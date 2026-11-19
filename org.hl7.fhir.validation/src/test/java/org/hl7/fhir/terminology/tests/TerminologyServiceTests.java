package org.hl7.fhir.terminology.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.commons.io.IOUtils;

import org.hl7.fhir.convertors.factory.*;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.OperationOutcome.*;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.terminology.ExpansionOptions;
import org.hl7.fhir.services.terminology.ValueSetExpansionOutcome;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.terminology.subsumption.SubsumptionException;
import org.hl7.fhir.standalone.terminology.subsumption.SubsumptionOutcome;
import org.hl7.fhir.standalone.terminology.subsumption.TerminologySubsumptionTester;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.UUIDUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.special.TxServiceTestHelper;
import org.hl7.fhir.validation.special.TxTestResponses;
import org.hl7.fhir.validation.special.TxTestSetup;
import org.hl7.fhir.validation.special.TxTestData;
import org.hl7.fhir.validation.special.TxTesterScrubbers;
import org.hl7.fhir.validation.special.TxTesterSorters;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Charsets;

import javax.annotation.Nonnull;

import static org.junit.Assert.assertNull;


@RunWith(Parameterized.class)
public class TerminologyServiceTests {


private static TxTestData testData;

  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {
    Set<String> omissions = new HashSet<>();
    omissions.add("search");
    testData = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#dev", omissions);
    return testData.getTestData();
  }

  private static final Object LOG_LOCK = new Object();
  private static final StringBuilder LOG = new StringBuilder();
  private static int logPass = 0;
  private static int logFail = 0;
  private static int logSkip = 0;

  private String actualFile;

  private final TxTestSetup setup;
  private final String version;
  private final String name;
  private List<String> warnings = new ArrayList<>();

  private static ValidationEngine baseEngine;

  public TerminologyServiceTests(String name, TxTestSetup setup) {
    this.name = name;
    this.setup = setup;
    version = "5.0.0";
  }

  @Test
  public void test() throws Exception {
    String id = setup.getTest().asString("name");
    System.out.println("Running "+id);
    try {
      if (runTest()) {
        log(id, "pass", null);
      } else {
        log(id, "skip", null);
      }
    } catch (AssertionError e) {
      log(id, "fail", e.getMessage());
      throw e;
    } catch (Exception e) {
      log(id, "error", e.getClass().getName()+": "+e.getMessage());
      throw e;
    }
  }

