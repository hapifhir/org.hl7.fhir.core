package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Dosage30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.RelatedArtifact30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;

public class ActivityDefinition30_40 {

  public static org.hl7.fhir.dstu3.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r4.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ActivityDefinition tgt = new org.hl7.fhir.dstu3.model.ActivityDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String30_40.convertString(src.getUsageElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.AUTHOR);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.EDITOR);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.REVIEWER);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.ENDORSER);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary())
      tgt.addLibrary(Reference30_40.convertCanonicalToReference(t));
    if (src.hasKind())
      tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTiming()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage30_40.convertDosage(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasTransform())
      tgt.setTransform(Reference30_40.convertCanonicalToReference(src.getTransformElement()));
    for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.dstu3.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition tgt = new org.hl7.fhir.r4.model.ActivityDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String30_40.convertString(src.getUsageElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
      if (t.getType() == ContributorType.AUTHOR)
        for (ContactDetail c : t.getContact()) tgt.addAuthor(ContactDetail30_40.convertContactDetail(c));
      if (t.getType() == ContributorType.EDITOR)
        for (ContactDetail c : t.getContact()) tgt.addEditor(ContactDetail30_40.convertContactDetail(c));
      if (t.getType() == ContributorType.REVIEWER)
        for (ContactDetail c : t.getContact()) tgt.addReviewer(ContactDetail30_40.convertContactDetail(c));
      if (t.getType() == ContributorType.ENDORSER)
        for (ContactDetail c : t.getContact()) tgt.addEndorser(ContactDetail30_40.convertContactDetail(c));
    }
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getLibrary())
      tgt.getLibrary().add(Reference30_40.convertReferenceToCanonical(t));
    if (src.hasKind())
      tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTiming()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    for (org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage30_40.convertDosage(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasTransform())
      tgt.setTransformElement(Reference30_40.convertReferenceToCanonical(src.getTransform()));
    for (org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasDescription())
      tgt.getExpression().setDescription(src.getDescription());
    if (src.hasPath())
      tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasLanguage())
      tgt.getExpression().setLanguage(src.getLanguage());
    if (src.hasExpression())
      tgt.getExpression().setExpression(src.getExpression());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasPath())
      tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.getExpression().hasDescription())
      tgt.setDescription(src.getExpression().getDescription());
    if (src.getExpression().hasLanguage())
      tgt.setLanguage(src.getExpression().getLanguage());
    if (src.getExpression().hasExpression())
      tgt.setExpression(src.getExpression().getExpression());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> convertActivityDefinitionKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKindEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case APPOINTMENT:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENT);
        break;
      case APPOINTMENTRESPONSE:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENTRESPONSE);
        break;
      case CAREPLAN:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CAREPLAN);
        break;
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CLAIM);
        break;
      case COMMUNICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.COMMUNICATIONREQUEST);
        break;
      case CONTRACT:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CONTRACT);
        break;
      case DEVICEREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.DEVICEREQUEST);
        break;
      case ENROLLMENTREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.ENROLLMENTREQUEST);
        break;
      case IMMUNIZATIONRECOMMENDATION:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.IMMUNIZATIONRECOMMENDATION);
        break;
      case MEDICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.MEDICATIONREQUEST);
        break;
      case NUTRITIONORDER:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NUTRITIONORDER);
        break;
      case PROCEDUREREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SERVICEREQUEST);
        break;
      case REFERRALREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SERVICEREQUEST);
        break;
      case SUPPLYREQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SUPPLYREQUEST);
        break;
      case TASK:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.TASK);
        break;
      case VISIONPRESCRIPTION:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.VISIONPRESCRIPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind> convertActivityDefinitionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKindEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case APPOINTMENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENT);
        break;
      case APPOINTMENTRESPONSE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENTRESPONSE);
        break;
      case CAREPLAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.CAREPLAN);
        break;
      case CLAIM:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.CLAIM);
        break;
      case COMMUNICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.COMMUNICATIONREQUEST);
        break;
      case CONTRACT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.CONTRACT);
        break;
      case DEVICEREQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.DEVICEREQUEST);
        break;
      case ENROLLMENTREQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.ENROLLMENTREQUEST);
        break;
      case IMMUNIZATIONRECOMMENDATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.IMMUNIZATIONRECOMMENDATION);
        break;
      case MEDICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.MEDICATIONREQUEST);
        break;
      case NUTRITIONORDER:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.NUTRITIONORDER);
        break;
      case SERVICEREQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.PROCEDUREREQUEST);
        break;
      case SUPPLYREQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.SUPPLYREQUEST);
        break;
      case TASK:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.TASK);
        break;
      case VISIONPRESCRIPTION:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.VISIONPRESCRIPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> convertActivityParticipantType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.PATIENT);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.PRACTITIONER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.RELATEDPERSON);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType> convertActivityParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType.PATIENT);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType.PRACTITIONER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType.RELATEDPERSON);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ActivityDefinition.ActivityParticipantType.NULL);
        break;
    }
    return tgt;
  }
}