package org.hl7.fhir.convertors.conv30_40.resources30_40;


import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.PositiveInt30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.dstu3.model.Coverage;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.codesystems.CoverageClass;

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
// mapping based on https://hl7.org/fhir/R4/coverage-version-maps.html
public class Coverage30_40 {

  public static org.hl7.fhir.dstu3.model.Coverage convertCoverage(org.hl7.fhir.r4.model.Coverage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Coverage tgt = new org.hl7.fhir.dstu3.model.Coverage();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference30_40.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference30_40.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.setSubscriberIdElement(String30_40.convertString(src.getSubscriberIdElement()));
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference30_40.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String30_40.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept30_40.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPayor())
      tgt.addPayor(Reference30_40.convertReference(t));
    if (src.hasOrder())
      tgt.setOrderElement(PositiveInt30_40.convertPositiveInt(src.getOrderElement()));
    if (src.hasNetwork())
      tgt.setNetworkElement(String30_40.convertString(src.getNetworkElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getContract())
      tgt.addContract(Reference30_40.convertReference(t));

    if (src.hasClass_()) {
      tgt.setGrouping(new Coverage.GroupComponent());
      for (org.hl7.fhir.r4.model.Coverage.ClassComponent t : src.getClass_()) {
        mapClassToGroup(tgt, t);
      }
    }

    return tgt;
  }


  public static org.hl7.fhir.r4.model.Coverage convertCoverage(org.hl7.fhir.dstu3.model.Coverage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coverage tgt = new org.hl7.fhir.r4.model.Coverage();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasPolicyHolder())
      tgt.setPolicyHolder(Reference30_40.convertReference(src.getPolicyHolder()));
    if (src.hasSubscriber())
      tgt.setSubscriber(Reference30_40.convertReference(src.getSubscriber()));
    if (src.hasSubscriberId())
      tgt.setSubscriberIdElement(String30_40.convertString(src.getSubscriberIdElement()));
    if (src.hasBeneficiary())
      tgt.setBeneficiary(Reference30_40.convertReference(src.getBeneficiary()));
    if (src.hasDependent())
      tgt.setDependentElement(String30_40.convertString(src.getDependentElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept30_40.convertCodeableConcept(src.getRelationship()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPayor())
      tgt.addPayor(Reference30_40.convertReference(t));
    if (src.hasOrder())
      tgt.setOrderElement(PositiveInt30_40.convertPositiveInt(src.getOrderElement()));
    if (src.hasNetwork())
      tgt.setNetworkElement(String30_40.convertString(src.getNetworkElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getContract())
      tgt.addContract(Reference30_40.convertReference(t));


    if (src.hasGrouping()) {
      org.hl7.fhir.dstu3.model.Coverage.GroupComponent group = src.getGrouping();
      if (group.hasGroup()) {
        tgt.addClass_(convertCoverageGrouping("group", group.getGroup(), group.getGroupDisplay()));
      }
      if (group.hasSubGroup()) {
        tgt.addClass_(convertCoverageGrouping("subGroup", group.getSubGroup(), group.getSubGroupDisplay()));
      }
      if (group.hasPlan()) {
        tgt.addClass_(convertCoverageGrouping("plan", group.getPlan(), group.getPlanDisplay()));
      }
      if (group.hasSubPlan()) {
        tgt.addClass_(convertCoverageGrouping("subPlan", group.getSubPlan(), group.getSubPlanDisplay()));
      }
      if (group.hasClass_()) {
        tgt.addClass_(convertCoverageGrouping("class", group.getClass_(), group.getClassDisplay()));
      }
      if (group.hasSubClass()) {
        tgt.addClass_(convertCoverageGrouping("subClass", group.getSubClass(), group.getSubClassDisplay()));
      }
    }
    //note mapping of sequence from dstu3 to r4 is not described in mapping
    if (src.hasSequence()) {
      tgt.addClass_(convertCoverageGrouping("sequence", src.getSequence(), null));
    }

    return tgt;
  }


  private static org.hl7.fhir.r4.model.Coverage.ClassComponent convertCoverageGrouping(String code, String value, String name) {
    org.hl7.fhir.r4.model.Coverage.ClassComponent tgt = new org.hl7.fhir.r4.model.Coverage.ClassComponent();

    org.hl7.fhir.r4.model.Coding coding = new org.hl7.fhir.r4.model.Coding();
    coding.setSystem(CoverageClass.CLASS.getSystem());
    coding.setCode(code);
    CodeableConcept codeableConcept = new CodeableConcept(coding);
    tgt.setType(codeableConcept);
    tgt.setValue(value);
    tgt.setName(name);
    return tgt;
  }

  private static void mapClassToGroup(Coverage tgt, org.hl7.fhir.r4.model.Coverage.ClassComponent classComponent) {
    if (classComponent == null || tgt == null)
      return;


    if (!classComponent.hasType())
      return;

    Coverage.GroupComponent grouping = tgt.getGrouping();
    switch (classComponent.getType().getCodingFirstRep().getCode()) {
      case "group":
        grouping.setGroup(classComponent.getValue());
        grouping.setGroupDisplay(classComponent.getName());
        break;
      case "subGroup":
        grouping.setSubGroup(classComponent.getValue());
        grouping.setSubGroupDisplay(classComponent.getName());
        break;
      case "plan":
        grouping.setPlan(classComponent.getValue());
        grouping.setPlanDisplay(classComponent.getName());
        break;
      case "subPlan":
        grouping.setSubPlan(classComponent.getValue());
        grouping.setSubPlanDisplay(classComponent.getName());
        break;
      case "class":
        grouping.setClass_(classComponent.getValue());
        grouping.setClassDisplay(classComponent.getName());
        break;
      case "subClass":
        grouping.setSubClass(classComponent.getValue());
        grouping.setSubClassDisplay(classComponent.getName());
        break;
      case "sequence":
        tgt.setSequence(classComponent.getValue());
        break;
    }
  }


  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Coverage.CoverageStatus> convertCoverageStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Coverage.CoverageStatus> tgt = new Enumeration<>(new Coverage.CoverageStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> convertCoverageStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Coverage.CoverageStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Coverage.CoverageStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

}