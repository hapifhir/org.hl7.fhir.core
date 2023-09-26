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
 * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.
 */
@ResourceDef(name="Endpoint", profile="http://hl7.org/fhir/StructureDefinition/Endpoint")
public class Endpoint extends DomainResource {

    public enum EndpointStatus {
        /**
         * This endpoint is expected to be active and can be used.
         */
        ACTIVE, 
        /**
         * This endpoint is temporarily unavailable.
         */
        SUSPENDED, 
        /**
         * This endpoint has exceeded connectivity thresholds and is considered in an error state and should no longer be attempted to connect to until corrective action is taken.
         */
        ERROR, 
        /**
         * This endpoint is no longer to be used.
         */
        OFF, 
        /**
         * This instance should not have been part of this patient's medical record.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EndpointStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("suspended".equals(codeString))
          return SUSPENDED;
        if ("error".equals(codeString))
          return ERROR;
        if ("off".equals(codeString))
          return OFF;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EndpointStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case SUSPENDED: return "suspended";
            case ERROR: return "error";
            case OFF: return "off";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/endpoint-status";
            case SUSPENDED: return "http://hl7.org/fhir/endpoint-status";
            case ERROR: return "http://hl7.org/fhir/endpoint-status";
            case OFF: return "http://hl7.org/fhir/endpoint-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/endpoint-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "This endpoint is expected to be active and can be used.";
            case SUSPENDED: return "This endpoint is temporarily unavailable.";
            case ERROR: return "This endpoint has exceeded connectivity thresholds and is considered in an error state and should no longer be attempted to connect to until corrective action is taken.";
            case OFF: return "This endpoint is no longer to be used.";
            case ENTEREDINERROR: return "This instance should not have been part of this patient's medical record.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case SUSPENDED: return "Suspended";
            case ERROR: return "Error";
            case OFF: return "Off";
            case ENTEREDINERROR: return "Entered in error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EndpointStatusEnumFactory implements EnumFactory<EndpointStatus> {
    public EndpointStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return EndpointStatus.ACTIVE;
        if ("suspended".equals(codeString))
          return EndpointStatus.SUSPENDED;
        if ("error".equals(codeString))
          return EndpointStatus.ERROR;
        if ("off".equals(codeString))
          return EndpointStatus.OFF;
        if ("entered-in-error".equals(codeString))
          return EndpointStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown EndpointStatus code '"+codeString+"'");
        }
        public Enumeration<EndpointStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EndpointStatus>(this, EndpointStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<EndpointStatus>(this, EndpointStatus.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<EndpointStatus>(this, EndpointStatus.ACTIVE, code);
        if ("suspended".equals(codeString))
          return new Enumeration<EndpointStatus>(this, EndpointStatus.SUSPENDED, code);
        if ("error".equals(codeString))
          return new Enumeration<EndpointStatus>(this, EndpointStatus.ERROR, code);
        if ("off".equals(codeString))
          return new Enumeration<EndpointStatus>(this, EndpointStatus.OFF, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<EndpointStatus>(this, EndpointStatus.ENTEREDINERROR, code);
        throw new FHIRException("Unknown EndpointStatus code '"+codeString+"'");
        }
    public String toCode(EndpointStatus code) {
      if (code == EndpointStatus.ACTIVE)
        return "active";
      if (code == EndpointStatus.SUSPENDED)
        return "suspended";
      if (code == EndpointStatus.ERROR)
        return "error";
      if (code == EndpointStatus.OFF)
        return "off";
      if (code == EndpointStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(EndpointStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class EndpointPayloadComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The payload type describes the acceptable content that can be communicated on the endpoint.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The type of content that may be used at this endpoint (e.g. XDS Discharge summaries)", formalDefinition="The payload type describes the acceptable content that can be communicated on the endpoint." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/endpoint-payload-type")
        protected List<CodeableConcept> type;

        /**
         * The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).
         */
        @Child(name = "mimeType", type = {CodeType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Mimetype to send. If not specified, the content could be anything (including no payload, if the connectionType defined this)", formalDefinition="The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected List<CodeType> mimeType;

        private static final long serialVersionUID = -1398955844L;

    /**
     * Constructor
     */
      public EndpointPayloadComponent() {
        super();
      }

        /**
         * @return {@link #type} (The payload type describes the acceptable content that can be communicated on the endpoint.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EndpointPayloadComponent setType(List<CodeableConcept> theType) { 
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

        public EndpointPayloadComponent addType(CodeableConcept t) { //3
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

        /**
         * @return {@link #mimeType} (The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).)
         */
        public List<CodeType> getMimeType() { 
          if (this.mimeType == null)
            this.mimeType = new ArrayList<CodeType>();
          return this.mimeType;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EndpointPayloadComponent setMimeType(List<CodeType> theMimeType) { 
          this.mimeType = theMimeType;
          return this;
        }

        public boolean hasMimeType() { 
          if (this.mimeType == null)
            return false;
          for (CodeType item : this.mimeType)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #mimeType} (The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).)
         */
        public CodeType addMimeTypeElement() {//2 
          CodeType t = new CodeType();
          if (this.mimeType == null)
            this.mimeType = new ArrayList<CodeType>();
          this.mimeType.add(t);
          return t;
        }

        /**
         * @param value {@link #mimeType} (The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).)
         */
        public EndpointPayloadComponent addMimeType(String value) { //1
          CodeType t = new CodeType();
          t.setValue(value);
          if (this.mimeType == null)
            this.mimeType = new ArrayList<CodeType>();
          this.mimeType.add(t);
          return this;
        }

        /**
         * @param value {@link #mimeType} (The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).)
         */
        public boolean hasMimeType(String value) { 
          if (this.mimeType == null)
            return false;
          for (CodeType v : this.mimeType)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The payload type describes the acceptable content that can be communicated on the endpoint.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("mimeType", "code", "The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).", 0, java.lang.Integer.MAX_VALUE, mimeType));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The payload type describes the acceptable content that can be communicated on the endpoint.", 0, java.lang.Integer.MAX_VALUE, type);
          case -1392120434: /*mimeType*/  return new Property("mimeType", "code", "The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the mime type is not specified, then the sender could send any content (including no content depending on the connectionType).", 0, java.lang.Integer.MAX_VALUE, mimeType);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1392120434: /*mimeType*/ return this.mimeType == null ? new Base[0] : this.mimeType.toArray(new Base[this.mimeType.size()]); // CodeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1392120434: // mimeType
          this.getMimeType().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("mimeType")) {
          this.getMimeType().add(TypeConvertor.castToCode(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().remove(value);
        } else if (name.equals("mimeType")) {
          this.getMimeType().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return addType(); 
        case -1392120434:  return addMimeTypeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1392120434: /*mimeType*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("mimeType")) {
          throw new FHIRException("Cannot call addChild on a singleton property Endpoint.payload.mimeType");
        }
        else
          return super.addChild(name);
      }

      public EndpointPayloadComponent copy() {
        EndpointPayloadComponent dst = new EndpointPayloadComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EndpointPayloadComponent dst) {
        super.copyValues(dst);
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (mimeType != null) {
          dst.mimeType = new ArrayList<CodeType>();
          for (CodeType i : mimeType)
            dst.mimeType.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EndpointPayloadComponent))
          return false;
        EndpointPayloadComponent o = (EndpointPayloadComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(mimeType, o.mimeType, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EndpointPayloadComponent))
          return false;
        EndpointPayloadComponent o = (EndpointPayloadComponent) other_;
        return compareValues(mimeType, o.mimeType, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, mimeType);
      }

  public String fhirType() {
    return "Endpoint.payload";

  }

  }

    /**
     * Identifier for the organization that is used to identify the endpoint across multiple disparate systems.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifies this endpoint across multiple systems", formalDefinition="Identifier for the organization that is used to identify the endpoint across multiple disparate systems." )
    protected List<Identifier> identifier;

    /**
     * The endpoint status represents the general expected availability of an endpoint.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | suspended | error | off | entered-in-error | test", formalDefinition="The endpoint status represents the general expected availability of an endpoint." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/endpoint-status")
    protected Enumeration<EndpointStatus> status;

    /**
     * A coded value that represents the technical details of the usage of this endpoint, such as what WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook).
     */
    @Child(name = "connectionType", type = {CodeableConcept.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Protocol/Profile/Standard to be used with this endpoint connection", formalDefinition="A coded value that represents the technical details of the usage of this endpoint, such as what WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/endpoint-connection-type")
    protected List<CodeableConcept> connectionType;

    /**
     * A friendly name that this endpoint can be referred to with.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A name that this endpoint can be identified by", formalDefinition="A friendly name that this endpoint can be referred to with." )
    protected StringType name;

    /**
     * The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).
     */
    @Child(name = "description", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Additional details about the endpoint that could be displayed as further information to identify the description beyond its name", formalDefinition="The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose)." )
    protected StringType description;

    /**
     * The type of environment(s) exposed at this endpoint (dev, prod, test, etc.).
     */
    @Child(name = "environmentType", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The type of environment(s) exposed at this endpoint", formalDefinition="The type of environment(s) exposed at this endpoint (dev, prod, test, etc.)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/endpoint-environment")
    protected List<CodeableConcept> environmentType;

    /**
     * The organization that manages this endpoint (even if technically another organization is hosting this in the cloud, it is the organization associated with the data).
     */
    @Child(name = "managingOrganization", type = {Organization.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization that manages this endpoint (might not be the organization that exposes the endpoint)", formalDefinition="The organization that manages this endpoint (even if technically another organization is hosting this in the cloud, it is the organization associated with the data)." )
    protected Reference managingOrganization;

    /**
     * Contact details for a human to contact about the endpoint. The primary use of this for system administrator troubleshooting.
     */
    @Child(name = "contact", type = {ContactPoint.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Contact details for source (e.g. troubleshooting)", formalDefinition="Contact details for a human to contact about the endpoint. The primary use of this for system administrator troubleshooting." )
    protected List<ContactPoint> contact;

    /**
     * The interval during which the endpoint is expected to be operational.
     */
    @Child(name = "period", type = {Period.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Interval the endpoint is expected to be operational", formalDefinition="The interval during which the endpoint is expected to be operational." )
    protected Period period;

    /**
     * The set of payloads that are provided/available at this endpoint.
     */
    @Child(name = "payload", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Set of payloads that are provided by this endpoint", formalDefinition="The set of payloads that are provided/available at this endpoint." )
    protected List<EndpointPayloadComponent> payload;

    /**
     * The uri that describes the actual end-point to connect to.
     */
    @Child(name = "address", type = {UrlType.class}, order=10, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The technical base address for connecting to this endpoint", formalDefinition="The uri that describes the actual end-point to connect to." )
    protected UrlType address;

    /**
     * Additional headers / information to send as part of the notification.
     */
    @Child(name = "header", type = {StringType.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Usage depends on the channel type", formalDefinition="Additional headers / information to send as part of the notification." )
    protected List<StringType> header;

    private static final long serialVersionUID = 1633700267L;

  /**
   * Constructor
   */
    public Endpoint() {
      super();
    }

  /**
   * Constructor
   */
    public Endpoint(EndpointStatus status, CodeableConcept connectionType, String address) {
      super();
      this.setStatus(status);
      this.addConnectionType(connectionType);
      this.setAddress(address);
    }

    /**
     * @return {@link #identifier} (Identifier for the organization that is used to identify the endpoint across multiple disparate systems.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Endpoint setIdentifier(List<Identifier> theIdentifier) { 
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

    public Endpoint addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The endpoint status represents the general expected availability of an endpoint.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EndpointStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Endpoint.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EndpointStatus>(new EndpointStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The endpoint status represents the general expected availability of an endpoint.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Endpoint setStatusElement(Enumeration<EndpointStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The endpoint status represents the general expected availability of an endpoint.
     */
    public EndpointStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The endpoint status represents the general expected availability of an endpoint.
     */
    public Endpoint setStatus(EndpointStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EndpointStatus>(new EndpointStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #connectionType} (A coded value that represents the technical details of the usage of this endpoint, such as what WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook).)
     */
    public List<CodeableConcept> getConnectionType() { 
      if (this.connectionType == null)
        this.connectionType = new ArrayList<CodeableConcept>();
      return this.connectionType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Endpoint setConnectionType(List<CodeableConcept> theConnectionType) { 
      this.connectionType = theConnectionType;
      return this;
    }

    public boolean hasConnectionType() { 
      if (this.connectionType == null)
        return false;
      for (CodeableConcept item : this.connectionType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addConnectionType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.connectionType == null)
        this.connectionType = new ArrayList<CodeableConcept>();
      this.connectionType.add(t);
      return t;
    }

    public Endpoint addConnectionType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.connectionType == null)
        this.connectionType = new ArrayList<CodeableConcept>();
      this.connectionType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #connectionType}, creating it if it does not already exist {3}
     */
    public CodeableConcept getConnectionTypeFirstRep() { 
      if (getConnectionType().isEmpty()) {
        addConnectionType();
      }
      return getConnectionType().get(0);
    }

    /**
     * @return {@link #name} (A friendly name that this endpoint can be referred to with.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Endpoint.name");
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
     * @param value {@link #name} (A friendly name that this endpoint can be referred to with.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Endpoint setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A friendly name that this endpoint can be referred to with.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A friendly name that this endpoint can be referred to with.
     */
    public Endpoint setName(String value) { 
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
     * @return {@link #description} (The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Endpoint.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Endpoint setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).
     */
    public Endpoint setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #environmentType} (The type of environment(s) exposed at this endpoint (dev, prod, test, etc.).)
     */
    public List<CodeableConcept> getEnvironmentType() { 
      if (this.environmentType == null)
        this.environmentType = new ArrayList<CodeableConcept>();
      return this.environmentType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Endpoint setEnvironmentType(List<CodeableConcept> theEnvironmentType) { 
      this.environmentType = theEnvironmentType;
      return this;
    }

    public boolean hasEnvironmentType() { 
      if (this.environmentType == null)
        return false;
      for (CodeableConcept item : this.environmentType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addEnvironmentType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.environmentType == null)
        this.environmentType = new ArrayList<CodeableConcept>();
      this.environmentType.add(t);
      return t;
    }

    public Endpoint addEnvironmentType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.environmentType == null)
        this.environmentType = new ArrayList<CodeableConcept>();
      this.environmentType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #environmentType}, creating it if it does not already exist {3}
     */
    public CodeableConcept getEnvironmentTypeFirstRep() { 
      if (getEnvironmentType().isEmpty()) {
        addEnvironmentType();
      }
      return getEnvironmentType().get(0);
    }

    /**
     * @return {@link #managingOrganization} (The organization that manages this endpoint (even if technically another organization is hosting this in the cloud, it is the organization associated with the data).)
     */
    public Reference getManagingOrganization() { 
      if (this.managingOrganization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Endpoint.managingOrganization");
        else if (Configuration.doAutoCreate())
          this.managingOrganization = new Reference(); // cc
      return this.managingOrganization;
    }

    public boolean hasManagingOrganization() { 
      return this.managingOrganization != null && !this.managingOrganization.isEmpty();
    }

    /**
     * @param value {@link #managingOrganization} (The organization that manages this endpoint (even if technically another organization is hosting this in the cloud, it is the organization associated with the data).)
     */
    public Endpoint setManagingOrganization(Reference value) { 
      this.managingOrganization = value;
      return this;
    }

    /**
     * @return {@link #contact} (Contact details for a human to contact about the endpoint. The primary use of this for system administrator troubleshooting.)
     */
    public List<ContactPoint> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Endpoint setContact(List<ContactPoint> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactPoint item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactPoint addContact() { //3
      ContactPoint t = new ContactPoint();
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      this.contact.add(t);
      return t;
    }

    public Endpoint addContact(ContactPoint t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactPoint>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactPoint getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #period} (The interval during which the endpoint is expected to be operational.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Endpoint.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The interval during which the endpoint is expected to be operational.)
     */
    public Endpoint setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #payload} (The set of payloads that are provided/available at this endpoint.)
     */
    public List<EndpointPayloadComponent> getPayload() { 
      if (this.payload == null)
        this.payload = new ArrayList<EndpointPayloadComponent>();
      return this.payload;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Endpoint setPayload(List<EndpointPayloadComponent> thePayload) { 
      this.payload = thePayload;
      return this;
    }

    public boolean hasPayload() { 
      if (this.payload == null)
        return false;
      for (EndpointPayloadComponent item : this.payload)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EndpointPayloadComponent addPayload() { //3
      EndpointPayloadComponent t = new EndpointPayloadComponent();
      if (this.payload == null)
        this.payload = new ArrayList<EndpointPayloadComponent>();
      this.payload.add(t);
      return t;
    }

    public Endpoint addPayload(EndpointPayloadComponent t) { //3
      if (t == null)
        return this;
      if (this.payload == null)
        this.payload = new ArrayList<EndpointPayloadComponent>();
      this.payload.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #payload}, creating it if it does not already exist {3}
     */
    public EndpointPayloadComponent getPayloadFirstRep() { 
      if (getPayload().isEmpty()) {
        addPayload();
      }
      return getPayload().get(0);
    }

    /**
     * @return {@link #address} (The uri that describes the actual end-point to connect to.). This is the underlying object with id, value and extensions. The accessor "getAddress" gives direct access to the value
     */
    public UrlType getAddressElement() { 
      if (this.address == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Endpoint.address");
        else if (Configuration.doAutoCreate())
          this.address = new UrlType(); // bb
      return this.address;
    }

    public boolean hasAddressElement() { 
      return this.address != null && !this.address.isEmpty();
    }

    public boolean hasAddress() { 
      return this.address != null && !this.address.isEmpty();
    }

    /**
     * @param value {@link #address} (The uri that describes the actual end-point to connect to.). This is the underlying object with id, value and extensions. The accessor "getAddress" gives direct access to the value
     */
    public Endpoint setAddressElement(UrlType value) { 
      this.address = value;
      return this;
    }

    /**
     * @return The uri that describes the actual end-point to connect to.
     */
    public String getAddress() { 
      return this.address == null ? null : this.address.getValue();
    }

    /**
     * @param value The uri that describes the actual end-point to connect to.
     */
    public Endpoint setAddress(String value) { 
        if (this.address == null)
          this.address = new UrlType();
        this.address.setValue(value);
      return this;
    }

    /**
     * @return {@link #header} (Additional headers / information to send as part of the notification.)
     */
    public List<StringType> getHeader() { 
      if (this.header == null)
        this.header = new ArrayList<StringType>();
      return this.header;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Endpoint setHeader(List<StringType> theHeader) { 
      this.header = theHeader;
      return this;
    }

    public boolean hasHeader() { 
      if (this.header == null)
        return false;
      for (StringType item : this.header)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #header} (Additional headers / information to send as part of the notification.)
     */
    public StringType addHeaderElement() {//2 
      StringType t = new StringType();
      if (this.header == null)
        this.header = new ArrayList<StringType>();
      this.header.add(t);
      return t;
    }

    /**
     * @param value {@link #header} (Additional headers / information to send as part of the notification.)
     */
    public Endpoint addHeader(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.header == null)
        this.header = new ArrayList<StringType>();
      this.header.add(t);
      return this;
    }

    /**
     * @param value {@link #header} (Additional headers / information to send as part of the notification.)
     */
    public boolean hasHeader(String value) { 
      if (this.header == null)
        return false;
      for (StringType v : this.header)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier for the organization that is used to identify the endpoint across multiple disparate systems.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The endpoint status represents the general expected availability of an endpoint.", 0, 1, status));
        children.add(new Property("connectionType", "CodeableConcept", "A coded value that represents the technical details of the usage of this endpoint, such as what WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook).", 0, java.lang.Integer.MAX_VALUE, connectionType));
        children.add(new Property("name", "string", "A friendly name that this endpoint can be referred to with.", 0, 1, name));
        children.add(new Property("description", "string", "The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).", 0, 1, description));
        children.add(new Property("environmentType", "CodeableConcept", "The type of environment(s) exposed at this endpoint (dev, prod, test, etc.).", 0, java.lang.Integer.MAX_VALUE, environmentType));
        children.add(new Property("managingOrganization", "Reference(Organization)", "The organization that manages this endpoint (even if technically another organization is hosting this in the cloud, it is the organization associated with the data).", 0, 1, managingOrganization));
        children.add(new Property("contact", "ContactPoint", "Contact details for a human to contact about the endpoint. The primary use of this for system administrator troubleshooting.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("period", "Period", "The interval during which the endpoint is expected to be operational.", 0, 1, period));
        children.add(new Property("payload", "", "The set of payloads that are provided/available at this endpoint.", 0, java.lang.Integer.MAX_VALUE, payload));
        children.add(new Property("address", "url", "The uri that describes the actual end-point to connect to.", 0, 1, address));
        children.add(new Property("header", "string", "Additional headers / information to send as part of the notification.", 0, java.lang.Integer.MAX_VALUE, header));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for the organization that is used to identify the endpoint across multiple disparate systems.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The endpoint status represents the general expected availability of an endpoint.", 0, 1, status);
        case 1270211384: /*connectionType*/  return new Property("connectionType", "CodeableConcept", "A coded value that represents the technical details of the usage of this endpoint, such as what WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook).", 0, java.lang.Integer.MAX_VALUE, connectionType);
        case 3373707: /*name*/  return new Property("name", "string", "A friendly name that this endpoint can be referred to with.", 0, 1, name);
        case -1724546052: /*description*/  return new Property("description", "string", "The description of the endpoint and what it is for (typically used as supplemental information in an endpoint directory describing its usage/purpose).", 0, 1, description);
        case 1680602093: /*environmentType*/  return new Property("environmentType", "CodeableConcept", "The type of environment(s) exposed at this endpoint (dev, prod, test, etc.).", 0, java.lang.Integer.MAX_VALUE, environmentType);
        case -2058947787: /*managingOrganization*/  return new Property("managingOrganization", "Reference(Organization)", "The organization that manages this endpoint (even if technically another organization is hosting this in the cloud, it is the organization associated with the data).", 0, 1, managingOrganization);
        case 951526432: /*contact*/  return new Property("contact", "ContactPoint", "Contact details for a human to contact about the endpoint. The primary use of this for system administrator troubleshooting.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -991726143: /*period*/  return new Property("period", "Period", "The interval during which the endpoint is expected to be operational.", 0, 1, period);
        case -786701938: /*payload*/  return new Property("payload", "", "The set of payloads that are provided/available at this endpoint.", 0, java.lang.Integer.MAX_VALUE, payload);
        case -1147692044: /*address*/  return new Property("address", "url", "The uri that describes the actual end-point to connect to.", 0, 1, address);
        case -1221270899: /*header*/  return new Property("header", "string", "Additional headers / information to send as part of the notification.", 0, java.lang.Integer.MAX_VALUE, header);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EndpointStatus>
        case 1270211384: /*connectionType*/ return this.connectionType == null ? new Base[0] : this.connectionType.toArray(new Base[this.connectionType.size()]); // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 1680602093: /*environmentType*/ return this.environmentType == null ? new Base[0] : this.environmentType.toArray(new Base[this.environmentType.size()]); // CodeableConcept
        case -2058947787: /*managingOrganization*/ return this.managingOrganization == null ? new Base[0] : new Base[] {this.managingOrganization}; // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactPoint
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case -786701938: /*payload*/ return this.payload == null ? new Base[0] : this.payload.toArray(new Base[this.payload.size()]); // EndpointPayloadComponent
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : new Base[] {this.address}; // UrlType
        case -1221270899: /*header*/ return this.header == null ? new Base[0] : this.header.toArray(new Base[this.header.size()]); // StringType
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
          value = new EndpointStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EndpointStatus>
          return value;
        case 1270211384: // connectionType
          this.getConnectionType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 1680602093: // environmentType
          this.getEnvironmentType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -2058947787: // managingOrganization
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -786701938: // payload
          this.getPayload().add((EndpointPayloadComponent) value); // EndpointPayloadComponent
          return value;
        case -1147692044: // address
          this.address = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case -1221270899: // header
          this.getHeader().add(TypeConvertor.castToString(value)); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new EndpointStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EndpointStatus>
        } else if (name.equals("connectionType")) {
          this.getConnectionType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("environmentType")) {
          this.getEnvironmentType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("managingOrganization")) {
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("payload")) {
          this.getPayload().add((EndpointPayloadComponent) value);
        } else if (name.equals("address")) {
          this.address = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("header")) {
          this.getHeader().add(TypeConvertor.castToString(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new EndpointStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EndpointStatus>
        } else if (name.equals("connectionType")) {
          this.getConnectionType().remove(value);
        } else if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("environmentType")) {
          this.getEnvironmentType().remove(value);
        } else if (name.equals("managingOrganization")) {
          this.managingOrganization = null;
        } else if (name.equals("contact")) {
          this.getContact().remove(value);
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("payload")) {
          this.getPayload().add((EndpointPayloadComponent) value);
        } else if (name.equals("address")) {
          this.address = null;
        } else if (name.equals("header")) {
          this.getHeader().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 1270211384:  return addConnectionType(); 
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case 1680602093:  return addEnvironmentType(); 
        case -2058947787:  return getManagingOrganization();
        case 951526432:  return addContact(); 
        case -991726143:  return getPeriod();
        case -786701938:  return addPayload(); 
        case -1147692044:  return getAddressElement();
        case -1221270899:  return addHeaderElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1270211384: /*connectionType*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 1680602093: /*environmentType*/ return new String[] {"CodeableConcept"};
        case -2058947787: /*managingOrganization*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ContactPoint"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -786701938: /*payload*/ return new String[] {};
        case -1147692044: /*address*/ return new String[] {"url"};
        case -1221270899: /*header*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Endpoint.status");
        }
        else if (name.equals("connectionType")) {
          return addConnectionType();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property Endpoint.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Endpoint.description");
        }
        else if (name.equals("environmentType")) {
          return addEnvironmentType();
        }
        else if (name.equals("managingOrganization")) {
          this.managingOrganization = new Reference();
          return this.managingOrganization;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("payload")) {
          return addPayload();
        }
        else if (name.equals("address")) {
          throw new FHIRException("Cannot call addChild on a singleton property Endpoint.address");
        }
        else if (name.equals("header")) {
          throw new FHIRException("Cannot call addChild on a singleton property Endpoint.header");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Endpoint";

  }

      public Endpoint copy() {
        Endpoint dst = new Endpoint();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Endpoint dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (connectionType != null) {
          dst.connectionType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : connectionType)
            dst.connectionType.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        if (environmentType != null) {
          dst.environmentType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : environmentType)
            dst.environmentType.add(i.copy());
        };
        dst.managingOrganization = managingOrganization == null ? null : managingOrganization.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactPoint>();
          for (ContactPoint i : contact)
            dst.contact.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
        if (payload != null) {
          dst.payload = new ArrayList<EndpointPayloadComponent>();
          for (EndpointPayloadComponent i : payload)
            dst.payload.add(i.copy());
        };
        dst.address = address == null ? null : address.copy();
        if (header != null) {
          dst.header = new ArrayList<StringType>();
          for (StringType i : header)
            dst.header.add(i.copy());
        };
      }

      protected Endpoint typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Endpoint))
          return false;
        Endpoint o = (Endpoint) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(connectionType, o.connectionType, true)
           && compareDeep(name, o.name, true) && compareDeep(description, o.description, true) && compareDeep(environmentType, o.environmentType, true)
           && compareDeep(managingOrganization, o.managingOrganization, true) && compareDeep(contact, o.contact, true)
           && compareDeep(period, o.period, true) && compareDeep(payload, o.payload, true) && compareDeep(address, o.address, true)
           && compareDeep(header, o.header, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Endpoint))
          return false;
        Endpoint o = (Endpoint) other_;
        return compareValues(status, o.status, true) && compareValues(name, o.name, true) && compareValues(description, o.description, true)
           && compareValues(address, o.address, true) && compareValues(header, o.header, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, connectionType
          , name, description, environmentType, managingOrganization, contact, period, payload
          , address, header);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Endpoint;
   }

 /**
   * Search parameter: <b>connection-type</b>
   * <p>
   * Description: <b>Protocol/Profile/Standard to be used with this endpoint connection</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.connectionType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="connection-type", path="Endpoint.connectionType", description="Protocol/Profile/Standard to be used with this endpoint connection", type="token" )
  public static final String SP_CONNECTION_TYPE = "connection-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>connection-type</b>
   * <p>
   * Description: <b>Protocol/Profile/Standard to be used with this endpoint connection</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.connectionType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONNECTION_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONNECTION_TYPE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Identifies this endpoint across multiple systems</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Endpoint.identifier", description="Identifies this endpoint across multiple systems", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Identifies this endpoint across multiple systems</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A name that this endpoint can be identified by</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Endpoint.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="Endpoint.name", description="A name that this endpoint can be identified by", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A name that this endpoint can be identified by</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Endpoint.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The organization that is managing the endpoint</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Endpoint.managingOrganization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="Endpoint.managingOrganization", description="The organization that is managing the endpoint", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The organization that is managing the endpoint</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Endpoint.managingOrganization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Endpoint:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("Endpoint:organization").toLocked();

 /**
   * Search parameter: <b>payload-type</b>
   * <p>
   * Description: <b>The type of content that may be used at this endpoint (e.g. XDS Discharge summaries)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.payload.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="payload-type", path="Endpoint.payload.type", description="The type of content that may be used at this endpoint (e.g. XDS Discharge summaries)", type="token" )
  public static final String SP_PAYLOAD_TYPE = "payload-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>payload-type</b>
   * <p>
   * Description: <b>The type of content that may be used at this endpoint (e.g. XDS Discharge summaries)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.payload.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PAYLOAD_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PAYLOAD_TYPE);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the Endpoint (usually expected to be active)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Endpoint.status", description="The current status of the Endpoint (usually expected to be active)", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the Endpoint (usually expected to be active)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Endpoint.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

