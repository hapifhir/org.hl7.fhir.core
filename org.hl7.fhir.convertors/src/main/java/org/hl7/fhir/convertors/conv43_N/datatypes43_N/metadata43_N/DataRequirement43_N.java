package org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.Utilities43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DataRequirement;
import org.hl7.fhir.r4b.model.Enumerations;

public class DataRequirement43_N {
  public static org.hl7.fhir.model.core.DataRequirement convertDataRequirement(org.hl7.fhir.r4b.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement tgt = new org.hl7.fhir.model.core.DataRequirement();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) {
      Utilities43_N.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getProfile())
      tgt.getProfileList().add(Canonical43_N.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getMustSupport())
      tgt.getMustSupportList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt43_N.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement convertDataRequirement(org.hl7.fhir.model.core.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement tgt = new org.hl7.fhir.r4b.model.DataRequirement();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) {
      tgt.setType(Enumerations.FHIRAllTypes.fromCode(src.getType().toCode()));
    }
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList())
      tgt.getProfile().add(Canonical43_N.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    for (org.hl7.fhir.model.core.StringType t : src.getMustSupportList())
      tgt.getMustSupport().add(String43_N.convertString(t));
    for (org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilterList())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilterList())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt43_N.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent t : src.getSortList())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_N.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getCode()) tgt.addCode(Coding43_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.model.core.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_N.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.model.core.Coding t : src.getCodeList()) tgt.addCode(Coding43_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_N.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.model.core.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_N.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.model.core.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DataRequirement.SortDirection> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.DataRequirement.SortDirectionEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.DataRequirement.SortDirectionEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case ASCENDING:
                    tgt.setValue(org.hl7.fhir.r4b.model.DataRequirement.SortDirection.ASCENDING);
                    break;
                case DESCENDING:
                    tgt.setValue(org.hl7.fhir.r4b.model.DataRequirement.SortDirection.DESCENDING);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.DataRequirement.SortDirection.NULL);
                    break;
       }
}
    return tgt;
  }
}
