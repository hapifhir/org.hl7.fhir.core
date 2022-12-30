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
 * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.
 */
@ResourceDef(name="AuditEvent", profile="http://hl7.org/fhir/StructureDefinition/AuditEvent")
public class AuditEvent extends DomainResource {

    public enum AuditEventAction {
        /**
         * Create a new database object, such as placing an order.
         */
        C, 
        /**
         * Display or print data, such as a doctor census.
         */
        R, 
        /**
         * Update data, such as revise patient information.
         */
        U, 
        /**
         * Delete items, such as a doctor master file record.
         */
        D, 
        /**
         * Perform a system or application function such as log-on, program execution or use of an object's method, or perform a query/search operation.
         */
        E, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AuditEventAction fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("C".equals(codeString))
          return C;
        if ("R".equals(codeString))
          return R;
        if ("U".equals(codeString))
          return U;
        if ("D".equals(codeString))
          return D;
        if ("E".equals(codeString))
          return E;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AuditEventAction code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case C: return "C";
            case R: return "R";
            case U: return "U";
            case D: return "D";
            case E: return "E";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case C: return "http://hl7.org/fhir/audit-event-action";
            case R: return "http://hl7.org/fhir/audit-event-action";
            case U: return "http://hl7.org/fhir/audit-event-action";
            case D: return "http://hl7.org/fhir/audit-event-action";
            case E: return "http://hl7.org/fhir/audit-event-action";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case C: return "Create a new database object, such as placing an order.";
            case R: return "Display or print data, such as a doctor census.";
            case U: return "Update data, such as revise patient information.";
            case D: return "Delete items, such as a doctor master file record.";
            case E: return "Perform a system or application function such as log-on, program execution or use of an object's method, or perform a query/search operation.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case C: return "Create";
            case R: return "Read/View/Print";
            case U: return "Update";
            case D: return "Delete";
            case E: return "Execute";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AuditEventActionEnumFactory implements EnumFactory<AuditEventAction> {
    public AuditEventAction fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("C".equals(codeString))
          return AuditEventAction.C;
        if ("R".equals(codeString))
          return AuditEventAction.R;
        if ("U".equals(codeString))
          return AuditEventAction.U;
        if ("D".equals(codeString))
          return AuditEventAction.D;
        if ("E".equals(codeString))
          return AuditEventAction.E;
        throw new IllegalArgumentException("Unknown AuditEventAction code '"+codeString+"'");
        }
        public Enumeration<AuditEventAction> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AuditEventAction>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("C".equals(codeString))
          return new Enumeration<AuditEventAction>(this, AuditEventAction.C);
        if ("R".equals(codeString))
          return new Enumeration<AuditEventAction>(this, AuditEventAction.R);
        if ("U".equals(codeString))
          return new Enumeration<AuditEventAction>(this, AuditEventAction.U);
        if ("D".equals(codeString))
          return new Enumeration<AuditEventAction>(this, AuditEventAction.D);
        if ("E".equals(codeString))
          return new Enumeration<AuditEventAction>(this, AuditEventAction.E);
        throw new FHIRException("Unknown AuditEventAction code '"+codeString+"'");
        }
    public String toCode(AuditEventAction code) {
      if (code == AuditEventAction.C)
        return "C";
      if (code == AuditEventAction.R)
        return "R";
      if (code == AuditEventAction.U)
        return "U";
      if (code == AuditEventAction.D)
        return "D";
      if (code == AuditEventAction.E)
        return "E";
      return "?";
      }
    public String toSystem(AuditEventAction code) {
      return code.getSystem();
      }
    }

    public enum AuditEventSeverity {
        /**
         * System is unusable. e.g., This level should only be reported by infrastructure and should not be used by applications.
         */
        EMERGENCY, 
        /**
         * Notification should be sent to trigger action be taken. e.g., Loss of the primary network connection needing attention.
         */
        ALERT, 
        /**
         * Critical conditions. e.g., A failure in the system's primary application that will reset automatically.
         */
        CRITICAL, 
        /**
         * Error conditions. e.g., An application has exceeded its file storage limit and attempts to write are failing. 
         */
        ERROR, 
        /**
         * Warning conditions. May indicate that an error will occur if action is not taken. e.g., A non-root file system has only 2GB remaining.
         */
        WARNING, 
        /**
         * Notice messages. Normal but significant condition. Events that are unusual, but not error conditions.
         */
        NOTICE, 
        /**
         * Normal operational messages that require no action. e.g., An application has started, paused, or ended successfully.
         */
        INFORMATIONAL, 
        /**
         * Debug-level messages. Information useful to developers for debugging the application.
         */
        DEBUG, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AuditEventSeverity fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("emergency".equals(codeString))
          return EMERGENCY;
        if ("alert".equals(codeString))
          return ALERT;
        if ("critical".equals(codeString))
          return CRITICAL;
        if ("error".equals(codeString))
          return ERROR;
        if ("warning".equals(codeString))
          return WARNING;
        if ("notice".equals(codeString))
          return NOTICE;
        if ("informational".equals(codeString))
          return INFORMATIONAL;
        if ("debug".equals(codeString))
          return DEBUG;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AuditEventSeverity code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EMERGENCY: return "emergency";
            case ALERT: return "alert";
            case CRITICAL: return "critical";
            case ERROR: return "error";
            case WARNING: return "warning";
            case NOTICE: return "notice";
            case INFORMATIONAL: return "informational";
            case DEBUG: return "debug";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EMERGENCY: return "http://hl7.org/fhir/audit-event-severity";
            case ALERT: return "http://hl7.org/fhir/audit-event-severity";
            case CRITICAL: return "http://hl7.org/fhir/audit-event-severity";
            case ERROR: return "http://hl7.org/fhir/audit-event-severity";
            case WARNING: return "http://hl7.org/fhir/audit-event-severity";
            case NOTICE: return "http://hl7.org/fhir/audit-event-severity";
            case INFORMATIONAL: return "http://hl7.org/fhir/audit-event-severity";
            case DEBUG: return "http://hl7.org/fhir/audit-event-severity";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EMERGENCY: return "System is unusable. e.g., This level should only be reported by infrastructure and should not be used by applications.";
            case ALERT: return "Notification should be sent to trigger action be taken. e.g., Loss of the primary network connection needing attention.";
            case CRITICAL: return "Critical conditions. e.g., A failure in the system's primary application that will reset automatically.";
            case ERROR: return "Error conditions. e.g., An application has exceeded its file storage limit and attempts to write are failing. ";
            case WARNING: return "Warning conditions. May indicate that an error will occur if action is not taken. e.g., A non-root file system has only 2GB remaining.";
            case NOTICE: return "Notice messages. Normal but significant condition. Events that are unusual, but not error conditions.";
            case INFORMATIONAL: return "Normal operational messages that require no action. e.g., An application has started, paused, or ended successfully.";
            case DEBUG: return "Debug-level messages. Information useful to developers for debugging the application.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EMERGENCY: return "Emergency";
            case ALERT: return "Alert";
            case CRITICAL: return "Critical";
            case ERROR: return "Error";
            case WARNING: return "Warning";
            case NOTICE: return "Notice";
            case INFORMATIONAL: return "Informational";
            case DEBUG: return "Debug";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AuditEventSeverityEnumFactory implements EnumFactory<AuditEventSeverity> {
    public AuditEventSeverity fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("emergency".equals(codeString))
          return AuditEventSeverity.EMERGENCY;
        if ("alert".equals(codeString))
          return AuditEventSeverity.ALERT;
        if ("critical".equals(codeString))
          return AuditEventSeverity.CRITICAL;
        if ("error".equals(codeString))
          return AuditEventSeverity.ERROR;
        if ("warning".equals(codeString))
          return AuditEventSeverity.WARNING;
        if ("notice".equals(codeString))
          return AuditEventSeverity.NOTICE;
        if ("informational".equals(codeString))
          return AuditEventSeverity.INFORMATIONAL;
        if ("debug".equals(codeString))
          return AuditEventSeverity.DEBUG;
        throw new IllegalArgumentException("Unknown AuditEventSeverity code '"+codeString+"'");
        }
        public Enumeration<AuditEventSeverity> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AuditEventSeverity>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("emergency".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.EMERGENCY);
        if ("alert".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.ALERT);
        if ("critical".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.CRITICAL);
        if ("error".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.ERROR);
        if ("warning".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.WARNING);
        if ("notice".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.NOTICE);
        if ("informational".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.INFORMATIONAL);
        if ("debug".equals(codeString))
          return new Enumeration<AuditEventSeverity>(this, AuditEventSeverity.DEBUG);
        throw new FHIRException("Unknown AuditEventSeverity code '"+codeString+"'");
        }
    public String toCode(AuditEventSeverity code) {
      if (code == AuditEventSeverity.EMERGENCY)
        return "emergency";
      if (code == AuditEventSeverity.ALERT)
        return "alert";
      if (code == AuditEventSeverity.CRITICAL)
        return "critical";
      if (code == AuditEventSeverity.ERROR)
        return "error";
      if (code == AuditEventSeverity.WARNING)
        return "warning";
      if (code == AuditEventSeverity.NOTICE)
        return "notice";
      if (code == AuditEventSeverity.INFORMATIONAL)
        return "informational";
      if (code == AuditEventSeverity.DEBUG)
        return "debug";
      return "?";
      }
    public String toSystem(AuditEventSeverity code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class AuditEventOutcomeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates whether the event succeeded or failed.
         */
        @Child(name = "code", type = {Coding.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Whether the event succeeded or failed", formalDefinition="Indicates whether the event succeeded or failed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-outcome")
        protected Coding code;

        /**
         * Additional details about the error. This may be a text description of the error or a system code that identifies the error.
         */
        @Child(name = "detail", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Additional outcome detail", formalDefinition="Additional details about the error. This may be a text description of the error or a system code that identifies the error." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-outcome-detail")
        protected List<CodeableConcept> detail;

        private static final long serialVersionUID = -1108329559L;

    /**
     * Constructor
     */
      public AuditEventOutcomeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AuditEventOutcomeComponent(Coding code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Indicates whether the event succeeded or failed.)
         */
        public Coding getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventOutcomeComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Coding(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Indicates whether the event succeeded or failed.)
         */
        public AuditEventOutcomeComponent setCode(Coding value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #detail} (Additional details about the error. This may be a text description of the error or a system code that identifies the error.)
         */
        public List<CodeableConcept> getDetail() { 
          if (this.detail == null)
            this.detail = new ArrayList<CodeableConcept>();
          return this.detail;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventOutcomeComponent setDetail(List<CodeableConcept> theDetail) { 
          this.detail = theDetail;
          return this;
        }

        public boolean hasDetail() { 
          if (this.detail == null)
            return false;
          for (CodeableConcept item : this.detail)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addDetail() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.detail == null)
            this.detail = new ArrayList<CodeableConcept>();
          this.detail.add(t);
          return t;
        }

        public AuditEventOutcomeComponent addDetail(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.detail == null)
            this.detail = new ArrayList<CodeableConcept>();
          this.detail.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #detail}, creating it if it does not already exist {3}
         */
        public CodeableConcept getDetailFirstRep() { 
          if (getDetail().isEmpty()) {
            addDetail();
          }
          return getDetail().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "Coding", "Indicates whether the event succeeded or failed.", 0, 1, code));
          children.add(new Property("detail", "CodeableConcept", "Additional details about the error. This may be a text description of the error or a system code that identifies the error.", 0, java.lang.Integer.MAX_VALUE, detail));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "Coding", "Indicates whether the event succeeded or failed.", 0, 1, code);
          case -1335224239: /*detail*/  return new Property("detail", "CodeableConcept", "Additional details about the error. This may be a text description of the error or a system code that identifies the error.", 0, java.lang.Integer.MAX_VALUE, detail);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Coding
        case -1335224239: /*detail*/ return this.detail == null ? new Base[0] : this.detail.toArray(new Base[this.detail.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -1335224239: // detail
          this.getDetail().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("detail")) {
          this.getDetail().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1335224239:  return addDetail(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"Coding"};
        case -1335224239: /*detail*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new Coding();
          return this.code;
        }
        else if (name.equals("detail")) {
          return addDetail();
        }
        else
          return super.addChild(name);
      }

      public AuditEventOutcomeComponent copy() {
        AuditEventOutcomeComponent dst = new AuditEventOutcomeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AuditEventOutcomeComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (detail != null) {
          dst.detail = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : detail)
            dst.detail.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AuditEventOutcomeComponent))
          return false;
        AuditEventOutcomeComponent o = (AuditEventOutcomeComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(detail, o.detail, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AuditEventOutcomeComponent))
          return false;
        AuditEventOutcomeComponent o = (AuditEventOutcomeComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, detail);
      }

  public String fhirType() {
    return "AuditEvent.outcome";

  }

  }

    @Block()
    public static class AuditEventAgentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The Functional Role of the user when performing the event.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="How agent participated", formalDefinition="The Functional Role of the user when performing the event." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participation-role-type")
        protected CodeableConcept type;

        /**
         * The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Agent role in the event", formalDefinition="The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-role-type")
        protected List<CodeableConcept> role;

        /**
         * Reference to who this agent is that was involved in the event.
         */
        @Child(name = "who", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifier of who", formalDefinition="Reference to who this agent is that was involved in the event." )
        protected Reference who;

        /**
         * Indicator that the user is or is not the requestor, or initiator, for the event being audited.
         */
        @Child(name = "requestor", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Whether user is initiator", formalDefinition="Indicator that the user is or is not the requestor, or initiator, for the event being audited." )
        protected BooleanType requestor;

        /**
         * Where the agent location is known, the agent location when the event occurred.
         */
        @Child(name = "location", type = {Location.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The agent location when the event occurred", formalDefinition="Where the agent location is known, the agent location when the event occurred." )
        protected Reference location;

        /**
         * Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.
         */
        @Child(name = "policy", type = {UriType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Policy that authorized the agent participation in the event", formalDefinition="Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used." )
        protected List<UriType> policy;

        /**
         * When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.
         */
        @Child(name = "network", type = {Endpoint.class, UriType.class, StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="This agent network location for the activity", formalDefinition="When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details." )
        protected DataType network;

        /**
         * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
         */
        @Child(name = "authorization", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Allowable authorization for this agent", formalDefinition="The authorization (e.g., PurposeOfUse) that was used during the event being recorded." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-PurposeOfUse")
        protected List<CodeableConcept> authorization;

        private static final long serialVersionUID = 509129255L;

    /**
     * Constructor
     */
      public AuditEventAgentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AuditEventAgentComponent(Reference who) {
        super();
        this.setWho(who);
      }

        /**
         * @return {@link #type} (The Functional Role of the user when performing the event.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventAgentComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The Functional Role of the user when performing the event.)
         */
        public AuditEventAgentComponent setType(CodeableConcept value) { 
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
        public AuditEventAgentComponent setRole(List<CodeableConcept> theRole) { 
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

        public AuditEventAgentComponent addRole(CodeableConcept t) { //3
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
         * @return {@link #who} (Reference to who this agent is that was involved in the event.)
         */
        public Reference getWho() { 
          if (this.who == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventAgentComponent.who");
            else if (Configuration.doAutoCreate())
              this.who = new Reference(); // cc
          return this.who;
        }

        public boolean hasWho() { 
          return this.who != null && !this.who.isEmpty();
        }

        /**
         * @param value {@link #who} (Reference to who this agent is that was involved in the event.)
         */
        public AuditEventAgentComponent setWho(Reference value) { 
          this.who = value;
          return this;
        }

        /**
         * @return {@link #requestor} (Indicator that the user is or is not the requestor, or initiator, for the event being audited.). This is the underlying object with id, value and extensions. The accessor "getRequestor" gives direct access to the value
         */
        public BooleanType getRequestorElement() { 
          if (this.requestor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventAgentComponent.requestor");
            else if (Configuration.doAutoCreate())
              this.requestor = new BooleanType(); // bb
          return this.requestor;
        }

        public boolean hasRequestorElement() { 
          return this.requestor != null && !this.requestor.isEmpty();
        }

        public boolean hasRequestor() { 
          return this.requestor != null && !this.requestor.isEmpty();
        }

        /**
         * @param value {@link #requestor} (Indicator that the user is or is not the requestor, or initiator, for the event being audited.). This is the underlying object with id, value and extensions. The accessor "getRequestor" gives direct access to the value
         */
        public AuditEventAgentComponent setRequestorElement(BooleanType value) { 
          this.requestor = value;
          return this;
        }

        /**
         * @return Indicator that the user is or is not the requestor, or initiator, for the event being audited.
         */
        public boolean getRequestor() { 
          return this.requestor == null || this.requestor.isEmpty() ? false : this.requestor.getValue();
        }

        /**
         * @param value Indicator that the user is or is not the requestor, or initiator, for the event being audited.
         */
        public AuditEventAgentComponent setRequestor(boolean value) { 
            if (this.requestor == null)
              this.requestor = new BooleanType();
            this.requestor.setValue(value);
          return this;
        }

        /**
         * @return {@link #location} (Where the agent location is known, the agent location when the event occurred.)
         */
        public Reference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventAgentComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new Reference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (Where the agent location is known, the agent location when the event occurred.)
         */
        public AuditEventAgentComponent setLocation(Reference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #policy} (Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.)
         */
        public List<UriType> getPolicy() { 
          if (this.policy == null)
            this.policy = new ArrayList<UriType>();
          return this.policy;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventAgentComponent setPolicy(List<UriType> thePolicy) { 
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
         * @return {@link #policy} (Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.)
         */
        public UriType addPolicyElement() {//2 
          UriType t = new UriType();
          if (this.policy == null)
            this.policy = new ArrayList<UriType>();
          this.policy.add(t);
          return t;
        }

        /**
         * @param value {@link #policy} (Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.)
         */
        public AuditEventAgentComponent addPolicy(String value) { //1
          UriType t = new UriType();
          t.setValue(value);
          if (this.policy == null)
            this.policy = new ArrayList<UriType>();
          this.policy.add(t);
          return this;
        }

        /**
         * @param value {@link #policy} (Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.)
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
         * @return {@link #network} (When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.)
         */
        public DataType getNetwork() { 
          return this.network;
        }

        /**
         * @return {@link #network} (When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.)
         */
        public Reference getNetworkReference() throws FHIRException { 
          if (this.network == null)
            this.network = new Reference();
          if (!(this.network instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.network.getClass().getName()+" was encountered");
          return (Reference) this.network;
        }

        public boolean hasNetworkReference() { 
          return this != null && this.network instanceof Reference;
        }

        /**
         * @return {@link #network} (When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.)
         */
        public UriType getNetworkUriType() throws FHIRException { 
          if (this.network == null)
            this.network = new UriType();
          if (!(this.network instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.network.getClass().getName()+" was encountered");
          return (UriType) this.network;
        }

        public boolean hasNetworkUriType() { 
          return this != null && this.network instanceof UriType;
        }

        /**
         * @return {@link #network} (When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.)
         */
        public StringType getNetworkStringType() throws FHIRException { 
          if (this.network == null)
            this.network = new StringType();
          if (!(this.network instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.network.getClass().getName()+" was encountered");
          return (StringType) this.network;
        }

        public boolean hasNetworkStringType() { 
          return this != null && this.network instanceof StringType;
        }

        public boolean hasNetwork() { 
          return this.network != null && !this.network.isEmpty();
        }

        /**
         * @param value {@link #network} (When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.)
         */
        public AuditEventAgentComponent setNetwork(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof UriType || value instanceof StringType))
            throw new Error("Not the right type for AuditEvent.agent.network[x]: "+value.fhirType());
          this.network = value;
          return this;
        }

        /**
         * @return {@link #authorization} (The authorization (e.g., PurposeOfUse) that was used during the event being recorded.)
         */
        public List<CodeableConcept> getAuthorization() { 
          if (this.authorization == null)
            this.authorization = new ArrayList<CodeableConcept>();
          return this.authorization;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventAgentComponent setAuthorization(List<CodeableConcept> theAuthorization) { 
          this.authorization = theAuthorization;
          return this;
        }

        public boolean hasAuthorization() { 
          if (this.authorization == null)
            return false;
          for (CodeableConcept item : this.authorization)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAuthorization() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.authorization == null)
            this.authorization = new ArrayList<CodeableConcept>();
          this.authorization.add(t);
          return t;
        }

        public AuditEventAgentComponent addAuthorization(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.authorization == null)
            this.authorization = new ArrayList<CodeableConcept>();
          this.authorization.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #authorization}, creating it if it does not already exist {3}
         */
        public CodeableConcept getAuthorizationFirstRep() { 
          if (getAuthorization().isEmpty()) {
            addAuthorization();
          }
          return getAuthorization().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The Functional Role of the user when performing the event.", 0, 1, type));
          children.add(new Property("role", "CodeableConcept", "The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.", 0, java.lang.Integer.MAX_VALUE, role));
          children.add(new Property("who", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Reference to who this agent is that was involved in the event.", 0, 1, who));
          children.add(new Property("requestor", "boolean", "Indicator that the user is or is not the requestor, or initiator, for the event being audited.", 0, 1, requestor));
          children.add(new Property("location", "Reference(Location)", "Where the agent location is known, the agent location when the event occurred.", 0, 1, location));
          children.add(new Property("policy", "uri", "Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.", 0, java.lang.Integer.MAX_VALUE, policy));
          children.add(new Property("network[x]", "Reference(Endpoint)|uri|string", "When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.", 0, 1, network));
          children.add(new Property("authorization", "CodeableConcept", "The authorization (e.g., PurposeOfUse) that was used during the event being recorded.", 0, java.lang.Integer.MAX_VALUE, authorization));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The Functional Role of the user when performing the event.", 0, 1, type);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The structural roles of the agent indicating the agent's competency. The security role enabling the agent with respect to the activity.", 0, java.lang.Integer.MAX_VALUE, role);
          case 117694: /*who*/  return new Property("who", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Reference to who this agent is that was involved in the event.", 0, 1, who);
          case 693934258: /*requestor*/  return new Property("requestor", "boolean", "Indicator that the user is or is not the requestor, or initiator, for the event being audited.", 0, 1, requestor);
          case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "Where the agent location is known, the agent location when the event occurred.", 0, 1, location);
          case -982670030: /*policy*/  return new Property("policy", "uri", "Where the policy(ies) are known that authorized the agent participation in the event. Typically, a single activity may have multiple applicable policies, such as patient consent, guarantor funding, etc. The policy would also indicate the security token used.", 0, java.lang.Integer.MAX_VALUE, policy);
          case -478235758: /*network[x]*/  return new Property("network[x]", "Reference(Endpoint)|uri|string", "When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.", 0, 1, network);
          case 1843485230: /*network*/  return new Property("network[x]", "Reference(Endpoint)|uri|string", "When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.", 0, 1, network);
          case -1769760579: /*networkReference*/  return new Property("network[x]", "Reference(Endpoint)", "When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.", 0, 1, network);
          case -478241698: /*networkUri*/  return new Property("network[x]", "uri", "When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.", 0, 1, network);
          case -946943009: /*networkString*/  return new Property("network[x]", "string", "When the event utilizes a network there should be an agent describing the local system, and an agent describing remote system, with the network interface details.", 0, 1, network);
          case -1385570183: /*authorization*/  return new Property("authorization", "CodeableConcept", "The authorization (e.g., PurposeOfUse) that was used during the event being recorded.", 0, java.lang.Integer.MAX_VALUE, authorization);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3506294: /*role*/ return this.role == null ? new Base[0] : this.role.toArray(new Base[this.role.size()]); // CodeableConcept
        case 117694: /*who*/ return this.who == null ? new Base[0] : new Base[] {this.who}; // Reference
        case 693934258: /*requestor*/ return this.requestor == null ? new Base[0] : new Base[] {this.requestor}; // BooleanType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -982670030: /*policy*/ return this.policy == null ? new Base[0] : this.policy.toArray(new Base[this.policy.size()]); // UriType
        case 1843485230: /*network*/ return this.network == null ? new Base[0] : new Base[] {this.network}; // DataType
        case -1385570183: /*authorization*/ return this.authorization == null ? new Base[0] : this.authorization.toArray(new Base[this.authorization.size()]); // CodeableConcept
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
        case 693934258: // requestor
          this.requestor = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -982670030: // policy
          this.getPolicy().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case 1843485230: // network
          this.network = TypeConvertor.castToType(value); // DataType
          return value;
        case -1385570183: // authorization
          this.getAuthorization().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        } else if (name.equals("requestor")) {
          this.requestor = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("policy")) {
          this.getPolicy().add(TypeConvertor.castToUri(value));
        } else if (name.equals("network[x]")) {
          this.network = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("authorization")) {
          this.getAuthorization().add(TypeConvertor.castToCodeableConcept(value));
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
        case 693934258:  return getRequestorElement();
        case 1901043637:  return getLocation();
        case -982670030:  return addPolicyElement();
        case -478235758:  return getNetwork();
        case 1843485230:  return getNetwork();
        case -1385570183:  return addAuthorization(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 117694: /*who*/ return new String[] {"Reference"};
        case 693934258: /*requestor*/ return new String[] {"boolean"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -982670030: /*policy*/ return new String[] {"uri"};
        case 1843485230: /*network*/ return new String[] {"Reference", "uri", "string"};
        case -1385570183: /*authorization*/ return new String[] {"CodeableConcept"};
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
        else if (name.equals("requestor")) {
          throw new FHIRException("Cannot call addChild on a primitive type AuditEvent.agent.requestor");
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("policy")) {
          throw new FHIRException("Cannot call addChild on a primitive type AuditEvent.agent.policy");
        }
        else if (name.equals("networkReference")) {
          this.network = new Reference();
          return this.network;
        }
        else if (name.equals("networkUri")) {
          this.network = new UriType();
          return this.network;
        }
        else if (name.equals("networkString")) {
          this.network = new StringType();
          return this.network;
        }
        else if (name.equals("authorization")) {
          return addAuthorization();
        }
        else
          return super.addChild(name);
      }

      public AuditEventAgentComponent copy() {
        AuditEventAgentComponent dst = new AuditEventAgentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AuditEventAgentComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (role != null) {
          dst.role = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : role)
            dst.role.add(i.copy());
        };
        dst.who = who == null ? null : who.copy();
        dst.requestor = requestor == null ? null : requestor.copy();
        dst.location = location == null ? null : location.copy();
        if (policy != null) {
          dst.policy = new ArrayList<UriType>();
          for (UriType i : policy)
            dst.policy.add(i.copy());
        };
        dst.network = network == null ? null : network.copy();
        if (authorization != null) {
          dst.authorization = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : authorization)
            dst.authorization.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AuditEventAgentComponent))
          return false;
        AuditEventAgentComponent o = (AuditEventAgentComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(role, o.role, true) && compareDeep(who, o.who, true)
           && compareDeep(requestor, o.requestor, true) && compareDeep(location, o.location, true) && compareDeep(policy, o.policy, true)
           && compareDeep(network, o.network, true) && compareDeep(authorization, o.authorization, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AuditEventAgentComponent))
          return false;
        AuditEventAgentComponent o = (AuditEventAgentComponent) other_;
        return compareValues(requestor, o.requestor, true) && compareValues(policy, o.policy, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, role, who, requestor
          , location, policy, network, authorization);
      }

  public String fhirType() {
    return "AuditEvent.agent";

  }

  }

    @Block()
    public static class AuditEventSourceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Logical source location within the healthcare enterprise network.  For example, a hospital or other provider location within a multi-entity provider group.
         */
        @Child(name = "site", type = {Location.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Logical source location within the enterprise", formalDefinition="Logical source location within the healthcare enterprise network.  For example, a hospital or other provider location within a multi-entity provider group." )
        protected Reference site;

        /**
         * Identifier of the source where the event was detected.
         */
        @Child(name = "observer", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The identity of source detecting the event", formalDefinition="Identifier of the source where the event was detected." )
        protected Reference observer;

        /**
         * Code specifying the type of source where event originated.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The type of source where event originated", formalDefinition="Code specifying the type of source where event originated." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-source-type")
        protected List<CodeableConcept> type;

        private static final long serialVersionUID = -140005578L;

    /**
     * Constructor
     */
      public AuditEventSourceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AuditEventSourceComponent(Reference observer) {
        super();
        this.setObserver(observer);
      }

        /**
         * @return {@link #site} (Logical source location within the healthcare enterprise network.  For example, a hospital or other provider location within a multi-entity provider group.)
         */
        public Reference getSite() { 
          if (this.site == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventSourceComponent.site");
            else if (Configuration.doAutoCreate())
              this.site = new Reference(); // cc
          return this.site;
        }

        public boolean hasSite() { 
          return this.site != null && !this.site.isEmpty();
        }

        /**
         * @param value {@link #site} (Logical source location within the healthcare enterprise network.  For example, a hospital or other provider location within a multi-entity provider group.)
         */
        public AuditEventSourceComponent setSite(Reference value) { 
          this.site = value;
          return this;
        }

        /**
         * @return {@link #observer} (Identifier of the source where the event was detected.)
         */
        public Reference getObserver() { 
          if (this.observer == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventSourceComponent.observer");
            else if (Configuration.doAutoCreate())
              this.observer = new Reference(); // cc
          return this.observer;
        }

        public boolean hasObserver() { 
          return this.observer != null && !this.observer.isEmpty();
        }

        /**
         * @param value {@link #observer} (Identifier of the source where the event was detected.)
         */
        public AuditEventSourceComponent setObserver(Reference value) { 
          this.observer = value;
          return this;
        }

        /**
         * @return {@link #type} (Code specifying the type of source where event originated.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventSourceComponent setType(List<CodeableConcept> theType) { 
          this.type = theType;
          return this;
        }

        public boolean hasType() { 
          if (this.type == null)
            return false;
          for (CodeableConcept item : this.type)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return t;
        }

        public AuditEventSourceComponent addType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTypeFirstRep() { 
          if (getType().isEmpty()) {
            addType();
          }
          return getType().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("site", "Reference(Location)", "Logical source location within the healthcare enterprise network.  For example, a hospital or other provider location within a multi-entity provider group.", 0, 1, site));
          children.add(new Property("observer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Identifier of the source where the event was detected.", 0, 1, observer));
          children.add(new Property("type", "CodeableConcept", "Code specifying the type of source where event originated.", 0, java.lang.Integer.MAX_VALUE, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3530567: /*site*/  return new Property("site", "Reference(Location)", "Logical source location within the healthcare enterprise network.  For example, a hospital or other provider location within a multi-entity provider group.", 0, 1, site);
          case 348607190: /*observer*/  return new Property("observer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Identifier of the source where the event was detected.", 0, 1, observer);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code specifying the type of source where event originated.", 0, java.lang.Integer.MAX_VALUE, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3530567: /*site*/ return this.site == null ? new Base[0] : new Base[] {this.site}; // Reference
        case 348607190: /*observer*/ return this.observer == null ? new Base[0] : new Base[] {this.observer}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3530567: // site
          this.site = TypeConvertor.castToReference(value); // Reference
          return value;
        case 348607190: // observer
          this.observer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("site")) {
          this.site = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("observer")) {
          this.observer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3530567:  return getSite();
        case 348607190:  return getObserver();
        case 3575610:  return addType(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3530567: /*site*/ return new String[] {"Reference"};
        case 348607190: /*observer*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("site")) {
          this.site = new Reference();
          return this.site;
        }
        else if (name.equals("observer")) {
          this.observer = new Reference();
          return this.observer;
        }
        else if (name.equals("type")) {
          return addType();
        }
        else
          return super.addChild(name);
      }

      public AuditEventSourceComponent copy() {
        AuditEventSourceComponent dst = new AuditEventSourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AuditEventSourceComponent dst) {
        super.copyValues(dst);
        dst.site = site == null ? null : site.copy();
        dst.observer = observer == null ? null : observer.copy();
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AuditEventSourceComponent))
          return false;
        AuditEventSourceComponent o = (AuditEventSourceComponent) other_;
        return compareDeep(site, o.site, true) && compareDeep(observer, o.observer, true) && compareDeep(type, o.type, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AuditEventSourceComponent))
          return false;
        AuditEventSourceComponent o = (AuditEventSourceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(site, observer, type);
      }

  public String fhirType() {
    return "AuditEvent.source";

  }

  }

    @Block()
    public static class AuditEventEntityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies a specific instance of the entity. The reference should be version specific. This is allowed to be a Parameters resource.
         */
        @Child(name = "what", type = {Reference.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Specific instance of resource", formalDefinition="Identifies a specific instance of the entity. The reference should be version specific. This is allowed to be a Parameters resource." )
        protected Reference what;

        /**
         * Code representing the role the entity played in the event being audited.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What role the entity played", formalDefinition="Code representing the role the entity played in the event being audited." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/object-role")
        protected CodeableConcept role;

        /**
         * Security labels for the identified entity.
         */
        @Child(name = "securityLabel", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Security labels on the entity", formalDefinition="Security labels for the identified entity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/security-label-examples")
        protected List<CodeableConcept> securityLabel;

        /**
         * The query parameters for a query-type entities.
         */
        @Child(name = "query", type = {Base64BinaryType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Query parameters", formalDefinition="The query parameters for a query-type entities." )
        protected Base64BinaryType query;

        /**
         * Tagged value pairs for conveying additional information about the entity.
         */
        @Child(name = "detail", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Additional Information about the entity", formalDefinition="Tagged value pairs for conveying additional information about the entity." )
        protected List<AuditEventEntityDetailComponent> detail;

        /**
         * The entity is attributed to an agent to express the agent's responsibility for that entity in the activity. This is most used to indicate when persistence media (the entity) are used by an agent. For example when importing data from a device, the device would be described in an entity, and the user importing data from that media would be indicated as the entity.agent.
         */
        @Child(name = "agent", type = {AuditEventAgentComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Entity is attributed to this agent", formalDefinition="The entity is attributed to an agent to express the agent's responsibility for that entity in the activity. This is most used to indicate when persistence media (the entity) are used by an agent. For example when importing data from a device, the device would be described in an entity, and the user importing data from that media would be indicated as the entity.agent." )
        protected List<AuditEventAgentComponent> agent;

        private static final long serialVersionUID = -711898650L;

    /**
     * Constructor
     */
      public AuditEventEntityComponent() {
        super();
      }

        /**
         * @return {@link #what} (Identifies a specific instance of the entity. The reference should be version specific. This is allowed to be a Parameters resource.)
         */
        public Reference getWhat() { 
          if (this.what == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventEntityComponent.what");
            else if (Configuration.doAutoCreate())
              this.what = new Reference(); // cc
          return this.what;
        }

        public boolean hasWhat() { 
          return this.what != null && !this.what.isEmpty();
        }

        /**
         * @param value {@link #what} (Identifies a specific instance of the entity. The reference should be version specific. This is allowed to be a Parameters resource.)
         */
        public AuditEventEntityComponent setWhat(Reference value) { 
          this.what = value;
          return this;
        }

        /**
         * @return {@link #role} (Code representing the role the entity played in the event being audited.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventEntityComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Code representing the role the entity played in the event being audited.)
         */
        public AuditEventEntityComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #securityLabel} (Security labels for the identified entity.)
         */
        public List<CodeableConcept> getSecurityLabel() { 
          if (this.securityLabel == null)
            this.securityLabel = new ArrayList<CodeableConcept>();
          return this.securityLabel;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventEntityComponent setSecurityLabel(List<CodeableConcept> theSecurityLabel) { 
          this.securityLabel = theSecurityLabel;
          return this;
        }

        public boolean hasSecurityLabel() { 
          if (this.securityLabel == null)
            return false;
          for (CodeableConcept item : this.securityLabel)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addSecurityLabel() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.securityLabel == null)
            this.securityLabel = new ArrayList<CodeableConcept>();
          this.securityLabel.add(t);
          return t;
        }

        public AuditEventEntityComponent addSecurityLabel(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.securityLabel == null)
            this.securityLabel = new ArrayList<CodeableConcept>();
          this.securityLabel.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #securityLabel}, creating it if it does not already exist {3}
         */
        public CodeableConcept getSecurityLabelFirstRep() { 
          if (getSecurityLabel().isEmpty()) {
            addSecurityLabel();
          }
          return getSecurityLabel().get(0);
        }

        /**
         * @return {@link #query} (The query parameters for a query-type entities.). This is the underlying object with id, value and extensions. The accessor "getQuery" gives direct access to the value
         */
        public Base64BinaryType getQueryElement() { 
          if (this.query == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventEntityComponent.query");
            else if (Configuration.doAutoCreate())
              this.query = new Base64BinaryType(); // bb
          return this.query;
        }

        public boolean hasQueryElement() { 
          return this.query != null && !this.query.isEmpty();
        }

        public boolean hasQuery() { 
          return this.query != null && !this.query.isEmpty();
        }

        /**
         * @param value {@link #query} (The query parameters for a query-type entities.). This is the underlying object with id, value and extensions. The accessor "getQuery" gives direct access to the value
         */
        public AuditEventEntityComponent setQueryElement(Base64BinaryType value) { 
          this.query = value;
          return this;
        }

        /**
         * @return The query parameters for a query-type entities.
         */
        public byte[] getQuery() { 
          return this.query == null ? null : this.query.getValue();
        }

        /**
         * @param value The query parameters for a query-type entities.
         */
        public AuditEventEntityComponent setQuery(byte[] value) { 
          if (value == null)
            this.query = null;
          else {
            if (this.query == null)
              this.query = new Base64BinaryType();
            this.query.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #detail} (Tagged value pairs for conveying additional information about the entity.)
         */
        public List<AuditEventEntityDetailComponent> getDetail() { 
          if (this.detail == null)
            this.detail = new ArrayList<AuditEventEntityDetailComponent>();
          return this.detail;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventEntityComponent setDetail(List<AuditEventEntityDetailComponent> theDetail) { 
          this.detail = theDetail;
          return this;
        }

        public boolean hasDetail() { 
          if (this.detail == null)
            return false;
          for (AuditEventEntityDetailComponent item : this.detail)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public AuditEventEntityDetailComponent addDetail() { //3
          AuditEventEntityDetailComponent t = new AuditEventEntityDetailComponent();
          if (this.detail == null)
            this.detail = new ArrayList<AuditEventEntityDetailComponent>();
          this.detail.add(t);
          return t;
        }

        public AuditEventEntityComponent addDetail(AuditEventEntityDetailComponent t) { //3
          if (t == null)
            return this;
          if (this.detail == null)
            this.detail = new ArrayList<AuditEventEntityDetailComponent>();
          this.detail.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #detail}, creating it if it does not already exist {3}
         */
        public AuditEventEntityDetailComponent getDetailFirstRep() { 
          if (getDetail().isEmpty()) {
            addDetail();
          }
          return getDetail().get(0);
        }

        /**
         * @return {@link #agent} (The entity is attributed to an agent to express the agent's responsibility for that entity in the activity. This is most used to indicate when persistence media (the entity) are used by an agent. For example when importing data from a device, the device would be described in an entity, and the user importing data from that media would be indicated as the entity.agent.)
         */
        public List<AuditEventAgentComponent> getAgent() { 
          if (this.agent == null)
            this.agent = new ArrayList<AuditEventAgentComponent>();
          return this.agent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public AuditEventEntityComponent setAgent(List<AuditEventAgentComponent> theAgent) { 
          this.agent = theAgent;
          return this;
        }

        public boolean hasAgent() { 
          if (this.agent == null)
            return false;
          for (AuditEventAgentComponent item : this.agent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public AuditEventAgentComponent addAgent() { //3
          AuditEventAgentComponent t = new AuditEventAgentComponent();
          if (this.agent == null)
            this.agent = new ArrayList<AuditEventAgentComponent>();
          this.agent.add(t);
          return t;
        }

        public AuditEventEntityComponent addAgent(AuditEventAgentComponent t) { //3
          if (t == null)
            return this;
          if (this.agent == null)
            this.agent = new ArrayList<AuditEventAgentComponent>();
          this.agent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #agent}, creating it if it does not already exist {3}
         */
        public AuditEventAgentComponent getAgentFirstRep() { 
          if (getAgent().isEmpty()) {
            addAgent();
          }
          return getAgent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("what", "Reference(Any)", "Identifies a specific instance of the entity. The reference should be version specific. This is allowed to be a Parameters resource.", 0, 1, what));
          children.add(new Property("role", "CodeableConcept", "Code representing the role the entity played in the event being audited.", 0, 1, role));
          children.add(new Property("securityLabel", "CodeableConcept", "Security labels for the identified entity.", 0, java.lang.Integer.MAX_VALUE, securityLabel));
          children.add(new Property("query", "base64Binary", "The query parameters for a query-type entities.", 0, 1, query));
          children.add(new Property("detail", "", "Tagged value pairs for conveying additional information about the entity.", 0, java.lang.Integer.MAX_VALUE, detail));
          children.add(new Property("agent", "@AuditEvent.agent", "The entity is attributed to an agent to express the agent's responsibility for that entity in the activity. This is most used to indicate when persistence media (the entity) are used by an agent. For example when importing data from a device, the device would be described in an entity, and the user importing data from that media would be indicated as the entity.agent.", 0, java.lang.Integer.MAX_VALUE, agent));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3648196: /*what*/  return new Property("what", "Reference(Any)", "Identifies a specific instance of the entity. The reference should be version specific. This is allowed to be a Parameters resource.", 0, 1, what);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Code representing the role the entity played in the event being audited.", 0, 1, role);
          case -722296940: /*securityLabel*/  return new Property("securityLabel", "CodeableConcept", "Security labels for the identified entity.", 0, java.lang.Integer.MAX_VALUE, securityLabel);
          case 107944136: /*query*/  return new Property("query", "base64Binary", "The query parameters for a query-type entities.", 0, 1, query);
          case -1335224239: /*detail*/  return new Property("detail", "", "Tagged value pairs for conveying additional information about the entity.", 0, java.lang.Integer.MAX_VALUE, detail);
          case 92750597: /*agent*/  return new Property("agent", "@AuditEvent.agent", "The entity is attributed to an agent to express the agent's responsibility for that entity in the activity. This is most used to indicate when persistence media (the entity) are used by an agent. For example when importing data from a device, the device would be described in an entity, and the user importing data from that media would be indicated as the entity.agent.", 0, java.lang.Integer.MAX_VALUE, agent);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3648196: /*what*/ return this.what == null ? new Base[0] : new Base[] {this.what}; // Reference
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -722296940: /*securityLabel*/ return this.securityLabel == null ? new Base[0] : this.securityLabel.toArray(new Base[this.securityLabel.size()]); // CodeableConcept
        case 107944136: /*query*/ return this.query == null ? new Base[0] : new Base[] {this.query}; // Base64BinaryType
        case -1335224239: /*detail*/ return this.detail == null ? new Base[0] : this.detail.toArray(new Base[this.detail.size()]); // AuditEventEntityDetailComponent
        case 92750597: /*agent*/ return this.agent == null ? new Base[0] : this.agent.toArray(new Base[this.agent.size()]); // AuditEventAgentComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3648196: // what
          this.what = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -722296940: // securityLabel
          this.getSecurityLabel().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 107944136: // query
          this.query = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
          return value;
        case -1335224239: // detail
          this.getDetail().add((AuditEventEntityDetailComponent) value); // AuditEventEntityDetailComponent
          return value;
        case 92750597: // agent
          this.getAgent().add((AuditEventAgentComponent) value); // AuditEventAgentComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("what")) {
          this.what = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("securityLabel")) {
          this.getSecurityLabel().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("query")) {
          this.query = TypeConvertor.castToBase64Binary(value); // Base64BinaryType
        } else if (name.equals("detail")) {
          this.getDetail().add((AuditEventEntityDetailComponent) value);
        } else if (name.equals("agent")) {
          this.getAgent().add((AuditEventAgentComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3648196:  return getWhat();
        case 3506294:  return getRole();
        case -722296940:  return addSecurityLabel(); 
        case 107944136:  return getQueryElement();
        case -1335224239:  return addDetail(); 
        case 92750597:  return addAgent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3648196: /*what*/ return new String[] {"Reference"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -722296940: /*securityLabel*/ return new String[] {"CodeableConcept"};
        case 107944136: /*query*/ return new String[] {"base64Binary"};
        case -1335224239: /*detail*/ return new String[] {};
        case 92750597: /*agent*/ return new String[] {"@AuditEvent.agent"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("what")) {
          this.what = new Reference();
          return this.what;
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("securityLabel")) {
          return addSecurityLabel();
        }
        else if (name.equals("query")) {
          throw new FHIRException("Cannot call addChild on a primitive type AuditEvent.entity.query");
        }
        else if (name.equals("detail")) {
          return addDetail();
        }
        else if (name.equals("agent")) {
          return addAgent();
        }
        else
          return super.addChild(name);
      }

      public AuditEventEntityComponent copy() {
        AuditEventEntityComponent dst = new AuditEventEntityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AuditEventEntityComponent dst) {
        super.copyValues(dst);
        dst.what = what == null ? null : what.copy();
        dst.role = role == null ? null : role.copy();
        if (securityLabel != null) {
          dst.securityLabel = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : securityLabel)
            dst.securityLabel.add(i.copy());
        };
        dst.query = query == null ? null : query.copy();
        if (detail != null) {
          dst.detail = new ArrayList<AuditEventEntityDetailComponent>();
          for (AuditEventEntityDetailComponent i : detail)
            dst.detail.add(i.copy());
        };
        if (agent != null) {
          dst.agent = new ArrayList<AuditEventAgentComponent>();
          for (AuditEventAgentComponent i : agent)
            dst.agent.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AuditEventEntityComponent))
          return false;
        AuditEventEntityComponent o = (AuditEventEntityComponent) other_;
        return compareDeep(what, o.what, true) && compareDeep(role, o.role, true) && compareDeep(securityLabel, o.securityLabel, true)
           && compareDeep(query, o.query, true) && compareDeep(detail, o.detail, true) && compareDeep(agent, o.agent, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AuditEventEntityComponent))
          return false;
        AuditEventEntityComponent o = (AuditEventEntityComponent) other_;
        return compareValues(query, o.query, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(what, role, securityLabel
          , query, detail, agent);
      }

  public String fhirType() {
    return "AuditEvent.entity";

  }

  }

    @Block()
    public static class AuditEventEntityDetailComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of extra detail provided in the value.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the property", formalDefinition="The type of extra detail provided in the value." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-type")
        protected CodeableConcept type;

        /**
         * The  value of the extra detail.
         */
        @Child(name = "value", type = {Quantity.class, CodeableConcept.class, StringType.class, BooleanType.class, IntegerType.class, Range.class, Ratio.class, TimeType.class, DateTimeType.class, Period.class, Base64BinaryType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Property value", formalDefinition="The  value of the extra detail." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public AuditEventEntityDetailComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AuditEventEntityDetailComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (The type of extra detail provided in the value.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AuditEventEntityDetailComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of extra detail provided in the value.)
         */
        public AuditEventEntityDetailComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() { 
          return this != null && this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public Ratio getValueRatio() throws FHIRException { 
          if (this.value == null)
            this.value = new Ratio();
          if (!(this.value instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Ratio) this.value;
        }

        public boolean hasValueRatio() { 
          return this != null && this.value instanceof Ratio;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public TimeType getValueTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new TimeType();
          if (!(this.value instanceof TimeType))
            throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TimeType) this.value;
        }

        public boolean hasValueTimeType() { 
          return this != null && this.value instanceof TimeType;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public DateTimeType getValueDateTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateTimeType();
          if (!(this.value instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateTimeType) this.value;
        }

        public boolean hasValueDateTimeType() { 
          return this != null && this.value instanceof DateTimeType;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public Period getValuePeriod() throws FHIRException { 
          if (this.value == null)
            this.value = new Period();
          if (!(this.value instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Period) this.value;
        }

        public boolean hasValuePeriod() { 
          return this != null && this.value instanceof Period;
        }

        /**
         * @return {@link #value} (The  value of the extra detail.)
         */
        public Base64BinaryType getValueBase64BinaryType() throws FHIRException { 
          if (this.value == null)
            this.value = new Base64BinaryType();
          if (!(this.value instanceof Base64BinaryType))
            throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Base64BinaryType) this.value;
        }

        public boolean hasValueBase64BinaryType() { 
          return this != null && this.value instanceof Base64BinaryType;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The  value of the extra detail.)
         */
        public AuditEventEntityDetailComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof CodeableConcept || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof Range || value instanceof Ratio || value instanceof TimeType || value instanceof DateTimeType || value instanceof Period || value instanceof Base64BinaryType))
            throw new Error("Not the right type for AuditEvent.entity.detail.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type of extra detail provided in the value.", 0, 1, type));
          children.add(new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|time|dateTime|Period|base64Binary", "The  value of the extra detail.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of extra detail provided in the value.", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|time|dateTime|Period|base64Binary", "The  value of the extra detail.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|time|dateTime|Period|base64Binary", "The  value of the extra detail.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The  value of the extra detail.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The  value of the extra detail.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The  value of the extra detail.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The  value of the extra detail.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The  value of the extra detail.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The  value of the extra detail.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The  value of the extra detail.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The  value of the extra detail.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The  value of the extra detail.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The  value of the extra detail.", 0, 1, value);
          case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "The  value of the extra detail.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Quantity", "CodeableConcept", "string", "boolean", "integer", "Range", "Ratio", "time", "dateTime", "Period", "base64Binary"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueRatio")) {
          this.value = new Ratio();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueBase64Binary")) {
          this.value = new Base64BinaryType();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public AuditEventEntityDetailComponent copy() {
        AuditEventEntityDetailComponent dst = new AuditEventEntityDetailComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AuditEventEntityDetailComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AuditEventEntityDetailComponent))
          return false;
        AuditEventEntityDetailComponent o = (AuditEventEntityDetailComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AuditEventEntityDetailComponent))
          return false;
        AuditEventEntityDetailComponent o = (AuditEventEntityDetailComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "AuditEvent.entity.detail";

  }

  }

    /**
     * Classification of the type of event.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type/identifier of event", formalDefinition="Classification of the type of event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-type")
    protected List<CodeableConcept> category;

    /**
     * Describes what happened. The most specific code for the event.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specific type of event", formalDefinition="Describes what happened. The most specific code for the event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-sub-type")
    protected CodeableConcept code;

    /**
     * Indicator for type of action performed during the event that generated the audit.
     */
    @Child(name = "action", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of action performed during the event", formalDefinition="Indicator for type of action performed during the event that generated the audit." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-action")
    protected Enumeration<AuditEventAction> action;

    /**
     * Indicates and enables segmentation of various severity including debugging from critical.
     */
    @Child(name = "severity", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="emergency | alert | critical | error | warning | notice | informational | debug", formalDefinition="Indicates and enables segmentation of various severity including debugging from critical." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/audit-event-severity")
    protected Enumeration<AuditEventSeverity> severity;

    /**
     * The time or period during which the activity occurred.
     */
    @Child(name = "occurred", type = {Period.class, DateTimeType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the activity occurred", formalDefinition="The time or period during which the activity occurred." )
    protected DataType occurred;

    /**
     * The time when the event was recorded.
     */
    @Child(name = "recorded", type = {InstantType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time when the event was recorded", formalDefinition="The time when the event was recorded." )
    protected InstantType recorded;

    /**
     * Indicates whether the event succeeded or failed. A free text descripiton can be given in outcome.text.
     */
    @Child(name = "outcome", type = {}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether the event succeeded or failed", formalDefinition="Indicates whether the event succeeded or failed. A free text descripiton can be given in outcome.text." )
    protected AuditEventOutcomeComponent outcome;

    /**
     * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
     */
    @Child(name = "authorization", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Authorization related to the event", formalDefinition="The authorization (e.g., PurposeOfUse) that was used during the event being recorded." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-PurposeOfUse")
    protected List<CodeableConcept> authorization;

    /**
     * Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, ServiceRequest.class, Task.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Workflow authorization within which this event occurred", formalDefinition="Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon." )
    protected List<Reference> basedOn;

    /**
     * The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.
     */
    @Child(name = "patient", type = {Patient.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The patient is the subject of the data used/created/updated/deleted during the activity", formalDefinition="The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity." )
    protected Reference patient;

    /**
     * This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).
     */
    @Child(name = "encounter", type = {Encounter.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Encounter within which this event occurred or which the event is tightly associated", formalDefinition="This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests)." )
    protected Reference encounter;

    /**
     * An actor taking an active role in the event or activity that is logged.
     */
    @Child(name = "agent", type = {}, order=11, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Actor involved in the event", formalDefinition="An actor taking an active role in the event or activity that is logged." )
    protected List<AuditEventAgentComponent> agent;

    /**
     * The actor that is reporting the event.
     */
    @Child(name = "source", type = {}, order=12, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Audit Event Reporter", formalDefinition="The actor that is reporting the event." )
    protected AuditEventSourceComponent source;

    /**
     * Specific instances of data or objects that have been accessed.
     */
    @Child(name = "entity", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Data or objects used", formalDefinition="Specific instances of data or objects that have been accessed." )
    protected List<AuditEventEntityComponent> entity;

    private static final long serialVersionUID = -1335832480L;

  /**
   * Constructor
   */
    public AuditEvent() {
      super();
    }

  /**
   * Constructor
   */
    public AuditEvent(CodeableConcept code, Date recorded, AuditEventAgentComponent agent, AuditEventSourceComponent source) {
      super();
      this.setCode(code);
      this.setRecorded(recorded);
      this.addAgent(agent);
      this.setSource(source);
    }

    /**
     * @return {@link #category} (Classification of the type of event.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AuditEvent setCategory(List<CodeableConcept> theCategory) { 
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

    public AuditEvent addCategory(CodeableConcept t) { //3
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
     * @return {@link #code} (Describes what happened. The most specific code for the event.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Describes what happened. The most specific code for the event.)
     */
    public AuditEvent setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #action} (Indicator for type of action performed during the event that generated the audit.). This is the underlying object with id, value and extensions. The accessor "getAction" gives direct access to the value
     */
    public Enumeration<AuditEventAction> getActionElement() { 
      if (this.action == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.action");
        else if (Configuration.doAutoCreate())
          this.action = new Enumeration<AuditEventAction>(new AuditEventActionEnumFactory()); // bb
      return this.action;
    }

    public boolean hasActionElement() { 
      return this.action != null && !this.action.isEmpty();
    }

    public boolean hasAction() { 
      return this.action != null && !this.action.isEmpty();
    }

    /**
     * @param value {@link #action} (Indicator for type of action performed during the event that generated the audit.). This is the underlying object with id, value and extensions. The accessor "getAction" gives direct access to the value
     */
    public AuditEvent setActionElement(Enumeration<AuditEventAction> value) { 
      this.action = value;
      return this;
    }

    /**
     * @return Indicator for type of action performed during the event that generated the audit.
     */
    public AuditEventAction getAction() { 
      return this.action == null ? null : this.action.getValue();
    }

    /**
     * @param value Indicator for type of action performed during the event that generated the audit.
     */
    public AuditEvent setAction(AuditEventAction value) { 
      if (value == null)
        this.action = null;
      else {
        if (this.action == null)
          this.action = new Enumeration<AuditEventAction>(new AuditEventActionEnumFactory());
        this.action.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #severity} (Indicates and enables segmentation of various severity including debugging from critical.). This is the underlying object with id, value and extensions. The accessor "getSeverity" gives direct access to the value
     */
    public Enumeration<AuditEventSeverity> getSeverityElement() { 
      if (this.severity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.severity");
        else if (Configuration.doAutoCreate())
          this.severity = new Enumeration<AuditEventSeverity>(new AuditEventSeverityEnumFactory()); // bb
      return this.severity;
    }

    public boolean hasSeverityElement() { 
      return this.severity != null && !this.severity.isEmpty();
    }

    public boolean hasSeverity() { 
      return this.severity != null && !this.severity.isEmpty();
    }

    /**
     * @param value {@link #severity} (Indicates and enables segmentation of various severity including debugging from critical.). This is the underlying object with id, value and extensions. The accessor "getSeverity" gives direct access to the value
     */
    public AuditEvent setSeverityElement(Enumeration<AuditEventSeverity> value) { 
      this.severity = value;
      return this;
    }

    /**
     * @return Indicates and enables segmentation of various severity including debugging from critical.
     */
    public AuditEventSeverity getSeverity() { 
      return this.severity == null ? null : this.severity.getValue();
    }

    /**
     * @param value Indicates and enables segmentation of various severity including debugging from critical.
     */
    public AuditEvent setSeverity(AuditEventSeverity value) { 
      if (value == null)
        this.severity = null;
      else {
        if (this.severity == null)
          this.severity = new Enumeration<AuditEventSeverity>(new AuditEventSeverityEnumFactory());
        this.severity.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #occurred} (The time or period during which the activity occurred.)
     */
    public DataType getOccurred() { 
      return this.occurred;
    }

    /**
     * @return {@link #occurred} (The time or period during which the activity occurred.)
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
     * @return {@link #occurred} (The time or period during which the activity occurred.)
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
     * @param value {@link #occurred} (The time or period during which the activity occurred.)
     */
    public AuditEvent setOccurred(DataType value) { 
      if (value != null && !(value instanceof Period || value instanceof DateTimeType))
        throw new Error("Not the right type for AuditEvent.occurred[x]: "+value.fhirType());
      this.occurred = value;
      return this;
    }

    /**
     * @return {@link #recorded} (The time when the event was recorded.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public InstantType getRecordedElement() { 
      if (this.recorded == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.recorded");
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
     * @param value {@link #recorded} (The time when the event was recorded.). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public AuditEvent setRecordedElement(InstantType value) { 
      this.recorded = value;
      return this;
    }

    /**
     * @return The time when the event was recorded.
     */
    public Date getRecorded() { 
      return this.recorded == null ? null : this.recorded.getValue();
    }

    /**
     * @param value The time when the event was recorded.
     */
    public AuditEvent setRecorded(Date value) { 
        if (this.recorded == null)
          this.recorded = new InstantType();
        this.recorded.setValue(value);
      return this;
    }

    /**
     * @return {@link #outcome} (Indicates whether the event succeeded or failed. A free text descripiton can be given in outcome.text.)
     */
    public AuditEventOutcomeComponent getOutcome() { 
      if (this.outcome == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.outcome");
        else if (Configuration.doAutoCreate())
          this.outcome = new AuditEventOutcomeComponent(); // cc
      return this.outcome;
    }

    public boolean hasOutcome() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    /**
     * @param value {@link #outcome} (Indicates whether the event succeeded or failed. A free text descripiton can be given in outcome.text.)
     */
    public AuditEvent setOutcome(AuditEventOutcomeComponent value) { 
      this.outcome = value;
      return this;
    }

    /**
     * @return {@link #authorization} (The authorization (e.g., PurposeOfUse) that was used during the event being recorded.)
     */
    public List<CodeableConcept> getAuthorization() { 
      if (this.authorization == null)
        this.authorization = new ArrayList<CodeableConcept>();
      return this.authorization;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AuditEvent setAuthorization(List<CodeableConcept> theAuthorization) { 
      this.authorization = theAuthorization;
      return this;
    }

    public boolean hasAuthorization() { 
      if (this.authorization == null)
        return false;
      for (CodeableConcept item : this.authorization)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addAuthorization() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.authorization == null)
        this.authorization = new ArrayList<CodeableConcept>();
      this.authorization.add(t);
      return t;
    }

    public AuditEvent addAuthorization(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.authorization == null)
        this.authorization = new ArrayList<CodeableConcept>();
      this.authorization.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #authorization}, creating it if it does not already exist {3}
     */
    public CodeableConcept getAuthorizationFirstRep() { 
      if (getAuthorization().isEmpty()) {
        addAuthorization();
      }
      return getAuthorization().get(0);
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
    public AuditEvent setBasedOn(List<Reference> theBasedOn) { 
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

    public AuditEvent addBasedOn(Reference t) { //3
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
          throw new Error("Attempt to auto-create AuditEvent.patient");
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
    public AuditEvent setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #encounter} (This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.encounter");
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
    public AuditEvent setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #agent} (An actor taking an active role in the event or activity that is logged.)
     */
    public List<AuditEventAgentComponent> getAgent() { 
      if (this.agent == null)
        this.agent = new ArrayList<AuditEventAgentComponent>();
      return this.agent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AuditEvent setAgent(List<AuditEventAgentComponent> theAgent) { 
      this.agent = theAgent;
      return this;
    }

    public boolean hasAgent() { 
      if (this.agent == null)
        return false;
      for (AuditEventAgentComponent item : this.agent)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AuditEventAgentComponent addAgent() { //3
      AuditEventAgentComponent t = new AuditEventAgentComponent();
      if (this.agent == null)
        this.agent = new ArrayList<AuditEventAgentComponent>();
      this.agent.add(t);
      return t;
    }

    public AuditEvent addAgent(AuditEventAgentComponent t) { //3
      if (t == null)
        return this;
      if (this.agent == null)
        this.agent = new ArrayList<AuditEventAgentComponent>();
      this.agent.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #agent}, creating it if it does not already exist {3}
     */
    public AuditEventAgentComponent getAgentFirstRep() { 
      if (getAgent().isEmpty()) {
        addAgent();
      }
      return getAgent().get(0);
    }

    /**
     * @return {@link #source} (The actor that is reporting the event.)
     */
    public AuditEventSourceComponent getSource() { 
      if (this.source == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AuditEvent.source");
        else if (Configuration.doAutoCreate())
          this.source = new AuditEventSourceComponent(); // cc
      return this.source;
    }

    public boolean hasSource() { 
      return this.source != null && !this.source.isEmpty();
    }

    /**
     * @param value {@link #source} (The actor that is reporting the event.)
     */
    public AuditEvent setSource(AuditEventSourceComponent value) { 
      this.source = value;
      return this;
    }

    /**
     * @return {@link #entity} (Specific instances of data or objects that have been accessed.)
     */
    public List<AuditEventEntityComponent> getEntity() { 
      if (this.entity == null)
        this.entity = new ArrayList<AuditEventEntityComponent>();
      return this.entity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AuditEvent setEntity(List<AuditEventEntityComponent> theEntity) { 
      this.entity = theEntity;
      return this;
    }

    public boolean hasEntity() { 
      if (this.entity == null)
        return false;
      for (AuditEventEntityComponent item : this.entity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AuditEventEntityComponent addEntity() { //3
      AuditEventEntityComponent t = new AuditEventEntityComponent();
      if (this.entity == null)
        this.entity = new ArrayList<AuditEventEntityComponent>();
      this.entity.add(t);
      return t;
    }

    public AuditEvent addEntity(AuditEventEntityComponent t) { //3
      if (t == null)
        return this;
      if (this.entity == null)
        this.entity = new ArrayList<AuditEventEntityComponent>();
      this.entity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #entity}, creating it if it does not already exist {3}
     */
    public AuditEventEntityComponent getEntityFirstRep() { 
      if (getEntity().isEmpty()) {
        addEntity();
      }
      return getEntity().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("category", "CodeableConcept", "Classification of the type of event.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "Describes what happened. The most specific code for the event.", 0, 1, code));
        children.add(new Property("action", "code", "Indicator for type of action performed during the event that generated the audit.", 0, 1, action));
        children.add(new Property("severity", "code", "Indicates and enables segmentation of various severity including debugging from critical.", 0, 1, severity));
        children.add(new Property("occurred[x]", "Period|dateTime", "The time or period during which the activity occurred.", 0, 1, occurred));
        children.add(new Property("recorded", "instant", "The time when the event was recorded.", 0, 1, recorded));
        children.add(new Property("outcome", "", "Indicates whether the event succeeded or failed. A free text descripiton can be given in outcome.text.", 0, 1, outcome));
        children.add(new Property("authorization", "CodeableConcept", "The authorization (e.g., PurposeOfUse) that was used during the event being recorded.", 0, java.lang.Integer.MAX_VALUE, authorization));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest|Task)", "Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("patient", "Reference(Patient)", "The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.", 0, 1, patient));
        children.add(new Property("encounter", "Reference(Encounter)", "This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).", 0, 1, encounter));
        children.add(new Property("agent", "", "An actor taking an active role in the event or activity that is logged.", 0, java.lang.Integer.MAX_VALUE, agent));
        children.add(new Property("source", "", "The actor that is reporting the event.", 0, 1, source));
        children.add(new Property("entity", "", "Specific instances of data or objects that have been accessed.", 0, java.lang.Integer.MAX_VALUE, entity));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Classification of the type of event.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Describes what happened. The most specific code for the event.", 0, 1, code);
        case -1422950858: /*action*/  return new Property("action", "code", "Indicator for type of action performed during the event that generated the audit.", 0, 1, action);
        case 1478300413: /*severity*/  return new Property("severity", "code", "Indicates and enables segmentation of various severity including debugging from critical.", 0, 1, severity);
        case 784181563: /*occurred[x]*/  return new Property("occurred[x]", "Period|dateTime", "The time or period during which the activity occurred.", 0, 1, occurred);
        case 792816933: /*occurred*/  return new Property("occurred[x]", "Period|dateTime", "The time or period during which the activity occurred.", 0, 1, occurred);
        case 894082886: /*occurredPeriod*/  return new Property("occurred[x]", "Period", "The time or period during which the activity occurred.", 0, 1, occurred);
        case 1579027424: /*occurredDateTime*/  return new Property("occurred[x]", "dateTime", "The time or period during which the activity occurred.", 0, 1, occurred);
        case -799233872: /*recorded*/  return new Property("recorded", "instant", "The time when the event was recorded.", 0, 1, recorded);
        case -1106507950: /*outcome*/  return new Property("outcome", "", "Indicates whether the event succeeded or failed. A free text descripiton can be given in outcome.text.", 0, 1, outcome);
        case -1385570183: /*authorization*/  return new Property("authorization", "CodeableConcept", "The authorization (e.g., PurposeOfUse) that was used during the event being recorded.", 0, java.lang.Integer.MAX_VALUE, authorization);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest|Task)", "Allows tracing of authorizatino for the events and tracking whether proposals/recommendations were acted upon.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The patient element is available to enable deterministic tracking of activities that involve the patient as the subject of the data used in an activity.", 0, 1, patient);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "This will typically be the encounter the event occurred, but some events may be initiated prior to or after the official completion of an encounter but still be tied to the context of the encounter (e.g. pre-admission lab tests).", 0, 1, encounter);
        case 92750597: /*agent*/  return new Property("agent", "", "An actor taking an active role in the event or activity that is logged.", 0, java.lang.Integer.MAX_VALUE, agent);
        case -896505829: /*source*/  return new Property("source", "", "The actor that is reporting the event.", 0, 1, source);
        case -1298275357: /*entity*/  return new Property("entity", "", "Specific instances of data or objects that have been accessed.", 0, java.lang.Integer.MAX_VALUE, entity);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : new Base[] {this.action}; // Enumeration<AuditEventAction>
        case 1478300413: /*severity*/ return this.severity == null ? new Base[0] : new Base[] {this.severity}; // Enumeration<AuditEventSeverity>
        case 792816933: /*occurred*/ return this.occurred == null ? new Base[0] : new Base[] {this.occurred}; // DataType
        case -799233872: /*recorded*/ return this.recorded == null ? new Base[0] : new Base[] {this.recorded}; // InstantType
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // AuditEventOutcomeComponent
        case -1385570183: /*authorization*/ return this.authorization == null ? new Base[0] : this.authorization.toArray(new Base[this.authorization.size()]); // CodeableConcept
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 92750597: /*agent*/ return this.agent == null ? new Base[0] : this.agent.toArray(new Base[this.agent.size()]); // AuditEventAgentComponent
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // AuditEventSourceComponent
        case -1298275357: /*entity*/ return this.entity == null ? new Base[0] : this.entity.toArray(new Base[this.entity.size()]); // AuditEventEntityComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1422950858: // action
          value = new AuditEventActionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.action = (Enumeration) value; // Enumeration<AuditEventAction>
          return value;
        case 1478300413: // severity
          value = new AuditEventSeverityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.severity = (Enumeration) value; // Enumeration<AuditEventSeverity>
          return value;
        case 792816933: // occurred
          this.occurred = TypeConvertor.castToType(value); // DataType
          return value;
        case -799233872: // recorded
          this.recorded = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case -1106507950: // outcome
          this.outcome = (AuditEventOutcomeComponent) value; // AuditEventOutcomeComponent
          return value;
        case -1385570183: // authorization
          this.getAuthorization().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
          this.getAgent().add((AuditEventAgentComponent) value); // AuditEventAgentComponent
          return value;
        case -896505829: // source
          this.source = (AuditEventSourceComponent) value; // AuditEventSourceComponent
          return value;
        case -1298275357: // entity
          this.getEntity().add((AuditEventEntityComponent) value); // AuditEventEntityComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("action")) {
          value = new AuditEventActionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.action = (Enumeration) value; // Enumeration<AuditEventAction>
        } else if (name.equals("severity")) {
          value = new AuditEventSeverityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.severity = (Enumeration) value; // Enumeration<AuditEventSeverity>
        } else if (name.equals("occurred[x]")) {
          this.occurred = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("recorded")) {
          this.recorded = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("outcome")) {
          this.outcome = (AuditEventOutcomeComponent) value; // AuditEventOutcomeComponent
        } else if (name.equals("authorization")) {
          this.getAuthorization().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("agent")) {
          this.getAgent().add((AuditEventAgentComponent) value);
        } else if (name.equals("source")) {
          this.source = (AuditEventSourceComponent) value; // AuditEventSourceComponent
        } else if (name.equals("entity")) {
          this.getEntity().add((AuditEventEntityComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -1422950858:  return getActionElement();
        case 1478300413:  return getSeverityElement();
        case 784181563:  return getOccurred();
        case 792816933:  return getOccurred();
        case -799233872:  return getRecordedElement();
        case -1106507950:  return getOutcome();
        case -1385570183:  return addAuthorization(); 
        case -332612366:  return addBasedOn(); 
        case -791418107:  return getPatient();
        case 1524132147:  return getEncounter();
        case 92750597:  return addAgent(); 
        case -896505829:  return getSource();
        case -1298275357:  return addEntity(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1422950858: /*action*/ return new String[] {"code"};
        case 1478300413: /*severity*/ return new String[] {"code"};
        case 792816933: /*occurred*/ return new String[] {"Period", "dateTime"};
        case -799233872: /*recorded*/ return new String[] {"instant"};
        case -1106507950: /*outcome*/ return new String[] {};
        case -1385570183: /*authorization*/ return new String[] {"CodeableConcept"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 92750597: /*agent*/ return new String[] {};
        case -896505829: /*source*/ return new String[] {};
        case -1298275357: /*entity*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("action")) {
          throw new FHIRException("Cannot call addChild on a primitive type AuditEvent.action");
        }
        else if (name.equals("severity")) {
          throw new FHIRException("Cannot call addChild on a primitive type AuditEvent.severity");
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
          throw new FHIRException("Cannot call addChild on a primitive type AuditEvent.recorded");
        }
        else if (name.equals("outcome")) {
          this.outcome = new AuditEventOutcomeComponent();
          return this.outcome;
        }
        else if (name.equals("authorization")) {
          return addAuthorization();
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
        else if (name.equals("source")) {
          this.source = new AuditEventSourceComponent();
          return this.source;
        }
        else if (name.equals("entity")) {
          return addEntity();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AuditEvent";

  }

      public AuditEvent copy() {
        AuditEvent dst = new AuditEvent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AuditEvent dst) {
        super.copyValues(dst);
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.action = action == null ? null : action.copy();
        dst.severity = severity == null ? null : severity.copy();
        dst.occurred = occurred == null ? null : occurred.copy();
        dst.recorded = recorded == null ? null : recorded.copy();
        dst.outcome = outcome == null ? null : outcome.copy();
        if (authorization != null) {
          dst.authorization = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : authorization)
            dst.authorization.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        dst.patient = patient == null ? null : patient.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        if (agent != null) {
          dst.agent = new ArrayList<AuditEventAgentComponent>();
          for (AuditEventAgentComponent i : agent)
            dst.agent.add(i.copy());
        };
        dst.source = source == null ? null : source.copy();
        if (entity != null) {
          dst.entity = new ArrayList<AuditEventEntityComponent>();
          for (AuditEventEntityComponent i : entity)
            dst.entity.add(i.copy());
        };
      }

      protected AuditEvent typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AuditEvent))
          return false;
        AuditEvent o = (AuditEvent) other_;
        return compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(action, o.action, true)
           && compareDeep(severity, o.severity, true) && compareDeep(occurred, o.occurred, true) && compareDeep(recorded, o.recorded, true)
           && compareDeep(outcome, o.outcome, true) && compareDeep(authorization, o.authorization, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(patient, o.patient, true) && compareDeep(encounter, o.encounter, true) && compareDeep(agent, o.agent, true)
           && compareDeep(source, o.source, true) && compareDeep(entity, o.entity, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AuditEvent))
          return false;
        AuditEvent o = (AuditEvent) other_;
        return compareValues(action, o.action, true) && compareValues(severity, o.severity, true) && compareValues(recorded, o.recorded, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, code, action, severity
          , occurred, recorded, outcome, authorization, basedOn, patient, encounter, agent
          , source, entity);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.AuditEvent;
   }

 /**
   * Search parameter: <b>action</b>
   * <p>
   * Description: <b>Type of action performed during the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.action</b><br>
   * </p>
   */
  @SearchParamDefinition(name="action", path="AuditEvent.action", description="Type of action performed during the event", type="token" )
  public static final String SP_ACTION = "action";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>action</b>
   * <p>
   * Description: <b>Type of action performed during the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.action</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTION);

 /**
   * Search parameter: <b>agent-role</b>
   * <p>
   * Description: <b>Agent role in the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.agent.role</b><br>
   * </p>
   */
  @SearchParamDefinition(name="agent-role", path="AuditEvent.agent.role", description="Agent role in the event", type="token" )
  public static final String SP_AGENT_ROLE = "agent-role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>agent-role</b>
   * <p>
   * Description: <b>Agent role in the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.agent.role</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam AGENT_ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_AGENT_ROLE);

 /**
   * Search parameter: <b>agent</b>
   * <p>
   * Description: <b>Identifier of who</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.agent.who</b><br>
   * </p>
   */
  @SearchParamDefinition(name="agent", path="AuditEvent.agent.who", description="Identifier of who", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_AGENT = "agent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>agent</b>
   * <p>
   * Description: <b>Identifier of who</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.agent.who</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AGENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AGENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AuditEvent:agent</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AGENT = new ca.uhn.fhir.model.api.Include("AuditEvent:agent").toLocked();

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Reference to the service request.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="AuditEvent.basedOn", description="Reference to the service request.", type="reference", target={CarePlan.class, DeviceRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, ServiceRequest.class, Task.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Reference to the service request.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AuditEvent:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("AuditEvent:based-on").toLocked();

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Category of event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="AuditEvent.category", description="Category of event", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Category of event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>More specific code for the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AuditEvent.code", description="More specific code for the event", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>More specific code for the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Time when the event was recorded</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AuditEvent.recorded</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AuditEvent.recorded", description="Time when the event was recorded", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Time when the event was recorded</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AuditEvent.recorded</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Encounter related to the activity recorded in the AuditEvent</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter", description="Encounter related to the activity recorded in the AuditEvent", type="reference", target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Encounter related to the activity recorded in the AuditEvent</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AuditEvent:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("AuditEvent:encounter").toLocked();

 /**
   * Search parameter: <b>entity-role</b>
   * <p>
   * Description: <b>What role the entity played</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.entity.role</b><br>
   * </p>
   */
  @SearchParamDefinition(name="entity-role", path="AuditEvent.entity.role", description="What role the entity played", type="token" )
  public static final String SP_ENTITY_ROLE = "entity-role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>entity-role</b>
   * <p>
   * Description: <b>What role the entity played</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.entity.role</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ENTITY_ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ENTITY_ROLE);

 /**
   * Search parameter: <b>entity</b>
   * <p>
   * Description: <b>Specific instance of resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.entity.what</b><br>
   * </p>
   */
  @SearchParamDefinition(name="entity", path="AuditEvent.entity.what", description="Specific instance of resource", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_ENTITY = "entity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>entity</b>
   * <p>
   * Description: <b>Specific instance of resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.entity.what</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENTITY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENTITY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AuditEvent:entity</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENTITY = new ca.uhn.fhir.model.api.Include("AuditEvent:entity").toLocked();

 /**
   * Search parameter: <b>outcome</b>
   * <p>
   * Description: <b>Whether the event succeeded or failed</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.outcome.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="outcome", path="AuditEvent.outcome.code", description="Whether the event succeeded or failed", type="token" )
  public static final String SP_OUTCOME = "outcome";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>outcome</b>
   * <p>
   * Description: <b>Whether the event succeeded or failed</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.outcome.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam OUTCOME = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_OUTCOME);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Where the activity involved patient data</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AuditEvent.patient", description="Where the activity involved patient data", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Where the activity involved patient data</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AuditEvent:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("AuditEvent:patient").toLocked();

 /**
   * Search parameter: <b>policy</b>
   * <p>
   * Description: <b>Policy that authorized event</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>AuditEvent.agent.policy</b><br>
   * </p>
   */
  @SearchParamDefinition(name="policy", path="AuditEvent.agent.policy", description="Policy that authorized event", type="uri" )
  public static final String SP_POLICY = "policy";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>policy</b>
   * <p>
   * Description: <b>Policy that authorized event</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>AuditEvent.agent.policy</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam POLICY = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_POLICY);

 /**
   * Search parameter: <b>purpose</b>
   * <p>
   * Description: <b>The authorization (purposeOfUse) of the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.authorization | AuditEvent.agent.authorization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="purpose", path="AuditEvent.authorization | AuditEvent.agent.authorization", description="The authorization (purposeOfUse) of the event", type="token" )
  public static final String SP_PURPOSE = "purpose";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>purpose</b>
   * <p>
   * Description: <b>The authorization (purposeOfUse) of the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AuditEvent.authorization | AuditEvent.agent.authorization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PURPOSE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PURPOSE);

 /**
   * Search parameter: <b>source</b>
   * <p>
   * Description: <b>The identity of source detecting the event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.source.observer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source", path="AuditEvent.source.observer", description="The identity of source detecting the event", type="reference", target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SOURCE = "source";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source</b>
   * <p>
   * Description: <b>The identity of source detecting the event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.source.observer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AuditEvent:source</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE = new ca.uhn.fhir.model.api.Include("AuditEvent:source").toLocked();


}

