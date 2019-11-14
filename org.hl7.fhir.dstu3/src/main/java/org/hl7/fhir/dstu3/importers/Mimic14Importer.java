package org.hl7.fhir.dstu3.importers;

/*-
 * #%L
 * org.hl7.fhir.dstu3.importers
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.fhir.ucum.UcumEssenceService;
import org.fhir.ucum.UcumException;
import org.fhir.ucum.UcumService;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.dstu3.context.SimpleWorkerContext;
import org.hl7.fhir.dstu3.formats.IParser.OutputStyle;
import org.hl7.fhir.dstu3.formats.JsonParser;
import org.hl7.fhir.dstu3.model.BaseDateTimeType;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.Bundle.BundleType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DateType;
import org.hl7.fhir.dstu3.model.DocumentReference;
import org.hl7.fhir.dstu3.model.Encounter;
import org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.dstu3.model.ExpansionProfile;
import org.hl7.fhir.dstu3.model.InstantType;
import org.hl7.fhir.dstu3.model.MedicationRequest;
import org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;
import org.hl7.fhir.dstu3.model.Parameters;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Period;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.dstu3.model.PractitionerRole;
import org.hl7.fhir.dstu3.model.Procedure;
import org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.SimpleQuantity;
import org.hl7.fhir.dstu3.model.Quantity.QuantityComparator;
import org.hl7.fhir.dstu3.model.Range;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Type;
import org.hl7.fhir.dstu3.utils.EOperationOutcome;
import org.hl7.fhir.dstu3.utils.NarrativeGenerator;
import org.hl7.fhir.dstu3.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CSVReader;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;

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
  private Map<String, PractitionerRole> careGivers = new HashMap<>();
  private Map<String, Patient> patients = new HashMap<>();
  private Map<String, Encounter> encounters = new HashMap<>();
  private IniFile ini;

  private UcumService ucum;
  private SimpleWorkerContext context;
  
  public static void main(String[] args) throws IOException, UcumException, FHIRException, EOperationOutcome {
    new Mimic14Importer().execute(args[0], args[1], args[2]);
  }

  public Mimic14Importer() {
    super();
    date = new Date();
  }


  private void execute(String src, String dest, String ucumSrc) throws IOException, UcumException, FHIRException, EOperationOutcome {
    System.out.println("Loading Context");
    PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.r3.core", "4.0.2"));
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.us.core", "1.1.0"), null, "StructureDefinition");
    context.setExpansionProfile(new ExpansionProfile());
    System.out.println("Loading UCUM from "+ucumSrc);
  
   ucum = new UcumEssenceService(ucumSrc);
   ini = new IniFile(Utilities.path(src, "translations.ini"));
  
   loadItems(Utilities.path(src, "d_items.csv"));
   loadLabItems(Utilities.path(src, "d_labitems.csv"));
   loadCareGivers(Utilities.path(src, "caregivers.csv"), Utilities.path(dest, "care-givers.json"));
   
   Bundle patients = processPatients(Utilities.path(src, "patients.csv"));
   Bundle encounters = processAdmissions(Utilities.path(src, "admissions.csv"));
   processLabEvents(Utilities.path(src, "labevents.csv"), Utilities.path(dest, "lab-observations.json"));
   processMicroEvents(Utilities.path(src, "microbiologyevents.csv"), Utilities.path(dest, "micro-observations.json"));
   processNoteEvents(Utilities.path(src, "noteevents.csv"), Utilities.path(dest, "notes.json"));
   processDiagnoses(Utilities.path(src, "diagnoses_icd.csv"), Utilities.path(dest, "diagnoses.json"));
   processProcedures(Utilities.path(src, "procedures_icd.csv"), Utilities.path(dest, "procedures.json"));
   processPrescriptions(Utilities.path(src, "prescriptions.csv"), Utilities.path(dest, "prescriptions.json"));
   processProcedureEvents(Utilities.path(src, "procedureevents_mv.csv"), Utilities.path(dest, "procedure-events.json"));
   processOutputEvents(Utilities.path(src, "outputevents.csv"), Utilities.path(dest, "outputs.json"));
   processChartEvents(Utilities.path(src, "chartevents.csv"), Utilities.path(dest, "chartevents.json"));
   
   System.out.println("saving");
   
   NarrativeGenerator gen = new NarrativeGenerator("", "http://hl7.org/fhir", context);
   for (BundleEntryComponent be : patients.getEntry()) {
     Patient p = (Patient) be.getResource();
     gen.generate(p);
   }
   for (BundleEntryComponent be : encounters.getEntry()) {
     Encounter p = (Encounter) be.getResource();
     gen.generate(p);
   }
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
    while (csv.line()) {
      PractitionerRole pr = new PractitionerRole();
      t++;
      pr.setId(csv.cell("cgid"));
      pr.addCode().addCoding().setSystem("http://mimic.physionet.org/fhir/CareGiverType").setCode(csv.cell("label")).setDisplay(csv.cell("description"));
      careGivers.put(pr.getId(), pr);
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
        obs.setContext(new Reference("Encounter/"+enc.getId()));
      }
      obs.setEffective(readDateTime(csv.cell("charttime")));
      if (item != null) {
        if (!Utilities.noString(item.category)) {
          obs.addCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode(item.category);
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
        Quantity qty = parseQuantity(csv.cell("valuenum"), "valueuom"); 
        obs.setValue(qty);
      } else {
        obs.setValue(new CodeableConcept().setText(csv.cell("value")));
      }
      if (csv.has("flag"))
        obs.getInterpretation().setText(csv.cell("flag"));

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
        obs.addCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode("microbiology");
        bnd.addEntry().setResource(obs);
 
        
        // todo: these are all cultures, but the codes state mainly what the culture is on
        obs.getCode().setText(csv.cell("spec_type_desc"));
        if ("70012".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("600-7").setDisplay("Bacteria identified in Blood by Culture");
        } else if ("70079".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("630-4").setDisplay("Bacteria identified in Urine by Culture");
        } else if ("70064".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("625-4").setDisplay("Bacteria identified in Stool by Culture");
        } else if ("70005".equals(csv.cell("spec_itemid"))) {
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("43411-8").setDisplay("Bacteria identified in Aspirate by Culture");
        } else if ("70045".equals(csv.cell("spec_itemid"))) {
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("16718-9").setDisplay("Cytomegalovirus Ag [Presence] in Blood");
        } else if ("70088".equals(csv.cell("spec_itemid"))) {
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("5002-1").setDisplay("Epstein Barr virus DNA [Presence] in Blood by NAA with probe detection");
        } else if ("70087".equals(csv.cell("spec_itemid"))) {
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("16712-2").setDisplay("Cytomegalovirus Ab [Units/volume] in Body fluid");
        } else if ("70093".equals(csv.cell("spec_itemid"))) {
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("49447-6").setDisplay("Toxoplasma gondii DNA [#/volume] in Blood by NAA with probe detection");
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
        } else if ("70069".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6463-4").setDisplay("Bacteria identified in Unspecified specimen by Culture");
        } else if ("70040".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6463-4").setDisplay("Bacteria identified in Unspecified specimen by Culture");
        } else if ("70057".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6463-4").setDisplay("Bacteria identified in Unspecified specimen by Culture");
        } else if ("70027".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("88142-5").setDisplay("Bacteria identified in Cornea or Conjunctiva by Aerobe culture");
        } else if ("70062".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6460-0").setDisplay("Bacteria identified in Sputum by Culture");
        } else if ("70054".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("618-9").setDisplay("Bacteria identified in Pleural fluid by Culture");
        } else if ("70067".equals(csv.cell("spec_itemid"))) { 
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6462-6").setDisplay("Bacteria identified in Wound by Culture");
        } else if ("70028".equals(csv.cell("spec_itemid"))) { 
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("62873-5").setDisplay("PhenX - assay herpes simplex virus types 1 - 2 protocol");
        } else if ("70070".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6462-6").setDisplay("Bacteria identified in Wound by Culture");
        } else if ("70091".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("13317-3").setDisplay("Methicillin resistant Staphylococcus aureus [Presence] in Unspecified specimen by Organism specific culture");
        } else if ("70061".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("620-5").setDisplay("Bacteria identified in Skin by Aerobe culture");
        } else if ("70030".equals(csv.cell("spec_itemid"))) { // check...
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("31982-2").setDisplay("Varicella zoster virus Ag [Presence] in Unspecified specimen");
        } else if ("70013".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("611-4").setDisplay("Bacteria identified in Body fluid by Culture");
        } else if ("70011".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("533-0").setDisplay("Mycobacterium sp identified in Blood by Organism specific culture");
        } else if ("70009".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("53911-4").setDisplay("Bacteria identified in Bile fluid by Culture");
        } else if ("70019".equals(csv.cell("spec_itemid"))) { // check...
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("50659-2").setDisplay("Chromosome analysis.interphase [Interpretation] in Bone marrow by FISH Narrative");
        } else if ("70026".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("606-4").setDisplay("Bacteria identified in Cerebral spinal fluid by Culture");
        } else if ("70081".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("630-4").setDisplay("Bacteria identified in Urine by Culture");
        } else if ("70075".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("626-2").setDisplay("Bacteria identified in Throat by Culture");
        } else if ("70069".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("626-2").setDisplay("Bacteria identified in Throat by Culture");
        } else if ("70021".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("88683-8").setDisplay("Bacteria identified in Bronchoalveolar lavage by Anaerobe culture");
        } else if ("70076".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("43408-4").setDisplay("Bacteria identified in Tissue by Culture");
        } else if ("70037".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("43408-4").setDisplay("Bacteria identified in Tissue by Culture");
        } else if ("70090".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("88683-8").setDisplay("Bacteria identified in Bronchoalveolar lavage by Anaerobe culture");
        } else if ("70047".equals(csv.cell("spec_itemid"))) { // check...
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("621-3").setDisplay("Bacteria identified in Synovial fluid by Culture");
        } else if ("70017".equals(csv.cell("spec_itemid"))) { // check...
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("56874-1").setDisplay("Serology and blood bank studies (set)");
        } else if ("70042".equals(csv.cell("spec_itemid"))) { // check...
          isCulture = false;
          obs.getCode().addCoding().setSystem("http://loinc.org").setCode("6438-6").setDisplay("Influenza virus A+B Ag [Presence] in Unspecified specimen by Immunofluorescence");
        } else
          throw new Error("Not coded yet: "+csv.cell("spec_itemid"));
        // obs.getCode().addCoding().setSystem("http://mimic.physionet.org/fhir/TestType").setCode(csv.cell("spec_itemid"));
      }

      if (pat != null) {
        obs.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        obs.setContext(new Reference("Encounter/"+enc.getId()));
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
        } else if ("90027".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18974-6").setDisplay("rifAMPin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90009".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18903-5").setDisplay("Chloramphenicol [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90003".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18965-4").setDisplay("Penicillin G [Susceptibility]")).setText(csv.cell("ab_name")));
        } else if ("90014".equals(csv.cell("ab_itemid"))) {
          oc.setCode(new CodeableConcept(new Coding().setSystem("http://loinc.org").setCode("18860-7").setDisplay("Amikacin [Susceptibility]")).setText(csv.cell("ab_name")));
        } else
          throw new Error("Not coded yet: "+csv.cell("ab_itemid"));
        if (csv.has("dilution_text")) {
          oc.setValue(parseQuantity(csv.cell("dilution_text")));
        }
        if (csv.has("interpretation")) {
          oc.getInterpretation().addCoding().setSystem("http://mimic.physionet.org/fhir/Interpretation").setCode(csv.cell("interpretation"));
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
        dr.getContext().setEncounter(new Reference("Encounter/"+enc.getId()));
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
        dr.getClass_().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Echo".equals(cat) && "Report".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("59282-4").setDisplay("Stress cardiac echo study report US");
        dr.getClass_().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Radiology".equals(cat) && "CHEST (PORTABLE AP)".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("59282-4").setDisplay("Chest X-ray AP portable single view");
        dr.getClass_().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Nursing/other".equals(cat) && "Report".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("34119-8").setDisplay("Nursing facility Initial assessment note");
        dr.getClass_().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else if ("Physician".equals(cat) && "Physician Surgical Admission Note".equals(desc)) {
        dr.getType().addCoding().setSystem("http://loinc.org").setCode("36589-0").setDisplay("Surgery Admission evaluation note");
        dr.getClass_().addCoding().setSystem("http://fhir.org/guides/argonaut/clinicalnotes/CodeSystem/documentreference-category").setCode("other");
      } else {
        throw new FHIRException("Unhandled Note type '"+cat+"'/'"+desc+"'");
      }
      dr.addContent().getAttachment().setContentType("text/plain; charset=UTF-8").setData(TextFile.stringToBytes(csv.cell("text"), false));
      bnd.addEntry().setResource(dr);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }
  

  private void processDiagnoses(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Diagnoses... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("diagnoses");
    bnd.setType(BundleType.COLLECTION);
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      Condition cnd = new Condition();
      t++;

      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));

      cnd.setId(csv.cell("row_id"));
      cnd.setVerificationStatus(ConditionVerificationStatus.CONFIRMED);
      if (pat != null) {
        cnd.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        cnd.setContext(new Reference("Encounter/"+enc.getId()));
        enc.addDiagnosis().setCondition(new Reference("Condition/"+cnd.getId())).setRank(Integer.parseInt(csv.cell("seq_num")));
      }
      cnd.setCode(new CodeableConcept(new Coding().setCode(csv.cell("icd9_code")).setSystem("http://hl7.org/fhir/sid/icd-9-cm")));

      bnd.addEntry().setResource(cnd);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }

  private void processProcedures(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Procedures... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("procedures");
    bnd.setType(BundleType.COLLECTION);
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      Procedure prc = new Procedure();
      t++;

      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));

      prc.setId(csv.cell("row_id"));
      prc.setStatus(ProcedureStatus.UNKNOWN);
      prc.getCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode("diagnosis");
      if (pat != null) {
        prc.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        prc.setContext(new Reference("Encounter/"+enc.getId()));
        enc.addDiagnosis().setCondition(new Reference("Procedure/"+prc.getId())).setRank(Integer.parseInt(csv.cell("seq_num")));
      }
      prc.setCode(new CodeableConcept(new Coding().setCode(csv.cell("icd9_code")).setSystem("http://hl7.org/fhir/sid/icd-9-cm")));

      bnd.addEntry().setResource(prc);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }

  private void processPrescriptions(String src, String dest) throws FHIRException, FileNotFoundException, IOException {
    System.out.print("Processing Prescriptions... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("prescriptions");
    bnd.setType(BundleType.COLLECTION);
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      MedicationRequest med = new MedicationRequest();
      t++;

      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));

      med.setId(csv.cell("row_id"));
      med.setStatus(MedicationRequestStatus.COMPLETED);
      if (pat != null) {
        med.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        med.setContext(new Reference("Encounter/"+enc.getId()));
      }
      med.getDispenseRequest().getValidityPeriod().setStartElement(readDateTime(csv.cell("startdate")));
      med.getDispenseRequest().getValidityPeriod().setEndElement(readDateTime(csv.cell("enddate")));
      med.getCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode(csv.cell("drug_type"));
      CodeableConcept cc = new CodeableConcept();
      cc.setText(csv.cell("drug"));
      if (csv.has("formulary_drug_cd")) {
        cc.addCoding().setSystem("http://mimic.physionet.org/fhir/drugs").setCode(csv.cell("formulary_drug_cd"));
      }
      med.setMedication(cc);
//      if (csv.has("gsn")) {
//        cc.addCoding().setSystem("http://hl7.org/fhir/sid/GSN?").setCode(csv.cell("gsn"));
//      }
      if (csv.has("ndc")) {
        cc.addCoding().setSystem("http://hl7.org/fhir/sid/ndc").setCode(csv.cell("ndc"));
      }

      //PROD_STRENGTH, DOSE_VAL_RX, DOSE_UNIT_RX - ignore as denomormalizations
      if (csv.has("dose_val_rx")) {
        try {
          med.getDosageInstructionFirstRep().setDose(parseQuantityRange(csv.cell("dose_val_rx"), csv.cell("dose_unit_rx")));
        } catch (Exception e) {
          med.getDosageInstructionFirstRep().setText(csv.cell("dose_val_rx"));
        }
      }
      if (csv.has("route")) {
        med.getDosageInstructionFirstRep().getRoute().addCoding().setSystem("http://mimic.physionet.org/fhir/route").setCode(csv.cell("route"));
      }

      bnd.addEntry().setResource(med);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }

  private void processProcedureEvents(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Procedure Events... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("procedure-events");
    bnd.setType(BundleType.COLLECTION);
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      Procedure prc = new Procedure();
      t++;

      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));

      prc.setId(csv.cell("row_id"));
      prc.setStatus(ProcedureStatus.UNKNOWN);
      prc.getCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode("diagnosis");
      if (pat != null) {
        prc.setSubject(new Reference("Patient/"+pat.getId()));
      }
      if (enc != null) {
        prc.setContext(new Reference("Encounter/"+enc.getId()));
      }
      prc.setPerformed(new Period());
      prc.getPerformedPeriod().setStartElement(readDateTime(csv.cell("starttime")));
      prc.getPerformedPeriod().setEndElement(readDateTime(csv.cell("endtime")));
      Item spec = items.get(csv.cell("itemid"));
      if (spec != null)
        prc.setCode(new CodeableConcept(new Coding().setSystem("http://mimic.physionet.org/fhir/procedures").setCode(csv.cell("itemid")).setDisplay(spec.label)));
      if (csv.has("location"))
        prc.addBodySite().setText(csv.cell("location"));
      bnd.addEntry().setResource(prc);
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }

  private void processOutputEvents(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Output Events... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("output-events");
    bnd.setType(BundleType.COLLECTION);
    csv.readHeaders();
    int t = 0;
    while (csv.line()) {
      t++;
      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));
      Item spec = items.get(csv.cell("itemid"));
      String loinc = ini.getStringProperty("outputs", csv.cell("itemid"));
      if (loinc != null) {
        if (!loinc.equals("n/a")) {
          String value = null;
          if (loinc.contains(";")) {
            String[] p = loinc.split("\\;");
            value=p[1].trim();
            loinc = p[0];
          }
          Observation obs = new Observation();
          obs.setId(csv.cell("row_id"));
          obs.setStatus(ObservationStatus.FINAL);
          obs.addCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode("output");

          if (pat != null) {
            obs.setSubject(new Reference("Patient/"+pat.getId()));
          }
          if (enc != null) {
            obs.setContext(new Reference("Encounter/"+enc.getId()));
          }
          obs.setEffective(readDateTime(csv.cell("charttime")));
          if (spec != null) {
            obs.setCode(new CodeableConcept(loincCoding(loinc)).setText(spec.label));
            obs.getCode().addCoding().setSystem("http://mimic.physionet.org/fhir/outputs").setCode(csv.cell("itemid"));
          }
          if (value != null) {
            obs.setValue(new CodeableConcept().setText(value)); 
          } else {
            Quantity qty = parseQuantity(csv.cell("value"), "valueuom"); 
            obs.setValue(qty);
          }
          obs.setIssuedElement(readInstant(csv.cell("storetime")));

          PractitionerRole prr = careGivers.get(csv.cell("cgid"));
          if (prr != null)
            obs.addPerformer().setReference("PractitionerRole/"+prr.getId());

          bnd.addEntry().setResource(obs);
        }
      } else {
        throw new Error("No LOINC code for output event "+csv.cell("itemid")+" ("+(spec == null ? "n/a" : spec.label)+"="+csv.cell("value")+")");
      }
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(dest), bnd);    
  }

  private void processChartEvents(String src, String dest) throws FileNotFoundException, IOException {
    System.out.print("Processing Chart Events... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("chart-events");
    bnd.setType(BundleType.COLLECTION);
    csv.readHeaders();
    int t = 0;
    int fc = 1;
    while (csv.line()) {
      t++;
      Patient pat = patients.get(csv.cell("subject_id"));
      Encounter enc = encounters.get(csv.cell("hadm_id"));
      Item spec = items.get(csv.cell("itemid"));
      if (spec != null) {
        Observation obs = new Observation();
        obs.setId(csv.cell("row_id"));
        obs.setStatus(ObservationStatus.FINAL);
        obs.addCategory().addCoding().setSystem("http://mimic.physionet.org/fhir/categories").setCode("chart");

        if (pat != null) {
          obs.setSubject(new Reference("Patient/"+pat.getId()));
        }
        if (enc != null) {
          obs.setContext(new Reference("Encounter/"+enc.getId()));
        }
        obs.setEffective(readDateTime(csv.cell("charttime")));

        obs.getCode().setText(spec.label).addCoding().setSystem("http://mimic.physionet.org/fhir/outputs").setCode(csv.cell("itemid"));
        String loinc = ini.getStringProperty("chartevents", csv.cell("itemid"));
        String value = null;
        if (!Utilities.noString(loinc)) {
          if (loinc.contains(";")) {
            String[] p = loinc.split("\\;");
            value=p[1].trim();
            loinc = p[0];
          }
          obs.getCode().addCoding(loincCoding(loinc));
        }
        if (value != null) {
          obs.setValue(new CodeableConcept().setText(value));         
        } else if (csv.has("valuenum")) {
          Quantity qty = parseQuantity(csv.cell("valuenum"), "valueuom"); 
          obs.setValue(qty);
        } else {
          obs.setValue(new CodeableConcept().setText(csv.cell("value")));
        }
        obs.setIssuedElement(readInstant(csv.cell("storetime")));

        PractitionerRole prr = careGivers.get(csv.cell("cgid"));
        if (prr != null)
          obs.addPerformer().setReference("PractitionerRole/"+prr.getId());

        bnd.addEntry().setResource(obs);
        if (bnd.getEntry().size() > 100000) {
          new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.changeFileExt(dest, ""+Integer.toString(fc)+".json")), bnd);
          fc++;
          bnd = new Bundle();
          bnd.setId("chart-events");
          bnd.setType(BundleType.COLLECTION);
        }
      }
    }
    System.out.println(Integer.toString(t)+" found");
    csv.close();
    new JsonParser().setOutputStyle(OutputStyle.PRETTY).compose(new FileOutputStream(Utilities.changeFileExt(dest, ""+Integer.toString(fc)+".json")), bnd);    
  }

  private Coding loincCoding(String loinc) {
    Coding c = new Coding();
    String[] p = loinc.split("\\#");
    c.setSystem(p[0]);
    p = p[1].split("\\:");
    c.setCode(p[0]);
    c.setDisplay(p[1].trim());
    return c;
  }

  private Type parseQuantityRange(String cell, String uom) {
    if (!Utilities.noString(cell) && cell.contains("-")) {
      String[] p = cell.split("\\-");
      Range rng = new Range();
      rng.setLow(parseQuantity(p[0], uom));
      rng.setHigh(parseQuantity(p[1], uom));
      return rng;
    } else
      return parseQuantity(cell, uom);
  }
  private SimpleQuantity parseQuantity(String cell, String uom) {
    if (Utilities.noString(cell))
      return null;
    SimpleQuantity qty = new SimpleQuantity();
    qty.setValue(new BigDecimal(cell));
    parseQuantity(cell);
    if (!Utilities.noString(uom)) {
      qty.setUnit(uom);
      if (ucum.validate(uom) == null) {
        qty.setCode(uom);
        qty.setSystem("http://unitsofmeasure.org");
      }
    }
    return qty;
  }
  
  private Quantity parseQuantity(String cell) {
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
      throw new FHIRException("Not a valid decimal: "+cell);
    }
      
    return new Quantity().setValue(new BigDecimal(cell));
  }

  private Bundle processAdmissions(String src) throws FileNotFoundException, IOException {
    System.out.print("Processing Admissions... ");
    CSVReader csv = new CSVReader(new FileInputStream(src));
    Bundle bnd = new Bundle();
    bnd.setId("encounters");
    bnd.setType(BundleType.COLLECTION);
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
        pat.getCommunication().clear();
        pat.addCommunication().getLanguage().setText(csv.cell("language"));
      }
      if (csv.has("religion")) {
        ToolingExtensions.removeExtension(pat, "http://hl7.org/fhir/StructureDefinition/patient-religion");
        pat.addExtension().setUrl("http://hl7.org/fhir/StructureDefinition/patient-religion").setValue(new CodeableConcept().setText(csv.cell("religion")));
      }
      if (csv.has("marital_status")) {
        pat.getMaritalStatus().getCoding().clear();
        pat.getMaritalStatus().addCoding().setSystem("http://mimic.physionet.org/fhir/MaritalStatus").setCode(csv.cell("marital_status"));
      }
      if (csv.has("ethnicity")) {
        ToolingExtensions.removeExtension(pat, "http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity");
        pat.addExtension().setUrl("http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity").setValue(new CodeableConcept().setText(csv.cell("ethnicity")));
      }
      if (!csv.has("diagnosis")) {
        enc.getReason().clear();
        enc.addReason().setText(csv.cell("diagnosis"));
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
    if (Utilities.noString(cell))
      return null;
    String src = cell.substring(0, 10);
    return new DateType(src);
  }

  private DateTimeType readDateTime(String cell) {
    if (Utilities.noString(cell))
      return null;
    String src = cell.replace(" ", "T");
    if (src.endsWith("00:00:00"))
      src = cell.substring(0, 10);
    return new DateTimeType(src);
  }

  private InstantType readInstant(String cell) {
    if (Utilities.noString(cell))
      return null;
    String src = cell.replace(" ", "T");
    return new InstantType(src);
  }

}
