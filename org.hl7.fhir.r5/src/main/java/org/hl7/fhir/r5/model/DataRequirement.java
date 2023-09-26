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
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * DataRequirement Type: Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.
 */
@DatatypeDef(name="DataRequirement")
public class DataRequirement extends DataType implements ICompositeType {

    public enum SortDirection {
        /**
         * Sort by the value ascending, so that lower values appear first.
         */
        ASCENDING, 
        /**
         * Sort by the value descending, so that lower values appear last.
         */
        DESCENDING, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SortDirection fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ascending".equals(codeString))
          return ASCENDING;
        if ("descending".equals(codeString))
          return DESCENDING;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SortDirection code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ASCENDING: return "ascending";
            case DESCENDING: return "descending";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ASCENDING: return "http://hl7.org/fhir/sort-direction";
            case DESCENDING: return "http://hl7.org/fhir/sort-direction";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ASCENDING: return "Sort by the value ascending, so that lower values appear first.";
            case DESCENDING: return "Sort by the value descending, so that lower values appear last.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ASCENDING: return "Ascending";
            case DESCENDING: return "Descending";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SortDirectionEnumFactory implements EnumFactory<SortDirection> {
    public SortDirection fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ascending".equals(codeString))
          return SortDirection.ASCENDING;
        if ("descending".equals(codeString))
          return SortDirection.DESCENDING;
        throw new IllegalArgumentException("Unknown SortDirection code '"+codeString+"'");
        }
        public Enumeration<SortDirection> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SortDirection>(this, SortDirection.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SortDirection>(this, SortDirection.NULL, code);
        if ("ascending".equals(codeString))
          return new Enumeration<SortDirection>(this, SortDirection.ASCENDING, code);
        if ("descending".equals(codeString))
          return new Enumeration<SortDirection>(this, SortDirection.DESCENDING, code);
        throw new FHIRException("Unknown SortDirection code '"+codeString+"'");
        }
    public String toCode(SortDirection code) {
      if (code == SortDirection.ASCENDING)
        return "ascending";
      if (code == SortDirection.DESCENDING)
        return "descending";
      return "?";
      }
    public String toSystem(SortDirection code) {
      return code.getSystem();
      }
    }

