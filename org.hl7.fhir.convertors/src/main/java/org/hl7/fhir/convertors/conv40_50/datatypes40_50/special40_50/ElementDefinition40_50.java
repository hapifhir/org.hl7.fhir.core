package org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.UnsignedInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.resources40_50.Enumerations40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.MarkdownType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.UsageContext;

public class ElementDefinition40_50 {
  
  public static org.hl7.fhir.r5.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition tgt = new org.hl7.fhir.r5.model.ElementDefinition();
    BackboneElement40_50.copyBackboneElement(src, tgt, 
        VersionConvertorConstants.EXT_MUST_VALUE, 
        VersionConvertorConstants.EXT_VALUE_ALT);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition40_50::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String40_50.convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(Boolean40_50.convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel()) tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String40_50.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown40_50.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown40_50.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown40_50.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri40_50.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown40_50.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String40_50.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getPattern()));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer40_50.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.getCondition().add(Id40_50.convertId(t));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean40_50.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean40_50.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(String40_50.convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean40_50.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));

    if (src.hasExtension(VersionConvertorConstants.EXT_MUST_VALUE)) {
      tgt.setMustHaveValueElement(Boolean40_50.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(VersionConvertorConstants.EXT_MUST_VALUE).getValueAsPrimitive()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VALUE_ALT)) {
      tgt.addValueAlternative(Canonical40_50.convertCanonical((org.hl7.fhir.r4.model.CanonicalType)ext.getValue()));
    }

    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition40_50::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String40_50.convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(Boolean40_50.convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel()) tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String40_50.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown40_50.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown40_50.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown40_50.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri40_50.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown40_50.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String40_50.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getPattern()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer40_50.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r5.model.IdType t : src.getCondition()) tgt.getCondition().add(Id40_50.convertId(t));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean40_50.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean40_50.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(String40_50.convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean40_50.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    if (src.hasMustHaveValue()) {
      tgt.addExtension(VersionConvertorConstants.EXT_MUST_VALUE, Boolean40_50.convertBoolean(src.getMustHaveValueElement()));
    }
    for (org.hl7.fhir.r5.model.CanonicalType ct : src.getValueAlternatives()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VALUE_ALT, Canonical40_50.convertCanonical(ct));      
    }

    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case XMLATTR:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                    break;
                case XMLTEXT:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                    break;
                case TYPEATTR:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                    break;
                case CDATEXT:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                    break;
                case XHTML:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XHTML);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean40_50.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean40_50.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CLOSED:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.CLOSED);
                    break;
                case OPEN:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPEN);
                    break;
                case OPENATEND:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPENATEND);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case VALUE:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.VALUE);
                    break;
                case EXISTS:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.EXISTS);
                    break;
                case PATTERN:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.PATTERN);
                    break;
                case TYPE:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.TYPE);
                    break;
                case PROFILE:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.PROFILE);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_50.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCodeElement(Uri40_50.convertUri(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(Canonical40_50.convertCanonical(t));
    tgt.setAggregation(src.getAggregation().stream().map(ElementDefinition40_50::convertAggregationMode).collect(Collectors.toList()));
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCodeElement(Uri40_50.convertUri(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(Canonical40_50.convertCanonical(t));
    tgt.setAggregation(src.getAggregation().stream().map(ElementDefinition40_50::convertAggregationMode).collect(Collectors.toList()));
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CONTAINED:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.CONTAINED);
                    break;
                case REFERENCED:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.REFERENCED);
                    break;
                case BUNDLED:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.BUNDLED);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case EITHER:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.EITHER);
                    break;
                case INDEPENDENT:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                    break;
                case SPECIFIC:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasKey()) tgt.setKeyElement(Id40_50.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String40_50.convertStringToMarkdown(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String40_50.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasXpath()) {
      tgt.addExtension(new org.hl7.fhir.r5.model.Extension(org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT, new org.hl7.fhir.r5.model.StringType(src.getXpath())));
    }
    if (src.hasSource()) tgt.setSourceElement(Canonical40_50.convertCanonical(src.getSourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT);
    if (src.hasKey()) tgt.setKeyElement(Id40_50.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String40_50.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String40_50.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (org.hl7.fhir.r5.extensions.ExtensionUtilities.hasExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT)) {
      tgt.setXpath(org.hl7.fhir.r5.extensions.ExtensionUtilities.readStringExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT));
    }
    if (src.hasSource()) tgt.setSourceElement(Canonical40_50.convertCanonical(src.getSourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case ERROR:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.ERROR);
                    break;
                case WARNING:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.WARNING);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        VersionConvertorConstants.EXT_ADDITIONAL_BINDING, ExtensionDefinitions.EXT_BINDING_ADDITIONAL);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations40_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_50.convertCanonical(src.getValueSetElement()));

    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_ADDITIONAL_BINDING)) {
      tgt.addAdditional(convertAdditional(ext));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) {
      tgt.addAdditional(convertAdditional(ext));
    }
    return tgt;
  }

  private static ElementDefinitionBindingAdditionalComponent convertAdditional(Extension src) {
    if (src == null) return null;
    ElementDefinitionBindingAdditionalComponent tgt = new ElementDefinitionBindingAdditionalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, "valueSet", "purpose", "documentation", "shortDoco", "usage", "any");
    if (src.hasExtension("purpose")) {
      tgt.getPurposeElement().setValueAsString(src.getExtensionByUrl("purpose").getValue().primitiveValue());
    }
    if (src.hasExtension("valueSet")) {
      tgt.setValueSetElement(Canonical40_50.convertCanonical((CanonicalType) src.getExtensionByUrl("valueSet").getValue()));
    }
    if (src.hasExtension("documentation")) {
      tgt.setDocumentationElement(MarkDown40_50.convertMarkdown((MarkdownType) src.getExtensionByUrl("documentation").getValue()));
    }
    if (src.hasExtension("shortDoco")) {
      tgt.setShortDocoElement(String40_50.convertString((StringType) src.getExtensionByUrl("shortDoco").getValue()));
    }
    for (Extension t : src.getExtensionsByUrl("usage")) {
      tgt.addUsage(UsageContext40_50.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) t.getValue()));
    }
    if (src.hasExtension("any")) {
      tgt.setAnyElement(Boolean40_50.convertBoolean((BooleanType) src.getExtensionByUrl("any").getValue()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Extension convertAdditional(ElementDefinitionBindingAdditionalComponent src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Extension tgt = new Extension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL);
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPurpose()) {
      tgt.addExtension(new Extension("purpose", new org.hl7.fhir.r4.model.CodeType(src.getPurposeElement().primitiveValue())));
    }
    if (src.hasValueSet()) {
      tgt.addExtension(new Extension("valueSet", Canonical40_50.convertCanonical(src.getValueSetElement())));
    }
    if (src.hasDocumentation()) {
      tgt.addExtension(new Extension("documentation", MarkDown40_50.convertMarkdown(src.getDocumentationElement())));
    }
    if (src.hasShortDoco()) {
      tgt.addExtension(new Extension("shortDoco", String40_50.convertString(src.getShortDocoElement())));
    }
    for (UsageContext t : src.getUsage()) {
      tgt.addExtension(new Extension("usage", UsageContext40_50.convertUsageContext(t)));
    }
    if (src.hasAny()) {
      tgt.addExtension(new Extension("any", Boolean40_50.convertBoolean(src.getAnyElement())));
    }
    
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations40_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_50.convertCanonical(src.getValueSetElement()));
    for (ElementDefinitionBindingAdditionalComponent ab : src.getAdditional()) {
      tgt.addExtension(convertAdditional(ab));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id40_50.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String40_50.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String40_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id40_50.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String40_50.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    return tgt;
  }
}
