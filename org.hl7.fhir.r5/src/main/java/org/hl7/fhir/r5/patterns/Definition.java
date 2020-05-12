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

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumeration;
import java.util.*;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
/**
 * A pattern to be followed by resources that represent a specific proposal, plan and/or order for some sort of action or service.
 */
public interface Definition extends PatternBase {

    /**
     * @return {@link #url} (An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for url
     */
    public boolean hasUrl();
    /**
     * @return minimum allowed cardinality for url. Note that with patterns, this may be different for the underlying resource
     */
    public int getUrlMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for url. Note that with patterns, this may be different for the underlying resource
     */
    public int getUrlMax() throws FHIRException;
    public boolean hasUrlElement();

    /**
     * @param value {@link #url} (An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Definition setUrlElement(UriType value) throws FHIRException;

    /**
     * @return An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public String getUrl() throws FHIRException;

    /**
     * @param value An absolute URL that is used to identify this {{title}} when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this {{title}} is (or will be) published. The URL SHOULD include the major version of the {{title}}. For more information see [Technical and Business Versions](resource.html#versions).
     */
    public Definition setUrl(String value) throws FHIRException;

    /**
     * @return {@link #identifier} (Business identifiers assigned to this {{title}} by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public Identifier getIdentifier() throws FHIRException ;

    /**
     * @return whether there is more than zero values for identifier
     */
    public boolean hasIdentifier();
    /**
     * @return minimum allowed cardinality for identifier. Note that with patterns, this may be different for the underlying resource
     */
    public int getIdentifierMin();
    /**
     * @return maximum allowed cardinality for identifier. Note that with patterns, this may be different for the underlying resource
     */
    public int getIdentifierMax();
    /**
     * @param value {@link #identifier} (Business identifiers assigned to this {{title}} by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public Definition setIdentifier(Identifier value) throws FHIRException;

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for version
     */
    public boolean hasVersion();
    /**
     * @return minimum allowed cardinality for version. Note that with patterns, this may be different for the underlying resource
     */
    public int getVersionMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for version. Note that with patterns, this may be different for the underlying resource
     */
    public int getVersionMax() throws FHIRException;
    public boolean hasVersionElement();

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Definition setVersionElement(StringType value) throws FHIRException;

    /**
     * @return The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public String getVersion() throws FHIRException;

    /**
     * @param value The identifier that is used to identify this version of the {{title}} when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the {{title}} author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions are orderable.
     */
    public Definition setVersion(String value) throws FHIRException;

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for title
     */
    public boolean hasTitle();
    /**
     * @return minimum allowed cardinality for title. Note that with patterns, this may be different for the underlying resource
     */
    public int getTitleMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for title. Note that with patterns, this may be different for the underlying resource
     */
    public int getTitleMax() throws FHIRException;
    public boolean hasTitleElement();

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Definition setTitleElement(StringType value) throws FHIRException;

    /**
     * @return A short, descriptive, user-friendly title for the {{title}}.
     */
    public String getTitle() throws FHIRException;

