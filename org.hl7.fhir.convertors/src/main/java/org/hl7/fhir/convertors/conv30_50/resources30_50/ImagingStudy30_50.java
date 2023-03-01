package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.UnsignedInt30_50;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;

public class ImagingStudy30_50 {

  private static final String URN_DICOM_UID = "urn:dicom:uid";

  private static final String URN_IETF_RFC_3986 = "urn:ietf:rfc:3986";

  public static org.hl7.fhir.dstu3.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r5.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImagingStudy tgt = new org.hl7.fhir.dstu3.model.ImagingStudy();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) {
      if (URN_DICOM_UID.equals(t.getSystem())) {
        tgt.setUid(t.getValue());
      } else {
        tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
      }
    }
    if (src.hasStatus()) {
      org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus s = src.getStatus();
      switch (s) {
        case REGISTERED:
          tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.OFFLINE);
          break;
        case AVAILABLE:
          tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.ONLINE);
          break;
        case CANCELLED:
          tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.UNAVAILABLE);
          break;
        default:
          break;
      }
    }
    for (CodeableConcept t : src.getModality()) {
      for (Coding tt : t.getCoding())
      tgt.addModalityList(Coding30_50.convertCoding(tt));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setPatient(Reference30_50.convertReference(src.getSubject()));
    }
    if (src.hasEncounter()) {
      if (src.hasEncounter())
        tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    }
    if (src.hasStarted()) {
      if (src.hasStartedElement())
        tgt.setStartedElement(DateTime30_50.convertDateTime(src.getStartedElement()));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_50.convertReference(t));
    }
    if (src.hasReferrer()) {
      if (src.hasReferrer())
        tgt.setReferrer(Reference30_50.convertReference(src.getReferrer()));
    }
//    for (org.hl7.fhir.r5.model.Reference t : src.getInterpreter()) {
//      tgt.addInterpreter(Reference30_50.convertReference(t));
//    }
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) {
      tgt.addEndpoint(Reference30_50.convertReference(t));
    }
    if (src.hasNumberOfSeries()) {
      if (src.hasNumberOfSeriesElement())
        tgt.setNumberOfSeriesElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberOfSeriesElement()));
    }
    if (src.hasNumberOfInstances()) {
      if (src.hasNumberOfInstancesElement())
        tgt.setNumberOfInstancesElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    }
    for (CodeableReference t : src.getProcedure()) {
      if (t.hasReference()) {
        tgt.addProcedureReference(Reference30_50.convertReference(t.getReference()));
      } else {
        tgt.addProcedureCode(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
      }
    }
    List<CodeableReference> reasonCodes = src.getReason();
    if (reasonCodes.size() > 0) {
      tgt.setReason(CodeableConcept30_50.convertCodeableConcept(reasonCodes.get(0).getConcept()));
      if (reasonCodes.size() > 1) {
      }
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    }
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) {
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu3.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy tgt = new org.hl7.fhir.r5.model.ImagingStudy();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUid()) {
      org.hl7.fhir.r5.model.Identifier i = new org.hl7.fhir.r5.model.Identifier();
      i.setSystem(URN_DICOM_UID);
      i.setValue(src.getUid());
      tgt.addIdentifier(i);
    }
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    }
    if (src.hasAccession())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getAccession()));
    if (src.hasAvailability()) {
      org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability availability = src.getAvailability();
      switch (availability) {
        case OFFLINE:
          tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.REGISTERED);
          break;
        case UNAVAILABLE:
          tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.CANCELLED);
          break;
        case ONLINE:
        case NEARLINE:
          tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.AVAILABLE);
          break;
        default:
          break;
      }
    } else {
      tgt.setStatus(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.UNKNOWN);
    }
    for (org.hl7.fhir.dstu3.model.Coding t : src.getModalityList()) {
      tgt.addModality(new CodeableConcept().addCoding(Coding30_50.convertCoding(t)));
    }
    if (src.hasPatient())
      tgt.setSubject(Reference30_50.convertReference(src.getPatient()));
    if (src.hasContext()) {
      if (src.hasContext())
        tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    }
    if (src.hasStarted()) {
      if (src.hasStartedElement())
        tgt.setStartedElement(DateTime30_50.convertDateTime(src.getStartedElement()));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_50.convertReference(t));
    }
    if (src.hasReferrer()) {
      if (src.hasReferrer())
        tgt.setReferrer(Reference30_50.convertReference(src.getReferrer()));
    }
