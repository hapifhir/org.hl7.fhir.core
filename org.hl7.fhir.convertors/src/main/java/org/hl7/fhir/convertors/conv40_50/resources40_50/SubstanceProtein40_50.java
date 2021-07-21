package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
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
public class SubstanceProtein40_50 {

  public static org.hl7.fhir.r5.model.SubstanceProtein convertSubstanceProtein(org.hl7.fhir.r4.model.SubstanceProtein src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceProtein tgt = new org.hl7.fhir.r5.model.SubstanceProtein();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyDomainResource(src, tgt);
    if (src.hasSequenceType())
      tgt.setSequenceType(CodeableConcept40_50.convertCodeableConcept(src.getSequenceType()));
    if (src.hasNumberOfSubunits())
      tgt.setNumberOfSubunitsElement(Integer40_50.convertInteger(src.getNumberOfSubunitsElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getDisulfideLinkage())
      tgt.getDisulfideLinkage().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.SubstanceProtein.SubstanceProteinSubunitComponent t : src.getSubunit())
      tgt.addSubunit(convertSubstanceProteinSubunitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceProtein convertSubstanceProtein(org.hl7.fhir.r5.model.SubstanceProtein src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceProtein tgt = new org.hl7.fhir.r4.model.SubstanceProtein();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyDomainResource(src, tgt);
    if (src.hasSequenceType())
      tgt.setSequenceType(CodeableConcept40_50.convertCodeableConcept(src.getSequenceType()));
    if (src.hasNumberOfSubunits())
      tgt.setNumberOfSubunitsElement(Integer40_50.convertInteger(src.getNumberOfSubunitsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getDisulfideLinkage())
      tgt.getDisulfideLinkage().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.SubstanceProtein.SubstanceProteinSubunitComponent t : src.getSubunit())
      tgt.addSubunit(convertSubstanceProteinSubunitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceProtein.SubstanceProteinSubunitComponent convertSubstanceProteinSubunitComponent(org.hl7.fhir.r4.model.SubstanceProtein.SubstanceProteinSubunitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceProtein.SubstanceProteinSubunitComponent tgt = new org.hl7.fhir.r5.model.SubstanceProtein.SubstanceProteinSubunitComponent();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasSubunit())
      tgt.setSubunitElement(Integer40_50.convertInteger(src.getSubunitElement()));
    if (src.hasSequence())
      tgt.setSequenceElement(String40_50.convertString(src.getSequenceElement()));
    if (src.hasLength())
      tgt.setLengthElement(Integer40_50.convertInteger(src.getLengthElement()));
    if (src.hasSequenceAttachment())
      tgt.setSequenceAttachment(Attachment40_50.convertAttachment(src.getSequenceAttachment()));
    if (src.hasNTerminalModificationId())
      tgt.setNTerminalModificationId(Identifier40_50.convertIdentifier(src.getNTerminalModificationId()));
    if (src.hasNTerminalModification())
      tgt.setNTerminalModificationElement(String40_50.convertString(src.getNTerminalModificationElement()));
    if (src.hasCTerminalModificationId())
      tgt.setCTerminalModificationId(Identifier40_50.convertIdentifier(src.getCTerminalModificationId()));
    if (src.hasCTerminalModification())
      tgt.setCTerminalModificationElement(String40_50.convertString(src.getCTerminalModificationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceProtein.SubstanceProteinSubunitComponent convertSubstanceProteinSubunitComponent(org.hl7.fhir.r5.model.SubstanceProtein.SubstanceProteinSubunitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceProtein.SubstanceProteinSubunitComponent tgt = new org.hl7.fhir.r4.model.SubstanceProtein.SubstanceProteinSubunitComponent();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasSubunit())
      tgt.setSubunitElement(Integer40_50.convertInteger(src.getSubunitElement()));
    if (src.hasSequence())
      tgt.setSequenceElement(String40_50.convertString(src.getSequenceElement()));
    if (src.hasLength())
      tgt.setLengthElement(Integer40_50.convertInteger(src.getLengthElement()));
    if (src.hasSequenceAttachment())
      tgt.setSequenceAttachment(Attachment40_50.convertAttachment(src.getSequenceAttachment()));
    if (src.hasNTerminalModificationId())
      tgt.setNTerminalModificationId(Identifier40_50.convertIdentifier(src.getNTerminalModificationId()));
    if (src.hasNTerminalModification())
      tgt.setNTerminalModificationElement(String40_50.convertString(src.getNTerminalModificationElement()));
    if (src.hasCTerminalModificationId())
      tgt.setCTerminalModificationId(Identifier40_50.convertIdentifier(src.getCTerminalModificationId()));
    if (src.hasCTerminalModification())
      tgt.setCTerminalModificationElement(String40_50.convertString(src.getCTerminalModificationElement()));
    return tgt;
  }
}