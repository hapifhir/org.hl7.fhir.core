package org.hl7.fhir.convertors.igs;

import org.hl7.fhir.r5.model.Resource;

public class VersionConvertorIGBase {

  public boolean handlesR5ToR5(String s) {
    return false;
  }

  public Resource convertR5ToR5(Resource source) {
    return source;
  }


  public boolean handlesR5ToR4(String s) {
    return false;
  }

  public org.hl7.fhir.r4.model.Resource convertR5ToR4(Resource source) {
    return null;
  }
}
