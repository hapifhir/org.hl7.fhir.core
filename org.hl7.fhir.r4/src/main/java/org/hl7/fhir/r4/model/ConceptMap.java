package org.hl7.fhir.r4.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Tue, May 12, 2020 07:26+1000 for FHIR v4.0.1
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence;
import org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;

/**
 * A statement of relationships from one set of concepts to one or more other
 * concepts - either concepts in code systems, or data element/data element
 * concepts, or classes in class models.
 */
@ResourceDef(name = "ConceptMap", profile = "http://hl7.org/fhir/StructureDefinition/ConceptMap")
@ChildOrder(names = { "url", "identifier", "version", "name", "title", "status", "experimental", "date", "publisher",
    "contact", "description", "useContext", "jurisdiction", "purpose", "copyright", "source[x]", "target[x]", "group" })
public class ConceptMap extends MetadataResource {

  public enum ConceptMapGroupUnmappedMode {
    /**
     * Use the code as provided in the $translate request.
     */
    PROVIDED,
    /**
     * Use the code explicitly provided in the group.unmapped.
     */
    FIXED,
    /**
     * Use the map identified by the canonical URL in the url element.
     */
    OTHERMAP,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static ConceptMapGroupUnmappedMode fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("provided".equals(codeString))
        return PROVIDED;
      if ("fixed".equals(codeString))
        return FIXED;
      if ("other-map".equals(codeString))
        return OTHERMAP;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown ConceptMapGroupUnmappedMode code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case PROVIDED:
        return "provided";
      case FIXED:
        return "fixed";
      case OTHERMAP:
        return "other-map";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case PROVIDED:
        return "http://hl7.org/fhir/conceptmap-unmapped-mode";
      case FIXED:
        return "http://hl7.org/fhir/conceptmap-unmapped-mode";
      case OTHERMAP:
        return "http://hl7.org/fhir/conceptmap-unmapped-mode";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case PROVIDED:
        return "Use the code as provided in the $translate request.";
      case FIXED:
        return "Use the code explicitly provided in the group.unmapped.";
      case OTHERMAP:
        return "Use the map identified by the canonical URL in the url element.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case PROVIDED:
        return "Provided Code";
      case FIXED:
        return "Fixed Code";
      case OTHERMAP:
        return "Other Map";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class ConceptMapGroupUnmappedModeEnumFactory implements EnumFactory<ConceptMapGroupUnmappedMode> {
    public ConceptMapGroupUnmappedMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("provided".equals(codeString))
        return ConceptMapGroupUnmappedMode.PROVIDED;
      if ("fixed".equals(codeString))
        return ConceptMapGroupUnmappedMode.FIXED;
      if ("other-map".equals(codeString))
        return ConceptMapGroupUnmappedMode.OTHERMAP;
      throw new IllegalArgumentException("Unknown ConceptMapGroupUnmappedMode code '" + codeString + "'");
    }

