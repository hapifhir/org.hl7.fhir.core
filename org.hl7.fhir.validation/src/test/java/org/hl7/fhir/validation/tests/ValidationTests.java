package org.hl7.fhir.validation.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.tests.CacheVerificationLogger;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ObjectConverter;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.CodedContentValidationPolicy;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.IValidatorResourceFetcher;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.IgLoader;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.cli.services.StandAloneValidatorFetcher;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Charsets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


@RunWith(Parameterized.class)
public class ValidationTests implements IEvaluationContext, IValidatorResourceFetcher, IValidationPolicyAdvisor {

  public final static boolean PRINT_OUTPUT_TO_CONSOLE = true;
  private static final boolean BUILD_NEW = false;

  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {
    String contents = TestingUtilities.loadTestResource("validator", "manifest.json");

    Map<String, JsonObject> examples = new HashMap<String, JsonObject>();
    manifest = (JsonObject) new com.google.gson.JsonParser().parse(contents);
    for (JsonElement e : manifest.getAsJsonArray("test-cases")) {
      JsonObject o = (JsonObject) e;
      examples.put(JsonUtilities.str(o, "name"), o);
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

  private static Map<String, ValidationEngine> ve = new HashMap<>();


  private static ValidationEngine vCurr;
  private static IgLoader igLoader;

  public ValidationTests(String name, JsonObject content) {
    this.name = name;
    this.content = content;
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    CacheVerificationLogger logger = new CacheVerificationLogger();
    long setup = System.nanoTime();

    this.name = name;
    System.out.println("---- " + name + " ---------------------------------------------------------------- ("+System.getProperty("java.vm.name")+")");
    System.out.println("** Core: ");
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
    if (!ve.containsKey(version)) {
      if (version.startsWith("5.0"))
        ve.put(version, TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", ValidationEngineTests.DEF_TX, txLog, FhirPublication.R5, true, "5.0.0"));
      else if (version.startsWith("4.3"))
        ve.put(version, TestUtilities.getValidationEngine("hl7.fhir.r4b.core#4.3.0", ValidationEngineTests.DEF_TX, txLog, FhirPublication.R4B, true, "4.3.0"));
      else if (version.startsWith("4.0"))
        ve.put(version, TestUtilities.getValidationEngine("hl7.fhir.r4.core#4.0.1", ValidationEngineTests.DEF_TX, txLog, FhirPublication.R4, true, "4.0.1"));
      else if (version.startsWith("3.0"))
        ve.put(version, TestUtilities.getValidationEngine("hl7.fhir.r3.core#3.0.2", ValidationEngineTests.DEF_TX, txLog, FhirPublication.STU3, true, "3.0.2"));
      else if (version.startsWith("1.4"))
        ve.put(version, TestUtilities.getValidationEngine("hl7.fhir.r2b.core#1.4.0", ValidationEngineTests.DEF_TX, txLog, FhirPublication.DSTU2016May, true, "1.4.0"));
      else if (version.startsWith("1.0"))
        ve.put(version, TestUtilities.getValidationEngine("hl7.fhir.r2.core#1.0.2", ValidationEngineTests.DEF_TX, txLog, FhirPublication.DSTU2, true, "1.0.2"));
      else
        throw new Exception("unknown version " + version);
    }
    vCurr = ve.get(version);
    vCurr.getContext().getTxClient().setLogger(logger);
    igLoader = new IgLoader(vCurr.getPcm(), vCurr.getContext(), vCurr.getVersion(), true);
    if (TestingUtilities.fcontexts == null) {
      TestingUtilities.fcontexts = new HashMap<>();
    }
    TestingUtilities.fcontexts.put(version, vCurr.getContext());

    if (content.has("use-test") && !content.get("use-test").getAsBoolean())
      return;

    byte[] testCaseContent = TestingUtilities.loadTestResource("validator", JsonUtilities.str(content, "file")).getBytes(StandardCharsets.UTF_8);
    // load and process content    
    FhirFormat fmt = determineFormat(content, testCaseContent);
    
    InstanceValidator val = vCurr.getValidator(fmt);
    val.setWantCheckSnapshotUnchanged(true);
    val.getContext().setClientRetryCount(4);
    val.setDebug(false);
    
    if (content.has("fetcher") && "standalone".equals(JsonUtilities.str(content, "fetcher"))) {
      val.setFetcher(vCurr);
      vCurr.setFetcher(new StandAloneValidatorFetcher(vCurr.getPcm(), vCurr.getContext(), vCurr));
    } else {
      val.setFetcher(this);
    }

    val.setPolicyAdvisor(this);

    if (content.has("allowed-extension-domain"))
      val.getExtensionDomains().add(content.get("allowed-extension-domain").getAsString());
    if (content.has("allowed-extension-domains"))
      for (JsonElement a : content.getAsJsonArray("allowed-extension-domains"))
        val.getExtensionDomains().add(a.getAsString());
    if (content.has("language"))
      val.setValidationLanguage(content.get("language").getAsString());
    else
      val.setValidationLanguage(null);
    if (content.has("default-version")) {
      val.setBaseOptions(val.getBaseOptions().setVersionFlexible(content.get("default-version").getAsBoolean()));
    } else {
      val.setBaseOptions(val.getBaseOptions().setVersionFlexible(false));
    }
    if (content.has("packages")) {
      for (JsonElement e : content.getAsJsonArray("packages")) {
        String n = e.getAsString();
        InputStream cnt = n.endsWith(".tgz") ? TestingUtilities.loadTestResourceStream("validator", n) : null;
        if (cnt != null) {
          igLoader.loadPackage(NpmPackage.fromPackage(cnt));
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
        val.getContext().cacheResource(mr);
        if (mr instanceof ImplementationGuide) {
          val.getImplementationGuides().add((ImplementationGuide) mr);
        }
      }
    }
    val.getBundleValidationRules().clear();
    if (content.has("bundle-param")) {
      val.getBundleValidationRules().add(new BundleValidationRule(content.getAsJsonObject("bundle-param").get("rule").getAsString(), content.getAsJsonObject("bundle-param").get("profile").getAsString()));
    }
    if (content.has("profiles")) {
      for (JsonElement je : content.getAsJsonArray("profiles")) {
        String filename = je.getAsString();    
        String contents = TestingUtilities.loadTestResource("validator", filename);
        StructureDefinition sd = loadProfile(filename, contents, messages, val.isDebug());
        val.getContext().cacheResource(sd);
      }
   }
    List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
    if (content.getAsJsonObject("java").has("debug")) {
      val.setDebug(content.getAsJsonObject("java").get("debug").getAsBoolean());
    } else {
      val.setDebug(false);
    }
    if (content.has("best-practice")) {
      val.setBestPracticeWarningLevel(BestPracticeWarningLevel.valueOf(content.get("best-practice").getAsString()));
    }
    if (content.has("examples")) {
      val.setAllowExamples(content.get("examples").getAsBoolean());
    } else {
      val.setAllowExamples(true);
    }
    if (content.has("security-checks")) {
      val.setSecurityChecks(content.get("security-checks").getAsBoolean());
    }
    if (content.has("noHtmlInMarkdown")) {
      val.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.ERROR);
    }
    if (content.has("logical")==false) {
      val.setAssumeValidRestReferences(content.has("assumeValidRestReferences") ? content.get("assumeValidRestReferences").getAsBoolean() : false);
      System.out.println(String.format("Start Validating (%d to set up)", (System.nanoTime() - setup) / 1000000));
      val.validate(null, errors, new ByteArrayInputStream(testCaseContent), fmt);
      System.out.println(val.reportTimes());
      checkOutcomes(errors, content, null, name);
    }
    if (content.has("profile")) {
      System.out.print("** Profile: ");
      JsonObject profile = content.getAsJsonObject("profile");
      if (profile.has("packages")) {
        for (JsonElement e : profile.getAsJsonArray("packages")) {
          igLoader.loadIg(vCurr.getIgs(), vCurr.getBinaries(), e.getAsString(), true);
        }
      }
      if (profile.getAsJsonObject("java").has("debug")) {
        val.setDebug(profile.getAsJsonObject("java").get("debug").getAsBoolean());
      }
      if (profile.has("supporting")) {
        for (JsonElement e : profile.getAsJsonArray("supporting")) {
          String filename = e.getAsString();
          String contents = TestingUtilities.loadTestResource("validator", filename);
          CanonicalResource mr = (CanonicalResource) loadResource(filename, contents);
          val.getContext().cacheResource(mr);
          if (mr instanceof ImplementationGuide) {
            val.getImplementationGuides().add((ImplementationGuide) mr);
          }
        }
      }
      StructureDefinition sd = null;
      String filename = profile.get("source").getAsString();
      if (Utilities.isAbsoluteUrl(filename)) {
        sd = val.getContext().fetchResource(StructureDefinition.class, filename);
      } else {
        String contents = TestingUtilities.loadTestResource("validator", filename);
        System.out.println("Name: " + name + " - profile : " + profile.get("source").getAsString());
        version = content.has("version") ? content.get("version").getAsString() : version;
        sd = loadProfile(filename, contents, messages, val.isDebug());
        val.getContext().cacheResource(sd);
      }
      val.setAssumeValidRestReferences(profile.has("assumeValidRestReferences") ? profile.get("assumeValidRestReferences").getAsBoolean() : false);
      List<ValidationMessage> errorsProfile = new ArrayList<ValidationMessage>();
      val.validate(null, errorsProfile, new ByteArrayInputStream(testCaseContent), fmt, asSdList(sd));
      System.out.println(val.reportTimes());
      checkOutcomes(errorsProfile, profile, filename, name);
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
            val.getContext().generateSnapshot((StructureDefinition) mr, true);
          }
          val.getContext().cacheResource(mr);
        }
      }
      if (logical.has("packages")) {
        for (JsonElement e : logical.getAsJsonArray("packages")) {
          igLoader.loadIg(vCurr.getIgs(), vCurr.getBinaries(), e.getAsString(), true);
        }
      }
      List<ValidationMessage> errorsLogical = new ArrayList<ValidationMessage>();
      Element le = val.validate(null, errorsLogical, new ByteArrayInputStream(testCaseContent), fmt);
      if (logical.has("expressions")) {
        FHIRPathEngine fp = new FHIRPathEngine(val.getContext());
        for (JsonElement e : logical.getAsJsonArray("expressions")) {
          String exp = e.getAsString();
          Assert.assertTrue(fp.evaluateToBoolean(null, le, le, le, fp.parse(exp)));
        }
      }
      checkOutcomes(errorsLogical, logical, "logical", name);
    }
    logger.verifyHasNoRequests();
    if (BUILD_NEW) {
      JsonTrackingParser.write(manifest, new File(Utilities.path("[tmp]", "validator", "manifest.new.json")));
    }
  }


