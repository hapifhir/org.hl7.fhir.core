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
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Base StructureDefinition for CodeableReference Type: A reference to a resource (by instance), or instead, a reference to a cencept defined in a terminology or ontology (by class).
 */
@DatatypeDef(name="CodeableReference")
public class CodeableReference extends DataType implements ICompositeType {

    /**
     * A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.
     */
    @Child(name = "concept", type = {CodeableConcept.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to a concept (by class)", formalDefinition="A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology." )
    protected CodeableConcept concept;

    /**
     * A reference to a resource the provides exact details about the information being referenced.
     */
    @Child(name = "reference", type = {Reference.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to a resource (by instance)", formalDefinition="A reference to a resource the provides exact details about the information being referenced." )
    protected Reference reference;

    private static final long serialVersionUID = 2070287445L;

  /**
   * Constructor
   */
    public CodeableReference() {
      super();
    }

    /**
     * @return {@link #concept} (A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.)
     */
    public CodeableConcept getConcept() { 
      if (this.concept == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CodeableReference.concept");
        else if (Configuration.doAutoCreate())
          this.concept = new CodeableConcept(); // cc
      return this.concept;
    }

    public boolean hasConcept() { 
      return this.concept != null && !this.concept.isEmpty();
    }

    /**
     * @param value {@link #concept} (A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.)
     */
    public CodeableReference setConcept(CodeableConcept value) { 
      this.concept = value;
      return this;
    }

    /**
     * @return {@link #reference} (A reference to a resource the provides exact details about the information being referenced.)
     */
    public Reference getReference() { 
      if (this.reference == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CodeableReference.reference");
        else if (Configuration.doAutoCreate())
          this.reference = new Reference(); // cc
      return this.reference;
    }

    public boolean hasReference() { 
      return this.reference != null && !this.reference.isEmpty();
    }

    /**
     * @param value {@link #reference} (A reference to a resource the provides exact details about the information being referenced.)
     */
    public CodeableReference setReference(Reference value) { 
      this.reference = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("concept", "CodeableConcept", "A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.", 0, 1, concept));
        children.add(new Property("reference", "Reference", "A reference to a resource the provides exact details about the information being referenced.", 0, 1, reference));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 951024232: /*concept*/  return new Property("concept", "CodeableConcept", "A reference to a concept - e.g. the information is identified by it's general classto the degree of precision found in the terminology.", 0, 1, concept);
        case -925155509: /*reference*/  return new Property("reference", "Reference", "A reference to a resource the provides exact details about the information being referenced.", 0, 1, reference);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 951024232: /*concept*/ return this.concept == null ? new Base[0] : new Base[] {this.concept}; // CodeableConcept
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 951024232: // concept
          this.concept = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("concept")) {
          this.concept = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951024232:  return getConcept();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951024232: /*concept*/ return new String[] {"CodeableConcept"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("concept")) {
          this.concept = new CodeableConcept();
          return this.concept;
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CodeableReference";

  }

      public CodeableReference copy() {
        CodeableReference dst = new CodeableReference();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CodeableReference dst) {
        super.copyValues(dst);
        dst.concept = concept == null ? null : concept.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      protected CodeableReference typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CodeableReference))
          return false;
        CodeableReference o = (CodeableReference) other_;
        return compareDeep(concept, o.concept, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CodeableReference))
          return false;
        CodeableReference o = (CodeableReference) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(concept, reference);
      }


}