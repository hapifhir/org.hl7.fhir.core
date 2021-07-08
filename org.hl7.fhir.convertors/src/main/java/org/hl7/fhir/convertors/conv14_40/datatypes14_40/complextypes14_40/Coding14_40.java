package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Boolean14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Coding14_40 {
    public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu2016may.model.Coding src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
      Element14_40.copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
      if (src.hasVersion()) tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
      if (src.hasDisplay()) tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
      if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean14_40.convertBoolean(src.getUserSelectedElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Coding tgt = new org.hl7.fhir.dstu2016may.model.Coding();
      Element14_40.copyElement(src, tgt);
      if (src.hasSystem()) tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
      if (src.hasVersion()) tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
      if (src.hasCode()) tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
      if (src.hasDisplay()) tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
      if (src.hasUserSelected()) tgt.setUserSelectedElement(Boolean14_40.convertBoolean(src.getUserSelectedElement()));
      return tgt;
    }
}
