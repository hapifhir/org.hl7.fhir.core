package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Coding10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Code10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Id10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Integer10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.MarkDown10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.dstu3.conformance.ProfileUtilities;
import org.hl7.fhir.dstu3.model.ElementDefinition;
import org.hl7.fhir.exceptions.FHIRException;

public class ElementDefinition10_30 {
  public static org.hl7.fhir.dstu3.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2.model.ElementDefinition src, List<String> slicePaths) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition tgt = new org.hl7.fhir.dstu3.model.ElementDefinition();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition10_30::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasName()) {
      if (slicePaths.contains(src.getPath())) tgt.setSliceNameElement(String10_30.convertString(src.getNameElement()));
      if (src.hasNameElement()) tgt.setIdElement(String10_30.convertString(src.getNameElement()));
    }
    if (src.hasLabel()) tgt.setLabelElement(String10_30.convertString(src.getLabelElement()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addCode(Coding10_30.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String10_30.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown10_30.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComments()) tgt.setCommentElement(MarkDown10_30.convertMarkdown(src.getCommentsElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown10_30.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    if (src.hasMin()) tgt.setMin(src.getMin());
    if (src.hasMax()) tgt.setMaxElement(String10_30.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasNameReference()) tgt.setContentReference("#" + src.getNameReference());
    for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertElementDefinitionTypeComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown10_30.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getPattern()));
    if (src.hasExample())
      tgt.addExample().setLabel("General").setValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getExample()));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer10_30.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.dstu2.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean10_30.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean10_30.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean10_30.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu3.model.ElementDefinition src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition tgt = new org.hl7.fhir.dstu2.model.ElementDefinition();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition10_30::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setNameElement(String10_30.convertString(src.getSliceNameElement()));
    else tgt.setNameElement(String10_30.convertString(src.getIdElement()));
    if (src.hasLabelElement()) tgt.setLabelElement(String10_30.convertString(src.getLabelElement()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(Coding10_30.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShortElement()) tgt.setShortElement(String10_30.convertString(src.getShortElement()));
    if (src.hasDefinitionElement()) tgt.setDefinitionElement(MarkDown10_30.convertMarkdown(src.getDefinitionElement()));
    if (src.hasCommentElement()) tgt.setCommentsElement(MarkDown10_30.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirementsElement())
      tgt.setRequirementsElement(MarkDown10_30.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    tgt.setMin(src.getMin());
    if (src.hasMaxElement()) tgt.setMaxElement(String10_30.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference()) tgt.setNameReference(src.getContentReference().substring(1));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertElementDefinitionTypeComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissingElement())
      tgt.setMeaningWhenMissingElement(MarkDown10_30.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getPattern()));
    if (src.hasExample())
      tgt.setExample(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getExampleFirstRep().getValue()));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getMaxValue()));
    if (src.hasMaxLengthElement()) tgt.setMaxLengthElement(Integer10_30.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.dstu3.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupportElement())
      tgt.setMustSupportElement(Boolean10_30.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifierElement()) tgt.setIsModifierElement(Boolean10_30.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsSummaryElement()) tgt.setIsSummaryElement(Boolean10_30.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.NULL);
    } else {
      switch (src.getValue()) {
        case XMLATTR:
          tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLATTR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.NULL);
    } else {
      switch (src.getValue()) {
        case XMLATTR:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.XMLATTR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.StringType t : src.getDiscriminator())
      tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue()));
    if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasOrderedElement()) tgt.setOrderedElement(Boolean10_30.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
    if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasOrderedElement()) tgt.setOrderedElement(Boolean10_30.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(ElementDefinition.SlicingRules.NULL);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.NULL);
    } else {
      switch (src.getValue()) {
        case CLOSED:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.CLOSED);
          break;
        case OPEN:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPEN);
          break;
        case OPENATEND:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPENATEND);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.NULL);
          break;
      }
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionBaseComponent tgt = new ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMin(src.getMin());
    if (src.hasMaxElement()) tgt.setMaxElement(String10_30.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    if (src.hasMin()) tgt.setMin(src.getMin());
    if (src.hasMaxElement()) tgt.setMaxElement(String10_30.convertString(src.getMaxElement()));
    return tgt;
  }

  public static ElementDefinition.TypeRefComponent convertElementDefinitionTypeComponent(org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.TypeRefComponent tgt = new ElementDefinition.TypeRefComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_30.convertCodeToUri(src.getCodeElement()));
    for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile())
      if (src.hasTarget()) tgt.setTargetProfile(t.getValueAsString());
      else tgt.setProfile(t.getValue());
    tgt.setAggregation(src.getAggregation().stream().map(ElementDefinition10_30::convertAggregationMode).collect(Collectors.toList()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent convertElementDefinitionTypeComponent(ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasCodeElement()) tgt.setCodeElement(Code10_30.convertUriToCode(src.getCodeElement()));
    if (src.hasTarget()) {
      if (src.hasTargetProfile()) tgt.addProfile(src.getTargetProfile());
    } else if (src.hasProfile()) tgt.addProfile(src.getProfile());
    tgt.setAggregation(src.getAggregation().stream().map(ElementDefinition10_30::convertAggregationMode).collect(Collectors.toList()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new ElementDefinition.AggregationModeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(ElementDefinition.AggregationMode.NULL);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.NULL);
    } else {
      switch (src.getValue()) {
        case CONTAINED:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.CONTAINED);
          break;
        case REFERENCED:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.REFERENCED);
          break;
        case BUNDLED:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.BUNDLED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionConstraintComponent tgt = new ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasKeyElement()) tgt.setKeyElement(Id10_30.convertId(src.getKeyElement()));
    if (src.hasRequirementsElement())
      tgt.setRequirementsElement(String10_30.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHumanElement()) tgt.setHumanElement(String10_30.convertString(src.getHumanElement()));
    tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
    if (src.hasXpathElement()) tgt.setXpathElement(String10_30.convertString(src.getXpathElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasKeyElement()) tgt.setKeyElement(Id10_30.convertId(src.getKeyElement()));
    if (src.hasRequirementsElement())
      tgt.setRequirementsElement(String10_30.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHumanElement()) tgt.setHumanElement(String10_30.convertString(src.getHumanElement()));
    if (src.hasExpression())
      ToolingExtensions.addStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
    if (src.hasXpathElement()) tgt.setXpathElement(String10_30.convertString(src.getXpathElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(ElementDefinition.ConstraintSeverity.NULL);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu3.model.Enumeration<ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.NULL);
    } else {
      switch (src.getValue()) {
        case ERROR:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.ERROR);
          break;
        case WARNING:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.WARNING);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.NULL);
          break;
      }
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionBindingComponent tgt = new ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasValueSet())
      tgt.setValueSet(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasValueSet())
      tgt.setValueSet(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getValueSet()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionMappingComponent tgt = new ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasIdentityElement()) tgt.setIdentityElement(Id10_30.convertId(src.getIdentityElement()));
    if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_30.convertCode(src.getLanguageElement()));
    if (src.hasMapElement()) tgt.setMapElement(String10_30.convertString(src.getMapElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasIdentityElement()) tgt.setIdentityElement(Id10_30.convertId(src.getIdentityElement()));
    if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_30.convertCode(src.getLanguageElement()));
    if (src.hasMapElement()) tgt.setMapElement(String10_30.convertString(src.getMapElement()));
    return tgt;
  }
}
