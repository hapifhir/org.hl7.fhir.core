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
public class ListResource40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ListResource convertListResource(org.hl7.fhir.r4.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ListResource tgt = new org.hl7.fhir.r5.model.ListResource();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ListResource convertListResource(org.hl7.fhir.r5.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ListResource tgt = new org.hl7.fhir.r4.model.ListResource();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ListResource.ListStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ListResource.ListStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.CURRENT);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.RETIRED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ListResource.ListStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.CURRENT);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.RETIRED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> convertListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ListModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> convertListMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ListResource.ListModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent convertListEntryComponent(org.hl7.fhir.r4.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent tgt = new org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent();
        copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(convertCodeableConcept(src.getFlag()));
        if (src.hasDeleted())
            tgt.setDeletedElement(convertBoolean(src.getDeletedElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(convertReference(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ListResource.ListEntryComponent convertListEntryComponent(org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.r4.model.ListResource.ListEntryComponent();
        copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(convertCodeableConcept(src.getFlag()));
        if (src.hasDeleted())
            tgt.setDeletedElement(convertBoolean(src.getDeletedElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(convertReference(src.getItem()));
        return tgt;
    }
}