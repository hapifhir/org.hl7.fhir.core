package org.hl7.fhir.convertors.analytics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.convertors.analytics.PackageVisitor.IPackageVisitorProcessor;
import org.hl7.fhir.convertors.analytics.PackageVisitor.PackageContext;
import org.hl7.fhir.convertors.context.ContextResourceLoaderFactory;
import org.hl7.fhir.convertors.loaders.loaderR5.ILoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R2016MayToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R2ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R3ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4BToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R5ToR5Loader;
import org.hl7.fhir.convertors.loaders.loaderR5.R6ToR5Loader;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ValidatedFragment;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.http.ManagedWebAccess.WebAccessPolicy;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.NpmPackage.PackagedResourceFile;
import org.xml.sax.SAXException;

@SuppressWarnings("checkstyle:systemout")
public class TestGenerationDataGenerator implements IPackageVisitorProcessor {

  private static class Counter {
    private int key;
    private int count;
  }
  private Map<String, Set<String>> hashes = new HashMap<String, Set<String>>();
  private Map<String, Counter> elements = new HashMap<String, Counter>();
  private Map<String, Counter> types = new HashMap<String, Counter>();
  private Map<String, IWorkerContext> contexts= new HashMap<>();
  private Connection conn;
  private PreparedStatement psqlE;
  private PreparedStatement psqlT;
  private PreparedStatement psqlV;
  private int keyV = 0;
  private int keyT = 0;
  private int keyE = 0;
  private PreparedStatement psqlEC;
  private PreparedStatement psqlET;
  

  @Override
  public void alreadyVisited(String pid) {
    
  }

  @Override
  public Object startPackage(PackageContext ctxt) {
    System.out.println("Process Package "+ctxt.getPid()+"#"+ctxt.getVersion()+" ("+ctxt.getNpm().fhirVersion()+")");
    return null;
  }

