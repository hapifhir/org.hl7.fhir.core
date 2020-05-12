package org.hl7.fhir.convertors;

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
import org.hl7.fhir.convertors.conv14_50.Bundle14_50;
import org.hl7.fhir.convertors.conv14_50.CodeSystem14_50;
import org.hl7.fhir.convertors.conv14_50.CompartmentDefinition14_50;
import org.hl7.fhir.convertors.conv14_50.ConceptMap14_50;
import org.hl7.fhir.convertors.conv14_50.Conformance14_50;
import org.hl7.fhir.convertors.conv14_50.DataElement14_50;
import org.hl7.fhir.convertors.conv14_50.ImplementationGuide14_50;
import org.hl7.fhir.convertors.conv14_50.NamingSystem14_50;
import org.hl7.fhir.convertors.conv14_50.OperationDefinition14_50;
import org.hl7.fhir.convertors.conv14_50.OperationOutcome14_50;
import org.hl7.fhir.convertors.conv14_50.Parameters14_50;
import org.hl7.fhir.convertors.conv14_50.Questionnaire14_50;
import org.hl7.fhir.convertors.conv14_50.QuestionnaireResponse14_50;
import org.hl7.fhir.convertors.conv14_50.SearchParameter14_50;
import org.hl7.fhir.convertors.conv14_50.StructureDefinition14_50;
import org.hl7.fhir.convertors.conv14_50.StructureMap14_50;
import org.hl7.fhir.convertors.conv14_50.ValueSet14_50;
import org.hl7.fhir.dstu2016may.model.CodeableConcept;
import org.hl7.fhir.dstu2016may.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.ProfileUtilities;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Timing.EventTiming;
import org.hl7.fhir.utilities.Utilities;

public class VersionConvertor_14_50 {

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

    static public boolean mappedExtension(String url) {
        if (url.equals(VersionConvertorConstants.PROFILE_EXTENSION) || url.equals(VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION) || url.equals(VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION) || url.equals(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT))
            return true;
        return false;
    }

