package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.Group;
import org.hl7.fhir.model.core.Group.GroupMembershipBasis;

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

public class Group43_N {

  public static org.hl7.fhir.model.core.Group convertGroup(org.hl7.fhir.r4b.model.Group src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Group tgt = new org.hl7.fhir.model.core.Group();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.getActive())
      tgt.setStatus(Enumerations.PublicationStatus.ACTIVE);
    if (src.hasType())
      tgt.setTypeElement(convertGroupType(src.getTypeElement()));
    if (src.hasActual())
      tgt.setMembership(src.getActual() ? GroupMembershipBasis.ENUMERATED : GroupMembershipBasis.DEFINITIONAL);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasQuantity())
      tgt.setQuantityElement(UnsignedInt43_N.convertUnsignedInt(src.getQuantityElement()));
    if (src.hasManagingEntity())
      tgt.setManagingEntity(Reference43_N.convertReference(src.getManagingEntity()));
    for (org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.r4b.model.Group.GroupMemberComponent t : src.getMember())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Group convertGroup(org.hl7.fhir.model.core.Group src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Group tgt = new org.hl7.fhir.r4b.model.Group();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setActive(src.getStatus() == Enumerations.PublicationStatus.ACTIVE);
    if (src.hasType())
      tgt.setTypeElement(convertGroupType(src.getTypeElement()));
    if (src.hasMembership())
      tgt.setActual(src.getMembership() == GroupMembershipBasis.ENUMERATED);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasQuantity())
      tgt.setQuantityElement(UnsignedInt43_N.convertUnsignedInt(src.getQuantityElement()));
    if (src.hasManagingEntity())
      tgt.setManagingEntity(Reference43_N.convertReference(src.getManagingEntity()));
    for (org.hl7.fhir.model.core.Group.GroupCharacteristicComponent t : src.getCharacteristicList())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.model.core.Group.GroupMemberComponent t : src.getMemberList())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Group.GroupType> convertGroupType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Group.GroupType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Group.GroupType> tgt = new Enumeration<>(new Group.GroupTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PERSON:
                  tgt.setValue(Group.GroupType.PERSON);
                  break;
              case ANIMAL:
                  tgt.setValue(Group.GroupType.ANIMAL);
                  break;
              case PRACTITIONER:
                  tgt.setValue(Group.GroupType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(Group.GroupType.DEVICE);
                  break;
              default:
                  tgt.setValue(Group.GroupType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Group.GroupType> convertGroupType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Group.GroupType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Group.GroupType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Group.GroupTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.model.core.Group.GroupCharacteristicComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    if (src.hasExclude())
      tgt.setExcludeElement(Boolean43_N.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.model.core.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.r4b.model.Group.GroupCharacteristicComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    if (src.hasExclude())
      tgt.setExcludeElement(Boolean43_N.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.r4b.model.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Group.GroupMemberComponent tgt = new org.hl7.fhir.model.core.Group.GroupMemberComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasEntity())
      tgt.setEntity(Reference43_N.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_N.convertBoolean(src.getInactiveElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.model.core.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.r4b.model.Group.GroupMemberComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasEntity())
      tgt.setEntity(Reference43_N.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean43_N.convertBoolean(src.getInactiveElement()));
    return tgt;
  }
}