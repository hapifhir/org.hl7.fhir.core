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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

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
 * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.
 */
@ResourceDef(name="Provenance", profile="http://hl7.org/fhir/StructureDefinition/Provenance")
public class Provenance extends DomainResource {

    public enum ProvenanceEntityRole {
        /**
         * An entity that is used by the activity to produce a new version of that entity.
         */
        REVISION, 
        /**
         * An entity that is copied in full or part by an agent that is not the author of the entity.
         */
        QUOTATION, 
        /**
         * An entity that is used as input to the activity that produced the target.
         */
        SOURCE, 
        /**
         * The record resulting from this event adheres to the protocol, guideline, order set or other definition represented by this entity.
         */
        INSTANTIATES, 
        /**
         * An entity that is removed from accessibility, usually through the DELETE operator.
         */
        REMOVAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ProvenanceEntityRole fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("revision".equals(codeString))
          return REVISION;
        if ("quotation".equals(codeString))
          return QUOTATION;
        if ("source".equals(codeString))
          return SOURCE;
        if ("instantiates".equals(codeString))
          return INSTANTIATES;
        if ("removal".equals(codeString))
          return REMOVAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ProvenanceEntityRole code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REVISION: return "revision";
            case QUOTATION: return "quotation";
            case SOURCE: return "source";
            case INSTANTIATES: return "instantiates";
            case REMOVAL: return "removal";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REVISION: return "http://hl7.org/fhir/provenance-entity-role";
            case QUOTATION: return "http://hl7.org/fhir/provenance-entity-role";
            case SOURCE: return "http://hl7.org/fhir/provenance-entity-role";
            case INSTANTIATES: return "http://hl7.org/fhir/provenance-entity-role";
            case REMOVAL: return "http://hl7.org/fhir/provenance-entity-role";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REVISION: return "An entity that is used by the activity to produce a new version of that entity.";
            case QUOTATION: return "An entity that is copied in full or part by an agent that is not the author of the entity.";
            case SOURCE: return "An entity that is used as input to the activity that produced the target.";
            case INSTANTIATES: return "The record resulting from this event adheres to the protocol, guideline, order set or other definition represented by this entity.";
            case REMOVAL: return "An entity that is removed from accessibility, usually through the DELETE operator.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REVISION: return "Revision";
            case QUOTATION: return "Quotation";
            case SOURCE: return "Source";
            case INSTANTIATES: return "Instantiates";
            case REMOVAL: return "Removal";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ProvenanceEntityRoleEnumFactory implements EnumFactory<ProvenanceEntityRole> {
    public ProvenanceEntityRole fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("revision".equals(codeString))
          return ProvenanceEntityRole.REVISION;
        if ("quotation".equals(codeString))
          return ProvenanceEntityRole.QUOTATION;
        if ("source".equals(codeString))
          return ProvenanceEntityRole.SOURCE;
        if ("instantiates".equals(codeString))
          return ProvenanceEntityRole.INSTANTIATES;
        if ("removal".equals(codeString))
          return ProvenanceEntityRole.REMOVAL;
        throw new IllegalArgumentException("Unknown ProvenanceEntityRole code '"+codeString+"'");
        }
        public Enumeration<ProvenanceEntityRole> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ProvenanceEntityRole>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("revision".equals(codeString))
          return new Enumeration<ProvenanceEntityRole>(this, ProvenanceEntityRole.REVISION);
        if ("quotation".equals(codeString))
          return new Enumeration<ProvenanceEntityRole>(this, ProvenanceEntityRole.QUOTATION);
        if ("source".equals(codeString))
          return new Enumeration<ProvenanceEntityRole>(this, ProvenanceEntityRole.SOURCE);
        if ("instantiates".equals(codeString))
          return new Enumeration<ProvenanceEntityRole>(this, ProvenanceEntityRole.INSTANTIATES);
        if ("removal".equals(codeString))
          return new Enumeration<ProvenanceEntityRole>(this, ProvenanceEntityRole.REMOVAL);
        throw new FHIRException("Unknown ProvenanceEntityRole code '"+codeString+"'");
        }
    public String toCode(ProvenanceEntityRole code) {
      if (code == ProvenanceEntityRole.REVISION)
        return "revision";
      if (code == ProvenanceEntityRole.QUOTATION)
        return "quotation";
      if (code == ProvenanceEntityRole.SOURCE)
        return "source";
      if (code == ProvenanceEntityRole.INSTANTIATES)
        return "instantiates";
      if (code == ProvenanceEntityRole.REMOVAL)
        return "removal";
      return "?";
      }
    public String toSystem(ProvenanceEntityRole code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ProvenanceAgentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The Functional Role of the agent with respect to the activity.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="How the agent participated", formalDefinition="The Functional Role of the agent with respect to the activity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participation-role-type")
        protected CodeableConcept type;

