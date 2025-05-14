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
 * Ancestor of all Party types, including real world entities and their roles. A Party is any entity which can participate in an activity. The name attribute inherited from LOCATABLE is used to indicate the actual type of party (note that the actual names, i.e. identities of parties are indicated in the identities attribute, not the name attribute).
 */
@DatatypeDef(name="PARTY")
public abstract class PARTY extends LOCATABLE implements ICompositeType {

    /**
     * Identities used by the party to identify itself, such as legal name, stage names, aliases, nicknames and so on.
     */
    @Child(name = "identities", type = {PARTY_IDENTITY.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identities used by the party to identify itself, such as legal name, stage names, aliases, nicknames and so on", formalDefinition="Identities used by the party to identify itself, such as legal name, stage names, aliases, nicknames and so on." )
    protected List<PARTY_IDENTITY> identitiesList;

    /**
     * Contacts for this party.
     */
    @Child(name = "contacts", type = {CONTACT.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Contacts for this party", formalDefinition="Contacts for this party." )
    protected CONTACT contacts;

    /**
     * All other details for this Party.
     */
    @Child(name = "details", type = {ITEM_STRUCTURE.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="All other details for this Party", formalDefinition="All other details for this Party." )
    protected ITEM_STRUCTURE details;

    /**
     * References to relationships in which this Party takes part as target.
     */
    @Child(name = "reverse_relationships", type = {LOCATABLE_REF.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="References to relationships in which this Party takes part as target", formalDefinition="References to relationships in which this Party takes part as target." )
    protected List<LOCATABLE_REF> reverse_relationshipsList;

    /**
     * Relationships in which this Party takes part as source.
     */
    @Child(name = "relationships", type = {PARTY_RELATIONSHIP.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Relationships in which this Party takes part as source", formalDefinition="Relationships in which this Party takes part as source." )
    protected List<PARTY_RELATIONSHIP> relationshipsList;

    private static final long serialVersionUID = 1369417704L;

  /**
   * Constructor
   */
    public PARTY() {
      super();
    }

    /**
     * @return {@link #identities} (Identities used by the party to identify itself, such as legal name, stage names, aliases, nicknames and so on.)
     */
    public List<PARTY_IDENTITY> getIdentitiesList() { 
      if (this.identitiesList == null)
        this.identitiesList = new ArrayList<PARTY_IDENTITY>();
      return this.identitiesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PARTY setIdentitiesList(List<PARTY_IDENTITY> theIdentities) { 
      this.identitiesList = theIdentities;
      return this;
    }

    public boolean hasIdentities() { 
      if (this.identitiesList == null)
        return false;
      for (PARTY_IDENTITY item : this.identitiesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PARTY_IDENTITY addIdentities() { //3a
      PARTY_IDENTITY t = new PARTY_IDENTITY();
      if (this.identitiesList == null)
        this.identitiesList = new ArrayList<PARTY_IDENTITY>();
      this.identitiesList.add(t);
      return t;
    }

    public PARTY addIdentities(PARTY_IDENTITY t) { //3b
      if (t == null)
        return this;
      if (this.identitiesList == null)
        this.identitiesList = new ArrayList<PARTY_IDENTITY>();
      this.identitiesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identities}, creating it if it does not already exist {3}
     */
    public PARTY_IDENTITY getIdentitiesFirstRep() { 
      if (getIdentitiesList().isEmpty()) {
        addIdentities();
      }
      return getIdentitiesList().get(0);
    }

    /**
     * @return {@link #contacts} (Contacts for this party.)
     */
    public CONTACT getContacts() { 
      if (this.contacts == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY.contacts");
        else if (Configuration.doAutoCreate())
          this.contacts = new CONTACT(); // cc
      return this.contacts;
    }

    public boolean hasContacts() { 
      return this.contacts != null && !this.contacts.isEmpty();
    }

    /**
     * @param value {@link #contacts} (Contacts for this party.)
     */
    public PARTY setContacts(CONTACT value) { 
      this.contacts = value;
      return this;
    }

    /**
     * @return {@link #details} (All other details for this Party.)
     */
    public ITEM_STRUCTURE getDetails() { 
      return this.details;
    }

    public boolean hasDetails() { 
      return this.details != null && !this.details.isEmpty();
    }

    /**
     * @param value {@link #details} (All other details for this Party.)
     */
    public PARTY setDetails(ITEM_STRUCTURE value) { 
      this.details = value;
      return this;
    }

    /**
     * @return {@link #reverse_relationships} (References to relationships in which this Party takes part as target.)
     */
    public List<LOCATABLE_REF> getReverse_relationshipsList() { 
      if (this.reverse_relationshipsList == null)
        this.reverse_relationshipsList = new ArrayList<LOCATABLE_REF>();
      return this.reverse_relationshipsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PARTY setReverse_relationshipsList(List<LOCATABLE_REF> theReverse_relationships) { 
      this.reverse_relationshipsList = theReverse_relationships;
      return this;
    }

    public boolean hasReverse_relationships() { 
      if (this.reverse_relationshipsList == null)
        return false;
      for (LOCATABLE_REF item : this.reverse_relationshipsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public LOCATABLE_REF addReverse_relationships() { //3a
      LOCATABLE_REF t = new LOCATABLE_REF();
      if (this.reverse_relationshipsList == null)
        this.reverse_relationshipsList = new ArrayList<LOCATABLE_REF>();
      this.reverse_relationshipsList.add(t);
      return t;
    }

    public PARTY addReverse_relationships(LOCATABLE_REF t) { //3b
      if (t == null)
        return this;
      if (this.reverse_relationshipsList == null)
        this.reverse_relationshipsList = new ArrayList<LOCATABLE_REF>();
      this.reverse_relationshipsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reverse_relationships}, creating it if it does not already exist {3}
     */
    public LOCATABLE_REF getReverse_relationshipsFirstRep() { 
      if (getReverse_relationshipsList().isEmpty()) {
        addReverse_relationships();
      }
      return getReverse_relationshipsList().get(0);
    }

    /**
     * @return {@link #relationships} (Relationships in which this Party takes part as source.)
     */
    public List<PARTY_RELATIONSHIP> getRelationshipsList() { 
      if (this.relationshipsList == null)
        this.relationshipsList = new ArrayList<PARTY_RELATIONSHIP>();
      return this.relationshipsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PARTY setRelationshipsList(List<PARTY_RELATIONSHIP> theRelationships) { 
      this.relationshipsList = theRelationships;
      return this;
    }

    public boolean hasRelationships() { 
      if (this.relationshipsList == null)
        return false;
      for (PARTY_RELATIONSHIP item : this.relationshipsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PARTY_RELATIONSHIP addRelationships() { //3a
      PARTY_RELATIONSHIP t = new PARTY_RELATIONSHIP();
      if (this.relationshipsList == null)
        this.relationshipsList = new ArrayList<PARTY_RELATIONSHIP>();
      this.relationshipsList.add(t);
      return t;
    }

    public PARTY addRelationships(PARTY_RELATIONSHIP t) { //3b
      if (t == null)
        return this;
      if (this.relationshipsList == null)
        this.relationshipsList = new ArrayList<PARTY_RELATIONSHIP>();
      this.relationshipsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relationships}, creating it if it does not already exist {3}
     */
    public PARTY_RELATIONSHIP getRelationshipsFirstRep() { 
      if (getRelationshipsList().isEmpty()) {
        addRelationships();
      }
      return getRelationshipsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identities", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTITY", "Identities used by the party to identify itself, such as legal name, stage names, aliases, nicknames and so on.", 0, java.lang.Integer.MAX_VALUE, identitiesList));
        children.add(new Property("contacts", "http://openehr.org/fhir/StructureDefinition/CONTACT", "Contacts for this party.", 0, 1, contacts));
        children.add(new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "All other details for this Party.", 0, 1, details));
        children.add(new Property("reverse_relationships", "http://openehr.org/fhir/StructureDefinition/LOCATABLE-REF", "References to relationships in which this Party takes part as target.", 0, java.lang.Integer.MAX_VALUE, reverse_relationshipsList));
        children.add(new Property("relationships", "http://openehr.org/fhir/StructureDefinition/PARTY-RELATIONSHIP", "Relationships in which this Party takes part as source.", 0, java.lang.Integer.MAX_VALUE, relationshipsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618015780: /*identities*/  return new Property("identities", "http://openehr.org/fhir/StructureDefinition/PARTY-IDENTITY", "Identities used by the party to identify itself, such as legal name, stage names, aliases, nicknames and so on.", 0, java.lang.Integer.MAX_VALUE, identitiesList);
        case -567451565: /*contacts*/  return new Property("contacts", "http://openehr.org/fhir/StructureDefinition/CONTACT", "Contacts for this party.", 0, 1, contacts);
        case 1557721666: /*details*/  return new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "All other details for this Party.", 0, 1, details);
        case -96288098: /*reverse_relationships*/  return new Property("reverse_relationships", "http://openehr.org/fhir/StructureDefinition/LOCATABLE-REF", "References to relationships in which this Party takes part as target.", 0, java.lang.Integer.MAX_VALUE, reverse_relationshipsList);
        case 472535355: /*relationships*/  return new Property("relationships", "http://openehr.org/fhir/StructureDefinition/PARTY-RELATIONSHIP", "Relationships in which this Party takes part as source.", 0, java.lang.Integer.MAX_VALUE, relationshipsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618015780: /*identities*/ return this.identitiesList == null ? new Base[0] : this.identitiesList.toArray(new Base[this.identitiesList.size()]); // PARTY_IDENTITY
        case -567451565: /*contacts*/ return this.contacts == null ? new Base[0] : new Base[] {this.contacts}; // CONTACT
        case 1557721666: /*details*/ return this.details == null ? new Base[0] : new Base[] {this.details}; // ITEM_STRUCTURE
        case -96288098: /*reverse_relationships*/ return this.reverse_relationshipsList == null ? new Base[0] : this.reverse_relationshipsList.toArray(new Base[this.reverse_relationshipsList.size()]); // LOCATABLE_REF
        case 472535355: /*relationships*/ return this.relationshipsList == null ? new Base[0] : this.relationshipsList.toArray(new Base[this.relationshipsList.size()]); // PARTY_RELATIONSHIP
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618015780: // identities
          this.getIdentitiesList().add((PARTY_IDENTITY) value); // PARTY_IDENTITY
          return value;
        case -567451565: // contacts
          this.contacts = (CONTACT) value; // CONTACT
          return value;
        case 1557721666: // details
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case -96288098: // reverse_relationships
          this.getReverse_relationshipsList().add((LOCATABLE_REF) value); // LOCATABLE_REF
          return value;
        case 472535355: // relationships
          this.getRelationshipsList().add((PARTY_RELATIONSHIP) value); // PARTY_RELATIONSHIP
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identities")) {
          this.getIdentitiesList().add((PARTY_IDENTITY) value); // PARTY_IDENTITY
        } else if (name.equals("contacts")) {
          this.contacts = (CONTACT) value; // CONTACT
        } else if (name.equals("details")) {
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("reverse_relationships")) {
          this.getReverse_relationshipsList().add((LOCATABLE_REF) value); // LOCATABLE_REF
        } else if (name.equals("relationships")) {
          this.getRelationshipsList().add((PARTY_RELATIONSHIP) value); // PARTY_RELATIONSHIP
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618015780:  return addIdentities(); 
        case -567451565:  return getContacts();
        case 1557721666: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'details'");
        case -96288098:  return addReverse_relationships(); 
        case 472535355:  return addRelationships(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618015780: /*identities*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-IDENTITY"};
        case -567451565: /*contacts*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CONTACT"};
        case 1557721666: /*details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case -96288098: /*reverse_relationships*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/LOCATABLE-REF"};
        case 472535355: /*relationships*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-RELATIONSHIP"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identities")) {
          return addIdentities();
        }
        else if (name.equals("contacts")) {
          this.contacts = new CONTACT();
          return this.contacts;
        }
        else if (name.equals("details")) {
          throw new FHIRException("Cannot call addChild on an abstract type PARTY.details");
        }
        else if (name.equals("reverse_relationships")) {
          return addReverse_relationships();
        }
        else if (name.equals("relationships")) {
          return addRelationships();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTY";

  }

      public abstract PARTY copy();

      public void copyValues(PARTY dst) {
        super.copyValues(dst);
        if (identitiesList != null) {
          dst.identitiesList = new ArrayList<PARTY_IDENTITY>();
          for (PARTY_IDENTITY i : identitiesList)
            dst.identitiesList.add(i.copy());
        };
        dst.contacts = contacts == null ? null : contacts.copy();
        dst.details = details == null ? null : details.copy();
        if (reverse_relationshipsList != null) {
          dst.reverse_relationshipsList = new ArrayList<LOCATABLE_REF>();
          for (LOCATABLE_REF i : reverse_relationshipsList)
            dst.reverse_relationshipsList.add(i.copy());
        };
        if (relationshipsList != null) {
          dst.relationshipsList = new ArrayList<PARTY_RELATIONSHIP>();
          for (PARTY_RELATIONSHIP i : relationshipsList)
            dst.relationshipsList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTY))
          return false;
        PARTY o = (PARTY) other_;
        return compareDeep(identitiesList, o.identitiesList, true) && compareDeep(contacts, o.contacts, true)
           && compareDeep(details, o.details, true) && compareDeep(reverse_relationshipsList, o.reverse_relationshipsList, true)
           && compareDeep(relationshipsList, o.relationshipsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTY))
          return false;
        PARTY o = (PARTY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identitiesList, contacts, details
          , reverse_relationshipsList, relationshipsList);
      }


}

