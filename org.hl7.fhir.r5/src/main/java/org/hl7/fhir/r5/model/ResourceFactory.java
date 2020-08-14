package org.hl7.fhir.r5.model;



/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent


  
import org.hl7.fhir.exceptions.FHIRException;

public class ResourceFactory extends Factory {

    public static Resource createResource(String name) throws FHIRException {
        if ("Account".equals(name))
            return new Account();
        if ("ActivityDefinition".equals(name))
            return new ActivityDefinition();
        if ("AdministrableProductDefinition".equals(name))
            return new AdministrableProductDefinition();
        if ("AdverseEvent".equals(name))
            return new AdverseEvent();
        if ("AllergyIntolerance".equals(name))
            return new AllergyIntolerance();
        if ("Appointment".equals(name))
            return new Appointment();
        if ("AppointmentResponse".equals(name))
            return new AppointmentResponse();
        if ("AuditEvent".equals(name))
            return new AuditEvent();
        if ("Basic".equals(name))
            return new Basic();
        if ("Binary".equals(name))
            return new Binary();
        if ("BiologicallyDerivedProduct".equals(name))
            return new BiologicallyDerivedProduct();
        if ("BodyStructure".equals(name))
            return new BodyStructure();
        if ("Bundle".equals(name))
            return new Bundle();
        if ("CapabilityStatement".equals(name))
            return new CapabilityStatement();
        if ("CapabilityStatement2".equals(name))
            return new CapabilityStatement2();
        if ("CarePlan".equals(name))
            return new CarePlan();
        if ("CareTeam".equals(name))
            return new CareTeam();
        if ("CatalogEntry".equals(name))
            return new CatalogEntry();
        if ("ChargeItem".equals(name))
            return new ChargeItem();
        if ("ChargeItemDefinition".equals(name))
            return new ChargeItemDefinition();
        if ("Citation".equals(name))
            return new Citation();
        if ("Claim".equals(name))
            return new Claim();
        if ("ClaimResponse".equals(name))
            return new ClaimResponse();
        if ("ClinicalImpression".equals(name))
            return new ClinicalImpression();
        if ("ClinicalUseIssue".equals(name))
            return new ClinicalUseIssue();
        if ("CodeSystem".equals(name))
            return new CodeSystem();
        if ("Communication".equals(name))
            return new Communication();
        if ("CommunicationRequest".equals(name))
            return new CommunicationRequest();
        if ("CompartmentDefinition".equals(name))
            return new CompartmentDefinition();
        if ("Composition".equals(name))
            return new Composition();
        if ("ConceptMap".equals(name))
            return new ConceptMap();
        if ("Condition".equals(name))
            return new Condition();
        if ("ConditionDefinition".equals(name))
            return new ConditionDefinition();
        if ("Consent".equals(name))
            return new Consent();
        if ("Contract".equals(name))
            return new Contract();
        if ("Coverage".equals(name))
            return new Coverage();
        if ("CoverageEligibilityRequest".equals(name))
            return new CoverageEligibilityRequest();
        if ("CoverageEligibilityResponse".equals(name))
            return new CoverageEligibilityResponse();
        if ("DetectedIssue".equals(name))
            return new DetectedIssue();
        if ("Device".equals(name))
            return new Device();
        if ("DeviceDefinition".equals(name))
            return new DeviceDefinition();
        if ("DeviceMetric".equals(name))
            return new DeviceMetric();
        if ("DeviceRequest".equals(name))
            return new DeviceRequest();
        if ("DeviceUseStatement".equals(name))
            return new DeviceUseStatement();
        if ("DiagnosticReport".equals(name))
            return new DiagnosticReport();
        if ("DocumentManifest".equals(name))
            return new DocumentManifest();
        if ("DocumentReference".equals(name))
            return new DocumentReference();
        if ("Encounter".equals(name))
            return new Encounter();
        if ("Endpoint".equals(name))
            return new Endpoint();
        if ("EnrollmentRequest".equals(name))
            return new EnrollmentRequest();
        if ("EnrollmentResponse".equals(name))
            return new EnrollmentResponse();
        if ("EpisodeOfCare".equals(name))
            return new EpisodeOfCare();
        if ("EventDefinition".equals(name))
            return new EventDefinition();
        if ("Evidence".equals(name))
            return new Evidence();
        if ("EvidenceFocus".equals(name))
            return new EvidenceFocus();
        if ("EvidenceVariable".equals(name))
            return new EvidenceVariable();
        if ("ExampleScenario".equals(name))
            return new ExampleScenario();
        if ("ExplanationOfBenefit".equals(name))
            return new ExplanationOfBenefit();
        if ("FamilyMemberHistory".equals(name))
            return new FamilyMemberHistory();
        if ("Flag".equals(name))
            return new Flag();
        if ("Goal".equals(name))
            return new Goal();
        if ("GraphDefinition".equals(name))
            return new GraphDefinition();
        if ("Group".equals(name))
            return new Group();
        if ("GuidanceResponse".equals(name))
            return new GuidanceResponse();
        if ("HealthcareService".equals(name))
            return new HealthcareService();
        if ("ImagingStudy".equals(name))
            return new ImagingStudy();
        if ("Immunization".equals(name))
            return new Immunization();
        if ("ImmunizationEvaluation".equals(name))
            return new ImmunizationEvaluation();
        if ("ImmunizationRecommendation".equals(name))
            return new ImmunizationRecommendation();
        if ("ImplementationGuide".equals(name))
            return new ImplementationGuide();
        if ("Ingredient".equals(name))
            return new Ingredient();
        if ("InsurancePlan".equals(name))
            return new InsurancePlan();
        if ("Invoice".equals(name))
            return new Invoice();
        if ("Library".equals(name))
            return new Library();
        if ("Linkage".equals(name))
            return new Linkage();
        if ("List".equals(name))
            return new ListResource();
        if ("Location".equals(name))
            return new Location();
        if ("ManufacturedItemDefinition".equals(name))
            return new ManufacturedItemDefinition();
        if ("Measure".equals(name))
            return new Measure();
        if ("MeasureReport".equals(name))
            return new MeasureReport();
        if ("Medication".equals(name))
            return new Medication();
        if ("MedicationAdministration".equals(name))
            return new MedicationAdministration();
        if ("MedicationDispense".equals(name))
            return new MedicationDispense();
        if ("MedicationKnowledge".equals(name))
            return new MedicationKnowledge();
        if ("MedicationRequest".equals(name))
            return new MedicationRequest();
        if ("MedicationUsage".equals(name))
            return new MedicationUsage();
        if ("MedicinalProductDefinition".equals(name))
            return new MedicinalProductDefinition();
        if ("MessageDefinition".equals(name))
            return new MessageDefinition();
        if ("MessageHeader".equals(name))
            return new MessageHeader();
        if ("MolecularSequence".equals(name))
            return new MolecularSequence();
        if ("NamingSystem".equals(name))
            return new NamingSystem();
        if ("NutritionIntake".equals(name))
            return new NutritionIntake();
        if ("NutritionOrder".equals(name))
            return new NutritionOrder();
        if ("NutritionProduct".equals(name))
            return new NutritionProduct();
        if ("Observation".equals(name))
            return new Observation();
        if ("ObservationDefinition".equals(name))
            return new ObservationDefinition();
        if ("OperationDefinition".equals(name))
            return new OperationDefinition();
        if ("OperationOutcome".equals(name))
            return new OperationOutcome();
        if ("Organization".equals(name))
            return new Organization();
        if ("OrganizationAffiliation".equals(name))
            return new OrganizationAffiliation();
        if ("PackagedProductDefinition".equals(name))
            return new PackagedProductDefinition();
        if ("Parameters".equals(name))
            return new Parameters();
        if ("Patient".equals(name))
            return new Patient();
        if ("PaymentNotice".equals(name))
            return new PaymentNotice();
        if ("PaymentReconciliation".equals(name))
            return new PaymentReconciliation();
        if ("Permission".equals(name))
            return new Permission();
        if ("Person".equals(name))
            return new Person();
        if ("PlanDefinition".equals(name))
            return new PlanDefinition();
        if ("Practitioner".equals(name))
            return new Practitioner();
        if ("PractitionerRole".equals(name))
            return new PractitionerRole();
        if ("Procedure".equals(name))
            return new Procedure();
        if ("Provenance".equals(name))
            return new Provenance();
        if ("Questionnaire".equals(name))
            return new Questionnaire();
        if ("QuestionnaireResponse".equals(name))
            return new QuestionnaireResponse();
        if ("RegulatedAuthorization".equals(name))
            return new RegulatedAuthorization();
        if ("RelatedPerson".equals(name))
            return new RelatedPerson();
        if ("RequestGroup".equals(name))
            return new RequestGroup();
        if ("ResearchStudy".equals(name))
            return new ResearchStudy();
        if ("ResearchSubject".equals(name))
            return new ResearchSubject();
        if ("RiskAssessment".equals(name))
            return new RiskAssessment();
        if ("Schedule".equals(name))
            return new Schedule();
        if ("SearchParameter".equals(name))
            return new SearchParameter();
        if ("ServiceRequest".equals(name))
            return new ServiceRequest();
        if ("Slot".equals(name))
            return new Slot();
        if ("Specimen".equals(name))
            return new Specimen();
        if ("SpecimenDefinition".equals(name))
            return new SpecimenDefinition();
        if ("StructureDefinition".equals(name))
            return new StructureDefinition();
        if ("StructureMap".equals(name))
            return new StructureMap();
        if ("Subscription".equals(name))
            return new Subscription();
        if ("SubscriptionStatus".equals(name))
            return new SubscriptionStatus();
        if ("SubscriptionTopic".equals(name))
            return new SubscriptionTopic();
        if ("Substance".equals(name))
            return new Substance();
        if ("SubstanceDefinition".equals(name))
            return new SubstanceDefinition();
        if ("SubstanceNucleicAcid".equals(name))
            return new SubstanceNucleicAcid();
        if ("SubstancePolymer".equals(name))
            return new SubstancePolymer();
        if ("SubstanceProtein".equals(name))
            return new SubstanceProtein();
        if ("SubstanceReferenceInformation".equals(name))
            return new SubstanceReferenceInformation();
        if ("SubstanceSourceMaterial".equals(name))
            return new SubstanceSourceMaterial();
        if ("SupplyDelivery".equals(name))
            return new SupplyDelivery();
        if ("SupplyRequest".equals(name))
            return new SupplyRequest();
        if ("Task".equals(name))
            return new Task();
        if ("TerminologyCapabilities".equals(name))
            return new TerminologyCapabilities();
        if ("TestReport".equals(name))
            return new TestReport();
        if ("TestScript".equals(name))
            return new TestScript();
        if ("ValueSet".equals(name))
            return new ValueSet();
        if ("VerificationResult".equals(name))
            return new VerificationResult();
        if ("VisionPrescription".equals(name))
            return new VisionPrescription();

        else
            throw new FHIRException("Unknown Resource Name '"+name+"'");
    }

