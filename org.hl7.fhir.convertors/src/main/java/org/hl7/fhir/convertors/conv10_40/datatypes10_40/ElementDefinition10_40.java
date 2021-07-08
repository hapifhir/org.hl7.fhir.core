package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Coding10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.*;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.utilities.Utilities;

import java.util.List;
import java.util.stream.Collectors;

public class ElementDefinition10_40 {
    public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2.model.ElementDefinition src, List<String> slicePaths, List<org.hl7.fhir.dstu2.model.ElementDefinition> context, int pos) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
      Element10_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String10_40.convertString(src.getPathElement()));
      tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition10_40::convertPropertyRepresentation).collect(Collectors.toList()));
      if (src.hasName()) {
        if (slicePaths.contains(src.getPath())) tgt.setSliceNameElement(String10_40.convertString(src.getNameElement()));
        if (src.hasNameElement()) tgt.setIdElement(String10_40.convertString(src.getNameElement()));
      }
      if (src.hasLabel()) tgt.setLabelElement(String10_40.convertString(src.getLabelElement()));
      for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addCode(Coding10_40.convertCoding(t));
      if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
      if (src.hasShort()) tgt.setShortElement(String10_40.convertString(src.getShortElement()));
      if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown10_40.convertMarkdown(src.getDefinitionElement()));
      if (src.hasComments()) tgt.setCommentElement(MarkDown10_40.convertMarkdown(src.getCommentsElement()));
      if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown10_40.convertMarkdown(src.getRequirementsElement()));
      for (org.hl7.fhir.dstu2.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
      if (src.hasMin()) tgt.setMin(src.getMin());
      if (src.hasMax()) tgt.setMaxElement(String10_40.convertString(src.getMaxElement()));
      if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
      if (src.hasNameReference()) tgt.setContentReference("#" + src.getNameReference());
      for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : src.getType())
        convertElementDefinitionTypeComponent(t, tgt.getType());
      if (src.hasDefaultValue()) tgt.setDefaultValue(Type10_40.convertType(src.getDefaultValue()));
      if (src.hasMeaningWhenMissing())
        tgt.setMeaningWhenMissingElement(MarkDown10_40.convertMarkdown(src.getMeaningWhenMissingElement()));
      if (src.hasFixed()) tgt.setFixed(Type10_40.convertType(src.getFixed()));
      if (src.hasPattern()) tgt.setPattern(Type10_40.convertType(src.getPattern()));
      if (src.hasExample()) tgt.addExample().setLabel("General").setValue(Type10_40.convertType(src.getExample()));
      if (src.hasMinValue()) tgt.setMinValue(Type10_40.convertType(src.getMinValue()));
      if (src.hasMaxValue()) tgt.setMaxValue(Type10_40.convertType(src.getMaxValue()));
      if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer10_40.convertInteger(src.getMaxLengthElement()));
      for (org.hl7.fhir.dstu2.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
      for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
        tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
      if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean10_40.convertBoolean(src.getMustSupportElement()));
      if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean10_40.convertBoolean(src.getIsModifierElement()));
      if (tgt.getIsModifier()) {
        String reason = org.hl7.fhir.dstu2.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
        if (Utilities.noString(reason)) reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
        tgt.setIsModifierReason(reason);
      }
      if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean10_40.convertBoolean(src.getIsSummaryElement()));
      if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
      for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
        tgt.addMapping(convertElementDefinitionMappingComponent(t));
      if (!tgt.hasId()) tgt.setId(tgt.getPath());
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.ElementDefinition tgt = new org.hl7.fhir.dstu2.model.ElementDefinition();
      Element10_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String10_40.convertString(src.getPathElement()));
      tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition10_40::convertPropertyRepresentation).collect(Collectors.toList()));
      if (src.hasSliceName()) tgt.setNameElement(String10_40.convertString(src.getSliceNameElement()));
      else tgt.setNameElement(String10_40.convertString(src.getIdElement()));
      if (src.hasLabelElement()) tgt.setLabelElement(String10_40.convertString(src.getLabelElement()));
      for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding10_40.convertCoding(t));
      if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
      if (src.hasShortElement()) tgt.setShortElement(String10_40.convertString(src.getShortElement()));
      if (src.hasDefinitionElement()) tgt.setDefinitionElement(MarkDown10_40.convertMarkdown(src.getDefinitionElement()));
      if (src.hasCommentElement()) tgt.setCommentsElement(MarkDown10_40.convertMarkdown(src.getCommentElement()));
      if (src.hasRequirementsElement()) tgt.setRequirementsElement(MarkDown10_40.convertMarkdown(src.getRequirementsElement()));
      for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
      tgt.setMin(src.getMin());
      if (src.hasMaxElement()) tgt.setMaxElement(String10_40.convertString(src.getMaxElement()));
      if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
      if (src.hasContentReference()) tgt.setNameReference(src.getContentReference().substring(1));
      for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType())
        convertElementDefinitionTypeComponent(t, tgt.getType());
      if (src.hasDefaultValue()) tgt.setDefaultValue(Type10_40.convertType(src.getDefaultValue()));
      if (src.hasMeaningWhenMissingElement())
        tgt.setMeaningWhenMissingElement(MarkDown10_40.convertMarkdown(src.getMeaningWhenMissingElement()));
      if (src.hasFixed()) tgt.setFixed(Type10_40.convertType(src.getFixed()));
      if (src.hasPattern()) tgt.setPattern(Type10_40.convertType(src.getPattern()));
      if (src.hasExample()) tgt.setExample(Type10_40.convertType(src.getExampleFirstRep().getValue()));
      if (src.hasMinValue()) tgt.setMinValue(Type10_40.convertType(src.getMinValue()));
      if (src.hasMaxValue()) tgt.setMaxValue(Type10_40.convertType(src.getMaxValue()));
      if (src.hasMaxLengthElement()) tgt.setMaxLengthElement(Integer10_40.convertInteger(src.getMaxLengthElement()));
      for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
      for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
        tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
      if (src.hasMustSupportElement()) tgt.setMustSupportElement(Boolean10_40.convertBoolean(src.getMustSupportElement()));
      if (src.hasIsModifierElement()) tgt.setIsModifierElement(Boolean10_40.convertBoolean(src.getIsModifierElement()));
      if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
        org.hl7.fhir.dstu2.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
      if (src.hasIsSummaryElement()) tgt.setIsSummaryElement(Boolean10_40.convertBoolean(src.getIsSummaryElement()));
      if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
      for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
        tgt.addMapping(convertElementDefinitionMappingComponent(t));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentationEnumFactory());
      Element10_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
      } else {
        switch (src.getValue()) {
          case XMLATTR:
            tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentationEnumFactory());
      Element10_40.copyElement(src, tgt);
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

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent src, List<org.hl7.fhir.dstu2.model.ElementDefinition> context, int pos) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
      Element10_40.copyElement(src, tgt);
      org.hl7.fhir.dstu2.model.ElementDefinition slicingElement = context.get(pos);
      for (org.hl7.fhir.dstu2.model.StringType t : src.getDiscriminator()) {
        boolean isExists = false;
        if (!t.asStringValue().contains("@")) {
          int slices = 0;
          boolean existsSlicePresent = false;
          boolean notExistsSlicePresent = false;
          String existsPath = slicingElement.getPath() + "." + t.asStringValue();
          for (int i = pos + 1; i < context.size(); i++) {
            org.hl7.fhir.dstu2.model.ElementDefinition e = context.get(i);
            if (e.getPath().equals(slicingElement.getPath())) slices++;
            else if (!e.getPath().startsWith(slicingElement.getPath() + ".")) break;
            else if (e.getPath().equals(existsPath)) {
              if (e.hasMin() && e.getMin() > 0) existsSlicePresent = true;
              else if (e.hasMax() && e.getMax().equals("0")) notExistsSlicePresent = true;
            }
          }
          isExists = (slices == 2 && existsSlicePresent && notExistsSlicePresent) || (slices == 1 && existsSlicePresent != notExistsSlicePresent);
        }
        tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue(), isExists));
      }
      if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
      if (src.hasOrderedElement()) tgt.setOrderedElement(Boolean10_40.convertBoolean(src.getOrderedElement()));
      if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent();
      Element10_40.copyElement(src, tgt);
      for (ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
        tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
      if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
      if (src.hasOrderedElement()) tgt.setOrderedElement(Boolean10_40.convertBoolean(src.getOrderedElement()));
      if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ElementDefinition.SlicingRulesEnumFactory());
      Element10_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4.model.Enumeration<ElementDefinition.SlicingRules> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRulesEnumFactory());
      Element10_40.copyElement(src, tgt);
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
      Element10_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String10_40.convertString(src.getPathElement()));
      tgt.setMin(src.getMin());
      if (src.hasMaxElement()) tgt.setMaxElement(String10_40.convertString(src.getMaxElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent();
      Element10_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String10_40.convertString(src.getPathElement()));
      tgt.setMin(src.getMin());
      if (src.hasMaxElement()) tgt.setMaxElement(String10_40.convertString(src.getMaxElement()));
      return tgt;
    }

    public static void convertElementDefinitionTypeComponent(org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent src, List<ElementDefinition.TypeRefComponent> list) throws FHIRException {
      if (src == null) return;
      ElementDefinition.TypeRefComponent tgt = null;
      for (ElementDefinition.TypeRefComponent t : list)
        if (t.getCode().equals(src.getCode())) tgt = t;
      if (tgt == null) {
        tgt = new ElementDefinition.TypeRefComponent();
        list.add(tgt);
        Element10_40.copyElement(src, tgt);
        tgt.setCode(src.getCode());
      }
      if (tgt.hasTarget()) {
        for (org.hl7.fhir.dstu2.model.UriType u : src.getProfile()) tgt.addTargetProfile(u.getValue());
      } else {
        for (org.hl7.fhir.dstu2.model.UriType u : src.getProfile()) tgt.addProfile(u.getValue());
      }
      for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
        org.hl7.fhir.r4.model.Enumeration<ElementDefinition.AggregationMode> a = convertAggregationMode(t);
        if (!tgt.hasAggregation(a.getValue())) Element10_40.copyElement(t, tgt.addAggregationElement().setValue(a.getValue()));
      }
    }

    public static void convertElementDefinitionTypeComponent(ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
      if (src == null) return;
      org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent();
      Element10_40.copyElement(src, tgt);
      tgt.setCode(src.getCode());
      list.add(tgt);
      if (src.hasTarget()) {
        for (org.hl7.fhir.r4.model.UriType u : src.getTargetProfile()) {
          tgt.addProfile(u.getValue());
        }
      } else {
        for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
          tgt.addProfile(u.getValue());
        }
      }
    }

    static public org.hl7.fhir.r4.model.Enumeration<ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ElementDefinition.AggregationModeEnumFactory());
      Element10_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4.model.Enumeration<ElementDefinition.AggregationMode> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.AggregationModeEnumFactory());
      Element10_40.copyElement(src, tgt);
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
      Element10_40.copyElement(src, tgt);
      if (src.hasKeyElement()) tgt.setKeyElement(Id10_40.convertId(src.getKeyElement()));
      if (src.hasRequirementsElement()) tgt.setRequirementsElement(String10_40.convertString(src.getRequirementsElement()));
      if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
      if (src.hasHumanElement()) tgt.setHumanElement(String10_40.convertString(src.getHumanElement()));
      tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
      if (src.hasXpathElement()) tgt.setXpathElement(String10_40.convertString(src.getXpathElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent();
      Element10_40.copyElement(src, tgt);
      if (src.hasKeyElement()) tgt.setKeyElement(Id10_40.convertId(src.getKeyElement()));
      if (src.hasRequirementsElement()) tgt.setRequirementsElement(String10_40.convertString(src.getRequirementsElement()));
      if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
      if (src.hasHumanElement()) tgt.setHumanElement(String10_40.convertString(src.getHumanElement()));
      if (src.hasExpression())
        ToolingExtensions.addStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
      if (src.hasXpathElement()) tgt.setXpathElement(String10_40.convertString(src.getXpathElement()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ElementDefinition.ConstraintSeverityEnumFactory());
      Element10_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4.model.Enumeration<ElementDefinition.ConstraintSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverityEnumFactory());
      Element10_40.copyElement(src, tgt);
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
      Element10_40.copyElement(src, tgt);
      if (src.hasStrength()) tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
      if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
      org.hl7.fhir.r4.model.Type vs = Type10_40.convertType(src.getValueSet());
      if (vs != null) {
        tgt.setValueSet(vs instanceof org.hl7.fhir.r4.model.Reference ? ((org.hl7.fhir.r4.model.Reference) vs).getReference() : vs.primitiveValue());
        tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
      }
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent();
      Element10_40.copyElement(src, tgt);
      if (src.hasStrength()) tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
      if (src.hasDescriptionElement()) tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
      if (src.hasValueSet()) {
        String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
        if (vsr != null) tgt.setValueSet(new org.hl7.fhir.dstu2.model.UriType(vsr));
        else tgt.setValueSet(new org.hl7.fhir.dstu2.model.Reference(src.getValueSet()));
      }
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.BindingStrengthEnumFactory());
      Element10_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL);
      } else {
        switch (src.getValue()) {
          case REQUIRED:
            tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED);
            break;
          case EXTENSIBLE:
            tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE);
            break;
          case PREFERRED:
            tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED);
            break;
          case EXAMPLE:
            tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE);
            break;
          default:
            tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.BindingStrengthEnumFactory());
      Element10_40.copyElement(src, tgt);
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
      Element10_40.copyElement(src, tgt);
      if (src.hasIdentityElement()) tgt.setIdentityElement(Id10_40.convertId(src.getIdentityElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_40.convertCode(src.getLanguageElement()));
      if (src.hasMapElement()) tgt.setMapElement(String10_40.convertString(src.getMapElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent();
      Element10_40.copyElement(src, tgt);
      if (src.hasIdentityElement()) tgt.setIdentityElement(Id10_40.convertId(src.getIdentityElement()));
      if (src.hasLanguageElement()) tgt.setLanguageElement(Code10_40.convertCode(src.getLanguageElement()));
      if (src.hasMapElement()) tgt.setMapElement(String10_40.convertString(src.getMapElement()));
      return tgt;
    }
}
