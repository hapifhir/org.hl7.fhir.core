package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class StructureDefinition40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r4.model.StructureDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getKeyword()) tgt.addKeyword(convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersionElement(Enumerations40_50.convertFHIRVersion(src.getFhirVersionElement()));
        for (org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(convertBoolean(src.getAbstractElement()));
        for (org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext()) tgt.addContext(convertStructureDefinitionContextComponent(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getContextInvariant()) tgt.getContextInvariant().add(convertString(t));
        if (src.hasType())
            tgt.setTypeElement(convertUri(src.getTypeElement()));
        if (src.hasBaseDefinition())
            tgt.setBaseDefinitionElement(convertCanonical(src.getBaseDefinitionElement()));
        if (src.hasDerivation())
            tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r5.model.StructureDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getKeyword()) tgt.addKeyword(convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersionElement(Enumerations40_50.convertFHIRVersion(src.getFhirVersionElement()));
        for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(convertBoolean(src.getAbstractElement()));
        for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext()) tgt.addContext(convertStructureDefinitionContextComponent(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getContextInvariant()) tgt.getContextInvariant().add(convertString(t));
        if (src.hasType())
            tgt.setTypeElement(convertUri(src.getTypeElement()));
        if (src.hasBaseDefinition())
            tgt.setBaseDefinitionElement(convertCanonical(src.getBaseDefinitionElement()));
        if (src.hasDerivation())
            tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRIMITIVETYPE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
                break;
            case COMPLEXTYPE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRIMITIVETYPE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
                break;
            case COMPLEXTYPE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRuleEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SPECIALIZATION:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
                break;
            case CONSTRAINT:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRuleEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SPECIALIZATION:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
                break;
            case CONSTRAINT:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent convertStructureDefinitionContextComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertExtensionContextType(src.getTypeElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent convertStructureDefinitionContextComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertExtensionContextType(src.getTypeElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> convertExtensionContextType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FHIRPATH:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.FHIRPATH);
                break;
            case ELEMENT:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.ELEMENT);
                break;
            case EXTENSION:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.EXTENSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType> convertExtensionContextType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FHIRPATH:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.FHIRPATH);
                break;
            case ELEMENT:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.ELEMENT);
                break;
            case EXTENSION:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.EXTENSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement()) tgt.addElement(convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement()) tgt.addElement(convertElementDefinition(t));
        return tgt;
    }
}