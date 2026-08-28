package org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.BackboneElement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.resources43_N.Enumerations43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.BooleanType;
import org.hl7.fhir.r4b.model.CanonicalType;
import org.hl7.fhir.r4b.model.Extension;
import org.hl7.fhir.r4b.model.MarkdownType;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.model.core.UsageContext;

public class ElementDefinition43_N {
  
  public static org.hl7.fhir.model.core.ElementDefinition convertElementDefinition(org.hl7.fhir.r4b.model.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition tgt = new org.hl7.fhir.model.core.ElementDefinition();
    BackboneElement43_N.copyBackboneElement(src, tgt, 
        VersionConvertorConstants.EXT_MUST_VALUE, 
        VersionConvertorConstants.EXT_VALUE_ALT);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    tgt.setRepresentationList(src.getRepresentation().stream().map(ElementDefinition43_N::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String43_N.convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(Boolean43_N.convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel()) tgt.setLabelElement(String43_N.convertString(src.getLabelElement()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getCode()) tgt.addCode(Coding43_N.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String43_N.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown43_N.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown43_N.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown43_N.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getAlias()) tgt.getAliasList().add(String43_N.convertString(t));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt43_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri43_N.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown43_N.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String43_N.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getPattern()));
    for (org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer43_N.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r4b.model.IdType t : src.getCondition()) tgt.getConditionList().add(Id43_N.convertId(t));
    for (org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean43_N.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean43_N.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(String43_N.convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean43_N.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));

    if (src.hasExtension(VersionConvertorConstants.EXT_MUST_VALUE)) {
      tgt.setMustHaveValueElement(Boolean43_N.convertBoolean((org.hl7.fhir.r4b.model.BooleanType) src.getExtensionByUrl(VersionConvertorConstants.EXT_MUST_VALUE).getValueAsPrimitive()));
    }
    for (org.hl7.fhir.r4b.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VALUE_ALT)) {
      tgt.getValueAlternativesList().add(Canonical43_N.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType) ext.getValue()));
    }

    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition convertElementDefinition(org.hl7.fhir.model.core.ElementDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition tgt = new org.hl7.fhir.r4b.model.ElementDefinition();
    BackboneElement43_N.copyBackboneElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentationList().stream().map(ElementDefinition43_N::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setSliceNameElement(String43_N.convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(Boolean43_N.convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel()) tgt.setLabelElement(String43_N.convertString(src.getLabelElement()));
    for (org.hl7.fhir.model.core.Coding t : src.getCodeList()) tgt.addCode(Coding43_N.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String43_N.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown43_N.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentElement(MarkDown43_N.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown43_N.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAliasList()) tgt.getAlias().add(String43_N.convertString(t));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt43_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri43_N.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent t : src.getTypeList())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown43_N.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning()) tgt.setOrderMeaningElement(String43_N.convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getPattern()));
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent t : src.getExampleList())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer43_N.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.model.core.IdType t : src.getConditionList()) tgt.getCondition().add(Id43_N.convertId(t));
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraintList())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean43_N.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean43_N.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(String43_N.convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean43_N.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent t : src.getMappingList())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    if (src.hasMustHaveValue()) {
      tgt.addExtension(VersionConvertorConstants.EXT_MUST_VALUE, Boolean43_N.convertBoolean(src.getMustHaveValueElement()));
    }
    for (org.hl7.fhir.model.core.CanonicalType ct : src.getValueAlternativesList()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VALUE_ALT, Canonical43_N.convertCanonical(ct));      
    }

    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case XMLATTR:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                    break;
                case XMLTEXT:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                    break;
                case TYPEATTR:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                    break;
                case CDATEXT:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                    break;
                case XHTML:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation.XHTML);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.PropertyRepresentation.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean43_N.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    for (org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminatorList())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean43_N.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CLOSED:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules.CLOSED);
                    break;
                case OPEN:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules.OPEN);
                    break;
                case OPENATEND:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules.OPENATEND);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.SlicingRules.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorTypeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case VALUE:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType.VALUE);
                    break;
                case EXISTS:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType.EXISTS);
                    break;
                case PATTERN:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType.PATTERN);
                    break;
                case TYPE:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType.TYPE);
                    break;
                case PROFILE:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType.PROFILE);
                    break;
                case POSITION:
                    // 'position' was introduced in R5: park it on the 5.0 inter-version extension. 
                    // discriminator.type is mandatory, so the containing resource converter is 
                    // responsible for marking implicitRules - see StructureDefinition43_N
                    tgt.addExtension(VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE, new org.hl7.fhir.r4b.model.CodeType("position"));
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.DiscriminatorType.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt43_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPath()) tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMinElement(UnsignedInt43_N.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCodeElement(Uri43_N.convertUri(src.getCodeElement()));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getProfile())
      tgt.getProfileList().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfileList().add(Canonical43_N.convertCanonical(t));
    tgt.setAggregationList(src.getAggregation().stream().map(ElementDefinition43_N::convertAggregationMode).collect(Collectors.toList()));
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.TypeRefComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCode()) tgt.setCodeElement(Uri43_N.convertUri(src.getCodeElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList())
      tgt.getProfile().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getTargetProfileList())
      tgt.getTargetProfile().add(Canonical43_N.convertCanonical(t));
    tgt.setAggregation(src.getAggregationList().stream().map(ElementDefinition43_N::convertAggregationMode).collect(Collectors.toList()));
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case CONTAINED:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode.CONTAINED);
                    break;
                case REFERENCED:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode.REFERENCED);
                    break;
                case BUNDLED:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode.BUNDLED);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.AggregationMode.NULL);
                    break;
       }
}
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case EITHER:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules.EITHER);
                    break;
                case INDEPENDENT:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                    break;
                case SPECIFIC:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ReferenceVersionRules.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String43_N.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionExampleComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String43_N.convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS);
    if (src.hasKey()) tgt.setKeyElement(Id43_N.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String43_N.convertStringToMarkdown(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String43_N.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    if (src.hasXpath()) {
      tgt.addExtension(new org.hl7.fhir.model.core.Extension(org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT, new org.hl7.fhir.model.core.StringType(src.getXpath())));
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS)) {
      tgt.setSuppressElement(Boolean43_N.convertBoolean((org.hl7.fhir.r4b.model.BooleanType) src.getExtensionByUrl(VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS).getValueAsPrimitive()));
    }
    if (src.hasSource()) tgt.setSourceElement(Canonical43_N.convertCanonical(src.getSourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT);
    if (src.hasKey()) tgt.setKeyElement(Id43_N.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String43_N.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHuman()) tgt.setHumanElement(String43_N.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    if (org.hl7.fhir.model.extensions.ExtensionUtilities.hasExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT)) {
      tgt.setXpath(org.hl7.fhir.model.extensions.ExtensionUtilities.readStringExtension(src, org.hl7.fhir.r5.extensions.ExtensionDefinitions.EXT_XPATH_CONSTRAINT));
    }
    if (src.hasSuppress()) {
      tgt.addExtension(VersionConvertorConstants.EXT_CONSTRAINT_SUPPRESS, Boolean43_N.convertBoolean(src.getSuppressElement()));
    }
    if (src.hasSource()) tgt.setSourceElement(Canonical43_N.convertCanonical(src.getSourceElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
    tgt.setValue(null);
} else {
      switch(src.getValue()) {
        case ERROR:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverity.ERROR);
                    break;
                case WARNING:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverity.WARNING);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4b.model.ElementDefinition.ConstraintSeverity.NULL);
                    break;
       }
}
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, 
        VersionConvertorConstants.EXT_ADDITIONAL_BINDING, ExtensionDefinitions.EXT_BINDING_ADDITIONAL);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations43_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));

    for (org.hl7.fhir.r4b.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_ADDITIONAL_BINDING)) {
      tgt.addAdditional(convertAdditional(ext));
    }
    for (org.hl7.fhir.r4b.model.Extension ext : src.getExtensionsByUrl(ExtensionDefinitions.EXT_BINDING_ADDITIONAL)) {
      tgt.addAdditional(convertAdditional(ext));
    }
    return tgt;
  }

  private static ElementDefinitionBindingAdditionalComponent convertAdditional(Extension src) {
    if (src == null) return null;
    ElementDefinitionBindingAdditionalComponent tgt = new ElementDefinitionBindingAdditionalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, "valueSet", "purpose", "documentation", "shortDoco", "usage", "any");
    if (src.hasExtension("purpose")) {
      tgt.getPurposeElement().setValueAsString(src.getExtensionByUrl("purpose").getValue().primitiveValue());
    }
    if (src.hasExtension("valueSet")) {
      tgt.setValueSetElement(Canonical43_N.convertCanonical((CanonicalType) src.getExtensionByUrl("valueSet").getValue()));
    }
    if (src.hasExtension("documentation")) {
      tgt.setDocumentationElement(MarkDown43_N.convertMarkdown((MarkdownType) src.getExtensionByUrl("documentation").getValue()));
    }
    if (src.hasExtension("shortDoco")) {
      tgt.setShortDocoElement(String43_N.convertString((StringType) src.getExtensionByUrl("shortDoco").getValue()));
    }
    for (Extension t : src.getExtensionsByUrl("usage")) {
      tgt.addUsage(UsageContext43_N.convertUsageContext((org.hl7.fhir.r4b.model.UsageContext) t.getValue()));
    }
    if (src.hasExtension("any")) {
      tgt.setAnyElement(Boolean43_N.convertBoolean((BooleanType) src.getExtensionByUrl("any").getValue()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Extension convertAdditional(ElementDefinitionBindingAdditionalComponent src) {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Extension tgt = new Extension(ExtensionDefinitions.EXT_BINDING_ADDITIONAL);
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPurpose()) {
      tgt.addExtension(new Extension("purpose", new org.hl7.fhir.r4b.model.CodeType(src.getPurposeElement().primitiveValue())));
    }
    if (src.hasValueSet()) {
      tgt.addExtension(new Extension("valueSet", Canonical43_N.convertCanonical(src.getValueSetElement())));
    }
    if (src.hasDocumentation()) {
      tgt.addExtension(new Extension("documentation", MarkDown43_N.convertMarkdown(src.getDocumentationElement())));
    }
    if (src.hasShortDoco()) {
      tgt.addExtension(new Extension("shortDoco", String43_N.convertString(src.getShortDocoElement())));
    }
    for (UsageContext t : src.getUsageList()) {
      tgt.addExtension(new Extension("usage", UsageContext43_N.convertUsageContext(t)));
    }
    if (src.hasAny()) {
      tgt.addExtension(new Extension("any", Boolean43_N.convertBoolean(src.getAnyElement())));
    }
    
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations43_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    for (ElementDefinitionBindingAdditionalComponent ab : src.getAdditionalList()) {
      tgt.addExtension(convertAdditional(ab));
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id43_N.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String43_N.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String43_N.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasIdentity()) tgt.setIdentityElement(Id43_N.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasMap()) tgt.setMapElement(String43_N.convertString(src.getMapElement()));
    if (src.hasComment()) tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }
}
