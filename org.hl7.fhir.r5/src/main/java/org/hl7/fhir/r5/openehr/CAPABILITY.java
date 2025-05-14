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
 * Capability of a role, such as ehr modifier, health care provider. Capability should be backed up by credentials.
 */
@DatatypeDef(name="CAPABILITY")
public class CAPABILITY extends LOCATABLE implements ICompositeType {

    /**
     * The qualifications of the performer of the role for this capability. This might include professional qualifications and official identifications such as provider numbers etc.
     */
    @Child(name = "credentials", type = {ITEM_STRUCTURE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The qualifications of the performer of the role for this capability", formalDefinition="The qualifications of the performer of the role for this capability. This might include professional qualifications and official identifications such as provider numbers etc." )
    protected ITEM_STRUCTURE credentials;

    /**
     * Valid time interval for the credentials of this capability.
     */
    @Child(name = "time_validity", type = {DV_INTERVAL.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Valid time interval for the credentials of this capability", formalDefinition="Valid time interval for the credentials of this capability." )
    protected DV_INTERVAL time_validity;

    private static final long serialVersionUID = -541927433L;

  /**
   * Constructor
   */
    public CAPABILITY() {
      super();
    }

  /**
   * Constructor
   */
    public CAPABILITY(ITEM_STRUCTURE credentials) {
      super();
      this.setCredentials(credentials);
    }

    /**
     * @return {@link #credentials} (The qualifications of the performer of the role for this capability. This might include professional qualifications and official identifications such as provider numbers etc.)
     */
    public ITEM_STRUCTURE getCredentials() { 
      return this.credentials;
    }

    public boolean hasCredentials() { 
      return this.credentials != null && !this.credentials.isEmpty();
    }

    /**
     * @param value {@link #credentials} (The qualifications of the performer of the role for this capability. This might include professional qualifications and official identifications such as provider numbers etc.)
     */
    public CAPABILITY setCredentials(ITEM_STRUCTURE value) { 
      this.credentials = value;
      return this;
    }

    /**
     * @return {@link #time_validity} (Valid time interval for the credentials of this capability.)
     */
    public DV_INTERVAL getTime_validity() { 
      if (this.time_validity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CAPABILITY.time_validity");
        else if (Configuration.doAutoCreate())
          this.time_validity = new DV_INTERVAL(); // cc
      return this.time_validity;
    }

    public boolean hasTime_validity() { 
      return this.time_validity != null && !this.time_validity.isEmpty();
    }

    /**
     * @param value {@link #time_validity} (Valid time interval for the credentials of this capability.)
     */
    public CAPABILITY setTime_validity(DV_INTERVAL value) { 
      this.time_validity = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("credentials", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The qualifications of the performer of the role for this capability. This might include professional qualifications and official identifications such as provider numbers etc.", 0, 1, credentials));
        children.add(new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Valid time interval for the credentials of this capability.", 0, 1, time_validity));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 288957180: /*credentials*/  return new Property("credentials", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The qualifications of the performer of the role for this capability. This might include professional qualifications and official identifications such as provider numbers etc.", 0, 1, credentials);
        case -1304171420: /*time_validity*/  return new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Valid time interval for the credentials of this capability.", 0, 1, time_validity);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 288957180: /*credentials*/ return this.credentials == null ? new Base[0] : new Base[] {this.credentials}; // ITEM_STRUCTURE
        case -1304171420: /*time_validity*/ return this.time_validity == null ? new Base[0] : new Base[] {this.time_validity}; // DV_INTERVAL
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 288957180: // credentials
          this.credentials = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case -1304171420: // time_validity
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("credentials")) {
          this.credentials = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("time_validity")) {
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 288957180: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'credentials'");
        case -1304171420:  return getTime_validity();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 288957180: /*credentials*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case -1304171420: /*time_validity*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("credentials")) {
          throw new FHIRException("Cannot call addChild on an abstract type CAPABILITY.credentials");
        }
        else if (name.equals("time_validity")) {
          this.time_validity = new DV_INTERVAL();
          return this.time_validity;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CAPABILITY";

  }

      public CAPABILITY copy() {
        CAPABILITY dst = new CAPABILITY();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CAPABILITY dst) {
        super.copyValues(dst);
        dst.credentials = credentials == null ? null : credentials.copy();
        dst.time_validity = time_validity == null ? null : time_validity.copy();
      }

      protected CAPABILITY typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CAPABILITY))
          return false;
        CAPABILITY o = (CAPABILITY) other_;
        return compareDeep(credentials, o.credentials, true) && compareDeep(time_validity, o.time_validity, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CAPABILITY))
          return false;
        CAPABILITY o = (CAPABILITY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(credentials, time_validity
          );
      }


}

