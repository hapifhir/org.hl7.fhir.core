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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR v5.0.0-snapshot2

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
 * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
 */
@ResourceDef(name="CareTeam", profile="http://hl7.org/fhir/StructureDefinition/CareTeam")
public class CareTeam extends DomainResource {

    public enum CareTeamStatus {
        /**
         * The care team has been drafted and proposed, but not yet participating in the coordination and delivery of patient care.
         */
        PROPOSED, 
        /**
         * The care team is currently participating in the coordination and delivery of care.
         */
        ACTIVE, 
        /**
         * The care team is temporarily on hold or suspended and not participating in the coordination and delivery of care.
         */
        SUSPENDED, 
        /**
         * The care team was, but is no longer, participating in the coordination and delivery of care.
         */
        INACTIVE, 
        /**
         * The care team should have never existed.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CareTeamStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposed".equals(codeString))
          return PROPOSED;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("suspended".equals(codeString))
          return SUSPENDED;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CareTeamStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PROPOSED: return "proposed";
            case ACTIVE: return "active";
            case SUSPENDED: return "suspended";
            case INACTIVE: return "inactive";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PROPOSED: return "http://hl7.org/fhir/care-team-status";
            case ACTIVE: return "http://hl7.org/fhir/care-team-status";
            case SUSPENDED: return "http://hl7.org/fhir/care-team-status";
            case INACTIVE: return "http://hl7.org/fhir/care-team-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/care-team-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PROPOSED: return "The care team has been drafted and proposed, but not yet participating in the coordination and delivery of patient care.";
            case ACTIVE: return "The care team is currently participating in the coordination and delivery of care.";
            case SUSPENDED: return "The care team is temporarily on hold or suspended and not participating in the coordination and delivery of care.";
            case INACTIVE: return "The care team was, but is no longer, participating in the coordination and delivery of care.";
            case ENTEREDINERROR: return "The care team should have never existed.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PROPOSED: return "Proposed";
            case ACTIVE: return "Active";
            case SUSPENDED: return "Suspended";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CareTeamStatusEnumFactory implements EnumFactory<CareTeamStatus> {
    public CareTeamStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposed".equals(codeString))
          return CareTeamStatus.PROPOSED;
        if ("active".equals(codeString))
          return CareTeamStatus.ACTIVE;
        if ("suspended".equals(codeString))
          return CareTeamStatus.SUSPENDED;
        if ("inactive".equals(codeString))
          return CareTeamStatus.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return CareTeamStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown CareTeamStatus code '"+codeString+"'");
        }
        public Enumeration<CareTeamStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CareTeamStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("proposed".equals(codeString))
          return new Enumeration<CareTeamStatus>(this, CareTeamStatus.PROPOSED);
        if ("active".equals(codeString))
          return new Enumeration<CareTeamStatus>(this, CareTeamStatus.ACTIVE);
        if ("suspended".equals(codeString))
          return new Enumeration<CareTeamStatus>(this, CareTeamStatus.SUSPENDED);
        if ("inactive".equals(codeString))
          return new Enumeration<CareTeamStatus>(this, CareTeamStatus.INACTIVE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<CareTeamStatus>(this, CareTeamStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown CareTeamStatus code '"+codeString+"'");
        }
    public String toCode(CareTeamStatus code) {
      if (code == CareTeamStatus.PROPOSED)
        return "proposed";
      if (code == CareTeamStatus.ACTIVE)
        return "active";
      if (code == CareTeamStatus.SUSPENDED)
        return "suspended";
      if (code == CareTeamStatus.INACTIVE)
        return "inactive";
      if (code == CareTeamStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(CareTeamStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CareTeamParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates specific responsibility of an individual within the care team, such as "Primary care physician", "Trained social worker counselor", "Caregiver", etc.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of involvement", formalDefinition="Indicates specific responsibility of an individual within the care team, such as \"Primary care physician\", \"Trained social worker counselor\", \"Caregiver\", etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participant-role")
        protected CodeableConcept role;

        /**
         * The specific person or organization who is participating/expected to participate in the care team.
         */
        @Child(name = "member", type = {Practitioner.class, PractitionerRole.class, RelatedPerson.class, Patient.class, Organization.class, CareTeam.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who is involved", formalDefinition="The specific person or organization who is participating/expected to participate in the care team." )
        protected Reference member;

        /**
         * The organization of the practitioner.
         */
        @Child(name = "onBehalfOf", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Organization of the practitioner", formalDefinition="The organization of the practitioner." )
        protected Reference onBehalfOf;

        /**
         * When the member is generally available within this care team.
         */
        @Child(name = "coverage", type = {Period.class, Timing.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the member is generally available within this care team", formalDefinition="When the member is generally available within this care team." )
        protected DataType coverage;

        private static final long serialVersionUID = 192079749L;

    /**
     * Constructor
     */
      public CareTeamParticipantComponent() {
        super();
      }

        /**
         * @return {@link #role} (Indicates specific responsibility of an individual within the care team, such as "Primary care physician", "Trained social worker counselor", "Caregiver", etc.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CareTeamParticipantComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Indicates specific responsibility of an individual within the care team, such as "Primary care physician", "Trained social worker counselor", "Caregiver", etc.)
         */
        public CareTeamParticipantComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #member} (The specific person or organization who is participating/expected to participate in the care team.)
         */
        public Reference getMember() { 
          if (this.member == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CareTeamParticipantComponent.member");
            else if (Configuration.doAutoCreate())
              this.member = new Reference(); // cc
          return this.member;
        }

        public boolean hasMember() { 
          return this.member != null && !this.member.isEmpty();
        }

        /**
         * @param value {@link #member} (The specific person or organization who is participating/expected to participate in the care team.)
         */
        public CareTeamParticipantComponent setMember(Reference value) { 
          this.member = value;
          return this;
        }

        /**
         * @return {@link #onBehalfOf} (The organization of the practitioner.)
         */
        public Reference getOnBehalfOf() { 
          if (this.onBehalfOf == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CareTeamParticipantComponent.onBehalfOf");
            else if (Configuration.doAutoCreate())
              this.onBehalfOf = new Reference(); // cc
          return this.onBehalfOf;
        }

        public boolean hasOnBehalfOf() { 
          return this.onBehalfOf != null && !this.onBehalfOf.isEmpty();
        }

        /**
         * @param value {@link #onBehalfOf} (The organization of the practitioner.)
         */
        public CareTeamParticipantComponent setOnBehalfOf(Reference value) { 
          this.onBehalfOf = value;
          return this;
        }

        /**
         * @return {@link #coverage} (When the member is generally available within this care team.)
         */
        public DataType getCoverage() { 
          return this.coverage;
        }

        /**
         * @return {@link #coverage} (When the member is generally available within this care team.)
         */
        public Period getCoveragePeriod() throws FHIRException { 
          if (this.coverage == null)
            this.coverage = new Period();
          if (!(this.coverage instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.coverage.getClass().getName()+" was encountered");
          return (Period) this.coverage;
        }

        public boolean hasCoveragePeriod() { 
          return this != null && this.coverage instanceof Period;
        }

        /**
         * @return {@link #coverage} (When the member is generally available within this care team.)
         */
        public Timing getCoverageTiming() throws FHIRException { 
          if (this.coverage == null)
            this.coverage = new Timing();
          if (!(this.coverage instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.coverage.getClass().getName()+" was encountered");
          return (Timing) this.coverage;
        }

        public boolean hasCoverageTiming() { 
          return this != null && this.coverage instanceof Timing;
        }

        public boolean hasCoverage() { 
          return this.coverage != null && !this.coverage.isEmpty();
        }

        /**
         * @param value {@link #coverage} (When the member is generally available within this care team.)
         */
        public CareTeamParticipantComponent setCoverage(DataType value) { 
          if (value != null && !(value instanceof Period || value instanceof Timing))
            throw new Error("Not the right type for CareTeam.participant.coverage[x]: "+value.fhirType());
          this.coverage = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "CodeableConcept", "Indicates specific responsibility of an individual within the care team, such as \"Primary care physician\", \"Trained social worker counselor\", \"Caregiver\", etc.", 0, 1, role));
          children.add(new Property("member", "Reference(Practitioner|PractitionerRole|RelatedPerson|Patient|Organization|CareTeam)", "The specific person or organization who is participating/expected to participate in the care team.", 0, 1, member));
          children.add(new Property("onBehalfOf", "Reference(Organization)", "The organization of the practitioner.", 0, 1, onBehalfOf));
          children.add(new Property("coverage[x]", "Period|Timing", "When the member is generally available within this care team.", 0, 1, coverage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Indicates specific responsibility of an individual within the care team, such as \"Primary care physician\", \"Trained social worker counselor\", \"Caregiver\", etc.", 0, 1, role);
          case -1077769574: /*member*/  return new Property("member", "Reference(Practitioner|PractitionerRole|RelatedPerson|Patient|Organization|CareTeam)", "The specific person or organization who is participating/expected to participate in the care team.", 0, 1, member);
          case -14402964: /*onBehalfOf*/  return new Property("onBehalfOf", "Reference(Organization)", "The organization of the practitioner.", 0, 1, onBehalfOf);
          case 227689880: /*coverage[x]*/  return new Property("coverage[x]", "Period|Timing", "When the member is generally available within this care team.", 0, 1, coverage);
          case -351767064: /*coverage*/  return new Property("coverage[x]", "Period|Timing", "When the member is generally available within this care team.", 0, 1, coverage);
          case 1024117193: /*coveragePeriod*/  return new Property("coverage[x]", "Period", "When the member is generally available within this care team.", 0, 1, coverage);
          case 1142178898: /*coverageTiming*/  return new Property("coverage[x]", "Timing", "When the member is generally available within this care team.", 0, 1, coverage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -1077769574: /*member*/ return this.member == null ? new Base[0] : new Base[] {this.member}; // Reference
        case -14402964: /*onBehalfOf*/ return this.onBehalfOf == null ? new Base[0] : new Base[] {this.onBehalfOf}; // Reference
        case -351767064: /*coverage*/ return this.coverage == null ? new Base[0] : new Base[] {this.coverage}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1077769574: // member
          this.member = TypeConvertor.castToReference(value); // Reference
          return value;
        case -14402964: // onBehalfOf
          this.onBehalfOf = TypeConvertor.castToReference(value); // Reference
          return value;
        case -351767064: // coverage
          this.coverage = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("member")) {
          this.member = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("onBehalfOf")) {
          this.onBehalfOf = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("coverage[x]")) {
          this.coverage = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRole();
        case -1077769574:  return getMember();
        case -14402964:  return getOnBehalfOf();
        case 227689880:  return getCoverage();
        case -351767064:  return getCoverage();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -1077769574: /*member*/ return new String[] {"Reference"};
        case -14402964: /*onBehalfOf*/ return new String[] {"Reference"};
        case -351767064: /*coverage*/ return new String[] {"Period", "Timing"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("member")) {
          this.member = new Reference();
          return this.member;
        }
        else if (name.equals("onBehalfOf")) {
          this.onBehalfOf = new Reference();
          return this.onBehalfOf;
        }
        else if (name.equals("coveragePeriod")) {
          this.coverage = new Period();
          return this.coverage;
        }
        else if (name.equals("coverageTiming")) {
          this.coverage = new Timing();
          return this.coverage;
        }
        else
          return super.addChild(name);
      }

      public CareTeamParticipantComponent copy() {
        CareTeamParticipantComponent dst = new CareTeamParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CareTeamParticipantComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.member = member == null ? null : member.copy();
        dst.onBehalfOf = onBehalfOf == null ? null : onBehalfOf.copy();
        dst.coverage = coverage == null ? null : coverage.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CareTeamParticipantComponent))
          return false;
        CareTeamParticipantComponent o = (CareTeamParticipantComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(member, o.member, true) && compareDeep(onBehalfOf, o.onBehalfOf, true)
           && compareDeep(coverage, o.coverage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CareTeamParticipantComponent))
          return false;
        CareTeamParticipantComponent o = (CareTeamParticipantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, member, onBehalfOf
          , coverage);
      }

  public String fhirType() {
    return "CareTeam.participant";

  }

  }

    /**
     * Business identifiers assigned to this care team by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Ids for this team", formalDefinition="Business identifiers assigned to this care team by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * Indicates the current state of the care team.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="proposed | active | suspended | inactive | entered-in-error", formalDefinition="Indicates the current state of the care team." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-team-status")
    protected Enumeration<CareTeamStatus> status;

    /**
     * Identifies what kind of team.  This is to support differentiation between multiple co-existing teams, such as care plan team, episode of care team, longitudinal care team.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of team", formalDefinition="Identifies what kind of team.  This is to support differentiation between multiple co-existing teams, such as care plan team, episode of care team, longitudinal care team." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-team-category")
    protected List<CodeableConcept> category;

    /**
     * A label for human use intended to distinguish like teams.  E.g. the "red" vs. "green" trauma teams.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the team, such as crisis assessment team", formalDefinition="A label for human use intended to distinguish like teams.  E.g. the \"red\" vs. \"green\" trauma teams." )
    protected StringType name;

    /**
     * Identifies the patient or group whose intended care is handled by the team.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who care team is for", formalDefinition="Identifies the patient or group whose intended care is handled by the team." )
    protected Reference subject;

    /**
     * Indicates when the team did (or is intended to) come into effect and end.
     */
    @Child(name = "period", type = {Period.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time period team covers", formalDefinition="Indicates when the team did (or is intended to) come into effect and end." )
    protected Period period;

    /**
     * Identifies all people and organizations who are expected to be involved in the care team.
     */
    @Child(name = "participant", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Members of the team", formalDefinition="Identifies all people and organizations who are expected to be involved in the care team." )
    protected List<CareTeamParticipantComponent> participant;

    /**
     * Describes why the care team exists.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why the care team exists", formalDefinition="Describes why the care team exists." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
    protected List<CodeableReference> reason;

    /**
     * The organization responsible for the care team.
     */
    @Child(name = "managingOrganization", type = {Organization.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Organization responsible for the care team", formalDefinition="The organization responsible for the care team." )
    protected List<Reference> managingOrganization;

    /**
     * A central contact detail for the care team (that applies to all members).
     */
    @Child(name = "telecom", type = {ContactPoint.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A contact detail for the care team (that applies to all members)", formalDefinition="A central contact detail for the care team (that applies to all members)." )
    protected List<ContactPoint> telecom;

    /**
     * Comments made about the CareTeam.
     */
    @Child(name = "note", type = {Annotation.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about the CareTeam", formalDefinition="Comments made about the CareTeam." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 1147350970L;

  /**
   * Constructor
   */
    public CareTeam() {
      super();
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this care team by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CareTeam addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #status} (Indicates the current state of the care team.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<CareTeamStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CareTeam.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<CareTeamStatus>(new CareTeamStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates the current state of the care team.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CareTeam setStatusElement(Enumeration<CareTeamStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Indicates the current state of the care team.
     */
    public CareTeamStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Indicates the current state of the care team.
     */
    public CareTeam setStatus(CareTeamStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<CareTeamStatus>(new CareTeamStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #category} (Identifies what kind of team.  This is to support differentiation between multiple co-existing teams, such as care plan team, episode of care team, longitudinal care team.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public CareTeam addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #name} (A label for human use intended to distinguish like teams.  E.g. the "red" vs. "green" trauma teams.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CareTeam.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A label for human use intended to distinguish like teams.  E.g. the "red" vs. "green" trauma teams.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public CareTeam setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A label for human use intended to distinguish like teams.  E.g. the "red" vs. "green" trauma teams.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A label for human use intended to distinguish like teams.  E.g. the "red" vs. "green" trauma teams.
     */
    public CareTeam setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (Identifies the patient or group whose intended care is handled by the team.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CareTeam.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Identifies the patient or group whose intended care is handled by the team.)
     */
    public CareTeam setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #period} (Indicates when the team did (or is intended to) come into effect and end.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CareTeam.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Indicates when the team did (or is intended to) come into effect and end.)
     */
    public CareTeam setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #participant} (Identifies all people and organizations who are expected to be involved in the care team.)
     */
    public List<CareTeamParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<CareTeamParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setParticipant(List<CareTeamParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (CareTeamParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CareTeamParticipantComponent addParticipant() { //3
      CareTeamParticipantComponent t = new CareTeamParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<CareTeamParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public CareTeam addParticipant(CareTeamParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<CareTeamParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public CareTeamParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #reason} (Describes why the care team exists.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public CareTeam addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #managingOrganization} (The organization responsible for the care team.)
     */
    public List<Reference> getManagingOrganization() { 
      if (this.managingOrganization == null)
        this.managingOrganization = new ArrayList<Reference>();
      return this.managingOrganization;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setManagingOrganization(List<Reference> theManagingOrganization) { 
      this.managingOrganization = theManagingOrganization;
      return this;
    }

    public boolean hasManagingOrganization() { 
      if (this.managingOrganization == null)
        return false;
      for (Reference item : this.managingOrganization)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addManagingOrganization() { //3
      Reference t = new Reference();
      if (this.managingOrganization == null)
        this.managingOrganization = new ArrayList<Reference>();
      this.managingOrganization.add(t);
      return t;
    }

    public CareTeam addManagingOrganization(Reference t) { //3
      if (t == null)
        return this;
      if (this.managingOrganization == null)
        this.managingOrganization = new ArrayList<Reference>();
      this.managingOrganization.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #managingOrganization}, creating it if it does not already exist {3}
     */
    public Reference getManagingOrganizationFirstRep() { 
      if (getManagingOrganization().isEmpty()) {
        addManagingOrganization();
      }
      return getManagingOrganization().get(0);
    }

    /**
     * @return {@link #telecom} (A central contact detail for the care team (that applies to all members).)
     */
    public List<ContactPoint> getTelecom() { 
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      return this.telecom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setTelecom(List<ContactPoint> theTelecom) { 
      this.telecom = theTelecom;
      return this;
    }

    public boolean hasTelecom() { 
      if (this.telecom == null)
        return false;
      for (ContactPoint item : this.telecom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactPoint addTelecom() { //3
      ContactPoint t = new ContactPoint();
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return t;
    }

    public CareTeam addTelecom(ContactPoint t) { //3
      if (t == null)
        return this;
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #telecom}, creating it if it does not already exist {3}
     */
    public ContactPoint getTelecomFirstRep() { 
      if (getTelecom().isEmpty()) {
        addTelecom();
      }
      return getTelecom().get(0);
    }

    /**
     * @return {@link #note} (Comments made about the CareTeam.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CareTeam setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public CareTeam addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this care team by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Indicates the current state of the care team.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "Identifies what kind of team.  This is to support differentiation between multiple co-existing teams, such as care plan team, episode of care team, longitudinal care team.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("name", "string", "A label for human use intended to distinguish like teams.  E.g. the \"red\" vs. \"green\" trauma teams.", 0, 1, name));
        children.add(new Property("subject", "Reference(Patient|Group)", "Identifies the patient or group whose intended care is handled by the team.", 0, 1, subject));
        children.add(new Property("period", "Period", "Indicates when the team did (or is intended to) come into effect and end.", 0, 1, period));
        children.add(new Property("participant", "", "Identifies all people and organizations who are expected to be involved in the care team.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("reason", "CodeableReference(Condition)", "Describes why the care team exists.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("managingOrganization", "Reference(Organization)", "The organization responsible for the care team.", 0, java.lang.Integer.MAX_VALUE, managingOrganization));
        children.add(new Property("telecom", "ContactPoint", "A central contact detail for the care team (that applies to all members).", 0, java.lang.Integer.MAX_VALUE, telecom));
        children.add(new Property("note", "Annotation", "Comments made about the CareTeam.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this care team by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates the current state of the care team.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Identifies what kind of team.  This is to support differentiation between multiple co-existing teams, such as care plan team, episode of care team, longitudinal care team.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3373707: /*name*/  return new Property("name", "string", "A label for human use intended to distinguish like teams.  E.g. the \"red\" vs. \"green\" trauma teams.", 0, 1, name);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "Identifies the patient or group whose intended care is handled by the team.", 0, 1, subject);
        case -991726143: /*period*/  return new Property("period", "Period", "Indicates when the team did (or is intended to) come into effect and end.", 0, 1, period);
        case 767422259: /*participant*/  return new Property("participant", "", "Identifies all people and organizations who are expected to be involved in the care team.", 0, java.lang.Integer.MAX_VALUE, participant);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition)", "Describes why the care team exists.", 0, java.lang.Integer.MAX_VALUE, reason);
        case -2058947787: /*managingOrganization*/  return new Property("managingOrganization", "Reference(Organization)", "The organization responsible for the care team.", 0, java.lang.Integer.MAX_VALUE, managingOrganization);
        case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "A central contact detail for the care team (that applies to all members).", 0, java.lang.Integer.MAX_VALUE, telecom);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments made about the CareTeam.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<CareTeamStatus>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // CareTeamParticipantComponent
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case -2058947787: /*managingOrganization*/ return this.managingOrganization == null ? new Base[0] : this.managingOrganization.toArray(new Base[this.managingOrganization.size()]); // Reference
        case -1429363305: /*telecom*/ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new CareTeamStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<CareTeamStatus>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 767422259: // participant
          this.getParticipant().add((CareTeamParticipantComponent) value); // CareTeamParticipantComponent
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -2058947787: // managingOrganization
          this.getManagingOrganization().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1429363305: // telecom
          this.getTelecom().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new CareTeamStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<CareTeamStatus>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("participant")) {
          this.getParticipant().add((CareTeamParticipantComponent) value);
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("managingOrganization")) {
          this.getManagingOrganization().add(TypeConvertor.castToReference(value));
        } else if (name.equals("telecom")) {
          this.getTelecom().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case 3373707:  return getNameElement();
        case -1867885268:  return getSubject();
        case -991726143:  return getPeriod();
        case 767422259:  return addParticipant(); 
        case -934964668:  return addReason(); 
        case -2058947787:  return addManagingOrganization(); 
        case -1429363305:  return addTelecom(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 767422259: /*participant*/ return new String[] {};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case -2058947787: /*managingOrganization*/ return new String[] {"Reference"};
        case -1429363305: /*telecom*/ return new String[] {"ContactPoint"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CareTeam.status");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CareTeam.name");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("managingOrganization")) {
          return addManagingOrganization();
        }
        else if (name.equals("telecom")) {
          return addTelecom();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CareTeam";

  }

      public CareTeam copy() {
        CareTeam dst = new CareTeam();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CareTeam dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.period = period == null ? null : period.copy();
        if (participant != null) {
          dst.participant = new ArrayList<CareTeamParticipantComponent>();
          for (CareTeamParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (managingOrganization != null) {
          dst.managingOrganization = new ArrayList<Reference>();
          for (Reference i : managingOrganization)
            dst.managingOrganization.add(i.copy());
        };
        if (telecom != null) {
          dst.telecom = new ArrayList<ContactPoint>();
          for (ContactPoint i : telecom)
            dst.telecom.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected CareTeam typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CareTeam))
          return false;
        CareTeam o = (CareTeam) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(category, o.category, true)
           && compareDeep(name, o.name, true) && compareDeep(subject, o.subject, true) && compareDeep(period, o.period, true)
           && compareDeep(participant, o.participant, true) && compareDeep(reason, o.reason, true) && compareDeep(managingOrganization, o.managingOrganization, true)
           && compareDeep(telecom, o.telecom, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CareTeam))
          return false;
        CareTeam o = (CareTeam) other_;
        return compareValues(status, o.status, true) && compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, category
          , name, subject, period, participant, reason, managingOrganization, telecom, note
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CareTeam;
   }


}

