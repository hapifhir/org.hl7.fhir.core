package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.MarketingStatus;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class MedicinalProductDefinition40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.MedicinalProductDefinition convertMedicinalProduct(org.hl7.fhir.r4.model.MedicinalProduct src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicinalProductDefinition tgt = new org.hl7.fhir.r5.model.MedicinalProductDefinition();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasType())
          tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasDomain())
          tgt.getDomain().addCoding(convertCoding(src.getDomain()));
        // version (new)
        // status (new)
        // description (new)
        if (src.hasCombinedPharmaceuticalDoseForm())
          tgt.setCombinedPharmaceuticalDoseForm(convertCodeableConcept(src.getCombinedPharmaceuticalDoseForm()));
        // indication (new)
        if (src.hasLegalStatusOfSupply())
          tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
        if (src.hasAdditionalMonitoringIndicator())
          tgt.setAdditionalMonitoringIndicator(convertCodeableConcept(src.getAdditionalMonitoringIndicator()));
        for (org.hl7.fhir.r4.model.StringType t : src.getSpecialMeasures()) {
          // specialMeasures string -> CodeableConcept
          org.hl7.fhir.r5.model.CodeableConcept c = new org.hl7.fhir.r5.model.CodeableConcept();
          tgt.addSpecialMeasures(c);
          c.setTextElement(convertString(t));
        }       
        if (src.hasPaediatricUseIndicator())
          tgt.setPaediatricUseIndicator(convertCodeableConcept(src.getPaediatricUseIndicator()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProductClassification()) tgt.addProductClassification(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.MarketingStatus t : src.getMarketingStatus()) tgt.addMarketingStatus(convertMarketingStatus(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPharmaceuticalProduct()) tgt.addPharmaceuticalProduct(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPackagedMedicinalProduct()) tgt.addPackagedMedicinalProduct(convertReference(t));
        // ingredient (new)
        for (org.hl7.fhir.r4.model.Reference t : src.getAttachedDocument()) tgt.addAttachedDocument(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getMasterFile()) tgt.addMasterFile(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getContact()) {
          // contact (Reference -> complex
          org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionContactComponent c = new org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionContactComponent();
          tgt.addContact(c);
          c.setContact(convertReference(t));
        }        
        for (org.hl7.fhir.r4.model.Reference t : src.getClinicalTrial()) tgt.addClinicalTrial(convertReference(t));
        for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent srcName : src.getName()) {
          org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameComponent tgtName = new org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameComponent();
          copyElement(srcName, tgtName);
          tgt.addName(tgtName);
          tgtName.setProductNameElement(convertString(srcName.getProductNameElement()));
          //type (new)
          for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent srcPart : srcName.getNamePart()) {
            org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameNamePartComponent tgtPart = new org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameNamePartComponent();
            copyElement(srcPart, tgtPart);
            tgtName.addNamePart(tgtPart);
            tgtPart.setPartElement(convertString(srcPart.getPartElement()));
            tgtPart.getType().addCoding(convertCoding(srcPart.getType()));
          }
          for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent srcLang : srcName.getCountryLanguage()) {
            org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameCountryLanguageComponent tgtLang = new org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameCountryLanguageComponent();
            copyElement(srcLang, tgtLang);
            tgtName.addCountryLanguage(tgtLang);
            tgtLang.setCountry(convertCodeableConcept(srcLang.getCountry()));
            tgtLang.setLanguage(convertCodeableConcept(srcLang.getLanguage()));
          }
        }
        for (org.hl7.fhir.r4.model.Identifier t : src.getCrossReference()) {
          // cross-reference Identifier -> complex
          org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionCrossReferenceComponent c = new org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionCrossReferenceComponent();
          tgt.addCrossReference(c);
          c.setProduct(convertIdentifier(t));
        }        
        for (org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent srcMBO : src.getManufacturingBusinessOperation()) {
          org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionManufacturingBusinessOperationComponent tgtMBO = new org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionManufacturingBusinessOperationComponent();
          copyElement(srcMBO, tgtMBO);
          tgt.addManufacturingBusinessOperation(tgtMBO);
          if (srcMBO.hasOperationType()) {
            tgtMBO.getType().setConcept(convertCodeableConcept(srcMBO.getOperationType()));
            // operationType -> type[x]
          }
          if (srcMBO.hasAuthorisationReferenceNumber())
            throw new FHIRException("Converting MedicinalProduct.ManufacturingBusinessOperation.authorizationReferenceNumber is not supported");
          if (srcMBO.hasEffectiveDate()) {
            // effectiveDate - dateTime -> Period
            org.hl7.fhir.r5.model.Period p = new org.hl7.fhir.r5.model.Period();
            tgtMBO.setEffectiveDate(p);
            p.setStartElement(convertDateTime(srcMBO.getEffectiveDateElement()));
            p.setEndElement(convertDateTime(srcMBO.getEffectiveDateElement()));
          }
          if (srcMBO.hasConfidentialityIndicator())
            tgtMBO.setConfidentialityIndicator(convertCodeableConcept(srcMBO.getConfidentialityIndicator()));
          for (org.hl7.fhir.r4.model.Reference t : srcMBO.getManufacturer()) tgtMBO.addManufacturer(convertReference(t));
          if (srcMBO.hasRegulator())
            throw new FHIRException("Converting MedicinalProduct.ManufacturingBusinessOperation.regulator is not supported");
          // added authorization
        }
        if (src.hasSpecialDesignation())
          throw new FHIRException("Converting MedicinalProduct.specialDesignation is not supported");
        
        return tgt;
    }
