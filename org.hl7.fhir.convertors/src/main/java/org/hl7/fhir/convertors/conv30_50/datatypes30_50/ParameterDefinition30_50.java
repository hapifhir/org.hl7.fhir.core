package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Integer30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ParameterDefinition30_50 {
  public static org.hl7.fhir.r5.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.dstu3.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ParameterDefinition tgt = new org.hl7.fhir.r5.model.ParameterDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code30_50.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer30_50.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String30_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) tgt.setType(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.fromCode(src.getType()));
    if (src.hasProfile()) {
      tgt.setProfile(Reference30_50.convertReference(src.getProfile()).getReference());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r5.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ParameterDefinition tgt = new org.hl7.fhir.dstu3.model.ParameterDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code30_50.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer30_50.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String30_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) tgt.setType(src.getType().toCode());
    if (src.hasProfile()) tgt.setProfile(new org.hl7.fhir.dstu3.model.Reference(src.getProfile()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUseEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.NULL);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
