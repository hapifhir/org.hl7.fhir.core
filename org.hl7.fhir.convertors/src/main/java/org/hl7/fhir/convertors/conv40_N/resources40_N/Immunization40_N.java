package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.Utilities40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Immunization;

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

public class Immunization40_N {

  public static org.hl7.fhir.model.core.Immunization convertImmunization(org.hl7.fhir.r4.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization tgt = new org.hl7.fhir.model.core.Immunization();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Immunization", tgt.getExtension(), "recorded", "education");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Immunization", "5.0", new String[] {"basedOn", "administeredProduct", "supportingInformation"}, CrossVersionElements40_N.urls("Immunization", "6.0", new String[] {}, CrossVersionElements40_N.url("Immunization", "5.0", "manufacturer"), CrossVersionElements40_N.url("Immunization", "5.0", "programEligibility"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "basedOn", "administeredProduct", "supportingInformation");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertImmunizationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept40_N.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "occurrence", tgt, tgt.getExtension());
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean40_N.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setInformationSource(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getReportOrigin()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference40_N.convertReferenceToCodeableReference(src.getManufacturer()));
    // the whole manufacturer, if it was more than a reference
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "manufacturer");
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_N.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date40_N.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept40_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    CodeableConcept40_N.convertReasonsToR6(src.getReasonCode(), src.getReasonReference(), tgt.getReasonList());
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean40_N.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(CodeableConcept40_N.convertCodeableConcept(t));
    // R4 programEligibility is R6 programEligibility.programStatus
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramEligibility())
      tgt.addProgramEligibility().setProgramStatus(CodeableConcept40_N.convertCodeableConcept(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "programEligibility");
    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept40_N.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization convertImmunization(org.hl7.fhir.model.core.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization tgt = new org.hl7.fhir.r4.model.Immunization();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Immunization", "4.0", new String[] {"recorded", "education"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Immunization", "recorded", "education");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "basedOn", "administeredProduct", "supportingInformation");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertImmunizationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept40_N.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "occurrence", tgt, tgt.getExtension());
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean40_N.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasInformationSource())
      tgt.setReportOrigin(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getInformationSource()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasManufacturer()) {
      if (src.getManufacturer().hasReference())
        tgt.setManufacturer(Reference40_N.convertReference(src.getManufacturer().getReference()));
      if (src.getManufacturer().hasConcept() || src.getManufacturer().hasId() || src.getManufacturer().hasExtension())
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Immunization", "5.0", "manufacturer"), src.getManufacturer()));
    }
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_N.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date40_N.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept40_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    CodeableConcept40_N.convertReasonsToR4(src.getReasonList(), tgt.getReasonCode(), tgt.getReasonReference());
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean40_N.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSubpotentReasonList())
      tgt.addSubpotentReason(CodeableConcept40_N.convertCodeableConcept(t));
    // an R6 programEligibility that's just a programStatus is an R4 programEligibility; the rest go whole in 5.0 extensions
    for (org.hl7.fhir.model.core.Immunization.ImmunizationProgramEligibilityComponent t : src.getProgramEligibilityList()) {
      if (t.hasProgramStatus() && !t.hasProgram() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension())
        tgt.addProgramEligibility(CodeableConcept40_N.convertCodeableConcept(t.getProgramStatus()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Immunization", "5.0", "programEligibility"), t));
    }
    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept40_N.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent t : src.getReactionList())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolAppliedList())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Immunization.ImmunizationStatusCodes> tgt = new Enumeration<>(new Immunization.ImmunizationStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.ENTEREDINERROR);
                  break;
              case NOTDONE:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.NOTDONE);
                  break;
              default:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> convertImmunizationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Immunization.ImmunizationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.ENTEREDINERROR);
                  break;
              case NOTDONE:
                  tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NOTDONE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

//  public static org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasDocumentType())
//      tgt.setDocumentTypeElement(String40_N.convertString(src.getDocumentTypeElement()));
//    if (src.hasReference())
//      tgt.setReferenceElement(Uri40_N.convertUri(src.getReferenceElement()));
//    if (src.hasPublicationDate())
//      tgt.setPublicationDateElement(DateTime40_N.convertDateTime(src.getPublicationDateElement()));
//    if (src.hasPresentationDate())
//      tgt.setPresentationDateElement(DateTime40_N.convertDateTime(src.getPresentationDateElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasDocumentType())
//      tgt.setDocumentTypeElement(String40_N.convertString(src.getDocumentTypeElement()));
//    if (src.hasReference())
//      tgt.setReferenceElement(Uri40_N.convertUri(src.getReferenceElement()));
//    if (src.hasPublicationDate())
//      tgt.setPublicationDateElement(DateTime40_N.convertDateTime(src.getPublicationDateElement()));
//    if (src.hasPresentationDate())
//      tgt.setPresentationDateElement(DateTime40_N.convertDateTime(src.getPresentationDateElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("Immunization.reaction", "5.0", "manifestation"));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setManifestation(Reference40_N.convertReferenceToCodeableReference(src.getDetail()));
    // the whole manifestation, if it was more than a reference
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Immunization.reaction", "5.0", "manifestation");
    if (src.hasReported())
      tgt.setReportedElement(Boolean40_N.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasManifestation()) {
      if (src.getManifestation().hasReference())
        tgt.setDetail(Reference40_N.convertReference(src.getManifestation().getReference()));
      if (src.getManifestation().hasConcept() || src.getManifestation().hasId() || src.getManifestation().hasExtension())
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Immunization.reaction", "5.0", "manifestation"), src.getManifestation()));
    }
    if (src.hasReported())
      tgt.setReportedElement(Boolean40_N.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String40_N.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference40_N.convertReference(src.getAuthority()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(Utilities40_N.convertPositiveIntOrStringToCodeableConcept(src.getDoseNumber(), CrossVersionElements40_N.url("Immunization.protocolApplied", "6.0", "doseNumber")));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(Utilities40_N.convertPositiveIntOrStringToCodeableConcept(src.getSeriesDoses(), CrossVersionElements40_N.url("Immunization.protocolApplied", "6.0", "seriesDoses")));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String40_N.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference40_N.convertReference(src.getAuthority()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTargetDiseaseList())
      tgt.addTargetDisease(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(Utilities40_N.convertCodeableConceptToPositiveIntOrString(src.getDoseNumber(), CrossVersionElements40_N.url("Immunization.protocolApplied", "6.0", "doseNumber")));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(Utilities40_N.convertCodeableConceptToPositiveIntOrString(src.getSeriesDoses(), CrossVersionElements40_N.url("Immunization.protocolApplied", "6.0", "seriesDoses")));
    return tgt;
  }
}