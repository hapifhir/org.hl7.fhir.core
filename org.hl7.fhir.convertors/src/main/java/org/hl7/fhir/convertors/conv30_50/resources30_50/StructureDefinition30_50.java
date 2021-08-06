package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ElementDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class StructureDefinition30_50 {

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> convertExtensionContext(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.ELEMENT);
        break;
      case DATATYPE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.ELEMENT);
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.EXTENSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> convertExtensionContext(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> src, String expression) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContextEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case FHIRPATH:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE);
        break;
      case ELEMENT:
        String tn = expression.contains(".") ? expression.substring(0, expression.indexOf(".")) : expression;
        if (isResource300(tn)) {
          tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE);
        } else {
          tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.DATATYPE);
        }
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.EXTENSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu3.model.StructureDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getKeyword()) tgt.addKeyword(Coding30_50.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
    for (org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean30_50.convertBoolean(src.getAbstractElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getContext()) {
      org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent ec = tgt.addContext();
      ec.setTypeElement(convertExtensionContext(src.getContextTypeElement()));
      ec.setExpression("*".equals(t.getValue()) ? "Element" : t.getValue());
    }
    for (org.hl7.fhir.dstu3.model.StringType t : src.getContextInvariant()) tgt.addContextInvariant(t.getValue());
    if (src.hasType())
      tgt.setType(src.getType());
    if (src.hasBaseDefinition())
      tgt.setBaseDefinition(src.getBaseDefinition());
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
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
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getKeyword()) tgt.addKeyword(Coding30_50.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersion(src.getFhirVersion().toCode());
    for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean30_50.convertBoolean(src.getAbstractElement()));
    for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext()) {
      if (!tgt.hasContextType())
        tgt.setContextTypeElement(convertExtensionContext(t.getTypeElement(), t.getExpression()));
      tgt.addContext("Element".equals(t.getExpression()) ? "*" : t.getExpression());
    }
    for (org.hl7.fhir.r5.model.StringType t : src.getContextInvariant()) tgt.addContextInvariant(t.getValue());
    if (src.hasType())
      tgt.setType(src.getType());
    if (src.hasBaseDefinition())
      tgt.setBaseDefinition(src.getBaseDefinition());
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
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
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition30_50.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition30_50.convertElementDefinition(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKindEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRIMITIVETYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
        break;
      case COMPLEXTYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKindEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRIMITIVETYPE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
        break;
      case COMPLEXTYPE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(Id30_50.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri30_50.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(Id30_50.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri30_50.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition30_50.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition30_50.convertElementDefinition(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRuleEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SPECIALIZATION:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        break;
      case CONSTRAINT:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRuleEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SPECIALIZATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        break;
      case CONSTRAINT:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.NULL);
        break;
    }
    return tgt;
  }

  static public boolean isResource300(String tn) {
    return Utilities.existsInList(tn, "Account", "ActivityDefinition", "AllergyIntolerance", "AdverseEvent", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodySite", "Bundle", "CapabilityStatement", "CarePlan", "CareTeam", "ChargeItem", "Claim", "ClaimResponse", "ClinicalImpression", "CodeSystem", "Communication", "CommunicationRequest", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Consent", "Contract", "Coverage", "DataElement", "DetectedIssue", "Device", "DeviceComponent", "DeviceMetric", "DeviceRequest", "DeviceUseStatement", "DiagnosticReport", "DocumentManifest", "DocumentReference", "EligibilityRequest", "EligibilityResponse", "Encounter", "Endpoint", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "ExpansionProfile", "ExplanationOfBenefit", "FamilyMemberHistory", "Flag", "Goal", "GraphDefinition", "Group", "GuidanceResponse", "HealthcareService", "ImagingManifest", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "Library", "Linkage", "List", "Location", "Measure", "MeasureReport", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationRequest", "MedicationStatement", "MessageDefinition", "MessageHeader", "NamingSystem", "NutritionOrder", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Parameters", "Patient", "PaymentNotice", "PaymentReconciliation", "Person", "PlanDefinition", "Practitioner", "PractitionerRole", "Procedure", "ProcedureRequest", "ProcessRequest", "ProcessResponse", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RequestGroup", "ResearchStudy", "ResearchSubject", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "ServiceDefinition", "Slot", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "Task", "TestScript", "TestReport", "ValueSet", "VisionPrescription");
  }
}