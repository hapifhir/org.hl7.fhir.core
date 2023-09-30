package org.hl7.fhir.validation.instance.utils;

import java.util.Comparator;

import org.hl7.fhir.r5.model.CanonicalType;

public class CanonicalTypeSorter implements Comparator<CanonicalType> {

  @Override
  public int compare(CanonicalType o1, CanonicalType o2) {
    return o1.getValue().compareTo(o2.getValue());
  }

}