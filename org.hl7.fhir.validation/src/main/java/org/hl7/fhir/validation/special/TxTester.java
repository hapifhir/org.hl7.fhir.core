package org.hl7.fhir.validation.special;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.TestReport;
import org.hl7.fhir.r5.model.TestReport.TestReportActionResult;
import org.hl7.fhir.r5.model.TestReport.TestReportParticipantType;
import org.hl7.fhir.r5.model.TestReport.TestReportResult;
import org.hl7.fhir.r5.model.TestReport.TestReportStatus;
import org.hl7.fhir.r5.model.TestReport.TestReportTestComponent;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient.ITerminologyConversionLogger;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.r5.utils.client.network.ClientHeaders;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@Slf4j
public class TxTester {

  public class IntHolder {

    private int count;
    
    public void count() {
      count++;
    }

    public int total() {
      return count;
    }

  }

  public interface ITxTesterLoader {
    public String describe();
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException;
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException;
    public boolean hasContent(String filename) throws IOException;
    public String code();
    public String version() throws JsonException, IOException;
    public String testFileName();
  }
  
  private class TxTesterConversionLogger implements ITerminologyConversionLogger {

    public String suiteName;
    public String testName;

    @Override
    public void log(String name, String resourceType, String version, byte[] cnt) {
      if (!"expandValueset.response".equals(name)) {
        return;
      }
       
      String base;
      try {
        base = Utilities.path(outputDir, "conversions");
        if (ManagedFileAccess.file(base).exists()) {
          String dir = Utilities.path(base, version, suiteName);
          FileUtilities.createDirectory(dir);
          String filename = Utilities.path(dir, testName+"."+resourceType+".json");
          FileUtilities.bytesToFile(cnt, filename);
        }      
      } catch (IOException e) {
        // TODO Auto-generated catch block
        log.error(e.getMessage(), e);
      }
    }
  }
  
  private String server;
  private List<ITxTesterLoader> loaders = new ArrayList<>();
  private String error;
  private String outputDir;
  private ITerminologyClient terminologyClient;
  private boolean tight;
  private JsonObject externals;
  private String software;
  private List<String> fails = new ArrayList<>();
  private CapabilityStatement cstmt;
  private TerminologyCapabilities tc;
  private TxTesterConversionLogger conversionLogger;
  private TestReport testReport;

  public TxTester(ITxTesterLoader loader, String server, boolean tight, JsonObject externals) {
    super();
    this.server = server;
    this.loaders.add(loader);
    this.tight = tight;
    this.externals = externals;
    conversionLogger = new TxTesterConversionLogger();
    testReport = new TestReport();
  }

  public static void main(String[] args) throws Exception {
    new TxTester(new InternalTxLoader(args[0]), args[1], "true".equals(args[2]), args.length == 5 ? JsonParser.parseObjectFromFile(args[4]) : null).execute(new HashSet<>(), args[3]);
  }
  
  public void addLoader(ITxTesterLoader loader) {
    this.loaders.add(loader);    
  }
  
