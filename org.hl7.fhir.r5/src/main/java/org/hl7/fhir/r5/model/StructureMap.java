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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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

import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
/**
 * A Map of relationships between 2 structures that can be used to transform data.
 */
@ResourceDef(name="StructureMap", profile="http://hl7.org/fhir/StructureDefinition/StructureMap")
public class StructureMap extends CanonicalResource {

    public enum StructureMapGroupTypeMode {
        /**
         * This group is a default mapping group for the specified types and for the primary source type.
         */
        TYPES, 
        /**
         * This group is a default mapping group for the specified types.
         */
        TYPEANDTYPES, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StructureMapGroupTypeMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("types".equals(codeString))
          return TYPES;
        if ("type-and-types".equals(codeString))
          return TYPEANDTYPES;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StructureMapGroupTypeMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case TYPES: return "types";
            case TYPEANDTYPES: return "type-and-types";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case TYPES: return "http://hl7.org/fhir/map-group-type-mode";
            case TYPEANDTYPES: return "http://hl7.org/fhir/map-group-type-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case TYPES: return "This group is a default mapping group for the specified types and for the primary source type.";
            case TYPEANDTYPES: return "This group is a default mapping group for the specified types.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case TYPES: return "Default for Type Combination";
            case TYPEANDTYPES: return "Default for type + combination";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StructureMapGroupTypeModeEnumFactory implements EnumFactory<StructureMapGroupTypeMode> {
    public StructureMapGroupTypeMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("types".equals(codeString))
          return StructureMapGroupTypeMode.TYPES;
        if ("type-and-types".equals(codeString))
          return StructureMapGroupTypeMode.TYPEANDTYPES;
        throw new IllegalArgumentException("Unknown StructureMapGroupTypeMode code '"+codeString+"'");
        }
        public Enumeration<StructureMapGroupTypeMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StructureMapGroupTypeMode>(this, StructureMapGroupTypeMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StructureMapGroupTypeMode>(this, StructureMapGroupTypeMode.NULL, code);
        if ("types".equals(codeString))
          return new Enumeration<StructureMapGroupTypeMode>(this, StructureMapGroupTypeMode.TYPES, code);
        if ("type-and-types".equals(codeString))
          return new Enumeration<StructureMapGroupTypeMode>(this, StructureMapGroupTypeMode.TYPEANDTYPES, code);
        throw new FHIRException("Unknown StructureMapGroupTypeMode code '"+codeString+"'");
        }
    public String toCode(StructureMapGroupTypeMode code) {
      if (code == StructureMapGroupTypeMode.TYPES)
        return "types";
      if (code == StructureMapGroupTypeMode.TYPEANDTYPES)
        return "type-and-types";
      return "?";
      }
    public String toSystem(StructureMapGroupTypeMode code) {
      return code.getSystem();
      }
    }

    public enum StructureMapInputMode {
        /**
         * Names an input instance used a source for mapping.
         */
        SOURCE, 
        /**
         * Names an instance that is being populated.
         */
        TARGET, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StructureMapInputMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("source".equals(codeString))
          return SOURCE;
        if ("target".equals(codeString))
          return TARGET;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StructureMapInputMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SOURCE: return "source";
            case TARGET: return "target";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SOURCE: return "http://hl7.org/fhir/map-input-mode";
            case TARGET: return "http://hl7.org/fhir/map-input-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SOURCE: return "Names an input instance used a source for mapping.";
            case TARGET: return "Names an instance that is being populated.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SOURCE: return "Source Instance";
            case TARGET: return "Target Instance";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StructureMapInputModeEnumFactory implements EnumFactory<StructureMapInputMode> {
    public StructureMapInputMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("source".equals(codeString))
          return StructureMapInputMode.SOURCE;
        if ("target".equals(codeString))
          return StructureMapInputMode.TARGET;
        throw new IllegalArgumentException("Unknown StructureMapInputMode code '"+codeString+"'");
        }
        public Enumeration<StructureMapInputMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StructureMapInputMode>(this, StructureMapInputMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StructureMapInputMode>(this, StructureMapInputMode.NULL, code);
        if ("source".equals(codeString))
          return new Enumeration<StructureMapInputMode>(this, StructureMapInputMode.SOURCE, code);
        if ("target".equals(codeString))
          return new Enumeration<StructureMapInputMode>(this, StructureMapInputMode.TARGET, code);
        throw new FHIRException("Unknown StructureMapInputMode code '"+codeString+"'");
        }
    public String toCode(StructureMapInputMode code) {
      if (code == StructureMapInputMode.SOURCE)
        return "source";
      if (code == StructureMapInputMode.TARGET)
        return "target";
      return "?";
      }
    public String toSystem(StructureMapInputMode code) {
      return code.getSystem();
      }
    }

    public enum StructureMapModelMode {
        /**
         * This structure describes an instance passed to the mapping engine that is used a source of data.
         */
        SOURCE, 
        /**
         * This structure describes an instance that the mapping engine may ask for that is used a source of data.
         */
        QUERIED, 
        /**
         * This structure describes an instance passed to the mapping engine that is used a target of data.
         */
        TARGET, 
        /**
         * This structure describes an instance that the mapping engine may ask to create that is used a target of data.
         */
        PRODUCED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StructureMapModelMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("source".equals(codeString))
          return SOURCE;
        if ("queried".equals(codeString))
          return QUERIED;
        if ("target".equals(codeString))
          return TARGET;
        if ("produced".equals(codeString))
          return PRODUCED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StructureMapModelMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SOURCE: return "source";
            case QUERIED: return "queried";
            case TARGET: return "target";
            case PRODUCED: return "produced";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SOURCE: return "http://hl7.org/fhir/map-model-mode";
            case QUERIED: return "http://hl7.org/fhir/map-model-mode";
            case TARGET: return "http://hl7.org/fhir/map-model-mode";
            case PRODUCED: return "http://hl7.org/fhir/map-model-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SOURCE: return "This structure describes an instance passed to the mapping engine that is used a source of data.";
            case QUERIED: return "This structure describes an instance that the mapping engine may ask for that is used a source of data.";
            case TARGET: return "This structure describes an instance passed to the mapping engine that is used a target of data.";
            case PRODUCED: return "This structure describes an instance that the mapping engine may ask to create that is used a target of data.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SOURCE: return "Source Structure Definition";
            case QUERIED: return "Queried Structure Definition";
            case TARGET: return "Target Structure Definition";
            case PRODUCED: return "Produced Structure Definition";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StructureMapModelModeEnumFactory implements EnumFactory<StructureMapModelMode> {
    public StructureMapModelMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("source".equals(codeString))
          return StructureMapModelMode.SOURCE;
        if ("queried".equals(codeString))
          return StructureMapModelMode.QUERIED;
        if ("target".equals(codeString))
          return StructureMapModelMode.TARGET;
        if ("produced".equals(codeString))
          return StructureMapModelMode.PRODUCED;
        throw new IllegalArgumentException("Unknown StructureMapModelMode code '"+codeString+"'");
        }
        public Enumeration<StructureMapModelMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StructureMapModelMode>(this, StructureMapModelMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StructureMapModelMode>(this, StructureMapModelMode.NULL, code);
        if ("source".equals(codeString))
          return new Enumeration<StructureMapModelMode>(this, StructureMapModelMode.SOURCE, code);
        if ("queried".equals(codeString))
          return new Enumeration<StructureMapModelMode>(this, StructureMapModelMode.QUERIED, code);
        if ("target".equals(codeString))
          return new Enumeration<StructureMapModelMode>(this, StructureMapModelMode.TARGET, code);
        if ("produced".equals(codeString))
          return new Enumeration<StructureMapModelMode>(this, StructureMapModelMode.PRODUCED, code);
        throw new FHIRException("Unknown StructureMapModelMode code '"+codeString+"'");
        }
    public String toCode(StructureMapModelMode code) {
      if (code == StructureMapModelMode.SOURCE)
        return "source";
      if (code == StructureMapModelMode.QUERIED)
        return "queried";
      if (code == StructureMapModelMode.TARGET)
        return "target";
      if (code == StructureMapModelMode.PRODUCED)
        return "produced";
      return "?";
      }
    public String toSystem(StructureMapModelMode code) {
      return code.getSystem();
      }
    }