  private FhirFormat determineFormat(JsonObject config, byte[] cnt) throws IOException {
    String name = JsonUtilities.str(config, "file");
    return org.hl7.fhir.validation.ResourceChecker.checkIsResource(vCurr.getContext(), true, cnt, name, !JsonUtilities.bool(config, "guess-format")); 
  }

  private List<StructureDefinition> asSdList(StructureDefinition sd) {
    List<StructureDefinition> res = new ArrayList<StructureDefinition>();
    res.add(sd);
    return res;
  }

  public StructureDefinition loadProfile(String filename, String contents, List<ValidationMessage> messages, boolean debug) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    StructureDefinition sd = (StructureDefinition) loadResource(filename, contents);
    ProfileUtilities pu = new ProfileUtilities(TestingUtilities.getSharedWorkerContext(version), messages, null);
    pu.setDebug(debug);
    if (!sd.hasSnapshot()) {
      StructureDefinition base = TestingUtilities.getSharedWorkerContext(version).fetchResource(StructureDefinition.class, sd.getBaseDefinition());
      pu.generateSnapshot(base, sd, sd.getUrl(), null, sd.getTitle());
// (debugging)      new XmlParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path("[tmp]", sd.getId()+".xml")), sd);
    }
    for (Resource r : sd.getContained()) {
      if (r instanceof StructureDefinition) {
        StructureDefinition childSd = (StructureDefinition) r;
        if (!childSd.hasSnapshot()) {
          StructureDefinition base = TestingUtilities.getSharedWorkerContext(version).fetchResource(StructureDefinition.class, childSd.getBaseDefinition());
          pu.generateSnapshot(base, childSd, childSd.getUrl(), null, childSd.getTitle());
        }
      }
    }
    return sd;
  }

  public Resource loadResource(String filename, String contents) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
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
        else
          throw new FHIRException("unknown version " + version);
      }
    }
  }

  private void checkOutcomes(List<ValidationMessage> errors, JsonObject focus, String profile, String name) throws IOException {
    JsonObject java = focus.getAsJsonObject("java");
    OperationOutcome goal = java.has("outcome") ? (OperationOutcome) new JsonParser().parse(java.getAsJsonObject("outcome")) : new OperationOutcome();
    OperationOutcome actual = OperationOutcomeUtilities.createOutcomeSimple(errors);
    actual.setText(null);
    String json = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(actual);

    List<String> fails = new ArrayList<>();
    
    Map<OperationOutcomeIssueComponent, OperationOutcomeIssueComponent> map = new HashMap<>();
    for (OperationOutcomeIssueComponent issGoal : goal.getIssue()) {
      OperationOutcomeIssueComponent issActual = findMatchingIssue(actual, issGoal);
      if (issActual == null) {
        fails.add("Expected Issue not found: "+issGoal.toString());
      } else {
        map.put(issActual, issGoal);
      }
    }
    for (OperationOutcomeIssueComponent issActual : actual.getIssue()) {
      if (PRINT_OUTPUT_TO_CONSOLE) {
        System.out.println(issActual.toString());
      }
      OperationOutcomeIssueComponent issGoal = map.get(issActual);
      if (issGoal == null) {
        fails.add("Unexpected Issue found: "+issActual.toString());
      }
    }
    if (goal.getIssue().size() != actual.getIssue().size() && fails.isEmpty()) {
      fails.add("Issue count mismatch (check for duplicate error messages)");
    }

    if (fails.size() > 0) {
      for (String s : fails) {
        System.out.println(s);
      }
      System.out.println("");
      System.out.println("========================================================");
      System.out.println("");
      System.out.println(json);
      System.out.println("");
      System.out.println("========================================================");
      System.out.println("");      
      Assertions.fail(fails.toString());
    }
//    int ec = 0;
//    int wc = 0;
//    int hc = 0;
//    List<String> errLocs = new ArrayList<>();
//    for (ValidationMessage vm : errors) {
//      if (vm.getLevel() == IssueSeverity.FATAL || vm.getLevel() == IssueSeverity.ERROR) {
//        ec++;
//        if (PRINT_OUTPUT_TO_CONSOLE) {
//          System.out.println(vm.getDisplay());
//        }
//        errLocs.add(vm.getLocation());
//      }
//      if (vm.getLevel() == IssueSeverity.WARNING) {
//        wc++;
//        if (PRINT_OUTPUT_TO_CONSOLE) {
//          System.out.println(vm.getDisplay());
//        }
//      }
//      if (vm.getLevel() == IssueSeverity.INFORMATION) {
//        hc++;
//        if (PRINT_OUTPUT_TO_CONSOLE) {
//          System.out.println(vm.getDisplay());
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
    if (BUILD_NEW) {
      if (java.has("output")) {
        java.remove("output");
      }
      if (java.has("error-locations")) {
        java.remove("error-locations");
      }
      if (java.has("warningCount")) {
        java.remove("warningCount");
      }
      if (java.has("infoCount")) {
        java.remove("infoCount");
      }
      if (java.has("errorCount")) {
        java.remove("errorCount");
      }
      if (java.has("outcome")) {
        java.remove("outcome");
      }
      if (actual.hasIssue()) {
        JsonObject oj = JsonTrackingParser.parse(json, null);
        java.add("outcome", oj);
      }
    }
  }

  private OperationOutcomeIssueComponent findMatchingIssue(OperationOutcome oo, OperationOutcomeIssueComponent iss) {
    for (OperationOutcomeIssueComponent t : oo.getIssue()) {
      if (t.getExpression().get(0).getValue().equals(iss.getExpression().get(0).getValue()) && t.getCode() == iss.getCode() && t.getSeverity() == iss.getSeverity()
          && (t.hasDiagnostics() ? t.getDiagnostics().equals(iss.getDiagnostics()) : !iss.hasDiagnostics()) && textMatches(t.getDetails().getText(), iss.getDetails().getText())) {
        return t;
      }
    }
    return null;
  }

  private boolean textMatches(String t1, String t2) {
    if (t1.endsWith("...")) {
      t2 = t2.substring(0, t1.length()-3);
      t1 = t1.substring(0, t1.length()-3);
    }
    if (t2.endsWith("...")) {
      t1 = t1.substring(0, t2.length()-3);
      t2 = t2.substring(0, t2.length()-3);
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
  public List<Base> resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
    return new ArrayList<Base>();
  }

  @Override
  public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
    return null;
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(String functionName) {
    return null;
  }

  @Override
  public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
    return null;
  }

  @Override
  public List<Base> executeFunction(Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    return null;
  }

  @Override
  public Base resolveReference(Object appContext, String url, Base refContext) {
    if (url.equals("Patient/test"))
      return new Patient();
    return null;
  }

  @Override
  public Element fetch(IResourceValidator validator, Object appContext, String url) throws FHIRFormatError, DefinitionException, IOException, FHIRException {
    Element res = null;
    if (url.equals("Patient/test")) {
      res = new ObjectConverter(TestingUtilities.getSharedWorkerContext(version)).convert(new Patient());
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase() + ".json")) {
      res = Manager.makeParser(TestingUtilities.getSharedWorkerContext(version), FhirFormat.JSON).parseSingle(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase() + ".json"));
    } else if (TestingUtilities.findTestResource("validator", url.replace("/", "-").toLowerCase() + ".xml")) {
      res = Manager.makeParser(TestingUtilities.getSharedWorkerContext(version), FhirFormat.XML).parseSingle(TestingUtilities.loadTestResourceStream("validator", url.replace("/", "-").toLowerCase() + ".xml"));
    }
    if (res == null && url.contains("/")) {
      String tail = url.substring(url.indexOf("/") + 1);
      if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase() + ".json")) {
        res = Manager.makeParser(TestingUtilities.getSharedWorkerContext(version), FhirFormat.JSON).parseSingle(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase() + ".json"));
      } else if (TestingUtilities.findTestResource("validator", tail.replace("/", "-").toLowerCase() + ".xml")) {
        res = Manager.makeParser(TestingUtilities.getSharedWorkerContext(version), FhirFormat.XML).parseSingle(TestingUtilities.loadTestResourceStream("validator", tail.replace("/", "-").toLowerCase() + ".xml"));
      }
    }
    return res;
  }

  @Override
  public ReferenceValidationPolicy policyForReference(IResourceValidator validator, Object appContext, String path, String url) {
    if (content.has("validateReference"))
      return ReferenceValidationPolicy.valueOf(content.get("validateReference").getAsString());
    else
      return ReferenceValidationPolicy.IGNORE;
  }

  @Override
  public ContainedReferenceValidationPolicy policyForContained(IResourceValidator validator, Object appContext,
                                                               String containerType, String containerId,
                                                               Element.SpecialElement containingResourceType,
                                                               String path, String url) {
    if (content.has("validateContains"))
      return ContainedReferenceValidationPolicy.valueOf(content.get("validateContains").getAsString());
    else
      return ContainedReferenceValidationPolicy.CHECK_VALID;
  }

  @Override
  public CodedContentValidationPolicy policyForCodedContent(IResourceValidator validator, Object appContext, String stackPath, ElementDefinition definition,
      StructureDefinition structure, BindingKind kind, ValueSet valueSet, List<String> systems) {
    if (content.has("validateCodedContent"))
      return CodedContentValidationPolicy.valueOf(content.get("validateCodedContent").getAsString());
    else
      return CodedContentValidationPolicy.VALUESET;
  }
  @Override
  public boolean resolveURL(IResourceValidator validator, Object appContext, String path, String url, String type) throws IOException, FHIRException {
    return !url.contains("example.org") && !url.startsWith("http://hl7.org/fhir/invalid");
  }

  @Override
  public IValidatorResourceFetcher setLocale(Locale locale) {
    //do nothing
    return null;
  }

  @Override
  public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
    IResourceValidator val = TestingUtilities.getSharedWorkerContext(version).newValidator();
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
  public ValueSet resolveValueSet(Object appContext, String url) {
    return vCurr.getContext().fetchResource(ValueSet.class, url);
  }

  @AfterClass
  public static void saveWhenDone() throws IOException {
    String content = new GsonBuilder().setPrettyPrinting().create().toJson(manifest);
    TextFile.stringToFile(content, Utilities.path("[tmp]", "validator-produced-manifest.json"));

  }

  @Override
  public byte[] fetchRaw(IResourceValidator validator, String source) throws MalformedURLException, IOException {
    SimpleHTTPClient http = new SimpleHTTPClient();
    HTTPResult res = http.get(source);
    res.checkThrowException();
    return res.getContent();
  }

  @Override
  public CanonicalResource fetchCanonicalResource(IResourceValidator validator, String url) {
    return null;
  }

  @Override
  public boolean fetchesCanonicalResource(IResourceValidator validator, String url) {
    return false;
  }

}