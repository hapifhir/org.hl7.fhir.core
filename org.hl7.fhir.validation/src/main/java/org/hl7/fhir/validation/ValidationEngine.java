package org.hl7.fhir.validation;

import com.google.gson.JsonObject;
import org.hl7.fhir.convertors.*;
import org.hl7.fhir.convertors.loaders.BaseLoaderR5.NullLoaderKnowledgeProvider;
import org.hl7.fhir.convertors.loaders.*;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.context.IWorkerContext.PackageVersion;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.terminologies.ConceptMapEngine;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.IResourceValidator.*;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.structuremap.ITransformerServices;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.validation.BaseValidator.ValidationControl;
import org.hl7.fhir.validation.cli.model.ScanOutputItem;
import org.hl7.fhir.validation.cli.services.StandAloneValidatorFetcher.IPackageInstaller;
import org.hl7.fhir.validation.cli.utils.*;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/*
Copyright (c) 2011+, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
   endorse or promote products derived from this software without specific
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.

*/

/**
 * This is just a wrapper around the InstanceValidator class for convenient use
 * <p>
 * The following resource formats are supported: XML, JSON, Turtle
 * The following versions are supported: 1.0.2, 1.4.0, 3.0.2, 4.0.1, and current
 * <p>
 * Note: the validation engine is intended to be threadsafe
 * To Use:
 * <p>
 * 1/ Initialize
 * ValidationEngine validator = new ValidationEngine(src);
 * - this must be the packageId of the relevant core specification
 * for the version you want to validate against (e.g. hl7.fhir.r4.core)
 * <p>
 * validator.connectToTSServer(txServer);
 * - this is optional; in the absence of a terminology service, snomed, loinc etc will not be validated
 * <p>
 * validator.loadIg(src);
 * - call this any number of times for the Implementation Guide(s) of interest.
 * - See https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator for documentation about the src parameter (-ig parameter)
 * <p>
 * validator.loadQuestionnaire(src)
 * - url or filename of a questionnaire to load. Any loaded questionnaires will be used while validating
 * <p>
 * validator.setNative(doNative);
 * - whether to do xml/json/rdf schema validation as well
 * <p>
 * You only need to do this initialization once. You can validate as many times as you like
 * <p>
 * 2. validate
 * validator.validate(src, profiles);
 * - source (as stream, byte[]), or url or filename of a resource to validate.
 * Also validate against any profiles (as canonical URLS, equivalent to listing them in Resource.meta.profile)
 * <p>
 * if the source is provided as byte[] or stream, you need to provide a format too, though you can
 * leave that as null, and the validator will guess
 * <p>
 * 3. Or, instead of validating, transform (see documentation and use in Validator.java)
 *
 * @author Grahame Grieve
 */
public class ValidationEngine implements IValidatorResourceFetcher, IPackageInstaller {

  public class TransformSupportServices implements ITransformerServices {

    private List<Base> outputs;

    public TransformSupportServices(List<Base> outputs) {
      this.outputs = outputs;
    }

    @Override
    public void log(String message) {
      if (mapLog != null)
        mapLog.println(message);
      System.out.println(message);
    }

    @Override
    public Base createType(Object appInfo, String name) throws FHIRException {
      StructureDefinition sd = context.fetchResource(StructureDefinition.class, name);
      return Manager.build(context, sd);
    }

    @Override
    public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
      if (atRootofTransform)
        outputs.add(res);
      return res;
    }

