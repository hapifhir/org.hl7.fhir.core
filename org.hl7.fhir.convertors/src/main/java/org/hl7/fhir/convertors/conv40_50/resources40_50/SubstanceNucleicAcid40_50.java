package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
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
public class SubstanceNucleicAcid40_50 {

  public static org.hl7.fhir.r5.model.SubstanceNucleicAcid convertSubstanceNucleicAcid(org.hl7.fhir.r4.model.SubstanceNucleicAcid src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceNucleicAcid tgt = new org.hl7.fhir.r5.model.SubstanceNucleicAcid();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasSequenceType())
      tgt.setSequenceType(CodeableConcept40_50.convertCodeableConcept(src.getSequenceType()));
    if (src.hasNumberOfSubunits())
      tgt.setNumberOfSubunitsElement(Integer40_50.convertInteger(src.getNumberOfSubunitsElement()));
    if (src.hasAreaOfHybridisation())
      tgt.setAreaOfHybridisationElement(String40_50.convertString(src.getAreaOfHybridisationElement()));
    if (src.hasOligoNucleotideType())
      tgt.setOligoNucleotideType(CodeableConcept40_50.convertCodeableConcept(src.getOligoNucleotideType()));
    for (org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent t : src.getSubunit())
      tgt.addSubunit(convertSubstanceNucleicAcidSubunitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceNucleicAcid convertSubstanceNucleicAcid(org.hl7.fhir.r5.model.SubstanceNucleicAcid src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceNucleicAcid tgt = new org.hl7.fhir.r4.model.SubstanceNucleicAcid();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasSequenceType())
      tgt.setSequenceType(CodeableConcept40_50.convertCodeableConcept(src.getSequenceType()));
    if (src.hasNumberOfSubunits())
      tgt.setNumberOfSubunitsElement(Integer40_50.convertInteger(src.getNumberOfSubunitsElement()));
    if (src.hasAreaOfHybridisation())
      tgt.setAreaOfHybridisationElement(String40_50.convertString(src.getAreaOfHybridisationElement()));
    if (src.hasOligoNucleotideType())
      tgt.setOligoNucleotideType(CodeableConcept40_50.convertCodeableConcept(src.getOligoNucleotideType()));
    for (org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent t : src.getSubunit())
      tgt.addSubunit(convertSubstanceNucleicAcidSubunitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent convertSubstanceNucleicAcidSubunitComponent(org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent tgt = new org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubunit())
      tgt.setSubunitElement(Integer40_50.convertInteger(src.getSubunitElement()));
    if (src.hasSequence())
      tgt.setSequenceElement(String40_50.convertString(src.getSequenceElement()));
    if (src.hasLength())
      tgt.setLengthElement(Integer40_50.convertInteger(src.getLengthElement()));
    if (src.hasSequenceAttachment())
      tgt.setSequenceAttachment(Attachment40_50.convertAttachment(src.getSequenceAttachment()));
    if (src.hasFivePrime())
      tgt.setFivePrime(CodeableConcept40_50.convertCodeableConcept(src.getFivePrime()));
    if (src.hasThreePrime())
      tgt.setThreePrime(CodeableConcept40_50.convertCodeableConcept(src.getThreePrime()));
    for (org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent t : src.getLinkage())
      tgt.addLinkage(convertSubstanceNucleicAcidSubunitLinkageComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent t : src.getSugar())
      tgt.addSugar(convertSubstanceNucleicAcidSubunitSugarComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent convertSubstanceNucleicAcidSubunitComponent(org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent tgt = new org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubunit())
      tgt.setSubunitElement(Integer40_50.convertInteger(src.getSubunitElement()));
    if (src.hasSequence())
      tgt.setSequenceElement(String40_50.convertString(src.getSequenceElement()));
    if (src.hasLength())
      tgt.setLengthElement(Integer40_50.convertInteger(src.getLengthElement()));
    if (src.hasSequenceAttachment())
      tgt.setSequenceAttachment(Attachment40_50.convertAttachment(src.getSequenceAttachment()));
    if (src.hasFivePrime())
      tgt.setFivePrime(CodeableConcept40_50.convertCodeableConcept(src.getFivePrime()));
    if (src.hasThreePrime())
      tgt.setThreePrime(CodeableConcept40_50.convertCodeableConcept(src.getThreePrime()));
    for (org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent t : src.getLinkage())
      tgt.addLinkage(convertSubstanceNucleicAcidSubunitLinkageComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent t : src.getSugar())
      tgt.addSugar(convertSubstanceNucleicAcidSubunitSugarComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent convertSubstanceNucleicAcidSubunitLinkageComponent(org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent tgt = new org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasConnectivity())
      tgt.setConnectivityElement(String40_50.convertString(src.getConnectivityElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasResidueSite())
      tgt.setResidueSiteElement(String40_50.convertString(src.getResidueSiteElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent convertSubstanceNucleicAcidSubunitLinkageComponent(org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent tgt = new org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitLinkageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasConnectivity())
      tgt.setConnectivityElement(String40_50.convertString(src.getConnectivityElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasResidueSite())
      tgt.setResidueSiteElement(String40_50.convertString(src.getResidueSiteElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent convertSubstanceNucleicAcidSubunitSugarComponent(org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent tgt = new org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasResidueSite())
      tgt.setResidueSiteElement(String40_50.convertString(src.getResidueSiteElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent convertSubstanceNucleicAcidSubunitSugarComponent(org.hl7.fhir.r5.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent tgt = new org.hl7.fhir.r4.model.SubstanceNucleicAcid.SubstanceNucleicAcidSubunitSugarComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasResidueSite())
      tgt.setResidueSiteElement(String40_50.convertString(src.getResidueSiteElement()));
    return tgt;
  }
}