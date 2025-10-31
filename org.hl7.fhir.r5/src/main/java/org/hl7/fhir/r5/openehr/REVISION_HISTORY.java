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
 * Defines the notion of a revision history of audit items, each associated with the version for which that audit was committed. The list is in most-recent-first order.
 */
@DatatypeDef(name="REVISION_HISTORY")
public class REVISION_HISTORY extends LogicalBase implements ICompositeType {

    /**
     * The version id of the most recent item, as a String.
     */
    @Child(name = "most_recent_version", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The version id of the most recent item, as a String", formalDefinition="The version id of the most recent item, as a String." )
    protected StringType most_recent_version;

    /**
     * The commit date/time of the most recent item, as a String.
     */
    @Child(name = "most_recent_version_time_committed", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The commit date/time of the most recent item, as a String", formalDefinition="The commit date/time of the most recent item, as a String." )
    protected StringType most_recent_version_time_committed;

    private static final long serialVersionUID = 213309767L;

  /**
   * Constructor
   */
    public REVISION_HISTORY() {
      super();
    }

  /**
   * Constructor
   */
    public REVISION_HISTORY(String most_recent_version, String most_recent_version_time_committed) {
      super();
      this.setMost_recent_version(most_recent_version);
      this.setMost_recent_version_time_committed(most_recent_version_time_committed);
    }

    /**
     * @return {@link #most_recent_version} (The version id of the most recent item, as a String.). This is the underlying object with id, value and extensions. The accessor "getMost_recent_version" gives direct access to the value
     */
    public StringType getMost_recent_versionElement() { 
      if (this.most_recent_version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create REVISION_HISTORY.most_recent_version");
        else if (Configuration.doAutoCreate())
          this.most_recent_version = new StringType(); // bb
      return this.most_recent_version;
    }

    public boolean hasMost_recent_versionElement() { 
      return this.most_recent_version != null && !this.most_recent_version.isEmpty();
    }

    public boolean hasMost_recent_version() { 
      return this.most_recent_version != null && !this.most_recent_version.isEmpty();
    }

    /**
     * @param value {@link #most_recent_version} (The version id of the most recent item, as a String.). This is the underlying object with id, value and extensions. The accessor "getMost_recent_version" gives direct access to the value
     */
    public REVISION_HISTORY setMost_recent_versionElement(StringType value) { 
      this.most_recent_version = value;
      return this;
    }

    /**
     * @return The version id of the most recent item, as a String.
     */
    public String getMost_recent_version() { 
      return this.most_recent_version == null ? null : this.most_recent_version.getValue();
    }

    /**
     * @param value The version id of the most recent item, as a String.
     */
    public REVISION_HISTORY setMost_recent_version(String value) { 
        if (this.most_recent_version == null)
          this.most_recent_version = new StringType();
        this.most_recent_version.setValue(value);
      return this;
    }

    /**
     * @return {@link #most_recent_version_time_committed} (The commit date/time of the most recent item, as a String.). This is the underlying object with id, value and extensions. The accessor "getMost_recent_version_time_committed" gives direct access to the value
     */
    public StringType getMost_recent_version_time_committedElement() { 
      if (this.most_recent_version_time_committed == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create REVISION_HISTORY.most_recent_version_time_committed");
        else if (Configuration.doAutoCreate())
          this.most_recent_version_time_committed = new StringType(); // bb
      return this.most_recent_version_time_committed;
    }

    public boolean hasMost_recent_version_time_committedElement() { 
      return this.most_recent_version_time_committed != null && !this.most_recent_version_time_committed.isEmpty();
    }

    public boolean hasMost_recent_version_time_committed() { 
      return this.most_recent_version_time_committed != null && !this.most_recent_version_time_committed.isEmpty();
    }

    /**
     * @param value {@link #most_recent_version_time_committed} (The commit date/time of the most recent item, as a String.). This is the underlying object with id, value and extensions. The accessor "getMost_recent_version_time_committed" gives direct access to the value
     */
    public REVISION_HISTORY setMost_recent_version_time_committedElement(StringType value) { 
      this.most_recent_version_time_committed = value;
      return this;
    }

    /**
     * @return The commit date/time of the most recent item, as a String.
     */
    public String getMost_recent_version_time_committed() { 
      return this.most_recent_version_time_committed == null ? null : this.most_recent_version_time_committed.getValue();
    }

    /**
     * @param value The commit date/time of the most recent item, as a String.
     */
    public REVISION_HISTORY setMost_recent_version_time_committed(String value) { 
        if (this.most_recent_version_time_committed == null)
          this.most_recent_version_time_committed = new StringType();
        this.most_recent_version_time_committed.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("most_recent_version", "string", "The version id of the most recent item, as a String.", 0, 1, most_recent_version));
        children.add(new Property("most_recent_version_time_committed", "string", "The commit date/time of the most recent item, as a String.", 0, 1, most_recent_version_time_committed));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -971449552: /*most_recent_version*/  return new Property("most_recent_version", "string", "The version id of the most recent item, as a String.", 0, 1, most_recent_version);
        case 855029113: /*most_recent_version_time_committed*/  return new Property("most_recent_version_time_committed", "string", "The commit date/time of the most recent item, as a String.", 0, 1, most_recent_version_time_committed);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -971449552: /*most_recent_version*/ return this.most_recent_version == null ? new Base[0] : new Base[] {this.most_recent_version}; // StringType
        case 855029113: /*most_recent_version_time_committed*/ return this.most_recent_version_time_committed == null ? new Base[0] : new Base[] {this.most_recent_version_time_committed}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -971449552: // most_recent_version
          this.most_recent_version = TypeConvertor.castToString(value); // StringType
          return value;
        case 855029113: // most_recent_version_time_committed
          this.most_recent_version_time_committed = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("most_recent_version")) {
          this.most_recent_version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("most_recent_version_time_committed")) {
          this.most_recent_version_time_committed = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -971449552:  return getMost_recent_versionElement();
        case 855029113:  return getMost_recent_version_time_committedElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -971449552: /*most_recent_version*/ return new String[] {"string"};
        case 855029113: /*most_recent_version_time_committed*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("most_recent_version")) {
          throw new FHIRException("Cannot call addChild on a singleton property REVISION_HISTORY.most_recent_version");
        }
        else if (name.equals("most_recent_version_time_committed")) {
          throw new FHIRException("Cannot call addChild on a singleton property REVISION_HISTORY.most_recent_version_time_committed");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "REVISION_HISTORY";

  }

      public REVISION_HISTORY copy() {
        REVISION_HISTORY dst = new REVISION_HISTORY();
        copyValues(dst);
        return dst;
      }

      public void copyValues(REVISION_HISTORY dst) {
        super.copyValues(dst);
        dst.most_recent_version = most_recent_version == null ? null : most_recent_version.copy();
        dst.most_recent_version_time_committed = most_recent_version_time_committed == null ? null : most_recent_version_time_committed.copy();
      }

      protected REVISION_HISTORY typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof REVISION_HISTORY))
          return false;
        REVISION_HISTORY o = (REVISION_HISTORY) other_;
        return compareDeep(most_recent_version, o.most_recent_version, true) && compareDeep(most_recent_version_time_committed, o.most_recent_version_time_committed, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof REVISION_HISTORY))
          return false;
        REVISION_HISTORY o = (REVISION_HISTORY) other_;
        return compareValues(most_recent_version, o.most_recent_version, true) && compareValues(most_recent_version_time_committed, o.most_recent_version_time_committed, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(most_recent_version, most_recent_version_time_committed
          );
      }


}

