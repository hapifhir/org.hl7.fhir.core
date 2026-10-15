package org.hl7.fhir.convertors.igs;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;

public class VersionConvertorIGBase {

  public boolean handlesR5ToR5(String s) {
    return false;
  }

  public org.hl7.fhir.r5.model.Resource convertR5ToR5(org.hl7.fhir.r5.model.Resource source) {
    return source;
  }

  public boolean handlesRNToR5(String s) {
    return false;
  }

  public org.hl7.fhir.r5.model.Resource convertRNToR5(org.hl7.fhir.model.core.Resource source) {
    return VersionConvertorFactory_50_N.convertResource(source);
  }


  public boolean handlesR5ToR4(String s) {
    return false;
  }

  public org.hl7.fhir.r4.model.Resource convertR5ToR4(org.hl7.fhir.r5.model.Resource source) {
    return null;
  }


  public boolean handlesRNToR4(String s) {
    return false;
  }

  public org.hl7.fhir.r4.model.Resource convertRNToR4(org.hl7.fhir.model.core.Resource source) {
    return null;
  }
}
