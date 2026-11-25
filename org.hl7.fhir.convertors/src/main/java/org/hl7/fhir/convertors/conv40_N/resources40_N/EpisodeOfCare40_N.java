package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.EpisodeOfCare;

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

public class EpisodeOfCare40_N {

  public static org.hl7.fhir.model.core.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r4.model.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EpisodeOfCare tgt = new org.hl7.fhir.model.core.EpisodeOfCare();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("EpisodeOfCare", "5.0", new String[] {"reason"}, CrossVersionElements40_N.urls("EpisodeOfCare", "6.0", new String[] {})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "reason");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertEpisodeOfCareStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(Reference40_N.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference40_N.convertReference(src.getCareManager()));
    for (org.hl7.fhir.r4.model.Reference t : src.getTeam()) tgt.addCareTeam(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAccount()) tgt.addAccount(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.model.core.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare tgt = new org.hl7.fhir.r4.model.EpisodeOfCare();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "reason");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertEpisodeOfCareStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistoryList())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.Reference t : src.getReferralRequestList())
      tgt.addReferralRequest(Reference40_N.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference40_N.convertReference(src.getCareManager()));
    for (org.hl7.fhir.model.core.Reference t : src.getCareTeamList()) tgt.addTeam(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAccountList()) tgt.addAccount(Reference40_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<EpisodeOfCare.EpisodeOfCareStatus> tgt = new Enumeration<>(new EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
                  break;
              case WAITLIST:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
                  break;
              case ACTIVE:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
                  break;
              case FINISHED:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
                  break;
              case CANCELLED:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
                  break;
              case WAITLIST:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
                  break;
              case FINISHED:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertEpisodeOfCareStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertEpisodeOfCareStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("EpisodeOfCare.diagnosis", "5.0", new String[] {"condition", "use"}));
    if (src.hasCondition())
      tgt.addCondition(Reference40_N.convertReferenceToCodeableReference(src.getCondition()));
    if (src.hasRole())
      tgt.addUse(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    // the conditions and uses R4 had no room for
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "EpisodeOfCare.diagnosis", "5.0", "condition", "use");
    // R6 dropped rank
    CrossVersionElements40_N.r4ElementsToExtensions(src, "EpisodeOfCare.diagnosis", tgt.getExtension(), "rank");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("EpisodeOfCare.diagnosis", "4.0", "rank"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "EpisodeOfCare.diagnosis", "rank");
    // R4 condition is a single reference: the first condition that's just a reference, and the rest in the extension
    for (org.hl7.fhir.model.core.CodeableReference t : src.getConditionList()) {
      if (!tgt.hasCondition() && t.hasReference() && !t.hasConcept() && !t.hasId() && !t.hasExtension())
        tgt.setCondition(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("EpisodeOfCare.diagnosis", "5.0", "condition"), t));
    }
    // R4 has one role: the first use, and the rest in the extension
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getUseList()) {
      if (!tgt.hasRole())
        tgt.setRole(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("EpisodeOfCare.diagnosis", "5.0", "use"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    return tgt;
  }
}