    public static Element createType(String name) throws FHIRException {
        if ("base64Binary".equals(name))            
          return new Base64BinaryType();
        if ("boolean".equals(name))            
          return new BooleanType();
        if ("canonical".equals(name))            
          return new CanonicalType();
        if ("code".equals(name))            
          return new CodeType();
        if ("date".equals(name))            
          return new DateType();
        if ("dateTime".equals(name))            
          return new DateTimeType();
        if ("decimal".equals(name))            
          return new DecimalType();
        if ("id".equals(name))            
          return new IdType();
        if ("instant".equals(name))            
          return new InstantType();
        if ("integer".equals(name))            
          return new IntegerType();
        if ("integer64".equals(name))            
          return new Integer64Type();
        if ("markdown".equals(name))            
          return new MarkdownType();
        if ("oid".equals(name))            
          return new OidType();
        if ("positiveInt".equals(name))            
          return new PositiveIntType();
        if ("string".equals(name))            
          return new StringType();
        if ("time".equals(name))            
          return new TimeType();
        if ("unsignedInt".equals(name))            
          return new UnsignedIntType();
        if ("uri".equals(name))            
          return new UriType();
        if ("url".equals(name))            
          return new UrlType();
        if ("uuid".equals(name))            
          return new UuidType();
        if ("Address".equals(name))
            return new Address();
        if ("Age".equals(name))
            return new Age();
        if ("Annotation".equals(name))
            return new Annotation();
        if ("Attachment".equals(name))
            return new Attachment();
        if ("CodeableConcept".equals(name))
            return new CodeableConcept();
        if ("CodeableReference".equals(name))
            return new CodeableReference();
        if ("Coding".equals(name))
            return new Coding();
        if ("ContactDetail".equals(name))
            return new ContactDetail();
        if ("ContactPoint".equals(name))
            return new ContactPoint();
        if ("Contributor".equals(name))
            return new Contributor();
        if ("Count".equals(name))
            return new Count();
        if ("DataRequirement".equals(name))
            return new DataRequirement();
        if ("Distance".equals(name))
            return new Distance();
        if ("Dosage".equals(name))
            return new Dosage();
        if ("Duration".equals(name))
            return new Duration();
        if ("ElementDefinition".equals(name))
            return new ElementDefinition();
        if ("Expression".equals(name))
            return new Expression();
        if ("Extension".equals(name))
            return new Extension();
        if ("HumanName".equals(name))
            return new HumanName();
        if ("Identifier".equals(name))
            return new Identifier();
        if ("MarketingStatus".equals(name))
            return new MarketingStatus();
        if ("Meta".equals(name))
            return new Meta();
        if ("Money".equals(name))
            return new Money();
        if ("Narrative".equals(name))
            return new Narrative();
        if ("OrderedDistribution".equals(name))
            return new OrderedDistribution();
        if ("ParameterDefinition".equals(name))
            return new ParameterDefinition();
        if ("Period".equals(name))
            return new Period();
        if ("Population".equals(name))
            return new Population();
        if ("ProdCharacteristic".equals(name))
            return new ProdCharacteristic();
        if ("ProductShelfLife".equals(name))
            return new ProductShelfLife();
        if ("Quantity".equals(name))
            return new Quantity();
        if ("Range".equals(name))
            return new Range();
        if ("Ratio".equals(name))
            return new Ratio();
        if ("Reference".equals(name))
            return new Reference();
        if ("RelatedArtifact".equals(name))
            return new RelatedArtifact();
        if ("SampledData".equals(name))
            return new SampledData();
        if ("Signature".equals(name))
            return new Signature();
        if ("Statistic".equals(name))
            return new Statistic();
        if ("SubstanceAmount".equals(name))
            return new SubstanceAmount();
        if ("Timing".equals(name))
            return new Timing();
        if ("TriggerDefinition".equals(name))
            return new TriggerDefinition();
        if ("UsageContext".equals(name))
            return new UsageContext();

        else
            throw new FHIRException("Unknown Type Name '"+name+"'");    }

