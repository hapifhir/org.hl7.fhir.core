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
 * Ancestor of all real-world types, including people and organisations. An actor is any real-world entity capable of taking on a role.
 */
@DatatypeDef(name="ACTOR")
public abstract class ACTOR extends PARTY implements ICompositeType {

    /**
     * Languages which can be used to communicate with this actor, in preferred order of use (if known, else order irrelevant).
     */
    @Child(name = "languages", type = {DV_TEXT.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Languages which can be used to communicate with this actor, in preferred order of use (if known, else order irrelevant)", formalDefinition="Languages which can be used to communicate with this actor, in preferred order of use (if known, else order irrelevant)." )
    protected List<DV_TEXT> languagesList;

    /**
     * Identifiers of the Version container for each Role played by this Party.
     */
    @Child(name = "roles", type = {PARTY_REF.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identifiers of the Version container for each Role played by this Party", formalDefinition="Identifiers of the Version container for each Role played by this Party." )
    protected List<PARTY_REF> rolesList;

    private static final long serialVersionUID = 635583100L;

  /**
   * Constructor
   */
    public ACTOR() {
      super();
    }

    /**
     * @return {@link #languages} (Languages which can be used to communicate with this actor, in preferred order of use (if known, else order irrelevant).)
     */
    public List<DV_TEXT> getLanguagesList() { 
      if (this.languagesList == null)
        this.languagesList = new ArrayList<DV_TEXT>();
      return this.languagesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ACTOR setLanguagesList(List<DV_TEXT> theLanguages) { 
      this.languagesList = theLanguages;
      return this;
    }

    public boolean hasLanguages() { 
      if (this.languagesList == null)
        return false;
      for (DV_TEXT item : this.languagesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_TEXT addLanguages() { //3a
      DV_TEXT t = new DV_TEXT();
      if (this.languagesList == null)
        this.languagesList = new ArrayList<DV_TEXT>();
      this.languagesList.add(t);
      return t;
    }

    public ACTOR addLanguages(DV_TEXT t) { //3b
      if (t == null)
        return this;
      if (this.languagesList == null)
        this.languagesList = new ArrayList<DV_TEXT>();
      this.languagesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #languages}, creating it if it does not already exist {3}
     */
    public DV_TEXT getLanguagesFirstRep() { 
      if (getLanguagesList().isEmpty()) {
        addLanguages();
      }
      return getLanguagesList().get(0);
    }

    /**
     * @return {@link #roles} (Identifiers of the Version container for each Role played by this Party.)
     */
    public List<PARTY_REF> getRolesList() { 
      if (this.rolesList == null)
        this.rolesList = new ArrayList<PARTY_REF>();
      return this.rolesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ACTOR setRolesList(List<PARTY_REF> theRoles) { 
      this.rolesList = theRoles;
      return this;
    }

    public boolean hasRoles() { 
      if (this.rolesList == null)
        return false;
      for (PARTY_REF item : this.rolesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PARTY_REF addRoles() { //3a
      PARTY_REF t = new PARTY_REF();
      if (this.rolesList == null)
        this.rolesList = new ArrayList<PARTY_REF>();
      this.rolesList.add(t);
      return t;
    }

    public ACTOR addRoles(PARTY_REF t) { //3b
      if (t == null)
        return this;
      if (this.rolesList == null)
        this.rolesList = new ArrayList<PARTY_REF>();
      this.rolesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #roles}, creating it if it does not already exist {3}
     */
    public PARTY_REF getRolesFirstRep() { 
      if (getRolesList().isEmpty()) {
        addRoles();
      }
      return getRolesList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("languages", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Languages which can be used to communicate with this actor, in preferred order of use (if known, else order irrelevant).", 0, java.lang.Integer.MAX_VALUE, languagesList));
        children.add(new Property("roles", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Identifiers of the Version container for each Role played by this Party.", 0, java.lang.Integer.MAX_VALUE, rolesList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1518327835: /*languages*/  return new Property("languages", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Languages which can be used to communicate with this actor, in preferred order of use (if known, else order irrelevant).", 0, java.lang.Integer.MAX_VALUE, languagesList);
        case 108695229: /*roles*/  return new Property("roles", "http://openehr.org/fhir/StructureDefinition/PARTY-REF", "Identifiers of the Version container for each Role played by this Party.", 0, java.lang.Integer.MAX_VALUE, rolesList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1518327835: /*languages*/ return this.languagesList == null ? new Base[0] : this.languagesList.toArray(new Base[this.languagesList.size()]); // DV_TEXT
        case 108695229: /*roles*/ return this.rolesList == null ? new Base[0] : this.rolesList.toArray(new Base[this.rolesList.size()]); // PARTY_REF
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1518327835: // languages
          this.getLanguagesList().add((DV_TEXT) value); // DV_TEXT
          return value;
        case 108695229: // roles
          this.getRolesList().add((PARTY_REF) value); // PARTY_REF
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("languages")) {
          this.getLanguagesList().add((DV_TEXT) value); // DV_TEXT
        } else if (name.equals("roles")) {
          this.getRolesList().add((PARTY_REF) value); // PARTY_REF
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1518327835:  return addLanguages(); 
        case 108695229:  return addRoles(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1518327835: /*languages*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case 108695229: /*roles*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-REF"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("languages")) {
          return addLanguages();
        }
        else if (name.equals("roles")) {
          return addRoles();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ACTOR";

  }

      public abstract ACTOR copy();

      public void copyValues(ACTOR dst) {
        super.copyValues(dst);
        if (languagesList != null) {
          dst.languagesList = new ArrayList<DV_TEXT>();
          for (DV_TEXT i : languagesList)
            dst.languagesList.add(i.copy());
        };
        if (rolesList != null) {
          dst.rolesList = new ArrayList<PARTY_REF>();
          for (PARTY_REF i : rolesList)
            dst.rolesList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ACTOR))
          return false;
        ACTOR o = (ACTOR) other_;
        return compareDeep(languagesList, o.languagesList, true) && compareDeep(rolesList, o.rolesList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ACTOR))
          return false;
        ACTOR o = (ACTOR) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(languagesList, rolesList);
      }


}

