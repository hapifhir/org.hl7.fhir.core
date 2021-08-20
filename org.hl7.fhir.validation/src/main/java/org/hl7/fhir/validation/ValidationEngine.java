package org.hl7.fhir.validation;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext.ICanonicalResourceLocator;
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
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.r5.utils.IResourceValidator.*;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.validation.BaseValidator.ValidationControl;
import org.hl7.fhir.validation.cli.services.IPackageInstaller;
import org.hl7.fhir.validation.cli.utils.*;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.ValidatorHostContext;
import org.xml.sax.SAXException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

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
@Accessors(chain = true)
public class ValidationEngine implements IValidatorResourceFetcher, IPackageInstaller {

  @Getter @Setter private SimpleWorkerContext context;
  @Getter @Setter private Map<String, byte[]> binaries = new HashMap<>();
  @Getter @Setter private boolean doNative;
  @Getter @Setter private boolean noInvariantChecks;
  @Getter @Setter private boolean wantInvariantInMessage;
  @Getter @Setter private boolean hintAboutNonMustSupport;
  @Getter @Setter private boolean anyExtensionsAllowed = false;
  @Getter @Setter private String version;
  @Getter @Setter private String language;
  @Setter private FilesystemPackageCacheManager pcm;
  @Getter @Setter private PrintWriter mapLog;
  @Getter @Setter private boolean debug = false;
  @Getter @Setter private IValidatorResourceFetcher fetcher;
  @Getter @Setter private ICanonicalResourceLocator locator;
  @Getter @Setter private boolean assumeValidRestReferences;
  @Getter @Setter private boolean noExtensibleBindingMessages;
  @Getter @Setter private boolean securityChecks;
  @Getter @Setter private boolean crumbTrails;
  @Getter @Setter private boolean allowExampleUrls;
  @Getter @Setter private boolean showMessagesFromReferences;
  @Getter @Setter private Locale locale;
  @Getter @Setter private List<ImplementationGuide> igs = new ArrayList<>();
  @Getter @Setter private boolean showTimes;
  @Getter @Setter private List<BundleValidationRule> bundleValidationRules = new ArrayList<>();
  @Getter @Setter private QuestionnaireMode questionnaireMode;
  @Getter @Setter private FHIRPathEngine fhirPathEngine;
  @Getter @Setter private IgLoader igLoader;

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
  @Getter @Setter private Map<String, ValidationControl> validationControl = new HashMap<>();

  public ValidationEngine() throws IOException {
    setContext(SimpleWorkerContext.fromNothing());
    initContext(null);
    igLoader = new IgLoader(getPcm(), getContext(), getVersion(), isDebug());
  }

  public ValidationEngine(String src) throws FHIRException, IOException {
    loadCoreDefinitions(src, false, null);
    igLoader = new IgLoader(getPcm(), getContext(), getVersion(), isDebug());
  }

  public ValidationEngine(String src, String txsrvr, String txLog, FhirPublication version, boolean canRunWithoutTerminologyServer, String vString) throws FHIRException, IOException, URISyntaxException {
    loadCoreDefinitions(src, false, null);
    getContext().setCanRunWithoutTerminology(canRunWithoutTerminologyServer);
    setTerminologyServer(txsrvr, txLog, version);
    setVersion(vString);
    igLoader = new IgLoader(getPcm(), getContext(), getVersion(), isDebug());
  }

  public ValidationEngine(String src, String txsrvr, String txLog, FhirPublication version, String vString) throws FHIRException, IOException, URISyntaxException {
    loadCoreDefinitions(src, false, null);
    setTerminologyServer(txsrvr, txLog, version);
    setVersion(vString);
    igLoader = new IgLoader(getPcm(), getContext(), getVersion(), isDebug());
  }

  public ValidationEngine(String src, String vString, TimeTracker tt) throws FHIRException, IOException, URISyntaxException {
    loadCoreDefinitions(src, false, tt);
    setVersion(vString);
    igLoader = new IgLoader(getPcm(), getContext(), getVersion(), isDebug());
  }

