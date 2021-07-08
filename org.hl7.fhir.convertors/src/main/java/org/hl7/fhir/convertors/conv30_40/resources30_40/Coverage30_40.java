package org.hl7.fhir.convertors.conv30_40.resources30_40;


import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.PositiveInt30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
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
public class Coverage30_40 extends VersionConvertor_30_40 {

    public static org.hl7.fhir.dstu3.model.Coverage convertCoverage(org.hl7.fhir.r4.model.Coverage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Coverage tgt = new org.hl7.fhir.dstu3.model.Coverage();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
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
        for (org.hl7.fhir.r4.model.Reference t : src.getPayor()) tgt.addPayor(Reference30_40.convertReference(t));
        if (src.hasOrder())
            tgt.setOrderElement(PositiveInt30_40.convertPositiveInt(src.getOrderElement()));
        if (src.hasNetwork())
            tgt.setNetworkElement(String30_40.convertString(src.getNetworkElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getContract()) tgt.addContract(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coverage convertCoverage(org.hl7.fhir.dstu3.model.Coverage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Coverage tgt = new org.hl7.fhir.r4.model.Coverage();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
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
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPayor()) tgt.addPayor(Reference30_40.convertReference(t));
        if (src.hasOrder())
            tgt.setOrderElement(PositiveInt30_40.convertPositiveInt(src.getOrderElement()));
        if (src.hasNetwork())
            tgt.setNetworkElement(String30_40.convertString(src.getNetworkElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getContract()) tgt.addContract(Reference30_40.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Coverage.CoverageStatus> convertCoverageStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Coverage.CoverageStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Coverage.CoverageStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Coverage.CoverageStatus.ACTIVE);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Coverage.CoverageStatus.CANCELLED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Coverage.CoverageStatus.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Coverage.CoverageStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Coverage.CoverageStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> convertCoverageStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Coverage.CoverageStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Coverage.CoverageStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

}