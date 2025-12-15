package org.hl7.fhir.validation.tests;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.convertors.factory.*;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.IHostApplicationServices;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.r5.terminologies.utilities.SnomedUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManagerFactory;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.tests.CacheVerificationLogger;
import org.hl7.fhir.utilities.validation.IDigitalSignatureServices;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.IgLoader.IDirectPackageProvider;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.instance.scoring.*;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.StandAloneValidatorFetcher;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.InstanceValidator.MatchetypeStatus;
import org.hl7.fhir.validation.instance.MatchetypeValidator;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.instance.advisor.JsonDrivenPolicyAdvisor;
import org.hl7.fhir.validation.instance.advisor.TextDrivenPolicyAdvisor;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Charsets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.BeforeClass;

@RunWith(Parameterized.class)
public class ValidationTests implements IHostApplicationServices, IValidatorResourceFetcher, IValidationPolicyAdvisor, IDigitalSignatureServices, IDirectPackageProvider {

  public class TestSorter implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
      return 0;
    }

  }

  public final static boolean PRINT_OUTPUT_TO_CONSOLE = true;
  private static final boolean CLONE = true;
  private static final boolean BUILD_NEW = false;
  private static final boolean REVISING_TEST_CASES = false;

  @Parameters(name = "{0} (#{index})")
  public static Iterable<Object[]> data() throws IOException {
    String contents = TestingUtilities.loadTestResource("validator", "manifest.json");

    Map<String, JsonObject> examples = new HashMap<String, JsonObject>();
    manifest = (JsonObject) new com.google.gson.JsonParser().parse(contents);
    thoVersion = manifest.getAsJsonObject("versions").get("terminology").getAsString();
    extensionsVersion = manifest.getAsJsonObject("versions").get("extensions").getAsString();
    for (JsonElement e : manifest.getAsJsonArray("test-cases")) {
      JsonObject o = (JsonObject) e;
      String name = JsonUtilities.str(o, "name");
      String version = JsonUtilities.str(o, "version");
      if (version == null) {
        version = "5.0.0";
      }
      examples.put(VersionUtilities.getNameForVersion(version) + "." + name, o);
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Object[]> objects = new ArrayList<Object[]>(examples.size());
    for (String id : names) {
      objects.add(new Object[]{id, examples.get(id)});
    }
    return objects;
  }

  private static JsonObject manifest;
  private JsonObject content;
  private String version;
  private String name;
  private Map<String, String> packageMap = new HashMap<String, String>();


  private static ValidationEngine currentEngine;
  private ValidationEngine vCurr;
  private String outputFolder;
  private static String thoVersion;
  private static String extensionsVersion;
  private static String currentVersion;
  private static IgLoader igLoader;

  public ValidationTests(String name, JsonObject content) throws IOException {
    this.name = name;
    this.content = content;
    this.outputFolder = Utilities.path("[tmp]", "validator", "validation-output");
    FileUtilities.createDirectory(outputFolder);
  }

  @BeforeClass
  public static void beforeClass() {
    ManagedWebAccess.loadFromFHIRSettings();
  }

  @AfterAll
  public void cleanup() {
    currentEngine = null;
    vCurr = null;
    igLoader = null;
    manifest = null;
    System.gc();
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    TestingUtilities.injectCorePackageLoader();

    CacheVerificationLogger logger = new CacheVerificationLogger();
//    SHLParser.setTestMode(true);
    long setup = System.nanoTime();

    logOutput("---- " + name + " ---------------------------------------------------------------- (" + System.getProperty("java.vm.name") + ")");
    logOutput("** Core: ");
    String txLog = null;
    if (content.has("txLog")) {
      txLog = content.get("txLog").getAsString();
    }
    version = "5.0";
    List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
    if (content.has("version")) {
      version = content.get("version").getAsString();
    }

    version = VersionUtilities.getMajMin(version);
    if (!version.equals(currentVersion)) {
      currentEngine = buildVersionEngine(version, txLog);
      currentVersion = version;
    }
    vCurr = CLONE ? new ValidationEngine(currentEngine) : currentEngine;
    vCurr.getContext().getTxClientManager().getMasterClient().setLogger(logger);
    igLoader = new IgLoader(vCurr.getPcm(), vCurr.getContext(), vCurr.getVersion(), true);
    igLoader.setDirectProvider(this);

    if (content.has("close-up")) {
      File newManifestFile = ManagedFileAccess.file(Utilities.path("[tmp]", "validator", "manifest.new.json"));
      if (!newManifestFile.getParentFile().exists()) {
        newManifestFile.getParentFile().mkdir();
      }
      JsonTrackingParser.write(manifest, newManifestFile);

      cleanup();
      Assertions.assertTrue(true);
      return;
    }
    if (content.has("use-test") && !content.get("use-test").getAsBoolean()) {
      return;
    }
    byte[] testCaseContent = TestingUtilities.loadTestResource("validator", JsonUtilities.str(content, "file")).getBytes(StandardCharsets.UTF_8);
    // load and process content    
    FhirFormat fmt = determineFormat(content, testCaseContent);
    if (fmt == null) {
      throw new FHIRException("Unknown format in source " + JsonUtilities.str(content, "file"));
    }

    if (!content.has("module")) {
      throw new FHIRException("A module is required");
    }
    InstanceValidator val = vCurr.getValidator(fmt);
    val.setWantCheckSnapshotUnchanged(true);
    val.getContext().setClientRetryCount(4);
    val.setBestPracticeWarningLevel(BestPracticeWarningLevel.Ignore);
    val.getSettings().setDebug(false);
    if (!VersionUtilities.isR5Plus(val.getContext().getVersion())) {
      val.getSettings().setUseValueSetDisplays(true);
    }
    if (content.has("language")) {
      val.getSettings().setLanguages(content.get("language").getAsString());
      val.setValidationLanguage(val.getSettings().getLanguages().getChosen());
    } else {
      val.getSettings().setLanguages(null);
      val.setValidationLanguage(null);
    }
    if (content.has("certificate")) {
      val.getSettings().getCertificates().put(content.get("certificate").getAsString(), TestingUtilities.loadTestResourceBytes("validator", content.get("certificate").getAsString()));
    }

    if (content.has("sct")) {
      vCurr.setSnomedExtension(SnomedUtilities.getCodeFromAlias(content.get("sct").getAsString()));
    } else {
      vCurr.setSnomedExtension(null);
    }
    if (content.has("fetcher") && "standalone".equals(JsonUtilities.str(content, "fetcher"))) {
      val.setFetcher(vCurr);
      vCurr.setFetcher(new StandAloneValidatorFetcher(vCurr.getPcm(), vCurr.getContext(), vCurr));
    } else {
      val.setFetcher(this);
    }

    if (!content.has("advisor")) {
      val.setPolicyAdvisor(this);
    } else {
      String fn = content.get("advisor").getAsString();
      String cnt = TestingUtilities.loadTestResource("validator", fn);
      if (fn.endsWith(".json")) {
        val.setPolicyAdvisor(new JsonDrivenPolicyAdvisor(this, fn, cnt));
      } else {
        val.setPolicyAdvisor(new TextDrivenPolicyAdvisor(this, fn, cnt));
      }
    }

    if (content.has("wrong-displays"))
      val.getSettings().setDisplayWarningMode("warning".equals(content.get("wrong-displays").getAsString()));
    if (content.has("allowed-extension-domain"))
      val.getExtensionDomains().add(content.get("allowed-extension-domain").getAsString());
    if (content.has("allowed-extension-domains"))
      for (JsonElement a : content.getAsJsonArray("allowed-extension-domains"))
        val.getExtensionDomains().add(a.getAsString());
    val.setForPublication(content.has("for-publication") && "true".equals(content.get("for-publication").getAsString()));
    if (content.has("default-version")) {
      val.getSettings().setVersionFlexible(content.get("default-version").getAsBoolean());
    } else {
      val.getSettings().setVersionFlexible(false);
    }
    if (content.has("no-tx")) {
      boolean notx = "true".equals(content.get("no-tx").getAsString());
      ((SimpleWorkerContext) val.getContext()).setCanRunWithoutTerminology(notx);
      ((SimpleWorkerContext) val.getContext()).setNoTerminologyServer(notx);
      ((SimpleWorkerContext) val.getContext()).setCachingAllowed(!notx);

    }
    packageMap.clear();
    if (content.has("package-map")) {
      for (Entry<String, JsonElement> e : content.getAsJsonObject("package-map").entrySet()) {
        packageMap.put(e.getKey(), e.getValue().getAsString());
      }
    }
    if (content.has("packages")) {
      for (JsonElement e : content.getAsJsonArray("packages")) {
        String n = e.getAsString();
        logOutput("load package " + n);
        InputStream cnt = n.endsWith(".tgz") ? TestingUtilities.loadTestResourceStream("validator", n) : null;
        if (cnt != null) {
          igLoader.loadPackage(NpmPackage.fromPackage(cnt), true);
        } else {
          igLoader.loadIg(vCurr.getIgs(), vCurr.getBinaries(), n, true);
        }
      }
    }
    if (content.has("crumb-trail")) {
      val.setCrumbTrails(content.get("crumb-trail").getAsBoolean());
    }
    if (content.has("supporting")) {
      for (JsonElement e : content.getAsJsonArray("supporting")) {
        String filename = e.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
        logOutput("load resource " + mr.getUrl());
        val.getContext().getManager().cacheResource(mr);
        if (mr instanceof ImplementationGuide) {
          val.getImplementationGuides().add((ImplementationGuide) mr);
        }
      }
    }
    if (content.has("supporting5")) {
      for (JsonElement e : content.getAsJsonArray("supporting5")) {
        String filename = e.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        CanonicalResource mr = (CanonicalResource) loadResource(filename, contents, "5.0.0");
        logOutput("load resource " + mr.getUrl());
        val.getContext().getManager().cacheResource(mr);
        if (mr instanceof ImplementationGuide) {
          val.getImplementationGuides().add((ImplementationGuide) mr);
        }
      }
    }
    val.getBundleValidationRules().clear();
    if (content.has("bundle-param")) {
      val.getBundleValidationRules().add(new BundleValidationRule().setRule(content.getAsJsonObject("bundle-param").get("rule").getAsString()).setProfile(content.getAsJsonObject("bundle-param").get("profile").getAsString()));
    }
    if (content.has("profiles")) {
      for (JsonElement je : content.getAsJsonArray("profiles")) {
        String filename = je.getAsString();
        String contents = TestingUtilities.loadTestResource("validator", filename);
        StructureDefinition sd = loadProfile(filename, contents, messages, val.getSettings().isDebug(), val.getContext());
        logOutput("load resource " + sd.getUrl());
        val.getContext().getManager().cacheResource(sd);
      }
    }
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    if (content.has("debug")) {
      val.getSettings().setDebug(content.get("debug").getAsBoolean());
    } else {
      val.getSettings().setDebug(false);
    }

    StructureDefinition sd = null;
    if (content.has("ips")) {
      val.setCheckIPSCodes(true);
      val.getContext().getManager().loadFromPackage(loadPackage("hl7.fhir.uv.ips#1.1.0"), ValidatorUtils.loaderForVersion("4.0.1"));
      if (content.get("ips").getAsString().equals("uv")) {
        sd = val.getContext().fetchResource(StructureDefinition.class, "http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
        val.getBundleValidationRules().add(new BundleValidationRule().setRule("Composition:0").setProfile("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips"));
      } else if (content.get("ips").getAsString().equals("au")) {
        val.getContext().getManager().loadFromPackage(loadPackage("hl7.fhir.au.base#current"), ValidatorUtils.loaderForVersion("4.0.1"));
        val.getContext().getManager().loadFromPackage(loadPackage("hl7.fhir.au.core#current"), ValidatorUtils.loaderForVersion("4.0.1"));
        val.getContext().getManager().loadFromPackage(loadPackage("hl7.fhir.au.ips#current"), ValidatorUtils.loaderForVersion("4.0.1"));
        sd = val.getContext().fetchResource(StructureDefinition.class, "http://hl7.org.au/fhir/ips/StructureDefinition/Bundle-au-ips");
        val.getBundleValidationRules().add(new BundleValidationRule().setRule("Composition:0").setProfile("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips"));
      } else if (content.get("ips").getAsString().equals("nz")) {
        val.getContext().getManager().loadFromPackage(loadPackage("tewhatuora.fhir.nzps#current"), ValidatorUtils.loaderForVersion("4.0.1"));
        sd = val.getContext().fetchResource(StructureDefinition.class, "https://standards.digital.health.nz/fhir/StructureDefinition/nzps-bundle");
        val.getBundleValidationRules().add(new BundleValidationRule().setRule("Composition:0").setProfile("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips"));
      } else {
        throw new Error("Unknown IPS " + content.get("ips").getAsString());
      }
    }
    if (content.has("best-practice")) {
      val.setBestPracticeWarningLevel(BestPracticeWarningLevel.valueOf(content.get("best-practice").getAsString()));
    }
    if (content.has("allow-comments")) {
      val.setAllowComments(content.get("allow-comments").getAsBoolean());
    }
    if (content.has("examples")) {
      val.setAllowExamples(content.get("examples").getAsBoolean());
    } else {
      val.setAllowExamples(true);
    }
    if (content.has("security-checks")) {
      val.setSecurityChecks(content.get("security-checks").getAsBoolean());
    }
    if (content.has("r5-bundle-relative-reference-policy")) {
      val.getSettings().setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.fromCode(content.get("r5-bundle-relative-reference-policy").getAsString()));
    }
    if (content.has("no-experimental-content")) {
      val.setNoExperimentalContent(content.get("no-experimental-content").getAsBoolean());
    }
    if (content.has("noHtmlInMarkdown")) {
      val.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.ERROR);
    }
    if (content.has("new-xver-mode")) {
      XVerExtensionManagerFactory.setNewLoader(true);
    }

    XVerExtensionManager xv = XVerExtensionManagerFactory.createExtensionManager(val.getContext());
    ((SimpleWorkerContext) val.getContext()).setXVerManager(xv);
    val.setXverManager(xv);
    JsonObject mtInfo = null;

    if (content.has("matchetype")) {
      if (content.get("matchetype").isJsonPrimitive()) {
        val.setMatchetypeStatus(MatchetypeStatus.Required);
      } else {
        mtInfo = content.getAsJsonObject("matchetype");
      }
    }
    List<String> suppress = new ArrayList<>();
    if (content.has("suppress")) {
      for (JsonElement c : content.getAsJsonArray("suppress")) {
        suppress.add(c.getAsString());
      }
    }

    val.setSignatureServices(this);
    if (content.has("logical") == false) {
      val.setAssumeValidRestReferences(content.has("assumeValidRestReferences") ? content.get("assumeValidRestReferences").getAsBoolean() : false);
      logOutput(String.format("Start Validating (%d to set up)", (System.nanoTime() - setup) / 1000000));
      Element res = val.validate(null, errors, new ByteArrayInputStream(testCaseContent), fmt);
      logOutput(val.reportTimes());
      checkOutcomes(errors, content, "base", null, name, suppress);
      moveOutcomes(content, name, "base");

      if (mtInfo != null) {
        System.out.print("** Matchetype: ");
        byte[] cnt = TestingUtilities.loadTestResourceBytes("validator", mtInfo.get("source").getAsString());
        Element exp = Manager.parseSingle(val.getContext(), new ByteArrayInputStream(cnt), fmt);
        MatchetypeValidator mv = new MatchetypeValidator(val.getFHIRPathEngine());
        List<ValidationMessage> mtErrors = new ArrayList<ValidationMessage>();
        mv.compare(mtErrors, "$", exp, res);
        checkOutcomes(mtErrors, mtInfo, "matchetype", null, name, suppress);
      }
      if (content.has("scoring")) {
        JsonObject scoring = content.getAsJsonObject("scoring");
        StructureDefinition profile = val.getContext().fetchResource(StructureDefinition.class, scoring.get("profile").getAsString());
        List<ValidationMessage> errorsProfile = new ArrayList<ValidationMessage>();
        Element scoringRes = val.validate(null, errorsProfile, new ByteArrayInputStream(testCaseContent), fmt, asSdList(profile));
        ScoringEngine engine = new ScoringEngine(val.getContext(), val.getFHIRPathEngine());
        ScoreOutcome score = engine.generateScores(profile, scoringRes);
        for (RuleScore rule : score.getRules()) {
          System.out.println(rule.summary());
        }
        String template = TestingUtilities.loadTestResource("validator", "templates", "scoring-template.html");
        String html = new ScoringReporter().generateReport(score.getElement(), template, "Test Score");
        FileUtilities.stringToFile(html, Utilities.path("[tmp]", "scoring-test.html"));
      }
    }
    if (content.has("profile")) {
      System.out.print("** Profile: ");
      JsonObject profile = content.getAsJsonObject("profile");
      if (profile.has("valueset-displays")) {
        val.getSettings().setUseValueSetDisplays(true);
      }
      if (profile.has("packages")) {
        for (JsonElement e : profile.getAsJsonArray("packages")) {
          logOutput("load package " + e.getAsString());
          igLoader.loadIg(vCurr.getIgs(), vCurr.getBinaries(), e.getAsString(), true);
        }
      }
      if (profile.has("debug")) {
        val.getSettings().setDebug(profile.get("debug").getAsBoolean());
      }
      if (profile.has("supporting")) {
        for (JsonElement e : profile.getAsJsonArray("supporting")) {
          String filename = e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
          logOutput("load resource " + mr.getUrl());
          val.getContext().getManager().cacheResource(mr);
          if (mr instanceof ImplementationGuide) {
            val.getImplementationGuides().add((ImplementationGuide) mr);
          }
        }
      }
      if (content.has("suppress")) {
        for (JsonElement c : content.getAsJsonArray("suppress")) {
          suppress.add(c.getAsString());
        }
      }
      String filename = profile.get("source").getAsString();
      if (Utilities.isAbsoluteUrl(filename)) {
        sd = val.getContext().fetchResource(StructureDefinition.class, filename);
      } else {
        String contents = TestingUtilities.loadTestResource("validator", filename);
        logOutput("Name: " + name + " - profile : " + profile.get("source").getAsString());
        version = content.has("version") ? content.get("version").getAsString() : version;
        sd = loadProfile(filename, contents, messages, val.getSettings().isDebug(), val.getContext());
        logOutput("load resource " + sd.getUrl());
        val.getContext().getManager().cacheResource(sd);
      }
      val.setAssumeValidRestReferences(profile.has("assumeValidRestReferences") ? profile.get("assumeValidRestReferences").getAsBoolean() : false);
      List<ValidationMessage> errorsProfile = new ArrayList<ValidationMessage>();
      val.validate(null, errorsProfile, new ByteArrayInputStream(testCaseContent), fmt, asSdList(sd));
      logOutput(val.reportTimes());
      checkOutcomes(errorsProfile, profile, "profile", filename, name, suppress);
      moveOutcomes(profile, name, "profile");
    }
    if (content.has("logical")) {
      System.out.print("** Logical: ");

      JsonObject logical = content.getAsJsonObject("logical");
      if (logical.has("supporting")) {
        for (JsonElement e : logical.getAsJsonArray("supporting")) {
          String filename = e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
          if (mr instanceof StructureDefinition) {
            new ContextUtilities(val.getContext()).generateSnapshot((StructureDefinition) mr);
          }
          logOutput("load resource " + mr.getUrl());
          val.getContext().getManager().cacheResource(mr);
        }
      }
      if (logical.has("packages")) {
        for (JsonElement e : logical.getAsJsonArray("packages")) {
          logOutput("load package " + e.getAsString());
          igLoader.loadIg(vCurr.getIgs(), vCurr.getBinaries(), e.getAsString(), true);
        }
      }
      List<StructureDefinition> profiles = new ArrayList<>();
      if (logical.has("format")) {
        sd = val.getContext().fetchResource(StructureDefinition.class, JsonUtilities.str(logical, "format"));
        if (sd != null) {
          profiles.add(sd);
        } else {
          throw new Error("Logical Model '" + JsonUtilities.str(logical, "format") + "' not found");
        }
      }
      List<ValidationMessage> errorsLogical = new ArrayList<ValidationMessage>();
      Element le = val.validate(null, errorsLogical, new ByteArrayInputStream(testCaseContent), fmt, profiles);
      if (logical.has("expressions")) {
        FHIRPathEngine fp = new FHIRPathEngine(val.getContext());
        for (JsonElement e : logical.getAsJsonArray("expressions")) {
          String exp = e.getAsString();
          Assert.assertTrue(fp.evaluateToBoolean(null, le, le, le, fp.parse(exp)));
        }
      }
      checkOutcomes(errorsLogical, logical, "logical", "logical", name, suppress);
    }
    logger.verifyHasNoRequests();
  }

  private void moveOutcomes(JsonObject focus, String name, String mode) throws IOException {
    if (REVISING_TEST_CASES) {
      if (focus.has("dotnet-brianpos") && focus.get("dotnet-brianpos").isJsonObject()) {
        byte[] json = JsonTrackingParser.writeBytes(focus.getAsJsonObject("dotnet-brianpos").getAsJsonObject("outcome"), true);
        String filename = Utilities.path("/Users/grahamegrieve/work/test-cases/validator/outcomes/brianpos", name.replace("/", "-") + "-" + mode + ".json");
        FileUtilities.bytesToFile(json, filename);
        focus.remove("dotnet-brianpos");
        focus.addProperty("brianpos", "brianpos/" + name.replace("/", "-") + "-" + mode + ".json");
      }
      if (focus.has("firely-sdk-current") && focus.get("firely-sdk-current").isJsonObject()) {
        byte[] json = JsonTrackingParser.writeBytes(focus.getAsJsonObject("firely-sdk-current").getAsJsonArray("output"), true);
        String filename = Utilities.path("/Users/grahamegrieve/work/test-cases/validator/outcomes/firely-sdk-current", name.replace("/", "-") + "-" + mode + ".json");
        FileUtilities.bytesToFile(json, filename);
        focus.remove("firely-sdk-current");
        focus.addProperty("firely-sdk-current", "firely-sdk-current/" + name.replace("/", "-") + "-" + mode + ".json");
      }
      if (content.has("firely-sdk-wip") && focus.get("firely-sdk-wip").isJsonObject()) {
        byte[] json = JsonTrackingParser.writeBytes(focus.getAsJsonObject("firely-sdk-wip").getAsJsonArray("output"), true);
        String filename = Utilities.path("/Users/grahamegrieve/work/test-cases/validator/outcomes/firely-sdk-wip", name.replace("/", "-") + "-" + mode + ".json");
        FileUtilities.bytesToFile(json, filename);
        focus.remove("firely-sdk-wip");
        focus.addProperty("firely-sdk-wip", "firely-sdk-wip/" + name.replace("/", "-") + "-" + mode + ".json");
      }
    }
  }


  private NpmPackage loadPackage(String idAndVer) throws IOException {
    var pcm = new FilesystemPackageCacheManager.Builder().build();
    return pcm.loadPackage(idAndVer);
  }

  private ValidationEngine buildVersionEngine(String ver, String txLog) throws Exception {
    String server = FhirSettings.getTxFhirDevelopment();
    switch (ver) {
      case "1.0":
        return TestUtilities.getValidationEngine("hl7.fhir.r2.core#1.0.2", server, txLog, FhirPublication.DSTU2, true, "1.0.2", true, thoVersion, extensionsVersion);
      case "1.4":
        return TestUtilities.getValidationEngine("hl7.fhir.r2b.core#1.4.0", server, txLog, FhirPublication.DSTU2016May, true, "1.4.0", true, thoVersion, extensionsVersion);
      case "3.0":
        return TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", server, txLog, FhirPublication.STU3, true, "3.0.2", true, thoVersion, extensionsVersion);
      case "4.0":
        return TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", server, txLog, FhirPublication.R4, true, "4.0.1", true, thoVersion, extensionsVersion);
      case "4.3":
        return TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", server, txLog, FhirPublication.R4B, true, "4.3.0", true, thoVersion, extensionsVersion);
      case "5.0":
        return TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", server, txLog, FhirPublication.R5, true, "5.0.0", true, thoVersion, extensionsVersion);
    }
    throw new Exception("unknown version " + version);
  }

  private FhirFormat determineFormat(JsonObject config, byte[] cnt) throws IOException {
    String name = JsonUtilities.str(config, "file");
    return org.hl7.fhir.validation.ResourceChecker.checkIsResource(vCurr.getContext(), cnt, name, !JsonUtilities.bool(config, "guess-format"));
  }

  private List<StructureDefinition> asSdList(StructureDefinition sd) {
    List<StructureDefinition> res = new ArrayList<StructureDefinition>();
    res.add(sd);
    return res;
  }

  public StructureDefinition loadProfile(String filename, String contents, List<ValidationMessage> messages, boolean debug, IWorkerContext context) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    StructureDefinition sd = (StructureDefinition) loadResource(filename, contents);
    ProfileUtilities pu = new ProfileUtilities(context, messages, null);
    pu.setDebug(debug);
    if (!sd.hasSnapshot()) {
      StructureDefinition base = context.fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      pu.generateSnapshot(base, sd, sd.getUrl(), null, sd.getTitle());
// (debugging)      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(Utilities.path("[tmp]", sd.getId()+".xml")), sd);
    }
    for (Resource r : sd.getContained()) {
      if (r instanceof StructureDefinition) {
        StructureDefinition childSd = (StructureDefinition) r;
        if (!childSd.hasSnapshot()) {
          StructureDefinition base = context.fetchResource(StructureDefinition.class, childSd.getBaseDefinition());
          pu.generateSnapshot(base, childSd, childSd.getUrl(), null, childSd.getTitle());
        }
      }
    }
    return sd;
  }

  public Resource loadResource(String filename, String contents) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    return loadResource(filename, contents, version);
  }

  public Resource loadResource(String filename, String contents, String version) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        if (Constants.VERSION.equals(version) || "5.0".equals(version))
          return new JsonParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r4b.model.Constants.VERSION.equals(version) || "4.3".equals(version))
          return VersionConvertorFactory_43_50.convertResource(new org.hl7.fhir.r4b.formats.JsonParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      } else {
        if (Constants.VERSION.equals(version) || "5.0".equals(version))
          return new XmlParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r4b.model.Constants.VERSION.equals(version) || "4.3".equals(version))
          return VersionConvertorFactory_43_50.convertResource(new org.hl7.fhir.r4b.formats.XmlParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      }
    }
  }

  private void checkOutcomes(List<ValidationMessage> errors, JsonObject focus, String mode, String profile, String name, List<String> suppress) throws IOException {
    errors.removeIf(vm -> vm.containsText(suppress));

    if (REVISING_TEST_CASES) {
      String fnSrc = Utilities.path("/Users/grahamegrieve/work/test-cases/validator/outcomes/java", name.replace("/", "-") + "-" + mode + ".json");
      if (!new File(fnSrc).exists()) {
        JsonObject java = focus.getAsJsonObject("java");
        OperationOutcome goal = java.has("outcome") ? (OperationOutcome) new JsonParser().parse(java.getAsJsonObject("outcome")) : new OperationOutcome();
        String jsonGoal = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(goal);
        FileUtilities.stringToFile(jsonGoal, fnSrc);
      }
      focus.remove("java");
      focus.addProperty("java", "java/" + name.replace("/", "-") + "-" + mode + ".json");
    }

    byte[] cnt = TestingUtilities.findTestResource("validator", "outcomes", "java", name.replace("/", "-") + "-" + mode + ".json") ?
      TestingUtilities.loadTestResourceBytes("validator", "outcomes", "java", name.replace("/", "-") + "-" + mode + ".json") :
      " { \"resourceType\" : \"OperationOutcome\" }".getBytes();
    OperationOutcome goal = (OperationOutcome) new JsonParser().parse(cnt);
    OperationOutcome actual = content.has("ids-in-errors") ? OperationOutcomeUtilities.createOutcomeSimpleWithIds(errors) : OperationOutcomeUtilities.createOutcomeSimple(errors);
    actual.setText(null);
    actual.getIssue().forEach(iss -> iss.removeExtension(ExtensionDefinitions.EXT_ISSUE_SLICE_INFO));

    String json = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(actual);
    FileUtilities.stringToFile(json, Utilities.path(outputFolder, name.replace("/", "-") + "-" + mode + ".json"));

    List<String> fails = new ArrayList<>();

    Map<OperationOutcomeIssueComponent, OperationOutcomeIssueComponent> map = new HashMap<>();
    for (OperationOutcomeIssueComponent issGoal : goal.getIssue()) {
      OperationOutcomeIssueComponent issActual = findMatchingIssue(actual, issGoal);
      if (issActual == null) {
        fails.add("Expected Issue missing: " + issGoal.toString());
      } else {
        map.put(issActual, issGoal);
      }
    }
    for (OperationOutcomeIssueComponent issActual : actual.getIssue()) {
      if (PRINT_OUTPUT_TO_CONSOLE) {
        logOutput(issActual.toString());
        for (Extension ext : issActual.getExtensionsByUrl(ExtensionDefinitions.EXT_ISSUE_INNER_MESSAGE)) {
          logOutput(innerToString(ext));
        }
      }
      OperationOutcomeIssueComponent issGoal = map.get(issActual);
      if (issGoal == null) {
        fails.add("Unexpected Issue found: " + issActual.toString());
      }
    }
    if (goal.getIssue().size() != actual.getIssue().size() && fails.isEmpty()) {
      fails.add("Issue count mismatch (check for duplicate error messages)");
    }

    if (fails.size() > 0) {
      logOutput("");
      logOutput("========================================================");
      logOutput("Test: " + name);
      logOutput("");
      for (String s : fails) {
        logOutput(s);
      }
      logOutput("");
      logOutput("========================================================");
      logOutput("");
      logOutput(json);
      logOutput("");
      logOutput("========================================================");
      logOutput("");
      if (BUILD_NEW) {
        File newManifestFile = ManagedFileAccess.file(Utilities.path("[tmp]", "validator", "manifest.new.json"));
        if (!newManifestFile.getParentFile().exists()) {
          newManifestFile.getParentFile().mkdir();
        }
        JsonTrackingParser.write(manifest, newManifestFile);
      }
      Assertions.fail("\r\n" + String.join("\r\n", fails));
    }
//    int ec = 0;
//    int wc = 0;
//    int hc = 0;
//    List<String> errLocs = new ArrayList<>();
//    for (ValidationMessage vm : errors) {
//      if (vm.getLevel() == IssueSeverity.FATAL || vm.getLevel() == IssueSeverity.ERROR) {
//        ec++;
//        if (PRINT_OUTPUT_TO_CONSOLE) {
//          logOutput(vm.getDisplay());
//        }
//        errLocs.add(vm.getLocation());
//      }
//      if (vm.getLevel() == IssueSeverity.WARNING) {
//        wc++;
//        if (PRINT_OUTPUT_TO_CONSOLE) {
//          logOutput(vm.getDisplay());
//        }
//      }
//      if (vm.getLevel() == IssueSeverity.INFORMATION) {
//        hc++;
//        if (PRINT_OUTPUT_TO_CONSOLE) {
//          logOutput(vm.getDisplay());
//        }
//      }
//    }
//    if (!TestingUtilities.getSharedWorkerContext(version).isNoTerminologyServer() || !focus.has("tx-dependent")) {
//      Assert.assertEquals("Test " + name + (profile == null ? "" : " profile: "+ profile) + ": Expected " + Integer.toString(java.get("errorCount").getAsInt()) + " errors, but found " + Integer.toString(ec) + ".", java.get("errorCount").getAsInt(), ec);
//      if (java.has("warningCount")) {
//        Assert.assertEquals( "Test " + name + (profile == null ? "" : " profile: "+ profile) + ": Expected " + Integer.toString(java.get("warningCount").getAsInt()) + " warnings, but found " + Integer.toString(wc) + ".", java.get("warningCount").getAsInt(), wc);
//      }
//      if (java.has("infoCount")) {
//        Assert.assertEquals( "Test " + name + (profile == null ? "" : " profile: "+ profile) + ": Expected " + Integer.toString(java.get("infoCount").getAsInt()) + " hints, but found " + Integer.toString(hc) + ".", java.get("infoCount").getAsInt(), hc);
//      }
//    }
//    if (java.has("error-locations")) {
//      JsonArray el = java.getAsJsonArray("error-locations");
//      Assert.assertEquals( "locations count is not correct", errLocs.size(), el.size());
//      for (int i = 0; i < errLocs.size(); i++) {
//        Assert.assertEquals("Location should be " + el.get(i).getAsString() + ", but was " + errLocs.get(i), errLocs.get(i), el.get(i).getAsString());
//      }
//    }

  }

  private String innerToString(Extension ext) {
    return "  - " + ext.getExtensionString("severity") + "/" + ext.getExtensionString("type") + " @ " + ext.getExtensionString("path") + ": " + ext.getExtensionString("message");
  }

  private void logOutput(String msg) {
    System.out.println(msg);
  }

  private OperationOutcomeIssueComponent findMatchingIssue(OperationOutcome oo, OperationOutcomeIssueComponent iss) {
    for (OperationOutcomeIssueComponent t : oo.getIssue()) {
      if (
        (t.hasExpression() && iss.hasExpression() && t.getExpression().get(0).getValue().equals(iss.getExpression().get(0).getValue())
          || (!t.hasExpression() && !iss.hasExpression())) &&
          t.getCode() == iss.getCode() && t.getSeverity() == iss.getSeverity() &&
          (t.hasDiagnostics() ? t.getDiagnostics().equals(iss.getDiagnostics()) : !iss.hasDiagnostics()) &&
          (t.getExtensionString(ExtensionDefinitions.EXT_ISSUE_SERVER) != null ? t.getExtensionString(ExtensionDefinitions.EXT_ISSUE_SERVER).equals(iss.getExtensionString(ExtensionDefinitions.EXT_ISSUE_SERVER)) : iss.getExtensionString(ExtensionDefinitions.EXT_ISSUE_SERVER) == null) &&
          textMatches(t.getDetails().getText(), iss.getDetails().getText())) {
        return t;
      }
    }
    return null;
  }

  private boolean textMatches(String t1, String t2) {
    if (t1.endsWith("...")) {
      t2 = t2.substring(0, t1.length() - 3);
      t1 = t1.substring(0, t1.length() - 3);
    }
    if (t2.endsWith("...")) {
      t1 = t1.substring(0, t2.length() - 3);
      t2 = t2.substring(0, t2.length() - 3);
    }
    t1 = t1.trim();
    t2 = t2.trim();
    return t1.equals(t2);
  }

  private org.hl7.fhir.r4.model.Parameters makeExpProfile() {
    org.hl7.fhir.r4.model.Parameters ep = new org.hl7.fhir.r4.model.Parameters();
    ep.addParameter("profile-url", "http://hl7.org/fhir/ExpansionProfile/dc8fd4bc-091a-424a-8a3b-6198ef146891"); // change this to blow the cache
    // all defaults....
    return ep;
  }

  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    return new ArrayList<Base>();
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    return null;
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    return null;
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    return null;
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    return null;
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) {
    if (url.equals("Patient/test"))
      return new Patient();
    return null;
  }

  @Override
  public Base findContainingResource(Object appContext, Base item) {
    return null;
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    Element res = null;
    if (url.equals("Patient/test")) {
      res = new ObjectConverter(vCurr.getContext()).convert(new Patient());
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase() + ".json")) {
      res = Manager.makeParser(vCurr.getContext(), FhirFormat.JSON).parseSingle(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase() + ".json"), null);
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase() + ".xml")) {
      res = Manager.makeParser(vCurr.getContext(), FhirFormat.XML).parseSingle(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase() + ".xml"), null);
    }
    if (res == null && url.contains("/")) {
      String tail = url.substring(url.indexOf("/") + 1);
      if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase() + ".json")) {
        res = Manager.makeParser(vCurr.getContext(), FhirFormat.JSON).parseSingle(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase() + ".json"), null);
      } else if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase() + ".xml")) {
        res = Manager.makeParser(vCurr.getContext(), FhirFormat.XML).parseSingle(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase() + ".xml"), null);
      }
    }
    return res;
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url, ReferenceDestinationType destinationType) {
    if (content.has("validateReference"))
      return ReferenceValidationPolicy.valueOf(content.get("validateReference").getAsString());
    else
      return ReferenceValidationPolicy.IGNORE;
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator,
                                                               Object appContext,
                                                               StructureDefinition structure,
                                                               ElementDefinition element,
                                                               String containerType,
                                                               String containerId,
                                                               Element.SpecialElement containingResourceType,
                                                               String path,
                                                               String url) {
    if (content.has("validateContains"))
      return ContainedReferenceValidationPolicy.valueOf(content.get("validateContains").getAsString());
    else
      return ContainedReferenceValidationPolicy.CHECK_VALID;
  }

  @Override
  public EnumSet<CodedContentValidationAction> policyForCodedContent(IResourceValidator validator,
                                                                     Object appContext,
                                                                     String stackPath,
                                                                     ElementDefinition definition,
                                                                     StructureDefinition structure,
                                                                     BindingKind kind,
                                                                     AdditionalBindingPurpose purpose,
                                                                     ValueSet valueSet,
                                                                     List<String> systems) {
    return EnumSet.allOf(CodedContentValidationAction.class);
  }

  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type, boolean canonical, List<CanonicalType> targets) throws IOException, FHIRException {
    return !url.contains("example.org") && !url.startsWith("http://hl7.org/fhir/invalid");
  }

  @Override
  public IValidatorResourceFetcher setLocale(Locale locale) {
    //do nothing
    return null;
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    IResourceValidator val = vCurr.getContext().newValidator();
    List<ValidationMessage> valerrors = new ArrayList<ValidationMessage>();
    if (item instanceof Resource) {
      val.validate(appContext, valerrors, (Resource) item, url);
      boolean ok = true;
      for (ValidationMessage v : valerrors)
        ok = ok && v.getLevel().isError();
      return ok;
    }
    throw new NotImplementedException("Not done yet (IGPublisherHostServices.conformsToProfile), when item is element");
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    return vCurr.getContext().fetchResource(ValueSet.class, url);
  }

  @AfterClass
  public static void saveWhenDone() throws IOException {
    String content = new GsonBuilder().setPrettyPrinting().create().toJson(manifest);
    FileUtilities.stringToFile(content, Utilities.path("[tmp]", "validator-produced-manifest.json"));

  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String source) throws MalformedURLException, IOException {
    HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), source);
    res.checkThrowException();
    return res.getContent();
  }

  @Override
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, Object appContext, String url) {
    return null;
  }

  @Override
  public boolean fetchesCanonicalResource(IResourceValidator validator, String url) {
    return false;
  }

  @Override
  public org.hl7.fhir.utilities.json.model.JsonObject fetchJWKS(String address) throws JsonException, IOException {
    if ("https://test.fhir.org/icao/.well-known/jwks.json".equals(address)) {
      return org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(TestingUtilities.loadTestResourceBytes("validator", "test.fhir.org-jwks.json"));
    } else {
      return org.hl7.fhir.utilities.json.parser.JsonParser.parseObjectFromUrl(address);
    }
  }

  @Override
  public boolean paramIsType(String name, int index) {
    return false;
  }

  @Override
  public EnumSet<ResourceValidationAction> policyForResource(IResourceValidator validator, Object appContext,
                                                             StructureDefinition type, String path) {
    return EnumSet.allOf(ResourceValidationAction.class);
  }

  @Override
  public EnumSet<ElementValidationAction> policyForElement(IResourceValidator validator, Object appContext,
                                                           StructureDefinition structure, ElementDefinition element, String path) {
    return EnumSet.allOf(ElementValidationAction.class);
  }

  @Override
  public Set<ResourceVersionInformation> fetchCanonicalResourceVersions(IResourceValidator validator, Object appContext, String url) {
    return new HashSet<>();
  }

  @Override
  public List<StructureDefinition> getImpliedProfilesForResource(IResourceValidator validator, Object appContext,
                                                                 String stackPath, ElementDefinition definition, StructureDefinition structure, Element resource, boolean valid,
                                                                 IMessagingServices msgServices, List<ValidationMessage> messages) {
    return new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.CHECK_VALID, null).getImpliedProfilesForResource(validator, appContext, stackPath,
      definition, structure, resource, valid, msgServices, messages);
  }

  @Override
  public InputStream fetchByPackage(String src) throws IOException {
    if (packageMap.containsKey(src)) {
      return TestingUtilities.loadTestResourceStream("validator", packageMap.get(src));
    } else {
      return null;
    }
  }

  @Override
  public boolean isSuppressMessageId(String path, String messageId) {
    return false;
  }

  @Override
  public ReferenceValidationPolicy getReferencePolicy() {
    return ReferenceValidationPolicy.IGNORE;
  }

  @Override
  public Set<String> getCheckReferencesTo() {
    return Set.of();
  }

  public IValidationPolicyAdvisor getPolicyAdvisor() {
    return null;
  }

  public IValidationPolicyAdvisor setPolicyAdvisor(IValidationPolicyAdvisor policyAdvisor) {
    throw new Error("This policy advisor is the test advisor");
  }

  @Override
  public SpecialValidationAction policyForSpecialValidation(IResourceValidator validator, Object appContext,
                                                            SpecialValidationRule rule, String stackPath, Element resource, Element element) {
    return SpecialValidationAction.CHECK_RULE;
  }

}