package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Id30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Integer30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.UnsignedInt30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Enumerations30_50;
import org.hl7.fhir.dstu3.utils.ExtensionUtilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.MarkdownType;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.utilities.Utilities;

public class ElementDefinition30_50 {
  public static org.hl7.fhir.r5.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu3.model.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition tgt = new org.hl7.fhir.r5.model.ElementDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, VersionConvertorConstants.EXT_MUST_VALUE, VersionConvertorConstants.EXT_VALUE_ALT);
    if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition30_50::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String30_50.convertString(src.getSliceNameElement()));
    if (src.hasLabel()) tgt.setLabelElement(String30_50.convertString(src.getLabelElement()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(Coding30_50.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String30_50.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown30_50.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown30_50.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown30_50.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    if (src.hasMin()) tgt.setMinElement(UnsignedInt30_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_50.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri30_50.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent t : src.getType())
      convertTypeRefComponent(t, tgt.getType());
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown30_50.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String30_50.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getPattern()));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer30_50.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.dstu3.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean30_50.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean30_50.convertBoolean(src.getIsModifierElement()));
    if (tgt.getIsModifier()) {
      String reason = ExtensionUtilities.readStringExtension(src, VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION);
      if (Utilities.noString(reason)) reason = VersionConvertorConstants.EXT_MODIFIER_REASON_LEGACY;
      tgt.setIsModifierReason(reason);
    }
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean30_50.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(ElementDefinition30_50.convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));

    if (src.hasExtension(VersionConvertorConstants.EXT_MUST_VALUE)) {
      tgt.setMustHaveValueElement(Boolean30_50.convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src.getExtensionByUrl(VersionConvertorConstants.EXT_MUST_VALUE).getValueAsPrimitive()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VALUE_ALT)) {
      tgt.addValueAlternative(Uri30_50.convertCanonical((org.hl7.fhir.dstu3.model.UriType)ext.getValue()));
    }

    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition tgt = new org.hl7.fhir.dstu3.model.ElementDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition30_50::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String30_50.convertString(src.getSliceNameElement()));
    if (src.hasLabel()) tgt.setLabelElement(String30_50.convertString(src.getLabelElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding30_50.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String30_50.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown30_50.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown30_50.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown30_50.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    if (src.hasMin()) tgt.setMinElement(UnsignedInt30_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_50.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri30_50.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType())
      convertTypeRefComponent(t, tgt.getType());
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown30_50.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String30_50.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getPattern()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer30_50.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r5.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean30_50.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean30_50.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason() && !VersionConvertorConstants.EXT_MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
      ExtensionUtilities.setStringExtension(tgt, VersionConvertorConstants.EXT_MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean30_50.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    if (src.hasMustHaveValue()) {
      tgt.addExtension(VersionConvertorConstants.EXT_MUST_VALUE, Boolean30_50.convertBoolean(src.getMustHaveValueElement()));
    }
    for (org.hl7.fhir.r5.model.CanonicalType ct : src.getValueAlternatives()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VALUE_ALT, Uri30_50.convertCanonical(ct));      
    }

    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case XMLATTR:
                    tgt.setValue(ElementDefinition.PropertyRepresentation.XMLATTR);
                    break;
                case XMLTEXT:
                    tgt.setValue(ElementDefinition.PropertyRepresentation.XMLTEXT);
                    break;
                case TYPEATTR:
                    tgt.setValue(ElementDefinition.PropertyRepresentation.TYPEATTR);
                    break;
                case CDATEXT:
                    tgt.setValue(ElementDefinition.PropertyRepresentation.CDATEXT);
                    break;
                case XHTML:
                    tgt.setValue(ElementDefinition.PropertyRepresentation.XHTML);
                    break;
                default:
                    tgt.setValue(ElementDefinition.PropertyRepresentation.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case XMLATTR:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                    break;
                case XMLTEXT:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                    break;
                case TYPEATTR:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                    break;
                case CDATEXT:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                    break;
                case XHTML:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XHTML);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean30_50.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean30_50.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CLOSED:
                    tgt.setValue(ElementDefinition.SlicingRules.CLOSED);
                    break;
                case OPEN:
                    tgt.setValue(ElementDefinition.SlicingRules.OPEN);
                    break;
                case OPENATEND:
                    tgt.setValue(ElementDefinition.SlicingRules.OPENATEND);
                    break;
                default:
                    tgt.setValue(ElementDefinition.SlicingRules.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CLOSED:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.CLOSED);
                    break;
                case OPEN:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPEN);
                    break;
                case OPENATEND:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPENATEND);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case VALUE:
                    tgt.setValue(ElementDefinition.DiscriminatorType.VALUE);
                    break;
                case EXISTS:
                    tgt.setValue(ElementDefinition.DiscriminatorType.EXISTS);
                    break;
                case PATTERN:
                    tgt.setValue(ElementDefinition.DiscriminatorType.PATTERN);
                    break;
                case TYPE:
                    tgt.setValue(ElementDefinition.DiscriminatorType.TYPE);
                    break;
                case PROFILE:
                    tgt.setValue(ElementDefinition.DiscriminatorType.PROFILE);
                    break;
                default:
                    tgt.setValue(ElementDefinition.DiscriminatorType.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case VALUE:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.VALUE);
                    break;
                case EXISTS:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.EXISTS);
                    break;
                case PATTERN:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.PATTERN);
                    break;
                case TYPE:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.TYPE);
                    break;
                case PROFILE:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.PROFILE);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.DiscriminatorType.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt30_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String30_50.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt30_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String30_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static void convertTypeRefComponent(org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent src, List<ElementDefinition.TypeRefComponent> list) throws FHIRException {
    if (src == null) return;
    ElementDefinition.TypeRefComponent tgt = null;
    for (ElementDefinition.TypeRefComponent t : list)
      if (t.getCode().equals(src.getCode())) tgt = t;
    if (tgt == null) {
      tgt = new ElementDefinition.TypeRefComponent();
      list.add(tgt);
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      tgt.setCodeElement(Uri30_50.convertUri(src.getCodeElement()));
    }
    if (src.hasProfile()) {
      boolean found = false;
      for (CanonicalType p : tgt.getProfile()) {
        if (p.equals(src.getProfile())) found = true;
      }
      if (!found) tgt.addProfile(src.getProfile());
    }
    if (src.hasTargetProfile()) tgt.addTargetProfile(src.getTargetProfile());
    for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
      org.hl7.fhir.r5.model.Enumeration<ElementDefinition.AggregationMode> a = convertAggregationMode(t);
      if (!tgt.hasAggregation(a.getValue()))
        ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(t, tgt.addAggregation(a.getValue()));
    }
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
  }

  public static void convertTypeRefComponent(ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
    if (src == null) return;
    org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    tgt.setCodeElement(Uri30_50.convertUri(src.getCodeElement()));
    list.add(tgt);
    if (src.hasTarget()) {
      if (src.hasProfile()) tgt.setProfile(src.getProfile().get(0).getValue());
      for (org.hl7.fhir.r5.model.UriType u : src.getTargetProfile()) {
        if (tgt.hasTargetProfile()) {
          tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
          list.add(tgt);
          ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
          tgt.setCode(src.getCode());
          if (src.hasProfile()) tgt.setProfile(src.getProfile().get(0).getValue());
        }
        tgt.setTargetProfile(u.getValue());
      }
    } else {
      for (org.hl7.fhir.r5.model.UriType u : src.getProfile()) {
        if (tgt.hasProfile()) {
          tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
          list.add(tgt);
          ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
          tgt.setCode(src.getCode());
        }
        tgt.setProfile(u.getValue());
      }
    }
    for (org.hl7.fhir.r5.model.Enumeration<ElementDefinition.AggregationMode> t : src.getAggregation()) {
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
      if (!tgt.hasAggregation(a.getValue()))
        ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(t, tgt.addAggregation(a.getValue()));
    }
  }

  static public org.hl7.fhir.r5.model.Enumeration<ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new ElementDefinition.AggregationModeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CONTAINED:
                    tgt.setValue(ElementDefinition.AggregationMode.CONTAINED);
                    break;
                case REFERENCED:
                    tgt.setValue(ElementDefinition.AggregationMode.REFERENCED);
                    break;
                case BUNDLED:
                    tgt.setValue(ElementDefinition.AggregationMode.BUNDLED);
                    break;
                default:
                    tgt.setValue(ElementDefinition.AggregationMode.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r5.model.Enumeration<ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CONTAINED:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.CONTAINED);
                    break;
                case REFERENCED:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.REFERENCED);
                    break;
                case BUNDLED:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.BUNDLED);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case EITHER:
                    tgt.setValue(ElementDefinition.ReferenceVersionRules.EITHER);
                    break;
                case INDEPENDENT:
                    tgt.setValue(ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                    break;
                case SPECIFIC:
                    tgt.setValue(ElementDefinition.ReferenceVersionRules.SPECIFIC);
                    break;
                default:
                    tgt.setValue(ElementDefinition.ReferenceVersionRules.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r5.model.Enumeration<ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case EITHER:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.EITHER);
                    break;
                case INDEPENDENT:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                    break;
                case SPECIFIC:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ReferenceVersionRules.NULL);
                    break;
       }
}
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    ElementDefinition.ElementDefinitionExampleComponent tgt = new ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String30_50.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String30_50.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    ElementDefinition.ElementDefinitionConstraintComponent tgt = new ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasKey()) tgt.setKeyElement(Id30_50.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String30_50.convertStringToMarkdown(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String30_50.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String30_50.convertString(src.getExpressionElement()));
    if (src.hasXpath()) {
      tgt.addExtension(new org.hl7.fhir.r5.model.Extension(org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT, new org.hl7.fhir.r5.model.StringType(src.getXpath())));
    }
    if (src.hasSource()) tgt.setSource(src.getSource());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT);
    if (src.hasKey()) tgt.setKeyElement(Id30_50.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String30_50.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String30_50.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String30_50.convertString(src.getExpressionElement()));
    if (org.hl7.fhir.r5.extensions.ExtensionUtilities.hasExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT)) {
      tgt.setXpath(org.hl7.fhir.r5.extensions.ExtensionUtilities.readStringExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT));
    }
    if (src.hasSource()) tgt.setSource(src.getSource());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case ERROR:
                    tgt.setValue(ElementDefinition.ConstraintSeverity.ERROR);
                    break;
                case WARNING:
                    tgt.setValue(ElementDefinition.ConstraintSeverity.WARNING);
                    break;
                default:
                    tgt.setValue(ElementDefinition.ConstraintSeverity.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r5.model.Enumeration<ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case ERROR:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.ERROR);
                    break;
                case WARNING:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.WARNING);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, VersionConvertor_30_50.EXT_SRC_TYPE);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations30_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) {
      org.hl7.fhir.r5.model.Extension ex = src.getValueSetElement().getExtensionByUrl(VersionConvertor_30_50.EXT_SRC_TYPE);
      String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
      if (ex != null) {
        if ("uri".equals(ex.getValue().primitiveValue())) {
          tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr == null ? src.getValueSet() : vsr));
        } else {
          tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
        }
      } else {
        if (vsr != null) tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
        else tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
      }
    }
    for (ElementDefinitionBindingAdditionalComponent ab : src.getAdditional()) {
      tgt.addExtension(convertAdditional(ab));
    }
    return tgt;
  }


  public static ElementDefinitionBindingAdditionalComponent convertAdditional(Extension src) {
    if (src == null) return null;
    ElementDefinitionBindingAdditionalComponent tgt = new ElementDefinitionBindingAdditionalComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, "valueSet", "purpose", "documentation", "shortDoco", "usage", "any");
    if (src.hasExtension("purpose")) {
      tgt.getPurposeElement().setValueAsString(src.getExtensionByUrl("purpose").getValue().primitiveValue());
    }
    if (src.hasExtension("valueSet")) {
      tgt.setValueSetElement(Uri30_50.convertCanonical((UriType) src.getExtensionByUrl("valueSet").getValue()));
    }
    if (src.hasExtension("documentation")) {
      tgt.setDocumentationElement(MarkDown30_50.convertMarkdown((MarkdownType) src.getExtensionByUrl("documentation").getValue()));
    }
    if (src.hasExtension("shortDoco")) {
      tgt.setShortDocoElement(String30_50.convertString((StringType) src.getExtensionByUrl("shortDoco").getValue()));
    }
    for (Extension t : src.getExtensionsByUrl("usage")) {
      tgt.addUsage(UsageContext30_50.convertUsageContext((org.hl7.fhir.dstu3.model.UsageContext) t.getValue()));
    }
    if (src.hasExtension("any")) {
      tgt.setAnyElement(Boolean30_50.convertBoolean((BooleanType) src.getExtensionByUrl("any").getValue()));
    }
    return tgt;
  }

  private static Extension convertAdditional(ElementDefinitionBindingAdditionalComponent src) {
    if (src == null) return null;
    Extension tgt = new Extension();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasPurpose()) {
      tgt.addExtension(new Extension("purpose", new org.hl7.fhir.dstu3.model.CodeType(src.getPurposeElement().primitiveValue())));
    }
    if (src.hasValueSet()) {
      tgt.addExtension(new Extension("valueSet", Uri30_50.convertCanonical(src.getValueSetElement())));
    }
    if (src.hasDocumentation()) {
      tgt.addExtension(new Extension("documentation", MarkDown30_50.convertMarkdown(src.getDocumentationElement())));
    }
    if (src.hasShortDoco()) {
      tgt.addExtension(new Extension("shortDoco", String30_50.convertString(src.getShortDocoElement())));
    }
    for (UsageContext t : src.getUsage()) {
      tgt.addExtension(new Extension("usage", UsageContext30_50.convertUsageContext(t)));
    }
    if (src.hasAny()) {
      tgt.addExtension(new Extension("any", Boolean30_50.convertBoolean(src.getAnyElement())));
    }
    
    return tgt;
  }
  
  public static ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    ElementDefinition.ElementDefinitionMappingComponent tgt = new ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id30_50.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String30_50.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String30_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id30_50.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String30_50.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    ElementDefinition.ElementDefinitionBindingComponent tgt = new ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, VersionConvertor_30_50.EXT_SRC_TYPE, 
        VersionConvertorConstants.EXT_ADDITIONAL_BINDING);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations30_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasValueSet()) {
      DataType t = ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValueSet());
      if (t instanceof org.hl7.fhir.r5.model.Reference) {
        tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
        tgt.getValueSetElement().addExtension(VersionConvertor_30_50.EXT_SRC_TYPE, new org.hl7.fhir.r5.model.UrlType("Reference"));
      } else {
        tgt.setValueSet(t.primitiveValue());
        tgt.getValueSetElement().addExtension(VersionConvertor_30_50.EXT_SRC_TYPE, new org.hl7.fhir.r5.model.UrlType("uri"));
      }
      tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
    }
    for (org.hl7.fhir.dstu3.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_ADDITIONAL_BINDING)) {
      tgt.addAdditional(convertAdditional(ext));
    }
    return tgt;
  }
}
