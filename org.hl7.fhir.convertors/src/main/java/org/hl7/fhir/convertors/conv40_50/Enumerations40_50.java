package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class Enumerations40_50 extends VersionConvertor_40_50 {

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.BindingStrengthEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED);
                break;
            case EXTENSIBLE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE);
                break;
            case PREFERRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> convertFHIRVersion(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FHIRVersionEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> convertFHIRVersion(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.FHIRVersionEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case _0_01:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_01);
                break;
            case _0_05:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_05);
                break;
            case _0_06:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_06);
                break;
            case _0_11:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_11);
                break;
            case _0_0_80:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_0_80);
                break;
            case _0_0_81:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_0_81);
                break;
            case _0_0_82:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_0_82);
                break;
            case _0_4_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_4_0);
                break;
            case _0_5_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_5_0);
                break;
            case _1_0_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_0_0);
                break;
            case _1_0_1:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_0_1);
                break;
            case _1_0_2:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_0_2);
                break;
            case _1_1_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_1_0);
                break;
            case _1_4_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_4_0);
                break;
            case _1_6_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_6_0);
                break;
            case _1_8_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_8_0);
                break;
            case _3_0_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_0_0);
                break;
            case _3_0_1:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_0_1);
                break;
            case _3_0_2:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_0_2);
                break;
            case _3_3_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_3_0);
                break;
            case _3_5_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_5_0);
                break;
            case _4_0_0:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._4_0_0);
                break;
            case _4_0_1:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion._4_0_1);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case SPECIAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.SPECIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.SearchParamTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NUMBER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NUMBER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.DATE);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.STRING);
                break;
            case TOKEN:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.TOKEN);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.REFERENCE);
                break;
            case COMPOSITE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.COMPOSITE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.QUANTITY);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.URI);
                break;
            case SPECIAL:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.SPECIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.NoteType> convertNoteType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.NoteType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.NoteType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.NoteTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.NoteType.DISPLAY);
                break;
            case PRINT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.NoteType.PRINT);
                break;
            case PRINTOPER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.NoteType.PRINTOPER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.NoteType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.NoteType> convertNoteType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.NoteType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.NoteType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.NoteTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.NoteType.DISPLAY);
                break;
            case PRINT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.NoteType.PRINT);
                break;
            case PRINTOPER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.NoteType.PRINTOPER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.NoteType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationshipEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case RELATEDTO:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO);
                break;
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
                break;
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
                break;
            case WIDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
                break;
            case SUBSUMES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
                break;
            case NARROWER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
                break;
            case SPECIALIZES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
                break;
            case INEXACT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO);
                break;
            case UNMATCHED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
                break;
            case DISJOINT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NOTRELATEDTO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case RELATEDTO:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.RELATEDTO);
                break;
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                break;
            case SOURCEISNARROWERTHANTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.WIDER);
                break;
            case SOURCEISBROADERTHANTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NARROWER);
                break;
            case NOTRELATEDTO:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.CURRENT);
                break;
            case SUPERSEDED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.CURRENT);
                break;
            case SUPERSEDED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.AdministrativeGenderEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MALE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE);
                break;
            case FEMALE:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.NULL);
                break;
        }
        return tgt;
    }
}