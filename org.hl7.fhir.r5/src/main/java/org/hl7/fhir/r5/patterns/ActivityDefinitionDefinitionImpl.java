package org.hl7.fhir.r5.patterns;




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

// Generated on Wed, May 8, 2019 10:40+1000 for FHIR v4.1.0

import java.util.*;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;

public class ActivityDefinitionDefinitionImpl extends PatternBaseImpl implements Definition {

  private ActivityDefinition wrapped;

  public ActivityDefinitionDefinitionImpl(ActivityDefinition wrapped) {
    super(wrapped);
    this.wrapped = wrapped;
  }

    public int getUrlMin() {
      return 0;
    }

    public int getUrlMax() {
      return 1;
    }

    public UriType getUrlElement() throws FHIRException {
      return wrapped.getUrlElement();
    }


    public boolean hasUrlElement() {
      return wrapped.hasUrlElement();
    }


    public boolean hasUrl() {
      return wrapped.hasUrl();
    }


    public Definition setUrlElement(UriType value) throws FHIRException {
      wrapped.setUrlElement(value);
      return this;

    }


    public String getUrl() throws FHIRException {
      return wrapped.getUrl();
    }

    public Definition setUrl(String value) throws FHIRException {
      wrapped.setUrl(value);
      return this;

}

    public int getIdentifierMin() {
      return 0;
    }

    public int getIdentifierMax() {
      return 2147483647;
    }

    public Identifier getIdentifier() throws FHIRException {
      return wrapped.getIdentifierFirstRep();
    }

    public boolean hasIdentifier() {
      return wrapped.hasIdentifier();
    }

    public Definition setIdentifier(Identifier value) throws FHIRException {
      wrapped.getIdentifier().clear();
      if (value != null)
        wrapped.getIdentifier().add(value);
      return this;

    }

    public int getVersionMin() {
      return 0;
    }

    public int getVersionMax() {
      return 1;
    }

    public StringType getVersionElement() throws FHIRException {
      return wrapped.getVersionElement();
    }


    public boolean hasVersionElement() {
      return wrapped.hasVersionElement();
    }


    public boolean hasVersion() {
      return wrapped.hasVersion();
    }


    public Definition setVersionElement(StringType value) throws FHIRException {
      wrapped.setVersionElement(value);
      return this;

    }


    public String getVersion() throws FHIRException {
      return wrapped.getVersion();
    }

    public Definition setVersion(String value) throws FHIRException {
      wrapped.setVersion(value);
      return this;

}

    public int getTitleMin() {
      return 0;
    }

    public int getTitleMax() {
      return 1;
    }

    public StringType getTitleElement() throws FHIRException {
      return wrapped.getTitleElement();
    }


    public boolean hasTitleElement() {
      return wrapped.hasTitleElement();
    }


    public boolean hasTitle() {
      return wrapped.hasTitle();
    }


    public Definition setTitleElement(StringType value) throws FHIRException {
      wrapped.setTitleElement(value);
      return this;

    }


    public String getTitle() throws FHIRException {
      return wrapped.getTitle();
    }

    public Definition setTitle(String value) throws FHIRException {
      wrapped.setTitle(value);
      return this;

}

    public int getDerivedFromCanonicalMin() {
      return 0;
    }

    public int getDerivedFromCanonicalMax() {
      return 0;
    }

    public List<CanonicalType> getDerivedFromCanonical() throws FHIRException {
      throw new FHIRException("The pattern property 'derivedFromCanonical' is not supported in 'ActivityDefinition'");
    }

