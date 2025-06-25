package org.hl7.fhir.validation.instance.utils;

import java.util.Comparator;

import org.hl7.fhir.r5.model.StructureDefinition;

public class StructureDefinitionSorterByUrl implements Comparator<StructureDefinition> {

  @Override
  public int compare(StructureDefinition o1, StructureDefinition o2) {
    if (o1.getUrl().equals(o2.getUrl())) {
      return o1.getVersion().compareTo(o2.getVersion());      
    } else {
      return o1.getUrl().compareTo(o2.getUrl());
    }
  }

}