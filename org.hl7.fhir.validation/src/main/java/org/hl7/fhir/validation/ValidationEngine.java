package org.hl7.fhir.validation;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.convertors.*;
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
import org.hl7.fhir.r5.terminologies.ConceptMapEngine;
import org.hl7.fhir.r5.utils.*;
import org.hl7.fhir.r5.utils.IResourceValidator.*;
import org.hl7.fhir.r5.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.cache.NpmPackage;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.xml.sax.SAXException;

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
  Copyright (c) 2011+, HL7, Inc.
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
 * 
 * The following resource formats are supported: XML, JSON, Turtle
 * The following versions are supported: 1.0.2, 1.4.0, 3.0.2, 4.0.1, and current
 * 
 * Note: the validation engine is intended to be threadsafe
 * To Use:
 *  
 * 1/ Initialize
 *    ValidationEngine validator = new ValidationEngine(src);
 *      - this must be the packageId of the relevant core specification
 *        for the version you want to validate against (e.g. hl7.fhir.r4.core)
 *
 *    validator.connectToTSServer(txServer);
 *      - this is optional; in the absence of a terminology service, snomed, loinc etc will not be validated
 *      
 *    validator.loadIg(src);
 *      - call this any number of times for the Implementation Guide(s) of interest. 
 *      - See https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator for documentation about the src parameter (-ig parameter)
 *         
 *    validator.loadQuestionnaire(src)
 *      - url or filename of a questionnaire to load. Any loaded questionnaires will be used while validating
 *      
 *    validator.setNative(doNative);
 *      - whether to do xml/json/rdf schema validation as well
 *
 *   You only need to do this initialization once. You can validate as many times as you like
 *   
 * 2. validate
 *    validator.validate(src, profiles);
 *      - source (as stream, byte[]), or url or filename of a resource to validate. 
 *        Also validate against any profiles (as canonical URLS, equivalent to listing them in Resource.meta.profile)
 *        
 *        if the source is provided as byte[] or stream, you need to provide a format too, though you can 
 *        leave that as null, and the validator will guess
 * 
 * 3. Or, instead of validating, transform (see documentation and use in Validator.java)
 *         
 * @author Grahame Grieve
 *
 */
public class ValidationEngine implements IValidatorResourceFetcher {



  public class ScanOutputItem {
    private String ref;
    private ImplementationGuide ig;
    private StructureDefinition profile;
    private OperationOutcome outcome;
    private String id;
    public ScanOutputItem(String ref, ImplementationGuide ig, StructureDefinition profile, OperationOutcome outcome) {
      super();
      this.ref = ref;
      this.ig = ig;
      this.profile = profile;
      this.outcome = outcome;
    }
    public String getRef() {
      return ref;
    }
    public ImplementationGuide getIg() {
      return ig;
    }
    public StructureDefinition getProfile() {
      return profile;
    }
    public OperationOutcome getOutcome() {
      return outcome;
    }
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public String getTitle() {
      if (profile != null)
        return "Validate " +ref+" against "+profile.present()+" ("+profile.getUrl()+")";
      if (ig != null)
        return "Validate " +ref+" against global profile specified in "+ig.present()+" ("+ig.getUrl()+")";      
      return "Validate " +ref+" against FHIR Spec";
    }
  }

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
//  private FHIRPathEngine fpe;
  private Map<String, byte[]> binaries = new HashMap<String, byte[]>();
  private boolean doNative;
  private boolean noInvariantChecks;
  private boolean hintAboutNonMustSupport;
  private boolean anyExtensionsAllowed = false;
  private String version;
  private String language;
  private PackageCacheManager pcm;
  private PrintWriter mapLog;
  private boolean debug;
  private Set<String> loadedIgs = new HashSet<>();
  private IValidatorResourceFetcher fetcher;
  private boolean assumeValidRestReferences;
  private boolean noExtensibleBindingMessages;
  private Locale locale;

  private class AsteriskFilter implements FilenameFilter {
    String dir;
    String regex;
    
    public AsteriskFilter(String filter) throws IOException {
      if (!filter.matches("(.*(\\\\|\\/))*(.*)\\*(.*)"))
        throw new IOException("Filter names must have the following syntax: [directorypath][prefix]?*[suffix]?   I.e. The asterisk must be in the filename, not the directory path");
      dir = filter.replaceAll("(.*(\\\\|\\/))*(.*)\\*(.*)", "$1");
      String expression = filter.replaceAll("(.*(\\\\|\\/))*(.*)", "$3");
      regex = "";
      for (int i = 0; i < expression.length(); i++) {
        if (Character.isAlphabetic(expression.codePointAt(i)) || Character.isDigit(expression.codePointAt(i)))
          regex = regex + expression.charAt(i);
        else if (expression.charAt(i)=='*')
          regex = regex + ".*";
        else
          regex = regex + "\\" + expression.charAt(i);
      }
      File f = new File(dir);
      if (!f.exists()) {
        throw new IOException("Directory " + dir + " does not exist");
      }
      if (!f.isDirectory()) {
        throw new IOException("Directory " + dir + " is not a directory");
      }
    }
    
    public boolean accept(File dir, String s) {
      boolean match = s.matches(regex);
      return match;
    }
    
    public String getDir() {
      return dir;
    }
  }
  
