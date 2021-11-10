package org.hl7.fhir.convertors.misc.searchparam;

import lombok.Data;

@Data
public class SPRelationship {
  private final String r4;
  private final String r3;
  private final String r2b;
  private final String r2;

  public String getByCode(String code) {
    if ("R4".equals(code))
      return r4;
    if ("R3".equals(code))
      return r3;
    if ("R2b".equals(code))
      return r2b;
    if ("R2".equals(code))
      return getR2();
    return null;
  }

}
