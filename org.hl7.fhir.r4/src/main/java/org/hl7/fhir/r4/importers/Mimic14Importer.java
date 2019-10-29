package org.hl7.fhir.r4.importers;

/*-
 * #%L
 * org.hl7.fhir.r4.importers
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * Development Notes: 
 * - ignore ICUStays and Transfers for now - low yield, based on discussons with Tom/Alistair
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
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
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Quantity.QuantityComparator;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Type;
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
  
  public static class Item {
    private int rowId;
    private int itemId;
    private String label;
    private String abbreviation;
    private String dbSource;
    private String linksTo; // where it's used...
    private String category; 
    private String unitName;  // uom for item, if it has one
    private String paramType; // type of item
    private int conceptId;
  }

  private static final String MRN_SYSTEM = null;
  private Date date;
  private Map<String, LabItem> labItems = new HashMap<>();
  private Map<String, Item> items = new HashMap<>();
//  private Map<String, PractitionerRole> careGivers = new HashMap<>();
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
  
   loadItems(Utilities.path(src, "d_items.csv"));
   loadLabItems(Utilities.path(src, "d_labitems.csv"));
   loadCareGivers(Utilities.path(src, "caregivers.csv"), Utilities.path(dest, "care-givers.json"));
   
   Bundle patients = processPatients(Utilities.path(src, "patients.csv"));
   Bundle encounters = processAdmissions(Utilities.path(src, "admissions.csv"));
   processLabEvents(Utilities.path(src, "labevents.csv"), Utilities.path(dest, "lab-observations.json"));
   processMicroEvents(Utilities.path(src, "microbiologyevents.csv"), Utilities.path(dest, "micro-observations.json"));
   processNoteEvents(Utilities.path(src, "noteevents.csv"), Utilities.path(dest, "notes.json"));
   
   System.out.println("saving");
   
   new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "patients.json")), patients);    
   new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.path(dest, "encounters.json")), encounters);
   
   System.out.println("done");
  }

  private void loadItems(String src) throws NumberFormatException, FHIRException, IOException {
    System.out.print("Processing Items... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    int t = 0;
    csv.readHeaders();    
    while (csv.line()) {
      Item item = new Item();
      t++;
      item.rowId = Integer.parseInt(csv.cell("row_id"));
      item.itemId = Integer.parseInt(csv.cell("itemid"));
      item.label = csv.cell("label");
      item.abbreviation = csv.cell("abbreviation");
      item.dbSource = csv.cell("dbsource");
      item.linksTo = csv.cell("linksto");
      item.category = csv.cell("category");
      item.unitName = csv.cell("unitname");
      item.paramType = csv.cell("param_type");
      if (csv.has("conceptid")) {
        item.conceptId = Integer.parseInt(csv.cell("conceptid"));
      }
      items.put(csv.cell("itemid"), item);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
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
    csv.close();
  }

  private void loadCareGivers(String src, String dest) throws NumberFormatException, FHIRException, IOException {
    System.out.print("Processing Care Givers... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    int t = 0;
    csv.readHeaders();    
    Bundle bnd = new Bundle();
    bnd.setId("care-givers");
    bnd.setType(BundleType.COLLECTION);
    bnd.setTimestamp(date);    
    while (csv.line()) {
      PractitionerRole pr = new PractitionerRole();
      t++;
      pr.setId(csv.cell("cgid"));
      pr.addCode().addCoding().setSystem("http://mimic.physionet.org/fhir/CareGiverType").setCode(csv.cell("label")).setDisplay(csv.cell("description"));
      bnd.addEntry().setResource(pr);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
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
      obs.setId(csv.cell("row_id"));
      obs.setStatus(ObservationStatus.FINAL);
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
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }
  
  /**
   * loinc COE 600-7  DATE TIME + CODE FOR OBSERVED - UPCODE TO snomed?
   * 
   * Sensitivity = observation panel code of 
   *   code = 
   * @param src
   * @param dest
   * @throws FileNotFoundException
   * @throws IOException
   */
  private void processMicroEvents(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Micro Events... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("lab-observations");
    bnd.setType(BundleType.COLLECTION);
    bnd.setTimestamp(date);    
    csv.readHeaders();
    Map<String, Observation> cache = new HashMap<>();
    
    int t = 0;
    while (csv.line()) {
      String cacheId = csv.cell("hadm_id")+"|"+csv.cell("spec_itemid")+"|"+csv.cell("org_itemid")+"|"+(csv.has("charttime") ? csv.cell("charttime") : csv.cell("chartdate"))+"|"+csv.cell("isolate_num");

      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));
      Item spec = items.get(csv.cell("spec_itemid"));
      Item org = items.get(csv.cell("org_itemid"));
      Item ab = items.get(csv.cell("ab_itemid"));

      Observation obs;
      boolean isCulture = true;
      if (cache.containsKey(cacheId)) {
        obs = cache.get(cacheId);
      } else {
        obs = new Observation();
        t++;
        cache.put(cacheId, obs);
        obs.setId(csv.cell("row_id"));
        obs.setStatus(ObservationStatus.FINAL);
        obs.addCategory().setText("microbiology");
        bnd.addEntry().setResource(obs);
 
        
        // todo: these are all cultures, but the codes state mainly what the culture is on
        obs.getCode().setText(csv.cell("spec_type_desc"));
        if ("70012".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("600-7").setDisplay("Bacteria identified in Blood by Culture");
        } else if ("70079".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("630-4").setDisplay("Bacteria identified in Urine by Culture");
        } else if ("70064".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("625-4").setDisplay("Bacteria identified in Stool by Culture");
        } else if ("70053".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("619-7").setDisplay("Bacteria identified in Peritoneal fluid by Culture");
//        } else if ("70013".equals(csv.cell("spec_itemid"))) {
//          obs.getCode().addCoding().setSystem("http://loinc.org").setCode().setDisplay();
        } else if ("70023".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("19128-8").setDisplay("Bacteria identified in Catheter tip by Culture");
        } else if ("70046".equals(csv.cell("spec_itemid"))) { 
          isCulture = false;
          obs.getCode().setText("HIV-1 Viral Load/Ultrasensitive");
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("20447-9").setDisplay("HIV 1 RNA [#/volume] (viral load) in Serum or Plasma by NAA with probe detection");
        } else if ("70051".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6463-4").setDisplay("Bacteria identified in Unspecified specimen by Culture");
        } else if ("70062".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6460-0").setDisplay("Bacteria identified in Sputum by Culture");
        } else if ("70067".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6462-6").setDisplay("Bacteria identified in Wound by Culture");
        } else if ("70070".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6462-6").setDisplay("Bacteria identified in Wound by Culture");
        } else if ("70091".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("13317-3").setDisplay("Methicillin resistant Staphylococcus aureus [Presence] in Unspecified specimen by Organism specific culture");
        } else
          throw new Error("Not coded yet: "+csv.cell("spec_itemid"));
        obs.getCode().addCoding().setSystem("http://mimic.physionet.org/fhir/TestType").setCode(csv.cell("spec_itemid"));
      }

      if (pat != null) {
        obs.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        obs.setEncounter(new Reference("Encounter/"+enc.getId()));
      }
      
      if (csv.has("charttime")) {
        obs.setEffective(readDateTime(csv.cell("charttime")));
      } else {
        obs.setEffective(readDateTime(csv.cell("chartdate")));
      }
      if (org == null) {
        obs.setValue(new CodeableConcept(new Coding().setSystem("http://mimic.physionet.org/fhir/TestValue").setCode("negative")));
      } else {
        obs.setValue(new CodeableConcept(new Coding().setSystem("http://mimic.physionet.org/fhir/Organism").setCode(csv.cell("org_itemid"))).setText(csv.cell("org_name")));
      }
      // todo: make this members not components
      if (isCulture && ab != null) {
        ObservationComponentComponent oc = obs.addComponent();
        if ("90015".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("19000-9").setDisplay("Vancomycin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90012".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18928-2").setDisplay("Gentamicin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90025".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("20629-2").setDisplay("levoFLOXacin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90016".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18961-3").setDisplay("Oxacillin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90011".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18993-6").setDisplay("Tetracycline [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90006".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18919-1").setDisplay("Erythromycin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90002".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18964-7").setDisplay("Penicillin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90004".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18864-9").setDisplay("Ampicillin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90005".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18878-9").setDisplay("ceFAZolin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90007".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18908-4").setDisplay("Clindamycin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90008".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18997-7").setDisplay("Trimethoprim [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90010".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18955-5").setDisplay("Nitrofurantoin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90020".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18932-4").setDisplay("Imipenem [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90021".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18969-6").setDisplay("Piperacillin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90013".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18996-9").setDisplay("Tobramycin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90017".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18893-8").setDisplay("cefTAZidime [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90018".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18895-3").setDisplay("cefTRIAXone [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90019".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18906-8").setDisplay("Ciprofloxacin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90022".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18865-6").setDisplay("Ampicillin+Sulbactam [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90023".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("51724-3").setDisplay("Cefuroxime [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90026".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18969-6").setDisplay("Piperacillin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90028".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18879-7").setDisplay("Cefepime [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90029".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18943-1").setDisplay("Meropenem [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90031".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("29258-1").setDisplay("Linezolid [Susceptibility]")).setText(csv.cell("ab_name")));
        } else
          throw new Error("Not coded yet: "+csv.cell("ab_itemid"));
        if (csv.has("dilution_text")) {
          oc.setValue(parseQuantity(csv.cell("dilution_text")));
        }
        if (csv.has("interpretation")) {
          oc.addInterpretation().addCoding().setSystem("http://mimic.physionet.org/fhir/Interpretation").setCode(csv.cell("interpretation"));
        }
      }
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }

  private void processNoteEvents(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Note Events... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("notes");
    bnd.setType(BundleType.COLLECTION);
    bnd.setTimestamp(date);    
    csv.readHeaders();
    Map<String, Observation> cache = new HashMap<>();
    
    int t = 0;
    while (csv.line()) {

      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));

      DocumentReference dr = new DocumentReference();
      dr.setId(csv.cell("row_id"));
      if (pat != null) {
        dr.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        dr.getContext().addEncounter(new Reference("Encounter/"+enc.getId()));
      }
      if ("1".equals(csv.cell("iserror"))) {
        dr.setStatus(DocumentReferenceStatus.ENTEREDINERROR);        
      } else {
        dr.setStatus(DocumentReferenceStatus.CURRENT);
      }
      if (csv.has("cgid")) {
        dr.addAuthor().setReference("PractitionerRole/"+csv.cell("cgid"));
      }
      String cat = csv.cell("category");
      String desc = csv.cell("description");
      if ("Discharge summary".equals(cat) && "Report".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("18842-5").setDisplay("Discharge summary");
        dr.addCategory().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Echo".equals(cat) && "Report".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("59282-4").setDisplay("Stress cardiac echo study report US");
        dr.addCategory().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Radiology".equals(cat) && "CHEST (PORTABLE AP)".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("59282-4").setDisplay("Chest X-ray AP portable single view");
        dr.addCategory().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Nursing/other".equals(cat) && "Report".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("34119-8").setDisplay("Nursing facility Initial assessment note");
        dr.addCategory().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Physician".equals(cat) && "Physician Surgical Admission Note".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("36589-0").setDisplay("Surgery Admission evaluation note");
        dr.addCategory().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else {
        throw new FHIRException("Unhandled Note type '"+cat+"'/'"+desc+"'");
      }
      dr.addContent().getAttachment().setContentType("text/plain; charset=UTF-8").setData(csv.cell("text").getBytes(Charset.forName("UTF-8")));
      bnd.addEntry().setResource(dr);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }
  

  private Type parseQuantity(String cell) {
    if (cell.startsWith("<=")) {
      return new Quantity().setComparator(QuantityComparator.LESS_OR_EQUAL).setValue(new BigDecimal(cell.substring(2)));
    }
    if (cell.startsWith("<")) {
      return new Quantity().setComparator(QuantityComparator.LESS_THAN).setValue(new BigDecimal(cell.substring(2)));
    }
    if (cell.startsWith(">=") || cell.startsWith("=>") ) {
      return new Quantity().setComparator(QuantityComparator.GREATER_OR_EQUAL).setValue(new BigDecimal(cell.substring(2)));
    }
    if (cell.startsWith(">")) {
      return new Quantity().setComparator(QuantityComparator.GREATER_THAN).setValue(new BigDecimal(cell.substring(2)));
    }
    if (!Utilities.isDecimal(cell, true)) {
      throw new Error("Not a valid decimal: "+cell);
    }
      
    return new Quantity().setValue(new BigDecimal(cell));
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
    csv.close();
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
    csv.close();
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
