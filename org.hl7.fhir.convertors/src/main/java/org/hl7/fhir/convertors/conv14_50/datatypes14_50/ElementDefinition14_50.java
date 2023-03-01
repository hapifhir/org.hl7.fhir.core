package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Coding14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Boolean14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Id14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Integer14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.MarkDown14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.convertors.conv14_50.resources14_50.Enumerations14_50;
import org.hl7.fhir.dstu2016may.model.ElementDefinition;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.utilities.Utilities;

public class ElementDefinition14_50 {
  public static org.hl7.fhir.r5.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2016may.model.ElementDefinition src, List<ElementDefinition> context, int pos) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ElementDefinition tgt = new org.hl7.fhir.r5.model.ElementDefinition();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String14_50.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition14_50::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasName()) tgt.setSliceNameElement(String14_50.convertString(src.getNameElement()));
    if (src.hasLabel()) tgt.setLabelElement(String14_50.convertString(src.getLabelElement()));
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addCode(Coding14_50.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
    if (src.hasShort()) tgt.setShortElement(String14_50.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown14_50.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComments()) tgt.setCommentElement(MarkDown14_50.convertMarkdown(src.getCommentsElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown14_50.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    if (src.hasMin()) tgt.setMin(src.getMin());
    if (src.hasMax()) tgt.setMaxElement(String14_50.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri14_50.convertUri(src.getContentReferenceElement()));
    // work around for problem in R2B definitions:
    if (!src.hasContentReference()) {
      for (ElementDefinition.TypeRefComponent t : src.getType())
        convertTypeRefComponent(t, tgt.getType());
      if (src.hasDefaultValue())
        tgt.setDefaultValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getDefaultValue()));
      if (src.hasMeaningWhenMissing())
        tgt.setMeaningWhenMissingElement(MarkDown14_50.convertMarkdown(src.getMeaningWhenMissingElement()));
      if (src.hasFixed())
        tgt.setFixed(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getFixed()));
      if (src.hasPattern())
        tgt.setPattern(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getPattern()));
      if (src.hasExample())
        tgt.addExample().setLabel("General").setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getExample()));
      if (src.hasMinValue())
        tgt.setMinValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getMinValue()));
      if (src.hasMaxValue())
        tgt.setMaxValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getMaxValue()));
      if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer14_50.convertInteger(src.getMaxLengthElement()));
      for (org.hl7.fhir.dstu2016may.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
      for (ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
        tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
      if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean14_50.convertBoolean(src.getMustSupportElement()));
      if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean14_50.convertBoolean(src.getIsModifierElement()));
      if (tgt.getIsModifier()) {
        String reason = org.hl7.fhir.dstu2016may.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
        if (Utilities.noString(reason)) reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
        tgt.setIsModifierReason(reason);
      }
      if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean14_50.convertBoolean(src.getIsSummaryElement()));
      if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
      for (ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
        tgt.addMapping(convertElementDefinitionMappingComponent(t));
    }
    return tgt;
  }

  public static ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition tgt = new ElementDefinition();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String14_50.convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream().map(ElementDefinition14_50::convertPropertyRepresentation).collect(Collectors.toList()));
    if (src.hasSliceName()) tgt.setNameElement(String14_50.convertString(src.getSliceNameElement()));
    if (src.hasLabel()) tgt.setLabelElement(String14_50.convertString(src.getLabelElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding14_50.convertCoding(t));
    if (src.hasSlicing()) tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort()) tgt.setShortElement(String14_50.convertString(src.getShortElement()));
    if (src.hasDefinition()) tgt.setDefinitionElement(MarkDown14_50.convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment()) tgt.setCommentsElement(MarkDown14_50.convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(MarkDown14_50.convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    if (src.hasMin()) tgt.setMin(src.getMin());
    if (src.hasMax()) tgt.setMaxElement(String14_50.convertString(src.getMaxElement()));
    if (src.hasBase()) tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(Uri14_50.convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType())
      convertTypeRefComponent(t, tgt.getType());
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(MarkDown14_50.convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasFixed())
      tgt.setFixed(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getPattern()));
    if (src.hasExample())
      tgt.setExample(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getExample().get(0).getValue()));
    if (src.hasMinValue())
      tgt.setMinValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getMaxValue()));
    if (src.hasMaxLength()) tgt.setMaxLengthElement(Integer14_50.convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r5.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport()) tgt.setMustSupportElement(Boolean14_50.convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier()) tgt.setIsModifierElement(Boolean14_50.convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
      org.hl7.fhir.dstu2016may.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
    if (src.hasIsSummary()) tgt.setIsSummaryElement(Boolean14_50.convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding()) tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.NULL);
    } else {
      switch (src.getValue()) {
        case XMLATTR:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLATTR);
          break;
        case XMLTEXT:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
          break;
        case TYPEATTR:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
          break;
        case CDATEXT:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.CDATEXT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.PropertyRepresentationEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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
  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(ElementDefinition.ElementDefinitionSlicingComponent src, List<ElementDefinition> context, int pos) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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
          String suffix = StringUtils.substringAfter(existsPath, "(").substring(1);
          existsPath = StringUtils.substringBefore(existsPath, "(");
          suffix = StringUtils.substringBefore(suffix, ")");
          url = suffix.substring(0, suffix.length() - 1);
        }
        for (int i = pos + 1; i < context.size(); i++) {
          ElementDefinition e = context.get(i);
          if (e.getPath().equals(slicingElement.getPath())) slices++;
          else if (!e.getPath().startsWith(slicingElement.getPath() + ".")) break;
          else if (e.getPath().equals(existsPath)) {
            if (url == null || (e.getType().get(0).hasProfile() && e.getType().get(0).getProfile().get(0).equals(url))) {
              if (e.hasMin() && e.getMin() > 0 && !e.hasFixed()) existsSlicePresent = true;
              else if (e.hasMax() && e.getMax().equals("0")) notExistsSlicePresent = true;
            }
          }
        }
        isExists = (slices == 2 && existsSlicePresent && notExistsSlicePresent) || (slices == 1 && existsSlicePresent != notExistsSlicePresent);
      }
      tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue(), isExists));
    }
    if (src.hasDescription()) tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean14_50.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionSlicingComponent tgt = new ElementDefinition.ElementDefinitionSlicingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
    if (src.hasDescription()) tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
    if (src.hasOrdered()) tgt.setOrderedElement(Boolean14_50.convertBoolean(src.getOrderedElement()));
    if (src.hasRules()) tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.NULL);
    } else {
      switch (src.getValue()) {
        case CLOSED:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.CLOSED);
          break;
        case OPEN:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPEN);
          break;
        case OPENATEND:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPENATEND);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.SlicingRulesEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String14_50.convertString(src.getPathElement()));
    tgt.setMin(src.getMin());
    if (src.hasMaxElement()) tgt.setMaxElement(String14_50.convertString(src.getMaxElement()));
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionBaseComponent tgt = new ElementDefinition.ElementDefinitionBaseComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasPathElement()) tgt.setPathElement(String14_50.convertString(src.getPathElement()));
    tgt.setMin(src.getMin());
    if (src.hasMaxElement()) tgt.setMaxElement(String14_50.convertString(src.getMaxElement()));
    return tgt;
  }

  static public void convertTypeRefComponent(ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
    if (src == null) return;
    org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent tgt = null;
    for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : list)
      if (t.getCode().equals(src.getCode())) tgt = t;
    if (tgt == null) {
      tgt = new org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent();
      list.add(tgt);
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      tgt.setCodeElement(Code14_50.convertCodeToUri(src.getCodeElement()));
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
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
      if (!tgt.hasAggregation(a.getValue()))
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(t, tgt.addAggregation(a.getValue()));
    }
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
  }

  public static void convertTypeRefComponent(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent src, List<ElementDefinition.TypeRefComponent> list) throws FHIRException {
    if (src == null) return;
    ElementDefinition.TypeRefComponent tgt = new ElementDefinition.TypeRefComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    list.add(tgt);
    if (src.hasTarget()) {
      for (org.hl7.fhir.r5.model.UriType u : src.getProfile()) {
        org.hl7.fhir.dstu2016may.model.Extension t = new org.hl7.fhir.dstu2016may.model.Extension(VersionConvertorConstants.PROFILE_EXTENSION);
        t.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(u));
        tgt.addExtension(t);
      }
      for (org.hl7.fhir.r5.model.UriType u : src.getTargetProfile()) {
        if (!u.equals(src.getTargetProfile().get(0))) {
          tgt = tgt.copy();
          tgt.getProfile().clear();
          list.add(tgt);
        }
        tgt.addProfile(u.getValue());
      }
    } else {
      for (org.hl7.fhir.r5.model.UriType u : src.getProfile()) {
        tgt.addProfile(u.getValue());
      }
    }
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
      org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> a = convertAggregationMode(t);
      if (!tgt.hasAggregation(a.getValue()))
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(t, tgt.addAggregationElement().setValue(a.getValue()));
    }
    if (src.hasVersioning()) tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.AggregationModeEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.NULL);
    } else {
      switch (src.getValue()) {
        case CONTAINED:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.CONTAINED);
          break;
        case REFERENCED:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.REFERENCED);
          break;
        case BUNDLED:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.BUNDLED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.AggregationModeEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.NULL);
    } else {
      switch (src.getValue()) {
        case EITHER:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.EITHER);
          break;
        case INDEPENDENT:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
          break;
        case SPECIFIC:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.ReferenceVersionRulesEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasKeyElement()) tgt.setKeyElement(Id14_50.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String14_50.convertStringToMarkdown(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHumanElement()) tgt.setHumanElement(String14_50.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpression(convertToR4Expression(src.getExpression()));
    if (src.hasXpath()) {
      tgt.addExtension(new org.hl7.fhir.r5.model.Extension(org.hl7.fhir.r5.utils.ToolingExtensions.EXT_XPATH_CONSTRAINT, new org.hl7.fhir.r5.model.StringType(src.getXpath())));
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionConstraintComponent tgt = new ElementDefinition.ElementDefinitionConstraintComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt, org.hl7.fhir.r5.utils.ToolingExtensions.EXT_XPATH_CONSTRAINT);
    if (src.hasKeyElement()) tgt.setKeyElement(Id14_50.convertId(src.getKeyElement()));
    if (src.hasRequirements()) tgt.setRequirementsElement(String14_50.convertString(src.getRequirementsElement()));
    if (src.hasSeverity()) tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHumanElement()) tgt.setHumanElement(String14_50.convertString(src.getHumanElement()));
    if (src.hasExpression()) tgt.setExpression(convertTo2016MayExpression(src.getExpression()));
    if (org.hl7.fhir.r5.utils.ToolingExtensions.hasExtension(src, org.hl7.fhir.r5.utils.ToolingExtensions.EXT_XPATH_CONSTRAINT)) {
      tgt.setXpath(org.hl7.fhir.r5.utils.ToolingExtensions.readStringExtension(src, org.hl7.fhir.r5.utils.ToolingExtensions.EXT_XPATH_CONSTRAINT));
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.NULL);
    } else {
      switch (src.getValue()) {
        case ERROR:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.ERROR);
          break;
        case WARNING:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.WARNING);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new ElementDefinition.ConstraintSeverityEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations14_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String14_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasValueSet()) {
      org.hl7.fhir.r5.model.DataType t = ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValueSet());
      if (t instanceof org.hl7.fhir.r5.model.Reference)
        tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
      else tgt.setValueSet(t.primitiveValue());
      tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
    }
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionBindingComponent tgt = new ElementDefinition.ElementDefinitionBindingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasStrength()) tgt.setStrengthElement(Enumerations14_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
    if (src.hasValueSet()) {
      String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
      if (vsr != null) tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.UriType(vsr));
      else tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.Reference(src.getValueSet()));
    }
    return tgt;
  }

  public static String convertToR4Expression(String oldExpression) {
    String pass1 = oldExpression.replaceAll("\\$context", "%context").replaceAll("\\$resource", "%resource").replaceAll("code\\+profile", "code&profile").replaceAll("path\\+'\\.'", "path&'.'").replaceAll("fullUrl\\+resource", "fullUrl&resource");
    String pass2 = pass1;
    if (pass1.endsWith(".distinct()")) pass2 = pass1.substring(0, pass2.length() - 11) + ".isDistinct()";
    String pass3 = pass2;
    if (pass2.endsWith(".empty() or (type.count() = 1)"))
      pass3 = pass2.substring(0, pass2.length() - 30) + ".empty() or (type.count() <= 1)";
    String pass4 = pass3;
    if (pass3.equals("duration >= 0")) pass4 = "duration.exists() implies duration >= 0";
    else if (pass3.equals("period >= 0")) pass4 = "period.exists() implies period >= 0";
    else if (pass3.equals("fullUrl.empty() xor resource")) pass4 = "fullUrl.empty() xor resource.exists()";
    return pass4;
  }

  public static String convertTo2016MayExpression(String newExpression) {
    String pass1 = newExpression.replaceAll("%context", "\\$context").replaceAll("%resource", "\\$resource").replaceAll("code&profile", "code+profile").replaceAll("path&'\\.'", "path+'.'").replaceAll("fullUrl%resource", "fullUrl+resource");
    String pass2 = pass1;
    if (pass1.endsWith(".isDistinct()")) pass2 = pass1.substring(0, pass1.length() - 13) + ".distinct()";
    String pass3 = pass2;
    if (pass2.endsWith(".empty() or (type.count() <= 1)"))
      pass3 = pass2.substring(0, pass2.length() - 31) + ".empty() or (type.count() = 1)";
    String pass4 = pass3;
    if (pass3.equals("duration.exists() implies duration >= 0")) pass4 = "duration >= 0";
    else if (pass3.equals("period.exists() implies period >= 0")) pass4 = "period >= 0";
    else if (pass3.equals("fullUrl.empty() xor resource.exists()")) pass4 = "fullUrl.empty() xor resource";
    return pass4;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasIdentityElement()) tgt.setIdentityElement(Id14_50.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_50.convertCode(src.getLanguageElement()));
    if (src.hasMapElement()) tgt.setMapElement(String14_50.convertString(src.getMapElement()));
    return tgt;
  }

  public static ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ElementDefinition.ElementDefinitionMappingComponent tgt = new ElementDefinition.ElementDefinitionMappingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasIdentityElement()) tgt.setIdentityElement(Id14_50.convertId(src.getIdentityElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code14_50.convertCode(src.getLanguageElement()));
    if (src.hasMapElement()) tgt.setMapElement(String14_50.convertString(src.getMapElement()));
    return tgt;
  }
}
