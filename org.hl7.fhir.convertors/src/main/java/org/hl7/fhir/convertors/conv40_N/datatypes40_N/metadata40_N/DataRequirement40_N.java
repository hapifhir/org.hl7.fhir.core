package org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.Utilities40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DataRequirement;

public class DataRequirement40_N {
  public static org.hl7.fhir.model.core.DataRequirement convertDataRequirement(org.hl7.fhir.r4.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement tgt = new org.hl7.fhir.model.core.DataRequirement();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) {
      Utilities40_N.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfileList().add(Canonical40_N.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSubject()));
    for (org.hl7.fhir.r4.model.StringType t : src.getMustSupport())
      tgt.getMustSupportList().add(String40_N.convertString(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt40_N.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement convertDataRequirement(org.hl7.fhir.model.core.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement tgt = new org.hl7.fhir.r4.model.DataRequirement();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) {
      Utilities40_N.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList())
      tgt.getProfile().add(Canonical40_N.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSubject()));
    for (org.hl7.fhir.model.core.StringType t : src.getMustSupportList())
      tgt.getMustSupport().add(String40_N.convertString(t));
    for (org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilterList())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilterList())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt40_N.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent t : src.getSortList())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_N.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_N.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_N.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_N.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.model.core.Coding t : src.getCodeList()) tgt.addCode(Coding40_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_N.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String40_N.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DataRequirement.SortDirection> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.DataRequirement.SortDirectionEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case ASCENDING:
                    tgt.setValue(DataRequirement.SortDirection.ASCENDING);
                    break;
                case DESCENDING:
                    tgt.setValue(DataRequirement.SortDirection.DESCENDING);
                    break;
                default:
                    tgt.setValue(DataRequirement.SortDirection.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DataRequirement.SortDirectionEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
