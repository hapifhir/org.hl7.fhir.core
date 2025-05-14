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
 * Items which are truly boolean data, such as true/false or yes/no answers. For such data, it is important to devise the meanings (usually questions in subjective data) carefully, so that the only allowed results are in fact true or false.
 */
@DatatypeDef(name="TERM_MAPPING")
public class TERM_MAPPING extends LogicalBase implements ICompositeType {

    /**
     * The relative match of the target term with respect to the mapped text item. Result meanings:

* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection
* '=': the mapping is to a (supposedly) equivalent to the original item
* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.
* '?': the kind of mapping is unknown.

The first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).
     */
    @Child(name = "match", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="> | = | < | ?: The relative match of the target term with respect to the mapped text item", formalDefinition="The relative match of the target term with respect to the mapped text item. Result meanings:\n\n* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection\n* '=': the mapping is to a (supposedly) equivalent to the original item\n* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.\n* '?': the kind of mapping is unknown.\n\nThe first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri)." )
    protected StringType match;

    /**
     * Purpose of the mapping e.g. 'automated data mining', 'billing', 'interoperability'.
     */
    @Child(name = "purpose", type = {DV_CODED_TEXT.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Purpose of the mapping", formalDefinition="Purpose of the mapping e.g. 'automated data mining', 'billing', 'interoperability'." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-term_mapping_purpose")
    protected DV_CODED_TEXT purpose;

    /**
     * The target term of the mapping.
     */
    @Child(name = "target", type = {CODE_PHRASE.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The target term of the mapping", formalDefinition="The target term of the mapping." )
    protected CODE_PHRASE target;

    private static final long serialVersionUID = -331225696L;

  /**
   * Constructor
   */
    public TERM_MAPPING() {
      super();
    }

  /**
   * Constructor
   */
    public TERM_MAPPING(String match, CODE_PHRASE target) {
      super();
      this.setMatch(match);
      this.setTarget(target);
    }

    /**
     * @return {@link #match} (The relative match of the target term with respect to the mapped text item. Result meanings:

* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection
* '=': the mapping is to a (supposedly) equivalent to the original item
* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.
* '?': the kind of mapping is unknown.

The first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).). This is the underlying object with id, value and extensions. The accessor "getMatch" gives direct access to the value
     */
    public StringType getMatchElement() { 
      if (this.match == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TERM_MAPPING.match");
        else if (Configuration.doAutoCreate())
          this.match = new StringType(); // bb
      return this.match;
    }

    public boolean hasMatchElement() { 
      return this.match != null && !this.match.isEmpty();
    }

    public boolean hasMatch() { 
      return this.match != null && !this.match.isEmpty();
    }

    /**
     * @param value {@link #match} (The relative match of the target term with respect to the mapped text item. Result meanings:

* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection
* '=': the mapping is to a (supposedly) equivalent to the original item
* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.
* '?': the kind of mapping is unknown.

The first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).). This is the underlying object with id, value and extensions. The accessor "getMatch" gives direct access to the value
     */
    public TERM_MAPPING setMatchElement(StringType value) { 
      this.match = value;
      return this;
    }

    /**
     * @return The relative match of the target term with respect to the mapped text item. Result meanings:

* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection
* '=': the mapping is to a (supposedly) equivalent to the original item
* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.
* '?': the kind of mapping is unknown.

The first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).
     */
    public String getMatch() { 
      return this.match == null ? null : this.match.getValue();
    }

    /**
     * @param value The relative match of the target term with respect to the mapped text item. Result meanings:

* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection
* '=': the mapping is to a (supposedly) equivalent to the original item
* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.
* '?': the kind of mapping is unknown.

The first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).
     */
    public TERM_MAPPING setMatch(String value) { 
        if (this.match == null)
          this.match = new StringType();
        this.match.setValue(value);
      return this;
    }

    /**
     * @return {@link #purpose} (Purpose of the mapping e.g. 'automated data mining', 'billing', 'interoperability'.)
     */
    public DV_CODED_TEXT getPurpose() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TERM_MAPPING.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new DV_CODED_TEXT(); // cc
      return this.purpose;
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Purpose of the mapping e.g. 'automated data mining', 'billing', 'interoperability'.)
     */
    public TERM_MAPPING setPurpose(DV_CODED_TEXT value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return {@link #target} (The target term of the mapping.)
     */
    public CODE_PHRASE getTarget() { 
      if (this.target == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TERM_MAPPING.target");
        else if (Configuration.doAutoCreate())
          this.target = new CODE_PHRASE(); // cc
      return this.target;
    }

    public boolean hasTarget() { 
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (The target term of the mapping.)
     */
    public TERM_MAPPING setTarget(CODE_PHRASE value) { 
      this.target = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("match", "string", "The relative match of the target term with respect to the mapped text item. Result meanings:\n\n* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection\n* '=': the mapping is to a (supposedly) equivalent to the original item\n* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.\n* '?': the kind of mapping is unknown.\n\nThe first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).", 0, 1, match));
        children.add(new Property("purpose", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Purpose of the mapping e.g. 'automated data mining', 'billing', 'interoperability'.", 0, 1, purpose));
        children.add(new Property("target", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "The target term of the mapping.", 0, 1, target));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 103668165: /*match*/  return new Property("match", "string", "The relative match of the target term with respect to the mapped text item. Result meanings:\n\n* '>': the mapping is to a broader term e.g. orginal text = arbovirus infection , target = viral infection\n* '=': the mapping is to a (supposedly) equivalent to the original item\n* '<': the mapping is to a narrower term. e.g. original text = diabetes , mapping = diabetes mellitus.\n* '?': the kind of mapping is unknown.\n\nThe first three values are taken from the ISO standards 2788 ( Guide to Establishment and development of monolingual thesauri) and 5964 (Guide to Establishment and development of multilingual thesauri).", 0, 1, match);
        case -220463842: /*purpose*/  return new Property("purpose", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Purpose of the mapping e.g. 'automated data mining', 'billing', 'interoperability'.", 0, 1, purpose);
        case -880905839: /*target*/  return new Property("target", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "The target term of the mapping.", 0, 1, target);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 103668165: /*match*/ return this.match == null ? new Base[0] : new Base[] {this.match}; // StringType
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // DV_CODED_TEXT
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // CODE_PHRASE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 103668165: // match
          this.match = TypeConvertor.castToString(value); // StringType
          return value;
        case -220463842: // purpose
          this.purpose = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case -880905839: // target
          this.target = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("match")) {
          this.match = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("purpose")) {
          this.purpose = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("target")) {
          this.target = (CODE_PHRASE) value; // CODE_PHRASE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 103668165:  return getMatchElement();
        case -220463842:  return getPurpose();
        case -880905839:  return getTarget();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 103668165: /*match*/ return new String[] {"string"};
        case -220463842: /*purpose*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case -880905839: /*target*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("match")) {
          throw new FHIRException("Cannot call addChild on a singleton property TERM_MAPPING.match");
        }
        else if (name.equals("purpose")) {
          this.purpose = new DV_CODED_TEXT();
          return this.purpose;
        }
        else if (name.equals("target")) {
          this.target = new CODE_PHRASE();
          return this.target;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "TERM_MAPPING";

  }

      public TERM_MAPPING copy() {
        TERM_MAPPING dst = new TERM_MAPPING();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TERM_MAPPING dst) {
        super.copyValues(dst);
        dst.match = match == null ? null : match.copy();
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.target = target == null ? null : target.copy();
      }

      protected TERM_MAPPING typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TERM_MAPPING))
          return false;
        TERM_MAPPING o = (TERM_MAPPING) other_;
        return compareDeep(match, o.match, true) && compareDeep(purpose, o.purpose, true) && compareDeep(target, o.target, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TERM_MAPPING))
          return false;
        TERM_MAPPING o = (TERM_MAPPING) other_;
        return compareValues(match, o.match, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(match, purpose, target);
      }


}