        /**
         * The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What the agents role was", formalDefinition="The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-role-type")
        protected List<CodeableConcept> role;

        /**
         * Indicates who or what performed in the event.
         */
        @Child(name = "who", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The agent that participated in the event", formalDefinition="Indicates who or what performed in the event." )
        protected Reference who;

        /**
         * The agent that delegated authority to perform the activity performed by the agent.who element.
         */
        @Child(name = "onBehalfOf", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The agent that delegated", formalDefinition="The agent that delegated authority to perform the activity performed by the agent.who element." )
        protected Reference onBehalfOf;

        private static final long serialVersionUID = 642650054L;

    /**
     * Constructor
     */
      public ProvenanceAgentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ProvenanceAgentComponent(Reference who) {
        super();
        this.setWho(who);
      }

        /**
         * @return {@link #type} (The Functional Role of the agent with respect to the activity.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvenanceAgentComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The Functional Role of the agent with respect to the activity.)
         */
        public ProvenanceAgentComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #role} (The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.)
         */
        public List<CodeableConcept> getRole() { 
          if (this.role == null)
            this.role = new ArrayList<CodeableConcept>();
          return this.role;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvenanceAgentComponent setRole(List<CodeableConcept> theRole) { 
          this.role = theRole;
          return this;
        }

        public boolean hasRole() { 
          if (this.role == null)
            return false;
          for (CodeableConcept item : this.role)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addRole() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.role == null)
            this.role = new ArrayList<CodeableConcept>();
          this.role.add(t);
          return t;
        }

        public ProvenanceAgentComponent addRole(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.role == null)
            this.role = new ArrayList<CodeableConcept>();
          this.role.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #role}, creating it if it does not already exist {3}
         */
        public CodeableConcept getRoleFirstRep() { 
          if (getRole().isEmpty()) {
            addRole();
          }
          return getRole().get(0);
        }

        /**
         * @return {@link #who} (Indicates who or what performed in the event.)
         */
        public Reference getWho() { 
          if (this.who == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvenanceAgentComponent.who");
            else if (Configuration.doAutoCreate())
              this.who = new Reference(); // cc
          return this.who;
        }

        public boolean hasWho() { 
          return this.who != null && !this.who.isEmpty();
        }

        /**
         * @param value {@link #who} (Indicates who or what performed in the event.)
         */
        public ProvenanceAgentComponent setWho(Reference value) { 
          this.who = value;
          return this;
        }

        /**
         * @return {@link #onBehalfOf} (The agent that delegated authority to perform the activity performed by the agent.who element.)
         */
        public Reference getOnBehalfOf() { 
          if (this.onBehalfOf == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvenanceAgentComponent.onBehalfOf");
            else if (Configuration.doAutoCreate())
              this.onBehalfOf = new Reference(); // cc
          return this.onBehalfOf;
        }

        public boolean hasOnBehalfOf() { 
          return this.onBehalfOf != null && !this.onBehalfOf.isEmpty();
        }

        /**
         * @param value {@link #onBehalfOf} (The agent that delegated authority to perform the activity performed by the agent.who element.)
         */
        public ProvenanceAgentComponent setOnBehalfOf(Reference value) { 
          this.onBehalfOf = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The Functional Role of the agent with respect to the activity.", 0, 1, type));
          children.add(new Property("role", "CodeableConcept", "The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.", 0, java.lang.Integer.MAX_VALUE, role));
          children.add(new Property("who", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Indicates who or what performed in the event.", 0, 1, who));
          children.add(new Property("onBehalfOf", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient)", "The agent that delegated authority to perform the activity performed by the agent.who element.", 0, 1, onBehalfOf));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The Functional Role of the agent with respect to the activity.", 0, 1, type);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.", 0, java.lang.Integer.MAX_VALUE, role);
          case 117694: /*who*/  return new Property("who", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Indicates who or what performed in the event.", 0, 1, who);
          case -14402964: /*onBehalfOf*/  return new Property("onBehalfOf", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient)", "The agent that delegated authority to perform the activity performed by the agent.who element.", 0, 1, onBehalfOf);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3506294: /*role*/ return this.role == null ? new Base[0] : this.role.toArray(new Base[this.role.size()]); // CodeableConcept
        case 117694: /*who*/ return this.who == null ? new Base[0] : new Base[] {this.who}; // Reference
        case -14402964: /*onBehalfOf*/ return this.onBehalfOf == null ? new Base[0] : new Base[] {this.onBehalfOf}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3506294: // role
          this.getRole().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 117694: // who
          this.who = TypeConvertor.castToReference(value); // Reference
          return value;
        case -14402964: // onBehalfOf
          this.onBehalfOf = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("role")) {
          this.getRole().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("who")) {
          this.who = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("onBehalfOf")) {
          this.onBehalfOf = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 3506294:  return addRole(); 
        case 117694:  return getWho();
        case -14402964:  return getOnBehalfOf();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 117694: /*who*/ return new String[] {"Reference"};
        case -14402964: /*onBehalfOf*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("role")) {
          return addRole();
        }
        else if (name.equals("who")) {
          this.who = new Reference();
          return this.who;
        }
        else if (name.equals("onBehalfOf")) {
          this.onBehalfOf = new Reference();
          return this.onBehalfOf;
        }
        else
          return super.addChild(name);
      }

      public ProvenanceAgentComponent copy() {
        ProvenanceAgentComponent dst = new ProvenanceAgentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProvenanceAgentComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (role != null) {
          dst.role = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : role)
            dst.role.add(i.copy());
        };
        dst.who = who == null ? null : who.copy();
        dst.onBehalfOf = onBehalfOf == null ? null : onBehalfOf.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProvenanceAgentComponent))
          return false;
        ProvenanceAgentComponent o = (ProvenanceAgentComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(role, o.role, true) && compareDeep(who, o.who, true)
           && compareDeep(onBehalfOf, o.onBehalfOf, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProvenanceAgentComponent))
          return false;
        ProvenanceAgentComponent o = (ProvenanceAgentComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, role, who, onBehalfOf
          );
      }

  public String fhirType() {
    return "Provenance.agent";

  }

  }

    @Block()
    public static class ProvenanceEntityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * How the entity was used during the activity.
         */
        @Child(name = "role", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="revision | quotation | source | instantiates | removal", formalDefinition="How the entity was used during the activity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/provenance-entity-role")
        protected Enumeration<ProvenanceEntityRole> role;

        /**
         * Identity of the  Entity used. May be a logical or physical uri and maybe absolute or relative.
         */
        @Child(name = "what", type = {Reference.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identity of entity", formalDefinition="Identity of the  Entity used. May be a logical or physical uri and maybe absolute or relative." )
        protected Reference what;

        /**
         * The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other agents. This description can be understood as shorthand for saying that the agent was responsible for the activity which used the entity.
         */
        @Child(name = "agent", type = {ProvenanceAgentComponent.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Entity is attributed to this agent", formalDefinition="The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other agents. This description can be understood as shorthand for saying that the agent was responsible for the activity which used the entity." )
        protected List<ProvenanceAgentComponent> agent;

        private static final long serialVersionUID = 211110220L;

    /**
     * Constructor
     */
      public ProvenanceEntityComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ProvenanceEntityComponent(ProvenanceEntityRole role, Reference what) {
        super();
        this.setRole(role);
        this.setWhat(what);
      }

        /**
         * @return {@link #role} (How the entity was used during the activity.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public Enumeration<ProvenanceEntityRole> getRoleElement() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvenanceEntityComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new Enumeration<ProvenanceEntityRole>(new ProvenanceEntityRoleEnumFactory()); // bb
          return this.role;
        }

        public boolean hasRoleElement() { 
          return this.role != null && !this.role.isEmpty();
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (How the entity was used during the activity.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public ProvenanceEntityComponent setRoleElement(Enumeration<ProvenanceEntityRole> value) { 
          this.role = value;
          return this;
        }

        /**
         * @return How the entity was used during the activity.
         */
        public ProvenanceEntityRole getRole() { 
          return this.role == null ? null : this.role.getValue();
        }

        /**
         * @param value How the entity was used during the activity.
         */
        public ProvenanceEntityComponent setRole(ProvenanceEntityRole value) { 
            if (this.role == null)
              this.role = new Enumeration<ProvenanceEntityRole>(new ProvenanceEntityRoleEnumFactory());
            this.role.setValue(value);
          return this;
        }

        /**
         * @return {@link #what} (Identity of the  Entity used. May be a logical or physical uri and maybe absolute or relative.)
         */
        public Reference getWhat() { 
          if (this.what == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProvenanceEntityComponent.what");
            else if (Configuration.doAutoCreate())
              this.what = new Reference(); // cc
          return this.what;
        }

        public boolean hasWhat() { 
          return this.what != null && !this.what.isEmpty();
        }

        /**
         * @param value {@link #what} (Identity of the  Entity used. May be a logical or physical uri and maybe absolute or relative.)
         */
        public ProvenanceEntityComponent setWhat(Reference value) { 
          this.what = value;
          return this;
        }

        /**
         * @return {@link #agent} (The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other agents. This description can be understood as shorthand for saying that the agent was responsible for the activity which used the entity.)
         */
        public List<ProvenanceAgentComponent> getAgent() { 
          if (this.agent == null)
            this.agent = new ArrayList<ProvenanceAgentComponent>();
          return this.agent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ProvenanceEntityComponent setAgent(List<ProvenanceAgentComponent> theAgent) { 
          this.agent = theAgent;
          return this;
        }

        public boolean hasAgent() { 
          if (this.agent == null)
            return false;
          for (ProvenanceAgentComponent item : this.agent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ProvenanceAgentComponent addAgent() { //3
          ProvenanceAgentComponent t = new ProvenanceAgentComponent();
          if (this.agent == null)
            this.agent = new ArrayList<ProvenanceAgentComponent>();
          this.agent.add(t);
          return t;
        }

        public ProvenanceEntityComponent addAgent(ProvenanceAgentComponent t) { //3
          if (t == null)
            return this;
          if (this.agent == null)
            this.agent = new ArrayList<ProvenanceAgentComponent>();
          this.agent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #agent}, creating it if it does not already exist {3}
         */
        public ProvenanceAgentComponent getAgentFirstRep() { 
          if (getAgent().isEmpty()) {
            addAgent();
          }
          return getAgent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "code", "How the entity was used during the activity.", 0, 1, role));
          children.add(new Property("what", "Reference(Any)", "Identity of the  Entity used. May be a logical or physical uri and maybe absolute or relative.", 0, 1, what));
          children.add(new Property("agent", "@Provenance.agent", "The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other agents. This description can be understood as shorthand for saying that the agent was responsible for the activity which used the entity.", 0, java.lang.Integer.MAX_VALUE, agent));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "code", "How the entity was used during the activity.", 0, 1, role);
          case 3648196: /*what*/  return new Property("what", "Reference(Any)", "Identity of the  Entity used. May be a logical or physical uri and maybe absolute or relative.", 0, 1, what);
          case 92750597: /*agent*/  return new Property("agent", "@Provenance.agent", "The entity is attributed to an agent to express the agent's responsibility for that entity, possibly along with other agents. This description can be understood as shorthand for saying that the agent was responsible for the activity which used the entity.", 0, java.lang.Integer.MAX_VALUE, agent);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // Enumeration<ProvenanceEntityRole>
        case 3648196: /*what*/ return this.what == null ? new Base[0] : new Base[] {this.what}; // Reference
        case 92750597: /*agent*/ return this.agent == null ? new Base[0] : this.agent.toArray(new Base[this.agent.size()]); // ProvenanceAgentComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          value = new ProvenanceEntityRoleEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.role = (Enumeration) value; // Enumeration<ProvenanceEntityRole>
          return value;
        case 3648196: // what
          this.what = TypeConvertor.castToReference(value); // Reference
          return value;
        case 92750597: // agent
          this.getAgent().add((ProvenanceAgentComponent) value); // ProvenanceAgentComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          value = new ProvenanceEntityRoleEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.role = (Enumeration) value; // Enumeration<ProvenanceEntityRole>
        } else if (name.equals("what")) {
          this.what = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("agent")) {
          this.getAgent().add((ProvenanceAgentComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRoleElement();
        case 3648196:  return getWhat();
        case 92750597:  return addAgent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"code"};
        case 3648196: /*what*/ return new String[] {"Reference"};
        case 92750597: /*agent*/ return new String[] {"@Provenance.agent"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          throw new FHIRException("Cannot call addChild on a primitive type Provenance.entity.role");
        }
        else if (name.equals("what")) {
          this.what = new Reference();
          return this.what;
        }
        else if (name.equals("agent")) {
          return addAgent();
        }
        else
          return super.addChild(name);
      }

      public ProvenanceEntityComponent copy() {
        ProvenanceEntityComponent dst = new ProvenanceEntityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProvenanceEntityComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.what = what == null ? null : what.copy();
        if (agent != null) {
          dst.agent = new ArrayList<ProvenanceAgentComponent>();
          for (ProvenanceAgentComponent i : agent)
            dst.agent.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProvenanceEntityComponent))
          return false;
        ProvenanceEntityComponent o = (ProvenanceEntityComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(what, o.what, true) && compareDeep(agent, o.agent, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProvenanceEntityComponent))
          return false;
        ProvenanceEntityComponent o = (ProvenanceEntityComponent) other_;
        return compareValues(role, o.role, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, what, agent);
      }

  public String fhirType() {
    return "Provenance.entity";

  }

  }

    /**
     * The Reference(s) that were generated or updated by  the activity described in this resource. A provenance can point to more than one target if multiple resources were created/updated by the same activity.
     */
    @Child(name = "target", type = {Reference.class}, order=0, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Target Reference(s) (usually version specific)", formalDefinition="The Reference(s) that were generated or updated by  the activity described in this resource. A provenance can point to more than one target if multiple resources were created/updated by the same activity." )
    protected List<Reference> target;

    /**
     * The period during which the activity occurred.
     */
    @Child(name = "occurred", type = {Period.class, DateTimeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the activity occurred", formalDefinition="The period during which the activity occurred." )
    protected DataType occurred;

    /**
     * The instant of time at which the activity was recorded.
     */
    @Child(name = "recorded", type = {InstantType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the activity was recorded / updated", formalDefinition="The instant of time at which the activity was recorded." )
    protected InstantType recorded;

    /**
     * Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.
     */
    @Child(name = "policy", type = {UriType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Policy or plan the activity was defined by", formalDefinition="Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc." )
    protected List<UriType> policy;

    /**
     * Where the activity occurred, if relevant.
     */
    @Child(name = "location", type = {Location.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the activity occurred, if relevant", formalDefinition="Where the activity occurred, if relevant." )
    protected Reference location;

    /**
     * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
     */
    @Child(name = "authorization", type = {CodeableReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Authorization (purposeOfUse) related to the event", formalDefinition="The authorization (e.g., PurposeOfUse) that was used during the event being recorded." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-PurposeOfUse")
    protected List<CodeableReference> authorization;

    /**
     * An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.
     */
    @Child(name = "activity", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Activity that occurred", formalDefinition="An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/provenance-activity-type")
    protected CodeableConcept activity;

    /**
     * Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, ServiceRequest.class, Task.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Workflow authorization within which this event occurred", formalDefinition="Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon." )
    protected List<Reference> basedOn;

    /**
     * The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.
     */
    @Child(name = "patient", type = {Patient.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The patient is the subject of the data created/updated (.target) by the activity", formalDefinition="The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity." )
    protected Reference patient;

    /**
     * This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).
     */
    @Child(name = "encounter", type = {Encounter.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Encounter within which this event occurred or which the event is tightly associated", formalDefinition="This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests)." )
    protected Reference encounter;

    /**
     * An actor taking a role in an activity  for which it can be assigned some degree of responsibility for the activity taking place.
     */
    @Child(name = "agent", type = {}, order=10, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Actor involved", formalDefinition="An actor taking a role in an activity  for which it can be assigned some degree of responsibility for the activity taking place." )
    protected List<ProvenanceAgentComponent> agent;

    /**
     * An entity used in this activity.
     */
    @Child(name = "entity", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An entity used in this activity", formalDefinition="An entity used in this activity." )
    protected List<ProvenanceEntityComponent> entity;

    /**
     * A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the signature is indicated.
     */
    @Child(name = "signature", type = {Signature.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Signature on target", formalDefinition="A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the signature is indicated." )
    protected List<Signature> signature;

    private static final long serialVersionUID = 2001521682L;

  /**
   * Constructor
   */
    public Provenance() {
      super();
    }

  /**
   * Constructor
   */
    public Provenance(Reference target, ProvenanceAgentComponent agent) {
      super();
      this.addTarget(target);
      this.addAgent(agent);
    }

    /**
     * @return {@link #target} (The Reference(s) that were generated or updated by  the activity described in this resource. A provenance can point to more than one target if multiple resources were created/updated by the same activity.)
     */
    public List<Reference> getTarget() { 
      if (this.target == null)
        this.target = new ArrayList<Reference>();
      return this.target;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setTarget(List<Reference> theTarget) { 
      this.target = theTarget;
      return this;
    }

    public boolean hasTarget() { 
      if (this.target == null)
        return false;
      for (Reference item : this.target)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addTarget() { //3
      Reference t = new Reference();
      if (this.target == null)
        this.target = new ArrayList<Reference>();
      this.target.add(t);
      return t;
    }

    public Provenance addTarget(Reference t) { //3
      if (t == null)
        return this;
      if (this.target == null)
        this.target = new ArrayList<Reference>();
      this.target.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #target}, creating it if it does not already exist {3}
     */
    public Reference getTargetFirstRep() { 
      if (getTarget().isEmpty()) {
        addTarget();
      }
      return getTarget().get(0);
    }

    /**
     * @return {@link #occurred} (The period during which the activity occurred.)
     */
    public DataType getOccurred() { 
      return this.occurred;
    }

    /**
     * @return {@link #occurred} (The period during which the activity occurred.)
     */
    public Period getOccurredPeriod() throws FHIRException { 
      if (this.occurred == null)
        this.occurred = new Period();
      if (!(this.occurred instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurred.getClass().getName()+" was encountered");
      return (Period) this.occurred;
    }

    public boolean hasOccurredPeriod() { 
      return this != null && this.occurred instanceof Period;
    }

    /**
     * @return {@link #occurred} (The period during which the activity occurred.)
     */
    public DateTimeType getOccurredDateTimeType() throws FHIRException { 
      if (this.occurred == null)
        this.occurred = new DateTimeType();
      if (!(this.occurred instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurred.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurred;
    }

    public boolean hasOccurredDateTimeType() { 
      return this != null && this.occurred instanceof DateTimeType;
    }

    public boolean hasOccurred() { 
      return this.occurred != null && !this.occurred.isEmpty();
    }

    /**
     * @param value {@link #occurred} (The period during which the activity occurred.)
     */
    public Provenance setOccurred(DataType value) { 
      if (value != null && !(value instanceof Period || value instanceof DateTimeType))
        throw new Error("Not the right type for Provenance.occurred[x]: "+value.fhirType());
      this.occurred = value;
      return this;
    }

    /**
     * @return {@link #recorded} (The instant of time at which the activity was recorded.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public InstantType getRecordedElement() { 
      if (this.recorded == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Provenance.recorded");
        else if (Configuration.doAutoCreate())
          this.recorded = new InstantType(); // bb
      return this.recorded;
    }

    public boolean hasRecordedElement() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    public boolean hasRecorded() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    /**
     * @param value {@link #recorded} (The instant of time at which the activity was recorded.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public Provenance setRecordedElement(InstantType value) { 
      this.recorded = value;
      return this;
    }

    /**
     * @return The instant of time at which the activity was recorded.
     */
    public Date getRecorded() { 
      return this.recorded == null ? null : this.recorded.getValue();
    }

    /**
     * @param value The instant of time at which the activity was recorded.
     */
    public Provenance setRecorded(Date value) { 
      if (value == null)
        this.recorded = null;
      else {
        if (this.recorded == null)
          this.recorded = new InstantType();
        this.recorded.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #policy} (Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.)
     */
    public List<UriType> getPolicy() { 
      if (this.policy == null)
        this.policy = new ArrayList<UriType>();
      return this.policy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setPolicy(List<UriType> thePolicy) { 
      this.policy = thePolicy;
      return this;
    }

    public boolean hasPolicy() { 
      if (this.policy == null)
        return false;
      for (UriType item : this.policy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #policy} (Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.)
     */
    public UriType addPolicyElement() {//2 
      UriType t = new UriType();
      if (this.policy == null)
        this.policy = new ArrayList<UriType>();
      this.policy.add(t);
      return t;
    }

    /**
     * @param value {@link #policy} (Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.)
     */
    public Provenance addPolicy(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.policy == null)
        this.policy = new ArrayList<UriType>();
      this.policy.add(t);
      return this;
    }

    /**
     * @param value {@link #policy} (Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.)
     */
    public boolean hasPolicy(String value) { 
      if (this.policy == null)
        return false;
      for (UriType v : this.policy)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #location} (Where the activity occurred, if relevant.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Provenance.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (Where the activity occurred, if relevant.)
     */
    public Provenance setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #authorization} (The authorization (e.g., PurposeOfUse) that was used during the event being recorded.)
     */
    public List<CodeableReference> getAuthorization() { 
      if (this.authorization == null)
        this.authorization = new ArrayList<CodeableReference>();
      return this.authorization;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setAuthorization(List<CodeableReference> theAuthorization) { 
      this.authorization = theAuthorization;
      return this;
    }

    public boolean hasAuthorization() { 
      if (this.authorization == null)
        return false;
      for (CodeableReference item : this.authorization)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addAuthorization() { //3
      CodeableReference t = new CodeableReference();
      if (this.authorization == null)
        this.authorization = new ArrayList<CodeableReference>();
      this.authorization.add(t);
      return t;
    }

    public Provenance addAuthorization(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.authorization == null)
        this.authorization = new ArrayList<CodeableReference>();
      this.authorization.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #authorization}, creating it if it does not already exist {3}
     */
    public CodeableReference getAuthorizationFirstRep() { 
      if (getAuthorization().isEmpty()) {
        addAuthorization();
      }
      return getAuthorization().get(0);
    }

    /**
     * @return {@link #activity} (An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.)
     */
    public CodeableConcept getActivity() { 
      if (this.activity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Provenance.activity");
        else if (Configuration.doAutoCreate())
          this.activity = new CodeableConcept(); // cc
      return this.activity;
    }

    public boolean hasActivity() { 
      return this.activity != null && !this.activity.isEmpty();
    }

    /**
     * @param value {@link #activity} (An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.)
     */
    public Provenance setActivity(CodeableConcept value) { 
      this.activity = value;
      return this;
    }

    /**
     * @return {@link #basedOn} (Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public Provenance addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #patient} (The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Provenance.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.)
     */
    public Provenance setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #encounter} (This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Provenance.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).)
     */
    public Provenance setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #agent} (An actor taking a role in an activity  for which it can be assigned some degree of responsibility for the activity taking place.)
     */
    public List<ProvenanceAgentComponent> getAgent() { 
      if (this.agent == null)
        this.agent = new ArrayList<ProvenanceAgentComponent>();
      return this.agent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setAgent(List<ProvenanceAgentComponent> theAgent) { 
      this.agent = theAgent;
      return this;
    }

    public boolean hasAgent() { 
      if (this.agent == null)
        return false;
      for (ProvenanceAgentComponent item : this.agent)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ProvenanceAgentComponent addAgent() { //3
      ProvenanceAgentComponent t = new ProvenanceAgentComponent();
      if (this.agent == null)
        this.agent = new ArrayList<ProvenanceAgentComponent>();
      this.agent.add(t);
      return t;
    }

    public Provenance addAgent(ProvenanceAgentComponent t) { //3
      if (t == null)
        return this;
      if (this.agent == null)
        this.agent = new ArrayList<ProvenanceAgentComponent>();
      this.agent.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #agent}, creating it if it does not already exist {3}
     */
    public ProvenanceAgentComponent getAgentFirstRep() { 
      if (getAgent().isEmpty()) {
        addAgent();
      }
      return getAgent().get(0);
    }

    /**
     * @return {@link #entity} (An entity used in this activity.)
     */
    public List<ProvenanceEntityComponent> getEntity() { 
      if (this.entity == null)
        this.entity = new ArrayList<ProvenanceEntityComponent>();
      return this.entity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setEntity(List<ProvenanceEntityComponent> theEntity) { 
      this.entity = theEntity;
      return this;
    }

    public boolean hasEntity() { 
      if (this.entity == null)
        return false;
      for (ProvenanceEntityComponent item : this.entity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ProvenanceEntityComponent addEntity() { //3
      ProvenanceEntityComponent t = new ProvenanceEntityComponent();
      if (this.entity == null)
        this.entity = new ArrayList<ProvenanceEntityComponent>();
      this.entity.add(t);
      return t;
    }

    public Provenance addEntity(ProvenanceEntityComponent t) { //3
      if (t == null)
        return this;
      if (this.entity == null)
        this.entity = new ArrayList<ProvenanceEntityComponent>();
      this.entity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #entity}, creating it if it does not already exist {3}
     */
    public ProvenanceEntityComponent getEntityFirstRep() { 
      if (getEntity().isEmpty()) {
        addEntity();
      }
      return getEntity().get(0);
    }

    /**
     * @return {@link #signature} (A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the signature is indicated.)
     */
    public List<Signature> getSignature() { 
      if (this.signature == null)
        this.signature = new ArrayList<Signature>();
      return this.signature;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Provenance setSignature(List<Signature> theSignature) { 
      this.signature = theSignature;
      return this;
    }

    public boolean hasSignature() { 
      if (this.signature == null)
        return false;
      for (Signature item : this.signature)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Signature addSignature() { //3
      Signature t = new Signature();
      if (this.signature == null)
        this.signature = new ArrayList<Signature>();
      this.signature.add(t);
      return t;
    }

    public Provenance addSignature(Signature t) { //3
      if (t == null)
        return this;
      if (this.signature == null)
        this.signature = new ArrayList<Signature>();
      this.signature.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #signature}, creating it if it does not already exist {3}
     */
    public Signature getSignatureFirstRep() { 
      if (getSignature().isEmpty()) {
        addSignature();
      }
      return getSignature().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("target", "Reference(Any)", "The Reference(s) that were generated or updated by  the activity described in this resource. A provenance can point to more than one target if multiple resources were created/updated by the same activity.", 0, java.lang.Integer.MAX_VALUE, target));
        children.add(new Property("occurred[x]", "Period|dateTime", "The period during which the activity occurred.", 0, 1, occurred));
        children.add(new Property("recorded", "instant", "The instant of time at which the activity was recorded.", 0, 1, recorded));
        children.add(new Property("policy", "uri", "Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.", 0, java.lang.Integer.MAX_VALUE, policy));
        children.add(new Property("location", "Reference(Location)", "Where the activity occurred, if relevant.", 0, 1, location));
        children.add(new Property("authorization", "CodeableReference", "The authorization (e.g., PurposeOfUse) that was used during the event being recorded.", 0, java.lang.Integer.MAX_VALUE, authorization));
        children.add(new Property("activity", "CodeableConcept", "An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.", 0, 1, activity));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest|Task)", "Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("patient", "Reference(Patient)", "The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.", 0, 1, patient));
        children.add(new Property("encounter", "Reference(Encounter)", "This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).", 0, 1, encounter));
        children.add(new Property("agent", "", "An actor taking a role in an activity  for which it can be assigned some degree of responsibility for the activity taking place.", 0, java.lang.Integer.MAX_VALUE, agent));
        children.add(new Property("entity", "", "An entity used in this activity.", 0, java.lang.Integer.MAX_VALUE, entity));
        children.add(new Property("signature", "Signature", "A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the signature is indicated.", 0, java.lang.Integer.MAX_VALUE, signature));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -880905839: /*target*/  return new Property("target", "Reference(Any)", "The Reference(s) that were generated or updated by  the activity described in this resource. A provenance can point to more than one target if multiple resources were created/updated by the same activity.", 0, java.lang.Integer.MAX_VALUE, target);
        case 784181563: /*occurred[x]*/  return new Property("occurred[x]", "Period|dateTime", "The period during which the activity occurred.", 0, 1, occurred);
        case 792816933: /*occurred*/  return new Property("occurred[x]", "Period|dateTime", "The period during which the activity occurred.", 0, 1, occurred);
        case 894082886: /*occurredPeriod*/  return new Property("occurred[x]", "Period", "The period during which the activity occurred.", 0, 1, occurred);
        case 1579027424: /*occurredDateTime*/  return new Property("occurred[x]", "dateTime", "The period during which the activity occurred.", 0, 1, occurred);
        case -799233872: /*recorded*/  return new Property("recorded", "instant", "The instant of time at which the activity was recorded.", 0, 1, recorded);
        case -982670030: /*policy*/  return new Property("policy", "uri", "Policy or plan the activity was defined by. Typically, a single activity may have multiple applicable policy documents, such as patient consent, guarantor funding, etc.", 0, java.lang.Integer.MAX_VALUE, policy);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "Where the activity occurred, if relevant.", 0, 1, location);
        case -1385570183: /*authorization*/  return new Property("authorization", "CodeableReference", "The authorization (e.g., PurposeOfUse) that was used during the event being recorded.", 0, java.lang.Integer.MAX_VALUE, authorization);
        case -1655966961: /*activity*/  return new Property("activity", "CodeableConcept", "An activity is something that occurs over a period of time and acts upon or with entities; it may include consuming, processing, transforming, modifying, relocating, using, or generating entities.", 0, 1, activity);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest|Task)", "Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.", 0, 1, patient);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).", 0, 1, encounter);
        case 92750597: /*agent*/  return new Property("agent", "", "An actor taking a role in an activity  for which it can be assigned some degree of responsibility for the activity taking place.", 0, java.lang.Integer.MAX_VALUE, agent);
        case -1298275357: /*entity*/  return new Property("entity", "", "An entity used in this activity.", 0, java.lang.Integer.MAX_VALUE, entity);
        case 1073584312: /*signature*/  return new Property("signature", "Signature", "A digital signature on the target Reference(s). The signer should match a Provenance.agent. The purpose of the signature is indicated.", 0, java.lang.Integer.MAX_VALUE, signature);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -880905839: /*target*/ return this.target == null ? new Base[0] : this.target.toArray(new Base[this.target.size()]); // Reference
        case 792816933: /*occurred*/ return this.occurred == null ? new Base[0] : new Base[] {this.occurred}; // DataType
        case -799233872: /*recorded*/ return this.recorded == null ? new Base[0] : new Base[] {this.recorded}; // InstantType
        case -982670030: /*policy*/ return this.policy == null ? new Base[0] : this.policy.toArray(new Base[this.policy.size()]); // UriType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -1385570183: /*authorization*/ return this.authorization == null ? new Base[0] : this.authorization.toArray(new Base[this.authorization.size()]); // CodeableReference
        case -1655966961: /*activity*/ return this.activity == null ? new Base[0] : new Base[] {this.activity}; // CodeableConcept
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 92750597: /*agent*/ return this.agent == null ? new Base[0] : this.agent.toArray(new Base[this.agent.size()]); // ProvenanceAgentComponent
        case -1298275357: /*entity*/ return this.entity == null ? new Base[0] : this.entity.toArray(new Base[this.entity.size()]); // ProvenanceEntityComponent
        case 1073584312: /*signature*/ return this.signature == null ? new Base[0] : this.signature.toArray(new Base[this.signature.size()]); // Signature
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -880905839: // target
          this.getTarget().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 792816933: // occurred
          this.occurred = TypeConvertor.castToType(value); // DataType
          return value;
        case -799233872: // recorded
          this.recorded = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case -982670030: // policy
          this.getPolicy().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1385570183: // authorization
          this.getAuthorization().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1655966961: // activity
          this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 92750597: // agent
          this.getAgent().add((ProvenanceAgentComponent) value); // ProvenanceAgentComponent
          return value;
        case -1298275357: // entity
          this.getEntity().add((ProvenanceEntityComponent) value); // ProvenanceEntityComponent
          return value;
        case 1073584312: // signature
          this.getSignature().add(TypeConvertor.castToSignature(value)); // Signature
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("target")) {
          this.getTarget().add(TypeConvertor.castToReference(value));
        } else if (name.equals("occurred[x]")) {
          this.occurred = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("recorded")) {
          this.recorded = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("policy")) {
          this.getPolicy().add(TypeConvertor.castToUri(value));
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("authorization")) {
          this.getAuthorization().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("activity")) {
          this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("agent")) {
          this.getAgent().add((ProvenanceAgentComponent) value);
        } else if (name.equals("entity")) {
          this.getEntity().add((ProvenanceEntityComponent) value);
        } else if (name.equals("signature")) {
          this.getSignature().add(TypeConvertor.castToSignature(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -880905839:  return addTarget(); 
        case 784181563:  return getOccurred();
        case 792816933:  return getOccurred();
        case -799233872:  return getRecordedElement();
        case -982670030:  return addPolicyElement();
        case 1901043637:  return getLocation();
        case -1385570183:  return addAuthorization(); 
        case -1655966961:  return getActivity();
        case -332612366:  return addBasedOn(); 
        case -791418107:  return getPatient();
        case 1524132147:  return getEncounter();
        case 92750597:  return addAgent(); 
        case -1298275357:  return addEntity(); 
        case 1073584312:  return addSignature(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -880905839: /*target*/ return new String[] {"Reference"};
        case 792816933: /*occurred*/ return new String[] {"Period", "dateTime"};
        case -799233872: /*recorded*/ return new String[] {"instant"};
        case -982670030: /*policy*/ return new String[] {"uri"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -1385570183: /*authorization*/ return new String[] {"CodeableReference"};
        case -1655966961: /*activity*/ return new String[] {"CodeableConcept"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 92750597: /*agent*/ return new String[] {};
        case -1298275357: /*entity*/ return new String[] {};
        case 1073584312: /*signature*/ return new String[] {"Signature"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("target")) {
          return addTarget();
        }
        else if (name.equals("occurredPeriod")) {
          this.occurred = new Period();
          return this.occurred;
        }
        else if (name.equals("occurredDateTime")) {
          this.occurred = new DateTimeType();
          return this.occurred;
        }
        else if (name.equals("recorded")) {
          throw new FHIRException("Cannot call addChild on a primitive type Provenance.recorded");
        }
        else if (name.equals("policy")) {
          throw new FHIRException("Cannot call addChild on a primitive type Provenance.policy");
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("authorization")) {
          return addAuthorization();
        }
        else if (name.equals("activity")) {
          this.activity = new CodeableConcept();
          return this.activity;
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("agent")) {
          return addAgent();
        }
        else if (name.equals("entity")) {
          return addEntity();
        }
        else if (name.equals("signature")) {
          return addSignature();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Provenance";

  }

      public Provenance copy() {
        Provenance dst = new Provenance();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Provenance dst) {
        super.copyValues(dst);
        if (target != null) {
          dst.target = new ArrayList<Reference>();
          for (Reference i : target)
            dst.target.add(i.copy());
        };
        dst.occurred = occurred == null ? null : occurred.copy();
        dst.recorded = recorded == null ? null : recorded.copy();
        if (policy != null) {
          dst.policy = new ArrayList<UriType>();
          for (UriType i : policy)
            dst.policy.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        if (authorization != null) {
          dst.authorization = new ArrayList<CodeableReference>();
          for (CodeableReference i : authorization)
            dst.authorization.add(i.copy());
        };
        dst.activity = activity == null ? null : activity.copy();
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.patient = patient == null ? null : patient.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        if (agent != null) {
          dst.agent = new ArrayList<ProvenanceAgentComponent>();
          for (ProvenanceAgentComponent i : agent)
            dst.agent.add(i.copy());
        };
        if (entity != null) {
          dst.entity = new ArrayList<ProvenanceEntityComponent>();
          for (ProvenanceEntityComponent i : entity)
            dst.entity.add(i.copy());
        };
        if (signature != null) {
          dst.signature = new ArrayList<Signature>();
          for (Signature i : signature)
            dst.signature.add(i.copy());
        };
      }

      protected Provenance typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Provenance))
          return false;
        Provenance o = (Provenance) other_;
        return compareDeep(target, o.target, true) && compareDeep(occurred, o.occurred, true) && compareDeep(recorded, o.recorded, true)
           && compareDeep(policy, o.policy, true) && compareDeep(location, o.location, true) && compareDeep(authorization, o.authorization, true)
           && compareDeep(activity, o.activity, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(patient, o.patient, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(agent, o.agent, true) && compareDeep(entity, o.entity, true)
           && compareDeep(signature, o.signature, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Provenance))
          return false;
        Provenance o = (Provenance) other_;
        return compareValues(recorded, o.recorded, true) && compareValues(policy, o.policy, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(target, occurred, recorded
          , policy, location, authorization, activity, basedOn, patient, encounter, agent
          , entity, signature);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Provenance;
   }

 /**
   * Search parameter: <b>activity</b>
   * <p>
   * Description: <b>Activity that occurred</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.activity</b><br>
   * </p>
   */
  @SearchParamDefinition(name="activity", path="Provenance.activity", description="Activity that occurred", type="token" )
  public static final String SP_ACTIVITY = "activity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>activity</b>
   * <p>
   * Description: <b>Activity that occurred</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.activity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTIVITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTIVITY);

 /**
   * Search parameter: <b>agent-role</b>
   * <p>
   * Description: <b>What the agents role was</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.agent.role</b><br>
   * </p>
   */
  @SearchParamDefinition(name="agent-role", path="Provenance.agent.role", description="What the agents role was", type="token" )
  public static final String SP_AGENT_ROLE = "agent-role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>agent-role</b>
   * <p>
   * Description: <b>What the agents role was</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.agent.role</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam AGENT_ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_AGENT_ROLE);

 /**
   * Search parameter: <b>agent-type</b>
   * <p>
   * Description: <b>How the agent participated</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.agent.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="agent-type", path="Provenance.agent.type", description="How the agent participated", type="token" )
  public static final String SP_AGENT_TYPE = "agent-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>agent-type</b>
   * <p>
   * Description: <b>How the agent participated</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.agent.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam AGENT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_AGENT_TYPE);

 /**
   * Search parameter: <b>agent</b>
   * <p>
   * Description: <b>Who participated</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.agent.who</b><br>
   * </p>
   */
  @SearchParamDefinition(name="agent", path="Provenance.agent.who", description="Who participated", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_AGENT = "agent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>agent</b>
   * <p>
   * Description: <b>Who participated</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.agent.who</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AGENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AGENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:agent</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AGENT = new ca.uhn.fhir.model.api.Include("Provenance:agent").toLocked();

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Reference to the service request.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="Provenance.basedOn", description="Reference to the service request.", type="reference", target={CarePlan.class, DeviceRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, ServiceRequest.class, Task.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Reference to the service request.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("Provenance:based-on").toLocked();

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Encounter related to the Provenance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="Provenance.encounter", description="Encounter related to the Provenance", type="reference", target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Encounter related to the Provenance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("Provenance:encounter").toLocked();

 /**
   * Search parameter: <b>entity</b>
   * <p>
   * Description: <b>Identity of entity</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.entity.what</b><br>
   * </p>
   */
  @SearchParamDefinition(name="entity", path="Provenance.entity.what", description="Identity of entity", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_ENTITY = "entity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>entity</b>
   * <p>
   * Description: <b>Identity of entity</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.entity.what</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENTITY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENTITY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:entity</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENTITY = new ca.uhn.fhir.model.api.Include("Provenance:entity").toLocked();

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>Where the activity occurred, if relevant</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="Provenance.location", description="Where the activity occurred, if relevant", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>Where the activity occurred, if relevant</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("Provenance:location").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Where the activity involved patient data</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Provenance.patient", description="Where the activity involved patient data", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Where the activity involved patient data</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Provenance:patient").toLocked();

 /**
   * Search parameter: <b>recorded</b>
   * <p>
   * Description: <b>When the activity was recorded / updated</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Provenance.recorded</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recorded", path="Provenance.recorded", description="When the activity was recorded / updated", type="date" )
  public static final String SP_RECORDED = "recorded";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recorded</b>
   * <p>
   * Description: <b>When the activity was recorded / updated</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Provenance.recorded</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam RECORDED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_RECORDED);

 /**
   * Search parameter: <b>signature-type</b>
   * <p>
   * Description: <b>Indication of the reason the entity signed the object(s)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.signature.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="signature-type", path="Provenance.signature.type", description="Indication of the reason the entity signed the object(s)", type="token" )
  public static final String SP_SIGNATURE_TYPE = "signature-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>signature-type</b>
   * <p>
   * Description: <b>Indication of the reason the entity signed the object(s)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Provenance.signature.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SIGNATURE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SIGNATURE_TYPE);

 /**
   * Search parameter: <b>target</b>
   * <p>
   * Description: <b>Target Reference(s) (usually version specific)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name="target", path="Provenance.target", description="Target Reference(s) (usually version specific)", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_TARGET = "target";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>target</b>
   * <p>
   * Description: <b>Target Reference(s) (usually version specific)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Provenance.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam TARGET = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_TARGET);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Provenance:target</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_TARGET = new ca.uhn.fhir.model.api.Include("Provenance:target").toLocked();

 /**
   * Search parameter: <b>when</b>
   * <p>
   * Description: <b>When the activity occurred</b><br>
   * Type: <b>date</b><br>
   * Path: <b>(Provenance.occurred as dateTime)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="when", path="(Provenance.occurred as dateTime)", description="When the activity occurred", type="date" )
  public static final String SP_WHEN = "when";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>when</b>
   * <p>
   * Description: <b>When the activity occurred</b><br>
   * Type: <b>date</b><br>
   * Path: <b>(Provenance.occurred as dateTime)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam WHEN = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_WHEN);


}

