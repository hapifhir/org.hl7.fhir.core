package org.hl7.fhir.support.archetypes;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class NodeTreeEntry {
  private final List<NodeTreeEntry> children = new ArrayList<NodeTreeEntry>();
  private String name;
  private String atCode;
  private String typeName;
  private Cardinality cardinality;
}
