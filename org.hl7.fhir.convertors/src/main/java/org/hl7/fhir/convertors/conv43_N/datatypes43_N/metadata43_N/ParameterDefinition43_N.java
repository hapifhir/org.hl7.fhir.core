package org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.Utilities43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.ParameterDefinition;
import org.hl7.fhir.model.core.Enumerations;

public class ParameterDefinition43_N {
  public static org.hl7.fhir.model.core.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r4b.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ParameterDefinition tgt = new org.hl7.fhir.model.core.ParameterDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code43_N.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer43_N.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities43_N.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.model.core.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ParameterDefinition tgt = new org.hl7.fhir.r4b.model.ParameterDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code43_N.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer43_N.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      tgt.setType(org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes.fromCode(src.getType().toCode()));
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical43_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
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
