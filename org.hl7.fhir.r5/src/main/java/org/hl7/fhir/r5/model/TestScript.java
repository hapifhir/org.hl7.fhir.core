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
 * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.
 */
@ResourceDef(name="TestScript", profile="http://hl7.org/fhir/StructureDefinition/TestScript")
public class TestScript extends CanonicalResource {

    public enum AssertionDirectionType {
        /**
         * The assertion is evaluated on the response. This is the default value.
         */
        RESPONSE, 
        /**
         * The assertion is evaluated on the request.
         */
        REQUEST, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AssertionDirectionType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("response".equals(codeString))
          return RESPONSE;
        if ("request".equals(codeString))
          return REQUEST;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AssertionDirectionType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case RESPONSE: return "response";
            case REQUEST: return "request";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case RESPONSE: return "http://hl7.org/fhir/assert-direction-codes";
            case REQUEST: return "http://hl7.org/fhir/assert-direction-codes";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case RESPONSE: return "The assertion is evaluated on the response. This is the default value.";
            case REQUEST: return "The assertion is evaluated on the request.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RESPONSE: return "response";
            case REQUEST: return "request";
            default: return "?";
          }
        }
    }

  public static class AssertionDirectionTypeEnumFactory implements EnumFactory<AssertionDirectionType> {
    public AssertionDirectionType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("response".equals(codeString))
          return AssertionDirectionType.RESPONSE;
        if ("request".equals(codeString))
          return AssertionDirectionType.REQUEST;
        throw new IllegalArgumentException("Unknown AssertionDirectionType code '"+codeString+"'");
        }
        public Enumeration<AssertionDirectionType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionDirectionType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("response".equals(codeString))
          return new Enumeration<AssertionDirectionType>(this, AssertionDirectionType.RESPONSE);
        if ("request".equals(codeString))
          return new Enumeration<AssertionDirectionType>(this, AssertionDirectionType.REQUEST);
        throw new FHIRException("Unknown AssertionDirectionType code '"+codeString+"'");
        }
    public String toCode(AssertionDirectionType code) {
      if (code == AssertionDirectionType.RESPONSE)
        return "response";
      if (code == AssertionDirectionType.REQUEST)
        return "request";
      return "?";
      }
    public String toSystem(AssertionDirectionType code) {
      return code.getSystem();
      }
    }

    public enum AssertionOperatorType {
        /**
         * Default value. Equals comparison.
         */
        EQUALS, 
        /**
         * Not equals comparison.
         */
        NOTEQUALS, 
        /**
         * Compare value within a known set of values.
         */
        IN, 
        /**
         * Compare value not within a known set of values.
         */
        NOTIN, 
        /**
         * Compare value to be greater than a known value.
         */
        GREATERTHAN, 
        /**
         * Compare value to be less than a known value.
         */
        LESSTHAN, 
        /**
         * Compare value is empty.
         */
        EMPTY, 
        /**
         * Compare value is not empty.
         */
        NOTEMPTY, 
        /**
         * Compare value string contains a known value.
         */
        CONTAINS, 
        /**
         * Compare value string does not contain a known value.
         */
        NOTCONTAINS, 
        /**
         * Evaluate the FHIRPath expression as a boolean condition.
         */
        EVAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AssertionOperatorType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("equals".equals(codeString))
          return EQUALS;
        if ("notEquals".equals(codeString))
          return NOTEQUALS;
        if ("in".equals(codeString))
          return IN;
        if ("notIn".equals(codeString))
          return NOTIN;
        if ("greaterThan".equals(codeString))
          return GREATERTHAN;
        if ("lessThan".equals(codeString))
          return LESSTHAN;
        if ("empty".equals(codeString))
          return EMPTY;
        if ("notEmpty".equals(codeString))
          return NOTEMPTY;
        if ("contains".equals(codeString))
          return CONTAINS;
        if ("notContains".equals(codeString))
          return NOTCONTAINS;
        if ("eval".equals(codeString))
          return EVAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AssertionOperatorType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EQUALS: return "equals";
            case NOTEQUALS: return "notEquals";
            case IN: return "in";
            case NOTIN: return "notIn";
            case GREATERTHAN: return "greaterThan";
            case LESSTHAN: return "lessThan";
            case EMPTY: return "empty";
            case NOTEMPTY: return "notEmpty";
            case CONTAINS: return "contains";
            case NOTCONTAINS: return "notContains";
            case EVAL: return "eval";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EQUALS: return "http://hl7.org/fhir/assert-operator-codes";
            case NOTEQUALS: return "http://hl7.org/fhir/assert-operator-codes";
            case IN: return "http://hl7.org/fhir/assert-operator-codes";
            case NOTIN: return "http://hl7.org/fhir/assert-operator-codes";
            case GREATERTHAN: return "http://hl7.org/fhir/assert-operator-codes";
            case LESSTHAN: return "http://hl7.org/fhir/assert-operator-codes";
            case EMPTY: return "http://hl7.org/fhir/assert-operator-codes";
            case NOTEMPTY: return "http://hl7.org/fhir/assert-operator-codes";
            case CONTAINS: return "http://hl7.org/fhir/assert-operator-codes";
            case NOTCONTAINS: return "http://hl7.org/fhir/assert-operator-codes";
            case EVAL: return "http://hl7.org/fhir/assert-operator-codes";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EQUALS: return "Default value. Equals comparison.";
            case NOTEQUALS: return "Not equals comparison.";
            case IN: return "Compare value within a known set of values.";
            case NOTIN: return "Compare value not within a known set of values.";
            case GREATERTHAN: return "Compare value to be greater than a known value.";
            case LESSTHAN: return "Compare value to be less than a known value.";
            case EMPTY: return "Compare value is empty.";
            case NOTEMPTY: return "Compare value is not empty.";
            case CONTAINS: return "Compare value string contains a known value.";
            case NOTCONTAINS: return "Compare value string does not contain a known value.";
            case EVAL: return "Evaluate the FHIRPath expression as a boolean condition.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EQUALS: return "equals";
            case NOTEQUALS: return "notEquals";
            case IN: return "in";
            case NOTIN: return "notIn";
            case GREATERTHAN: return "greaterThan";
            case LESSTHAN: return "lessThan";
            case EMPTY: return "empty";
            case NOTEMPTY: return "notEmpty";
            case CONTAINS: return "contains";
            case NOTCONTAINS: return "notContains";
            case EVAL: return "evaluate";
            default: return "?";
          }
        }
    }

  public static class AssertionOperatorTypeEnumFactory implements EnumFactory<AssertionOperatorType> {
    public AssertionOperatorType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("equals".equals(codeString))
          return AssertionOperatorType.EQUALS;
        if ("notEquals".equals(codeString))
          return AssertionOperatorType.NOTEQUALS;
        if ("in".equals(codeString))
          return AssertionOperatorType.IN;
        if ("notIn".equals(codeString))
          return AssertionOperatorType.NOTIN;
        if ("greaterThan".equals(codeString))
          return AssertionOperatorType.GREATERTHAN;
        if ("lessThan".equals(codeString))
          return AssertionOperatorType.LESSTHAN;
        if ("empty".equals(codeString))
          return AssertionOperatorType.EMPTY;
        if ("notEmpty".equals(codeString))
          return AssertionOperatorType.NOTEMPTY;
        if ("contains".equals(codeString))
          return AssertionOperatorType.CONTAINS;
        if ("notContains".equals(codeString))
          return AssertionOperatorType.NOTCONTAINS;
        if ("eval".equals(codeString))
          return AssertionOperatorType.EVAL;
        throw new IllegalArgumentException("Unknown AssertionOperatorType code '"+codeString+"'");
        }
        public Enumeration<AssertionOperatorType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionOperatorType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("equals".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.EQUALS);
        if ("notEquals".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTEQUALS);
        if ("in".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.IN);
        if ("notIn".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTIN);
        if ("greaterThan".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.GREATERTHAN);
        if ("lessThan".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.LESSTHAN);
        if ("empty".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.EMPTY);
        if ("notEmpty".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTEMPTY);
        if ("contains".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.CONTAINS);
        if ("notContains".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTCONTAINS);
        if ("eval".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.EVAL);
        throw new FHIRException("Unknown AssertionOperatorType code '"+codeString+"'");
        }
    public String toCode(AssertionOperatorType code) {
      if (code == AssertionOperatorType.EQUALS)
        return "equals";
      if (code == AssertionOperatorType.NOTEQUALS)
        return "notEquals";
      if (code == AssertionOperatorType.IN)
        return "in";
      if (code == AssertionOperatorType.NOTIN)
        return "notIn";
      if (code == AssertionOperatorType.GREATERTHAN)
        return "greaterThan";
      if (code == AssertionOperatorType.LESSTHAN)
        return "lessThan";
      if (code == AssertionOperatorType.EMPTY)
        return "empty";
      if (code == AssertionOperatorType.NOTEMPTY)
        return "notEmpty";
      if (code == AssertionOperatorType.CONTAINS)
        return "contains";
      if (code == AssertionOperatorType.NOTCONTAINS)
        return "notContains";
      if (code == AssertionOperatorType.EVAL)
        return "eval";
      return "?";
      }
    public String toSystem(AssertionOperatorType code) {
      return code.getSystem();
      }
    }

    public enum AssertionResponseTypes {
        /**
         * Response code is 200.
         */
        OKAY, 
        /**
         * Response code is 201.
         */
        CREATED, 
        /**
         * Response code is 204.
         */
        NOCONTENT, 
        /**
         * Response code is 304.
         */
        NOTMODIFIED, 
        /**
         * Response code is 400.
         */
        BAD, 
        /**
         * Response code is 403.
         */
        FORBIDDEN, 
        /**
         * Response code is 404.
         */
        NOTFOUND, 
        /**
         * Response code is 405.
         */
        METHODNOTALLOWED, 
        /**
         * Response code is 409.
         */
        CONFLICT, 
        /**
         * Response code is 410.
         */
        GONE, 
        /**
         * Response code is 412.
         */
        PRECONDITIONFAILED, 
        /**
         * Response code is 422.
         */
        UNPROCESSABLE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AssertionResponseTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("okay".equals(codeString))
          return OKAY;
        if ("created".equals(codeString))
          return CREATED;
        if ("noContent".equals(codeString))
          return NOCONTENT;
        if ("notModified".equals(codeString))
          return NOTMODIFIED;
        if ("bad".equals(codeString))
          return BAD;
        if ("forbidden".equals(codeString))
          return FORBIDDEN;
        if ("notFound".equals(codeString))
          return NOTFOUND;
        if ("methodNotAllowed".equals(codeString))
          return METHODNOTALLOWED;
        if ("conflict".equals(codeString))
          return CONFLICT;
        if ("gone".equals(codeString))
          return GONE;
        if ("preconditionFailed".equals(codeString))
          return PRECONDITIONFAILED;
        if ("unprocessable".equals(codeString))
          return UNPROCESSABLE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AssertionResponseTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case OKAY: return "okay";
            case CREATED: return "created";
            case NOCONTENT: return "noContent";
            case NOTMODIFIED: return "notModified";
            case BAD: return "bad";
            case FORBIDDEN: return "forbidden";
            case NOTFOUND: return "notFound";
            case METHODNOTALLOWED: return "methodNotAllowed";
            case CONFLICT: return "conflict";
            case GONE: return "gone";
            case PRECONDITIONFAILED: return "preconditionFailed";
            case UNPROCESSABLE: return "unprocessable";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case OKAY: return "http://hl7.org/fhir/assert-response-code-types";
            case CREATED: return "http://hl7.org/fhir/assert-response-code-types";
            case NOCONTENT: return "http://hl7.org/fhir/assert-response-code-types";
            case NOTMODIFIED: return "http://hl7.org/fhir/assert-response-code-types";
            case BAD: return "http://hl7.org/fhir/assert-response-code-types";
            case FORBIDDEN: return "http://hl7.org/fhir/assert-response-code-types";
            case NOTFOUND: return "http://hl7.org/fhir/assert-response-code-types";
            case METHODNOTALLOWED: return "http://hl7.org/fhir/assert-response-code-types";
            case CONFLICT: return "http://hl7.org/fhir/assert-response-code-types";
            case GONE: return "http://hl7.org/fhir/assert-response-code-types";
            case PRECONDITIONFAILED: return "http://hl7.org/fhir/assert-response-code-types";
            case UNPROCESSABLE: return "http://hl7.org/fhir/assert-response-code-types";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case OKAY: return "Response code is 200.";
            case CREATED: return "Response code is 201.";
            case NOCONTENT: return "Response code is 204.";
            case NOTMODIFIED: return "Response code is 304.";
            case BAD: return "Response code is 400.";
            case FORBIDDEN: return "Response code is 403.";
            case NOTFOUND: return "Response code is 404.";
            case METHODNOTALLOWED: return "Response code is 405.";
            case CONFLICT: return "Response code is 409.";
            case GONE: return "Response code is 410.";
            case PRECONDITIONFAILED: return "Response code is 412.";
            case UNPROCESSABLE: return "Response code is 422.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case OKAY: return "okay";
            case CREATED: return "created";
            case NOCONTENT: return "noContent";
            case NOTMODIFIED: return "notModified";
            case BAD: return "bad";
            case FORBIDDEN: return "forbidden";
            case NOTFOUND: return "notFound";
            case METHODNOTALLOWED: return "methodNotAllowed";
            case CONFLICT: return "conflict";
            case GONE: return "gone";
            case PRECONDITIONFAILED: return "preconditionFailed";
            case UNPROCESSABLE: return "unprocessable";
            default: return "?";
          }
        }
    }

  public static class AssertionResponseTypesEnumFactory implements EnumFactory<AssertionResponseTypes> {
    public AssertionResponseTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("okay".equals(codeString))
          return AssertionResponseTypes.OKAY;
        if ("created".equals(codeString))
          return AssertionResponseTypes.CREATED;
        if ("noContent".equals(codeString))
          return AssertionResponseTypes.NOCONTENT;
        if ("notModified".equals(codeString))
          return AssertionResponseTypes.NOTMODIFIED;
        if ("bad".equals(codeString))
          return AssertionResponseTypes.BAD;
        if ("forbidden".equals(codeString))
          return AssertionResponseTypes.FORBIDDEN;
        if ("notFound".equals(codeString))
          return AssertionResponseTypes.NOTFOUND;
        if ("methodNotAllowed".equals(codeString))
          return AssertionResponseTypes.METHODNOTALLOWED;
        if ("conflict".equals(codeString))
          return AssertionResponseTypes.CONFLICT;
        if ("gone".equals(codeString))
          return AssertionResponseTypes.GONE;
        if ("preconditionFailed".equals(codeString))
          return AssertionResponseTypes.PRECONDITIONFAILED;
        if ("unprocessable".equals(codeString))
          return AssertionResponseTypes.UNPROCESSABLE;
        throw new IllegalArgumentException("Unknown AssertionResponseTypes code '"+codeString+"'");
        }
        public Enumeration<AssertionResponseTypes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionResponseTypes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("okay".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.OKAY);
        if ("created".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.CREATED);
        if ("noContent".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOCONTENT);
        if ("notModified".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOTMODIFIED);
        if ("bad".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.BAD);
        if ("forbidden".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.FORBIDDEN);
        if ("notFound".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOTFOUND);
        if ("methodNotAllowed".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.METHODNOTALLOWED);
        if ("conflict".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.CONFLICT);
        if ("gone".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.GONE);
        if ("preconditionFailed".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.PRECONDITIONFAILED);
        if ("unprocessable".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.UNPROCESSABLE);
        throw new FHIRException("Unknown AssertionResponseTypes code '"+codeString+"'");
        }
    public String toCode(AssertionResponseTypes code) {
      if (code == AssertionResponseTypes.OKAY)
        return "okay";
      if (code == AssertionResponseTypes.CREATED)
        return "created";
      if (code == AssertionResponseTypes.NOCONTENT)
        return "noContent";
      if (code == AssertionResponseTypes.NOTMODIFIED)
        return "notModified";
      if (code == AssertionResponseTypes.BAD)
        return "bad";
      if (code == AssertionResponseTypes.FORBIDDEN)
        return "forbidden";
      if (code == AssertionResponseTypes.NOTFOUND)
        return "notFound";
      if (code == AssertionResponseTypes.METHODNOTALLOWED)
        return "methodNotAllowed";
      if (code == AssertionResponseTypes.CONFLICT)
        return "conflict";
      if (code == AssertionResponseTypes.GONE)
        return "gone";
      if (code == AssertionResponseTypes.PRECONDITIONFAILED)
        return "preconditionFailed";
      if (code == AssertionResponseTypes.UNPROCESSABLE)
        return "unprocessable";
      return "?";
      }
    public String toSystem(AssertionResponseTypes code) {
      return code.getSystem();
      }
    }

    public enum FHIRDefinedType {
        /**
         * An address expressed using postal conventions (as opposed to GPS or other location definition formats).  This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery.  There are a variety of postal address formats defined around the world.
         */
        ADDRESS, 
        /**
         * A duration of time during which an organism (or a process) has existed.
         */
        AGE, 
        /**
         * A  text note which also  contains information about who made the statement and when.
         */
        ANNOTATION, 
        /**
         * For referring to data content defined in other formats.
         */
        ATTACHMENT, 
        /**
         * Base definition for all elements that are defined inside a resource - but not those in a data type.
         */
        BACKBONEELEMENT, 
        /**
         * Base definition for the few data types that are allowed to carry modifier extensions.
         */
        BACKBONETYPE, 
        /**
         * Base definition for all types defined in FHIR type system.
         */
        BASE, 
        /**
         * A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.
         */
        CODEABLECONCEPT, 
        /**
         * A reference to a resource (by instance), or instead, a reference to a cencept defined in a terminology or ontology (by class).
         */
        CODEABLEREFERENCE, 
        /**
         * A reference to a code defined by a terminology system.
         */
        CODING, 
        /**
         * Specifies contact information for a person or organization.
         */
        CONTACTDETAIL, 
        /**
         * Details for all kinds of technology mediated contact points for a person or organization, including telephone, email, etc.
         */
        CONTACTPOINT, 
        /**
         * A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.
         */
        CONTRIBUTOR, 
        /**
         * A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
         */
        COUNT, 
        /**
         * Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.
         */
        DATAREQUIREMENT, 
        /**
         * The base class for all re-useable types defined as part of the FHIR Specification.
         */
        DATATYPE, 
        /**
         * A length - a value with a unit that is a physical distance.
         */
        DISTANCE, 
        /**
         * Indicates how the medication is/was taken or should be taken by the patient.
         */
        DOSAGE, 
        /**
         * A length of time.
         */
        DURATION, 
        /**
         * Base definition for all elements in a resource.
         */
        ELEMENT, 
        /**
         * Captures constraints on each element within the resource, profile, or extension.
         */
        ELEMENTDEFINITION, 
        /**
         * A expression that is evaluated in a specified context and returns a value. The context of use of the expression must specify the context in which the expression is evaluated, and how the result of the expression is used.
         */
        EXPRESSION, 
        /**
         * Optional Extension Element - found in all resources.
         */
        EXTENSION, 
        /**
         * A human's name with the ability to identify parts and usage.
         */
        HUMANNAME, 
        /**
         * An identifier - identifies some entity uniquely and unambiguously. Typically this is used for business identifiers.
         */
        IDENTIFIER, 
        /**
         * The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.
         */
        MARKETINGSTATUS, 
        /**
         * The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to the content might not always be associated with version changes to the resource.
         */
        META, 
        /**
         * An amount of economic utility in some recognized currency.
         */
        MONEY, 
        /**
         * 
         */
        MONEYQUANTITY, 
        /**
         * A human-readable summary of the resource conveying the essential clinical and business information for the resource.
         */
        NARRATIVE, 
        /**
         * An ordered list (distribution) of statistics.
         */
        ORDEREDDISTRIBUTION, 
        /**
         * The parameters to the module. This collection specifies both the input and output parameters. Input parameters are provided by the caller as part of the $evaluate operation. Output parameters are included in the GuidanceResponse.
         */
        PARAMETERDEFINITION, 
        /**
         * A time period defined by a start and end date and optionally time.
         */
        PERIOD, 
        /**
         * A populatioof people with some set of grouping criteria.
         */
        POPULATION, 
        /**
         * The base type for all re-useable types defined that have a simple property.
         */
        PRIMITIVETYPE, 
        /**
         * The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.
         */
        PRODCHARACTERISTIC, 
        /**
         * The shelf-life and storage information for a medicinal product item or container can be described using this class.
         */
        PRODUCTSHELFLIFE, 
        /**
         * A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
         */
        QUANTITY, 
        /**
         * A set of ordered Quantities defined by a low and high limit.
         */
        RANGE, 
        /**
         * A relationship of two Quantity values - expressed as a numerator and a denominator.
         */
        RATIO, 
        /**
         * A reference from one resource to another.
         */
        REFERENCE, 
        /**
         * Related artifacts such as additional documentation, justification, or bibliographic references.
         */
        RELATEDARTIFACT, 
        /**
         * A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.
         */
        SAMPLEDDATA, 
        /**
         * A signature along with supporting context. The signature may be a digital signature that is cryptographic in nature, or some other signature acceptable to the domain. This other signature may be as simple as a graphical image representing a hand-written signature, or a signature ceremony Different signature approaches have different utilities.
         */
        SIGNATURE, 
        /**
         * 
         */
        SIMPLEQUANTITY, 
        /**
         * A fact or piece of data from a  study of a large quantity of numerical data.  A mathematical or quantified characteristic of a group of observations.
         */
        STATISTIC, 
        /**
         * Chemical substances are a single substance type whose primary defining element is the molecular structure. Chemical substances shall be defined on the basis of their complete covalent molecular structure; the presence of a salt (counter-ion) and/or solvates (water, alcohols) is also captured. Purity, grade, physical form or particle size are not taken into account in the definition of a chemical substance or in the assignment of a Substance ID.
         */
        SUBSTANCEAMOUNT, 
        /**
         * Specifies an event that may occur multiple times. Timing schedules are used to record when things are planned, expected or requested to occur. The most common usage is in dosage instructions for medications. They are also used when planning care of various kinds, and may be used for reporting the schedule to which past regular activities were carried out.
         */
        TIMING, 
        /**
         * A description of a triggering event. Triggering events can be named events, data events, or periodic, as determined by the type element.
         */
        TRIGGERDEFINITION, 
        /**
         * Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact. This metadata can either be specific to the applicable population (e.g., age category, DRG) or the specific context of care (e.g., venue, care setting, provider of care).
         */
        USAGECONTEXT, 
        /**
         * A stream of bytes
         */
        BASE64BINARY, 
        /**
         * Value of \"true\" or \"false\"
         */
        BOOLEAN, 
        /**
         * A URI that is a reference to a canonical URL on a FHIR resource
         */
        CANONICAL, 
        /**
         * A string which has at least one character and no leading or trailing whitespace and where there is no whitespace other than single spaces in the contents
         */
        CODE, 
        /**
         * A date or partial date (e.g. just year or year + month). There is no time zone. The format is a union of the schema types gYear, gYearMonth and date.  Dates SHALL be valid dates.
         */
        DATE, 
        /**
         * A date, date-time or partial date (e.g. just year or year + month).  If hours and minutes are specified, a time zone SHALL be populated. The format is a union of the schema types gYear, gYearMonth, date and dateTime. Seconds must be provided due to schema type constraints but may be zero-filled and may be ignored.                 Dates SHALL be valid dates.
         */
        DATETIME, 
        /**
         * A rational number with implicit precision
         */
        DECIMAL, 
        /**
         * Any combination of letters, numerals, \"-\" and \".\", with a length limit of 64 characters.  (This might be an integer, an unprefixed OID, UUID or any other identifier pattern that meets these constraints.)  Ids are case-insensitive.
         */
        ID, 
        /**
         * An instant in time - known at least to the second
         */
        INSTANT, 
        /**
         * A whole number
         */
        INTEGER, 
        /**
         * A very large whole number
         */
        INTEGER64, 
        /**
         * A string that may contain Github Flavored Markdown syntax for optional processing by a mark down presentation engine
         */
        MARKDOWN, 
        /**
         * An OID represented as a URI
         */
        OID, 
        /**
         * An integer with a value that is positive (e.g. >0)
         */
        POSITIVEINT, 
        /**
         * A sequence of Unicode characters
         */
        STRING, 
        /**
         * A time during the day, with no date specified
         */
        TIME, 
        /**
         * An integer with a value that is not negative (e.g. >= 0)
         */
        UNSIGNEDINT, 
        /**
         * String of characters used to identify a name or a resource
         */
        URI, 
        /**
         * A URI that is a literal reference
         */
        URL, 
        /**
         * A UUID, represented as a URI
         */
        UUID, 
        /**
         * XHTML format, as defined by W3C, but restricted usage (mainly, no active content)
         */
        XHTML, 
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * A pharmaceutical product described in terms of its composition and dose form.
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.
         */
        ADVERSEEVENT, 
        /**
         * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.
         */
        ALLERGYINTOLERANCE, 
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
         */
        APPOINTMENTRESPONSE, 
        /**
         * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.
         */
        AUDITEVENT, 
        /**
         * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
         */
        BASIC, 
        /**
         * A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.
         */
        BINARY, 
        /**
         * A material substance originating from a biological entity intended to be transplanted or infused\ninto another (possibly the same) biological entity.
         */
        BIOLOGICALLYDERIVEDPRODUCT, 
        /**
         * Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.
         */
        BODYSTRUCTURE, 
        /**
         * A container for a collection of resources.
         */
        BUNDLE, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT2, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * Catalog entries are wrappers that contextualize items included in a catalog.
         */
        CATALOGENTRY, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
        /**
         * The Citation.
         */
        CITATION, 
        /**
         * A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.
         */
        CLAIM, 
        /**
         * This resource provides the adjudication details from the processing of a Claim resource.
         */
        CLAIMRESPONSE, 
        /**
         * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.
         */
        CLINICALIMPRESSION, 
        /**
         * A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
         */
        CLINICALUSEISSUE, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
         */
        COMMUNICATION, 
        /**
         * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
         */
        COMMUNICATIONREQUEST, 
        /**
         * A compartment definition that defines how resources are accessed on a server.
         */
        COMPARTMENTDEFINITION, 
        /**
         * A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).
         */
        COMPOSITION, 
        /**
         * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.
         */
        CONCEPTMAP, 
        /**
         * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.
         */
        CONDITION, 
        /**
         * A definition of a condition and information relevant to managing it.
         */
        CONDITIONDEFINITION, 
        /**
         * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
         */
        CONSENT, 
        /**
         * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.
         */
        CONTRACT, 
        /**
         * Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.
         */
        COVERAGE, 
        /**
         * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.
         */
        COVERAGEELIGIBILITYREQUEST, 
        /**
         * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
         */
        COVERAGEELIGIBILITYRESPONSE, 
        /**
         * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.
         */
        DETECTEDISSUE, 
        /**
         * A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.
         */
        DEVICE, 
        /**
         * The characteristics, operational status and capabilities of a medical-related component of a medical device.
         */
        DEVICEDEFINITION, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.
         */
        DEVICEUSESTATEMENT, 
        /**
         * The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.
         */
        DIAGNOSTICREPORT, 
        /**
         * A collection of documents compiled for a purpose together with metadata that applies to the collection.
         */
        DOCUMENTMANIFEST, 
        /**
         * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
         */
        DOCUMENTREFERENCE, 
        /**
         * A resource that includes narrative, extensions, and contained resources.
         */
        DOMAINRESOURCE, 
        /**
         * An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.
         */
        ENDPOINT, 
        /**
         * This resource provides the insurance enrollment details to the insurer regarding a specified coverage.
         */
        ENROLLMENTREQUEST, 
        /**
         * This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.
         */
        ENROLLMENTRESPONSE, 
        /**
         * An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.
         */
        EPISODEOFCARE, 
        /**
         * The EventDefinition resource provides a reusable description of when a particular event can occur.
         */
        EVENTDEFINITION, 
        /**
         * This represents statistics, certainty, both the intended and actual population, and evidence variables.
         */
        EVIDENCE, 
        /**
         * EvidenceFocus.
         */
        EVIDENCEFOCUS, 
        /**
         * The EvidenceVariable resource describes an element that knowledge (Evidence) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * Example of workflow instance.
         */
        EXAMPLESCENARIO, 
        /**
         * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.
         */
        EXPLANATIONOFBENEFIT, 
        /**
         * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
         */
        FAMILYMEMBERHISTORY, 
        /**
         * Prospective warnings of potential issues when providing care to the patient.
         */
        FLAG, 
        /**
         * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.
         */
        GOAL, 
        /**
         * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.
         */
        GRAPHDEFINITION, 
        /**
         * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.
         */
        GROUP, 
        /**
         * A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.
         */
        GUIDANCERESPONSE, 
        /**
         * The details of a healthcare service available at a location.
         */
        HEALTHCARESERVICE, 
        /**
         * Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
         */
        IMAGINGSTUDY, 
        /**
         * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.
         */
        IMMUNIZATION, 
        /**
         * Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.
         */
        IMMUNIZATIONEVALUATION, 
        /**
         * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.
         */
        IMMUNIZATIONRECOMMENDATION, 
        /**
         * A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.
         */
        IMPLEMENTATIONGUIDE, 
        /**
         * An ingredient of a manufactured item or pharmaceutical product.
         */
        INGREDIENT, 
        /**
         * Details of a Health Insurance product/plan provided by an organization.
         */
        INSURANCEPLAN, 
        /**
         * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.
         */
        INVOICE, 
        /**
         * The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.
         */
        LIBRARY, 
        /**
         * Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".
         */
        LINKAGE, 
        /**
         * A list is a curated collection of resources.
         */
        LIST, 
        /**
         * Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.
         */
        LOCATION, 
        /**
         * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.
         */
        MANUFACTUREDITEMDEFINITION, 
        /**
         * The Measure resource provides the definition of a quality measure.
         */
        MEASURE, 
        /**
         * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.
         */
        MEASUREREPORT, 
        /**
         * This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
         */
        MEDICATION, 
        /**
         * Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.
         */
        MEDICATIONADMINISTRATION, 
        /**
         * Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.
         */
        MEDICATIONDISPENSE, 
        /**
         * Information about a medication that is used to support knowledge.
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
         */
        MEDICATIONREQUEST, 
        /**
         * A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.
         */
        MEDICATIONUSAGE, 
        /**
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).
         */
        MEDICINALPRODUCTDEFINITION, 
        /**
         * Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.
         */
        MESSAGEDEFINITION, 
        /**
         * The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.
         */
        MESSAGEHEADER, 
        /**
         * Raw data describing a biological sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
        /**
         * A food or fluid product that is consumed by patients.
         */
        NUTRITIONPRODUCT, 
        /**
         * Measurements and simple assertions made about a patient, device or other subject.
         */
        OBSERVATION, 
        /**
         * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.
         */
        OBSERVATIONDEFINITION, 
        /**
         * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
         */
        OPERATIONDEFINITION, 
        /**
         * A collection of error, warning, or information messages that result from a system action.
         */
        OPERATIONOUTCOME, 
        /**
         * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.
         */
        ORGANIZATION, 
        /**
         * Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medicinal product in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.
         */
        PARAMETERS, 
        /**
         * Demographics and other administrative information about an individual or animal receiving care or other health-related services.
         */
        PATIENT, 
        /**
         * This resource provides the status of the payment for goods and services rendered, and the request and response resource references.
         */
        PAYMENTNOTICE, 
        /**
         * This resource provides the details including amount of a payment and allocates the payment items being paid.
         */
        PAYMENTRECONCILIATION, 
        /**
         * Permission.
         */
        PERMISSION, 
        /**
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.
         */
        PROCEDURE, 
        /**
         * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.
         */
        PROVENANCE, 
        /**
         * A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.
         */
        QUESTIONNAIRE, 
        /**
         * A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.
         */
        QUESTIONNAIRERESPONSE, 
        /**
         * The regulatory authorization of a medicinal product, device or process.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A group of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".
         */
        REQUESTGROUP, 
        /**
         * A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.
         */
        RESEARCHSTUDY, 
        /**
         * A physical entity which is the primary unit of operational and/or administrative interest in a study.
         */
        RESEARCHSUBJECT, 
        /**
         * This is the base resource type for everything.
         */
        RESOURCE, 
        /**
         * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
         */
        RISKASSESSMENT, 
        /**
         * A container for slots of time that may be available for booking appointments.
         */
        SCHEDULE, 
        /**
         * A search parameter that defines a named search item that can be used to search/filter on a resource.
         */
        SEARCHPARAMETER, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * A slot of time on a schedule that may be available for booking appointments.
         */
        SLOT, 
        /**
         * A sample to be used for analysis.
         */
        SPECIMEN, 
        /**
         * A kind of specimen with associated set of requirements.
         */
        SPECIMENDEFINITION, 
        /**
         * A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.
         */
        STRUCTUREDEFINITION, 
        /**
         * A Map of relationships between 2 structures that can be used to transform data.
         */
        STRUCTUREMAP, 
        /**
         * The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.
         */
        SUBSCRIPTION, 
        /**
         * The SubscriptionStatus resource describes the state of a Subscription during notifications.
         */
        SUBSCRIPTIONSTATUS, 
        /**
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        SUBSCRIPTIONTOPIC, 
        /**
         * A homogeneous material with a definite composition.
         */
        SUBSTANCE, 
        /**
         * The detailed description of a substance, typically at a level beyond what is used for prescribing.
         */
        SUBSTANCEDEFINITION, 
        /**
         * Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.
         */
        SUBSTANCENUCLEICACID, 
        /**
         * Todo.
         */
        SUBSTANCEPOLYMER, 
        /**
         * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.
         */
        SUBSTANCEPROTEIN, 
        /**
         * Todo.
         */
        SUBSTANCEREFERENCEINFORMATION, 
        /**
         * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.
         */
        SUBSTANCESOURCEMATERIAL, 
        /**
         * Record of delivery of what is supplied.
         */
        SUPPLYDELIVERY, 
        /**
         * A record of a request for a medication, substance or device used in the healthcare setting.
         */
        SUPPLYREQUEST, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        TERMINOLOGYCAPABILITIES, 
        /**
         * A summary of information based on the results of executing a TestScript.
         */
        TESTREPORT, 
        /**
         * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.
         */
        TESTSCRIPT, 
        /**
         * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).
         */
        VALUESET, 
        /**
         * Describes validation requirements, source(s), status and dates for one or more elements.
         */
        VERIFICATIONRESULT, 
        /**
         * An authorization for the provision of glasses and/or contact lenses to a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static FHIRDefinedType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Address".equals(codeString))
          return ADDRESS;
        if ("Age".equals(codeString))
          return AGE;
        if ("Annotation".equals(codeString))
          return ANNOTATION;
        if ("Attachment".equals(codeString))
          return ATTACHMENT;
        if ("BackboneElement".equals(codeString))
          return BACKBONEELEMENT;
        if ("BackboneType".equals(codeString))
          return BACKBONETYPE;
        if ("Base".equals(codeString))
          return BASE;
        if ("CodeableConcept".equals(codeString))
          return CODEABLECONCEPT;
        if ("CodeableReference".equals(codeString))
          return CODEABLEREFERENCE;
        if ("Coding".equals(codeString))
          return CODING;
        if ("ContactDetail".equals(codeString))
          return CONTACTDETAIL;
        if ("ContactPoint".equals(codeString))
          return CONTACTPOINT;
        if ("Contributor".equals(codeString))
          return CONTRIBUTOR;
        if ("Count".equals(codeString))
          return COUNT;
        if ("DataRequirement".equals(codeString))
          return DATAREQUIREMENT;
        if ("DataType".equals(codeString))
          return DATATYPE;
        if ("Distance".equals(codeString))
          return DISTANCE;
        if ("Dosage".equals(codeString))
          return DOSAGE;
        if ("Duration".equals(codeString))
          return DURATION;
        if ("Element".equals(codeString))
          return ELEMENT;
        if ("ElementDefinition".equals(codeString))
          return ELEMENTDEFINITION;
        if ("Expression".equals(codeString))
          return EXPRESSION;
        if ("Extension".equals(codeString))
          return EXTENSION;
        if ("HumanName".equals(codeString))
          return HUMANNAME;
        if ("Identifier".equals(codeString))
          return IDENTIFIER;
        if ("MarketingStatus".equals(codeString))
          return MARKETINGSTATUS;
        if ("Meta".equals(codeString))
          return META;
        if ("Money".equals(codeString))
          return MONEY;
        if ("MoneyQuantity".equals(codeString))
          return MONEYQUANTITY;
        if ("Narrative".equals(codeString))
          return NARRATIVE;
        if ("OrderedDistribution".equals(codeString))
          return ORDEREDDISTRIBUTION;
        if ("ParameterDefinition".equals(codeString))
          return PARAMETERDEFINITION;
        if ("Period".equals(codeString))
          return PERIOD;
        if ("Population".equals(codeString))
          return POPULATION;
        if ("PrimitiveType".equals(codeString))
          return PRIMITIVETYPE;
        if ("ProdCharacteristic".equals(codeString))
          return PRODCHARACTERISTIC;
        if ("ProductShelfLife".equals(codeString))
          return PRODUCTSHELFLIFE;
        if ("Quantity".equals(codeString))
          return QUANTITY;
        if ("Range".equals(codeString))
          return RANGE;
        if ("Ratio".equals(codeString))
          return RATIO;
        if ("Reference".equals(codeString))
          return REFERENCE;
        if ("RelatedArtifact".equals(codeString))
          return RELATEDARTIFACT;
        if ("SampledData".equals(codeString))
          return SAMPLEDDATA;
        if ("Signature".equals(codeString))
          return SIGNATURE;
        if ("SimpleQuantity".equals(codeString))
          return SIMPLEQUANTITY;
        if ("Statistic".equals(codeString))
          return STATISTIC;
        if ("SubstanceAmount".equals(codeString))
          return SUBSTANCEAMOUNT;
        if ("Timing".equals(codeString))
          return TIMING;
        if ("TriggerDefinition".equals(codeString))
          return TRIGGERDEFINITION;
        if ("UsageContext".equals(codeString))
          return USAGECONTEXT;
        if ("base64Binary".equals(codeString))
          return BASE64BINARY;
        if ("boolean".equals(codeString))
          return BOOLEAN;
        if ("canonical".equals(codeString))
          return CANONICAL;
        if ("code".equals(codeString))
          return CODE;
        if ("date".equals(codeString))
          return DATE;
        if ("dateTime".equals(codeString))
          return DATETIME;
        if ("decimal".equals(codeString))
          return DECIMAL;
        if ("id".equals(codeString))
          return ID;
        if ("instant".equals(codeString))
          return INSTANT;
        if ("integer".equals(codeString))
          return INTEGER;
        if ("integer64".equals(codeString))
          return INTEGER64;
        if ("markdown".equals(codeString))
          return MARKDOWN;
        if ("oid".equals(codeString))
          return OID;
        if ("positiveInt".equals(codeString))
          return POSITIVEINT;
        if ("string".equals(codeString))
          return STRING;
        if ("time".equals(codeString))
          return TIME;
        if ("unsignedInt".equals(codeString))
          return UNSIGNEDINT;
        if ("uri".equals(codeString))
          return URI;
        if ("url".equals(codeString))
          return URL;
        if ("uuid".equals(codeString))
          return UUID;
        if ("xhtml".equals(codeString))
          return XHTML;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return APPOINTMENTRESPONSE;
        if ("AuditEvent".equals(codeString))
          return AUDITEVENT;
        if ("Basic".equals(codeString))
          return BASIC;
        if ("Binary".equals(codeString))
          return BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return CAPABILITYSTATEMENT;
        if ("CapabilityStatement2".equals(codeString))
          return CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return CITATION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return CLINICALUSEISSUE;
        if ("CodeSystem".equals(codeString))
          return CODESYSTEM;
        if ("Communication".equals(codeString))
          return COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return CONCEPTMAP;
        if ("Condition".equals(codeString))
          return CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return CONSENT;
        if ("Contract".equals(codeString))
          return CONTRACT;
        if ("Coverage".equals(codeString))
          return COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return DETECTEDISSUE;
        if ("Device".equals(codeString))
          return DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return DEVICEDEFINITION;
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return DEVICEUSESTATEMENT;
        if ("DiagnosticReport".equals(codeString))
          return DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return EVIDENCE;
        if ("EvidenceFocus".equals(codeString))
          return EVIDENCEFOCUS;
        if ("EvidenceVariable".equals(codeString))
          return EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FLAG;
        if ("Goal".equals(codeString))
          return GOAL;
        if ("GraphDefinition".equals(codeString))
          return GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return GROUP;
        if ("GuidanceResponse".equals(codeString))
          return GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return HEALTHCARESERVICE;
        if ("ImagingStudy".equals(codeString))
          return IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return INSURANCEPLAN;
        if ("Invoice".equals(codeString))
          return INVOICE;
        if ("Library".equals(codeString))
          return LIBRARY;
        if ("Linkage".equals(codeString))
          return LINKAGE;
        if ("List".equals(codeString))
          return LIST;
        if ("Location".equals(codeString))
          return LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return MEASURE;
        if ("MeasureReport".equals(codeString))
          return MEASUREREPORT;
        if ("Medication".equals(codeString))
          return MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return PARAMETERS;
        if ("Patient".equals(codeString))
          return PATIENT;
        if ("PaymentNotice".equals(codeString))
          return PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return PERMISSION;
        if ("Person".equals(codeString))
          return PERSON;
        if ("PlanDefinition".equals(codeString))
          return PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return PROCEDURE;
        if ("Provenance".equals(codeString))
          return PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return RELATEDPERSON;
        if ("RequestGroup".equals(codeString))
          return REQUESTGROUP;
        if ("ResearchStudy".equals(codeString))
          return RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return SLOT;
        if ("Specimen".equals(codeString))
          return SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return TESTREPORT;
        if ("TestScript".equals(codeString))
          return TESTSCRIPT;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown FHIRDefinedType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ADDRESS: return "Address";
            case AGE: return "Age";
            case ANNOTATION: return "Annotation";
            case ATTACHMENT: return "Attachment";
            case BACKBONEELEMENT: return "BackboneElement";
            case BACKBONETYPE: return "BackboneType";
            case BASE: return "Base";
            case CODEABLECONCEPT: return "CodeableConcept";
            case CODEABLEREFERENCE: return "CodeableReference";
            case CODING: return "Coding";
            case CONTACTDETAIL: return "ContactDetail";
            case CONTACTPOINT: return "ContactPoint";
            case CONTRIBUTOR: return "Contributor";
            case COUNT: return "Count";
            case DATAREQUIREMENT: return "DataRequirement";
            case DATATYPE: return "DataType";
            case DISTANCE: return "Distance";
            case DOSAGE: return "Dosage";
            case DURATION: return "Duration";
            case ELEMENT: return "Element";
            case ELEMENTDEFINITION: return "ElementDefinition";
            case EXPRESSION: return "Expression";
            case EXTENSION: return "Extension";
            case HUMANNAME: return "HumanName";
            case IDENTIFIER: return "Identifier";
            case MARKETINGSTATUS: return "MarketingStatus";
            case META: return "Meta";
            case MONEY: return "Money";
            case MONEYQUANTITY: return "MoneyQuantity";
            case NARRATIVE: return "Narrative";
            case ORDEREDDISTRIBUTION: return "OrderedDistribution";
            case PARAMETERDEFINITION: return "ParameterDefinition";
            case PERIOD: return "Period";
            case POPULATION: return "Population";
            case PRIMITIVETYPE: return "PrimitiveType";
            case PRODCHARACTERISTIC: return "ProdCharacteristic";
            case PRODUCTSHELFLIFE: return "ProductShelfLife";
            case QUANTITY: return "Quantity";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case REFERENCE: return "Reference";
            case RELATEDARTIFACT: return "RelatedArtifact";
            case SAMPLEDDATA: return "SampledData";
            case SIGNATURE: return "Signature";
            case SIMPLEQUANTITY: return "SimpleQuantity";
            case STATISTIC: return "Statistic";
            case SUBSTANCEAMOUNT: return "SubstanceAmount";
            case TIMING: return "Timing";
            case TRIGGERDEFINITION: return "TriggerDefinition";
            case USAGECONTEXT: return "UsageContext";
            case BASE64BINARY: return "base64Binary";
            case BOOLEAN: return "boolean";
            case CANONICAL: return "canonical";
            case CODE: return "code";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case DECIMAL: return "decimal";
            case ID: return "id";
            case INSTANT: return "instant";
            case INTEGER: return "integer";
            case INTEGER64: return "integer64";
            case MARKDOWN: return "markdown";
            case OID: return "oid";
            case POSITIVEINT: return "positiveInt";
            case STRING: return "string";
            case TIME: return "time";
            case UNSIGNEDINT: return "unsignedInt";
            case URI: return "uri";
            case URL: return "url";
            case UUID: return "uuid";
            case XHTML: return "xhtml";
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case DOMAINRESOURCE: return "DomainResource";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEFOCUS: return "EvidenceFocus";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTGROUP: return "RequestGroup";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RESOURCE: return "Resource";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ADDRESS: return "http://hl7.org/fhir/data-types";
            case AGE: return "http://hl7.org/fhir/data-types";
            case ANNOTATION: return "http://hl7.org/fhir/data-types";
            case ATTACHMENT: return "http://hl7.org/fhir/data-types";
            case BACKBONEELEMENT: return "http://hl7.org/fhir/data-types";
            case BACKBONETYPE: return "http://hl7.org/fhir/data-types";
            case BASE: return "http://hl7.org/fhir/data-types";
            case CODEABLECONCEPT: return "http://hl7.org/fhir/data-types";
            case CODEABLEREFERENCE: return "http://hl7.org/fhir/data-types";
            case CODING: return "http://hl7.org/fhir/data-types";
            case CONTACTDETAIL: return "http://hl7.org/fhir/data-types";
            case CONTACTPOINT: return "http://hl7.org/fhir/data-types";
            case CONTRIBUTOR: return "http://hl7.org/fhir/data-types";
            case COUNT: return "http://hl7.org/fhir/data-types";
            case DATAREQUIREMENT: return "http://hl7.org/fhir/data-types";
            case DATATYPE: return "http://hl7.org/fhir/data-types";
            case DISTANCE: return "http://hl7.org/fhir/data-types";
            case DOSAGE: return "http://hl7.org/fhir/data-types";
            case DURATION: return "http://hl7.org/fhir/data-types";
            case ELEMENT: return "http://hl7.org/fhir/data-types";
            case ELEMENTDEFINITION: return "http://hl7.org/fhir/data-types";
            case EXPRESSION: return "http://hl7.org/fhir/data-types";
            case EXTENSION: return "http://hl7.org/fhir/data-types";
            case HUMANNAME: return "http://hl7.org/fhir/data-types";
            case IDENTIFIER: return "http://hl7.org/fhir/data-types";
            case MARKETINGSTATUS: return "http://hl7.org/fhir/data-types";
            case META: return "http://hl7.org/fhir/data-types";
            case MONEY: return "http://hl7.org/fhir/data-types";
            case MONEYQUANTITY: return "http://hl7.org/fhir/data-types";
            case NARRATIVE: return "http://hl7.org/fhir/data-types";
            case ORDEREDDISTRIBUTION: return "http://hl7.org/fhir/data-types";
            case PARAMETERDEFINITION: return "http://hl7.org/fhir/data-types";
            case PERIOD: return "http://hl7.org/fhir/data-types";
            case POPULATION: return "http://hl7.org/fhir/data-types";
            case PRIMITIVETYPE: return "http://hl7.org/fhir/data-types";
            case PRODCHARACTERISTIC: return "http://hl7.org/fhir/data-types";
            case PRODUCTSHELFLIFE: return "http://hl7.org/fhir/data-types";
            case QUANTITY: return "http://hl7.org/fhir/data-types";
            case RANGE: return "http://hl7.org/fhir/data-types";
            case RATIO: return "http://hl7.org/fhir/data-types";
            case REFERENCE: return "http://hl7.org/fhir/data-types";
            case RELATEDARTIFACT: return "http://hl7.org/fhir/data-types";
            case SAMPLEDDATA: return "http://hl7.org/fhir/data-types";
            case SIGNATURE: return "http://hl7.org/fhir/data-types";
            case SIMPLEQUANTITY: return "http://hl7.org/fhir/data-types";
            case STATISTIC: return "http://hl7.org/fhir/data-types";
            case SUBSTANCEAMOUNT: return "http://hl7.org/fhir/data-types";
            case TIMING: return "http://hl7.org/fhir/data-types";
            case TRIGGERDEFINITION: return "http://hl7.org/fhir/data-types";
            case USAGECONTEXT: return "http://hl7.org/fhir/data-types";
            case BASE64BINARY: return "http://hl7.org/fhir/data-types";
            case BOOLEAN: return "http://hl7.org/fhir/data-types";
            case CANONICAL: return "http://hl7.org/fhir/data-types";
            case CODE: return "http://hl7.org/fhir/data-types";
            case DATE: return "http://hl7.org/fhir/data-types";
            case DATETIME: return "http://hl7.org/fhir/data-types";
            case DECIMAL: return "http://hl7.org/fhir/data-types";
            case ID: return "http://hl7.org/fhir/data-types";
            case INSTANT: return "http://hl7.org/fhir/data-types";
            case INTEGER: return "http://hl7.org/fhir/data-types";
            case INTEGER64: return "http://hl7.org/fhir/data-types";
            case MARKDOWN: return "http://hl7.org/fhir/data-types";
            case OID: return "http://hl7.org/fhir/data-types";
            case POSITIVEINT: return "http://hl7.org/fhir/data-types";
            case STRING: return "http://hl7.org/fhir/data-types";
            case TIME: return "http://hl7.org/fhir/data-types";
            case UNSIGNEDINT: return "http://hl7.org/fhir/data-types";
            case URI: return "http://hl7.org/fhir/data-types";
            case URL: return "http://hl7.org/fhir/data-types";
            case UUID: return "http://hl7.org/fhir/data-types";
            case XHTML: return "http://hl7.org/fhir/data-types";
            case ACCOUNT: return "http://hl7.org/fhir/resource-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/resource-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENT: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case AUDITEVENT: return "http://hl7.org/fhir/resource-types";
            case BASIC: return "http://hl7.org/fhir/resource-types";
            case BINARY: return "http://hl7.org/fhir/resource-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/resource-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/resource-types";
            case BUNDLE: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT2: return "http://hl7.org/fhir/resource-types";
            case CAREPLAN: return "http://hl7.org/fhir/resource-types";
            case CARETEAM: return "http://hl7.org/fhir/resource-types";
            case CATALOGENTRY: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEM: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CITATION: return "http://hl7.org/fhir/resource-types";
            case CLAIM: return "http://hl7.org/fhir/resource-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/resource-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/resource-types";
            case CLINICALUSEISSUE: return "http://hl7.org/fhir/resource-types";
            case CODESYSTEM: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATION: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case COMPOSITION: return "http://hl7.org/fhir/resource-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/resource-types";
            case CONDITION: return "http://hl7.org/fhir/resource-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CONSENT: return "http://hl7.org/fhir/resource-types";
            case CONTRACT: return "http://hl7.org/fhir/resource-types";
            case COVERAGE: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/resource-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/resource-types";
            case DEVICE: return "http://hl7.org/fhir/resource-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/resource-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case DEVICEUSESTATEMENT: return "http://hl7.org/fhir/resource-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/resource-types";
            case DOMAINRESOURCE: return "http://hl7.org/fhir/resource-types";
            case ENCOUNTER: return "http://hl7.org/fhir/resource-types";
            case ENDPOINT: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/resource-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case EVIDENCE: return "http://hl7.org/fhir/resource-types";
            case EVIDENCEFOCUS: return "http://hl7.org/fhir/resource-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/resource-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/resource-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/resource-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/resource-types";
            case FLAG: return "http://hl7.org/fhir/resource-types";
            case GOAL: return "http://hl7.org/fhir/resource-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/resource-types";
            case GROUP: return "http://hl7.org/fhir/resource-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/resource-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/resource-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/resource-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/resource-types";
            case INGREDIENT: return "http://hl7.org/fhir/resource-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/resource-types";
            case INVOICE: return "http://hl7.org/fhir/resource-types";
            case LIBRARY: return "http://hl7.org/fhir/resource-types";
            case LINKAGE: return "http://hl7.org/fhir/resource-types";
            case LIST: return "http://hl7.org/fhir/resource-types";
            case LOCATION: return "http://hl7.org/fhir/resource-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MEASURE: return "http://hl7.org/fhir/resource-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/resource-types";
            case MEDICATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/resource-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/resource-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/resource-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONPRODUCT: return "http://hl7.org/fhir/resource-types";
            case OBSERVATION: return "http://hl7.org/fhir/resource-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATION: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/resource-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PARAMETERS: return "http://hl7.org/fhir/resource-types";
            case PATIENT: return "http://hl7.org/fhir/resource-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/resource-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/resource-types";
            case PERMISSION: return "http://hl7.org/fhir/resource-types";
            case PERSON: return "http://hl7.org/fhir/resource-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONER: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/resource-types";
            case PROCEDURE: return "http://hl7.org/fhir/resource-types";
            case PROVENANCE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/resource-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/resource-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/resource-types";
            case REQUESTGROUP: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/resource-types";
            case RESOURCE: return "http://hl7.org/fhir/resource-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/resource-types";
            case SCHEDULE: return "http://hl7.org/fhir/resource-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/resource-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case SLOT: return "http://hl7.org/fhir/resource-types";
            case SPECIMEN: return "http://hl7.org/fhir/resource-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/resource-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/resource-types";
            case SUBSCRIPTIONSTATUS: return "http://hl7.org/fhir/resource-types";
            case SUBSCRIPTIONTOPIC: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCE: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/resource-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/resource-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/resource-types";
            case TASK: return "http://hl7.org/fhir/resource-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/resource-types";
            case TESTREPORT: return "http://hl7.org/fhir/resource-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/resource-types";
            case VALUESET: return "http://hl7.org/fhir/resource-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/resource-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/resource-types";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ADDRESS: return "An address expressed using postal conventions (as opposed to GPS or other location definition formats).  This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery.  There are a variety of postal address formats defined around the world.";
            case AGE: return "A duration of time during which an organism (or a process) has existed.";
            case ANNOTATION: return "A  text note which also  contains information about who made the statement and when.";
            case ATTACHMENT: return "For referring to data content defined in other formats.";
            case BACKBONEELEMENT: return "Base definition for all elements that are defined inside a resource - but not those in a data type.";
            case BACKBONETYPE: return "Base definition for the few data types that are allowed to carry modifier extensions.";
            case BASE: return "Base definition for all types defined in FHIR type system.";
            case CODEABLECONCEPT: return "A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.";
            case CODEABLEREFERENCE: return "A reference to a resource (by instance), or instead, a reference to a cencept defined in a terminology or ontology (by class).";
            case CODING: return "A reference to a code defined by a terminology system.";
            case CONTACTDETAIL: return "Specifies contact information for a person or organization.";
            case CONTACTPOINT: return "Details for all kinds of technology mediated contact points for a person or organization, including telephone, email, etc.";
            case CONTRIBUTOR: return "A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.";
            case COUNT: return "A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.";
            case DATAREQUIREMENT: return "Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.";
            case DATATYPE: return "The base class for all re-useable types defined as part of the FHIR Specification.";
            case DISTANCE: return "A length - a value with a unit that is a physical distance.";
            case DOSAGE: return "Indicates how the medication is/was taken or should be taken by the patient.";
            case DURATION: return "A length of time.";
            case ELEMENT: return "Base definition for all elements in a resource.";
            case ELEMENTDEFINITION: return "Captures constraints on each element within the resource, profile, or extension.";
            case EXPRESSION: return "A expression that is evaluated in a specified context and returns a value. The context of use of the expression must specify the context in which the expression is evaluated, and how the result of the expression is used.";
            case EXTENSION: return "Optional Extension Element - found in all resources.";
            case HUMANNAME: return "A human's name with the ability to identify parts and usage.";
            case IDENTIFIER: return "An identifier - identifies some entity uniquely and unambiguously. Typically this is used for business identifiers.";
            case MARKETINGSTATUS: return "The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.";
            case META: return "The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to the content might not always be associated with version changes to the resource.";
            case MONEY: return "An amount of economic utility in some recognized currency.";
            case MONEYQUANTITY: return "";
            case NARRATIVE: return "A human-readable summary of the resource conveying the essential clinical and business information for the resource.";
            case ORDEREDDISTRIBUTION: return "An ordered list (distribution) of statistics.";
            case PARAMETERDEFINITION: return "The parameters to the module. This collection specifies both the input and output parameters. Input parameters are provided by the caller as part of the $evaluate operation. Output parameters are included in the GuidanceResponse.";
            case PERIOD: return "A time period defined by a start and end date and optionally time.";
            case POPULATION: return "A populatioof people with some set of grouping criteria.";
            case PRIMITIVETYPE: return "The base type for all re-useable types defined that have a simple property.";
            case PRODCHARACTERISTIC: return "The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.";
            case PRODUCTSHELFLIFE: return "The shelf-life and storage information for a medicinal product item or container can be described using this class.";
            case QUANTITY: return "A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.";
            case RANGE: return "A set of ordered Quantities defined by a low and high limit.";
            case RATIO: return "A relationship of two Quantity values - expressed as a numerator and a denominator.";
            case REFERENCE: return "A reference from one resource to another.";
            case RELATEDARTIFACT: return "Related artifacts such as additional documentation, justification, or bibliographic references.";
            case SAMPLEDDATA: return "A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.";
            case SIGNATURE: return "A signature along with supporting context. The signature may be a digital signature that is cryptographic in nature, or some other signature acceptable to the domain. This other signature may be as simple as a graphical image representing a hand-written signature, or a signature ceremony Different signature approaches have different utilities.";
            case SIMPLEQUANTITY: return "";
            case STATISTIC: return "A fact or piece of data from a  study of a large quantity of numerical data.  A mathematical or quantified characteristic of a group of observations.";
            case SUBSTANCEAMOUNT: return "Chemical substances are a single substance type whose primary defining element is the molecular structure. Chemical substances shall be defined on the basis of their complete covalent molecular structure; the presence of a salt (counter-ion) and/or solvates (water, alcohols) is also captured. Purity, grade, physical form or particle size are not taken into account in the definition of a chemical substance or in the assignment of a Substance ID.";
            case TIMING: return "Specifies an event that may occur multiple times. Timing schedules are used to record when things are planned, expected or requested to occur. The most common usage is in dosage instructions for medications. They are also used when planning care of various kinds, and may be used for reporting the schedule to which past regular activities were carried out.";
            case TRIGGERDEFINITION: return "A description of a triggering event. Triggering events can be named events, data events, or periodic, as determined by the type element.";
            case USAGECONTEXT: return "Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact. This metadata can either be specific to the applicable population (e.g., age category, DRG) or the specific context of care (e.g., venue, care setting, provider of care).";
            case BASE64BINARY: return "A stream of bytes";
            case BOOLEAN: return "Value of \"true\" or \"false\"";
            case CANONICAL: return "A URI that is a reference to a canonical URL on a FHIR resource";
            case CODE: return "A string which has at least one character and no leading or trailing whitespace and where there is no whitespace other than single spaces in the contents";
            case DATE: return "A date or partial date (e.g. just year or year + month). There is no time zone. The format is a union of the schema types gYear, gYearMonth and date.  Dates SHALL be valid dates.";
            case DATETIME: return "A date, date-time or partial date (e.g. just year or year + month).  If hours and minutes are specified, a time zone SHALL be populated. The format is a union of the schema types gYear, gYearMonth, date and dateTime. Seconds must be provided due to schema type constraints but may be zero-filled and may be ignored.                 Dates SHALL be valid dates.";
            case DECIMAL: return "A rational number with implicit precision";
            case ID: return "Any combination of letters, numerals, \"-\" and \".\", with a length limit of 64 characters.  (This might be an integer, an unprefixed OID, UUID or any other identifier pattern that meets these constraints.)  Ids are case-insensitive.";
            case INSTANT: return "An instant in time - known at least to the second";
            case INTEGER: return "A whole number";
            case INTEGER64: return "A very large whole number";
            case MARKDOWN: return "A string that may contain Github Flavored Markdown syntax for optional processing by a mark down presentation engine";
            case OID: return "An OID represented as a URI";
            case POSITIVEINT: return "An integer with a value that is positive (e.g. >0)";
            case STRING: return "A sequence of Unicode characters";
            case TIME: return "A time during the day, with no date specified";
            case UNSIGNEDINT: return "An integer with a value that is not negative (e.g. >= 0)";
            case URI: return "String of characters used to identify a name or a resource";
            case URL: return "A URI that is a literal reference";
            case UUID: return "A UUID, represented as a URI";
            case XHTML: return "XHTML format, as defined by W3C, but restricted usage (mainly, no active content)";
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A pharmaceutical product described in terms of its composition and dose form.";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A material substance originating from a biological entity intended to be transplanted or infused\ninto another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case BUNDLE: return "A container for a collection of resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAPABILITYSTATEMENT2: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CATALOGENTRY: return "Catalog entries are wrappers that contextualize items included in a catalog.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CITATION: return "The Citation.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEISSUE: return "A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
            case COMMUNICATIONREQUEST: return "A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.";
            case COMPARTMENTDEFINITION: return "A compartment definition that defines how resources are accessed on a server.";
            case COMPOSITION: return "A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).";
            case CONCEPTMAP: return "A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.";
            case CONDITION: return "A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.";
            case CONDITIONDEFINITION: return "A definition of a condition and information relevant to managing it.";
            case CONSENT: return "A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.";
            case CONTRACT: return "Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.";
            case COVERAGE: return "Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.";
            case COVERAGEELIGIBILITYREQUEST: return "The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.";
            case COVERAGEELIGIBILITYRESPONSE: return "This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.";
            case DETECTEDISSUE: return "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.";
            case DEVICE: return "A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.";
            case DEVICEDEFINITION: return "The characteristics, operational status and capabilities of a medical-related component of a medical device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.";
            case DEVICEUSESTATEMENT: return "A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case DOMAINRESOURCE: return "A resource that includes narrative, extensions, and contained resources.";
            case ENCOUNTER: return "An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "This represents statistics, certainty, both the intended and actual population, and evidence variables.";
            case EVIDENCEFOCUS: return "EvidenceFocus.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes an element that knowledge (Evidence) is about.";
            case EXAMPLESCENARIO: return "Example of workflow instance.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A list is a curated collection of resources.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case MOLECULARSEQUENCE: return "Raw data describing a biological sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case NUTRITIONPRODUCT: return "A food or fluid product that is consumed by patients.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medicinal product in a container or package.";
            case PARAMETERS: return "This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERMISSION: return "Permission.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "The regulatory authorization of a medicinal product, device or process.";
            case RELATEDPERSON: return "Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTGROUP: return "A group of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case RESEARCHSTUDY: return "A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.";
            case RESEARCHSUBJECT: return "A physical entity which is the primary unit of operational and/or administrative interest in a study.";
            case RESOURCE: return "This is the base resource type for everything.";
            case RISKASSESSMENT: return "An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.";
            case SCHEDULE: return "A container for slots of time that may be available for booking appointments.";
            case SEARCHPARAMETER: return "A search parameter that defines a named search item that can be used to search/filter on a resource.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case SLOT: return "A slot of time on a schedule that may be available for booking appointments.";
            case SPECIMEN: return "A sample to be used for analysis.";
            case SPECIMENDEFINITION: return "A kind of specimen with associated set of requirements.";
            case STRUCTUREDEFINITION: return "A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.";
            case STRUCTUREMAP: return "A Map of relationships between 2 structures that can be used to transform data.";
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.";
            case SUBSCRIPTIONSTATUS: return "The SubscriptionStatus resource describes the state of a Subscription during notifications.";
            case SUBSCRIPTIONTOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Todo.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a request for a medication, substance or device used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ADDRESS: return "Address";
            case AGE: return "Age";
            case ANNOTATION: return "Annotation";
            case ATTACHMENT: return "Attachment";
            case BACKBONEELEMENT: return "BackboneElement";
            case BACKBONETYPE: return "BackboneType";
            case BASE: return "Base";
            case CODEABLECONCEPT: return "CodeableConcept";
            case CODEABLEREFERENCE: return "CodeableReference";
            case CODING: return "Coding";
            case CONTACTDETAIL: return "ContactDetail";
            case CONTACTPOINT: return "ContactPoint";
            case CONTRIBUTOR: return "Contributor";
            case COUNT: return "Count";
            case DATAREQUIREMENT: return "DataRequirement";
            case DATATYPE: return "DataType";
            case DISTANCE: return "Distance";
            case DOSAGE: return "Dosage";
            case DURATION: return "Duration";
            case ELEMENT: return "Element";
            case ELEMENTDEFINITION: return "ElementDefinition";
            case EXPRESSION: return "Expression";
            case EXTENSION: return "Extension";
            case HUMANNAME: return "HumanName";
            case IDENTIFIER: return "Identifier";
            case MARKETINGSTATUS: return "MarketingStatus";
            case META: return "Meta";
            case MONEY: return "Money";
            case MONEYQUANTITY: return "MoneyQuantity";
            case NARRATIVE: return "Narrative";
            case ORDEREDDISTRIBUTION: return "OrderedDistribution";
            case PARAMETERDEFINITION: return "ParameterDefinition";
            case PERIOD: return "Period";
            case POPULATION: return "Population";
            case PRIMITIVETYPE: return "PrimitiveType";
            case PRODCHARACTERISTIC: return "ProdCharacteristic";
            case PRODUCTSHELFLIFE: return "ProductShelfLife";
            case QUANTITY: return "Quantity";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case REFERENCE: return "Reference";
            case RELATEDARTIFACT: return "RelatedArtifact";
            case SAMPLEDDATA: return "SampledData";
            case SIGNATURE: return "Signature";
            case SIMPLEQUANTITY: return "SimpleQuantity";
            case STATISTIC: return "Statistic";
            case SUBSTANCEAMOUNT: return "SubstanceAmount";
            case TIMING: return "Timing";
            case TRIGGERDEFINITION: return "TriggerDefinition";
            case USAGECONTEXT: return "UsageContext";
            case BASE64BINARY: return "base64Binary";
            case BOOLEAN: return "boolean";
            case CANONICAL: return "canonical";
            case CODE: return "code";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case DECIMAL: return "decimal";
            case ID: return "id";
            case INSTANT: return "instant";
            case INTEGER: return "integer";
            case INTEGER64: return "integer64";
            case MARKDOWN: return "markdown";
            case OID: return "oid";
            case POSITIVEINT: return "positiveInt";
            case STRING: return "string";
            case TIME: return "time";
            case UNSIGNEDINT: return "unsignedInt";
            case URI: return "uri";
            case URL: return "url";
            case UUID: return "uuid";
            case XHTML: return "XHTML";
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case DOMAINRESOURCE: return "DomainResource";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEFOCUS: return "EvidenceFocus";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTGROUP: return "RequestGroup";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RESOURCE: return "Resource";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
    }

  public static class FHIRDefinedTypeEnumFactory implements EnumFactory<FHIRDefinedType> {
    public FHIRDefinedType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Address".equals(codeString))
          return FHIRDefinedType.ADDRESS;
        if ("Age".equals(codeString))
          return FHIRDefinedType.AGE;
        if ("Annotation".equals(codeString))
          return FHIRDefinedType.ANNOTATION;
        if ("Attachment".equals(codeString))
          return FHIRDefinedType.ATTACHMENT;
        if ("BackboneElement".equals(codeString))
          return FHIRDefinedType.BACKBONEELEMENT;
        if ("BackboneType".equals(codeString))
          return FHIRDefinedType.BACKBONETYPE;
        if ("Base".equals(codeString))
          return FHIRDefinedType.BASE;
        if ("CodeableConcept".equals(codeString))
          return FHIRDefinedType.CODEABLECONCEPT;
        if ("CodeableReference".equals(codeString))
          return FHIRDefinedType.CODEABLEREFERENCE;
        if ("Coding".equals(codeString))
          return FHIRDefinedType.CODING;
        if ("ContactDetail".equals(codeString))
          return FHIRDefinedType.CONTACTDETAIL;
        if ("ContactPoint".equals(codeString))
          return FHIRDefinedType.CONTACTPOINT;
        if ("Contributor".equals(codeString))
          return FHIRDefinedType.CONTRIBUTOR;
        if ("Count".equals(codeString))
          return FHIRDefinedType.COUNT;
        if ("DataRequirement".equals(codeString))
          return FHIRDefinedType.DATAREQUIREMENT;
        if ("DataType".equals(codeString))
          return FHIRDefinedType.DATATYPE;
        if ("Distance".equals(codeString))
          return FHIRDefinedType.DISTANCE;
        if ("Dosage".equals(codeString))
          return FHIRDefinedType.DOSAGE;
        if ("Duration".equals(codeString))
          return FHIRDefinedType.DURATION;
        if ("Element".equals(codeString))
          return FHIRDefinedType.ELEMENT;
        if ("ElementDefinition".equals(codeString))
          return FHIRDefinedType.ELEMENTDEFINITION;
        if ("Expression".equals(codeString))
          return FHIRDefinedType.EXPRESSION;
        if ("Extension".equals(codeString))
          return FHIRDefinedType.EXTENSION;
        if ("HumanName".equals(codeString))
          return FHIRDefinedType.HUMANNAME;
        if ("Identifier".equals(codeString))
          return FHIRDefinedType.IDENTIFIER;
        if ("MarketingStatus".equals(codeString))
          return FHIRDefinedType.MARKETINGSTATUS;
        if ("Meta".equals(codeString))
          return FHIRDefinedType.META;
        if ("Money".equals(codeString))
          return FHIRDefinedType.MONEY;
        if ("MoneyQuantity".equals(codeString))
          return FHIRDefinedType.MONEYQUANTITY;
        if ("Narrative".equals(codeString))
          return FHIRDefinedType.NARRATIVE;
        if ("OrderedDistribution".equals(codeString))
          return FHIRDefinedType.ORDEREDDISTRIBUTION;
        if ("ParameterDefinition".equals(codeString))
          return FHIRDefinedType.PARAMETERDEFINITION;
        if ("Period".equals(codeString))
          return FHIRDefinedType.PERIOD;
        if ("Population".equals(codeString))
          return FHIRDefinedType.POPULATION;
        if ("PrimitiveType".equals(codeString))
          return FHIRDefinedType.PRIMITIVETYPE;
        if ("ProdCharacteristic".equals(codeString))
          return FHIRDefinedType.PRODCHARACTERISTIC;
        if ("ProductShelfLife".equals(codeString))
          return FHIRDefinedType.PRODUCTSHELFLIFE;
        if ("Quantity".equals(codeString))
          return FHIRDefinedType.QUANTITY;
        if ("Range".equals(codeString))
          return FHIRDefinedType.RANGE;
        if ("Ratio".equals(codeString))
          return FHIRDefinedType.RATIO;
        if ("Reference".equals(codeString))
          return FHIRDefinedType.REFERENCE;
        if ("RelatedArtifact".equals(codeString))
          return FHIRDefinedType.RELATEDARTIFACT;
        if ("SampledData".equals(codeString))
          return FHIRDefinedType.SAMPLEDDATA;
        if ("Signature".equals(codeString))
          return FHIRDefinedType.SIGNATURE;
        if ("SimpleQuantity".equals(codeString))
          return FHIRDefinedType.SIMPLEQUANTITY;
        if ("Statistic".equals(codeString))
          return FHIRDefinedType.STATISTIC;
        if ("SubstanceAmount".equals(codeString))
          return FHIRDefinedType.SUBSTANCEAMOUNT;
        if ("Timing".equals(codeString))
          return FHIRDefinedType.TIMING;
        if ("TriggerDefinition".equals(codeString))
          return FHIRDefinedType.TRIGGERDEFINITION;
        if ("UsageContext".equals(codeString))
          return FHIRDefinedType.USAGECONTEXT;
        if ("base64Binary".equals(codeString))
          return FHIRDefinedType.BASE64BINARY;
        if ("boolean".equals(codeString))
          return FHIRDefinedType.BOOLEAN;
        if ("canonical".equals(codeString))
          return FHIRDefinedType.CANONICAL;
        if ("code".equals(codeString))
          return FHIRDefinedType.CODE;
        if ("date".equals(codeString))
          return FHIRDefinedType.DATE;
        if ("dateTime".equals(codeString))
          return FHIRDefinedType.DATETIME;
        if ("decimal".equals(codeString))
          return FHIRDefinedType.DECIMAL;
        if ("id".equals(codeString))
          return FHIRDefinedType.ID;
        if ("instant".equals(codeString))
          return FHIRDefinedType.INSTANT;
        if ("integer".equals(codeString))
          return FHIRDefinedType.INTEGER;
        if ("integer64".equals(codeString))
          return FHIRDefinedType.INTEGER64;
        if ("markdown".equals(codeString))
          return FHIRDefinedType.MARKDOWN;
        if ("oid".equals(codeString))
          return FHIRDefinedType.OID;
        if ("positiveInt".equals(codeString))
          return FHIRDefinedType.POSITIVEINT;
        if ("string".equals(codeString))
          return FHIRDefinedType.STRING;
        if ("time".equals(codeString))
          return FHIRDefinedType.TIME;
        if ("unsignedInt".equals(codeString))
          return FHIRDefinedType.UNSIGNEDINT;
        if ("uri".equals(codeString))
          return FHIRDefinedType.URI;
        if ("url".equals(codeString))
          return FHIRDefinedType.URL;
        if ("uuid".equals(codeString))
          return FHIRDefinedType.UUID;
        if ("xhtml".equals(codeString))
          return FHIRDefinedType.XHTML;
        if ("Account".equals(codeString))
          return FHIRDefinedType.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return FHIRDefinedType.ACTIVITYDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return FHIRDefinedType.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return FHIRDefinedType.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return FHIRDefinedType.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return FHIRDefinedType.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return FHIRDefinedType.APPOINTMENTRESPONSE;
        if ("AuditEvent".equals(codeString))
          return FHIRDefinedType.AUDITEVENT;
        if ("Basic".equals(codeString))
          return FHIRDefinedType.BASIC;
        if ("Binary".equals(codeString))
          return FHIRDefinedType.BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return FHIRDefinedType.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return FHIRDefinedType.BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return FHIRDefinedType.BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return FHIRDefinedType.CAPABILITYSTATEMENT;
        if ("CapabilityStatement2".equals(codeString))
          return FHIRDefinedType.CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return FHIRDefinedType.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return FHIRDefinedType.CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return FHIRDefinedType.CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return FHIRDefinedType.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return FHIRDefinedType.CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return FHIRDefinedType.CITATION;
        if ("Claim".equals(codeString))
          return FHIRDefinedType.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return FHIRDefinedType.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return FHIRDefinedType.CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return FHIRDefinedType.CLINICALUSEISSUE;
        if ("CodeSystem".equals(codeString))
          return FHIRDefinedType.CODESYSTEM;
        if ("Communication".equals(codeString))
          return FHIRDefinedType.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return FHIRDefinedType.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return FHIRDefinedType.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return FHIRDefinedType.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return FHIRDefinedType.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return FHIRDefinedType.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return FHIRDefinedType.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return FHIRDefinedType.CONSENT;
        if ("Contract".equals(codeString))
          return FHIRDefinedType.CONTRACT;
        if ("Coverage".equals(codeString))
          return FHIRDefinedType.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return FHIRDefinedType.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return FHIRDefinedType.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return FHIRDefinedType.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return FHIRDefinedType.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return FHIRDefinedType.DEVICEDEFINITION;
        if ("DeviceMetric".equals(codeString))
          return FHIRDefinedType.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return FHIRDefinedType.DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return FHIRDefinedType.DEVICEUSESTATEMENT;
        if ("DiagnosticReport".equals(codeString))
          return FHIRDefinedType.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return FHIRDefinedType.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return FHIRDefinedType.DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return FHIRDefinedType.DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return FHIRDefinedType.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return FHIRDefinedType.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return FHIRDefinedType.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return FHIRDefinedType.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return FHIRDefinedType.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return FHIRDefinedType.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return FHIRDefinedType.EVIDENCE;
        if ("EvidenceFocus".equals(codeString))
          return FHIRDefinedType.EVIDENCEFOCUS;
        if ("EvidenceVariable".equals(codeString))
          return FHIRDefinedType.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return FHIRDefinedType.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return FHIRDefinedType.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FHIRDefinedType.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FHIRDefinedType.FLAG;
        if ("Goal".equals(codeString))
          return FHIRDefinedType.GOAL;
        if ("GraphDefinition".equals(codeString))
          return FHIRDefinedType.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return FHIRDefinedType.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return FHIRDefinedType.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return FHIRDefinedType.HEALTHCARESERVICE;
        if ("ImagingStudy".equals(codeString))
          return FHIRDefinedType.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return FHIRDefinedType.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return FHIRDefinedType.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return FHIRDefinedType.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return FHIRDefinedType.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return FHIRDefinedType.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return FHIRDefinedType.INSURANCEPLAN;
        if ("Invoice".equals(codeString))
          return FHIRDefinedType.INVOICE;
        if ("Library".equals(codeString))
          return FHIRDefinedType.LIBRARY;
        if ("Linkage".equals(codeString))
          return FHIRDefinedType.LINKAGE;
        if ("List".equals(codeString))
          return FHIRDefinedType.LIST;
        if ("Location".equals(codeString))
          return FHIRDefinedType.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return FHIRDefinedType.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return FHIRDefinedType.MEASURE;
        if ("MeasureReport".equals(codeString))
          return FHIRDefinedType.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return FHIRDefinedType.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return FHIRDefinedType.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return FHIRDefinedType.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return FHIRDefinedType.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return FHIRDefinedType.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return FHIRDefinedType.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return FHIRDefinedType.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return FHIRDefinedType.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return FHIRDefinedType.MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return FHIRDefinedType.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return FHIRDefinedType.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return FHIRDefinedType.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return FHIRDefinedType.NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return FHIRDefinedType.NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return FHIRDefinedType.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return FHIRDefinedType.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return FHIRDefinedType.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return FHIRDefinedType.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return FHIRDefinedType.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return FHIRDefinedType.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return FHIRDefinedType.PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return FHIRDefinedType.PARAMETERS;
        if ("Patient".equals(codeString))
          return FHIRDefinedType.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return FHIRDefinedType.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return FHIRDefinedType.PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return FHIRDefinedType.PERMISSION;
        if ("Person".equals(codeString))
          return FHIRDefinedType.PERSON;
        if ("PlanDefinition".equals(codeString))
          return FHIRDefinedType.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return FHIRDefinedType.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return FHIRDefinedType.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return FHIRDefinedType.PROCEDURE;
        if ("Provenance".equals(codeString))
          return FHIRDefinedType.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return FHIRDefinedType.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return FHIRDefinedType.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return FHIRDefinedType.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return FHIRDefinedType.RELATEDPERSON;
        if ("RequestGroup".equals(codeString))
          return FHIRDefinedType.REQUESTGROUP;
        if ("ResearchStudy".equals(codeString))
          return FHIRDefinedType.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return FHIRDefinedType.RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return FHIRDefinedType.RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return FHIRDefinedType.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return FHIRDefinedType.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return FHIRDefinedType.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return FHIRDefinedType.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return FHIRDefinedType.SLOT;
        if ("Specimen".equals(codeString))
          return FHIRDefinedType.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return FHIRDefinedType.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return FHIRDefinedType.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return FHIRDefinedType.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return FHIRDefinedType.SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return FHIRDefinedType.SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return FHIRDefinedType.SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return FHIRDefinedType.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return FHIRDefinedType.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return FHIRDefinedType.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return FHIRDefinedType.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return FHIRDefinedType.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return FHIRDefinedType.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return FHIRDefinedType.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return FHIRDefinedType.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return FHIRDefinedType.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return FHIRDefinedType.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return FHIRDefinedType.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return FHIRDefinedType.TESTREPORT;
        if ("TestScript".equals(codeString))
          return FHIRDefinedType.TESTSCRIPT;
        if ("ValueSet".equals(codeString))
          return FHIRDefinedType.VALUESET;
        if ("VerificationResult".equals(codeString))
          return FHIRDefinedType.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return FHIRDefinedType.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown FHIRDefinedType code '"+codeString+"'");
        }
        public Enumeration<FHIRDefinedType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRDefinedType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Address".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ADDRESS);
        if ("Age".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.AGE);
        if ("Annotation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ANNOTATION);
        if ("Attachment".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ATTACHMENT);
        if ("BackboneElement".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BACKBONEELEMENT);
        if ("BackboneType".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BACKBONETYPE);
        if ("Base".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BASE);
        if ("CodeableConcept".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CODEABLECONCEPT);
        if ("CodeableReference".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CODEABLEREFERENCE);
        if ("Coding".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CODING);
        if ("ContactDetail".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONTACTDETAIL);
        if ("ContactPoint".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONTACTPOINT);
        if ("Contributor".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONTRIBUTOR);
        if ("Count".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COUNT);
        if ("DataRequirement".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DATAREQUIREMENT);
        if ("DataType".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DATATYPE);
        if ("Distance".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DISTANCE);
        if ("Dosage".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DOSAGE);
        if ("Duration".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DURATION);
        if ("Element".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ELEMENT);
        if ("ElementDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ELEMENTDEFINITION);
        if ("Expression".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EXPRESSION);
        if ("Extension".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EXTENSION);
        if ("HumanName".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.HUMANNAME);
        if ("Identifier".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.IDENTIFIER);
        if ("MarketingStatus".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MARKETINGSTATUS);
        if ("Meta".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.META);
        if ("Money".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MONEY);
        if ("MoneyQuantity".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MONEYQUANTITY);
        if ("Narrative".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.NARRATIVE);
        if ("OrderedDistribution".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ORDEREDDISTRIBUTION);
        if ("ParameterDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PARAMETERDEFINITION);
        if ("Period".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PERIOD);
        if ("Population".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.POPULATION);
        if ("PrimitiveType".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PRIMITIVETYPE);
        if ("ProdCharacteristic".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PRODCHARACTERISTIC);
        if ("ProductShelfLife".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PRODUCTSHELFLIFE);
        if ("Quantity".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.QUANTITY);
        if ("Range".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RANGE);
        if ("Ratio".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RATIO);
        if ("Reference".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.REFERENCE);
        if ("RelatedArtifact".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RELATEDARTIFACT);
        if ("SampledData".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SAMPLEDDATA);
        if ("Signature".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SIGNATURE);
        if ("SimpleQuantity".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SIMPLEQUANTITY);
        if ("Statistic".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.STATISTIC);
        if ("SubstanceAmount".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCEAMOUNT);
        if ("Timing".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TIMING);
        if ("TriggerDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TRIGGERDEFINITION);
        if ("UsageContext".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.USAGECONTEXT);
        if ("base64Binary".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BASE64BINARY);
        if ("boolean".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BOOLEAN);
        if ("canonical".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CANONICAL);
        if ("code".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CODE);
        if ("date".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DATE);
        if ("dateTime".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DATETIME);
        if ("decimal".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DECIMAL);
        if ("id".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ID);
        if ("instant".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.INSTANT);
        if ("integer".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.INTEGER);
        if ("integer64".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.INTEGER64);
        if ("markdown".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MARKDOWN);
        if ("oid".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.OID);
        if ("positiveInt".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.POSITIVEINT);
        if ("string".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.STRING);
        if ("time".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TIME);
        if ("unsignedInt".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.UNSIGNEDINT);
        if ("uri".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.URI);
        if ("url".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.URL);
        if ("uuid".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.UUID);
        if ("xhtml".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.XHTML);
        if ("Account".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ACTIVITYDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.APPOINTMENTRESPONSE);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BASIC);
        if ("Binary".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BINARY);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BODYSTRUCTURE);
        if ("Bundle".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.BUNDLE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CAPABILITYSTATEMENT);
        if ("CapabilityStatement2".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CAPABILITYSTATEMENT2);
        if ("CarePlan".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CARETEAM);
        if ("CatalogEntry".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CATALOGENTRY);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CHARGEITEMDEFINITION);
        if ("Citation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CITATION);
        if ("Claim".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CLINICALIMPRESSION);
        if ("ClinicalUseIssue".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CLINICALUSEISSUE);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DEVICEDEFINITION);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DEVICEREQUEST);
        if ("DeviceUseStatement".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DEVICEUSESTATEMENT);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DOCUMENTREFERENCE);
        if ("DomainResource".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.DOMAINRESOURCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EVIDENCE);
        if ("EvidenceFocus".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EVIDENCEFOCUS);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.FLAG);
        if ("Goal".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.HEALTHCARESERVICE);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.INSURANCEPLAN);
        if ("Invoice".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MESSAGEHEADER);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.NUTRITIONORDER);
        if ("NutritionProduct".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.NUTRITIONPRODUCT);
        if ("Observation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PACKAGEDPRODUCTDEFINITION);
        if ("Parameters".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PARAMETERS);
        if ("Patient".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PAYMENTRECONCILIATION);
        if ("Permission".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PERMISSION);
        if ("Person".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RELATEDPERSON);
        if ("RequestGroup".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.REQUESTGROUP);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RESEARCHSUBJECT);
        if ("Resource".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RESOURCE);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSCRIPTION);
        if ("SubscriptionStatus".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSCRIPTIONSTATUS);
        if ("SubscriptionTopic".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSCRIPTIONTOPIC);
        if ("Substance".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.TESTSCRIPT);
        if ("ValueSet".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<FHIRDefinedType>(this, FHIRDefinedType.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown FHIRDefinedType code '"+codeString+"'");
        }
    public String toCode(FHIRDefinedType code) {
      if (code == FHIRDefinedType.ADDRESS)
        return "Address";
      if (code == FHIRDefinedType.AGE)
        return "Age";
      if (code == FHIRDefinedType.ANNOTATION)
        return "Annotation";
      if (code == FHIRDefinedType.ATTACHMENT)
        return "Attachment";
      if (code == FHIRDefinedType.BACKBONEELEMENT)
        return "BackboneElement";
      if (code == FHIRDefinedType.BACKBONETYPE)
        return "BackboneType";
      if (code == FHIRDefinedType.BASE)
        return "Base";
      if (code == FHIRDefinedType.CODEABLECONCEPT)
        return "CodeableConcept";
      if (code == FHIRDefinedType.CODEABLEREFERENCE)
        return "CodeableReference";
      if (code == FHIRDefinedType.CODING)
        return "Coding";
      if (code == FHIRDefinedType.CONTACTDETAIL)
        return "ContactDetail";
      if (code == FHIRDefinedType.CONTACTPOINT)
        return "ContactPoint";
      if (code == FHIRDefinedType.CONTRIBUTOR)
        return "Contributor";
      if (code == FHIRDefinedType.COUNT)
        return "Count";
      if (code == FHIRDefinedType.DATAREQUIREMENT)
        return "DataRequirement";
      if (code == FHIRDefinedType.DATATYPE)
        return "DataType";
      if (code == FHIRDefinedType.DISTANCE)
        return "Distance";
      if (code == FHIRDefinedType.DOSAGE)
        return "Dosage";
      if (code == FHIRDefinedType.DURATION)
        return "Duration";
      if (code == FHIRDefinedType.ELEMENT)
        return "Element";
      if (code == FHIRDefinedType.ELEMENTDEFINITION)
        return "ElementDefinition";
      if (code == FHIRDefinedType.EXPRESSION)
        return "Expression";
      if (code == FHIRDefinedType.EXTENSION)
        return "Extension";
      if (code == FHIRDefinedType.HUMANNAME)
        return "HumanName";
      if (code == FHIRDefinedType.IDENTIFIER)
        return "Identifier";
      if (code == FHIRDefinedType.MARKETINGSTATUS)
        return "MarketingStatus";
      if (code == FHIRDefinedType.META)
        return "Meta";
      if (code == FHIRDefinedType.MONEY)
        return "Money";
      if (code == FHIRDefinedType.MONEYQUANTITY)
        return "MoneyQuantity";
      if (code == FHIRDefinedType.NARRATIVE)
        return "Narrative";
      if (code == FHIRDefinedType.ORDEREDDISTRIBUTION)
        return "OrderedDistribution";
      if (code == FHIRDefinedType.PARAMETERDEFINITION)
        return "ParameterDefinition";
      if (code == FHIRDefinedType.PERIOD)
        return "Period";
      if (code == FHIRDefinedType.POPULATION)
        return "Population";
      if (code == FHIRDefinedType.PRIMITIVETYPE)
        return "PrimitiveType";
      if (code == FHIRDefinedType.PRODCHARACTERISTIC)
        return "ProdCharacteristic";
      if (code == FHIRDefinedType.PRODUCTSHELFLIFE)
        return "ProductShelfLife";
      if (code == FHIRDefinedType.QUANTITY)
        return "Quantity";
      if (code == FHIRDefinedType.RANGE)
        return "Range";
      if (code == FHIRDefinedType.RATIO)
        return "Ratio";
      if (code == FHIRDefinedType.REFERENCE)
        return "Reference";
      if (code == FHIRDefinedType.RELATEDARTIFACT)
        return "RelatedArtifact";
      if (code == FHIRDefinedType.SAMPLEDDATA)
        return "SampledData";
      if (code == FHIRDefinedType.SIGNATURE)
        return "Signature";
      if (code == FHIRDefinedType.SIMPLEQUANTITY)
        return "SimpleQuantity";
      if (code == FHIRDefinedType.STATISTIC)
        return "Statistic";
      if (code == FHIRDefinedType.SUBSTANCEAMOUNT)
        return "SubstanceAmount";
      if (code == FHIRDefinedType.TIMING)
        return "Timing";
      if (code == FHIRDefinedType.TRIGGERDEFINITION)
        return "TriggerDefinition";
      if (code == FHIRDefinedType.USAGECONTEXT)
        return "UsageContext";
      if (code == FHIRDefinedType.BASE64BINARY)
        return "base64Binary";
      if (code == FHIRDefinedType.BOOLEAN)
        return "boolean";
      if (code == FHIRDefinedType.CANONICAL)
        return "canonical";
      if (code == FHIRDefinedType.CODE)
        return "code";
      if (code == FHIRDefinedType.DATE)
        return "date";
      if (code == FHIRDefinedType.DATETIME)
        return "dateTime";
      if (code == FHIRDefinedType.DECIMAL)
        return "decimal";
      if (code == FHIRDefinedType.ID)
        return "id";
      if (code == FHIRDefinedType.INSTANT)
        return "instant";
      if (code == FHIRDefinedType.INTEGER)
        return "integer";
      if (code == FHIRDefinedType.INTEGER64)
        return "integer64";
      if (code == FHIRDefinedType.MARKDOWN)
        return "markdown";
      if (code == FHIRDefinedType.OID)
        return "oid";
      if (code == FHIRDefinedType.POSITIVEINT)
        return "positiveInt";
      if (code == FHIRDefinedType.STRING)
        return "string";
      if (code == FHIRDefinedType.TIME)
        return "time";
      if (code == FHIRDefinedType.UNSIGNEDINT)
        return "unsignedInt";
      if (code == FHIRDefinedType.URI)
        return "uri";
      if (code == FHIRDefinedType.URL)
        return "url";
      if (code == FHIRDefinedType.UUID)
        return "uuid";
      if (code == FHIRDefinedType.XHTML)
        return "xhtml";
      if (code == FHIRDefinedType.ACCOUNT)
        return "Account";
      if (code == FHIRDefinedType.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == FHIRDefinedType.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == FHIRDefinedType.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == FHIRDefinedType.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == FHIRDefinedType.APPOINTMENT)
        return "Appointment";
      if (code == FHIRDefinedType.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == FHIRDefinedType.AUDITEVENT)
        return "AuditEvent";
      if (code == FHIRDefinedType.BASIC)
        return "Basic";
      if (code == FHIRDefinedType.BINARY)
        return "Binary";
      if (code == FHIRDefinedType.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == FHIRDefinedType.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == FHIRDefinedType.BUNDLE)
        return "Bundle";
      if (code == FHIRDefinedType.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == FHIRDefinedType.CAPABILITYSTATEMENT2)
        return "CapabilityStatement2";
      if (code == FHIRDefinedType.CAREPLAN)
        return "CarePlan";
      if (code == FHIRDefinedType.CARETEAM)
        return "CareTeam";
      if (code == FHIRDefinedType.CATALOGENTRY)
        return "CatalogEntry";
      if (code == FHIRDefinedType.CHARGEITEM)
        return "ChargeItem";
      if (code == FHIRDefinedType.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == FHIRDefinedType.CITATION)
        return "Citation";
      if (code == FHIRDefinedType.CLAIM)
        return "Claim";
      if (code == FHIRDefinedType.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == FHIRDefinedType.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == FHIRDefinedType.CLINICALUSEISSUE)
        return "ClinicalUseIssue";
      if (code == FHIRDefinedType.CODESYSTEM)
        return "CodeSystem";
      if (code == FHIRDefinedType.COMMUNICATION)
        return "Communication";
      if (code == FHIRDefinedType.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == FHIRDefinedType.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == FHIRDefinedType.COMPOSITION)
        return "Composition";
      if (code == FHIRDefinedType.CONCEPTMAP)
        return "ConceptMap";
      if (code == FHIRDefinedType.CONDITION)
        return "Condition";
      if (code == FHIRDefinedType.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == FHIRDefinedType.CONSENT)
        return "Consent";
      if (code == FHIRDefinedType.CONTRACT)
        return "Contract";
      if (code == FHIRDefinedType.COVERAGE)
        return "Coverage";
      if (code == FHIRDefinedType.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == FHIRDefinedType.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == FHIRDefinedType.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == FHIRDefinedType.DEVICE)
        return "Device";
      if (code == FHIRDefinedType.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == FHIRDefinedType.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == FHIRDefinedType.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == FHIRDefinedType.DEVICEUSESTATEMENT)
        return "DeviceUseStatement";
      if (code == FHIRDefinedType.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == FHIRDefinedType.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == FHIRDefinedType.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == FHIRDefinedType.DOMAINRESOURCE)
        return "DomainResource";
      if (code == FHIRDefinedType.ENCOUNTER)
        return "Encounter";
      if (code == FHIRDefinedType.ENDPOINT)
        return "Endpoint";
      if (code == FHIRDefinedType.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == FHIRDefinedType.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == FHIRDefinedType.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == FHIRDefinedType.EVENTDEFINITION)
        return "EventDefinition";
      if (code == FHIRDefinedType.EVIDENCE)
        return "Evidence";
      if (code == FHIRDefinedType.EVIDENCEFOCUS)
        return "EvidenceFocus";
      if (code == FHIRDefinedType.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == FHIRDefinedType.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == FHIRDefinedType.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == FHIRDefinedType.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == FHIRDefinedType.FLAG)
        return "Flag";
      if (code == FHIRDefinedType.GOAL)
        return "Goal";
      if (code == FHIRDefinedType.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == FHIRDefinedType.GROUP)
        return "Group";
      if (code == FHIRDefinedType.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == FHIRDefinedType.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == FHIRDefinedType.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == FHIRDefinedType.IMMUNIZATION)
        return "Immunization";
      if (code == FHIRDefinedType.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == FHIRDefinedType.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == FHIRDefinedType.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == FHIRDefinedType.INGREDIENT)
        return "Ingredient";
      if (code == FHIRDefinedType.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == FHIRDefinedType.INVOICE)
        return "Invoice";
      if (code == FHIRDefinedType.LIBRARY)
        return "Library";
      if (code == FHIRDefinedType.LINKAGE)
        return "Linkage";
      if (code == FHIRDefinedType.LIST)
        return "List";
      if (code == FHIRDefinedType.LOCATION)
        return "Location";
      if (code == FHIRDefinedType.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == FHIRDefinedType.MEASURE)
        return "Measure";
      if (code == FHIRDefinedType.MEASUREREPORT)
        return "MeasureReport";
      if (code == FHIRDefinedType.MEDICATION)
        return "Medication";
      if (code == FHIRDefinedType.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == FHIRDefinedType.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == FHIRDefinedType.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == FHIRDefinedType.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == FHIRDefinedType.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == FHIRDefinedType.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == FHIRDefinedType.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == FHIRDefinedType.MESSAGEHEADER)
        return "MessageHeader";
      if (code == FHIRDefinedType.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == FHIRDefinedType.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == FHIRDefinedType.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == FHIRDefinedType.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == FHIRDefinedType.NUTRITIONPRODUCT)
        return "NutritionProduct";
      if (code == FHIRDefinedType.OBSERVATION)
        return "Observation";
      if (code == FHIRDefinedType.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == FHIRDefinedType.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == FHIRDefinedType.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == FHIRDefinedType.ORGANIZATION)
        return "Organization";
      if (code == FHIRDefinedType.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == FHIRDefinedType.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == FHIRDefinedType.PARAMETERS)
        return "Parameters";
      if (code == FHIRDefinedType.PATIENT)
        return "Patient";
      if (code == FHIRDefinedType.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == FHIRDefinedType.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == FHIRDefinedType.PERMISSION)
        return "Permission";
      if (code == FHIRDefinedType.PERSON)
        return "Person";
      if (code == FHIRDefinedType.PLANDEFINITION)
        return "PlanDefinition";
      if (code == FHIRDefinedType.PRACTITIONER)
        return "Practitioner";
      if (code == FHIRDefinedType.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == FHIRDefinedType.PROCEDURE)
        return "Procedure";
      if (code == FHIRDefinedType.PROVENANCE)
        return "Provenance";
      if (code == FHIRDefinedType.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == FHIRDefinedType.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == FHIRDefinedType.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == FHIRDefinedType.RELATEDPERSON)
        return "RelatedPerson";
      if (code == FHIRDefinedType.REQUESTGROUP)
        return "RequestGroup";
      if (code == FHIRDefinedType.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == FHIRDefinedType.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == FHIRDefinedType.RESOURCE)
        return "Resource";
      if (code == FHIRDefinedType.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == FHIRDefinedType.SCHEDULE)
        return "Schedule";
      if (code == FHIRDefinedType.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == FHIRDefinedType.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == FHIRDefinedType.SLOT)
        return "Slot";
      if (code == FHIRDefinedType.SPECIMEN)
        return "Specimen";
      if (code == FHIRDefinedType.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == FHIRDefinedType.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == FHIRDefinedType.STRUCTUREMAP)
        return "StructureMap";
      if (code == FHIRDefinedType.SUBSCRIPTION)
        return "Subscription";
      if (code == FHIRDefinedType.SUBSCRIPTIONSTATUS)
        return "SubscriptionStatus";
      if (code == FHIRDefinedType.SUBSCRIPTIONTOPIC)
        return "SubscriptionTopic";
      if (code == FHIRDefinedType.SUBSTANCE)
        return "Substance";
      if (code == FHIRDefinedType.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == FHIRDefinedType.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == FHIRDefinedType.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == FHIRDefinedType.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == FHIRDefinedType.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == FHIRDefinedType.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == FHIRDefinedType.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == FHIRDefinedType.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == FHIRDefinedType.TASK)
        return "Task";
      if (code == FHIRDefinedType.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == FHIRDefinedType.TESTREPORT)
        return "TestReport";
      if (code == FHIRDefinedType.TESTSCRIPT)
        return "TestScript";
      if (code == FHIRDefinedType.VALUESET)
        return "ValueSet";
      if (code == FHIRDefinedType.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == FHIRDefinedType.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(FHIRDefinedType code) {
      return code.getSystem();
      }
    }

    public enum TestScriptRequestMethodCode {
        /**
         * HTTP DELETE operation.
         */
        DELETE, 
        /**
         * HTTP GET operation.
         */
        GET, 
        /**
         * HTTP OPTIONS operation.
         */
        OPTIONS, 
        /**
         * HTTP PATCH operation.
         */
        PATCH, 
        /**
         * HTTP POST operation.
         */
        POST, 
        /**
         * HTTP PUT operation.
         */
        PUT, 
        /**
         * HTTP HEAD operation.
         */
        HEAD, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TestScriptRequestMethodCode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("delete".equals(codeString))
          return DELETE;
        if ("get".equals(codeString))
          return GET;
        if ("options".equals(codeString))
          return OPTIONS;
        if ("patch".equals(codeString))
          return PATCH;
        if ("post".equals(codeString))
          return POST;
        if ("put".equals(codeString))
          return PUT;
        if ("head".equals(codeString))
          return HEAD;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TestScriptRequestMethodCode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DELETE: return "delete";
            case GET: return "get";
            case OPTIONS: return "options";
            case PATCH: return "patch";
            case POST: return "post";
            case PUT: return "put";
            case HEAD: return "head";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DELETE: return "http://hl7.org/fhir/http-operations";
            case GET: return "http://hl7.org/fhir/http-operations";
            case OPTIONS: return "http://hl7.org/fhir/http-operations";
            case PATCH: return "http://hl7.org/fhir/http-operations";
            case POST: return "http://hl7.org/fhir/http-operations";
            case PUT: return "http://hl7.org/fhir/http-operations";
            case HEAD: return "http://hl7.org/fhir/http-operations";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DELETE: return "HTTP DELETE operation.";
            case GET: return "HTTP GET operation.";
            case OPTIONS: return "HTTP OPTIONS operation.";
            case PATCH: return "HTTP PATCH operation.";
            case POST: return "HTTP POST operation.";
            case PUT: return "HTTP PUT operation.";
            case HEAD: return "HTTP HEAD operation.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DELETE: return "DELETE";
            case GET: return "GET";
            case OPTIONS: return "OPTIONS";
            case PATCH: return "PATCH";
            case POST: return "POST";
            case PUT: return "PUT";
            case HEAD: return "HEAD";
            default: return "?";
          }
        }
    }

  public static class TestScriptRequestMethodCodeEnumFactory implements EnumFactory<TestScriptRequestMethodCode> {
    public TestScriptRequestMethodCode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("delete".equals(codeString))
          return TestScriptRequestMethodCode.DELETE;
        if ("get".equals(codeString))
          return TestScriptRequestMethodCode.GET;
        if ("options".equals(codeString))
          return TestScriptRequestMethodCode.OPTIONS;
        if ("patch".equals(codeString))
          return TestScriptRequestMethodCode.PATCH;
        if ("post".equals(codeString))
          return TestScriptRequestMethodCode.POST;
        if ("put".equals(codeString))
          return TestScriptRequestMethodCode.PUT;
        if ("head".equals(codeString))
          return TestScriptRequestMethodCode.HEAD;
        throw new IllegalArgumentException("Unknown TestScriptRequestMethodCode code '"+codeString+"'");
        }
        public Enumeration<TestScriptRequestMethodCode> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TestScriptRequestMethodCode>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("delete".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.DELETE);
        if ("get".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.GET);
        if ("options".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.OPTIONS);
        if ("patch".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.PATCH);
        if ("post".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.POST);
        if ("put".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.PUT);
        if ("head".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.HEAD);
        throw new FHIRException("Unknown TestScriptRequestMethodCode code '"+codeString+"'");
        }
    public String toCode(TestScriptRequestMethodCode code) {
      if (code == TestScriptRequestMethodCode.DELETE)
        return "delete";
      if (code == TestScriptRequestMethodCode.GET)
        return "get";
      if (code == TestScriptRequestMethodCode.OPTIONS)
        return "options";
      if (code == TestScriptRequestMethodCode.PATCH)
        return "patch";
      if (code == TestScriptRequestMethodCode.POST)
        return "post";
      if (code == TestScriptRequestMethodCode.PUT)
        return "put";
      if (code == TestScriptRequestMethodCode.HEAD)
        return "head";
      return "?";
      }
    public String toSystem(TestScriptRequestMethodCode code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class TestScriptOriginComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.
         */
        @Child(name = "index", type = {IntegerType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The index of the abstract origin server starting at 1", formalDefinition="Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1." )
        protected IntegerType index;

        /**
         * The type of origin profile the test system supports.
         */
        @Child(name = "profile", type = {Coding.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="FHIR-Client | FHIR-SDC-FormFiller", formalDefinition="The type of origin profile the test system supports." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-profile-origin-types")
        protected Coding profile;

        private static final long serialVersionUID = -1239935149L;

    /**
     * Constructor
     */
      public TestScriptOriginComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptOriginComponent(int index, Coding profile) {
        super();
        this.setIndex(index);
        this.setProfile(profile);
      }

        /**
         * @return {@link #index} (Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.). This is the underlying object with id, value and extensions. The accessor "getIndex" gives direct access to the value
         */
        public IntegerType getIndexElement() { 
          if (this.index == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptOriginComponent.index");
            else if (Configuration.doAutoCreate())
              this.index = new IntegerType(); // bb
          return this.index;
        }

        public boolean hasIndexElement() { 
          return this.index != null && !this.index.isEmpty();
        }

        public boolean hasIndex() { 
          return this.index != null && !this.index.isEmpty();
        }

        /**
         * @param value {@link #index} (Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.). This is the underlying object with id, value and extensions. The accessor "getIndex" gives direct access to the value
         */
        public TestScriptOriginComponent setIndexElement(IntegerType value) { 
          this.index = value;
          return this;
        }

        /**
         * @return Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.
         */
        public int getIndex() { 
          return this.index == null || this.index.isEmpty() ? 0 : this.index.getValue();
        }

        /**
         * @param value Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.
         */
        public TestScriptOriginComponent setIndex(int value) { 
            if (this.index == null)
              this.index = new IntegerType();
            this.index.setValue(value);
          return this;
        }

        /**
         * @return {@link #profile} (The type of origin profile the test system supports.)
         */
        public Coding getProfile() { 
          if (this.profile == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptOriginComponent.profile");
            else if (Configuration.doAutoCreate())
              this.profile = new Coding(); // cc
          return this.profile;
        }

        public boolean hasProfile() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        /**
         * @param value {@link #profile} (The type of origin profile the test system supports.)
         */
        public TestScriptOriginComponent setProfile(Coding value) { 
          this.profile = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("index", "integer", "Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.", 0, 1, index));
          children.add(new Property("profile", "Coding", "The type of origin profile the test system supports.", 0, 1, profile));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 100346066: /*index*/  return new Property("index", "integer", "Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.", 0, 1, index);
          case -309425751: /*profile*/  return new Property("profile", "Coding", "The type of origin profile the test system supports.", 0, 1, profile);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return this.index == null ? new Base[0] : new Base[] {this.index}; // IntegerType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // Coding
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 100346066: // index
          this.index = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -309425751: // profile
          this.profile = TypeConvertor.castToCoding(value); // Coding
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("index")) {
          this.index = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("profile")) {
          this.profile = TypeConvertor.castToCoding(value); // Coding
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066:  return getIndexElement();
        case -309425751:  return getProfile();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return new String[] {"integer"};
        case -309425751: /*profile*/ return new String[] {"Coding"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("index")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.origin.index");
        }
        else if (name.equals("profile")) {
          this.profile = new Coding();
          return this.profile;
        }
        else
          return super.addChild(name);
      }

      public TestScriptOriginComponent copy() {
        TestScriptOriginComponent dst = new TestScriptOriginComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptOriginComponent dst) {
        super.copyValues(dst);
        dst.index = index == null ? null : index.copy();
        dst.profile = profile == null ? null : profile.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptOriginComponent))
          return false;
        TestScriptOriginComponent o = (TestScriptOriginComponent) other_;
        return compareDeep(index, o.index, true) && compareDeep(profile, o.profile, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptOriginComponent))
          return false;
        TestScriptOriginComponent o = (TestScriptOriginComponent) other_;
        return compareValues(index, o.index, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(index, profile);
      }

  public String fhirType() {
    return "TestScript.origin";

  }

  }

    @Block()
    public static class TestScriptDestinationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.
         */
        @Child(name = "index", type = {IntegerType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The index of the abstract destination server starting at 1", formalDefinition="Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1." )
        protected IntegerType index;

        /**
         * The type of destination profile the test system supports.
         */
        @Child(name = "profile", type = {Coding.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="FHIR-Server | FHIR-SDC-FormManager | FHIR-SDC-FormReceiver | FHIR-SDC-FormProcessor", formalDefinition="The type of destination profile the test system supports." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-profile-destination-types")
        protected Coding profile;

        private static final long serialVersionUID = -1239935149L;

    /**
     * Constructor
     */
      public TestScriptDestinationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptDestinationComponent(int index, Coding profile) {
        super();
        this.setIndex(index);
        this.setProfile(profile);
      }

        /**
         * @return {@link #index} (Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.). This is the underlying object with id, value and extensions. The accessor "getIndex" gives direct access to the value
         */
        public IntegerType getIndexElement() { 
          if (this.index == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptDestinationComponent.index");
            else if (Configuration.doAutoCreate())
              this.index = new IntegerType(); // bb
          return this.index;
        }

        public boolean hasIndexElement() { 
          return this.index != null && !this.index.isEmpty();
        }

        public boolean hasIndex() { 
          return this.index != null && !this.index.isEmpty();
        }

        /**
         * @param value {@link #index} (Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.). This is the underlying object with id, value and extensions. The accessor "getIndex" gives direct access to the value
         */
        public TestScriptDestinationComponent setIndexElement(IntegerType value) { 
          this.index = value;
          return this;
        }

        /**
         * @return Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.
         */
        public int getIndex() { 
          return this.index == null || this.index.isEmpty() ? 0 : this.index.getValue();
        }

        /**
         * @param value Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.
         */
        public TestScriptDestinationComponent setIndex(int value) { 
            if (this.index == null)
              this.index = new IntegerType();
            this.index.setValue(value);
          return this;
        }

        /**
         * @return {@link #profile} (The type of destination profile the test system supports.)
         */
        public Coding getProfile() { 
          if (this.profile == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptDestinationComponent.profile");
            else if (Configuration.doAutoCreate())
              this.profile = new Coding(); // cc
          return this.profile;
        }

        public boolean hasProfile() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        /**
         * @param value {@link #profile} (The type of destination profile the test system supports.)
         */
        public TestScriptDestinationComponent setProfile(Coding value) { 
          this.profile = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("index", "integer", "Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.", 0, 1, index));
          children.add(new Property("profile", "Coding", "The type of destination profile the test system supports.", 0, 1, profile));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 100346066: /*index*/  return new Property("index", "integer", "Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.", 0, 1, index);
          case -309425751: /*profile*/  return new Property("profile", "Coding", "The type of destination profile the test system supports.", 0, 1, profile);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return this.index == null ? new Base[0] : new Base[] {this.index}; // IntegerType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // Coding
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 100346066: // index
          this.index = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -309425751: // profile
          this.profile = TypeConvertor.castToCoding(value); // Coding
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("index")) {
          this.index = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("profile")) {
          this.profile = TypeConvertor.castToCoding(value); // Coding
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066:  return getIndexElement();
        case -309425751:  return getProfile();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return new String[] {"integer"};
        case -309425751: /*profile*/ return new String[] {"Coding"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("index")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.destination.index");
        }
        else if (name.equals("profile")) {
          this.profile = new Coding();
          return this.profile;
        }
        else
          return super.addChild(name);
      }

      public TestScriptDestinationComponent copy() {
        TestScriptDestinationComponent dst = new TestScriptDestinationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptDestinationComponent dst) {
        super.copyValues(dst);
        dst.index = index == null ? null : index.copy();
        dst.profile = profile == null ? null : profile.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptDestinationComponent))
          return false;
        TestScriptDestinationComponent o = (TestScriptDestinationComponent) other_;
        return compareDeep(index, o.index, true) && compareDeep(profile, o.profile, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptDestinationComponent))
          return false;
        TestScriptDestinationComponent o = (TestScriptDestinationComponent) other_;
        return compareValues(index, o.index, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(index, profile);
      }

  public String fhirType() {
    return "TestScript.destination";

  }

  }

    @Block()
    public static class TestScriptMetadataComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A link to the FHIR specification that this test is covering.
         */
        @Child(name = "link", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Links to the FHIR specification", formalDefinition="A link to the FHIR specification that this test is covering." )
        protected List<TestScriptMetadataLinkComponent> link;

        /**
         * Capabilities that must exist and are assumed to function correctly on the FHIR server being tested.
         */
        @Child(name = "capability", type = {}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Capabilities  that are assumed to function correctly on the FHIR server being tested", formalDefinition="Capabilities that must exist and are assumed to function correctly on the FHIR server being tested." )
        protected List<TestScriptMetadataCapabilityComponent> capability;

        private static final long serialVersionUID = 745183328L;

    /**
     * Constructor
     */
      public TestScriptMetadataComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptMetadataComponent(TestScriptMetadataCapabilityComponent capability) {
        super();
        this.addCapability(capability);
      }

        /**
         * @return {@link #link} (A link to the FHIR specification that this test is covering.)
         */
        public List<TestScriptMetadataLinkComponent> getLink() { 
          if (this.link == null)
            this.link = new ArrayList<TestScriptMetadataLinkComponent>();
          return this.link;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptMetadataComponent setLink(List<TestScriptMetadataLinkComponent> theLink) { 
          this.link = theLink;
          return this;
        }

        public boolean hasLink() { 
          if (this.link == null)
            return false;
          for (TestScriptMetadataLinkComponent item : this.link)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestScriptMetadataLinkComponent addLink() { //3
          TestScriptMetadataLinkComponent t = new TestScriptMetadataLinkComponent();
          if (this.link == null)
            this.link = new ArrayList<TestScriptMetadataLinkComponent>();
          this.link.add(t);
          return t;
        }

        public TestScriptMetadataComponent addLink(TestScriptMetadataLinkComponent t) { //3
          if (t == null)
            return this;
          if (this.link == null)
            this.link = new ArrayList<TestScriptMetadataLinkComponent>();
          this.link.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #link}, creating it if it does not already exist {3}
         */
        public TestScriptMetadataLinkComponent getLinkFirstRep() { 
          if (getLink().isEmpty()) {
            addLink();
          }
          return getLink().get(0);
        }

        /**
         * @return {@link #capability} (Capabilities that must exist and are assumed to function correctly on the FHIR server being tested.)
         */
        public List<TestScriptMetadataCapabilityComponent> getCapability() { 
          if (this.capability == null)
            this.capability = new ArrayList<TestScriptMetadataCapabilityComponent>();
          return this.capability;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptMetadataComponent setCapability(List<TestScriptMetadataCapabilityComponent> theCapability) { 
          this.capability = theCapability;
          return this;
        }

        public boolean hasCapability() { 
          if (this.capability == null)
            return false;
          for (TestScriptMetadataCapabilityComponent item : this.capability)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestScriptMetadataCapabilityComponent addCapability() { //3
          TestScriptMetadataCapabilityComponent t = new TestScriptMetadataCapabilityComponent();
          if (this.capability == null)
            this.capability = new ArrayList<TestScriptMetadataCapabilityComponent>();
          this.capability.add(t);
          return t;
        }

        public TestScriptMetadataComponent addCapability(TestScriptMetadataCapabilityComponent t) { //3
          if (t == null)
            return this;
          if (this.capability == null)
            this.capability = new ArrayList<TestScriptMetadataCapabilityComponent>();
          this.capability.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #capability}, creating it if it does not already exist {3}
         */
        public TestScriptMetadataCapabilityComponent getCapabilityFirstRep() { 
          if (getCapability().isEmpty()) {
            addCapability();
          }
          return getCapability().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("link", "", "A link to the FHIR specification that this test is covering.", 0, java.lang.Integer.MAX_VALUE, link));
          children.add(new Property("capability", "", "Capabilities that must exist and are assumed to function correctly on the FHIR server being tested.", 0, java.lang.Integer.MAX_VALUE, capability));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3321850: /*link*/  return new Property("link", "", "A link to the FHIR specification that this test is covering.", 0, java.lang.Integer.MAX_VALUE, link);
          case -783669992: /*capability*/  return new Property("capability", "", "Capabilities that must exist and are assumed to function correctly on the FHIR server being tested.", 0, java.lang.Integer.MAX_VALUE, capability);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3321850: /*link*/ return this.link == null ? new Base[0] : this.link.toArray(new Base[this.link.size()]); // TestScriptMetadataLinkComponent
        case -783669992: /*capability*/ return this.capability == null ? new Base[0] : this.capability.toArray(new Base[this.capability.size()]); // TestScriptMetadataCapabilityComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3321850: // link
          this.getLink().add((TestScriptMetadataLinkComponent) value); // TestScriptMetadataLinkComponent
          return value;
        case -783669992: // capability
          this.getCapability().add((TestScriptMetadataCapabilityComponent) value); // TestScriptMetadataCapabilityComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("link")) {
          this.getLink().add((TestScriptMetadataLinkComponent) value);
        } else if (name.equals("capability")) {
          this.getCapability().add((TestScriptMetadataCapabilityComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3321850:  return addLink(); 
        case -783669992:  return addCapability(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3321850: /*link*/ return new String[] {};
        case -783669992: /*capability*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("link")) {
          return addLink();
        }
        else if (name.equals("capability")) {
          return addCapability();
        }
        else
          return super.addChild(name);
      }

      public TestScriptMetadataComponent copy() {
        TestScriptMetadataComponent dst = new TestScriptMetadataComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptMetadataComponent dst) {
        super.copyValues(dst);
        if (link != null) {
          dst.link = new ArrayList<TestScriptMetadataLinkComponent>();
          for (TestScriptMetadataLinkComponent i : link)
            dst.link.add(i.copy());
        };
        if (capability != null) {
          dst.capability = new ArrayList<TestScriptMetadataCapabilityComponent>();
          for (TestScriptMetadataCapabilityComponent i : capability)
            dst.capability.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptMetadataComponent))
          return false;
        TestScriptMetadataComponent o = (TestScriptMetadataComponent) other_;
        return compareDeep(link, o.link, true) && compareDeep(capability, o.capability, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptMetadataComponent))
          return false;
        TestScriptMetadataComponent o = (TestScriptMetadataComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(link, capability);
      }

  public String fhirType() {
    return "TestScript.metadata";

  }

  }

    @Block()
    public static class TestScriptMetadataLinkComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * URL to a particular requirement or feature within the FHIR specification.
         */
        @Child(name = "url", type = {UriType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="URL to the specification", formalDefinition="URL to a particular requirement or feature within the FHIR specification." )
        protected UriType url;

        /**
         * Short description of the link.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Short description", formalDefinition="Short description of the link." )
        protected StringType description;

        private static final long serialVersionUID = 213372298L;

    /**
     * Constructor
     */
      public TestScriptMetadataLinkComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptMetadataLinkComponent(String url) {
        super();
        this.setUrl(url);
      }

        /**
         * @return {@link #url} (URL to a particular requirement or feature within the FHIR specification.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UriType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataLinkComponent.url");
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
         * @param value {@link #url} (URL to a particular requirement or feature within the FHIR specification.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public TestScriptMetadataLinkComponent setUrlElement(UriType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return URL to a particular requirement or feature within the FHIR specification.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value URL to a particular requirement or feature within the FHIR specification.
         */
        public TestScriptMetadataLinkComponent setUrl(String value) { 
            if (this.url == null)
              this.url = new UriType();
            this.url.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Short description of the link.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataLinkComponent.description");
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
         * @param value {@link #description} (Short description of the link.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestScriptMetadataLinkComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Short description of the link.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Short description of the link.
         */
        public TestScriptMetadataLinkComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("url", "uri", "URL to a particular requirement or feature within the FHIR specification.", 0, 1, url));
          children.add(new Property("description", "string", "Short description of the link.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 116079: /*url*/  return new Property("url", "uri", "URL to a particular requirement or feature within the FHIR specification.", 0, 1, url);
          case -1724546052: /*description*/  return new Property("description", "string", "Short description of the link.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1724546052: /*description*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.link.url");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.link.description");
        }
        else
          return super.addChild(name);
      }

      public TestScriptMetadataLinkComponent copy() {
        TestScriptMetadataLinkComponent dst = new TestScriptMetadataLinkComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptMetadataLinkComponent dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptMetadataLinkComponent))
          return false;
        TestScriptMetadataLinkComponent o = (TestScriptMetadataLinkComponent) other_;
        return compareDeep(url, o.url, true) && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptMetadataLinkComponent))
          return false;
        TestScriptMetadataLinkComponent o = (TestScriptMetadataLinkComponent) other_;
        return compareValues(url, o.url, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, description);
      }

  public String fhirType() {
    return "TestScript.metadata.link";

  }

  }

    @Block()
    public static class TestScriptMetadataCapabilityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.
         */
        @Child(name = "required", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Are the capabilities required?", formalDefinition="Whether or not the test execution will require the given capabilities of the server in order for this test script to execute." )
        protected BooleanType required;

        /**
         * Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.
         */
        @Child(name = "validated", type = {BooleanType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Are the capabilities validated?", formalDefinition="Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute." )
        protected BooleanType validated;

        /**
         * Description of the capabilities that this test script is requiring the server to support.
         */
        @Child(name = "description", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The expected capabilities of the server", formalDefinition="Description of the capabilities that this test script is requiring the server to support." )
        protected StringType description;

        /**
         * Which origin server these requirements apply to.
         */
        @Child(name = "origin", type = {IntegerType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Which origin server these requirements apply to", formalDefinition="Which origin server these requirements apply to." )
        protected List<IntegerType> origin;

        /**
         * Which server these requirements apply to.
         */
        @Child(name = "destination", type = {IntegerType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Which server these requirements apply to", formalDefinition="Which server these requirements apply to." )
        protected IntegerType destination;

        /**
         * Links to the FHIR specification that describes this interaction and the resources involved in more detail.
         */
        @Child(name = "link", type = {UriType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Links to the FHIR specification", formalDefinition="Links to the FHIR specification that describes this interaction and the resources involved in more detail." )
        protected List<UriType> link;

        /**
         * Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.
         */
        @Child(name = "capabilities", type = {CanonicalType.class}, order=7, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Required Capability Statement", formalDefinition="Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped." )
        protected CanonicalType capabilities;

        private static final long serialVersionUID = -1368199288L;

    /**
     * Constructor
     */
      public TestScriptMetadataCapabilityComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptMetadataCapabilityComponent(boolean required, boolean validated, String capabilities) {
        super();
        this.setRequired(required);
        this.setValidated(validated);
        this.setCapabilities(capabilities);
      }

        /**
         * @return {@link #required} (Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.). This is the underlying object with id, value and extensions. The accessor "getRequired" gives direct access to the value
         */
        public BooleanType getRequiredElement() { 
          if (this.required == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataCapabilityComponent.required");
            else if (Configuration.doAutoCreate())
              this.required = new BooleanType(); // bb
          return this.required;
        }

        public boolean hasRequiredElement() { 
          return this.required != null && !this.required.isEmpty();
        }

        public boolean hasRequired() { 
          return this.required != null && !this.required.isEmpty();
        }

        /**
         * @param value {@link #required} (Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.). This is the underlying object with id, value and extensions. The accessor "getRequired" gives direct access to the value
         */
        public TestScriptMetadataCapabilityComponent setRequiredElement(BooleanType value) { 
          this.required = value;
          return this;
        }

        /**
         * @return Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.
         */
        public boolean getRequired() { 
          return this.required == null || this.required.isEmpty() ? false : this.required.getValue();
        }

        /**
         * @param value Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.
         */
        public TestScriptMetadataCapabilityComponent setRequired(boolean value) { 
            if (this.required == null)
              this.required = new BooleanType();
            this.required.setValue(value);
          return this;
        }

        /**
         * @return {@link #validated} (Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.). This is the underlying object with id, value and extensions. The accessor "getValidated" gives direct access to the value
         */
        public BooleanType getValidatedElement() { 
          if (this.validated == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataCapabilityComponent.validated");
            else if (Configuration.doAutoCreate())
              this.validated = new BooleanType(); // bb
          return this.validated;
        }

        public boolean hasValidatedElement() { 
          return this.validated != null && !this.validated.isEmpty();
        }

        public boolean hasValidated() { 
          return this.validated != null && !this.validated.isEmpty();
        }

        /**
         * @param value {@link #validated} (Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.). This is the underlying object with id, value and extensions. The accessor "getValidated" gives direct access to the value
         */
        public TestScriptMetadataCapabilityComponent setValidatedElement(BooleanType value) { 
          this.validated = value;
          return this;
        }

        /**
         * @return Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.
         */
        public boolean getValidated() { 
          return this.validated == null || this.validated.isEmpty() ? false : this.validated.getValue();
        }

        /**
         * @param value Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.
         */
        public TestScriptMetadataCapabilityComponent setValidated(boolean value) { 
            if (this.validated == null)
              this.validated = new BooleanType();
            this.validated.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Description of the capabilities that this test script is requiring the server to support.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataCapabilityComponent.description");
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
         * @param value {@link #description} (Description of the capabilities that this test script is requiring the server to support.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestScriptMetadataCapabilityComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of the capabilities that this test script is requiring the server to support.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of the capabilities that this test script is requiring the server to support.
         */
        public TestScriptMetadataCapabilityComponent setDescription(String value) { 
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
         * @return {@link #origin} (Which origin server these requirements apply to.)
         */
        public List<IntegerType> getOrigin() { 
          if (this.origin == null)
            this.origin = new ArrayList<IntegerType>();
          return this.origin;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptMetadataCapabilityComponent setOrigin(List<IntegerType> theOrigin) { 
          this.origin = theOrigin;
          return this;
        }

        public boolean hasOrigin() { 
          if (this.origin == null)
            return false;
          for (IntegerType item : this.origin)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #origin} (Which origin server these requirements apply to.)
         */
        public IntegerType addOriginElement() {//2 
          IntegerType t = new IntegerType();
          if (this.origin == null)
            this.origin = new ArrayList<IntegerType>();
          this.origin.add(t);
          return t;
        }

        /**
         * @param value {@link #origin} (Which origin server these requirements apply to.)
         */
        public TestScriptMetadataCapabilityComponent addOrigin(int value) { //1
          IntegerType t = new IntegerType();
          t.setValue(value);
          if (this.origin == null)
            this.origin = new ArrayList<IntegerType>();
          this.origin.add(t);
          return this;
        }

        /**
         * @param value {@link #origin} (Which origin server these requirements apply to.)
         */
        public boolean hasOrigin(int value) { 
          if (this.origin == null)
            return false;
          for (IntegerType v : this.origin)
            if (v.getValue().equals(value)) // integer
              return true;
          return false;
        }

        /**
         * @return {@link #destination} (Which server these requirements apply to.). This is the underlying object with id, value and extensions. The accessor "getDestination" gives direct access to the value
         */
        public IntegerType getDestinationElement() { 
          if (this.destination == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataCapabilityComponent.destination");
            else if (Configuration.doAutoCreate())
              this.destination = new IntegerType(); // bb
          return this.destination;
        }

        public boolean hasDestinationElement() { 
          return this.destination != null && !this.destination.isEmpty();
        }

        public boolean hasDestination() { 
          return this.destination != null && !this.destination.isEmpty();
        }

        /**
         * @param value {@link #destination} (Which server these requirements apply to.). This is the underlying object with id, value and extensions. The accessor "getDestination" gives direct access to the value
         */
        public TestScriptMetadataCapabilityComponent setDestinationElement(IntegerType value) { 
          this.destination = value;
          return this;
        }

        /**
         * @return Which server these requirements apply to.
         */
        public int getDestination() { 
          return this.destination == null || this.destination.isEmpty() ? 0 : this.destination.getValue();
        }

        /**
         * @param value Which server these requirements apply to.
         */
        public TestScriptMetadataCapabilityComponent setDestination(int value) { 
            if (this.destination == null)
              this.destination = new IntegerType();
            this.destination.setValue(value);
          return this;
        }

        /**
         * @return {@link #link} (Links to the FHIR specification that describes this interaction and the resources involved in more detail.)
         */
        public List<UriType> getLink() { 
          if (this.link == null)
            this.link = new ArrayList<UriType>();
          return this.link;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptMetadataCapabilityComponent setLink(List<UriType> theLink) { 
          this.link = theLink;
          return this;
        }

        public boolean hasLink() { 
          if (this.link == null)
            return false;
          for (UriType item : this.link)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #link} (Links to the FHIR specification that describes this interaction and the resources involved in more detail.)
         */
        public UriType addLinkElement() {//2 
          UriType t = new UriType();
          if (this.link == null)
            this.link = new ArrayList<UriType>();
          this.link.add(t);
          return t;
        }

        /**
         * @param value {@link #link} (Links to the FHIR specification that describes this interaction and the resources involved in more detail.)
         */
        public TestScriptMetadataCapabilityComponent addLink(String value) { //1
          UriType t = new UriType();
          t.setValue(value);
          if (this.link == null)
            this.link = new ArrayList<UriType>();
          this.link.add(t);
          return this;
        }

        /**
         * @param value {@link #link} (Links to the FHIR specification that describes this interaction and the resources involved in more detail.)
         */
        public boolean hasLink(String value) { 
          if (this.link == null)
            return false;
          for (UriType v : this.link)
            if (v.getValue().equals(value)) // uri
              return true;
          return false;
        }

        /**
         * @return {@link #capabilities} (Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.). This is the underlying object with id, value and extensions. The accessor "getCapabilities" gives direct access to the value
         */
        public CanonicalType getCapabilitiesElement() { 
          if (this.capabilities == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptMetadataCapabilityComponent.capabilities");
            else if (Configuration.doAutoCreate())
              this.capabilities = new CanonicalType(); // bb
          return this.capabilities;
        }

        public boolean hasCapabilitiesElement() { 
          return this.capabilities != null && !this.capabilities.isEmpty();
        }

        public boolean hasCapabilities() { 
          return this.capabilities != null && !this.capabilities.isEmpty();
        }

        /**
         * @param value {@link #capabilities} (Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.). This is the underlying object with id, value and extensions. The accessor "getCapabilities" gives direct access to the value
         */
        public TestScriptMetadataCapabilityComponent setCapabilitiesElement(CanonicalType value) { 
          this.capabilities = value;
          return this;
        }

        /**
         * @return Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.
         */
        public String getCapabilities() { 
          return this.capabilities == null ? null : this.capabilities.getValue();
        }

        /**
         * @param value Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.
         */
        public TestScriptMetadataCapabilityComponent setCapabilities(String value) { 
            if (this.capabilities == null)
              this.capabilities = new CanonicalType();
            this.capabilities.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("required", "boolean", "Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.", 0, 1, required));
          children.add(new Property("validated", "boolean", "Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.", 0, 1, validated));
          children.add(new Property("description", "string", "Description of the capabilities that this test script is requiring the server to support.", 0, 1, description));
          children.add(new Property("origin", "integer", "Which origin server these requirements apply to.", 0, java.lang.Integer.MAX_VALUE, origin));
          children.add(new Property("destination", "integer", "Which server these requirements apply to.", 0, 1, destination));
          children.add(new Property("link", "uri", "Links to the FHIR specification that describes this interaction and the resources involved in more detail.", 0, java.lang.Integer.MAX_VALUE, link));
          children.add(new Property("capabilities", "canonical(CapabilityStatement)", "Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.", 0, 1, capabilities));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -393139297: /*required*/  return new Property("required", "boolean", "Whether or not the test execution will require the given capabilities of the server in order for this test script to execute.", 0, 1, required);
          case -1109784050: /*validated*/  return new Property("validated", "boolean", "Whether or not the test execution will validate the given capabilities of the server in order for this test script to execute.", 0, 1, validated);
          case -1724546052: /*description*/  return new Property("description", "string", "Description of the capabilities that this test script is requiring the server to support.", 0, 1, description);
          case -1008619738: /*origin*/  return new Property("origin", "integer", "Which origin server these requirements apply to.", 0, java.lang.Integer.MAX_VALUE, origin);
          case -1429847026: /*destination*/  return new Property("destination", "integer", "Which server these requirements apply to.", 0, 1, destination);
          case 3321850: /*link*/  return new Property("link", "uri", "Links to the FHIR specification that describes this interaction and the resources involved in more detail.", 0, java.lang.Integer.MAX_VALUE, link);
          case -1487597642: /*capabilities*/  return new Property("capabilities", "canonical(CapabilityStatement)", "Minimum capabilities required of server for test script to execute successfully.   If server does not meet at a minimum the referenced capability statement, then all tests in this script are skipped.", 0, 1, capabilities);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -393139297: /*required*/ return this.required == null ? new Base[0] : new Base[] {this.required}; // BooleanType
        case -1109784050: /*validated*/ return this.validated == null ? new Base[0] : new Base[] {this.validated}; // BooleanType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : this.origin.toArray(new Base[this.origin.size()]); // IntegerType
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // IntegerType
        case 3321850: /*link*/ return this.link == null ? new Base[0] : this.link.toArray(new Base[this.link.size()]); // UriType
        case -1487597642: /*capabilities*/ return this.capabilities == null ? new Base[0] : new Base[] {this.capabilities}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -393139297: // required
          this.required = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1109784050: // validated
          this.validated = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1008619738: // origin
          this.getOrigin().add(TypeConvertor.castToInteger(value)); // IntegerType
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 3321850: // link
          this.getLink().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -1487597642: // capabilities
          this.capabilities = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("required")) {
          this.required = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("validated")) {
          this.validated = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("origin")) {
          this.getOrigin().add(TypeConvertor.castToInteger(value));
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("link")) {
          this.getLink().add(TypeConvertor.castToUri(value));
        } else if (name.equals("capabilities")) {
          this.capabilities = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -393139297:  return getRequiredElement();
        case -1109784050:  return getValidatedElement();
        case -1724546052:  return getDescriptionElement();
        case -1008619738:  return addOriginElement();
        case -1429847026:  return getDestinationElement();
        case 3321850:  return addLinkElement();
        case -1487597642:  return getCapabilitiesElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -393139297: /*required*/ return new String[] {"boolean"};
        case -1109784050: /*validated*/ return new String[] {"boolean"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1008619738: /*origin*/ return new String[] {"integer"};
        case -1429847026: /*destination*/ return new String[] {"integer"};
        case 3321850: /*link*/ return new String[] {"uri"};
        case -1487597642: /*capabilities*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("required")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.required");
        }
        else if (name.equals("validated")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.validated");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.description");
        }
        else if (name.equals("origin")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.origin");
        }
        else if (name.equals("destination")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.destination");
        }
        else if (name.equals("link")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.link");
        }
        else if (name.equals("capabilities")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.metadata.capability.capabilities");
        }
        else
          return super.addChild(name);
      }

      public TestScriptMetadataCapabilityComponent copy() {
        TestScriptMetadataCapabilityComponent dst = new TestScriptMetadataCapabilityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptMetadataCapabilityComponent dst) {
        super.copyValues(dst);
        dst.required = required == null ? null : required.copy();
        dst.validated = validated == null ? null : validated.copy();
        dst.description = description == null ? null : description.copy();
        if (origin != null) {
          dst.origin = new ArrayList<IntegerType>();
          for (IntegerType i : origin)
            dst.origin.add(i.copy());
        };
        dst.destination = destination == null ? null : destination.copy();
        if (link != null) {
          dst.link = new ArrayList<UriType>();
          for (UriType i : link)
            dst.link.add(i.copy());
        };
        dst.capabilities = capabilities == null ? null : capabilities.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptMetadataCapabilityComponent))
          return false;
        TestScriptMetadataCapabilityComponent o = (TestScriptMetadataCapabilityComponent) other_;
        return compareDeep(required, o.required, true) && compareDeep(validated, o.validated, true) && compareDeep(description, o.description, true)
           && compareDeep(origin, o.origin, true) && compareDeep(destination, o.destination, true) && compareDeep(link, o.link, true)
           && compareDeep(capabilities, o.capabilities, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptMetadataCapabilityComponent))
          return false;
        TestScriptMetadataCapabilityComponent o = (TestScriptMetadataCapabilityComponent) other_;
        return compareValues(required, o.required, true) && compareValues(validated, o.validated, true) && compareValues(description, o.description, true)
           && compareValues(origin, o.origin, true) && compareValues(destination, o.destination, true) && compareValues(link, o.link, true)
           && compareValues(capabilities, o.capabilities, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(required, validated, description
          , origin, destination, link, capabilities);
      }

  public String fhirType() {
    return "TestScript.metadata.capability";

  }

  }

    @Block()
    public static class TestScriptFixtureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.
         */
        @Child(name = "autocreate", type = {BooleanType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not to implicitly create the fixture during setup", formalDefinition="Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section." )
        protected BooleanType autocreate;

        /**
         * Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.
         */
        @Child(name = "autodelete", type = {BooleanType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not to implicitly delete the fixture during teardown", formalDefinition="Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section." )
        protected BooleanType autodelete;

        /**
         * Reference to the resource (containing the contents of the resource needed for operations).
         */
        @Child(name = "resource", type = {Reference.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference of the resource", formalDefinition="Reference to the resource (containing the contents of the resource needed for operations)." )
        protected Reference resource;

        private static final long serialVersionUID = 672117234L;

    /**
     * Constructor
     */
      public TestScriptFixtureComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptFixtureComponent(boolean autocreate, boolean autodelete) {
        super();
        this.setAutocreate(autocreate);
        this.setAutodelete(autodelete);
      }

        /**
         * @return {@link #autocreate} (Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.). This is the underlying object with id, value and extensions. The accessor "getAutocreate" gives direct access to the value
         */
        public BooleanType getAutocreateElement() { 
          if (this.autocreate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptFixtureComponent.autocreate");
            else if (Configuration.doAutoCreate())
              this.autocreate = new BooleanType(); // bb
          return this.autocreate;
        }

        public boolean hasAutocreateElement() { 
          return this.autocreate != null && !this.autocreate.isEmpty();
        }

        public boolean hasAutocreate() { 
          return this.autocreate != null && !this.autocreate.isEmpty();
        }

        /**
         * @param value {@link #autocreate} (Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.). This is the underlying object with id, value and extensions. The accessor "getAutocreate" gives direct access to the value
         */
        public TestScriptFixtureComponent setAutocreateElement(BooleanType value) { 
          this.autocreate = value;
          return this;
        }

        /**
         * @return Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.
         */
        public boolean getAutocreate() { 
          return this.autocreate == null || this.autocreate.isEmpty() ? false : this.autocreate.getValue();
        }

        /**
         * @param value Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.
         */
        public TestScriptFixtureComponent setAutocreate(boolean value) { 
            if (this.autocreate == null)
              this.autocreate = new BooleanType();
            this.autocreate.setValue(value);
          return this;
        }

        /**
         * @return {@link #autodelete} (Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.). This is the underlying object with id, value and extensions. The accessor "getAutodelete" gives direct access to the value
         */
        public BooleanType getAutodeleteElement() { 
          if (this.autodelete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptFixtureComponent.autodelete");
            else if (Configuration.doAutoCreate())
              this.autodelete = new BooleanType(); // bb
          return this.autodelete;
        }

        public boolean hasAutodeleteElement() { 
          return this.autodelete != null && !this.autodelete.isEmpty();
        }

        public boolean hasAutodelete() { 
          return this.autodelete != null && !this.autodelete.isEmpty();
        }

        /**
         * @param value {@link #autodelete} (Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.). This is the underlying object with id, value and extensions. The accessor "getAutodelete" gives direct access to the value
         */
        public TestScriptFixtureComponent setAutodeleteElement(BooleanType value) { 
          this.autodelete = value;
          return this;
        }

        /**
         * @return Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.
         */
        public boolean getAutodelete() { 
          return this.autodelete == null || this.autodelete.isEmpty() ? false : this.autodelete.getValue();
        }

        /**
         * @param value Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.
         */
        public TestScriptFixtureComponent setAutodelete(boolean value) { 
            if (this.autodelete == null)
              this.autodelete = new BooleanType();
            this.autodelete.setValue(value);
          return this;
        }

        /**
         * @return {@link #resource} (Reference to the resource (containing the contents of the resource needed for operations).)
         */
        public Reference getResource() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptFixtureComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new Reference(); // cc
          return this.resource;
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (Reference to the resource (containing the contents of the resource needed for operations).)
         */
        public TestScriptFixtureComponent setResource(Reference value) { 
          this.resource = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("autocreate", "boolean", "Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.", 0, 1, autocreate));
          children.add(new Property("autodelete", "boolean", "Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.", 0, 1, autodelete));
          children.add(new Property("resource", "Reference(Any)", "Reference to the resource (containing the contents of the resource needed for operations).", 0, 1, resource));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 73154411: /*autocreate*/  return new Property("autocreate", "boolean", "Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.", 0, 1, autocreate);
          case 89990170: /*autodelete*/  return new Property("autodelete", "boolean", "Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.", 0, 1, autodelete);
          case -341064690: /*resource*/  return new Property("resource", "Reference(Any)", "Reference to the resource (containing the contents of the resource needed for operations).", 0, 1, resource);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 73154411: /*autocreate*/ return this.autocreate == null ? new Base[0] : new Base[] {this.autocreate}; // BooleanType
        case 89990170: /*autodelete*/ return this.autodelete == null ? new Base[0] : new Base[] {this.autodelete}; // BooleanType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 73154411: // autocreate
          this.autocreate = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 89990170: // autodelete
          this.autodelete = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -341064690: // resource
          this.resource = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("autocreate")) {
          this.autocreate = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("autodelete")) {
          this.autodelete = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 73154411:  return getAutocreateElement();
        case 89990170:  return getAutodeleteElement();
        case -341064690:  return getResource();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 73154411: /*autocreate*/ return new String[] {"boolean"};
        case 89990170: /*autodelete*/ return new String[] {"boolean"};
        case -341064690: /*resource*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("autocreate")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.fixture.autocreate");
        }
        else if (name.equals("autodelete")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.fixture.autodelete");
        }
        else if (name.equals("resource")) {
          this.resource = new Reference();
          return this.resource;
        }
        else
          return super.addChild(name);
      }

      public TestScriptFixtureComponent copy() {
        TestScriptFixtureComponent dst = new TestScriptFixtureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptFixtureComponent dst) {
        super.copyValues(dst);
        dst.autocreate = autocreate == null ? null : autocreate.copy();
        dst.autodelete = autodelete == null ? null : autodelete.copy();
        dst.resource = resource == null ? null : resource.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptFixtureComponent))
          return false;
        TestScriptFixtureComponent o = (TestScriptFixtureComponent) other_;
        return compareDeep(autocreate, o.autocreate, true) && compareDeep(autodelete, o.autodelete, true)
           && compareDeep(resource, o.resource, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptFixtureComponent))
          return false;
        TestScriptFixtureComponent o = (TestScriptFixtureComponent) other_;
        return compareValues(autocreate, o.autocreate, true) && compareValues(autodelete, o.autodelete, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(autocreate, autodelete, resource
          );
      }

  public String fhirType() {
    return "TestScript.fixture";

  }

  }

    @Block()
    public static class TestScriptVariableComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Descriptive name for this variable.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Descriptive name for this variable", formalDefinition="Descriptive name for this variable." )
        protected StringType name;

        /**
         * A default, hard-coded, or user-defined value for this variable.
         */
        @Child(name = "defaultValue", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Default, hard-coded, or user-defined value for this variable", formalDefinition="A default, hard-coded, or user-defined value for this variable." )
        protected StringType defaultValue;

        /**
         * A free text natural language description of the variable and its purpose.
         */
        @Child(name = "description", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Natural language description of the variable", formalDefinition="A free text natural language description of the variable and its purpose." )
        protected StringType description;

        /**
         * The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.
         */
        @Child(name = "expression", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The FHIRPath expression against the fixture body", formalDefinition="The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified." )
        protected StringType expression;

        /**
         * Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.
         */
        @Child(name = "headerField", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP header field name for source", formalDefinition="Will be used to grab the HTTP header field value from the headers that sourceId is pointing to." )
        protected StringType headerField;

        /**
         * Displayable text string with hint help information to the user when entering a default value.
         */
        @Child(name = "hint", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Hint help text for default value to enter", formalDefinition="Displayable text string with hint help information to the user when entering a default value." )
        protected StringType hint;

        /**
         * XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.
         */
        @Child(name = "path", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="XPath or JSONPath against the fixture body", formalDefinition="XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified." )
        protected StringType path;

        /**
         * Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.
         */
        @Child(name = "sourceId", type = {IdType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of source expression or headerField within this variable", formalDefinition="Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable." )
        protected IdType sourceId;

        private static final long serialVersionUID = -1592325432L;

    /**
     * Constructor
     */
      public TestScriptVariableComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptVariableComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (Descriptive name for this variable.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.name");
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
         * @param value {@link #name} (Descriptive name for this variable.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TestScriptVariableComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Descriptive name for this variable.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Descriptive name for this variable.
         */
        public TestScriptVariableComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #defaultValue} (A default, hard-coded, or user-defined value for this variable.). This is the underlying object with id, value and extensions. The accessor "getDefaultValue" gives direct access to the value
         */
        public StringType getDefaultValueElement() { 
          if (this.defaultValue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.defaultValue");
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
         * @param value {@link #defaultValue} (A default, hard-coded, or user-defined value for this variable.). This is the underlying object with id, value and extensions. The accessor "getDefaultValue" gives direct access to the value
         */
        public TestScriptVariableComponent setDefaultValueElement(StringType value) { 
          this.defaultValue = value;
          return this;
        }

        /**
         * @return A default, hard-coded, or user-defined value for this variable.
         */
        public String getDefaultValue() { 
          return this.defaultValue == null ? null : this.defaultValue.getValue();
        }

        /**
         * @param value A default, hard-coded, or user-defined value for this variable.
         */
        public TestScriptVariableComponent setDefaultValue(String value) { 
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
         * @return {@link #description} (A free text natural language description of the variable and its purpose.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.description");
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
         * @param value {@link #description} (A free text natural language description of the variable and its purpose.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestScriptVariableComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A free text natural language description of the variable and its purpose.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A free text natural language description of the variable and its purpose.
         */
        public TestScriptVariableComponent setDescription(String value) { 
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
         * @return {@link #expression} (The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public StringType getExpressionElement() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.expression");
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
         * @param value {@link #expression} (The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public TestScriptVariableComponent setExpressionElement(StringType value) { 
          this.expression = value;
          return this;
        }

        /**
         * @return The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.
         */
        public String getExpression() { 
          return this.expression == null ? null : this.expression.getValue();
        }

        /**
         * @param value The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.
         */
        public TestScriptVariableComponent setExpression(String value) { 
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
         * @return {@link #headerField} (Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.). This is the underlying object with id, value and extensions. The accessor "getHeaderField" gives direct access to the value
         */
        public StringType getHeaderFieldElement() { 
          if (this.headerField == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.headerField");
            else if (Configuration.doAutoCreate())
              this.headerField = new StringType(); // bb
          return this.headerField;
        }

        public boolean hasHeaderFieldElement() { 
          return this.headerField != null && !this.headerField.isEmpty();
        }

        public boolean hasHeaderField() { 
          return this.headerField != null && !this.headerField.isEmpty();
        }

        /**
         * @param value {@link #headerField} (Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.). This is the underlying object with id, value and extensions. The accessor "getHeaderField" gives direct access to the value
         */
        public TestScriptVariableComponent setHeaderFieldElement(StringType value) { 
          this.headerField = value;
          return this;
        }

        /**
         * @return Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.
         */
        public String getHeaderField() { 
          return this.headerField == null ? null : this.headerField.getValue();
        }

        /**
         * @param value Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.
         */
        public TestScriptVariableComponent setHeaderField(String value) { 
          if (Utilities.noString(value))
            this.headerField = null;
          else {
            if (this.headerField == null)
              this.headerField = new StringType();
            this.headerField.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #hint} (Displayable text string with hint help information to the user when entering a default value.). This is the underlying object with id, value and extensions. The accessor "getHint" gives direct access to the value
         */
        public StringType getHintElement() { 
          if (this.hint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.hint");
            else if (Configuration.doAutoCreate())
              this.hint = new StringType(); // bb
          return this.hint;
        }

        public boolean hasHintElement() { 
          return this.hint != null && !this.hint.isEmpty();
        }

        public boolean hasHint() { 
          return this.hint != null && !this.hint.isEmpty();
        }

        /**
         * @param value {@link #hint} (Displayable text string with hint help information to the user when entering a default value.). This is the underlying object with id, value and extensions. The accessor "getHint" gives direct access to the value
         */
        public TestScriptVariableComponent setHintElement(StringType value) { 
          this.hint = value;
          return this;
        }

        /**
         * @return Displayable text string with hint help information to the user when entering a default value.
         */
        public String getHint() { 
          return this.hint == null ? null : this.hint.getValue();
        }

        /**
         * @param value Displayable text string with hint help information to the user when entering a default value.
         */
        public TestScriptVariableComponent setHint(String value) { 
          if (Utilities.noString(value))
            this.hint = null;
          else {
            if (this.hint == null)
              this.hint = new StringType();
            this.hint.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #path} (XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.path");
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
         * @param value {@link #path} (XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public TestScriptVariableComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.
         */
        public TestScriptVariableComponent setPath(String value) { 
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
         * @return {@link #sourceId} (Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public IdType getSourceIdElement() { 
          if (this.sourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptVariableComponent.sourceId");
            else if (Configuration.doAutoCreate())
              this.sourceId = new IdType(); // bb
          return this.sourceId;
        }

        public boolean hasSourceIdElement() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        public boolean hasSourceId() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        /**
         * @param value {@link #sourceId} (Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public TestScriptVariableComponent setSourceIdElement(IdType value) { 
          this.sourceId = value;
          return this;
        }

        /**
         * @return Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.
         */
        public String getSourceId() { 
          return this.sourceId == null ? null : this.sourceId.getValue();
        }

        /**
         * @param value Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.
         */
        public TestScriptVariableComponent setSourceId(String value) { 
          if (Utilities.noString(value))
            this.sourceId = null;
          else {
            if (this.sourceId == null)
              this.sourceId = new IdType();
            this.sourceId.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Descriptive name for this variable.", 0, 1, name));
          children.add(new Property("defaultValue", "string", "A default, hard-coded, or user-defined value for this variable.", 0, 1, defaultValue));
          children.add(new Property("description", "string", "A free text natural language description of the variable and its purpose.", 0, 1, description));
          children.add(new Property("expression", "string", "The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.", 0, 1, expression));
          children.add(new Property("headerField", "string", "Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.", 0, 1, headerField));
          children.add(new Property("hint", "string", "Displayable text string with hint help information to the user when entering a default value.", 0, 1, hint));
          children.add(new Property("path", "string", "XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.", 0, 1, path));
          children.add(new Property("sourceId", "id", "Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.", 0, 1, sourceId));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Descriptive name for this variable.", 0, 1, name);
          case -659125328: /*defaultValue*/  return new Property("defaultValue", "string", "A default, hard-coded, or user-defined value for this variable.", 0, 1, defaultValue);
          case -1724546052: /*description*/  return new Property("description", "string", "A free text natural language description of the variable and its purpose.", 0, 1, description);
          case -1795452264: /*expression*/  return new Property("expression", "string", "The FHIRPath expression to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.", 0, 1, expression);
          case 1160732269: /*headerField*/  return new Property("headerField", "string", "Will be used to grab the HTTP header field value from the headers that sourceId is pointing to.", 0, 1, headerField);
          case 3202695: /*hint*/  return new Property("hint", "string", "Displayable text string with hint help information to the user when entering a default value.", 0, 1, hint);
          case 3433509: /*path*/  return new Property("path", "string", "XPath or JSONPath to evaluate against the fixture body.  When variables are defined, only one of either expression, headerField or path must be specified.", 0, 1, path);
          case 1746327190: /*sourceId*/  return new Property("sourceId", "id", "Fixture to evaluate the XPath/JSONPath expression or the headerField  against within this variable.", 0, 1, sourceId);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -659125328: /*defaultValue*/ return this.defaultValue == null ? new Base[0] : new Base[] {this.defaultValue}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // StringType
        case 1160732269: /*headerField*/ return this.headerField == null ? new Base[0] : new Base[] {this.headerField}; // StringType
        case 3202695: /*hint*/ return this.hint == null ? new Base[0] : new Base[] {this.hint}; // StringType
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case 1746327190: /*sourceId*/ return this.sourceId == null ? new Base[0] : new Base[] {this.sourceId}; // IdType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -659125328: // defaultValue
          this.defaultValue = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToString(value); // StringType
          return value;
        case 1160732269: // headerField
          this.headerField = TypeConvertor.castToString(value); // StringType
          return value;
        case 3202695: // hint
          this.hint = TypeConvertor.castToString(value); // StringType
          return value;
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case 1746327190: // sourceId
          this.sourceId = TypeConvertor.castToId(value); // IdType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("defaultValue")) {
          this.defaultValue = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("headerField")) {
          this.headerField = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("hint")) {
          this.hint = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("sourceId")) {
          this.sourceId = TypeConvertor.castToId(value); // IdType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -659125328:  return getDefaultValueElement();
        case -1724546052:  return getDescriptionElement();
        case -1795452264:  return getExpressionElement();
        case 1160732269:  return getHeaderFieldElement();
        case 3202695:  return getHintElement();
        case 3433509:  return getPathElement();
        case 1746327190:  return getSourceIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -659125328: /*defaultValue*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1795452264: /*expression*/ return new String[] {"string"};
        case 1160732269: /*headerField*/ return new String[] {"string"};
        case 3202695: /*hint*/ return new String[] {"string"};
        case 3433509: /*path*/ return new String[] {"string"};
        case 1746327190: /*sourceId*/ return new String[] {"id"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.name");
        }
        else if (name.equals("defaultValue")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.defaultValue");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.description");
        }
        else if (name.equals("expression")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.expression");
        }
        else if (name.equals("headerField")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.headerField");
        }
        else if (name.equals("hint")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.hint");
        }
        else if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.path");
        }
        else if (name.equals("sourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.variable.sourceId");
        }
        else
          return super.addChild(name);
      }

      public TestScriptVariableComponent copy() {
        TestScriptVariableComponent dst = new TestScriptVariableComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptVariableComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.defaultValue = defaultValue == null ? null : defaultValue.copy();
        dst.description = description == null ? null : description.copy();
        dst.expression = expression == null ? null : expression.copy();
        dst.headerField = headerField == null ? null : headerField.copy();
        dst.hint = hint == null ? null : hint.copy();
        dst.path = path == null ? null : path.copy();
        dst.sourceId = sourceId == null ? null : sourceId.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptVariableComponent))
          return false;
        TestScriptVariableComponent o = (TestScriptVariableComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(defaultValue, o.defaultValue, true) && compareDeep(description, o.description, true)
           && compareDeep(expression, o.expression, true) && compareDeep(headerField, o.headerField, true)
           && compareDeep(hint, o.hint, true) && compareDeep(path, o.path, true) && compareDeep(sourceId, o.sourceId, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptVariableComponent))
          return false;
        TestScriptVariableComponent o = (TestScriptVariableComponent) other_;
        return compareValues(name, o.name, true) && compareValues(defaultValue, o.defaultValue, true) && compareValues(description, o.description, true)
           && compareValues(expression, o.expression, true) && compareValues(headerField, o.headerField, true)
           && compareValues(hint, o.hint, true) && compareValues(path, o.path, true) && compareValues(sourceId, o.sourceId, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, defaultValue, description
          , expression, headerField, hint, path, sourceId);
      }

  public String fhirType() {
    return "TestScript.variable";

  }

  }

    @Block()
    public static class TestScriptSetupComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Action would contain either an operation or an assertion.
         */
        @Child(name = "action", type = {}, order=1, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A setup operation or assert to perform", formalDefinition="Action would contain either an operation or an assertion." )
        protected List<SetupActionComponent> action;

        private static final long serialVersionUID = -123374486L;

    /**
     * Constructor
     */
      public TestScriptSetupComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptSetupComponent(SetupActionComponent action) {
        super();
        this.addAction(action);
      }

        /**
         * @return {@link #action} (Action would contain either an operation or an assertion.)
         */
        public List<SetupActionComponent> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<SetupActionComponent>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptSetupComponent setAction(List<SetupActionComponent> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (SetupActionComponent item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SetupActionComponent addAction() { //3
          SetupActionComponent t = new SetupActionComponent();
          if (this.action == null)
            this.action = new ArrayList<SetupActionComponent>();
          this.action.add(t);
          return t;
        }

        public TestScriptSetupComponent addAction(SetupActionComponent t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<SetupActionComponent>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public SetupActionComponent getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("action", "", "Action would contain either an operation or an assertion.", 0, java.lang.Integer.MAX_VALUE, action));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1422950858: /*action*/  return new Property("action", "", "Action would contain either an operation or an assertion.", 0, java.lang.Integer.MAX_VALUE, action);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // SetupActionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1422950858: // action
          this.getAction().add((SetupActionComponent) value); // SetupActionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("action")) {
          this.getAction().add((SetupActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1422950858:  return addAction(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1422950858: /*action*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("action")) {
          return addAction();
        }
        else
          return super.addChild(name);
      }

      public TestScriptSetupComponent copy() {
        TestScriptSetupComponent dst = new TestScriptSetupComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptSetupComponent dst) {
        super.copyValues(dst);
        if (action != null) {
          dst.action = new ArrayList<SetupActionComponent>();
          for (SetupActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptSetupComponent))
          return false;
        TestScriptSetupComponent o = (TestScriptSetupComponent) other_;
        return compareDeep(action, o.action, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptSetupComponent))
          return false;
        TestScriptSetupComponent o = (TestScriptSetupComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(action);
      }

  public String fhirType() {
    return "TestScript.setup";

  }

  }

    @Block()
    public static class SetupActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The operation to perform.
         */
        @Child(name = "operation", type = {}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The setup operation to perform", formalDefinition="The operation to perform." )
        protected SetupActionOperationComponent operation;

        /**
         * Evaluates the results of previous operations to determine if the server under test behaves appropriately.
         */
        @Child(name = "assert", type = {}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The assertion to perform", formalDefinition="Evaluates the results of previous operations to determine if the server under test behaves appropriately." )
        protected SetupActionAssertComponent assert_;

        private static final long serialVersionUID = -252088305L;

    /**
     * Constructor
     */
      public SetupActionComponent() {
        super();
      }

        /**
         * @return {@link #operation} (The operation to perform.)
         */
        public SetupActionOperationComponent getOperation() { 
          if (this.operation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionComponent.operation");
            else if (Configuration.doAutoCreate())
              this.operation = new SetupActionOperationComponent(); // cc
          return this.operation;
        }

        public boolean hasOperation() { 
          return this.operation != null && !this.operation.isEmpty();
        }

        /**
         * @param value {@link #operation} (The operation to perform.)
         */
        public SetupActionComponent setOperation(SetupActionOperationComponent value) { 
          this.operation = value;
          return this;
        }

        /**
         * @return {@link #assert_} (Evaluates the results of previous operations to determine if the server under test behaves appropriately.)
         */
        public SetupActionAssertComponent getAssert() { 
          if (this.assert_ == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionComponent.assert_");
            else if (Configuration.doAutoCreate())
              this.assert_ = new SetupActionAssertComponent(); // cc
          return this.assert_;
        }

        public boolean hasAssert() { 
          return this.assert_ != null && !this.assert_.isEmpty();
        }

        /**
         * @param value {@link #assert_} (Evaluates the results of previous operations to determine if the server under test behaves appropriately.)
         */
        public SetupActionComponent setAssert(SetupActionAssertComponent value) { 
          this.assert_ = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("operation", "", "The operation to perform.", 0, 1, operation));
          children.add(new Property("assert", "", "Evaluates the results of previous operations to determine if the server under test behaves appropriately.", 0, 1, assert_));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1662702951: /*operation*/  return new Property("operation", "", "The operation to perform.", 0, 1, operation);
          case -1408208058: /*assert*/  return new Property("assert", "", "Evaluates the results of previous operations to determine if the server under test behaves appropriately.", 0, 1, assert_);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : new Base[] {this.operation}; // SetupActionOperationComponent
        case -1408208058: /*assert*/ return this.assert_ == null ? new Base[0] : new Base[] {this.assert_}; // SetupActionAssertComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1662702951: // operation
          this.operation = (SetupActionOperationComponent) value; // SetupActionOperationComponent
          return value;
        case -1408208058: // assert
          this.assert_ = (SetupActionAssertComponent) value; // SetupActionAssertComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("operation")) {
          this.operation = (SetupActionOperationComponent) value; // SetupActionOperationComponent
        } else if (name.equals("assert")) {
          this.assert_ = (SetupActionAssertComponent) value; // SetupActionAssertComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1662702951:  return getOperation();
        case -1408208058:  return getAssert();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1662702951: /*operation*/ return new String[] {};
        case -1408208058: /*assert*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("operation")) {
          this.operation = new SetupActionOperationComponent();
          return this.operation;
        }
        else if (name.equals("assert")) {
          this.assert_ = new SetupActionAssertComponent();
          return this.assert_;
        }
        else
          return super.addChild(name);
      }

      public SetupActionComponent copy() {
        SetupActionComponent dst = new SetupActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SetupActionComponent dst) {
        super.copyValues(dst);
        dst.operation = operation == null ? null : operation.copy();
        dst.assert_ = assert_ == null ? null : assert_.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SetupActionComponent))
          return false;
        SetupActionComponent o = (SetupActionComponent) other_;
        return compareDeep(operation, o.operation, true) && compareDeep(assert_, o.assert_, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SetupActionComponent))
          return false;
        SetupActionComponent o = (SetupActionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(operation, assert_);
      }

  public String fhirType() {
    return "TestScript.setup.action";

  }

  }

    @Block()
    public static class SetupActionOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Server interaction or operation type.
         */
        @Child(name = "type", type = {Coding.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The operation code type that will be executed", formalDefinition="Server interaction or operation type." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-operation-codes")
        protected Coding type;

        /**
         * The type of the resource.  See http://build.fhir.org/resourcelist.html.
         */
        @Child(name = "resource", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Resource type", formalDefinition="The type of the resource.  See http://build.fhir.org/resourcelist.html." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/defined-types")
        protected Enumeration<FHIRDefinedType> resource;

        /**
         * The label would be used for tracking/logging purposes by test engines.
         */
        @Child(name = "label", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Tracking/logging operation label", formalDefinition="The label would be used for tracking/logging purposes by test engines." )
        protected StringType label;

        /**
         * The description would be used by test engines for tracking and reporting purposes.
         */
        @Child(name = "description", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Tracking/reporting operation description", formalDefinition="The description would be used by test engines for tracking and reporting purposes." )
        protected StringType description;

        /**
         * The mime-type to use for RESTful operation in the 'Accept' header.
         */
        @Child(name = "accept", type = {CodeType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Mime type to accept in the payload of the response, with charset etc.", formalDefinition="The mime-type to use for RESTful operation in the 'Accept' header." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected CodeType accept;

        /**
         * The mime-type to use for RESTful operation in the 'Content-Type' header.
         */
        @Child(name = "contentType", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Mime type of the request payload contents, with charset etc.", formalDefinition="The mime-type to use for RESTful operation in the 'Content-Type' header." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected CodeType contentType;

        /**
         * The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.
         */
        @Child(name = "destination", type = {IntegerType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Server responding to the request", formalDefinition="The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section." )
        protected IntegerType destination;

        /**
         * Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.
         */
        @Child(name = "encodeRequestUrl", type = {BooleanType.class}, order=8, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not to send the request url in encoded format", formalDefinition="Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths." )
        protected BooleanType encodeRequestUrl;

        /**
         * The HTTP method the test engine MUST use for this operation regardless of any other operation details.
         */
        @Child(name = "method", type = {CodeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="delete | get | options | patch | post | put | head", formalDefinition="The HTTP method the test engine MUST use for this operation regardless of any other operation details." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/http-operations")
        protected Enumeration<TestScriptRequestMethodCode> method;

        /**
         * The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.
         */
        @Child(name = "origin", type = {IntegerType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Server initiating the request", formalDefinition="The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section." )
        protected IntegerType origin;

        /**
         * Path plus parameters after [type].  Used to set parts of the request URL explicitly.
         */
        @Child(name = "params", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Explicitly defined path parameters", formalDefinition="Path plus parameters after [type].  Used to set parts of the request URL explicitly." )
        protected StringType params;

        /**
         * Header elements would be used to set HTTP headers.
         */
        @Child(name = "requestHeader", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Each operation can have one or more header elements", formalDefinition="Header elements would be used to set HTTP headers." )
        protected List<SetupActionOperationRequestHeaderComponent> requestHeader;

        /**
         * The fixture id (maybe new) to map to the request.
         */
        @Child(name = "requestId", type = {IdType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of mapped request", formalDefinition="The fixture id (maybe new) to map to the request." )
        protected IdType requestId;

        /**
         * The fixture id (maybe new) to map to the response.
         */
        @Child(name = "responseId", type = {IdType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of mapped response", formalDefinition="The fixture id (maybe new) to map to the response." )
        protected IdType responseId;

        /**
         * The id of the fixture used as the body of a PUT or POST request.
         */
        @Child(name = "sourceId", type = {IdType.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of body for PUT and POST requests", formalDefinition="The id of the fixture used as the body of a PUT or POST request." )
        protected IdType sourceId;

        /**
         * Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.
         */
        @Child(name = "targetId", type = {IdType.class}, order=16, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Id of fixture used for extracting the [id],  [type], and [vid] for GET requests", formalDefinition="Id of fixture used for extracting the [id],  [type], and [vid] for GET requests." )
        protected IdType targetId;

        /**
         * Complete request URL.
         */
        @Child(name = "url", type = {StringType.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Request URL", formalDefinition="Complete request URL." )
        protected StringType url;

        private static final long serialVersionUID = -1301448722L;

    /**
     * Constructor
     */
      public SetupActionOperationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SetupActionOperationComponent(boolean encodeRequestUrl) {
        super();
        this.setEncodeRequestUrl(encodeRequestUrl);
      }

        /**
         * @return {@link #type} (Server interaction or operation type.)
         */
        public Coding getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Coding(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Server interaction or operation type.)
         */
        public SetupActionOperationComponent setType(Coding value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #resource} (The type of the resource.  See http://build.fhir.org/resourcelist.html.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public Enumeration<FHIRDefinedType> getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new Enumeration<FHIRDefinedType>(new FHIRDefinedTypeEnumFactory()); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (The type of the resource.  See http://build.fhir.org/resourcelist.html.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SetupActionOperationComponent setResourceElement(Enumeration<FHIRDefinedType> value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return The type of the resource.  See http://build.fhir.org/resourcelist.html.
         */
        public FHIRDefinedType getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value The type of the resource.  See http://build.fhir.org/resourcelist.html.
         */
        public SetupActionOperationComponent setResource(FHIRDefinedType value) { 
          if (value == null)
            this.resource = null;
          else {
            if (this.resource == null)
              this.resource = new Enumeration<FHIRDefinedType>(new FHIRDefinedTypeEnumFactory());
            this.resource.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #label} (The label would be used for tracking/logging purposes by test engines.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.label");
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
         * @param value {@link #label} (The label would be used for tracking/logging purposes by test engines.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public SetupActionOperationComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return The label would be used for tracking/logging purposes by test engines.
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value The label would be used for tracking/logging purposes by test engines.
         */
        public SetupActionOperationComponent setLabel(String value) { 
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
         * @return {@link #description} (The description would be used by test engines for tracking and reporting purposes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.description");
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
         * @param value {@link #description} (The description would be used by test engines for tracking and reporting purposes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SetupActionOperationComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The description would be used by test engines for tracking and reporting purposes.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The description would be used by test engines for tracking and reporting purposes.
         */
        public SetupActionOperationComponent setDescription(String value) { 
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
         * @return {@link #accept} (The mime-type to use for RESTful operation in the 'Accept' header.). This is the underlying object with id, value and extensions. The accessor "getAccept" gives direct access to the value
         */
        public CodeType getAcceptElement() { 
          if (this.accept == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.accept");
            else if (Configuration.doAutoCreate())
              this.accept = new CodeType(); // bb
          return this.accept;
        }

        public boolean hasAcceptElement() { 
          return this.accept != null && !this.accept.isEmpty();
        }

        public boolean hasAccept() { 
          return this.accept != null && !this.accept.isEmpty();
        }

        /**
         * @param value {@link #accept} (The mime-type to use for RESTful operation in the 'Accept' header.). This is the underlying object with id, value and extensions. The accessor "getAccept" gives direct access to the value
         */
        public SetupActionOperationComponent setAcceptElement(CodeType value) { 
          this.accept = value;
          return this;
        }

        /**
         * @return The mime-type to use for RESTful operation in the 'Accept' header.
         */
        public String getAccept() { 
          return this.accept == null ? null : this.accept.getValue();
        }

        /**
         * @param value The mime-type to use for RESTful operation in the 'Accept' header.
         */
        public SetupActionOperationComponent setAccept(String value) { 
          if (Utilities.noString(value))
            this.accept = null;
          else {
            if (this.accept == null)
              this.accept = new CodeType();
            this.accept.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #contentType} (The mime-type to use for RESTful operation in the 'Content-Type' header.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
         */
        public CodeType getContentTypeElement() { 
          if (this.contentType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.contentType");
            else if (Configuration.doAutoCreate())
              this.contentType = new CodeType(); // bb
          return this.contentType;
        }

        public boolean hasContentTypeElement() { 
          return this.contentType != null && !this.contentType.isEmpty();
        }

        public boolean hasContentType() { 
          return this.contentType != null && !this.contentType.isEmpty();
        }

        /**
         * @param value {@link #contentType} (The mime-type to use for RESTful operation in the 'Content-Type' header.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
         */
        public SetupActionOperationComponent setContentTypeElement(CodeType value) { 
          this.contentType = value;
          return this;
        }

        /**
         * @return The mime-type to use for RESTful operation in the 'Content-Type' header.
         */
        public String getContentType() { 
          return this.contentType == null ? null : this.contentType.getValue();
        }

        /**
         * @param value The mime-type to use for RESTful operation in the 'Content-Type' header.
         */
        public SetupActionOperationComponent setContentType(String value) { 
          if (Utilities.noString(value))
            this.contentType = null;
          else {
            if (this.contentType == null)
              this.contentType = new CodeType();
            this.contentType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #destination} (The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.). This is the underlying object with id, value and extensions. The accessor "getDestination" gives direct access to the value
         */
        public IntegerType getDestinationElement() { 
          if (this.destination == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.destination");
            else if (Configuration.doAutoCreate())
              this.destination = new IntegerType(); // bb
          return this.destination;
        }

        public boolean hasDestinationElement() { 
          return this.destination != null && !this.destination.isEmpty();
        }

        public boolean hasDestination() { 
          return this.destination != null && !this.destination.isEmpty();
        }

        /**
         * @param value {@link #destination} (The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.). This is the underlying object with id, value and extensions. The accessor "getDestination" gives direct access to the value
         */
        public SetupActionOperationComponent setDestinationElement(IntegerType value) { 
          this.destination = value;
          return this;
        }

        /**
         * @return The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.
         */
        public int getDestination() { 
          return this.destination == null || this.destination.isEmpty() ? 0 : this.destination.getValue();
        }

        /**
         * @param value The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.
         */
        public SetupActionOperationComponent setDestination(int value) { 
            if (this.destination == null)
              this.destination = new IntegerType();
            this.destination.setValue(value);
          return this;
        }

        /**
         * @return {@link #encodeRequestUrl} (Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.). This is the underlying object with id, value and extensions. The accessor "getEncodeRequestUrl" gives direct access to the value
         */
        public BooleanType getEncodeRequestUrlElement() { 
          if (this.encodeRequestUrl == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.encodeRequestUrl");
            else if (Configuration.doAutoCreate())
              this.encodeRequestUrl = new BooleanType(); // bb
          return this.encodeRequestUrl;
        }

        public boolean hasEncodeRequestUrlElement() { 
          return this.encodeRequestUrl != null && !this.encodeRequestUrl.isEmpty();
        }

        public boolean hasEncodeRequestUrl() { 
          return this.encodeRequestUrl != null && !this.encodeRequestUrl.isEmpty();
        }

        /**
         * @param value {@link #encodeRequestUrl} (Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.). This is the underlying object with id, value and extensions. The accessor "getEncodeRequestUrl" gives direct access to the value
         */
        public SetupActionOperationComponent setEncodeRequestUrlElement(BooleanType value) { 
          this.encodeRequestUrl = value;
          return this;
        }

        /**
         * @return Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.
         */
        public boolean getEncodeRequestUrl() { 
          return this.encodeRequestUrl == null || this.encodeRequestUrl.isEmpty() ? false : this.encodeRequestUrl.getValue();
        }

        /**
         * @param value Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.
         */
        public SetupActionOperationComponent setEncodeRequestUrl(boolean value) { 
            if (this.encodeRequestUrl == null)
              this.encodeRequestUrl = new BooleanType();
            this.encodeRequestUrl.setValue(value);
          return this;
        }

        /**
         * @return {@link #method} (The HTTP method the test engine MUST use for this operation regardless of any other operation details.). This is the underlying object with id, value and extensions. The accessor "getMethod" gives direct access to the value
         */
        public Enumeration<TestScriptRequestMethodCode> getMethodElement() { 
          if (this.method == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.method");
            else if (Configuration.doAutoCreate())
              this.method = new Enumeration<TestScriptRequestMethodCode>(new TestScriptRequestMethodCodeEnumFactory()); // bb
          return this.method;
        }

        public boolean hasMethodElement() { 
          return this.method != null && !this.method.isEmpty();
        }

        public boolean hasMethod() { 
          return this.method != null && !this.method.isEmpty();
        }

        /**
         * @param value {@link #method} (The HTTP method the test engine MUST use for this operation regardless of any other operation details.). This is the underlying object with id, value and extensions. The accessor "getMethod" gives direct access to the value
         */
        public SetupActionOperationComponent setMethodElement(Enumeration<TestScriptRequestMethodCode> value) { 
          this.method = value;
          return this;
        }

        /**
         * @return The HTTP method the test engine MUST use for this operation regardless of any other operation details.
         */
        public TestScriptRequestMethodCode getMethod() { 
          return this.method == null ? null : this.method.getValue();
        }

        /**
         * @param value The HTTP method the test engine MUST use for this operation regardless of any other operation details.
         */
        public SetupActionOperationComponent setMethod(TestScriptRequestMethodCode value) { 
          if (value == null)
            this.method = null;
          else {
            if (this.method == null)
              this.method = new Enumeration<TestScriptRequestMethodCode>(new TestScriptRequestMethodCodeEnumFactory());
            this.method.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #origin} (The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.). This is the underlying object with id, value and extensions. The accessor "getOrigin" gives direct access to the value
         */
        public IntegerType getOriginElement() { 
          if (this.origin == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.origin");
            else if (Configuration.doAutoCreate())
              this.origin = new IntegerType(); // bb
          return this.origin;
        }

        public boolean hasOriginElement() { 
          return this.origin != null && !this.origin.isEmpty();
        }

        public boolean hasOrigin() { 
          return this.origin != null && !this.origin.isEmpty();
        }

        /**
         * @param value {@link #origin} (The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.). This is the underlying object with id, value and extensions. The accessor "getOrigin" gives direct access to the value
         */
        public SetupActionOperationComponent setOriginElement(IntegerType value) { 
          this.origin = value;
          return this;
        }

        /**
         * @return The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.
         */
        public int getOrigin() { 
          return this.origin == null || this.origin.isEmpty() ? 0 : this.origin.getValue();
        }

        /**
         * @param value The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.
         */
        public SetupActionOperationComponent setOrigin(int value) { 
            if (this.origin == null)
              this.origin = new IntegerType();
            this.origin.setValue(value);
          return this;
        }

        /**
         * @return {@link #params} (Path plus parameters after [type].  Used to set parts of the request URL explicitly.). This is the underlying object with id, value and extensions. The accessor "getParams" gives direct access to the value
         */
        public StringType getParamsElement() { 
          if (this.params == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.params");
            else if (Configuration.doAutoCreate())
              this.params = new StringType(); // bb
          return this.params;
        }

        public boolean hasParamsElement() { 
          return this.params != null && !this.params.isEmpty();
        }

        public boolean hasParams() { 
          return this.params != null && !this.params.isEmpty();
        }

        /**
         * @param value {@link #params} (Path plus parameters after [type].  Used to set parts of the request URL explicitly.). This is the underlying object with id, value and extensions. The accessor "getParams" gives direct access to the value
         */
        public SetupActionOperationComponent setParamsElement(StringType value) { 
          this.params = value;
          return this;
        }

        /**
         * @return Path plus parameters after [type].  Used to set parts of the request URL explicitly.
         */
        public String getParams() { 
          return this.params == null ? null : this.params.getValue();
        }

        /**
         * @param value Path plus parameters after [type].  Used to set parts of the request URL explicitly.
         */
        public SetupActionOperationComponent setParams(String value) { 
          if (Utilities.noString(value))
            this.params = null;
          else {
            if (this.params == null)
              this.params = new StringType();
            this.params.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #requestHeader} (Header elements would be used to set HTTP headers.)
         */
        public List<SetupActionOperationRequestHeaderComponent> getRequestHeader() { 
          if (this.requestHeader == null)
            this.requestHeader = new ArrayList<SetupActionOperationRequestHeaderComponent>();
          return this.requestHeader;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SetupActionOperationComponent setRequestHeader(List<SetupActionOperationRequestHeaderComponent> theRequestHeader) { 
          this.requestHeader = theRequestHeader;
          return this;
        }

        public boolean hasRequestHeader() { 
          if (this.requestHeader == null)
            return false;
          for (SetupActionOperationRequestHeaderComponent item : this.requestHeader)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SetupActionOperationRequestHeaderComponent addRequestHeader() { //3
          SetupActionOperationRequestHeaderComponent t = new SetupActionOperationRequestHeaderComponent();
          if (this.requestHeader == null)
            this.requestHeader = new ArrayList<SetupActionOperationRequestHeaderComponent>();
          this.requestHeader.add(t);
          return t;
        }

        public SetupActionOperationComponent addRequestHeader(SetupActionOperationRequestHeaderComponent t) { //3
          if (t == null)
            return this;
          if (this.requestHeader == null)
            this.requestHeader = new ArrayList<SetupActionOperationRequestHeaderComponent>();
          this.requestHeader.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #requestHeader}, creating it if it does not already exist {3}
         */
        public SetupActionOperationRequestHeaderComponent getRequestHeaderFirstRep() { 
          if (getRequestHeader().isEmpty()) {
            addRequestHeader();
          }
          return getRequestHeader().get(0);
        }

        /**
         * @return {@link #requestId} (The fixture id (maybe new) to map to the request.). This is the underlying object with id, value and extensions. The accessor "getRequestId" gives direct access to the value
         */
        public IdType getRequestIdElement() { 
          if (this.requestId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.requestId");
            else if (Configuration.doAutoCreate())
              this.requestId = new IdType(); // bb
          return this.requestId;
        }

        public boolean hasRequestIdElement() { 
          return this.requestId != null && !this.requestId.isEmpty();
        }

        public boolean hasRequestId() { 
          return this.requestId != null && !this.requestId.isEmpty();
        }

        /**
         * @param value {@link #requestId} (The fixture id (maybe new) to map to the request.). This is the underlying object with id, value and extensions. The accessor "getRequestId" gives direct access to the value
         */
        public SetupActionOperationComponent setRequestIdElement(IdType value) { 
          this.requestId = value;
          return this;
        }

        /**
         * @return The fixture id (maybe new) to map to the request.
         */
        public String getRequestId() { 
          return this.requestId == null ? null : this.requestId.getValue();
        }

        /**
         * @param value The fixture id (maybe new) to map to the request.
         */
        public SetupActionOperationComponent setRequestId(String value) { 
          if (Utilities.noString(value))
            this.requestId = null;
          else {
            if (this.requestId == null)
              this.requestId = new IdType();
            this.requestId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #responseId} (The fixture id (maybe new) to map to the response.). This is the underlying object with id, value and extensions. The accessor "getResponseId" gives direct access to the value
         */
        public IdType getResponseIdElement() { 
          if (this.responseId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.responseId");
            else if (Configuration.doAutoCreate())
              this.responseId = new IdType(); // bb
          return this.responseId;
        }

        public boolean hasResponseIdElement() { 
          return this.responseId != null && !this.responseId.isEmpty();
        }

        public boolean hasResponseId() { 
          return this.responseId != null && !this.responseId.isEmpty();
        }

        /**
         * @param value {@link #responseId} (The fixture id (maybe new) to map to the response.). This is the underlying object with id, value and extensions. The accessor "getResponseId" gives direct access to the value
         */
        public SetupActionOperationComponent setResponseIdElement(IdType value) { 
          this.responseId = value;
          return this;
        }

        /**
         * @return The fixture id (maybe new) to map to the response.
         */
        public String getResponseId() { 
          return this.responseId == null ? null : this.responseId.getValue();
        }

        /**
         * @param value The fixture id (maybe new) to map to the response.
         */
        public SetupActionOperationComponent setResponseId(String value) { 
          if (Utilities.noString(value))
            this.responseId = null;
          else {
            if (this.responseId == null)
              this.responseId = new IdType();
            this.responseId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #sourceId} (The id of the fixture used as the body of a PUT or POST request.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public IdType getSourceIdElement() { 
          if (this.sourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.sourceId");
            else if (Configuration.doAutoCreate())
              this.sourceId = new IdType(); // bb
          return this.sourceId;
        }

        public boolean hasSourceIdElement() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        public boolean hasSourceId() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        /**
         * @param value {@link #sourceId} (The id of the fixture used as the body of a PUT or POST request.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public SetupActionOperationComponent setSourceIdElement(IdType value) { 
          this.sourceId = value;
          return this;
        }

        /**
         * @return The id of the fixture used as the body of a PUT or POST request.
         */
        public String getSourceId() { 
          return this.sourceId == null ? null : this.sourceId.getValue();
        }

        /**
         * @param value The id of the fixture used as the body of a PUT or POST request.
         */
        public SetupActionOperationComponent setSourceId(String value) { 
          if (Utilities.noString(value))
            this.sourceId = null;
          else {
            if (this.sourceId == null)
              this.sourceId = new IdType();
            this.sourceId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #targetId} (Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.). This is the underlying object with id, value and extensions. The accessor "getTargetId" gives direct access to the value
         */
        public IdType getTargetIdElement() { 
          if (this.targetId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.targetId");
            else if (Configuration.doAutoCreate())
              this.targetId = new IdType(); // bb
          return this.targetId;
        }

        public boolean hasTargetIdElement() { 
          return this.targetId != null && !this.targetId.isEmpty();
        }

        public boolean hasTargetId() { 
          return this.targetId != null && !this.targetId.isEmpty();
        }

        /**
         * @param value {@link #targetId} (Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.). This is the underlying object with id, value and extensions. The accessor "getTargetId" gives direct access to the value
         */
        public SetupActionOperationComponent setTargetIdElement(IdType value) { 
          this.targetId = value;
          return this;
        }

        /**
         * @return Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.
         */
        public String getTargetId() { 
          return this.targetId == null ? null : this.targetId.getValue();
        }

        /**
         * @param value Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.
         */
        public SetupActionOperationComponent setTargetId(String value) { 
          if (Utilities.noString(value))
            this.targetId = null;
          else {
            if (this.targetId == null)
              this.targetId = new IdType();
            this.targetId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #url} (Complete request URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public StringType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new StringType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (Complete request URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public SetupActionOperationComponent setUrlElement(StringType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return Complete request URL.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value Complete request URL.
         */
        public SetupActionOperationComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new StringType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "Coding", "Server interaction or operation type.", 0, 1, type));
          children.add(new Property("resource", "code", "The type of the resource.  See http://build.fhir.org/resourcelist.html.", 0, 1, resource));
          children.add(new Property("label", "string", "The label would be used for tracking/logging purposes by test engines.", 0, 1, label));
          children.add(new Property("description", "string", "The description would be used by test engines for tracking and reporting purposes.", 0, 1, description));
          children.add(new Property("accept", "code", "The mime-type to use for RESTful operation in the 'Accept' header.", 0, 1, accept));
          children.add(new Property("contentType", "code", "The mime-type to use for RESTful operation in the 'Content-Type' header.", 0, 1, contentType));
          children.add(new Property("destination", "integer", "The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.", 0, 1, destination));
          children.add(new Property("encodeRequestUrl", "boolean", "Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.", 0, 1, encodeRequestUrl));
          children.add(new Property("method", "code", "The HTTP method the test engine MUST use for this operation regardless of any other operation details.", 0, 1, method));
          children.add(new Property("origin", "integer", "The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.", 0, 1, origin));
          children.add(new Property("params", "string", "Path plus parameters after [type].  Used to set parts of the request URL explicitly.", 0, 1, params));
          children.add(new Property("requestHeader", "", "Header elements would be used to set HTTP headers.", 0, java.lang.Integer.MAX_VALUE, requestHeader));
          children.add(new Property("requestId", "id", "The fixture id (maybe new) to map to the request.", 0, 1, requestId));
          children.add(new Property("responseId", "id", "The fixture id (maybe new) to map to the response.", 0, 1, responseId));
          children.add(new Property("sourceId", "id", "The id of the fixture used as the body of a PUT or POST request.", 0, 1, sourceId));
          children.add(new Property("targetId", "id", "Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.", 0, 1, targetId));
          children.add(new Property("url", "string", "Complete request URL.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "Coding", "Server interaction or operation type.", 0, 1, type);
          case -341064690: /*resource*/  return new Property("resource", "code", "The type of the resource.  See http://build.fhir.org/resourcelist.html.", 0, 1, resource);
          case 102727412: /*label*/  return new Property("label", "string", "The label would be used for tracking/logging purposes by test engines.", 0, 1, label);
          case -1724546052: /*description*/  return new Property("description", "string", "The description would be used by test engines for tracking and reporting purposes.", 0, 1, description);
          case -1423461112: /*accept*/  return new Property("accept", "code", "The mime-type to use for RESTful operation in the 'Accept' header.", 0, 1, accept);
          case -389131437: /*contentType*/  return new Property("contentType", "code", "The mime-type to use for RESTful operation in the 'Content-Type' header.", 0, 1, contentType);
          case -1429847026: /*destination*/  return new Property("destination", "integer", "The server where the request message is destined for.  Must be one of the server numbers listed in TestScript.destination section.", 0, 1, destination);
          case -1760554218: /*encodeRequestUrl*/  return new Property("encodeRequestUrl", "boolean", "Whether or not to implicitly send the request url in encoded format. The default is true to match the standard RESTful client behavior. Set to false when communicating with a server that does not support encoded url paths.", 0, 1, encodeRequestUrl);
          case -1077554975: /*method*/  return new Property("method", "code", "The HTTP method the test engine MUST use for this operation regardless of any other operation details.", 0, 1, method);
          case -1008619738: /*origin*/  return new Property("origin", "integer", "The server where the request message originates from.  Must be one of the server numbers listed in TestScript.origin section.", 0, 1, origin);
          case -995427962: /*params*/  return new Property("params", "string", "Path plus parameters after [type].  Used to set parts of the request URL explicitly.", 0, 1, params);
          case 1074158076: /*requestHeader*/  return new Property("requestHeader", "", "Header elements would be used to set HTTP headers.", 0, java.lang.Integer.MAX_VALUE, requestHeader);
          case 693933066: /*requestId*/  return new Property("requestId", "id", "The fixture id (maybe new) to map to the request.", 0, 1, requestId);
          case -633138884: /*responseId*/  return new Property("responseId", "id", "The fixture id (maybe new) to map to the response.", 0, 1, responseId);
          case 1746327190: /*sourceId*/  return new Property("sourceId", "id", "The id of the fixture used as the body of a PUT or POST request.", 0, 1, sourceId);
          case -441951604: /*targetId*/  return new Property("targetId", "id", "Id of fixture used for extracting the [id],  [type], and [vid] for GET requests.", 0, 1, targetId);
          case 116079: /*url*/  return new Property("url", "string", "Complete request URL.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Coding
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Enumeration<FHIRDefinedType>
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1423461112: /*accept*/ return this.accept == null ? new Base[0] : new Base[] {this.accept}; // CodeType
        case -389131437: /*contentType*/ return this.contentType == null ? new Base[0] : new Base[] {this.contentType}; // CodeType
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // IntegerType
        case -1760554218: /*encodeRequestUrl*/ return this.encodeRequestUrl == null ? new Base[0] : new Base[] {this.encodeRequestUrl}; // BooleanType
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // Enumeration<TestScriptRequestMethodCode>
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : new Base[] {this.origin}; // IntegerType
        case -995427962: /*params*/ return this.params == null ? new Base[0] : new Base[] {this.params}; // StringType
        case 1074158076: /*requestHeader*/ return this.requestHeader == null ? new Base[0] : this.requestHeader.toArray(new Base[this.requestHeader.size()]); // SetupActionOperationRequestHeaderComponent
        case 693933066: /*requestId*/ return this.requestId == null ? new Base[0] : new Base[] {this.requestId}; // IdType
        case -633138884: /*responseId*/ return this.responseId == null ? new Base[0] : new Base[] {this.responseId}; // IdType
        case 1746327190: /*sourceId*/ return this.sourceId == null ? new Base[0] : new Base[] {this.sourceId}; // IdType
        case -441951604: /*targetId*/ return this.targetId == null ? new Base[0] : new Base[] {this.targetId}; // IdType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCoding(value); // Coding
          return value;
        case -341064690: // resource
          value = new FHIRDefinedTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resource = (Enumeration) value; // Enumeration<FHIRDefinedType>
          return value;
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1423461112: // accept
          this.accept = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -389131437: // contentType
          this.contentType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -1760554218: // encodeRequestUrl
          this.encodeRequestUrl = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1077554975: // method
          value = new TestScriptRequestMethodCodeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.method = (Enumeration) value; // Enumeration<TestScriptRequestMethodCode>
          return value;
        case -1008619738: // origin
          this.origin = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -995427962: // params
          this.params = TypeConvertor.castToString(value); // StringType
          return value;
        case 1074158076: // requestHeader
          this.getRequestHeader().add((SetupActionOperationRequestHeaderComponent) value); // SetupActionOperationRequestHeaderComponent
          return value;
        case 693933066: // requestId
          this.requestId = TypeConvertor.castToId(value); // IdType
          return value;
        case -633138884: // responseId
          this.responseId = TypeConvertor.castToId(value); // IdType
          return value;
        case 1746327190: // sourceId
          this.sourceId = TypeConvertor.castToId(value); // IdType
          return value;
        case -441951604: // targetId
          this.targetId = TypeConvertor.castToId(value); // IdType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("resource")) {
          value = new FHIRDefinedTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resource = (Enumeration) value; // Enumeration<FHIRDefinedType>
        } else if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("accept")) {
          this.accept = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("contentType")) {
          this.contentType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("encodeRequestUrl")) {
          this.encodeRequestUrl = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("method")) {
          value = new TestScriptRequestMethodCodeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.method = (Enumeration) value; // Enumeration<TestScriptRequestMethodCode>
        } else if (name.equals("origin")) {
          this.origin = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("params")) {
          this.params = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("requestHeader")) {
          this.getRequestHeader().add((SetupActionOperationRequestHeaderComponent) value);
        } else if (name.equals("requestId")) {
          this.requestId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("responseId")) {
          this.responseId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("sourceId")) {
          this.sourceId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("targetId")) {
          this.targetId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -341064690:  return getResourceElement();
        case 102727412:  return getLabelElement();
        case -1724546052:  return getDescriptionElement();
        case -1423461112:  return getAcceptElement();
        case -389131437:  return getContentTypeElement();
        case -1429847026:  return getDestinationElement();
        case -1760554218:  return getEncodeRequestUrlElement();
        case -1077554975:  return getMethodElement();
        case -1008619738:  return getOriginElement();
        case -995427962:  return getParamsElement();
        case 1074158076:  return addRequestHeader(); 
        case 693933066:  return getRequestIdElement();
        case -633138884:  return getResponseIdElement();
        case 1746327190:  return getSourceIdElement();
        case -441951604:  return getTargetIdElement();
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"Coding"};
        case -341064690: /*resource*/ return new String[] {"code"};
        case 102727412: /*label*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1423461112: /*accept*/ return new String[] {"code"};
        case -389131437: /*contentType*/ return new String[] {"code"};
        case -1429847026: /*destination*/ return new String[] {"integer"};
        case -1760554218: /*encodeRequestUrl*/ return new String[] {"boolean"};
        case -1077554975: /*method*/ return new String[] {"code"};
        case -1008619738: /*origin*/ return new String[] {"integer"};
        case -995427962: /*params*/ return new String[] {"string"};
        case 1074158076: /*requestHeader*/ return new String[] {};
        case 693933066: /*requestId*/ return new String[] {"id"};
        case -633138884: /*responseId*/ return new String[] {"id"};
        case 1746327190: /*sourceId*/ return new String[] {"id"};
        case -441951604: /*targetId*/ return new String[] {"id"};
        case 116079: /*url*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new Coding();
          return this.type;
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.resource");
        }
        else if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.label");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.description");
        }
        else if (name.equals("accept")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.accept");
        }
        else if (name.equals("contentType")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.contentType");
        }
        else if (name.equals("destination")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.destination");
        }
        else if (name.equals("encodeRequestUrl")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.encodeRequestUrl");
        }
        else if (name.equals("method")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.method");
        }
        else if (name.equals("origin")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.origin");
        }
        else if (name.equals("params")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.params");
        }
        else if (name.equals("requestHeader")) {
          return addRequestHeader();
        }
        else if (name.equals("requestId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.requestId");
        }
        else if (name.equals("responseId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.responseId");
        }
        else if (name.equals("sourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.sourceId");
        }
        else if (name.equals("targetId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.targetId");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.url");
        }
        else
          return super.addChild(name);
      }

      public SetupActionOperationComponent copy() {
        SetupActionOperationComponent dst = new SetupActionOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SetupActionOperationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.label = label == null ? null : label.copy();
        dst.description = description == null ? null : description.copy();
        dst.accept = accept == null ? null : accept.copy();
        dst.contentType = contentType == null ? null : contentType.copy();
        dst.destination = destination == null ? null : destination.copy();
        dst.encodeRequestUrl = encodeRequestUrl == null ? null : encodeRequestUrl.copy();
        dst.method = method == null ? null : method.copy();
        dst.origin = origin == null ? null : origin.copy();
        dst.params = params == null ? null : params.copy();
        if (requestHeader != null) {
          dst.requestHeader = new ArrayList<SetupActionOperationRequestHeaderComponent>();
          for (SetupActionOperationRequestHeaderComponent i : requestHeader)
            dst.requestHeader.add(i.copy());
        };
        dst.requestId = requestId == null ? null : requestId.copy();
        dst.responseId = responseId == null ? null : responseId.copy();
        dst.sourceId = sourceId == null ? null : sourceId.copy();
        dst.targetId = targetId == null ? null : targetId.copy();
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SetupActionOperationComponent))
          return false;
        SetupActionOperationComponent o = (SetupActionOperationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(resource, o.resource, true) && compareDeep(label, o.label, true)
           && compareDeep(description, o.description, true) && compareDeep(accept, o.accept, true) && compareDeep(contentType, o.contentType, true)
           && compareDeep(destination, o.destination, true) && compareDeep(encodeRequestUrl, o.encodeRequestUrl, true)
           && compareDeep(method, o.method, true) && compareDeep(origin, o.origin, true) && compareDeep(params, o.params, true)
           && compareDeep(requestHeader, o.requestHeader, true) && compareDeep(requestId, o.requestId, true)
           && compareDeep(responseId, o.responseId, true) && compareDeep(sourceId, o.sourceId, true) && compareDeep(targetId, o.targetId, true)
           && compareDeep(url, o.url, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SetupActionOperationComponent))
          return false;
        SetupActionOperationComponent o = (SetupActionOperationComponent) other_;
        return compareValues(resource, o.resource, true) && compareValues(label, o.label, true) && compareValues(description, o.description, true)
           && compareValues(accept, o.accept, true) && compareValues(contentType, o.contentType, true) && compareValues(destination, o.destination, true)
           && compareValues(encodeRequestUrl, o.encodeRequestUrl, true) && compareValues(method, o.method, true)
           && compareValues(origin, o.origin, true) && compareValues(params, o.params, true) && compareValues(requestId, o.requestId, true)
           && compareValues(responseId, o.responseId, true) && compareValues(sourceId, o.sourceId, true) && compareValues(targetId, o.targetId, true)
           && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, resource, label, description
          , accept, contentType, destination, encodeRequestUrl, method, origin, params, requestHeader
          , requestId, responseId, sourceId, targetId, url);
      }

  public String fhirType() {
    return "TestScript.setup.action.operation";

  }

  }

    @Block()
    public static class SetupActionOperationRequestHeaderComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The HTTP header field e.g. "Accept".
         */
        @Child(name = "field", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP header field name", formalDefinition="The HTTP header field e.g. \"Accept\"." )
        protected StringType field;

        /**
         * The value of the header e.g. "application/fhir+xml".
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP headerfield value", formalDefinition="The value of the header e.g. \"application/fhir+xml\"." )
        protected StringType value;

        private static final long serialVersionUID = 274395337L;

    /**
     * Constructor
     */
      public SetupActionOperationRequestHeaderComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SetupActionOperationRequestHeaderComponent(String field, String value) {
        super();
        this.setField(field);
        this.setValue(value);
      }

        /**
         * @return {@link #field} (The HTTP header field e.g. "Accept".). This is the underlying object with id, value and extensions. The accessor "getField" gives direct access to the value
         */
        public StringType getFieldElement() { 
          if (this.field == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationRequestHeaderComponent.field");
            else if (Configuration.doAutoCreate())
              this.field = new StringType(); // bb
          return this.field;
        }

        public boolean hasFieldElement() { 
          return this.field != null && !this.field.isEmpty();
        }

        public boolean hasField() { 
          return this.field != null && !this.field.isEmpty();
        }

        /**
         * @param value {@link #field} (The HTTP header field e.g. "Accept".). This is the underlying object with id, value and extensions. The accessor "getField" gives direct access to the value
         */
        public SetupActionOperationRequestHeaderComponent setFieldElement(StringType value) { 
          this.field = value;
          return this;
        }

        /**
         * @return The HTTP header field e.g. "Accept".
         */
        public String getField() { 
          return this.field == null ? null : this.field.getValue();
        }

        /**
         * @param value The HTTP header field e.g. "Accept".
         */
        public SetupActionOperationRequestHeaderComponent setField(String value) { 
            if (this.field == null)
              this.field = new StringType();
            this.field.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (The value of the header e.g. "application/fhir+xml".). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationRequestHeaderComponent.value");
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
         * @param value {@link #value} (The value of the header e.g. "application/fhir+xml".). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public SetupActionOperationRequestHeaderComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The value of the header e.g. "application/fhir+xml".
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The value of the header e.g. "application/fhir+xml".
         */
        public SetupActionOperationRequestHeaderComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("field", "string", "The HTTP header field e.g. \"Accept\".", 0, 1, field));
          children.add(new Property("value", "string", "The value of the header e.g. \"application/fhir+xml\".", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 97427706: /*field*/  return new Property("field", "string", "The HTTP header field e.g. \"Accept\".", 0, 1, field);
          case 111972721: /*value*/  return new Property("value", "string", "The value of the header e.g. \"application/fhir+xml\".", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 97427706: /*field*/ return this.field == null ? new Base[0] : new Base[] {this.field}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 97427706: // field
          this.field = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("field")) {
          this.field = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 97427706:  return getFieldElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 97427706: /*field*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("field")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.requestHeader.field");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.operation.requestHeader.value");
        }
        else
          return super.addChild(name);
      }

      public SetupActionOperationRequestHeaderComponent copy() {
        SetupActionOperationRequestHeaderComponent dst = new SetupActionOperationRequestHeaderComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SetupActionOperationRequestHeaderComponent dst) {
        super.copyValues(dst);
        dst.field = field == null ? null : field.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SetupActionOperationRequestHeaderComponent))
          return false;
        SetupActionOperationRequestHeaderComponent o = (SetupActionOperationRequestHeaderComponent) other_;
        return compareDeep(field, o.field, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SetupActionOperationRequestHeaderComponent))
          return false;
        SetupActionOperationRequestHeaderComponent o = (SetupActionOperationRequestHeaderComponent) other_;
        return compareValues(field, o.field, true) && compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(field, value);
      }

  public String fhirType() {
    return "TestScript.setup.action.operation.requestHeader";

  }

  }

    @Block()
    public static class SetupActionAssertComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The label would be used for tracking/logging purposes by test engines.
         */
        @Child(name = "label", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Tracking/logging assertion label", formalDefinition="The label would be used for tracking/logging purposes by test engines." )
        protected StringType label;

        /**
         * The description would be used by test engines for tracking and reporting purposes.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Tracking/reporting assertion description", formalDefinition="The description would be used by test engines for tracking and reporting purposes." )
        protected StringType description;

        /**
         * The direction to use for the assertion.
         */
        @Child(name = "direction", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="response | request", formalDefinition="The direction to use for the assertion." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/assert-direction-codes")
        protected Enumeration<AssertionDirectionType> direction;

        /**
         * Id of the source fixture used as the contents to be evaluated by either the "source/expression" or "sourceId/path" definition.
         */
        @Child(name = "compareToSourceId", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Id of the source fixture to be evaluated", formalDefinition="Id of the source fixture used as the contents to be evaluated by either the \"source/expression\" or \"sourceId/path\" definition." )
        protected StringType compareToSourceId;

        /**
         * The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        @Child(name = "compareToSourceExpression", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The FHIRPath expression to evaluate against the source fixture", formalDefinition="The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both." )
        protected StringType compareToSourceExpression;

        /**
         * XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        @Child(name = "compareToSourcePath", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="XPath or JSONPath expression to evaluate against the source fixture", formalDefinition="XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both." )
        protected StringType compareToSourcePath;

        /**
         * The mime-type contents to compare against the request or response message 'Content-Type' header.
         */
        @Child(name = "contentType", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Mime type to compare against the 'Content-Type' header", formalDefinition="The mime-type contents to compare against the request or response message 'Content-Type' header." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected CodeType contentType;

        /**
         * The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.
         */
        @Child(name = "expression", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The FHIRPath expression to be evaluated", formalDefinition="The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload." )
        protected StringType expression;

        /**
         * The HTTP header field name e.g. 'Location'.
         */
        @Child(name = "headerField", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP header field name", formalDefinition="The HTTP header field name e.g. 'Location'." )
        protected StringType headerField;

        /**
         * The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.
         */
        @Child(name = "minimumId", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of minimum content resource", formalDefinition="The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId." )
        protected StringType minimumId;

        /**
         * Whether or not the test execution performs validation on the bundle navigation links.
         */
        @Child(name = "navigationLinks", type = {BooleanType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Perform validation on navigation links?", formalDefinition="Whether or not the test execution performs validation on the bundle navigation links." )
        protected BooleanType navigationLinks;

        /**
         * The operator type defines the conditional behavior of the assert. If not defined, the default is equals.
         */
        @Child(name = "operator", type = {CodeType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="equals | notEquals | in | notIn | greaterThan | lessThan | empty | notEmpty | contains | notContains | eval", formalDefinition="The operator type defines the conditional behavior of the assert. If not defined, the default is equals." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/assert-operator-codes")
        protected Enumeration<AssertionOperatorType> operator;

        /**
         * The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.
         */
        @Child(name = "path", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="XPath or JSONPath expression", formalDefinition="The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server." )
        protected StringType path;

        /**
         * The request method or HTTP operation code to compare against that used by the client system under test.
         */
        @Child(name = "requestMethod", type = {CodeType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="delete | get | options | patch | post | put | head", formalDefinition="The request method or HTTP operation code to compare against that used by the client system under test." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/http-operations")
        protected Enumeration<TestScriptRequestMethodCode> requestMethod;

        /**
         * The value to use in a comparison against the request URL path string.
         */
        @Child(name = "requestURL", type = {StringType.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Request URL comparison value", formalDefinition="The value to use in a comparison against the request URL path string." )
        protected StringType requestURL;

        /**
         * The type of the resource.  See http://build.fhir.org/resourcelist.html.
         */
        @Child(name = "resource", type = {CodeType.class}, order=16, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Resource type", formalDefinition="The type of the resource.  See http://build.fhir.org/resourcelist.html." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/defined-types")
        protected Enumeration<FHIRDefinedType> resource;

        /**
         * okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.
         */
        @Child(name = "response", type = {CodeType.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable", formalDefinition="okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/assert-response-code-types")
        protected Enumeration<AssertionResponseTypes> response;

        /**
         * The value of the HTTP response code to be tested.
         */
        @Child(name = "responseCode", type = {StringType.class}, order=18, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP response code to test", formalDefinition="The value of the HTTP response code to be tested." )
        protected StringType responseCode;

        /**
         * Fixture to evaluate the XPath/JSONPath expression or the headerField  against.
         */
        @Child(name = "sourceId", type = {IdType.class}, order=19, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of source expression or headerField", formalDefinition="Fixture to evaluate the XPath/JSONPath expression or the headerField  against." )
        protected IdType sourceId;

        /**
         * The ID of the Profile to validate against.
         */
        @Child(name = "validateProfileId", type = {IdType.class}, order=20, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Profile Id of validation profile reference", formalDefinition="The ID of the Profile to validate against." )
        protected IdType validateProfileId;

        /**
         * The value to compare to.
         */
        @Child(name = "value", type = {StringType.class}, order=21, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The value to compare to", formalDefinition="The value to compare to." )
        protected StringType value;

        /**
         * Whether or not the test execution will produce a warning only on error for this assert.
         */
        @Child(name = "warningOnly", type = {BooleanType.class}, order=22, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Will this assert produce a warning only on error?", formalDefinition="Whether or not the test execution will produce a warning only on error for this assert." )
        protected BooleanType warningOnly;

        private static final long serialVersionUID = -1112296782L;

    /**
     * Constructor
     */
      public SetupActionAssertComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SetupActionAssertComponent(boolean warningOnly) {
        super();
        this.setWarningOnly(warningOnly);
      }

        /**
         * @return {@link #label} (The label would be used for tracking/logging purposes by test engines.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.label");
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
         * @param value {@link #label} (The label would be used for tracking/logging purposes by test engines.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public SetupActionAssertComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return The label would be used for tracking/logging purposes by test engines.
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value The label would be used for tracking/logging purposes by test engines.
         */
        public SetupActionAssertComponent setLabel(String value) { 
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
         * @return {@link #description} (The description would be used by test engines for tracking and reporting purposes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.description");
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
         * @param value {@link #description} (The description would be used by test engines for tracking and reporting purposes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SetupActionAssertComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The description would be used by test engines for tracking and reporting purposes.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The description would be used by test engines for tracking and reporting purposes.
         */
        public SetupActionAssertComponent setDescription(String value) { 
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
         * @return {@link #direction} (The direction to use for the assertion.). This is the underlying object with id, value and extensions. The accessor "getDirection" gives direct access to the value
         */
        public Enumeration<AssertionDirectionType> getDirectionElement() { 
          if (this.direction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.direction");
            else if (Configuration.doAutoCreate())
              this.direction = new Enumeration<AssertionDirectionType>(new AssertionDirectionTypeEnumFactory()); // bb
          return this.direction;
        }

        public boolean hasDirectionElement() { 
          return this.direction != null && !this.direction.isEmpty();
        }

        public boolean hasDirection() { 
          return this.direction != null && !this.direction.isEmpty();
        }

        /**
         * @param value {@link #direction} (The direction to use for the assertion.). This is the underlying object with id, value and extensions. The accessor "getDirection" gives direct access to the value
         */
        public SetupActionAssertComponent setDirectionElement(Enumeration<AssertionDirectionType> value) { 
          this.direction = value;
          return this;
        }

        /**
         * @return The direction to use for the assertion.
         */
        public AssertionDirectionType getDirection() { 
          return this.direction == null ? null : this.direction.getValue();
        }

        /**
         * @param value The direction to use for the assertion.
         */
        public SetupActionAssertComponent setDirection(AssertionDirectionType value) { 
          if (value == null)
            this.direction = null;
          else {
            if (this.direction == null)
              this.direction = new Enumeration<AssertionDirectionType>(new AssertionDirectionTypeEnumFactory());
            this.direction.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #compareToSourceId} (Id of the source fixture used as the contents to be evaluated by either the "source/expression" or "sourceId/path" definition.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourceId" gives direct access to the value
         */
        public StringType getCompareToSourceIdElement() { 
          if (this.compareToSourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.compareToSourceId");
            else if (Configuration.doAutoCreate())
              this.compareToSourceId = new StringType(); // bb
          return this.compareToSourceId;
        }

        public boolean hasCompareToSourceIdElement() { 
          return this.compareToSourceId != null && !this.compareToSourceId.isEmpty();
        }

        public boolean hasCompareToSourceId() { 
          return this.compareToSourceId != null && !this.compareToSourceId.isEmpty();
        }

        /**
         * @param value {@link #compareToSourceId} (Id of the source fixture used as the contents to be evaluated by either the "source/expression" or "sourceId/path" definition.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourceId" gives direct access to the value
         */
        public SetupActionAssertComponent setCompareToSourceIdElement(StringType value) { 
          this.compareToSourceId = value;
          return this;
        }

        /**
         * @return Id of the source fixture used as the contents to be evaluated by either the "source/expression" or "sourceId/path" definition.
         */
        public String getCompareToSourceId() { 
          return this.compareToSourceId == null ? null : this.compareToSourceId.getValue();
        }

        /**
         * @param value Id of the source fixture used as the contents to be evaluated by either the "source/expression" or "sourceId/path" definition.
         */
        public SetupActionAssertComponent setCompareToSourceId(String value) { 
          if (Utilities.noString(value))
            this.compareToSourceId = null;
          else {
            if (this.compareToSourceId == null)
              this.compareToSourceId = new StringType();
            this.compareToSourceId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #compareToSourceExpression} (The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourceExpression" gives direct access to the value
         */
        public StringType getCompareToSourceExpressionElement() { 
          if (this.compareToSourceExpression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.compareToSourceExpression");
            else if (Configuration.doAutoCreate())
              this.compareToSourceExpression = new StringType(); // bb
          return this.compareToSourceExpression;
        }

        public boolean hasCompareToSourceExpressionElement() { 
          return this.compareToSourceExpression != null && !this.compareToSourceExpression.isEmpty();
        }

        public boolean hasCompareToSourceExpression() { 
          return this.compareToSourceExpression != null && !this.compareToSourceExpression.isEmpty();
        }

        /**
         * @param value {@link #compareToSourceExpression} (The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourceExpression" gives direct access to the value
         */
        public SetupActionAssertComponent setCompareToSourceExpressionElement(StringType value) { 
          this.compareToSourceExpression = value;
          return this;
        }

        /**
         * @return The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        public String getCompareToSourceExpression() { 
          return this.compareToSourceExpression == null ? null : this.compareToSourceExpression.getValue();
        }

        /**
         * @param value The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        public SetupActionAssertComponent setCompareToSourceExpression(String value) { 
          if (Utilities.noString(value))
            this.compareToSourceExpression = null;
          else {
            if (this.compareToSourceExpression == null)
              this.compareToSourceExpression = new StringType();
            this.compareToSourceExpression.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #compareToSourcePath} (XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourcePath" gives direct access to the value
         */
        public StringType getCompareToSourcePathElement() { 
          if (this.compareToSourcePath == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.compareToSourcePath");
            else if (Configuration.doAutoCreate())
              this.compareToSourcePath = new StringType(); // bb
          return this.compareToSourcePath;
        }

        public boolean hasCompareToSourcePathElement() { 
          return this.compareToSourcePath != null && !this.compareToSourcePath.isEmpty();
        }

        public boolean hasCompareToSourcePath() { 
          return this.compareToSourcePath != null && !this.compareToSourcePath.isEmpty();
        }

        /**
         * @param value {@link #compareToSourcePath} (XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourcePath" gives direct access to the value
         */
        public SetupActionAssertComponent setCompareToSourcePathElement(StringType value) { 
          this.compareToSourcePath = value;
          return this;
        }

        /**
         * @return XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        public String getCompareToSourcePath() { 
          return this.compareToSourcePath == null ? null : this.compareToSourcePath.getValue();
        }

        /**
         * @param value XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        public SetupActionAssertComponent setCompareToSourcePath(String value) { 
          if (Utilities.noString(value))
            this.compareToSourcePath = null;
          else {
            if (this.compareToSourcePath == null)
              this.compareToSourcePath = new StringType();
            this.compareToSourcePath.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #contentType} (The mime-type contents to compare against the request or response message 'Content-Type' header.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
         */
        public CodeType getContentTypeElement() { 
          if (this.contentType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.contentType");
            else if (Configuration.doAutoCreate())
              this.contentType = new CodeType(); // bb
          return this.contentType;
        }

        public boolean hasContentTypeElement() { 
          return this.contentType != null && !this.contentType.isEmpty();
        }

        public boolean hasContentType() { 
          return this.contentType != null && !this.contentType.isEmpty();
        }

        /**
         * @param value {@link #contentType} (The mime-type contents to compare against the request or response message 'Content-Type' header.). This is the underlying object with id, value and extensions. The accessor "getContentType" gives direct access to the value
         */
        public SetupActionAssertComponent setContentTypeElement(CodeType value) { 
          this.contentType = value;
          return this;
        }

        /**
         * @return The mime-type contents to compare against the request or response message 'Content-Type' header.
         */
        public String getContentType() { 
          return this.contentType == null ? null : this.contentType.getValue();
        }

        /**
         * @param value The mime-type contents to compare against the request or response message 'Content-Type' header.
         */
        public SetupActionAssertComponent setContentType(String value) { 
          if (Utilities.noString(value))
            this.contentType = null;
          else {
            if (this.contentType == null)
              this.contentType = new CodeType();
            this.contentType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #expression} (The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public StringType getExpressionElement() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.expression");
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
         * @param value {@link #expression} (The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public SetupActionAssertComponent setExpressionElement(StringType value) { 
          this.expression = value;
          return this;
        }

        /**
         * @return The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.
         */
        public String getExpression() { 
          return this.expression == null ? null : this.expression.getValue();
        }

        /**
         * @param value The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.
         */
        public SetupActionAssertComponent setExpression(String value) { 
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
         * @return {@link #headerField} (The HTTP header field name e.g. 'Location'.). This is the underlying object with id, value and extensions. The accessor "getHeaderField" gives direct access to the value
         */
        public StringType getHeaderFieldElement() { 
          if (this.headerField == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.headerField");
            else if (Configuration.doAutoCreate())
              this.headerField = new StringType(); // bb
          return this.headerField;
        }

        public boolean hasHeaderFieldElement() { 
          return this.headerField != null && !this.headerField.isEmpty();
        }

        public boolean hasHeaderField() { 
          return this.headerField != null && !this.headerField.isEmpty();
        }

        /**
         * @param value {@link #headerField} (The HTTP header field name e.g. 'Location'.). This is the underlying object with id, value and extensions. The accessor "getHeaderField" gives direct access to the value
         */
        public SetupActionAssertComponent setHeaderFieldElement(StringType value) { 
          this.headerField = value;
          return this;
        }

        /**
         * @return The HTTP header field name e.g. 'Location'.
         */
        public String getHeaderField() { 
          return this.headerField == null ? null : this.headerField.getValue();
        }

        /**
         * @param value The HTTP header field name e.g. 'Location'.
         */
        public SetupActionAssertComponent setHeaderField(String value) { 
          if (Utilities.noString(value))
            this.headerField = null;
          else {
            if (this.headerField == null)
              this.headerField = new StringType();
            this.headerField.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #minimumId} (The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.). This is the underlying object with id, value and extensions. The accessor "getMinimumId" gives direct access to the value
         */
        public StringType getMinimumIdElement() { 
          if (this.minimumId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.minimumId");
            else if (Configuration.doAutoCreate())
              this.minimumId = new StringType(); // bb
          return this.minimumId;
        }

        public boolean hasMinimumIdElement() { 
          return this.minimumId != null && !this.minimumId.isEmpty();
        }

        public boolean hasMinimumId() { 
          return this.minimumId != null && !this.minimumId.isEmpty();
        }

        /**
         * @param value {@link #minimumId} (The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.). This is the underlying object with id, value and extensions. The accessor "getMinimumId" gives direct access to the value
         */
        public SetupActionAssertComponent setMinimumIdElement(StringType value) { 
          this.minimumId = value;
          return this;
        }

        /**
         * @return The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.
         */
        public String getMinimumId() { 
          return this.minimumId == null ? null : this.minimumId.getValue();
        }

        /**
         * @param value The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.
         */
        public SetupActionAssertComponent setMinimumId(String value) { 
          if (Utilities.noString(value))
            this.minimumId = null;
          else {
            if (this.minimumId == null)
              this.minimumId = new StringType();
            this.minimumId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #navigationLinks} (Whether or not the test execution performs validation on the bundle navigation links.). This is the underlying object with id, value and extensions. The accessor "getNavigationLinks" gives direct access to the value
         */
        public BooleanType getNavigationLinksElement() { 
          if (this.navigationLinks == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.navigationLinks");
            else if (Configuration.doAutoCreate())
              this.navigationLinks = new BooleanType(); // bb
          return this.navigationLinks;
        }

        public boolean hasNavigationLinksElement() { 
          return this.navigationLinks != null && !this.navigationLinks.isEmpty();
        }

        public boolean hasNavigationLinks() { 
          return this.navigationLinks != null && !this.navigationLinks.isEmpty();
        }

        /**
         * @param value {@link #navigationLinks} (Whether or not the test execution performs validation on the bundle navigation links.). This is the underlying object with id, value and extensions. The accessor "getNavigationLinks" gives direct access to the value
         */
        public SetupActionAssertComponent setNavigationLinksElement(BooleanType value) { 
          this.navigationLinks = value;
          return this;
        }

        /**
         * @return Whether or not the test execution performs validation on the bundle navigation links.
         */
        public boolean getNavigationLinks() { 
          return this.navigationLinks == null || this.navigationLinks.isEmpty() ? false : this.navigationLinks.getValue();
        }

        /**
         * @param value Whether or not the test execution performs validation on the bundle navigation links.
         */
        public SetupActionAssertComponent setNavigationLinks(boolean value) { 
            if (this.navigationLinks == null)
              this.navigationLinks = new BooleanType();
            this.navigationLinks.setValue(value);
          return this;
        }

        /**
         * @return {@link #operator} (The operator type defines the conditional behavior of the assert. If not defined, the default is equals.). This is the underlying object with id, value and extensions. The accessor "getOperator" gives direct access to the value
         */
        public Enumeration<AssertionOperatorType> getOperatorElement() { 
          if (this.operator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.operator");
            else if (Configuration.doAutoCreate())
              this.operator = new Enumeration<AssertionOperatorType>(new AssertionOperatorTypeEnumFactory()); // bb
          return this.operator;
        }

        public boolean hasOperatorElement() { 
          return this.operator != null && !this.operator.isEmpty();
        }

        public boolean hasOperator() { 
          return this.operator != null && !this.operator.isEmpty();
        }

        /**
         * @param value {@link #operator} (The operator type defines the conditional behavior of the assert. If not defined, the default is equals.). This is the underlying object with id, value and extensions. The accessor "getOperator" gives direct access to the value
         */
        public SetupActionAssertComponent setOperatorElement(Enumeration<AssertionOperatorType> value) { 
          this.operator = value;
          return this;
        }

        /**
         * @return The operator type defines the conditional behavior of the assert. If not defined, the default is equals.
         */
        public AssertionOperatorType getOperator() { 
          return this.operator == null ? null : this.operator.getValue();
        }

        /**
         * @param value The operator type defines the conditional behavior of the assert. If not defined, the default is equals.
         */
        public SetupActionAssertComponent setOperator(AssertionOperatorType value) { 
          if (value == null)
            this.operator = null;
          else {
            if (this.operator == null)
              this.operator = new Enumeration<AssertionOperatorType>(new AssertionOperatorTypeEnumFactory());
            this.operator.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #path} (The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.path");
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
         * @param value {@link #path} (The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public SetupActionAssertComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.
         */
        public SetupActionAssertComponent setPath(String value) { 
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
         * @return {@link #requestMethod} (The request method or HTTP operation code to compare against that used by the client system under test.). This is the underlying object with id, value and extensions. The accessor "getRequestMethod" gives direct access to the value
         */
        public Enumeration<TestScriptRequestMethodCode> getRequestMethodElement() { 
          if (this.requestMethod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.requestMethod");
            else if (Configuration.doAutoCreate())
              this.requestMethod = new Enumeration<TestScriptRequestMethodCode>(new TestScriptRequestMethodCodeEnumFactory()); // bb
          return this.requestMethod;
        }

        public boolean hasRequestMethodElement() { 
          return this.requestMethod != null && !this.requestMethod.isEmpty();
        }

        public boolean hasRequestMethod() { 
          return this.requestMethod != null && !this.requestMethod.isEmpty();
        }

        /**
         * @param value {@link #requestMethod} (The request method or HTTP operation code to compare against that used by the client system under test.). This is the underlying object with id, value and extensions. The accessor "getRequestMethod" gives direct access to the value
         */
        public SetupActionAssertComponent setRequestMethodElement(Enumeration<TestScriptRequestMethodCode> value) { 
          this.requestMethod = value;
          return this;
        }

        /**
         * @return The request method or HTTP operation code to compare against that used by the client system under test.
         */
        public TestScriptRequestMethodCode getRequestMethod() { 
          return this.requestMethod == null ? null : this.requestMethod.getValue();
        }

        /**
         * @param value The request method or HTTP operation code to compare against that used by the client system under test.
         */
        public SetupActionAssertComponent setRequestMethod(TestScriptRequestMethodCode value) { 
          if (value == null)
            this.requestMethod = null;
          else {
            if (this.requestMethod == null)
              this.requestMethod = new Enumeration<TestScriptRequestMethodCode>(new TestScriptRequestMethodCodeEnumFactory());
            this.requestMethod.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #requestURL} (The value to use in a comparison against the request URL path string.). This is the underlying object with id, value and extensions. The accessor "getRequestURL" gives direct access to the value
         */
        public StringType getRequestURLElement() { 
          if (this.requestURL == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.requestURL");
            else if (Configuration.doAutoCreate())
              this.requestURL = new StringType(); // bb
          return this.requestURL;
        }

        public boolean hasRequestURLElement() { 
          return this.requestURL != null && !this.requestURL.isEmpty();
        }

        public boolean hasRequestURL() { 
          return this.requestURL != null && !this.requestURL.isEmpty();
        }

        /**
         * @param value {@link #requestURL} (The value to use in a comparison against the request URL path string.). This is the underlying object with id, value and extensions. The accessor "getRequestURL" gives direct access to the value
         */
        public SetupActionAssertComponent setRequestURLElement(StringType value) { 
          this.requestURL = value;
          return this;
        }

        /**
         * @return The value to use in a comparison against the request URL path string.
         */
        public String getRequestURL() { 
          return this.requestURL == null ? null : this.requestURL.getValue();
        }

        /**
         * @param value The value to use in a comparison against the request URL path string.
         */
        public SetupActionAssertComponent setRequestURL(String value) { 
          if (Utilities.noString(value))
            this.requestURL = null;
          else {
            if (this.requestURL == null)
              this.requestURL = new StringType();
            this.requestURL.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resource} (The type of the resource.  See http://build.fhir.org/resourcelist.html.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public Enumeration<FHIRDefinedType> getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new Enumeration<FHIRDefinedType>(new FHIRDefinedTypeEnumFactory()); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (The type of the resource.  See http://build.fhir.org/resourcelist.html.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SetupActionAssertComponent setResourceElement(Enumeration<FHIRDefinedType> value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return The type of the resource.  See http://build.fhir.org/resourcelist.html.
         */
        public FHIRDefinedType getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value The type of the resource.  See http://build.fhir.org/resourcelist.html.
         */
        public SetupActionAssertComponent setResource(FHIRDefinedType value) { 
          if (value == null)
            this.resource = null;
          else {
            if (this.resource == null)
              this.resource = new Enumeration<FHIRDefinedType>(new FHIRDefinedTypeEnumFactory());
            this.resource.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #response} (okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.). This is the underlying object with id, value and extensions. The accessor "getResponse" gives direct access to the value
         */
        public Enumeration<AssertionResponseTypes> getResponseElement() { 
          if (this.response == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.response");
            else if (Configuration.doAutoCreate())
              this.response = new Enumeration<AssertionResponseTypes>(new AssertionResponseTypesEnumFactory()); // bb
          return this.response;
        }

        public boolean hasResponseElement() { 
          return this.response != null && !this.response.isEmpty();
        }

        public boolean hasResponse() { 
          return this.response != null && !this.response.isEmpty();
        }

        /**
         * @param value {@link #response} (okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.). This is the underlying object with id, value and extensions. The accessor "getResponse" gives direct access to the value
         */
        public SetupActionAssertComponent setResponseElement(Enumeration<AssertionResponseTypes> value) { 
          this.response = value;
          return this;
        }

        /**
         * @return okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.
         */
        public AssertionResponseTypes getResponse() { 
          return this.response == null ? null : this.response.getValue();
        }

        /**
         * @param value okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.
         */
        public SetupActionAssertComponent setResponse(AssertionResponseTypes value) { 
          if (value == null)
            this.response = null;
          else {
            if (this.response == null)
              this.response = new Enumeration<AssertionResponseTypes>(new AssertionResponseTypesEnumFactory());
            this.response.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #responseCode} (The value of the HTTP response code to be tested.). This is the underlying object with id, value and extensions. The accessor "getResponseCode" gives direct access to the value
         */
        public StringType getResponseCodeElement() { 
          if (this.responseCode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.responseCode");
            else if (Configuration.doAutoCreate())
              this.responseCode = new StringType(); // bb
          return this.responseCode;
        }

        public boolean hasResponseCodeElement() { 
          return this.responseCode != null && !this.responseCode.isEmpty();
        }

        public boolean hasResponseCode() { 
          return this.responseCode != null && !this.responseCode.isEmpty();
        }

        /**
         * @param value {@link #responseCode} (The value of the HTTP response code to be tested.). This is the underlying object with id, value and extensions. The accessor "getResponseCode" gives direct access to the value
         */
        public SetupActionAssertComponent setResponseCodeElement(StringType value) { 
          this.responseCode = value;
          return this;
        }

        /**
         * @return The value of the HTTP response code to be tested.
         */
        public String getResponseCode() { 
          return this.responseCode == null ? null : this.responseCode.getValue();
        }

        /**
         * @param value The value of the HTTP response code to be tested.
         */
        public SetupActionAssertComponent setResponseCode(String value) { 
          if (Utilities.noString(value))
            this.responseCode = null;
          else {
            if (this.responseCode == null)
              this.responseCode = new StringType();
            this.responseCode.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #sourceId} (Fixture to evaluate the XPath/JSONPath expression or the headerField  against.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public IdType getSourceIdElement() { 
          if (this.sourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.sourceId");
            else if (Configuration.doAutoCreate())
              this.sourceId = new IdType(); // bb
          return this.sourceId;
        }

        public boolean hasSourceIdElement() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        public boolean hasSourceId() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        /**
         * @param value {@link #sourceId} (Fixture to evaluate the XPath/JSONPath expression or the headerField  against.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public SetupActionAssertComponent setSourceIdElement(IdType value) { 
          this.sourceId = value;
          return this;
        }

        /**
         * @return Fixture to evaluate the XPath/JSONPath expression or the headerField  against.
         */
        public String getSourceId() { 
          return this.sourceId == null ? null : this.sourceId.getValue();
        }

        /**
         * @param value Fixture to evaluate the XPath/JSONPath expression or the headerField  against.
         */
        public SetupActionAssertComponent setSourceId(String value) { 
          if (Utilities.noString(value))
            this.sourceId = null;
          else {
            if (this.sourceId == null)
              this.sourceId = new IdType();
            this.sourceId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #validateProfileId} (The ID of the Profile to validate against.). This is the underlying object with id, value and extensions. The accessor "getValidateProfileId" gives direct access to the value
         */
        public IdType getValidateProfileIdElement() { 
          if (this.validateProfileId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.validateProfileId");
            else if (Configuration.doAutoCreate())
              this.validateProfileId = new IdType(); // bb
          return this.validateProfileId;
        }

        public boolean hasValidateProfileIdElement() { 
          return this.validateProfileId != null && !this.validateProfileId.isEmpty();
        }

        public boolean hasValidateProfileId() { 
          return this.validateProfileId != null && !this.validateProfileId.isEmpty();
        }

        /**
         * @param value {@link #validateProfileId} (The ID of the Profile to validate against.). This is the underlying object with id, value and extensions. The accessor "getValidateProfileId" gives direct access to the value
         */
        public SetupActionAssertComponent setValidateProfileIdElement(IdType value) { 
          this.validateProfileId = value;
          return this;
        }

        /**
         * @return The ID of the Profile to validate against.
         */
        public String getValidateProfileId() { 
          return this.validateProfileId == null ? null : this.validateProfileId.getValue();
        }

        /**
         * @param value The ID of the Profile to validate against.
         */
        public SetupActionAssertComponent setValidateProfileId(String value) { 
          if (Utilities.noString(value))
            this.validateProfileId = null;
          else {
            if (this.validateProfileId == null)
              this.validateProfileId = new IdType();
            this.validateProfileId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #value} (The value to compare to.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.value");
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
         * @param value {@link #value} (The value to compare to.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public SetupActionAssertComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The value to compare to.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The value to compare to.
         */
        public SetupActionAssertComponent setValue(String value) { 
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
         * @return {@link #warningOnly} (Whether or not the test execution will produce a warning only on error for this assert.). This is the underlying object with id, value and extensions. The accessor "getWarningOnly" gives direct access to the value
         */
        public BooleanType getWarningOnlyElement() { 
          if (this.warningOnly == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.warningOnly");
            else if (Configuration.doAutoCreate())
              this.warningOnly = new BooleanType(); // bb
          return this.warningOnly;
        }

        public boolean hasWarningOnlyElement() { 
          return this.warningOnly != null && !this.warningOnly.isEmpty();
        }

        public boolean hasWarningOnly() { 
          return this.warningOnly != null && !this.warningOnly.isEmpty();
        }

        /**
         * @param value {@link #warningOnly} (Whether or not the test execution will produce a warning only on error for this assert.). This is the underlying object with id, value and extensions. The accessor "getWarningOnly" gives direct access to the value
         */
        public SetupActionAssertComponent setWarningOnlyElement(BooleanType value) { 
          this.warningOnly = value;
          return this;
        }

        /**
         * @return Whether or not the test execution will produce a warning only on error for this assert.
         */
        public boolean getWarningOnly() { 
          return this.warningOnly == null || this.warningOnly.isEmpty() ? false : this.warningOnly.getValue();
        }

        /**
         * @param value Whether or not the test execution will produce a warning only on error for this assert.
         */
        public SetupActionAssertComponent setWarningOnly(boolean value) { 
            if (this.warningOnly == null)
              this.warningOnly = new BooleanType();
            this.warningOnly.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("label", "string", "The label would be used for tracking/logging purposes by test engines.", 0, 1, label));
          children.add(new Property("description", "string", "The description would be used by test engines for tracking and reporting purposes.", 0, 1, description));
          children.add(new Property("direction", "code", "The direction to use for the assertion.", 0, 1, direction));
          children.add(new Property("compareToSourceId", "string", "Id of the source fixture used as the contents to be evaluated by either the \"source/expression\" or \"sourceId/path\" definition.", 0, 1, compareToSourceId));
          children.add(new Property("compareToSourceExpression", "string", "The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourceExpression));
          children.add(new Property("compareToSourcePath", "string", "XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourcePath));
          children.add(new Property("contentType", "code", "The mime-type contents to compare against the request or response message 'Content-Type' header.", 0, 1, contentType));
          children.add(new Property("expression", "string", "The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.", 0, 1, expression));
          children.add(new Property("headerField", "string", "The HTTP header field name e.g. 'Location'.", 0, 1, headerField));
          children.add(new Property("minimumId", "string", "The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.", 0, 1, minimumId));
          children.add(new Property("navigationLinks", "boolean", "Whether or not the test execution performs validation on the bundle navigation links.", 0, 1, navigationLinks));
          children.add(new Property("operator", "code", "The operator type defines the conditional behavior of the assert. If not defined, the default is equals.", 0, 1, operator));
          children.add(new Property("path", "string", "The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.", 0, 1, path));
          children.add(new Property("requestMethod", "code", "The request method or HTTP operation code to compare against that used by the client system under test.", 0, 1, requestMethod));
          children.add(new Property("requestURL", "string", "The value to use in a comparison against the request URL path string.", 0, 1, requestURL));
          children.add(new Property("resource", "code", "The type of the resource.  See http://build.fhir.org/resourcelist.html.", 0, 1, resource));
          children.add(new Property("response", "code", "okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.", 0, 1, response));
          children.add(new Property("responseCode", "string", "The value of the HTTP response code to be tested.", 0, 1, responseCode));
          children.add(new Property("sourceId", "id", "Fixture to evaluate the XPath/JSONPath expression or the headerField  against.", 0, 1, sourceId));
          children.add(new Property("validateProfileId", "id", "The ID of the Profile to validate against.", 0, 1, validateProfileId));
          children.add(new Property("value", "string", "The value to compare to.", 0, 1, value));
          children.add(new Property("warningOnly", "boolean", "Whether or not the test execution will produce a warning only on error for this assert.", 0, 1, warningOnly));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 102727412: /*label*/  return new Property("label", "string", "The label would be used for tracking/logging purposes by test engines.", 0, 1, label);
          case -1724546052: /*description*/  return new Property("description", "string", "The description would be used by test engines for tracking and reporting purposes.", 0, 1, description);
          case -962590849: /*direction*/  return new Property("direction", "code", "The direction to use for the assertion.", 0, 1, direction);
          case 2081856758: /*compareToSourceId*/  return new Property("compareToSourceId", "string", "Id of the source fixture used as the contents to be evaluated by either the \"source/expression\" or \"sourceId/path\" definition.", 0, 1, compareToSourceId);
          case -1415702669: /*compareToSourceExpression*/  return new Property("compareToSourceExpression", "string", "The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourceExpression);
          case -790206144: /*compareToSourcePath*/  return new Property("compareToSourcePath", "string", "XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourcePath);
          case -389131437: /*contentType*/  return new Property("contentType", "code", "The mime-type contents to compare against the request or response message 'Content-Type' header.", 0, 1, contentType);
          case -1795452264: /*expression*/  return new Property("expression", "string", "The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.", 0, 1, expression);
          case 1160732269: /*headerField*/  return new Property("headerField", "string", "The HTTP header field name e.g. 'Location'.", 0, 1, headerField);
          case 818925001: /*minimumId*/  return new Property("minimumId", "string", "The ID of a fixture.  Asserts that the response contains at a minimum the fixture specified by minimumId.", 0, 1, minimumId);
          case 1001488901: /*navigationLinks*/  return new Property("navigationLinks", "boolean", "Whether or not the test execution performs validation on the bundle navigation links.", 0, 1, navigationLinks);
          case -500553564: /*operator*/  return new Property("operator", "code", "The operator type defines the conditional behavior of the assert. If not defined, the default is equals.", 0, 1, operator);
          case 3433509: /*path*/  return new Property("path", "string", "The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.", 0, 1, path);
          case 1217874000: /*requestMethod*/  return new Property("requestMethod", "code", "The request method or HTTP operation code to compare against that used by the client system under test.", 0, 1, requestMethod);
          case 37099616: /*requestURL*/  return new Property("requestURL", "string", "The value to use in a comparison against the request URL path string.", 0, 1, requestURL);
          case -341064690: /*resource*/  return new Property("resource", "code", "The type of the resource.  See http://build.fhir.org/resourcelist.html.", 0, 1, resource);
          case -340323263: /*response*/  return new Property("response", "code", "okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.", 0, 1, response);
          case 1438723534: /*responseCode*/  return new Property("responseCode", "string", "The value of the HTTP response code to be tested.", 0, 1, responseCode);
          case 1746327190: /*sourceId*/  return new Property("sourceId", "id", "Fixture to evaluate the XPath/JSONPath expression or the headerField  against.", 0, 1, sourceId);
          case 1555541038: /*validateProfileId*/  return new Property("validateProfileId", "id", "The ID of the Profile to validate against.", 0, 1, validateProfileId);
          case 111972721: /*value*/  return new Property("value", "string", "The value to compare to.", 0, 1, value);
          case -481159832: /*warningOnly*/  return new Property("warningOnly", "boolean", "Whether or not the test execution will produce a warning only on error for this assert.", 0, 1, warningOnly);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -962590849: /*direction*/ return this.direction == null ? new Base[0] : new Base[] {this.direction}; // Enumeration<AssertionDirectionType>
        case 2081856758: /*compareToSourceId*/ return this.compareToSourceId == null ? new Base[0] : new Base[] {this.compareToSourceId}; // StringType
        case -1415702669: /*compareToSourceExpression*/ return this.compareToSourceExpression == null ? new Base[0] : new Base[] {this.compareToSourceExpression}; // StringType
        case -790206144: /*compareToSourcePath*/ return this.compareToSourcePath == null ? new Base[0] : new Base[] {this.compareToSourcePath}; // StringType
        case -389131437: /*contentType*/ return this.contentType == null ? new Base[0] : new Base[] {this.contentType}; // CodeType
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // StringType
        case 1160732269: /*headerField*/ return this.headerField == null ? new Base[0] : new Base[] {this.headerField}; // StringType
        case 818925001: /*minimumId*/ return this.minimumId == null ? new Base[0] : new Base[] {this.minimumId}; // StringType
        case 1001488901: /*navigationLinks*/ return this.navigationLinks == null ? new Base[0] : new Base[] {this.navigationLinks}; // BooleanType
        case -500553564: /*operator*/ return this.operator == null ? new Base[0] : new Base[] {this.operator}; // Enumeration<AssertionOperatorType>
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case 1217874000: /*requestMethod*/ return this.requestMethod == null ? new Base[0] : new Base[] {this.requestMethod}; // Enumeration<TestScriptRequestMethodCode>
        case 37099616: /*requestURL*/ return this.requestURL == null ? new Base[0] : new Base[] {this.requestURL}; // StringType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Enumeration<FHIRDefinedType>
        case -340323263: /*response*/ return this.response == null ? new Base[0] : new Base[] {this.response}; // Enumeration<AssertionResponseTypes>
        case 1438723534: /*responseCode*/ return this.responseCode == null ? new Base[0] : new Base[] {this.responseCode}; // StringType
        case 1746327190: /*sourceId*/ return this.sourceId == null ? new Base[0] : new Base[] {this.sourceId}; // IdType
        case 1555541038: /*validateProfileId*/ return this.validateProfileId == null ? new Base[0] : new Base[] {this.validateProfileId}; // IdType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case -481159832: /*warningOnly*/ return this.warningOnly == null ? new Base[0] : new Base[] {this.warningOnly}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -962590849: // direction
          value = new AssertionDirectionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.direction = (Enumeration) value; // Enumeration<AssertionDirectionType>
          return value;
        case 2081856758: // compareToSourceId
          this.compareToSourceId = TypeConvertor.castToString(value); // StringType
          return value;
        case -1415702669: // compareToSourceExpression
          this.compareToSourceExpression = TypeConvertor.castToString(value); // StringType
          return value;
        case -790206144: // compareToSourcePath
          this.compareToSourcePath = TypeConvertor.castToString(value); // StringType
          return value;
        case -389131437: // contentType
          this.contentType = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToString(value); // StringType
          return value;
        case 1160732269: // headerField
          this.headerField = TypeConvertor.castToString(value); // StringType
          return value;
        case 818925001: // minimumId
          this.minimumId = TypeConvertor.castToString(value); // StringType
          return value;
        case 1001488901: // navigationLinks
          this.navigationLinks = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -500553564: // operator
          value = new AssertionOperatorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.operator = (Enumeration) value; // Enumeration<AssertionOperatorType>
          return value;
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case 1217874000: // requestMethod
          value = new TestScriptRequestMethodCodeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.requestMethod = (Enumeration) value; // Enumeration<TestScriptRequestMethodCode>
          return value;
        case 37099616: // requestURL
          this.requestURL = TypeConvertor.castToString(value); // StringType
          return value;
        case -341064690: // resource
          value = new FHIRDefinedTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resource = (Enumeration) value; // Enumeration<FHIRDefinedType>
          return value;
        case -340323263: // response
          value = new AssertionResponseTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.response = (Enumeration) value; // Enumeration<AssertionResponseTypes>
          return value;
        case 1438723534: // responseCode
          this.responseCode = TypeConvertor.castToString(value); // StringType
          return value;
        case 1746327190: // sourceId
          this.sourceId = TypeConvertor.castToId(value); // IdType
          return value;
        case 1555541038: // validateProfileId
          this.validateProfileId = TypeConvertor.castToId(value); // IdType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case -481159832: // warningOnly
          this.warningOnly = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("direction")) {
          value = new AssertionDirectionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.direction = (Enumeration) value; // Enumeration<AssertionDirectionType>
        } else if (name.equals("compareToSourceId")) {
          this.compareToSourceId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("compareToSourceExpression")) {
          this.compareToSourceExpression = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("compareToSourcePath")) {
          this.compareToSourcePath = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contentType")) {
          this.contentType = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("headerField")) {
          this.headerField = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("minimumId")) {
          this.minimumId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("navigationLinks")) {
          this.navigationLinks = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("operator")) {
          value = new AssertionOperatorTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.operator = (Enumeration) value; // Enumeration<AssertionOperatorType>
        } else if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("requestMethod")) {
          value = new TestScriptRequestMethodCodeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.requestMethod = (Enumeration) value; // Enumeration<TestScriptRequestMethodCode>
        } else if (name.equals("requestURL")) {
          this.requestURL = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resource")) {
          value = new FHIRDefinedTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.resource = (Enumeration) value; // Enumeration<FHIRDefinedType>
        } else if (name.equals("response")) {
          value = new AssertionResponseTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.response = (Enumeration) value; // Enumeration<AssertionResponseTypes>
        } else if (name.equals("responseCode")) {
          this.responseCode = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("sourceId")) {
          this.sourceId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("validateProfileId")) {
          this.validateProfileId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("warningOnly")) {
          this.warningOnly = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412:  return getLabelElement();
        case -1724546052:  return getDescriptionElement();
        case -962590849:  return getDirectionElement();
        case 2081856758:  return getCompareToSourceIdElement();
        case -1415702669:  return getCompareToSourceExpressionElement();
        case -790206144:  return getCompareToSourcePathElement();
        case -389131437:  return getContentTypeElement();
        case -1795452264:  return getExpressionElement();
        case 1160732269:  return getHeaderFieldElement();
        case 818925001:  return getMinimumIdElement();
        case 1001488901:  return getNavigationLinksElement();
        case -500553564:  return getOperatorElement();
        case 3433509:  return getPathElement();
        case 1217874000:  return getRequestMethodElement();
        case 37099616:  return getRequestURLElement();
        case -341064690:  return getResourceElement();
        case -340323263:  return getResponseElement();
        case 1438723534:  return getResponseCodeElement();
        case 1746327190:  return getSourceIdElement();
        case 1555541038:  return getValidateProfileIdElement();
        case 111972721:  return getValueElement();
        case -481159832:  return getWarningOnlyElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -962590849: /*direction*/ return new String[] {"code"};
        case 2081856758: /*compareToSourceId*/ return new String[] {"string"};
        case -1415702669: /*compareToSourceExpression*/ return new String[] {"string"};
        case -790206144: /*compareToSourcePath*/ return new String[] {"string"};
        case -389131437: /*contentType*/ return new String[] {"code"};
        case -1795452264: /*expression*/ return new String[] {"string"};
        case 1160732269: /*headerField*/ return new String[] {"string"};
        case 818925001: /*minimumId*/ return new String[] {"string"};
        case 1001488901: /*navigationLinks*/ return new String[] {"boolean"};
        case -500553564: /*operator*/ return new String[] {"code"};
        case 3433509: /*path*/ return new String[] {"string"};
        case 1217874000: /*requestMethod*/ return new String[] {"code"};
        case 37099616: /*requestURL*/ return new String[] {"string"};
        case -341064690: /*resource*/ return new String[] {"code"};
        case -340323263: /*response*/ return new String[] {"code"};
        case 1438723534: /*responseCode*/ return new String[] {"string"};
        case 1746327190: /*sourceId*/ return new String[] {"id"};
        case 1555541038: /*validateProfileId*/ return new String[] {"id"};
        case 111972721: /*value*/ return new String[] {"string"};
        case -481159832: /*warningOnly*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.label");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.description");
        }
        else if (name.equals("direction")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.direction");
        }
        else if (name.equals("compareToSourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.compareToSourceId");
        }
        else if (name.equals("compareToSourceExpression")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.compareToSourceExpression");
        }
        else if (name.equals("compareToSourcePath")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.compareToSourcePath");
        }
        else if (name.equals("contentType")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.contentType");
        }
        else if (name.equals("expression")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.expression");
        }
        else if (name.equals("headerField")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.headerField");
        }
        else if (name.equals("minimumId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.minimumId");
        }
        else if (name.equals("navigationLinks")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.navigationLinks");
        }
        else if (name.equals("operator")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.operator");
        }
        else if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.path");
        }
        else if (name.equals("requestMethod")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.requestMethod");
        }
        else if (name.equals("requestURL")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.requestURL");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.resource");
        }
        else if (name.equals("response")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.response");
        }
        else if (name.equals("responseCode")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.responseCode");
        }
        else if (name.equals("sourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.sourceId");
        }
        else if (name.equals("validateProfileId")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.validateProfileId");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.value");
        }
        else if (name.equals("warningOnly")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.warningOnly");
        }
        else
          return super.addChild(name);
      }

      public SetupActionAssertComponent copy() {
        SetupActionAssertComponent dst = new SetupActionAssertComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SetupActionAssertComponent dst) {
        super.copyValues(dst);
        dst.label = label == null ? null : label.copy();
        dst.description = description == null ? null : description.copy();
        dst.direction = direction == null ? null : direction.copy();
        dst.compareToSourceId = compareToSourceId == null ? null : compareToSourceId.copy();
        dst.compareToSourceExpression = compareToSourceExpression == null ? null : compareToSourceExpression.copy();
        dst.compareToSourcePath = compareToSourcePath == null ? null : compareToSourcePath.copy();
        dst.contentType = contentType == null ? null : contentType.copy();
        dst.expression = expression == null ? null : expression.copy();
        dst.headerField = headerField == null ? null : headerField.copy();
        dst.minimumId = minimumId == null ? null : minimumId.copy();
        dst.navigationLinks = navigationLinks == null ? null : navigationLinks.copy();
        dst.operator = operator == null ? null : operator.copy();
        dst.path = path == null ? null : path.copy();
        dst.requestMethod = requestMethod == null ? null : requestMethod.copy();
        dst.requestURL = requestURL == null ? null : requestURL.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.response = response == null ? null : response.copy();
        dst.responseCode = responseCode == null ? null : responseCode.copy();
        dst.sourceId = sourceId == null ? null : sourceId.copy();
        dst.validateProfileId = validateProfileId == null ? null : validateProfileId.copy();
        dst.value = value == null ? null : value.copy();
        dst.warningOnly = warningOnly == null ? null : warningOnly.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SetupActionAssertComponent))
          return false;
        SetupActionAssertComponent o = (SetupActionAssertComponent) other_;
        return compareDeep(label, o.label, true) && compareDeep(description, o.description, true) && compareDeep(direction, o.direction, true)
           && compareDeep(compareToSourceId, o.compareToSourceId, true) && compareDeep(compareToSourceExpression, o.compareToSourceExpression, true)
           && compareDeep(compareToSourcePath, o.compareToSourcePath, true) && compareDeep(contentType, o.contentType, true)
           && compareDeep(expression, o.expression, true) && compareDeep(headerField, o.headerField, true)
           && compareDeep(minimumId, o.minimumId, true) && compareDeep(navigationLinks, o.navigationLinks, true)
           && compareDeep(operator, o.operator, true) && compareDeep(path, o.path, true) && compareDeep(requestMethod, o.requestMethod, true)
           && compareDeep(requestURL, o.requestURL, true) && compareDeep(resource, o.resource, true) && compareDeep(response, o.response, true)
           && compareDeep(responseCode, o.responseCode, true) && compareDeep(sourceId, o.sourceId, true) && compareDeep(validateProfileId, o.validateProfileId, true)
           && compareDeep(value, o.value, true) && compareDeep(warningOnly, o.warningOnly, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SetupActionAssertComponent))
          return false;
        SetupActionAssertComponent o = (SetupActionAssertComponent) other_;
        return compareValues(label, o.label, true) && compareValues(description, o.description, true) && compareValues(direction, o.direction, true)
           && compareValues(compareToSourceId, o.compareToSourceId, true) && compareValues(compareToSourceExpression, o.compareToSourceExpression, true)
           && compareValues(compareToSourcePath, o.compareToSourcePath, true) && compareValues(contentType, o.contentType, true)
           && compareValues(expression, o.expression, true) && compareValues(headerField, o.headerField, true)
           && compareValues(minimumId, o.minimumId, true) && compareValues(navigationLinks, o.navigationLinks, true)
           && compareValues(operator, o.operator, true) && compareValues(path, o.path, true) && compareValues(requestMethod, o.requestMethod, true)
           && compareValues(requestURL, o.requestURL, true) && compareValues(resource, o.resource, true) && compareValues(response, o.response, true)
           && compareValues(responseCode, o.responseCode, true) && compareValues(sourceId, o.sourceId, true) && compareValues(validateProfileId, o.validateProfileId, true)
           && compareValues(value, o.value, true) && compareValues(warningOnly, o.warningOnly, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(label, description, direction
          , compareToSourceId, compareToSourceExpression, compareToSourcePath, contentType, expression
          , headerField, minimumId, navigationLinks, operator, path, requestMethod, requestURL
          , resource, response, responseCode, sourceId, validateProfileId, value, warningOnly
          );
      }

  public String fhirType() {
    return "TestScript.setup.action.assert";

  }

  }

    @Block()
    public static class TestScriptTestComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of this test used for tracking/logging purposes by test engines.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Tracking/logging name of this test", formalDefinition="The name of this test used for tracking/logging purposes by test engines." )
        protected StringType name;

        /**
         * A short description of the test used by test engines for tracking and reporting purposes.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Tracking/reporting short description of the test", formalDefinition="A short description of the test used by test engines for tracking and reporting purposes." )
        protected StringType description;

        /**
         * Action would contain either an operation or an assertion.
         */
        @Child(name = "action", type = {}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A test operation or assert to perform", formalDefinition="Action would contain either an operation or an assertion." )
        protected List<TestActionComponent> action;

        private static final long serialVersionUID = -865006110L;

    /**
     * Constructor
     */
      public TestScriptTestComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptTestComponent(TestActionComponent action) {
        super();
        this.addAction(action);
      }

        /**
         * @return {@link #name} (The name of this test used for tracking/logging purposes by test engines.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptTestComponent.name");
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
         * @param value {@link #name} (The name of this test used for tracking/logging purposes by test engines.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TestScriptTestComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of this test used for tracking/logging purposes by test engines.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of this test used for tracking/logging purposes by test engines.
         */
        public TestScriptTestComponent setName(String value) { 
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
         * @return {@link #description} (A short description of the test used by test engines for tracking and reporting purposes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptTestComponent.description");
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
         * @param value {@link #description} (A short description of the test used by test engines for tracking and reporting purposes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestScriptTestComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A short description of the test used by test engines for tracking and reporting purposes.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A short description of the test used by test engines for tracking and reporting purposes.
         */
        public TestScriptTestComponent setDescription(String value) { 
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
         * @return {@link #action} (Action would contain either an operation or an assertion.)
         */
        public List<TestActionComponent> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<TestActionComponent>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptTestComponent setAction(List<TestActionComponent> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (TestActionComponent item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestActionComponent addAction() { //3
          TestActionComponent t = new TestActionComponent();
          if (this.action == null)
            this.action = new ArrayList<TestActionComponent>();
          this.action.add(t);
          return t;
        }

        public TestScriptTestComponent addAction(TestActionComponent t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<TestActionComponent>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public TestActionComponent getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name of this test used for tracking/logging purposes by test engines.", 0, 1, name));
          children.add(new Property("description", "string", "A short description of the test used by test engines for tracking and reporting purposes.", 0, 1, description));
          children.add(new Property("action", "", "Action would contain either an operation or an assertion.", 0, java.lang.Integer.MAX_VALUE, action));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name of this test used for tracking/logging purposes by test engines.", 0, 1, name);
          case -1724546052: /*description*/  return new Property("description", "string", "A short description of the test used by test engines for tracking and reporting purposes.", 0, 1, description);
          case -1422950858: /*action*/  return new Property("action", "", "Action would contain either an operation or an assertion.", 0, java.lang.Integer.MAX_VALUE, action);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // TestActionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1422950858: // action
          this.getAction().add((TestActionComponent) value); // TestActionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("action")) {
          this.getAction().add((TestActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case -1422950858:  return addAction(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1422950858: /*action*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.test.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.test.description");
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else
          return super.addChild(name);
      }

      public TestScriptTestComponent copy() {
        TestScriptTestComponent dst = new TestScriptTestComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptTestComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        if (action != null) {
          dst.action = new ArrayList<TestActionComponent>();
          for (TestActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptTestComponent))
          return false;
        TestScriptTestComponent o = (TestScriptTestComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(description, o.description, true) && compareDeep(action, o.action, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptTestComponent))
          return false;
        TestScriptTestComponent o = (TestScriptTestComponent) other_;
        return compareValues(name, o.name, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, description, action
          );
      }

  public String fhirType() {
    return "TestScript.test";

  }

  }

    @Block()
    public static class TestActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An operation would involve a REST request to a server.
         */
        @Child(name = "operation", type = {SetupActionOperationComponent.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The setup operation to perform", formalDefinition="An operation would involve a REST request to a server." )
        protected SetupActionOperationComponent operation;

        /**
         * Evaluates the results of previous operations to determine if the server under test behaves appropriately.
         */
        @Child(name = "assert", type = {SetupActionAssertComponent.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The setup assertion to perform", formalDefinition="Evaluates the results of previous operations to determine if the server under test behaves appropriately." )
        protected SetupActionAssertComponent assert_;

        private static final long serialVersionUID = -252088305L;

    /**
     * Constructor
     */
      public TestActionComponent() {
        super();
      }

        /**
         * @return {@link #operation} (An operation would involve a REST request to a server.)
         */
        public SetupActionOperationComponent getOperation() { 
          if (this.operation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestActionComponent.operation");
            else if (Configuration.doAutoCreate())
              this.operation = new SetupActionOperationComponent(); // cc
          return this.operation;
        }

        public boolean hasOperation() { 
          return this.operation != null && !this.operation.isEmpty();
        }

        /**
         * @param value {@link #operation} (An operation would involve a REST request to a server.)
         */
        public TestActionComponent setOperation(SetupActionOperationComponent value) { 
          this.operation = value;
          return this;
        }

        /**
         * @return {@link #assert_} (Evaluates the results of previous operations to determine if the server under test behaves appropriately.)
         */
        public SetupActionAssertComponent getAssert() { 
          if (this.assert_ == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestActionComponent.assert_");
            else if (Configuration.doAutoCreate())
              this.assert_ = new SetupActionAssertComponent(); // cc
          return this.assert_;
        }

        public boolean hasAssert() { 
          return this.assert_ != null && !this.assert_.isEmpty();
        }

        /**
         * @param value {@link #assert_} (Evaluates the results of previous operations to determine if the server under test behaves appropriately.)
         */
        public TestActionComponent setAssert(SetupActionAssertComponent value) { 
          this.assert_ = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("operation", "@TestScript.setup.action.operation", "An operation would involve a REST request to a server.", 0, 1, operation));
          children.add(new Property("assert", "@TestScript.setup.action.assert", "Evaluates the results of previous operations to determine if the server under test behaves appropriately.", 0, 1, assert_));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1662702951: /*operation*/  return new Property("operation", "@TestScript.setup.action.operation", "An operation would involve a REST request to a server.", 0, 1, operation);
          case -1408208058: /*assert*/  return new Property("assert", "@TestScript.setup.action.assert", "Evaluates the results of previous operations to determine if the server under test behaves appropriately.", 0, 1, assert_);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : new Base[] {this.operation}; // SetupActionOperationComponent
        case -1408208058: /*assert*/ return this.assert_ == null ? new Base[0] : new Base[] {this.assert_}; // SetupActionAssertComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1662702951: // operation
          this.operation = (SetupActionOperationComponent) value; // SetupActionOperationComponent
          return value;
        case -1408208058: // assert
          this.assert_ = (SetupActionAssertComponent) value; // SetupActionAssertComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("operation")) {
          this.operation = (SetupActionOperationComponent) value; // SetupActionOperationComponent
        } else if (name.equals("assert")) {
          this.assert_ = (SetupActionAssertComponent) value; // SetupActionAssertComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1662702951:  return getOperation();
        case -1408208058:  return getAssert();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1662702951: /*operation*/ return new String[] {"@TestScript.setup.action.operation"};
        case -1408208058: /*assert*/ return new String[] {"@TestScript.setup.action.assert"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("operation")) {
          this.operation = new SetupActionOperationComponent();
          return this.operation;
        }
        else if (name.equals("assert")) {
          this.assert_ = new SetupActionAssertComponent();
          return this.assert_;
        }
        else
          return super.addChild(name);
      }

      public TestActionComponent copy() {
        TestActionComponent dst = new TestActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestActionComponent dst) {
        super.copyValues(dst);
        dst.operation = operation == null ? null : operation.copy();
        dst.assert_ = assert_ == null ? null : assert_.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestActionComponent))
          return false;
        TestActionComponent o = (TestActionComponent) other_;
        return compareDeep(operation, o.operation, true) && compareDeep(assert_, o.assert_, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestActionComponent))
          return false;
        TestActionComponent o = (TestActionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(operation, assert_);
      }

  public String fhirType() {
    return "TestScript.test.action";

  }

  }

    @Block()
    public static class TestScriptTeardownComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The teardown action will only contain an operation.
         */
        @Child(name = "action", type = {}, order=1, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="One or more teardown operations to perform", formalDefinition="The teardown action will only contain an operation." )
        protected List<TeardownActionComponent> action;

        private static final long serialVersionUID = 1168638089L;

    /**
     * Constructor
     */
      public TestScriptTeardownComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptTeardownComponent(TeardownActionComponent action) {
        super();
        this.addAction(action);
      }

        /**
         * @return {@link #action} (The teardown action will only contain an operation.)
         */
        public List<TeardownActionComponent> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<TeardownActionComponent>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestScriptTeardownComponent setAction(List<TeardownActionComponent> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (TeardownActionComponent item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TeardownActionComponent addAction() { //3
          TeardownActionComponent t = new TeardownActionComponent();
          if (this.action == null)
            this.action = new ArrayList<TeardownActionComponent>();
          this.action.add(t);
          return t;
        }

        public TestScriptTeardownComponent addAction(TeardownActionComponent t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<TeardownActionComponent>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public TeardownActionComponent getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("action", "", "The teardown action will only contain an operation.", 0, java.lang.Integer.MAX_VALUE, action));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1422950858: /*action*/  return new Property("action", "", "The teardown action will only contain an operation.", 0, java.lang.Integer.MAX_VALUE, action);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // TeardownActionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1422950858: // action
          this.getAction().add((TeardownActionComponent) value); // TeardownActionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("action")) {
          this.getAction().add((TeardownActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1422950858:  return addAction(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1422950858: /*action*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("action")) {
          return addAction();
        }
        else
          return super.addChild(name);
      }

      public TestScriptTeardownComponent copy() {
        TestScriptTeardownComponent dst = new TestScriptTeardownComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptTeardownComponent dst) {
        super.copyValues(dst);
        if (action != null) {
          dst.action = new ArrayList<TeardownActionComponent>();
          for (TeardownActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptTeardownComponent))
          return false;
        TestScriptTeardownComponent o = (TestScriptTeardownComponent) other_;
        return compareDeep(action, o.action, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptTeardownComponent))
          return false;
        TestScriptTeardownComponent o = (TestScriptTeardownComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(action);
      }

  public String fhirType() {
    return "TestScript.teardown";

  }

  }

    @Block()
    public static class TeardownActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An operation would involve a REST request to a server.
         */
        @Child(name = "operation", type = {SetupActionOperationComponent.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The teardown operation to perform", formalDefinition="An operation would involve a REST request to a server." )
        protected SetupActionOperationComponent operation;

        private static final long serialVersionUID = -1099598054L;

    /**
     * Constructor
     */
      public TeardownActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TeardownActionComponent(SetupActionOperationComponent operation) {
        super();
        this.setOperation(operation);
      }

        /**
         * @return {@link #operation} (An operation would involve a REST request to a server.)
         */
        public SetupActionOperationComponent getOperation() { 
          if (this.operation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TeardownActionComponent.operation");
            else if (Configuration.doAutoCreate())
              this.operation = new SetupActionOperationComponent(); // cc
          return this.operation;
        }

        public boolean hasOperation() { 
          return this.operation != null && !this.operation.isEmpty();
        }

        /**
         * @param value {@link #operation} (An operation would involve a REST request to a server.)
         */
        public TeardownActionComponent setOperation(SetupActionOperationComponent value) { 
          this.operation = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("operation", "@TestScript.setup.action.operation", "An operation would involve a REST request to a server.", 0, 1, operation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1662702951: /*operation*/  return new Property("operation", "@TestScript.setup.action.operation", "An operation would involve a REST request to a server.", 0, 1, operation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : new Base[] {this.operation}; // SetupActionOperationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1662702951: // operation
          this.operation = (SetupActionOperationComponent) value; // SetupActionOperationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("operation")) {
          this.operation = (SetupActionOperationComponent) value; // SetupActionOperationComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1662702951:  return getOperation();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1662702951: /*operation*/ return new String[] {"@TestScript.setup.action.operation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("operation")) {
          this.operation = new SetupActionOperationComponent();
          return this.operation;
        }
        else
          return super.addChild(name);
      }

      public TeardownActionComponent copy() {
        TeardownActionComponent dst = new TeardownActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TeardownActionComponent dst) {
        super.copyValues(dst);
        dst.operation = operation == null ? null : operation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TeardownActionComponent))
          return false;
        TeardownActionComponent o = (TeardownActionComponent) other_;
        return compareDeep(operation, o.operation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TeardownActionComponent))
          return false;
        TeardownActionComponent o = (TeardownActionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(operation);
      }

  public String fhirType() {
    return "TestScript.teardown.action";

  }

  }

    /**
     * An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this test script, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the test script", formalDefinition="A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected Identifier identifier;

    /**
     * The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the test script", formalDefinition="The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this test script (computer friendly)", formalDefinition="A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the test script.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this test script (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the test script." )
    protected StringType title;

    /**
     * The status of this test script. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this test script. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the test script.
     */
    @Child(name = "publisher", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the test script." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the test script from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the test script", formalDefinition="A free text natural language description of the test script from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the test script is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for test script (if applicable)", formalDefinition="A legal or geographic region in which the test script is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this test script is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this test script is defined", formalDefinition="Explanation of why this test script is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script." )
    protected MarkdownType copyright;

    /**
     * An abstract server used in operations within this test script in the origin element.
     */
    @Child(name = "origin", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An abstract server representing a client or sender in a message exchange", formalDefinition="An abstract server used in operations within this test script in the origin element." )
    protected List<TestScriptOriginComponent> origin;

    /**
     * An abstract server used in operations within this test script in the destination element.
     */
    @Child(name = "destination", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An abstract server representing a destination or receiver in a message exchange", formalDefinition="An abstract server used in operations within this test script in the destination element." )
    protected List<TestScriptDestinationComponent> destination;

    /**
     * The required capability must exist and are assumed to function correctly on the FHIR server being tested.
     */
    @Child(name = "metadata", type = {}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Required capability that is assumed to function correctly on the FHIR server being tested", formalDefinition="The required capability must exist and are assumed to function correctly on the FHIR server being tested." )
    protected TestScriptMetadataComponent metadata;

    /**
     * Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.
     */
    @Child(name = "fixture", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Fixture in the test script - by reference (uri)", formalDefinition="Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute." )
    protected List<TestScriptFixtureComponent> fixture;

    /**
     * Reference to the profile to be used for validation.
     */
    @Child(name = "profile", type = {Reference.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reference of the validation profile", formalDefinition="Reference to the profile to be used for validation." )
    protected List<Reference> profile;

    /**
     * Variable is set based either on element value in response body or on header field value in the response headers.
     */
    @Child(name = "variable", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Placeholder for evaluated elements", formalDefinition="Variable is set based either on element value in response body or on header field value in the response headers." )
    protected List<TestScriptVariableComponent> variable;

    /**
     * A series of required setup operations before tests are executed.
     */
    @Child(name = "setup", type = {}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A series of required setup operations before tests are executed", formalDefinition="A series of required setup operations before tests are executed." )
    protected TestScriptSetupComponent setup;

    /**
     * A test in this script.
     */
    @Child(name = "test", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A test in this script", formalDefinition="A test in this script." )
    protected List<TestScriptTestComponent> test;

    /**
     * A series of operations required to clean up after all the tests are executed (successfully or otherwise).
     */
    @Child(name = "teardown", type = {}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A series of required clean up steps", formalDefinition="A series of operations required to clean up after all the tests are executed (successfully or otherwise)." )
    protected TestScriptTeardownComponent teardown;

    private static final long serialVersionUID = -2020826225L;

  /**
   * Constructor
   */
    public TestScript() {
      super();
    }

  /**
   * Constructor
   */
    public TestScript(String url, String name, PublicationStatus status) {
      super();
      this.setUrl(url);
      this.setName(name);
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public TestScript setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.
     */
    public TestScript setUrl(String value) { 
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      return this;
    }

    /**
     * only one on this implementation
     */
    @Override
    public int getIdentifierMax() { 
      return 1;
    }
    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      List<Identifier> list = new ArrayList<Identifier>();
      if (this.identifier == null) {
        list.add(identifier);
      }
      return list;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setIdentifier(List<Identifier> theIdentifier) { 
      if (theIdentifier.size() == 0) {
        this.identifier = null;
      } else if (theIdentifier.size() == 1) {
        this.identifier = theIdentifier.get(0);
      } else {
        throw new Error("Cannot have more than one TestScript.identifier");
      }
      return this;
    }

    public boolean hasIdentifier() { 
      return this.identifier != null && !this.identifier.isEmpty();
    }

    public Identifier addIdentifier() { //3
      if (this.identifier == null) {
        this.identifier = new Identifier();
      } else {
        throw new Error("Cannot have more than one TestScript.identifier");
      }
      return this.identifier;
    }

    public TestScript addIdentifier(Identifier t) { //3
      if (this.identifier == null) {
        this.identifier = t;
      } else {
        throw new Error("Cannot have more than one TestScript.identifier");
      }
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (identifier == null) {
        addIdentifier();
      }
      return identifier;
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public TestScript setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public TestScript setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.name");
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
     * @param value {@link #name} (A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public TestScript setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public TestScript setName(String value) { 
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the test script.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the test script.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public TestScript setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the test script.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the test script.
     */
    public TestScript setTitle(String value) { 
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
     * @return {@link #status} (The status of this test script. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.status");
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
     * @param value {@link #status} (The status of this test script. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public TestScript setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this test script. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this test script. Enables tracking the life-cycle of the content.
     */
    public TestScript setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public TestScript setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public TestScript setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public TestScript setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.
     */
    public TestScript setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual that published the test script.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual that published the test script.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public TestScript setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the test script.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the test script.
     */
    public TestScript setPublisher(String value) { 
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
    public TestScript setContact(List<ContactDetail> theContact) { 
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

    public TestScript addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the test script from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.description");
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
     * @param value {@link #description} (A free text natural language description of the test script from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public TestScript setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the test script from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the test script from a consumer's perspective.
     */
    public TestScript setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setUseContext(List<UsageContext> theUseContext) { 
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

    public TestScript addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the test script is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public TestScript addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explanation of why this test script is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.purpose");
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
     * @param value {@link #purpose} (Explanation of why this test script is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public TestScript setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this test script is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this test script is needed and why it has been designed as it has.
     */
    public TestScript setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public TestScript setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.
     */
    public TestScript setCopyright(String value) { 
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
     * @return {@link #origin} (An abstract server used in operations within this test script in the origin element.)
     */
    public List<TestScriptOriginComponent> getOrigin() { 
      if (this.origin == null)
        this.origin = new ArrayList<TestScriptOriginComponent>();
      return this.origin;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setOrigin(List<TestScriptOriginComponent> theOrigin) { 
      this.origin = theOrigin;
      return this;
    }

    public boolean hasOrigin() { 
      if (this.origin == null)
        return false;
      for (TestScriptOriginComponent item : this.origin)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestScriptOriginComponent addOrigin() { //3
      TestScriptOriginComponent t = new TestScriptOriginComponent();
      if (this.origin == null)
        this.origin = new ArrayList<TestScriptOriginComponent>();
      this.origin.add(t);
      return t;
    }

    public TestScript addOrigin(TestScriptOriginComponent t) { //3
      if (t == null)
        return this;
      if (this.origin == null)
        this.origin = new ArrayList<TestScriptOriginComponent>();
      this.origin.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #origin}, creating it if it does not already exist {3}
     */
    public TestScriptOriginComponent getOriginFirstRep() { 
      if (getOrigin().isEmpty()) {
        addOrigin();
      }
      return getOrigin().get(0);
    }

    /**
     * @return {@link #destination} (An abstract server used in operations within this test script in the destination element.)
     */
    public List<TestScriptDestinationComponent> getDestination() { 
      if (this.destination == null)
        this.destination = new ArrayList<TestScriptDestinationComponent>();
      return this.destination;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setDestination(List<TestScriptDestinationComponent> theDestination) { 
      this.destination = theDestination;
      return this;
    }

    public boolean hasDestination() { 
      if (this.destination == null)
        return false;
      for (TestScriptDestinationComponent item : this.destination)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestScriptDestinationComponent addDestination() { //3
      TestScriptDestinationComponent t = new TestScriptDestinationComponent();
      if (this.destination == null)
        this.destination = new ArrayList<TestScriptDestinationComponent>();
      this.destination.add(t);
      return t;
    }

    public TestScript addDestination(TestScriptDestinationComponent t) { //3
      if (t == null)
        return this;
      if (this.destination == null)
        this.destination = new ArrayList<TestScriptDestinationComponent>();
      this.destination.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #destination}, creating it if it does not already exist {3}
     */
    public TestScriptDestinationComponent getDestinationFirstRep() { 
      if (getDestination().isEmpty()) {
        addDestination();
      }
      return getDestination().get(0);
    }

    /**
     * @return {@link #metadata} (The required capability must exist and are assumed to function correctly on the FHIR server being tested.)
     */
    public TestScriptMetadataComponent getMetadata() { 
      if (this.metadata == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.metadata");
        else if (Configuration.doAutoCreate())
          this.metadata = new TestScriptMetadataComponent(); // cc
      return this.metadata;
    }

    public boolean hasMetadata() { 
      return this.metadata != null && !this.metadata.isEmpty();
    }

    /**
     * @param value {@link #metadata} (The required capability must exist and are assumed to function correctly on the FHIR server being tested.)
     */
    public TestScript setMetadata(TestScriptMetadataComponent value) { 
      this.metadata = value;
      return this;
    }

    /**
     * @return {@link #fixture} (Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.)
     */
    public List<TestScriptFixtureComponent> getFixture() { 
      if (this.fixture == null)
        this.fixture = new ArrayList<TestScriptFixtureComponent>();
      return this.fixture;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setFixture(List<TestScriptFixtureComponent> theFixture) { 
      this.fixture = theFixture;
      return this;
    }

    public boolean hasFixture() { 
      if (this.fixture == null)
        return false;
      for (TestScriptFixtureComponent item : this.fixture)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestScriptFixtureComponent addFixture() { //3
      TestScriptFixtureComponent t = new TestScriptFixtureComponent();
      if (this.fixture == null)
        this.fixture = new ArrayList<TestScriptFixtureComponent>();
      this.fixture.add(t);
      return t;
    }

    public TestScript addFixture(TestScriptFixtureComponent t) { //3
      if (t == null)
        return this;
      if (this.fixture == null)
        this.fixture = new ArrayList<TestScriptFixtureComponent>();
      this.fixture.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #fixture}, creating it if it does not already exist {3}
     */
    public TestScriptFixtureComponent getFixtureFirstRep() { 
      if (getFixture().isEmpty()) {
        addFixture();
      }
      return getFixture().get(0);
    }

    /**
     * @return {@link #profile} (Reference to the profile to be used for validation.)
     */
    public List<Reference> getProfile() { 
      if (this.profile == null)
        this.profile = new ArrayList<Reference>();
      return this.profile;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setProfile(List<Reference> theProfile) { 
      this.profile = theProfile;
      return this;
    }

    public boolean hasProfile() { 
      if (this.profile == null)
        return false;
      for (Reference item : this.profile)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addProfile() { //3
      Reference t = new Reference();
      if (this.profile == null)
        this.profile = new ArrayList<Reference>();
      this.profile.add(t);
      return t;
    }

    public TestScript addProfile(Reference t) { //3
      if (t == null)
        return this;
      if (this.profile == null)
        this.profile = new ArrayList<Reference>();
      this.profile.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #profile}, creating it if it does not already exist {3}
     */
    public Reference getProfileFirstRep() { 
      if (getProfile().isEmpty()) {
        addProfile();
      }
      return getProfile().get(0);
    }

    /**
     * @return {@link #variable} (Variable is set based either on element value in response body or on header field value in the response headers.)
     */
    public List<TestScriptVariableComponent> getVariable() { 
      if (this.variable == null)
        this.variable = new ArrayList<TestScriptVariableComponent>();
      return this.variable;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setVariable(List<TestScriptVariableComponent> theVariable) { 
      this.variable = theVariable;
      return this;
    }

    public boolean hasVariable() { 
      if (this.variable == null)
        return false;
      for (TestScriptVariableComponent item : this.variable)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestScriptVariableComponent addVariable() { //3
      TestScriptVariableComponent t = new TestScriptVariableComponent();
      if (this.variable == null)
        this.variable = new ArrayList<TestScriptVariableComponent>();
      this.variable.add(t);
      return t;
    }

    public TestScript addVariable(TestScriptVariableComponent t) { //3
      if (t == null)
        return this;
      if (this.variable == null)
        this.variable = new ArrayList<TestScriptVariableComponent>();
      this.variable.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #variable}, creating it if it does not already exist {3}
     */
    public TestScriptVariableComponent getVariableFirstRep() { 
      if (getVariable().isEmpty()) {
        addVariable();
      }
      return getVariable().get(0);
    }

    /**
     * @return {@link #setup} (A series of required setup operations before tests are executed.)
     */
    public TestScriptSetupComponent getSetup() { 
      if (this.setup == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.setup");
        else if (Configuration.doAutoCreate())
          this.setup = new TestScriptSetupComponent(); // cc
      return this.setup;
    }

    public boolean hasSetup() { 
      return this.setup != null && !this.setup.isEmpty();
    }

    /**
     * @param value {@link #setup} (A series of required setup operations before tests are executed.)
     */
    public TestScript setSetup(TestScriptSetupComponent value) { 
      this.setup = value;
      return this;
    }

    /**
     * @return {@link #test} (A test in this script.)
     */
    public List<TestScriptTestComponent> getTest() { 
      if (this.test == null)
        this.test = new ArrayList<TestScriptTestComponent>();
      return this.test;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setTest(List<TestScriptTestComponent> theTest) { 
      this.test = theTest;
      return this;
    }

    public boolean hasTest() { 
      if (this.test == null)
        return false;
      for (TestScriptTestComponent item : this.test)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestScriptTestComponent addTest() { //3
      TestScriptTestComponent t = new TestScriptTestComponent();
      if (this.test == null)
        this.test = new ArrayList<TestScriptTestComponent>();
      this.test.add(t);
      return t;
    }

    public TestScript addTest(TestScriptTestComponent t) { //3
      if (t == null)
        return this;
      if (this.test == null)
        this.test = new ArrayList<TestScriptTestComponent>();
      this.test.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #test}, creating it if it does not already exist {3}
     */
    public TestScriptTestComponent getTestFirstRep() { 
      if (getTest().isEmpty()) {
        addTest();
      }
      return getTest().get(0);
    }

    /**
     * @return {@link #teardown} (A series of operations required to clean up after all the tests are executed (successfully or otherwise).)
     */
    public TestScriptTeardownComponent getTeardown() { 
      if (this.teardown == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestScript.teardown");
        else if (Configuration.doAutoCreate())
          this.teardown = new TestScriptTeardownComponent(); // cc
      return this.teardown;
    }

    public boolean hasTeardown() { 
      return this.teardown != null && !this.teardown.isEmpty();
    }

    /**
     * @param value {@link #teardown} (A series of operations required to clean up after all the tests are executed (successfully or otherwise).)
     */
    public TestScript setTeardown(TestScriptTeardownComponent value) { 
      this.teardown = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, 1, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the test script.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this test script. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the test script.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the test script from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the test script is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this test script is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.", 0, 1, copyright));
        children.add(new Property("origin", "", "An abstract server used in operations within this test script in the origin element.", 0, java.lang.Integer.MAX_VALUE, origin));
        children.add(new Property("destination", "", "An abstract server used in operations within this test script in the destination element.", 0, java.lang.Integer.MAX_VALUE, destination));
        children.add(new Property("metadata", "", "The required capability must exist and are assumed to function correctly on the FHIR server being tested.", 0, 1, metadata));
        children.add(new Property("fixture", "", "Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.", 0, java.lang.Integer.MAX_VALUE, fixture));
        children.add(new Property("profile", "Reference(Any)", "Reference to the profile to be used for validation.", 0, java.lang.Integer.MAX_VALUE, profile));
        children.add(new Property("variable", "", "Variable is set based either on element value in response body or on header field value in the response headers.", 0, java.lang.Integer.MAX_VALUE, variable));
        children.add(new Property("setup", "", "A series of required setup operations before tests are executed.", 0, 1, setup));
        children.add(new Property("test", "", "A test in this script.", 0, java.lang.Integer.MAX_VALUE, test));
        children.add(new Property("teardown", "", "A series of operations required to clean up after all the tests are executed (successfully or otherwise).", 0, 1, teardown));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, 1, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the test script.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this test script. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the test script was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the test script.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the test script from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the test script is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this test script is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.", 0, 1, copyright);
        case -1008619738: /*origin*/  return new Property("origin", "", "An abstract server used in operations within this test script in the origin element.", 0, java.lang.Integer.MAX_VALUE, origin);
        case -1429847026: /*destination*/  return new Property("destination", "", "An abstract server used in operations within this test script in the destination element.", 0, java.lang.Integer.MAX_VALUE, destination);
        case -450004177: /*metadata*/  return new Property("metadata", "", "The required capability must exist and are assumed to function correctly on the FHIR server being tested.", 0, 1, metadata);
        case -843449847: /*fixture*/  return new Property("fixture", "", "Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.", 0, java.lang.Integer.MAX_VALUE, fixture);
        case -309425751: /*profile*/  return new Property("profile", "Reference(Any)", "Reference to the profile to be used for validation.", 0, java.lang.Integer.MAX_VALUE, profile);
        case -1249586564: /*variable*/  return new Property("variable", "", "Variable is set based either on element value in response body or on header field value in the response headers.", 0, java.lang.Integer.MAX_VALUE, variable);
        case 109329021: /*setup*/  return new Property("setup", "", "A series of required setup operations before tests are executed.", 0, 1, setup);
        case 3556498: /*test*/  return new Property("test", "", "A test in this script.", 0, java.lang.Integer.MAX_VALUE, test);
        case -1663474172: /*teardown*/  return new Property("teardown", "", "A series of operations required to clean up after all the tests are executed (successfully or otherwise).", 0, 1, teardown);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
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
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : this.origin.toArray(new Base[this.origin.size()]); // TestScriptOriginComponent
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : this.destination.toArray(new Base[this.destination.size()]); // TestScriptDestinationComponent
        case -450004177: /*metadata*/ return this.metadata == null ? new Base[0] : new Base[] {this.metadata}; // TestScriptMetadataComponent
        case -843449847: /*fixture*/ return this.fixture == null ? new Base[0] : this.fixture.toArray(new Base[this.fixture.size()]); // TestScriptFixtureComponent
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : this.profile.toArray(new Base[this.profile.size()]); // Reference
        case -1249586564: /*variable*/ return this.variable == null ? new Base[0] : this.variable.toArray(new Base[this.variable.size()]); // TestScriptVariableComponent
        case 109329021: /*setup*/ return this.setup == null ? new Base[0] : new Base[] {this.setup}; // TestScriptSetupComponent
        case 3556498: /*test*/ return this.test == null ? new Base[0] : this.test.toArray(new Base[this.test.size()]); // TestScriptTestComponent
        case -1663474172: /*teardown*/ return this.teardown == null ? new Base[0] : new Base[] {this.teardown}; // TestScriptTeardownComponent
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
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
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
        case -1008619738: // origin
          this.getOrigin().add((TestScriptOriginComponent) value); // TestScriptOriginComponent
          return value;
        case -1429847026: // destination
          this.getDestination().add((TestScriptDestinationComponent) value); // TestScriptDestinationComponent
          return value;
        case -450004177: // metadata
          this.metadata = (TestScriptMetadataComponent) value; // TestScriptMetadataComponent
          return value;
        case -843449847: // fixture
          this.getFixture().add((TestScriptFixtureComponent) value); // TestScriptFixtureComponent
          return value;
        case -309425751: // profile
          this.getProfile().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1249586564: // variable
          this.getVariable().add((TestScriptVariableComponent) value); // TestScriptVariableComponent
          return value;
        case 109329021: // setup
          this.setup = (TestScriptSetupComponent) value; // TestScriptSetupComponent
          return value;
        case 3556498: // test
          this.getTest().add((TestScriptTestComponent) value); // TestScriptTestComponent
          return value;
        case -1663474172: // teardown
          this.teardown = (TestScriptTeardownComponent) value; // TestScriptTeardownComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
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
        } else if (name.equals("origin")) {
          this.getOrigin().add((TestScriptOriginComponent) value);
        } else if (name.equals("destination")) {
          this.getDestination().add((TestScriptDestinationComponent) value);
        } else if (name.equals("metadata")) {
          this.metadata = (TestScriptMetadataComponent) value; // TestScriptMetadataComponent
        } else if (name.equals("fixture")) {
          this.getFixture().add((TestScriptFixtureComponent) value);
        } else if (name.equals("profile")) {
          this.getProfile().add(TypeConvertor.castToReference(value));
        } else if (name.equals("variable")) {
          this.getVariable().add((TestScriptVariableComponent) value);
        } else if (name.equals("setup")) {
          this.setup = (TestScriptSetupComponent) value; // TestScriptSetupComponent
        } else if (name.equals("test")) {
          this.getTest().add((TestScriptTestComponent) value);
        } else if (name.equals("teardown")) {
          this.teardown = (TestScriptTeardownComponent) value; // TestScriptTeardownComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return getIdentifierFirstRep();
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
        case -1008619738:  return addOrigin(); 
        case -1429847026:  return addDestination(); 
        case -450004177:  return getMetadata();
        case -843449847:  return addFixture(); 
        case -309425751:  return addProfile(); 
        case -1249586564:  return addVariable(); 
        case 109329021:  return getSetup();
        case 3556498:  return addTest(); 
        case -1663474172:  return getTeardown();
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
        case -1008619738: /*origin*/ return new String[] {};
        case -1429847026: /*destination*/ return new String[] {};
        case -450004177: /*metadata*/ return new String[] {};
        case -843449847: /*fixture*/ return new String[] {};
        case -309425751: /*profile*/ return new String[] {"Reference"};
        case -1249586564: /*variable*/ return new String[] {};
        case 109329021: /*setup*/ return new String[] {};
        case 3556498: /*test*/ return new String[] {};
        case -1663474172: /*teardown*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.url");
        }
        else if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.copyright");
        }
        else if (name.equals("origin")) {
          return addOrigin();
        }
        else if (name.equals("destination")) {
          return addDestination();
        }
        else if (name.equals("metadata")) {
          this.metadata = new TestScriptMetadataComponent();
          return this.metadata;
        }
        else if (name.equals("fixture")) {
          return addFixture();
        }
        else if (name.equals("profile")) {
          return addProfile();
        }
        else if (name.equals("variable")) {
          return addVariable();
        }
        else if (name.equals("setup")) {
          this.setup = new TestScriptSetupComponent();
          return this.setup;
        }
        else if (name.equals("test")) {
          return addTest();
        }
        else if (name.equals("teardown")) {
          this.teardown = new TestScriptTeardownComponent();
          return this.teardown;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "TestScript";

  }

      public TestScript copy() {
        TestScript dst = new TestScript();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScript dst) {
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
        if (origin != null) {
          dst.origin = new ArrayList<TestScriptOriginComponent>();
          for (TestScriptOriginComponent i : origin)
            dst.origin.add(i.copy());
        };
        if (destination != null) {
          dst.destination = new ArrayList<TestScriptDestinationComponent>();
          for (TestScriptDestinationComponent i : destination)
            dst.destination.add(i.copy());
        };
        dst.metadata = metadata == null ? null : metadata.copy();
        if (fixture != null) {
          dst.fixture = new ArrayList<TestScriptFixtureComponent>();
          for (TestScriptFixtureComponent i : fixture)
            dst.fixture.add(i.copy());
        };
        if (profile != null) {
          dst.profile = new ArrayList<Reference>();
          for (Reference i : profile)
            dst.profile.add(i.copy());
        };
        if (variable != null) {
          dst.variable = new ArrayList<TestScriptVariableComponent>();
          for (TestScriptVariableComponent i : variable)
            dst.variable.add(i.copy());
        };
        dst.setup = setup == null ? null : setup.copy();
        if (test != null) {
          dst.test = new ArrayList<TestScriptTestComponent>();
          for (TestScriptTestComponent i : test)
            dst.test.add(i.copy());
        };
        dst.teardown = teardown == null ? null : teardown.copy();
      }

      protected TestScript typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScript))
          return false;
        TestScript o = (TestScript) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(status, o.status, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(origin, o.origin, true) && compareDeep(destination, o.destination, true) && compareDeep(metadata, o.metadata, true)
           && compareDeep(fixture, o.fixture, true) && compareDeep(profile, o.profile, true) && compareDeep(variable, o.variable, true)
           && compareDeep(setup, o.setup, true) && compareDeep(test, o.test, true) && compareDeep(teardown, o.teardown, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScript))
          return false;
        TestScript o = (TestScript) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, status, experimental, date, publisher, contact, description, useContext
          , jurisdiction, purpose, copyright, origin, destination, metadata, fixture, profile
          , variable, setup, test, teardown);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.TestScript;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the test script</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the test script", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the test script</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the test script</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>TestScript.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="TestScript.useContext", description="A use context type and quantity- or range-based value assigned to the test script", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the test script</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>TestScript.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the test script</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>TestScript.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="TestScript.useContext", description="A use context type and value assigned to the test script", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the test script</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>TestScript.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="TestScript.useContext.code", description="A type of use context assigned to the test script", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(TestScript.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(TestScript.useContext.value as CodeableConcept)", description="A use context assigned to the test script", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(TestScript.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The test script publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>TestScript.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="TestScript.date", description="The test script publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The test script publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>TestScript.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="TestScript.description", description="The description of the test script", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="TestScript.identifier", description="External identifier for the test script", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="TestScript.jurisdiction", description="Intended jurisdiction for the test script", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="TestScript.name", description="Computationally friendly name of the test script", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="TestScript.publisher", description="Name of the publisher of the test script", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="TestScript.status", description="The current status of the test script", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>testscript-capability</b>
   * <p>
   * Description: <b>TestScript required and validated capability</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.metadata.capability.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="testscript-capability", path="TestScript.metadata.capability.description", description="TestScript required and validated capability", type="string" )
  public static final String SP_TESTSCRIPT_CAPABILITY = "testscript-capability";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>testscript-capability</b>
   * <p>
   * Description: <b>TestScript required and validated capability</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.metadata.capability.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TESTSCRIPT_CAPABILITY = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TESTSCRIPT_CAPABILITY);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="TestScript.title", description="The human-friendly name of the test script", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the test script</b><br>
   * Type: <b>string</b><br>
   * Path: <b>TestScript.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the test script</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>TestScript.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="TestScript.url", description="The uri that identifies the test script", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the test script</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>TestScript.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="TestScript.version", description="The business version of the test script", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the test script</b><br>
   * Type: <b>token</b><br>
   * Path: <b>TestScript.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}