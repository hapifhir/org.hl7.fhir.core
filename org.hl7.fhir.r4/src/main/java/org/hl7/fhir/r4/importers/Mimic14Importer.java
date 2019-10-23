package org.hl7.fhir.r4.importers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.fhir.ucum.UcumEssenceService;
import org.fhir.ucum.UcumException;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.Utilities;

public class Mimic14Importer {

  public static class LabItem {
    private int rowId;
    private int itemId;
    private String label;
    private String fluid;
    private String category;
    private String loinc;
  }
  
  private static final String MRN_SYSTEM = null;
  private Date date;
  private Map<String, LabItem> labItems = new HashMap<>();
  private Map<String, Patient> patients = new HashMap<>();
  private Map<String, Encounter> encounters = new HashMap<>();

  private UcumService ucum;
  
  public static void main(String[] args) throws IOException, UcumException {
    new Mimic14Importer().execute(args[0], args[1], args[2]);
  }

  public Mimic14Importer() {
    super();
    date = new Date();
  }


  private void execute(String src, String dest, String ucumSrc) throws IOException, UcumException {
    System.out.println("Loading UCUM from "+ucumSrc);
  
   ucum = new UcumEssenceService(ucumSrc);
  
   loadLabItems(Utilities.path(src, "d_labitems.csv"));
   Bundle patients = processPatients(Utilities.path(src, "patients.csv"));
   Bundle encounters = processAdmissions(Utilities.path(src, "admissions.csv"));
   processLabEvents(Utilities.path(src, "labevents.csv"), Utilities.path(dest, "lab-observations.json"));

   
   System.out.println("saving");
   
   new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "patients.json")), patients);    
   new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "encounters.json")), encounters);
   
   System.out.println("done");
  }

  private void loadLabItems(String src) throws NumberFormatException, FHIRException, IOException {
    System.out.print("Processing Lab Items... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    int t = 0;
    csv.readHeaders();    
    while (csv.line()) {
      LabItem item = new LabItem();
      t++;
      item.rowId = Integer.parseInt(csv.cell("row_id"));
      item.itemId = Integer.parseInt(csv.cell("itemid"));
      item.label = csv.cell("label");
      item.fluid = csv.cell("fluid");
      item.category = csv.cell("category");
      item.loinc = csv.cell("loinc_code");
      labItems.put(csv.cell("itemid"), item);
    }
    System.out.println(Integer.toString(t)+" found");
  }

  private void processLabEvents(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Lab Events... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("lab-observations");
    bnd.setType(BundleType.COLLECTION);
    bnd.setTimestamp(date);    
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      Observation obs = new Observation();
      t++;
      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));
      LabItem item = labItems.get(csv.cell("itemid"));
      obs.setId(csv.cell("hadm_id"));
      if (pat != null) {
        obs.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        obs.setEncounter(new Reference("Encounter/"+enc.getId()));
      }
      obs.setEffective(readDateTime(csv.cell("charttime")));
      if (item != null) {
        if (!Utilities.noString(item.category)) {
          obs.addCategory().setText(item.category);
        }
        obs.getCode().setText(item.label);
        if (!Utilities.noString(item.fluid)) {
          obs.getSpecimen().setDisplay(item.fluid);
        }
        if (!Utilities.noString(item.loinc)) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode(item.loinc);
        }
      }

      if (csv.has("valuenum")) {
        Quantity qty = new Quantity();
        qty.setValue(new BigDecimal(csv.cell("valuenum")));
        String uom = csv.cell("valueuom");
        qty.setUnit(uom);
        if (ucum.validate(uom) == null) {
          qty.setCode(uom);
          qty.setSystem("http://unitsofmeasure.org");
        }
        obs.setValue(qty);
      } else {
        obs.setValue(new CodeableConcept().setText(csv.cell("value")));
      }
      if (csv.has("flag"))
        obs.addInterpretation().setText(csv.cell("flag"));

      bnd.addEntry().setResource(obs);
    }
    System.out.println(Integer.toString(t)+" found");
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }
  
  private Bundle processAdmissions(String src) throws FileNotFoundException, IOException {
    System.out.print("Processing Admissions... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("encounters");
    bnd.setType(BundleType.COLLECTION);
    bnd.setTimestamp(date);    
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      Encounter enc = new Encounter();
      t++;
      Patient pat = patients.get(csv.cell("subject_id"));
      encounters.put(csv.cell("hadm_id"), enc);
      enc.setId(csv.cell("hadm_id"));
      enc.setSubject(new Reference("Patient/"+pat.getId()));
      enc.getPeriod().setStartElement(readDateTime(csv.cell("admittime")));
      enc.getPeriod().setEndElement(readDateTime(csv.cell("dischtime")));
      enc.addType().addCoding().setSystem("http://mimic.physionet.org/fhir/AdmissionType").setCode(csv.cell("admission_type"));
      if (!Utilities.noString(csv.cell("admission_location"))) {
        enc.getHospitalization().getAdmitSource().addCoding().setSystem("http://mimic.physionet.org/fhir/AdmitSource").setCode(csv.cell("admission_location"));
      }
      if (csv.has("discharge_location")) {
        enc.getHospitalization().getDischargeDisposition().addCoding().setSystem("http://mimic.physionet.org/fhir/DischargeLocation").setCode(csv.cell("discharge_location"));
      }
      // ignore insurance
      if (csv.has("language")) {
        pat.addCommunication().getLanguage().setText(csv.cell("language"));
      }
      if (csv.has("religion")) {
        pat.addExtension().setUrl("http://hl7.org/fhir/StructureDefinition/patient-religion").setValue(new CodeableConcept().setText(csv.cell("religion")));
      }
      if (csv.has("marital_status")) {
        pat.getMaritalStatus().addCoding().setSystem("http://mimic.physionet.org/fhir/MaritalStatus").setCode(csv.cell("marital_status"));
      }
      if (csv.has("ethnicity")) {
        pat.addExtension().setUrl("http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity").setValue(new CodeableConcept().setText(csv.cell("ethnicity")));
      }
      if (!csv.has("diagnosis")) {
        enc.addReasonCode().setText(csv.cell("diagnosis"));
      }
      if ("1".equals(csv.cell("hospital_expire_flag"))) {
        enc.getHospitalization().getDischargeDisposition().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/discharge-disposition").setCode("exp");
      }
      bnd.addEntry().setResource(enc);
    }
    System.out.println(Integer.toString(t)+" found");
    return bnd;
  }
  
  private Bundle processPatients(String src) throws FileNotFoundException, IOException {
    System.out.print("Processing Patients... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("patients");
    bnd.setType(BundleType.COLLECTION);
    bnd.setTimestamp(date);    
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      Patient pat = new Patient();
      t++;
      patients.put(csv.cell("subject_id"), pat);
      pat.setId(csv.cell("row_id"));
      pat.addIdentifier().setSystem(MRN_SYSTEM).setValue(csv.cell("subject_id"));
      if ("F".equals(csv.cell("gender")))
        pat.setGender(AdministrativeGender.FEMALE);
      else if ("M".equals(csv.cell("gender")))
        pat.setGender(AdministrativeGender.MALE);
      else
       throw new Error("unknown gender: "+csv.cell("gender"));
      pat.setBirthDateElement(readDate(csv.cell("dob")));
      pat.setDeceased(readDateTime(csv.cell("dod")));
      bnd.addEntry().setResource(pat);
    }
    System.out.println(Integer.toString(t)+" found");
    return bnd;
  }


  private DateType readDate(String cell) {
    String src = cell.substring(0, 10);
    return new DateType(src);
  }

  private DateTimeType readDateTime(String cell) {
    String src = cell.replace(" ", "T");
    if (src.endsWith("00:00:00"))
      src = cell.substring(0, 10);
    return new DateTimeType(src);
  }

}
