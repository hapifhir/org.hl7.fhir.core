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
 * 
 */
@DatatypeDef(name="WebTemplateItem")
public class WebTemplateItem extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "id", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Node ID (this ID is needed when input data is converted to a composition)", formalDefinition="" )
    protected StringType id;

    /**
     * 
     */
    @Child(name = "depth", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected IntegerType depth;

    /**
     * 
     */
    @Child(name = "name", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Default node name", formalDefinition="" )
    protected StringType name;

    /**
     * 
     */
    @Child(name = "localizedName", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Node name in the default language", formalDefinition="" )
    protected StringType localizedName;

    /**
     * 
     */
    @Child(name = "rmType", type = {CodeType.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference Model class name for this node", formalDefinition="" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-item-rmtype")
    protected CodeType rmType;

    /**
     * 
     */
    @Child(name = "nodeId", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Archetype node id as either a full openEHR-EHR-xxxxx archetype id or just an at-code", formalDefinition="" )
    protected StringType nodeId;

    /**
     * 
     */
    @Child(name = "min", type = {StringType.class}, order=6, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Minimal value of occurrences for this node (this node has to appear at least this many times)", formalDefinition="" )
    protected StringType min;

    /**
     * 
     */
    @Child(name = "max", type = {StringType.class}, order=7, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Maximal value of occurrences for this node or -1 if unlimited. When converting to a composition this node should not appear more than this many times.", formalDefinition="" )
    protected StringType max;

    /**
     * 
     */
    @Child(name = "dependsOn", type = {StringType.class}, order=8, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType dependsOn;

    /**
     * 
     */
    @Child(name = "localizedNames", type = {TranslatedString.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Map with labels in additional languages", formalDefinition="" )
    protected List<TranslatedString> localizedNamesList;

    /**
     * 
     */
    @Child(name = "localizedDescriptions", type = {TranslatedString.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Map with element descriptions", formalDefinition="" )
    protected List<TranslatedString> localizedDescriptionsList;

    /**
     * 
     */
    @Child(name = "annotations", type = {Annotations.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected Annotations annotations;

    /**
     * 
     */
    @Child(name = "archetype_id", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType archetype_id;

    /**
     * 
     */
    @Child(name = "aqlPath", type = {StringType.class}, order=13, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="AQL (or RM) path to this node. Such paths can be used in AQLs", formalDefinition="" )
    protected StringType aqlPath;

    /**
     * 
     */
    @Child(name = "custodian_namespace", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType custodian_namespace;

    /**
     * 
     */
    @Child(name = "custodian_organisation", type = {StringType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType custodian_organisation;

    /**
     * 
     */
    @Child(name = "lifecycleState", type = {CodeType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-item-lifecyclestate")
    protected CodeType lifecycleState;

    /**
     * 
     */
    @Child(name = "original_namespace", type = {StringType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType original_namespace;

    /**
     * 
     */
    @Child(name = "original_publisher", type = {StringType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType original_publisher;

    /**
     * 
     */
    @Child(name = "proportionTypes", type = {CodeType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-item-proportiontype")
    protected CodeType proportionTypes;

    /**
     * 
     */
    @Child(name = "revision", type = {StringType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType revision;

    /**
     * 
     */
    @Child(name = "inContext", type = {BooleanType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected BooleanType inContext;

    /**
     * 
     */
    @Child(name = "inputs", type = {WebTemplateInput.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for creating input fields. the inputs are determined by the attributes for a particular datatype", formalDefinition="" )
    protected List<WebTemplateInput> inputsList;

    /**
     * 
     */
    @Child(name = "termBindings", type = {WebTemplateTermBinding.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected List<WebTemplateTermBinding> termBindingsList;

    /**
     * 
     */
    @Child(name = "children", type = {WebTemplateItem.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected List<WebTemplateItem> childrenList;

    private static final long serialVersionUID = -1765598574L;

  /**
   * Constructor
   */
    public WebTemplateItem() {
      super();
    }

  /**
   * Constructor
   */
    public WebTemplateItem(String id, String rmType, String min, String max, String dependsOn, String aqlPath) {
      super();
      this.setId(id);
      this.setRmType(rmType);
      this.setMin(min);
      this.setMax(max);
      this.setDependsOn(dependsOn);
      this.setAqlPath(aqlPath);
    }

    /**
     * @return {@link #id} (). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
     */
    public StringType getIdElement() { 
      if (this.id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.id");
        else if (Configuration.doAutoCreate())
          this.id = new StringType(); // bb
      return this.id;
    }

    public boolean hasIdElement() { 
      return this.id != null && !this.id.isEmpty();
    }

    public boolean hasId() { 
      return this.id != null && !this.id.isEmpty();
    }

    /**
     * @param value {@link #id} (). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
     */
    public WebTemplateItem setIdElement(StringType value) { 
      this.id = value;
      return this;
    }

    /**
     * @return 
     */
    public String getId() { 
      return this.id == null ? null : this.id.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setId(String value) { 
        if (this.id == null)
          this.id = new StringType();
        this.id.setValue(value);
      return this;
    }

    /**
     * @return {@link #depth} (). This is the underlying object with id, value and extensions. The accessor "getDepth" gives direct access to the value
     */
    public IntegerType getDepthElement() { 
      if (this.depth == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.depth");
        else if (Configuration.doAutoCreate())
          this.depth = new IntegerType(); // bb
      return this.depth;
    }

    public boolean hasDepthElement() { 
      return this.depth != null && !this.depth.isEmpty();
    }

    public boolean hasDepth() { 
      return this.depth != null && !this.depth.isEmpty();
    }

    /**
     * @param value {@link #depth} (). This is the underlying object with id, value and extensions. The accessor "getDepth" gives direct access to the value
     */
    public WebTemplateItem setDepthElement(IntegerType value) { 
      this.depth = value;
      return this;
    }

    /**
     * @return 
     */
    public int getDepth() { 
      return this.depth == null || this.depth.isEmpty() ? 0 : this.depth.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setDepth(int value) { 
        if (this.depth == null)
          this.depth = new IntegerType();
        this.depth.setValue(value);
      return this;
    }

    /**
     * @return {@link #name} (). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.name");
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
     * @param value {@link #name} (). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public WebTemplateItem setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return 
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setName(String value) { 
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
     * @return {@link #localizedName} (). This is the underlying object with id, value and extensions. The accessor "getLocalizedName" gives direct access to the value
     */
    public StringType getLocalizedNameElement() { 
      if (this.localizedName == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.localizedName");
        else if (Configuration.doAutoCreate())
          this.localizedName = new StringType(); // bb
      return this.localizedName;
    }

    public boolean hasLocalizedNameElement() { 
      return this.localizedName != null && !this.localizedName.isEmpty();
    }

    public boolean hasLocalizedName() { 
      return this.localizedName != null && !this.localizedName.isEmpty();
    }

    /**
     * @param value {@link #localizedName} (). This is the underlying object with id, value and extensions. The accessor "getLocalizedName" gives direct access to the value
     */
    public WebTemplateItem setLocalizedNameElement(StringType value) { 
      this.localizedName = value;
      return this;
    }

    /**
     * @return 
     */
    public String getLocalizedName() { 
      return this.localizedName == null ? null : this.localizedName.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setLocalizedName(String value) { 
      if (Utilities.noString(value))
        this.localizedName = null;
      else {
        if (this.localizedName == null)
          this.localizedName = new StringType();
        this.localizedName.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #rmType} (). This is the underlying object with id, value and extensions. The accessor "getRmType" gives direct access to the value
     */
    public CodeType getRmTypeElement() { 
      if (this.rmType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.rmType");
        else if (Configuration.doAutoCreate())
          this.rmType = new CodeType(); // bb
      return this.rmType;
    }

    public boolean hasRmTypeElement() { 
      return this.rmType != null && !this.rmType.isEmpty();
    }

    public boolean hasRmType() { 
      return this.rmType != null && !this.rmType.isEmpty();
    }

    /**
     * @param value {@link #rmType} (). This is the underlying object with id, value and extensions. The accessor "getRmType" gives direct access to the value
     */
    public WebTemplateItem setRmTypeElement(CodeType value) { 
      this.rmType = value;
      return this;
    }

    /**
     * @return 
     */
    public String getRmType() { 
      return this.rmType == null ? null : this.rmType.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setRmType(String value) { 
        if (this.rmType == null)
          this.rmType = new CodeType();
        this.rmType.setValue(value);
      return this;
    }

    /**
     * @return {@link #nodeId} (). This is the underlying object with id, value and extensions. The accessor "getNodeId" gives direct access to the value
     */
    public StringType getNodeIdElement() { 
      if (this.nodeId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.nodeId");
        else if (Configuration.doAutoCreate())
          this.nodeId = new StringType(); // bb
      return this.nodeId;
    }

    public boolean hasNodeIdElement() { 
      return this.nodeId != null && !this.nodeId.isEmpty();
    }

    public boolean hasNodeId() { 
      return this.nodeId != null && !this.nodeId.isEmpty();
    }

    /**
     * @param value {@link #nodeId} (). This is the underlying object with id, value and extensions. The accessor "getNodeId" gives direct access to the value
     */
    public WebTemplateItem setNodeIdElement(StringType value) { 
      this.nodeId = value;
      return this;
    }

    /**
     * @return 
     */
    public String getNodeId() { 
      return this.nodeId == null ? null : this.nodeId.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setNodeId(String value) { 
      if (Utilities.noString(value))
        this.nodeId = null;
      else {
        if (this.nodeId == null)
          this.nodeId = new StringType();
        this.nodeId.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #min} (). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
     */
    public StringType getMinElement() { 
      if (this.min == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.min");
        else if (Configuration.doAutoCreate())
          this.min = new StringType(); // bb
      return this.min;
    }

    public boolean hasMinElement() { 
      return this.min != null && !this.min.isEmpty();
    }

    public boolean hasMin() { 
      return this.min != null && !this.min.isEmpty();
    }

    /**
     * @param value {@link #min} (). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
     */
    public WebTemplateItem setMinElement(StringType value) { 
      this.min = value;
      return this;
    }

    /**
     * @return 
     */
    public String getMin() { 
      return this.min == null ? null : this.min.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setMin(String value) { 
        if (this.min == null)
          this.min = new StringType();
        this.min.setValue(value);
      return this;
    }

    /**
     * @return {@link #max} (). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
     */
    public StringType getMaxElement() { 
      if (this.max == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.max");
        else if (Configuration.doAutoCreate())
          this.max = new StringType(); // bb
      return this.max;
    }

    public boolean hasMaxElement() { 
      return this.max != null && !this.max.isEmpty();
    }

    public boolean hasMax() { 
      return this.max != null && !this.max.isEmpty();
    }

    /**
     * @param value {@link #max} (). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
     */
    public WebTemplateItem setMaxElement(StringType value) { 
      this.max = value;
      return this;
    }

    /**
     * @return 
     */
    public String getMax() { 
      return this.max == null ? null : this.max.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setMax(String value) { 
        if (this.max == null)
          this.max = new StringType();
        this.max.setValue(value);
      return this;
    }

    /**
     * @return {@link #dependsOn} (). This is the underlying object with id, value and extensions. The accessor "getDependsOn" gives direct access to the value
     */
    public StringType getDependsOnElement() { 
      if (this.dependsOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.dependsOn");
        else if (Configuration.doAutoCreate())
          this.dependsOn = new StringType(); // bb
      return this.dependsOn;
    }

    public boolean hasDependsOnElement() { 
      return this.dependsOn != null && !this.dependsOn.isEmpty();
    }

    public boolean hasDependsOn() { 
      return this.dependsOn != null && !this.dependsOn.isEmpty();
    }

    /**
     * @param value {@link #dependsOn} (). This is the underlying object with id, value and extensions. The accessor "getDependsOn" gives direct access to the value
     */
    public WebTemplateItem setDependsOnElement(StringType value) { 
      this.dependsOn = value;
      return this;
    }

    /**
     * @return 
     */
    public String getDependsOn() { 
      return this.dependsOn == null ? null : this.dependsOn.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setDependsOn(String value) { 
        if (this.dependsOn == null)
          this.dependsOn = new StringType();
        this.dependsOn.setValue(value);
      return this;
    }

    /**
     * @return {@link #localizedNames} ()
     */
    public List<TranslatedString> getLocalizedNamesList() { 
      if (this.localizedNamesList == null)
        this.localizedNamesList = new ArrayList<TranslatedString>();
      return this.localizedNamesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateItem setLocalizedNamesList(List<TranslatedString> theLocalizedNames) { 
      this.localizedNamesList = theLocalizedNames;
      return this;
    }

    public boolean hasLocalizedNames() { 
      if (this.localizedNamesList == null)
        return false;
      for (TranslatedString item : this.localizedNamesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TranslatedString addLocalizedNames() { //3a
      TranslatedString t = new TranslatedString();
      if (this.localizedNamesList == null)
        this.localizedNamesList = new ArrayList<TranslatedString>();
      this.localizedNamesList.add(t);
      return t;
    }

    public WebTemplateItem addLocalizedNames(TranslatedString t) { //3b
      if (t == null)
        return this;
      if (this.localizedNamesList == null)
        this.localizedNamesList = new ArrayList<TranslatedString>();
      this.localizedNamesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #localizedNames}, creating it if it does not already exist {3}
     */
    public TranslatedString getLocalizedNamesFirstRep() { 
      if (getLocalizedNamesList().isEmpty()) {
        addLocalizedNames();
      }
      return getLocalizedNamesList().get(0);
    }

    /**
     * @return {@link #localizedDescriptions} ()
     */
    public List<TranslatedString> getLocalizedDescriptionsList() { 
      if (this.localizedDescriptionsList == null)
        this.localizedDescriptionsList = new ArrayList<TranslatedString>();
      return this.localizedDescriptionsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateItem setLocalizedDescriptionsList(List<TranslatedString> theLocalizedDescriptions) { 
      this.localizedDescriptionsList = theLocalizedDescriptions;
      return this;
    }

    public boolean hasLocalizedDescriptions() { 
      if (this.localizedDescriptionsList == null)
        return false;
      for (TranslatedString item : this.localizedDescriptionsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TranslatedString addLocalizedDescriptions() { //3a
      TranslatedString t = new TranslatedString();
      if (this.localizedDescriptionsList == null)
        this.localizedDescriptionsList = new ArrayList<TranslatedString>();
      this.localizedDescriptionsList.add(t);
      return t;
    }

    public WebTemplateItem addLocalizedDescriptions(TranslatedString t) { //3b
      if (t == null)
        return this;
      if (this.localizedDescriptionsList == null)
        this.localizedDescriptionsList = new ArrayList<TranslatedString>();
      this.localizedDescriptionsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #localizedDescriptions}, creating it if it does not already exist {3}
     */
    public TranslatedString getLocalizedDescriptionsFirstRep() { 
      if (getLocalizedDescriptionsList().isEmpty()) {
        addLocalizedDescriptions();
      }
      return getLocalizedDescriptionsList().get(0);
    }

    /**
     * @return {@link #annotations} ()
     */
    public Annotations getAnnotations() { 
      if (this.annotations == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.annotations");
        else if (Configuration.doAutoCreate())
          this.annotations = new Annotations(); // cc
      return this.annotations;
    }

    public boolean hasAnnotations() { 
      return this.annotations != null && !this.annotations.isEmpty();
    }

    /**
     * @param value {@link #annotations} ()
     */
    public WebTemplateItem setAnnotations(Annotations value) { 
      this.annotations = value;
      return this;
    }

    /**
     * @return {@link #archetype_id} (). This is the underlying object with id, value and extensions. The accessor "getArchetype_id" gives direct access to the value
     */
    public StringType getArchetype_idElement() { 
      if (this.archetype_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.archetype_id");
        else if (Configuration.doAutoCreate())
          this.archetype_id = new StringType(); // bb
      return this.archetype_id;
    }

    public boolean hasArchetype_idElement() { 
      return this.archetype_id != null && !this.archetype_id.isEmpty();
    }

    public boolean hasArchetype_id() { 
      return this.archetype_id != null && !this.archetype_id.isEmpty();
    }

    /**
     * @param value {@link #archetype_id} (). This is the underlying object with id, value and extensions. The accessor "getArchetype_id" gives direct access to the value
     */
    public WebTemplateItem setArchetype_idElement(StringType value) { 
      this.archetype_id = value;
      return this;
    }

    /**
     * @return 
     */
    public String getArchetype_id() { 
      return this.archetype_id == null ? null : this.archetype_id.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setArchetype_id(String value) { 
      if (Utilities.noString(value))
        this.archetype_id = null;
      else {
        if (this.archetype_id == null)
          this.archetype_id = new StringType();
        this.archetype_id.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #aqlPath} (). This is the underlying object with id, value and extensions. The accessor "getAqlPath" gives direct access to the value
     */
    public StringType getAqlPathElement() { 
      if (this.aqlPath == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.aqlPath");
        else if (Configuration.doAutoCreate())
          this.aqlPath = new StringType(); // bb
      return this.aqlPath;
    }

    public boolean hasAqlPathElement() { 
      return this.aqlPath != null && !this.aqlPath.isEmpty();
    }

    public boolean hasAqlPath() { 
      return this.aqlPath != null && !this.aqlPath.isEmpty();
    }

    /**
     * @param value {@link #aqlPath} (). This is the underlying object with id, value and extensions. The accessor "getAqlPath" gives direct access to the value
     */
    public WebTemplateItem setAqlPathElement(StringType value) { 
      this.aqlPath = value;
      return this;
    }

    /**
     * @return 
     */
    public String getAqlPath() { 
      return this.aqlPath == null ? null : this.aqlPath.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setAqlPath(String value) { 
        if (this.aqlPath == null)
          this.aqlPath = new StringType();
        this.aqlPath.setValue(value);
      return this;
    }

    /**
     * @return {@link #custodian_namespace} (). This is the underlying object with id, value and extensions. The accessor "getCustodian_namespace" gives direct access to the value
     */
    public StringType getCustodian_namespaceElement() { 
      if (this.custodian_namespace == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.custodian_namespace");
        else if (Configuration.doAutoCreate())
          this.custodian_namespace = new StringType(); // bb
      return this.custodian_namespace;
    }

    public boolean hasCustodian_namespaceElement() { 
      return this.custodian_namespace != null && !this.custodian_namespace.isEmpty();
    }

    public boolean hasCustodian_namespace() { 
      return this.custodian_namespace != null && !this.custodian_namespace.isEmpty();
    }

    /**
     * @param value {@link #custodian_namespace} (). This is the underlying object with id, value and extensions. The accessor "getCustodian_namespace" gives direct access to the value
     */
    public WebTemplateItem setCustodian_namespaceElement(StringType value) { 
      this.custodian_namespace = value;
      return this;
    }

    /**
     * @return 
     */
    public String getCustodian_namespace() { 
      return this.custodian_namespace == null ? null : this.custodian_namespace.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setCustodian_namespace(String value) { 
      if (Utilities.noString(value))
        this.custodian_namespace = null;
      else {
        if (this.custodian_namespace == null)
          this.custodian_namespace = new StringType();
        this.custodian_namespace.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #custodian_organisation} (). This is the underlying object with id, value and extensions. The accessor "getCustodian_organisation" gives direct access to the value
     */
    public StringType getCustodian_organisationElement() { 
      if (this.custodian_organisation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.custodian_organisation");
        else if (Configuration.doAutoCreate())
          this.custodian_organisation = new StringType(); // bb
      return this.custodian_organisation;
    }

    public boolean hasCustodian_organisationElement() { 
      return this.custodian_organisation != null && !this.custodian_organisation.isEmpty();
    }

    public boolean hasCustodian_organisation() { 
      return this.custodian_organisation != null && !this.custodian_organisation.isEmpty();
    }

    /**
     * @param value {@link #custodian_organisation} (). This is the underlying object with id, value and extensions. The accessor "getCustodian_organisation" gives direct access to the value
     */
    public WebTemplateItem setCustodian_organisationElement(StringType value) { 
      this.custodian_organisation = value;
      return this;
    }

    /**
     * @return 
     */
    public String getCustodian_organisation() { 
      return this.custodian_organisation == null ? null : this.custodian_organisation.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setCustodian_organisation(String value) { 
      if (Utilities.noString(value))
        this.custodian_organisation = null;
      else {
        if (this.custodian_organisation == null)
          this.custodian_organisation = new StringType();
        this.custodian_organisation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lifecycleState} (). This is the underlying object with id, value and extensions. The accessor "getLifecycleState" gives direct access to the value
     */
    public CodeType getLifecycleStateElement() { 
      if (this.lifecycleState == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.lifecycleState");
        else if (Configuration.doAutoCreate())
          this.lifecycleState = new CodeType(); // bb
      return this.lifecycleState;
    }

    public boolean hasLifecycleStateElement() { 
      return this.lifecycleState != null && !this.lifecycleState.isEmpty();
    }

    public boolean hasLifecycleState() { 
      return this.lifecycleState != null && !this.lifecycleState.isEmpty();
    }

    /**
     * @param value {@link #lifecycleState} (). This is the underlying object with id, value and extensions. The accessor "getLifecycleState" gives direct access to the value
     */
    public WebTemplateItem setLifecycleStateElement(CodeType value) { 
      this.lifecycleState = value;
      return this;
    }

    /**
     * @return 
     */
    public String getLifecycleState() { 
      return this.lifecycleState == null ? null : this.lifecycleState.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setLifecycleState(String value) { 
      if (Utilities.noString(value))
        this.lifecycleState = null;
      else {
        if (this.lifecycleState == null)
          this.lifecycleState = new CodeType();
        this.lifecycleState.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #original_namespace} (). This is the underlying object with id, value and extensions. The accessor "getOriginal_namespace" gives direct access to the value
     */
    public StringType getOriginal_namespaceElement() { 
      if (this.original_namespace == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.original_namespace");
        else if (Configuration.doAutoCreate())
          this.original_namespace = new StringType(); // bb
      return this.original_namespace;
    }

    public boolean hasOriginal_namespaceElement() { 
      return this.original_namespace != null && !this.original_namespace.isEmpty();
    }

    public boolean hasOriginal_namespace() { 
      return this.original_namespace != null && !this.original_namespace.isEmpty();
    }

    /**
     * @param value {@link #original_namespace} (). This is the underlying object with id, value and extensions. The accessor "getOriginal_namespace" gives direct access to the value
     */
    public WebTemplateItem setOriginal_namespaceElement(StringType value) { 
      this.original_namespace = value;
      return this;
    }

    /**
     * @return 
     */
    public String getOriginal_namespace() { 
      return this.original_namespace == null ? null : this.original_namespace.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setOriginal_namespace(String value) { 
      if (Utilities.noString(value))
        this.original_namespace = null;
      else {
        if (this.original_namespace == null)
          this.original_namespace = new StringType();
        this.original_namespace.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #original_publisher} (). This is the underlying object with id, value and extensions. The accessor "getOriginal_publisher" gives direct access to the value
     */
    public StringType getOriginal_publisherElement() { 
      if (this.original_publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.original_publisher");
        else if (Configuration.doAutoCreate())
          this.original_publisher = new StringType(); // bb
      return this.original_publisher;
    }

    public boolean hasOriginal_publisherElement() { 
      return this.original_publisher != null && !this.original_publisher.isEmpty();
    }

    public boolean hasOriginal_publisher() { 
      return this.original_publisher != null && !this.original_publisher.isEmpty();
    }

    /**
     * @param value {@link #original_publisher} (). This is the underlying object with id, value and extensions. The accessor "getOriginal_publisher" gives direct access to the value
     */
    public WebTemplateItem setOriginal_publisherElement(StringType value) { 
      this.original_publisher = value;
      return this;
    }

    /**
     * @return 
     */
    public String getOriginal_publisher() { 
      return this.original_publisher == null ? null : this.original_publisher.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setOriginal_publisher(String value) { 
      if (Utilities.noString(value))
        this.original_publisher = null;
      else {
        if (this.original_publisher == null)
          this.original_publisher = new StringType();
        this.original_publisher.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #proportionTypes} (). This is the underlying object with id, value and extensions. The accessor "getProportionTypes" gives direct access to the value
     */
    public CodeType getProportionTypesElement() { 
      if (this.proportionTypes == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.proportionTypes");
        else if (Configuration.doAutoCreate())
          this.proportionTypes = new CodeType(); // bb
      return this.proportionTypes;
    }

    public boolean hasProportionTypesElement() { 
      return this.proportionTypes != null && !this.proportionTypes.isEmpty();
    }

    public boolean hasProportionTypes() { 
      return this.proportionTypes != null && !this.proportionTypes.isEmpty();
    }

    /**
     * @param value {@link #proportionTypes} (). This is the underlying object with id, value and extensions. The accessor "getProportionTypes" gives direct access to the value
     */
    public WebTemplateItem setProportionTypesElement(CodeType value) { 
      this.proportionTypes = value;
      return this;
    }

    /**
     * @return 
     */
    public String getProportionTypes() { 
      return this.proportionTypes == null ? null : this.proportionTypes.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setProportionTypes(String value) { 
      if (Utilities.noString(value))
        this.proportionTypes = null;
      else {
        if (this.proportionTypes == null)
          this.proportionTypes = new CodeType();
        this.proportionTypes.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #revision} (). This is the underlying object with id, value and extensions. The accessor "getRevision" gives direct access to the value
     */
    public StringType getRevisionElement() { 
      if (this.revision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.revision");
        else if (Configuration.doAutoCreate())
          this.revision = new StringType(); // bb
      return this.revision;
    }

    public boolean hasRevisionElement() { 
      return this.revision != null && !this.revision.isEmpty();
    }

    public boolean hasRevision() { 
      return this.revision != null && !this.revision.isEmpty();
    }

    /**
     * @param value {@link #revision} (). This is the underlying object with id, value and extensions. The accessor "getRevision" gives direct access to the value
     */
    public WebTemplateItem setRevisionElement(StringType value) { 
      this.revision = value;
      return this;
    }

    /**
     * @return 
     */
    public String getRevision() { 
      return this.revision == null ? null : this.revision.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setRevision(String value) { 
      if (Utilities.noString(value))
        this.revision = null;
      else {
        if (this.revision == null)
          this.revision = new StringType();
        this.revision.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #inContext} (). This is the underlying object with id, value and extensions. The accessor "getInContext" gives direct access to the value
     */
    public BooleanType getInContextElement() { 
      if (this.inContext == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateItem.inContext");
        else if (Configuration.doAutoCreate())
          this.inContext = new BooleanType(); // bb
      return this.inContext;
    }

    public boolean hasInContextElement() { 
      return this.inContext != null && !this.inContext.isEmpty();
    }

    public boolean hasInContext() { 
      return this.inContext != null && !this.inContext.isEmpty();
    }

    /**
     * @param value {@link #inContext} (). This is the underlying object with id, value and extensions. The accessor "getInContext" gives direct access to the value
     */
    public WebTemplateItem setInContextElement(BooleanType value) { 
      this.inContext = value;
      return this;
    }

    /**
     * @return 
     */
    public boolean getInContext() { 
      return this.inContext == null || this.inContext.isEmpty() ? false : this.inContext.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateItem setInContext(boolean value) { 
        if (this.inContext == null)
          this.inContext = new BooleanType();
        this.inContext.setValue(value);
      return this;
    }

    /**
     * @return {@link #inputs} ()
     */
    public List<WebTemplateInput> getInputsList() { 
      if (this.inputsList == null)
        this.inputsList = new ArrayList<WebTemplateInput>();
      return this.inputsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateItem setInputsList(List<WebTemplateInput> theInputs) { 
      this.inputsList = theInputs;
      return this;
    }

    public boolean hasInputs() { 
      if (this.inputsList == null)
        return false;
      for (WebTemplateInput item : this.inputsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public WebTemplateInput addInputs() { //3a
      WebTemplateInput t = new WebTemplateInput();
      if (this.inputsList == null)
        this.inputsList = new ArrayList<WebTemplateInput>();
      this.inputsList.add(t);
      return t;
    }

    public WebTemplateItem addInputs(WebTemplateInput t) { //3b
      if (t == null)
        return this;
      if (this.inputsList == null)
        this.inputsList = new ArrayList<WebTemplateInput>();
      this.inputsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #inputs}, creating it if it does not already exist {3}
     */
    public WebTemplateInput getInputsFirstRep() { 
      if (getInputsList().isEmpty()) {
        addInputs();
      }
      return getInputsList().get(0);
    }

    /**
     * @return {@link #termBindings} ()
     */
    public List<WebTemplateTermBinding> getTermBindingsList() { 
      if (this.termBindingsList == null)
        this.termBindingsList = new ArrayList<WebTemplateTermBinding>();
      return this.termBindingsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateItem setTermBindingsList(List<WebTemplateTermBinding> theTermBindings) { 
      this.termBindingsList = theTermBindings;
      return this;
    }

    public boolean hasTermBindings() { 
      if (this.termBindingsList == null)
        return false;
      for (WebTemplateTermBinding item : this.termBindingsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public WebTemplateTermBinding addTermBindings() { //3a
      WebTemplateTermBinding t = new WebTemplateTermBinding();
      if (this.termBindingsList == null)
        this.termBindingsList = new ArrayList<WebTemplateTermBinding>();
      this.termBindingsList.add(t);
      return t;
    }

    public WebTemplateItem addTermBindings(WebTemplateTermBinding t) { //3b
      if (t == null)
        return this;
      if (this.termBindingsList == null)
        this.termBindingsList = new ArrayList<WebTemplateTermBinding>();
      this.termBindingsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #termBindings}, creating it if it does not already exist {3}
     */
    public WebTemplateTermBinding getTermBindingsFirstRep() { 
      if (getTermBindingsList().isEmpty()) {
        addTermBindings();
      }
      return getTermBindingsList().get(0);
    }

    /**
     * @return {@link #children} ()
     */
    public List<WebTemplateItem> getChildrenList() { 
      if (this.childrenList == null)
        this.childrenList = new ArrayList<WebTemplateItem>();
      return this.childrenList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateItem setChildrenList(List<WebTemplateItem> theChildren) { 
      this.childrenList = theChildren;
      return this;
    }

    public boolean hasChildren() { 
      if (this.childrenList == null)
        return false;
      for (WebTemplateItem item : this.childrenList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public WebTemplateItem addChildren() { //3a
      WebTemplateItem t = new WebTemplateItem();
      if (this.childrenList == null)
        this.childrenList = new ArrayList<WebTemplateItem>();
      this.childrenList.add(t);
      return t;
    }

    public WebTemplateItem addChildren(WebTemplateItem t) { //3b
      if (t == null)
        return this;
      if (this.childrenList == null)
        this.childrenList = new ArrayList<WebTemplateItem>();
      this.childrenList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #children}, creating it if it does not already exist {3}
     */
    public WebTemplateItem getChildrenFirstRep() { 
      if (getChildrenList().isEmpty()) {
        addChildren();
      }
      return getChildrenList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("id", "string", "", 0, 1, id));
        children.add(new Property("depth", "integer", "", 0, 1, depth));
        children.add(new Property("name", "string", "", 0, 1, name));
        children.add(new Property("localizedName", "string", "", 0, 1, localizedName));
        children.add(new Property("rmType", "code", "", 0, 1, rmType));
        children.add(new Property("nodeId", "string", "", 0, 1, nodeId));
        children.add(new Property("min", "string", "", 0, 1, min));
        children.add(new Property("max", "string", "", 0, 1, max));
        children.add(new Property("dependsOn", "string", "", 0, 1, dependsOn));
        children.add(new Property("localizedNames", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedNamesList));
        children.add(new Property("localizedDescriptions", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedDescriptionsList));
        children.add(new Property("annotations", "http://openehr.org/fhir/StructureDefinition/Annotations", "", 0, 1, annotations));
        children.add(new Property("archetype_id", "string", "", 0, 1, archetype_id));
        children.add(new Property("aqlPath", "string", "", 0, 1, aqlPath));
        children.add(new Property("custodian_namespace", "string", "", 0, 1, custodian_namespace));
        children.add(new Property("custodian_organisation", "string", "", 0, 1, custodian_organisation));
        children.add(new Property("lifecycleState", "code", "", 0, 1, lifecycleState));
        children.add(new Property("original_namespace", "string", "", 0, 1, original_namespace));
        children.add(new Property("original_publisher", "string", "", 0, 1, original_publisher));
        children.add(new Property("proportionTypes", "code", "", 0, 1, proportionTypes));
        children.add(new Property("revision", "string", "", 0, 1, revision));
        children.add(new Property("inContext", "boolean", "", 0, 1, inContext));
        children.add(new Property("inputs", "http://openehr.org/fhir/StructureDefinition/WebTemplateInput", "", 0, java.lang.Integer.MAX_VALUE, inputsList));
        children.add(new Property("termBindings", "http://openehr.org/fhir/StructureDefinition/WebTemplateTermBinding", "", 0, java.lang.Integer.MAX_VALUE, termBindingsList));
        children.add(new Property("children", "http://openehr.org/fhir/StructureDefinition/WebTemplateItem", "", 0, java.lang.Integer.MAX_VALUE, childrenList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3355: /*id*/  return new Property("id", "string", "", 0, 1, id);
        case 95472323: /*depth*/  return new Property("depth", "integer", "", 0, 1, depth);
        case 3373707: /*name*/  return new Property("name", "string", "", 0, 1, name);
        case 696548518: /*localizedName*/  return new Property("localizedName", "string", "", 0, 1, localizedName);
        case -927957995: /*rmType*/  return new Property("rmType", "code", "", 0, 1, rmType);
        case -1040171331: /*nodeId*/  return new Property("nodeId", "string", "", 0, 1, nodeId);
        case 108114: /*min*/  return new Property("min", "string", "", 0, 1, min);
        case 107876: /*max*/  return new Property("max", "string", "", 0, 1, max);
        case -1109214266: /*dependsOn*/  return new Property("dependsOn", "string", "", 0, 1, dependsOn);
        case 118167693: /*localizedNames*/  return new Property("localizedNames", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedNamesList);
        case 31568658: /*localizedDescriptions*/  return new Property("localizedDescriptions", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedDescriptionsList);
        case -961709276: /*annotations*/  return new Property("annotations", "http://openehr.org/fhir/StructureDefinition/Annotations", "", 0, 1, annotations);
        case -1252479343: /*archetype_id*/  return new Property("archetype_id", "string", "", 0, 1, archetype_id);
        case -769141631: /*aqlPath*/  return new Property("aqlPath", "string", "", 0, 1, aqlPath);
        case -1393315766: /*custodian_namespace*/  return new Property("custodian_namespace", "string", "", 0, 1, custodian_namespace);
        case 525929355: /*custodian_organisation*/  return new Property("custodian_organisation", "string", "", 0, 1, custodian_organisation);
        case -1486422201: /*lifecycleState*/  return new Property("lifecycleState", "code", "", 0, 1, lifecycleState);
        case -1611298707: /*original_namespace*/  return new Property("original_namespace", "string", "", 0, 1, original_namespace);
        case -1416112882: /*original_publisher*/  return new Property("original_publisher", "string", "", 0, 1, original_publisher);
        case 2145858559: /*proportionTypes*/  return new Property("proportionTypes", "code", "", 0, 1, proportionTypes);
        case -260786213: /*revision*/  return new Property("revision", "string", "", 0, 1, revision);
        case 247635146: /*inContext*/  return new Property("inContext", "boolean", "", 0, 1, inContext);
        case -1183866391: /*inputs*/  return new Property("inputs", "http://openehr.org/fhir/StructureDefinition/WebTemplateInput", "", 0, java.lang.Integer.MAX_VALUE, inputsList);
        case 1618255642: /*termBindings*/  return new Property("termBindings", "http://openehr.org/fhir/StructureDefinition/WebTemplateTermBinding", "", 0, java.lang.Integer.MAX_VALUE, termBindingsList);
        case 1659526655: /*children*/  return new Property("children", "http://openehr.org/fhir/StructureDefinition/WebTemplateItem", "", 0, java.lang.Integer.MAX_VALUE, childrenList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3355: /*id*/ return this.id == null ? new Base[0] : new Base[] {this.id}; // StringType
        case 95472323: /*depth*/ return this.depth == null ? new Base[0] : new Base[] {this.depth}; // IntegerType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 696548518: /*localizedName*/ return this.localizedName == null ? new Base[0] : new Base[] {this.localizedName}; // StringType
        case -927957995: /*rmType*/ return this.rmType == null ? new Base[0] : new Base[] {this.rmType}; // CodeType
        case -1040171331: /*nodeId*/ return this.nodeId == null ? new Base[0] : new Base[] {this.nodeId}; // StringType
        case 108114: /*min*/ return this.min == null ? new Base[0] : new Base[] {this.min}; // StringType
        case 107876: /*max*/ return this.max == null ? new Base[0] : new Base[] {this.max}; // StringType
        case -1109214266: /*dependsOn*/ return this.dependsOn == null ? new Base[0] : new Base[] {this.dependsOn}; // StringType
        case 118167693: /*localizedNames*/ return this.localizedNamesList == null ? new Base[0] : this.localizedNamesList.toArray(new Base[this.localizedNamesList.size()]); // TranslatedString
        case 31568658: /*localizedDescriptions*/ return this.localizedDescriptionsList == null ? new Base[0] : this.localizedDescriptionsList.toArray(new Base[this.localizedDescriptionsList.size()]); // TranslatedString
        case -961709276: /*annotations*/ return this.annotations == null ? new Base[0] : new Base[] {this.annotations}; // Annotations
        case -1252479343: /*archetype_id*/ return this.archetype_id == null ? new Base[0] : new Base[] {this.archetype_id}; // StringType
        case -769141631: /*aqlPath*/ return this.aqlPath == null ? new Base[0] : new Base[] {this.aqlPath}; // StringType
        case -1393315766: /*custodian_namespace*/ return this.custodian_namespace == null ? new Base[0] : new Base[] {this.custodian_namespace}; // StringType
        case 525929355: /*custodian_organisation*/ return this.custodian_organisation == null ? new Base[0] : new Base[] {this.custodian_organisation}; // StringType
        case -1486422201: /*lifecycleState*/ return this.lifecycleState == null ? new Base[0] : new Base[] {this.lifecycleState}; // CodeType
        case -1611298707: /*original_namespace*/ return this.original_namespace == null ? new Base[0] : new Base[] {this.original_namespace}; // StringType
        case -1416112882: /*original_publisher*/ return this.original_publisher == null ? new Base[0] : new Base[] {this.original_publisher}; // StringType
        case 2145858559: /*proportionTypes*/ return this.proportionTypes == null ? new Base[0] : new Base[] {this.proportionTypes}; // CodeType
        case -260786213: /*revision*/ return this.revision == null ? new Base[0] : new Base[] {this.revision}; // StringType
        case 247635146: /*inContext*/ return this.inContext == null ? new Base[0] : new Base[] {this.inContext}; // BooleanType
        case -1183866391: /*inputs*/ return this.inputsList == null ? new Base[0] : this.inputsList.toArray(new Base[this.inputsList.size()]); // WebTemplateInput
        case 1618255642: /*termBindings*/ return this.termBindingsList == null ? new Base[0] : this.termBindingsList.toArray(new Base[this.termBindingsList.size()]); // WebTemplateTermBinding
        case 1659526655: /*children*/ return this.childrenList == null ? new Base[0] : this.childrenList.toArray(new Base[this.childrenList.size()]); // WebTemplateItem
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3355: // id
          this.id = TypeConvertor.castToString(value); // StringType
          return value;
        case 95472323: // depth
          this.depth = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 696548518: // localizedName
          this.localizedName = TypeConvertor.castToString(value); // StringType
          return value;
        case -927957995: // rmType
          this.rmType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1040171331: // nodeId
          this.nodeId = TypeConvertor.castToString(value); // StringType
          return value;
        case 108114: // min
          this.min = TypeConvertor.castToString(value); // StringType
          return value;
        case 107876: // max
          this.max = TypeConvertor.castToString(value); // StringType
          return value;
        case -1109214266: // dependsOn
          this.dependsOn = TypeConvertor.castToString(value); // StringType
          return value;
        case 118167693: // localizedNames
          this.getLocalizedNamesList().add((TranslatedString) value); // TranslatedString
          return value;
        case 31568658: // localizedDescriptions
          this.getLocalizedDescriptionsList().add((TranslatedString) value); // TranslatedString
          return value;
        case -961709276: // annotations
          this.annotations = (Annotations) value; // Annotations
          return value;
        case -1252479343: // archetype_id
          this.archetype_id = TypeConvertor.castToString(value); // StringType
          return value;
        case -769141631: // aqlPath
          this.aqlPath = TypeConvertor.castToString(value); // StringType
          return value;
        case -1393315766: // custodian_namespace
          this.custodian_namespace = TypeConvertor.castToString(value); // StringType
          return value;
        case 525929355: // custodian_organisation
          this.custodian_organisation = TypeConvertor.castToString(value); // StringType
          return value;
        case -1486422201: // lifecycleState
          this.lifecycleState = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1611298707: // original_namespace
          this.original_namespace = TypeConvertor.castToString(value); // StringType
          return value;
        case -1416112882: // original_publisher
          this.original_publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 2145858559: // proportionTypes
          this.proportionTypes = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -260786213: // revision
          this.revision = TypeConvertor.castToString(value); // StringType
          return value;
        case 247635146: // inContext
          this.inContext = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1183866391: // inputs
          this.getInputsList().add((WebTemplateInput) value); // WebTemplateInput
          return value;
        case 1618255642: // termBindings
          this.getTermBindingsList().add((WebTemplateTermBinding) value); // WebTemplateTermBinding
          return value;
        case 1659526655: // children
          this.getChildrenList().add((WebTemplateItem) value); // WebTemplateItem
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("id")) {
          this.id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("depth")) {
          this.depth = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("localizedName")) {
          this.localizedName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("rmType")) {
          this.rmType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("nodeId")) {
          this.nodeId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("min")) {
          this.min = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("max")) {
          this.max = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("dependsOn")) {
          this.dependsOn = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("localizedNames")) {
          this.getLocalizedNamesList().add((TranslatedString) value); // TranslatedString
        } else if (name.equals("localizedDescriptions")) {
          this.getLocalizedDescriptionsList().add((TranslatedString) value); // TranslatedString
        } else if (name.equals("annotations")) {
          this.annotations = (Annotations) value; // Annotations
        } else if (name.equals("archetype_id")) {
          this.archetype_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("aqlPath")) {
          this.aqlPath = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("custodian_namespace")) {
          this.custodian_namespace = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("custodian_organisation")) {
          this.custodian_organisation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("lifecycleState")) {
          this.lifecycleState = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("original_namespace")) {
          this.original_namespace = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("original_publisher")) {
          this.original_publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("proportionTypes")) {
          this.proportionTypes = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("revision")) {
          this.revision = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("inContext")) {
          this.inContext = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("inputs")) {
          this.getInputsList().add((WebTemplateInput) value); // WebTemplateInput
        } else if (name.equals("termBindings")) {
          this.getTermBindingsList().add((WebTemplateTermBinding) value); // WebTemplateTermBinding
        } else if (name.equals("children")) {
          this.getChildrenList().add((WebTemplateItem) value); // WebTemplateItem
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3355:  return getIdElement();
        case 95472323:  return getDepthElement();
        case 3373707:  return getNameElement();
        case 696548518:  return getLocalizedNameElement();
        case -927957995:  return getRmTypeElement();
        case -1040171331:  return getNodeIdElement();
        case 108114:  return getMinElement();
        case 107876:  return getMaxElement();
        case -1109214266:  return getDependsOnElement();
        case 118167693:  return addLocalizedNames(); 
        case 31568658:  return addLocalizedDescriptions(); 
        case -961709276:  return getAnnotations();
        case -1252479343:  return getArchetype_idElement();
        case -769141631:  return getAqlPathElement();
        case -1393315766:  return getCustodian_namespaceElement();
        case 525929355:  return getCustodian_organisationElement();
        case -1486422201:  return getLifecycleStateElement();
        case -1611298707:  return getOriginal_namespaceElement();
        case -1416112882:  return getOriginal_publisherElement();
        case 2145858559:  return getProportionTypesElement();
        case -260786213:  return getRevisionElement();
        case 247635146:  return getInContextElement();
        case -1183866391:  return addInputs(); 
        case 1618255642:  return addTermBindings(); 
        case 1659526655:  return addChildren(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3355: /*id*/ return new String[] {"string"};
        case 95472323: /*depth*/ return new String[] {"integer"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 696548518: /*localizedName*/ return new String[] {"string"};
        case -927957995: /*rmType*/ return new String[] {"code"};
        case -1040171331: /*nodeId*/ return new String[] {"string"};
        case 108114: /*min*/ return new String[] {"string"};
        case 107876: /*max*/ return new String[] {"string"};
        case -1109214266: /*dependsOn*/ return new String[] {"string"};
        case 118167693: /*localizedNames*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TranslatedString"};
        case 31568658: /*localizedDescriptions*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TranslatedString"};
        case -961709276: /*annotations*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/Annotations"};
        case -1252479343: /*archetype_id*/ return new String[] {"string"};
        case -769141631: /*aqlPath*/ return new String[] {"string"};
        case -1393315766: /*custodian_namespace*/ return new String[] {"string"};
        case 525929355: /*custodian_organisation*/ return new String[] {"string"};
        case -1486422201: /*lifecycleState*/ return new String[] {"code"};
        case -1611298707: /*original_namespace*/ return new String[] {"string"};
        case -1416112882: /*original_publisher*/ return new String[] {"string"};
        case 2145858559: /*proportionTypes*/ return new String[] {"code"};
        case -260786213: /*revision*/ return new String[] {"string"};
        case 247635146: /*inContext*/ return new String[] {"boolean"};
        case -1183866391: /*inputs*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateInput"};
        case 1618255642: /*termBindings*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateTermBinding"};
        case 1659526655: /*children*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateItem"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("id")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.id");
        }
        else if (name.equals("depth")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.depth");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.name");
        }
        else if (name.equals("localizedName")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.localizedName");
        }
        else if (name.equals("rmType")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.rmType");
        }
        else if (name.equals("nodeId")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.nodeId");
        }
        else if (name.equals("min")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.min");
        }
        else if (name.equals("max")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.max");
        }
        else if (name.equals("dependsOn")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.dependsOn");
        }
        else if (name.equals("localizedNames")) {
          return addLocalizedNames();
        }
        else if (name.equals("localizedDescriptions")) {
          return addLocalizedDescriptions();
        }
        else if (name.equals("annotations")) {
          this.annotations = new Annotations();
          return this.annotations;
        }
        else if (name.equals("archetype_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.archetype_id");
        }
        else if (name.equals("aqlPath")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.aqlPath");
        }
        else if (name.equals("custodian_namespace")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.custodian_namespace");
        }
        else if (name.equals("custodian_organisation")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.custodian_organisation");
        }
        else if (name.equals("lifecycleState")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.lifecycleState");
        }
        else if (name.equals("original_namespace")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.original_namespace");
        }
        else if (name.equals("original_publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.original_publisher");
        }
        else if (name.equals("proportionTypes")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.proportionTypes");
        }
        else if (name.equals("revision")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.revision");
        }
        else if (name.equals("inContext")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateItem.inContext");
        }
        else if (name.equals("inputs")) {
          return addInputs();
        }
        else if (name.equals("termBindings")) {
          return addTermBindings();
        }
        else if (name.equals("children")) {
          return addChildren();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplateItem";

  }

      public WebTemplateItem copy() {
        WebTemplateItem dst = new WebTemplateItem();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplateItem dst) {
        super.copyValues(dst);
        dst.id = id == null ? null : id.copy();
        dst.depth = depth == null ? null : depth.copy();
        dst.name = name == null ? null : name.copy();
        dst.localizedName = localizedName == null ? null : localizedName.copy();
        dst.rmType = rmType == null ? null : rmType.copy();
        dst.nodeId = nodeId == null ? null : nodeId.copy();
        dst.min = min == null ? null : min.copy();
        dst.max = max == null ? null : max.copy();
        dst.dependsOn = dependsOn == null ? null : dependsOn.copy();
        if (localizedNamesList != null) {
          dst.localizedNamesList = new ArrayList<TranslatedString>();
          for (TranslatedString i : localizedNamesList)
            dst.localizedNamesList.add(i.copy());
        };
        if (localizedDescriptionsList != null) {
          dst.localizedDescriptionsList = new ArrayList<TranslatedString>();
          for (TranslatedString i : localizedDescriptionsList)
            dst.localizedDescriptionsList.add(i.copy());
        };
        dst.annotations = annotations == null ? null : annotations.copy();
        dst.archetype_id = archetype_id == null ? null : archetype_id.copy();
        dst.aqlPath = aqlPath == null ? null : aqlPath.copy();
        dst.custodian_namespace = custodian_namespace == null ? null : custodian_namespace.copy();
        dst.custodian_organisation = custodian_organisation == null ? null : custodian_organisation.copy();
        dst.lifecycleState = lifecycleState == null ? null : lifecycleState.copy();
        dst.original_namespace = original_namespace == null ? null : original_namespace.copy();
        dst.original_publisher = original_publisher == null ? null : original_publisher.copy();
        dst.proportionTypes = proportionTypes == null ? null : proportionTypes.copy();
        dst.revision = revision == null ? null : revision.copy();
        dst.inContext = inContext == null ? null : inContext.copy();
        if (inputsList != null) {
          dst.inputsList = new ArrayList<WebTemplateInput>();
          for (WebTemplateInput i : inputsList)
            dst.inputsList.add(i.copy());
        };
        if (termBindingsList != null) {
          dst.termBindingsList = new ArrayList<WebTemplateTermBinding>();
          for (WebTemplateTermBinding i : termBindingsList)
            dst.termBindingsList.add(i.copy());
        };
        if (childrenList != null) {
          dst.childrenList = new ArrayList<WebTemplateItem>();
          for (WebTemplateItem i : childrenList)
            dst.childrenList.add(i.copy());
        };
      }

      protected WebTemplateItem typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplateItem))
          return false;
        WebTemplateItem o = (WebTemplateItem) other_;
        return compareDeep(id, o.id, true) && compareDeep(depth, o.depth, true) && compareDeep(name, o.name, true)
           && compareDeep(localizedName, o.localizedName, true) && compareDeep(rmType, o.rmType, true) && compareDeep(nodeId, o.nodeId, true)
           && compareDeep(min, o.min, true) && compareDeep(max, o.max, true) && compareDeep(dependsOn, o.dependsOn, true)
           && compareDeep(localizedNamesList, o.localizedNamesList, true) && compareDeep(localizedDescriptionsList, o.localizedDescriptionsList, true)
           && compareDeep(annotations, o.annotations, true) && compareDeep(archetype_id, o.archetype_id, true)
           && compareDeep(aqlPath, o.aqlPath, true) && compareDeep(custodian_namespace, o.custodian_namespace, true)
           && compareDeep(custodian_organisation, o.custodian_organisation, true) && compareDeep(lifecycleState, o.lifecycleState, true)
           && compareDeep(original_namespace, o.original_namespace, true) && compareDeep(original_publisher, o.original_publisher, true)
           && compareDeep(proportionTypes, o.proportionTypes, true) && compareDeep(revision, o.revision, true)
           && compareDeep(inContext, o.inContext, true) && compareDeep(inputsList, o.inputsList, true) && compareDeep(termBindingsList, o.termBindingsList, true)
           && compareDeep(childrenList, o.childrenList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplateItem))
          return false;
        WebTemplateItem o = (WebTemplateItem) other_;
        return compareValues(id, o.id, true) && compareValues(depth, o.depth, true) && compareValues(name, o.name, true)
           && compareValues(localizedName, o.localizedName, true) && compareValues(rmType, o.rmType, true) && compareValues(nodeId, o.nodeId, true)
           && compareValues(min, o.min, true) && compareValues(max, o.max, true) && compareValues(dependsOn, o.dependsOn, true)
           && compareValues(archetype_id, o.archetype_id, true) && compareValues(aqlPath, o.aqlPath, true) && compareValues(custodian_namespace, o.custodian_namespace, true)
           && compareValues(custodian_organisation, o.custodian_organisation, true) && compareValues(lifecycleState, o.lifecycleState, true)
           && compareValues(original_namespace, o.original_namespace, true) && compareValues(original_publisher, o.original_publisher, true)
           && compareValues(proportionTypes, o.proportionTypes, true) && compareValues(revision, o.revision, true)
           && compareValues(inContext, o.inContext, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(id, depth, name, localizedName
          , rmType, nodeId, min, max, dependsOn, localizedNamesList, localizedDescriptionsList
          , annotations, archetype_id, aqlPath, custodian_namespace, custodian_organisation
          , lifecycleState, original_namespace, original_publisher, proportionTypes, revision
          , inContext, inputsList, termBindingsList, childrenList);
      }


}

