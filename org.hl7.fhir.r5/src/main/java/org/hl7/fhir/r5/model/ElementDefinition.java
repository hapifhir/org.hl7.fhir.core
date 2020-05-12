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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

import org.hl7.fhir.instance.model.api.ICompositeType;
import  org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import  org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory;
import  org.hl7.fhir.r5.utils.ToolingExtensions;
import  org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import  org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
/**
 * Base StructureDefinition for ElementDefinition Type: Captures constraints on each element within the resource, profile, or extension.
 */
@DatatypeDef(name="ElementDefinition")
public class ElementDefinition extends BackboneType implements ICompositeType {

    public enum AggregationMode {
        /**
         * The reference is a local reference to a contained resource.
         */
        CONTAINED, 
        /**
         * The reference to a resource that has to be resolved externally to the resource that includes the reference.
         */
        REFERENCED, 
        /**
         * The resource the reference points to will be found in the same bundle as the resource that includes the reference.
         */
        BUNDLED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AggregationMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("contained".equals(codeString))
          return CONTAINED;
        if ("referenced".equals(codeString))
          return REFERENCED;
        if ("bundled".equals(codeString))
          return BUNDLED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AggregationMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CONTAINED: return "contained";
            case REFERENCED: return "referenced";
            case BUNDLED: return "bundled";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CONTAINED: return "http://hl7.org/fhir/resource-aggregation-mode";
            case REFERENCED: return "http://hl7.org/fhir/resource-aggregation-mode";
            case BUNDLED: return "http://hl7.org/fhir/resource-aggregation-mode";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CONTAINED: return "The reference is a local reference to a contained resource.";
            case REFERENCED: return "The reference to a resource that has to be resolved externally to the resource that includes the reference.";
            case BUNDLED: return "The resource the reference points to will be found in the same bundle as the resource that includes the reference.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CONTAINED: return "Contained";
            case REFERENCED: return "Referenced";
            case BUNDLED: return "Bundled";
            default: return "?";
          }
        }
    }

  public static class AggregationModeEnumFactory implements EnumFactory<AggregationMode> {
    public AggregationMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("contained".equals(codeString))
          return AggregationMode.CONTAINED;
        if ("referenced".equals(codeString))
          return AggregationMode.REFERENCED;
        if ("bundled".equals(codeString))
          return AggregationMode.BUNDLED;
        throw new IllegalArgumentException("Unknown AggregationMode code '"+codeString+"'");
        }
        public Enumeration<AggregationMode> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AggregationMode>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("contained".equals(codeString))
          return new Enumeration<AggregationMode>(this, AggregationMode.CONTAINED);
        if ("referenced".equals(codeString))
          return new Enumeration<AggregationMode>(this, AggregationMode.REFERENCED);
        if ("bundled".equals(codeString))
          return new Enumeration<AggregationMode>(this, AggregationMode.BUNDLED);
        throw new FHIRException("Unknown AggregationMode code '"+codeString+"'");
        }
    public String toCode(AggregationMode code) {
      if (code == AggregationMode.CONTAINED)
        return "contained";
      if (code == AggregationMode.REFERENCED)
        return "referenced";
      if (code == AggregationMode.BUNDLED)
        return "bundled";
      return "?";
      }
    public String toSystem(AggregationMode code) {
      return code.getSystem();
      }
    }

    public enum ConstraintSeverity {
        /**
         * If the constraint is violated, the resource is not conformant.
         */
        ERROR, 
        /**
         * If the constraint is violated, the resource is conformant, but it is not necessarily following best practice.
         */
        WARNING, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConstraintSeverity fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("error".equals(codeString))
          return ERROR;
        if ("warning".equals(codeString))
          return WARNING;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConstraintSeverity code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ERROR: return "error";
            case WARNING: return "warning";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ERROR: return "http://hl7.org/fhir/constraint-severity";
            case WARNING: return "http://hl7.org/fhir/constraint-severity";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ERROR: return "If the constraint is violated, the resource is not conformant.";
            case WARNING: return "If the constraint is violated, the resource is conformant, but it is not necessarily following best practice.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ERROR: return "Error";
            case WARNING: return "Warning";
            default: return "?";
          }
        }
    }

  public static class ConstraintSeverityEnumFactory implements EnumFactory<ConstraintSeverity> {
    public ConstraintSeverity fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("error".equals(codeString))
          return ConstraintSeverity.ERROR;
        if ("warning".equals(codeString))
          return ConstraintSeverity.WARNING;
        throw new IllegalArgumentException("Unknown ConstraintSeverity code '"+codeString+"'");
        }
        public Enumeration<ConstraintSeverity> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConstraintSeverity>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("error".equals(codeString))
          return new Enumeration<ConstraintSeverity>(this, ConstraintSeverity.ERROR);
        if ("warning".equals(codeString))
          return new Enumeration<ConstraintSeverity>(this, ConstraintSeverity.WARNING);
        throw new FHIRException("Unknown ConstraintSeverity code '"+codeString+"'");
        }
    public String toCode(ConstraintSeverity code) {
      if (code == ConstraintSeverity.ERROR)
        return "error";
      if (code == ConstraintSeverity.WARNING)
        return "warning";
      return "?";
      }
    public String toSystem(ConstraintSeverity code) {
      return code.getSystem();
      }
    }

    public enum DiscriminatorType {
        /**
         * The slices have different values in the nominated element.
         */
        VALUE, 
        /**
         * The slices are differentiated by the presence or absence of the nominated element.
         */
        EXISTS, 
        /**
         * The slices have different values in the nominated element, as determined by testing them against the applicable ElementDefinition.pattern[x].
         */
        PATTERN, 
        /**
         * The slices are differentiated by type of the nominated element.
         */
        TYPE, 
        /**
         * The slices are differentiated by conformance of the nominated element to a specified profile. Note that if the path specifies .resolve() then the profile is the target profile on the reference. In this case, validation by the possible profiles is required to differentiate the slices.
         */
        PROFILE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DiscriminatorType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("value".equals(codeString))
          return VALUE;
        if ("exists".equals(codeString))
          return EXISTS;
        if ("pattern".equals(codeString))
          return PATTERN;
        if ("type".equals(codeString))
          return TYPE;
        if ("profile".equals(codeString))
          return PROFILE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DiscriminatorType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case VALUE: return "value";
            case EXISTS: return "exists";
            case PATTERN: return "pattern";
            case TYPE: return "type";
            case PROFILE: return "profile";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case VALUE: return "http://hl7.org/fhir/discriminator-type";
            case EXISTS: return "http://hl7.org/fhir/discriminator-type";
            case PATTERN: return "http://hl7.org/fhir/discriminator-type";
            case TYPE: return "http://hl7.org/fhir/discriminator-type";
            case PROFILE: return "http://hl7.org/fhir/discriminator-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case VALUE: return "The slices have different values in the nominated element.";
            case EXISTS: return "The slices are differentiated by the presence or absence of the nominated element.";
            case PATTERN: return "The slices have different values in the nominated element, as determined by testing them against the applicable ElementDefinition.pattern[x].";
            case TYPE: return "The slices are differentiated by type of the nominated element.";
            case PROFILE: return "The slices are differentiated by conformance of the nominated element to a specified profile. Note that if the path specifies .resolve() then the profile is the target profile on the reference. In this case, validation by the possible profiles is required to differentiate the slices.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case VALUE: return "Value";
            case EXISTS: return "Exists";
            case PATTERN: return "Pattern";
            case TYPE: return "Type";
            case PROFILE: return "Profile";
            default: return "?";
          }
        }
    }

  public static class DiscriminatorTypeEnumFactory implements EnumFactory<DiscriminatorType> {
    public DiscriminatorType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("value".equals(codeString))
          return DiscriminatorType.VALUE;
        if ("exists".equals(codeString))
          return DiscriminatorType.EXISTS;
        if ("pattern".equals(codeString))
          return DiscriminatorType.PATTERN;
        if ("type".equals(codeString))
          return DiscriminatorType.TYPE;
        if ("profile".equals(codeString))
          return DiscriminatorType.PROFILE;
        throw new IllegalArgumentException("Unknown DiscriminatorType code '"+codeString+"'");
        }
        public Enumeration<DiscriminatorType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DiscriminatorType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("value".equals(codeString))
          return new Enumeration<DiscriminatorType>(this, DiscriminatorType.VALUE);
        if ("exists".equals(codeString))
          return new Enumeration<DiscriminatorType>(this, DiscriminatorType.EXISTS);
        if ("pattern".equals(codeString))
          return new Enumeration<DiscriminatorType>(this, DiscriminatorType.PATTERN);
        if ("type".equals(codeString))
          return new Enumeration<DiscriminatorType>(this, DiscriminatorType.TYPE);
        if ("profile".equals(codeString))
          return new Enumeration<DiscriminatorType>(this, DiscriminatorType.PROFILE);
        throw new FHIRException("Unknown DiscriminatorType code '"+codeString+"'");
        }
    public String toCode(DiscriminatorType code) {
      if (code == DiscriminatorType.VALUE)
        return "value";
      if (code == DiscriminatorType.EXISTS)
        return "exists";
      if (code == DiscriminatorType.PATTERN)
        return "pattern";
      if (code == DiscriminatorType.TYPE)
        return "type";
      if (code == DiscriminatorType.PROFILE)
        return "profile";
      return "?";
      }
    public String toSystem(DiscriminatorType code) {
      return code.getSystem();
      }
    }

    public enum PropertyRepresentation {
        /**
         * In XML, this property is represented as an attribute not an element.
         */
        XMLATTR, 
        /**
         * This element is represented using the XML text attribute (primitives only).
         */
        XMLTEXT, 
        /**
         * The type of this element is indicated using xsi:type.
         */
        TYPEATTR, 
        /**
         * Use CDA narrative instead of XHTML.
         */
        CDATEXT, 
        /**
         * The property is represented using XHTML.
         */
        XHTML, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static PropertyRepresentation fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("xmlAttr".equals(codeString))
          return XMLATTR;
        if ("xmlText".equals(codeString))
          return XMLTEXT;
        if ("typeAttr".equals(codeString))
          return TYPEATTR;
        if ("cdaText".equals(codeString))
          return CDATEXT;
        if ("xhtml".equals(codeString))
          return XHTML;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown PropertyRepresentation code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case XMLATTR: return "xmlAttr";
            case XMLTEXT: return "xmlText";
            case TYPEATTR: return "typeAttr";
            case CDATEXT: return "cdaText";
            case XHTML: return "xhtml";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case XMLATTR: return "http://hl7.org/fhir/property-representation";
            case XMLTEXT: return "http://hl7.org/fhir/property-representation";
            case TYPEATTR: return "http://hl7.org/fhir/property-representation";
            case CDATEXT: return "http://hl7.org/fhir/property-representation";
            case XHTML: return "http://hl7.org/fhir/property-representation";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case XMLATTR: return "In XML, this property is represented as an attribute not an element.";
            case XMLTEXT: return "This element is represented using the XML text attribute (primitives only).";
            case TYPEATTR: return "The type of this element is indicated using xsi:type.";
            case CDATEXT: return "Use CDA narrative instead of XHTML.";
            case XHTML: return "The property is represented using XHTML.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case XMLATTR: return "XML Attribute";
            case XMLTEXT: return "XML Text";
            case TYPEATTR: return "Type Attribute";
            case CDATEXT: return "CDA Text Format";
            case XHTML: return "XHTML";
            default: return "?";
          }
        }
    }

  public static class PropertyRepresentationEnumFactory implements EnumFactory<PropertyRepresentation> {
    public PropertyRepresentation fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("xmlAttr".equals(codeString))
          return PropertyRepresentation.XMLATTR;
        if ("xmlText".equals(codeString))
          return PropertyRepresentation.XMLTEXT;
        if ("typeAttr".equals(codeString))
          return PropertyRepresentation.TYPEATTR;
        if ("cdaText".equals(codeString))
          return PropertyRepresentation.CDATEXT;
        if ("xhtml".equals(codeString))
          return PropertyRepresentation.XHTML;
        throw new IllegalArgumentException("Unknown PropertyRepresentation code '"+codeString+"'");
        }
        public Enumeration<PropertyRepresentation> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PropertyRepresentation>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("xmlAttr".equals(codeString))
          return new Enumeration<PropertyRepresentation>(this, PropertyRepresentation.XMLATTR);
        if ("xmlText".equals(codeString))
          return new Enumeration<PropertyRepresentation>(this, PropertyRepresentation.XMLTEXT);
        if ("typeAttr".equals(codeString))
          return new Enumeration<PropertyRepresentation>(this, PropertyRepresentation.TYPEATTR);
        if ("cdaText".equals(codeString))
          return new Enumeration<PropertyRepresentation>(this, PropertyRepresentation.CDATEXT);
        if ("xhtml".equals(codeString))
          return new Enumeration<PropertyRepresentation>(this, PropertyRepresentation.XHTML);
        throw new FHIRException("Unknown PropertyRepresentation code '"+codeString+"'");
        }
    public String toCode(PropertyRepresentation code) {
      if (code == PropertyRepresentation.XMLATTR)
        return "xmlAttr";
      if (code == PropertyRepresentation.XMLTEXT)
        return "xmlText";
      if (code == PropertyRepresentation.TYPEATTR)
        return "typeAttr";
      if (code == PropertyRepresentation.CDATEXT)
        return "cdaText";
      if (code == PropertyRepresentation.XHTML)
        return "xhtml";
      return "?";
      }
    public String toSystem(PropertyRepresentation code) {
      return code.getSystem();
      }
    }

    public enum ReferenceVersionRules {
        /**
         * The reference may be either version independent or version specific.
         */
        EITHER, 
        /**
         * The reference must be version independent.
         */
        INDEPENDENT, 
        /**
         * The reference must be version specific.
         */
        SPECIFIC, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ReferenceVersionRules fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("either".equals(codeString))
          return EITHER;
        if ("independent".equals(codeString))
          return INDEPENDENT;
        if ("specific".equals(codeString))
          return SPECIFIC;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ReferenceVersionRules code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EITHER: return "either";
            case INDEPENDENT: return "independent";
            case SPECIFIC: return "specific";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EITHER: return "http://hl7.org/fhir/reference-version-rules";
            case INDEPENDENT: return "http://hl7.org/fhir/reference-version-rules";
            case SPECIFIC: return "http://hl7.org/fhir/reference-version-rules";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EITHER: return "The reference may be either version independent or version specific.";
            case INDEPENDENT: return "The reference must be version independent.";
            case SPECIFIC: return "The reference must be version specific.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EITHER: return "Either Specific or independent";
            case INDEPENDENT: return "Version independent";
            case SPECIFIC: return "Version Specific";
            default: return "?";
          }
        }
    }

  public static class ReferenceVersionRulesEnumFactory implements EnumFactory<ReferenceVersionRules> {
    public ReferenceVersionRules fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("either".equals(codeString))
          return ReferenceVersionRules.EITHER;
        if ("independent".equals(codeString))
          return ReferenceVersionRules.INDEPENDENT;
        if ("specific".equals(codeString))
          return ReferenceVersionRules.SPECIFIC;
        throw new IllegalArgumentException("Unknown ReferenceVersionRules code '"+codeString+"'");
        }
        public Enumeration<ReferenceVersionRules> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ReferenceVersionRules>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("either".equals(codeString))
          return new Enumeration<ReferenceVersionRules>(this, ReferenceVersionRules.EITHER);
        if ("independent".equals(codeString))
          return new Enumeration<ReferenceVersionRules>(this, ReferenceVersionRules.INDEPENDENT);
        if ("specific".equals(codeString))
          return new Enumeration<ReferenceVersionRules>(this, ReferenceVersionRules.SPECIFIC);
        throw new FHIRException("Unknown ReferenceVersionRules code '"+codeString+"'");
        }
    public String toCode(ReferenceVersionRules code) {
      if (code == ReferenceVersionRules.EITHER)
        return "either";
      if (code == ReferenceVersionRules.INDEPENDENT)
        return "independent";
      if (code == ReferenceVersionRules.SPECIFIC)
        return "specific";
      return "?";
      }
    public String toSystem(ReferenceVersionRules code) {
      return code.getSystem();
      }
    }

    public enum SlicingRules {
        /**
         * No additional content is allowed other than that described by the slices in this profile.
         */
        CLOSED, 
        /**
         * Additional content is allowed anywhere in the list.
         */
        OPEN, 
        /**
         * Additional content is allowed, but only at the end of the list. Note that using this requires that the slices be ordered, which makes it hard to share uses. This should only be done where absolutely required.
         */
        OPENATEND, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SlicingRules fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("closed".equals(codeString))
          return CLOSED;
        if ("open".equals(codeString))
          return OPEN;
        if ("openAtEnd".equals(codeString))
          return OPENATEND;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SlicingRules code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CLOSED: return "closed";
            case OPEN: return "open";
            case OPENATEND: return "openAtEnd";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CLOSED: return "http://hl7.org/fhir/resource-slicing-rules";
            case OPEN: return "http://hl7.org/fhir/resource-slicing-rules";
            case OPENATEND: return "http://hl7.org/fhir/resource-slicing-rules";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CLOSED: return "No additional content is allowed other than that described by the slices in this profile.";
            case OPEN: return "Additional content is allowed anywhere in the list.";
            case OPENATEND: return "Additional content is allowed, but only at the end of the list. Note that using this requires that the slices be ordered, which makes it hard to share uses. This should only be done where absolutely required.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CLOSED: return "Closed";
            case OPEN: return "Open";
            case OPENATEND: return "Open at End";
            default: return "?";
          }
        }
    }

  public static class SlicingRulesEnumFactory implements EnumFactory<SlicingRules> {
    public SlicingRules fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("closed".equals(codeString))
          return SlicingRules.CLOSED;
        if ("open".equals(codeString))
          return SlicingRules.OPEN;
        if ("openAtEnd".equals(codeString))
          return SlicingRules.OPENATEND;
        throw new IllegalArgumentException("Unknown SlicingRules code '"+codeString+"'");
        }
        public Enumeration<SlicingRules> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SlicingRules>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("closed".equals(codeString))
          return new Enumeration<SlicingRules>(this, SlicingRules.CLOSED);
        if ("open".equals(codeString))
          return new Enumeration<SlicingRules>(this, SlicingRules.OPEN);
        if ("openAtEnd".equals(codeString))
          return new Enumeration<SlicingRules>(this, SlicingRules.OPENATEND);
        throw new FHIRException("Unknown SlicingRules code '"+codeString+"'");
        }
    public String toCode(SlicingRules code) {
      if (code == SlicingRules.CLOSED)
        return "closed";
      if (code == SlicingRules.OPEN)
        return "open";
      if (code == SlicingRules.OPENATEND)
        return "openAtEnd";
      return "?";
      }
    public String toSystem(SlicingRules code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ElementDefinitionSlicingComponent extends Element implements IBaseDatatypeElement {
        /**
         * Designates which child elements are used to discriminate between the slices when processing an instance. If one or more discriminators are provided, the value of the child elements in the instance data SHALL completely distinguish which slice the element in the resource matches based on the allowed values for those elements in each of the slices.
         */
        @Child(name = "discriminator", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Element values that are used to distinguish the slices", formalDefinition="Designates which child elements are used to discriminate between the slices when processing an instance. If one or more discriminators are provided, the value of the child elements in the instance data SHALL completely distinguish which slice the element in the resource matches based on the allowed values for those elements in each of the slices." )
        protected List<ElementDefinitionSlicingDiscriminatorComponent> discriminator;

        /**
         * A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text description of how slicing works (or not)", formalDefinition="A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated." )
        protected StringType description;

        /**
         * If the matching elements have to occur in the same order as defined in the profile.
         */
        @Child(name = "ordered", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="If elements must be in same order as slices", formalDefinition="If the matching elements have to occur in the same order as defined in the profile." )
        protected BooleanType ordered;

        /**
         * Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.
         */
        @Child(name = "rules", type = {CodeType.class}, order=4, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="closed | open | openAtEnd", formalDefinition="Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-slicing-rules")
        protected Enumeration<SlicingRules> rules;

        private static final long serialVersionUID = -311635839L;

    /**
     * Constructor
     */
      public ElementDefinitionSlicingComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionSlicingComponent(SlicingRules rules) {
        super();
        this.setRules(rules);
      }

        /**
         * @return {@link #discriminator} (Designates which child elements are used to discriminate between the slices when processing an instance. If one or more discriminators are provided, the value of the child elements in the instance data SHALL completely distinguish which slice the element in the resource matches based on the allowed values for those elements in each of the slices.)
         */
        public List<ElementDefinitionSlicingDiscriminatorComponent> getDiscriminator() { 
          if (this.discriminator == null)
            this.discriminator = new ArrayList<ElementDefinitionSlicingDiscriminatorComponent>();
          return this.discriminator;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ElementDefinitionSlicingComponent setDiscriminator(List<ElementDefinitionSlicingDiscriminatorComponent> theDiscriminator) { 
          this.discriminator = theDiscriminator;
          return this;
        }

        public boolean hasDiscriminator() { 
          if (this.discriminator == null)
            return false;
          for (ElementDefinitionSlicingDiscriminatorComponent item : this.discriminator)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ElementDefinitionSlicingDiscriminatorComponent addDiscriminator() { //3
          ElementDefinitionSlicingDiscriminatorComponent t = new ElementDefinitionSlicingDiscriminatorComponent();
          if (this.discriminator == null)
            this.discriminator = new ArrayList<ElementDefinitionSlicingDiscriminatorComponent>();
          this.discriminator.add(t);
          return t;
        }

        public ElementDefinitionSlicingComponent addDiscriminator(ElementDefinitionSlicingDiscriminatorComponent t) { //3
          if (t == null)
            return this;
          if (this.discriminator == null)
            this.discriminator = new ArrayList<ElementDefinitionSlicingDiscriminatorComponent>();
          this.discriminator.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #discriminator}, creating it if it does not already exist {3}
         */
        public ElementDefinitionSlicingDiscriminatorComponent getDiscriminatorFirstRep() { 
          if (getDiscriminator().isEmpty()) {
            addDiscriminator();
          }
          return getDiscriminator().get(0);
        }

        /**
         * @return {@link #description} (A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionSlicingComponent.description");
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
         * @param value {@link #description} (A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ElementDefinitionSlicingComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.
         */
        public ElementDefinitionSlicingComponent setDescription(String value) { 
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
         * @return {@link #ordered} (If the matching elements have to occur in the same order as defined in the profile.). This is the underlying object with id, value and extensions. The accessor "getOrdered" gives direct access to the value
         */
        public BooleanType getOrderedElement() { 
          if (this.ordered == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionSlicingComponent.ordered");
            else if (Configuration.doAutoCreate())
              this.ordered = new BooleanType(); // bb
          return this.ordered;
        }

        public boolean hasOrderedElement() { 
          return this.ordered != null && !this.ordered.isEmpty();
        }

        public boolean hasOrdered() { 
          return this.ordered != null && !this.ordered.isEmpty();
        }

        /**
         * @param value {@link #ordered} (If the matching elements have to occur in the same order as defined in the profile.). This is the underlying object with id, value and extensions. The accessor "getOrdered" gives direct access to the value
         */
        public ElementDefinitionSlicingComponent setOrderedElement(BooleanType value) { 
          this.ordered = value;
          return this;
        }

        /**
         * @return If the matching elements have to occur in the same order as defined in the profile.
         */
        public boolean getOrdered() { 
          return this.ordered == null || this.ordered.isEmpty() ? false : this.ordered.getValue();
        }

        /**
         * @param value If the matching elements have to occur in the same order as defined in the profile.
         */
        public ElementDefinitionSlicingComponent setOrdered(boolean value) { 
            if (this.ordered == null)
              this.ordered = new BooleanType();
            this.ordered.setValue(value);
          return this;
        }

        /**
         * @return {@link #rules} (Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.). This is the underlying object with id, value and extensions. The accessor "getRules" gives direct access to the value
         */
        public Enumeration<SlicingRules> getRulesElement() { 
          if (this.rules == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionSlicingComponent.rules");
            else if (Configuration.doAutoCreate())
              this.rules = new Enumeration<SlicingRules>(new SlicingRulesEnumFactory()); // bb
          return this.rules;
        }

        public boolean hasRulesElement() { 
          return this.rules != null && !this.rules.isEmpty();
        }

        public boolean hasRules() { 
          return this.rules != null && !this.rules.isEmpty();
        }

        /**
         * @param value {@link #rules} (Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.). This is the underlying object with id, value and extensions. The accessor "getRules" gives direct access to the value
         */
        public ElementDefinitionSlicingComponent setRulesElement(Enumeration<SlicingRules> value) { 
          this.rules = value;
          return this;
        }

        /**
         * @return Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.
         */
        public SlicingRules getRules() { 
          return this.rules == null ? null : this.rules.getValue();
        }

        /**
         * @param value Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.
         */
        public ElementDefinitionSlicingComponent setRules(SlicingRules value) { 
            if (this.rules == null)
              this.rules = new Enumeration<SlicingRules>(new SlicingRulesEnumFactory());
            this.rules.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("discriminator", "", "Designates which child elements are used to discriminate between the slices when processing an instance. If one or more discriminators are provided, the value of the child elements in the instance data SHALL completely distinguish which slice the element in the resource matches based on the allowed values for those elements in each of the slices.", 0, java.lang.Integer.MAX_VALUE, discriminator));
          children.add(new Property("description", "string", "A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.", 0, 1, description));
          children.add(new Property("ordered", "boolean", "If the matching elements have to occur in the same order as defined in the profile.", 0, 1, ordered));
          children.add(new Property("rules", "code", "Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.", 0, 1, rules));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1888270692: /*discriminator*/  return new Property("discriminator", "", "Designates which child elements are used to discriminate between the slices when processing an instance. If one or more discriminators are provided, the value of the child elements in the instance data SHALL completely distinguish which slice the element in the resource matches based on the allowed values for those elements in each of the slices.", 0, java.lang.Integer.MAX_VALUE, discriminator);
          case -1724546052: /*description*/  return new Property("description", "string", "A human-readable text description of how the slicing works. If there is no discriminator, this is required to be present to provide whatever information is possible about how the slices can be differentiated.", 0, 1, description);
          case -1207109523: /*ordered*/  return new Property("ordered", "boolean", "If the matching elements have to occur in the same order as defined in the profile.", 0, 1, ordered);
          case 108873975: /*rules*/  return new Property("rules", "code", "Whether additional slices are allowed or not. When the slices are ordered, profile authors can also say that additional slices are only allowed at the end.", 0, 1, rules);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1888270692: /*discriminator*/ return this.discriminator == null ? new Base[0] : this.discriminator.toArray(new Base[this.discriminator.size()]); // ElementDefinitionSlicingDiscriminatorComponent
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1207109523: /*ordered*/ return this.ordered == null ? new Base[0] : new Base[] {this.ordered}; // BooleanType
        case 108873975: /*rules*/ return this.rules == null ? new Base[0] : new Base[] {this.rules}; // Enumeration<SlicingRules>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1888270692: // discriminator
          this.getDiscriminator().add((ElementDefinitionSlicingDiscriminatorComponent) value); // ElementDefinitionSlicingDiscriminatorComponent
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1207109523: // ordered
          this.ordered = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 108873975: // rules
          value = new SlicingRulesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.rules = (Enumeration) value; // Enumeration<SlicingRules>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("discriminator")) {
          this.getDiscriminator().add((ElementDefinitionSlicingDiscriminatorComponent) value);
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("ordered")) {
          this.ordered = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("rules")) {
          value = new SlicingRulesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.rules = (Enumeration) value; // Enumeration<SlicingRules>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1888270692:  return addDiscriminator(); 
        case -1724546052:  return getDescriptionElement();
        case -1207109523:  return getOrderedElement();
        case 108873975:  return getRulesElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1888270692: /*discriminator*/ return new String[] {};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1207109523: /*ordered*/ return new String[] {"boolean"};
        case 108873975: /*rules*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("discriminator")) {
          return addDiscriminator();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.slicing.description");
        }
        else if (name.equals("ordered")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.slicing.ordered");
        }
        else if (name.equals("rules")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.slicing.rules");
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionSlicingComponent copy() {
        ElementDefinitionSlicingComponent dst = new ElementDefinitionSlicingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionSlicingComponent dst) {
        super.copyValues(dst);
        if (discriminator != null) {
          dst.discriminator = new ArrayList<ElementDefinitionSlicingDiscriminatorComponent>();
          for (ElementDefinitionSlicingDiscriminatorComponent i : discriminator)
            dst.discriminator.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.ordered = ordered == null ? null : ordered.copy();
        dst.rules = rules == null ? null : rules.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionSlicingComponent))
          return false;
        ElementDefinitionSlicingComponent o = (ElementDefinitionSlicingComponent) other_;
        return compareDeep(discriminator, o.discriminator, true) && compareDeep(description, o.description, true)
           && compareDeep(ordered, o.ordered, true) && compareDeep(rules, o.rules, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionSlicingComponent))
          return false;
        ElementDefinitionSlicingComponent o = (ElementDefinitionSlicingComponent) other_;
        return compareValues(description, o.description, true) && compareValues(ordered, o.ordered, true) && compareValues(rules, o.rules, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(discriminator, description
          , ordered, rules);
      }

  public String fhirType() {
    return "ElementDefinition.slicing";

  }

  }

    @Block()
    public static class ElementDefinitionSlicingDiscriminatorComponent extends Element implements IBaseDatatypeElement {
        /**
         * How the element value is interpreted when discrimination is evaluated.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="value | exists | pattern | type | profile", formalDefinition="How the element value is interpreted when discrimination is evaluated." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/discriminator-type")
        protected Enumeration<DiscriminatorType> type;

        /**
         * A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.
         */
        @Child(name = "path", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Path to element value", formalDefinition="A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based." )
        protected StringType path;

        private static final long serialVersionUID = 1151159293L;

    /**
     * Constructor
     */
      public ElementDefinitionSlicingDiscriminatorComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionSlicingDiscriminatorComponent(DiscriminatorType type, String path) {
        super();
        this.setType(type);
        this.setPath(path);
      }

        /**
         * @return {@link #type} (How the element value is interpreted when discrimination is evaluated.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<DiscriminatorType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionSlicingDiscriminatorComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<DiscriminatorType>(new DiscriminatorTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (How the element value is interpreted when discrimination is evaluated.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ElementDefinitionSlicingDiscriminatorComponent setTypeElement(Enumeration<DiscriminatorType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return How the element value is interpreted when discrimination is evaluated.
         */
        public DiscriminatorType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value How the element value is interpreted when discrimination is evaluated.
         */
        public ElementDefinitionSlicingDiscriminatorComponent setType(DiscriminatorType value) { 
            if (this.type == null)
              this.type = new Enumeration<DiscriminatorType>(new DiscriminatorTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #path} (A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionSlicingDiscriminatorComponent.path");
            else if (Configuration.doAutoCreate())
              this.path = new StringType(); // bb
          return this.path;
        }

        public boolean hasPathElement() { 
          return this.path != null && !this.path.isEmpty();
        }

        public boolean hasPath() { 
          return this.path != null && !this.path.isEmpty();
        }

        /**
         * @param value {@link #path} (A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public ElementDefinitionSlicingDiscriminatorComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.
         */
        public ElementDefinitionSlicingDiscriminatorComponent setPath(String value) { 
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "How the element value is interpreted when discrimination is evaluated.", 0, 1, type));
          children.add(new Property("path", "string", "A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.", 0, 1, path));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "How the element value is interpreted when discrimination is evaluated.", 0, 1, type);
          case 3433509: /*path*/  return new Property("path", "string", "A FHIRPath expression, using [the simple subset of FHIRPath](fhirpath.html#simple), that is used to identify the element on which discrimination is based.", 0, 1, path);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<DiscriminatorType>
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new DiscriminatorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DiscriminatorType>
          return value;
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new DiscriminatorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<DiscriminatorType>
        } else if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 3433509:  return getPathElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 3433509: /*path*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.slicing.discriminator.type");
        }
        else if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.slicing.discriminator.path");
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionSlicingDiscriminatorComponent copy() {
        ElementDefinitionSlicingDiscriminatorComponent dst = new ElementDefinitionSlicingDiscriminatorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionSlicingDiscriminatorComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.path = path == null ? null : path.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionSlicingDiscriminatorComponent))
          return false;
        ElementDefinitionSlicingDiscriminatorComponent o = (ElementDefinitionSlicingDiscriminatorComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(path, o.path, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionSlicingDiscriminatorComponent))
          return false;
        ElementDefinitionSlicingDiscriminatorComponent o = (ElementDefinitionSlicingDiscriminatorComponent) other_;
        return compareValues(type, o.type, true) && compareValues(path, o.path, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, path);
      }

  public String fhirType() {
    return "ElementDefinition.slicing.discriminator";

  }

  }

    @Block()
    public static class ElementDefinitionBaseComponent extends Element implements IBaseDatatypeElement {
        /**
         * The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Path that identifies the base element", formalDefinition="The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base." )
        protected StringType path;

        /**
         * Minimum cardinality of the base element identified by the path.
         */
        @Child(name = "min", type = {UnsignedIntType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Min cardinality of the base element", formalDefinition="Minimum cardinality of the base element identified by the path." )
        protected UnsignedIntType min;

        /**
         * Maximum cardinality of the base element identified by the path.
         */
        @Child(name = "max", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Max cardinality of the base element", formalDefinition="Maximum cardinality of the base element identified by the path." )
        protected StringType max;

        private static final long serialVersionUID = -1412704221L;

    /**
     * Constructor
     */
      public ElementDefinitionBaseComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionBaseComponent(String path, int min, String max) {
        super();
        this.setPath(path);
        this.setMin(min);
        this.setMax(max);
      }

        /**
         * @return {@link #path} (The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionBaseComponent.path");
            else if (Configuration.doAutoCreate())
              this.path = new StringType(); // bb
          return this.path;
        }

        public boolean hasPathElement() { 
          return this.path != null && !this.path.isEmpty();
        }

        public boolean hasPath() { 
          return this.path != null && !this.path.isEmpty();
        }

        /**
         * @param value {@link #path} (The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public ElementDefinitionBaseComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.
         */
        public ElementDefinitionBaseComponent setPath(String value) { 
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          return this;
        }

        /**
         * @return {@link #min} (Minimum cardinality of the base element identified by the path.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
         */
        public UnsignedIntType getMinElement() { 
          if (this.min == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionBaseComponent.min");
            else if (Configuration.doAutoCreate())
              this.min = new UnsignedIntType(); // bb
          return this.min;
        }

        public boolean hasMinElement() { 
          return this.min != null && !this.min.isEmpty();
        }

        public boolean hasMin() { 
          return this.min != null && !this.min.isEmpty();
        }

        /**
         * @param value {@link #min} (Minimum cardinality of the base element identified by the path.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
         */
        public ElementDefinitionBaseComponent setMinElement(UnsignedIntType value) { 
          this.min = value;
          return this;
        }

        /**
         * @return Minimum cardinality of the base element identified by the path.
         */
        public int getMin() { 
          return this.min == null || this.min.isEmpty() ? 0 : this.min.getValue();
        }

        /**
         * @param value Minimum cardinality of the base element identified by the path.
         */
        public ElementDefinitionBaseComponent setMin(int value) { 
            if (this.min == null)
              this.min = new UnsignedIntType();
            this.min.setValue(value);
          return this;
        }

        /**
         * @return {@link #max} (Maximum cardinality of the base element identified by the path.). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
         */
        public StringType getMaxElement() { 
          if (this.max == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionBaseComponent.max");
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
         * @param value {@link #max} (Maximum cardinality of the base element identified by the path.). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
         */
        public ElementDefinitionBaseComponent setMaxElement(StringType value) { 
          this.max = value;
          return this;
        }

        /**
         * @return Maximum cardinality of the base element identified by the path.
         */
        public String getMax() { 
          return this.max == null ? null : this.max.getValue();
        }

        /**
         * @param value Maximum cardinality of the base element identified by the path.
         */
        public ElementDefinitionBaseComponent setMax(String value) { 
            if (this.max == null)
              this.max = new StringType();
            this.max.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.", 0, 1, path));
          children.add(new Property("min", "unsignedInt", "Minimum cardinality of the base element identified by the path.", 0, 1, min));
          children.add(new Property("max", "string", "Maximum cardinality of the base element identified by the path.", 0, 1, max));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The Path that identifies the base element - this matches the ElementDefinition.path for that element. Across FHIR, there is only one base definition of any element - that is, an element definition on a [StructureDefinition](structuredefinition.html#) without a StructureDefinition.base.", 0, 1, path);
          case 108114: /*min*/  return new Property("min", "unsignedInt", "Minimum cardinality of the base element identified by the path.", 0, 1, min);
          case 107876: /*max*/  return new Property("max", "string", "Maximum cardinality of the base element identified by the path.", 0, 1, max);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case 108114: /*min*/ return this.min == null ? new Base[0] : new Base[] {this.min}; // UnsignedIntType
        case 107876: /*max*/ return this.max == null ? new Base[0] : new Base[] {this.max}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case 108114: // min
          this.min = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 107876: // max
          this.max = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("min")) {
          this.min = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("max")) {
          this.max = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case 108114:  return getMinElement();
        case 107876:  return getMaxElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case 108114: /*min*/ return new String[] {"unsignedInt"};
        case 107876: /*max*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.base.path");
        }
        else if (name.equals("min")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.base.min");
        }
        else if (name.equals("max")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.base.max");
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionBaseComponent copy() {
        ElementDefinitionBaseComponent dst = new ElementDefinitionBaseComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionBaseComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.min = min == null ? null : min.copy();
        dst.max = max == null ? null : max.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionBaseComponent))
          return false;
        ElementDefinitionBaseComponent o = (ElementDefinitionBaseComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(min, o.min, true) && compareDeep(max, o.max, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionBaseComponent))
          return false;
        ElementDefinitionBaseComponent o = (ElementDefinitionBaseComponent) other_;
        return compareValues(path, o.path, true) && compareValues(min, o.min, true) && compareValues(max, o.max, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, min, max);
      }

  public String fhirType() {
    return "ElementDefinition.base";

  }

  }

    @Block()
    public static class TypeRefComponent extends Element implements IBaseDatatypeElement {
        /**
         * URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.
         */
        @Child(name = "code", type = {UriType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Data type or Resource (reference to definition)", formalDefinition="URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. \"string\" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/defined-types")
        protected UriType code;

        /**
         * Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.
         */
        @Child(name = "profile", type = {CanonicalType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Profiles (StructureDefinition or IG) - one must apply", formalDefinition="Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide." )
        protected List<CanonicalType> profile;

        /**
         * Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.
         */
        @Child(name = "targetProfile", type = {CanonicalType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Profile (StructureDefinition or IG) on the Reference/canonical target - one must apply", formalDefinition="Used when the type is \"Reference\" or \"canonical\", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide." )
        protected List<CanonicalType> targetProfile;

        /**
         * If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.
         */
        @Child(name = "aggregation", type = {CodeType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="contained | referenced | bundled - how aggregated", formalDefinition="If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-aggregation-mode")
        protected List<Enumeration<AggregationMode>> aggregation;

        /**
         * Whether this reference needs to be version specific or version independent, or whether either can be used.
         */
        @Child(name = "versioning", type = {CodeType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="either | independent | specific", formalDefinition="Whether this reference needs to be version specific or version independent, or whether either can be used." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/reference-version-rules")
        protected Enumeration<ReferenceVersionRules> versioning;

        private static final long serialVersionUID = 957891653L;

    /**
     * Constructor
     */
      public TypeRefComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TypeRefComponent(String code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public UriType getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TypeRefComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new UriType(); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public TypeRefComponent setCodeElement(UriType value) { 
          this.code = value;
          return this;
        }

        /**
         * @return URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.
         */
        public String getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.
         */
        public TypeRefComponent setCode(String value) { 
            if (this.code == null)
              this.code = new UriType();
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #profile} (Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.)
         */
        public List<CanonicalType> getProfile() { 
          if (this.profile == null)
            this.profile = new ArrayList<CanonicalType>();
          return this.profile;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TypeRefComponent setProfile(List<CanonicalType> theProfile) { 
          this.profile = theProfile;
          return this;
        }

        public boolean hasProfile() { 
          if (this.profile == null)
            return false;
          for (CanonicalType item : this.profile)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #profile} (Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.)
         */
        public CanonicalType addProfileElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.profile == null)
            this.profile = new ArrayList<CanonicalType>();
          this.profile.add(t);
          return t;
        }

        /**
         * @param value {@link #profile} (Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.)
         */
        public TypeRefComponent addProfile(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.profile == null)
            this.profile = new ArrayList<CanonicalType>();
          this.profile.add(t);
          return this;
        }

        /**
         * @param value {@link #profile} (Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.)
         */
        public boolean hasProfile(String value) { 
          if (this.profile == null)
            return false;
          for (CanonicalType v : this.profile)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        /**
         * @return {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public List<CanonicalType> getTargetProfile() { 
          if (this.targetProfile == null)
            this.targetProfile = new ArrayList<CanonicalType>();
          return this.targetProfile;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TypeRefComponent setTargetProfile(List<CanonicalType> theTargetProfile) { 
          this.targetProfile = theTargetProfile;
          return this;
        }

        public boolean hasTargetProfile() { 
          if (this.targetProfile == null)
            return false;
          for (CanonicalType item : this.targetProfile)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public CanonicalType addTargetProfileElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.targetProfile == null)
            this.targetProfile = new ArrayList<CanonicalType>();
          this.targetProfile.add(t);
          return t;
        }

        /**
         * @param value {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public TypeRefComponent addTargetProfile(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.targetProfile == null)
            this.targetProfile = new ArrayList<CanonicalType>();
          this.targetProfile.add(t);
          return this;
        }

        /**
         * @param value {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public boolean hasTargetProfile(String value) { 
          if (this.targetProfile == null)
            return false;
          for (CanonicalType v : this.targetProfile)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        /**
         * @return {@link #aggregation} (If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.)
         */
        public List<Enumeration<AggregationMode>> getAggregation() { 
          if (this.aggregation == null)
            this.aggregation = new ArrayList<Enumeration<AggregationMode>>();
          return this.aggregation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TypeRefComponent setAggregation(List<Enumeration<AggregationMode>> theAggregation) { 
          this.aggregation = theAggregation;
          return this;
        }

        public boolean hasAggregation() { 
          if (this.aggregation == null)
            return false;
          for (Enumeration<AggregationMode> item : this.aggregation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #aggregation} (If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.)
         */
        public Enumeration<AggregationMode> addAggregationElement() {//2 
          Enumeration<AggregationMode> t = new Enumeration<AggregationMode>(new AggregationModeEnumFactory());
          if (this.aggregation == null)
            this.aggregation = new ArrayList<Enumeration<AggregationMode>>();
          this.aggregation.add(t);
          return t;
        }

        /**
         * @param value {@link #aggregation} (If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.)
         */
        public TypeRefComponent addAggregation(AggregationMode value) { //1
          Enumeration<AggregationMode> t = new Enumeration<AggregationMode>(new AggregationModeEnumFactory());
          t.setValue(value);
          if (this.aggregation == null)
            this.aggregation = new ArrayList<Enumeration<AggregationMode>>();
          this.aggregation.add(t);
          return this;
        }

        /**
         * @param value {@link #aggregation} (If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.)
         */
        public boolean hasAggregation(AggregationMode value) { 
          if (this.aggregation == null)
            return false;
          for (Enumeration<AggregationMode> v : this.aggregation)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #versioning} (Whether this reference needs to be version specific or version independent, or whether either can be used.). This is the underlying object with id, value and extensions. The accessor "getVersioning" gives direct access to the value
         */
        public Enumeration<ReferenceVersionRules> getVersioningElement() { 
          if (this.versioning == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TypeRefComponent.versioning");
            else if (Configuration.doAutoCreate())
              this.versioning = new Enumeration<ReferenceVersionRules>(new ReferenceVersionRulesEnumFactory()); // bb
          return this.versioning;
        }

        public boolean hasVersioningElement() { 
          return this.versioning != null && !this.versioning.isEmpty();
        }

        public boolean hasVersioning() { 
          return this.versioning != null && !this.versioning.isEmpty();
        }

        /**
         * @param value {@link #versioning} (Whether this reference needs to be version specific or version independent, or whether either can be used.). This is the underlying object with id, value and extensions. The accessor "getVersioning" gives direct access to the value
         */
        public TypeRefComponent setVersioningElement(Enumeration<ReferenceVersionRules> value) { 
          this.versioning = value;
          return this;
        }

        /**
         * @return Whether this reference needs to be version specific or version independent, or whether either can be used.
         */
        public ReferenceVersionRules getVersioning() { 
          return this.versioning == null ? null : this.versioning.getValue();
        }

        /**
         * @param value Whether this reference needs to be version specific or version independent, or whether either can be used.
         */
        public TypeRefComponent setVersioning(ReferenceVersionRules value) { 
          if (value == null)
            this.versioning = null;
          else {
            if (this.versioning == null)
              this.versioning = new Enumeration<ReferenceVersionRules>(new ReferenceVersionRulesEnumFactory());
            this.versioning.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "uri", "URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. \"string\" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.", 0, 1, code));
          children.add(new Property("profile", "canonical(StructureDefinition|ImplementationGuide)", "Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.", 0, java.lang.Integer.MAX_VALUE, profile));
          children.add(new Property("targetProfile", "canonical(StructureDefinition|ImplementationGuide)", "Used when the type is \"Reference\" or \"canonical\", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.", 0, java.lang.Integer.MAX_VALUE, targetProfile));
          children.add(new Property("aggregation", "code", "If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.", 0, java.lang.Integer.MAX_VALUE, aggregation));
          children.add(new Property("versioning", "code", "Whether this reference needs to be version specific or version independent, or whether either can be used.", 0, 1, versioning));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "uri", "URL of Data type or Resource that is a(or the) type used for this element. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. \"string\" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.", 0, 1, code);
          case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition|ImplementationGuide)", "Identifies a profile structure or implementation Guide that applies to the datatype this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the type SHALL conform to at least one profile defined in the implementation guide.", 0, java.lang.Integer.MAX_VALUE, profile);
          case 1994521304: /*targetProfile*/  return new Property("targetProfile", "canonical(StructureDefinition|ImplementationGuide)", "Used when the type is \"Reference\" or \"canonical\", and identifies a profile structure or implementation Guide that applies to the target of the reference this element refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.", 0, java.lang.Integer.MAX_VALUE, targetProfile);
          case 841524962: /*aggregation*/  return new Property("aggregation", "code", "If the type is a reference to another resource, how the resource is or can be aggregated - is it a contained resource, or a reference, and if the context is a bundle, is it included in the bundle.", 0, java.lang.Integer.MAX_VALUE, aggregation);
          case -670487542: /*versioning*/  return new Property("versioning", "code", "Whether this reference needs to be version specific or version independent, or whether either can be used.", 0, 1, versioning);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // UriType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : this.profile.toArray(new Base[this.profile.size()]); // CanonicalType
        case 1994521304: /*targetProfile*/ return this.targetProfile == null ? new Base[0] : this.targetProfile.toArray(new Base[this.targetProfile.size()]); // CanonicalType
        case 841524962: /*aggregation*/ return this.aggregation == null ? new Base[0] : this.aggregation.toArray(new Base[this.aggregation.size()]); // Enumeration<AggregationMode>
        case -670487542: /*versioning*/ return this.versioning == null ? new Base[0] : new Base[] {this.versioning}; // Enumeration<ReferenceVersionRules>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToUri(value); // UriType
          return value;
        case -309425751: // profile
          this.getProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1994521304: // targetProfile
          this.getTargetProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 841524962: // aggregation
          value = new AggregationModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getAggregation().add((Enumeration) value); // Enumeration<AggregationMode>
          return value;
        case -670487542: // versioning
          value = new ReferenceVersionRulesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.versioning = (Enumeration) value; // Enumeration<ReferenceVersionRules>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("profile")) {
          this.getProfile().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("targetProfile")) {
          this.getTargetProfile().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("aggregation")) {
          value = new AggregationModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getAggregation().add((Enumeration) value);
        } else if (name.equals("versioning")) {
          value = new ReferenceVersionRulesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.versioning = (Enumeration) value; // Enumeration<ReferenceVersionRules>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case -309425751:  return addProfileElement();
        case 1994521304:  return addTargetProfileElement();
        case 841524962:  return addAggregationElement();
        case -670487542:  return getVersioningElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"uri"};
        case -309425751: /*profile*/ return new String[] {"canonical"};
        case 1994521304: /*targetProfile*/ return new String[] {"canonical"};
        case 841524962: /*aggregation*/ return new String[] {"code"};
        case -670487542: /*versioning*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.type.code");
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.type.profile");
        }
        else if (name.equals("targetProfile")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.type.targetProfile");
        }
        else if (name.equals("aggregation")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.type.aggregation");
        }
        else if (name.equals("versioning")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.type.versioning");
        }
        else
          return super.addChild(name);
      }

      public TypeRefComponent copy() {
        TypeRefComponent dst = new TypeRefComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TypeRefComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (profile != null) {
          dst.profile = new ArrayList<CanonicalType>();
          for (CanonicalType i : profile)
            dst.profile.add(i.copy());
        };
        if (targetProfile != null) {
          dst.targetProfile = new ArrayList<CanonicalType>();
          for (CanonicalType i : targetProfile)
            dst.targetProfile.add(i.copy());
        };
        if (aggregation != null) {
          dst.aggregation = new ArrayList<Enumeration<AggregationMode>>();
          for (Enumeration<AggregationMode> i : aggregation)
            dst.aggregation.add(i.copy());
        };
        dst.versioning = versioning == null ? null : versioning.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TypeRefComponent))
          return false;
        TypeRefComponent o = (TypeRefComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(profile, o.profile, true) && compareDeep(targetProfile, o.targetProfile, true)
           && compareDeep(aggregation, o.aggregation, true) && compareDeep(versioning, o.versioning, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TypeRefComponent))
          return false;
        TypeRefComponent o = (TypeRefComponent) other_;
        return compareValues(code, o.code, true) && compareValues(profile, o.profile, true) && compareValues(targetProfile, o.targetProfile, true)
           && compareValues(aggregation, o.aggregation, true) && compareValues(versioning, o.versioning, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, profile, targetProfile
          , aggregation, versioning);
      }

  public String fhirType() {
    return "ElementDefinition.type";

  }

// added from java-adornments.txt:

  public boolean hasTarget() {
    return Utilities.existsInList(getCode(), "Reference", "canonical", "CodeableReference");
  }
  
    /**
   * This code checks for the system prefix and returns the FHIR type
   * 
   * @return
   */
  public String getWorkingCode() {
    if (hasExtension(ToolingExtensions.EXT_FHIR_TYPE))
      return getExtensionString(ToolingExtensions.EXT_FHIR_TYPE);
    if (!hasCodeElement()) 
      return null;
    if (getCodeElement().hasExtension(ToolingExtensions.EXT_XML_TYPE)) {
      String s = getCodeElement().getExtensionString(ToolingExtensions.EXT_XML_TYPE);
      if ("xsd:gYear OR xsd:gYearMonth OR xsd:date OR xsd:dateTime".equalsIgnoreCase(s))
        return "dateTime";
      if ("xsd:gYear OR xsd:gYearMonth OR xsd:date".equalsIgnoreCase(s))
        return "date";
      if ("xsd:dateTime".equalsIgnoreCase(s))
        return "instant";
      if ("xsd:token".equals(s))
        return "code";
      if ("xsd:boolean".equals(s))
        return "boolean";
      if ("xsd:string".equals(s))
        return "string";
      if ("xsd:time".equals(s))
        return "time";
      if ("xsd:int".equals(s))
        return "integer";
      if ("xsd:decimal OR xsd:double".equals(s))
        return "decimal";
      if ("xsd:decimal".equalsIgnoreCase(s))
        return "decimal";
      if ("xsd:base64Binary".equalsIgnoreCase(s))
        return "base64Binary";
      if ("xsd:positiveInteger".equalsIgnoreCase(s))
        return "positiveInt";
      if ("xsd:nonNegativeInteger".equalsIgnoreCase(s))
        return "unsignedInt";
      if ("xsd:anyURI".equalsIgnoreCase(s))
        return "uri";
      
      throw new Error("Unknown xml type '"+s+"'");
    }
    return getCode();
  }

  @Override
  public String toString() {
    String res = getCode();
    if (hasProfile()) {
      res = res + "{";
      boolean first = true;
      for (CanonicalType s : getProfile()) {
        if (first) first = false; else res = res + "|";
        res = res + s.getValue();
      }
      res = res + "}";
    }
    if (hasTargetProfile()) {
      res = res + "->(";
      boolean first = true;
      for (CanonicalType s : getTargetProfile()) {
        if (first) first = false; else res = res + "|";
        res = res + s.getValue();
      }
      res = res + ")";
    }    
    return res;
  }

  public String getName() {
    return getWorkingCode();
  }

  public boolean isResourceReference() {
    return "Reference".equals(getCode()) && hasTargetProfile();
  }
// end addition
  }

    @Block()
    public static class ElementDefinitionExampleComponent extends Element implements IBaseDatatypeElement {
        /**
         * Describes the purpose of this example amoung the set of examples.
         */
        @Child(name = "label", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Describes the purpose of this example", formalDefinition="Describes the purpose of this example amoung the set of examples." )
        protected StringType label;

        /**
         * The actual value for the element, which must be one of the types allowed for this element.
         */
        @Child(name = "value", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Value of Example (one of allowed types)", formalDefinition="The actual value for the element, which must be one of the types allowed for this element." )
        protected DataType value;

        private static final long serialVersionUID = 463190922L;

    /**
     * Constructor
     */
      public ElementDefinitionExampleComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionExampleComponent(String label, DataType value) {
        super();
        this.setLabel(label);
        this.setValue(value);
      }

        /**
         * @return {@link #label} (Describes the purpose of this example amoung the set of examples.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionExampleComponent.label");
            else if (Configuration.doAutoCreate())
              this.label = new StringType(); // bb
          return this.label;
        }

        public boolean hasLabelElement() { 
          return this.label != null && !this.label.isEmpty();
        }

        public boolean hasLabel() { 
          return this.label != null && !this.label.isEmpty();
        }

        /**
         * @param value {@link #label} (Describes the purpose of this example amoung the set of examples.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public ElementDefinitionExampleComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return Describes the purpose of this example amoung the set of examples.
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value Describes the purpose of this example amoung the set of examples.
         */
        public ElementDefinitionExampleComponent setLabel(String value) { 
            if (this.label == null)
              this.label = new StringType();
            this.label.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public CanonicalType getValueCanonicalType() throws FHIRException { 
          if (this.value == null)
            this.value = new CanonicalType();
          if (!(this.value instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CanonicalType) this.value;
        }

        public boolean hasValueCanonicalType() { 
          return this != null && this.value instanceof CanonicalType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public DateType getValueDateType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateType();
          if (!(this.value instanceof DateType))
            throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateType) this.value;
        }

        public boolean hasValueDateType() { 
          return this != null && this.value instanceof DateType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public InstantType getValueInstantType() throws FHIRException { 
          if (this.value == null)
            this.value = new InstantType();
          if (!(this.value instanceof InstantType))
            throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (InstantType) this.value;
        }

        public boolean hasValueInstantType() { 
          return this != null && this.value instanceof InstantType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Integer64Type getValueInteger64Type() throws FHIRException { 
          if (this.value == null)
            this.value = new Integer64Type();
          if (!(this.value instanceof Integer64Type))
            throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Integer64Type) this.value;
        }

        public boolean hasValueInteger64Type() { 
          return this != null && this.value instanceof Integer64Type;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public MarkdownType getValueMarkdownType() throws FHIRException { 
          if (this.value == null)
            this.value = new MarkdownType();
          if (!(this.value instanceof MarkdownType))
            throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (MarkdownType) this.value;
        }

        public boolean hasValueMarkdownType() { 
          return this != null && this.value instanceof MarkdownType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public OidType getValueOidType() throws FHIRException { 
          if (this.value == null)
            this.value = new OidType();
          if (!(this.value instanceof OidType))
            throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (OidType) this.value;
        }

        public boolean hasValueOidType() { 
          return this != null && this.value instanceof OidType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public PositiveIntType getValuePositiveIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new PositiveIntType();
          if (!(this.value instanceof PositiveIntType))
            throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (PositiveIntType) this.value;
        }

        public boolean hasValuePositiveIntType() { 
          return this != null && this.value instanceof PositiveIntType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public UnsignedIntType getValueUnsignedIntType() throws FHIRException { 
          if (this.value == null)
            this.value = new UnsignedIntType();
          if (!(this.value instanceof UnsignedIntType))
            throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UnsignedIntType) this.value;
        }

        public boolean hasValueUnsignedIntType() { 
          return this != null && this.value instanceof UnsignedIntType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public UrlType getValueUrlType() throws FHIRException { 
          if (this.value == null)
            this.value = new UrlType();
          if (!(this.value instanceof UrlType))
            throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UrlType) this.value;
        }

        public boolean hasValueUrlType() { 
          return this != null && this.value instanceof UrlType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public UuidType getValueUuidType() throws FHIRException { 
          if (this.value == null)
            this.value = new UuidType();
          if (!(this.value instanceof UuidType))
            throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UuidType) this.value;
        }

        public boolean hasValueUuidType() { 
          return this != null && this.value instanceof UuidType;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Address getValueAddress() throws FHIRException { 
          if (this.value == null)
            this.value = new Address();
          if (!(this.value instanceof Address))
            throw new FHIRException("Type mismatch: the type Address was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Address) this.value;
        }

        public boolean hasValueAddress() { 
          return this != null && this.value instanceof Address;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Age getValueAge() throws FHIRException { 
          if (this.value == null)
            this.value = new Age();
          if (!(this.value instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Age) this.value;
        }

        public boolean hasValueAge() { 
          return this != null && this.value instanceof Age;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Annotation getValueAnnotation() throws FHIRException { 
          if (this.value == null)
            this.value = new Annotation();
          if (!(this.value instanceof Annotation))
            throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Annotation) this.value;
        }

        public boolean hasValueAnnotation() { 
          return this != null && this.value instanceof Annotation;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public ContactPoint getValueContactPoint() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactPoint();
          if (!(this.value instanceof ContactPoint))
            throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactPoint) this.value;
        }

        public boolean hasValueContactPoint() { 
          return this != null && this.value instanceof ContactPoint;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Count getValueCount() throws FHIRException { 
          if (this.value == null)
            this.value = new Count();
          if (!(this.value instanceof Count))
            throw new FHIRException("Type mismatch: the type Count was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Count) this.value;
        }

        public boolean hasValueCount() { 
          return this != null && this.value instanceof Count;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Distance getValueDistance() throws FHIRException { 
          if (this.value == null)
            this.value = new Distance();
          if (!(this.value instanceof Distance))
            throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Distance) this.value;
        }

        public boolean hasValueDistance() { 
          return this != null && this.value instanceof Distance;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Duration getValueDuration() throws FHIRException { 
          if (this.value == null)
            this.value = new Duration();
          if (!(this.value instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Duration) this.value;
        }

        public boolean hasValueDuration() { 
          return this != null && this.value instanceof Duration;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public HumanName getValueHumanName() throws FHIRException { 
          if (this.value == null)
            this.value = new HumanName();
          if (!(this.value instanceof HumanName))
            throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.value.getClass().getName()+" was encountered");
          return (HumanName) this.value;
        }

        public boolean hasValueHumanName() { 
          return this != null && this.value instanceof HumanName;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Identifier getValueIdentifier() throws FHIRException { 
          if (this.value == null)
            this.value = new Identifier();
          if (!(this.value instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Identifier) this.value;
        }

        public boolean hasValueIdentifier() { 
          return this != null && this.value instanceof Identifier;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Money getValueMoney() throws FHIRException { 
          if (this.value == null)
            this.value = new Money();
          if (!(this.value instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Money) this.value;
        }

        public boolean hasValueMoney() { 
          return this != null && this.value instanceof Money;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
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
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public SampledData getValueSampledData() throws FHIRException { 
          if (this.value == null)
            this.value = new SampledData();
          if (!(this.value instanceof SampledData))
            throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.value.getClass().getName()+" was encountered");
          return (SampledData) this.value;
        }

        public boolean hasValueSampledData() { 
          return this != null && this.value instanceof SampledData;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Signature getValueSignature() throws FHIRException { 
          if (this.value == null)
            this.value = new Signature();
          if (!(this.value instanceof Signature))
            throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Signature) this.value;
        }

        public boolean hasValueSignature() { 
          return this != null && this.value instanceof Signature;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Timing getValueTiming() throws FHIRException { 
          if (this.value == null)
            this.value = new Timing();
          if (!(this.value instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Timing) this.value;
        }

        public boolean hasValueTiming() { 
          return this != null && this.value instanceof Timing;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public ContactDetail getValueContactDetail() throws FHIRException { 
          if (this.value == null)
            this.value = new ContactDetail();
          if (!(this.value instanceof ContactDetail))
            throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ContactDetail) this.value;
        }

        public boolean hasValueContactDetail() { 
          return this != null && this.value instanceof ContactDetail;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Contributor getValueContributor() throws FHIRException { 
          if (this.value == null)
            this.value = new Contributor();
          if (!(this.value instanceof Contributor))
            throw new FHIRException("Type mismatch: the type Contributor was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Contributor) this.value;
        }

        public boolean hasValueContributor() { 
          return this != null && this.value instanceof Contributor;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public DataRequirement getValueDataRequirement() throws FHIRException { 
          if (this.value == null)
            this.value = new DataRequirement();
          if (!(this.value instanceof DataRequirement))
            throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DataRequirement) this.value;
        }

        public boolean hasValueDataRequirement() { 
          return this != null && this.value instanceof DataRequirement;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Expression getValueExpression() throws FHIRException { 
          if (this.value == null)
            this.value = new Expression();
          if (!(this.value instanceof Expression))
            throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Expression) this.value;
        }

        public boolean hasValueExpression() { 
          return this != null && this.value instanceof Expression;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public ParameterDefinition getValueParameterDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new ParameterDefinition();
          if (!(this.value instanceof ParameterDefinition))
            throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (ParameterDefinition) this.value;
        }

        public boolean hasValueParameterDefinition() { 
          return this != null && this.value instanceof ParameterDefinition;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public RelatedArtifact getValueRelatedArtifact() throws FHIRException { 
          if (this.value == null)
            this.value = new RelatedArtifact();
          if (!(this.value instanceof RelatedArtifact))
            throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.value.getClass().getName()+" was encountered");
          return (RelatedArtifact) this.value;
        }

        public boolean hasValueRelatedArtifact() { 
          return this != null && this.value instanceof RelatedArtifact;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public TriggerDefinition getValueTriggerDefinition() throws FHIRException { 
          if (this.value == null)
            this.value = new TriggerDefinition();
          if (!(this.value instanceof TriggerDefinition))
            throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TriggerDefinition) this.value;
        }

        public boolean hasValueTriggerDefinition() { 
          return this != null && this.value instanceof TriggerDefinition;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public UsageContext getValueUsageContext() throws FHIRException { 
          if (this.value == null)
            this.value = new UsageContext();
          if (!(this.value instanceof UsageContext))
            throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UsageContext) this.value;
        }

        public boolean hasValueUsageContext() { 
          return this != null && this.value instanceof UsageContext;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Dosage getValueDosage() throws FHIRException { 
          if (this.value == null)
            this.value = new Dosage();
          if (!(this.value instanceof Dosage))
            throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Dosage) this.value;
        }

        public boolean hasValueDosage() { 
          return this != null && this.value instanceof Dosage;
        }

        /**
         * @return {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public Meta getValueMeta() throws FHIRException { 
          if (this.value == null)
            this.value = new Meta();
          if (!(this.value instanceof Meta))
            throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Meta) this.value;
        }

        public boolean hasValueMeta() { 
          return this != null && this.value instanceof Meta;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The actual value for the element, which must be one of the types allowed for this element.)
         */
        public ElementDefinitionExampleComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof Contributor || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Dosage || value instanceof Meta))
            throw new Error("Not the right type for ElementDefinition.example.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("label", "string", "Describes the purpose of this example amoung the set of examples.", 0, 1, label));
          children.add(new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 102727412: /*label*/  return new Property("label", "string", "Describes the purpose of this example amoung the set of examples.", 0, 1, label);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -786218365: /*valueCanonical*/  return new Property("value[x]", "canonical", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -766209282: /*valueCode*/  return new Property("value[x]", "code", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1668687056: /*valueInstant*/  return new Property("value[x]", "instant", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1122120181: /*valueInteger64*/  return new Property("value[x]", "integer64", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -497880704: /*valueMarkdown*/  return new Property("value[x]", "markdown", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1410178407: /*valueOid*/  return new Property("value[x]", "oid", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1249932027: /*valuePositiveInt*/  return new Property("value[x]", "positiveInt", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 26529417: /*valueUnsignedInt*/  return new Property("value[x]", "unsignedInt", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1410172354: /*valueUrl*/  return new Property("value[x]", "url", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -765667124: /*valueUuid*/  return new Property("value[x]", "uuid", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -478981821: /*valueAddress*/  return new Property("value[x]", "Address", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1410191922: /*valueAge*/  return new Property("value[x]", "Age", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -67108992: /*valueAnnotation*/  return new Property("value[x]", "Annotation", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 944904545: /*valueContactPoint*/  return new Property("value[x]", "ContactPoint", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 2017332766: /*valueCount*/  return new Property("value[x]", "Count", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -456359802: /*valueDistance*/  return new Property("value[x]", "Distance", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -2026205465: /*valueHumanName*/  return new Property("value[x]", "HumanName", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -130498310: /*valueIdentifier*/  return new Property("value[x]", "Identifier", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 2026560975: /*valueMoney*/  return new Property("value[x]", "Money", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -540985785: /*valueSignature*/  return new Property("value[x]", "Signature", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1406282469: /*valueTiming*/  return new Property("value[x]", "Timing", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1125200224: /*valueContactDetail*/  return new Property("value[x]", "ContactDetail", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1281021610: /*valueContributor*/  return new Property("value[x]", "Contributor", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1710554248: /*valueDataRequirement*/  return new Property("value[x]", "DataRequirement", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -307517719: /*valueExpression*/  return new Property("value[x]", "Expression", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1387478187: /*valueParameterDefinition*/  return new Property("value[x]", "ParameterDefinition", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 1748214124: /*valueRelatedArtifact*/  return new Property("value[x]", "RelatedArtifact", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 976830394: /*valueTriggerDefinition*/  return new Property("value[x]", "TriggerDefinition", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case 588000479: /*valueUsageContext*/  return new Property("value[x]", "UsageContext", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -1858636920: /*valueDosage*/  return new Property("value[x]", "Dosage", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          case -765920490: /*valueMeta*/  return new Property("value[x]", "Meta", "The actual value for the element, which must be one of the types allowed for this element.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412:  return getLabelElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Dosage", "Meta"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.example.label");
        }
        else if (name.equals("valueBase64Binary")) {
          this.value = new Base64BinaryType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueCanonical")) {
          this.value = new CanonicalType();
          return this.value;
        }
        else if (name.equals("valueCode")) {
          this.value = new CodeType();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
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
        else if (name.equals("valueId")) {
          this.value = new IdType();
          return this.value;
        }
        else if (name.equals("valueInstant")) {
          this.value = new InstantType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueInteger64")) {
          this.value = new Integer64Type();
          return this.value;
        }
        else if (name.equals("valueMarkdown")) {
          this.value = new MarkdownType();
          return this.value;
        }
        else if (name.equals("valueOid")) {
          this.value = new OidType();
          return this.value;
        }
        else if (name.equals("valuePositiveInt")) {
          this.value = new PositiveIntType();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueUnsignedInt")) {
          this.value = new UnsignedIntType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueUrl")) {
          this.value = new UrlType();
          return this.value;
        }
        else if (name.equals("valueUuid")) {
          this.value = new UuidType();
          return this.value;
        }
        else if (name.equals("valueAddress")) {
          this.value = new Address();
          return this.value;
        }
        else if (name.equals("valueAge")) {
          this.value = new Age();
          return this.value;
        }
        else if (name.equals("valueAnnotation")) {
          this.value = new Annotation();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueContactPoint")) {
          this.value = new ContactPoint();
          return this.value;
        }
        else if (name.equals("valueCount")) {
          this.value = new Count();
          return this.value;
        }
        else if (name.equals("valueDistance")) {
          this.value = new Distance();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else if (name.equals("valueHumanName")) {
          this.value = new HumanName();
          return this.value;
        }
        else if (name.equals("valueIdentifier")) {
          this.value = new Identifier();
          return this.value;
        }
        else if (name.equals("valueMoney")) {
          this.value = new Money();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
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
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("valueSampledData")) {
          this.value = new SampledData();
          return this.value;
        }
        else if (name.equals("valueSignature")) {
          this.value = new Signature();
          return this.value;
        }
        else if (name.equals("valueTiming")) {
          this.value = new Timing();
          return this.value;
        }
        else if (name.equals("valueContactDetail")) {
          this.value = new ContactDetail();
          return this.value;
        }
        else if (name.equals("valueContributor")) {
          this.value = new Contributor();
          return this.value;
        }
        else if (name.equals("valueDataRequirement")) {
          this.value = new DataRequirement();
          return this.value;
        }
        else if (name.equals("valueExpression")) {
          this.value = new Expression();
          return this.value;
        }
        else if (name.equals("valueParameterDefinition")) {
          this.value = new ParameterDefinition();
          return this.value;
        }
        else if (name.equals("valueRelatedArtifact")) {
          this.value = new RelatedArtifact();
          return this.value;
        }
        else if (name.equals("valueTriggerDefinition")) {
          this.value = new TriggerDefinition();
          return this.value;
        }
        else if (name.equals("valueUsageContext")) {
          this.value = new UsageContext();
          return this.value;
        }
        else if (name.equals("valueDosage")) {
          this.value = new Dosage();
          return this.value;
        }
        else if (name.equals("valueMeta")) {
          this.value = new Meta();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionExampleComponent copy() {
        ElementDefinitionExampleComponent dst = new ElementDefinitionExampleComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionExampleComponent dst) {
        super.copyValues(dst);
        dst.label = label == null ? null : label.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionExampleComponent))
          return false;
        ElementDefinitionExampleComponent o = (ElementDefinitionExampleComponent) other_;
        return compareDeep(label, o.label, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionExampleComponent))
          return false;
        ElementDefinitionExampleComponent o = (ElementDefinitionExampleComponent) other_;
        return compareValues(label, o.label, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(label, value);
      }

  public String fhirType() {
    return "ElementDefinition.example";

  }

  }

    @Block()
    public static class ElementDefinitionConstraintComponent extends Element implements IBaseDatatypeElement {
        /**
         * Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.
         */
        @Child(name = "key", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Target of 'condition' reference above", formalDefinition="Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality." )
        protected IdType key;

        /**
         * Description of why this constraint is necessary or appropriate.
         */
        @Child(name = "requirements", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Why this constraint is necessary or appropriate", formalDefinition="Description of why this constraint is necessary or appropriate." )
        protected StringType requirements;

        /**
         * Identifies the impact constraint violation has on the conformance of the instance.
         */
        @Child(name = "severity", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="error | warning", formalDefinition="Identifies the impact constraint violation has on the conformance of the instance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/constraint-severity")
        protected Enumeration<ConstraintSeverity> severity;

        /**
         * Text that can be used to describe the constraint in messages identifying that the constraint has been violated.
         */
        @Child(name = "human", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Human description of constraint", formalDefinition="Text that can be used to describe the constraint in messages identifying that the constraint has been violated." )
        protected StringType human;

        /**
         * A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.
         */
        @Child(name = "expression", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath expression of constraint", formalDefinition="A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met." )
        protected StringType expression;

        /**
         * An XPath expression of constraint that can be executed to see if this constraint is met.
         */
        @Child(name = "xpath", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="XPath expression of constraint", formalDefinition="An XPath expression of constraint that can be executed to see if this constraint is met." )
        protected StringType xpath;

        /**
         * A reference to the original source of the constraint, for traceability purposes.
         */
        @Child(name = "source", type = {CanonicalType.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to original source of constraint", formalDefinition="A reference to the original source of the constraint, for traceability purposes." )
        protected CanonicalType source;

        private static final long serialVersionUID = 1048354565L;

    /**
     * Constructor
     */
      public ElementDefinitionConstraintComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionConstraintComponent(String key, ConstraintSeverity severity, String human) {
        super();
        this.setKey(key);
        this.setSeverity(severity);
        this.setHuman(human);
      }

        /**
         * @return {@link #key} (Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public IdType getKeyElement() { 
          if (this.key == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.key");
            else if (Configuration.doAutoCreate())
              this.key = new IdType(); // bb
          return this.key;
        }

        public boolean hasKeyElement() { 
          return this.key != null && !this.key.isEmpty();
        }

        public boolean hasKey() { 
          return this.key != null && !this.key.isEmpty();
        }

        /**
         * @param value {@link #key} (Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setKeyElement(IdType value) { 
          this.key = value;
          return this;
        }

        /**
         * @return Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.
         */
        public String getKey() { 
          return this.key == null ? null : this.key.getValue();
        }

        /**
         * @param value Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.
         */
        public ElementDefinitionConstraintComponent setKey(String value) { 
            if (this.key == null)
              this.key = new IdType();
            this.key.setValue(value);
          return this;
        }

        /**
         * @return {@link #requirements} (Description of why this constraint is necessary or appropriate.). This is the underlying object with id, value and extensions. The accessor "getRequirements" gives direct access to the value
         */
        public StringType getRequirementsElement() { 
          if (this.requirements == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.requirements");
            else if (Configuration.doAutoCreate())
              this.requirements = new StringType(); // bb
          return this.requirements;
        }

        public boolean hasRequirementsElement() { 
          return this.requirements != null && !this.requirements.isEmpty();
        }

        public boolean hasRequirements() { 
          return this.requirements != null && !this.requirements.isEmpty();
        }

        /**
         * @param value {@link #requirements} (Description of why this constraint is necessary or appropriate.). This is the underlying object with id, value and extensions. The accessor "getRequirements" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setRequirementsElement(StringType value) { 
          this.requirements = value;
          return this;
        }

        /**
         * @return Description of why this constraint is necessary or appropriate.
         */
        public String getRequirements() { 
          return this.requirements == null ? null : this.requirements.getValue();
        }

        /**
         * @param value Description of why this constraint is necessary or appropriate.
         */
        public ElementDefinitionConstraintComponent setRequirements(String value) { 
          if (Utilities.noString(value))
            this.requirements = null;
          else {
            if (this.requirements == null)
              this.requirements = new StringType();
            this.requirements.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #severity} (Identifies the impact constraint violation has on the conformance of the instance.). This is the underlying object with id, value and extensions. The accessor "getSeverity" gives direct access to the value
         */
        public Enumeration<ConstraintSeverity> getSeverityElement() { 
          if (this.severity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.severity");
            else if (Configuration.doAutoCreate())
              this.severity = new Enumeration<ConstraintSeverity>(new ConstraintSeverityEnumFactory()); // bb
          return this.severity;
        }

        public boolean hasSeverityElement() { 
          return this.severity != null && !this.severity.isEmpty();
        }

        public boolean hasSeverity() { 
          return this.severity != null && !this.severity.isEmpty();
        }

        /**
         * @param value {@link #severity} (Identifies the impact constraint violation has on the conformance of the instance.). This is the underlying object with id, value and extensions. The accessor "getSeverity" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setSeverityElement(Enumeration<ConstraintSeverity> value) { 
          this.severity = value;
          return this;
        }

        /**
         * @return Identifies the impact constraint violation has on the conformance of the instance.
         */
        public ConstraintSeverity getSeverity() { 
          return this.severity == null ? null : this.severity.getValue();
        }

        /**
         * @param value Identifies the impact constraint violation has on the conformance of the instance.
         */
        public ElementDefinitionConstraintComponent setSeverity(ConstraintSeverity value) { 
            if (this.severity == null)
              this.severity = new Enumeration<ConstraintSeverity>(new ConstraintSeverityEnumFactory());
            this.severity.setValue(value);
          return this;
        }

        /**
         * @return {@link #human} (Text that can be used to describe the constraint in messages identifying that the constraint has been violated.). This is the underlying object with id, value and extensions. The accessor "getHuman" gives direct access to the value
         */
        public StringType getHumanElement() { 
          if (this.human == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.human");
            else if (Configuration.doAutoCreate())
              this.human = new StringType(); // bb
          return this.human;
        }

        public boolean hasHumanElement() { 
          return this.human != null && !this.human.isEmpty();
        }

        public boolean hasHuman() { 
          return this.human != null && !this.human.isEmpty();
        }

        /**
         * @param value {@link #human} (Text that can be used to describe the constraint in messages identifying that the constraint has been violated.). This is the underlying object with id, value and extensions. The accessor "getHuman" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setHumanElement(StringType value) { 
          this.human = value;
          return this;
        }

        /**
         * @return Text that can be used to describe the constraint in messages identifying that the constraint has been violated.
         */
        public String getHuman() { 
          return this.human == null ? null : this.human.getValue();
        }

        /**
         * @param value Text that can be used to describe the constraint in messages identifying that the constraint has been violated.
         */
        public ElementDefinitionConstraintComponent setHuman(String value) { 
            if (this.human == null)
              this.human = new StringType();
            this.human.setValue(value);
          return this;
        }

        /**
         * @return {@link #expression} (A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public StringType getExpressionElement() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new StringType(); // bb
          return this.expression;
        }

        public boolean hasExpressionElement() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setExpressionElement(StringType value) { 
          this.expression = value;
          return this;
        }

        /**
         * @return A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.
         */
        public String getExpression() { 
          return this.expression == null ? null : this.expression.getValue();
        }

        /**
         * @param value A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.
         */
        public ElementDefinitionConstraintComponent setExpression(String value) { 
          if (Utilities.noString(value))
            this.expression = null;
          else {
            if (this.expression == null)
              this.expression = new StringType();
            this.expression.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #xpath} (An XPath expression of constraint that can be executed to see if this constraint is met.). This is the underlying object with id, value and extensions. The accessor "getXpath" gives direct access to the value
         */
        public StringType getXpathElement() { 
          if (this.xpath == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.xpath");
            else if (Configuration.doAutoCreate())
              this.xpath = new StringType(); // bb
          return this.xpath;
        }

        public boolean hasXpathElement() { 
          return this.xpath != null && !this.xpath.isEmpty();
        }

        public boolean hasXpath() { 
          return this.xpath != null && !this.xpath.isEmpty();
        }

        /**
         * @param value {@link #xpath} (An XPath expression of constraint that can be executed to see if this constraint is met.). This is the underlying object with id, value and extensions. The accessor "getXpath" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setXpathElement(StringType value) { 
          this.xpath = value;
          return this;
        }

        /**
         * @return An XPath expression of constraint that can be executed to see if this constraint is met.
         */
        public String getXpath() { 
          return this.xpath == null ? null : this.xpath.getValue();
        }

        /**
         * @param value An XPath expression of constraint that can be executed to see if this constraint is met.
         */
        public ElementDefinitionConstraintComponent setXpath(String value) { 
          if (Utilities.noString(value))
            this.xpath = null;
          else {
            if (this.xpath == null)
              this.xpath = new StringType();
            this.xpath.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #source} (A reference to the original source of the constraint, for traceability purposes.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public CanonicalType getSourceElement() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionConstraintComponent.source");
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
         * @param value {@link #source} (A reference to the original source of the constraint, for traceability purposes.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public ElementDefinitionConstraintComponent setSourceElement(CanonicalType value) { 
          this.source = value;
          return this;
        }

        /**
         * @return A reference to the original source of the constraint, for traceability purposes.
         */
        public String getSource() { 
          return this.source == null ? null : this.source.getValue();
        }

        /**
         * @param value A reference to the original source of the constraint, for traceability purposes.
         */
        public ElementDefinitionConstraintComponent setSource(String value) { 
          if (Utilities.noString(value))
            this.source = null;
          else {
            if (this.source == null)
              this.source = new CanonicalType();
            this.source.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("key", "id", "Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.", 0, 1, key));
          children.add(new Property("requirements", "string", "Description of why this constraint is necessary or appropriate.", 0, 1, requirements));
          children.add(new Property("severity", "code", "Identifies the impact constraint violation has on the conformance of the instance.", 0, 1, severity));
          children.add(new Property("human", "string", "Text that can be used to describe the constraint in messages identifying that the constraint has been violated.", 0, 1, human));
          children.add(new Property("expression", "string", "A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.", 0, 1, expression));
          children.add(new Property("xpath", "string", "An XPath expression of constraint that can be executed to see if this constraint is met.", 0, 1, xpath));
          children.add(new Property("source", "canonical(StructureDefinition)", "A reference to the original source of the constraint, for traceability purposes.", 0, 1, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106079: /*key*/  return new Property("key", "id", "Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.", 0, 1, key);
          case -1619874672: /*requirements*/  return new Property("requirements", "string", "Description of why this constraint is necessary or appropriate.", 0, 1, requirements);
          case 1478300413: /*severity*/  return new Property("severity", "code", "Identifies the impact constraint violation has on the conformance of the instance.", 0, 1, severity);
          case 99639597: /*human*/  return new Property("human", "string", "Text that can be used to describe the constraint in messages identifying that the constraint has been violated.", 0, 1, human);
          case -1795452264: /*expression*/  return new Property("expression", "string", "A [FHIRPath](fhirpath.html) expression of constraint that can be executed to see if this constraint is met.", 0, 1, expression);
          case 114256029: /*xpath*/  return new Property("xpath", "string", "An XPath expression of constraint that can be executed to see if this constraint is met.", 0, 1, xpath);
          case -896505829: /*source*/  return new Property("source", "canonical(StructureDefinition)", "A reference to the original source of the constraint, for traceability purposes.", 0, 1, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // IdType
        case -1619874672: /*requirements*/ return this.requirements == null ? new Base[0] : new Base[] {this.requirements}; // StringType
        case 1478300413: /*severity*/ return this.severity == null ? new Base[0] : new Base[] {this.severity}; // Enumeration<ConstraintSeverity>
        case 99639597: /*human*/ return this.human == null ? new Base[0] : new Base[] {this.human}; // StringType
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // StringType
        case 114256029: /*xpath*/ return this.xpath == null ? new Base[0] : new Base[] {this.xpath}; // StringType
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106079: // key
          this.key = TypeConvertor.castToId(value); // IdType
          return value;
        case -1619874672: // requirements
          this.requirements = TypeConvertor.castToString(value); // StringType
          return value;
        case 1478300413: // severity
          value = new ConstraintSeverityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.severity = (Enumeration) value; // Enumeration<ConstraintSeverity>
          return value;
        case 99639597: // human
          this.human = TypeConvertor.castToString(value); // StringType
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToString(value); // StringType
          return value;
        case 114256029: // xpath
          this.xpath = TypeConvertor.castToString(value); // StringType
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("key")) {
          this.key = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("requirements")) {
          this.requirements = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("severity")) {
          value = new ConstraintSeverityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.severity = (Enumeration) value; // Enumeration<ConstraintSeverity>
        } else if (name.equals("human")) {
          this.human = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("xpath")) {
          this.xpath = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079:  return getKeyElement();
        case -1619874672:  return getRequirementsElement();
        case 1478300413:  return getSeverityElement();
        case 99639597:  return getHumanElement();
        case -1795452264:  return getExpressionElement();
        case 114256029:  return getXpathElement();
        case -896505829:  return getSourceElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"id"};
        case -1619874672: /*requirements*/ return new String[] {"string"};
        case 1478300413: /*severity*/ return new String[] {"code"};
        case 99639597: /*human*/ return new String[] {"string"};
        case -1795452264: /*expression*/ return new String[] {"string"};
        case 114256029: /*xpath*/ return new String[] {"string"};
        case -896505829: /*source*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.key");
        }
        else if (name.equals("requirements")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.requirements");
        }
        else if (name.equals("severity")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.severity");
        }
        else if (name.equals("human")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.human");
        }
        else if (name.equals("expression")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.expression");
        }
        else if (name.equals("xpath")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.xpath");
        }
        else if (name.equals("source")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.constraint.source");
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionConstraintComponent copy() {
        ElementDefinitionConstraintComponent dst = new ElementDefinitionConstraintComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionConstraintComponent dst) {
        super.copyValues(dst);
        dst.key = key == null ? null : key.copy();
        dst.requirements = requirements == null ? null : requirements.copy();
        dst.severity = severity == null ? null : severity.copy();
        dst.human = human == null ? null : human.copy();
        dst.expression = expression == null ? null : expression.copy();
        dst.xpath = xpath == null ? null : xpath.copy();
        dst.source = source == null ? null : source.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionConstraintComponent))
          return false;
        ElementDefinitionConstraintComponent o = (ElementDefinitionConstraintComponent) other_;
        return compareDeep(key, o.key, true) && compareDeep(requirements, o.requirements, true) && compareDeep(severity, o.severity, true)
           && compareDeep(human, o.human, true) && compareDeep(expression, o.expression, true) && compareDeep(xpath, o.xpath, true)
           && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionConstraintComponent))
          return false;
        ElementDefinitionConstraintComponent o = (ElementDefinitionConstraintComponent) other_;
        return compareValues(key, o.key, true) && compareValues(requirements, o.requirements, true) && compareValues(severity, o.severity, true)
           && compareValues(human, o.human, true) && compareValues(expression, o.expression, true) && compareValues(xpath, o.xpath, true)
           && compareValues(source, o.source, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, requirements, severity
          , human, expression, xpath, source);
      }

  public String fhirType() {
    return "ElementDefinition.constraint";

  }

  }

    @Block()
    public static class ElementDefinitionBindingComponent extends Element implements IBaseDatatypeElement {
        /**
         * Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.
         */
        @Child(name = "strength", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="required | extensible | preferred | example", formalDefinition="Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/binding-strength")
        protected Enumeration<BindingStrength> strength;

        /**
         * Describes the intended use of this particular set of codes.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Human explanation of the value set", formalDefinition="Describes the intended use of this particular set of codes." )
        protected StringType description;

        /**
         * Refers to the value set that identifies the set of codes the binding refers to.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Source of value set", formalDefinition="Refers to the value set that identifies the set of codes the binding refers to." )
        protected CanonicalType valueSet;

        private static final long serialVersionUID = -514477030L;

    /**
     * Constructor
     */
      public ElementDefinitionBindingComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionBindingComponent(BindingStrength strength) {
        super();
        this.setStrength(strength);
      }

        /**
         * @return {@link #strength} (Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.). This is the underlying object with id, value and extensions. The accessor "getStrength" gives direct access to the value
         */
        public Enumeration<BindingStrength> getStrengthElement() { 
          if (this.strength == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionBindingComponent.strength");
            else if (Configuration.doAutoCreate())
              this.strength = new Enumeration<BindingStrength>(new BindingStrengthEnumFactory()); // bb
          return this.strength;
        }

        public boolean hasStrengthElement() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        public boolean hasStrength() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        /**
         * @param value {@link #strength} (Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.). This is the underlying object with id, value and extensions. The accessor "getStrength" gives direct access to the value
         */
        public ElementDefinitionBindingComponent setStrengthElement(Enumeration<BindingStrength> value) { 
          this.strength = value;
          return this;
        }

        /**
         * @return Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.
         */
        public BindingStrength getStrength() { 
          return this.strength == null ? null : this.strength.getValue();
        }

        /**
         * @param value Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.
         */
        public ElementDefinitionBindingComponent setStrength(BindingStrength value) { 
            if (this.strength == null)
              this.strength = new Enumeration<BindingStrength>(new BindingStrengthEnumFactory());
            this.strength.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Describes the intended use of this particular set of codes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionBindingComponent.description");
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
         * @param value {@link #description} (Describes the intended use of this particular set of codes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ElementDefinitionBindingComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Describes the intended use of this particular set of codes.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Describes the intended use of this particular set of codes.
         */
        public ElementDefinitionBindingComponent setDescription(String value) { 
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
         * @return {@link #valueSet} (Refers to the value set that identifies the set of codes the binding refers to.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionBindingComponent.valueSet");
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
         * @param value {@link #valueSet} (Refers to the value set that identifies the set of codes the binding refers to.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public ElementDefinitionBindingComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return Refers to the value set that identifies the set of codes the binding refers to.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value Refers to the value set that identifies the set of codes the binding refers to.
         */
        public ElementDefinitionBindingComponent setValueSet(String value) { 
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
          children.add(new Property("strength", "code", "Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.", 0, 1, strength));
          children.add(new Property("description", "string", "Describes the intended use of this particular set of codes.", 0, 1, description));
          children.add(new Property("valueSet", "canonical(ValueSet)", "Refers to the value set that identifies the set of codes the binding refers to.", 0, 1, valueSet));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1791316033: /*strength*/  return new Property("strength", "code", "Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.", 0, 1, strength);
          case -1724546052: /*description*/  return new Property("description", "string", "Describes the intended use of this particular set of codes.", 0, 1, description);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "Refers to the value set that identifies the set of codes the binding refers to.", 0, 1, valueSet);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : new Base[] {this.strength}; // Enumeration<BindingStrength>
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1791316033: // strength
          value = new BindingStrengthEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strength = (Enumeration) value; // Enumeration<BindingStrength>
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("strength")) {
          value = new BindingStrengthEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strength = (Enumeration) value; // Enumeration<BindingStrength>
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1791316033:  return getStrengthElement();
        case -1724546052:  return getDescriptionElement();
        case -1410174671:  return getValueSetElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1791316033: /*strength*/ return new String[] {"code"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("strength")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.binding.strength");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.binding.description");
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.binding.valueSet");
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionBindingComponent copy() {
        ElementDefinitionBindingComponent dst = new ElementDefinitionBindingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionBindingComponent dst) {
        super.copyValues(dst);
        dst.strength = strength == null ? null : strength.copy();
        dst.description = description == null ? null : description.copy();
        dst.valueSet = valueSet == null ? null : valueSet.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionBindingComponent))
          return false;
        ElementDefinitionBindingComponent o = (ElementDefinitionBindingComponent) other_;
        return compareDeep(strength, o.strength, true) && compareDeep(description, o.description, true)
           && compareDeep(valueSet, o.valueSet, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionBindingComponent))
          return false;
        ElementDefinitionBindingComponent o = (ElementDefinitionBindingComponent) other_;
        return compareValues(strength, o.strength, true) && compareValues(description, o.description, true)
           && compareValues(valueSet, o.valueSet, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(strength, description, valueSet
          );
      }

  public String fhirType() {
    return "ElementDefinition.binding";

  }

  }

    @Block()
    public static class ElementDefinitionMappingComponent extends Element implements IBaseDatatypeElement {
        /**
         * An internal reference to the definition of a mapping.
         */
        @Child(name = "identity", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Reference to mapping declaration", formalDefinition="An internal reference to the definition of a mapping." )
        protected IdType identity;

        /**
         * Identifies the computable language in which mapping.map is expressed.
         */
        @Child(name = "language", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Computable language of mapping", formalDefinition="Identifies the computable language in which mapping.map is expressed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected CodeType language;

        /**
         * Expresses what part of the target specification corresponds to this element.
         */
        @Child(name = "map", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Details of the mapping", formalDefinition="Expresses what part of the target specification corresponds to this element." )
        protected StringType map;

        /**
         * Comments that provide information about the mapping or its use.
         */
        @Child(name = "comment", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Comments about the mapping or its use", formalDefinition="Comments that provide information about the mapping or its use." )
        protected StringType comment;

        private static final long serialVersionUID = 1386816887L;

    /**
     * Constructor
     */
      public ElementDefinitionMappingComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ElementDefinitionMappingComponent(String identity, String map) {
        super();
        this.setIdentity(identity);
        this.setMap(map);
      }

        /**
         * @return {@link #identity} (An internal reference to the definition of a mapping.). This is the underlying object with id, value and extensions. The accessor "getIdentity" gives direct access to the value
         */
        public IdType getIdentityElement() { 
          if (this.identity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionMappingComponent.identity");
            else if (Configuration.doAutoCreate())
              this.identity = new IdType(); // bb
          return this.identity;
        }

        public boolean hasIdentityElement() { 
          return this.identity != null && !this.identity.isEmpty();
        }

        public boolean hasIdentity() { 
          return this.identity != null && !this.identity.isEmpty();
        }

        /**
         * @param value {@link #identity} (An internal reference to the definition of a mapping.). This is the underlying object with id, value and extensions. The accessor "getIdentity" gives direct access to the value
         */
        public ElementDefinitionMappingComponent setIdentityElement(IdType value) { 
          this.identity = value;
          return this;
        }

        /**
         * @return An internal reference to the definition of a mapping.
         */
        public String getIdentity() { 
          return this.identity == null ? null : this.identity.getValue();
        }

        /**
         * @param value An internal reference to the definition of a mapping.
         */
        public ElementDefinitionMappingComponent setIdentity(String value) { 
            if (this.identity == null)
              this.identity = new IdType();
            this.identity.setValue(value);
          return this;
        }

        /**
         * @return {@link #language} (Identifies the computable language in which mapping.map is expressed.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
         */
        public CodeType getLanguageElement() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionMappingComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeType(); // bb
          return this.language;
        }

        public boolean hasLanguageElement() { 
          return this.language != null && !this.language.isEmpty();
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Identifies the computable language in which mapping.map is expressed.). This is the underlying object with id, value and extensions. The accessor "getLanguage" gives direct access to the value
         */
        public ElementDefinitionMappingComponent setLanguageElement(CodeType value) { 
          this.language = value;
          return this;
        }

        /**
         * @return Identifies the computable language in which mapping.map is expressed.
         */
        public String getLanguage() { 
          return this.language == null ? null : this.language.getValue();
        }

        /**
         * @param value Identifies the computable language in which mapping.map is expressed.
         */
        public ElementDefinitionMappingComponent setLanguage(String value) { 
          if (Utilities.noString(value))
            this.language = null;
          else {
            if (this.language == null)
              this.language = new CodeType();
            this.language.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #map} (Expresses what part of the target specification corresponds to this element.). This is the underlying object with id, value and extensions. The accessor "getMap" gives direct access to the value
         */
        public StringType getMapElement() { 
          if (this.map == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionMappingComponent.map");
            else if (Configuration.doAutoCreate())
              this.map = new StringType(); // bb
          return this.map;
        }

        public boolean hasMapElement() { 
          return this.map != null && !this.map.isEmpty();
        }

        public boolean hasMap() { 
          return this.map != null && !this.map.isEmpty();
        }

        /**
         * @param value {@link #map} (Expresses what part of the target specification corresponds to this element.). This is the underlying object with id, value and extensions. The accessor "getMap" gives direct access to the value
         */
        public ElementDefinitionMappingComponent setMapElement(StringType value) { 
          this.map = value;
          return this;
        }

        /**
         * @return Expresses what part of the target specification corresponds to this element.
         */
        public String getMap() { 
          return this.map == null ? null : this.map.getValue();
        }

        /**
         * @param value Expresses what part of the target specification corresponds to this element.
         */
        public ElementDefinitionMappingComponent setMap(String value) { 
            if (this.map == null)
              this.map = new StringType();
            this.map.setValue(value);
          return this;
        }

        /**
         * @return {@link #comment} (Comments that provide information about the mapping or its use.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public StringType getCommentElement() { 
          if (this.comment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ElementDefinitionMappingComponent.comment");
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
         * @param value {@link #comment} (Comments that provide information about the mapping or its use.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public ElementDefinitionMappingComponent setCommentElement(StringType value) { 
          this.comment = value;
          return this;
        }

        /**
         * @return Comments that provide information about the mapping or its use.
         */
        public String getComment() { 
          return this.comment == null ? null : this.comment.getValue();
        }

        /**
         * @param value Comments that provide information about the mapping or its use.
         */
        public ElementDefinitionMappingComponent setComment(String value) { 
          if (Utilities.noString(value))
            this.comment = null;
          else {
            if (this.comment == null)
              this.comment = new StringType();
            this.comment.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identity", "id", "An internal reference to the definition of a mapping.", 0, 1, identity));
          children.add(new Property("language", "code", "Identifies the computable language in which mapping.map is expressed.", 0, 1, language));
          children.add(new Property("map", "string", "Expresses what part of the target specification corresponds to this element.", 0, 1, map));
          children.add(new Property("comment", "string", "Comments that provide information about the mapping or its use.", 0, 1, comment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -135761730: /*identity*/  return new Property("identity", "id", "An internal reference to the definition of a mapping.", 0, 1, identity);
          case -1613589672: /*language*/  return new Property("language", "code", "Identifies the computable language in which mapping.map is expressed.", 0, 1, language);
          case 107868: /*map*/  return new Property("map", "string", "Expresses what part of the target specification corresponds to this element.", 0, 1, map);
          case 950398559: /*comment*/  return new Property("comment", "string", "Comments that provide information about the mapping or its use.", 0, 1, comment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -135761730: /*identity*/ return this.identity == null ? new Base[0] : new Base[] {this.identity}; // IdType
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeType
        case 107868: /*map*/ return this.map == null ? new Base[0] : new Base[] {this.map}; // StringType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -135761730: // identity
          this.identity = TypeConvertor.castToId(value); // IdType
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 107868: // map
          this.map = TypeConvertor.castToString(value); // StringType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identity")) {
          this.identity = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("map")) {
          this.map = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -135761730:  return getIdentityElement();
        case -1613589672:  return getLanguageElement();
        case 107868:  return getMapElement();
        case 950398559:  return getCommentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -135761730: /*identity*/ return new String[] {"id"};
        case -1613589672: /*language*/ return new String[] {"code"};
        case 107868: /*map*/ return new String[] {"string"};
        case 950398559: /*comment*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identity")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.mapping.identity");
        }
        else if (name.equals("language")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.mapping.language");
        }
        else if (name.equals("map")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.mapping.map");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.mapping.comment");
        }
        else
          return super.addChild(name);
      }

      public ElementDefinitionMappingComponent copy() {
        ElementDefinitionMappingComponent dst = new ElementDefinitionMappingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinitionMappingComponent dst) {
        super.copyValues(dst);
        dst.identity = identity == null ? null : identity.copy();
        dst.language = language == null ? null : language.copy();
        dst.map = map == null ? null : map.copy();
        dst.comment = comment == null ? null : comment.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionMappingComponent))
          return false;
        ElementDefinitionMappingComponent o = (ElementDefinitionMappingComponent) other_;
        return compareDeep(identity, o.identity, true) && compareDeep(language, o.language, true) && compareDeep(map, o.map, true)
           && compareDeep(comment, o.comment, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinitionMappingComponent))
          return false;
        ElementDefinitionMappingComponent o = (ElementDefinitionMappingComponent) other_;
        return compareValues(identity, o.identity, true) && compareValues(language, o.language, true) && compareValues(map, o.map, true)
           && compareValues(comment, o.comment, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identity, language, map
          , comment);
      }

  public String fhirType() {
    return "ElementDefinition.mapping";

  }

  }

    /**
     * The path identifies the element and is expressed as a "."-separated list of ancestor elements, beginning with the name of the resource or extension.
     */
    @Child(name = "path", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Path of the element in the hierarchy of elements", formalDefinition="The path identifies the element and is expressed as a \".\"-separated list of ancestor elements, beginning with the name of the resource or extension." )
    protected StringType path;

    /**
     * Codes that define how this element is represented in instances, when the deviation varies from the normal case.
     */
    @Child(name = "representation", type = {CodeType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="xmlAttr | xmlText | typeAttr | cdaText | xhtml", formalDefinition="Codes that define how this element is represented in instances, when the deviation varies from the normal case." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/property-representation")
    protected List<Enumeration<PropertyRepresentation>> representation;

    /**
     * The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.
     */
    @Child(name = "sliceName", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this particular element (in a set of slices)", formalDefinition="The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element." )
    protected StringType sliceName;

    /**
     * If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.
     */
    @Child(name = "sliceIsConstraining", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this slice definition constrains an inherited slice definition (or not)", formalDefinition="If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName." )
    protected BooleanType sliceIsConstraining;

    /**
     * A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.
     */
    @Child(name = "label", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for element to display with or prompt for element", formalDefinition="A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form." )
    protected StringType label;

    /**
     * A code that has the same meaning as the element in a particular terminology.
     */
    @Child(name = "code", type = {Coding.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Corresponding codes in terminologies", formalDefinition="A code that has the same meaning as the element in a particular terminology." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
    protected List<Coding> code;

    /**
     * Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition, there are multiple different constraints on a single element in the base resource). Slicing can be used in any resource that has cardinality ..* on the base resource, or any resource with a choice of types. The set of slices is any elements that come after this in the element sequence that have the same path, until a shorter path occurs (the shorter path terminates the set).
     */
    @Child(name = "slicing", type = {}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="This element is sliced - slices follow", formalDefinition="Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition, there are multiple different constraints on a single element in the base resource). Slicing can be used in any resource that has cardinality ..* on the base resource, or any resource with a choice of types. The set of slices is any elements that come after this in the element sequence that have the same path, until a shorter path occurs (the shorter path terminates the set)." )
    protected ElementDefinitionSlicingComponent slicing;

    /**
     * A concise description of what this element means (e.g. for use in autogenerated summaries).
     */
    @Child(name = "short", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Concise definition for space-constrained presentation", formalDefinition="A concise description of what this element means (e.g. for use in autogenerated summaries)." )
    protected StringType short_;

    /**
     * Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).
     */
    @Child(name = "definition", type = {MarkdownType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Full formal definition as narrative text", formalDefinition="Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition)." )
    protected MarkdownType definition;

    /**
     * Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).
     */
    @Child(name = "comment", type = {MarkdownType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Comments about the use of this element", formalDefinition="Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment)." )
    protected MarkdownType comment;

    /**
     * This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.
     */
    @Child(name = "requirements", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Why this resource has been created", formalDefinition="This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element." )
    protected MarkdownType requirements;

    /**
     * Identifies additional names by which this element might also be known.
     */
    @Child(name = "alias", type = {StringType.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Other names", formalDefinition="Identifies additional names by which this element might also be known." )
    protected List<StringType> alias;

    /**
     * The minimum number of times this element SHALL appear in the instance.
     */
    @Child(name = "min", type = {UnsignedIntType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Minimum Cardinality", formalDefinition="The minimum number of times this element SHALL appear in the instance." )
    protected UnsignedIntType min;

    /**
     * The maximum number of times this element is permitted to appear in the instance.
     */
    @Child(name = "max", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Maximum Cardinality (a number or *)", formalDefinition="The maximum number of times this element is permitted to appear in the instance." )
    protected StringType max;

    /**
     * Information about the base definition of the element, provided to make it unnecessary for tools to trace the deviation of the element through the derived and related profiles. When the element definition is not the original definition of an element - i.g. either in a constraint on another type, or for elements from a super type in a snap shot - then the information in provided in the element definition may be different to the base definition. On the original definition of the element, it will be same.
     */
    @Child(name = "base", type = {}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Base definition information for tools", formalDefinition="Information about the base definition of the element, provided to make it unnecessary for tools to trace the deviation of the element through the derived and related profiles. When the element definition is not the original definition of an element - i.g. either in a constraint on another type, or for elements from a super type in a snap shot - then the information in provided in the element definition may be different to the base definition. On the original definition of the element, it will be same." )
    protected ElementDefinitionBaseComponent base;

    /**
     * Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.
     */
    @Child(name = "contentReference", type = {UriType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to definition of content for the element", formalDefinition="Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc." )
    protected UriType contentReference;

    /**
     * The data type or resource that the value of this element is permitted to be.
     */
    @Child(name = "type", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Data type and Profile for this element", formalDefinition="The data type or resource that the value of this element is permitted to be." )
    protected List<TypeRefComponent> type;

    /**
     * The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').
     */
    @Child(name = "defaultValue", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specified value if missing from instance", formalDefinition="The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false')." )
    protected DataType defaultValue;

    /**
     * The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').
     */
    @Child(name = "meaningWhenMissing", type = {MarkdownType.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Implicit meaning when this element is missing", formalDefinition="The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing')." )
    protected MarkdownType meaningWhenMissing;

    /**
     * If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.
     */
    @Child(name = "orderMeaning", type = {StringType.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What the order of the elements means", formalDefinition="If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning." )
    protected StringType orderMeaning;

    /**
     * Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.
     */
    @Child(name = "fixed", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Value must be exactly this", formalDefinition="Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing." )
    protected DataType fixed;

    /**
     * Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.
     */
    @Child(name = "pattern", type = {Base64BinaryType.class, BooleanType.class, CanonicalType.class, CodeType.class, DateType.class, DateTimeType.class, DecimalType.class, IdType.class, InstantType.class, IntegerType.class, Integer64Type.class, MarkdownType.class, OidType.class, PositiveIntType.class, StringType.class, TimeType.class, UnsignedIntType.class, UriType.class, UrlType.class, UuidType.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Value must have at least these property values", formalDefinition="Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value." )
    protected DataType pattern;

    /**
     * A sample value for this element demonstrating the type of information that would typically be found in the element.
     */
    @Child(name = "example", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Example value (as defined for type)", formalDefinition="A sample value for this element demonstrating the type of information that would typically be found in the element." )
    protected List<ElementDefinitionExampleComponent> example;

    /**
     * The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.
     */
    @Child(name = "minValue", type = {DateType.class, DateTimeType.class, InstantType.class, TimeType.class, DecimalType.class, IntegerType.class, Integer64Type.class, PositiveIntType.class, UnsignedIntType.class, Quantity.class}, order=23, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Minimum Allowed Value (for some types)", formalDefinition="The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity." )
    protected DataType minValue;

    /**
     * The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.
     */
    @Child(name = "maxValue", type = {DateType.class, DateTimeType.class, InstantType.class, TimeType.class, DecimalType.class, IntegerType.class, Integer64Type.class, PositiveIntType.class, UnsignedIntType.class, Quantity.class}, order=24, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Maximum Allowed Value (for some types)", formalDefinition="The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity." )
    protected DataType maxValue;

    /**
     * Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.
     */
    @Child(name = "maxLength", type = {IntegerType.class}, order=25, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Max length for strings", formalDefinition="Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element." )
    protected IntegerType maxLength;

    /**
     * A reference to an invariant that may make additional statements about the cardinality or value in the instance.
     */
    @Child(name = "condition", type = {IdType.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Reference to invariant about presence", formalDefinition="A reference to an invariant that may make additional statements about the cardinality or value in the instance." )
    protected List<IdType> condition;

    /**
     * Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the context of the instance.
     */
    @Child(name = "constraint", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Condition that must evaluate to true", formalDefinition="Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the context of the instance." )
    protected List<ElementDefinitionConstraintComponent> constraint;

    /**
     * If true, implementations that produce or consume resources SHALL provide "support" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.
     */
    @Child(name = "mustSupport", type = {BooleanType.class}, order=28, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If the element must be supported", formalDefinition="If true, implementations that produce or consume resources SHALL provide \"support\" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation." )
    protected BooleanType mustSupport;

    /**
     * If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.
     */
    @Child(name = "isModifier", type = {BooleanType.class}, order=29, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this modifies the meaning of other elements", formalDefinition="If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system." )
    protected BooleanType isModifier;

    /**
     * Explains how that element affects the interpretation of the resource or element that contains it.
     */
    @Child(name = "isModifierReason", type = {StringType.class}, order=30, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reason that this element is marked as a modifier", formalDefinition="Explains how that element affects the interpretation of the resource or element that contains it." )
    protected StringType isModifierReason;

    /**
     * Whether the element should be included if a client requests a search with the parameter _summary=true.
     */
    @Child(name = "isSummary", type = {BooleanType.class}, order=31, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Include when _summary = true?", formalDefinition="Whether the element should be included if a client requests a search with the parameter _summary=true." )
    protected BooleanType isSummary;

    /**
     * Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types (string, uri).
     */
    @Child(name = "binding", type = {}, order=32, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="ValueSet details if this is coded", formalDefinition="Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types (string, uri)." )
    protected ElementDefinitionBindingComponent binding;

    /**
     * Identifies a concept from an external specification that roughly corresponds to this element.
     */
    @Child(name = "mapping", type = {}, order=33, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Map element to another set of definitions", formalDefinition="Identifies a concept from an external specification that roughly corresponds to this element." )
    protected List<ElementDefinitionMappingComponent> mapping;

    private static final long serialVersionUID = 821951601L;

  /**
   * Constructor
   */
    public ElementDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ElementDefinition(String path) {
      super();
      this.setPath(path);
    }

    /**
     * @return {@link #path} (The path identifies the element and is expressed as a "."-separated list of ancestor elements, beginning with the name of the resource or extension.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
     */
    public StringType getPathElement() { 
      if (this.path == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.path");
        else if (Configuration.doAutoCreate())
          this.path = new StringType(); // bb
      return this.path;
    }

    public boolean hasPathElement() { 
      return this.path != null && !this.path.isEmpty();
    }

    public boolean hasPath() { 
      return this.path != null && !this.path.isEmpty();
    }

    /**
     * @param value {@link #path} (The path identifies the element and is expressed as a "."-separated list of ancestor elements, beginning with the name of the resource or extension.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
     */
    public ElementDefinition setPathElement(StringType value) { 
      this.path = value;
      return this;
    }

    /**
     * @return The path identifies the element and is expressed as a "."-separated list of ancestor elements, beginning with the name of the resource or extension.
     */
    public String getPath() { 
      return this.path == null ? null : this.path.getValue();
    }

    /**
     * @param value The path identifies the element and is expressed as a "."-separated list of ancestor elements, beginning with the name of the resource or extension.
     */
    public ElementDefinition setPath(String value) { 
        if (this.path == null)
          this.path = new StringType();
        this.path.setValue(value);
      return this;
    }

    /**
     * @return {@link #representation} (Codes that define how this element is represented in instances, when the deviation varies from the normal case.)
     */
    public List<Enumeration<PropertyRepresentation>> getRepresentation() { 
      if (this.representation == null)
        this.representation = new ArrayList<Enumeration<PropertyRepresentation>>();
      return this.representation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setRepresentation(List<Enumeration<PropertyRepresentation>> theRepresentation) { 
      this.representation = theRepresentation;
      return this;
    }

    public boolean hasRepresentation() { 
      if (this.representation == null)
        return false;
      for (Enumeration<PropertyRepresentation> item : this.representation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #representation} (Codes that define how this element is represented in instances, when the deviation varies from the normal case.)
     */
    public Enumeration<PropertyRepresentation> addRepresentationElement() {//2 
      Enumeration<PropertyRepresentation> t = new Enumeration<PropertyRepresentation>(new PropertyRepresentationEnumFactory());
      if (this.representation == null)
        this.representation = new ArrayList<Enumeration<PropertyRepresentation>>();
      this.representation.add(t);
      return t;
    }

    /**
     * @param value {@link #representation} (Codes that define how this element is represented in instances, when the deviation varies from the normal case.)
     */
    public ElementDefinition addRepresentation(PropertyRepresentation value) { //1
      Enumeration<PropertyRepresentation> t = new Enumeration<PropertyRepresentation>(new PropertyRepresentationEnumFactory());
      t.setValue(value);
      if (this.representation == null)
        this.representation = new ArrayList<Enumeration<PropertyRepresentation>>();
      this.representation.add(t);
      return this;
    }

    /**
     * @param value {@link #representation} (Codes that define how this element is represented in instances, when the deviation varies from the normal case.)
     */
    public boolean hasRepresentation(PropertyRepresentation value) { 
      if (this.representation == null)
        return false;
      for (Enumeration<PropertyRepresentation> v : this.representation)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #sliceName} (The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.). This is the underlying object with id, value and extensions. The accessor "getSliceName" gives direct access to the value
     */
    public StringType getSliceNameElement() { 
      if (this.sliceName == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.sliceName");
        else if (Configuration.doAutoCreate())
          this.sliceName = new StringType(); // bb
      return this.sliceName;
    }

    public boolean hasSliceNameElement() { 
      return this.sliceName != null && !this.sliceName.isEmpty();
    }

    public boolean hasSliceName() { 
      return this.sliceName != null && !this.sliceName.isEmpty();
    }

    /**
     * @param value {@link #sliceName} (The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.). This is the underlying object with id, value and extensions. The accessor "getSliceName" gives direct access to the value
     */
    public ElementDefinition setSliceNameElement(StringType value) { 
      this.sliceName = value;
      return this;
    }

    /**
     * @return The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.
     */
    public String getSliceName() { 
      return this.sliceName == null ? null : this.sliceName.getValue();
    }

    /**
     * @param value The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.
     */
    public ElementDefinition setSliceName(String value) { 
      if (Utilities.noString(value))
        this.sliceName = null;
      else {
        if (this.sliceName == null)
          this.sliceName = new StringType();
        this.sliceName.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #sliceIsConstraining} (If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.). This is the underlying object with id, value and extensions. The accessor "getSliceIsConstraining" gives direct access to the value
     */
    public BooleanType getSliceIsConstrainingElement() { 
      if (this.sliceIsConstraining == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.sliceIsConstraining");
        else if (Configuration.doAutoCreate())
          this.sliceIsConstraining = new BooleanType(); // bb
      return this.sliceIsConstraining;
    }

    public boolean hasSliceIsConstrainingElement() { 
      return this.sliceIsConstraining != null && !this.sliceIsConstraining.isEmpty();
    }

    public boolean hasSliceIsConstraining() { 
      return this.sliceIsConstraining != null && !this.sliceIsConstraining.isEmpty();
    }

    /**
     * @param value {@link #sliceIsConstraining} (If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.). This is the underlying object with id, value and extensions. The accessor "getSliceIsConstraining" gives direct access to the value
     */
    public ElementDefinition setSliceIsConstrainingElement(BooleanType value) { 
      this.sliceIsConstraining = value;
      return this;
    }

    /**
     * @return If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.
     */
    public boolean getSliceIsConstraining() { 
      return this.sliceIsConstraining == null || this.sliceIsConstraining.isEmpty() ? false : this.sliceIsConstraining.getValue();
    }

    /**
     * @param value If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.
     */
    public ElementDefinition setSliceIsConstraining(boolean value) { 
        if (this.sliceIsConstraining == null)
          this.sliceIsConstraining = new BooleanType();
        this.sliceIsConstraining.setValue(value);
      return this;
    }

    /**
     * @return {@link #label} (A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public StringType getLabelElement() { 
      if (this.label == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.label");
        else if (Configuration.doAutoCreate())
          this.label = new StringType(); // bb
      return this.label;
    }

    public boolean hasLabelElement() { 
      return this.label != null && !this.label.isEmpty();
    }

    public boolean hasLabel() { 
      return this.label != null && !this.label.isEmpty();
    }

    /**
     * @param value {@link #label} (A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public ElementDefinition setLabelElement(StringType value) { 
      this.label = value;
      return this;
    }

    /**
     * @return A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.
     */
    public String getLabel() { 
      return this.label == null ? null : this.label.getValue();
    }

    /**
     * @param value A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.
     */
    public ElementDefinition setLabel(String value) { 
      if (Utilities.noString(value))
        this.label = null;
      else {
        if (this.label == null)
          this.label = new StringType();
        this.label.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #code} (A code that has the same meaning as the element in a particular terminology.)
     */
    public List<Coding> getCode() { 
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      return this.code;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setCode(List<Coding> theCode) { 
      this.code = theCode;
      return this;
    }

    public boolean hasCode() { 
      if (this.code == null)
        return false;
      for (Coding item : this.code)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Coding addCode() { //3
      Coding t = new Coding();
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      this.code.add(t);
      return t;
    }

    public ElementDefinition addCode(Coding t) { //3
      if (t == null)
        return this;
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      this.code.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #code}, creating it if it does not already exist {3}
     */
    public Coding getCodeFirstRep() { 
      if (getCode().isEmpty()) {
        addCode();
      }
      return getCode().get(0);
    }

    /**
     * @return {@link #slicing} (Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition, there are multiple different constraints on a single element in the base resource). Slicing can be used in any resource that has cardinality ..* on the base resource, or any resource with a choice of types. The set of slices is any elements that come after this in the element sequence that have the same path, until a shorter path occurs (the shorter path terminates the set).)
     */
    public ElementDefinitionSlicingComponent getSlicing() { 
      if (this.slicing == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.slicing");
        else if (Configuration.doAutoCreate())
          this.slicing = new ElementDefinitionSlicingComponent(); // cc
      return this.slicing;
    }

    public boolean hasSlicing() { 
      return this.slicing != null && !this.slicing.isEmpty();
    }

    /**
     * @param value {@link #slicing} (Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition, there are multiple different constraints on a single element in the base resource). Slicing can be used in any resource that has cardinality ..* on the base resource, or any resource with a choice of types. The set of slices is any elements that come after this in the element sequence that have the same path, until a shorter path occurs (the shorter path terminates the set).)
     */
    public ElementDefinition setSlicing(ElementDefinitionSlicingComponent value) { 
      this.slicing = value;
      return this;
    }

    /**
     * @return {@link #short_} (A concise description of what this element means (e.g. for use in autogenerated summaries).). This is the underlying object with id, value and extensions. The accessor "getShort" gives direct access to the value
     */
    public StringType getShortElement() { 
      if (this.short_ == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.short_");
        else if (Configuration.doAutoCreate())
          this.short_ = new StringType(); // bb
      return this.short_;
    }

    public boolean hasShortElement() { 
      return this.short_ != null && !this.short_.isEmpty();
    }

    public boolean hasShort() { 
      return this.short_ != null && !this.short_.isEmpty();
    }

    /**
     * @param value {@link #short_} (A concise description of what this element means (e.g. for use in autogenerated summaries).). This is the underlying object with id, value and extensions. The accessor "getShort" gives direct access to the value
     */
    public ElementDefinition setShortElement(StringType value) { 
      this.short_ = value;
      return this;
    }

    /**
     * @return A concise description of what this element means (e.g. for use in autogenerated summaries).
     */
    public String getShort() { 
      return this.short_ == null ? null : this.short_.getValue();
    }

    /**
     * @param value A concise description of what this element means (e.g. for use in autogenerated summaries).
     */
    public ElementDefinition setShort(String value) { 
      if (Utilities.noString(value))
        this.short_ = null;
      else {
        if (this.short_ == null)
          this.short_ = new StringType();
        this.short_.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #definition} (Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
     */
    public MarkdownType getDefinitionElement() { 
      if (this.definition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.definition");
        else if (Configuration.doAutoCreate())
          this.definition = new MarkdownType(); // bb
      return this.definition;
    }

    public boolean hasDefinitionElement() { 
      return this.definition != null && !this.definition.isEmpty();
    }

    public boolean hasDefinition() { 
      return this.definition != null && !this.definition.isEmpty();
    }

    /**
     * @param value {@link #definition} (Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
     */
    public ElementDefinition setDefinitionElement(MarkdownType value) { 
      this.definition = value;
      return this;
    }

    /**
     * @return Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).
     */
    public String getDefinition() { 
      return this.definition == null ? null : this.definition.getValue();
    }

    /**
     * @param value Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).
     */
    public ElementDefinition setDefinition(String value) { 
      if (value == null)
        this.definition = null;
      else {
        if (this.definition == null)
          this.definition = new MarkdownType();
        this.definition.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #comment} (Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public MarkdownType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new MarkdownType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public ElementDefinition setCommentElement(MarkdownType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).
     */
    public ElementDefinition setComment(String value) { 
      if (value == null)
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new MarkdownType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #requirements} (This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.). This is the underlying object with id, value and extensions. The accessor "getRequirements" gives direct access to the value
     */
    public MarkdownType getRequirementsElement() { 
      if (this.requirements == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.requirements");
        else if (Configuration.doAutoCreate())
          this.requirements = new MarkdownType(); // bb
      return this.requirements;
    }

    public boolean hasRequirementsElement() { 
      return this.requirements != null && !this.requirements.isEmpty();
    }

    public boolean hasRequirements() { 
      return this.requirements != null && !this.requirements.isEmpty();
    }

    /**
     * @param value {@link #requirements} (This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.). This is the underlying object with id, value and extensions. The accessor "getRequirements" gives direct access to the value
     */
    public ElementDefinition setRequirementsElement(MarkdownType value) { 
      this.requirements = value;
      return this;
    }

    /**
     * @return This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.
     */
    public String getRequirements() { 
      return this.requirements == null ? null : this.requirements.getValue();
    }

    /**
     * @param value This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.
     */
    public ElementDefinition setRequirements(String value) { 
      if (value == null)
        this.requirements = null;
      else {
        if (this.requirements == null)
          this.requirements = new MarkdownType();
        this.requirements.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #alias} (Identifies additional names by which this element might also be known.)
     */
    public List<StringType> getAlias() { 
      if (this.alias == null)
        this.alias = new ArrayList<StringType>();
      return this.alias;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setAlias(List<StringType> theAlias) { 
      this.alias = theAlias;
      return this;
    }

    public boolean hasAlias() { 
      if (this.alias == null)
        return false;
      for (StringType item : this.alias)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #alias} (Identifies additional names by which this element might also be known.)
     */
    public StringType addAliasElement() {//2 
      StringType t = new StringType();
      if (this.alias == null)
        this.alias = new ArrayList<StringType>();
      this.alias.add(t);
      return t;
    }

    /**
     * @param value {@link #alias} (Identifies additional names by which this element might also be known.)
     */
    public ElementDefinition addAlias(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.alias == null)
        this.alias = new ArrayList<StringType>();
      this.alias.add(t);
      return this;
    }

    /**
     * @param value {@link #alias} (Identifies additional names by which this element might also be known.)
     */
    public boolean hasAlias(String value) { 
      if (this.alias == null)
        return false;
      for (StringType v : this.alias)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #min} (The minimum number of times this element SHALL appear in the instance.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
     */
    public UnsignedIntType getMinElement() { 
      if (this.min == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.min");
        else if (Configuration.doAutoCreate())
          this.min = new UnsignedIntType(); // bb
      return this.min;
    }

    public boolean hasMinElement() { 
      return this.min != null && !this.min.isEmpty();
    }

    public boolean hasMin() { 
      return this.min != null && !this.min.isEmpty();
    }

    /**
     * @param value {@link #min} (The minimum number of times this element SHALL appear in the instance.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
     */
    public ElementDefinition setMinElement(UnsignedIntType value) { 
      this.min = value;
      return this;
    }

    /**
     * @return The minimum number of times this element SHALL appear in the instance.
     */
    public int getMin() { 
      return this.min == null || this.min.isEmpty() ? 0 : this.min.getValue();
    }

    /**
     * @param value The minimum number of times this element SHALL appear in the instance.
     */
    public ElementDefinition setMin(int value) { 
        if (this.min == null)
          this.min = new UnsignedIntType();
        this.min.setValue(value);
      return this;
    }

    /**
     * @return {@link #max} (The maximum number of times this element is permitted to appear in the instance.). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
     */
    public StringType getMaxElement() { 
      if (this.max == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.max");
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
     * @param value {@link #max} (The maximum number of times this element is permitted to appear in the instance.). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
     */
    public ElementDefinition setMaxElement(StringType value) { 
      this.max = value;
      return this;
    }

    /**
     * @return The maximum number of times this element is permitted to appear in the instance.
     */
    public String getMax() { 
      return this.max == null ? null : this.max.getValue();
    }

    /**
     * @param value The maximum number of times this element is permitted to appear in the instance.
     */
    public ElementDefinition setMax(String value) { 
      if (Utilities.noString(value))
        this.max = null;
      else {
        if (this.max == null)
          this.max = new StringType();
        this.max.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #base} (Information about the base definition of the element, provided to make it unnecessary for tools to trace the deviation of the element through the derived and related profiles. When the element definition is not the original definition of an element - i.g. either in a constraint on another type, or for elements from a super type in a snap shot - then the information in provided in the element definition may be different to the base definition. On the original definition of the element, it will be same.)
     */
    public ElementDefinitionBaseComponent getBase() { 
      if (this.base == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.base");
        else if (Configuration.doAutoCreate())
          this.base = new ElementDefinitionBaseComponent(); // cc
      return this.base;
    }

    public boolean hasBase() { 
      return this.base != null && !this.base.isEmpty();
    }

    /**
     * @param value {@link #base} (Information about the base definition of the element, provided to make it unnecessary for tools to trace the deviation of the element through the derived and related profiles. When the element definition is not the original definition of an element - i.g. either in a constraint on another type, or for elements from a super type in a snap shot - then the information in provided in the element definition may be different to the base definition. On the original definition of the element, it will be same.)
     */
    public ElementDefinition setBase(ElementDefinitionBaseComponent value) { 
      this.base = value;
      return this;
    }

    /**
     * @return {@link #contentReference} (Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.). This is the underlying object with id, value and extensions. The accessor "getContentReference" gives direct access to the value
     */
    public UriType getContentReferenceElement() { 
      if (this.contentReference == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.contentReference");
        else if (Configuration.doAutoCreate())
          this.contentReference = new UriType(); // bb
      return this.contentReference;
    }

    public boolean hasContentReferenceElement() { 
      return this.contentReference != null && !this.contentReference.isEmpty();
    }

    public boolean hasContentReference() { 
      return this.contentReference != null && !this.contentReference.isEmpty();
    }

    /**
     * @param value {@link #contentReference} (Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.). This is the underlying object with id, value and extensions. The accessor "getContentReference" gives direct access to the value
     */
    public ElementDefinition setContentReferenceElement(UriType value) { 
      this.contentReference = value;
      return this;
    }

    /**
     * @return Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.
     */
    public String getContentReference() { 
      return this.contentReference == null ? null : this.contentReference.getValue();
    }

    /**
     * @param value Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.
     */
    public ElementDefinition setContentReference(String value) { 
      if (Utilities.noString(value))
        this.contentReference = null;
      else {
        if (this.contentReference == null)
          this.contentReference = new UriType();
        this.contentReference.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (The data type or resource that the value of this element is permitted to be.)
     */
    public List<TypeRefComponent> getType() { 
      if (this.type == null)
        this.type = new ArrayList<TypeRefComponent>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setType(List<TypeRefComponent> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (TypeRefComponent item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TypeRefComponent addType() { //3
      TypeRefComponent t = new TypeRefComponent();
      if (this.type == null)
        this.type = new ArrayList<TypeRefComponent>();
      this.type.add(t);
      return t;
    }

    public ElementDefinition addType(TypeRefComponent t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<TypeRefComponent>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
     */
    public TypeRefComponent getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public DataType getDefaultValue() { 
      return this.defaultValue;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Base64BinaryType getDefaultValueBase64BinaryType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Base64BinaryType();
      if (!(this.defaultValue instanceof Base64BinaryType))
        throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Base64BinaryType) this.defaultValue;
    }

    public boolean hasDefaultValueBase64BinaryType() { 
      return this != null && this.defaultValue instanceof Base64BinaryType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public BooleanType getDefaultValueBooleanType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new BooleanType();
      if (!(this.defaultValue instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (BooleanType) this.defaultValue;
    }

    public boolean hasDefaultValueBooleanType() { 
      return this != null && this.defaultValue instanceof BooleanType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public CanonicalType getDefaultValueCanonicalType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new CanonicalType();
      if (!(this.defaultValue instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (CanonicalType) this.defaultValue;
    }

    public boolean hasDefaultValueCanonicalType() { 
      return this != null && this.defaultValue instanceof CanonicalType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public CodeType getDefaultValueCodeType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new CodeType();
      if (!(this.defaultValue instanceof CodeType))
        throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (CodeType) this.defaultValue;
    }

    public boolean hasDefaultValueCodeType() { 
      return this != null && this.defaultValue instanceof CodeType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public DateType getDefaultValueDateType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new DateType();
      if (!(this.defaultValue instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (DateType) this.defaultValue;
    }

    public boolean hasDefaultValueDateType() { 
      return this != null && this.defaultValue instanceof DateType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public DateTimeType getDefaultValueDateTimeType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new DateTimeType();
      if (!(this.defaultValue instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (DateTimeType) this.defaultValue;
    }

    public boolean hasDefaultValueDateTimeType() { 
      return this != null && this.defaultValue instanceof DateTimeType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public DecimalType getDefaultValueDecimalType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new DecimalType();
      if (!(this.defaultValue instanceof DecimalType))
        throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (DecimalType) this.defaultValue;
    }

    public boolean hasDefaultValueDecimalType() { 
      return this != null && this.defaultValue instanceof DecimalType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public IdType getDefaultValueIdType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new IdType();
      if (!(this.defaultValue instanceof IdType))
        throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (IdType) this.defaultValue;
    }

    public boolean hasDefaultValueIdType() { 
      return this != null && this.defaultValue instanceof IdType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public InstantType getDefaultValueInstantType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new InstantType();
      if (!(this.defaultValue instanceof InstantType))
        throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (InstantType) this.defaultValue;
    }

    public boolean hasDefaultValueInstantType() { 
      return this != null && this.defaultValue instanceof InstantType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public IntegerType getDefaultValueIntegerType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new IntegerType();
      if (!(this.defaultValue instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (IntegerType) this.defaultValue;
    }

    public boolean hasDefaultValueIntegerType() { 
      return this != null && this.defaultValue instanceof IntegerType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Integer64Type getDefaultValueInteger64Type() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Integer64Type();
      if (!(this.defaultValue instanceof Integer64Type))
        throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Integer64Type) this.defaultValue;
    }

    public boolean hasDefaultValueInteger64Type() { 
      return this != null && this.defaultValue instanceof Integer64Type;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public MarkdownType getDefaultValueMarkdownType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new MarkdownType();
      if (!(this.defaultValue instanceof MarkdownType))
        throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (MarkdownType) this.defaultValue;
    }

    public boolean hasDefaultValueMarkdownType() { 
      return this != null && this.defaultValue instanceof MarkdownType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public OidType getDefaultValueOidType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new OidType();
      if (!(this.defaultValue instanceof OidType))
        throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (OidType) this.defaultValue;
    }

    public boolean hasDefaultValueOidType() { 
      return this != null && this.defaultValue instanceof OidType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public PositiveIntType getDefaultValuePositiveIntType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new PositiveIntType();
      if (!(this.defaultValue instanceof PositiveIntType))
        throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (PositiveIntType) this.defaultValue;
    }

    public boolean hasDefaultValuePositiveIntType() { 
      return this != null && this.defaultValue instanceof PositiveIntType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public StringType getDefaultValueStringType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new StringType();
      if (!(this.defaultValue instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (StringType) this.defaultValue;
    }

    public boolean hasDefaultValueStringType() { 
      return this != null && this.defaultValue instanceof StringType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public TimeType getDefaultValueTimeType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new TimeType();
      if (!(this.defaultValue instanceof TimeType))
        throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (TimeType) this.defaultValue;
    }

    public boolean hasDefaultValueTimeType() { 
      return this != null && this.defaultValue instanceof TimeType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public UnsignedIntType getDefaultValueUnsignedIntType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new UnsignedIntType();
      if (!(this.defaultValue instanceof UnsignedIntType))
        throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (UnsignedIntType) this.defaultValue;
    }

    public boolean hasDefaultValueUnsignedIntType() { 
      return this != null && this.defaultValue instanceof UnsignedIntType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public UriType getDefaultValueUriType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new UriType();
      if (!(this.defaultValue instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (UriType) this.defaultValue;
    }

    public boolean hasDefaultValueUriType() { 
      return this != null && this.defaultValue instanceof UriType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public UrlType getDefaultValueUrlType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new UrlType();
      if (!(this.defaultValue instanceof UrlType))
        throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (UrlType) this.defaultValue;
    }

    public boolean hasDefaultValueUrlType() { 
      return this != null && this.defaultValue instanceof UrlType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public UuidType getDefaultValueUuidType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new UuidType();
      if (!(this.defaultValue instanceof UuidType))
        throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (UuidType) this.defaultValue;
    }

    public boolean hasDefaultValueUuidType() { 
      return this != null && this.defaultValue instanceof UuidType;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Address getDefaultValueAddress() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Address();
      if (!(this.defaultValue instanceof Address))
        throw new FHIRException("Type mismatch: the type Address was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Address) this.defaultValue;
    }

    public boolean hasDefaultValueAddress() { 
      return this != null && this.defaultValue instanceof Address;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Age getDefaultValueAge() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Age();
      if (!(this.defaultValue instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Age) this.defaultValue;
    }

    public boolean hasDefaultValueAge() { 
      return this != null && this.defaultValue instanceof Age;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Annotation getDefaultValueAnnotation() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Annotation();
      if (!(this.defaultValue instanceof Annotation))
        throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Annotation) this.defaultValue;
    }

    public boolean hasDefaultValueAnnotation() { 
      return this != null && this.defaultValue instanceof Annotation;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Attachment getDefaultValueAttachment() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Attachment();
      if (!(this.defaultValue instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Attachment) this.defaultValue;
    }

    public boolean hasDefaultValueAttachment() { 
      return this != null && this.defaultValue instanceof Attachment;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public CodeableConcept getDefaultValueCodeableConcept() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new CodeableConcept();
      if (!(this.defaultValue instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (CodeableConcept) this.defaultValue;
    }

    public boolean hasDefaultValueCodeableConcept() { 
      return this != null && this.defaultValue instanceof CodeableConcept;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Coding getDefaultValueCoding() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Coding();
      if (!(this.defaultValue instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Coding) this.defaultValue;
    }

    public boolean hasDefaultValueCoding() { 
      return this != null && this.defaultValue instanceof Coding;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public ContactPoint getDefaultValueContactPoint() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new ContactPoint();
      if (!(this.defaultValue instanceof ContactPoint))
        throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (ContactPoint) this.defaultValue;
    }

    public boolean hasDefaultValueContactPoint() { 
      return this != null && this.defaultValue instanceof ContactPoint;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Count getDefaultValueCount() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Count();
      if (!(this.defaultValue instanceof Count))
        throw new FHIRException("Type mismatch: the type Count was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Count) this.defaultValue;
    }

    public boolean hasDefaultValueCount() { 
      return this != null && this.defaultValue instanceof Count;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Distance getDefaultValueDistance() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Distance();
      if (!(this.defaultValue instanceof Distance))
        throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Distance) this.defaultValue;
    }

    public boolean hasDefaultValueDistance() { 
      return this != null && this.defaultValue instanceof Distance;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Duration getDefaultValueDuration() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Duration();
      if (!(this.defaultValue instanceof Duration))
        throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Duration) this.defaultValue;
    }

    public boolean hasDefaultValueDuration() { 
      return this != null && this.defaultValue instanceof Duration;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public HumanName getDefaultValueHumanName() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new HumanName();
      if (!(this.defaultValue instanceof HumanName))
        throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (HumanName) this.defaultValue;
    }

    public boolean hasDefaultValueHumanName() { 
      return this != null && this.defaultValue instanceof HumanName;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Identifier getDefaultValueIdentifier() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Identifier();
      if (!(this.defaultValue instanceof Identifier))
        throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Identifier) this.defaultValue;
    }

    public boolean hasDefaultValueIdentifier() { 
      return this != null && this.defaultValue instanceof Identifier;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Money getDefaultValueMoney() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Money();
      if (!(this.defaultValue instanceof Money))
        throw new FHIRException("Type mismatch: the type Money was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Money) this.defaultValue;
    }

    public boolean hasDefaultValueMoney() { 
      return this != null && this.defaultValue instanceof Money;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Period getDefaultValuePeriod() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Period();
      if (!(this.defaultValue instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Period) this.defaultValue;
    }

    public boolean hasDefaultValuePeriod() { 
      return this != null && this.defaultValue instanceof Period;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Quantity getDefaultValueQuantity() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Quantity();
      if (!(this.defaultValue instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Quantity) this.defaultValue;
    }

    public boolean hasDefaultValueQuantity() { 
      return this != null && this.defaultValue instanceof Quantity;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Range getDefaultValueRange() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Range();
      if (!(this.defaultValue instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Range) this.defaultValue;
    }

    public boolean hasDefaultValueRange() { 
      return this != null && this.defaultValue instanceof Range;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Ratio getDefaultValueRatio() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Ratio();
      if (!(this.defaultValue instanceof Ratio))
        throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Ratio) this.defaultValue;
    }

    public boolean hasDefaultValueRatio() { 
      return this != null && this.defaultValue instanceof Ratio;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Reference getDefaultValueReference() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Reference();
      if (!(this.defaultValue instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Reference) this.defaultValue;
    }

    public boolean hasDefaultValueReference() { 
      return this != null && this.defaultValue instanceof Reference;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public SampledData getDefaultValueSampledData() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new SampledData();
      if (!(this.defaultValue instanceof SampledData))
        throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (SampledData) this.defaultValue;
    }

    public boolean hasDefaultValueSampledData() { 
      return this != null && this.defaultValue instanceof SampledData;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Signature getDefaultValueSignature() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Signature();
      if (!(this.defaultValue instanceof Signature))
        throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Signature) this.defaultValue;
    }

    public boolean hasDefaultValueSignature() { 
      return this != null && this.defaultValue instanceof Signature;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Timing getDefaultValueTiming() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Timing();
      if (!(this.defaultValue instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Timing) this.defaultValue;
    }

    public boolean hasDefaultValueTiming() { 
      return this != null && this.defaultValue instanceof Timing;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public ContactDetail getDefaultValueContactDetail() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new ContactDetail();
      if (!(this.defaultValue instanceof ContactDetail))
        throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (ContactDetail) this.defaultValue;
    }

    public boolean hasDefaultValueContactDetail() { 
      return this != null && this.defaultValue instanceof ContactDetail;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Contributor getDefaultValueContributor() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Contributor();
      if (!(this.defaultValue instanceof Contributor))
        throw new FHIRException("Type mismatch: the type Contributor was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Contributor) this.defaultValue;
    }

    public boolean hasDefaultValueContributor() { 
      return this != null && this.defaultValue instanceof Contributor;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public DataRequirement getDefaultValueDataRequirement() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new DataRequirement();
      if (!(this.defaultValue instanceof DataRequirement))
        throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (DataRequirement) this.defaultValue;
    }

    public boolean hasDefaultValueDataRequirement() { 
      return this != null && this.defaultValue instanceof DataRequirement;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Expression getDefaultValueExpression() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Expression();
      if (!(this.defaultValue instanceof Expression))
        throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Expression) this.defaultValue;
    }

    public boolean hasDefaultValueExpression() { 
      return this != null && this.defaultValue instanceof Expression;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public ParameterDefinition getDefaultValueParameterDefinition() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new ParameterDefinition();
      if (!(this.defaultValue instanceof ParameterDefinition))
        throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (ParameterDefinition) this.defaultValue;
    }

    public boolean hasDefaultValueParameterDefinition() { 
      return this != null && this.defaultValue instanceof ParameterDefinition;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public RelatedArtifact getDefaultValueRelatedArtifact() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new RelatedArtifact();
      if (!(this.defaultValue instanceof RelatedArtifact))
        throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (RelatedArtifact) this.defaultValue;
    }

    public boolean hasDefaultValueRelatedArtifact() { 
      return this != null && this.defaultValue instanceof RelatedArtifact;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public TriggerDefinition getDefaultValueTriggerDefinition() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new TriggerDefinition();
      if (!(this.defaultValue instanceof TriggerDefinition))
        throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (TriggerDefinition) this.defaultValue;
    }

    public boolean hasDefaultValueTriggerDefinition() { 
      return this != null && this.defaultValue instanceof TriggerDefinition;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public UsageContext getDefaultValueUsageContext() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new UsageContext();
      if (!(this.defaultValue instanceof UsageContext))
        throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (UsageContext) this.defaultValue;
    }

    public boolean hasDefaultValueUsageContext() { 
      return this != null && this.defaultValue instanceof UsageContext;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Dosage getDefaultValueDosage() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Dosage();
      if (!(this.defaultValue instanceof Dosage))
        throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Dosage) this.defaultValue;
    }

    public boolean hasDefaultValueDosage() { 
      return this != null && this.defaultValue instanceof Dosage;
    }

    /**
     * @return {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public Meta getDefaultValueMeta() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new Meta();
      if (!(this.defaultValue instanceof Meta))
        throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (Meta) this.defaultValue;
    }

    public boolean hasDefaultValueMeta() { 
      return this != null && this.defaultValue instanceof Meta;
    }

    public boolean hasDefaultValue() { 
      return this.defaultValue != null && !this.defaultValue.isEmpty();
    }

    /**
     * @param value {@link #defaultValue} (The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').)
     */
    public ElementDefinition setDefaultValue(DataType value) { 
      if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof Contributor || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Dosage || value instanceof Meta))
        throw new Error("Not the right type for ElementDefinition.defaultValue[x]: "+value.fhirType());
      this.defaultValue = value;
      return this;
    }

    /**
     * @return {@link #meaningWhenMissing} (The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').). This is the underlying object with id, value and extensions. The accessor "getMeaningWhenMissing" gives direct access to the value
     */
    public MarkdownType getMeaningWhenMissingElement() { 
      if (this.meaningWhenMissing == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.meaningWhenMissing");
        else if (Configuration.doAutoCreate())
          this.meaningWhenMissing = new MarkdownType(); // bb
      return this.meaningWhenMissing;
    }

    public boolean hasMeaningWhenMissingElement() { 
      return this.meaningWhenMissing != null && !this.meaningWhenMissing.isEmpty();
    }

    public boolean hasMeaningWhenMissing() { 
      return this.meaningWhenMissing != null && !this.meaningWhenMissing.isEmpty();
    }

    /**
     * @param value {@link #meaningWhenMissing} (The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').). This is the underlying object with id, value and extensions. The accessor "getMeaningWhenMissing" gives direct access to the value
     */
    public ElementDefinition setMeaningWhenMissingElement(MarkdownType value) { 
      this.meaningWhenMissing = value;
      return this;
    }

    /**
     * @return The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').
     */
    public String getMeaningWhenMissing() { 
      return this.meaningWhenMissing == null ? null : this.meaningWhenMissing.getValue();
    }

    /**
     * @param value The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').
     */
    public ElementDefinition setMeaningWhenMissing(String value) { 
      if (value == null)
        this.meaningWhenMissing = null;
      else {
        if (this.meaningWhenMissing == null)
          this.meaningWhenMissing = new MarkdownType();
        this.meaningWhenMissing.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #orderMeaning} (If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.). This is the underlying object with id, value and extensions. The accessor "getOrderMeaning" gives direct access to the value
     */
    public StringType getOrderMeaningElement() { 
      if (this.orderMeaning == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.orderMeaning");
        else if (Configuration.doAutoCreate())
          this.orderMeaning = new StringType(); // bb
      return this.orderMeaning;
    }

    public boolean hasOrderMeaningElement() { 
      return this.orderMeaning != null && !this.orderMeaning.isEmpty();
    }

    public boolean hasOrderMeaning() { 
      return this.orderMeaning != null && !this.orderMeaning.isEmpty();
    }

    /**
     * @param value {@link #orderMeaning} (If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.). This is the underlying object with id, value and extensions. The accessor "getOrderMeaning" gives direct access to the value
     */
    public ElementDefinition setOrderMeaningElement(StringType value) { 
      this.orderMeaning = value;
      return this;
    }

    /**
     * @return If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.
     */
    public String getOrderMeaning() { 
      return this.orderMeaning == null ? null : this.orderMeaning.getValue();
    }

    /**
     * @param value If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.
     */
    public ElementDefinition setOrderMeaning(String value) { 
      if (Utilities.noString(value))
        this.orderMeaning = null;
      else {
        if (this.orderMeaning == null)
          this.orderMeaning = new StringType();
        this.orderMeaning.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public DataType getFixed() { 
      return this.fixed;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Base64BinaryType getFixedBase64BinaryType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Base64BinaryType();
      if (!(this.fixed instanceof Base64BinaryType))
        throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Base64BinaryType) this.fixed;
    }

    public boolean hasFixedBase64BinaryType() { 
      return this != null && this.fixed instanceof Base64BinaryType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public BooleanType getFixedBooleanType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new BooleanType();
      if (!(this.fixed instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (BooleanType) this.fixed;
    }

    public boolean hasFixedBooleanType() { 
      return this != null && this.fixed instanceof BooleanType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public CanonicalType getFixedCanonicalType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new CanonicalType();
      if (!(this.fixed instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (CanonicalType) this.fixed;
    }

    public boolean hasFixedCanonicalType() { 
      return this != null && this.fixed instanceof CanonicalType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public CodeType getFixedCodeType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new CodeType();
      if (!(this.fixed instanceof CodeType))
        throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (CodeType) this.fixed;
    }

    public boolean hasFixedCodeType() { 
      return this != null && this.fixed instanceof CodeType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public DateType getFixedDateType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new DateType();
      if (!(this.fixed instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (DateType) this.fixed;
    }

    public boolean hasFixedDateType() { 
      return this != null && this.fixed instanceof DateType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public DateTimeType getFixedDateTimeType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new DateTimeType();
      if (!(this.fixed instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (DateTimeType) this.fixed;
    }

    public boolean hasFixedDateTimeType() { 
      return this != null && this.fixed instanceof DateTimeType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public DecimalType getFixedDecimalType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new DecimalType();
      if (!(this.fixed instanceof DecimalType))
        throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (DecimalType) this.fixed;
    }

    public boolean hasFixedDecimalType() { 
      return this != null && this.fixed instanceof DecimalType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public IdType getFixedIdType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new IdType();
      if (!(this.fixed instanceof IdType))
        throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (IdType) this.fixed;
    }

    public boolean hasFixedIdType() { 
      return this != null && this.fixed instanceof IdType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public InstantType getFixedInstantType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new InstantType();
      if (!(this.fixed instanceof InstantType))
        throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (InstantType) this.fixed;
    }

    public boolean hasFixedInstantType() { 
      return this != null && this.fixed instanceof InstantType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public IntegerType getFixedIntegerType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new IntegerType();
      if (!(this.fixed instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (IntegerType) this.fixed;
    }

    public boolean hasFixedIntegerType() { 
      return this != null && this.fixed instanceof IntegerType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Integer64Type getFixedInteger64Type() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Integer64Type();
      if (!(this.fixed instanceof Integer64Type))
        throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Integer64Type) this.fixed;
    }

    public boolean hasFixedInteger64Type() { 
      return this != null && this.fixed instanceof Integer64Type;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public MarkdownType getFixedMarkdownType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new MarkdownType();
      if (!(this.fixed instanceof MarkdownType))
        throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (MarkdownType) this.fixed;
    }

    public boolean hasFixedMarkdownType() { 
      return this != null && this.fixed instanceof MarkdownType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public OidType getFixedOidType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new OidType();
      if (!(this.fixed instanceof OidType))
        throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (OidType) this.fixed;
    }

    public boolean hasFixedOidType() { 
      return this != null && this.fixed instanceof OidType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public PositiveIntType getFixedPositiveIntType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new PositiveIntType();
      if (!(this.fixed instanceof PositiveIntType))
        throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (PositiveIntType) this.fixed;
    }

    public boolean hasFixedPositiveIntType() { 
      return this != null && this.fixed instanceof PositiveIntType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public StringType getFixedStringType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new StringType();
      if (!(this.fixed instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (StringType) this.fixed;
    }

    public boolean hasFixedStringType() { 
      return this != null && this.fixed instanceof StringType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public TimeType getFixedTimeType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new TimeType();
      if (!(this.fixed instanceof TimeType))
        throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (TimeType) this.fixed;
    }

    public boolean hasFixedTimeType() { 
      return this != null && this.fixed instanceof TimeType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public UnsignedIntType getFixedUnsignedIntType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new UnsignedIntType();
      if (!(this.fixed instanceof UnsignedIntType))
        throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (UnsignedIntType) this.fixed;
    }

    public boolean hasFixedUnsignedIntType() { 
      return this != null && this.fixed instanceof UnsignedIntType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public UriType getFixedUriType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new UriType();
      if (!(this.fixed instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (UriType) this.fixed;
    }

    public boolean hasFixedUriType() { 
      return this != null && this.fixed instanceof UriType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public UrlType getFixedUrlType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new UrlType();
      if (!(this.fixed instanceof UrlType))
        throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (UrlType) this.fixed;
    }

    public boolean hasFixedUrlType() { 
      return this != null && this.fixed instanceof UrlType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public UuidType getFixedUuidType() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new UuidType();
      if (!(this.fixed instanceof UuidType))
        throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (UuidType) this.fixed;
    }

    public boolean hasFixedUuidType() { 
      return this != null && this.fixed instanceof UuidType;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Address getFixedAddress() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Address();
      if (!(this.fixed instanceof Address))
        throw new FHIRException("Type mismatch: the type Address was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Address) this.fixed;
    }

    public boolean hasFixedAddress() { 
      return this != null && this.fixed instanceof Address;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Age getFixedAge() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Age();
      if (!(this.fixed instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Age) this.fixed;
    }

    public boolean hasFixedAge() { 
      return this != null && this.fixed instanceof Age;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Annotation getFixedAnnotation() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Annotation();
      if (!(this.fixed instanceof Annotation))
        throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Annotation) this.fixed;
    }

    public boolean hasFixedAnnotation() { 
      return this != null && this.fixed instanceof Annotation;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Attachment getFixedAttachment() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Attachment();
      if (!(this.fixed instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Attachment) this.fixed;
    }

    public boolean hasFixedAttachment() { 
      return this != null && this.fixed instanceof Attachment;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public CodeableConcept getFixedCodeableConcept() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new CodeableConcept();
      if (!(this.fixed instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (CodeableConcept) this.fixed;
    }

    public boolean hasFixedCodeableConcept() { 
      return this != null && this.fixed instanceof CodeableConcept;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Coding getFixedCoding() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Coding();
      if (!(this.fixed instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Coding) this.fixed;
    }

    public boolean hasFixedCoding() { 
      return this != null && this.fixed instanceof Coding;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public ContactPoint getFixedContactPoint() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new ContactPoint();
      if (!(this.fixed instanceof ContactPoint))
        throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (ContactPoint) this.fixed;
    }

    public boolean hasFixedContactPoint() { 
      return this != null && this.fixed instanceof ContactPoint;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Count getFixedCount() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Count();
      if (!(this.fixed instanceof Count))
        throw new FHIRException("Type mismatch: the type Count was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Count) this.fixed;
    }

    public boolean hasFixedCount() { 
      return this != null && this.fixed instanceof Count;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Distance getFixedDistance() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Distance();
      if (!(this.fixed instanceof Distance))
        throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Distance) this.fixed;
    }

    public boolean hasFixedDistance() { 
      return this != null && this.fixed instanceof Distance;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Duration getFixedDuration() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Duration();
      if (!(this.fixed instanceof Duration))
        throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Duration) this.fixed;
    }

    public boolean hasFixedDuration() { 
      return this != null && this.fixed instanceof Duration;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public HumanName getFixedHumanName() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new HumanName();
      if (!(this.fixed instanceof HumanName))
        throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (HumanName) this.fixed;
    }

    public boolean hasFixedHumanName() { 
      return this != null && this.fixed instanceof HumanName;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Identifier getFixedIdentifier() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Identifier();
      if (!(this.fixed instanceof Identifier))
        throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Identifier) this.fixed;
    }

    public boolean hasFixedIdentifier() { 
      return this != null && this.fixed instanceof Identifier;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Money getFixedMoney() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Money();
      if (!(this.fixed instanceof Money))
        throw new FHIRException("Type mismatch: the type Money was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Money) this.fixed;
    }

    public boolean hasFixedMoney() { 
      return this != null && this.fixed instanceof Money;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Period getFixedPeriod() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Period();
      if (!(this.fixed instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Period) this.fixed;
    }

    public boolean hasFixedPeriod() { 
      return this != null && this.fixed instanceof Period;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Quantity getFixedQuantity() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Quantity();
      if (!(this.fixed instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Quantity) this.fixed;
    }

    public boolean hasFixedQuantity() { 
      return this != null && this.fixed instanceof Quantity;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Range getFixedRange() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Range();
      if (!(this.fixed instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Range) this.fixed;
    }

    public boolean hasFixedRange() { 
      return this != null && this.fixed instanceof Range;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Ratio getFixedRatio() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Ratio();
      if (!(this.fixed instanceof Ratio))
        throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Ratio) this.fixed;
    }

    public boolean hasFixedRatio() { 
      return this != null && this.fixed instanceof Ratio;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Reference getFixedReference() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Reference();
      if (!(this.fixed instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Reference) this.fixed;
    }

    public boolean hasFixedReference() { 
      return this != null && this.fixed instanceof Reference;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public SampledData getFixedSampledData() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new SampledData();
      if (!(this.fixed instanceof SampledData))
        throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (SampledData) this.fixed;
    }

    public boolean hasFixedSampledData() { 
      return this != null && this.fixed instanceof SampledData;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Signature getFixedSignature() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Signature();
      if (!(this.fixed instanceof Signature))
        throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Signature) this.fixed;
    }

    public boolean hasFixedSignature() { 
      return this != null && this.fixed instanceof Signature;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Timing getFixedTiming() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Timing();
      if (!(this.fixed instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Timing) this.fixed;
    }

    public boolean hasFixedTiming() { 
      return this != null && this.fixed instanceof Timing;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public ContactDetail getFixedContactDetail() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new ContactDetail();
      if (!(this.fixed instanceof ContactDetail))
        throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (ContactDetail) this.fixed;
    }

    public boolean hasFixedContactDetail() { 
      return this != null && this.fixed instanceof ContactDetail;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Contributor getFixedContributor() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Contributor();
      if (!(this.fixed instanceof Contributor))
        throw new FHIRException("Type mismatch: the type Contributor was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Contributor) this.fixed;
    }

    public boolean hasFixedContributor() { 
      return this != null && this.fixed instanceof Contributor;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public DataRequirement getFixedDataRequirement() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new DataRequirement();
      if (!(this.fixed instanceof DataRequirement))
        throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (DataRequirement) this.fixed;
    }

    public boolean hasFixedDataRequirement() { 
      return this != null && this.fixed instanceof DataRequirement;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Expression getFixedExpression() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Expression();
      if (!(this.fixed instanceof Expression))
        throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Expression) this.fixed;
    }

    public boolean hasFixedExpression() { 
      return this != null && this.fixed instanceof Expression;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public ParameterDefinition getFixedParameterDefinition() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new ParameterDefinition();
      if (!(this.fixed instanceof ParameterDefinition))
        throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (ParameterDefinition) this.fixed;
    }

    public boolean hasFixedParameterDefinition() { 
      return this != null && this.fixed instanceof ParameterDefinition;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public RelatedArtifact getFixedRelatedArtifact() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new RelatedArtifact();
      if (!(this.fixed instanceof RelatedArtifact))
        throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (RelatedArtifact) this.fixed;
    }

    public boolean hasFixedRelatedArtifact() { 
      return this != null && this.fixed instanceof RelatedArtifact;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public TriggerDefinition getFixedTriggerDefinition() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new TriggerDefinition();
      if (!(this.fixed instanceof TriggerDefinition))
        throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (TriggerDefinition) this.fixed;
    }

    public boolean hasFixedTriggerDefinition() { 
      return this != null && this.fixed instanceof TriggerDefinition;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public UsageContext getFixedUsageContext() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new UsageContext();
      if (!(this.fixed instanceof UsageContext))
        throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (UsageContext) this.fixed;
    }

    public boolean hasFixedUsageContext() { 
      return this != null && this.fixed instanceof UsageContext;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Dosage getFixedDosage() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Dosage();
      if (!(this.fixed instanceof Dosage))
        throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Dosage) this.fixed;
    }

    public boolean hasFixedDosage() { 
      return this != null && this.fixed instanceof Dosage;
    }

    /**
     * @return {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public Meta getFixedMeta() throws FHIRException { 
      if (this.fixed == null)
        this.fixed = new Meta();
      if (!(this.fixed instanceof Meta))
        throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.fixed.getClass().getName()+" was encountered");
      return (Meta) this.fixed;
    }

    public boolean hasFixedMeta() { 
      return this != null && this.fixed instanceof Meta;
    }

    public boolean hasFixed() { 
      return this.fixed != null && !this.fixed.isEmpty();
    }

    /**
     * @param value {@link #fixed} (Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.)
     */
    public ElementDefinition setFixed(DataType value) { 
      if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof Contributor || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Dosage || value instanceof Meta))
        throw new Error("Not the right type for ElementDefinition.fixed[x]: "+value.fhirType());
      this.fixed = value;
      return this;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public DataType getPattern() { 
      return this.pattern;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Base64BinaryType getPatternBase64BinaryType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Base64BinaryType();
      if (!(this.pattern instanceof Base64BinaryType))
        throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Base64BinaryType) this.pattern;
    }

    public boolean hasPatternBase64BinaryType() { 
      return this != null && this.pattern instanceof Base64BinaryType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public BooleanType getPatternBooleanType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new BooleanType();
      if (!(this.pattern instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (BooleanType) this.pattern;
    }

    public boolean hasPatternBooleanType() { 
      return this != null && this.pattern instanceof BooleanType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public CanonicalType getPatternCanonicalType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new CanonicalType();
      if (!(this.pattern instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (CanonicalType) this.pattern;
    }

    public boolean hasPatternCanonicalType() { 
      return this != null && this.pattern instanceof CanonicalType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public CodeType getPatternCodeType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new CodeType();
      if (!(this.pattern instanceof CodeType))
        throw new FHIRException("Type mismatch: the type CodeType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (CodeType) this.pattern;
    }

    public boolean hasPatternCodeType() { 
      return this != null && this.pattern instanceof CodeType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public DateType getPatternDateType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new DateType();
      if (!(this.pattern instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (DateType) this.pattern;
    }

    public boolean hasPatternDateType() { 
      return this != null && this.pattern instanceof DateType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public DateTimeType getPatternDateTimeType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new DateTimeType();
      if (!(this.pattern instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (DateTimeType) this.pattern;
    }

    public boolean hasPatternDateTimeType() { 
      return this != null && this.pattern instanceof DateTimeType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public DecimalType getPatternDecimalType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new DecimalType();
      if (!(this.pattern instanceof DecimalType))
        throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (DecimalType) this.pattern;
    }

    public boolean hasPatternDecimalType() { 
      return this != null && this.pattern instanceof DecimalType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public IdType getPatternIdType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new IdType();
      if (!(this.pattern instanceof IdType))
        throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (IdType) this.pattern;
    }

    public boolean hasPatternIdType() { 
      return this != null && this.pattern instanceof IdType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public InstantType getPatternInstantType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new InstantType();
      if (!(this.pattern instanceof InstantType))
        throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (InstantType) this.pattern;
    }

    public boolean hasPatternInstantType() { 
      return this != null && this.pattern instanceof InstantType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public IntegerType getPatternIntegerType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new IntegerType();
      if (!(this.pattern instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (IntegerType) this.pattern;
    }

    public boolean hasPatternIntegerType() { 
      return this != null && this.pattern instanceof IntegerType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Integer64Type getPatternInteger64Type() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Integer64Type();
      if (!(this.pattern instanceof Integer64Type))
        throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Integer64Type) this.pattern;
    }

    public boolean hasPatternInteger64Type() { 
      return this != null && this.pattern instanceof Integer64Type;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public MarkdownType getPatternMarkdownType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new MarkdownType();
      if (!(this.pattern instanceof MarkdownType))
        throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (MarkdownType) this.pattern;
    }

    public boolean hasPatternMarkdownType() { 
      return this != null && this.pattern instanceof MarkdownType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public OidType getPatternOidType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new OidType();
      if (!(this.pattern instanceof OidType))
        throw new FHIRException("Type mismatch: the type OidType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (OidType) this.pattern;
    }

    public boolean hasPatternOidType() { 
      return this != null && this.pattern instanceof OidType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public PositiveIntType getPatternPositiveIntType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new PositiveIntType();
      if (!(this.pattern instanceof PositiveIntType))
        throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (PositiveIntType) this.pattern;
    }

    public boolean hasPatternPositiveIntType() { 
      return this != null && this.pattern instanceof PositiveIntType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public StringType getPatternStringType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new StringType();
      if (!(this.pattern instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (StringType) this.pattern;
    }

    public boolean hasPatternStringType() { 
      return this != null && this.pattern instanceof StringType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public TimeType getPatternTimeType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new TimeType();
      if (!(this.pattern instanceof TimeType))
        throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (TimeType) this.pattern;
    }

    public boolean hasPatternTimeType() { 
      return this != null && this.pattern instanceof TimeType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public UnsignedIntType getPatternUnsignedIntType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new UnsignedIntType();
      if (!(this.pattern instanceof UnsignedIntType))
        throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (UnsignedIntType) this.pattern;
    }

    public boolean hasPatternUnsignedIntType() { 
      return this != null && this.pattern instanceof UnsignedIntType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public UriType getPatternUriType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new UriType();
      if (!(this.pattern instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (UriType) this.pattern;
    }

    public boolean hasPatternUriType() { 
      return this != null && this.pattern instanceof UriType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public UrlType getPatternUrlType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new UrlType();
      if (!(this.pattern instanceof UrlType))
        throw new FHIRException("Type mismatch: the type UrlType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (UrlType) this.pattern;
    }

    public boolean hasPatternUrlType() { 
      return this != null && this.pattern instanceof UrlType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public UuidType getPatternUuidType() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new UuidType();
      if (!(this.pattern instanceof UuidType))
        throw new FHIRException("Type mismatch: the type UuidType was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (UuidType) this.pattern;
    }

    public boolean hasPatternUuidType() { 
      return this != null && this.pattern instanceof UuidType;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Address getPatternAddress() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Address();
      if (!(this.pattern instanceof Address))
        throw new FHIRException("Type mismatch: the type Address was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Address) this.pattern;
    }

    public boolean hasPatternAddress() { 
      return this != null && this.pattern instanceof Address;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Age getPatternAge() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Age();
      if (!(this.pattern instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Age) this.pattern;
    }

    public boolean hasPatternAge() { 
      return this != null && this.pattern instanceof Age;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Annotation getPatternAnnotation() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Annotation();
      if (!(this.pattern instanceof Annotation))
        throw new FHIRException("Type mismatch: the type Annotation was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Annotation) this.pattern;
    }

    public boolean hasPatternAnnotation() { 
      return this != null && this.pattern instanceof Annotation;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Attachment getPatternAttachment() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Attachment();
      if (!(this.pattern instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Attachment) this.pattern;
    }

    public boolean hasPatternAttachment() { 
      return this != null && this.pattern instanceof Attachment;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public CodeableConcept getPatternCodeableConcept() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new CodeableConcept();
      if (!(this.pattern instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (CodeableConcept) this.pattern;
    }

    public boolean hasPatternCodeableConcept() { 
      return this != null && this.pattern instanceof CodeableConcept;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Coding getPatternCoding() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Coding();
      if (!(this.pattern instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Coding) this.pattern;
    }

    public boolean hasPatternCoding() { 
      return this != null && this.pattern instanceof Coding;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public ContactPoint getPatternContactPoint() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new ContactPoint();
      if (!(this.pattern instanceof ContactPoint))
        throw new FHIRException("Type mismatch: the type ContactPoint was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (ContactPoint) this.pattern;
    }

    public boolean hasPatternContactPoint() { 
      return this != null && this.pattern instanceof ContactPoint;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Count getPatternCount() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Count();
      if (!(this.pattern instanceof Count))
        throw new FHIRException("Type mismatch: the type Count was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Count) this.pattern;
    }

    public boolean hasPatternCount() { 
      return this != null && this.pattern instanceof Count;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Distance getPatternDistance() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Distance();
      if (!(this.pattern instanceof Distance))
        throw new FHIRException("Type mismatch: the type Distance was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Distance) this.pattern;
    }

    public boolean hasPatternDistance() { 
      return this != null && this.pattern instanceof Distance;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Duration getPatternDuration() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Duration();
      if (!(this.pattern instanceof Duration))
        throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Duration) this.pattern;
    }

    public boolean hasPatternDuration() { 
      return this != null && this.pattern instanceof Duration;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public HumanName getPatternHumanName() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new HumanName();
      if (!(this.pattern instanceof HumanName))
        throw new FHIRException("Type mismatch: the type HumanName was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (HumanName) this.pattern;
    }

    public boolean hasPatternHumanName() { 
      return this != null && this.pattern instanceof HumanName;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Identifier getPatternIdentifier() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Identifier();
      if (!(this.pattern instanceof Identifier))
        throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Identifier) this.pattern;
    }

    public boolean hasPatternIdentifier() { 
      return this != null && this.pattern instanceof Identifier;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Money getPatternMoney() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Money();
      if (!(this.pattern instanceof Money))
        throw new FHIRException("Type mismatch: the type Money was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Money) this.pattern;
    }

    public boolean hasPatternMoney() { 
      return this != null && this.pattern instanceof Money;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Period getPatternPeriod() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Period();
      if (!(this.pattern instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Period) this.pattern;
    }

    public boolean hasPatternPeriod() { 
      return this != null && this.pattern instanceof Period;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Quantity getPatternQuantity() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Quantity();
      if (!(this.pattern instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Quantity) this.pattern;
    }

    public boolean hasPatternQuantity() { 
      return this != null && this.pattern instanceof Quantity;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Range getPatternRange() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Range();
      if (!(this.pattern instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Range) this.pattern;
    }

    public boolean hasPatternRange() { 
      return this != null && this.pattern instanceof Range;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Ratio getPatternRatio() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Ratio();
      if (!(this.pattern instanceof Ratio))
        throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Ratio) this.pattern;
    }

    public boolean hasPatternRatio() { 
      return this != null && this.pattern instanceof Ratio;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Reference getPatternReference() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Reference();
      if (!(this.pattern instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Reference) this.pattern;
    }

    public boolean hasPatternReference() { 
      return this != null && this.pattern instanceof Reference;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public SampledData getPatternSampledData() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new SampledData();
      if (!(this.pattern instanceof SampledData))
        throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (SampledData) this.pattern;
    }

    public boolean hasPatternSampledData() { 
      return this != null && this.pattern instanceof SampledData;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Signature getPatternSignature() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Signature();
      if (!(this.pattern instanceof Signature))
        throw new FHIRException("Type mismatch: the type Signature was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Signature) this.pattern;
    }

    public boolean hasPatternSignature() { 
      return this != null && this.pattern instanceof Signature;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Timing getPatternTiming() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Timing();
      if (!(this.pattern instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Timing) this.pattern;
    }

    public boolean hasPatternTiming() { 
      return this != null && this.pattern instanceof Timing;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public ContactDetail getPatternContactDetail() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new ContactDetail();
      if (!(this.pattern instanceof ContactDetail))
        throw new FHIRException("Type mismatch: the type ContactDetail was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (ContactDetail) this.pattern;
    }

    public boolean hasPatternContactDetail() { 
      return this != null && this.pattern instanceof ContactDetail;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Contributor getPatternContributor() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Contributor();
      if (!(this.pattern instanceof Contributor))
        throw new FHIRException("Type mismatch: the type Contributor was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Contributor) this.pattern;
    }

    public boolean hasPatternContributor() { 
      return this != null && this.pattern instanceof Contributor;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public DataRequirement getPatternDataRequirement() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new DataRequirement();
      if (!(this.pattern instanceof DataRequirement))
        throw new FHIRException("Type mismatch: the type DataRequirement was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (DataRequirement) this.pattern;
    }

    public boolean hasPatternDataRequirement() { 
      return this != null && this.pattern instanceof DataRequirement;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Expression getPatternExpression() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Expression();
      if (!(this.pattern instanceof Expression))
        throw new FHIRException("Type mismatch: the type Expression was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Expression) this.pattern;
    }

    public boolean hasPatternExpression() { 
      return this != null && this.pattern instanceof Expression;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public ParameterDefinition getPatternParameterDefinition() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new ParameterDefinition();
      if (!(this.pattern instanceof ParameterDefinition))
        throw new FHIRException("Type mismatch: the type ParameterDefinition was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (ParameterDefinition) this.pattern;
    }

    public boolean hasPatternParameterDefinition() { 
      return this != null && this.pattern instanceof ParameterDefinition;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public RelatedArtifact getPatternRelatedArtifact() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new RelatedArtifact();
      if (!(this.pattern instanceof RelatedArtifact))
        throw new FHIRException("Type mismatch: the type RelatedArtifact was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (RelatedArtifact) this.pattern;
    }

    public boolean hasPatternRelatedArtifact() { 
      return this != null && this.pattern instanceof RelatedArtifact;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public TriggerDefinition getPatternTriggerDefinition() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new TriggerDefinition();
      if (!(this.pattern instanceof TriggerDefinition))
        throw new FHIRException("Type mismatch: the type TriggerDefinition was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (TriggerDefinition) this.pattern;
    }

    public boolean hasPatternTriggerDefinition() { 
      return this != null && this.pattern instanceof TriggerDefinition;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public UsageContext getPatternUsageContext() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new UsageContext();
      if (!(this.pattern instanceof UsageContext))
        throw new FHIRException("Type mismatch: the type UsageContext was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (UsageContext) this.pattern;
    }

    public boolean hasPatternUsageContext() { 
      return this != null && this.pattern instanceof UsageContext;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Dosage getPatternDosage() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Dosage();
      if (!(this.pattern instanceof Dosage))
        throw new FHIRException("Type mismatch: the type Dosage was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Dosage) this.pattern;
    }

    public boolean hasPatternDosage() { 
      return this != null && this.pattern instanceof Dosage;
    }

    /**
     * @return {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public Meta getPatternMeta() throws FHIRException { 
      if (this.pattern == null)
        this.pattern = new Meta();
      if (!(this.pattern instanceof Meta))
        throw new FHIRException("Type mismatch: the type Meta was expected, but "+this.pattern.getClass().getName()+" was encountered");
      return (Meta) this.pattern;
    }

    public boolean hasPatternMeta() { 
      return this != null && this.pattern instanceof Meta;
    }

    public boolean hasPattern() { 
      return this.pattern != null && !this.pattern.isEmpty();
    }

    /**
     * @param value {@link #pattern} (Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  

When pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.

When pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.

When pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,

1. If primitive: it must match exactly the pattern value
2. If a complex object: it must match (recursively) the pattern value
3. If an array: it must match (recursively) the pattern value.)
     */
    public ElementDefinition setPattern(DataType value) { 
      if (value != null && !(value instanceof Base64BinaryType || value instanceof BooleanType || value instanceof CanonicalType || value instanceof CodeType || value instanceof DateType || value instanceof DateTimeType || value instanceof DecimalType || value instanceof IdType || value instanceof InstantType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof MarkdownType || value instanceof OidType || value instanceof PositiveIntType || value instanceof StringType || value instanceof TimeType || value instanceof UnsignedIntType || value instanceof UriType || value instanceof UrlType || value instanceof UuidType || value instanceof Address || value instanceof Age || value instanceof Annotation || value instanceof Attachment || value instanceof CodeableConcept || value instanceof Coding || value instanceof ContactPoint || value instanceof Count || value instanceof Distance || value instanceof Duration || value instanceof HumanName || value instanceof Identifier || value instanceof Money || value instanceof Period || value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof Reference || value instanceof SampledData || value instanceof Signature || value instanceof Timing || value instanceof ContactDetail || value instanceof Contributor || value instanceof DataRequirement || value instanceof Expression || value instanceof ParameterDefinition || value instanceof RelatedArtifact || value instanceof TriggerDefinition || value instanceof UsageContext || value instanceof Dosage || value instanceof Meta))
        throw new Error("Not the right type for ElementDefinition.pattern[x]: "+value.fhirType());
      this.pattern = value;
      return this;
    }

    /**
     * @return {@link #example} (A sample value for this element demonstrating the type of information that would typically be found in the element.)
     */
    public List<ElementDefinitionExampleComponent> getExample() { 
      if (this.example == null)
        this.example = new ArrayList<ElementDefinitionExampleComponent>();
      return this.example;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setExample(List<ElementDefinitionExampleComponent> theExample) { 
      this.example = theExample;
      return this;
    }

    public boolean hasExample() { 
      if (this.example == null)
        return false;
      for (ElementDefinitionExampleComponent item : this.example)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ElementDefinitionExampleComponent addExample() { //3
      ElementDefinitionExampleComponent t = new ElementDefinitionExampleComponent();
      if (this.example == null)
        this.example = new ArrayList<ElementDefinitionExampleComponent>();
      this.example.add(t);
      return t;
    }

    public ElementDefinition addExample(ElementDefinitionExampleComponent t) { //3
      if (t == null)
        return this;
      if (this.example == null)
        this.example = new ArrayList<ElementDefinitionExampleComponent>();
      this.example.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #example}, creating it if it does not already exist {3}
     */
    public ElementDefinitionExampleComponent getExampleFirstRep() { 
      if (getExample().isEmpty()) {
        addExample();
      }
      return getExample().get(0);
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DataType getMinValue() { 
      return this.minValue;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DateType getMinValueDateType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new DateType();
      if (!(this.minValue instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (DateType) this.minValue;
    }

    public boolean hasMinValueDateType() { 
      return this != null && this.minValue instanceof DateType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DateTimeType getMinValueDateTimeType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new DateTimeType();
      if (!(this.minValue instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (DateTimeType) this.minValue;
    }

    public boolean hasMinValueDateTimeType() { 
      return this != null && this.minValue instanceof DateTimeType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public InstantType getMinValueInstantType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new InstantType();
      if (!(this.minValue instanceof InstantType))
        throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (InstantType) this.minValue;
    }

    public boolean hasMinValueInstantType() { 
      return this != null && this.minValue instanceof InstantType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public TimeType getMinValueTimeType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new TimeType();
      if (!(this.minValue instanceof TimeType))
        throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (TimeType) this.minValue;
    }

    public boolean hasMinValueTimeType() { 
      return this != null && this.minValue instanceof TimeType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DecimalType getMinValueDecimalType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new DecimalType();
      if (!(this.minValue instanceof DecimalType))
        throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (DecimalType) this.minValue;
    }

    public boolean hasMinValueDecimalType() { 
      return this != null && this.minValue instanceof DecimalType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public IntegerType getMinValueIntegerType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new IntegerType();
      if (!(this.minValue instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (IntegerType) this.minValue;
    }

    public boolean hasMinValueIntegerType() { 
      return this != null && this.minValue instanceof IntegerType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public Integer64Type getMinValueInteger64Type() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new Integer64Type();
      if (!(this.minValue instanceof Integer64Type))
        throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (Integer64Type) this.minValue;
    }

    public boolean hasMinValueInteger64Type() { 
      return this != null && this.minValue instanceof Integer64Type;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public PositiveIntType getMinValuePositiveIntType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new PositiveIntType();
      if (!(this.minValue instanceof PositiveIntType))
        throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (PositiveIntType) this.minValue;
    }

    public boolean hasMinValuePositiveIntType() { 
      return this != null && this.minValue instanceof PositiveIntType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public UnsignedIntType getMinValueUnsignedIntType() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new UnsignedIntType();
      if (!(this.minValue instanceof UnsignedIntType))
        throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (UnsignedIntType) this.minValue;
    }

    public boolean hasMinValueUnsignedIntType() { 
      return this != null && this.minValue instanceof UnsignedIntType;
    }

    /**
     * @return {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public Quantity getMinValueQuantity() throws FHIRException { 
      if (this.minValue == null)
        this.minValue = new Quantity();
      if (!(this.minValue instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.minValue.getClass().getName()+" was encountered");
      return (Quantity) this.minValue;
    }

    public boolean hasMinValueQuantity() { 
      return this != null && this.minValue instanceof Quantity;
    }

    public boolean hasMinValue() { 
      return this.minValue != null && !this.minValue.isEmpty();
    }

    /**
     * @param value {@link #minValue} (The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public ElementDefinition setMinValue(DataType value) { 
      if (value != null && !(value instanceof DateType || value instanceof DateTimeType || value instanceof InstantType || value instanceof TimeType || value instanceof DecimalType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof PositiveIntType || value instanceof UnsignedIntType || value instanceof Quantity))
        throw new Error("Not the right type for ElementDefinition.minValue[x]: "+value.fhirType());
      this.minValue = value;
      return this;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DataType getMaxValue() { 
      return this.maxValue;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DateType getMaxValueDateType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new DateType();
      if (!(this.maxValue instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (DateType) this.maxValue;
    }

    public boolean hasMaxValueDateType() { 
      return this != null && this.maxValue instanceof DateType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DateTimeType getMaxValueDateTimeType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new DateTimeType();
      if (!(this.maxValue instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (DateTimeType) this.maxValue;
    }

    public boolean hasMaxValueDateTimeType() { 
      return this != null && this.maxValue instanceof DateTimeType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public InstantType getMaxValueInstantType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new InstantType();
      if (!(this.maxValue instanceof InstantType))
        throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (InstantType) this.maxValue;
    }

    public boolean hasMaxValueInstantType() { 
      return this != null && this.maxValue instanceof InstantType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public TimeType getMaxValueTimeType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new TimeType();
      if (!(this.maxValue instanceof TimeType))
        throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (TimeType) this.maxValue;
    }

    public boolean hasMaxValueTimeType() { 
      return this != null && this.maxValue instanceof TimeType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public DecimalType getMaxValueDecimalType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new DecimalType();
      if (!(this.maxValue instanceof DecimalType))
        throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (DecimalType) this.maxValue;
    }

    public boolean hasMaxValueDecimalType() { 
      return this != null && this.maxValue instanceof DecimalType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public IntegerType getMaxValueIntegerType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new IntegerType();
      if (!(this.maxValue instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (IntegerType) this.maxValue;
    }

    public boolean hasMaxValueIntegerType() { 
      return this != null && this.maxValue instanceof IntegerType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public Integer64Type getMaxValueInteger64Type() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new Integer64Type();
      if (!(this.maxValue instanceof Integer64Type))
        throw new FHIRException("Type mismatch: the type Integer64Type was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (Integer64Type) this.maxValue;
    }

    public boolean hasMaxValueInteger64Type() { 
      return this != null && this.maxValue instanceof Integer64Type;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public PositiveIntType getMaxValuePositiveIntType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new PositiveIntType();
      if (!(this.maxValue instanceof PositiveIntType))
        throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (PositiveIntType) this.maxValue;
    }

    public boolean hasMaxValuePositiveIntType() { 
      return this != null && this.maxValue instanceof PositiveIntType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public UnsignedIntType getMaxValueUnsignedIntType() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new UnsignedIntType();
      if (!(this.maxValue instanceof UnsignedIntType))
        throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (UnsignedIntType) this.maxValue;
    }

    public boolean hasMaxValueUnsignedIntType() { 
      return this != null && this.maxValue instanceof UnsignedIntType;
    }

    /**
     * @return {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public Quantity getMaxValueQuantity() throws FHIRException { 
      if (this.maxValue == null)
        this.maxValue = new Quantity();
      if (!(this.maxValue instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.maxValue.getClass().getName()+" was encountered");
      return (Quantity) this.maxValue;
    }

    public boolean hasMaxValueQuantity() { 
      return this != null && this.maxValue instanceof Quantity;
    }

    public boolean hasMaxValue() { 
      return this.maxValue != null && !this.maxValue.isEmpty();
    }

    /**
     * @param value {@link #maxValue} (The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.)
     */
    public ElementDefinition setMaxValue(DataType value) { 
      if (value != null && !(value instanceof DateType || value instanceof DateTimeType || value instanceof InstantType || value instanceof TimeType || value instanceof DecimalType || value instanceof IntegerType || value instanceof Integer64Type || value instanceof PositiveIntType || value instanceof UnsignedIntType || value instanceof Quantity))
        throw new Error("Not the right type for ElementDefinition.maxValue[x]: "+value.fhirType());
      this.maxValue = value;
      return this;
    }

    /**
     * @return {@link #maxLength} (Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.). This is the underlying object with id, value and extensions. The accessor "getMaxLength" gives direct access to the value
     */
    public IntegerType getMaxLengthElement() { 
      if (this.maxLength == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.maxLength");
        else if (Configuration.doAutoCreate())
          this.maxLength = new IntegerType(); // bb
      return this.maxLength;
    }

    public boolean hasMaxLengthElement() { 
      return this.maxLength != null && !this.maxLength.isEmpty();
    }

    public boolean hasMaxLength() { 
      return this.maxLength != null && !this.maxLength.isEmpty();
    }

    /**
     * @param value {@link #maxLength} (Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.). This is the underlying object with id, value and extensions. The accessor "getMaxLength" gives direct access to the value
     */
    public ElementDefinition setMaxLengthElement(IntegerType value) { 
      this.maxLength = value;
      return this;
    }

    /**
     * @return Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.
     */
    public int getMaxLength() { 
      return this.maxLength == null || this.maxLength.isEmpty() ? 0 : this.maxLength.getValue();
    }

    /**
     * @param value Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.
     */
    public ElementDefinition setMaxLength(int value) { 
        if (this.maxLength == null)
          this.maxLength = new IntegerType();
        this.maxLength.setValue(value);
      return this;
    }

    /**
     * @return {@link #condition} (A reference to an invariant that may make additional statements about the cardinality or value in the instance.)
     */
    public List<IdType> getCondition() { 
      if (this.condition == null)
        this.condition = new ArrayList<IdType>();
      return this.condition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setCondition(List<IdType> theCondition) { 
      this.condition = theCondition;
      return this;
    }

    public boolean hasCondition() { 
      if (this.condition == null)
        return false;
      for (IdType item : this.condition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #condition} (A reference to an invariant that may make additional statements about the cardinality or value in the instance.)
     */
    public IdType addConditionElement() {//2 
      IdType t = new IdType();
      if (this.condition == null)
        this.condition = new ArrayList<IdType>();
      this.condition.add(t);
      return t;
    }

    /**
     * @param value {@link #condition} (A reference to an invariant that may make additional statements about the cardinality or value in the instance.)
     */
    public ElementDefinition addCondition(String value) { //1
      IdType t = new IdType();
      t.setValue(value);
      if (this.condition == null)
        this.condition = new ArrayList<IdType>();
      this.condition.add(t);
      return this;
    }

    /**
     * @param value {@link #condition} (A reference to an invariant that may make additional statements about the cardinality or value in the instance.)
     */
    public boolean hasCondition(String value) { 
      if (this.condition == null)
        return false;
      for (IdType v : this.condition)
        if (v.getValue().equals(value)) // id
          return true;
      return false;
    }

    /**
     * @return {@link #constraint} (Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the context of the instance.)
     */
    public List<ElementDefinitionConstraintComponent> getConstraint() { 
      if (this.constraint == null)
        this.constraint = new ArrayList<ElementDefinitionConstraintComponent>();
      return this.constraint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setConstraint(List<ElementDefinitionConstraintComponent> theConstraint) { 
      this.constraint = theConstraint;
      return this;
    }

    public boolean hasConstraint() { 
      if (this.constraint == null)
        return false;
      for (ElementDefinitionConstraintComponent item : this.constraint)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ElementDefinitionConstraintComponent addConstraint() { //3
      ElementDefinitionConstraintComponent t = new ElementDefinitionConstraintComponent();
      if (this.constraint == null)
        this.constraint = new ArrayList<ElementDefinitionConstraintComponent>();
      this.constraint.add(t);
      return t;
    }

    public ElementDefinition addConstraint(ElementDefinitionConstraintComponent t) { //3
      if (t == null)
        return this;
      if (this.constraint == null)
        this.constraint = new ArrayList<ElementDefinitionConstraintComponent>();
      this.constraint.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #constraint}, creating it if it does not already exist {3}
     */
    public ElementDefinitionConstraintComponent getConstraintFirstRep() { 
      if (getConstraint().isEmpty()) {
        addConstraint();
      }
      return getConstraint().get(0);
    }

    /**
     * @return {@link #mustSupport} (If true, implementations that produce or consume resources SHALL provide "support" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.). This is the underlying object with id, value and extensions. The accessor "getMustSupport" gives direct access to the value
     */
    public BooleanType getMustSupportElement() { 
      if (this.mustSupport == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.mustSupport");
        else if (Configuration.doAutoCreate())
          this.mustSupport = new BooleanType(); // bb
      return this.mustSupport;
    }

    public boolean hasMustSupportElement() { 
      return this.mustSupport != null && !this.mustSupport.isEmpty();
    }

    public boolean hasMustSupport() { 
      return this.mustSupport != null && !this.mustSupport.isEmpty();
    }

    /**
     * @param value {@link #mustSupport} (If true, implementations that produce or consume resources SHALL provide "support" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.). This is the underlying object with id, value and extensions. The accessor "getMustSupport" gives direct access to the value
     */
    public ElementDefinition setMustSupportElement(BooleanType value) { 
      this.mustSupport = value;
      return this;
    }

    /**
     * @return If true, implementations that produce or consume resources SHALL provide "support" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.
     */
    public boolean getMustSupport() { 
      return this.mustSupport == null || this.mustSupport.isEmpty() ? false : this.mustSupport.getValue();
    }

    /**
     * @param value If true, implementations that produce or consume resources SHALL provide "support" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.
     */
    public ElementDefinition setMustSupport(boolean value) { 
        if (this.mustSupport == null)
          this.mustSupport = new BooleanType();
        this.mustSupport.setValue(value);
      return this;
    }

    /**
     * @return {@link #isModifier} (If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.). This is the underlying object with id, value and extensions. The accessor "getIsModifier" gives direct access to the value
     */
    public BooleanType getIsModifierElement() { 
      if (this.isModifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.isModifier");
        else if (Configuration.doAutoCreate())
          this.isModifier = new BooleanType(); // bb
      return this.isModifier;
    }

    public boolean hasIsModifierElement() { 
      return this.isModifier != null && !this.isModifier.isEmpty();
    }

    public boolean hasIsModifier() { 
      return this.isModifier != null && !this.isModifier.isEmpty();
    }

    /**
     * @param value {@link #isModifier} (If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.). This is the underlying object with id, value and extensions. The accessor "getIsModifier" gives direct access to the value
     */
    public ElementDefinition setIsModifierElement(BooleanType value) { 
      this.isModifier = value;
      return this;
    }

    /**
     * @return If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.
     */
    public boolean getIsModifier() { 
      return this.isModifier == null || this.isModifier.isEmpty() ? false : this.isModifier.getValue();
    }

    /**
     * @param value If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.
     */
    public ElementDefinition setIsModifier(boolean value) { 
        if (this.isModifier == null)
          this.isModifier = new BooleanType();
        this.isModifier.setValue(value);
      return this;
    }

    /**
     * @return {@link #isModifierReason} (Explains how that element affects the interpretation of the resource or element that contains it.). This is the underlying object with id, value and extensions. The accessor "getIsModifierReason" gives direct access to the value
     */
    public StringType getIsModifierReasonElement() { 
      if (this.isModifierReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.isModifierReason");
        else if (Configuration.doAutoCreate())
          this.isModifierReason = new StringType(); // bb
      return this.isModifierReason;
    }

    public boolean hasIsModifierReasonElement() { 
      return this.isModifierReason != null && !this.isModifierReason.isEmpty();
    }

    public boolean hasIsModifierReason() { 
      return this.isModifierReason != null && !this.isModifierReason.isEmpty();
    }

    /**
     * @param value {@link #isModifierReason} (Explains how that element affects the interpretation of the resource or element that contains it.). This is the underlying object with id, value and extensions. The accessor "getIsModifierReason" gives direct access to the value
     */
    public ElementDefinition setIsModifierReasonElement(StringType value) { 
      this.isModifierReason = value;
      return this;
    }

    /**
     * @return Explains how that element affects the interpretation of the resource or element that contains it.
     */
    public String getIsModifierReason() { 
      return this.isModifierReason == null ? null : this.isModifierReason.getValue();
    }

    /**
     * @param value Explains how that element affects the interpretation of the resource or element that contains it.
     */
    public ElementDefinition setIsModifierReason(String value) { 
      if (Utilities.noString(value))
        this.isModifierReason = null;
      else {
        if (this.isModifierReason == null)
          this.isModifierReason = new StringType();
        this.isModifierReason.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #isSummary} (Whether the element should be included if a client requests a search with the parameter _summary=true.). This is the underlying object with id, value and extensions. The accessor "getIsSummary" gives direct access to the value
     */
    public BooleanType getIsSummaryElement() { 
      if (this.isSummary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.isSummary");
        else if (Configuration.doAutoCreate())
          this.isSummary = new BooleanType(); // bb
      return this.isSummary;
    }

    public boolean hasIsSummaryElement() { 
      return this.isSummary != null && !this.isSummary.isEmpty();
    }

    public boolean hasIsSummary() { 
      return this.isSummary != null && !this.isSummary.isEmpty();
    }

    /**
     * @param value {@link #isSummary} (Whether the element should be included if a client requests a search with the parameter _summary=true.). This is the underlying object with id, value and extensions. The accessor "getIsSummary" gives direct access to the value
     */
    public ElementDefinition setIsSummaryElement(BooleanType value) { 
      this.isSummary = value;
      return this;
    }

    /**
     * @return Whether the element should be included if a client requests a search with the parameter _summary=true.
     */
    public boolean getIsSummary() { 
      return this.isSummary == null || this.isSummary.isEmpty() ? false : this.isSummary.getValue();
    }

    /**
     * @param value Whether the element should be included if a client requests a search with the parameter _summary=true.
     */
    public ElementDefinition setIsSummary(boolean value) { 
        if (this.isSummary == null)
          this.isSummary = new BooleanType();
        this.isSummary.setValue(value);
      return this;
    }

    /**
     * @return {@link #binding} (Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types (string, uri).)
     */
    public ElementDefinitionBindingComponent getBinding() { 
      if (this.binding == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ElementDefinition.binding");
        else if (Configuration.doAutoCreate())
          this.binding = new ElementDefinitionBindingComponent(); // cc
      return this.binding;
    }

    public boolean hasBinding() { 
      return this.binding != null && !this.binding.isEmpty();
    }

    /**
     * @param value {@link #binding} (Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types (string, uri).)
     */
    public ElementDefinition setBinding(ElementDefinitionBindingComponent value) { 
      this.binding = value;
      return this;
    }

    /**
     * @return {@link #mapping} (Identifies a concept from an external specification that roughly corresponds to this element.)
     */
    public List<ElementDefinitionMappingComponent> getMapping() { 
      if (this.mapping == null)
        this.mapping = new ArrayList<ElementDefinitionMappingComponent>();
      return this.mapping;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ElementDefinition setMapping(List<ElementDefinitionMappingComponent> theMapping) { 
      this.mapping = theMapping;
      return this;
    }

    public boolean hasMapping() { 
      if (this.mapping == null)
        return false;
      for (ElementDefinitionMappingComponent item : this.mapping)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ElementDefinitionMappingComponent addMapping() { //3
      ElementDefinitionMappingComponent t = new ElementDefinitionMappingComponent();
      if (this.mapping == null)
        this.mapping = new ArrayList<ElementDefinitionMappingComponent>();
      this.mapping.add(t);
      return t;
    }

    public ElementDefinition addMapping(ElementDefinitionMappingComponent t) { //3
      if (t == null)
        return this;
      if (this.mapping == null)
        this.mapping = new ArrayList<ElementDefinitionMappingComponent>();
      this.mapping.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #mapping}, creating it if it does not already exist {3}
     */
    public ElementDefinitionMappingComponent getMappingFirstRep() { 
      if (getMapping().isEmpty()) {
        addMapping();
      }
      return getMapping().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("path", "string", "The path identifies the element and is expressed as a \".\"-separated list of ancestor elements, beginning with the name of the resource or extension.", 0, 1, path));
        children.add(new Property("representation", "code", "Codes that define how this element is represented in instances, when the deviation varies from the normal case.", 0, java.lang.Integer.MAX_VALUE, representation));
        children.add(new Property("sliceName", "string", "The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.", 0, 1, sliceName));
        children.add(new Property("sliceIsConstraining", "boolean", "If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.", 0, 1, sliceIsConstraining));
        children.add(new Property("label", "string", "A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.", 0, 1, label));
        children.add(new Property("code", "Coding", "A code that has the same meaning as the element in a particular terminology.", 0, java.lang.Integer.MAX_VALUE, code));
        children.add(new Property("slicing", "", "Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition, there are multiple different constraints on a single element in the base resource). Slicing can be used in any resource that has cardinality ..* on the base resource, or any resource with a choice of types. The set of slices is any elements that come after this in the element sequence that have the same path, until a shorter path occurs (the shorter path terminates the set).", 0, 1, slicing));
        children.add(new Property("short", "string", "A concise description of what this element means (e.g. for use in autogenerated summaries).", 0, 1, short_));
        children.add(new Property("definition", "markdown", "Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).", 0, 1, definition));
        children.add(new Property("comment", "markdown", "Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).", 0, 1, comment));
        children.add(new Property("requirements", "markdown", "This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.", 0, 1, requirements));
        children.add(new Property("alias", "string", "Identifies additional names by which this element might also be known.", 0, java.lang.Integer.MAX_VALUE, alias));
        children.add(new Property("min", "unsignedInt", "The minimum number of times this element SHALL appear in the instance.", 0, 1, min));
        children.add(new Property("max", "string", "The maximum number of times this element is permitted to appear in the instance.", 0, 1, max));
        children.add(new Property("base", "", "Information about the base definition of the element, provided to make it unnecessary for tools to trace the deviation of the element through the derived and related profiles. When the element definition is not the original definition of an element - i.g. either in a constraint on another type, or for elements from a super type in a snap shot - then the information in provided in the element definition may be different to the base definition. On the original definition of the element, it will be same.", 0, 1, base));
        children.add(new Property("contentReference", "uri", "Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.", 0, 1, contentReference));
        children.add(new Property("type", "", "The data type or resource that the value of this element is permitted to be.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("defaultValue[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue));
        children.add(new Property("meaningWhenMissing", "markdown", "The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').", 0, 1, meaningWhenMissing));
        children.add(new Property("orderMeaning", "string", "If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.", 0, 1, orderMeaning));
        children.add(new Property("fixed[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed));
        children.add(new Property("pattern[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern));
        children.add(new Property("example", "", "A sample value for this element demonstrating the type of information that would typically be found in the element.", 0, java.lang.Integer.MAX_VALUE, example));
        children.add(new Property("minValue[x]", "date|dateTime|instant|time|decimal|integer|integer64|positiveInt|unsignedInt|Quantity", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue));
        children.add(new Property("maxValue[x]", "date|dateTime|instant|time|decimal|integer|integer64|positiveInt|unsignedInt|Quantity", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue));
        children.add(new Property("maxLength", "integer", "Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.", 0, 1, maxLength));
        children.add(new Property("condition", "id", "A reference to an invariant that may make additional statements about the cardinality or value in the instance.", 0, java.lang.Integer.MAX_VALUE, condition));
        children.add(new Property("constraint", "", "Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the context of the instance.", 0, java.lang.Integer.MAX_VALUE, constraint));
        children.add(new Property("mustSupport", "boolean", "If true, implementations that produce or consume resources SHALL provide \"support\" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.", 0, 1, mustSupport));
        children.add(new Property("isModifier", "boolean", "If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.", 0, 1, isModifier));
        children.add(new Property("isModifierReason", "string", "Explains how that element affects the interpretation of the resource or element that contains it.", 0, 1, isModifierReason));
        children.add(new Property("isSummary", "boolean", "Whether the element should be included if a client requests a search with the parameter _summary=true.", 0, 1, isSummary));
        children.add(new Property("binding", "", "Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types (string, uri).", 0, 1, binding));
        children.add(new Property("mapping", "", "Identifies a concept from an external specification that roughly corresponds to this element.", 0, java.lang.Integer.MAX_VALUE, mapping));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3433509: /*path*/  return new Property("path", "string", "The path identifies the element and is expressed as a \".\"-separated list of ancestor elements, beginning with the name of the resource or extension.", 0, 1, path);
        case -671065907: /*representation*/  return new Property("representation", "code", "Codes that define how this element is represented in instances, when the deviation varies from the normal case.", 0, java.lang.Integer.MAX_VALUE, representation);
        case -825289923: /*sliceName*/  return new Property("sliceName", "string", "The name of this element definition slice, when slicing is working. The name must be a token with no dots or spaces. This is a unique name referring to a specific set of constraints applied to this element, used to provide a name to different slices of the same element.", 0, 1, sliceName);
        case 333040519: /*sliceIsConstraining*/  return new Property("sliceIsConstraining", "boolean", "If true, indicates that this slice definition is constraining a slice definition with the same name in an inherited profile. If false, the slice is not overriding any slice in an inherited profile. If missing, the slice might or might not be overriding a slice in an inherited profile, depending on the sliceName.", 0, 1, sliceIsConstraining);
        case 102727412: /*label*/  return new Property("label", "string", "A single preferred label which is the text to display beside the element indicating its meaning or to use to prompt for the element in a user display or form.", 0, 1, label);
        case 3059181: /*code*/  return new Property("code", "Coding", "A code that has the same meaning as the element in a particular terminology.", 0, java.lang.Integer.MAX_VALUE, code);
        case -2119287345: /*slicing*/  return new Property("slicing", "", "Indicates that the element is sliced into a set of alternative definitions (i.e. in a structure definition, there are multiple different constraints on a single element in the base resource). Slicing can be used in any resource that has cardinality ..* on the base resource, or any resource with a choice of types. The set of slices is any elements that come after this in the element sequence that have the same path, until a shorter path occurs (the shorter path terminates the set).", 0, 1, slicing);
        case 109413500: /*short*/  return new Property("short", "string", "A concise description of what this element means (e.g. for use in autogenerated summaries).", 0, 1, short_);
        case -1014418093: /*definition*/  return new Property("definition", "markdown", "Provides a complete explanation of the meaning of the data element for human readability.  For the case of elements derived from existing elements (e.g. constraints), the definition SHALL be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource. (Note: The text you are reading is specified in ElementDefinition.definition).", 0, 1, definition);
        case 950398559: /*comment*/  return new Property("comment", "markdown", "Explanatory notes and implementation guidance about the data element, including notes about how to use the data properly, exceptions to proper use, etc. (Note: The text you are reading is specified in ElementDefinition.comment).", 0, 1, comment);
        case -1619874672: /*requirements*/  return new Property("requirements", "markdown", "This element is for traceability of why the element was created and why the constraints exist as they do. This may be used to point to source materials or specifications that drove the structure of this element.", 0, 1, requirements);
        case 92902992: /*alias*/  return new Property("alias", "string", "Identifies additional names by which this element might also be known.", 0, java.lang.Integer.MAX_VALUE, alias);
        case 108114: /*min*/  return new Property("min", "unsignedInt", "The minimum number of times this element SHALL appear in the instance.", 0, 1, min);
        case 107876: /*max*/  return new Property("max", "string", "The maximum number of times this element is permitted to appear in the instance.", 0, 1, max);
        case 3016401: /*base*/  return new Property("base", "", "Information about the base definition of the element, provided to make it unnecessary for tools to trace the deviation of the element through the derived and related profiles. When the element definition is not the original definition of an element - i.g. either in a constraint on another type, or for elements from a super type in a snap shot - then the information in provided in the element definition may be different to the base definition. On the original definition of the element, it will be same.", 0, 1, base);
        case 1193747154: /*contentReference*/  return new Property("contentReference", "uri", "Identifies an element defined elsewhere in the definition whose content rules should be applied to the current element. ContentReferences bring across all the rules that are in the ElementDefinition for the element, including definitions, cardinality constraints, bindings, invariants etc.", 0, 1, contentReference);
        case 3575610: /*type*/  return new Property("type", "", "The data type or resource that the value of this element is permitted to be.", 0, java.lang.Integer.MAX_VALUE, type);
        case 587922128: /*defaultValue[x]*/  return new Property("defaultValue[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -659125328: /*defaultValue*/  return new Property("defaultValue[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1470297600: /*defaultValueBase64Binary*/  return new Property("defaultValue[x]", "base64Binary", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 600437336: /*defaultValueBoolean*/  return new Property("defaultValue[x]", "boolean", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 264593188: /*defaultValueCanonical*/  return new Property("defaultValue[x]", "canonical", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1044993469: /*defaultValueCode*/  return new Property("defaultValue[x]", "code", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1045010302: /*defaultValueDate*/  return new Property("defaultValue[x]", "date", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1220374379: /*defaultValueDateTime*/  return new Property("defaultValue[x]", "dateTime", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 2077989249: /*defaultValueDecimal*/  return new Property("defaultValue[x]", "decimal", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -2059245333: /*defaultValueId*/  return new Property("defaultValue[x]", "id", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1801671663: /*defaultValueInstant*/  return new Property("defaultValue[x]", "instant", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1801189522: /*defaultValueInteger*/  return new Property("defaultValue[x]", "integer", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -71308628: /*defaultValueInteger64*/  return new Property("defaultValue[x]", "integer64", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -325436225: /*defaultValueMarkdown*/  return new Property("defaultValue[x]", "markdown", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 587910138: /*defaultValueOid*/  return new Property("defaultValue[x]", "oid", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -737344154: /*defaultValuePositiveInt*/  return new Property("defaultValue[x]", "positiveInt", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -320515103: /*defaultValueString*/  return new Property("defaultValue[x]", "string", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1045494429: /*defaultValueTime*/  return new Property("defaultValue[x]", "time", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 539117290: /*defaultValueUnsignedInt*/  return new Property("defaultValue[x]", "unsignedInt", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 587916188: /*defaultValueUri*/  return new Property("defaultValue[x]", "uri", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 587916191: /*defaultValueUrl*/  return new Property("defaultValue[x]", "url", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1045535627: /*defaultValueUuid*/  return new Property("defaultValue[x]", "uuid", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -611966428: /*defaultValueAddress*/  return new Property("defaultValue[x]", "Address", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 587896623: /*defaultValueAge*/  return new Property("defaultValue[x]", "Age", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1851689217: /*defaultValueAnnotation*/  return new Property("defaultValue[x]", "Annotation", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 2034820339: /*defaultValueAttachment*/  return new Property("defaultValue[x]", "Attachment", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -410434095: /*defaultValueCodeableConcept*/  return new Property("defaultValue[x]", "CodeableConcept", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -783616198: /*defaultValueCoding*/  return new Property("defaultValue[x]", "Coding", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -344740576: /*defaultValueContactPoint*/  return new Property("defaultValue[x]", "ContactPoint", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1964924097: /*defaultValueCount*/  return new Property("defaultValue[x]", "Count", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -283915323: /*defaultValueDistance*/  return new Property("defaultValue[x]", "Distance", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1730579812: /*defaultValueDuration*/  return new Property("defaultValue[x]", "Duration", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -975393912: /*defaultValueHumanName*/  return new Property("defaultValue[x]", "HumanName", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1915078535: /*defaultValueIdentifier*/  return new Property("defaultValue[x]", "Identifier", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1955695888: /*defaultValueMoney*/  return new Property("defaultValue[x]", "Money", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -420255343: /*defaultValuePeriod*/  return new Property("defaultValue[x]", "Period", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1857379237: /*defaultValueQuantity*/  return new Property("defaultValue[x]", "Quantity", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1951495315: /*defaultValueRange*/  return new Property("defaultValue[x]", "Range", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1951489477: /*defaultValueRatio*/  return new Property("defaultValue[x]", "Ratio", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -1488914053: /*defaultValueReference*/  return new Property("defaultValue[x]", "Reference", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -449641228: /*defaultValueSampledData*/  return new Property("defaultValue[x]", "SampledData", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 509825768: /*defaultValueSignature*/  return new Property("defaultValue[x]", "Signature", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -302193638: /*defaultValueTiming*/  return new Property("defaultValue[x]", "Timing", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1845473985: /*defaultValueContactDetail*/  return new Property("defaultValue[x]", "ContactDetail", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1793609483: /*defaultValueContributor*/  return new Property("defaultValue[x]", "Contributor", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 375217257: /*defaultValueDataRequirement*/  return new Property("defaultValue[x]", "DataRequirement", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -2092097944: /*defaultValueExpression*/  return new Property("defaultValue[x]", "Expression", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -701053940: /*defaultValueParameterDefinition*/  return new Property("defaultValue[x]", "ParameterDefinition", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 412877133: /*defaultValueRelatedArtifact*/  return new Property("defaultValue[x]", "RelatedArtifact", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1913203547: /*defaultValueTriggerDefinition*/  return new Property("defaultValue[x]", "TriggerDefinition", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -701644642: /*defaultValueUsageContext*/  return new Property("defaultValue[x]", "UsageContext", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case -754548089: /*defaultValueDosage*/  return new Property("defaultValue[x]", "Dosage", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1045282261: /*defaultValueMeta*/  return new Property("defaultValue[x]", "Meta", "The value that should be used if there is no value stated in the instance (e.g. 'if not otherwise specified, the abstract is false').", 0, 1, defaultValue);
        case 1857257103: /*meaningWhenMissing*/  return new Property("meaningWhenMissing", "markdown", "The Implicit meaning that is to be understood when this element is missing (e.g. 'when this element is missing, the period is ongoing').", 0, 1, meaningWhenMissing);
        case 1828196047: /*orderMeaning*/  return new Property("orderMeaning", "string", "If present, indicates that the order of the repeating element has meaning and describes what that meaning is.  If absent, it means that the order of the element has no meaning.", 0, 1, orderMeaning);
        case -391522164: /*fixed[x]*/  return new Property("fixed[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 97445748: /*fixed*/  return new Property("fixed[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -799290428: /*fixedBase64Binary*/  return new Property("fixed[x]", "base64Binary", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 520851988: /*fixedBoolean*/  return new Property("fixed[x]", "boolean", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1092485088: /*fixedCanonical*/  return new Property("fixed[x]", "canonical", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 746991489: /*fixedCode*/  return new Property("fixed[x]", "code", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 747008322: /*fixedDate*/  return new Property("fixed[x]", "date", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1246771409: /*fixedDateTime*/  return new Property("fixed[x]", "dateTime", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1998403901: /*fixedDecimal*/  return new Property("fixed[x]", "decimal", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -843914321: /*fixedId*/  return new Property("fixed[x]", "id", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1881257011: /*fixedInstant*/  return new Property("fixed[x]", "instant", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1880774870: /*fixedInteger*/  return new Property("fixed[x]", "integer", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 756583272: /*fixedInteger64*/  return new Property("fixed[x]", "integer64", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1502385283: /*fixedMarkdown*/  return new Property("fixed[x]", "markdown", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -391534154: /*fixedOid*/  return new Property("fixed[x]", "oid", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 297821986: /*fixedPositiveInt*/  return new Property("fixed[x]", "positiveInt", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1062390949: /*fixedString*/  return new Property("fixed[x]", "string", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 747492449: /*fixedTime*/  return new Property("fixed[x]", "time", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1574283430: /*fixedUnsignedInt*/  return new Property("fixed[x]", "unsignedInt", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -391528104: /*fixedUri*/  return new Property("fixed[x]", "uri", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -391528101: /*fixedUrl*/  return new Property("fixed[x]", "url", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 747533647: /*fixedUuid*/  return new Property("fixed[x]", "uuid", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -691551776: /*fixedAddress*/  return new Property("fixed[x]", "Address", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -391547669: /*fixedAge*/  return new Property("fixed[x]", "Age", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1956844093: /*fixedAnnotation*/  return new Property("fixed[x]", "Annotation", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1929665463: /*fixedAttachment*/  return new Property("fixed[x]", "Attachment", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1962764685: /*fixedCodeableConcept*/  return new Property("fixed[x]", "CodeableConcept", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 599289854: /*fixedCoding*/  return new Property("fixed[x]", "Coding", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1680638692: /*fixedContactPoint*/  return new Property("fixed[x]", "ContactPoint", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1681916411: /*fixedCount*/  return new Property("fixed[x]", "Count", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1543906185: /*fixedDistance*/  return new Property("fixed[x]", "Distance", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -736565976: /*fixedDuration*/  return new Property("fixed[x]", "Duration", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -147502012: /*fixedHumanName*/  return new Property("fixed[x]", "HumanName", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -2020233411: /*fixedIdentifier*/  return new Property("fixed[x]", "Identifier", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1691144620: /*fixedMoney*/  return new Property("fixed[x]", "Money", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 962650709: /*fixedPeriod*/  return new Property("fixed[x]", "Period", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -29557729: /*fixedQuantity*/  return new Property("fixed[x]", "Quantity", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1695345193: /*fixedRange*/  return new Property("fixed[x]", "Range", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1695351031: /*fixedRatio*/  return new Property("fixed[x]", "Ratio", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -661022153: /*fixedReference*/  return new Property("fixed[x]", "Reference", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 585524912: /*fixedSampledData*/  return new Property("fixed[x]", "SampledData", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1337717668: /*fixedSignature*/  return new Property("fixed[x]", "Signature", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1080712414: /*fixedTiming*/  return new Property("fixed[x]", "Timing", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 207721853: /*fixedContactDetail*/  return new Property("fixed[x]", "ContactDetail", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1466191673: /*fixedContributor*/  return new Property("fixed[x]", "Contributor", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1546551259: /*fixedDataRequirement*/  return new Property("fixed[x]", "DataRequirement", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 2097714476: /*fixedExpression*/  return new Property("fixed[x]", "Expression", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -2126861880: /*fixedParameterDefinition*/  return new Property("fixed[x]", "ParameterDefinition", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -1508891383: /*fixedRelatedArtifact*/  return new Property("fixed[x]", "RelatedArtifact", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1929596951: /*fixedTriggerDefinition*/  return new Property("fixed[x]", "TriggerDefinition", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 1323734626: /*fixedUsageContext*/  return new Property("fixed[x]", "UsageContext", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 628357963: /*fixedDosage*/  return new Property("fixed[x]", "Dosage", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case 747280281: /*fixedMeta*/  return new Property("fixed[x]", "Meta", "Specifies a value that SHALL be exactly the value  for this element in the instance. For purposes of comparison, non-significant whitespace is ignored, and all values must be an exact match (case and accent sensitive). Missing elements/attributes must also be missing.", 0, 1, fixed);
        case -885125392: /*pattern[x]*/  return new Property("pattern[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -791090288: /*pattern*/  return new Property("pattern[x]", "base64Binary|boolean|canonical|code|date|dateTime|decimal|id|instant|integer|integer64|markdown|oid|positiveInt|string|time|unsignedInt|uri|url|uuid|Address|Age|Annotation|Attachment|CodeableConcept|Coding|ContactPoint|Count|Distance|Duration|HumanName|Identifier|Money|Period|Quantity|Range|Ratio|Reference|SampledData|Signature|Timing|ContactDetail|Contributor|DataRequirement|Expression|ParameterDefinition|RelatedArtifact|TriggerDefinition|UsageContext|Dosage|Meta", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 2127857120: /*patternBase64Binary*/  return new Property("pattern[x]", "base64Binary", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1776945544: /*patternBoolean*/  return new Property("pattern[x]", "boolean", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 522246980: /*patternCanonical*/  return new Property("pattern[x]", "canonical", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1669806691: /*patternCode*/  return new Property("pattern[x]", "code", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1669789858: /*patternDate*/  return new Property("pattern[x]", "date", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 535949131: /*patternDateTime*/  return new Property("pattern[x]", "dateTime", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -299393631: /*patternDecimal*/  return new Property("pattern[x]", "decimal", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -28553013: /*patternId*/  return new Property("pattern[x]", "id", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 115912753: /*patternInstant*/  return new Property("pattern[x]", "instant", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 116394894: /*patternInteger*/  return new Property("pattern[x]", "integer", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 186345164: /*patternInteger64*/  return new Property("pattern[x]", "integer64", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1009861473: /*patternMarkdown*/  return new Property("pattern[x]", "markdown", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -885137382: /*patternOid*/  return new Property("pattern[x]", "oid", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 2054814086: /*patternPositiveInt*/  return new Property("pattern[x]", "positiveInt", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 2096647105: /*patternString*/  return new Property("pattern[x]", "string", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1669305731: /*patternTime*/  return new Property("pattern[x]", "time", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -963691766: /*patternUnsignedInt*/  return new Property("pattern[x]", "unsignedInt", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -885131332: /*patternUri*/  return new Property("pattern[x]", "uri", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -885131329: /*patternUrl*/  return new Property("pattern[x]", "url", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1669264533: /*patternUuid*/  return new Property("pattern[x]", "uuid", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1305617988: /*patternAddress*/  return new Property("pattern[x]", "Address", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -885150897: /*patternAge*/  return new Property("pattern[x]", "Age", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1840611039: /*patternAnnotation*/  return new Property("pattern[x]", "Annotation", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1432153299: /*patternAttachment*/  return new Property("pattern[x]", "Attachment", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -400610831: /*patternCodeableConcept*/  return new Property("pattern[x]", "CodeableConcept", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1633546010: /*patternCoding*/  return new Property("pattern[x]", "Coding", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 312818944: /*patternContactPoint*/  return new Property("pattern[x]", "ContactPoint", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -224383137: /*patternCount*/  return new Property("pattern[x]", "Count", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -968340571: /*patternDistance*/  return new Property("pattern[x]", "Distance", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1046154564: /*patternDuration*/  return new Property("pattern[x]", "Duration", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -717740120: /*patternHumanName*/  return new Property("pattern[x]", "HumanName", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1777221721: /*patternIdentifier*/  return new Property("pattern[x]", "Identifier", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -215154928: /*patternMoney*/  return new Property("pattern[x]", "Money", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1996906865: /*patternPeriod*/  return new Property("pattern[x]", "Period", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1753162811: /*patternQuantity*/  return new Property("pattern[x]", "Quantity", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -210954355: /*patternRange*/  return new Property("pattern[x]", "Range", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -210948517: /*patternRatio*/  return new Property("pattern[x]", "Ratio", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1231260261: /*patternReference*/  return new Property("pattern[x]", "Reference", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1952450284: /*patternSampledData*/  return new Property("pattern[x]", "SampledData", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 767479560: /*patternSignature*/  return new Property("pattern[x]", "Signature", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 2114968570: /*patternTiming*/  return new Property("pattern[x]", "Timing", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 754982625: /*patternContactDetail*/  return new Property("pattern[x]", "ContactDetail", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 290800427: /*patternContributor*/  return new Property("pattern[x]", "Contributor", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 385040521: /*patternDataRequirement*/  return new Property("pattern[x]", "DataRequirement", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1600202312: /*patternExpression*/  return new Property("pattern[x]", "Expression", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 318609452: /*patternParameterDefinition*/  return new Property("pattern[x]", "ParameterDefinition", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 422700397: /*patternRelatedArtifact*/  return new Property("pattern[x]", "RelatedArtifact", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1531541637: /*patternTriggerDefinition*/  return new Property("pattern[x]", "TriggerDefinition", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -44085122: /*patternUsageContext*/  return new Property("pattern[x]", "UsageContext", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case 1662614119: /*patternDosage*/  return new Property("pattern[x]", "Dosage", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1669517899: /*patternMeta*/  return new Property("pattern[x]", "Meta", "Specifies a value that the value in the instance SHALL follow - that is, any value in the pattern must be found in the instance. Other additional values may be found too. This is effectively constraint by example.  \n\nWhen pattern[x] is used to constrain a primitive, it means that the value provided in the pattern[x] must match the instance value exactly.\n\nWhen pattern[x] is used to constrain an array, it means that each element provided in the pattern[x] array must (recursively) match at least one element from the instance array.\n\nWhen pattern[x] is used to constrain a complex object, it means that each property in the pattern must be present in the complex object, and its value must recursively match -- i.e.,\n\n1. If primitive: it must match exactly the pattern value\n2. If a complex object: it must match (recursively) the pattern value\n3. If an array: it must match (recursively) the pattern value.", 0, 1, pattern);
        case -1322970774: /*example*/  return new Property("example", "", "A sample value for this element demonstrating the type of information that would typically be found in the element.", 0, java.lang.Integer.MAX_VALUE, example);
        case -55301663: /*minValue[x]*/  return new Property("minValue[x]", "date|dateTime|instant|time|decimal|integer|integer64|positiveInt|unsignedInt|Quantity", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -1376969153: /*minValue*/  return new Property("minValue[x]", "date|dateTime|instant|time|decimal|integer|integer64|positiveInt|unsignedInt|Quantity", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -1715058035: /*minValueDate*/  return new Property("minValue[x]", "date", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case 1635517178: /*minValueDateTime*/  return new Property("minValue[x]", "dateTime", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case 151382690: /*minValueInstant*/  return new Property("minValue[x]", "instant", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -1714573908: /*minValueTime*/  return new Property("minValue[x]", "time", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -263923694: /*minValueDecimal*/  return new Property("minValue[x]", "decimal", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case 151864831: /*minValueInteger*/  return new Property("minValue[x]", "integer", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -86783747: /*minValueInteger64*/  return new Property("minValue[x]", "integer64", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case 1570935671: /*minValuePositiveInt*/  return new Property("minValue[x]", "positiveInt", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -1447570181: /*minValueUnsignedInt*/  return new Property("minValue[x]", "unsignedInt", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case -1442236438: /*minValueQuantity*/  return new Property("minValue[x]", "Quantity", "The minimum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, minValue);
        case 622130931: /*maxValue[x]*/  return new Property("maxValue[x]", "date|dateTime|instant|time|decimal|integer|integer64|positiveInt|unsignedInt|Quantity", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 399227501: /*maxValue*/  return new Property("maxValue[x]", "date|dateTime|instant|time|decimal|integer|integer64|positiveInt|unsignedInt|Quantity", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 2105483195: /*maxValueDate*/  return new Property("maxValue[x]", "date", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 1699385640: /*maxValueDateTime*/  return new Property("maxValue[x]", "dateTime", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 1261821620: /*maxValueInstant*/  return new Property("maxValue[x]", "instant", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 2105967322: /*maxValueTime*/  return new Property("maxValue[x]", "time", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 846515236: /*maxValueDecimal*/  return new Property("maxValue[x]", "decimal", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 1262303761: /*maxValueInteger*/  return new Property("maxValue[x]", "integer", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 1893138575: /*maxValueInteger64*/  return new Property("maxValue[x]", "integer64", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case 1605774985: /*maxValuePositiveInt*/  return new Property("maxValue[x]", "positiveInt", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case -1412730867: /*maxValueUnsignedInt*/  return new Property("maxValue[x]", "unsignedInt", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case -1378367976: /*maxValueQuantity*/  return new Property("maxValue[x]", "Quantity", "The maximum allowed value for the element. The value is inclusive. This is allowed for the types date, dateTime, instant, time, decimal, integer, and Quantity.", 0, 1, maxValue);
        case -791400086: /*maxLength*/  return new Property("maxLength", "integer", "Indicates the maximum length in characters that is permitted to be present in conformant instances and which is expected to be supported by conformant consumers that support the element.", 0, 1, maxLength);
        case -861311717: /*condition*/  return new Property("condition", "id", "A reference to an invariant that may make additional statements about the cardinality or value in the instance.", 0, java.lang.Integer.MAX_VALUE, condition);
        case -190376483: /*constraint*/  return new Property("constraint", "", "Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the context of the instance.", 0, java.lang.Integer.MAX_VALUE, constraint);
        case -1402857082: /*mustSupport*/  return new Property("mustSupport", "boolean", "If true, implementations that produce or consume resources SHALL provide \"support\" for the element in some meaningful way.  If false, the element may be ignored and not supported. If false, whether to populate or use the data element in any way is at the discretion of the implementation.", 0, 1, mustSupport);
        case -1408783839: /*isModifier*/  return new Property("isModifier", "boolean", "If true, the value of this element affects the interpretation of the element or resource that contains it, and the value of the element cannot be ignored. Typically, this is used for status, negation and qualification codes. The effect of this is that the element cannot be ignored by systems: they SHALL either recognize the element and process it, and/or a pre-determination has been made that it is not relevant to their particular system.", 0, 1, isModifier);
        case -1854387259: /*isModifierReason*/  return new Property("isModifierReason", "string", "Explains how that element affects the interpretation of the resource or element that contains it.", 0, 1, isModifierReason);
        case 1857548060: /*isSummary*/  return new Property("isSummary", "boolean", "Whether the element should be included if a client requests a search with the parameter _summary=true.", 0, 1, isSummary);
        case -108220795: /*binding*/  return new Property("binding", "", "Binds to a value set if this element is coded (code, Coding, CodeableConcept, Quantity), or the data types (string, uri).", 0, 1, binding);
        case 837556430: /*mapping*/  return new Property("mapping", "", "Identifies a concept from an external specification that roughly corresponds to this element.", 0, java.lang.Integer.MAX_VALUE, mapping);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -671065907: /*representation*/ return this.representation == null ? new Base[0] : this.representation.toArray(new Base[this.representation.size()]); // Enumeration<PropertyRepresentation>
        case -825289923: /*sliceName*/ return this.sliceName == null ? new Base[0] : new Base[] {this.sliceName}; // StringType
        case 333040519: /*sliceIsConstraining*/ return this.sliceIsConstraining == null ? new Base[0] : new Base[] {this.sliceIsConstraining}; // BooleanType
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // Coding
        case -2119287345: /*slicing*/ return this.slicing == null ? new Base[0] : new Base[] {this.slicing}; // ElementDefinitionSlicingComponent
        case 109413500: /*short*/ return this.short_ == null ? new Base[0] : new Base[] {this.short_}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // MarkdownType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // MarkdownType
        case -1619874672: /*requirements*/ return this.requirements == null ? new Base[0] : new Base[] {this.requirements}; // MarkdownType
        case 92902992: /*alias*/ return this.alias == null ? new Base[0] : this.alias.toArray(new Base[this.alias.size()]); // StringType
        case 108114: /*min*/ return this.min == null ? new Base[0] : new Base[] {this.min}; // UnsignedIntType
        case 107876: /*max*/ return this.max == null ? new Base[0] : new Base[] {this.max}; // StringType
        case 3016401: /*base*/ return this.base == null ? new Base[0] : new Base[] {this.base}; // ElementDefinitionBaseComponent
        case 1193747154: /*contentReference*/ return this.contentReference == null ? new Base[0] : new Base[] {this.contentReference}; // UriType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // TypeRefComponent
        case -659125328: /*defaultValue*/ return this.defaultValue == null ? new Base[0] : new Base[] {this.defaultValue}; // DataType
        case 1857257103: /*meaningWhenMissing*/ return this.meaningWhenMissing == null ? new Base[0] : new Base[] {this.meaningWhenMissing}; // MarkdownType
        case 1828196047: /*orderMeaning*/ return this.orderMeaning == null ? new Base[0] : new Base[] {this.orderMeaning}; // StringType
        case 97445748: /*fixed*/ return this.fixed == null ? new Base[0] : new Base[] {this.fixed}; // DataType
        case -791090288: /*pattern*/ return this.pattern == null ? new Base[0] : new Base[] {this.pattern}; // DataType
        case -1322970774: /*example*/ return this.example == null ? new Base[0] : this.example.toArray(new Base[this.example.size()]); // ElementDefinitionExampleComponent
        case -1376969153: /*minValue*/ return this.minValue == null ? new Base[0] : new Base[] {this.minValue}; // DataType
        case 399227501: /*maxValue*/ return this.maxValue == null ? new Base[0] : new Base[] {this.maxValue}; // DataType
        case -791400086: /*maxLength*/ return this.maxLength == null ? new Base[0] : new Base[] {this.maxLength}; // IntegerType
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // IdType
        case -190376483: /*constraint*/ return this.constraint == null ? new Base[0] : this.constraint.toArray(new Base[this.constraint.size()]); // ElementDefinitionConstraintComponent
        case -1402857082: /*mustSupport*/ return this.mustSupport == null ? new Base[0] : new Base[] {this.mustSupport}; // BooleanType
        case -1408783839: /*isModifier*/ return this.isModifier == null ? new Base[0] : new Base[] {this.isModifier}; // BooleanType
        case -1854387259: /*isModifierReason*/ return this.isModifierReason == null ? new Base[0] : new Base[] {this.isModifierReason}; // StringType
        case 1857548060: /*isSummary*/ return this.isSummary == null ? new Base[0] : new Base[] {this.isSummary}; // BooleanType
        case -108220795: /*binding*/ return this.binding == null ? new Base[0] : new Base[] {this.binding}; // ElementDefinitionBindingComponent
        case 837556430: /*mapping*/ return this.mapping == null ? new Base[0] : this.mapping.toArray(new Base[this.mapping.size()]); // ElementDefinitionMappingComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -671065907: // representation
          value = new PropertyRepresentationEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getRepresentation().add((Enumeration) value); // Enumeration<PropertyRepresentation>
          return value;
        case -825289923: // sliceName
          this.sliceName = TypeConvertor.castToString(value); // StringType
          return value;
        case 333040519: // sliceIsConstraining
          this.sliceIsConstraining = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case -2119287345: // slicing
          this.slicing = (ElementDefinitionSlicingComponent) value; // ElementDefinitionSlicingComponent
          return value;
        case 109413500: // short
          this.short_ = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1619874672: // requirements
          this.requirements = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 92902992: // alias
          this.getAlias().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 108114: // min
          this.min = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 107876: // max
          this.max = TypeConvertor.castToString(value); // StringType
          return value;
        case 3016401: // base
          this.base = (ElementDefinitionBaseComponent) value; // ElementDefinitionBaseComponent
          return value;
        case 1193747154: // contentReference
          this.contentReference = TypeConvertor.castToUri(value); // UriType
          return value;
        case 3575610: // type
          this.getType().add((TypeRefComponent) value); // TypeRefComponent
          return value;
        case -659125328: // defaultValue
          this.defaultValue = TypeConvertor.castToType(value); // DataType
          return value;
        case 1857257103: // meaningWhenMissing
          this.meaningWhenMissing = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1828196047: // orderMeaning
          this.orderMeaning = TypeConvertor.castToString(value); // StringType
          return value;
        case 97445748: // fixed
          this.fixed = TypeConvertor.castToType(value); // DataType
          return value;
        case -791090288: // pattern
          this.pattern = TypeConvertor.castToType(value); // DataType
          return value;
        case -1322970774: // example
          this.getExample().add((ElementDefinitionExampleComponent) value); // ElementDefinitionExampleComponent
          return value;
        case -1376969153: // minValue
          this.minValue = TypeConvertor.castToType(value); // DataType
          return value;
        case 399227501: // maxValue
          this.maxValue = TypeConvertor.castToType(value); // DataType
          return value;
        case -791400086: // maxLength
          this.maxLength = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -861311717: // condition
          this.getCondition().add(TypeConvertor.castToId(value)); // IdType
          return value;
        case -190376483: // constraint
          this.getConstraint().add((ElementDefinitionConstraintComponent) value); // ElementDefinitionConstraintComponent
          return value;
        case -1402857082: // mustSupport
          this.mustSupport = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1408783839: // isModifier
          this.isModifier = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1854387259: // isModifierReason
          this.isModifierReason = TypeConvertor.castToString(value); // StringType
          return value;
        case 1857548060: // isSummary
          this.isSummary = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -108220795: // binding
          this.binding = (ElementDefinitionBindingComponent) value; // ElementDefinitionBindingComponent
          return value;
        case 837556430: // mapping
          this.getMapping().add((ElementDefinitionMappingComponent) value); // ElementDefinitionMappingComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("representation")) {
          value = new PropertyRepresentationEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getRepresentation().add((Enumeration) value);
        } else if (name.equals("sliceName")) {
          this.sliceName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("sliceIsConstraining")) {
          this.sliceIsConstraining = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("slicing")) {
          this.slicing = (ElementDefinitionSlicingComponent) value; // ElementDefinitionSlicingComponent
        } else if (name.equals("short")) {
          this.short_ = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("requirements")) {
          this.requirements = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("alias")) {
          this.getAlias().add(TypeConvertor.castToString(value));
        } else if (name.equals("min")) {
          this.min = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("max")) {
          this.max = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("base")) {
          this.base = (ElementDefinitionBaseComponent) value; // ElementDefinitionBaseComponent
        } else if (name.equals("contentReference")) {
          this.contentReference = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("type")) {
          this.getType().add((TypeRefComponent) value);
        } else if (name.equals("defaultValue[x]")) {
          this.defaultValue = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("meaningWhenMissing")) {
          this.meaningWhenMissing = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("orderMeaning")) {
          this.orderMeaning = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("fixed[x]")) {
          this.fixed = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("pattern[x]")) {
          this.pattern = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("example")) {
          this.getExample().add((ElementDefinitionExampleComponent) value);
        } else if (name.equals("minValue[x]")) {
          this.minValue = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("maxValue[x]")) {
          this.maxValue = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("maxLength")) {
          this.maxLength = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("condition")) {
          this.getCondition().add(TypeConvertor.castToId(value));
        } else if (name.equals("constraint")) {
          this.getConstraint().add((ElementDefinitionConstraintComponent) value);
        } else if (name.equals("mustSupport")) {
          this.mustSupport = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("isModifier")) {
          this.isModifier = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("isModifierReason")) {
          this.isModifierReason = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("isSummary")) {
          this.isSummary = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("binding")) {
          this.binding = (ElementDefinitionBindingComponent) value; // ElementDefinitionBindingComponent
        } else if (name.equals("mapping")) {
          this.getMapping().add((ElementDefinitionMappingComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -671065907:  return addRepresentationElement();
        case -825289923:  return getSliceNameElement();
        case 333040519:  return getSliceIsConstrainingElement();
        case 102727412:  return getLabelElement();
        case 3059181:  return addCode(); 
        case -2119287345:  return getSlicing();
        case 109413500:  return getShortElement();
        case -1014418093:  return getDefinitionElement();
        case 950398559:  return getCommentElement();
        case -1619874672:  return getRequirementsElement();
        case 92902992:  return addAliasElement();
        case 108114:  return getMinElement();
        case 107876:  return getMaxElement();
        case 3016401:  return getBase();
        case 1193747154:  return getContentReferenceElement();
        case 3575610:  return addType(); 
        case 587922128:  return getDefaultValue();
        case -659125328:  return getDefaultValue();
        case 1857257103:  return getMeaningWhenMissingElement();
        case 1828196047:  return getOrderMeaningElement();
        case -391522164:  return getFixed();
        case 97445748:  return getFixed();
        case -885125392:  return getPattern();
        case -791090288:  return getPattern();
        case -1322970774:  return addExample(); 
        case -55301663:  return getMinValue();
        case -1376969153:  return getMinValue();
        case 622130931:  return getMaxValue();
        case 399227501:  return getMaxValue();
        case -791400086:  return getMaxLengthElement();
        case -861311717:  return addConditionElement();
        case -190376483:  return addConstraint(); 
        case -1402857082:  return getMustSupportElement();
        case -1408783839:  return getIsModifierElement();
        case -1854387259:  return getIsModifierReasonElement();
        case 1857548060:  return getIsSummaryElement();
        case -108220795:  return getBinding();
        case 837556430:  return addMapping(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -671065907: /*representation*/ return new String[] {"code"};
        case -825289923: /*sliceName*/ return new String[] {"string"};
        case 333040519: /*sliceIsConstraining*/ return new String[] {"boolean"};
        case 102727412: /*label*/ return new String[] {"string"};
        case 3059181: /*code*/ return new String[] {"Coding"};
        case -2119287345: /*slicing*/ return new String[] {};
        case 109413500: /*short*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"markdown"};
        case 950398559: /*comment*/ return new String[] {"markdown"};
        case -1619874672: /*requirements*/ return new String[] {"markdown"};
        case 92902992: /*alias*/ return new String[] {"string"};
        case 108114: /*min*/ return new String[] {"unsignedInt"};
        case 107876: /*max*/ return new String[] {"string"};
        case 3016401: /*base*/ return new String[] {};
        case 1193747154: /*contentReference*/ return new String[] {"uri"};
        case 3575610: /*type*/ return new String[] {};
        case -659125328: /*defaultValue*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Dosage", "Meta"};
        case 1857257103: /*meaningWhenMissing*/ return new String[] {"markdown"};
        case 1828196047: /*orderMeaning*/ return new String[] {"string"};
        case 97445748: /*fixed*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Dosage", "Meta"};
        case -791090288: /*pattern*/ return new String[] {"base64Binary", "boolean", "canonical", "code", "date", "dateTime", "decimal", "id", "instant", "integer", "integer64", "markdown", "oid", "positiveInt", "string", "time", "unsignedInt", "uri", "url", "uuid", "Address", "Age", "Annotation", "Attachment", "CodeableConcept", "Coding", "ContactPoint", "Count", "Distance", "Duration", "HumanName", "Identifier", "Money", "Period", "Quantity", "Range", "Ratio", "Reference", "SampledData", "Signature", "Timing", "ContactDetail", "Contributor", "DataRequirement", "Expression", "ParameterDefinition", "RelatedArtifact", "TriggerDefinition", "UsageContext", "Dosage", "Meta"};
        case -1322970774: /*example*/ return new String[] {};
        case -1376969153: /*minValue*/ return new String[] {"date", "dateTime", "instant", "time", "decimal", "integer", "integer64", "positiveInt", "unsignedInt", "Quantity"};
        case 399227501: /*maxValue*/ return new String[] {"date", "dateTime", "instant", "time", "decimal", "integer", "integer64", "positiveInt", "unsignedInt", "Quantity"};
        case -791400086: /*maxLength*/ return new String[] {"integer"};
        case -861311717: /*condition*/ return new String[] {"id"};
        case -190376483: /*constraint*/ return new String[] {};
        case -1402857082: /*mustSupport*/ return new String[] {"boolean"};
        case -1408783839: /*isModifier*/ return new String[] {"boolean"};
        case -1854387259: /*isModifierReason*/ return new String[] {"string"};
        case 1857548060: /*isSummary*/ return new String[] {"boolean"};
        case -108220795: /*binding*/ return new String[] {};
        case 837556430: /*mapping*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.path");
        }
        else if (name.equals("representation")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.representation");
        }
        else if (name.equals("sliceName")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.sliceName");
        }
        else if (name.equals("sliceIsConstraining")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.sliceIsConstraining");
        }
        else if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.label");
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("slicing")) {
          this.slicing = new ElementDefinitionSlicingComponent();
          return this.slicing;
        }
        else if (name.equals("short")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.short");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.definition");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.comment");
        }
        else if (name.equals("requirements")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.requirements");
        }
        else if (name.equals("alias")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.alias");
        }
        else if (name.equals("min")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.min");
        }
        else if (name.equals("max")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.max");
        }
        else if (name.equals("base")) {
          this.base = new ElementDefinitionBaseComponent();
          return this.base;
        }
        else if (name.equals("contentReference")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.contentReference");
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("defaultValueBase64Binary")) {
          this.defaultValue = new Base64BinaryType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueBoolean")) {
          this.defaultValue = new BooleanType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueCanonical")) {
          this.defaultValue = new CanonicalType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueCode")) {
          this.defaultValue = new CodeType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDate")) {
          this.defaultValue = new DateType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDateTime")) {
          this.defaultValue = new DateTimeType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDecimal")) {
          this.defaultValue = new DecimalType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueId")) {
          this.defaultValue = new IdType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueInstant")) {
          this.defaultValue = new InstantType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueInteger")) {
          this.defaultValue = new IntegerType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueInteger64")) {
          this.defaultValue = new Integer64Type();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueMarkdown")) {
          this.defaultValue = new MarkdownType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueOid")) {
          this.defaultValue = new OidType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValuePositiveInt")) {
          this.defaultValue = new PositiveIntType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueString")) {
          this.defaultValue = new StringType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueTime")) {
          this.defaultValue = new TimeType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueUnsignedInt")) {
          this.defaultValue = new UnsignedIntType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueUri")) {
          this.defaultValue = new UriType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueUrl")) {
          this.defaultValue = new UrlType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueUuid")) {
          this.defaultValue = new UuidType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueAddress")) {
          this.defaultValue = new Address();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueAge")) {
          this.defaultValue = new Age();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueAnnotation")) {
          this.defaultValue = new Annotation();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueAttachment")) {
          this.defaultValue = new Attachment();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueCodeableConcept")) {
          this.defaultValue = new CodeableConcept();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueCoding")) {
          this.defaultValue = new Coding();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueContactPoint")) {
          this.defaultValue = new ContactPoint();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueCount")) {
          this.defaultValue = new Count();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDistance")) {
          this.defaultValue = new Distance();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDuration")) {
          this.defaultValue = new Duration();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueHumanName")) {
          this.defaultValue = new HumanName();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueIdentifier")) {
          this.defaultValue = new Identifier();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueMoney")) {
          this.defaultValue = new Money();
          return this.defaultValue;
        }
        else if (name.equals("defaultValuePeriod")) {
          this.defaultValue = new Period();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueQuantity")) {
          this.defaultValue = new Quantity();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueRange")) {
          this.defaultValue = new Range();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueRatio")) {
          this.defaultValue = new Ratio();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueReference")) {
          this.defaultValue = new Reference();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueSampledData")) {
          this.defaultValue = new SampledData();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueSignature")) {
          this.defaultValue = new Signature();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueTiming")) {
          this.defaultValue = new Timing();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueContactDetail")) {
          this.defaultValue = new ContactDetail();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueContributor")) {
          this.defaultValue = new Contributor();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDataRequirement")) {
          this.defaultValue = new DataRequirement();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueExpression")) {
          this.defaultValue = new Expression();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueParameterDefinition")) {
          this.defaultValue = new ParameterDefinition();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueRelatedArtifact")) {
          this.defaultValue = new RelatedArtifact();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueTriggerDefinition")) {
          this.defaultValue = new TriggerDefinition();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueUsageContext")) {
          this.defaultValue = new UsageContext();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueDosage")) {
          this.defaultValue = new Dosage();
          return this.defaultValue;
        }
        else if (name.equals("defaultValueMeta")) {
          this.defaultValue = new Meta();
          return this.defaultValue;
        }
        else if (name.equals("meaningWhenMissing")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.meaningWhenMissing");
        }
        else if (name.equals("orderMeaning")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.orderMeaning");
        }
        else if (name.equals("fixedBase64Binary")) {
          this.fixed = new Base64BinaryType();
          return this.fixed;
        }
        else if (name.equals("fixedBoolean")) {
          this.fixed = new BooleanType();
          return this.fixed;
        }
        else if (name.equals("fixedCanonical")) {
          this.fixed = new CanonicalType();
          return this.fixed;
        }
        else if (name.equals("fixedCode")) {
          this.fixed = new CodeType();
          return this.fixed;
        }
        else if (name.equals("fixedDate")) {
          this.fixed = new DateType();
          return this.fixed;
        }
        else if (name.equals("fixedDateTime")) {
          this.fixed = new DateTimeType();
          return this.fixed;
        }
        else if (name.equals("fixedDecimal")) {
          this.fixed = new DecimalType();
          return this.fixed;
        }
        else if (name.equals("fixedId")) {
          this.fixed = new IdType();
          return this.fixed;
        }
        else if (name.equals("fixedInstant")) {
          this.fixed = new InstantType();
          return this.fixed;
        }
        else if (name.equals("fixedInteger")) {
          this.fixed = new IntegerType();
          return this.fixed;
        }
        else if (name.equals("fixedInteger64")) {
          this.fixed = new Integer64Type();
          return this.fixed;
        }
        else if (name.equals("fixedMarkdown")) {
          this.fixed = new MarkdownType();
          return this.fixed;
        }
        else if (name.equals("fixedOid")) {
          this.fixed = new OidType();
          return this.fixed;
        }
        else if (name.equals("fixedPositiveInt")) {
          this.fixed = new PositiveIntType();
          return this.fixed;
        }
        else if (name.equals("fixedString")) {
          this.fixed = new StringType();
          return this.fixed;
        }
        else if (name.equals("fixedTime")) {
          this.fixed = new TimeType();
          return this.fixed;
        }
        else if (name.equals("fixedUnsignedInt")) {
          this.fixed = new UnsignedIntType();
          return this.fixed;
        }
        else if (name.equals("fixedUri")) {
          this.fixed = new UriType();
          return this.fixed;
        }
        else if (name.equals("fixedUrl")) {
          this.fixed = new UrlType();
          return this.fixed;
        }
        else if (name.equals("fixedUuid")) {
          this.fixed = new UuidType();
          return this.fixed;
        }
        else if (name.equals("fixedAddress")) {
          this.fixed = new Address();
          return this.fixed;
        }
        else if (name.equals("fixedAge")) {
          this.fixed = new Age();
          return this.fixed;
        }
        else if (name.equals("fixedAnnotation")) {
          this.fixed = new Annotation();
          return this.fixed;
        }
        else if (name.equals("fixedAttachment")) {
          this.fixed = new Attachment();
          return this.fixed;
        }
        else if (name.equals("fixedCodeableConcept")) {
          this.fixed = new CodeableConcept();
          return this.fixed;
        }
        else if (name.equals("fixedCoding")) {
          this.fixed = new Coding();
          return this.fixed;
        }
        else if (name.equals("fixedContactPoint")) {
          this.fixed = new ContactPoint();
          return this.fixed;
        }
        else if (name.equals("fixedCount")) {
          this.fixed = new Count();
          return this.fixed;
        }
        else if (name.equals("fixedDistance")) {
          this.fixed = new Distance();
          return this.fixed;
        }
        else if (name.equals("fixedDuration")) {
          this.fixed = new Duration();
          return this.fixed;
        }
        else if (name.equals("fixedHumanName")) {
          this.fixed = new HumanName();
          return this.fixed;
        }
        else if (name.equals("fixedIdentifier")) {
          this.fixed = new Identifier();
          return this.fixed;
        }
        else if (name.equals("fixedMoney")) {
          this.fixed = new Money();
          return this.fixed;
        }
        else if (name.equals("fixedPeriod")) {
          this.fixed = new Period();
          return this.fixed;
        }
        else if (name.equals("fixedQuantity")) {
          this.fixed = new Quantity();
          return this.fixed;
        }
        else if (name.equals("fixedRange")) {
          this.fixed = new Range();
          return this.fixed;
        }
        else if (name.equals("fixedRatio")) {
          this.fixed = new Ratio();
          return this.fixed;
        }
        else if (name.equals("fixedReference")) {
          this.fixed = new Reference();
          return this.fixed;
        }
        else if (name.equals("fixedSampledData")) {
          this.fixed = new SampledData();
          return this.fixed;
        }
        else if (name.equals("fixedSignature")) {
          this.fixed = new Signature();
          return this.fixed;
        }
        else if (name.equals("fixedTiming")) {
          this.fixed = new Timing();
          return this.fixed;
        }
        else if (name.equals("fixedContactDetail")) {
          this.fixed = new ContactDetail();
          return this.fixed;
        }
        else if (name.equals("fixedContributor")) {
          this.fixed = new Contributor();
          return this.fixed;
        }
        else if (name.equals("fixedDataRequirement")) {
          this.fixed = new DataRequirement();
          return this.fixed;
        }
        else if (name.equals("fixedExpression")) {
          this.fixed = new Expression();
          return this.fixed;
        }
        else if (name.equals("fixedParameterDefinition")) {
          this.fixed = new ParameterDefinition();
          return this.fixed;
        }
        else if (name.equals("fixedRelatedArtifact")) {
          this.fixed = new RelatedArtifact();
          return this.fixed;
        }
        else if (name.equals("fixedTriggerDefinition")) {
          this.fixed = new TriggerDefinition();
          return this.fixed;
        }
        else if (name.equals("fixedUsageContext")) {
          this.fixed = new UsageContext();
          return this.fixed;
        }
        else if (name.equals("fixedDosage")) {
          this.fixed = new Dosage();
          return this.fixed;
        }
        else if (name.equals("fixedMeta")) {
          this.fixed = new Meta();
          return this.fixed;
        }
        else if (name.equals("patternBase64Binary")) {
          this.pattern = new Base64BinaryType();
          return this.pattern;
        }
        else if (name.equals("patternBoolean")) {
          this.pattern = new BooleanType();
          return this.pattern;
        }
        else if (name.equals("patternCanonical")) {
          this.pattern = new CanonicalType();
          return this.pattern;
        }
        else if (name.equals("patternCode")) {
          this.pattern = new CodeType();
          return this.pattern;
        }
        else if (name.equals("patternDate")) {
          this.pattern = new DateType();
          return this.pattern;
        }
        else if (name.equals("patternDateTime")) {
          this.pattern = new DateTimeType();
          return this.pattern;
        }
        else if (name.equals("patternDecimal")) {
          this.pattern = new DecimalType();
          return this.pattern;
        }
        else if (name.equals("patternId")) {
          this.pattern = new IdType();
          return this.pattern;
        }
        else if (name.equals("patternInstant")) {
          this.pattern = new InstantType();
          return this.pattern;
        }
        else if (name.equals("patternInteger")) {
          this.pattern = new IntegerType();
          return this.pattern;
        }
        else if (name.equals("patternInteger64")) {
          this.pattern = new Integer64Type();
          return this.pattern;
        }
        else if (name.equals("patternMarkdown")) {
          this.pattern = new MarkdownType();
          return this.pattern;
        }
        else if (name.equals("patternOid")) {
          this.pattern = new OidType();
          return this.pattern;
        }
        else if (name.equals("patternPositiveInt")) {
          this.pattern = new PositiveIntType();
          return this.pattern;
        }
        else if (name.equals("patternString")) {
          this.pattern = new StringType();
          return this.pattern;
        }
        else if (name.equals("patternTime")) {
          this.pattern = new TimeType();
          return this.pattern;
        }
        else if (name.equals("patternUnsignedInt")) {
          this.pattern = new UnsignedIntType();
          return this.pattern;
        }
        else if (name.equals("patternUri")) {
          this.pattern = new UriType();
          return this.pattern;
        }
        else if (name.equals("patternUrl")) {
          this.pattern = new UrlType();
          return this.pattern;
        }
        else if (name.equals("patternUuid")) {
          this.pattern = new UuidType();
          return this.pattern;
        }
        else if (name.equals("patternAddress")) {
          this.pattern = new Address();
          return this.pattern;
        }
        else if (name.equals("patternAge")) {
          this.pattern = new Age();
          return this.pattern;
        }
        else if (name.equals("patternAnnotation")) {
          this.pattern = new Annotation();
          return this.pattern;
        }
        else if (name.equals("patternAttachment")) {
          this.pattern = new Attachment();
          return this.pattern;
        }
        else if (name.equals("patternCodeableConcept")) {
          this.pattern = new CodeableConcept();
          return this.pattern;
        }
        else if (name.equals("patternCoding")) {
          this.pattern = new Coding();
          return this.pattern;
        }
        else if (name.equals("patternContactPoint")) {
          this.pattern = new ContactPoint();
          return this.pattern;
        }
        else if (name.equals("patternCount")) {
          this.pattern = new Count();
          return this.pattern;
        }
        else if (name.equals("patternDistance")) {
          this.pattern = new Distance();
          return this.pattern;
        }
        else if (name.equals("patternDuration")) {
          this.pattern = new Duration();
          return this.pattern;
        }
        else if (name.equals("patternHumanName")) {
          this.pattern = new HumanName();
          return this.pattern;
        }
        else if (name.equals("patternIdentifier")) {
          this.pattern = new Identifier();
          return this.pattern;
        }
        else if (name.equals("patternMoney")) {
          this.pattern = new Money();
          return this.pattern;
        }
        else if (name.equals("patternPeriod")) {
          this.pattern = new Period();
          return this.pattern;
        }
        else if (name.equals("patternQuantity")) {
          this.pattern = new Quantity();
          return this.pattern;
        }
        else if (name.equals("patternRange")) {
          this.pattern = new Range();
          return this.pattern;
        }
        else if (name.equals("patternRatio")) {
          this.pattern = new Ratio();
          return this.pattern;
        }
        else if (name.equals("patternReference")) {
          this.pattern = new Reference();
          return this.pattern;
        }
        else if (name.equals("patternSampledData")) {
          this.pattern = new SampledData();
          return this.pattern;
        }
        else if (name.equals("patternSignature")) {
          this.pattern = new Signature();
          return this.pattern;
        }
        else if (name.equals("patternTiming")) {
          this.pattern = new Timing();
          return this.pattern;
        }
        else if (name.equals("patternContactDetail")) {
          this.pattern = new ContactDetail();
          return this.pattern;
        }
        else if (name.equals("patternContributor")) {
          this.pattern = new Contributor();
          return this.pattern;
        }
        else if (name.equals("patternDataRequirement")) {
          this.pattern = new DataRequirement();
          return this.pattern;
        }
        else if (name.equals("patternExpression")) {
          this.pattern = new Expression();
          return this.pattern;
        }
        else if (name.equals("patternParameterDefinition")) {
          this.pattern = new ParameterDefinition();
          return this.pattern;
        }
        else if (name.equals("patternRelatedArtifact")) {
          this.pattern = new RelatedArtifact();
          return this.pattern;
        }
        else if (name.equals("patternTriggerDefinition")) {
          this.pattern = new TriggerDefinition();
          return this.pattern;
        }
        else if (name.equals("patternUsageContext")) {
          this.pattern = new UsageContext();
          return this.pattern;
        }
        else if (name.equals("patternDosage")) {
          this.pattern = new Dosage();
          return this.pattern;
        }
        else if (name.equals("patternMeta")) {
          this.pattern = new Meta();
          return this.pattern;
        }
        else if (name.equals("example")) {
          return addExample();
        }
        else if (name.equals("minValueDate")) {
          this.minValue = new DateType();
          return this.minValue;
        }
        else if (name.equals("minValueDateTime")) {
          this.minValue = new DateTimeType();
          return this.minValue;
        }
        else if (name.equals("minValueInstant")) {
          this.minValue = new InstantType();
          return this.minValue;
        }
        else if (name.equals("minValueTime")) {
          this.minValue = new TimeType();
          return this.minValue;
        }
        else if (name.equals("minValueDecimal")) {
          this.minValue = new DecimalType();
          return this.minValue;
        }
        else if (name.equals("minValueInteger")) {
          this.minValue = new IntegerType();
          return this.minValue;
        }
        else if (name.equals("minValueInteger64")) {
          this.minValue = new Integer64Type();
          return this.minValue;
        }
        else if (name.equals("minValuePositiveInt")) {
          this.minValue = new PositiveIntType();
          return this.minValue;
        }
        else if (name.equals("minValueUnsignedInt")) {
          this.minValue = new UnsignedIntType();
          return this.minValue;
        }
        else if (name.equals("minValueQuantity")) {
          this.minValue = new Quantity();
          return this.minValue;
        }
        else if (name.equals("maxValueDate")) {
          this.maxValue = new DateType();
          return this.maxValue;
        }
        else if (name.equals("maxValueDateTime")) {
          this.maxValue = new DateTimeType();
          return this.maxValue;
        }
        else if (name.equals("maxValueInstant")) {
          this.maxValue = new InstantType();
          return this.maxValue;
        }
        else if (name.equals("maxValueTime")) {
          this.maxValue = new TimeType();
          return this.maxValue;
        }
        else if (name.equals("maxValueDecimal")) {
          this.maxValue = new DecimalType();
          return this.maxValue;
        }
        else if (name.equals("maxValueInteger")) {
          this.maxValue = new IntegerType();
          return this.maxValue;
        }
        else if (name.equals("maxValueInteger64")) {
          this.maxValue = new Integer64Type();
          return this.maxValue;
        }
        else if (name.equals("maxValuePositiveInt")) {
          this.maxValue = new PositiveIntType();
          return this.maxValue;
        }
        else if (name.equals("maxValueUnsignedInt")) {
          this.maxValue = new UnsignedIntType();
          return this.maxValue;
        }
        else if (name.equals("maxValueQuantity")) {
          this.maxValue = new Quantity();
          return this.maxValue;
        }
        else if (name.equals("maxLength")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.maxLength");
        }
        else if (name.equals("condition")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.condition");
        }
        else if (name.equals("constraint")) {
          return addConstraint();
        }
        else if (name.equals("mustSupport")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.mustSupport");
        }
        else if (name.equals("isModifier")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.isModifier");
        }
        else if (name.equals("isModifierReason")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.isModifierReason");
        }
        else if (name.equals("isSummary")) {
          throw new FHIRException("Cannot call addChild on a primitive type ElementDefinition.isSummary");
        }
        else if (name.equals("binding")) {
          this.binding = new ElementDefinitionBindingComponent();
          return this.binding;
        }
        else if (name.equals("mapping")) {
          return addMapping();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ElementDefinition";

  }

      public ElementDefinition copy() {
        ElementDefinition dst = new ElementDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ElementDefinition dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        if (representation != null) {
          dst.representation = new ArrayList<Enumeration<PropertyRepresentation>>();
          for (Enumeration<PropertyRepresentation> i : representation)
            dst.representation.add(i.copy());
        };
        dst.sliceName = sliceName == null ? null : sliceName.copy();
        dst.sliceIsConstraining = sliceIsConstraining == null ? null : sliceIsConstraining.copy();
        dst.label = label == null ? null : label.copy();
        if (code != null) {
          dst.code = new ArrayList<Coding>();
          for (Coding i : code)
            dst.code.add(i.copy());
        };
        dst.slicing = slicing == null ? null : slicing.copy();
        dst.short_ = short_ == null ? null : short_.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.comment = comment == null ? null : comment.copy();
        dst.requirements = requirements == null ? null : requirements.copy();
        if (alias != null) {
          dst.alias = new ArrayList<StringType>();
          for (StringType i : alias)
            dst.alias.add(i.copy());
        };
        dst.min = min == null ? null : min.copy();
        dst.max = max == null ? null : max.copy();
        dst.base = base == null ? null : base.copy();
        dst.contentReference = contentReference == null ? null : contentReference.copy();
        if (type != null) {
          dst.type = new ArrayList<TypeRefComponent>();
          for (TypeRefComponent i : type)
            dst.type.add(i.copy());
        };
        dst.defaultValue = defaultValue == null ? null : defaultValue.copy();
        dst.meaningWhenMissing = meaningWhenMissing == null ? null : meaningWhenMissing.copy();
        dst.orderMeaning = orderMeaning == null ? null : orderMeaning.copy();
        dst.fixed = fixed == null ? null : fixed.copy();
        dst.pattern = pattern == null ? null : pattern.copy();
        if (example != null) {
          dst.example = new ArrayList<ElementDefinitionExampleComponent>();
          for (ElementDefinitionExampleComponent i : example)
            dst.example.add(i.copy());
        };
        dst.minValue = minValue == null ? null : minValue.copy();
        dst.maxValue = maxValue == null ? null : maxValue.copy();
        dst.maxLength = maxLength == null ? null : maxLength.copy();
        if (condition != null) {
          dst.condition = new ArrayList<IdType>();
          for (IdType i : condition)
            dst.condition.add(i.copy());
        };
        if (constraint != null) {
          dst.constraint = new ArrayList<ElementDefinitionConstraintComponent>();
          for (ElementDefinitionConstraintComponent i : constraint)
            dst.constraint.add(i.copy());
        };
        dst.mustSupport = mustSupport == null ? null : mustSupport.copy();
        dst.isModifier = isModifier == null ? null : isModifier.copy();
        dst.isModifierReason = isModifierReason == null ? null : isModifierReason.copy();
        dst.isSummary = isSummary == null ? null : isSummary.copy();
        dst.binding = binding == null ? null : binding.copy();
        if (mapping != null) {
          dst.mapping = new ArrayList<ElementDefinitionMappingComponent>();
          for (ElementDefinitionMappingComponent i : mapping)
            dst.mapping.add(i.copy());
        };
      }

      protected ElementDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ElementDefinition))
          return false;
        ElementDefinition o = (ElementDefinition) other_;
        return compareDeep(path, o.path, true) && compareDeep(representation, o.representation, true) && compareDeep(sliceName, o.sliceName, true)
           && compareDeep(sliceIsConstraining, o.sliceIsConstraining, true) && compareDeep(label, o.label, true)
           && compareDeep(code, o.code, true) && compareDeep(slicing, o.slicing, true) && compareDeep(short_, o.short_, true)
           && compareDeep(definition, o.definition, true) && compareDeep(comment, o.comment, true) && compareDeep(requirements, o.requirements, true)
           && compareDeep(alias, o.alias, true) && compareDeep(min, o.min, true) && compareDeep(max, o.max, true)
           && compareDeep(base, o.base, true) && compareDeep(contentReference, o.contentReference, true) && compareDeep(type, o.type, true)
           && compareDeep(defaultValue, o.defaultValue, true) && compareDeep(meaningWhenMissing, o.meaningWhenMissing, true)
           && compareDeep(orderMeaning, o.orderMeaning, true) && compareDeep(fixed, o.fixed, true) && compareDeep(pattern, o.pattern, true)
           && compareDeep(example, o.example, true) && compareDeep(minValue, o.minValue, true) && compareDeep(maxValue, o.maxValue, true)
           && compareDeep(maxLength, o.maxLength, true) && compareDeep(condition, o.condition, true) && compareDeep(constraint, o.constraint, true)
           && compareDeep(mustSupport, o.mustSupport, true) && compareDeep(isModifier, o.isModifier, true)
           && compareDeep(isModifierReason, o.isModifierReason, true) && compareDeep(isSummary, o.isSummary, true)
           && compareDeep(binding, o.binding, true) && compareDeep(mapping, o.mapping, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ElementDefinition))
          return false;
        ElementDefinition o = (ElementDefinition) other_;
        return compareValues(path, o.path, true) && compareValues(representation, o.representation, true) && compareValues(sliceName, o.sliceName, true)
           && compareValues(sliceIsConstraining, o.sliceIsConstraining, true) && compareValues(label, o.label, true)
           && compareValues(short_, o.short_, true) && compareValues(definition, o.definition, true) && compareValues(comment, o.comment, true)
           && compareValues(requirements, o.requirements, true) && compareValues(alias, o.alias, true) && compareValues(min, o.min, true)
           && compareValues(max, o.max, true) && compareValues(contentReference, o.contentReference, true) && compareValues(meaningWhenMissing, o.meaningWhenMissing, true)
           && compareValues(orderMeaning, o.orderMeaning, true) && compareValues(maxLength, o.maxLength, true)
           && compareValues(condition, o.condition, true) && compareValues(mustSupport, o.mustSupport, true) && compareValues(isModifier, o.isModifier, true)
           && compareValues(isModifierReason, o.isModifierReason, true) && compareValues(isSummary, o.isSummary, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, representation, sliceName
          , sliceIsConstraining, label, code, slicing, short_, definition, comment, requirements
          , alias, min, max, base, contentReference, type, defaultValue, meaningWhenMissing
          , orderMeaning, fixed, pattern, example, minValue, maxValue, maxLength, condition
          , constraint, mustSupport, isModifier, isModifierReason, isSummary, binding, mapping
          );
      }

// Manual code (from Configuration.txt)t:
  
  public String toString() {
    if (hasId())
      return getId();
    if (hasSliceName())
      return getPath()+":"+getSliceName();
    else
      return getPath();
  }
    
  public void makeBase(String path, int min, String max) {
    ElementDefinitionBaseComponent self = getBase();
    self.setPath(path);
    self.setMin(min);
    self.setMax(max);
  }
  
  public void makeBase() {
    ElementDefinitionBaseComponent self = getBase();
    self.setPath(getPath());
    self.setMin(getMin());
    self.setMax(getMax());
  }
 
  
  public String typeSummary() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (TypeRefComponent tr : getType()) {
      if (tr.hasCode())
        b.append(tr.getWorkingCode());
    }
    return b.toString();
  }
  
  public String typeSummaryVB() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder("|");
    for (TypeRefComponent tr : getType()) {
      if (tr.hasCode())
        b.append(tr.getWorkingCode());
    }
    return b.toString().replace(" ", "");
  }
  
  public TypeRefComponent getType(String code) {
    for (TypeRefComponent tr : getType()) 
      if (tr.getCode().equals(code))
        return tr;
    TypeRefComponent tr = new TypeRefComponent();
    tr.setCode(code);
    type.add(tr);
    return tr;
  }

  public static final boolean NOT_MODIFIER = false;
  public static final boolean NOT_IN_SUMMARY = false;
  public static final boolean IS_MODIFIER = true;
  public static final boolean IS_IN_SUMMARY = true;
  public ElementDefinition(boolean defaults, boolean modifier, boolean inSummary) {
    super();
    if (defaults) {
      setIsModifier(modifier);
      setIsSummary(inSummary);
    }
  }  

 public String present() {
    return hasId() ? getId() : getPath();
  }

  public boolean hasCondition(IdType id) {
    for (IdType c : getCondition()) {
      if (c.primitiveValue().equals(id.primitiveValue()))
        return true;
    }
    return false;
  }

  public boolean hasConstraint(String key) {
    for (ElementDefinitionConstraintComponent c : getConstraint()) {
      if (c.getKey().equals(key))
        return true;
    }
    return false;
  }

  public boolean hasCode(Coding c) {
    for (Coding t : getCode()) {
      if (t.getSystem().equals(c.getSystem()) && t.getCode().equals(c.getCode()))
        return true;
    }
    return false;
  }  

  public boolean isChoice() {
    return getPath().endsWith("[x]");
  }  

  public String getName() {
    return hasPath() ? getPath().contains(".") ? getPath().substring(getPath().lastIndexOf(".")+1) : getPath() : null;
  }

  public boolean unbounded() {
    return getMax().equals("*") || Integer.parseInt(getMax()) > 1;
  }

  public boolean isMandatory() {
    return getMin() > 0;
  }

  public boolean isInlineType() {
    return getType().size() == 1 && Utilities.existsInList(getType().get(0).getCode(), "Element", "BackboneElement");
  }  




// end addition

}