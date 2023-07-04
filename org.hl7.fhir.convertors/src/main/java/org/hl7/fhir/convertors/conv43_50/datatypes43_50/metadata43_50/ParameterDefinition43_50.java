package org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.Utilities43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ParameterDefinition43_50 {
  public static org.hl7.fhir.r5.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r4b.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ParameterDefinition tgt = new org.hl7.fhir.r5.model.ParameterDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code43_50.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer43_50.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities43_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r5.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ParameterDefinition tgt = new org.hl7.fhir.r4b.model.ParameterDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code43_50.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer43_50.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities43_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.NULL);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
