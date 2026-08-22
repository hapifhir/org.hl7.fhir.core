package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Coverage;
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

public class Coverage40_N {

  public static org.hl7.fhir.model.core.Coverage convertCoverage(org.hl7.fhir.r4.model.Coverage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage tgt = new org.hl7.fhir.model.core.Coverage();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference40_N.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference40_N.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.getSubscriberIdFirstRep().setValueElement(String40_N.convertString(src.getSubscriberIdElement()));
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference40_N.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String40_N.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPayor()) tgt.setInsurer(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Coverage.ClassComponent t : src.getClass_()) tgt.addClass_(convertClassComponent(t));
    if (src.hasOrder())
      tgt.setOrderElement(PositiveInt40_N.convertPositiveInt(src.getOrderElement()));
    for (org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent t : src.getCostToBeneficiary())
      tgt.addCostToBeneficiary(convertCostToBeneficiaryComponent(t));
    if (src.hasSubrogation())
      tgt.setSubrogationElement(Boolean40_N.convertBoolean(src.getSubrogationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coverage convertCoverage(org.hl7.fhir.model.core.Coverage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage tgt = new org.hl7.fhir.r4.model.Coverage();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference40_N.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference40_N.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.setSubscriberIdElement(String40_N.convertString(src.getSubscriberIdFirstRep().getValueElement()));
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference40_N.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String40_N.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    tgt.addPayor(Reference40_N.convertReference(src.getInsurer()));
    for (org.hl7.fhir.model.core.Coverage.ClassComponent t : src.getClass_List()) tgt.addClass_(convertClassComponent(t));
    if (src.hasOrder())
      tgt.setOrderElement(PositiveInt40_N.convertPositiveInt(src.getOrderElement()));
    for (org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent t : src.getCostToBeneficiaryList())
      tgt.addCostToBeneficiary(convertCostToBeneficiaryComponent(t));
    if (src.hasSubrogation())
      tgt.setSubrogationElement(Boolean40_N.convertBoolean(src.getSubrogationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertCoverageStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> convertCoverageStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Coverage.CoverageStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Coverage.CoverageStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Coverage.CoverageStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Coverage.CoverageStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Coverage.CoverageStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Coverage.CoverageStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Coverage.CoverageStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.r4.model.Coverage.ClassComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.ClassComponent tgt = new org.hl7.fhir.model.core.Coverage.ClassComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.getValue().setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.model.core.Coverage.ClassComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage.ClassComponent tgt = new org.hl7.fhir.r4.model.Coverage.ClassComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValue().getValueElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    for (org.hl7.fhir.r4.model.Coverage.ExemptionComponent t : src.getException())
      tgt.addException(convertExemptionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    for (org.hl7.fhir.model.core.Coverage.ExceptionComponent t : src.getExceptionList())
      tgt.addException(convertExemptionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.ExceptionComponent convertExemptionComponent(org.hl7.fhir.r4.model.Coverage.ExemptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.ExceptionComponent tgt = new org.hl7.fhir.model.core.Coverage.ExceptionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coverage.ExemptionComponent convertExemptionComponent(org.hl7.fhir.model.core.Coverage.ExceptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage.ExemptionComponent tgt = new org.hl7.fhir.r4.model.Coverage.ExemptionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }
}