//    for (org.hl7.fhir.dstu3.model.Reference t : src.getInterpreter()) {
//      tgt.addInterpreter(Reference30_50.convertReference(t));
//    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) {
      tgt.addEndpoint(Reference30_50.convertReference(t));
    }
    if (src.hasNumberOfSeries()) {
      if (src.hasNumberOfSeriesElement())
        tgt.setNumberOfSeriesElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberOfSeriesElement()));
    }
    if (src.hasNumberOfInstances()) {
      if (src.hasNumberOfInstancesElement())
        tgt.setNumberOfInstancesElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    }
    List<Reference> procedureReferences = src.getProcedureReference();
    if (procedureReferences.size() > 0) {
      tgt.addProcedure().setReference(Reference30_50.convertReference(procedureReferences.get(0)));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getProcedureCode()) {
      tgt.addProcedure().setConcept(CodeableConcept30_50.convertCodeableConcept(t));
    }
    if (src.hasReason()) {
      if (src.hasReason())
        tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(src.getReason()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    }
    for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) {
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasUid()) {
      if (src.hasUid())
        tgt.setUid(src.getUid());
    }
    if (src.hasNumber()) {
      if (src.hasNumberElement())
        tgt.setNumberElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberElement()));
    }
    if (src.hasModality()) {
      if (src.hasModality())
        tgt.setModality(Coding30_50.convertCoding(src.getModality()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    }
    if (src.hasNumberOfInstances()) {
      if (src.hasNumberOfInstancesElement())
        tgt.setNumberOfInstancesElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) {
      tgt.addEndpoint(Reference30_50.convertReference(t));
    }
    if (src.getBodySite().hasConcept()) {
        tgt.setBodySite(Coding30_50.convertCoding(src.getBodySite().getConcept().getCodingFirstRep()));
    }
    if (src.hasLaterality()) {
      if (src.hasLaterality())
        tgt.setLaterality(Coding30_50.convertCoding(src.getLaterality()));
    }
    if (src.hasStarted()) {
      if (src.hasStartedElement())
        tgt.setStartedElement(DateTime30_50.convertDateTime(src.getStartedElement()));
    }
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) {
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasUid()) {
      if (src.hasUid())
        tgt.setUid(src.getUid());
    }
    if (src.hasNumber()) {
      if (src.hasNumberElement())
        tgt.setNumberElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberElement()));
    }
    if (src.hasModality()) {
      if (src.hasModality())
        tgt.setModality(new CodeableConcept().addCoding(Coding30_50.convertCoding(src.getModality())));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    }
    if (src.hasNumberOfInstances()) {
      if (src.hasNumberOfInstancesElement())
        tgt.setNumberOfInstancesElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) {
      tgt.addEndpoint(Reference30_50.convertReference(t));
    }
    if (src.hasBodySite()) {
      if (src.hasBodySite())
        tgt.setBodySite(new CodeableReference(new CodeableConcept(Coding30_50.convertCoding(src.getBodySite()))));
    }
    if (src.hasLaterality()) {
      if (src.hasLaterality())
        tgt.setLaterality(new CodeableConcept(Coding30_50.convertCoding(src.getLaterality())));
    }
    if (src.hasStarted()) {
      if (src.hasStartedElement())
        tgt.setStartedElement(DateTime30_50.convertDateTime(src.getStartedElement()));
    }
    for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) {
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasUid()) {
      if (src.hasUid())
        tgt.setUid(src.getUid());
    }
    org.hl7.fhir.r5.model.Coding sop = src.getSopClass();
    if (URN_IETF_RFC_3986.equals(sop.getSystem())) {
      tgt.setSopClass(sop.getCode());
    }
    if (src.hasNumber()) {
      if (src.hasNumberElement())
        tgt.setNumberElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberElement()));
    }
    if (src.hasTitle()) {
      if (src.hasTitleElement())
        tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasUid()) {
      if (src.hasUid())
        tgt.setUid(src.getUid());
    }
    if (src.hasSopClass()) {
      org.hl7.fhir.r5.model.Coding c = new org.hl7.fhir.r5.model.Coding();
      c.setSystem(URN_IETF_RFC_3986);
      c.setCode(src.getSopClass());
      tgt.setSopClass(c);
    }
    if (src.hasNumber()) {
      if (src.hasNumberElement())
        tgt.setNumberElement(UnsignedInt30_50.convertUnsignedInt(src.getNumberElement()));
    }
    if (src.hasTitle()) {
      if (src.hasTitleElement())
        tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    }
    return tgt;
  }
}