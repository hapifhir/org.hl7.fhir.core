package org.hl7.fhir.convertors;


/*
 *   public static final String EXT_JSON_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-json-type"; 
  public static final String EXT_RDF_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-rdf-type"; 
  public static final String EXT_XML_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-xml-type"; 

 */
import org.hl7.fhir.convertors.conv40_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class VersionConvertor_40_50 {

    static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
        boolean ok = false;
        for (String s : extensionsToIgnore) if (s.equals(url))
            ok = true;
        return ok;
    }

    protected static void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
        if (src.hasId()) tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            if (!isExemptExtension(e.getUrl(), extensionsToIgnore)) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    protected static void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.r4.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
        if (src.hasId()) tgt.setId(src.getId());
        for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
            if (!isExemptExtension(e.getUrl(), extensionsToIgnore)) {
                tgt.addExtension(convertExtension(e));
            }
        }
    }

    protected static void copyEnumeration(org.hl7.fhir.r4.model.Enumeration<?> src, org.hl7.fhir.r5.model.Enumeration<?> tgt) throws FHIRException {
        if (src.hasId()) tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    protected static void copyEnumeration(org.hl7.fhir.r5.model.Enumeration<?> src, org.hl7.fhir.r4.model.Enumeration<?> tgt) throws FHIRException {
        if (src.hasId()) tgt.setId(src.getId());
        for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    protected static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    protected static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    protected static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneType src, org.hl7.fhir.r4.model.BackboneType tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    protected static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneType src, org.hl7.fhir.r5.model.BackboneType tgt) throws FHIRException {
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(convertExtension(e));
        }
    }

    protected static org.hl7.fhir.utilities.xhtml.XhtmlNode convertXhtml(org.hl7.fhir.utilities.xhtml.XhtmlNode src) throws FHIRException {
        return src;
    }

    public static org.hl7.fhir.r5.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r5.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r5.model.Base64BinaryType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r5.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r4.model.Base64BinaryType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue()) : new org.hl7.fhir.r4.model.Base64BinaryType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r5.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.BooleanType(src.getValue()) : new org.hl7.fhir.r5.model.BooleanType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r4.model.BooleanType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.BooleanType(src.getValue()) : new org.hl7.fhir.r4.model.BooleanType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CanonicalType convertCanonical(org.hl7.fhir.r4.model.CanonicalType src) throws FHIRException {
        org.hl7.fhir.r5.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CanonicalType(src.getValue()) : new org.hl7.fhir.r5.model.CanonicalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CanonicalType convertCanonical(org.hl7.fhir.r5.model.CanonicalType src) throws FHIRException {
        org.hl7.fhir.r4.model.CanonicalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CanonicalType(src.getValue()) : new org.hl7.fhir.r4.model.CanonicalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r5.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.CodeType(src.getValue()) : new org.hl7.fhir.r5.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r4.model.CodeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.CodeType(src.getValue()) : new org.hl7.fhir.r4.model.CodeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateType(src.getValue()) : new org.hl7.fhir.r5.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.r5.model.DateType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValue()) : new org.hl7.fhir.r4.model.DateType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r5.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DateTimeType(src.getValue()) : new org.hl7.fhir.r5.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.r5.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateTimeType(src.getValue()) : new org.hl7.fhir.r4.model.DateTimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r5.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DecimalType(src.getValue()) : new org.hl7.fhir.r5.model.DecimalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r4.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DecimalType(src.getValue()) : new org.hl7.fhir.r4.model.DecimalType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
        org.hl7.fhir.r5.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IdType(src.getValue()) : new org.hl7.fhir.r5.model.IdType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.r5.model.IdType src) throws FHIRException {
        org.hl7.fhir.r4.model.IdType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IdType(src.getValue()) : new org.hl7.fhir.r4.model.IdType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r5.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.InstantType(src.getValue()) : new org.hl7.fhir.r5.model.InstantType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.r5.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r4.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.InstantType(src.getValue()) : new org.hl7.fhir.r4.model.InstantType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r5.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.IntegerType(src.getValue()) : new org.hl7.fhir.r5.model.IntegerType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Integer64Type convertUnsignedIntToInteger64(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.Integer64Type tgt = src.hasValue() ? new org.hl7.fhir.r5.model.Integer64Type(Long.valueOf(src.getValue())) : new org.hl7.fhir.r5.model.Integer64Type();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UnsignedIntType convertInteger64ToUnsignedInt(org.hl7.fhir.r5.model.Integer64Type src) throws FHIRException {
        org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(Math.toIntExact(src.getValue())) : new org.hl7.fhir.r4.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.r5.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValue()) : new org.hl7.fhir.r4.model.IntegerType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r5.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r5.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.r5.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r4.model.MarkdownType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.MarkdownType(src.getValue()) : new org.hl7.fhir.r4.model.MarkdownType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
        org.hl7.fhir.r5.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.OidType(src.getValue()) : new org.hl7.fhir.r5.model.OidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.r5.model.OidType src) throws FHIRException {
        org.hl7.fhir.r4.model.OidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.OidType(src.getValue()) : new org.hl7.fhir.r4.model.OidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r5.model.PositiveIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r5.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.PositiveIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.PositiveIntType(src.getValue()) : new org.hl7.fhir.r4.model.PositiveIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
        org.hl7.fhir.r5.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.StringType(src.getValue()) : new org.hl7.fhir.r5.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
        org.hl7.fhir.r4.model.StringType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.StringType(src.getValue()) : new org.hl7.fhir.r4.model.StringType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r5.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.TimeType(src.getValue()) : new org.hl7.fhir.r5.model.TimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.r5.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.TimeType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.TimeType(src.getValue()) : new org.hl7.fhir.r4.model.TimeType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r5.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r5.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r5.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.UnsignedIntType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UnsignedIntType(src.getValue()) : new org.hl7.fhir.r4.model.UnsignedIntType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
        org.hl7.fhir.r5.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UriType(src.getValue()) : new org.hl7.fhir.r5.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.r5.model.UriType src) throws FHIRException {
        org.hl7.fhir.r4.model.UriType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UriType(src.getValue()) : new org.hl7.fhir.r4.model.UriType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UrlType convertUrl(org.hl7.fhir.r4.model.UrlType src) throws FHIRException {
        org.hl7.fhir.r5.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UrlType(src.getValue()) : new org.hl7.fhir.r5.model.UrlType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UrlType convertUrl(org.hl7.fhir.r5.model.UrlType src) throws FHIRException {
        org.hl7.fhir.r4.model.UrlType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UrlType(src.getValue()) : new org.hl7.fhir.r4.model.UrlType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r5.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.UuidType(src.getValue()) : new org.hl7.fhir.r5.model.UuidType();
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r4.model.UuidType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.UuidType(src.getValue()) : new org.hl7.fhir.r4.model.UuidType();
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
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
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
            tgt.setStatusElement(convertNarrativeStatus(src.getStatusElement()));
        if (src.hasDiv())
            tgt.setDiv(convertXhtml(src.getDiv()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> convertNarrativeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Narrative.NarrativeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Narrative.NarrativeStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Narrative.NarrativeStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case GENERATED:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EXTENSIONS);
                break;
            case ADDITIONAL:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.ADDITIONAL);
                break;
            case EMPTY:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EMPTY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Address tgt = new org.hl7.fhir.r5.model.Address();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLine()) tgt.getLine().add(convertString(t));
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
            tgt.setUseElement(convertAddressUse(src.getUseElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAddressType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLine()) tgt.getLine().add(convertString(t));
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case BILLING:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.BILLING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> convertAddressUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.OLD);
                break;
            case BILLING:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.BILLING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> convertAddressType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Address.AddressTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> convertAddressType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Address.AddressType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Address.AddressType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Address.AddressTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case POSTAL:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.POSTAL);
                break;
            case PHYSICAL:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.PHYSICAL);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Address.AddressType.NULL);
                break;
        }
        return tgt;
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
            tgt.setSizeElement(convertUnsignedIntToInteger64(src.getSizeElement()));
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
            tgt.setSizeElement(convertInteger64ToUnsignedInt(src.getSizeElement()));
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
        for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
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
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertContactDetail(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactPoint convertContactPoint(org.hl7.fhir.r4.model.ContactPoint src) throws FHIRException {
        if (src == null)
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

    public static org.hl7.fhir.r4.model.ContactPoint convertContactPoint(org.hl7.fhir.r5.model.ContactPoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ContactPoint tgt = new org.hl7.fhir.r4.model.ContactPoint();
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case URL:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.URL);
                break;
            case SMS:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.SMS);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> convertContactPointSystem(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ContactPoint.ContactPointSystemEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PHONE:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PHONE);
                break;
            case FAX:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.FAX);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.EMAIL);
                break;
            case PAGER:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PAGER);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.URL);
                break;
            case SMS:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.SMS);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> convertContactPointUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ContactPoint.ContactPointUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ContactPoint.ContactPointUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ContactPoint.ContactPointUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case HOME:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.HOME);
                break;
            case WORK:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.WORK);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.TEMP);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.OLD);
                break;
            case MOBILE:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.MOBILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contributor convertContributor(org.hl7.fhir.r4.model.Contributor src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contributor tgt = new org.hl7.fhir.r5.model.Contributor();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertContributorType(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contributor convertContributor(org.hl7.fhir.r5.model.Contributor src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contributor tgt = new org.hl7.fhir.r4.model.Contributor();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertContributorType(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contributor.ContributorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contributor.ContributorTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AUTHOR:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.AUTHOR);
                break;
            case EDITOR:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.EDITOR);
                break;
            case REVIEWER:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.REVIEWER);
                break;
            case ENDORSER:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.ENDORSER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Contributor.ContributorType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contributor.ContributorType> convertContributorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contributor.ContributorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contributor.ContributorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Contributor.ContributorTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AUTHOR:
                tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.AUTHOR);
                break;
            case EDITOR:
                tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.EDITOR);
                break;
            case REVIEWER:
                tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.REVIEWER);
                break;
            case ENDORSER:
                tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.ENDORSER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Contributor.ContributorType.NULL);
                break;
        }
        return tgt;
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
            tgt.setType(org.hl7.fhir.r5.model.Enumerations.FHIRAllTypes.fromCode(src.getType()));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile()) tgt.getProfile().add(convertCanonical(t));
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        for (org.hl7.fhir.r4.model.StringType t : src.getMustSupport()) tgt.getMustSupport().add(convertString(t));
        for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter()) tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
        for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter()) tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
        if (src.hasLimit())
            tgt.setLimitElement(convertPositiveInt(src.getLimitElement()));
        for (org.hl7.fhir.r4.model.DataRequirement.DataRequirementSortComponent t : src.getSort()) tgt.addSort(convertDataRequirementSortComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DataRequirement convertDataRequirement(org.hl7.fhir.r5.model.DataRequirement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DataRequirement tgt = new org.hl7.fhir.r4.model.DataRequirement();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType().toCode());
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile()) tgt.getProfile().add(convertCanonical(t));
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        for (org.hl7.fhir.r5.model.StringType t : src.getMustSupport()) tgt.getMustSupport().add(convertString(t));
        for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementCodeFilterComponent t : src.getCodeFilter()) tgt.addCodeFilter(convertDataRequirementCodeFilterComponent(t));
        for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementDateFilterComponent t : src.getDateFilter()) tgt.addDateFilter(convertDataRequirementDateFilterComponent(t));
        if (src.hasLimit())
            tgt.setLimitElement(convertPositiveInt(src.getLimitElement()));
        for (org.hl7.fhir.r5.model.DataRequirement.DataRequirementSortComponent t : src.getSort()) tgt.addSort(convertDataRequirementSortComponent(t));
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
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
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
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
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
            tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
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
            tgt.setDirectionElement(convertSortDirection(src.getDirectionElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DataRequirement.SortDirectionEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ASCENDING:
                tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.ASCENDING);
                break;
            case DESCENDING:
                tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.DESCENDING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.DataRequirement.SortDirection.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> convertSortDirection(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DataRequirement.SortDirection> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DataRequirement.SortDirection> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DataRequirement.SortDirectionEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ASCENDING:
                tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.ASCENDING);
                break;
            case DESCENDING:
                tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.DESCENDING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DataRequirement.SortDirection.NULL);
                break;
        }
        return tgt;
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
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAdditionalInstruction()) tgt.addAdditionalInstruction(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate()) tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
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
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAdditionalInstruction()) tgt.addAdditionalInstruction(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate()) tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
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
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
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
            tgt.setLanguageElement(convertCode(src.getLanguageElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasReference())
            tgt.setReferenceElement(convertUri(src.getReferenceElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.HumanName tgt = new org.hl7.fhir.r5.model.HumanName();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasFamily())
            tgt.setFamilyElement(convertString(src.getFamilyElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.getGiven().add(convertString(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.getPrefix().add(convertString(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.getSuffix().add(convertString(t));
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
            tgt.setUseElement(convertNameUse(src.getUseElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasFamily())
            tgt.setFamilyElement(convertString(src.getFamilyElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getGiven()) tgt.getGiven().add(convertString(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getPrefix()) tgt.getPrefix().add(convertString(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getSuffix()) tgt.getSuffix().add(convertString(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.HumanName.NameUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> convertNameUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.HumanName.NameUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.HumanName.NameUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.HumanName.NameUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.TEMP);
                break;
            case NICKNAME:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NICKNAME);
                break;
            case ANONYMOUS:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.ANONYMOUS);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.OLD);
                break;
            case MAIDEN:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.MAIDEN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.HumanName.NameUse.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
        if (src == null)
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

    public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.r5.model.Identifier src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case OLD:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> convertIdentifierUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Identifier.IdentifierUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Identifier.IdentifierUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Identifier.IdentifierUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case USUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.USUAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.OFFICIAL);
                break;
            case TEMP:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.TEMP);
                break;
            case SECONDARY:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.SECONDARY);
                break;
            case OLD:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.OLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL);
                break;
        }
        return tgt;
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
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile()) tgt.getProfile().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
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
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile()) tgt.getProfile().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
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
            tgt.setUseElement(convertParameterUse(src.getUseElement()));
        if (src.hasMin())
            tgt.setMinElement(convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
        if (src.hasType())
            tgt.setType(org.hl7.fhir.r5.model.Enumerations.FHIRAllTypes.fromCode(src.getType()));
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
            tgt.setUseElement(convertParameterUse(src.getUseElement()));
        if (src.hasMin())
            tgt.setMinElement(convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(convertString(src.getDocumentationElement()));
        if (src.hasType())
            tgt.setType(src.getType().toCode());
        if (src.hasProfile())
            tgt.setProfileElement(convertCanonical(src.getProfileElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ParameterDefinition.ParameterUseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.NULL);
                break;
        }
        return tgt;
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
        for (org.hl7.fhir.r4.model.StringType t : src.getColor()) tgt.getColor().add(convertString(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getImprint()) tgt.getImprint().add(convertString(t));
        for (org.hl7.fhir.r4.model.Attachment t : src.getImage()) tgt.addImage(convertAttachment(t));
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
        for (org.hl7.fhir.r5.model.StringType t : src.getColor()) tgt.getColor().add(convertString(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getImprint()) tgt.getImprint().add(convertString(t));
        for (org.hl7.fhir.r5.model.Attachment t : src.getImage()) tgt.addImage(convertAttachment(t));
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
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialPrecautionsForStorage()) tgt.addSpecialPrecautionsForStorage(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialPrecautionsForStorage()) tgt.addSpecialPrecautionsForStorage(convertCodeableConcept(t));
        return tgt;
    }

    public static void copyQuantity(org.hl7.fhir.r4.model.Quantity src, org.hl7.fhir.r5.model.Quantity tgt) throws FHIRException {
        if (src == null || tgt == null)
            return;
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasComparator())
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Quantity.QuantityComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Quantity.QuantityComparatorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LESS_THAN:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_THAN);
                break;
            case LESS_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_OR_EQUAL);
                break;
            case GREATER_OR_EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_OR_EQUAL);
                break;
            case GREATER_THAN:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_THAN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL);
                break;
        }
        return tgt;
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
            tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
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
            tgt.setTypeElement(convertRelatedArtifactType(src.getTypeElement()));
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DOCUMENTATION:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
                break;
            case JUSTIFICATION:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
                break;
            case CITATION:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.CITATION);
                break;
            case PREDECESSOR:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
                break;
            case SUCCESSOR:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
                break;
            case DERIVEDFROM:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
                break;
            case DEPENDSON:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
                break;
            case COMPOSEDOF:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> convertRelatedArtifactType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DOCUMENTATION:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DOCUMENTATION);
                break;
            case JUSTIFICATION:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.JUSTIFICATION);
                break;
            case CITATION:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.CITATION);
                break;
            case PREDECESSOR:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.PREDECESSOR);
                break;
            case SUCCESSOR:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.SUCCESSOR);
                break;
            case DERIVEDFROM:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DERIVEDFROM);
                break;
            case DEPENDSON:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.DEPENDSON);
                break;
            case COMPOSEDOF:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.COMPOSEDOF);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RelatedArtifact.RelatedArtifactType.NULL);
                break;
        }
        return tgt;
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
        for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
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
        for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
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
        for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent()) tgt.getEvent().add(convertDateTime(t));
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
        for (org.hl7.fhir.r5.model.DateTimeType t : src.getEvent()) tgt.getEvent().add(convertDateTime(t));
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
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
        if (src.hasFrequency())
            tgt.setFrequencyElement(convertPositiveInt(src.getFrequencyElement()));
        if (src.hasFrequencyMax())
            tgt.setFrequencyMaxElement(convertPositiveInt(src.getFrequencyMaxElement()));
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMax())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        tgt.setDayOfWeek(src.getDayOfWeek().stream()
                .map(VersionConvertor_40_50::convertDayOfWeek)
                .collect(Collectors.toList()));
        tgt.setWhen(src.getWhen().stream()
                .map(VersionConvertor_40_50::convertEventTiming)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.r4.model.TimeType t : src.getTimeOfDay()) tgt.getTimeOfDay().add(convertTime(t));
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
            tgt.setDurationUnitElement(convertUnitsOfTime(src.getDurationUnitElement()));
        if (src.hasFrequency())
            tgt.setFrequencyElement(convertPositiveInt(src.getFrequencyElement()));
        if (src.hasFrequencyMax())
            tgt.setFrequencyMaxElement(convertPositiveInt(src.getFrequencyMaxElement()));
        if (src.hasPeriod())
            tgt.setPeriodElement(convertDecimal(src.getPeriodElement()));
        if (src.hasPeriodMax())
            tgt.setPeriodMaxElement(convertDecimal(src.getPeriodMaxElement()));
        if (src.hasPeriodUnit())
            tgt.setPeriodUnitElement(convertUnitsOfTime(src.getPeriodUnitElement()));
        tgt.setDayOfWeek(src.getDayOfWeek().stream()
                .map(VersionConvertor_40_50::convertDayOfWeek)
                .collect(Collectors.toList()));
        tgt.setWhen(src.getWhen().stream()
                .map(VersionConvertor_40_50::convertEventTiming)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.r5.model.TimeType t : src.getTimeOfDay()) tgt.getTimeOfDay().add(convertTime(t));
        if (src.hasOffset())
            tgt.setOffsetElement(convertUnsignedInt(src.getOffsetElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> convertUnitsOfTime(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.UnitsOfTime> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.UnitsOfTime> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.UnitsOfTimeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case S:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.S);
                break;
            case MIN:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.MIN);
                break;
            case H:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.H);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.D);
                break;
            case WK:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.WK);
                break;
            case MO:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.MO);
                break;
            case A:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.A);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDayOfWeek(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MON:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
                break;
            case TUE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
                break;
            case WED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
                break;
            case THU:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
                break;
            case FRI:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
                break;
            case SAT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
                break;
            case SUN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> convertDayOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.DayOfWeek> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.DayOfWeekEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MON:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.MON);
                break;
            case TUE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.TUE);
                break;
            case WED:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.WED);
                break;
            case THU:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.THU);
                break;
            case FRI:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.FRI);
                break;
            case SAT:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.SAT);
                break;
            case SUN:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.SUN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.DayOfWeek.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Timing.EventTimingEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MORN:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN);
                break;
            case MORN_EARLY:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN_EARLY);
                break;
            case MORN_LATE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.MORN_LATE);
                break;
            case NOON:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NOON);
                break;
            case AFT:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT);
                break;
            case AFT_EARLY:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT_EARLY);
                break;
            case AFT_LATE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.AFT_LATE);
                break;
            case EVE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE);
                break;
            case EVE_EARLY:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE_EARLY);
                break;
            case EVE_LATE:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.EVE_LATE);
                break;
            case NIGHT:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.NIGHT);
                break;
            case PHS:
                tgt.setValue(org.hl7.fhir.r5.model.Timing.EventTiming.PHS);
                break;
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> convertEventTiming(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Timing.EventTiming> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Timing.EventTiming> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Timing.EventTimingEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MORN:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN);
                break;
            case MORN_EARLY:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN_EARLY);
                break;
            case MORN_LATE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.MORN_LATE);
                break;
            case NOON:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NOON);
                break;
            case AFT:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT);
                break;
            case AFT_EARLY:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT_EARLY);
                break;
            case AFT_LATE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AFT_LATE);
                break;
            case EVE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE);
                break;
            case EVE_EARLY:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE_EARLY);
                break;
            case EVE_LATE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.EVE_LATE);
                break;
            case NIGHT:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NIGHT);
                break;
            case PHS:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PHS);
                break;
            case HS:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.HS);
                break;
            case WAKE:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.WAKE);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.C);
                break;
            case CM:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CM);
                break;
            case CD:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CD);
                break;
            case CV:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.CV);
                break;
            case AC:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.AC);
                break;
            case ACM:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACM);
                break;
            case ACD:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACD);
                break;
            case ACV:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.ACV);
                break;
            case PC:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PC);
                break;
            case PCM:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCM);
                break;
            case PCD:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCD);
                break;
            case PCV:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.PCV);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Timing.EventTiming.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TriggerDefinition convertTriggerDefinition(org.hl7.fhir.r4.model.TriggerDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TriggerDefinition tgt = new org.hl7.fhir.r5.model.TriggerDefinition();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        for (org.hl7.fhir.r4.model.DataRequirement t : src.getData()) tgt.addData(convertDataRequirement(t));
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
            tgt.setTypeElement(convertTriggerType(src.getTypeElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        for (org.hl7.fhir.r5.model.DataRequirement t : src.getData()) tgt.addData(convertDataRequirement(t));
        if (src.hasCondition())
            tgt.setCondition(convertExpression(src.getCondition()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TriggerDefinition.TriggerTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NAMEDEVENT:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NAMEDEVENT);
                break;
            case PERIODIC:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.PERIODIC);
                break;
            case DATACHANGED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATACHANGED);
                break;
            case DATAADDED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAADDED);
                break;
            case DATAMODIFIED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAMODIFIED);
                break;
            case DATAREMOVED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAREMOVED);
                break;
            case DATAACCESSED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSED);
                break;
            case DATAACCESSENDED:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TriggerDefinition.TriggerType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> convertTriggerType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TriggerDefinition.TriggerType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TriggerDefinition.TriggerType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TriggerDefinition.TriggerTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NAMEDEVENT:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NAMEDEVENT);
                break;
            case PERIODIC:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.PERIODIC);
                break;
            case DATACHANGED:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATACHANGED);
                break;
            case DATAADDED:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAADDED);
                break;
            case DATAMODIFIED:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAMODIFIED);
                break;
            case DATAREMOVED:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAREMOVED);
                break;
            case DATAACCESSED:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSED);
                break;
            case DATAACCESSENDED:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.DATAACCESSENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TriggerDefinition.TriggerType.NULL);
                break;
        }
        return tgt;
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
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_40_50::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasSliceName())
            tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
        if (src.hasSliceIsConstraining())
            tgt.setSliceIsConstrainingElement(convertBoolean(src.getSliceIsConstrainingElement()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
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
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasMin())
            tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType()) tgt.addType(convertTypeRefComponent(t));
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
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample()) tgt.addExample(convertElementDefinitionExampleComponent(t));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.getCondition().add(convertId(t));
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
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
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r5.model.ElementDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
        copyBackboneElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        tgt.setRepresentation(src.getRepresentation().stream()
                .map(VersionConvertor_40_50::convertPropertyRepresentation)
                .collect(Collectors.toList()));
        if (src.hasSliceName())
            tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
        if (src.hasSliceIsConstraining())
            tgt.setSliceIsConstrainingElement(convertBoolean(src.getSliceIsConstrainingElement()));
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
            tgt.setCommentElement(convertMarkdown(src.getCommentElement()));
        if (src.hasRequirements())
            tgt.setRequirementsElement(convertMarkdown(src.getRequirementsElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasMin())
            tgt.setMinElement(convertUnsignedInt(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(convertString(src.getMaxElement()));
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setContentReferenceElement(convertUri(src.getContentReferenceElement()));
        for (org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent t : src.getType()) tgt.addType(convertTypeRefComponent(t));
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
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionExampleComponent t : src.getExample()) tgt.addExample(convertElementDefinitionExampleComponent(t));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(convertInteger(src.getMaxLengthElement()));
        for (org.hl7.fhir.r5.model.IdType t : src.getCondition()) tgt.getCondition().add(convertId(t));
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
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
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case XHTML:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.XHTML);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> convertPropertyRepresentation(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentationEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case XMLATTR:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR);
                break;
            case XMLTEXT:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLTEXT);
                break;
            case TYPEATTR:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.TYPEATTR);
                break;
            case CDATEXT:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.CDATEXT);
                break;
            case XHTML:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XHTML);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrdered())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(convertElementDefinitionSlicingDiscriminatorComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasOrdered())
            tgt.setOrderedElement(convertBoolean(src.getOrderedElement()));
        if (src.hasRules())
            tgt.setRulesElement(convertSlicingRules(src.getRulesElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> convertSlicingRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.SlicingRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.SlicingRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.SlicingRulesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLOSED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.CLOSED);
                break;
            case OPEN:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPEN);
                break;
            case OPENATEND:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPENATEND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent convertElementDefinitionSlicingDiscriminatorComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
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
            tgt.setTypeElement(convertDiscriminatorType(src.getTypeElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VALUE:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.VALUE);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.EXISTS);
                break;
            case PATTERN:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.PATTERN);
                break;
            case TYPE:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.TYPE);
                break;
            case PROFILE:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.PROFILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> convertDiscriminatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VALUE:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.VALUE);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.EXISTS);
                break;
            case PATTERN:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.PATTERN);
                break;
            case TYPE:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.TYPE);
                break;
            case PROFILE:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.PROFILE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.DiscriminatorType.NULL);
                break;
        }
        return tgt;
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
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile()) tgt.getProfile().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile()) tgt.getTargetProfile().add(convertCanonical(t));
        tgt.setAggregation(src.getAggregation().stream()
                .map(VersionConvertor_40_50::convertAggregationMode)
                .collect(Collectors.toList()));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent convertTypeRefComponent(org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertUri(src.getCodeElement()));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile()) tgt.getProfile().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getTargetProfile()) tgt.getTargetProfile().add(convertCanonical(t));
        tgt.setAggregation(src.getAggregation().stream()
                .map(VersionConvertor_40_50::convertAggregationMode)
                .collect(Collectors.toList()));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertReferenceVersionRules(src.getVersioningElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> convertAggregationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.AggregationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.AggregationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.AggregationModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONTAINED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.CONTAINED);
                break;
            case REFERENCED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.REFERENCED);
                break;
            case BUNDLED:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.BUNDLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> convertReferenceVersionRules(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ReferenceVersionRules> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRulesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EITHER:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.EITHER);
                break;
            case INDEPENDENT:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.INDEPENDENT);
                break;
            case SPECIFIC:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.SPECIFIC);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ReferenceVersionRules.NULL);
                break;
        }
        return tgt;
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
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
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
            tgt.setSeverityElement(convertConstraintSeverity(src.getSeverityElement()));
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> convertConstraintSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ElementDefinition.ConstraintSeverity> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.ERROR);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.WARNING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(Enumerations40_50.convertBindingStrength(src.getStrengthElement()));
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
            tgt.setStrengthElement(Enumerations40_50.convertBindingStrength(src.getStrengthElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
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
            tgt.setComparatorElement(convertQuantityComparator(src.getComparatorElement()));
        if (src.hasUnit())
            tgt.setUnitElement(convertString(src.getUnitElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertUri(src.getSystemElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
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
        if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.r4.model.IntegerType)
            return convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.r4.model.OidType)
            return convertOid((org.hl7.fhir.r4.model.OidType) src);
        if (src instanceof org.hl7.fhir.r4.model.StringType)
            return convertString((org.hl7.fhir.r4.model.StringType) src);
        if (src instanceof org.hl7.fhir.r4.model.TimeType)
            return convertTime((org.hl7.fhir.r4.model.TimeType) src);
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
        throw new Error("Unknown type " + src.fhirType());
    }

    public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
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
        if (src instanceof org.hl7.fhir.r5.model.IntegerType)
            return convertInteger((org.hl7.fhir.r5.model.IntegerType) src);
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
        throw new Error("Unknown type " + src.fhirType());
    }

    protected static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt) throws FHIRException {
        copyResource(src, tgt);
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r4.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getExtension()) tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getModifierExtension()) tgt.addModifierExtension(convertExtension(t));
    }

    protected static void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt) throws FHIRException {
        copyResource(src, tgt);
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r5.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.r5.model.Extension t : src.getExtension()) tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.r5.model.Extension t : src.getModifierExtension()) tgt.addModifierExtension(convertExtension(t));
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
            return Parameters40_50.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
        if (src instanceof org.hl7.fhir.r4.model.Account)
            return Account40_50.convertAccount((org.hl7.fhir.r4.model.Account) src);
        if (src instanceof org.hl7.fhir.r4.model.ActivityDefinition)
            return ActivityDefinition40_50.convertActivityDefinition((org.hl7.fhir.r4.model.ActivityDefinition) src);
        // if (src instanceof org.hl7.fhir.r4.model.AdverseEvent)
        // return AdverseEvent.convertAdverseEvent((org.hl7.fhir.r4.model.AdverseEvent) src);
        if (src instanceof org.hl7.fhir.r4.model.AllergyIntolerance)
            return AllergyIntolerance40_50.convertAllergyIntolerance((org.hl7.fhir.r4.model.AllergyIntolerance) src);
        if (src instanceof org.hl7.fhir.r4.model.Appointment)
            return Appointment40_50.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
        if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
            return AppointmentResponse40_50.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
            return AuditEvent40_50.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.r4.model.Basic)
            return Basic40_50.convertBasic((org.hl7.fhir.r4.model.Basic) src);
        if (src instanceof org.hl7.fhir.r4.model.Binary)
            return Binary40_50.convertBinary((org.hl7.fhir.r4.model.Binary) src);
        if (src instanceof org.hl7.fhir.r4.model.BiologicallyDerivedProduct)
            return BiologicallyDerivedProduct40_50.convertBiologicallyDerivedProduct((org.hl7.fhir.r4.model.BiologicallyDerivedProduct) src);
        if (src instanceof org.hl7.fhir.r4.model.BodyStructure)
            return BodyStructure40_50.convertBodyStructure((org.hl7.fhir.r4.model.BodyStructure) src);
        if (src instanceof org.hl7.fhir.r4.model.Bundle)
            return Bundle40_50.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
        if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
            return CapabilityStatement40_50.convertCapabilityStatement((org.hl7.fhir.r4.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.CarePlan)
            return CarePlan40_50.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.r4.model.CareTeam)
            return CareTeam40_50.convertCareTeam((org.hl7.fhir.r4.model.CareTeam) src);
        // if (src instanceof org.hl7.fhir.r4.model.CatalogEntry)
        // return CatalogEntry.convertCatalogEntry((org.hl7.fhir.r4.model.CatalogEntry) src);
        if (src instanceof org.hl7.fhir.r4.model.ChargeItem)
            return ChargeItem40_50.convertChargeItem((org.hl7.fhir.r4.model.ChargeItem) src);
        if (src instanceof org.hl7.fhir.r4.model.ChargeItemDefinition)
            return ChargeItemDefinition40_50.convertChargeItemDefinition((org.hl7.fhir.r4.model.ChargeItemDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.Claim)
            return Claim40_50.convertClaim((org.hl7.fhir.r4.model.Claim) src);
        if (src instanceof org.hl7.fhir.r4.model.ClaimResponse)
            return ClaimResponse40_50.convertClaimResponse((org.hl7.fhir.r4.model.ClaimResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.ClinicalImpression)
            return ClinicalImpression40_50.convertClinicalImpression((org.hl7.fhir.r4.model.ClinicalImpression) src);
        if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
            return CodeSystem40_50.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.r4.model.Communication)
            return Communication40_50.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
        if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
            return CommunicationRequest40_50.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
            return CompartmentDefinition40_50.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.Composition)
            return Composition40_50.convertComposition((org.hl7.fhir.r4.model.Composition) src);
        if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
            return ConceptMap40_50.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r4.model.Condition)
            return Condition40_50.convertCondition((org.hl7.fhir.r4.model.Condition) src);
        if (src instanceof org.hl7.fhir.r4.model.Consent)
            return Consent40_50.convertConsent((org.hl7.fhir.r4.model.Consent) src);
        if (src instanceof org.hl7.fhir.r4.model.Contract)
            return Contract40_50.convertContract((org.hl7.fhir.r4.model.Contract) src);
        if (src instanceof org.hl7.fhir.r4.model.Coverage)
            return Coverage40_50.convertCoverage((org.hl7.fhir.r4.model.Coverage) src);
        if (src instanceof org.hl7.fhir.r4.model.CoverageEligibilityRequest)
            return CoverageEligibilityRequest40_50.convertCoverageEligibilityRequest((org.hl7.fhir.r4.model.CoverageEligibilityRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.CoverageEligibilityResponse)
            return CoverageEligibilityResponse40_50.convertCoverageEligibilityResponse((org.hl7.fhir.r4.model.CoverageEligibilityResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
            return DetectedIssue40_50.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.r4.model.Device)
            return Device40_50.convertDevice((org.hl7.fhir.r4.model.Device) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceDefinition)
            return DeviceDefinition40_50.convertDeviceDefinition((org.hl7.fhir.r4.model.DeviceDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
            return DeviceMetric40_50.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceRequest)
            return DeviceRequest40_50.convertDeviceRequest((org.hl7.fhir.r4.model.DeviceRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
            return DeviceUseStatement40_50.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
            return DiagnosticReport40_50.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.r4.model.DocumentManifest)
            return DocumentManifest40_50.convertDocumentManifest((org.hl7.fhir.r4.model.DocumentManifest) src);
        if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
            return DocumentReference40_50.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r4.model.Encounter)
            return Encounter40_50.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
        if (src instanceof org.hl7.fhir.r4.model.Endpoint)
            return Endpoint40_50.convertEndpoint((org.hl7.fhir.r4.model.Endpoint) src);
        if (src instanceof org.hl7.fhir.r4.model.EnrollmentRequest)
            return EnrollmentRequest40_50.convertEnrollmentRequest((org.hl7.fhir.r4.model.EnrollmentRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.EnrollmentResponse)
            return EnrollmentResponse40_50.convertEnrollmentResponse((org.hl7.fhir.r4.model.EnrollmentResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
            return EpisodeOfCare40_50.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.r4.model.EventDefinition)
            return EventDefinition40_50.convertEventDefinition((org.hl7.fhir.r4.model.EventDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.ExampleScenario)
            return ExampleScenario40_50.convertExampleScenario((org.hl7.fhir.r4.model.ExampleScenario) src);
        if (src instanceof org.hl7.fhir.r4.model.ExplanationOfBenefit)
            return ExplanationOfBenefit40_50.convertExplanationOfBenefit((org.hl7.fhir.r4.model.ExplanationOfBenefit) src);
        if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
            return FamilyMemberHistory40_50.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.r4.model.Flag)
            return Flag40_50.convertFlag((org.hl7.fhir.r4.model.Flag) src);
        if (src instanceof org.hl7.fhir.r4.model.Goal)
            return Goal40_50.convertGoal((org.hl7.fhir.r4.model.Goal) src);
        if (src instanceof org.hl7.fhir.r4.model.GraphDefinition)
            return GraphDefinition40_50.convertGraphDefinition((org.hl7.fhir.r4.model.GraphDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.Group)
            return Group40_50.convertGroup((org.hl7.fhir.r4.model.Group) src);
        if (src instanceof org.hl7.fhir.r4.model.GuidanceResponse)
            return GuidanceResponse40_50.convertGuidanceResponse((org.hl7.fhir.r4.model.GuidanceResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
            return HealthcareService40_50.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.r4.model.ImagingStudy)
            return ImagingStudy40_50.convertImagingStudy((org.hl7.fhir.r4.model.ImagingStudy) src);
        if (src instanceof org.hl7.fhir.r4.model.Immunization)
            return Immunization40_50.convertImmunization((org.hl7.fhir.r4.model.Immunization) src);
        if (src instanceof org.hl7.fhir.r4.model.ImmunizationEvaluation)
            return ImmunizationEvaluation40_50.convertImmunizationEvaluation((org.hl7.fhir.r4.model.ImmunizationEvaluation) src);
        if (src instanceof org.hl7.fhir.r4.model.ImmunizationRecommendation)
            return ImmunizationRecommendation40_50.convertImmunizationRecommendation((org.hl7.fhir.r4.model.ImmunizationRecommendation) src);
        if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
            return ImplementationGuide40_50.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r4.model.InsurancePlan)
            return InsurancePlan40_50.convertInsurancePlan((org.hl7.fhir.r4.model.InsurancePlan) src);
        if (src instanceof org.hl7.fhir.r4.model.Invoice)
            return Invoice40_50.convertInvoice((org.hl7.fhir.r4.model.Invoice) src);
        if (src instanceof org.hl7.fhir.r4.model.Library)
            return Library40_50.convertLibrary((org.hl7.fhir.r4.model.Library) src);
        if (src instanceof org.hl7.fhir.r4.model.Linkage)
            return Linkage40_50.convertLinkage((org.hl7.fhir.r4.model.Linkage) src);
        if (src instanceof org.hl7.fhir.r4.model.ListResource)
            return ListResource40_50.convertListResource((org.hl7.fhir.r4.model.ListResource) src);
        if (src instanceof org.hl7.fhir.r4.model.Location)
            return Location40_50.convertLocation((org.hl7.fhir.r4.model.Location) src);
        if (src instanceof org.hl7.fhir.r4.model.Measure)
            return Measure40_50.convertMeasure((org.hl7.fhir.r4.model.Measure) src);
        if (src instanceof org.hl7.fhir.r4.model.MeasureReport)
            return MeasureReport40_50.convertMeasureReport((org.hl7.fhir.r4.model.MeasureReport) src);
        if (src instanceof org.hl7.fhir.r4.model.Media)
            return Media40_50.convertMedia((org.hl7.fhir.r4.model.Media) src);
        if (src instanceof org.hl7.fhir.r4.model.Medication)
            return Medication40_50.convertMedication((org.hl7.fhir.r4.model.Medication) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationAdministration)
            return MedicationAdministration40_50.convertMedicationAdministration((org.hl7.fhir.r4.model.MedicationAdministration) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
            return MedicationDispense40_50.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationKnowledge)
            return MedicationKnowledge40_50.convertMedicationKnowledge((org.hl7.fhir.r4.model.MedicationKnowledge) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationRequest)
            return MedicationRequest40_50.convertMedicationRequest((org.hl7.fhir.r4.model.MedicationRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
            return MedicationStatement40_50.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicinalProduct)
          return MedicinalProductDefinition40_50.convertMedicinalProduct((org.hl7.fhir.r4.model.MedicinalProduct) src);
        if (src instanceof org.hl7.fhir.r4.model.MessageDefinition)
            return MessageDefinition40_50.convertMessageDefinition((org.hl7.fhir.r4.model.MessageDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
            return MessageHeader40_50.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.r4.model.MolecularSequence)
            return MolecularSequence40_50.convertMolecularSequence((org.hl7.fhir.r4.model.MolecularSequence) src);
        if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
            return NamingSystem40_50.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r4.model.NutritionOrder)
            return NutritionOrder40_50.convertNutritionOrder((org.hl7.fhir.r4.model.NutritionOrder) src);
        if (src instanceof org.hl7.fhir.r4.model.Observation)
            return Observation40_50.convertObservation((org.hl7.fhir.r4.model.Observation) src);
        if (src instanceof org.hl7.fhir.r4.model.ObservationDefinition)
            return ObservationDefinition40_50.convertObservationDefinition((org.hl7.fhir.r4.model.ObservationDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
            return OperationDefinition40_50.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
            return OperationOutcome40_50.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r4.model.Organization)
            return Organization40_50.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
        if (src instanceof org.hl7.fhir.r4.model.OrganizationAffiliation)
            return OrganizationAffiliation40_50.convertOrganizationAffiliation((org.hl7.fhir.r4.model.OrganizationAffiliation) src);
        if (src instanceof org.hl7.fhir.r4.model.Patient)
            return Patient40_50.convertPatient((org.hl7.fhir.r4.model.Patient) src);
        if (src instanceof org.hl7.fhir.r4.model.PaymentNotice)
            return PaymentNotice40_50.convertPaymentNotice((org.hl7.fhir.r4.model.PaymentNotice) src);
        if (src instanceof org.hl7.fhir.r4.model.PaymentReconciliation)
            return PaymentReconciliation40_50.convertPaymentReconciliation((org.hl7.fhir.r4.model.PaymentReconciliation) src);
        if (src instanceof org.hl7.fhir.r4.model.Person)
            return Person40_50.convertPerson((org.hl7.fhir.r4.model.Person) src);
        if (src instanceof org.hl7.fhir.r4.model.PlanDefinition)
            return PlanDefinition40_50.convertPlanDefinition((org.hl7.fhir.r4.model.PlanDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.Practitioner)
            return Practitioner40_50.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.r4.model.PractitionerRole)
            return PractitionerRole40_50.convertPractitionerRole((org.hl7.fhir.r4.model.PractitionerRole) src);
        if (src instanceof org.hl7.fhir.r4.model.Procedure)
            return Procedure40_50.convertProcedure((org.hl7.fhir.r4.model.Procedure) src);
        if (src instanceof org.hl7.fhir.r4.model.Provenance)
            return Provenance40_50.convertProvenance((org.hl7.fhir.r4.model.Provenance) src);
        if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
            return Questionnaire40_50.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
            return QuestionnaireResponse40_50.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.RelatedPerson)
            return RelatedPerson40_50.convertRelatedPerson((org.hl7.fhir.r4.model.RelatedPerson) src);
        if (src instanceof org.hl7.fhir.r4.model.RequestGroup)
            return RequestGroup40_50.convertRequestGroup((org.hl7.fhir.r4.model.RequestGroup) src);
        if (src instanceof org.hl7.fhir.r4.model.ResearchStudy)
            return ResearchStudy40_50.convertResearchStudy((org.hl7.fhir.r4.model.ResearchStudy) src);
        if (src instanceof org.hl7.fhir.r4.model.ResearchSubject)
            return ResearchSubject40_50.convertResearchSubject((org.hl7.fhir.r4.model.ResearchSubject) src);
        if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
            return RiskAssessment40_50.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.r4.model.Schedule)
            return Schedule40_50.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
        if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
            return SearchParameter40_50.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r4.model.ServiceRequest)
            return ServiceRequest40_50.convertServiceRequest((org.hl7.fhir.r4.model.ServiceRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.Slot)
            return Slot40_50.convertSlot((org.hl7.fhir.r4.model.Slot) src);
        if (src instanceof org.hl7.fhir.r4.model.Specimen)
            return Specimen40_50.convertSpecimen((org.hl7.fhir.r4.model.Specimen) src);
        if (src instanceof org.hl7.fhir.r4.model.SpecimenDefinition)
            return SpecimenDefinition40_50.convertSpecimenDefinition((org.hl7.fhir.r4.model.SpecimenDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
            return StructureDefinition40_50.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.StructureMap)
            return StructureMap40_50.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
        // if (src instanceof org.hl7.fhir.r4.model.Subscription)
        // return Subscription.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);
        if (src instanceof org.hl7.fhir.r4.model.Substance)
            return Substance40_50.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
        if (src instanceof org.hl7.fhir.r4.model.SubstanceNucleicAcid)
            return SubstanceNucleicAcid40_50.convertSubstanceNucleicAcid((org.hl7.fhir.r4.model.SubstanceNucleicAcid) src);
        if (src instanceof org.hl7.fhir.r4.model.SubstancePolymer)
            return SubstancePolymer40_50.convertSubstancePolymer((org.hl7.fhir.r4.model.SubstancePolymer) src);
        if (src instanceof org.hl7.fhir.r4.model.SubstanceProtein)
            return SubstanceProtein40_50.convertSubstanceProtein((org.hl7.fhir.r4.model.SubstanceProtein) src);
        if (src instanceof org.hl7.fhir.r4.model.SubstanceReferenceInformation)
            return SubstanceReferenceInformation40_50.convertSubstanceReferenceInformation((org.hl7.fhir.r4.model.SubstanceReferenceInformation) src);
        if (src instanceof org.hl7.fhir.r4.model.SubstanceSourceMaterial)
            return SubstanceSourceMaterial40_50.convertSubstanceSourceMaterial((org.hl7.fhir.r4.model.SubstanceSourceMaterial) src);
        if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
            return SupplyDelivery40_50.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.r4.model.SupplyRequest)
            return SupplyRequest40_50.convertSupplyRequest((org.hl7.fhir.r4.model.SupplyRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.Task)
            return Task40_50.convertTask((org.hl7.fhir.r4.model.Task) src);
        if (src instanceof org.hl7.fhir.r4.model.TerminologyCapabilities)
            return TerminologyCapabilities40_50.convertTerminologyCapabilities((org.hl7.fhir.r4.model.TerminologyCapabilities) src);
        if (src instanceof org.hl7.fhir.r4.model.TestReport)
            return TestReport40_50.convertTestReport((org.hl7.fhir.r4.model.TestReport) src);
        if (src instanceof org.hl7.fhir.r4.model.TestScript)
            return TestScript40_50.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
        if (src instanceof org.hl7.fhir.r4.model.ValueSet)
            return ValueSet40_50.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
        if (src instanceof org.hl7.fhir.r4.model.VerificationResult)
            return VerificationResult40_50.convertVerificationResult((org.hl7.fhir.r4.model.VerificationResult) src);
        if (src instanceof org.hl7.fhir.r4.model.VisionPrescription)
            return VisionPrescription40_50.convertVisionPrescription((org.hl7.fhir.r4.model.VisionPrescription) src);
        throw new Error("Unknown resource " + src.fhirType());
    }

    public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
        if (src == null)
            return null;
        if (src instanceof org.hl7.fhir.r5.model.Parameters)
            return Parameters40_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
        if (src instanceof org.hl7.fhir.r5.model.Account)
            return Account40_50.convertAccount((org.hl7.fhir.r5.model.Account) src);
        if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
            return ActivityDefinition40_50.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
        // if (src instanceof org.hl7.fhir.r5.model.AdverseEvent)
        // return AdverseEvent.convertAdverseEvent((org.hl7.fhir.r5.model.AdverseEvent) src);
        if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
            return AllergyIntolerance40_50.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
        if (src instanceof org.hl7.fhir.r5.model.Appointment)
            return Appointment40_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
        if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
            return AppointmentResponse40_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
            return AuditEvent40_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.r5.model.Basic)
            return Basic40_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
        if (src instanceof org.hl7.fhir.r5.model.Binary)
            return Binary40_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
        if (src instanceof org.hl7.fhir.r5.model.BiologicallyDerivedProduct)
            return BiologicallyDerivedProduct40_50.convertBiologicallyDerivedProduct((org.hl7.fhir.r5.model.BiologicallyDerivedProduct) src);
        if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
            return BodyStructure40_50.convertBodyStructure((org.hl7.fhir.r5.model.BodyStructure) src);
        if (src instanceof org.hl7.fhir.r5.model.Bundle)
            return Bundle40_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
        if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
            return CapabilityStatement40_50.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r5.model.CarePlan)
            return CarePlan40_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.r5.model.CareTeam)
            return CareTeam40_50.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
        // if (src instanceof org.hl7.fhir.r5.model.CatalogEntry)
        // return CatalogEntry.convertCatalogEntry((org.hl7.fhir.r5.model.CatalogEntry) src);
        if (src instanceof org.hl7.fhir.r5.model.ChargeItem)
            return ChargeItem40_50.convertChargeItem((org.hl7.fhir.r5.model.ChargeItem) src);
        if (src instanceof org.hl7.fhir.r5.model.ChargeItemDefinition)
            return ChargeItemDefinition40_50.convertChargeItemDefinition((org.hl7.fhir.r5.model.ChargeItemDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Claim)
            return Claim40_50.convertClaim((org.hl7.fhir.r5.model.Claim) src);
        if (src instanceof org.hl7.fhir.r5.model.ClaimResponse)
            return ClaimResponse40_50.convertClaimResponse((org.hl7.fhir.r5.model.ClaimResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
            return ClinicalImpression40_50.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
        if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
            return CodeSystem40_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
        if (src instanceof org.hl7.fhir.r5.model.Communication)
            return Communication40_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
        if (src instanceof org.hl7.fhir.r5.model.CommunicationRequest)
            return CommunicationRequest40_50.convertCommunicationRequest((org.hl7.fhir.r5.model.CommunicationRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
            return CompartmentDefinition40_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Composition)
            return Composition40_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
        if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
            return ConceptMap40_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r5.model.Condition)
            return Condition40_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
        if (src instanceof org.hl7.fhir.r5.model.Consent)
            return Consent40_50.convertConsent((org.hl7.fhir.r5.model.Consent) src);
        if (src instanceof org.hl7.fhir.r5.model.Contract)
            return Contract40_50.convertContract((org.hl7.fhir.r5.model.Contract) src);
        if (src instanceof org.hl7.fhir.r5.model.Coverage)
            return Coverage40_50.convertCoverage((org.hl7.fhir.r5.model.Coverage) src);
        if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityRequest)
            return CoverageEligibilityRequest40_50.convertCoverageEligibilityRequest((org.hl7.fhir.r5.model.CoverageEligibilityRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityResponse)
            return CoverageEligibilityResponse40_50.convertCoverageEligibilityResponse((org.hl7.fhir.r5.model.CoverageEligibilityResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
            return DetectedIssue40_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.r5.model.Device)
            return Device40_50.convertDevice((org.hl7.fhir.r5.model.Device) src);
        if (src instanceof org.hl7.fhir.r5.model.DeviceDefinition)
            return DeviceDefinition40_50.convertDeviceDefinition((org.hl7.fhir.r5.model.DeviceDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.DeviceMetric)
            return DeviceMetric40_50.convertDeviceMetric((org.hl7.fhir.r5.model.DeviceMetric) src);
        if (src instanceof org.hl7.fhir.r5.model.DeviceRequest)
            return DeviceRequest40_50.convertDeviceRequest((org.hl7.fhir.r5.model.DeviceRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.DeviceUseStatement)
            return DeviceUseStatement40_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
            return DiagnosticReport40_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.r5.model.DocumentManifest)
            return DocumentManifest40_50.convertDocumentManifest((org.hl7.fhir.r5.model.DocumentManifest) src);
        if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
            return DocumentReference40_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r5.model.Encounter)
            return Encounter40_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
        if (src instanceof org.hl7.fhir.r5.model.Endpoint)
            return Endpoint40_50.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
        if (src instanceof org.hl7.fhir.r5.model.EnrollmentRequest)
            return EnrollmentRequest40_50.convertEnrollmentRequest((org.hl7.fhir.r5.model.EnrollmentRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.EnrollmentResponse)
            return EnrollmentResponse40_50.convertEnrollmentResponse((org.hl7.fhir.r5.model.EnrollmentResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
            return EpisodeOfCare40_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.r5.model.EventDefinition)
            return EventDefinition40_50.convertEventDefinition((org.hl7.fhir.r5.model.EventDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.ExampleScenario)
            return ExampleScenario40_50.convertExampleScenario((org.hl7.fhir.r5.model.ExampleScenario) src);
        if (src instanceof org.hl7.fhir.r5.model.ExplanationOfBenefit)
            return ExplanationOfBenefit40_50.convertExplanationOfBenefit((org.hl7.fhir.r5.model.ExplanationOfBenefit) src);
        if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
            return FamilyMemberHistory40_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.r5.model.Flag)
            return Flag40_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
        if (src instanceof org.hl7.fhir.r5.model.Goal)
            return Goal40_50.convertGoal((org.hl7.fhir.r5.model.Goal) src);
        if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
            return GraphDefinition40_50.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Group)
            return Group40_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
        if (src instanceof org.hl7.fhir.r5.model.GuidanceResponse)
            return GuidanceResponse40_50.convertGuidanceResponse((org.hl7.fhir.r5.model.GuidanceResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
            return HealthcareService40_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
            return ImagingStudy40_50.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
        if (src instanceof org.hl7.fhir.r5.model.Immunization)
            return Immunization40_50.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
        if (src instanceof org.hl7.fhir.r5.model.ImmunizationEvaluation)
            return ImmunizationEvaluation40_50.convertImmunizationEvaluation((org.hl7.fhir.r5.model.ImmunizationEvaluation) src);
        if (src instanceof org.hl7.fhir.r5.model.ImmunizationRecommendation)
            return ImmunizationRecommendation40_50.convertImmunizationRecommendation((org.hl7.fhir.r5.model.ImmunizationRecommendation) src);
        if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
            return ImplementationGuide40_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r5.model.InsurancePlan)
            return InsurancePlan40_50.convertInsurancePlan((org.hl7.fhir.r5.model.InsurancePlan) src);
        if (src instanceof org.hl7.fhir.r5.model.Invoice)
            return Invoice40_50.convertInvoice((org.hl7.fhir.r5.model.Invoice) src);
        if (src instanceof org.hl7.fhir.r5.model.Library)
            return Library40_50.convertLibrary((org.hl7.fhir.r5.model.Library) src);
        if (src instanceof org.hl7.fhir.r5.model.Linkage)
            return Linkage40_50.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
        if (src instanceof org.hl7.fhir.r5.model.ListResource)
            return ListResource40_50.convertListResource((org.hl7.fhir.r5.model.ListResource) src);
        if (src instanceof org.hl7.fhir.r5.model.Location)
            return Location40_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
        if (src instanceof org.hl7.fhir.r5.model.Measure)
            return Measure40_50.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
        if (src instanceof org.hl7.fhir.r5.model.MeasureReport)
            return MeasureReport40_50.convertMeasureReport((org.hl7.fhir.r5.model.MeasureReport) src);
        if (// todo: will never get here (doesn't work anyway)
        src instanceof org.hl7.fhir.r5.model.DocumentReference)
            return Media40_50.convertMedia((org.hl7.fhir.r5.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r5.model.Medication)
            return Medication40_50.convertMedication((org.hl7.fhir.r5.model.Medication) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
            return MedicationAdministration40_50.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
            return MedicationDispense40_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationKnowledge)
            return MedicationKnowledge40_50.convertMedicationKnowledge((org.hl7.fhir.r5.model.MedicationKnowledge) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
            return MedicationRequest40_50.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicationUsage)
            return MedicationStatement40_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationUsage) src);
        if (src instanceof org.hl7.fhir.r5.model.MedicinalProductDefinition)
          return MedicinalProductDefinition40_50.convertMedicinalProductDefinition((org.hl7.fhir.r5.model.MedicinalProductDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
            return MessageDefinition40_50.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
            return MessageHeader40_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.r5.model.MolecularSequence)
            return MolecularSequence40_50.convertMolecularSequence((org.hl7.fhir.r5.model.MolecularSequence) src);
        if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
            return NamingSystem40_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r5.model.NutritionOrder)
            return NutritionOrder40_50.convertNutritionOrder((org.hl7.fhir.r5.model.NutritionOrder) src);
        if (src instanceof org.hl7.fhir.r5.model.Observation)
            return Observation40_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
        if (src instanceof org.hl7.fhir.r5.model.ObservationDefinition)
            return ObservationDefinition40_50.convertObservationDefinition((org.hl7.fhir.r5.model.ObservationDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
            return OperationDefinition40_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
            return OperationOutcome40_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r5.model.Organization)
            return Organization40_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
        if (src instanceof org.hl7.fhir.r5.model.OrganizationAffiliation)
            return OrganizationAffiliation40_50.convertOrganizationAffiliation((org.hl7.fhir.r5.model.OrganizationAffiliation) src);
        if (src instanceof org.hl7.fhir.r5.model.Patient)
            return Patient40_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
        if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
            return PaymentNotice40_50.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
        if (src instanceof org.hl7.fhir.r5.model.PaymentReconciliation)
            return PaymentReconciliation40_50.convertPaymentReconciliation((org.hl7.fhir.r5.model.PaymentReconciliation) src);
        if (src instanceof org.hl7.fhir.r5.model.Person)
            return Person40_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
        if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
            return PlanDefinition40_50.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.Practitioner)
            return Practitioner40_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
            return PractitionerRole40_50.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
        if (src instanceof org.hl7.fhir.r5.model.Procedure)
            return Procedure40_50.convertProcedure((org.hl7.fhir.r5.model.Procedure) src);
        if (src instanceof org.hl7.fhir.r5.model.Provenance)
            return Provenance40_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
        if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
            return Questionnaire40_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
            return QuestionnaireResponse40_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
            return RelatedPerson40_50.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
        if (src instanceof org.hl7.fhir.r5.model.RequestGroup)
            return RequestGroup40_50.convertRequestGroup((org.hl7.fhir.r5.model.RequestGroup) src);
        if (src instanceof org.hl7.fhir.r5.model.ResearchStudy)
            return ResearchStudy40_50.convertResearchStudy((org.hl7.fhir.r5.model.ResearchStudy) src);
        if (src instanceof org.hl7.fhir.r5.model.ResearchSubject)
            return ResearchSubject40_50.convertResearchSubject((org.hl7.fhir.r5.model.ResearchSubject) src);
        if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
            return RiskAssessment40_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.r5.model.Schedule)
            return Schedule40_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
        if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
            return SearchParameter40_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r5.model.ServiceRequest)
            return ServiceRequest40_50.convertServiceRequest((org.hl7.fhir.r5.model.ServiceRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.Slot)
            return Slot40_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
        if (src instanceof org.hl7.fhir.r5.model.Specimen)
            return Specimen40_50.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
        if (src instanceof org.hl7.fhir.r5.model.SpecimenDefinition)
            return SpecimenDefinition40_50.convertSpecimenDefinition((org.hl7.fhir.r5.model.SpecimenDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
            return StructureDefinition40_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r5.model.StructureMap)
            return StructureMap40_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
        // if (src instanceof org.hl7.fhir.r5.model.Subscription)
        // return Subscription.convertSubscription((org.hl7.fhir.r5.model.Subscription) src);
        if (src instanceof org.hl7.fhir.r5.model.Substance)
            return Substance40_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
        if (src instanceof org.hl7.fhir.r5.model.SubstanceNucleicAcid)
            return SubstanceNucleicAcid40_50.convertSubstanceNucleicAcid((org.hl7.fhir.r5.model.SubstanceNucleicAcid) src);
        if (src instanceof org.hl7.fhir.r5.model.SubstancePolymer)
            return SubstancePolymer40_50.convertSubstancePolymer((org.hl7.fhir.r5.model.SubstancePolymer) src);
        if (src instanceof org.hl7.fhir.r5.model.SubstanceProtein)
            return SubstanceProtein40_50.convertSubstanceProtein((org.hl7.fhir.r5.model.SubstanceProtein) src);
        if (src instanceof org.hl7.fhir.r5.model.SubstanceReferenceInformation)
            return SubstanceReferenceInformation40_50.convertSubstanceReferenceInformation((org.hl7.fhir.r5.model.SubstanceReferenceInformation) src);
        if (src instanceof org.hl7.fhir.r5.model.SubstanceSourceMaterial)
            return SubstanceSourceMaterial40_50.convertSubstanceSourceMaterial((org.hl7.fhir.r5.model.SubstanceSourceMaterial) src);
        if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
            return SupplyDelivery40_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.r5.model.SupplyRequest)
            return SupplyRequest40_50.convertSupplyRequest((org.hl7.fhir.r5.model.SupplyRequest) src);
        if (src instanceof org.hl7.fhir.r5.model.Task)
            return Task40_50.convertTask((org.hl7.fhir.r5.model.Task) src);
        if (src instanceof org.hl7.fhir.r5.model.TerminologyCapabilities)
            return TerminologyCapabilities40_50.convertTerminologyCapabilities((org.hl7.fhir.r5.model.TerminologyCapabilities) src);
        if (src instanceof org.hl7.fhir.r5.model.TestReport)
            return TestReport40_50.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
        if (src instanceof org.hl7.fhir.r5.model.TestScript)
            return TestScript40_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
        if (src instanceof org.hl7.fhir.r5.model.ValueSet)
            return ValueSet40_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
        if (src instanceof org.hl7.fhir.r5.model.VerificationResult)
            return VerificationResult40_50.convertVerificationResult((org.hl7.fhir.r5.model.VerificationResult) src);
        if (src instanceof org.hl7.fhir.r5.model.VisionPrescription)
            return VisionPrescription40_50.convertVisionPrescription((org.hl7.fhir.r5.model.VisionPrescription) src);
        throw new Error("Unknown resource " + src.fhirType());
    }

    protected static org.hl7.fhir.r5.model.CodeType convertResourceEnum(org.hl7.fhir.r4.model.CodeType src) {
        return convertCode(src);
    }

    protected static org.hl7.fhir.r4.model.CodeType convertResourceEnum(org.hl7.fhir.r5.model.CodeType src) {
        return convertCode(src);
    }

    protected static CodeableReference convertReferenceToCodeableReference(org.hl7.fhir.r4.model.Reference src) {
        CodeableReference tgt = new CodeableReference();
        tgt.setReference(convertReference(src));
        return tgt;
    }

    protected static CodeableReference convertCodeableConceptToCodeableReference(org.hl7.fhir.r4.model.CodeableConcept src) {
        CodeableReference tgt = new CodeableReference();
        tgt.setConcept(convertCodeableConcept(src));
        return tgt;
    }
}