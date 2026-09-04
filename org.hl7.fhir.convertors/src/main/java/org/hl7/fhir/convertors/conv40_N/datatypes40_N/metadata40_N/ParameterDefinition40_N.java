package org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.Utilities40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ParameterDefinition;
import org.hl7.fhir.model.core.Enumerations;

public class ParameterDefinition40_N {
  public static org.hl7.fhir.model.core.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r4.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ParameterDefinition tgt = new org.hl7.fhir.model.core.ParameterDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code40_N.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer40_N.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities40_N.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.model.core.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ParameterDefinition tgt = new org.hl7.fhir.r4.model.ParameterDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code40_N.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer40_N.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities40_N.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case IN:
                    tgt.setValue(Enumerations.OperationParameterUse.IN);
                    break;
                case OUT:
                    tgt.setValue(Enumerations.OperationParameterUse.OUT);
                    break;
                default:
                    tgt.setValue(Enumerations.OperationParameterUse.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ParameterDefinition.ParameterUseEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case IN:
                    tgt.setValue(ParameterDefinition.ParameterUse.IN);
                    break;
                case OUT:
                    tgt.setValue(ParameterDefinition.ParameterUse.OUT);
                    break;
                default:
                    tgt.setValue(ParameterDefinition.ParameterUse.NULL);
                    break;
       }
}
    return tgt;
  }
}
