package org.hl7.fhir.r5.tools;


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
import org.hl7.fhir.r5.tools.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * This structure is defined to allow the FHIR Validator to validate a CDSHooks Request Body. TODO: This content will be moved to the CDS Hooks specification in the future
 */
@DatatypeDef(name="CDSHooksRequest")
public class CDSHooksRequest extends CDSHooksElement implements ICompositeType {

    @Block()
    public static class CDSHooksRequestFhirAuthorizationComponent extends CDSHooksElement {
        /**
         * This is the OAuth 2.0 access token that provides access to the FHIR server
         */
        @Child(name = "accessToken", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="This is the OAuth 2.0 access token that provides access to the FHIR server", formalDefinition="This is the OAuth 2.0 access token that provides access to the FHIR server" )
        protected StringType accessToken;

        /**
         * Fixed value: Bearer
         */
        @Child(name = "tokenType", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixed value: Bearer", formalDefinition="Fixed value: Bearer" )
        protected CodeType tokenType;

        /**
         * The lifetime in seconds of the access token.
         */
        @Child(name = "expiresIn", type = {IntegerType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The lifetime in seconds of the access token.", formalDefinition="The lifetime in seconds of the access token." )
        protected IntegerType expiresIn;

        /**
         * The scopes the access token grants the CDS Service
         */
        @Child(name = "scope", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The scopes the access token grants the CDS Service", formalDefinition="The scopes the access token grants the CDS Service" )
        protected StringType scope;

        /**
         * The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server
         */
        @Child(name = "subject", type = {StringType.class}, order=5, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server", formalDefinition="The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server" )
        protected StringType subject;

        /**
         * The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server
         */
        @Child(name = "patient", type = {IdType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server", formalDefinition="The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server" )
        protected IdType patient;

        private static final long serialVersionUID = 265340325L;

    /**
     * Constructor
     */
      public CDSHooksRequestFhirAuthorizationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksRequestFhirAuthorizationComponent(String accessToken, String tokenType, int expiresIn, String scope, String subject) {
        super();
        this.setAccessToken(accessToken);
        this.setTokenType(tokenType);
        this.setExpiresIn(expiresIn);
        this.setScope(scope);
        this.setSubject(subject);
      }

        /**
         * @return {@link #accessToken} (This is the OAuth 2.0 access token that provides access to the FHIR server). This is the underlying object with id, value and extensions. The accessor "getAccessToken" gives direct access to the value
         */
        public StringType getAccessTokenElement() { 
          if (this.accessToken == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestFhirAuthorizationComponent.accessToken");
            else if (Configuration.doAutoCreate())
              this.accessToken = new StringType(); // bb
          return this.accessToken;
        }

        public boolean hasAccessTokenElement() { 
          return this.accessToken != null && !this.accessToken.isEmpty();
        }

        public boolean hasAccessToken() { 
          return this.accessToken != null && !this.accessToken.isEmpty();
        }

        /**
         * @param value {@link #accessToken} (This is the OAuth 2.0 access token that provides access to the FHIR server). This is the underlying object with id, value and extensions. The accessor "getAccessToken" gives direct access to the value
         */
        public CDSHooksRequestFhirAuthorizationComponent setAccessTokenElement(StringType value) { 
          this.accessToken = value;
          return this;
        }

        /**
         * @return This is the OAuth 2.0 access token that provides access to the FHIR server
         */
        public String getAccessToken() { 
          return this.accessToken == null ? null : this.accessToken.getValue();
        }

        /**
         * @param value This is the OAuth 2.0 access token that provides access to the FHIR server
         */
        public CDSHooksRequestFhirAuthorizationComponent setAccessToken(String value) { 
            if (this.accessToken == null)
              this.accessToken = new StringType();
            this.accessToken.setValue(value);
          return this;
        }

        /**
         * @return {@link #tokenType} (Fixed value: Bearer). This is the underlying object with id, value and extensions. The accessor "getTokenType" gives direct access to the value
         */
        public CodeType getTokenTypeElement() { 
          if (this.tokenType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestFhirAuthorizationComponent.tokenType");
            else if (Configuration.doAutoCreate())
              this.tokenType = new CodeType(); // bb
          return this.tokenType;
        }

        public boolean hasTokenTypeElement() { 
          return this.tokenType != null && !this.tokenType.isEmpty();
        }

        public boolean hasTokenType() { 
          return this.tokenType != null && !this.tokenType.isEmpty();
        }

        /**
         * @param value {@link #tokenType} (Fixed value: Bearer). This is the underlying object with id, value and extensions. The accessor "getTokenType" gives direct access to the value
         */
        public CDSHooksRequestFhirAuthorizationComponent setTokenTypeElement(CodeType value) { 
          this.tokenType = value;
          return this;
        }

        /**
         * @return Fixed value: Bearer
         */
        public String getTokenType() { 
          return this.tokenType == null ? null : this.tokenType.getValue();
        }

        /**
         * @param value Fixed value: Bearer
         */
        public CDSHooksRequestFhirAuthorizationComponent setTokenType(String value) { 
            if (this.tokenType == null)
              this.tokenType = new CodeType();
            this.tokenType.setValue(value);
          return this;
        }

        /**
         * @return {@link #expiresIn} (The lifetime in seconds of the access token.). This is the underlying object with id, value and extensions. The accessor "getExpiresIn" gives direct access to the value
         */
        public IntegerType getExpiresInElement() { 
          if (this.expiresIn == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestFhirAuthorizationComponent.expiresIn");
            else if (Configuration.doAutoCreate())
              this.expiresIn = new IntegerType(); // bb
          return this.expiresIn;
        }

        public boolean hasExpiresInElement() { 
          return this.expiresIn != null && !this.expiresIn.isEmpty();
        }

        public boolean hasExpiresIn() { 
          return this.expiresIn != null && !this.expiresIn.isEmpty();
        }

        /**
         * @param value {@link #expiresIn} (The lifetime in seconds of the access token.). This is the underlying object with id, value and extensions. The accessor "getExpiresIn" gives direct access to the value
         */
        public CDSHooksRequestFhirAuthorizationComponent setExpiresInElement(IntegerType value) { 
          this.expiresIn = value;
          return this;
        }

        /**
         * @return The lifetime in seconds of the access token.
         */
        public int getExpiresIn() { 
          return this.expiresIn == null || this.expiresIn.isEmpty() ? 0 : this.expiresIn.getValue();
        }

        /**
         * @param value The lifetime in seconds of the access token.
         */
        public CDSHooksRequestFhirAuthorizationComponent setExpiresIn(int value) { 
            if (this.expiresIn == null)
              this.expiresIn = new IntegerType();
            this.expiresIn.setValue(value);
          return this;
        }

        /**
         * @return {@link #scope} (The scopes the access token grants the CDS Service). This is the underlying object with id, value and extensions. The accessor "getScope" gives direct access to the value
         */
        public StringType getScopeElement() { 
          if (this.scope == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestFhirAuthorizationComponent.scope");
            else if (Configuration.doAutoCreate())
              this.scope = new StringType(); // bb
          return this.scope;
        }

        public boolean hasScopeElement() { 
          return this.scope != null && !this.scope.isEmpty();
        }

        public boolean hasScope() { 
          return this.scope != null && !this.scope.isEmpty();
        }

        /**
         * @param value {@link #scope} (The scopes the access token grants the CDS Service). This is the underlying object with id, value and extensions. The accessor "getScope" gives direct access to the value
         */
        public CDSHooksRequestFhirAuthorizationComponent setScopeElement(StringType value) { 
          this.scope = value;
          return this;
        }

        /**
         * @return The scopes the access token grants the CDS Service
         */
        public String getScope() { 
          return this.scope == null ? null : this.scope.getValue();
        }

        /**
         * @param value The scopes the access token grants the CDS Service
         */
        public CDSHooksRequestFhirAuthorizationComponent setScope(String value) { 
            if (this.scope == null)
              this.scope = new StringType();
            this.scope.setValue(value);
          return this;
        }

        /**
         * @return {@link #subject} (The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server). This is the underlying object with id, value and extensions. The accessor "getSubject" gives direct access to the value
         */
        public StringType getSubjectElement() { 
          if (this.subject == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestFhirAuthorizationComponent.subject");
            else if (Configuration.doAutoCreate())
              this.subject = new StringType(); // bb
          return this.subject;
        }

        public boolean hasSubjectElement() { 
          return this.subject != null && !this.subject.isEmpty();
        }

        public boolean hasSubject() { 
          return this.subject != null && !this.subject.isEmpty();
        }

        /**
         * @param value {@link #subject} (The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server). This is the underlying object with id, value and extensions. The accessor "getSubject" gives direct access to the value
         */
        public CDSHooksRequestFhirAuthorizationComponent setSubjectElement(StringType value) { 
          this.subject = value;
          return this;
        }

        /**
         * @return The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server
         */
        public String getSubject() { 
          return this.subject == null ? null : this.subject.getValue();
        }

        /**
         * @param value The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server
         */
        public CDSHooksRequestFhirAuthorizationComponent setSubject(String value) { 
            if (this.subject == null)
              this.subject = new StringType();
            this.subject.setValue(value);
          return this;
        }

        /**
         * @return {@link #patient} (The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server). This is the underlying object with id, value and extensions. The accessor "getPatient" gives direct access to the value
         */
        public IdType getPatientElement() { 
          if (this.patient == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestFhirAuthorizationComponent.patient");
            else if (Configuration.doAutoCreate())
              this.patient = new IdType(); // bb
          return this.patient;
        }

        public boolean hasPatientElement() { 
          return this.patient != null && !this.patient.isEmpty();
        }

        public boolean hasPatient() { 
          return this.patient != null && !this.patient.isEmpty();
        }

        /**
         * @param value {@link #patient} (The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server). This is the underlying object with id, value and extensions. The accessor "getPatient" gives direct access to the value
         */
        public CDSHooksRequestFhirAuthorizationComponent setPatientElement(IdType value) { 
          this.patient = value;
          return this;
        }

        /**
         * @return The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server
         */
        public String getPatient() { 
          return this.patient == null ? null : this.patient.getValue();
        }

        /**
         * @param value The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server
         */
        public CDSHooksRequestFhirAuthorizationComponent setPatient(String value) { 
          if (Utilities.noString(value))
            this.patient = null;
          else {
            if (this.patient == null)
              this.patient = new IdType();
            this.patient.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("accessToken", "string", "This is the OAuth 2.0 access token that provides access to the FHIR server", 0, 1, accessToken));
          children.add(new Property("tokenType", "code", "Fixed value: Bearer", 0, 1, tokenType));
          children.add(new Property("expiresIn", "integer", "The lifetime in seconds of the access token.", 0, 1, expiresIn));
          children.add(new Property("scope", "string", "The scopes the access token grants the CDS Service", 0, 1, scope));
          children.add(new Property("subject", "string", "The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server", 0, 1, subject));
          children.add(new Property("patient", "id", "The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server", 0, 1, patient));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1042689291: /*accessToken*/  return new Property("accessToken", "string", "This is the OAuth 2.0 access token that provides access to the FHIR server", 0, 1, accessToken);
          case 141498579: /*tokenType*/  return new Property("tokenType", "code", "Fixed value: Bearer", 0, 1, tokenType);
          case 250196857: /*expiresIn*/  return new Property("expiresIn", "integer", "The lifetime in seconds of the access token.", 0, 1, expiresIn);
          case 109264468: /*scope*/  return new Property("scope", "string", "The scopes the access token grants the CDS Service", 0, 1, scope);
          case -1867885268: /*subject*/  return new Property("subject", "string", "The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server", 0, 1, subject);
          case -791418107: /*patient*/  return new Property("patient", "id", "The OAuth 2.0 client identifier of the CDS Service, as registered with the CDS Client's authorization server", 0, 1, patient);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1042689291: /*accessToken*/ return this.accessToken == null ? new Base[0] : new Base[] {this.accessToken}; // StringType
        case 141498579: /*tokenType*/ return this.tokenType == null ? new Base[0] : new Base[] {this.tokenType}; // CodeType
        case 250196857: /*expiresIn*/ return this.expiresIn == null ? new Base[0] : new Base[] {this.expiresIn}; // IntegerType
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : new Base[] {this.scope}; // StringType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // StringType
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // IdType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1042689291: // accessToken
          this.accessToken = TypeConvertor.castToString(value); // StringType
          return value;
        case 141498579: // tokenType
          this.tokenType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 250196857: // expiresIn
          this.expiresIn = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 109264468: // scope
          this.scope = TypeConvertor.castToString(value); // StringType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToString(value); // StringType
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToId(value); // IdType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("accessToken")) {
          this.accessToken = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("tokenType")) {
          this.tokenType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("expiresIn")) {
          this.expiresIn = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("scope")) {
          this.scope = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToId(value); // IdType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1042689291:  return getAccessTokenElement();
        case 141498579:  return getTokenTypeElement();
        case 250196857:  return getExpiresInElement();
        case 109264468:  return getScopeElement();
        case -1867885268:  return getSubjectElement();
        case -791418107:  return getPatientElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1042689291: /*accessToken*/ return new String[] {"string"};
        case 141498579: /*tokenType*/ return new String[] {"code"};
        case 250196857: /*expiresIn*/ return new String[] {"integer"};
        case 109264468: /*scope*/ return new String[] {"string"};
        case -1867885268: /*subject*/ return new String[] {"string"};
        case -791418107: /*patient*/ return new String[] {"id"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("accessToken")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirAuthorization.accessToken");
        }
        else if (name.equals("tokenType")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirAuthorization.tokenType");
        }
        else if (name.equals("expiresIn")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirAuthorization.expiresIn");
        }
        else if (name.equals("scope")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirAuthorization.scope");
        }
        else if (name.equals("subject")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirAuthorization.subject");
        }
        else if (name.equals("patient")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirAuthorization.patient");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksRequestFhirAuthorizationComponent copy() {
        CDSHooksRequestFhirAuthorizationComponent dst = new CDSHooksRequestFhirAuthorizationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksRequestFhirAuthorizationComponent dst) {
        super.copyValues(dst);
        dst.accessToken = accessToken == null ? null : accessToken.copy();
        dst.tokenType = tokenType == null ? null : tokenType.copy();
        dst.expiresIn = expiresIn == null ? null : expiresIn.copy();
        dst.scope = scope == null ? null : scope.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.patient = patient == null ? null : patient.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksRequestFhirAuthorizationComponent))
          return false;
        CDSHooksRequestFhirAuthorizationComponent o = (CDSHooksRequestFhirAuthorizationComponent) other_;
        return compareDeep(accessToken, o.accessToken, true) && compareDeep(tokenType, o.tokenType, true)
           && compareDeep(expiresIn, o.expiresIn, true) && compareDeep(scope, o.scope, true) && compareDeep(subject, o.subject, true)
           && compareDeep(patient, o.patient, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksRequestFhirAuthorizationComponent))
          return false;
        CDSHooksRequestFhirAuthorizationComponent o = (CDSHooksRequestFhirAuthorizationComponent) other_;
        return compareValues(accessToken, o.accessToken, true) && compareValues(tokenType, o.tokenType, true)
           && compareValues(expiresIn, o.expiresIn, true) && compareValues(scope, o.scope, true) && compareValues(subject, o.subject, true)
           && compareValues(patient, o.patient, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(accessToken, tokenType, expiresIn
          , scope, subject, patient);
      }

  public String fhirType() {
    return "CDSHooksRequest.fhirAuthorization";

  }

  }

    @Block()
    public static class CDSHooksRequestPrefetchComponent extends LogicalBase {
        /**
         * Key of FHIR query - name for client to use when sending to Request
         */
        @Child(name = "key", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Key of FHIR query - name for client to use when sending to Request", formalDefinition="Key of FHIR query - name for client to use when sending to Request" )
        protected CodeType key;

        /**
         * Value of FHIR query - FHIR Query for client to perform
         */
        @Child(name = "value", type = {Resource.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of FHIR query - FHIR Query for client to perform", formalDefinition="Value of FHIR query - FHIR Query for client to perform" )
        protected Resource value;

        private static final long serialVersionUID = -18668409L;

    /**
     * Constructor
     */
      public CDSHooksRequestPrefetchComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksRequestPrefetchComponent(String key, Resource value) {
        super();
        this.setKey(key);
        this.setValue(value);
      }

        /**
         * @return {@link #key} (Key of FHIR query - name for client to use when sending to Request). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public CodeType getKeyElement() { 
          if (this.key == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksRequestPrefetchComponent.key");
            else if (Configuration.doAutoCreate())
              this.key = new CodeType(); // bb
          return this.key;
        }

        public boolean hasKeyElement() { 
          return this.key != null && !this.key.isEmpty();
        }

        public boolean hasKey() { 
          return this.key != null && !this.key.isEmpty();
        }

        /**
         * @param value {@link #key} (Key of FHIR query - name for client to use when sending to Request). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public CDSHooksRequestPrefetchComponent setKeyElement(CodeType value) { 
          this.key = value;
          return this;
        }

        /**
         * @return Key of FHIR query - name for client to use when sending to Request
         */
        public String getKey() { 
          return this.key == null ? null : this.key.getValue();
        }

        /**
         * @param value Key of FHIR query - name for client to use when sending to Request
         */
        public CDSHooksRequestPrefetchComponent setKey(String value) { 
            if (this.key == null)
              this.key = new CodeType();
            this.key.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (Value of FHIR query - FHIR Query for client to perform)
         */
        public Resource getValue() { 
          return this.value;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Value of FHIR query - FHIR Query for client to perform)
         */
        public CDSHooksRequestPrefetchComponent setValue(Resource value) { 
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("key", "code", "Key of FHIR query - name for client to use when sending to Request", 0, 1, key));
          children.add(new Property("value", "Resource", "Value of FHIR query - FHIR Query for client to perform", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106079: /*key*/  return new Property("key", "code", "Key of FHIR query - name for client to use when sending to Request", 0, 1, key);
          case 111972721: /*value*/  return new Property("value", "Resource", "Value of FHIR query - FHIR Query for client to perform", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // CodeType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // Resource
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106079: // key
          this.key = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 111972721: // value
          this.value = (Resource) value; // Resource
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("key")) {
          this.key = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("value")) {
          this.value = (Resource) value; // Resource
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079:  return getKeyElement();
        case 111972721: throw new FHIRException("Cannot make property value as it is not a complex type"); // Resource
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"code"};
        case 111972721: /*value*/ return new String[] {"Resource"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.prefetch.key");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksRequest.prefetch.value");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksRequestPrefetchComponent copy() {
        CDSHooksRequestPrefetchComponent dst = new CDSHooksRequestPrefetchComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksRequestPrefetchComponent dst) {
        super.copyValues(dst);
        dst.key = key == null ? null : key.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksRequestPrefetchComponent))
          return false;
        CDSHooksRequestPrefetchComponent o = (CDSHooksRequestPrefetchComponent) other_;
        return compareDeep(key, o.key, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksRequestPrefetchComponent))
          return false;
        CDSHooksRequestPrefetchComponent o = (CDSHooksRequestPrefetchComponent) other_;
        return compareValues(key, o.key, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, value);
      }

  public String fhirType() {
    return "CDSHooksRequest.prefetch";

  }

  }

    /**
     * The hook that triggered this CDS Service call
     */
    @Child(name = "hook", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The hook that triggered this CDS Service call", formalDefinition="The hook that triggered this CDS Service call" )
    protected CodeType hook;

    /**
     * While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation
     */
    @Child(name = "hookInstance", type = {UuidType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A universally unique identifier (UUID) for this particular hook call", formalDefinition="While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation" )
    protected UuidType hookInstance;

    /**
     * The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged
     */
    @Child(name = "fhirServer", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The base URL of the CDS Client's FHIR server", formalDefinition="The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged" )
    protected UrlType fhirServer;

    /**
     * A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token
     */
    @Child(name = "fhirAuthorization", type = {CDSHooksElement.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token", formalDefinition="A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token" )
    protected CDSHooksRequestFhirAuthorizationComponent fhirAuthorization;

    /**
     * Hook-specific contextual data that the CDS service will need
     */
    @Child(name = "context", type = {CDSHookContext.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Hook-specific contextual data that the CDS service will need", formalDefinition="Hook-specific contextual data that the CDS service will need" )
    protected CDSHookContext context;

    /**
     * An object containing key/value pairs of FHIR queries that this Request is requesting the CDS Client to perform and provide on each Request call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query
     */
    @Child(name = "prefetch", type = {Base.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Key/value pairs of FHIR queries the CDS Client provides on each call", formalDefinition="An object containing key/value pairs of FHIR queries that this Request is requesting the CDS Client to perform and provide on each Request call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query" )
    protected List<CDSHooksRequestPrefetchComponent> prefetchList;

    private static final long serialVersionUID = 1427298453L;

  /**
   * Constructor
   */
    public CDSHooksRequest() {
      super();
    }

  /**
   * Constructor
   */
    public CDSHooksRequest(String hook, String hookInstance, CDSHookContext context) {
      super();
      this.setHook(hook);
      this.setHookInstance(hookInstance);
      this.setContext(context);
    }

    /**
     * @return {@link #hook} (The hook that triggered this CDS Service call). This is the underlying object with id, value and extensions. The accessor "getHook" gives direct access to the value
     */
    public CodeType getHookElement() { 
      if (this.hook == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHooksRequest.hook");
        else if (Configuration.doAutoCreate())
          this.hook = new CodeType(); // bb
      return this.hook;
    }

    public boolean hasHookElement() { 
      return this.hook != null && !this.hook.isEmpty();
    }

    public boolean hasHook() { 
      return this.hook != null && !this.hook.isEmpty();
    }

    /**
     * @param value {@link #hook} (The hook that triggered this CDS Service call). This is the underlying object with id, value and extensions. The accessor "getHook" gives direct access to the value
     */
    public CDSHooksRequest setHookElement(CodeType value) { 
      this.hook = value;
      return this;
    }

    /**
     * @return The hook that triggered this CDS Service call
     */
    public String getHook() { 
      return this.hook == null ? null : this.hook.getValue();
    }

    /**
     * @param value The hook that triggered this CDS Service call
     */
    public CDSHooksRequest setHook(String value) { 
        if (this.hook == null)
          this.hook = new CodeType();
        this.hook.setValue(value);
      return this;
    }

    /**
     * @return {@link #hookInstance} (While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation). This is the underlying object with id, value and extensions. The accessor "getHookInstance" gives direct access to the value
     */
    public UuidType getHookInstanceElement() { 
      if (this.hookInstance == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHooksRequest.hookInstance");
        else if (Configuration.doAutoCreate())
          this.hookInstance = new UuidType(); // bb
      return this.hookInstance;
    }

    public boolean hasHookInstanceElement() { 
      return this.hookInstance != null && !this.hookInstance.isEmpty();
    }

    public boolean hasHookInstance() { 
      return this.hookInstance != null && !this.hookInstance.isEmpty();
    }

    /**
     * @param value {@link #hookInstance} (While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation). This is the underlying object with id, value and extensions. The accessor "getHookInstance" gives direct access to the value
     */
    public CDSHooksRequest setHookInstanceElement(UuidType value) { 
      this.hookInstance = value;
      return this;
    }

    /**
     * @return While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation
     */
    public String getHookInstance() { 
      return this.hookInstance == null ? null : this.hookInstance.getValue();
    }

    /**
     * @param value While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation
     */
    public CDSHooksRequest setHookInstance(String value) { 
        if (this.hookInstance == null)
          this.hookInstance = new UuidType();
        this.hookInstance.setValue(value);
      return this;
    }

    /**
     * @return {@link #fhirServer} (The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged). This is the underlying object with id, value and extensions. The accessor "getFhirServer" gives direct access to the value
     */
    public UrlType getFhirServerElement() { 
      if (this.fhirServer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CDSHooksRequest.fhirServer");
        else if (Configuration.doAutoCreate())
          this.fhirServer = new UrlType(); // bb
      return this.fhirServer;
    }

    public boolean hasFhirServerElement() { 
      return this.fhirServer != null && !this.fhirServer.isEmpty();
    }

    public boolean hasFhirServer() { 
      return this.fhirServer != null && !this.fhirServer.isEmpty();
    }

    /**
     * @param value {@link #fhirServer} (The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged). This is the underlying object with id, value and extensions. The accessor "getFhirServer" gives direct access to the value
     */
    public CDSHooksRequest setFhirServerElement(UrlType value) { 
      this.fhirServer = value;
      return this;
    }

    /**
     * @return The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged
     */
    public String getFhirServer() { 
      return this.fhirServer == null ? null : this.fhirServer.getValue();
    }

    /**
     * @param value The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged
     */
    public CDSHooksRequest setFhirServer(String value) { 
      if (Utilities.noString(value))
        this.fhirServer = null;
      else {
        if (this.fhirServer == null)
          this.fhirServer = new UrlType();
        this.fhirServer.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #fhirAuthorization} (A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token)
     */
    public CDSHooksRequestFhirAuthorizationComponent getFhirAuthorization() { 
      return this.fhirAuthorization;
    }

    public boolean hasFhirAuthorization() { 
      return this.fhirAuthorization != null && !this.fhirAuthorization.isEmpty();
    }

    /**
     * @param value {@link #fhirAuthorization} (A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token)
     */
    public CDSHooksRequest setFhirAuthorization(CDSHooksRequestFhirAuthorizationComponent value) { 
      this.fhirAuthorization = value;
      return this;
    }

    /**
     * @return {@link #context} (Hook-specific contextual data that the CDS service will need)
     */
    public CDSHookContext getContext() { 
      return this.context;
    }

    public boolean hasContext() { 
      return this.context != null && !this.context.isEmpty();
    }

    /**
     * @param value {@link #context} (Hook-specific contextual data that the CDS service will need)
     */
    public CDSHooksRequest setContext(CDSHookContext value) { 
      this.context = value;
      return this;
    }

    /**
     * @return {@link #prefetch} (An object containing key/value pairs of FHIR queries that this Request is requesting the CDS Client to perform and provide on each Request call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query)
     */
    public List<CDSHooksRequestPrefetchComponent> getPrefetchList() { 
      if (this.prefetchList == null)
        this.prefetchList = new ArrayList<CDSHooksRequestPrefetchComponent>();
      return this.prefetchList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CDSHooksRequest setPrefetchList(List<CDSHooksRequestPrefetchComponent> thePrefetch) { 
      this.prefetchList = thePrefetch;
      return this;
    }

    public boolean hasPrefetch() { 
      if (this.prefetchList == null)
        return false;
      for (CDSHooksRequestPrefetchComponent item : this.prefetchList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CDSHooksRequest addPrefetch(CDSHooksRequestPrefetchComponent t) { //3b
      if (t == null)
        return this;
      if (this.prefetchList == null)
        this.prefetchList = new ArrayList<CDSHooksRequestPrefetchComponent>();
      this.prefetchList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("hook", "code", "The hook that triggered this CDS Service call", 0, 1, hook));
        children.add(new Property("hookInstance", "uuid", "While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation", 0, 1, hookInstance));
        children.add(new Property("fhirServer", "url", "The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged", 0, 1, fhirServer));
        children.add(new Property("fhirAuthorization", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token", 0, 1, fhirAuthorization));
        children.add(new Property("context", "http://hl7.org/fhir/tools/StructureDefinition/CDSHookContext", "Hook-specific contextual data that the CDS service will need", 0, 1, context));
        children.add(new Property("prefetch", "Base", "An object containing key/value pairs of FHIR queries that this Request is requesting the CDS Client to perform and provide on each Request call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query", 0, java.lang.Integer.MAX_VALUE, prefetchList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3208483: /*hook*/  return new Property("hook", "code", "The hook that triggered this CDS Service call", 0, 1, hook);
        case -1195894056: /*hookInstance*/  return new Property("hookInstance", "uuid", "While working in the CDS Client, a user can perform multiple actions in series or in parallel. For example, a clinician might prescribe two drugs in a row; each prescription action would be assigned a unique hookInstance. This allows a CDS Service to uniquely identify each hook invocation", 0, 1, hookInstance);
        case 1314459790: /*fhirServer*/  return new Property("fhirServer", "url", "The base URL of the CDS Client's FHIR server. If fhirAuthorization is provided, this field is REQUIRED. The scheme MUST be https when production data is exchanged", 0, 1, fhirServer);
        case 331089102: /*fhirAuthorization*/  return new Property("fhirAuthorization", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "A structure holding an OAuth 2.0 bearer access token granting the CDS Service access to FHIR resources, along with supplemental information relating to the token", 0, 1, fhirAuthorization);
        case 951530927: /*context*/  return new Property("context", "http://hl7.org/fhir/tools/StructureDefinition/CDSHookContext", "Hook-specific contextual data that the CDS service will need", 0, 1, context);
        case -1288666633: /*prefetch*/  return new Property("prefetch", "Base", "An object containing key/value pairs of FHIR queries that this Request is requesting the CDS Client to perform and provide on each Request call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query", 0, java.lang.Integer.MAX_VALUE, prefetchList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3208483: /*hook*/ return this.hook == null ? new Base[0] : new Base[] {this.hook}; // CodeType
        case -1195894056: /*hookInstance*/ return this.hookInstance == null ? new Base[0] : new Base[] {this.hookInstance}; // UuidType
        case 1314459790: /*fhirServer*/ return this.fhirServer == null ? new Base[0] : new Base[] {this.fhirServer}; // UrlType
        case 331089102: /*fhirAuthorization*/ return this.fhirAuthorization == null ? new Base[0] : new Base[] {this.fhirAuthorization}; // CDSHooksRequestFhirAuthorizationComponent
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // CDSHookContext
        case -1288666633: /*prefetch*/ return this.prefetchList == null ? new Base[0] : this.prefetchList.toArray(new Base[this.prefetchList.size()]); // CDSHooksRequestPrefetchComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3208483: // hook
          this.hook = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1195894056: // hookInstance
          this.hookInstance = TypeConvertor.castToUuid(value); // UuidType
          return value;
        case 1314459790: // fhirServer
          this.fhirServer = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 331089102: // fhirAuthorization
          this.fhirAuthorization = (CDSHooksRequestFhirAuthorizationComponent) value; // CDSHooksRequestFhirAuthorizationComponent
          return value;
        case 951530927: // context
          this.context = (CDSHookContext) value; // CDSHookContext
          return value;
        case -1288666633: // prefetch
          this.getPrefetchList().add((CDSHooksRequestPrefetchComponent) value); // CDSHooksRequestPrefetchComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("hook")) {
          this.hook = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("hookInstance")) {
          this.hookInstance = TypeConvertor.castToUuid(value); // UuidType
        } else if (name.equals("fhirServer")) {
          this.fhirServer = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("fhirAuthorization")) {
          this.fhirAuthorization = (CDSHooksRequestFhirAuthorizationComponent) value; // CDSHooksRequestFhirAuthorizationComponent
        } else if (name.equals("context")) {
          this.context = (CDSHookContext) value; // CDSHookContext
        } else if (name.equals("prefetch")) {
          this.getPrefetchList().add((CDSHooksRequestPrefetchComponent) value); // CDSHooksRequestPrefetchComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3208483:  return getHookElement();
        case -1195894056:  return getHookInstanceElement();
        case 1314459790:  return getFhirServerElement();
        case 331089102:  return getFhirAuthorization();
        case 951530927: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'context'");
        case -1288666633: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'prefetch'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3208483: /*hook*/ return new String[] {"code"};
        case -1195894056: /*hookInstance*/ return new String[] {"uuid"};
        case 1314459790: /*fhirServer*/ return new String[] {"url"};
        case 331089102: /*fhirAuthorization*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        case 951530927: /*context*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHookContext"};
        case -1288666633: /*prefetch*/ return new String[] {"Base"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("hook")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.hook");
        }
        else if (name.equals("hookInstance")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.hookInstance");
        }
        else if (name.equals("fhirServer")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksRequest.fhirServer");
        }
        else if (name.equals("fhirAuthorization")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksRequest.fhirAuthorization");
        }
        else if (name.equals("context")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksRequest.context");
        }
        else if (name.equals("prefetch")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksRequest.prefetch");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CDSHooksRequest";

  }

      public CDSHooksRequest copy() {
        CDSHooksRequest dst = new CDSHooksRequest();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksRequest dst) {
        super.copyValues(dst);
        dst.hook = hook == null ? null : hook.copy();
        dst.hookInstance = hookInstance == null ? null : hookInstance.copy();
        dst.fhirServer = fhirServer == null ? null : fhirServer.copy();
        dst.fhirAuthorization = fhirAuthorization == null ? null : fhirAuthorization.copy();
        dst.context = context == null ? null : context.copy();
        if (prefetchList != null) {
          dst.prefetchList = new ArrayList<CDSHooksRequestPrefetchComponent>();
          for (CDSHooksRequestPrefetchComponent i : prefetchList)
            dst.prefetchList.add(i.copy());
        };
      }

      protected CDSHooksRequest typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksRequest))
          return false;
        CDSHooksRequest o = (CDSHooksRequest) other_;
        return compareDeep(hook, o.hook, true) && compareDeep(hookInstance, o.hookInstance, true) && compareDeep(fhirServer, o.fhirServer, true)
           && compareDeep(fhirAuthorization, o.fhirAuthorization, true) && compareDeep(context, o.context, true)
           && compareDeep(prefetchList, o.prefetchList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksRequest))
          return false;
        CDSHooksRequest o = (CDSHooksRequest) other_;
        return compareValues(hook, o.hook, true) && compareValues(hookInstance, o.hookInstance, true) && compareValues(fhirServer, o.fhirServer, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(hook, hookInstance, fhirServer
          , fhirAuthorization, context, prefetchList);
      }


}

