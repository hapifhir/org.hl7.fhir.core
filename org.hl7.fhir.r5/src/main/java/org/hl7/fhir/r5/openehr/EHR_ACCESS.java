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
 * EHR-wide access control object. All access decisions to data in the EHR must be made in accordance with the policies and rules in this object.
 */
@DatatypeDef(name="EHR_ACCESS")
public class EHR_ACCESS extends LOCATABLE implements ICompositeType {

    /**
     * Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes.
     */
    @Child(name = "settings", type = {ACCESS_CONTROL_SETTINGS.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes", formalDefinition="Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes." )
    protected ACCESS_CONTROL_SETTINGS settings;

    private static final long serialVersionUID = 708478691L;

  /**
   * Constructor
   */
    public EHR_ACCESS() {
      super();
    }

    /**
     * @return {@link #settings} (Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes.)
     */
    public ACCESS_CONTROL_SETTINGS getSettings() { 
      return this.settings;
    }

    public boolean hasSettings() { 
      return this.settings != null && !this.settings.isEmpty();
    }

    /**
     * @param value {@link #settings} (Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes.)
     */
    public EHR_ACCESS setSettings(ACCESS_CONTROL_SETTINGS value) { 
      this.settings = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("settings", "http://openehr.org/fhir/StructureDefinition/ACCESS-CONTROL-SETTINGS", "Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes.", 0, 1, settings));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1434631203: /*settings*/  return new Property("settings", "http://openehr.org/fhir/StructureDefinition/ACCESS-CONTROL-SETTINGS", "Access control settings for the EHR. Instance is a subtype of the type ACCESS_CONTROL_SETTINGS, allowing for the use of different access control schemes.", 0, 1, settings);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1434631203: /*settings*/ return this.settings == null ? new Base[0] : new Base[] {this.settings}; // ACCESS_CONTROL_SETTINGS
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1434631203: // settings
          this.settings = (ACCESS_CONTROL_SETTINGS) value; // ACCESS_CONTROL_SETTINGS
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("settings")) {
          this.settings = (ACCESS_CONTROL_SETTINGS) value; // ACCESS_CONTROL_SETTINGS
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1434631203: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'settings'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1434631203: /*settings*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ACCESS-CONTROL-SETTINGS"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("settings")) {
          throw new FHIRException("Cannot call addChild on an abstract type EHR_ACCESS.settings");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EHR_ACCESS";

  }

      public EHR_ACCESS copy() {
        EHR_ACCESS dst = new EHR_ACCESS();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EHR_ACCESS dst) {
        super.copyValues(dst);
        dst.settings = settings == null ? null : settings.copy();
      }

      protected EHR_ACCESS typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EHR_ACCESS))
          return false;
        EHR_ACCESS o = (EHR_ACCESS) other_;
        return compareDeep(settings, o.settings, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EHR_ACCESS))
          return false;
        EHR_ACCESS o = (EHR_ACCESS) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(settings);
      }


}

