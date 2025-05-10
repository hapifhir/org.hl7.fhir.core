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
 * Version control abstraction, defining semantics for versioning one complex object.
 */
@DatatypeDef(name="VERSION")
public abstract class VERSION extends LogicalBase implements ICompositeType {

    /**
     * Contribution in which this version was added.
     */
    @Child(name = "contribution", type = {OBJECT_REF.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Contribution in which this version was added", formalDefinition="Contribution in which this version was added." )
    protected OBJECT_REF contribution;

    /**
     * OpenPGP digital signature or digest of content committed in this Version.
     */
    @Child(name = "signature", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="OpenPGP digital signature or digest of content committed in this Version", formalDefinition="OpenPGP digital signature or digest of content committed in this Version." )
    protected StringType signature;

    /**
     * Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT.
     */
    @Child(name = "commit_audit", type = {AUDIT_DETAILS.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT", formalDefinition="Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT." )
    protected AUDIT_DETAILS commit_audit;

    private static final long serialVersionUID = 1394455611L;

  /**
   * Constructor
   */
    public VERSION() {
      super();
    }

  /**
   * Constructor
   */
    public VERSION(OBJECT_REF contribution, AUDIT_DETAILS commit_audit) {
      super();
      this.setContribution(contribution);
      this.setCommit_audit(commit_audit);
    }

    /**
     * @return {@link #contribution} (Contribution in which this version was added.)
     */
    public OBJECT_REF getContribution() { 
      if (this.contribution == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VERSION.contribution");
        else if (Configuration.doAutoCreate())
          this.contribution = new OBJECT_REF(); // cc
      return this.contribution;
    }

    public boolean hasContribution() { 
      return this.contribution != null && !this.contribution.isEmpty();
    }

    /**
     * @param value {@link #contribution} (Contribution in which this version was added.)
     */
    public VERSION setContribution(OBJECT_REF value) { 
      this.contribution = value;
      return this;
    }

    /**
     * @return {@link #signature} (OpenPGP digital signature or digest of content committed in this Version.). This is the underlying object with id, value and extensions. The accessor "getSignature" gives direct access to the value
     */
    public StringType getSignatureElement() { 
      if (this.signature == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VERSION.signature");
        else if (Configuration.doAutoCreate())
          this.signature = new StringType(); // bb
      return this.signature;
    }

    public boolean hasSignatureElement() { 
      return this.signature != null && !this.signature.isEmpty();
    }

    public boolean hasSignature() { 
      return this.signature != null && !this.signature.isEmpty();
    }

    /**
     * @param value {@link #signature} (OpenPGP digital signature or digest of content committed in this Version.). This is the underlying object with id, value and extensions. The accessor "getSignature" gives direct access to the value
     */
    public VERSION setSignatureElement(StringType value) { 
      this.signature = value;
      return this;
    }

    /**
     * @return OpenPGP digital signature or digest of content committed in this Version.
     */
    public String getSignature() { 
      return this.signature == null ? null : this.signature.getValue();
    }

    /**
     * @param value OpenPGP digital signature or digest of content committed in this Version.
     */
    public VERSION setSignature(String value) { 
      if (Utilities.noString(value))
        this.signature = null;
      else {
        if (this.signature == null)
          this.signature = new StringType();
        this.signature.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #commit_audit} (Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT.)
     */
    public AUDIT_DETAILS getCommit_audit() { 
      if (this.commit_audit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create VERSION.commit_audit");
        else if (Configuration.doAutoCreate())
          this.commit_audit = new AUDIT_DETAILS(); // cc
      return this.commit_audit;
    }

    public boolean hasCommit_audit() { 
      return this.commit_audit != null && !this.commit_audit.isEmpty();
    }

    /**
     * @param value {@link #commit_audit} (Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT.)
     */
    public VERSION setCommit_audit(AUDIT_DETAILS value) { 
      this.commit_audit = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("contribution", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Contribution in which this version was added.", 0, 1, contribution));
        children.add(new Property("signature", "string", "OpenPGP digital signature or digest of content committed in this Version.", 0, 1, signature));
        children.add(new Property("commit_audit", "http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS", "Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT.", 0, 1, commit_audit));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1375970320: /*contribution*/  return new Property("contribution", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Contribution in which this version was added.", 0, 1, contribution);
        case 1073584312: /*signature*/  return new Property("signature", "string", "OpenPGP digital signature or digest of content committed in this Version.", 0, 1, signature);
        case -392355117: /*commit_audit*/  return new Property("commit_audit", "http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS", "Audit trail corresponding to the committal of this version to the VERSIONED_OBJECT.", 0, 1, commit_audit);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1375970320: /*contribution*/ return this.contribution == null ? new Base[0] : new Base[] {this.contribution}; // OBJECT_REF
        case 1073584312: /*signature*/ return this.signature == null ? new Base[0] : new Base[] {this.signature}; // StringType
        case -392355117: /*commit_audit*/ return this.commit_audit == null ? new Base[0] : new Base[] {this.commit_audit}; // AUDIT_DETAILS
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1375970320: // contribution
          this.contribution = (OBJECT_REF) value; // OBJECT_REF
          return value;
        case 1073584312: // signature
          this.signature = TypeConvertor.castToString(value); // StringType
          return value;
        case -392355117: // commit_audit
          this.commit_audit = (AUDIT_DETAILS) value; // AUDIT_DETAILS
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("contribution")) {
          this.contribution = (OBJECT_REF) value; // OBJECT_REF
        } else if (name.equals("signature")) {
          this.signature = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("commit_audit")) {
          this.commit_audit = (AUDIT_DETAILS) value; // AUDIT_DETAILS
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1375970320:  return getContribution();
        case 1073584312:  return getSignatureElement();
        case -392355117:  return getCommit_audit();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1375970320: /*contribution*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case 1073584312: /*signature*/ return new String[] {"string"};
        case -392355117: /*commit_audit*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/AUDIT-DETAILS"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("contribution")) {
          this.contribution = new OBJECT_REF();
          return this.contribution;
        }
        else if (name.equals("signature")) {
          throw new FHIRException("Cannot call addChild on a singleton property VERSION.signature");
        }
        else if (name.equals("commit_audit")) {
          this.commit_audit = new AUDIT_DETAILS();
          return this.commit_audit;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "VERSION";

  }

      public abstract VERSION copy();

      public void copyValues(VERSION dst) {
        super.copyValues(dst);
        dst.contribution = contribution == null ? null : contribution.copy();
        dst.signature = signature == null ? null : signature.copy();
        dst.commit_audit = commit_audit == null ? null : commit_audit.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof VERSION))
          return false;
        VERSION o = (VERSION) other_;
        return compareDeep(contribution, o.contribution, true) && compareDeep(signature, o.signature, true)
           && compareDeep(commit_audit, o.commit_audit, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof VERSION))
          return false;
        VERSION o = (VERSION) other_;
        return compareValues(signature, o.signature, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(contribution, signature, commit_audit
          );
      }


}

