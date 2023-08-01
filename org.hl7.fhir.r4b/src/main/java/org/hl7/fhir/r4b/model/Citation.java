package org.hl7.fhir.r4b.model;

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

// Generated on Mon, Jun 13, 2022 17:19+0300 for FHIR v4.3.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r4b.model.Enumerations.*;
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
 * The Citation Resource enables reference to any knowledge artifact for
 * purposes of identification and attribution. The Citation Resource supports
 * existing reference structures and developing publication practices such as
 * versioning, expressing complex contributorship roles, and referencing
 * computable resources.
 */
@ResourceDef(name = "Citation", profile = "http://hl7.org/fhir/StructureDefinition/Citation")
public class Citation extends CanonicalResource {

  @Block()
  public static class CitationClassificationComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * The kind of classifier (e.g. publication type, keyword).
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The kind of classifier (e.g. publication type, keyword)", formalDefinition = "The kind of classifier (e.g. publication type, keyword).")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-classification-type")
    protected CodeableConcept type;

    /**
     * The specific classification value.
     */
    @Child(name = "classifier", type = {
        CodeableConcept.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The specific classification value", formalDefinition = "The specific classification value.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
    protected List<CodeableConcept> classifier;

    private static final long serialVersionUID = -283121869L;

    /**
     * Constructor
     */
    public CitationClassificationComponent() {
      super();
    }

    /**
     * @return {@link #type} (The kind of classifier (e.g. publication type,
     *         keyword).)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationClassificationComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The kind of classifier (e.g. publication type,
     *              keyword).)
     */
    public CitationClassificationComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #classifier} (The specific classification value.)
     */
    public List<CodeableConcept> getClassifier() {
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      return this.classifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationClassificationComponent setClassifier(List<CodeableConcept> theClassifier) {
      this.classifier = theClassifier;
      return this;
    }

    public boolean hasClassifier() {
      if (this.classifier == null)
        return false;
      for (CodeableConcept item : this.classifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addClassifier() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return t;
    }

    public CitationClassificationComponent addClassifier(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classifier}, creating
     *         it if it does not already exist {3}
     */
    public CodeableConcept getClassifierFirstRep() {
      if (getClassifier().isEmpty()) {
        addClassifier();
      }
      return getClassifier().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept", "The kind of classifier (e.g. publication type, keyword).",
          0, 1, type));
      children.add(new Property("classifier", "CodeableConcept", "The specific classification value.", 0,
          java.lang.Integer.MAX_VALUE, classifier));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "The kind of classifier (e.g. publication type, keyword).", 0, 1, type);
      case -281470431:
        /* classifier */ return new Property("classifier", "CodeableConcept", "The specific classification value.", 0,
            java.lang.Integer.MAX_VALUE, classifier);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -281470431:
        /* classifier */ return this.classifier == null ? new Base[0]
            : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -281470431: // classifier
        this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("classifier")) {
        this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case -281470431:
        return addClassifier();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -281470431:
        /* classifier */ return new String[] { "CodeableConcept" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("classifier")) {
        return addClassifier();
      } else
        return super.addChild(name);
    }

    public CitationClassificationComponent copy() {
      CitationClassificationComponent dst = new CitationClassificationComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationClassificationComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      if (classifier != null) {
        dst.classifier = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : classifier)
          dst.classifier.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationClassificationComponent))
        return false;
      CitationClassificationComponent o = (CitationClassificationComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationClassificationComponent))
        return false;
      CitationClassificationComponent o = (CitationClassificationComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classifier);
    }

    public String fhirType() {
      return "Citation.classification";

    }

  }

  @Block()
  public static class CitationStatusDateComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Classification of the status.
     */
    @Child(name = "activity", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Classification of the status", formalDefinition = "Classification of the status.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-status-type")
    protected CodeableConcept activity;

    /**
     * Either occurred or expected.
     */
    @Child(name = "actual", type = {
        BooleanType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Either occurred or expected", formalDefinition = "Either occurred or expected.")
    protected BooleanType actual;

    /**
     * When the status started and/or ended.
     */
    @Child(name = "period", type = { Period.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "When the status started and/or ended", formalDefinition = "When the status started and/or ended.")
    protected Period period;

    private static final long serialVersionUID = 1123586924L;

    /**
     * Constructor
     */
    public CitationStatusDateComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationStatusDateComponent(CodeableConcept activity, Period period) {
      super();
      this.setActivity(activity);
      this.setPeriod(period);
    }

    /**
     * @return {@link #activity} (Classification of the status.)
     */
    public CodeableConcept getActivity() {
      if (this.activity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationStatusDateComponent.activity");
        else if (Configuration.doAutoCreate())
          this.activity = new CodeableConcept(); // cc
      return this.activity;
    }

    public boolean hasActivity() {
      return this.activity != null && !this.activity.isEmpty();
    }

    /**
     * @param value {@link #activity} (Classification of the status.)
     */
    public CitationStatusDateComponent setActivity(CodeableConcept value) {
      this.activity = value;
      return this;
    }

    /**
     * @return {@link #actual} (Either occurred or expected.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getActual" gives direct access to the value
     */
    public BooleanType getActualElement() {
      if (this.actual == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationStatusDateComponent.actual");
        else if (Configuration.doAutoCreate())
          this.actual = new BooleanType(); // bb
      return this.actual;
    }

    public boolean hasActualElement() {
      return this.actual != null && !this.actual.isEmpty();
    }

    public boolean hasActual() {
      return this.actual != null && !this.actual.isEmpty();
    }

    /**
     * @param value {@link #actual} (Either occurred or expected.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getActual" gives direct access to the value
     */
    public CitationStatusDateComponent setActualElement(BooleanType value) {
      this.actual = value;
      return this;
    }

    /**
     * @return Either occurred or expected.
     */
    public boolean getActual() {
      return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
    }

    /**
     * @param value Either occurred or expected.
     */
    public CitationStatusDateComponent setActual(boolean value) {
      if (this.actual == null)
        this.actual = new BooleanType();
      this.actual.setValue(value);
      return this;
    }

    /**
     * @return {@link #period} (When the status started and/or ended.)
     */
    public Period getPeriod() {
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationStatusDateComponent.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() {
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (When the status started and/or ended.)
     */
    public CitationStatusDateComponent setPeriod(Period value) {
      this.period = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("activity", "CodeableConcept", "Classification of the status.", 0, 1, activity));
      children.add(new Property("actual", "boolean", "Either occurred or expected.", 0, 1, actual));
      children.add(new Property("period", "Period", "When the status started and/or ended.", 0, 1, period));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1655966961:
        /* activity */ return new Property("activity", "CodeableConcept", "Classification of the status.", 0, 1,
            activity);
      case -1422939762:
        /* actual */ return new Property("actual", "boolean", "Either occurred or expected.", 0, 1, actual);
      case -991726143:
        /* period */ return new Property("period", "Period", "When the status started and/or ended.", 0, 1, period);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1655966961:
        /* activity */ return this.activity == null ? new Base[0] : new Base[] { this.activity }; // CodeableConcept
      case -1422939762:
        /* actual */ return this.actual == null ? new Base[0] : new Base[] { this.actual }; // BooleanType
      case -991726143:
        /* period */ return this.period == null ? new Base[0] : new Base[] { this.period }; // Period
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1655966961: // activity
        this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1422939762: // actual
        this.actual = TypeConvertor.castToBoolean(value); // BooleanType
        return value;
      case -991726143: // period
        this.period = TypeConvertor.castToPeriod(value); // Period
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("activity")) {
        this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("actual")) {
        this.actual = TypeConvertor.castToBoolean(value); // BooleanType
      } else if (name.equals("period")) {
        this.period = TypeConvertor.castToPeriod(value); // Period
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1655966961:
        return getActivity();
      case -1422939762:
        return getActualElement();
      case -991726143:
        return getPeriod();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1655966961:
        /* activity */ return new String[] { "CodeableConcept" };
      case -1422939762:
        /* actual */ return new String[] { "boolean" };
      case -991726143:
        /* period */ return new String[] { "Period" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("activity")) {
        this.activity = new CodeableConcept();
        return this.activity;
      } else if (name.equals("actual")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.statusDate.actual");
      } else if (name.equals("period")) {
        this.period = new Period();
        return this.period;
      } else
        return super.addChild(name);
    }

    public CitationStatusDateComponent copy() {
      CitationStatusDateComponent dst = new CitationStatusDateComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationStatusDateComponent dst) {
      super.copyValues(dst);
      dst.activity = activity == null ? null : activity.copy();
      dst.actual = actual == null ? null : actual.copy();
      dst.period = period == null ? null : period.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationStatusDateComponent))
        return false;
      CitationStatusDateComponent o = (CitationStatusDateComponent) other_;
      return compareDeep(activity, o.activity, true) && compareDeep(actual, o.actual, true)
          && compareDeep(period, o.period, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationStatusDateComponent))
        return false;
      CitationStatusDateComponent o = (CitationStatusDateComponent) other_;
      return compareValues(actual, o.actual, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(activity, actual, period);
    }

    public String fhirType() {
      return "Citation.statusDate";

    }

  }

  @Block()
  public static class CitationRelatesToComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * How the Citation resource relates to the target artifact.
     */
    @Child(name = "relationshipType", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "How the Citation resource relates to the target artifact", formalDefinition = "How the Citation resource relates to the target artifact.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/artifact-relationship-type")
    protected CodeableConcept relationshipType;

    /**
     * The clasification of the related artifact.
     */
    @Child(name = "targetClassifier", type = {
        CodeableConcept.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The clasification of the related artifact", formalDefinition = "The clasification of the related artifact.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
    protected List<CodeableConcept> targetClassifier;

    /**
     * The article or artifact that the Citation Resource is related to.
     */
    @Child(name = "target", type = { UriType.class, Identifier.class, Reference.class,
        Attachment.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The article or artifact that the Citation Resource is related to", formalDefinition = "The article or artifact that the Citation Resource is related to.")
    protected DataType target;

    private static final long serialVersionUID = 819025047L;

    /**
     * Constructor
     */
    public CitationRelatesToComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationRelatesToComponent(CodeableConcept relationshipType, DataType target) {
      super();
      this.setRelationshipType(relationshipType);
      this.setTarget(target);
    }

    /**
     * @return {@link #relationshipType} (How the Citation resource relates to the
     *         target artifact.)
     */
    public CodeableConcept getRelationshipType() {
      if (this.relationshipType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationRelatesToComponent.relationshipType");
        else if (Configuration.doAutoCreate())
          this.relationshipType = new CodeableConcept(); // cc
      return this.relationshipType;
    }

    public boolean hasRelationshipType() {
      return this.relationshipType != null && !this.relationshipType.isEmpty();
    }

    /**
     * @param value {@link #relationshipType} (How the Citation resource relates to
     *              the target artifact.)
     */
    public CitationRelatesToComponent setRelationshipType(CodeableConcept value) {
      this.relationshipType = value;
      return this;
    }

    /**
     * @return {@link #targetClassifier} (The clasification of the related
     *         artifact.)
     */
    public List<CodeableConcept> getTargetClassifier() {
      if (this.targetClassifier == null)
        this.targetClassifier = new ArrayList<CodeableConcept>();
      return this.targetClassifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationRelatesToComponent setTargetClassifier(List<CodeableConcept> theTargetClassifier) {
      this.targetClassifier = theTargetClassifier;
      return this;
    }

    public boolean hasTargetClassifier() {
      if (this.targetClassifier == null)
        return false;
      for (CodeableConcept item : this.targetClassifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addTargetClassifier() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.targetClassifier == null)
        this.targetClassifier = new ArrayList<CodeableConcept>();
      this.targetClassifier.add(t);
      return t;
    }

    public CitationRelatesToComponent addTargetClassifier(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.targetClassifier == null)
        this.targetClassifier = new ArrayList<CodeableConcept>();
      this.targetClassifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #targetClassifier},
     *         creating it if it does not already exist {3}
     */
    public CodeableConcept getTargetClassifierFirstRep() {
      if (getTargetClassifier().isEmpty()) {
        addTargetClassifier();
      }
      return getTargetClassifier().get(0);
    }

    /**
     * @return {@link #target} (The article or artifact that the Citation Resource
     *         is related to.)
     */
    public DataType getTarget() {
      return this.target;
    }

    /**
     * @return {@link #target} (The article or artifact that the Citation Resource
     *         is related to.)
     */
    public UriType getTargetUriType() throws FHIRException {
      if (this.target == null)
        this.target = new UriType();
      if (!(this.target instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but " + this.target.getClass().getName()
            + " was encountered");
      return (UriType) this.target;
    }

    public boolean hasTargetUriType() {
      return this != null && this.target instanceof UriType;
    }

    /**
     * @return {@link #target} (The article or artifact that the Citation Resource
     *         is related to.)
     */
    public Identifier getTargetIdentifier() throws FHIRException {
      if (this.target == null)
        this.target = new Identifier();
      if (!(this.target instanceof Identifier))
        throw new FHIRException("Type mismatch: the type Identifier was expected, but "
            + this.target.getClass().getName() + " was encountered");
      return (Identifier) this.target;
    }

    public boolean hasTargetIdentifier() {
      return this != null && this.target instanceof Identifier;
    }

    /**
     * @return {@link #target} (The article or artifact that the Citation Resource
     *         is related to.)
     */
    public Reference getTargetReference() throws FHIRException {
      if (this.target == null)
        this.target = new Reference();
      if (!(this.target instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "
            + this.target.getClass().getName() + " was encountered");
      return (Reference) this.target;
    }

    public boolean hasTargetReference() {
      return this != null && this.target instanceof Reference;
    }

    /**
     * @return {@link #target} (The article or artifact that the Citation Resource
     *         is related to.)
     */
    public Attachment getTargetAttachment() throws FHIRException {
      if (this.target == null)
        this.target = new Attachment();
      if (!(this.target instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "
            + this.target.getClass().getName() + " was encountered");
      return (Attachment) this.target;
    }

    public boolean hasTargetAttachment() {
      return this != null && this.target instanceof Attachment;
    }

    public boolean hasTarget() {
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (The article or artifact that the Citation
     *              Resource is related to.)
     */
    public CitationRelatesToComponent setTarget(DataType value) {
      if (value != null && !(value instanceof UriType || value instanceof Identifier || value instanceof Reference
          || value instanceof Attachment))
        throw new Error("Not the right type for Citation.relatesTo.target[x]: " + value.fhirType());
      this.target = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("relationshipType", "CodeableConcept",
          "How the Citation resource relates to the target artifact.", 0, 1, relationshipType));
      children.add(new Property("targetClassifier", "CodeableConcept", "The clasification of the related artifact.", 0,
          java.lang.Integer.MAX_VALUE, targetClassifier));
      children.add(new Property("target[x]", "uri|Identifier|Reference(Any)|Attachment",
          "The article or artifact that the Citation Resource is related to.", 0, 1, target));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1602839150:
        /* relationshipType */ return new Property("relationshipType", "CodeableConcept",
            "How the Citation resource relates to the target artifact.", 0, 1, relationshipType);
      case -1267112302:
        /* targetClassifier */ return new Property("targetClassifier", "CodeableConcept",
            "The clasification of the related artifact.", 0, java.lang.Integer.MAX_VALUE, targetClassifier);
      case -815579825:
        /* target[x] */ return new Property("target[x]", "uri|Identifier|Reference(Any)|Attachment",
            "The article or artifact that the Citation Resource is related to.", 0, 1, target);
      case -880905839:
        /* target */ return new Property("target[x]", "uri|Identifier|Reference(Any)|Attachment",
            "The article or artifact that the Citation Resource is related to.", 0, 1, target);
      case -815585765:
        /* targetUri */ return new Property("target[x]", "uri",
            "The article or artifact that the Citation Resource is related to.", 0, 1, target);
      case 1690892570:
        /* targetIdentifier */ return new Property("target[x]", "Identifier",
            "The article or artifact that the Citation Resource is related to.", 0, 1, target);
      case 1259806906:
        /* targetReference */ return new Property("target[x]", "Reference(Any)",
            "The article or artifact that the Citation Resource is related to.", 0, 1, target);
      case 1345824148:
        /* targetAttachment */ return new Property("target[x]", "Attachment",
            "The article or artifact that the Citation Resource is related to.", 0, 1, target);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1602839150:
        /* relationshipType */ return this.relationshipType == null ? new Base[0]
            : new Base[] { this.relationshipType }; // CodeableConcept
      case -1267112302:
        /* targetClassifier */ return this.targetClassifier == null ? new Base[0]
            : this.targetClassifier.toArray(new Base[this.targetClassifier.size()]); // CodeableConcept
      case -880905839:
        /* target */ return this.target == null ? new Base[0] : new Base[] { this.target }; // DataType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1602839150: // relationshipType
        this.relationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1267112302: // targetClassifier
        this.getTargetClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case -880905839: // target
        this.target = TypeConvertor.castToType(value); // DataType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("relationshipType")) {
        this.relationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("targetClassifier")) {
        this.getTargetClassifier().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("target[x]")) {
        this.target = TypeConvertor.castToType(value); // DataType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1602839150:
        return getRelationshipType();
      case -1267112302:
        return addTargetClassifier();
      case -815579825:
        return getTarget();
      case -880905839:
        return getTarget();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1602839150:
        /* relationshipType */ return new String[] { "CodeableConcept" };
      case -1267112302:
        /* targetClassifier */ return new String[] { "CodeableConcept" };
      case -880905839:
        /* target */ return new String[] { "uri", "Identifier", "Reference", "Attachment" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("relationshipType")) {
        this.relationshipType = new CodeableConcept();
        return this.relationshipType;
      } else if (name.equals("targetClassifier")) {
        return addTargetClassifier();
      } else if (name.equals("targetUri")) {
        this.target = new UriType();
        return this.target;
      } else if (name.equals("targetIdentifier")) {
        this.target = new Identifier();
        return this.target;
      } else if (name.equals("targetReference")) {
        this.target = new Reference();
        return this.target;
      } else if (name.equals("targetAttachment")) {
        this.target = new Attachment();
        return this.target;
      } else
        return super.addChild(name);
    }

    public CitationRelatesToComponent copy() {
      CitationRelatesToComponent dst = new CitationRelatesToComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationRelatesToComponent dst) {
      super.copyValues(dst);
      dst.relationshipType = relationshipType == null ? null : relationshipType.copy();
      if (targetClassifier != null) {
        dst.targetClassifier = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : targetClassifier)
          dst.targetClassifier.add(i.copy());
      }
      ;
      dst.target = target == null ? null : target.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationRelatesToComponent))
        return false;
      CitationRelatesToComponent o = (CitationRelatesToComponent) other_;
      return compareDeep(relationshipType, o.relationshipType, true)
          && compareDeep(targetClassifier, o.targetClassifier, true) && compareDeep(target, o.target, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationRelatesToComponent))
        return false;
      CitationRelatesToComponent o = (CitationRelatesToComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(relationshipType, targetClassifier, target);
    }

    public String fhirType() {
      return "Citation.relatesTo";

    }

  }

  @Block()
  public static class CitationCitedArtifactComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * A formal identifier that is used to identify this citation when it is
     * represented in other formats, or referenced in a specification, model, design
     * or an instance.
     */
    @Child(name = "identifier", type = {
        Identifier.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "May include DOI, PMID, PMCID, etc.", formalDefinition = "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.")
    protected List<Identifier> identifier;

    /**
     * A formal identifier that is used to identify things closely related to this
     * citation.
     */
    @Child(name = "relatedIdentifier", type = {
        Identifier.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "May include trial registry identifiers", formalDefinition = "A formal identifier that is used to identify things closely related to this citation.")
    protected List<Identifier> relatedIdentifier;

    /**
     * When the cited artifact was accessed.
     */
    @Child(name = "dateAccessed", type = {
        DateTimeType.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "When the cited artifact was accessed", formalDefinition = "When the cited artifact was accessed.")
    protected DateTimeType dateAccessed;

    /**
     * The defined version of the cited artifact.
     */
    @Child(name = "version", type = {}, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The defined version of the cited artifact", formalDefinition = "The defined version of the cited artifact.")
    protected CitationCitedArtifactVersionComponent version;

    /**
     * The status of the cited artifact.
     */
    @Child(name = "currentState", type = {
        CodeableConcept.class }, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The status of the cited artifact", formalDefinition = "The status of the cited artifact.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/cited-artifact-status-type")
    protected List<CodeableConcept> currentState;

    /**
     * An effective date or period for a status of the cited artifact.
     */
    @Child(name = "statusDate", type = {}, order = 6, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "An effective date or period for a status of the cited artifact", formalDefinition = "An effective date or period for a status of the cited artifact.")
    protected List<CitationCitedArtifactStatusDateComponent> statusDate;

    /**
     * The title details of the article or artifact.
     */
    @Child(name = "title", type = {}, order = 7, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The title details of the article or artifact", formalDefinition = "The title details of the article or artifact.")
    protected List<CitationCitedArtifactTitleComponent> title;

    /**
     * Summary of the article or artifact.
     */
    @Child(name = "abstract", type = {}, order = 8, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Summary of the article or artifact", formalDefinition = "Summary of the article or artifact.")
    protected List<CitationCitedArtifactAbstractComponent> abstract_;

    /**
     * The component of the article or artifact.
     */
    @Child(name = "part", type = {}, order = 9, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The component of the article or artifact", formalDefinition = "The component of the article or artifact.")
    protected CitationCitedArtifactPartComponent part;

    /**
     * The artifact related to the cited artifact.
     */
    @Child(name = "relatesTo", type = {}, order = 10, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The artifact related to the cited artifact", formalDefinition = "The artifact related to the cited artifact.")
    protected List<CitationCitedArtifactRelatesToComponent> relatesTo;

    /**
     * If multiple, used to represent alternative forms of the article that are not
     * separate citations.
     */
    @Child(name = "publicationForm", type = {}, order = 11, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "If multiple, used to represent alternative forms of the article that are not separate citations", formalDefinition = "If multiple, used to represent alternative forms of the article that are not separate citations.")
    protected List<CitationCitedArtifactPublicationFormComponent> publicationForm;

    /**
     * Used for any URL for the article or artifact cited.
     */
    @Child(name = "webLocation", type = {}, order = 12, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Used for any URL for the article or artifact cited", formalDefinition = "Used for any URL for the article or artifact cited.")
    protected List<CitationCitedArtifactWebLocationComponent> webLocation;

    /**
     * The assignment to an organizing scheme.
     */
    @Child(name = "classification", type = {}, order = 13, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The assignment to an organizing scheme", formalDefinition = "The assignment to an organizing scheme.")
    protected List<CitationCitedArtifactClassificationComponent> classification;

    /**
     * This element is used to list authors and other contributors, their contact
     * information, specific contributions, and summary statements.
     */
    @Child(name = "contributorship", type = {}, order = 14, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Attribution of authors and other contributors", formalDefinition = "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.")
    protected CitationCitedArtifactContributorshipComponent contributorship;

    /**
     * Any additional information or content for the article or artifact.
     */
    @Child(name = "note", type = {
        Annotation.class }, order = 15, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Any additional information or content for the article or artifact", formalDefinition = "Any additional information or content for the article or artifact.")
    protected List<Annotation> note;

    private static final long serialVersionUID = -1685890486L;

    /**
     * Constructor
     */
    public CitationCitedArtifactComponent() {
      super();
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify
     *         this citation when it is represented in other formats, or referenced
     *         in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() {
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setIdentifier(List<Identifier> theIdentifier) {
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

    public Identifier addIdentifier() { // 3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addIdentifier(Identifier t) { // 3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating
     *         it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() {
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #relatedIdentifier} (A formal identifier that is used to
     *         identify things closely related to this citation.)
     */
    public List<Identifier> getRelatedIdentifier() {
      if (this.relatedIdentifier == null)
        this.relatedIdentifier = new ArrayList<Identifier>();
      return this.relatedIdentifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setRelatedIdentifier(List<Identifier> theRelatedIdentifier) {
      this.relatedIdentifier = theRelatedIdentifier;
      return this;
    }

    public boolean hasRelatedIdentifier() {
      if (this.relatedIdentifier == null)
        return false;
      for (Identifier item : this.relatedIdentifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addRelatedIdentifier() { // 3
      Identifier t = new Identifier();
      if (this.relatedIdentifier == null)
        this.relatedIdentifier = new ArrayList<Identifier>();
      this.relatedIdentifier.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addRelatedIdentifier(Identifier t) { // 3
      if (t == null)
        return this;
      if (this.relatedIdentifier == null)
        this.relatedIdentifier = new ArrayList<Identifier>();
      this.relatedIdentifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedIdentifier},
     *         creating it if it does not already exist {3}
     */
    public Identifier getRelatedIdentifierFirstRep() {
      if (getRelatedIdentifier().isEmpty()) {
        addRelatedIdentifier();
      }
      return getRelatedIdentifier().get(0);
    }

    /**
     * @return {@link #dateAccessed} (When the cited artifact was accessed.). This
     *         is the underlying object with id, value and extensions. The accessor
     *         "getDateAccessed" gives direct access to the value
     */
    public DateTimeType getDateAccessedElement() {
      if (this.dateAccessed == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactComponent.dateAccessed");
        else if (Configuration.doAutoCreate())
          this.dateAccessed = new DateTimeType(); // bb
      return this.dateAccessed;
    }

    public boolean hasDateAccessedElement() {
      return this.dateAccessed != null && !this.dateAccessed.isEmpty();
    }

    public boolean hasDateAccessed() {
      return this.dateAccessed != null && !this.dateAccessed.isEmpty();
    }

    /**
     * @param value {@link #dateAccessed} (When the cited artifact was accessed.).
     *              This is the underlying object with id, value and extensions. The
     *              accessor "getDateAccessed" gives direct access to the value
     */
    public CitationCitedArtifactComponent setDateAccessedElement(DateTimeType value) {
      this.dateAccessed = value;
      return this;
    }

    /**
     * @return When the cited artifact was accessed.
     */
    public Date getDateAccessed() {
      return this.dateAccessed == null ? null : this.dateAccessed.getValue();
    }

    /**
     * @param value When the cited artifact was accessed.
     */
    public CitationCitedArtifactComponent setDateAccessed(Date value) {
      if (value == null)
        this.dateAccessed = null;
      else {
        if (this.dateAccessed == null)
          this.dateAccessed = new DateTimeType();
        this.dateAccessed.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #version} (The defined version of the cited artifact.)
     */
    public CitationCitedArtifactVersionComponent getVersion() {
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactComponent.version");
        else if (Configuration.doAutoCreate())
          this.version = new CitationCitedArtifactVersionComponent(); // cc
      return this.version;
    }

    public boolean hasVersion() {
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (The defined version of the cited artifact.)
     */
    public CitationCitedArtifactComponent setVersion(CitationCitedArtifactVersionComponent value) {
      this.version = value;
      return this;
    }

    /**
     * @return {@link #currentState} (The status of the cited artifact.)
     */
    public List<CodeableConcept> getCurrentState() {
      if (this.currentState == null)
        this.currentState = new ArrayList<CodeableConcept>();
      return this.currentState;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setCurrentState(List<CodeableConcept> theCurrentState) {
      this.currentState = theCurrentState;
      return this;
    }

    public boolean hasCurrentState() {
      if (this.currentState == null)
        return false;
      for (CodeableConcept item : this.currentState)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCurrentState() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.currentState == null)
        this.currentState = new ArrayList<CodeableConcept>();
      this.currentState.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addCurrentState(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.currentState == null)
        this.currentState = new ArrayList<CodeableConcept>();
      this.currentState.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #currentState},
     *         creating it if it does not already exist {3}
     */
    public CodeableConcept getCurrentStateFirstRep() {
      if (getCurrentState().isEmpty()) {
        addCurrentState();
      }
      return getCurrentState().get(0);
    }

    /**
     * @return {@link #statusDate} (An effective date or period for a status of the
     *         cited artifact.)
     */
    public List<CitationCitedArtifactStatusDateComponent> getStatusDate() {
      if (this.statusDate == null)
        this.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
      return this.statusDate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setStatusDate(List<CitationCitedArtifactStatusDateComponent> theStatusDate) {
      this.statusDate = theStatusDate;
      return this;
    }

    public boolean hasStatusDate() {
      if (this.statusDate == null)
        return false;
      for (CitationCitedArtifactStatusDateComponent item : this.statusDate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactStatusDateComponent addStatusDate() { // 3
      CitationCitedArtifactStatusDateComponent t = new CitationCitedArtifactStatusDateComponent();
      if (this.statusDate == null)
        this.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
      this.statusDate.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addStatusDate(CitationCitedArtifactStatusDateComponent t) { // 3
      if (t == null)
        return this;
      if (this.statusDate == null)
        this.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
      this.statusDate.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statusDate}, creating
     *         it if it does not already exist {3}
     */
    public CitationCitedArtifactStatusDateComponent getStatusDateFirstRep() {
      if (getStatusDate().isEmpty()) {
        addStatusDate();
      }
      return getStatusDate().get(0);
    }

    /**
     * @return {@link #title} (The title details of the article or artifact.)
     */
    public List<CitationCitedArtifactTitleComponent> getTitle() {
      if (this.title == null)
        this.title = new ArrayList<CitationCitedArtifactTitleComponent>();
      return this.title;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setTitle(List<CitationCitedArtifactTitleComponent> theTitle) {
      this.title = theTitle;
      return this;
    }

    public boolean hasTitle() {
      if (this.title == null)
        return false;
      for (CitationCitedArtifactTitleComponent item : this.title)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactTitleComponent addTitle() { // 3
      CitationCitedArtifactTitleComponent t = new CitationCitedArtifactTitleComponent();
      if (this.title == null)
        this.title = new ArrayList<CitationCitedArtifactTitleComponent>();
      this.title.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addTitle(CitationCitedArtifactTitleComponent t) { // 3
      if (t == null)
        return this;
      if (this.title == null)
        this.title = new ArrayList<CitationCitedArtifactTitleComponent>();
      this.title.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #title}, creating it
     *         if it does not already exist {3}
     */
    public CitationCitedArtifactTitleComponent getTitleFirstRep() {
      if (getTitle().isEmpty()) {
        addTitle();
      }
      return getTitle().get(0);
    }

    /**
     * @return {@link #abstract_} (Summary of the article or artifact.)
     */
    public List<CitationCitedArtifactAbstractComponent> getAbstract() {
      if (this.abstract_ == null)
        this.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
      return this.abstract_;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setAbstract(List<CitationCitedArtifactAbstractComponent> theAbstract) {
      this.abstract_ = theAbstract;
      return this;
    }

    public boolean hasAbstract() {
      if (this.abstract_ == null)
        return false;
      for (CitationCitedArtifactAbstractComponent item : this.abstract_)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactAbstractComponent addAbstract() { // 3
      CitationCitedArtifactAbstractComponent t = new CitationCitedArtifactAbstractComponent();
      if (this.abstract_ == null)
        this.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
      this.abstract_.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addAbstract(CitationCitedArtifactAbstractComponent t) { // 3
      if (t == null)
        return this;
      if (this.abstract_ == null)
        this.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
      this.abstract_.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #abstract_}, creating
     *         it if it does not already exist {3}
     */
    public CitationCitedArtifactAbstractComponent getAbstractFirstRep() {
      if (getAbstract().isEmpty()) {
        addAbstract();
      }
      return getAbstract().get(0);
    }

    /**
     * @return {@link #part} (The component of the article or artifact.)
     */
    public CitationCitedArtifactPartComponent getPart() {
      if (this.part == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactComponent.part");
        else if (Configuration.doAutoCreate())
          this.part = new CitationCitedArtifactPartComponent(); // cc
      return this.part;
    }

    public boolean hasPart() {
      return this.part != null && !this.part.isEmpty();
    }

    /**
     * @param value {@link #part} (The component of the article or artifact.)
     */
    public CitationCitedArtifactComponent setPart(CitationCitedArtifactPartComponent value) {
      this.part = value;
      return this;
    }

    /**
     * @return {@link #relatesTo} (The artifact related to the cited artifact.)
     */
    public List<CitationCitedArtifactRelatesToComponent> getRelatesTo() {
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
      return this.relatesTo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setRelatesTo(List<CitationCitedArtifactRelatesToComponent> theRelatesTo) {
      this.relatesTo = theRelatesTo;
      return this;
    }

    public boolean hasRelatesTo() {
      if (this.relatesTo == null)
        return false;
      for (CitationCitedArtifactRelatesToComponent item : this.relatesTo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactRelatesToComponent addRelatesTo() { // 3
      CitationCitedArtifactRelatesToComponent t = new CitationCitedArtifactRelatesToComponent();
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
      this.relatesTo.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addRelatesTo(CitationCitedArtifactRelatesToComponent t) { // 3
      if (t == null)
        return this;
      if (this.relatesTo == null)
        this.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
      this.relatesTo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatesTo}, creating
     *         it if it does not already exist {3}
     */
    public CitationCitedArtifactRelatesToComponent getRelatesToFirstRep() {
      if (getRelatesTo().isEmpty()) {
        addRelatesTo();
      }
      return getRelatesTo().get(0);
    }

    /**
     * @return {@link #publicationForm} (If multiple, used to represent alternative
     *         forms of the article that are not separate citations.)
     */
    public List<CitationCitedArtifactPublicationFormComponent> getPublicationForm() {
      if (this.publicationForm == null)
        this.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
      return this.publicationForm;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setPublicationForm(
        List<CitationCitedArtifactPublicationFormComponent> thePublicationForm) {
      this.publicationForm = thePublicationForm;
      return this;
    }

    public boolean hasPublicationForm() {
      if (this.publicationForm == null)
        return false;
      for (CitationCitedArtifactPublicationFormComponent item : this.publicationForm)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactPublicationFormComponent addPublicationForm() { // 3
      CitationCitedArtifactPublicationFormComponent t = new CitationCitedArtifactPublicationFormComponent();
      if (this.publicationForm == null)
        this.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
      this.publicationForm.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addPublicationForm(CitationCitedArtifactPublicationFormComponent t) { // 3
      if (t == null)
        return this;
      if (this.publicationForm == null)
        this.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
      this.publicationForm.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #publicationForm},
     *         creating it if it does not already exist {3}
     */
    public CitationCitedArtifactPublicationFormComponent getPublicationFormFirstRep() {
      if (getPublicationForm().isEmpty()) {
        addPublicationForm();
      }
      return getPublicationForm().get(0);
    }

    /**
     * @return {@link #webLocation} (Used for any URL for the article or artifact
     *         cited.)
     */
    public List<CitationCitedArtifactWebLocationComponent> getWebLocation() {
      if (this.webLocation == null)
        this.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
      return this.webLocation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setWebLocation(
        List<CitationCitedArtifactWebLocationComponent> theWebLocation) {
      this.webLocation = theWebLocation;
      return this;
    }

    public boolean hasWebLocation() {
      if (this.webLocation == null)
        return false;
      for (CitationCitedArtifactWebLocationComponent item : this.webLocation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactWebLocationComponent addWebLocation() { // 3
      CitationCitedArtifactWebLocationComponent t = new CitationCitedArtifactWebLocationComponent();
      if (this.webLocation == null)
        this.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
      this.webLocation.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addWebLocation(CitationCitedArtifactWebLocationComponent t) { // 3
      if (t == null)
        return this;
      if (this.webLocation == null)
        this.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
      this.webLocation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #webLocation},
     *         creating it if it does not already exist {3}
     */
    public CitationCitedArtifactWebLocationComponent getWebLocationFirstRep() {
      if (getWebLocation().isEmpty()) {
        addWebLocation();
      }
      return getWebLocation().get(0);
    }

    /**
     * @return {@link #classification} (The assignment to an organizing scheme.)
     */
    public List<CitationCitedArtifactClassificationComponent> getClassification() {
      if (this.classification == null)
        this.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
      return this.classification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setClassification(
        List<CitationCitedArtifactClassificationComponent> theClassification) {
      this.classification = theClassification;
      return this;
    }

    public boolean hasClassification() {
      if (this.classification == null)
        return false;
      for (CitationCitedArtifactClassificationComponent item : this.classification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactClassificationComponent addClassification() { // 3
      CitationCitedArtifactClassificationComponent t = new CitationCitedArtifactClassificationComponent();
      if (this.classification == null)
        this.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
      this.classification.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addClassification(CitationCitedArtifactClassificationComponent t) { // 3
      if (t == null)
        return this;
      if (this.classification == null)
        this.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
      this.classification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classification},
     *         creating it if it does not already exist {3}
     */
    public CitationCitedArtifactClassificationComponent getClassificationFirstRep() {
      if (getClassification().isEmpty()) {
        addClassification();
      }
      return getClassification().get(0);
    }

    /**
     * @return {@link #contributorship} (This element is used to list authors and
     *         other contributors, their contact information, specific
     *         contributions, and summary statements.)
     */
    public CitationCitedArtifactContributorshipComponent getContributorship() {
      if (this.contributorship == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactComponent.contributorship");
        else if (Configuration.doAutoCreate())
          this.contributorship = new CitationCitedArtifactContributorshipComponent(); // cc
      return this.contributorship;
    }

    public boolean hasContributorship() {
      return this.contributorship != null && !this.contributorship.isEmpty();
    }

    /**
     * @param value {@link #contributorship} (This element is used to list authors
     *              and other contributors, their contact information, specific
     *              contributions, and summary statements.)
     */
    public CitationCitedArtifactComponent setContributorship(CitationCitedArtifactContributorshipComponent value) {
      this.contributorship = value;
      return this;
    }

    /**
     * @return {@link #note} (Any additional information or content for the article
     *         or artifact.)
     */
    public List<Annotation> getNote() {
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactComponent setNote(List<Annotation> theNote) {
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

    public Annotation addNote() { // 3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public CitationCitedArtifactComponent addNote(Annotation t) { // 3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if
     *         it does not already exist {3}
     */
    public Annotation getNoteFirstRep() {
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("identifier", "Identifier",
          "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.",
          0, java.lang.Integer.MAX_VALUE, identifier));
      children.add(new Property("relatedIdentifier", "Identifier",
          "A formal identifier that is used to identify things closely related to this citation.", 0,
          java.lang.Integer.MAX_VALUE, relatedIdentifier));
      children
          .add(new Property("dateAccessed", "dateTime", "When the cited artifact was accessed.", 0, 1, dateAccessed));
      children.add(new Property("version", "", "The defined version of the cited artifact.", 0, 1, version));
      children.add(new Property("currentState", "CodeableConcept", "The status of the cited artifact.", 0,
          java.lang.Integer.MAX_VALUE, currentState));
      children.add(new Property("statusDate", "", "An effective date or period for a status of the cited artifact.", 0,
          java.lang.Integer.MAX_VALUE, statusDate));
      children.add(new Property("title", "", "The title details of the article or artifact.", 0,
          java.lang.Integer.MAX_VALUE, title));
      children.add(new Property("abstract", "", "Summary of the article or artifact.", 0, java.lang.Integer.MAX_VALUE,
          abstract_));
      children.add(new Property("part", "", "The component of the article or artifact.", 0, 1, part));
      children.add(new Property("relatesTo", "", "The artifact related to the cited artifact.", 0,
          java.lang.Integer.MAX_VALUE, relatesTo));
      children.add(new Property("publicationForm", "",
          "If multiple, used to represent alternative forms of the article that are not separate citations.", 0,
          java.lang.Integer.MAX_VALUE, publicationForm));
      children.add(new Property("webLocation", "", "Used for any URL for the article or artifact cited.", 0,
          java.lang.Integer.MAX_VALUE, webLocation));
      children.add(new Property("classification", "", "The assignment to an organizing scheme.", 0,
          java.lang.Integer.MAX_VALUE, classification));
      children.add(new Property("contributorship", "",
          "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.",
          0, 1, contributorship));
      children.add(new Property("note", "Annotation",
          "Any additional information or content for the article or artifact.", 0, java.lang.Integer.MAX_VALUE, note));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1618432855:
        /* identifier */ return new Property("identifier", "Identifier",
            "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.",
            0, java.lang.Integer.MAX_VALUE, identifier);
      case -1007604940:
        /* relatedIdentifier */ return new Property("relatedIdentifier", "Identifier",
            "A formal identifier that is used to identify things closely related to this citation.", 0,
            java.lang.Integer.MAX_VALUE, relatedIdentifier);
      case 540917457:
        /* dateAccessed */ return new Property("dateAccessed", "dateTime", "When the cited artifact was accessed.", 0,
            1, dateAccessed);
      case 351608024:
        /* version */ return new Property("version", "", "The defined version of the cited artifact.", 0, 1, version);
      case 1457822360:
        /* currentState */ return new Property("currentState", "CodeableConcept", "The status of the cited artifact.",
            0, java.lang.Integer.MAX_VALUE, currentState);
      case 247524032:
        /* statusDate */ return new Property("statusDate", "",
            "An effective date or period for a status of the cited artifact.", 0, java.lang.Integer.MAX_VALUE,
            statusDate);
      case 110371416:
        /* title */ return new Property("title", "", "The title details of the article or artifact.", 0,
            java.lang.Integer.MAX_VALUE, title);
      case 1732898850:
        /* abstract */ return new Property("abstract", "", "Summary of the article or artifact.", 0,
            java.lang.Integer.MAX_VALUE, abstract_);
      case 3433459:
        /* part */ return new Property("part", "", "The component of the article or artifact.", 0, 1, part);
      case -7765931:
        /* relatesTo */ return new Property("relatesTo", "", "The artifact related to the cited artifact.", 0,
            java.lang.Integer.MAX_VALUE, relatesTo);
      case 1470639376:
        /* publicationForm */ return new Property("publicationForm", "",
            "If multiple, used to represent alternative forms of the article that are not separate citations.", 0,
            java.lang.Integer.MAX_VALUE, publicationForm);
      case -828032215:
        /* webLocation */ return new Property("webLocation", "", "Used for any URL for the article or artifact cited.",
            0, java.lang.Integer.MAX_VALUE, webLocation);
      case 382350310:
        /* classification */ return new Property("classification", "", "The assignment to an organizing scheme.", 0,
            java.lang.Integer.MAX_VALUE, classification);
      case 538727831:
        /* contributorship */ return new Property("contributorship", "",
            "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.",
            0, 1, contributorship);
      case 3387378:
        /* note */ return new Property("note", "Annotation",
            "Any additional information or content for the article or artifact.", 0, java.lang.Integer.MAX_VALUE, note);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1618432855:
        /* identifier */ return this.identifier == null ? new Base[0]
            : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
      case -1007604940:
        /* relatedIdentifier */ return this.relatedIdentifier == null ? new Base[0]
            : this.relatedIdentifier.toArray(new Base[this.relatedIdentifier.size()]); // Identifier
      case 540917457:
        /* dateAccessed */ return this.dateAccessed == null ? new Base[0] : new Base[] { this.dateAccessed }; // DateTimeType
      case 351608024:
        /* version */ return this.version == null ? new Base[0] : new Base[] { this.version }; // CitationCitedArtifactVersionComponent
      case 1457822360:
        /* currentState */ return this.currentState == null ? new Base[0]
            : this.currentState.toArray(new Base[this.currentState.size()]); // CodeableConcept
      case 247524032:
        /* statusDate */ return this.statusDate == null ? new Base[0]
            : this.statusDate.toArray(new Base[this.statusDate.size()]); // CitationCitedArtifactStatusDateComponent
      case 110371416:
        /* title */ return this.title == null ? new Base[0] : this.title.toArray(new Base[this.title.size()]); // CitationCitedArtifactTitleComponent
      case 1732898850:
        /* abstract */ return this.abstract_ == null ? new Base[0]
            : this.abstract_.toArray(new Base[this.abstract_.size()]); // CitationCitedArtifactAbstractComponent
      case 3433459:
        /* part */ return this.part == null ? new Base[0] : new Base[] { this.part }; // CitationCitedArtifactPartComponent
      case -7765931:
        /* relatesTo */ return this.relatesTo == null ? new Base[0]
            : this.relatesTo.toArray(new Base[this.relatesTo.size()]); // CitationCitedArtifactRelatesToComponent
      case 1470639376:
        /* publicationForm */ return this.publicationForm == null ? new Base[0]
            : this.publicationForm.toArray(new Base[this.publicationForm.size()]); // CitationCitedArtifactPublicationFormComponent
      case -828032215:
        /* webLocation */ return this.webLocation == null ? new Base[0]
            : this.webLocation.toArray(new Base[this.webLocation.size()]); // CitationCitedArtifactWebLocationComponent
      case 382350310:
        /* classification */ return this.classification == null ? new Base[0]
            : this.classification.toArray(new Base[this.classification.size()]); // CitationCitedArtifactClassificationComponent
      case 538727831:
        /* contributorship */ return this.contributorship == null ? new Base[0] : new Base[] { this.contributorship }; // CitationCitedArtifactContributorshipComponent
      case 3387378:
        /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1618432855: // identifier
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
        return value;
      case -1007604940: // relatedIdentifier
        this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
        return value;
      case 540917457: // dateAccessed
        this.dateAccessed = TypeConvertor.castToDateTime(value); // DateTimeType
        return value;
      case 351608024: // version
        this.version = (CitationCitedArtifactVersionComponent) value; // CitationCitedArtifactVersionComponent
        return value;
      case 1457822360: // currentState
        this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case 247524032: // statusDate
        this.getStatusDate().add((CitationCitedArtifactStatusDateComponent) value); // CitationCitedArtifactStatusDateComponent
        return value;
      case 110371416: // title
        this.getTitle().add((CitationCitedArtifactTitleComponent) value); // CitationCitedArtifactTitleComponent
        return value;
      case 1732898850: // abstract
        this.getAbstract().add((CitationCitedArtifactAbstractComponent) value); // CitationCitedArtifactAbstractComponent
        return value;
      case 3433459: // part
        this.part = (CitationCitedArtifactPartComponent) value; // CitationCitedArtifactPartComponent
        return value;
      case -7765931: // relatesTo
        this.getRelatesTo().add((CitationCitedArtifactRelatesToComponent) value); // CitationCitedArtifactRelatesToComponent
        return value;
      case 1470639376: // publicationForm
        this.getPublicationForm().add((CitationCitedArtifactPublicationFormComponent) value); // CitationCitedArtifactPublicationFormComponent
        return value;
      case -828032215: // webLocation
        this.getWebLocation().add((CitationCitedArtifactWebLocationComponent) value); // CitationCitedArtifactWebLocationComponent
        return value;
      case 382350310: // classification
        this.getClassification().add((CitationCitedArtifactClassificationComponent) value); // CitationCitedArtifactClassificationComponent
        return value;
      case 538727831: // contributorship
        this.contributorship = (CitationCitedArtifactContributorshipComponent) value; // CitationCitedArtifactContributorshipComponent
        return value;
      case 3387378: // note
        this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("identifier")) {
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
      } else if (name.equals("relatedIdentifier")) {
        this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value));
      } else if (name.equals("dateAccessed")) {
        this.dateAccessed = TypeConvertor.castToDateTime(value); // DateTimeType
      } else if (name.equals("version")) {
        this.version = (CitationCitedArtifactVersionComponent) value; // CitationCitedArtifactVersionComponent
      } else if (name.equals("currentState")) {
        this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("statusDate")) {
        this.getStatusDate().add((CitationCitedArtifactStatusDateComponent) value);
      } else if (name.equals("title")) {
        this.getTitle().add((CitationCitedArtifactTitleComponent) value);
      } else if (name.equals("abstract")) {
        this.getAbstract().add((CitationCitedArtifactAbstractComponent) value);
      } else if (name.equals("part")) {
        this.part = (CitationCitedArtifactPartComponent) value; // CitationCitedArtifactPartComponent
      } else if (name.equals("relatesTo")) {
        this.getRelatesTo().add((CitationCitedArtifactRelatesToComponent) value);
      } else if (name.equals("publicationForm")) {
        this.getPublicationForm().add((CitationCitedArtifactPublicationFormComponent) value);
      } else if (name.equals("webLocation")) {
        this.getWebLocation().add((CitationCitedArtifactWebLocationComponent) value);
      } else if (name.equals("classification")) {
        this.getClassification().add((CitationCitedArtifactClassificationComponent) value);
      } else if (name.equals("contributorship")) {
        this.contributorship = (CitationCitedArtifactContributorshipComponent) value; // CitationCitedArtifactContributorshipComponent
      } else if (name.equals("note")) {
        this.getNote().add(TypeConvertor.castToAnnotation(value));
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1618432855:
        return addIdentifier();
      case -1007604940:
        return addRelatedIdentifier();
      case 540917457:
        return getDateAccessedElement();
      case 351608024:
        return getVersion();
      case 1457822360:
        return addCurrentState();
      case 247524032:
        return addStatusDate();
      case 110371416:
        return addTitle();
      case 1732898850:
        return addAbstract();
      case 3433459:
        return getPart();
      case -7765931:
        return addRelatesTo();
      case 1470639376:
        return addPublicationForm();
      case -828032215:
        return addWebLocation();
      case 382350310:
        return addClassification();
      case 538727831:
        return getContributorship();
      case 3387378:
        return addNote();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1618432855:
        /* identifier */ return new String[] { "Identifier" };
      case -1007604940:
        /* relatedIdentifier */ return new String[] { "Identifier" };
      case 540917457:
        /* dateAccessed */ return new String[] { "dateTime" };
      case 351608024:
        /* version */ return new String[] {};
      case 1457822360:
        /* currentState */ return new String[] { "CodeableConcept" };
      case 247524032:
        /* statusDate */ return new String[] {};
      case 110371416:
        /* title */ return new String[] {};
      case 1732898850:
        /* abstract */ return new String[] {};
      case 3433459:
        /* part */ return new String[] {};
      case -7765931:
        /* relatesTo */ return new String[] {};
      case 1470639376:
        /* publicationForm */ return new String[] {};
      case -828032215:
        /* webLocation */ return new String[] {};
      case 382350310:
        /* classification */ return new String[] {};
      case 538727831:
        /* contributorship */ return new String[] {};
      case 3387378:
        /* note */ return new String[] { "Annotation" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("identifier")) {
        return addIdentifier();
      } else if (name.equals("relatedIdentifier")) {
        return addRelatedIdentifier();
      } else if (name.equals("dateAccessed")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.dateAccessed");
      } else if (name.equals("version")) {
        this.version = new CitationCitedArtifactVersionComponent();
        return this.version;
      } else if (name.equals("currentState")) {
        return addCurrentState();
      } else if (name.equals("statusDate")) {
        return addStatusDate();
      } else if (name.equals("title")) {
        return addTitle();
      } else if (name.equals("abstract")) {
        return addAbstract();
      } else if (name.equals("part")) {
        this.part = new CitationCitedArtifactPartComponent();
        return this.part;
      } else if (name.equals("relatesTo")) {
        return addRelatesTo();
      } else if (name.equals("publicationForm")) {
        return addPublicationForm();
      } else if (name.equals("webLocation")) {
        return addWebLocation();
      } else if (name.equals("classification")) {
        return addClassification();
      } else if (name.equals("contributorship")) {
        this.contributorship = new CitationCitedArtifactContributorshipComponent();
        return this.contributorship;
      } else if (name.equals("note")) {
        return addNote();
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactComponent copy() {
      CitationCitedArtifactComponent dst = new CitationCitedArtifactComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactComponent dst) {
      super.copyValues(dst);
      if (identifier != null) {
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
      }
      ;
      if (relatedIdentifier != null) {
        dst.relatedIdentifier = new ArrayList<Identifier>();
        for (Identifier i : relatedIdentifier)
          dst.relatedIdentifier.add(i.copy());
      }
      ;
      dst.dateAccessed = dateAccessed == null ? null : dateAccessed.copy();
      dst.version = version == null ? null : version.copy();
      if (currentState != null) {
        dst.currentState = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : currentState)
          dst.currentState.add(i.copy());
      }
      ;
      if (statusDate != null) {
        dst.statusDate = new ArrayList<CitationCitedArtifactStatusDateComponent>();
        for (CitationCitedArtifactStatusDateComponent i : statusDate)
          dst.statusDate.add(i.copy());
      }
      ;
      if (title != null) {
        dst.title = new ArrayList<CitationCitedArtifactTitleComponent>();
        for (CitationCitedArtifactTitleComponent i : title)
          dst.title.add(i.copy());
      }
      ;
      if (abstract_ != null) {
        dst.abstract_ = new ArrayList<CitationCitedArtifactAbstractComponent>();
        for (CitationCitedArtifactAbstractComponent i : abstract_)
          dst.abstract_.add(i.copy());
      }
      ;
      dst.part = part == null ? null : part.copy();
      if (relatesTo != null) {
        dst.relatesTo = new ArrayList<CitationCitedArtifactRelatesToComponent>();
        for (CitationCitedArtifactRelatesToComponent i : relatesTo)
          dst.relatesTo.add(i.copy());
      }
      ;
      if (publicationForm != null) {
        dst.publicationForm = new ArrayList<CitationCitedArtifactPublicationFormComponent>();
        for (CitationCitedArtifactPublicationFormComponent i : publicationForm)
          dst.publicationForm.add(i.copy());
      }
      ;
      if (webLocation != null) {
        dst.webLocation = new ArrayList<CitationCitedArtifactWebLocationComponent>();
        for (CitationCitedArtifactWebLocationComponent i : webLocation)
          dst.webLocation.add(i.copy());
      }
      ;
      if (classification != null) {
        dst.classification = new ArrayList<CitationCitedArtifactClassificationComponent>();
        for (CitationCitedArtifactClassificationComponent i : classification)
          dst.classification.add(i.copy());
      }
      ;
      dst.contributorship = contributorship == null ? null : contributorship.copy();
      if (note != null) {
        dst.note = new ArrayList<Annotation>();
        for (Annotation i : note)
          dst.note.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactComponent))
        return false;
      CitationCitedArtifactComponent o = (CitationCitedArtifactComponent) other_;
      return compareDeep(identifier, o.identifier, true) && compareDeep(relatedIdentifier, o.relatedIdentifier, true)
          && compareDeep(dateAccessed, o.dateAccessed, true) && compareDeep(version, o.version, true)
          && compareDeep(currentState, o.currentState, true) && compareDeep(statusDate, o.statusDate, true)
          && compareDeep(title, o.title, true) && compareDeep(abstract_, o.abstract_, true)
          && compareDeep(part, o.part, true) && compareDeep(relatesTo, o.relatesTo, true)
          && compareDeep(publicationForm, o.publicationForm, true) && compareDeep(webLocation, o.webLocation, true)
          && compareDeep(classification, o.classification, true)
          && compareDeep(contributorship, o.contributorship, true) && compareDeep(note, o.note, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactComponent))
        return false;
      CitationCitedArtifactComponent o = (CitationCitedArtifactComponent) other_;
      return compareValues(dateAccessed, o.dateAccessed, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, relatedIdentifier, dateAccessed,
          version, currentState, statusDate, title, abstract_, part, relatesTo, publicationForm, webLocation,
          classification, contributorship, note);
    }

    public String fhirType() {
      return "Citation.citedArtifact";

    }

  }

  @Block()
  public static class CitationCitedArtifactVersionComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * The version number or other version identifier.
     */
    @Child(name = "value", type = { StringType.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The version number or other version identifier", formalDefinition = "The version number or other version identifier.")
    protected StringType value;

    /**
     * Citation for the main version of the cited artifact.
     */
    @Child(name = "baseCitation", type = {
        Citation.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Citation for the main version of the cited artifact", formalDefinition = "Citation for the main version of the cited artifact.")
    protected Reference baseCitation;

    private static final long serialVersionUID = 1437090319L;

    /**
     * Constructor
     */
    public CitationCitedArtifactVersionComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactVersionComponent(String value) {
      super();
      this.setValue(value);
    }

    /**
     * @return {@link #value} (The version number or other version identifier.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getValue" gives direct access to the value
     */
    public StringType getValueElement() {
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactVersionComponent.value");
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
     * @param value {@link #value} (The version number or other version
     *              identifier.). This is the underlying object with id, value and
     *              extensions. The accessor "getValue" gives direct access to the
     *              value
     */
    public CitationCitedArtifactVersionComponent setValueElement(StringType value) {
      this.value = value;
      return this;
    }

    /**
     * @return The version number or other version identifier.
     */
    public String getValue() {
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value The version number or other version identifier.
     */
    public CitationCitedArtifactVersionComponent setValue(String value) {
      if (this.value == null)
        this.value = new StringType();
      this.value.setValue(value);
      return this;
    }

    /**
     * @return {@link #baseCitation} (Citation for the main version of the cited
     *         artifact.)
     */
    public Reference getBaseCitation() {
      if (this.baseCitation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactVersionComponent.baseCitation");
        else if (Configuration.doAutoCreate())
          this.baseCitation = new Reference(); // cc
      return this.baseCitation;
    }

    public boolean hasBaseCitation() {
      return this.baseCitation != null && !this.baseCitation.isEmpty();
    }

    /**
     * @param value {@link #baseCitation} (Citation for the main version of the
     *              cited artifact.)
     */
    public CitationCitedArtifactVersionComponent setBaseCitation(Reference value) {
      this.baseCitation = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("value", "string", "The version number or other version identifier.", 0, 1, value));
      children.add(new Property("baseCitation", "Reference(Citation)",
          "Citation for the main version of the cited artifact.", 0, 1, baseCitation));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 111972721:
        /* value */ return new Property("value", "string", "The version number or other version identifier.", 0, 1,
            value);
      case 1182995672:
        /* baseCitation */ return new Property("baseCitation", "Reference(Citation)",
            "Citation for the main version of the cited artifact.", 0, 1, baseCitation);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 111972721:
        /* value */ return this.value == null ? new Base[0] : new Base[] { this.value }; // StringType
      case 1182995672:
        /* baseCitation */ return this.baseCitation == null ? new Base[0] : new Base[] { this.baseCitation }; // Reference
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 111972721: // value
        this.value = TypeConvertor.castToString(value); // StringType
        return value;
      case 1182995672: // baseCitation
        this.baseCitation = TypeConvertor.castToReference(value); // Reference
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("value")) {
        this.value = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("baseCitation")) {
        this.baseCitation = TypeConvertor.castToReference(value); // Reference
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 111972721:
        return getValueElement();
      case 1182995672:
        return getBaseCitation();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 111972721:
        /* value */ return new String[] { "string" };
      case 1182995672:
        /* baseCitation */ return new String[] { "Reference" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("value")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.version.value");
      } else if (name.equals("baseCitation")) {
        this.baseCitation = new Reference();
        return this.baseCitation;
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactVersionComponent copy() {
      CitationCitedArtifactVersionComponent dst = new CitationCitedArtifactVersionComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactVersionComponent dst) {
      super.copyValues(dst);
      dst.value = value == null ? null : value.copy();
      dst.baseCitation = baseCitation == null ? null : baseCitation.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactVersionComponent))
        return false;
      CitationCitedArtifactVersionComponent o = (CitationCitedArtifactVersionComponent) other_;
      return compareDeep(value, o.value, true) && compareDeep(baseCitation, o.baseCitation, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactVersionComponent))
        return false;
      CitationCitedArtifactVersionComponent o = (CitationCitedArtifactVersionComponent) other_;
      return compareValues(value, o.value, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, baseCitation);
    }

    public String fhirType() {
      return "Citation.citedArtifact.version";

    }

  }

  @Block()
  public static class CitationCitedArtifactStatusDateComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Classification of the status.
     */
    @Child(name = "activity", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Classification of the status", formalDefinition = "Classification of the status.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/cited-artifact-status-type")
    protected CodeableConcept activity;

    /**
     * Either occurred or expected.
     */
    @Child(name = "actual", type = {
        BooleanType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Either occurred or expected", formalDefinition = "Either occurred or expected.")
    protected BooleanType actual;

    /**
     * When the status started and/or ended.
     */
    @Child(name = "period", type = { Period.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "When the status started and/or ended", formalDefinition = "When the status started and/or ended.")
    protected Period period;

    private static final long serialVersionUID = 1123586924L;

    /**
     * Constructor
     */
    public CitationCitedArtifactStatusDateComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactStatusDateComponent(CodeableConcept activity, Period period) {
      super();
      this.setActivity(activity);
      this.setPeriod(period);
    }

    /**
     * @return {@link #activity} (Classification of the status.)
     */
    public CodeableConcept getActivity() {
      if (this.activity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactStatusDateComponent.activity");
        else if (Configuration.doAutoCreate())
          this.activity = new CodeableConcept(); // cc
      return this.activity;
    }

    public boolean hasActivity() {
      return this.activity != null && !this.activity.isEmpty();
    }

    /**
     * @param value {@link #activity} (Classification of the status.)
     */
    public CitationCitedArtifactStatusDateComponent setActivity(CodeableConcept value) {
      this.activity = value;
      return this;
    }

    /**
     * @return {@link #actual} (Either occurred or expected.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getActual" gives direct access to the value
     */
    public BooleanType getActualElement() {
      if (this.actual == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactStatusDateComponent.actual");
        else if (Configuration.doAutoCreate())
          this.actual = new BooleanType(); // bb
      return this.actual;
    }

    public boolean hasActualElement() {
      return this.actual != null && !this.actual.isEmpty();
    }

    public boolean hasActual() {
      return this.actual != null && !this.actual.isEmpty();
    }

    /**
     * @param value {@link #actual} (Either occurred or expected.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getActual" gives direct access to the value
     */
    public CitationCitedArtifactStatusDateComponent setActualElement(BooleanType value) {
      this.actual = value;
      return this;
    }

    /**
     * @return Either occurred or expected.
     */
    public boolean getActual() {
      return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
    }

    /**
     * @param value Either occurred or expected.
     */
    public CitationCitedArtifactStatusDateComponent setActual(boolean value) {
      if (this.actual == null)
        this.actual = new BooleanType();
      this.actual.setValue(value);
      return this;
    }

    /**
     * @return {@link #period} (When the status started and/or ended.)
     */
    public Period getPeriod() {
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactStatusDateComponent.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() {
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (When the status started and/or ended.)
     */
    public CitationCitedArtifactStatusDateComponent setPeriod(Period value) {
      this.period = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("activity", "CodeableConcept", "Classification of the status.", 0, 1, activity));
      children.add(new Property("actual", "boolean", "Either occurred or expected.", 0, 1, actual));
      children.add(new Property("period", "Period", "When the status started and/or ended.", 0, 1, period));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1655966961:
        /* activity */ return new Property("activity", "CodeableConcept", "Classification of the status.", 0, 1,
            activity);
      case -1422939762:
        /* actual */ return new Property("actual", "boolean", "Either occurred or expected.", 0, 1, actual);
      case -991726143:
        /* period */ return new Property("period", "Period", "When the status started and/or ended.", 0, 1, period);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1655966961:
        /* activity */ return this.activity == null ? new Base[0] : new Base[] { this.activity }; // CodeableConcept
      case -1422939762:
        /* actual */ return this.actual == null ? new Base[0] : new Base[] { this.actual }; // BooleanType
      case -991726143:
        /* period */ return this.period == null ? new Base[0] : new Base[] { this.period }; // Period
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1655966961: // activity
        this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1422939762: // actual
        this.actual = TypeConvertor.castToBoolean(value); // BooleanType
        return value;
      case -991726143: // period
        this.period = TypeConvertor.castToPeriod(value); // Period
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("activity")) {
        this.activity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("actual")) {
        this.actual = TypeConvertor.castToBoolean(value); // BooleanType
      } else if (name.equals("period")) {
        this.period = TypeConvertor.castToPeriod(value); // Period
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1655966961:
        return getActivity();
      case -1422939762:
        return getActualElement();
      case -991726143:
        return getPeriod();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1655966961:
        /* activity */ return new String[] { "CodeableConcept" };
      case -1422939762:
        /* actual */ return new String[] { "boolean" };
      case -991726143:
        /* period */ return new String[] { "Period" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("activity")) {
        this.activity = new CodeableConcept();
        return this.activity;
      } else if (name.equals("actual")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.statusDate.actual");
      } else if (name.equals("period")) {
        this.period = new Period();
        return this.period;
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactStatusDateComponent copy() {
      CitationCitedArtifactStatusDateComponent dst = new CitationCitedArtifactStatusDateComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactStatusDateComponent dst) {
      super.copyValues(dst);
      dst.activity = activity == null ? null : activity.copy();
      dst.actual = actual == null ? null : actual.copy();
      dst.period = period == null ? null : period.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactStatusDateComponent))
        return false;
      CitationCitedArtifactStatusDateComponent o = (CitationCitedArtifactStatusDateComponent) other_;
      return compareDeep(activity, o.activity, true) && compareDeep(actual, o.actual, true)
          && compareDeep(period, o.period, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactStatusDateComponent))
        return false;
      CitationCitedArtifactStatusDateComponent o = (CitationCitedArtifactStatusDateComponent) other_;
      return compareValues(actual, o.actual, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(activity, actual, period);
    }

    public String fhirType() {
      return "Citation.citedArtifact.statusDate";

    }

  }

  @Block()
  public static class CitationCitedArtifactTitleComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Used to express the reason or specific aspect for the title.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The kind of title", formalDefinition = "Used to express the reason or specific aspect for the title.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/title-type")
    protected List<CodeableConcept> type;

    /**
     * Used to express the specific language.
     */
    @Child(name = "language", type = {
        CodeableConcept.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used to express the specific language", formalDefinition = "Used to express the specific language.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/languages")
    protected CodeableConcept language;

    /**
     * The title of the article or artifact.
     */
    @Child(name = "text", type = { MarkdownType.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The title of the article or artifact", formalDefinition = "The title of the article or artifact.")
    protected MarkdownType text;

    private static final long serialVersionUID = 1526221998L;

    /**
     * Constructor
     */
    public CitationCitedArtifactTitleComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactTitleComponent(String text) {
      super();
      this.setText(text);
    }

    /**
     * @return {@link #type} (Used to express the reason or specific aspect for the
     *         title.)
     */
    public List<CodeableConcept> getType() {
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactTitleComponent setType(List<CodeableConcept> theType) {
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

    public CodeableConcept addType() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return t;
    }

    public CitationCitedArtifactTitleComponent addType(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if
     *         it does not already exist {3}
     */
    public CodeableConcept getTypeFirstRep() {
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #language} (Used to express the specific language.)
     */
    public CodeableConcept getLanguage() {
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactTitleComponent.language");
        else if (Configuration.doAutoCreate())
          this.language = new CodeableConcept(); // cc
      return this.language;
    }

    public boolean hasLanguage() {
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Used to express the specific language.)
     */
    public CitationCitedArtifactTitleComponent setLanguage(CodeableConcept value) {
      this.language = value;
      return this;
    }

    /**
     * @return {@link #text} (The title of the article or artifact.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getText" gives direct access to the value
     */
    public MarkdownType getTextElement() {
      if (this.text == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactTitleComponent.text");
        else if (Configuration.doAutoCreate())
          this.text = new MarkdownType(); // bb
      return this.text;
    }

    public boolean hasTextElement() {
      return this.text != null && !this.text.isEmpty();
    }

    public boolean hasText() {
      return this.text != null && !this.text.isEmpty();
    }

    /**
     * @param value {@link #text} (The title of the article or artifact.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getText" gives direct access to the value
     */
    public CitationCitedArtifactTitleComponent setTextElement(MarkdownType value) {
      this.text = value;
      return this;
    }

    /**
     * @return The title of the article or artifact.
     */
    public String getText() {
      return this.text == null ? null : this.text.getValue();
    }

    /**
     * @param value The title of the article or artifact.
     */
    public CitationCitedArtifactTitleComponent setText(String value) {
      if (this.text == null)
        this.text = new MarkdownType();
      this.text.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept",
          "Used to express the reason or specific aspect for the title.", 0, java.lang.Integer.MAX_VALUE, type));
      children
          .add(new Property("language", "CodeableConcept", "Used to express the specific language.", 0, 1, language));
      children.add(new Property("text", "markdown", "The title of the article or artifact.", 0, 1, text));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "Used to express the reason or specific aspect for the title.", 0, java.lang.Integer.MAX_VALUE, type);
      case -1613589672:
        /* language */ return new Property("language", "CodeableConcept", "Used to express the specific language.", 0,
            1, language);
      case 3556653:
        /* text */ return new Property("text", "markdown", "The title of the article or artifact.", 0, 1, text);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
      case -1613589672:
        /* language */ return this.language == null ? new Base[0] : new Base[] { this.language }; // CodeableConcept
      case 3556653:
        /* text */ return this.text == null ? new Base[0] : new Base[] { this.text }; // MarkdownType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case -1613589672: // language
        this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 3556653: // text
        this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.getType().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("language")) {
        this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("text")) {
        this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return addType();
      case -1613589672:
        return getLanguage();
      case 3556653:
        return getTextElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -1613589672:
        /* language */ return new String[] { "CodeableConcept" };
      case 3556653:
        /* text */ return new String[] { "markdown" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        return addType();
      } else if (name.equals("language")) {
        this.language = new CodeableConcept();
        return this.language;
      } else if (name.equals("text")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.title.text");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactTitleComponent copy() {
      CitationCitedArtifactTitleComponent dst = new CitationCitedArtifactTitleComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactTitleComponent dst) {
      super.copyValues(dst);
      if (type != null) {
        dst.type = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : type)
          dst.type.add(i.copy());
      }
      ;
      dst.language = language == null ? null : language.copy();
      dst.text = text == null ? null : text.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactTitleComponent))
        return false;
      CitationCitedArtifactTitleComponent o = (CitationCitedArtifactTitleComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(language, o.language, true)
          && compareDeep(text, o.text, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactTitleComponent))
        return false;
      CitationCitedArtifactTitleComponent o = (CitationCitedArtifactTitleComponent) other_;
      return compareValues(text, o.text, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, language, text);
    }

    public String fhirType() {
      return "Citation.citedArtifact.title";

    }

  }

  @Block()
  public static class CitationCitedArtifactAbstractComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Used to express the reason or specific aspect for the abstract.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The kind of abstract", formalDefinition = "Used to express the reason or specific aspect for the abstract.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/cited-artifact-abstract-type")
    protected CodeableConcept type;

    /**
     * Used to express the specific language.
     */
    @Child(name = "language", type = {
        CodeableConcept.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used to express the specific language", formalDefinition = "Used to express the specific language.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/languages")
    protected CodeableConcept language;

    /**
     * Abstract content.
     */
    @Child(name = "text", type = { MarkdownType.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Abstract content", formalDefinition = "Abstract content.")
    protected MarkdownType text;

    /**
     * Copyright notice for the abstract.
     */
    @Child(name = "copyright", type = {
        MarkdownType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Copyright notice for the abstract", formalDefinition = "Copyright notice for the abstract.")
    protected MarkdownType copyright;

    private static final long serialVersionUID = -1882363442L;

    /**
     * Constructor
     */
    public CitationCitedArtifactAbstractComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactAbstractComponent(String text) {
      super();
      this.setText(text);
    }

    /**
     * @return {@link #type} (Used to express the reason or specific aspect for the
     *         abstract.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Used to express the reason or specific aspect for
     *              the abstract.)
     */
    public CitationCitedArtifactAbstractComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #language} (Used to express the specific language.)
     */
    public CodeableConcept getLanguage() {
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.language");
        else if (Configuration.doAutoCreate())
          this.language = new CodeableConcept(); // cc
      return this.language;
    }

    public boolean hasLanguage() {
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Used to express the specific language.)
     */
    public CitationCitedArtifactAbstractComponent setLanguage(CodeableConcept value) {
      this.language = value;
      return this;
    }

    /**
     * @return {@link #text} (Abstract content.). This is the underlying object with
     *         id, value and extensions. The accessor "getText" gives direct access
     *         to the value
     */
    public MarkdownType getTextElement() {
      if (this.text == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.text");
        else if (Configuration.doAutoCreate())
          this.text = new MarkdownType(); // bb
      return this.text;
    }

    public boolean hasTextElement() {
      return this.text != null && !this.text.isEmpty();
    }

    public boolean hasText() {
      return this.text != null && !this.text.isEmpty();
    }

    /**
     * @param value {@link #text} (Abstract content.). This is the underlying object
     *              with id, value and extensions. The accessor "getText" gives
     *              direct access to the value
     */
    public CitationCitedArtifactAbstractComponent setTextElement(MarkdownType value) {
      this.text = value;
      return this;
    }

    /**
     * @return Abstract content.
     */
    public String getText() {
      return this.text == null ? null : this.text.getValue();
    }

    /**
     * @param value Abstract content.
     */
    public CitationCitedArtifactAbstractComponent setText(String value) {
      if (this.text == null)
        this.text = new MarkdownType();
      this.text.setValue(value);
      return this;
    }

    /**
     * @return {@link #copyright} (Copyright notice for the abstract.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() {
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactAbstractComponent.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() {
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() {
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (Copyright notice for the abstract.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getCopyright" gives direct access to the value
     */
    public CitationCitedArtifactAbstractComponent setCopyrightElement(MarkdownType value) {
      this.copyright = value;
      return this;
    }

    /**
     * @return Copyright notice for the abstract.
     */
    public String getCopyright() {
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Copyright notice for the abstract.
     */
    public CitationCitedArtifactAbstractComponent setCopyright(String value) {
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept",
          "Used to express the reason or specific aspect for the abstract.", 0, 1, type));
      children
          .add(new Property("language", "CodeableConcept", "Used to express the specific language.", 0, 1, language));
      children.add(new Property("text", "markdown", "Abstract content.", 0, 1, text));
      children.add(new Property("copyright", "markdown", "Copyright notice for the abstract.", 0, 1, copyright));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "Used to express the reason or specific aspect for the abstract.", 0, 1, type);
      case -1613589672:
        /* language */ return new Property("language", "CodeableConcept", "Used to express the specific language.", 0,
            1, language);
      case 3556653:
        /* text */ return new Property("text", "markdown", "Abstract content.", 0, 1, text);
      case 1522889671:
        /* copyright */ return new Property("copyright", "markdown", "Copyright notice for the abstract.", 0, 1,
            copyright);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -1613589672:
        /* language */ return this.language == null ? new Base[0] : new Base[] { this.language }; // CodeableConcept
      case 3556653:
        /* text */ return this.text == null ? new Base[0] : new Base[] { this.text }; // MarkdownType
      case 1522889671:
        /* copyright */ return this.copyright == null ? new Base[0] : new Base[] { this.copyright }; // MarkdownType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1613589672: // language
        this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 3556653: // text
        this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
        return value;
      case 1522889671: // copyright
        this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("language")) {
        this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("text")) {
        this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
      } else if (name.equals("copyright")) {
        this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case -1613589672:
        return getLanguage();
      case 3556653:
        return getTextElement();
      case 1522889671:
        return getCopyrightElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -1613589672:
        /* language */ return new String[] { "CodeableConcept" };
      case 3556653:
        /* text */ return new String[] { "markdown" };
      case 1522889671:
        /* copyright */ return new String[] { "markdown" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("language")) {
        this.language = new CodeableConcept();
        return this.language;
      } else if (name.equals("text")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.abstract.text");
      } else if (name.equals("copyright")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.abstract.copyright");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactAbstractComponent copy() {
      CitationCitedArtifactAbstractComponent dst = new CitationCitedArtifactAbstractComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactAbstractComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      dst.language = language == null ? null : language.copy();
      dst.text = text == null ? null : text.copy();
      dst.copyright = copyright == null ? null : copyright.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactAbstractComponent))
        return false;
      CitationCitedArtifactAbstractComponent o = (CitationCitedArtifactAbstractComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(language, o.language, true)
          && compareDeep(text, o.text, true) && compareDeep(copyright, o.copyright, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactAbstractComponent))
        return false;
      CitationCitedArtifactAbstractComponent o = (CitationCitedArtifactAbstractComponent) other_;
      return compareValues(text, o.text, true) && compareValues(copyright, o.copyright, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, language, text, copyright);
    }

    public String fhirType() {
      return "Citation.citedArtifact.abstract";

    }

  }

  @Block()
  public static class CitationCitedArtifactPartComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * The kind of component.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The kind of component", formalDefinition = "The kind of component.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/cited-artifact-part-type")
    protected CodeableConcept type;

    /**
     * The specification of the component.
     */
    @Child(name = "value", type = { StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The specification of the component", formalDefinition = "The specification of the component.")
    protected StringType value;

    /**
     * The citation for the full article or artifact.
     */
    @Child(name = "baseCitation", type = {
        Citation.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The citation for the full article or artifact", formalDefinition = "The citation for the full article or artifact.")
    protected Reference baseCitation;

    private static final long serialVersionUID = -765350500L;

    /**
     * Constructor
     */
    public CitationCitedArtifactPartComponent() {
      super();
    }

    /**
     * @return {@link #type} (The kind of component.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPartComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The kind of component.)
     */
    public CitationCitedArtifactPartComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #value} (The specification of the component.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getValue" gives direct access to the value
     */
    public StringType getValueElement() {
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPartComponent.value");
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
     * @param value {@link #value} (The specification of the component.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getValue" gives direct access to the value
     */
    public CitationCitedArtifactPartComponent setValueElement(StringType value) {
      this.value = value;
      return this;
    }

    /**
     * @return The specification of the component.
     */
    public String getValue() {
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value The specification of the component.
     */
    public CitationCitedArtifactPartComponent setValue(String value) {
      if (Utilities.noString(value))
        this.value = null;
      else {
        if (this.value == null)
          this.value = new StringType();
        this.value.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #baseCitation} (The citation for the full article or
     *         artifact.)
     */
    public Reference getBaseCitation() {
      if (this.baseCitation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPartComponent.baseCitation");
        else if (Configuration.doAutoCreate())
          this.baseCitation = new Reference(); // cc
      return this.baseCitation;
    }

    public boolean hasBaseCitation() {
      return this.baseCitation != null && !this.baseCitation.isEmpty();
    }

    /**
     * @param value {@link #baseCitation} (The citation for the full article or
     *              artifact.)
     */
    public CitationCitedArtifactPartComponent setBaseCitation(Reference value) {
      this.baseCitation = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept", "The kind of component.", 0, 1, type));
      children.add(new Property("value", "string", "The specification of the component.", 0, 1, value));
      children.add(new Property("baseCitation", "Reference(Citation)", "The citation for the full article or artifact.",
          0, 1, baseCitation));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept", "The kind of component.", 0, 1, type);
      case 111972721:
        /* value */ return new Property("value", "string", "The specification of the component.", 0, 1, value);
      case 1182995672:
        /* baseCitation */ return new Property("baseCitation", "Reference(Citation)",
            "The citation for the full article or artifact.", 0, 1, baseCitation);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case 111972721:
        /* value */ return this.value == null ? new Base[0] : new Base[] { this.value }; // StringType
      case 1182995672:
        /* baseCitation */ return this.baseCitation == null ? new Base[0] : new Base[] { this.baseCitation }; // Reference
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 111972721: // value
        this.value = TypeConvertor.castToString(value); // StringType
        return value;
      case 1182995672: // baseCitation
        this.baseCitation = TypeConvertor.castToReference(value); // Reference
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("value")) {
        this.value = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("baseCitation")) {
        this.baseCitation = TypeConvertor.castToReference(value); // Reference
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case 111972721:
        return getValueElement();
      case 1182995672:
        return getBaseCitation();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case 111972721:
        /* value */ return new String[] { "string" };
      case 1182995672:
        /* baseCitation */ return new String[] { "Reference" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("value")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.part.value");
      } else if (name.equals("baseCitation")) {
        this.baseCitation = new Reference();
        return this.baseCitation;
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactPartComponent copy() {
      CitationCitedArtifactPartComponent dst = new CitationCitedArtifactPartComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactPartComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      dst.value = value == null ? null : value.copy();
      dst.baseCitation = baseCitation == null ? null : baseCitation.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPartComponent))
        return false;
      CitationCitedArtifactPartComponent o = (CitationCitedArtifactPartComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(value, o.value, true)
          && compareDeep(baseCitation, o.baseCitation, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPartComponent))
        return false;
      CitationCitedArtifactPartComponent o = (CitationCitedArtifactPartComponent) other_;
      return compareValues(value, o.value, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value, baseCitation);
    }

    public String fhirType() {
      return "Citation.citedArtifact.part";

    }

  }

  @Block()
  public static class CitationCitedArtifactRelatesToComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * How the cited artifact relates to the target artifact.
     */
    @Child(name = "relationshipType", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "How the cited artifact relates to the target artifact", formalDefinition = "How the cited artifact relates to the target artifact.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/artifact-relationship-type")
    protected CodeableConcept relationshipType;

    /**
     * The clasification of the related artifact.
     */
    @Child(name = "targetClassifier", type = {
        CodeableConcept.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The clasification of the related artifact", formalDefinition = "The clasification of the related artifact.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
    protected List<CodeableConcept> targetClassifier;

    /**
     * The article or artifact that the cited artifact is related to.
     */
    @Child(name = "target", type = { UriType.class, Identifier.class, Reference.class,
        Attachment.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The article or artifact that the cited artifact is related to", formalDefinition = "The article or artifact that the cited artifact is related to.")
    protected DataType target;

    private static final long serialVersionUID = 819025047L;

    /**
     * Constructor
     */
    public CitationCitedArtifactRelatesToComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactRelatesToComponent(CodeableConcept relationshipType, DataType target) {
      super();
      this.setRelationshipType(relationshipType);
      this.setTarget(target);
    }

    /**
     * @return {@link #relationshipType} (How the cited artifact relates to the
     *         target artifact.)
     */
    public CodeableConcept getRelationshipType() {
      if (this.relationshipType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactRelatesToComponent.relationshipType");
        else if (Configuration.doAutoCreate())
          this.relationshipType = new CodeableConcept(); // cc
      return this.relationshipType;
    }

    public boolean hasRelationshipType() {
      return this.relationshipType != null && !this.relationshipType.isEmpty();
    }

    /**
     * @param value {@link #relationshipType} (How the cited artifact relates to the
     *              target artifact.)
     */
    public CitationCitedArtifactRelatesToComponent setRelationshipType(CodeableConcept value) {
      this.relationshipType = value;
      return this;
    }

    /**
     * @return {@link #targetClassifier} (The clasification of the related
     *         artifact.)
     */
    public List<CodeableConcept> getTargetClassifier() {
      if (this.targetClassifier == null)
        this.targetClassifier = new ArrayList<CodeableConcept>();
      return this.targetClassifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactRelatesToComponent setTargetClassifier(List<CodeableConcept> theTargetClassifier) {
      this.targetClassifier = theTargetClassifier;
      return this;
    }

    public boolean hasTargetClassifier() {
      if (this.targetClassifier == null)
        return false;
      for (CodeableConcept item : this.targetClassifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addTargetClassifier() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.targetClassifier == null)
        this.targetClassifier = new ArrayList<CodeableConcept>();
      this.targetClassifier.add(t);
      return t;
    }

    public CitationCitedArtifactRelatesToComponent addTargetClassifier(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.targetClassifier == null)
        this.targetClassifier = new ArrayList<CodeableConcept>();
      this.targetClassifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #targetClassifier},
     *         creating it if it does not already exist {3}
     */
    public CodeableConcept getTargetClassifierFirstRep() {
      if (getTargetClassifier().isEmpty()) {
        addTargetClassifier();
      }
      return getTargetClassifier().get(0);
    }

    /**
     * @return {@link #target} (The article or artifact that the cited artifact is
     *         related to.)
     */
    public DataType getTarget() {
      return this.target;
    }

    /**
     * @return {@link #target} (The article or artifact that the cited artifact is
     *         related to.)
     */
    public UriType getTargetUriType() throws FHIRException {
      if (this.target == null)
        this.target = new UriType();
      if (!(this.target instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but " + this.target.getClass().getName()
            + " was encountered");
      return (UriType) this.target;
    }

    public boolean hasTargetUriType() {
      return this != null && this.target instanceof UriType;
    }

    /**
     * @return {@link #target} (The article or artifact that the cited artifact is
     *         related to.)
     */
    public Identifier getTargetIdentifier() throws FHIRException {
      if (this.target == null)
        this.target = new Identifier();
      if (!(this.target instanceof Identifier))
        throw new FHIRException("Type mismatch: the type Identifier was expected, but "
            + this.target.getClass().getName() + " was encountered");
      return (Identifier) this.target;
    }

    public boolean hasTargetIdentifier() {
      return this != null && this.target instanceof Identifier;
    }

    /**
     * @return {@link #target} (The article or artifact that the cited artifact is
     *         related to.)
     */
    public Reference getTargetReference() throws FHIRException {
      if (this.target == null)
        this.target = new Reference();
      if (!(this.target instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "
            + this.target.getClass().getName() + " was encountered");
      return (Reference) this.target;
    }

    public boolean hasTargetReference() {
      return this != null && this.target instanceof Reference;
    }

    /**
     * @return {@link #target} (The article or artifact that the cited artifact is
     *         related to.)
     */
    public Attachment getTargetAttachment() throws FHIRException {
      if (this.target == null)
        this.target = new Attachment();
      if (!(this.target instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "
            + this.target.getClass().getName() + " was encountered");
      return (Attachment) this.target;
    }

    public boolean hasTargetAttachment() {
      return this != null && this.target instanceof Attachment;
    }

    public boolean hasTarget() {
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (The article or artifact that the cited artifact
     *              is related to.)
     */
    public CitationCitedArtifactRelatesToComponent setTarget(DataType value) {
      if (value != null && !(value instanceof UriType || value instanceof Identifier || value instanceof Reference
          || value instanceof Attachment))
        throw new Error("Not the right type for Citation.citedArtifact.relatesTo.target[x]: " + value.fhirType());
      this.target = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("relationshipType", "CodeableConcept",
          "How the cited artifact relates to the target artifact.", 0, 1, relationshipType));
      children.add(new Property("targetClassifier", "CodeableConcept", "The clasification of the related artifact.", 0,
          java.lang.Integer.MAX_VALUE, targetClassifier));
      children.add(new Property("target[x]", "uri|Identifier|Reference(Any)|Attachment",
          "The article or artifact that the cited artifact is related to.", 0, 1, target));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1602839150:
        /* relationshipType */ return new Property("relationshipType", "CodeableConcept",
            "How the cited artifact relates to the target artifact.", 0, 1, relationshipType);
      case -1267112302:
        /* targetClassifier */ return new Property("targetClassifier", "CodeableConcept",
            "The clasification of the related artifact.", 0, java.lang.Integer.MAX_VALUE, targetClassifier);
      case -815579825:
        /* target[x] */ return new Property("target[x]", "uri|Identifier|Reference(Any)|Attachment",
            "The article or artifact that the cited artifact is related to.", 0, 1, target);
      case -880905839:
        /* target */ return new Property("target[x]", "uri|Identifier|Reference(Any)|Attachment",
            "The article or artifact that the cited artifact is related to.", 0, 1, target);
      case -815585765:
        /* targetUri */ return new Property("target[x]", "uri",
            "The article or artifact that the cited artifact is related to.", 0, 1, target);
      case 1690892570:
        /* targetIdentifier */ return new Property("target[x]", "Identifier",
            "The article or artifact that the cited artifact is related to.", 0, 1, target);
      case 1259806906:
        /* targetReference */ return new Property("target[x]", "Reference(Any)",
            "The article or artifact that the cited artifact is related to.", 0, 1, target);
      case 1345824148:
        /* targetAttachment */ return new Property("target[x]", "Attachment",
            "The article or artifact that the cited artifact is related to.", 0, 1, target);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1602839150:
        /* relationshipType */ return this.relationshipType == null ? new Base[0]
            : new Base[] { this.relationshipType }; // CodeableConcept
      case -1267112302:
        /* targetClassifier */ return this.targetClassifier == null ? new Base[0]
            : this.targetClassifier.toArray(new Base[this.targetClassifier.size()]); // CodeableConcept
      case -880905839:
        /* target */ return this.target == null ? new Base[0] : new Base[] { this.target }; // DataType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1602839150: // relationshipType
        this.relationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1267112302: // targetClassifier
        this.getTargetClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case -880905839: // target
        this.target = TypeConvertor.castToType(value); // DataType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("relationshipType")) {
        this.relationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("targetClassifier")) {
        this.getTargetClassifier().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("target[x]")) {
        this.target = TypeConvertor.castToType(value); // DataType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1602839150:
        return getRelationshipType();
      case -1267112302:
        return addTargetClassifier();
      case -815579825:
        return getTarget();
      case -880905839:
        return getTarget();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1602839150:
        /* relationshipType */ return new String[] { "CodeableConcept" };
      case -1267112302:
        /* targetClassifier */ return new String[] { "CodeableConcept" };
      case -880905839:
        /* target */ return new String[] { "uri", "Identifier", "Reference", "Attachment" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("relationshipType")) {
        this.relationshipType = new CodeableConcept();
        return this.relationshipType;
      } else if (name.equals("targetClassifier")) {
        return addTargetClassifier();
      } else if (name.equals("targetUri")) {
        this.target = new UriType();
        return this.target;
      } else if (name.equals("targetIdentifier")) {
        this.target = new Identifier();
        return this.target;
      } else if (name.equals("targetReference")) {
        this.target = new Reference();
        return this.target;
      } else if (name.equals("targetAttachment")) {
        this.target = new Attachment();
        return this.target;
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactRelatesToComponent copy() {
      CitationCitedArtifactRelatesToComponent dst = new CitationCitedArtifactRelatesToComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactRelatesToComponent dst) {
      super.copyValues(dst);
      dst.relationshipType = relationshipType == null ? null : relationshipType.copy();
      if (targetClassifier != null) {
        dst.targetClassifier = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : targetClassifier)
          dst.targetClassifier.add(i.copy());
      }
      ;
      dst.target = target == null ? null : target.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactRelatesToComponent))
        return false;
      CitationCitedArtifactRelatesToComponent o = (CitationCitedArtifactRelatesToComponent) other_;
      return compareDeep(relationshipType, o.relationshipType, true)
          && compareDeep(targetClassifier, o.targetClassifier, true) && compareDeep(target, o.target, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactRelatesToComponent))
        return false;
      CitationCitedArtifactRelatesToComponent o = (CitationCitedArtifactRelatesToComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(relationshipType, targetClassifier, target);
    }

    public String fhirType() {
      return "Citation.citedArtifact.relatesTo";

    }

  }

  @Block()
  public static class CitationCitedArtifactPublicationFormComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * The collection the cited article or artifact is published in.
     */
    @Child(name = "publishedIn", type = {}, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The collection the cited article or artifact is published in", formalDefinition = "The collection the cited article or artifact is published in.")
    protected CitationCitedArtifactPublicationFormPublishedInComponent publishedIn;

    /**
     * The specific issue in which the cited article resides.
     */
    @Child(name = "periodicRelease", type = {}, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The specific issue in which the cited article resides", formalDefinition = "The specific issue in which the cited article resides.")
    protected CitationCitedArtifactPublicationFormPeriodicReleaseComponent periodicRelease;

    /**
     * The date the article was added to the database, or the date the article was
     * released (which may differ from the journal issue publication date).
     */
    @Child(name = "articleDate", type = {
        DateTimeType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The date the article was added to the database, or the date the article was released", formalDefinition = "The date the article was added to the database, or the date the article was released (which may differ from the journal issue publication date).")
    protected DateTimeType articleDate;

    /**
     * The date the article was last revised or updated in the database.
     */
    @Child(name = "lastRevisionDate", type = {
        DateTimeType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The date the article was last revised or updated in the database", formalDefinition = "The date the article was last revised or updated in the database.")
    protected DateTimeType lastRevisionDate;

    /**
     * Language in which this form of the article is published.
     */
    @Child(name = "language", type = {
        CodeableConcept.class }, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Language in which this form of the article is published", formalDefinition = "Language in which this form of the article is published.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/languages")
    protected List<CodeableConcept> language;

    /**
     * Entry number or identifier for inclusion in a database.
     */
    @Child(name = "accessionNumber", type = {
        StringType.class }, order = 6, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Entry number or identifier for inclusion in a database", formalDefinition = "Entry number or identifier for inclusion in a database.")
    protected StringType accessionNumber;

    /**
     * Used for full display of pagination.
     */
    @Child(name = "pageString", type = {
        StringType.class }, order = 7, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used for full display of pagination", formalDefinition = "Used for full display of pagination.")
    protected StringType pageString;

    /**
     * Used for isolated representation of first page.
     */
    @Child(name = "firstPage", type = {
        StringType.class }, order = 8, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used for isolated representation of first page", formalDefinition = "Used for isolated representation of first page.")
    protected StringType firstPage;

    /**
     * Used for isolated representation of last page.
     */
    @Child(name = "lastPage", type = {
        StringType.class }, order = 9, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used for isolated representation of last page", formalDefinition = "Used for isolated representation of last page.")
    protected StringType lastPage;

    /**
     * Actual or approximate number of pages or screens.
     */
    @Child(name = "pageCount", type = {
        StringType.class }, order = 10, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Number of pages or screens", formalDefinition = "Actual or approximate number of pages or screens.")
    protected StringType pageCount;

    /**
     * Copyright notice for the full article or artifact.
     */
    @Child(name = "copyright", type = {
        MarkdownType.class }, order = 11, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Copyright notice for the full article or artifact", formalDefinition = "Copyright notice for the full article or artifact.")
    protected MarkdownType copyright;

    private static final long serialVersionUID = -191740896L;

    /**
     * Constructor
     */
    public CitationCitedArtifactPublicationFormComponent() {
      super();
    }

    /**
     * @return {@link #publishedIn} (The collection the cited article or artifact is
     *         published in.)
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent getPublishedIn() {
      if (this.publishedIn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.publishedIn");
        else if (Configuration.doAutoCreate())
          this.publishedIn = new CitationCitedArtifactPublicationFormPublishedInComponent(); // cc
      return this.publishedIn;
    }

    public boolean hasPublishedIn() {
      return this.publishedIn != null && !this.publishedIn.isEmpty();
    }

    /**
     * @param value {@link #publishedIn} (The collection the cited article or
     *              artifact is published in.)
     */
    public CitationCitedArtifactPublicationFormComponent setPublishedIn(
        CitationCitedArtifactPublicationFormPublishedInComponent value) {
      this.publishedIn = value;
      return this;
    }

    /**
     * @return {@link #periodicRelease} (The specific issue in which the cited
     *         article resides.)
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent getPeriodicRelease() {
      if (this.periodicRelease == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.periodicRelease");
        else if (Configuration.doAutoCreate())
          this.periodicRelease = new CitationCitedArtifactPublicationFormPeriodicReleaseComponent(); // cc
      return this.periodicRelease;
    }

    public boolean hasPeriodicRelease() {
      return this.periodicRelease != null && !this.periodicRelease.isEmpty();
    }

    /**
     * @param value {@link #periodicRelease} (The specific issue in which the cited
     *              article resides.)
     */
    public CitationCitedArtifactPublicationFormComponent setPeriodicRelease(
        CitationCitedArtifactPublicationFormPeriodicReleaseComponent value) {
      this.periodicRelease = value;
      return this;
    }

    /**
     * @return {@link #articleDate} (The date the article was added to the database,
     *         or the date the article was released (which may differ from the
     *         journal issue publication date).). This is the underlying object with
     *         id, value and extensions. The accessor "getArticleDate" gives direct
     *         access to the value
     */
    public DateTimeType getArticleDateElement() {
      if (this.articleDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.articleDate");
        else if (Configuration.doAutoCreate())
          this.articleDate = new DateTimeType(); // bb
      return this.articleDate;
    }

    public boolean hasArticleDateElement() {
      return this.articleDate != null && !this.articleDate.isEmpty();
    }

    public boolean hasArticleDate() {
      return this.articleDate != null && !this.articleDate.isEmpty();
    }

    /**
     * @param value {@link #articleDate} (The date the article was added to the
     *              database, or the date the article was released (which may differ
     *              from the journal issue publication date).). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getArticleDate" gives direct access to the value
     */
    public CitationCitedArtifactPublicationFormComponent setArticleDateElement(DateTimeType value) {
      this.articleDate = value;
      return this;
    }

    /**
     * @return The date the article was added to the database, or the date the
     *         article was released (which may differ from the journal issue
     *         publication date).
     */
    public Date getArticleDate() {
      return this.articleDate == null ? null : this.articleDate.getValue();
    }

    /**
     * @param value The date the article was added to the database, or the date the
     *              article was released (which may differ from the journal issue
     *              publication date).
     */
    public CitationCitedArtifactPublicationFormComponent setArticleDate(Date value) {
      if (value == null)
        this.articleDate = null;
      else {
        if (this.articleDate == null)
          this.articleDate = new DateTimeType();
        this.articleDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastRevisionDate} (The date the article was last revised or
     *         updated in the database.). This is the underlying object with id,
     *         value and extensions. The accessor "getLastRevisionDate" gives direct
     *         access to the value
     */
    public DateTimeType getLastRevisionDateElement() {
      if (this.lastRevisionDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.lastRevisionDate");
        else if (Configuration.doAutoCreate())
          this.lastRevisionDate = new DateTimeType(); // bb
      return this.lastRevisionDate;
    }

    public boolean hasLastRevisionDateElement() {
      return this.lastRevisionDate != null && !this.lastRevisionDate.isEmpty();
    }

    public boolean hasLastRevisionDate() {
      return this.lastRevisionDate != null && !this.lastRevisionDate.isEmpty();
    }

    /**
     * @param value {@link #lastRevisionDate} (The date the article was last revised
     *              or updated in the database.). This is the underlying object with
     *              id, value and extensions. The accessor "getLastRevisionDate"
     *              gives direct access to the value
     */
    public CitationCitedArtifactPublicationFormComponent setLastRevisionDateElement(DateTimeType value) {
      this.lastRevisionDate = value;
      return this;
    }

    /**
     * @return The date the article was last revised or updated in the database.
     */
    public Date getLastRevisionDate() {
      return this.lastRevisionDate == null ? null : this.lastRevisionDate.getValue();
    }

    /**
     * @param value The date the article was last revised or updated in the
     *              database.
     */
    public CitationCitedArtifactPublicationFormComponent setLastRevisionDate(Date value) {
      if (value == null)
        this.lastRevisionDate = null;
      else {
        if (this.lastRevisionDate == null)
          this.lastRevisionDate = new DateTimeType();
        this.lastRevisionDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #language} (Language in which this form of the article is
     *         published.)
     */
    public List<CodeableConcept> getLanguage() {
      if (this.language == null)
        this.language = new ArrayList<CodeableConcept>();
      return this.language;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactPublicationFormComponent setLanguage(List<CodeableConcept> theLanguage) {
      this.language = theLanguage;
      return this;
    }

    public boolean hasLanguage() {
      if (this.language == null)
        return false;
      for (CodeableConcept item : this.language)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addLanguage() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.language == null)
        this.language = new ArrayList<CodeableConcept>();
      this.language.add(t);
      return t;
    }

    public CitationCitedArtifactPublicationFormComponent addLanguage(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.language == null)
        this.language = new ArrayList<CodeableConcept>();
      this.language.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #language}, creating
     *         it if it does not already exist {3}
     */
    public CodeableConcept getLanguageFirstRep() {
      if (getLanguage().isEmpty()) {
        addLanguage();
      }
      return getLanguage().get(0);
    }

    /**
     * @return {@link #accessionNumber} (Entry number or identifier for inclusion in
     *         a database.). This is the underlying object with id, value and
     *         extensions. The accessor "getAccessionNumber" gives direct access to
     *         the value
     */
    public StringType getAccessionNumberElement() {
      if (this.accessionNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.accessionNumber");
        else if (Configuration.doAutoCreate())
          this.accessionNumber = new StringType(); // bb
      return this.accessionNumber;
    }

    public boolean hasAccessionNumberElement() {
      return this.accessionNumber != null && !this.accessionNumber.isEmpty();
    }

    public boolean hasAccessionNumber() {
      return this.accessionNumber != null && !this.accessionNumber.isEmpty();
    }

    /**
     * @param value {@link #accessionNumber} (Entry number or identifier for
     *              inclusion in a database.). This is the underlying object with
     *              id, value and extensions. The accessor "getAccessionNumber"
     *              gives direct access to the value
     */
    public CitationCitedArtifactPublicationFormComponent setAccessionNumberElement(StringType value) {
      this.accessionNumber = value;
      return this;
    }

    /**
     * @return Entry number or identifier for inclusion in a database.
     */
    public String getAccessionNumber() {
      return this.accessionNumber == null ? null : this.accessionNumber.getValue();
    }

    /**
     * @param value Entry number or identifier for inclusion in a database.
     */
    public CitationCitedArtifactPublicationFormComponent setAccessionNumber(String value) {
      if (Utilities.noString(value))
        this.accessionNumber = null;
      else {
        if (this.accessionNumber == null)
          this.accessionNumber = new StringType();
        this.accessionNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #pageString} (Used for full display of pagination.). This is
     *         the underlying object with id, value and extensions. The accessor
     *         "getPageString" gives direct access to the value
     */
    public StringType getPageStringElement() {
      if (this.pageString == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.pageString");
        else if (Configuration.doAutoCreate())
          this.pageString = new StringType(); // bb
      return this.pageString;
    }

    public boolean hasPageStringElement() {
      return this.pageString != null && !this.pageString.isEmpty();
    }

    public boolean hasPageString() {
      return this.pageString != null && !this.pageString.isEmpty();
    }

    /**
     * @param value {@link #pageString} (Used for full display of pagination.). This
     *              is the underlying object with id, value and extensions. The
     *              accessor "getPageString" gives direct access to the value
     */
    public CitationCitedArtifactPublicationFormComponent setPageStringElement(StringType value) {
      this.pageString = value;
      return this;
    }

    /**
     * @return Used for full display of pagination.
     */
    public String getPageString() {
      return this.pageString == null ? null : this.pageString.getValue();
    }

    /**
     * @param value Used for full display of pagination.
     */
    public CitationCitedArtifactPublicationFormComponent setPageString(String value) {
      if (Utilities.noString(value))
        this.pageString = null;
      else {
        if (this.pageString == null)
          this.pageString = new StringType();
        this.pageString.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #firstPage} (Used for isolated representation of first page.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getFirstPage" gives direct access to the value
     */
    public StringType getFirstPageElement() {
      if (this.firstPage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.firstPage");
        else if (Configuration.doAutoCreate())
          this.firstPage = new StringType(); // bb
      return this.firstPage;
    }

    public boolean hasFirstPageElement() {
      return this.firstPage != null && !this.firstPage.isEmpty();
    }

    public boolean hasFirstPage() {
      return this.firstPage != null && !this.firstPage.isEmpty();
    }

    /**
     * @param value {@link #firstPage} (Used for isolated representation of first
     *              page.). This is the underlying object with id, value and
     *              extensions. The accessor "getFirstPage" gives direct access to
     *              the value
     */
    public CitationCitedArtifactPublicationFormComponent setFirstPageElement(StringType value) {
      this.firstPage = value;
      return this;
    }

    /**
     * @return Used for isolated representation of first page.
     */
    public String getFirstPage() {
      return this.firstPage == null ? null : this.firstPage.getValue();
    }

    /**
     * @param value Used for isolated representation of first page.
     */
    public CitationCitedArtifactPublicationFormComponent setFirstPage(String value) {
      if (Utilities.noString(value))
        this.firstPage = null;
      else {
        if (this.firstPage == null)
          this.firstPage = new StringType();
        this.firstPage.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastPage} (Used for isolated representation of last page.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getLastPage" gives direct access to the value
     */
    public StringType getLastPageElement() {
      if (this.lastPage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.lastPage");
        else if (Configuration.doAutoCreate())
          this.lastPage = new StringType(); // bb
      return this.lastPage;
    }

    public boolean hasLastPageElement() {
      return this.lastPage != null && !this.lastPage.isEmpty();
    }

    public boolean hasLastPage() {
      return this.lastPage != null && !this.lastPage.isEmpty();
    }

    /**
     * @param value {@link #lastPage} (Used for isolated representation of last
     *              page.). This is the underlying object with id, value and
     *              extensions. The accessor "getLastPage" gives direct access to
     *              the value
     */
    public CitationCitedArtifactPublicationFormComponent setLastPageElement(StringType value) {
      this.lastPage = value;
      return this;
    }

    /**
     * @return Used for isolated representation of last page.
     */
    public String getLastPage() {
      return this.lastPage == null ? null : this.lastPage.getValue();
    }

    /**
     * @param value Used for isolated representation of last page.
     */
    public CitationCitedArtifactPublicationFormComponent setLastPage(String value) {
      if (Utilities.noString(value))
        this.lastPage = null;
      else {
        if (this.lastPage == null)
          this.lastPage = new StringType();
        this.lastPage.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #pageCount} (Actual or approximate number of pages or
     *         screens.). This is the underlying object with id, value and
     *         extensions. The accessor "getPageCount" gives direct access to the
     *         value
     */
    public StringType getPageCountElement() {
      if (this.pageCount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.pageCount");
        else if (Configuration.doAutoCreate())
          this.pageCount = new StringType(); // bb
      return this.pageCount;
    }

    public boolean hasPageCountElement() {
      return this.pageCount != null && !this.pageCount.isEmpty();
    }

    public boolean hasPageCount() {
      return this.pageCount != null && !this.pageCount.isEmpty();
    }

    /**
     * @param value {@link #pageCount} (Actual or approximate number of pages or
     *              screens.). This is the underlying object with id, value and
     *              extensions. The accessor "getPageCount" gives direct access to
     *              the value
     */
    public CitationCitedArtifactPublicationFormComponent setPageCountElement(StringType value) {
      this.pageCount = value;
      return this;
    }

    /**
     * @return Actual or approximate number of pages or screens.
     */
    public String getPageCount() {
      return this.pageCount == null ? null : this.pageCount.getValue();
    }

    /**
     * @param value Actual or approximate number of pages or screens.
     */
    public CitationCitedArtifactPublicationFormComponent setPageCount(String value) {
      if (Utilities.noString(value))
        this.pageCount = null;
      else {
        if (this.pageCount == null)
          this.pageCount = new StringType();
        this.pageCount.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (Copyright notice for the full article or
     *         artifact.). This is the underlying object with id, value and
     *         extensions. The accessor "getCopyright" gives direct access to the
     *         value
     */
    public MarkdownType getCopyrightElement() {
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormComponent.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() {
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() {
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (Copyright notice for the full article or
     *              artifact.). This is the underlying object with id, value and
     *              extensions. The accessor "getCopyright" gives direct access to
     *              the value
     */
    public CitationCitedArtifactPublicationFormComponent setCopyrightElement(MarkdownType value) {
      this.copyright = value;
      return this;
    }

    /**
     * @return Copyright notice for the full article or artifact.
     */
    public String getCopyright() {
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Copyright notice for the full article or artifact.
     */
    public CitationCitedArtifactPublicationFormComponent setCopyright(String value) {
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("publishedIn", "", "The collection the cited article or artifact is published in.", 0,
          1, publishedIn));
      children.add(new Property("periodicRelease", "", "The specific issue in which the cited article resides.", 0, 1,
          periodicRelease));
      children.add(new Property("articleDate", "dateTime",
          "The date the article was added to the database, or the date the article was released (which may differ from the journal issue publication date).",
          0, 1, articleDate));
      children.add(new Property("lastRevisionDate", "dateTime",
          "The date the article was last revised or updated in the database.", 0, 1, lastRevisionDate));
      children.add(new Property("language", "CodeableConcept",
          "Language in which this form of the article is published.", 0, java.lang.Integer.MAX_VALUE, language));
      children.add(new Property("accessionNumber", "string", "Entry number or identifier for inclusion in a database.",
          0, 1, accessionNumber));
      children.add(new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString));
      children
          .add(new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage));
      children
          .add(new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage));
      children.add(
          new Property("pageCount", "string", "Actual or approximate number of pages or screens.", 0, 1, pageCount));
      children.add(
          new Property("copyright", "markdown", "Copyright notice for the full article or artifact.", 0, 1, copyright));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -614144077:
        /* publishedIn */ return new Property("publishedIn", "",
            "The collection the cited article or artifact is published in.", 0, 1, publishedIn);
      case 1726878956:
        /* periodicRelease */ return new Property("periodicRelease", "",
            "The specific issue in which the cited article resides.", 0, 1, periodicRelease);
      case 817743300:
        /* articleDate */ return new Property("articleDate", "dateTime",
            "The date the article was added to the database, or the date the article was released (which may differ from the journal issue publication date).",
            0, 1, articleDate);
      case 2129161183:
        /* lastRevisionDate */ return new Property("lastRevisionDate", "dateTime",
            "The date the article was last revised or updated in the database.", 0, 1, lastRevisionDate);
      case -1613589672:
        /* language */ return new Property("language", "CodeableConcept",
            "Language in which this form of the article is published.", 0, java.lang.Integer.MAX_VALUE, language);
      case 1807963277:
        /* accessionNumber */ return new Property("accessionNumber", "string",
            "Entry number or identifier for inclusion in a database.", 0, 1, accessionNumber);
      case 1287145344:
        /* pageString */ return new Property("pageString", "string", "Used for full display of pagination.", 0, 1,
            pageString);
      case 132895071:
        /* firstPage */ return new Property("firstPage", "string", "Used for isolated representation of first page.", 0,
            1, firstPage);
      case -1459540411:
        /* lastPage */ return new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1,
            lastPage);
      case 857882560:
        /* pageCount */ return new Property("pageCount", "string", "Actual or approximate number of pages or screens.",
            0, 1, pageCount);
      case 1522889671:
        /* copyright */ return new Property("copyright", "markdown",
            "Copyright notice for the full article or artifact.", 0, 1, copyright);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -614144077:
        /* publishedIn */ return this.publishedIn == null ? new Base[0] : new Base[] { this.publishedIn }; // CitationCitedArtifactPublicationFormPublishedInComponent
      case 1726878956:
        /* periodicRelease */ return this.periodicRelease == null ? new Base[0] : new Base[] { this.periodicRelease }; // CitationCitedArtifactPublicationFormPeriodicReleaseComponent
      case 817743300:
        /* articleDate */ return this.articleDate == null ? new Base[0] : new Base[] { this.articleDate }; // DateTimeType
      case 2129161183:
        /* lastRevisionDate */ return this.lastRevisionDate == null ? new Base[0]
            : new Base[] { this.lastRevisionDate }; // DateTimeType
      case -1613589672:
        /* language */ return this.language == null ? new Base[0]
            : this.language.toArray(new Base[this.language.size()]); // CodeableConcept
      case 1807963277:
        /* accessionNumber */ return this.accessionNumber == null ? new Base[0] : new Base[] { this.accessionNumber }; // StringType
      case 1287145344:
        /* pageString */ return this.pageString == null ? new Base[0] : new Base[] { this.pageString }; // StringType
      case 132895071:
        /* firstPage */ return this.firstPage == null ? new Base[0] : new Base[] { this.firstPage }; // StringType
      case -1459540411:
        /* lastPage */ return this.lastPage == null ? new Base[0] : new Base[] { this.lastPage }; // StringType
      case 857882560:
        /* pageCount */ return this.pageCount == null ? new Base[0] : new Base[] { this.pageCount }; // StringType
      case 1522889671:
        /* copyright */ return this.copyright == null ? new Base[0] : new Base[] { this.copyright }; // MarkdownType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -614144077: // publishedIn
        this.publishedIn = (CitationCitedArtifactPublicationFormPublishedInComponent) value; // CitationCitedArtifactPublicationFormPublishedInComponent
        return value;
      case 1726878956: // periodicRelease
        this.periodicRelease = (CitationCitedArtifactPublicationFormPeriodicReleaseComponent) value; // CitationCitedArtifactPublicationFormPeriodicReleaseComponent
        return value;
      case 817743300: // articleDate
        this.articleDate = TypeConvertor.castToDateTime(value); // DateTimeType
        return value;
      case 2129161183: // lastRevisionDate
        this.lastRevisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
        return value;
      case -1613589672: // language
        this.getLanguage().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case 1807963277: // accessionNumber
        this.accessionNumber = TypeConvertor.castToString(value); // StringType
        return value;
      case 1287145344: // pageString
        this.pageString = TypeConvertor.castToString(value); // StringType
        return value;
      case 132895071: // firstPage
        this.firstPage = TypeConvertor.castToString(value); // StringType
        return value;
      case -1459540411: // lastPage
        this.lastPage = TypeConvertor.castToString(value); // StringType
        return value;
      case 857882560: // pageCount
        this.pageCount = TypeConvertor.castToString(value); // StringType
        return value;
      case 1522889671: // copyright
        this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("publishedIn")) {
        this.publishedIn = (CitationCitedArtifactPublicationFormPublishedInComponent) value; // CitationCitedArtifactPublicationFormPublishedInComponent
      } else if (name.equals("periodicRelease")) {
        this.periodicRelease = (CitationCitedArtifactPublicationFormPeriodicReleaseComponent) value; // CitationCitedArtifactPublicationFormPeriodicReleaseComponent
      } else if (name.equals("articleDate")) {
        this.articleDate = TypeConvertor.castToDateTime(value); // DateTimeType
      } else if (name.equals("lastRevisionDate")) {
        this.lastRevisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
      } else if (name.equals("language")) {
        this.getLanguage().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("accessionNumber")) {
        this.accessionNumber = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("pageString")) {
        this.pageString = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("firstPage")) {
        this.firstPage = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("lastPage")) {
        this.lastPage = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("pageCount")) {
        this.pageCount = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("copyright")) {
        this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -614144077:
        return getPublishedIn();
      case 1726878956:
        return getPeriodicRelease();
      case 817743300:
        return getArticleDateElement();
      case 2129161183:
        return getLastRevisionDateElement();
      case -1613589672:
        return addLanguage();
      case 1807963277:
        return getAccessionNumberElement();
      case 1287145344:
        return getPageStringElement();
      case 132895071:
        return getFirstPageElement();
      case -1459540411:
        return getLastPageElement();
      case 857882560:
        return getPageCountElement();
      case 1522889671:
        return getCopyrightElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -614144077:
        /* publishedIn */ return new String[] {};
      case 1726878956:
        /* periodicRelease */ return new String[] {};
      case 817743300:
        /* articleDate */ return new String[] { "dateTime" };
      case 2129161183:
        /* lastRevisionDate */ return new String[] { "dateTime" };
      case -1613589672:
        /* language */ return new String[] { "CodeableConcept" };
      case 1807963277:
        /* accessionNumber */ return new String[] { "string" };
      case 1287145344:
        /* pageString */ return new String[] { "string" };
      case 132895071:
        /* firstPage */ return new String[] { "string" };
      case -1459540411:
        /* lastPage */ return new String[] { "string" };
      case 857882560:
        /* pageCount */ return new String[] { "string" };
      case 1522889671:
        /* copyright */ return new String[] { "markdown" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("publishedIn")) {
        this.publishedIn = new CitationCitedArtifactPublicationFormPublishedInComponent();
        return this.publishedIn;
      } else if (name.equals("periodicRelease")) {
        this.periodicRelease = new CitationCitedArtifactPublicationFormPeriodicReleaseComponent();
        return this.periodicRelease;
      } else if (name.equals("articleDate")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.articleDate");
      } else if (name.equals("lastRevisionDate")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.lastRevisionDate");
      } else if (name.equals("language")) {
        return addLanguage();
      } else if (name.equals("accessionNumber")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.accessionNumber");
      } else if (name.equals("pageString")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.pageString");
      } else if (name.equals("firstPage")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.firstPage");
      } else if (name.equals("lastPage")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.lastPage");
      } else if (name.equals("pageCount")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.pageCount");
      } else if (name.equals("copyright")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.copyright");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactPublicationFormComponent copy() {
      CitationCitedArtifactPublicationFormComponent dst = new CitationCitedArtifactPublicationFormComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactPublicationFormComponent dst) {
      super.copyValues(dst);
      dst.publishedIn = publishedIn == null ? null : publishedIn.copy();
      dst.periodicRelease = periodicRelease == null ? null : periodicRelease.copy();
      dst.articleDate = articleDate == null ? null : articleDate.copy();
      dst.lastRevisionDate = lastRevisionDate == null ? null : lastRevisionDate.copy();
      if (language != null) {
        dst.language = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : language)
          dst.language.add(i.copy());
      }
      ;
      dst.accessionNumber = accessionNumber == null ? null : accessionNumber.copy();
      dst.pageString = pageString == null ? null : pageString.copy();
      dst.firstPage = firstPage == null ? null : firstPage.copy();
      dst.lastPage = lastPage == null ? null : lastPage.copy();
      dst.pageCount = pageCount == null ? null : pageCount.copy();
      dst.copyright = copyright == null ? null : copyright.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormComponent))
        return false;
      CitationCitedArtifactPublicationFormComponent o = (CitationCitedArtifactPublicationFormComponent) other_;
      return compareDeep(publishedIn, o.publishedIn, true) && compareDeep(periodicRelease, o.periodicRelease, true)
          && compareDeep(articleDate, o.articleDate, true) && compareDeep(lastRevisionDate, o.lastRevisionDate, true)
          && compareDeep(language, o.language, true) && compareDeep(accessionNumber, o.accessionNumber, true)
          && compareDeep(pageString, o.pageString, true) && compareDeep(firstPage, o.firstPage, true)
          && compareDeep(lastPage, o.lastPage, true) && compareDeep(pageCount, o.pageCount, true)
          && compareDeep(copyright, o.copyright, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormComponent))
        return false;
      CitationCitedArtifactPublicationFormComponent o = (CitationCitedArtifactPublicationFormComponent) other_;
      return compareValues(articleDate, o.articleDate, true)
          && compareValues(lastRevisionDate, o.lastRevisionDate, true)
          && compareValues(accessionNumber, o.accessionNumber, true) && compareValues(pageString, o.pageString, true)
          && compareValues(firstPage, o.firstPage, true) && compareValues(lastPage, o.lastPage, true)
          && compareValues(pageCount, o.pageCount, true) && compareValues(copyright, o.copyright, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(publishedIn, periodicRelease, articleDate,
          lastRevisionDate, language, accessionNumber, pageString, firstPage, lastPage, pageCount, copyright);
    }

    public String fhirType() {
      return "Citation.citedArtifact.publicationForm";

    }

  }

  @Block()
  public static class CitationCitedArtifactPublicationFormPublishedInComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Kind of container (e.g. Periodical, database, or book).
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Kind of container (e.g. Periodical, database, or book)", formalDefinition = "Kind of container (e.g. Periodical, database, or book).")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/published-in-type")
    protected CodeableConcept type;

    /**
     * Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book
     * identifiers include ISBN.
     */
    @Child(name = "identifier", type = {
        Identifier.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN", formalDefinition = "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.")
    protected List<Identifier> identifier;

    /**
     * Name of the database or title of the book or journal.
     */
    @Child(name = "title", type = { StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Name of the database or title of the book or journal", formalDefinition = "Name of the database or title of the book or journal.")
    protected StringType title;

    /**
     * Name of the publisher.
     */
    @Child(name = "publisher", type = {
        Organization.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Name of the publisher", formalDefinition = "Name of the publisher.")
    protected Reference publisher;

    /**
     * Geographic location of the publisher.
     */
    @Child(name = "publisherLocation", type = {
        StringType.class }, order = 5, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Geographic location of the publisher", formalDefinition = "Geographic location of the publisher.")
    protected StringType publisherLocation;

    private static final long serialVersionUID = 1440066953L;

    /**
     * Constructor
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent() {
      super();
    }

    /**
     * @return {@link #type} (Kind of container (e.g. Periodical, database, or
     *         book).)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Kind of container (e.g. Periodical, database, or
     *              book).)
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #identifier} (Journal identifiers include ISSN, ISO
     *         Abbreviation and NLMuniqueID; Book identifiers include ISBN.)
     */
    public List<Identifier> getIdentifier() {
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setIdentifier(List<Identifier> theIdentifier) {
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

    public Identifier addIdentifier() { // 3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CitationCitedArtifactPublicationFormPublishedInComponent addIdentifier(Identifier t) { // 3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating
     *         it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() {
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #title} (Name of the database or title of the book or
     *         journal.). This is the underlying object with id, value and
     *         extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() {
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.title");
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
     * @param value {@link #title} (Name of the database or title of the book or
     *              journal.). This is the underlying object with id, value and
     *              extensions. The accessor "getTitle" gives direct access to the
     *              value
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setTitleElement(StringType value) {
      this.title = value;
      return this;
    }

    /**
     * @return Name of the database or title of the book or journal.
     */
    public String getTitle() {
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value Name of the database or title of the book or journal.
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setTitle(String value) {
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
     * @return {@link #publisher} (Name of the publisher.)
     */
    public Reference getPublisher() {
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new Reference(); // cc
      return this.publisher;
    }

    public boolean hasPublisher() {
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (Name of the publisher.)
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setPublisher(Reference value) {
      this.publisher = value;
      return this;
    }

    /**
     * @return {@link #publisherLocation} (Geographic location of the publisher.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getPublisherLocation" gives direct access to the value
     */
    public StringType getPublisherLocationElement() {
      if (this.publisherLocation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPublishedInComponent.publisherLocation");
        else if (Configuration.doAutoCreate())
          this.publisherLocation = new StringType(); // bb
      return this.publisherLocation;
    }

    public boolean hasPublisherLocationElement() {
      return this.publisherLocation != null && !this.publisherLocation.isEmpty();
    }

    public boolean hasPublisherLocation() {
      return this.publisherLocation != null && !this.publisherLocation.isEmpty();
    }

    /**
     * @param value {@link #publisherLocation} (Geographic location of the
     *              publisher.). This is the underlying object with id, value and
     *              extensions. The accessor "getPublisherLocation" gives direct
     *              access to the value
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setPublisherLocationElement(StringType value) {
      this.publisherLocation = value;
      return this;
    }

    /**
     * @return Geographic location of the publisher.
     */
    public String getPublisherLocation() {
      return this.publisherLocation == null ? null : this.publisherLocation.getValue();
    }

    /**
     * @param value Geographic location of the publisher.
     */
    public CitationCitedArtifactPublicationFormPublishedInComponent setPublisherLocation(String value) {
      if (Utilities.noString(value))
        this.publisherLocation = null;
      else {
        if (this.publisherLocation == null)
          this.publisherLocation = new StringType();
        this.publisherLocation.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept", "Kind of container (e.g. Periodical, database, or book).", 0,
          1, type));
      children.add(new Property("identifier", "Identifier",
          "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.", 0,
          java.lang.Integer.MAX_VALUE, identifier));
      children
          .add(new Property("title", "string", "Name of the database or title of the book or journal.", 0, 1, title));
      children.add(new Property("publisher", "Reference(Organization)", "Name of the publisher.", 0, 1, publisher));
      children.add(new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1,
          publisherLocation));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "Kind of container (e.g. Periodical, database, or book).", 0, 1, type);
      case -1618432855:
        /* identifier */ return new Property("identifier", "Identifier",
            "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers include ISBN.", 0,
            java.lang.Integer.MAX_VALUE, identifier);
      case 110371416:
        /* title */ return new Property("title", "string", "Name of the database or title of the book or journal.", 0,
            1, title);
      case 1447404028:
        /* publisher */ return new Property("publisher", "Reference(Organization)", "Name of the publisher.", 0, 1,
            publisher);
      case -1281627695:
        /* publisherLocation */ return new Property("publisherLocation", "string",
            "Geographic location of the publisher.", 0, 1, publisherLocation);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -1618432855:
        /* identifier */ return this.identifier == null ? new Base[0]
            : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
      case 110371416:
        /* title */ return this.title == null ? new Base[0] : new Base[] { this.title }; // StringType
      case 1447404028:
        /* publisher */ return this.publisher == null ? new Base[0] : new Base[] { this.publisher }; // Reference
      case -1281627695:
        /* publisherLocation */ return this.publisherLocation == null ? new Base[0]
            : new Base[] { this.publisherLocation }; // StringType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -1618432855: // identifier
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
        return value;
      case 110371416: // title
        this.title = TypeConvertor.castToString(value); // StringType
        return value;
      case 1447404028: // publisher
        this.publisher = TypeConvertor.castToReference(value); // Reference
        return value;
      case -1281627695: // publisherLocation
        this.publisherLocation = TypeConvertor.castToString(value); // StringType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("identifier")) {
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
      } else if (name.equals("title")) {
        this.title = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("publisher")) {
        this.publisher = TypeConvertor.castToReference(value); // Reference
      } else if (name.equals("publisherLocation")) {
        this.publisherLocation = TypeConvertor.castToString(value); // StringType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case -1618432855:
        return addIdentifier();
      case 110371416:
        return getTitleElement();
      case 1447404028:
        return getPublisher();
      case -1281627695:
        return getPublisherLocationElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -1618432855:
        /* identifier */ return new String[] { "Identifier" };
      case 110371416:
        /* title */ return new String[] { "string" };
      case 1447404028:
        /* publisher */ return new String[] { "Reference" };
      case -1281627695:
        /* publisherLocation */ return new String[] { "string" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("identifier")) {
        return addIdentifier();
      } else if (name.equals("title")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.publishedIn.title");
      } else if (name.equals("publisher")) {
        this.publisher = new Reference();
        return this.publisher;
      } else if (name.equals("publisherLocation")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.publishedIn.publisherLocation");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactPublicationFormPublishedInComponent copy() {
      CitationCitedArtifactPublicationFormPublishedInComponent dst = new CitationCitedArtifactPublicationFormPublishedInComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactPublicationFormPublishedInComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      if (identifier != null) {
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
      }
      ;
      dst.title = title == null ? null : title.copy();
      dst.publisher = publisher == null ? null : publisher.copy();
      dst.publisherLocation = publisherLocation == null ? null : publisherLocation.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormPublishedInComponent))
        return false;
      CitationCitedArtifactPublicationFormPublishedInComponent o = (CitationCitedArtifactPublicationFormPublishedInComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(identifier, o.identifier, true)
          && compareDeep(title, o.title, true) && compareDeep(publisher, o.publisher, true)
          && compareDeep(publisherLocation, o.publisherLocation, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormPublishedInComponent))
        return false;
      CitationCitedArtifactPublicationFormPublishedInComponent o = (CitationCitedArtifactPublicationFormPublishedInComponent) other_;
      return compareValues(title, o.title, true) && compareValues(publisherLocation, o.publisherLocation, true);
    }

    public boolean isEmpty() {
      return super.isEmpty()
          && ca.uhn.fhir.util.ElementUtil.isEmpty(type, identifier, title, publisher, publisherLocation);
    }

    public String fhirType() {
      return "Citation.citedArtifact.publicationForm.publishedIn";

    }

  }

  @Block()
  public static class CitationCitedArtifactPublicationFormPeriodicReleaseComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Describes the form of the medium cited. Common codes are "Internet" or
     * "Print".
     */
    @Child(name = "citedMedium", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Internet or Print", formalDefinition = "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print\".")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/cited-medium")
    protected CodeableConcept citedMedium;

    /**
     * Volume number of journal in which the article is published.
     */
    @Child(name = "volume", type = { StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Volume number of journal in which the article is published", formalDefinition = "Volume number of journal in which the article is published.")
    protected StringType volume;

    /**
     * Issue, part or supplement of journal in which the article is published.
     */
    @Child(name = "issue", type = { StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Issue, part or supplement of journal in which the article is published", formalDefinition = "Issue, part or supplement of journal in which the article is published.")
    protected StringType issue;

    /**
     * Defining the date on which the issue of the journal was published.
     */
    @Child(name = "dateOfPublication", type = {}, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Defining the date on which the issue of the journal was published", formalDefinition = "Defining the date on which the issue of the journal was published.")
    protected CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent dateOfPublication;

    private static final long serialVersionUID = -474554951L;

    /**
     * Constructor
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent() {
      super();
    }

    /**
     * @return {@link #citedMedium} (Describes the form of the medium cited. Common
     *         codes are "Internet" or "Print".)
     */
    public CodeableConcept getCitedMedium() {
      if (this.citedMedium == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseComponent.citedMedium");
        else if (Configuration.doAutoCreate())
          this.citedMedium = new CodeableConcept(); // cc
      return this.citedMedium;
    }

    public boolean hasCitedMedium() {
      return this.citedMedium != null && !this.citedMedium.isEmpty();
    }

    /**
     * @param value {@link #citedMedium} (Describes the form of the medium cited.
     *              Common codes are "Internet" or "Print".)
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent setCitedMedium(CodeableConcept value) {
      this.citedMedium = value;
      return this;
    }

    /**
     * @return {@link #volume} (Volume number of journal in which the article is
     *         published.). This is the underlying object with id, value and
     *         extensions. The accessor "getVolume" gives direct access to the value
     */
    public StringType getVolumeElement() {
      if (this.volume == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseComponent.volume");
        else if (Configuration.doAutoCreate())
          this.volume = new StringType(); // bb
      return this.volume;
    }

    public boolean hasVolumeElement() {
      return this.volume != null && !this.volume.isEmpty();
    }

    public boolean hasVolume() {
      return this.volume != null && !this.volume.isEmpty();
    }

    /**
     * @param value {@link #volume} (Volume number of journal in which the article
     *              is published.). This is the underlying object with id, value and
     *              extensions. The accessor "getVolume" gives direct access to the
     *              value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent setVolumeElement(StringType value) {
      this.volume = value;
      return this;
    }

    /**
     * @return Volume number of journal in which the article is published.
     */
    public String getVolume() {
      return this.volume == null ? null : this.volume.getValue();
    }

    /**
     * @param value Volume number of journal in which the article is published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent setVolume(String value) {
      if (Utilities.noString(value))
        this.volume = null;
      else {
        if (this.volume == null)
          this.volume = new StringType();
        this.volume.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #issue} (Issue, part or supplement of journal in which the
     *         article is published.). This is the underlying object with id, value
     *         and extensions. The accessor "getIssue" gives direct access to the
     *         value
     */
    public StringType getIssueElement() {
      if (this.issue == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseComponent.issue");
        else if (Configuration.doAutoCreate())
          this.issue = new StringType(); // bb
      return this.issue;
    }

    public boolean hasIssueElement() {
      return this.issue != null && !this.issue.isEmpty();
    }

    public boolean hasIssue() {
      return this.issue != null && !this.issue.isEmpty();
    }

    /**
     * @param value {@link #issue} (Issue, part or supplement of journal in which
     *              the article is published.). This is the underlying object with
     *              id, value and extensions. The accessor "getIssue" gives direct
     *              access to the value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent setIssueElement(StringType value) {
      this.issue = value;
      return this;
    }

    /**
     * @return Issue, part or supplement of journal in which the article is
     *         published.
     */
    public String getIssue() {
      return this.issue == null ? null : this.issue.getValue();
    }

    /**
     * @param value Issue, part or supplement of journal in which the article is
     *              published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent setIssue(String value) {
      if (Utilities.noString(value))
        this.issue = null;
      else {
        if (this.issue == null)
          this.issue = new StringType();
        this.issue.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #dateOfPublication} (Defining the date on which the issue of
     *         the journal was published.)
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent getDateOfPublication() {
      if (this.dateOfPublication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseComponent.dateOfPublication");
        else if (Configuration.doAutoCreate())
          this.dateOfPublication = new CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent(); // cc
      return this.dateOfPublication;
    }

    public boolean hasDateOfPublication() {
      return this.dateOfPublication != null && !this.dateOfPublication.isEmpty();
    }

    /**
     * @param value {@link #dateOfPublication} (Defining the date on which the issue
     *              of the journal was published.)
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent setDateOfPublication(
        CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent value) {
      this.dateOfPublication = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("citedMedium", "CodeableConcept",
          "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print\".", 0, 1, citedMedium));
      children.add(new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1,
          volume));
      children.add(new Property("issue", "string",
          "Issue, part or supplement of journal in which the article is published.", 0, 1, issue));
      children.add(new Property("dateOfPublication", "",
          "Defining the date on which the issue of the journal was published.", 0, 1, dateOfPublication));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 612116418:
        /* citedMedium */ return new Property("citedMedium", "CodeableConcept",
            "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print\".", 0, 1, citedMedium);
      case -810883302:
        /* volume */ return new Property("volume", "string",
            "Volume number of journal in which the article is published.", 0, 1, volume);
      case 100509913:
        /* issue */ return new Property("issue", "string",
            "Issue, part or supplement of journal in which the article is published.", 0, 1, issue);
      case -1662473529:
        /* dateOfPublication */ return new Property("dateOfPublication", "",
            "Defining the date on which the issue of the journal was published.", 0, 1, dateOfPublication);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 612116418:
        /* citedMedium */ return this.citedMedium == null ? new Base[0] : new Base[] { this.citedMedium }; // CodeableConcept
      case -810883302:
        /* volume */ return this.volume == null ? new Base[0] : new Base[] { this.volume }; // StringType
      case 100509913:
        /* issue */ return this.issue == null ? new Base[0] : new Base[] { this.issue }; // StringType
      case -1662473529:
        /* dateOfPublication */ return this.dateOfPublication == null ? new Base[0]
            : new Base[] { this.dateOfPublication }; // CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 612116418: // citedMedium
        this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -810883302: // volume
        this.volume = TypeConvertor.castToString(value); // StringType
        return value;
      case 100509913: // issue
        this.issue = TypeConvertor.castToString(value); // StringType
        return value;
      case -1662473529: // dateOfPublication
        this.dateOfPublication = (CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent) value; // CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("citedMedium")) {
        this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("volume")) {
        this.volume = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("issue")) {
        this.issue = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("dateOfPublication")) {
        this.dateOfPublication = (CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent) value; // CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 612116418:
        return getCitedMedium();
      case -810883302:
        return getVolumeElement();
      case 100509913:
        return getIssueElement();
      case -1662473529:
        return getDateOfPublication();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 612116418:
        /* citedMedium */ return new String[] { "CodeableConcept" };
      case -810883302:
        /* volume */ return new String[] { "string" };
      case 100509913:
        /* issue */ return new String[] { "string" };
      case -1662473529:
        /* dateOfPublication */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("citedMedium")) {
        this.citedMedium = new CodeableConcept();
        return this.citedMedium;
      } else if (name.equals("volume")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.volume");
      } else if (name.equals("issue")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.issue");
      } else if (name.equals("dateOfPublication")) {
        this.dateOfPublication = new CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent();
        return this.dateOfPublication;
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactPublicationFormPeriodicReleaseComponent copy() {
      CitationCitedArtifactPublicationFormPeriodicReleaseComponent dst = new CitationCitedArtifactPublicationFormPeriodicReleaseComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactPublicationFormPeriodicReleaseComponent dst) {
      super.copyValues(dst);
      dst.citedMedium = citedMedium == null ? null : citedMedium.copy();
      dst.volume = volume == null ? null : volume.copy();
      dst.issue = issue == null ? null : issue.copy();
      dst.dateOfPublication = dateOfPublication == null ? null : dateOfPublication.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormPeriodicReleaseComponent))
        return false;
      CitationCitedArtifactPublicationFormPeriodicReleaseComponent o = (CitationCitedArtifactPublicationFormPeriodicReleaseComponent) other_;
      return compareDeep(citedMedium, o.citedMedium, true) && compareDeep(volume, o.volume, true)
          && compareDeep(issue, o.issue, true) && compareDeep(dateOfPublication, o.dateOfPublication, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormPeriodicReleaseComponent))
        return false;
      CitationCitedArtifactPublicationFormPeriodicReleaseComponent o = (CitationCitedArtifactPublicationFormPeriodicReleaseComponent) other_;
      return compareValues(volume, o.volume, true) && compareValues(issue, o.issue, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(citedMedium, volume, issue, dateOfPublication);
    }

    public String fhirType() {
      return "Citation.citedArtifact.publicationForm.periodicRelease";

    }

  }

  @Block()
  public static class CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent
      extends BackboneElement implements IBaseBackboneElement {
    /**
     * Date on which the issue of the journal was published.
     */
    @Child(name = "date", type = { DateType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Date on which the issue of the journal was published", formalDefinition = "Date on which the issue of the journal was published.")
    protected DateType date;

    /**
     * Year on which the issue of the journal was published.
     */
    @Child(name = "year", type = { StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Year on which the issue of the journal was published", formalDefinition = "Year on which the issue of the journal was published.")
    protected StringType year;

    /**
     * Month on which the issue of the journal was published.
     */
    @Child(name = "month", type = { StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Month on which the issue of the journal was published", formalDefinition = "Month on which the issue of the journal was published.")
    protected StringType month;

    /**
     * Day on which the issue of the journal was published.
     */
    @Child(name = "day", type = { StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Day on which the issue of the journal was published", formalDefinition = "Day on which the issue of the journal was published.")
    protected StringType day;

    /**
     * Spring, Summer, Fall/Autumn, Winter.
     */
    @Child(name = "season", type = { StringType.class }, order = 5, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Season on which the issue of the journal was published", formalDefinition = "Spring, Summer, Fall/Autumn, Winter.")
    protected StringType season;

    /**
     * Text representation of the date of which the issue of the journal was
     * published.
     */
    @Child(name = "text", type = { StringType.class }, order = 6, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Text representation of the date of which the issue of the journal was published", formalDefinition = "Text representation of the date of which the issue of the journal was published.")
    protected StringType text;

    private static final long serialVersionUID = 1585589146L;

    /**
     * Constructor
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent() {
      super();
    }

    /**
     * @return {@link #date} (Date on which the issue of the journal was
     *         published.). This is the underlying object with id, value and
     *         extensions. The accessor "getDate" gives direct access to the value
     */
    public DateType getDateElement() {
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateType(); // bb
      return this.date;
    }

    public boolean hasDateElement() {
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() {
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (Date on which the issue of the journal was
     *              published.). This is the underlying object with id, value and
     *              extensions. The accessor "getDate" gives direct access to the
     *              value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setDateElement(
        DateType value) {
      this.date = value;
      return this;
    }

    /**
     * @return Date on which the issue of the journal was published.
     */
    public Date getDate() {
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value Date on which the issue of the journal was published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setDate(Date value) {
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #year} (Year on which the issue of the journal was
     *         published.). This is the underlying object with id, value and
     *         extensions. The accessor "getYear" gives direct access to the value
     */
    public StringType getYearElement() {
      if (this.year == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent.year");
        else if (Configuration.doAutoCreate())
          this.year = new StringType(); // bb
      return this.year;
    }

    public boolean hasYearElement() {
      return this.year != null && !this.year.isEmpty();
    }

    public boolean hasYear() {
      return this.year != null && !this.year.isEmpty();
    }

    /**
     * @param value {@link #year} (Year on which the issue of the journal was
     *              published.). This is the underlying object with id, value and
     *              extensions. The accessor "getYear" gives direct access to the
     *              value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setYearElement(
        StringType value) {
      this.year = value;
      return this;
    }

    /**
     * @return Year on which the issue of the journal was published.
     */
    public String getYear() {
      return this.year == null ? null : this.year.getValue();
    }

    /**
     * @param value Year on which the issue of the journal was published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setYear(String value) {
      if (Utilities.noString(value))
        this.year = null;
      else {
        if (this.year == null)
          this.year = new StringType();
        this.year.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #month} (Month on which the issue of the journal was
     *         published.). This is the underlying object with id, value and
     *         extensions. The accessor "getMonth" gives direct access to the value
     */
    public StringType getMonthElement() {
      if (this.month == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent.month");
        else if (Configuration.doAutoCreate())
          this.month = new StringType(); // bb
      return this.month;
    }

    public boolean hasMonthElement() {
      return this.month != null && !this.month.isEmpty();
    }

    public boolean hasMonth() {
      return this.month != null && !this.month.isEmpty();
    }

    /**
     * @param value {@link #month} (Month on which the issue of the journal was
     *              published.). This is the underlying object with id, value and
     *              extensions. The accessor "getMonth" gives direct access to the
     *              value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setMonthElement(
        StringType value) {
      this.month = value;
      return this;
    }

    /**
     * @return Month on which the issue of the journal was published.
     */
    public String getMonth() {
      return this.month == null ? null : this.month.getValue();
    }

    /**
     * @param value Month on which the issue of the journal was published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setMonth(String value) {
      if (Utilities.noString(value))
        this.month = null;
      else {
        if (this.month == null)
          this.month = new StringType();
        this.month.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #day} (Day on which the issue of the journal was published.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getDay" gives direct access to the value
     */
    public StringType getDayElement() {
      if (this.day == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent.day");
        else if (Configuration.doAutoCreate())
          this.day = new StringType(); // bb
      return this.day;
    }

    public boolean hasDayElement() {
      return this.day != null && !this.day.isEmpty();
    }

    public boolean hasDay() {
      return this.day != null && !this.day.isEmpty();
    }

    /**
     * @param value {@link #day} (Day on which the issue of the journal was
     *              published.). This is the underlying object with id, value and
     *              extensions. The accessor "getDay" gives direct access to the
     *              value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setDayElement(
        StringType value) {
      this.day = value;
      return this;
    }

    /**
     * @return Day on which the issue of the journal was published.
     */
    public String getDay() {
      return this.day == null ? null : this.day.getValue();
    }

    /**
     * @param value Day on which the issue of the journal was published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setDay(String value) {
      if (Utilities.noString(value))
        this.day = null;
      else {
        if (this.day == null)
          this.day = new StringType();
        this.day.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #season} (Spring, Summer, Fall/Autumn, Winter.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getSeason" gives direct access to the value
     */
    public StringType getSeasonElement() {
      if (this.season == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent.season");
        else if (Configuration.doAutoCreate())
          this.season = new StringType(); // bb
      return this.season;
    }

    public boolean hasSeasonElement() {
      return this.season != null && !this.season.isEmpty();
    }

    public boolean hasSeason() {
      return this.season != null && !this.season.isEmpty();
    }

    /**
     * @param value {@link #season} (Spring, Summer, Fall/Autumn, Winter.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getSeason" gives direct access to the value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setSeasonElement(
        StringType value) {
      this.season = value;
      return this;
    }

    /**
     * @return Spring, Summer, Fall/Autumn, Winter.
     */
    public String getSeason() {
      return this.season == null ? null : this.season.getValue();
    }

    /**
     * @param value Spring, Summer, Fall/Autumn, Winter.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setSeason(String value) {
      if (Utilities.noString(value))
        this.season = null;
      else {
        if (this.season == null)
          this.season = new StringType();
        this.season.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #text} (Text representation of the date of which the issue of
     *         the journal was published.). This is the underlying object with id,
     *         value and extensions. The accessor "getText" gives direct access to
     *         the value
     */
    public StringType getTextElement() {
      if (this.text == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent.text");
        else if (Configuration.doAutoCreate())
          this.text = new StringType(); // bb
      return this.text;
    }

    public boolean hasTextElement() {
      return this.text != null && !this.text.isEmpty();
    }

    public boolean hasText() {
      return this.text != null && !this.text.isEmpty();
    }

    /**
     * @param value {@link #text} (Text representation of the date of which the
     *              issue of the journal was published.). This is the underlying
     *              object with id, value and extensions. The accessor "getText"
     *              gives direct access to the value
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setTextElement(
        StringType value) {
      this.text = value;
      return this;
    }

    /**
     * @return Text representation of the date of which the issue of the journal was
     *         published.
     */
    public String getText() {
      return this.text == null ? null : this.text.getValue();
    }

    /**
     * @param value Text representation of the date of which the issue of the
     *              journal was published.
     */
    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent setText(String value) {
      if (Utilities.noString(value))
        this.text = null;
      else {
        if (this.text == null)
          this.text = new StringType();
        this.text.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("date", "date", "Date on which the issue of the journal was published.", 0, 1, date));
      children.add(new Property("year", "string", "Year on which the issue of the journal was published.", 0, 1, year));
      children
          .add(new Property("month", "string", "Month on which the issue of the journal was published.", 0, 1, month));
      children.add(new Property("day", "string", "Day on which the issue of the journal was published.", 0, 1, day));
      children.add(new Property("season", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, season));
      children.add(new Property("text", "string",
          "Text representation of the date of which the issue of the journal was published.", 0, 1, text));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3076014:
        /* date */ return new Property("date", "date", "Date on which the issue of the journal was published.", 0, 1,
            date);
      case 3704893:
        /* year */ return new Property("year", "string", "Year on which the issue of the journal was published.", 0, 1,
            year);
      case 104080000:
        /* month */ return new Property("month", "string", "Month on which the issue of the journal was published.", 0,
            1, month);
      case 99228:
        /* day */ return new Property("day", "string", "Day on which the issue of the journal was published.", 0, 1,
            day);
      case -906335517:
        /* season */ return new Property("season", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, season);
      case 3556653:
        /* text */ return new Property("text", "string",
            "Text representation of the date of which the issue of the journal was published.", 0, 1, text);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3076014:
        /* date */ return this.date == null ? new Base[0] : new Base[] { this.date }; // DateType
      case 3704893:
        /* year */ return this.year == null ? new Base[0] : new Base[] { this.year }; // StringType
      case 104080000:
        /* month */ return this.month == null ? new Base[0] : new Base[] { this.month }; // StringType
      case 99228:
        /* day */ return this.day == null ? new Base[0] : new Base[] { this.day }; // StringType
      case -906335517:
        /* season */ return this.season == null ? new Base[0] : new Base[] { this.season }; // StringType
      case 3556653:
        /* text */ return this.text == null ? new Base[0] : new Base[] { this.text }; // StringType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3076014: // date
        this.date = TypeConvertor.castToDate(value); // DateType
        return value;
      case 3704893: // year
        this.year = TypeConvertor.castToString(value); // StringType
        return value;
      case 104080000: // month
        this.month = TypeConvertor.castToString(value); // StringType
        return value;
      case 99228: // day
        this.day = TypeConvertor.castToString(value); // StringType
        return value;
      case -906335517: // season
        this.season = TypeConvertor.castToString(value); // StringType
        return value;
      case 3556653: // text
        this.text = TypeConvertor.castToString(value); // StringType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("date")) {
        this.date = TypeConvertor.castToDate(value); // DateType
      } else if (name.equals("year")) {
        this.year = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("month")) {
        this.month = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("day")) {
        this.day = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("season")) {
        this.season = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("text")) {
        this.text = TypeConvertor.castToString(value); // StringType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3076014:
        return getDateElement();
      case 3704893:
        return getYearElement();
      case 104080000:
        return getMonthElement();
      case 99228:
        return getDayElement();
      case -906335517:
        return getSeasonElement();
      case 3556653:
        return getTextElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3076014:
        /* date */ return new String[] { "date" };
      case 3704893:
        /* year */ return new String[] { "string" };
      case 104080000:
        /* month */ return new String[] { "string" };
      case 99228:
        /* day */ return new String[] { "string" };
      case -906335517:
        /* season */ return new String[] { "string" };
      case 3556653:
        /* text */ return new String[] { "string" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("date")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication.date");
      } else if (name.equals("year")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication.year");
      } else if (name.equals("month")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication.month");
      } else if (name.equals("day")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication.day");
      } else if (name.equals("season")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication.season");
      } else if (name.equals("text")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication.text");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent copy() {
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent dst = new CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent dst) {
      super.copyValues(dst);
      dst.date = date == null ? null : date.copy();
      dst.year = year == null ? null : year.copy();
      dst.month = month == null ? null : month.copy();
      dst.day = day == null ? null : day.copy();
      dst.season = season == null ? null : season.copy();
      dst.text = text == null ? null : text.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent))
        return false;
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent o = (CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent) other_;
      return compareDeep(date, o.date, true) && compareDeep(year, o.year, true) && compareDeep(month, o.month, true)
          && compareDeep(day, o.day, true) && compareDeep(season, o.season, true) && compareDeep(text, o.text, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent))
        return false;
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent o = (CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationComponent) other_;
      return compareValues(date, o.date, true) && compareValues(year, o.year, true)
          && compareValues(month, o.month, true) && compareValues(day, o.day, true)
          && compareValues(season, o.season, true) && compareValues(text, o.text, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(date, year, month, day, season, text);
    }

    public String fhirType() {
      return "Citation.citedArtifact.publicationForm.periodicRelease.dateOfPublication";

    }

  }

  @Block()
  public static class CitationCitedArtifactWebLocationComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Code the reason for different URLs, e.g. abstract and full-text.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Code the reason for different URLs, e.g. abstract and full-text", formalDefinition = "Code the reason for different URLs, e.g. abstract and full-text.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/article-url-type")
    protected CodeableConcept type;

    /**
     * The specific URL.
     */
    @Child(name = "url", type = { UriType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The specific URL", formalDefinition = "The specific URL.")
    protected UriType url;

    private static final long serialVersionUID = 397204034L;

    /**
     * Constructor
     */
    public CitationCitedArtifactWebLocationComponent() {
      super();
    }

    /**
     * @return {@link #type} (Code the reason for different URLs, e.g. abstract and
     *         full-text.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactWebLocationComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Code the reason for different URLs, e.g. abstract
     *              and full-text.)
     */
    public CitationCitedArtifactWebLocationComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #url} (The specific URL.). This is the underlying object with
     *         id, value and extensions. The accessor "getUrl" gives direct access
     *         to the value
     */
    public UriType getUrlElement() {
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactWebLocationComponent.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() {
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() {
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (The specific URL.). This is the underlying object
     *              with id, value and extensions. The accessor "getUrl" gives
     *              direct access to the value
     */
    public CitationCitedArtifactWebLocationComponent setUrlElement(UriType value) {
      this.url = value;
      return this;
    }

    /**
     * @return The specific URL.
     */
    public String getUrl() {
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value The specific URL.
     */
    public CitationCitedArtifactWebLocationComponent setUrl(String value) {
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept",
          "Code the reason for different URLs, e.g. abstract and full-text.", 0, 1, type));
      children.add(new Property("url", "uri", "The specific URL.", 0, 1, url));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "Code the reason for different URLs, e.g. abstract and full-text.", 0, 1, type);
      case 116079:
        /* url */ return new Property("url", "uri", "The specific URL.", 0, 1, url);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case 116079:
        /* url */ return this.url == null ? new Base[0] : new Base[] { this.url }; // UriType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 116079: // url
        this.url = TypeConvertor.castToUri(value); // UriType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("url")) {
        this.url = TypeConvertor.castToUri(value); // UriType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case 116079:
        return getUrlElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case 116079:
        /* url */ return new String[] { "uri" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("url")) {
        throw new FHIRException("Cannot call addChild on a primitive type Citation.citedArtifact.webLocation.url");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactWebLocationComponent copy() {
      CitationCitedArtifactWebLocationComponent dst = new CitationCitedArtifactWebLocationComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactWebLocationComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      dst.url = url == null ? null : url.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactWebLocationComponent))
        return false;
      CitationCitedArtifactWebLocationComponent o = (CitationCitedArtifactWebLocationComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(url, o.url, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactWebLocationComponent))
        return false;
      CitationCitedArtifactWebLocationComponent o = (CitationCitedArtifactWebLocationComponent) other_;
      return compareValues(url, o.url, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, url);
    }

    public String fhirType() {
      return "Citation.citedArtifact.webLocation";

    }

  }

  @Block()
  public static class CitationCitedArtifactClassificationComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * The kind of classifier (e.g. publication type, keyword).
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The kind of classifier (e.g. publication type, keyword)", formalDefinition = "The kind of classifier (e.g. publication type, keyword).")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/cited-artifact-classification-type")
    protected CodeableConcept type;

    /**
     * The specific classification value.
     */
    @Child(name = "classifier", type = {
        CodeableConcept.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The specific classification value", formalDefinition = "The specific classification value.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-artifact-classifier")
    protected List<CodeableConcept> classifier;

    /**
     * Provenance and copyright of classification.
     */
    @Child(name = "whoClassified", type = {}, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Provenance and copyright of classification", formalDefinition = "Provenance and copyright of classification.")
    protected CitationCitedArtifactClassificationWhoClassifiedComponent whoClassified;

    private static final long serialVersionUID = -1887617918L;

    /**
     * Constructor
     */
    public CitationCitedArtifactClassificationComponent() {
      super();
    }

    /**
     * @return {@link #type} (The kind of classifier (e.g. publication type,
     *         keyword).)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactClassificationComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The kind of classifier (e.g. publication type,
     *              keyword).)
     */
    public CitationCitedArtifactClassificationComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #classifier} (The specific classification value.)
     */
    public List<CodeableConcept> getClassifier() {
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      return this.classifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactClassificationComponent setClassifier(List<CodeableConcept> theClassifier) {
      this.classifier = theClassifier;
      return this;
    }

    public boolean hasClassifier() {
      if (this.classifier == null)
        return false;
      for (CodeableConcept item : this.classifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addClassifier() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return t;
    }

    public CitationCitedArtifactClassificationComponent addClassifier(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classifier}, creating
     *         it if it does not already exist {3}
     */
    public CodeableConcept getClassifierFirstRep() {
      if (getClassifier().isEmpty()) {
        addClassifier();
      }
      return getClassifier().get(0);
    }

    /**
     * @return {@link #whoClassified} (Provenance and copyright of classification.)
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent getWhoClassified() {
      if (this.whoClassified == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactClassificationComponent.whoClassified");
        else if (Configuration.doAutoCreate())
          this.whoClassified = new CitationCitedArtifactClassificationWhoClassifiedComponent(); // cc
      return this.whoClassified;
    }

    public boolean hasWhoClassified() {
      return this.whoClassified != null && !this.whoClassified.isEmpty();
    }

    /**
     * @param value {@link #whoClassified} (Provenance and copyright of
     *              classification.)
     */
    public CitationCitedArtifactClassificationComponent setWhoClassified(
        CitationCitedArtifactClassificationWhoClassifiedComponent value) {
      this.whoClassified = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept", "The kind of classifier (e.g. publication type, keyword).",
          0, 1, type));
      children.add(new Property("classifier", "CodeableConcept", "The specific classification value.", 0,
          java.lang.Integer.MAX_VALUE, classifier));
      children
          .add(new Property("whoClassified", "", "Provenance and copyright of classification.", 0, 1, whoClassified));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "The kind of classifier (e.g. publication type, keyword).", 0, 1, type);
      case -281470431:
        /* classifier */ return new Property("classifier", "CodeableConcept", "The specific classification value.", 0,
            java.lang.Integer.MAX_VALUE, classifier);
      case -196629391:
        /* whoClassified */ return new Property("whoClassified", "", "Provenance and copyright of classification.", 0,
            1, whoClassified);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -281470431:
        /* classifier */ return this.classifier == null ? new Base[0]
            : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
      case -196629391:
        /* whoClassified */ return this.whoClassified == null ? new Base[0] : new Base[] { this.whoClassified }; // CitationCitedArtifactClassificationWhoClassifiedComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -281470431: // classifier
        this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case -196629391: // whoClassified
        this.whoClassified = (CitationCitedArtifactClassificationWhoClassifiedComponent) value; // CitationCitedArtifactClassificationWhoClassifiedComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("classifier")) {
        this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("whoClassified")) {
        this.whoClassified = (CitationCitedArtifactClassificationWhoClassifiedComponent) value; // CitationCitedArtifactClassificationWhoClassifiedComponent
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case -281470431:
        return addClassifier();
      case -196629391:
        return getWhoClassified();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -281470431:
        /* classifier */ return new String[] { "CodeableConcept" };
      case -196629391:
        /* whoClassified */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("classifier")) {
        return addClassifier();
      } else if (name.equals("whoClassified")) {
        this.whoClassified = new CitationCitedArtifactClassificationWhoClassifiedComponent();
        return this.whoClassified;
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactClassificationComponent copy() {
      CitationCitedArtifactClassificationComponent dst = new CitationCitedArtifactClassificationComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactClassificationComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      if (classifier != null) {
        dst.classifier = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : classifier)
          dst.classifier.add(i.copy());
      }
      ;
      dst.whoClassified = whoClassified == null ? null : whoClassified.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactClassificationComponent))
        return false;
      CitationCitedArtifactClassificationComponent o = (CitationCitedArtifactClassificationComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(classifier, o.classifier, true)
          && compareDeep(whoClassified, o.whoClassified, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactClassificationComponent))
        return false;
      CitationCitedArtifactClassificationComponent o = (CitationCitedArtifactClassificationComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classifier, whoClassified);
    }

    public String fhirType() {
      return "Citation.citedArtifact.classification";

    }

  }

  @Block()
  public static class CitationCitedArtifactClassificationWhoClassifiedComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Person who created the classification.
     */
    @Child(name = "person", type = { Person.class,
        Practitioner.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Person who created the classification", formalDefinition = "Person who created the classification.")
    protected Reference person;

    /**
     * Organization who created the classification.
     */
    @Child(name = "organization", type = {
        Organization.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Organization who created the classification", formalDefinition = "Organization who created the classification.")
    protected Reference organization;

    /**
     * The publisher of the classification, not the publisher of the article or
     * artifact being cited.
     */
    @Child(name = "publisher", type = {
        Organization.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The publisher of the classification, not the publisher of the article or artifact being cited", formalDefinition = "The publisher of the classification, not the publisher of the article or artifact being cited.")
    protected Reference publisher;

    /**
     * Rights management statement for the classification.
     */
    @Child(name = "classifierCopyright", type = {
        StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Rights management statement for the classification", formalDefinition = "Rights management statement for the classification.")
    protected StringType classifierCopyright;

    /**
     * Acceptable to re-use the classification.
     */
    @Child(name = "freeToShare", type = {
        BooleanType.class }, order = 5, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Acceptable to re-use the classification", formalDefinition = "Acceptable to re-use the classification.")
    protected BooleanType freeToShare;

    private static final long serialVersionUID = -1835300032L;

    /**
     * Constructor
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent() {
      super();
    }

    /**
     * @return {@link #person} (Person who created the classification.)
     */
    public Reference getPerson() {
      if (this.person == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactClassificationWhoClassifiedComponent.person");
        else if (Configuration.doAutoCreate())
          this.person = new Reference(); // cc
      return this.person;
    }

    public boolean hasPerson() {
      return this.person != null && !this.person.isEmpty();
    }

    /**
     * @param value {@link #person} (Person who created the classification.)
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setPerson(Reference value) {
      this.person = value;
      return this;
    }

    /**
     * @return {@link #organization} (Organization who created the classification.)
     */
    public Reference getOrganization() {
      if (this.organization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactClassificationWhoClassifiedComponent.organization");
        else if (Configuration.doAutoCreate())
          this.organization = new Reference(); // cc
      return this.organization;
    }

    public boolean hasOrganization() {
      return this.organization != null && !this.organization.isEmpty();
    }

    /**
     * @param value {@link #organization} (Organization who created the
     *              classification.)
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setOrganization(Reference value) {
      this.organization = value;
      return this;
    }

    /**
     * @return {@link #publisher} (The publisher of the classification, not the
     *         publisher of the article or artifact being cited.)
     */
    public Reference getPublisher() {
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactClassificationWhoClassifiedComponent.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new Reference(); // cc
      return this.publisher;
    }

    public boolean hasPublisher() {
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (The publisher of the classification, not the
     *              publisher of the article or artifact being cited.)
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setPublisher(Reference value) {
      this.publisher = value;
      return this;
    }

    /**
     * @return {@link #classifierCopyright} (Rights management statement for the
     *         classification.). This is the underlying object with id, value and
     *         extensions. The accessor "getClassifierCopyright" gives direct access
     *         to the value
     */
    public StringType getClassifierCopyrightElement() {
      if (this.classifierCopyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactClassificationWhoClassifiedComponent.classifierCopyright");
        else if (Configuration.doAutoCreate())
          this.classifierCopyright = new StringType(); // bb
      return this.classifierCopyright;
    }

    public boolean hasClassifierCopyrightElement() {
      return this.classifierCopyright != null && !this.classifierCopyright.isEmpty();
    }

    public boolean hasClassifierCopyright() {
      return this.classifierCopyright != null && !this.classifierCopyright.isEmpty();
    }

    /**
     * @param value {@link #classifierCopyright} (Rights management statement for
     *              the classification.). This is the underlying object with id,
     *              value and extensions. The accessor "getClassifierCopyright"
     *              gives direct access to the value
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setClassifierCopyrightElement(StringType value) {
      this.classifierCopyright = value;
      return this;
    }

    /**
     * @return Rights management statement for the classification.
     */
    public String getClassifierCopyright() {
      return this.classifierCopyright == null ? null : this.classifierCopyright.getValue();
    }

    /**
     * @param value Rights management statement for the classification.
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setClassifierCopyright(String value) {
      if (Utilities.noString(value))
        this.classifierCopyright = null;
      else {
        if (this.classifierCopyright == null)
          this.classifierCopyright = new StringType();
        this.classifierCopyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #freeToShare} (Acceptable to re-use the classification.). This
     *         is the underlying object with id, value and extensions. The accessor
     *         "getFreeToShare" gives direct access to the value
     */
    public BooleanType getFreeToShareElement() {
      if (this.freeToShare == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactClassificationWhoClassifiedComponent.freeToShare");
        else if (Configuration.doAutoCreate())
          this.freeToShare = new BooleanType(); // bb
      return this.freeToShare;
    }

    public boolean hasFreeToShareElement() {
      return this.freeToShare != null && !this.freeToShare.isEmpty();
    }

    public boolean hasFreeToShare() {
      return this.freeToShare != null && !this.freeToShare.isEmpty();
    }

    /**
     * @param value {@link #freeToShare} (Acceptable to re-use the classification.).
     *              This is the underlying object with id, value and extensions. The
     *              accessor "getFreeToShare" gives direct access to the value
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setFreeToShareElement(BooleanType value) {
      this.freeToShare = value;
      return this;
    }

    /**
     * @return Acceptable to re-use the classification.
     */
    public boolean getFreeToShare() {
      return this.freeToShare == null || this.freeToShare.isEmpty() ? false : this.freeToShare.getValue();
    }

    /**
     * @param value Acceptable to re-use the classification.
     */
    public CitationCitedArtifactClassificationWhoClassifiedComponent setFreeToShare(boolean value) {
      if (this.freeToShare == null)
        this.freeToShare = new BooleanType();
      this.freeToShare.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("person", "Reference(Person|Practitioner)", "Person who created the classification.", 0,
          1, person));
      children.add(new Property("organization", "Reference(Organization)",
          "Organization who created the classification.", 0, 1, organization));
      children.add(new Property("publisher", "Reference(Organization)",
          "The publisher of the classification, not the publisher of the article or artifact being cited.", 0, 1,
          publisher));
      children.add(new Property("classifierCopyright", "string", "Rights management statement for the classification.",
          0, 1, classifierCopyright));
      children
          .add(new Property("freeToShare", "boolean", "Acceptable to re-use the classification.", 0, 1, freeToShare));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -991716523:
        /* person */ return new Property("person", "Reference(Person|Practitioner)",
            "Person who created the classification.", 0, 1, person);
      case 1178922291:
        /* organization */ return new Property("organization", "Reference(Organization)",
            "Organization who created the classification.", 0, 1, organization);
      case 1447404028:
        /* publisher */ return new Property("publisher", "Reference(Organization)",
            "The publisher of the classification, not the publisher of the article or artifact being cited.", 0, 1,
            publisher);
      case -434942298:
        /* classifierCopyright */ return new Property("classifierCopyright", "string",
            "Rights management statement for the classification.", 0, 1, classifierCopyright);
      case -1268656616:
        /* freeToShare */ return new Property("freeToShare", "boolean", "Acceptable to re-use the classification.", 0,
            1, freeToShare);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -991716523:
        /* person */ return this.person == null ? new Base[0] : new Base[] { this.person }; // Reference
      case 1178922291:
        /* organization */ return this.organization == null ? new Base[0] : new Base[] { this.organization }; // Reference
      case 1447404028:
        /* publisher */ return this.publisher == null ? new Base[0] : new Base[] { this.publisher }; // Reference
      case -434942298:
        /* classifierCopyright */ return this.classifierCopyright == null ? new Base[0]
            : new Base[] { this.classifierCopyright }; // StringType
      case -1268656616:
        /* freeToShare */ return this.freeToShare == null ? new Base[0] : new Base[] { this.freeToShare }; // BooleanType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -991716523: // person
        this.person = TypeConvertor.castToReference(value); // Reference
        return value;
      case 1178922291: // organization
        this.organization = TypeConvertor.castToReference(value); // Reference
        return value;
      case 1447404028: // publisher
        this.publisher = TypeConvertor.castToReference(value); // Reference
        return value;
      case -434942298: // classifierCopyright
        this.classifierCopyright = TypeConvertor.castToString(value); // StringType
        return value;
      case -1268656616: // freeToShare
        this.freeToShare = TypeConvertor.castToBoolean(value); // BooleanType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("person")) {
        this.person = TypeConvertor.castToReference(value); // Reference
      } else if (name.equals("organization")) {
        this.organization = TypeConvertor.castToReference(value); // Reference
      } else if (name.equals("publisher")) {
        this.publisher = TypeConvertor.castToReference(value); // Reference
      } else if (name.equals("classifierCopyright")) {
        this.classifierCopyright = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("freeToShare")) {
        this.freeToShare = TypeConvertor.castToBoolean(value); // BooleanType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -991716523:
        return getPerson();
      case 1178922291:
        return getOrganization();
      case 1447404028:
        return getPublisher();
      case -434942298:
        return getClassifierCopyrightElement();
      case -1268656616:
        return getFreeToShareElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -991716523:
        /* person */ return new String[] { "Reference" };
      case 1178922291:
        /* organization */ return new String[] { "Reference" };
      case 1447404028:
        /* publisher */ return new String[] { "Reference" };
      case -434942298:
        /* classifierCopyright */ return new String[] { "string" };
      case -1268656616:
        /* freeToShare */ return new String[] { "boolean" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("person")) {
        this.person = new Reference();
        return this.person;
      } else if (name.equals("organization")) {
        this.organization = new Reference();
        return this.organization;
      } else if (name.equals("publisher")) {
        this.publisher = new Reference();
        return this.publisher;
      } else if (name.equals("classifierCopyright")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.classification.whoClassified.classifierCopyright");
      } else if (name.equals("freeToShare")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.classification.whoClassified.freeToShare");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactClassificationWhoClassifiedComponent copy() {
      CitationCitedArtifactClassificationWhoClassifiedComponent dst = new CitationCitedArtifactClassificationWhoClassifiedComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactClassificationWhoClassifiedComponent dst) {
      super.copyValues(dst);
      dst.person = person == null ? null : person.copy();
      dst.organization = organization == null ? null : organization.copy();
      dst.publisher = publisher == null ? null : publisher.copy();
      dst.classifierCopyright = classifierCopyright == null ? null : classifierCopyright.copy();
      dst.freeToShare = freeToShare == null ? null : freeToShare.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactClassificationWhoClassifiedComponent))
        return false;
      CitationCitedArtifactClassificationWhoClassifiedComponent o = (CitationCitedArtifactClassificationWhoClassifiedComponent) other_;
      return compareDeep(person, o.person, true) && compareDeep(organization, o.organization, true)
          && compareDeep(publisher, o.publisher, true) && compareDeep(classifierCopyright, o.classifierCopyright, true)
          && compareDeep(freeToShare, o.freeToShare, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactClassificationWhoClassifiedComponent))
        return false;
      CitationCitedArtifactClassificationWhoClassifiedComponent o = (CitationCitedArtifactClassificationWhoClassifiedComponent) other_;
      return compareValues(classifierCopyright, o.classifierCopyright, true)
          && compareValues(freeToShare, o.freeToShare, true);
    }

    public boolean isEmpty() {
      return super.isEmpty()
          && ca.uhn.fhir.util.ElementUtil.isEmpty(person, organization, publisher, classifierCopyright, freeToShare);
    }

    public String fhirType() {
      return "Citation.citedArtifact.classification.whoClassified";

    }

  }

  @Block()
  public static class CitationCitedArtifactContributorshipComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Indicates if the list includes all authors and/or contributors.
     */
    @Child(name = "complete", type = {
        BooleanType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Indicates if the list includes all authors and/or contributors", formalDefinition = "Indicates if the list includes all authors and/or contributors.")
    protected BooleanType complete;

    /**
     * An individual entity named in the author list or contributor list.
     */
    @Child(name = "entry", type = {}, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "An individual entity named in the list", formalDefinition = "An individual entity named in the author list or contributor list.")
    protected List<CitationCitedArtifactContributorshipEntryComponent> entry;

    /**
     * Used to record a display of the author/contributor list without separate
     * coding for each list member.
     */
    @Child(name = "summary", type = {}, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Used to record a display of the author/contributor list without separate coding for each list member", formalDefinition = "Used to record a display of the author/contributor list without separate coding for each list member.")
    protected List<CitationCitedArtifactContributorshipSummaryComponent> summary;

    private static final long serialVersionUID = 78346599L;

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipComponent() {
      super();
    }

    /**
     * @return {@link #complete} (Indicates if the list includes all authors and/or
     *         contributors.). This is the underlying object with id, value and
     *         extensions. The accessor "getComplete" gives direct access to the
     *         value
     */
    public BooleanType getCompleteElement() {
      if (this.complete == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipComponent.complete");
        else if (Configuration.doAutoCreate())
          this.complete = new BooleanType(); // bb
      return this.complete;
    }

    public boolean hasCompleteElement() {
      return this.complete != null && !this.complete.isEmpty();
    }

    public boolean hasComplete() {
      return this.complete != null && !this.complete.isEmpty();
    }

    /**
     * @param value {@link #complete} (Indicates if the list includes all authors
     *              and/or contributors.). This is the underlying object with id,
     *              value and extensions. The accessor "getComplete" gives direct
     *              access to the value
     */
    public CitationCitedArtifactContributorshipComponent setCompleteElement(BooleanType value) {
      this.complete = value;
      return this;
    }

    /**
     * @return Indicates if the list includes all authors and/or contributors.
     */
    public boolean getComplete() {
      return this.complete == null || this.complete.isEmpty() ? false : this.complete.getValue();
    }

    /**
     * @param value Indicates if the list includes all authors and/or contributors.
     */
    public CitationCitedArtifactContributorshipComponent setComplete(boolean value) {
      if (this.complete == null)
        this.complete = new BooleanType();
      this.complete.setValue(value);
      return this;
    }

    /**
     * @return {@link #entry} (An individual entity named in the author list or
     *         contributor list.)
     */
    public List<CitationCitedArtifactContributorshipEntryComponent> getEntry() {
      if (this.entry == null)
        this.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
      return this.entry;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipComponent setEntry(
        List<CitationCitedArtifactContributorshipEntryComponent> theEntry) {
      this.entry = theEntry;
      return this;
    }

    public boolean hasEntry() {
      if (this.entry == null)
        return false;
      for (CitationCitedArtifactContributorshipEntryComponent item : this.entry)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactContributorshipEntryComponent addEntry() { // 3
      CitationCitedArtifactContributorshipEntryComponent t = new CitationCitedArtifactContributorshipEntryComponent();
      if (this.entry == null)
        this.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
      this.entry.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipComponent addEntry(
        CitationCitedArtifactContributorshipEntryComponent t) { // 3
      if (t == null)
        return this;
      if (this.entry == null)
        this.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
      this.entry.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #entry}, creating it
     *         if it does not already exist {3}
     */
    public CitationCitedArtifactContributorshipEntryComponent getEntryFirstRep() {
      if (getEntry().isEmpty()) {
        addEntry();
      }
      return getEntry().get(0);
    }

    /**
     * @return {@link #summary} (Used to record a display of the author/contributor
     *         list without separate coding for each list member.)
     */
    public List<CitationCitedArtifactContributorshipSummaryComponent> getSummary() {
      if (this.summary == null)
        this.summary = new ArrayList<CitationCitedArtifactContributorshipSummaryComponent>();
      return this.summary;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipComponent setSummary(
        List<CitationCitedArtifactContributorshipSummaryComponent> theSummary) {
      this.summary = theSummary;
      return this;
    }

    public boolean hasSummary() {
      if (this.summary == null)
        return false;
      for (CitationCitedArtifactContributorshipSummaryComponent item : this.summary)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactContributorshipSummaryComponent addSummary() { // 3
      CitationCitedArtifactContributorshipSummaryComponent t = new CitationCitedArtifactContributorshipSummaryComponent();
      if (this.summary == null)
        this.summary = new ArrayList<CitationCitedArtifactContributorshipSummaryComponent>();
      this.summary.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipComponent addSummary(
        CitationCitedArtifactContributorshipSummaryComponent t) { // 3
      if (t == null)
        return this;
      if (this.summary == null)
        this.summary = new ArrayList<CitationCitedArtifactContributorshipSummaryComponent>();
      this.summary.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #summary}, creating it
     *         if it does not already exist {3}
     */
    public CitationCitedArtifactContributorshipSummaryComponent getSummaryFirstRep() {
      if (getSummary().isEmpty()) {
        addSummary();
      }
      return getSummary().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("complete", "boolean",
          "Indicates if the list includes all authors and/or contributors.", 0, 1, complete));
      children.add(new Property("entry", "", "An individual entity named in the author list or contributor list.", 0,
          java.lang.Integer.MAX_VALUE, entry));
      children.add(new Property("summary", "",
          "Used to record a display of the author/contributor list without separate coding for each list member.", 0,
          java.lang.Integer.MAX_VALUE, summary));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -599445191:
        /* complete */ return new Property("complete", "boolean",
            "Indicates if the list includes all authors and/or contributors.", 0, 1, complete);
      case 96667762:
        /* entry */ return new Property("entry", "",
            "An individual entity named in the author list or contributor list.", 0, java.lang.Integer.MAX_VALUE,
            entry);
      case -1857640538:
        /* summary */ return new Property("summary", "",
            "Used to record a display of the author/contributor list without separate coding for each list member.", 0,
            java.lang.Integer.MAX_VALUE, summary);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -599445191:
        /* complete */ return this.complete == null ? new Base[0] : new Base[] { this.complete }; // BooleanType
      case 96667762:
        /* entry */ return this.entry == null ? new Base[0] : this.entry.toArray(new Base[this.entry.size()]); // CitationCitedArtifactContributorshipEntryComponent
      case -1857640538:
        /* summary */ return this.summary == null ? new Base[0] : this.summary.toArray(new Base[this.summary.size()]); // CitationCitedArtifactContributorshipSummaryComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -599445191: // complete
        this.complete = TypeConvertor.castToBoolean(value); // BooleanType
        return value;
      case 96667762: // entry
        this.getEntry().add((CitationCitedArtifactContributorshipEntryComponent) value); // CitationCitedArtifactContributorshipEntryComponent
        return value;
      case -1857640538: // summary
        this.getSummary().add((CitationCitedArtifactContributorshipSummaryComponent) value); // CitationCitedArtifactContributorshipSummaryComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("complete")) {
        this.complete = TypeConvertor.castToBoolean(value); // BooleanType
      } else if (name.equals("entry")) {
        this.getEntry().add((CitationCitedArtifactContributorshipEntryComponent) value);
      } else if (name.equals("summary")) {
        this.getSummary().add((CitationCitedArtifactContributorshipSummaryComponent) value);
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -599445191:
        return getCompleteElement();
      case 96667762:
        return addEntry();
      case -1857640538:
        return addSummary();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -599445191:
        /* complete */ return new String[] { "boolean" };
      case 96667762:
        /* entry */ return new String[] {};
      case -1857640538:
        /* summary */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("complete")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.complete");
      } else if (name.equals("entry")) {
        return addEntry();
      } else if (name.equals("summary")) {
        return addSummary();
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactContributorshipComponent copy() {
      CitationCitedArtifactContributorshipComponent dst = new CitationCitedArtifactContributorshipComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactContributorshipComponent dst) {
      super.copyValues(dst);
      dst.complete = complete == null ? null : complete.copy();
      if (entry != null) {
        dst.entry = new ArrayList<CitationCitedArtifactContributorshipEntryComponent>();
        for (CitationCitedArtifactContributorshipEntryComponent i : entry)
          dst.entry.add(i.copy());
      }
      ;
      if (summary != null) {
        dst.summary = new ArrayList<CitationCitedArtifactContributorshipSummaryComponent>();
        for (CitationCitedArtifactContributorshipSummaryComponent i : summary)
          dst.summary.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipComponent))
        return false;
      CitationCitedArtifactContributorshipComponent o = (CitationCitedArtifactContributorshipComponent) other_;
      return compareDeep(complete, o.complete, true) && compareDeep(entry, o.entry, true)
          && compareDeep(summary, o.summary, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipComponent))
        return false;
      CitationCitedArtifactContributorshipComponent o = (CitationCitedArtifactContributorshipComponent) other_;
      return compareValues(complete, o.complete, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(complete, entry, summary);
    }

    public String fhirType() {
      return "Citation.citedArtifact.contributorship";

    }

  }

  @Block()
  public static class CitationCitedArtifactContributorshipEntryComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * A name associated with the individual.
     */
    @Child(name = "name", type = { HumanName.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "A name associated with the person", formalDefinition = "A name associated with the individual.")
    protected HumanName name;

    /**
     * Initials for forename.
     */
    @Child(name = "initials", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Initials for forename", formalDefinition = "Initials for forename.")
    protected StringType initials;

    /**
     * Used for collective or corporate name as an author.
     */
    @Child(name = "collectiveName", type = {
        StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used for collective or corporate name as an author", formalDefinition = "Used for collective or corporate name as an author.")
    protected StringType collectiveName;

    /**
     * Unique person identifier.
     */
    @Child(name = "identifier", type = {
        Identifier.class }, order = 4, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Author identifier, eg ORCID", formalDefinition = "Unique person identifier.")
    protected List<Identifier> identifier;

    /**
     * Organization affiliated with the entity.
     */
    @Child(name = "affiliationInfo", type = {}, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Organizational affiliation", formalDefinition = "Organization affiliated with the entity.")
    protected List<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent> affiliationInfo;

    /**
     * Physical mailing address for the author or contributor.
     */
    @Child(name = "address", type = {
        Address.class }, order = 6, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Physical mailing address", formalDefinition = "Physical mailing address for the author or contributor.")
    protected List<Address> address;

    /**
     * Email or telephone contact methods for the author or contributor.
     */
    @Child(name = "telecom", type = {
        ContactPoint.class }, order = 7, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Email or telephone contact methods for the author or contributor", formalDefinition = "Email or telephone contact methods for the author or contributor.")
    protected List<ContactPoint> telecom;

    /**
     * This element identifies the specific nature of an individual’s contribution
     * with respect to the cited work.
     */
    @Child(name = "contributionType", type = {
        CodeableConcept.class }, order = 8, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "The specific contribution", formalDefinition = "This element identifies the specific nature of an individual’s contribution with respect to the cited work.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/artifact-contribution-type")
    protected List<CodeableConcept> contributionType;

    /**
     * The role of the contributor (e.g. author, editor, reviewer).
     */
    @Child(name = "role", type = {
        CodeableConcept.class }, order = 9, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The role of the contributor (e.g. author, editor, reviewer)", formalDefinition = "The role of the contributor (e.g. author, editor, reviewer).")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/contributor-role")
    protected CodeableConcept role;

    /**
     * Contributions with accounting for time or number.
     */
    @Child(name = "contributionInstance", type = {}, order = 10, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Contributions with accounting for time or number", formalDefinition = "Contributions with accounting for time or number.")
    protected List<CitationCitedArtifactContributorshipEntryContributionInstanceComponent> contributionInstance;

    /**
     * Indication of which contributor is the corresponding contributor for the
     * role.
     */
    @Child(name = "correspondingContact", type = {
        BooleanType.class }, order = 11, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Indication of which contributor is the corresponding contributor for the role", formalDefinition = "Indication of which contributor is the corresponding contributor for the role.")
    protected BooleanType correspondingContact;

    /**
     * Used to code order of authors.
     */
    @Child(name = "listOrder", type = {
        PositiveIntType.class }, order = 12, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used to code order of authors", formalDefinition = "Used to code order of authors.")
    protected PositiveIntType listOrder;

    private static final long serialVersionUID = -1994433623L;

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipEntryComponent() {
      super();
    }

    /**
     * @return {@link #name} (A name associated with the individual.)
     */
    public HumanName getName() {
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.name");
        else if (Configuration.doAutoCreate())
          this.name = new HumanName(); // cc
      return this.name;
    }

    public boolean hasName() {
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A name associated with the individual.)
     */
    public CitationCitedArtifactContributorshipEntryComponent setName(HumanName value) {
      this.name = value;
      return this;
    }

    /**
     * @return {@link #initials} (Initials for forename.). This is the underlying
     *         object with id, value and extensions. The accessor "getInitials"
     *         gives direct access to the value
     */
    public StringType getInitialsElement() {
      if (this.initials == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.initials");
        else if (Configuration.doAutoCreate())
          this.initials = new StringType(); // bb
      return this.initials;
    }

    public boolean hasInitialsElement() {
      return this.initials != null && !this.initials.isEmpty();
    }

    public boolean hasInitials() {
      return this.initials != null && !this.initials.isEmpty();
    }

    /**
     * @param value {@link #initials} (Initials for forename.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getInitials" gives direct access to the value
     */
    public CitationCitedArtifactContributorshipEntryComponent setInitialsElement(StringType value) {
      this.initials = value;
      return this;
    }

    /**
     * @return Initials for forename.
     */
    public String getInitials() {
      return this.initials == null ? null : this.initials.getValue();
    }

    /**
     * @param value Initials for forename.
     */
    public CitationCitedArtifactContributorshipEntryComponent setInitials(String value) {
      if (Utilities.noString(value))
        this.initials = null;
      else {
        if (this.initials == null)
          this.initials = new StringType();
        this.initials.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #collectiveName} (Used for collective or corporate name as an
     *         author.). This is the underlying object with id, value and
     *         extensions. The accessor "getCollectiveName" gives direct access to
     *         the value
     */
    public StringType getCollectiveNameElement() {
      if (this.collectiveName == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.collectiveName");
        else if (Configuration.doAutoCreate())
          this.collectiveName = new StringType(); // bb
      return this.collectiveName;
    }

    public boolean hasCollectiveNameElement() {
      return this.collectiveName != null && !this.collectiveName.isEmpty();
    }

    public boolean hasCollectiveName() {
      return this.collectiveName != null && !this.collectiveName.isEmpty();
    }

    /**
     * @param value {@link #collectiveName} (Used for collective or corporate name
     *              as an author.). This is the underlying object with id, value and
     *              extensions. The accessor "getCollectiveName" gives direct access
     *              to the value
     */
    public CitationCitedArtifactContributorshipEntryComponent setCollectiveNameElement(StringType value) {
      this.collectiveName = value;
      return this;
    }

    /**
     * @return Used for collective or corporate name as an author.
     */
    public String getCollectiveName() {
      return this.collectiveName == null ? null : this.collectiveName.getValue();
    }

    /**
     * @param value Used for collective or corporate name as an author.
     */
    public CitationCitedArtifactContributorshipEntryComponent setCollectiveName(String value) {
      if (Utilities.noString(value))
        this.collectiveName = null;
      else {
        if (this.collectiveName == null)
          this.collectiveName = new StringType();
        this.collectiveName.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (Unique person identifier.)
     */
    public List<Identifier> getIdentifier() {
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryComponent setIdentifier(List<Identifier> theIdentifier) {
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

    public Identifier addIdentifier() { // 3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryComponent addIdentifier(Identifier t) { // 3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating
     *         it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() {
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #affiliationInfo} (Organization affiliated with the entity.)
     */
    public List<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent> getAffiliationInfo() {
      if (this.affiliationInfo == null)
        this.affiliationInfo = new ArrayList<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent>();
      return this.affiliationInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryComponent setAffiliationInfo(
        List<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent> theAffiliationInfo) {
      this.affiliationInfo = theAffiliationInfo;
      return this;
    }

    public boolean hasAffiliationInfo() {
      if (this.affiliationInfo == null)
        return false;
      for (CitationCitedArtifactContributorshipEntryAffiliationInfoComponent item : this.affiliationInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent addAffiliationInfo() { // 3
      CitationCitedArtifactContributorshipEntryAffiliationInfoComponent t = new CitationCitedArtifactContributorshipEntryAffiliationInfoComponent();
      if (this.affiliationInfo == null)
        this.affiliationInfo = new ArrayList<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent>();
      this.affiliationInfo.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryComponent addAffiliationInfo(
        CitationCitedArtifactContributorshipEntryAffiliationInfoComponent t) { // 3
      if (t == null)
        return this;
      if (this.affiliationInfo == null)
        this.affiliationInfo = new ArrayList<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent>();
      this.affiliationInfo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #affiliationInfo},
     *         creating it if it does not already exist {3}
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent getAffiliationInfoFirstRep() {
      if (getAffiliationInfo().isEmpty()) {
        addAffiliationInfo();
      }
      return getAffiliationInfo().get(0);
    }

    /**
     * @return {@link #address} (Physical mailing address for the author or
     *         contributor.)
     */
    public List<Address> getAddress() {
      if (this.address == null)
        this.address = new ArrayList<Address>();
      return this.address;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryComponent setAddress(List<Address> theAddress) {
      this.address = theAddress;
      return this;
    }

    public boolean hasAddress() {
      if (this.address == null)
        return false;
      for (Address item : this.address)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Address addAddress() { // 3
      Address t = new Address();
      if (this.address == null)
        this.address = new ArrayList<Address>();
      this.address.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryComponent addAddress(Address t) { // 3
      if (t == null)
        return this;
      if (this.address == null)
        this.address = new ArrayList<Address>();
      this.address.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #address}, creating it
     *         if it does not already exist {3}
     */
    public Address getAddressFirstRep() {
      if (getAddress().isEmpty()) {
        addAddress();
      }
      return getAddress().get(0);
    }

    /**
     * @return {@link #telecom} (Email or telephone contact methods for the author
     *         or contributor.)
     */
    public List<ContactPoint> getTelecom() {
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      return this.telecom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryComponent setTelecom(List<ContactPoint> theTelecom) {
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

    public ContactPoint addTelecom() { // 3
      ContactPoint t = new ContactPoint();
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryComponent addTelecom(ContactPoint t) { // 3
      if (t == null)
        return this;
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #telecom}, creating it
     *         if it does not already exist {3}
     */
    public ContactPoint getTelecomFirstRep() {
      if (getTelecom().isEmpty()) {
        addTelecom();
      }
      return getTelecom().get(0);
    }

    /**
     * @return {@link #contributionType} (This element identifies the specific
     *         nature of an individual’s contribution with respect to the cited
     *         work.)
     */
    public List<CodeableConcept> getContributionType() {
      if (this.contributionType == null)
        this.contributionType = new ArrayList<CodeableConcept>();
      return this.contributionType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryComponent setContributionType(
        List<CodeableConcept> theContributionType) {
      this.contributionType = theContributionType;
      return this;
    }

    public boolean hasContributionType() {
      if (this.contributionType == null)
        return false;
      for (CodeableConcept item : this.contributionType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addContributionType() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.contributionType == null)
        this.contributionType = new ArrayList<CodeableConcept>();
      this.contributionType.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryComponent addContributionType(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.contributionType == null)
        this.contributionType = new ArrayList<CodeableConcept>();
      this.contributionType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contributionType},
     *         creating it if it does not already exist {3}
     */
    public CodeableConcept getContributionTypeFirstRep() {
      if (getContributionType().isEmpty()) {
        addContributionType();
      }
      return getContributionType().get(0);
    }

    /**
     * @return {@link #role} (The role of the contributor (e.g. author, editor,
     *         reviewer).)
     */
    public CodeableConcept getRole() {
      if (this.role == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.role");
        else if (Configuration.doAutoCreate())
          this.role = new CodeableConcept(); // cc
      return this.role;
    }

    public boolean hasRole() {
      return this.role != null && !this.role.isEmpty();
    }

    /**
     * @param value {@link #role} (The role of the contributor (e.g. author, editor,
     *              reviewer).)
     */
    public CitationCitedArtifactContributorshipEntryComponent setRole(CodeableConcept value) {
      this.role = value;
      return this;
    }

    /**
     * @return {@link #contributionInstance} (Contributions with accounting for time
     *         or number.)
     */
    public List<CitationCitedArtifactContributorshipEntryContributionInstanceComponent> getContributionInstance() {
      if (this.contributionInstance == null)
        this.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
      return this.contributionInstance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryComponent setContributionInstance(
        List<CitationCitedArtifactContributorshipEntryContributionInstanceComponent> theContributionInstance) {
      this.contributionInstance = theContributionInstance;
      return this;
    }

    public boolean hasContributionInstance() {
      if (this.contributionInstance == null)
        return false;
      for (CitationCitedArtifactContributorshipEntryContributionInstanceComponent item : this.contributionInstance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent addContributionInstance() { // 3
      CitationCitedArtifactContributorshipEntryContributionInstanceComponent t = new CitationCitedArtifactContributorshipEntryContributionInstanceComponent();
      if (this.contributionInstance == null)
        this.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
      this.contributionInstance.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryComponent addContributionInstance(
        CitationCitedArtifactContributorshipEntryContributionInstanceComponent t) { // 3
      if (t == null)
        return this;
      if (this.contributionInstance == null)
        this.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
      this.contributionInstance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field
     *         {@link #contributionInstance}, creating it if it does not already
     *         exist {3}
     */
    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent getContributionInstanceFirstRep() {
      if (getContributionInstance().isEmpty()) {
        addContributionInstance();
      }
      return getContributionInstance().get(0);
    }

    /**
     * @return {@link #correspondingContact} (Indication of which contributor is the
     *         corresponding contributor for the role.). This is the underlying
     *         object with id, value and extensions. The accessor
     *         "getCorrespondingContact" gives direct access to the value
     */
    public BooleanType getCorrespondingContactElement() {
      if (this.correspondingContact == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.correspondingContact");
        else if (Configuration.doAutoCreate())
          this.correspondingContact = new BooleanType(); // bb
      return this.correspondingContact;
    }

    public boolean hasCorrespondingContactElement() {
      return this.correspondingContact != null && !this.correspondingContact.isEmpty();
    }

    public boolean hasCorrespondingContact() {
      return this.correspondingContact != null && !this.correspondingContact.isEmpty();
    }

    /**
     * @param value {@link #correspondingContact} (Indication of which contributor
     *              is the corresponding contributor for the role.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getCorrespondingContact" gives direct access to the value
     */
    public CitationCitedArtifactContributorshipEntryComponent setCorrespondingContactElement(BooleanType value) {
      this.correspondingContact = value;
      return this;
    }

    /**
     * @return Indication of which contributor is the corresponding contributor for
     *         the role.
     */
    public boolean getCorrespondingContact() {
      return this.correspondingContact == null || this.correspondingContact.isEmpty() ? false
          : this.correspondingContact.getValue();
    }

    /**
     * @param value Indication of which contributor is the corresponding contributor
     *              for the role.
     */
    public CitationCitedArtifactContributorshipEntryComponent setCorrespondingContact(boolean value) {
      if (this.correspondingContact == null)
        this.correspondingContact = new BooleanType();
      this.correspondingContact.setValue(value);
      return this;
    }

    /**
     * @return {@link #listOrder} (Used to code order of authors.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getListOrder" gives direct access to the value
     */
    public PositiveIntType getListOrderElement() {
      if (this.listOrder == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipEntryComponent.listOrder");
        else if (Configuration.doAutoCreate())
          this.listOrder = new PositiveIntType(); // bb
      return this.listOrder;
    }

    public boolean hasListOrderElement() {
      return this.listOrder != null && !this.listOrder.isEmpty();
    }

    public boolean hasListOrder() {
      return this.listOrder != null && !this.listOrder.isEmpty();
    }

    /**
     * @param value {@link #listOrder} (Used to code order of authors.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getListOrder" gives direct access to the value
     */
    public CitationCitedArtifactContributorshipEntryComponent setListOrderElement(PositiveIntType value) {
      this.listOrder = value;
      return this;
    }

    /**
     * @return Used to code order of authors.
     */
    public int getListOrder() {
      return this.listOrder == null || this.listOrder.isEmpty() ? 0 : this.listOrder.getValue();
    }

    /**
     * @param value Used to code order of authors.
     */
    public CitationCitedArtifactContributorshipEntryComponent setListOrder(int value) {
      if (this.listOrder == null)
        this.listOrder = new PositiveIntType();
      this.listOrder.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("name", "HumanName", "A name associated with the individual.", 0, 1, name));
      children.add(new Property("initials", "string", "Initials for forename.", 0, 1, initials));
      children.add(new Property("collectiveName", "string", "Used for collective or corporate name as an author.", 0, 1,
          collectiveName));
      children.add(new Property("identifier", "Identifier", "Unique person identifier.", 0, java.lang.Integer.MAX_VALUE,
          identifier));
      children.add(new Property("affiliationInfo", "", "Organization affiliated with the entity.", 0,
          java.lang.Integer.MAX_VALUE, affiliationInfo));
      children.add(new Property("address", "Address", "Physical mailing address for the author or contributor.", 0,
          java.lang.Integer.MAX_VALUE, address));
      children.add(
          new Property("telecom", "ContactPoint", "Email or telephone contact methods for the author or contributor.",
              0, java.lang.Integer.MAX_VALUE, telecom));
      children.add(new Property("contributionType", "CodeableConcept",
          "This element identifies the specific nature of an individual’s contribution with respect to the cited work.",
          0, java.lang.Integer.MAX_VALUE, contributionType));
      children.add(new Property("role", "CodeableConcept",
          "The role of the contributor (e.g. author, editor, reviewer).", 0, 1, role));
      children.add(new Property("contributionInstance", "", "Contributions with accounting for time or number.", 0,
          java.lang.Integer.MAX_VALUE, contributionInstance));
      children.add(new Property("correspondingContact", "boolean",
          "Indication of which contributor is the corresponding contributor for the role.", 0, 1,
          correspondingContact));
      children.add(new Property("listOrder", "positiveInt", "Used to code order of authors.", 0, 1, listOrder));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3373707:
        /* name */ return new Property("name", "HumanName", "A name associated with the individual.", 0, 1, name);
      case 269062575:
        /* initials */ return new Property("initials", "string", "Initials for forename.", 0, 1, initials);
      case 502871833:
        /* collectiveName */ return new Property("collectiveName", "string",
            "Used for collective or corporate name as an author.", 0, 1, collectiveName);
      case -1618432855:
        /* identifier */ return new Property("identifier", "Identifier", "Unique person identifier.", 0,
            java.lang.Integer.MAX_VALUE, identifier);
      case -215129154:
        /* affiliationInfo */ return new Property("affiliationInfo", "", "Organization affiliated with the entity.", 0,
            java.lang.Integer.MAX_VALUE, affiliationInfo);
      case -1147692044:
        /* address */ return new Property("address", "Address",
            "Physical mailing address for the author or contributor.", 0, java.lang.Integer.MAX_VALUE, address);
      case -1429363305:
        /* telecom */ return new Property("telecom", "ContactPoint",
            "Email or telephone contact methods for the author or contributor.", 0, java.lang.Integer.MAX_VALUE,
            telecom);
      case -1600446614:
        /* contributionType */ return new Property("contributionType", "CodeableConcept",
            "This element identifies the specific nature of an individual’s contribution with respect to the cited work.",
            0, java.lang.Integer.MAX_VALUE, contributionType);
      case 3506294:
        /* role */ return new Property("role", "CodeableConcept",
            "The role of the contributor (e.g. author, editor, reviewer).", 0, 1, role);
      case -547910459:
        /* contributionInstance */ return new Property("contributionInstance", "",
            "Contributions with accounting for time or number.", 0, java.lang.Integer.MAX_VALUE, contributionInstance);
      case -1816008851:
        /* correspondingContact */ return new Property("correspondingContact", "boolean",
            "Indication of which contributor is the corresponding contributor for the role.", 0, 1,
            correspondingContact);
      case -1238918832:
        /* listOrder */ return new Property("listOrder", "positiveInt", "Used to code order of authors.", 0, 1,
            listOrder);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3373707:
        /* name */ return this.name == null ? new Base[0] : new Base[] { this.name }; // HumanName
      case 269062575:
        /* initials */ return this.initials == null ? new Base[0] : new Base[] { this.initials }; // StringType
      case 502871833:
        /* collectiveName */ return this.collectiveName == null ? new Base[0] : new Base[] { this.collectiveName }; // StringType
      case -1618432855:
        /* identifier */ return this.identifier == null ? new Base[0]
            : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
      case -215129154:
        /* affiliationInfo */ return this.affiliationInfo == null ? new Base[0]
            : this.affiliationInfo.toArray(new Base[this.affiliationInfo.size()]); // CitationCitedArtifactContributorshipEntryAffiliationInfoComponent
      case -1147692044:
        /* address */ return this.address == null ? new Base[0] : this.address.toArray(new Base[this.address.size()]); // Address
      case -1429363305:
        /* telecom */ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
      case -1600446614:
        /* contributionType */ return this.contributionType == null ? new Base[0]
            : this.contributionType.toArray(new Base[this.contributionType.size()]); // CodeableConcept
      case 3506294:
        /* role */ return this.role == null ? new Base[0] : new Base[] { this.role }; // CodeableConcept
      case -547910459:
        /* contributionInstance */ return this.contributionInstance == null ? new Base[0]
            : this.contributionInstance.toArray(new Base[this.contributionInstance.size()]); // CitationCitedArtifactContributorshipEntryContributionInstanceComponent
      case -1816008851:
        /* correspondingContact */ return this.correspondingContact == null ? new Base[0]
            : new Base[] { this.correspondingContact }; // BooleanType
      case -1238918832:
        /* listOrder */ return this.listOrder == null ? new Base[0] : new Base[] { this.listOrder }; // PositiveIntType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3373707: // name
        this.name = TypeConvertor.castToHumanName(value); // HumanName
        return value;
      case 269062575: // initials
        this.initials = TypeConvertor.castToString(value); // StringType
        return value;
      case 502871833: // collectiveName
        this.collectiveName = TypeConvertor.castToString(value); // StringType
        return value;
      case -1618432855: // identifier
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
        return value;
      case -215129154: // affiliationInfo
        this.getAffiliationInfo().add((CitationCitedArtifactContributorshipEntryAffiliationInfoComponent) value); // CitationCitedArtifactContributorshipEntryAffiliationInfoComponent
        return value;
      case -1147692044: // address
        this.getAddress().add(TypeConvertor.castToAddress(value)); // Address
        return value;
      case -1429363305: // telecom
        this.getTelecom().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
        return value;
      case -1600446614: // contributionType
        this.getContributionType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
        return value;
      case 3506294: // role
        this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -547910459: // contributionInstance
        this.getContributionInstance()
            .add((CitationCitedArtifactContributorshipEntryContributionInstanceComponent) value); // CitationCitedArtifactContributorshipEntryContributionInstanceComponent
        return value;
      case -1816008851: // correspondingContact
        this.correspondingContact = TypeConvertor.castToBoolean(value); // BooleanType
        return value;
      case -1238918832: // listOrder
        this.listOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("name")) {
        this.name = TypeConvertor.castToHumanName(value); // HumanName
      } else if (name.equals("initials")) {
        this.initials = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("collectiveName")) {
        this.collectiveName = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("identifier")) {
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
      } else if (name.equals("affiliationInfo")) {
        this.getAffiliationInfo().add((CitationCitedArtifactContributorshipEntryAffiliationInfoComponent) value);
      } else if (name.equals("address")) {
        this.getAddress().add(TypeConvertor.castToAddress(value));
      } else if (name.equals("telecom")) {
        this.getTelecom().add(TypeConvertor.castToContactPoint(value));
      } else if (name.equals("contributionType")) {
        this.getContributionType().add(TypeConvertor.castToCodeableConcept(value));
      } else if (name.equals("role")) {
        this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("contributionInstance")) {
        this.getContributionInstance()
            .add((CitationCitedArtifactContributorshipEntryContributionInstanceComponent) value);
      } else if (name.equals("correspondingContact")) {
        this.correspondingContact = TypeConvertor.castToBoolean(value); // BooleanType
      } else if (name.equals("listOrder")) {
        this.listOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3373707:
        return getName();
      case 269062575:
        return getInitialsElement();
      case 502871833:
        return getCollectiveNameElement();
      case -1618432855:
        return addIdentifier();
      case -215129154:
        return addAffiliationInfo();
      case -1147692044:
        return addAddress();
      case -1429363305:
        return addTelecom();
      case -1600446614:
        return addContributionType();
      case 3506294:
        return getRole();
      case -547910459:
        return addContributionInstance();
      case -1816008851:
        return getCorrespondingContactElement();
      case -1238918832:
        return getListOrderElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3373707:
        /* name */ return new String[] { "HumanName" };
      case 269062575:
        /* initials */ return new String[] { "string" };
      case 502871833:
        /* collectiveName */ return new String[] { "string" };
      case -1618432855:
        /* identifier */ return new String[] { "Identifier" };
      case -215129154:
        /* affiliationInfo */ return new String[] {};
      case -1147692044:
        /* address */ return new String[] { "Address" };
      case -1429363305:
        /* telecom */ return new String[] { "ContactPoint" };
      case -1600446614:
        /* contributionType */ return new String[] { "CodeableConcept" };
      case 3506294:
        /* role */ return new String[] { "CodeableConcept" };
      case -547910459:
        /* contributionInstance */ return new String[] {};
      case -1816008851:
        /* correspondingContact */ return new String[] { "boolean" };
      case -1238918832:
        /* listOrder */ return new String[] { "positiveInt" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("name")) {
        this.name = new HumanName();
        return this.name;
      } else if (name.equals("initials")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.initials");
      } else if (name.equals("collectiveName")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.collectiveName");
      } else if (name.equals("identifier")) {
        return addIdentifier();
      } else if (name.equals("affiliationInfo")) {
        return addAffiliationInfo();
      } else if (name.equals("address")) {
        return addAddress();
      } else if (name.equals("telecom")) {
        return addTelecom();
      } else if (name.equals("contributionType")) {
        return addContributionType();
      } else if (name.equals("role")) {
        this.role = new CodeableConcept();
        return this.role;
      } else if (name.equals("contributionInstance")) {
        return addContributionInstance();
      } else if (name.equals("correspondingContact")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.correspondingContact");
      } else if (name.equals("listOrder")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.listOrder");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactContributorshipEntryComponent copy() {
      CitationCitedArtifactContributorshipEntryComponent dst = new CitationCitedArtifactContributorshipEntryComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactContributorshipEntryComponent dst) {
      super.copyValues(dst);
      dst.name = name == null ? null : name.copy();
      dst.initials = initials == null ? null : initials.copy();
      dst.collectiveName = collectiveName == null ? null : collectiveName.copy();
      if (identifier != null) {
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
      }
      ;
      if (affiliationInfo != null) {
        dst.affiliationInfo = new ArrayList<CitationCitedArtifactContributorshipEntryAffiliationInfoComponent>();
        for (CitationCitedArtifactContributorshipEntryAffiliationInfoComponent i : affiliationInfo)
          dst.affiliationInfo.add(i.copy());
      }
      ;
      if (address != null) {
        dst.address = new ArrayList<Address>();
        for (Address i : address)
          dst.address.add(i.copy());
      }
      ;
      if (telecom != null) {
        dst.telecom = new ArrayList<ContactPoint>();
        for (ContactPoint i : telecom)
          dst.telecom.add(i.copy());
      }
      ;
      if (contributionType != null) {
        dst.contributionType = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : contributionType)
          dst.contributionType.add(i.copy());
      }
      ;
      dst.role = role == null ? null : role.copy();
      if (contributionInstance != null) {
        dst.contributionInstance = new ArrayList<CitationCitedArtifactContributorshipEntryContributionInstanceComponent>();
        for (CitationCitedArtifactContributorshipEntryContributionInstanceComponent i : contributionInstance)
          dst.contributionInstance.add(i.copy());
      }
      ;
      dst.correspondingContact = correspondingContact == null ? null : correspondingContact.copy();
      dst.listOrder = listOrder == null ? null : listOrder.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipEntryComponent))
        return false;
      CitationCitedArtifactContributorshipEntryComponent o = (CitationCitedArtifactContributorshipEntryComponent) other_;
      return compareDeep(name, o.name, true) && compareDeep(initials, o.initials, true)
          && compareDeep(collectiveName, o.collectiveName, true) && compareDeep(identifier, o.identifier, true)
          && compareDeep(affiliationInfo, o.affiliationInfo, true) && compareDeep(address, o.address, true)
          && compareDeep(telecom, o.telecom, true) && compareDeep(contributionType, o.contributionType, true)
          && compareDeep(role, o.role, true) && compareDeep(contributionInstance, o.contributionInstance, true)
          && compareDeep(correspondingContact, o.correspondingContact, true)
          && compareDeep(listOrder, o.listOrder, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipEntryComponent))
        return false;
      CitationCitedArtifactContributorshipEntryComponent o = (CitationCitedArtifactContributorshipEntryComponent) other_;
      return compareValues(initials, o.initials, true) && compareValues(collectiveName, o.collectiveName, true)
          && compareValues(correspondingContact, o.correspondingContact, true)
          && compareValues(listOrder, o.listOrder, true);
    }

    public boolean isEmpty() {
      return super.isEmpty()
          && ca.uhn.fhir.util.ElementUtil.isEmpty(name, initials, collectiveName, identifier, affiliationInfo, address,
              telecom, contributionType, role, contributionInstance, correspondingContact, listOrder);
    }

    public String fhirType() {
      return "Citation.citedArtifact.contributorship.entry";

    }

  }

  @Block()
  public static class CitationCitedArtifactContributorshipEntryAffiliationInfoComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Display for the organization.
     */
    @Child(name = "affiliation", type = {
        StringType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Display for the organization", formalDefinition = "Display for the organization.")
    protected StringType affiliation;

    /**
     * Role within the organization, such as professional title.
     */
    @Child(name = "role", type = { StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Role within the organization, such as professional title", formalDefinition = "Role within the organization, such as professional title.")
    protected StringType role;

    /**
     * Identifier for the organization.
     */
    @Child(name = "identifier", type = {
        Identifier.class }, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Identifier for the organization", formalDefinition = "Identifier for the organization.")
    protected List<Identifier> identifier;

    private static final long serialVersionUID = 548335522L;

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent() {
      super();
    }

    /**
     * @return {@link #affiliation} (Display for the organization.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getAffiliation" gives direct access to the value
     */
    public StringType getAffiliationElement() {
      if (this.affiliation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactContributorshipEntryAffiliationInfoComponent.affiliation");
        else if (Configuration.doAutoCreate())
          this.affiliation = new StringType(); // bb
      return this.affiliation;
    }

    public boolean hasAffiliationElement() {
      return this.affiliation != null && !this.affiliation.isEmpty();
    }

    public boolean hasAffiliation() {
      return this.affiliation != null && !this.affiliation.isEmpty();
    }

    /**
     * @param value {@link #affiliation} (Display for the organization.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getAffiliation" gives direct access to the value
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent setAffiliationElement(StringType value) {
      this.affiliation = value;
      return this;
    }

    /**
     * @return Display for the organization.
     */
    public String getAffiliation() {
      return this.affiliation == null ? null : this.affiliation.getValue();
    }

    /**
     * @param value Display for the organization.
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent setAffiliation(String value) {
      if (Utilities.noString(value))
        this.affiliation = null;
      else {
        if (this.affiliation == null)
          this.affiliation = new StringType();
        this.affiliation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #role} (Role within the organization, such as professional
     *         title.). This is the underlying object with id, value and extensions.
     *         The accessor "getRole" gives direct access to the value
     */
    public StringType getRoleElement() {
      if (this.role == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactContributorshipEntryAffiliationInfoComponent.role");
        else if (Configuration.doAutoCreate())
          this.role = new StringType(); // bb
      return this.role;
    }

    public boolean hasRoleElement() {
      return this.role != null && !this.role.isEmpty();
    }

    public boolean hasRole() {
      return this.role != null && !this.role.isEmpty();
    }

    /**
     * @param value {@link #role} (Role within the organization, such as
     *              professional title.). This is the underlying object with id,
     *              value and extensions. The accessor "getRole" gives direct access
     *              to the value
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent setRoleElement(StringType value) {
      this.role = value;
      return this;
    }

    /**
     * @return Role within the organization, such as professional title.
     */
    public String getRole() {
      return this.role == null ? null : this.role.getValue();
    }

    /**
     * @param value Role within the organization, such as professional title.
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent setRole(String value) {
      if (Utilities.noString(value))
        this.role = null;
      else {
        if (this.role == null)
          this.role = new StringType();
        this.role.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (Identifier for the organization.)
     */
    public List<Identifier> getIdentifier() {
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent setIdentifier(
        List<Identifier> theIdentifier) {
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

    public Identifier addIdentifier() { // 3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent addIdentifier(Identifier t) { // 3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating
     *         it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() {
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("affiliation", "string", "Display for the organization.", 0, 1, affiliation));
      children
          .add(new Property("role", "string", "Role within the organization, such as professional title.", 0, 1, role));
      children.add(new Property("identifier", "Identifier", "Identifier for the organization.", 0,
          java.lang.Integer.MAX_VALUE, identifier));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 2019918576:
        /* affiliation */ return new Property("affiliation", "string", "Display for the organization.", 0, 1,
            affiliation);
      case 3506294:
        /* role */ return new Property("role", "string", "Role within the organization, such as professional title.", 0,
            1, role);
      case -1618432855:
        /* identifier */ return new Property("identifier", "Identifier", "Identifier for the organization.", 0,
            java.lang.Integer.MAX_VALUE, identifier);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 2019918576:
        /* affiliation */ return this.affiliation == null ? new Base[0] : new Base[] { this.affiliation }; // StringType
      case 3506294:
        /* role */ return this.role == null ? new Base[0] : new Base[] { this.role }; // StringType
      case -1618432855:
        /* identifier */ return this.identifier == null ? new Base[0]
            : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 2019918576: // affiliation
        this.affiliation = TypeConvertor.castToString(value); // StringType
        return value;
      case 3506294: // role
        this.role = TypeConvertor.castToString(value); // StringType
        return value;
      case -1618432855: // identifier
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("affiliation")) {
        this.affiliation = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("role")) {
        this.role = TypeConvertor.castToString(value); // StringType
      } else if (name.equals("identifier")) {
        this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 2019918576:
        return getAffiliationElement();
      case 3506294:
        return getRoleElement();
      case -1618432855:
        return addIdentifier();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 2019918576:
        /* affiliation */ return new String[] { "string" };
      case 3506294:
        /* role */ return new String[] { "string" };
      case -1618432855:
        /* identifier */ return new String[] { "Identifier" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("affiliation")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.affiliationInfo.affiliation");
      } else if (name.equals("role")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.affiliationInfo.role");
      } else if (name.equals("identifier")) {
        return addIdentifier();
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactContributorshipEntryAffiliationInfoComponent copy() {
      CitationCitedArtifactContributorshipEntryAffiliationInfoComponent dst = new CitationCitedArtifactContributorshipEntryAffiliationInfoComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactContributorshipEntryAffiliationInfoComponent dst) {
      super.copyValues(dst);
      dst.affiliation = affiliation == null ? null : affiliation.copy();
      dst.role = role == null ? null : role.copy();
      if (identifier != null) {
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipEntryAffiliationInfoComponent))
        return false;
      CitationCitedArtifactContributorshipEntryAffiliationInfoComponent o = (CitationCitedArtifactContributorshipEntryAffiliationInfoComponent) other_;
      return compareDeep(affiliation, o.affiliation, true) && compareDeep(role, o.role, true)
          && compareDeep(identifier, o.identifier, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipEntryAffiliationInfoComponent))
        return false;
      CitationCitedArtifactContributorshipEntryAffiliationInfoComponent o = (CitationCitedArtifactContributorshipEntryAffiliationInfoComponent) other_;
      return compareValues(affiliation, o.affiliation, true) && compareValues(role, o.role, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(affiliation, role, identifier);
    }

    public String fhirType() {
      return "Citation.citedArtifact.contributorship.entry.affiliationInfo";

    }

  }

  @Block()
  public static class CitationCitedArtifactContributorshipEntryContributionInstanceComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * The specific contribution.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The specific contribution", formalDefinition = "The specific contribution.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/artifact-contribution-instance-type")
    protected CodeableConcept type;

    /**
     * The time that the contribution was made.
     */
    @Child(name = "time", type = { DateTimeType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The time that the contribution was made", formalDefinition = "The time that the contribution was made.")
    protected DateTimeType time;

    private static final long serialVersionUID = -196837729L;

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent(CodeableConcept type) {
      super();
      this.setType(type);
    }

    /**
     * @return {@link #type} (The specific contribution.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactContributorshipEntryContributionInstanceComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The specific contribution.)
     */
    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #time} (The time that the contribution was made.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getTime" gives direct access to the value
     */
    public DateTimeType getTimeElement() {
      if (this.time == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error(
              "Attempt to auto-create CitationCitedArtifactContributorshipEntryContributionInstanceComponent.time");
        else if (Configuration.doAutoCreate())
          this.time = new DateTimeType(); // bb
      return this.time;
    }

    public boolean hasTimeElement() {
      return this.time != null && !this.time.isEmpty();
    }

    public boolean hasTime() {
      return this.time != null && !this.time.isEmpty();
    }

    /**
     * @param value {@link #time} (The time that the contribution was made.). This
     *              is the underlying object with id, value and extensions. The
     *              accessor "getTime" gives direct access to the value
     */
    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent setTimeElement(DateTimeType value) {
      this.time = value;
      return this;
    }

    /**
     * @return The time that the contribution was made.
     */
    public Date getTime() {
      return this.time == null ? null : this.time.getValue();
    }

    /**
     * @param value The time that the contribution was made.
     */
    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent setTime(Date value) {
      if (value == null)
        this.time = null;
      else {
        if (this.time == null)
          this.time = new DateTimeType();
        this.time.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept", "The specific contribution.", 0, 1, type));
      children.add(new Property("time", "dateTime", "The time that the contribution was made.", 0, 1, time));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept", "The specific contribution.", 0, 1, type);
      case 3560141:
        /* time */ return new Property("time", "dateTime", "The time that the contribution was made.", 0, 1, time);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case 3560141:
        /* time */ return this.time == null ? new Base[0] : new Base[] { this.time }; // DateTimeType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 3560141: // time
        this.time = TypeConvertor.castToDateTime(value); // DateTimeType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("time")) {
        this.time = TypeConvertor.castToDateTime(value); // DateTimeType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case 3560141:
        return getTimeElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case 3560141:
        /* time */ return new String[] { "dateTime" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("time")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.entry.contributionInstance.time");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactContributorshipEntryContributionInstanceComponent copy() {
      CitationCitedArtifactContributorshipEntryContributionInstanceComponent dst = new CitationCitedArtifactContributorshipEntryContributionInstanceComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactContributorshipEntryContributionInstanceComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      dst.time = time == null ? null : time.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipEntryContributionInstanceComponent))
        return false;
      CitationCitedArtifactContributorshipEntryContributionInstanceComponent o = (CitationCitedArtifactContributorshipEntryContributionInstanceComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(time, o.time, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipEntryContributionInstanceComponent))
        return false;
      CitationCitedArtifactContributorshipEntryContributionInstanceComponent o = (CitationCitedArtifactContributorshipEntryContributionInstanceComponent) other_;
      return compareValues(time, o.time, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, time);
    }

    public String fhirType() {
      return "Citation.citedArtifact.contributorship.entry.contributionInstance";

    }

  }

  @Block()
  public static class CitationCitedArtifactContributorshipSummaryComponent extends BackboneElement
      implements IBaseBackboneElement {
    /**
     * Used most commonly to express an author list or a contributorship statement.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Either authorList or contributorshipStatement", formalDefinition = "Used most commonly to express an author list or a contributorship statement.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/contributor-summary-type")
    protected CodeableConcept type;

    /**
     * The format for the display string.
     */
    @Child(name = "style", type = {
        CodeableConcept.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The format for the display string", formalDefinition = "The format for the display string.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/contributor-summary-style")
    protected CodeableConcept style;

    /**
     * Used to code the producer or rule for creating the display string.
     */
    @Child(name = "source", type = {
        CodeableConcept.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Used to code the producer or rule for creating the display string", formalDefinition = "Used to code the producer or rule for creating the display string.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/contributor-summary-source")
    protected CodeableConcept source;

    /**
     * The display string for the author list, contributor list, or contributorship
     * statement.
     */
    @Child(name = "value", type = {
        MarkdownType.class }, order = 4, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "The display string for the author list, contributor list, or contributorship statement", formalDefinition = "The display string for the author list, contributor list, or contributorship statement.")
    protected MarkdownType value;

    private static final long serialVersionUID = 1353383781L;

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipSummaryComponent() {
      super();
    }

    /**
     * Constructor
     */
    public CitationCitedArtifactContributorshipSummaryComponent(String value) {
      super();
      this.setValue(value);
    }

    /**
     * @return {@link #type} (Used most commonly to express an author list or a
     *         contributorship statement.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipSummaryComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Used most commonly to express an author list or a
     *              contributorship statement.)
     */
    public CitationCitedArtifactContributorshipSummaryComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #style} (The format for the display string.)
     */
    public CodeableConcept getStyle() {
      if (this.style == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipSummaryComponent.style");
        else if (Configuration.doAutoCreate())
          this.style = new CodeableConcept(); // cc
      return this.style;
    }

    public boolean hasStyle() {
      return this.style != null && !this.style.isEmpty();
    }

    /**
     * @param value {@link #style} (The format for the display string.)
     */
    public CitationCitedArtifactContributorshipSummaryComponent setStyle(CodeableConcept value) {
      this.style = value;
      return this;
    }

    /**
     * @return {@link #source} (Used to code the producer or rule for creating the
     *         display string.)
     */
    public CodeableConcept getSource() {
      if (this.source == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipSummaryComponent.source");
        else if (Configuration.doAutoCreate())
          this.source = new CodeableConcept(); // cc
      return this.source;
    }

    public boolean hasSource() {
      return this.source != null && !this.source.isEmpty();
    }

    /**
     * @param value {@link #source} (Used to code the producer or rule for creating
     *              the display string.)
     */
    public CitationCitedArtifactContributorshipSummaryComponent setSource(CodeableConcept value) {
      this.source = value;
      return this;
    }

    /**
     * @return {@link #value} (The display string for the author list, contributor
     *         list, or contributorship statement.). This is the underlying object
     *         with id, value and extensions. The accessor "getValue" gives direct
     *         access to the value
     */
    public MarkdownType getValueElement() {
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CitationCitedArtifactContributorshipSummaryComponent.value");
        else if (Configuration.doAutoCreate())
          this.value = new MarkdownType(); // bb
      return this.value;
    }

    public boolean hasValueElement() {
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() {
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (The display string for the author list,
     *              contributor list, or contributorship statement.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getValue" gives direct access to the value
     */
    public CitationCitedArtifactContributorshipSummaryComponent setValueElement(MarkdownType value) {
      this.value = value;
      return this;
    }

    /**
     * @return The display string for the author list, contributor list, or
     *         contributorship statement.
     */
    public String getValue() {
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value The display string for the author list, contributor list, or
     *              contributorship statement.
     */
    public CitationCitedArtifactContributorshipSummaryComponent setValue(String value) {
      if (this.value == null)
        this.value = new MarkdownType();
      this.value.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "CodeableConcept",
          "Used most commonly to express an author list or a contributorship statement.", 0, 1, type));
      children.add(new Property("style", "CodeableConcept", "The format for the display string.", 0, 1, style));
      children.add(new Property("source", "CodeableConcept",
          "Used to code the producer or rule for creating the display string.", 0, 1, source));
      children.add(new Property("value", "markdown",
          "The display string for the author list, contributor list, or contributorship statement.", 0, 1, value));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "Used most commonly to express an author list or a contributorship statement.", 0, 1, type);
      case 109780401:
        /* style */ return new Property("style", "CodeableConcept", "The format for the display string.", 0, 1, style);
      case -896505829:
        /* source */ return new Property("source", "CodeableConcept",
            "Used to code the producer or rule for creating the display string.", 0, 1, source);
      case 111972721:
        /* value */ return new Property("value", "markdown",
            "The display string for the author list, contributor list, or contributorship statement.", 0, 1, value);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case 109780401:
        /* style */ return this.style == null ? new Base[0] : new Base[] { this.style }; // CodeableConcept
      case -896505829:
        /* source */ return this.source == null ? new Base[0] : new Base[] { this.source }; // CodeableConcept
      case 111972721:
        /* value */ return this.value == null ? new Base[0] : new Base[] { this.value }; // MarkdownType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 109780401: // style
        this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case -896505829: // source
        this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        return value;
      case 111972721: // value
        this.value = TypeConvertor.castToMarkdown(value); // MarkdownType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("style")) {
        this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("source")) {
        this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("value")) {
        this.value = TypeConvertor.castToMarkdown(value); // MarkdownType
      } else
        return super.setProperty(name, value);
      return value;
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getType();
      case 109780401:
        return getStyle();
      case -896505829:
        return getSource();
      case 111972721:
        return getValueElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case 109780401:
        /* style */ return new String[] { "CodeableConcept" };
      case -896505829:
        /* source */ return new String[] { "CodeableConcept" };
      case 111972721:
        /* value */ return new String[] { "markdown" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("style")) {
        this.style = new CodeableConcept();
        return this.style;
      } else if (name.equals("source")) {
        this.source = new CodeableConcept();
        return this.source;
      } else if (name.equals("value")) {
        throw new FHIRException(
            "Cannot call addChild on a primitive type Citation.citedArtifact.contributorship.summary.value");
      } else
        return super.addChild(name);
    }

    public CitationCitedArtifactContributorshipSummaryComponent copy() {
      CitationCitedArtifactContributorshipSummaryComponent dst = new CitationCitedArtifactContributorshipSummaryComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(CitationCitedArtifactContributorshipSummaryComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      dst.style = style == null ? null : style.copy();
      dst.source = source == null ? null : source.copy();
      dst.value = value == null ? null : value.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipSummaryComponent))
        return false;
      CitationCitedArtifactContributorshipSummaryComponent o = (CitationCitedArtifactContributorshipSummaryComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(style, o.style, true) && compareDeep(source, o.source, true)
          && compareDeep(value, o.value, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof CitationCitedArtifactContributorshipSummaryComponent))
        return false;
      CitationCitedArtifactContributorshipSummaryComponent o = (CitationCitedArtifactContributorshipSummaryComponent) other_;
      return compareValues(value, o.value, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, style, source, value);
    }

    public String fhirType() {
      return "Citation.citedArtifact.contributorship.summary";

    }

  }

  /**
   * An absolute URI that is used to identify this citation when it is referenced
   * in a specification, model, design or an instance; also called its canonical
   * identifier. This SHOULD be globally unique and SHOULD be a literal address at
   * which at which an authoritative instance of this summary is (or will be)
   * published. This URL can be the target of a canonical reference. It SHALL
   * remain the same when the summary is stored on different servers.
   */
  @Child(name = "url", type = { UriType.class }, order = 0, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Canonical identifier for this citation, represented as a globally unique URI", formalDefinition = "An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.")
  protected UriType url;

  /**
   * A formal identifier that is used to identify this citation when it is
   * represented in other formats, or referenced in a specification, model, design
   * or an instance.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Identifier for the Citation resource itself", formalDefinition = "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.")
  protected List<Identifier> identifier;

  /**
   * The identifier that is used to identify this version of the citation when it
   * is referenced in a specification, model, design or instance. This is an
   * arbitrary value managed by the citation author and is not expected to be
   * globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a
   * managed version is not available. There is also no expectation that versions
   * can be placed in a lexicographical sequence.
   */
  @Child(name = "version", type = { StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Business version of the citation", formalDefinition = "The identifier that is used to identify this version of the citation when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.")
  protected StringType version;

  /**
   * A natural language name identifying the citation. This name should be usable
   * as an identifier for the module by machine processing applications such as
   * code generation.
   */
  @Child(name = "name", type = { StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Name for this citation (computer friendly)", formalDefinition = "A natural language name identifying the citation. This name should be usable as an identifier for the module by machine processing applications such as code generation.")
  protected StringType name;

  /**
   * A short, descriptive, user-friendly title for the citation.
   */
  @Child(name = "title", type = { StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Name for this citation (human friendly)", formalDefinition = "A short, descriptive, user-friendly title for the citation.")
  protected StringType title;

  /**
   * The status of this summary. Enables tracking the life-cycle of the content.
   */
  @Child(name = "status", type = { CodeType.class }, order = 5, min = 1, max = 1, modifier = true, summary = true)
  @Description(shortDefinition = "draft | active | retired | unknown", formalDefinition = "The status of this summary. Enables tracking the life-cycle of the content.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/publication-status")
  protected Enumeration<PublicationStatus> status;

  /**
   * A Boolean value to indicate that this citation is authored for testing
   * purposes (or education/evaluation/marketing) and is not intended to be used
   * for genuine usage.
   */
  @Child(name = "experimental", type = {
      BooleanType.class }, order = 6, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "For testing purposes, not real usage", formalDefinition = "A Boolean value to indicate that this citation is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.")
  protected BooleanType experimental;

  /**
   * The date (and optionally time) when the citation was published. The date must
   * change when the business version changes and it must change if the status
   * code changes. In addition, it should change when the substantive content of
   * the citation changes.
   */
  @Child(name = "date", type = { DateTimeType.class }, order = 7, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Date last changed", formalDefinition = "The date  (and optionally time) when the citation was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation changes.")
  protected DateTimeType date;

  /**
   * The name of the organization or individual that published the citation.
   */
  @Child(name = "publisher", type = { StringType.class }, order = 8, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The publisher of the Citation, not the publisher of the article or artifact being cited", formalDefinition = "The name of the organization or individual that published the citation.")
  protected StringType publisher;

  /**
   * Contact details to assist a user in finding and communicating with the
   * publisher.
   */
  @Child(name = "contact", type = {
      ContactDetail.class }, order = 9, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Contact details for the publisher of the Citation Resource", formalDefinition = "Contact details to assist a user in finding and communicating with the publisher.")
  protected List<ContactDetail> contact;

  /**
   * A free text natural language description of the citation from a consumer's
   * perspective.
   */
  @Child(name = "description", type = {
      MarkdownType.class }, order = 10, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Natural language description of the citation", formalDefinition = "A free text natural language description of the citation from a consumer's perspective.")
  protected MarkdownType description;

  /**
   * The content was developed with a focus and intent of supporting the contexts
   * that are listed. These contexts may be general categories (gender, age, ...)
   * or may be references to specific programs (insurance plans, studies, ...) and
   * may be used to assist with indexing and searching for appropriate citation
   * instances.
   */
  @Child(name = "useContext", type = {
      UsageContext.class }, order = 11, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "The context that the Citation Resource content is intended to support", formalDefinition = "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.")
  protected List<UsageContext> useContext;

  /**
   * A legal or geographic region in which the citation is intended to be used.
   */
  @Child(name = "jurisdiction", type = {
      CodeableConcept.class }, order = 12, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Intended jurisdiction for citation (if applicable)", formalDefinition = "A legal or geographic region in which the citation is intended to be used.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/jurisdiction")
  protected List<CodeableConcept> jurisdiction;

  /**
   * Explanation of why this citation is needed and why it has been designed as it
   * has.
   */
  @Child(name = "purpose", type = {
      MarkdownType.class }, order = 13, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Why this citation is defined", formalDefinition = "Explanation of why this citation is needed and why it has been designed as it has.")
  protected MarkdownType purpose;

  /**
   * Use and/or publishing restrictions for the Citation, not for the cited
   * artifact.
   */
  @Child(name = "copyright", type = {
      MarkdownType.class }, order = 14, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Use and/or publishing restrictions for the Citation, not for the cited artifact", formalDefinition = "Use and/or publishing restrictions for the Citation, not for the cited artifact.")
  protected MarkdownType copyright;

  /**
   * The date on which the resource content was approved by the publisher.
   * Approval happens once when the content is officially approved for usage.
   */
  @Child(name = "approvalDate", type = {
      DateType.class }, order = 15, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "When the citation was approved by publisher", formalDefinition = "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.")
  protected DateType approvalDate;

  /**
   * The date on which the resource content was last reviewed. Review happens
   * periodically after approval but does not change the original approval date.
   */
  @Child(name = "lastReviewDate", type = {
      DateType.class }, order = 16, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "When the citation was last reviewed", formalDefinition = "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.")
  protected DateType lastReviewDate;

  /**
   * The period during which the citation content was or is planned to be in
   * active use.
   */
  @Child(name = "effectivePeriod", type = {
      Period.class }, order = 17, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "When the citation is expected to be used", formalDefinition = "The period during which the citation content was or is planned to be in active use.")
  protected Period effectivePeriod;

  /**
   * Who authored the Citation.
   */
  @Child(name = "author", type = {
      ContactDetail.class }, order = 18, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who authored the Citation", formalDefinition = "Who authored the Citation.")
  protected List<ContactDetail> author;

  /**
   * Who edited the Citation.
   */
  @Child(name = "editor", type = {
      ContactDetail.class }, order = 19, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who edited the Citation", formalDefinition = "Who edited the Citation.")
  protected List<ContactDetail> editor;

  /**
   * Who reviewed the Citation.
   */
  @Child(name = "reviewer", type = {
      ContactDetail.class }, order = 20, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who reviewed the Citation", formalDefinition = "Who reviewed the Citation.")
  protected List<ContactDetail> reviewer;

  /**
   * Who endorsed the Citation.
   */
  @Child(name = "endorser", type = {
      ContactDetail.class }, order = 21, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who endorsed the Citation", formalDefinition = "Who endorsed the Citation.")
  protected List<ContactDetail> endorser;

  /**
   * A human-readable display of the citation.
   */
  @Child(name = "summary", type = {
      ContactDetail.class }, order = 22, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "A human-readable display of the citation", formalDefinition = "A human-readable display of the citation.")
  protected List<ContactDetail> summary;

  /**
   * The assignment to an organizing scheme.
   */
  @Child(name = "classification", type = {}, order = 23, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "The assignment to an organizing scheme", formalDefinition = "The assignment to an organizing scheme.")
  protected List<CitationClassificationComponent> classification;

  /**
   * Used for general notes and annotations not coded elsewhere.
   */
  @Child(name = "note", type = {
      Annotation.class }, order = 24, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Used for general notes and annotations not coded elsewhere", formalDefinition = "Used for general notes and annotations not coded elsewhere.")
  protected List<Annotation> note;

  /**
   * The status of the citation.
   */
  @Child(name = "currentState", type = {
      CodeableConcept.class }, order = 25, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "The status of the citation", formalDefinition = "The status of the citation.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/citation-status-type")
  protected List<CodeableConcept> currentState;

  /**
   * An effective date or period for a status of the citation.
   */
  @Child(name = "statusDate", type = {}, order = 26, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "An effective date or period for a status of the citation", formalDefinition = "An effective date or period for a status of the citation.")
  protected List<CitationStatusDateComponent> statusDate;

  /**
   * Artifact related to the Citation Resource.
   */
  @Child(name = "relatesTo", type = {}, order = 27, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Artifact related to the Citation Resource", formalDefinition = "Artifact related to the Citation Resource.")
  protected List<CitationRelatesToComponent> relatesTo;

  /**
   * The article or artifact being described.
   */
  @Child(name = "citedArtifact", type = {}, order = 28, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "The article or artifact being described", formalDefinition = "The article or artifact being described.")
  protected CitationCitedArtifactComponent citedArtifact;

  private static final long serialVersionUID = 2083863417L;

  /**
   * Constructor
   */
  public Citation() {
    super();
  }

  /**
   * Constructor
   */
  public Citation(PublicationStatus status) {
    super();
    this.setStatus(status);
  }

  /**
   * @return {@link #url} (An absolute URI that is used to identify this citation
   *         when it is referenced in a specification, model, design or an
   *         instance; also called its canonical identifier. This SHOULD be
   *         globally unique and SHOULD be a literal address at which at which an
   *         authoritative instance of this summary is (or will be) published.
   *         This URL can be the target of a canonical reference. It SHALL remain
   *         the same when the summary is stored on different servers.). This is
   *         the underlying object with id, value and extensions. The accessor
   *         "getUrl" gives direct access to the value
   */
  public UriType getUrlElement() {
    if (this.url == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.url");
      else if (Configuration.doAutoCreate())
        this.url = new UriType(); // bb
    return this.url;
  }

  public boolean hasUrlElement() {
    return this.url != null && !this.url.isEmpty();
  }

  public boolean hasUrl() {
    return this.url != null && !this.url.isEmpty();
  }

  /**
   * @param value {@link #url} (An absolute URI that is used to identify this
   *              citation when it is referenced in a specification, model, design
   *              or an instance; also called its canonical identifier. This
   *              SHOULD be globally unique and SHOULD be a literal address at
   *              which at which an authoritative instance of this summary is (or
   *              will be) published. This URL can be the target of a canonical
   *              reference. It SHALL remain the same when the summary is stored
   *              on different servers.). This is the underlying object with id,
   *              value and extensions. The accessor "getUrl" gives direct access
   *              to the value
   */
  public Citation setUrlElement(UriType value) {
    this.url = value;
    return this;
  }

  /**
   * @return An absolute URI that is used to identify this citation when it is
   *         referenced in a specification, model, design or an instance; also
   *         called its canonical identifier. This SHOULD be globally unique and
   *         SHOULD be a literal address at which at which an authoritative
   *         instance of this summary is (or will be) published. This URL can be
   *         the target of a canonical reference. It SHALL remain the same when
   *         the summary is stored on different servers.
   */
  public String getUrl() {
    return this.url == null ? null : this.url.getValue();
  }

  /**
   * @param value An absolute URI that is used to identify this citation when it
   *              is referenced in a specification, model, design or an instance;
   *              also called its canonical identifier. This SHOULD be globally
   *              unique and SHOULD be a literal address at which at which an
   *              authoritative instance of this summary is (or will be)
   *              published. This URL can be the target of a canonical reference.
   *              It SHALL remain the same when the summary is stored on different
   *              servers.
   */
  public Citation setUrl(String value) {
    if (Utilities.noString(value))
      this.url = null;
    else {
      if (this.url == null)
        this.url = new UriType();
      this.url.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #identifier} (A formal identifier that is used to identify
   *         this citation when it is represented in other formats, or referenced
   *         in a specification, model, design or an instance.)
   */
  public List<Identifier> getIdentifier() {
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    return this.identifier;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setIdentifier(List<Identifier> theIdentifier) {
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

  public Identifier addIdentifier() { // 3
    Identifier t = new Identifier();
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return t;
  }

  public Citation addIdentifier(Identifier t) { // 3
    if (t == null)
      return this;
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #identifier}, creating
   *         it if it does not already exist {3}
   */
  public Identifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return getIdentifier().get(0);
  }

  /**
   * @return {@link #version} (The identifier that is used to identify this
   *         version of the citation when it is referenced in a specification,
   *         model, design or instance. This is an arbitrary value managed by the
   *         citation author and is not expected to be globally unique. For
   *         example, it might be a timestamp (e.g. yyyymmdd) if a managed version
   *         is not available. There is also no expectation that versions can be
   *         placed in a lexicographical sequence.). This is the underlying object
   *         with id, value and extensions. The accessor "getVersion" gives direct
   *         access to the value
   */
  public StringType getVersionElement() {
    if (this.version == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.version");
      else if (Configuration.doAutoCreate())
        this.version = new StringType(); // bb
    return this.version;
  }

  public boolean hasVersionElement() {
    return this.version != null && !this.version.isEmpty();
  }

  public boolean hasVersion() {
    return this.version != null && !this.version.isEmpty();
  }

  /**
   * @param value {@link #version} (The identifier that is used to identify this
   *              version of the citation when it is referenced in a
   *              specification, model, design or instance. This is an arbitrary
   *              value managed by the citation author and is not expected to be
   *              globally unique. For example, it might be a timestamp (e.g.
   *              yyyymmdd) if a managed version is not available. There is also
   *              no expectation that versions can be placed in a lexicographical
   *              sequence.). This is the underlying object with id, value and
   *              extensions. The accessor "getVersion" gives direct access to the
   *              value
   */
  public Citation setVersionElement(StringType value) {
    this.version = value;
    return this;
  }

  /**
   * @return The identifier that is used to identify this version of the citation
   *         when it is referenced in a specification, model, design or instance.
   *         This is an arbitrary value managed by the citation author and is not
   *         expected to be globally unique. For example, it might be a timestamp
   *         (e.g. yyyymmdd) if a managed version is not available. There is also
   *         no expectation that versions can be placed in a lexicographical
   *         sequence.
   */
  public String getVersion() {
    return this.version == null ? null : this.version.getValue();
  }

  /**
   * @param value The identifier that is used to identify this version of the
   *              citation when it is referenced in a specification, model, design
   *              or instance. This is an arbitrary value managed by the citation
   *              author and is not expected to be globally unique. For example,
   *              it might be a timestamp (e.g. yyyymmdd) if a managed version is
   *              not available. There is also no expectation that versions can be
   *              placed in a lexicographical sequence.
   */
  public Citation setVersion(String value) {
    if (Utilities.noString(value))
      this.version = null;
    else {
      if (this.version == null)
        this.version = new StringType();
      this.version.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #name} (A natural language name identifying the citation. This
   *         name should be usable as an identifier for the module by machine
   *         processing applications such as code generation.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getName" gives direct access to the value
   */
  public StringType getNameElement() {
    if (this.name == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.name");
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
   * @param value {@link #name} (A natural language name identifying the citation.
   *              This name should be usable as an identifier for the module by
   *              machine processing applications such as code generation.). This
   *              is the underlying object with id, value and extensions. The
   *              accessor "getName" gives direct access to the value
   */
  public Citation setNameElement(StringType value) {
    this.name = value;
    return this;
  }

  /**
   * @return A natural language name identifying the citation. This name should be
   *         usable as an identifier for the module by machine processing
   *         applications such as code generation.
   */
  public String getName() {
    return this.name == null ? null : this.name.getValue();
  }

  /**
   * @param value A natural language name identifying the citation. This name
   *              should be usable as an identifier for the module by machine
   *              processing applications such as code generation.
   */
  public Citation setName(String value) {
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
   * @return {@link #title} (A short, descriptive, user-friendly title for the
   *         citation.). This is the underlying object with id, value and
   *         extensions. The accessor "getTitle" gives direct access to the value
   */
  public StringType getTitleElement() {
    if (this.title == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.title");
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
   * @param value {@link #title} (A short, descriptive, user-friendly title for
   *              the citation.). This is the underlying object with id, value and
   *              extensions. The accessor "getTitle" gives direct access to the
   *              value
   */
  public Citation setTitleElement(StringType value) {
    this.title = value;
    return this;
  }

  /**
   * @return A short, descriptive, user-friendly title for the citation.
   */
  public String getTitle() {
    return this.title == null ? null : this.title.getValue();
  }

  /**
   * @param value A short, descriptive, user-friendly title for the citation.
   */
  public Citation setTitle(String value) {
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
   * @return {@link #status} (The status of this summary. Enables tracking the
   *         life-cycle of the content.). This is the underlying object with id,
   *         value and extensions. The accessor "getStatus" gives direct access to
   *         the value
   */
  public Enumeration<PublicationStatus> getStatusElement() {
    if (this.status == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.status");
      else if (Configuration.doAutoCreate())
        this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
    return this.status;
  }

  public boolean hasStatusElement() {
    return this.status != null && !this.status.isEmpty();
  }

  public boolean hasStatus() {
    return this.status != null && !this.status.isEmpty();
  }

  /**
   * @param value {@link #status} (The status of this summary. Enables tracking
   *              the life-cycle of the content.). This is the underlying object
   *              with id, value and extensions. The accessor "getStatus" gives
   *              direct access to the value
   */
  public Citation setStatusElement(Enumeration<PublicationStatus> value) {
    this.status = value;
    return this;
  }

  /**
   * @return The status of this summary. Enables tracking the life-cycle of the
   *         content.
   */
  public PublicationStatus getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  /**
   * @param value The status of this summary. Enables tracking the life-cycle of
   *              the content.
   */
  public Citation setStatus(PublicationStatus value) {
    if (this.status == null)
      this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
    this.status.setValue(value);
    return this;
  }

  /**
   * @return {@link #experimental} (A Boolean value to indicate that this citation
   *         is authored for testing purposes (or education/evaluation/marketing)
   *         and is not intended to be used for genuine usage.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getExperimental" gives direct access to the value
   */
  public BooleanType getExperimentalElement() {
    if (this.experimental == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.experimental");
      else if (Configuration.doAutoCreate())
        this.experimental = new BooleanType(); // bb
    return this.experimental;
  }

  public boolean hasExperimentalElement() {
    return this.experimental != null && !this.experimental.isEmpty();
  }

  public boolean hasExperimental() {
    return this.experimental != null && !this.experimental.isEmpty();
  }

  /**
   * @param value {@link #experimental} (A Boolean value to indicate that this
   *              citation is authored for testing purposes (or
   *              education/evaluation/marketing) and is not intended to be used
   *              for genuine usage.). This is the underlying object with id,
   *              value and extensions. The accessor "getExperimental" gives
   *              direct access to the value
   */
  public Citation setExperimentalElement(BooleanType value) {
    this.experimental = value;
    return this;
  }

  /**
   * @return A Boolean value to indicate that this citation is authored for
   *         testing purposes (or education/evaluation/marketing) and is not
   *         intended to be used for genuine usage.
   */
  public boolean getExperimental() {
    return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
  }

  /**
   * @param value A Boolean value to indicate that this citation is authored for
   *              testing purposes (or education/evaluation/marketing) and is not
   *              intended to be used for genuine usage.
   */
  public Citation setExperimental(boolean value) {
    if (this.experimental == null)
      this.experimental = new BooleanType();
    this.experimental.setValue(value);
    return this;
  }

  /**
   * @return {@link #date} (The date (and optionally time) when the citation was
   *         published. The date must change when the business version changes and
   *         it must change if the status code changes. In addition, it should
   *         change when the substantive content of the citation changes.). This
   *         is the underlying object with id, value and extensions. The accessor
   *         "getDate" gives direct access to the value
   */
  public DateTimeType getDateElement() {
    if (this.date == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.date");
      else if (Configuration.doAutoCreate())
        this.date = new DateTimeType(); // bb
    return this.date;
  }

  public boolean hasDateElement() {
    return this.date != null && !this.date.isEmpty();
  }

  public boolean hasDate() {
    return this.date != null && !this.date.isEmpty();
  }

  /**
   * @param value {@link #date} (The date (and optionally time) when the citation
   *              was published. The date must change when the business version
   *              changes and it must change if the status code changes. In
   *              addition, it should change when the substantive content of the
   *              citation changes.). This is the underlying object with id, value
   *              and extensions. The accessor "getDate" gives direct access to
   *              the value
   */
  public Citation setDateElement(DateTimeType value) {
    this.date = value;
    return this;
  }

  /**
   * @return The date (and optionally time) when the citation was published. The
   *         date must change when the business version changes and it must change
   *         if the status code changes. In addition, it should change when the
   *         substantive content of the citation changes.
   */
  public Date getDate() {
    return this.date == null ? null : this.date.getValue();
  }

  /**
   * @param value The date (and optionally time) when the citation was published.
   *              The date must change when the business version changes and it
   *              must change if the status code changes. In addition, it should
   *              change when the substantive content of the citation changes.
   */
  public Citation setDate(Date value) {
    if (value == null)
      this.date = null;
    else {
      if (this.date == null)
        this.date = new DateTimeType();
      this.date.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #publisher} (The name of the organization or individual that
   *         published the citation.). This is the underlying object with id,
   *         value and extensions. The accessor "getPublisher" gives direct access
   *         to the value
   */
  public StringType getPublisherElement() {
    if (this.publisher == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.publisher");
      else if (Configuration.doAutoCreate())
        this.publisher = new StringType(); // bb
    return this.publisher;
  }

  public boolean hasPublisherElement() {
    return this.publisher != null && !this.publisher.isEmpty();
  }

  public boolean hasPublisher() {
    return this.publisher != null && !this.publisher.isEmpty();
  }

  /**
   * @param value {@link #publisher} (The name of the organization or individual
   *              that published the citation.). This is the underlying object
   *              with id, value and extensions. The accessor "getPublisher" gives
   *              direct access to the value
   */
  public Citation setPublisherElement(StringType value) {
    this.publisher = value;
    return this;
  }

  /**
   * @return The name of the organization or individual that published the
   *         citation.
   */
  public String getPublisher() {
    return this.publisher == null ? null : this.publisher.getValue();
  }

  /**
   * @param value The name of the organization or individual that published the
   *              citation.
   */
  public Citation setPublisher(String value) {
    if (Utilities.noString(value))
      this.publisher = null;
    else {
      if (this.publisher == null)
        this.publisher = new StringType();
      this.publisher.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #contact} (Contact details to assist a user in finding and
   *         communicating with the publisher.)
   */
  public List<ContactDetail> getContact() {
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    return this.contact;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setContact(List<ContactDetail> theContact) {
    this.contact = theContact;
    return this;
  }

  public boolean hasContact() {
    if (this.contact == null)
      return false;
    for (ContactDetail item : this.contact)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addContact() { // 3
    ContactDetail t = new ContactDetail();
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return t;
  }

  public Citation addContact(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #contact}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getContactFirstRep() {
    if (getContact().isEmpty()) {
      addContact();
    }
    return getContact().get(0);
  }

  /**
   * @return {@link #description} (A free text natural language description of the
   *         citation from a consumer's perspective.). This is the underlying
   *         object with id, value and extensions. The accessor "getDescription"
   *         gives direct access to the value
   */
  public MarkdownType getDescriptionElement() {
    if (this.description == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.description");
      else if (Configuration.doAutoCreate())
        this.description = new MarkdownType(); // bb
    return this.description;
  }

  public boolean hasDescriptionElement() {
    return this.description != null && !this.description.isEmpty();
  }

  public boolean hasDescription() {
    return this.description != null && !this.description.isEmpty();
  }

  /**
   * @param value {@link #description} (A free text natural language description
   *              of the citation from a consumer's perspective.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getDescription" gives direct access to the value
   */
  public Citation setDescriptionElement(MarkdownType value) {
    this.description = value;
    return this;
  }

  /**
   * @return A free text natural language description of the citation from a
   *         consumer's perspective.
   */
  public String getDescription() {
    return this.description == null ? null : this.description.getValue();
  }

  /**
   * @param value A free text natural language description of the citation from a
   *              consumer's perspective.
   */
  public Citation setDescription(String value) {
    if (value == null)
      this.description = null;
    else {
      if (this.description == null)
        this.description = new MarkdownType();
      this.description.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #useContext} (The content was developed with a focus and
   *         intent of supporting the contexts that are listed. These contexts may
   *         be general categories (gender, age, ...) or may be references to
   *         specific programs (insurance plans, studies, ...) and may be used to
   *         assist with indexing and searching for appropriate citation
   *         instances.)
   */
  public List<UsageContext> getUseContext() {
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    return this.useContext;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setUseContext(List<UsageContext> theUseContext) {
    this.useContext = theUseContext;
    return this;
  }

  public boolean hasUseContext() {
    if (this.useContext == null)
      return false;
    for (UsageContext item : this.useContext)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public UsageContext addUseContext() { // 3
    UsageContext t = new UsageContext();
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return t;
  }

  public Citation addUseContext(UsageContext t) { // 3
    if (t == null)
      return this;
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #useContext}, creating
   *         it if it does not already exist {3}
   */
  public UsageContext getUseContextFirstRep() {
    if (getUseContext().isEmpty()) {
      addUseContext();
    }
    return getUseContext().get(0);
  }

  /**
   * @return {@link #jurisdiction} (A legal or geographic region in which the
   *         citation is intended to be used.)
   */
  public List<CodeableConcept> getJurisdiction() {
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    return this.jurisdiction;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setJurisdiction(List<CodeableConcept> theJurisdiction) {
    this.jurisdiction = theJurisdiction;
    return this;
  }

  public boolean hasJurisdiction() {
    if (this.jurisdiction == null)
      return false;
    for (CodeableConcept item : this.jurisdiction)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addJurisdiction() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return t;
  }

  public Citation addJurisdiction(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #jurisdiction},
   *         creating it if it does not already exist {3}
   */
  public CodeableConcept getJurisdictionFirstRep() {
    if (getJurisdiction().isEmpty()) {
      addJurisdiction();
    }
    return getJurisdiction().get(0);
  }

  /**
   * @return {@link #purpose} (Explanation of why this citation is needed and why
   *         it has been designed as it has.). This is the underlying object with
   *         id, value and extensions. The accessor "getPurpose" gives direct
   *         access to the value
   */
  public MarkdownType getPurposeElement() {
    if (this.purpose == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.purpose");
      else if (Configuration.doAutoCreate())
        this.purpose = new MarkdownType(); // bb
    return this.purpose;
  }

  public boolean hasPurposeElement() {
    return this.purpose != null && !this.purpose.isEmpty();
  }

  public boolean hasPurpose() {
    return this.purpose != null && !this.purpose.isEmpty();
  }

  /**
   * @param value {@link #purpose} (Explanation of why this citation is needed and
   *              why it has been designed as it has.). This is the underlying
   *              object with id, value and extensions. The accessor "getPurpose"
   *              gives direct access to the value
   */
  public Citation setPurposeElement(MarkdownType value) {
    this.purpose = value;
    return this;
  }

  /**
   * @return Explanation of why this citation is needed and why it has been
   *         designed as it has.
   */
  public String getPurpose() {
    return this.purpose == null ? null : this.purpose.getValue();
  }

  /**
   * @param value Explanation of why this citation is needed and why it has been
   *              designed as it has.
   */
  public Citation setPurpose(String value) {
    if (value == null)
      this.purpose = null;
    else {
      if (this.purpose == null)
        this.purpose = new MarkdownType();
      this.purpose.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #copyright} (Use and/or publishing restrictions for the
   *         Citation, not for the cited artifact.). This is the underlying object
   *         with id, value and extensions. The accessor "getCopyright" gives
   *         direct access to the value
   */
  public MarkdownType getCopyrightElement() {
    if (this.copyright == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.copyright");
      else if (Configuration.doAutoCreate())
        this.copyright = new MarkdownType(); // bb
    return this.copyright;
  }

  public boolean hasCopyrightElement() {
    return this.copyright != null && !this.copyright.isEmpty();
  }

  public boolean hasCopyright() {
    return this.copyright != null && !this.copyright.isEmpty();
  }

  /**
   * @param value {@link #copyright} (Use and/or publishing restrictions for the
   *              Citation, not for the cited artifact.). This is the underlying
   *              object with id, value and extensions. The accessor
   *              "getCopyright" gives direct access to the value
   */
  public Citation setCopyrightElement(MarkdownType value) {
    this.copyright = value;
    return this;
  }

  /**
   * @return Use and/or publishing restrictions for the Citation, not for the
   *         cited artifact.
   */
  public String getCopyright() {
    return this.copyright == null ? null : this.copyright.getValue();
  }

  /**
   * @param value Use and/or publishing restrictions for the Citation, not for the
   *              cited artifact.
   */
  public Citation setCopyright(String value) {
    if (value == null)
      this.copyright = null;
    else {
      if (this.copyright == null)
        this.copyright = new MarkdownType();
      this.copyright.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #approvalDate} (The date on which the resource content was
   *         approved by the publisher. Approval happens once when the content is
   *         officially approved for usage.). This is the underlying object with
   *         id, value and extensions. The accessor "getApprovalDate" gives direct
   *         access to the value
   */
  public DateType getApprovalDateElement() {
    if (this.approvalDate == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.approvalDate");
      else if (Configuration.doAutoCreate())
        this.approvalDate = new DateType(); // bb
    return this.approvalDate;
  }

  public boolean hasApprovalDateElement() {
    return this.approvalDate != null && !this.approvalDate.isEmpty();
  }

  public boolean hasApprovalDate() {
    return this.approvalDate != null && !this.approvalDate.isEmpty();
  }

  /**
   * @param value {@link #approvalDate} (The date on which the resource content
   *              was approved by the publisher. Approval happens once when the
   *              content is officially approved for usage.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getApprovalDate" gives direct access to the value
   */
  public Citation setApprovalDateElement(DateType value) {
    this.approvalDate = value;
    return this;
  }

  /**
   * @return The date on which the resource content was approved by the publisher.
   *         Approval happens once when the content is officially approved for
   *         usage.
   */
  public Date getApprovalDate() {
    return this.approvalDate == null ? null : this.approvalDate.getValue();
  }

  /**
   * @param value The date on which the resource content was approved by the
   *              publisher. Approval happens once when the content is officially
   *              approved for usage.
   */
  public Citation setApprovalDate(Date value) {
    if (value == null)
      this.approvalDate = null;
    else {
      if (this.approvalDate == null)
        this.approvalDate = new DateType();
      this.approvalDate.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #lastReviewDate} (The date on which the resource content was
   *         last reviewed. Review happens periodically after approval but does
   *         not change the original approval date.). This is the underlying
   *         object with id, value and extensions. The accessor
   *         "getLastReviewDate" gives direct access to the value
   */
  public DateType getLastReviewDateElement() {
    if (this.lastReviewDate == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.lastReviewDate");
      else if (Configuration.doAutoCreate())
        this.lastReviewDate = new DateType(); // bb
    return this.lastReviewDate;
  }

  public boolean hasLastReviewDateElement() {
    return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
  }

  public boolean hasLastReviewDate() {
    return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
  }

  /**
   * @param value {@link #lastReviewDate} (The date on which the resource content
   *              was last reviewed. Review happens periodically after approval
   *              but does not change the original approval date.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getLastReviewDate" gives direct access to the value
   */
  public Citation setLastReviewDateElement(DateType value) {
    this.lastReviewDate = value;
    return this;
  }

  /**
   * @return The date on which the resource content was last reviewed. Review
   *         happens periodically after approval but does not change the original
   *         approval date.
   */
  public Date getLastReviewDate() {
    return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
  }

  /**
   * @param value The date on which the resource content was last reviewed. Review
   *              happens periodically after approval but does not change the
   *              original approval date.
   */
  public Citation setLastReviewDate(Date value) {
    if (value == null)
      this.lastReviewDate = null;
    else {
      if (this.lastReviewDate == null)
        this.lastReviewDate = new DateType();
      this.lastReviewDate.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #effectivePeriod} (The period during which the citation
   *         content was or is planned to be in active use.)
   */
  public Period getEffectivePeriod() {
    if (this.effectivePeriod == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.effectivePeriod");
      else if (Configuration.doAutoCreate())
        this.effectivePeriod = new Period(); // cc
    return this.effectivePeriod;
  }

  public boolean hasEffectivePeriod() {
    return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
  }

  /**
   * @param value {@link #effectivePeriod} (The period during which the citation
   *              content was or is planned to be in active use.)
   */
  public Citation setEffectivePeriod(Period value) {
    this.effectivePeriod = value;
    return this;
  }

  /**
   * @return {@link #author} (Who authored the Citation.)
   */
  public List<ContactDetail> getAuthor() {
    if (this.author == null)
      this.author = new ArrayList<ContactDetail>();
    return this.author;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setAuthor(List<ContactDetail> theAuthor) {
    this.author = theAuthor;
    return this;
  }

  public boolean hasAuthor() {
    if (this.author == null)
      return false;
    for (ContactDetail item : this.author)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addAuthor() { // 3
    ContactDetail t = new ContactDetail();
    if (this.author == null)
      this.author = new ArrayList<ContactDetail>();
    this.author.add(t);
    return t;
  }

  public Citation addAuthor(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.author == null)
      this.author = new ArrayList<ContactDetail>();
    this.author.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #author}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getAuthorFirstRep() {
    if (getAuthor().isEmpty()) {
      addAuthor();
    }
    return getAuthor().get(0);
  }

  /**
   * @return {@link #editor} (Who edited the Citation.)
   */
  public List<ContactDetail> getEditor() {
    if (this.editor == null)
      this.editor = new ArrayList<ContactDetail>();
    return this.editor;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setEditor(List<ContactDetail> theEditor) {
    this.editor = theEditor;
    return this;
  }

  public boolean hasEditor() {
    if (this.editor == null)
      return false;
    for (ContactDetail item : this.editor)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addEditor() { // 3
    ContactDetail t = new ContactDetail();
    if (this.editor == null)
      this.editor = new ArrayList<ContactDetail>();
    this.editor.add(t);
    return t;
  }

  public Citation addEditor(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.editor == null)
      this.editor = new ArrayList<ContactDetail>();
    this.editor.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #editor}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getEditorFirstRep() {
    if (getEditor().isEmpty()) {
      addEditor();
    }
    return getEditor().get(0);
  }

  /**
   * @return {@link #reviewer} (Who reviewed the Citation.)
   */
  public List<ContactDetail> getReviewer() {
    if (this.reviewer == null)
      this.reviewer = new ArrayList<ContactDetail>();
    return this.reviewer;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setReviewer(List<ContactDetail> theReviewer) {
    this.reviewer = theReviewer;
    return this;
  }

  public boolean hasReviewer() {
    if (this.reviewer == null)
      return false;
    for (ContactDetail item : this.reviewer)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addReviewer() { // 3
    ContactDetail t = new ContactDetail();
    if (this.reviewer == null)
      this.reviewer = new ArrayList<ContactDetail>();
    this.reviewer.add(t);
    return t;
  }

  public Citation addReviewer(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.reviewer == null)
      this.reviewer = new ArrayList<ContactDetail>();
    this.reviewer.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #reviewer}, creating
   *         it if it does not already exist {3}
   */
  public ContactDetail getReviewerFirstRep() {
    if (getReviewer().isEmpty()) {
      addReviewer();
    }
    return getReviewer().get(0);
  }

  /**
   * @return {@link #endorser} (Who endorsed the Citation.)
   */
  public List<ContactDetail> getEndorser() {
    if (this.endorser == null)
      this.endorser = new ArrayList<ContactDetail>();
    return this.endorser;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setEndorser(List<ContactDetail> theEndorser) {
    this.endorser = theEndorser;
    return this;
  }

  public boolean hasEndorser() {
    if (this.endorser == null)
      return false;
    for (ContactDetail item : this.endorser)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addEndorser() { // 3
    ContactDetail t = new ContactDetail();
    if (this.endorser == null)
      this.endorser = new ArrayList<ContactDetail>();
    this.endorser.add(t);
    return t;
  }

  public Citation addEndorser(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.endorser == null)
      this.endorser = new ArrayList<ContactDetail>();
    this.endorser.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #endorser}, creating
   *         it if it does not already exist {3}
   */
  public ContactDetail getEndorserFirstRep() {
    if (getEndorser().isEmpty()) {
      addEndorser();
    }
    return getEndorser().get(0);
  }

  /**
   * @return {@link #summary} (A human-readable display of the citation.)
   */
  public List<ContactDetail> getSummary() {
    if (this.summary == null)
      this.summary = new ArrayList<ContactDetail>();
    return this.summary;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setSummary(List<ContactDetail> theSummary) {
    this.summary = theSummary;
    return this;
  }

  public boolean hasSummary() {
    if (this.summary == null)
      return false;
    for (ContactDetail item : this.summary)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addSummary() { // 3
    ContactDetail t = new ContactDetail();
    if (this.summary == null)
      this.summary = new ArrayList<ContactDetail>();
    this.summary.add(t);
    return t;
  }

  public Citation addSummary(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.summary == null)
      this.summary = new ArrayList<ContactDetail>();
    this.summary.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #summary}, creating it
   *         if it does not already exist {3}
   */
  public ContactDetail getSummaryFirstRep() {
    if (getSummary().isEmpty()) {
      addSummary();
    }
    return getSummary().get(0);
  }

  /**
   * @return {@link #classification} (The assignment to an organizing scheme.)
   */
  public List<CitationClassificationComponent> getClassification() {
    if (this.classification == null)
      this.classification = new ArrayList<CitationClassificationComponent>();
    return this.classification;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setClassification(List<CitationClassificationComponent> theClassification) {
    this.classification = theClassification;
    return this;
  }

  public boolean hasClassification() {
    if (this.classification == null)
      return false;
    for (CitationClassificationComponent item : this.classification)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CitationClassificationComponent addClassification() { // 3
    CitationClassificationComponent t = new CitationClassificationComponent();
    if (this.classification == null)
      this.classification = new ArrayList<CitationClassificationComponent>();
    this.classification.add(t);
    return t;
  }

  public Citation addClassification(CitationClassificationComponent t) { // 3
    if (t == null)
      return this;
    if (this.classification == null)
      this.classification = new ArrayList<CitationClassificationComponent>();
    this.classification.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #classification},
   *         creating it if it does not already exist {3}
   */
  public CitationClassificationComponent getClassificationFirstRep() {
    if (getClassification().isEmpty()) {
      addClassification();
    }
    return getClassification().get(0);
  }

  /**
   * @return {@link #note} (Used for general notes and annotations not coded
   *         elsewhere.)
   */
  public List<Annotation> getNote() {
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    return this.note;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setNote(List<Annotation> theNote) {
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

  public Annotation addNote() { // 3
    Annotation t = new Annotation();
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return t;
  }

  public Citation addNote(Annotation t) { // 3
    if (t == null)
      return this;
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #note}, creating it if
   *         it does not already exist {3}
   */
  public Annotation getNoteFirstRep() {
    if (getNote().isEmpty()) {
      addNote();
    }
    return getNote().get(0);
  }

  /**
   * @return {@link #currentState} (The status of the citation.)
   */
  public List<CodeableConcept> getCurrentState() {
    if (this.currentState == null)
      this.currentState = new ArrayList<CodeableConcept>();
    return this.currentState;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setCurrentState(List<CodeableConcept> theCurrentState) {
    this.currentState = theCurrentState;
    return this;
  }

  public boolean hasCurrentState() {
    if (this.currentState == null)
      return false;
    for (CodeableConcept item : this.currentState)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addCurrentState() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.currentState == null)
      this.currentState = new ArrayList<CodeableConcept>();
    this.currentState.add(t);
    return t;
  }

  public Citation addCurrentState(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.currentState == null)
      this.currentState = new ArrayList<CodeableConcept>();
    this.currentState.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #currentState},
   *         creating it if it does not already exist {3}
   */
  public CodeableConcept getCurrentStateFirstRep() {
    if (getCurrentState().isEmpty()) {
      addCurrentState();
    }
    return getCurrentState().get(0);
  }

  /**
   * @return {@link #statusDate} (An effective date or period for a status of the
   *         citation.)
   */
  public List<CitationStatusDateComponent> getStatusDate() {
    if (this.statusDate == null)
      this.statusDate = new ArrayList<CitationStatusDateComponent>();
    return this.statusDate;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setStatusDate(List<CitationStatusDateComponent> theStatusDate) {
    this.statusDate = theStatusDate;
    return this;
  }

  public boolean hasStatusDate() {
    if (this.statusDate == null)
      return false;
    for (CitationStatusDateComponent item : this.statusDate)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CitationStatusDateComponent addStatusDate() { // 3
    CitationStatusDateComponent t = new CitationStatusDateComponent();
    if (this.statusDate == null)
      this.statusDate = new ArrayList<CitationStatusDateComponent>();
    this.statusDate.add(t);
    return t;
  }

  public Citation addStatusDate(CitationStatusDateComponent t) { // 3
    if (t == null)
      return this;
    if (this.statusDate == null)
      this.statusDate = new ArrayList<CitationStatusDateComponent>();
    this.statusDate.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #statusDate}, creating
   *         it if it does not already exist {3}
   */
  public CitationStatusDateComponent getStatusDateFirstRep() {
    if (getStatusDate().isEmpty()) {
      addStatusDate();
    }
    return getStatusDate().get(0);
  }

  /**
   * @return {@link #relatesTo} (Artifact related to the Citation Resource.)
   */
  public List<CitationRelatesToComponent> getRelatesTo() {
    if (this.relatesTo == null)
      this.relatesTo = new ArrayList<CitationRelatesToComponent>();
    return this.relatesTo;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Citation setRelatesTo(List<CitationRelatesToComponent> theRelatesTo) {
    this.relatesTo = theRelatesTo;
    return this;
  }

  public boolean hasRelatesTo() {
    if (this.relatesTo == null)
      return false;
    for (CitationRelatesToComponent item : this.relatesTo)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CitationRelatesToComponent addRelatesTo() { // 3
    CitationRelatesToComponent t = new CitationRelatesToComponent();
    if (this.relatesTo == null)
      this.relatesTo = new ArrayList<CitationRelatesToComponent>();
    this.relatesTo.add(t);
    return t;
  }

  public Citation addRelatesTo(CitationRelatesToComponent t) { // 3
    if (t == null)
      return this;
    if (this.relatesTo == null)
      this.relatesTo = new ArrayList<CitationRelatesToComponent>();
    this.relatesTo.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #relatesTo}, creating
   *         it if it does not already exist {3}
   */
  public CitationRelatesToComponent getRelatesToFirstRep() {
    if (getRelatesTo().isEmpty()) {
      addRelatesTo();
    }
    return getRelatesTo().get(0);
  }

  /**
   * @return {@link #citedArtifact} (The article or artifact being described.)
   */
  public CitationCitedArtifactComponent getCitedArtifact() {
    if (this.citedArtifact == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Citation.citedArtifact");
      else if (Configuration.doAutoCreate())
        this.citedArtifact = new CitationCitedArtifactComponent(); // cc
    return this.citedArtifact;
  }

  public boolean hasCitedArtifact() {
    return this.citedArtifact != null && !this.citedArtifact.isEmpty();
  }

  /**
   * @param value {@link #citedArtifact} (The article or artifact being
   *              described.)
   */
  public Citation setCitedArtifact(CitationCitedArtifactComponent value) {
    this.citedArtifact = value;
    return this;
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("url", "uri",
        "An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.",
        0, 1, url));
    children.add(new Property("identifier", "Identifier",
        "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.",
        0, java.lang.Integer.MAX_VALUE, identifier));
    children.add(new Property("version", "string",
        "The identifier that is used to identify this version of the citation when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.",
        0, 1, version));
    children.add(new Property("name", "string",
        "A natural language name identifying the citation. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
        0, 1, name));
    children.add(
        new Property("title", "string", "A short, descriptive, user-friendly title for the citation.", 0, 1, title));
    children.add(new Property("status", "code",
        "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
    children.add(new Property("experimental", "boolean",
        "A Boolean value to indicate that this citation is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
        0, 1, experimental));
    children.add(new Property("date", "dateTime",
        "The date  (and optionally time) when the citation was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation changes.",
        0, 1, date));
    children.add(new Property("publisher", "string",
        "The name of the organization or individual that published the citation.", 0, 1, publisher));
    children.add(new Property("contact", "ContactDetail",
        "Contact details to assist a user in finding and communicating with the publisher.", 0,
        java.lang.Integer.MAX_VALUE, contact));
    children.add(new Property("description", "markdown",
        "A free text natural language description of the citation from a consumer's perspective.", 0, 1, description));
    children.add(new Property("useContext", "UsageContext",
        "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.",
        0, java.lang.Integer.MAX_VALUE, useContext));
    children.add(new Property("jurisdiction", "CodeableConcept",
        "A legal or geographic region in which the citation is intended to be used.", 0, java.lang.Integer.MAX_VALUE,
        jurisdiction));
    children.add(new Property("purpose", "markdown",
        "Explanation of why this citation is needed and why it has been designed as it has.", 0, 1, purpose));
    children.add(new Property("copyright", "markdown",
        "Use and/or publishing restrictions for the Citation, not for the cited artifact.", 0, 1, copyright));
    children.add(new Property("approvalDate", "date",
        "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.",
        0, 1, approvalDate));
    children.add(new Property("lastReviewDate", "date",
        "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.",
        0, 1, lastReviewDate));
    children.add(new Property("effectivePeriod", "Period",
        "The period during which the citation content was or is planned to be in active use.", 0, 1, effectivePeriod));
    children.add(
        new Property("author", "ContactDetail", "Who authored the Citation.", 0, java.lang.Integer.MAX_VALUE, author));
    children.add(
        new Property("editor", "ContactDetail", "Who edited the Citation.", 0, java.lang.Integer.MAX_VALUE, editor));
    children.add(new Property("reviewer", "ContactDetail", "Who reviewed the Citation.", 0, java.lang.Integer.MAX_VALUE,
        reviewer));
    children.add(new Property("endorser", "ContactDetail", "Who endorsed the Citation.", 0, java.lang.Integer.MAX_VALUE,
        endorser));
    children.add(new Property("summary", "ContactDetail", "A human-readable display of the citation.", 0,
        java.lang.Integer.MAX_VALUE, summary));
    children.add(new Property("classification", "", "The assignment to an organizing scheme.", 0,
        java.lang.Integer.MAX_VALUE, classification));
    children.add(new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0,
        java.lang.Integer.MAX_VALUE, note));
    children.add(new Property("currentState", "CodeableConcept", "The status of the citation.", 0,
        java.lang.Integer.MAX_VALUE, currentState));
    children.add(new Property("statusDate", "", "An effective date or period for a status of the citation.", 0,
        java.lang.Integer.MAX_VALUE, statusDate));
    children.add(new Property("relatesTo", "", "Artifact related to the Citation Resource.", 0,
        java.lang.Integer.MAX_VALUE, relatesTo));
    children.add(new Property("citedArtifact", "", "The article or artifact being described.", 0, 1, citedArtifact));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case 116079:
      /* url */ return new Property("url", "uri",
          "An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.",
          0, 1, url);
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier",
          "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.",
          0, java.lang.Integer.MAX_VALUE, identifier);
    case 351608024:
      /* version */ return new Property("version", "string",
          "The identifier that is used to identify this version of the citation when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.",
          0, 1, version);
    case 3373707:
      /* name */ return new Property("name", "string",
          "A natural language name identifying the citation. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
          0, 1, name);
    case 110371416:
      /* title */ return new Property("title", "string", "A short, descriptive, user-friendly title for the citation.",
          0, 1, title);
    case -892481550:
      /* status */ return new Property("status", "code",
          "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
    case -404562712:
      /* experimental */ return new Property("experimental", "boolean",
          "A Boolean value to indicate that this citation is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
          0, 1, experimental);
    case 3076014:
      /* date */ return new Property("date", "dateTime",
          "The date  (and optionally time) when the citation was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation changes.",
          0, 1, date);
    case 1447404028:
      /* publisher */ return new Property("publisher", "string",
          "The name of the organization or individual that published the citation.", 0, 1, publisher);
    case 951526432:
      /* contact */ return new Property("contact", "ContactDetail",
          "Contact details to assist a user in finding and communicating with the publisher.", 0,
          java.lang.Integer.MAX_VALUE, contact);
    case -1724546052:
      /* description */ return new Property("description", "markdown",
          "A free text natural language description of the citation from a consumer's perspective.", 0, 1, description);
    case -669707736:
      /* useContext */ return new Property("useContext", "UsageContext",
          "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.",
          0, java.lang.Integer.MAX_VALUE, useContext);
    case -507075711:
      /* jurisdiction */ return new Property("jurisdiction", "CodeableConcept",
          "A legal or geographic region in which the citation is intended to be used.", 0, java.lang.Integer.MAX_VALUE,
          jurisdiction);
    case -220463842:
      /* purpose */ return new Property("purpose", "markdown",
          "Explanation of why this citation is needed and why it has been designed as it has.", 0, 1, purpose);
    case 1522889671:
      /* copyright */ return new Property("copyright", "markdown",
          "Use and/or publishing restrictions for the Citation, not for the cited artifact.", 0, 1, copyright);
    case 223539345:
      /* approvalDate */ return new Property("approvalDate", "date",
          "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.",
          0, 1, approvalDate);
    case -1687512484:
      /* lastReviewDate */ return new Property("lastReviewDate", "date",
          "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.",
          0, 1, lastReviewDate);
    case -403934648:
      /* effectivePeriod */ return new Property("effectivePeriod", "Period",
          "The period during which the citation content was or is planned to be in active use.", 0, 1, effectivePeriod);
    case -1406328437:
      /* author */ return new Property("author", "ContactDetail", "Who authored the Citation.", 0,
          java.lang.Integer.MAX_VALUE, author);
    case -1307827859:
      /* editor */ return new Property("editor", "ContactDetail", "Who edited the Citation.", 0,
          java.lang.Integer.MAX_VALUE, editor);
    case -261190139:
      /* reviewer */ return new Property("reviewer", "ContactDetail", "Who reviewed the Citation.", 0,
          java.lang.Integer.MAX_VALUE, reviewer);
    case 1740277666:
      /* endorser */ return new Property("endorser", "ContactDetail", "Who endorsed the Citation.", 0,
          java.lang.Integer.MAX_VALUE, endorser);
    case -1857640538:
      /* summary */ return new Property("summary", "ContactDetail", "A human-readable display of the citation.", 0,
          java.lang.Integer.MAX_VALUE, summary);
    case 382350310:
      /* classification */ return new Property("classification", "", "The assignment to an organizing scheme.", 0,
          java.lang.Integer.MAX_VALUE, classification);
    case 3387378:
      /* note */ return new Property("note", "Annotation",
          "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note);
    case 1457822360:
      /* currentState */ return new Property("currentState", "CodeableConcept", "The status of the citation.", 0,
          java.lang.Integer.MAX_VALUE, currentState);
    case 247524032:
      /* statusDate */ return new Property("statusDate", "",
          "An effective date or period for a status of the citation.", 0, java.lang.Integer.MAX_VALUE, statusDate);
    case -7765931:
      /* relatesTo */ return new Property("relatesTo", "", "Artifact related to the Citation Resource.", 0,
          java.lang.Integer.MAX_VALUE, relatesTo);
    case -495272225:
      /* citedArtifact */ return new Property("citedArtifact", "", "The article or artifact being described.", 0, 1,
          citedArtifact);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case 116079:
      /* url */ return this.url == null ? new Base[0] : new Base[] { this.url }; // UriType
    case -1618432855:
      /* identifier */ return this.identifier == null ? new Base[0]
          : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
    case 351608024:
      /* version */ return this.version == null ? new Base[0] : new Base[] { this.version }; // StringType
    case 3373707:
      /* name */ return this.name == null ? new Base[0] : new Base[] { this.name }; // StringType
    case 110371416:
      /* title */ return this.title == null ? new Base[0] : new Base[] { this.title }; // StringType
    case -892481550:
      /* status */ return this.status == null ? new Base[0] : new Base[] { this.status }; // Enumeration<PublicationStatus>
    case -404562712:
      /* experimental */ return this.experimental == null ? new Base[0] : new Base[] { this.experimental }; // BooleanType
    case 3076014:
      /* date */ return this.date == null ? new Base[0] : new Base[] { this.date }; // DateTimeType
    case 1447404028:
      /* publisher */ return this.publisher == null ? new Base[0] : new Base[] { this.publisher }; // StringType
    case 951526432:
      /* contact */ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
    case -1724546052:
      /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // MarkdownType
    case -669707736:
      /* useContext */ return this.useContext == null ? new Base[0]
          : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
    case -507075711:
      /* jurisdiction */ return this.jurisdiction == null ? new Base[0]
          : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
    case -220463842:
      /* purpose */ return this.purpose == null ? new Base[0] : new Base[] { this.purpose }; // MarkdownType
    case 1522889671:
      /* copyright */ return this.copyright == null ? new Base[0] : new Base[] { this.copyright }; // MarkdownType
    case 223539345:
      /* approvalDate */ return this.approvalDate == null ? new Base[0] : new Base[] { this.approvalDate }; // DateType
    case -1687512484:
      /* lastReviewDate */ return this.lastReviewDate == null ? new Base[0] : new Base[] { this.lastReviewDate }; // DateType
    case -403934648:
      /* effectivePeriod */ return this.effectivePeriod == null ? new Base[0] : new Base[] { this.effectivePeriod }; // Period
    case -1406328437:
      /* author */ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
    case -1307827859:
      /* editor */ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
    case -261190139:
      /* reviewer */ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
    case 1740277666:
      /* endorser */ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
    case -1857640538:
      /* summary */ return this.summary == null ? new Base[0] : this.summary.toArray(new Base[this.summary.size()]); // ContactDetail
    case 382350310:
      /* classification */ return this.classification == null ? new Base[0]
          : this.classification.toArray(new Base[this.classification.size()]); // CitationClassificationComponent
    case 3387378:
      /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
    case 1457822360:
      /* currentState */ return this.currentState == null ? new Base[0]
          : this.currentState.toArray(new Base[this.currentState.size()]); // CodeableConcept
    case 247524032:
      /* statusDate */ return this.statusDate == null ? new Base[0]
          : this.statusDate.toArray(new Base[this.statusDate.size()]); // CitationStatusDateComponent
    case -7765931:
      /* relatesTo */ return this.relatesTo == null ? new Base[0]
          : this.relatesTo.toArray(new Base[this.relatesTo.size()]); // CitationRelatesToComponent
    case -495272225:
      /* citedArtifact */ return this.citedArtifact == null ? new Base[0] : new Base[] { this.citedArtifact }; // CitationCitedArtifactComponent
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 116079: // url
      this.url = TypeConvertor.castToUri(value); // UriType
      return value;
    case -1618432855: // identifier
      this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
      return value;
    case 351608024: // version
      this.version = TypeConvertor.castToString(value); // StringType
      return value;
    case 3373707: // name
      this.name = TypeConvertor.castToString(value); // StringType
      return value;
    case 110371416: // title
      this.title = TypeConvertor.castToString(value); // StringType
      return value;
    case -892481550: // status
      value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
      return value;
    case -404562712: // experimental
      this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
      return value;
    case 3076014: // date
      this.date = TypeConvertor.castToDateTime(value); // DateTimeType
      return value;
    case 1447404028: // publisher
      this.publisher = TypeConvertor.castToString(value); // StringType
      return value;
    case 951526432: // contact
      this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -1724546052: // description
      this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case -669707736: // useContext
      this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
      return value;
    case -507075711: // jurisdiction
      this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -220463842: // purpose
      this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case 1522889671: // copyright
      this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
      return value;
    case 223539345: // approvalDate
      this.approvalDate = TypeConvertor.castToDate(value); // DateType
      return value;
    case -1687512484: // lastReviewDate
      this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
      return value;
    case -403934648: // effectivePeriod
      this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
      return value;
    case -1406328437: // author
      this.getAuthor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -1307827859: // editor
      this.getEditor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -261190139: // reviewer
      this.getReviewer().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case 1740277666: // endorser
      this.getEndorser().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case -1857640538: // summary
      this.getSummary().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
      return value;
    case 382350310: // classification
      this.getClassification().add((CitationClassificationComponent) value); // CitationClassificationComponent
      return value;
    case 3387378: // note
      this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
      return value;
    case 1457822360: // currentState
      this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
      return value;
    case 247524032: // statusDate
      this.getStatusDate().add((CitationStatusDateComponent) value); // CitationStatusDateComponent
      return value;
    case -7765931: // relatesTo
      this.getRelatesTo().add((CitationRelatesToComponent) value); // CitationRelatesToComponent
      return value;
    case -495272225: // citedArtifact
      this.citedArtifact = (CitationCitedArtifactComponent) value; // CitationCitedArtifactComponent
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = TypeConvertor.castToUri(value); // UriType
    } else if (name.equals("identifier")) {
      this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
    } else if (name.equals("version")) {
      this.version = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("name")) {
      this.name = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("title")) {
      this.title = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("status")) {
      value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
    } else if (name.equals("experimental")) {
      this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
    } else if (name.equals("date")) {
      this.date = TypeConvertor.castToDateTime(value); // DateTimeType
    } else if (name.equals("publisher")) {
      this.publisher = TypeConvertor.castToString(value); // StringType
    } else if (name.equals("contact")) {
      this.getContact().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("description")) {
      this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("useContext")) {
      this.getUseContext().add(TypeConvertor.castToUsageContext(value));
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
    } else if (name.equals("purpose")) {
      this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("copyright")) {
      this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
    } else if (name.equals("approvalDate")) {
      this.approvalDate = TypeConvertor.castToDate(value); // DateType
    } else if (name.equals("lastReviewDate")) {
      this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
    } else if (name.equals("effectivePeriod")) {
      this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
    } else if (name.equals("author")) {
      this.getAuthor().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("editor")) {
      this.getEditor().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("reviewer")) {
      this.getReviewer().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("endorser")) {
      this.getEndorser().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("summary")) {
      this.getSummary().add(TypeConvertor.castToContactDetail(value));
    } else if (name.equals("classification")) {
      this.getClassification().add((CitationClassificationComponent) value);
    } else if (name.equals("note")) {
      this.getNote().add(TypeConvertor.castToAnnotation(value));
    } else if (name.equals("currentState")) {
      this.getCurrentState().add(TypeConvertor.castToCodeableConcept(value));
    } else if (name.equals("statusDate")) {
      this.getStatusDate().add((CitationStatusDateComponent) value);
    } else if (name.equals("relatesTo")) {
      this.getRelatesTo().add((CitationRelatesToComponent) value);
    } else if (name.equals("citedArtifact")) {
      this.citedArtifact = (CitationCitedArtifactComponent) value; // CitationCitedArtifactComponent
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      return getUrlElement();
    case -1618432855:
      return addIdentifier();
    case 351608024:
      return getVersionElement();
    case 3373707:
      return getNameElement();
    case 110371416:
      return getTitleElement();
    case -892481550:
      return getStatusElement();
    case -404562712:
      return getExperimentalElement();
    case 3076014:
      return getDateElement();
    case 1447404028:
      return getPublisherElement();
    case 951526432:
      return addContact();
    case -1724546052:
      return getDescriptionElement();
    case -669707736:
      return addUseContext();
    case -507075711:
      return addJurisdiction();
    case -220463842:
      return getPurposeElement();
    case 1522889671:
      return getCopyrightElement();
    case 223539345:
      return getApprovalDateElement();
    case -1687512484:
      return getLastReviewDateElement();
    case -403934648:
      return getEffectivePeriod();
    case -1406328437:
      return addAuthor();
    case -1307827859:
      return addEditor();
    case -261190139:
      return addReviewer();
    case 1740277666:
      return addEndorser();
    case -1857640538:
      return addSummary();
    case 382350310:
      return addClassification();
    case 3387378:
      return addNote();
    case 1457822360:
      return addCurrentState();
    case 247524032:
      return addStatusDate();
    case -7765931:
      return addRelatesTo();
    case -495272225:
      return getCitedArtifact();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      /* url */ return new String[] { "uri" };
    case -1618432855:
      /* identifier */ return new String[] { "Identifier" };
    case 351608024:
      /* version */ return new String[] { "string" };
    case 3373707:
      /* name */ return new String[] { "string" };
    case 110371416:
      /* title */ return new String[] { "string" };
    case -892481550:
      /* status */ return new String[] { "code" };
    case -404562712:
      /* experimental */ return new String[] { "boolean" };
    case 3076014:
      /* date */ return new String[] { "dateTime" };
    case 1447404028:
      /* publisher */ return new String[] { "string" };
    case 951526432:
      /* contact */ return new String[] { "ContactDetail" };
    case -1724546052:
      /* description */ return new String[] { "markdown" };
    case -669707736:
      /* useContext */ return new String[] { "UsageContext" };
    case -507075711:
      /* jurisdiction */ return new String[] { "CodeableConcept" };
    case -220463842:
      /* purpose */ return new String[] { "markdown" };
    case 1522889671:
      /* copyright */ return new String[] { "markdown" };
    case 223539345:
      /* approvalDate */ return new String[] { "date" };
    case -1687512484:
      /* lastReviewDate */ return new String[] { "date" };
    case -403934648:
      /* effectivePeriod */ return new String[] { "Period" };
    case -1406328437:
      /* author */ return new String[] { "ContactDetail" };
    case -1307827859:
      /* editor */ return new String[] { "ContactDetail" };
    case -261190139:
      /* reviewer */ return new String[] { "ContactDetail" };
    case 1740277666:
      /* endorser */ return new String[] { "ContactDetail" };
    case -1857640538:
      /* summary */ return new String[] { "ContactDetail" };
    case 382350310:
      /* classification */ return new String[] {};
    case 3387378:
      /* note */ return new String[] { "Annotation" };
    case 1457822360:
      /* currentState */ return new String[] { "CodeableConcept" };
    case 247524032:
      /* statusDate */ return new String[] {};
    case -7765931:
      /* relatesTo */ return new String[] {};
    case -495272225:
      /* citedArtifact */ return new String[] {};
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("url")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.url");
    } else if (name.equals("identifier")) {
      return addIdentifier();
    } else if (name.equals("version")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.version");
    } else if (name.equals("name")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.name");
    } else if (name.equals("title")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.title");
    } else if (name.equals("status")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.status");
    } else if (name.equals("experimental")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.experimental");
    } else if (name.equals("date")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.date");
    } else if (name.equals("publisher")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.publisher");
    } else if (name.equals("contact")) {
      return addContact();
    } else if (name.equals("description")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.description");
    } else if (name.equals("useContext")) {
      return addUseContext();
    } else if (name.equals("jurisdiction")) {
      return addJurisdiction();
    } else if (name.equals("purpose")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.purpose");
    } else if (name.equals("copyright")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.copyright");
    } else if (name.equals("approvalDate")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.approvalDate");
    } else if (name.equals("lastReviewDate")) {
      throw new FHIRException("Cannot call addChild on a primitive type Citation.lastReviewDate");
    } else if (name.equals("effectivePeriod")) {
      this.effectivePeriod = new Period();
      return this.effectivePeriod;
    } else if (name.equals("author")) {
      return addAuthor();
    } else if (name.equals("editor")) {
      return addEditor();
    } else if (name.equals("reviewer")) {
      return addReviewer();
    } else if (name.equals("endorser")) {
      return addEndorser();
    } else if (name.equals("summary")) {
      return addSummary();
    } else if (name.equals("classification")) {
      return addClassification();
    } else if (name.equals("note")) {
      return addNote();
    } else if (name.equals("currentState")) {
      return addCurrentState();
    } else if (name.equals("statusDate")) {
      return addStatusDate();
    } else if (name.equals("relatesTo")) {
      return addRelatesTo();
    } else if (name.equals("citedArtifact")) {
      this.citedArtifact = new CitationCitedArtifactComponent();
      return this.citedArtifact;
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "Citation";

  }

  public Citation copy() {
    Citation dst = new Citation();
    copyValues(dst);
    return dst;
  }

  public void copyValues(Citation dst) {
    super.copyValues(dst);
    dst.url = url == null ? null : url.copy();
    if (identifier != null) {
      dst.identifier = new ArrayList<Identifier>();
      for (Identifier i : identifier)
        dst.identifier.add(i.copy());
    }
    ;
    dst.version = version == null ? null : version.copy();
    dst.name = name == null ? null : name.copy();
    dst.title = title == null ? null : title.copy();
    dst.status = status == null ? null : status.copy();
    dst.experimental = experimental == null ? null : experimental.copy();
    dst.date = date == null ? null : date.copy();
    dst.publisher = publisher == null ? null : publisher.copy();
    if (contact != null) {
      dst.contact = new ArrayList<ContactDetail>();
      for (ContactDetail i : contact)
        dst.contact.add(i.copy());
    }
    ;
    dst.description = description == null ? null : description.copy();
    if (useContext != null) {
      dst.useContext = new ArrayList<UsageContext>();
      for (UsageContext i : useContext)
        dst.useContext.add(i.copy());
    }
    ;
    if (jurisdiction != null) {
      dst.jurisdiction = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : jurisdiction)
        dst.jurisdiction.add(i.copy());
    }
    ;
    dst.purpose = purpose == null ? null : purpose.copy();
    dst.copyright = copyright == null ? null : copyright.copy();
    dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
    dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
    dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
    if (author != null) {
      dst.author = new ArrayList<ContactDetail>();
      for (ContactDetail i : author)
        dst.author.add(i.copy());
    }
    ;
    if (editor != null) {
      dst.editor = new ArrayList<ContactDetail>();
      for (ContactDetail i : editor)
        dst.editor.add(i.copy());
    }
    ;
    if (reviewer != null) {
      dst.reviewer = new ArrayList<ContactDetail>();
      for (ContactDetail i : reviewer)
        dst.reviewer.add(i.copy());
    }
    ;
    if (endorser != null) {
      dst.endorser = new ArrayList<ContactDetail>();
      for (ContactDetail i : endorser)
        dst.endorser.add(i.copy());
    }
    ;
    if (summary != null) {
      dst.summary = new ArrayList<ContactDetail>();
      for (ContactDetail i : summary)
        dst.summary.add(i.copy());
    }
    ;
    if (classification != null) {
      dst.classification = new ArrayList<CitationClassificationComponent>();
      for (CitationClassificationComponent i : classification)
        dst.classification.add(i.copy());
    }
    ;
    if (note != null) {
      dst.note = new ArrayList<Annotation>();
      for (Annotation i : note)
        dst.note.add(i.copy());
    }
    ;
    if (currentState != null) {
      dst.currentState = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : currentState)
        dst.currentState.add(i.copy());
    }
    ;
    if (statusDate != null) {
      dst.statusDate = new ArrayList<CitationStatusDateComponent>();
      for (CitationStatusDateComponent i : statusDate)
        dst.statusDate.add(i.copy());
    }
    ;
    if (relatesTo != null) {
      dst.relatesTo = new ArrayList<CitationRelatesToComponent>();
      for (CitationRelatesToComponent i : relatesTo)
        dst.relatesTo.add(i.copy());
    }
    ;
    dst.citedArtifact = citedArtifact == null ? null : citedArtifact.copy();
  }

  protected Citation typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof Citation))
      return false;
    Citation o = (Citation) other_;
    return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true)
        && compareDeep(version, o.version, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
        && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
        && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
        && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
        && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
        && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
        && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
        && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(author, o.author, true)
        && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true)
        && compareDeep(endorser, o.endorser, true) && compareDeep(summary, o.summary, true)
        && compareDeep(classification, o.classification, true) && compareDeep(note, o.note, true)
        && compareDeep(currentState, o.currentState, true) && compareDeep(statusDate, o.statusDate, true)
        && compareDeep(relatesTo, o.relatesTo, true) && compareDeep(citedArtifact, o.citedArtifact, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof Citation))
      return false;
    Citation o = (Citation) other_;
    return compareValues(url, o.url, true) && compareValues(version, o.version, true)
        && compareValues(name, o.name, true) && compareValues(title, o.title, true)
        && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
        && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true)
        && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true)
        && compareValues(copyright, o.copyright, true) && compareValues(approvalDate, o.approvalDate, true)
        && compareValues(lastReviewDate, o.lastReviewDate, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version, name, title, status,
        experimental, date, publisher, contact, description, useContext, jurisdiction, purpose, copyright, approvalDate,
        lastReviewDate, effectivePeriod, author, editor, reviewer, endorser, summary, classification, note,
        currentState, statusDate, relatesTo, citedArtifact);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Citation;
  }

  /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * citation</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Citation.useContext.value as Quantity) | (Citation.useContext.value
   * as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-quantity", path = "(Citation.useContext.value as Quantity) | (Citation.useContext.value as Range)", description = "A quantity- or range-valued use context assigned to the citation", type = "quantity")
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * citation</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Citation.useContext.value as Quantity) | (Citation.useContext.value
   * as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(
      SP_CONTEXT_QUANTITY);

  /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-quantity", path = "Citation.useContext", description = "A use context type and quantity- or range-based value assigned to the citation", type = "composite", compositeOf = {
      "context-type", "context-quantity" })
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for
   * <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(
      SP_CONTEXT_TYPE_QUANTITY);

  /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-value", path = "Citation.useContext", description = "A use context type and value assigned to the citation", type = "composite", compositeOf = {
      "context-type", "context" })
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(
      SP_CONTEXT_TYPE_VALUE);

  /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type", path = "Citation.useContext.code", description = "A type of use context assigned to the citation", type = "token")
  public static final String SP_CONTEXT_TYPE = "context-type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT_TYPE);

  /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context", path = "(Citation.useContext.value as CodeableConcept)", description = "A use context assigned to the citation", type = "token")
  public static final String SP_CONTEXT = "context";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT);

  /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The citation publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Citation.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "date", path = "Citation.date", description = "The citation publication date", type = "date")
  public static final String SP_DATE = "date";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The citation publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Citation.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_DATE);

  /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "description", path = "Citation.description", description = "The description of the citation", type = "string")
  public static final String SP_DESCRIPTION = "description";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_DESCRIPTION);

  /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>The time during which the citation is intended to be in
   * use</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Citation.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "effective", path = "Citation.effectivePeriod", description = "The time during which the citation is intended to be in use", type = "date")
  public static final String SP_EFFECTIVE = "effective";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>The time during which the citation is intended to be in
   * use</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Citation.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_EFFECTIVE);

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "Citation.identifier", description = "External identifier for the citation", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "jurisdiction", path = "Citation.jurisdiction", description = "Intended jurisdiction for the citation", type = "token")
  public static final String SP_JURISDICTION = "jurisdiction";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_JURISDICTION);

  /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "name", path = "Citation.name", description = "Computationally friendly name of the citation", type = "string")
  public static final String SP_NAME = "name";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_NAME);

  /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "publisher", path = "Citation.publisher", description = "Name of the publisher of the citation", type = "string")
  public static final String SP_PUBLISHER = "publisher";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_PUBLISHER);

  /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "status", path = "Citation.status", description = "The current status of the citation", type = "token")
  public static final String SP_STATUS = "status";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_STATUS);

  /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "title", path = "Citation.title", description = "The human-friendly name of the citation", type = "string")
  public static final String SP_TITLE = "title";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the citation</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Citation.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_TITLE);

  /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the citation</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Citation.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "url", path = "Citation.url", description = "The uri that identifies the citation", type = "uri")
  public static final String SP_URL = "url";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the citation</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Citation.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

  /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "version", path = "Citation.version", description = "The business version of the citation", type = "token")
  public static final String SP_VERSION = "version";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_VERSION);

}