    public enum StructureMapSourceListMode {
        /**
         * Only process this rule for the first in the list.
         */
        FIRST, 
        /**
         * Process this rule for all but the first.
         */
        NOTFIRST, 
        /**
         * Only process this rule for the last in the list.
         */
        LAST, 
        /**
         * Process this rule for all but the last.
         */
        NOTLAST, 
        /**
         * Only process this rule is there is only item.
         */
        ONLYONE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StructureMapSourceListMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("first".equals(codeString))
          return FIRST;
        if ("not_first".equals(codeString))
          return NOTFIRST;
        if ("last".equals(codeString))
          return LAST;
        if ("not_last".equals(codeString))
          return NOTLAST;
        if ("only_one".equals(codeString))
          return ONLYONE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StructureMapSourceListMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case FIRST: return "first";
            case NOTFIRST: return "not_first";
            case LAST: return "last";
            case NOTLAST: return "not_last";
            case ONLYONE: return "only_one";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case FIRST: return "http://hl7.org/fhir/map-source-list-mode";
            case NOTFIRST: return "http://hl7.org/fhir/map-source-list-mode";
            case LAST: return "http://hl7.org/fhir/map-source-list-mode";
            case NOTLAST: return "http://hl7.org/fhir/map-source-list-mode";
            case ONLYONE: return "http://hl7.org/fhir/map-source-list-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case FIRST: return "Only process this rule for the first in the list.";
            case NOTFIRST: return "Process this rule for all but the first.";
            case LAST: return "Only process this rule for the last in the list.";
            case NOTLAST: return "Process this rule for all but the last.";
            case ONLYONE: return "Only process this rule is there is only item.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case FIRST: return "First";
            case NOTFIRST: return "All but the first";
            case LAST: return "Last";
            case NOTLAST: return "All but the last";
            case ONLYONE: return "Enforce only one";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StructureMapSourceListModeEnumFactory implements EnumFactory<StructureMapSourceListMode> {
    public StructureMapSourceListMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("first".equals(codeString))
          return StructureMapSourceListMode.FIRST;
        if ("not_first".equals(codeString))
          return StructureMapSourceListMode.NOTFIRST;
        if ("last".equals(codeString))
          return StructureMapSourceListMode.LAST;
        if ("not_last".equals(codeString))
          return StructureMapSourceListMode.NOTLAST;
        if ("only_one".equals(codeString))
          return StructureMapSourceListMode.ONLYONE;
        throw new IllegalArgumentException("Unknown StructureMapSourceListMode code '"+codeString+"'");
        }
        public Enumeration<StructureMapSourceListMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.NULL, code);
        if ("first".equals(codeString))
          return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.FIRST, code);
        if ("not_first".equals(codeString))
          return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.NOTFIRST, code);
        if ("last".equals(codeString))
          return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.LAST, code);
        if ("not_last".equals(codeString))
          return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.NOTLAST, code);
        if ("only_one".equals(codeString))
          return new Enumeration<StructureMapSourceListMode>(this, StructureMapSourceListMode.ONLYONE, code);
        throw new FHIRException("Unknown StructureMapSourceListMode code '"+codeString+"'");
        }
    public String toCode(StructureMapSourceListMode code) {
      if (code == StructureMapSourceListMode.FIRST)
        return "first";
      if (code == StructureMapSourceListMode.NOTFIRST)
        return "not_first";
      if (code == StructureMapSourceListMode.LAST)
        return "last";
      if (code == StructureMapSourceListMode.NOTLAST)
        return "not_last";
      if (code == StructureMapSourceListMode.ONLYONE)
        return "only_one";
      return "?";
      }
    public String toSystem(StructureMapSourceListMode code) {
      return code.getSystem();
      }
    }

    public enum StructureMapTargetListMode {
        /**
         * when the target list is being assembled, the items for this rule go first. If more than one rule defines a first item (for a given instance of mapping) then this is an error.
         */
        FIRST, 
        /**
         * the target instance is shared with the target instances generated by another rule (up to the first common n items, then create new ones).
         */
        SHARE, 
        /**
         * when the target list is being assembled, the items for this rule go last. If more than one rule defines a last item (for a given instance of mapping) then this is an error.
         */
        LAST, 
        /**
         * the target instance is shared with a number of target instances generated by another rule (up to the first common n items, then create new ones).
         */
        SINGLE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StructureMapTargetListMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("first".equals(codeString))
          return FIRST;
        if ("share".equals(codeString))
          return SHARE;
        if ("last".equals(codeString))
          return LAST;
        if ("single".equals(codeString))
          return SINGLE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StructureMapTargetListMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case FIRST: return "first";
            case SHARE: return "share";
            case LAST: return "last";
            case SINGLE: return "single";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case FIRST: return "http://hl7.org/fhir/map-target-list-mode";
            case SHARE: return "http://hl7.org/fhir/map-target-list-mode";
            case LAST: return "http://hl7.org/fhir/map-target-list-mode";
            case SINGLE: return "http://hl7.org/fhir/map-target-list-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case FIRST: return "when the target list is being assembled, the items for this rule go first. If more than one rule defines a first item (for a given instance of mapping) then this is an error.";
            case SHARE: return "the target instance is shared with the target instances generated by another rule (up to the first common n items, then create new ones).";
            case LAST: return "when the target list is being assembled, the items for this rule go last. If more than one rule defines a last item (for a given instance of mapping) then this is an error.";
            case SINGLE: return "the target instance is shared with a number of target instances generated by another rule (up to the first common n items, then create new ones).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case FIRST: return "First";
            case SHARE: return "Share";
            case LAST: return "Last";
            case SINGLE: return "single";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StructureMapTargetListModeEnumFactory implements EnumFactory<StructureMapTargetListMode> {
    public StructureMapTargetListMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("first".equals(codeString))
          return StructureMapTargetListMode.FIRST;
        if ("share".equals(codeString))
          return StructureMapTargetListMode.SHARE;
        if ("last".equals(codeString))
          return StructureMapTargetListMode.LAST;
        if ("single".equals(codeString))
          return StructureMapTargetListMode.SINGLE;
        throw new IllegalArgumentException("Unknown StructureMapTargetListMode code '"+codeString+"'");
        }
        public Enumeration<StructureMapTargetListMode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StructureMapTargetListMode>(this, StructureMapTargetListMode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StructureMapTargetListMode>(this, StructureMapTargetListMode.NULL, code);
        if ("first".equals(codeString))
          return new Enumeration<StructureMapTargetListMode>(this, StructureMapTargetListMode.FIRST, code);
        if ("share".equals(codeString))
          return new Enumeration<StructureMapTargetListMode>(this, StructureMapTargetListMode.SHARE, code);
        if ("last".equals(codeString))
          return new Enumeration<StructureMapTargetListMode>(this, StructureMapTargetListMode.LAST, code);
        if ("single".equals(codeString))
          return new Enumeration<StructureMapTargetListMode>(this, StructureMapTargetListMode.SINGLE, code);
        throw new FHIRException("Unknown StructureMapTargetListMode code '"+codeString+"'");
        }
    public String toCode(StructureMapTargetListMode code) {
      if (code == StructureMapTargetListMode.FIRST)
        return "first";
      if (code == StructureMapTargetListMode.SHARE)
        return "share";
      if (code == StructureMapTargetListMode.LAST)
        return "last";
      if (code == StructureMapTargetListMode.SINGLE)
        return "single";
      return "?";
      }
    public String toSystem(StructureMapTargetListMode code) {
      return code.getSystem();
      }
    }

    public enum StructureMapTransform {
        /**
         * create(type : string) - type is passed through to the application on the standard API, and must be known by it.
         */
        CREATE, 
        /**
         * copy(source).
         */
        COPY, 
        /**
         * truncate(source, length) - source must be stringy type.
         */
        TRUNCATE, 
        /**
         * escape(source, fmt1, fmt2) - change source from one kind of escaping to another (plain, java, xml, json). note that this is for when the string itself is escaped.
         */
        ESCAPE, 
        /**
         * cast(source, type?) - cast (convert) source from one type to another. Target type can be left as implicit if there is one and only one target type known. The default namespace for the type is 'FHIR' (see [FHIRPath type specifiers](http://hl7.org/fhirpath/N1/#is-type-specifier))
         */
        CAST, 
        /**
         * append(source...) - source is element or string.
         */
        APPEND, 
        /**
         * translate(source, uri_of_map) - use the translate operation.
         */
        TRANSLATE, 
        /**
         * reference(source : object) - return a string that references the provided tree properly.
         */
        REFERENCE, 
        /**
         * Perform a date operation. *Parameters to be documented*.
         */
        DATEOP, 
        /**
         * Generate a random UUID (in lowercase). No Parameters.
         */
        UUID, 
        /**
         * Return the appropriate string to put in a reference that refers to the resource provided as a parameter.
         */
        POINTER, 
        /**
         * Execute the supplied FHIRPath expression and use the value returned by that.
         */
        EVALUATE, 
        /**
         * Create a CodeableConcept. Parameters = (text) or (system. Code[, display]).
         */
        CC, 
        /**
         * Create a Coding. Parameters = (system. Code[, display]).
         */
        C, 
        /**
         * Create a quantity. Parameters = (text) or (value, unit, [system, code]) where text is the natural representation e.g. [comparator]value[space]unit.
         */
        QTY, 
        /**
         * Create an identifier. Parameters = (system, value[, type]) where type is a code from the identifier type value set.
         */
        ID, 
        /**
         * Create a contact details. Parameters = (value) or (system, value). If no system is provided, the system should be inferred from the content of the value.
         */
        CP, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static StructureMapTransform fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return CREATE;
        if ("copy".equals(codeString))
          return COPY;
        if ("truncate".equals(codeString))
          return TRUNCATE;
        if ("escape".equals(codeString))
          return ESCAPE;
        if ("cast".equals(codeString))
          return CAST;
        if ("append".equals(codeString))
          return APPEND;
        if ("translate".equals(codeString))
          return TRANSLATE;
        if ("reference".equals(codeString))
          return REFERENCE;
        if ("dateOp".equals(codeString))
          return DATEOP;
        if ("uuid".equals(codeString))
          return UUID;
        if ("pointer".equals(codeString))
          return POINTER;
        if ("evaluate".equals(codeString))
          return EVALUATE;
        if ("cc".equals(codeString))
          return CC;
        if ("c".equals(codeString))
          return C;
        if ("qty".equals(codeString))
          return QTY;
        if ("id".equals(codeString))
          return ID;
        if ("cp".equals(codeString))
          return CP;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown StructureMapTransform code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CREATE: return "create";
            case COPY: return "copy";
            case TRUNCATE: return "truncate";
            case ESCAPE: return "escape";
            case CAST: return "cast";
            case APPEND: return "append";
            case TRANSLATE: return "translate";
            case REFERENCE: return "reference";
            case DATEOP: return "dateOp";
            case UUID: return "uuid";
            case POINTER: return "pointer";
            case EVALUATE: return "evaluate";
            case CC: return "cc";
            case C: return "c";
            case QTY: return "qty";
            case ID: return "id";
            case CP: return "cp";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CREATE: return "http://hl7.org/fhir/map-transform";
            case COPY: return "http://hl7.org/fhir/map-transform";
            case TRUNCATE: return "http://hl7.org/fhir/map-transform";
            case ESCAPE: return "http://hl7.org/fhir/map-transform";
            case CAST: return "http://hl7.org/fhir/map-transform";
            case APPEND: return "http://hl7.org/fhir/map-transform";
            case TRANSLATE: return "http://hl7.org/fhir/map-transform";
            case REFERENCE: return "http://hl7.org/fhir/map-transform";
            case DATEOP: return "http://hl7.org/fhir/map-transform";
            case UUID: return "http://hl7.org/fhir/map-transform";
            case POINTER: return "http://hl7.org/fhir/map-transform";
            case EVALUATE: return "http://hl7.org/fhir/map-transform";
            case CC: return "http://hl7.org/fhir/map-transform";
            case C: return "http://hl7.org/fhir/map-transform";
            case QTY: return "http://hl7.org/fhir/map-transform";
            case ID: return "http://hl7.org/fhir/map-transform";
            case CP: return "http://hl7.org/fhir/map-transform";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CREATE: return "create(type : string) - type is passed through to the application on the standard API, and must be known by it.";
            case COPY: return "copy(source).";
            case TRUNCATE: return "truncate(source, length) - source must be stringy type.";
            case ESCAPE: return "escape(source, fmt1, fmt2) - change source from one kind of escaping to another (plain, java, xml, json). note that this is for when the string itself is escaped.";
            case CAST: return "cast(source, type?) - cast (convert) source from one type to another. Target type can be left as implicit if there is one and only one target type known. The default namespace for the type is 'FHIR' (see [FHIRPath type specifiers](http://hl7.org/fhirpath/N1/#is-type-specifier))";
            case APPEND: return "append(source...) - source is element or string.";
            case TRANSLATE: return "translate(source, uri_of_map) - use the translate operation.";
            case REFERENCE: return "reference(source : object) - return a string that references the provided tree properly.";
            case DATEOP: return "Perform a date operation. *Parameters to be documented*.";
            case UUID: return "Generate a random UUID (in lowercase). No Parameters.";
            case POINTER: return "Return the appropriate string to put in a reference that refers to the resource provided as a parameter.";
            case EVALUATE: return "Execute the supplied FHIRPath expression and use the value returned by that.";
            case CC: return "Create a CodeableConcept. Parameters = (text) or (system. Code[, display]).";
            case C: return "Create a Coding. Parameters = (system. Code[, display]).";
            case QTY: return "Create a quantity. Parameters = (text) or (value, unit, [system, code]) where text is the natural representation e.g. [comparator]value[space]unit.";
            case ID: return "Create an identifier. Parameters = (system, value[, type]) where type is a code from the identifier type value set.";
            case CP: return "Create a contact details. Parameters = (value) or (system, value). If no system is provided, the system should be inferred from the content of the value.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CREATE: return "create";
            case COPY: return "copy";
            case TRUNCATE: return "truncate";
            case ESCAPE: return "escape";
            case CAST: return "cast";
            case APPEND: return "append";
            case TRANSLATE: return "translate";
            case REFERENCE: return "reference";
            case DATEOP: return "dateOp";
            case UUID: return "uuid";
            case POINTER: return "pointer";
            case EVALUATE: return "evaluate";
            case CC: return "cc";
            case C: return "c";
            case QTY: return "qty";
            case ID: return "id";
            case CP: return "cp";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class StructureMapTransformEnumFactory implements EnumFactory<StructureMapTransform> {
    public StructureMapTransform fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return StructureMapTransform.CREATE;
        if ("copy".equals(codeString))
          return StructureMapTransform.COPY;
        if ("truncate".equals(codeString))
          return StructureMapTransform.TRUNCATE;
        if ("escape".equals(codeString))
          return StructureMapTransform.ESCAPE;
        if ("cast".equals(codeString))
          return StructureMapTransform.CAST;
        if ("append".equals(codeString))
          return StructureMapTransform.APPEND;
        if ("translate".equals(codeString))
          return StructureMapTransform.TRANSLATE;
        if ("reference".equals(codeString))
          return StructureMapTransform.REFERENCE;
        if ("dateOp".equals(codeString))
          return StructureMapTransform.DATEOP;
        if ("uuid".equals(codeString))
          return StructureMapTransform.UUID;
        if ("pointer".equals(codeString))
          return StructureMapTransform.POINTER;
        if ("evaluate".equals(codeString))
          return StructureMapTransform.EVALUATE;
        if ("cc".equals(codeString))
          return StructureMapTransform.CC;
        if ("c".equals(codeString))
          return StructureMapTransform.C;
        if ("qty".equals(codeString))
          return StructureMapTransform.QTY;
        if ("id".equals(codeString))
          return StructureMapTransform.ID;
        if ("cp".equals(codeString))
          return StructureMapTransform.CP;
        throw new IllegalArgumentException("Unknown StructureMapTransform code '"+codeString+"'");
        }
        public Enumeration<StructureMapTransform> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<StructureMapTransform>(this, StructureMapTransform.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<StructureMapTransform>(this, StructureMapTransform.NULL, code);
        if ("create".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.CREATE, code);
        if ("copy".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.COPY, code);
        if ("truncate".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.TRUNCATE, code);
        if ("escape".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.ESCAPE, code);
        if ("cast".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.CAST, code);
        if ("append".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.APPEND, code);
        if ("translate".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.TRANSLATE, code);
        if ("reference".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.REFERENCE, code);
        if ("dateOp".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.DATEOP, code);
        if ("uuid".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.UUID, code);
        if ("pointer".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.POINTER, code);
        if ("evaluate".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.EVALUATE, code);
        if ("cc".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.CC, code);
        if ("c".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.C, code);
        if ("qty".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.QTY, code);
        if ("id".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.ID, code);
        if ("cp".equals(codeString))
          return new Enumeration<StructureMapTransform>(this, StructureMapTransform.CP, code);
        throw new FHIRException("Unknown StructureMapTransform code '"+codeString+"'");
        }
    public String toCode(StructureMapTransform code) {
      if (code == StructureMapTransform.CREATE)
        return "create";
      if (code == StructureMapTransform.COPY)
        return "copy";
      if (code == StructureMapTransform.TRUNCATE)
        return "truncate";
      if (code == StructureMapTransform.ESCAPE)
        return "escape";
      if (code == StructureMapTransform.CAST)
        return "cast";
      if (code == StructureMapTransform.APPEND)
        return "append";
      if (code == StructureMapTransform.TRANSLATE)
        return "translate";
      if (code == StructureMapTransform.REFERENCE)
        return "reference";
      if (code == StructureMapTransform.DATEOP)
        return "dateOp";
      if (code == StructureMapTransform.UUID)
        return "uuid";
      if (code == StructureMapTransform.POINTER)
        return "pointer";
      if (code == StructureMapTransform.EVALUATE)
        return "evaluate";
      if (code == StructureMapTransform.CC)
        return "cc";
      if (code == StructureMapTransform.C)
        return "c";
      if (code == StructureMapTransform.QTY)
        return "qty";
      if (code == StructureMapTransform.ID)
        return "id";
      if (code == StructureMapTransform.CP)
        return "cp";
      return "?";
      }
    public String toSystem(StructureMapTransform code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class StructureMapStructureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The canonical reference to the structure.
         */
        @Child(name = "url", type = {CanonicalType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Canonical reference to structure definition", formalDefinition="The canonical reference to the structure." )
        protected CanonicalType url;

        /**
         * How the referenced structure is used in this mapping.
         */
        @Child(name = "mode", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="source | queried | target | produced", formalDefinition="How the referenced structure is used in this mapping." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/map-model-mode")
        protected Enumeration<StructureMapModelMode> mode;

        /**
         * The name used for this type in the map.
         */
        @Child(name = "alias", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name for type in this map", formalDefinition="The name used for this type in the map." )
        protected StringType alias;

        /**
         * Documentation that describes how the structure is used in the mapping.
         */
        @Child(name = "documentation", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Documentation on use of structure", formalDefinition="Documentation that describes how the structure is used in the mapping." )
        protected StringType documentation;

        private static final long serialVersionUID = 364750586L;

    /**
     * Constructor
     */
      public StructureMapStructureComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapStructureComponent(String url, StructureMapModelMode mode) {
        super();
        this.setUrl(url);
        this.setMode(mode);
      }

        /**
         * @return {@link #url} (The canonical reference to the structure.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CanonicalType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapStructureComponent.url");
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
         * @param value {@link #url} (The canonical reference to the structure.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public StructureMapStructureComponent setUrlElement(CanonicalType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return The canonical reference to the structure.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value The canonical reference to the structure.
         */
        public StructureMapStructureComponent setUrl(String value) { 
            if (this.url == null)
              this.url = new CanonicalType();
            this.url.setValue(value);
          return this;
        }

        /**
         * @return {@link #mode} (How the referenced structure is used in this mapping.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public Enumeration<StructureMapModelMode> getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapStructureComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new Enumeration<StructureMapModelMode>(new StructureMapModelModeEnumFactory()); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (How the referenced structure is used in this mapping.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public StructureMapStructureComponent setModeElement(Enumeration<StructureMapModelMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return How the referenced structure is used in this mapping.
         */
        public StructureMapModelMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value How the referenced structure is used in this mapping.
         */
        public StructureMapStructureComponent setMode(StructureMapModelMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<StructureMapModelMode>(new StructureMapModelModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #alias} (The name used for this type in the map.). This is the underlying object with id, value and extensions. The accessor "getAlias" gives direct access to the value
         */
        public StringType getAliasElement() { 
          if (this.alias == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapStructureComponent.alias");
            else if (Configuration.doAutoCreate())
              this.alias = new StringType(); // bb
          return this.alias;
        }

        public boolean hasAliasElement() { 
          return this.alias != null && !this.alias.isEmpty();
        }

        public boolean hasAlias() { 
          return this.alias != null && !this.alias.isEmpty();
        }

        /**
         * @param value {@link #alias} (The name used for this type in the map.). This is the underlying object with id, value and extensions. The accessor "getAlias" gives direct access to the value
         */
        public StructureMapStructureComponent setAliasElement(StringType value) { 
          this.alias = value;
          return this;
        }

        /**
         * @return The name used for this type in the map.
         */
        public String getAlias() { 
          return this.alias == null ? null : this.alias.getValue();
        }

        /**
         * @param value The name used for this type in the map.
         */
        public StructureMapStructureComponent setAlias(String value) { 
          if (Utilities.noString(value))
            this.alias = null;
          else {
            if (this.alias == null)
              this.alias = new StringType();
            this.alias.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #documentation} (Documentation that describes how the structure is used in the mapping.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StringType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapStructureComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new StringType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Documentation that describes how the structure is used in the mapping.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StructureMapStructureComponent setDocumentationElement(StringType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Documentation that describes how the structure is used in the mapping.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Documentation that describes how the structure is used in the mapping.
         */
        public StructureMapStructureComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new StringType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("url", "canonical(StructureDefinition)", "The canonical reference to the structure.", 0, 1, url));
          children.add(new Property("mode", "code", "How the referenced structure is used in this mapping.", 0, 1, mode));
          children.add(new Property("alias", "string", "The name used for this type in the map.", 0, 1, alias));
          children.add(new Property("documentation", "string", "Documentation that describes how the structure is used in the mapping.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 116079: /*url*/  return new Property("url", "canonical(StructureDefinition)", "The canonical reference to the structure.", 0, 1, url);
          case 3357091: /*mode*/  return new Property("mode", "code", "How the referenced structure is used in this mapping.", 0, 1, mode);
          case 92902992: /*alias*/  return new Property("alias", "string", "The name used for this type in the map.", 0, 1, alias);
          case 1587405498: /*documentation*/  return new Property("documentation", "string", "Documentation that describes how the structure is used in the mapping.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // CanonicalType
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<StructureMapModelMode>
        case 92902992: /*alias*/ return this.alias == null ? new Base[0] : new Base[] {this.alias}; // StringType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 3357091: // mode
          value = new StructureMapModelModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<StructureMapModelMode>
          return value;
        case 92902992: // alias
          this.alias = TypeConvertor.castToString(value); // StringType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("mode")) {
          value = new StructureMapModelModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<StructureMapModelMode>
        } else if (name.equals("alias")) {
          this.alias = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case 3357091:  return getModeElement();
        case 92902992:  return getAliasElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"canonical"};
        case 3357091: /*mode*/ return new String[] {"code"};
        case 92902992: /*alias*/ return new String[] {"string"};
        case 1587405498: /*documentation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.structure.url");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.structure.mode");
        }
        else if (name.equals("alias")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.structure.alias");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.structure.documentation");
        }
        else
          return super.addChild(name);
      }

      public StructureMapStructureComponent copy() {
        StructureMapStructureComponent dst = new StructureMapStructureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapStructureComponent dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.mode = mode == null ? null : mode.copy();
        dst.alias = alias == null ? null : alias.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapStructureComponent))
          return false;
        StructureMapStructureComponent o = (StructureMapStructureComponent) other_;
        return compareDeep(url, o.url, true) && compareDeep(mode, o.mode, true) && compareDeep(alias, o.alias, true)
           && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapStructureComponent))
          return false;
        StructureMapStructureComponent o = (StructureMapStructureComponent) other_;
        return compareValues(url, o.url, true) && compareValues(mode, o.mode, true) && compareValues(alias, o.alias, true)
           && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, mode, alias, documentation
          );
      }

  public String fhirType() {
    return "StructureMap.structure";

  }

  }

    @Block()
    public static class StructureMapConstComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Other maps used by this map (canonical URLs).
         */
        @Child(name = "name", type = {IdType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Constant name", formalDefinition="Other maps used by this map (canonical URLs)." )
        protected IdType name;

        /**
         * A FHIRPath expression that is the value of this variable.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath exression - value of the constant", formalDefinition="A FHIRPath expression that is the value of this variable." )
        protected StringType value;

        private static final long serialVersionUID = 19170614L;

    /**
     * Constructor
     */
      public StructureMapConstComponent() {
        super();
      }

        /**
         * @return {@link #name} (Other maps used by this map (canonical URLs).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public IdType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapConstComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new IdType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Other maps used by this map (canonical URLs).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StructureMapConstComponent setNameElement(IdType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Other maps used by this map (canonical URLs).
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Other maps used by this map (canonical URLs).
         */
        public StructureMapConstComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new IdType();
            this.name.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #value} (A FHIRPath expression that is the value of this variable.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapConstComponent.value");
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
         * @param value {@link #value} (A FHIRPath expression that is the value of this variable.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StructureMapConstComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return A FHIRPath expression that is the value of this variable.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value A FHIRPath expression that is the value of this variable.
         */
        public StructureMapConstComponent setValue(String value) { 
          if (Utilities.noString(value))
            this.value = null;
          else {
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "id", "Other maps used by this map (canonical URLs).", 0, 1, name));
          children.add(new Property("value", "string", "A FHIRPath expression that is the value of this variable.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "id", "Other maps used by this map (canonical URLs).", 0, 1, name);
          case 111972721: /*value*/  return new Property("value", "string", "A FHIRPath expression that is the value of this variable.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // IdType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToId(value); // IdType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"id"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.const.name");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.const.value");
        }
        else
          return super.addChild(name);
      }

      public StructureMapConstComponent copy() {
        StructureMapConstComponent dst = new StructureMapConstComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapConstComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapConstComponent))
          return false;
        StructureMapConstComponent o = (StructureMapConstComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapConstComponent))
          return false;
        StructureMapConstComponent o = (StructureMapConstComponent) other_;
        return compareValues(name, o.name, true) && compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, value);
      }

  public String fhirType() {
    return "StructureMap.const";

  }

  }

    @Block()
    public static class StructureMapGroupComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A unique name for the group for the convenience of human readers.
         */
        @Child(name = "name", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Human-readable label", formalDefinition="A unique name for the group for the convenience of human readers." )
        protected IdType name;

        /**
         * Another group that this group adds rules to.
         */
        @Child(name = "extends", type = {IdType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Another group that this group adds rules to", formalDefinition="Another group that this group adds rules to." )
        protected IdType extends_;

        /**
         * If this is the default rule set to apply for the source type or this combination of types.
         */
        @Child(name = "typeMode", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="types | type-and-types", formalDefinition="If this is the default rule set to apply for the source type or this combination of types." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/map-group-type-mode")
        protected Enumeration<StructureMapGroupTypeMode> typeMode;

        /**
         * Additional supporting documentation that explains the purpose of the group and the types of mappings within it.
         */
        @Child(name = "documentation", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Additional description/explanation for group", formalDefinition="Additional supporting documentation that explains the purpose of the group and the types of mappings within it." )
        protected StringType documentation;

        /**
         * A name assigned to an instance of data. The instance must be provided when the mapping is invoked.
         */
        @Child(name = "input", type = {}, order=5, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Named instance provided when invoking the map", formalDefinition="A name assigned to an instance of data. The instance must be provided when the mapping is invoked." )
        protected List<StructureMapGroupInputComponent> input;

        /**
         * Transform Rule from source to target.
         */
        @Child(name = "rule", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Transform Rule from source to target", formalDefinition="Transform Rule from source to target." )
        protected List<StructureMapGroupRuleComponent> rule;

        private static final long serialVersionUID = -1474595081L;

    /**
     * Constructor
     */
      public StructureMapGroupComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapGroupComponent(String name, StructureMapGroupInputComponent input) {
        super();
        this.setName(name);
        this.addInput(input);
      }

        /**
         * @return {@link #name} (A unique name for the group for the convenience of human readers.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public IdType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new IdType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (A unique name for the group for the convenience of human readers.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StructureMapGroupComponent setNameElement(IdType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A unique name for the group for the convenience of human readers.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A unique name for the group for the convenience of human readers.
         */
        public StructureMapGroupComponent setName(String value) { 
            if (this.name == null)
              this.name = new IdType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #extends_} (Another group that this group adds rules to.). This is the underlying object with id, value and extensions. The accessor "getExtends" gives direct access to the value
         */
        public IdType getExtendsElement() { 
          if (this.extends_ == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupComponent.extends_");
            else if (Configuration.doAutoCreate())
              this.extends_ = new IdType(); // bb
          return this.extends_;
        }

        public boolean hasExtendsElement() { 
          return this.extends_ != null && !this.extends_.isEmpty();
        }

        public boolean hasExtends() { 
          return this.extends_ != null && !this.extends_.isEmpty();
        }

        /**
         * @param value {@link #extends_} (Another group that this group adds rules to.). This is the underlying object with id, value and extensions. The accessor "getExtends" gives direct access to the value
         */
        public StructureMapGroupComponent setExtendsElement(IdType value) { 
          this.extends_ = value;
          return this;
        }

        /**
         * @return Another group that this group adds rules to.
         */
        public String getExtends() { 
          return this.extends_ == null ? null : this.extends_.getValue();
        }

        /**
         * @param value Another group that this group adds rules to.
         */
        public StructureMapGroupComponent setExtends(String value) { 
          if (Utilities.noString(value))
            this.extends_ = null;
          else {
            if (this.extends_ == null)
              this.extends_ = new IdType();
            this.extends_.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #typeMode} (If this is the default rule set to apply for the source type or this combination of types.). This is the underlying object with id, value and extensions. The accessor "getTypeMode" gives direct access to the value
         */
        public Enumeration<StructureMapGroupTypeMode> getTypeModeElement() { 
          if (this.typeMode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupComponent.typeMode");
            else if (Configuration.doAutoCreate())
              this.typeMode = new Enumeration<StructureMapGroupTypeMode>(new StructureMapGroupTypeModeEnumFactory()); // bb
          return this.typeMode;
        }

        public boolean hasTypeModeElement() { 
          return this.typeMode != null && !this.typeMode.isEmpty();
        }

        public boolean hasTypeMode() { 
          return this.typeMode != null && !this.typeMode.isEmpty();
        }

        /**
         * @param value {@link #typeMode} (If this is the default rule set to apply for the source type or this combination of types.). This is the underlying object with id, value and extensions. The accessor "getTypeMode" gives direct access to the value
         */
        public StructureMapGroupComponent setTypeModeElement(Enumeration<StructureMapGroupTypeMode> value) { 
          this.typeMode = value;
          return this;
        }

        /**
         * @return If this is the default rule set to apply for the source type or this combination of types.
         */
        public StructureMapGroupTypeMode getTypeMode() { 
          return this.typeMode == null ? null : this.typeMode.getValue();
        }

        /**
         * @param value If this is the default rule set to apply for the source type or this combination of types.
         */
        public StructureMapGroupComponent setTypeMode(StructureMapGroupTypeMode value) { 
          if (value == null)
            this.typeMode = null;
          else {
            if (this.typeMode == null)
              this.typeMode = new Enumeration<StructureMapGroupTypeMode>(new StructureMapGroupTypeModeEnumFactory());
            this.typeMode.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #documentation} (Additional supporting documentation that explains the purpose of the group and the types of mappings within it.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StringType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new StringType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Additional supporting documentation that explains the purpose of the group and the types of mappings within it.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StructureMapGroupComponent setDocumentationElement(StringType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Additional supporting documentation that explains the purpose of the group and the types of mappings within it.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Additional supporting documentation that explains the purpose of the group and the types of mappings within it.
         */
        public StructureMapGroupComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new StringType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #input} (A name assigned to an instance of data. The instance must be provided when the mapping is invoked.)
         */
        public List<StructureMapGroupInputComponent> getInput() { 
          if (this.input == null)
            this.input = new ArrayList<StructureMapGroupInputComponent>();
          return this.input;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupComponent setInput(List<StructureMapGroupInputComponent> theInput) { 
          this.input = theInput;
          return this;
        }

        public boolean hasInput() { 
          if (this.input == null)
            return false;
          for (StructureMapGroupInputComponent item : this.input)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupInputComponent addInput() { //3
          StructureMapGroupInputComponent t = new StructureMapGroupInputComponent();
          if (this.input == null)
            this.input = new ArrayList<StructureMapGroupInputComponent>();
          this.input.add(t);
          return t;
        }

        public StructureMapGroupComponent addInput(StructureMapGroupInputComponent t) { //3
          if (t == null)
            return this;
          if (this.input == null)
            this.input = new ArrayList<StructureMapGroupInputComponent>();
          this.input.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #input}, creating it if it does not already exist {3}
         */
        public StructureMapGroupInputComponent getInputFirstRep() { 
          if (getInput().isEmpty()) {
            addInput();
          }
          return getInput().get(0);
        }

        /**
         * @return {@link #rule} (Transform Rule from source to target.)
         */
        public List<StructureMapGroupRuleComponent> getRule() { 
          if (this.rule == null)
            this.rule = new ArrayList<StructureMapGroupRuleComponent>();
          return this.rule;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupComponent setRule(List<StructureMapGroupRuleComponent> theRule) { 
          this.rule = theRule;
          return this;
        }

        public boolean hasRule() { 
          if (this.rule == null)
            return false;
          for (StructureMapGroupRuleComponent item : this.rule)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleComponent addRule() { //3
          StructureMapGroupRuleComponent t = new StructureMapGroupRuleComponent();
          if (this.rule == null)
            this.rule = new ArrayList<StructureMapGroupRuleComponent>();
          this.rule.add(t);
          return t;
        }

        public StructureMapGroupComponent addRule(StructureMapGroupRuleComponent t) { //3
          if (t == null)
            return this;
          if (this.rule == null)
            this.rule = new ArrayList<StructureMapGroupRuleComponent>();
          this.rule.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #rule}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleComponent getRuleFirstRep() { 
          if (getRule().isEmpty()) {
            addRule();
          }
          return getRule().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "id", "A unique name for the group for the convenience of human readers.", 0, 1, name));
          children.add(new Property("extends", "id", "Another group that this group adds rules to.", 0, 1, extends_));
          children.add(new Property("typeMode", "code", "If this is the default rule set to apply for the source type or this combination of types.", 0, 1, typeMode));
          children.add(new Property("documentation", "string", "Additional supporting documentation that explains the purpose of the group and the types of mappings within it.", 0, 1, documentation));
          children.add(new Property("input", "", "A name assigned to an instance of data. The instance must be provided when the mapping is invoked.", 0, java.lang.Integer.MAX_VALUE, input));
          children.add(new Property("rule", "", "Transform Rule from source to target.", 0, java.lang.Integer.MAX_VALUE, rule));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "id", "A unique name for the group for the convenience of human readers.", 0, 1, name);
          case -1305664359: /*extends*/  return new Property("extends", "id", "Another group that this group adds rules to.", 0, 1, extends_);
          case -676524035: /*typeMode*/  return new Property("typeMode", "code", "If this is the default rule set to apply for the source type or this combination of types.", 0, 1, typeMode);
          case 1587405498: /*documentation*/  return new Property("documentation", "string", "Additional supporting documentation that explains the purpose of the group and the types of mappings within it.", 0, 1, documentation);
          case 100358090: /*input*/  return new Property("input", "", "A name assigned to an instance of data. The instance must be provided when the mapping is invoked.", 0, java.lang.Integer.MAX_VALUE, input);
          case 3512060: /*rule*/  return new Property("rule", "", "Transform Rule from source to target.", 0, java.lang.Integer.MAX_VALUE, rule);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // IdType
        case -1305664359: /*extends*/ return this.extends_ == null ? new Base[0] : new Base[] {this.extends_}; // IdType
        case -676524035: /*typeMode*/ return this.typeMode == null ? new Base[0] : new Base[] {this.typeMode}; // Enumeration<StructureMapGroupTypeMode>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // StringType
        case 100358090: /*input*/ return this.input == null ? new Base[0] : this.input.toArray(new Base[this.input.size()]); // StructureMapGroupInputComponent
        case 3512060: /*rule*/ return this.rule == null ? new Base[0] : this.rule.toArray(new Base[this.rule.size()]); // StructureMapGroupRuleComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToId(value); // IdType
          return value;
        case -1305664359: // extends
          this.extends_ = TypeConvertor.castToId(value); // IdType
          return value;
        case -676524035: // typeMode
          value = new StructureMapGroupTypeModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.typeMode = (Enumeration) value; // Enumeration<StructureMapGroupTypeMode>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToString(value); // StringType
          return value;
        case 100358090: // input
          this.getInput().add((StructureMapGroupInputComponent) value); // StructureMapGroupInputComponent
          return value;
        case 3512060: // rule
          this.getRule().add((StructureMapGroupRuleComponent) value); // StructureMapGroupRuleComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("extends")) {
          this.extends_ = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("typeMode")) {
          value = new StructureMapGroupTypeModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.typeMode = (Enumeration) value; // Enumeration<StructureMapGroupTypeMode>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("input")) {
          this.getInput().add((StructureMapGroupInputComponent) value);
        } else if (name.equals("rule")) {
          this.getRule().add((StructureMapGroupRuleComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1305664359:  return getExtendsElement();
        case -676524035:  return getTypeModeElement();
        case 1587405498:  return getDocumentationElement();
        case 100358090:  return addInput(); 
        case 3512060:  return addRule(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"id"};
        case -1305664359: /*extends*/ return new String[] {"id"};
        case -676524035: /*typeMode*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"string"};
        case 100358090: /*input*/ return new String[] {};
        case 3512060: /*rule*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.name");
        }
        else if (name.equals("extends")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.extends");
        }
        else if (name.equals("typeMode")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.typeMode");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.documentation");
        }
        else if (name.equals("input")) {
          return addInput();
        }
        else if (name.equals("rule")) {
          return addRule();
        }
        else
          return super.addChild(name);
      }

      public StructureMapGroupComponent copy() {
        StructureMapGroupComponent dst = new StructureMapGroupComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.extends_ = extends_ == null ? null : extends_.copy();
        dst.typeMode = typeMode == null ? null : typeMode.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
        if (input != null) {
          dst.input = new ArrayList<StructureMapGroupInputComponent>();
          for (StructureMapGroupInputComponent i : input)
            dst.input.add(i.copy());
        };
        if (rule != null) {
          dst.rule = new ArrayList<StructureMapGroupRuleComponent>();
          for (StructureMapGroupRuleComponent i : rule)
            dst.rule.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupComponent))
          return false;
        StructureMapGroupComponent o = (StructureMapGroupComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(extends_, o.extends_, true) && compareDeep(typeMode, o.typeMode, true)
           && compareDeep(documentation, o.documentation, true) && compareDeep(input, o.input, true) && compareDeep(rule, o.rule, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupComponent))
          return false;
        StructureMapGroupComponent o = (StructureMapGroupComponent) other_;
        return compareValues(name, o.name, true) && compareValues(extends_, o.extends_, true) && compareValues(typeMode, o.typeMode, true)
           && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, extends_, typeMode
          , documentation, input, rule);
      }

  public String fhirType() {
    return "StructureMap.group";

  }

// added from java-adornments.txt:
public String toString() {
    return StructureMapUtilities.groupToString(this);
  }
// end addition
  }

    @Block()
    public static class StructureMapGroupInputComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name for this instance of data.
         */
        @Child(name = "name", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name for this instance of data", formalDefinition="Name for this instance of data." )
        protected IdType name;

        /**
         * Type for this instance of data.
         */
        @Child(name = "type", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type for this instance of data", formalDefinition="Type for this instance of data." )
        protected StringType type;

        /**
         * Mode for this instance of data.
         */
        @Child(name = "mode", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="source | target", formalDefinition="Mode for this instance of data." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/map-input-mode")
        protected Enumeration<StructureMapInputMode> mode;

        /**
         * Documentation for this instance of data.
         */
        @Child(name = "documentation", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Documentation for this instance of data", formalDefinition="Documentation for this instance of data." )
        protected StringType documentation;

        private static final long serialVersionUID = -25050724L;

    /**
     * Constructor
     */
      public StructureMapGroupInputComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapGroupInputComponent(String name, StructureMapInputMode mode) {
        super();
        this.setName(name);
        this.setMode(mode);
      }

        /**
         * @return {@link #name} (Name for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public IdType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupInputComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new IdType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StructureMapGroupInputComponent setNameElement(IdType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name for this instance of data.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name for this instance of data.
         */
        public StructureMapGroupInputComponent setName(String value) { 
            if (this.name == null)
              this.name = new IdType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Type for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public StringType getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupInputComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new StringType(); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public StructureMapGroupInputComponent setTypeElement(StringType value) { 
          this.type = value;
          return this;
        }

        /**
         * @return Type for this instance of data.
         */
        public String getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value Type for this instance of data.
         */
        public StructureMapGroupInputComponent setType(String value) { 
          if (Utilities.noString(value))
            this.type = null;
          else {
            if (this.type == null)
              this.type = new StringType();
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #mode} (Mode for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public Enumeration<StructureMapInputMode> getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupInputComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new Enumeration<StructureMapInputMode>(new StructureMapInputModeEnumFactory()); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (Mode for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public StructureMapGroupInputComponent setModeElement(Enumeration<StructureMapInputMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return Mode for this instance of data.
         */
        public StructureMapInputMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value Mode for this instance of data.
         */
        public StructureMapGroupInputComponent setMode(StructureMapInputMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<StructureMapInputMode>(new StructureMapInputModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Documentation for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StringType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupInputComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new StringType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Documentation for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StructureMapGroupInputComponent setDocumentationElement(StringType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Documentation for this instance of data.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Documentation for this instance of data.
         */
        public StructureMapGroupInputComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new StringType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "id", "Name for this instance of data.", 0, 1, name));
          children.add(new Property("type", "string", "Type for this instance of data.", 0, 1, type));
          children.add(new Property("mode", "code", "Mode for this instance of data.", 0, 1, mode));
          children.add(new Property("documentation", "string", "Documentation for this instance of data.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "id", "Name for this instance of data.", 0, 1, name);
          case 3575610: /*type*/  return new Property("type", "string", "Type for this instance of data.", 0, 1, type);
          case 3357091: /*mode*/  return new Property("mode", "code", "Mode for this instance of data.", 0, 1, mode);
          case 1587405498: /*documentation*/  return new Property("documentation", "string", "Documentation for this instance of data.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // IdType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // StringType
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<StructureMapInputMode>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToId(value); // IdType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToString(value); // StringType
          return value;
        case 3357091: // mode
          value = new StructureMapInputModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<StructureMapInputMode>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("mode")) {
          value = new StructureMapInputModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<StructureMapInputMode>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3575610:  return getTypeElement();
        case 3357091:  return getModeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"id"};
        case 3575610: /*type*/ return new String[] {"string"};
        case 3357091: /*mode*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.input.name");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.input.type");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.input.mode");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.input.documentation");
        }
        else
          return super.addChild(name);
      }

      public StructureMapGroupInputComponent copy() {
        StructureMapGroupInputComponent dst = new StructureMapGroupInputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupInputComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
        dst.mode = mode == null ? null : mode.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupInputComponent))
          return false;
        StructureMapGroupInputComponent o = (StructureMapGroupInputComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(type, o.type, true) && compareDeep(mode, o.mode, true)
           && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupInputComponent))
          return false;
        StructureMapGroupInputComponent o = (StructureMapGroupInputComponent) other_;
        return compareValues(name, o.name, true) && compareValues(type, o.type, true) && compareValues(mode, o.mode, true)
           && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, type, mode, documentation
          );
      }

  public String fhirType() {
    return "StructureMap.group.input";

  }

  }

    @Block()
    public static class StructureMapGroupRuleComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name of the rule for internal references.
         */
        @Child(name = "name", type = {IdType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name of the rule for internal references", formalDefinition="Name of the rule for internal references." )
        protected IdType name;

        /**
         * Source inputs to the mapping.
         */
        @Child(name = "source", type = {}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Source inputs to the mapping", formalDefinition="Source inputs to the mapping." )
        protected List<StructureMapGroupRuleSourceComponent> source;

        /**
         * Content to create because of this mapping rule.
         */
        @Child(name = "target", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Content to create because of this mapping rule", formalDefinition="Content to create because of this mapping rule." )
        protected List<StructureMapGroupRuleTargetComponent> target;

        /**
         * Rules contained in this rule.
         */
        @Child(name = "rule", type = {StructureMapGroupRuleComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Rules contained in this rule", formalDefinition="Rules contained in this rule." )
        protected List<StructureMapGroupRuleComponent> rule;

        /**
         * Which other rules to apply in the context of this rule.
         */
        @Child(name = "dependent", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Which other rules to apply in the context of this rule", formalDefinition="Which other rules to apply in the context of this rule." )
        protected List<StructureMapGroupRuleDependentComponent> dependent;

        /**
         * Documentation for this instance of data.
         */
        @Child(name = "documentation", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Documentation for this instance of data", formalDefinition="Documentation for this instance of data." )
        protected StringType documentation;

        private static final long serialVersionUID = 773925517L;

    /**
     * Constructor
     */
      public StructureMapGroupRuleComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapGroupRuleComponent(StructureMapGroupRuleSourceComponent source) {
        super();
        this.addSource(source);
      }

        /**
         * @return {@link #name} (Name of the rule for internal references.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public IdType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new IdType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name of the rule for internal references.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StructureMapGroupRuleComponent setNameElement(IdType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of the rule for internal references.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of the rule for internal references.
         */
        public StructureMapGroupRuleComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new IdType();
            this.name.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #source} (Source inputs to the mapping.)
         */
        public List<StructureMapGroupRuleSourceComponent> getSource() { 
          if (this.source == null)
            this.source = new ArrayList<StructureMapGroupRuleSourceComponent>();
          return this.source;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleComponent setSource(List<StructureMapGroupRuleSourceComponent> theSource) { 
          this.source = theSource;
          return this;
        }

        public boolean hasSource() { 
          if (this.source == null)
            return false;
          for (StructureMapGroupRuleSourceComponent item : this.source)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleSourceComponent addSource() { //3
          StructureMapGroupRuleSourceComponent t = new StructureMapGroupRuleSourceComponent();
          if (this.source == null)
            this.source = new ArrayList<StructureMapGroupRuleSourceComponent>();
          this.source.add(t);
          return t;
        }

        public StructureMapGroupRuleComponent addSource(StructureMapGroupRuleSourceComponent t) { //3
          if (t == null)
            return this;
          if (this.source == null)
            this.source = new ArrayList<StructureMapGroupRuleSourceComponent>();
          this.source.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleSourceComponent getSourceFirstRep() { 
          if (getSource().isEmpty()) {
            addSource();
          }
          return getSource().get(0);
        }

        /**
         * @return {@link #target} (Content to create because of this mapping rule.)
         */
        public List<StructureMapGroupRuleTargetComponent> getTarget() { 
          if (this.target == null)
            this.target = new ArrayList<StructureMapGroupRuleTargetComponent>();
          return this.target;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleComponent setTarget(List<StructureMapGroupRuleTargetComponent> theTarget) { 
          this.target = theTarget;
          return this;
        }

        public boolean hasTarget() { 
          if (this.target == null)
            return false;
          for (StructureMapGroupRuleTargetComponent item : this.target)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleTargetComponent addTarget() { //3
          StructureMapGroupRuleTargetComponent t = new StructureMapGroupRuleTargetComponent();
          if (this.target == null)
            this.target = new ArrayList<StructureMapGroupRuleTargetComponent>();
          this.target.add(t);
          return t;
        }

        public StructureMapGroupRuleComponent addTarget(StructureMapGroupRuleTargetComponent t) { //3
          if (t == null)
            return this;
          if (this.target == null)
            this.target = new ArrayList<StructureMapGroupRuleTargetComponent>();
          this.target.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #target}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleTargetComponent getTargetFirstRep() { 
          if (getTarget().isEmpty()) {
            addTarget();
          }
          return getTarget().get(0);
        }

        /**
         * @return {@link #rule} (Rules contained in this rule.)
         */
        public List<StructureMapGroupRuleComponent> getRule() { 
          if (this.rule == null)
            this.rule = new ArrayList<StructureMapGroupRuleComponent>();
          return this.rule;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleComponent setRule(List<StructureMapGroupRuleComponent> theRule) { 
          this.rule = theRule;
          return this;
        }

        public boolean hasRule() { 
          if (this.rule == null)
            return false;
          for (StructureMapGroupRuleComponent item : this.rule)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleComponent addRule() { //3
          StructureMapGroupRuleComponent t = new StructureMapGroupRuleComponent();
          if (this.rule == null)
            this.rule = new ArrayList<StructureMapGroupRuleComponent>();
          this.rule.add(t);
          return t;
        }

        public StructureMapGroupRuleComponent addRule(StructureMapGroupRuleComponent t) { //3
          if (t == null)
            return this;
          if (this.rule == null)
            this.rule = new ArrayList<StructureMapGroupRuleComponent>();
          this.rule.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #rule}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleComponent getRuleFirstRep() { 
          if (getRule().isEmpty()) {
            addRule();
          }
          return getRule().get(0);
        }

        /**
         * @return {@link #dependent} (Which other rules to apply in the context of this rule.)
         */
        public List<StructureMapGroupRuleDependentComponent> getDependent() { 
          if (this.dependent == null)
            this.dependent = new ArrayList<StructureMapGroupRuleDependentComponent>();
          return this.dependent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleComponent setDependent(List<StructureMapGroupRuleDependentComponent> theDependent) { 
          this.dependent = theDependent;
          return this;
        }

        public boolean hasDependent() { 
          if (this.dependent == null)
            return false;
          for (StructureMapGroupRuleDependentComponent item : this.dependent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleDependentComponent addDependent() { //3
          StructureMapGroupRuleDependentComponent t = new StructureMapGroupRuleDependentComponent();
          if (this.dependent == null)
            this.dependent = new ArrayList<StructureMapGroupRuleDependentComponent>();
          this.dependent.add(t);
          return t;
        }

        public StructureMapGroupRuleComponent addDependent(StructureMapGroupRuleDependentComponent t) { //3
          if (t == null)
            return this;
          if (this.dependent == null)
            this.dependent = new ArrayList<StructureMapGroupRuleDependentComponent>();
          this.dependent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dependent}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleDependentComponent getDependentFirstRep() { 
          if (getDependent().isEmpty()) {
            addDependent();
          }
          return getDependent().get(0);
        }

        /**
         * @return {@link #documentation} (Documentation for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StringType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new StringType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Documentation for this instance of data.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StructureMapGroupRuleComponent setDocumentationElement(StringType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Documentation for this instance of data.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Documentation for this instance of data.
         */
        public StructureMapGroupRuleComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new StringType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "id", "Name of the rule for internal references.", 0, 1, name));
          children.add(new Property("source", "", "Source inputs to the mapping.", 0, java.lang.Integer.MAX_VALUE, source));
          children.add(new Property("target", "", "Content to create because of this mapping rule.", 0, java.lang.Integer.MAX_VALUE, target));
          children.add(new Property("rule", "@StructureMap.group.rule", "Rules contained in this rule.", 0, java.lang.Integer.MAX_VALUE, rule));
          children.add(new Property("dependent", "", "Which other rules to apply in the context of this rule.", 0, java.lang.Integer.MAX_VALUE, dependent));
          children.add(new Property("documentation", "string", "Documentation for this instance of data.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "id", "Name of the rule for internal references.", 0, 1, name);
          case -896505829: /*source*/  return new Property("source", "", "Source inputs to the mapping.", 0, java.lang.Integer.MAX_VALUE, source);
          case -880905839: /*target*/  return new Property("target", "", "Content to create because of this mapping rule.", 0, java.lang.Integer.MAX_VALUE, target);
          case 3512060: /*rule*/  return new Property("rule", "@StructureMap.group.rule", "Rules contained in this rule.", 0, java.lang.Integer.MAX_VALUE, rule);
          case -1109226753: /*dependent*/  return new Property("dependent", "", "Which other rules to apply in the context of this rule.", 0, java.lang.Integer.MAX_VALUE, dependent);
          case 1587405498: /*documentation*/  return new Property("documentation", "string", "Documentation for this instance of data.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // IdType
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // StructureMapGroupRuleSourceComponent
        case -880905839: /*target*/ return this.target == null ? new Base[0] : this.target.toArray(new Base[this.target.size()]); // StructureMapGroupRuleTargetComponent
        case 3512060: /*rule*/ return this.rule == null ? new Base[0] : this.rule.toArray(new Base[this.rule.size()]); // StructureMapGroupRuleComponent
        case -1109226753: /*dependent*/ return this.dependent == null ? new Base[0] : this.dependent.toArray(new Base[this.dependent.size()]); // StructureMapGroupRuleDependentComponent
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToId(value); // IdType
          return value;
        case -896505829: // source
          this.getSource().add((StructureMapGroupRuleSourceComponent) value); // StructureMapGroupRuleSourceComponent
          return value;
        case -880905839: // target
          this.getTarget().add((StructureMapGroupRuleTargetComponent) value); // StructureMapGroupRuleTargetComponent
          return value;
        case 3512060: // rule
          this.getRule().add((StructureMapGroupRuleComponent) value); // StructureMapGroupRuleComponent
          return value;
        case -1109226753: // dependent
          this.getDependent().add((StructureMapGroupRuleDependentComponent) value); // StructureMapGroupRuleDependentComponent
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("source")) {
          this.getSource().add((StructureMapGroupRuleSourceComponent) value);
        } else if (name.equals("target")) {
          this.getTarget().add((StructureMapGroupRuleTargetComponent) value);
        } else if (name.equals("rule")) {
          this.getRule().add((StructureMapGroupRuleComponent) value);
        } else if (name.equals("dependent")) {
          this.getDependent().add((StructureMapGroupRuleDependentComponent) value);
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -896505829:  return addSource(); 
        case -880905839:  return addTarget(); 
        case 3512060:  return addRule(); 
        case -1109226753:  return addDependent(); 
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"id"};
        case -896505829: /*source*/ return new String[] {};
        case -880905839: /*target*/ return new String[] {};
        case 3512060: /*rule*/ return new String[] {"@StructureMap.group.rule"};
        case -1109226753: /*dependent*/ return new String[] {};
        case 1587405498: /*documentation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.name");
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else if (name.equals("target")) {
          return addTarget();
        }
        else if (name.equals("rule")) {
          return addRule();
        }
        else if (name.equals("dependent")) {
          return addDependent();
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.documentation");
        }
        else
          return super.addChild(name);
      }

      public StructureMapGroupRuleComponent copy() {
        StructureMapGroupRuleComponent dst = new StructureMapGroupRuleComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupRuleComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (source != null) {
          dst.source = new ArrayList<StructureMapGroupRuleSourceComponent>();
          for (StructureMapGroupRuleSourceComponent i : source)
            dst.source.add(i.copy());
        };
        if (target != null) {
          dst.target = new ArrayList<StructureMapGroupRuleTargetComponent>();
          for (StructureMapGroupRuleTargetComponent i : target)
            dst.target.add(i.copy());
        };
        if (rule != null) {
          dst.rule = new ArrayList<StructureMapGroupRuleComponent>();
          for (StructureMapGroupRuleComponent i : rule)
            dst.rule.add(i.copy());
        };
        if (dependent != null) {
          dst.dependent = new ArrayList<StructureMapGroupRuleDependentComponent>();
          for (StructureMapGroupRuleDependentComponent i : dependent)
            dst.dependent.add(i.copy());
        };
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleComponent))
          return false;
        StructureMapGroupRuleComponent o = (StructureMapGroupRuleComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(source, o.source, true) && compareDeep(target, o.target, true)
           && compareDeep(rule, o.rule, true) && compareDeep(dependent, o.dependent, true) && compareDeep(documentation, o.documentation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleComponent))
          return false;
        StructureMapGroupRuleComponent o = (StructureMapGroupRuleComponent) other_;
        return compareValues(name, o.name, true) && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, source, target, rule
          , dependent, documentation);
      }

  public String fhirType() {
    return "StructureMap.group.rule";

  }

// added from java-adornments.txt:
public String toString() {
    return StructureMapUtilities.ruleToString(this);
  }
// end addition
  }

    @Block()
    public static class StructureMapGroupRuleSourceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Type or variable this rule applies to.
         */
        @Child(name = "context", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type or variable this rule applies to", formalDefinition="Type or variable this rule applies to." )
        protected IdType context;

        /**
         * Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.
         */
        @Child(name = "min", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Specified minimum cardinality", formalDefinition="Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content." )
        protected IntegerType min;

        /**
         * Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).
         */
        @Child(name = "max", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Specified maximum cardinality (number or *)", formalDefinition="Specified maximum cardinality for the element - a number or a \"*\". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value)." )
        protected StringType max;

        /**
         * Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.
         */
        @Child(name = "type", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Rule only applies if source has this type", formalDefinition="Specified type for the element. This works as a condition on the mapping - use for polymorphic elements." )
        protected StringType type;

        /**
         * A value to use if there is no existing value in the source object.
         */
        @Child(name = "defaultValue", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Default value if no value exists", formalDefinition="A value to use if there is no existing value in the source object." )
        protected StringType defaultValue;

        /**
         * Optional field for this source.
         */
        @Child(name = "element", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Optional field for this source", formalDefinition="Optional field for this source." )
        protected StringType element;

        /**
         * How to handle the list mode for this element.
         */
        @Child(name = "listMode", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="first | not_first | last | not_last | only_one", formalDefinition="How to handle the list mode for this element." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/map-source-list-mode")
        protected Enumeration<StructureMapSourceListMode> listMode;

        /**
         * Named context for field, if a field is specified.
         */
        @Child(name = "variable", type = {IdType.class}, order=8, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Named context for field, if a field is specified", formalDefinition="Named context for field, if a field is specified." )
        protected IdType variable;

        /**
         * FHIRPath expression  - must be true or the rule does not apply.
         */
        @Child(name = "condition", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath expression  - must be true or the rule does not apply", formalDefinition="FHIRPath expression  - must be true or the rule does not apply." )
        protected StringType condition;

        /**
         * FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.
         */
        @Child(name = "check", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="FHIRPath expression  - must be true or the mapping engine throws an error instead of completing", formalDefinition="FHIRPath expression  - must be true or the mapping engine throws an error instead of completing." )
        protected StringType check;

        /**
         * A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.
         */
        @Child(name = "logMessage", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Message to put in log if source exists (FHIRPath)", formalDefinition="A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found." )
        protected StringType logMessage;

        private static final long serialVersionUID = 214178119L;

    /**
     * Constructor
     */
      public StructureMapGroupRuleSourceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapGroupRuleSourceComponent(String context) {
        super();
        this.setContext(context);
      }

        /**
         * @return {@link #context} (Type or variable this rule applies to.). This is the underlying object with id, value and extensions. The accessor "getContext" gives direct access to the value
         */
        public IdType getContextElement() { 
          if (this.context == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.context");
            else if (Configuration.doAutoCreate())
              this.context = new IdType(); // bb
          return this.context;
        }

        public boolean hasContextElement() { 
          return this.context != null && !this.context.isEmpty();
        }

        public boolean hasContext() { 
          return this.context != null && !this.context.isEmpty();
        }

        /**
         * @param value {@link #context} (Type or variable this rule applies to.). This is the underlying object with id, value and extensions. The accessor "getContext" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setContextElement(IdType value) { 
          this.context = value;
          return this;
        }

        /**
         * @return Type or variable this rule applies to.
         */
        public String getContext() { 
          return this.context == null ? null : this.context.getValue();
        }

        /**
         * @param value Type or variable this rule applies to.
         */
        public StructureMapGroupRuleSourceComponent setContext(String value) { 
            if (this.context == null)
              this.context = new IdType();
            this.context.setValue(value);
          return this;
        }

        /**
         * @return {@link #min} (Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
         */
        public IntegerType getMinElement() { 
          if (this.min == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.min");
            else if (Configuration.doAutoCreate())
              this.min = new IntegerType(); // bb
          return this.min;
        }

        public boolean hasMinElement() { 
          return this.min != null && !this.min.isEmpty();
        }

        public boolean hasMin() { 
          return this.min != null && !this.min.isEmpty();
        }

        /**
         * @param value {@link #min} (Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setMinElement(IntegerType value) { 
          this.min = value;
          return this;
        }

        /**
         * @return Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.
         */
        public int getMin() { 
          return this.min == null || this.min.isEmpty() ? 0 : this.min.getValue();
        }

        /**
         * @param value Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.
         */
        public StructureMapGroupRuleSourceComponent setMin(int value) { 
            if (this.min == null)
              this.min = new IntegerType();
            this.min.setValue(value);
          return this;
        }

        /**
         * @return {@link #max} (Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
         */
        public StringType getMaxElement() { 
          if (this.max == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.max");
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
         * @param value {@link #max} (Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setMaxElement(StringType value) { 
          this.max = value;
          return this;
        }

        /**
         * @return Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).
         */
        public String getMax() { 
          return this.max == null ? null : this.max.getValue();
        }

        /**
         * @param value Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).
         */
        public StructureMapGroupRuleSourceComponent setMax(String value) { 
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
         * @return {@link #type} (Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public StringType getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new StringType(); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setTypeElement(StringType value) { 
          this.type = value;
          return this;
        }

        /**
         * @return Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.
         */
        public String getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.
         */
        public StructureMapGroupRuleSourceComponent setType(String value) { 
          if (Utilities.noString(value))
            this.type = null;
          else {
            if (this.type == null)
              this.type = new StringType();
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #defaultValue} (A value to use if there is no existing value in the source object.). This is the underlying object with id, value and extensions. The accessor "getDefaultValue" gives direct access to the value
         */
        public StringType getDefaultValueElement() { 
          if (this.defaultValue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.defaultValue");
            else if (Configuration.doAutoCreate())
              this.defaultValue = new StringType(); // bb
          return this.defaultValue;
        }

        public boolean hasDefaultValueElement() { 
          return this.defaultValue != null && !this.defaultValue.isEmpty();
        }

        public boolean hasDefaultValue() { 
          return this.defaultValue != null && !this.defaultValue.isEmpty();
        }

        /**
         * @param value {@link #defaultValue} (A value to use if there is no existing value in the source object.). This is the underlying object with id, value and extensions. The accessor "getDefaultValue" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setDefaultValueElement(StringType value) { 
          this.defaultValue = value;
          return this;
        }

        /**
         * @return A value to use if there is no existing value in the source object.
         */
        public String getDefaultValue() { 
          return this.defaultValue == null ? null : this.defaultValue.getValue();
        }

        /**
         * @param value A value to use if there is no existing value in the source object.
         */
        public StructureMapGroupRuleSourceComponent setDefaultValue(String value) { 
          if (Utilities.noString(value))
            this.defaultValue = null;
          else {
            if (this.defaultValue == null)
              this.defaultValue = new StringType();
            this.defaultValue.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #element} (Optional field for this source.). This is the underlying object with id, value and extensions. The accessor "getElement" gives direct access to the value
         */
        public StringType getElementElement() { 
          if (this.element == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.element");
            else if (Configuration.doAutoCreate())
              this.element = new StringType(); // bb
          return this.element;
        }

        public boolean hasElementElement() { 
          return this.element != null && !this.element.isEmpty();
        }

        public boolean hasElement() { 
          return this.element != null && !this.element.isEmpty();
        }

        /**
         * @param value {@link #element} (Optional field for this source.). This is the underlying object with id, value and extensions. The accessor "getElement" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setElementElement(StringType value) { 
          this.element = value;
          return this;
        }

        /**
         * @return Optional field for this source.
         */
        public String getElement() { 
          return this.element == null ? null : this.element.getValue();
        }

        /**
         * @param value Optional field for this source.
         */
        public StructureMapGroupRuleSourceComponent setElement(String value) { 
          if (Utilities.noString(value))
            this.element = null;
          else {
            if (this.element == null)
              this.element = new StringType();
            this.element.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #listMode} (How to handle the list mode for this element.). This is the underlying object with id, value and extensions. The accessor "getListMode" gives direct access to the value
         */
        public Enumeration<StructureMapSourceListMode> getListModeElement() { 
          if (this.listMode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.listMode");
            else if (Configuration.doAutoCreate())
              this.listMode = new Enumeration<StructureMapSourceListMode>(new StructureMapSourceListModeEnumFactory()); // bb
          return this.listMode;
        }

        public boolean hasListModeElement() { 
          return this.listMode != null && !this.listMode.isEmpty();
        }

        public boolean hasListMode() { 
          return this.listMode != null && !this.listMode.isEmpty();
        }

        /**
         * @param value {@link #listMode} (How to handle the list mode for this element.). This is the underlying object with id, value and extensions. The accessor "getListMode" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setListModeElement(Enumeration<StructureMapSourceListMode> value) { 
          this.listMode = value;
          return this;
        }

        /**
         * @return How to handle the list mode for this element.
         */
        public StructureMapSourceListMode getListMode() { 
          return this.listMode == null ? null : this.listMode.getValue();
        }

        /**
         * @param value How to handle the list mode for this element.
         */
        public StructureMapGroupRuleSourceComponent setListMode(StructureMapSourceListMode value) { 
          if (value == null)
            this.listMode = null;
          else {
            if (this.listMode == null)
              this.listMode = new Enumeration<StructureMapSourceListMode>(new StructureMapSourceListModeEnumFactory());
            this.listMode.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #variable} (Named context for field, if a field is specified.). This is the underlying object with id, value and extensions. The accessor "getVariable" gives direct access to the value
         */
        public IdType getVariableElement() { 
          if (this.variable == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.variable");
            else if (Configuration.doAutoCreate())
              this.variable = new IdType(); // bb
          return this.variable;
        }

        public boolean hasVariableElement() { 
          return this.variable != null && !this.variable.isEmpty();
        }

        public boolean hasVariable() { 
          return this.variable != null && !this.variable.isEmpty();
        }

        /**
         * @param value {@link #variable} (Named context for field, if a field is specified.). This is the underlying object with id, value and extensions. The accessor "getVariable" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setVariableElement(IdType value) { 
          this.variable = value;
          return this;
        }

        /**
         * @return Named context for field, if a field is specified.
         */
        public String getVariable() { 
          return this.variable == null ? null : this.variable.getValue();
        }

        /**
         * @param value Named context for field, if a field is specified.
         */
        public StructureMapGroupRuleSourceComponent setVariable(String value) { 
          if (Utilities.noString(value))
            this.variable = null;
          else {
            if (this.variable == null)
              this.variable = new IdType();
            this.variable.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #condition} (FHIRPath expression  - must be true or the rule does not apply.). This is the underlying object with id, value and extensions. The accessor "getCondition" gives direct access to the value
         */
        public StringType getConditionElement() { 
          if (this.condition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.condition");
            else if (Configuration.doAutoCreate())
              this.condition = new StringType(); // bb
          return this.condition;
        }

        public boolean hasConditionElement() { 
          return this.condition != null && !this.condition.isEmpty();
        }

        public boolean hasCondition() { 
          return this.condition != null && !this.condition.isEmpty();
        }

        /**
         * @param value {@link #condition} (FHIRPath expression  - must be true or the rule does not apply.). This is the underlying object with id, value and extensions. The accessor "getCondition" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setConditionElement(StringType value) { 
          this.condition = value;
          return this;
        }

        /**
         * @return FHIRPath expression  - must be true or the rule does not apply.
         */
        public String getCondition() { 
          return this.condition == null ? null : this.condition.getValue();
        }

        /**
         * @param value FHIRPath expression  - must be true or the rule does not apply.
         */
        public StructureMapGroupRuleSourceComponent setCondition(String value) { 
          if (Utilities.noString(value))
            this.condition = null;
          else {
            if (this.condition == null)
              this.condition = new StringType();
            this.condition.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #check} (FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.). This is the underlying object with id, value and extensions. The accessor "getCheck" gives direct access to the value
         */
        public StringType getCheckElement() { 
          if (this.check == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.check");
            else if (Configuration.doAutoCreate())
              this.check = new StringType(); // bb
          return this.check;
        }

        public boolean hasCheckElement() { 
          return this.check != null && !this.check.isEmpty();
        }

        public boolean hasCheck() { 
          return this.check != null && !this.check.isEmpty();
        }

        /**
         * @param value {@link #check} (FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.). This is the underlying object with id, value and extensions. The accessor "getCheck" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setCheckElement(StringType value) { 
          this.check = value;
          return this;
        }

        /**
         * @return FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.
         */
        public String getCheck() { 
          return this.check == null ? null : this.check.getValue();
        }

        /**
         * @param value FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.
         */
        public StructureMapGroupRuleSourceComponent setCheck(String value) { 
          if (Utilities.noString(value))
            this.check = null;
          else {
            if (this.check == null)
              this.check = new StringType();
            this.check.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #logMessage} (A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.). This is the underlying object with id, value and extensions. The accessor "getLogMessage" gives direct access to the value
         */
        public StringType getLogMessageElement() { 
          if (this.logMessage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleSourceComponent.logMessage");
            else if (Configuration.doAutoCreate())
              this.logMessage = new StringType(); // bb
          return this.logMessage;
        }

        public boolean hasLogMessageElement() { 
          return this.logMessage != null && !this.logMessage.isEmpty();
        }

        public boolean hasLogMessage() { 
          return this.logMessage != null && !this.logMessage.isEmpty();
        }

        /**
         * @param value {@link #logMessage} (A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.). This is the underlying object with id, value and extensions. The accessor "getLogMessage" gives direct access to the value
         */
        public StructureMapGroupRuleSourceComponent setLogMessageElement(StringType value) { 
          this.logMessage = value;
          return this;
        }

        /**
         * @return A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.
         */
        public String getLogMessage() { 
          return this.logMessage == null ? null : this.logMessage.getValue();
        }

        /**
         * @param value A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.
         */
        public StructureMapGroupRuleSourceComponent setLogMessage(String value) { 
          if (Utilities.noString(value))
            this.logMessage = null;
          else {
            if (this.logMessage == null)
              this.logMessage = new StringType();
            this.logMessage.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("context", "id", "Type or variable this rule applies to.", 0, 1, context));
          children.add(new Property("min", "integer", "Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.", 0, 1, min));
          children.add(new Property("max", "string", "Specified maximum cardinality for the element - a number or a \"*\". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).", 0, 1, max));
          children.add(new Property("type", "string", "Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.", 0, 1, type));
          children.add(new Property("defaultValue", "string", "A value to use if there is no existing value in the source object.", 0, 1, defaultValue));
          children.add(new Property("element", "string", "Optional field for this source.", 0, 1, element));
          children.add(new Property("listMode", "code", "How to handle the list mode for this element.", 0, 1, listMode));
          children.add(new Property("variable", "id", "Named context for field, if a field is specified.", 0, 1, variable));
          children.add(new Property("condition", "string", "FHIRPath expression  - must be true or the rule does not apply.", 0, 1, condition));
          children.add(new Property("check", "string", "FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.", 0, 1, check));
          children.add(new Property("logMessage", "string", "A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.", 0, 1, logMessage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 951530927: /*context*/  return new Property("context", "id", "Type or variable this rule applies to.", 0, 1, context);
          case 108114: /*min*/  return new Property("min", "integer", "Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input content.", 0, 1, min);
          case 107876: /*max*/  return new Property("max", "string", "Specified maximum cardinality for the element - a number or a \"*\". This is optional; if present, it acts an implicit check on the input content (* just serves as documentation; it's the default value).", 0, 1, max);
          case 3575610: /*type*/  return new Property("type", "string", "Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.", 0, 1, type);
          case -659125328: /*defaultValue*/  return new Property("defaultValue", "string", "A value to use if there is no existing value in the source object.", 0, 1, defaultValue);
          case -1662836996: /*element*/  return new Property("element", "string", "Optional field for this source.", 0, 1, element);
          case 1345445729: /*listMode*/  return new Property("listMode", "code", "How to handle the list mode for this element.", 0, 1, listMode);
          case -1249586564: /*variable*/  return new Property("variable", "id", "Named context for field, if a field is specified.", 0, 1, variable);
          case -861311717: /*condition*/  return new Property("condition", "string", "FHIRPath expression  - must be true or the rule does not apply.", 0, 1, condition);
          case 94627080: /*check*/  return new Property("check", "string", "FHIRPath expression  - must be true or the mapping engine throws an error instead of completing.", 0, 1, check);
          case -1067155421: /*logMessage*/  return new Property("logMessage", "string", "A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is found.", 0, 1, logMessage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // IdType
        case 108114: /*min*/ return this.min == null ? new Base[0] : new Base[] {this.min}; // IntegerType
        case 107876: /*max*/ return this.max == null ? new Base[0] : new Base[] {this.max}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // StringType
        case -659125328: /*defaultValue*/ return this.defaultValue == null ? new Base[0] : new Base[] {this.defaultValue}; // StringType
        case -1662836996: /*element*/ return this.element == null ? new Base[0] : new Base[] {this.element}; // StringType
        case 1345445729: /*listMode*/ return this.listMode == null ? new Base[0] : new Base[] {this.listMode}; // Enumeration<StructureMapSourceListMode>
        case -1249586564: /*variable*/ return this.variable == null ? new Base[0] : new Base[] {this.variable}; // IdType
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : new Base[] {this.condition}; // StringType
        case 94627080: /*check*/ return this.check == null ? new Base[0] : new Base[] {this.check}; // StringType
        case -1067155421: /*logMessage*/ return this.logMessage == null ? new Base[0] : new Base[] {this.logMessage}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 951530927: // context
          this.context = TypeConvertor.castToId(value); // IdType
          return value;
        case 108114: // min
          this.min = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 107876: // max
          this.max = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToString(value); // StringType
          return value;
        case -659125328: // defaultValue
          this.defaultValue = TypeConvertor.castToString(value); // StringType
          return value;
        case -1662836996: // element
          this.element = TypeConvertor.castToString(value); // StringType
          return value;
        case 1345445729: // listMode
          value = new StructureMapSourceListModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.listMode = (Enumeration) value; // Enumeration<StructureMapSourceListMode>
          return value;
        case -1249586564: // variable
          this.variable = TypeConvertor.castToId(value); // IdType
          return value;
        case -861311717: // condition
          this.condition = TypeConvertor.castToString(value); // StringType
          return value;
        case 94627080: // check
          this.check = TypeConvertor.castToString(value); // StringType
          return value;
        case -1067155421: // logMessage
          this.logMessage = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("context")) {
          this.context = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("min")) {
          this.min = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("max")) {
          this.max = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("defaultValue")) {
          this.defaultValue = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("element")) {
          this.element = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("listMode")) {
          value = new StructureMapSourceListModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.listMode = (Enumeration) value; // Enumeration<StructureMapSourceListMode>
        } else if (name.equals("variable")) {
          this.variable = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("condition")) {
          this.condition = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("check")) {
          this.check = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("logMessage")) {
          this.logMessage = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530927:  return getContextElement();
        case 108114:  return getMinElement();
        case 107876:  return getMaxElement();
        case 3575610:  return getTypeElement();
        case -659125328:  return getDefaultValueElement();
        case -1662836996:  return getElementElement();
        case 1345445729:  return getListModeElement();
        case -1249586564:  return getVariableElement();
        case -861311717:  return getConditionElement();
        case 94627080:  return getCheckElement();
        case -1067155421:  return getLogMessageElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530927: /*context*/ return new String[] {"id"};
        case 108114: /*min*/ return new String[] {"integer"};
        case 107876: /*max*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"string"};
        case -659125328: /*defaultValue*/ return new String[] {"string"};
        case -1662836996: /*element*/ return new String[] {"string"};
        case 1345445729: /*listMode*/ return new String[] {"code"};
        case -1249586564: /*variable*/ return new String[] {"id"};
        case -861311717: /*condition*/ return new String[] {"string"};
        case 94627080: /*check*/ return new String[] {"string"};
        case -1067155421: /*logMessage*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("context")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.context");
        }
        else if (name.equals("min")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.min");
        }
        else if (name.equals("max")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.max");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.type");
        }
        else if (name.equals("defaultValue")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.defaultValue");
        }
        else if (name.equals("element")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.element");
        }
        else if (name.equals("listMode")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.listMode");
        }
        else if (name.equals("variable")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.variable");
        }
        else if (name.equals("condition")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.condition");
        }
        else if (name.equals("check")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.check");
        }
        else if (name.equals("logMessage")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.source.logMessage");
        }
        else
          return super.addChild(name);
      }

      public StructureMapGroupRuleSourceComponent copy() {
        StructureMapGroupRuleSourceComponent dst = new StructureMapGroupRuleSourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupRuleSourceComponent dst) {
        super.copyValues(dst);
        dst.context = context == null ? null : context.copy();
        dst.min = min == null ? null : min.copy();
        dst.max = max == null ? null : max.copy();
        dst.type = type == null ? null : type.copy();
        dst.defaultValue = defaultValue == null ? null : defaultValue.copy();
        dst.element = element == null ? null : element.copy();
        dst.listMode = listMode == null ? null : listMode.copy();
        dst.variable = variable == null ? null : variable.copy();
        dst.condition = condition == null ? null : condition.copy();
        dst.check = check == null ? null : check.copy();
        dst.logMessage = logMessage == null ? null : logMessage.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleSourceComponent))
          return false;
        StructureMapGroupRuleSourceComponent o = (StructureMapGroupRuleSourceComponent) other_;
        return compareDeep(context, o.context, true) && compareDeep(min, o.min, true) && compareDeep(max, o.max, true)
           && compareDeep(type, o.type, true) && compareDeep(defaultValue, o.defaultValue, true) && compareDeep(element, o.element, true)
           && compareDeep(listMode, o.listMode, true) && compareDeep(variable, o.variable, true) && compareDeep(condition, o.condition, true)
           && compareDeep(check, o.check, true) && compareDeep(logMessage, o.logMessage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleSourceComponent))
          return false;
        StructureMapGroupRuleSourceComponent o = (StructureMapGroupRuleSourceComponent) other_;
        return compareValues(context, o.context, true) && compareValues(min, o.min, true) && compareValues(max, o.max, true)
           && compareValues(type, o.type, true) && compareValues(defaultValue, o.defaultValue, true) && compareValues(element, o.element, true)
           && compareValues(listMode, o.listMode, true) && compareValues(variable, o.variable, true) && compareValues(condition, o.condition, true)
           && compareValues(check, o.check, true) && compareValues(logMessage, o.logMessage, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(context, min, max, type
          , defaultValue, element, listMode, variable, condition, check, logMessage);
      }

  public String fhirType() {
    return "StructureMap.group.rule.source";

  }

// added from java-adornments.txt:
public String toString() {
    return StructureMapUtilities.sourceToString(this);
  }
// end addition
  }

    @Block()
    public static class StructureMapGroupRuleTargetComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Variable this rule applies to.
         */
        @Child(name = "context", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Variable this rule applies to", formalDefinition="Variable this rule applies to." )
        protected StringType context;

        /**
         * Field to create in the context.
         */
        @Child(name = "element", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Field to create in the context", formalDefinition="Field to create in the context." )
        protected StringType element;

        /**
         * Named context for field, if desired, and a field is specified.
         */
        @Child(name = "variable", type = {IdType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Named context for field, if desired, and a field is specified", formalDefinition="Named context for field, if desired, and a field is specified." )
        protected IdType variable;

        /**
         * If field is a list, how to manage the list.
         */
        @Child(name = "listMode", type = {CodeType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="first | share | last | single", formalDefinition="If field is a list, how to manage the list." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/map-target-list-mode")
        protected List<Enumeration<StructureMapTargetListMode>> listMode;

        /**
         * Internal rule reference for shared list items.
         */
        @Child(name = "listRuleId", type = {IdType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Internal rule reference for shared list items", formalDefinition="Internal rule reference for shared list items." )
        protected IdType listRuleId;

        /**
         * How the data is copied / created.
         */
        @Child(name = "transform", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="create | copy +", formalDefinition="How the data is copied / created." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/map-transform")
        protected Enumeration<StructureMapTransform> transform;

        /**
         * Parameters to the transform.
         */
        @Child(name = "parameter", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Parameters to the transform", formalDefinition="Parameters to the transform." )
        protected List<StructureMapGroupRuleTargetParameterComponent> parameter;

        private static final long serialVersionUID = 1565495071L;

    /**
     * Constructor
     */
      public StructureMapGroupRuleTargetComponent() {
        super();
      }

        /**
         * @return {@link #context} (Variable this rule applies to.). This is the underlying object with id, value and extensions. The accessor "getContext" gives direct access to the value
         */
        public StringType getContextElement() { 
          if (this.context == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleTargetComponent.context");
            else if (Configuration.doAutoCreate())
              this.context = new StringType(); // bb
          return this.context;
        }

        public boolean hasContextElement() { 
          return this.context != null && !this.context.isEmpty();
        }

        public boolean hasContext() { 
          return this.context != null && !this.context.isEmpty();
        }

        /**
         * @param value {@link #context} (Variable this rule applies to.). This is the underlying object with id, value and extensions. The accessor "getContext" gives direct access to the value
         */
        public StructureMapGroupRuleTargetComponent setContextElement(StringType value) { 
          this.context = value;
          return this;
        }

        /**
         * @return Variable this rule applies to.
         */
        public String getContext() { 
          return this.context == null ? null : this.context.getValue();
        }

        /**
         * @param value Variable this rule applies to.
         */
        public StructureMapGroupRuleTargetComponent setContext(String value) { 
          if (Utilities.noString(value))
            this.context = null;
          else {
            if (this.context == null)
              this.context = new StringType();
            this.context.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #element} (Field to create in the context.). This is the underlying object with id, value and extensions. The accessor "getElement" gives direct access to the value
         */
        public StringType getElementElement() { 
          if (this.element == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleTargetComponent.element");
            else if (Configuration.doAutoCreate())
              this.element = new StringType(); // bb
          return this.element;
        }

        public boolean hasElementElement() { 
          return this.element != null && !this.element.isEmpty();
        }

        public boolean hasElement() { 
          return this.element != null && !this.element.isEmpty();
        }

        /**
         * @param value {@link #element} (Field to create in the context.). This is the underlying object with id, value and extensions. The accessor "getElement" gives direct access to the value
         */
        public StructureMapGroupRuleTargetComponent setElementElement(StringType value) { 
          this.element = value;
          return this;
        }

        /**
         * @return Field to create in the context.
         */
        public String getElement() { 
          return this.element == null ? null : this.element.getValue();
        }

        /**
         * @param value Field to create in the context.
         */
        public StructureMapGroupRuleTargetComponent setElement(String value) { 
          if (Utilities.noString(value))
            this.element = null;
          else {
            if (this.element == null)
              this.element = new StringType();
            this.element.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #variable} (Named context for field, if desired, and a field is specified.). This is the underlying object with id, value and extensions. The accessor "getVariable" gives direct access to the value
         */
        public IdType getVariableElement() { 
          if (this.variable == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleTargetComponent.variable");
            else if (Configuration.doAutoCreate())
              this.variable = new IdType(); // bb
          return this.variable;
        }

        public boolean hasVariableElement() { 
          return this.variable != null && !this.variable.isEmpty();
        }

        public boolean hasVariable() { 
          return this.variable != null && !this.variable.isEmpty();
        }

        /**
         * @param value {@link #variable} (Named context for field, if desired, and a field is specified.). This is the underlying object with id, value and extensions. The accessor "getVariable" gives direct access to the value
         */
        public StructureMapGroupRuleTargetComponent setVariableElement(IdType value) { 
          this.variable = value;
          return this;
        }

        /**
         * @return Named context for field, if desired, and a field is specified.
         */
        public String getVariable() { 
          return this.variable == null ? null : this.variable.getValue();
        }

        /**
         * @param value Named context for field, if desired, and a field is specified.
         */
        public StructureMapGroupRuleTargetComponent setVariable(String value) { 
          if (Utilities.noString(value))
            this.variable = null;
          else {
            if (this.variable == null)
              this.variable = new IdType();
            this.variable.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #listMode} (If field is a list, how to manage the list.)
         */
        public List<Enumeration<StructureMapTargetListMode>> getListMode() { 
          if (this.listMode == null)
            this.listMode = new ArrayList<Enumeration<StructureMapTargetListMode>>();
          return this.listMode;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleTargetComponent setListMode(List<Enumeration<StructureMapTargetListMode>> theListMode) { 
          this.listMode = theListMode;
          return this;
        }

        public boolean hasListMode() { 
          if (this.listMode == null)
            return false;
          for (Enumeration<StructureMapTargetListMode> item : this.listMode)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #listMode} (If field is a list, how to manage the list.)
         */
        public Enumeration<StructureMapTargetListMode> addListModeElement() {//2 
          Enumeration<StructureMapTargetListMode> t = new Enumeration<StructureMapTargetListMode>(new StructureMapTargetListModeEnumFactory());
          if (this.listMode == null)
            this.listMode = new ArrayList<Enumeration<StructureMapTargetListMode>>();
          this.listMode.add(t);
          return t;
        }

        /**
         * @param value {@link #listMode} (If field is a list, how to manage the list.)
         */
        public StructureMapGroupRuleTargetComponent addListMode(StructureMapTargetListMode value) { //1
          Enumeration<StructureMapTargetListMode> t = new Enumeration<StructureMapTargetListMode>(new StructureMapTargetListModeEnumFactory());
          t.setValue(value);
          if (this.listMode == null)
            this.listMode = new ArrayList<Enumeration<StructureMapTargetListMode>>();
          this.listMode.add(t);
          return this;
        }

        /**
         * @param value {@link #listMode} (If field is a list, how to manage the list.)
         */
        public boolean hasListMode(StructureMapTargetListMode value) { 
          if (this.listMode == null)
            return false;
          for (Enumeration<StructureMapTargetListMode> v : this.listMode)
            if (v.getValue().equals(value)) // code
              return true;
          return false;
        }

        /**
         * @return {@link #listRuleId} (Internal rule reference for shared list items.). This is the underlying object with id, value and extensions. The accessor "getListRuleId" gives direct access to the value
         */
        public IdType getListRuleIdElement() { 
          if (this.listRuleId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleTargetComponent.listRuleId");
            else if (Configuration.doAutoCreate())
              this.listRuleId = new IdType(); // bb
          return this.listRuleId;
        }

        public boolean hasListRuleIdElement() { 
          return this.listRuleId != null && !this.listRuleId.isEmpty();
        }

        public boolean hasListRuleId() { 
          return this.listRuleId != null && !this.listRuleId.isEmpty();
        }

        /**
         * @param value {@link #listRuleId} (Internal rule reference for shared list items.). This is the underlying object with id, value and extensions. The accessor "getListRuleId" gives direct access to the value
         */
        public StructureMapGroupRuleTargetComponent setListRuleIdElement(IdType value) { 
          this.listRuleId = value;
          return this;
        }

        /**
         * @return Internal rule reference for shared list items.
         */
        public String getListRuleId() { 
          return this.listRuleId == null ? null : this.listRuleId.getValue();
        }

        /**
         * @param value Internal rule reference for shared list items.
         */
        public StructureMapGroupRuleTargetComponent setListRuleId(String value) { 
          if (Utilities.noString(value))
            this.listRuleId = null;
          else {
            if (this.listRuleId == null)
              this.listRuleId = new IdType();
            this.listRuleId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #transform} (How the data is copied / created.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
         */
        public Enumeration<StructureMapTransform> getTransformElement() { 
          if (this.transform == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleTargetComponent.transform");
            else if (Configuration.doAutoCreate())
              this.transform = new Enumeration<StructureMapTransform>(new StructureMapTransformEnumFactory()); // bb
          return this.transform;
        }

        public boolean hasTransformElement() { 
          return this.transform != null && !this.transform.isEmpty();
        }

        public boolean hasTransform() { 
          return this.transform != null && !this.transform.isEmpty();
        }

        /**
         * @param value {@link #transform} (How the data is copied / created.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
         */
        public StructureMapGroupRuleTargetComponent setTransformElement(Enumeration<StructureMapTransform> value) { 
          this.transform = value;
          return this;
        }

        /**
         * @return How the data is copied / created.
         */
        public StructureMapTransform getTransform() { 
          return this.transform == null ? null : this.transform.getValue();
        }

        /**
         * @param value How the data is copied / created.
         */
        public StructureMapGroupRuleTargetComponent setTransform(StructureMapTransform value) { 
          if (value == null)
            this.transform = null;
          else {
            if (this.transform == null)
              this.transform = new Enumeration<StructureMapTransform>(new StructureMapTransformEnumFactory());
            this.transform.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #parameter} (Parameters to the transform.)
         */
        public List<StructureMapGroupRuleTargetParameterComponent> getParameter() { 
          if (this.parameter == null)
            this.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          return this.parameter;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleTargetComponent setParameter(List<StructureMapGroupRuleTargetParameterComponent> theParameter) { 
          this.parameter = theParameter;
          return this;
        }

        public boolean hasParameter() { 
          if (this.parameter == null)
            return false;
          for (StructureMapGroupRuleTargetParameterComponent item : this.parameter)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleTargetParameterComponent addParameter() { //3
          StructureMapGroupRuleTargetParameterComponent t = new StructureMapGroupRuleTargetParameterComponent();
          if (this.parameter == null)
            this.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          this.parameter.add(t);
          return t;
        }

        public StructureMapGroupRuleTargetComponent addParameter(StructureMapGroupRuleTargetParameterComponent t) { //3
          if (t == null)
            return this;
          if (this.parameter == null)
            this.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          this.parameter.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleTargetParameterComponent getParameterFirstRep() { 
          if (getParameter().isEmpty()) {
            addParameter();
          }
          return getParameter().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("context", "string", "Variable this rule applies to.", 0, 1, context));
          children.add(new Property("element", "string", "Field to create in the context.", 0, 1, element));
          children.add(new Property("variable", "id", "Named context for field, if desired, and a field is specified.", 0, 1, variable));
          children.add(new Property("listMode", "code", "If field is a list, how to manage the list.", 0, java.lang.Integer.MAX_VALUE, listMode));
          children.add(new Property("listRuleId", "id", "Internal rule reference for shared list items.", 0, 1, listRuleId));
          children.add(new Property("transform", "code", "How the data is copied / created.", 0, 1, transform));
          children.add(new Property("parameter", "", "Parameters to the transform.", 0, java.lang.Integer.MAX_VALUE, parameter));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 951530927: /*context*/  return new Property("context", "string", "Variable this rule applies to.", 0, 1, context);
          case -1662836996: /*element*/  return new Property("element", "string", "Field to create in the context.", 0, 1, element);
          case -1249586564: /*variable*/  return new Property("variable", "id", "Named context for field, if desired, and a field is specified.", 0, 1, variable);
          case 1345445729: /*listMode*/  return new Property("listMode", "code", "If field is a list, how to manage the list.", 0, java.lang.Integer.MAX_VALUE, listMode);
          case 337117045: /*listRuleId*/  return new Property("listRuleId", "id", "Internal rule reference for shared list items.", 0, 1, listRuleId);
          case 1052666732: /*transform*/  return new Property("transform", "code", "How the data is copied / created.", 0, 1, transform);
          case 1954460585: /*parameter*/  return new Property("parameter", "", "Parameters to the transform.", 0, java.lang.Integer.MAX_VALUE, parameter);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // StringType
        case -1662836996: /*element*/ return this.element == null ? new Base[0] : new Base[] {this.element}; // StringType
        case -1249586564: /*variable*/ return this.variable == null ? new Base[0] : new Base[] {this.variable}; // IdType
        case 1345445729: /*listMode*/ return this.listMode == null ? new Base[0] : this.listMode.toArray(new Base[this.listMode.size()]); // Enumeration<StructureMapTargetListMode>
        case 337117045: /*listRuleId*/ return this.listRuleId == null ? new Base[0] : new Base[] {this.listRuleId}; // IdType
        case 1052666732: /*transform*/ return this.transform == null ? new Base[0] : new Base[] {this.transform}; // Enumeration<StructureMapTransform>
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // StructureMapGroupRuleTargetParameterComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 951530927: // context
          this.context = TypeConvertor.castToString(value); // StringType
          return value;
        case -1662836996: // element
          this.element = TypeConvertor.castToString(value); // StringType
          return value;
        case -1249586564: // variable
          this.variable = TypeConvertor.castToId(value); // IdType
          return value;
        case 1345445729: // listMode
          value = new StructureMapTargetListModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getListMode().add((Enumeration) value); // Enumeration<StructureMapTargetListMode>
          return value;
        case 337117045: // listRuleId
          this.listRuleId = TypeConvertor.castToId(value); // IdType
          return value;
        case 1052666732: // transform
          value = new StructureMapTransformEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.transform = (Enumeration) value; // Enumeration<StructureMapTransform>
          return value;
        case 1954460585: // parameter
          this.getParameter().add((StructureMapGroupRuleTargetParameterComponent) value); // StructureMapGroupRuleTargetParameterComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("context")) {
          this.context = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("element")) {
          this.element = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("variable")) {
          this.variable = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("listMode")) {
          value = new StructureMapTargetListModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getListMode().add((Enumeration) value);
        } else if (name.equals("listRuleId")) {
          this.listRuleId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("transform")) {
          value = new StructureMapTransformEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.transform = (Enumeration) value; // Enumeration<StructureMapTransform>
        } else if (name.equals("parameter")) {
          this.getParameter().add((StructureMapGroupRuleTargetParameterComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530927:  return getContextElement();
        case -1662836996:  return getElementElement();
        case -1249586564:  return getVariableElement();
        case 1345445729:  return addListModeElement();
        case 337117045:  return getListRuleIdElement();
        case 1052666732:  return getTransformElement();
        case 1954460585:  return addParameter(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530927: /*context*/ return new String[] {"string"};
        case -1662836996: /*element*/ return new String[] {"string"};
        case -1249586564: /*variable*/ return new String[] {"id"};
        case 1345445729: /*listMode*/ return new String[] {"code"};
        case 337117045: /*listRuleId*/ return new String[] {"id"};
        case 1052666732: /*transform*/ return new String[] {"code"};
        case 1954460585: /*parameter*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("context")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.target.context");
        }
        else if (name.equals("element")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.target.element");
        }
        else if (name.equals("variable")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.target.variable");
        }
        else if (name.equals("listMode")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.target.listMode");
        }
        else if (name.equals("listRuleId")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.target.listRuleId");
        }
        else if (name.equals("transform")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.target.transform");
        }
        else if (name.equals("parameter")) {
          return addParameter();
        }
        else
          return super.addChild(name);
      }

      public StructureMapGroupRuleTargetComponent copy() {
        StructureMapGroupRuleTargetComponent dst = new StructureMapGroupRuleTargetComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupRuleTargetComponent dst) {
        super.copyValues(dst);
        dst.context = context == null ? null : context.copy();
        dst.element = element == null ? null : element.copy();
        dst.variable = variable == null ? null : variable.copy();
        if (listMode != null) {
          dst.listMode = new ArrayList<Enumeration<StructureMapTargetListMode>>();
          for (Enumeration<StructureMapTargetListMode> i : listMode)
            dst.listMode.add(i.copy());
        };
        dst.listRuleId = listRuleId == null ? null : listRuleId.copy();
        dst.transform = transform == null ? null : transform.copy();
        if (parameter != null) {
          dst.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          for (StructureMapGroupRuleTargetParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleTargetComponent))
          return false;
        StructureMapGroupRuleTargetComponent o = (StructureMapGroupRuleTargetComponent) other_;
        return compareDeep(context, o.context, true) && compareDeep(element, o.element, true) && compareDeep(variable, o.variable, true)
           && compareDeep(listMode, o.listMode, true) && compareDeep(listRuleId, o.listRuleId, true) && compareDeep(transform, o.transform, true)
           && compareDeep(parameter, o.parameter, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleTargetComponent))
          return false;
        StructureMapGroupRuleTargetComponent o = (StructureMapGroupRuleTargetComponent) other_;
        return compareValues(context, o.context, true) && compareValues(element, o.element, true) && compareValues(variable, o.variable, true)
           && compareValues(listMode, o.listMode, true) && compareValues(listRuleId, o.listRuleId, true) && compareValues(transform, o.transform, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(context, element, variable
          , listMode, listRuleId, transform, parameter);
      }

  public String fhirType() {
    return "StructureMap.group.rule.target";

  }

// added from java-adornments.txt:
public String toString() {
    return StructureMapUtilities.targetToString(this);
  }
// end addition
  }

    @Block()
    public static class StructureMapGroupRuleTargetParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Parameter value - variable or literal.
         */
        @Child(name = "value", type = {IdType.class, StringType.class, BooleanType.class, IntegerType.class, DecimalType.class, DateType.class, TimeType.class, DateTimeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Parameter value - variable or literal", formalDefinition="Parameter value - variable or literal." )
        protected DataType value;

        private static final long serialVersionUID = -1135414639L;

    /**
     * Constructor
     */
      public StructureMapGroupRuleTargetParameterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapGroupRuleTargetParameterComponent(DataType value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #value} (Parameter value - variable or literal.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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
         * @return {@link #value} (Parameter value - variable or literal.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Parameter value - variable or literal.)
         */
        public StructureMapGroupRuleTargetParameterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof IdType || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof DecimalType || value instanceof DateType || value instanceof TimeType || value instanceof DateTimeType))
            throw new Error("Not the right type for StructureMap.group.rule.target.parameter.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value[x]", "id|string|boolean|integer|decimal|date|time|dateTime", "Parameter value - variable or literal.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1410166417: /*value[x]*/  return new Property("value[x]", "id|string|boolean|integer|decimal|date|time|dateTime", "Parameter value - variable or literal.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "id|string|boolean|integer|decimal|date|time|dateTime", "Parameter value - variable or literal.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "Parameter value - variable or literal.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "Parameter value - variable or literal.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Parameter value - variable or literal.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "Parameter value - variable or literal.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "Parameter value - variable or literal.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "Parameter value - variable or literal.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "Parameter value - variable or literal.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "Parameter value - variable or literal.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"id", "string", "boolean", "integer", "decimal", "date", "time", "dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("valueId")) {
          this.value = new IdType();
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
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueDate")) {
          this.value = new DateType();
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
        else
          return super.addChild(name);
      }

      public StructureMapGroupRuleTargetParameterComponent copy() {
        StructureMapGroupRuleTargetParameterComponent dst = new StructureMapGroupRuleTargetParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupRuleTargetParameterComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleTargetParameterComponent))
          return false;
        StructureMapGroupRuleTargetParameterComponent o = (StructureMapGroupRuleTargetParameterComponent) other_;
        return compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleTargetParameterComponent))
          return false;
        StructureMapGroupRuleTargetParameterComponent o = (StructureMapGroupRuleTargetParameterComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value);
      }

  public String fhirType() {
    return "StructureMap.group.rule.target.parameter";

  }

// added from java-adornments.txt:
public String toString() {
        return value == null ? "null!" : value.toString();
      }
// end addition
  }

    @Block()
    public static class StructureMapGroupRuleDependentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name of a rule or group to apply.
         */
        @Child(name = "name", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name of a rule or group to apply", formalDefinition="Name of a rule or group to apply." )
        protected IdType name;

        /**
         * Parameter to pass to the rule or group.
         */
        @Child(name = "parameter", type = {StructureMapGroupRuleTargetParameterComponent.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Parameter to pass to the rule or group", formalDefinition="Parameter to pass to the rule or group." )
        protected List<StructureMapGroupRuleTargetParameterComponent> parameter;

        private static final long serialVersionUID = -290346576L;

    /**
     * Constructor
     */
      public StructureMapGroupRuleDependentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public StructureMapGroupRuleDependentComponent(String name, StructureMapGroupRuleTargetParameterComponent parameter) {
        super();
        this.setName(name);
        this.addParameter(parameter);
      }

        /**
         * @return {@link #name} (Name of a rule or group to apply.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public IdType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StructureMapGroupRuleDependentComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new IdType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name of a rule or group to apply.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StructureMapGroupRuleDependentComponent setNameElement(IdType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of a rule or group to apply.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of a rule or group to apply.
         */
        public StructureMapGroupRuleDependentComponent setName(String value) { 
            if (this.name == null)
              this.name = new IdType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #parameter} (Parameter to pass to the rule or group.)
         */
        public List<StructureMapGroupRuleTargetParameterComponent> getParameter() { 
          if (this.parameter == null)
            this.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          return this.parameter;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StructureMapGroupRuleDependentComponent setParameter(List<StructureMapGroupRuleTargetParameterComponent> theParameter) { 
          this.parameter = theParameter;
          return this;
        }

        public boolean hasParameter() { 
          if (this.parameter == null)
            return false;
          for (StructureMapGroupRuleTargetParameterComponent item : this.parameter)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StructureMapGroupRuleTargetParameterComponent addParameter() { //3
          StructureMapGroupRuleTargetParameterComponent t = new StructureMapGroupRuleTargetParameterComponent();
          if (this.parameter == null)
            this.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          this.parameter.add(t);
          return t;
        }

        public StructureMapGroupRuleDependentComponent addParameter(StructureMapGroupRuleTargetParameterComponent t) { //3
          if (t == null)
            return this;
          if (this.parameter == null)
            this.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          this.parameter.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
         */
        public StructureMapGroupRuleTargetParameterComponent getParameterFirstRep() { 
          if (getParameter().isEmpty()) {
            addParameter();
          }
          return getParameter().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "id", "Name of a rule or group to apply.", 0, 1, name));
          children.add(new Property("parameter", "@StructureMap.group.rule.target.parameter", "Parameter to pass to the rule or group.", 0, java.lang.Integer.MAX_VALUE, parameter));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "id", "Name of a rule or group to apply.", 0, 1, name);
          case 1954460585: /*parameter*/  return new Property("parameter", "@StructureMap.group.rule.target.parameter", "Parameter to pass to the rule or group.", 0, java.lang.Integer.MAX_VALUE, parameter);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // IdType
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // StructureMapGroupRuleTargetParameterComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToId(value); // IdType
          return value;
        case 1954460585: // parameter
          this.getParameter().add((StructureMapGroupRuleTargetParameterComponent) value); // StructureMapGroupRuleTargetParameterComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("parameter")) {
          this.getParameter().add((StructureMapGroupRuleTargetParameterComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 1954460585:  return addParameter(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"id"};
        case 1954460585: /*parameter*/ return new String[] {"@StructureMap.group.rule.target.parameter"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.group.rule.dependent.name");
        }
        else if (name.equals("parameter")) {
          return addParameter();
        }
        else
          return super.addChild(name);
      }

      public StructureMapGroupRuleDependentComponent copy() {
        StructureMapGroupRuleDependentComponent dst = new StructureMapGroupRuleDependentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMapGroupRuleDependentComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (parameter != null) {
          dst.parameter = new ArrayList<StructureMapGroupRuleTargetParameterComponent>();
          for (StructureMapGroupRuleTargetParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleDependentComponent))
          return false;
        StructureMapGroupRuleDependentComponent o = (StructureMapGroupRuleDependentComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(parameter, o.parameter, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMapGroupRuleDependentComponent))
          return false;
        StructureMapGroupRuleDependentComponent o = (StructureMapGroupRuleDependentComponent) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, parameter);
      }

  public String fhirType() {
    return "StructureMap.group.rule.dependent";

  }

  }

    /**
     * An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this structure map, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the structure map", formalDefinition="A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the structure map", formalDefinition="The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this structure map (computer friendly)", formalDefinition="A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the structure map.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this structure map (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the structure map." )
    protected StringType title;

    /**
     * The status of this structure map. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this structure map. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.
     */
    @Child(name = "publisher", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the structure map." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the structure map from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the structure map", formalDefinition="A free text natural language description of the structure map from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure map instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure map instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the structure map is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for structure map (if applicable)", formalDefinition="A legal or geographic region in which the structure map is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this structure map is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this structure map is defined", formalDefinition="Explanation of why this structure map is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * A structure definition used by this map. The structure definition may describe instances that are converted, or the instances that are produced.
     */
    @Child(name = "structure", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Structure Definition used by this map", formalDefinition="A structure definition used by this map. The structure definition may describe instances that are converted, or the instances that are produced." )
    protected List<StructureMapStructureComponent> structure;

    /**
     * Other maps used by this map (canonical URLs).
     */
    @Child(name = "import", type = {CanonicalType.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Other maps used by this map (canonical URLs)", formalDefinition="Other maps used by this map (canonical URLs)." )
    protected List<CanonicalType> import_;

    /**
     * Definition of a constant value used in the map rules.
     */
    @Child(name = "const", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Definition of the constant value used in the map rules", formalDefinition="Definition of a constant value used in the map rules." )
    protected List<StructureMapConstComponent> const_;

    /**
     * Organizes the mapping into managable chunks for human review/ease of maintenance.
     */
    @Child(name = "group", type = {}, order=20, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Named sections for reader convenience", formalDefinition="Organizes the mapping into managable chunks for human review/ease of maintenance." )
    protected List<StructureMapGroupComponent> group;

    private static final long serialVersionUID = -1875777589L;

  /**
   * Constructor
   */
    public StructureMap() {
      super();
    }

  /**
   * Constructor
   */
    public StructureMap(String url, String name, PublicationStatus status, StructureMapGroupComponent group) {
      super();
      this.setUrl(url);
      this.setName(name);
      this.setStatus(status);
      this.addGroup(group);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public StructureMap setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.
     */
    public StructureMap setUrl(String value) { 
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setIdentifier(List<Identifier> theIdentifier) { 
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

    public StructureMap addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StructureMap setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public StructureMap setVersion(String value) { 
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
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      return this.versionAlgorithm;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new StringType();
      if (!(this.versionAlgorithm instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (StringType) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmStringType() { 
      return this != null && this.versionAlgorithm instanceof StringType;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new Coding();
      if (!(this.versionAlgorithm instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (Coding) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmCoding() { 
      return this != null && this.versionAlgorithm instanceof Coding;
    }

    public boolean hasVersionAlgorithm() { 
      return this.versionAlgorithm != null && !this.versionAlgorithm.isEmpty();
    }

    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StructureMap setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new Error("Not the right type for StructureMap.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.name");
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
     * @param value {@link #name} (A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StructureMap setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public StructureMap setName(String value) { 
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the structure map.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the structure map.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StructureMap setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the structure map.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the structure map.
     */
    public StructureMap setTitle(String value) { 
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
     * @return {@link #status} (The status of this structure map. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.status");
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
     * @param value {@link #status} (The status of this structure map. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public StructureMap setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this structure map. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this structure map. Enables tracking the life-cycle of the content.
     */
    public StructureMap setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public StructureMap setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public StructureMap setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public StructureMap setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.
     */
    public StructureMap setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StructureMap setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.
     */
    public StructureMap setPublisher(String value) { 
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
    public StructureMap setContact(List<ContactDetail> theContact) { 
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

    public StructureMap addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the structure map from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.description");
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
     * @param value {@link #description} (A free text natural language description of the structure map from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StructureMap setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the structure map from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the structure map from a consumer's perspective.
     */
    public StructureMap setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure map instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setUseContext(List<UsageContext> theUseContext) { 
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

    public StructureMap addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the structure map is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public StructureMap addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explanation of why this structure map is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.purpose");
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
     * @param value {@link #purpose} (Explanation of why this structure map is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public StructureMap setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this structure map is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this structure map is needed and why it has been designed as it has.
     */
    public StructureMap setPurpose(String value) { 
      if (Utilities.noString(value))
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public StructureMap setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.
     */
    public StructureMap setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureMap.copyrightLabel");
        else if (Configuration.doAutoCreate())
          this.copyrightLabel = new StringType(); // bb
      return this.copyrightLabel;
    }

    public boolean hasCopyrightLabelElement() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    public boolean hasCopyrightLabel() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StructureMap setCopyrightLabelElement(StringType value) { 
      this.copyrightLabel = value;
      return this;
    }

    /**
     * @return A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public String getCopyrightLabel() { 
      return this.copyrightLabel == null ? null : this.copyrightLabel.getValue();
    }

    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public StructureMap setCopyrightLabel(String value) { 
      if (Utilities.noString(value))
        this.copyrightLabel = null;
      else {
        if (this.copyrightLabel == null)
          this.copyrightLabel = new StringType();
        this.copyrightLabel.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #structure} (A structure definition used by this map. The structure definition may describe instances that are converted, or the instances that are produced.)
     */
    public List<StructureMapStructureComponent> getStructure() { 
      if (this.structure == null)
        this.structure = new ArrayList<StructureMapStructureComponent>();
      return this.structure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setStructure(List<StructureMapStructureComponent> theStructure) { 
      this.structure = theStructure;
      return this;
    }

    public boolean hasStructure() { 
      if (this.structure == null)
        return false;
      for (StructureMapStructureComponent item : this.structure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public StructureMapStructureComponent addStructure() { //3
      StructureMapStructureComponent t = new StructureMapStructureComponent();
      if (this.structure == null)
        this.structure = new ArrayList<StructureMapStructureComponent>();
      this.structure.add(t);
      return t;
    }

    public StructureMap addStructure(StructureMapStructureComponent t) { //3
      if (t == null)
        return this;
      if (this.structure == null)
        this.structure = new ArrayList<StructureMapStructureComponent>();
      this.structure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #structure}, creating it if it does not already exist {3}
     */
    public StructureMapStructureComponent getStructureFirstRep() { 
      if (getStructure().isEmpty()) {
        addStructure();
      }
      return getStructure().get(0);
    }

    /**
     * @return {@link #import_} (Other maps used by this map (canonical URLs).)
     */
    public List<CanonicalType> getImport() { 
      if (this.import_ == null)
        this.import_ = new ArrayList<CanonicalType>();
      return this.import_;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setImport(List<CanonicalType> theImport) { 
      this.import_ = theImport;
      return this;
    }

    public boolean hasImport() { 
      if (this.import_ == null)
        return false;
      for (CanonicalType item : this.import_)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #import_} (Other maps used by this map (canonical URLs).)
     */
    public CanonicalType addImportElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.import_ == null)
        this.import_ = new ArrayList<CanonicalType>();
      this.import_.add(t);
      return t;
    }

    /**
     * @param value {@link #import_} (Other maps used by this map (canonical URLs).)
     */
    public StructureMap addImport(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.import_ == null)
        this.import_ = new ArrayList<CanonicalType>();
      this.import_.add(t);
      return this;
    }

    /**
     * @param value {@link #import_} (Other maps used by this map (canonical URLs).)
     */
    public boolean hasImport(String value) { 
      if (this.import_ == null)
        return false;
      for (CanonicalType v : this.import_)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #const_} (Definition of a constant value used in the map rules.)
     */
    public List<StructureMapConstComponent> getConst() { 
      if (this.const_ == null)
        this.const_ = new ArrayList<StructureMapConstComponent>();
      return this.const_;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setConst(List<StructureMapConstComponent> theConst) { 
      this.const_ = theConst;
      return this;
    }

    public boolean hasConst() { 
      if (this.const_ == null)
        return false;
      for (StructureMapConstComponent item : this.const_)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public StructureMapConstComponent addConst() { //3
      StructureMapConstComponent t = new StructureMapConstComponent();
      if (this.const_ == null)
        this.const_ = new ArrayList<StructureMapConstComponent>();
      this.const_.add(t);
      return t;
    }

    public StructureMap addConst(StructureMapConstComponent t) { //3
      if (t == null)
        return this;
      if (this.const_ == null)
        this.const_ = new ArrayList<StructureMapConstComponent>();
      this.const_.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #const_}, creating it if it does not already exist {3}
     */
    public StructureMapConstComponent getConstFirstRep() { 
      if (getConst().isEmpty()) {
        addConst();
      }
      return getConst().get(0);
    }

    /**
     * @return {@link #group} (Organizes the mapping into managable chunks for human review/ease of maintenance.)
     */
    public List<StructureMapGroupComponent> getGroup() { 
      if (this.group == null)
        this.group = new ArrayList<StructureMapGroupComponent>();
      return this.group;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureMap setGroup(List<StructureMapGroupComponent> theGroup) { 
      this.group = theGroup;
      return this;
    }

    public boolean hasGroup() { 
      if (this.group == null)
        return false;
      for (StructureMapGroupComponent item : this.group)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public StructureMapGroupComponent addGroup() { //3
      StructureMapGroupComponent t = new StructureMapGroupComponent();
      if (this.group == null)
        this.group = new ArrayList<StructureMapGroupComponent>();
      this.group.add(t);
      return t;
    }

    public StructureMap addGroup(StructureMapGroupComponent t) { //3
      if (t == null)
        return this;
      if (this.group == null)
        this.group = new ArrayList<StructureMapGroupComponent>();
      this.group.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #group}, creating it if it does not already exist {3}
     */
    public StructureMapGroupComponent getGroupFirstRep() { 
      if (getGroup().isEmpty()) {
        addGroup();
      }
      return getGroup().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the structure map.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this structure map. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the structure map from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure map instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the structure map is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this structure map is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("structure", "", "A structure definition used by this map. The structure definition may describe instances that are converted, or the instances that are produced.", 0, java.lang.Integer.MAX_VALUE, structure));
        children.add(new Property("import", "canonical(StructureMap)", "Other maps used by this map (canonical URLs).", 0, java.lang.Integer.MAX_VALUE, import_));
        children.add(new Property("const", "", "Definition of a constant value used in the map rules.", 0, java.lang.Integer.MAX_VALUE, const_));
        children.add(new Property("group", "", "Organizes the mapping into managable chunks for human review/ease of maintenance.", 0, java.lang.Integer.MAX_VALUE, group));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this structure map is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the structure map when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the structure map. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the structure map.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this structure map. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this structure map is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the structure map was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure map changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the structure map.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the structure map from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure map instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the structure map is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this structure map is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure map.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 144518515: /*structure*/  return new Property("structure", "", "A structure definition used by this map. The structure definition may describe instances that are converted, or the instances that are produced.", 0, java.lang.Integer.MAX_VALUE, structure);
        case -1184795739: /*import*/  return new Property("import", "canonical(StructureMap)", "Other maps used by this map (canonical URLs).", 0, java.lang.Integer.MAX_VALUE, import_);
        case 94844771: /*const*/  return new Property("const", "", "Definition of a constant value used in the map rules.", 0, java.lang.Integer.MAX_VALUE, const_);
        case 98629247: /*group*/  return new Property("group", "", "Organizes the mapping into managable chunks for human review/ease of maintenance.", 0, java.lang.Integer.MAX_VALUE, group);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 1508158071: /*versionAlgorithm*/ return this.versionAlgorithm == null ? new Base[0] : new Base[] {this.versionAlgorithm}; // DataType
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
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 144518515: /*structure*/ return this.structure == null ? new Base[0] : this.structure.toArray(new Base[this.structure.size()]); // StructureMapStructureComponent
        case -1184795739: /*import*/ return this.import_ == null ? new Base[0] : this.import_.toArray(new Base[this.import_.size()]); // CanonicalType
        case 94844771: /*const*/ return this.const_ == null ? new Base[0] : this.const_.toArray(new Base[this.const_.size()]); // StructureMapConstComponent
        case 98629247: /*group*/ return this.group == null ? new Base[0] : this.group.toArray(new Base[this.group.size()]); // StructureMapGroupComponent
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
        case 1508158071: // versionAlgorithm
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
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
        case 765157229: // copyrightLabel
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
          return value;
        case 144518515: // structure
          this.getStructure().add((StructureMapStructureComponent) value); // StructureMapStructureComponent
          return value;
        case -1184795739: // import
          this.getImport().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 94844771: // const
          this.getConst().add((StructureMapConstComponent) value); // StructureMapConstComponent
          return value;
        case 98629247: // group
          this.getGroup().add((StructureMapGroupComponent) value); // StructureMapGroupComponent
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
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
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
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("structure")) {
          this.getStructure().add((StructureMapStructureComponent) value);
        } else if (name.equals("import")) {
          this.getImport().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("const")) {
          this.getConst().add((StructureMapConstComponent) value);
        } else if (name.equals("group")) {
          this.getGroup().add((StructureMapGroupComponent) value);
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
        case -115699031:  return getVersionAlgorithm();
        case 1508158071:  return getVersionAlgorithm();
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
        case 765157229:  return getCopyrightLabelElement();
        case 144518515:  return addStructure(); 
        case -1184795739:  return addImportElement();
        case 94844771:  return addConst(); 
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
        case 1508158071: /*versionAlgorithm*/ return new String[] {"string", "Coding"};
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
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 144518515: /*structure*/ return new String[] {};
        case -1184795739: /*import*/ return new String[] {"canonical"};
        case 94844771: /*const*/ return new String[] {};
        case 98629247: /*group*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.version");
        }
        else if (name.equals("versionAlgorithmString")) {
          this.versionAlgorithm = new StringType();
          return this.versionAlgorithm;
        }
        else if (name.equals("versionAlgorithmCoding")) {
          this.versionAlgorithm = new Coding();
          return this.versionAlgorithm;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.copyrightLabel");
        }
        else if (name.equals("structure")) {
          return addStructure();
        }
        else if (name.equals("import")) {
          throw new FHIRException("Cannot call addChild on a primitive type StructureMap.import");
        }
        else if (name.equals("const")) {
          return addConst();
        }
        else if (name.equals("group")) {
          return addGroup();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "StructureMap";

  }

      public StructureMap copy() {
        StructureMap dst = new StructureMap();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StructureMap dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
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
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
        if (structure != null) {
          dst.structure = new ArrayList<StructureMapStructureComponent>();
          for (StructureMapStructureComponent i : structure)
            dst.structure.add(i.copy());
        };
        if (import_ != null) {
          dst.import_ = new ArrayList<CanonicalType>();
          for (CanonicalType i : import_)
            dst.import_.add(i.copy());
        };
        if (const_ != null) {
          dst.const_ = new ArrayList<StructureMapConstComponent>();
          for (StructureMapConstComponent i : const_)
            dst.const_.add(i.copy());
        };
        if (group != null) {
          dst.group = new ArrayList<StructureMapGroupComponent>();
          for (StructureMapGroupComponent i : group)
            dst.group.add(i.copy());
        };
      }

      protected StructureMap typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StructureMap))
          return false;
        StructureMap o = (StructureMap) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(structure, o.structure, true) && compareDeep(import_, o.import_, true) && compareDeep(const_, o.const_, true)
           && compareDeep(group, o.group, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StructureMap))
          return false;
        StructureMap o = (StructureMap) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(import_, o.import_, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, experimental, date, publisher, contact
          , description, useContext, jurisdiction, purpose, copyright, copyrightLabel, structure
          , import_, const_, group);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.StructureMap;
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
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
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
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
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
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
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
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
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
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
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
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
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
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
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

// Manual code (from Configuration.txt):
public String toString() {
    return StructureMapUtilities.render(this);
  }
// end addition

}

