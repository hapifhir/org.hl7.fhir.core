package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Coverage", tgt.getExtension(), "contract");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Coverage", "5.0", new String[] {"kind", "paymentBy"}, CrossVersionElements40_N.urls("Coverage", "6.0", new String[] {"statusReason"}, CrossVersionElements40_N.url("Coverage", "5.0", "subscriberId"), CrossVersionElements40_N.url("Coverage", "5.0", "network"))));
    // R6 kind is required, but R4 has nothing to say what it is, so it's not populated (and the R6 resource isn't valid)
    // unless there's a cross-version extension; see https://jira.hl7.org/browse/FHIR-59959
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "kind");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "statusReason");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertCoverageStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference40_N.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference40_N.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.addSubscriberId().setValueElement(String40_N.convertString(src.getSubscriberIdElement()));
    // the subscriber ids R4's string couldn't hold
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "subscriberId");
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference40_N.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String40_N.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    // R4 payor is a list; R6 insurer is single: the first payor, and the rest in 4.0 extensions
    // R4 payor is a list of Organization | Patient | RelatedPerson. Going by the reference type (where it can be told):
    // the first organisation is R6 insurer, and the patients and related persons are R6 paymentBy.party.
    // Other organisations go in 4.0 extensions
    for (org.hl7.fhir.r4.model.Reference t : src.getPayor()) {
      if (isPaymentByParty(t))
        tgt.addPaymentBy().setParty(Reference40_N.convertReference(t));
      else if (!tgt.hasInsurer())
        tgt.setInsurer(Reference40_N.convertReference(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Coverage", "4.0", "payor"), Reference40_N.convertReference(t));
    }
    // the paymentBys that were more than a party
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "paymentBy");
    if (src.hasNetwork())
      tgt.setNetwork(new org.hl7.fhir.model.core.Reference().setDisplayElement(String40_N.convertString(src.getNetworkElement())));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "network");
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Coverage", "4.0", new String[] {"contract", "payor"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Coverage", "contract");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "kind");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "statusReason");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertCoverageStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference40_N.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference40_N.convertReference(src.getSubscriber()));
    // R4 subscriberId is a string: the first identifier, if it's only a value; the rest in 5.0 extensions
    for (org.hl7.fhir.model.core.Identifier t : src.getSubscriberIdList()) {
      if (!tgt.hasSubscriberId() && tgt.getExtensionsByUrl(CrossVersionElements40_N.url("Coverage", "5.0", "subscriberId")).isEmpty() && isValueOnly(t))
        tgt.setSubscriberIdElement(String40_N.convertString(t.getValueElement()));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Coverage", "5.0", "subscriberId"), Identifier40_N.convertIdentifier(t));
    }
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference40_N.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String40_N.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasInsurer())
      tgt.addPayor(Reference40_N.convertReference(src.getInsurer()));
    // a paymentBy that's only a party is a payor; anything more goes whole in a 5.0 extension
    for (org.hl7.fhir.model.core.Coverage.CoveragePaymentByComponent t : src.getPaymentByList()) {
      if (t.hasParty() && !t.hasResponsibility() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension())
        tgt.addPayor(Reference40_N.convertReference(t.getParty()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Coverage", "5.0", "paymentBy"), t));
    }
    for (org.hl7.fhir.model.core.Extension ext : src.getExtension())
      if (CrossVersionElements40_N.url("Coverage", "4.0", "payor").equals(ext.getUrl()))
        tgt.addPayor(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) ext.getValue()));
    // R4 network is a string: the display of the reference, if that's all there is
    if (src.hasNetwork()) {
      if (src.getNetwork().hasDisplay() && !src.getNetwork().hasReference() && !src.getNetwork().hasIdentifier() && !src.getNetwork().hasType() && !src.getNetwork().hasId() && !src.getNetwork().hasExtension())
        tgt.setNetworkElement(String40_N.convertString(src.getNetwork().getDisplayElement()));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Coverage", "5.0", "network"), Reference40_N.convertReference(src.getNetwork()));
    }
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Coverage.class", "5.0", new String[] {}, CrossVersionElements40_N.urls("Coverage.class", "6.0", new String[] {"code"}, CrossVersionElements40_N.url("Coverage.class", "5.0", "value"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "code");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.getValue().setValueElement(String40_N.convertString(src.getValueElement()));
    // the whole identifier, if it was more than a value
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Coverage.class", "5.0", "value");
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.model.core.Coverage.ClassComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage.ClassComponent tgt = new org.hl7.fhir.r4.model.Coverage.ClassComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "code");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue()) {
      tgt.setValueElement(String40_N.convertString(src.getValue().getValueElement()));
      if (!isValueOnly(src.getValue()))
        tgt.addExtension(CrossVersionElements40_N.url("Coverage.class", "5.0", "value"), Identifier40_N.convertIdentifier(src.getValue()));
    }
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Coverage.costToBeneficiary", "5.0", new String[] {"category", "network", "unit", "term"}, CrossVersionElements40_N.urls("Coverage.costToBeneficiary", "6.0", new String[] {})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "category", "network", "unit", "term");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    for (org.hl7.fhir.r4.model.Coverage.ExemptionComponent t : src.getException())
      tgt.addException(convertExemptionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.model.core.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "category", "network", "unit", "term");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
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

  private static boolean isValueOnly(org.hl7.fhir.model.core.Identifier t) {
    return t.hasValue() && !t.hasSystem() && !t.hasUse() && !t.hasType() && !t.hasPeriod() && !t.hasAssigner() && !t.hasId() && !t.hasExtension()
      && !t.getValueElement().hasExtension();
  }

  // whether an R4 payor is a patient or related person (R6 paymentBy.party) rather than an organisation (R6 insurer)
  private static boolean isPaymentByParty(org.hl7.fhir.r4.model.Reference ref) {
    String type = ref.hasType() ? ref.getType() : ref.hasReference() && ref.getReference().contains("/") ? ref.getReference().substring(0, ref.getReference().indexOf("/")) : null;
    if (type != null && type.contains("/"))
      type = type.substring(type.lastIndexOf("/") + 1);
    return "Patient".equals(type) || "RelatedPerson".equals(type);
  }
}
