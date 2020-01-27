package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class StructureDefinition10_40 {

    static public org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType convertExtensionContext(org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType src, String expression) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FHIRPATH:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.RESOURCE;
            case ELEMENT:
                String tn = expression.contains(".") ? expression.substring(0, expression.indexOf(".")) : expression;
                if (isResource102(tn)) {
                    return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.RESOURCE;
                } else {
                    return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.DATATYPE;
                }
            case EXTENSION:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.EXTENSION;
            default:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu2.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setTitle(src.getDisplay());
        tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConceptToUsageContext(t));
        tgt.setPurpose(src.getRequirements());
        tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addKeyword(VersionConvertor_10_40.convertCoding(t));
        tgt.setFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        for (org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        tgt.setKind(convertStructureDefinitionKind(src.getKind(), tgt.getId()));
        tgt.setAbstract(src.getAbstract());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getContext()) {
            org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent ec = tgt.addContext();
            ec.setType(convertExtensionContext(src.getContextType()));
            ec.setExpression("*".equals(t.getValue()) ? "Element" : t.getValue());
        }
        if (src.hasConstrainedType())
            tgt.setType(src.getConstrainedType());
        else if (src.getSnapshot().hasElement())
            tgt.setType(src.getSnapshot().getElement().get(0).getPath());
        else if (src.getDifferential().hasElement() && !src.getDifferential().getElement().get(0).getPath().contains("."))
            tgt.setType(src.getDifferential().getElement().get(0).getPath());
        else
            tgt.setType(src.getDifferential().getElement().get(0).getPath().substring(0, src.getDifferential().getElement().get(0).getPath().indexOf(".")));
        tgt.setBaseDefinition(src.getBase());
        tgt.setDerivation(src.hasConstrainedType() ? org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.CONSTRAINT : org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        if (tgt.hasSnapshot())
            tgt.getSnapshot().getElementFirstRep().getType().clear();
        if (tgt.hasDifferential())
            tgt.getDifferential().getElementFirstRep().getType().clear();
        if (tgt.getKind() == StructureDefinitionKind.PRIMITIVETYPE && !tgt.getType().equals(tgt.getId())) {
            tgt.setDerivation(TypeDerivationRule.SPECIALIZATION);
            tgt.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/" + tgt.getType());
            tgt.setType(tgt.getId());
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

    public static org.hl7.fhir.dstu2.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r4.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition tgt = new org.hl7.fhir.dstu2.model.StructureDefinition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setDisplay(src.getTitle());
        tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setRequirements(src.getPurpose());
        tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.r4.model.Coding t : src.getKeyword()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
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
        tgt.setConstrainedType(src.getType());
        tgt.setBase(src.getBaseDefinition());
        tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        if (tgt.hasBase()) {
            if (tgt.hasDifferential())
                tgt.getDifferential().getElement().get(0).addType().setCode(tail(tgt.getBase()));
            if (tgt.hasSnapshot())
                tgt.getSnapshot().getElement().get(0).addType().setCode(tail(tgt.getBase()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent convertStructureDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        List<String> slicePaths = new ArrayList<String>();
        for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
            if (t.hasSlicing())
                slicePaths.add(t.getPath());
            tgt.addElement(VersionConvertor_10_40.convertElementDefinition(t, slicePaths, src.getElement(), src.getElement().indexOf(t)));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_40.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind src, String dtName) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DATATYPE:
                if (Utilities.existsInList(dtName, "boolean", "integer", "decimal", "base64Binary", "instant", "string", "uri", "date", "dateTime", "time", "code", "oid", "uuid", "id", "unsignedInt", "positiveInt", "markdown", "xhtml", "url", "canonical"))
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

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRIMITIVETYPE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case COMPLEXTYPE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        tgt.setUri(src.getUri());
        tgt.setName(src.getName());
        tgt.setComments(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        tgt.setUri(src.getUri());
        tgt.setName(src.getName());
        tgt.setComment(src.getComments());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        List<String> slicePaths = new ArrayList<String>();
        for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
            if (t.hasSlicing())
                slicePaths.add(t.getPath());
            tgt.addElement(VersionConvertor_10_40.convertElementDefinition(t, slicePaths, src.getElement(), src.getElement().indexOf(t)));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_40.convertElementDefinition(t));
        return tgt;
    }

    static public boolean isResource102(String tn) {
        return Utilities.existsInList(tn, "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodySite", "Bundle", "CarePlan", "Claim", "ClaimResponse", "ClinicalImpression", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "Conformance", "Contract", "DetectedIssue", "Coverage", "DataElement", "Device", "DeviceComponent", "DeviceMetric", "DeviceUseRequest", "DeviceUseStatement", "DiagnosticOrder", "DiagnosticReport", "DocumentManifest", "DocumentReference", "EligibilityRequest", "EligibilityResponse", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "ExplanationOfBenefit", "FamilyMemberHistory", "Flag", "Goal", "Group", "HealthcareService", "ImagingObjectSelection", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "List", "Location", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationOrder", "MedicationStatement", "MessageHeader", "NamingSystem", "NutritionOrder", "Observation", "OperationDefinition", "OperationOutcome", "Order", "OrderResponse", "Organization", "Parameters", "Patient", "PaymentNotice", "PaymentReconciliation", "Person", "Practitioner", "Procedure", "ProcessRequest", "ProcessResponse", "ProcedureRequest", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "Specimen", "StructureDefinition", "Subscription", "Substance", "SupplyRequest", "SupplyDelivery", "TestScript", "ValueSet", "VisionPrescription");
    }

    static public String tail(String base) {
        return base.substring(base.lastIndexOf("/") + 1);
    }
}