    static public void copyElement(org.hl7.fhir.dstu2016may.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... exemptExtensions) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        for (org.hl7.fhir.dstu2016may.model.Extension e : src.getExtension()) {
            if (!Utilities.existsInList(e.getUrl(), exemptExtensions) && !mappedExtension(e.getUrl().toString()))
                tgt.addExtension(convertExtension(e));
        }
    }

    static public void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.dstu2016may.model.Element tgt, String... exemptExtensions) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
            if (!Utilities.existsInList(e.getUrl(), exemptExtensions)) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    static public void copyBackboneElement(org.hl7.fhir.dstu2016may.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    static public void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.dstu2016may.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2016may.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r5.model.Base64BinaryType tgt = new org.hl7.fhir.r5.model.Base64BinaryType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.Base64BinaryType tgt = new org.hl7.fhir.dstu2016may.model.Base64BinaryType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.dstu2016may.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r5.model.BooleanType tgt = new org.hl7.fhir.r5.model.BooleanType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.BooleanType tgt = new org.hl7.fhir.dstu2016may.model.BooleanType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.dstu2016may.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r5.model.CodeType tgt = new org.hl7.fhir.r5.model.CodeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.CodeType tgt = new org.hl7.fhir.dstu2016may.model.CodeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.dstu2016may.model.DateType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateType tgt = new org.hl7.fhir.r5.model.DateType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.DateType tgt = new org.hl7.fhir.dstu2016may.model.DateType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2016may.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateTimeType tgt = new org.hl7.fhir.r5.model.DateTimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DateTimeType convertDateTime(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.DateTimeType tgt = new org.hl7.fhir.dstu2016may.model.DateTimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.dstu2016may.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r5.model.DecimalType tgt = new org.hl7.fhir.r5.model.DecimalType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.DecimalType tgt = new org.hl7.fhir.dstu2016may.model.DecimalType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.dstu2016may.model.IdType src) throws FHIRException {
        org.hl7.fhir.r5.model.IdType tgt = new org.hl7.fhir.r5.model.IdType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.IdType tgt = new org.hl7.fhir.dstu2016may.model.IdType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.dstu2016may.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r5.model.InstantType tgt = new org.hl7.fhir.r5.model.InstantType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.InstantType tgt = new org.hl7.fhir.dstu2016may.model.InstantType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.dstu2016may.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r5.model.IntegerType tgt = new org.hl7.fhir.r5.model.IntegerType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.IntegerType tgt = new org.hl7.fhir.dstu2016may.model.IntegerType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2016may.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r5.model.MarkdownType tgt = new org.hl7.fhir.r5.model.MarkdownType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.MarkdownType tgt = new org.hl7.fhir.dstu2016may.model.MarkdownType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.dstu2016may.model.OidType src) throws FHIRException {
        org.hl7.fhir.r5.model.OidType tgt = new org.hl7.fhir.r5.model.OidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.OidType tgt = new org.hl7.fhir.dstu2016may.model.OidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2016may.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.PositiveIntType tgt = new org.hl7.fhir.r5.model.PositiveIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.PositiveIntType tgt = new org.hl7.fhir.dstu2016may.model.PositiveIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.dstu2016may.model.StringType src) throws FHIRException {
        org.hl7.fhir.r5.model.StringType tgt = new org.hl7.fhir.r5.model.StringType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.StringType tgt = new org.hl7.fhir.dstu2016may.model.StringType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.dstu2016may.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r5.model.TimeType tgt = new org.hl7.fhir.r5.model.TimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.TimeType tgt = new org.hl7.fhir.dstu2016may.model.TimeType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2016may.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.UnsignedIntType tgt = new org.hl7.fhir.r5.model.UnsignedIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.UnsignedIntType tgt = new org.hl7.fhir.dstu2016may.model.UnsignedIntType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
        org.hl7.fhir.r5.model.UriType tgt = new org.hl7.fhir.r5.model.UriType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.UriType tgt = new org.hl7.fhir.dstu2016may.model.UriType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.dstu2016may.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r5.model.UuidType tgt = new org.hl7.fhir.r5.model.UuidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu2016may.model.UuidType tgt = new org.hl7.fhir.dstu2016may.model.UuidType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Extension convertExtension(org.hl7.fhir.dstu2016may.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
        copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2016may.model.Reference)
                tgt.setValue(convertReferenceToCanonical((Reference) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Extension convertExtension(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Extension tgt = new org.hl7.fhir.dstu2016may.model.Extension();
        copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r5.model.CanonicalType)
                tgt.setValue(convertCanonicalToReference((CanonicalType) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Narrative convertNarrative(org.hl7.fhir.dstu2016may.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Narrative tgt = new org.hl7.fhir.r5.model.Narrative();
        copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        if (src.hasDiv())
            tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Narrative convertNarrative(org.hl7.fhir.r5.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Narrative tgt = new org.hl7.fhir.dstu2016may.model.Narrative();
        copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        if (src.hasDiv())
            tgt.setDiv(src.getDiv());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Age convertAge(org.hl7.fhir.dstu2016may.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Age tgt = new org.hl7.fhir.r5.model.Age();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Age convertAge(org.hl7.fhir.r5.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Age tgt = new org.hl7.fhir.dstu2016may.model.Age();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Annotation convertAnnotation(org.hl7.fhir.dstu2016may.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Annotation tgt = new org.hl7.fhir.r5.model.Annotation();
        copyElement(src, tgt);
        if (src.hasAuthor())
            tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTime())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Annotation convertAnnotation(org.hl7.fhir.r5.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Annotation tgt = new org.hl7.fhir.dstu2016may.model.Annotation();
        copyElement(src, tgt);
        if (src.hasAuthor())
            tgt.setAuthor(convertType(src.getAuthor()));
        if (src.hasTime())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Attachment convertAttachment(org.hl7.fhir.dstu2016may.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
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
            tgt.setUrl(src.getUrl());
        if (src.hasSize())
            tgt.setSize(Long.valueOf(src.getSize()));
        if (src.hasHash())
            tgt.setHashElement(convertBase64Binary(src.getHashElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCreation())
            tgt.setCreationElement(convertDateTime(src.getCreationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Attachment convertAttachment(org.hl7.fhir.r5.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Attachment tgt = new org.hl7.fhir.dstu2016may.model.Attachment();
        copyElement(src, tgt);
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasData())
            tgt.setDataElement(convertBase64Binary(src.getDataElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasSize())
            tgt.setSize(Math.toIntExact(src.getSize()));
        if (src.hasHash())
            tgt.setHashElement(convertBase64Binary(src.getHashElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCreation())
            tgt.setCreationElement(convertDateTime(src.getCreationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2016may.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeableConcept tgt = new org.hl7.fhir.dstu2016may.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coding convertCoding(org.hl7.fhir.dstu2016may.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
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

    public static org.hl7.fhir.dstu2016may.model.Coding convertCoding(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Coding tgt = new org.hl7.fhir.dstu2016may.model.Coding();
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

    public static org.hl7.fhir.r5.model.Count convertCount(org.hl7.fhir.dstu2016may.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Count tgt = new org.hl7.fhir.r5.model.Count();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Count convertCount(org.hl7.fhir.r5.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Count tgt = new org.hl7.fhir.dstu2016may.model.Count();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Distance convertDistance(org.hl7.fhir.dstu2016may.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Distance tgt = new org.hl7.fhir.r5.model.Distance();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Distance convertDistance(org.hl7.fhir.r5.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Distance tgt = new org.hl7.fhir.dstu2016may.model.Distance();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Duration convertDuration(org.hl7.fhir.dstu2016may.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Duration tgt = new org.hl7.fhir.r5.model.Duration();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Duration convertDuration(org.hl7.fhir.r5.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Duration tgt = new org.hl7.fhir.dstu2016may.model.Duration();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Money convertMoney(org.hl7.fhir.dstu2016may.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Money tgt = new org.hl7.fhir.r5.model.Money();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasCode())
            tgt.setCurrencyElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Money convertMoney(org.hl7.fhir.r5.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Money tgt = new org.hl7.fhir.dstu2016may.model.Money();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasCurrency())
            tgt.setCodeElement(convertCode(src.getCurrencyElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.dstu2016may.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Identifier tgt = new org.hl7.fhir.r5.model.Identifier();
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

    public static org.hl7.fhir.dstu2016may.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Identifier tgt = new org.hl7.fhir.dstu2016may.model.Identifier();
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.SECONDARY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.SECONDARY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Period convertPeriod(org.hl7.fhir.dstu2016may.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Period tgt = new org.hl7.fhir.r5.model.Period();
        copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(convertDateTime(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertDateTime(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Period convertPeriod(org.hl7.fhir.r5.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Period tgt = new org.hl7.fhir.dstu2016may.model.Period();
        copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(convertDateTime(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertDateTime(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Quantity convertQuantity(org.hl7.fhir.dstu2016may.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Quantity convertQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Quantity tgt = new org.hl7.fhir.dstu2016may.model.Quantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparatorEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Quantity.QuantityComparator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Range convertRange(org.hl7.fhir.dstu2016may.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Range tgt = new org.hl7.fhir.r5.model.Range();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Range convertRange(org.hl7.fhir.r5.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Range tgt = new org.hl7.fhir.dstu2016may.model.Range();
        copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Ratio convertRatio(org.hl7.fhir.dstu2016may.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Ratio tgt = new org.hl7.fhir.r5.model.Ratio();
        copyElement(src, tgt);
        if (src.hasNumerator())
            tgt.setNumerator(convertQuantity(src.getNumerator()));
        if (src.hasDenominator())
            tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Ratio convertRatio(org.hl7.fhir.r5.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Ratio tgt = new org.hl7.fhir.dstu2016may.model.Ratio();
        copyElement(src, tgt);
        if (src.hasNumerator())
            tgt.setNumerator(convertQuantity(src.getNumerator()));
        if (src.hasDenominator())
            tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.dstu2016may.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(src.getReference());
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Reference tgt = new org.hl7.fhir.dstu2016may.model.Reference();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(src.getReference());
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.dstu2016may.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
        copyElement(src, tgt);
        if (src.hasOrigin())
            tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        if (src.hasPeriodElement())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasLowerLimit())
            tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
        if (src.hasUpperLimit())
            tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
        if (src.hasDimensionsElement())
            tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
        if (src.hasDataElement())
            tgt.setDataElement(convertString(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SampledData tgt = new org.hl7.fhir.dstu2016may.model.SampledData();
        copyElement(src, tgt);
        if (src.hasOrigin())
            tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        if (src.hasPeriodElement())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasLowerLimit())
            tgt.setLowerLimitElement(convertDecimal(src.getLowerLimitElement()));
        if (src.hasUpperLimit())
            tgt.setUpperLimitElement(convertDecimal(src.getUpperLimitElement()));
        if (src.hasDimensionsElement())
            tgt.setDimensionsElement(convertPositiveInt(src.getDimensionsElement()));
        if (src.hasDataElement())
            tgt.setDataElement(convertString(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Signature convertSignature(org.hl7.fhir.dstu2016may.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Signature tgt = new org.hl7.fhir.r5.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        if (src.hasWhenElement())
            tgt.setWhenElement(convertInstant(src.getWhenElement()));
        if (src.hasWhoUriType())
            tgt.setWho(new org.hl7.fhir.r5.model.Reference(src.getWhoUriType().getValue()));
        else
            tgt.setWho(convertReference(src.getWhoReference()));
        if (src.hasContentType())
            tgt.setSigFormatElement(convertCode(src.getContentTypeElement()));
        if (src.hasBlob())
            tgt.setDataElement(convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Signature convertSignature(org.hl7.fhir.r5.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Signature tgt = new org.hl7.fhir.dstu2016may.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        if (src.hasWhenElement())
            tgt.setWhenElement(convertInstant(src.getWhenElement()));
        if (src.hasWho())
            tgt.setWho(convertType(src.getWho()));
        if (src.hasSigFormat())
            tgt.setContentTypeElement(convertCode(src.getSigFormatElement()));
        if (src.hasData())
            tgt.setBlobElement(convertBase64Binary(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Address convertAddress(org.hl7.fhir.dstu2016may.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Address tgt = new org.hl7.fhir.r5.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
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

    public static org.hl7.fhir.dstu2016may.model.Address convertAddress(org.hl7.fhir.r5.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Address tgt = new org.hl7.fhir.dstu2016may.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Address.AddressUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Address.AddressUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> convertAddressType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Address.AddressType> convertAddressType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Address.AddressType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Address.AddressTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2016may.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactPoint tgt = new org.hl7.fhir.r5.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasUse())
            tgt.setUseElement(convertContactPointUse(src.getUseElement()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ContactPoint tgt = new org.hl7.fhir.dstu2016may.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(convertContactPointSystem(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasUse())
            tgt.setUseElement(convertContactPointUse(src.getUseElement()));
        if (src.hasRank())
            tgt.setRankElement(convertPositiveInt(src.getRankElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.URL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2016may.model.ElementDefinition src, List<org.hl7.fhir.dstu2016may.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ElementDefinition tgt = new org.hl7.fhir.r5.model.ElementDefinition();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_14_50::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasName())
            tgt.setSliceNameElement(convertString(src.getNameElement()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
        if (src.hasShort())
            tgt.setShortElement(convertString(src.getShortElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
        if (src.hasComments())
            tgt.setCommentElement(convertMarkdown(src.getCommentsElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent t : src.getType()) convertTypeRefComponent(t, tgt.getType());
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
        for (org.hl7.fhir.dstu2016may.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
        if (src.hasIsModifier())
            tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
        if (tgt.getIsModifier()) {
            String reason = org.hl7.fhir.dstu2016may.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
            if (Utilities.noString(reason))
                reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
            tgt.setIsModifierReason(reason);
        }
        if (src.hasIsSummary())
            tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_14_50::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasSliceName())
            tgt.setNameElement(convertString(src.getSliceNameElement()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        if (src.hasShort())
            tgt.setShortElement(convertString(src.getShortElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(convertMarkdown(src.getDefinitionElement()));
        if (src.hasComment())
            tgt.setCommentsElement(convertMarkdown(src.getCommentElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
        for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType()) convertTypeRefComponent(t, tgt.getType());
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissingElement(convertMarkdown(src.getMeaningWhenMissingElement()));
        if (src.hasFixed())
            tgt.setFixed(convertType(src.getFixed()));
        if (src.hasPattern())
            tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.setExample(convertType(src.getExample().get(0).getValue()));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.r5.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupportElement(convertBoolean(src.getMustSupportElement()));
        if (src.hasIsModifier())
            tgt.setIsModifierElement(convertBoolean(src.getIsModifierElement()));
        if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
            org.hl7.fhir.dstu2016may.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
        if (src.hasIsSummary())
            tgt.setIsSummaryElement(convertBoolean(src.getIsSummaryElement()));
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            case XMLTEXT:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                break;
            case TYPEATTR:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                break;
            case CDATEXT:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            case XMLTEXT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                break;
            case TYPEATTR:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                break;
            case CDATEXT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent src, List<org.hl7.fhir.dstu2016may.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
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
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrdered())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrdered())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setMin(src.getMin());
        if (src.hasMaxElement())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setMin(src.getMin());
        if (src.hasMaxElement())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        return tgt;
    }

    static public void convertTypeRefComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent tgt = null;
        for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : list) if (t.getCode().equals(src.getCode()))
            tgt = t;
        if (tgt == null) {
            tgt = new org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent();
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
            org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
            if (!tgt.hasAggregation(a.getValue()))
                copyElement(t, tgt.addAggregation(a.getValue()));
        }
        if (src.hasVersioning())
            tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    }

    public static void convertTypeRefComponent(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCode(src.getCode());
        list.add(tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.r5.model.UriType u : src.getProfile()) {
                org.hl7.fhir.dstu2016may.model.Extension t = new org.hl7.fhir.dstu2016may.model.Extension(VersionConvertorConstants.PROFILE_EXTENSION);
                t.setValue(convertType(u));
                tgt.addExtension(t);
            }
            for (org.hl7.fhir.r5.model.UriType u : src.getTargetProfile()) {
                if (!u.equals(src.getTargetProfile().get(0))) {
                    tgt = tgt.copy();
                    tgt.getProfile().clear();
                    list.add(tgt);
                }
                tgt.addProfile(u.getValue());
            }
        } else {
            for (org.hl7.fhir.r5.model.UriType u : src.getProfile()) {
                tgt.addProfile(u.getValue());
            }
        }
        for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
            org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode> a = convertAggregationMode(t);
            if (!tgt.hasAggregation(a.getValue()))
                copyElement(t, tgt.addAggregationElement().setValue(a.getValue()));
        }
        if (src.hasVersioning())
            tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EITHER:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.EITHER);
                break;
            case INDEPENDENT:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                break;
            case SPECIFIC:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EITHER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.EITHER);
                break;
            case INDEPENDENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                break;
            case SPECIFIC:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ReferenceVersionRules.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        if (src.hasKeyElement())
            tgt.setKeyElement(convertId(src.getKeyElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
        if (src.hasHumanElement())
            tgt.setHumanElement(convertString(src.getHumanElement()));
        if (src.hasExpression())
            tgt.setExpression(convertToR4Expression(src.getExpression()));
        if (src.hasXpathElement())
            tgt.setXpathElement(convertString(src.getXpathElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        if (src.hasKeyElement())
            tgt.setKeyElement(convertId(src.getKeyElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertString(src.getRequirementsElement()));
        if (src.hasSeverity())
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
        if (src.hasHumanElement())
            tgt.setHumanElement(convertString(src.getHumanElement()));
        if (src.hasExpression())
            tgt.setExpression(convertTo2016MayExpression(src.getExpression()));
        if (src.hasXpathElement())
            tgt.setXpathElement(convertString(src.getXpathElement()));
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasValueSet()) {
            org.hl7.fhir.r5.model.DataType t = convertType(src.getValueSet());
            if (t instanceof org.hl7.fhir.r5.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(convertBindingStrength(src.getStrengthElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.REQUIRED);
                break;
            case EXTENSIBLE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXTENSIBLE);
                break;
            case PREFERRED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.PREFERRED);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.EXAMPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.BindingStrength.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasMapElement())
            tgt.setMapElement(convertString(src.getMapElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(convertId(src.getIdentityElement()));
        if (src.hasLanguage())
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasMapElement())
            tgt.setMapElement(convertString(src.getMapElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HumanName convertHumanName(org.hl7.fhir.dstu2016may.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.HumanName tgt = new org.hl7.fhir.r5.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.HumanName convertHumanName(org.hl7.fhir.r5.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.HumanName tgt = new org.hl7.fhir.dstu2016may.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasFamily())
            tgt.addFamily(src.getFamily());
        for (org.hl7.fhir.r5.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.HumanName.NameUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.HumanName.NameUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.HumanName.NameUseEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.dstu2016may.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
        if (src.hasLastUpdated())
            tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Meta tgt = new org.hl7.fhir.dstu2016may.model.Meta();
        copyElement(src, tgt);
        if (src.hasVersionId())
            tgt.setVersionIdElement(convertId(src.getVersionIdElement()));
        if (src.hasLastUpdated())
            tgt.setLastUpdatedElement(convertInstant(src.getLastUpdatedElement()));
        for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Timing convertTiming(org.hl7.fhir.dstu2016may.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Timing tgt = new org.hl7.fhir.r5.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        if (src.hasRepeat())
            tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Timing convertTiming(org.hl7.fhir.r5.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Timing tgt = new org.hl7.fhir.dstu2016may.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        if (src.hasRepeat())
            tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r5.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        if (src.hasBounds())
            tgt.setBounds(convertType(src.getBounds()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasCountMax())
            tgt.setCountMax(src.getCountMax());
        if (src.hasDuration())
            tgt.setDurationElement(convertDecimal(src.getDurationElement()));
        if (src.hasDurationMax())
            tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
        if (src.hasDurationUnit())
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
        if (src.hasFrequency())
            tgt.setFrequency(src.getFrequency());
        if (src.hasFrequencyMax())
            tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMax())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        if (src.hasWhen())
            tgt.setWhen(Collections.singletonList(convertEventTiming(src.getWhenElement())));
        if (src.hasOffset())
            tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r5.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2016may.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        if (src.hasBounds())
            tgt.setBounds(convertType(src.getBounds()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasCountMax())
            tgt.setCountMax(src.getCountMax());
        if (src.hasDuration())
            tgt.setDurationElement(convertDecimal(src.getDurationElement()));
        if (src.hasDurationMax())
            tgt.setDurationMaxElement(convertDecimal(src.getDurationMaxElement()));
        if (src.hasDurationUnit())
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
        if (src.hasFrequency())
            tgt.setFrequency(src.getFrequency());
        if (src.hasFrequencyMax())
            tgt.setFrequencyMax(src.getFrequencyMax());
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMax())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        if (src.hasWhen())
            tgt.setWhenElement(convertEventTiming(src.getWhen().get(0)));
        if (src.hasOffset())
            tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.EventTimingEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HS:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Timing.EventTiming> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Timing.EventTimingEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu2016may.model.SimpleQuantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.SimpleQuantity tgt = new org.hl7.fhir.r5.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r5.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2016may.model.SimpleQuantity();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2016may.model.Type src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2016may.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r5.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.r5.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.r5.model.BooleanType)
            return convertBoolean((org.hl7.fhir.r5.model.BooleanType) src);
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
        if (src instanceof org.hl7.fhir.r5.model.UriType)
            return convertUri((org.hl7.fhir.r5.model.UriType) src);
        if (src instanceof org.hl7.fhir.r5.model.UuidType)
            return convertUuid((org.hl7.fhir.r5.model.UuidType) src);
        if (src instanceof org.hl7.fhir.r5.model.Extension)
            return convertExtension((org.hl7.fhir.r5.model.Extension) src);
        if (src instanceof org.hl7.fhir.r5.model.Narrative)
            return convertNarrative((org.hl7.fhir.r5.model.Narrative) src);
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
        if (src instanceof org.hl7.fhir.r5.model.Count)
            return convertCount((org.hl7.fhir.r5.model.Count) src);
        if (src instanceof org.hl7.fhir.r5.model.Distance)
            return convertDistance((org.hl7.fhir.r5.model.Distance) src);
        if (src instanceof org.hl7.fhir.r5.model.Duration)
            return convertDuration((org.hl7.fhir.r5.model.Duration) src);
        if (src instanceof org.hl7.fhir.r5.model.Identifier)
            return convertIdentifier((org.hl7.fhir.r5.model.Identifier) src);
        if (src instanceof org.hl7.fhir.r5.model.Money)
            return convertMoney((org.hl7.fhir.r5.model.Money) src);
        if (src instanceof org.hl7.fhir.r5.model.Period)
            return convertPeriod((org.hl7.fhir.r5.model.Period) src);
        if (src instanceof org.hl7.fhir.r5.model.Quantity)
            return convertQuantity((org.hl7.fhir.r5.model.Quantity) src);
        if (src instanceof org.hl7.fhir.r5.model.Range)
            return convertRange((org.hl7.fhir.r5.model.Range) src);
        if (src instanceof org.hl7.fhir.r5.model.Ratio)
            return convertRatio((org.hl7.fhir.r5.model.Ratio) src);
        if (src instanceof org.hl7.fhir.r5.model.Reference)
            return convertReference((org.hl7.fhir.r5.model.Reference) src);
        if (src instanceof org.hl7.fhir.r5.model.SampledData)
            return convertSampledData((org.hl7.fhir.r5.model.SampledData) src);
        if (src instanceof org.hl7.fhir.r5.model.Signature)
            return convertSignature((org.hl7.fhir.r5.model.Signature) src);
        if (src instanceof org.hl7.fhir.r5.model.Address)
            return convertAddress((org.hl7.fhir.r5.model.Address) src);
        if (src instanceof org.hl7.fhir.r5.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.r5.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.r5.model.HumanName)
            return convertHumanName((org.hl7.fhir.r5.model.HumanName) src);
        if (src instanceof org.hl7.fhir.r5.model.Meta)
            return convertMeta((org.hl7.fhir.r5.model.Meta) src);
        if (src instanceof org.hl7.fhir.r5.model.Timing)
            return convertTiming((org.hl7.fhir.r5.model.Timing) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
        boolean ok = false;
        for (String s : extensionsToIgnore) if (s.equals(url))
            ok = true;
        return ok;
    }

    static public void copyDomainResource(org.hl7.fhir.dstu2016may.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.dstu2016may.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.dstu2016may.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.dstu2016may.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    static public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.dstu2016may.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r5.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.r5.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.r5.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    static public void copyResource(org.hl7.fhir.dstu2016may.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
    }

    static public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.dstu2016may.model.Resource tgt) throws FHIRException {
        if (src.hasId())
            tgt.setId(src.getId());
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
    }

    public static org.hl7.fhir.r5.model.Binary convertBinary(org.hl7.fhir.dstu2016may.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Binary tgt = new org.hl7.fhir.r5.model.Binary();
        copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasContent())
            tgt.setContent(src.getContent());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Binary convertBinary(org.hl7.fhir.r5.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Binary tgt = new org.hl7.fhir.dstu2016may.model.Binary();
        copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        tgt.setContentElement(convertBase64Binary(src.getContentElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertConformanceResourceStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> convertConformanceResourceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatusEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.RETIRED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConformanceResourceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public boolean isJurisdiction(CodeableConcept t) {
        return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
    }

    public static org.hl7.fhir.r5.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2016may.model.CodeableConcept t) throws FHIRException {
        org.hl7.fhir.r5.model.UsageContext result = new org.hl7.fhir.r5.model.UsageContext();
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

        public org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent comp;
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NUMBER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NUMBER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.DATE);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.STRING);
                break;
            case TOKEN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.TOKEN);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.REFERENCE);
                break;
            case COMPOSITE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.COMPOSITE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.QUANTITY);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.URI);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode> convertConformanceEventMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode> convertConformanceEventMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2016may.model.Resource src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2016may.model.Parameters)
            return Parameters14_50.convertParameters((org.hl7.fhir.dstu2016may.model.Parameters) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Bundle)
            return Bundle14_50.convertBundle((org.hl7.fhir.dstu2016may.model.Bundle) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.CodeSystem)
            return CodeSystem14_50.convertCodeSystem((org.hl7.fhir.dstu2016may.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.CompartmentDefinition)
            return CompartmentDefinition14_50.convertCompartmentDefinition((org.hl7.fhir.dstu2016may.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ConceptMap)
            return ConceptMap14_50.convertConceptMap((org.hl7.fhir.dstu2016may.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Conformance)
            return Conformance14_50.convertConformance((org.hl7.fhir.dstu2016may.model.Conformance) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.DataElement)
            return DataElement14_50.convertDataElement((org.hl7.fhir.dstu2016may.model.DataElement) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ImplementationGuide)
            return ImplementationGuide14_50.convertImplementationGuide((org.hl7.fhir.dstu2016may.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.NamingSystem)
            return NamingSystem14_50.convertNamingSystem((org.hl7.fhir.dstu2016may.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.OperationDefinition)
            return OperationDefinition14_50.convertOperationDefinition((org.hl7.fhir.dstu2016may.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.OperationOutcome)
            return OperationOutcome14_50.convertOperationOutcome((org.hl7.fhir.dstu2016may.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.Questionnaire)
            return Questionnaire14_50.convertQuestionnaire((org.hl7.fhir.dstu2016may.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.QuestionnaireResponse)
            return QuestionnaireResponse14_50.convertQuestionnaireResponse((org.hl7.fhir.dstu2016may.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.SearchParameter)
            return SearchParameter14_50.convertSearchParameter((org.hl7.fhir.dstu2016may.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.StructureDefinition)
            return StructureDefinition14_50.convertStructureDefinition((org.hl7.fhir.dstu2016may.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.StructureMap)
            return StructureMap14_50.convertStructureMap((org.hl7.fhir.dstu2016may.model.StructureMap) src);
        if (src instanceof org.hl7.fhir.dstu2016may.model.ValueSet)
            return ValueSet14_50.convertValueSet((org.hl7.fhir.dstu2016may.model.ValueSet) src);
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2016may.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r5.model.Parameters)
            return Parameters14_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
        if (src instanceof org.hl7.fhir.r5.model.Bundle)
            return Bundle14_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
        if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
            return CodeSystem14_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
            return CompartmentDefinition14_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
            return ConceptMap14_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
            return Conformance14_50.convertConformance((org.hl7.fhir.r5.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
            return ImplementationGuide14_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
            return NamingSystem14_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
            return OperationDefinition14_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
            return OperationOutcome14_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
            return Questionnaire14_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
            return QuestionnaireResponse14_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
            return SearchParameter14_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
            return StructureDefinition14_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.StructureMap)
            return StructureMap14_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
        if (src instanceof org.hl7.fhir.r5.model.ValueSet)
            return ValueSet14_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static boolean convertsResource(String rt) {
        return Utilities.existsInList(rt, "Parameters", "Bundle", "CodeSystem", "CompartmentDefinition", "ConceptMap", "CapabilityStatement", "ImplementationGuide", "NamingSystem", "OperationDefinition", "OperationOutcome", "Questionnaire", "QuestionnaireResponse", "SearchParameter", "StructureDefinition", "StructureMap", "ValueSet");
    }
}