package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.ValueSet;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.ValueSet.ConceptPropertyComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionPropertyComponent;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

public class ValueSet43_N {

  public static org.hl7.fhir.model.core.ValueSet convertValueSet(org.hl7.fhir.r4b.model.ValueSet src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet tgt = new org.hl7.fhir.model.core.ValueSet();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_VERSION_ALGORITHM);
    if (tgt.hasImplicitRules() && VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE.equals(tgt.getImplicitRules())) {
      // the marker recorded that filter operators were omitted on the way down to R4; they are 
      // restored from the inter-version extension below, so the marker no longer applies
      tgt.setImplicitRulesElement(null);
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getExtensionByUrl(VersionConvertorConstants.EXT_VERSION_ALGORITHM).getValue()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasImmutable())
      tgt.setImmutableElement(Boolean43_N.convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCompose())
      tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
    if (src.hasExpansion())
      tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet convertValueSet(org.hl7.fhir.model.core.ValueSet src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet tgt = new org.hl7.fhir.r4b.model.ValueSet();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasVersionAlgorithm()) {
      tgt.addExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM,
        ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getVersionAlgorithm()));
    }
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasImmutable())
      tgt.setImmutableElement(Boolean43_N.convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCompose()) {
      tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
      if (hasOmittedFilterOp(tgt.getCompose())) {
        // at least one filter operator could not be represented in R4 - see convertFilterOperator. 
        // Readers that don't understand the omission must not process the resource
        tgt.setImplicitRules(VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE);
      }
    }
    if (src.hasExpansion())
      tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
    return tgt;
  }

  private static boolean hasOmittedFilterOp(org.hl7.fhir.r4b.model.ValueSet.ValueSetComposeComponent compose) {
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent gc : compose.getInclude())
      if (hasOmittedFilterOp(gc))
        return true;
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent gc : compose.getExclude())
      if (hasOmittedFilterOp(gc))
        return true;
    return false;
  }

  private static boolean hasOmittedFilterOp(org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent inc) {
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent f : inc.getFilter())
      if (f.getOpElement().hasExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP) || f.getOpElement().hasExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP_R6))
        return true;
    return false;
  }

  public static org.hl7.fhir.model.core.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r4b.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.model.core.ValueSet.ValueSetComposeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_VS_COMPOSE_PROPERTY);
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Date43_N.convertDate(src.getLockedDateElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_N.convertBoolean(src.getInactiveElement()));
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent t : src.getInclude())
      tgt.addInclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent t : src.getExclude())
      tgt.addExclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VS_COMPOSE_PROPERTY)) {
      if (ex.hasValue() && ex.getValue() instanceof org.hl7.fhir.r4b.model.StringType)
        tgt.getPropertyList().add(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) ex.getValue()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.model.core.ValueSet.ValueSetComposeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ValueSetComposeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLockedDate())
      tgt.setLockedDateElement(Date43_N.convertDate(src.getLockedDateElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_N.convertBoolean(src.getInactiveElement()));
    for (org.hl7.fhir.model.core.ValueSet.ConceptSetComponent t : src.getIncludeList())
      tgt.addInclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.model.core.ValueSet.ConceptSetComponent t : src.getExcludeList())
      tgt.addExclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.model.core.StringType t : src.getPropertyList())
      tgt.addExtension(VersionConvertorConstants.EXT_VS_COMPOSE_PROPERTY, String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.model.core.ValueSet.ConceptSetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_VS_INCLUDE_COPYRIGHT);
    if (src.hasSystem())
      tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getValueSet())
      tgt.getValueSetList().add(Canonical43_N.convertCanonical(t));
    if (src.hasExtension(VersionConvertorConstants.EXT_VS_INCLUDE_COPYRIGHT))
      tgt.setCopyright(src.getExtensionString(VersionConvertorConstants.EXT_VS_INCLUDE_COPYRIGHT));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.model.core.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ConceptSetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    for (org.hl7.fhir.model.core.ValueSet.ConceptReferenceComponent t : src.getConceptList())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent t : src.getFilterList())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getValueSetList())
      tgt.getValueSet().add(Canonical43_N.convertCanonical(t));
    if (src.hasCopyright())
      tgt.addExtension(VersionConvertorConstants.EXT_VS_INCLUDE_COPYRIGHT, new org.hl7.fhir.r4b.model.StringType(src.getCopyright()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.model.core.ValueSet.ConceptReferenceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.model.core.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignationList())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_VS_DESIGNATION_ADDITIONAL_USE);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding43_N.convertCoding(src.getUse()));
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VS_DESIGNATION_ADDITIONAL_USE)) {
      if (ex.hasValue() && ex.getValue() instanceof org.hl7.fhir.r4b.model.Coding)
        tgt.addAdditionalUse(Coding43_N.convertCoding((org.hl7.fhir.r4b.model.Coding) ex.getValue()));
    }
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceDesignationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding43_N.convertCoding(src.getUse()));
    for (org.hl7.fhir.model.core.Coding t : src.getAdditionalUseList())
      tgt.addExtension(VersionConvertorConstants.EXT_VS_DESIGNATION_ADDITIONAL_USE, Coding43_N.convertCoding(t));
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_VALUESET_FILTER_FILTER);
    if (src.hasProperty())
      tgt.setPropertyElement(Code43_N.convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOpElement(convertFilterOperator(src.getOpElement()));
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl(VersionConvertorConstants.EXT_VALUESET_FILTER_FILTER))
      tgt.addFilter(convertNestedFilter(ex));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ConceptSetFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(Code43_N.convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOpElement(convertFilterOperator(src.getOpElement()));
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    for (org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent t : src.getFilterList())
      tgt.addExtension(convertNestedFilterToExtension(t, VersionConvertorConstants.EXT_VALUESET_FILTER_FILTER));
    return tgt;
  }

  private static org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent convertNestedFilter(org.hl7.fhir.r4b.model.Extension src) throws FHIRException {
    // a nested filter (introduced in R6), reconstituted from the inter-version extension - see 
    // convertNestedFilterToExtension
    org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent();
    if (src.hasExtension("property"))
      tgt.setProperty(src.getExtensionString("property"));
    if (src.hasExtension("op"))
      tgt.setOp(Enumerations.FilterOperator.fromCode(src.getExtensionString("op")));
    if (src.hasExtension("value"))
      tgt.setValue(src.getExtensionString("value"));
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl("filter"))
      tgt.addFilter(convertNestedFilter(ex));
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Extension convertNestedFilterToExtension(org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent src, String url) throws FHIRException {
    // R4 has no equivalent for nested filters (introduced in R6), so the whole filter is moved to 
    // an inter-version extension, with sub-extensions named for the child elements, recursively. 
    // Note that the filter itself is 0..*, so no implicitRules marking - nothing mandatory is omitted
    org.hl7.fhir.r4b.model.Extension ext = new org.hl7.fhir.r4b.model.Extension(url);
    if (src.hasProperty())
      ext.addExtension("property", new org.hl7.fhir.r4b.model.CodeType(src.getProperty()));
    if (src.hasOp())
      ext.addExtension("op", new org.hl7.fhir.r4b.model.CodeType(src.getOp().toCode()));
    if (src.hasValue())
      ext.addExtension("value", new org.hl7.fhir.r4b.model.StringType(src.getValue()));
    for (org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent t : src.getFilterList())
      ext.addExtension(convertNestedFilterToExtension(t, "filter"));
    return ext;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FilterOperator> tgt = new Enumeration<>(new Enumerations.FilterOperatorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, VersionConvertorConstants.EXT_VALUESET_FILTER_OP, VersionConvertorConstants.EXT_VALUESET_FILTER_OP_R6);
      if (src.hasExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP)) {
        tgt.setValue(Enumerations.FilterOperator.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_VALUESET_FILTER_OP)));
      } else if (src.hasExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP_R6)) {
        tgt.setValue(Enumerations.FilterOperator.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_VALUESET_FILTER_OP_R6)));
      } else if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUAL:
                  tgt.setValue(Enumerations.FilterOperator.EQUAL);
                  break;
              case ISA:
                  tgt.setValue(Enumerations.FilterOperator.ISA);
                  break;
              case DESCENDENTOF:
                  tgt.setValue(Enumerations.FilterOperator.DESCENDENTOF);
                  break;
              case ISNOTA:
                  tgt.setValue(Enumerations.FilterOperator.ISNOTA);
                  break;
              case REGEX:
                  tgt.setValue(Enumerations.FilterOperator.REGEX);
                  break;
              case IN:
                  tgt.setValue(Enumerations.FilterOperator.IN);
                  break;
              case NOTIN:
                  tgt.setValue(Enumerations.FilterOperator.NOTIN);
                  break;
              case GENERALIZES:
                  tgt.setValue(Enumerations.FilterOperator.GENERALIZES);
                  break;
              case EXISTS:
                  tgt.setValue(Enumerations.FilterOperator.EXISTS);
                  break;
              default:
                  tgt.setValue(Enumerations.FilterOperator.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FilterOperator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FilterOperatorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.EQUAL);
                  break;
              case ISA:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.ISA);
                  break;
              case DESCENDENTOF:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.DESCENDENTOF);
                  break;
              case ISNOTA:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.ISNOTA);
                  break;
              case REGEX:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.REGEX);
                  break;
              case IN:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.IN);
                  break;
              case NOTIN:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.NOTIN);
                  break;
              case GENERALIZES:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.GENERALIZES);
                  break;
              case CHILDOF:
                tgt.addExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP, new org.hl7.fhir.r4b.model.CodeType("child-of"));
                break;
              case DESCENDENTLEAF:
                tgt.addExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP, new org.hl7.fhir.r4b.model.CodeType("descendent-leaf"));
                break;
              case PROPERTYVALUEOF:
                tgt.addExtension(VersionConvertorConstants.EXT_VALUESET_FILTER_OP_R6, new org.hl7.fhir.r4b.model.CodeType("property-value-of"));
                break;
              case EXISTS:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.EXISTS);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FilterOperator.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_VS_EXP_PROP);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(Uri43_N.convertUri(src.getIdentifierElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(DateTime43_N.convertDateTime(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(Integer43_N.convertInteger(src.getTotalElement()));
    if (src.hasOffset())
      tgt.setOffsetElement(Integer43_N.convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (org.hl7.fhir.r4b.model.Extension t : src.getExtension()) {
      if (VersionConvertorConstants.EXT_VS_EXP_PROP.equals(t.getUrl())) {
        ValueSetExpansionPropertyComponent tt = tgt.addProperty();
        if (t.hasExtension("code")) {
          tt.setCode(t.getExtensionString("code"));
        }
        if (t.hasExtension("uri")) {
          tt.setUri(t.getExtensionString("uri"));
        }
      }
    }
    for (org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifierElement(Uri43_N.convertUri(src.getIdentifierElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(DateTime43_N.convertDateTime(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(Integer43_N.convertInteger(src.getTotalElement()));
    if (src.hasOffset())
      tgt.setOffsetElement(Integer43_N.convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent t : src.getParameterList())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (ValueSetExpansionPropertyComponent t : src.getPropertyList()) {
      org.hl7.fhir.r4b.model.Extension ext = tgt.addExtension().setUrl(VersionConvertorConstants.EXT_VS_EXP_PROP);
      ext.addExtension().setUrl("code").setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(t.getCodeElement()));
      ext.addExtension().setUrl("uri").setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(t.getUriElement()));
    }
    for (org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent t : src.getContainsList())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.model.core.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_EXP_VS_CONT_PROP);
    if (src.hasSystem())
      tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean43_N.convertBoolean(src.getAbstractElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_N.convertBoolean(src.getInactiveElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4b.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    for (org.hl7.fhir.r4b.model.Extension t : src.getExtension()) {
      if (VersionConvertorConstants.EXT_EXP_VS_CONT_PROP.equals(t.getUrl())) {
        ConceptPropertyComponent prop = tgt.addProperty();
        ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(t, prop, "code", "value[x]", "value", "subProperty");
        prop.setCode(t.getExtensionString("code"));
        if (t.hasExtension("value")) {
          prop.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(t.getExtensionByUrl("value").getValue()));
        } else if (t.hasExtension("value[x]")) {
          prop.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(t.getExtensionByUrl("value[x]").getValue()));
        }
        for (org.hl7.fhir.r4b.model.Extension spx : t.getExtensionsByUrl("subProperty")) {
          org.hl7.fhir.model.core.ValueSet.ConceptSubPropertyComponent sp = prop.addSubProperty();
          sp.setCode(spx.getExtensionString("code"));
          if (spx.hasExtension("value"))
            sp.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(spx.getExtensionByUrl("value").getValue()));
        }
      }
    }
    for (org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r4b.model.ValueSet.ValueSetExpansionContainsComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(Uri43_N.convertUri(src.getSystemElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean43_N.convertBoolean(src.getAbstractElement()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_N.convertBoolean(src.getInactiveElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.model.core.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignationList())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    for (org.hl7.fhir.model.core.ValueSet.ConceptPropertyComponent t : src.getPropertyList()) {
      org.hl7.fhir.r4b.model.Extension ext = tgt.addExtension().setUrl(VersionConvertorConstants.EXT_EXP_VS_CONT_PROP);
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(t, ext, "code", "value");
      ext.addExtension().setUrl("code").setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(t.getCodeElement()));
      ext.addExtension().setUrl("value").setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(t.getValue()));
      for (org.hl7.fhir.model.core.ValueSet.ConceptSubPropertyComponent sp : t.getSubPropertyList()) {
        org.hl7.fhir.r4b.model.Extension spx = ext.addExtension().setUrl("subProperty");
        spx.addExtension().setUrl("code").setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(sp.getCodeElement()));
        spx.addExtension().setUrl("value").setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(sp.getValue()));
      }
    }
    for (org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent t : src.getContainsList())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }
}