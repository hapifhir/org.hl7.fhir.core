package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.UnsignedInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Group.GroupMembershipBasis;

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
public class Group43_50 {

  public static org.hl7.fhir.r5.model.Group convertGroup(org.hl7.fhir.r4b.model.Group src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Group tgt = new org.hl7.fhir.r5.model.Group();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasType())
      tgt.setTypeElement(convertGroupType(src.getTypeElement()));
    if (src.hasActual())
      tgt.setMembership(src.getActual() ? GroupMembershipBasis.ENUMERATED : GroupMembershipBasis.DEFINITIONAL);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasQuantity())
      tgt.setQuantityElement(UnsignedInt43_50.convertUnsignedInt(src.getQuantityElement()));
    if (src.hasManagingEntity())
      tgt.setManagingEntity(Reference43_50.convertReference(src.getManagingEntity()));
    for (org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.r4b.model.Group.GroupMemberComponent t : src.getMember())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Group convertGroup(org.hl7.fhir.r5.model.Group src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Group tgt = new org.hl7.fhir.r4b.model.Group();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasType())
      tgt.setTypeElement(convertGroupType(src.getTypeElement()));
    if (src.hasMembership())
      tgt.setActual(src.getMembership() == GroupMembershipBasis.ENUMERATED);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasQuantity())
      tgt.setQuantityElement(UnsignedInt43_50.convertUnsignedInt(src.getQuantityElement()));
    if (src.hasManagingEntity())
      tgt.setManagingEntity(Reference43_50.convertReference(src.getManagingEntity()));
    for (org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.r5.model.Group.GroupMemberComponent t : src.getMember())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> convertGroupType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Group.GroupType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Group.GroupTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.PERSON);
        break;
      case ANIMAL:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.ANIMAL);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Group.GroupType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Group.GroupType> convertGroupType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Group.GroupType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Group.GroupType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Group.GroupTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r4b.model.Group.GroupType.PERSON);
        break;
      case ANIMAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Group.GroupType.ANIMAL);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r4b.model.Group.GroupType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r4b.model.Group.GroupType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Group.GroupType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasExclude())
      tgt.setExcludeElement(Boolean43_50.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.r5.model.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasExclude())
      tgt.setExcludeElement(Boolean43_50.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.r4b.model.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.r5.model.Group.GroupMemberComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasEntity())
      tgt.setEntity(Reference43_50.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_50.convertBoolean(src.getInactiveElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.r5.model.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.r4b.model.Group.GroupMemberComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasEntity())
      tgt.setEntity(Reference43_50.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_50.convertBoolean(src.getInactiveElement()));
    return tgt;
  }
}