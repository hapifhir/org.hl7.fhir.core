package org.hl7.fhir.r5.model;

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

// Generated on Tue, May 7, 2019 08:21+1000 for FHIR v4.1.0

import java.util.*;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;
import org.hl7.fhir.instance.model.api.*;
import org.hl7.fhir.exceptions.FHIRException;
/**
 * A pattern to be followed by resources that represent a specific proposal, plan and/or order for some sort of action or service.
 */
public interface Definition extends PatternBase {

    /**
     * @return {@link #url} (An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement();

    public boolean hasUrlElement();

    public boolean hasUrl();

    /**
     * @param value {@link #url} (An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Definition setUrlElement(UriType value) ;

    /**
     * @return An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public String getUrl();

    /**
     * @param value An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public Definition setUrl(String value);

    /**
     * @return {@link #identifier} (Business identifiers assigned to this {{title}} by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public Identifier getIdentifier();

    public boolean hasIdentifier();

    /**
     * @param value {@link #identifier} (Business identifiers assigned to this {{title}} by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public Definition setIdentifier(Identifier value);

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement();

    public boolean hasVersionElement();

    public boolean hasVersion();

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Definition setVersionElement(StringType value) ;

    /**
     * @return The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public String getVersion();

    /**
     * @param value The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public Definition setVersion(String value);

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement();

    public boolean hasTitleElement();

    public boolean hasTitle();

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Definition setTitleElement(StringType value) ;

    /**
     * @return A short, descriptive, user-friendly title for the {{title}}.
     */
    public String getTitle();

