package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Signature43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Provenance;

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

public class Provenance43_N {

  public static org.hl7.fhir.model.core.Provenance convertProvenance(org.hl7.fhir.r4b.model.Provenance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Provenance tgt = new org.hl7.fhir.model.core.Provenance();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Reference t : src.getTarget()) tgt.addTarget(Reference43_N.convertReference(t));
    if (src.hasOccurred())
      tgt.setOccurred(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurred()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant43_N.convertInstant(src.getRecordedElement()));
    for (org.hl7.fhir.r4b.model.UriType t : src.getPolicy()) tgt.getPolicyList().add(Uri43_N.convertUri(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReason())
      tgt.addAuthorization(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasActivity())
      tgt.setActivity(CodeableConcept43_N.convertCodeableConcept(src.getActivity()));
    for (org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent t : src.getAgent())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    for (org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent t : src.getEntity())
      tgt.addEntity(convertProvenanceEntityComponent(t));
    for (org.hl7.fhir.r4b.model.Signature t : src.getSignature()) tgt.addSignature(Signature43_N.convertSignature(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Provenance convertProvenance(org.hl7.fhir.model.core.Provenance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Provenance tgt = new org.hl7.fhir.r4b.model.Provenance();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Reference t : src.getTargetList()) tgt.addTarget(Reference43_N.convertReference(t));
    if (src.hasOccurred())
      tgt.setOccurred(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurred()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant43_N.convertInstant(src.getRecordedElement()));
    for (org.hl7.fhir.model.core.UriType t : src.getPolicyList()) tgt.getPolicy().add(Uri43_N.convertUri(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (CodeableConcept t : src.getAuthorizationList())
        tgt.addReason(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasActivity())
      tgt.setActivity(CodeableConcept43_N.convertCodeableConcept(src.getActivity()));
    for (org.hl7.fhir.model.core.Provenance.ProvenanceAgentComponent t : src.getAgentList())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    for (org.hl7.fhir.model.core.Provenance.ProvenanceEntityComponent t : src.getEntityList())
      tgt.addEntity(convertProvenanceEntityComponent(t));
    for (org.hl7.fhir.model.core.Signature t : src.getSignatureList()) tgt.addSignature(Signature43_N.convertSignature(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.model.core.Provenance.ProvenanceAgentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference43_N.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.model.core.Provenance.ProvenanceAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRoleList())
      tgt.addRole(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference43_N.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.model.core.Provenance.ProvenanceEntityComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRoleElement(convertProvenanceEntityRole(src.getRoleElement()));
    if (src.hasWhat())
      tgt.setWhat(Reference43_N.convertReference(src.getWhat()));
    for (org.hl7.fhir.r4b.model.Provenance.ProvenanceAgentComponent t : src.getAgent())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.model.core.Provenance.ProvenanceEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRoleElement(convertProvenanceEntityRole(src.getRoleElement()));
    if (src.hasWhat())
      tgt.setWhat(Reference43_N.convertReference(src.getWhat()));
    for (org.hl7.fhir.model.core.Provenance.ProvenanceAgentComponent t : src.getAgentList())
      tgt.addAgent(convertProvenanceAgentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Provenance.ProvenanceEntityRole> convertProvenanceEntityRole(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Provenance.ProvenanceEntityRole> tgt = new Enumeration<>(new Provenance.ProvenanceEntityRoleEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DERIVATION:
                  tgt.setValue(Provenance.ProvenanceEntityRole.INSTANTIATES);
                  break;
              case REVISION:
                  tgt.setValue(Provenance.ProvenanceEntityRole.REVISION);
                  break;
              case QUOTATION:
                  tgt.setValue(Provenance.ProvenanceEntityRole.QUOTATION);
                  break;
              case SOURCE:
                  tgt.setValue(Provenance.ProvenanceEntityRole.SOURCE);
                  break;
              case REMOVAL:
                  tgt.setValue(Provenance.ProvenanceEntityRole.REMOVAL);
                  break;
              default:
                  tgt.setValue(Provenance.ProvenanceEntityRole.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole> convertProvenanceEntityRole(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Provenance.ProvenanceEntityRole> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRole> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Provenance.ProvenanceEntityRoleEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}