  public boolean execute(Set<String> modes, String filter) throws IOException, URISyntaxException {
    if (outputDir == null) {
      outputDir = Utilities.path("[tmp]", serverId());
    }
    
    log.info("Run terminology service Tests");
    log.info("  Source for tests: "+loaders.get(0).describe());
    for (ITxTesterLoader loader : loaders) {
      if (loader != loaders.get(0)) {
        log.info("  Additional Tests: "+loader.describe());
      }
    }
    log.info("  Output Directory: "+outputDir);
    if (!ManagedFileAccess.file(outputDir).exists()) {
      FileUtilities.createDirectory(outputDir);
    }
    if (!ManagedFileAccess.file(outputDir).exists()) {
      throw new IOException("Unable to create output directory "+outputDir);
    }
    FileUtilities.createDirectory(Utilities.path(outputDir, "actual"));
    FileUtilities.createDirectory(Utilities.path(outputDir, "expected"));
    log.info("  Term Service Url: "+server);
    testReport.addParticipant().setType(TestReportParticipantType.SERVER).setUri(server);
    log.info("  External Strings: "+(externals != null));
    log.info("  Test  Exec Modes: "+modes.toString());

    if (filter != null) {
      log.info("  Filter Parameter: "+filter);
    }

    IntHolder counter = new IntHolder();
    IntHolder errCount = new IntHolder();
    JsonObject json = new JsonObject();
    List<StringPair> versions = new ArrayList<StringPair>();
    json.add("date", new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(Calendar.getInstance().getTime()) + timezone());
    try {
      terminologyClient = connectToServer(modes);
      boolean ok = checkClient();
      for (ITxTesterLoader loader : loaders) {
        JsonObject tests = loadTests(loader);
        readTests(tests, loader.version());
        versions.add(new StringPair(loader.code(), loader.version()));
        for (JsonObject suite : tests.getJsonObjects("suites")) {
          if ((!suite.has("mode") || modes.contains(suite.asString("mode")))) {
            if (suite.asBoolean("disabled")) {
              // ok = true;
            } else {
              ok = runSuite(loader, suite, modes, filter, json.forceArray("suites"), counter, errCount) && ok;
            }
          }
        }
      }
      FileUtilities.stringToFile(JsonParser.compose(json, true), Utilities.path(outputDir, "test-results.json"));

      int c = counter.total() * 100;
      int e = errCount.total() * 100;
      double s = counter.total() == 0 ? 0 : (c - e) / counter.total();
      
      testReport.setScore(s / 100);
      testReport.setResult(errCount.total() == 0 ? TestReportResult.PASS : TestReportResult.FAIL);
      
      if (filter == null) {
        String m = modes.isEmpty() ? "[none]" : CommaSeparatedStringBuilder.join("+", modes);
        if (ok) {
          log.info(software+" passed all "+counter.total()+" HL7 terminology service tests ("+Utilities.pluralize("mode", modes.size())+" "+m+", tests v"+vString(versions)+", runner v"+VersionUtil.getBaseVersion()+")");
          return true;
        } else {
          log.info(software+" failed "+errCount.total()+" of "+counter.total()+" HL7 terminology service tests ("+Utilities.pluralize("mode", modes.size())+" "+m+", tests v"+vString(versions)+", runner v"+VersionUtil.getBaseVersion()+")");
          log.info("Failed Tests: "+ CommaSeparatedStringBuilder.join(",", fails ));
          return false;
        }    
      } else {
        log.info(software+" "+(ok ? "Passed the tests" : "did not pass the tests")+" '"+filter+"'");
        return ok;
      }
    } catch (Exception e) {
      log.error("Exception running Terminology Service Tests: "+e.getMessage(), e);
      return false;
    }
  }
  
//
//  private TestCasesSuiteComponent getSuite(JsonObject suite) {
//    for (TestCasesSuiteComponent t : testCases.getSuite()) {
//      if (t.getName().equals(suite.asString("name"))) {
//        return t;
//      }
//    }
//    TestCasesSuiteComponent t = testCases.addSuite();
//    t.setName(suite.asString("name"));
//    t.setDescription(suite.asString("description"));
//    if (suite.has("notes")) {
//      t.setDescription(t.getDescription()+". "+suite.asString("notes"));
//    }
//    for (String s : suite.getStrings("setup")) {
//      t.addSetup().setFile(s);
//    }
//    return t;
//  }
//
//  private TestCasesSuiteTestComponent getSuiteTest(TestCasesSuiteComponent tcs, JsonObject test) {
//    for (TestCasesSuiteTestComponent t : tcs.getTest()) {
//      if (t.getName().equals(test.asString("name"))) {
//        return t;
//      }
//    }
//    TestCasesSuiteTestComponent t = tcs.addTest();
//    t.setName(test.asString("name"));
//    if (test.has("explanation")) {
//      t.setDescription(test.asString("explanation"));      
//    } else {
//      t.setDescription(test.asString("description"));
//    }
//    t.setOperation(test.asString("operation"));
//    if (test.has("mode")) {
//      t.setMode(test.asString("mode"));
//    }
//    if (test.has("request")) {
//      t.addInput().setName("request").setFile(test.asString("request"));
//    }
//    if (test.has("response")) {
//      t.addOutput().setName("response").setFile(test.asString("response"));
//    }
//    for (JsonProperty p : test.getProperties()) {
//      if (p.getName().startsWith("request:")) {
//        t.addInput().setName("request").setMode(p.getName().substring(8)).setFile(p.getValue().asString());        
//      }
//      if (p.getName().startsWith("response:")) {
//        t.addInput().setName("response").setMode(p.getName().substring(9)).setFile(p.getValue().asString());
//      }
//    }
//    if (test.has("Accept-Language")) {
//      t.addParameter().setName("Accept-Language").setValue(new StringType(test.asString("Accept-Language")));
//    }
//    if (test.has("http-code")) {
//      t.addParameter().setName("http-code").setValue(new StringType(test.asString("http-code")));
//    }
//    if (test.has("profile")) {
//      t.addParameter().setName("profile").setValue(new StringType(test.asString("profile")));
//    }
//    if (test.has("header")) {
//      JsonObject hdr = test.getJsonObject("header"); 
//      t.addParameter().setMode(hdr.asString("mode")).setName("header").setValue(new StringType(hdr.asString("name")+": "+hdr.asString("value")));
//    }
//    return t;
//  }
  
