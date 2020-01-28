package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

public class StructureDefinition14_40 {

    static public org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType convertExtensionContext(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESOURCE:
                return org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.ELEMENT;
            case DATATYPE:
                return org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.ELEMENT;
            case EXTENSION:
                return org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.EXTENSION;
            default:
                return org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType src, String expression) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FHIRPATH:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.RESOURCE;
            case ELEMENT:
                String tn = expression.contains(".") ? expression.substring(0, expression.indexOf(".")) : expression;
                if (isResource140(tn)) {
                    return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.RESOURCE;
                } else {
                    return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.DATATYPE;
                }
            case EXTENSION:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.EXTENSION;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r4.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setDisplay(src.getTitle());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.r4.model.Coding t : src.getKeyword()) tgt.addCode(VersionConvertor_14_40.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion().toCode());
        for (org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        tgt.setKind(convertStructureDefinitionKind(src.getKind()));
        tgt.setAbstract(src.getAbstract());
        for (org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext()) {
            if (!tgt.hasContextType())
                tgt.setContextType(convertExtensionContext(t.getType(), t.getExpression()));
            tgt.addContext("Element".equals(t.getExpression()) ? "*" : t.getExpression());
        }
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        if (src.hasType() && src.getDerivation() == org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.CONSTRAINT)
            tgt.setBaseType(src.getType());
        tgt.setDerivation(convertTypeDerivationRule(src.getDerivation()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu2016may.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        if (src.hasDisplay())
            tgt.setTitle(src.getDisplay());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addKeyword(VersionConvertor_14_40.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        tgt.setKind(convertStructureDefinitionKind(src.getKind(), src.getName()));
        tgt.setAbstract(src.getAbstract());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getContext()) {
            org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent ec = tgt.addContext();
            ec.setType(convertExtensionContext(src.getContextType()));
            ec.setExpression("*".equals(t.getValue()) ? "Element" : t.getValue());
        }
        if (src.getDerivation() == org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.CONSTRAINT)
            tgt.setType(src.getBaseType());
        else
            tgt.setType(src.getId());
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        tgt.setDerivation(convertTypeDerivationRule(src.getDerivation()));
        if (src.hasSnapshot()) {
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
            tgt.getSnapshot().getElementFirstRep().getType().clear();
        }
        if (src.hasDifferential()) {
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
            tgt.getDifferential().getElementFirstRep().getType().clear();
        }
        if (tgt.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
            for (ElementDefinition ed : tgt.getSnapshot().getElement()) {
                if (!ed.hasBase()) {
                    ed.getBase().setPath(ed.getPath()).setMin(ed.getMin()).setMax(ed.getMax());
                }
            }
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent convertStructureDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRIMITIVETYPE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case COMPLEXTYPE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind src, String name) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DATATYPE:
                if (name.substring(0, 1).toLowerCase().equals(name.substring(0, 1)))
                    return org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE;
                else
                    return org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE;
            case RESOURCE:
                return org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComments(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComments())
            tgt.setComment(src.getComments());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule convertTypeDerivationRule(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SPECIALIZATION:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION;
            case CONSTRAINT:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.CONSTRAINT;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule convertTypeDerivationRule(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SPECIALIZATION:
                return org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION;
            case CONSTRAINT:
                return org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.CONSTRAINT;
            default:
                return org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.NULL;
        }
    }

    static public boolean isResource140(String tn) {
        return Utilities.existsInList(tn, "Account", "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodySite", "Bundle", "CarePlan", "CareTeam", "Claim", "ClaimResponse", "ClinicalImpression", "CodeSystem", "Communication", "CommunicationRequest", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Conformance", "Contract", "Coverage", "DataElement", "DecisionSupportRule", "DecisionSupportServiceModule", "DetectedIssue", "Device", "DeviceComponent", "DeviceMetric", "DeviceUseRequest", "DeviceUseStatement", "DiagnosticOrder", "DiagnosticReport", "DocumentManifest", "DocumentReference", "EligibilityRequest", "EligibilityResponse", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "ExpansionProfile", "ExplanationOfBenefit", "FamilyMemberHistory", "Flag", "Goal", "Group", "GuidanceResponse", "HealthcareService", "ImagingExcerpt", "ImagingObjectSelection", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "Library", "Linkage", "List", "Location", "Measure", "MeasureReport", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationOrder", "MedicationStatement", "MessageHeader", "ModuleDefinition", "NamingSystem", "NutritionOrder", "Observation", "OperationDefinition", "OperationOutcome", "Order", "OrderResponse", "OrderSet", "Organization", "Parameters", "Patient", "PaymentNotice", "PaymentReconciliation", "Person", "Practitioner", "PractitionerRole", "Procedure", "ProcedureRequest", "ProcessRequest", "ProcessResponse", "Protocol", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "Slot", "Sequence", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "Task", "TestScript", "ValueSet", "VisionPrescription");
    }
}
