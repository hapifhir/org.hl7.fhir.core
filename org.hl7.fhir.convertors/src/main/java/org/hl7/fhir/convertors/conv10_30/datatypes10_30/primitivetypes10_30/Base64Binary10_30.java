package org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Base64Binary10_30 {
    public static org.hl7.fhir.dstu3.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2.model.Base64BinaryType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu3.model.Base64BinaryType();
      Element10_30.copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu3.model.Base64BinaryType src) throws FHIRException {
      org.hl7.fhir.dstu2.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu2.model.Base64BinaryType();
      Element10_30.copyElement(src, tgt);
      return tgt;
    }
}
