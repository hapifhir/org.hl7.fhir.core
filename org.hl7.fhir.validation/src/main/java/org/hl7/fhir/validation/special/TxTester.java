package org.hl7.fhir.validation.special;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.txClient.TerminologyClientFactory;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.special.TxTester.ITxTesterLoader;
import org.hl7.fhir.validation.special.TxTester.InternalLoader;

public class TxTester {


  public interface ITxTesterLoader {
    public String describe();
    public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException;
    public byte[] loadContent(String filename) throws FileNotFoundException, IOException;
  }
  
  private String server;
  private ITxTesterLoader loader;
  private String error;
  

  public TxTester(ITxTesterLoader loader) {
    super();
    this.loader = loader;
  }

  public static void main(String[] args) throws Exception {
    new TxTester(new InternalLoader(args[0])).execute(args[1], args[2]);
  }
  
  public void execute(String server, String filter) {
    this.server = server;
    System.out.println("Run terminology service Tests");
    
    try {
      JsonObject tests = loadTests();
      TerminologyClient tx = connectToServer();
      boolean ok = checkClient(tx);
      for (JsonObject suite : tests.getJsonObjects("suites")) {
        ok = runSuite(suite, tx, filter) && ok;
      }
      if (ok) {
        System.out.println("Terminology Service Tests all passed");
      } else {
        System.out.println("Terminology Service Tests did not all pass");
      }        
    } catch (Exception e) {
      System.out.println("Exception running Terminology Service Tests: "+e.getMessage());
      e.printStackTrace();
    }
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
    return TerminologyClientFactory.makeClient(server, "Tools/Java", FhirPublication.R4);  
  }


  public String executeTest(JsonObject suite, JsonObject test, String server) throws URISyntaxException, FHIRFormatError, FileNotFoundException, IOException {
    this.server = server;
    error = null;
    TerminologyClient tx = connectToServer();
    checkClient(tx);
    List<Resource> setup = loadSetupResources(suite);
    if (runTest(test, tx, setup, "*")) {
      return null;      
    } else {
      return error;
    }
  }
  private boolean runSuite(JsonObject suite, TerminologyClient tx, String filter) throws FHIRFormatError, FileNotFoundException, IOException {
    System.out.println("Group "+suite.asString("name"));
    List<Resource> setup = loadSetupResources(suite);
    boolean ok = true;
    for (JsonObject test : suite.getJsonObjects("tests")) {
      ok = runTest(test, tx, setup, filter) && ok;      
    }
    return ok;
  }

  private boolean runTest(JsonObject test, TerminologyClient tx, List<Resource> setup, String filter) {    
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
        return msg == null;
      } catch (Exception e) {
        System.out.println("  ... Exception: "+e.getMessage());
        System.out.print("    ");
        error = e.getMessage();
        e.printStackTrace();
        return false;
      }
    } else {
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
    ValueSet vs = tx.expandValueset(null, p, null);
    String vsj = new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(vs);
    String diff = CompareUtilities.checkJsonSrcIsSame(resp, vsj);
    if (diff != null) {
      Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
      TextFile.stringToFile(vsj, fp);        
    }
    return diff;
  }

  private String validate(TerminologyClient tx, List<Resource> setup, Resource req, String resp, String fp) {
    // TODO Auto-generated method stub
    return "not done yet";
  }

  private List<Resource> loadSetupResources(JsonObject suite) throws FHIRFormatError, FileNotFoundException, IOException {
    List<Resource> res = new ArrayList<>();
    for (String s : suite.getStrings("setup")) {
      res.add(loader.loadResource(s));
    }
    return res;
  }
  
  public static class InternalLoader implements ITxTesterLoader {

    private String folder;
    
    public InternalLoader(String folder) {
      this.folder = folder;
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
