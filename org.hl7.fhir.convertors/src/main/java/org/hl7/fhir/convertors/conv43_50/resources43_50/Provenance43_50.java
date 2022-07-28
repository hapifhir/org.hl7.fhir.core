package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Signature43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class Provenance43_50 {

  public static org.hl7.fhir.r5.model.Provenance convertProvenance(org.hl7.fhir.r4b.model.Provenance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Provenance tgt = new org.hl7.fhir.r5.model.Provenance();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Reference t : src.getTarget()) tgt.addTarget(Reference43_50.convertReference(t));
    if (src.hasOccurred())
      tgt.setOccurred(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurred()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant43_50.convertInstant(src.getRecordedElement()));
    for (org.hl7.fhir.r4b.model.UriType t : src.getPolicy()) tgt.getPolicy().add(Uri43_50.convertUri(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReason())
      tgt.addAuthorization().setConcept(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasActivity())
      tgt.setActivity(CodeableConcept43_50.convertCodeableConcept(src.getActivity()));
    for (org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent t : src.getAgent())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    for (org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent t : src.getEntity())
      tgt.addEntity(convertProvenanceEntityComponent(t));
    for (org.hl7.fhir.r4b.model.Signature t : src.getSignature()) tgt.addSignature(Signature43_50.convertSignature(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Provenance convertProvenance(org.hl7.fhir.r5.model.Provenance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Provenance tgt = new org.hl7.fhir.r4b.model.Provenance();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getTarget()) tgt.addTarget(Reference43_50.convertReference(t));
    if (src.hasOccurred())
      tgt.setOccurred(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurred()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant43_50.convertInstant(src.getRecordedElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getPolicy()) tgt.getPolicy().add(Uri43_50.convertUri(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    for (CodeableReference t : src.getAuthorization())
      if (t.hasConcept())
        tgt.addReason(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    if (src.hasActivity())
      tgt.setActivity(CodeableConcept43_50.convertCodeableConcept(src.getActivity()));
    for (org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent t : src.getAgent())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    for (org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent t : src.getEntity())
      tgt.addEntity(convertProvenanceEntityComponent(t));
    for (org.hl7.fhir.r5.model.Signature t : src.getSignature()) tgt.addSignature(Signature43_50.convertSignature(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference43_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference43_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRoleElement(convertProvenanceEntityRole(src.getRoleElement()));
    if (src.hasWhat())
      tgt.setWhat(Reference43_50.convertReference(src.getWhat()));
    for (org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent t : src.getAgent())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRoleElement(convertProvenanceEntityRole(src.getRoleElement()));
    if (src.hasWhat())
      tgt.setWhat(Reference43_50.convertReference(src.getWhat()));
    for (org.hl7.fhir.r5.model.Provenance.ProvenanceAgentComponent t : src.getAgent())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole> convertProvenanceEntityRole(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRoleEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DERIVATION:
        tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.INSTANTIATES);
        break;
      case REVISION:
        tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.REVISION);
        break;
      case QUOTATION:
        tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.QUOTATION);
        break;
      case SOURCE:
        tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.SOURCE);
        break;
      case REMOVAL:
        tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.REMOVAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole> convertProvenanceEntityRole(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Provenance.ProvenanceEntityRole> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRoleEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANTIATES:
        tgt.setValue(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole.DERIVATION);
        break;
      case REVISION:
        tgt.setValue(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole.REVISION);
        break;
      case QUOTATION:
        tgt.setValue(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole.QUOTATION);
        break;
      case SOURCE:
        tgt.setValue(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole.SOURCE);
        break;
      case REMOVAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole.REMOVAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole.NULL);
        break;
    }
    return tgt;
  }
}