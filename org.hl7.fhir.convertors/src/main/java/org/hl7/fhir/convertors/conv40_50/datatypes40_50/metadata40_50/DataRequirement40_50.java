package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DataRequirement40_50 {
  public static org.hl7.fhir.r5.model.DataRequirement convertDataRequirement(org.hl7.fhir.r4.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement tgt = new org.hl7.fhir.r5.model.DataRequirement();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.fromCode(convertResourceName4to5(src.getType())));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_50.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSubject()));
    for (org.hl7.fhir.r4.model.StringType t : src.getMustSupport())
      tgt.getMustSupport().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt40_50.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement convertDataRequirement(org.hl7.fhir.r5.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement tgt = new org.hl7.fhir.r4.model.DataRequirement();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(convertResourceName5to4(src.getType().toCode()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_50.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSubject()));
    for (org.hl7.fhir.r5.model.StringType t : src.getMustSupport())
      tgt.getMustSupport().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt40_50.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  private static String convertResourceName4to5(String name) {
    if (name == null) return null;
    if (name.equals("DeviceUseStatement")) {
      return "DeviceUsage";
    }
    return name;
  }

  private static String convertResourceName5to4(String name) {
    if (name == null) return null;
    if (name.equals("DeviceUsage")) {
      return "DeviceUseStatement";
    }
    return name;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_50.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_50.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_50.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_50.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_50.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_50.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DataRequirement.SortDirectionEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.NULL);
    } else {
      switch (src.getValue()) {
        case ASCENDING:
          tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.ASCENDING);
          break;
        case DESCENDING:
          tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.DESCENDING);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DataRequirement.SortDirectionEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.NULL);
    } else {
      switch (src.getValue()) {
        case ASCENDING:
          tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.ASCENDING);
          break;
        case DESCENDING:
          tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.DESCENDING);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.NULL);
          break;
      }
    }
    return tgt;
  }
}
