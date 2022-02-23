package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Coding10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Oid10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.UnsignedInt10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImagingStudy10_30 {

  public static org.hl7.fhir.dstu3.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu2.model.ImagingStudy src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImagingStudy tgt = new org.hl7.fhir.dstu3.model.ImagingStudy();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasUidElement())
      tgt.setUidElement(Oid10_30.convertOid(src.getUidElement()));
    if (src.hasAccession())
      tgt.setAccession(Identifier10_30.convertIdentifier(src.getAccession()));
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasAvailability())
      tgt.setAvailabilityElement(convertInstanceAvailability(src.getAvailabilityElement()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getModalityList()) tgt.addModalityList(Coding10_30.convertCoding(t));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasStartedElement())
      tgt.setStartedElement(DateTime10_30.convertDateTime(src.getStartedElement()));
    if (src.hasReferrer())
      tgt.setReferrer(Reference10_30.convertReference(src.getReferrer()));
    if (src.hasInterpreter())
      tgt.addInterpreter(Reference10_30.convertReference(src.getInterpreter()));
    if (src.hasNumberOfSeriesElement())
      tgt.setNumberOfSeriesElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstancesElement())
      tgt.setNumberOfInstancesElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getProcedure())
      tgt.addProcedureReference(Reference10_30.convertReference(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu3.model.ImagingStudy src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImagingStudy tgt = new org.hl7.fhir.dstu2.model.ImagingStudy();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasUidElement())
      tgt.setUidElement(Oid10_30.convertOid(src.getUidElement()));
    if (src.hasAccession())
      tgt.setAccession(Identifier10_30.convertIdentifier(src.getAccession()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasAvailability())
      tgt.setAvailabilityElement(convertInstanceAvailability(src.getAvailabilityElement()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getModalityList()) tgt.addModalityList(Coding10_30.convertCoding(t));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasStartedElement())
      tgt.setStartedElement(DateTime10_30.convertDateTime(src.getStartedElement()));
    if (src.hasReferrer())
      tgt.setReferrer(Reference10_30.convertReference(src.getReferrer()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getInterpreter())
      tgt.setInterpreter(Reference10_30.convertReference(t));
    if (src.hasNumberOfSeriesElement())
      tgt.setNumberOfSeriesElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstancesElement())
      tgt.setNumberOfInstancesElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getProcedureReference())
      tgt.addProcedure(Reference10_30.convertReference(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasUidElement())
      tgt.setUidElement(Oid10_30.convertOid(src.getUidElement()));
    if (src.hasNumberElement())
      tgt.setNumberElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(Coding10_30.convertCoding(src.getModality()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstancesElement())
      tgt.setNumberOfInstancesElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberOfInstancesElement()));
    if (src.hasAvailability())
      tgt.setAvailabilityElement(convertInstanceAvailability(src.getAvailabilityElement()));
    if (src.hasBodySite())
      tgt.setBodySite(Coding10_30.convertCoding(src.getBodySite()));
    if (src.hasLaterality())
      tgt.setLaterality(Coding10_30.convertCoding(src.getLaterality()));
    if (src.hasStartedElement())
      tgt.setStartedElement(DateTime10_30.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasUidElement())
      tgt.setUidElement(Oid10_30.convertOid(src.getUidElement()));
    if (src.hasNumberElement())
      tgt.setNumberElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(Coding10_30.convertCoding(src.getModality()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstancesElement())
      tgt.setNumberOfInstancesElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberOfInstancesElement()));
    if (src.hasAvailability())
      tgt.setAvailabilityElement(convertInstanceAvailability(src.getAvailabilityElement()));
    if (src.hasBodySite())
      tgt.setBodySite(Coding10_30.convertCoding(src.getBodySite()));
    if (src.hasLaterality())
      tgt.setLaterality(Coding10_30.convertCoding(src.getLaterality()));
    if (src.hasStartedElement())
      tgt.setStartedElement(DateTime10_30.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasUidElement())
      tgt.setUidElement(Oid10_30.convertOid(src.getUidElement()));
    if (src.hasNumberElement())
      tgt.setNumberElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberElement()));
    if (src.hasSopClassElement())
      tgt.setSopClassElement(Oid10_30.convertOid(src.getSopClassElement()));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasUidElement())
      tgt.setUidElement(Oid10_30.convertOid(src.getUidElement()));
    if (src.hasNumberElement())
      tgt.setNumberElement(UnsignedInt10_30.convertUnsignedInt(src.getNumberElement()));
    if (src.hasSopClassElement())
      tgt.setSopClassElement(Oid10_30.convertOid(src.getSopClassElement()));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability> convertInstanceAvailability(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailabilityEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ONLINE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.ONLINE);
        break;
      case OFFLINE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.OFFLINE);
        break;
      case NEARLINE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.NEARLINE);
        break;
      case UNAVAILABLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.UNAVAILABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability> convertInstanceAvailability(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailabilityEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ONLINE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.ONLINE);
        break;
      case OFFLINE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.OFFLINE);
        break;
      case NEARLINE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.NEARLINE);
        break;
      case UNAVAILABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.UNAVAILABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.NULL);
        break;
    }
    return tgt;
  }
}