  private void loadCoreDefinitions(String src, boolean recursive, TimeTracker tt) throws FHIRException, IOException {
    NpmPackage npm = getPcm().loadPackage(src, null);
    if (npm != null) {
      version = npm.fhirVersion();
      context = SimpleWorkerContext.fromPackage(npm, ValidatorUtils.loaderForVersion(version));
    } else {
      Map<String, byte[]> source = igLoader.loadIgSource(src, recursive, true);
      if (version == null) {
        version = getVersionFromPack(source);
      }
      context = SimpleWorkerContext.fromDefinitions(source, ValidatorUtils.loaderForVersion(version), new PackageVersion(src));
      ValidatorUtils.grabNatives(getBinaries(), source, "http://hl7.org/fhir");
    }
    initContext(tt);
  }

  public void initContext(TimeTracker tt) throws IOException {
    context.setCanNoTS(true);
    context.setCacheId(UUID.randomUUID().toString());
    context.setAllowLoadingDuplicates(true); // because of Forge
    context.setExpansionProfile(makeExpProfile());
    if (tt != null) {
      context.setClock(tt);
    }
    NpmPackage npmX = getPcm().loadPackage("hl7.fhir.xver-extensions", "0.0.4");
    context.loadFromPackage(npmX, null);

    this.fhirPathEngine = new FHIRPathEngine(context);
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

  public String connectToTSServer(String url, String log, FhirPublication version) throws URISyntaxException, FHIRException {
    context.setTlogging(false);
    if (url == null) {
      context.setCanRunWithoutTerminology(true);
      context.setNoTerminologyServer(true);
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

  // testing entry point
  public OperationOutcome validate(FhirFormat format, InputStream stream, List<String> profiles) throws FHIRException, IOException, EOperationOutcome {
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    InstanceValidator validator = getValidator();
    validator.validate(null, messages, stream, format, asSdList(profiles));
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
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

  public Resource validate(List<String> sources, List<String> profiles, List<ValidationRecord> record) throws FHIRException, IOException {
    if (profiles.size() > 0) {
      System.out.println("  Profiles: " + profiles);
    }
    List<String> refs = new ArrayList<String>();
    boolean asBundle = ValidatorUtils.parseSources(sources, refs, context);
    Bundle results = new Bundle();
    results.setType(Bundle.BundleType.COLLECTION);
    for (String ref : refs) {
      TimeTracker.Session tts = context.clock().start("validation");
      context.clock().milestone();
      System.out.print("  Validate " + ref);
      Content cnt = igLoader.loadContent(ref, "validate", false);
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

  public OperationOutcome validate(byte[] source, FhirFormat cntType, List<String> profiles, List<ValidationMessage> messages) throws FHIRException, IOException, EOperationOutcome {
    InstanceValidator validator = getValidator();

    validator.validate(null, messages, new ByteArrayInputStream(source), cntType, asSdList(profiles));
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
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
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
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
    return ValidatorUtils.messagesToOutcome(messages, context, fhirPathEngine);
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(String source, String map) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false);
    return transform(cnt.focus, cnt.cntType, map);
  }

  public org.hl7.fhir.r5.elementmodel.Element transform(byte[] source, FhirFormat cntType, String mapUri) throws FHIRException, IOException {
    List<Base> outputs = new ArrayList<>();
    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs, mapLog, context));
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context, new ByteArrayInputStream(source), cntType);
    StructureMap map = context.getTransform(mapUri);
    if (map == null) throw new Error("Unable to find map " + mapUri + " (Known Maps = " + context.listMapUrls() + ")");
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

    if (targetTypeUrl == null) throw new FHIRException("Unable to determine resource URL for target type");

    StructureDefinition structureDefinition = null;
    for (StructureDefinition sd : this.context.getStructures()) {
      if (sd.getUrl().equalsIgnoreCase(targetTypeUrl)) {
        structureDefinition = sd;
        break;
      }
    }

    if (structureDefinition == null) throw new FHIRException("Unable to find StructureDefinition for target type ('" + targetTypeUrl + "')");

    return Manager.build(getContext(), structureDefinition);
  }

  public Resource generate(String source, String version) throws FHIRException, IOException, EOperationOutcome {
    Content cnt = igLoader.loadContent(source, "validate", false);
    Resource res = igLoader.loadResourceByVersion(version, cnt.focus, source);
    RenderingContext rc = new RenderingContext(context, null, null, "http://hl7.org/fhir", "", null, ResourceRendererMode.RESOURCE);
    genResource(res, rc);
    return (Resource) res;
  }

  public void genResource(Resource res, RenderingContext rc) throws IOException, EOperationOutcome {
    if (res instanceof Bundle) {
      Bundle bnd = (Bundle) res;
      for (BundleEntryComponent be : bnd.getEntry()) {
        if (be.hasResource()) {
          genResource(be.getResource(), rc);
        }
      }
    } else {
      RendererFactory.factory(res, rc).render((DomainResource) res);
    }
  }

  public void convert(String source, String output) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false);
    Element e = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);
    Manager.compose(context, e, new FileOutputStream(output), (output.endsWith(".json") ? FhirFormat.JSON : FhirFormat.XML), OutputStyle.PRETTY, null);
  }

  public String evaluateFhirPath(String source, String expression) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false);
    FHIRPathEngine fpe = this.getValidator().getFHIRPathEngine();
    Element e = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);
    ExpressionNode exp = fpe.parse(expression);
    return fpe.evaluateToString(new ValidatorHostContext(context, e), e, e, e, exp);
  }

  public StructureDefinition snapshot(String source, String version) throws FHIRException, IOException {
    Content cnt = igLoader.loadContent(source, "validate", false);
    Resource res = igLoader.loadResourceByVersion(version, cnt.focus, Utilities.getFileNameForName(source));

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
    validator.setWantInvariantInMessage(isWantInvariantInMessage());
    validator.setValidationLanguage(language);
    if (language != null) {
      validator.getContext().setValidationMessageLanguage(Locale.forLanguageTag(language));
    }
    validator.setAssumeValidRestReferences(assumeValidRestReferences);
    validator.setNoExtensibleWarnings(noExtensibleBindingMessages);
    validator.setSecurityChecks(securityChecks);
    validator.setCrumbTrails(crumbTrails);
    validator.setAllowExamples(allowExampleUrls);
    validator.setShowMessagesFromReferences(showMessagesFromReferences);
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
//        if (debug) {
          e.printStackTrace();
//        }
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

  public void handleOutput(Resource r, String output, String version) throws FHIRException, IOException {
    if (output.startsWith("http://")) {
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
      org.hl7.fhir.dstu3.model.Resource res = VersionConvertorFactory_30_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu3.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu3.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu3.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        TextFile.stringToStream(org.hl7.fhir.dstu3.utils.StructureMapUtilities.render((org.hl7.fhir.dstu3.model.StructureMap) res), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource res = VersionConvertorFactory_40_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".txt") || fn.endsWith(".map"))
        TextFile.stringToStream(org.hl7.fhir.r4.utils.StructureMapUtilities.render((org.hl7.fhir.r4.model.StructureMap) res), s, false);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.startsWith("1.4")) {
      org.hl7.fhir.dstu2016may.model.Resource res = VersionConvertorFactory_14_50.convertResource(r);
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        new org.hl7.fhir.dstu2016may.formats.XmlParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        new org.hl7.fhir.dstu2016may.formats.JsonParser().setOutputStyle(org.hl7.fhir.dstu2016may.formats.IParser.OutputStyle.PRETTY).compose(s, res);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else if (version.startsWith("1.0")) {
      org.hl7.fhir.dstu2.model.Resource res = VersionConvertorFactory_10_50.convertResource(r, new org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor5());
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
    Content cnt = igLoader.loadContent(source, "validate", false);
    org.hl7.fhir.r5.elementmodel.Element src = Manager.parse(context, new ByteArrayInputStream(cnt.focus), cnt.cntType);

    // if the src has a url, we try to use the java code 
    if ((canDoNative == null && src.hasChild("url")) || (canDoNative != null && canDoNative)) {
      try {
        if (VersionUtilities.isR2Ver(version)) {
          return VersionConvertor.convertVersionNativeR2(targetVer, cnt, format);
        } else if (VersionUtilities.isR2BVer(version)) {
          return VersionConvertor.convertVersionNativeR2b(targetVer, cnt, format);
        } else if (VersionUtilities.isR3Ver(version)) {
          return VersionConvertor.convertVersionNativeR3(targetVer, cnt, format);
        } else if (VersionUtilities.isR4Ver(version)) {
          return VersionConvertor.convertVersionNativeR4(targetVer, cnt, format);
        } else {
          throw new FHIRException("Source version not supported yet: " + version);
        }
      } catch (Exception e) {
        System.out.println("Conversion failed using Java convertor: " + e.getMessage());
      }
    }
    // ok, we try converting using the structure maps
    System.out.println("Loading hl7.fhir.xver.r4");
    igLoader.loadIg(getIgs(), getBinaries(), "hl7.fhir.xver.r4", false);
    String type = src.fhirType();
    String url = getMapId(type, targetVer);
    List<Base> outputs = new ArrayList<Base>();
    StructureMapUtilities scu = new StructureMapUtilities(context, new TransformSupportServices(outputs, mapLog, context));
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

  public String setTerminologyServer(String src, String log, FhirPublication version) throws FHIRException, URISyntaxException {
    return connectToTSServer(src, log, version);
  }

  public ValidationEngine setMapLog(String mapLog) throws FileNotFoundException {
    if (mapLog != null) {
      this.mapLog = new PrintWriter(mapLog);
    }
    return this;
  }

  public ValidationEngine setSnomedExtension(String sct) {
    getContext().getExpansionParameters().addParameter("system-version", "http://snomed.info/sct|http://snomed.info/sct/" + sct);
    return this;
  }

  public FilesystemPackageCacheManager getPcm() throws IOException {
    if (pcm == null) {
      //System.out.println("Creating Package manager?");
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    }
    return pcm;
  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String source) throws IOException {
    URL url = new URL(source);
    URLConnection c = url.openConnection();
    return TextFile.streamToBytes(c.getInputStream());
  }

  @Override
  public boolean packageExists(String id, String ver) throws IOException, FHIRException {
    return getPcm().packageExists(id, ver);
  }

  @Override
  public void loadPackage(String id, String ver) throws IOException, FHIRException {
    igLoader.loadIg(getIgs(), getBinaries(),id + (ver == null ? "" : "#" + ver), true);
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRException, IOException {
    Resource resource = context.fetchResource(Resource.class, url);
    if (resource != null) {
      return new ObjectConverter(context).convert(resource);
    }
    if (fetcher != null) {
      return fetcher.fetch(validator, appContext, url);
    }
    return null;
  }

  @Override
  public ReferenceValidationPolicy validationPolicy(IResourceValidator validator, Object appContext, String path, String url) {
    Resource resource = context.fetchResource(StructureDefinition.class, url);
    if (resource != null) {
      return ReferenceValidationPolicy.CHECK_VALID;
    }
    if (!(url.contains("hl7.org") || url.contains("fhir.org"))) {
      return ReferenceValidationPolicy.IGNORE;
    } else if (fetcher != null) {
      return fetcher.validationPolicy(validator, appContext, path, url);
    } else {
      return ReferenceValidationPolicy.CHECK_EXISTS_AND_TYPE;
    }
  }

  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type) throws IOException, FHIRException {
    if (!url.startsWith("http://") && !url.startsWith("https://")) { // ignore these
      return true;
    }
    if (context.fetchResource(Resource.class, url) != null)
      return true;
    if (SIDUtilities.isKnownSID(url) || 
        Utilities.existsInList(url, "http://hl7.org/fhir/w5", "http://hl7.org/fhir/fivews", "http://hl7.org/fhir/workflow", "http://hl7.org/fhir/ConsentPolicy/opt-out", "http://hl7.org/fhir/ConsentPolicy/opt-in")) {
      return true;
    }
    if (Utilities.existsInList(url, "http://loinc.org", "http://unitsofmeasure.org", "http://snomed.info/sct")) {
      return true;
    }
    if (url.contains("example.org") || url.contains("acme.com")) {
      return false; // todo... how to access settings from here?
    }
    if (fetcher != null) {
      try {
        return fetcher.resolveURL(validator, appContext, path, url, type);
      } catch (Exception e) {
        return false;
      }
    }
    return false;
  }

  @Override
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, String url) throws URISyntaxException {
    Resource res = context.fetchResource(Resource.class, url);
    if (res != null) {
      if (res instanceof CanonicalResource) {
        return (CanonicalResource) res;
      } else {
        return null;
      }
    }
    return fetcher != null ? fetcher.fetchCanonicalResource(validator, url) : null;
  }

  @Override
  public boolean fetchesCanonicalResource(IResourceValidator validator, String url) {
    return fetcher != null && fetcher.fetchesCanonicalResource(validator, url);
  }
}