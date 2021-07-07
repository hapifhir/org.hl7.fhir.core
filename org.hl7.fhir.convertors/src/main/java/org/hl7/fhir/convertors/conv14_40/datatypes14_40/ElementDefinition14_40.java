package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Coding14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.*;
import org.hl7.fhir.convertors.conv14_40.resources14_40.Enumerations14_40;
import org.hl7.fhir.dstu2016may.model.ElementDefinition;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.utilities.Utilities;

import java.util.List;
import java.util.stream.Collectors;

public class ElementDefinition14_40 {
    public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2016may.model.ElementDefinition src, List<ElementDefinition> context, int pos) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
      Element14_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String14_40.convertString(src.getPathElement()));
      tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition14_40::convertPropertyRepresentation).collect(Collectors.toList()));
      if (src.hasName()) tgt.setSliceNameElement(String14_40.convertString(src.getNameElement()));
      if (src.hasLabel()) tgt.setLabelElement(String14_40.convertString(src.getLabelElement()));
      for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addCode(Coding14_40.convertCoding(t));
      if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
      if (src.hasShort()) tgt.setShortElement(String14_40.convertString(src.getShortElement()));
      if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown14_40.convertMarkdown(src.getDefinitionElement()));
      if (src.hasComments()) tgt.setCommentElement(MarkDown14_40.convertMarkdown(src.getCommentsElement()));
      if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown14_40.convertMarkdown(src.getRequirementsElement()));
      for (org.hl7.fhir.dstu2016may.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
      if (src.hasMin()) tgt.setMin(src.getMin());
      if (src.hasMax()) tgt.setMaxElement(String14_40.convertString(src.getMaxElement()));
      if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
      if (src.hasContentReference()) tgt.setContentReferenceElement(Uri14_40.convertUri(src.getContentReferenceElement()));
      for (ElementDefinition.TypeRefComponent t : src.getType())
        convertTypeRefComponent(t, tgt.getType());
      if (src.hasDefaultValue()) tgt.setDefaultValue(Type14_40.convertType(src.getDefaultValue()));
      if (src.hasMeaningWhenMissing())
        tgt.setMeaningWhenMissingElement(MarkDown14_40.convertMarkdown(src.getMeaningWhenMissingElement()));
      if (src.hasFixed()) tgt.setFixed(Type14_40.convertType(src.getFixed()));
      if (src.hasPattern()) tgt.setPattern(Type14_40.convertType(src.getPattern()));
      if (src.hasExample()) tgt.addExample().setLabel("General").setValue(Type14_40.convertType(src.getExample()));
      if (src.hasMinValue()) tgt.setMinValue(Type14_40.convertType(src.getMinValue()));
      if (src.hasMaxValue()) tgt.setMaxValue(Type14_40.convertType(src.getMaxValue()));
      if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer14_40.convertInteger(src.getMaxLengthElement()));
      for (org.hl7.fhir.dstu2016may.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
      for (ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
        tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
      if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean14_40.convertBoolean(src.getMustSupportElement()));
      if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean14_40.convertBoolean(src.getIsModifierElement()));
      if (tgt.getIsModifier()) {
        String reason = org.hl7.fhir.dstu2016may.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
        if (Utilities.noString(reason)) reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
        tgt.setIsModifierReason(reason);
      }
      if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean14_40.convertBoolean(src.getIsSummaryElement()));
      if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
      for (ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
        tgt.addMapping(convertElementDefinitionMappingComponent(t));
      return tgt;
    }

    public static ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      ElementDefinition tgt = new ElementDefinition();
      Element14_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String14_40.convertString(src.getPathElement()));
      tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition14_40::convertPropertyRepresentation).collect(Collectors.toList()));
      if (src.hasSliceName()) tgt.setNameElement(String14_40.convertString(src.getSliceNameElement()));
      if (src.hasLabel()) tgt.setLabelElement(String14_40.convertString(src.getLabelElement()));
      for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding14_40.convertCoding(t));
      if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
      if (src.hasShort()) tgt.setShortElement(String14_40.convertString(src.getShortElement()));
      if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown14_40.convertMarkdown(src.getDefinitionElement()));
      if (src.hasComment()) tgt.setCommentsElement(MarkDown14_40.convertMarkdown(src.getCommentElement()));
      if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown14_40.convertMarkdown(src.getRequirementsElement()));
      for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
      if (src.hasMin()) tgt.setMin(src.getMin());
      if (src.hasMax()) tgt.setMaxElement(String14_40.convertString(src.getMaxElement()));
      if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
      if (src.hasContentReference()) tgt.setContentReferenceElement(Uri14_40.convertUri(src.getContentReferenceElement()));
      for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType())
        convertTypeRefComponent(t, tgt.getType());
      if (src.hasDefaultValue()) tgt.setDefaultValue(Type14_40.convertType(src.getDefaultValue()));
      if (src.hasMeaningWhenMissing())
        tgt.setMeaningWhenMissingElement(MarkDown14_40.convertMarkdown(src.getMeaningWhenMissingElement()));
      if (src.hasFixed()) tgt.setFixed(Type14_40.convertType(src.getFixed()));
      if (src.hasPattern()) tgt.setPattern(Type14_40.convertType(src.getPattern()));
      if (src.hasExample()) tgt.setExample(Type14_40.convertType(src.getExample().get(0).getValue()));
      if (src.hasMinValue()) tgt.setMinValue(Type14_40.convertType(src.getMinValue()));
      if (src.hasMaxValue()) tgt.setMaxValue(Type14_40.convertType(src.getMaxValue()));
      if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer14_40.convertInteger(src.getMaxLengthElement()));
      for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
      for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
        tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
      if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean14_40.convertBoolean(src.getMustSupportElement()));
      if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean14_40.convertBoolean(src.getIsModifierElement()));
      if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
        org.hl7.fhir.dstu2016may.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
      if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean14_40.convertBoolean(src.getIsSummaryElement()));
      if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
      for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
        tgt.addMapping(convertElementDefinitionMappingComponent(t));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.PropertyRepresentation> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentationEnumFactory());
      Element14_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
      } else {
        switch (src.getValue()) {
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
          default:
            tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
            break;
        }
      }
      return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.PropertyRepresentationEnumFactory());
      Element14_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(ElementDefinition.PropertyRepresentation.NULL);
      } else {
        switch (src.getValue()) {
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
          default:
            tgt.setValue(ElementDefinition.PropertyRepresentation.NULL);
            break;
        }
      }
      return tgt;
    }

    /*
     * This process deals with the fact that 'exists' slicing didn't have a mechanism to flag it in 2016May.
     * (Pattern and profile both had '@' flags in the discriminator to distinguish this, but exists did not.)
     * 'Exists' can thus only be determined by looking at the available slices - and checking to see that there
     * are exactly two slices, one which is mandatory and one which is prohibited.  We need to do that check
     * at the level where the slices are defined, rather than only inside the 'slicing' element where we don't
     * have access to the slices themselves.
     *
     * This process checks to see if we have a 'value' discriminator (i.e. no '@') and if so, checks for all
     * matching slices.  If there are exactly two and one's required and one's prohibited, then it sets a flag
     * so that the converter will declare a discriminator.type of 'exists'.
     *
     * Note that we only need complex processing on the R2B -> newer release, not on the reverse.  On the reverse,
     * we just strip the discriminator type.  What slices exist is still the same.  In theory, that means that the
     * exists type is unnecessary, but it's far more efficient (and clear) to have it.
     */
    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(ElementDefinition.ElementDefinitionSlicingComponent src, List<ElementDefinition> context, int pos) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
      Element14_40.copyElement(src, tgt);
      ElementDefinition slicingElement = context.get(pos);
      for (org.hl7.fhir.dstu2016may.model.StringType t : src.getDiscriminator()) {
        boolean isExists = false;
        if (!t.asStringValue().contains("@")) {
          int slices = 0;
          boolean existsSlicePresent = false;
          boolean notExistsSlicePresent = false;
          String url = null;
          String existsPath = slicingElement.getPath() + "." + t.asStringValue();
          if (existsPath.contains(".extension(")) {
            String suffix = StringUtils.substringAfter(existsPath,"(").substring(1);
            existsPath = StringUtils.substringBefore(existsPath,"(");
            suffix = StringUtils.substringBefore(suffix, ")");
            url = suffix.substring(0,suffix.length()-1);
          }
          for (int i = pos + 1; i < context.size(); i++) {
            ElementDefinition e = context.get(i);
            if (e.getPath().equals(slicingElement.getPath())) slices++;
            else if (!e.getPath().startsWith(slicingElement.getPath() + ".")) break;
            else if (e.getPath().equals(existsPath)) {
              if (url==null || (e.getType().get(0).hasProfile() && e.getType().get(0).getProfile().get(0).equals(url))) {
                if (e.hasMin() && e.getMin() > 0 && !e.hasFixed()) existsSlicePresent = true;
                else if (e.hasMax() && e.getMax().equals("0")) notExistsSlicePresent = true;
              }
            }
          }
          isExists = (slices == 2 && existsSlicePresent && notExistsSlicePresent) || (slices == 1 && existsSlicePresent != notExistsSlicePresent);
        }
        tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue(), isExists));
      }
      if (src.hasDescription()) tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
      if (src.hasOrdered()) tgt.setOrderedElement(Boolean14_40.convertBoolean(src.getOrderedElement()));
      if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
      return tgt;
    }

    public static ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      ElementDefinition.ElementDefinitionSlicingComponent tgt = new ElementDefinition.ElementDefinitionSlicingComponent();
      Element14_40.copyElement(src, tgt);
      for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
        tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
      if (src.hasDescription()) tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
      if (src.hasOrdered()) tgt.setOrderedElement(Boolean14_40.convertBoolean(src.getOrderedElement()));
      if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
      return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.SlicingRules> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.SlicingRulesEnumFactory());
      Element14_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL);
      } else {
        switch (src.getValue()) {
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.SlicingRulesEnumFactory());
      Element14_40.copyElement(src, tgt);
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

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
      Element14_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String14_40.convertString(src.getPathElement()));
      tgt.setMin(src.getMin());
      if (src.hasMaxElement()) tgt.setMaxElement(String14_40.convertString(src.getMaxElement()));
      return tgt;
    }

    public static ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      ElementDefinition.ElementDefinitionBaseComponent tgt = new ElementDefinition.ElementDefinitionBaseComponent();
      Element14_40.copyElement(src, tgt);
      if (src.hasPathElement()) tgt.setPathElement(String14_40.convertString(src.getPathElement()));
      tgt.setMin(src.getMin());
      if (src.hasMaxElement()) tgt.setMaxElement(String14_40.convertString(src.getMaxElement()));
      return tgt;
    }

    static public void convertTypeRefComponent(ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
      if (src == null) return;
      org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = null;
      for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : list)
        if (t.getCode().equals(src.getCode())) tgt = t;
      if (tgt == null) {
        tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
        list.add(tgt);
        Element14_40.copyElement(src, tgt);
        tgt.setCode(src.getCode());
      }
      if (tgt.hasTarget()) {
        for (org.hl7.fhir.dstu2016may.model.UriType u : src.getProfile()) {
          if (src.getCode().equals("Reference")) tgt.addTargetProfile(u.getValue());
          else tgt.addProfile(u.getValue());
        }
        for (org.hl7.fhir.dstu2016may.model.Extension t : src.getExtensionsByUrl(VersionConvertorConstants.PROFILE_EXTENSION)) {
          String s = ((org.hl7.fhir.dstu2016may.model.PrimitiveType<String>) t.getValue()).getValue();
          tgt.addProfile(s);
        }
      } else {
        for (org.hl7.fhir.dstu2016may.model.UriType u : src.getProfile()) tgt.addProfile(u.getValue());
      }
      for (org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> t : src.getAggregation()) {
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
        if (!tgt.hasAggregation(a.getValue())) Element14_40.copyElement(t, tgt.addAggregation(a.getValue()));
      }
      if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    }

    public static void convertTypeRefComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src, List<ElementDefinition.TypeRefComponent> list) throws FHIRException {
      if (src == null) return;
      ElementDefinition.TypeRefComponent tgt = new ElementDefinition.TypeRefComponent();
      Element14_40.copyElement(src, tgt);
      tgt.setCode(src.getCode());
      list.add(tgt);
      if (src.hasTarget()) {
        for (org.hl7.fhir.r4.model.UriType u : src.getTargetProfile()) {
          tgt.addProfile(u.getValue());
          String baseName = u.getValue().toLowerCase();
          if (baseName.contains("reference") && !baseName.contains("documentreference"))
            throw new Error("2016May Target profile contains the word 'reference':" + u);
        }
        for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
          if (src.getCode().equals("Reference")) {
            org.hl7.fhir.dstu2016may.model.Extension t = new org.hl7.fhir.dstu2016may.model.Extension(VersionConvertorConstants.PROFILE_EXTENSION);
            t.setValue(Type14_40.convertType(u));
            tgt.addExtension(t);
          } else tgt.addProfile(u.getValue());
        }
      } else {
        for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
          tgt.addProfile(u.getValue());
        }
      }
      for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
        org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> a = convertAggregationMode(t);
        if (!tgt.hasAggregation(a.getValue())) Element14_40.copyElement(t, tgt.addAggregation(a.getValue()));
      }
      if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.AggregationModeEnumFactory());
      Element14_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL);
      } else {
        switch (src.getValue()) {
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.AggregationModeEnumFactory());
      Element14_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
      Element14_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.NULL);
      } else {
        switch (src.getValue()) {
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.ReferenceVersionRulesEnumFactory());
      Element14_40.copyElement(src, tgt);
      if (src.getValue() == null) {
        tgt.setValue(ElementDefinition.ReferenceVersionRules.NULL);
      } else {
        switch (src.getValue()) {
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

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
      Element14_40.copyElement(src, tgt);
      if (src.hasKeyElement()) tgt.setKeyElement(Id14_40.convertId(src.getKeyElement()));
      if (src.hasRequirements()) tgt.setRequirementsElement(String14_40.convertString(src.getRequirementsElement()));
      if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
      if (src.hasHumanElement()) tgt.setHumanElement(String14_40.convertString(src.getHumanElement()));
      if (src.hasExpression()) tgt.setExpression(Expression14_40.convertToR4Expression(src.getExpression()));
      if (src.hasXpathElement()) tgt.setXpathElement(String14_40.convertString(src.getXpathElement()));
      return tgt;
    }

    public static ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      ElementDefinition.ElementDefinitionConstraintComponent tgt = new ElementDefinition.ElementDefinitionConstraintComponent();
      Element14_40.copyElement(src, tgt);
      if (src.hasKeyElement()) tgt.setKeyElement(Id14_40.convertId(src.getKeyElement()));
      if (src.hasRequirements()) tgt.setRequirementsElement(String14_40.convertString(src.getRequirementsElement()));
      if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
      if (src.hasHumanElement()) tgt.setHumanElement(String14_40.convertString(src.getHumanElement()));
      if (src.hasExpression()) tgt.setExpression(Expression14_40.convertTo2016MayExpression(src.getExpression()));
      if (src.hasXpathElement()) tgt.setXpathElement(String14_40.convertString(src.getXpathElement()));
      return tgt;
    }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverityEnumFactory());
    Element14_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL);
    } else {
      switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.ConstraintSeverityEnumFactory());
    Element14_40.copyElement(src, tgt);
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

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
    Element14_40.copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations14_40.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) {
      org.hl7.fhir.r4.model.Type t = Type14_40.convertType(src.getValueSet());
      if (t instanceof org.hl7.fhir.r4.model.Reference)
        tgt.setValueSet(((org.hl7.fhir.r4.model.Reference) t).getReference());
      else tgt.setValueSet(t.primitiveValue());
      tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionBindingComponent tgt = new ElementDefinition.ElementDefinitionBindingComponent();
    Element14_40.copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations14_40.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) {
      String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
      if (vsr != null) tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.UriType(vsr));
      else tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.Reference(src.getValueSet()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
    Element14_40.copyElement(src, tgt);
    if (src.hasIdentityElement()) tgt.setIdentityElement(Id14_40.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
    if (src.hasMapElement()) tgt.setMapElement(String14_40.convertString(src.getMapElement()));
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionMappingComponent tgt = new ElementDefinition.ElementDefinitionMappingComponent();
    Element14_40.copyElement(src, tgt);
    if (src.hasIdentityElement()) tgt.setIdentityElement(Id14_40.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
    if (src.hasMapElement()) tgt.setMapElement(String14_40.convertString(src.getMapElement()));
    return tgt;
  }
}
