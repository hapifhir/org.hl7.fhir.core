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
 * The abstract parent of all ENTRY subtypes. An ENTRY is the root of a logical item of hard clinical information created in the clinical statement context, within a clinical session. There can be numerous such contexts in a clinical session. Observations and other Entry types only ever document information captured/created in the event documented by the enclosing Composition. An ENTRY is also the minimal unit of information any query should return, since a whole ENTRY (including subparts) records spatial structure, timing information, and contextual information, as well as the subject and generator of the information.
 */
@DatatypeDef(name="ENTRY")
public abstract class ENTRY extends CONTENT_ITEM implements ICompositeType {

    /**
     * Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages.
     */
    @Child(name = "language", type = {CODE_PHRASE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages", formalDefinition="Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected CODE_PHRASE language;

    /**
     * Name of character set in which text values in this Entry are encoded. Coded from openEHR Code Set character sets.
     */
    @Child(name = "encoding", type = {CODE_PHRASE.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of character set in which text values in this Entry are encoded", formalDefinition="Name of character set in which text values in this Entry are encoded. Coded from openEHR Code Set character sets." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-character_sets")
    protected CODE_PHRASE encoding;

    /**
     * Other participations at ENTRY level.
     */
    @Child(name = "other_participations", type = {PARTICIPATION.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Other participations at ENTRY level", formalDefinition="Other participations at ENTRY level." )
    protected List<PARTICIPATION> other_participationsList;

    /**
     * Identifier of externally held workflow engine data for this workflow execution, for this subject of care.
     */
    @Child(name = "workflow_id", type = {OBJECT_REF.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of externally held workflow engine data for this workflow execution, for this subject of care", formalDefinition="Identifier of externally held workflow engine data for this workflow execution, for this subject of care." )
    protected OBJECT_REF workflow_id;

    /**
     * Id of human subject of this ENTRY, e.g.:

* organ donor
* foetus
* a family member
* another clinically relevant person
     */
    @Child(name = "subject", type = {PARTY_PROXY.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Id of human subject of this ENTRY, e.g. organ donor, foetus, a family member, or another clinically relevant person", formalDefinition="Id of human subject of this ENTRY, e.g.:\r\n\r\n* organ donor\r\n* foetus\r\n* a family member\r\n* another clinically relevant person" )
    protected PARTY_PROXY subject;

    /**
     * Optional identification of provider of the information in this ENTRY, which might be:

* the patient
* a patient agent, e.g. parent, guardian
* the clinician
* a device or software


Generally only used when the recorder needs to make it explicit. Otherwise, Composition composer and other participants are assumed.
     */
    @Child(name = "provider", type = {PARTY_PROXY.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional identification of provider of the information in this ENTRY, which might be the patient, a patient agent, the clinician, a device", formalDefinition="Optional identification of provider of the information in this ENTRY, which might be:\r\n\r\n* the patient\r\n* a patient agent, e.g. parent, guardian\r\n* the clinician\r\n* a device or software\r\n\r\n\r\nGenerally only used when the recorder needs to make it explicit. Otherwise, Composition composer and other participants are assumed." )
    protected PARTY_PROXY provider;

    private static final long serialVersionUID = -1650881402L;

  /**
   * Constructor
   */
    public ENTRY() {
      super();
    }

  /**
   * Constructor
   */
    public ENTRY(CODE_PHRASE language, CODE_PHRASE encoding, PARTY_PROXY subject) {
      super();
      this.setLanguage(language);
      this.setEncoding(encoding);
      this.setSubject(subject);
    }

    /**
     * @return {@link #language} (Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages.)
     */
    public CODE_PHRASE getLanguage() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ENTRY.language");
        else if (Configuration.doAutoCreate())
          this.language = new CODE_PHRASE(); // cc
      return this.language;
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages.)
     */
    public ENTRY setLanguage(CODE_PHRASE value) { 
      this.language = value;
      return this;
    }

    /**
     * @return {@link #encoding} (Name of character set in which text values in this Entry are encoded. Coded from openEHR Code Set character sets.)
     */
    public CODE_PHRASE getEncoding() { 
      if (this.encoding == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ENTRY.encoding");
        else if (Configuration.doAutoCreate())
          this.encoding = new CODE_PHRASE(); // cc
      return this.encoding;
    }

    public boolean hasEncoding() { 
      return this.encoding != null && !this.encoding.isEmpty();
    }

    /**
     * @param value {@link #encoding} (Name of character set in which text values in this Entry are encoded. Coded from openEHR Code Set character sets.)
     */
    public ENTRY setEncoding(CODE_PHRASE value) { 
      this.encoding = value;
      return this;
    }

    /**
     * @return {@link #other_participations} (Other participations at ENTRY level.)
     */
    public List<PARTICIPATION> getOther_participationsList() { 
      if (this.other_participationsList == null)
        this.other_participationsList = new ArrayList<PARTICIPATION>();
      return this.other_participationsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ENTRY setOther_participationsList(List<PARTICIPATION> theOther_participations) { 
      this.other_participationsList = theOther_participations;
      return this;
    }

    public boolean hasOther_participations() { 
      if (this.other_participationsList == null)
        return false;
      for (PARTICIPATION item : this.other_participationsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PARTICIPATION addOther_participations() { //3a
      PARTICIPATION t = new PARTICIPATION();
      if (this.other_participationsList == null)
        this.other_participationsList = new ArrayList<PARTICIPATION>();
      this.other_participationsList.add(t);
      return t;
    }

    public ENTRY addOther_participations(PARTICIPATION t) { //3b
      if (t == null)
        return this;
      if (this.other_participationsList == null)
        this.other_participationsList = new ArrayList<PARTICIPATION>();
      this.other_participationsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #other_participations}, creating it if it does not already exist {3}
     */
    public PARTICIPATION getOther_participationsFirstRep() { 
      if (getOther_participationsList().isEmpty()) {
        addOther_participations();
      }
      return getOther_participationsList().get(0);
    }

    /**
     * @return {@link #workflow_id} (Identifier of externally held workflow engine data for this workflow execution, for this subject of care.)
     */
    public OBJECT_REF getWorkflow_id() { 
      if (this.workflow_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ENTRY.workflow_id");
        else if (Configuration.doAutoCreate())
          this.workflow_id = new OBJECT_REF(); // cc
      return this.workflow_id;
    }

    public boolean hasWorkflow_id() { 
      return this.workflow_id != null && !this.workflow_id.isEmpty();
    }

    /**
     * @param value {@link #workflow_id} (Identifier of externally held workflow engine data for this workflow execution, for this subject of care.)
     */
    public ENTRY setWorkflow_id(OBJECT_REF value) { 
      this.workflow_id = value;
      return this;
    }

    /**
     * @return {@link #subject} (Id of human subject of this ENTRY, e.g.:

* organ donor
* foetus
* a family member
* another clinically relevant person)
     */
    public PARTY_PROXY getSubject() { 
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Id of human subject of this ENTRY, e.g.:

* organ donor
* foetus
* a family member
* another clinically relevant person)
     */
    public ENTRY setSubject(PARTY_PROXY value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #provider} (Optional identification of provider of the information in this ENTRY, which might be:

* the patient
* a patient agent, e.g. parent, guardian
* the clinician
* a device or software


Generally only used when the recorder needs to make it explicit. Otherwise, Composition composer and other participants are assumed.)
     */
    public PARTY_PROXY getProvider() { 
      return this.provider;
    }

    public boolean hasProvider() { 
      return this.provider != null && !this.provider.isEmpty();
    }

    /**
     * @param value {@link #provider} (Optional identification of provider of the information in this ENTRY, which might be:

* the patient
* a patient agent, e.g. parent, guardian
* the clinician
* a device or software


Generally only used when the recorder needs to make it explicit. Otherwise, Composition composer and other participants are assumed.)
     */
    public ENTRY setProvider(PARTY_PROXY value) { 
      this.provider = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages.", 0, 1, language));
        children.add(new Property("encoding", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of character set in which text values in this Entry are encoded. Coded from openEHR Code Set character sets.", 0, 1, encoding));
        children.add(new Property("other_participations", "http://openehr.org/fhir/StructureDefinition/PARTICIPATION", "Other participations at ENTRY level.", 0, java.lang.Integer.MAX_VALUE, other_participationsList));
        children.add(new Property("workflow_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Identifier of externally held workflow engine data for this workflow execution, for this subject of care.", 0, 1, workflow_id));
        children.add(new Property("subject", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Id of human subject of this ENTRY, e.g.:\r\n\r\n* organ donor\r\n* foetus\r\n* a family member\r\n* another clinically relevant person", 0, 1, subject));
        children.add(new Property("provider", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Optional identification of provider of the information in this ENTRY, which might be:\r\n\r\n* the patient\r\n* a patient agent, e.g. parent, guardian\r\n* the clinician\r\n* a device or software\r\n\r\n\r\nGenerally only used when the recorder needs to make it explicit. Otherwise, Composition composer and other participants are assumed.", 0, 1, provider));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1613589672: /*language*/  return new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Mandatory indicator of the localised language in which this Entry is written. Coded from openEHR Code Set languages.", 0, 1, language);
        case 1711222099: /*encoding*/  return new Property("encoding", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of character set in which text values in this Entry are encoded. Coded from openEHR Code Set character sets.", 0, 1, encoding);
        case 607783009: /*other_participations*/  return new Property("other_participations", "http://openehr.org/fhir/StructureDefinition/PARTICIPATION", "Other participations at ENTRY level.", 0, java.lang.Integer.MAX_VALUE, other_participationsList);
        case 1712917915: /*workflow_id*/  return new Property("workflow_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Identifier of externally held workflow engine data for this workflow execution, for this subject of care.", 0, 1, workflow_id);
        case -1867885268: /*subject*/  return new Property("subject", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Id of human subject of this ENTRY, e.g.:\r\n\r\n* organ donor\r\n* foetus\r\n* a family member\r\n* another clinically relevant person", 0, 1, subject);
        case -987494927: /*provider*/  return new Property("provider", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "Optional identification of provider of the information in this ENTRY, which might be:\r\n\r\n* the patient\r\n* a patient agent, e.g. parent, guardian\r\n* the clinician\r\n* a device or software\r\n\r\n\r\nGenerally only used when the recorder needs to make it explicit. Otherwise, Composition composer and other participants are assumed.", 0, 1, provider);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CODE_PHRASE
        case 1711222099: /*encoding*/ return this.encoding == null ? new Base[0] : new Base[] {this.encoding}; // CODE_PHRASE
        case 607783009: /*other_participations*/ return this.other_participationsList == null ? new Base[0] : this.other_participationsList.toArray(new Base[this.other_participationsList.size()]); // PARTICIPATION
        case 1712917915: /*workflow_id*/ return this.workflow_id == null ? new Base[0] : new Base[] {this.workflow_id}; // OBJECT_REF
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // PARTY_PROXY
        case -987494927: /*provider*/ return this.provider == null ? new Base[0] : new Base[] {this.provider}; // PARTY_PROXY
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1613589672: // language
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 1711222099: // encoding
          this.encoding = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 607783009: // other_participations
          this.getOther_participationsList().add((PARTICIPATION) value); // PARTICIPATION
          return value;
        case 1712917915: // workflow_id
          this.workflow_id = (OBJECT_REF) value; // OBJECT_REF
          return value;
        case -1867885268: // subject
          this.subject = (PARTY_PROXY) value; // PARTY_PROXY
          return value;
        case -987494927: // provider
          this.provider = (PARTY_PROXY) value; // PARTY_PROXY
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("encoding")) {
          this.encoding = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("other_participations")) {
          this.getOther_participationsList().add((PARTICIPATION) value); // PARTICIPATION
        } else if (name.equals("workflow_id")) {
          this.workflow_id = (OBJECT_REF) value; // OBJECT_REF
        } else if (name.equals("subject")) {
          this.subject = (PARTY_PROXY) value; // PARTY_PROXY
        } else if (name.equals("provider")) {
          this.provider = (PARTY_PROXY) value; // PARTY_PROXY
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672:  return getLanguage();
        case 1711222099:  return getEncoding();
        case 607783009:  return addOther_participations(); 
        case 1712917915:  return getWorkflow_id();
        case -1867885268: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'subject'");
        case -987494927: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'provider'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 1711222099: /*encoding*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 607783009: /*other_participations*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTICIPATION"};
        case 1712917915: /*workflow_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -1867885268: /*subject*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-PROXY"};
        case -987494927: /*provider*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-PROXY"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("language")) {
          this.language = new CODE_PHRASE();
          return this.language;
        }
        else if (name.equals("encoding")) {
          this.encoding = new CODE_PHRASE();
          return this.encoding;
        }
        else if (name.equals("other_participations")) {
          return addOther_participations();
        }
        else if (name.equals("workflow_id")) {
          this.workflow_id = new OBJECT_REF();
          return this.workflow_id;
        }
        else if (name.equals("subject")) {
          throw new FHIRException("Cannot call addChild on an abstract type ENTRY.subject");
        }
        else if (name.equals("provider")) {
          throw new FHIRException("Cannot call addChild on an abstract type ENTRY.provider");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ENTRY";

  }

      public abstract ENTRY copy();

      public void copyValues(ENTRY dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.encoding = encoding == null ? null : encoding.copy();
        if (other_participationsList != null) {
          dst.other_participationsList = new ArrayList<PARTICIPATION>();
          for (PARTICIPATION i : other_participationsList)
            dst.other_participationsList.add(i.copy());
        };
        dst.workflow_id = workflow_id == null ? null : workflow_id.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.provider = provider == null ? null : provider.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ENTRY))
          return false;
        ENTRY o = (ENTRY) other_;
        return compareDeep(language, o.language, true) && compareDeep(encoding, o.encoding, true) && compareDeep(other_participationsList, o.other_participationsList, true)
           && compareDeep(workflow_id, o.workflow_id, true) && compareDeep(subject, o.subject, true) && compareDeep(provider, o.provider, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ENTRY))
          return false;
        ENTRY o = (ENTRY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, encoding, other_participationsList
          , workflow_id, subject, provider);
      }


}

