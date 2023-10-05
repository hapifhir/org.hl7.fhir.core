package org.hl7.fhir.r4.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;

import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.Property;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.utils.client.FHIRToolingClient;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

public class CmdLineApp {

  private FHIRToolingClient client;
  private String currentId;
  private Resource currentResource;
  private SimpleWorkerContext context;
  private FHIRPathEngine fpe;

  public static void main(String[] args) throws IOException, Exception {
    new CmdLineApp().execute();
  }

  private void execute() throws IOException {
    System.out.print("Loading...");
    NpmPackage npm = new FilesystemPackageCacheManager(true).loadPackage("hl7.fhir.r4.core");
    context = SimpleWorkerContext.fromPackage(npm);
    fpe = new FHIRPathEngine(context);
    System.out.println(" Done");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    genMenu();
    boolean finished = false;
    do {
      System.out.print("> ");
      String cmd = reader.readLine();
      String[] p = cmd.split("\\s+");
      try {
        if (p.length == 1 && p[0].equals("x")) {
          finished = true;
        } else if (p.length == 1 && p[0].equals("?")) {
          genMenu();
        } else if (p.length == 1 && p[0].equals("?tx")) {
          genMenuTx();
        } else if (p.length >= 1 && p[0].equals("c")) {
          if (p.length == 1) {
            connectToServer("http://hapi.fhir.org/baseR4");
          } else {
            connectToServer(p[1]);
          }
        } else if (p.length >= 1 && p[0].equals("imm")) {
          if (p.length == 1) {
            if (currentResource == null || !(currentResource instanceof Patient)) {
              throw new FHIRException("Current resource must be a patient for this command");
            }
            getImmunizations();
          } else {
            select("Immunization", p[1]);
          }
        } else if (p.length >= 1 && p[0].equals("cnd")) {
          if (p.length == 1) {
            if (currentResource == null || !(currentResource instanceof Patient)) {
              throw new FHIRException("Current resource must be a patient for this command");
            }
            getConditions();
          } else {
            select("Condition", p[1]);
          }
        } else if (p.length >= 1 && p[0].equals("prc")) {
          if (p.length == 1) {
            if (currentResource == null || !(currentResource instanceof Patient)) {
              throw new FHIRException("Current resource must be a patient for this command");
            }
            getProcedures();
          } else {
            select("Procedure", p[1]);
          }
        } else if (p.length >= 1 && p[0].equals("v")) {
          if (p.length == 1) {
            viewResource();
          } else {
            viewResource(p[1]);
          }
        } else if (p.length >= 2 && p[0].equals("s")) {
          search(p);
        } else if (p.length >= 2 && p[0].equals("p")) {
          select("Patient", p[1]);
        } else if (p.length == 3 && p[0].equals("e")) {
          edit(p[1], p[2]);
        } else if (p.length > 3 && p[0].equals("tx")) {
          tx(p);
        } else {
          tx(p);
        }
      } catch (Exception e) {
        System.out.println("Error executing command "+p[0]+": "+e.getMessage());
      }
    } while (!finished);
    
    System.out.println("Finished!"); 
  }

  private boolean tx(String[] p) throws IOException {
    if (p[1].equals("l")) {
      if (p.length == 4) {
        return lookup(p[2], p[3]);
      }
    } else if (p[1].equals("v")) {
      if (p.length == 4) {
        return validate(p[2], p[3], null);
      } else if (p.length == 5) {
        return validate(p[2], p[3], p[4]);
      }
    }
    throw new FHIRException("Not understood");
  }

  private boolean validate(String system, String code, String url) throws IOException {
    Parameters pin = new Parameters();
    if (url != null) {
      pin.addParameter("url", url);
    }
    pin.addParameter("system", system);
    pin.addParameter("code", code);
    Parameters pout = client.operateType(CodeSystem.class, "validate-code", pin);
    showParameters("  ", pout.getParameter());
    return true;
  }

  private void showParameters(String prefix, List<ParametersParameterComponent> list) {
    for (ParametersParameterComponent pp : list) {
      if (pp.hasValue()) {        
        System.out.println("  "+pp.getName()+": "+pp.getValue().toString());
      } else if (pp.hasPart()) {
        showParameters("   ", pp.getPart());
      }
    }
  }

