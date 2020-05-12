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
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Permission.
 */
@ResourceDef(name="Permission", profile="http://hl7.org/fhir/StructureDefinition/Permission")
public class Permission extends DomainResource {

    public enum PermissionStatus {
        /**
         * Permission is given.
         */
        ACTIVE, 
        /**
         * Permission was entered in error and is not active.
         */
        ENTEREDINERROR, 
        /**
         * Permission is being defined.
         */
        DRAFT, 
        /**
         * Permission not granted.
         */
        REJECTED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static PermissionStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("rejected".equals(codeString))
          return REJECTED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown PermissionStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case ENTEREDINERROR: return "entered-in-error";
            case DRAFT: return "draft";
            case REJECTED: return "rejected";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/permission-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/permission-status";
            case DRAFT: return "http://hl7.org/fhir/permission-status";
            case REJECTED: return "http://hl7.org/fhir/permission-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "Permission is given.";
            case ENTEREDINERROR: return "Permission was entered in error and is not active.";
            case DRAFT: return "Permission is being defined.";
            case REJECTED: return "Permission not granted.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case ENTEREDINERROR: return "Entered in Error";
            case DRAFT: return "Draft";
            case REJECTED: return "Rejected";
            default: return "?";
          }
        }
    }

  public static class PermissionStatusEnumFactory implements EnumFactory<PermissionStatus> {
    public PermissionStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return PermissionStatus.ACTIVE;
        if ("entered-in-error".equals(codeString))
          return PermissionStatus.ENTEREDINERROR;
        if ("draft".equals(codeString))
          return PermissionStatus.DRAFT;
        if ("rejected".equals(codeString))
          return PermissionStatus.REJECTED;
        throw new IllegalArgumentException("Unknown PermissionStatus code '"+codeString+"'");
        }
        public Enumeration<PermissionStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PermissionStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.ACTIVE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.ENTEREDINERROR);
        if ("draft".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.DRAFT);
        if ("rejected".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.REJECTED);
        throw new FHIRException("Unknown PermissionStatus code '"+codeString+"'");
        }
    public String toCode(PermissionStatus code) {
      if (code == PermissionStatus.ACTIVE)
        return "active";
      if (code == PermissionStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == PermissionStatus.DRAFT)
        return "draft";
      if (code == PermissionStatus.REJECTED)
        return "rejected";
      return "?";
      }
    public String toSystem(PermissionStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class PermissionProcessingActivityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * If the processing is a transfer, we must capture where it the data allowed or expected to be shared - with a party or person.
         */
        @Child(name = "partyReference", type = {Organization.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="If the processing is a transfer, we must capture where it the data allowed or expected to be shared - with a party or person", formalDefinition="If the processing is a transfer, we must capture where it the data allowed or expected to be shared - with a party or person." )
        protected List<Reference> partyReference;

        /**
         * If the processing is a transfer, or involves another party, we must capture where it the data allowed or expected to be shared - with a party or person. This can be a party instance or party type
§ Purpose – a specific purpose of the data.
         */
        @Child(name = "partyCodeableConcept", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="If the processing is a transfer, or involves another party, we must capture where it the data allowed or expected to be shared - with a party or person. This can be a party instance or party type\n§ Purpose – a specific purpose of the data", formalDefinition="If the processing is a transfer, or involves another party, we must capture where it the data allowed or expected to be shared - with a party or person. This can be a party instance or party type\n§ Purpose – a specific purpose of the data." )
        protected List<CodeableConcept> partyCodeableConcept;

        /**
         * The purpose for which the permission is given.
         */
        @Child(name = "purpose", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The purpose for which the permission is given", formalDefinition="The purpose for which the permission is given." )
        protected List<CodeableConcept> purpose;

        private static final long serialVersionUID = -1556351771L;

    /**
     * Constructor
     */
      public PermissionProcessingActivityComponent() {
        super();
      }

        /**
         * @return {@link #partyReference} (If the processing is a transfer, we must capture where it the data allowed or expected to be shared - with a party or person.)
         */
        public List<Reference> getPartyReference() { 
          if (this.partyReference == null)
            this.partyReference = new ArrayList<Reference>();
          return this.partyReference;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PermissionProcessingActivityComponent setPartyReference(List<Reference> thePartyReference) { 
          this.partyReference = thePartyReference;
          return this;
        }

        public boolean hasPartyReference() { 
          if (this.partyReference == null)
            return false;
          for (Reference item : this.partyReference)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addPartyReference() { //3
          Reference t = new Reference();
          if (this.partyReference == null)
            this.partyReference = new ArrayList<Reference>();
          this.partyReference.add(t);
          return t;
        }

        public PermissionProcessingActivityComponent addPartyReference(Reference t) { //3
          if (t == null)
            return this;
          if (this.partyReference == null)
            this.partyReference = new ArrayList<Reference>();
          this.partyReference.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #partyReference}, creating it if it does not already exist {3}
         */
        public Reference getPartyReferenceFirstRep() { 
          if (getPartyReference().isEmpty()) {
            addPartyReference();
          }
          return getPartyReference().get(0);
        }

        /**
         * @return {@link #partyCodeableConcept} (If the processing is a transfer, or involves another party, we must capture where it the data allowed or expected to be shared - with a party or person. This can be a party instance or party type
§ Purpose – a specific purpose of the data.)
         */
        public List<CodeableConcept> getPartyCodeableConcept() { 
          if (this.partyCodeableConcept == null)
            this.partyCodeableConcept = new ArrayList<CodeableConcept>();
          return this.partyCodeableConcept;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PermissionProcessingActivityComponent setPartyCodeableConcept(List<CodeableConcept> thePartyCodeableConcept) { 
          this.partyCodeableConcept = thePartyCodeableConcept;
          return this;
        }

        public boolean hasPartyCodeableConcept() { 
          if (this.partyCodeableConcept == null)
            return false;
          for (CodeableConcept item : this.partyCodeableConcept)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addPartyCodeableConcept() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.partyCodeableConcept == null)
            this.partyCodeableConcept = new ArrayList<CodeableConcept>();
          this.partyCodeableConcept.add(t);
          return t;
        }

        public PermissionProcessingActivityComponent addPartyCodeableConcept(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.partyCodeableConcept == null)
            this.partyCodeableConcept = new ArrayList<CodeableConcept>();
          this.partyCodeableConcept.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #partyCodeableConcept}, creating it if it does not already exist {3}
         */
        public CodeableConcept getPartyCodeableConceptFirstRep() { 
          if (getPartyCodeableConcept().isEmpty()) {
            addPartyCodeableConcept();
          }
          return getPartyCodeableConcept().get(0);
        }

        /**
         * @return {@link #purpose} (The purpose for which the permission is given.)
         */
        public List<CodeableConcept> getPurpose() { 
          if (this.purpose == null)
            this.purpose = new ArrayList<CodeableConcept>();
          return this.purpose;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PermissionProcessingActivityComponent setPurpose(List<CodeableConcept> thePurpose) { 
          this.purpose = thePurpose;
          return this;
        }

        public boolean hasPurpose() { 
          if (this.purpose == null)
            return false;
          for (CodeableConcept item : this.purpose)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addPurpose() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.purpose == null)
            this.purpose = new ArrayList<CodeableConcept>();
          this.purpose.add(t);
          return t;
        }

        public PermissionProcessingActivityComponent addPurpose(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.purpose == null)
            this.purpose = new ArrayList<CodeableConcept>();
          this.purpose.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #purpose}, creating it if it does not already exist {3}
         */
        public CodeableConcept getPurposeFirstRep() { 
          if (getPurpose().isEmpty()) {
            addPurpose();
          }
          return getPurpose().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("partyReference", "Reference(Organization)", "If the processing is a transfer, we must capture where it the data allowed or expected to be shared - with a party or person.", 0, java.lang.Integer.MAX_VALUE, partyReference));
          children.add(new Property("partyCodeableConcept", "CodeableConcept", "If the processing is a transfer, or involves another party, we must capture where it the data allowed or expected to be shared - with a party or person. This can be a party instance or party type\n§ Purpose – a specific purpose of the data.", 0, java.lang.Integer.MAX_VALUE, partyCodeableConcept));
          children.add(new Property("purpose", "CodeableConcept", "The purpose for which the permission is given.", 0, java.lang.Integer.MAX_VALUE, purpose));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -865196283: /*partyReference*/  return new Property("partyReference", "Reference(Organization)", "If the processing is a transfer, we must capture where it the data allowed or expected to be shared - with a party or person.", 0, java.lang.Integer.MAX_VALUE, partyReference);
          case -1283677221: /*partyCodeableConcept*/  return new Property("partyCodeableConcept", "CodeableConcept", "If the processing is a transfer, or involves another party, we must capture where it the data allowed or expected to be shared - with a party or person. This can be a party instance or party type\n§ Purpose – a specific purpose of the data.", 0, java.lang.Integer.MAX_VALUE, partyCodeableConcept);
          case -220463842: /*purpose*/  return new Property("purpose", "CodeableConcept", "The purpose for which the permission is given.", 0, java.lang.Integer.MAX_VALUE, purpose);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -865196283: /*partyReference*/ return this.partyReference == null ? new Base[0] : this.partyReference.toArray(new Base[this.partyReference.size()]); // Reference
        case -1283677221: /*partyCodeableConcept*/ return this.partyCodeableConcept == null ? new Base[0] : this.partyCodeableConcept.toArray(new Base[this.partyCodeableConcept.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : this.purpose.toArray(new Base[this.purpose.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -865196283: // partyReference
          this.getPartyReference().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1283677221: // partyCodeableConcept
          this.getPartyCodeableConcept().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.getPurpose().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("partyReference")) {
          this.getPartyReference().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partyCodeableConcept")) {
          this.getPartyCodeableConcept().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.getPurpose().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -865196283:  return addPartyReference(); 
        case -1283677221:  return addPartyCodeableConcept(); 
        case -220463842:  return addPurpose(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -865196283: /*partyReference*/ return new String[] {"Reference"};
        case -1283677221: /*partyCodeableConcept*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("partyReference")) {
          return addPartyReference();
        }
        else if (name.equals("partyCodeableConcept")) {
          return addPartyCodeableConcept();
        }
        else if (name.equals("purpose")) {
          return addPurpose();
        }
        else
          return super.addChild(name);
      }

      public PermissionProcessingActivityComponent copy() {
        PermissionProcessingActivityComponent dst = new PermissionProcessingActivityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PermissionProcessingActivityComponent dst) {
        super.copyValues(dst);
        if (partyReference != null) {
          dst.partyReference = new ArrayList<Reference>();
          for (Reference i : partyReference)
            dst.partyReference.add(i.copy());
        };
        if (partyCodeableConcept != null) {
          dst.partyCodeableConcept = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : partyCodeableConcept)
            dst.partyCodeableConcept.add(i.copy());
        };
        if (purpose != null) {
          dst.purpose = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : purpose)
            dst.purpose.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PermissionProcessingActivityComponent))
          return false;
        PermissionProcessingActivityComponent o = (PermissionProcessingActivityComponent) other_;
        return compareDeep(partyReference, o.partyReference, true) && compareDeep(partyCodeableConcept, o.partyCodeableConcept, true)
           && compareDeep(purpose, o.purpose, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PermissionProcessingActivityComponent))
          return false;
        PermissionProcessingActivityComponent o = (PermissionProcessingActivityComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(partyReference, partyCodeableConcept
          , purpose);
      }

  public String fhirType() {
    return "Permission.processingActivity";

  }

  }

    @Block()
    public static class PermissionJustificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Evidence – reference to consent, or a contract, or a policy, or a regulation, or an attachment that contains a screenshot.
         */
        @Child(name = "evidence", type = {Consent.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Evidence – reference to consent, or a contract, or a policy, or a regulation, or an attachment that contains a screenshot", formalDefinition="Evidence – reference to consent, or a contract, or a policy, or a regulation, or an attachment that contains a screenshot." )
        protected List<Reference> evidence;

        /**
         * This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.
         */
        @Child(name = "grounds", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR", formalDefinition="This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR." )
        protected List<CodeableConcept> grounds;

        private static final long serialVersionUID = -146214493L;

    /**
     * Constructor
     */
      public PermissionJustificationComponent() {
        super();
      }

        /**
         * @return {@link #evidence} (Evidence – reference to consent, or a contract, or a policy, or a regulation, or an attachment that contains a screenshot.)
         */
        public List<Reference> getEvidence() { 
          if (this.evidence == null)
            this.evidence = new ArrayList<Reference>();
          return this.evidence;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PermissionJustificationComponent setEvidence(List<Reference> theEvidence) { 
          this.evidence = theEvidence;
          return this;
        }

        public boolean hasEvidence() { 
          if (this.evidence == null)
            return false;
          for (Reference item : this.evidence)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addEvidence() { //3
          Reference t = new Reference();
          if (this.evidence == null)
            this.evidence = new ArrayList<Reference>();
          this.evidence.add(t);
          return t;
        }

        public PermissionJustificationComponent addEvidence(Reference t) { //3
          if (t == null)
            return this;
          if (this.evidence == null)
            this.evidence = new ArrayList<Reference>();
          this.evidence.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #evidence}, creating it if it does not already exist {3}
         */
        public Reference getEvidenceFirstRep() { 
          if (getEvidence().isEmpty()) {
            addEvidence();
          }
          return getEvidence().get(0);
        }

        /**
         * @return {@link #grounds} (This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.)
         */
        public List<CodeableConcept> getGrounds() { 
          if (this.grounds == null)
            this.grounds = new ArrayList<CodeableConcept>();
          return this.grounds;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PermissionJustificationComponent setGrounds(List<CodeableConcept> theGrounds) { 
          this.grounds = theGrounds;
          return this;
        }

        public boolean hasGrounds() { 
          if (this.grounds == null)
            return false;
          for (CodeableConcept item : this.grounds)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addGrounds() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.grounds == null)
            this.grounds = new ArrayList<CodeableConcept>();
          this.grounds.add(t);
          return t;
        }

        public PermissionJustificationComponent addGrounds(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.grounds == null)
            this.grounds = new ArrayList<CodeableConcept>();
          this.grounds.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #grounds}, creating it if it does not already exist {3}
         */
        public CodeableConcept getGroundsFirstRep() { 
          if (getGrounds().isEmpty()) {
            addGrounds();
          }
          return getGrounds().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("evidence", "Reference(Consent)", "Evidence – reference to consent, or a contract, or a policy, or a regulation, or an attachment that contains a screenshot.", 0, java.lang.Integer.MAX_VALUE, evidence));
          children.add(new Property("grounds", "CodeableConcept", "This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.", 0, java.lang.Integer.MAX_VALUE, grounds));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 382967383: /*evidence*/  return new Property("evidence", "Reference(Consent)", "Evidence – reference to consent, or a contract, or a policy, or a regulation, or an attachment that contains a screenshot.", 0, java.lang.Integer.MAX_VALUE, evidence);
          case 293427148: /*grounds*/  return new Property("grounds", "CodeableConcept", "This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.", 0, java.lang.Integer.MAX_VALUE, grounds);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 382967383: /*evidence*/ return this.evidence == null ? new Base[0] : this.evidence.toArray(new Base[this.evidence.size()]); // Reference
        case 293427148: /*grounds*/ return this.grounds == null ? new Base[0] : this.grounds.toArray(new Base[this.grounds.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 382967383: // evidence
          this.getEvidence().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 293427148: // grounds
          this.getGrounds().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("evidence")) {
          this.getEvidence().add(TypeConvertor.castToReference(value));
        } else if (name.equals("grounds")) {
          this.getGrounds().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 382967383:  return addEvidence(); 
        case 293427148:  return addGrounds(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 382967383: /*evidence*/ return new String[] {"Reference"};
        case 293427148: /*grounds*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("evidence")) {
          return addEvidence();
        }
        else if (name.equals("grounds")) {
          return addGrounds();
        }
        else
          return super.addChild(name);
      }

      public PermissionJustificationComponent copy() {
        PermissionJustificationComponent dst = new PermissionJustificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PermissionJustificationComponent dst) {
        super.copyValues(dst);
        if (evidence != null) {
          dst.evidence = new ArrayList<Reference>();
          for (Reference i : evidence)
            dst.evidence.add(i.copy());
        };
        if (grounds != null) {
          dst.grounds = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : grounds)
            dst.grounds.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PermissionJustificationComponent))
          return false;
        PermissionJustificationComponent o = (PermissionJustificationComponent) other_;
        return compareDeep(evidence, o.evidence, true) && compareDeep(grounds, o.grounds, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PermissionJustificationComponent))
          return false;
        PermissionJustificationComponent o = (PermissionJustificationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(evidence, grounds);
      }

  public String fhirType() {
    return "Permission.justification";

  }

  }

    /**
     * Status.
     */
    @Child(name = "status", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="active | entered-in-error | draft | rejected", formalDefinition="Status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/permission-status")
    protected Enumeration<PermissionStatus> status;

    /**
     * grant|refuse.
     */
    @Child(name = "intent", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="grant|refuse", formalDefinition="grant|refuse." )
    protected CodeableConcept intent;

    /**
     * The person or entity that asserts the permission.
     */
    @Child(name = "asserter", type = {Person.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The person or entity that asserts the permission", formalDefinition="The person or entity that asserts the permission." )
    protected Reference asserter;

    /**
     * The date that permission was asserted.
     */
    @Child(name = "assertionDate", type = {DateTimeType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The date that permission was asserted", formalDefinition="The date that permission was asserted." )
    protected List<DateTimeType> assertionDate;

    /**
     * The period in which the permission is active.
     */
    @Child(name = "validity", type = {Period.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The period in which the permission is active", formalDefinition="The period in which the permission is active." )
    protected Period validity;

    /**
     * The purpose for which the permission is given.
     */
    @Child(name = "purpose", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The purpose for which the permission is given", formalDefinition="The purpose for which the permission is given." )
    protected List<CodeableConcept> purpose;

    /**
     * This can be 1) the definition of data elements, or 2) a category or label) e.g. “sensitive”. It could also be a c) graph-like definition of a set of data elements.
     */
    @Child(name = "dataScope", type = {Expression.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="This can be 1) the definition of data elements, or 2) a category or label) e.g. “sensitive”. It could also be a c) graph-like definition of a set of data elements", formalDefinition="This can be 1) the definition of data elements, or 2) a category or label) e.g. “sensitive”. It could also be a c) graph-like definition of a set of data elements." )
    protected List<Expression> dataScope;

    /**
     * A description or definition of which activities are allowed to be done on the data.
     */
    @Child(name = "processingActivity", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A description or definition of which activities are allowed to be done on the data", formalDefinition="A description or definition of which activities are allowed to be done on the data." )
    protected List<PermissionProcessingActivityComponent> processingActivity;

    /**
     * The asserted justification for using the data.
     */
    @Child(name = "justification", type = {}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The asserted justification for using the data", formalDefinition="The asserted justification for using the data." )
    protected PermissionJustificationComponent justification;

    /**
     * What limits apply to the use of the data.
     */
    @Child(name = "usageLimitations", type = {CodeableConcept.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What limits apply to the use of the data", formalDefinition="What limits apply to the use of the data." )
    protected List<CodeableConcept> usageLimitations;

    private static final long serialVersionUID = -1764304363L;

  /**
   * Constructor
   */
    public Permission() {
      super();
    }

  /**
   * Constructor
   */
    public Permission(PermissionStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #status} (Status.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PermissionStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Permission.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PermissionStatus>(new PermissionStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Status.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Permission setStatusElement(Enumeration<PermissionStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Status.
     */
    public PermissionStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Status.
     */
    public Permission setStatus(PermissionStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PermissionStatus>(new PermissionStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #intent} (grant|refuse.)
     */
    public CodeableConcept getIntent() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Permission.intent");
        else if (Configuration.doAutoCreate())
          this.intent = new CodeableConcept(); // cc
      return this.intent;
    }

    public boolean hasIntent() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    /**
     * @param value {@link #intent} (grant|refuse.)
     */
    public Permission setIntent(CodeableConcept value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return {@link #asserter} (The person or entity that asserts the permission.)
     */
    public Reference getAsserter() { 
      if (this.asserter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Permission.asserter");
        else if (Configuration.doAutoCreate())
          this.asserter = new Reference(); // cc
      return this.asserter;
    }

    public boolean hasAsserter() { 
      return this.asserter != null && !this.asserter.isEmpty();
    }

    /**
     * @param value {@link #asserter} (The person or entity that asserts the permission.)
     */
    public Permission setAsserter(Reference value) { 
      this.asserter = value;
      return this;
    }

    /**
     * @return {@link #assertionDate} (The date that permission was asserted.)
     */
    public List<DateTimeType> getAssertionDate() { 
      if (this.assertionDate == null)
        this.assertionDate = new ArrayList<DateTimeType>();
      return this.assertionDate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setAssertionDate(List<DateTimeType> theAssertionDate) { 
      this.assertionDate = theAssertionDate;
      return this;
    }

    public boolean hasAssertionDate() { 
      if (this.assertionDate == null)
        return false;
      for (DateTimeType item : this.assertionDate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #assertionDate} (The date that permission was asserted.)
     */
    public DateTimeType addAssertionDateElement() {//2 
      DateTimeType t = new DateTimeType();
      if (this.assertionDate == null)
        this.assertionDate = new ArrayList<DateTimeType>();
      this.assertionDate.add(t);
      return t;
    }

    /**
     * @param value {@link #assertionDate} (The date that permission was asserted.)
     */
    public Permission addAssertionDate(Date value) { //1
      DateTimeType t = new DateTimeType();
      t.setValue(value);
      if (this.assertionDate == null)
        this.assertionDate = new ArrayList<DateTimeType>();
      this.assertionDate.add(t);
      return this;
    }

    /**
     * @param value {@link #assertionDate} (The date that permission was asserted.)
     */
    public boolean hasAssertionDate(Date value) { 
      if (this.assertionDate == null)
        return false;
      for (DateTimeType v : this.assertionDate)
        if (v.getValue().equals(value)) // dateTime
          return true;
      return false;
    }

    /**
     * @return {@link #validity} (The period in which the permission is active.)
     */
    public Period getValidity() { 
      if (this.validity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Permission.validity");
        else if (Configuration.doAutoCreate())
          this.validity = new Period(); // cc
      return this.validity;
    }

    public boolean hasValidity() { 
      return this.validity != null && !this.validity.isEmpty();
    }

    /**
     * @param value {@link #validity} (The period in which the permission is active.)
     */
    public Permission setValidity(Period value) { 
      this.validity = value;
      return this;
    }

    /**
     * @return {@link #purpose} (The purpose for which the permission is given.)
     */
    public List<CodeableConcept> getPurpose() { 
      if (this.purpose == null)
        this.purpose = new ArrayList<CodeableConcept>();
      return this.purpose;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setPurpose(List<CodeableConcept> thePurpose) { 
      this.purpose = thePurpose;
      return this;
    }

    public boolean hasPurpose() { 
      if (this.purpose == null)
        return false;
      for (CodeableConcept item : this.purpose)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addPurpose() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.purpose == null)
        this.purpose = new ArrayList<CodeableConcept>();
      this.purpose.add(t);
      return t;
    }

    public Permission addPurpose(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.purpose == null)
        this.purpose = new ArrayList<CodeableConcept>();
      this.purpose.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #purpose}, creating it if it does not already exist {3}
     */
    public CodeableConcept getPurposeFirstRep() { 
      if (getPurpose().isEmpty()) {
        addPurpose();
      }
      return getPurpose().get(0);
    }

    /**
     * @return {@link #dataScope} (This can be 1) the definition of data elements, or 2) a category or label) e.g. “sensitive”. It could also be a c) graph-like definition of a set of data elements.)
     */
    public List<Expression> getDataScope() { 
      if (this.dataScope == null)
        this.dataScope = new ArrayList<Expression>();
      return this.dataScope;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setDataScope(List<Expression> theDataScope) { 
      this.dataScope = theDataScope;
      return this;
    }

    public boolean hasDataScope() { 
      if (this.dataScope == null)
        return false;
      for (Expression item : this.dataScope)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Expression addDataScope() { //3
      Expression t = new Expression();
      if (this.dataScope == null)
        this.dataScope = new ArrayList<Expression>();
      this.dataScope.add(t);
      return t;
    }

    public Permission addDataScope(Expression t) { //3
      if (t == null)
        return this;
      if (this.dataScope == null)
        this.dataScope = new ArrayList<Expression>();
      this.dataScope.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dataScope}, creating it if it does not already exist {3}
     */
    public Expression getDataScopeFirstRep() { 
      if (getDataScope().isEmpty()) {
        addDataScope();
      }
      return getDataScope().get(0);
    }

    /**
     * @return {@link #processingActivity} (A description or definition of which activities are allowed to be done on the data.)
     */
    public List<PermissionProcessingActivityComponent> getProcessingActivity() { 
      if (this.processingActivity == null)
        this.processingActivity = new ArrayList<PermissionProcessingActivityComponent>();
      return this.processingActivity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setProcessingActivity(List<PermissionProcessingActivityComponent> theProcessingActivity) { 
      this.processingActivity = theProcessingActivity;
      return this;
    }

    public boolean hasProcessingActivity() { 
      if (this.processingActivity == null)
        return false;
      for (PermissionProcessingActivityComponent item : this.processingActivity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PermissionProcessingActivityComponent addProcessingActivity() { //3
      PermissionProcessingActivityComponent t = new PermissionProcessingActivityComponent();
      if (this.processingActivity == null)
        this.processingActivity = new ArrayList<PermissionProcessingActivityComponent>();
      this.processingActivity.add(t);
      return t;
    }

    public Permission addProcessingActivity(PermissionProcessingActivityComponent t) { //3
      if (t == null)
        return this;
      if (this.processingActivity == null)
        this.processingActivity = new ArrayList<PermissionProcessingActivityComponent>();
      this.processingActivity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #processingActivity}, creating it if it does not already exist {3}
     */
    public PermissionProcessingActivityComponent getProcessingActivityFirstRep() { 
      if (getProcessingActivity().isEmpty()) {
        addProcessingActivity();
      }
      return getProcessingActivity().get(0);
    }

    /**
     * @return {@link #justification} (The asserted justification for using the data.)
     */
    public PermissionJustificationComponent getJustification() { 
      if (this.justification == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Permission.justification");
        else if (Configuration.doAutoCreate())
          this.justification = new PermissionJustificationComponent(); // cc
      return this.justification;
    }

    public boolean hasJustification() { 
      return this.justification != null && !this.justification.isEmpty();
    }

    /**
     * @param value {@link #justification} (The asserted justification for using the data.)
     */
    public Permission setJustification(PermissionJustificationComponent value) { 
      this.justification = value;
      return this;
    }

    /**
     * @return {@link #usageLimitations} (What limits apply to the use of the data.)
     */
    public List<CodeableConcept> getUsageLimitations() { 
      if (this.usageLimitations == null)
        this.usageLimitations = new ArrayList<CodeableConcept>();
      return this.usageLimitations;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setUsageLimitations(List<CodeableConcept> theUsageLimitations) { 
      this.usageLimitations = theUsageLimitations;
      return this;
    }

    public boolean hasUsageLimitations() { 
      if (this.usageLimitations == null)
        return false;
      for (CodeableConcept item : this.usageLimitations)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addUsageLimitations() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.usageLimitations == null)
        this.usageLimitations = new ArrayList<CodeableConcept>();
      this.usageLimitations.add(t);
      return t;
    }

    public Permission addUsageLimitations(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.usageLimitations == null)
        this.usageLimitations = new ArrayList<CodeableConcept>();
      this.usageLimitations.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #usageLimitations}, creating it if it does not already exist {3}
     */
    public CodeableConcept getUsageLimitationsFirstRep() { 
      if (getUsageLimitations().isEmpty()) {
        addUsageLimitations();
      }
      return getUsageLimitations().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("status", "code", "Status.", 0, 1, status));
        children.add(new Property("intent", "CodeableConcept", "grant|refuse.", 0, 1, intent));
        children.add(new Property("asserter", "Reference(Person)", "The person or entity that asserts the permission.", 0, 1, asserter));
        children.add(new Property("assertionDate", "dateTime", "The date that permission was asserted.", 0, java.lang.Integer.MAX_VALUE, assertionDate));
        children.add(new Property("validity", "Period", "The period in which the permission is active.", 0, 1, validity));
        children.add(new Property("purpose", "CodeableConcept", "The purpose for which the permission is given.", 0, java.lang.Integer.MAX_VALUE, purpose));
        children.add(new Property("dataScope", "Expression", "This can be 1) the definition of data elements, or 2) a category or label) e.g. “sensitive”. It could also be a c) graph-like definition of a set of data elements.", 0, java.lang.Integer.MAX_VALUE, dataScope));
        children.add(new Property("processingActivity", "", "A description or definition of which activities are allowed to be done on the data.", 0, java.lang.Integer.MAX_VALUE, processingActivity));
        children.add(new Property("justification", "", "The asserted justification for using the data.", 0, 1, justification));
        children.add(new Property("usageLimitations", "CodeableConcept", "What limits apply to the use of the data.", 0, java.lang.Integer.MAX_VALUE, usageLimitations));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -892481550: /*status*/  return new Property("status", "code", "Status.", 0, 1, status);
        case -1183762788: /*intent*/  return new Property("intent", "CodeableConcept", "grant|refuse.", 0, 1, intent);
        case -373242253: /*asserter*/  return new Property("asserter", "Reference(Person)", "The person or entity that asserts the permission.", 0, 1, asserter);
        case -1498338864: /*assertionDate*/  return new Property("assertionDate", "dateTime", "The date that permission was asserted.", 0, java.lang.Integer.MAX_VALUE, assertionDate);
        case -1421265102: /*validity*/  return new Property("validity", "Period", "The period in which the permission is active.", 0, 1, validity);
        case -220463842: /*purpose*/  return new Property("purpose", "CodeableConcept", "The purpose for which the permission is given.", 0, java.lang.Integer.MAX_VALUE, purpose);
        case -374957878: /*dataScope*/  return new Property("dataScope", "Expression", "This can be 1) the definition of data elements, or 2) a category or label) e.g. “sensitive”. It could also be a c) graph-like definition of a set of data elements.", 0, java.lang.Integer.MAX_VALUE, dataScope);
        case -2117745854: /*processingActivity*/  return new Property("processingActivity", "", "A description or definition of which activities are allowed to be done on the data.", 0, java.lang.Integer.MAX_VALUE, processingActivity);
        case 1864993522: /*justification*/  return new Property("justification", "", "The asserted justification for using the data.", 0, 1, justification);
        case -788364488: /*usageLimitations*/  return new Property("usageLimitations", "CodeableConcept", "What limits apply to the use of the data.", 0, java.lang.Integer.MAX_VALUE, usageLimitations);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PermissionStatus>
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // CodeableConcept
        case -373242253: /*asserter*/ return this.asserter == null ? new Base[0] : new Base[] {this.asserter}; // Reference
        case -1498338864: /*assertionDate*/ return this.assertionDate == null ? new Base[0] : this.assertionDate.toArray(new Base[this.assertionDate.size()]); // DateTimeType
        case -1421265102: /*validity*/ return this.validity == null ? new Base[0] : new Base[] {this.validity}; // Period
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : this.purpose.toArray(new Base[this.purpose.size()]); // CodeableConcept
        case -374957878: /*dataScope*/ return this.dataScope == null ? new Base[0] : this.dataScope.toArray(new Base[this.dataScope.size()]); // Expression
        case -2117745854: /*processingActivity*/ return this.processingActivity == null ? new Base[0] : this.processingActivity.toArray(new Base[this.processingActivity.size()]); // PermissionProcessingActivityComponent
        case 1864993522: /*justification*/ return this.justification == null ? new Base[0] : new Base[] {this.justification}; // PermissionJustificationComponent
        case -788364488: /*usageLimitations*/ return this.usageLimitations == null ? new Base[0] : this.usageLimitations.toArray(new Base[this.usageLimitations.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -892481550: // status
          value = new PermissionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PermissionStatus>
          return value;
        case -1183762788: // intent
          this.intent = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -373242253: // asserter
          this.asserter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1498338864: // assertionDate
          this.getAssertionDate().add(TypeConvertor.castToDateTime(value)); // DateTimeType
          return value;
        case -1421265102: // validity
          this.validity = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -220463842: // purpose
          this.getPurpose().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -374957878: // dataScope
          this.getDataScope().add(TypeConvertor.castToExpression(value)); // Expression
          return value;
        case -2117745854: // processingActivity
          this.getProcessingActivity().add((PermissionProcessingActivityComponent) value); // PermissionProcessingActivityComponent
          return value;
        case 1864993522: // justification
          this.justification = (PermissionJustificationComponent) value; // PermissionJustificationComponent
          return value;
        case -788364488: // usageLimitations
          this.getUsageLimitations().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("status")) {
          value = new PermissionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PermissionStatus>
        } else if (name.equals("intent")) {
          this.intent = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("asserter")) {
          this.asserter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("assertionDate")) {
          this.getAssertionDate().add(TypeConvertor.castToDateTime(value));
        } else if (name.equals("validity")) {
          this.validity = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("purpose")) {
          this.getPurpose().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("dataScope")) {
          this.getDataScope().add(TypeConvertor.castToExpression(value));
        } else if (name.equals("processingActivity")) {
          this.getProcessingActivity().add((PermissionProcessingActivityComponent) value);
        } else if (name.equals("justification")) {
          this.justification = (PermissionJustificationComponent) value; // PermissionJustificationComponent
        } else if (name.equals("usageLimitations")) {
          this.getUsageLimitations().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550:  return getStatusElement();
        case -1183762788:  return getIntent();
        case -373242253:  return getAsserter();
        case -1498338864:  return addAssertionDateElement();
        case -1421265102:  return getValidity();
        case -220463842:  return addPurpose(); 
        case -374957878:  return addDataScope(); 
        case -2117745854:  return addProcessingActivity(); 
        case 1864993522:  return getJustification();
        case -788364488:  return addUsageLimitations(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return new String[] {"code"};
        case -1183762788: /*intent*/ return new String[] {"CodeableConcept"};
        case -373242253: /*asserter*/ return new String[] {"Reference"};
        case -1498338864: /*assertionDate*/ return new String[] {"dateTime"};
        case -1421265102: /*validity*/ return new String[] {"Period"};
        case -220463842: /*purpose*/ return new String[] {"CodeableConcept"};
        case -374957878: /*dataScope*/ return new String[] {"Expression"};
        case -2117745854: /*processingActivity*/ return new String[] {};
        case 1864993522: /*justification*/ return new String[] {};
        case -788364488: /*usageLimitations*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Permission.status");
        }
        else if (name.equals("intent")) {
          this.intent = new CodeableConcept();
          return this.intent;
        }
        else if (name.equals("asserter")) {
          this.asserter = new Reference();
          return this.asserter;
        }
        else if (name.equals("assertionDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Permission.assertionDate");
        }
        else if (name.equals("validity")) {
          this.validity = new Period();
          return this.validity;
        }
        else if (name.equals("purpose")) {
          return addPurpose();
        }
        else if (name.equals("dataScope")) {
          return addDataScope();
        }
        else if (name.equals("processingActivity")) {
          return addProcessingActivity();
        }
        else if (name.equals("justification")) {
          this.justification = new PermissionJustificationComponent();
          return this.justification;
        }
        else if (name.equals("usageLimitations")) {
          return addUsageLimitations();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Permission";

  }

      public Permission copy() {
        Permission dst = new Permission();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Permission dst) {
        super.copyValues(dst);
        dst.status = status == null ? null : status.copy();
        dst.intent = intent == null ? null : intent.copy();
        dst.asserter = asserter == null ? null : asserter.copy();
        if (assertionDate != null) {
          dst.assertionDate = new ArrayList<DateTimeType>();
          for (DateTimeType i : assertionDate)
            dst.assertionDate.add(i.copy());
        };
        dst.validity = validity == null ? null : validity.copy();
        if (purpose != null) {
          dst.purpose = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : purpose)
            dst.purpose.add(i.copy());
        };
        if (dataScope != null) {
          dst.dataScope = new ArrayList<Expression>();
          for (Expression i : dataScope)
            dst.dataScope.add(i.copy());
        };
        if (processingActivity != null) {
          dst.processingActivity = new ArrayList<PermissionProcessingActivityComponent>();
          for (PermissionProcessingActivityComponent i : processingActivity)
            dst.processingActivity.add(i.copy());
        };
        dst.justification = justification == null ? null : justification.copy();
        if (usageLimitations != null) {
          dst.usageLimitations = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : usageLimitations)
            dst.usageLimitations.add(i.copy());
        };
      }

      protected Permission typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Permission))
          return false;
        Permission o = (Permission) other_;
        return compareDeep(status, o.status, true) && compareDeep(intent, o.intent, true) && compareDeep(asserter, o.asserter, true)
           && compareDeep(assertionDate, o.assertionDate, true) && compareDeep(validity, o.validity, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(dataScope, o.dataScope, true) && compareDeep(processingActivity, o.processingActivity, true)
           && compareDeep(justification, o.justification, true) && compareDeep(usageLimitations, o.usageLimitations, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Permission))
          return false;
        Permission o = (Permission) other_;
        return compareValues(status, o.status, true) && compareValues(assertionDate, o.assertionDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(status, intent, asserter
          , assertionDate, validity, purpose, dataScope, processingActivity, justification
          , usageLimitations);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Permission;
   }

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>active | entered-in-error | draft | rejected</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Permission.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Permission.status", description="active | entered-in-error | draft | rejected", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>active | entered-in-error | draft | rejected</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Permission.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}