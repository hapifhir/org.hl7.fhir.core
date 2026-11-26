package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class Group40_N {

  // R6 status <-> R4 active
  public static final String ACTIVE_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-Group.active";
  public static final String STATUS_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-Group.status";

  // R6 membership has conceptual, which R4's actual (boolean) can't say
  public static final String MEMBERSHIP_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-Group.membership";

  public static org.hl7.fhir.model.core.Group convertGroup(org.hl7.fhir.r4.model.Group src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Group tgt = new org.hl7.fhir.model.core.Group();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Group", "5.0", new String[] {"description"}, CrossVersionElements40_N.urls("Group", "6.0", new String[] {"url", "version", "title", "experimental", "date", "publisher", "contact", "purpose", "copyright", "copyrightLabel", "useContext", "combinationMethod", "combinationThreshold"}, VersionConvertorConstants.EXT_VERSION_ALGORITHM)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "description");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "url", "version", "title", "experimental", "date", "publisher", "contact", "purpose", "copyright", "copyrightLabel", "useContext", "combinationMethod", "combinationThreshold");
    if (src.hasExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(VersionConvertorConstants.EXT_VERSION_ALGORITHM).getValue()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    // active = true is status = active. active = false is unknown, with active = false in an extension, unless
    // the R6 status that became active = false is in an extension
    if (src.hasActive()) {
      if (src.getActiveElement().hasExtension(STATUS_EXTENSION_URL))
        tgt.setStatus(Enumerations.PublicationStatus.fromCode(src.getActiveElement().getExtensionByUrl(STATUS_EXTENSION_URL).getValue().primitiveValue()));
      else if (src.getActive())
        tgt.setStatus(Enumerations.PublicationStatus.ACTIVE);
      else {
        tgt.setStatus(Enumerations.PublicationStatus.UNKNOWN);
        tgt.getStatusElement().addExtension(ACTIVE_EXTENSION_URL, new org.hl7.fhir.model.core.BooleanType(false));
      }
    }
    if (src.hasType())
      tgt.setTypeElement(CrossVersionElements40_N.toR6Code(src.getTypeElement(), convertGroupType(src.getTypeElement()), src.fhirType(), "type"));
    if (src.hasActual())
      tgt.setMembership(src.getActualElement().hasExtension(MEMBERSHIP_EXTENSION_URL)
        ? GroupMembershipBasis.fromCode(src.getActualElement().getExtensionByUrl(MEMBERSHIP_EXTENSION_URL).getValue().primitiveValue())
        : src.getActual() ? GroupMembershipBasis.ENUMERATED : GroupMembershipBasis.DEFINITIONAL);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasQuantity())
      tgt.setQuantityElement(UnsignedInt40_N.convertUnsignedInt(src.getQuantityElement()));
    if (src.hasManagingEntity())
      tgt.setManagingEntity(Reference40_N.convertReference(src.getManagingEntity()));
    for (org.hl7.fhir.r4.model.Group.GroupCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.r4.model.Group.GroupMemberComponent t : src.getMember())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Group convertGroup(org.hl7.fhir.model.core.Group src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Group tgt = new org.hl7.fhir.r4.model.Group();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "description");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "url", "version", "title", "experimental", "date", "publisher", "contact", "purpose", "copyright", "copyrightLabel", "useContext", "combinationMethod", "combinationThreshold");
    if (src.hasVersionAlgorithm())
      tgt.addExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getVersionAlgorithm()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus()) {
      tgt.setActive(src.getStatus() == Enumerations.PublicationStatus.ACTIVE);
      // anything but active (or unknown standing for active = false) is false, with the real status in an extension
      if (src.getStatus() != Enumerations.PublicationStatus.ACTIVE && !(src.getStatus() == Enumerations.PublicationStatus.UNKNOWN && src.getStatusElement().hasExtension(ACTIVE_EXTENSION_URL)))
        tgt.getActiveElement().addExtension(STATUS_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getStatusElement().getCode()));
    }
    if (src.hasType())
      tgt.setTypeElement(CrossVersionElements40_N.toR4Code(src.getTypeElement(), convertGroupType(src.getTypeElement()), src.fhirType(), "type"));
    if (src.hasMembership())
    {
      tgt.setActual(src.getMembership() == GroupMembershipBasis.ENUMERATED);
      // R4 actual can't say conceptual: keep the code
      if (src.getMembership() == GroupMembershipBasis.CONCEPTUAL)
        tgt.getActualElement().addExtension(MEMBERSHIP_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getMembershipElement().getCode()));
    }
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasQuantity())
      tgt.setQuantityElement(UnsignedInt40_N.convertUnsignedInt(src.getQuantityElement()));
    if (src.hasManagingEntity())
      tgt.setManagingEntity(Reference40_N.convertReference(src.getManagingEntity()));
    for (org.hl7.fhir.model.core.Group.GroupCharacteristicComponent t : src.getCharacteristicList())
      tgt.addCharacteristic(convertGroupCharacteristicComponent(t));
    for (org.hl7.fhir.model.core.Group.GroupMemberComponent t : src.getMemberList())
      tgt.addMember(convertGroupMemberComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Group.GroupType> convertGroupType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Group.GroupType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Group.GroupType> tgt = new Enumeration<>(new Group.GroupTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Group.GroupType> convertGroupType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Group.GroupType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Group.GroupType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Group.GroupTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PERSON:
                  tgt.setValue(org.hl7.fhir.r4.model.Group.GroupType.PERSON);
                  break;
              case ANIMAL:
                  tgt.setValue(org.hl7.fhir.r4.model.Group.GroupType.ANIMAL);
                  break;
              case PRACTITIONER:
                  tgt.setValue(org.hl7.fhir.r4.model.Group.GroupType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(org.hl7.fhir.r4.model.Group.GroupType.DEVICE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Group.GroupType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.r4.model.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.model.core.Group.GroupCharacteristicComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Group.characteristic", "6.0", new String[] {"value", "description", "method", "formula", "determiner", "offset", "instances", "duration", "relativeTime"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Group.characteristic", "6.0", "value", "description", "method", "formula", "determiner", "offset", "instances", "duration", "relativeTime");
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    if (src.hasExclude())
      tgt.setExcludeElement(Boolean40_N.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Group.GroupCharacteristicComponent convertGroupCharacteristicComponent(org.hl7.fhir.model.core.Group.GroupCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Group.GroupCharacteristicComponent tgt = new org.hl7.fhir.r4.model.Group.GroupCharacteristicComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Group.characteristic", tgt.getExtension(), "6.0", "description", "method", "formula", "determiner", "offset", "instances", "duration", "relativeTime");
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue()) {
      if (src.getValue() instanceof org.hl7.fhir.model.core.UriType || src.getValue() instanceof org.hl7.fhir.model.core.Expression)
        CrossVersionElements40_N.elementsToExtensionsForPath(src, "Group.characteristic", tgt.getExtension(), "6.0", "value");
      else
        tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    }
    if (src.hasExclude())
      tgt.setExcludeElement(Boolean40_N.convertBoolean(src.getExcludeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.r4.model.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Group.GroupMemberComponent tgt = new org.hl7.fhir.model.core.Group.GroupMemberComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Group.member", "6.0", new String[] {"involvement"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Group.member", "6.0", "involvement");
    if (src.hasEntity())
      tgt.setEntity(Reference40_N.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean40_N.convertBoolean(src.getInactiveElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Group.GroupMemberComponent convertGroupMemberComponent(org.hl7.fhir.model.core.Group.GroupMemberComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Group.GroupMemberComponent tgt = new org.hl7.fhir.r4.model.Group.GroupMemberComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Group.member", tgt.getExtension(), "6.0", "involvement");
    if (src.hasEntity())
      tgt.setEntity(Reference40_N.convertReference(src.getEntity()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasInactive())
      tgt.setInactiveElement(Boolean40_N.convertBoolean(src.getInactiveElement()));
    return tgt;
  }
}