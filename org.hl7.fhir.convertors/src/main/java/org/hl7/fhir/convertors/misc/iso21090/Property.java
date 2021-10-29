package org.hl7.fhir.convertors.misc.iso21090;

import lombok.Data;

@Data
class Property {
  private boolean isattr;
  private String name;
  private int min;
  private int max;
  private String type;
  private String doco;
  private String binding;
}
