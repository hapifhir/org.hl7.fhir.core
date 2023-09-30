package org.hl7.fhir.validation.instance.utils;

import java.util.Comparator;

import org.hl7.fhir.r5.model.StructureDefinition;

public class StructureDefinitionSorterByUrl implements Comparator<StructureDefinition> {

  @Override
  public int compare(StructureDefinition o1, StructureDefinition o2) {
    return o1.getUrl().compareTo(o2.getUrl());
  }

}