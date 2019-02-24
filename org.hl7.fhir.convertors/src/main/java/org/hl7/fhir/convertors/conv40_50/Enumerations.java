package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class Enumerations extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.r4.model.Enumerations.BindingStrength src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REQUIRED: return org.hl7.fhir.r5.model.Enumerations.BindingStrength.REQUIRED;
    case EXTENSIBLE: return org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXTENSIBLE;
    case PREFERRED: return org.hl7.fhir.r5.model.Enumerations.BindingStrength.PREFERRED;
    case EXAMPLE: return org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXAMPLE;
    default: return org.hl7.fhir.r5.model.Enumerations.BindingStrength.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.r5.model.Enumerations.BindingStrength src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REQUIRED: return org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED;
    case EXTENSIBLE: return org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE;
    case PREFERRED: return org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED;
    case EXAMPLE: return org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE;
    default: return org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.PublicationStatus convertPublicationStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE;
    case RETIRED: return org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED;
    case UNKNOWN: return org.hl7.fhir.r5.model.Enumerations.PublicationStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.PublicationStatus convertPublicationStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE;
    case RETIRED: return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED;
    case UNKNOWN: return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.FHIRVersion convertFHIRVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case _0_01: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_01;
    case _0_05: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_05;
    case _0_06: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_06;
    case _0_11: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_11;
    case _0_0_80: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_80;
    case _0_0_81: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_81;
    case _0_0_82: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_82;
    case _0_4_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_4_0;
    case _0_5_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_5_0;
    case _1_0_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_0;
    case _1_0_1: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_1;
    case _1_0_2: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_2;
    case _1_1_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_1_0;
    case _1_4_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_4_0;
    case _1_6_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_6_0;
    case _1_8_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_8_0;
    case _3_0_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_0;
    case _3_0_1: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_1;
    case _3_3_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_3_0;
    case _3_5_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_5_0;
    case _4_0_0: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_0_0;
    default: return org.hl7.fhir.r5.model.Enumerations.FHIRVersion.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.FHIRVersion convertFHIRVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case _0_01: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_01;
    case _0_05: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_05;
    case _0_06: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_06;
    case _0_11: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_11;
    case _0_0_80: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_0_80;
    case _0_0_81: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_0_81;
    case _0_0_82: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_0_82;
    case _0_4_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_4_0;
    case _0_5_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._0_5_0;
    case _1_0_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_0_0;
    case _1_0_1: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_0_1;
    case _1_0_2: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_0_2;
    case _1_1_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_1_0;
    case _1_4_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_4_0;
    case _1_6_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_6_0;
    case _1_8_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._1_8_0;
    case _3_0_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_0_0;
    case _3_0_1: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_0_1;
    case _3_3_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_3_0;
    case _3_5_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._3_5_0;
    case _4_0_0: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion._4_0_0;
    default: return org.hl7.fhir.r4.model.Enumerations.FHIRVersion.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.r4.model.Enumerations.SearchParamType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NUMBER: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.NUMBER;
    case DATE: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.DATE;
    case STRING: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.STRING;
    case TOKEN: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.TOKEN;
    case REFERENCE: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.REFERENCE;
    case COMPOSITE: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.COMPOSITE;
    case QUANTITY: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.QUANTITY;
    case URI: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.URI;
    case SPECIAL: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.SPECIAL;
    default: return org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.r5.model.Enumerations.SearchParamType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NUMBER: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.NUMBER;
    case DATE: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.DATE;
    case STRING: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.STRING;
    case TOKEN: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.TOKEN;
    case REFERENCE: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.REFERENCE;
    case COMPOSITE: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.COMPOSITE;
    case QUANTITY: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.QUANTITY;
    case URI: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.URI;
    case SPECIAL: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.SPECIAL;
    default: return org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.NoteType convertNoteType(org.hl7.fhir.r4.model.Enumerations.NoteType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DISPLAY: return org.hl7.fhir.r5.model.Enumerations.NoteType.DISPLAY;
    case PRINT: return org.hl7.fhir.r5.model.Enumerations.NoteType.PRINT;
    case PRINTOPER: return org.hl7.fhir.r5.model.Enumerations.NoteType.PRINTOPER;
    default: return org.hl7.fhir.r5.model.Enumerations.NoteType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.NoteType convertNoteType(org.hl7.fhir.r5.model.Enumerations.NoteType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DISPLAY: return org.hl7.fhir.r4.model.Enumerations.NoteType.DISPLAY;
    case PRINT: return org.hl7.fhir.r4.model.Enumerations.NoteType.PRINT;
    case PRINTOPER: return org.hl7.fhir.r4.model.Enumerations.NoteType.PRINTOPER;
    default: return org.hl7.fhir.r4.model.Enumerations.NoteType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case RELATEDTO: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.RELATEDTO;
    case EQUIVALENT: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
    case EQUAL: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.EQUAL;
    case WIDER: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.WIDER;
    case SUBSUMES: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.SUBSUMES;
    case NARROWER: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.NARROWER;
    case SPECIALIZES: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.SPECIALIZES;
    case INEXACT: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.INEXACT;
    case UNMATCHED: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.UNMATCHED;
    case DISJOINT: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.DISJOINT;
    default: return org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.r5.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case RELATEDTO: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.RELATEDTO;
    case EQUIVALENT: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
    case EQUAL: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUAL;
    case WIDER: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.WIDER;
    case SUBSUMES: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.SUBSUMES;
    case NARROWER: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NARROWER;
    case SPECIALIZES: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.SPECIALIZES;
    case INEXACT: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.INEXACT;
    case UNMATCHED: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED;
    case DISJOINT: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.DISJOINT;
    default: return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus convertDocumentReferenceStatus(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CURRENT: return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.CURRENT;
    case SUPERSEDED: return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.SUPERSEDED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus convertDocumentReferenceStatus(org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CURRENT: return org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.CURRENT;
    case SUPERSEDED: return org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.SUPERSEDED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.AdministrativeGender convertAdministrativeGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MALE: return org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.MALE;
    case FEMALE: return org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.FEMALE;
    case OTHER: return org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.OTHER;
    case UNKNOWN: return org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.AdministrativeGender convertAdministrativeGender(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MALE: return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE;
    case FEMALE: return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE;
    case OTHER: return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER;
    case UNKNOWN: return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.NULL;
  }
}


}
