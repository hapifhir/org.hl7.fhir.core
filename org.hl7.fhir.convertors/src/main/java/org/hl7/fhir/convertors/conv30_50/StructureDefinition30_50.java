package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class StructureDefinition30_50 {

    static public org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType convertExtensionContext(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESOURCE:
                return org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.ELEMENT;
            case DATATYPE:
                return org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.ELEMENT;
            case EXTENSION:
                return org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.EXTENSION;
            default:
                return org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType src, String expression) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FHIRPATH:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE;
            case ELEMENT:
                String tn = expression.contains(".") ? expression.substring(0, expression.indexOf(".")) : expression;
                if (isResource300(tn)) {
                    return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE;
                } else {
                    return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.DATATYPE;
                }
            case EXTENSION:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.EXTENSION;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu3.model.StructureDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu3.model.Coding t : src.getKeyword()) tgt.addKeyword(VersionConvertor_30_50.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        for (org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKind(convertStructureDefinitionKind(src.getKind()));
        if (src.hasAbstract())
            tgt.setAbstract(src.getAbstract());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getContext()) {
            org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent ec = tgt.addContext();
            ec.setType(convertExtensionContext(src.getContextType()));
            ec.setExpression("*".equals(t.getValue()) ? "Element" : t.getValue());
        }
        for (org.hl7.fhir.dstu3.model.StringType t : src.getContextInvariant()) tgt.addContextInvariant(t.getValue());
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        if (src.hasDerivation())
            tgt.setDerivation(convertTypeDerivationRule(src.getDerivation()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        if (tgt.getDerivation() == org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION) {
            for (org.hl7.fhir.r5.model.ElementDefinition ed : tgt.getSnapshot().getElement()) {
                if (!ed.hasBase()) {
                    ed.getBase().setPath(ed.getPath()).setMin(ed.getMin()).setMax(ed.getMax());
                }
            }
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r5.model.StructureDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition tgt = new org.hl7.fhir.dstu3.model.StructureDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.r5.model.Coding t : src.getKeyword()) tgt.addKeyword(VersionConvertor_30_50.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion().toCode());
        for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKind(convertStructureDefinitionKind(src.getKind()));
        if (src.hasAbstract())
            tgt.setAbstract(src.getAbstract());
        for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext()) {
            if (!tgt.hasContextType())
                tgt.setContextType(convertExtensionContext(t.getType(), t.getExpression()));
            tgt.addContext("Element".equals(t.getExpression()) ? "*" : t.getExpression());
        }
        for (org.hl7.fhir.r5.model.StringType t : src.getContextInvariant()) tgt.addContextInvariant(t.getValue());
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        if (src.hasDerivation())
            tgt.setDerivation(convertTypeDerivationRule(src.getDerivation()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_30_50.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_30_50.convertElementDefinition(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRIMITIVETYPE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE;
            case COMPLEXTYPE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRIMITIVETYPE:
                return org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE;
            case COMPLEXTYPE:
                return org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE;
            case RESOURCE:
                return org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentity(src.getIdentity());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentity(src.getIdentity());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_30_50.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_30_50.convertElementDefinition(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule convertTypeDerivationRule(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SPECIALIZATION:
                return org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION;
            case CONSTRAINT:
                return org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.CONSTRAINT;
            default:
                return org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule convertTypeDerivationRule(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SPECIALIZATION:
                return org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION;
            case CONSTRAINT:
                return org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.NULL;
        }
    }

    static public boolean isResource300(String tn) {
        return Utilities.existsInList(tn, "Account", "ActivityDefinition", "AllergyIntolerance", "AdverseEvent", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodySite", "Bundle", "CapabilityStatement", "CarePlan", "CareTeam", "ChargeItem", "Claim", "ClaimResponse", "ClinicalImpression", "CodeSystem", "Communication", "CommunicationRequest", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Consent", "Contract", "Coverage", "DataElement", "DetectedIssue", "Device", "DeviceComponent", "DeviceMetric", "DeviceRequest", "DeviceUseStatement", "DiagnosticReport", "DocumentManifest", "DocumentReference", "EligibilityRequest", "EligibilityResponse", "Encounter", "Endpoint", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "ExpansionProfile", "ExplanationOfBenefit", "FamilyMemberHistory", "Flag", "Goal", "GraphDefinition", "Group", "GuidanceResponse", "HealthcareService", "ImagingManifest", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "Library", "Linkage", "List", "Location", "Measure", "MeasureReport", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationRequest", "MedicationStatement", "MessageDefinition", "MessageHeader", "NamingSystem", "NutritionOrder", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Parameters", "Patient", "PaymentNotice", "PaymentReconciliation", "Person", "PlanDefinition", "Practitioner", "PractitionerRole", "Procedure", "ProcedureRequest", "ProcessRequest", "ProcessResponse", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RequestGroup", "ResearchStudy", "ResearchSubject", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "ServiceDefinition", "Slot", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "Task", "TestScript", "TestReport", "ValueSet", "VisionPrescription");
    }
}