// Todo convert references
    
    public static org.hl7.fhir.r4.model.MedicinalProduct convertMedicinalProductDefinition(org.hl7.fhir.r5.model.MedicinalProductDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicinalProduct tgt = new org.hl7.fhir.r4.model.MedicinalProduct();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasType())
          tgt.setType(convertCodeableConcept(src.getType()));
        if (src.getDomain().hasCoding())
          tgt.setDomain(convertCoding(src.getDomain().getCodingFirstRep()));
        if (src.hasVersion())
          throw new FHIRException("Converting MedicinalProductDefinition.version is not supported");
        if (src.hasStatus())
          throw new FHIRException("Converting MedicinalProductDefinition.status is not supported");
        if (src.hasDescription())
          throw new FHIRException("Converting MedicinalProductDefinition.description is not supported");
        if (src.hasCombinedPharmaceuticalDoseForm())
          tgt.setCombinedPharmaceuticalDoseForm(convertCodeableConcept(src.getCombinedPharmaceuticalDoseForm()));
        if (src.hasIndication())
          throw new FHIRException("Converting MedicinalProductDefinition.indication is not supported");
        if (src.hasLegalStatusOfSupply())
          tgt.setLegalStatusOfSupply(convertCodeableConcept(src.getLegalStatusOfSupply()));
        if (src.hasAdditionalMonitoringIndicator())
          tgt.setAdditionalMonitoringIndicator(convertCodeableConcept(src.getAdditionalMonitoringIndicator()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialMeasures()) {
          // specialMeasures  CodeableConcept -> string
          if (t.hasText()) {
            org.hl7.fhir.r4.model.StringType s = tgt.addSpecialMeasuresElement();
            copyElement(t.getTextElement(), s);
            s.setValue(t.getText());
          }
          checkBase(t, "MedicinalProductDefinition.specialMeasures");
          if (t.hasCoding())
            throw new FHIRException("Converting MedicinalProductDefinition.specialMeasures.coding is not supported");
        }       
        if (src.hasPaediatricUseIndicator())
          tgt.setPaediatricUseIndicator(convertCodeableConcept(src.getPaediatricUseIndicator()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProductClassification()) tgt.addProductClassification(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.MarketingStatus t : src.getMarketingStatus()) tgt.addMarketingStatus(convertMarketingStatus(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPharmaceuticalProduct()) tgt.addPharmaceuticalProduct(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPackagedMedicinalProduct()) tgt.addPackagedMedicinalProduct(convertReference(t));
        // ingredient (new)
        for (org.hl7.fhir.r5.model.Reference t : src.getAttachedDocument()) tgt.addAttachedDocument(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getMasterFile()) tgt.addMasterFile(convertReference(t));
        for (org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionContactComponent t : src.getContact()) {
          // contact complex -> reference
          if (t.hasContact()) {
            tgt.addContact(convertReference(t.getContact()));
          }
          checkBase(t, "MedicinalProductDefinition.contact");
          if (t.hasType())
            throw new FHIRException("Converting MedicinalProductDefinition.contact.type is not supported");
        }        
        for (org.hl7.fhir.r5.model.Reference t : src.getClinicalTrial()) tgt.addClinicalTrial(convertReference(t));
        for (org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameComponent srcName : src.getName()) {
          org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent tgtName = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameComponent();
          copyElement(srcName, tgtName);
          tgt.addName(tgtName);
          tgtName.setProductNameElement(convertString(srcName.getProductNameElement()));
          //type (new)
          for (org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameNamePartComponent srcPart : srcName.getNamePart()) {
            org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent tgtPart = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameNamePartComponent();
            copyElement(srcPart, tgtPart);
            tgtName.addNamePart(tgtPart);
            tgtPart.setPartElement(convertString(srcPart.getPartElement()));
            if (srcPart.getType().hasCoding()) {
              tgtPart.setType(convertCoding(srcPart.getType().getCodingFirstRep()));
            }
          }
          for (org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionNameCountryLanguageComponent srcLang : srcName.getCountryLanguage()) {
            org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent tgtLang = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductNameCountryLanguageComponent();
            copyElement(srcLang, tgtLang);
            tgtName.addCountryLanguage(tgtLang);
            tgtLang.setCountry(convertCodeableConcept(srcLang.getCountry()));
            tgtLang.setLanguage(convertCodeableConcept(srcLang.getLanguage()));
          }
        }
        for (org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionCrossReferenceComponent t : src.getCrossReference()) {
          // cross-reference complex -> Identifier
          if (t.hasProduct()) {
            if (t.getProduct() instanceof org.hl7.fhir.r5.model.Identifier)
              tgt.addCrossReference(convertIdentifier((org.hl7.fhir.r5.model.Identifier)t.getProduct()));
            else
              throw new FHIRException("Converting MedicinalProductDefinition.crossReference.productReference is not supported");
          }
          checkBase(t, "MedicinalProductDefinition.crossReference");
          if (t.hasType())
            throw new FHIRException("Converting MedicinalProductDefinition.crossReference.type is not supported");
        }        
        for (org.hl7.fhir.r5.model.MedicinalProductDefinition.MedicinalProductDefinitionManufacturingBusinessOperationComponent srcMBO : src.getManufacturingBusinessOperation()) {
          org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent tgtMBO = new org.hl7.fhir.r4.model.MedicinalProduct.MedicinalProductManufacturingBusinessOperationComponent();
          copyElement(srcMBO, tgtMBO);
          tgt.addManufacturingBusinessOperation(tgtMBO);
          if (srcMBO.hasType()) {
            //  type[x] -> operationType
              if (srcMBO.getType().hasConcept())
                tgtMBO.setOperationType(convertCodeableConcept(srcMBO.getType().getConcept()));
              else
                throw new FHIRException("Converting MedicinalProductDefinition.manufacturingBusinessOperation.typeReference is not supported");
          }
          // added authorisationReferenceNumber
          if (srcMBO.hasEffectiveDate()) {
            // effectiveDate - Period -> dateTime
            org.hl7.fhir.r5.model.Period d = srcMBO.getEffectiveDate(); 
            checkBase(srcMBO, "MedicinalProductDefinition.manufacturingBusinessOperation.effectiveDate");
            if (d.hasStart() || d.hasEnd()) {
              if (d.hasStart() != d.hasEnd() || !d.getStart().equals(d.getEnd()))
                throw new FHIRException("Converting MedicinalProductDefinition.manufacturingBusinessOperation.effectiveDate is not supported when start is not identical to end");
              else
                tgtMBO.setEffectiveDateElement(convertDateTime(d.getStartElement()));
            }
          }
          if (srcMBO.hasAuthorization())
            throw new FHIRException("Converting MedicinalProductDefinition.manufacturingBusinessOperation.authorization is not supported");
          if (srcMBO.hasConfidentialityIndicator())
            tgtMBO.setConfidentialityIndicator(convertCodeableConcept(srcMBO.getConfidentialityIndicator()));
          for (org.hl7.fhir.r5.model.Reference t : srcMBO.getManufacturer()) tgtMBO.addManufacturer(convertReference(t));
          // Added regulator
          // added authorization
        }
        // added specialDesignation
        return tgt;
    }
    
    static public void checkBase(org.hl7.fhir.r5.model.Element e, String path) throws FHIRException {
      if (e.hasId())
        throw new FHIRException ("Converting " + path + ".id is not supported");
      if (e.hasExtension())
        throw new FHIRException ("Converting " + path + ".extension is not supported");
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.INTENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.STOPPED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ONHOLD);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.UNKNOWN);
                break;
            case NOTTAKEN:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.NOTTAKEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.STOPPED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.UNKNOWN);
                break;
            case NOTTAKEN:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }
}