    public static Base createResourceOrType(String name) throws FHIRException {
      switch (name.hashCode()) {
        case -1216012752: return new Base64BinaryType();
        case 64711720: return new BooleanType();
        case 828351732: return new CanonicalType();
        case 3059181: return new CodeType();
        case 3076014: return new DateType();
        case 1792749467: return new DateTimeType();
        case 1542263633: return new DecimalType();
        case 3355: return new IdType();
        case 1957570017: return new InstantType();
        case 1958052158: return new IntegerType();
        case 246938863: return new MarkdownType();
        case 110026: return new OidType();
        case -131262666: return new PositiveIntType();
        case -891985903: return new StringType();
        case 3560141: return new TimeType();
        case 1145198778: return new UnsignedIntType();
        case 116076: return new UriType();
        case 116079: return new UrlType();
        case 3601339: return new UuidType();
        case 487334413: return new Account();
        case 851278306: return new ActivityDefinition();
        case 1643210993: return new AdministrableProductDefinition();
        case -329624856: return new AdverseEvent();
        case 1721380104: return new AllergyIntolerance();
        case 192873343: return new Appointment();
        case 1733332192: return new AppointmentResponse();
        case -632949857: return new AuditEvent();
        case 63955982: return new Basic();
        case 1989867553: return new Binary();
        case -310041824: return new BiologicallyDerivedProduct();
        case -202769967: return new BodyStructure();
        case 2000952482: return new Bundle();
        case -871422185: return new CapabilityStatement();
        case -1244283909: return new CapabilityStatement2();
        case 57208314: return new CarePlan();
        case 57320750: return new CareTeam();
        case -1007602695: return new CatalogEntry();
        case -883723257: return new ChargeItem();
        case -315725638: return new ChargeItemDefinition();
        case -1378062585: return new Citation();
        case 65189916: return new Claim();
        case 1488475261: return new ClaimResponse();
        case -1268501092: return new ClinicalImpression();
        case -590890011: return new ClinicalUseIssue();
        case 1076953756: return new CodeSystem();
        case -236322890: return new Communication();
        case -1874423303: return new CommunicationRequest();
        case 1287805733: return new CompartmentDefinition();
        case 828944778: return new Composition();
        case 57185780: return new ConceptMap();
        case 1142656251: return new Condition();
        case 1722998958: return new ConditionDefinition();
        case -1678813190: return new Consent();
        case -502303438: return new Contract();
        case -287122936: return new Coverage();
        case -140860822: return new CoverageEligibilityRequest();
        case -18784314: return new CoverageEligibilityResponse();
        case 850563927: return new DetectedIssue();
        case 2043677302: return new Device();
        case 1083244649: return new DeviceDefinition();
        case -949306426: return new DeviceMetric();
        case 776138553: return new DeviceRequest();
        case 491858238: return new DeviceUseStatement();
        case -1122842661: return new DiagnosticReport();
        case 1922784394: return new DocumentManifest();
        case -1202791344: return new DocumentReference();
        case -766867181: return new Encounter();
        case 1805746613: return new Endpoint();
        case -1377846581: return new EnrollmentRequest();
        case 289362821: return new EnrollmentResponse();
        case -1093178557: return new EpisodeOfCare();
        case 1851868013: return new EventDefinition();
        case 447611511: return new Evidence();
        case -1696443231: return new EvidenceFocus();
        case -1162161645: return new EvidenceVariable();
        case 1175230202: return new ExampleScenario();
        case -1001676601: return new ExplanationOfBenefit();
        case 1260711798: return new FamilyMemberHistory();
        case 2192268: return new Flag();
        case 2224947: return new Goal();
        case -180371167: return new GraphDefinition();
        case 69076575: return new Group();
        case 997117913: return new GuidanceResponse();
        case 933423720: return new HealthcareService();
        case -650580623: return new ImagingStudy();
        case -2004863454: return new Immunization();
        case -1768794370: return new ImmunizationEvaluation();
        case 1728372347: return new ImmunizationRecommendation();
        case 1410262602: return new ImplementationGuide();
        case 1787055601: return new Ingredient();
        case -1503864573: return new InsurancePlan();
        case -670115059: return new Invoice();
        case 1830861979: return new Library();
        case 1841735333: return new Linkage();
        case 2368702: return new ListResource();
        case 1965687765: return new Location();
        case -116700279: return new ManufacturedItemDefinition();
        case -1691992770: return new Measure();
        case 1681397778: return new MeasureReport();
        case -302536977: return new Medication();
        case -342579923: return new MedicationAdministration();
        case -408244884: return new MedicationDispense();
        case 1537687119: return new MedicationKnowledge();
        case 1627523232: return new MedicationRequest();
        case 362406898: return new MedicationUsage();
        case -1378257556: return new MedicinalProductDefinition();
        case -2037697382: return new MessageDefinition();
        case -1087398572: return new MessageHeader();
        case -1839726095: return new MolecularSequence();
        case 369315063: return new NamingSystem();
        case -146918204: return new NutritionIntake();
        case 1247831734: return new NutritionOrder();
        case 1768059479: return new NutritionProduct();
        case 1790214156: return new Observation();
        case 673706623: return new ObservationDefinition();
        case -2140710406: return new OperationDefinition();
        case -526550005: return new OperationOutcome();
        case 1343242579: return new Organization();
        case 2069161885: return new OrganizationAffiliation();
        case 577413700: return new PackagedProductDefinition();
        case -1842766326: return new Parameters();
        case 873235173: return new Patient();
        case 2082457694: return new PaymentNotice();
        case 28778089: return new PaymentReconciliation();
        case 1475846639: return new Permission();
        case -1907849355: return new Person();
        case 1401244028: return new PlanDefinition();
        case 738893626: return new Practitioner();
        case -621058352: return new PractitionerRole();
        case 908763827: return new Procedure();
        case 2093211201: return new Provenance();
        case -218088061: return new Questionnaire();
        case 269058788: return new QuestionnaireResponse();
        case 2137545436: return new RegulatedAuthorization();
        case 846088000: return new RelatedPerson();
        case 1445374288: return new RequestGroup();
        case 1312904398: return new ResearchStudy();
        case -1008013583: return new ResearchSubject();
        case -766422255: return new RiskAssessment();
        case -633276745: return new Schedule();
        case -912457023: return new SearchParameter();
        case -1944810950: return new ServiceRequest();
        case 2579998: return new Slot();
        case -2068224216: return new Specimen();
        case 863741595: return new SpecimenDefinition();
        case 1133777670: return new StructureDefinition();
        case 1958247177: return new StructureMap();
        case 505523517: return new Subscription();
        case 108709775: return new SubscriptionStatus();
        case 835579378: return new SubscriptionTopic();
        case -1760959152: return new Substance();
        case 1971491523: return new SubstanceDefinition();
        case -300807236: return new SubstanceNucleicAcid();
        case 1272939294: return new SubstancePolymer();
        case 1361440787: return new SubstanceProtein();
        case 159007313: return new SubstanceReferenceInformation();
        case -222622766: return new SubstanceSourceMaterial();
        case 383030819: return new SupplyDelivery();
        case 665843328: return new SupplyRequest();
        case 2599333: return new Task();
        case -549565975: return new TerminologyCapabilities();
        case -616289146: return new TestReport();
        case -589453283: return new TestScript();
        case -1345530543: return new ValueSet();
        case 957089336: return new VerificationResult();
        case -555387838: return new VisionPrescription();
        case 516961236: return new Address();
        case 65759: return new Age();
        case 438421327: return new Annotation();
        case 29963587: return new Attachment();
        case -1153521791: return new CodeableConcept();
        case -464287196: return new CodeableReference();
        case 2023747466: return new Coding();
        case 973193329: return new ContactDetail();
        case 1428236656: return new ContactPoint();
        case -227407685: return new Contributor();
        case 65298671: return new Count();
        case -367870439: return new DataRequirement();
        case 353103893: return new Distance();
        case 2052815575: return new Dosage();
        case -1927368268: return new Duration();
        case -1605049009: return new ElementDefinition();
        case 198012600: return new Expression();
        case 1391410207: return new Extension();
        case 1592332600: return new HumanName();
        case 375032009: return new Identifier();
        case -926250600: return new MarketingStatus();
        case 2394661: return new Meta();
        case 74526880: return new Money();
        case -540546990: return new Narrative();
        case 2020222833: return new OrderedDistribution();
        case 671337916: return new ParameterDefinition();
        case -1907858975: return new Period();
        case -30093459: return new Population();
        case 458000626: return new ProdCharacteristic();
        case 1209602103: return new ProductShelfLife();
        case -1220360021: return new Quantity();
        case 78727453: return new Range();
        case 78733291: return new Ratio();
        case 1078812459: return new Reference();
        case -330210563: return new RelatedArtifact();
        case 1824308900: return new SampledData();
        case -1217415016: return new Signature();
        case -77293264: return new Statistic();
        case 1549526472: return new SubstanceAmount();
        case -1789797270: return new Timing();
        case 770498827: return new TriggerDefinition();
        case 1071332590: return new UsageContext();

      default:
        throw new FHIRException("Unknown Resource or Type Name '"+name+"'");
    }
  }


}