  public ValidationEngine() throws IOException {
    pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);  
  }
    
  public void setTerminologyServer(String src, String log, FhirPublication version) throws Exception {
    connectToTSServer(src, log, version);   
  }
  
  public boolean isHintAboutNonMustSupport() {
    return hintAboutNonMustSupport;
  }

  public void setHintAboutNonMustSupport(boolean hintAboutNonMustSupport) {
    this.hintAboutNonMustSupport = hintAboutNonMustSupport;
  }

  public boolean isAnyExtensionsAllowed() {
    return anyExtensionsAllowed;
  }

  public void setAnyExtensionsAllowed(boolean anyExtensionsAllowed) {
    this.anyExtensionsAllowed = anyExtensionsAllowed;
  }

  public ValidationEngine(String src, String txsrvr, String txLog, FhirPublication version, boolean canRunWithoutTerminologyServer, String vString) throws Exception {
    pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    loadCoreDefinitions(src, false);
    context.setCanRunWithoutTerminology(canRunWithoutTerminologyServer);
    setTerminologyServer(txsrvr, txLog, version);    
    this.version = vString;
  }
  
  public ValidationEngine(String src, String txsrvr, String txLog, FhirPublication version, String vString) throws Exception {
    pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    loadCoreDefinitions(src, false);
    setTerminologyServer(txsrvr, txLog, version);
    this.version = vString;
  }
  
  public ValidationEngine(String src) throws Exception {
    loadCoreDefinitions(src, false);
    pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
  }
  
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  private void loadCoreDefinitions(String src, boolean recursive) throws Exception {
    Map<String, byte[]> source = loadIgSource(src, recursive, true);   
    if (version == null)
      version = getVersionFromPack(source);
    context = SimpleWorkerContext.fromDefinitions(source, loaderForVersion(), new PackageVersion(src));
    context.setAllowLoadingDuplicates(true); // because of Forge
    context.setExpansionProfile(makeExpProfile());
    NpmPackage npm = pcm.loadPackage("hl7.fhir.xver-extensions", "0.0.4");
    context.loadFromPackage(npm, null);
    grabNatives(source, "http://hl7.org/fhir");
  }

  private IContextResourceLoader loaderForVersion() {
    if (Utilities.noString(version))
      return null;
    if (version.startsWith("1.0"))
      return new R2ToR5Loader(new String[] { "Conformance", "StructureDefinition", "ValueSet", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"});
    if (version.startsWith("1.4"))
      return new R2016MayToR5Loader(new String[] { "Conformance", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"}); // special case
    if (version.startsWith("3.0"))
      return new R3ToR5Loader(new String[] { "CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"});    
    if (version.startsWith("4.0"))
      return new R4ToR5Loader(new String[] { "CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"});    
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
    Parameters ep  = new Parameters();
    ep.addParameter("profile-url", "http://hl7.org/fhir/ExpansionProfile/dc8fd4bc-091a-424a-8a3b-6198ef146891"); // change this to blow the cache
    // all defaults....
    return ep;
  }

  private byte[] loadProfileSource(String src) throws Exception {
    if (Utilities.noString(src)) {
      throw new FHIRException("Profile Source '" + src + "' could not be processed");
    } else if (src.startsWith("https:") || src.startsWith("http:")) {
      return loadProfileFromUrl(src);
    } else if (new File(src).exists()) {
      return loadProfileFromFile(src);      
    } else {
      throw new FHIRException("Definitions Source '"+src+"' could not be processed");
    }
  }

  private byte[] loadProfileFromUrl(String src) throws Exception {
    try {
      URL url = new URL(src+"?nocache=" + System.currentTimeMillis());
      URLConnection c = url.openConnection();
      return IOUtils.toByteArray(c.getInputStream());
    } catch (Exception e) {
      throw new Exception("Unable to find definitions at URL '"+src+"': "+e.getMessage(), e);
  }
    }

  private byte[] loadProfileFromFile(String src) throws FileNotFoundException, IOException {
    File f = new File(src);
    if (f.isDirectory()) 
      throw new IOException("You must provide a file name, not a directory name");
    return TextFile.fileToBytes(src);
  }

  /** explore should be true if we're trying to load an -ig parameter, and false if we're loading source **/
  
  private Map<String, byte[]> loadIgSource(String src, boolean recursive, boolean explore) throws Exception {
    // src can be one of the following:
    // - a canonical url for an ig - this will be converted to a package id and loaded into the cache
    // - a package id for an ig - this will be loaded into the cache
    // - a direct reference to a package ("package.tgz") - this will be extracted by the cache manager, but not put in the cache
    // - a folder containing resources - these will be loaded directly
    if (src.startsWith("https:") || src.startsWith("http:")) {
      String v = null;
      if (src.contains("|")) {
        v = src.substring(src.indexOf("|")+1);
        src = src.substring(0, src.indexOf("|"));
      }
      String pid = pcm.getPackageId(src);
      if (!Utilities.noString(pid))
        return fetchByPackage(pid+(v == null ? "" : "#"+v));
      else
        return fetchFromUrl(src+(v == null ? "" : "|"+v), explore);
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
        res.put(Utilities.changeFileExt(src, "."+fmt.getExtension()), TextFile.fileToBytesNCS(src));
        return res;
      }
    } else if ((src.matches(PackageCacheManager.PACKAGE_REGEX) || src.matches(PackageCacheManager.PACKAGE_VERSION_REGEX)) && !src.endsWith(".zip") && !src.endsWith(".tgz")) {
      return fetchByPackage(src);
    }
    throw new Exception("Unable to find/resolve/read -ig "+src);
  }

  
  private Map<String, byte[]> fetchFromUrl(String src, boolean explore) throws Exception {
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
    if (stream == null)
      cnt = fetchFromUrlSpecific(src, "application/json", true);
    else
      cnt = TextFile.streamToBytes(stream);
    
    FhirFormat fmt = checkIsResource(cnt, src);
    if (fmt != null) {
      Map<String, byte[]> res = new HashMap<String, byte[]>();
      res.put(Utilities.changeFileExt(src, "."+fmt.getExtension()), cnt);
      return res;
    }    
    throw new Exception("Unable to find/resolve/read -ig "+src);
  }

  private InputStream fetchFromUrlSpecific(String source, boolean optional) throws Exception {
    try {
      URL url = new URL(source+"?nocache=" + System.currentTimeMillis());
      URLConnection c = url.openConnection();
      return c.getInputStream();
    } catch (Exception e) {
      if (optional)
        return null;
      else
        throw e;
    }
  }

  private byte[] fetchFromUrlSpecific(String source, String contentType, boolean optional) throws Exception {
    try {
      URL url = new URL(source+"?nocache=" + System.currentTimeMillis());
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestProperty("Accept", contentType);
      return TextFile.streamToBytes(conn.getInputStream());
    } catch (Exception e) {
      if (optional)
        return null;
      else
        throw e;
    }
  }

  private Map<String, byte[]> scanDirectory(File f, boolean recursive) throws FileNotFoundException, IOException {
    Map<String, byte[]> res = new HashMap<>();
    for (File ff : f.listFiles()) {
      if (ff.isDirectory() && recursive){
          res.putAll(scanDirectory(ff, true));
      }
      else if (!isIgnoreFile(ff)) {
        FhirFormat fmt = checkIsResource(ff.getAbsolutePath());
        if (fmt != null) {
          res.put(Utilities.changeFileExt(ff.getName(), "."+fmt.getExtension()), TextFile.fileToBytes(ff.getAbsolutePath()));
        }
      }
    }
    return res;
  }

  private boolean isIgnoreFile(File ff) {
    if (ff.getName().startsWith(".")|| ff.getAbsolutePath().contains(".git")){
      return true;
    }
    return Utilities.existsInList(Utilities.getFileExtension(ff.getName()).toLowerCase(), "md", "css", "js", "png", "gif", "jpg", "html", "tgz", "pack", "zip");
  }

  private Map<String, byte[]> loadPackage(InputStream stream, String name) throws Exception {
    return loadPackage(NpmPackage.fromPackage(stream));
  }

  public Map<String, byte[]> loadPackage(NpmPackage pi) throws Exception {
    loadedIgs.add(pi.name()+"#"+pi.version());
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (String s : pi.dependencies()) {
      if (!loadedIgs.contains(s)) {
        if (!VersionUtilities.isCorePackage(s)) {
          System.out.println("+  .. load IG from "+s);
          res.putAll(fetchByPackage(s));
        }
      }
    }
    
    for (String s : pi.listResources("CodeSystem", "ConceptMap", "ImplementationGuide", "CapabilityStatement", "SearchParameter", "Conformance", "StructureMap", "ValueSet", "StructureDefinition")) {
       res.put(s, TextFile.streamToBytes(pi.load("package", s)));
    }
    String ini = "[FHIR]\r\nversion="+pi.fhirVersion()+"\r\n";
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

  private Map<String, byte[]> fetchByPackage(String src) throws Exception {
    String id = src;
    String version = null;
    if (src.contains("#")) {
      id = src.substring(0, src.indexOf("#"));
      version = src.substring(src.indexOf("#")+1);
    }
    if (pcm == null) {
      log("Creating Package manager?");
      pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    if (version == null) {
      version = pcm.getLatestVersion(id);
    }
    NpmPackage pi = null;
    if (version == null) {
      pi = pcm.loadPackageFromCacheOnly(id);
      if (pi != null)
        log("   ... Using version "+pi.version());
    } else
      pi = pcm.loadPackageFromCacheOnly(id, version);
    if (pi == null) {
      return resolvePackage(id, version);
    } else
      return loadPackage(pi);
  }

  private Map<String, byte[]> resolvePackage(String id, String v) throws Exception {
    NpmPackage pi = pcm.loadPackage(id, v);
    if (pi != null && v == null)
      log("   ... Using version "+pi.version());
    return loadPackage(pi);
  }

  public SimpleWorkerContext getContext() {
    return context;
  }
  
 
  public boolean isNoInvariantChecks() {
    return noInvariantChecks;
  }

  public void setNoInvariantChecks(boolean value) {
    this.noInvariantChecks = value;
  }

  private FhirFormat checkIsResource(byte[] cnt, String filename) {
    System.out.println("   ..Detect format for "+filename);
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt), FhirFormat.JSON);
      return FhirFormat.JSON;
    } catch (Exception e) {
    }
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt),FhirFormat.XML);
      return FhirFormat.XML;
    } catch (Exception e) {
    }
    try {
      Manager.parse(context, new ByteArrayInputStream(cnt),FhirFormat.TURTLE);
      return FhirFormat.TURTLE;
    } catch (Exception e) {
    }
    try {
      new StructureMapUtilities(context, null, null).parse(TextFile.bytesToString(cnt), null);
      return FhirFormat.TEXT;
    } catch (Exception e) {
    }
    if (debug)
      System.out.println("     .. not a resource: "+filename);
    return null;    
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

  public void connectToTSServer(String url, String log, FhirPublication version) throws URISyntaxException, FHIRException {
    context.setTlogging(false);
    if (url == null) {
      context.setCanRunWithoutTerminology(true);
    } else {
      try {
        context.connectToTSServer(TerminologyClientFactory.makeClient(url, version), log);
      } catch (Exception e) {
        if (context.isCanRunWithoutTerminology()) {
          System.out.println("Running without Terminology Server (error: "+e.getMessage()+")");
        } else 
          throw e;
      }
    }
  }

  public void loadProfile(String src) throws Exception {
    if (context.hasResource(StructureDefinition.class, src))
      return;
    if (context.hasResource(ImplementationGuide.class, src))
      return;
    
    byte[] source = loadProfileSource(src);
    FhirFormat fmt = FormatUtilities.determineFormat(source);
    Resource r = FormatUtilities.makeParser(fmt).parse(source);
    context.cacheResource(r);
  }
  
  public void loadIg(String src, boolean recursive) throws IOException, FHIRException, Exception {
    String canonical = null;
    Map<String, byte[]> source = loadIgSource(src, recursive, true);
    String version = Constants.VERSION;
    if (this.version != null)
      version = this.version;
    if (source.containsKey("version.info"))
      version = readInfoVersion(source.get("version.info"));
    
    for (Entry<String, byte[]> t : source.entrySet()) {
      String fn = t.getKey();
      if (!exemptFile(fn)) {
        Resource r = loadFileWithErrorChecking(version, t, fn);
        if (r != null) {
          context.cacheResource(r);
          if (r instanceof ImplementationGuide) {
            canonical = ((ImplementationGuide) r).getUrl();
            if (canonical.contains("/ImplementationGuide/")) {
              Resource r2 = r.copy();
              ((ImplementationGuide) r2).setUrl(canonical.substring(0, canonical.indexOf("/ImplementationGuide/")));
              context.cacheResource(r2);
            }
          }
        }
      }
    }
    if (canonical != null)
      grabNatives(source, canonical);
  }

  public Resource loadFileWithErrorChecking(String version, Entry<String, byte[]> t, String fn) {
    if (debug)
      System.out.print("* load file: "+fn);
    Resource r = null;
    try { 
      r = loadResourceByVersion(version, t.getValue(), fn);
      if (debug)
        System.out.println(" .. success");
    } catch (Exception e) {
      if (!debug) {
        System.out.print("* load file: "+fn);
      }
      System.out.println(" - ignored due to error: "+(e.getMessage() == null ? " (null - NPE)" :  e.getMessage()));
      if (debug || ((e.getMessage() != null && e.getMessage().contains("cannot be cast")))) {
        e.printStackTrace();
      }
    }
    return r;
  }

  public Resource loadResourceByVersion(String version, byte[] content, String fn) throws IOException, Exception {
    Resource r;
    if (version.startsWith("3.0")) {
      org.hl7.fhir.dstu3.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu3.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map") )
        res = new org.hl7.fhir.dstu3.utils.StructureMapUtilities(null).parse(new String(content));
      else
        throw new Exception("Unsupported format for "+fn);
      r = VersionConvertor_30_50.convertResource(res, false);
    } else if (version.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.r4.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.r4.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map") )
        res = new org.hl7.fhir.r4.utils.StructureMapUtilities(null).parse(new String(content), fn);
      else
        throw new Exception("Unsupported format for "+fn);
      r = VersionConvertor_40_50.convertResource(res);
    } else if (version.startsWith("1.4")) {
      org.hl7.fhir.dstu2016may.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else
        throw new Exception("Unsupported format for "+fn);
      r = VersionConvertor_14_50.convertResource(res);
    } else if (version.startsWith("1.0")) {
      org.hl7.fhir.dstu2.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else
        throw new Exception("Unsupported format for "+fn);
      VersionConvertorAdvisor50 advisor = new org.hl7.fhir.convertors.IGR2ConvertorAdvisor5();
      r = VersionConvertor_10_50.convertResource(res, advisor);
    } else if (version.equals(Constants.VERSION) || "current".equals(version)) {
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        r = new XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        r = new JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt"))
        r = new StructureMapUtilities(context, null, null).parse(TextFile.bytesToString(content), fn);
      else if (fn.endsWith(".txt") || fn.endsWith(".map") )
        r = new org.hl7.fhir.r5.utils.StructureMapUtilities(null).parse(new String(content), fn);
      else
        throw new Exception("Unsupported format for "+fn);
    } else
      throw new Exception("Unsupported version "+version);
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
        binaries.put(prefix+"#"+e.getKey(), e.getValue());
    }
  }

  public void setQuestionnaires(List<String> questionnaires) {
  }

  public void setNative(boolean doNative) {
    this.doNative = doNative;
  }

  private class Content {
    byte[] focus = null;
    FhirFormat cntType = null;
  }
  
  public Content loadContent(String source, String opName) throws Exception {
    Map<String, byte[]> s = loadIgSource(source, false, false);
    Content res = new Content();
    if (s.size() != 1)
      throw new Exception("Unable to find resource " + source + " to "+opName);
    for (Entry<String, byte[]> t: s.entrySet()) {
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
        throw new Exception("Todo: Determining resource type is not yet done");
    }
    return res;
  }

  // testing entry point
  public OperationOutcome validate(FhirFormat format, InputStream stream, List<String> profiles) throws Exception {
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
          throw new Error("Unable to resolve profile "+p);
        }
        list.add(sd);
      }
    }
    return list;
  }
    
  public OperationOutcome validate(String source, List<String> profiles) throws Exception {
    List<String> l = new ArrayList<String>();
    l.add(source);
    return (OperationOutcome)validate(l, profiles);
  }
    
  public List<ScanOutputItem> validateScan(List<String> sources, Set<String> guides) throws Exception {
    List<String> refs = new ArrayList<String>();
    handleSources(sources, refs);
    
    List<ScanOutputItem> res = new ArrayList();
    InstanceValidator validator = getValidator();
    
    for (String ref : refs) {
      Content cnt = loadContent(ref, "validate");
      List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
      Element e = null;
      try {
        System.out.println("Validate "+ref);
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
          System.out.println("Check Guide "+ig.getUrl());
          String canonical = ig.getUrl().contains("/Impl") ? ig.getUrl().substring(0, ig.getUrl().indexOf("/Impl")) : ig.getUrl();
          String url = getGlobal(ig, rt);
          if (url != null) {
            try {
              System.out.println("Validate "+ref+" against "+ig.getUrl());
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
                  System.out.println("Validate "+ref+" against "+sd.getUrl());
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

  private Resource resolve(Reference reference) {
    return null;
  }

  private String getGlobal(ImplementationGuide ig, String rt) {
    for (ImplementationGuideGlobalComponent igg : ig.getGlobal()) {
      if (rt.equals(igg.getType()))
        return igg.getProfile();
    }
    return null;
  }

  public Resource validate(List<String> sources, List<String> profiles) throws Exception {
    List<String> refs = new ArrayList<String>();
    boolean asBundle = handleSources(sources, refs);
    Bundle results = new Bundle();
    results.setType(Bundle.BundleType.COLLECTION);
    for (String ref : refs) {
      Content cnt = loadContent(ref, "validate");
      if (refs.size() > 1)
        System.out.println("Validate "+ref);
      try {
        OperationOutcome outcome = validate(ref, cnt.focus, cnt.cntType, profiles);
        ToolingExtensions.addStringExtension(outcome, ToolingExtensions.EXT_OO_FILE, ref);
        if (refs.size() > 1)
          produceValidationSummary(outcome);
        results.addEntry().setResource(outcome);
      } catch (Exception e) {
        System.out.println("Validation Infrastructure fail validating "+ref+": "+e.getMessage());
        throw e;
      }
    }
    if (asBundle)
      return results;
    else
      return results.getEntryFirstRep().getResource();
  }
  
  private void produceValidationSummary(OperationOutcome oo) {
    for (OperationOutcomeIssueComponent iss : oo.getIssue()) {
      if (iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR || iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL) {
        System.out.println("  "+iss.getSeverity().toCode()+": "+iss.getDetails().getText());
      }
    } 
  }

  public OperationOutcome validateString(String location, String source, FhirFormat format, List<String> profiles) throws Exception {
    return validate(location, source.getBytes(), format, profiles);
  }

  // Public to allow reporting of results in alternate ways
  public boolean handleSources(List<String> sources, List<String> refs) throws IOException {
    boolean asBundle = sources.size() > 1;
    for (String source : sources) {
      if (handleSource(source, refs)) {
        asBundle = true;  // Code needs to be written this way to ensure handleSource gets called
      }
    }
    
    return asBundle;
  }
  
  private boolean handleSource(String name, List<String> refs) throws IOException {
    boolean isBundle = false;
    if (name.startsWith("https:") || name.startsWith("http:")) {
      refs.add(name);

    } else if (name.contains("*")) {
      isBundle = true;
      AsteriskFilter filter = new AsteriskFilter(name);
      File[] files = new File(filter.getDir()).listFiles(filter);
      for (int i=0; i < files.length; i++) {
        refs.add(files[i].getPath());
      }
    
    } else {
      File file = new File(name);

      if (!file.exists())
        throw new IOException("File " + name + " does not exist");
    
      if (file.isFile()) {
        refs.add(name);
        
      } else {
        isBundle = true;
        for (int i=0; i < file.listFiles().length; i++) {
          File[] fileList = file.listFiles();
          if (fileList[i].isFile())
            refs.add(fileList[i].getPath());
        }
      }
    }
    
    return isBundle;
  }

  public OperationOutcome validate(byte[] source, FhirFormat cntType, List<String> profiles) throws Exception {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    InstanceValidator validator = getValidator();
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return messagesToOutcome(messages);
  }

  public OperationOutcome validate(String location, byte[] source, FhirFormat cntType, List<String> profiles) throws Exception {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      if (cntType == FhirFormat.JSON)
        validateJsonSchema(location, messages);
      if (cntType == FhirFormat.XML)
        validateXmlSchema(location, messages);
      if (cntType == FhirFormat.TURTLE)
        validateSHEX(location, messages);
    }
    InstanceValidator validator = getValidator();
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return messagesToOutcome(messages);
  }

  public OperationOutcome validate(String location, byte[] source, FhirFormat cntType, List<String> profiles, IdStatus resourceIdRule, boolean anyExtensionsAllowed, BestPracticeWarningLevel bpWarnings, CheckDisplayOption displayOption) throws Exception {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (doNative) {
      if (cntType == FhirFormat.JSON)
        validateJsonSchema(location, messages);
      if (cntType == FhirFormat.XML)
        validateXmlSchema(location, messages);
      if (cntType == FhirFormat.TURTLE)
        validateSHEX(location, messages);
    }
    InstanceValidator validator = getValidator();
    validator.setResourceIdRule(resourceIdRule);
    validator.setBestPracticeWarningLevel(bpWarnings);
    validator.setCheckDisplay(displayOption);   
    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return messagesToOutcome(messages);
  }
  
  
  private void validateSHEX(String location, List<ValidationMessage> messages) {
    messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.INFORMATIONAL, location, "SHEX Validation is not done yet", IssueSeverity.INFORMATION));
  }

  private void validateXmlSchema(String location, List<ValidationMessage> messages) throws FileNotFoundException, IOException, SAXException {
    messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.INFORMATIONAL, location, "XML Schema Validation is not done yet", IssueSeverity.INFORMATION));
  }

  private Map<String, byte[]> loadSchemas() throws IOException {
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (Entry<String, byte[]> e : readZip(new ByteArrayInputStream(binaries.get("http://hl7.org/fhir#fhir-all-xsd.zip"))).entrySet()) {
      if (e.getKey().equals("fhir-single.xsd"))
        res.put(e.getKey(), e.getValue());
      if (e.getKey().equals("fhir-invariants.sch"))
        res.put(e.getKey(), e.getValue());
    }
    return res;
  }
  
  private Map<String, byte[]> loadTransforms() throws IOException {
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (Entry<String, byte[]> e : readZip(new ByteArrayInputStream(binaries.get("http://hl7.org/fhir#fhir-all-xsd.zip"))).entrySet()) {
      if (e.getKey().endsWith(".xsl"))
        res.put(e.getKey(), e.getValue());
    }
    return res;
  }

  private void validateJsonSchema(String location, List<ValidationMessage> messages) {
    messages.add(new ValidationMessage(Source.InstanceValidator, IssueType.INFORMATIONAL, location, "JSON Schema Validation is not done yet", IssueSeverity.INFORMATION));   
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
  
  private OperationOutcome exceptionToOutcome(Exception ex) throws DefinitionException {
    OperationOutcome op = new OperationOutcome();
    op.addIssue().setCode(org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXCEPTION).setSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL).getDetails().setText(ex.getMessage());
    new NarrativeGenerator("", "", context).generate(null, op);
    return op;
  }
  
  private OperationOutcome messagesToOutcome(List<ValidationMessage> messages) throws DefinitionException {
    OperationOutcome op = new OperationOutcome();
    for (ValidationMessage vm : filterMessages(messages)) {
      FHIRPathEngine fpe = new FHIRPathEngine(context);
      try {
        fpe.parse(vm.getLocation());
      } catch (Exception e) {
        System.out.println("Internal error in location for message: '"+e.getMessage()+"', loc = '"+vm.getLocation()+"', err = '"+vm.getMessage()+"'");
      }
      op.getIssue().add(OperationOutcomeUtilities.convertToIssue(vm, op));
    }
    new NarrativeGenerator("", "", context).generate(null, op);
    return op;
  }
  
  public static String issueSummary (OperationOutcomeIssueComponent issue) {
    String source = ToolingExtensions.readStringExtension(issue, ToolingExtensions.EXT_ISSUE_SOURCE);
    return issue.getSeverity().toString()+" @ "+issue.getLocation() + " " +issue.getDetails().getText() +(source != null ? " (src = "+source+")" : "");    
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(String source, String map) throws Exception {
    Content cnt = loadContent(source, "validate");
    return transform(cnt.focus, cnt.cntType, map);
  }
  
  public org.hl7.fhir.r5.elementmodel.Element transform(byte[] source, FhirFormat cntType, String mapUri) throws Exception {
    List<Base> outputs = new ArrayList<Base>();
    
    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs));
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context, new ByteArrayInputStream(source), cntType); 
    StructureMap map = context.getTransform(mapUri);
    if (map == null)
      throw new Error("Unable to find map "+mapUri+" (Known Maps = "+context.listMapUrls()+")");
    
    org.hl7.fhir.r5.elementmodel.Element resource = getTargetResourceFromStructureMap(map);
    scu.transform(null, src, map, resource);
    return resource;
  }

  private org.hl7.fhir.r5.elementmodel.Element getTargetResourceFromStructureMap(StructureMap map) {
    String targetTypeUrl = null;
    for(StructureMap.StructureMapStructureComponent component: map.getStructure()) {
      if(component.getMode() == StructureMap.StructureMapModelMode.TARGET) {
        targetTypeUrl = component.getUrl();
        break;
      }
    }

    if(targetTypeUrl == null)
      throw new FHIRException("Unable to determine resource URL for target type");

    StructureDefinition structureDefinition = null;
    for(StructureDefinition sd:this.context.getStructures()) {
      if(sd.getUrl().equalsIgnoreCase(targetTypeUrl)) {
        structureDefinition = sd;
        break;
      }
    }

    if(structureDefinition == null)
      throw new FHIRException("Unable to find StructureDefinition for target type ('"+targetTypeUrl+"')");
    
    return Manager.build(getContext(), structureDefinition);
  }

  public DomainResource generate(String source, String version) throws Exception {
    Content cnt = loadContent(source, "validate");
    Resource res = loadResourceByVersion(version, cnt.focus, source);
    new NarrativeGenerator("",  "", context).generate((DomainResource) res, null);
    return (DomainResource) res;
  }
  
  public void convert(String source, String output) throws Exception {
    Content cnt = loadContent(source, "validate");
    Element e = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);
    Manager.compose(context, e, new FileOutputStream(output), (output.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML), OutputStyle.PRETTY, null);
  }

  public String evaluateFhirPath(String source, String expression) throws Exception {
    Content cnt = loadContent(source, "validate");
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    Element e = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);
    return fpe.evaluateToString(e, expression);
  }

  public StructureDefinition snapshot(String source, String version) throws Exception {
    Content cnt = loadContent(source, "validate");
    Resource res = loadResourceByVersion(version, cnt.focus, Utilities.getFileNameForName(source));
   
    if (!(res instanceof StructureDefinition))
      throw new Exception("Require a StructureDefinition for generating a snapshot");
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

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public InstanceValidator getValidator() {
    InstanceValidator validator = new InstanceValidator(context, null);
    validator.setHintAboutNonMustSupport(hintAboutNonMustSupport);
    validator.setAnyExtensionsAllowed(anyExtensionsAllowed);
    validator.setNoInvariantChecks(isNoInvariantChecks());
    validator.setValidationLanguage(language);
    validator.setAssumeValidRestReferences(assumeValidRestReferences);
    validator.setNoExtensibleWarnings(noExtensibleBindingMessages);
    validator.getContext().setLocale(locale);
    validator.setFetcher(this);
    return validator;
  }

  public void setMapLog(String mapLog) throws FileNotFoundException {
    this.mapLog = new PrintWriter(mapLog);
  }

  public void prepare() {
    for (StructureDefinition sd : context.allStructures()) {
      try {
        makeSnapshot(sd);
      } catch (Exception e) {
        System.out.println("Process Note: Unable to generate snapshot for "+sd.present()+": "+e.getMessage());
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

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }

  public void genScanOutput(String folder, List<ScanOutputItem> items) throws IOException {
    String f = Utilities.path(folder, "comparison.zip");
    download("http://fhir.org/archive/comparison.zip", f);
    unzip(f, folder);

    for (int i = 0; i < items.size(); i++) {
      items.get(i).setId("c"+Integer.toString(i));
      genScanOutputItem(items.get(i), Utilities.path(folder, items.get(i).getId()+".html"));
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
      refs.add(item.ref);
      if (item.ig != null) {
        igs.add(item.ig.getUrl());
        if (!profiles.containsKey(item.ig.getUrl())) {
          profiles.put(item.ig.getUrl(), new HashSet<>());
        }
        if (item.profile != null)
          profiles.get(item.ig.getUrl()).add(item.profile.getUrl());
      }
    }

    b.append("<h2>By reference</h2>\r\n");
    b.append("<table class=\"grid\">");
    b.append("<tr><th></th><th></th>");
    for (String s : sorted(igs)) {
      ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, s);
      b.append("<th colspan=\""+Integer.toString(profiles.get(s).size()+1)+"\"><b title=\""+s+"\">"+ig.present()+"</b></th>");      
    }
    b.append("</tr>\r\n");
    b.append("<tr><th><b>Source</b></th><th><span>Core Spec</span></th>");
    for (String s : sorted(igs)) {
      ImplementationGuide ig = context.fetchResource(ImplementationGuide.class, s);
      b.append("<th><span>Global</span></th>");      
      for (String sp : sorted(profiles.get(s))) {
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, sp);
        b.append("<th><b title=\""+sp+"\"><span>"+sd.present()+"</span></b></th>");      
      }
    }
    b.append("</tr>\r\n");

    for (String s : sorted(refs)) {
      b.append("<tr>");
      b.append("<td>"+s+"</td>");
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
      b.append("<th><span>"+s+"</span></th>");      
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
      b.append("<td><b title=\""+si+"\">"+ig.present()+"</b></td>");      
      b.append("<td>Global</td>");      
      for (String s : sorted(refs)) {
        b.append(genOutcome(items, s, si, null));
      }
      b.append("</tr>\r\n");

      for (String sp : sorted(profiles.get(ig.getUrl()))) {
        b.append("<tr>");
        StructureDefinition sd = context.fetchResource(StructureDefinition.class, sp);
        b.append("<td></td><td><b title=\""+sp+"\">"+sd.present()+"</b></td>");      
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
      if (!t.ref.equals(src))
        match = false;
      if (!((ig == null && t.ig == null) || (ig != null && t.ig != null && ig.equals(t.ig.getUrl()))))
        match = false;
      if (!((profile == null && t.profile == null) || (profile != null && t.profile != null && profile.equals(t.profile.getUrl()))))
        match = false;
      if (match) {
        item = t;
        break;
      }
    }
      
    if (item == null)
      return "<td></td>";
    boolean ok = true;
    for (OperationOutcomeIssueComponent iss : item.outcome.getIssue()) {
      if (iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR || iss.getSeverity() == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL) {
        ok = false;
      }
    }
    if (ok) 
      return "<td style=\"background-color: #e6ffe6\"><a href=\""+item.getId()+".html\">\u2714</a></td>";
    else
      return "<td style=\"background-color: #ffe6e6\"><a href=\""+item.getId()+".html\">\u2716</a></td>";
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

  private void genScanOutputItem(ScanOutputItem item, String filename) throws IOException {
    NarrativeGenerator gen = new NarrativeGenerator("", "http://hl7.org/fhir", context);
    gen.setNoSlowLookup(true);
    gen.generate(null, item.outcome);
    String s = new XhtmlComposer(XhtmlComposer.HTML).compose(item.outcome.getText().getDiv());
    
    String title = item.getTitle();
    
    StringBuilder b = new StringBuilder();
    b.append("<html>");
    b.append("<head>");
    b.append("<title>"+title+"</title>");
    b.append("<link rel=\"stylesheet\" href=\"fhir.css\"/>\r\n");
    b.append("</head>");
    b.append("<body>");
    b.append("<h2>"+title+"</h2>");
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
    if (!url.startsWith("http://hl7.org/fhir")) {
      return ReferenceValidationPolicy.IGNORE;
    } else if (fetcher != null) {
      return fetcher.validationPolicy(appContext, path, url);
    } else {
      return ReferenceValidationPolicy.CHECK_EXISTS_AND_TYPE;      
    }
  }

  @Override
  public boolean resolveURL(Object appContext, String path, String url) throws IOException, FHIRException {
    if (!url.startsWith("http://hl7.org/fhir"))
      return true; // we don't bother with those.
    if (context.fetchResource(Resource.class, url) != null)
      return true;
    if (Utilities.existsInList(url, "http://hl7.org/fhir/sid/us-ssn", "http://hl7.org/fhir/sid/cvx", "http://hl7.org/fhir/sid/ndc", "http://hl7.org/fhir/sid/us-npi", "http://hl7.org/fhir/sid/icd-10", 
       "http://hl7.org/fhir/sid/icd-10-vn", "http://hl7.org/fhir/sid/icd-10-cm", "http://hl7.org/fhir/sid/icd-9-cm", "http://hl7.org/fhir/w5", "http://hl7.org/fhir/fivews", 
       "http://hl7.org/fhir/workflow", "http://hl7.org/fhir/ConsentPolicy/opt-out", "http://hl7.org/fhir/ConsentPolicy/opt-in")) {
      return true;
    }
    if (fetcher != null) {
      return fetcher.resolveURL(appContext, path, url);
    };
    return false;
  }

  @Override
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public void handleOutput(Resource r, String output, String version) throws Exception {
    if (output.startsWith("http://") || output.startsWith("http://")) {
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      handleOutputToStream(r, output, bs, version);
      URL url = new URL(output);
      HttpURLConnection c = (HttpURLConnection) url.openConnection();
      c.setDoOutput(true);
      c.setDoInput(true);
      c.setRequestMethod("POST");
      c.setRequestProperty( "Content-type", "application/fhir+xml");
      c.setRequestProperty( "Accept", "application/fhir+xml" );
      c.getOutputStream().write(bs.toByteArray());
      c.getOutputStream().close();

      if (c.getResponseCode() >= 300) {
//        String line;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
//        while ((line = reader.readLine()) != null) {
//          System.out.println(line);
//        }
//        reader.close();
        throw new IOException("Unable to PUT to "+output+": "+c.getResponseMessage());
      }
    } else {
      FileOutputStream s = new FileOutputStream(output);
      handleOutputToStream(r, output, s, version);
    }
  }

  private void handleOutputToStream(Resource r, String fn, OutputStream s, String version) throws Exception {
    if (fn.endsWith(".html") || fn.endsWith(".htm") && r instanceof DomainResource)
      new XhtmlComposer(XhtmlComposer.HTML, true).compose(s, ((DomainResource) r).getText().getDiv());
    else if (version.startsWith("3.0")) {
      org.hl7.fhir.dstu3.model.Resource res = VersionConvertor_30_50.convertResource(r, false);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu3.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu3.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map") )
        TextFile.stringToStream(org.hl7.fhir.dstu3.utils.StructureMapUtilities.render((org.hl7.fhir.dstu3.model.StructureMap) res), s, false);
      else
        throw new Exception("Unsupported format for "+fn);
    } else if (version.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource res = VersionConvertor_40_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map") )
        TextFile.stringToStream(org.hl7.fhir.r4.utils.StructureMapUtilities.render((org.hl7.fhir.r4.model.StructureMap) res), s, false);
      else
        throw new Exception("Unsupported format for "+fn);
    } else if (version.startsWith("1.4")) {
      org.hl7.fhir.dstu2016may.model.Resource res = VersionConvertor_14_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new Exception("Unsupported format for "+fn);
    } else if (version.startsWith("1.0")) {
      VersionConvertorAdvisor50 advisor = new org.hl7.fhir.convertors.IGR2ConvertorAdvisor5();
      org.hl7.fhir.dstu2.model.Resource res = VersionConvertor_10_50.convertResource(r, advisor);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new Exception("Unsupported format for "+fn);
    } else if (version.equals(Constants.VERSION)) {
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new XmlParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(s, r);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new JsonParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).compose(s, r);
      else if (fn.endsWith(".txt") || fn.endsWith(".map") )
        TextFile.stringToStream(org.hl7.fhir.r5.utils.StructureMapUtilities.render((org.hl7.fhir.r5.model.StructureMap) r), s, false);
      else
        throw new Exception("Unsupported format for "+fn);
    } else
      throw new Exception("Encounted unsupported configured version "+version+" loading "+fn);

    s.close();
  }

  public void setSnomedExtension(String sct) {
    context.getExpansionParameters().addParameter("system-version", "http://snomed.info/sct|http://snomed.info/sct/"+sct);
  }

  public IValidatorResourceFetcher getFetcher() {
    return fetcher;
  }

  public void setFetcher(IValidatorResourceFetcher fetcher) {
    this.fetcher = fetcher;
  }

  public void setAssumeValidRestReferences(boolean assumeValidRestReferences) {
    this.assumeValidRestReferences = assumeValidRestReferences;
  }

  public boolean isNoExtensibleBindingMessages() {
    return noExtensibleBindingMessages;
  }

  public void setNoExtensibleBindingMessages(boolean noExtensibleBindingMessages) {
    this.noExtensibleBindingMessages = noExtensibleBindingMessages;
  }

  public byte[] transformVersion(String source, String targetVer, FhirFormat format, Boolean canDoNative) throws FHIRException, IOException, Exception {
    Content cnt = loadContent(source, "validate");
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
          throw new Exception("Source version not supported yet: "+version);
        }
      } catch (Exception e) {
        System.out.println("Conversion failed using Java convertor: "+e.getMessage());
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
      throw new Error("Unable to find map "+url+" (Known Maps = "+context.listMapUrls()+")");
    org.hl7.fhir.r5.elementmodel.Element resource = getTargetResourceFromStructureMap(map);
    scu.transform(null, src, map, resource);
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    Manager.compose(context, resource, bs, format, OutputStyle.PRETTY, null);
    return bs.toByteArray();
  }
  
  private String getMapId(String type, String targetVer) {
    if (VersionUtilities.isR2Ver(version)) {
      if (VersionUtilities.isR3Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/"+type+"2to3";
      }
    } else if (VersionUtilities.isR3Ver(version)) {
      if (VersionUtilities.isR2Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/"+type+"3to2";
      } else if (VersionUtilities.isR4Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/"+type+"3to4";
      }
    } else if (VersionUtilities.isR4Ver(version)) {
      if (VersionUtilities.isR3Ver(targetVer)) {
        return "http://hl7.org/fhir/StructureMap/"+type+"4to3";
      }
    }
    throw new FHIRException("Source/Target version not supported: "+version+" -> "+targetVer);
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
      throw new FHIRException("Unsupported input format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
      }
    } else {
      throw new Exception("Target Version not supported yet: "+targetVer);
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
      throw new FHIRException("Unsupported input format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
      }
    } else {
      throw new Exception("Target Version not supported yet: "+targetVer);
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
      throw new FHIRException("Unsupported input format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
      }
    } else {
      throw new Exception("Target Version not supported yet: "+targetVer);
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
      throw new FHIRException("Unsupported input format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
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
        throw new FHIRException("Unsupported output format: "+cnt.cntType.toString());
      }
    } else {
      throw new Exception("Target Version not supported yet: "+targetVer);
    }
  }
  
}