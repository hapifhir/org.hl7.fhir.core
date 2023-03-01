package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Extension43_50;
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
public class Enumerations43_50 {

  public static void copyEnumeration(org.hl7.fhir.r4b.model.Enumeration<?> src, org.hl7.fhir.r5.model.Enumeration<?> tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    for (org.hl7.fhir.r4b.model.Extension e : src.getExtension()) {
      tgt.addExtension(Extension43_50.convertExtension(e));
    }
  }

  public static void copyEnumeration(org.hl7.fhir.r5.model.Enumeration<?> src, org.hl7.fhir.r4b.model.Enumeration<?> tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
      tgt.addExtension(Extension43_50.convertExtension(e));
    }
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.REQUIRED);
        break;
      case EXTENSIBLE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXTENSIBLE);
        break;
      case PREFERRED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.PREFERRED);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXAMPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.BindingStrength.REQUIRED);
        break;
      case EXTENSIBLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.BindingStrength.EXTENSIBLE);
        break;
      case PREFERRED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.BindingStrength.PREFERRED);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.BindingStrength.EXAMPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.BindingStrength.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.PublicationStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.PublicationStatus.ACTIVE);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.PublicationStatus.RETIRED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.PublicationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.PublicationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> convertFHIRVersion(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FHIRVersion> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FHIRVersionEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case _0_01:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_01);
        break;
      case _0_05:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_05);
        break;
      case _0_06:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_06);
        break;
      case _0_11:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_11);
        break;
      case _0_0_80:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_80);
        break;
      case _0_0_81:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_81);
        break;
      case _0_0_82:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_82);
        break;
      case _0_4_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_4_0);
        break;
      case _0_5_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_5_0);
        break;
      case _1_0_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_0);
        break;
      case _1_0_1:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_1);
        break;
      case _1_0_2:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_2);
        break;
      case _1_1_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_1_0);
        break;
      case _1_4_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_4_0);
        break;
      case _1_6_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_6_0);
        break;
      case _1_8_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_8_0);
        break;
      case _3_0_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_0);
        break;
      case _3_0_1:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_1);
        break;
      case _3_0_2:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_2);
        break;
      case _3_3_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_3_0);
        break;
      case _3_5_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_5_0);
        break;
      case _4_0_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_0_0);
        break;
      case _4_0_1:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_0_1);
        break;
      case _4_1_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_1_0);
        break;
      case _4_3_0:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_3_0);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FHIRVersion> convertFHIRVersion(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FHIRVersion> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FHIRVersionEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case _0_01:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_01);
        break;
      case _0_05:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_05);
        break;
      case _0_06:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_06);
        break;
      case _0_11:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_11);
        break;
      case _0_0_80:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_0_80);
        break;
      case _0_0_81:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_0_81);
        break;
      case _0_0_82:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_0_82);
        break;
      case _0_4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_4_0);
        break;
      case _0_5_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._0_5_0);
        break;
      case _1_0_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_0_0);
        break;
      case _1_0_1:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_0_1);
        break;
      case _1_0_2:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_0_2);
        break;
      case _1_1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_1_0);
        break;
      case _1_4_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_4_0);
        break;
      case _1_6_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_6_0);
        break;
      case _1_8_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._1_8_0);
        break;
      case _3_0_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._3_0_0);
        break;
      case _3_0_1:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._3_0_1);
        break;
      case _3_0_2:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._3_0_2);
        break;
      case _3_3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._3_3_0);
        break;
      case _3_5_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._3_5_0);
        break;
      case _4_0_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._4_0_0);
        break;
      case _4_0_1:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._4_0_1);
        break;
      case _4_1_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._4_1_0);
        break;
      case _4_3_0:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion._4_3_0);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FHIRVersion.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case NUMBER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NUMBER);
        break;
      case DATE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.DATE);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.STRING);
        break;
      case TOKEN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.TOKEN);
        break;
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.REFERENCE);
        break;
      case COMPOSITE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.COMPOSITE);
        break;
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.QUANTITY);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.URI);
        break;
      case SPECIAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.SPECIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case NUMBER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.NUMBER);
        break;
      case DATE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.DATE);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.STRING);
        break;
      case TOKEN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.TOKEN);
        break;
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.REFERENCE);
        break;
      case COMPOSITE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.COMPOSITE);
        break;
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.QUANTITY);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.URI);
        break;
      case SPECIAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.SPECIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.SearchParamType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.PaymentReconciliation.NoteType> convertNoteType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.NoteType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.PaymentReconciliation.NoteType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.PaymentReconciliation.NoteTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DISPLAY:
        tgt.setValue(org.hl7.fhir.r5.model.PaymentReconciliation.NoteType.DISPLAY);
        break;
      case PRINT:
        tgt.setValue(org.hl7.fhir.r5.model.PaymentReconciliation.NoteType.PRINT);
        break;
      case PRINTOPER:
        tgt.setValue(org.hl7.fhir.r5.model.PaymentReconciliation.NoteType.PRINTOPER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.PaymentReconciliation.NoteType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.NoteType> convertNoteType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.PaymentReconciliation.NoteType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.NoteType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.NoteTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DISPLAY:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.NoteType.DISPLAY);
        break;
      case PRINT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.NoteType.PRINT);
        break;
      case PRINTOPER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.NoteType.PRINTOPER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.NoteType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CURRENT:
        tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.CURRENT);
        break;
      case SUPERSEDED:
        tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.SUPERSEDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CURRENT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus.CURRENT);
        break;
      case SUPERSEDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentReferenceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MALE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.MALE);
        break;
      case FEMALE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.FEMALE);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.OTHER);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MALE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender.MALE);
        break;
      case FEMALE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender.FEMALE);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender.OTHER);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.AdministrativeGender.NULL);
        break;
    }
    return tgt;
  }

}