  private void readTests(JsonObject tests, String version) {
//    testCases.setIdBase("tx-ecosystem-test-cases");
//    testCases.setUrl("http://hl7.org/fhir/uv/tx-ecosystem/TestCases/tx-ecosystem-test-cases");
//    testCases.setVersion(version);
//    testCases.setName("TxEcosystemTests");
//    testCases.setDescription(tests.asString("introduction"));
    testReport.setName("TxEcosystemTests");
    testReport.setTestScript("http://hl7.org/fhir/uv/tx-ecosystem/TestCases/tx-ecosystem-test-cases|"+version);
    testReport.setTester("HL7 Ecosystem Test Runner v"+VersionUtil.getBaseVersion());
    testReport.setStatus(TestReportStatus.COMPLETED);
  }
  
  private TestReportTestComponent getTestReportTest(JsonObject suite, JsonObject test) {
    TestReportTestComponent t = testReport.addTest();
    t.setName(suite.asString("name")+"/"+test.asString("name"));
    t.getActionFirstRep().getOperation().setResult(TestReportActionResult.SKIP);
    return t;
  }

  private String vString(List<StringPair> versions) {
    StringBuilder b = new StringBuilder();
    b.append(versions.get(0).getValue());
    if (versions.size() > 1) {
      b.append("[");
      for (int i = 1; i < versions.size(); i++) {
        if (i > 1) {
          b.append(",");
        }
        b.append(versions.get(i).getName());
        b.append(":");
        b.append(versions.get(i).getValue());
      }
      b.append("]");
    }
    return b.toString();
  }

  private String timezone() {
    TimeZone tz = TimeZone.getDefault();
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
    offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

    return offset;
  }

  private boolean checkClient() {
    conversionLogger.suiteName = "connect";
    conversionLogger.testName = "checkClient";
    cstmt = terminologyClient.getCapabilitiesStatement();
    if (cstmt.hasSoftware()) {
      software = cstmt.getSoftware().getName()+" v"+cstmt.getSoftware().getVersion();
      testReport.getParticipantFirstRep().setDisplay(software);
    }
    tc = terminologyClient.getTerminologyCapabilities();
    return true;
  }

  private JsonObject loadTests(ITxTesterLoader loader) throws JsonException, IOException {
    log.info("Load Tests from "+loader.describe());
    return JsonParser.parseObject(loader.loadContent(loader.testFileName()));
  }

