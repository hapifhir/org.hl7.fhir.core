package org.hl7.fhir.convertors.misc.iso21090;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class DataType {
  private final List<Property> properties = new ArrayList<Property>();
  private boolean isAbstract;
  private String name;
  private String doco;
  private String parent;
}