    public Definition setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical) throws FHIRException {

      throw new FHIRException("The pattern property 'derivedFromCanonical' is not supported in 'ActivityDefinition'");
    }

    public boolean hasDerivedFromCanonical() {
      return false;
    }


    public CanonicalType addDerivedFromCanonicalElement() throws FHIRException {
      throw new FHIRException("The pattern property 'derivedFromCanonical' is not supported in 'ActivityDefinition'");
    }


    public Definition addDerivedFromCanonical(String value) throws FHIRException {
      throw new FHIRException("The pattern property 'derivedFromCanonical' is not supported in 'ActivityDefinition'");
    }


    public boolean hasDerivedFromCanonical(String value) {
      return false;
    }


    public int getDerivedFromUriMin() {
      return 0;
    }

    public int getDerivedFromUriMax() {
      return 0;
    }

    public List<UriType> getDerivedFromUri() throws FHIRException {
      throw new FHIRException("The pattern property 'derivedFromUri' is not supported in 'ActivityDefinition'");
    }

    public Definition setDerivedFromUri(List<UriType> theDerivedFromUri) throws FHIRException {

      throw new FHIRException("The pattern property 'derivedFromUri' is not supported in 'ActivityDefinition'");
    }

    public boolean hasDerivedFromUri() {
      return false;
    }


    public UriType addDerivedFromUriElement() throws FHIRException {
      throw new FHIRException("The pattern property 'derivedFromUri' is not supported in 'ActivityDefinition'");
    }


    public Definition addDerivedFromUri(String value) throws FHIRException {
      throw new FHIRException("The pattern property 'derivedFromUri' is not supported in 'ActivityDefinition'");
    }


    public boolean hasDerivedFromUri(String value) {
      return false;
    }


    public int getPartOfMin() {
      return 0;
    }

    public int getPartOfMax() {
      return 0;
    }

    public List<CanonicalType> getPartOf() throws FHIRException {
      throw new FHIRException("The pattern property 'partOf' is not supported in 'ActivityDefinition'");
    }

    public Definition setPartOf(List<CanonicalType> thePartOf) throws FHIRException {

      throw new FHIRException("The pattern property 'partOf' is not supported in 'ActivityDefinition'");
    }

    public boolean hasPartOf() {
      return false;
    }


    public CanonicalType addPartOfElement() throws FHIRException {
      throw new FHIRException("The pattern property 'partOf' is not supported in 'ActivityDefinition'");
    }


    public Definition addPartOf(String value) throws FHIRException {
      throw new FHIRException("The pattern property 'partOf' is not supported in 'ActivityDefinition'");
    }


    public boolean hasPartOf(String value) {
      return false;
    }


    public int getReplacesMin() {
      return 0;
    }

    public int getReplacesMax() {
      return 0;
    }

    public List<CanonicalType> getReplaces() throws FHIRException {
      throw new FHIRException("The pattern property 'replaces' is not supported in 'ActivityDefinition'");
    }

    public Definition setReplaces(List<CanonicalType> theReplaces) throws FHIRException {

      throw new FHIRException("The pattern property 'replaces' is not supported in 'ActivityDefinition'");
    }

    public boolean hasReplaces() {
      return false;
    }


    public CanonicalType addReplacesElement() throws FHIRException {
      throw new FHIRException("The pattern property 'replaces' is not supported in 'ActivityDefinition'");
    }


    public Definition addReplaces(String value) throws FHIRException {
      throw new FHIRException("The pattern property 'replaces' is not supported in 'ActivityDefinition'");
    }


    public boolean hasReplaces(String value) {
      return false;
    }


    public int getStatusMin() {
      return 0;
    }

    public int getStatusMax() {
      return 0;
    }

    public Enumeration<PublicationStatus> getStatusElement() throws FHIRException {
      throw new FHIRException("The pattern property 'status' is not supported in 'ActivityDefinition'");
    }


    public boolean hasStatusElement() {
      return false;
    }


    public boolean hasStatus() {
      return false;
    }


    public Definition setStatusElement(Enumeration<PublicationStatus> value) throws FHIRException {
      throw new FHIRException("The pattern property 'status' is not supported in 'ActivityDefinition'");
    }


    public PublicationStatus getStatus() throws FHIRException {
      throw new FHIRException("The pattern property 'status' is not supported in 'ActivityDefinition'");
    }

    public Definition setStatus(PublicationStatus value) throws FHIRException {
      throw new FHIRException("The pattern property 'status' is not supported in 'ActivityDefinition'");
}

    public int getExperimentalMin() {
      return 0;
    }

    public int getExperimentalMax() {
      return 1;
    }

    public BooleanType getExperimentalElement() throws FHIRException {
      return wrapped.getExperimentalElement();
    }


    public boolean hasExperimentalElement() {
      return wrapped.hasExperimentalElement();
    }


    public boolean hasExperimental() {
      return wrapped.hasExperimental();
    }


    public Definition setExperimentalElement(BooleanType value) throws FHIRException {
      wrapped.setExperimentalElement(value);
      return this;

    }


    public boolean getExperimental() throws FHIRException {
      return wrapped.getExperimental();
    }

    public Definition setExperimental(boolean value) throws FHIRException {
      wrapped.setExperimental(value);
      return this;

}

    public int getSubjectMin() {
      return 0;
    }

    public int getSubjectMax() {
      return 0;
    }

    public DataType getSubject() throws FHIRException {
      throw new FHIRException("The pattern property 'subject[x]' is not supported in 'ActivityDefinition'");
    }

    public CodeableConcept getSubjectCodeableConcept() throws FHIRException {
      throw new FHIRException("The pattern property 'subject[x]' is not supported in 'ActivityDefinition'");
    }

    public boolean hasSubjectCodeableConcept() { 
      return false;
    }

    public Reference getSubjectReference() throws FHIRException {
      throw new FHIRException("The pattern property 'subject[x]' is not supported in 'ActivityDefinition'");
    }

    public boolean hasSubjectReference() { 
      return false;
    }

    public boolean hasSubject() {
      return false;
    }

    public Definition setSubject(DataType value) throws FHIRException {
      throw new FHIRException("The pattern property 'subject[x]' is not supported in 'ActivityDefinition'");
    }

    public int getDateMin() {
      return 0;
    }

    public int getDateMax() {
      return 1;
    }

    public DateTimeType getDateElement() throws FHIRException {
      return wrapped.getDateElement();
    }


    public boolean hasDateElement() {
      return wrapped.hasDateElement();
    }


    public boolean hasDate() {
      return wrapped.hasDate();
    }


    public Definition setDateElement(DateTimeType value) throws FHIRException {
      wrapped.setDateElement(value);
      return this;

    }


    public Date getDate() throws FHIRException {
      return wrapped.getDate();
    }

    public Definition setDate(Date value) throws FHIRException {
      wrapped.setDate(value);
      return this;

}

    public int getPublisherMin() {
      return 0;
    }

    public int getPublisherMax() {
      return 0;
    }

    public Reference getPublisher() throws FHIRException {
      throw new FHIRException("The pattern property 'publisher' is not supported in 'ActivityDefinition'");
    }

    public boolean hasPublisher() {
      return false;
    }

    public Definition setPublisher(Reference value) throws FHIRException {
      throw new FHIRException("The pattern property 'publisher' is not supported in 'ActivityDefinition'");
    }

    public int getContactMin() {
      return 0;
    }

    public int getContactMax() {
      return 2147483647;
    }

    public List<ContactDetail> getContact() throws FHIRException {
      return wrapped.getContact();
    }

    public Definition setContact(List<ContactDetail> theContact) throws FHIRException {

      wrapped.setContact(theContact);
      return this;

    }

    public boolean hasContact() {
      return wrapped.hasContact();
    }


    public ContactDetail addContact() throws FHIRException {
      throw new FHIRException("The pattern property 'contact' is not supported in 'ActivityDefinition'");
    }


    public Definition addContact(ContactDetail t) throws FHIRException {
      throw new FHIRException("The pattern property 'contact' is not supported in 'ActivityDefinition'");
    }


    public ContactDetail getContactFirstRep() throws FHIRException {

      return wrapped.getContactFirstRep();
    }

    public int getDescriptionMin() {
      return 0;
    }

    public int getDescriptionMax() {
      return 1;
    }

    public MarkdownType getDescriptionElement() throws FHIRException {
      return wrapped.getDescriptionElement();
    }


    public boolean hasDescriptionElement() {
      return wrapped.hasDescriptionElement();
    }


    public boolean hasDescription() {
      return wrapped.hasDescription();
    }


    public Definition setDescriptionElement(MarkdownType value) throws FHIRException {
      wrapped.setDescriptionElement(value);
      return this;

    }


    public String getDescription() throws FHIRException {
      return wrapped.getDescription();
    }

    public Definition setDescription(String value) throws FHIRException {
      wrapped.setDescription(value);
      return this;

}

    public int getUseContextMin() {
      return 0;
    }

    public int getUseContextMax() {
      return 2147483647;
    }

    public List<UsageContext> getUseContext() throws FHIRException {
      return wrapped.getUseContext();
    }

    public Definition setUseContext(List<UsageContext> theUseContext) throws FHIRException {

      wrapped.setUseContext(theUseContext);
      return this;

    }

    public boolean hasUseContext() {
      return wrapped.hasUseContext();
    }


    public UsageContext addUseContext() throws FHIRException {
      throw new FHIRException("The pattern property 'useContext' is not supported in 'ActivityDefinition'");
    }


    public Definition addUseContext(UsageContext t) throws FHIRException {
      throw new FHIRException("The pattern property 'useContext' is not supported in 'ActivityDefinition'");
    }


    public UsageContext getUseContextFirstRep() throws FHIRException {

      return wrapped.getUseContextFirstRep();
    }

    public int getJurisdictionMin() {
      return 0;
    }

    public int getJurisdictionMax() {
      return 2147483647;
    }

    public List<CodeableConcept> getJurisdiction() throws FHIRException {
      return wrapped.getJurisdiction();
    }

    public Definition setJurisdiction(List<CodeableConcept> theJurisdiction) throws FHIRException {

      wrapped.setJurisdiction(theJurisdiction);
      return this;

    }

    public boolean hasJurisdiction() {
      return wrapped.hasJurisdiction();
    }


    public CodeableConcept addJurisdiction() throws FHIRException {
      throw new FHIRException("The pattern property 'jurisdiction' is not supported in 'ActivityDefinition'");
    }


    public Definition addJurisdiction(CodeableConcept t) throws FHIRException {
      throw new FHIRException("The pattern property 'jurisdiction' is not supported in 'ActivityDefinition'");
    }


    public CodeableConcept getJurisdictionFirstRep() throws FHIRException {

      return wrapped.getJurisdictionFirstRep();
    }

    public int getPurposeMin() {
      return 0;
    }

    public int getPurposeMax() {
      return 1;
    }

    public MarkdownType getPurposeElement() throws FHIRException {
      return wrapped.getPurposeElement();
    }


    public boolean hasPurposeElement() {
      return wrapped.hasPurposeElement();
    }


    public boolean hasPurpose() {
      return wrapped.hasPurpose();
    }


    public Definition setPurposeElement(MarkdownType value) throws FHIRException {
      wrapped.setPurposeElement(value);
      return this;

    }


    public String getPurpose() throws FHIRException {
      return wrapped.getPurpose();
    }

    public Definition setPurpose(String value) throws FHIRException {
      wrapped.setPurpose(value);
      return this;

}

    public int getCopyrightMin() {
      return 0;
    }

    public int getCopyrightMax() {
      return 1;
    }

    public MarkdownType getCopyrightElement() throws FHIRException {
      return wrapped.getCopyrightElement();
    }


    public boolean hasCopyrightElement() {
      return wrapped.hasCopyrightElement();
    }


    public boolean hasCopyright() {
      return wrapped.hasCopyright();
    }


    public Definition setCopyrightElement(MarkdownType value) throws FHIRException {
      wrapped.setCopyrightElement(value);
      return this;

    }


    public String getCopyright() throws FHIRException {
      return wrapped.getCopyright();
    }

    public Definition setCopyright(String value) throws FHIRException {
      wrapped.setCopyright(value);
      return this;

}

    public int getApprovalDateMin() {
      return 0;
    }

    public int getApprovalDateMax() {
      return 1;
    }

    public DateType getApprovalDateElement() throws FHIRException {
      return wrapped.getApprovalDateElement();
    }


    public boolean hasApprovalDateElement() {
      return wrapped.hasApprovalDateElement();
    }


    public boolean hasApprovalDate() {
      return wrapped.hasApprovalDate();
    }


    public Definition setApprovalDateElement(DateType value) throws FHIRException {
      wrapped.setApprovalDateElement(value);
      return this;

    }


    public Date getApprovalDate() throws FHIRException {
      return wrapped.getApprovalDate();
    }

    public Definition setApprovalDate(Date value) throws FHIRException {
      wrapped.setApprovalDate(value);
      return this;

}

    public int getLastReviewDateMin() {
      return 0;
    }

    public int getLastReviewDateMax() {
      return 1;
    }

    public DateType getLastReviewDateElement() throws FHIRException {
      return wrapped.getLastReviewDateElement();
    }


    public boolean hasLastReviewDateElement() {
      return wrapped.hasLastReviewDateElement();
    }


    public boolean hasLastReviewDate() {
      return wrapped.hasLastReviewDate();
    }


    public Definition setLastReviewDateElement(DateType value) throws FHIRException {
      wrapped.setLastReviewDateElement(value);
      return this;

    }


    public Date getLastReviewDate() throws FHIRException {
      return wrapped.getLastReviewDate();
    }

    public Definition setLastReviewDate(Date value) throws FHIRException {
      wrapped.setLastReviewDate(value);
      return this;

}

    public int getEffectivePeriodMin() {
      return 0;
    }

    public int getEffectivePeriodMax() {
      return 1;
    }

    public Period getEffectivePeriod() throws FHIRException {
      return wrapped.getEffectivePeriod();
    }

    public boolean hasEffectivePeriod() {
      return wrapped.hasEffectivePeriod();
    }

    public Definition setEffectivePeriod(Period value) throws FHIRException {
      wrapped.setEffectivePeriod(value);
      return this;

    }

    public int getPerformerTypeMin() {
      return 0;
    }

    public int getPerformerTypeMax() {
      return 0;
    }

    public CodeableConcept getPerformerType() throws FHIRException {
      throw new FHIRException("The pattern property 'performerType' is not supported in 'ActivityDefinition'");
    }

    public boolean hasPerformerType() {
      return false;
    }

    public Definition setPerformerType(CodeableConcept value) throws FHIRException {
      throw new FHIRException("The pattern property 'performerType' is not supported in 'ActivityDefinition'");
    }

  public String fhirType() {
     return "ActivityDefinition";
}


}