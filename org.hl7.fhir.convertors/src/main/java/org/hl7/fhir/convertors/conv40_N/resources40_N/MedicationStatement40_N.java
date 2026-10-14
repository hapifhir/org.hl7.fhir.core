package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Dosage40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.DosageDetails;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.MedicationStatement;

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

public class MedicationStatement40_N {

  public static org.hl7.fhir.model.core.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MedicationStatement tgt = new org.hl7.fhir.model.core.MedicationStatement();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_MED_STAT_STATUS_5);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasPrimitiveExtension(VersionConvertorConstants.EXT_MED_STAT_STATUS_5)) {
      tgt.setStatus(org.hl7.fhir.model.core.MedicationStatement.MedicationStatementStatusCodes.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_MED_STAT_STATUS_5)));
    } else if (src.hasStatus()) {
      tgt.addExtension(new org.hl7.fhir.model.core.Extension(VersionConvertorConstants.EXT_MED_STAT_STATUS_4, new org.hl7.fhir.model.core.CodeType(src.getStatus().toCode())));
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    }
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept()) {
      tgt.getMedication().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getMedicationCodeableConcept()));
    }
    if (src.hasMedicationReference()) {
      tgt.getMedication().setReference(Reference40_N.convertReference(src.getMedicationReference()));
    }
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference40_N.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime40_N.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.addInformationSource(Reference40_N.convertReference(src.getInformationSource()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.getDosage().getStepFirstRep().addComponent(Dosage40_N.convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.model.core.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_MED_STAT_STATUS_4);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
//    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
//    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));

    if (src.hasPrimitiveExtension(VersionConvertorConstants.EXT_MED_STAT_STATUS_4)) {
      tgt.setStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.fromCode(src.getExtensionString(VersionConvertorConstants.EXT_MED_STAT_STATUS_4)));
    } else if (src.hasStatus()) {
      tgt.addExtension(new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_MED_STAT_STATUS_5, new org.hl7.fhir.r4.model.CodeType(src.getStatus().toCode())));
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    }
//    for (org.hl7.fhir.model.core.CodeableConcept t : src.getStatusReasonList())
//      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept()) {
      tgt.setMedication(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMedication().getConcept()));
    }
    if (src.getMedication().hasReference()) {
      tgt.setMedication(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMedication().getReference()));
    }
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime40_N.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference40_N.convertReference(src.getInformationSourceFirstRep()));
    for (org.hl7.fhir.model.core.Reference t : src.getDerivedFromList())
      tgt.addDerivedFrom(Reference40_N.convertReference(t));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (DosageDetails.DosageDetailsStepComponent t : src.getDosage().getStepList()) tgt.addDosage(Dosage40_N.convertDosage(t.getComponentFirstRep()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationStatement.MedicationStatementStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MedicationStatement.MedicationStatementStatusCodes> tgt = new Enumeration<>(new MedicationStatement.MedicationStatementStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              case COMPLETED:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.ENTEREDINERROR);
                  break;
              case INTENDED:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              case STOPPED:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              case ONHOLD:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              case UNKNOWN:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              case NOTTAKEN:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.RECORDED);
                  break;
              default:
                  tgt.setValue(MedicationStatement.MedicationStatementStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MedicationStatement.MedicationStatementStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              //            case ACTIVE:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
//                break;
              case RECORDED:
                  tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
                  break;
//            case UNKNOWN:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED);
//                break;
//            case STOPPED:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.STOPPED);
//                break;
//            case ONHOLD:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
//                break;
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.UNKNOWN);
                  break;
//            case NOTTAKEN:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN);
//                break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}