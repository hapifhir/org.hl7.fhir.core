package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.BackboneElement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.resources40_N.Enumerations40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.MarkdownType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.model.core.UsageContext;

public class ElementDefinition40_N {
  
  public static org.hl7.fhir.model.core.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition tgt = new org.hl7.fhir.model.core.ElementDefinition();
    BackboneElement40_N.copyBackboneElement(src, tgt, 
        VersionConvertorConstants.EXT_MUST_VALUE, 
        VersionConvertorConstants.EXT_VALUE_ALT);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    tgt.setRepresentationList(src.getRepresentation().stream().map(ElementDefinition40_N::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String40_N.convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(Boolean40_N.convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel()) tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_N.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String40_N.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown40_N.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown40_N.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown40_N.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAliasList().add(String40_N.convertString(t));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri40_N.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown40_N.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String40_N.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getPattern()));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer40_N.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.getConditionList().add(Id40_N.convertId(t));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean40_N.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean40_N.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(String40_N.convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean40_N.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));

    if (src.hasExtension(VersionConvertorConstants.EXT_MUST_VALUE)) {
      tgt.setMustHaveValueElement(Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(VersionConvertorConstants.EXT_MUST_VALUE).getValueAsPrimitive()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VALUE_ALT)) {
      tgt.getValueAlternativesList().add(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) ext.getValue()));
    }

    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.model.core.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentationList().stream().map(ElementDefinition40_N::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String40_N.convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(Boolean40_N.convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel()) tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    for (org.hl7.fhir.model.core.Coding t : src.getCodeList()) tgt.addCode(Coding40_N.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String40_N.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown40_N.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown40_N.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown40_N.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAliasList()) tgt.getAlias().add(String40_N.convertString(t));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri40_N.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent t : src.getTypeList())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown40_N.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String40_N.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getPattern()));
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent t : src.getExampleList())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer40_N.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.model.core.IdType t : src.getConditionList()) tgt.getCondition().add(Id40_N.convertId(t));
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraintList())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean40_N.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean40_N.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(String40_N.convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean40_N.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent t : src.getMappingList())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    if (src.hasMustHaveValue()) {
      tgt.addExtension(VersionConvertorConstants.EXT_MUST_VALUE, Boolean40_N.convertBoolean(src.getMustHaveValueElement()));
    }
    for (org.hl7.fhir.model.core.CanonicalType ct : src.getValueAlternativesList()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VALUE_ALT, Canonical40_N.convertCanonical(ct));      
    }

    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean40_N.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminatorList())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean40_N.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE);
    if (src.hasExtension(VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE)) {
      tgt.setValue(org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE)));
    } else if (src.getValue() == null) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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
                case POSITION:
                    // 'position' was introduced in R5: park it on the 5.0 inter-version extension. 
                    // discriminator.type is mandatory, so the containing resource converter is 
                    // responsible for marking implicitRules - see StructureDefinition40_N
                    tgt.addExtension(VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE, new org.hl7.fhir.r4.model.CodeType("position"));
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt40_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCodeElement(Uri40_N.convertUri(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfileList().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfileList().add(Canonical40_N.convertCanonical(t));
    tgt.setAggregationList(src.getAggregation().stream().map(ElementDefinition40_N::convertAggregationMode).collect(Collectors.toList()));
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCodeElement(Uri40_N.convertUri(src.getCodeElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList())
      tgt.getProfile().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getTargetProfileList())
      tgt.getTargetProfile().add(Canonical40_N.convertCanonical(t));
    tgt.setAggregation(src.getAggregationList().stream().map(ElementDefinition40_N::convertAggregationMode).collect(Collectors.toList()));
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS);
    if (src.hasKey()) tgt.setKeyElement(Id40_N.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String40_N.convertStringToMarkdown(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String40_N.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_N.convertString(src.getExpressionElement()));
    if (src.hasXpath()) {
      tgt.addExtension(new org.hl7.fhir.model.core.Extension(org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT, new org.hl7.fhir.model.core.StringType(src.getXpath())));
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS)) {
      tgt.setSuppressElement(Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS).getValueAsPrimitive()));
    }
    if (src.hasSource()) tgt.setSourceElement(Canonical40_N.convertCanonical(src.getSourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT);
    if (src.hasKey()) tgt.setKeyElement(Id40_N.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String40_N.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String40_N.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_N.convertString(src.getExpressionElement()));
    if (org.hl7.fhir.model.extensions.ExtensionUtilities.hasExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT)) {
      tgt.setXpath(org.hl7.fhir.model.extensions.ExtensionUtilities.readStringExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT));
    }
    if (src.hasSuppress()) {
      tgt.addExtension(VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS, Boolean40_N.convertBoolean(src.getSuppressElement()));
    }
    if (src.hasSource()) tgt.setSourceElement(Canonical40_N.convertCanonical(src.getSourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, 
        VersionConvertorConstants.EXT_ADDITIONAL_BINDING, ExtensionDefinitions.EXT_BINDING_ADDITIONAL);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations40_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_N.convertCanonical(src.getValueSetElement()));

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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "valueSet", "purpose", "documentation", "shortDoco", "usage", "any");
    if (src.hasExtension("purpose")) {
      tgt.getPurposeElement().setValueAsString(src.getExtensionByUrl("purpose").getValue().primitiveValue());
    }
    if (src.hasExtension("valueSet")) {
      tgt.setValueSetElement(Canonical40_N.convertCanonical((CanonicalType) src.getExtensionByUrl("valueSet").getValue()));
    }
    if (src.hasExtension("documentation")) {
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown((MarkdownType) src.getExtensionByUrl("documentation").getValue()));
    }
    if (src.hasExtension("shortDoco")) {
      tgt.setShortDocoElement(String40_N.convertString((StringType) src.getExtensionByUrl("shortDoco").getValue()));
    }
    for (Extension t : src.getExtensionsByUrl("usage")) {
      tgt.addUsage(UsageContext40_N.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) t.getValue()));
    }
    if (src.hasExtension("any")) {
      tgt.setAnyElement(Boolean40_N.convertBoolean((BooleanType) src.getExtensionByUrl("any").getValue()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Extension convertAdditional(ElementDefinitionBindingAdditionalComponent src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Extension tgt = new Extension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL);
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPurpose()) {
      tgt.addExtension(new Extension("purpose", new org.hl7.fhir.r4.model.CodeType(src.getPurposeElement().primitiveValue())));
    }
    if (src.hasValueSet()) {
      tgt.addExtension(new Extension("valueSet", Canonical40_N.convertCanonical(src.getValueSetElement())));
    }
    if (src.hasDocumentation()) {
      tgt.addExtension(new Extension("documentation", MarkDown40_N.convertMarkdown(src.getDocumentationElement())));
    }
    if (src.hasShortDoco()) {
      tgt.addExtension(new Extension("shortDoco", String40_N.convertString(src.getShortDocoElement())));
    }
    for (UsageContext t : src.getUsageList()) {
      tgt.addExtension(new Extension("usage", UsageContext40_N.convertUsageContext(t)));
    }
    if (src.hasAny()) {
      tgt.addExtension(new Extension("any", Boolean40_N.convertBoolean(src.getAnyElement())));
    }
    
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations40_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical40_N.convertCanonical(src.getValueSetElement()));
    for (ElementDefinitionBindingAdditionalComponent ab : src.getAdditionalList()) {
      tgt.addExtension(convertAdditional(ab));
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id40_N.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String40_N.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String40_N.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id40_N.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String40_N.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    return tgt;
  }
}