    public Enumeration<ConceptMapGroupUnmappedMode> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.NULL, code);
      if ("provided".equals(codeString))
        return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.PROVIDED, code);
      if ("fixed".equals(codeString))
        return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.FIXED, code);
      if ("other-map".equals(codeString))
        return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.OTHERMAP, code);
      throw new FHIRException("Unknown ConceptMapGroupUnmappedMode code '" + codeString + "'");
    }

    public String toCode(ConceptMapGroupUnmappedMode code) {
       if (code == ConceptMapGroupUnmappedMode.NULL)
           return null;
       if (code == ConceptMapGroupUnmappedMode.PROVIDED)
        return "provided";
      if (code == ConceptMapGroupUnmappedMode.FIXED)
        return "fixed";
      if (code == ConceptMapGroupUnmappedMode.OTHERMAP)
        return "other-map";
      return "?";
   }

    public String toSystem(ConceptMapGroupUnmappedMode code) {
      return code.getSystem();
    }
  }

  @Block()
  public static class ConceptMapGroupComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * An absolute URI that identifies the source system where the concepts to be
     * mapped are defined.
     */
    @Child(name = "source", type = { UriType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Source system where concepts to be mapped are defined", formalDefinition = "An absolute URI that identifies the source system where the concepts to be mapped are defined.")
    protected UriType source;

    /**
     * The specific version of the code system, as determined by the code system
     * authority.
     */
    @Child(name = "sourceVersion", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Specific version of the  code system", formalDefinition = "The specific version of the code system, as determined by the code system authority.")
    protected StringType sourceVersion;

    /**
     * An absolute URI that identifies the target system that the concepts will be
     * mapped to.
     */
    @Child(name = "target", type = { UriType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Target system that the concepts are to be mapped to", formalDefinition = "An absolute URI that identifies the target system that the concepts will be mapped to.")
    protected UriType target;

    /**
     * The specific version of the code system, as determined by the code system
     * authority.
     */
    @Child(name = "targetVersion", type = {
        StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Specific version of the  code system", formalDefinition = "The specific version of the code system, as determined by the code system authority.")
    protected StringType targetVersion;

    /**
     * Mappings for an individual concept in the source to one or more concepts in
     * the target.
     */
    @Child(name = "element", type = {}, order = 5, min = 1, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Mappings for a concept from the source set", formalDefinition = "Mappings for an individual concept in the source to one or more concepts in the target.")
    protected List<SourceElementComponent> element;

    /**
     * What to do when there is no mapping for the source concept. "Unmapped" does
     * not include codes that are unmatched, and the unmapped element is ignored in
     * a code is specified to have equivalence = unmatched.
     */
    @Child(name = "unmapped", type = {}, order = 6, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "What to do when there is no mapping for the source concept", formalDefinition = "What to do when there is no mapping for the source concept. \"Unmapped\" does not include codes that are unmatched, and the unmapped element is ignored in a code is specified to have equivalence = unmatched.")
    protected ConceptMapGroupUnmappedComponent unmapped;

    private static final long serialVersionUID = 1606357508L;

    /**
     * Constructor
     */
    public ConceptMapGroupComponent() {
      super();
    }

    /**
     * @return {@link #source} (An absolute URI that identifies the source system
     *         where the concepts to be mapped are defined.). This is the underlying
     *         object with id, value and extensions. The accessor "getSource" gives
     *         direct access to the value
     */
    public UriType getSourceElement() {
      if (this.source == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupComponent.source");
        else if (Configuration.doAutoCreate())
          this.source = new UriType(); // bb
      return this.source;
    }

    public boolean hasSourceElement() {
      return this.source != null && !this.source.isEmpty();
    }

    public boolean hasSource() {
      return this.source != null && !this.source.isEmpty();
    }

    /**
     * @param value {@link #source} (An absolute URI that identifies the source
     *              system where the concepts to be mapped are defined.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getSource" gives direct access to the value
     */
    public ConceptMapGroupComponent setSourceElement(UriType value) {
      this.source = value;
      return this;
    }

    /**
     * @return An absolute URI that identifies the source system where the concepts
     *         to be mapped are defined.
     */
    public String getSource() {
      return this.source == null ? null : this.source.getValue();
    }

    /**
     * @param value An absolute URI that identifies the source system where the
     *              concepts to be mapped are defined.
     */
    public ConceptMapGroupComponent setSource(String value) {
      if (Utilities.noString(value))
        this.source = null;
      else {
        if (this.source == null)
          this.source = new UriType();
        this.source.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #sourceVersion} (The specific version of the code system, as
     *         determined by the code system authority.). This is the underlying
     *         object with id, value and extensions. The accessor "getSourceVersion"
     *         gives direct access to the value
     */
    public StringType getSourceVersionElement() {
      if (this.sourceVersion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupComponent.sourceVersion");
        else if (Configuration.doAutoCreate())
          this.sourceVersion = new StringType(); // bb
      return this.sourceVersion;
    }

    public boolean hasSourceVersionElement() {
      return this.sourceVersion != null && !this.sourceVersion.isEmpty();
    }

    public boolean hasSourceVersion() {
      return this.sourceVersion != null && !this.sourceVersion.isEmpty();
    }

    /**
     * @param value {@link #sourceVersion} (The specific version of the code system,
     *              as determined by the code system authority.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getSourceVersion" gives direct access to the value
     */
    public ConceptMapGroupComponent setSourceVersionElement(StringType value) {
      this.sourceVersion = value;
      return this;
    }

    /**
     * @return The specific version of the code system, as determined by the code
     *         system authority.
     */
    public String getSourceVersion() {
      return this.sourceVersion == null ? null : this.sourceVersion.getValue();
    }

    /**
     * @param value The specific version of the code system, as determined by the
     *              code system authority.
     */
    public ConceptMapGroupComponent setSourceVersion(String value) {
      if (Utilities.noString(value))
        this.sourceVersion = null;
      else {
        if (this.sourceVersion == null)
          this.sourceVersion = new StringType();
        this.sourceVersion.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #target} (An absolute URI that identifies the target system
     *         that the concepts will be mapped to.). This is the underlying object
     *         with id, value and extensions. The accessor "getTarget" gives direct
     *         access to the value
     */
    public UriType getTargetElement() {
      if (this.target == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupComponent.target");
        else if (Configuration.doAutoCreate())
          this.target = new UriType(); // bb
      return this.target;
    }

    public boolean hasTargetElement() {
      return this.target != null && !this.target.isEmpty();
    }

    public boolean hasTarget() {
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (An absolute URI that identifies the target
     *              system that the concepts will be mapped to.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getTarget" gives direct access to the value
     */
    public ConceptMapGroupComponent setTargetElement(UriType value) {
      this.target = value;
      return this;
    }

    /**
     * @return An absolute URI that identifies the target system that the concepts
     *         will be mapped to.
     */
    public String getTarget() {
      return this.target == null ? null : this.target.getValue();
    }

    /**
     * @param value An absolute URI that identifies the target system that the
     *              concepts will be mapped to.
     */
    public ConceptMapGroupComponent setTarget(String value) {
      if (Utilities.noString(value))
        this.target = null;
      else {
        if (this.target == null)
          this.target = new UriType();
        this.target.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #targetVersion} (The specific version of the code system, as
     *         determined by the code system authority.). This is the underlying
     *         object with id, value and extensions. The accessor "getTargetVersion"
     *         gives direct access to the value
     */
    public StringType getTargetVersionElement() {
      if (this.targetVersion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupComponent.targetVersion");
        else if (Configuration.doAutoCreate())
          this.targetVersion = new StringType(); // bb
      return this.targetVersion;
    }

    public boolean hasTargetVersionElement() {
      return this.targetVersion != null && !this.targetVersion.isEmpty();
    }

    public boolean hasTargetVersion() {
      return this.targetVersion != null && !this.targetVersion.isEmpty();
    }

    /**
     * @param value {@link #targetVersion} (The specific version of the code system,
     *              as determined by the code system authority.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getTargetVersion" gives direct access to the value
     */
    public ConceptMapGroupComponent setTargetVersionElement(StringType value) {
      this.targetVersion = value;
      return this;
    }

    /**
     * @return The specific version of the code system, as determined by the code
     *         system authority.
     */
    public String getTargetVersion() {
      return this.targetVersion == null ? null : this.targetVersion.getValue();
    }

    /**
     * @param value The specific version of the code system, as determined by the
     *              code system authority.
     */
    public ConceptMapGroupComponent setTargetVersion(String value) {
      if (Utilities.noString(value))
        this.targetVersion = null;
      else {
        if (this.targetVersion == null)
          this.targetVersion = new StringType();
        this.targetVersion.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #element} (Mappings for an individual concept in the source to
     *         one or more concepts in the target.)
     */
    public List<SourceElementComponent> getElement() {
      if (this.element == null)
        this.element = new ArrayList<SourceElementComponent>();
      return this.element;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMapGroupComponent setElement(List<SourceElementComponent> theElement) {
      this.element = theElement;
      return this;
    }

    public boolean hasElement() {
      if (this.element == null)
        return false;
      for (SourceElementComponent item : this.element)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SourceElementComponent addElement() { // 3
      SourceElementComponent t = new SourceElementComponent();
      if (this.element == null)
        this.element = new ArrayList<SourceElementComponent>();
      this.element.add(t);
      return t;
    }

    public ConceptMapGroupComponent addElement(SourceElementComponent t) { // 3
      if (t == null)
        return this;
      if (this.element == null)
        this.element = new ArrayList<SourceElementComponent>();
      this.element.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #element}, creating it
     *         if it does not already exist
     */
    public SourceElementComponent getElementFirstRep() {
      if (getElement().isEmpty()) {
        addElement();
      }
      return getElement().get(0);
    }

    /**
     * @return {@link #unmapped} (What to do when there is no mapping for the source
     *         concept. "Unmapped" does not include codes that are unmatched, and
     *         the unmapped element is ignored in a code is specified to have
     *         equivalence = unmatched.)
     */
    public ConceptMapGroupUnmappedComponent getUnmapped() {
      if (this.unmapped == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupComponent.unmapped");
        else if (Configuration.doAutoCreate())
          this.unmapped = new ConceptMapGroupUnmappedComponent(); // cc
      return this.unmapped;
    }

    public boolean hasUnmapped() {
      return this.unmapped != null && !this.unmapped.isEmpty();
    }

    /**
     * @param value {@link #unmapped} (What to do when there is no mapping for the
     *              source concept. "Unmapped" does not include codes that are
     *              unmatched, and the unmapped element is ignored in a code is
     *              specified to have equivalence = unmatched.)
     */
    public ConceptMapGroupComponent setUnmapped(ConceptMapGroupUnmappedComponent value) {
      this.unmapped = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("source", "uri",
          "An absolute URI that identifies the source system where the concepts to be mapped are defined.", 0, 1,
          source));
      children.add(new Property("sourceVersion", "string",
          "The specific version of the code system, as determined by the code system authority.", 0, 1, sourceVersion));
      children.add(new Property("target", "uri",
          "An absolute URI that identifies the target system that the concepts will be mapped to.", 0, 1, target));
      children.add(new Property("targetVersion", "string",
          "The specific version of the code system, as determined by the code system authority.", 0, 1, targetVersion));
      children.add(new Property("element", "",
          "Mappings for an individual concept in the source to one or more concepts in the target.", 0,
          java.lang.Integer.MAX_VALUE, element));
      children.add(new Property("unmapped", "",
          "What to do when there is no mapping for the source concept. \"Unmapped\" does not include codes that are unmatched, and the unmapped element is ignored in a code is specified to have equivalence = unmatched.",
          0, 1, unmapped));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -896505829:
        /* source */ return new Property("source", "uri",
            "An absolute URI that identifies the source system where the concepts to be mapped are defined.", 0, 1,
            source);
      case 446171197:
        /* sourceVersion */ return new Property("sourceVersion", "string",
            "The specific version of the code system, as determined by the code system authority.", 0, 1,
            sourceVersion);
      case -880905839:
        /* target */ return new Property("target", "uri",
            "An absolute URI that identifies the target system that the concepts will be mapped to.", 0, 1, target);
      case -1639412217:
        /* targetVersion */ return new Property("targetVersion", "string",
            "The specific version of the code system, as determined by the code system authority.", 0, 1,
            targetVersion);
      case -1662836996:
        /* element */ return new Property("element", "",
            "Mappings for an individual concept in the source to one or more concepts in the target.", 0,
            java.lang.Integer.MAX_VALUE, element);
      case -194857460:
        /* unmapped */ return new Property("unmapped", "",
            "What to do when there is no mapping for the source concept. \"Unmapped\" does not include codes that are unmatched, and the unmapped element is ignored in a code is specified to have equivalence = unmatched.",
            0, 1, unmapped);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -896505829:
        /* source */ return this.source == null ? new Base[0] : new Base[] { this.source }; // UriType
      case 446171197:
        /* sourceVersion */ return this.sourceVersion == null ? new Base[0] : new Base[] { this.sourceVersion }; // StringType
      case -880905839:
        /* target */ return this.target == null ? new Base[0] : new Base[] { this.target }; // UriType
      case -1639412217:
        /* targetVersion */ return this.targetVersion == null ? new Base[0] : new Base[] { this.targetVersion }; // StringType
      case -1662836996:
        /* element */ return this.element == null ? new Base[0] : this.element.toArray(new Base[this.element.size()]); // SourceElementComponent
      case -194857460:
        /* unmapped */ return this.unmapped == null ? new Base[0] : new Base[] { this.unmapped }; // ConceptMapGroupUnmappedComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -896505829: // source
        this.source = castToUri(value); // UriType
        return value;
      case 446171197: // sourceVersion
        this.sourceVersion = castToString(value); // StringType
        return value;
      case -880905839: // target
        this.target = castToUri(value); // UriType
        return value;
      case -1639412217: // targetVersion
        this.targetVersion = castToString(value); // StringType
        return value;
      case -1662836996: // element
        this.getElement().add((SourceElementComponent) value); // SourceElementComponent
        return value;
      case -194857460: // unmapped
        this.unmapped = (ConceptMapGroupUnmappedComponent) value; // ConceptMapGroupUnmappedComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("source")) {
        this.source = castToUri(value); // UriType
      } else if (name.equals("sourceVersion")) {
        this.sourceVersion = castToString(value); // StringType
      } else if (name.equals("target")) {
        this.target = castToUri(value); // UriType
      } else if (name.equals("targetVersion")) {
        this.targetVersion = castToString(value); // StringType
      } else if (name.equals("element")) {
        this.getElement().add((SourceElementComponent) value);
      } else if (name.equals("unmapped")) {
        this.unmapped = (ConceptMapGroupUnmappedComponent) value; // ConceptMapGroupUnmappedComponent
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("source")) {
        this.source = null;
      } else if (name.equals("sourceVersion")) {
        this.sourceVersion = null;
      } else if (name.equals("target")) {
        this.target = null;
      } else if (name.equals("targetVersion")) {
        this.targetVersion = null;
      } else if (name.equals("element")) {
        this.getElement().remove((SourceElementComponent) value);
      } else if (name.equals("unmapped")) {
        this.unmapped = (ConceptMapGroupUnmappedComponent) value; // ConceptMapGroupUnmappedComponent
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -896505829:
        return getSourceElement();
      case 446171197:
        return getSourceVersionElement();
      case -880905839:
        return getTargetElement();
      case -1639412217:
        return getTargetVersionElement();
      case -1662836996:
        return addElement();
      case -194857460:
        return getUnmapped();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -896505829:
        /* source */ return new String[] { "uri" };
      case 446171197:
        /* sourceVersion */ return new String[] { "string" };
      case -880905839:
        /* target */ return new String[] { "uri" };
      case -1639412217:
        /* targetVersion */ return new String[] { "string" };
      case -1662836996:
        /* element */ return new String[] {};
      case -194857460:
        /* unmapped */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("source")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.source");
      } else if (name.equals("sourceVersion")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.sourceVersion");
      } else if (name.equals("target")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.target");
      } else if (name.equals("targetVersion")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.targetVersion");
      } else if (name.equals("element")) {
        return addElement();
      } else if (name.equals("unmapped")) {
        this.unmapped = new ConceptMapGroupUnmappedComponent();
        return this.unmapped;
      } else
        return super.addChild(name);
    }

    public ConceptMapGroupComponent copy() {
      ConceptMapGroupComponent dst = new ConceptMapGroupComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(ConceptMapGroupComponent dst) {
      super.copyValues(dst);
      dst.source = source == null ? null : source.copy();
      dst.sourceVersion = sourceVersion == null ? null : sourceVersion.copy();
      dst.target = target == null ? null : target.copy();
      dst.targetVersion = targetVersion == null ? null : targetVersion.copy();
      if (element != null) {
        dst.element = new ArrayList<SourceElementComponent>();
        for (SourceElementComponent i : element)
          dst.element.add(i.copy());
      }
      ;
      dst.unmapped = unmapped == null ? null : unmapped.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof ConceptMapGroupComponent))
        return false;
      ConceptMapGroupComponent o = (ConceptMapGroupComponent) other_;
      return compareDeep(source, o.source, true) && compareDeep(sourceVersion, o.sourceVersion, true)
          && compareDeep(target, o.target, true) && compareDeep(targetVersion, o.targetVersion, true)
          && compareDeep(element, o.element, true) && compareDeep(unmapped, o.unmapped, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof ConceptMapGroupComponent))
        return false;
      ConceptMapGroupComponent o = (ConceptMapGroupComponent) other_;
      return compareValues(source, o.source, true) && compareValues(sourceVersion, o.sourceVersion, true)
          && compareValues(target, o.target, true) && compareValues(targetVersion, o.targetVersion, true);
    }

    public boolean isEmpty() {
      return super.isEmpty()
          && ca.uhn.fhir.util.ElementUtil.isEmpty(source, sourceVersion, target, targetVersion, element, unmapped);
    }

    public String fhirType() {
      return "ConceptMap.group";

    }

  }

  @Block()
  public static class SourceElementComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Identity (code or path) or the element/item being mapped.
     */
    @Child(name = "code", type = { CodeType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Identifies element being mapped", formalDefinition = "Identity (code or path) or the element/item being mapped.")
    protected CodeType code;

    /**
     * The display for the code. The display is only provided to help editors when
     * editing the concept map.
     */
    @Child(name = "display", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Display for the code", formalDefinition = "The display for the code. The display is only provided to help editors when editing the concept map.")
    protected StringType display;

    /**
     * A concept from the target value set that this concept maps to.
     */
    @Child(name = "target", type = {}, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Concept in target system for element", formalDefinition = "A concept from the target value set that this concept maps to.")
    protected List<TargetElementComponent> target;

    private static final long serialVersionUID = -1115258852L;

    /**
     * Constructor
     */
    public SourceElementComponent() {
      super();
    }

    /**
     * @return {@link #code} (Identity (code or path) or the element/item being
     *         mapped.). This is the underlying object with id, value and
     *         extensions. The accessor "getCode" gives direct access to the value
     */
    public CodeType getCodeElement() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SourceElementComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeType(); // bb
      return this.code;
    }

    public boolean hasCodeElement() {
      return this.code != null && !this.code.isEmpty();
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Identity (code or path) or the element/item being
     *              mapped.). This is the underlying object with id, value and
     *              extensions. The accessor "getCode" gives direct access to the
     *              value
     */
    public SourceElementComponent setCodeElement(CodeType value) {
      this.code = value;
      return this;
    }

    /**
     * @return Identity (code or path) or the element/item being mapped.
     */
    public String getCode() {
      return this.code == null ? null : this.code.getValue();
    }

    /**
     * @param value Identity (code or path) or the element/item being mapped.
     */
    public SourceElementComponent setCode(String value) {
      if (Utilities.noString(value))
        this.code = null;
      else {
        if (this.code == null)
          this.code = new CodeType();
        this.code.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #display} (The display for the code. The display is only
     *         provided to help editors when editing the concept map.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getDisplay" gives direct access to the value
     */
    public StringType getDisplayElement() {
      if (this.display == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SourceElementComponent.display");
        else if (Configuration.doAutoCreate())
          this.display = new StringType(); // bb
      return this.display;
    }

    public boolean hasDisplayElement() {
      return this.display != null && !this.display.isEmpty();
    }

    public boolean hasDisplay() {
      return this.display != null && !this.display.isEmpty();
    }

    /**
     * @param value {@link #display} (The display for the code. The display is only
     *              provided to help editors when editing the concept map.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getDisplay" gives direct access to the value
     */
    public SourceElementComponent setDisplayElement(StringType value) {
      this.display = value;
      return this;
    }

    /**
     * @return The display for the code. The display is only provided to help
     *         editors when editing the concept map.
     */
    public String getDisplay() {
      return this.display == null ? null : this.display.getValue();
    }

    /**
     * @param value The display for the code. The display is only provided to help
     *              editors when editing the concept map.
     */
    public SourceElementComponent setDisplay(String value) {
      if (Utilities.noString(value))
        this.display = null;
      else {
        if (this.display == null)
          this.display = new StringType();
        this.display.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #target} (A concept from the target value set that this
     *         concept maps to.)
     */
    public List<TargetElementComponent> getTarget() {
      if (this.target == null)
        this.target = new ArrayList<TargetElementComponent>();
      return this.target;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SourceElementComponent setTarget(List<TargetElementComponent> theTarget) {
      this.target = theTarget;
      return this;
    }

    public boolean hasTarget() {
      if (this.target == null)
        return false;
      for (TargetElementComponent item : this.target)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TargetElementComponent addTarget() { // 3
      TargetElementComponent t = new TargetElementComponent();
      if (this.target == null)
        this.target = new ArrayList<TargetElementComponent>();
      this.target.add(t);
      return t;
    }

    public SourceElementComponent addTarget(TargetElementComponent t) { // 3
      if (t == null)
        return this;
      if (this.target == null)
        this.target = new ArrayList<TargetElementComponent>();
      this.target.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #target}, creating it
     *         if it does not already exist
     */
    public TargetElementComponent getTargetFirstRep() {
      if (getTarget().isEmpty()) {
        addTarget();
      }
      return getTarget().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children
          .add(new Property("code", "code", "Identity (code or path) or the element/item being mapped.", 0, 1, code));
      children.add(new Property("display", "string",
          "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1,
          display));
      children.add(new Property("target", "", "A concept from the target value set that this concept maps to.", 0,
          java.lang.Integer.MAX_VALUE, target));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "code", "Identity (code or path) or the element/item being mapped.", 0,
            1, code);
      case 1671764162:
        /* display */ return new Property("display", "string",
            "The display for the code. The display is only provided to help editors when editing the concept map.", 0,
            1, display);
      case -880905839:
        /* target */ return new Property("target", "", "A concept from the target value set that this concept maps to.",
            0, java.lang.Integer.MAX_VALUE, target);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeType
      case 1671764162:
        /* display */ return this.display == null ? new Base[0] : new Base[] { this.display }; // StringType
      case -880905839:
        /* target */ return this.target == null ? new Base[0] : this.target.toArray(new Base[this.target.size()]); // TargetElementComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = castToCode(value); // CodeType
        return value;
      case 1671764162: // display
        this.display = castToString(value); // StringType
        return value;
      case -880905839: // target
        this.getTarget().add((TargetElementComponent) value); // TargetElementComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = castToCode(value); // CodeType
      } else if (name.equals("display")) {
        this.display = castToString(value); // StringType
      } else if (name.equals("target")) {
        this.getTarget().add((TargetElementComponent) value);
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("display")) {
        this.display = null;
      } else if (name.equals("target")) {
        this.getTarget().remove((TargetElementComponent) value);
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCodeElement();
      case 1671764162:
        return getDisplayElement();
      case -880905839:
        return addTarget();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "code" };
      case 1671764162:
        /* display */ return new String[] { "string" };
      case -880905839:
        /* target */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.code");
      } else if (name.equals("display")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.display");
      } else if (name.equals("target")) {
        return addTarget();
      } else
        return super.addChild(name);
    }

    public SourceElementComponent copy() {
      SourceElementComponent dst = new SourceElementComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(SourceElementComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.display = display == null ? null : display.copy();
      if (target != null) {
        dst.target = new ArrayList<TargetElementComponent>();
        for (TargetElementComponent i : target)
          dst.target.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof SourceElementComponent))
        return false;
      SourceElementComponent o = (SourceElementComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(display, o.display, true)
          && compareDeep(target, o.target, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof SourceElementComponent))
        return false;
      SourceElementComponent o = (SourceElementComponent) other_;
      return compareValues(code, o.code, true) && compareValues(display, o.display, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, display, target);
    }

    public String fhirType() {
      return "ConceptMap.group.element";

    }

  }

  @Block()
  public static class TargetElementComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Identity (code or path) or the element/item that the map refers to.
     */
    @Child(name = "code", type = { CodeType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Code that identifies the target element", formalDefinition = "Identity (code or path) or the element/item that the map refers to.")
    protected CodeType code;

    /**
     * The display for the code. The display is only provided to help editors when
     * editing the concept map.
     */
    @Child(name = "display", type = {
        StringType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Display for the code", formalDefinition = "The display for the code. The display is only provided to help editors when editing the concept map.")
    protected StringType display;

    /**
     * The equivalence between the source and target concepts (counting for the
     * dependencies and products). The equivalence is read from target to source
     * (e.g. the target is 'wider' than the source).
     */
    @Child(name = "equivalence", type = {
        CodeType.class }, order = 3, min = 1, max = 1, modifier = true, summary = false)
    @Description(shortDefinition = "relatedto | equivalent | equal | wider | subsumes | narrower | specializes | inexact | unmatched | disjoint", formalDefinition = "The equivalence between the source and target concepts (counting for the dependencies and products). The equivalence is read from target to source (e.g. the target is 'wider' than the source).")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/concept-map-equivalence")
    protected Enumeration<ConceptMapEquivalence> equivalence;

    /**
     * A description of status/issues in mapping that conveys additional information
     * not represented in the structured data.
     */
    @Child(name = "comment", type = {
        StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Description of status/issues in mapping", formalDefinition = "A description of status/issues in mapping that conveys additional information not represented in  the structured data.")
    protected StringType comment;

    /**
     * A set of additional dependencies for this mapping to hold. This mapping is
     * only applicable if the specified element can be resolved, and it has the
     * specified value.
     */
    @Child(name = "dependsOn", type = {}, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Other elements required for this mapping (from context)", formalDefinition = "A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified element can be resolved, and it has the specified value.")
    protected List<OtherElementComponent> dependsOn;

    /**
     * A set of additional outcomes from this mapping to other elements. To properly
     * execute this mapping, the specified element must be mapped to some data
     * element or source that is in context. The mapping may still be useful without
     * a place for the additional data elements, but the equivalence cannot be
     * relied on.
     */
    @Child(name = "product", type = {
        OtherElementComponent.class }, order = 6, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Other concepts that this mapping also produces", formalDefinition = "A set of additional outcomes from this mapping to other elements. To properly execute this mapping, the specified element must be mapped to some data element or source that is in context. The mapping may still be useful without a place for the additional data elements, but the equivalence cannot be relied on.")
    protected List<OtherElementComponent> product;

    private static final long serialVersionUID = -2008997477L;

    /**
     * Constructor
     */
    public TargetElementComponent() {
      super();
    }

    /**
     * Constructor
     */
    public TargetElementComponent(Enumeration<ConceptMapEquivalence> equivalence) {
      super();
      this.equivalence = equivalence;
    }

    /**
     * @return {@link #code} (Identity (code or path) or the element/item that the
     *         map refers to.). This is the underlying object with id, value and
     *         extensions. The accessor "getCode" gives direct access to the value
     */
    public CodeType getCodeElement() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TargetElementComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeType(); // bb
      return this.code;
    }

    public boolean hasCodeElement() {
      return this.code != null && !this.code.isEmpty();
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Identity (code or path) or the element/item that
     *              the map refers to.). This is the underlying object with id,
     *              value and extensions. The accessor "getCode" gives direct access
     *              to the value
     */
    public TargetElementComponent setCodeElement(CodeType value) {
      this.code = value;
      return this;
    }

    /**
     * @return Identity (code or path) or the element/item that the map refers to.
     */
    public String getCode() {
      return this.code == null ? null : this.code.getValue();
    }

    /**
     * @param value Identity (code or path) or the element/item that the map refers
     *              to.
     */
    public TargetElementComponent setCode(String value) {
      if (Utilities.noString(value))
        this.code = null;
      else {
        if (this.code == null)
          this.code = new CodeType();
        this.code.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #display} (The display for the code. The display is only
     *         provided to help editors when editing the concept map.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getDisplay" gives direct access to the value
     */
    public StringType getDisplayElement() {
      if (this.display == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TargetElementComponent.display");
        else if (Configuration.doAutoCreate())
          this.display = new StringType(); // bb
      return this.display;
    }

    public boolean hasDisplayElement() {
      return this.display != null && !this.display.isEmpty();
    }

    public boolean hasDisplay() {
      return this.display != null && !this.display.isEmpty();
    }

    /**
     * @param value {@link #display} (The display for the code. The display is only
     *              provided to help editors when editing the concept map.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getDisplay" gives direct access to the value
     */
    public TargetElementComponent setDisplayElement(StringType value) {
      this.display = value;
      return this;
    }

    /**
     * @return The display for the code. The display is only provided to help
     *         editors when editing the concept map.
     */
    public String getDisplay() {
      return this.display == null ? null : this.display.getValue();
    }

    /**
     * @param value The display for the code. The display is only provided to help
     *              editors when editing the concept map.
     */
    public TargetElementComponent setDisplay(String value) {
      if (Utilities.noString(value))
        this.display = null;
      else {
        if (this.display == null)
          this.display = new StringType();
        this.display.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #equivalence} (The equivalence between the source and target
     *         concepts (counting for the dependencies and products). The
     *         equivalence is read from target to source (e.g. the target is 'wider'
     *         than the source).). This is the underlying object with id, value and
     *         extensions. The accessor "getEquivalence" gives direct access to the
     *         value
     */
    public Enumeration<ConceptMapEquivalence> getEquivalenceElement() {
      if (this.equivalence == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TargetElementComponent.equivalence");
        else if (Configuration.doAutoCreate())
          this.equivalence = new Enumeration<ConceptMapEquivalence>(new ConceptMapEquivalenceEnumFactory()); // bb
      return this.equivalence;
    }

    public boolean hasEquivalenceElement() {
      return this.equivalence != null && !this.equivalence.isEmpty();
    }

    public boolean hasEquivalence() {
      return this.equivalence != null && !this.equivalence.isEmpty();
    }

    /**
     * @param value {@link #equivalence} (The equivalence between the source and
     *              target concepts (counting for the dependencies and products).
     *              The equivalence is read from target to source (e.g. the target
     *              is 'wider' than the source).). This is the underlying object
     *              with id, value and extensions. The accessor "getEquivalence"
     *              gives direct access to the value
     */
    public TargetElementComponent setEquivalenceElement(Enumeration<ConceptMapEquivalence> value) {
      this.equivalence = value;
      return this;
    }

    /**
     * @return The equivalence between the source and target concepts (counting for
     *         the dependencies and products). The equivalence is read from target
     *         to source (e.g. the target is 'wider' than the source).
     */
    public ConceptMapEquivalence getEquivalence() {
      return this.equivalence == null ? null : this.equivalence.getValue();
    }

    /**
     * @param value The equivalence between the source and target concepts (counting
     *              for the dependencies and products). The equivalence is read from
     *              target to source (e.g. the target is 'wider' than the source).
     */
    public TargetElementComponent setEquivalence(ConceptMapEquivalence value) {
      if (this.equivalence == null)
        this.equivalence = new Enumeration<ConceptMapEquivalence>(new ConceptMapEquivalenceEnumFactory());
      this.equivalence.setValue(value);
      return this;
    }

    /**
     * @return {@link #comment} (A description of status/issues in mapping that
     *         conveys additional information not represented in the structured
     *         data.). This is the underlying object with id, value and extensions.
     *         The accessor "getComment" gives direct access to the value
     */
    public StringType getCommentElement() {
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TargetElementComponent.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new StringType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() {
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() {
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (A description of status/issues in mapping that
     *              conveys additional information not represented in the structured
     *              data.). This is the underlying object with id, value and
     *              extensions. The accessor "getComment" gives direct access to the
     *              value
     */
    public TargetElementComponent setCommentElement(StringType value) {
      this.comment = value;
      return this;
    }

    /**
     * @return A description of status/issues in mapping that conveys additional
     *         information not represented in the structured data.
     */
    public String getComment() {
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value A description of status/issues in mapping that conveys
     *              additional information not represented in the structured data.
     */
    public TargetElementComponent setComment(String value) {
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new StringType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #dependsOn} (A set of additional dependencies for this mapping
     *         to hold. This mapping is only applicable if the specified element can
     *         be resolved, and it has the specified value.)
     */
    public List<OtherElementComponent> getDependsOn() {
      if (this.dependsOn == null)
        this.dependsOn = new ArrayList<OtherElementComponent>();
      return this.dependsOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TargetElementComponent setDependsOn(List<OtherElementComponent> theDependsOn) {
      this.dependsOn = theDependsOn;
      return this;
    }

    public boolean hasDependsOn() {
      if (this.dependsOn == null)
        return false;
      for (OtherElementComponent item : this.dependsOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OtherElementComponent addDependsOn() { // 3
      OtherElementComponent t = new OtherElementComponent();
      if (this.dependsOn == null)
        this.dependsOn = new ArrayList<OtherElementComponent>();
      this.dependsOn.add(t);
      return t;
    }

    public TargetElementComponent addDependsOn(OtherElementComponent t) { // 3
      if (t == null)
        return this;
      if (this.dependsOn == null)
        this.dependsOn = new ArrayList<OtherElementComponent>();
      this.dependsOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dependsOn}, creating
     *         it if it does not already exist
     */
    public OtherElementComponent getDependsOnFirstRep() {
      if (getDependsOn().isEmpty()) {
        addDependsOn();
      }
      return getDependsOn().get(0);
    }

    /**
     * @return {@link #product} (A set of additional outcomes from this mapping to
     *         other elements. To properly execute this mapping, the specified
     *         element must be mapped to some data element or source that is in
     *         context. The mapping may still be useful without a place for the
     *         additional data elements, but the equivalence cannot be relied on.)
     */
    public List<OtherElementComponent> getProduct() {
      if (this.product == null)
        this.product = new ArrayList<OtherElementComponent>();
      return this.product;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TargetElementComponent setProduct(List<OtherElementComponent> theProduct) {
      this.product = theProduct;
      return this;
    }

    public boolean hasProduct() {
      if (this.product == null)
        return false;
      for (OtherElementComponent item : this.product)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OtherElementComponent addProduct() { // 3
      OtherElementComponent t = new OtherElementComponent();
      if (this.product == null)
        this.product = new ArrayList<OtherElementComponent>();
      this.product.add(t);
      return t;
    }

    public TargetElementComponent addProduct(OtherElementComponent t) { // 3
      if (t == null)
        return this;
      if (this.product == null)
        this.product = new ArrayList<OtherElementComponent>();
      this.product.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #product}, creating it
     *         if it does not already exist
     */
    public OtherElementComponent getProductFirstRep() {
      if (getProduct().isEmpty()) {
        addProduct();
      }
      return getProduct().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "code", "Identity (code or path) or the element/item that the map refers to.",
          0, 1, code));
      children.add(new Property("display", "string",
          "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1,
          display));
      children.add(new Property("equivalence", "code",
          "The equivalence between the source and target concepts (counting for the dependencies and products). The equivalence is read from target to source (e.g. the target is 'wider' than the source).",
          0, 1, equivalence));
      children.add(new Property("comment", "string",
          "A description of status/issues in mapping that conveys additional information not represented in  the structured data.",
          0, 1, comment));
      children.add(new Property("dependsOn", "",
          "A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified element can be resolved, and it has the specified value.",
          0, java.lang.Integer.MAX_VALUE, dependsOn));
      children.add(new Property("product", "@ConceptMap.group.element.target.dependsOn",
          "A set of additional outcomes from this mapping to other elements. To properly execute this mapping, the specified element must be mapped to some data element or source that is in context. The mapping may still be useful without a place for the additional data elements, but the equivalence cannot be relied on.",
          0, java.lang.Integer.MAX_VALUE, product));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "code",
            "Identity (code or path) or the element/item that the map refers to.", 0, 1, code);
      case 1671764162:
        /* display */ return new Property("display", "string",
            "The display for the code. The display is only provided to help editors when editing the concept map.", 0,
            1, display);
      case -15828692:
        /* equivalence */ return new Property("equivalence", "code",
            "The equivalence between the source and target concepts (counting for the dependencies and products). The equivalence is read from target to source (e.g. the target is 'wider' than the source).",
            0, 1, equivalence);
      case 950398559:
        /* comment */ return new Property("comment", "string",
            "A description of status/issues in mapping that conveys additional information not represented in  the structured data.",
            0, 1, comment);
      case -1109214266:
        /* dependsOn */ return new Property("dependsOn", "",
            "A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified element can be resolved, and it has the specified value.",
            0, java.lang.Integer.MAX_VALUE, dependsOn);
      case -309474065:
        /* product */ return new Property("product", "@ConceptMap.group.element.target.dependsOn",
            "A set of additional outcomes from this mapping to other elements. To properly execute this mapping, the specified element must be mapped to some data element or source that is in context. The mapping may still be useful without a place for the additional data elements, but the equivalence cannot be relied on.",
            0, java.lang.Integer.MAX_VALUE, product);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeType
      case 1671764162:
        /* display */ return this.display == null ? new Base[0] : new Base[] { this.display }; // StringType
      case -15828692:
        /* equivalence */ return this.equivalence == null ? new Base[0] : new Base[] { this.equivalence }; // Enumeration<ConceptMapEquivalence>
      case 950398559:
        /* comment */ return this.comment == null ? new Base[0] : new Base[] { this.comment }; // StringType
      case -1109214266:
        /* dependsOn */ return this.dependsOn == null ? new Base[0]
            : this.dependsOn.toArray(new Base[this.dependsOn.size()]); // OtherElementComponent
      case -309474065:
        /* product */ return this.product == null ? new Base[0] : this.product.toArray(new Base[this.product.size()]); // OtherElementComponent
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3059181: // code
        this.code = castToCode(value); // CodeType
        return value;
      case 1671764162: // display
        this.display = castToString(value); // StringType
        return value;
      case -15828692: // equivalence
        value = new ConceptMapEquivalenceEnumFactory().fromType(castToCode(value));
        this.equivalence = (Enumeration) value; // Enumeration<ConceptMapEquivalence>
        return value;
      case 950398559: // comment
        this.comment = castToString(value); // StringType
        return value;
      case -1109214266: // dependsOn
        this.getDependsOn().add((OtherElementComponent) value); // OtherElementComponent
        return value;
      case -309474065: // product
        this.getProduct().add((OtherElementComponent) value); // OtherElementComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = castToCode(value); // CodeType
      } else if (name.equals("display")) {
        this.display = castToString(value); // StringType
      } else if (name.equals("equivalence")) {
        value = new ConceptMapEquivalenceEnumFactory().fromType(castToCode(value));
        this.equivalence = (Enumeration) value; // Enumeration<ConceptMapEquivalence>
      } else if (name.equals("comment")) {
        this.comment = castToString(value); // StringType
      } else if (name.equals("dependsOn")) {
        this.getDependsOn().add((OtherElementComponent) value);
      } else if (name.equals("product")) {
        this.getProduct().add((OtherElementComponent) value);
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("display")) {
        this.display = null;
      } else if (name.equals("equivalence")) {
        this.equivalence = null;
      } else if (name.equals("comment")) {
        this.comment = null;
      } else if (name.equals("dependsOn")) {
        this.getDependsOn().remove((OtherElementComponent) value);
      } else if (name.equals("product")) {
        this.getProduct().remove((OtherElementComponent) value);
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCodeElement();
      case 1671764162:
        return getDisplayElement();
      case -15828692:
        return getEquivalenceElement();
      case 950398559:
        return getCommentElement();
      case -1109214266:
        return addDependsOn();
      case -309474065:
        return addProduct();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "code" };
      case 1671764162:
        /* display */ return new String[] { "string" };
      case -15828692:
        /* equivalence */ return new String[] { "code" };
      case 950398559:
        /* comment */ return new String[] { "string" };
      case -1109214266:
        /* dependsOn */ return new String[] {};
      case -309474065:
        /* product */ return new String[] { "@ConceptMap.group.element.target.dependsOn" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.code");
      } else if (name.equals("display")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.display");
      } else if (name.equals("equivalence")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.equivalence");
      } else if (name.equals("comment")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.comment");
      } else if (name.equals("dependsOn")) {
        return addDependsOn();
      } else if (name.equals("product")) {
        return addProduct();
      } else
        return super.addChild(name);
    }

    public TargetElementComponent copy() {
      TargetElementComponent dst = new TargetElementComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(TargetElementComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.display = display == null ? null : display.copy();
      dst.equivalence = equivalence == null ? null : equivalence.copy();
      dst.comment = comment == null ? null : comment.copy();
      if (dependsOn != null) {
        dst.dependsOn = new ArrayList<OtherElementComponent>();
        for (OtherElementComponent i : dependsOn)
          dst.dependsOn.add(i.copy());
      }
      ;
      if (product != null) {
        dst.product = new ArrayList<OtherElementComponent>();
        for (OtherElementComponent i : product)
          dst.product.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof TargetElementComponent))
        return false;
      TargetElementComponent o = (TargetElementComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(display, o.display, true)
          && compareDeep(equivalence, o.equivalence, true) && compareDeep(comment, o.comment, true)
          && compareDeep(dependsOn, o.dependsOn, true) && compareDeep(product, o.product, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof TargetElementComponent))
        return false;
      TargetElementComponent o = (TargetElementComponent) other_;
      return compareValues(code, o.code, true) && compareValues(display, o.display, true)
          && compareValues(equivalence, o.equivalence, true) && compareValues(comment, o.comment, true);
    }

    public boolean isEmpty() {
      return super.isEmpty()
          && ca.uhn.fhir.util.ElementUtil.isEmpty(code, display, equivalence, comment, dependsOn, product);
    }

    public String fhirType() {
      return "ConceptMap.group.element.target";

    }

  }

  @Block()
  public static class OtherElementComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * A reference to an element that holds a coded value that corresponds to a code
     * system property. The idea is that the information model carries an element
     * somewhere that is labeled to correspond with a code system property.
     */
    @Child(name = "property", type = { UriType.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Reference to property mapping depends on", formalDefinition = "A reference to an element that holds a coded value that corresponds to a code system property. The idea is that the information model carries an element somewhere that is labeled to correspond with a code system property.")
    protected UriType property;

    /**
     * An absolute URI that identifies the code system of the dependency code (if
     * the source/dependency is a value set that crosses code systems).
     */
    @Child(name = "system", type = {
        CanonicalType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Code System (if necessary)", formalDefinition = "An absolute URI that identifies the code system of the dependency code (if the source/dependency is a value set that crosses code systems).")
    protected CanonicalType system;

    /**
     * Identity (code or path) or the element/item/ValueSet/text that the map
     * depends on / refers to.
     */
    @Child(name = "value", type = { StringType.class }, order = 3, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Value of the referenced element", formalDefinition = "Identity (code or path) or the element/item/ValueSet/text that the map depends on / refers to.")
    protected StringType value;

    /**
     * The display for the code. The display is only provided to help editors when
     * editing the concept map.
     */
    @Child(name = "display", type = {
        StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Display for the code (if value is a code)", formalDefinition = "The display for the code. The display is only provided to help editors when editing the concept map.")
    protected StringType display;

    private static final long serialVersionUID = -1836341923L;

    /**
     * Constructor
     */
    public OtherElementComponent() {
      super();
    }

    /**
     * Constructor
     */
    public OtherElementComponent(UriType property, StringType value) {
      super();
      this.property = property;
      this.value = value;
    }

    /**
     * @return {@link #property} (A reference to an element that holds a coded value
     *         that corresponds to a code system property. The idea is that the
     *         information model carries an element somewhere that is labeled to
     *         correspond with a code system property.). This is the underlying
     *         object with id, value and extensions. The accessor "getProperty"
     *         gives direct access to the value
     */
    public UriType getPropertyElement() {
      if (this.property == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OtherElementComponent.property");
        else if (Configuration.doAutoCreate())
          this.property = new UriType(); // bb
      return this.property;
    }

    public boolean hasPropertyElement() {
      return this.property != null && !this.property.isEmpty();
    }

    public boolean hasProperty() {
      return this.property != null && !this.property.isEmpty();
    }

    /**
     * @param value {@link #property} (A reference to an element that holds a coded
     *              value that corresponds to a code system property. The idea is
     *              that the information model carries an element somewhere that is
     *              labeled to correspond with a code system property.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getProperty" gives direct access to the value
     */
    public OtherElementComponent setPropertyElement(UriType value) {
      this.property = value;
      return this;
    }

    /**
     * @return A reference to an element that holds a coded value that corresponds
     *         to a code system property. The idea is that the information model
     *         carries an element somewhere that is labeled to correspond with a
     *         code system property.
     */
    public String getProperty() {
      return this.property == null ? null : this.property.getValue();
    }

    /**
     * @param value A reference to an element that holds a coded value that
     *              corresponds to a code system property. The idea is that the
     *              information model carries an element somewhere that is labeled
     *              to correspond with a code system property.
     */
    public OtherElementComponent setProperty(String value) {
      if (this.property == null)
        this.property = new UriType();
      this.property.setValue(value);
      return this;
    }

    /**
     * @return {@link #system} (An absolute URI that identifies the code system of
     *         the dependency code (if the source/dependency is a value set that
     *         crosses code systems).). This is the underlying object with id, value
     *         and extensions. The accessor "getSystem" gives direct access to the
     *         value
     */
    public CanonicalType getSystemElement() {
      if (this.system == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OtherElementComponent.system");
        else if (Configuration.doAutoCreate())
          this.system = new CanonicalType(); // bb
      return this.system;
    }

    public boolean hasSystemElement() {
      return this.system != null && !this.system.isEmpty();
    }

    public boolean hasSystem() {
      return this.system != null && !this.system.isEmpty();
    }

    /**
     * @param value {@link #system} (An absolute URI that identifies the code system
     *              of the dependency code (if the source/dependency is a value set
     *              that crosses code systems).). This is the underlying object with
     *              id, value and extensions. The accessor "getSystem" gives direct
     *              access to the value
     */
    public OtherElementComponent setSystemElement(CanonicalType value) {
      this.system = value;
      return this;
    }

    /**
     * @return An absolute URI that identifies the code system of the dependency
     *         code (if the source/dependency is a value set that crosses code
     *         systems).
     */
    public String getSystem() {
      return this.system == null ? null : this.system.getValue();
    }

    /**
     * @param value An absolute URI that identifies the code system of the
     *              dependency code (if the source/dependency is a value set that
     *              crosses code systems).
     */
    public OtherElementComponent setSystem(String value) {
      if (Utilities.noString(value))
        this.system = null;
      else {
        if (this.system == null)
          this.system = new CanonicalType();
        this.system.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #value} (Identity (code or path) or the
     *         element/item/ValueSet/text that the map depends on / refers to.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getValue" gives direct access to the value
     */
    public StringType getValueElement() {
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OtherElementComponent.value");
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
     * @param value {@link #value} (Identity (code or path) or the
     *              element/item/ValueSet/text that the map depends on / refers
     *              to.). This is the underlying object with id, value and
     *              extensions. The accessor "getValue" gives direct access to the
     *              value
     */
    public OtherElementComponent setValueElement(StringType value) {
      this.value = value;
      return this;
    }

    /**
     * @return Identity (code or path) or the element/item/ValueSet/text that the
     *         map depends on / refers to.
     */
    public String getValue() {
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value Identity (code or path) or the element/item/ValueSet/text that
     *              the map depends on / refers to.
     */
    public OtherElementComponent setValue(String value) {
      if (this.value == null)
        this.value = new StringType();
      this.value.setValue(value);
      return this;
    }

    /**
     * @return {@link #display} (The display for the code. The display is only
     *         provided to help editors when editing the concept map.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getDisplay" gives direct access to the value
     */
    public StringType getDisplayElement() {
      if (this.display == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OtherElementComponent.display");
        else if (Configuration.doAutoCreate())
          this.display = new StringType(); // bb
      return this.display;
    }

    public boolean hasDisplayElement() {
      return this.display != null && !this.display.isEmpty();
    }

    public boolean hasDisplay() {
      return this.display != null && !this.display.isEmpty();
    }

    /**
     * @param value {@link #display} (The display for the code. The display is only
     *              provided to help editors when editing the concept map.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getDisplay" gives direct access to the value
     */
    public OtherElementComponent setDisplayElement(StringType value) {
      this.display = value;
      return this;
    }

    /**
     * @return The display for the code. The display is only provided to help
     *         editors when editing the concept map.
     */
    public String getDisplay() {
      return this.display == null ? null : this.display.getValue();
    }

    /**
     * @param value The display for the code. The display is only provided to help
     *              editors when editing the concept map.
     */
    public OtherElementComponent setDisplay(String value) {
      if (Utilities.noString(value))
        this.display = null;
      else {
        if (this.display == null)
          this.display = new StringType();
        this.display.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("property", "uri",
          "A reference to an element that holds a coded value that corresponds to a code system property. The idea is that the information model carries an element somewhere that is labeled to correspond with a code system property.",
          0, 1, property));
      children.add(new Property("system", "canonical(CodeSystem)",
          "An absolute URI that identifies the code system of the dependency code (if the source/dependency is a value set that crosses code systems).",
          0, 1, system));
      children.add(new Property("value", "string",
          "Identity (code or path) or the element/item/ValueSet/text that the map depends on / refers to.", 0, 1,
          value));
      children.add(new Property("display", "string",
          "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1,
          display));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -993141291:
        /* property */ return new Property("property", "uri",
            "A reference to an element that holds a coded value that corresponds to a code system property. The idea is that the information model carries an element somewhere that is labeled to correspond with a code system property.",
            0, 1, property);
      case -887328209:
        /* system */ return new Property("system", "canonical(CodeSystem)",
            "An absolute URI that identifies the code system of the dependency code (if the source/dependency is a value set that crosses code systems).",
            0, 1, system);
      case 111972721:
        /* value */ return new Property("value", "string",
            "Identity (code or path) or the element/item/ValueSet/text that the map depends on / refers to.", 0, 1,
            value);
      case 1671764162:
        /* display */ return new Property("display", "string",
            "The display for the code. The display is only provided to help editors when editing the concept map.", 0,
            1, display);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -993141291:
        /* property */ return this.property == null ? new Base[0] : new Base[] { this.property }; // UriType
      case -887328209:
        /* system */ return this.system == null ? new Base[0] : new Base[] { this.system }; // CanonicalType
      case 111972721:
        /* value */ return this.value == null ? new Base[0] : new Base[] { this.value }; // StringType
      case 1671764162:
        /* display */ return this.display == null ? new Base[0] : new Base[] { this.display }; // StringType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -993141291: // property
        this.property = castToUri(value); // UriType
        return value;
      case -887328209: // system
        this.system = castToCanonical(value); // CanonicalType
        return value;
      case 111972721: // value
        this.value = castToString(value); // StringType
        return value;
      case 1671764162: // display
        this.display = castToString(value); // StringType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("property")) {
        this.property = castToUri(value); // UriType
      } else if (name.equals("system")) {
        this.system = castToCanonical(value); // CanonicalType
      } else if (name.equals("value")) {
        this.value = castToString(value); // StringType
      } else if (name.equals("display")) {
        this.display = castToString(value); // StringType
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("property")) {
        this.property = null;
      } else if (name.equals("system")) {
        this.system = null;
      } else if (name.equals("value")) {
        this.value = null;
      } else if (name.equals("display")) {
        this.display = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -993141291:
        return getPropertyElement();
      case -887328209:
        return getSystemElement();
      case 111972721:
        return getValueElement();
      case 1671764162:
        return getDisplayElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -993141291:
        /* property */ return new String[] { "uri" };
      case -887328209:
        /* system */ return new String[] { "canonical" };
      case 111972721:
        /* value */ return new String[] { "string" };
      case 1671764162:
        /* display */ return new String[] { "string" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("property")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.property");
      } else if (name.equals("system")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.system");
      } else if (name.equals("value")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.value");
      } else if (name.equals("display")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.display");
      } else
        return super.addChild(name);
    }

    public OtherElementComponent copy() {
      OtherElementComponent dst = new OtherElementComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(OtherElementComponent dst) {
      super.copyValues(dst);
      dst.property = property == null ? null : property.copy();
      dst.system = system == null ? null : system.copy();
      dst.value = value == null ? null : value.copy();
      dst.display = display == null ? null : display.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof OtherElementComponent))
        return false;
      OtherElementComponent o = (OtherElementComponent) other_;
      return compareDeep(property, o.property, true) && compareDeep(system, o.system, true)
          && compareDeep(value, o.value, true) && compareDeep(display, o.display, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof OtherElementComponent))
        return false;
      OtherElementComponent o = (OtherElementComponent) other_;
      return compareValues(property, o.property, true) && compareValues(value, o.value, true)
          && compareValues(display, o.display, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(property, system, value, display);
    }

    public String fhirType() {
      return "ConceptMap.group.element.target.dependsOn";

    }

  }

  @Block()
  public static class ConceptMapGroupUnmappedComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Defines which action to take if there is no match for the source concept in
     * the target system designated for the group. One of 3 actions are possible:
     * use the unmapped code (this is useful when doing a mapping between versions,
     * and only a few codes have changed), use a fixed code (a default code), or
     * alternatively, a reference to a different concept map can be provided (by
     * canonical URL).
     */
    @Child(name = "mode", type = { CodeType.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "provided | fixed | other-map", formalDefinition = "Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/conceptmap-unmapped-mode")
    protected Enumeration<ConceptMapGroupUnmappedMode> mode;

    /**
     * The fixed code to use when the mode = 'fixed' - all unmapped codes are mapped
     * to a single fixed code.
     */
    @Child(name = "code", type = { CodeType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Fixed code when mode = fixed", formalDefinition = "The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.")
    protected CodeType code;

    /**
     * The display for the code. The display is only provided to help editors when
     * editing the concept map.
     */
    @Child(name = "display", type = {
        StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Display for the code", formalDefinition = "The display for the code. The display is only provided to help editors when editing the concept map.")
    protected StringType display;

    /**
     * The canonical reference to an additional ConceptMap resource instance to use
     * for mapping if this ConceptMap resource contains no matching mapping for the
     * source concept.
     */
    @Child(name = "url", type = { CanonicalType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "canonical reference to an additional ConceptMap to use for mapping if the source concept is unmapped", formalDefinition = "The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.")
    protected CanonicalType url;

    private static final long serialVersionUID = 1261364354L;

    /**
     * Constructor
     */
    public ConceptMapGroupUnmappedComponent() {
      super();
    }

    /**
     * Constructor
     */
    public ConceptMapGroupUnmappedComponent(Enumeration<ConceptMapGroupUnmappedMode> mode) {
      super();
      this.mode = mode;
    }

    /**
     * @return {@link #mode} (Defines which action to take if there is no match for
     *         the source concept in the target system designated for the group. One
     *         of 3 actions are possible: use the unmapped code (this is useful when
     *         doing a mapping between versions, and only a few codes have changed),
     *         use a fixed code (a default code), or alternatively, a reference to a
     *         different concept map can be provided (by canonical URL).). This is
     *         the underlying object with id, value and extensions. The accessor
     *         "getMode" gives direct access to the value
     */
    public Enumeration<ConceptMapGroupUnmappedMode> getModeElement() {
      if (this.mode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.mode");
        else if (Configuration.doAutoCreate())
          this.mode = new Enumeration<ConceptMapGroupUnmappedMode>(new ConceptMapGroupUnmappedModeEnumFactory()); // bb
      return this.mode;
    }

    public boolean hasModeElement() {
      return this.mode != null && !this.mode.isEmpty();
    }

    public boolean hasMode() {
      return this.mode != null && !this.mode.isEmpty();
    }

    /**
     * @param value {@link #mode} (Defines which action to take if there is no match
     *              for the source concept in the target system designated for the
     *              group. One of 3 actions are possible: use the unmapped code
     *              (this is useful when doing a mapping between versions, and only
     *              a few codes have changed), use a fixed code (a default code), or
     *              alternatively, a reference to a different concept map can be
     *              provided (by canonical URL).). This is the underlying object
     *              with id, value and extensions. The accessor "getMode" gives
     *              direct access to the value
     */
    public ConceptMapGroupUnmappedComponent setModeElement(Enumeration<ConceptMapGroupUnmappedMode> value) {
      this.mode = value;
      return this;
    }

    /**
     * @return Defines which action to take if there is no match for the source
     *         concept in the target system designated for the group. One of 3
     *         actions are possible: use the unmapped code (this is useful when
     *         doing a mapping between versions, and only a few codes have changed),
     *         use a fixed code (a default code), or alternatively, a reference to a
     *         different concept map can be provided (by canonical URL).
     */
    public ConceptMapGroupUnmappedMode getMode() {
      return this.mode == null ? null : this.mode.getValue();
    }

    /**
     * @param value Defines which action to take if there is no match for the source
     *              concept in the target system designated for the group. One of 3
     *              actions are possible: use the unmapped code (this is useful when
     *              doing a mapping between versions, and only a few codes have
     *              changed), use a fixed code (a default code), or alternatively, a
     *              reference to a different concept map can be provided (by
     *              canonical URL).
     */
    public ConceptMapGroupUnmappedComponent setMode(ConceptMapGroupUnmappedMode value) {
      if (this.mode == null)
        this.mode = new Enumeration<ConceptMapGroupUnmappedMode>(new ConceptMapGroupUnmappedModeEnumFactory());
      this.mode.setValue(value);
      return this;
    }

    /**
     * @return {@link #code} (The fixed code to use when the mode = 'fixed' - all
     *         unmapped codes are mapped to a single fixed code.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getCode" gives direct access to the value
     */
    public CodeType getCodeElement() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeType(); // bb
      return this.code;
    }

    public boolean hasCodeElement() {
      return this.code != null && !this.code.isEmpty();
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (The fixed code to use when the mode = 'fixed' -
     *              all unmapped codes are mapped to a single fixed code.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getCode" gives direct access to the value
     */
    public ConceptMapGroupUnmappedComponent setCodeElement(CodeType value) {
      this.code = value;
      return this;
    }

    /**
     * @return The fixed code to use when the mode = 'fixed' - all unmapped codes
     *         are mapped to a single fixed code.
     */
    public String getCode() {
      return this.code == null ? null : this.code.getValue();
    }

    /**
     * @param value The fixed code to use when the mode = 'fixed' - all unmapped
     *              codes are mapped to a single fixed code.
     */
    public ConceptMapGroupUnmappedComponent setCode(String value) {
      if (Utilities.noString(value))
        this.code = null;
      else {
        if (this.code == null)
          this.code = new CodeType();
        this.code.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #display} (The display for the code. The display is only
     *         provided to help editors when editing the concept map.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getDisplay" gives direct access to the value
     */
    public StringType getDisplayElement() {
      if (this.display == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.display");
        else if (Configuration.doAutoCreate())
          this.display = new StringType(); // bb
      return this.display;
    }

    public boolean hasDisplayElement() {
      return this.display != null && !this.display.isEmpty();
    }

    public boolean hasDisplay() {
      return this.display != null && !this.display.isEmpty();
    }

    /**
     * @param value {@link #display} (The display for the code. The display is only
     *              provided to help editors when editing the concept map.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getDisplay" gives direct access to the value
     */
    public ConceptMapGroupUnmappedComponent setDisplayElement(StringType value) {
      this.display = value;
      return this;
    }

    /**
     * @return The display for the code. The display is only provided to help
     *         editors when editing the concept map.
     */
    public String getDisplay() {
      return this.display == null ? null : this.display.getValue();
    }

    /**
     * @param value The display for the code. The display is only provided to help
     *              editors when editing the concept map.
     */
    public ConceptMapGroupUnmappedComponent setDisplay(String value) {
      if (Utilities.noString(value))
        this.display = null;
      else {
        if (this.display == null)
          this.display = new StringType();
        this.display.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #url} (The canonical reference to an additional ConceptMap
     *         resource instance to use for mapping if this ConceptMap resource
     *         contains no matching mapping for the source concept.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getUrl" gives direct access to the value
     */
    public CanonicalType getUrlElement() {
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.url");
        else if (Configuration.doAutoCreate())
          this.url = new CanonicalType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() {
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() {
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (The canonical reference to an additional
     *              ConceptMap resource instance to use for mapping if this
     *              ConceptMap resource contains no matching mapping for the source
     *              concept.). This is the underlying object with id, value and
     *              extensions. The accessor "getUrl" gives direct access to the
     *              value
     */
    public ConceptMapGroupUnmappedComponent setUrlElement(CanonicalType value) {
      this.url = value;
      return this;
    }

    /**
     * @return The canonical reference to an additional ConceptMap resource instance
     *         to use for mapping if this ConceptMap resource contains no matching
     *         mapping for the source concept.
     */
    public String getUrl() {
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value The canonical reference to an additional ConceptMap resource
     *              instance to use for mapping if this ConceptMap resource contains
     *              no matching mapping for the source concept.
     */
    public ConceptMapGroupUnmappedComponent setUrl(String value) {
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new CanonicalType();
        this.url.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("mode", "code",
          "Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).",
          0, 1, mode));
      children.add(new Property("code", "code",
          "The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.", 0,
          1, code));
      children.add(new Property("display", "string",
          "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1,
          display));
      children.add(new Property("url", "canonical(ConceptMap)",
          "The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.",
          0, 1, url));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3357091:
        /* mode */ return new Property("mode", "code",
            "Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).",
            0, 1, mode);
      case 3059181:
        /* code */ return new Property("code", "code",
            "The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.", 0,
            1, code);
      case 1671764162:
        /* display */ return new Property("display", "string",
            "The display for the code. The display is only provided to help editors when editing the concept map.", 0,
            1, display);
      case 116079:
        /* url */ return new Property("url", "canonical(ConceptMap)",
            "The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.",
            0, 1, url);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3357091:
        /* mode */ return this.mode == null ? new Base[0] : new Base[] { this.mode }; // Enumeration<ConceptMapGroupUnmappedMode>
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeType
      case 1671764162:
        /* display */ return this.display == null ? new Base[0] : new Base[] { this.display }; // StringType
      case 116079:
        /* url */ return this.url == null ? new Base[0] : new Base[] { this.url }; // CanonicalType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3357091: // mode
        value = new ConceptMapGroupUnmappedModeEnumFactory().fromType(castToCode(value));
        this.mode = (Enumeration) value; // Enumeration<ConceptMapGroupUnmappedMode>
        return value;
      case 3059181: // code
        this.code = castToCode(value); // CodeType
        return value;
      case 1671764162: // display
        this.display = castToString(value); // StringType
        return value;
      case 116079: // url
        this.url = castToCanonical(value); // CanonicalType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("mode")) {
        value = new ConceptMapGroupUnmappedModeEnumFactory().fromType(castToCode(value));
        this.mode = (Enumeration) value; // Enumeration<ConceptMapGroupUnmappedMode>
      } else if (name.equals("code")) {
        this.code = castToCode(value); // CodeType
      } else if (name.equals("display")) {
        this.display = castToString(value); // StringType
      } else if (name.equals("url")) {
        this.url = castToCanonical(value); // CanonicalType
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("mode")) {
        this.mode = null;
      } else if (name.equals("code")) {
        this.code = null;
      } else if (name.equals("display")) {
        this.display = null;
      } else if (name.equals("url")) {
        this.url = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3357091:
        return getModeElement();
      case 3059181:
        return getCodeElement();
      case 1671764162:
        return getDisplayElement();
      case 116079:
        return getUrlElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3357091:
        /* mode */ return new String[] { "code" };
      case 3059181:
        /* code */ return new String[] { "code" };
      case 1671764162:
        /* display */ return new String[] { "string" };
      case 116079:
        /* url */ return new String[] { "canonical" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("mode")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.mode");
      } else if (name.equals("code")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.code");
      } else if (name.equals("display")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.display");
      } else if (name.equals("url")) {
        throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.url");
      } else
        return super.addChild(name);
    }

    public ConceptMapGroupUnmappedComponent copy() {
      ConceptMapGroupUnmappedComponent dst = new ConceptMapGroupUnmappedComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(ConceptMapGroupUnmappedComponent dst) {
      super.copyValues(dst);
      dst.mode = mode == null ? null : mode.copy();
      dst.code = code == null ? null : code.copy();
      dst.display = display == null ? null : display.copy();
      dst.url = url == null ? null : url.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof ConceptMapGroupUnmappedComponent))
        return false;
      ConceptMapGroupUnmappedComponent o = (ConceptMapGroupUnmappedComponent) other_;
      return compareDeep(mode, o.mode, true) && compareDeep(code, o.code, true) && compareDeep(display, o.display, true)
          && compareDeep(url, o.url, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof ConceptMapGroupUnmappedComponent))
        return false;
      ConceptMapGroupUnmappedComponent o = (ConceptMapGroupUnmappedComponent) other_;
      return compareValues(mode, o.mode, true) && compareValues(code, o.code, true)
          && compareValues(display, o.display, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, code, display, url);
    }

    public String fhirType() {
      return "ConceptMap.group.unmapped";

    }

  }

  /**
   * A formal identifier that is used to identify this concept map when it is
   * represented in other formats, or referenced in a specification, model, design
   * or an instance.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 0, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Additional identifier for the concept map", formalDefinition = "A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.")
  protected Identifier identifier;

  /**
   * Explanation of why this concept map is needed and why it has been designed as
   * it has.
   */
  @Child(name = "purpose", type = {
      MarkdownType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Why this concept map is defined", formalDefinition = "Explanation of why this concept map is needed and why it has been designed as it has.")
  protected MarkdownType purpose;

  /**
   * A copyright statement relating to the concept map and/or its contents.
   * Copyright statements are generally legal restrictions on the use and
   * publishing of the concept map.
   */
  @Child(name = "copyright", type = {
      MarkdownType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Use and/or publishing restrictions", formalDefinition = "A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.")
  protected MarkdownType copyright;

  /**
   * Identifier for the source value set that contains the concepts that are being
   * mapped and provides context for the mappings.
   */
  @Child(name = "source", type = { UriType.class,
      CanonicalType.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The source value set that contains the concepts that are being mapped", formalDefinition = "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.")
  protected Type source;

  /**
   * The target value set provides context for the mappings. Note that the mapping
   * is made between concepts, not between value sets, but the value set provides
   * important context about how the concept mapping choices are made.
   */
  @Child(name = "target", type = { UriType.class,
      CanonicalType.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The target value set which provides context for the mappings", formalDefinition = "The target value set provides context for the mappings. Note that the mapping is made between concepts, not between value sets, but the value set provides important context about how the concept mapping choices are made.")
  protected Type target;

  /**
   * A group of mappings that all have the same source and target system.
   */
  @Child(name = "group", type = {}, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Same source and target systems", formalDefinition = "A group of mappings that all have the same source and target system.")
  protected List<ConceptMapGroupComponent> group;

  private static final long serialVersionUID = -2081872580L;

  /**
   * Constructor
   */
  public ConceptMap() {
    super();
  }

  /**
   * Constructor
   */
  public ConceptMap(Enumeration<PublicationStatus> status) {
    super();
    this.status = status;
  }

  /**
   * @return {@link #url} (An absolute URI that is used to identify this concept
   *         map when it is referenced in a specification, model, design or an
   *         instance; also called its canonical identifier. This SHOULD be
   *         globally unique and SHOULD be a literal address at which at which an
   *         authoritative instance of this concept map is (or will be) published.
   *         This URL can be the target of a canonical reference. It SHALL remain
   *         the same when the concept map is stored on different servers.). This
   *         is the underlying object with id, value and extensions. The accessor
   *         "getUrl" gives direct access to the value
   */
  public UriType getUrlElement() {
    if (this.url == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.url");
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
   *              concept map when it is referenced in a specification, model,
   *              design or an instance; also called its canonical identifier.
   *              This SHOULD be globally unique and SHOULD be a literal address
   *              at which at which an authoritative instance of this concept map
   *              is (or will be) published. This URL can be the target of a
   *              canonical reference. It SHALL remain the same when the concept
   *              map is stored on different servers.). This is the underlying
   *              object with id, value and extensions. The accessor "getUrl"
   *              gives direct access to the value
   */
  public ConceptMap setUrlElement(UriType value) {
    this.url = value;
    return this;
  }

  /**
   * @return An absolute URI that is used to identify this concept map when it is
   *         referenced in a specification, model, design or an instance; also
   *         called its canonical identifier. This SHOULD be globally unique and
   *         SHOULD be a literal address at which at which an authoritative
   *         instance of this concept map is (or will be) published. This URL can
   *         be the target of a canonical reference. It SHALL remain the same when
   *         the concept map is stored on different servers.
   */
  public String getUrl() {
    return this.url == null ? null : this.url.getValue();
  }

  /**
   * @param value An absolute URI that is used to identify this concept map when
   *              it is referenced in a specification, model, design or an
   *              instance; also called its canonical identifier. This SHOULD be
   *              globally unique and SHOULD be a literal address at which at
   *              which an authoritative instance of this concept map is (or will
   *              be) published. This URL can be the target of a canonical
   *              reference. It SHALL remain the same when the concept map is
   *              stored on different servers.
   */
  public ConceptMap setUrl(String value) {
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
   *         this concept map when it is represented in other formats, or
   *         referenced in a specification, model, design or an instance.)
   */
  public Identifier getIdentifier() {
    if (this.identifier == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.identifier");
      else if (Configuration.doAutoCreate())
        this.identifier = new Identifier(); // cc
    return this.identifier;
  }

  public boolean hasIdentifier() {
    return this.identifier != null && !this.identifier.isEmpty();
  }

  /**
   * @param value {@link #identifier} (A formal identifier that is used to
   *              identify this concept map when it is represented in other
   *              formats, or referenced in a specification, model, design or an
   *              instance.)
   */
  public ConceptMap setIdentifier(Identifier value) {
    this.identifier = value;
    return this;
  }

  /**
   * @return {@link #version} (The identifier that is used to identify this
   *         version of the concept map when it is referenced in a specification,
   *         model, design or instance. This is an arbitrary value managed by the
   *         concept map author and is not expected to be globally unique. For
   *         example, it might be a timestamp (e.g. yyyymmdd) if a managed version
   *         is not available. There is also no expectation that versions can be
   *         placed in a lexicographical sequence.). This is the underlying object
   *         with id, value and extensions. The accessor "getVersion" gives direct
   *         access to the value
   */
  public StringType getVersionElement() {
    if (this.version == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.version");
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
   *              version of the concept map when it is referenced in a
   *              specification, model, design or instance. This is an arbitrary
   *              value managed by the concept map author and is not expected to
   *              be globally unique. For example, it might be a timestamp (e.g.
   *              yyyymmdd) if a managed version is not available. There is also
   *              no expectation that versions can be placed in a lexicographical
   *              sequence.). This is the underlying object with id, value and
   *              extensions. The accessor "getVersion" gives direct access to the
   *              value
   */
  public ConceptMap setVersionElement(StringType value) {
    this.version = value;
    return this;
  }

  /**
   * @return The identifier that is used to identify this version of the concept
   *         map when it is referenced in a specification, model, design or
   *         instance. This is an arbitrary value managed by the concept map
   *         author and is not expected to be globally unique. For example, it
   *         might be a timestamp (e.g. yyyymmdd) if a managed version is not
   *         available. There is also no expectation that versions can be placed
   *         in a lexicographical sequence.
   */
  public String getVersion() {
    return this.version == null ? null : this.version.getValue();
  }

  /**
   * @param value The identifier that is used to identify this version of the
   *              concept map when it is referenced in a specification, model,
   *              design or instance. This is an arbitrary value managed by the
   *              concept map author and is not expected to be globally unique.
   *              For example, it might be a timestamp (e.g. yyyymmdd) if a
   *              managed version is not available. There is also no expectation
   *              that versions can be placed in a lexicographical sequence.
   */
  public ConceptMap setVersion(String value) {
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
   * @return {@link #name} (A natural language name identifying the concept map.
   *         This name should be usable as an identifier for the module by machine
   *         processing applications such as code generation.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getName" gives direct access to the value
   */
  public StringType getNameElement() {
    if (this.name == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.name");
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
   * @param value {@link #name} (A natural language name identifying the concept
   *              map. This name should be usable as an identifier for the module
   *              by machine processing applications such as code generation.).
   *              This is the underlying object with id, value and extensions. The
   *              accessor "getName" gives direct access to the value
   */
  public ConceptMap setNameElement(StringType value) {
    this.name = value;
    return this;
  }

  /**
   * @return A natural language name identifying the concept map. This name should
   *         be usable as an identifier for the module by machine processing
   *         applications such as code generation.
   */
  public String getName() {
    return this.name == null ? null : this.name.getValue();
  }

  /**
   * @param value A natural language name identifying the concept map. This name
   *              should be usable as an identifier for the module by machine
   *              processing applications such as code generation.
   */
  public ConceptMap setName(String value) {
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
   *         concept map.). This is the underlying object with id, value and
   *         extensions. The accessor "getTitle" gives direct access to the value
   */
  public StringType getTitleElement() {
    if (this.title == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.title");
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
   *              the concept map.). This is the underlying object with id, value
   *              and extensions. The accessor "getTitle" gives direct access to
   *              the value
   */
  public ConceptMap setTitleElement(StringType value) {
    this.title = value;
    return this;
  }

  /**
   * @return A short, descriptive, user-friendly title for the concept map.
   */
  public String getTitle() {
    return this.title == null ? null : this.title.getValue();
  }

  /**
   * @param value A short, descriptive, user-friendly title for the concept map.
   */
  public ConceptMap setTitle(String value) {
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
   * @return {@link #status} (The status of this concept map. Enables tracking the
   *         life-cycle of the content.). This is the underlying object with id,
   *         value and extensions. The accessor "getStatus" gives direct access to
   *         the value
   */
  public Enumeration<PublicationStatus> getStatusElement() {
    if (this.status == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.status");
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
   * @param value {@link #status} (The status of this concept map. Enables
   *              tracking the life-cycle of the content.). This is the underlying
   *              object with id, value and extensions. The accessor "getStatus"
   *              gives direct access to the value
   */
  public ConceptMap setStatusElement(Enumeration<PublicationStatus> value) {
    this.status = value;
    return this;
  }

  /**
   * @return The status of this concept map. Enables tracking the life-cycle of
   *         the content.
   */
  public PublicationStatus getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  /**
   * @param value The status of this concept map. Enables tracking the life-cycle
   *              of the content.
   */
  public ConceptMap setStatus(PublicationStatus value) {
    if (this.status == null)
      this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
    this.status.setValue(value);
    return this;
  }

  /**
   * @return {@link #experimental} (A Boolean value to indicate that this concept
   *         map is authored for testing purposes (or
   *         education/evaluation/marketing) and is not intended to be used for
   *         genuine usage.). This is the underlying object with id, value and
   *         extensions. The accessor "getExperimental" gives direct access to the
   *         value
   */
  public BooleanType getExperimentalElement() {
    if (this.experimental == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.experimental");
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
   *              concept map is authored for testing purposes (or
   *              education/evaluation/marketing) and is not intended to be used
   *              for genuine usage.). This is the underlying object with id,
   *              value and extensions. The accessor "getExperimental" gives
   *              direct access to the value
   */
  public ConceptMap setExperimentalElement(BooleanType value) {
    this.experimental = value;
    return this;
  }

  /**
   * @return A Boolean value to indicate that this concept map is authored for
   *         testing purposes (or education/evaluation/marketing) and is not
   *         intended to be used for genuine usage.
   */
  public boolean getExperimental() {
    return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
  }

  /**
   * @param value A Boolean value to indicate that this concept map is authored
   *              for testing purposes (or education/evaluation/marketing) and is
   *              not intended to be used for genuine usage.
   */
  public ConceptMap setExperimental(boolean value) {
    if (this.experimental == null)
      this.experimental = new BooleanType();
    this.experimental.setValue(value);
    return this;
  }

  /**
   * @return {@link #date} (The date (and optionally time) when the concept map
   *         was published. The date must change when the business version changes
   *         and it must change if the status code changes. In addition, it should
   *         change when the substantive content of the concept map changes.).
   *         This is the underlying object with id, value and extensions. The
   *         accessor "getDate" gives direct access to the value
   */
  public DateTimeType getDateElement() {
    if (this.date == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.date");
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
   * @param value {@link #date} (The date (and optionally time) when the concept
   *              map was published. The date must change when the business
   *              version changes and it must change if the status code changes.
   *              In addition, it should change when the substantive content of
   *              the concept map changes.). This is the underlying object with
   *              id, value and extensions. The accessor "getDate" gives direct
   *              access to the value
   */
  public ConceptMap setDateElement(DateTimeType value) {
    this.date = value;
    return this;
  }

  /**
   * @return The date (and optionally time) when the concept map was published.
   *         The date must change when the business version changes and it must
   *         change if the status code changes. In addition, it should change when
   *         the substantive content of the concept map changes.
   */
  public Date getDate() {
    return this.date == null ? null : this.date.getValue();
  }

  /**
   * @param value The date (and optionally time) when the concept map was
   *              published. The date must change when the business version
   *              changes and it must change if the status code changes. In
   *              addition, it should change when the substantive content of the
   *              concept map changes.
   */
  public ConceptMap setDate(Date value) {
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
   *         published the concept map.). This is the underlying object with id,
   *         value and extensions. The accessor "getPublisher" gives direct access
   *         to the value
   */
  public StringType getPublisherElement() {
    if (this.publisher == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.publisher");
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
   *              that published the concept map.). This is the underlying object
   *              with id, value and extensions. The accessor "getPublisher" gives
   *              direct access to the value
   */
  public ConceptMap setPublisherElement(StringType value) {
    this.publisher = value;
    return this;
  }

  /**
   * @return The name of the organization or individual that published the concept
   *         map.
   */
  public String getPublisher() {
    return this.publisher == null ? null : this.publisher.getValue();
  }

  /**
   * @param value The name of the organization or individual that published the
   *              concept map.
   */
  public ConceptMap setPublisher(String value) {
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
  public ConceptMap setContact(List<ContactDetail> theContact) {
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

  public ConceptMap addContact(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #contact}, creating it
   *         if it does not already exist
   */
  public ContactDetail getContactFirstRep() {
    if (getContact().isEmpty()) {
      addContact();
    }
    return getContact().get(0);
  }

  /**
   * @return {@link #description} (A free text natural language description of the
   *         concept map from a consumer's perspective.). This is the underlying
   *         object with id, value and extensions. The accessor "getDescription"
   *         gives direct access to the value
   */
  public MarkdownType getDescriptionElement() {
    if (this.description == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.description");
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
   *              of the concept map from a consumer's perspective.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getDescription" gives direct access to the value
   */
  public ConceptMap setDescriptionElement(MarkdownType value) {
    this.description = value;
    return this;
  }

  /**
   * @return A free text natural language description of the concept map from a
   *         consumer's perspective.
   */
  public String getDescription() {
    return this.description == null ? null : this.description.getValue();
  }

  /**
   * @param value A free text natural language description of the concept map from
   *              a consumer's perspective.
   */
  public ConceptMap setDescription(String value) {
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
   *         assist with indexing and searching for appropriate concept map
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
  public ConceptMap setUseContext(List<UsageContext> theUseContext) {
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

  public ConceptMap addUseContext(UsageContext t) { // 3
    if (t == null)
      return this;
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #useContext}, creating
   *         it if it does not already exist
   */
  public UsageContext getUseContextFirstRep() {
    if (getUseContext().isEmpty()) {
      addUseContext();
    }
    return getUseContext().get(0);
  }

  /**
   * @return {@link #jurisdiction} (A legal or geographic region in which the
   *         concept map is intended to be used.)
   */
  public List<CodeableConcept> getJurisdiction() {
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    return this.jurisdiction;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public ConceptMap setJurisdiction(List<CodeableConcept> theJurisdiction) {
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

  public ConceptMap addJurisdiction(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #jurisdiction},
   *         creating it if it does not already exist
   */
  public CodeableConcept getJurisdictionFirstRep() {
    if (getJurisdiction().isEmpty()) {
      addJurisdiction();
    }
    return getJurisdiction().get(0);
  }

  /**
   * @return {@link #purpose} (Explanation of why this concept map is needed and
   *         why it has been designed as it has.). This is the underlying object
   *         with id, value and extensions. The accessor "getPurpose" gives direct
   *         access to the value
   */
  public MarkdownType getPurposeElement() {
    if (this.purpose == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.purpose");
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
   * @param value {@link #purpose} (Explanation of why this concept map is needed
   *              and why it has been designed as it has.). This is the underlying
   *              object with id, value and extensions. The accessor "getPurpose"
   *              gives direct access to the value
   */
  public ConceptMap setPurposeElement(MarkdownType value) {
    this.purpose = value;
    return this;
  }

  /**
   * @return Explanation of why this concept map is needed and why it has been
   *         designed as it has.
   */
  public String getPurpose() {
    return this.purpose == null ? null : this.purpose.getValue();
  }

  /**
   * @param value Explanation of why this concept map is needed and why it has
   *              been designed as it has.
   */
  public ConceptMap setPurpose(String value) {
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
   * @return {@link #copyright} (A copyright statement relating to the concept map
   *         and/or its contents. Copyright statements are generally legal
   *         restrictions on the use and publishing of the concept map.). This is
   *         the underlying object with id, value and extensions. The accessor
   *         "getCopyright" gives direct access to the value
   */
  public MarkdownType getCopyrightElement() {
    if (this.copyright == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create ConceptMap.copyright");
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
   * @param value {@link #copyright} (A copyright statement relating to the
   *              concept map and/or its contents. Copyright statements are
   *              generally legal restrictions on the use and publishing of the
   *              concept map.). This is the underlying object with id, value and
   *              extensions. The accessor "getCopyright" gives direct access to
   *              the value
   */
  public ConceptMap setCopyrightElement(MarkdownType value) {
    this.copyright = value;
    return this;
  }

  /**
   * @return A copyright statement relating to the concept map and/or its
   *         contents. Copyright statements are generally legal restrictions on
   *         the use and publishing of the concept map.
   */
  public String getCopyright() {
    return this.copyright == null ? null : this.copyright.getValue();
  }

  /**
   * @param value A copyright statement relating to the concept map and/or its
   *              contents. Copyright statements are generally legal restrictions
   *              on the use and publishing of the concept map.
   */
  public ConceptMap setCopyright(String value) {
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
   * @return {@link #source} (Identifier for the source value set that contains
   *         the concepts that are being mapped and provides context for the
   *         mappings.)
   */
  public Type getSource() {
    return this.source;
  }

  /**
   * @return {@link #source} (Identifier for the source value set that contains
   *         the concepts that are being mapped and provides context for the
   *         mappings.)
   */
  public UriType getSourceUriType() throws FHIRException {
    if (this.source == null)
      this.source = new UriType();
    if (!(this.source instanceof UriType))
      throw new FHIRException(
          "Type mismatch: the type UriType was expected, but " + this.source.getClass().getName() + " was encountered");
    return (UriType) this.source;
  }

  public boolean hasSourceUriType() {
      return this.source instanceof UriType;
  }

  /**
   * @return {@link #source} (Identifier for the source value set that contains
   *         the concepts that are being mapped and provides context for the
   *         mappings.)
   */
  public CanonicalType getSourceCanonicalType() throws FHIRException {
    if (this.source == null)
      this.source = new CanonicalType();
    if (!(this.source instanceof CanonicalType))
      throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "
          + this.source.getClass().getName() + " was encountered");
    return (CanonicalType) this.source;
  }

  public boolean hasSourceCanonicalType() {
      return this.source instanceof CanonicalType;
  }

  public boolean hasSource() {
    return this.source != null && !this.source.isEmpty();
  }

  /**
   * @param value {@link #source} (Identifier for the source value set that
   *              contains the concepts that are being mapped and provides context
   *              for the mappings.)
   */
  public ConceptMap setSource(Type value) {
    if (value != null && !(value instanceof UriType || value instanceof CanonicalType))
      throw new Error("Not the right type for ConceptMap.source[x]: " + value.fhirType());
    this.source = value;
    return this;
  }

  /**
   * @return {@link #target} (The target value set provides context for the
   *         mappings. Note that the mapping is made between concepts, not between
   *         value sets, but the value set provides important context about how
   *         the concept mapping choices are made.)
   */
  public Type getTarget() {
    return this.target;
  }

  /**
   * @return {@link #target} (The target value set provides context for the
   *         mappings. Note that the mapping is made between concepts, not between
   *         value sets, but the value set provides important context about how
   *         the concept mapping choices are made.)
   */
  public UriType getTargetUriType() throws FHIRException {
    if (this.target == null)
      this.target = new UriType();
    if (!(this.target instanceof UriType))
      throw new FHIRException(
          "Type mismatch: the type UriType was expected, but " + this.target.getClass().getName() + " was encountered");
    return (UriType) this.target;
  }

  public boolean hasTargetUriType() {
      return this.target instanceof UriType;
  }

  /**
   * @return {@link #target} (The target value set provides context for the
   *         mappings. Note that the mapping is made between concepts, not between
   *         value sets, but the value set provides important context about how
   *         the concept mapping choices are made.)
   */
  public CanonicalType getTargetCanonicalType() throws FHIRException {
    if (this.target == null)
      this.target = new CanonicalType();
    if (!(this.target instanceof CanonicalType))
      throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "
          + this.target.getClass().getName() + " was encountered");
    return (CanonicalType) this.target;
  }

  public boolean hasTargetCanonicalType() {
      return this.target instanceof CanonicalType;
  }

  public boolean hasTarget() {
    return this.target != null && !this.target.isEmpty();
  }

  /**
   * @param value {@link #target} (The target value set provides context for the
   *              mappings. Note that the mapping is made between concepts, not
   *              between value sets, but the value set provides important context
   *              about how the concept mapping choices are made.)
   */
  public ConceptMap setTarget(Type value) {
    if (value != null && !(value instanceof UriType || value instanceof CanonicalType))
      throw new Error("Not the right type for ConceptMap.target[x]: " + value.fhirType());
    this.target = value;
    return this;
  }

  /**
   * @return {@link #group} (A group of mappings that all have the same source and
   *         target system.)
   */
  public List<ConceptMapGroupComponent> getGroup() {
    if (this.group == null)
      this.group = new ArrayList<ConceptMapGroupComponent>();
    return this.group;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public ConceptMap setGroup(List<ConceptMapGroupComponent> theGroup) {
    this.group = theGroup;
    return this;
  }

  public boolean hasGroup() {
    if (this.group == null)
      return false;
    for (ConceptMapGroupComponent item : this.group)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ConceptMapGroupComponent addGroup() { // 3
    ConceptMapGroupComponent t = new ConceptMapGroupComponent();
    if (this.group == null)
      this.group = new ArrayList<ConceptMapGroupComponent>();
    this.group.add(t);
    return t;
  }

  public ConceptMap addGroup(ConceptMapGroupComponent t) { // 3
    if (t == null)
      return this;
    if (this.group == null)
      this.group = new ArrayList<ConceptMapGroupComponent>();
    this.group.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #group}, creating it
   *         if it does not already exist
   */
  public ConceptMapGroupComponent getGroupFirstRep() {
    if (getGroup().isEmpty()) {
      addGroup();
    }
    return getGroup().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("url", "uri",
        "An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.",
        0, 1, url));
    children.add(new Property("identifier", "Identifier",
        "A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.",
        0, 1, identifier));
    children.add(new Property("version", "string",
        "The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.",
        0, 1, version));
    children.add(new Property("name", "string",
        "A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
        0, 1, name));
    children.add(
        new Property("title", "string", "A short, descriptive, user-friendly title for the concept map.", 0, 1, title));
    children.add(new Property("status", "code",
        "The status of this concept map. Enables tracking the life-cycle of the content.", 0, 1, status));
    children.add(new Property("experimental", "boolean",
        "A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
        0, 1, experimental));
    children.add(new Property("date", "dateTime",
        "The date  (and optionally time) when the concept map was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.",
        0, 1, date));
    children.add(new Property("publisher", "string",
        "The name of the organization or individual that published the concept map.", 0, 1, publisher));
    children.add(new Property("contact", "ContactDetail",
        "Contact details to assist a user in finding and communicating with the publisher.", 0,
        java.lang.Integer.MAX_VALUE, contact));
    children.add(new Property("description", "markdown",
        "A free text natural language description of the concept map from a consumer's perspective.", 0, 1,
        description));
    children.add(new Property("useContext", "UsageContext",
        "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances.",
        0, java.lang.Integer.MAX_VALUE, useContext));
    children.add(new Property("jurisdiction", "CodeableConcept",
        "A legal or geographic region in which the concept map is intended to be used.", 0, java.lang.Integer.MAX_VALUE,
        jurisdiction));
    children.add(new Property("purpose", "markdown",
        "Explanation of why this concept map is needed and why it has been designed as it has.", 0, 1, purpose));
    children.add(new Property("copyright", "markdown",
        "A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.",
        0, 1, copyright));
    children.add(new Property("source[x]", "uri|canonical(ValueSet)",
        "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.",
        0, 1, source));
    children.add(new Property("target[x]", "uri|canonical(ValueSet)",
        "The target value set provides context for the mappings. Note that the mapping is made between concepts, not between value sets, but the value set provides important context about how the concept mapping choices are made.",
        0, 1, target));
    children.add(new Property("group", "", "A group of mappings that all have the same source and target system.", 0,
        java.lang.Integer.MAX_VALUE, group));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case 116079:
      /* url */ return new Property("url", "uri",
          "An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.",
          0, 1, url);
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier",
          "A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.",
          0, 1, identifier);
    case 351608024:
      /* version */ return new Property("version", "string",
          "The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.",
          0, 1, version);
    case 3373707:
      /* name */ return new Property("name", "string",
          "A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
          0, 1, name);
    case 110371416:
      /* title */ return new Property("title", "string",
          "A short, descriptive, user-friendly title for the concept map.", 0, 1, title);
    case -892481550:
      /* status */ return new Property("status", "code",
          "The status of this concept map. Enables tracking the life-cycle of the content.", 0, 1, status);
    case -404562712:
      /* experimental */ return new Property("experimental", "boolean",
          "A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
          0, 1, experimental);
    case 3076014:
      /* date */ return new Property("date", "dateTime",
          "The date  (and optionally time) when the concept map was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.",
          0, 1, date);
    case 1447404028:
      /* publisher */ return new Property("publisher", "string",
          "The name of the organization or individual that published the concept map.", 0, 1, publisher);
    case 951526432:
      /* contact */ return new Property("contact", "ContactDetail",
          "Contact details to assist a user in finding and communicating with the publisher.", 0,
          java.lang.Integer.MAX_VALUE, contact);
    case -1724546052:
      /* description */ return new Property("description", "markdown",
          "A free text natural language description of the concept map from a consumer's perspective.", 0, 1,
          description);
    case -669707736:
      /* useContext */ return new Property("useContext", "UsageContext",
          "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances.",
          0, java.lang.Integer.MAX_VALUE, useContext);
    case -507075711:
      /* jurisdiction */ return new Property("jurisdiction", "CodeableConcept",
          "A legal or geographic region in which the concept map is intended to be used.", 0,
          java.lang.Integer.MAX_VALUE, jurisdiction);
    case -220463842:
      /* purpose */ return new Property("purpose", "markdown",
          "Explanation of why this concept map is needed and why it has been designed as it has.", 0, 1, purpose);
    case 1522889671:
      /* copyright */ return new Property("copyright", "markdown",
          "A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.",
          0, 1, copyright);
    case -1698413947:
      /* source[x] */ return new Property("source[x]", "uri|canonical(ValueSet)",
          "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.",
          0, 1, source);
    case -896505829:
      /* source */ return new Property("source[x]", "uri|canonical(ValueSet)",
          "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.",
          0, 1, source);
    case -1698419887:
      /* sourceUri */ return new Property("source[x]", "uri|canonical(ValueSet)",
          "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.",
          0, 1, source);
    case 1509247769:
      /* sourceCanonical */ return new Property("source[x]", "uri|canonical(ValueSet)",
          "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.",
          0, 1, source);
    case -815579825:
      /* target[x] */ return new Property("target[x]", "uri|canonical(ValueSet)",
          "The target value set provides context for the mappings. Note that the mapping is made between concepts, not between value sets, but the value set provides important context about how the concept mapping choices are made.",
          0, 1, target);
    case -880905839:
      /* target */ return new Property("target[x]", "uri|canonical(ValueSet)",
          "The target value set provides context for the mappings. Note that the mapping is made between concepts, not between value sets, but the value set provides important context about how the concept mapping choices are made.",
          0, 1, target);
    case -815585765:
      /* targetUri */ return new Property("target[x]", "uri|canonical(ValueSet)",
          "The target value set provides context for the mappings. Note that the mapping is made between concepts, not between value sets, but the value set provides important context about how the concept mapping choices are made.",
          0, 1, target);
    case -1281653149:
      /* targetCanonical */ return new Property("target[x]", "uri|canonical(ValueSet)",
          "The target value set provides context for the mappings. Note that the mapping is made between concepts, not between value sets, but the value set provides important context about how the concept mapping choices are made.",
          0, 1, target);
    case 98629247:
      /* group */ return new Property("group", "",
          "A group of mappings that all have the same source and target system.", 0, java.lang.Integer.MAX_VALUE,
          group);
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
      /* identifier */ return this.identifier == null ? new Base[0] : new Base[] { this.identifier }; // Identifier
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
    case -896505829:
      /* source */ return this.source == null ? new Base[0] : new Base[] { this.source }; // Type
    case -880905839:
      /* target */ return this.target == null ? new Base[0] : new Base[] { this.target }; // Type
    case 98629247:
      /* group */ return this.group == null ? new Base[0] : this.group.toArray(new Base[this.group.size()]); // ConceptMapGroupComponent
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 116079: // url
      this.url = castToUri(value); // UriType
      return value;
    case -1618432855: // identifier
      this.identifier = castToIdentifier(value); // Identifier
      return value;
    case 351608024: // version
      this.version = castToString(value); // StringType
      return value;
    case 3373707: // name
      this.name = castToString(value); // StringType
      return value;
    case 110371416: // title
      this.title = castToString(value); // StringType
      return value;
    case -892481550: // status
      value = new PublicationStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
      return value;
    case -404562712: // experimental
      this.experimental = castToBoolean(value); // BooleanType
      return value;
    case 3076014: // date
      this.date = castToDateTime(value); // DateTimeType
      return value;
    case 1447404028: // publisher
      this.publisher = castToString(value); // StringType
      return value;
    case 951526432: // contact
      this.getContact().add(castToContactDetail(value)); // ContactDetail
      return value;
    case -1724546052: // description
      this.description = castToMarkdown(value); // MarkdownType
      return value;
    case -669707736: // useContext
      this.getUseContext().add(castToUsageContext(value)); // UsageContext
      return value;
    case -507075711: // jurisdiction
      this.getJurisdiction().add(castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -220463842: // purpose
      this.purpose = castToMarkdown(value); // MarkdownType
      return value;
    case 1522889671: // copyright
      this.copyright = castToMarkdown(value); // MarkdownType
      return value;
    case -896505829: // source
      this.source = castToType(value); // Type
      return value;
    case -880905839: // target
      this.target = castToType(value); // Type
      return value;
    case 98629247: // group
      this.getGroup().add((ConceptMapGroupComponent) value); // ConceptMapGroupComponent
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = castToUri(value); // UriType
    } else if (name.equals("identifier")) {
      this.identifier = castToIdentifier(value); // Identifier
    } else if (name.equals("version")) {
      this.version = castToString(value); // StringType
    } else if (name.equals("name")) {
      this.name = castToString(value); // StringType
    } else if (name.equals("title")) {
      this.title = castToString(value); // StringType
    } else if (name.equals("status")) {
      value = new PublicationStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
    } else if (name.equals("experimental")) {
      this.experimental = castToBoolean(value); // BooleanType
    } else if (name.equals("date")) {
      this.date = castToDateTime(value); // DateTimeType
    } else if (name.equals("publisher")) {
      this.publisher = castToString(value); // StringType
    } else if (name.equals("contact")) {
      this.getContact().add(castToContactDetail(value));
    } else if (name.equals("description")) {
      this.description = castToMarkdown(value); // MarkdownType
    } else if (name.equals("useContext")) {
      this.getUseContext().add(castToUsageContext(value));
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().add(castToCodeableConcept(value));
    } else if (name.equals("purpose")) {
      this.purpose = castToMarkdown(value); // MarkdownType
    } else if (name.equals("copyright")) {
      this.copyright = castToMarkdown(value); // MarkdownType
    } else if (name.equals("source[x]")) {
      this.source = castToType(value); // Type
    } else if (name.equals("target[x]")) {
      this.target = castToType(value); // Type
    } else if (name.equals("group")) {
      this.getGroup().add((ConceptMapGroupComponent) value);
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = null;
    } else if (name.equals("identifier")) {
      this.identifier = null;
    } else if (name.equals("version")) {
      this.version = null;
    } else if (name.equals("name")) {
      this.name = null;
    } else if (name.equals("title")) {
      this.title = null;
    } else if (name.equals("status")) {
      this.status = null;
    } else if (name.equals("experimental")) {
      this.experimental = null;
    } else if (name.equals("date")) {
      this.date = null;
    } else if (name.equals("publisher")) {
      this.publisher = null;
    } else if (name.equals("contact")) {
      this.getContact().remove(castToContactDetail(value));
    } else if (name.equals("description")) {
      this.description = null;
    } else if (name.equals("useContext")) {
      this.getUseContext().remove(castToUsageContext(value));
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().remove(castToCodeableConcept(value));
    } else if (name.equals("purpose")) {
      this.purpose = null;
    } else if (name.equals("copyright")) {
      this.copyright = null;
    } else if (name.equals("source[x]")) {
      this.source = null;
    } else if (name.equals("target[x]")) {
      this.target = null;
    } else if (name.equals("group")) {
      this.getGroup().remove((ConceptMapGroupComponent) value);
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      return getUrlElement();
    case -1618432855:
      return getIdentifier();
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
    case -1698413947:
      return getSource();
    case -896505829:
      return getSource();
    case -815579825:
      return getTarget();
    case -880905839:
      return getTarget();
    case 98629247:
      return addGroup();
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
    case -896505829:
      /* source */ return new String[] { "uri", "canonical" };
    case -880905839:
      /* target */ return new String[] { "uri", "canonical" };
    case 98629247:
      /* group */ return new String[] {};
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("url")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.url");
    } else if (name.equals("identifier")) {
      this.identifier = new Identifier();
      return this.identifier;
    } else if (name.equals("version")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.version");
    } else if (name.equals("name")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.name");
    } else if (name.equals("title")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.title");
    } else if (name.equals("status")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.status");
    } else if (name.equals("experimental")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.experimental");
    } else if (name.equals("date")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.date");
    } else if (name.equals("publisher")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.publisher");
    } else if (name.equals("contact")) {
      return addContact();
    } else if (name.equals("description")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.description");
    } else if (name.equals("useContext")) {
      return addUseContext();
    } else if (name.equals("jurisdiction")) {
      return addJurisdiction();
    } else if (name.equals("purpose")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.purpose");
    } else if (name.equals("copyright")) {
      throw new FHIRException("Cannot call addChild on a singleton property ConceptMap.copyright");
    } else if (name.equals("sourceUri")) {
      this.source = new UriType();
      return this.source;
    } else if (name.equals("sourceCanonical")) {
      this.source = new CanonicalType();
      return this.source;
    } else if (name.equals("targetUri")) {
      this.target = new UriType();
      return this.target;
    } else if (name.equals("targetCanonical")) {
      this.target = new CanonicalType();
      return this.target;
    } else if (name.equals("group")) {
      return addGroup();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "ConceptMap";

  }

  public ConceptMap copy() {
    ConceptMap dst = new ConceptMap();
    copyValues(dst);
    return dst;
  }

  public void copyValues(ConceptMap dst) {
    super.copyValues(dst);
    dst.url = url == null ? null : url.copy();
    dst.identifier = identifier == null ? null : identifier.copy();
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
    dst.source = source == null ? null : source.copy();
    dst.target = target == null ? null : target.copy();
    if (group != null) {
      dst.group = new ArrayList<ConceptMapGroupComponent>();
      for (ConceptMapGroupComponent i : group)
        dst.group.add(i.copy());
    }
    ;
  }

  protected ConceptMap typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof ConceptMap))
      return false;
    ConceptMap o = (ConceptMap) other_;
    return compareDeep(identifier, o.identifier, true) && compareDeep(purpose, o.purpose, true)
        && compareDeep(copyright, o.copyright, true) && compareDeep(source, o.source, true)
        && compareDeep(target, o.target, true) && compareDeep(group, o.group, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof ConceptMap))
      return false;
    ConceptMap o = (ConceptMap) other_;
    return compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true);
  }

  public boolean isEmpty() {
    return super.isEmpty()
        && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, purpose, copyright, source, target, group);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ConceptMap;
  }

  /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The concept map publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ConceptMap.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "date", path = "ConceptMap.date", description = "The concept map publication date", type = "date")
  public static final String SP_DATE = "date";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The concept map publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ConceptMap.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_DATE);

  /**
   * Search parameter: <b>other</b>
   * <p>
   * Description: <b>canonical reference to an additional ConceptMap to use for
   * mapping if the source concept is unmapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.unmapped.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "other", path = "ConceptMap.group.unmapped.url", description = "canonical reference to an additional ConceptMap to use for mapping if the source concept is unmapped", type = "reference", target = {
      ConceptMap.class })
  public static final String SP_OTHER = "other";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>other</b>
   * <p>
   * Description: <b>canonical reference to an additional ConceptMap to use for
   * mapping if the source concept is unmapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.unmapped.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam OTHER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_OTHER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:other</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_OTHER = new ca.uhn.fhir.model.api.Include(
      "ConceptMap:other").toLocked();

  /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the concept
   * map</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-value", path = "ConceptMap.useContext", description = "A use context type and value assigned to the concept map", type = "composite", compositeOf = {
      "context-type", "context" })
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the concept
   * map</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(
      SP_CONTEXT_TYPE_VALUE);

  /**
   * Search parameter: <b>target-system</b>
   * <p>
   * Description: <b>Target system that the concepts are to be mapped to</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "target-system", path = "ConceptMap.group.target", description = "Target system that the concepts are to be mapped to", type = "uri")
  public static final String SP_TARGET_SYSTEM = "target-system";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>target-system</b>
   * <p>
   * Description: <b>Target system that the concepts are to be mapped to</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam TARGET_SYSTEM = new ca.uhn.fhir.rest.gclient.UriClientParam(
      SP_TARGET_SYSTEM);

  /**
   * Search parameter: <b>dependson</b>
   * <p>
   * Description: <b>Reference to property mapping depends on</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.dependsOn.property</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "dependson", path = "ConceptMap.group.element.target.dependsOn.property", description = "Reference to property mapping depends on", type = "uri")
  public static final String SP_DEPENDSON = "dependson";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>dependson</b>
   * <p>
   * Description: <b>Reference to property mapping depends on</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.dependsOn.property</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam DEPENDSON = new ca.uhn.fhir.rest.gclient.UriClientParam(
      SP_DEPENDSON);

  /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "jurisdiction", path = "ConceptMap.jurisdiction", description = "Intended jurisdiction for the concept map", type = "token")
  public static final String SP_JURISDICTION = "jurisdiction";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_JURISDICTION);

  /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "description", path = "ConceptMap.description", description = "The description of the concept map", type = "string")
  public static final String SP_DESCRIPTION = "description";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_DESCRIPTION);

  /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type", path = "ConceptMap.useContext.code", description = "A type of use context assigned to the concept map", type = "token")
  public static final String SP_CONTEXT_TYPE = "context-type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT_TYPE);

  /**
   * Search parameter: <b>source</b>
   * <p>
   * Description: <b>The source value set that contains the concepts that are
   * being mapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.sourceCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "source", path = "(ConceptMap.source as canonical)", description = "The source value set that contains the concepts that are being mapped", type = "reference", target = {
      ValueSet.class })
  public static final String SP_SOURCE = "source";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>source</b>
   * <p>
   * Description: <b>The source value set that contains the concepts that are
   * being mapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.sourceCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_SOURCE);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:source</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE = new ca.uhn.fhir.model.api.Include(
      "ConceptMap:source").toLocked();

  /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "title", path = "ConceptMap.title", description = "The human-friendly name of the concept map", type = "string")
  public static final String SP_TITLE = "title";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_TITLE);

  /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * concept map</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>ConceptMap.useContext.valueQuantity,
   * ConceptMap.useContext.valueRange</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-quantity", path = "(ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range)", description = "A quantity- or range-valued use context assigned to the concept map", type = "quantity")
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * concept map</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>ConceptMap.useContext.valueQuantity,
   * ConceptMap.useContext.valueRange</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(
      SP_CONTEXT_QUANTITY);

  /**
   * Search parameter: <b>source-uri</b>
   * <p>
   * Description: <b>The source value set that contains the concepts that are
   * being mapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.sourceUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "source-uri", path = "(ConceptMap.source as uri)", description = "The source value set that contains the concepts that are being mapped", type = "reference", target = {
      ValueSet.class })
  public static final String SP_SOURCE_URI = "source-uri";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>source-uri</b>
   * <p>
   * Description: <b>The source value set that contains the concepts that are
   * being mapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.sourceUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE_URI = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_SOURCE_URI);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:source-uri</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE_URI = new ca.uhn.fhir.model.api.Include(
      "ConceptMap:source-uri").toLocked();

  /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.useContext.valueCodeableConcept</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context", path = "(ConceptMap.useContext.value as CodeableConcept)", description = "A use context assigned to the concept map", type = "token")
  public static final String SP_CONTEXT = "context";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.useContext.valueCodeableConcept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT);

  /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the concept map</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-quantity", path = "ConceptMap.useContext", description = "A use context type and quantity- or range-based value assigned to the concept map", type = "composite", compositeOf = {
      "context-type", "context-quantity" })
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for
   * <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the concept map</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(
      SP_CONTEXT_TYPE_QUANTITY);

  /**
   * Search parameter: <b>source-system</b>
   * <p>
   * Description: <b>Source system where concepts to be mapped are defined</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.source</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "source-system", path = "ConceptMap.group.source", description = "Source system where concepts to be mapped are defined", type = "uri")
  public static final String SP_SOURCE_SYSTEM = "source-system";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>source-system</b>
   * <p>
   * Description: <b>Source system where concepts to be mapped are defined</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.source</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam SOURCE_SYSTEM = new ca.uhn.fhir.rest.gclient.UriClientParam(
      SP_SOURCE_SYSTEM);

  /**
   * Search parameter: <b>target-code</b>
   * <p>
   * Description: <b>Code that identifies the target element</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.target.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "target-code", path = "ConceptMap.group.element.target.code", description = "Code that identifies the target element", type = "token")
  public static final String SP_TARGET_CODE = "target-code";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>target-code</b>
   * <p>
   * Description: <b>Code that identifies the target element</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.target.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TARGET_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_TARGET_CODE);

  /**
   * Search parameter: <b>target-uri</b>
   * <p>
   * Description: <b>The target value set which provides context for the
   * mappings</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.targetUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "target-uri", path = "(ConceptMap.target as uri)", description = "The target value set which provides context for the mappings", type = "reference", target = {
      ValueSet.class })
  public static final String SP_TARGET_URI = "target-uri";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>target-uri</b>
   * <p>
   * Description: <b>The target value set which provides context for the
   * mappings</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.targetUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam TARGET_URI = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_TARGET_URI);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:target-uri</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_TARGET_URI = new ca.uhn.fhir.model.api.Include(
      "ConceptMap:target-uri").toLocked();

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "ConceptMap.identifier", description = "External identifier for the concept map", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>product</b>
   * <p>
   * Description: <b>Reference to property mapping depends on</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.product.property</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "product", path = "ConceptMap.group.element.target.product.property", description = "Reference to property mapping depends on", type = "uri")
  public static final String SP_PRODUCT = "product";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>product</b>
   * <p>
   * Description: <b>Reference to property mapping depends on</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.product.property</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam PRODUCT = new ca.uhn.fhir.rest.gclient.UriClientParam(
      SP_PRODUCT);

  /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "version", path = "ConceptMap.version", description = "The business version of the concept map", type = "token")
  public static final String SP_VERSION = "version";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_VERSION);

  /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the concept map</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "url", path = "ConceptMap.url", description = "The uri that identifies the concept map", type = "uri")
  public static final String SP_URL = "url";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the concept map</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

  /**
   * Search parameter: <b>target</b>
   * <p>
   * Description: <b>The target value set which provides context for the
   * mappings</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.targetCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "target", path = "(ConceptMap.target as canonical)", description = "The target value set which provides context for the mappings", type = "reference", target = {
      ValueSet.class })
  public static final String SP_TARGET = "target";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>target</b>
   * <p>
   * Description: <b>The target value set which provides context for the
   * mappings</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.targetCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam TARGET = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_TARGET);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:target</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_TARGET = new ca.uhn.fhir.model.api.Include(
      "ConceptMap:target").toLocked();

  /**
   * Search parameter: <b>source-code</b>
   * <p>
   * Description: <b>Identifies element being mapped</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "source-code", path = "ConceptMap.group.element.code", description = "Identifies element being mapped", type = "token")
  public static final String SP_SOURCE_CODE = "source-code";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>source-code</b>
   * <p>
   * Description: <b>Identifies element being mapped</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SOURCE_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_SOURCE_CODE);

  /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "name", path = "ConceptMap.name", description = "Computationally friendly name of the concept map", type = "string")
  public static final String SP_NAME = "name";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_NAME);

  /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "publisher", path = "ConceptMap.publisher", description = "Name of the publisher of the concept map", type = "string")
  public static final String SP_PUBLISHER = "publisher";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the concept map</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ConceptMap.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_PUBLISHER);

  /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "status", path = "ConceptMap.status", description = "The current status of the concept map", type = "token")
  public static final String SP_STATUS = "status";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the concept map</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_STATUS);

}
