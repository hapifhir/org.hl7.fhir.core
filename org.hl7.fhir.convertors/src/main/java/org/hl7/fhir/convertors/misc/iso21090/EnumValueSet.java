package org.hl7.fhir.convertors.misc.iso21090;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class EnumValueSet {
  private final List<String> codes = new ArrayList<String>();
  private final Map<String, String> members = new HashMap<String, String>();
  private String name;
  private String template;
  private String system;
}
