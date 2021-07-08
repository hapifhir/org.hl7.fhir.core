package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary30_40 {
    public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu3.model.Base64BinaryType src) throws FHIRException {
      org.hl7.fhir.r4.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r4.model.Base64BinaryType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu3.model.Base64BinaryType();
      Element30_40.copyElement(src, tgt);
      return tgt;
    }
}
