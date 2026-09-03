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
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.ElementDefinition43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.StructureDefinition;

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

public class StructureDefinition43_N {

  public static org.hl7.fhir.model.core.StructureDefinition convertStructureDefinition(org.hl7.fhir.r4b.model.StructureDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.StructureDefinition tgt = new org.hl7.fhir.model.core.StructureDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_VERSION_ALGORITHM);
    if (tgt.hasImplicitRules() && VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE.equals(tgt.getImplicitRules())) {
      // the marker recorded that discriminator types were omitted on the way down to R4; they are 
      // restored from the inter-version extension (see ElementDefinition43_N.convertDiscriminatorType), 
      // so the marker no longer applies
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
    for (org.hl7.fhir.r4b.model.Coding t : src.getKeyword()) tgt.addKeyword(Coding43_N.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Enumerations43_N.convertFHIRVersion(src.getFhirVersionElement()));
    for (org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean43_N.convertBoolean(src.getAbstractElement()));
    for (org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext())
      tgt.addContext(convertStructureDefinitionContextComponent(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getContextInvariant())
      tgt.getContextInvariantList().add(String43_N.convertString(t));
    if (src.hasType())
      tgt.setTypeElement(Uri43_N.convertUri(src.getTypeElement()));
    if (src.hasBaseDefinition())
      tgt.setBaseDefinitionElement(Canonical43_N.convertCanonical(src.getBaseDefinitionElement()));
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
    if (src.hasSnapshot())
      tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
    if (src.hasDifferential())
      tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.model.core.StructureDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition tgt = new org.hl7.fhir.r4b.model.StructureDefinition();
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
    for (org.hl7.fhir.model.core.Coding t : src.getKeywordList()) tgt.addKeyword(Coding43_N.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Enumerations43_N.convertFHIRVersion(src.getFhirVersionElement()));
    for (org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionMappingComponent t : src.getMappingList())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean43_N.convertBoolean(src.getAbstractElement()));
    for (org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionContextComponent t : src.getContextList())
      tgt.addContext(convertStructureDefinitionContextComponent(t));
    for (org.hl7.fhir.model.core.StringType t : src.getContextInvariantList())
      tgt.getContextInvariant().add(String43_N.convertString(t));
    if (src.hasType())
      tgt.setTypeElement(Uri43_N.convertUri(src.getTypeElement()));
    if (src.hasBaseDefinition())
      tgt.setBaseDefinitionElement(Canonical43_N.convertCanonical(src.getBaseDefinitionElement()));
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
    if (src.hasSnapshot())
      tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
    if (src.hasDifferential())
      tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
    if (hasOmittedDiscriminatorType(tgt)) {
      // at least one slicing discriminator type could not be represented in R4 and was parked on 
      // the inter-version extension - see ElementDefinition43_N.convertDiscriminatorType. 
      // discriminator.type is mandatory, so readers that don't understand the omission must not 
      // process the resource
      tgt.setImplicitRules(VersionConvertorConstants.IMPLICIT_RULES_OMITTED_MANDATORY_CODE);
    }
    return tgt;
  }

  private static boolean hasOmittedDiscriminatorType(org.hl7.fhir.r4b.model.StructureDefinition sd) {
    return hasOmittedDiscriminatorType(sd.getSnapshot().getElement()) 
        || hasOmittedDiscriminatorType(sd.getDifferential().getElement());
  }

  private static boolean hasOmittedDiscriminatorType(java.util.List<org.hl7.fhir.r4b.model.ElementDefinition> elements) {
    for (org.hl7.fhir.r4b.model.ElementDefinition ed : elements)
      for (org.hl7.fhir.r4b.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent d : ed.getSlicing().getDiscriminator())
        if (d.getTypeElement().hasExtension(VersionConvertorConstants.EXT_DISCRIMINATOR_TYPE))
          return true;
    return false;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<StructureDefinition.StructureDefinitionKind> tgt = new Enumeration<>(new StructureDefinition.StructureDefinitionKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRIMITIVETYPE:
                  tgt.setValue(StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
                  break;
              case COMPLEXTYPE:
                  tgt.setValue(StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
                  break;
              case RESOURCE:
                  tgt.setValue(StructureDefinition.StructureDefinitionKind.RESOURCE);
                  break;
              case LOGICAL:
                  tgt.setValue(StructureDefinition.StructureDefinitionKind.LOGICAL);
                  break;
              default:
                  tgt.setValue(StructureDefinition.StructureDefinitionKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRIMITIVETYPE:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
                  break;
              case COMPLEXTYPE:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
                  break;
              case RESOURCE:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                  break;
              case LOGICAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<StructureDefinition.TypeDerivationRule> tgt = new Enumeration<>(new StructureDefinition.TypeDerivationRuleEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SPECIALIZATION:
                  tgt.setValue(StructureDefinition.TypeDerivationRule.SPECIALIZATION);
                  break;
              case CONSTRAINT:
                  tgt.setValue(StructureDefinition.TypeDerivationRule.CONSTRAINT);
                  break;
              default:
                  tgt.setValue(StructureDefinition.TypeDerivationRule.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRuleEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SPECIALIZATION:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
                  break;
              case CONSTRAINT:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(Id43_N.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(Id43_N.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionContextComponent convertStructureDefinitionContextComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionContextComponent tgt = new org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionContextComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertExtensionContextType(src.getTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent convertStructureDefinitionContextComponent(org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertExtensionContextType(src.getTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.StructureDefinition.ExtensionContextType> convertExtensionContextType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<StructureDefinition.ExtensionContextType> tgt = new Enumeration<>(new StructureDefinition.ExtensionContextTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FHIRPATH:
                  tgt.setValue(StructureDefinition.ExtensionContextType.FHIRPATH);
                  break;
              case ELEMENT:
                  tgt.setValue(StructureDefinition.ExtensionContextType.ELEMENT);
                  break;
              case EXTENSION:
                  tgt.setValue(StructureDefinition.ExtensionContextType.EXTENSION);
                  break;
              default:
                  tgt.setValue(StructureDefinition.ExtensionContextType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType> convertExtensionContextType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.StructureDefinition.ExtensionContextType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FHIRPATH:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.FHIRPATH);
                  break;
              case ELEMENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.ELEMENT);
                  break;
              case EXTENSION:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.EXTENSION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition43_N.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.ElementDefinition t : src.getElementList())
      tgt.addElement(ElementDefinition43_N.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition43_N.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.ElementDefinition t : src.getElementList())
      tgt.addElement(ElementDefinition43_N.convertElementDefinition(t));
    return tgt;
  }
}