  /**
   * Run one test case. Returns false if the case was skipped (disabled, or not in scope for the
   * modes the internal server is tested under), true if it actually ran.
   */
  private boolean runTest() throws Exception {
    if (setup.getSuite().asBoolean("disabled") || setup.getTest().asBoolean("disabled")) {
      return false;
    }
    if (!passesModes(setup.getSuite()) || !passesModes(setup.getTest())) {
      return false;
    }

    if (baseEngine == null) {
      baseEngine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    }

    ValidationEngine engine = new ValidationEngine(this.baseEngine);
    for (String s : setup.getSuite().forceArray("setup").asStrings()) {
      Resource res = loadResource(s);
      engine.seeResource(res);
    }
    String reqFile = setup.getTest().asString("request");
    Resource req = reqFile == null ? null : loadResource(reqFile);
    // a server sees every tx-resource in the request, not just the value set being operated on:
    // load them all, so that references from it (an imported or excluded value set) resolve
    if (req instanceof org.hl7.fhir.model.core.Parameters) {
      for (org.hl7.fhir.model.core.Parameters.ParametersParameterComponent pp : ((org.hl7.fhir.model.core.Parameters) req).getParameterList()) {
        if ("tx-resource".equals(pp.getName()) && pp.hasResource()) {
          engine.seeResource(pp.getResource());
        }
      }
    }
    // The test case's lenient-display property is carried to the server as the
    // lenient-display-validation parameter (see TxTester.runTest, which does the same for
    // the HTTP path). It only means anything for the two $validate-code operations.
    if (setup.getTest().has("lenient-display") && req instanceof org.hl7.fhir.model.core.Parameters
        && Utilities.existsInList(setup.getTest().asString("operation"), "validate-code", "cs-validate-code")) {
      ((org.hl7.fhir.model.core.Parameters) req).addParameter("lenient-display-validation", setup.getTest().asBoolean("lenient-display"));
    }
    // which response the internal server's answer is compared with can depend on whether it
    // succeeded or failed (see TxTestResponses), so the response is chosen once it has answered
    TxTestResponses responses = new TxTestResponses(setup.getTest(), modes());
    String fn2 = setup.getTest().has("response2") ? setup.getTest().asString("response2") : null; // alternative allowed response for servers unable to implement a feature
    String resp2 = fn2 == null ? null : testData.load(fn2);
    for (String fn : responses.files()) {
      File fo = ManagedFileAccess.file(Utilities.path("[tmp]", "tx", fn));
      if (fo.exists()) {
        fo.delete();
      }
    }
    actualFile = Utilities.path("[tmp]", "tx", responses.fileFor(responses.getChoices().get(0)));

    if (setup.getTest().has("profile")) {
      engine.getContext().setExpansionParameters((org.hl7.fhir.model.core.Parameters) loadResource(setup.getTest().asString("profile")));
    } else {
      engine.getContext().setExpansionParameters((org.hl7.fhir.model.core.Parameters) loadResource("parameters-default.json"));
    }
    engine.getContext().setNoTerminologyServer(true);
    if (setup.getTest().asString("operation").equals("expand")) {
      expand(setup.getTest().str("name"), engine, req, responses, resp2, setup.getTest().asString("Accept-Language"));
    } else if (setup.getTest().asString("operation").equals("validate-code")) {
      validate(engine, req, responses, resp2, false);
    } else if (setup.getTest().asString("operation").equals("cs-validate-code")) {
      validate(engine, req, responses, resp2, true);
    } else if (setup.getTest().asString("operation").equals("subsumes")) {
      subsumes(setup.getTest().str("name"), engine, req, responses);
    } else if (Utilities.existsInList(setup.getTest().asString("operation"), "lookup", "translate", "metadata", "term-caps")) {
      Assertions.assertTrue(true); // we don't test these for the internal server
    } else if (!Utilities.existsInList(setup.getTest().asString("operation"), "batch-validate", "cs-batch-validate", "closure")) { // the internal terminology server doesn't implement these methods
      Assertions.fail("Unknown Operation "+ setup.getTest().asString("operation"));
    }
    return true;
  }

  /** The expected response for what the internal server did, and where its actual response goes */
  private static class Expected {
    private final String resp;
    private final String fp;
    private final JsonObject ext;

    private Expected(String resp, String fp, JsonObject ext) {
      this.resp = resp;
      this.fp = fp;
      this.ext = ext;
    }
  }

  /**
   * The response to compare the internal server's answer with. Usually a test has just the one.
   * When its http-code gives a choice (e.g. 200|4xx), it depends on whether the internal server
   * failed: there's no http layer here, so a result stands for the 2xx choice, and an error
   * (an OperationOutcome) for the 4xx or 5xx one.
   */
  private Expected expected(TxTestResponses responses, boolean error) throws IOException {
    String choice;
    if (responses.isChoice()) {
      choice = responses.choiceForOutcome(error);
      if (choice == null) {
        Assertions.fail("The internal server "+(error ? "failed" : "succeeded")+", but the test's http-code '"+responses.getHttpCode()+"' doesn't allow for that");
      }
    } else {
      // the internal server doesn't check the http-code of tests without a choice
      choice = responses.getChoices().get(0);
    }
    String fn = responses.fileFor(choice);
    String fp = Utilities.path("[tmp]", "tx", fn);
    actualFile = fp;
    return new Expected(testData.load(fn), fp, testData.getExternals() == null ? null : testData.getExternals().getJsonObject(fn));
  }

