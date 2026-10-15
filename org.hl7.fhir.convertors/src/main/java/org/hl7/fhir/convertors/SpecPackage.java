package org.hl7.fhir.convertors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.ValueSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecPackage {
  private List<ValueSet> valuesets = new ArrayList<ValueSet>();
  private List<ValueSet> expansions = new ArrayList<ValueSet>();
  private Map<String, StructureDefinition> types = new HashMap<String, StructureDefinition>();
  private Map<String, StructureDefinition> resources = new HashMap<String, StructureDefinition>();
  private Map<String, StructureDefinition> extensions = new HashMap<String, StructureDefinition>();
  private Map<String, StructureDefinition> profiles = new HashMap<String, StructureDefinition>();
}
