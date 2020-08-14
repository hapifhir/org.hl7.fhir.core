package org.hl7.fhir.convertors;

import org.hl7.fhir.convertors.conv10_30.*;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.dstu3.conformance.ProfileUtilities;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.dstu3.terminologies.CodeSystemUtilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



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
public class VersionConvertor_10_30 {

  public static void copyElement(org.hl7.fhir.dstu2.model.Element src, org.hl7.fhir.dstu3.model.Element tgt) throws FHIRException {
    tgt.setId(src.getId());
    for (org.hl7.fhir.dstu2.model.Extension e : src.getExtension()) {
      tgt.addExtension(convertExtension(e));
    }
  }

  public static void copyElement(org.hl7.fhir.dstu3.model.Element src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
    tgt.setId(src.getId());
    for (org.hl7.fhir.dstu3.model.Extension e : src.getExtension()) {
      tgt.addExtension(convertExtension(e));
    }
  }

  public static void copyElement(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
    tgt.setId(src.getId());
    for (org.hl7.fhir.dstu3.model.Extension e : src.getExtension()) {
      tgt.addExtension(convertExtension(e));
    }
  }

  public static org.hl7.fhir.dstu3.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu3.model.Base64BinaryType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu3.model.Base64BinaryType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.dstu2.model.Base64BinaryType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.BooleanType convertBoolean(org.hl7.fhir.dstu2.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu3.model.BooleanType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.BooleanType convertBoolean(org.hl7.fhir.dstu3.model.BooleanType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.BooleanType(src.getValue()) : new org.hl7.fhir.dstu2.model.BooleanType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CodeType convertCode(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu3.model.CodeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeType convertCode(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UriType convertCodeToUri(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UriType(src.getValue()) : new org.hl7.fhir.dstu3.model.UriType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeType convertUriToCode(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.CodeType(src.getValue()) : new org.hl7.fhir.dstu2.model.CodeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.DateTimeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DateTimeType convertDateTime(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.DateTimeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DecimalType convertDecimal(org.hl7.fhir.dstu2.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.DecimalType(src.getValue()) : new org.hl7.fhir.dstu3.model.DecimalType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DecimalType convertDecimal(org.hl7.fhir.dstu3.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.DecimalType(src.getValue()) : new org.hl7.fhir.dstu2.model.DecimalType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.IdType convertId(org.hl7.fhir.dstu2.model.IdType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IdType(src.getValue()) : new org.hl7.fhir.dstu3.model.IdType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.IdType convertId(org.hl7.fhir.dstu3.model.IdType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IdType(src.getValue()) : new org.hl7.fhir.dstu2.model.IdType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.dstu2.model.InstantType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.InstantType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu2.model.InstantType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.IntegerType convertInteger(org.hl7.fhir.dstu2.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu3.model.IntegerType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.IntegerType convertInteger(org.hl7.fhir.dstu3.model.IntegerType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu2.model.IntegerType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu3.model.MarkdownType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.MarkdownType(src.getValue()) : new org.hl7.fhir.dstu2.model.MarkdownType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.OidType convertOid(org.hl7.fhir.dstu2.model.OidType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.OidType(src.getValue()) : new org.hl7.fhir.dstu3.model.OidType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.OidType convertOid(org.hl7.fhir.dstu3.model.OidType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.OidType(src.getValue()) : new org.hl7.fhir.dstu2.model.OidType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.dstu3.model.PositiveIntType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu3.model.PositiveIntType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.PositiveIntType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StringType convertString(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.StringType(src.getValue()) : new org.hl7.fhir.dstu3.model.StringType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.StringType convertString(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.StringType(src.getValue()) : new org.hl7.fhir.dstu2.model.StringType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TimeType convertTime(org.hl7.fhir.dstu2.model.TimeType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.TimeType(src.getValue()) : new org.hl7.fhir.dstu3.model.TimeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TimeType convertTime(org.hl7.fhir.dstu3.model.TimeType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.TimeType(src.getValue()) : new org.hl7.fhir.dstu2.model.TimeType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu3.model.UnsignedIntType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu3.model.UnsignedIntType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.dstu2.model.UnsignedIntType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UriType(src.getValue()) : new org.hl7.fhir.dstu3.model.UriType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UriType(src.getValue()) : new org.hl7.fhir.dstu2.model.UriType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.UuidType convertUuid(org.hl7.fhir.dstu2.model.UuidType src) throws FHIRException {
    org.hl7.fhir.dstu3.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.UuidType(src.getValue()) : new org.hl7.fhir.dstu3.model.UuidType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.UuidType convertUuid(org.hl7.fhir.dstu3.model.UuidType src) throws FHIRException {
    org.hl7.fhir.dstu2.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.dstu2.model.UuidType(src.getValue()) : new org.hl7.fhir.dstu2.model.UuidType();
    copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
    copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
    copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Narrative convertNarrative(org.hl7.fhir.dstu2.model.Narrative src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Narrative tgt = new org.hl7.fhir.dstu3.model.Narrative();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
    if (src.hasDiv())
      tgt.setDiv(src.getDiv());
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Narrative convertNarrative(org.hl7.fhir.dstu3.model.Narrative src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Narrative tgt = new org.hl7.fhir.dstu2.model.Narrative();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
    tgt.setDiv(src.getDiv());
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Narrative.NarrativeStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case GENERATED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.GENERATED);
        break;
      case EXTENSIONS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EXTENSIONS);
        break;
      case ADDITIONAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.ADDITIONAL);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EMPTY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Narrative.NarrativeStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case GENERATED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.GENERATED);
        break;
      case EXTENSIONS:
        tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EXTENSIONS);
        break;
      case ADDITIONAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.ADDITIONAL);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EMPTY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
    copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(convertType(src.getAuthor()));
    if (src.hasTimeElement())
      tgt.setTimeElement(convertDateTime(src.getTimeElement()));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
    copyElement(src, tgt);
    if (src.hasAuthor())
      tgt.setAuthor(convertType(src.getAuthor()));
    if (src.hasTimeElement())
      tgt.setTimeElement(convertDateTime(src.getTimeElement()));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
    copyElement(src, tgt);
    if (src.hasContentTypeElement())
      tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
    if (src.hasLanguageElement())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasDataElement())
      tgt.setDataElement(convertBase64Binary(src.getDataElement()));
    if (src.hasUrlElement())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasSizeElement())
      tgt.setSizeElement(convertUnsignedInt(src.getSizeElement()));
    if (src.hasHashElement())
      tgt.setHashElement(convertBase64Binary(src.getHashElement()));
    if (src.hasTitleElement())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasCreationElement())
      tgt.setCreationElement(convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
    copyElement(src, tgt);
    if (src.hasContentTypeElement())
      tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
    if (src.hasLanguageElement())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasDataElement())
      tgt.setDataElement(convertBase64Binary(src.getDataElement()));
    if (src.hasUrlElement())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasSizeElement())
      tgt.setSizeElement(convertUnsignedInt(src.getSizeElement()));
    if (src.hasHashElement())
      tgt.setHashElement(convertBase64Binary(src.getHashElement()));
    if (src.hasTitleElement())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasCreationElement())
      tgt.setCreationElement(convertDateTime(src.getCreationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
    copyElement(src, tgt);
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplayElement())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement())
      tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
    copyElement(src, tgt);
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplayElement())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasUserSelectedElement())
      tgt.setUserSelectedElement(convertBoolean(src.getUserSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Identifier tgt = new org.hl7.fhir.dstu3.model.Identifier();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasValueElement())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasAssigner())
      tgt.setAssigner(convertReference(src.getAssigner()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.dstu3.model.Identifier src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUseElement(convertIdentifierUse(src.getUseElement()));
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Identifier.IdentifierUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case USUAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.USUAL);
        break;
      case OFFICIAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.OFFICIAL);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.TEMP);
        break;
      case SECONDARY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.SECONDARY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Identifier.IdentifierUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Identifier.IdentifierUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case USUAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.USUAL);
        break;
      case OFFICIAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.OFFICIAL);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.TEMP);
        break;
      case SECONDARY:
        tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.SECONDARY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
    copyElement(src, tgt);
    if (src.hasStartElement())
      tgt.setStartElement(convertDateTime(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
    copyElement(src, tgt);
    if (src.hasStartElement())
      tgt.setStartElement(convertDateTime(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Quantity convertQuantity(org.hl7.fhir.dstu2.model.Quantity src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Quantity tgt = new org.hl7.fhir.dstu3.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Quantity convertQuantity(org.hl7.fhir.dstu3.model.Quantity src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Quantity tgt = new org.hl7.fhir.dstu2.model.Quantity();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Quantity.QuantityComparatorEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case LESS_THAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_THAN);
        break;
      case LESS_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
        break;
      case GREATER_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
        break;
      case GREATER_THAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_THAN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Quantity.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Quantity.QuantityComparatorEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case LESS_THAN:
        tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_THAN);
        break;
      case LESS_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
        break;
      case GREATER_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
        break;
      case GREATER_THAN:
        tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_THAN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
    copyElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
    copyElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(convertSimpleQuantity(src.getHigh()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
    copyElement(src, tgt);
    if (src.hasNumerator())
      tgt.setNumerator(convertQuantity(src.getNumerator()));
    if (src.hasDenominator())
      tgt.setDenominator(convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
    copyElement(src, tgt);
    if (src.hasNumerator())
      tgt.setNumerator(convertQuantity(src.getNumerator()));
    if (src.hasDenominator())
      tgt.setDenominator(convertQuantity(src.getDenominator()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(src.getReference());
    if (src.hasDisplayElement())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(src.getReference());
    if (src.hasDisplayElement())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
    copyElement(src, tgt);
    if (src.hasOrigin())
      tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement())
      tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement())
      tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement())
      tgt.setDataElement(convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
    copyElement(src, tgt);
    if (src.hasOrigin())
      tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement())
      tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement())
      tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement())
      tgt.setDataElement(convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
    if (src.hasWhenElement())
      tgt.setWhenElement(convertInstant(src.getWhenElement()));
    if (src.hasWho())
      tgt.setWho(convertType(src.getWho()));
    if (src.hasContentTypeElement())
      tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
    if (src.hasBlobElement())
      tgt.setBlobElement(convertBase64Binary(src.getBlobElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
    if (src.hasWhenElement())
      tgt.setWhenElement(convertInstant(src.getWhenElement()));
    if (src.hasWho())
      tgt.setWho(convertType(src.getWho()));
    if (src.hasContentTypeElement())
      tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
    if (src.hasBlobElement())
      tgt.setBlobElement(convertBase64Binary(src.getBlobElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Address convertAddress(org.hl7.fhir.dstu2.model.Address src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Address tgt = new org.hl7.fhir.dstu3.model.Address();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUseElement(convertAddressUse(src.getUseElement()));
    if (src.hasType())
      tgt.setTypeElement(convertAddressType(src.getTypeElement()));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
    if (src.hasCityElement())
      tgt.setCityElement(convertString(src.getCityElement()));
    if (src.hasDistrictElement())
      tgt.setDistrictElement(convertString(src.getDistrictElement()));
    if (src.hasStateElement())
      tgt.setStateElement(convertString(src.getStateElement()));
    if (src.hasPostalCodeElement())
      tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
    if (src.hasCountryElement())
      tgt.setCountryElement(convertString(src.getCountryElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Address convertAddress(org.hl7.fhir.dstu3.model.Address src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Address tgt = new org.hl7.fhir.dstu2.model.Address();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUseElement(convertAddressUse(src.getUseElement()));
    if (src.hasType())
      tgt.setTypeElement(convertAddressType(src.getTypeElement()));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
    if (src.hasCityElement())
      tgt.setCityElement(convertString(src.getCityElement()));
    if (src.hasDistrictElement())
      tgt.setDistrictElement(convertString(src.getDistrictElement()));
    if (src.hasStateElement())
      tgt.setStateElement(convertString(src.getStateElement()));
    if (src.hasPostalCodeElement())
      tgt.setPostalCodeElement(convertString(src.getPostalCodeElement()));
    if (src.hasCountryElement())
      tgt.setCountryElement(convertString(src.getCountryElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Address.AddressUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case HOME:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.HOME);
        break;
      case WORK:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.WORK);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP);
        break;
      case OLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.OLD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Address.AddressUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case HOME:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.HOME);
        break;
      case WORK:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.WORK);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.TEMP);
        break;
      case OLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.OLD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressType> convertAddressType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Address.AddressTypeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case POSTAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.POSTAL);
        break;
      case PHYSICAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.PHYSICAL);
        break;
      case BOTH:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.BOTH);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Address.AddressType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressType> convertAddressType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Address.AddressType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Address.AddressType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Address.AddressTypeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case POSTAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.POSTAL);
        break;
      case PHYSICAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.PHYSICAL);
        break;
      case BOTH:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.BOTH);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Address.AddressType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ContactPoint tgt = new org.hl7.fhir.dstu3.model.ContactPoint();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValueElement())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasUse())
      tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu3.model.ContactPoint src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ContactPoint tgt = new org.hl7.fhir.dstu2.model.ContactPoint();
    copyElement(src, tgt);
    if (src.hasSystem())
      tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
    if (src.hasValueElement())
      tgt.setValueElement(convertString(src.getValueElement()));
    if (src.hasUse())
      tgt.setUseElement(convertContactPointUse(src.getUseElement()));
    if (src.hasRankElement())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystemEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case PHONE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PHONE);
        break;
      case FAX:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.FAX);
        break;
      case EMAIL:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.EMAIL);
        break;
      case PAGER:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PAGER);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystemEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case PHONE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PHONE);
        break;
      case FAX:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.FAX);
        break;
      case EMAIL:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.EMAIL);
        break;
      case PAGER:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PAGER);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER);
        break;
      case URL:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case HOME:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.HOME);
        break;
      case WORK:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.WORK);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.TEMP);
        break;
      case OLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.OLD);
        break;
      case MOBILE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.MOBILE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case HOME:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.HOME);
        break;
      case WORK:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.WORK);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.TEMP);
        break;
      case OLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.OLD);
        break;
      case MOBILE:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.MOBILE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2.model.ElementDefinition src, List<String> slicePaths) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition tgt = new org.hl7.fhir.dstu3.model.ElementDefinition();
    copyElement(src, tgt);
    if (src.hasPathElement())
      tgt.setPathElement(convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream()
      .map(VersionConvertor_10_30::convertPropertyRepresentation)
      .collect(Collectors.toList()));
    if (src.hasName()) {
      if (slicePaths.contains(src.getPath()))
        tgt.setSliceNameElement(convertString(src.getNameElement()));
      if (src.hasNameElement())
        tgt.setIdElement(convertString(src.getNameElement()));
    }
    if (src.hasLabel())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
    if (src.hasSlicing())
      tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShort())
      tgt.setShortElement(convertString(src.getShortElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
    if (src.hasComments())
      tgt.setCommentElement(convertMarkdown(src.getCommentsElement()));
    if (src.hasRequirements())
      tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    if (src.hasMin())
      tgt.setMin(src.getMin());
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasBase())
      tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasNameReference())
      tgt.setContentReference("#" + src.getNameReference());
    for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertElementDefinitionTypeComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissing())
      tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasFixed())
      tgt.setFixed(convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(convertType(src.getPattern()));
    if (src.hasExample())
      tgt.addExample().setLabel("General").setValue(convertType(src.getExample()));
    if (src.hasMinValue())
      tgt.setMinValue(convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(convertType(src.getMaxValue()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.dstu2.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupport())
      tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifier())
      tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
    if (src.hasIsSummary())
      tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding())
      tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu3.model.ElementDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition tgt = new org.hl7.fhir.dstu2.model.ElementDefinition();
    copyElement(src, tgt);
    if (src.hasPathElement())
      tgt.setPathElement(convertString(src.getPathElement()));
    tgt.setRepresentation(src.getRepresentation().stream()
      .map(VersionConvertor_10_30::convertPropertyRepresentation)
      .collect(Collectors.toList()));
    if (src.hasSliceName())
      tgt.setNameElement(convertString(src.getSliceNameElement()));
    else
      tgt.setNameElement(convertString(src.getIdElement()));
    if (src.hasLabelElement())
      tgt.setLabelElement(convertString(src.getLabelElement()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
    if (src.hasSlicing())
      tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
    if (src.hasShortElement())
      tgt.setShortElement(convertString(src.getShortElement()));
    if (src.hasDefinitionElement())
      tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
    if (src.hasCommentElement())
      tgt.setCommentsElement(convertMarkdown(src.getCommentElement()));
    if (src.hasRequirementsElement())
      tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
    tgt.setMin(src.getMin());
    if (src.hasMaxElement())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasBase())
      tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
    if (src.hasContentReference())
      tgt.setNameReference(src.getContentReference().substring(1));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent t : src.getType())
      tgt.addType(convertElementDefinitionTypeComponent(t));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(convertType(src.getDefaultValue()));
    if (src.hasMeaningWhenMissingElement())
      tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
    if (src.hasFixed())
      tgt.setFixed(convertType(src.getFixed()));
    if (src.hasPattern())
      tgt.setPattern(convertType(src.getPattern()));
    if (src.hasExample())
      tgt.setExample(convertType(src.getExampleFirstRep().getValue()));
    if (src.hasMinValue())
      tgt.setMinValue(convertType(src.getMinValue()));
    if (src.hasMaxValue())
      tgt.setMaxValue(convertType(src.getMaxValue()));
    if (src.hasMaxLengthElement())
      tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
    for (org.hl7.fhir.dstu3.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint())
      tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
    if (src.hasMustSupportElement())
      tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
    if (src.hasIsModifierElement())
      tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
    if (src.hasIsSummaryElement())
      tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
    if (src.hasBinding())
      tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertElementDefinitionMappingComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentationEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case XMLATTR:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLATTR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentationEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case XMLATTR:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.XMLATTR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.StringType t : src.getDiscriminator())
      tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasOrderedElement())
      tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
    if (src.hasRules())
      tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent();
    copyElement(src, tgt);
    for (ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator())
      tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasOrderedElement())
      tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
    if (src.hasRules())
      tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRulesEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CLOSED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.CLOSED);
        break;
      case OPEN:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPEN);
        break;
      case OPENATEND:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPENATEND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRulesEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CLOSED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.CLOSED);
        break;
      case OPEN:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPEN);
        break;
      case OPENATEND:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPENATEND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent();
    copyElement(src, tgt);
    if (src.hasPathElement())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasMin())
      tgt.setMin(src.getMin());
    if (src.hasMaxElement())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent();
    copyElement(src, tgt);
    if (src.hasPathElement())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasMin())
      tgt.setMin(src.getMin());
    if (src.hasMaxElement())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent convertElementDefinitionTypeComponent(org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
    copyElement(src, tgt);
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCodeToUri(src.getCodeElement()));
    for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile())
      if (src.hasTarget())
        tgt.setTargetProfile(t.getValueAsString());
      else
        tgt.setProfile(t.getValue());
    tgt.setAggregation(src.getAggregation().stream()
      .map(VersionConvertor_10_30::convertAggregationMode)
      .collect(Collectors.toList()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent convertElementDefinitionTypeComponent(org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent();
    copyElement(src, tgt);
    if (src.hasCodeElement())
      tgt.setCodeElement(convertUriToCode(src.getCodeElement()));
    if (src.hasTarget()) {
      if (src.hasTargetProfile())
        tgt.addProfile(src.getTargetProfile());
    } else if (src.hasProfile())
      tgt.addProfile(src.getProfile());
    tgt.setAggregation(src.getAggregation().stream()
      .map(VersionConvertor_10_30::convertAggregationMode)
      .collect(Collectors.toList()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.AggregationModeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CONTAINED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.CONTAINED);
        break;
      case REFERENCED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.REFERENCED);
        break;
      case BUNDLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.BUNDLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.AggregationModeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CONTAINED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.CONTAINED);
        break;
      case REFERENCED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.REFERENCED);
        break;
      case BUNDLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.BUNDLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent();
    copyElement(src, tgt);
    if (src.hasKeyElement())
      tgt.setKeyElement(convertId(src.getKeyElement()));
    if (src.hasRequirementsElement())
      tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHumanElement())
      tgt.setHumanElement(convertString(src.getHumanElement()));
    tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
    if (src.hasXpathElement())
      tgt.setXpathElement(convertString(src.getXpathElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent();
    copyElement(src, tgt);
    if (src.hasKeyElement())
      tgt.setKeyElement(convertId(src.getKeyElement()));
    if (src.hasRequirementsElement())
      tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
    if (src.hasHumanElement())
      tgt.setHumanElement(convertString(src.getHumanElement()));
    if (src.hasExpression())
      ToolingExtensions.addStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
    if (src.hasXpathElement())
      tgt.setXpathElement(convertString(src.getXpathElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverityEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case ERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.ERROR);
        break;
      case WARNING:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.WARNING);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverityEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case ERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.ERROR);
        break;
      case WARNING:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.WARNING);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent();
    copyElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasValueSet())
      tgt.setValueSet(convertType(src.getValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent();
    copyElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasValueSet())
      tgt.setValueSet(convertType(src.getValueSet()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.BindingStrengthEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.REQUIRED);
        break;
      case EXTENSIBLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXTENSIBLE);
        break;
      case PREFERRED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.PREFERRED);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXAMPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.BindingStrengthEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.REQUIRED);
        break;
      case EXTENSIBLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXTENSIBLE);
        break;
      case PREFERRED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.PREFERRED);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXAMPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent();
    copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(convertId(src.getIdentityElement()));
    if (src.hasLanguageElement())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasMapElement())
      tgt.setMapElement(convertString(src.getMapElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent();
    copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(convertId(src.getIdentityElement()));
    if (src.hasLanguageElement())
      tgt.setLanguageElement(convertCode(src.getLanguageElement()));
    if (src.hasMapElement())
      tgt.setMapElement(convertString(src.getMapElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.HumanName convertHumanName(org.hl7.fhir.dstu2.model.HumanName src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.HumanName tgt = new org.hl7.fhir.dstu3.model.HumanName();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu2.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
    for (org.hl7.fhir.dstu2.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
    for (org.hl7.fhir.dstu2.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
    for (org.hl7.fhir.dstu2.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.HumanName convertHumanName(org.hl7.fhir.dstu3.model.HumanName src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.HumanName tgt = new org.hl7.fhir.dstu2.model.HumanName();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUseElement(convertNameUse(src.getUseElement()));
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasFamily())
      tgt.addFamily(src.getFamily());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.HumanName.NameUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case USUAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.USUAL);
        break;
      case OFFICIAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.OFFICIAL);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.TEMP);
        break;
      case NICKNAME:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NICKNAME);
        break;
      case ANONYMOUS:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.ANONYMOUS);
        break;
      case OLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.OLD);
        break;
      case MAIDEN:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.MAIDEN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.HumanName.NameUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.HumanName.NameUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.HumanName.NameUseEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case USUAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.USUAL);
        break;
      case OFFICIAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.OFFICIAL);
        break;
      case TEMP:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.TEMP);
        break;
      case NICKNAME:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NICKNAME);
        break;
      case ANONYMOUS:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.ANONYMOUS);
        break;
      case OLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.OLD);
        break;
      case MAIDEN:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.MAIDEN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.HumanName.NameUse.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
    copyElement(src, tgt);
    if (src.hasVersionIdElement())
      tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
    if (src.hasLastUpdatedElement())
      tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Meta convertMeta(org.hl7.fhir.dstu3.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Meta tgt = new org.hl7.fhir.dstu2.model.Meta();
    copyElement(src, tgt);
    if (src.hasVersionIdElement())
      tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
    if (src.hasLastUpdatedElement())
      tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Timing convertTiming(org.hl7.fhir.dstu2.model.Timing src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Timing tgt = new org.hl7.fhir.dstu3.model.Timing();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
    if (src.hasRepeat())
      tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Timing convertTiming(org.hl7.fhir.dstu3.model.Timing src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Timing tgt = new org.hl7.fhir.dstu2.model.Timing();
    copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
    if (src.hasRepeat())
      tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent();
    copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(convertType(src.getBounds()));
    if (src.hasCountElement())
      tgt.setCountElement(convertInteger(src.getCountElement()));
    if (src.hasDurationElement())
      tgt.setDurationElement(convertDecimal(src.getDurationElement()));
    if (src.hasDurationMaxElement())
      tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnits())
      tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitsElement()));
    if (src.hasFrequencyElement())
      tgt.setFrequencyElement(convertInteger(src.getFrequencyElement()));
    if (src.hasFrequencyMaxElement())
      tgt.setFrequencyMaxElement(convertInteger(src.getFrequencyMaxElement()));
    if (src.hasPeriodElement())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMaxElement())
      tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnits())
      tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitsElement()));
    tgt.setWhen(Collections.singletonList(convertEventTiming(src.getWhenElement())));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent();
    copyElement(src, tgt);
    if (src.hasBounds())
      tgt.setBounds(convertType(src.getBounds()));
    if (src.hasCountElement())
      tgt.setCountElement(convertInteger(src.getCountElement()));
    if (src.hasDurationElement())
      tgt.setDurationElement(convertDecimal(src.getDurationElement()));
    if (src.hasDurationMaxElement())
      tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
    if (src.hasDurationUnit())
      tgt.setDurationUnitsElement(convertUnitsOfTime(src.getDurationUnitElement()));
    if (src.hasFrequencyElement())
      tgt.setFrequencyElement(convertInteger(src.getFrequencyElement()));
    if (src.hasFrequencyMaxElement())
      tgt.setFrequencyMaxElement(convertInteger(src.getFrequencyMaxElement()));
    if (src.hasPeriodElement())
      tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
    if (src.hasPeriodMaxElement())
      tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
    if (src.hasPeriodUnit())
      tgt.setPeriodUnitsElement(convertUnitsOfTime(src.getPeriodUnitElement()));
    if (src.hasWhen())
      tgt.setWhenElement(convertEventTiming(src.getWhen().get(0)));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.UnitsOfTimeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case S:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.S);
        break;
      case MIN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MIN);
        break;
      case H:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.H);
        break;
      case D:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.D);
        break;
      case WK:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.WK);
        break;
      case MO:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MO);
        break;
      case A:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.A);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.UnitsOfTime> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Timing.UnitsOfTimeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case S:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.S);
        break;
      case MIN:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MIN);
        break;
      case H:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.H);
        break;
      case D:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.D);
        break;
      case WK:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.WK);
        break;
      case MO:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MO);
        break;
      case A:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.A);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Timing.EventTimingEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case HS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.HS);
        break;
      case WAKE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.WAKE);
        break;
      case C:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.C);
        break;
      case CM:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CM);
        break;
      case CD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CD);
        break;
      case CV:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.CV);
        break;
      case AC:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.AC);
        break;
      case ACM:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACM);
        break;
      case ACD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACD);
        break;
      case ACV:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.ACV);
        break;
      case PC:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PC);
        break;
      case PCM:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCM);
        break;
      case PCD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCD);
        break;
      case PCV:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.PCV);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Timing.EventTiming.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Timing.EventTiming> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Timing.EventTimingEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case HS:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.HS);
        break;
      case WAKE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.WAKE);
        break;
      case C:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.C);
        break;
      case CM:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.CM);
        break;
      case CD:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.CD);
        break;
      case CV:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.CV);
        break;
      case AC:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.AC);
        break;
      case ACM:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.ACM);
        break;
      case ACD:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.ACD);
        break;
      case ACV:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.ACV);
        break;
      case PC:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PC);
        break;
      case PCM:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PCM);
        break;
      case PCD:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PCD);
        break;
      case PCV:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.PCV);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Timing.EventTiming.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Age convertAge(org.hl7.fhir.dstu2.model.Age src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Age tgt = new org.hl7.fhir.dstu3.model.Age();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Age convertAge(org.hl7.fhir.dstu3.model.Age src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Age tgt = new org.hl7.fhir.dstu2.model.Age();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Count convertCount(org.hl7.fhir.dstu2.model.Count src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Count tgt = new org.hl7.fhir.dstu3.model.Count();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Count convertCount(org.hl7.fhir.dstu3.model.Count src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Count tgt = new org.hl7.fhir.dstu2.model.Count();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Distance convertDistance(org.hl7.fhir.dstu2.model.Distance src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Distance tgt = new org.hl7.fhir.dstu3.model.Distance();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Distance convertDistance(org.hl7.fhir.dstu3.model.Distance src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Distance tgt = new org.hl7.fhir.dstu2.model.Distance();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Duration convertDuration(org.hl7.fhir.dstu2.model.Duration src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Duration tgt = new org.hl7.fhir.dstu3.model.Duration();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Duration convertDuration(org.hl7.fhir.dstu3.model.Duration src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Duration tgt = new org.hl7.fhir.dstu2.model.Duration();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Money convertMoney(org.hl7.fhir.dstu2.model.Money src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Money tgt = new org.hl7.fhir.dstu3.model.Money();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Money convertMoney(org.hl7.fhir.dstu3.model.Money src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Money tgt = new org.hl7.fhir.dstu2.model.Money();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.dstu2.model.SimpleQuantity src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.SimpleQuantity tgt = new org.hl7.fhir.dstu3.model.SimpleQuantity();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.dstu3.model.SimpleQuantity src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2.model.SimpleQuantity();
    copyElement(src, tgt);
    if (src.hasValueElement())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasComparator())
      tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
    if (src.hasUnitElement())
      tgt.setUnitElement(convertString(src.getUnitElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(convertUri(src.getSystemElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Base64BinaryType)
      return convertBase64Binary((org.hl7.fhir.dstu2.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.BooleanType)
      return convertBoolean((org.hl7.fhir.dstu2.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeType)
      return convertCode((org.hl7.fhir.dstu2.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateType)
      return convertDate((org.hl7.fhir.dstu2.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DateTimeType)
      return convertDateTime((org.hl7.fhir.dstu2.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DecimalType)
      return convertDecimal((org.hl7.fhir.dstu2.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IdType)
      return convertId((org.hl7.fhir.dstu2.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.InstantType)
      return convertInstant((org.hl7.fhir.dstu2.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.PositiveIntType)
      return convertPositiveInt((org.hl7.fhir.dstu2.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UnsignedIntType)
      return convertUnsignedInt((org.hl7.fhir.dstu2.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.IntegerType)
      return convertInteger((org.hl7.fhir.dstu2.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MarkdownType)
      return convertMarkdown((org.hl7.fhir.dstu2.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OidType)
      return convertOid((org.hl7.fhir.dstu2.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StringType)
      return convertString((org.hl7.fhir.dstu2.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TimeType)
      return convertTime((org.hl7.fhir.dstu2.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UuidType)
      return convertUuid((org.hl7.fhir.dstu2.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.UriType)
      return convertUri((org.hl7.fhir.dstu2.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Extension)
      return convertExtension((org.hl7.fhir.dstu2.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Narrative)
      return convertNarrative((org.hl7.fhir.dstu2.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Annotation)
      return convertAnnotation((org.hl7.fhir.dstu2.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Attachment)
      return convertAttachment((org.hl7.fhir.dstu2.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.dstu2.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Coding)
      return convertCoding((org.hl7.fhir.dstu2.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Identifier)
      return convertIdentifier((org.hl7.fhir.dstu2.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Period)
      return convertPeriod((org.hl7.fhir.dstu2.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Age)
      return convertAge((org.hl7.fhir.dstu2.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Count)
      return convertCount((org.hl7.fhir.dstu2.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Distance)
      return convertDistance((org.hl7.fhir.dstu2.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Duration)
      return convertDuration((org.hl7.fhir.dstu2.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Money)
      return convertMoney((org.hl7.fhir.dstu2.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SimpleQuantity)
      return convertSimpleQuantity((org.hl7.fhir.dstu2.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Quantity)
      return convertQuantity((org.hl7.fhir.dstu2.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Range)
      return convertRange((org.hl7.fhir.dstu2.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Ratio)
      return convertRatio((org.hl7.fhir.dstu2.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Reference)
      return convertReference((org.hl7.fhir.dstu2.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SampledData)
      return convertSampledData((org.hl7.fhir.dstu2.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Signature)
      return convertSignature((org.hl7.fhir.dstu2.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Address)
      return convertAddress((org.hl7.fhir.dstu2.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ContactPoint)
      return convertContactPoint((org.hl7.fhir.dstu2.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ElementDefinition)
      return convertElementDefinition((org.hl7.fhir.dstu2.model.ElementDefinition) src, new ArrayList<String>());
    if (src instanceof org.hl7.fhir.dstu2.model.HumanName)
      return convertHumanName((org.hl7.fhir.dstu2.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Meta)
      return convertMeta((org.hl7.fhir.dstu2.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Timing)
      return convertTiming((org.hl7.fhir.dstu2.model.Timing) src);
    throw new FHIRException("Unknown type " + src.fhirType());
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Base64BinaryType)
      return convertBase64Binary((org.hl7.fhir.dstu3.model.Base64BinaryType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BooleanType)
      return convertBoolean((org.hl7.fhir.dstu3.model.BooleanType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeType)
      return convertCode((org.hl7.fhir.dstu3.model.CodeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateType)
      return convertDate((org.hl7.fhir.dstu3.model.DateType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DateTimeType)
      return convertDateTime((org.hl7.fhir.dstu3.model.DateTimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DecimalType)
      return convertDecimal((org.hl7.fhir.dstu3.model.DecimalType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IdType)
      return convertId((org.hl7.fhir.dstu3.model.IdType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.InstantType)
      return convertInstant((org.hl7.fhir.dstu3.model.InstantType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PositiveIntType)
      return convertPositiveInt((org.hl7.fhir.dstu3.model.PositiveIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UnsignedIntType)
      return convertUnsignedInt((org.hl7.fhir.dstu3.model.UnsignedIntType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.IntegerType)
      return convertInteger((org.hl7.fhir.dstu3.model.IntegerType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MarkdownType)
      return convertMarkdown((org.hl7.fhir.dstu3.model.MarkdownType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OidType)
      return convertOid((org.hl7.fhir.dstu3.model.OidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StringType)
      return convertString((org.hl7.fhir.dstu3.model.StringType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TimeType)
      return convertTime((org.hl7.fhir.dstu3.model.TimeType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UuidType)
      return convertUuid((org.hl7.fhir.dstu3.model.UuidType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.UriType)
      return convertUri((org.hl7.fhir.dstu3.model.UriType) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Extension)
      return convertExtension((org.hl7.fhir.dstu3.model.Extension) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Narrative)
      return convertNarrative((org.hl7.fhir.dstu3.model.Narrative) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Annotation)
      return convertAnnotation((org.hl7.fhir.dstu3.model.Annotation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Attachment)
      return convertAttachment((org.hl7.fhir.dstu3.model.Attachment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeableConcept)
      return convertCodeableConcept((org.hl7.fhir.dstu3.model.CodeableConcept) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Coding)
      return convertCoding((org.hl7.fhir.dstu3.model.Coding) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Identifier)
      return convertIdentifier((org.hl7.fhir.dstu3.model.Identifier) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Period)
      return convertPeriod((org.hl7.fhir.dstu3.model.Period) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Age)
      return convertAge((org.hl7.fhir.dstu3.model.Age) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Count)
      return convertCount((org.hl7.fhir.dstu3.model.Count) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Distance)
      return convertDistance((org.hl7.fhir.dstu3.model.Distance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Duration)
      return convertDuration((org.hl7.fhir.dstu3.model.Duration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Money)
      return convertMoney((org.hl7.fhir.dstu3.model.Money) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SimpleQuantity)
      return convertSimpleQuantity((org.hl7.fhir.dstu3.model.SimpleQuantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Quantity)
      return convertQuantity((org.hl7.fhir.dstu3.model.Quantity) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Range)
      return convertRange((org.hl7.fhir.dstu3.model.Range) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Ratio)
      return convertRatio((org.hl7.fhir.dstu3.model.Ratio) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Reference)
      return convertReference((org.hl7.fhir.dstu3.model.Reference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SampledData)
      return convertSampledData((org.hl7.fhir.dstu3.model.SampledData) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Signature)
      return convertSignature((org.hl7.fhir.dstu3.model.Signature) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Address)
      return convertAddress((org.hl7.fhir.dstu3.model.Address) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ContactPoint)
      return convertContactPoint((org.hl7.fhir.dstu3.model.ContactPoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ElementDefinition)
      return convertElementDefinition((org.hl7.fhir.dstu3.model.ElementDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HumanName)
      return convertHumanName((org.hl7.fhir.dstu3.model.HumanName) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Meta)
      return convertMeta((org.hl7.fhir.dstu3.model.Meta) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Timing)
      return convertTiming((org.hl7.fhir.dstu3.model.Timing) src);
    throw new FHIRException("Unknown type " + src.fhirType());
  }

  public static void copyDomainResource(org.hl7.fhir.dstu2.model.DomainResource src, org.hl7.fhir.dstu3.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    tgt.setText(convertNarrative(src.getText()));
    for (org.hl7.fhir.dstu2.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
    for (org.hl7.fhir.dstu2.model.Extension t : src.getExtension()) tgt.addExtension(convertExtension(t));
    for (org.hl7.fhir.dstu2.model.Extension t : src.getModifierExtension())
      tgt.addModifierExtension(convertExtension(t));
  }

  public static void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    tgt.setText(convertNarrative(src.getText()));
    for (org.hl7.fhir.dstu3.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
    for (org.hl7.fhir.dstu3.model.Extension t : src.getExtension()) tgt.addExtension(convertExtension(t));
    for (org.hl7.fhir.dstu3.model.Extension t : src.getModifierExtension())
      tgt.addModifierExtension(convertExtension(t));
  }

  public static void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    tgt.setMeta(convertMeta(src.getMeta()));
    tgt.setImplicitRules(src.getImplicitRules());
    tgt.setLanguage(src.getLanguage());
  }

  public static void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    if (src.hasMeta())
      tgt.setMeta(convertMeta(src.getMeta()));
    if (src.hasImplicitRules())
      tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage())
      tgt.setLanguage(src.getLanguage());
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGenderEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case MALE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.MALE);
        break;
      case FEMALE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.OTHER);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGenderEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case MALE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.MALE);
        break;
      case FEMALE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.FEMALE);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.OTHER);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.SearchParamTypeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    tgt.setValue(convertSearchParamType(src.getValue()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType src) throws FHIRException {
    switch (src) {
      case NUMBER:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NUMBER;
      case DATE:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.DATE;
      case STRING:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.STRING;
      case TOKEN:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.TOKEN;
      case REFERENCE:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.REFERENCE;
      case COMPOSITE:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.COMPOSITE;
      case QUANTITY:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.QUANTITY;
      case URI:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.URI;
      default:
        return org.hl7.fhir.dstu3.model.Enumerations.SearchParamType.NULL;
    }
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.SearchParamTypeEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case NUMBER:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NUMBER);
        break;
      case DATE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.DATE);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.STRING);
        break;
      case TOKEN:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.TOKEN);
        break;
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.REFERENCE);
        break;
      case COMPOSITE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.COMPOSITE);
        break;
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.QUANTITY);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.URI);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NULL);
        break;
    }
    return tgt;
  }

  static public class SourceElementComponentWrapper {

    public SourceElementComponentWrapper(SourceElementComponent comp, String source, String target) {
      super();
      this.source = source;
      this.target = target;
      this.comp = comp;
    }

    public String source;

    public String target;

    public org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent comp;
  }

  public static org.hl7.fhir.dstu3.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2.model.CodeableConcept t) throws FHIRException {
    org.hl7.fhir.dstu3.model.UsageContext result = new org.hl7.fhir.dstu3.model.UsageContext();
    result.setValue(convertCodeableConcept(t));
    return result;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.PublicationStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.ACTIVE);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.RETIRED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.ACTIVE);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.RETIRED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CURRENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.CURRENT);
        break;
      case SUPERSEDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CURRENT:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.CURRENT);
        break;
      case SUPERSEDED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public boolean hasConcept(org.hl7.fhir.dstu3.model.CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.dstu3.model.Coding c : cc.getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode()))
        return true;
    }
    return false;
  }

  static public boolean hasConcept(org.hl7.fhir.dstu2.model.CodeableConcept cc, String system, String code) {
    for (org.hl7.fhir.dstu2.model.Coding c : cc.getCoding()) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode()))
        return true;
    }
    return false;
  }

  public static org.hl7.fhir.dstu3.model.Dosage convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
    copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
    copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(convertType(src.getAsNeeded()));
    if (src.hasSite())
      tgt.setSite(convertType(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcessRequest.ActionList> convertActionList(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcessRequest.ActionList> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcessRequest.ActionList> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ProcessRequest.ActionListEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCEL:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.CANCEL);
        break;
      case POLL:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.POLL);
        break;
      case REPROCESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.REPROCESS);
        break;
      case STATUS:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.STATUS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcessRequest.ActionList> convertActionList(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcessRequest.ActionList> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ProcessRequest.ActionList> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ProcessRequest.ActionListEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCEL:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.CANCEL);
        break;
      case POLL:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.POLL);
        break;
      case REPROCESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.REPROCESS);
        break;
      case STATUS:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.STATUS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent convertItemsComponent(org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent tgt = new org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent();
    copyElement(src, tgt);
    if (src.hasSequenceLinkIdElement())
      tgt.setSequenceLinkIdElement(convertInteger(src.getSequenceLinkIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent convertItemsComponent(org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent tgt = new org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent();
    copyElement(src, tgt);
    if (src.hasSequenceLinkIdElement())
      tgt.setSequenceLinkIdElement(convertInteger(src.getSequenceLinkIdElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Slot.SlotStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case BUSY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSY);
        break;
      case FREE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.FREE);
        break;
      case BUSYUNAVAILABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYUNAVAILABLE);
        break;
      case BUSYTENTATIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYTENTATIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Slot.SlotStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case BUSY:
        tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSY);
        break;
      case FREE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.FREE);
        break;
      case BUSYUNAVAILABLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYUNAVAILABLE);
        break;
      case BUSYTENTATIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYTENTATIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUESTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
        break;
      case FAILED:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    VersionConvertor_10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.REQUESTED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent convertCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent();
    copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setSystemElement(convertUri(src.getUrlElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasCaseSensitiveElement())
      tgt.setCaseSensitiveElement(convertBoolean(src.getCaseSensitiveElement()));
    for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(src, cc));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent convertCodeSystemConcept(CodeSystem cs, ConceptDefinitionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent();
    copyElement(src, tgt);
    tgt.setAbstract(CodeSystemUtilities.isNotSelectable(cs, src));
    tgt.setCode(src.getCode());
    tgt.setDefinition(src.getDefinition());
    tgt.setDisplay(src.getDisplay());
    for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(cs, cc));
    for (ConceptDefinitionDesignationComponent cc : src.getDesignation())
      tgt.addDesignation(convertCodeSystemDesignation(cc));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent convertCodeSystemDesignation(ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
    copyElement(src, tgt);
    tgt.setUse(convertCoding(src.getUse()));
    tgt.setLanguage(src.getLanguage());
    tgt.setValue(src.getValue());
    return tgt;
  }

  static public boolean isJurisdiction(CodeableConcept t) {
    return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, VersionConvertorAdvisor30 advisor) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Parameters)
      return Parameters10_30.convertParameters((org.hl7.fhir.dstu2.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Account)
      return Account10_30.convertAccount((org.hl7.fhir.dstu2.model.Account) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Appointment)
      return Appointment10_30.convertAppointment((org.hl7.fhir.dstu2.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AppointmentResponse)
      return AppointmentResponse10_30.convertAppointmentResponse((org.hl7.fhir.dstu2.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AuditEvent)
      return AuditEvent10_30.convertAuditEvent((org.hl7.fhir.dstu2.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Basic)
      return Basic10_30.convertBasic((org.hl7.fhir.dstu2.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Binary)
      return Binary10_30.convertBinary((org.hl7.fhir.dstu2.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Bundle)
      return Bundle10_30.convertBundle((org.hl7.fhir.dstu2.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CarePlan)
      return CarePlan10_30.convertCarePlan((org.hl7.fhir.dstu2.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ClinicalImpression)
      return ClinicalImpression10_30.convertClinicalImpression((org.hl7.fhir.dstu2.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Communication)
      return Communication10_30.convertCommunication((org.hl7.fhir.dstu2.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CommunicationRequest)
      return CommunicationRequest10_30.convertCommunicationRequest((org.hl7.fhir.dstu2.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Composition)
      return Composition10_30.convertComposition((org.hl7.fhir.dstu2.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ConceptMap)
      return ConceptMap10_30.convertConceptMap((org.hl7.fhir.dstu2.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Condition)
      return Condition10_30.convertCondition((org.hl7.fhir.dstu2.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Conformance)
      return Conformance10_30.convertConformance((org.hl7.fhir.dstu2.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Contract)
      return Contract10_30.convertContract((org.hl7.fhir.dstu2.model.Contract) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DataElement)
      return DataElement10_30.convertDataElement((org.hl7.fhir.dstu2.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DetectedIssue)
      return DetectedIssue10_30.convertDetectedIssue((org.hl7.fhir.dstu2.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Device)
      return Device10_30.convertDevice((org.hl7.fhir.dstu2.model.Device) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceComponent)
      return DeviceComponent10_30.convertDeviceComponent((org.hl7.fhir.dstu2.model.DeviceComponent) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceMetric)
      return DeviceMetric10_30.convertDeviceMetric((org.hl7.fhir.dstu2.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceUseStatement)
      return DeviceUseStatement10_30.convertDeviceUseStatement((org.hl7.fhir.dstu2.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DiagnosticReport)
      return DiagnosticReport10_30.convertDiagnosticReport((org.hl7.fhir.dstu2.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DocumentManifest)
      return DocumentManifest10_30.convertDocumentManifest((org.hl7.fhir.dstu2.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DocumentReference)
      return DocumentReference10_30.convertDocumentReference((org.hl7.fhir.dstu2.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Encounter)
      return Encounter10_30.convertEncounter((org.hl7.fhir.dstu2.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentRequest)
      return EnrollmentRequest10_30.convertEnrollmentRequest((org.hl7.fhir.dstu2.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentResponse)
      return EnrollmentResponse10_30.convertEnrollmentResponse((org.hl7.fhir.dstu2.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EpisodeOfCare)
      return EpisodeOfCare10_30.convertEpisodeOfCare((org.hl7.fhir.dstu2.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu2.model.FamilyMemberHistory)
      return FamilyMemberHistory10_30.convertFamilyMemberHistory((org.hl7.fhir.dstu2.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Flag)
      return Flag10_30.convertFlag((org.hl7.fhir.dstu2.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Group)
      return Group10_30.convertGroup((org.hl7.fhir.dstu2.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu2.model.HealthcareService)
      return HealthcareService10_30.convertHealthcareService((org.hl7.fhir.dstu2.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImagingStudy)
      return ImagingStudy10_30.convertImagingStudy((org.hl7.fhir.dstu2.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Immunization)
      return Immunization10_30.convertImmunization((org.hl7.fhir.dstu2.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImmunizationRecommendation)
      return ImmunizationRecommendation10_30.convertImmunizationRecommendation((org.hl7.fhir.dstu2.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImplementationGuide)
      return ImplementationGuide10_30.convertImplementationGuide((org.hl7.fhir.dstu2.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2.model.List_)
      return List10_30.convertList((org.hl7.fhir.dstu2.model.List_) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Location)
      return Location10_30.convertLocation((org.hl7.fhir.dstu2.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Media)
      return Media10_30.convertMedia((org.hl7.fhir.dstu2.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Medication)
      return Medication10_30.convertMedication((org.hl7.fhir.dstu2.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationDispense)
      return MedicationDispense10_30.convertMedicationDispense((org.hl7.fhir.dstu2.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationStatement)
      return MedicationStatement10_30.convertMedicationStatement((org.hl7.fhir.dstu2.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MessageHeader)
      return MessageHeader10_30.convertMessageHeader((org.hl7.fhir.dstu2.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu2.model.NamingSystem)
      return NamingSystem10_30.convertNamingSystem((org.hl7.fhir.dstu2.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Observation)
      return Observation10_30.convertObservation((org.hl7.fhir.dstu2.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationDefinition)
      return OperationDefinition10_30.convertOperationDefinition((org.hl7.fhir.dstu2.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationOutcome)
      return OperationOutcome10_30.convertOperationOutcome((org.hl7.fhir.dstu2.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Organization)
      return Organization10_30.convertOrganization((org.hl7.fhir.dstu2.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Patient)
      return Patient10_30.convertPatient((org.hl7.fhir.dstu2.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Person)
      return Person10_30.convertPerson((org.hl7.fhir.dstu2.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Practitioner)
      return Practitioner10_30.convertPractitioner((org.hl7.fhir.dstu2.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Procedure)
      return Procedure10_30.convertProcedure((org.hl7.fhir.dstu2.model.Procedure) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ProcedureRequest)
      return ProcedureRequest10_30.convertProcedureRequest((org.hl7.fhir.dstu2.model.ProcedureRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Provenance)
      return Provenance10_30.convertProvenance((org.hl7.fhir.dstu2.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Questionnaire)
      return Questionnaire10_30.convertQuestionnaire((org.hl7.fhir.dstu2.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2.model.QuestionnaireResponse)
      return QuestionnaireResponse10_30.convertQuestionnaireResponse((org.hl7.fhir.dstu2.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ReferralRequest)
      return ReferralRequest10_30.convertReferralRequest((org.hl7.fhir.dstu2.model.ReferralRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.RelatedPerson)
      return RelatedPerson10_30.convertRelatedPerson((org.hl7.fhir.dstu2.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu2.model.RiskAssessment)
      return RiskAssessment10_30.convertRiskAssessment((org.hl7.fhir.dstu2.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Schedule)
      return Schedule10_30.convertSchedule((org.hl7.fhir.dstu2.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SearchParameter)
      return SearchParameter10_30.convertSearchParameter((org.hl7.fhir.dstu2.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Slot)
      return Slot10_30.convertSlot((org.hl7.fhir.dstu2.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StructureDefinition)
      return StructureDefinition10_30.convertStructureDefinition((org.hl7.fhir.dstu2.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Subscription)
      return Subscription10_30.convertSubscription((org.hl7.fhir.dstu2.model.Subscription) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Substance)
      return Substance10_30.convertSubstance((org.hl7.fhir.dstu2.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyDelivery)
      return SupplyDelivery10_30.convertSupplyDelivery((org.hl7.fhir.dstu2.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyRequest)
      return SupplyRequest10_30.convertSupplyRequest((org.hl7.fhir.dstu2.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TestScript)
      return TestScript10_30.convertTestScript((org.hl7.fhir.dstu2.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ValueSet)
      return ValueSet10_30.convertValueSet((org.hl7.fhir.dstu2.model.ValueSet) src, advisor);
    throw new FHIRException("Unknown resource " + src.fhirType());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, VersionConvertorAdvisor30 advisor) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
      return Parameters10_30.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Appointment)
      return Appointment10_30.convertAppointment((org.hl7.fhir.dstu3.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AppointmentResponse)
      return AppointmentResponse10_30.convertAppointmentResponse((org.hl7.fhir.dstu3.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AuditEvent)
      return AuditEvent10_30.convertAuditEvent((org.hl7.fhir.dstu3.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Basic)
      return Basic10_30.convertBasic((org.hl7.fhir.dstu3.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Binary)
      return Binary10_30.convertBinary((org.hl7.fhir.dstu3.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
      return Bundle10_30.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src, advisor);
    if (src instanceof org.hl7.fhir.dstu3.model.CarePlan)
      return CarePlan10_30.convertCarePlan((org.hl7.fhir.dstu3.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ClinicalImpression)
      return ClinicalImpression10_30.convertClinicalImpression((org.hl7.fhir.dstu3.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Communication)
      return Communication10_30.convertCommunication((org.hl7.fhir.dstu3.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CommunicationRequest)
      return CommunicationRequest10_30.convertCommunicationRequest((org.hl7.fhir.dstu3.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Composition)
      return Composition10_30.convertComposition((org.hl7.fhir.dstu3.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
      return ConceptMap10_30.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Condition)
      return Condition10_30.convertCondition((org.hl7.fhir.dstu3.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
      return Conformance10_30.convertConformance((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Contract)
      return Contract10_30.convertContract((org.hl7.fhir.dstu3.model.Contract) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
      return DataElement10_30.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DetectedIssue)
      return DetectedIssue10_30.convertDetectedIssue((org.hl7.fhir.dstu3.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Device)
      return Device10_30.convertDevice((org.hl7.fhir.dstu3.model.Device) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceComponent)
      return DeviceComponent10_30.convertDeviceComponent((org.hl7.fhir.dstu3.model.DeviceComponent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceMetric)
      return DeviceMetric10_30.convertDeviceMetric((org.hl7.fhir.dstu3.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceUseStatement)
      return DeviceUseStatement10_30.convertDeviceUseStatement((org.hl7.fhir.dstu3.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DiagnosticReport)
      return DiagnosticReport10_30.convertDiagnosticReport((org.hl7.fhir.dstu3.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentManifest)
      return DocumentManifest10_30.convertDocumentManifest((org.hl7.fhir.dstu3.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentReference)
      return DocumentReference10_30.convertDocumentReference((org.hl7.fhir.dstu3.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Encounter)
      return Encounter10_30.convertEncounter((org.hl7.fhir.dstu3.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EnrollmentRequest)
      return EnrollmentRequest10_30.convertEnrollmentRequest((org.hl7.fhir.dstu3.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EnrollmentResponse)
      return EnrollmentResponse10_30.convertEnrollmentResponse((org.hl7.fhir.dstu3.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EpisodeOfCare)
      return EpisodeOfCare10_30.convertEpisodeOfCare((org.hl7.fhir.dstu3.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu3.model.FamilyMemberHistory)
      return FamilyMemberHistory10_30.convertFamilyMemberHistory((org.hl7.fhir.dstu3.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Flag)
      return Flag10_30.convertFlag((org.hl7.fhir.dstu3.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Group)
      return Group10_30.convertGroup((org.hl7.fhir.dstu3.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HealthcareService)
      return HealthcareService10_30.convertHealthcareService((org.hl7.fhir.dstu3.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImagingStudy)
      return ImagingStudy10_30.convertImagingStudy((org.hl7.fhir.dstu3.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Immunization)
      return Immunization10_30.convertImmunization((org.hl7.fhir.dstu3.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImmunizationRecommendation)
      return ImmunizationRecommendation10_30.convertImmunizationRecommendation((org.hl7.fhir.dstu3.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
      return ImplementationGuide10_30.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ListResource)
      return List10_30.convertList((org.hl7.fhir.dstu3.model.ListResource) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Location)
      return Location10_30.convertLocation((org.hl7.fhir.dstu3.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Media)
      return Media10_30.convertMedia((org.hl7.fhir.dstu3.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Medication)
      return Medication10_30.convertMedication((org.hl7.fhir.dstu3.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationDispense)
      return MedicationDispense10_30.convertMedicationDispense((org.hl7.fhir.dstu3.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationStatement)
      return MedicationStatement10_30.convertMedicationStatement((org.hl7.fhir.dstu3.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageHeader)
      return MessageHeader10_30.convertMessageHeader((org.hl7.fhir.dstu3.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
      return NamingSystem10_30.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Observation)
      return Observation10_30.convertObservation((org.hl7.fhir.dstu3.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
      return OperationDefinition10_30.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
      return OperationOutcome10_30.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Organization)
      return Organization10_30.convertOrganization((org.hl7.fhir.dstu3.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Patient)
      return Patient10_30.convertPatient((org.hl7.fhir.dstu3.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Person)
      return Person10_30.convertPerson((org.hl7.fhir.dstu3.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Practitioner)
      return Practitioner10_30.convertPractitioner((org.hl7.fhir.dstu3.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Procedure)
      return Procedure10_30.convertProcedure((org.hl7.fhir.dstu3.model.Procedure) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ProcedureRequest)
      return ProcedureRequest10_30.convertProcedureRequest((org.hl7.fhir.dstu3.model.ProcedureRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Provenance)
      return Provenance10_30.convertProvenance((org.hl7.fhir.dstu3.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
      return Questionnaire10_30.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
      return QuestionnaireResponse10_30.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ReferralRequest)
      return ReferralRequest10_30.convertReferralRequest((org.hl7.fhir.dstu3.model.ReferralRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedPerson)
      return RelatedPerson10_30.convertRelatedPerson((org.hl7.fhir.dstu3.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RiskAssessment)
      return RiskAssessment10_30.convertRiskAssessment((org.hl7.fhir.dstu3.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Schedule)
      return Schedule10_30.convertSchedule((org.hl7.fhir.dstu3.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
      return SearchParameter10_30.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Slot)
      return Slot10_30.convertSlot((org.hl7.fhir.dstu3.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Specimen)
      return Specimen10_30.convertSpecimen((org.hl7.fhir.dstu3.model.Specimen) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
      return StructureDefinition10_30.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Subscription)
      return Subscription10_30.convertSubscription((org.hl7.fhir.dstu3.model.Subscription) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Substance)
      return Substance10_30.convertSubstance((org.hl7.fhir.dstu3.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyDelivery)
      return SupplyDelivery10_30.convertSupplyDelivery((org.hl7.fhir.dstu3.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyRequest)
      return SupplyRequest10_30.convertSupplyRequest((org.hl7.fhir.dstu3.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
      return TestScript10_30.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
      return ValueSet10_30.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src, advisor);
    throw new FHIRException("Unknown resource " + src.fhirType());
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "Bundle", "CarePlan", "ClinicalImpression", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "CapabilityStatement", "Contract", "DataElement", "DetectedIssue", "Device", "DeviceComponent", "DeviceMetric", "DeviceUseStatement", "DiagnosticReport", "DocumentManifest", "DocumentReference", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Group", "HealthcareService", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "ListResource", "Location", "Media", "Medication", "MedicationDispense", "MedicationStatement", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "Person", "Practitioner", "Procedure", "ProcedureRequest", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "StructureDefinition", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "TestScript", "ValueSet");
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    return convertResource(src, null);
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    return convertResource(src, null);
  }
}