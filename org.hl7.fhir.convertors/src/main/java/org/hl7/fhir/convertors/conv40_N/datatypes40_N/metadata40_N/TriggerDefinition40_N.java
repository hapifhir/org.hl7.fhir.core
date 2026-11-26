package org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.TriggerDefinition;

public class TriggerDefinition40_N {
  public static org.hl7.fhir.model.core.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r4.model.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.TriggerDefinition tgt = new org.hl7.fhir.model.core.TriggerDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, CrossVersionElements40_N.urls("TriggerDefinition", "5.0", new String[] {"code", "subscriptionTopic"}, CrossVersionElements40_N.urls("TriggerDefinition", "6.0", new String[] {})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "code", "subscriptionTopic");
    if (src.hasType()) tgt.setTypeElement(CrossVersionElements40_N.toR6Code(src.getTypeElement(), convertTriggerType(src.getTypeElement()), src.fhirType(), "type"));
    if (src.hasName()) tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    // R4 and R6 allow different types
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), "TriggerDefinition", "timing", tgt, tgt.getExtension());
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getData())
      tgt.addData(DataRequirement40_N.convertDataRequirement(t));
    if (src.hasCondition()) tgt.setCondition(Expression40_N.convertExpression(src.getCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.model.core.TriggerDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TriggerDefinition tgt = new org.hl7.fhir.r4.model.TriggerDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "code", "subscriptionTopic");
    if (src.hasType()) tgt.setTypeElement(CrossVersionElements40_N.toR4Code(src.getTypeElement(), convertTriggerType(src.getTypeElement()), src.fhirType(), "type"));
    if (src.hasName()) tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), "TriggerDefinition", "timing", tgt, tgt.getExtension());
    for (org.hl7.fhir.model.core.DataRequirement t : src.getDataList())
      tgt.addData(DataRequirement40_N.convertDataRequirement(t));
    if (src.hasCondition()) tgt.setCondition(Expression40_N.convertExpression(src.getCondition()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case NAMEDEVENT:
                    tgt.setValue(TriggerDefinition.TriggerType.NAMEDEVENT);
                    break;
                case PERIODIC:
                    tgt.setValue(TriggerDefinition.TriggerType.PERIODIC);
                    break;
                case DATACHANGED:
                    tgt.setValue(TriggerDefinition.TriggerType.DATACHANGED);
                    break;
                case DATAADDED:
                    tgt.setValue(TriggerDefinition.TriggerType.DATAADDED);
                    break;
                case DATAMODIFIED:
                    tgt.setValue(TriggerDefinition.TriggerType.DATAMODIFIED);
                    break;
                case DATAREMOVED:
                    tgt.setValue(TriggerDefinition.TriggerType.DATAREMOVED);
                    break;
                case DATAACCESSED:
                    tgt.setValue(TriggerDefinition.TriggerType.DATAACCESSED);
                    break;
                case DATAACCESSENDED:
                    tgt.setValue(TriggerDefinition.TriggerType.DATAACCESSENDED);
                    break;
                default:
                    tgt.setValue(TriggerDefinition.TriggerType.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.TriggerDefinition.TriggerType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TriggerDefinition.TriggerTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case NAMEDEVENT:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NAMEDEVENT);
                    break;
                case PERIODIC:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.PERIODIC);
                    break;
                case DATACHANGED:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATACHANGED);
                    break;
                case DATAADDED:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAADDED);
                    break;
                case DATAMODIFIED:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAMODIFIED);
                    break;
                case DATAREMOVED:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAREMOVED);
                    break;
                case DATAACCESSED:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSED);
                    break;
                case DATAACCESSENDED:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NULL);
                    break;
       }
}
    return tgt;
  }
}
