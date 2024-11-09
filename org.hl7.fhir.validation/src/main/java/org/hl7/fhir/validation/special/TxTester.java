package org.hl7.fhir.validation.special;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class TxTester {


  public interface ITxTesterLoader {
    public String describe();
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException;
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException;
  }
  
  private String server;
  private ITxTesterLoader loader;
  private String error;
  private String output;
  private ITerminologyClient tx;
  private boolean tight;
  private JsonObject externals;
  private String software;
  private List<String> fails = new ArrayList<>();
  

  public TxTester(ITxTesterLoader loader, String server, boolean tight, JsonObject externals) {
    super();
    this.server = server;
    this.loader = loader;
    this.tight = tight;
    this.externals = externals;
  }

  public static void main(String[] args) throws Exception {
    new TxTester(new InternalTxLoader(args[0]), args[1], "true".equals(args[2]), args.length == 5 ? JsonParser.parseObjectFromFile(args[4]) : null).execute(args[2], new ArrayList<>(), args[3]);
  }
  
  public boolean execute(String version, List<String> modes, String filter) throws IOException, URISyntaxException {
    if (output == null) {
      output = Utilities.path("[tmp]", serverId());
    }
    
    System.out.println("Run terminology service Tests");
    System.out.println("  Source for tests: "+loader.describe());
    System.out.println("  Output Directory: "+output);
    if (!new File(output).exists()) {
      Utilities.createDirectory(output);
    }
    if (!new File(output).exists()) {
      throw new IOException("Unable to create output directory "+output);
    }
    System.out.println("  Term Service Url: "+server);
    System.out.println("  External Strings: "+(externals != null));
    System.out.println("  Test  Exec Modes: "+modes.toString());
    if (version != null) {
      System.out.println("  Tx  FHIR Version: "+version);
    }
    if (filter != null) {
      System.out.println("  Filter Parameter: "+filter);
    }
    
    JsonObject json = new JsonObject();
    json.add("date", new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US")).format(Calendar.getInstance().getTime()) + timezone());
    try {
      JsonObject tests = loadTests();
      ITerminologyClient tx = connectToServer(modes);
      boolean ok = checkClient(tx);
      for (JsonObject suite : tests.getJsonObjects("suites")) {
        if ((!suite.has("mode") || modes.contains(suite.asString("mode")))) {
          if (suite.asBoolean("disabled")) {
            // ok = true;
          } else {
            ok = runSuite(suite, tx, modes, filter, json.forceArray("suites")) && ok;
          }
        }
      }
      TextFile.stringToFile(JsonParser.compose(json, true), Utilities.path(output, "test-results.json"));

      if (filter == null) {
        String m = modes.isEmpty() ? "[none]" : CommaSeparatedStringBuilder.join(";", modes);
        if (ok) {
          System.out.println(software+" passed all HL7 terminology service tests (modes "+m+", tests v"+loadVersion()+", runner v"+VersionUtil.getBaseVersion()+")");
          return true;
        } else {
          System.out.println(software+" did not pass all HL7 terminology service tests (modes "+m+", tests v"+loadVersion()+", runner v"+VersionUtil.getBaseVersion()+")");
          System.out.println("Failed Tests: "+ CommaSeparatedStringBuilder.join(",", fails ));
          return false;
        }        
      } else {
        System.out.println(software+" "+(ok ? "Passed the tests" : "did not pass the tests")+" '"+filter+"'");
        return ok;
      }
    } catch (Exception e) {
      System.out.println("Exception running Terminology Service Tests: "+e.getMessage());
      e.printStackTrace();
      return false;
    }
  }
  

  private String timezone() {
    TimeZone tz = TimeZone.getDefault();
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
    offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

    return offset;
  }

  private boolean checkClient(ITerminologyClient tx) {
    CapabilityStatement cstmt =  tx.getCapabilitiesStatementQuick();
    if (cstmt.hasSoftware()) {
      software = cstmt.getSoftware().getName()+" v"+cstmt.getSoftware().getVersion();
    }
    tx.getTerminologyCapabilities();
    return true;
  }

  private JsonObject loadTests() throws JsonException, IOException {
    System.out.println("Load Tests from "+loader.describe());
    return JsonParser.parseObject(loader.loadContent("test-cases.json"));
  }
  
  private String loadVersion() throws JsonException, IOException {
    return processHistoryMarkdown(loader.loadContent("history.md"));
  }

  private String processHistoryMarkdown(byte[] content) throws IOException {
    DataInputStream in = new DataInputStream(new ByteArrayInputStream(content));
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    try {
      String strLine;
      //Read File Line By Line
      while ((strLine = br.readLine()) != null)   {
        if (strLine.startsWith("## ")) {
          return strLine.substring(3);
        }
      }
    } finally {
      br.close();
      in.close();
    }
    return "<1.6.0";
  }

  private ITerminologyClient connectToServer(List<String> modes) throws URISyntaxException {
    System.out.println("Connect to "+server);
    software = server;
    ITerminologyClient client = new TerminologyClientFactory(FhirPublication.R4).makeClient("Test-Server", server, "Tools/Java", null);
    return client;  
  }


  public String executeTest(JsonObject suite, JsonObject test, List<String> modes) throws URISyntaxException, FHIRFormatError, FileNotFoundException, IOException {
    error = null;
    if (tx == null) {
      tx = connectToServer(modes);
      checkClient(tx);
    }
    List<Resource> setup = loadSetupResources(suite);

    if (runTest(suite, test, tx, setup, modes, "*", null)) {
      return null;      
    } else {
      return error;
    }
  }
  
  private boolean runSuite(JsonObject suite, ITerminologyClient tx, List<String> modes, String filter, JsonArray output) throws FHIRFormatError, FileNotFoundException, IOException {
    System.out.println("Group "+suite.asString("name"));
    JsonObject outputS = new JsonObject();
    if (output != null) {
      output.add(outputS);
    }
    outputS.add("name", suite.asString("name"));
    List<Resource> setup = loadSetupResources(suite);
    boolean ok = true;
    for (JsonObject test : suite.getJsonObjects("tests")) {
      if ((!test.has("mode") || modes.contains(test.asString("mode")))) {
        if (test.asBoolean("disabled")) {
          ok = true;
        } else {
          ok = runTest(suite, test, tx, setup, modes, filter, outputS.forceArray("tests")) && ok;
        }
      }
    }
    return ok;
  }

  private boolean runTest(JsonObject suite, JsonObject test, ITerminologyClient tx, List<Resource> setup, List<String> modes, String filter, JsonArray output) throws FHIRFormatError, DefinitionException, FileNotFoundException, FHIRException, IOException { 
    JsonObject outputT = new JsonObject();
    if (output != null) {
      output.add(outputT);
    }
    long start = System.currentTimeMillis();
    Parameters profile = loadProfile(test);
    outputT.add("name", test.asString("name"));
    if (Utilities.noString(filter) || filter.equals("*") || test.asString("name").contains(filter)) {
      System.out.print("  Test "+test.asString("name")+": ");
      HTTPHeader header = null;
      try {
        if (test.has("header")) {
          JsonObject hdr = test.getJsonObject("header");
          if (hdr.has("mode") && modes.contains(hdr.asString("mode"))) {
            header = new HTTPHeader(hdr.asString("name"), hdr.asString("value"));
            tx.getClientHeaders().addHeader(header);
          }
        }

        Parameters req = (Parameters) loader.loadResource(chooseParam(test, "request", modes));

        String fn = chooseParam(test, "response", modes);
        String resp = TextFile.bytesToString(loader.loadContent(fn));
        String fp = this.output == null ?  Utilities.path("[tmp]", serverId(), fn) : Utilities.path(this.output, fn);
        File fo = ManagedFileAccess.file(fp);
        if (fo.exists()) {
          fo.delete();
        }
        JsonObject ext = externals == null ? null : externals.getJsonObject(fn);

        String lang = test.asString("Content-Language");
        String msg = null;
        if (test.asString("operation").equals("expand")) {
          msg = expand(test.str("name"), tx, setup, req, resp, fp, lang, profile, ext, getResponseCode(test));
        } else if (test.asString("operation").equals("validate-code")) {
          msg = validate(test.str("name"),tx, setup, req, resp, fp, lang, profile, ext, getResponseCode(test));      
        } else if (test.asString("operation").equals("cs-validate-code")) {
          msg = validateCS(test.str("name"),tx, setup, req, resp, fp, lang, profile, ext, getResponseCode(test));      
        } else if (test.asString("operation").equals("lookup")) {
          msg = lookup(test.str("name"),tx, setup, req, resp, fp, lang, profile, ext, getResponseCode(test));      
        } else if (test.asString("operation").equals("translate")) {
          msg = translate(test.str("name"),tx, setup, req, resp, fp, lang, profile, ext, getResponseCode(test));      
        } else {
          throw new Exception("Unknown Operation "+test.asString("operation"));
        }

        System.out.println((msg == null ? "Pass" : "Fail") + " ("+Utilities.describeDuration(System.currentTimeMillis() - start)+")");
        if (msg != null) {
          System.out.println("    "+msg);
          error = msg;
          fails.add(suite.asString("name")+"/"+test.asString("name"));
        }  
        outputT.add("status", msg == null ? "pass" : "fail");
        if (msg != null) {
          outputT.add("message", msg);
        }
        if (header != null) {
          tx.getClientHeaders().removeHeader(header);
        }
        return msg == null;
      } catch (Exception e) {
        System.out.println("  ... Exception: "+e.getMessage());
        System.out.print("    ");
        fails.add(suite.asString("name")+"/"+test.asString("name"));
        error = e.getMessage();
        e.printStackTrace();
        if (header != null) {
          tx.getClientHeaders().removeHeader(header);
        }
        return false;
      }
    } else {
      outputT.add("status", "ignored");
      return true;
    }
  }

  private String getResponseCode(JsonObject test) {
    if (test.has("http-code")) {
      return test.asString("http-code");
    } else {
      return "2xx";
    }
  }

  private String chooseParam(JsonObject test, String name, List<String> modes) {
    for (String mode : modes) {
      if (test.has(name+":"+mode)) {
        return test.asString(name+":"+mode);
      }
    }
    return test.asString(name);
  }

  private Parameters loadProfile(JsonObject test) throws FHIRFormatError, DefinitionException, FileNotFoundException, FHIRException, IOException {
    if (test.has("profile")) {        
      return (Parameters) loader.loadResource(test.asString("profile"));
    } else {
      return (Parameters) loader.loadResource("parameters-default.json");
    }
  }

  private String serverId() throws URISyntaxException {
    return new URI(server).getHost();
  }

  private String lookup(String id, ITerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp, String lang, Parameters profile, JsonObject ext, String tcode) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    tx.setContentLanguage(lang);
    p.getParameter().addAll(profile.getParameter());
    int code = 0;
    String pj;
    try {
      Parameters po = tx.lookupCode(p);
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
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(id, resp, pj, false, ext);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(pj, fp);        
    }
    return diff;
  }

  private String translate(String id, ITerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp, String lang, Parameters profile, JsonObject ext, String tcode) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    tx.setContentLanguage(lang);
    p.getParameter().addAll(profile.getParameter());
    int code = 0;
    String pj;
    try {
      Parameters po = tx.translate(p);
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
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(id, resp, pj, false, ext);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(pj, fp);        
    }
    return diff;
  }

  private String expand(String id, ITerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp, String lang, Parameters profile, JsonObject ext, String tcode) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    tx.setContentLanguage(lang);
    p.getParameter().addAll(profile.getParameter());
    int code = 0;
    String vsj;
    try {
      ValueSet vs = tx.expandValueset(null, p);
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
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(id, resp, vsj, false, ext);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(vsj, fp);        
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

  private String validate(String id, ITerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp, String lang, Parameters profile, JsonObject ext, String tcode) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameter().addAll(profile.getParameter());
    tx.setContentLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = tx.validateVS(p);
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
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(id, resp, pj, false, ext);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(pj, fp);        
    }
    return diff;
  }
  
  private String validateCS(String id, ITerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp, String lang, Parameters profile, JsonObject ext, String tcode) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    p.getParameter().addAll(profile.getParameter());
    tx.setContentLanguage(lang);
    int code = 0;
    String pj;
    try {
      Parameters po = tx.validateCS(p);
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
    if (tcode != null && !httpCodeOk(tcode, code)) {
      return "Response Code fail: should be '"+tcode+"' but is '"+code+"'";
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(id, resp, pj, false, ext);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(pj, fp);        
    }
    return diff;
  }


  private List<Resource> loadSetupResources(JsonObject suite) throws FHIRFormatError, FileNotFoundException, IOException {
    List<Resource> res = new ArrayList<>();
    for (String s : suite.getStrings("setup")) {
      res.add(loader.loadResource(s));
    }
    return res;
  }
  
  public String getOutput() {
    return output;
  }

  public TxTester setOutput(String output) {
    this.output = output;
    return this;
  }

  public static class InternalTxLoader implements ITxTesterLoader {

    private String folder;
    
    public InternalTxLoader(String folder) {
      this.folder = folder;
    }
    
    public InternalTxLoader(String source, String local) throws IOException {
      if (source.startsWith("http://") || source.startsWith("https://")) {
        this.folder = Utilities.path(local, "source");

        URL url = new URL(zipUrl(source));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStream zip = connection.getInputStream();
        unzip(zip); 
      } else {
        this.folder = source;
      }
    }

    public void unzip(InputStream is) throws IOException {
      try (ZipInputStream zipIn = new ZipInputStream(is)) {
        for (ZipEntry ze; (ze = zipIn.getNextEntry()) != null; ) {
          if (ze.getName().startsWith("fhir-test-cases-master/tx/")) {
            Path path = Path.of(Utilities.path(this.folder, ze.getName().substring(26))).normalize();
            String pathString = ManagedFileAccess.fromPath(path).getAbsolutePath();
            if (!path.startsWith(Path.of(this.folder).normalize())) {
              // see: https://snyk.io/research/zip-slip-vulnerability
              throw new RuntimeException("Entry with an illegal path: " + ze.getName());
            }
            if (ze.isDirectory()) {
              Utilities.createDirectory(pathString);
            } else {
              Utilities.createDirectory(Utilities.getDirectoryForFile(pathString));
              TextFile.streamToFileNoClose(zipIn, pathString);
            }
          }
        }
      }
    }


    private String zipUrl(String template) {
      if (!template.startsWith("https://github.")) {
        throw new FHIRException("Cannot refer to source by URL unless referring to a github repository: "+template);
      } else if (Utilities.charCount(template, '/') == 4) {
        return Utilities.pathURL(template, "archive", "master.zip");      
      } else if (Utilities.charCount(template, '/') == 6) {
        String[] p = template.split("\\/");
        return Utilities.pathURL("https://"+p[2], p[3], p[4], "archive", p[6]+".zip");      
      } else {
        throw new FHIRException("Source syntax in URL referring to a github repository was not understood: "+template);
      }
    }

    
    @Override
    public String describe() {
      return folder;
    }

    @Override
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
      Resource res = new org.hl7.fhir.r5.formats.JsonParser().parse(ManagedFileAccess.inStream(Utilities.path(folder, filename)));
      org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(res);
      String p = Utilities.path(folder, "r4", filename);
      Utilities.createDirectory(Utilities.getDirectoryForFile(p));
      new org.hl7.fhir.r4.formats.JsonParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(p), r4);
      return res;
    }

    @Override
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException {
      return TextFile.fileToBytes(Utilities.path(folder, filename));
    }
  }

}
