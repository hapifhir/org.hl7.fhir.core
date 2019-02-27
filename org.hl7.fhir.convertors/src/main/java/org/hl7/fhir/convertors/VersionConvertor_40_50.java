package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.conv40_50.*;
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


public class VersionConvertor_40_50 {

  protected static void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.r5.model.Element tgt) throws FHIRException {
    if (src.hasId())
      tgt.setId(src.getId());
    for (org.hl7.fhir.r4.model.Extension  e : src.getExtension()) {
      tgt.addExtension(convertExtension(e));
    }
  }

  protected static void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.r4.model.Element tgt) throws FHIRException {
    if (src.hasId())
      tgt.setId(src.getId());
    for (org.hl7.fhir.r5.model.Extension  e : src.getExtension()) {
      tgt.addExtension(convertExtension(e));
    }
  }

  protected static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt) throws FHIRException {
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Extension  e : src.getModifierExtension()) {
      tgt.addModifierExtension(convertExtension(e));
    }
  }

  protected static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Extension  e : src.getModifierExtension()) {
      tgt.addModifierExtension(convertExtension(e));
    }
  }

  protected static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneType src, org.hl7.fhir.r4.model.BackboneType tgt) throws FHIRException {
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Extension  e : src.getModifierExtension()) {
      tgt.addModifierExtension(convertExtension(e));
    }
  }

  protected static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneType src, org.hl7.fhir.r5.model.BackboneType tgt) throws FHIRException {
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Extension  e : src.getModifierExtension()) {
      tgt.addModifierExtension(convertExtension(e));
    }
  }

  protected static org.hl7.fhir.utilities.xhtml.XhtmlNode convertXhtml(org.hl7.fhir.utilities.xhtml.XhtmlNode src) throws FHIRException {
    return src;
  }

  public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r5.model.Base64BinaryType tgt = new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.r4.model.Base64BinaryType tgt = new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r5.model.BooleanType tgt = new org.hl7.fhir.r5.model.BooleanType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.r4.model.BooleanType tgt = new org.hl7.fhir.r4.model.BooleanType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CanonicalType convertCanonical(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r5.model.CanonicalType tgt = new org.hl7.fhir.r5.model.CanonicalType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CanonicalType convertCanonical(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
    org.hl7.fhir.r4.model.CanonicalType tgt = new org.hl7.fhir.r4.model.CanonicalType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r5.model.CodeType tgt = new org.hl7.fhir.r5.model.CodeType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    org.hl7.fhir.r4.model.CodeType tgt = new org.hl7.fhir.r4.model.CodeType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateType tgt = new org.hl7.fhir.r5.model.DateType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateType tgt = new org.hl7.fhir.r4.model.DateType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.DateTimeType tgt = new org.hl7.fhir.r5.model.DateTimeType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateTimeType tgt = new org.hl7.fhir.r4.model.DateTimeType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.r5.model.DecimalType tgt = new org.hl7.fhir.r5.model.DecimalType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.r4.model.DecimalType tgt = new org.hl7.fhir.r4.model.DecimalType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
    org.hl7.fhir.r5.model.IdType tgt = new org.hl7.fhir.r5.model.IdType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
    org.hl7.fhir.r4.model.IdType tgt = new org.hl7.fhir.r4.model.IdType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
    org.hl7.fhir.r5.model.InstantType tgt = new org.hl7.fhir.r5.model.InstantType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
    org.hl7.fhir.r4.model.InstantType tgt = new org.hl7.fhir.r4.model.InstantType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r5.model.IntegerType tgt = new org.hl7.fhir.r5.model.IntegerType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.r4.model.IntegerType tgt = new org.hl7.fhir.r4.model.IntegerType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r5.model.MarkdownType tgt = new org.hl7.fhir.r5.model.MarkdownType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4.model.MarkdownType tgt = new org.hl7.fhir.r4.model.MarkdownType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
    org.hl7.fhir.r5.model.OidType tgt = new org.hl7.fhir.r5.model.OidType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
    org.hl7.fhir.r4.model.OidType tgt = new org.hl7.fhir.r4.model.OidType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.PositiveIntType tgt = new org.hl7.fhir.r5.model.PositiveIntType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.PositiveIntType tgt = new org.hl7.fhir.r4.model.PositiveIntType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    org.hl7.fhir.r5.model.StringType tgt = new org.hl7.fhir.r5.model.StringType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r5.model.TimeType tgt = new org.hl7.fhir.r5.model.TimeType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
    org.hl7.fhir.r4.model.TimeType tgt = new org.hl7.fhir.r4.model.TimeType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r5.model.UnsignedIntType tgt = new org.hl7.fhir.r5.model.UnsignedIntType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.r4.model.UnsignedIntType tgt = new org.hl7.fhir.r4.model.UnsignedIntType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UriType tgt = new org.hl7.fhir.r5.model.UriType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
    org.hl7.fhir.r4.model.UriType tgt = new org.hl7.fhir.r4.model.UriType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UrlType convertUrl(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = new org.hl7.fhir.r5.model.UrlType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UrlType convertUrl(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
    org.hl7.fhir.r4.model.UrlType tgt = new org.hl7.fhir.r4.model.UrlType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r5.model.UuidType tgt = new org.hl7.fhir.r5.model.UuidType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r4.model.UuidType tgt = new org.hl7.fhir.r4.model.UuidType(src.getValue());
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
    copyElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    copyElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Narrative convertNarrative(org.hl7.fhir.r4.model.Narrative src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Narrative tgt = new org.hl7.fhir.r5.model.Narrative();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertNarrativeStatus(src.getStatus()));
    if (src.hasDiv())
      tgt.setDiv(convertXhtml(src.getDiv()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Narrative convertNarrative(org.hl7.fhir.r5.model.Narrative src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Narrative tgt = new org.hl7.fhir.r4.model.Narrative();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertNarrativeStatus(src.getStatus()));
    if (src.hasDiv())
      tgt.setDiv(convertXhtml(src.getDiv()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.r4.model.Narrative.NarrativeStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case GENERATED: return org.hl7.fhir.r5.model.Narrative.NarrativeStatus.GENERATED;
    case EXTENSIONS: return org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EXTENSIONS;
    case ADDITIONAL: return org.hl7.fhir.r5.model.Narrative.NarrativeStatus.ADDITIONAL;
    case EMPTY: return org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EMPTY;
    default: return org.hl7.fhir.r5.model.Narrative.NarrativeStatus.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.r5.model.Narrative.NarrativeStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case GENERATED: return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED;
    case EXTENSIONS: return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EXTENSIONS;
    case ADDITIONAL: return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.ADDITIONAL;
    case EMPTY: return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EMPTY;
    default: return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Address tgt = new org.hl7.fhir.r5.model.Address();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertAddressUse(src.getUse()));
    if (src.hasType())
      tgt.setType(convertAddressType(src.getType()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getLine())
      tgt.getLine().add(convertString(t));
    if (src.hasCity())
      tgt.setCityElement(convertString(src.getCityElement()));
    if (src.hasDistrict())
      tgt.setDistrictElement(convertString(src.getDistrictElement()));
    if (src.hasState())
      tgt.setStateElement(convertString(src.getStateElement()));
    if (src.hasPostalCode())
      tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
    if (src.hasCountry())
      tgt.setCountryElement(convertString(src.getCountryElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Address convertAddress(org.hl7.fhir.r5.model.Address src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Address tgt = new org.hl7.fhir.r4.model.Address();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertAddressUse(src.getUse()));
    if (src.hasType())
      tgt.setType(convertAddressType(src.getType()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLine())
      tgt.getLine().add(convertString(t));
    if (src.hasCity())
      tgt.setCityElement(convertString(src.getCityElement()));
    if (src.hasDistrict())
      tgt.setDistrictElement(convertString(src.getDistrictElement()));
    if (src.hasState())
      tgt.setStateElement(convertString(src.getStateElement()));
    if (src.hasPostalCode())
      tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
    if (src.hasCountry())
      tgt.setCountryElement(convertString(src.getCountryElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Address.AddressUse convertAddressUse(org.hl7.fhir.r4.model.Address.AddressUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HOME: return org.hl7.fhir.r5.model.Address.AddressUse.HOME;
    case WORK: return org.hl7.fhir.r5.model.Address.AddressUse.WORK;
    case TEMP: return org.hl7.fhir.r5.model.Address.AddressUse.TEMP;
    case OLD: return org.hl7.fhir.r5.model.Address.AddressUse.OLD;
    case BILLING: return org.hl7.fhir.r5.model.Address.AddressUse.BILLING;
    default: return org.hl7.fhir.r5.model.Address.AddressUse.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Address.AddressUse convertAddressUse(org.hl7.fhir.r5.model.Address.AddressUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HOME: return org.hl7.fhir.r4.model.Address.AddressUse.HOME;
    case WORK: return org.hl7.fhir.r4.model.Address.AddressUse.WORK;
    case TEMP: return org.hl7.fhir.r4.model.Address.AddressUse.TEMP;
    case OLD: return org.hl7.fhir.r4.model.Address.AddressUse.OLD;
    case BILLING: return org.hl7.fhir.r4.model.Address.AddressUse.BILLING;
    default: return org.hl7.fhir.r4.model.Address.AddressUse.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Address.AddressType convertAddressType(org.hl7.fhir.r4.model.Address.AddressType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case POSTAL: return org.hl7.fhir.r5.model.Address.AddressType.POSTAL;
    case PHYSICAL: return org.hl7.fhir.r5.model.Address.AddressType.PHYSICAL;
    case BOTH: return org.hl7.fhir.r5.model.Address.AddressType.BOTH;
    default: return org.hl7.fhir.r5.model.Address.AddressType.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Address.AddressType convertAddressType(org.hl7.fhir.r5.model.Address.AddressType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case POSTAL: return org.hl7.fhir.r4.model.Address.AddressType.POSTAL;
    case PHYSICAL: return org.hl7.fhir.r4.model.Address.AddressType.PHYSICAL;
    case BOTH: return org.hl7.fhir.r4.model.Address.AddressType.BOTH;
    default: return org.hl7.fhir.r4.model.Address.AddressType.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Age convertAge(org.hl7.fhir.r4.model.Age src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Age tgt = new org.hl7.fhir.r5.model.Age();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Age convertAge(org.hl7.fhir.r5.model.Age src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Age tgt = new org.hl7.fhir.r4.model.Age();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
    copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(convertType(src.getAuthor()));
    if (src.hasTime())
      tgt.setTimeElement(convertDateTime(src.getTimeElement()));
    if (src.hasText())
      tgt.setTextElement(convertMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
    copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(convertType(src.getAuthor()));
    if (src.hasTime())
      tgt.setTimeElement(convertDateTime(src.getTimeElement()));
    if (src.hasText())
      tgt.setTextElement(convertMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Attachment tgt = new org.hl7.fhir.r5.model.Attachment();
    copyElement(src, tgt);
    if (src.hasContentType())
      tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasData())
      tgt.setDataElement(convertBase64Binary(src.getDataElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUrl(src.getUrlElement()));
    if (src.hasSize())
      tgt.setSizeElement(convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash())
      tgt.setHashElement(convertBase64Binary(src.getHashElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasCreation())
      tgt.setCreationElement(convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
    copyElement(src, tgt);
    if (src.hasContentType())
      tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasData())
      tgt.setDataElement(convertBase64Binary(src.getDataElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUrl(src.getUrlElement()));
    if (src.hasSize())
      tgt.setSizeElement(convertUnsignedInt(src.getSizeElement()));
    if (src.hasHash())
      tgt.setHashElement(convertBase64Binary(src.getHashElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasCreation())
      tgt.setCreationElement(convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getCoding())
      tgt.addCoding(convertCoding(t));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getCoding())
      tgt.addCoding(convertCoding(t));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasUserSelected())
      tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasUserSelected())
      tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertContactDetail(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactDetail convertContactDetail(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.r4.model.ContactPoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystem(convertContactPointSystem(src.getSystem()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasUse())
      tgt.setUse(convertContactPointUse(src.getUse()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ContactPoint tgt = new org.hl7.fhir.r4.model.ContactPoint();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystem(convertContactPointSystem(src.getSystem()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasUse())
      tgt.setUse(convertContactPointUse(src.getUse()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PHONE: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PHONE;
    case FAX: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.FAX;
    case EMAIL: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.EMAIL;
    case PAGER: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PAGER;
    case URL: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.URL;
    case SMS: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.SMS;
    case OTHER: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.OTHER;
    default: return org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PHONE: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PHONE;
    case FAX: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.FAX;
    case EMAIL: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.EMAIL;
    case PAGER: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PAGER;
    case URL: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.URL;
    case SMS: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.SMS;
    case OTHER: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.OTHER;
    default: return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HOME: return org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.HOME;
    case WORK: return org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.WORK;
    case TEMP: return org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.TEMP;
    case OLD: return org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.OLD;
    case MOBILE: return org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.MOBILE;
    default: return org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HOME: return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.HOME;
    case WORK: return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.WORK;
    case TEMP: return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.TEMP;
    case OLD: return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.OLD;
    case MOBILE: return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.MOBILE;
    default: return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Contributor convertContributor(org.hl7.fhir.r4.model.Contributor src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contributor tgt = new org.hl7.fhir.r5.model.Contributor();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertContributorType(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Contributor convertContributor(org.hl7.fhir.r5.model.Contributor src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Contributor tgt = new org.hl7.fhir.r4.model.Contributor();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertContributorType(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contributor.ContributorType convertContributorType(org.hl7.fhir.r4.model.Contributor.ContributorType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AUTHOR: return org.hl7.fhir.r5.model.Contributor.ContributorType.AUTHOR;
    case EDITOR: return org.hl7.fhir.r5.model.Contributor.ContributorType.EDITOR;
    case REVIEWER: return org.hl7.fhir.r5.model.Contributor.ContributorType.REVIEWER;
    case ENDORSER: return org.hl7.fhir.r5.model.Contributor.ContributorType.ENDORSER;
    default: return org.hl7.fhir.r5.model.Contributor.ContributorType.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Contributor.ContributorType convertContributorType(org.hl7.fhir.r5.model.Contributor.ContributorType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AUTHOR: return org.hl7.fhir.r4.model.Contributor.ContributorType.AUTHOR;
    case EDITOR: return org.hl7.fhir.r4.model.Contributor.ContributorType.EDITOR;
    case REVIEWER: return org.hl7.fhir.r4.model.Contributor.ContributorType.REVIEWER;
    case ENDORSER: return org.hl7.fhir.r4.model.Contributor.ContributorType.ENDORSER;
    default: return org.hl7.fhir.r4.model.Contributor.ContributorType.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Count convertCount(org.hl7.fhir.r4.model.Count src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Count tgt = new org.hl7.fhir.r5.model.Count();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Count convertCount(org.hl7.fhir.r5.model.Count src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Count tgt = new org.hl7.fhir.r4.model.Count();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement convertDataRequirement(org.hl7.fhir.r4.model.DataRequirement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DataRequirement tgt = new org.hl7.fhir.r5.model.DataRequirement();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(convertType(src.getSubject()));
    for (org.hl7.fhir.r4.model.StringType t : src.getMustSupport())
      tgt.getMustSupport().add(convertString(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit())
      tgt.setLimitElement(convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement convertDataRequirement(org.hl7.fhir.r5.model.DataRequirement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DataRequirement tgt = new org.hl7.fhir.r4.model.DataRequirement();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(convertCanonical(t));
    if (src.hasSubject())
      tgt.setSubject(convertType(src.getSubject()));
    for (org.hl7.fhir.r5.model.StringType t : src.getMustSupport())
      tgt.getMustSupport().add(convertString(t));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter())
      tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter())
      tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
    if (src.hasLimit())
      tgt.setLimitElement(convertPositiveInt(src.getLimitElement()));
    for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent t : src.getSort())
      tgt.addSort(convertDataRequirementSortComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasSearchParam())
      tgt.setSearchParamElement(convertString(src.getSearchParamElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode())
      tgt.addCode(convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent convertDataRequirementCodeFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasSearchParam())
      tgt.setSearchParamElement(convertString(src.getSearchParamElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode())
      tgt.addCode(convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasSearchParam())
      tgt.setSearchParamElement(convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent convertDataRequirementDateFilterComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasSearchParam())
      tgt.setSearchParamElement(convertString(src.getSearchParamElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasDirection())
      tgt.setDirection(convertSortDirection(src.getDirection()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent convertDataRequirementSortComponent(org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent tgt = new org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasDirection())
      tgt.setDirection(convertSortDirection(src.getDirection()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DataRequirement.SortDirection convertSortDirection(org.hl7.fhir.r4.model.DataRequirement.SortDirection src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ASCENDING: return org.hl7.fhir.r5.model.DataRequirement.SortDirection.ASCENDING;
    case DESCENDING: return org.hl7.fhir.r5.model.DataRequirement.SortDirection.DESCENDING;
    default: return org.hl7.fhir.r5.model.DataRequirement.SortDirection.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.DataRequirement.SortDirection convertSortDirection(org.hl7.fhir.r5.model.DataRequirement.SortDirection src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ASCENDING: return org.hl7.fhir.r4.model.DataRequirement.SortDirection.ASCENDING;
    case DESCENDING: return org.hl7.fhir.r4.model.DataRequirement.SortDirection.DESCENDING;
    default: return org.hl7.fhir.r4.model.DataRequirement.SortDirection.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Distance tgt = new org.hl7.fhir.r5.model.Distance();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.r5.model.Distance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Dosage convertDosage(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertInteger(src.getSequenceElement()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
    if (src.hasTiming())
      tgt.setTiming(convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(convertType(src.getAsNeeded()));
    if (src.hasSite())
      tgt.setSite(convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage convertDosage(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
    copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertInteger(src.getSequenceElement()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
    if (src.hasTiming())
      tgt.setTiming(convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(convertType(src.getAsNeeded()));
    if (src.hasSite())
      tgt.setSite(convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Duration convertDuration(org.hl7.fhir.r4.model.Duration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Duration tgt = new org.hl7.fhir.r5.model.Duration();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Duration convertDuration(org.hl7.fhir.r5.model.Duration src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Duration tgt = new org.hl7.fhir.r4.model.Duration();
    copyQuantity(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Expression convertExpression(org.hl7.fhir.r4.model.Expression src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Expression tgt = new org.hl7.fhir.r5.model.Expression();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    if (src.hasLanguage())
      tgt.setLanguage(convertExpressionLanguage(src.getLanguage()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasReference())
      tgt.setReferenceElement(convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Expression convertExpression(org.hl7.fhir.r5.model.Expression src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Expression tgt = new org.hl7.fhir.r4.model.Expression();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasName())
      tgt.setNameElement(convertId(src.getNameElement()));
    if (src.hasLanguage())
      tgt.setLanguage(convertExpressionLanguage(src.getLanguage()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasReference())
      tgt.setReferenceElement(convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Expression.ExpressionLanguage convertExpressionLanguage(org.hl7.fhir.r4.model.Expression.ExpressionLanguage src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TEXT_CQL: return org.hl7.fhir.r5.model.Expression.ExpressionLanguage.TEXT_CQL;
    case TEXT_FHIRPATH: return org.hl7.fhir.r5.model.Expression.ExpressionLanguage.TEXT_FHIRPATH;
    case APPLICATION_XFHIRQUERY: return org.hl7.fhir.r5.model.Expression.ExpressionLanguage.APPLICATION_XFHIRQUERY;
    default: return org.hl7.fhir.r5.model.Expression.ExpressionLanguage.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Expression.ExpressionLanguage convertExpressionLanguage(org.hl7.fhir.r5.model.Expression.ExpressionLanguage src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TEXT_CQL: return org.hl7.fhir.r4.model.Expression.ExpressionLanguage.TEXT_CQL;
    case TEXT_FHIRPATH: return org.hl7.fhir.r4.model.Expression.ExpressionLanguage.TEXT_FHIRPATH;
    case APPLICATION_XFHIRQUERY: return org.hl7.fhir.r4.model.Expression.ExpressionLanguage.APPLICATION_XFHIRQUERY;
    default: return org.hl7.fhir.r4.model.Expression.ExpressionLanguage.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.HumanName tgt = new org.hl7.fhir.r5.model.HumanName();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertNameUse(src.getUse()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasFamily())
      tgt.setFamilyElement(convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getGiven())
      tgt.getGiven().add(convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getPrefix())
      tgt.getPrefix().add(convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getSuffix())
      tgt.getSuffix().add(convertString(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.r5.model.HumanName src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertNameUse(src.getUse()));
    if (src.hasText())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasFamily())
      tgt.setFamilyElement(convertString(src.getFamilyElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getGiven())
      tgt.getGiven().add(convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getPrefix())
      tgt.getPrefix().add(convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getSuffix())
      tgt.getSuffix().add(convertString(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.HumanName.NameUse convertNameUse(org.hl7.fhir.r4.model.HumanName.NameUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case USUAL: return org.hl7.fhir.r5.model.HumanName.NameUse.USUAL;
    case OFFICIAL: return org.hl7.fhir.r5.model.HumanName.NameUse.OFFICIAL;
    case TEMP: return org.hl7.fhir.r5.model.HumanName.NameUse.TEMP;
    case NICKNAME: return org.hl7.fhir.r5.model.HumanName.NameUse.NICKNAME;
    case ANONYMOUS: return org.hl7.fhir.r5.model.HumanName.NameUse.ANONYMOUS;
    case OLD: return org.hl7.fhir.r5.model.HumanName.NameUse.OLD;
    case MAIDEN: return org.hl7.fhir.r5.model.HumanName.NameUse.MAIDEN;
    default: return org.hl7.fhir.r5.model.HumanName.NameUse.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.HumanName.NameUse convertNameUse(org.hl7.fhir.r5.model.HumanName.NameUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case USUAL: return org.hl7.fhir.r4.model.HumanName.NameUse.USUAL;
    case OFFICIAL: return org.hl7.fhir.r4.model.HumanName.NameUse.OFFICIAL;
    case TEMP: return org.hl7.fhir.r4.model.HumanName.NameUse.TEMP;
    case NICKNAME: return org.hl7.fhir.r4.model.HumanName.NameUse.NICKNAME;
    case ANONYMOUS: return org.hl7.fhir.r4.model.HumanName.NameUse.ANONYMOUS;
    case OLD: return org.hl7.fhir.r4.model.HumanName.NameUse.OLD;
    case MAIDEN: return org.hl7.fhir.r4.model.HumanName.NameUse.MAIDEN;
    default: return org.hl7.fhir.r4.model.HumanName.NameUse.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertIdentifierUse(src.getUse()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasAssigner())
      tgt.setAssigner(convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertIdentifierUse(src.getUse()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasValue())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasAssigner())
      tgt.setAssigner(convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.r4.model.Identifier.IdentifierUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case USUAL: return org.hl7.fhir.r5.model.Identifier.IdentifierUse.USUAL;
    case OFFICIAL: return org.hl7.fhir.r5.model.Identifier.IdentifierUse.OFFICIAL;
    case TEMP: return org.hl7.fhir.r5.model.Identifier.IdentifierUse.TEMP;
    case SECONDARY: return org.hl7.fhir.r5.model.Identifier.IdentifierUse.SECONDARY;
    case OLD: return org.hl7.fhir.r5.model.Identifier.IdentifierUse.OLD;
    default: return org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.r5.model.Identifier.IdentifierUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case USUAL: return org.hl7.fhir.r4.model.Identifier.IdentifierUse.USUAL;
    case OFFICIAL: return org.hl7.fhir.r4.model.Identifier.IdentifierUse.OFFICIAL;
    case TEMP: return org.hl7.fhir.r4.model.Identifier.IdentifierUse.TEMP;
    case SECONDARY: return org.hl7.fhir.r4.model.Identifier.IdentifierUse.SECONDARY;
    case OLD: return org.hl7.fhir.r4.model.Identifier.IdentifierUse.OLD;
    default: return org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.r4.model.MarketingStatus src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MarketingStatus tgt = new org.hl7.fhir.r5.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry())
      tgt.setCountry(convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction())
      tgt.setJurisdiction(convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange())
      tgt.setDateRange(convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate())
      tgt.setRestoreDateElement(convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.r5.model.MarketingStatus src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MarketingStatus tgt = new org.hl7.fhir.r4.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry())
      tgt.setCountry(convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction())
      tgt.setJurisdiction(convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange())
      tgt.setDateRange(convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate())
      tgt.setRestoreDateElement(convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
    copyElement(src, tgt);
    if (src.hasVersionId())
      tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated())
      tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource())
      tgt.setSourceElement(convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurity())
      tgt.addSecurity(convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getTag())
      tgt.addTag(convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
    copyElement(src, tgt);
    if (src.hasVersionId())
      tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated())
      tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource())
      tgt.setSourceElement(convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurity())
      tgt.addSecurity(convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getTag())
      tgt.addTag(convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasCurrency())
      tgt.setCurrencyElement(convertCode(src.getCurrencyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasCurrency())
      tgt.setCurrencyElement(convertCode(src.getCurrencyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r4.model.ParameterDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ParameterDefinition tgt = new org.hl7.fhir.r5.model.ParameterDefinition();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUse(convertParameterUse(src.getUse()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r5.model.ParameterDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ParameterDefinition tgt = new org.hl7.fhir.r4.model.ParameterDefinition();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUse(convertParameterUse(src.getUse()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ParameterDefinition.ParameterUse convertParameterUse(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case IN: return org.hl7.fhir.r5.model.ParameterDefinition.ParameterUse.IN;
    case OUT: return org.hl7.fhir.r5.model.ParameterDefinition.ParameterUse.OUT;
    default: return org.hl7.fhir.r5.model.ParameterDefinition.ParameterUse.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse convertParameterUse(org.hl7.fhir.r5.model.ParameterDefinition.ParameterUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case IN: return org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.IN;
    case OUT: return org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.OUT;
    default: return org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertDateTime(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertDateTime(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Population convertPopulation(org.hl7.fhir.r4.model.Population src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Population tgt = new org.hl7.fhir.r5.model.Population();
    copyBackboneElement(src, tgt);
    if (src.hasAge())
      tgt.setAge(convertType(src.getAge()));
    if (src.hasGender())
      tgt.setGender(convertCodeableConcept(src.getGender()));
    if (src.hasRace())
      tgt.setRace(convertCodeableConcept(src.getRace()));
    if (src.hasPhysiologicalCondition())
      tgt.setPhysiologicalCondition(convertCodeableConcept(src.getPhysiologicalCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Population convertPopulation(org.hl7.fhir.r5.model.Population src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Population tgt = new org.hl7.fhir.r4.model.Population();
    copyBackboneElement(src, tgt);
    if (src.hasAge())
      tgt.setAge(convertType(src.getAge()));
    if (src.hasGender())
      tgt.setGender(convertCodeableConcept(src.getGender()));
    if (src.hasRace())
      tgt.setRace(convertCodeableConcept(src.getRace()));
    if (src.hasPhysiologicalCondition())
      tgt.setPhysiologicalCondition(convertCodeableConcept(src.getPhysiologicalCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ProdCharacteristic convertProdCharacteristic(org.hl7.fhir.r4.model.ProdCharacteristic src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ProdCharacteristic tgt = new org.hl7.fhir.r5.model.ProdCharacteristic();
    copyBackboneElement(src, tgt);
    if (src.hasHeight())
      tgt.setHeight(convertQuantity(src.getHeight()));
    if (src.hasWidth())
      tgt.setWidth(convertQuantity(src.getWidth()));
    if (src.hasDepth())
      tgt.setDepth(convertQuantity(src.getDepth()));
    if (src.hasWeight())
      tgt.setWeight(convertQuantity(src.getWeight()));
    if (src.hasNominalVolume())
      tgt.setNominalVolume(convertQuantity(src.getNominalVolume()));
    if (src.hasExternalDiameter())
      tgt.setExternalDiameter(convertQuantity(src.getExternalDiameter()));
    if (src.hasShape())
      tgt.setShapeElement(convertString(src.getShapeElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getColor())
      tgt.getColor().add(convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getImprint())
      tgt.getImprint().add(convertString(t));
    for (org.hl7.fhir.r4.model.Attachment t : src.getImage())
      tgt.addImage(convertAttachment(t));
    if (src.hasScoring())
      tgt.setScoring(convertCodeableConcept(src.getScoring()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ProdCharacteristic convertProdCharacteristic(org.hl7.fhir.r5.model.ProdCharacteristic src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ProdCharacteristic tgt = new org.hl7.fhir.r4.model.ProdCharacteristic();
    copyBackboneElement(src, tgt);
    if (src.hasHeight())
      tgt.setHeight(convertQuantity(src.getHeight()));
    if (src.hasWidth())
      tgt.setWidth(convertQuantity(src.getWidth()));
    if (src.hasDepth())
      tgt.setDepth(convertQuantity(src.getDepth()));
    if (src.hasWeight())
      tgt.setWeight(convertQuantity(src.getWeight()));
    if (src.hasNominalVolume())
      tgt.setNominalVolume(convertQuantity(src.getNominalVolume()));
    if (src.hasExternalDiameter())
      tgt.setExternalDiameter(convertQuantity(src.getExternalDiameter()));
    if (src.hasShape())
      tgt.setShapeElement(convertString(src.getShapeElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getColor())
      tgt.getColor().add(convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImprint())
      tgt.getImprint().add(convertString(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getImage())
      tgt.addImage(convertAttachment(t));
    if (src.hasScoring())
      tgt.setScoring(convertCodeableConcept(src.getScoring()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r4.model.ProductShelfLife src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ProductShelfLife tgt = new org.hl7.fhir.r5.model.ProductShelfLife();
    copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(convertQuantity(src.getPeriod()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r5.model.ProductShelfLife src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ProductShelfLife tgt = new org.hl7.fhir.r4.model.ProductShelfLife();
    copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(convertQuantity(src.getPeriod()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(convertCodeableConcept(t));
    return tgt;
  }

  public static void copyQuantity(org.hl7.fhir.r4.model.Quantity src, org.hl7.fhir.r5.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null)
      return;
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(src.getValue());
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnit(src.getUnit());
    if (src.hasSystem())
      tgt.setSystem(src.getSystem());
    if (src.hasCode())
      tgt.setCode(src.getCode());
  }

  public static void copyQuantity(org.hl7.fhir.r5.model.Quantity src, org.hl7.fhir.r4.model.Quantity tgt) throws FHIRException {
    if (src == null || tgt == null)
      return;
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(src.getValue());
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnit(src.getUnit());
    if (src.hasSystem())
      tgt.setSystem(src.getSystem());
    if (src.hasCode())
      tgt.setCode(src.getCode());
  }

  public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.r4.model.Quantity.QuantityComparator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LESS_THAN: return org.hl7.fhir.r5.model.Quantity.QuantityComparator.LESS_THAN;
    case LESS_OR_EQUAL: return org.hl7.fhir.r5.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
    case GREATER_OR_EQUAL: return org.hl7.fhir.r5.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
    case GREATER_THAN: return org.hl7.fhir.r5.model.Quantity.QuantityComparator.GREATER_THAN;
    default: return org.hl7.fhir.r5.model.Quantity.QuantityComparator.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.r5.model.Quantity.QuantityComparator src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LESS_THAN: return org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_THAN;
    case LESS_OR_EQUAL: return org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
    case GREATER_OR_EQUAL: return org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
    case GREATER_THAN: return org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_THAN;
    default: return org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
    copyElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
    copyElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
    copyElement(src, tgt);
    if (src.hasNumerator())
      tgt.setNumerator(convertQuantity(src.getNumerator()));
    if (src.hasDenominator())
      tgt.setDenominator(convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
    copyElement(src, tgt);
    if (src.hasNumerator())
      tgt.setNumerator(convertQuantity(src.getNumerator()));
    if (src.hasDenominator())
      tgt.setDenominator(convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReferenceElement(convertString(src.getReferenceElement_()));
    if (src.hasType())
      tgt.setTypeElement(convertUri(src.getTypeElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReferenceElement(convertString(src.getReferenceElement_()));
    if (src.hasType())
      tgt.setTypeElement(convertUri(src.getTypeElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r4.model.RelatedArtifact src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertRelatedArtifactType(src.getType()));
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasCitation())
      tgt.setCitationElement(convertMarkdown(src.getCitationElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUrl(src.getUrlElement()));
    if (src.hasDocument())
      tgt.setDocument(convertAttachment(src.getDocument()));
    if (src.hasResource())
      tgt.setResourceElement(convertCanonical(src.getResourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RelatedArtifact convertRelatedArtifact(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RelatedArtifact tgt = new org.hl7.fhir.r4.model.RelatedArtifact();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertRelatedArtifactType(src.getType()));
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasCitation())
      tgt.setCitationElement(convertMarkdown(src.getCitationElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUrl(src.getUrlElement()));
    if (src.hasDocument())
      tgt.setDocument(convertAttachment(src.getDocument()));
    if (src.hasResource())
      tgt.setResourceElement(convertCanonical(src.getResourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType convertRelatedArtifactType(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DOCUMENTATION: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION;
    case JUSTIFICATION: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION;
    case CITATION: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.CITATION;
    case PREDECESSOR: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR;
    case SUCCESSOR: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR;
    case DERIVEDFROM: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM;
    case DEPENDSON: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DEPENDSON;
    case COMPOSEDOF: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF;
    default: return org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType convertRelatedArtifactType(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DOCUMENTATION: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION;
    case JUSTIFICATION: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION;
    case CITATION: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.CITATION;
    case PREDECESSOR: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR;
    case SUCCESSOR: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR;
    case DERIVEDFROM: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM;
    case DEPENDSON: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DEPENDSON;
    case COMPOSEDOF: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF;
    default: return org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
    copyElement(src, tgt);
    if (src.hasOrigin())
      tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit())
      tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit())
      tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions())
      tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData())
      tgt.setDataElement(convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
    copyElement(src, tgt);
    if (src.hasOrigin())
      tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit())
      tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit())
      tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions())
      tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData())
      tgt.setDataElement(convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Coding t : src.getType())
      tgt.addType(convertCoding(t));
    if (src.hasWhen())
      tgt.setWhenElement(convertInstant(src.getWhenElement()));
    if (src.hasWho())
      tgt.setWho(convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat())
      tgt.setTargetFormatElement(convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat())
      tgt.setSigFormatElement(convertCode(src.getSigFormatElement()));
    if (src.hasData())
      tgt.setDataElement(convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Coding t : src.getType())
      tgt.addType(convertCoding(t));
    if (src.hasWhen())
      tgt.setWhenElement(convertInstant(src.getWhenElement()));
    if (src.hasWho())
      tgt.setWho(convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(convertReference(src.getOnBehalfOf()));
    if (src.hasTargetFormat())
      tgt.setTargetFormatElement(convertCode(src.getTargetFormatElement()));
    if (src.hasSigFormat())
      tgt.setSigFormatElement(convertCode(src.getSigFormatElement()));
    if (src.hasData())
      tgt.setDataElement(convertBase64Binary(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceAmount convertSubstanceAmount(org.hl7.fhir.r4.model.SubstanceAmount src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceAmount tgt = new org.hl7.fhir.r5.model.SubstanceAmount();
    copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    if (src.hasAmountType())
      tgt.setAmountType(convertCodeableConcept(src.getAmountType()));
    if (src.hasAmountText())
      tgt.setAmountTextElement(convertString(src.getAmountTextElement()));
    if (src.hasReferenceRange())
      tgt.setReferenceRange(convertSubstanceAmountReferenceRangeComponent(src.getReferenceRange()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceAmount convertSubstanceAmount(org.hl7.fhir.r5.model.SubstanceAmount src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceAmount tgt = new org.hl7.fhir.r4.model.SubstanceAmount();
    copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    if (src.hasAmountType())
      tgt.setAmountType(convertCodeableConcept(src.getAmountType()));
    if (src.hasAmountText())
      tgt.setAmountTextElement(convertString(src.getAmountTextElement()));
    if (src.hasReferenceRange())
      tgt.setReferenceRange(convertSubstanceAmountReferenceRangeComponent(src.getReferenceRange()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent convertSubstanceAmountReferenceRangeComponent(org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent();
    copyElement(src, tgt);
    if (src.hasLowLimit())
      tgt.setLowLimit(convertQuantity(src.getLowLimit()));
    if (src.hasHighLimit())
      tgt.setHighLimit(convertQuantity(src.getHighLimit()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent convertSubstanceAmountReferenceRangeComponent(org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent();
    copyElement(src, tgt);
    if (src.hasLowLimit())
      tgt.setLowLimit(convertQuantity(src.getLowLimit()));
    if (src.hasHighLimit())
      tgt.setHighLimit(convertQuantity(src.getHighLimit()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Timing convertTiming(org.hl7.fhir.r4.model.Timing src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Timing tgt = new org.hl7.fhir.r5.model.Timing();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent())
      tgt.getEvent().add(convertDateTime(t));
    if (src.hasRepeat())
      tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Timing convertTiming(org.hl7.fhir.r5.model.Timing src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Timing tgt = new org.hl7.fhir.r4.model.Timing();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.DateTimeType t : src.getEvent())
      tgt.getEvent().add(convertDateTime(t));
    if (src.hasRepeat())
      tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r5.model.Timing.TimingRepeatComponent();
    copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(convertType(src.getBounds()));
    if (src.hasCount())
      tgt.setCountElement(convertPositiveInt(src.getCountElement()));
    if (src.hasCountMax())
      tgt.setCountMaxElement(convertPositiveInt(src.getCountMaxElement()));
    if (src.hasDuration())
      tgt.setDurationElement(convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax())
      tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit())
      tgt.setDurationUnit(convertUnitsOfTime(src.getDurationUnit()));
    if (src.hasFrequency())
      tgt.setFrequencyElement(convertPositiveInt(src.getFrequencyElement()));
    if (src.hasFrequencyMax())
      tgt.setFrequencyMaxElement(convertPositiveInt(src.getFrequencyMaxElement()));
    if (src.hasPeriod())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax())
      tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit())
      tgt.setPeriodUnit(convertUnitsOfTime(src.getPeriodUnit()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> t : src.getDayOfWeek())
      tgt.addDayOfWeek(convertDayOfWeek(t.getValue()));
    for (org.hl7.fhir.r4.model.TimeType t : src.getTimeOfDay())
      tgt.getTimeOfDay().add(convertTime(t));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> t : src.getWhen())
      tgt.addWhen(convertEventTiming(t.getValue()));
    if (src.hasOffset())
      tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4.model.Timing.TimingRepeatComponent();
    copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(convertType(src.getBounds()));
    if (src.hasCount())
      tgt.setCountElement(convertPositiveInt(src.getCountElement()));
    if (src.hasCountMax())
      tgt.setCountMaxElement(convertPositiveInt(src.getCountMaxElement()));
    if (src.hasDuration())
      tgt.setDurationElement(convertDecimal(src.getDurationElement()));
    if (src.hasDurationMax())
      tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit())
      tgt.setDurationUnit(convertUnitsOfTime(src.getDurationUnit()));
    if (src.hasFrequency())
      tgt.setFrequencyElement(convertPositiveInt(src.getFrequencyElement()));
    if (src.hasFrequencyMax())
      tgt.setFrequencyMaxElement(convertPositiveInt(src.getFrequencyMaxElement()));
    if (src.hasPeriod())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMax())
      tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit())
      tgt.setPeriodUnit(convertUnitsOfTime(src.getPeriodUnit()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.DayOfWeek> t : src.getDayOfWeek())
      tgt.addDayOfWeek(convertDayOfWeek(t.getValue()));
    for (org.hl7.fhir.r5.model.TimeType t : src.getTimeOfDay())
      tgt.getTimeOfDay().add(convertTime(t));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> t : src.getWhen())
      tgt.addWhen(convertEventTiming(t.getValue()));
    if (src.hasOffset())
      tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.r4.model.Timing.UnitsOfTime src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case S: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.S;
    case MIN: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.MIN;
    case H: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.H;
    case D: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.D;
    case WK: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.WK;
    case MO: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.MO;
    case A: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.A;
    default: return org.hl7.fhir.r5.model.Timing.UnitsOfTime.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.r5.model.Timing.UnitsOfTime src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case S: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.S;
    case MIN: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.MIN;
    case H: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.H;
    case D: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.D;
    case WK: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.WK;
    case MO: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.MO;
    case A: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.A;
    default: return org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Timing.DayOfWeek convertDayOfWeek(org.hl7.fhir.r4.model.Timing.DayOfWeek src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MON: return org.hl7.fhir.r5.model.Timing.DayOfWeek.MON;
    case TUE: return org.hl7.fhir.r5.model.Timing.DayOfWeek.TUE;
    case WED: return org.hl7.fhir.r5.model.Timing.DayOfWeek.WED;
    case THU: return org.hl7.fhir.r5.model.Timing.DayOfWeek.THU;
    case FRI: return org.hl7.fhir.r5.model.Timing.DayOfWeek.FRI;
    case SAT: return org.hl7.fhir.r5.model.Timing.DayOfWeek.SAT;
    case SUN: return org.hl7.fhir.r5.model.Timing.DayOfWeek.SUN;
    default: return org.hl7.fhir.r5.model.Timing.DayOfWeek.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Timing.DayOfWeek convertDayOfWeek(org.hl7.fhir.r5.model.Timing.DayOfWeek src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MON: return org.hl7.fhir.r4.model.Timing.DayOfWeek.MON;
    case TUE: return org.hl7.fhir.r4.model.Timing.DayOfWeek.TUE;
    case WED: return org.hl7.fhir.r4.model.Timing.DayOfWeek.WED;
    case THU: return org.hl7.fhir.r4.model.Timing.DayOfWeek.THU;
    case FRI: return org.hl7.fhir.r4.model.Timing.DayOfWeek.FRI;
    case SAT: return org.hl7.fhir.r4.model.Timing.DayOfWeek.SAT;
    case SUN: return org.hl7.fhir.r4.model.Timing.DayOfWeek.SUN;
    default: return org.hl7.fhir.r4.model.Timing.DayOfWeek.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.r4.model.Timing.EventTiming src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MORN: return org.hl7.fhir.r5.model.Timing.EventTiming.MORN;
    case MORN_EARLY: return org.hl7.fhir.r5.model.Timing.EventTiming.MORN_EARLY;
    case MORN_LATE: return org.hl7.fhir.r5.model.Timing.EventTiming.MORN_LATE;
    case NOON: return org.hl7.fhir.r5.model.Timing.EventTiming.NOON;
    case AFT: return org.hl7.fhir.r5.model.Timing.EventTiming.AFT;
    case AFT_EARLY: return org.hl7.fhir.r5.model.Timing.EventTiming.AFT_EARLY;
    case AFT_LATE: return org.hl7.fhir.r5.model.Timing.EventTiming.AFT_LATE;
    case EVE: return org.hl7.fhir.r5.model.Timing.EventTiming.EVE;
    case EVE_EARLY: return org.hl7.fhir.r5.model.Timing.EventTiming.EVE_EARLY;
    case EVE_LATE: return org.hl7.fhir.r5.model.Timing.EventTiming.EVE_LATE;
    case NIGHT: return org.hl7.fhir.r5.model.Timing.EventTiming.NIGHT;
    case PHS: return org.hl7.fhir.r5.model.Timing.EventTiming.PHS;
    case HS: return org.hl7.fhir.r5.model.Timing.EventTiming.HS;
    case WAKE: return org.hl7.fhir.r5.model.Timing.EventTiming.WAKE;
    case C: return org.hl7.fhir.r5.model.Timing.EventTiming.C;
    case CM: return org.hl7.fhir.r5.model.Timing.EventTiming.CM;
    case CD: return org.hl7.fhir.r5.model.Timing.EventTiming.CD;
    case CV: return org.hl7.fhir.r5.model.Timing.EventTiming.CV;
    case AC: return org.hl7.fhir.r5.model.Timing.EventTiming.AC;
    case ACM: return org.hl7.fhir.r5.model.Timing.EventTiming.ACM;
    case ACD: return org.hl7.fhir.r5.model.Timing.EventTiming.ACD;
    case ACV: return org.hl7.fhir.r5.model.Timing.EventTiming.ACV;
    case PC: return org.hl7.fhir.r5.model.Timing.EventTiming.PC;
    case PCM: return org.hl7.fhir.r5.model.Timing.EventTiming.PCM;
    case PCD: return org.hl7.fhir.r5.model.Timing.EventTiming.PCD;
    case PCV: return org.hl7.fhir.r5.model.Timing.EventTiming.PCV;
    default: return org.hl7.fhir.r5.model.Timing.EventTiming.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.r5.model.Timing.EventTiming src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MORN: return org.hl7.fhir.r4.model.Timing.EventTiming.MORN;
    case MORN_EARLY: return org.hl7.fhir.r4.model.Timing.EventTiming.MORN_EARLY;
    case MORN_LATE: return org.hl7.fhir.r4.model.Timing.EventTiming.MORN_LATE;
    case NOON: return org.hl7.fhir.r4.model.Timing.EventTiming.NOON;
    case AFT: return org.hl7.fhir.r4.model.Timing.EventTiming.AFT;
    case AFT_EARLY: return org.hl7.fhir.r4.model.Timing.EventTiming.AFT_EARLY;
    case AFT_LATE: return org.hl7.fhir.r4.model.Timing.EventTiming.AFT_LATE;
    case EVE: return org.hl7.fhir.r4.model.Timing.EventTiming.EVE;
    case EVE_EARLY: return org.hl7.fhir.r4.model.Timing.EventTiming.EVE_EARLY;
    case EVE_LATE: return org.hl7.fhir.r4.model.Timing.EventTiming.EVE_LATE;
    case NIGHT: return org.hl7.fhir.r4.model.Timing.EventTiming.NIGHT;
    case PHS: return org.hl7.fhir.r4.model.Timing.EventTiming.PHS;
    case HS: return org.hl7.fhir.r4.model.Timing.EventTiming.HS;
    case WAKE: return org.hl7.fhir.r4.model.Timing.EventTiming.WAKE;
    case C: return org.hl7.fhir.r4.model.Timing.EventTiming.C;
    case CM: return org.hl7.fhir.r4.model.Timing.EventTiming.CM;
    case CD: return org.hl7.fhir.r4.model.Timing.EventTiming.CD;
    case CV: return org.hl7.fhir.r4.model.Timing.EventTiming.CV;
    case AC: return org.hl7.fhir.r4.model.Timing.EventTiming.AC;
    case ACM: return org.hl7.fhir.r4.model.Timing.EventTiming.ACM;
    case ACD: return org.hl7.fhir.r4.model.Timing.EventTiming.ACD;
    case ACV: return org.hl7.fhir.r4.model.Timing.EventTiming.ACV;
    case PC: return org.hl7.fhir.r4.model.Timing.EventTiming.PC;
    case PCM: return org.hl7.fhir.r4.model.Timing.EventTiming.PCM;
    case PCD: return org.hl7.fhir.r4.model.Timing.EventTiming.PCD;
    case PCV: return org.hl7.fhir.r4.model.Timing.EventTiming.PCV;
    default: return org.hl7.fhir.r4.model.Timing.EventTiming.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r4.model.TriggerDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TriggerDefinition tgt = new org.hl7.fhir.r5.model.TriggerDefinition();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertTriggerType(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getData())
      tgt.addData(convertDataRequirement(t));
    if (src.hasCondition())
      tgt.setCondition(convertExpression(src.getCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r5.model.TriggerDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TriggerDefinition tgt = new org.hl7.fhir.r4.model.TriggerDefinition();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertTriggerType(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    for (org.hl7.fhir.r5.model.DataRequirement t : src.getData())
      tgt.addData(convertDataRequirement(t));
    if (src.hasCondition())
      tgt.setCondition(convertExpression(src.getCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TriggerDefinition.TriggerType convertTriggerType(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NAMEDEVENT: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NAMEDEVENT;
    case PERIODIC: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.PERIODIC;
    case DATACHANGED: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATACHANGED;
    case DATAADDED: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAADDED;
    case DATAMODIFIED: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAMODIFIED;
    case DATAREMOVED: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAREMOVED;
    case DATAACCESSED: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSED;
    case DATAACCESSENDED: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSENDED;
    default: return org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.TriggerDefinition.TriggerType convertTriggerType(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NAMEDEVENT: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NAMEDEVENT;
    case PERIODIC: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.PERIODIC;
    case DATACHANGED: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATACHANGED;
    case DATAADDED: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAADDED;
    case DATAMODIFIED: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAMODIFIED;
    case DATAREMOVED: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAREMOVED;
    case DATAACCESSED: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSED;
    case DATAACCESSENDED: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSENDED;
    default: return org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.UsageContext convertUsageContext(org.hl7.fhir.r4.model.UsageContext src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.UsageContext tgt = new org.hl7.fhir.r5.model.UsageContext();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.UsageContext convertUsageContext(org.hl7.fhir.r5.model.UsageContext src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.UsageContext tgt = new org.hl7.fhir.r4.model.UsageContext();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCoding(src.getCode()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition tgt = new org.hl7.fhir.r5.model.ElementDefinition();
    copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation())
      tgt.addRepresentation(convertPropertyRepresentation(t.getValue()));
    if (src.hasSliceName())
      tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode())
      tgt.addCode(convertCoding(t));
    if (src.hasSlicing())
      tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort())
      tgt.setShortElement(convertString(src.getShortElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements())
      tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias())
      tgt.getAlias().add(convertString(t));
    if (src.hasMin())
      tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasBase())
      tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning())
      tgt.setOrderMeaningElement(convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(convertType(src.getPattern()));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(convertType(src.getMaxValue()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r4.model.IdType t : src.getCondition())
      tgt.getCondition().add(convertId(t));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport())
      tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier())
      tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary())
      tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding())
      tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
    copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation())
      tgt.addRepresentation(convertPropertyRepresentation(t.getValue()));
    if (src.hasSliceName())
      tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
    if (src.hasSliceIsConstraining())
      tgt.setSliceIsConstrainingElement(convertBoolean(src.getSliceIsConstrainingElement()));
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode())
      tgt.addCode(convertCoding(t));
    if (src.hasSlicing())
      tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort())
      tgt.setShortElement(convertString(src.getShortElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
    if (src.hasRequirements())
      tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias())
      tgt.getAlias().add(convertString(t));
    if (src.hasMin())
      tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasBase())
      tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
    for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertTypeRefComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasOrderMeaning())
      tgt.setOrderMeaningElement(convertString(src.getOrderMeaningElement()));
    if (src.hasFixed())
      tgt.setFixed(convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(convertType(src.getPattern()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample())
      tgt.addExample(convertElementDefinitionExampleComponent(t));
    if (src.hasMinValue())
      tgt.setMinValue(convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(convertType(src.getMaxValue()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.r5.model.IdType t : src.getCondition())
      tgt.getCondition().add(convertId(t));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport())
      tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier())
      tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
    if (src.hasIsModifierReason())
      tgt.setIsModifierReasonElement(convertString(src.getIsModifierReasonElement()));
    if (src.hasIsSummary())
      tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding())
      tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case XMLATTR: return org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLATTR;
    case XMLTEXT: return org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLTEXT;
    case TYPEATTR: return org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.TYPEATTR;
    case CDATEXT: return org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.CDATEXT;
    case XHTML: return org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XHTML;
    default: return org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case XMLATTR: return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR;
    case XMLTEXT: return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLTEXT;
    case TYPEATTR: return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.TYPEATTR;
    case CDATEXT: return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.CDATEXT;
    case XHTML: return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XHTML;
    default: return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasOrdered())
      tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
    if (src.hasRules())
      tgt.setRules(convertSlicingRules(src.getRules()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasOrdered())
      tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
    if (src.hasRules())
      tgt.setRules(convertSlicingRules(src.getRules()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CLOSED: return org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.CLOSED;
    case OPEN: return org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPEN;
    case OPENATEND: return org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPENATEND;
    default: return org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CLOSED: return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.CLOSED;
    case OPEN: return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPEN;
    case OPENATEND: return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPENATEND;
    default: return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertDiscriminatorType(src.getType()));
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertDiscriminatorType(src.getType()));
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType convertDiscriminatorType(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case VALUE: return org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.VALUE;
    case EXISTS: return org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.EXISTS;
    case PATTERN: return org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.PATTERN;
    case TYPE: return org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.TYPE;
    case PROFILE: return org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.PROFILE;
    default: return org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType convertDiscriminatorType(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case VALUE: return org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.VALUE;
    case EXISTS: return org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.EXISTS;
    case PATTERN: return org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.PATTERN;
    case TYPE: return org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.TYPE;
    case PROFILE: return org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.PROFILE;
    default: return org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasMin())
      tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasMin())
      tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertUri(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> t : src.getAggregation())
      tgt.addAggregation(convertAggregationMode(t.getValue()));
    if (src.hasVersioning())
      tgt.setVersioning(convertReferenceVersionRules(src.getVersioning()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertUri(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> t : src.getAggregation())
      tgt.addAggregation(convertAggregationMode(t.getValue()));
    if (src.hasVersioning())
      tgt.setVersioning(convertReferenceVersionRules(src.getVersioning()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CONTAINED: return org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.CONTAINED;
    case REFERENCED: return org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.REFERENCED;
    case BUNDLED: return org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.BUNDLED;
    default: return org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CONTAINED: return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.CONTAINED;
    case REFERENCED: return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.REFERENCED;
    case BUNDLED: return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.BUNDLED;
    default: return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules convertReferenceVersionRules(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EITHER: return org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.EITHER;
    case INDEPENDENT: return org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT;
    case SPECIFIC: return org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.SPECIFIC;
    default: return org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules convertReferenceVersionRules(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EITHER: return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.EITHER;
    case INDEPENDENT: return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT;
    case SPECIFIC: return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.SPECIFIC;
    default: return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent();
    copyElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent convertElementDefinitionExampleComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent();
    copyElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent();
    copyElement(src, tgt);
    if (src.hasKey())
      tgt.setKeyElement(convertId(src.getKeyElement()));
    if (src.hasRequirements())
      tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
    if (src.hasSeverity())
      tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
    if (src.hasHuman())
      tgt.setHumanElement(convertString(src.getHumanElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(convertString(src.getXpathElement()));
    if (src.hasSource())
      tgt.setSourceElement(convertCanonical(src.getSourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
    copyElement(src, tgt);
    if (src.hasKey())
      tgt.setKeyElement(convertId(src.getKeyElement()));
    if (src.hasRequirements())
      tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
    if (src.hasSeverity())
      tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
    if (src.hasHuman())
      tgt.setHumanElement(convertString(src.getHumanElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(convertString(src.getXpathElement()));
    if (src.hasSource())
      tgt.setSourceElement(convertCanonical(src.getSourceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ERROR: return org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.ERROR;
    case WARNING: return org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.WARNING;
    default: return org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.NULL;
    }
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ERROR: return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.ERROR;
    case WARNING: return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.WARNING;
    default: return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL;
    }
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent();
    copyElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrength(Enumerations.convertBindingStrength(src.getStrength()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
    copyElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrength(Enumerations.convertBindingStrength(src.getStrength()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent();
    copyElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(convertId(src.getIdentityElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasMap())
      tgt.setMapElement(convertString(src.getMapElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
    copyElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(convertId(src.getIdentityElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasMap())
      tgt.setMapElement(convertString(src.getMapElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Quantity convertMoneyQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Quantity convertMoneyQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Quantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparator(convertQuantityComparator(src.getComparator()));
    if (src.hasUnit())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystem())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    if (src == null)
      return null;
    if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
      return convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r4.model.BooleanType)
      return convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r4.model.CanonicalType)
      return convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeType)
      return convertCode((org.hl7.fhir.r4.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateType)
      return convertDate((org.hl7.fhir.r4.model.DateType) src);
    if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
      return convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.DecimalType)
      return convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r4.model.IdType)
      return convertId((org.hl7.fhir.r4.model.IdType) src);
    if (src instanceof org.hl7.fhir.r4.model.InstantType)
      return convertInstant((org.hl7.fhir.r4.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r4.model.IntegerType)
      return convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
      return convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r4.model.OidType)
      return convertOid((org.hl7.fhir.r4.model.OidType) src);
    if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
      return convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.StringType)
      return convertString((org.hl7.fhir.r4.model.StringType) src);
    if (src instanceof org.hl7.fhir.r4.model.TimeType)
      return convertTime((org.hl7.fhir.r4.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
      return convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r4.model.UrlType)
      return convertUrl((org.hl7.fhir.r4.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r4.model.UriType)
      return convertUri((org.hl7.fhir.r4.model.UriType) src);
    if (src instanceof org.hl7.fhir.r4.model.UuidType)
      return convertUuid((org.hl7.fhir.r4.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r4.model.Extension)
      return convertExtension((org.hl7.fhir.r4.model.Extension) src);
    if (src instanceof org.hl7.fhir.r4.model.Narrative)
      return convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r4.model.Address)
      return convertAddress((org.hl7.fhir.r4.model.Address) src);
    if (src instanceof org.hl7.fhir.r4.model.Age)
      return convertAge((org.hl7.fhir.r4.model.Age) src);
    if (src instanceof org.hl7.fhir.r4.model.Annotation)
      return convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r4.model.Attachment)
      return convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r4.model.Coding)
      return convertCoding((org.hl7.fhir.r4.model.Coding) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactDetail)
      return convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
      return convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r4.model.Contributor)
      return convertContributor((org.hl7.fhir.r4.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r4.model.Count)
      return convertCount((org.hl7.fhir.r4.model.Count) src);
    if (src instanceof org.hl7.fhir.r4.model.DataRequirement)
      return convertDataRequirement((org.hl7.fhir.r4.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r4.model.Distance)
      return convertDistance((org.hl7.fhir.r4.model.Distance) src);
    if (src instanceof org.hl7.fhir.r4.model.Dosage)
      return convertDosage((org.hl7.fhir.r4.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r4.model.Duration)
      return convertDuration((org.hl7.fhir.r4.model.Duration) src);
    if (src instanceof org.hl7.fhir.r4.model.Expression)
      return convertExpression((org.hl7.fhir.r4.model.Expression) src);
    if (src instanceof org.hl7.fhir.r4.model.HumanName)
      return convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r4.model.Identifier)
      return convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r4.model.MarketingStatus)
      return convertMarketingStatus((org.hl7.fhir.r4.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r4.model.Meta)
      return convertMeta((org.hl7.fhir.r4.model.Meta) src);
    if (src instanceof org.hl7.fhir.r4.model.Money)
      return convertMoney((org.hl7.fhir.r4.model.Money) src);
    if (src instanceof org.hl7.fhir.r4.model.ParameterDefinition)
      return convertParameterDefinition((org.hl7.fhir.r4.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Period)
      return convertPeriod((org.hl7.fhir.r4.model.Period) src);
    if (src instanceof org.hl7.fhir.r4.model.Population)
      return convertPopulation((org.hl7.fhir.r4.model.Population) src);
    if (src instanceof org.hl7.fhir.r4.model.ProdCharacteristic)
      return convertProdCharacteristic((org.hl7.fhir.r4.model.ProdCharacteristic) src);
    if (src instanceof org.hl7.fhir.r4.model.ProductShelfLife)
      return convertProductShelfLife((org.hl7.fhir.r4.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r4.model.Quantity)
      return convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r4.model.Range)
      return convertRange((org.hl7.fhir.r4.model.Range) src);
    if (src instanceof org.hl7.fhir.r4.model.Ratio)
      return convertRatio((org.hl7.fhir.r4.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r4.model.Reference)
      return convertReference((org.hl7.fhir.r4.model.Reference) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedArtifact)
      return convertRelatedArtifact((org.hl7.fhir.r4.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r4.model.SampledData)
      return convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r4.model.Signature)
      return convertSignature((org.hl7.fhir.r4.model.Signature) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceAmount)
      return convertSubstanceAmount((org.hl7.fhir.r4.model.SubstanceAmount) src);
    if (src instanceof org.hl7.fhir.r4.model.Timing)
      return convertTiming((org.hl7.fhir.r4.model.Timing) src);
    if (src instanceof org.hl7.fhir.r4.model.TriggerDefinition)
      return convertTriggerDefinition((org.hl7.fhir.r4.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.UsageContext)
      return convertUsageContext((org.hl7.fhir.r4.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r4.model.ElementDefinition)
      return convertElementDefinition((org.hl7.fhir.r4.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.MoneyQuantity)
      return convertMoneyQuantity((org.hl7.fhir.r4.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
      return convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
    throw new Error("Unknown type "+src.fhirType());
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.r5.model.Type src) throws FHIRException {
    if (src == null)
      return null;
    if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
      return convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.r5.model.BooleanType)
      return convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.r5.model.CanonicalType)
      return convertCanonical((org.hl7.fhir.r5.model.CanonicalType) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeType)
      return convertCode((org.hl7.fhir.r5.model.CodeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateType)
      return convertDate((org.hl7.fhir.r5.model.DateType) src);
    if (src instanceof org.hl7.fhir.r5.model.DateTimeType)
      return convertDateTime((org.hl7.fhir.r5.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.DecimalType)
      return convertDecimal((org.hl7.fhir.r5.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.r5.model.IdType)
      return convertId((org.hl7.fhir.r5.model.IdType) src);
    if (src instanceof org.hl7.fhir.r5.model.InstantType)
      return convertInstant((org.hl7.fhir.r5.model.InstantType) src);
    if (src instanceof org.hl7.fhir.r5.model.IntegerType)
      return convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.r5.model.MarkdownType)
      return convertMarkdown((org.hl7.fhir.r5.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.r5.model.OidType)
      return convertOid((org.hl7.fhir.r5.model.OidType) src);
    if (src instanceof org.hl7.fhir.r5.model.PositiveIntType)
      return convertPositiveInt((org.hl7.fhir.r5.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.StringType)
      return convertString((org.hl7.fhir.r5.model.StringType) src);
    if (src instanceof org.hl7.fhir.r5.model.TimeType)
      return convertTime((org.hl7.fhir.r5.model.TimeType) src);
    if (src instanceof org.hl7.fhir.r5.model.UnsignedIntType)
      return convertUnsignedInt((org.hl7.fhir.r5.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.r5.model.UrlType)
      return convertUrl((org.hl7.fhir.r5.model.UrlType) src);
    if (src instanceof org.hl7.fhir.r5.model.UriType)
      return convertUri((org.hl7.fhir.r5.model.UriType) src);
    if (src instanceof org.hl7.fhir.r5.model.UuidType)
      return convertUuid((org.hl7.fhir.r5.model.UuidType) src);
    if (src instanceof org.hl7.fhir.r5.model.Extension)
      return convertExtension((org.hl7.fhir.r5.model.Extension) src);
    if (src instanceof org.hl7.fhir.r5.model.Narrative)
      return convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
    if (src instanceof org.hl7.fhir.r5.model.Address)
      return convertAddress((org.hl7.fhir.r5.model.Address) src);
    if (src instanceof org.hl7.fhir.r5.model.Age)
      return convertAge((org.hl7.fhir.r5.model.Age) src);
    if (src instanceof org.hl7.fhir.r5.model.Annotation)
      return convertAnnotation((org.hl7.fhir.r5.model.Annotation) src);
    if (src instanceof org.hl7.fhir.r5.model.Attachment)
      return convertAttachment((org.hl7.fhir.r5.model.Attachment) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.r5.model.Coding)
      return convertCoding((org.hl7.fhir.r5.model.Coding) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactDetail)
      return convertContactDetail((org.hl7.fhir.r5.model.ContactDetail) src);
    if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
      return convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.r5.model.Contributor)
      return convertContributor((org.hl7.fhir.r5.model.Contributor) src);
    if (src instanceof org.hl7.fhir.r5.model.Count)
      return convertCount((org.hl7.fhir.r5.model.Count) src);
    if (src instanceof org.hl7.fhir.r5.model.DataRequirement)
      return convertDataRequirement((org.hl7.fhir.r5.model.DataRequirement) src);
    if (src instanceof org.hl7.fhir.r5.model.Distance)
      return convertDistance((org.hl7.fhir.r5.model.Distance) src);
    if (src instanceof org.hl7.fhir.r5.model.Dosage)
      return convertDosage((org.hl7.fhir.r5.model.Dosage) src);
    if (src instanceof org.hl7.fhir.r5.model.Duration)
      return convertDuration((org.hl7.fhir.r5.model.Duration) src);
    if (src instanceof org.hl7.fhir.r5.model.Expression)
      return convertExpression((org.hl7.fhir.r5.model.Expression) src);
    if (src instanceof org.hl7.fhir.r5.model.HumanName)
      return convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
    if (src instanceof org.hl7.fhir.r5.model.Identifier)
      return convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
    if (src instanceof org.hl7.fhir.r5.model.MarketingStatus)
      return convertMarketingStatus((org.hl7.fhir.r5.model.MarketingStatus) src);
    if (src instanceof org.hl7.fhir.r5.model.Meta)
      return convertMeta((org.hl7.fhir.r5.model.Meta) src);
    if (src instanceof org.hl7.fhir.r5.model.Money)
      return convertMoney((org.hl7.fhir.r5.model.Money) src);
    if (src instanceof org.hl7.fhir.r5.model.ParameterDefinition)
      return convertParameterDefinition((org.hl7.fhir.r5.model.ParameterDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Period)
      return convertPeriod((org.hl7.fhir.r5.model.Period) src);
    if (src instanceof org.hl7.fhir.r5.model.Population)
      return convertPopulation((org.hl7.fhir.r5.model.Population) src);
    if (src instanceof org.hl7.fhir.r5.model.ProdCharacteristic)
      return convertProdCharacteristic((org.hl7.fhir.r5.model.ProdCharacteristic) src);
    if (src instanceof org.hl7.fhir.r5.model.ProductShelfLife)
      return convertProductShelfLife((org.hl7.fhir.r5.model.ProductShelfLife) src);
    if (src instanceof org.hl7.fhir.r5.model.Quantity)
      return convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
    if (src instanceof org.hl7.fhir.r5.model.Range)
      return convertRange((org.hl7.fhir.r5.model.Range) src);
    if (src instanceof org.hl7.fhir.r5.model.Ratio)
      return convertRatio((org.hl7.fhir.r5.model.Ratio) src);
    if (src instanceof org.hl7.fhir.r5.model.Reference)
      return convertReference((org.hl7.fhir.r5.model.Reference) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedArtifact)
      return convertRelatedArtifact((org.hl7.fhir.r5.model.RelatedArtifact) src);
    if (src instanceof org.hl7.fhir.r5.model.SampledData)
      return convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
    if (src instanceof org.hl7.fhir.r5.model.Signature)
      return convertSignature((org.hl7.fhir.r5.model.Signature) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceAmount)
      return convertSubstanceAmount((org.hl7.fhir.r5.model.SubstanceAmount) src);
    if (src instanceof org.hl7.fhir.r5.model.Timing)
      return convertTiming((org.hl7.fhir.r5.model.Timing) src);
    if (src instanceof org.hl7.fhir.r5.model.TriggerDefinition)
      return convertTriggerDefinition((org.hl7.fhir.r5.model.TriggerDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.UsageContext)
      return convertUsageContext((org.hl7.fhir.r5.model.UsageContext) src);
    if (src instanceof org.hl7.fhir.r5.model.ElementDefinition)
      return convertElementDefinition((org.hl7.fhir.r5.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MoneyQuantity)
      return convertMoneyQuantity((org.hl7.fhir.r5.model.MoneyQuantity) src);
    if (src instanceof org.hl7.fhir.r5.model.SimpleQuantity)
      return convertSimpleQuantity((org.hl7.fhir.r5.model.SimpleQuantity) src);
    throw new Error("Unknown type "+src.fhirType());
  }

  protected static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText())
      tgt.setText(convertNarrative(src.getText()));
    for (org.hl7.fhir.r4.model.Resource t : src.getContained())
      tgt.addContained(convertResource(t));
    for (org.hl7.fhir.r4.model.Extension t : src.getExtension())
      tgt.addExtension(convertExtension(t));
    for (org.hl7.fhir.r4.model.Extension t : src.getModifierExtension())
      tgt.addModifierExtension(convertExtension(t));
  }
  protected static void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText())
      tgt.setText(convertNarrative(src.getText()));
    for (org.hl7.fhir.r5.model.Resource t : src.getContained())
      tgt.addContained(convertResource(t));
    for (org.hl7.fhir.r5.model.Extension t : src.getExtension())
      tgt.addExtension(convertExtension(t));
    for (org.hl7.fhir.r5.model.Extension t : src.getModifierExtension())
      tgt.addModifierExtension(convertExtension(t));
  }

  protected static void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId())
      tgt.setIdElement(convertId(src.getIdElement()));
    if (src.hasMeta())
      tgt.setMeta(convertMeta(src.getMeta()));
    if (src.hasImplicitRules())
      tgt.setImplicitRulesElement(convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
  }
  protected static void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    if (src.hasId())
      tgt.setIdElement(convertId(src.getIdElement()));
    if (src.hasMeta())
      tgt.setMeta(convertMeta(src.getMeta()));
    if (src.hasImplicitRules())
      tgt.setImplicitRulesElement(convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
  }
  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    if (src == null)
      return null;
    if (src instanceof org.hl7.fhir.r4.model.Parameters)
      return Parameters.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4.model.Account)
      return Account.convertAccount((org.hl7.fhir.r4.model.Account) src);
    if (src instanceof org.hl7.fhir.r4.model.ActivityDefinition)
      return ActivityDefinition.convertActivityDefinition((org.hl7.fhir.r4.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.AdverseEvent)
      return AdverseEvent.convertAdverseEvent((org.hl7.fhir.r4.model.AdverseEvent) src);
    if (src instanceof org.hl7.fhir.r4.model.AllergyIntolerance)
      return AllergyIntolerance.convertAllergyIntolerance((org.hl7.fhir.r4.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r4.model.Appointment)
      return Appointment.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
      return AppointmentResponse.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
      return AuditEvent.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4.model.Basic)
      return Basic.convertBasic((org.hl7.fhir.r4.model.Basic) src);
    if (src instanceof org.hl7.fhir.r4.model.Binary)
      return Binary.convertBinary((org.hl7.fhir.r4.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct.convertBiologicallyDerivedProduct((org.hl7.fhir.r4.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r4.model.BodyStructure)
      return BodyStructure.convertBodyStructure((org.hl7.fhir.r4.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r4.model.Bundle)
      return Bundle.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
      return CapabilityStatement.convertCapabilityStatement((org.hl7.fhir.r4.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.CarePlan)
      return CarePlan.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.CareTeam)
      return CareTeam.convertCareTeam((org.hl7.fhir.r4.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r4.model.CatalogEntry)
      return CatalogEntry.convertCatalogEntry((org.hl7.fhir.r4.model.CatalogEntry) src);
    if (src instanceof org.hl7.fhir.r4.model.ChargeItem)
      return ChargeItem.convertChargeItem((org.hl7.fhir.r4.model.ChargeItem) src);
    if (src instanceof org.hl7.fhir.r4.model.ChargeItemDefinition)
      return ChargeItemDefinition.convertChargeItemDefinition((org.hl7.fhir.r4.model.ChargeItemDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Claim)
      return Claim.convertClaim((org.hl7.fhir.r4.model.Claim) src);
    if (src instanceof org.hl7.fhir.r4.model.ClaimResponse)
      return ClaimResponse.convertClaimResponse((org.hl7.fhir.r4.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.ClinicalImpression)
      return ClinicalImpression.convertClinicalImpression((org.hl7.fhir.r4.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
      return CodeSystem.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.Communication)
      return Communication.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
      return CommunicationRequest.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
      return CompartmentDefinition.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Composition)
      return Composition.convertComposition((org.hl7.fhir.r4.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
      return ConceptMap.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Condition)
      return Condition.convertCondition((org.hl7.fhir.r4.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4.model.Consent)
      return Consent.convertConsent((org.hl7.fhir.r4.model.Consent) src);
    if (src instanceof org.hl7.fhir.r4.model.Contract)
      return Contract.convertContract((org.hl7.fhir.r4.model.Contract) src);
    if (src instanceof org.hl7.fhir.r4.model.Coverage)
      return Coverage.convertCoverage((org.hl7.fhir.r4.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r4.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest.convertCoverageEligibilityRequest((org.hl7.fhir.r4.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.CoverageEligibilityResponse)
      return CoverageEligibilityResponse.convertCoverageEligibilityResponse((org.hl7.fhir.r4.model.CoverageEligibilityResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
      return DetectedIssue.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4.model.Device)
      return Device.convertDevice((org.hl7.fhir.r4.model.Device) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceDefinition)
      return DeviceDefinition.convertDeviceDefinition((org.hl7.fhir.r4.model.DeviceDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
      return DeviceMetric.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceRequest)
      return DeviceRequest.convertDeviceRequest((org.hl7.fhir.r4.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
      return DeviceUseStatement.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
      return DiagnosticReport.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r4.model.DocumentManifest)
      return DocumentManifest.convertDocumentManifest((org.hl7.fhir.r4.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
      return DocumentReference.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4.model.EffectEvidenceSynthesis)
      return EffectEvidenceSynthesis.convertEffectEvidenceSynthesis((org.hl7.fhir.r4.model.EffectEvidenceSynthesis) src);
    if (src instanceof org.hl7.fhir.r4.model.Encounter)
      return Encounter.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4.model.Endpoint)
      return Endpoint.convertEndpoint((org.hl7.fhir.r4.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r4.model.EnrollmentRequest)
      return EnrollmentRequest.convertEnrollmentRequest((org.hl7.fhir.r4.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.EnrollmentResponse)
      return EnrollmentResponse.convertEnrollmentResponse((org.hl7.fhir.r4.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
      return EpisodeOfCare.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4.model.EventDefinition)
      return EventDefinition.convertEventDefinition((org.hl7.fhir.r4.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Evidence)
      return Evidence.convertEvidence((org.hl7.fhir.r4.model.Evidence) src);
    if (src instanceof org.hl7.fhir.r4.model.EvidenceVariable)
      return EvidenceVariable.convertEvidenceVariable((org.hl7.fhir.r4.model.EvidenceVariable) src);
    if (src instanceof org.hl7.fhir.r4.model.ExampleScenario)
      return ExampleScenario.convertExampleScenario((org.hl7.fhir.r4.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r4.model.ExplanationOfBenefit)
      return ExplanationOfBenefit.convertExplanationOfBenefit((org.hl7.fhir.r4.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
      return FamilyMemberHistory.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4.model.Flag)
      return Flag.convertFlag((org.hl7.fhir.r4.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4.model.Goal)
      return Goal.convertGoal((org.hl7.fhir.r4.model.Goal) src);
    if (src instanceof org.hl7.fhir.r4.model.GraphDefinition)
      return GraphDefinition.convertGraphDefinition((org.hl7.fhir.r4.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Group)
      return Group.convertGroup((org.hl7.fhir.r4.model.Group) src);
    if (src instanceof org.hl7.fhir.r4.model.GuidanceResponse)
      return GuidanceResponse.convertGuidanceResponse((org.hl7.fhir.r4.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
      return HealthcareService.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4.model.ImagingStudy)
      return ImagingStudy.convertImagingStudy((org.hl7.fhir.r4.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r4.model.Immunization)
      return Immunization.convertImmunization((org.hl7.fhir.r4.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r4.model.ImmunizationEvaluation)
      return ImmunizationEvaluation.convertImmunizationEvaluation((org.hl7.fhir.r4.model.ImmunizationEvaluation) src);
    if (src instanceof org.hl7.fhir.r4.model.ImmunizationRecommendation)
      return ImmunizationRecommendation.convertImmunizationRecommendation((org.hl7.fhir.r4.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
      return ImplementationGuide.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4.model.InsurancePlan)
      return InsurancePlan.convertInsurancePlan((org.hl7.fhir.r4.model.InsurancePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.Invoice)
      return Invoice.convertInvoice((org.hl7.fhir.r4.model.Invoice) src);
    if (src instanceof org.hl7.fhir.r4.model.Library)
      return Library.convertLibrary((org.hl7.fhir.r4.model.Library) src);
    if (src instanceof org.hl7.fhir.r4.model.Linkage)
      return Linkage.convertLinkage((org.hl7.fhir.r4.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r4.model.ListResource)
      return ListResource.convertListResource((org.hl7.fhir.r4.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4.model.Location)
      return Location.convertLocation((org.hl7.fhir.r4.model.Location) src);
    if (src instanceof org.hl7.fhir.r4.model.Measure)
      return Measure.convertMeasure((org.hl7.fhir.r4.model.Measure) src);
    if (src instanceof org.hl7.fhir.r4.model.MeasureReport)
      return MeasureReport.convertMeasureReport((org.hl7.fhir.r4.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r4.model.Media)
      return Media.convertMedia((org.hl7.fhir.r4.model.Media) src);
    if (src instanceof org.hl7.fhir.r4.model.Medication)
      return Medication.convertMedication((org.hl7.fhir.r4.model.Medication) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationAdministration)
      return MedicationAdministration.convertMedicationAdministration((org.hl7.fhir.r4.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
      return MedicationDispense.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationKnowledge)
      return MedicationKnowledge.convertMedicationKnowledge((org.hl7.fhir.r4.model.MedicationKnowledge) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationRequest)
      return MedicationRequest.convertMedicationRequest((org.hl7.fhir.r4.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
      return MedicationStatement.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProduct)
      return MedicinalProduct.convertMedicinalProduct((org.hl7.fhir.r4.model.MedicinalProduct) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductAuthorization)
      return MedicinalProductAuthorization.convertMedicinalProductAuthorization((org.hl7.fhir.r4.model.MedicinalProductAuthorization) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductContraindication)
      return MedicinalProductContraindication.convertMedicinalProductContraindication((org.hl7.fhir.r4.model.MedicinalProductContraindication) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductIndication)
      return MedicinalProductIndication.convertMedicinalProductIndication((org.hl7.fhir.r4.model.MedicinalProductIndication) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductIngredient)
      return MedicinalProductIngredient.convertMedicinalProductIngredient((org.hl7.fhir.r4.model.MedicinalProductIngredient) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductInteraction)
      return MedicinalProductInteraction.convertMedicinalProductInteraction((org.hl7.fhir.r4.model.MedicinalProductInteraction) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductManufactured)
      return MedicinalProductManufactured.convertMedicinalProductManufactured((org.hl7.fhir.r4.model.MedicinalProductManufactured) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductPackaged)
      return MedicinalProductPackaged.convertMedicinalProductPackaged((org.hl7.fhir.r4.model.MedicinalProductPackaged) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductPharmaceutical)
      return MedicinalProductPharmaceutical.convertMedicinalProductPharmaceutical((org.hl7.fhir.r4.model.MedicinalProductPharmaceutical) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicinalProductUndesirableEffect)
      return MedicinalProductUndesirableEffect.convertMedicinalProductUndesirableEffect((org.hl7.fhir.r4.model.MedicinalProductUndesirableEffect) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageDefinition)
      return MessageDefinition.convertMessageDefinition((org.hl7.fhir.r4.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
      return MessageHeader.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4.model.MolecularSequence)
      return MolecularSequence.convertMolecularSequence((org.hl7.fhir.r4.model.MolecularSequence) src);
    if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
      return NamingSystem.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.NutritionOrder)
      return NutritionOrder.convertNutritionOrder((org.hl7.fhir.r4.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r4.model.Observation)
      return Observation.convertObservation((org.hl7.fhir.r4.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4.model.ObservationDefinition)
      return ObservationDefinition.convertObservationDefinition((org.hl7.fhir.r4.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
      return OperationDefinition.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
      return OperationOutcome.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4.model.Organization)
      return Organization.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4.model.OrganizationAffiliation)
      return OrganizationAffiliation.convertOrganizationAffiliation((org.hl7.fhir.r4.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r4.model.Patient)
      return Patient.convertPatient((org.hl7.fhir.r4.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4.model.PaymentNotice)
      return PaymentNotice.convertPaymentNotice((org.hl7.fhir.r4.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r4.model.PaymentReconciliation)
      return PaymentReconciliation.convertPaymentReconciliation((org.hl7.fhir.r4.model.PaymentReconciliation) src);
    if (src instanceof org.hl7.fhir.r4.model.Person)
      return Person.convertPerson((org.hl7.fhir.r4.model.Person) src);
    if (src instanceof org.hl7.fhir.r4.model.PlanDefinition)
      return PlanDefinition.convertPlanDefinition((org.hl7.fhir.r4.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Practitioner)
      return Practitioner.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4.model.PractitionerRole)
      return PractitionerRole.convertPractitionerRole((org.hl7.fhir.r4.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r4.model.Procedure)
      return Procedure.convertProcedure((org.hl7.fhir.r4.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r4.model.Provenance)
      return Provenance.convertProvenance((org.hl7.fhir.r4.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
      return Questionnaire.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
      return QuestionnaireResponse.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedPerson)
      return RelatedPerson.convertRelatedPerson((org.hl7.fhir.r4.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r4.model.RequestGroup)
      return RequestGroup.convertRequestGroup((org.hl7.fhir.r4.model.RequestGroup) src);
    if (src instanceof org.hl7.fhir.r4.model.ResearchDefinition)
      return ResearchDefinition.convertResearchDefinition((org.hl7.fhir.r4.model.ResearchDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.ResearchElementDefinition)
      return ResearchElementDefinition.convertResearchElementDefinition((org.hl7.fhir.r4.model.ResearchElementDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.ResearchStudy)
      return ResearchStudy.convertResearchStudy((org.hl7.fhir.r4.model.ResearchStudy) src);
    if (src instanceof org.hl7.fhir.r4.model.ResearchSubject)
      return ResearchSubject.convertResearchSubject((org.hl7.fhir.r4.model.ResearchSubject) src);
    if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
      return RiskAssessment.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4.model.RiskEvidenceSynthesis)
      return RiskEvidenceSynthesis.convertRiskEvidenceSynthesis((org.hl7.fhir.r4.model.RiskEvidenceSynthesis) src);
    if (src instanceof org.hl7.fhir.r4.model.Schedule)
      return Schedule.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
      return SearchParameter.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4.model.ServiceRequest)
      return ServiceRequest.convertServiceRequest((org.hl7.fhir.r4.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Slot)
      return Slot.convertSlot((org.hl7.fhir.r4.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4.model.Specimen)
      return Specimen.convertSpecimen((org.hl7.fhir.r4.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r4.model.SpecimenDefinition)
      return SpecimenDefinition.convertSpecimenDefinition((org.hl7.fhir.r4.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
      return StructureDefinition.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureMap)
      return StructureMap.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Subscription)
      return Subscription.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);
    if (src instanceof org.hl7.fhir.r4.model.Substance)
      return Substance.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceNucleicAcid)
      return SubstanceNucleicAcid.convertSubstanceNucleicAcid((org.hl7.fhir.r4.model.SubstanceNucleicAcid) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstancePolymer)
      return SubstancePolymer.convertSubstancePolymer((org.hl7.fhir.r4.model.SubstancePolymer) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceProtein)
      return SubstanceProtein.convertSubstanceProtein((org.hl7.fhir.r4.model.SubstanceProtein) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceReferenceInformation)
      return SubstanceReferenceInformation.convertSubstanceReferenceInformation((org.hl7.fhir.r4.model.SubstanceReferenceInformation) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceSourceMaterial)
      return SubstanceSourceMaterial.convertSubstanceSourceMaterial((org.hl7.fhir.r4.model.SubstanceSourceMaterial) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceSpecification)
      return SubstanceSpecification.convertSubstanceSpecification((org.hl7.fhir.r4.model.SubstanceSpecification) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
      return SupplyDelivery.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyRequest)
      return SupplyRequest.convertSupplyRequest((org.hl7.fhir.r4.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Task)
      return Task.convertTask((org.hl7.fhir.r4.model.Task) src);
    if (src instanceof org.hl7.fhir.r4.model.TerminologyCapabilities)
      return TerminologyCapabilities.convertTerminologyCapabilities((org.hl7.fhir.r4.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r4.model.TestReport)
      return TestReport.convertTestReport((org.hl7.fhir.r4.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r4.model.TestScript)
      return TestScript.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r4.model.ValueSet)
      return ValueSet.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r4.model.VerificationResult)
      return VerificationResult.convertVerificationResult((org.hl7.fhir.r4.model.VerificationResult) src);
    if (src instanceof org.hl7.fhir.r4.model.VisionPrescription)
      return VisionPrescription.convertVisionPrescription((org.hl7.fhir.r4.model.VisionPrescription) src);
    throw new Error("Unknown resource "+src.fhirType());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null)
      return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters)
      return Parameters.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r5.model.Account)
      return Account.convertAccount((org.hl7.fhir.r5.model.Account) src);
    if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
      return ActivityDefinition.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.AdverseEvent)
      return AdverseEvent.convertAdverseEvent((org.hl7.fhir.r5.model.AdverseEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
      return AllergyIntolerance.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.Basic)
      return Basic.convertBasic((org.hl7.fhir.r5.model.Basic) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct.convertBiologicallyDerivedProduct((org.hl7.fhir.r5.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
      return BodyStructure.convertBodyStructure((org.hl7.fhir.r5.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return CapabilityStatement.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.CareTeam)
      return CareTeam.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r5.model.CatalogEntry)
      return CatalogEntry.convertCatalogEntry((org.hl7.fhir.r5.model.CatalogEntry) src);
    if (src instanceof org.hl7.fhir.r5.model.ChargeItem)
      return ChargeItem.convertChargeItem((org.hl7.fhir.r5.model.ChargeItem) src);
    if (src instanceof org.hl7.fhir.r5.model.ChargeItemDefinition)
      return ChargeItemDefinition.convertChargeItemDefinition((org.hl7.fhir.r5.model.ChargeItemDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Claim)
      return Claim.convertClaim((org.hl7.fhir.r5.model.Claim) src);
    if (src instanceof org.hl7.fhir.r5.model.ClaimResponse)
      return ClaimResponse.convertClaimResponse((org.hl7.fhir.r5.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
      return ClinicalImpression.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CommunicationRequest)
      return CommunicationRequest.convertCommunicationRequest((org.hl7.fhir.r5.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.Consent)
      return Consent.convertConsent((org.hl7.fhir.r5.model.Consent) src);
    if (src instanceof org.hl7.fhir.r5.model.Contract)
      return Contract.convertContract((org.hl7.fhir.r5.model.Contract) src);
    if (src instanceof org.hl7.fhir.r5.model.Coverage)
      return Coverage.convertCoverage((org.hl7.fhir.r5.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest.convertCoverageEligibilityRequest((org.hl7.fhir.r5.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityResponse)
      return CoverageEligibilityResponse.convertCoverageEligibilityResponse((org.hl7.fhir.r5.model.CoverageEligibilityResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.Device)
      return Device.convertDevice((org.hl7.fhir.r5.model.Device) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceDefinition)
      return DeviceDefinition.convertDeviceDefinition((org.hl7.fhir.r5.model.DeviceDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceMetric)
      return DeviceMetric.convertDeviceMetric((org.hl7.fhir.r5.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceRequest)
      return DeviceRequest.convertDeviceRequest((org.hl7.fhir.r5.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceUseStatement)
      return DeviceUseStatement.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentManifest)
      return DocumentManifest.convertDocumentManifest((org.hl7.fhir.r5.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.EffectEvidenceSynthesis)
      return EffectEvidenceSynthesis.convertEffectEvidenceSynthesis((org.hl7.fhir.r5.model.EffectEvidenceSynthesis) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.Endpoint)
      return Endpoint.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r5.model.EnrollmentRequest)
      return EnrollmentRequest.convertEnrollmentRequest((org.hl7.fhir.r5.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.EnrollmentResponse)
      return EnrollmentResponse.convertEnrollmentResponse((org.hl7.fhir.r5.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.EventDefinition)
      return EventDefinition.convertEventDefinition((org.hl7.fhir.r5.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Evidence)
      return Evidence.convertEvidence((org.hl7.fhir.r5.model.Evidence) src);
    if (src instanceof org.hl7.fhir.r5.model.EvidenceVariable)
      return EvidenceVariable.convertEvidenceVariable((org.hl7.fhir.r5.model.EvidenceVariable) src);
    if (src instanceof org.hl7.fhir.r5.model.ExampleScenario)
      return ExampleScenario.convertExampleScenario((org.hl7.fhir.r5.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r5.model.ExplanationOfBenefit)
      return ExplanationOfBenefit.convertExplanationOfBenefit((org.hl7.fhir.r5.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag)
      return Flag.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Goal)
      return Goal.convertGoal((org.hl7.fhir.r5.model.Goal) src);
    if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
      return GraphDefinition.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Group)
      return Group.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.GuidanceResponse)
      return GuidanceResponse.convertGuidanceResponse((org.hl7.fhir.r5.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
      return ImagingStudy.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.Immunization)
      return Immunization.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r5.model.ImmunizationEvaluation)
      return ImmunizationEvaluation.convertImmunizationEvaluation((org.hl7.fhir.r5.model.ImmunizationEvaluation) src);
    if (src instanceof org.hl7.fhir.r5.model.ImmunizationRecommendation)
      return ImmunizationRecommendation.convertImmunizationRecommendation((org.hl7.fhir.r5.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.InsurancePlan)
      return InsurancePlan.convertInsurancePlan((org.hl7.fhir.r5.model.InsurancePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.Invoice)
      return Invoice.convertInvoice((org.hl7.fhir.r5.model.Invoice) src);
    if (src instanceof org.hl7.fhir.r5.model.Library)
      return Library.convertLibrary((org.hl7.fhir.r5.model.Library) src);
    if (src instanceof org.hl7.fhir.r5.model.Linkage)
      return Linkage.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return ListResource.convertListResource((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.Measure)
      return Measure.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
    if (src instanceof org.hl7.fhir.r5.model.MeasureReport)
      return MeasureReport.convertMeasureReport((org.hl7.fhir.r5.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r5.model.Media)
      return Media.convertMedia((org.hl7.fhir.r5.model.Media) src);
    if (src instanceof org.hl7.fhir.r5.model.Medication)
      return Medication.convertMedication((org.hl7.fhir.r5.model.Medication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
      return MedicationAdministration.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationKnowledge)
      return MedicationKnowledge.convertMedicationKnowledge((org.hl7.fhir.r5.model.MedicationKnowledge) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
      return MedicationRequest.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationStatement)
      return MedicationStatement.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProduct)
      return MedicinalProduct.convertMedicinalProduct((org.hl7.fhir.r5.model.MedicinalProduct) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductAuthorization)
      return MedicinalProductAuthorization.convertMedicinalProductAuthorization((org.hl7.fhir.r5.model.MedicinalProductAuthorization) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductContraindication)
      return MedicinalProductContraindication.convertMedicinalProductContraindication((org.hl7.fhir.r5.model.MedicinalProductContraindication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductIndication)
      return MedicinalProductIndication.convertMedicinalProductIndication((org.hl7.fhir.r5.model.MedicinalProductIndication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductIngredient)
      return MedicinalProductIngredient.convertMedicinalProductIngredient((org.hl7.fhir.r5.model.MedicinalProductIngredient) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductInteraction)
      return MedicinalProductInteraction.convertMedicinalProductInteraction((org.hl7.fhir.r5.model.MedicinalProductInteraction) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductManufactured)
      return MedicinalProductManufactured.convertMedicinalProductManufactured((org.hl7.fhir.r5.model.MedicinalProductManufactured) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductPackaged)
      return MedicinalProductPackaged.convertMedicinalProductPackaged((org.hl7.fhir.r5.model.MedicinalProductPackaged) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductPharmaceutical)
      return MedicinalProductPharmaceutical.convertMedicinalProductPharmaceutical((org.hl7.fhir.r5.model.MedicinalProductPharmaceutical) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicinalProductUndesirableEffect)
      return MedicinalProductUndesirableEffect.convertMedicinalProductUndesirableEffect((org.hl7.fhir.r5.model.MedicinalProductUndesirableEffect) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
      return MessageDefinition.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.MolecularSequence)
      return MolecularSequence.convertMolecularSequence((org.hl7.fhir.r5.model.MolecularSequence) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.NutritionOrder)
      return NutritionOrder.convertNutritionOrder((org.hl7.fhir.r5.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.ObservationDefinition)
      return ObservationDefinition.convertObservationDefinition((org.hl7.fhir.r5.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.OrganizationAffiliation)
      return OrganizationAffiliation.convertOrganizationAffiliation((org.hl7.fhir.r5.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
      return PaymentNotice.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentReconciliation)
      return PaymentReconciliation.convertPaymentReconciliation((org.hl7.fhir.r5.model.PaymentReconciliation) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
      return PlanDefinition.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
      return PractitionerRole.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r5.model.Procedure)
      return Procedure.convertProcedure((org.hl7.fhir.r5.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
      return RelatedPerson.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r5.model.RequestGroup)
      return RequestGroup.convertRequestGroup((org.hl7.fhir.r5.model.RequestGroup) src);
    if (src instanceof org.hl7.fhir.r5.model.ResearchDefinition)
      return ResearchDefinition.convertResearchDefinition((org.hl7.fhir.r5.model.ResearchDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ResearchElementDefinition)
      return ResearchElementDefinition.convertResearchElementDefinition((org.hl7.fhir.r5.model.ResearchElementDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ResearchStudy)
      return ResearchStudy.convertResearchStudy((org.hl7.fhir.r5.model.ResearchStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.ResearchSubject)
      return ResearchSubject.convertResearchSubject((org.hl7.fhir.r5.model.ResearchSubject) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskEvidenceSynthesis)
      return RiskEvidenceSynthesis.convertRiskEvidenceSynthesis((org.hl7.fhir.r5.model.RiskEvidenceSynthesis) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.ServiceRequest)
      return ServiceRequest.convertServiceRequest((org.hl7.fhir.r5.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot)
      return Slot.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.Specimen)
      return Specimen.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r5.model.SpecimenDefinition)
      return SpecimenDefinition.convertSpecimenDefinition((org.hl7.fhir.r5.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Subscription)
      return Subscription.convertSubscription((org.hl7.fhir.r5.model.Subscription) src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceNucleicAcid)
      return SubstanceNucleicAcid.convertSubstanceNucleicAcid((org.hl7.fhir.r5.model.SubstanceNucleicAcid) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstancePolymer)
      return SubstancePolymer.convertSubstancePolymer((org.hl7.fhir.r5.model.SubstancePolymer) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceProtein)
      return SubstanceProtein.convertSubstanceProtein((org.hl7.fhir.r5.model.SubstanceProtein) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceReferenceInformation)
      return SubstanceReferenceInformation.convertSubstanceReferenceInformation((org.hl7.fhir.r5.model.SubstanceReferenceInformation) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceSourceMaterial)
      return SubstanceSourceMaterial.convertSubstanceSourceMaterial((org.hl7.fhir.r5.model.SubstanceSourceMaterial) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceSpecification)
      return SubstanceSpecification.convertSubstanceSpecification((org.hl7.fhir.r5.model.SubstanceSpecification) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
      return SupplyDelivery.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyRequest)
      return SupplyRequest.convertSupplyRequest((org.hl7.fhir.r5.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Task)
      return Task.convertTask((org.hl7.fhir.r5.model.Task) src);
    if (src instanceof org.hl7.fhir.r5.model.TerminologyCapabilities)
      return TerminologyCapabilities.convertTerminologyCapabilities((org.hl7.fhir.r5.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r5.model.TestReport)
      return TestReport.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r5.model.VerificationResult)
      return VerificationResult.convertVerificationResult((org.hl7.fhir.r5.model.VerificationResult) src);
    if (src instanceof org.hl7.fhir.r5.model.VisionPrescription)
      return VisionPrescription.convertVisionPrescription((org.hl7.fhir.r5.model.VisionPrescription) src);
    throw new Error("Unknown resource "+src.fhirType());
  }


}