  private void validate(ValidationEngine engine, Resource req, TxTestResponses responses, String resp2, boolean isCodeSystem) throws IOException {
    TxServiceTestHelper.ValidationResponse actual = TxServiceTestHelper.runValidation(engine.getContext(), req, setup.getTest().asString("Accept-Language"), isCodeSystem);
    Expected exp = expected(responses, actual.isError());
    String diff = TxServiceTestHelper.compareResponse(setup.getTest().str("name"), setup.getTest().asString("name"), exp.resp, resp2, actual.getJson(), exp.fp, exp.ext, modes());
    assertNull(diff, diff);
  }

  /**
   * The run is logged to test-results.log in the same directory the actual responses are written
   * to ([tmp]/tx), so a run can be reviewed with a diff tool rather than scraped off the console.
   * The whole log is rewritten after each test, so it is complete even if the run is interrupted.
   * Logging never fails a test.
   */
  private void log(String id, String status, String details) {
    synchronized (LOG_LOCK) {
      if ("pass".equals(status)) {
        logPass++;
      } else if ("skip".equals(status)) {
        logSkip++;
      } else {
        logFail++;
      }
      LOG.append(Utilities.padRight(status, ' ', 6)+id+"\n");
      if (actualFile != null && !"pass".equals(status) && !"skip".equals(status)) {
        LOG.append("      actual response written to "+actualFile+"\n");
      }
      if (details != null) {
        LOG.append("      "+details.trim()+"\n");
      }
      try {
        String fn = Utilities.path("[tmp]", "tx", "test-results.log");
        FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fn));
        FileUtilities.stringToFile("TerminologyServiceTests (internal terminology server): "+
            logPass+" passed, "+logFail+" failed, "+logSkip+" skipped\n\n"+LOG.toString(), fn);
      } catch (IOException e) {
        // the log is a convenience - never fail a test because it could not be written
      }
    }
  }

  /**
   * $subsumes against the internal terminology server. The test cases use both forms of the 
   * operation parameters (system + codeA/codeB, and codingA/codingB); the parameter names are 
   * passed through to the tester so that any issues are reported against the right parameter.
   */
  private void subsumes(String id, ValidationEngine engine, Resource req, TxTestResponses responses) throws IOException {
    org.hl7.fhir.model.core.Parameters p = (org.hl7.fhir.model.core.Parameters) req;
    Coding codingA;
    Coding codingB;
    String pathA;
    String pathB;
    if (p.hasParameter("codingA") || p.hasParameter("codingB")) {
      codingA = (Coding) p.getParameterValue("codingA");
      codingB = (Coding) p.getParameterValue("codingB");
      pathA = "codingA";
      pathB = "codingB";
    } else {
      String system = primitive(p, "system");
      String sversion = primitive(p, "version");
      codingA = new Coding().setSystem(system).setVersion(sversion).setCode(primitive(p, "codeA"));
      codingB = new Coding().setSystem(system).setVersion(sversion).setCode(primitive(p, "codeB"));
      pathA = "codeA";
      pathB = "codeB";
    }

    String actual;
    boolean error = false;
    try {
      SubsumptionOutcome outcome = new TerminologySubsumptionTester(engine.getContext()).subsumes(codingA, codingB, pathA, pathB);
      org.hl7.fhir.model.core.Parameters po = new org.hl7.fhir.model.core.Parameters();
      po.addParameter("outcome", new CodeType(outcome.toCode()));
      actual = new JsonParser(engine.getContext().getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(po);
    } catch (SubsumptionException e) {
      error = true;
      OperationOutcome oo = new OperationOutcome();
      oo.getIssueList().addAll(e.getIssues());
      TxTesterSorters.sortOperationOutcome(oo);
      TxTesterScrubbers.scrubOperationOutcome(oo, false);
      actual = new JsonParser(engine.getContext().getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }

    Expected exp = expected(responses, error);
    String diff = new CompareUtilities(modes(), exp.ext, vars()).checkJsonSrcIsSame(id, exp.resp, actual);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(exp.fp));
      FileUtilities.stringToFile(actual, exp.fp);
    }
    Assertions.assertNull(diff, diff);
  }

  private String primitive(org.hl7.fhir.model.core.Parameters p, String name) {
    return p.hasParameter(name) && p.getParameterValue(name) != null ? p.getParameterValue(name).primitiveValue() : null;
  }

  private boolean passesModes(JsonObject obj) {
    Set<String> modes = new HashSet<>();
    modes.add("general");

    if (obj.has("modes")) {
      for (String mode : obj.getStrings("modes")) {
        if (modes.contains(mode)) {
          return true;
        }
      }
    }
    if (obj.has("mode")) {
      return modes.contains(obj.asString("mode"));
    }
    return true;

  }

  private void expand(String id, ValidationEngine engine, Resource req, TxTestResponses responses, String resp2, String lang) throws IOException {
    org.hl7.fhir.model.core.Parameters p = ( org.hl7.fhir.model.core.Parameters) req;
    ValueSet vs = null;
    if (p.hasParameter("valueSetVersion")) {      
      vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), VersionResolutionRules.defaultRule(), p.getParameterValue("valueSetVersion").primitiveValue());
    } else if (p.hasParameter("url")) {
      vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), VersionResolutionRules.defaultRule());
    }
    if (vs == null) {
      for (org.hl7.fhir.model.core.Parameters.ParametersParameterComponent pp : p.getParameterList()) {
        if (pp.getName().equals("valueSet")) {
          vs = (ValueSet) pp.getResource();
          break;
        }
        if (pp.getName().equals("tx-resource") && pp.hasResource() && pp.getResource() instanceof ValueSet && ((ValueSet) pp.getResource()).getUrl().equals(p.getParameterValue("url").primitiveValue())) {
          vs = (ValueSet) pp.getResource();
          break;
        }
      }
    }
    boolean clearUrl = false;
    if (!vs.hasUrl()) {
      vs.setUrl(UUIDUtilities.makeUuidUrn());
      clearUrl = true;
    }
    boolean hierarchical = p.hasParameter("excludeNested") ? p.getParameterBool("excludeNested") == false : true;
    Assertions.assertNotNull(vs);
    if (lang != null && !p.hasParameter("displayLanguage")) {
      p.addParameter("displayLanguage", new CodeType(lang));
    }
    ValueSetExpansionOutcome vse = engine.getContext().expandVS(new ExpansionOptions( false, hierarchical, 0, false, null), vs,p, true);
    Expected exp = expected(responses, vse.getValueset() == null);
    String resp = exp.resp;
    String fp = exp.fp;
    JsonObject ext = exp.ext;
    if (resp.contains("\"ValueSet\"")) {
      if (vse.getValueset() == null) {
        if (resp2 != null) {
          OperationOutcome oo = makeOperationOutcome(vse);

          String ooj = new JsonParser(engine.getContext().getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
          String diff = new CompareUtilities(modes(), ext, vars()).checkJsonSrcIsSame(id, resp2, ooj);
          if (diff != null) {
            FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
            FileUtilities.stringToFile(ooj, fp);
          }
          Assertions.assertNull(diff);
        } else {
          Assertions.fail(vse.getError());
        }
      } else {
        if (clearUrl) {
          vse.getValueset().setUrl(null);
        }
        if (!p.hasParameter("excludeNested")) {
          removeParameter(vse.getValueset(), "excludeNested");
        }
        TxTesterSorters.sortValueSet(vse.getValueset());
        TxTesterScrubbers.scrubValueSet(vse.getValueset(), false);
        String vsj = new JsonParser(engine.getContext().getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(vse.getValueset());
        CompareUtilities c = new CompareUtilities(modes(), ext, vars());
        String diff = c.checkJsonSrcIsSame(id, resp, vsj);
        if (diff != null) {
          FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
          FileUtilities.stringToFile(vsj, fp);        
        }
        warnings.addAll(c.getWarnings());
        Assertions.assertNull(diff);
      }
    } else {
      OperationOutcome oo = makeOperationOutcome(vse);

      String ooj = new JsonParser(engine.getContext().getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      String diff = new CompareUtilities(modes(), ext, vars()).checkJsonSrcIsSame(id, resp, ooj);
      if (diff != null) {
        FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
        FileUtilities.stringToFile(ooj, fp);        
      }
      Assertions.assertNull(diff);
    }
  }

  private static @Nonnull OperationOutcome makeOperationOutcome(ValueSetExpansionOutcome vse) {
    OperationOutcome oo = new OperationOutcome();
    if (vse.getIssues() != null) {
      oo.getIssueList().addAll(vse.getIssues());
    } else if (vse.getErrorClass() == null) {
      Assertions.fail("Expected an error, but none received");
    } else {
      OperationOutcomeIssueComponent e = new OperationOutcomeIssueComponent();
      e.setSeverity(IssueSeverity.ERROR);
      switch (vse.getErrorClass()) {
      case BLOCKED_BY_OPTIONS:
        e.setCode(IssueType.FORBIDDEN);
        break;
      case BUSINESS_RULE:
        e.setCode(IssueType.BUSINESSRULE);
        break;
      case CODESYSTEM_UNSUPPORTED:
        e.setCode(IssueType.CODEINVALID);
        break;
      case INTERNAL_ERROR:
        e.setCode(IssueType.EXCEPTION);
        break;
      case NOSERVICE:
        e.setCode(IssueType.CONFLICT);
        break;
      case SERVER_ERROR:
        e.setCode(IssueType.EXCEPTION);
        break;
      case TOO_COSTLY:
        e.setCode(IssueType.TOOCOSTLY);
        break;
      case PROCESSING:
        e.setCode(IssueType.PROCESSING);
        break;
      case UNKNOWN:
        e.setCode(IssueType.UNKNOWN);
        break;
      case VALUESET_UNKNOWN:
        e.setCode(IssueType.NOTFOUND);
        e.getDetails().addCoding().setSystem("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type").setCode("not-found");
        break;
      case VALUESET_UNSUPPORTED:
        e.setCode(IssueType.NOTSUPPORTED);
        break;
      }
      if (vse.getMsgId() != null) {
        e.addExtension(ExtensionDefinitions.EXT_ISSUE_MSG_ID, new StringType(vse.getMsgId()));
      }
      if (vse.getCode() != null) {
        e.getDetails().addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", vse.getCode().toCode(), null);
      }
      e.getDetails().setText(vse.getError());
      oo.addIssue(e);
    }
    TxTesterSorters.sortOperationOutcome(oo);
    TxTesterScrubbers.scrubOperationOutcome(oo, false);
    return oo;
  }

  private Set<String> modes() {
    Set<String> modes = new HashSet<String>();
    modes.add("tx.fhir.org");
    return modes;
  }

  private void removeParameter(ValueSet valueset, String name) {
    for (ValueSet.ValueSetExpansionParameterComponent exp : valueset.getExpansion().getParameterList()) {
      if (exp.getName().equals(name)) {
        valueset.getExpansion().getParameterList().remove(exp);
        return;
      }
    }
  }



  public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    String contents = testData.load(filename);
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        if (Constants.VERSION.equals(version) || "6.0".equals(version))
          return new JsonParser(baseEngine.getContext().getModelContext()).parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertorFactory_30_N.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertorFactory_14_N.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertorFactory_10_N.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertorFactory_40_N.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r5.model.Constants.VERSION.equals(version) || "5.0".equals(version))
          return VersionConvertorFactory_50_N.convertResource(new org.hl7.fhir.r5.formats.JsonParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      } else {
        if (Constants.VERSION.equals(version) || "6.0".equals(version))
          return new XmlParser(baseEngine.getContext().getModelContext()).parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertorFactory_30_N.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertorFactory_14_N.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertorFactory_10_N.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertorFactory_40_N.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r5.model.Constants.VERSION.equals(version) || "5.0".equals(version))
          return VersionConvertorFactory_50_N.convertResource(new org.hl7.fhir.r5.formats.XmlParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      }
    }
  }
  
  private Map<String, String> vars() {
    Map<String, String> vars = new HashMap<String, String>();
    vars.put("version", "5.0.0");
    return vars;

  }
}