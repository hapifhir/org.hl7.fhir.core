package org.hl7.fhir.convertors.misc.adl;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NodeTreeEntry {
  private final List<NodeTreeEntry> children = new ArrayList<NodeTreeEntry>();
  private String name;
  private String atCode;
  private String typeName;
  private Cardinality cardinality;
}
