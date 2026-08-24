package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.ListResource;

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

public class ListResource43_N {

  public static org.hl7.fhir.model.core.ListResource convertListResource(org.hl7.fhir.r4b.model.ListResource src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ListResource tgt = new org.hl7.fhir.model.core.ListResource();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertListStatus(src.getStatusElement()));
    if (src.hasMode())
      tgt.setModeElement(convertListMode(src.getModeElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.addSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasSource())
      tgt.setSource(Reference43_N.convertReference(src.getSource()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept43_N.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.ListResource.ListResourceEntryComponent t : src.getEntry())
      tgt.addEntry(convertListEntryComponent(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept43_N.convertCodeableConcept(src.getEmptyReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ListResource convertListResource(org.hl7.fhir.model.core.ListResource src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ListResource tgt = new org.hl7.fhir.r4b.model.ListResource();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertListStatus(src.getStatusElement()));
    if (src.hasMode())
      tgt.setModeElement(convertListMode(src.getModeElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubjectFirstRep()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasSource())
      tgt.setSource(Reference43_N.convertReference(src.getSource()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept43_N.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.ListResource.ListResourceEntryComponent t : src.getEntryList())
      tgt.addEntry(convertListEntryComponent(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept43_N.convertCodeableConcept(src.getEmptyReason()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListStatus> convertListStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ListResource.ListStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ListResource.ListStatus> tgt = new Enumeration<>(new ListResource.ListStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CURRENT:
                  tgt.setValue(ListResource.ListStatus.CURRENT);
                  break;
              case RETIRED:
                  tgt.setValue(ListResource.ListStatus.RETIRED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ListResource.ListStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(ListResource.ListStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ListResource.ListStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ListResource.ListStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CURRENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.ListResource.ListStatus.CURRENT);
                  break;
              case RETIRED:
                  tgt.setValue(org.hl7.fhir.r4b.model.ListResource.ListStatus.RETIRED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.ListResource.ListStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.ListResource.ListStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListMode> convertListMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ListResource.ListMode> tgt = new Enumeration<>(new ListResource.ListModeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case WORKING:
                  tgt.setValue(ListResource.ListMode.WORKING);
                  break;
              case SNAPSHOT:
                  tgt.setValue(ListResource.ListMode.SNAPSHOT);
                  break;
              case CHANGES:
                  tgt.setValue(ListResource.ListMode.CHANGES);
                  break;
              default:
                  tgt.setValue(ListResource.ListMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> convertListMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ListModeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case WORKING:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.WORKING);
                  break;
              case SNAPSHOT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.SNAPSHOT);
                  break;
              case CHANGES:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.CHANGES);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ListResource.ListResourceEntryComponent convertListEntryComponent(org.hl7.fhir.r4b.model.ListResource.ListResourceEntryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ListResource.ListResourceEntryComponent tgt = new org.hl7.fhir.model.core.ListResource.ListResourceEntryComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFlag())
      tgt.setFlag(CodeableConcept43_N.convertCodeableConcept(src.getFlag()));
    if (src.hasDeleted())
      tgt.setDeletedElement(Boolean43_N.convertBoolean(src.getDeletedElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasItem())
      tgt.setItem(Reference43_N.convertReference(src.getItem()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ListResource.ListResourceEntryComponent convertListEntryComponent(org.hl7.fhir.model.core.ListResource.ListResourceEntryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ListResource.ListResourceEntryComponent tgt = new org.hl7.fhir.r4b.model.ListResource.ListResourceEntryComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFlag())
      tgt.setFlag(CodeableConcept43_N.convertCodeableConcept(src.getFlag()));
    if (src.hasDeleted())
      tgt.setDeletedElement(Boolean43_N.convertBoolean(src.getDeletedElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasItem())
      tgt.setItem(Reference43_N.convertReference(src.getItem()));
    return tgt;
  }
}