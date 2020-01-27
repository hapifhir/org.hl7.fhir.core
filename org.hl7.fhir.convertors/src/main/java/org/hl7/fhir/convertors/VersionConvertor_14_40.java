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

import org.hl7.fhir.convertors.conv14_40.*;
import org.hl7.fhir.dstu2016may.model.CodeableConcept;
import org.hl7.fhir.dstu2016may.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.Timing.EventTiming;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class VersionConvertor_14_40 {

    static public List<String> CANONICAL_URLS = new ArrayList<String>();

    static {
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/codesystem-map");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/cqif-library");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/event-instantiatesCanonical");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-allowedProfile");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-deMap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-sourceStructureMap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-targetStructureMap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-unit-valueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-map");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-supplement");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-system");
    }

    static public void copyElement(org.hl7.fhir.dstu2016may.model.Element src, org.hl7.fhir.r4.model.Element tgt, String... exemptExtensions) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        for (org.hl7.fhir.dstu2016may.model.Extension e : src.getExtension()) {
            if (!Utilities.existsInList(e.getUrl(), exemptExtensions) && (!(e.getUrl().equals(VersionConvertorConstants.PROFILE_EXTENSION) || e.getUrl().equals(VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION) || e.getUrl().equals(VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION)))) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    static public void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.dstu2016may.model.Element tgt, String... exemptExtensions) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            if (!Utilities.existsInList(e.getUrl(), exemptExtensions)) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    static public void copyBackboneElement(org.hl7.fhir.dstu2016may.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    static public void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.dstu2016may.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2016may.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r4.model.Base64BinaryType tgt = new org.hl7.fhir.r4.model.Base64BinaryType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.Base64BinaryType tgt = new org.hl7.fhir.dstu2016may.model.Base64BinaryType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.dstu2016may.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r4.model.BooleanType tgt = new org.hl7.fhir.r4.model.BooleanType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.BooleanType tgt = new org.hl7.fhir.dstu2016may.model.BooleanType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.dstu2016may.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r4.model.CodeType tgt = new org.hl7.fhir.r4.model.CodeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.CodeType tgt = new org.hl7.fhir.dstu2016may.model.CodeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.dstu2016may.model.DateType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateType tgt = new org.hl7.fhir.r4.model.DateType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.DateType tgt = new org.hl7.fhir.dstu2016may.model.DateType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2016may.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = new org.hl7.fhir.r4.model.DateTimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.DateTimeType tgt = new org.hl7.fhir.dstu2016may.model.DateTimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.dstu2016may.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r4.model.DecimalType tgt = new org.hl7.fhir.r4.model.DecimalType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.DecimalType tgt = new org.hl7.fhir.dstu2016may.model.DecimalType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.dstu2016may.model.IdType src) throws FHIRException {
        org.hl7.fhir.r4.model.IdType tgt = new org.hl7.fhir.r4.model.IdType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.IdType tgt = new org.hl7.fhir.dstu2016may.model.IdType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.dstu2016may.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r4.model.InstantType tgt = new org.hl7.fhir.r4.model.InstantType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.InstantType tgt = new org.hl7.fhir.dstu2016may.model.InstantType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.dstu2016may.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r4.model.IntegerType tgt = new org.hl7.fhir.r4.model.IntegerType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.IntegerType tgt = new org.hl7.fhir.dstu2016may.model.IntegerType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2016may.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r4.model.MarkdownType tgt = new org.hl7.fhir.r4.model.MarkdownType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.MarkdownType tgt = new org.hl7.fhir.dstu2016may.model.MarkdownType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.dstu2016may.model.OidType src) throws FHIRException {
        org.hl7.fhir.r4.model.OidType tgt = new org.hl7.fhir.r4.model.OidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.OidType tgt = new org.hl7.fhir.dstu2016may.model.OidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2016may.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.PositiveIntType tgt = new org.hl7.fhir.r4.model.PositiveIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.PositiveIntType tgt = new org.hl7.fhir.dstu2016may.model.PositiveIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.dstu2016may.model.StringType src) throws FHIRException {
        org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.StringType tgt = new org.hl7.fhir.dstu2016may.model.StringType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.dstu2016may.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.TimeType tgt = new org.hl7.fhir.r4.model.TimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.TimeType tgt = new org.hl7.fhir.dstu2016may.model.TimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2016may.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.UnsignedIntType tgt = new org.hl7.fhir.r4.model.UnsignedIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.UnsignedIntType tgt = new org.hl7.fhir.dstu2016may.model.UnsignedIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
        org.hl7.fhir.r4.model.UriType tgt = new org.hl7.fhir.r4.model.UriType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.UriType tgt = new org.hl7.fhir.dstu2016may.model.UriType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.dstu2016may.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r4.model.UuidType tgt = new org.hl7.fhir.r4.model.UuidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.UuidType tgt = new org.hl7.fhir.dstu2016may.model.UuidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.dstu2016may.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
        copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2016may.model.Reference)
                tgt.setValue(convertReferenceToCanonical((Reference) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Extension tgt = new org.hl7.fhir.dstu2016may.model.Extension();
        copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
                tgt.setValue(convertCanonicalToReference((CanonicalType) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Narrative convertNarrative(org.hl7.fhir.dstu2016may.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Narrative tgt = new org.hl7.fhir.r4.model.Narrative();
        copyElement(src, tgt);
        tgt.setStatus(convertNarrativeStatus(src.getStatus()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Narrative convertNarrative(org.hl7.fhir.r4.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Narrative tgt = new org.hl7.fhir.dstu2016may.model.Narrative();
        copyElement(src, tgt);
        tgt.setStatus(convertNarrativeStatus(src.getStatus()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GENERATED:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED;
            case EXTENSIONS:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EXTENSIONS;
            case ADDITIONAL:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.ADDITIONAL;
            case EMPTY:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EMPTY;
            default:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.r4.model.Narrative.NarrativeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GENERATED:
                return org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.GENERATED;
            case EXTENSIONS:
                return org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.EXTENSIONS;
            case ADDITIONAL:
                return org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.ADDITIONAL;
            case EMPTY:
                return org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.EMPTY;
            default:
                return org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Age convertAge(org.hl7.fhir.dstu2016may.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Age tgt = new org.hl7.fhir.r4.model.Age();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Age convertAge(org.hl7.fhir.r4.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Age tgt = new org.hl7.fhir.dstu2016may.model.Age();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.dstu2016may.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
        copyElement(src, tgt);
        tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTime())
            tgt.setTime(src.getTime());
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Annotation tgt = new org.hl7.fhir.dstu2016may.model.Annotation();
        copyElement(src, tgt);
        tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTime())
            tgt.setTime(src.getTime());
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.dstu2016may.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentType())
            tgt.setContentType(src.getContentType());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
        if (src.hasData())
            tgt.setData(src.getData());
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasSize())
            tgt.setSize(src.getSize());
        if (src.hasHash())
            tgt.setHash(src.getHash());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasCreation())
            tgt.setCreation(src.getCreation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Attachment tgt = new org.hl7.fhir.dstu2016may.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentType())
            tgt.setContentType(src.getContentType());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
        if (src.hasData())
            tgt.setData(src.getData());
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasSize())
            tgt.setSize(src.getSize());
        if (src.hasHash())
            tgt.setHash(src.getHash());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasCreation())
            tgt.setCreation(src.getCreation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2016may.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeableConcept tgt = new org.hl7.fhir.dstu2016may.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu2016may.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasUserSelected())
            tgt.setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Coding tgt = new org.hl7.fhir.dstu2016may.model.Coding();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasUserSelected())
            tgt.setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Count convertCount(org.hl7.fhir.dstu2016may.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Count tgt = new org.hl7.fhir.r4.model.Count();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Count convertCount(org.hl7.fhir.r4.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Count tgt = new org.hl7.fhir.dstu2016may.model.Count();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.dstu2016may.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Distance tgt = new org.hl7.fhir.dstu2016may.model.Distance();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Duration convertDuration(org.hl7.fhir.dstu2016may.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Duration tgt = new org.hl7.fhir.r4.model.Duration();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Duration convertDuration(org.hl7.fhir.r4.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Duration tgt = new org.hl7.fhir.dstu2016may.model.Duration();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.dstu2016may.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasCode())
            tgt.setCurrency(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Money tgt = new org.hl7.fhir.dstu2016may.model.Money();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasCurrency())
            tgt.setCode(src.getCurrency());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.dstu2016may.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
        copyElement(src, tgt);
        tgt.setUse(convertIdentifierUse(src.getUse()));
        tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Identifier tgt = new org.hl7.fhir.dstu2016may.model.Identifier();
        copyElement(src, tgt);
        tgt.setUse(convertIdentifierUse(src.getUse()));
        tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.TEMP;
            case SECONDARY:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.SECONDARY;
            default:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.r4.model.Identifier.IdentifierUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.TEMP;
            case SECONDARY:
                return org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.SECONDARY;
            default:
                return org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.dstu2016may.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
        copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStart(src.getStart());
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Period tgt = new org.hl7.fhir.dstu2016may.model.Period();
        copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStart(src.getStart());
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.dstu2016may.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Quantity tgt = new org.hl7.fhir.dstu2016may.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LESS_THAN:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_THAN;
            case LESS_OR_EQUAL:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
            case GREATER_OR_EQUAL:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
            case GREATER_THAN:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_THAN;
            default:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.r4.model.Quantity.QuantityComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LESS_THAN:
                return org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.LESS_THAN;
            case LESS_OR_EQUAL:
                return org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
            case GREATER_OR_EQUAL:
                return org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
            case GREATER_THAN:
                return org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.GREATER_THAN;
            default:
                return org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.dstu2016may.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
        copyElement(src, tgt);
        tgt.setLow(convertSimpleQuantity(src.getLow()));
        tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Range tgt = new org.hl7.fhir.dstu2016may.model.Range();
        copyElement(src, tgt);
        tgt.setLow(convertSimpleQuantity(src.getLow()));
        tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.dstu2016may.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
        copyElement(src, tgt);
        tgt.setNumerator(convertQuantity(src.getNumerator()));
        tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Ratio tgt = new org.hl7.fhir.dstu2016may.model.Ratio();
        copyElement(src, tgt);
        tgt.setNumerator(convertQuantity(src.getNumerator()));
        tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.dstu2016may.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(src.getReference());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Reference tgt = new org.hl7.fhir.dstu2016may.model.Reference();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(src.getReference());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.dstu2016may.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
        copyElement(src, tgt);
        tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        tgt.setPeriod(src.getPeriod());
        if (src.hasFactor())
            tgt.setFactor(src.getFactor());
        if (src.hasLowerLimit())
            tgt.setLowerLimit(src.getLowerLimit());
        if (src.hasUpperLimit())
            tgt.setUpperLimit(src.getUpperLimit());
        tgt.setDimensions(src.getDimensions());
        tgt.setData(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SampledData tgt = new org.hl7.fhir.dstu2016may.model.SampledData();
        copyElement(src, tgt);
        tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        tgt.setPeriod(src.getPeriod());
        if (src.hasFactor())
            tgt.setFactor(src.getFactor());
        if (src.hasLowerLimit())
            tgt.setLowerLimit(src.getLowerLimit());
        if (src.hasUpperLimit())
            tgt.setUpperLimit(src.getUpperLimit());
        tgt.setDimensions(src.getDimensions());
        tgt.setData(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.dstu2016may.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        tgt.setWhen(src.getWhen());
        if (src.hasWhoUriType())
            tgt.setWho(new org.hl7.fhir.r4.model.Reference(src.getWhoUriType().getValue()));
        else
            tgt.setWho(convertReference(src.getWhoReference()));
        if (src.hasContentType())
            tgt.setSigFormat(src.getContentType());
        if (src.hasBlob())
            tgt.setData(src.getBlob());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Signature tgt = new org.hl7.fhir.dstu2016may.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        tgt.setWhen(src.getWhen());
        tgt.setWho(convertType(src.getWho()));
        if (src.hasSigFormat())
            tgt.setContentType(src.getSigFormat());
        if (src.hasData())
            tgt.setBlob(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Address convertAddress(org.hl7.fhir.dstu2016may.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Address tgt = new org.hl7.fhir.r4.model.Address();
        copyElement(src, tgt);
        tgt.setUse(convertAddressUse(src.getUse()));
        tgt.setType(convertAddressType(src.getType()));
        if (src.hasText())
            tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        if (src.hasCity())
            tgt.setCity(src.getCity());
        if (src.hasDistrict())
            tgt.setDistrict(src.getDistrict());
        if (src.hasState())
            tgt.setState(src.getState());
        if (src.hasPostalCode())
            tgt.setPostalCode(src.getPostalCode());
        if (src.hasCountry())
            tgt.setCountry(src.getCountry());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Address tgt = new org.hl7.fhir.dstu2016may.model.Address();
        copyElement(src, tgt);
        tgt.setUse(convertAddressUse(src.getUse()));
        tgt.setType(convertAddressType(src.getType()));
        if (src.hasText())
            tgt.setText(src.getText());
        for (org.hl7.fhir.r4.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        if (src.hasCity())
            tgt.setCity(src.getCity());
        if (src.hasDistrict())
            tgt.setDistrict(src.getDistrict());
        if (src.hasState())
            tgt.setState(src.getState());
        if (src.hasPostalCode())
            tgt.setPostalCode(src.getPostalCode());
        if (src.hasCountry())
            tgt.setCountry(src.getCountry());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Address.AddressUse convertAddressUse(org.hl7.fhir.dstu2016may.model.Address.AddressUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.r4.model.Address.AddressUse.HOME;
            case WORK:
                return org.hl7.fhir.r4.model.Address.AddressUse.WORK;
            case TEMP:
                return org.hl7.fhir.r4.model.Address.AddressUse.TEMP;
            case OLD:
                return org.hl7.fhir.r4.model.Address.AddressUse.OLD;
            default:
                return org.hl7.fhir.r4.model.Address.AddressUse.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Address.AddressUse convertAddressUse(org.hl7.fhir.r4.model.Address.AddressUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu2016may.model.Address.AddressUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu2016may.model.Address.AddressUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu2016may.model.Address.AddressUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu2016may.model.Address.AddressUse.OLD;
            default:
                return org.hl7.fhir.dstu2016may.model.Address.AddressUse.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Address.AddressType convertAddressType(org.hl7.fhir.dstu2016may.model.Address.AddressType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case POSTAL:
                return org.hl7.fhir.r4.model.Address.AddressType.POSTAL;
            case PHYSICAL:
                return org.hl7.fhir.r4.model.Address.AddressType.PHYSICAL;
            case BOTH:
                return org.hl7.fhir.r4.model.Address.AddressType.BOTH;
            default:
                return org.hl7.fhir.r4.model.Address.AddressType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Address.AddressType convertAddressType(org.hl7.fhir.r4.model.Address.AddressType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case POSTAL:
                return org.hl7.fhir.dstu2016may.model.Address.AddressType.POSTAL;
            case PHYSICAL:
                return org.hl7.fhir.dstu2016may.model.Address.AddressType.PHYSICAL;
            case BOTH:
                return org.hl7.fhir.dstu2016may.model.Address.AddressType.BOTH;
            default:
                return org.hl7.fhir.dstu2016may.model.Address.AddressType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactPoint tgt = new org.hl7.fhir.r4.model.ContactPoint();
        copyElement(src, tgt);
        tgt.setSystem(convertContactPointSystem(src.getSystem()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setUse(convertContactPointUse(src.getUse()));
        if (src.hasRank())
            tgt.setRank(src.getRank());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ContactPoint convertContactPoint(org.hl7.fhir.r4.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ContactPoint tgt = new org.hl7.fhir.dstu2016may.model.ContactPoint();
        copyElement(src, tgt);
        tgt.setSystem(convertContactPointSystem(src.getSystem()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setUse(convertContactPointUse(src.getUse()));
        if (src.hasRank())
            tgt.setRank(src.getRank());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHONE:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PHONE;
            case FAX:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.FAX;
            case EMAIL:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.EMAIL;
            case PAGER:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PAGER;
            case OTHER:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.URL;
            default:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHONE:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.PHONE;
            case FAX:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.FAX;
            case EMAIL:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.EMAIL;
            case PAGER:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.PAGER;
            case URL:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.OTHER;
            default:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.HOME;
            case WORK:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.WORK;
            case TEMP:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.TEMP;
            case OLD:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.OLD;
            case MOBILE:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.MOBILE;
            default:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.OLD;
            case MOBILE:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.MOBILE;
            default:
                return org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2016may.model.ElementDefinition src, List<org.hl7.fhir.dstu2016may.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        for (org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation()) copyElement(t, tgt.addRepresentationElement().setValue(convertPropertyRepresentation(t.getValue())));
        if (src.hasName())
            tgt.setSliceName(src.getName());
        if (src.hasLabel())
            tgt.setLabel(src.getLabel());
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
        if (src.hasShort())
            tgt.setShort(src.getShort());
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasComments())
            tgt.setComment(src.getComments());
        if (src.hasRequirements())
            tgt.setRequirements(src.getRequirements());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReference(src.getContentReference());
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent t : src.getType()) convertTypeRefComponent(t, tgt.getType());
        tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissing(src.getMeaningWhenMissing());
        tgt.setFixed(convertType(src.getFixed()));
        tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.addExample().setLabel("General").setValue(convertType(src.getExample()));
        tgt.setMinValue(convertType(src.getMinValue()));
        tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLength(src.getMaxLength());
        for (org.hl7.fhir.dstu2016may.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupport(src.getMustSupport());
        if (src.hasIsModifier())
            tgt.setIsModifier(src.getIsModifier());
        if (tgt.getIsModifier()) {
            String reason = org.hl7.fhir.dstu2016may.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
            if (Utilities.noString(reason))
                reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
            tgt.setIsModifierReason(reason);
        }
        if (src.hasIsSummary())
            tgt.setIsSummary(src.getIsSummary());
        tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation()) copyElement(t, tgt.addRepresentationElement().setValue(convertPropertyRepresentation(t.getValue())));
        if (src.hasSliceName())
            tgt.setName(src.getSliceName());
        if (src.hasLabel())
            tgt.setLabel(src.getLabel());
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        if (src.hasShort())
            tgt.setShort(src.getShort());
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasComment())
            tgt.setComments(src.getComment());
        if (src.hasRequirements())
            tgt.setRequirements(src.getRequirements());
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReference(src.getContentReference());
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType()) convertTypeRefComponent(t, tgt.getType());
        tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissing(src.getMeaningWhenMissing());
        tgt.setFixed(convertType(src.getFixed()));
        tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.setExample(convertType(src.getExample().get(0).getValue()));
        tgt.setMinValue(convertType(src.getMinValue()));
        tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLength(src.getMaxLength());
        for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupport(src.getMustSupport());
        if (src.hasIsModifier())
            tgt.setIsModifier(src.getIsModifier());
        if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
            org.hl7.fhir.dstu2016may.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
        if (src.hasIsSummary())
            tgt.setIsSummary(src.getIsSummary());
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XMLATTR:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR;
            case XMLTEXT:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLTEXT;
            case TYPEATTR:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.TYPEATTR;
            case CDATEXT:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.CDATEXT;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XMLATTR:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.XMLATTR;
            case XMLTEXT:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.XMLTEXT;
            case TYPEATTR:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.TYPEATTR;
            case CDATEXT:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.CDATEXT;
            default:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent src, List<org.hl7.fhir.dstu2016may.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        org.hl7.fhir.dstu2016may.model.ElementDefinition slicingElement = context.get(pos);
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getDiscriminator()) {
            boolean isExists = false;
            if (!t.asStringValue().contains("@")) {
                int slices = 0;
                boolean existsSlicePresent = false;
                boolean notExistsSlicePresent = false;
                String existsPath = slicingElement.getPath() + "." + t.asStringValue();
                for (int i = pos + 1; i < context.size(); i++) {
                    org.hl7.fhir.dstu2016may.model.ElementDefinition e = context.get(i);
                    if (e.getPath().equals(slicingElement.getPath()))
                        slices++;
                    else if (!e.getPath().startsWith(slicingElement.getPath() + "."))
                        break;
                    else if (e.getPath().equals(existsPath)) {
                        if (e.hasMin() && e.getMin() > 0 && !e.hasFixed())
                            existsSlicePresent = true;
                        else if (e.hasMax() && e.getMax().equals("0"))
                            notExistsSlicePresent = true;
                    }
                }
                isExists = (slices == 2 && existsSlicePresent && notExistsSlicePresent) || (slices == 1 && existsSlicePresent != notExistsSlicePresent);
            }
            tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue(), isExists));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasOrdered())
            tgt.setOrdered(src.getOrdered());
        tgt.setRules(convertSlicingRules(src.getRules()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasOrdered())
            tgt.setOrdered(src.getOrdered());
        tgt.setRules(convertSlicingRules(src.getRules()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLOSED:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.CLOSED;
            case OPEN:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPEN;
            case OPENATEND:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPENATEND;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLOSED:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.CLOSED;
            case OPEN:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.OPEN;
            case OPENATEND:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.OPENATEND;
            default:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        return tgt;
    }

    static public void convertTypeRefComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = null;
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : list) if (t.getCode().equals(src.getCode()))
            tgt = t;
        if (tgt == null) {
            tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
            list.add(tgt);
            copyElement(src, tgt);
            tgt.setCode(src.getCode());
        }
        if (tgt.hasTarget()) {
            for (org.hl7.fhir.dstu2016may.model.UriType u : src.getProfile()) {
                if (src.getCode().equals("Reference"))
                    tgt.addTargetProfile(u.getValue());
                else
                    tgt.addProfile(u.getValue());
            }
            for (org.hl7.fhir.dstu2016may.model.Extension t : src.getExtensionsByUrl(VersionConvertorConstants.PROFILE_EXTENSION)) {
                String s = ((org.hl7.fhir.dstu2016may.model.PrimitiveType<String>) t.getValue()).getValue();
                tgt.addProfile(s);
            }
        } else {
            for (org.hl7.fhir.dstu2016may.model.UriType u : src.getProfile()) tgt.addProfile(u.getValue());
        }
        for (org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
            org.hl7.fhir.r4.model.ElementDefinition.AggregationMode a = convertAggregationMode(t.getValue());
            if (!tgt.hasAggregation(a))
                copyElement(t, tgt.addAggregation(a));
        }
        if (src.hasVersioning())
            tgt.setVersioning(convertReferenceVersionRules(src.getVersioning()));
    }

    public static void convertTypeRefComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCode(src.getCode());
        list.add(tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.UriType u : src.getTargetProfile()) {
                tgt.addProfile(u.getValue());
                String baseName = u.getValue().toLowerCase();
                if (baseName.contains("reference") && !baseName.contains("documentreference"))
                    throw new Error("2016May Target profile contains the word 'reference':" + u);
            }
            for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
                if (src.getCode().equals("Reference")) {
                    org.hl7.fhir.dstu2016may.model.Extension t = new org.hl7.fhir.dstu2016may.model.Extension(VersionConvertorConstants.PROFILE_EXTENSION);
                    t.setValue(convertType(u));
                    tgt.addExtension(t);
                } else
                    tgt.addProfile(u.getValue());
            }
        } else {
            for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
                tgt.addProfile(u.getValue());
            }
        }
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
            org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode a = convertAggregationMode(t.getValue());
            if (!tgt.hasAggregation(a))
                copyElement(t, tgt.addAggregation(a));
        }
        if (src.hasVersioning())
            tgt.setVersioning(convertReferenceVersionRules(src.getVersioning()));
    }

    static public org.hl7.fhir.r4.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONTAINED:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.CONTAINED;
            case REFERENCED:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.REFERENCED;
            case BUNDLED:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.BUNDLED;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONTAINED:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.CONTAINED;
            case REFERENCED:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.REFERENCED;
            case BUNDLED:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.BUNDLED;
            default:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules convertReferenceVersionRules(org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EITHER:
                return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.EITHER;
            case INDEPENDENT:
                return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT;
            case SPECIFIC:
                return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.SPECIFIC;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules convertReferenceVersionRules(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EITHER:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.EITHER;
            case INDEPENDENT:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT;
            case SPECIFIC:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.SPECIFIC;
            default:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        tgt.setKey(src.getKey());
        if (src.hasRequirements())
            tgt.setRequirements(src.getRequirements());
        tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
        tgt.setHuman(src.getHuman());
        if (src.hasExpression())
            tgt.setExpression(convertToR4Expression(src.getExpression()));
        tgt.setXpath(src.getXpath());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        tgt.setKey(src.getKey());
        if (src.hasRequirements())
            tgt.setRequirements(src.getRequirements());
        tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
        tgt.setHuman(src.getHuman());
        if (src.hasExpression())
            tgt.setExpression(convertTo2016MayExpression(src.getExpression()));
        tgt.setXpath(src.getXpath());
        return tgt;
    }

    public static String convertToR4Expression(String oldExpression) {
        String pass1 = oldExpression.replaceAll("\\$context", "%context").replaceAll("\\$resource", "%resource").replaceAll("code\\+profile", "code&profile").replaceAll("path\\+'\\.'", "path&'.'").replaceAll("fullUrl\\+resource", "fullUrl&resource");
        String pass2 = pass1;
        if (pass1.endsWith(".distinct()"))
            pass2 = pass1.substring(0, pass2.length() - 11) + ".isDistinct()";
        String pass3 = pass2;
        if (pass2.endsWith(".empty() or (type.count() = 1)"))
            pass3 = pass2.substring(0, pass2.length() - 30) + ".empty() or (type.count() <= 1)";
        String pass4 = pass3;
        if (pass3.equals("duration >= 0"))
            pass4 = "duration.exists() implies duration >= 0";
        else if (pass3.equals("period >= 0"))
            pass4 = "period.exists() implies period >= 0";
        else if (pass3.equals("fullUrl.empty() xor resource"))
            pass4 = "fullUrl.empty() xor resource.exists()";
        return pass4;
    }

    public static String convertTo2016MayExpression(String newExpression) {
        String pass1 = newExpression.replaceAll("%context", "\\$context").replaceAll("%resource", "\\$resource").replaceAll("code&profile", "code+profile").replaceAll("path&'\\.'", "path+'.'").replaceAll("fullUrl%resource", "fullUrl+resource");
        String pass2 = pass1;
        if (pass1.endsWith(".isDistinct()"))
            pass2 = pass1.substring(0, pass1.length() - 13) + ".distinct()";
        String pass3 = pass2;
        if (pass2.endsWith(".empty() or (type.count() <= 1)"))
            pass3 = pass2.substring(0, pass2.length() - 31) + ".empty() or (type.count() = 1)";
        String pass4 = pass3;
        if (pass3.equals("duration.exists() implies duration >= 0"))
            pass4 = "duration >= 0";
        else if (pass3.equals("period.exists() implies period >= 0"))
            pass4 = "period >= 0";
        else if (pass3.equals("fullUrl.empty() xor resource.exists()"))
            pass4 = "fullUrl.empty() xor resource";
        return pass4;
    }

    static public org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ERROR:
                return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.WARNING;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ERROR:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity.WARNING;
            default:
                return org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        tgt.setStrength(convertBindingStrength(src.getStrength()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasValueSet()) {
            org.hl7.fhir.r4.model.Type t = convertType(src.getValueSet());
            if (t instanceof org.hl7.fhir.r4.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r4.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        tgt.setStrength(convertBindingStrength(src.getStrength()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED;
            case EXTENSIBLE:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE;
            case PREFERRED:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED;
            case EXAMPLE:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE;
            default:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.r4.model.Enumerations.BindingStrength src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.REQUIRED;
            case EXTENSIBLE:
                return org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXTENSIBLE;
            case PREFERRED:
                return org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.PREFERRED;
            case EXAMPLE:
                return org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXAMPLE;
            default:
                return org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
        tgt.setMap(src.getMap());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
        tgt.setMap(src.getMap());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.dstu2016may.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
        copyElement(src, tgt);
        tgt.setUse(convertNameUse(src.getUse()));
        if (src.hasText())
            tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.HumanName tgt = new org.hl7.fhir.dstu2016may.model.HumanName();
        copyElement(src, tgt);
        tgt.setUse(convertNameUse(src.getUse()));
        if (src.hasText())
            tgt.setText(src.getText());
        if (src.hasFamily())
            tgt.addFamily(src.getFamily());
        for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.HumanName.NameUse convertNameUse(org.hl7.fhir.dstu2016may.model.HumanName.NameUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.r4.model.HumanName.NameUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.r4.model.HumanName.NameUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.r4.model.HumanName.NameUse.TEMP;
            case NICKNAME:
                return org.hl7.fhir.r4.model.HumanName.NameUse.NICKNAME;
            case ANONYMOUS:
                return org.hl7.fhir.r4.model.HumanName.NameUse.ANONYMOUS;
            case OLD:
                return org.hl7.fhir.r4.model.HumanName.NameUse.OLD;
            case MAIDEN:
                return org.hl7.fhir.r4.model.HumanName.NameUse.MAIDEN;
            default:
                return org.hl7.fhir.r4.model.HumanName.NameUse.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.HumanName.NameUse convertNameUse(org.hl7.fhir.r4.model.HumanName.NameUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.TEMP;
            case NICKNAME:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NICKNAME;
            case ANONYMOUS:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.ANONYMOUS;
            case OLD:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.OLD;
            case MAIDEN:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.MAIDEN;
            default:
                return org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.dstu2016may.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionId(src.getVersionId());
        if (src.hasLastUpdated())
            tgt.setLastUpdated(src.getLastUpdated());
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Meta tgt = new org.hl7.fhir.dstu2016may.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionId(src.getVersionId());
        if (src.hasLastUpdated())
            tgt.setLastUpdated(src.getLastUpdated());
        for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing convertTiming(org.hl7.fhir.dstu2016may.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Timing tgt = new org.hl7.fhir.r4.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Timing convertTiming(org.hl7.fhir.r4.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Timing tgt = new org.hl7.fhir.dstu2016may.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        tgt.setBounds(convertType(src.getBounds()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasCountMax())
            tgt.setCountMax(src.getCountMax());
        if (src.hasDuration())
            tgt.setDuration(src.getDuration());
        if (src.hasDurationMax())
            tgt.setDurationMax(src.getDurationMax());
        tgt.setDurationUnit(convertUnitsOfTime(src.getDurationUnit()));
        if (src.hasFrequency())
            tgt.setFrequency(src.getFrequency());
        if (src.hasFrequencyMax())
            tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriod())
            tgt.setPeriod(src.getPeriod());
        if (src.hasPeriodMax())
            tgt.setPeriodMax(src.getPeriodMax());
        tgt.setPeriodUnit(convertUnitsOfTime(src.getPeriodUnit()));
        tgt.addWhen(convertEventTiming(src.getWhen()));
        if (src.hasOffset())
            tgt.setOffset(src.getOffset());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        tgt.setBounds(convertType(src.getBounds()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasCountMax())
            tgt.setCountMax(src.getCountMax());
        if (src.hasDuration())
            tgt.setDuration(src.getDuration());
        if (src.hasDurationMax())
            tgt.setDurationMax(src.getDurationMax());
        tgt.setDurationUnit(convertUnitsOfTime(src.getDurationUnit()));
        if (src.hasFrequency())
            tgt.setFrequency(src.getFrequency());
        if (src.hasFrequencyMax())
            tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriod())
            tgt.setPeriod(src.getPeriod());
        if (src.hasPeriodMax())
            tgt.setPeriodMax(src.getPeriodMax());
        tgt.setPeriodUnit(convertUnitsOfTime(src.getPeriodUnit()));
        for (Enumeration<EventTiming> t : src.getWhen()) tgt.setWhen(convertEventTiming(t.getValue()));
        if (src.hasOffset())
            tgt.setOffset(src.getOffset());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case S:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.S;
            case MIN:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.MIN;
            case H:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.H;
            case D:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.D;
            case WK:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.WK;
            case MO:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.MO;
            case A:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.A;
            default:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.r4.model.Timing.UnitsOfTime src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case S:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.S;
            case MIN:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.MIN;
            case H:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.H;
            case D:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.D;
            case WK:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.WK;
            case MO:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.MO;
            case A:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.A;
            default:
                return org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.dstu2016may.model.Timing.EventTiming src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HS:
                return org.hl7.fhir.r4.model.Timing.EventTiming.HS;
            case WAKE:
                return org.hl7.fhir.r4.model.Timing.EventTiming.WAKE;
            case C:
                return org.hl7.fhir.r4.model.Timing.EventTiming.C;
            case CM:
                return org.hl7.fhir.r4.model.Timing.EventTiming.CM;
            case CD:
                return org.hl7.fhir.r4.model.Timing.EventTiming.CD;
            case CV:
                return org.hl7.fhir.r4.model.Timing.EventTiming.CV;
            case AC:
                return org.hl7.fhir.r4.model.Timing.EventTiming.AC;
            case ACM:
                return org.hl7.fhir.r4.model.Timing.EventTiming.ACM;
            case ACD:
                return org.hl7.fhir.r4.model.Timing.EventTiming.ACD;
            case ACV:
                return org.hl7.fhir.r4.model.Timing.EventTiming.ACV;
            case PC:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PC;
            case PCM:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PCM;
            case PCD:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PCD;
            case PCV:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PCV;
            default:
                return org.hl7.fhir.r4.model.Timing.EventTiming.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.r4.model.Timing.EventTiming src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HS:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.HS;
            case WAKE:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.WAKE;
            case C:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.C;
            case CM:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CM;
            case CD:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CD;
            case CV:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CV;
            case AC:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.AC;
            case ACM:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACM;
            case ACD:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACD;
            case ACV:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACV;
            case PC:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PC;
            case PCM:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCM;
            case PCD:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCD;
            case PCV:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCV;
            default:
                return org.hl7.fhir.dstu2016may.model.Timing.EventTiming.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu2016may.model.SimpleQuantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SimpleQuantity tgt = new org.hl7.fhir.r4.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2016may.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        if (src.hasUnit())
            tgt.setUnit(src.getUnit());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2016may.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.dstu2016may.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.BooleanType)
            return convertBoolean((org.hl7.fhir.dstu2016may.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.CodeType)
            return convertCode((org.hl7.fhir.dstu2016may.model.CodeType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.DateType)
            return convertDate((org.hl7.fhir.dstu2016may.model.DateType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.dstu2016may.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.DecimalType)
            return convertDecimal((org.hl7.fhir.dstu2016may.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.IdType)
            return convertId((org.hl7.fhir.dstu2016may.model.IdType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.InstantType)
            return convertInstant((org.hl7.fhir.dstu2016may.model.InstantType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.IntegerType)
            return convertInteger((org.hl7.fhir.dstu2016may.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.dstu2016may.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.OidType)
            return convertOid((org.hl7.fhir.dstu2016may.model.OidType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.dstu2016may.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.StringType)
            return convertString((org.hl7.fhir.dstu2016may.model.StringType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.TimeType)
            return convertTime((org.hl7.fhir.dstu2016may.model.TimeType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.dstu2016may.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.UriType)
            return convertUri((org.hl7.fhir.dstu2016may.model.UriType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.UuidType)
            return convertUuid((org.hl7.fhir.dstu2016may.model.UuidType) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Extension)
            return convertExtension((org.hl7.fhir.dstu2016may.model.Extension) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Narrative)
            return convertNarrative((org.hl7.fhir.dstu2016may.model.Narrative) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Age)
            return convertAge((org.hl7.fhir.dstu2016may.model.Age) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Annotation)
            return convertAnnotation((org.hl7.fhir.dstu2016may.model.Annotation) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Attachment)
            return convertAttachment((org.hl7.fhir.dstu2016may.model.Attachment) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.dstu2016may.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Coding)
            return convertCoding((org.hl7.fhir.dstu2016may.model.Coding) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Count)
            return convertCount((org.hl7.fhir.dstu2016may.model.Count) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Distance)
            return convertDistance((org.hl7.fhir.dstu2016may.model.Distance) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Duration)
            return convertDuration((org.hl7.fhir.dstu2016may.model.Duration) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Identifier)
            return convertIdentifier((org.hl7.fhir.dstu2016may.model.Identifier) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Money)
            return convertMoney((org.hl7.fhir.dstu2016may.model.Money) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Period)
            return convertPeriod((org.hl7.fhir.dstu2016may.model.Period) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Quantity)
            return convertQuantity((org.hl7.fhir.dstu2016may.model.Quantity) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Range)
            return convertRange((org.hl7.fhir.dstu2016may.model.Range) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Ratio)
            return convertRatio((org.hl7.fhir.dstu2016may.model.Ratio) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Reference)
            return convertReference((org.hl7.fhir.dstu2016may.model.Reference) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.SampledData)
            return convertSampledData((org.hl7.fhir.dstu2016may.model.SampledData) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Signature)
            return convertSignature((org.hl7.fhir.dstu2016may.model.Signature) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Address)
            return convertAddress((org.hl7.fhir.dstu2016may.model.Address) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.dstu2016may.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.HumanName)
            return convertHumanName((org.hl7.fhir.dstu2016may.model.HumanName) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Meta)
            return convertMeta((org.hl7.fhir.dstu2016may.model.Meta) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Timing)
            return convertTiming((org.hl7.fhir.dstu2016may.model.Timing) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2016may.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.r4.model.BooleanType)
            return convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
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
        if (src instanceof org.hl7.fhir.r4.model.UriType)
            return convertUri((org.hl7.fhir.r4.model.UriType) src);
        if (src instanceof org.hl7.fhir.r4.model.UuidType)
            return convertUuid((org.hl7.fhir.r4.model.UuidType) src);
        if (src instanceof org.hl7.fhir.r4.model.Extension)
            return convertExtension((org.hl7.fhir.r4.model.Extension) src);
        if (src instanceof org.hl7.fhir.r4.model.Narrative)
            return convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
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
        if (src instanceof org.hl7.fhir.r4.model.Count)
            return convertCount((org.hl7.fhir.r4.model.Count) src);
        if (src instanceof org.hl7.fhir.r4.model.Distance)
            return convertDistance((org.hl7.fhir.r4.model.Distance) src);
        if (src instanceof org.hl7.fhir.r4.model.Duration)
            return convertDuration((org.hl7.fhir.r4.model.Duration) src);
        if (src instanceof org.hl7.fhir.r4.model.Identifier)
            return convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
        if (src instanceof org.hl7.fhir.r4.model.Money)
            return convertMoney((org.hl7.fhir.r4.model.Money) src);
        if (src instanceof org.hl7.fhir.r4.model.Period)
            return convertPeriod((org.hl7.fhir.r4.model.Period) src);
        if (src instanceof org.hl7.fhir.r4.model.Quantity)
            return convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
        if (src instanceof org.hl7.fhir.r4.model.Range)
            return convertRange((org.hl7.fhir.r4.model.Range) src);
        if (src instanceof org.hl7.fhir.r4.model.Ratio)
            return convertRatio((org.hl7.fhir.r4.model.Ratio) src);
        if (src instanceof org.hl7.fhir.r4.model.Reference)
            return convertReference((org.hl7.fhir.r4.model.Reference) src);
        if (src instanceof org.hl7.fhir.r4.model.SampledData)
            return convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
        if (src instanceof org.hl7.fhir.r4.model.Signature)
            return convertSignature((org.hl7.fhir.r4.model.Signature) src);
        if (src instanceof org.hl7.fhir.r4.model.Address)
            return convertAddress((org.hl7.fhir.r4.model.Address) src);
        if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.r4.model.HumanName)
            return convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
        if (src instanceof org.hl7.fhir.r4.model.Meta)
            return convertMeta((org.hl7.fhir.r4.model.Meta) src);
        if (src instanceof org.hl7.fhir.r4.model.Timing)
            return convertTiming((org.hl7.fhir.r4.model.Timing) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
        boolean ok = false;
        for (String s : extensionsToIgnore) if (s.equals(url))
            ok = true;
        return ok;
    }

    static public void copyDomainResource(org.hl7.fhir.dstu2016may.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.dstu2016may.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.dstu2016may.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.dstu2016may.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    static public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2016may.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r4.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    static public void copyResource(org.hl7.fhir.dstu2016may.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
    }

    static public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
    }

    public static org.hl7.fhir.r4.model.Binary convertBinary(org.hl7.fhir.dstu2016may.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Binary tgt = new org.hl7.fhir.r4.model.Binary();
        copyResource(src, tgt);
        tgt.setContentType(src.getContentType());
        tgt.setContent(src.getContent());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Binary convertBinary(org.hl7.fhir.r4.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Binary tgt = new org.hl7.fhir.dstu2016may.model.Binary();
        copyResource(src, tgt);
        tgt.setContentType(src.getContentType());
        tgt.setContent(src.getContent());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Enumerations.PublicationStatus convertConformanceResourceStatus(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED;
            default:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus convertConformanceResourceStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.NULL;
        }
    }

    static public boolean isJurisdiction(CodeableConcept t) {
        return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
    }

    public static org.hl7.fhir.r4.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2016may.model.CodeableConcept t) throws FHIRException {
        org.hl7.fhir.r4.model.UsageContext result = new org.hl7.fhir.r4.model.UsageContext();
        result.setValue(convertCodeableConcept(t));
        return result;
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

        public org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent comp;
    }

    static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
        CanonicalType dst = new CanonicalType(src.getReference());
        copyElement(src, dst);
        return dst;
    }

    static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
        Reference dst = new Reference(src.getValue());
        copyElement(src, dst);
        return dst;
    }

    public static org.hl7.fhir.r4.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NUMBER:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.NUMBER;
            case DATE:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.DATE;
            case STRING:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.STRING;
            case TOKEN:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.TOKEN;
            case REFERENCE:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.REFERENCE;
            case COMPOSITE:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.COMPOSITE;
            case QUANTITY:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.QUANTITY;
            case URI:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.URI;
            default:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.r4.model.Enumerations.SearchParamType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NUMBER:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NUMBER;
            case DATE:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.DATE;
            case STRING:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.STRING;
            case TOKEN:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.TOKEN;
            case REFERENCE:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.REFERENCE;
            case COMPOSITE:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.COMPOSITE;
            case QUANTITY:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.QUANTITY;
            case URI:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.URI;
            default:
                return org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode convertConformanceEventMode(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.RECEIVER;
            default:
                return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode convertConformanceEventMode(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.RECEIVER;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.NULL;
        }
    }

    /*  public static org.hl7.fhir.r4.model.VisionPrescription convertVisionPrescription(org.hl7.fhir.dstu2016may.model.VisionPrescription src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.VisionPrescription tgt = new org.hl7.fhir.r4.model.VisionPrescription();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    tgt.setDateWritten(src.getDateWritten());
    tgt.setPatient(convertReference(src.getPatient()));
    tgt.setPrescriber(convertReference(src.getPrescriber()));
    tgt.setEncounter(convertReference(src.getEncounter()));
    tgt.setReason(convertType(src.getReason()));
    for (org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionPrescriptionDispenseComponent t : src.getDispense())
      tgt.addDispense(convertVisionPrescriptionDispenseComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.VisionPrescription convertVisionPrescription(org.hl7.fhir.r4.model.VisionPrescription src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.VisionPrescription tgt = new org.hl7.fhir.dstu2016may.model.VisionPrescription();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    tgt.setDateWritten(src.getDateWritten());
    tgt.setPatient(convertReference(src.getPatient()));
    tgt.setPrescriber(convertReference(src.getPrescriber()));
    tgt.setEncounter(convertReference(src.getEncounter()));
    tgt.setReason(convertType(src.getReason()));
    for (org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionDispenseComponent t : src.getDispense())
      tgt.addDispense(convertVisionPrescriptionDispenseComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionDispenseComponent convertVisionPrescriptionDispenseComponent(org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionPrescriptionDispenseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionDispenseComponent tgt = new org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionDispenseComponent();
    copyElement(src, tgt);
    tgt.setProduct(convertCoding(src.getProduct()));
    tgt.setEye(convertVisionEyes(src.getEye()));
    tgt.setSphere(src.getSphere());
    tgt.setCylinder(src.getCylinder());
    tgt.setAxis(src.getAxis());
    tgt.setPrism(src.getPrism());
    tgt.setBase(convertVisionBase(src.getBase()));
    tgt.setAdd(src.getAdd());
    tgt.setPower(src.getPower());
    tgt.setBackCurve(src.getBackCurve());
    tgt.setDiameter(src.getDiameter());
    tgt.setDuration(convertSimpleQuantity(src.getDuration()));
    tgt.setColor(src.getColor());
    tgt.setBrand(src.getBrand());
    tgt.setNotes(src.getNotes());
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionPrescriptionDispenseComponent convertVisionPrescriptionDispenseComponent(org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionDispenseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionPrescriptionDispenseComponent tgt = new org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionPrescriptionDispenseComponent();
    copyElement(src, tgt);
    tgt.setProduct(convertCoding(src.getProduct()));
    tgt.setEye(convertVisionEyes(src.getEye()));
    tgt.setSphere(src.getSphere());
    tgt.setCylinder(src.getCylinder());
    tgt.setAxis(src.getAxis());
    tgt.setPrism(src.getPrism());
    tgt.setBase(convertVisionBase(src.getBase()));
    tgt.setAdd(src.getAdd());
    tgt.setPower(src.getPower());
    tgt.setBackCurve(src.getBackCurve());
    tgt.setDiameter(src.getDiameter());
    tgt.setDuration(convertSimpleQuantity(src.getDuration()));
    tgt.setColor(src.getColor());
    tgt.setBrand(src.getBrand());
    tgt.setNotes(src.getNotes());
    return tgt;
  }

  private static org.hl7.fhir.r4.model.VisionPrescription.VisionEyes convertVisionEyes(org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionEyes src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case RIGHT: return org.hl7.fhir.r4.model.VisionPrescription.VisionEyes.RIGHT;
    case LEFT: return org.hl7.fhir.r4.model.VisionPrescription.VisionEyes.LEFT;
    default: return org.hl7.fhir.r4.model.VisionPrescription.VisionEyes.NULL;
    }
  }

  private static org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionEyes convertVisionEyes(org.hl7.fhir.r4.model.VisionPrescription.VisionEyes src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case RIGHT: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionEyes.RIGHT;
    case LEFT: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionEyes.LEFT;
    default: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionEyes.NULL;
    }
  }

  private static org.hl7.fhir.r4.model.VisionPrescription.VisionBase convertVisionBase(org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case UP: return org.hl7.fhir.r4.model.VisionPrescription.VisionBase.UP;
    case DOWN: return org.hl7.fhir.r4.model.VisionPrescription.VisionBase.DOWN;
    case IN: return org.hl7.fhir.r4.model.VisionPrescription.VisionBase.IN;
    case OUT: return org.hl7.fhir.r4.model.VisionPrescription.VisionBase.OUT;
    default: return org.hl7.fhir.r4.model.VisionPrescription.VisionBase.NULL;
    }
  }

  private static org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase convertVisionBase(org.hl7.fhir.r4.model.VisionPrescription.VisionBase src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case UP: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase.UP;
    case DOWN: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase.DOWN;
    case IN: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase.IN;
    case OUT: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase.OUT;
    default: return org.hl7.fhir.dstu2016may.model.VisionPrescription.VisionBase.NULL;
    }
  }
*/
    public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2016may.model.Parameters)
            return Parameters14_40.convertParameters((org.hl7.fhir.dstu2016may.model.Parameters) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Bundle)
            return Bundle14_40.convertBundle((org.hl7.fhir.dstu2016may.model.Bundle) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.CodeSystem)
            return CodeSystem14_40.convertCodeSystem((org.hl7.fhir.dstu2016may.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.CompartmentDefinition)
            return CompartmentDefinition14_40.convertCompartmentDefinition((org.hl7.fhir.dstu2016may.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ConceptMap)
            return ConceptMap14_40.convertConceptMap((org.hl7.fhir.dstu2016may.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Conformance)
            return Conformance14_40.convertConformance((org.hl7.fhir.dstu2016may.model.Conformance) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.DataElement)
            return DataElement14_40.convertDataElement((org.hl7.fhir.dstu2016may.model.DataElement) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ImplementationGuide)
            return ImplementationGuide14_40.convertImplementationGuide((org.hl7.fhir.dstu2016may.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.NamingSystem)
            return NamingSystem14_40.convertNamingSystem((org.hl7.fhir.dstu2016may.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.OperationDefinition)
            return OperationDefinition14_40.convertOperationDefinition((org.hl7.fhir.dstu2016may.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.OperationOutcome)
            return OperationOutcome14_40.convertOperationOutcome((org.hl7.fhir.dstu2016may.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Questionnaire)
            return Questionnaire14_40.convertQuestionnaire((org.hl7.fhir.dstu2016may.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.QuestionnaireResponse)
            return QuestionnaireResponse14_40.convertQuestionnaireResponse((org.hl7.fhir.dstu2016may.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.SearchParameter)
            return SearchParameter14_40.convertSearchParameter((org.hl7.fhir.dstu2016may.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.StructureDefinition)
            return StructureDefinition14_40.convertStructureDefinition((org.hl7.fhir.dstu2016may.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.StructureMap)
            return StructureMap14_40.convertStructureMap((org.hl7.fhir.dstu2016may.model.StructureMap) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ValueSet)
            return ValueSet14_40.convertValueSet((org.hl7.fhir.dstu2016may.model.ValueSet) src);
        /*    if (src instanceof org.hl7.fhir.dstu2016may.model.VisionPrescription)
      return convertVisionPrescription((org.hl7.fhir.dstu2016may.model.VisionPrescription) src);*/
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r4.model.Parameters)
            return Parameters14_40.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
        if (src instanceof org.hl7.fhir.r4.model.Bundle)
            return Bundle14_40.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
        if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
            return CodeSystem14_40.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
            return CompartmentDefinition14_40.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
            return ConceptMap14_40.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
            return Conformance14_40.convertConformance((org.hl7.fhir.r4.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
            return ImplementationGuide14_40.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
            return NamingSystem14_40.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
            return OperationDefinition14_40.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
            return OperationOutcome14_40.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
            return Questionnaire14_40.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
            return QuestionnaireResponse14_40.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
            return SearchParameter14_40.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
            return StructureDefinition14_40.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.StructureMap)
            return StructureMap14_40.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
        if (src instanceof org.hl7.fhir.r4.model.ValueSet)
            return ValueSet14_40.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
        /*    if (src instanceof org.hl7.fhir.r4.model.VisionPrescription)
      return convertVisionPrescription((org.hl7.fhir.r4.model.VisionPrescription) src);*/
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static boolean convertsResource(String rt) {
        return Utilities.existsInList(rt, "Parameters", "Bundle", "CodeSystem", "CompartmentDefinition", "ConceptMap", "CapabilityStatement", "ImplementationGuide", "NamingSystem", "OperationDefinition", "OperationOutcome", "Questionnaire", "QuestionnaireResponse", "SearchParameter", "StructureDefinition", "StructureMap", "ValueSet");
    }
}
