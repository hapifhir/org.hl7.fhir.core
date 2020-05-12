package org.hl7.fhir.r5.model;




/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Common Ancestor declaration for conformance and knowledge artifact resources.
 */
public abstract class CanonicalResource extends DomainResource {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public CanonicalResource() {
      super();
    }

  /**
   * Constructor
   */
    public CanonicalResource(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * How many allowed for this property by the implementation
     */
    public int getUrlMax() { 
      return 1;
    }
    /**
     * @return {@link #url} (An absolute URI that is used to identify this canonical resource when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this canonical resource is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the canonical resource is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public abstract UriType getUrlElement(); 

    public abstract boolean hasUrlElement(); 
    public abstract boolean hasUrl(); 

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this canonical resource when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this canonical resource is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the canonical resource is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public abstract CanonicalResource setUrlElement(UriType value); 
    /**
     * @return An absolute URI that is used to identify this canonical resource when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this canonical resource is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the canonical resource is stored on different servers.
     */
    public abstract String getUrl(); 
    /**
     * @param value An absolute URI that is used to identify this canonical resource when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this canonical resource is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the canonical resource is stored on different servers.
     */
    public abstract CanonicalResource setUrl(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getIdentifierMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this canonical resource when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public abstract List<Identifier> getIdentifier(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract CanonicalResource setIdentifier(List<Identifier> theIdentifier); 
    public abstract boolean hasIdentifier(); 

    public abstract Identifier addIdentifier(); //3
    public abstract CanonicalResource addIdentifier(Identifier t); //3
    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {1}
     */
    public abstract Identifier getIdentifierFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getVersionMax() { 
      return 1;
    }
    /**
     * @return {@link #version} (The identifier that is used to identify this version of the canonical resource when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the canonical resource author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public abstract StringType getVersionElement(); 

    public abstract boolean hasVersionElement(); 
    public abstract boolean hasVersion(); 

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the canonical resource when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the canonical resource author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public abstract CanonicalResource setVersionElement(StringType value); 
    /**
     * @return The identifier that is used to identify this version of the canonical resource when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the canonical resource author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public abstract String getVersion(); 
    /**
     * @param value The identifier that is used to identify this version of the canonical resource when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the canonical resource author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public abstract CanonicalResource setVersion(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getNameMax() { 
      return 1;
    }
    /**
     * @return {@link #name} (A natural language name identifying the canonical resource. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public abstract StringType getNameElement(); 

    public abstract boolean hasNameElement(); 
    public abstract boolean hasName(); 

    /**
     * @param value {@link #name} (A natural language name identifying the canonical resource. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public abstract CanonicalResource setNameElement(StringType value); 
    /**
     * @return A natural language name identifying the canonical resource. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public abstract String getName(); 
    /**
     * @param value A natural language name identifying the canonical resource. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public abstract CanonicalResource setName(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getTitleMax() { 
      return 1;
    }
    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the canonical resource.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public abstract StringType getTitleElement(); 

    public abstract boolean hasTitleElement(); 
    public abstract boolean hasTitle(); 

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the canonical resource.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public abstract CanonicalResource setTitleElement(StringType value); 
    /**
     * @return A short, descriptive, user-friendly title for the canonical resource.
     */
    public abstract String getTitle(); 
    /**
     * @param value A short, descriptive, user-friendly title for the canonical resource.
     */
    public abstract CanonicalResource setTitle(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getStatusMax() { 
      return 1;
    }
    /**
     * @return {@link #status} (The status of this canonical resource. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public abstract Enumeration<PublicationStatus> getStatusElement(); 

    public abstract boolean hasStatusElement(); 
    public abstract boolean hasStatus(); 

    /**
     * @param value {@link #status} (The status of this canonical resource. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public abstract CanonicalResource setStatusElement(Enumeration<PublicationStatus> value); 
    /**
     * @return The status of this canonical resource. Enables tracking the life-cycle of the content.
     */
    public abstract PublicationStatus getStatus(); 
    /**
     * @param value The status of this canonical resource. Enables tracking the life-cycle of the content.
     */
    public abstract CanonicalResource setStatus(PublicationStatus value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getExperimentalMax() { 
      return 1;
    }
    /**
     * @return {@link #experimental} (A Boolean value to indicate that this canonical resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public abstract BooleanType getExperimentalElement(); 

    public abstract boolean hasExperimentalElement(); 
    public abstract boolean hasExperimental(); 

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this canonical resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public abstract CanonicalResource setExperimentalElement(BooleanType value); 
    /**
     * @return A Boolean value to indicate that this canonical resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public abstract boolean getExperimental(); 
    /**
     * @param value A Boolean value to indicate that this canonical resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public abstract CanonicalResource setExperimental(boolean value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getDateMax() { 
      return 1;
    }
    /**
     * @return {@link #date} (The date  (and optionally time) when the canonical resource was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the canonical resource changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public abstract DateTimeType getDateElement(); 

    public abstract boolean hasDateElement(); 
    public abstract boolean hasDate(); 

    /**
     * @param value {@link #date} (The date  (and optionally time) when the canonical resource was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the canonical resource changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public abstract CanonicalResource setDateElement(DateTimeType value); 
    /**
     * @return The date  (and optionally time) when the canonical resource was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the canonical resource changes.
     */
    public abstract Date getDate(); 
    /**
     * @param value The date  (and optionally time) when the canonical resource was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the canonical resource changes.
     */
    public abstract CanonicalResource setDate(Date value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getPublisherMax() { 
      return 1;
    }
    /**
     * @return {@link #publisher} (The name of the organization or individual that published the canonical resource.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public abstract StringType getPublisherElement(); 

    public abstract boolean hasPublisherElement(); 
    public abstract boolean hasPublisher(); 

    /**
     * @param value {@link #publisher} (The name of the organization or individual that published the canonical resource.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public abstract CanonicalResource setPublisherElement(StringType value); 
    /**
     * @return The name of the organization or individual that published the canonical resource.
     */
    public abstract String getPublisher(); 
    /**
     * @param value The name of the organization or individual that published the canonical resource.
     */
    public abstract CanonicalResource setPublisher(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getContactMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public abstract List<ContactDetail> getContact(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract CanonicalResource setContact(List<ContactDetail> theContact); 
    public abstract boolean hasContact(); 

    public abstract ContactDetail addContact(); //3
    public abstract CanonicalResource addContact(ContactDetail t); //3
    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {1}
     */
    public abstract ContactDetail getContactFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getDescriptionMax() { 
      return 1;
    }
    /**
     * @return {@link #description} (A free text natural language description of the canonical resource from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public abstract MarkdownType getDescriptionElement(); 

    public abstract boolean hasDescriptionElement(); 
    public abstract boolean hasDescription(); 

    /**
     * @param value {@link #description} (A free text natural language description of the canonical resource from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public abstract CanonicalResource setDescriptionElement(MarkdownType value); 
    /**
     * @return A free text natural language description of the canonical resource from a consumer's perspective.
     */
    public abstract String getDescription(); 
    /**
     * @param value A free text natural language description of the canonical resource from a consumer's perspective.
     */
    public abstract CanonicalResource setDescription(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getUseContextMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate canonical resource instances.)
     */
    public abstract List<UsageContext> getUseContext(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract CanonicalResource setUseContext(List<UsageContext> theUseContext); 
    public abstract boolean hasUseContext(); 

    public abstract UsageContext addUseContext(); //3
    public abstract CanonicalResource addUseContext(UsageContext t); //3
    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {1}
     */
    public abstract UsageContext getUseContextFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getJurisdictionMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the canonical resource is intended to be used.)
     */
    public abstract List<CodeableConcept> getJurisdiction(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract CanonicalResource setJurisdiction(List<CodeableConcept> theJurisdiction); 
    public abstract boolean hasJurisdiction(); 

    public abstract CodeableConcept addJurisdiction(); //3
    public abstract CanonicalResource addJurisdiction(CodeableConcept t); //3
    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {1}
     */
    public abstract CodeableConcept getJurisdictionFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getPurposeMax() { 
      return 1;
    }
    /**
     * @return {@link #purpose} (Explanation of why this canonical resource is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public abstract MarkdownType getPurposeElement(); 

    public abstract boolean hasPurposeElement(); 
    public abstract boolean hasPurpose(); 

    /**
     * @param value {@link #purpose} (Explanation of why this canonical resource is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public abstract CanonicalResource setPurposeElement(MarkdownType value); 
    /**
     * @return Explanation of why this canonical resource is needed and why it has been designed as it has.
     */
    public abstract String getPurpose(); 
    /**
     * @param value Explanation of why this canonical resource is needed and why it has been designed as it has.
     */
    public abstract CanonicalResource setPurpose(String value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getCopyrightMax() { 
      return 1;
    }
    /**
     * @return {@link #copyright} (A copyright statement relating to the canonical resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the canonical resource.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public abstract MarkdownType getCopyrightElement(); 

    public abstract boolean hasCopyrightElement(); 
    public abstract boolean hasCopyright(); 

    /**
     * @param value {@link #copyright} (A copyright statement relating to the canonical resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the canonical resource.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public abstract CanonicalResource setCopyrightElement(MarkdownType value); 
    /**
     * @return A copyright statement relating to the canonical resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the canonical resource.
     */
    public abstract String getCopyright(); 
    /**
     * @param value A copyright statement relating to the canonical resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the canonical resource.
     */
    public abstract CanonicalResource setCopyright(String value); 
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
          return super.setProperty(name, value);
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
          return super.addChild(name);
      }

  public String fhirType() {
    return "CanonicalResource";

  }

      public abstract CanonicalResource copy();

      public void copyValues(CanonicalResource dst) {
        super.copyValues(dst);
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CanonicalResource))
          return false;
        CanonicalResource o = (CanonicalResource) other_;
        return true;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CanonicalResource))
          return false;
        CanonicalResource o = (CanonicalResource) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty();
      }

// Manual code (from Configuration.txt)t:
      @Override
      public String toString() {
        return fhirType()+"["+getUrl()+"]";
      }
      
      public String present() {
        if (hasTitle())
          return getTitle();
        if (hasName())
          return getName();
        return toString();
      }      

// end addition

}