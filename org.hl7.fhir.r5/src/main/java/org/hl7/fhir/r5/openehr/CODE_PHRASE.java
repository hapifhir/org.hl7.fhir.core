package org.hl7.fhir.r5.openehr;


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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * A fully coordinated (i.e. all coordination has been performed) term from a terminology service (as distinct from a particular terminology).
 */
@DatatypeDef(name="CODE_PHRASE")
public class CODE_PHRASE extends LogicalBase implements ICompositeType {

    /**
     * Identifier of the distinct terminology from which the code_string (or its elements) was extracted.
     */
    @Child(name = "terminology_id", type = {TERMINOLOGY_ID.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of the distinct terminology from which the code_string was extracted", formalDefinition="Identifier of the distinct terminology from which the code_string (or its elements) was extracted." )
    protected TERMINOLOGY_ID terminology_id;

    /**
     * The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.
     */
    @Child(name = "code_string", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The key used by the terminology service to identify a concept or coordination of concepts", formalDefinition="The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context." )
    protected StringType code_string;

    /**
     * Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.
     */
    @Child(name = "preferred_term", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional attribute to carry preferred term corresponding to the code or expression in code_string", formalDefinition="Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required." )
    protected StringType preferred_term;

    private static final long serialVersionUID = -380890311L;

  /**
   * Constructor
   */
    public CODE_PHRASE() {
      super();
    }

  /**
   * Constructor
   */
    public CODE_PHRASE(TERMINOLOGY_ID terminology_id, String code_string) {
      super();
      this.setTerminology_id(terminology_id);
      this.setCode_string(code_string);
    }

    /**
     * @return {@link #terminology_id} (Identifier of the distinct terminology from which the code_string (or its elements) was extracted.)
     */
    public TERMINOLOGY_ID getTerminology_id() { 
      if (this.terminology_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CODE_PHRASE.terminology_id");
        else if (Configuration.doAutoCreate())
          this.terminology_id = new TERMINOLOGY_ID(); // cc
      return this.terminology_id;
    }

    public boolean hasTerminology_id() { 
      return this.terminology_id != null && !this.terminology_id.isEmpty();
    }

    /**
     * @param value {@link #terminology_id} (Identifier of the distinct terminology from which the code_string (or its elements) was extracted.)
     */
    public CODE_PHRASE setTerminology_id(TERMINOLOGY_ID value) { 
      this.terminology_id = value;
      return this;
    }

    /**
     * @return {@link #code_string} (The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.). This is the underlying object with id, value and extensions. The accessor "getCode_string" gives direct access to the value
     */
    public StringType getCode_stringElement() { 
      if (this.code_string == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CODE_PHRASE.code_string");
        else if (Configuration.doAutoCreate())
          this.code_string = new StringType(); // bb
      return this.code_string;
    }

    public boolean hasCode_stringElement() { 
      return this.code_string != null && !this.code_string.isEmpty();
    }

    public boolean hasCode_string() { 
      return this.code_string != null && !this.code_string.isEmpty();
    }

    /**
     * @param value {@link #code_string} (The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.). This is the underlying object with id, value and extensions. The accessor "getCode_string" gives direct access to the value
     */
    public CODE_PHRASE setCode_stringElement(StringType value) { 
      this.code_string = value;
      return this;
    }

    /**
     * @return The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.
     */
    public String getCode_string() { 
      return this.code_string == null ? null : this.code_string.getValue();
    }

    /**
     * @param value The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.
     */
    public CODE_PHRASE setCode_string(String value) { 
        if (this.code_string == null)
          this.code_string = new StringType();
        this.code_string.setValue(value);
      return this;
    }

    /**
     * @return {@link #preferred_term} (Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.). This is the underlying object with id, value and extensions. The accessor "getPreferred_term" gives direct access to the value
     */
    public StringType getPreferred_termElement() { 
      if (this.preferred_term == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CODE_PHRASE.preferred_term");
        else if (Configuration.doAutoCreate())
          this.preferred_term = new StringType(); // bb
      return this.preferred_term;
    }

    public boolean hasPreferred_termElement() { 
      return this.preferred_term != null && !this.preferred_term.isEmpty();
    }

    public boolean hasPreferred_term() { 
      return this.preferred_term != null && !this.preferred_term.isEmpty();
    }

    /**
     * @param value {@link #preferred_term} (Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.). This is the underlying object with id, value and extensions. The accessor "getPreferred_term" gives direct access to the value
     */
    public CODE_PHRASE setPreferred_termElement(StringType value) { 
      this.preferred_term = value;
      return this;
    }

    /**
     * @return Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.
     */
    public String getPreferred_term() { 
      return this.preferred_term == null ? null : this.preferred_term.getValue();
    }

    /**
     * @param value Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.
     */
    public CODE_PHRASE setPreferred_term(String value) { 
      if (Utilities.noString(value))
        this.preferred_term = null;
      else {
        if (this.preferred_term == null)
          this.preferred_term = new StringType();
        this.preferred_term.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("terminology_id", "http://openehr.org/fhir/StructureDefinition/TERMINOLOGY-ID", "Identifier of the distinct terminology from which the code_string (or its elements) was extracted.", 0, 1, terminology_id));
        children.add(new Property("code_string", "string", "The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.", 0, 1, code_string));
        children.add(new Property("preferred_term", "string", "Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.", 0, 1, preferred_term));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1262816807: /*terminology_id*/  return new Property("terminology_id", "http://openehr.org/fhir/StructureDefinition/TERMINOLOGY-ID", "Identifier of the distinct terminology from which the code_string (or its elements) was extracted.", 0, 1, terminology_id);
        case -752837981: /*code_string*/  return new Property("code_string", "string", "The key used by the terminology service to identify a concept or coordination of concepts. This string is most likely parsable inside the terminology service, but nothing can be assumed about its syntax outside that context.", 0, 1, code_string);
        case -1673881238: /*preferred_term*/  return new Property("preferred_term", "string", "Optional attribute to carry preferred term corresponding to the code or expression in code_string. Typical use in integration situations which create mappings, and representing data for which both a (non-preferred) actual term and a preferred term are both required.", 0, 1, preferred_term);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1262816807: /*terminology_id*/ return this.terminology_id == null ? new Base[0] : new Base[] {this.terminology_id}; // TERMINOLOGY_ID
        case -752837981: /*code_string*/ return this.code_string == null ? new Base[0] : new Base[] {this.code_string}; // StringType
        case -1673881238: /*preferred_term*/ return this.preferred_term == null ? new Base[0] : new Base[] {this.preferred_term}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1262816807: // terminology_id
          this.terminology_id = (TERMINOLOGY_ID) value; // TERMINOLOGY_ID
          return value;
        case -752837981: // code_string
          this.code_string = TypeConvertor.castToString(value); // StringType
          return value;
        case -1673881238: // preferred_term
          this.preferred_term = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("terminology_id")) {
          this.terminology_id = (TERMINOLOGY_ID) value; // TERMINOLOGY_ID
        } else if (name.equals("code_string")) {
          this.code_string = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("preferred_term")) {
          this.preferred_term = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1262816807:  return getTerminology_id();
        case -752837981:  return getCode_stringElement();
        case -1673881238:  return getPreferred_termElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1262816807: /*terminology_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TERMINOLOGY-ID"};
        case -752837981: /*code_string*/ return new String[] {"string"};
        case -1673881238: /*preferred_term*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("terminology_id")) {
          this.terminology_id = new TERMINOLOGY_ID();
          return this.terminology_id;
        }
        else if (name.equals("code_string")) {
          throw new FHIRException("Cannot call addChild on a singleton property CODE_PHRASE.code_string");
        }
        else if (name.equals("preferred_term")) {
          throw new FHIRException("Cannot call addChild on a singleton property CODE_PHRASE.preferred_term");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CODE_PHRASE";

  }

      public CODE_PHRASE copy() {
        CODE_PHRASE dst = new CODE_PHRASE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CODE_PHRASE dst) {
        super.copyValues(dst);
        dst.terminology_id = terminology_id == null ? null : terminology_id.copy();
        dst.code_string = code_string == null ? null : code_string.copy();
        dst.preferred_term = preferred_term == null ? null : preferred_term.copy();
      }

      protected CODE_PHRASE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CODE_PHRASE))
          return false;
        CODE_PHRASE o = (CODE_PHRASE) other_;
        return compareDeep(terminology_id, o.terminology_id, true) && compareDeep(code_string, o.code_string, true)
           && compareDeep(preferred_term, o.preferred_term, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CODE_PHRASE))
          return false;
        CODE_PHRASE o = (CODE_PHRASE) other_;
        return compareValues(code_string, o.code_string, true) && compareValues(preferred_term, o.preferred_term, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(terminology_id, code_string
          , preferred_term);
      }


}

