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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * Common Interface declaration for conformance and knowledge artifact resources.
 */
public abstract class MetadataResource extends CanonicalResource {

    private static final long serialVersionUID = 0L;

  /**
   * Constructor
   */
    public MetadataResource() {
      super();
    }

    /**
     * How many allowed for this property by the implementation
     */
    public int getApprovalDateMax() { 
      return 1;
    }
    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public abstract DateType getApprovalDateElement(); 

    public abstract boolean hasApprovalDateElement(); 
    public abstract boolean hasApprovalDate(); 

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public abstract MetadataResource setApprovalDateElement(DateType value); 
    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public abstract Date getApprovalDate(); 
    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public abstract MetadataResource setApprovalDate(Date value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getLastReviewDateMax() { 
      return 1;
    }
    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public abstract DateType getLastReviewDateElement(); 

    public abstract boolean hasLastReviewDateElement(); 
    public abstract boolean hasLastReviewDate(); 

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public abstract MetadataResource setLastReviewDateElement(DateType value); 
    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public abstract Date getLastReviewDate(); 
    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public abstract MetadataResource setLastReviewDate(Date value); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getEffectivePeriodMax() { 
      return 1;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the metadata resource content was or is planned to be in active use.)
     */
    public abstract Period getEffectivePeriod(); 
    public abstract boolean hasEffectivePeriod(); 
    /**
     * @param value {@link #effectivePeriod} (The period during which the metadata resource content was or is planned to be in active use.)
     */
    public abstract MetadataResource setEffectivePeriod(Period value); 

    /**
     * How many allowed for this property by the implementation
     */
    public int getTopicMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the metadata resource. Topics provide a high-level categorization as well as keywords for the metadata resource that can be useful for filtering and searching.)
     */
    public abstract List<CodeableConcept> getTopic(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract MetadataResource setTopic(List<CodeableConcept> theTopic); 
    public abstract boolean hasTopic(); 

    public abstract CodeableConcept addTopic(); //3
    public abstract MetadataResource addTopic(CodeableConcept t); //3
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {1}
     */
    public abstract CodeableConcept getTopicFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getAuthorMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the metadata resource.)
     */
    public abstract List<ContactDetail> getAuthor(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract MetadataResource setAuthor(List<ContactDetail> theAuthor); 
    public abstract boolean hasAuthor(); 

    public abstract ContactDetail addAuthor(); //3
    public abstract MetadataResource addAuthor(ContactDetail t); //3
    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {1}
     */
    public abstract ContactDetail getAuthorFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getEditorMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the metadata resource.)
     */
    public abstract List<ContactDetail> getEditor(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract MetadataResource setEditor(List<ContactDetail> theEditor); 
    public abstract boolean hasEditor(); 

    public abstract ContactDetail addEditor(); //3
    public abstract MetadataResource addEditor(ContactDetail t); //3
    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {1}
     */
    public abstract ContactDetail getEditorFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getReviewerMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #reviewer} (An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the metadata resource.)
     */
    public abstract List<ContactDetail> getReviewer(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract MetadataResource setReviewer(List<ContactDetail> theReviewer); 
    public abstract boolean hasReviewer(); 

    public abstract ContactDetail addReviewer(); //3
    public abstract MetadataResource addReviewer(ContactDetail t); //3
    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {1}
     */
    public abstract ContactDetail getReviewerFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getEndorserMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #endorser} (An individual or organization asserted by the publisher to be responsible for officially endorsing the metadata resource for use in some setting.)
     */
    public abstract List<ContactDetail> getEndorser(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract MetadataResource setEndorser(List<ContactDetail> theEndorser); 
    public abstract boolean hasEndorser(); 

    public abstract ContactDetail addEndorser(); //3
    public abstract MetadataResource addEndorser(ContactDetail t); //3
    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {1}
     */
    public abstract ContactDetail getEndorserFirstRep(); 
    /**
     * How many allowed for this property by the implementation
     */
    public int getRelatedArtifactMax() { 
      return Integer.MAX_VALUE;
    }
    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.)
     */
    public abstract List<RelatedArtifact> getRelatedArtifact(); 
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public abstract MetadataResource setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact); 
    public abstract boolean hasRelatedArtifact(); 

    public abstract RelatedArtifact addRelatedArtifact(); //3
    public abstract MetadataResource addRelatedArtifact(RelatedArtifact t); //3
    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {1}
     */
    public abstract RelatedArtifact getRelatedArtifactFirstRep(); 
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
    return "MetadataResource";

  }

      public abstract MetadataResource copy();

      public void copyValues(MetadataResource dst) {
        super.copyValues(dst);
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MetadataResource))
          return false;
        MetadataResource o = (MetadataResource) other_;
        return true;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MetadataResource))
          return false;
        MetadataResource o = (MetadataResource) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty();
      }


}