    /**
     * @param value A short, descriptive, user-friendly title for the {{title}}.
     */
    public Definition setTitle(String value);

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<CanonicalType> getDerivedFromCanonical();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical);

    public boolean hasDerivedFromCanonical();

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public CanonicalType addDerivedFromCanonicalElement();

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public Definition addDerivedFromCanonical(String value);

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromCanonical(String value) ;

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<UriType> getDerivedFromUri();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setDerivedFromUri(List<UriType> theDerivedFromUri);

    public boolean hasDerivedFromUri();

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public UriType addDerivedFromUriElement();

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public Definition addDerivedFromUri(String value);

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromUri(String value) ;

    /**
     * @return {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public List<CanonicalType> getPartOf();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setPartOf(List<CanonicalType> thePartOf);

    public boolean hasPartOf();

    /**
     * @return {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public CanonicalType addPartOfElement();

    /**
     * @param value {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public Definition addPartOf(String value);

    /**
     * @param value {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public boolean hasPartOf(String value) ;

    /**
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public List<CanonicalType> getReplaces();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setReplaces(List<CanonicalType> theReplaces);

    public boolean hasReplaces();

    /**
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public CanonicalType addReplacesElement();

    /**
     * @param value {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public Definition addReplaces(String value);

    /**
     * @param value {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public boolean hasReplaces(String value) ;

    /**
     * @return {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement();

    public boolean hasStatusElement();

    public boolean hasStatus();

    /**
     * @param value {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Definition setStatusElement(Enumeration<PublicationStatus> value) ;

    /**
     * @return The current state of the {{title}}.
     */
    public PublicationStatus getStatus();

    /**
     * @param value The current state of the {{title}}.
     */
    public Definition setStatus(PublicationStatus value);

    /**
     * @return {@link #experimental} (A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement();

    public boolean hasExperimentalElement();

    public boolean hasExperimental();

    /**
     * @param value {@link #experimental} (A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Definition setExperimentalElement(BooleanType value) ;

    /**
     * @return A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public boolean getExperimental();

    /**
     * @param value A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public Definition setExperimental(boolean value);

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of instantiations of this definition.)
     */
    public Type getSubject();

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of instantiations of this definition.)
     */
    public CodeableConcept getSubjectCodeableConcept() throws FHIRException;

    public boolean hasSubjectCodeableConcept();

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of instantiations of this definition.)
     */
    public Reference getSubjectReference() throws FHIRException;

    public boolean hasSubjectReference();

    public boolean hasSubject();

    /**
     * @param value {@link #subject} (A code or group definition that describes the intended subject of instantiations of this definition.)
     */
    public Definition setSubject(Type value);

    /**
     * @return {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement();

    public boolean hasDateElement();

    public boolean hasDate();

    /**
     * @param value {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Definition setDateElement(DateTimeType value) ;

    /**
     * @return For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Date getDate();

    /**
     * @param value For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Definition setDate(Date value);

    /**
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the {{title}}.  May also allow for contact.)
     */
    public Reference getPublisher();

    public boolean hasPublisher();

    /**
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the {{title}}.  May also allow for contact.)
     */
    public Definition setPublisher(Reference value);

    /**
     * @return {@link #publisher} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Helps establish the "authority/credibility" of the {{title}}.  May also allow for contact.)
     */
    public Resource getPublisherTarget();

    /**
     * @param value {@link #publisher} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Helps establish the "authority/credibility" of the {{title}}.  May also allow for contact.)
     */
    public Definition setPublisherTarget(Resource value);

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setContact(List<ContactDetail> theContact);

    public boolean hasContact();

    public ContactDetail addContact();

    public Definition addContact(ContactDetail t);

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist
     */
    public ContactDetail getContactFirstRep() ;

    /**
     * @return {@link #description} (A free text natural language description of the {{title}} from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement();

    public boolean hasDescriptionElement();

    public boolean hasDescription();

    /**
     * @param value {@link #description} (A free text natural language description of the {{title}} from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Definition setDescriptionElement(MarkdownType value) ;

    /**
     * @return A free text natural language description of the {{title}} from the consumer's perspective.
     */
    public String getDescription();

    /**
     * @param value A free text natural language description of the {{title}} from the consumer's perspective.
     */
    public Definition setDescription(String value);

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.)
     */
    public List<UsageContext> getUseContext();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setUseContext(List<UsageContext> theUseContext);

    public boolean hasUseContext();

    public UsageContext addUseContext();

    public Definition addUseContext(UsageContext t);

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist
     */
    public UsageContext getUseContextFirstRep() ;

    /**
     * @return {@link #jurisdiction} (A jurisdiction in which the {{title}} is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction();

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setJurisdiction(List<CodeableConcept> theJurisdiction);

    public boolean hasJurisdiction();

    public CodeableConcept addJurisdiction();

    public Definition addJurisdiction(CodeableConcept t);

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist
     */
    public CodeableConcept getJurisdictionFirstRep() ;

    /**
     * @return {@link #purpose} (Explains why this {{title}} is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement();

    public boolean hasPurposeElement();

    public boolean hasPurpose();

    /**
     * @param value {@link #purpose} (Explains why this {{title}} is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Definition setPurposeElement(MarkdownType value) ;

    /**
     * @return Explains why this {{title}} is needed and why it has been designed as it has.
     */
    public String getPurpose();

    /**
     * @param value Explains why this {{title}} is needed and why it has been designed as it has.
     */
    public Definition setPurpose(String value);

    /**
     * @return {@link #copyright} (A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement();

    public boolean hasCopyrightElement();

    public boolean hasCopyright();

    /**
     * @param value {@link #copyright} (A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Definition setCopyrightElement(MarkdownType value) ;

    /**
     * @return A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.
     */
    public String getCopyright();

    /**
     * @param value A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.
     */
    public Definition setCopyright(String value);

    /**
     * @return {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement();

    public boolean hasApprovalDateElement();

    public boolean hasApprovalDate();

    /**
     * @param value {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public Definition setApprovalDateElement(DateType value) ;

    /**
     * @return The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate();

    /**
     * @param value The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Definition setApprovalDate(Date value);

    /**
     * @return {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement();

    public boolean hasLastReviewDateElement();

    public boolean hasLastReviewDate();

    /**
     * @param value {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public Definition setLastReviewDateElement(DateType value) ;

    /**
     * @return The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Date getLastReviewDate();

    /**
     * @param value The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Definition setLastReviewDate(Date value);

    /**
     * @return {@link #effectivePeriod} (The period during which the {{title}} content was or is planned to be effective.)
     */
    public Period getEffectivePeriod();

    public boolean hasEffectivePeriod();

    /**
     * @param value {@link #effectivePeriod} (The period during which the {{title}} content was or is planned to be effective.)
     */
    public Definition setEffectivePeriod(Period value);

    /**
     * @return {@link #performerType} (The type of individual that is expected to act upon instances of this definition.)
     */
    public CodeableConcept getPerformerType();

    public boolean hasPerformerType();

    /**
     * @param value {@link #performerType} (The type of individual that is expected to act upon instances of this definition.)
     */
    public Definition setPerformerType(CodeableConcept value);

  public String fhirType();


}