    @Override
    public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
      ConceptMapEngine cme = new ConceptMapEngine(context);
      return cme.translate(source, conceptMapUrl);
    }

    @Override
    public Base resolveReference(Object appContext, String url) throws FHIRException {
      throw new FHIRException("resolveReference is not supported yet");
    }

    @Override
    public List<Base> performSearch(Object appContext, String url) throws FHIRException {
      throw new FHIRException("performSearch is not supported yet");
    }
  }

  private SimpleWorkerContext context;
  private Map<String, byte[]> binaries = new HashMap<String, byte[]>();
  private boolean doNative;
  private boolean noInvariantChecks;
  private boolean hintAboutNonMustSupport;
  private boolean anyExtensionsAllowed = false;
  private String version;
  private String language;
  private FilesystemPackageCacheManager pcm;
  private PrintWriter mapLog;
  private boolean debug;
  private IValidatorResourceFetcher fetcher;
  private boolean assumeValidRestReferences;
  private boolean noExtensibleBindingMessages;
  private boolean securityChecks;
  private boolean crumbTrails;
  private Locale locale;
  private List<ImplementationGuide> igs = new ArrayList<>();
  private boolean showTimes;
  private List<BundleValidationRule> bundleValidationRules = new ArrayList<>();
  private Map<String, ValidationControl> validationControl = new HashMap<>();
  private QuestionnaireMode questionnaireMode;

  public ValidationEngine() throws IOException {
    pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    context = SimpleWorkerContext.fromNothing();
    initContext(null);
  }

  public ValidationEngine(String src, String txsrvr, String txLog, FhirPublication version, boolean canRunWithoutTerminologyServer, String vString) throws FHIRException, IOException, URISyntaxException {
    pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    loadCoreDefinitions(src, false, null);
    context.setCanRunWithoutTerminology(canRunWithoutTerminologyServer);
    setTerminologyServer(txsrvr, txLog, version);
    this.version = vString;
  }

  public ValidationEngine(String src, String txsrvr, String txLog, FhirPublication version, String vString) throws FHIRException, IOException, URISyntaxException {
    pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    loadCoreDefinitions(src, false, null);
    setTerminologyServer(txsrvr, txLog, version);
    this.version = vString;
  }

  public ValidationEngine(String src, FhirPublication version, String vString, TimeTracker tt) throws FHIRException, IOException, URISyntaxException {
    pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    loadCoreDefinitions(src, false, tt);
    this.version = vString;
  }


  public ValidationEngine(String src) throws FHIRException, IOException {
    loadCoreDefinitions(src, false, null);
    pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
  }

  private void loadCoreDefinitions(String src, boolean recursive, TimeTracker tt) throws FHIRException, IOException {
    if (pcm == null) {
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    NpmPackage npm = pcm.loadPackage(src, null);
    if (npm != null) {
      version = npm.fhirVersion();
      context = SimpleWorkerContext.fromPackage(npm, loaderForVersion());
    } else {
      Map<String, byte[]> source = loadIgSource(src, recursive, true);
      if (version == null) {
        version = getVersionFromPack(source);
      }
      context = SimpleWorkerContext.fromDefinitions(source, loaderForVersion(), new PackageVersion(src));
      grabNatives(source, "http://hl7.org/fhir");
    }
    initContext(tt);
  }

  public void initContext(TimeTracker tt) throws IOException, FileNotFoundException {
    context.setCanNoTS(true);
    context.setCacheId(UUID.randomUUID().toString());
    context.setAllowLoadingDuplicates(true); // because of Forge
    context.setExpansionProfile(makeExpProfile());
    if (tt != null) {
      context.setClock(tt);
    }
    NpmPackage npmX = pcm.loadPackage("hl7.fhir.xver-extensions", "0.0.4");
    context.loadFromPackage(npmX, null);
  }

  private IContextResourceLoader loaderForVersion() {
    return loaderForVersion(version);
  }

  private IContextResourceLoader loaderForVersion(String version) {
    if (Utilities.noString(version))
      return null;
    if (version.startsWith("1.0"))
      return new R2ToR5Loader(new String[]{"Conformance", "StructureDefinition", "ValueSet", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProvider());
    if (version.startsWith("1.4"))
      return new R2016MayToR5Loader(new String[]{"Conformance", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProvider()); // special case
    if (version.startsWith("3.0"))
      return new R3ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProvider());
    if (version.startsWith("4.0"))
      return new R4ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProvider());
    if (version.startsWith("5.0"))
      return new R5ToR5Loader(new String[]{"CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire", "ConceptMap", "StructureMap", "NamingSystem"}, new NullLoaderKnowledgeProvider());
    return null;
  }

  private String getVersionFromPack(Map<String, byte[]> source) {
    if (source.containsKey("version.info")) {
      IniFile vi = new IniFile(new ByteArrayInputStream(removeBom(source.get("version.info"))));
      return vi.getStringProperty("FHIR", "version");
    } else {
      throw new Error("Missing version.info?");
    }
  }

  private byte[] removeBom(byte[] bs) {
    if (bs.length > 3 && bs[0] == -17 && bs[1] == -69 && bs[2] == -65)
      return Arrays.copyOfRange(bs, 3, bs.length);
    else
      return bs;
  }

  private Parameters makeExpProfile() {
    Parameters ep = new Parameters();
    ep.addParameter("profile-url", "http://hl7.org/fhir/ExpansionProfile/dc8fd4bc-091a-424a-8a3b-6198ef146891"); // change this to blow the cache
    // all defaults....
    return ep;
  }

  /**
   * explore should be true if we're trying to load an -ig parameter, and false if we're loading source
   *
   * @throws IOException
   **/

  private Map<String, byte[]> loadIgSource(String src, boolean recursive, boolean explore) throws FHIRException, IOException {
    // src can be one of the following:
    // - a canonical url for an ig - this will be converted to a package id and loaded into the cache
    // - a package id for an ig - this will be loaded into the cache
    // - a direct reference to a package ("package.tgz") - this will be extracted by the cache manager, but not put in the cache
    // - a folder containing resources - these will be loaded directly
    if (Common.isNetworkPath(src)) {
      String v = null;
      if (src.contains("|")) {
        v = src.substring(src.indexOf("|") + 1);
        src = src.substring(0, src.indexOf("|"));
      }
      String pid = explore ? pcm.getPackageId(src) : null;
      if (!Utilities.noString(pid))
        return fetchByPackage(pid + (v == null ? "" : "#" + v));
      else
        return fetchFromUrl(src + (v == null ? "" : "|" + v), explore);
    }

    File f = new File(Utilities.path(src));
    if (f.exists()) {
      if (f.isDirectory() && new File(Utilities.path(src, "package.tgz")).exists())
        return loadPackage(new FileInputStream(Utilities.path(src, "package.tgz")), Utilities.path(src, "package.tgz"));
      if (f.isDirectory() && new File(Utilities.path(src, "igpack.zip")).exists())
        return readZip(new FileInputStream(Utilities.path(src, "igpack.zip")));
      if (f.isDirectory() && new File(Utilities.path(src, "validator.pack")).exists())
        return readZip(new FileInputStream(Utilities.path(src, "validator.pack")));
      if (f.isDirectory())
        return scanDirectory(f, recursive);
      if (src.endsWith(".tgz"))
        return loadPackage(new FileInputStream(src), src);
      if (src.endsWith(".pack"))
        return readZip(new FileInputStream(src));
      if (src.endsWith("igpack.zip"))
        return readZip(new FileInputStream(src));
      FhirFormat fmt = checkIsResource(src);
      if (fmt != null) {
        Map<String, byte[]> res = new HashMap<String, byte[]>();
        res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), TextFile.fileToBytesNCS(src));
        return res;
      }
    } else if ((src.matches(FilesystemPackageCacheManager.PACKAGE_REGEX) || src.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX)) && !src.endsWith(".zip") && !src.endsWith(".tgz")) {
      return fetchByPackage(src);
    }
    throw new FHIRException("Unable to find/resolve/read " + (explore ? "-ig " : "") + src);
  }

  private Map<String, byte[]> loadIgSourceForVersion(String src, boolean recursive, boolean explore, VersionSourceInformation versions) throws FHIRException, IOException {
    if (Common.isNetworkPath(src)) {
      String v = null;
      if (src.contains("|")) {
        v = src.substring(src.indexOf("|") + 1);
        src = src.substring(0, src.indexOf("|"));
      }
      String pid = pcm.getPackageId(src);
      if (!Utilities.noString(pid)) {
        versions.see(fetchVersionByPackage(pid + (v == null ? "" : "#" + v)), "Package " + src);
        return null;
      } else {
        return fetchVersionFromUrl(src + (v == null ? "" : "|" + v), explore, versions);
      }
    }

    File f = new File(Utilities.path(src));
    if (f.exists()) {
      if (f.isDirectory() && new File(Utilities.path(src, "package.tgz")).exists()) {
        versions.see(loadPackageForVersion(new FileInputStream(Utilities.path(src, "package.tgz")), Utilities.path(src, "package.tgz")), "Package " + src);
        return null;
      }
      if (f.isDirectory() && new File(Utilities.path(src, "igpack.zip")).exists())
        return readZip(new FileInputStream(Utilities.path(src, "igpack.zip")));
      if (f.isDirectory() && new File(Utilities.path(src, "validator.pack")).exists())
        return readZip(new FileInputStream(Utilities.path(src, "validator.pack")));
      if (f.isDirectory())
        return scanDirectory(f, recursive);
      if (src.endsWith(".tgz")) {
        versions.see(loadPackageForVersion(new FileInputStream(src), src), "Package " + src);
        return null;
      }
      if (src.endsWith(".pack"))
        return readZip(new FileInputStream(src));
      if (src.endsWith("igpack.zip"))
        return readZip(new FileInputStream(src));
      FhirFormat fmt = checkIsResource(src);
      if (fmt != null) {
        Map<String, byte[]> res = new HashMap<String, byte[]>();
        res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), TextFile.fileToBytesNCS(src));
        return res;
      }
    } else if ((src.matches(FilesystemPackageCacheManager.PACKAGE_REGEX) || src.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX)) && !src.endsWith(".zip") && !src.endsWith(".tgz")) {
      versions.see(fetchVersionByPackage(src), "Package " + src);
      return null;
    }
    throw new FHIRException("Unable to find/resolve/read -ig " + src);
  }


  private Map<String, byte[]> fetchFromUrl(String src, boolean explore) throws FHIRException, IOException {
    if (src.endsWith(".tgz"))
      return loadPackage(fetchFromUrlSpecific(src, false), src);
    if (src.endsWith(".pack"))
      return readZip(fetchFromUrlSpecific(src, false));
    if (src.endsWith("igpack.zip"))
      return readZip(fetchFromUrlSpecific(src, false));

    InputStream stream = null;
    if (explore) {
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "package.tgz"), true);
      if (stream != null)
        return loadPackage(stream, Utilities.pathURL(src, "package.tgz"));
      // todo: these options are deprecated - remove once all IGs have been rebuilt post R4 technical correction
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "igpack.zip"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      //// -----
    }

    // ok, having tried all that... now we'll just try to access it directly
    byte[] cnt;
    List<String> errors = new ArrayList<>();
    if (stream != null) {
      cnt = TextFile.streamToBytes(stream);
    } else {
      cnt = fetchFromUrlSpecific(src, "application/json", true, errors);
      if (cnt == null) {
        cnt = fetchFromUrlSpecific(src, "application/xml", true, errors);
      }
    }
    if (cnt == null) {
      throw new FHIRException("Unable to fetch content from " + src + " (" + errors.toString() + ")");

    }
    FhirFormat fmt = checkFormat(cnt, src);
    if (fmt != null) {
      Map<String, byte[]> res = new HashMap<String, byte[]>();
      res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), cnt);
      return res;
    }
    throw new FHIRException("Unable to read content from " + src + ": cannot determine format");
  }

  private Map<String, byte[]> fetchVersionFromUrl(String src, boolean explore, VersionSourceInformation versions) throws FHIRException, IOException {
    if (src.endsWith(".tgz")) {
      versions.see(loadPackageForVersion(fetchFromUrlSpecific(src, false), src), "From Package " + src);
      return null;
    }
    if (src.endsWith(".pack"))
      return readZip(fetchFromUrlSpecific(src, false));
    if (src.endsWith("igpack.zip"))
      return readZip(fetchFromUrlSpecific(src, false));

    InputStream stream = null;
    if (explore) {
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "package.tgz"), true);
      if (stream != null) {
        versions.see(loadPackageForVersion(stream, Utilities.pathURL(src, "package.tgz")), "From Package at " + src);
        return null;
      }
      // todo: these options are deprecated - remove once all IGs have been rebuilt post R4 technical correction
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "igpack.zip"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      //// -----
    }

    // ok, having tried all that... now we'll just try to access it directly
    byte[] cnt;
    if (stream == null)
      cnt = fetchFromUrlSpecific(src, "application/json", true, null);
    else
      cnt = TextFile.streamToBytes(stream);

    FhirFormat fmt = checkIsResource(cnt, src);
    if (fmt != null) {
      Map<String, byte[]> res = new HashMap<String, byte[]>();
      res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), cnt);
      return res;
    }
    String fn = Utilities.path("[tmp]", "fetch-resource-error-content.bin");
    TextFile.bytesToFile(cnt, fn);
    System.out.println("Error Fetching " + src);
    System.out.println("Some content was found, saved to " + fn);
    System.out.println("1st 100 bytes = " + presentForDebugging(cnt));
    throw new FHIRException("Unable to find/resolve/read " + (explore ? "-ig " : "") + src);
  }

  private String presentForDebugging(byte[] cnt) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < Integer.min(cnt.length, 50); i++) {
      b.append(Integer.toHexString(cnt[i]));
    }
    return b.toString();
  }

  private InputStream fetchFromUrlSpecific(String source, boolean optional) throws FHIRException, IOException {
    try {
      URL url = new URL(source + "?nocache=" + System.currentTimeMillis());
      URLConnection c = url.openConnection();
      return c.getInputStream();
    } catch (IOException e) {
      if (optional)
        return null;
      else
        throw e;
    }
  }

  private byte[] fetchFromUrlSpecific(String source, String contentType, boolean optional, List<String> errors) throws FHIRException, IOException {
    try {
      try {
        // try with cache-busting option and then try withhout in case the server doesn't support that
        URL url = new URL(source + "?nocache=" + System.currentTimeMillis());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Accept", contentType);
        return TextFile.streamToBytes(conn.getInputStream());
      } catch (Exception e) {
        URL url = new URL(source);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Accept", contentType);
        return TextFile.streamToBytes(conn.getInputStream());
      }
    } catch (IOException e) {
      if (errors != null) {
        errors.add("Error accessing " + source + ": " + e.getMessage());
      }
      if (optional)
        return null;
      else
        throw e;
    }
  }

  private Map<String, byte[]> scanDirectory(File f, boolean recursive) throws FileNotFoundException, IOException {
    Map<String, byte[]> res = new HashMap<>();
    for (File ff : f.listFiles()) {
      if (ff.isDirectory() && recursive) {
        res.putAll(scanDirectory(ff, true));
      } else if (!isIgnoreFile(ff)) {
        FhirFormat fmt = checkIsResource(ff.getAbsolutePath());
        if (fmt != null) {
          res.put(Utilities.changeFileExt(ff.getName(), "." + fmt.getExtension()), TextFile.fileToBytes(ff.getAbsolutePath()));
        }
      }
    }
    return res;
  }

  private boolean isIgnoreFile(File ff) {
    if (ff.getName().startsWith(".") || ff.getAbsolutePath().contains(".git")) {
      return true;
    }
    return Utilities.existsInList(Utilities.getFileExtension(ff.getName()).toLowerCase(), "md", "css", "js", "png", "gif", "jpg", "html", "tgz", "pack", "zip");
  }

  private Map<String, byte[]> loadPackage(InputStream stream, String name) throws FHIRException, IOException {
    return loadPackage(NpmPackage.fromPackage(stream));
  }

  private String loadPackageForVersion(InputStream stream, String name) throws FHIRException, IOException {
    return NpmPackage.fromPackage(stream).fhirVersion();
  }

  public Map<String, byte[]> loadPackage(NpmPackage pi) throws FHIRException, IOException {
    context.getLoadedPackages().add(pi.name() + "#" + pi.version());
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (String s : pi.dependencies()) {
      if (s.endsWith(".x") && s.length() > 2) {
        String packageMajorMinor = s.substring(0, s.length() - 2);
        boolean found = false;
        for (int i = 0; i < context.getLoadedPackages().size() && !found; ++i) {
          String loadedPackage = context.getLoadedPackages().get(i);
          if (loadedPackage.startsWith(packageMajorMinor)) {
            found = true;
          }
        }
        if (found)
          continue;
      }
      if (!context.getLoadedPackages().contains(s)) {
        if (!VersionUtilities.isCorePackage(s)) {
          System.out.println("+  .. load IG from " + s);
          res.putAll(fetchByPackage(s));
        }
      }
    }

    for (String s : pi.listResources("CodeSystem", "ConceptMap", "ImplementationGuide", "CapabilityStatement", "SearchParameter", "Conformance", "StructureMap", "ValueSet", "StructureDefinition")) {
      res.put(s, TextFile.streamToBytes(pi.load("package", s)));
    }
    String ini = "[FHIR]\r\nversion=" + pi.fhirVersion() + "\r\n";
    res.put("version.info", ini.getBytes());
    return res;
  }

  private Map<String, byte[]> readZip(InputStream stream) throws IOException {
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    ZipInputStream zip = new ZipInputStream(stream);
    ZipEntry ze;
    while ((ze = zip.getNextEntry()) != null) {
      String name = ze.getName();
      InputStream in = zip;
      ByteArrayOutputStream b = new ByteArrayOutputStream();
      int n;
      byte[] buf = new byte[1024];
      while ((n = in.read(buf, 0, 1024)) > -1) {
        b.write(buf, 0, n);
      }
      res.put(name, b.toByteArray());
      zip.closeEntry();
    }
    zip.close();
    return res;
  }

  public void log(String message) {
    System.out.println(message);
  }

  private Map<String, byte[]> fetchByPackage(String src) throws FHIRException, IOException {
    String id = src;
    String version = null;
    if (src.contains("#")) {
      id = src.substring(0, src.indexOf("#"));
      version = src.substring(src.indexOf("#") + 1);
    }
    if (pcm == null) {
      log("Creating Package manager?");
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    if (version == null) {
      version = pcm.getLatestVersion(id);
    }
    NpmPackage pi = null;
    if (version == null) {
      pi = pcm.loadPackageFromCacheOnly(id);
      if (pi != null)
        log("   ... Using version " + pi.version());
    } else
      pi = pcm.loadPackageFromCacheOnly(id, version);
    if (pi == null) {
      return resolvePackage(id, version);
    } else
      return loadPackage(pi);
  }

  private String fetchVersionByPackage(String src) throws FHIRException, IOException {
    String id = src;
    String version = null;
    if (src.contains("#")) {
      id = src.substring(0, src.indexOf("#"));
      version = src.substring(src.indexOf("#") + 1);
    }
    if (pcm == null) {
      log("Creating Package manager?");
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    if (version == null) {
      version = pcm.getLatestVersion(id);
    }
    NpmPackage pi = null;
    if (version == null) {
      pi = pcm.loadPackageFromCacheOnly(id);
      if (pi != null)
        log("   ... Using version " + pi.version());
    } else
      pi = pcm.loadPackageFromCacheOnly(id, version);
    if (pi == null) {
      return resolvePackageForVersion(id, version);
    } else {
      return pi.fhirVersion();
    }
  }

  private Map<String, byte[]> resolvePackage(String id, String v) throws FHIRException, IOException {
    NpmPackage pi = pcm.loadPackage(id, v);
    if (pi != null && v == null)
      log("   ... Using version " + pi.version());
    return loadPackage(pi);
  }

  private String resolvePackageForVersion(String id, String v) throws FHIRException, IOException {
    NpmPackage pi = pcm.loadPackage(id, v);
    return pi.fhirVersion();
  }

  public SimpleWorkerContext getContext() {
    return context;
  }

  private FhirFormat checkFormat(byte[] cnt, String filename) {
    System.out.println("   ..Detect format for " + filename);
    try {
      JsonTrackingParser.parseJson(cnt);
      return FhirFormat.JSON;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not JSON: " + e.getMessage());
      }
    }
    try {
      parseXml(cnt);
      return FhirFormat.XML;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not XML: " + e.getMessage());
      }
    }
    try {
      new Turtle().parse(TextFile.bytesToString(cnt));
      return FhirFormat.TURTLE;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not Turtle: " + e.getMessage());
      }
    }
    try {
      new StructureMapUtilities(context, null, null).parse(TextFile.bytesToString(cnt), null);
      return FhirFormat.TEXT;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not Text: " + e.getMessage());
      }
    }
    if (debug)
      System.out.println("     .. not a resource: " + filename);
    return null;
  }


  private FhirFormat checkIsResource(byte[] cnt, String filename) {
    System.out.println("   ..Detect format for " + filename);
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), FhirFormat.JSON);
      return FhirFormat.JSON;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not JSON: " + e.getMessage());
      }
    }
    try {
      parseXml(cnt);
      return FhirFormat.XML;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not XML: " + e.getMessage());
      }
    }
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), FhirFormat.TURTLE);
      return FhirFormat.TURTLE;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not Turtle: " + e.getMessage());
      }
    }
    try {
      new StructureMapUtilities(context, null, null).parse(TextFile.bytesToString(cnt), null);
      return FhirFormat.TEXT;
    } catch (Exception e) {
      if (debug) {
        System.out.println("Not Text: " + e.getMessage());
      }
    }
    if (debug)
      System.out.println("     .. not a resource: " + filename);
    return null;
  }

  private Document parseXml(byte[] cnt) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // xxe protection
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    factory.setXIncludeAware(false);
    factory.setExpandEntityReferences(false);
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(new ByteArrayInputStream(cnt));
  }

  private FhirFormat checkIsResource(String path) throws IOException {
    String ext = Utilities.getFileExtension(path);
    if (Utilities.existsInList(ext, "xml"))
      return FhirFormat.XML;
    if (Utilities.existsInList(ext, "json"))
      return FhirFormat.JSON;
    if (Utilities.existsInList(ext, "ttl"))
      return FhirFormat.TURTLE;
    if (Utilities.existsInList(ext, "map"))
      return FhirFormat.TEXT;
    if (Utilities.existsInList(ext, "txt"))
      return FhirFormat.TEXT;

    return checkIsResource(TextFile.fileToBytes(path), path);
  }

  public String connectToTSServer(String url, String log, FhirPublication version) throws URISyntaxException, FHIRException {
    context.setTlogging(false);
    if (url == null) {
      context.setCanRunWithoutTerminology(true);
      return "n/a: No Terminology Server";
    } else {
      try {
        return context.connectToTSServer(TerminologyClientFactory.makeClient(url, version), log);
      } catch (Exception e) {
        if (context.isCanRunWithoutTerminology()) {
          return "n/a: Running without Terminology Server (error: " + e.getMessage() + ")";
        } else
          throw e;
      }
    }
  }

  public void loadProfile(String src) throws FHIRException, IOException {
    if (context.hasResource(StructureDefinition.class, src))
      return;
    if (context.hasResource(ImplementationGuide.class, src))
      return;

    byte[] source = ProfileLoader.loadProfileSource(src);
    FhirFormat fmt = FormatUtilities.determineFormat(source);
    Resource r = FormatUtilities.makeParser(fmt).parse(source);
    context.cacheResource(r);
  }

  public void scanForIgVersion(String src, boolean recursive, VersionSourceInformation versions) throws IOException, FHIRException, Exception {
    Map<String, byte[]> source = loadIgSourceForVersion(src, recursive, true, versions);
    if (source != null && source.containsKey("version.info"))
      versions.see(readInfoVersion(source.get("version.info")), "version.info in " + src);
  }

  public void loadIg(String src, boolean recursive) throws IOException, FHIRException {
    NpmPackage npm = src.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX_OPT) && !new File(src).exists() ? pcm.loadPackage(src, null) : null;
    if (npm != null) {
      for (String s : npm.dependencies()) {
        if (!context.getLoadedPackages().contains(s)) {
          if (!VersionUtilities.isCorePackage(s)) {
            loadIg(s, false);
          }
        }
      }
      System.out.print("  Load " + src);
      if (!src.contains("#")) {
        System.out.print("#" + npm.version());
      }
      int count = context.loadFromPackage(npm, loaderForVersion(npm.fhirVersion()));
      System.out.println(" - " + count + " resources (" + context.clock().milestone() + ")");
    } else {
      System.out.print("  Load " + src);
      String canonical = null;
      int count = 0;
      Map<String, byte[]> source = loadIgSource(src, recursive, true);
      String version = Constants.VERSION;
      if (this.version != null) {
        version = this.version;
      }
      if (source.containsKey("version.info")) {
        version = readInfoVersion(source.get("version.info"));
      }
      for (Entry<String, byte[]> t : source.entrySet()) {
        String fn = t.getKey();
        if (!exemptFile(fn)) {
          Resource r = loadFileWithErrorChecking(version, t, fn);
          if (r != null) {
            count++;
            context.cacheResource(r);
            if (r instanceof ImplementationGuide) {
              canonical = ((ImplementationGuide) r).getUrl();
              igs.add((ImplementationGuide) r);
              if (canonical.contains("/ImplementationGuide/")) {
                Resource r2 = r.copy();
                ((ImplementationGuide) r2).setUrl(canonical.substring(0, canonical.indexOf("/ImplementationGuide/")));
                context.cacheResource(r2);
              }
            }
          }
        }
      }
      if (canonical != null) {
        grabNatives(source, canonical);
      }
      System.out.println(" - " + count + " resources (" + context.clock().milestone() + ")");
    }
  }

  public Resource loadFileWithErrorChecking(String version, Entry<String, byte[]> t, String fn) {
    if (debug)
      System.out.print("* load file: " + fn);
    Resource r = null;
    try {
      r = loadResourceByVersion(version, t.getValue(), fn);
      if (debug)
        System.out.println(" .. success");
    } catch (Exception e) {
      if (!debug) {
        System.out.print("* load file: " + fn);
      }
      System.out.println(" - ignored due to error: " + (e.getMessage() == null ? " (null - NPE)" : e.getMessage()));
      if (debug || ((e.getMessage() != null && e.getMessage().contains("cannot be cast")))) {
        e.printStackTrace();
      }
    }
    return r;
  }

  public Resource loadResourceByVersion(String version, byte[] content, String fn) throws IOException, FHIRException {
    Resource r;
    if (version.startsWith("3.0")) {
      org.hl7.fhir.dstu3.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu3.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        res = new org.hl7.fhir.dstu3.utils.StructureMapUtilities(null).parse(new String(content));
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertor_30_50.convertResource(res, false);
    } else if (version.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.r4.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.r4.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        res = new org.hl7.fhir.r4.utils.StructureMapUtilities(null).parse(new String(content), fn);
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertor_40_50.convertResource(res);
    } else if (version.startsWith("1.4")) {
      org.hl7.fhir.dstu2016may.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertor_14_50.convertResource(res);
    } else if (version.startsWith("1.0")) {
      org.hl7.fhir.dstu2.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else
        throw new FHIRException("Unsupported format for " + fn);
      VersionConvertorAdvisor50 advisor = new org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor5();
      r = VersionConvertor_10_50.convertResource(res, advisor);
    } else if (version.equals(Constants.VERSION) || "current".equals(version)) {
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        r = new XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        r = new JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt"))
        r = new StructureMapUtilities(context, null, null).parse(TextFile.bytesToString(content), fn);
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        r = new StructureMapUtilities(null).parse(new String(content), fn);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else
      throw new FHIRException("Unsupported version " + version);
    return r;
  }

  private boolean exemptFile(String fn) {
    return Utilities.existsInList(fn, "spec.internals", "version.info", "schematron.zip", "package.json");
  }

  private String readInfoVersion(byte[] bs) throws IOException {
    String is = TextFile.bytesToString(bs);
    is = is.trim();
    IniFile ini = new IniFile(new ByteArrayInputStream(TextFile.stringToBytes(is, false)));
    return ini.getStringProperty("FHIR", "version");
  }

  private void grabNatives(Map<String, byte[]> source, String prefix) {
    for (Entry<String, byte[]> e : source.entrySet()) {
      if (e.getKey().endsWith(".zip"))
        binaries.put(prefix + "#" + e.getKey(), e.getValue());
    }
  }

  public Content loadContent(String source, String opName, boolean asIg) throws FHIRException, IOException {
    Map<String, byte[]> s = loadIgSource(source, false, asIg);
    Content res = new Content();
    if (s.size() != 1)
      throw new FHIRException("Unable to find resource " + source + " to " + opName);
    for (Entry<String, byte[]> t : s.entrySet()) {
      res.focus = t.getValue();
      if (t.getKey().endsWith(".json"))
        res.cntType = FhirFormat.JSON;
      else if (t.getKey().endsWith(".xml"))
        res.cntType = FhirFormat.XML;
      else if (t.getKey().endsWith(".ttl"))
        res.cntType = FhirFormat.TURTLE;
      else if (t.getKey().endsWith(".txt") || t.getKey().endsWith(".map"))
        res.cntType = FhirFormat.TEXT;
      else
        throw new FHIRException("Todo: Determining resource type is not yet done");
    }
    return res;
  }

  // testing entry point
  public OperationOutcome validate(FhirFormat format, InputStream stream, List<String> profiles) throws FHIRException, IOException, EOperationOutcome {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    InstanceValidator validator = getValidator();
    validator.validate(null, messages, stream, format, asSdList(profiles));
    return messagesToOutcome(messages);
  }

  public List<StructureDefinition> asSdList(List<String> profiles) throws Error {
    List<StructureDefinition> list = new ArrayList<>();
    if (profiles != null) {
      for (String p : profiles) {
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, p);
        if (sd == null) {
          throw new Error("Unable to resolve profile " + p);
        }
        list.add(sd);
      }
    }
    return list;
  }

  public OperationOutcome validate(String source, List<String> profiles) throws FHIRException, IOException {
    List<String> l = new ArrayList<String>();
    l.add(source);
    return (OperationOutcome) validate(l, profiles, null);
  }

  public List<ScanOutputItem> validateScan(List<String> sources, Set<String> guides) throws FHIRException, IOException, EOperationOutcome {
    List<String> refs = new ArrayList<String>();
    parseSources(sources, refs);

    List<ScanOutputItem> res = new ArrayList();
    InstanceValidator validator = getValidator();

    for (String ref : refs) {
      Content cnt = loadContent(ref, "validate", false);
      List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
      Element e = null;
      try {
        System.out.println("Validate " + ref);
        messages.clear();
        e = validator.validate(null, messages, new ByteArrayInputStream(cnt.focus), cnt.cntType);
        res.add(new ScanOutputItem(ref, null, null, messagesToOutcome(messages)));
      } catch (Exception ex) {
        res.add(new ScanOutputItem(ref, null, null, exceptionToOutcome(ex)));
      }
      if (e != null) {
        String rt = e.fhirType();
        for (String u : guides) {
          ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, u);
          System.out.println("Check Guide " + ig.getUrl());
          String canonical = ig.getUrl().contains("/Impl") ? ig.getUrl().substring(0, ig.getUrl().indexOf("/Impl")) : ig.getUrl();
          String url = getGlobal(ig, rt);
          if (url != null) {
            try {
              System.out.println("Validate " + ref + " against " + ig.getUrl());
              messages.clear();
              validator.validate(null, messages, new ByteArrayInputStream(cnt.focus), cnt.cntType, url);
              res.add(new ScanOutputItem(ref, ig, null, messagesToOutcome(messages)));
            } catch (Exception ex) {
              res.add(new ScanOutputItem(ref, ig, null, exceptionToOutcome(ex)));
            }
          }
          Set<String> done = new HashSet<>();
          for (StructureDefinition sd : context.allStructures()) {
            if (!done.contains(sd.getUrl())) {
              done.add(sd.getUrl());
              if (sd.getUrl().startsWith(canonical) && rt.equals(sd.getType())) {
                try {
                  System.out.println("Validate " + ref + " against " + sd.getUrl());
                  messages.clear();
                  validator.validate(null, messages, new ByteArrayInputStream(cnt.focus), cnt.cntType, asSdList(sd));
                  res.add(new ScanOutputItem(ref, ig, sd, messagesToOutcome(messages)));
                } catch (Exception ex) {
                  res.add(new ScanOutputItem(ref, ig, sd, exceptionToOutcome(ex)));
                }
              }
            }
          }
        }
      }
    }
    return res;
  }

  private List<StructureDefinition> asSdList(StructureDefinition sd) {
    List<StructureDefinition> res = new ArrayList<StructureDefinition>();
    res.add(sd);
    return res;
  }

  private String getGlobal(ImplementationGuide ig, String rt) {
    for (ImplementationGuideGlobalComponent igg : ig.getGlobal()) {
      if (rt.equals(igg.getType()))
        return igg.getProfile();
    }
    return null;
  }

  public void scanForVersions(List<String> sources, VersionSourceInformation versions) throws FHIRException, IOException {
    List<String> refs = new ArrayList<String>();
    parseSources(sources, refs);
    for (String ref : refs) {
      Content cnt = loadContent(ref, "validate", false);
      String s = TextFile.bytesToString(cnt.focus);
      if (s.contains("http://hl7.org/fhir/3.0")) {
        versions.see("3.0", "Profile in " + ref);
      }
      if (s.contains("http://hl7.org/fhir/1.0")) {
        versions.see("1.0", "Profile in " + ref);
      }
      if (s.contains("http://hl7.org/fhir/4.0")) {
        versions.see("4.0", "Profile in " + ref);
      }
      if (s.contains("http://hl7.org/fhir/1.4")) {
        versions.see("1.4", "Profile in " + ref);
      }
      try {
        if (s.startsWith("{")) {
          JsonObject json = JsonTrackingParser.parse(s, null);
          if (json.has("fhirVersion")) {
            versions.see(VersionUtilities.getMajMin(JSONUtil.str(json, "fhirVersion")), "fhirVersion in " + ref);
          }
        } else {
          Document doc = parseXml(cnt.focus);
          String v = XMLUtil.getNamedChildValue(doc.getDocumentElement(), "fhirVersion");
          if (v != null) {
            versions.see(VersionUtilities.getMajMin(v), "fhirVersion in " + ref);
          }
        }
      } catch (Exception e) {
        // nothing
      }
    }
  }

  public Resource validate(List<String> sources, List<String> profiles, List<ValidationRecord> record) throws FHIRException, IOException {
    if (profiles.size() > 0) {
      System.out.println("  Profiles: " + profiles);
    }
    List<String> refs = new ArrayList<String>();
    boolean asBundle = parseSources(sources, refs);
    Bundle results = new Bundle();
    results.setType(Bundle.BundleType.COLLECTION);
    for (String ref : refs) {
      TimeTracker.Session tts = context.clock().start("validation");
      context.clock().milestone();
      System.out.print("  Validate " + ref);
      Content cnt = loadContent(ref, "validate", false);
      try {
        OperationOutcome outcome = validate(ref, cnt.focus, cnt.cntType, profiles, record);
        ToolingExtensions.addStringExtension(outcome, ToolingExtensions.EXT_OO_FILE, ref);
        System.out.println(" " + context.clock().milestone());
        results.addEntry().setResource(outcome);
        tts.end();
      } catch (Exception e) {
        System.out.println("Validation Infrastructure fail validating " + ref + ": " + e.getMessage());
        tts.end();
        throw new FHIRException(e);
      }
    }
    if (asBundle)
      return results;
    else
      return results.getEntryFirstRep().getResource();
  }

  /**
   * Iterates through the list of passed in sources, extracting all references and populated them in the passed in list.
   *
   * @return {@link Boolean#TRUE} if more than one reference is found.
   */
  public boolean parseSources(List<String> sources, List<String> refs) throws IOException {
    boolean multipleRefsFound = sources.size() > 1;
    for (String source : sources) {
      multipleRefsFound |= extractReferences(source, refs);
    }
    return multipleRefsFound;
  }

  /**
   * Parses passed in resource path, adding any found references to the passed in list.
   *
   * @return {@link Boolean#TRUE} if more than one reference is found.
   */
  private boolean extractReferences(String name, List<String> refs) throws IOException {
    if (Common.isNetworkPath(name)) {
      refs.add(name);
    } else if (Common.isWildcardPath(name)) {
      AsteriskFilter filter = new AsteriskFilter(name);
      File[] files = new File(filter.getDir()).listFiles(filter);
      for (File file : files) {
        refs.add(file.getPath());
      }
    } else {
      File file = new File(name);
      if (!file.exists()) {
        if (System.console() != null) {
          System.console().printf(context.formatMessage(I18nConstants.BAD_FILE_PATH_ERROR, name));
        } else {
          System.out.println(context.formatMessage(I18nConstants.BAD_FILE_PATH_ERROR, name));
        }
        throw new IOException("File " + name + " does not exist");
      }

      if (file.isFile()) {
        refs.add(name);
      } else {
        for (int i = 0; i < file.listFiles().length; i++) {
          File[] fileList = file.listFiles();
          if (fileList[i].isFile())
            refs.add(fileList[i].getPath());
        }
      }
    }
    return refs.size() > 1;
  }

  public OperationOutcome validate(byte[] source, FhirFormat cntType, List<String> profiles, List<ValidationMessage> messages) throws FHIRException, IOException, EOperationOutcome {
    InstanceValidator validator = getValidator();

    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return messagesToOutcome(messages);
  }


  public OperationOutcome validate(String location, byte[] source, FhirFormat cntType, List<String> profiles, List<ValidationRecord> record) throws FHIRException, IOException, EOperationOutcome, SAXException {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      SchemaValidator.validateSchema(location, cntType, messages);
    }
    InstanceValidator validator = getValidator();
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    if (showTimes) {
      System.out.println(location + ": " + validator.reportTimes());
    }
    if (record != null) {
      record.add(new ValidationRecord(location, messages));
    }
    return messagesToOutcome(messages);
  }

  public OperationOutcome validate(String location, byte[] source, FhirFormat cntType, List<String> profiles, IdStatus resourceIdRule, boolean anyExtensionsAllowed, BestPracticeWarningLevel bpWarnings, CheckDisplayOption displayOption) throws FHIRException, IOException, EOperationOutcome, SAXException {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      SchemaValidator.validateSchema(location, cntType, messages);
    }
    InstanceValidator validator = getValidator();
    validator.setResourceIdRule(resourceIdRule);
    validator.setBestPracticeWarningLevel(bpWarnings);
    validator.setCheckDisplay(displayOption);
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return messagesToOutcome(messages);
  }

  private List<ValidationMessage> filterMessages(List<ValidationMessage> messages) {
    List<ValidationMessage> filteredValidation = new ArrayList<ValidationMessage>();
    for (ValidationMessage e : messages) {
      if (!filteredValidation.contains(e))
        filteredValidation.add(e);
    }
    filteredValidation.sort(null);
    return filteredValidation;
  }

  private OperationOutcome exceptionToOutcome(Exception ex) throws IOException, FHIRException, EOperationOutcome {
    OperationOutcome op = new OperationOutcome();
    op.addIssue().setCode(org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXCEPTION).setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL).getDetails().setText(ex.getMessage());
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
    RendererFactory.factory(op, rc).render(op);
    return op;
  }

  private OperationOutcome messagesToOutcome(List<ValidationMessage> messages) throws IOException, FHIRException, EOperationOutcome {
    OperationOutcome op = new OperationOutcome();
    for (ValidationMessage vm : filterMessages(messages)) {
      FHIRPathEngine fpe = new FHIRPathEngine(context);
      try {
        fpe.parse(vm.getLocation());
      } catch (Exception e) {
        System.out.println("Internal error in location for message: '" + e.getMessage() + "', loc = '" + vm.getLocation() + "', err = '" + vm.getMessage() + "'");
      }
      op.getIssue().add(OperationOutcomeUtilities.convertToIssue(vm, op));
    }
    if (!op.hasIssue()) {
      op.addIssue().setSeverity(OperationOutcome.IssueSeverity.INFORMATION).setCode(OperationOutcome.IssueType.INFORMATIONAL).getDetails().setText(context.formatMessage(I18nConstants.ALL_OK));
    }
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
    RendererFactory.factory(op, rc).render(op);
    return op;
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(String source, String map) throws FHIRException, IOException {
    Content cnt = loadContent(source, "validate", false);
    return transform(cnt.focus, cnt.cntType, map);
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(byte[] source, FhirFormat cntType, String mapUri) throws FHIRException, IOException {
    List<Base> outputs = new ArrayList<Base>();

    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs));
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context, new ByteArrayInputStream(source), cntType);
    StructureMap map = context.getTransform(mapUri);
    if (map == null)
      throw new Error("Unable to find map " + mapUri + " (Known Maps = " + context.listMapUrls() + ")");

    org.hl7.fhir.r5.elementmodel.Element resource = getTargetResourceFromStructureMap(map);
    scu.transform(null, src, map, resource);
    return resource;
  }

  private org.hl7.fhir.r5.elementmodel.Element getTargetResourceFromStructureMap(StructureMap map) {
    String targetTypeUrl = null;
    for (StructureMap.StructureMapStructureComponent component : map.getStructure()) {
      if (component.getMode() == StructureMap.StructureMapModelMode.TARGET) {
        targetTypeUrl = component.getUrl();
        break;
      }
    }

    if (targetTypeUrl == null)
      throw new FHIRException("Unable to determine resource URL for target type");

    StructureDefinition structureDefinition = null;
    for (StructureDefinition sd : this.context.getStructures()) {
      if (sd.getUrl().equalsIgnoreCase(targetTypeUrl)) {
        structureDefinition = sd;
        break;
      }
    }

    if (structureDefinition == null)
      throw new FHIRException("Unable to find StructureDefinition for target type ('" + targetTypeUrl + "')");

    return Manager.build(getContext(), structureDefinition);
  }

  public DomainResource generate(String source, String version) throws FHIRException, IOException, EOperationOutcome {
    Content cnt = loadContent(source, "validate", false);
    Resource res = loadResourceByVersion(version, cnt.focus, source);
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
    RendererFactory.factory(res, rc).render((DomainResource) res);
    return (DomainResource) res;
  }

  public void convert(String source, String output) throws FHIRException, IOException {
    Content cnt = loadContent(source, "validate", false);
    Element e = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);
    Manager.compose(context, e, new FileOutputStream(output), (output.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML), OutputStyle.PRETTY, null);
  }

  public String evaluateFhirPath(String source, String expression) throws FHIRException, IOException {
    Content cnt = loadContent(source, "validate", false);
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    Element e = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);
    return fpe.evaluateToString(e, expression);
  }

  public StructureDefinition snapshot(String source, String version) throws FHIRException, IOException {
    Content cnt = loadContent(source, "validate", false);
    Resource res = loadResourceByVersion(version, cnt.focus, Utilities.getFileNameForName(source));

    if (!(res instanceof StructureDefinition))
      throw new FHIRException("Require a StructureDefinition for generating a snapshot");
    StructureDefinition sd = (StructureDefinition) res;
    StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());

    new ProfileUtilities(context, null, null).setAutoFixSliceNames(true).generateSnapshot(base, sd, sd.getUrl(), null, sd.getName());
    return sd;
  }

  public void seeResource(Resource r) throws FHIRException {
    context.cacheResource(r);
  }

  public void dropResource(String type, String id) {
    context.dropResource(type, id);

  }

  public InstanceValidator getValidator() {
    InstanceValidator validator = new InstanceValidator(context, null, null);
    validator.setHintAboutNonMustSupport(hintAboutNonMustSupport);
    validator.setAnyExtensionsAllowed(anyExtensionsAllowed);
    validator.setNoInvariantChecks(isNoInvariantChecks());
    validator.setValidationLanguage(language);
    validator.setAssumeValidRestReferences(assumeValidRestReferences);
    validator.setNoExtensibleWarnings(noExtensibleBindingMessages);
    validator.setSecurityChecks(securityChecks);
    validator.setCrumbTrails(crumbTrails);
    validator.getContext().setLocale(locale);
    validator.setFetcher(this);
    validator.getImplementationGuides().addAll(igs);
    validator.getBundleValidationRules().addAll(bundleValidationRules);
    validator.getValidationControl().putAll(validationControl);
    validator.setQuestionnaireMode(questionnaireMode);
    return validator;
  }

  public void prepare() {
    for (StructureDefinition sd : context.allStructures()) {
      try {
        makeSnapshot(sd);
      } catch (Exception e) {
        System.out.println("Process Note: Unable to generate snapshot for " + sd.present() + ": " + e.getMessage());
        if (debug) {
          e.printStackTrace();
        }
      }
    }
  }

  private void makeSnapshot(StructureDefinition sd) throws DefinitionException, FHIRException {
    if (sd.hasSnapshot())
      return;
    StructureDefinition sdb = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
    if (sdb != null) {
      makeSnapshot(sdb);
      new ProfileUtilities(context, null, null).setAutoFixSliceNames(true).generateSnapshot(sdb, sd, sd.getUrl(), null, sd.getName());
    }

  }

  public void genScanOutput(String folder, List<ScanOutputItem> items) throws IOException, FHIRException, EOperationOutcome {
    String f = Utilities.path(folder, "comparison.zip");
    download("http://fhir.org/archive/comparison.zip", f);
    unzip(f, folder);

    for (int i = 0; i < items.size(); i++) {
      items.get(i).setId("c" + Integer.toString(i));
      genScanOutputItem(items.get(i), Utilities.path(folder, items.get(i).getId() + ".html"));
    }

    StringBuilder b = new StringBuilder();
    b.append("<html>");
    b.append("<head>");
    b.append("<title>Implementation Guide Scan</title>");
    b.append("<link rel=\"stylesheet\" href=\"fhir.css\"/>\r\n");
    b.append("<style>\r\n");
    b.append("th \r\n");
    b.append("{\r\n");
    b.append("  vertical-align: bottom;\r\n");
    b.append("  text-align: center;\r\n");
    b.append("}\r\n");
    b.append("\r\n");
    b.append("th span\r\n");
    b.append("{\r\n");
    b.append("  -ms-writing-mode: tb-rl;\r\n");
    b.append("  -webkit-writing-mode: vertical-rl;\r\n");
    b.append("  writing-mode: vertical-rl;\r\n");
    b.append("  transform: rotate(180deg);\r\n");
    b.append("  white-space: nowrap;\r\n");
    b.append("}\r\n");
    b.append("</style>\r\n");
    b.append("</head>");
    b.append("<body>");
    b.append("<h2>Implementation Guide Scan</h2>");

    // organise
    Set<String> refs = new HashSet<>();
    Set<String> igs = new HashSet<>();
    Map<String, Set<String>> profiles = new HashMap<>();
    for (ScanOutputItem item : items) {
      refs.add(item.getRef());
      if (item.getIg() != null) {
        igs.add(item.getIg().getUrl());
        if (!profiles.containsKey(item.getIg().getUrl())) {
          profiles.put(item.getIg().getUrl(), new HashSet<>());
        }
        if (item.getProfile() != null)
          profiles.get(item.getIg().getUrl()).add(item.getProfile().getUrl());
      }
    }

    b.append("<h2>By reference</h2>\r\n");
    b.append("<table class=\"grid\">");
    b.append("<tr><th></th><th></th>");
    for (String s : sorted(igs)) {
      ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, s);
      b.append("<th colspan=\"" + Integer.toString(profiles.get(s).size() + 1) + "\"><b title=\"" + s + "\">" + ig.present() + "</b></th>");
    }
    b.append("</tr>\r\n");
    b.append("<tr><th><b>Source</b></th><th><span>Core Spec</span></th>");
    for (String s : sorted(igs)) {
      ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, s);
      b.append("<th><span>Global</span></th>");
      for (String sp : sorted(profiles.get(s))) {
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, sp);
        b.append("<th><b title=\"" + sp + "\"><span>" + sd.present() + "</span></b></th>");
      }
    }
    b.append("</tr>\r\n");

    for (String s : sorted(refs)) {
      b.append("<tr>");
      b.append("<td>" + s + "</td>");
      b.append(genOutcome(items, s, null, null));
      for (String si : sorted(igs)) {
        ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, si);
        b.append(genOutcome(items, s, si, null));
        for (String sp : sorted(profiles.get(ig.getUrl()))) {
          b.append(genOutcome(items, s, si, sp));
        }
      }
      b.append("</tr>\r\n");
    }
    b.append("</table>\r\n");

    b.append("<h2>By IG</h2>\r\n");
    b.append("<table class=\"grid\">");
    b.append("<tr><th></th><th></th>");
    for (String s : sorted(refs)) {
      b.append("<th><span>" + s + "</span></th>");
    }
    b.append("</tr>\r\n");
    b.append("<tr><td></td><td>Core Spec</td>");
    for (String s : sorted(refs)) {
      b.append(genOutcome(items, s, null, null));
    }
    b.append("</tr>\r\n");
    for (String si : sorted(igs)) {
      b.append("<tr>");
      ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, si);
      b.append("<td><b title=\"" + si + "\">" + ig.present() + "</b></td>");
      b.append("<td>Global</td>");
      for (String s : sorted(refs)) {
        b.append(genOutcome(items, s, si, null));
      }
      b.append("</tr>\r\n");

      for (String sp : sorted(profiles.get(ig.getUrl()))) {
        b.append("<tr>");
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, sp);
        b.append("<td></td><td><b title=\"" + sp + "\">" + sd.present() + "</b></td>");
        for (String s : sorted(refs)) {
          b.append(genOutcome(items, s, si, sp));
        }
        b.append("</tr>\r\n");
      }
    }
    b.append("</table>\r\n");

    b.append("</body>");
    b.append("</html>");
    TextFile.stringToFile(b.toString(), Utilities.path(folder, "scan.html"));
  }

  private String genOutcome(List<ScanOutputItem> items, String src, String ig, String profile) {
    ScanOutputItem item = null;
    for (ScanOutputItem t : items) {
      boolean match = true;
      if (!t.getRef().equals(src))
        match = false;
      if (!((ig == null && t.getIg() == null) || (ig != null && t.getIg() != null && ig.equals(t.getIg().getUrl()))))
        match = false;
      if (!((profile == null && t.getProfile() == null) || (profile != null && t.getProfile() != null && profile.equals(t.getProfile().getUrl()))))
        match = false;
      if (match) {
        item = t;
        break;
      }
    }

    if (item == null)
      return "<td></td>";
    boolean ok = true;
    for (OperationOutcomeIssueComponent iss : item.getOutcome().getIssue()) {
      if (iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR || iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL) {
        ok = false;
      }
    }
    if (ok)
      return "<td style=\"background-color: #e6ffe6\"><a href=\"" + item.getId() + ".html\">\u2714</a></td>";
    else
      return "<td style=\"background-color: #ffe6e6\"><a href=\"" + item.getId() + ".html\">\u2716</a></td>";
  }

  public void unzip(String zipFilePath, String destDirectory) throws IOException {
    File destDir = new File(destDirectory);
    if (!destDir.exists()) {
      destDir.mkdir();
    }
    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry entry = zipIn.getNextEntry();
    // iterates over entries in the zip file
    while (entry != null) {
      String filePath = destDirectory + File.separator + entry.getName();
      if (!entry.isDirectory()) {
        // if the entry is a file, extracts it
        extractFile(zipIn, filePath);
      } else {
        // if the entry is a directory, make the directory
        File dir = new File(filePath);
        dir.mkdir();
      }
      zipIn.closeEntry();
      entry = zipIn.getNextEntry();
    }
    zipIn.close();
  }

  private static final int BUFFER_SIZE = 4096;

  private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[BUFFER_SIZE];
    int read = 0;
    while ((read = zipIn.read(bytesIn)) != -1) {
      bos.write(bytesIn, 0, read);
    }
    bos.close();
  }

  private void download(String address, String filename) throws IOException {
    URL url = new URL(address);
    URLConnection c = url.openConnection();
    InputStream s = c.getInputStream();
    FileOutputStream f = new FileOutputStream(filename);
    transfer(s, f, 1024);
    f.close();
  }

  public static void transfer(InputStream in, OutputStream out, int buffer) throws IOException {
    byte[] read = new byte[buffer]; // Your buffer size.
    while (0 < (buffer = in.read(read)))
      out.write(read, 0, buffer);
  }

  private void genScanOutputItem(ScanOutputItem item, String filename) throws IOException, FHIRException, EOperationOutcome {
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
    rc.setNoSlowLookup(true);
    RendererFactory.factory(item.getOutcome(), rc).render(item.getOutcome());
    String s = new XhtmlComposer(XhtmlComposer.HTML).compose(item.getOutcome().getText().getDiv());

    String title = item.getTitle();

    StringBuilder b = new StringBuilder();
    b.append("<html>");
    b.append("<head>");
    b.append("<title>" + title + "</title>");
    b.append("<link rel=\"stylesheet\" href=\"fhir.css\"/>\r\n");
    b.append("</head>");
    b.append("<body>");
    b.append("<h2>" + title + "</h2>");
    b.append(s);
    b.append("</body>");
    b.append("</html>");
    TextFile.stringToFile(b.toString(), filename);
  }

  private List<String> sorted(Set<String> keys) {
    List<String> names = new ArrayList<String>();
    if (keys != null)
      names.addAll(keys);
    Collections.sort(names);
    return names;
  }

  @Override
  public Element fetch(Object appContext, String url) throws FHIRException, IOException {
    Resource resource = context.fetchResource(Resource.class, url);
    if (resource != null) {
      return new ObjectConverter(context).convert(resource);
    }
    if (fetcher != null) {
      return fetcher.fetch(appContext, url);
    }
    return null;
  }

  @Override
  public ReferenceValidationPolicy validationPolicy(Object appContext, String path, String url) {
    Resource resource = context.fetchResource(StructureDefinition.class, url);
    if (resource != null) {
      return ReferenceValidationPolicy.CHECK_VALID;
    }
    if (!(url.contains("hl7.org") || url.contains("fhir.org"))) {
      return ReferenceValidationPolicy.IGNORE;
    } else if (fetcher != null) {
      return fetcher.validationPolicy(appContext, path, url);
    } else {
      return ReferenceValidationPolicy.CHECK_EXISTS_AND_TYPE;
    }
  }

  @Override
  public boolean resolveURL(Object appContext, String path, String url, String type) throws IOException, FHIRException {
    if (!url.startsWith("http://") && !url.startsWith("https://")) { // ignore these 
      return true;
    }
    if (context.fetchResource(Resource.class, url) != null)
      return true;
    if (Utilities.existsInList(url, "http://hl7.org/fhir/sid/us-ssn", "http://hl7.org/fhir/sid/cvx", "http://hl7.org/fhir/sid/ndc", "http://hl7.org/fhir/sid/us-npi", "http://hl7.org/fhir/sid/icd-10",
      "http://hl7.org/fhir/sid/icd-10-vn", "http://hl7.org/fhir/sid/icd-10-cm", "http://hl7.org/fhir/sid/icd-9-cm", "http://hl7.org/fhir/w5", "http://hl7.org/fhir/fivews",
      "http://hl7.org/fhir/workflow", "http://hl7.org/fhir/ConsentPolicy/opt-out", "http://hl7.org/fhir/ConsentPolicy/opt-in")) {
      return true;
    }
    if (Utilities.existsInList(url, "http://loinc.org", "http://unitsofmeasure.org", "http://snomed.info/sct")) {
      return true;
    }
    if (fetcher != null) {
      return fetcher.resolveURL(appContext, path, url, type);
    }
    ;
    return false;
  }

  @Override
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  @Override
  public CanonicalResource fetchCanonicalResource(String url) throws URISyntaxException {
    Resource res = context.fetchResource(Resource.class, url);
    if (res != null) {
      if (res instanceof CanonicalResource) {
        return (CanonicalResource) res;
      } else {
        return null;
      }     
    }
    return fetcher != null ? fetcher.fetchCanonicalResource(url) : null;
  }

  @Override
  public boolean fetchesCanonicalResource(String url) {
    return fetcher != null ? fetcher.fetchesCanonicalResource(url) : false;
  }


  public void handleOutput(Resource r, String output, String version) throws FHIRException, IOException {
    if (output.startsWith("http://") || output.startsWith("http://")) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      handleOutputToStream(r, output, bs, version);
      URL url = new URL(output);
      HttpURLConnection c = (HttpURLConnection) url.openConnection();
      c.setDoOutput(true);
      c.setDoInput(true);
      c.setRequestMethod("POST");
      c.setRequestProperty("Content-type", "application/fhir+xml");
      c.setRequestProperty("Accept", "application/fhir+xml");
      c.getOutputStream().write(bs.toByteArray());
      c.getOutputStream().close();

      if (c.getResponseCode() >= 300) {
//        String line;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
//        while ((line = reader.readLine()) != null) {
//          System.out.println(line);
//        }
//        reader.close();
        throw new IOException("Unable to PUT to " + output + ": " + c.getResponseMessage());
      }
    } else {
      FileOutputStream s = new FileOutputStream(output);
      handleOutputToStream(r, output, s, version);
    }
  }

  private void handleOutputToStream(Resource r, String fn, OutputStream s, String version) throws FHIRException, IOException {
    if (fn.endsWith(".html") || fn.endsWith(".htm") && r instanceof DomainResource)
      new XhtmlComposer(XhtmlComposer.HTML, true).compose(s, ((DomainResource) r).getText().getDiv());
    else if (version.startsWith("3.0")) {
      org.hl7.fhir.dstu3.model.Resource res = VersionConvertor_30_50.convertResource(r, false);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu3.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu3.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        TextFile.stringToStream(org.hl7.fhir.dstu3.utils.StructureMapUtilities.render((org.hl7.fhir.dstu3.model.StructureMap) res), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource res = VersionConvertor_40_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        TextFile.stringToStream(org.hl7.fhir.r4.utils.StructureMapUtilities.render((org.hl7.fhir.r4.model.StructureMap) res), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.startsWith("1.4")) {
      org.hl7.fhir.dstu2016may.model.Resource res = VersionConvertor_14_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.startsWith("1.0")) {
      VersionConvertorAdvisor50 advisor = new org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor5();
      org.hl7.fhir.dstu2.model.Resource res = VersionConvertor_10_50.convertResource(r, advisor);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.equals(Constants.VERSION)) {
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new XmlParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(s, r);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new JsonParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(s, r);
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        TextFile.stringToStream(StructureMapUtilities.render((org.hl7.fhir.r5.model.StructureMap) r), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else
      throw new FHIRException("Encounted unsupported configured version " + version + " loading " + fn);

    s.close();
  }

  public byte[] transformVersion(String source, String targetVer, FhirFormat format, Boolean canDoNative) throws FHIRException, IOException, Exception {
    Content cnt = loadContent(source, "validate", false);
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);

    // if the src has a url, we try to use the java code 
    if ((canDoNative == null && src.hasChild("url")) || (canDoNative != null && canDoNative)) {
      try {
        if (VersionUtilities.isR2Ver(version)) {
          return convertVersionNativeR2(targetVer, cnt, format);
        } else if (VersionUtilities.isR2BVer(version)) {
          return convertVersionNativeR2b(targetVer, cnt, format);
        } else if (VersionUtilities.isR3Ver(version)) {
          return convertVersionNativeR3(targetVer, cnt, format);
        } else if (VersionUtilities.isR4Ver(version)) {
          return convertVersionNativeR4(targetVer, cnt, format);
        } else {
          throw new FHIRException("Source version not supported yet: " + version);
        }
      } catch (Exception e) {
        System.out.println("Conversion failed using Java convertor: " + e.getMessage());
      }
    }
    // ok, we try converting using the structure maps
    System.out.println("Loading hl7.fhir.xver.r4");
    loadIg("hl7.fhir.xver.r4", false);
    String type = src.fhirType();
    String url = getMapId(type, targetVer);
    List<Base> outputs = new ArrayList<Base>();
    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs));
    StructureMap map = context.getTransform(url);
    if (map == null)
      throw new Error("Unable to find map " + url + " (Known Maps = " + context.listMapUrls() + ")");
    org.hl7.fhir.r5.elementmodel.Element resource = getTargetResourceFromStructureMap(map);
    scu.transform(null, src, map, resource);
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    Manager.compose(context, resource, bs, format, OutputStyle.PRETTY, null);
    return bs.toByteArray();
  }

  private String getMapId(String type, String targetVer) {
    if (VersionUtilities.isR2Ver(version)) {
      if (VersionUtilities.isR3Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "2to3";
      }
    } else if (VersionUtilities.isR3Ver(version)) {
      if (VersionUtilities.isR2Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "3to2";
      } else if (VersionUtilities.isR4Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "3to4";
      }
    } else if (VersionUtilities.isR4Ver(version)) {
      if (VersionUtilities.isR3Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/" + type + "4to3";
      }
    }
    throw new FHIRException("Source/Target version not supported: " + version + " -> " + targetVer);
  }

  public byte[] convertVersionNativeR2(String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu2.model.Resource r2;
    switch (cnt.cntType) {
      case JSON:
        r2 = new org.hl7.fhir.dstu2.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r2 = new org.hl7.fhir.dstu2.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, r2);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2.formats.XmlParser().compose(bs, r2);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_10_30.convertResource(r2);
      org.hl7.fhir.dstu2016may.model.Resource r2b = VersionConvertor_14_30.convertResource(r3);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2016may.formats.JsonParser().compose(bs, r2b);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2016may.formats.XmlParser().compose(bs, r2b);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_10_30.convertResource(r2);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu3.formats.JsonParser().compose(bs, r3);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu3.formats.XmlParser().compose(bs, r3);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertor_10_40.convertResource(r2);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.r4.formats.JsonParser().compose(bs, r4);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.r4.formats.XmlParser().compose(bs, r4);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public byte[] convertVersionNativeR2b(String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu2016may.model.Resource r2b;
    switch (cnt.cntType) {
      case JSON:
        r2b = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r2b = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_14_30.convertResource(r2b);
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertor_10_30.convertResource(r3);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, r2);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2.formats.XmlParser().compose(bs, r2);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2016may.formats.JsonParser().compose(bs, r2b);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2016may.formats.XmlParser().compose(bs, r2b);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_14_30.convertResource(r2b);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu3.formats.JsonParser().compose(bs, r3);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu3.formats.XmlParser().compose(bs, r3);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertor_14_40.convertResource(r2b);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.r4.formats.JsonParser().compose(bs, r4);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.r4.formats.XmlParser().compose(bs, r4);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  public byte[] convertVersionNativeR3(String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.dstu3.model.Resource r3;
    switch (cnt.cntType) {
      case JSON:
        r3 = new org.hl7.fhir.dstu3.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r3 = new org.hl7.fhir.dstu3.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertor_10_30.convertResource(r3);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, r2);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2.formats.XmlParser().compose(bs, r2);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      org.hl7.fhir.dstu2016may.model.Resource r2b = VersionConvertor_14_30.convertResource(r3);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2016may.formats.JsonParser().compose(bs, r2b);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2016may.formats.XmlParser().compose(bs, r2b);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu3.formats.JsonParser().compose(bs, r3);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu3.formats.XmlParser().compose(bs, r3);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertor_30_40.convertResource(r3, false);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.r4.formats.JsonParser().compose(bs, r4);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.r4.formats.XmlParser().compose(bs, r4);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }


  public byte[] convertVersionNativeR4(String targetVer, Content cnt, FhirFormat format) throws IOException, Exception {
    org.hl7.fhir.r4.model.Resource r4;
    switch (cnt.cntType) {
      case JSON:
        r4 = new org.hl7.fhir.r4.formats.JsonParser().parse(cnt.focus);
        break;
      case XML:
        r4 = new org.hl7.fhir.r4.formats.XmlParser().parse(cnt.focus);
        break;
      default:
        throw new FHIRException("Unsupported input format: " + cnt.cntType.toString());
    }
    if (VersionUtilities.isR2Ver(targetVer)) {
      org.hl7.fhir.dstu2.model.Resource r2 = VersionConvertor_10_40.convertResource(r4);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2.formats.JsonParser().compose(bs, r2);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2.formats.XmlParser().compose(bs, r2);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR2BVer(targetVer)) {
      org.hl7.fhir.dstu2016may.model.Resource r2b = VersionConvertor_14_40.convertResource(r4);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu2016may.formats.JsonParser().compose(bs, r2b);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu2016may.formats.XmlParser().compose(bs, r2b);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR3Ver(targetVer)) {
      org.hl7.fhir.dstu3.model.Resource r3 = VersionConvertor_30_40.convertResource(r4, false);
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.dstu3.formats.JsonParser().compose(bs, r3);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.dstu3.formats.XmlParser().compose(bs, r3);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else if (VersionUtilities.isR4Ver(targetVer)) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      switch (format) {
        case JSON:
          new org.hl7.fhir.r4.formats.JsonParser().compose(bs, r4);
          return bs.toByteArray();
        case XML:
          new org.hl7.fhir.r4.formats.XmlParser().compose(bs, r4);
          return bs.toByteArray();
        default:
          throw new FHIRException("Unsupported output format: " + cnt.cntType.toString());
      }
    } else {
      throw new FHIRException("Target Version not supported yet: " + targetVer);
    }
  }

  @Override
  public byte[] fetchRaw(String source) throws IOException {
    URL url = new URL(source);
    URLConnection c = url.openConnection();
    return TextFile.streamToBytes(c.getInputStream());
  }

  public boolean packageExists(String id, String ver) throws IOException, FHIRException {
    return pcm.packageExists(id, ver);
  }

  public void loadPackage(String id, String ver) throws IOException, FHIRException {
    loadIg(id + (ver == null ? "" : "#" + ver), true);
  }

  /**
   * Systems that host the ValidationEngine can use this to control what validation the validator performs.
   * <p>
   * Using this, you can turn particular kinds of validation on and off. In addition, you can override
   * the error | warning | hint level and make it a different level.
   * <p>
   * Each entry has
   * * 'allowed': a boolean flag. if this is false, the Validator will not report the error.
   * * 'level' : set to error, warning, information
   * <p>
   * Entries are registered by ID, using the IDs in /org.hl7.fhir.utilities/src/main/resources/Messages.properties
   * <p>
   * This feature is not supported by the validator CLI - and won't be. It's for systems hosting
   * the validation framework in their own implementation context
   */
  public Map<String, ValidationControl> getValidationControl() {
    return validationControl;
  }

  public String setTerminologyServer(String src, String log, FhirPublication version) throws FHIRException, URISyntaxException {
    return connectToTSServer(src, log, version);
  }

  /*
   * Accessors
   */

  public boolean isDoNative() {
    return doNative;
  }

  public ValidationEngine setNative(boolean doNative) {
    this.doNative = doNative;
    return this;
  }

  public boolean isNoInvariantChecks() {
    return noInvariantChecks;
  }

  public ValidationEngine setNoInvariantChecks(boolean value) {
    this.noInvariantChecks = value;
    return this;
  }

  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  public ValidationEngine setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
    return this;
  }

  public boolean isAnyExtensionsAllowed() {
    return anyExtensionsAllowed;
  }

  public ValidationEngine setAnyExtensionsAllowed(boolean anyExtensionsAllowed) {
    this.anyExtensionsAllowed = anyExtensionsAllowed;
    return this;
  }

  public String getVersion() {
    return version;
  }

  public ValidationEngine setVersion(String version) {
    this.version = version;
    return this;
  }

  public String getLanguage() {
    return language;
  }

  public ValidationEngine setLanguage(String language) {
    this.language = language;
    return this;
  }

  public FilesystemPackageCacheManager getPcm() {
    return pcm;
  }

  public PrintWriter getMapLog() {
    return mapLog;
  }

  public ValidationEngine setMapLog(String mapLog) throws FileNotFoundException {
    if (mapLog != null) {
      this.mapLog = new PrintWriter(mapLog);
    }
    return this;
  }

  public boolean isDebug() {
    return debug;
  }

  public ValidationEngine setDebug(boolean debug) {
    this.debug = debug;
    return this;
  }

  public IValidatorResourceFetcher getFetcher() {
    return fetcher;
  }

  public ValidationEngine setFetcher(IValidatorResourceFetcher fetcher) {
    this.fetcher = fetcher;
    return this;
  }

  public boolean isAssumeValidRestReferences() {
    return assumeValidRestReferences;
  }

  public ValidationEngine setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
    return this;
  }

  public boolean isNoExtensibleBindingMessages() {
    return noExtensibleBindingMessages;
  }

  public ValidationEngine setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
    return this;
  }

  public boolean isSecurityChecks() {
    return securityChecks;
  }

  public ValidationEngine setSecurityChecks(boolean securityChecks) {
    this.securityChecks = securityChecks;
    return this;
  }

  public boolean isCrumbTrails() {
    return crumbTrails;
  }

  public ValidationEngine setCrumbTrails(boolean crumbTrails) {
    this.crumbTrails = crumbTrails;
    return this;
  }

  public boolean isShowTimes() {
    return showTimes;
  }

  public ValidationEngine setShowTimes(boolean showTimes) {
    this.showTimes = showTimes;
    return this;
  }

  public List<BundleValidationRule> getBundleValidationRules() {
    return bundleValidationRules;
  }

  public ValidationEngine setBundleValidationRules(List<BundleValidationRule> bundleValidationRules) {
    this.bundleValidationRules = bundleValidationRules;
    return this;
  }

  public QuestionnaireMode getQuestionnaireMode() {
    return questionnaireMode;
  }

  public ValidationEngine setQuestionnaireMode(QuestionnaireMode questionnaireMode) {
    this.questionnaireMode = questionnaireMode;
    return this;
  }

  public ValidationEngine setSnomedExtension(String sct) {
    context.getExpansionParameters().addParameter("system-version", "http://snomed.info/sct|http://snomed.info/sct/" + sct);
    return this;
  }

}