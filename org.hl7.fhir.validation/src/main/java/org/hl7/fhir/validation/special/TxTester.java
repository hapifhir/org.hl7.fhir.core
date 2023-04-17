package org.hl7.fhir.validation.special;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.utils.client.EFhirClientException;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.NpmPackage;

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
  

  public TxTester(ITxTesterLoader loader) {
    super();
    this.loader = loader;
  }

  public static void main(String[] args) throws Exception {
    new TxTester(new InternalTxLoader(args[0])).execute(args[1], args[2], args[3]);
  }
  
  public boolean execute(String server, String version, String filter) throws IOException, URISyntaxException {
    this.server = server;
    if (output == null) {
      output = Utilities.path("[tmp]", serverId());
    }
    
    System.out.println("Run terminology service Tests");
    System.out.println("  Source for tests: "+loader.describe());
    System.out.println("  Output Directory: "+output);
    System.out.println("  Term Service Url: "+server);
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
      TerminologyClient tx = connectToServer();
      boolean ok = checkClient(tx);
      for (JsonObject suite : tests.getJsonObjects("suites")) {
        ok = runSuite(suite, tx, filter, json.forceArray("suites")) && ok;
      }
      TextFile.stringToFile(JsonParser.compose(json, true), Utilities.path(output, "test-results.json"));
      if (ok) {
        System.out.println("Terminology Service Tests all passed");
        return true;
      } else {
        System.out.println("Terminology Service Tests did not all pass");
        return false;
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

  private boolean checkClient(TerminologyClient tx) {
    tx.getCapabilitiesStatementQuick();
    tx.getTerminologyCapabilities();
    return true;
  }

  private JsonObject loadTests() throws JsonException, IOException {
    System.out.println("Load Tests from "+loader.describe());
    return JsonParser.parseObject(loader.loadContent("test-cases.json"));
  }

  private TerminologyClient connectToServer() throws URISyntaxException {
    System.out.println("Connect to "+server);
    return TerminologyClientFactory.makeClient("Test-Server", server, "Tools/Java", FhirPublication.R4);  
  }


  public String executeTest(JsonObject suite, JsonObject test, String server) throws URISyntaxException, FHIRFormatError, FileNotFoundException, IOException {
    this.server = server;
    error = null;
    TerminologyClient tx = connectToServer();
    checkClient(tx);
    List<Resource> setup = loadSetupResources(suite);
    if (runTest(test, tx, setup, "*", null)) {
      return null;      
    } else {
      return error;
    }
  }
  private boolean runSuite(JsonObject suite, TerminologyClient tx, String filter, JsonArray output) throws FHIRFormatError, FileNotFoundException, IOException {
    System.out.println("Group "+suite.asString("name"));
    JsonObject outputS = new JsonObject();
    if (output != null) {
      output.add(outputS);
    }
    outputS.add("name", suite.asString("name"));
    List<Resource> setup = loadSetupResources(suite);
    boolean ok = true;
    for (JsonObject test : suite.getJsonObjects("tests")) {
      ok = runTest(test, tx, setup, filter, outputS.forceArray("tests")) && ok;      
    }
    return ok;
  }

  private boolean runTest(JsonObject test, TerminologyClient tx, List<Resource> setup, String filter, JsonArray output) { 
    JsonObject outputT = new JsonObject();
    if (output != null) {
      output.add(outputT);
    }
    outputT.add("name", test.asString("name"));
    if (Utilities.noString(filter) || filter.equals("*") || test.asString("name").contains(filter)) {
      System.out.print("  Test "+test.asString("name")+": ");
      try {
        Parameters req = (Parameters) loader.loadResource(test.asString("request"));

        String fn = test.asString("response");
        String resp = TextFile.bytesToString(loader.loadContent(fn));
        String fp = Utilities.path("[tmp]", serverId(), fn);
        File fo = new File(fp);
        if (fo.exists()) {
          fo.delete();
        }

        String msg = null;
        if (test.asString("operation").equals("expand")) {
          msg = expand(tx, setup, req, resp, fp);
        } else if (test.asString("operation").equals("validate-code")) {
          msg = validate(tx, setup, req, resp, fp);      
        } else {
          throw new Exception("Unknown Operation "+test.asString("operation"));
        }

        System.out.println(msg == null ? "Pass" : "Fail");
        if (msg != null) {
          System.out.println("    "+msg);
          error = msg;
        }  
        outputT.add("status", msg == null ? "pass" : "fail");
        if (msg != null) {
          outputT.add("message", msg);
        }
        return msg == null;
      } catch (Exception e) {
        System.out.println("  ... Exception: "+e.getMessage());
        System.out.print("    ");
        error = e.getMessage();
        e.printStackTrace();
        return false;
      }
    } else {
      outputT.add("status", "ignored");
      return true;
    }
  }

  private String serverId() throws URISyntaxException {
    return new URI(server).getHost();
  }

  private String expand(TerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    String vsj;
    try {
      ValueSet vs = tx.expandValueset(null, p, null);
      vs.setText(null);
      TxTesterSorters.sortValueSet(vs);
      vsj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(vs);
    } catch (EFhirClientException e) {
      OperationOutcome oo = e.getServerErrors().get(0); 
      oo.setText(null);
      vsj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(resp, vsj);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(vsj, fp);        
    }
    return diff;
  }

  private String validate(TerminologyClient tx, List<Resource> setup, Parameters p, String resp, String fp) throws IOException {
    for (Resource r : setup) {
      p.addParameter().setName("tx-resource").setResource(r);
    }
    String pj;
    try {
      Parameters po = tx.validateVS(p);
      TxTesterSorters.sortParameters(po);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(po);
    } catch (EFhirClientException e) {
      OperationOutcome oo = e.getServerErrors().get(0); 
      oo.setText(null);
      pj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
    }
    String diff = CompareUtilities.checkJsonSrcIsSame(resp, pj);
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
            String pathString = path.toFile().getAbsolutePath();
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
      return new org.hl7.fhir.r5.formats.JsonParser().parse(new FileInputStream(Utilities.path(folder, filename)));
    }

    @Override
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException {
      return TextFile.fileToBytes(Utilities.path(folder, filename));
    }
  }

}
