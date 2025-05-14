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
 * This structure is defined to allow the FHIR Validator to validate a CDSHooks Services response body. TODO: This content will be moved to the CDS Hooks specification in the future
 */
@DatatypeDef(name="CDSHooksServices")
public class CDSHooksServices extends CDSHooksElement implements ICompositeType {

    @Block()
    public static class CDSHooksServicesServicesComponent extends CDSHooksElement {
        /**
         * The hook this Services should be invoked on
         */
        @Child(name = "hook", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The hook this Services should be invoked on", formalDefinition="The hook this Services should be invoked on" )
        protected StringType hook;

        /**
         * The human-friendly name of this Services (Recommended)
         */
        @Child(name = "title", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The human-friendly name of this Services (Recommended)", formalDefinition="The human-friendly name of this Services (Recommended)" )
        protected StringType title;

        /**
         * The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```
         */
        @Child(name = "id", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The URL to this service which is available at: {baseUrl}/cds-services/{id}", formalDefinition="The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```" )
        protected CodeType id;

        /**
         * The description of this Services
         */
        @Child(name = "description", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The description of this Services", formalDefinition="The description of this Services" )
        protected StringType description;

        /**
         * Human-friendly description of any preconditions for the use of this CDS Services
         */
        @Child(name = "usageRequirements", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-friendly description of any preconditions for the use of this CDS Services", formalDefinition="Human-friendly description of any preconditions for the use of this CDS Services" )
        protected StringType usageRequirements;

        /**
         * An object containing key/value pairs of FHIR queries that this Services is requesting the CDS Client to perform and provide on each Services call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query
         */
        @Child(name = "prefetch", type = {Base.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Key/value pairs of FHIR queries the CDS Client provides on each call", formalDefinition="An object containing key/value pairs of FHIR queries that this Services is requesting the CDS Client to perform and provide on each Services call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query" )
        protected List<CDSHooksServicesServicesPrefetchComponent> prefetchList;

        private static final long serialVersionUID = 1303422447L;

    /**
     * Constructor
     */
      public CDSHooksServicesServicesComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksServicesServicesComponent(String hook, String id, String description) {
        super();
        this.setHook(hook);
        this.setId(id);
        this.setDescription(description);
      }

        /**
         * @return {@link #hook} (The hook this Services should be invoked on). This is the underlying object with id, value and extensions. The accessor "getHook" gives direct access to the value
         */
        public StringType getHookElement() { 
          if (this.hook == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesComponent.hook");
            else if (Configuration.doAutoCreate())
              this.hook = new StringType(); // bb
          return this.hook;
        }

        public boolean hasHookElement() { 
          return this.hook != null && !this.hook.isEmpty();
        }

        public boolean hasHook() { 
          return this.hook != null && !this.hook.isEmpty();
        }

        /**
         * @param value {@link #hook} (The hook this Services should be invoked on). This is the underlying object with id, value and extensions. The accessor "getHook" gives direct access to the value
         */
        public CDSHooksServicesServicesComponent setHookElement(StringType value) { 
          this.hook = value;
          return this;
        }

        /**
         * @return The hook this Services should be invoked on
         */
        public String getHook() { 
          return this.hook == null ? null : this.hook.getValue();
        }

        /**
         * @param value The hook this Services should be invoked on
         */
        public CDSHooksServicesServicesComponent setHook(String value) { 
            if (this.hook == null)
              this.hook = new StringType();
            this.hook.setValue(value);
          return this;
        }

        /**
         * @return {@link #title} (The human-friendly name of this Services (Recommended)). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesComponent.title");
            else if (Configuration.doAutoCreate())
              this.title = new StringType(); // bb
          return this.title;
        }

        public boolean hasTitleElement() { 
          return this.title != null && !this.title.isEmpty();
        }

        public boolean hasTitle() { 
          return this.title != null && !this.title.isEmpty();
        }

        /**
         * @param value {@link #title} (The human-friendly name of this Services (Recommended)). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public CDSHooksServicesServicesComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The human-friendly name of this Services (Recommended)
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The human-friendly name of this Services (Recommended)
         */
        public CDSHooksServicesServicesComponent setTitle(String value) { 
          if (Utilities.noString(value))
            this.title = null;
          else {
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #id} (The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
         */
        public CodeType getIdElement() { 
          if (this.id == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesComponent.id");
            else if (Configuration.doAutoCreate())
              this.id = new CodeType(); // bb
          return this.id;
        }

        public boolean hasIdElement() { 
          return this.id != null && !this.id.isEmpty();
        }

        public boolean hasId() { 
          return this.id != null && !this.id.isEmpty();
        }

        /**
         * @param value {@link #id} (The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
         */
        public CDSHooksServicesServicesComponent setIdElement(CodeType value) { 
          this.id = value;
          return this;
        }

        /**
         * @return The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```
         */
        public String getId() { 
          return this.id == null ? null : this.id.getValue();
        }

        /**
         * @param value The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```
         */
        public CDSHooksServicesServicesComponent setId(String value) { 
            if (this.id == null)
              this.id = new CodeType();
            this.id.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (The description of this Services). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesComponent.description");
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
         * @param value {@link #description} (The description of this Services). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public CDSHooksServicesServicesComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The description of this Services
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The description of this Services
         */
        public CDSHooksServicesServicesComponent setDescription(String value) { 
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          return this;
        }

        /**
         * @return {@link #usageRequirements} (Human-friendly description of any preconditions for the use of this CDS Services). This is the underlying object with id, value and extensions. The accessor "getUsageRequirements" gives direct access to the value
         */
        public StringType getUsageRequirementsElement() { 
          if (this.usageRequirements == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesComponent.usageRequirements");
            else if (Configuration.doAutoCreate())
              this.usageRequirements = new StringType(); // bb
          return this.usageRequirements;
        }

        public boolean hasUsageRequirementsElement() { 
          return this.usageRequirements != null && !this.usageRequirements.isEmpty();
        }

        public boolean hasUsageRequirements() { 
          return this.usageRequirements != null && !this.usageRequirements.isEmpty();
        }

        /**
         * @param value {@link #usageRequirements} (Human-friendly description of any preconditions for the use of this CDS Services). This is the underlying object with id, value and extensions. The accessor "getUsageRequirements" gives direct access to the value
         */
        public CDSHooksServicesServicesComponent setUsageRequirementsElement(StringType value) { 
          this.usageRequirements = value;
          return this;
        }

        /**
         * @return Human-friendly description of any preconditions for the use of this CDS Services
         */
        public String getUsageRequirements() { 
          return this.usageRequirements == null ? null : this.usageRequirements.getValue();
        }

        /**
         * @param value Human-friendly description of any preconditions for the use of this CDS Services
         */
        public CDSHooksServicesServicesComponent setUsageRequirements(String value) { 
          if (Utilities.noString(value))
            this.usageRequirements = null;
          else {
            if (this.usageRequirements == null)
              this.usageRequirements = new StringType();
            this.usageRequirements.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #prefetch} (An object containing key/value pairs of FHIR queries that this Services is requesting the CDS Client to perform and provide on each Services call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query)
         */
        public List<CDSHooksServicesServicesPrefetchComponent> getPrefetchList() { 
          if (this.prefetchList == null)
            this.prefetchList = new ArrayList<CDSHooksServicesServicesPrefetchComponent>();
          return this.prefetchList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CDSHooksServicesServicesComponent setPrefetchList(List<CDSHooksServicesServicesPrefetchComponent> thePrefetch) { 
          this.prefetchList = thePrefetch;
          return this;
        }

        public boolean hasPrefetch() { 
          if (this.prefetchList == null)
            return false;
          for (CDSHooksServicesServicesPrefetchComponent item : this.prefetchList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CDSHooksServicesServicesComponent addPrefetch(CDSHooksServicesServicesPrefetchComponent t) { //3b
          if (t == null)
            return this;
          if (this.prefetchList == null)
            this.prefetchList = new ArrayList<CDSHooksServicesServicesPrefetchComponent>();
          this.prefetchList.add(t);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("hook", "string", "The hook this Services should be invoked on", 0, 1, hook));
          children.add(new Property("title", "string", "The human-friendly name of this Services (Recommended)", 0, 1, title));
          children.add(new Property("id", "code", "The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```", 0, 1, id));
          children.add(new Property("description", "string", "The description of this Services", 0, 1, description));
          children.add(new Property("usageRequirements", "string", "Human-friendly description of any preconditions for the use of this CDS Services", 0, 1, usageRequirements));
          children.add(new Property("prefetch", "Base", "An object containing key/value pairs of FHIR queries that this Services is requesting the CDS Client to perform and provide on each Services call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query", 0, java.lang.Integer.MAX_VALUE, prefetchList));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3208483: /*hook*/  return new Property("hook", "string", "The hook this Services should be invoked on", 0, 1, hook);
          case 110371416: /*title*/  return new Property("title", "string", "The human-friendly name of this Services (Recommended)", 0, 1, title);
          case 3355: /*id*/  return new Property("id", "code", "The {id} portion of the URL to this service which is available at ```{baseUrl}/cds-services/{id}```", 0, 1, id);
          case -1724546052: /*description*/  return new Property("description", "string", "The description of this Services", 0, 1, description);
          case -512224047: /*usageRequirements*/  return new Property("usageRequirements", "string", "Human-friendly description of any preconditions for the use of this CDS Services", 0, 1, usageRequirements);
          case -1288666633: /*prefetch*/  return new Property("prefetch", "Base", "An object containing key/value pairs of FHIR queries that this Services is requesting the CDS Client to perform and provide on each Services call. The key is a string that describes the type of data being requested and the value is a string representing the FHIR query", 0, java.lang.Integer.MAX_VALUE, prefetchList);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3208483: /*hook*/ return this.hook == null ? new Base[0] : new Base[] {this.hook}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 3355: /*id*/ return this.id == null ? new Base[0] : new Base[] {this.id}; // CodeType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -512224047: /*usageRequirements*/ return this.usageRequirements == null ? new Base[0] : new Base[] {this.usageRequirements}; // StringType
        case -1288666633: /*prefetch*/ return this.prefetchList == null ? new Base[0] : this.prefetchList.toArray(new Base[this.prefetchList.size()]); // CDSHooksServicesServicesPrefetchComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3208483: // hook
          this.hook = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 3355: // id
          this.id = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -512224047: // usageRequirements
          this.usageRequirements = TypeConvertor.castToString(value); // StringType
          return value;
        case -1288666633: // prefetch
          this.getPrefetchList().add((CDSHooksServicesServicesPrefetchComponent) value); // CDSHooksServicesServicesPrefetchComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("hook")) {
          this.hook = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("id")) {
          this.id = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("usageRequirements")) {
          this.usageRequirements = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("prefetch")) {
          this.getPrefetchList().add((CDSHooksServicesServicesPrefetchComponent) value); // CDSHooksServicesServicesPrefetchComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3208483:  return getHookElement();
        case 110371416:  return getTitleElement();
        case 3355:  return getIdElement();
        case -1724546052:  return getDescriptionElement();
        case -512224047:  return getUsageRequirementsElement();
        case -1288666633: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'prefetch'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3208483: /*hook*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case 3355: /*id*/ return new String[] {"code"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -512224047: /*usageRequirements*/ return new String[] {"string"};
        case -1288666633: /*prefetch*/ return new String[] {"Base"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("hook")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.hook");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.title");
        }
        else if (name.equals("id")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.id");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.description");
        }
        else if (name.equals("usageRequirements")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.usageRequirements");
        }
        else if (name.equals("prefetch")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksServices.services.prefetch");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksServicesServicesComponent copy() {
        CDSHooksServicesServicesComponent dst = new CDSHooksServicesServicesComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksServicesServicesComponent dst) {
        super.copyValues(dst);
        dst.hook = hook == null ? null : hook.copy();
        dst.title = title == null ? null : title.copy();
        dst.id = id == null ? null : id.copy();
        dst.description = description == null ? null : description.copy();
        dst.usageRequirements = usageRequirements == null ? null : usageRequirements.copy();
        if (prefetchList != null) {
          dst.prefetchList = new ArrayList<CDSHooksServicesServicesPrefetchComponent>();
          for (CDSHooksServicesServicesPrefetchComponent i : prefetchList)
            dst.prefetchList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksServicesServicesComponent))
          return false;
        CDSHooksServicesServicesComponent o = (CDSHooksServicesServicesComponent) other_;
        return compareDeep(hook, o.hook, true) && compareDeep(title, o.title, true) && compareDeep(id, o.id, true)
           && compareDeep(description, o.description, true) && compareDeep(usageRequirements, o.usageRequirements, true)
           && compareDeep(prefetchList, o.prefetchList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksServicesServicesComponent))
          return false;
        CDSHooksServicesServicesComponent o = (CDSHooksServicesServicesComponent) other_;
        return compareValues(hook, o.hook, true) && compareValues(title, o.title, true) && compareValues(id, o.id, true)
           && compareValues(description, o.description, true) && compareValues(usageRequirements, o.usageRequirements, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(hook, title, id, description
          , usageRequirements, prefetchList);
      }

  public String fhirType() {
    return "CDSHooksServices.services";

  }

  }

    @Block()
    public static class CDSHooksServicesServicesPrefetchComponent extends LogicalBase {
        /**
         * Key of FHIR query - name for client to use when sending to Services
         */
        @Child(name = "key", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Key of FHIR query - name for client to use when sending to Services", formalDefinition="Key of FHIR query - name for client to use when sending to Services" )
        protected CodeType key;

        /**
         * Value of FHIR query - FHIR Query for client to perform
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of FHIR query - FHIR Query for client to perform", formalDefinition="Value of FHIR query - FHIR Query for client to perform" )
        protected StringType value;

        private static final long serialVersionUID = -1496585526L;

    /**
     * Constructor
     */
      public CDSHooksServicesServicesPrefetchComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksServicesServicesPrefetchComponent(String key, String value) {
        super();
        this.setKey(key);
        this.setValue(value);
      }

        /**
         * @return {@link #key} (Key of FHIR query - name for client to use when sending to Services). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public CodeType getKeyElement() { 
          if (this.key == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesPrefetchComponent.key");
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
         * @param value {@link #key} (Key of FHIR query - name for client to use when sending to Services). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public CDSHooksServicesServicesPrefetchComponent setKeyElement(CodeType value) { 
          this.key = value;
          return this;
        }

        /**
         * @return Key of FHIR query - name for client to use when sending to Services
         */
        public String getKey() { 
          return this.key == null ? null : this.key.getValue();
        }

        /**
         * @param value Key of FHIR query - name for client to use when sending to Services
         */
        public CDSHooksServicesServicesPrefetchComponent setKey(String value) { 
            if (this.key == null)
              this.key = new CodeType();
            this.key.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (Value of FHIR query - FHIR Query for client to perform). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksServicesServicesPrefetchComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Value of FHIR query - FHIR Query for client to perform). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CDSHooksServicesServicesPrefetchComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return Value of FHIR query - FHIR Query for client to perform
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value Value of FHIR query - FHIR Query for client to perform
         */
        public CDSHooksServicesServicesPrefetchComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("key", "code", "Key of FHIR query - name for client to use when sending to Services", 0, 1, key));
          children.add(new Property("value", "string", "Value of FHIR query - FHIR Query for client to perform", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106079: /*key*/  return new Property("key", "code", "Key of FHIR query - name for client to use when sending to Services", 0, 1, key);
          case 111972721: /*value*/  return new Property("value", "string", "Value of FHIR query - FHIR Query for client to perform", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // CodeType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
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
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("key")) {
          this.key = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079:  return getKeyElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"code"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.prefetch.key");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksServices.services.prefetch.value");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksServicesServicesPrefetchComponent copy() {
        CDSHooksServicesServicesPrefetchComponent dst = new CDSHooksServicesServicesPrefetchComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksServicesServicesPrefetchComponent dst) {
        super.copyValues(dst);
        dst.key = key == null ? null : key.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksServicesServicesPrefetchComponent))
          return false;
        CDSHooksServicesServicesPrefetchComponent o = (CDSHooksServicesServicesPrefetchComponent) other_;
        return compareDeep(key, o.key, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksServicesServicesPrefetchComponent))
          return false;
        CDSHooksServicesServicesPrefetchComponent o = (CDSHooksServicesServicesPrefetchComponent) other_;
        return compareValues(key, o.key, true) && compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, value);
      }

  public String fhirType() {
    return "CDSHooksServices.services.prefetch";

  }

  }

    /**
     * A list of CDS services
     */
    @Child(name = "services", type = {CDSHooksElement.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A list of CDS services", formalDefinition="A list of CDS services" )
    protected List<CDSHooksServicesServicesComponent> servicesList;

    private static final long serialVersionUID = 721056483L;

  /**
   * Constructor
   */
    public CDSHooksServices() {
      super();
    }

    /**
     * @return {@link #services} (A list of CDS services)
     */
    public List<CDSHooksServicesServicesComponent> getServicesList() { 
      if (this.servicesList == null)
        this.servicesList = new ArrayList<CDSHooksServicesServicesComponent>();
      return this.servicesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CDSHooksServices setServicesList(List<CDSHooksServicesServicesComponent> theServices) { 
      this.servicesList = theServices;
      return this;
    }

    public boolean hasServices() { 
      if (this.servicesList == null)
        return false;
      for (CDSHooksServicesServicesComponent item : this.servicesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CDSHooksServicesServicesComponent addServices() { //3a
      CDSHooksServicesServicesComponent t = new CDSHooksServicesServicesComponent();
      if (this.servicesList == null)
        this.servicesList = new ArrayList<CDSHooksServicesServicesComponent>();
      this.servicesList.add(t);
      return t;
    }

    public CDSHooksServices addServices(CDSHooksServicesServicesComponent t) { //3b
      if (t == null)
        return this;
      if (this.servicesList == null)
        this.servicesList = new ArrayList<CDSHooksServicesServicesComponent>();
      this.servicesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #services}, creating it if it does not already exist {3}
     */
    public CDSHooksServicesServicesComponent getServicesFirstRep() { 
      if (getServicesList().isEmpty()) {
        addServices();
      }
      return getServicesList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("services", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "A list of CDS services", 0, java.lang.Integer.MAX_VALUE, servicesList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1379209310: /*services*/  return new Property("services", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "A list of CDS services", 0, java.lang.Integer.MAX_VALUE, servicesList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1379209310: /*services*/ return this.servicesList == null ? new Base[0] : this.servicesList.toArray(new Base[this.servicesList.size()]); // CDSHooksServicesServicesComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1379209310: // services
          this.getServicesList().add((CDSHooksServicesServicesComponent) value); // CDSHooksServicesServicesComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("services")) {
          this.getServicesList().add((CDSHooksServicesServicesComponent) value); // CDSHooksServicesServicesComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1379209310:  return addServices(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1379209310: /*services*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("services")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksServices.services");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CDSHooksServices";

  }

      public CDSHooksServices copy() {
        CDSHooksServices dst = new CDSHooksServices();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksServices dst) {
        super.copyValues(dst);
        if (servicesList != null) {
          dst.servicesList = new ArrayList<CDSHooksServicesServicesComponent>();
          for (CDSHooksServicesServicesComponent i : servicesList)
            dst.servicesList.add(i.copy());
        };
      }

      protected CDSHooksServices typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksServices))
          return false;
        CDSHooksServices o = (CDSHooksServices) other_;
        return compareDeep(servicesList, o.servicesList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksServices))
          return false;
        CDSHooksServices o = (CDSHooksServices) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(servicesList);
      }


}