  private byte[] fetch(String source) throws IOException {
    String murl = source.contains("?") ? source+"&nocache=" + System.currentTimeMillis() : source+"?nocache=" + System.currentTimeMillis();
    HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), murl, "application/json, application/fhir+json");
    return res.getContent();
  }

  private ITerminologyClient connectToServer(Set<String> modes) throws URISyntaxException, IOException {
    log.info("Connect to "+server);
    software = server;
    
    if (outputDir == null) {
      outputDir = Utilities.path("[tmp]", serverId());
    }
    
    String fhirVersion = null;
    try {
      String actFn = this.outputDir == null ?  Utilities.path("[tmp]", serverId(), "actual", "$versions.json") : Utilities.path(this.outputDir, "actual", "$versions.json");
      byte[] vr = fetch(Utilities.pathURL(server, "$versions", "?_format=json"));
      FileUtilities.bytesToFile(vr, actFn);
      JsonObject vl = JsonParser.parseObject(vr);
      if ("Parameters".equals(vl.asString("resourceType"))) {
        for (JsonObject v : vl.forceArray("parameter").asJsonObjects()) {
          if ("default".equals(v.asString("name"))) {
            fhirVersion = v.asString("valueString");
          }
        }
      } else if (vl.has("default")) {
        fhirVersion = vl.asString("default");
      } else {
        log.warn("Unable to interpret response from $versions: "+vl.toString());
      }
      if (fhirVersion != null) {
        log.info("Server version "+fhirVersion+" from $versions");
      }
      
    } catch (Exception e) {
      log.warn("Server does not support $versions: "+e.getMessage(), e);
    }
    if (fhirVersion == null) {
      try {
        JsonObject cs = JsonParser.parseObjectFromUrl(Utilities.pathURL(server, "metadata", "?_format=json"));
        fhirVersion = cs.asString("fhirVersion");
        log.info("Server version "+fhirVersion+" from /metadata");
      } catch (Exception e) {
        log.warn("Error checking server version: "+e.getMessage(), e);
        log.warn("Defaulting to FHIR R4");
        fhirVersion = "4.0";
      }
    }
    
    ITerminologyClient client = null;
    
    if (VersionUtilities.isR5Plus(fhirVersion)) {
      client = new TerminologyClientFactory(FhirPublication.R5).makeClient("Test-Server", server, "Tools/Java", null);      
    } else if (VersionUtilities.isR4Plus(fhirVersion)) {
      FileUtilities.createDirectory(Utilities.path(outputDir, "conversions", "r4"));
      FileUtilities.createDirectory(Utilities.path(outputDir, "conversions", "r5"));    
      client = new TerminologyClientFactory(FhirPublication.R4).makeClient("Test-Server", server, "Tools/Java", null);
      client.setConversionLogger(conversionLogger); 
    } else {
      throw new FHIRException("unsupported FHIR Version for terminology tests: "+fhirVersion);
    }
    return client;  
  }


  public String executeTest(ITxTesterLoader loader, JsonObject suite, JsonObject test, Set<String> modes) throws URISyntaxException, FHIRFormatError, FileNotFoundException, IOException {
    error = null;
    if (!passesModes(suite, modes) || !passesModes(test, modes)) {
      return "n/a";
    }

      if (terminologyClient == null) {
      terminologyClient = connectToServer(modes);
      checkClient();
    }
    List<Resource> setup = loadSetupResources(loader, suite);
    TestReportTestComponent tr = getTestReportTest(suite, test);

    if (runTest(loader, suite, test, setup, modes, "*", null, new IntHolder(), tr)) {
      return null;      
    } else {
      return error;
    }
  }

  private boolean passesModes(JsonObject obj, Set<String> modes) {
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

  private boolean runSuite(ITxTesterLoader loader, JsonObject suite, Set<String> modes, String filter, JsonArray output, IntHolder counter, IntHolder errCount) throws FHIRFormatError, FileNotFoundException, IOException {
    log.info("Group "+suite.asString("name"));
    JsonObject outputS = new JsonObject();
    if (output != null) {
      output.add(outputS);
    }
    outputS.add("name", suite.asString("name"));
    List<Resource> setup = loadSetupResources(loader, suite);
    boolean ok = true;
    for (JsonObject test : suite.getJsonObjects("tests")) {
      TestReportTestComponent tr = getTestReportTest(suite, test);
      if ((!test.has("mode") || modes.contains(test.asString("mode")))) {
        if (test.asBoolean("disabled")) {
          ok = true;
        } else {
          boolean tok = runTest(loader, suite, test, setup, modes, filter, outputS.forceArray("tests"), counter, tr);
          if (!tok) {
            errCount.count();
          }
          ok = tok && ok;
        }
      }
    }
    return ok;
  }

  private boolean runTest(ITxTesterLoader loader, JsonObject suite, JsonObject test, List<Resource> setup, Set<String> modes, String filter, 
      JsonArray output, IntHolder counter, TestReportTestComponent tr) throws FHIRFormatError, DefinitionException, FileNotFoundException, FHIRException, IOException { 
    JsonObject outputT = new JsonObject();
    if (output != null) {
      output.add(outputT);
    }
    long start = System.currentTimeMillis();
    Parameters profile = loadProfile(loader, test);
    String testName = test.asString("name");
    outputT.add("name", testName);
    if (Utilities.noString(filter) || filter.equals("*") || testName.contains(filter)) {
      log.info("  Testing "+ testName +": ");
      HTTPHeader header = null;
      try {
        counter.count();
        if (test.has("header")) {
          JsonObject hdr = test.getJsonObject("header");
          if (hdr.has("mode") && modes.contains(hdr.asString("mode"))) {
            header = new HTTPHeader(hdr.asString("name"), hdr.asString("value"));
            terminologyClient.setClientHeaders(new ClientHeaders(List.of(header)));
          }
        }
        conversionLogger.suiteName = suite.asString("name");
        conversionLogger.testName = testName;
        String reqFile = chooseParam(test, "request", modes);
        Resource req = reqFile == null ? null : loader.loadResource(reqFile);

        String fn = chooseParam(test, "response", modes);
        String resp = FileUtilities.bytesToString(loader.loadContent(fn));
        String expFn = this.outputDir == null ?  Utilities.path("[tmp]", serverId(), "expected", fn) : Utilities.path(this.outputDir, "expected", fn);
        String actFn = this.outputDir == null ?  Utilities.path("[tmp]", serverId(), "actual", fn) : Utilities.path(this.outputDir, "actual", fn);
        File fo = ManagedFileAccess.file(expFn);
        if (fo.exists()) {
          fo.delete();
        }
        fo = ManagedFileAccess.file(actFn);
        if (fo.exists()) {
          fo.delete();
        }

        JsonObject ext = externals == null ? null : externals.getJsonObject(fn);

        String lang = test.asString("Accept-Language");
        String msg = null;
        if (test.asString("operation").equals("metadata")) {
          msg = metadata(test.str("name"), setup, resp, expFn, actFn, lang, profile, ext, modes);
        } else if (test.asString("operation").equals("term-caps")) {
          msg = termcaps(test.str("name"), setup, resp, expFn, actFn, lang, profile, ext, modes);
        } else if (test.asString("operation").equals("expand")) {
          msg = expand(test.str("name"), setup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("validate-code")) {
          msg = validate(test.str("name"), setup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);      
        } else if (test.asString("operation").equals("cs-validate-code")) {
          msg = validateCS(test.str("name"), setup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);      
        } else if (test.asString("operation").equals("lookup")) {
          msg = lookup(test.str("name"), setup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);      
        } else if (test.asString("operation").equals("translate")) {
          msg = translate(test.str("name"), setup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("batch")) {
          msg = batch(test.str("name"), setup, (Bundle) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else if (test.asString("operation").equals("batch-validate")) {
          msg = batchValidate(test.str("name"), setup, (Parameters) req, resp, expFn, actFn, lang, profile, ext, getResponseCode(test), modes);
        } else {
          throw new Exception("Unknown Operation "+test.asString("operation"));
        }

       log.info("   -- "+ testName +": " + (msg == null ? "Pass" : "Fail") + " ("+Utilities.describeDuration(System.currentTimeMillis() - start)+")");
        if (msg != null) {
          log.error("    "+msg);
          error = msg;
          fails.add(suite.asString("name")+"/"+ testName);
        }  
        outputT.add("status", msg == null ? "pass" : "fail");
        if (msg != null) {
          outputT.add("message", msg);
        }
        if (header != null) {
          terminologyClient.setClientHeaders(new ClientHeaders());
        }
        tr.getActionFirstRep().getOperation().setResult(msg == null ? TestReportActionResult.PASS : TestReportActionResult.FAIL).setMessage(msg);
        return msg == null;
      } catch (Exception e) {
        log.error("  Tested "+ testName +": "+ "  ... Exception: "+e.getMessage());

        fails.add(suite.asString("name")+"/"+ testName);
        error = e.getMessage();
        log.error(e.getMessage(), e);
        if (header != null) {
          terminologyClient.setClientHeaders(new ClientHeaders());
        }
        tr.getActionFirstRep().getOperation().setResult(TestReportActionResult.ERROR).setMessage(e.getMessage());
        return false;
      }
    } else {
      outputT.add("status", "ignored");
      tr.getActionFirstRep().getOperation().setResult(TestReportActionResult.SKIP);
      return true;
    }
  }

  private String metadata(String id, List<Resource> setup, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, Set<String> modes) throws IOException {
    CapabilityStatement cs = cstmt.copy();
    TxTesterScrubbers.scrubCapStmt(cs, tight);
    TxTesterSorters.sortCapStmt(cs);
    String csj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(cs);

    String diff = new CompareUtilities(modes, ext, vars()).setPatternMode(true).checkJsonSrcIsSame(id, resp, csj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(csj, actFn);
    }
    return diff;
  }

  private String termcaps(String id, List<Resource> setup, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, Set<String> modes) throws IOException {
    TerminologyCapabilities cs = tc.copy();
    TxTesterScrubbers.scrubTermCaps(cs, tight);
    TxTesterSorters.sortTermCaps(cs);
    String csj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(cs);

    String diff = new CompareUtilities(modes, ext, vars()).setPatternMode(true).checkJsonSrcIsSame(id, resp, csj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(csj, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(resp, actFn);
    }
    return diff;
  }

  private String getResponseCode(JsonObject test) {
    if (test.has("http-code")) {
      return test.asString("http-code");
    } else {
      return "2xx";
    }
  }

  private String chooseParam(JsonObject test, String name, Set<String> modes) {
    for (String mode : modes) {
      if (test.has(name+":"+mode)) {
        return test.asString(name+":"+mode);
      }
    }
    return test.asString(name);
  }

  private Parameters loadProfile(ITxTesterLoader loader, JsonObject test) throws FHIRFormatError, DefinitionException, FileNotFoundException, FHIRException, IOException {
    if (test.has("profile")) {        
      return (Parameters) loader.loadResource(test.asString("profile"));
    } else {
      return (Parameters) loader.loadResource("parameters-default.json");
    }
  }

  private String serverId() throws URISyntaxException {
    return new URI(server).getHost();
  }

  private String lookup(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    terminologyClient.setAcceptLanguage(lang);
    p.getParameter().addAll(profile.getParameter());
    int code = 0;
    String pj;
    try {
      Parameters po = terminologyClient.lookupCode(p);
      TxTesterScrubbers.scrubParams(po);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError(); 
      TxTesterScrubbers.scrubOO(oo, tight);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, pj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(pj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String translate(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    terminologyClient.setAcceptLanguage(lang);
    p.getParameter().addAll(profile.getParameter());
    int code = 0;
    String pj;
    try {
      Parameters po = terminologyClient.translate(p);
      TxTesterScrubbers.scrubParams(po);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError(); 
      TxTesterScrubbers.scrubOO(oo, tight);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, pj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(pj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String expand(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    terminologyClient.setAcceptLanguage(lang);
    p.getParameter().addAll(profile.getParameter());
    int code = 0;
    String vsj;
    try {
      ValueSet vs = terminologyClient.expandValueset(null, p);
      TxTesterScrubbers.scrubVS(vs, tight);
      TxTesterSorters.sortValueSet(vs);
      vsj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(vs);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError(); 
      TxTesterScrubbers.scrubOO(oo, tight);
      vsj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, vsj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(vsj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private boolean httpCodeOk(String tcode, int code) {
    switch (tcode) {
    case "2xx" : return code >= 200 && code < 300;
    case "3xx" : return code >= 300 && code < 400;
    case "4xx" : return code >= 400 && code < 500;
    case "5xx" : return code >= 500 && code < 600;
    default:
      throw new Error("unknown code string "+tcode);
    }
  }

  private String batchValidate(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameter().addAll(profile.getParameter());
    terminologyClient.setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = terminologyClient.batchValidateVS(p);
      TxTesterScrubbers.scrubParams(po);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError();
      TxTesterScrubbers.scrubOO(oo, tight);
      oo.setText(null);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, pj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(pj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String validate(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameter().addAll(profile.getParameter());
    terminologyClient.setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = terminologyClient.validateVS(p);
      TxTesterScrubbers.scrubParams(po);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError(); 
      TxTesterScrubbers.scrubOO(oo, tight);
      oo.setText(null);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, pj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(pj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }
  
  private String validateCS(String id, List<Resource> setup, Parameters p, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameter().addAll(profile.getParameter());
    terminologyClient.setAcceptLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = terminologyClient.validateCS(p);
      TxTesterScrubbers.scrubParams(po);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(po);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError(); 
      oo.setText(null);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, pj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(pj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }

  private String batch(String id, List<Resource> setup, Bundle bnd, String resp, String expFn, String actFn, String lang, Parameters profile, JsonObject ext, String tcode, Set<String> modes) throws IOException {
    for (Resource r : setup) {
      Parameters p = (Parameters) bnd.getEntryFirstRep().getResource();
      p.addParameter().setName("tx-resource").setResource(r);
    }
    terminologyClient.setAcceptLanguage(lang);
    for (BundleEntryComponent be : bnd.getEntry()) {
      ((Parameters) be.getResource()).getParameter().addAll(profile.getParameter());
    }
    int code = 0;
    String bj;
    try {
      Bundle bo = terminologyClient.batch(bnd);
      for (BundleEntryComponent be : bo.getEntry()) {
        if (be.getResource() instanceof Parameters) {
          Parameters po = ((Parameters) be.getResource());
          TxTesterScrubbers.scrubParams(po);
          TxTesterSorters.sortParameters(po);
        }
        if (be.getResource() instanceof OperationOutcome) {
          OperationOutcome oo = ((OperationOutcome) be.getResource());
          TxTesterScrubbers.scrubOO(oo, tight);          
        }
      }
      bj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(bo);
      code = 200;
    } catch (EFhirClientException e) {
      code = e.getCode();
      OperationOutcome oo = e.getServerError(); 
      TxTesterScrubbers.scrubOO(oo, tight);
      bj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = new CompareUtilities(modes, ext, vars()).checkJsonSrcIsSame(id, resp, bj, false);
    if (diff != null) {
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(expFn));
      FileUtilities.stringToFile(resp, expFn);
      FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(actFn));
      FileUtilities.stringToFile(bj, actFn);
    }
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    return diff;
  }


  private Map<String, String> vars() {
    Map<String, String> vars = new HashMap<String, String>();
    vars.put("version", terminologyClient.getActualVersion().toCode());
    return vars;
    
  }

  private List<Resource> loadSetupResources(ITxTesterLoader loader, JsonObject suite) throws FHIRFormatError, FileNotFoundException, IOException {
    List<Resource> res = new ArrayList<>();
    for (String s : suite.getStrings("setup")) {
      res.add(loader.loadResource(s));
    }
    return res;
  }
  
  public String getOutput() {
    return outputDir;
  }

  public TxTester setOutput(String output) {
    this.outputDir = output;
    return this;
  }

  public static class InternalTxLoader implements ITxTesterLoader {
    
    private TxTestData txtests;
    private boolean additional;
    
    public InternalTxLoader(String version) throws IOException {
      File f = ManagedFileAccess.file(version);
      if (f.exists() && f.isDirectory()) {
        txtests = TxTestData.loadTestDataFromFolder(f, "test-cases.json");
      } else {
        load(version);
      }
    }

    public InternalTxLoader(String source, boolean additional) throws IOException {
      this.additional = additional;
      File f = ManagedFileAccess.file(source);
      if (f.exists() && f.isDirectory()) {
        txtests = TxTestData.loadTestDataFromFolder(f, "test-cases.json");
      } else if (f.exists()) {
        txtests = TxTestData.loadTestDataFromFolder(ManagedFileAccess.file(FileUtilities.getDirectoryForFile(source)), f.getName());
      } else {
        load(source);
      }
    }
    
    private void load(String version) throws IOException {
      txtests = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#"+version);
    }

    @Override
    public String describe() {
      return txtests.describe();
    }

    @Override
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
      Resource res = new org.hl7.fhir.r5.formats.JsonParser().parse(txtests.load(filename));
//        org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(res);
//        String p = Utilities.path(folder, "r4", filename);
//        Utilities.createDirectory(Utilities.getDirectoryForFile(p));
//        new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(p), r4);
//      } catch (Exception e) {
//        // nothing...
//      }      
      return res;
    }

    @Override
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException {
      return txtests.loadBytes(filename);
    }

    @Override
    public boolean hasContent(String filename) throws IOException {
      return txtests.hasFile(filename);
    }

    @Override
    public String code() {
      return txtests.code();
    }

    @Override
    public String version() throws JsonException, IOException {
      return txtests.loadVersion();
    }

    @Override
    public String testFileName() {
      return txtests.testFileName();
    }
  }

  public TestReport getTestReport() {
    return testReport;
  }


}
