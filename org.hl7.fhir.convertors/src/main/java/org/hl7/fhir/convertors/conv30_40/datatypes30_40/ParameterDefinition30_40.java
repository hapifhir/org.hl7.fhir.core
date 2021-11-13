package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Integer30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class ParameterDefinition30_40 {
  public static org.hl7.fhir.r4.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.dstu3.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ParameterDefinition tgt = new org.hl7.fhir.r4.model.ParameterDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code30_40.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer30_40.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_40.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String30_40.convertString(src.getDocumentationElement()));
    if (src.hasType()) tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    if (src.hasProfile()) {
      tgt.setProfile(Reference30_40.convertReference(src.getProfile()).getReference());
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r4.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ParameterDefinition tgt = new org.hl7.fhir.dstu3.model.ParameterDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code30_40.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer30_40.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_40.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String30_40.convertString(src.getDocumentationElement()));
    if (src.hasType()) tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    if (src.hasProfile()) tgt.setProfile(new org.hl7.fhir.dstu3.model.Reference(src.getProfile()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ParameterDefinition.ParameterUseEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.NULL);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ParameterDefinition.ParameterUseEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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