    public enum ValueFilterComparator {
        /**
         * the value for the parameter in the resource is equal to the provided value.
         */
        EQ, 
        /**
         * the value for the parameter in the resource is greater than the provided value.
         */
        GT, 
        /**
         * the value for the parameter in the resource is less than the provided value.
         */
        LT, 
        /**
         * the value for the parameter in the resource is greater or equal to the provided value.
         */
        GE, 
        /**
         * the value for the parameter in the resource is less or equal to the provided value.
         */
        LE, 
        /**
         * the value for the parameter in the resource starts after the provided value.
         */
        SA, 
        /**
         * the value for the parameter in the resource ends before the provided value.
         */
        EB, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ValueFilterComparator fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("eq".equals(codeString))
          return EQ;
        if ("gt".equals(codeString))
          return GT;
        if ("lt".equals(codeString))
          return LT;
        if ("ge".equals(codeString))
          return GE;
        if ("le".equals(codeString))
          return LE;
        if ("sa".equals(codeString))
          return SA;
        if ("eb".equals(codeString))
          return EB;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ValueFilterComparator code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EQ: return "eq";
            case GT: return "gt";
            case LT: return "lt";
            case GE: return "ge";
            case LE: return "le";
            case SA: return "sa";
            case EB: return "eb";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EQ: return "http://hl7.org/fhir/search-comparator";
            case GT: return "http://hl7.org/fhir/search-comparator";
            case LT: return "http://hl7.org/fhir/search-comparator";
            case GE: return "http://hl7.org/fhir/search-comparator";
            case LE: return "http://hl7.org/fhir/search-comparator";
            case SA: return "http://hl7.org/fhir/search-comparator";
            case EB: return "http://hl7.org/fhir/search-comparator";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EQ: return "the value for the parameter in the resource is equal to the provided value.";
            case GT: return "the value for the parameter in the resource is greater than the provided value.";
            case LT: return "the value for the parameter in the resource is less than the provided value.";
            case GE: return "the value for the parameter in the resource is greater or equal to the provided value.";
            case LE: return "the value for the parameter in the resource is less or equal to the provided value.";
            case SA: return "the value for the parameter in the resource starts after the provided value.";
            case EB: return "the value for the parameter in the resource ends before the provided value.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EQ: return "Equals";
            case GT: return "Greater Than";
            case LT: return "Less Than";
            case GE: return "Greater or Equals";
            case LE: return "Less of Equal";
            case SA: return "Starts After";
            case EB: return "Ends Before";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ValueFilterComparatorEnumFactory implements EnumFactory<ValueFilterComparator> {
    public ValueFilterComparator fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("eq".equals(codeString))
          return ValueFilterComparator.EQ;
        if ("gt".equals(codeString))
          return ValueFilterComparator.GT;
        if ("lt".equals(codeString))
          return ValueFilterComparator.LT;
        if ("ge".equals(codeString))
          return ValueFilterComparator.GE;
        if ("le".equals(codeString))
          return ValueFilterComparator.LE;
        if ("sa".equals(codeString))
          return ValueFilterComparator.SA;
        if ("eb".equals(codeString))
          return ValueFilterComparator.EB;
        throw new IllegalArgumentException("Unknown ValueFilterComparator code '"+codeString+"'");
        }
        public Enumeration<ValueFilterComparator> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.NULL, code);
        if ("eq".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.EQ, code);
        if ("gt".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.GT, code);
        if ("lt".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.LT, code);
        if ("ge".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.GE, code);
        if ("le".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.LE, code);
        if ("sa".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.SA, code);
        if ("eb".equals(codeString))
          return new Enumeration<ValueFilterComparator>(this, ValueFilterComparator.EB, code);
        throw new FHIRException("Unknown ValueFilterComparator code '"+codeString+"'");
        }
    public String toCode(ValueFilterComparator code) {
      if (code == ValueFilterComparator.EQ)
        return "eq";
      if (code == ValueFilterComparator.GT)
        return "gt";
      if (code == ValueFilterComparator.LT)
        return "lt";
      if (code == ValueFilterComparator.GE)
        return "ge";
      if (code == ValueFilterComparator.LE)
        return "le";
      if (code == ValueFilterComparator.SA)
        return "sa";
      if (code == ValueFilterComparator.EB)
        return "eb";
      return "?";
      }
    public String toSystem(ValueFilterComparator code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DataRequirementCodeFilterComponent extends Element implements IBaseDatatypeElement {
        /**
         * The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code-valued attribute to filter on", formalDefinition="The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept." )
        protected StringType path;

        /**
         * A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.
         */
        @Child(name = "searchParam", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A coded (token) parameter to search on", formalDefinition="A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept." )
        protected StringType searchParam;

        /**
         * The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="ValueSet for the filter", formalDefinition="The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset." )
        protected CanonicalType valueSet;

        /**
         * The codes for the code filter. If values are given, the filter will return only those data items for which the code-valued attribute specified by the path has a value that is one of the specified codes. If codes are specified in addition to a value set, the filter returns items matching a code in the value set or one of the specified codes.
         */
        @Child(name = "code", type = {Coding.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="What code is expected", formalDefinition="The codes for the code filter. If values are given, the filter will return only those data items for which the code-valued attribute specified by the path has a value that is one of the specified codes. If codes are specified in addition to a value set, the filter returns items matching a code in the value set or one of the specified codes." )
        protected List<Coding> code;

        private static final long serialVersionUID = -1286212752L;

    /**
     * Constructor
     */
      public DataRequirementCodeFilterComponent() {
        super();
      }

        /**
         * @return {@link #path} (The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementCodeFilterComponent.path");
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
         * @param value {@link #path} (The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public DataRequirementCodeFilterComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.
         */
        public DataRequirementCodeFilterComponent setPath(String value) { 
          if (Utilities.noString(value))
            this.path = null;
          else {
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #searchParam} (A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.). This is the underlying object with id, value and extensions. The accessor "getSearchParam" gives direct access to the value
         */
        public StringType getSearchParamElement() { 
          if (this.searchParam == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementCodeFilterComponent.searchParam");
            else if (Configuration.doAutoCreate())
              this.searchParam = new StringType(); // bb
          return this.searchParam;
        }

        public boolean hasSearchParamElement() { 
          return this.searchParam != null && !this.searchParam.isEmpty();
        }

        public boolean hasSearchParam() { 
          return this.searchParam != null && !this.searchParam.isEmpty();
        }

        /**
         * @param value {@link #searchParam} (A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.). This is the underlying object with id, value and extensions. The accessor "getSearchParam" gives direct access to the value
         */
        public DataRequirementCodeFilterComponent setSearchParamElement(StringType value) { 
          this.searchParam = value;
          return this;
        }

        /**
         * @return A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.
         */
        public String getSearchParam() { 
          return this.searchParam == null ? null : this.searchParam.getValue();
        }

        /**
         * @param value A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.
         */
        public DataRequirementCodeFilterComponent setSearchParam(String value) { 
          if (Utilities.noString(value))
            this.searchParam = null;
          else {
            if (this.searchParam == null)
              this.searchParam = new StringType();
            this.searchParam.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #valueSet} (The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementCodeFilterComponent.valueSet");
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
         * @param value {@link #valueSet} (The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public DataRequirementCodeFilterComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.
         */
        public DataRequirementCodeFilterComponent setValueSet(String value) { 
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
         * @return {@link #code} (The codes for the code filter. If values are given, the filter will return only those data items for which the code-valued attribute specified by the path has a value that is one of the specified codes. If codes are specified in addition to a value set, the filter returns items matching a code in the value set or one of the specified codes.)
         */
        public List<Coding> getCode() { 
          if (this.code == null)
            this.code = new ArrayList<Coding>();
          return this.code;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DataRequirementCodeFilterComponent setCode(List<Coding> theCode) { 
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

        public DataRequirementCodeFilterComponent addCode(Coding t) { //3
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.", 0, 1, path));
          children.add(new Property("searchParam", "string", "A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.", 0, 1, searchParam));
          children.add(new Property("valueSet", "canonical(ValueSet)", "The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.", 0, 1, valueSet));
          children.add(new Property("code", "Coding", "The codes for the code filter. If values are given, the filter will return only those data items for which the code-valued attribute specified by the path has a value that is one of the specified codes. If codes are specified in addition to a value set, the filter returns items matching a code in the value set or one of the specified codes.", 0, java.lang.Integer.MAX_VALUE, code));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The code-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type code, Coding, or CodeableConcept.", 0, 1, path);
          case -553645115: /*searchParam*/  return new Property("searchParam", "string", "A token parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type code, Coding, or CodeableConcept.", 0, 1, searchParam);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "The valueset for the code filter. The valueSet and code elements are additive. If valueSet is specified, the filter will return only those data items for which the value of the code-valued element specified in the path is a member of the specified valueset.", 0, 1, valueSet);
          case 3059181: /*code*/  return new Property("code", "Coding", "The codes for the code filter. If values are given, the filter will return only those data items for which the code-valued attribute specified by the path has a value that is one of the specified codes. If codes are specified in addition to a value set, the filter returns items matching a code in the value set or one of the specified codes.", 0, java.lang.Integer.MAX_VALUE, code);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : new Base[] {this.searchParam}; // StringType
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // Coding
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -553645115: // searchParam
          this.searchParam = TypeConvertor.castToString(value); // StringType
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("searchParam")) {
          this.searchParam = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCoding(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = null;
        } else if (name.equals("searchParam")) {
          this.searchParam = null;
        } else if (name.equals("valueSet")) {
          this.valueSet = null;
        } else if (name.equals("code")) {
          this.getCode().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -553645115:  return getSearchParamElement();
        case -1410174671:  return getValueSetElement();
        case 3059181:  return addCode(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -553645115: /*searchParam*/ return new String[] {"string"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        case 3059181: /*code*/ return new String[] {"Coding"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.codeFilter.path");
        }
        else if (name.equals("searchParam")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.codeFilter.searchParam");
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.codeFilter.valueSet");
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else
          return super.addChild(name);
      }

      public DataRequirementCodeFilterComponent copy() {
        DataRequirementCodeFilterComponent dst = new DataRequirementCodeFilterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DataRequirementCodeFilterComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.searchParam = searchParam == null ? null : searchParam.copy();
        dst.valueSet = valueSet == null ? null : valueSet.copy();
        if (code != null) {
          dst.code = new ArrayList<Coding>();
          for (Coding i : code)
            dst.code.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DataRequirementCodeFilterComponent))
          return false;
        DataRequirementCodeFilterComponent o = (DataRequirementCodeFilterComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(searchParam, o.searchParam, true) && compareDeep(valueSet, o.valueSet, true)
           && compareDeep(code, o.code, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DataRequirementCodeFilterComponent))
          return false;
        DataRequirementCodeFilterComponent o = (DataRequirementCodeFilterComponent) other_;
        return compareValues(path, o.path, true) && compareValues(searchParam, o.searchParam, true) && compareValues(valueSet, o.valueSet, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, searchParam, valueSet
          , code);
      }

  public String fhirType() {
    return "DataRequirement.codeFilter";

  }

  }

    @Block()
    public static class DataRequirementDateFilterComponent extends Element implements IBaseDatatypeElement {
        /**
         * The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A date-valued attribute to filter on", formalDefinition="The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing." )
        protected StringType path;

        /**
         * A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.
         */
        @Child(name = "searchParam", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A date valued parameter to search on", formalDefinition="A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing." )
        protected StringType searchParam;

        /**
         * The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.
         */
        @Child(name = "value", type = {DateTimeType.class, Period.class, Duration.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The value of the filter, as a Period, DateTime, or Duration value", formalDefinition="The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now." )
        protected DataType value;

        private static final long serialVersionUID = 1649787979L;

    /**
     * Constructor
     */
      public DataRequirementDateFilterComponent() {
        super();
      }

        /**
         * @return {@link #path} (The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementDateFilterComponent.path");
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
         * @param value {@link #path} (The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public DataRequirementDateFilterComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.
         */
        public DataRequirementDateFilterComponent setPath(String value) { 
          if (Utilities.noString(value))
            this.path = null;
          else {
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #searchParam} (A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.). This is the underlying object with id, value and extensions. The accessor "getSearchParam" gives direct access to the value
         */
        public StringType getSearchParamElement() { 
          if (this.searchParam == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementDateFilterComponent.searchParam");
            else if (Configuration.doAutoCreate())
              this.searchParam = new StringType(); // bb
          return this.searchParam;
        }

        public boolean hasSearchParamElement() { 
          return this.searchParam != null && !this.searchParam.isEmpty();
        }

        public boolean hasSearchParam() { 
          return this.searchParam != null && !this.searchParam.isEmpty();
        }

        /**
         * @param value {@link #searchParam} (A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.). This is the underlying object with id, value and extensions. The accessor "getSearchParam" gives direct access to the value
         */
        public DataRequirementDateFilterComponent setSearchParamElement(StringType value) { 
          this.searchParam = value;
          return this;
        }

        /**
         * @return A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.
         */
        public String getSearchParam() { 
          return this.searchParam == null ? null : this.searchParam.getValue();
        }

        /**
         * @param value A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.
         */
        public DataRequirementDateFilterComponent setSearchParam(String value) { 
          if (Utilities.noString(value))
            this.searchParam = null;
          else {
            if (this.searchParam == null)
              this.searchParam = new StringType();
            this.searchParam.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #value} (The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.)
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
         * @return {@link #value} (The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.)
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
         * @return {@link #value} (The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.)
         */
        public DataRequirementDateFilterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Duration))
            throw new FHIRException("Not the right type for DataRequirement.dateFilter.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.", 0, 1, path));
          children.add(new Property("searchParam", "string", "A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.", 0, 1, searchParam));
          children.add(new Property("value[x]", "dateTime|Period|Duration", "The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The date-valued attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of type date, dateTime, Period, Schedule, or Timing.", 0, 1, path);
          case -553645115: /*searchParam*/  return new Property("searchParam", "string", "A date parameter that refers to a search parameter defined on the specified type of the DataRequirement, and which searches on elements of type date, dateTime, Period, Schedule, or Timing.", 0, 1, searchParam);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "dateTime|Period|Duration", "The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "dateTime|Period|Duration", "The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "The value of the filter. If period is specified, the filter will return only those data items that fall within the bounds determined by the Period, inclusive of the period boundaries. If dateTime is specified, the filter will return only those data items that are equal to the specified dateTime. If a Duration is specified, the filter will return only those data items that fall within Duration before now.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : new Base[] {this.searchParam}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -553645115: // searchParam
          this.searchParam = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("searchParam")) {
          this.searchParam = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = null;
        } else if (name.equals("searchParam")) {
          this.searchParam = null;
        } else if (name.equals("value[x]")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -553645115:  return getSearchParamElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -553645115: /*searchParam*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"dateTime", "Period", "Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.dateFilter.path");
        }
        else if (name.equals("searchParam")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.dateFilter.searchParam");
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public DataRequirementDateFilterComponent copy() {
        DataRequirementDateFilterComponent dst = new DataRequirementDateFilterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DataRequirementDateFilterComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.searchParam = searchParam == null ? null : searchParam.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DataRequirementDateFilterComponent))
          return false;
        DataRequirementDateFilterComponent o = (DataRequirementDateFilterComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(searchParam, o.searchParam, true) && compareDeep(value, o.value, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DataRequirementDateFilterComponent))
          return false;
        DataRequirementDateFilterComponent o = (DataRequirementDateFilterComponent) other_;
        return compareValues(path, o.path, true) && compareValues(searchParam, o.searchParam, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, searchParam, value
          );
      }

  public String fhirType() {
    return "DataRequirement.dateFilter";

  }

  }

    @Block()
    public static class DataRequirementValueFilterComponent extends Element implements IBaseDatatypeElement {
        /**
         * The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="An attribute to filter on", formalDefinition="The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter." )
        protected StringType path;

        /**
         * A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.
         */
        @Child(name = "searchParam", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A parameter to search on", formalDefinition="A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter." )
        protected StringType searchParam;

        /**
         * The comparator to be used to determine whether the value is matching.
         */
        @Child(name = "comparator", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="eq | gt | lt | ge | le | sa | eb", formalDefinition="The comparator to be used to determine whether the value is matching." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/value-filter-comparator")
        protected Enumeration<ValueFilterComparator> comparator;

        /**
         * The value of the filter.
         */
        @Child(name = "value", type = {DateTimeType.class, Period.class, Duration.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The value of the filter, as a Period, DateTime, or Duration value", formalDefinition="The value of the filter." )
        protected DataType value;

        private static final long serialVersionUID = 2106988483L;

    /**
     * Constructor
     */
      public DataRequirementValueFilterComponent() {
        super();
      }

        /**
         * @return {@link #path} (The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementValueFilterComponent.path");
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
         * @param value {@link #path} (The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public DataRequirementValueFilterComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.
         */
        public DataRequirementValueFilterComponent setPath(String value) { 
          if (Utilities.noString(value))
            this.path = null;
          else {
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #searchParam} (A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.). This is the underlying object with id, value and extensions. The accessor "getSearchParam" gives direct access to the value
         */
        public StringType getSearchParamElement() { 
          if (this.searchParam == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementValueFilterComponent.searchParam");
            else if (Configuration.doAutoCreate())
              this.searchParam = new StringType(); // bb
          return this.searchParam;
        }

        public boolean hasSearchParamElement() { 
          return this.searchParam != null && !this.searchParam.isEmpty();
        }

        public boolean hasSearchParam() { 
          return this.searchParam != null && !this.searchParam.isEmpty();
        }

        /**
         * @param value {@link #searchParam} (A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.). This is the underlying object with id, value and extensions. The accessor "getSearchParam" gives direct access to the value
         */
        public DataRequirementValueFilterComponent setSearchParamElement(StringType value) { 
          this.searchParam = value;
          return this;
        }

        /**
         * @return A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.
         */
        public String getSearchParam() { 
          return this.searchParam == null ? null : this.searchParam.getValue();
        }

        /**
         * @param value A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.
         */
        public DataRequirementValueFilterComponent setSearchParam(String value) { 
          if (Utilities.noString(value))
            this.searchParam = null;
          else {
            if (this.searchParam == null)
              this.searchParam = new StringType();
            this.searchParam.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #comparator} (The comparator to be used to determine whether the value is matching.). This is the underlying object with id, value and extensions. The accessor "getComparator" gives direct access to the value
         */
        public Enumeration<ValueFilterComparator> getComparatorElement() { 
          if (this.comparator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementValueFilterComponent.comparator");
            else if (Configuration.doAutoCreate())
              this.comparator = new Enumeration<ValueFilterComparator>(new ValueFilterComparatorEnumFactory()); // bb
          return this.comparator;
        }

        public boolean hasComparatorElement() { 
          return this.comparator != null && !this.comparator.isEmpty();
        }

        public boolean hasComparator() { 
          return this.comparator != null && !this.comparator.isEmpty();
        }

        /**
         * @param value {@link #comparator} (The comparator to be used to determine whether the value is matching.). This is the underlying object with id, value and extensions. The accessor "getComparator" gives direct access to the value
         */
        public DataRequirementValueFilterComponent setComparatorElement(Enumeration<ValueFilterComparator> value) { 
          this.comparator = value;
          return this;
        }

        /**
         * @return The comparator to be used to determine whether the value is matching.
         */
        public ValueFilterComparator getComparator() { 
          return this.comparator == null ? null : this.comparator.getValue();
        }

        /**
         * @param value The comparator to be used to determine whether the value is matching.
         */
        public DataRequirementValueFilterComponent setComparator(ValueFilterComparator value) { 
          if (value == null)
            this.comparator = null;
          else {
            if (this.comparator == null)
              this.comparator = new Enumeration<ValueFilterComparator>(new ValueFilterComparatorEnumFactory());
            this.comparator.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #value} (The value of the filter.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the filter.)
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
         * @return {@link #value} (The value of the filter.)
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
         * @return {@link #value} (The value of the filter.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the filter.)
         */
        public DataRequirementValueFilterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Duration))
            throw new FHIRException("Not the right type for DataRequirement.valueFilter.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.", 0, 1, path));
          children.add(new Property("searchParam", "string", "A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.", 0, 1, searchParam));
          children.add(new Property("comparator", "code", "The comparator to be used to determine whether the value is matching.", 0, 1, comparator));
          children.add(new Property("value[x]", "dateTime|Period|Duration", "The value of the filter.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The attribute of the filter. The specified path SHALL be a FHIRPath resolvable on the specified type of the DataRequirement, and SHALL consist only of identifiers, constant indexers, and .resolve(). The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details). Note that the index must be an integer constant. The path must resolve to an element of a type that is comparable to the valueFilter.value[x] element for the filter.", 0, 1, path);
          case -553645115: /*searchParam*/  return new Property("searchParam", "string", "A search parameter defined on the specified type of the DataRequirement, and which searches on elements of a type compatible with the type of the valueFilter.value[x] for the filter.", 0, 1, searchParam);
          case -844673834: /*comparator*/  return new Property("comparator", "code", "The comparator to be used to determine whether the value is matching.", 0, 1, comparator);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "dateTime|Period|Duration", "The value of the filter.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "dateTime|Period|Duration", "The value of the filter.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The value of the filter.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The value of the filter.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "The value of the filter.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : new Base[] {this.searchParam}; // StringType
        case -844673834: /*comparator*/ return this.comparator == null ? new Base[0] : new Base[] {this.comparator}; // Enumeration<ValueFilterComparator>
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -553645115: // searchParam
          this.searchParam = TypeConvertor.castToString(value); // StringType
          return value;
        case -844673834: // comparator
          value = new ValueFilterComparatorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.comparator = (Enumeration) value; // Enumeration<ValueFilterComparator>
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("searchParam")) {
          this.searchParam = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("comparator")) {
          value = new ValueFilterComparatorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.comparator = (Enumeration) value; // Enumeration<ValueFilterComparator>
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = null;
        } else if (name.equals("searchParam")) {
          this.searchParam = null;
        } else if (name.equals("comparator")) {
          value = new ValueFilterComparatorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.comparator = (Enumeration) value; // Enumeration<ValueFilterComparator>
        } else if (name.equals("value[x]")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -553645115:  return getSearchParamElement();
        case -844673834:  return getComparatorElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -553645115: /*searchParam*/ return new String[] {"string"};
        case -844673834: /*comparator*/ return new String[] {"code"};
        case 111972721: /*value*/ return new String[] {"dateTime", "Period", "Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.valueFilter.path");
        }
        else if (name.equals("searchParam")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.valueFilter.searchParam");
        }
        else if (name.equals("comparator")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.valueFilter.comparator");
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public DataRequirementValueFilterComponent copy() {
        DataRequirementValueFilterComponent dst = new DataRequirementValueFilterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DataRequirementValueFilterComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.searchParam = searchParam == null ? null : searchParam.copy();
        dst.comparator = comparator == null ? null : comparator.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DataRequirementValueFilterComponent))
          return false;
        DataRequirementValueFilterComponent o = (DataRequirementValueFilterComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(searchParam, o.searchParam, true) && compareDeep(comparator, o.comparator, true)
           && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DataRequirementValueFilterComponent))
          return false;
        DataRequirementValueFilterComponent o = (DataRequirementValueFilterComponent) other_;
        return compareValues(path, o.path, true) && compareValues(searchParam, o.searchParam, true) && compareValues(comparator, o.comparator, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, searchParam, comparator
          , value);
      }

  public String fhirType() {
    return "DataRequirement.valueFilter";

  }

  }

    @Block()
    public static class DataRequirementSortComponent extends Element implements IBaseDatatypeElement {
        /**
         * The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The name of the attribute to perform the sort", formalDefinition="The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant." )
        protected StringType path;

        /**
         * The direction of the sort, ascending or descending.
         */
        @Child(name = "direction", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="ascending | descending", formalDefinition="The direction of the sort, ascending or descending." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/sort-direction")
        protected Enumeration<SortDirection> direction;

        private static final long serialVersionUID = -694498683L;

    /**
     * Constructor
     */
      public DataRequirementSortComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DataRequirementSortComponent(String path, SortDirection direction) {
        super();
        this.setPath(path);
        this.setDirection(direction);
      }

        /**
         * @return {@link #path} (The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementSortComponent.path");
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
         * @param value {@link #path} (The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public DataRequirementSortComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.
         */
        public DataRequirementSortComponent setPath(String value) { 
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          return this;
        }

        /**
         * @return {@link #direction} (The direction of the sort, ascending or descending.). This is the underlying object with id, value and extensions. The accessor "getDirection" gives direct access to the value
         */
        public Enumeration<SortDirection> getDirectionElement() { 
          if (this.direction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DataRequirementSortComponent.direction");
            else if (Configuration.doAutoCreate())
              this.direction = new Enumeration<SortDirection>(new SortDirectionEnumFactory()); // bb
          return this.direction;
        }

        public boolean hasDirectionElement() { 
          return this.direction != null && !this.direction.isEmpty();
        }

        public boolean hasDirection() { 
          return this.direction != null && !this.direction.isEmpty();
        }

        /**
         * @param value {@link #direction} (The direction of the sort, ascending or descending.). This is the underlying object with id, value and extensions. The accessor "getDirection" gives direct access to the value
         */
        public DataRequirementSortComponent setDirectionElement(Enumeration<SortDirection> value) { 
          this.direction = value;
          return this;
        }

        /**
         * @return The direction of the sort, ascending or descending.
         */
        public SortDirection getDirection() { 
          return this.direction == null ? null : this.direction.getValue();
        }

        /**
         * @param value The direction of the sort, ascending or descending.
         */
        public DataRequirementSortComponent setDirection(SortDirection value) { 
            if (this.direction == null)
              this.direction = new Enumeration<SortDirection>(new SortDirectionEnumFactory());
            this.direction.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.", 0, 1, path));
          children.add(new Property("direction", "code", "The direction of the sort, ascending or descending.", 0, 1, direction));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The attribute of the sort. The specified path must be resolvable from the type of the required data. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements. Note that the index must be an integer constant.", 0, 1, path);
          case -962590849: /*direction*/  return new Property("direction", "code", "The direction of the sort, ascending or descending.", 0, 1, direction);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -962590849: /*direction*/ return this.direction == null ? new Base[0] : new Base[] {this.direction}; // Enumeration<SortDirection>
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -962590849: // direction
          value = new SortDirectionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.direction = (Enumeration) value; // Enumeration<SortDirection>
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("direction")) {
          value = new SortDirectionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.direction = (Enumeration) value; // Enumeration<SortDirection>
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = null;
        } else if (name.equals("direction")) {
          value = new SortDirectionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.direction = (Enumeration) value; // Enumeration<SortDirection>
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -962590849:  return getDirectionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -962590849: /*direction*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.sort.path");
        }
        else if (name.equals("direction")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.sort.direction");
        }
        else
          return super.addChild(name);
      }

      public DataRequirementSortComponent copy() {
        DataRequirementSortComponent dst = new DataRequirementSortComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DataRequirementSortComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.direction = direction == null ? null : direction.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DataRequirementSortComponent))
          return false;
        DataRequirementSortComponent o = (DataRequirementSortComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(direction, o.direction, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DataRequirementSortComponent))
          return false;
        DataRequirementSortComponent o = (DataRequirementSortComponent) other_;
        return compareValues(path, o.path, true) && compareValues(direction, o.direction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, direction);
      }

  public String fhirType() {
    return "DataRequirement.sort";

  }

  }

    /**
     * The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.
     */
    @Child(name = "type", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The type of the required data", formalDefinition="The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fhir-types")
    protected Enumeration<FHIRTypes> type;

    /**
     * The profile of the required data, specified as the uri of the profile definition.
     */
    @Child(name = "profile", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The profile of the required data", formalDefinition="The profile of the required data, specified as the uri of the profile definition." )
    protected List<CanonicalType> profile;

    /**
     * The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.
     */
    @Child(name = "subject", type = {CodeableConcept.class, Group.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="E.g. Patient, Practitioner, RelatedPerson, Organization, Location, Device", formalDefinition="The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participant-resource-types")
    protected DataType subject;

    /**
     * Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. 

The value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
     */
    @Child(name = "mustSupport", type = {StringType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Indicates specific structure elements that are referenced by the knowledge module", formalDefinition="Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. \n\nThe value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details)." )
    protected List<StringType> mustSupport;

    /**
     * Code filters specify additional constraints on the data, specifying the value set of interest for a particular element of the data. Each code filter defines an additional constraint on the data, i.e. code filters are AND'ed, not OR'ed.
     */
    @Child(name = "codeFilter", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What codes are expected", formalDefinition="Code filters specify additional constraints on the data, specifying the value set of interest for a particular element of the data. Each code filter defines an additional constraint on the data, i.e. code filters are AND'ed, not OR'ed." )
    protected List<DataRequirementCodeFilterComponent> codeFilter;

    /**
     * Date filters specify additional constraints on the data in terms of the applicable date range for specific elements. Each date filter specifies an additional constraint on the data, i.e. date filters are AND'ed, not OR'ed.
     */
    @Child(name = "dateFilter", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What dates/date ranges are expected", formalDefinition="Date filters specify additional constraints on the data in terms of the applicable date range for specific elements. Each date filter specifies an additional constraint on the data, i.e. date filters are AND'ed, not OR'ed." )
    protected List<DataRequirementDateFilterComponent> dateFilter;

    /**
     * Value filters specify additional constraints on the data for elements other than code-valued or date-valued. Each value filter specifies an additional constraint on the data (i.e. valueFilters are AND'ed, not OR'ed).
     */
    @Child(name = "valueFilter", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What values are expected", formalDefinition="Value filters specify additional constraints on the data for elements other than code-valued or date-valued. Each value filter specifies an additional constraint on the data (i.e. valueFilters are AND'ed, not OR'ed)." )
    protected List<DataRequirementValueFilterComponent> valueFilter;

    /**
     * Specifies a maximum number of results that are required (uses the _count search parameter).
     */
    @Child(name = "limit", type = {PositiveIntType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of results", formalDefinition="Specifies a maximum number of results that are required (uses the _count search parameter)." )
    protected PositiveIntType limit;

    /**
     * Specifies the order of the results to be returned.
     */
    @Child(name = "sort", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Order of the results", formalDefinition="Specifies the order of the results to be returned." )
    protected List<DataRequirementSortComponent> sort;

    private static final long serialVersionUID = -2078097376L;

  /**
   * Constructor
   */
    public DataRequirement() {
      super();
    }

  /**
   * Constructor
   */
    public DataRequirement(FHIRTypes type) {
      super();
      this.setType(type);
    }

    /**
     * @return {@link #type} (The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<FHIRTypes> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DataRequirement.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<FHIRTypes>(new FHIRTypesEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public DataRequirement setTypeElement(Enumeration<FHIRTypes> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.
     */
    public FHIRTypes getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.
     */
    public DataRequirement setType(FHIRTypes value) { 
        if (this.type == null)
          this.type = new Enumeration<FHIRTypes>(new FHIRTypesEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #profile} (The profile of the required data, specified as the uri of the profile definition.)
     */
    public List<CanonicalType> getProfile() { 
      if (this.profile == null)
        this.profile = new ArrayList<CanonicalType>();
      return this.profile;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DataRequirement setProfile(List<CanonicalType> theProfile) { 
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
     * @return {@link #profile} (The profile of the required data, specified as the uri of the profile definition.)
     */
    public CanonicalType addProfileElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.profile == null)
        this.profile = new ArrayList<CanonicalType>();
      this.profile.add(t);
      return t;
    }

    /**
     * @param value {@link #profile} (The profile of the required data, specified as the uri of the profile definition.)
     */
    public DataRequirement addProfile(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.profile == null)
        this.profile = new ArrayList<CanonicalType>();
      this.profile.add(t);
      return this;
    }

    /**
     * @param value {@link #profile} (The profile of the required data, specified as the uri of the profile definition.)
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
     * @return {@link #subject} (The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.)
     */
    public DataType getSubject() { 
      return this.subject;
    }

    /**
     * @return {@link #subject} (The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.)
     */
    public CodeableConcept getSubjectCodeableConcept() throws FHIRException { 
      if (this.subject == null)
        this.subject = new CodeableConcept();
      if (!(this.subject instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (CodeableConcept) this.subject;
    }

    public boolean hasSubjectCodeableConcept() { 
      return this != null && this.subject instanceof CodeableConcept;
    }

    /**
     * @return {@link #subject} (The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.)
     */
    public Reference getSubjectReference() throws FHIRException { 
      if (this.subject == null)
        this.subject = new Reference();
      if (!(this.subject instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (Reference) this.subject;
    }

    public boolean hasSubjectReference() { 
      return this != null && this.subject instanceof Reference;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.)
     */
    public DataRequirement setSubject(DataType value) { 
      if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
        throw new FHIRException("Not the right type for DataRequirement.subject[x]: "+value.fhirType());
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #mustSupport} (Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. 

The value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).)
     */
    public List<StringType> getMustSupport() { 
      if (this.mustSupport == null)
        this.mustSupport = new ArrayList<StringType>();
      return this.mustSupport;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DataRequirement setMustSupport(List<StringType> theMustSupport) { 
      this.mustSupport = theMustSupport;
      return this;
    }

    public boolean hasMustSupport() { 
      if (this.mustSupport == null)
        return false;
      for (StringType item : this.mustSupport)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #mustSupport} (Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. 

The value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).)
     */
    public StringType addMustSupportElement() {//2 
      StringType t = new StringType();
      if (this.mustSupport == null)
        this.mustSupport = new ArrayList<StringType>();
      this.mustSupport.add(t);
      return t;
    }

    /**
     * @param value {@link #mustSupport} (Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. 

The value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).)
     */
    public DataRequirement addMustSupport(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.mustSupport == null)
        this.mustSupport = new ArrayList<StringType>();
      this.mustSupport.add(t);
      return this;
    }

    /**
     * @param value {@link #mustSupport} (Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. 

The value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).)
     */
    public boolean hasMustSupport(String value) { 
      if (this.mustSupport == null)
        return false;
      for (StringType v : this.mustSupport)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #codeFilter} (Code filters specify additional constraints on the data, specifying the value set of interest for a particular element of the data. Each code filter defines an additional constraint on the data, i.e. code filters are AND'ed, not OR'ed.)
     */
    public List<DataRequirementCodeFilterComponent> getCodeFilter() { 
      if (this.codeFilter == null)
        this.codeFilter = new ArrayList<DataRequirementCodeFilterComponent>();
      return this.codeFilter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DataRequirement setCodeFilter(List<DataRequirementCodeFilterComponent> theCodeFilter) { 
      this.codeFilter = theCodeFilter;
      return this;
    }

    public boolean hasCodeFilter() { 
      if (this.codeFilter == null)
        return false;
      for (DataRequirementCodeFilterComponent item : this.codeFilter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DataRequirementCodeFilterComponent addCodeFilter() { //3
      DataRequirementCodeFilterComponent t = new DataRequirementCodeFilterComponent();
      if (this.codeFilter == null)
        this.codeFilter = new ArrayList<DataRequirementCodeFilterComponent>();
      this.codeFilter.add(t);
      return t;
    }

    public DataRequirement addCodeFilter(DataRequirementCodeFilterComponent t) { //3
      if (t == null)
        return this;
      if (this.codeFilter == null)
        this.codeFilter = new ArrayList<DataRequirementCodeFilterComponent>();
      this.codeFilter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #codeFilter}, creating it if it does not already exist {3}
     */
    public DataRequirementCodeFilterComponent getCodeFilterFirstRep() { 
      if (getCodeFilter().isEmpty()) {
        addCodeFilter();
      }
      return getCodeFilter().get(0);
    }

    /**
     * @return {@link #dateFilter} (Date filters specify additional constraints on the data in terms of the applicable date range for specific elements. Each date filter specifies an additional constraint on the data, i.e. date filters are AND'ed, not OR'ed.)
     */
    public List<DataRequirementDateFilterComponent> getDateFilter() { 
      if (this.dateFilter == null)
        this.dateFilter = new ArrayList<DataRequirementDateFilterComponent>();
      return this.dateFilter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DataRequirement setDateFilter(List<DataRequirementDateFilterComponent> theDateFilter) { 
      this.dateFilter = theDateFilter;
      return this;
    }

    public boolean hasDateFilter() { 
      if (this.dateFilter == null)
        return false;
      for (DataRequirementDateFilterComponent item : this.dateFilter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DataRequirementDateFilterComponent addDateFilter() { //3
      DataRequirementDateFilterComponent t = new DataRequirementDateFilterComponent();
      if (this.dateFilter == null)
        this.dateFilter = new ArrayList<DataRequirementDateFilterComponent>();
      this.dateFilter.add(t);
      return t;
    }

    public DataRequirement addDateFilter(DataRequirementDateFilterComponent t) { //3
      if (t == null)
        return this;
      if (this.dateFilter == null)
        this.dateFilter = new ArrayList<DataRequirementDateFilterComponent>();
      this.dateFilter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dateFilter}, creating it if it does not already exist {3}
     */
    public DataRequirementDateFilterComponent getDateFilterFirstRep() { 
      if (getDateFilter().isEmpty()) {
        addDateFilter();
      }
      return getDateFilter().get(0);
    }

    /**
     * @return {@link #valueFilter} (Value filters specify additional constraints on the data for elements other than code-valued or date-valued. Each value filter specifies an additional constraint on the data (i.e. valueFilters are AND'ed, not OR'ed).)
     */
    public List<DataRequirementValueFilterComponent> getValueFilter() { 
      if (this.valueFilter == null)
        this.valueFilter = new ArrayList<DataRequirementValueFilterComponent>();
      return this.valueFilter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DataRequirement setValueFilter(List<DataRequirementValueFilterComponent> theValueFilter) { 
      this.valueFilter = theValueFilter;
      return this;
    }

    public boolean hasValueFilter() { 
      if (this.valueFilter == null)
        return false;
      for (DataRequirementValueFilterComponent item : this.valueFilter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DataRequirementValueFilterComponent addValueFilter() { //3
      DataRequirementValueFilterComponent t = new DataRequirementValueFilterComponent();
      if (this.valueFilter == null)
        this.valueFilter = new ArrayList<DataRequirementValueFilterComponent>();
      this.valueFilter.add(t);
      return t;
    }

    public DataRequirement addValueFilter(DataRequirementValueFilterComponent t) { //3
      if (t == null)
        return this;
      if (this.valueFilter == null)
        this.valueFilter = new ArrayList<DataRequirementValueFilterComponent>();
      this.valueFilter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #valueFilter}, creating it if it does not already exist {3}
     */
    public DataRequirementValueFilterComponent getValueFilterFirstRep() { 
      if (getValueFilter().isEmpty()) {
        addValueFilter();
      }
      return getValueFilter().get(0);
    }

    /**
     * @return {@link #limit} (Specifies a maximum number of results that are required (uses the _count search parameter).). This is the underlying object with id, value and extensions. The accessor "getLimit" gives direct access to the value
     */
    public PositiveIntType getLimitElement() { 
      if (this.limit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DataRequirement.limit");
        else if (Configuration.doAutoCreate())
          this.limit = new PositiveIntType(); // bb
      return this.limit;
    }

    public boolean hasLimitElement() { 
      return this.limit != null && !this.limit.isEmpty();
    }

    public boolean hasLimit() { 
      return this.limit != null && !this.limit.isEmpty();
    }

    /**
     * @param value {@link #limit} (Specifies a maximum number of results that are required (uses the _count search parameter).). This is the underlying object with id, value and extensions. The accessor "getLimit" gives direct access to the value
     */
    public DataRequirement setLimitElement(PositiveIntType value) { 
      this.limit = value;
      return this;
    }

    /**
     * @return Specifies a maximum number of results that are required (uses the _count search parameter).
     */
    public int getLimit() { 
      return this.limit == null || this.limit.isEmpty() ? 0 : this.limit.getValue();
    }

    /**
     * @param value Specifies a maximum number of results that are required (uses the _count search parameter).
     */
    public DataRequirement setLimit(int value) { 
        if (this.limit == null)
          this.limit = new PositiveIntType();
        this.limit.setValue(value);
      return this;
    }

    /**
     * @return {@link #sort} (Specifies the order of the results to be returned.)
     */
    public List<DataRequirementSortComponent> getSort() { 
      if (this.sort == null)
        this.sort = new ArrayList<DataRequirementSortComponent>();
      return this.sort;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DataRequirement setSort(List<DataRequirementSortComponent> theSort) { 
      this.sort = theSort;
      return this;
    }

    public boolean hasSort() { 
      if (this.sort == null)
        return false;
      for (DataRequirementSortComponent item : this.sort)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DataRequirementSortComponent addSort() { //3
      DataRequirementSortComponent t = new DataRequirementSortComponent();
      if (this.sort == null)
        this.sort = new ArrayList<DataRequirementSortComponent>();
      this.sort.add(t);
      return t;
    }

    public DataRequirement addSort(DataRequirementSortComponent t) { //3
      if (t == null)
        return this;
      if (this.sort == null)
        this.sort = new ArrayList<DataRequirementSortComponent>();
      this.sort.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #sort}, creating it if it does not already exist {3}
     */
    public DataRequirementSortComponent getSortFirstRep() { 
      if (getSort().isEmpty()) {
        addSort();
      }
      return getSort().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("type", "code", "The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.", 0, 1, type));
        children.add(new Property("profile", "canonical(StructureDefinition)", "The profile of the required data, specified as the uri of the profile definition.", 0, java.lang.Integer.MAX_VALUE, profile));
        children.add(new Property("subject[x]", "CodeableConcept|Reference(Group)", "The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.", 0, 1, subject));
        children.add(new Property("mustSupport", "string", "Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. \n\nThe value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).", 0, java.lang.Integer.MAX_VALUE, mustSupport));
        children.add(new Property("codeFilter", "", "Code filters specify additional constraints on the data, specifying the value set of interest for a particular element of the data. Each code filter defines an additional constraint on the data, i.e. code filters are AND'ed, not OR'ed.", 0, java.lang.Integer.MAX_VALUE, codeFilter));
        children.add(new Property("dateFilter", "", "Date filters specify additional constraints on the data in terms of the applicable date range for specific elements. Each date filter specifies an additional constraint on the data, i.e. date filters are AND'ed, not OR'ed.", 0, java.lang.Integer.MAX_VALUE, dateFilter));
        children.add(new Property("valueFilter", "", "Value filters specify additional constraints on the data for elements other than code-valued or date-valued. Each value filter specifies an additional constraint on the data (i.e. valueFilters are AND'ed, not OR'ed).", 0, java.lang.Integer.MAX_VALUE, valueFilter));
        children.add(new Property("limit", "positiveInt", "Specifies a maximum number of results that are required (uses the _count search parameter).", 0, 1, limit));
        children.add(new Property("sort", "", "Specifies the order of the results to be returned.", 0, java.lang.Integer.MAX_VALUE, sort));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3575610: /*type*/  return new Property("type", "code", "The type of the required data, specified as the type name of a resource. For profiles, this value is set to the type of the base resource of the profile.", 0, 1, type);
        case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition)", "The profile of the required data, specified as the uri of the profile definition.", 0, java.lang.Integer.MAX_VALUE, profile);
        case -573640748: /*subject[x]*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)", "The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.", 0, 1, subject);
        case -1867885268: /*subject*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)", "The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.", 0, 1, subject);
        case -1257122603: /*subjectCodeableConcept*/  return new Property("subject[x]", "CodeableConcept", "The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.", 0, 1, subject);
        case 772938623: /*subjectReference*/  return new Property("subject[x]", "Reference(Group)", "The intended subjects of the data requirement. If this element is not provided, a Patient subject is assumed.", 0, 1, subject);
        case -1402857082: /*mustSupport*/  return new Property("mustSupport", "string", "Indicates that specific elements of the type are referenced by the knowledge module and must be supported by the consumer in order to obtain an effective evaluation. This does not mean that a value is required for this element, only that the consuming system must understand the element and be able to provide values for it if they are available. \n\nThe value of mustSupport SHALL be a FHIRPath resolvable on the type of the DataRequirement. The path SHALL consist only of identifiers, constant indexers, and .resolve() (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).", 0, java.lang.Integer.MAX_VALUE, mustSupport);
        case -1303674939: /*codeFilter*/  return new Property("codeFilter", "", "Code filters specify additional constraints on the data, specifying the value set of interest for a particular element of the data. Each code filter defines an additional constraint on the data, i.e. code filters are AND'ed, not OR'ed.", 0, java.lang.Integer.MAX_VALUE, codeFilter);
        case 149531846: /*dateFilter*/  return new Property("dateFilter", "", "Date filters specify additional constraints on the data in terms of the applicable date range for specific elements. Each date filter specifies an additional constraint on the data, i.e. date filters are AND'ed, not OR'ed.", 0, java.lang.Integer.MAX_VALUE, dateFilter);
        case -1807110071: /*valueFilter*/  return new Property("valueFilter", "", "Value filters specify additional constraints on the data for elements other than code-valued or date-valued. Each value filter specifies an additional constraint on the data (i.e. valueFilters are AND'ed, not OR'ed).", 0, java.lang.Integer.MAX_VALUE, valueFilter);
        case 102976443: /*limit*/  return new Property("limit", "positiveInt", "Specifies a maximum number of results that are required (uses the _count search parameter).", 0, 1, limit);
        case 3536286: /*sort*/  return new Property("sort", "", "Specifies the order of the results to be returned.", 0, java.lang.Integer.MAX_VALUE, sort);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<FHIRTypes>
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : this.profile.toArray(new Base[this.profile.size()]); // CanonicalType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // DataType
        case -1402857082: /*mustSupport*/ return this.mustSupport == null ? new Base[0] : this.mustSupport.toArray(new Base[this.mustSupport.size()]); // StringType
        case -1303674939: /*codeFilter*/ return this.codeFilter == null ? new Base[0] : this.codeFilter.toArray(new Base[this.codeFilter.size()]); // DataRequirementCodeFilterComponent
        case 149531846: /*dateFilter*/ return this.dateFilter == null ? new Base[0] : this.dateFilter.toArray(new Base[this.dateFilter.size()]); // DataRequirementDateFilterComponent
        case -1807110071: /*valueFilter*/ return this.valueFilter == null ? new Base[0] : this.valueFilter.toArray(new Base[this.valueFilter.size()]); // DataRequirementValueFilterComponent
        case 102976443: /*limit*/ return this.limit == null ? new Base[0] : new Base[] {this.limit}; // PositiveIntType
        case 3536286: /*sort*/ return this.sort == null ? new Base[0] : this.sort.toArray(new Base[this.sort.size()]); // DataRequirementSortComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new FHIRTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<FHIRTypes>
          return value;
        case -309425751: // profile
          this.getProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToType(value); // DataType
          return value;
        case -1402857082: // mustSupport
          this.getMustSupport().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -1303674939: // codeFilter
          this.getCodeFilter().add((DataRequirementCodeFilterComponent) value); // DataRequirementCodeFilterComponent
          return value;
        case 149531846: // dateFilter
          this.getDateFilter().add((DataRequirementDateFilterComponent) value); // DataRequirementDateFilterComponent
          return value;
        case -1807110071: // valueFilter
          this.getValueFilter().add((DataRequirementValueFilterComponent) value); // DataRequirementValueFilterComponent
          return value;
        case 102976443: // limit
          this.limit = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 3536286: // sort
          this.getSort().add((DataRequirementSortComponent) value); // DataRequirementSortComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new FHIRTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<FHIRTypes>
        } else if (name.equals("profile")) {
          this.getProfile().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("subject[x]")) {
          this.subject = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("mustSupport")) {
          this.getMustSupport().add(TypeConvertor.castToString(value));
        } else if (name.equals("codeFilter")) {
          this.getCodeFilter().add((DataRequirementCodeFilterComponent) value);
        } else if (name.equals("dateFilter")) {
          this.getDateFilter().add((DataRequirementDateFilterComponent) value);
        } else if (name.equals("valueFilter")) {
          this.getValueFilter().add((DataRequirementValueFilterComponent) value);
        } else if (name.equals("limit")) {
          this.limit = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("sort")) {
          this.getSort().add((DataRequirementSortComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new FHIRTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<FHIRTypes>
        } else if (name.equals("profile")) {
          this.getProfile().remove(value);
        } else if (name.equals("subject[x]")) {
          this.subject = null;
        } else if (name.equals("mustSupport")) {
          this.getMustSupport().remove(value);
        } else if (name.equals("codeFilter")) {
          this.getCodeFilter().add((DataRequirementCodeFilterComponent) value);
        } else if (name.equals("dateFilter")) {
          this.getDateFilter().add((DataRequirementDateFilterComponent) value);
        } else if (name.equals("valueFilter")) {
          this.getValueFilter().add((DataRequirementValueFilterComponent) value);
        } else if (name.equals("limit")) {
          this.limit = null;
        } else if (name.equals("sort")) {
          this.getSort().add((DataRequirementSortComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -309425751:  return addProfileElement();
        case -573640748:  return getSubject();
        case -1867885268:  return getSubject();
        case -1402857082:  return addMustSupportElement();
        case -1303674939:  return addCodeFilter(); 
        case 149531846:  return addDateFilter(); 
        case -1807110071:  return addValueFilter(); 
        case 102976443:  return getLimitElement();
        case 3536286:  return addSort(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case -309425751: /*profile*/ return new String[] {"canonical"};
        case -1867885268: /*subject*/ return new String[] {"CodeableConcept", "Reference"};
        case -1402857082: /*mustSupport*/ return new String[] {"string"};
        case -1303674939: /*codeFilter*/ return new String[] {};
        case 149531846: /*dateFilter*/ return new String[] {};
        case -1807110071: /*valueFilter*/ return new String[] {};
        case 102976443: /*limit*/ return new String[] {"positiveInt"};
        case 3536286: /*sort*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.type");
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.profile");
        }
        else if (name.equals("subjectCodeableConcept")) {
          this.subject = new CodeableConcept();
          return this.subject;
        }
        else if (name.equals("subjectReference")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("mustSupport")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.mustSupport");
        }
        else if (name.equals("codeFilter")) {
          return addCodeFilter();
        }
        else if (name.equals("dateFilter")) {
          return addDateFilter();
        }
        else if (name.equals("valueFilter")) {
          return addValueFilter();
        }
        else if (name.equals("limit")) {
          throw new FHIRException("Cannot call addChild on a singleton property DataRequirement.limit");
        }
        else if (name.equals("sort")) {
          return addSort();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DataRequirement";

  }

      public DataRequirement copy() {
        DataRequirement dst = new DataRequirement();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DataRequirement dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (profile != null) {
          dst.profile = new ArrayList<CanonicalType>();
          for (CanonicalType i : profile)
            dst.profile.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        if (mustSupport != null) {
          dst.mustSupport = new ArrayList<StringType>();
          for (StringType i : mustSupport)
            dst.mustSupport.add(i.copy());
        };
        if (codeFilter != null) {
          dst.codeFilter = new ArrayList<DataRequirementCodeFilterComponent>();
          for (DataRequirementCodeFilterComponent i : codeFilter)
            dst.codeFilter.add(i.copy());
        };
        if (dateFilter != null) {
          dst.dateFilter = new ArrayList<DataRequirementDateFilterComponent>();
          for (DataRequirementDateFilterComponent i : dateFilter)
            dst.dateFilter.add(i.copy());
        };
        if (valueFilter != null) {
          dst.valueFilter = new ArrayList<DataRequirementValueFilterComponent>();
          for (DataRequirementValueFilterComponent i : valueFilter)
            dst.valueFilter.add(i.copy());
        };
        dst.limit = limit == null ? null : limit.copy();
        if (sort != null) {
          dst.sort = new ArrayList<DataRequirementSortComponent>();
          for (DataRequirementSortComponent i : sort)
            dst.sort.add(i.copy());
        };
      }

      protected DataRequirement typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DataRequirement))
          return false;
        DataRequirement o = (DataRequirement) other_;
        return compareDeep(type, o.type, true) && compareDeep(profile, o.profile, true) && compareDeep(subject, o.subject, true)
           && compareDeep(mustSupport, o.mustSupport, true) && compareDeep(codeFilter, o.codeFilter, true)
           && compareDeep(dateFilter, o.dateFilter, true) && compareDeep(valueFilter, o.valueFilter, true)
           && compareDeep(limit, o.limit, true) && compareDeep(sort, o.sort, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DataRequirement))
          return false;
        DataRequirement o = (DataRequirement) other_;
        return compareValues(type, o.type, true) && compareValues(profile, o.profile, true) && compareValues(mustSupport, o.mustSupport, true)
           && compareValues(limit, o.limit, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, profile, subject, mustSupport
          , codeFilter, dateFilter, valueFilter, limit, sort);
      }


}