  @Override
  public void processResource(PackageContext ctxt, Object context, String type, String id, byte[] content) throws FHIRException, IOException, EOperationOutcome {
    String version = ctxt.getNpm().fhirVersion();
    IWorkerContext worker = contexts.get(version);
    if (worker == null) {
      FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
      NpmPackage npm = pcm.loadPackage(VersionUtilities.packageForVersion(version));
      IContextResourceLoader loader = ContextResourceLoaderFactory.makeLoader(ctxt.getNpm().fhirVersion(), new NullLoaderKnowledgeProviderR5());
      SimpleWorkerContext swc = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).fromPackage(npm, loader, true);
      contexts.put(version, swc);
      worker = swc;
    }
    List<ValidatedFragment> res = Manager.parse(worker, new ByteArrayInputStream(content), FhirFormat.JSON);
    if (res.size() > 0) {
      try {
        processElement(res.get(0).getElement(), null);
      } catch (SQLException e) {
        throw new FHIRException(e);
      }
    }
  }


  private void processElement(Element element, String path) throws SQLException {
    String id = path != null ? path : element.getProperty().getDefinition().getId();
    switch (element.fhirType()) {
    case "Address":
      recordValue(id, "Address", getValues(element, "use", "type", "text", "line", "city", "district", "state", "postalCode", "country"));
      break;
    case "Age":
      recordValue(id, "Age", getValues(element, "value", "comparator", "unit", "system", "code"));
      break;
    case "Annotation":
      recordValue(id, "Annotation", getValues(element, "author", "time", "text"));
      break;
    case "Attachment":
      recordValue(id, "Attachment", getValues(element, "contentType", "language", "data", "url", "size", "hash", "title"));
      break;
    case "CodeableConcept":
      break;      
    case "CodeableReference":
      break;
    case "Coding":
      recordValue(id, "Coding", getValues(element, "system", "version", "code", "display"));
      break;
    case "ContactPoint":
      recordValue(id, "ContactPoint", getValues(element, "system", "value", "use", "rank"));
      break;
    case "Count":
      recordValue(id, "Count", getValues(element, "value", "comparator", "unit", "system", "code"));
      break;
    case "Distance":
      recordValue(id, "Distance", getValues(element, "value", "comparator", "unit", "system", "code"));
      break;
    case "Duration":
      recordValue(id, "Duration", getValues(element, "value", "comparator", "unit", "system", "code"));
      break;
    case "HumanName":
      recordValue(id, "Address", getValues(element, "use", "text", "family", "given", "prefix", "suffix"));
      break;
    case "Identifier":
      recordValue(id, "Identifier", getValues(element, "use", "type", "system", "value"));
      break;
    case "Money":
      recordValue(id, "Money", getValues(element, "value", "currency"));
      break;
    case "Period":
      recordValue(id, "Period", getValues(element, "start", "end"));
      break;
    case "Quantity":
      recordValue(id, "Quantity", getValues(element, "value", "comparator", "unit", "system", "code"));
      break;
    case "Range":
    case "Ratio":
    case "RatioRange":
    case "Reference":
    case "SampledData":
    case "Signature":
    case "Timing":
    case "RelatedArtifact":
    case "DataRequirement":
    case "Expression":
      break;
    case "xhtml":
    case "id":
    case "canonical":
    case "boolean":
    case "code":
    case "uri":
    case "instant":
      break;
    default:
      if (element.isPrimitive()) {
        if (!element.getProperty().getDefinition().getId().equals("Extension.url")) {
          recordValue(id, element.fhirType(), element.primitiveValue());
        }
      } else {
        for (Element child : element.getChildren()) {
          if (child.fhirType().equals("Extension")) {
            String url = child.getChildValue("url");
            String npath;
            if (Utilities.isAbsoluteUrl(url) || path == null) {
              npath = url;
            } else {
              npath = path+"."+url;
            }
            processElement(child, npath);                
          } else if (!child.getPath().endsWith(".id") && !child.getPath().endsWith(".linkId")) {
            if (!child.isResource() || !Utilities.existsInList(child.fhirType(), "Bundle", "CapabilityStatement", "CodeSystem", "ConceptMap", "GraphDefinition", "ImplementationGuide", "MessageHeader", "NamingSystem", "OperationDefinition", "OperationOutcome", "Parameters", "SearchParameter", "StructureDefinition", "StructureMap", "TerminologyCapabilities", "ValueSet")) {
              processElement(child, path);
            }
          }
        }
      }
    }
  }

  private String[] getValues(Element element, String... names) {
    List<String> values = new ArrayList<>();
    for (String name : names) {
      List<Element> children = element.getChildren(name);
      if (!children.isEmpty()) {
        CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("~");
        for (Element child : children) {
          if (child.hasPrimitiveValue()) {
            b.append(child.primitiveValue());
          }
        }
        if (b.length() > 0) {
         values.add(name+":"+b.toString());
        }
      }
    }
    
    return values.toArray(new String[0]);
  }

  public void start(String filename) throws SQLException, IOException {
    ManagedFileAccess.file(filename).delete();
    conn = DriverManager.getConnection("jdbc:sqlite:"+filename); 
    Statement stmt = conn.createStatement();
    stmt.execute("CREATE TABLE TestElements (ElementKey int NOT NULL, ElementId nvarchar NOT NULL, Count int NULL, PRIMARY KEY (ElementKey))");
    stmt.execute("CREATE INDEX TestElementsElement ON TestElements ( ElementId )");
    
    stmt.execute("CREATE TABLE TestTypes (TypeKey int NOT NULL, TypeName nvarchar NOT NULL, Count int NULL, PRIMARY KEY (TypeKey))");
    stmt.execute("CREATE INDEX TestTypesType ON TestTypes ( TypeName )");
    
    stmt.execute("CREATE TABLE TestValues (ValueKey int NOT NULL, ElementKey int NOT NULL, TypeKey int NOT NULL, ValueData nvarchar NOT NULL, PRIMARY KEY (ValueKey))");
    stmt.execute("CREATE INDEX TestValueElement ON TestValues ( ElementKey, TypeKey)");
    
    psqlE = conn.prepareStatement("Insert into TestElements (ElementKey, ElementId) values (?, ?)");
    psqlT = conn.prepareStatement("Insert into TestTypes (TypeKey, TypeName) values (?, ?)");
    psqlV = conn.prepareStatement("Insert into TestValues (ValueKey, ElementKey, TypeKey, ValueData) values (?, ?, ?, ?)");
    psqlEC = conn.prepareStatement("Update TestElements set Count = ? where ElementKey = ?");
    psqlET = conn.prepareStatement("Update TestTypes set Count = ? where TypeKey = ?");
  }

  private void store(String path, String type, String[] values) throws SQLException {
    Counter cE = elements.get(path);
    if (cE != null) {
      cE.count++;
      psqlEC.setInt(1, cE.count);
      psqlEC.setInt(2, cE.key);
      psqlEC.execute();
    } else {
      keyE++;
      cE = new Counter();
      cE.key = keyE;
      cE.count = 1;
      elements.put(path, cE);
      psqlE.setInt(1, cE.key);
      psqlE.setString(2, path);
      psqlE.execute();
    }
    
    Counter cT = types.get(type);
    if (cT != null) {
      cT.count++;
      psqlET.setInt(1, cT.count);
      psqlET.setInt(2, cT.key);
      psqlET.execute();
    } else {
      keyT++;
      cT = new Counter();
      cT.key = keyT;
      cT.count = 1;
      types.put(type, cT);
      psqlT.setInt(1, cT.key);
      psqlT.setString(2, type);
      psqlT.execute();
    }
    
    psqlV.setInt(1, keyE++); 
    psqlV.setInt(2, cE.key); 
    psqlV.setInt(3, cT.key);
    psqlV.setString(4, CommaSeparatedStringBuilder.join("|:|",values)); 
    psqlV.execute(); 
  }

  private void recordValue(String path, String type, String... values) throws SQLException {
    StringBuilder v = new StringBuilder();
    v.append(type);
    v.append("|");
    for (String s : values) {
      v.append(s);
      v.append("|");
    }
    Set<String> hashset = hashes.get(path);
    if (hashset == null) {
      hashset = new HashSet<String>();
      hashes.put(path, hashset);
    }
    String s= v.toString();
    if (!hashset.contains(s)) {
      hashset.add(s);
      store(path, type, values);
    }
  }

  @Override
  public void finishPackage(PackageContext ctxt) {    
    
  }


  public static void main(String[] args) throws Exception {
    new TestGenerationDataGenerator().execute();
    // new TestGenerationDataGenerator().offAirWExecute();
  }

  private void offAirWExecute() throws FHIRException, IOException, EOperationOutcome, SQLException {
    ManagedWebAccess.setAccessPolicy(WebAccessPolicy.PROHIBITED);
    start("/Users/grahamegrieve/temp/testdata.db");
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    
    System.out.println("Processing");
    for (String pid : pcm.listPackages()) {
      System.out.println(pid);
      NpmPackage npm = pcm.loadPackage(pid);
      try {
        processPackage(npm);
      } catch (Exception e) {
        System.out.println("  "+e.getMessage());
      }
    }    
    System.out.print("Done");
  }
  
  private void processPackage(NpmPackage npm) throws IOException, FHIRException, EOperationOutcome {


    String fv = npm.fhirVersion();
    String v = npm.version();
    PackageContext ctxt = new PackageContext(npm.name()+"#"+v, npm, fv);
    boolean ok = false;
    Object context = null;
    context = startPackage(ctxt);
    ok = true;
    if (ok) {
      int c = 0;
      Set<String> resourceTypes = new HashSet<String>();
      addR5ResourceNames(resourceTypes);
      addR4ResourceNames(resourceTypes);
      addR3ResourceNames(resourceTypes);

      for (String type : resourceTypes) {
        List<String> rt = new ArrayList<String>();
        rt.add(type);
        for (PackagedResourceFile s : npm.listAllResources(rt)) {
          c++;
          processResource(ctxt, context, type, s.getFilename(), FileUtilities.streamToBytes(npm.load(s.getFolder(), s.getFilename())));
        }
      }
    }    
    finishPackage(ctxt); 
  }


  private void execute() throws IOException, ParserConfigurationException, SAXException, FHIRException, EOperationOutcome, SQLException {
    start("/Users/grahamegrieve/temp/testdata.db");
    PackageVisitor pv = new PackageVisitor();
    addR5ResourceNames(pv.getResourceTypes());
    addR4ResourceNames(pv.getResourceTypes());
    addR3ResourceNames(pv.getResourceTypes());

    pv.setOldVersions(false);
    pv.setCorePackages(true);
    pv.setProcessor(this);
    pv.visitPackages();
    System.out.println("Done");

  }

  private void addR5ResourceNames(Set<String> set) {
    set.add("Account");
    set.add("ActivityDefinition");
    set.add("ActorDefinition");
    set.add("AdministrableProductDefinition");
    set.add("AdverseEvent");
    set.add("AllergyIntolerance");
    set.add("Appointment");
    set.add("AppointmentResponse");
    set.add("ArtifactAssessment");
    set.add("AuditEvent");
    set.add("Basic");
//    set.add("Binary");
    set.add("BiologicallyDerivedProduct");
    set.add("BiologicallyDerivedProductDispense");
    set.add("BodyStructure");
//    set.add("Bundle");
//    set.add("CapabilityStatement");
    set.add("CarePlan");
    set.add("CareTeam");
    set.add("ChargeItem");
    set.add("ChargeItemDefinition");
    set.add("Citation");
    set.add("Claim");
    set.add("ClaimResponse");
    set.add("ClinicalImpression");
    set.add("ClinicalUseDefinition");
//    set.add("CodeSystem");
    set.add("Communication");
    set.add("CommunicationRequest");
    set.add("CompartmentDefinition");
    set.add("Composition");
//    set.add("ConceptMap");
    set.add("Condition");
    set.add("ConditionDefinition");
    set.add("Consent");
    set.add("Contract");
    set.add("Coverage");
    set.add("CoverageEligibilityRequest");
    set.add("CoverageEligibilityResponse");
    set.add("DetectedIssue");
    set.add("Device");
    set.add("DeviceAssociation");
    set.add("DeviceDefinition");
    set.add("DeviceDispense");
    set.add("DeviceMetric");
    set.add("DeviceRequest");
    set.add("DeviceUsage");
    set.add("DiagnosticReport");
    set.add("DocumentReference");
    set.add("Encounter");
    set.add("EncounterHistory");
    set.add("Endpoint");
    set.add("EnrollmentRequest");
    set.add("EnrollmentResponse");
    set.add("EpisodeOfCare");
    set.add("EventDefinition");
    set.add("Evidence");
    set.add("EvidenceReport");
    set.add("EvidenceVariable");
    set.add("ExampleScenario");
    set.add("ExplanationOfBenefit");
    set.add("FamilyMemberHistory");
    set.add("Flag");
    set.add("FormularyItem");
    set.add("GenomicStudy");
    set.add("Goal");
//    set.add("GraphDefinition");
    set.add("Group");
    set.add("GuidanceResponse");
    set.add("HealthcareService");
    set.add("ImagingSelection");
    set.add("ImagingStudy");
    set.add("Immunization");
    set.add("ImmunizationEvaluation");
    set.add("ImmunizationRecommendation");
//    set.add("ImplementationGuide");
    set.add("Ingredient");
    set.add("InsurancePlan");
    set.add("InventoryItem");
    set.add("InventoryReport");
    set.add("Invoice");
    set.add("Library");
    set.add("Linkage");
    set.add("List");
    set.add("Location");
    set.add("ManufacturedItemDefinition");
    set.add("Measure");
    set.add("MeasureReport");
    set.add("Medication");
    set.add("MedicationAdministration");
    set.add("MedicationDispense");
    set.add("MedicationKnowledge");
    set.add("MedicationRequest");
    set.add("MedicationStatement");
    set.add("MedicinalProductDefinition");
    set.add("MessageDefinition");
//    set.add("MessageHeader");
    set.add("MolecularSequence");
//    set.add("NamingSystem");
    set.add("NutritionIntake");
    set.add("NutritionOrder");
    set.add("NutritionProduct");
    set.add("Observation");
    set.add("ObservationDefinition");
//    set.add("OperationDefinition");
//    set.add("OperationOutcome");
    set.add("Organization");
    set.add("OrganizationAffiliation");
    set.add("PackagedProductDefinition");
//    set.add("Parameters");
    set.add("Patient");
    set.add("PaymentNotice");
    set.add("PaymentReconciliation");
    set.add("Permission");
    set.add("Person");
    set.add("PlanDefinition");
    set.add("Practitioner");
    set.add("PractitionerRole");
    set.add("Procedure");
    set.add("Provenance");
    set.add("Questionnaire");
    set.add("QuestionnaireResponse");
    set.add("RegulatedAuthorization");
    set.add("RelatedPerson");
    set.add("RequestOrchestration");
    set.add("Requirements");
    set.add("ResearchStudy");
    set.add("ResearchSubject");
    set.add("RiskAssessment");
    set.add("Schedule");
//    set.add("SearchParameter");
    set.add("ServiceRequest");
    set.add("Slot");
    set.add("Specimen");
    set.add("SpecimenDefinition");
//    set.add("StructureDefinition");
//    set.add("StructureMap");
    set.add("Subscription");
    set.add("SubscriptionStatus");
    set.add("SubscriptionTopic");
    set.add("Substance");
    set.add("SubstanceDefinition");
    set.add("SubstanceNucleicAcid");
    set.add("SubstancePolymer");
    set.add("SubstanceProtein");
    set.add("SubstanceReferenceInformation");
    set.add("SubstanceSourceMaterial");
    set.add("SupplyDelivery");
    set.add("SupplyRequest");
    set.add("Task");
//    set.add("TerminologyCapabilities");
    set.add("TestPlan");
    set.add("TestReport");
    set.add("TestScript");
    set.add("Transport");
//    set.add("ValueSet");
    set.add("VerificationResult");
    set.add("VisionPrescription");
  }

  private void addR4ResourceNames(Set<String> set) {
    set.add("Account");
    set.add("ActivityDefinition");
    set.add("AdverseEvent");
    set.add("AllergyIntolerance");
    set.add("Appointment");
    set.add("AppointmentResponse");
    set.add("AuditEvent");
    set.add("Basic");
//    set.add("Binary");
    set.add("BiologicallyDerivedProduct");
    set.add("BodyStructure");
//    set.add("Bundle");
//    set.add("CapabilityStatement");
    set.add("CarePlan");
    set.add("CareTeam");
    set.add("CatalogEntry");
    set.add("ChargeItem");
    set.add("ChargeItemDefinition");
    set.add("Claim");
    set.add("ClaimResponse");
    set.add("ClinicalImpression");
//    set.add("CodeSystem");
    set.add("Communication");
    set.add("CommunicationRequest");
    set.add("CompartmentDefinition");
    set.add("Composition");
//    set.add("ConceptMap");
    set.add("Condition");
    set.add("Consent");
    set.add("Contract");
    set.add("Coverage");
    set.add("CoverageEligibilityRequest");
    set.add("CoverageEligibilityResponse");
    set.add("DetectedIssue");
    set.add("Device");
    set.add("DeviceDefinition");
    set.add("DeviceMetric");
    set.add("DeviceRequest");
    set.add("DeviceUseStatement");
    set.add("DiagnosticReport");
    set.add("DocumentManifest");
    set.add("DocumentReference");
    set.add("EffectEvidenceSynthesis");
    set.add("Encounter");
    set.add("Endpoint");
    set.add("EnrollmentRequest");
    set.add("EnrollmentResponse");
    set.add("EpisodeOfCare");
    set.add("EventDefinition");
    set.add("Evidence");
    set.add("EvidenceVariable");
    set.add("ExampleScenario");
    set.add("ExplanationOfBenefit");
    set.add("FamilyMemberHistory");
    set.add("Flag");
    set.add("Goal");
//    set.add("GraphDefinition");
    set.add("Group");
    set.add("GuidanceResponse");
    set.add("HealthcareService");
    set.add("ImagingStudy");
    set.add("Immunization");
    set.add("ImmunizationEvaluation");
    set.add("ImmunizationRecommendation");
//    set.add("ImplementationGuide");
    set.add("InsurancePlan");
    set.add("Invoice");
    set.add("Library");
    set.add("Linkage");
    set.add("List");
    set.add("Location");
    set.add("Measure");
    set.add("MeasureReport");
    set.add("Media");
    set.add("Medication");
    set.add("MedicationAdministration");
    set.add("MedicationDispense");
    set.add("MedicationKnowledge");
    set.add("MedicationRequest");
    set.add("MedicationStatement");
    set.add("MedicinalProduct");
    set.add("MedicinalProductAuthorization");
    set.add("MedicinalProductContraindication");
    set.add("MedicinalProductIndication");
    set.add("MedicinalProductIngredient");
    set.add("MedicinalProductInteraction");
    set.add("MedicinalProductManufactured");
    set.add("MedicinalProductPackaged");
    set.add("MedicinalProductPharmaceutical");
    set.add("MedicinalProductUndesirableEffect");
    set.add("MessageDefinition");
//    set.add("MessageHeader");
    set.add("MolecularSequence");
//    set.add("NamingSystem");
    set.add("NutritionOrder");
    set.add("Observation");
    set.add("ObservationDefinition");
//    set.add("OperationDefinition");
//    set.add("OperationOutcome");
    set.add("Organization");
    set.add("OrganizationAffiliation");
//    set.add("Parameters");
    set.add("Patient");
    set.add("PaymentNotice");
    set.add("PaymentReconciliation");
    set.add("Person");
    set.add("PlanDefinition");
    set.add("Practitioner");
    set.add("PractitionerRole");
    set.add("Procedure");
    set.add("Provenance");
    set.add("Questionnaire");
    set.add("QuestionnaireResponse");
    set.add("RelatedPerson");
    set.add("RequestGroup");
    set.add("ResearchDefinition");
    set.add("ResearchElementDefinition");
    set.add("ResearchStudy");
    set.add("ResearchSubject");
    set.add("RiskAssessment");
    set.add("RiskEvidenceSynthesis");
    set.add("Schedule");
//    set.add("SearchParameter");
    set.add("ServiceRequest");
    set.add("Slot");
    set.add("Specimen");
    set.add("SpecimenDefinition");
//    set.add("StructureDefinition");
//    set.add("StructureMap");
    set.add("Subscription");
    set.add("Substance");
    set.add("SubstancePolymer");
    set.add("SubstanceProtein");
    set.add("SubstanceReferenceInformation");
    set.add("SubstanceSpecification");
    set.add("SubstanceSourceMaterial");
    set.add("SupplyDelivery");
    set.add("SupplyRequest");
    set.add("Task");
    set.add("TerminologyCapabilities");
    set.add("TestReport");
    set.add("TestScript");
//    set.add("ValueSet");
    set.add("VerificationResult");
    set.add("VisionPrescription");
  }

  private void addR3ResourceNames(Set<String> set) {
    set.add("Account");
    set.add("ActivityDefinition");
    set.add("AllergyIntolerance");
    set.add("AdverseEvent");
    set.add("Appointment");
    set.add("AppointmentResponse");
    set.add("AuditEvent");
    set.add("Basic");
//    set.add("Binary");
    set.add("BodySite");
//    set.add("Bundle");
//    set.add("CapabilityStatement");
    set.add("CarePlan");
    set.add("CareTeam");
    set.add("ChargeItem");
    set.add("Claim");
    set.add("ClaimResponse");
    set.add("ClinicalImpression");
//    set.add("CodeSystem");
    set.add("Communication");
    set.add("CommunicationRequest");
    set.add("CompartmentDefinition");
    set.add("Composition");
//    set.add("ConceptMap");
    set.add("Condition");
    set.add("Consent");
    set.add("Contract");
    set.add("Coverage");
    set.add("DataElement");
    set.add("DetectedIssue");
    set.add("Device");
    set.add("DeviceComponent");
    set.add("DeviceMetric");
    set.add("DeviceRequest");
    set.add("DeviceUseStatement");
    set.add("DiagnosticReport");
    set.add("DocumentManifest");
    set.add("DocumentReference");
    set.add("EligibilityRequest");
    set.add("EligibilityResponse");
    set.add("Encounter");
    set.add("Endpoint");
    set.add("EnrollmentRequest");
    set.add("EnrollmentResponse");
    set.add("EpisodeOfCare");
    set.add("ExpansionProfile");
    set.add("ExplanationOfBenefit");
    set.add("FamilyMemberHistory");
    set.add("Flag");
    set.add("Goal");
//    set.add("GraphDefinition");
    set.add("Group");
    set.add("GuidanceResponse");
    set.add("HealthcareService");
    set.add("ImagingManifest");
    set.add("ImagingStudy");
    set.add("Immunization");
    set.add("ImmunizationRecommendation");
//    set.add("ImplementationGuide");
    set.add("Library");
    set.add("Linkage");
    set.add("List");
    set.add("Location");
    set.add("Measure");
    set.add("MeasureReport");
    set.add("Media");
    set.add("Medication");
    set.add("MedicationAdministration");
    set.add("MedicationDispense");
    set.add("MedicationRequest");
    set.add("MedicationStatement");
    set.add("MessageDefinition");
//    set.add("MessageHeader");
//    set.add("NamingSystem");
    set.add("NutritionOrder");
    set.add("Observation");
//    set.add("OperationDefinition");
//    set.add("OperationOutcome");
    set.add("Organization");
//    set.add("Parameters");
    set.add("Patient");
    set.add("PaymentNotice");
    set.add("PaymentReconciliation");
    set.add("Person");
    set.add("PlanDefinition");
    set.add("Practitioner");
    set.add("PractitionerRole");
    set.add("Procedure");
    set.add("ProcedureRequest");
    set.add("ProcessRequest");
    set.add("ProcessResponse");
    set.add("Provenance");
    set.add("Questionnaire");
    set.add("QuestionnaireResponse");
    set.add("ReferralRequest");
    set.add("RelatedPerson");
    set.add("RequestGroup");
    set.add("ResearchStudy");
    set.add("ResearchSubject");
    set.add("RiskAssessment");
    set.add("Schedule");
//    set.add("SearchParameter");
    set.add("Sequence");
    set.add("ServiceDefinition");
    set.add("Slot");
    set.add("Specimen");
//    set.add("StructureDefinition");
//    set.add("StructureMap");
    set.add("Subscription");
    set.add("Substance");
    set.add("SupplyDelivery");
    set.add("SupplyRequest");
    set.add("Task");
    set.add("TestScript");
    set.add("TestReport");
//    set.add("ValueSet");
    set.add("VisionPrescription");
  }
  
}
