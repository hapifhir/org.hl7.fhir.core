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
 * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.
 */
@ResourceDef(name="ConceptMap", profile="http://hl7.org/fhir/StructureDefinition/ConceptMap")
public class ConceptMap extends MetadataResource {

    public enum ConceptMapGroupUnmappedMode {
        /**
         * Use the code as provided in the $translate request in one of the following input parameters: sourceCode, sourceCoding, sourceCodeableConcept.
         */
        USESOURCECODE, 
        /**
         * Use the code(s) explicitly provided in the group.unmapped 'code' or 'valueSet' element.
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
        if ("use-source-code".equals(codeString))
          return USESOURCECODE;
        if ("fixed".equals(codeString))
          return FIXED;
        if ("other-map".equals(codeString))
          return OTHERMAP;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConceptMapGroupUnmappedMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case USESOURCECODE: return "use-source-code";
            case FIXED: return "fixed";
            case OTHERMAP: return "other-map";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case USESOURCECODE: return "http://hl7.org/fhir/conceptmap-unmapped-mode";
            case FIXED: return "http://hl7.org/fhir/conceptmap-unmapped-mode";
            case OTHERMAP: return "http://hl7.org/fhir/conceptmap-unmapped-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case USESOURCECODE: return "Use the code as provided in the $translate request in one of the following input parameters: sourceCode, sourceCoding, sourceCodeableConcept.";
            case FIXED: return "Use the code(s) explicitly provided in the group.unmapped 'code' or 'valueSet' element.";
            case OTHERMAP: return "Use the map identified by the canonical URL in the url element.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case USESOURCECODE: return "Use Provided Source Code";
            case FIXED: return "Fixed Code";
            case OTHERMAP: return "Other Map";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConceptMapGroupUnmappedModeEnumFactory implements EnumFactory<ConceptMapGroupUnmappedMode> {
    public ConceptMapGroupUnmappedMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("use-source-code".equals(codeString))
          return ConceptMapGroupUnmappedMode.USESOURCECODE;
        if ("fixed".equals(codeString))
          return ConceptMapGroupUnmappedMode.FIXED;
        if ("other-map".equals(codeString))
          return ConceptMapGroupUnmappedMode.OTHERMAP;
        throw new IllegalArgumentException("Unknown ConceptMapGroupUnmappedMode code '"+codeString+"'");
        }
        public Enumeration<ConceptMapGroupUnmappedMode> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConceptMapGroupUnmappedMode>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("use-source-code".equals(codeString))
          return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.USESOURCECODE);
        if ("fixed".equals(codeString))
          return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.FIXED);
        if ("other-map".equals(codeString))
          return new Enumeration<ConceptMapGroupUnmappedMode>(this, ConceptMapGroupUnmappedMode.OTHERMAP);
        throw new FHIRException("Unknown ConceptMapGroupUnmappedMode code '"+codeString+"'");
        }
    public String toCode(ConceptMapGroupUnmappedMode code) {
      if (code == ConceptMapGroupUnmappedMode.USESOURCECODE)
        return "use-source-code";
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
         * An absolute URI that identifies the source system where the concepts to be mapped are defined.
         */
        @Child(name = "source", type = {CanonicalType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Source system where concepts to be mapped are defined", formalDefinition="An absolute URI that identifies the source system where the concepts to be mapped are defined." )
        protected CanonicalType source;

        /**
         * An absolute URI that identifies the target system that the concepts will be mapped to.
         */
        @Child(name = "target", type = {CanonicalType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Target system that the concepts are to be mapped to", formalDefinition="An absolute URI that identifies the target system that the concepts will be mapped to." )
        protected CanonicalType target;

        /**
         * Mappings for an individual concept in the source to one or more concepts in the target.
         */
        @Child(name = "element", type = {}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Mappings for a concept from the source set", formalDefinition="Mappings for an individual concept in the source to one or more concepts in the target." )
        protected List<SourceElementComponent> element;

        /**
         * What to do when there is no mapping to a target concept from the source concept.  This provides the "default" to be applied when there is no target concept mapping specified.  The 'unmapped' element is ignored if a code is specified to have relationship = not-related-to.
         */
        @Child(name = "unmapped", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What to do when there is no mapping target for the source concept", formalDefinition="What to do when there is no mapping to a target concept from the source concept.  This provides the \"default\" to be applied when there is no target concept mapping specified.  The 'unmapped' element is ignored if a code is specified to have relationship = not-related-to." )
        protected ConceptMapGroupUnmappedComponent unmapped;

        private static final long serialVersionUID = 1307192416L;

    /**
     * Constructor
     */
      public ConceptMapGroupComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConceptMapGroupComponent(SourceElementComponent element) {
        super();
        this.addElement(element);
      }

        /**
         * @return {@link #source} (An absolute URI that identifies the source system where the concepts to be mapped are defined.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public CanonicalType getSourceElement() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConceptMapGroupComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new CanonicalType(); // bb
          return this.source;
        }

        public boolean hasSourceElement() { 
          return this.source != null && !this.source.isEmpty();
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (An absolute URI that identifies the source system where the concepts to be mapped are defined.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public ConceptMapGroupComponent setSourceElement(CanonicalType value) { 
          this.source = value;
          return this;
        }

        /**
         * @return An absolute URI that identifies the source system where the concepts to be mapped are defined.
         */
        public String getSource() { 
          return this.source == null ? null : this.source.getValue();
        }

        /**
         * @param value An absolute URI that identifies the source system where the concepts to be mapped are defined.
         */
        public ConceptMapGroupComponent setSource(String value) { 
          if (Utilities.noString(value))
            this.source = null;
          else {
            if (this.source == null)
              this.source = new CanonicalType();
            this.source.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #target} (An absolute URI that identifies the target system that the concepts will be mapped to.). This is the underlying object with id, value and extensions. The accessor "getTarget" gives direct access to the value
         */
        public CanonicalType getTargetElement() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConceptMapGroupComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new CanonicalType(); // bb
          return this.target;
        }

        public boolean hasTargetElement() { 
          return this.target != null && !this.target.isEmpty();
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (An absolute URI that identifies the target system that the concepts will be mapped to.). This is the underlying object with id, value and extensions. The accessor "getTarget" gives direct access to the value
         */
        public ConceptMapGroupComponent setTargetElement(CanonicalType value) { 
          this.target = value;
          return this;
        }

        /**
         * @return An absolute URI that identifies the target system that the concepts will be mapped to.
         */
        public String getTarget() { 
          return this.target == null ? null : this.target.getValue();
        }

        /**
         * @param value An absolute URI that identifies the target system that the concepts will be mapped to.
         */
        public ConceptMapGroupComponent setTarget(String value) { 
          if (Utilities.noString(value))
            this.target = null;
          else {
            if (this.target == null)
              this.target = new CanonicalType();
            this.target.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #element} (Mappings for an individual concept in the source to one or more concepts in the target.)
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

        public SourceElementComponent addElement() { //3
          SourceElementComponent t = new SourceElementComponent();
          if (this.element == null)
            this.element = new ArrayList<SourceElementComponent>();
          this.element.add(t);
          return t;
        }

        public ConceptMapGroupComponent addElement(SourceElementComponent t) { //3
          if (t == null)
            return this;
          if (this.element == null)
            this.element = new ArrayList<SourceElementComponent>();
          this.element.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #element}, creating it if it does not already exist {3}
         */
        public SourceElementComponent getElementFirstRep() { 
          if (getElement().isEmpty()) {
            addElement();
          }
          return getElement().get(0);
        }

        /**
         * @return {@link #unmapped} (What to do when there is no mapping to a target concept from the source concept.  This provides the "default" to be applied when there is no target concept mapping specified.  The 'unmapped' element is ignored if a code is specified to have relationship = not-related-to.)
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
         * @param value {@link #unmapped} (What to do when there is no mapping to a target concept from the source concept.  This provides the "default" to be applied when there is no target concept mapping specified.  The 'unmapped' element is ignored if a code is specified to have relationship = not-related-to.)
         */
        public ConceptMapGroupComponent setUnmapped(ConceptMapGroupUnmappedComponent value) { 
          this.unmapped = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("source", "canonical(CodeSystem)", "An absolute URI that identifies the source system where the concepts to be mapped are defined.", 0, 1, source));
          children.add(new Property("target", "canonical(CodeSystem)", "An absolute URI that identifies the target system that the concepts will be mapped to.", 0, 1, target));
          children.add(new Property("element", "", "Mappings for an individual concept in the source to one or more concepts in the target.", 0, java.lang.Integer.MAX_VALUE, element));
          children.add(new Property("unmapped", "", "What to do when there is no mapping to a target concept from the source concept.  This provides the \"default\" to be applied when there is no target concept mapping specified.  The 'unmapped' element is ignored if a code is specified to have relationship = not-related-to.", 0, 1, unmapped));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -896505829: /*source*/  return new Property("source", "canonical(CodeSystem)", "An absolute URI that identifies the source system where the concepts to be mapped are defined.", 0, 1, source);
          case -880905839: /*target*/  return new Property("target", "canonical(CodeSystem)", "An absolute URI that identifies the target system that the concepts will be mapped to.", 0, 1, target);
          case -1662836996: /*element*/  return new Property("element", "", "Mappings for an individual concept in the source to one or more concepts in the target.", 0, java.lang.Integer.MAX_VALUE, element);
          case -194857460: /*unmapped*/  return new Property("unmapped", "", "What to do when there is no mapping to a target concept from the source concept.  This provides the \"default\" to be applied when there is no target concept mapping specified.  The 'unmapped' element is ignored if a code is specified to have relationship = not-related-to.", 0, 1, unmapped);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // CanonicalType
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // CanonicalType
        case -1662836996: /*element*/ return this.element == null ? new Base[0] : this.element.toArray(new Base[this.element.size()]); // SourceElementComponent
        case -194857460: /*unmapped*/ return this.unmapped == null ? new Base[0] : new Base[] {this.unmapped}; // ConceptMapGroupUnmappedComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -896505829: // source
          this.source = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -880905839: // target
          this.target = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1662836996: // element
          this.getElement().add((SourceElementComponent) value); // SourceElementComponent
          return value;
        case -194857460: // unmapped
          this.unmapped = (ConceptMapGroupUnmappedComponent) value; // ConceptMapGroupUnmappedComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("source")) {
          this.source = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("target")) {
          this.target = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("element")) {
          this.getElement().add((SourceElementComponent) value);
        } else if (name.equals("unmapped")) {
          this.unmapped = (ConceptMapGroupUnmappedComponent) value; // ConceptMapGroupUnmappedComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -896505829:  return getSourceElement();
        case -880905839:  return getTargetElement();
        case -1662836996:  return addElement(); 
        case -194857460:  return getUnmapped();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -896505829: /*source*/ return new String[] {"canonical"};
        case -880905839: /*target*/ return new String[] {"canonical"};
        case -1662836996: /*element*/ return new String[] {};
        case -194857460: /*unmapped*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("source")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.source");
        }
        else if (name.equals("target")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.target");
        }
        else if (name.equals("element")) {
          return addElement();
        }
        else if (name.equals("unmapped")) {
          this.unmapped = new ConceptMapGroupUnmappedComponent();
          return this.unmapped;
        }
        else
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
        dst.target = target == null ? null : target.copy();
        if (element != null) {
          dst.element = new ArrayList<SourceElementComponent>();
          for (SourceElementComponent i : element)
            dst.element.add(i.copy());
        };
        dst.unmapped = unmapped == null ? null : unmapped.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConceptMapGroupComponent))
          return false;
        ConceptMapGroupComponent o = (ConceptMapGroupComponent) other_;
        return compareDeep(source, o.source, true) && compareDeep(target, o.target, true) && compareDeep(element, o.element, true)
           && compareDeep(unmapped, o.unmapped, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConceptMapGroupComponent))
          return false;
        ConceptMapGroupComponent o = (ConceptMapGroupComponent) other_;
        return compareValues(source, o.source, true) && compareValues(target, o.target, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(source, target, element
          , unmapped);
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
        @Child(name = "code", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Identifies element being mapped", formalDefinition="Identity (code or path) or the element/item being mapped." )
        protected CodeType code;

        /**
         * The display for the code. The display is only provided to help editors when editing the concept map.
         */
        @Child(name = "display", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Display for the code", formalDefinition="The display for the code. The display is only provided to help editors when editing the concept map." )
        protected StringType display;

        /**
         * The set of codes being mapped.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Identifies elements being mapped", formalDefinition="The set of codes being mapped." )
        protected CanonicalType valueSet;

        /**
         * If noMap = true this indicates that no mapping to a target concept exists for this source concept.
         */
        @Child(name = "noMap", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="No mapping to a target concept for this source concept", formalDefinition="If noMap = true this indicates that no mapping to a target concept exists for this source concept." )
        protected BooleanType noMap;

        /**
         * A concept from the target value set that this concept maps to.
         */
        @Child(name = "target", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Concept in target system for element", formalDefinition="A concept from the target value set that this concept maps to." )
        protected List<TargetElementComponent> target;

        private static final long serialVersionUID = 1485743554L;

    /**
     * Constructor
     */
      public SourceElementComponent() {
        super();
      }

        /**
         * @return {@link #code} (Identity (code or path) or the element/item being mapped.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
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
         * @param value {@link #code} (Identity (code or path) or the element/item being mapped.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
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
         * @return {@link #display} (The display for the code. The display is only provided to help editors when editing the concept map.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
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
         * @param value {@link #display} (The display for the code. The display is only provided to help editors when editing the concept map.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public SourceElementComponent setDisplayElement(StringType value) { 
          this.display = value;
          return this;
        }

        /**
         * @return The display for the code. The display is only provided to help editors when editing the concept map.
         */
        public String getDisplay() { 
          return this.display == null ? null : this.display.getValue();
        }

        /**
         * @param value The display for the code. The display is only provided to help editors when editing the concept map.
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
         * @return {@link #valueSet} (The set of codes being mapped.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SourceElementComponent.valueSet");
            else if (Configuration.doAutoCreate())
              this.valueSet = new CanonicalType(); // bb
          return this.valueSet;
        }

        public boolean hasValueSetElement() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        public boolean hasValueSet() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        /**
         * @param value {@link #valueSet} (The set of codes being mapped.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public SourceElementComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return The set of codes being mapped.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value The set of codes being mapped.
         */
        public SourceElementComponent setValueSet(String value) { 
          if (Utilities.noString(value))
            this.valueSet = null;
          else {
            if (this.valueSet == null)
              this.valueSet = new CanonicalType();
            this.valueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #noMap} (If noMap = true this indicates that no mapping to a target concept exists for this source concept.). This is the underlying object with id, value and extensions. The accessor "getNoMap" gives direct access to the value
         */
        public BooleanType getNoMapElement() { 
          if (this.noMap == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SourceElementComponent.noMap");
            else if (Configuration.doAutoCreate())
              this.noMap = new BooleanType(); // bb
          return this.noMap;
        }

        public boolean hasNoMapElement() { 
          return this.noMap != null && !this.noMap.isEmpty();
        }

        public boolean hasNoMap() { 
          return this.noMap != null && !this.noMap.isEmpty();
        }

        /**
         * @param value {@link #noMap} (If noMap = true this indicates that no mapping to a target concept exists for this source concept.). This is the underlying object with id, value and extensions. The accessor "getNoMap" gives direct access to the value
         */
        public SourceElementComponent setNoMapElement(BooleanType value) { 
          this.noMap = value;
          return this;
        }

        /**
         * @return If noMap = true this indicates that no mapping to a target concept exists for this source concept.
         */
        public boolean getNoMap() { 
          return this.noMap == null || this.noMap.isEmpty() ? false : this.noMap.getValue();
        }

        /**
         * @param value If noMap = true this indicates that no mapping to a target concept exists for this source concept.
         */
        public SourceElementComponent setNoMap(boolean value) { 
            if (this.noMap == null)
              this.noMap = new BooleanType();
            this.noMap.setValue(value);
          return this;
        }

        /**
         * @return {@link #target} (A concept from the target value set that this concept maps to.)
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

        public TargetElementComponent addTarget() { //3
          TargetElementComponent t = new TargetElementComponent();
          if (this.target == null)
            this.target = new ArrayList<TargetElementComponent>();
          this.target.add(t);
          return t;
        }

        public SourceElementComponent addTarget(TargetElementComponent t) { //3
          if (t == null)
            return this;
          if (this.target == null)
            this.target = new ArrayList<TargetElementComponent>();
          this.target.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #target}, creating it if it does not already exist {3}
         */
        public TargetElementComponent getTargetFirstRep() { 
          if (getTarget().isEmpty()) {
            addTarget();
          }
          return getTarget().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "Identity (code or path) or the element/item being mapped.", 0, 1, code));
          children.add(new Property("display", "string", "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1, display));
          children.add(new Property("valueSet", "canonical(ValueSet)", "The set of codes being mapped.", 0, 1, valueSet));
          children.add(new Property("noMap", "boolean", "If noMap = true this indicates that no mapping to a target concept exists for this source concept.", 0, 1, noMap));
          children.add(new Property("target", "", "A concept from the target value set that this concept maps to.", 0, java.lang.Integer.MAX_VALUE, target));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "Identity (code or path) or the element/item being mapped.", 0, 1, code);
          case 1671764162: /*display*/  return new Property("display", "string", "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1, display);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "The set of codes being mapped.", 0, 1, valueSet);
          case 104971227: /*noMap*/  return new Property("noMap", "boolean", "If noMap = true this indicates that no mapping to a target concept exists for this source concept.", 0, 1, noMap);
          case -880905839: /*target*/  return new Property("target", "", "A concept from the target value set that this concept maps to.", 0, java.lang.Integer.MAX_VALUE, target);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        case 104971227: /*noMap*/ return this.noMap == null ? new Base[0] : new Base[] {this.noMap}; // BooleanType
        case -880905839: /*target*/ return this.target == null ? new Base[0] : this.target.toArray(new Base[this.target.size()]); // TargetElementComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 1671764162: // display
          this.display = TypeConvertor.castToString(value); // StringType
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 104971227: // noMap
          this.noMap = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -880905839: // target
          this.getTarget().add((TargetElementComponent) value); // TargetElementComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("display")) {
          this.display = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("noMap")) {
          this.noMap = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("target")) {
          this.getTarget().add((TargetElementComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 1671764162:  return getDisplayElement();
        case -1410174671:  return getValueSetElement();
        case 104971227:  return getNoMapElement();
        case -880905839:  return addTarget(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 1671764162: /*display*/ return new String[] {"string"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        case 104971227: /*noMap*/ return new String[] {"boolean"};
        case -880905839: /*target*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.code");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.display");
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.valueSet");
        }
        else if (name.equals("noMap")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.noMap");
        }
        else if (name.equals("target")) {
          return addTarget();
        }
        else
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
        dst.valueSet = valueSet == null ? null : valueSet.copy();
        dst.noMap = noMap == null ? null : noMap.copy();
        if (target != null) {
          dst.target = new ArrayList<TargetElementComponent>();
          for (TargetElementComponent i : target)
            dst.target.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SourceElementComponent))
          return false;
        SourceElementComponent o = (SourceElementComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(display, o.display, true) && compareDeep(valueSet, o.valueSet, true)
           && compareDeep(noMap, o.noMap, true) && compareDeep(target, o.target, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SourceElementComponent))
          return false;
        SourceElementComponent o = (SourceElementComponent) other_;
        return compareValues(code, o.code, true) && compareValues(display, o.display, true) && compareValues(valueSet, o.valueSet, true)
           && compareValues(noMap, o.noMap, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, display, valueSet
          , noMap, target);
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
        @Child(name = "code", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code that identifies the target element", formalDefinition="Identity (code or path) or the element/item that the map refers to." )
        protected CodeType code;

        /**
         * The display for the code. The display is only provided to help editors when editing the concept map.
         */
        @Child(name = "display", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Display for the code", formalDefinition="The display for the code. The display is only provided to help editors when editing the concept map." )
        protected StringType display;

        /**
         * The set of codes that the map refers to.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Identifies the set of target elements", formalDefinition="The set of codes that the map refers to." )
        protected CanonicalType valueSet;

        /**
         * The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).
         */
        @Child(name = "relationship", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=false)
        @Description(shortDefinition="related-to | equivalent | source-is-narrower-than-target | source-is-broader-than-target | not-related-to", formalDefinition="The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/concept-map-relationship")
        protected Enumeration<ConceptMapRelationship> relationship;

        /**
         * A description of status/issues in mapping that conveys additional information not represented in  the structured data.
         */
        @Child(name = "comment", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of status/issues in mapping", formalDefinition="A description of status/issues in mapping that conveys additional information not represented in  the structured data." )
        protected StringType comment;

        /**
         * A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified property can be resolved, and it has the specified value.
         */
        @Child(name = "dependsOn", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Other properties required for this mapping", formalDefinition="A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified property can be resolved, and it has the specified value." )
        protected List<OtherElementComponent> dependsOn;

        /**
         * Product is the output of a ConceptMap that provides additional values relevant to the interpretation of the mapping target.
         */
        @Child(name = "product", type = {OtherElementComponent.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Other properties that this mapping also produces", formalDefinition="Product is the output of a ConceptMap that provides additional values relevant to the interpretation of the mapping target." )
        protected List<OtherElementComponent> product;

        private static final long serialVersionUID = 1705844456L;

    /**
     * Constructor
     */
      public TargetElementComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TargetElementComponent(ConceptMapRelationship relationship) {
        super();
        this.setRelationship(relationship);
      }

        /**
         * @return {@link #code} (Identity (code or path) or the element/item that the map refers to.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
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
         * @param value {@link #code} (Identity (code or path) or the element/item that the map refers to.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
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
         * @param value Identity (code or path) or the element/item that the map refers to.
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
         * @return {@link #display} (The display for the code. The display is only provided to help editors when editing the concept map.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
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
         * @param value {@link #display} (The display for the code. The display is only provided to help editors when editing the concept map.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public TargetElementComponent setDisplayElement(StringType value) { 
          this.display = value;
          return this;
        }

        /**
         * @return The display for the code. The display is only provided to help editors when editing the concept map.
         */
        public String getDisplay() { 
          return this.display == null ? null : this.display.getValue();
        }

        /**
         * @param value The display for the code. The display is only provided to help editors when editing the concept map.
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
         * @return {@link #valueSet} (The set of codes that the map refers to.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TargetElementComponent.valueSet");
            else if (Configuration.doAutoCreate())
              this.valueSet = new CanonicalType(); // bb
          return this.valueSet;
        }

        public boolean hasValueSetElement() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        public boolean hasValueSet() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        /**
         * @param value {@link #valueSet} (The set of codes that the map refers to.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public TargetElementComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return The set of codes that the map refers to.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value The set of codes that the map refers to.
         */
        public TargetElementComponent setValueSet(String value) { 
          if (Utilities.noString(value))
            this.valueSet = null;
          else {
            if (this.valueSet == null)
              this.valueSet = new CanonicalType();
            this.valueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #relationship} (The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public Enumeration<ConceptMapRelationship> getRelationshipElement() { 
          if (this.relationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TargetElementComponent.relationship");
            else if (Configuration.doAutoCreate())
              this.relationship = new Enumeration<ConceptMapRelationship>(new ConceptMapRelationshipEnumFactory()); // bb
          return this.relationship;
        }

        public boolean hasRelationshipElement() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        public boolean hasRelationship() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        /**
         * @param value {@link #relationship} (The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public TargetElementComponent setRelationshipElement(Enumeration<ConceptMapRelationship> value) { 
          this.relationship = value;
          return this;
        }

        /**
         * @return The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).
         */
        public ConceptMapRelationship getRelationship() { 
          return this.relationship == null ? null : this.relationship.getValue();
        }

        /**
         * @param value The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).
         */
        public TargetElementComponent setRelationship(ConceptMapRelationship value) { 
            if (this.relationship == null)
              this.relationship = new Enumeration<ConceptMapRelationship>(new ConceptMapRelationshipEnumFactory());
            this.relationship.setValue(value);
          return this;
        }

        /**
         * @return {@link #comment} (A description of status/issues in mapping that conveys additional information not represented in  the structured data.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
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
         * @param value {@link #comment} (A description of status/issues in mapping that conveys additional information not represented in  the structured data.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public TargetElementComponent setCommentElement(StringType value) { 
          this.comment = value;
          return this;
        }

        /**
         * @return A description of status/issues in mapping that conveys additional information not represented in  the structured data.
         */
        public String getComment() { 
          return this.comment == null ? null : this.comment.getValue();
        }

        /**
         * @param value A description of status/issues in mapping that conveys additional information not represented in  the structured data.
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
         * @return {@link #dependsOn} (A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified property can be resolved, and it has the specified value.)
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

        public OtherElementComponent addDependsOn() { //3
          OtherElementComponent t = new OtherElementComponent();
          if (this.dependsOn == null)
            this.dependsOn = new ArrayList<OtherElementComponent>();
          this.dependsOn.add(t);
          return t;
        }

        public TargetElementComponent addDependsOn(OtherElementComponent t) { //3
          if (t == null)
            return this;
          if (this.dependsOn == null)
            this.dependsOn = new ArrayList<OtherElementComponent>();
          this.dependsOn.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dependsOn}, creating it if it does not already exist {3}
         */
        public OtherElementComponent getDependsOnFirstRep() { 
          if (getDependsOn().isEmpty()) {
            addDependsOn();
          }
          return getDependsOn().get(0);
        }

        /**
         * @return {@link #product} (Product is the output of a ConceptMap that provides additional values relevant to the interpretation of the mapping target.)
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

        public OtherElementComponent addProduct() { //3
          OtherElementComponent t = new OtherElementComponent();
          if (this.product == null)
            this.product = new ArrayList<OtherElementComponent>();
          this.product.add(t);
          return t;
        }

        public TargetElementComponent addProduct(OtherElementComponent t) { //3
          if (t == null)
            return this;
          if (this.product == null)
            this.product = new ArrayList<OtherElementComponent>();
          this.product.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #product}, creating it if it does not already exist {3}
         */
        public OtherElementComponent getProductFirstRep() { 
          if (getProduct().isEmpty()) {
            addProduct();
          }
          return getProduct().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "Identity (code or path) or the element/item that the map refers to.", 0, 1, code));
          children.add(new Property("display", "string", "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1, display));
          children.add(new Property("valueSet", "canonical(ValueSet)", "The set of codes that the map refers to.", 0, 1, valueSet));
          children.add(new Property("relationship", "code", "The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).", 0, 1, relationship));
          children.add(new Property("comment", "string", "A description of status/issues in mapping that conveys additional information not represented in  the structured data.", 0, 1, comment));
          children.add(new Property("dependsOn", "", "A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified property can be resolved, and it has the specified value.", 0, java.lang.Integer.MAX_VALUE, dependsOn));
          children.add(new Property("product", "@ConceptMap.group.element.target.dependsOn", "Product is the output of a ConceptMap that provides additional values relevant to the interpretation of the mapping target.", 0, java.lang.Integer.MAX_VALUE, product));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "Identity (code or path) or the element/item that the map refers to.", 0, 1, code);
          case 1671764162: /*display*/  return new Property("display", "string", "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1, display);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "The set of codes that the map refers to.", 0, 1, valueSet);
          case -261851592: /*relationship*/  return new Property("relationship", "code", "The relationship between the source and target concepts. The relationship is read from source to target (e.g. source-is-narrower-than-target).", 0, 1, relationship);
          case 950398559: /*comment*/  return new Property("comment", "string", "A description of status/issues in mapping that conveys additional information not represented in  the structured data.", 0, 1, comment);
          case -1109214266: /*dependsOn*/  return new Property("dependsOn", "", "A set of additional dependencies for this mapping to hold. This mapping is only applicable if the specified property can be resolved, and it has the specified value.", 0, java.lang.Integer.MAX_VALUE, dependsOn);
          case -309474065: /*product*/  return new Property("product", "@ConceptMap.group.element.target.dependsOn", "Product is the output of a ConceptMap that provides additional values relevant to the interpretation of the mapping target.", 0, java.lang.Integer.MAX_VALUE, product);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // Enumeration<ConceptMapRelationship>
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        case -1109214266: /*dependsOn*/ return this.dependsOn == null ? new Base[0] : this.dependsOn.toArray(new Base[this.dependsOn.size()]); // OtherElementComponent
        case -309474065: /*product*/ return this.product == null ? new Base[0] : this.product.toArray(new Base[this.product.size()]); // OtherElementComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 1671764162: // display
          this.display = TypeConvertor.castToString(value); // StringType
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -261851592: // relationship
          value = new ConceptMapRelationshipEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ConceptMapRelationship>
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        case -1109214266: // dependsOn
          this.getDependsOn().add((OtherElementComponent) value); // OtherElementComponent
          return value;
        case -309474065: // product
          this.getProduct().add((OtherElementComponent) value); // OtherElementComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("display")) {
          this.display = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("relationship")) {
          value = new ConceptMapRelationshipEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ConceptMapRelationship>
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("dependsOn")) {
          this.getDependsOn().add((OtherElementComponent) value);
        } else if (name.equals("product")) {
          this.getProduct().add((OtherElementComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 1671764162:  return getDisplayElement();
        case -1410174671:  return getValueSetElement();
        case -261851592:  return getRelationshipElement();
        case 950398559:  return getCommentElement();
        case -1109214266:  return addDependsOn(); 
        case -309474065:  return addProduct(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 1671764162: /*display*/ return new String[] {"string"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        case -261851592: /*relationship*/ return new String[] {"code"};
        case 950398559: /*comment*/ return new String[] {"string"};
        case -1109214266: /*dependsOn*/ return new String[] {};
        case -309474065: /*product*/ return new String[] {"@ConceptMap.group.element.target.dependsOn"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.code");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.display");
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.valueSet");
        }
        else if (name.equals("relationship")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.relationship");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.comment");
        }
        else if (name.equals("dependsOn")) {
          return addDependsOn();
        }
        else if (name.equals("product")) {
          return addProduct();
        }
        else
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
        dst.valueSet = valueSet == null ? null : valueSet.copy();
        dst.relationship = relationship == null ? null : relationship.copy();
        dst.comment = comment == null ? null : comment.copy();
        if (dependsOn != null) {
          dst.dependsOn = new ArrayList<OtherElementComponent>();
          for (OtherElementComponent i : dependsOn)
            dst.dependsOn.add(i.copy());
        };
        if (product != null) {
          dst.product = new ArrayList<OtherElementComponent>();
          for (OtherElementComponent i : product)
            dst.product.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TargetElementComponent))
          return false;
        TargetElementComponent o = (TargetElementComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(display, o.display, true) && compareDeep(valueSet, o.valueSet, true)
           && compareDeep(relationship, o.relationship, true) && compareDeep(comment, o.comment, true) && compareDeep(dependsOn, o.dependsOn, true)
           && compareDeep(product, o.product, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TargetElementComponent))
          return false;
        TargetElementComponent o = (TargetElementComponent) other_;
        return compareValues(code, o.code, true) && compareValues(display, o.display, true) && compareValues(valueSet, o.valueSet, true)
           && compareValues(relationship, o.relationship, true) && compareValues(comment, o.comment, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, display, valueSet
          , relationship, comment, dependsOn, product);
      }

  public String fhirType() {
    return "ConceptMap.group.element.target";

  }

  }

    @Block()
    public static class OtherElementComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.
         */
        @Child(name = "property", type = {UriType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A reference to a property that may be required to refine the mapping", formalDefinition="A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets." )
        protected UriType property;

        /**
         * Property value that the map depends on.
         */
        @Child(name = "value", type = {CodeType.class, Coding.class, StringType.class, IntegerType.class, BooleanType.class, DateTimeType.class, DecimalType.class, UriType.class, IdType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of the referenced property", formalDefinition="Property value that the map depends on." )
        protected DataType value;

        /**
         * This mapping applies if the property value is a code from this value set.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The mapping depends on a property with a value from this value set", formalDefinition="This mapping applies if the property value is a code from this value set." )
        protected CanonicalType valueSet;

        private static final long serialVersionUID = -2108798167L;

    /**
     * Constructor
     */
      public OtherElementComponent() {
        super();
      }

    /**
     * Constructor
     */
      public OtherElementComponent(String property) {
        super();
        this.setProperty(property);
      }

        /**
         * @return {@link #property} (A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.). This is the underlying object with id, value and extensions. The accessor "getProperty" gives direct access to the value
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
         * @param value {@link #property} (A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.). This is the underlying object with id, value and extensions. The accessor "getProperty" gives direct access to the value
         */
        public OtherElementComponent setPropertyElement(UriType value) { 
          this.property = value;
          return this;
        }

        /**
         * @return A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.
         */
        public String getProperty() { 
          return this.property == null ? null : this.property.getValue();
        }

        /**
         * @param value A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.
         */
        public OtherElementComponent setProperty(String value) { 
            if (this.property == null)
              this.property = new UriType();
            this.property.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (Property value that the map depends on.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Property value that the map depends on.)
         */
        public CodeType getValueCodeType() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeType();
          if (!(this.value instanceof CodeType))
            throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeType) this.value;
        }

        public boolean hasValueCodeType() { 
          return this != null && this.value instanceof CodeType;
        }

        /**
         * @return {@link #value} (Property value that the map depends on.)
         */
        public Coding getValueCoding() throws FHIRException { 
          if (this.value == null)
            this.value = new Coding();
          if (!(this.value instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Coding) this.value;
        }

        public boolean hasValueCoding() { 
          return this != null && this.value instanceof Coding;
        }

        /**
         * @return {@link #value} (Property value that the map depends on.)
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
         * @return {@link #value} (Property value that the map depends on.)
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
         * @return {@link #value} (Property value that the map depends on.)
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
         * @return {@link #value} (Property value that the map depends on.)
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
         * @return {@link #value} (Property value that the map depends on.)
         */
        public DecimalType getValueDecimalType() throws FHIRException { 
          if (this.value == null)
            this.value = new DecimalType();
          if (!(this.value instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DecimalType) this.value;
        }

        public boolean hasValueDecimalType() { 
          return this != null && this.value instanceof DecimalType;
        }

        /**
         * @return {@link #value} (Property value that the map depends on.)
         */
        public UriType getValueUriType() throws FHIRException { 
          if (this.value == null)
            this.value = new UriType();
          if (!(this.value instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UriType) this.value;
        }

        public boolean hasValueUriType() { 
          return this != null && this.value instanceof UriType;
        }

        /**
         * @return {@link #value} (Property value that the map depends on.)
         */
        public IdType getValueIdType() throws FHIRException { 
          if (this.value == null)
            this.value = new IdType();
          if (!(this.value instanceof IdType))
            throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IdType) this.value;
        }

        public boolean hasValueIdType() { 
          return this != null && this.value instanceof IdType;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Property value that the map depends on.)
         */
        public OtherElementComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeType || value instanceof Coding || value instanceof StringType || value instanceof IntegerType || value instanceof BooleanType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof UriType || value instanceof IdType))
            throw new Error("Not the right type for ConceptMap.group.element.target.dependsOn.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #valueSet} (This mapping applies if the property value is a code from this value set.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OtherElementComponent.valueSet");
            else if (Configuration.doAutoCreate())
              this.valueSet = new CanonicalType(); // bb
          return this.valueSet;
        }

        public boolean hasValueSetElement() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        public boolean hasValueSet() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        /**
         * @param value {@link #valueSet} (This mapping applies if the property value is a code from this value set.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public OtherElementComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return This mapping applies if the property value is a code from this value set.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value This mapping applies if the property value is a code from this value set.
         */
        public OtherElementComponent setValueSet(String value) { 
          if (Utilities.noString(value))
            this.valueSet = null;
          else {
            if (this.valueSet == null)
              this.valueSet = new CanonicalType();
            this.valueSet.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("property", "uri", "A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.", 0, 1, property));
          children.add(new Property("value[x]", "code|Coding|string|integer|boolean|dateTime|decimal|uri|id", "Property value that the map depends on.", 0, 1, value));
          children.add(new Property("valueSet", "canonical(ValueSet)", "This mapping applies if the property value is a code from this value set.", 0, 1, valueSet));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -993141291: /*property*/  return new Property("property", "uri", "A reference to a property that holds a value the map depends on. This value can be supplied to the $translate operation to select the appropriate targets.", 0, 1, property);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "code|Coding|string|integer|boolean|dateTime|decimal|uri|id", "Property value that the map depends on.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "code|Coding|string|integer|boolean|dateTime|decimal|uri|id", "Property value that the map depends on.", 0, 1, value);
          case -766209282: /*valueCode*/  return new Property("value[x]", "code", "Property value that the map depends on.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "Property value that the map depends on.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "Property value that the map depends on.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "Property value that the map depends on.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Property value that the map depends on.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "Property value that the map depends on.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "Property value that the map depends on.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "Property value that the map depends on.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "Property value that the map depends on.", 0, 1, value);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "This mapping applies if the property value is a code from this value set.", 0, 1, valueSet);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -993141291: /*property*/ return this.property == null ? new Base[0] : new Base[] {this.property}; // UriType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -993141291: // property
          this.property = TypeConvertor.castToUri(value); // UriType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("property")) {
          this.property = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -993141291:  return getPropertyElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -1410174671:  return getValueSetElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -993141291: /*property*/ return new String[] {"uri"};
        case 111972721: /*value*/ return new String[] {"code", "Coding", "string", "integer", "boolean", "dateTime", "decimal", "uri", "id"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("property")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.dependsOn.property");
        }
        else if (name.equals("valueCode")) {
          this.value = new CodeType();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueId")) {
          this.value = new IdType();
          return this.value;
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.element.target.dependsOn.valueSet");
        }
        else
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
        dst.value = value == null ? null : value.copy();
        dst.valueSet = valueSet == null ? null : valueSet.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OtherElementComponent))
          return false;
        OtherElementComponent o = (OtherElementComponent) other_;
        return compareDeep(property, o.property, true) && compareDeep(value, o.value, true) && compareDeep(valueSet, o.valueSet, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OtherElementComponent))
          return false;
        OtherElementComponent o = (OtherElementComponent) other_;
        return compareValues(property, o.property, true) && compareValues(valueSet, o.valueSet, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(property, value, valueSet
          );
      }

  public String fhirType() {
    return "ConceptMap.group.element.target.dependsOn";

  }

  }

    @Block()
    public static class ConceptMapGroupUnmappedComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).
         */
        @Child(name = "mode", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="use-source-code | fixed | other-map", formalDefinition="Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/conceptmap-unmapped-mode")
        protected Enumeration<ConceptMapGroupUnmappedMode> mode;

        /**
         * The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.
         */
        @Child(name = "code", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixed code when mode = fixed", formalDefinition="The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code." )
        protected CodeType code;

        /**
         * The display for the code. The display is only provided to help editors when editing the concept map.
         */
        @Child(name = "display", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Display for the code", formalDefinition="The display for the code. The display is only provided to help editors when editing the concept map." )
        protected StringType display;

        /**
         * The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixed code set when mode = fixed", formalDefinition="The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes." )
        protected CanonicalType valueSet;

        /**
         * The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.
         */
        @Child(name = "relationship", type = {CodeType.class}, order=5, min=0, max=1, modifier=true, summary=false)
        @Description(shortDefinition="related-to | equivalent | source-is-narrower-than-target | source-is-broader-than-target | not-related-to", formalDefinition="The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/concept-map-relationship")
        protected Enumeration<ConceptMapRelationship> relationship;

        /**
         * The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.
         */
        @Child(name = "otherMap", type = {CanonicalType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="canonical reference to an additional ConceptMap to use for mapping if the source concept is unmapped", formalDefinition="The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept." )
        protected CanonicalType otherMap;

        private static final long serialVersionUID = 449945387L;

    /**
     * Constructor
     */
      public ConceptMapGroupUnmappedComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConceptMapGroupUnmappedComponent(ConceptMapGroupUnmappedMode mode) {
        super();
        this.setMode(mode);
      }

        /**
         * @return {@link #mode} (Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
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
         * @param value {@link #mode} (Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public ConceptMapGroupUnmappedComponent setModeElement(Enumeration<ConceptMapGroupUnmappedMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).
         */
        public ConceptMapGroupUnmappedMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).
         */
        public ConceptMapGroupUnmappedComponent setMode(ConceptMapGroupUnmappedMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<ConceptMapGroupUnmappedMode>(new ConceptMapGroupUnmappedModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #code} (The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
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
         * @param value {@link #code} (The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public ConceptMapGroupUnmappedComponent setCodeElement(CodeType value) { 
          this.code = value;
          return this;
        }

        /**
         * @return The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.
         */
        public String getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.
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
         * @return {@link #display} (The display for the code. The display is only provided to help editors when editing the concept map.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
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
         * @param value {@link #display} (The display for the code. The display is only provided to help editors when editing the concept map.). This is the underlying object with id, value and extensions. The accessor "getDisplay" gives direct access to the value
         */
        public ConceptMapGroupUnmappedComponent setDisplayElement(StringType value) { 
          this.display = value;
          return this;
        }

        /**
         * @return The display for the code. The display is only provided to help editors when editing the concept map.
         */
        public String getDisplay() { 
          return this.display == null ? null : this.display.getValue();
        }

        /**
         * @param value The display for the code. The display is only provided to help editors when editing the concept map.
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
         * @return {@link #valueSet} (The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.valueSet");
            else if (Configuration.doAutoCreate())
              this.valueSet = new CanonicalType(); // bb
          return this.valueSet;
        }

        public boolean hasValueSetElement() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        public boolean hasValueSet() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        /**
         * @param value {@link #valueSet} (The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public ConceptMapGroupUnmappedComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.
         */
        public ConceptMapGroupUnmappedComponent setValueSet(String value) { 
          if (Utilities.noString(value))
            this.valueSet = null;
          else {
            if (this.valueSet == null)
              this.valueSet = new CanonicalType();
            this.valueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #relationship} (The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public Enumeration<ConceptMapRelationship> getRelationshipElement() { 
          if (this.relationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.relationship");
            else if (Configuration.doAutoCreate())
              this.relationship = new Enumeration<ConceptMapRelationship>(new ConceptMapRelationshipEnumFactory()); // bb
          return this.relationship;
        }

        public boolean hasRelationshipElement() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        public boolean hasRelationship() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        /**
         * @param value {@link #relationship} (The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public ConceptMapGroupUnmappedComponent setRelationshipElement(Enumeration<ConceptMapRelationship> value) { 
          this.relationship = value;
          return this;
        }

        /**
         * @return The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.
         */
        public ConceptMapRelationship getRelationship() { 
          return this.relationship == null ? null : this.relationship.getValue();
        }

        /**
         * @param value The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.
         */
        public ConceptMapGroupUnmappedComponent setRelationship(ConceptMapRelationship value) { 
          if (value == null)
            this.relationship = null;
          else {
            if (this.relationship == null)
              this.relationship = new Enumeration<ConceptMapRelationship>(new ConceptMapRelationshipEnumFactory());
            this.relationship.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #otherMap} (The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.). This is the underlying object with id, value and extensions. The accessor "getOtherMap" gives direct access to the value
         */
        public CanonicalType getOtherMapElement() { 
          if (this.otherMap == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConceptMapGroupUnmappedComponent.otherMap");
            else if (Configuration.doAutoCreate())
              this.otherMap = new CanonicalType(); // bb
          return this.otherMap;
        }

        public boolean hasOtherMapElement() { 
          return this.otherMap != null && !this.otherMap.isEmpty();
        }

        public boolean hasOtherMap() { 
          return this.otherMap != null && !this.otherMap.isEmpty();
        }

        /**
         * @param value {@link #otherMap} (The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.). This is the underlying object with id, value and extensions. The accessor "getOtherMap" gives direct access to the value
         */
        public ConceptMapGroupUnmappedComponent setOtherMapElement(CanonicalType value) { 
          this.otherMap = value;
          return this;
        }

        /**
         * @return The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.
         */
        public String getOtherMap() { 
          return this.otherMap == null ? null : this.otherMap.getValue();
        }

        /**
         * @param value The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.
         */
        public ConceptMapGroupUnmappedComponent setOtherMap(String value) { 
          if (Utilities.noString(value))
            this.otherMap = null;
          else {
            if (this.otherMap == null)
              this.otherMap = new CanonicalType();
            this.otherMap.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("mode", "code", "Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).", 0, 1, mode));
          children.add(new Property("code", "code", "The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.", 0, 1, code));
          children.add(new Property("display", "string", "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1, display));
          children.add(new Property("valueSet", "canonical(ValueSet)", "The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.", 0, 1, valueSet));
          children.add(new Property("relationship", "code", "The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.", 0, 1, relationship));
          children.add(new Property("otherMap", "canonical(ConceptMap)", "The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.", 0, 1, otherMap));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3357091: /*mode*/  return new Property("mode", "code", "Defines which action to take if there is no match for the source concept in the target system designated for the group. One of 3 actions are possible: use the unmapped source code (this is useful when doing a mapping between versions, and only a few codes have changed), use a fixed code (a default code), or alternatively, a reference to a different concept map can be provided (by canonical URL).", 0, 1, mode);
          case 3059181: /*code*/  return new Property("code", "code", "The fixed code to use when the mode = 'fixed'  - all unmapped codes are mapped to a single fixed code.", 0, 1, code);
          case 1671764162: /*display*/  return new Property("display", "string", "The display for the code. The display is only provided to help editors when editing the concept map.", 0, 1, display);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "The set of fixed codes to use when the mode = 'fixed'  - all unmapped codes are mapped to each of the fixed codes.", 0, 1, valueSet);
          case -261851592: /*relationship*/  return new Property("relationship", "code", "The default relationship value to apply between the source and target concepts when the source code is unmapped and the mode is 'fixed' or 'use-source-code'.", 0, 1, relationship);
          case -1171155924: /*otherMap*/  return new Property("otherMap", "canonical(ConceptMap)", "The canonical reference to an additional ConceptMap resource instance to use for mapping if this ConceptMap resource contains no matching mapping for the source concept.", 0, 1, otherMap);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<ConceptMapGroupUnmappedMode>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeType
        case 1671764162: /*display*/ return this.display == null ? new Base[0] : new Base[] {this.display}; // StringType
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // Enumeration<ConceptMapRelationship>
        case -1171155924: /*otherMap*/ return this.otherMap == null ? new Base[0] : new Base[] {this.otherMap}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3357091: // mode
          value = new ConceptMapGroupUnmappedModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<ConceptMapGroupUnmappedMode>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 1671764162: // display
          this.display = TypeConvertor.castToString(value); // StringType
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -261851592: // relationship
          value = new ConceptMapRelationshipEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ConceptMapRelationship>
          return value;
        case -1171155924: // otherMap
          this.otherMap = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new ConceptMapGroupUnmappedModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<ConceptMapGroupUnmappedMode>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("display")) {
          this.display = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("relationship")) {
          value = new ConceptMapRelationshipEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ConceptMapRelationship>
        } else if (name.equals("otherMap")) {
          this.otherMap = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091:  return getModeElement();
        case 3059181:  return getCodeElement();
        case 1671764162:  return getDisplayElement();
        case -1410174671:  return getValueSetElement();
        case -261851592:  return getRelationshipElement();
        case -1171155924:  return getOtherMapElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"code"};
        case 1671764162: /*display*/ return new String[] {"string"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        case -261851592: /*relationship*/ return new String[] {"code"};
        case -1171155924: /*otherMap*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.unmapped.mode");
        }
        else if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.unmapped.code");
        }
        else if (name.equals("display")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.unmapped.display");
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.unmapped.valueSet");
        }
        else if (name.equals("relationship")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.unmapped.relationship");
        }
        else if (name.equals("otherMap")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.group.unmapped.otherMap");
        }
        else
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
        dst.valueSet = valueSet == null ? null : valueSet.copy();
        dst.relationship = relationship == null ? null : relationship.copy();
        dst.otherMap = otherMap == null ? null : otherMap.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConceptMapGroupUnmappedComponent))
          return false;
        ConceptMapGroupUnmappedComponent o = (ConceptMapGroupUnmappedComponent) other_;
        return compareDeep(mode, o.mode, true) && compareDeep(code, o.code, true) && compareDeep(display, o.display, true)
           && compareDeep(valueSet, o.valueSet, true) && compareDeep(relationship, o.relationship, true) && compareDeep(otherMap, o.otherMap, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConceptMapGroupUnmappedComponent))
          return false;
        ConceptMapGroupUnmappedComponent o = (ConceptMapGroupUnmappedComponent) other_;
        return compareValues(mode, o.mode, true) && compareValues(code, o.code, true) && compareValues(display, o.display, true)
           && compareValues(valueSet, o.valueSet, true) && compareValues(relationship, o.relationship, true) && compareValues(otherMap, o.otherMap, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, code, display, valueSet
          , relationship, otherMap);
      }

  public String fhirType() {
    return "ConceptMap.group.unmapped";

  }

  }

    /**
     * An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this concept map, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the concept map", formalDefinition="A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the concept map", formalDefinition="The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this concept map (computer friendly)", formalDefinition="A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the concept map.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this concept map (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the concept map." )
    protected StringType title;

    /**
     * The status of this concept map. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this concept map. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.
     */
    @Child(name = "publisher", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the concept map." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the concept map from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the concept map", formalDefinition="A free text natural language description of the concept map from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the concept map is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for concept map (if applicable)", formalDefinition="A legal or geographic region in which the concept map is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this concept map is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this concept map is defined", formalDefinition="Explanation of why this concept map is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map." )
    protected MarkdownType copyright;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the ConceptMap was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the ConceptMap was last reviewed", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the ConceptMap content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the ConceptMap is expected to be used", formalDefinition="The period during which the ConceptMap content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * Descriptions related to the content of the ConceptMap. Topics provide a high-level categorization as well as keywords for the ConceptMap that can be useful for filtering and searching.
     */
    @Child(name = "topic", type = {CodeableConcept.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="E.g. Education, Treatment, Assessment, etc.", formalDefinition="Descriptions related to the content of the ConceptMap. Topics provide a high-level categorization as well as keywords for the ConceptMap that can be useful for filtering and searching." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/definition-topic")
    protected List<CodeableConcept> topic;

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the ConceptMap.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who authored the ConceptMap", formalDefinition="An individiual or organization primarily involved in the creation and maintenance of the ConceptMap." )
    protected List<ContactDetail> author;

    /**
     * An individual or organization primarily responsible for internal coherence of the ConceptMap.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the ConceptMap", formalDefinition="An individual or organization primarily responsible for internal coherence of the ConceptMap." )
    protected List<ContactDetail> editor;

    /**
     * An individual or organization primarily responsible for review of some aspect of the ConceptMap.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the ConceptMap", formalDefinition="An individual or organization primarily responsible for review of some aspect of the ConceptMap." )
    protected List<ContactDetail> reviewer;

    /**
     * An individual or organization responsible for officially endorsing the ConceptMap for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who endorsed the ConceptMap", formalDefinition="An individual or organization responsible for officially endorsing the ConceptMap for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional documentation, citations, etc.", formalDefinition="Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.
     */
    @Child(name = "sourceScope", type = {UriType.class, CanonicalType.class}, order=24, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The source value set that contains the concepts that are being mapped", formalDefinition="Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set." )
    protected DataType sourceScope;

    /**
     * Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.
     */
    @Child(name = "targetScope", type = {UriType.class, CanonicalType.class}, order=25, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The target value set which provides context for the mappings", formalDefinition="Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set." )
    protected DataType targetScope;

    /**
     * A group of mappings that all have the same source and target system.
     */
    @Child(name = "group", type = {}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Same source and target systems", formalDefinition="A group of mappings that all have the same source and target system." )
    protected List<ConceptMapGroupComponent> group;

    private static final long serialVersionUID = 682923821L;

  /**
   * Constructor
   */
    public ConceptMap() {
      super();
    }

  /**
   * Constructor
   */
    public ConceptMap(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
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
     * @param value {@link #url} (An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ConceptMap setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.
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
     * @return {@link #identifier} (A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setIdentifier(List<Identifier> theIdentifier) { 
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

    public ConceptMap addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
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
     * @param value {@link #version} (The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public ConceptMap setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
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
     * @return {@link #name} (A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
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
     * @param value {@link #name} (A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ConceptMap setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the concept map.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the concept map.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
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
     * @return {@link #status} (The status of this concept map. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
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
     * @param value {@link #status} (The status of this concept map. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ConceptMap setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this concept map. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this concept map. Enables tracking the life-cycle of the content.
     */
    public ConceptMap setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
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
     * @param value {@link #experimental} (A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public ConceptMap setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public ConceptMap setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
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
     * @param value {@link #date} (The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ConceptMap setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public ConceptMap setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.
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
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
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

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public ConceptMap addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the concept map from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
     * @param value {@link #description} (A free text natural language description of the concept map from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ConceptMap setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the concept map from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the concept map from a consumer's perspective.
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances.)
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

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public ConceptMap addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the concept map is intended to be used.)
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

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public ConceptMap addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this concept map is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
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
     * @param value {@link #purpose} (Explanation of why this concept map is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public ConceptMap setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this concept map is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this concept map is needed and why it has been designed as it has.
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
     * @return {@link #copyright} (A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
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
     * @param value {@link #copyright} (A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public ConceptMap setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.
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
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMap.approvalDate");
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
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public ConceptMap setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public ConceptMap setApprovalDate(Date value) { 
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
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMap.lastReviewDate");
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
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public ConceptMap setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public ConceptMap setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the ConceptMap content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConceptMap.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the ConceptMap content was or is planned to be in active use.)
     */
    public ConceptMap setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #topic} (Descriptions related to the content of the ConceptMap. Topics provide a high-level categorization as well as keywords for the ConceptMap that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      return this.topic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setTopic(List<CodeableConcept> theTopic) { 
      this.topic = theTopic;
      return this;
    }

    public boolean hasTopic() { 
      if (this.topic == null)
        return false;
      for (CodeableConcept item : this.topic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addTopic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return t;
    }

    public ConceptMap addTopic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTopicFirstRep() { 
      if (getTopic().isEmpty()) {
        addTopic();
      }
      return getTopic().get(0);
    }

    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the ConceptMap.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setAuthor(List<ContactDetail> theAuthor) { 
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

    public ContactDetail addAuthor() { //3
      ContactDetail t = new ContactDetail();
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return t;
    }

    public ConceptMap addAuthor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
     */
    public ContactDetail getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the ConceptMap.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setEditor(List<ContactDetail> theEditor) { 
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

    public ContactDetail addEditor() { //3
      ContactDetail t = new ContactDetail();
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return t;
    }

    public ConceptMap addEditor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {3}
     */
    public ContactDetail getEditorFirstRep() { 
      if (getEditor().isEmpty()) {
        addEditor();
      }
      return getEditor().get(0);
    }

    /**
     * @return {@link #reviewer} (An individual or organization primarily responsible for review of some aspect of the ConceptMap.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setReviewer(List<ContactDetail> theReviewer) { 
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

    public ContactDetail addReviewer() { //3
      ContactDetail t = new ContactDetail();
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return t;
    }

    public ConceptMap addReviewer(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {3}
     */
    public ContactDetail getReviewerFirstRep() { 
      if (getReviewer().isEmpty()) {
        addReviewer();
      }
      return getReviewer().get(0);
    }

    /**
     * @return {@link #endorser} (An individual or organization responsible for officially endorsing the ConceptMap for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setEndorser(List<ContactDetail> theEndorser) { 
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

    public ContactDetail addEndorser() { //3
      ContactDetail t = new ContactDetail();
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return t;
    }

    public ConceptMap addEndorser(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {3}
     */
    public ContactDetail getEndorserFirstRep() { 
      if (getEndorser().isEmpty()) {
        addEndorser();
      }
      return getEndorser().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConceptMap setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public ConceptMap addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * @return {@link #sourceScope} (Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.)
     */
    public DataType getSourceScope() { 
      return this.sourceScope;
    }

    /**
     * @return {@link #sourceScope} (Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.)
     */
    public UriType getSourceScopeUriType() throws FHIRException { 
      if (this.sourceScope == null)
        this.sourceScope = new UriType();
      if (!(this.sourceScope instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.sourceScope.getClass().getName()+" was encountered");
      return (UriType) this.sourceScope;
    }

    public boolean hasSourceScopeUriType() { 
      return this != null && this.sourceScope instanceof UriType;
    }

    /**
     * @return {@link #sourceScope} (Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.)
     */
    public CanonicalType getSourceScopeCanonicalType() throws FHIRException { 
      if (this.sourceScope == null)
        this.sourceScope = new CanonicalType();
      if (!(this.sourceScope instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.sourceScope.getClass().getName()+" was encountered");
      return (CanonicalType) this.sourceScope;
    }

    public boolean hasSourceScopeCanonicalType() { 
      return this != null && this.sourceScope instanceof CanonicalType;
    }

    public boolean hasSourceScope() { 
      return this.sourceScope != null && !this.sourceScope.isEmpty();
    }

    /**
     * @param value {@link #sourceScope} (Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.)
     */
    public ConceptMap setSourceScope(DataType value) { 
      if (value != null && !(value instanceof UriType || value instanceof CanonicalType))
        throw new Error("Not the right type for ConceptMap.sourceScope[x]: "+value.fhirType());
      this.sourceScope = value;
      return this;
    }

    /**
     * @return {@link #targetScope} (Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.)
     */
    public DataType getTargetScope() { 
      return this.targetScope;
    }

    /**
     * @return {@link #targetScope} (Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.)
     */
    public UriType getTargetScopeUriType() throws FHIRException { 
      if (this.targetScope == null)
        this.targetScope = new UriType();
      if (!(this.targetScope instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.targetScope.getClass().getName()+" was encountered");
      return (UriType) this.targetScope;
    }

    public boolean hasTargetScopeUriType() { 
      return this != null && this.targetScope instanceof UriType;
    }

    /**
     * @return {@link #targetScope} (Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.)
     */
    public CanonicalType getTargetScopeCanonicalType() throws FHIRException { 
      if (this.targetScope == null)
        this.targetScope = new CanonicalType();
      if (!(this.targetScope instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.targetScope.getClass().getName()+" was encountered");
      return (CanonicalType) this.targetScope;
    }

    public boolean hasTargetScopeCanonicalType() { 
      return this != null && this.targetScope instanceof CanonicalType;
    }

    public boolean hasTargetScope() { 
      return this.targetScope != null && !this.targetScope.isEmpty();
    }

    /**
     * @param value {@link #targetScope} (Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.)
     */
    public ConceptMap setTargetScope(DataType value) { 
      if (value != null && !(value instanceof UriType || value instanceof CanonicalType))
        throw new Error("Not the right type for ConceptMap.targetScope[x]: "+value.fhirType());
      this.targetScope = value;
      return this;
    }

    /**
     * @return {@link #group} (A group of mappings that all have the same source and target system.)
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

    public ConceptMapGroupComponent addGroup() { //3
      ConceptMapGroupComponent t = new ConceptMapGroupComponent();
      if (this.group == null)
        this.group = new ArrayList<ConceptMapGroupComponent>();
      this.group.add(t);
      return t;
    }

    public ConceptMap addGroup(ConceptMapGroupComponent t) { //3
      if (t == null)
        return this;
      if (this.group == null)
        this.group = new ArrayList<ConceptMapGroupComponent>();
      this.group.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #group}, creating it if it does not already exist {3}
     */
    public ConceptMapGroupComponent getGroupFirstRep() { 
      if (getGroup().isEmpty()) {
        addGroup();
      }
      return getGroup().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getVersionAlgorithmMax() { 
      return 0;
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmStringType() { 
      return false;////K 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmCoding() { 
      return false;////K 
    }
    public boolean hasVersionAlgorithm() { 
      return false;
    }
    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public ConceptMap setVersionAlgorithm(DataType value) { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"versionAlgorithm[x]\""); 
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightLabelMax() { 
      return 0;
    }
    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"copyrightLabel\"");
    }

    public boolean hasCopyrightLabelElement() { 
      return false;
    }
    public boolean hasCopyrightLabel() {
      return false;
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public ConceptMap setCopyrightLabelElement(StringType value) { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"copyrightLabel\""); 
    }
    public String getCopyrightLabel() { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"copyrightLabel\""); 
    }
    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public ConceptMap setCopyrightLabel(String value) { 
      throw new Error("The resource type \"ConceptMap\" does not implement the property \"copyrightLabel\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the concept map.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this concept map. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the concept map from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the concept map is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this concept map is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the ConceptMap content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("topic", "CodeableConcept", "Descriptions related to the content of the ConceptMap. Topics provide a high-level categorization as well as keywords for the ConceptMap that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic));
        children.add(new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the ConceptMap.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the ConceptMap.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individual or organization primarily responsible for review of some aspect of the ConceptMap.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individual or organization responsible for officially endorsing the ConceptMap for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("sourceScope[x]", "uri|canonical(ValueSet)", "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.", 0, 1, sourceScope));
        children.add(new Property("targetScope[x]", "uri|canonical(ValueSet)", "Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.", 0, 1, targetScope));
        children.add(new Property("group", "", "A group of mappings that all have the same source and target system.", 0, java.lang.Integer.MAX_VALUE, group));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this concept map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this concept map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the concept map is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this concept map when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the concept map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the concept map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the concept map. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the concept map.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this concept map. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this concept map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the concept map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the concept map changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the concept map.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the concept map from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate concept map instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the concept map is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this concept map is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the concept map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the concept map.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the ConceptMap content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case 110546223: /*topic*/  return new Property("topic", "CodeableConcept", "Descriptions related to the content of the ConceptMap. Topics provide a high-level categorization as well as keywords for the ConceptMap that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the ConceptMap.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the ConceptMap.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individual or organization primarily responsible for review of some aspect of the ConceptMap.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individual or organization responsible for officially endorsing the ConceptMap for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case -1850861849: /*sourceScope[x]*/  return new Property("sourceScope[x]", "uri|canonical(ValueSet)", "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.", 0, 1, sourceScope);
        case -96223495: /*sourceScope*/  return new Property("sourceScope[x]", "uri|canonical(ValueSet)", "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.", 0, 1, sourceScope);
        case -1850867789: /*sourceScopeUri*/  return new Property("sourceScope[x]", "uri", "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.", 0, 1, sourceScope);
        case -1487745541: /*sourceScopeCanonical*/  return new Property("sourceScope[x]", "canonical(ValueSet)", "Identifier for the source value set that contains the concepts that are being mapped and provides context for the mappings.  Limits the scope of the map to source codes (ConceptMap.group.element code or valueSet) that are members of this value set.", 0, 1, sourceScope);
        case -2079438243: /*targetScope[x]*/  return new Property("targetScope[x]", "uri|canonical(ValueSet)", "Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.", 0, 1, targetScope);
        case -2096156861: /*targetScope*/  return new Property("targetScope[x]", "uri|canonical(ValueSet)", "Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.", 0, 1, targetScope);
        case -2079444183: /*targetScopeUri*/  return new Property("targetScope[x]", "uri", "Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.", 0, 1, targetScope);
        case -1851780879: /*targetScopeCanonical*/  return new Property("targetScope[x]", "canonical(ValueSet)", "Identifier for the target value set that provides important context about how the mapping choices are made.  Limits the scope of the map to target codes (ConceptMap.group.element.target code or valueSet) that are members of this value set.", 0, 1, targetScope);
        case 98629247: /*group*/  return new Property("group", "", "A group of mappings that all have the same source and target system.", 0, java.lang.Integer.MAX_VALUE, group);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : this.topic.toArray(new Base[this.topic.size()]); // CodeableConcept
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -96223495: /*sourceScope*/ return this.sourceScope == null ? new Base[0] : new Base[] {this.sourceScope}; // DataType
        case -2096156861: /*targetScope*/ return this.targetScope == null ? new Base[0] : new Base[] {this.targetScope}; // DataType
        case 98629247: /*group*/ return this.group == null ? new Base[0] : this.group.toArray(new Base[this.group.size()]); // ConceptMapGroupComponent
        default: return super.getProperty(hash, name, checkValid);
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
        case 110546223: // topic
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case -96223495: // sourceScope
          this.sourceScope = TypeConvertor.castToType(value); // DataType
          return value;
        case -2096156861: // targetScope
          this.targetScope = TypeConvertor.castToType(value); // DataType
          return value;
        case 98629247: // group
          this.getGroup().add((ConceptMapGroupComponent) value); // ConceptMapGroupComponent
          return value;
        default: return super.setProperty(hash, name, value);
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
        } else if (name.equals("topic")) {
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("author")) {
          this.getAuthor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("editor")) {
          this.getEditor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("reviewer")) {
          this.getReviewer().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("endorser")) {
          this.getEndorser().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("sourceScope[x]")) {
          this.sourceScope = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("targetScope[x]")) {
          this.targetScope = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("group")) {
          this.getGroup().add((ConceptMapGroupComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case 110546223:  return addTopic(); 
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case 666807069:  return addRelatedArtifact(); 
        case -1850861849:  return getSourceScope();
        case -96223495:  return getSourceScope();
        case -2079438243:  return getTargetScope();
        case -2096156861:  return getTargetScope();
        case 98629247:  return addGroup(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case 110546223: /*topic*/ return new String[] {"CodeableConcept"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -96223495: /*sourceScope*/ return new String[] {"uri", "canonical"};
        case -2096156861: /*targetScope*/ return new String[] {"uri", "canonical"};
        case 98629247: /*group*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ConceptMap.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("topic")) {
          return addTopic();
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("editor")) {
          return addEditor();
        }
        else if (name.equals("reviewer")) {
          return addReviewer();
        }
        else if (name.equals("endorser")) {
          return addEndorser();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("sourceScopeUri")) {
          this.sourceScope = new UriType();
          return this.sourceScope;
        }
        else if (name.equals("sourceScopeCanonical")) {
          this.sourceScope = new CanonicalType();
          return this.sourceScope;
        }
        else if (name.equals("targetScopeUri")) {
          this.targetScope = new UriType();
          return this.targetScope;
        }
        else if (name.equals("targetScopeCanonical")) {
          this.targetScope = new CanonicalType();
          return this.targetScope;
        }
        else if (name.equals("group")) {
          return addGroup();
        }
        else
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
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
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
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (topic != null) {
          dst.topic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : topic)
            dst.topic.add(i.copy());
        };
        if (author != null) {
          dst.author = new ArrayList<ContactDetail>();
          for (ContactDetail i : author)
            dst.author.add(i.copy());
        };
        if (editor != null) {
          dst.editor = new ArrayList<ContactDetail>();
          for (ContactDetail i : editor)
            dst.editor.add(i.copy());
        };
        if (reviewer != null) {
          dst.reviewer = new ArrayList<ContactDetail>();
          for (ContactDetail i : reviewer)
            dst.reviewer.add(i.copy());
        };
        if (endorser != null) {
          dst.endorser = new ArrayList<ContactDetail>();
          for (ContactDetail i : endorser)
            dst.endorser.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        dst.sourceScope = sourceScope == null ? null : sourceScope.copy();
        dst.targetScope = targetScope == null ? null : targetScope.copy();
        if (group != null) {
          dst.group = new ArrayList<ConceptMapGroupComponent>();
          for (ConceptMapGroupComponent i : group)
            dst.group.add(i.copy());
        };
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
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(status, o.status, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(topic, o.topic, true) && compareDeep(author, o.author, true)
           && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true)
           && compareDeep(relatedArtifact, o.relatedArtifact, true) && compareDeep(sourceScope, o.sourceScope, true)
           && compareDeep(targetScope, o.targetScope, true) && compareDeep(group, o.group, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConceptMap))
          return false;
        ConceptMap o = (ConceptMap) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(approvalDate, o.approvalDate, true)
           && compareValues(lastReviewDate, o.lastReviewDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, status, experimental, date, publisher, contact, description, useContext
          , jurisdiction, purpose, copyright, approvalDate, lastReviewDate, effectivePeriod
          , topic, author, editor, reviewer, endorser, relatedArtifact, sourceScope, targetScope
          , group);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ConceptMap;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range) | (ActorDefinition.useContext.value as Quantity) | (ActorDefinition.useContext.value as Range) | (CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range) | (Citation.useContext.value as Quantity) | (Citation.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (ConditionDefinition.useContext.value as Quantity) | (ConditionDefinition.useContext.value as Range) | (EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range) | (Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range) | (EvidenceReport.useContext.value as Quantity) | (EvidenceReport.useContext.value as Range) | (EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range) | (ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (Library.useContext.value as Quantity) | (Library.useContext.value as Range) | (Measure.useContext.value as Quantity) | (Measure.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range) | (Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range) | (Requirements.useContext.value as Quantity) | (Requirements.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range) | (ActorDefinition.useContext.value as Quantity) | (ActorDefinition.useContext.value as Range) | (CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range) | (Citation.useContext.value as Quantity) | (Citation.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (ConditionDefinition.useContext.value as Quantity) | (ConditionDefinition.useContext.value as Range) | (EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range) | (Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range) | (EvidenceReport.useContext.value as Quantity) | (EvidenceReport.useContext.value as Range) | (EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range) | (ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (Library.useContext.value as Quantity) | (Library.useContext.value as Range) | (Measure.useContext.value as Quantity) | (Measure.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range) | (Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range) | (Requirements.useContext.value as Quantity) | (Requirements.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range) | (ActorDefinition.useContext.value as Quantity) | (ActorDefinition.useContext.value as Range) | (CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range) | (Citation.useContext.value as Quantity) | (Citation.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (ConditionDefinition.useContext.value as Quantity) | (ConditionDefinition.useContext.value as Range) | (EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range) | (Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range) | (EvidenceReport.useContext.value as Quantity) | (EvidenceReport.useContext.value as Range) | (EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range) | (ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (Library.useContext.value as Quantity) | (Library.useContext.value as Range) | (Measure.useContext.value as Quantity) | (Measure.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range) | (Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range) | (Requirements.useContext.value as Quantity) | (Requirements.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide\r\n* [Library](library.html): A use context type and quantity- or range-based value assigned to the library\r\n* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide\r\n* [Library](library.html): A use context type and value assigned to the library\r\n* [Measure](measure.html): A use context type and value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition\r\n* [Citation](citation.html): A type of use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A type of use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition\r\n* [Evidence](evidence.html): A type of use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide\r\n* [Library](library.html): A type of use context assigned to the library\r\n* [Measure](measure.html): A type of use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A type of use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A type of use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A type of use context assigned to the test script\r\n* [ValueSet](valueset.html): A type of use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as CodeableConcept) | (ActorDefinition.useContext.value as CodeableConcept) | (CapabilityStatement.useContext.value as CodeableConcept) | (ChargeItemDefinition.useContext.value as CodeableConcept) | (Citation.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (ConditionDefinition.useContext.value as CodeableConcept) | (EventDefinition.useContext.value as CodeableConcept) | (Evidence.useContext.value as CodeableConcept) | (EvidenceReport.useContext.value as CodeableConcept) | (EvidenceVariable.useContext.value as CodeableConcept) | (ExampleScenario.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (Library.useContext.value as CodeableConcept) | (Measure.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (PlanDefinition.useContext.value as CodeableConcept) | (Questionnaire.useContext.value as CodeableConcept) | (Requirements.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (TestScript.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value as CodeableConcept) | (ActorDefinition.useContext.value as CodeableConcept) | (CapabilityStatement.useContext.value as CodeableConcept) | (ChargeItemDefinition.useContext.value as CodeableConcept) | (Citation.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (ConditionDefinition.useContext.value as CodeableConcept) | (EventDefinition.useContext.value as CodeableConcept) | (Evidence.useContext.value as CodeableConcept) | (EvidenceReport.useContext.value as CodeableConcept) | (EvidenceVariable.useContext.value as CodeableConcept) | (ExampleScenario.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (Library.useContext.value as CodeableConcept) | (Measure.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (PlanDefinition.useContext.value as CodeableConcept) | (Questionnaire.useContext.value as CodeableConcept) | (Requirements.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (TestScript.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as CodeableConcept) | (ActorDefinition.useContext.value as CodeableConcept) | (CapabilityStatement.useContext.value as CodeableConcept) | (ChargeItemDefinition.useContext.value as CodeableConcept) | (Citation.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (ConditionDefinition.useContext.value as CodeableConcept) | (EventDefinition.useContext.value as CodeableConcept) | (Evidence.useContext.value as CodeableConcept) | (EvidenceReport.useContext.value as CodeableConcept) | (EvidenceVariable.useContext.value as CodeableConcept) | (ExampleScenario.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (Library.useContext.value as CodeableConcept) | (Measure.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (PlanDefinition.useContext.value as CodeableConcept) | (Questionnaire.useContext.value as CodeableConcept) | (Requirements.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (TestScript.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The activity definition publication date\r\n* [ActorDefinition](actordefinition.html): The Actor Definition publication date\r\n* [CapabilityStatement](capabilitystatement.html): The capability statement publication date\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date\r\n* [Citation](citation.html): The citation publication date\r\n* [CodeSystem](codesystem.html): The code system publication date\r\n* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date\r\n* [ConceptMap](conceptmap.html): The concept map publication date\r\n* [ConditionDefinition](conditiondefinition.html): The condition definition publication date\r\n* [EventDefinition](eventdefinition.html): The event definition publication date\r\n* [Evidence](evidence.html): The evidence publication date\r\n* [EvidenceVariable](evidencevariable.html): The evidence variable publication date\r\n* [ExampleScenario](examplescenario.html): The example scenario publication date\r\n* [GraphDefinition](graphdefinition.html): The graph definition publication date\r\n* [ImplementationGuide](implementationguide.html): The implementation guide publication date\r\n* [Library](library.html): The library publication date\r\n* [Measure](measure.html): The measure publication date\r\n* [MessageDefinition](messagedefinition.html): The message definition publication date\r\n* [NamingSystem](namingsystem.html): The naming system publication date\r\n* [OperationDefinition](operationdefinition.html): The operation definition publication date\r\n* [PlanDefinition](plandefinition.html): The plan definition publication date\r\n* [Questionnaire](questionnaire.html): The questionnaire publication date\r\n* [Requirements](requirements.html): The requirements publication date\r\n* [SearchParameter](searchparameter.html): The search parameter publication date\r\n* [StructureDefinition](structuredefinition.html): The structure definition publication date\r\n* [StructureMap](structuremap.html): The structure map publication date\r\n* [SubscriptionTopic](subscriptiontopic.html): Date status first applied\r\n* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date\r\n* [TestScript](testscript.html): The test script publication date\r\n* [ValueSet](valueset.html): The value set publication date\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The description of the activity definition\r\n* [ActorDefinition](actordefinition.html): The description of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The description of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition\r\n* [Citation](citation.html): The description of the citation\r\n* [CodeSystem](codesystem.html): The description of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition\r\n* [ConceptMap](conceptmap.html): The description of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The description of the condition definition\r\n* [EventDefinition](eventdefinition.html): The description of the event definition\r\n* [Evidence](evidence.html): The description of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The description of the evidence variable\r\n* [GraphDefinition](graphdefinition.html): The description of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The description of the implementation guide\r\n* [Library](library.html): The description of the library\r\n* [Measure](measure.html): The description of the measure\r\n* [MessageDefinition](messagedefinition.html): The description of the message definition\r\n* [NamingSystem](namingsystem.html): The description of the naming system\r\n* [OperationDefinition](operationdefinition.html): The description of the operation definition\r\n* [PlanDefinition](plandefinition.html): The description of the plan definition\r\n* [Questionnaire](questionnaire.html): The description of the questionnaire\r\n* [Requirements](requirements.html): The description of the requirements\r\n* [SearchParameter](searchparameter.html): The description of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The description of the structure definition\r\n* [StructureMap](structuremap.html): The description of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities\r\n* [TestScript](testscript.html): The description of the test script\r\n* [ValueSet](valueset.html): The description of the value set\r\n", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition\r\n* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition\r\n* [Citation](citation.html): Intended jurisdiction for the citation\r\n* [CodeSystem](codesystem.html): Intended jurisdiction for the code system\r\n* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition\r\n* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition\r\n* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario\r\n* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition\r\n* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide\r\n* [Library](library.html): Intended jurisdiction for the library\r\n* [Measure](measure.html): Intended jurisdiction for the measure\r\n* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition\r\n* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system\r\n* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition\r\n* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition\r\n* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire\r\n* [Requirements](requirements.html): Intended jurisdiction for the requirements\r\n* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter\r\n* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition\r\n* [StructureMap](structuremap.html): Intended jurisdiction for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities\r\n* [TestScript](testscript.html): Intended jurisdiction for the test script\r\n* [ValueSet](valueset.html): Intended jurisdiction for the value set\r\n", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition\r\n* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement\r\n* [Citation](citation.html): Computationally friendly name of the citation\r\n* [CodeSystem](codesystem.html): Computationally friendly name of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition\r\n* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition\r\n* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide\r\n* [Library](library.html): Computationally friendly name of the library\r\n* [Measure](measure.html): Computationally friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition\r\n* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system\r\n* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire\r\n* [Requirements](requirements.html): Computationally friendly name of the requirements\r\n* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition\r\n* [StructureMap](structuremap.html): Computationally friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): Computationally friendly name of the test script\r\n* [ValueSet](valueset.html): Computationally friendly name of the value set\r\n", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition\r\n* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition\r\n* [Citation](citation.html): Name of the publisher of the citation\r\n* [CodeSystem](codesystem.html): Name of the publisher of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition\r\n* [ConceptMap](conceptmap.html): Name of the publisher of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition\r\n* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition\r\n* [Evidence](evidence.html): Name of the publisher of the evidence\r\n* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide\r\n* [Library](library.html): Name of the publisher of the library\r\n* [Measure](measure.html): Name of the publisher of the measure\r\n* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition\r\n* [NamingSystem](namingsystem.html): Name of the publisher of the naming system\r\n* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition\r\n* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition\r\n* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire\r\n* [Requirements](requirements.html): Name of the publisher of the requirements\r\n* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition\r\n* [StructureMap](structuremap.html): Name of the publisher of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities\r\n* [TestScript](testscript.html): Name of the publisher of the test script\r\n* [ValueSet](valueset.html): Name of the publisher of the value set\r\n", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition\r\n* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition\r\n* [Citation](citation.html): The human-friendly name of the citation\r\n* [CodeSystem](codesystem.html): The human-friendly name of the code system\r\n* [ConceptMap](conceptmap.html): The human-friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition\r\n* [Evidence](evidence.html): The human-friendly name of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable\r\n* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide\r\n* [Library](library.html): The human-friendly name of the library\r\n* [Measure](measure.html): The human-friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition\r\n* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition\r\n* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire\r\n* [Requirements](requirements.html): The human-friendly name of the requirements\r\n* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition\r\n* [StructureMap](structuremap.html): The human-friendly name of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): The human-friendly name of the test script\r\n* [ValueSet](valueset.html): The human-friendly name of the value set\r\n", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The business version of the activity definition\r\n* [ActorDefinition](actordefinition.html): The business version of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition\r\n* [Citation](citation.html): The business version of the citation\r\n* [CodeSystem](codesystem.html): The business version of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition\r\n* [ConceptMap](conceptmap.html): The business version of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition\r\n* [EventDefinition](eventdefinition.html): The business version of the event definition\r\n* [Evidence](evidence.html): The business version of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The business version of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The business version of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The business version of the implementation guide\r\n* [Library](library.html): The business version of the library\r\n* [Measure](measure.html): The business version of the measure\r\n* [MessageDefinition](messagedefinition.html): The business version of the message definition\r\n* [NamingSystem](namingsystem.html): The business version of the naming system\r\n* [OperationDefinition](operationdefinition.html): The business version of the operation definition\r\n* [PlanDefinition](plandefinition.html): The business version of the plan definition\r\n* [Questionnaire](questionnaire.html): The business version of the questionnaire\r\n* [Requirements](requirements.html): The business version of the requirements\r\n* [SearchParameter](searchparameter.html): The business version of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The business version of the structure definition\r\n* [StructureMap](structuremap.html): The business version of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities\r\n* [TestScript](testscript.html): The business version of the test script\r\n* [ValueSet](valueset.html): The business version of the value set\r\n", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);

 /**
   * Search parameter: <b>dependson</b>
   * <p>
   * Description: <b>Other properties required for this mapping</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.dependsOn.property</b><br>
   * </p>
   */
  @SearchParamDefinition(name="dependson", path="ConceptMap.group.element.target.dependsOn.property", description="Other properties required for this mapping", type="uri" )
  public static final String SP_DEPENDSON = "dependson";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>dependson</b>
   * <p>
   * Description: <b>Other properties required for this mapping</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.dependsOn.property</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam DEPENDSON = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_DEPENDSON);

 /**
   * Search parameter: <b>other-map</b>
   * <p>
   * Description: <b>canonical reference to an additional ConceptMap to use for mapping if the source concept is unmapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.unmapped.otherMap</b><br>
   * </p>
   */
  @SearchParamDefinition(name="other-map", path="ConceptMap.group.unmapped.otherMap", description="canonical reference to an additional ConceptMap to use for mapping if the source concept is unmapped", type="reference", target={ConceptMap.class } )
  public static final String SP_OTHER_MAP = "other-map";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>other-map</b>
   * <p>
   * Description: <b>canonical reference to an additional ConceptMap to use for mapping if the source concept is unmapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.unmapped.otherMap</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam OTHER_MAP = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_OTHER_MAP);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:other-map</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_OTHER_MAP = new ca.uhn.fhir.model.api.Include("ConceptMap:other-map").toLocked();

 /**
   * Search parameter: <b>product</b>
   * <p>
   * Description: <b>Other properties that this mapping also produces</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.product.property</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product", path="ConceptMap.group.element.target.product.property", description="Other properties that this mapping also produces", type="uri" )
  public static final String SP_PRODUCT = "product";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product</b>
   * <p>
   * Description: <b>Other properties that this mapping also produces</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ConceptMap.group.element.target.product.property</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam PRODUCT = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_PRODUCT);

 /**
   * Search parameter: <b>source-code</b>
   * <p>
   * Description: <b>Identifies elements being mapped</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source-code", path="ConceptMap.group.element.code", description="Identifies elements being mapped", type="token" )
  public static final String SP_SOURCE_CODE = "source-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source-code</b>
   * <p>
   * Description: <b>Identifies elements being mapped</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SOURCE_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SOURCE_CODE);

 /**
   * Search parameter: <b>source-group-system</b>
   * <p>
   * Description: <b>Source system where concepts to be mapped are defined</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.source</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source-group-system", path="ConceptMap.group.source", description="Source system where concepts to be mapped are defined", type="reference", target={CodeSystem.class } )
  public static final String SP_SOURCE_GROUP_SYSTEM = "source-group-system";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source-group-system</b>
   * <p>
   * Description: <b>Source system where concepts to be mapped are defined</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.source</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE_GROUP_SYSTEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE_GROUP_SYSTEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:source-group-system</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE_GROUP_SYSTEM = new ca.uhn.fhir.model.api.Include("ConceptMap:source-group-system").toLocked();

 /**
   * Search parameter: <b>source-scope-uri</b>
   * <p>
   * Description: <b>The URI for the source value set that contains the concepts being mapped</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>(ConceptMap.sourceScope as uri)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source-scope-uri", path="(ConceptMap.sourceScope as uri)", description="The URI for the source value set that contains the concepts being mapped", type="uri" )
  public static final String SP_SOURCE_SCOPE_URI = "source-scope-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source-scope-uri</b>
   * <p>
   * Description: <b>The URI for the source value set that contains the concepts being mapped</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>(ConceptMap.sourceScope as uri)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam SOURCE_SCOPE_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_SOURCE_SCOPE_URI);

 /**
   * Search parameter: <b>source-scope</b>
   * <p>
   * Description: <b>The source value set that contains the concepts that are being mapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(ConceptMap.sourceScope as canonical)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source-scope", path="(ConceptMap.sourceScope as canonical)", description="The source value set that contains the concepts that are being mapped", type="reference", target={ValueSet.class } )
  public static final String SP_SOURCE_SCOPE = "source-scope";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source-scope</b>
   * <p>
   * Description: <b>The source value set that contains the concepts that are being mapped</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(ConceptMap.sourceScope as canonical)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE_SCOPE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE_SCOPE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:source-scope</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE_SCOPE = new ca.uhn.fhir.model.api.Include("ConceptMap:source-scope").toLocked();

 /**
   * Search parameter: <b>target-code</b>
   * <p>
   * Description: <b>Code that identifies the target element</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.target.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="target-code", path="ConceptMap.group.element.target.code", description="Code that identifies the target element", type="token" )
  public static final String SP_TARGET_CODE = "target-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>target-code</b>
   * <p>
   * Description: <b>Code that identifies the target element</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ConceptMap.group.element.target.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TARGET_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TARGET_CODE);

 /**
   * Search parameter: <b>target-group-system</b>
   * <p>
   * Description: <b>Target system that the concepts are to be mapped to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.target</b><br>
   * </p>
   */
  @SearchParamDefinition(name="target-group-system", path="ConceptMap.group.target", description="Target system that the concepts are to be mapped to", type="reference", target={CodeSystem.class } )
  public static final String SP_TARGET_GROUP_SYSTEM = "target-group-system";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>target-group-system</b>
   * <p>
   * Description: <b>Target system that the concepts are to be mapped to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ConceptMap.group.target</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam TARGET_GROUP_SYSTEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_TARGET_GROUP_SYSTEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:target-group-system</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_TARGET_GROUP_SYSTEM = new ca.uhn.fhir.model.api.Include("ConceptMap:target-group-system").toLocked();

 /**
   * Search parameter: <b>target-scope-uri</b>
   * <p>
   * Description: <b>The URI for the target value set that contains the concepts being mapped.</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>(ConceptMap.targetScope as uri)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="target-scope-uri", path="(ConceptMap.targetScope as uri)", description="The URI for the target value set that contains the concepts being mapped.", type="uri" )
  public static final String SP_TARGET_SCOPE_URI = "target-scope-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>target-scope-uri</b>
   * <p>
   * Description: <b>The URI for the target value set that contains the concepts being mapped.</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>(ConceptMap.targetScope as uri)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam TARGET_SCOPE_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_TARGET_SCOPE_URI);

 /**
   * Search parameter: <b>target-scope</b>
   * <p>
   * Description: <b>The target value set which provides context for the mappings</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(ConceptMap.targetScope as canonical)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="target-scope", path="(ConceptMap.targetScope as canonical)", description="The target value set which provides context for the mappings", type="reference", target={ValueSet.class } )
  public static final String SP_TARGET_SCOPE = "target-scope";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>target-scope</b>
   * <p>
   * Description: <b>The target value set which provides context for the mappings</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(ConceptMap.targetScope as canonical)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam TARGET_SCOPE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_TARGET_SCOPE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:target-scope</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_TARGET_SCOPE = new ca.uhn.fhir.model.api.Include("ConceptMap:target-scope").toLocked();

 /**
   * Search parameter: <b>derived-from</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from
* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): A resource that the ValueSet is derived from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="derived-from", path="ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from\r\n* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): A resource that the ValueSet is derived from\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DERIVED_FROM = "derived-from";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-from</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from
* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): A resource that the ValueSet is derived from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DERIVED_FROM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DERIVED_FROM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include("ConceptMap:derived-from").toLocked();

 /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use\r\n* [Citation](citation.html): The time during which the citation is intended to be in use\r\n* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use\r\n* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use\r\n* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use\r\n* [Library](library.html): The time during which the library is intended to be in use\r\n* [Measure](measure.html): The time during which the measure is intended to be in use\r\n* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use\r\n* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use\r\n* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use\r\n* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use\r\n", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);

 /**
   * Search parameter: <b>predecessor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): The predecessor of the CodeSystem
* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): The predecessor of the ValueSet
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="predecessor", path="ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): The predecessor of the CodeSystem\r\n* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): The predecessor of the ValueSet\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_PREDECESSOR = "predecessor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>predecessor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): The predecessor of the CodeSystem
* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): The predecessor of the ValueSet
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PREDECESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PREDECESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ConceptMap:predecessor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREDECESSOR = new ca.uhn.fhir.model.api.Include("ConceptMap:predecessor").toLocked();

 /**
   * Search parameter: <b>topic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Topics associated with the module
* [CodeSystem](codesystem.html): Topics associated with the CodeSystem
* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap
* [EventDefinition](eventdefinition.html): Topics associated with the module
* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable
* [Library](library.html): Topics associated with the module
* [Measure](measure.html): Topics associated with the measure
* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem
* [PlanDefinition](plandefinition.html): Topics associated with the module
* [ValueSet](valueset.html): Topics associated with the ValueSet
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="topic", path="ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Topics associated with the module\r\n* [CodeSystem](codesystem.html): Topics associated with the CodeSystem\r\n* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap\r\n* [EventDefinition](eventdefinition.html): Topics associated with the module\r\n* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable\r\n* [Library](library.html): Topics associated with the module\r\n* [Measure](measure.html): Topics associated with the measure\r\n* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem\r\n* [PlanDefinition](plandefinition.html): Topics associated with the module\r\n* [ValueSet](valueset.html): Topics associated with the ValueSet\r\n", type="token" )
  public static final String SP_TOPIC = "topic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>topic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Topics associated with the module
* [CodeSystem](codesystem.html): Topics associated with the CodeSystem
* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap
* [EventDefinition](eventdefinition.html): Topics associated with the module
* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable
* [Library](library.html): Topics associated with the module
* [Measure](measure.html): Topics associated with the measure
* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem
* [PlanDefinition](plandefinition.html): Topics associated with the module
* [ValueSet](valueset.html): Topics associated with the ValueSet
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TOPIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TOPIC);


}

