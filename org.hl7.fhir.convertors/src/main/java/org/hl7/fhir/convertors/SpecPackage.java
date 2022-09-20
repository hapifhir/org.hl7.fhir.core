package org.hl7.fhir.convertors;

import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecPackage {
  private Map<String, ValueSet> valuesets = new HashMap<String, ValueSet>();
  private Map<String, ValueSet> expansions = new HashMap<String, ValueSet>();
  private Map<String, StructureDefinition> types = new HashMap<String, StructureDefinition>();
  private Map<String, StructureDefinition> resources = new HashMap<String, StructureDefinition>();
  private Map<String, StructureDefinition> extensions = new HashMap<String, StructureDefinition>();
  private Map<String, StructureDefinition> profiles = new HashMap<String, StructureDefinition>();
}