  private boolean lookup(String string, String string2) {
    throw new FHIRException("Not implemented");
  }

  private void getImmunizations() throws IOException {

    Bundle bnd = client.search("Immunization", "?patient="+currentId);
    System.out.println(""+bnd.getTotal()+" Immunizations found. Printing "+bnd.getEntry().size());
    
    for (BundleEntryComponent be : bnd.getEntry()) {
      Resource imm = be.getResource();
      System.out.println(summary(imm));
    } 
  }

  private void getProcedures() throws IOException {

    Bundle bnd = client.search("Procedure", "?patient="+currentId);
    System.out.println(""+bnd.getTotal()+" Procedures found. Printing "+bnd.getEntry().size());
    
    for (BundleEntryComponent be : bnd.getEntry()) {
      Resource imm = be.getResource();
      System.out.println(summary(imm));
    } 
  }
  
  private void getConditions() throws IOException {

    Bundle bnd = client.search("Condition", "?patient="+currentId);
    System.out.println(""+bnd.getTotal()+" Conditions found. Printing "+bnd.getEntry().size());
    
    for (BundleEntryComponent be : bnd.getEntry()) {
      Resource imm = be.getResource();
      System.out.println(summary(imm));
    } 
  }

  private void edit(String path, String value) {
    if (path.contains(".")) {
      List<Base> list = fpe.evaluate(currentResource, fpe.parse(path.substring(0, path.lastIndexOf("."))));
      if (list.size() == 1) {
        path = path.substring(path.lastIndexOf(".")+1);
        Property p = list.get(0).getNamedProperty(path);
        Base b = makeValue(p, value);
        list.get(0).setProperty(path, b);
      } else {
        throw new FHIRException("Unable to set value at "+path+": "+list.size()+" matches");
      }
    } else {
      Property p = currentResource.getNamedProperty(path);
      Base b = makeValue(p, value);
      currentResource.setProperty(path, b);
    }
    currentResource = client.update(currentResource);
  }

  private Base makeValue(Property p, String value) {
    switch (p.getTypeCode()) {
    case "boolean" : return new BooleanType(value);
    case "code" :  return new CodeType(value);
    case "string" : return new StringType(value);
    case "date" : return new DateType(value);
    }
    throw new FHIRException("Unhandled type "+p.getTypeCode());
  }

  private void viewResource(String path) {
    System.out.println("Current Resource, query = "+path);
    List<Base> list = fpe.evaluate(currentResource, fpe.parse(path));
    for (Base b : list) {
      System.out.println(b.toString());
    }
  }

  private void viewResource() throws IOException {
    System.out.println("Current Resource:");
    System.out.println(new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(currentResource));
  }

  private void select(String type, String id) throws IOException {
    if (type.equals("Patient")) {
      currentResource = client.fetchResource(Patient.class, id);
    } else if (type.equals("Immunization")) {
      currentResource = client.fetchResource(Immunization.class, id);
    } else if (type.equals("Condition")) {
      currentResource = client.fetchResource(Condition.class, id);
    } else if (type.equals("Procedure")) {
      currentResource = client.fetchResource(Procedure.class, id);
    } else {
      throw new FHIRException("Unhandled type "+type);
    }
    currentId = type+"/"+id;
    System.out.println("Resource = "+currentId+" "+summary(currentResource));
  }

  private String summary(Resource r) throws IOException {
//    return new XmlParser().composeString(r);
    if (r instanceof Patient) {
      Patient pat = (Patient) r;
      return pat.getIdBase()+" "+pat.getGender()+" "+pat.getBirthDateElement().asStringValue()+" "+name(pat);
    }
    if (r instanceof Immunization) {
      Immunization imm = (Immunization) r;
      return imm.getIdBase()+" "+imm.getOccurrenceDateTimeType().asStringValue()+" "+code(imm.getVaccineCode())+" "+imm.getLotNumber()+" ("+imm.getStatus()+")";
    }
    if (r instanceof Condition) {
      Condition cnd = (Condition) r;
      return cnd.getIdBase()+" "+code(cnd.getClinicalStatus())+" "+code(cnd.getVerificationStatus())+" "+code(cnd.getCode())+" "+cnd.getRecordedDateElement().asStringValue();
    }
    if (r instanceof Procedure) {
      Procedure prc = (Procedure) r;
      return prc.getIdBase()+" "+prc.getStatusElement().asStringValue()+" "+code(prc.getCode())+" "+code(prc.getCode())+" "+dt(prc.getPerformed());
    }
    return "??";
  }

