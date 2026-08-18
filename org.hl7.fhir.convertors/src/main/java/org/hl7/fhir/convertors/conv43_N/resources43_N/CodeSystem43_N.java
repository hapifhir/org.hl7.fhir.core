package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.stream.Collectors;

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
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class CodeSystem43_N {

  public static org.hl7.fhir.model.core.CodeSystem convertCodeSystem(org.hl7.fhir.r4b.model.CodeSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeSystem tgt = new org.hl7.fhir.model.core.CodeSystem();
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCaseSensitive())
      tgt.setCaseSensitiveElement(Boolean43_N.convertBoolean(src.getCaseSensitiveElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    if (src.hasHierarchyMeaning())
      tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_N.convertBoolean(src.getCompositionalElement()));
    if (src.hasVersionNeeded())
      tgt.setVersionNeededElement(Boolean43_N.convertBoolean(src.getVersionNeededElement()));
    if (src.hasContent())
      tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
    if (src.hasSupplements())
      tgt.setSupplementsElement(Canonical43_N.convertCanonical(src.getSupplementsElement()));
    if (src.hasCount())
      tgt.setCountElement(UnsignedInt43_N.convertUnsignedInt(src.getCountElement()));
    for (org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter())
      tgt.addFilter(convertCodeSystemFilterComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent t : src.getProperty())
      tgt.addProperty(convertPropertyComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem convertCodeSystem(org.hl7.fhir.model.core.CodeSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem tgt = new org.hl7.fhir.r4b.model.CodeSystem();
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCaseSensitive())
      tgt.setCaseSensitiveElement(Boolean43_N.convertBoolean(src.getCaseSensitiveElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    if (src.hasHierarchyMeaning())
      tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
    if (src.hasCompositional())
      tgt.setCompositionalElement(Boolean43_N.convertBoolean(src.getCompositionalElement()));
    if (src.hasVersionNeeded())
      tgt.setVersionNeededElement(Boolean43_N.convertBoolean(src.getVersionNeededElement()));
    if (src.hasContent())
      tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
    if (src.hasSupplements())
      tgt.setSupplementsElement(Canonical43_N.convertCanonical(src.getSupplementsElement()));
    if (src.hasCount())
      tgt.setCountElement(UnsignedInt43_N.convertUnsignedInt(src.getCountElement()));
    for (org.hl7.fhir.model.core.CodeSystem.CodeSystemFilterComponent t : src.getFilterList()) {
      org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent f = convertCodeSystemFilterComponent(t);
      tgt.addFilter(f);
      if (f.hasExtension(VersionConvertorConstants.EXT_CS_FILTER_OPERATOR) || f.hasExtension(VersionConvertorConstants.EXT_CS_FILTER_OPERATOR_R5)) {
        // at least one filter operator could not be represented in R4 - see the filter component 
        // converter. Readers that don't understand the omission must not process the resource
        tgt.setImplicitRules(VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE);
      }
    }
    for (org.hl7.fhir.model.core.CodeSystem.PropertyComponent t : src.getPropertyList())
      tgt.addProperty(convertPropertyComponent(t));
    for (org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent t : src.getConceptList())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CodeSystem.CodeSystemHierarchyMeaning> tgt = new Enumeration<>(new CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case GROUPEDBY:
                  tgt.setValue(CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
                  break;
              case ISA:
                  tgt.setValue(CodeSystem.CodeSystemHierarchyMeaning.ISA);
                  break;
              case PARTOF:
                  tgt.setValue(CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
                  break;
              case CLASSIFIEDWITH:
                  tgt.setValue(CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
                  break;
              default:
                  tgt.setValue(CodeSystem.CodeSystemHierarchyMeaning.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case GROUPEDBY:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
                  break;
              case ISA:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.ISA);
                  break;
              case PARTOF:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
                  break;
              case CLASSIFIEDWITH:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemHierarchyMeaning.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.CodeSystemContentMode> tgt = new Enumeration<>(new Enumerations.CodeSystemContentModeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTPRESENT:
                  tgt.setValue(Enumerations.CodeSystemContentMode.NOTPRESENT);
                  break;
              case EXAMPLE:
                  tgt.setValue(Enumerations.CodeSystemContentMode.EXAMPLE);
                  break;
              case FRAGMENT:
                  tgt.setValue(Enumerations.CodeSystemContentMode.FRAGMENT);
                  break;
              case COMPLETE:
                  tgt.setValue(Enumerations.CodeSystemContentMode.COMPLETE);
                  break;
              case SUPPLEMENT:
                  tgt.setValue(Enumerations.CodeSystemContentMode.SUPPLEMENT);
                  break;
              default:
                  tgt.setValue(Enumerations.CodeSystemContentMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentModeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTPRESENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                  break;
              case EXAMPLE:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
                  break;
              case FRAGMENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                  break;
              case COMPLETE:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                  break;
              case SUPPLEMENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.SUPPLEMENT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemContentMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.model.core.CodeSystem.CodeSystemFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_CS_FILTER_OPERATOR, VersionConvertorConstants.EXT_CS_FILTER_OPERATOR_R5);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    tgt.setOperatorList(src.getOperator().stream()
      .map(CodeSystem43_N::convertFilterOperator)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl(VersionConvertorConstants.EXT_CS_FILTER_OPERATOR_R5)) {
      // an operator introduced in R5, parked on this extension by the R6->R4 conversion
      if (ex.hasValue()) {
        tgt.addOperator(org.hl7.fhir.model.core.Enumerations.FilterOperator.fromCode(ex.getValue().primitiveValue()));
      }
    }
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl(VersionConvertorConstants.EXT_CS_FILTER_OPERATOR)) {
      // an operator introduced in R6, parked on this extension by the R6->R4 conversion
      if (ex.hasValue()) {
        tgt.addOperator(org.hl7.fhir.model.core.Enumerations.FilterOperator.fromCode(ex.getValue().primitiveValue()));
      }
    }
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.model.core.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.CodeSystemFilterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (Enumeration<Enumerations.FilterOperator> t : src.getOperatorList()) {
      if (t.getValue() == null || isR4FilterOperator(t.getValue())) {
        tgt.getOperator().add(convertFilterOperator(t));
      } else if (t.getValue() == Enumerations.FilterOperator.CHILDOF || t.getValue() == Enumerations.FilterOperator.DESCENDENTLEAF) {
        // this operator doesn't exist in R4 but was introduced in R5: park it on the 5.0 
        // inter-version extension, and the resource-level converter marks the resource with 
        // implicitRules because a mandatory element value has been omitted
        tgt.addExtension(VersionConvertorConstants.EXT_CS_FILTER_OPERATOR_R5, new org.hl7.fhir.r4b.model.CodeType(t.getValue().toCode()));
      } else {
        // this operator was introduced in R6: park it on the 6.0 inter-version extension, and 
        // mark with implicitRules as above
        tgt.addExtension(VersionConvertorConstants.EXT_CS_FILTER_OPERATOR, new org.hl7.fhir.r4b.model.CodeType(t.getValue().toCode()));
      }
    }
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;

  }

  private static boolean isR4FilterOperator(Enumerations.FilterOperator op) {
    switch (op) {
      case EQUAL:
      case ISA:
      case DESCENDENTOF:
      case ISNOTA:
      case REGEX:
      case IN:
      case NOTIN:
      case GENERALIZES:
      case EXISTS:
        return true;
      default:
        return false;
    }
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FilterOperator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FilterOperator> tgt = new Enumeration<>(new Enumerations.FilterOperatorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
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

  public static org.hl7.fhir.model.core.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.model.core.CodeSystem.PropertyComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.model.core.CodeSystem.PropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.PropertyComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.PropertyType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CodeSystem.PropertyType> tgt = new Enumeration<>(new CodeSystem.PropertyTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CODE:
                  tgt.setValue(CodeSystem.PropertyType.CODE);
                  break;
              case CODING:
                  tgt.setValue(CodeSystem.PropertyType.CODING);
                  break;
              case STRING:
                  tgt.setValue(CodeSystem.PropertyType.STRING);
                  break;
              case INTEGER:
                  tgt.setValue(CodeSystem.PropertyType.INTEGER);
                  break;
              case BOOLEAN:
                  tgt.setValue(CodeSystem.PropertyType.BOOLEAN);
                  break;
              case DATETIME:
                  tgt.setValue(CodeSystem.PropertyType.DATETIME);
                  break;
              case DECIMAL:
                  tgt.setValue(CodeSystem.PropertyType.DECIMAL);
                  break;
              default:
                  tgt.setValue(CodeSystem.PropertyType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CodeSystem.PropertyType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CodeSystem.PropertyTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CODE:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.CODE);
                  break;
              case CODING:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.CODING);
                  break;
              case STRING:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.STRING);
                  break;
              case INTEGER:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.INTEGER);
                  break;
              case BOOLEAN:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.BOOLEAN);
                  break;
              case DATETIME:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.DATETIME);
                  break;
              case DECIMAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.DECIMAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.CodeSystem.PropertyType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(String43_N.convertString(src.getDefinitionElement()));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent t : src.getProperty())
      tgt.addProperty(convertConceptPropertyComponent(t));
    for (org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(String43_N.convertString(src.getDefinitionElement()));
    for (org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignationList())
      tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
    for (org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent t : src.getPropertyList())
      tgt.addProperty(convertConceptPropertyComponent(t));
    for (org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent t : src.getConceptList())
      tgt.addConcept(convertConceptDefinitionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionDesignationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_CS_DESIGNATION_ADDITIONAL_USE);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding43_N.convertCoding(src.getUse()));
    for (org.hl7.fhir.r4b.model.Extension ex : src.getExtensionsByUrl(VersionConvertorConstants.EXT_CS_DESIGNATION_ADDITIONAL_USE)) {
      if (ex.hasValue() && ex.getValue() instanceof org.hl7.fhir.r4b.model.Coding)
        tgt.addAdditionalUse(Coding43_N.convertCoding((org.hl7.fhir.r4b.model.Coding) ex.getValue()));
    }
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.ConceptDefinitionDesignationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding43_N.convertCoding(src.getUse()));
    for (org.hl7.fhir.model.core.Coding t : src.getAdditionalUseList())
      tgt.addExtension(VersionConvertorConstants.EXT_CS_DESIGNATION_ADDITIONAL_USE, Coding43_N.convertCoding(t));
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r4b.model.CodeSystem.ConceptPropertyComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }
}