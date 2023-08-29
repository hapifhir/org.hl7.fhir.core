package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.Utilities43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DataRequirement43_50 {
  public static org.hl7.fhir.r5.model.DataRequirement convertDataRequirement(org.hl7.fhir.r4b.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement tgt = new org.hl7.fhir.r5.model.DataRequirement();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) {
      Utilities43_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical43_50.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSubject()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getMustSupport())
      tgt.getMustSupport().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt43_50.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement convertDataRequirement(org.hl7.fhir.r5.model.DataRequirement src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement tgt = new org.hl7.fhir.r4b.model.DataRequirement();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) {
      Utilities43_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical43_50.convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSubject()));
    for (org.hl7.fhir.r5.model.StringType t : src.getMustSupport())
      tgt.getMustSupport().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit()) tgt.setLimitElement(PositiveInt43_50.convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_50.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical43_50.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getCode()) tgt.addCode(Coding43_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r4b.model.DataRequirement.DataRequirementCodeFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_50.convertString(src.getSearchParamElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical43_50.convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding43_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_50.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r4b.model.DataRequirement.DataRequirementDateFilterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasSearchParam()) tgt.setSearchParamElement(String43_50.convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r4b.model.DataRequirement.DataRequirementSortComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DataRequirement.SortDirectionEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.DataRequirement.SortDirectionEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.DataRequirement.SortDirection.NULL);
    } else {
      switch (src.getValue()) {
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
