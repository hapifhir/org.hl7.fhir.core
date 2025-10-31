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
 * Defines the descriptive meta-data of a resource.
 */
@DatatypeDef(name="RESOURCE_DESCRIPTION")
public class RESOURCE_DESCRIPTION extends LogicalBase implements ICompositeType {

    /**
     * Original author of this resource, with all relevant details, including organisation.
     */
    @Child(name = "original_author", type = {StringType.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Original author of this resource, with all relevant details, including organisation", formalDefinition="Original author of this resource, with all relevant details, including organisation." )
    protected List<StringType> original_authorList;

    /**
     * Other contributors to the resource, probably listed in 'name <email>' form.
     */
    @Child(name = "other_contributors", type = {StringType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Other contributors to the resource, probably listed in 'name <email>' form", formalDefinition="Other contributors to the resource, probably listed in 'name <email>' form." )
    protected List<StringType> other_contributorsList;

    /**
     * Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.
     */
    @Child(name = "lifecycle_state", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="E.g. initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete", formalDefinition="Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete." )
    protected StringType lifecycle_state;

    /**
     * URI of package to which this resource belongs..
     */
    @Child(name = "resource_package_uri", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="URI of package to which this resource belongs", formalDefinition="URI of package to which this resource belongs.." )
    protected StringType resource_package_uri;

    /**
     * Additional non language-senstive resource meta-data, as a list of name/value pairs.
     */
    @Child(name = "other_details", type = {OBJECT_REF.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional non language-senstive resource meta-data, as a list of name/value pairs", formalDefinition="Additional non language-senstive resource meta-data, as a list of name/value pairs." )
    protected List<OBJECT_REF> other_detailsList;

    /**
     * Reference to owning resource.
     */
    @Child(name = "parent_resource", type = {AUTHORED_RESOURCE.class}, order=5, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to owning resource", formalDefinition="Reference to owning resource." )
    protected AUTHORED_RESOURCE parent_resource;

    /**
     * Details of all parts of resource description that are natural language-dependent, keyed by language code.
     */
    @Child(name = "details", type = {RESOURCE_DESCRIPTION_ITEM.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details of all parts of resource description that are natural language-dependent, keyed by language code", formalDefinition="Details of all parts of resource description that are natural language-dependent, keyed by language code." )
    protected List<RESOURCE_DESCRIPTION_ITEM> detailsList;

    private static final long serialVersionUID = 1426214531L;

  /**
   * Constructor
   */
    public RESOURCE_DESCRIPTION() {
      super();
    }

  /**
   * Constructor
   */
    public RESOURCE_DESCRIPTION(String lifecycle_state, AUTHORED_RESOURCE parent_resource) {
      super();
      this.setLifecycle_state(lifecycle_state);
      this.setParent_resource(parent_resource);
    }

    /**
     * @return {@link #original_author} (Original author of this resource, with all relevant details, including organisation.)
     */
    public List<StringType> getOriginal_authorList() { 
      if (this.original_authorList == null)
        this.original_authorList = new ArrayList<StringType>();
      return this.original_authorList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION setOriginal_authorList(List<StringType> theOriginal_author) { 
      this.original_authorList = theOriginal_author;
      return this;
    }

    public boolean hasOriginal_author() { 
      if (this.original_authorList == null)
        return false;
      for (StringType item : this.original_authorList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #original_author} (Original author of this resource, with all relevant details, including organisation.)
     */
    public StringType addOriginal_authorElement() {//2 
      StringType t = new StringType();
      if (this.original_authorList == null)
        this.original_authorList = new ArrayList<StringType>();
      this.original_authorList.add(t);
      return t;
    }

    /**
     * @param value {@link #original_author} (Original author of this resource, with all relevant details, including organisation.)
     */
    public RESOURCE_DESCRIPTION addOriginal_author(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.original_authorList == null)
        this.original_authorList = new ArrayList<StringType>();
      this.original_authorList.add(t);
      return this;
    }

    /**
     * @param value {@link #original_author} (Original author of this resource, with all relevant details, including organisation.)
     */
    public boolean hasOriginal_author(String value) { 
      if (this.original_authorList == null)
        return false;
      for (StringType v : this.original_authorList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #other_contributors} (Other contributors to the resource, probably listed in 'name <email>' form.)
     */
    public List<StringType> getOther_contributorsList() { 
      if (this.other_contributorsList == null)
        this.other_contributorsList = new ArrayList<StringType>();
      return this.other_contributorsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION setOther_contributorsList(List<StringType> theOther_contributors) { 
      this.other_contributorsList = theOther_contributors;
      return this;
    }

    public boolean hasOther_contributors() { 
      if (this.other_contributorsList == null)
        return false;
      for (StringType item : this.other_contributorsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #other_contributors} (Other contributors to the resource, probably listed in 'name <email>' form.)
     */
    public StringType addOther_contributorsElement() {//2 
      StringType t = new StringType();
      if (this.other_contributorsList == null)
        this.other_contributorsList = new ArrayList<StringType>();
      this.other_contributorsList.add(t);
      return t;
    }

    /**
     * @param value {@link #other_contributors} (Other contributors to the resource, probably listed in 'name <email>' form.)
     */
    public RESOURCE_DESCRIPTION addOther_contributors(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.other_contributorsList == null)
        this.other_contributorsList = new ArrayList<StringType>();
      this.other_contributorsList.add(t);
      return this;
    }

    /**
     * @param value {@link #other_contributors} (Other contributors to the resource, probably listed in 'name <email>' form.)
     */
    public boolean hasOther_contributors(String value) { 
      if (this.other_contributorsList == null)
        return false;
      for (StringType v : this.other_contributorsList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #lifecycle_state} (Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.). This is the underlying object with id, value and extensions. The accessor "getLifecycle_state" gives direct access to the value
     */
    public StringType getLifecycle_stateElement() { 
      if (this.lifecycle_state == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION.lifecycle_state");
        else if (Configuration.doAutoCreate())
          this.lifecycle_state = new StringType(); // bb
      return this.lifecycle_state;
    }

    public boolean hasLifecycle_stateElement() { 
      return this.lifecycle_state != null && !this.lifecycle_state.isEmpty();
    }

    public boolean hasLifecycle_state() { 
      return this.lifecycle_state != null && !this.lifecycle_state.isEmpty();
    }

    /**
     * @param value {@link #lifecycle_state} (Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.). This is the underlying object with id, value and extensions. The accessor "getLifecycle_state" gives direct access to the value
     */
    public RESOURCE_DESCRIPTION setLifecycle_stateElement(StringType value) { 
      this.lifecycle_state = value;
      return this;
    }

    /**
     * @return Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.
     */
    public String getLifecycle_state() { 
      return this.lifecycle_state == null ? null : this.lifecycle_state.getValue();
    }

    /**
     * @param value Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.
     */
    public RESOURCE_DESCRIPTION setLifecycle_state(String value) { 
        if (this.lifecycle_state == null)
          this.lifecycle_state = new StringType();
        this.lifecycle_state.setValue(value);
      return this;
    }

    /**
     * @return {@link #resource_package_uri} (URI of package to which this resource belongs..). This is the underlying object with id, value and extensions. The accessor "getResource_package_uri" gives direct access to the value
     */
    public StringType getResource_package_uriElement() { 
      if (this.resource_package_uri == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION.resource_package_uri");
        else if (Configuration.doAutoCreate())
          this.resource_package_uri = new StringType(); // bb
      return this.resource_package_uri;
    }

    public boolean hasResource_package_uriElement() { 
      return this.resource_package_uri != null && !this.resource_package_uri.isEmpty();
    }

    public boolean hasResource_package_uri() { 
      return this.resource_package_uri != null && !this.resource_package_uri.isEmpty();
    }

    /**
     * @param value {@link #resource_package_uri} (URI of package to which this resource belongs..). This is the underlying object with id, value and extensions. The accessor "getResource_package_uri" gives direct access to the value
     */
    public RESOURCE_DESCRIPTION setResource_package_uriElement(StringType value) { 
      this.resource_package_uri = value;
      return this;
    }

    /**
     * @return URI of package to which this resource belongs..
     */
    public String getResource_package_uri() { 
      return this.resource_package_uri == null ? null : this.resource_package_uri.getValue();
    }

    /**
     * @param value URI of package to which this resource belongs..
     */
    public RESOURCE_DESCRIPTION setResource_package_uri(String value) { 
      if (Utilities.noString(value))
        this.resource_package_uri = null;
      else {
        if (this.resource_package_uri == null)
          this.resource_package_uri = new StringType();
        this.resource_package_uri.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #other_details} (Additional non language-senstive resource meta-data, as a list of name/value pairs.)
     */
    public List<OBJECT_REF> getOther_detailsList() { 
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<OBJECT_REF>();
      return this.other_detailsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION setOther_detailsList(List<OBJECT_REF> theOther_details) { 
      this.other_detailsList = theOther_details;
      return this;
    }

    public boolean hasOther_details() { 
      if (this.other_detailsList == null)
        return false;
      for (OBJECT_REF item : this.other_detailsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OBJECT_REF addOther_details() { //3a
      OBJECT_REF t = new OBJECT_REF();
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<OBJECT_REF>();
      this.other_detailsList.add(t);
      return t;
    }

    public RESOURCE_DESCRIPTION addOther_details(OBJECT_REF t) { //3b
      if (t == null)
        return this;
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<OBJECT_REF>();
      this.other_detailsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #other_details}, creating it if it does not already exist {3}
     */
    public OBJECT_REF getOther_detailsFirstRep() { 
      if (getOther_detailsList().isEmpty()) {
        addOther_details();
      }
      return getOther_detailsList().get(0);
    }

    /**
     * @return {@link #parent_resource} (Reference to owning resource.)
     */
    public AUTHORED_RESOURCE getParent_resource() { 
      return this.parent_resource;
    }

    public boolean hasParent_resource() { 
      return this.parent_resource != null && !this.parent_resource.isEmpty();
    }

    /**
     * @param value {@link #parent_resource} (Reference to owning resource.)
     */
    public RESOURCE_DESCRIPTION setParent_resource(AUTHORED_RESOURCE value) { 
      this.parent_resource = value;
      return this;
    }

    /**
     * @return {@link #details} (Details of all parts of resource description that are natural language-dependent, keyed by language code.)
     */
    public List<RESOURCE_DESCRIPTION_ITEM> getDetailsList() { 
      if (this.detailsList == null)
        this.detailsList = new ArrayList<RESOURCE_DESCRIPTION_ITEM>();
      return this.detailsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION setDetailsList(List<RESOURCE_DESCRIPTION_ITEM> theDetails) { 
      this.detailsList = theDetails;
      return this;
    }

    public boolean hasDetails() { 
      if (this.detailsList == null)
        return false;
      for (RESOURCE_DESCRIPTION_ITEM item : this.detailsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RESOURCE_DESCRIPTION_ITEM addDetails() { //3a
      RESOURCE_DESCRIPTION_ITEM t = new RESOURCE_DESCRIPTION_ITEM();
      if (this.detailsList == null)
        this.detailsList = new ArrayList<RESOURCE_DESCRIPTION_ITEM>();
      this.detailsList.add(t);
      return t;
    }

    public RESOURCE_DESCRIPTION addDetails(RESOURCE_DESCRIPTION_ITEM t) { //3b
      if (t == null)
        return this;
      if (this.detailsList == null)
        this.detailsList = new ArrayList<RESOURCE_DESCRIPTION_ITEM>();
      this.detailsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #details}, creating it if it does not already exist {3}
     */
    public RESOURCE_DESCRIPTION_ITEM getDetailsFirstRep() { 
      if (getDetailsList().isEmpty()) {
        addDetails();
      }
      return getDetailsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("original_author", "string", "Original author of this resource, with all relevant details, including organisation.", 0, java.lang.Integer.MAX_VALUE, original_authorList));
        children.add(new Property("other_contributors", "string", "Other contributors to the resource, probably listed in 'name <email>' form.", 0, java.lang.Integer.MAX_VALUE, other_contributorsList));
        children.add(new Property("lifecycle_state", "string", "Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.", 0, 1, lifecycle_state));
        children.add(new Property("resource_package_uri", "string", "URI of package to which this resource belongs..", 0, 1, resource_package_uri));
        children.add(new Property("other_details", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Additional non language-senstive resource meta-data, as a list of name/value pairs.", 0, java.lang.Integer.MAX_VALUE, other_detailsList));
        children.add(new Property("parent_resource", "http://openehr.org/fhir/StructureDefinition/AUTHORED-RESOURCE", "Reference to owning resource.", 0, 1, parent_resource));
        children.add(new Property("details", "http://openehr.org/fhir/StructureDefinition/RESOURCE-DESCRIPTION-ITEM", "Details of all parts of resource description that are natural language-dependent, keyed by language code.", 0, java.lang.Integer.MAX_VALUE, detailsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -821815367: /*original_author*/  return new Property("original_author", "string", "Original author of this resource, with all relevant details, including organisation.", 0, java.lang.Integer.MAX_VALUE, original_authorList);
        case 1215537095: /*other_contributors*/  return new Property("other_contributors", "string", "Other contributors to the resource, probably listed in 'name <email>' form.", 0, java.lang.Integer.MAX_VALUE, other_contributorsList);
        case 1508726652: /*lifecycle_state*/  return new Property("lifecycle_state", "string", "Lifecycle state of the resource, typically including states such as: initial | submitted | experimental | awaiting_approval | approved | superseded | obsolete.", 0, 1, lifecycle_state);
        case 812585794: /*resource_package_uri*/  return new Property("resource_package_uri", "string", "URI of package to which this resource belongs..", 0, 1, resource_package_uri);
        case -1257043949: /*other_details*/  return new Property("other_details", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Additional non language-senstive resource meta-data, as a list of name/value pairs.", 0, java.lang.Integer.MAX_VALUE, other_detailsList);
        case -1055650813: /*parent_resource*/  return new Property("parent_resource", "http://openehr.org/fhir/StructureDefinition/AUTHORED-RESOURCE", "Reference to owning resource.", 0, 1, parent_resource);
        case 1557721666: /*details*/  return new Property("details", "http://openehr.org/fhir/StructureDefinition/RESOURCE-DESCRIPTION-ITEM", "Details of all parts of resource description that are natural language-dependent, keyed by language code.", 0, java.lang.Integer.MAX_VALUE, detailsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -821815367: /*original_author*/ return this.original_authorList == null ? new Base[0] : this.original_authorList.toArray(new Base[this.original_authorList.size()]); // StringType
        case 1215537095: /*other_contributors*/ return this.other_contributorsList == null ? new Base[0] : this.other_contributorsList.toArray(new Base[this.other_contributorsList.size()]); // StringType
        case 1508726652: /*lifecycle_state*/ return this.lifecycle_state == null ? new Base[0] : new Base[] {this.lifecycle_state}; // StringType
        case 812585794: /*resource_package_uri*/ return this.resource_package_uri == null ? new Base[0] : new Base[] {this.resource_package_uri}; // StringType
        case -1257043949: /*other_details*/ return this.other_detailsList == null ? new Base[0] : this.other_detailsList.toArray(new Base[this.other_detailsList.size()]); // OBJECT_REF
        case -1055650813: /*parent_resource*/ return this.parent_resource == null ? new Base[0] : new Base[] {this.parent_resource}; // AUTHORED_RESOURCE
        case 1557721666: /*details*/ return this.detailsList == null ? new Base[0] : this.detailsList.toArray(new Base[this.detailsList.size()]); // RESOURCE_DESCRIPTION_ITEM
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -821815367: // original_author
          this.getOriginal_authorList().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 1215537095: // other_contributors
          this.getOther_contributorsList().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 1508726652: // lifecycle_state
          this.lifecycle_state = TypeConvertor.castToString(value); // StringType
          return value;
        case 812585794: // resource_package_uri
          this.resource_package_uri = TypeConvertor.castToString(value); // StringType
          return value;
        case -1257043949: // other_details
          this.getOther_detailsList().add((OBJECT_REF) value); // OBJECT_REF
          return value;
        case -1055650813: // parent_resource
          this.parent_resource = (AUTHORED_RESOURCE) value; // AUTHORED_RESOURCE
          return value;
        case 1557721666: // details
          this.getDetailsList().add((RESOURCE_DESCRIPTION_ITEM) value); // RESOURCE_DESCRIPTION_ITEM
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("original_author")) {
          this.getOriginal_authorList().add(TypeConvertor.castToString(value)); // StringType
        } else if (name.equals("other_contributors")) {
          this.getOther_contributorsList().add(TypeConvertor.castToString(value)); // StringType
        } else if (name.equals("lifecycle_state")) {
          this.lifecycle_state = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resource_package_uri")) {
          this.resource_package_uri = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("other_details")) {
          this.getOther_detailsList().add((OBJECT_REF) value); // OBJECT_REF
        } else if (name.equals("parent_resource")) {
          this.parent_resource = (AUTHORED_RESOURCE) value; // AUTHORED_RESOURCE
        } else if (name.equals("details")) {
          this.getDetailsList().add((RESOURCE_DESCRIPTION_ITEM) value); // RESOURCE_DESCRIPTION_ITEM
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -821815367:  return addOriginal_authorElement();
        case 1215537095:  return addOther_contributorsElement();
        case 1508726652:  return getLifecycle_stateElement();
        case 812585794:  return getResource_package_uriElement();
        case -1257043949:  return addOther_details(); 
        case -1055650813: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'parent_resource'");
        case 1557721666:  return addDetails(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -821815367: /*original_author*/ return new String[] {"string"};
        case 1215537095: /*other_contributors*/ return new String[] {"string"};
        case 1508726652: /*lifecycle_state*/ return new String[] {"string"};
        case 812585794: /*resource_package_uri*/ return new String[] {"string"};
        case -1257043949: /*other_details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        case -1055650813: /*parent_resource*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/AUTHORED-RESOURCE"};
        case 1557721666: /*details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/RESOURCE-DESCRIPTION-ITEM"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("original_author")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION.original_author");
        }
        else if (name.equals("other_contributors")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION.other_contributors");
        }
        else if (name.equals("lifecycle_state")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION.lifecycle_state");
        }
        else if (name.equals("resource_package_uri")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION.resource_package_uri");
        }
        else if (name.equals("other_details")) {
          return addOther_details();
        }
        else if (name.equals("parent_resource")) {
          throw new FHIRException("Cannot call addChild on an abstract type RESOURCE_DESCRIPTION.parent_resource");
        }
        else if (name.equals("details")) {
          return addDetails();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RESOURCE_DESCRIPTION";

  }

      public RESOURCE_DESCRIPTION copy() {
        RESOURCE_DESCRIPTION dst = new RESOURCE_DESCRIPTION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RESOURCE_DESCRIPTION dst) {
        super.copyValues(dst);
        if (original_authorList != null) {
          dst.original_authorList = new ArrayList<StringType>();
          for (StringType i : original_authorList)
            dst.original_authorList.add(i.copy());
        };
        if (other_contributorsList != null) {
          dst.other_contributorsList = new ArrayList<StringType>();
          for (StringType i : other_contributorsList)
            dst.other_contributorsList.add(i.copy());
        };
        dst.lifecycle_state = lifecycle_state == null ? null : lifecycle_state.copy();
        dst.resource_package_uri = resource_package_uri == null ? null : resource_package_uri.copy();
        if (other_detailsList != null) {
          dst.other_detailsList = new ArrayList<OBJECT_REF>();
          for (OBJECT_REF i : other_detailsList)
            dst.other_detailsList.add(i.copy());
        };
        dst.parent_resource = parent_resource == null ? null : parent_resource.copy();
        if (detailsList != null) {
          dst.detailsList = new ArrayList<RESOURCE_DESCRIPTION_ITEM>();
          for (RESOURCE_DESCRIPTION_ITEM i : detailsList)
            dst.detailsList.add(i.copy());
        };
      }

      protected RESOURCE_DESCRIPTION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RESOURCE_DESCRIPTION))
          return false;
        RESOURCE_DESCRIPTION o = (RESOURCE_DESCRIPTION) other_;
        return compareDeep(original_authorList, o.original_authorList, true) && compareDeep(other_contributorsList, o.other_contributorsList, true)
           && compareDeep(lifecycle_state, o.lifecycle_state, true) && compareDeep(resource_package_uri, o.resource_package_uri, true)
           && compareDeep(other_detailsList, o.other_detailsList, true) && compareDeep(parent_resource, o.parent_resource, true)
           && compareDeep(detailsList, o.detailsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RESOURCE_DESCRIPTION))
          return false;
        RESOURCE_DESCRIPTION o = (RESOURCE_DESCRIPTION) other_;
        return compareValues(original_authorList, o.original_authorList, true) && compareValues(other_contributorsList, o.other_contributorsList, true)
           && compareValues(lifecycle_state, o.lifecycle_state, true) && compareValues(resource_package_uri, o.resource_package_uri, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(original_authorList, other_contributorsList
          , lifecycle_state, resource_package_uri, other_detailsList, parent_resource, detailsList
          );
      }


}