    /**
     * @param value A short, descriptive, user-friendly title for the {{title}}.
     */
    public Definition setTitle(String value) throws FHIRException;

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<CanonicalType> getDerivedFromCanonical() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical) throws FHIRException;

    /**
     * @return whether there is more than zero values for derivedFromCanonical
     */
    public boolean hasDerivedFromCanonical();
    /**
     * @return minimum allowed cardinality for derivedFromCanonical. Note that with patterns, this may be different for the underlying resource
     */
    public int getDerivedFromCanonicalMin();
    /**
     * @return maximum allowed cardinality for derivedFromCanonical. Note that with patterns, this may be different for the underlying resource
     */
    public int getDerivedFromCanonicalMax();

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public CanonicalType addDerivedFromCanonicalElement() throws FHIRException;

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public Definition addDerivedFromCanonical(String value) throws FHIRException;

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromCanonical(String value)  throws FHIRException;

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<UriType> getDerivedFromUri() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setDerivedFromUri(List<UriType> theDerivedFromUri) throws FHIRException;

    /**
     * @return whether there is more than zero values for derivedFromUri
     */
    public boolean hasDerivedFromUri();
    /**
     * @return minimum allowed cardinality for derivedFromUri. Note that with patterns, this may be different for the underlying resource
     */
    public int getDerivedFromUriMin();
    /**
     * @return maximum allowed cardinality for derivedFromUri. Note that with patterns, this may be different for the underlying resource
     */
    public int getDerivedFromUriMax();

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public UriType addDerivedFromUriElement() throws FHIRException;

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public Definition addDerivedFromUri(String value) throws FHIRException;

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromUri(String value)  throws FHIRException;

    /**
     * @return {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public List<CanonicalType> getPartOf() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setPartOf(List<CanonicalType> thePartOf) throws FHIRException;

    /**
     * @return whether there is more than zero values for partOf
     */
    public boolean hasPartOf();
    /**
     * @return minimum allowed cardinality for partOf. Note that with patterns, this may be different for the underlying resource
     */
    public int getPartOfMin();
    /**
     * @return maximum allowed cardinality for partOf. Note that with patterns, this may be different for the underlying resource
     */
    public int getPartOfMax();

    /**
     * @return {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public CanonicalType addPartOfElement() throws FHIRException;

    /**
     * @param value {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public Definition addPartOf(String value) throws FHIRException;

    /**
     * @param value {@link #partOf} (A larger definition of which this particular definition is a component or step.)
     */
    public boolean hasPartOf(String value)  throws FHIRException;

    /**
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public List<CanonicalType> getReplaces() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setReplaces(List<CanonicalType> theReplaces) throws FHIRException;

    /**
     * @return whether there is more than zero values for replaces
     */
    public boolean hasReplaces();
    /**
     * @return minimum allowed cardinality for replaces. Note that with patterns, this may be different for the underlying resource
     */
    public int getReplacesMin();
    /**
     * @return maximum allowed cardinality for replaces. Note that with patterns, this may be different for the underlying resource
     */
    public int getReplacesMax();

    /**
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public CanonicalType addReplacesElement() throws FHIRException;

    /**
     * @param value {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public Definition addReplaces(String value) throws FHIRException;

    /**
     * @param value {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public boolean hasReplaces(String value)  throws FHIRException;

    /**
     * @return {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for status
     */
    public boolean hasStatus();
    /**
     * @return minimum allowed cardinality for status. Note that with patterns, this may be different for the underlying resource
     */
    public int getStatusMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for status. Note that with patterns, this may be different for the underlying resource
     */
    public int getStatusMax() throws FHIRException;
    public boolean hasStatusElement();

    /**
     * @param value {@link #status} (The current state of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Definition setStatusElement(Enumeration<PublicationStatus> value) throws FHIRException;

    /**
     * @return The current state of the {{title}}.
     */
    public PublicationStatus getStatus() throws FHIRException;

    /**
     * @param value The current state of the {{title}}.
     */
    public Definition setStatus(PublicationStatus value) throws FHIRException;

    /**
     * @return {@link #experimental} (A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for experimental
     */
    public boolean hasExperimental();
    /**
     * @return minimum allowed cardinality for experimental. Note that with patterns, this may be different for the underlying resource
     */
    public int getExperimentalMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for experimental. Note that with patterns, this may be different for the underlying resource
     */
    public int getExperimentalMax() throws FHIRException;
    public boolean hasExperimentalElement();

    /**
     * @param value {@link #experimental} (A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Definition setExperimentalElement(BooleanType value) throws FHIRException;

    /**
     * @return A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() throws FHIRException;

    /**
     * @param value A flag to indicate that this {{title}} is authored for testing purposes (or education/evaluation/marketing), and is not intended to be used for genuine usage.
     */
    public Definition setExperimental(boolean value) throws FHIRException;

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of instantiations of this definition.)
     */
    public DataType getSubject() throws FHIRException ;

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

    /**
     * @return whether there is more than zero values for subject
     */
    public boolean hasSubject();
    /**
     * @return minimum allowed cardinality for subject. Note that with patterns, this may be different for the underlying resource
     */
    public int getSubjectMin();
    /**
     * @return maximum allowed cardinality for subject. Note that with patterns, this may be different for the underlying resource
     */
    public int getSubjectMax();
    /**
     * @param value {@link #subject} (A code or group definition that describes the intended subject of instantiations of this definition.)
     */
    public Definition setSubject(DataType value) throws FHIRException;

    /**
     * @return {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for date
     */
    public boolean hasDate();
    /**
     * @return minimum allowed cardinality for date. Note that with patterns, this may be different for the underlying resource
     */
    public int getDateMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for date. Note that with patterns, this may be different for the underlying resource
     */
    public int getDateMax() throws FHIRException;
    public boolean hasDateElement();

    /**
     * @param value {@link #date} (For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Definition setDateElement(DateTimeType value) throws FHIRException;

    /**
     * @return For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Date getDate() throws FHIRException;

    /**
     * @param value For draft definitions, indicates the date of initial creation.  For active definitions, represents the date of activation.  For withdrawn definitions, indicates the date of withdrawal.
     */
    public Definition setDate(Date value) throws FHIRException;

    /**
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the {{title}}.  May also allow for contact.)
     */
    public Reference getPublisher() throws FHIRException ;

    /**
     * @return whether there is more than zero values for publisher
     */
    public boolean hasPublisher();
    /**
     * @return minimum allowed cardinality for publisher. Note that with patterns, this may be different for the underlying resource
     */
    public int getPublisherMin();
    /**
     * @return maximum allowed cardinality for publisher. Note that with patterns, this may be different for the underlying resource
     */
    public int getPublisherMax();
    /**
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the {{title}}.  May also allow for contact.)
     */
    public Definition setPublisher(Reference value) throws FHIRException;

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setContact(List<ContactDetail> theContact) throws FHIRException;

    /**
     * @return whether there is more than zero values for contact
     */
    public boolean hasContact();
    /**
     * @return minimum allowed cardinality for contact. Note that with patterns, this may be different for the underlying resource
     */
    public int getContactMin();
    /**
     * @return maximum allowed cardinality for contact. Note that with patterns, this may be different for the underlying resource
     */
    public int getContactMax();

    public ContactDetail addContact() throws FHIRException;

    public Definition addContact(ContactDetail t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist
     */
    public ContactDetail getContactFirstRep() throws FHIRException;

    /**
     * @return {@link #description} (A free text natural language description of the {{title}} from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for description
     */
    public boolean hasDescription();
    /**
     * @return minimum allowed cardinality for description. Note that with patterns, this may be different for the underlying resource
     */
    public int getDescriptionMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for description. Note that with patterns, this may be different for the underlying resource
     */
    public int getDescriptionMax() throws FHIRException;
    public boolean hasDescriptionElement();

    /**
     * @param value {@link #description} (A free text natural language description of the {{title}} from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Definition setDescriptionElement(MarkdownType value) throws FHIRException;

    /**
     * @return A free text natural language description of the {{title}} from the consumer's perspective.
     */
    public String getDescription() throws FHIRException;

    /**
     * @param value A free text natural language description of the {{title}} from the consumer's perspective.
     */
    public Definition setDescription(String value) throws FHIRException;

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of code system definitions.)
     */
    public List<UsageContext> getUseContext() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setUseContext(List<UsageContext> theUseContext) throws FHIRException;

    /**
     * @return whether there is more than zero values for useContext
     */
    public boolean hasUseContext();
    /**
     * @return minimum allowed cardinality for useContext. Note that with patterns, this may be different for the underlying resource
     */
    public int getUseContextMin();
    /**
     * @return maximum allowed cardinality for useContext. Note that with patterns, this may be different for the underlying resource
     */
    public int getUseContextMax();

    public UsageContext addUseContext() throws FHIRException;

    public Definition addUseContext(UsageContext t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist
     */
    public UsageContext getUseContextFirstRep() throws FHIRException;

    /**
     * @return {@link #jurisdiction} (A jurisdiction in which the {{title}} is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() throws FHIRException;

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Definition setJurisdiction(List<CodeableConcept> theJurisdiction) throws FHIRException;

    /**
     * @return whether there is more than zero values for jurisdiction
     */
    public boolean hasJurisdiction();
    /**
     * @return minimum allowed cardinality for jurisdiction. Note that with patterns, this may be different for the underlying resource
     */
    public int getJurisdictionMin();
    /**
     * @return maximum allowed cardinality for jurisdiction. Note that with patterns, this may be different for the underlying resource
     */
    public int getJurisdictionMax();

    public CodeableConcept addJurisdiction() throws FHIRException;

    public Definition addJurisdiction(CodeableConcept t) throws FHIRException;

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist
     */
    public CodeableConcept getJurisdictionFirstRep() throws FHIRException;

    /**
     * @return {@link #purpose} (Explains why this {{title}} is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for purpose
     */
    public boolean hasPurpose();
    /**
     * @return minimum allowed cardinality for purpose. Note that with patterns, this may be different for the underlying resource
     */
    public int getPurposeMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for purpose. Note that with patterns, this may be different for the underlying resource
     */
    public int getPurposeMax() throws FHIRException;
    public boolean hasPurposeElement();

    /**
     * @param value {@link #purpose} (Explains why this {{title}} is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Definition setPurposeElement(MarkdownType value) throws FHIRException;

    /**
     * @return Explains why this {{title}} is needed and why it has been designed as it has.
     */
    public String getPurpose() throws FHIRException;

    /**
     * @param value Explains why this {{title}} is needed and why it has been designed as it has.
     */
    public Definition setPurpose(String value) throws FHIRException;

    /**
     * @return {@link #copyright} (A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for copyright
     */
    public boolean hasCopyright();
    /**
     * @return minimum allowed cardinality for copyright. Note that with patterns, this may be different for the underlying resource
     */
    public int getCopyrightMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for copyright. Note that with patterns, this may be different for the underlying resource
     */
    public int getCopyrightMax() throws FHIRException;
    public boolean hasCopyrightElement();

    /**
     * @param value {@link #copyright} (A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Definition setCopyrightElement(MarkdownType value) throws FHIRException;

    /**
     * @return A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.
     */
    public String getCopyright() throws FHIRException;

    /**
     * @param value A copyright statement relating to the {{title}} and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the {{title}}.
     */
    public Definition setCopyright(String value) throws FHIRException;

    /**
     * @return {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for approvalDate
     */
    public boolean hasApprovalDate();
    /**
     * @return minimum allowed cardinality for approvalDate. Note that with patterns, this may be different for the underlying resource
     */
    public int getApprovalDateMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for approvalDate. Note that with patterns, this may be different for the underlying resource
     */
    public int getApprovalDateMax() throws FHIRException;
    public boolean hasApprovalDateElement();

    /**
     * @param value {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public Definition setApprovalDateElement(DateType value) throws FHIRException;

    /**
     * @return The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() throws FHIRException;

    /**
     * @param value The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Definition setApprovalDate(Date value) throws FHIRException;

    /**
     * @return {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() throws FHIRException;

    /**
     * @return whether there is more than zero values for lastReviewDate
     */
    public boolean hasLastReviewDate();
    /**
     * @return minimum allowed cardinality for lastReviewDate. Note that with patterns, this may be different for the underlying resource
     */
    public int getLastReviewDateMin() throws FHIRException;
    /**
     * @return maximum allowed cardinality for lastReviewDate. Note that with patterns, this may be different for the underlying resource
     */
    public int getLastReviewDateMax() throws FHIRException;
    public boolean hasLastReviewDateElement();

    /**
     * @param value {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public Definition setLastReviewDateElement(DateType value) throws FHIRException;

    /**
     * @return The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Date getLastReviewDate() throws FHIRException;

    /**
     * @param value The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Definition setLastReviewDate(Date value) throws FHIRException;

    /**
     * @return {@link #effectivePeriod} (The period during which the {{title}} content was or is planned to be effective.)
     */
    public Period getEffectivePeriod() throws FHIRException ;

    /**
     * @return whether there is more than zero values for effectivePeriod
     */
    public boolean hasEffectivePeriod();
    /**
     * @return minimum allowed cardinality for effectivePeriod. Note that with patterns, this may be different for the underlying resource
     */
    public int getEffectivePeriodMin();
    /**
     * @return maximum allowed cardinality for effectivePeriod. Note that with patterns, this may be different for the underlying resource
     */
    public int getEffectivePeriodMax();
    /**
     * @param value {@link #effectivePeriod} (The period during which the {{title}} content was or is planned to be effective.)
     */
    public Definition setEffectivePeriod(Period value) throws FHIRException;

    /**
     * @return {@link #performerType} (The type of individual that is expected to act upon instances of this definition.)
     */
    public CodeableConcept getPerformerType() throws FHIRException ;

    /**
     * @return whether there is more than zero values for performerType
     */
    public boolean hasPerformerType();
    /**
     * @return minimum allowed cardinality for performerType. Note that with patterns, this may be different for the underlying resource
     */
    public int getPerformerTypeMin();
    /**
     * @return maximum allowed cardinality for performerType. Note that with patterns, this may be different for the underlying resource
     */
    public int getPerformerTypeMax();
    /**
     * @param value {@link #performerType} (The type of individual that is expected to act upon instances of this definition.)
     */
    public Definition setPerformerType(CodeableConcept value) throws FHIRException;

  public String fhirType();


}