package org.hl7.fhir.convertors;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.hl7.fhir.convertors.conv10_30.*;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.dstu3.conformance.ProfileUtilities;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.dstu3.model.Timing.EventTiming;
import org.hl7.fhir.dstu3.terminologies.CodeSystemUtilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

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
        org.hl7.fhir.dstu3.model.Base64BinaryType tgt = new org.hl7.fhir.dstu3.model.Base64BinaryType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu3.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.Base64BinaryType tgt = new org.hl7.fhir.dstu2.model.Base64BinaryType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.BooleanType convertBoolean(org.hl7.fhir.dstu2.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.BooleanType tgt = new org.hl7.fhir.dstu3.model.BooleanType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.BooleanType convertBoolean(org.hl7.fhir.dstu3.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.BooleanType tgt = new org.hl7.fhir.dstu2.model.BooleanType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeType convertCode(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.CodeType tgt = new org.hl7.fhir.dstu3.model.CodeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertCode(org.hl7.fhir.dstu3.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.CodeType tgt = new org.hl7.fhir.dstu2.model.CodeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UriType convertCodeToUri(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UriType tgt = new org.hl7.fhir.dstu3.model.UriType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertUriToCode(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.CodeType tgt = new org.hl7.fhir.dstu2.model.CodeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateType tgt = new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateType tgt = new org.hl7.fhir.dstu3.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateTimeType tgt = new org.hl7.fhir.dstu3.model.DateTimeType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateTimeType convertDateTime(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateTimeType tgt = new org.hl7.fhir.dstu2.model.DateTimeType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DecimalType convertDecimal(org.hl7.fhir.dstu2.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DecimalType tgt = new org.hl7.fhir.dstu3.model.DecimalType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DecimalType convertDecimal(org.hl7.fhir.dstu3.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DecimalType tgt = new org.hl7.fhir.dstu2.model.DecimalType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.IdType convertId(org.hl7.fhir.dstu2.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.IdType tgt = new org.hl7.fhir.dstu3.model.IdType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.IdType convertId(org.hl7.fhir.dstu3.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.IdType tgt = new org.hl7.fhir.dstu2.model.IdType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.dstu2.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.InstantType tgt = new org.hl7.fhir.dstu3.model.InstantType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.InstantType tgt = new org.hl7.fhir.dstu2.model.InstantType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.IntegerType convertInteger(org.hl7.fhir.dstu2.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.IntegerType tgt = new org.hl7.fhir.dstu3.model.IntegerType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.IntegerType convertInteger(org.hl7.fhir.dstu3.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.IntegerType tgt = new org.hl7.fhir.dstu2.model.IntegerType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.MarkdownType tgt = new org.hl7.fhir.dstu3.model.MarkdownType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu3.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.MarkdownType tgt = new org.hl7.fhir.dstu2.model.MarkdownType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OidType convertOid(org.hl7.fhir.dstu2.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.OidType tgt = new org.hl7.fhir.dstu3.model.OidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OidType convertOid(org.hl7.fhir.dstu3.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.OidType tgt = new org.hl7.fhir.dstu2.model.OidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.PositiveIntType tgt = new org.hl7.fhir.dstu3.model.PositiveIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu3.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.PositiveIntType tgt = new org.hl7.fhir.dstu2.model.PositiveIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StringType convertString(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.StringType tgt = new org.hl7.fhir.dstu3.model.StringType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StringType convertString(org.hl7.fhir.dstu3.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.StringType tgt = new org.hl7.fhir.dstu2.model.StringType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TimeType convertTime(org.hl7.fhir.dstu2.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.TimeType tgt = new org.hl7.fhir.dstu3.model.TimeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TimeType convertTime(org.hl7.fhir.dstu3.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.TimeType tgt = new org.hl7.fhir.dstu2.model.TimeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UnsignedIntType tgt = new org.hl7.fhir.dstu3.model.UnsignedIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu3.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UnsignedIntType tgt = new org.hl7.fhir.dstu2.model.UnsignedIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UriType tgt = new org.hl7.fhir.dstu3.model.UriType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UriType tgt = new org.hl7.fhir.dstu2.model.UriType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.UuidType convertUuid(org.hl7.fhir.dstu2.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.UuidType tgt = new org.hl7.fhir.dstu3.model.UuidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UuidType convertUuid(org.hl7.fhir.dstu3.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UuidType tgt = new org.hl7.fhir.dstu2.model.UuidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Extension tgt = new org.hl7.fhir.dstu3.model.Extension();
        copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.dstu3.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
        copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Narrative convertNarrative(org.hl7.fhir.dstu2.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Narrative tgt = new org.hl7.fhir.dstu3.model.Narrative();
        copyElement(src, tgt);
        tgt.setStatus(convertNarrativeStatus(src.getStatus()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Narrative convertNarrative(org.hl7.fhir.dstu3.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Narrative tgt = new org.hl7.fhir.dstu2.model.Narrative();
        copyElement(src, tgt);
        tgt.setStatus(convertNarrativeStatus(src.getStatus()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GENERATED:
                return org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.GENERATED;
            case EXTENSIONS:
                return org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EXTENSIONS;
            case ADDITIONAL:
                return org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.ADDITIONAL;
            case EMPTY:
                return org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.EMPTY;
            default:
                return org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.dstu3.model.Narrative.NarrativeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GENERATED:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.GENERATED;
            case EXTENSIONS:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EXTENSIONS;
            case ADDITIONAL:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.ADDITIONAL;
            case EMPTY:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EMPTY;
            default:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Annotation tgt = new org.hl7.fhir.dstu3.model.Annotation();
        copyElement(src, tgt);
        tgt.setAuthor(convertType(src.getAuthor()));
        tgt.setTime(src.getTime());
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.dstu3.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
        copyElement(src, tgt);
        tgt.setAuthor(convertType(src.getAuthor()));
        tgt.setTime(src.getTime());
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Attachment tgt = new org.hl7.fhir.dstu3.model.Attachment();
        copyElement(src, tgt);
        tgt.setContentType(src.getContentType());
        tgt.setLanguage(src.getLanguage());
        tgt.setData(src.getData());
        tgt.setUrl(src.getUrl());
        tgt.setSize(src.getSize());
        tgt.setHash(src.getHash());
        tgt.setTitle(src.getTitle());
        tgt.setCreation(src.getCreation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.dstu3.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
        copyElement(src, tgt);
        tgt.setContentType(src.getContentType());
        tgt.setLanguage(src.getLanguage());
        tgt.setData(src.getData());
        tgt.setUrl(src.getUrl());
        tgt.setSize(src.getSize());
        tgt.setHash(src.getHash());
        tgt.setTitle(src.getTitle());
        tgt.setCreation(src.getCreation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeableConcept tgt = new org.hl7.fhir.dstu3.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu3.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Coding tgt = new org.hl7.fhir.dstu3.model.Coding();
        copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setVersion(src.getVersion());
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        tgt.setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
        copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setVersion(src.getVersion());
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        tgt.setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Identifier tgt = new org.hl7.fhir.dstu3.model.Identifier();
        copyElement(src, tgt);
        tgt.setUse(convertIdentifierUse(src.getUse()));
        tgt.setType(convertCodeableConcept(src.getType()));
        tgt.setSystem(src.getSystem());
        tgt.setValue(src.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.dstu3.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUse(convertIdentifierUse(src.getUse()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasAssigner())
            tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.TEMP;
            case SECONDARY:
                return org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.SECONDARY;
            default:
                return org.hl7.fhir.dstu3.model.Identifier.IdentifierUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.dstu3.model.Identifier.IdentifierUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.TEMP;
            case SECONDARY:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.SECONDARY;
            default:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Period tgt = new org.hl7.fhir.dstu3.model.Period();
        copyElement(src, tgt);
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.dstu3.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
        copyElement(src, tgt);
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Quantity convertQuantity(org.hl7.fhir.dstu2.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Quantity tgt = new org.hl7.fhir.dstu3.model.Quantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Quantity convertQuantity(org.hl7.fhir.dstu3.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Quantity tgt = new org.hl7.fhir.dstu2.model.Quantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LESS_THAN:
                return org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_THAN;
            case LESS_OR_EQUAL:
                return org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
            case GREATER_OR_EQUAL:
                return org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
            case GREATER_THAN:
                return org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.GREATER_THAN;
            default:
                return org.hl7.fhir.dstu3.model.Quantity.QuantityComparator.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.dstu3.model.Quantity.QuantityComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LESS_THAN:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_THAN;
            case LESS_OR_EQUAL:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
            case GREATER_OR_EQUAL:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
            case GREATER_THAN:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_THAN;
            default:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
        copyElement(src, tgt);
        tgt.setLow(convertSimpleQuantity(src.getLow()));
        tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
        copyElement(src, tgt);
        tgt.setLow(convertSimpleQuantity(src.getLow()));
        tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Ratio tgt = new org.hl7.fhir.dstu3.model.Ratio();
        copyElement(src, tgt);
        tgt.setNumerator(convertQuantity(src.getNumerator()));
        tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.dstu3.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
        copyElement(src, tgt);
        tgt.setNumerator(convertQuantity(src.getNumerator()));
        tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
        copyElement(src, tgt);
        tgt.setReference(src.getReference());
        tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
        copyElement(src, tgt);
        tgt.setReference(src.getReference());
        tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
        copyElement(src, tgt);
        tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        tgt.setPeriod(src.getPeriod());
        tgt.setFactor(src.getFactor());
        tgt.setLowerLimit(src.getLowerLimit());
        tgt.setUpperLimit(src.getUpperLimit());
        tgt.setDimensions(src.getDimensions());
        tgt.setData(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
        copyElement(src, tgt);
        tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        tgt.setPeriod(src.getPeriod());
        tgt.setFactor(src.getFactor());
        tgt.setLowerLimit(src.getLowerLimit());
        tgt.setUpperLimit(src.getUpperLimit());
        tgt.setDimensions(src.getDimensions());
        tgt.setData(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Signature tgt = new org.hl7.fhir.dstu3.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        tgt.setWhen(src.getWhen());
        tgt.setWho(convertType(src.getWho()));
        tgt.setContentType(src.getContentType());
        tgt.setBlob(src.getBlob());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.dstu3.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        tgt.setWhen(src.getWhen());
        tgt.setWho(convertType(src.getWho()));
        tgt.setContentType(src.getContentType());
        tgt.setBlob(src.getBlob());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Address convertAddress(org.hl7.fhir.dstu2.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Address tgt = new org.hl7.fhir.dstu3.model.Address();
        copyElement(src, tgt);
        tgt.setUse(convertAddressUse(src.getUse()));
        tgt.setType(convertAddressType(src.getType()));
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        tgt.setCity(src.getCity());
        tgt.setDistrict(src.getDistrict());
        tgt.setState(src.getState());
        tgt.setPostalCode(src.getPostalCode());
        tgt.setCountry(src.getCountry());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Address convertAddress(org.hl7.fhir.dstu3.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Address tgt = new org.hl7.fhir.dstu2.model.Address();
        copyElement(src, tgt);
        tgt.setUse(convertAddressUse(src.getUse()));
        tgt.setType(convertAddressType(src.getType()));
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        tgt.setCity(src.getCity());
        tgt.setDistrict(src.getDistrict());
        tgt.setState(src.getState());
        tgt.setPostalCode(src.getPostalCode());
        tgt.setCountry(src.getCountry());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Address.AddressUse convertAddressUse(org.hl7.fhir.dstu2.model.Address.AddressUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu3.model.Address.AddressUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu3.model.Address.AddressUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu3.model.Address.AddressUse.OLD;
            default:
                return org.hl7.fhir.dstu3.model.Address.AddressUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Address.AddressUse convertAddressUse(org.hl7.fhir.dstu3.model.Address.AddressUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.OLD;
            default:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Address.AddressType convertAddressType(org.hl7.fhir.dstu2.model.Address.AddressType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case POSTAL:
                return org.hl7.fhir.dstu3.model.Address.AddressType.POSTAL;
            case PHYSICAL:
                return org.hl7.fhir.dstu3.model.Address.AddressType.PHYSICAL;
            case BOTH:
                return org.hl7.fhir.dstu3.model.Address.AddressType.BOTH;
            default:
                return org.hl7.fhir.dstu3.model.Address.AddressType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Address.AddressType convertAddressType(org.hl7.fhir.dstu3.model.Address.AddressType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case POSTAL:
                return org.hl7.fhir.dstu2.model.Address.AddressType.POSTAL;
            case PHYSICAL:
                return org.hl7.fhir.dstu2.model.Address.AddressType.PHYSICAL;
            case BOTH:
                return org.hl7.fhir.dstu2.model.Address.AddressType.BOTH;
            default:
                return org.hl7.fhir.dstu2.model.Address.AddressType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactPoint tgt = new org.hl7.fhir.dstu3.model.ContactPoint();
        copyElement(src, tgt);
        tgt.setSystem(convertContactPointSystem(src.getSystem()));
        tgt.setValue(src.getValue());
        tgt.setUse(convertContactPointUse(src.getUse()));
        if (src.hasRank())
            tgt.setRank(src.getRank());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu3.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ContactPoint tgt = new org.hl7.fhir.dstu2.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystem(convertContactPointSystem(src.getSystem()));
        tgt.setValue(src.getValue());
        tgt.setUse(convertContactPointUse(src.getUse()));
        tgt.setRank(src.getRank());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHONE:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PHONE;
            case FAX:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.FAX;
            case EMAIL:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.EMAIL;
            case PAGER:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.PAGER;
            case OTHER:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.OTHER;
            default:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHONE:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PHONE;
            case FAX:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.FAX;
            case EMAIL:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.EMAIL;
            case PAGER:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PAGER;
            case OTHER:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER;
            case URL:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER;
            default:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.OLD;
            case MOBILE:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.MOBILE;
            default:
                return org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.OLD;
            case MOBILE:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.MOBILE;
            default:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2.model.ElementDefinition src, List<String> slicePaths) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition tgt = new org.hl7.fhir.dstu3.model.ElementDefinition();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation()) copyElement(t, tgt.addRepresentationElement().setValue(convertPropertyRepresentation(t.getValue())));
        if (src.hasName()) {
            if (slicePaths.contains(src.getPath()))
                tgt.setSliceName(src.getName());
            tgt.setId(src.getName());
        }
        if (src.hasLabel())
            tgt.setLabel(src.getLabel());
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        if (src.hasShort())
            tgt.setShort(src.getShort());
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasComments())
            tgt.setComment(src.getComments());
        if (src.hasRequirements())
            tgt.setRequirements(src.getRequirements());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasNameReference())
            tgt.setContentReference("#" + src.getNameReference());
        for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : src.getType()) tgt.addType(convertElementDefinitionTypeComponent(t));
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissing(src.getMeaningWhenMissing());
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
            tgt.setMaxLength(src.getMaxLength());
        for (org.hl7.fhir.dstu2.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupport(src.getMustSupport());
        if (src.hasIsModifier())
            tgt.setIsModifier(src.getIsModifier());
        if (src.hasIsSummary())
            tgt.setIsSummary(src.getIsSummary());
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu3.model.ElementDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition tgt = new org.hl7.fhir.dstu2.model.ElementDefinition();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation()) copyElement(t, tgt.addRepresentationElement().setValue(convertPropertyRepresentation(t.getValue())));
        if (src.hasSliceName())
            tgt.setName(src.getSliceName());
        else
            tgt.setName(src.getId());
        tgt.setLabel(src.getLabel());
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        tgt.setShort(src.getShort());
        tgt.setDefinition(src.getDefinition());
        tgt.setComments(src.getComment());
        tgt.setRequirements(src.getRequirements());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setNameReference(src.getContentReference().substring(1));
        for (org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent t : src.getType()) tgt.addType(convertElementDefinitionTypeComponent(t));
        tgt.setDefaultValue(convertType(src.getDefaultValue()));
        tgt.setMeaningWhenMissing(src.getMeaningWhenMissing());
        tgt.setFixed(convertType(src.getFixed()));
        tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.setExample(convertType(src.getExampleFirstRep().getValue()));
        tgt.setMinValue(convertType(src.getMinValue()));
        tgt.setMaxValue(convertType(src.getMaxValue()));
        tgt.setMaxLength(src.getMaxLength());
        for (org.hl7.fhir.dstu3.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        tgt.setMustSupport(src.getMustSupport());
        tgt.setIsModifier(src.getIsModifier());
        tgt.setIsSummary(src.getIsSummary());
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XMLATTR:
                return org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.XMLATTR;
            default:
                return org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.dstu3.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XMLATTR:
                return org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.XMLATTR;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.StringType t : src.getDiscriminator()) tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue()));
        tgt.setDescription(src.getDescription());
        tgt.setOrdered(src.getOrdered());
        tgt.setRules(convertSlicingRules(src.getRules()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
        tgt.setDescription(src.getDescription());
        tgt.setOrdered(src.getOrdered());
        tgt.setRules(convertSlicingRules(src.getRules()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLOSED:
                return org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.CLOSED;
            case OPEN:
                return org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPEN;
            case OPENATEND:
                return org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.OPENATEND;
            default:
                return org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.dstu3.model.ElementDefinition.SlicingRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLOSED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.CLOSED;
            case OPEN:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPEN;
            case OPENATEND:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPENATEND;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent convertElementDefinitionTypeComponent(org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCodeElement(convertCodeToUri(src.getCodeElement()));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) if (src.hasTarget())
            tgt.setTargetProfile(t.getValueAsString());
        else
            tgt.setProfile(t.getValue());
        for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> t : src.getAggregation()) copyElement(t, tgt.addAggregationElement().setValue(convertAggregationMode(t.getValue())));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent convertElementDefinitionTypeComponent(org.hl7.fhir.dstu3.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCodeElement(convertUriToCode(src.getCodeElement()));
        if (src.hasTarget()) {
            if (src.hasTargetProfile())
                tgt.addProfile(src.getTargetProfile());
        } else if (src.hasProfile())
            tgt.addProfile(src.getProfile());
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode> t : src.getAggregation()) copyElement(t, tgt.addAggregationElement().setValue(convertAggregationMode(t.getValue())));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONTAINED:
                return org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.CONTAINED;
            case REFERENCED:
                return org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.REFERENCED;
            case BUNDLED:
                return org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.BUNDLED;
            default:
                return org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.dstu3.model.ElementDefinition.AggregationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONTAINED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.CONTAINED;
            case REFERENCED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.REFERENCED;
            case BUNDLED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.BUNDLED;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        tgt.setKey(src.getKey());
        tgt.setRequirements(src.getRequirements());
        tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
        tgt.setHuman(src.getHuman());
        tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
        tgt.setXpath(src.getXpath());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        tgt.setKey(src.getKey());
        tgt.setRequirements(src.getRequirements());
        tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
        tgt.setHuman(src.getHuman());
        if (src.hasExpression())
            ToolingExtensions.addStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
        tgt.setXpath(src.getXpath());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ERROR:
                return org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.WARNING;
            default:
                return org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.dstu3.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ERROR:
                return org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.WARNING;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        tgt.setStrength(convertBindingStrength(src.getStrength()));
        tgt.setDescription(src.getDescription());
        tgt.setValueSet(convertType(src.getValueSet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        tgt.setStrength(convertBindingStrength(src.getStrength()));
        tgt.setDescription(src.getDescription());
        tgt.setValueSet(convertType(src.getValueSet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.REQUIRED;
            case EXTENSIBLE:
                return org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXTENSIBLE;
            case PREFERRED:
                return org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.PREFERRED;
            case EXAMPLE:
                return org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.EXAMPLE;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.BindingStrength.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.dstu3.model.Enumerations.BindingStrength src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.REQUIRED;
            case EXTENSIBLE:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXTENSIBLE;
            case PREFERRED:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.PREFERRED;
            case EXAMPLE:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXAMPLE;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        tgt.setLanguage(src.getLanguage());
        tgt.setMap(src.getMap());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu3.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        tgt.setLanguage(src.getLanguage());
        tgt.setMap(src.getMap());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HumanName convertHumanName(org.hl7.fhir.dstu2.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.HumanName tgt = new org.hl7.fhir.dstu3.model.HumanName();
        copyElement(src, tgt);
        tgt.setUse(convertNameUse(src.getUse()));
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HumanName convertHumanName(org.hl7.fhir.dstu3.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HumanName tgt = new org.hl7.fhir.dstu2.model.HumanName();
        copyElement(src, tgt);
        tgt.setUse(convertNameUse(src.getUse()));
        tgt.setText(src.getText());
        if (src.hasFamily())
            tgt.addFamily(src.getFamily());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.HumanName.NameUse convertNameUse(org.hl7.fhir.dstu2.model.HumanName.NameUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.TEMP;
            case NICKNAME:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.NICKNAME;
            case ANONYMOUS:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.ANONYMOUS;
            case OLD:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.OLD;
            case MAIDEN:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.MAIDEN;
            default:
                return org.hl7.fhir.dstu3.model.HumanName.NameUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.HumanName.NameUse convertNameUse(org.hl7.fhir.dstu3.model.HumanName.NameUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.TEMP;
            case NICKNAME:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.NICKNAME;
            case ANONYMOUS:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.ANONYMOUS;
            case OLD:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.OLD;
            case MAIDEN:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.MAIDEN;
            default:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
        copyElement(src, tgt);
        tgt.setVersionId(src.getVersionId());
        tgt.setLastUpdated(src.getLastUpdated());
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
        tgt.setVersionId(src.getVersionId());
        tgt.setLastUpdated(src.getLastUpdated());
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
        tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Timing convertTiming(org.hl7.fhir.dstu3.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Timing tgt = new org.hl7.fhir.dstu2.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        tgt.setBounds(convertType(src.getBounds()));
        tgt.setCount(src.getCount());
        tgt.setDuration(src.getDuration());
        tgt.setDurationMax(src.getDurationMax());
        tgt.setDurationUnit(convertUnitsOfTime(src.getDurationUnits()));
        tgt.setFrequency(src.getFrequency());
        tgt.setFrequencyMax(src.getFrequencyMax());
        tgt.setPeriod(src.getPeriod());
        tgt.setPeriodMax(src.getPeriodMax());
        tgt.setPeriodUnit(convertUnitsOfTime(src.getPeriodUnits()));
        tgt.addWhen(convertEventTiming(src.getWhen()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        tgt.setBounds(convertType(src.getBounds()));
        tgt.setCount(src.getCount());
        tgt.setDuration(src.getDuration());
        tgt.setDurationMax(src.getDurationMax());
        tgt.setDurationUnits(convertUnitsOfTime(src.getDurationUnit()));
        tgt.setFrequency(src.getFrequency());
        tgt.setFrequencyMax(src.getFrequencyMax());
        tgt.setPeriod(src.getPeriod());
        tgt.setPeriodMax(src.getPeriodMax());
        tgt.setPeriodUnits(convertUnitsOfTime(src.getPeriodUnit()));
        for (Enumeration<EventTiming> t : src.getWhen()) tgt.setWhen(convertEventTiming(t.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case S:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.S;
            case MIN:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MIN;
            case H:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.H;
            case D:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.D;
            case WK:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.WK;
            case MO:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.MO;
            case A:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.A;
            default:
                return org.hl7.fhir.dstu3.model.Timing.UnitsOfTime.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.dstu3.model.Timing.UnitsOfTime src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case S:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.S;
            case MIN:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MIN;
            case H:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.H;
            case D:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.D;
            case WK:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.WK;
            case MO:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MO;
            case A:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.A;
            default:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.dstu2.model.Timing.EventTiming src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HS:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.HS;
            case WAKE:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.WAKE;
            case C:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.C;
            case CM:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.CM;
            case CD:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.CD;
            case CV:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.CV;
            case AC:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.AC;
            case ACM:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.ACM;
            case ACD:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.ACD;
            case ACV:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.ACV;
            case PC:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.PC;
            case PCM:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.PCM;
            case PCD:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.PCD;
            case PCV:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.PCV;
            default:
                return org.hl7.fhir.dstu3.model.Timing.EventTiming.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.dstu3.model.Timing.EventTiming src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HS:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.HS;
            case WAKE:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.WAKE;
            case C:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.C;
            case CM:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.CM;
            case CD:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.CD;
            case CV:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.CV;
            case AC:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.AC;
            case ACM:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.ACM;
            case ACD:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.ACD;
            case ACV:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.ACV;
            case PC:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PC;
            case PCM:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PCM;
            case PCD:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PCD;
            case PCV:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PCV;
            default:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Age convertAge(org.hl7.fhir.dstu2.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Age tgt = new org.hl7.fhir.dstu3.model.Age();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Age convertAge(org.hl7.fhir.dstu3.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Age tgt = new org.hl7.fhir.dstu2.model.Age();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Count convertCount(org.hl7.fhir.dstu2.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Count tgt = new org.hl7.fhir.dstu3.model.Count();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Count convertCount(org.hl7.fhir.dstu3.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Count tgt = new org.hl7.fhir.dstu2.model.Count();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Distance convertDistance(org.hl7.fhir.dstu2.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Distance tgt = new org.hl7.fhir.dstu3.model.Distance();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Distance convertDistance(org.hl7.fhir.dstu3.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Distance tgt = new org.hl7.fhir.dstu2.model.Distance();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Duration convertDuration(org.hl7.fhir.dstu2.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Duration tgt = new org.hl7.fhir.dstu3.model.Duration();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Duration convertDuration(org.hl7.fhir.dstu3.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Duration tgt = new org.hl7.fhir.dstu2.model.Duration();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Money convertMoney(org.hl7.fhir.dstu2.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Money tgt = new org.hl7.fhir.dstu3.model.Money();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Money convertMoney(org.hl7.fhir.dstu3.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Money tgt = new org.hl7.fhir.dstu2.model.Money();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.dstu2.model.SimpleQuantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.SimpleQuantity tgt = new org.hl7.fhir.dstu3.model.SimpleQuantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.dstu3.model.SimpleQuantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2.model.SimpleQuantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
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
        for (org.hl7.fhir.dstu2.model.Extension t : src.getModifierExtension()) tgt.addModifierExtension(convertExtension(t));
    }

    public static void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.dstu3.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.dstu3.model.Extension t : src.getExtension()) tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.dstu3.model.Extension t : src.getModifierExtension()) tgt.addModifierExtension(convertExtension(t));
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

    public static org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MALE:
                return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.MALE;
            case FEMALE:
                return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE;
            case OTHER:
                return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.OTHER;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender convertAdministrativeGender(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MALE:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.MALE;
            case FEMALE:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.FEMALE;
            case OTHER:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.OTHER;
            case UNKNOWN:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.UNKNOWN;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
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

    public static org.hl7.fhir.dstu2.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.dstu3.model.Enumerations.SearchParamType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NUMBER:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NUMBER;
            case DATE:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.DATE;
            case STRING:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.STRING;
            case TOKEN:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.TOKEN;
            case REFERENCE:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.REFERENCE;
            case COMPOSITE:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.COMPOSITE;
            case QUANTITY:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.QUANTITY;
            case URI:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.URI;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NULL;
        }
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

    public static org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus convertConformanceResourceStatus(org.hl7.fhir.dstu3.model.Enumerations.PublicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus convertDocumentReferenceStatus(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.CURRENT;
            case SUPERSEDED:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.SUPERSEDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus convertDocumentReferenceStatus(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.CURRENT;
            case SUPERSEDED:
                return org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.SUPERSEDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.NULL;
        }
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
        tgt.setText(src.getText());
        tgt.setTiming(convertTiming(src.getTiming()));
        tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(convertCodeableConcept(src.getSiteCodeableConcept()));
        tgt.setRoute(convertCodeableConcept(src.getRoute()));
        tgt.setMethod(convertCodeableConcept(src.getMethod()));
        tgt.setDose(convertType(src.getDose()));
        tgt.setRate(convertType(src.getRate()));
        tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
        copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(convertTiming(src.getTiming()));
        tgt.setAsNeeded(convertType(src.getAsNeeded()));
        tgt.setSite(convertType(src.getSite()));
        tgt.setRoute(convertCodeableConcept(src.getRoute()));
        tgt.setMethod(convertCodeableConcept(src.getMethod()));
        tgt.setDose(convertType(src.getDose()));
        tgt.setRate(convertType(src.getRate()));
        tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ProcessRequest.ActionList convertActionList(org.hl7.fhir.dstu2.model.ProcessRequest.ActionList src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CANCEL:
                return org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.CANCEL;
            case POLL:
                return org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.POLL;
            case REPROCESS:
                return org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.REPROCESS;
            case STATUS:
                return org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.STATUS;
            default:
                return org.hl7.fhir.dstu3.model.ProcessRequest.ActionList.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ProcessRequest.ActionList convertActionList(org.hl7.fhir.dstu3.model.ProcessRequest.ActionList src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CANCEL:
                return org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.CANCEL;
            case POLL:
                return org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.POLL;
            case REPROCESS:
                return org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.REPROCESS;
            case STATUS:
                return org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.STATUS;
            default:
                return org.hl7.fhir.dstu2.model.ProcessRequest.ActionList.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent convertItemsComponent(org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent tgt = new org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent();
        copyElement(src, tgt);
        tgt.setSequenceLinkId(src.getSequenceLinkId());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent convertItemsComponent(org.hl7.fhir.dstu3.model.ProcessRequest.ItemsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent tgt = new org.hl7.fhir.dstu2.model.ProcessRequest.ItemsComponent();
        copyElement(src, tgt);
        tgt.setSequenceLinkId(src.getSequenceLinkId());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Slot.SlotStatus convertSlotStatus(org.hl7.fhir.dstu2.model.Slot.SlotStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BUSY:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSY;
            case FREE:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.FREE;
            case BUSYUNAVAILABLE:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYUNAVAILABLE;
            case BUSYTENTATIVE:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYTENTATIVE;
            default:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Slot.SlotStatus convertSlotStatus(org.hl7.fhir.dstu3.model.Slot.SlotStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BUSY:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSY;
            case FREE:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.FREE;
            case BUSYUNAVAILABLE:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYUNAVAILABLE;
            case BUSYTENTATIVE:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYTENTATIVE;
            default:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUESTED:
                return org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.COMPLETED;
            case FAILED:
                return org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
            default:
                return org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus convertSupplyRequestStatus(org.hl7.fhir.dstu3.model.SupplyRequest.SupplyRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.REQUESTED;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.COMPLETED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
            default:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent convertCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent();
        copyElement(src, tgt);
        tgt.setSystem(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setCaseSensitive(src.getCaseSensitive());
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
        for (ConceptDefinitionDesignationComponent cc : src.getDesignation()) tgt.addDesignation(convertCodeSystemDesignation(cc));
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
