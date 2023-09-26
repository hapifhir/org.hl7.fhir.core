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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

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
 * Permission resource holds access rules for a given data and context.
 */
@ResourceDef(name="Permission", profile="http://hl7.org/fhir/StructureDefinition/Permission")
public class Permission extends DomainResource {

    public enum PermissionRuleCombining {
        /**
         * The deny overrides combining algorithm is intended for those cases where a deny decision should have priority over a permit decision.
         */
        DENYOVERRIDES, 
        /**
         * The permit overrides combining algorithm is intended for those cases where a permit decision should have priority over a deny decision.
         */
        PERMITOVERRIDES, 
        /**
         * The behavior of this algorithm is identical to that of the “Deny-overrides” rule-combining algorithm with one exception.  The order in which the collection of rules is evaluated SHALL match the order as listed in the permission.
         */
        ORDEREDDENYOVERRIDES, 
        /**
         * The behavior of this algorithm is identical to that of the “Permit-overrides” rule-combining algorithm with one exception.  The order in which the collection of rules is evaluated SHALL match the order as listed in the permission.
         */
        ORDEREDPERMITOVERRIDES, 
        /**
         * The “Deny-unless-permit” combining algorithm is intended for those cases where a permit decision should have priority over a deny decision, and an “Indeterminate” or “NotApplicable” must never be the result. It is particularly useful at the top level in a policy structure to ensure that a PDP will always return a definite “Permit” or “Deny” result.
         */
        DENYUNLESSPERMIT, 
        /**
         * The “Permit-unless-deny” combining algorithm is intended for those cases where a deny decision should have priority over a permit decision, and an “Indeterminate” or “NotApplicable” must never be the result. It is particularly useful at the top level in a policy structure to ensure that a PDP will always return a definite “Permit” or “Deny” result. This algorithm has the following behavior.
         */
        PERMITUNLESSDENY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static PermissionRuleCombining fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("deny-overrides".equals(codeString))
          return DENYOVERRIDES;
        if ("permit-overrides".equals(codeString))
          return PERMITOVERRIDES;
        if ("ordered-deny-overrides".equals(codeString))
          return ORDEREDDENYOVERRIDES;
        if ("ordered-permit-overrides".equals(codeString))
          return ORDEREDPERMITOVERRIDES;
        if ("deny-unless-permit".equals(codeString))
          return DENYUNLESSPERMIT;
        if ("permit-unless-deny".equals(codeString))
          return PERMITUNLESSDENY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown PermissionRuleCombining code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DENYOVERRIDES: return "deny-overrides";
            case PERMITOVERRIDES: return "permit-overrides";
            case ORDEREDDENYOVERRIDES: return "ordered-deny-overrides";
            case ORDEREDPERMITOVERRIDES: return "ordered-permit-overrides";
            case DENYUNLESSPERMIT: return "deny-unless-permit";
            case PERMITUNLESSDENY: return "permit-unless-deny";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DENYOVERRIDES: return "http://hl7.org/fhir/permission-rule-combining";
            case PERMITOVERRIDES: return "http://hl7.org/fhir/permission-rule-combining";
            case ORDEREDDENYOVERRIDES: return "http://hl7.org/fhir/permission-rule-combining";
            case ORDEREDPERMITOVERRIDES: return "http://hl7.org/fhir/permission-rule-combining";
            case DENYUNLESSPERMIT: return "http://hl7.org/fhir/permission-rule-combining";
            case PERMITUNLESSDENY: return "http://hl7.org/fhir/permission-rule-combining";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DENYOVERRIDES: return "The deny overrides combining algorithm is intended for those cases where a deny decision should have priority over a permit decision.";
            case PERMITOVERRIDES: return "The permit overrides combining algorithm is intended for those cases where a permit decision should have priority over a deny decision.";
            case ORDEREDDENYOVERRIDES: return "The behavior of this algorithm is identical to that of the “Deny-overrides” rule-combining algorithm with one exception.  The order in which the collection of rules is evaluated SHALL match the order as listed in the permission.";
            case ORDEREDPERMITOVERRIDES: return "The behavior of this algorithm is identical to that of the “Permit-overrides” rule-combining algorithm with one exception.  The order in which the collection of rules is evaluated SHALL match the order as listed in the permission.";
            case DENYUNLESSPERMIT: return "The “Deny-unless-permit” combining algorithm is intended for those cases where a permit decision should have priority over a deny decision, and an “Indeterminate” or “NotApplicable” must never be the result. It is particularly useful at the top level in a policy structure to ensure that a PDP will always return a definite “Permit” or “Deny” result.";
            case PERMITUNLESSDENY: return "The “Permit-unless-deny” combining algorithm is intended for those cases where a deny decision should have priority over a permit decision, and an “Indeterminate” or “NotApplicable” must never be the result. It is particularly useful at the top level in a policy structure to ensure that a PDP will always return a definite “Permit” or “Deny” result. This algorithm has the following behavior.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DENYOVERRIDES: return "Deny-overrides";
            case PERMITOVERRIDES: return "Permit-overrides";
            case ORDEREDDENYOVERRIDES: return "Ordered-deny-overrides";
            case ORDEREDPERMITOVERRIDES: return "Ordered-permit-overrides";
            case DENYUNLESSPERMIT: return "Deny-unless-permit";
            case PERMITUNLESSDENY: return "Permit-unless-deny";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class PermissionRuleCombiningEnumFactory implements EnumFactory<PermissionRuleCombining> {
    public PermissionRuleCombining fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("deny-overrides".equals(codeString))
          return PermissionRuleCombining.DENYOVERRIDES;
        if ("permit-overrides".equals(codeString))
          return PermissionRuleCombining.PERMITOVERRIDES;
        if ("ordered-deny-overrides".equals(codeString))
          return PermissionRuleCombining.ORDEREDDENYOVERRIDES;
        if ("ordered-permit-overrides".equals(codeString))
          return PermissionRuleCombining.ORDEREDPERMITOVERRIDES;
        if ("deny-unless-permit".equals(codeString))
          return PermissionRuleCombining.DENYUNLESSPERMIT;
        if ("permit-unless-deny".equals(codeString))
          return PermissionRuleCombining.PERMITUNLESSDENY;
        throw new IllegalArgumentException("Unknown PermissionRuleCombining code '"+codeString+"'");
        }
        public Enumeration<PermissionRuleCombining> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.NULL, code);
        if ("deny-overrides".equals(codeString))
          return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.DENYOVERRIDES, code);
        if ("permit-overrides".equals(codeString))
          return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.PERMITOVERRIDES, code);
        if ("ordered-deny-overrides".equals(codeString))
          return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.ORDEREDDENYOVERRIDES, code);
        if ("ordered-permit-overrides".equals(codeString))
          return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.ORDEREDPERMITOVERRIDES, code);
        if ("deny-unless-permit".equals(codeString))
          return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.DENYUNLESSPERMIT, code);
        if ("permit-unless-deny".equals(codeString))
          return new Enumeration<PermissionRuleCombining>(this, PermissionRuleCombining.PERMITUNLESSDENY, code);
        throw new FHIRException("Unknown PermissionRuleCombining code '"+codeString+"'");
        }
    public String toCode(PermissionRuleCombining code) {
      if (code == PermissionRuleCombining.DENYOVERRIDES)
        return "deny-overrides";
      if (code == PermissionRuleCombining.PERMITOVERRIDES)
        return "permit-overrides";
      if (code == PermissionRuleCombining.ORDEREDDENYOVERRIDES)
        return "ordered-deny-overrides";
      if (code == PermissionRuleCombining.ORDEREDPERMITOVERRIDES)
        return "ordered-permit-overrides";
      if (code == PermissionRuleCombining.DENYUNLESSPERMIT)
        return "deny-unless-permit";
      if (code == PermissionRuleCombining.PERMITUNLESSDENY)
        return "permit-unless-deny";
      return "?";
      }
    public String toSystem(PermissionRuleCombining code) {
      return code.getSystem();
      }
    }

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
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/permission-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/permission-status";
            case DRAFT: return "http://hl7.org/fhir/permission-status";
            case REJECTED: return "http://hl7.org/fhir/permission-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "Permission is given.";
            case ENTEREDINERROR: return "Permission was entered in error and is not active.";
            case DRAFT: return "Permission is being defined.";
            case REJECTED: return "Permission not granted.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case ENTEREDINERROR: return "Entered in Error";
            case DRAFT: return "Draft";
            case REJECTED: return "Rejected";
            case NULL: return null;
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
        public Enumeration<PermissionStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PermissionStatus>(this, PermissionStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<PermissionStatus>(this, PermissionStatus.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.ACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.ENTEREDINERROR, code);
        if ("draft".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.DRAFT, code);
        if ("rejected".equals(codeString))
          return new Enumeration<PermissionStatus>(this, PermissionStatus.REJECTED, code);
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
    public static class PermissionJustificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.
         */
        @Child(name = "basis", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The regulatory grounds upon which this Permission builds", formalDefinition="This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-policy")
        protected List<CodeableConcept> basis;

        /**
         * Justifing rational.
         */
        @Child(name = "evidence", type = {Reference.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Justifing rational", formalDefinition="Justifing rational." )
        protected List<Reference> evidence;

        private static final long serialVersionUID = -2023272721L;

    /**
     * Constructor
     */
      public PermissionJustificationComponent() {
        super();
      }

        /**
         * @return {@link #basis} (This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.)
         */
        public List<CodeableConcept> getBasis() { 
          if (this.basis == null)
            this.basis = new ArrayList<CodeableConcept>();
          return this.basis;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PermissionJustificationComponent setBasis(List<CodeableConcept> theBasis) { 
          this.basis = theBasis;
          return this;
        }

        public boolean hasBasis() { 
          if (this.basis == null)
            return false;
          for (CodeableConcept item : this.basis)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addBasis() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.basis == null)
            this.basis = new ArrayList<CodeableConcept>();
          this.basis.add(t);
          return t;
        }

        public PermissionJustificationComponent addBasis(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.basis == null)
            this.basis = new ArrayList<CodeableConcept>();
          this.basis.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #basis}, creating it if it does not already exist {3}
         */
        public CodeableConcept getBasisFirstRep() { 
          if (getBasis().isEmpty()) {
            addBasis();
          }
          return getBasis().get(0);
        }

        /**
         * @return {@link #evidence} (Justifing rational.)
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("basis", "CodeableConcept", "This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.", 0, java.lang.Integer.MAX_VALUE, basis));
          children.add(new Property("evidence", "Reference(Any)", "Justifing rational.", 0, java.lang.Integer.MAX_VALUE, evidence));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 93508670: /*basis*/  return new Property("basis", "CodeableConcept", "This would be a codeableconcept, or a coding, which can be constrained to , for example, the 6 grounds for processing in GDPR.", 0, java.lang.Integer.MAX_VALUE, basis);
          case 382967383: /*evidence*/  return new Property("evidence", "Reference(Any)", "Justifing rational.", 0, java.lang.Integer.MAX_VALUE, evidence);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 93508670: /*basis*/ return this.basis == null ? new Base[0] : this.basis.toArray(new Base[this.basis.size()]); // CodeableConcept
        case 382967383: /*evidence*/ return this.evidence == null ? new Base[0] : this.evidence.toArray(new Base[this.evidence.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 93508670: // basis
          this.getBasis().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 382967383: // evidence
          this.getEvidence().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("basis")) {
          this.getBasis().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("evidence")) {
          this.getEvidence().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("basis")) {
          this.getBasis().remove(value);
        } else if (name.equals("evidence")) {
          this.getEvidence().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 93508670:  return addBasis(); 
        case 382967383:  return addEvidence(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 93508670: /*basis*/ return new String[] {"CodeableConcept"};
        case 382967383: /*evidence*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("basis")) {
          return addBasis();
        }
        else if (name.equals("evidence")) {
          return addEvidence();
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
        if (basis != null) {
          dst.basis = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : basis)
            dst.basis.add(i.copy());
        };
        if (evidence != null) {
          dst.evidence = new ArrayList<Reference>();
          for (Reference i : evidence)
            dst.evidence.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PermissionJustificationComponent))
          return false;
        PermissionJustificationComponent o = (PermissionJustificationComponent) other_;
        return compareDeep(basis, o.basis, true) && compareDeep(evidence, o.evidence, true);
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(basis, evidence);
      }

  public String fhirType() {
    return "Permission.justification";

  }

  }

    @Block()
    public static class RuleComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * deny | permit.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=0, max=1, modifier=true, summary=true)
        @Description(shortDefinition="deny | permit", formalDefinition="deny | permit." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-provision-type")
        protected Enumeration<ConsentProvisionType> type;

        /**
         * A description or definition of which activities are allowed to be done on the data.
         */
        @Child(name = "data", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The selection criteria to identify data that is within scope of this provision", formalDefinition="A description or definition of which activities are allowed to be done on the data." )
        protected List<RuleDataComponent> data;

        /**
         * A description or definition of which activities are allowed to be done on the data.
         */
        @Child(name = "activity", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A description or definition of which activities are allowed to be done on the data", formalDefinition="A description or definition of which activities are allowed to be done on the data." )
        protected List<RuleActivityComponent> activity;

        /**
         * What limits apply to the use of the data.
         */
        @Child(name = "limit", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="What limits apply to the use of the data", formalDefinition="What limits apply to the use of the data." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-label-event-examples")
        protected List<CodeableConcept> limit;

        private static final long serialVersionUID = 1376717588L;

    /**
     * Constructor
     */
      public RuleComponent() {
        super();
      }

        /**
         * @return {@link #type} (deny | permit.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ConsentProvisionType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RuleComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ConsentProvisionType>(new ConsentProvisionTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (deny | permit.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public RuleComponent setTypeElement(Enumeration<ConsentProvisionType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return deny | permit.
         */
        public ConsentProvisionType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value deny | permit.
         */
        public RuleComponent setType(ConsentProvisionType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<ConsentProvisionType>(new ConsentProvisionTypeEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #data} (A description or definition of which activities are allowed to be done on the data.)
         */
        public List<RuleDataComponent> getData() { 
          if (this.data == null)
            this.data = new ArrayList<RuleDataComponent>();
          return this.data;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleComponent setData(List<RuleDataComponent> theData) { 
          this.data = theData;
          return this;
        }

        public boolean hasData() { 
          if (this.data == null)
            return false;
          for (RuleDataComponent item : this.data)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RuleDataComponent addData() { //3
          RuleDataComponent t = new RuleDataComponent();
          if (this.data == null)
            this.data = new ArrayList<RuleDataComponent>();
          this.data.add(t);
          return t;
        }

        public RuleComponent addData(RuleDataComponent t) { //3
          if (t == null)
            return this;
          if (this.data == null)
            this.data = new ArrayList<RuleDataComponent>();
          this.data.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #data}, creating it if it does not already exist {3}
         */
        public RuleDataComponent getDataFirstRep() { 
          if (getData().isEmpty()) {
            addData();
          }
          return getData().get(0);
        }

        /**
         * @return {@link #activity} (A description or definition of which activities are allowed to be done on the data.)
         */
        public List<RuleActivityComponent> getActivity() { 
          if (this.activity == null)
            this.activity = new ArrayList<RuleActivityComponent>();
          return this.activity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleComponent setActivity(List<RuleActivityComponent> theActivity) { 
          this.activity = theActivity;
          return this;
        }

        public boolean hasActivity() { 
          if (this.activity == null)
            return false;
          for (RuleActivityComponent item : this.activity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RuleActivityComponent addActivity() { //3
          RuleActivityComponent t = new RuleActivityComponent();
          if (this.activity == null)
            this.activity = new ArrayList<RuleActivityComponent>();
          this.activity.add(t);
          return t;
        }

        public RuleComponent addActivity(RuleActivityComponent t) { //3
          if (t == null)
            return this;
          if (this.activity == null)
            this.activity = new ArrayList<RuleActivityComponent>();
          this.activity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #activity}, creating it if it does not already exist {3}
         */
        public RuleActivityComponent getActivityFirstRep() { 
          if (getActivity().isEmpty()) {
            addActivity();
          }
          return getActivity().get(0);
        }

        /**
         * @return {@link #limit} (What limits apply to the use of the data.)
         */
        public List<CodeableConcept> getLimit() { 
          if (this.limit == null)
            this.limit = new ArrayList<CodeableConcept>();
          return this.limit;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleComponent setLimit(List<CodeableConcept> theLimit) { 
          this.limit = theLimit;
          return this;
        }

        public boolean hasLimit() { 
          if (this.limit == null)
            return false;
          for (CodeableConcept item : this.limit)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addLimit() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.limit == null)
            this.limit = new ArrayList<CodeableConcept>();
          this.limit.add(t);
          return t;
        }

        public RuleComponent addLimit(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.limit == null)
            this.limit = new ArrayList<CodeableConcept>();
          this.limit.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #limit}, creating it if it does not already exist {3}
         */
        public CodeableConcept getLimitFirstRep() { 
          if (getLimit().isEmpty()) {
            addLimit();
          }
          return getLimit().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "deny | permit.", 0, 1, type));
          children.add(new Property("data", "", "A description or definition of which activities are allowed to be done on the data.", 0, java.lang.Integer.MAX_VALUE, data));
          children.add(new Property("activity", "", "A description or definition of which activities are allowed to be done on the data.", 0, java.lang.Integer.MAX_VALUE, activity));
          children.add(new Property("limit", "CodeableConcept", "What limits apply to the use of the data.", 0, java.lang.Integer.MAX_VALUE, limit));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "deny | permit.", 0, 1, type);
          case 3076010: /*data*/  return new Property("data", "", "A description or definition of which activities are allowed to be done on the data.", 0, java.lang.Integer.MAX_VALUE, data);
          case -1655966961: /*activity*/  return new Property("activity", "", "A description or definition of which activities are allowed to be done on the data.", 0, java.lang.Integer.MAX_VALUE, activity);
          case 102976443: /*limit*/  return new Property("limit", "CodeableConcept", "What limits apply to the use of the data.", 0, java.lang.Integer.MAX_VALUE, limit);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ConsentProvisionType>
        case 3076010: /*data*/ return this.data == null ? new Base[0] : this.data.toArray(new Base[this.data.size()]); // RuleDataComponent
        case -1655966961: /*activity*/ return this.activity == null ? new Base[0] : this.activity.toArray(new Base[this.activity.size()]); // RuleActivityComponent
        case 102976443: /*limit*/ return this.limit == null ? new Base[0] : this.limit.toArray(new Base[this.limit.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConsentProvisionType>
          return value;
        case 3076010: // data
          this.getData().add((RuleDataComponent) value); // RuleDataComponent
          return value;
        case -1655966961: // activity
          this.getActivity().add((RuleActivityComponent) value); // RuleActivityComponent
          return value;
        case 102976443: // limit
          this.getLimit().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConsentProvisionType>
        } else if (name.equals("data")) {
          this.getData().add((RuleDataComponent) value);
        } else if (name.equals("activity")) {
          this.getActivity().add((RuleActivityComponent) value);
        } else if (name.equals("limit")) {
          this.getLimit().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new ConsentProvisionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConsentProvisionType>
        } else if (name.equals("data")) {
          this.getData().add((RuleDataComponent) value);
        } else if (name.equals("activity")) {
          this.getActivity().add((RuleActivityComponent) value);
        } else if (name.equals("limit")) {
          this.getLimit().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 3076010:  return addData(); 
        case -1655966961:  return addActivity(); 
        case 102976443:  return addLimit(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 3076010: /*data*/ return new String[] {};
        case -1655966961: /*activity*/ return new String[] {};
        case 102976443: /*limit*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property Permission.rule.type");
        }
        else if (name.equals("data")) {
          return addData();
        }
        else if (name.equals("activity")) {
          return addActivity();
        }
        else if (name.equals("limit")) {
          return addLimit();
        }
        else
          return super.addChild(name);
      }

      public RuleComponent copy() {
        RuleComponent dst = new RuleComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RuleComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (data != null) {
          dst.data = new ArrayList<RuleDataComponent>();
          for (RuleDataComponent i : data)
            dst.data.add(i.copy());
        };
        if (activity != null) {
          dst.activity = new ArrayList<RuleActivityComponent>();
          for (RuleActivityComponent i : activity)
            dst.activity.add(i.copy());
        };
        if (limit != null) {
          dst.limit = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : limit)
            dst.limit.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RuleComponent))
          return false;
        RuleComponent o = (RuleComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(data, o.data, true) && compareDeep(activity, o.activity, true)
           && compareDeep(limit, o.limit, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RuleComponent))
          return false;
        RuleComponent o = (RuleComponent) other_;
        return compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, data, activity, limit
          );
      }

  public String fhirType() {
    return "Permission.rule";

  }

  }

    @Block()
    public static class RuleDataComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Explicit FHIR Resource references.
         */
        @Child(name = "resource", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Explicit FHIR Resource references", formalDefinition="Explicit FHIR Resource references." )
        protected List<RuleDataResourceComponent> resource;

        /**
         * The data in scope are those with the given codes present in that data .meta.security element.
         */
        @Child(name = "security", type = {Coding.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Security tag code on .meta.security", formalDefinition="The data in scope are those with the given codes present in that data .meta.security element." )
        protected List<Coding> security;

        /**
         * Clinical or Operational Relevant period of time that bounds the data controlled by this rule.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Timeframe encompasing data create/update", formalDefinition="Clinical or Operational Relevant period of time that bounds the data controlled by this rule." )
        protected List<Period> period;

        /**
         * Used when other data selection elements are insufficient.
         */
        @Child(name = "expression", type = {Expression.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Expression identifying the data", formalDefinition="Used when other data selection elements are insufficient." )
        protected Expression expression;

        private static final long serialVersionUID = -774403139L;

    /**
     * Constructor
     */
      public RuleDataComponent() {
        super();
      }

        /**
         * @return {@link #resource} (Explicit FHIR Resource references.)
         */
        public List<RuleDataResourceComponent> getResource() { 
          if (this.resource == null)
            this.resource = new ArrayList<RuleDataResourceComponent>();
          return this.resource;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleDataComponent setResource(List<RuleDataResourceComponent> theResource) { 
          this.resource = theResource;
          return this;
        }

        public boolean hasResource() { 
          if (this.resource == null)
            return false;
          for (RuleDataResourceComponent item : this.resource)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RuleDataResourceComponent addResource() { //3
          RuleDataResourceComponent t = new RuleDataResourceComponent();
          if (this.resource == null)
            this.resource = new ArrayList<RuleDataResourceComponent>();
          this.resource.add(t);
          return t;
        }

        public RuleDataComponent addResource(RuleDataResourceComponent t) { //3
          if (t == null)
            return this;
          if (this.resource == null)
            this.resource = new ArrayList<RuleDataResourceComponent>();
          this.resource.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #resource}, creating it if it does not already exist {3}
         */
        public RuleDataResourceComponent getResourceFirstRep() { 
          if (getResource().isEmpty()) {
            addResource();
          }
          return getResource().get(0);
        }

        /**
         * @return {@link #security} (The data in scope are those with the given codes present in that data .meta.security element.)
         */
        public List<Coding> getSecurity() { 
          if (this.security == null)
            this.security = new ArrayList<Coding>();
          return this.security;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleDataComponent setSecurity(List<Coding> theSecurity) { 
          this.security = theSecurity;
          return this;
        }

        public boolean hasSecurity() { 
          if (this.security == null)
            return false;
          for (Coding item : this.security)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addSecurity() { //3
          Coding t = new Coding();
          if (this.security == null)
            this.security = new ArrayList<Coding>();
          this.security.add(t);
          return t;
        }

        public RuleDataComponent addSecurity(Coding t) { //3
          if (t == null)
            return this;
          if (this.security == null)
            this.security = new ArrayList<Coding>();
          this.security.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #security}, creating it if it does not already exist {3}
         */
        public Coding getSecurityFirstRep() { 
          if (getSecurity().isEmpty()) {
            addSecurity();
          }
          return getSecurity().get(0);
        }

        /**
         * @return {@link #period} (Clinical or Operational Relevant period of time that bounds the data controlled by this rule.)
         */
        public List<Period> getPeriod() { 
          if (this.period == null)
            this.period = new ArrayList<Period>();
          return this.period;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleDataComponent setPeriod(List<Period> thePeriod) { 
          this.period = thePeriod;
          return this;
        }

        public boolean hasPeriod() { 
          if (this.period == null)
            return false;
          for (Period item : this.period)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Period addPeriod() { //3
          Period t = new Period();
          if (this.period == null)
            this.period = new ArrayList<Period>();
          this.period.add(t);
          return t;
        }

        public RuleDataComponent addPeriod(Period t) { //3
          if (t == null)
            return this;
          if (this.period == null)
            this.period = new ArrayList<Period>();
          this.period.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #period}, creating it if it does not already exist {3}
         */
        public Period getPeriodFirstRep() { 
          if (getPeriod().isEmpty()) {
            addPeriod();
          }
          return getPeriod().get(0);
        }

        /**
         * @return {@link #expression} (Used when other data selection elements are insufficient.)
         */
        public Expression getExpression() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RuleDataComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new Expression(); // cc
          return this.expression;
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (Used when other data selection elements are insufficient.)
         */
        public RuleDataComponent setExpression(Expression value) { 
          this.expression = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("resource", "", "Explicit FHIR Resource references.", 0, java.lang.Integer.MAX_VALUE, resource));
          children.add(new Property("security", "Coding", "The data in scope are those with the given codes present in that data .meta.security element.", 0, java.lang.Integer.MAX_VALUE, security));
          children.add(new Property("period", "Period", "Clinical or Operational Relevant period of time that bounds the data controlled by this rule.", 0, java.lang.Integer.MAX_VALUE, period));
          children.add(new Property("expression", "Expression", "Used when other data selection elements are insufficient.", 0, 1, expression));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -341064690: /*resource*/  return new Property("resource", "", "Explicit FHIR Resource references.", 0, java.lang.Integer.MAX_VALUE, resource);
          case 949122880: /*security*/  return new Property("security", "Coding", "The data in scope are those with the given codes present in that data .meta.security element.", 0, java.lang.Integer.MAX_VALUE, security);
          case -991726143: /*period*/  return new Property("period", "Period", "Clinical or Operational Relevant period of time that bounds the data controlled by this rule.", 0, java.lang.Integer.MAX_VALUE, period);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "Used when other data selection elements are insufficient.", 0, 1, expression);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : this.resource.toArray(new Base[this.resource.size()]); // RuleDataResourceComponent
        case 949122880: /*security*/ return this.security == null ? new Base[0] : this.security.toArray(new Base[this.security.size()]); // Coding
        case -991726143: /*period*/ return this.period == null ? new Base[0] : this.period.toArray(new Base[this.period.size()]); // Period
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // Expression
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -341064690: // resource
          this.getResource().add((RuleDataResourceComponent) value); // RuleDataResourceComponent
          return value;
        case 949122880: // security
          this.getSecurity().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case -991726143: // period
          this.getPeriod().add(TypeConvertor.castToPeriod(value)); // Period
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToExpression(value); // Expression
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("resource")) {
          this.getResource().add((RuleDataResourceComponent) value);
        } else if (name.equals("security")) {
          this.getSecurity().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("period")) {
          this.getPeriod().add(TypeConvertor.castToPeriod(value));
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToExpression(value); // Expression
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("resource")) {
          this.getResource().add((RuleDataResourceComponent) value);
        } else if (name.equals("security")) {
          this.getSecurity().remove(value);
        } else if (name.equals("period")) {
          this.getPeriod().remove(value);
        } else if (name.equals("expression")) {
          this.expression = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -341064690:  return addResource(); 
        case 949122880:  return addSecurity(); 
        case -991726143:  return addPeriod(); 
        case -1795452264:  return getExpression();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -341064690: /*resource*/ return new String[] {};
        case 949122880: /*security*/ return new String[] {"Coding"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -1795452264: /*expression*/ return new String[] {"Expression"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("resource")) {
          return addResource();
        }
        else if (name.equals("security")) {
          return addSecurity();
        }
        else if (name.equals("period")) {
          return addPeriod();
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public RuleDataComponent copy() {
        RuleDataComponent dst = new RuleDataComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RuleDataComponent dst) {
        super.copyValues(dst);
        if (resource != null) {
          dst.resource = new ArrayList<RuleDataResourceComponent>();
          for (RuleDataResourceComponent i : resource)
            dst.resource.add(i.copy());
        };
        if (security != null) {
          dst.security = new ArrayList<Coding>();
          for (Coding i : security)
            dst.security.add(i.copy());
        };
        if (period != null) {
          dst.period = new ArrayList<Period>();
          for (Period i : period)
            dst.period.add(i.copy());
        };
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RuleDataComponent))
          return false;
        RuleDataComponent o = (RuleDataComponent) other_;
        return compareDeep(resource, o.resource, true) && compareDeep(security, o.security, true) && compareDeep(period, o.period, true)
           && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RuleDataComponent))
          return false;
        RuleDataComponent o = (RuleDataComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(resource, security, period
          , expression);
      }

  public String fhirType() {
    return "Permission.rule.data";

  }

  }

    @Block()
    public static class RuleDataResourceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * How the resource reference is interpreted when testing consent restrictions.
         */
        @Child(name = "meaning", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="instance | related | dependents | authoredby", formalDefinition="How the resource reference is interpreted when testing consent restrictions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-data-meaning")
        protected Enumeration<ConsentDataMeaning> meaning;

        /**
         * A reference to a specific resource that defines which resources are covered by this consent.
         */
        @Child(name = "reference", type = {Reference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The actual data reference", formalDefinition="A reference to a specific resource that defines which resources are covered by this consent." )
        protected Reference reference;

        private static final long serialVersionUID = 1735979153L;

    /**
     * Constructor
     */
      public RuleDataResourceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RuleDataResourceComponent(ConsentDataMeaning meaning, Reference reference) {
        super();
        this.setMeaning(meaning);
        this.setReference(reference);
      }

        /**
         * @return {@link #meaning} (How the resource reference is interpreted when testing consent restrictions.). This is the underlying object with id, value and extensions. The accessor "getMeaning" gives direct access to the value
         */
        public Enumeration<ConsentDataMeaning> getMeaningElement() { 
          if (this.meaning == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RuleDataResourceComponent.meaning");
            else if (Configuration.doAutoCreate())
              this.meaning = new Enumeration<ConsentDataMeaning>(new ConsentDataMeaningEnumFactory()); // bb
          return this.meaning;
        }

        public boolean hasMeaningElement() { 
          return this.meaning != null && !this.meaning.isEmpty();
        }

        public boolean hasMeaning() { 
          return this.meaning != null && !this.meaning.isEmpty();
        }

        /**
         * @param value {@link #meaning} (How the resource reference is interpreted when testing consent restrictions.). This is the underlying object with id, value and extensions. The accessor "getMeaning" gives direct access to the value
         */
        public RuleDataResourceComponent setMeaningElement(Enumeration<ConsentDataMeaning> value) { 
          this.meaning = value;
          return this;
        }

        /**
         * @return How the resource reference is interpreted when testing consent restrictions.
         */
        public ConsentDataMeaning getMeaning() { 
          return this.meaning == null ? null : this.meaning.getValue();
        }

        /**
         * @param value How the resource reference is interpreted when testing consent restrictions.
         */
        public RuleDataResourceComponent setMeaning(ConsentDataMeaning value) { 
            if (this.meaning == null)
              this.meaning = new Enumeration<ConsentDataMeaning>(new ConsentDataMeaningEnumFactory());
            this.meaning.setValue(value);
          return this;
        }

        /**
         * @return {@link #reference} (A reference to a specific resource that defines which resources are covered by this consent.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RuleDataResourceComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (A reference to a specific resource that defines which resources are covered by this consent.)
         */
        public RuleDataResourceComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("meaning", "code", "How the resource reference is interpreted when testing consent restrictions.", 0, 1, meaning));
          children.add(new Property("reference", "Reference(Any)", "A reference to a specific resource that defines which resources are covered by this consent.", 0, 1, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 938160637: /*meaning*/  return new Property("meaning", "code", "How the resource reference is interpreted when testing consent restrictions.", 0, 1, meaning);
          case -925155509: /*reference*/  return new Property("reference", "Reference(Any)", "A reference to a specific resource that defines which resources are covered by this consent.", 0, 1, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return this.meaning == null ? new Base[0] : new Base[] {this.meaning}; // Enumeration<ConsentDataMeaning>
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 938160637: // meaning
          value = new ConsentDataMeaningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.meaning = (Enumeration) value; // Enumeration<ConsentDataMeaning>
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("meaning")) {
          value = new ConsentDataMeaningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.meaning = (Enumeration) value; // Enumeration<ConsentDataMeaning>
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("meaning")) {
          value = new ConsentDataMeaningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.meaning = (Enumeration) value; // Enumeration<ConsentDataMeaning>
        } else if (name.equals("reference")) {
          this.reference = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637:  return getMeaningElement();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return new String[] {"code"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("meaning")) {
          throw new FHIRException("Cannot call addChild on a singleton property Permission.rule.data.resource.meaning");
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

      public RuleDataResourceComponent copy() {
        RuleDataResourceComponent dst = new RuleDataResourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RuleDataResourceComponent dst) {
        super.copyValues(dst);
        dst.meaning = meaning == null ? null : meaning.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RuleDataResourceComponent))
          return false;
        RuleDataResourceComponent o = (RuleDataResourceComponent) other_;
        return compareDeep(meaning, o.meaning, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RuleDataResourceComponent))
          return false;
        RuleDataResourceComponent o = (RuleDataResourceComponent) other_;
        return compareValues(meaning, o.meaning, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(meaning, reference);
      }

  public String fhirType() {
    return "Permission.rule.data.resource";

  }

  }

    @Block()
    public static class RuleActivityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actor(s) authorized for the defined activity.
         */
        @Child(name = "actor", type = {Device.class, Group.class, CareTeam.class, Organization.class, Patient.class, Practitioner.class, RelatedPerson.class, PractitionerRole.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Authorized actor(s)", formalDefinition="The actor(s) authorized for the defined activity." )
        protected List<Reference> actor;

        /**
         * Actions controlled by this Rule.
         */
        @Child(name = "action", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Actions controlled by this rule", formalDefinition="Actions controlled by this Rule." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/consent-action")
        protected List<CodeableConcept> action;

        /**
         * The purpose for which the permission is given.
         */
        @Child(name = "purpose", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The purpose for which the permission is given", formalDefinition="The purpose for which the permission is given." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-PurposeOfUse")
        protected List<CodeableConcept> purpose;

        private static final long serialVersionUID = 1403721720L;

    /**
     * Constructor
     */
      public RuleActivityComponent() {
        super();
      }

        /**
         * @return {@link #actor} (The actor(s) authorized for the defined activity.)
         */
        public List<Reference> getActor() { 
          if (this.actor == null)
            this.actor = new ArrayList<Reference>();
          return this.actor;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleActivityComponent setActor(List<Reference> theActor) { 
          this.actor = theActor;
          return this;
        }

        public boolean hasActor() { 
          if (this.actor == null)
            return false;
          for (Reference item : this.actor)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addActor() { //3
          Reference t = new Reference();
          if (this.actor == null)
            this.actor = new ArrayList<Reference>();
          this.actor.add(t);
          return t;
        }

        public RuleActivityComponent addActor(Reference t) { //3
          if (t == null)
            return this;
          if (this.actor == null)
            this.actor = new ArrayList<Reference>();
          this.actor.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #actor}, creating it if it does not already exist {3}
         */
        public Reference getActorFirstRep() { 
          if (getActor().isEmpty()) {
            addActor();
          }
          return getActor().get(0);
        }

        /**
         * @return {@link #action} (Actions controlled by this Rule.)
         */
        public List<CodeableConcept> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<CodeableConcept>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RuleActivityComponent setAction(List<CodeableConcept> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (CodeableConcept item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAction() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.action == null)
            this.action = new ArrayList<CodeableConcept>();
          this.action.add(t);
          return t;
        }

        public RuleActivityComponent addAction(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<CodeableConcept>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public CodeableConcept getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
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
        public RuleActivityComponent setPurpose(List<CodeableConcept> thePurpose) { 
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

        public RuleActivityComponent addPurpose(CodeableConcept t) { //3
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
          children.add(new Property("actor", "Reference(Device|Group|CareTeam|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The actor(s) authorized for the defined activity.", 0, java.lang.Integer.MAX_VALUE, actor));
          children.add(new Property("action", "CodeableConcept", "Actions controlled by this Rule.", 0, java.lang.Integer.MAX_VALUE, action));
          children.add(new Property("purpose", "CodeableConcept", "The purpose for which the permission is given.", 0, java.lang.Integer.MAX_VALUE, purpose));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 92645877: /*actor*/  return new Property("actor", "Reference(Device|Group|CareTeam|Organization|Patient|Practitioner|RelatedPerson|PractitionerRole)", "The actor(s) authorized for the defined activity.", 0, java.lang.Integer.MAX_VALUE, actor);
          case -1422950858: /*action*/  return new Property("action", "CodeableConcept", "Actions controlled by this Rule.", 0, java.lang.Integer.MAX_VALUE, action);
          case -220463842: /*purpose*/  return new Property("purpose", "CodeableConcept", "The purpose for which the permission is given.", 0, java.lang.Integer.MAX_VALUE, purpose);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : this.actor.toArray(new Base[this.actor.size()]); // Reference
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : this.purpose.toArray(new Base[this.purpose.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 92645877: // actor
          this.getActor().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1422950858: // action
          this.getAction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.getPurpose().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("actor")) {
          this.getActor().add(TypeConvertor.castToReference(value));
        } else if (name.equals("action")) {
          this.getAction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.getPurpose().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("actor")) {
          this.getActor().remove(value);
        } else if (name.equals("action")) {
          this.getAction().remove(value);
        } else if (name.equals("purpose")) {
          this.getPurpose().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 92645877:  return addActor(); 
        case -1422950858:  return addAction(); 
        case -220463842:  return addPurpose(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 92645877: /*actor*/ return new String[] {"Reference"};
        case -1422950858: /*action*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("actor")) {
          return addActor();
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else if (name.equals("purpose")) {
          return addPurpose();
        }
        else
          return super.addChild(name);
      }

      public RuleActivityComponent copy() {
        RuleActivityComponent dst = new RuleActivityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RuleActivityComponent dst) {
        super.copyValues(dst);
        if (actor != null) {
          dst.actor = new ArrayList<Reference>();
          for (Reference i : actor)
            dst.actor.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : action)
            dst.action.add(i.copy());
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
        if (!(other_ instanceof RuleActivityComponent))
          return false;
        RuleActivityComponent o = (RuleActivityComponent) other_;
        return compareDeep(actor, o.actor, true) && compareDeep(action, o.action, true) && compareDeep(purpose, o.purpose, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RuleActivityComponent))
          return false;
        RuleActivityComponent o = (RuleActivityComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(actor, action, purpose);
      }

  public String fhirType() {
    return "Permission.rule.activity";

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
     * The person or entity that asserts the permission.
     */
    @Child(name = "asserter", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, RelatedPerson.class, HealthcareService.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The person or entity that asserts the permission", formalDefinition="The person or entity that asserts the permission." )
    protected Reference asserter;

    /**
     * The date that permission was asserted.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The date that permission was asserted", formalDefinition="The date that permission was asserted." )
    protected List<DateTimeType> date;

    /**
     * The period in which the permission is active.
     */
    @Child(name = "validity", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The period in which the permission is active", formalDefinition="The period in which the permission is active." )
    protected Period validity;

    /**
     * The asserted justification for using the data.
     */
    @Child(name = "justification", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The asserted justification for using the data", formalDefinition="The asserted justification for using the data." )
    protected PermissionJustificationComponent justification;

    /**
     * Defines a procedure for arriving at an access decision given the set of rules.
     */
    @Child(name = "combining", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="deny-overrides | permit-overrides | ordered-deny-overrides | ordered-permit-overrides | deny-unless-permit | permit-unless-deny", formalDefinition="Defines a procedure for arriving at an access decision given the set of rules." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/permission-rule-combining")
    protected Enumeration<PermissionRuleCombining> combining;

    /**
     * A set of rules.
     */
    @Child(name = "rule", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Constraints to the Permission", formalDefinition="A set of rules." )
    protected List<RuleComponent> rule;

    private static final long serialVersionUID = 1252321973L;

  /**
   * Constructor
   */
    public Permission() {
      super();
    }

  /**
   * Constructor
   */
    public Permission(PermissionStatus status, PermissionRuleCombining combining) {
      super();
      this.setStatus(status);
      this.setCombining(combining);
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
     * @return {@link #date} (The date that permission was asserted.)
     */
    public List<DateTimeType> getDate() { 
      if (this.date == null)
        this.date = new ArrayList<DateTimeType>();
      return this.date;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setDate(List<DateTimeType> theDate) { 
      this.date = theDate;
      return this;
    }

    public boolean hasDate() { 
      if (this.date == null)
        return false;
      for (DateTimeType item : this.date)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #date} (The date that permission was asserted.)
     */
    public DateTimeType addDateElement() {//2 
      DateTimeType t = new DateTimeType();
      if (this.date == null)
        this.date = new ArrayList<DateTimeType>();
      this.date.add(t);
      return t;
    }

    /**
     * @param value {@link #date} (The date that permission was asserted.)
     */
    public Permission addDate(Date value) { //1
      DateTimeType t = new DateTimeType();
      t.setValue(value);
      if (this.date == null)
        this.date = new ArrayList<DateTimeType>();
      this.date.add(t);
      return this;
    }

    /**
     * @param value {@link #date} (The date that permission was asserted.)
     */
    public boolean hasDate(Date value) { 
      if (this.date == null)
        return false;
      for (DateTimeType v : this.date)
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
     * @return {@link #combining} (Defines a procedure for arriving at an access decision given the set of rules.). This is the underlying object with id, value and extensions. The accessor "getCombining" gives direct access to the value
     */
    public Enumeration<PermissionRuleCombining> getCombiningElement() { 
      if (this.combining == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Permission.combining");
        else if (Configuration.doAutoCreate())
          this.combining = new Enumeration<PermissionRuleCombining>(new PermissionRuleCombiningEnumFactory()); // bb
      return this.combining;
    }

    public boolean hasCombiningElement() { 
      return this.combining != null && !this.combining.isEmpty();
    }

    public boolean hasCombining() { 
      return this.combining != null && !this.combining.isEmpty();
    }

    /**
     * @param value {@link #combining} (Defines a procedure for arriving at an access decision given the set of rules.). This is the underlying object with id, value and extensions. The accessor "getCombining" gives direct access to the value
     */
    public Permission setCombiningElement(Enumeration<PermissionRuleCombining> value) { 
      this.combining = value;
      return this;
    }

    /**
     * @return Defines a procedure for arriving at an access decision given the set of rules.
     */
    public PermissionRuleCombining getCombining() { 
      return this.combining == null ? null : this.combining.getValue();
    }

    /**
     * @param value Defines a procedure for arriving at an access decision given the set of rules.
     */
    public Permission setCombining(PermissionRuleCombining value) { 
        if (this.combining == null)
          this.combining = new Enumeration<PermissionRuleCombining>(new PermissionRuleCombiningEnumFactory());
        this.combining.setValue(value);
      return this;
    }

    /**
     * @return {@link #rule} (A set of rules.)
     */
    public List<RuleComponent> getRule() { 
      if (this.rule == null)
        this.rule = new ArrayList<RuleComponent>();
      return this.rule;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Permission setRule(List<RuleComponent> theRule) { 
      this.rule = theRule;
      return this;
    }

    public boolean hasRule() { 
      if (this.rule == null)
        return false;
      for (RuleComponent item : this.rule)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RuleComponent addRule() { //3
      RuleComponent t = new RuleComponent();
      if (this.rule == null)
        this.rule = new ArrayList<RuleComponent>();
      this.rule.add(t);
      return t;
    }

    public Permission addRule(RuleComponent t) { //3
      if (t == null)
        return this;
      if (this.rule == null)
        this.rule = new ArrayList<RuleComponent>();
      this.rule.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #rule}, creating it if it does not already exist {3}
     */
    public RuleComponent getRuleFirstRep() { 
      if (getRule().isEmpty()) {
        addRule();
      }
      return getRule().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("status", "code", "Status.", 0, 1, status));
        children.add(new Property("asserter", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|RelatedPerson|HealthcareService)", "The person or entity that asserts the permission.", 0, 1, asserter));
        children.add(new Property("date", "dateTime", "The date that permission was asserted.", 0, java.lang.Integer.MAX_VALUE, date));
        children.add(new Property("validity", "Period", "The period in which the permission is active.", 0, 1, validity));
        children.add(new Property("justification", "", "The asserted justification for using the data.", 0, 1, justification));
        children.add(new Property("combining", "code", "Defines a procedure for arriving at an access decision given the set of rules.", 0, 1, combining));
        children.add(new Property("rule", "", "A set of rules.", 0, java.lang.Integer.MAX_VALUE, rule));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -892481550: /*status*/  return new Property("status", "code", "Status.", 0, 1, status);
        case -373242253: /*asserter*/  return new Property("asserter", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|RelatedPerson|HealthcareService)", "The person or entity that asserts the permission.", 0, 1, asserter);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date that permission was asserted.", 0, java.lang.Integer.MAX_VALUE, date);
        case -1421265102: /*validity*/  return new Property("validity", "Period", "The period in which the permission is active.", 0, 1, validity);
        case 1864993522: /*justification*/  return new Property("justification", "", "The asserted justification for using the data.", 0, 1, justification);
        case -1806252484: /*combining*/  return new Property("combining", "code", "Defines a procedure for arriving at an access decision given the set of rules.", 0, 1, combining);
        case 3512060: /*rule*/  return new Property("rule", "", "A set of rules.", 0, java.lang.Integer.MAX_VALUE, rule);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PermissionStatus>
        case -373242253: /*asserter*/ return this.asserter == null ? new Base[0] : new Base[] {this.asserter}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : this.date.toArray(new Base[this.date.size()]); // DateTimeType
        case -1421265102: /*validity*/ return this.validity == null ? new Base[0] : new Base[] {this.validity}; // Period
        case 1864993522: /*justification*/ return this.justification == null ? new Base[0] : new Base[] {this.justification}; // PermissionJustificationComponent
        case -1806252484: /*combining*/ return this.combining == null ? new Base[0] : new Base[] {this.combining}; // Enumeration<PermissionRuleCombining>
        case 3512060: /*rule*/ return this.rule == null ? new Base[0] : this.rule.toArray(new Base[this.rule.size()]); // RuleComponent
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
        case -373242253: // asserter
          this.asserter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.getDate().add(TypeConvertor.castToDateTime(value)); // DateTimeType
          return value;
        case -1421265102: // validity
          this.validity = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 1864993522: // justification
          this.justification = (PermissionJustificationComponent) value; // PermissionJustificationComponent
          return value;
        case -1806252484: // combining
          value = new PermissionRuleCombiningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.combining = (Enumeration) value; // Enumeration<PermissionRuleCombining>
          return value;
        case 3512060: // rule
          this.getRule().add((RuleComponent) value); // RuleComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("status")) {
          value = new PermissionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PermissionStatus>
        } else if (name.equals("asserter")) {
          this.asserter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.getDate().add(TypeConvertor.castToDateTime(value));
        } else if (name.equals("validity")) {
          this.validity = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("justification")) {
          this.justification = (PermissionJustificationComponent) value; // PermissionJustificationComponent
        } else if (name.equals("combining")) {
          value = new PermissionRuleCombiningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.combining = (Enumeration) value; // Enumeration<PermissionRuleCombining>
        } else if (name.equals("rule")) {
          this.getRule().add((RuleComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("status")) {
          value = new PermissionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PermissionStatus>
        } else if (name.equals("asserter")) {
          this.asserter = null;
        } else if (name.equals("date")) {
          this.getDate().remove(value);
        } else if (name.equals("validity")) {
          this.validity = null;
        } else if (name.equals("justification")) {
          this.justification = (PermissionJustificationComponent) value; // PermissionJustificationComponent
        } else if (name.equals("combining")) {
          value = new PermissionRuleCombiningEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.combining = (Enumeration) value; // Enumeration<PermissionRuleCombining>
        } else if (name.equals("rule")) {
          this.getRule().add((RuleComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550:  return getStatusElement();
        case -373242253:  return getAsserter();
        case 3076014:  return addDateElement();
        case -1421265102:  return getValidity();
        case 1864993522:  return getJustification();
        case -1806252484:  return getCombiningElement();
        case 3512060:  return addRule(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return new String[] {"code"};
        case -373242253: /*asserter*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case -1421265102: /*validity*/ return new String[] {"Period"};
        case 1864993522: /*justification*/ return new String[] {};
        case -1806252484: /*combining*/ return new String[] {"code"};
        case 3512060: /*rule*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Permission.status");
        }
        else if (name.equals("asserter")) {
          this.asserter = new Reference();
          return this.asserter;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property Permission.date");
        }
        else if (name.equals("validity")) {
          this.validity = new Period();
          return this.validity;
        }
        else if (name.equals("justification")) {
          this.justification = new PermissionJustificationComponent();
          return this.justification;
        }
        else if (name.equals("combining")) {
          throw new FHIRException("Cannot call addChild on a singleton property Permission.combining");
        }
        else if (name.equals("rule")) {
          return addRule();
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
        dst.asserter = asserter == null ? null : asserter.copy();
        if (date != null) {
          dst.date = new ArrayList<DateTimeType>();
          for (DateTimeType i : date)
            dst.date.add(i.copy());
        };
        dst.validity = validity == null ? null : validity.copy();
        dst.justification = justification == null ? null : justification.copy();
        dst.combining = combining == null ? null : combining.copy();
        if (rule != null) {
          dst.rule = new ArrayList<RuleComponent>();
          for (RuleComponent i : rule)
            dst.rule.add(i.copy());
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
        return compareDeep(status, o.status, true) && compareDeep(asserter, o.asserter, true) && compareDeep(date, o.date, true)
           && compareDeep(validity, o.validity, true) && compareDeep(justification, o.justification, true)
           && compareDeep(combining, o.combining, true) && compareDeep(rule, o.rule, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Permission))
          return false;
        Permission o = (Permission) other_;
        return compareValues(status, o.status, true) && compareValues(date, o.date, true) && compareValues(combining, o.combining, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(status, asserter, date, validity
          , justification, combining, rule);
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

