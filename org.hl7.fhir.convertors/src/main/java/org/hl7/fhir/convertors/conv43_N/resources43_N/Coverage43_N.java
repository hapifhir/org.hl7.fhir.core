package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Coverage;
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

public class Coverage43_N {

  public static org.hl7.fhir.model.core.Coverage convertCoverage(org.hl7.fhir.r4b.model.Coverage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage tgt = new org.hl7.fhir.model.core.Coverage();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference43_N.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference43_N.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.getSubscriberIdFirstRep().setValueElement(String43_N.convertString(src.getSubscriberIdElement()));
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference43_N.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String43_N.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPayor()) tgt.setInsurer(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Coverage.ClassComponent t : src.getClass_()) tgt.addClass_(convertClassComponent(t));
    if (src.hasOrder())
      tgt.setOrderElement(PositiveInt43_N.convertPositiveInt(src.getOrderElement()));
    for (org.hl7.fhir.r4b.model.Coverage.CostToBeneficiaryComponent t : src.getCostToBeneficiary())
      tgt.addCostToBeneficiary(convertCostToBeneficiaryComponent(t));
    if (src.hasSubrogation())
      tgt.setSubrogationElement(Boolean43_N.convertBoolean(src.getSubrogationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Coverage convertCoverage(org.hl7.fhir.model.core.Coverage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Coverage tgt = new org.hl7.fhir.r4b.model.Coverage();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference43_N.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference43_N.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.setSubscriberIdElement(String43_N.convertString(src.getSubscriberIdFirstRep().getValueElement()));
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference43_N.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String43_N.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    tgt.addPayor(Reference43_N.convertReference(src.getInsurer()));
    for (org.hl7.fhir.model.core.Coverage.ClassComponent t : src.getClass_List()) tgt.addClass_(convertClassComponent(t));
    if (src.hasOrder())
      tgt.setOrderElement(PositiveInt43_N.convertPositiveInt(src.getOrderElement()));
    for (org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent t : src.getCostToBeneficiaryList())
      tgt.addCostToBeneficiary(convertCostToBeneficiaryComponent(t));
    if (src.hasSubrogation())
      tgt.setSubrogationElement(Boolean43_N.convertBoolean(src.getSubrogationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertCoverageStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertCoverageStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.r4b.model.Coverage.ClassComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.ClassComponent tgt = new org.hl7.fhir.model.core.Coverage.ClassComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.getValue().setValueElement(String43_N.convertString(src.getValueElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.model.core.Coverage.ClassComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Coverage.ClassComponent tgt = new org.hl7.fhir.r4b.model.Coverage.ClassComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValueElement(String43_N.convertString(src.getValue().getValueElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.r4b.model.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    for (org.hl7.fhir.r4b.model.Coverage.ExemptionComponent t : src.getException())
      tgt.addException(convertExemptionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.r4b.model.Coverage.CostToBeneficiaryComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    for (org.hl7.fhir.model.core.Coverage.ExceptionComponent t : src.getExceptionList())
      tgt.addException(convertExemptionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.ExceptionComponent convertExemptionComponent(org.hl7.fhir.r4b.model.Coverage.ExemptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.ExceptionComponent tgt = new org.hl7.fhir.model.core.Coverage.ExceptionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Coverage.ExemptionComponent convertExemptionComponent(org.hl7.fhir.model.core.Coverage.ExceptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Coverage.ExemptionComponent tgt = new org.hl7.fhir.r4b.model.Coverage.ExemptionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }
}