  private String dt(Type type) {
    if (type == null) {
      return "";
    }
    if (type.isPrimitive()) {
      return type.primitiveValue();
    }
    if (type instanceof Period) {
      Period pd = (Period) type;
      return pd.getStartElement().asStringValue()+" -> "+pd.getEndElement().asStringValue();
    }
    return "??";
  }

  private String code(CodeableConcept cc) {
    for (Coding c : cc.getCoding()) {
      if (c.hasSystem()) {
        String d = c.hasDisplay() ? " ("+c.getDisplay()+")" : "";
        if (c.hasCode()) {
          switch (c.getSystem()) {
          case "http://hl7.org/fhir/sid/cvx": return "CVX "+c.getCode()+d;
          case "http://snomed.info/sct": return "SCT "+c.getCode()+d;
          default:
            if (Utilities.startsWithInList(c.getSystem(), "http://terminology.hl7.org")) {
              return c.getCode();
            } else {
              throw new FHIRException("Unknown system "+c.getSystem());
            }
          }
        }
      }
    }
    for (Coding c : cc.getCoding()) {
      if (c.hasCode()) {
        return c.getCode();
      }
    }
    if (cc.hasText()) {
      return cc.getText();
    }
    return "";
  }

  private void search(String[] p) throws IOException {
    if (client == null) {
      throw new FHIRException("Not connected to to a server");
    }
    String search = "?name="+p[1];
    if (p.length > 2) {
      search = search +"&gender="+p[2];
      if (p.length > 3) {
        search = search +"&birthdate="+p[3];
      }
    }
    Bundle bnd = client.search("Patient", search);
    System.out.println(""+bnd.getTotal()+" Patients found. Printing "+bnd.getEntry().size());
    
    for (BundleEntryComponent be : bnd.getEntry()) {
      Patient pat = (Patient) be.getResource();
      System.out.println(summary(pat));
    } 
  }

  private String name(Patient pat) {
    if (pat.getName().size() > 0) {
      return name(pat.getName().get(0));
    }
    return null;
  }

  private String name(HumanName n) {
    if (n.hasText()) {
      return n.getText();
    }
    if (n.hasFamily()) {
      if (n.hasGiven()) {
        return n.getGiven().get(0)+" "+n.getFamily().toUpperCase();
      } else {
        return n.getFamily().toUpperCase();
      }
    }
    return "??";
  }

  private void connectToServer(String url) throws URISyntaxException {
    client = new FHIRToolingClient(url, "FHIR-Command-Line-App");
    CapabilityStatement cs = client.getCapabilitiesStatementQuick();
    System.out.println("Connected to "+url+": "+cs.getSoftware().getName()+", version "+cs.getFhirVersion().toCode());
  }

  private void genMenuTx() {

    System.out.println("Simple Client. Commands you can run:");
    System.out.println(" tx l {system} {code}");
    System.out.println(" tx v {system} {code} {vs-url}");
    System.out.println(" ?tx - print this again");    
    System.out.println(" x - exit");    
  }
  
  private void genMenu() {
    System.out.println("Simple Client. Commands you can run:");
    System.out.println(" c {url} - connect to a server");
    System.out.println(" s {name} [{gender}] {{dob]} - find a patient record");
    System.out.println(" p {id} - choose a patient record");    
    System.out.println(" v [{field}] - see a set of field(s) in the current resource, or the whole resource");
    System.out.println(" e {field} {value} - edit a field in the current resource");
    System.out.println(" imm [{id}] - get a list of the patient's immunizations, or use the resource for the id (then use e to edit it)");
    System.out.println(" cnd [{id}] - get a list of the patient's conditions, or use the resource for the id (then use e to edit it)");
    System.out.println(" prc [{id}] - get a list of the patient's procedures, or use the resource for the id (then use e to edit it)");
    System.out.println(" ? - print this again");    
    System.out.println(" x - exit");    
  }
}
