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
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case RESPONSE: return "http://hl7.org/fhir/assert-direction-codes";
            case REQUEST: return "http://hl7.org/fhir/assert-direction-codes";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case RESPONSE: return "The assertion is evaluated on the response. This is the default value.";
            case REQUEST: return "The assertion is evaluated on the request.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RESPONSE: return "response";
            case REQUEST: return "request";
            case NULL: return null;
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
        public Enumeration<AssertionDirectionType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionDirectionType>(this, AssertionDirectionType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<AssertionDirectionType>(this, AssertionDirectionType.NULL, code);
        if ("response".equals(codeString))
          return new Enumeration<AssertionDirectionType>(this, AssertionDirectionType.RESPONSE, code);
        if ("request".equals(codeString))
          return new Enumeration<AssertionDirectionType>(this, AssertionDirectionType.REQUEST, code);
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

    public enum AssertionManualCompletionType {
        /**
         * Mark the currently waiting test failed and proceed with the next assert if the stopTestOnFail is false or the next test in the TestScript if the stopTestOnFail is true.
         */
        FAIL, 
        /**
         * Mark the currently waiting test passed (if the test is not failed already) and proceed with the next action in the TestScript.
         */
        PASS, 
        /**
         * Mark this assert as skipped and proceed with the next action in the TestScript.
         */
        SKIP, 
        /**
         * Stop execution of this TestScript. The overall status of this TestScript is evaluated based on the status of the completed tests.
         */
        STOP, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AssertionManualCompletionType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("fail".equals(codeString))
          return FAIL;
        if ("pass".equals(codeString))
          return PASS;
        if ("skip".equals(codeString))
          return SKIP;
        if ("stop".equals(codeString))
          return STOP;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AssertionManualCompletionType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case FAIL: return "fail";
            case PASS: return "pass";
            case SKIP: return "skip";
            case STOP: return "stop";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case FAIL: return "http://hl7.org/fhir/assert-manual-completion-codes";
            case PASS: return "http://hl7.org/fhir/assert-manual-completion-codes";
            case SKIP: return "http://hl7.org/fhir/assert-manual-completion-codes";
            case STOP: return "http://hl7.org/fhir/assert-manual-completion-codes";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case FAIL: return "Mark the currently waiting test failed and proceed with the next assert if the stopTestOnFail is false or the next test in the TestScript if the stopTestOnFail is true.";
            case PASS: return "Mark the currently waiting test passed (if the test is not failed already) and proceed with the next action in the TestScript.";
            case SKIP: return "Mark this assert as skipped and proceed with the next action in the TestScript.";
            case STOP: return "Stop execution of this TestScript. The overall status of this TestScript is evaluated based on the status of the completed tests.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case FAIL: return "Fail";
            case PASS: return "Pass";
            case SKIP: return "Skip";
            case STOP: return "Stop";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AssertionManualCompletionTypeEnumFactory implements EnumFactory<AssertionManualCompletionType> {
    public AssertionManualCompletionType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("fail".equals(codeString))
          return AssertionManualCompletionType.FAIL;
        if ("pass".equals(codeString))
          return AssertionManualCompletionType.PASS;
        if ("skip".equals(codeString))
          return AssertionManualCompletionType.SKIP;
        if ("stop".equals(codeString))
          return AssertionManualCompletionType.STOP;
        throw new IllegalArgumentException("Unknown AssertionManualCompletionType code '"+codeString+"'");
        }
        public Enumeration<AssertionManualCompletionType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionManualCompletionType>(this, AssertionManualCompletionType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<AssertionManualCompletionType>(this, AssertionManualCompletionType.NULL, code);
        if ("fail".equals(codeString))
          return new Enumeration<AssertionManualCompletionType>(this, AssertionManualCompletionType.FAIL, code);
        if ("pass".equals(codeString))
          return new Enumeration<AssertionManualCompletionType>(this, AssertionManualCompletionType.PASS, code);
        if ("skip".equals(codeString))
          return new Enumeration<AssertionManualCompletionType>(this, AssertionManualCompletionType.SKIP, code);
        if ("stop".equals(codeString))
          return new Enumeration<AssertionManualCompletionType>(this, AssertionManualCompletionType.STOP, code);
        throw new FHIRException("Unknown AssertionManualCompletionType code '"+codeString+"'");
        }
    public String toCode(AssertionManualCompletionType code) {
      if (code == AssertionManualCompletionType.FAIL)
        return "fail";
      if (code == AssertionManualCompletionType.PASS)
        return "pass";
      if (code == AssertionManualCompletionType.SKIP)
        return "skip";
      if (code == AssertionManualCompletionType.STOP)
        return "stop";
      return "?";
      }
    public String toSystem(AssertionManualCompletionType code) {
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
         * Manually evaluate the condition described by this assert. The test engine SHALL pause and provide an input mechanism to set the outcome of this assert to 'pass', 'fail', 'skip' or 'stop'.
         */
        MANUALEVAL, 
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
        if ("manualEval".equals(codeString))
          return MANUALEVAL;
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
            case MANUALEVAL: return "manualEval";
            case NULL: return null;
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
            case MANUALEVAL: return "http://hl7.org/fhir/assert-operator-codes";
            case NULL: return null;
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
            case MANUALEVAL: return "Manually evaluate the condition described by this assert. The test engine SHALL pause and provide an input mechanism to set the outcome of this assert to 'pass', 'fail', 'skip' or 'stop'.";
            case NULL: return null;
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
            case MANUALEVAL: return "manualEvaluate";
            case NULL: return null;
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
        if ("manualEval".equals(codeString))
          return AssertionOperatorType.MANUALEVAL;
        throw new IllegalArgumentException("Unknown AssertionOperatorType code '"+codeString+"'");
        }
        public Enumeration<AssertionOperatorType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NULL, code);
        if ("equals".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.EQUALS, code);
        if ("notEquals".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTEQUALS, code);
        if ("in".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.IN, code);
        if ("notIn".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTIN, code);
        if ("greaterThan".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.GREATERTHAN, code);
        if ("lessThan".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.LESSTHAN, code);
        if ("empty".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.EMPTY, code);
        if ("notEmpty".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTEMPTY, code);
        if ("contains".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.CONTAINS, code);
        if ("notContains".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.NOTCONTAINS, code);
        if ("eval".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.EVAL, code);
        if ("manualEval".equals(codeString))
          return new Enumeration<AssertionOperatorType>(this, AssertionOperatorType.MANUALEVAL, code);
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
      if (code == AssertionOperatorType.MANUALEVAL)
        return "manualEval";
      return "?";
      }
    public String toSystem(AssertionOperatorType code) {
      return code.getSystem();
      }
    }

    public enum AssertionResponseTypes {
        /**
         * Response code is 100.
         */
        CONTINUE, 
        /**
         * Response code is 101.
         */
        SWITCHINGPROTOCOLS, 
        /**
         * Response code is 200.
         */
        OKAY, 
        /**
         * Response code is 201.
         */
        CREATED, 
        /**
         * Response code is 202.
         */
        ACCEPTED, 
        /**
         * Response code is 203.
         */
        NONAUTHORITATIVEINFORMATION, 
        /**
         * Response code is 204.
         */
        NOCONTENT, 
        /**
         * Response code is 205.
         */
        RESETCONTENT, 
        /**
         * Response code is 206.
         */
        PARTIALCONTENT, 
        /**
         * Response code is 300.
         */
        MULTIPLECHOICES, 
        /**
         * Response code is 301.
         */
        MOVEDPERMANENTLY, 
        /**
         * Response code is 302.
         */
        FOUND, 
        /**
         * Response code is 303.
         */
        SEEOTHER, 
        /**
         * Response code is 304.
         */
        NOTMODIFIED, 
        /**
         * Response code is 305.
         */
        USEPROXY, 
        /**
         * Response code is 307.
         */
        TEMPORARYREDIRECT, 
        /**
         * Response code is 308.
         */
        PERMANENTREDIRECT, 
        /**
         * Response code is 400.
         */
        BADREQUEST, 
        /**
         * Response code is 401.
         */
        UNAUTHORIZED, 
        /**
         * Response code is 402.
         */
        PAYMENTREQUIRED, 
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
         * Response code is 406.
         */
        NOTACCEPTABLE, 
        /**
         * Response code is 407.
         */
        PROXYAUTHENTICATIONREQUIRED, 
        /**
         * Response code is 408.
         */
        REQUESTTIMEOUT, 
        /**
         * Response code is 409.
         */
        CONFLICT, 
        /**
         * Response code is 410.
         */
        GONE, 
        /**
         * Response code is 411.
         */
        LENGTHREQUIRED, 
        /**
         * Response code is 412.
         */
        PRECONDITIONFAILED, 
        /**
         * Response code is 413.
         */
        CONTENTTOOLARGE, 
        /**
         * Response code is 414.
         */
        URITOOLONG, 
        /**
         * Response code is 415.
         */
        UNSUPPORTEDMEDIATYPE, 
        /**
         * Response code is 416.
         */
        RANGENOTSATISFIABLE, 
        /**
         * Response code is 417.
         */
        EXPECTATIONFAILED, 
        /**
         * Response code is 421.
         */
        MISDIRECTEDREQUEST, 
        /**
         * Response code is 422.
         */
        UNPROCESSABLECONTENT, 
        /**
         * Response code is 426.
         */
        UPGRADEREQUIRED, 
        /**
         * Response code is 500.
         */
        INTERNALSERVERERROR, 
        /**
         * Response code is 501.
         */
        NOTIMPLEMENTED, 
        /**
         * Response code is 502.
         */
        BADGATEWAY, 
        /**
         * Response code is 503.
         */
        SERVICEUNAVAILABLE, 
        /**
         * Response code is 504.
         */
        GATEWAYTIMEOUT, 
        /**
         * Response code is 505.
         */
        HTTPVERSIONNOTSUPPORTED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AssertionResponseTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("continue".equals(codeString))
          return CONTINUE;
        if ("switchingProtocols".equals(codeString))
          return SWITCHINGPROTOCOLS;
        if ("okay".equals(codeString))
          return OKAY;
        if ("created".equals(codeString))
          return CREATED;
        if ("accepted".equals(codeString))
          return ACCEPTED;
        if ("nonAuthoritativeInformation".equals(codeString))
          return NONAUTHORITATIVEINFORMATION;
        if ("noContent".equals(codeString))
          return NOCONTENT;
        if ("resetContent".equals(codeString))
          return RESETCONTENT;
        if ("partialContent".equals(codeString))
          return PARTIALCONTENT;
        if ("multipleChoices".equals(codeString))
          return MULTIPLECHOICES;
        if ("movedPermanently".equals(codeString))
          return MOVEDPERMANENTLY;
        if ("found".equals(codeString))
          return FOUND;
        if ("seeOther".equals(codeString))
          return SEEOTHER;
        if ("notModified".equals(codeString))
          return NOTMODIFIED;
        if ("useProxy".equals(codeString))
          return USEPROXY;
        if ("temporaryRedirect".equals(codeString))
          return TEMPORARYREDIRECT;
        if ("permanentRedirect".equals(codeString))
          return PERMANENTREDIRECT;
        if ("badRequest".equals(codeString))
          return BADREQUEST;
        if ("unauthorized".equals(codeString))
          return UNAUTHORIZED;
        if ("paymentRequired".equals(codeString))
          return PAYMENTREQUIRED;
        if ("forbidden".equals(codeString))
          return FORBIDDEN;
        if ("notFound".equals(codeString))
          return NOTFOUND;
        if ("methodNotAllowed".equals(codeString))
          return METHODNOTALLOWED;
        if ("notAcceptable".equals(codeString))
          return NOTACCEPTABLE;
        if ("proxyAuthenticationRequired".equals(codeString))
          return PROXYAUTHENTICATIONREQUIRED;
        if ("requestTimeout".equals(codeString))
          return REQUESTTIMEOUT;
        if ("conflict".equals(codeString))
          return CONFLICT;
        if ("gone".equals(codeString))
          return GONE;
        if ("lengthRequired".equals(codeString))
          return LENGTHREQUIRED;
        if ("preconditionFailed".equals(codeString))
          return PRECONDITIONFAILED;
        if ("contentTooLarge".equals(codeString))
          return CONTENTTOOLARGE;
        if ("uriTooLong".equals(codeString))
          return URITOOLONG;
        if ("unsupportedMediaType".equals(codeString))
          return UNSUPPORTEDMEDIATYPE;
        if ("rangeNotSatisfiable".equals(codeString))
          return RANGENOTSATISFIABLE;
        if ("expectationFailed".equals(codeString))
          return EXPECTATIONFAILED;
        if ("misdirectedRequest".equals(codeString))
          return MISDIRECTEDREQUEST;
        if ("unprocessableContent".equals(codeString))
          return UNPROCESSABLECONTENT;
        if ("upgradeRequired".equals(codeString))
          return UPGRADEREQUIRED;
        if ("internalServerError".equals(codeString))
          return INTERNALSERVERERROR;
        if ("notImplemented".equals(codeString))
          return NOTIMPLEMENTED;
        if ("badGateway".equals(codeString))
          return BADGATEWAY;
        if ("serviceUnavailable".equals(codeString))
          return SERVICEUNAVAILABLE;
        if ("gatewayTimeout".equals(codeString))
          return GATEWAYTIMEOUT;
        if ("httpVersionNotSupported".equals(codeString))
          return HTTPVERSIONNOTSUPPORTED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AssertionResponseTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CONTINUE: return "continue";
            case SWITCHINGPROTOCOLS: return "switchingProtocols";
            case OKAY: return "okay";
            case CREATED: return "created";
            case ACCEPTED: return "accepted";
            case NONAUTHORITATIVEINFORMATION: return "nonAuthoritativeInformation";
            case NOCONTENT: return "noContent";
            case RESETCONTENT: return "resetContent";
            case PARTIALCONTENT: return "partialContent";
            case MULTIPLECHOICES: return "multipleChoices";
            case MOVEDPERMANENTLY: return "movedPermanently";
            case FOUND: return "found";
            case SEEOTHER: return "seeOther";
            case NOTMODIFIED: return "notModified";
            case USEPROXY: return "useProxy";
            case TEMPORARYREDIRECT: return "temporaryRedirect";
            case PERMANENTREDIRECT: return "permanentRedirect";
            case BADREQUEST: return "badRequest";
            case UNAUTHORIZED: return "unauthorized";
            case PAYMENTREQUIRED: return "paymentRequired";
            case FORBIDDEN: return "forbidden";
            case NOTFOUND: return "notFound";
            case METHODNOTALLOWED: return "methodNotAllowed";
            case NOTACCEPTABLE: return "notAcceptable";
            case PROXYAUTHENTICATIONREQUIRED: return "proxyAuthenticationRequired";
            case REQUESTTIMEOUT: return "requestTimeout";
            case CONFLICT: return "conflict";
            case GONE: return "gone";
            case LENGTHREQUIRED: return "lengthRequired";
            case PRECONDITIONFAILED: return "preconditionFailed";
            case CONTENTTOOLARGE: return "contentTooLarge";
            case URITOOLONG: return "uriTooLong";
            case UNSUPPORTEDMEDIATYPE: return "unsupportedMediaType";
            case RANGENOTSATISFIABLE: return "rangeNotSatisfiable";
            case EXPECTATIONFAILED: return "expectationFailed";
            case MISDIRECTEDREQUEST: return "misdirectedRequest";
            case UNPROCESSABLECONTENT: return "unprocessableContent";
            case UPGRADEREQUIRED: return "upgradeRequired";
            case INTERNALSERVERERROR: return "internalServerError";
            case NOTIMPLEMENTED: return "notImplemented";
            case BADGATEWAY: return "badGateway";
            case SERVICEUNAVAILABLE: return "serviceUnavailable";
            case GATEWAYTIMEOUT: return "gatewayTimeout";
            case HTTPVERSIONNOTSUPPORTED: return "httpVersionNotSupported";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CONTINUE: return "http://hl7.org/fhir/assert-response-code-types";
            case SWITCHINGPROTOCOLS: return "http://hl7.org/fhir/assert-response-code-types";
            case OKAY: return "http://hl7.org/fhir/assert-response-code-types";
            case CREATED: return "http://hl7.org/fhir/assert-response-code-types";
            case ACCEPTED: return "http://hl7.org/fhir/assert-response-code-types";
            case NONAUTHORITATIVEINFORMATION: return "http://hl7.org/fhir/assert-response-code-types";
            case NOCONTENT: return "http://hl7.org/fhir/assert-response-code-types";
            case RESETCONTENT: return "http://hl7.org/fhir/assert-response-code-types";
            case PARTIALCONTENT: return "http://hl7.org/fhir/assert-response-code-types";
            case MULTIPLECHOICES: return "http://hl7.org/fhir/assert-response-code-types";
            case MOVEDPERMANENTLY: return "http://hl7.org/fhir/assert-response-code-types";
            case FOUND: return "http://hl7.org/fhir/assert-response-code-types";
            case SEEOTHER: return "http://hl7.org/fhir/assert-response-code-types";
            case NOTMODIFIED: return "http://hl7.org/fhir/assert-response-code-types";
            case USEPROXY: return "http://hl7.org/fhir/assert-response-code-types";
            case TEMPORARYREDIRECT: return "http://hl7.org/fhir/assert-response-code-types";
            case PERMANENTREDIRECT: return "http://hl7.org/fhir/assert-response-code-types";
            case BADREQUEST: return "http://hl7.org/fhir/assert-response-code-types";
            case UNAUTHORIZED: return "http://hl7.org/fhir/assert-response-code-types";
            case PAYMENTREQUIRED: return "http://hl7.org/fhir/assert-response-code-types";
            case FORBIDDEN: return "http://hl7.org/fhir/assert-response-code-types";
            case NOTFOUND: return "http://hl7.org/fhir/assert-response-code-types";
            case METHODNOTALLOWED: return "http://hl7.org/fhir/assert-response-code-types";
            case NOTACCEPTABLE: return "http://hl7.org/fhir/assert-response-code-types";
            case PROXYAUTHENTICATIONREQUIRED: return "http://hl7.org/fhir/assert-response-code-types";
            case REQUESTTIMEOUT: return "http://hl7.org/fhir/assert-response-code-types";
            case CONFLICT: return "http://hl7.org/fhir/assert-response-code-types";
            case GONE: return "http://hl7.org/fhir/assert-response-code-types";
            case LENGTHREQUIRED: return "http://hl7.org/fhir/assert-response-code-types";
            case PRECONDITIONFAILED: return "http://hl7.org/fhir/assert-response-code-types";
            case CONTENTTOOLARGE: return "http://hl7.org/fhir/assert-response-code-types";
            case URITOOLONG: return "http://hl7.org/fhir/assert-response-code-types";
            case UNSUPPORTEDMEDIATYPE: return "http://hl7.org/fhir/assert-response-code-types";
            case RANGENOTSATISFIABLE: return "http://hl7.org/fhir/assert-response-code-types";
            case EXPECTATIONFAILED: return "http://hl7.org/fhir/assert-response-code-types";
            case MISDIRECTEDREQUEST: return "http://hl7.org/fhir/assert-response-code-types";
            case UNPROCESSABLECONTENT: return "http://hl7.org/fhir/assert-response-code-types";
            case UPGRADEREQUIRED: return "http://hl7.org/fhir/assert-response-code-types";
            case INTERNALSERVERERROR: return "http://hl7.org/fhir/assert-response-code-types";
            case NOTIMPLEMENTED: return "http://hl7.org/fhir/assert-response-code-types";
            case BADGATEWAY: return "http://hl7.org/fhir/assert-response-code-types";
            case SERVICEUNAVAILABLE: return "http://hl7.org/fhir/assert-response-code-types";
            case GATEWAYTIMEOUT: return "http://hl7.org/fhir/assert-response-code-types";
            case HTTPVERSIONNOTSUPPORTED: return "http://hl7.org/fhir/assert-response-code-types";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CONTINUE: return "Response code is 100.";
            case SWITCHINGPROTOCOLS: return "Response code is 101.";
            case OKAY: return "Response code is 200.";
            case CREATED: return "Response code is 201.";
            case ACCEPTED: return "Response code is 202.";
            case NONAUTHORITATIVEINFORMATION: return "Response code is 203.";
            case NOCONTENT: return "Response code is 204.";
            case RESETCONTENT: return "Response code is 205.";
            case PARTIALCONTENT: return "Response code is 206.";
            case MULTIPLECHOICES: return "Response code is 300.";
            case MOVEDPERMANENTLY: return "Response code is 301.";
            case FOUND: return "Response code is 302.";
            case SEEOTHER: return "Response code is 303.";
            case NOTMODIFIED: return "Response code is 304.";
            case USEPROXY: return "Response code is 305.";
            case TEMPORARYREDIRECT: return "Response code is 307.";
            case PERMANENTREDIRECT: return "Response code is 308.";
            case BADREQUEST: return "Response code is 400.";
            case UNAUTHORIZED: return "Response code is 401.";
            case PAYMENTREQUIRED: return "Response code is 402.";
            case FORBIDDEN: return "Response code is 403.";
            case NOTFOUND: return "Response code is 404.";
            case METHODNOTALLOWED: return "Response code is 405.";
            case NOTACCEPTABLE: return "Response code is 406.";
            case PROXYAUTHENTICATIONREQUIRED: return "Response code is 407.";
            case REQUESTTIMEOUT: return "Response code is 408.";
            case CONFLICT: return "Response code is 409.";
            case GONE: return "Response code is 410.";
            case LENGTHREQUIRED: return "Response code is 411.";
            case PRECONDITIONFAILED: return "Response code is 412.";
            case CONTENTTOOLARGE: return "Response code is 413.";
            case URITOOLONG: return "Response code is 414.";
            case UNSUPPORTEDMEDIATYPE: return "Response code is 415.";
            case RANGENOTSATISFIABLE: return "Response code is 416.";
            case EXPECTATIONFAILED: return "Response code is 417.";
            case MISDIRECTEDREQUEST: return "Response code is 421.";
            case UNPROCESSABLECONTENT: return "Response code is 422.";
            case UPGRADEREQUIRED: return "Response code is 426.";
            case INTERNALSERVERERROR: return "Response code is 500.";
            case NOTIMPLEMENTED: return "Response code is 501.";
            case BADGATEWAY: return "Response code is 502.";
            case SERVICEUNAVAILABLE: return "Response code is 503.";
            case GATEWAYTIMEOUT: return "Response code is 504.";
            case HTTPVERSIONNOTSUPPORTED: return "Response code is 505.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CONTINUE: return "Continue";
            case SWITCHINGPROTOCOLS: return "Switching Protocols";
            case OKAY: return "OK";
            case CREATED: return "Created";
            case ACCEPTED: return "Accepted";
            case NONAUTHORITATIVEINFORMATION: return "Non-Authoritative Information";
            case NOCONTENT: return "No Content";
            case RESETCONTENT: return "Reset Content";
            case PARTIALCONTENT: return "Partial Content";
            case MULTIPLECHOICES: return "Multiple Choices";
            case MOVEDPERMANENTLY: return "Moved Permanently";
            case FOUND: return "Found";
            case SEEOTHER: return "See Other";
            case NOTMODIFIED: return "Not Modified";
            case USEPROXY: return "Use Proxy";
            case TEMPORARYREDIRECT: return "Temporary Redirect";
            case PERMANENTREDIRECT: return "Permanent Redirect";
            case BADREQUEST: return "Bad Request";
            case UNAUTHORIZED: return "Unauthorized";
            case PAYMENTREQUIRED: return "Payment Required";
            case FORBIDDEN: return "Forbidden";
            case NOTFOUND: return "Not Found";
            case METHODNOTALLOWED: return "Method Not Allowed";
            case NOTACCEPTABLE: return "Not Acceptable";
            case PROXYAUTHENTICATIONREQUIRED: return "Proxy Authentication Required";
            case REQUESTTIMEOUT: return "Request Timeout";
            case CONFLICT: return "Conflict";
            case GONE: return "Gone";
            case LENGTHREQUIRED: return "Length Required";
            case PRECONDITIONFAILED: return "Precondition Failed";
            case CONTENTTOOLARGE: return "Content Too Large";
            case URITOOLONG: return "URI Too Long";
            case UNSUPPORTEDMEDIATYPE: return "Unsupported Media Type";
            case RANGENOTSATISFIABLE: return "Range Not Satisfiable";
            case EXPECTATIONFAILED: return "Expectation Failed";
            case MISDIRECTEDREQUEST: return "Misdirected Request";
            case UNPROCESSABLECONTENT: return "Unprocessable Content";
            case UPGRADEREQUIRED: return "Upgrade Required";
            case INTERNALSERVERERROR: return "Internal Server Error";
            case NOTIMPLEMENTED: return "Not Implemented";
            case BADGATEWAY: return "Bad Gateway";
            case SERVICEUNAVAILABLE: return "Service Unavailable";
            case GATEWAYTIMEOUT: return "Gateway Timeout";
            case HTTPVERSIONNOTSUPPORTED: return "HTTP Version Not Supported";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AssertionResponseTypesEnumFactory implements EnumFactory<AssertionResponseTypes> {
    public AssertionResponseTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("continue".equals(codeString))
          return AssertionResponseTypes.CONTINUE;
        if ("switchingProtocols".equals(codeString))
          return AssertionResponseTypes.SWITCHINGPROTOCOLS;
        if ("okay".equals(codeString))
          return AssertionResponseTypes.OKAY;
        if ("created".equals(codeString))
          return AssertionResponseTypes.CREATED;
        if ("accepted".equals(codeString))
          return AssertionResponseTypes.ACCEPTED;
        if ("nonAuthoritativeInformation".equals(codeString))
          return AssertionResponseTypes.NONAUTHORITATIVEINFORMATION;
        if ("noContent".equals(codeString))
          return AssertionResponseTypes.NOCONTENT;
        if ("resetContent".equals(codeString))
          return AssertionResponseTypes.RESETCONTENT;
        if ("partialContent".equals(codeString))
          return AssertionResponseTypes.PARTIALCONTENT;
        if ("multipleChoices".equals(codeString))
          return AssertionResponseTypes.MULTIPLECHOICES;
        if ("movedPermanently".equals(codeString))
          return AssertionResponseTypes.MOVEDPERMANENTLY;
        if ("found".equals(codeString))
          return AssertionResponseTypes.FOUND;
        if ("seeOther".equals(codeString))
          return AssertionResponseTypes.SEEOTHER;
        if ("notModified".equals(codeString))
          return AssertionResponseTypes.NOTMODIFIED;
        if ("useProxy".equals(codeString))
          return AssertionResponseTypes.USEPROXY;
        if ("temporaryRedirect".equals(codeString))
          return AssertionResponseTypes.TEMPORARYREDIRECT;
        if ("permanentRedirect".equals(codeString))
          return AssertionResponseTypes.PERMANENTREDIRECT;
        if ("badRequest".equals(codeString))
          return AssertionResponseTypes.BADREQUEST;
        if ("unauthorized".equals(codeString))
          return AssertionResponseTypes.UNAUTHORIZED;
        if ("paymentRequired".equals(codeString))
          return AssertionResponseTypes.PAYMENTREQUIRED;
        if ("forbidden".equals(codeString))
          return AssertionResponseTypes.FORBIDDEN;
        if ("notFound".equals(codeString))
          return AssertionResponseTypes.NOTFOUND;
        if ("methodNotAllowed".equals(codeString))
          return AssertionResponseTypes.METHODNOTALLOWED;
        if ("notAcceptable".equals(codeString))
          return AssertionResponseTypes.NOTACCEPTABLE;
        if ("proxyAuthenticationRequired".equals(codeString))
          return AssertionResponseTypes.PROXYAUTHENTICATIONREQUIRED;
        if ("requestTimeout".equals(codeString))
          return AssertionResponseTypes.REQUESTTIMEOUT;
        if ("conflict".equals(codeString))
          return AssertionResponseTypes.CONFLICT;
        if ("gone".equals(codeString))
          return AssertionResponseTypes.GONE;
        if ("lengthRequired".equals(codeString))
          return AssertionResponseTypes.LENGTHREQUIRED;
        if ("preconditionFailed".equals(codeString))
          return AssertionResponseTypes.PRECONDITIONFAILED;
        if ("contentTooLarge".equals(codeString))
          return AssertionResponseTypes.CONTENTTOOLARGE;
        if ("uriTooLong".equals(codeString))
          return AssertionResponseTypes.URITOOLONG;
        if ("unsupportedMediaType".equals(codeString))
          return AssertionResponseTypes.UNSUPPORTEDMEDIATYPE;
        if ("rangeNotSatisfiable".equals(codeString))
          return AssertionResponseTypes.RANGENOTSATISFIABLE;
        if ("expectationFailed".equals(codeString))
          return AssertionResponseTypes.EXPECTATIONFAILED;
        if ("misdirectedRequest".equals(codeString))
          return AssertionResponseTypes.MISDIRECTEDREQUEST;
        if ("unprocessableContent".equals(codeString))
          return AssertionResponseTypes.UNPROCESSABLECONTENT;
        if ("upgradeRequired".equals(codeString))
          return AssertionResponseTypes.UPGRADEREQUIRED;
        if ("internalServerError".equals(codeString))
          return AssertionResponseTypes.INTERNALSERVERERROR;
        if ("notImplemented".equals(codeString))
          return AssertionResponseTypes.NOTIMPLEMENTED;
        if ("badGateway".equals(codeString))
          return AssertionResponseTypes.BADGATEWAY;
        if ("serviceUnavailable".equals(codeString))
          return AssertionResponseTypes.SERVICEUNAVAILABLE;
        if ("gatewayTimeout".equals(codeString))
          return AssertionResponseTypes.GATEWAYTIMEOUT;
        if ("httpVersionNotSupported".equals(codeString))
          return AssertionResponseTypes.HTTPVERSIONNOTSUPPORTED;
        throw new IllegalArgumentException("Unknown AssertionResponseTypes code '"+codeString+"'");
        }
        public Enumeration<AssertionResponseTypes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NULL, code);
        if ("continue".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.CONTINUE, code);
        if ("switchingProtocols".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.SWITCHINGPROTOCOLS, code);
        if ("okay".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.OKAY, code);
        if ("created".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.CREATED, code);
        if ("accepted".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.ACCEPTED, code);
        if ("nonAuthoritativeInformation".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NONAUTHORITATIVEINFORMATION, code);
        if ("noContent".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOCONTENT, code);
        if ("resetContent".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.RESETCONTENT, code);
        if ("partialContent".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.PARTIALCONTENT, code);
        if ("multipleChoices".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.MULTIPLECHOICES, code);
        if ("movedPermanently".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.MOVEDPERMANENTLY, code);
        if ("found".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.FOUND, code);
        if ("seeOther".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.SEEOTHER, code);
        if ("notModified".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOTMODIFIED, code);
        if ("useProxy".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.USEPROXY, code);
        if ("temporaryRedirect".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.TEMPORARYREDIRECT, code);
        if ("permanentRedirect".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.PERMANENTREDIRECT, code);
        if ("badRequest".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.BADREQUEST, code);
        if ("unauthorized".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.UNAUTHORIZED, code);
        if ("paymentRequired".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.PAYMENTREQUIRED, code);
        if ("forbidden".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.FORBIDDEN, code);
        if ("notFound".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOTFOUND, code);
        if ("methodNotAllowed".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.METHODNOTALLOWED, code);
        if ("notAcceptable".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOTACCEPTABLE, code);
        if ("proxyAuthenticationRequired".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.PROXYAUTHENTICATIONREQUIRED, code);
        if ("requestTimeout".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.REQUESTTIMEOUT, code);
        if ("conflict".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.CONFLICT, code);
        if ("gone".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.GONE, code);
        if ("lengthRequired".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.LENGTHREQUIRED, code);
        if ("preconditionFailed".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.PRECONDITIONFAILED, code);
        if ("contentTooLarge".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.CONTENTTOOLARGE, code);
        if ("uriTooLong".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.URITOOLONG, code);
        if ("unsupportedMediaType".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.UNSUPPORTEDMEDIATYPE, code);
        if ("rangeNotSatisfiable".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.RANGENOTSATISFIABLE, code);
        if ("expectationFailed".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.EXPECTATIONFAILED, code);
        if ("misdirectedRequest".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.MISDIRECTEDREQUEST, code);
        if ("unprocessableContent".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.UNPROCESSABLECONTENT, code);
        if ("upgradeRequired".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.UPGRADEREQUIRED, code);
        if ("internalServerError".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.INTERNALSERVERERROR, code);
        if ("notImplemented".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.NOTIMPLEMENTED, code);
        if ("badGateway".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.BADGATEWAY, code);
        if ("serviceUnavailable".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.SERVICEUNAVAILABLE, code);
        if ("gatewayTimeout".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.GATEWAYTIMEOUT, code);
        if ("httpVersionNotSupported".equals(codeString))
          return new Enumeration<AssertionResponseTypes>(this, AssertionResponseTypes.HTTPVERSIONNOTSUPPORTED, code);
        throw new FHIRException("Unknown AssertionResponseTypes code '"+codeString+"'");
        }
    public String toCode(AssertionResponseTypes code) {
      if (code == AssertionResponseTypes.CONTINUE)
        return "continue";
      if (code == AssertionResponseTypes.SWITCHINGPROTOCOLS)
        return "switchingProtocols";
      if (code == AssertionResponseTypes.OKAY)
        return "okay";
      if (code == AssertionResponseTypes.CREATED)
        return "created";
      if (code == AssertionResponseTypes.ACCEPTED)
        return "accepted";
      if (code == AssertionResponseTypes.NONAUTHORITATIVEINFORMATION)
        return "nonAuthoritativeInformation";
      if (code == AssertionResponseTypes.NOCONTENT)
        return "noContent";
      if (code == AssertionResponseTypes.RESETCONTENT)
        return "resetContent";
      if (code == AssertionResponseTypes.PARTIALCONTENT)
        return "partialContent";
      if (code == AssertionResponseTypes.MULTIPLECHOICES)
        return "multipleChoices";
      if (code == AssertionResponseTypes.MOVEDPERMANENTLY)
        return "movedPermanently";
      if (code == AssertionResponseTypes.FOUND)
        return "found";
      if (code == AssertionResponseTypes.SEEOTHER)
        return "seeOther";
      if (code == AssertionResponseTypes.NOTMODIFIED)
        return "notModified";
      if (code == AssertionResponseTypes.USEPROXY)
        return "useProxy";
      if (code == AssertionResponseTypes.TEMPORARYREDIRECT)
        return "temporaryRedirect";
      if (code == AssertionResponseTypes.PERMANENTREDIRECT)
        return "permanentRedirect";
      if (code == AssertionResponseTypes.BADREQUEST)
        return "badRequest";
      if (code == AssertionResponseTypes.UNAUTHORIZED)
        return "unauthorized";
      if (code == AssertionResponseTypes.PAYMENTREQUIRED)
        return "paymentRequired";
      if (code == AssertionResponseTypes.FORBIDDEN)
        return "forbidden";
      if (code == AssertionResponseTypes.NOTFOUND)
        return "notFound";
      if (code == AssertionResponseTypes.METHODNOTALLOWED)
        return "methodNotAllowed";
      if (code == AssertionResponseTypes.NOTACCEPTABLE)
        return "notAcceptable";
      if (code == AssertionResponseTypes.PROXYAUTHENTICATIONREQUIRED)
        return "proxyAuthenticationRequired";
      if (code == AssertionResponseTypes.REQUESTTIMEOUT)
        return "requestTimeout";
      if (code == AssertionResponseTypes.CONFLICT)
        return "conflict";
      if (code == AssertionResponseTypes.GONE)
        return "gone";
      if (code == AssertionResponseTypes.LENGTHREQUIRED)
        return "lengthRequired";
      if (code == AssertionResponseTypes.PRECONDITIONFAILED)
        return "preconditionFailed";
      if (code == AssertionResponseTypes.CONTENTTOOLARGE)
        return "contentTooLarge";
      if (code == AssertionResponseTypes.URITOOLONG)
        return "uriTooLong";
      if (code == AssertionResponseTypes.UNSUPPORTEDMEDIATYPE)
        return "unsupportedMediaType";
      if (code == AssertionResponseTypes.RANGENOTSATISFIABLE)
        return "rangeNotSatisfiable";
      if (code == AssertionResponseTypes.EXPECTATIONFAILED)
        return "expectationFailed";
      if (code == AssertionResponseTypes.MISDIRECTEDREQUEST)
        return "misdirectedRequest";
      if (code == AssertionResponseTypes.UNPROCESSABLECONTENT)
        return "unprocessableContent";
      if (code == AssertionResponseTypes.UPGRADEREQUIRED)
        return "upgradeRequired";
      if (code == AssertionResponseTypes.INTERNALSERVERERROR)
        return "internalServerError";
      if (code == AssertionResponseTypes.NOTIMPLEMENTED)
        return "notImplemented";
      if (code == AssertionResponseTypes.BADGATEWAY)
        return "badGateway";
      if (code == AssertionResponseTypes.SERVICEUNAVAILABLE)
        return "serviceUnavailable";
      if (code == AssertionResponseTypes.GATEWAYTIMEOUT)
        return "gatewayTimeout";
      if (code == AssertionResponseTypes.HTTPVERSIONNOTSUPPORTED)
        return "httpVersionNotSupported";
      return "?";
      }
    public String toSystem(AssertionResponseTypes code) {
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
            case NULL: return null;
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
            case NULL: return null;
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
            case NULL: return null;
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
            case NULL: return null;
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
        public Enumeration<TestScriptRequestMethodCode> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.NULL, code);
        if ("delete".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.DELETE, code);
        if ("get".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.GET, code);
        if ("options".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.OPTIONS, code);
        if ("patch".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.PATCH, code);
        if ("post".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.POST, code);
        if ("put".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.PUT, code);
        if ("head".equals(codeString))
          return new Enumeration<TestScriptRequestMethodCode>(this, TestScriptRequestMethodCode.HEAD, code);
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

        /**
         * The explicit url path of the origin server used in this test script.
         */
        @Child(name = "url", type = {UrlType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The url path of the origin server", formalDefinition="The explicit url path of the origin server used in this test script." )
        protected UrlType url;

        private static final long serialVersionUID = -188072923L;

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

        /**
         * @return {@link #url} (The explicit url path of the origin server used in this test script.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptOriginComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UrlType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (The explicit url path of the origin server used in this test script.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public TestScriptOriginComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return The explicit url path of the origin server used in this test script.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value The explicit url path of the origin server used in this test script.
         */
        public TestScriptOriginComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("index", "integer", "Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.", 0, 1, index));
          children.add(new Property("profile", "Coding", "The type of origin profile the test system supports.", 0, 1, profile));
          children.add(new Property("url", "url", "The explicit url path of the origin server used in this test script.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 100346066: /*index*/  return new Property("index", "integer", "Abstract name given to an origin server in this test script.  The name is provided as a number starting at 1.", 0, 1, index);
          case -309425751: /*profile*/  return new Property("profile", "Coding", "The type of origin profile the test system supports.", 0, 1, profile);
          case 116079: /*url*/  return new Property("url", "url", "The explicit url path of the origin server used in this test script.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return this.index == null ? new Base[0] : new Base[] {this.index}; // IntegerType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // Coding
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
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
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
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
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066:  return getIndexElement();
        case -309425751:  return getProfile();
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return new String[] {"integer"};
        case -309425751: /*profile*/ return new String[] {"Coding"};
        case 116079: /*url*/ return new String[] {"url"};
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
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.origin.url");
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
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptOriginComponent))
          return false;
        TestScriptOriginComponent o = (TestScriptOriginComponent) other_;
        return compareDeep(index, o.index, true) && compareDeep(profile, o.profile, true) && compareDeep(url, o.url, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptOriginComponent))
          return false;
        TestScriptOriginComponent o = (TestScriptOriginComponent) other_;
        return compareValues(index, o.index, true) && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(index, profile, url);
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

        /**
         * The explicit url path of the destination server used in this test script.
         */
        @Child(name = "url", type = {UrlType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The url path of the destination server", formalDefinition="The explicit url path of the destination server used in this test script." )
        protected UrlType url;

        private static final long serialVersionUID = -188072923L;

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

        /**
         * @return {@link #url} (The explicit url path of the destination server used in this test script.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptDestinationComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UrlType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (The explicit url path of the destination server used in this test script.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public TestScriptDestinationComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return The explicit url path of the destination server used in this test script.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value The explicit url path of the destination server used in this test script.
         */
        public TestScriptDestinationComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("index", "integer", "Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.", 0, 1, index));
          children.add(new Property("profile", "Coding", "The type of destination profile the test system supports.", 0, 1, profile));
          children.add(new Property("url", "url", "The explicit url path of the destination server used in this test script.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 100346066: /*index*/  return new Property("index", "integer", "Abstract name given to a destination server in this test script.  The name is provided as a number starting at 1.", 0, 1, index);
          case -309425751: /*profile*/  return new Property("profile", "Coding", "The type of destination profile the test system supports.", 0, 1, profile);
          case 116079: /*url*/  return new Property("url", "url", "The explicit url path of the destination server used in this test script.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return this.index == null ? new Base[0] : new Base[] {this.index}; // IntegerType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // Coding
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
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
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
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
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066:  return getIndexElement();
        case -309425751:  return getProfile();
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 100346066: /*index*/ return new String[] {"integer"};
        case -309425751: /*profile*/ return new String[] {"Coding"};
        case 116079: /*url*/ return new String[] {"url"};
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
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.destination.url");
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
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptDestinationComponent))
          return false;
        TestScriptDestinationComponent o = (TestScriptDestinationComponent) other_;
        return compareDeep(index, o.index, true) && compareDeep(profile, o.profile, true) && compareDeep(url, o.url, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptDestinationComponent))
          return false;
        TestScriptDestinationComponent o = (TestScriptDestinationComponent) other_;
        return compareValues(index, o.index, true) && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(index, profile, url);
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
    public static class TestScriptScopeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific conformance artifact being tested. The canonical reference can be version-specific.
         */
        @Child(name = "artifact", type = {CanonicalType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific conformance artifact being tested", formalDefinition="The specific conformance artifact being tested. The canonical reference can be version-specific." )
        protected CanonicalType artifact;

        /**
         * The expectation of whether the test must pass for the system to be considered conformant with the artifact: required - all tests are expected to pass, optional - all test are expected to pass but non-pass status may be allowed, strict - all tests are expected to pass and warnings are treated as a failure.
         */
        @Child(name = "conformance", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="required | optional | strict", formalDefinition="The expectation of whether the test must pass for the system to be considered conformant with the artifact: required - all tests are expected to pass, optional - all test are expected to pass but non-pass status may be allowed, strict - all tests are expected to pass and warnings are treated as a failure." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-scope-conformance-codes")
        protected CodeableConcept conformance;

        /**
         * The phase of testing for this artifact: unit - development / implementation phase, integration - internal system to system phase, production - live system to system phase (Note, this may involve pii/phi data).
         */
        @Child(name = "phase", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="unit | integration | production", formalDefinition="The phase of testing for this artifact: unit - development / implementation phase, integration - internal system to system phase, production - live system to system phase (Note, this may involve pii/phi data)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-scope-phase-codes")
        protected CodeableConcept phase;

        private static final long serialVersionUID = 1236847076L;

    /**
     * Constructor
     */
      public TestScriptScopeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestScriptScopeComponent(String artifact) {
        super();
        this.setArtifact(artifact);
      }

        /**
         * @return {@link #artifact} (The specific conformance artifact being tested. The canonical reference can be version-specific.). This is the underlying object with id, value and extensions. The accessor "getArtifact" gives direct access to the value
         */
        public CanonicalType getArtifactElement() { 
          if (this.artifact == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptScopeComponent.artifact");
            else if (Configuration.doAutoCreate())
              this.artifact = new CanonicalType(); // bb
          return this.artifact;
        }

        public boolean hasArtifactElement() { 
          return this.artifact != null && !this.artifact.isEmpty();
        }

        public boolean hasArtifact() { 
          return this.artifact != null && !this.artifact.isEmpty();
        }

        /**
         * @param value {@link #artifact} (The specific conformance artifact being tested. The canonical reference can be version-specific.). This is the underlying object with id, value and extensions. The accessor "getArtifact" gives direct access to the value
         */
        public TestScriptScopeComponent setArtifactElement(CanonicalType value) { 
          this.artifact = value;
          return this;
        }

        /**
         * @return The specific conformance artifact being tested. The canonical reference can be version-specific.
         */
        public String getArtifact() { 
          return this.artifact == null ? null : this.artifact.getValue();
        }

        /**
         * @param value The specific conformance artifact being tested. The canonical reference can be version-specific.
         */
        public TestScriptScopeComponent setArtifact(String value) { 
            if (this.artifact == null)
              this.artifact = new CanonicalType();
            this.artifact.setValue(value);
          return this;
        }

        /**
         * @return {@link #conformance} (The expectation of whether the test must pass for the system to be considered conformant with the artifact: required - all tests are expected to pass, optional - all test are expected to pass but non-pass status may be allowed, strict - all tests are expected to pass and warnings are treated as a failure.)
         */
        public CodeableConcept getConformance() { 
          if (this.conformance == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptScopeComponent.conformance");
            else if (Configuration.doAutoCreate())
              this.conformance = new CodeableConcept(); // cc
          return this.conformance;
        }

        public boolean hasConformance() { 
          return this.conformance != null && !this.conformance.isEmpty();
        }

        /**
         * @param value {@link #conformance} (The expectation of whether the test must pass for the system to be considered conformant with the artifact: required - all tests are expected to pass, optional - all test are expected to pass but non-pass status may be allowed, strict - all tests are expected to pass and warnings are treated as a failure.)
         */
        public TestScriptScopeComponent setConformance(CodeableConcept value) { 
          this.conformance = value;
          return this;
        }

        /**
         * @return {@link #phase} (The phase of testing for this artifact: unit - development / implementation phase, integration - internal system to system phase, production - live system to system phase (Note, this may involve pii/phi data).)
         */
        public CodeableConcept getPhase() { 
          if (this.phase == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestScriptScopeComponent.phase");
            else if (Configuration.doAutoCreate())
              this.phase = new CodeableConcept(); // cc
          return this.phase;
        }

        public boolean hasPhase() { 
          return this.phase != null && !this.phase.isEmpty();
        }

        /**
         * @param value {@link #phase} (The phase of testing for this artifact: unit - development / implementation phase, integration - internal system to system phase, production - live system to system phase (Note, this may involve pii/phi data).)
         */
        public TestScriptScopeComponent setPhase(CodeableConcept value) { 
          this.phase = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("artifact", "canonical(Any)", "The specific conformance artifact being tested. The canonical reference can be version-specific.", 0, 1, artifact));
          children.add(new Property("conformance", "CodeableConcept", "The expectation of whether the test must pass for the system to be considered conformant with the artifact: required - all tests are expected to pass, optional - all test are expected to pass but non-pass status may be allowed, strict - all tests are expected to pass and warnings are treated as a failure.", 0, 1, conformance));
          children.add(new Property("phase", "CodeableConcept", "The phase of testing for this artifact: unit - development / implementation phase, integration - internal system to system phase, production - live system to system phase (Note, this may involve pii/phi data).", 0, 1, phase));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1228798510: /*artifact*/  return new Property("artifact", "canonical(Any)", "The specific conformance artifact being tested. The canonical reference can be version-specific.", 0, 1, artifact);
          case 1374858133: /*conformance*/  return new Property("conformance", "CodeableConcept", "The expectation of whether the test must pass for the system to be considered conformant with the artifact: required - all tests are expected to pass, optional - all test are expected to pass but non-pass status may be allowed, strict - all tests are expected to pass and warnings are treated as a failure.", 0, 1, conformance);
          case 106629499: /*phase*/  return new Property("phase", "CodeableConcept", "The phase of testing for this artifact: unit - development / implementation phase, integration - internal system to system phase, production - live system to system phase (Note, this may involve pii/phi data).", 0, 1, phase);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1228798510: /*artifact*/ return this.artifact == null ? new Base[0] : new Base[] {this.artifact}; // CanonicalType
        case 1374858133: /*conformance*/ return this.conformance == null ? new Base[0] : new Base[] {this.conformance}; // CodeableConcept
        case 106629499: /*phase*/ return this.phase == null ? new Base[0] : new Base[] {this.phase}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1228798510: // artifact
          this.artifact = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1374858133: // conformance
          this.conformance = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 106629499: // phase
          this.phase = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("artifact")) {
          this.artifact = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("conformance")) {
          this.conformance = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("phase")) {
          this.phase = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1228798510:  return getArtifactElement();
        case 1374858133:  return getConformance();
        case 106629499:  return getPhase();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1228798510: /*artifact*/ return new String[] {"canonical"};
        case 1374858133: /*conformance*/ return new String[] {"CodeableConcept"};
        case 106629499: /*phase*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("artifact")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.scope.artifact");
        }
        else if (name.equals("conformance")) {
          this.conformance = new CodeableConcept();
          return this.conformance;
        }
        else if (name.equals("phase")) {
          this.phase = new CodeableConcept();
          return this.phase;
        }
        else
          return super.addChild(name);
      }

      public TestScriptScopeComponent copy() {
        TestScriptScopeComponent dst = new TestScriptScopeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestScriptScopeComponent dst) {
        super.copyValues(dst);
        dst.artifact = artifact == null ? null : artifact.copy();
        dst.conformance = conformance == null ? null : conformance.copy();
        dst.phase = phase == null ? null : phase.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestScriptScopeComponent))
          return false;
        TestScriptScopeComponent o = (TestScriptScopeComponent) other_;
        return compareDeep(artifact, o.artifact, true) && compareDeep(conformance, o.conformance, true)
           && compareDeep(phase, o.phase, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestScriptScopeComponent))
          return false;
        TestScriptScopeComponent o = (TestScriptScopeComponent) other_;
        return compareValues(artifact, o.artifact, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(artifact, conformance, phase
          );
      }

  public String fhirType() {
    return "TestScript.scope";

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
         * Reference to the resource (containing the contents of the resource needed for operations). This is allowed to be a Parameters resource.
         */
        @Child(name = "resource", type = {Reference.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference of the resource", formalDefinition="Reference to the resource (containing the contents of the resource needed for operations). This is allowed to be a Parameters resource." )
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
         * @return {@link #resource} (Reference to the resource (containing the contents of the resource needed for operations). This is allowed to be a Parameters resource.)
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
         * @param value {@link #resource} (Reference to the resource (containing the contents of the resource needed for operations). This is allowed to be a Parameters resource.)
         */
        public TestScriptFixtureComponent setResource(Reference value) { 
          this.resource = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("autocreate", "boolean", "Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.", 0, 1, autocreate));
          children.add(new Property("autodelete", "boolean", "Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.", 0, 1, autodelete));
          children.add(new Property("resource", "Reference(Any)", "Reference to the resource (containing the contents of the resource needed for operations). This is allowed to be a Parameters resource.", 0, 1, resource));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 73154411: /*autocreate*/  return new Property("autocreate", "boolean", "Whether or not to implicitly create the fixture during setup. If true, the fixture is automatically created on each server being tested during setup, therefore no create operation is required for this fixture in the TestScript.setup section.", 0, 1, autocreate);
          case 89990170: /*autodelete*/  return new Property("autodelete", "boolean", "Whether or not to implicitly delete the fixture during teardown. If true, the fixture is automatically deleted on each server being tested during teardown, therefore no delete operation is required for this fixture in the TestScript.teardown section.", 0, 1, autodelete);
          case -341064690: /*resource*/  return new Property("resource", "Reference(Any)", "Reference to the resource (containing the contents of the resource needed for operations). This is allowed to be a Parameters resource.", 0, 1, resource);
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
         * The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.
         */
        @Child(name = "expression", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The FHIRPath expression against the fixture body", formalDefinition="The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified." )
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
         * @return {@link #expression} (The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
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
         * @param value {@link #expression} (The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.). This is the underlying object with id, value and extensions. The accessor "getExpression" gives direct access to the value
         */
        public TestScriptVariableComponent setExpressionElement(StringType value) { 
          this.expression = value;
          return this;
        }

        /**
         * @return The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.
         */
        public String getExpression() { 
          return this.expression == null ? null : this.expression.getValue();
        }

        /**
         * @param value The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.
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
          children.add(new Property("expression", "string", "The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.", 0, 1, expression));
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
          case -1795452264: /*expression*/  return new Property("expression", "string", "The FHIRPath expression for a specific value to evaluate against the fixture body. When variables are defined, only one of either expression, headerField or path must be specified.", 0, 1, expression);
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
         * The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.
         */
        @Child(name = "resource", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Resource type", formalDefinition="The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/concrete-fhir-types")
        protected UriType resource;

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
        @Description(shortDefinition="Mime type to accept in the payload of the response, with charset etc", formalDefinition="The mime-type to use for RESTful operation in the 'Accept' header." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
        protected CodeType accept;

        /**
         * The mime-type to use for RESTful operation in the 'Content-Type' header.
         */
        @Child(name = "contentType", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Mime type of the request payload contents, with charset etc", formalDefinition="The mime-type to use for RESTful operation in the 'Content-Type' header." )
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

        private static final long serialVersionUID = 308704897L;

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
         * @return {@link #resource} (The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public UriType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionOperationComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new UriType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SetupActionOperationComponent setResourceElement(UriType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.
         */
        public SetupActionOperationComponent setResource(String value) { 
          if (Utilities.noString(value))
            this.resource = null;
          else {
            if (this.resource == null)
              this.resource = new UriType();
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
          children.add(new Property("resource", "uri", "The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.", 0, 1, resource));
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
          case -341064690: /*resource*/  return new Property("resource", "uri", "The type of the FHIR resource. See the [resource list](resourcelist.html). Data type of uri is needed when non-HL7 artifacts are identified.", 0, 1, resource);
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
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // UriType
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
          this.resource = TypeConvertor.castToUri(value); // UriType
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
          this.resource = TypeConvertor.castToUri(value); // UriType
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
        case -341064690: /*resource*/ return new String[] {"uri"};
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
         * The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        @Child(name = "compareToSourceExpression", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The FHIRPath expression to evaluate against the source fixture", formalDefinition="The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both." )
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
         * The default manual completion outcome applied to this assertion.
         */
        @Child(name = "defaultManualCompletion", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="fail | pass | skip | stop", formalDefinition="The default manual completion outcome applied to this assertion." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/assert-manual-completion-codes")
        protected Enumeration<AssertionManualCompletionType> defaultManualCompletion;

        /**
         * The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.
         */
        @Child(name = "expression", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The FHIRPath expression to be evaluated", formalDefinition="The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload." )
        protected StringType expression;

        /**
         * The HTTP header field name e.g. 'Location'.
         */
        @Child(name = "headerField", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP header field name", formalDefinition="The HTTP header field name e.g. 'Location'." )
        protected StringType headerField;

        /**
         * The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.
         */
        @Child(name = "minimumId", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of minimum content resource", formalDefinition="The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId." )
        protected StringType minimumId;

        /**
         * Whether or not the test execution performs validation on the bundle navigation links.
         */
        @Child(name = "navigationLinks", type = {BooleanType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Perform validation on navigation links?", formalDefinition="Whether or not the test execution performs validation on the bundle navigation links." )
        protected BooleanType navigationLinks;

        /**
         * The operator type defines the conditional behavior of the assert.
         */
        @Child(name = "operator", type = {CodeType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="equals | notEquals | in | notIn | greaterThan | lessThan | empty | notEmpty | contains | notContains | eval | manualEval", formalDefinition="The operator type defines the conditional behavior of the assert." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/assert-operator-codes")
        protected Enumeration<AssertionOperatorType> operator;

        /**
         * The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.
         */
        @Child(name = "path", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="XPath or JSONPath expression", formalDefinition="The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server." )
        protected StringType path;

        /**
         * The request method or HTTP operation code to compare against that used by the client system under test.
         */
        @Child(name = "requestMethod", type = {CodeType.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="delete | get | options | patch | post | put | head", formalDefinition="The request method or HTTP operation code to compare against that used by the client system under test." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/http-operations")
        protected Enumeration<TestScriptRequestMethodCode> requestMethod;

        /**
         * The value to use in a comparison against the request URL path string.
         */
        @Child(name = "requestURL", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Request URL comparison value", formalDefinition="The value to use in a comparison against the request URL path string." )
        protected StringType requestURL;

        /**
         * The type of the resource.  See the [resource list](resourcelist.html).
         */
        @Child(name = "resource", type = {UriType.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Resource type", formalDefinition="The type of the resource.  See the [resource list](resourcelist.html)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/concrete-fhir-types")
        protected UriType resource;

        /**
         * continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.
         */
        @Child(name = "response", type = {CodeType.class}, order=18, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported", formalDefinition="continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/assert-response-code-types")
        protected Enumeration<AssertionResponseTypes> response;

        /**
         * The value of the HTTP response code to be tested.
         */
        @Child(name = "responseCode", type = {StringType.class}, order=19, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="HTTP response code to test", formalDefinition="The value of the HTTP response code to be tested." )
        protected StringType responseCode;

        /**
         * Fixture to evaluate the XPath/JSONPath expression or the headerField  against.
         */
        @Child(name = "sourceId", type = {IdType.class}, order=20, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Fixture Id of source expression or headerField", formalDefinition="Fixture to evaluate the XPath/JSONPath expression or the headerField  against." )
        protected IdType sourceId;

        /**
         * Whether or not the current test execution will stop on failure for this assert.
         */
        @Child(name = "stopTestOnFail", type = {BooleanType.class}, order=21, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="If this assert fails, will the current test execution stop?", formalDefinition="Whether or not the current test execution will stop on failure for this assert." )
        protected BooleanType stopTestOnFail;

        /**
         * The ID of the Profile to validate against.
         */
        @Child(name = "validateProfileId", type = {IdType.class}, order=22, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Profile Id of validation profile reference", formalDefinition="The ID of the Profile to validate against." )
        protected IdType validateProfileId;

        /**
         * The value to compare to.
         */
        @Child(name = "value", type = {StringType.class}, order=23, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The value to compare to", formalDefinition="The value to compare to." )
        protected StringType value;

        /**
         * Whether or not the test execution will produce a warning only on error for this assert.
         */
        @Child(name = "warningOnly", type = {BooleanType.class}, order=24, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Will this assert produce a warning only on error?", formalDefinition="Whether or not the test execution will produce a warning only on error for this assert." )
        protected BooleanType warningOnly;

        /**
         * Links or references providing traceability to the testing requirements for this assert.
         */
        @Child(name = "requirement", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Links or references to the testing requirements", formalDefinition="Links or references providing traceability to the testing requirements for this assert." )
        protected List<SetupActionAssertRequirementComponent> requirement;

        private static final long serialVersionUID = -1269963728L;

    /**
     * Constructor
     */
      public SetupActionAssertComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SetupActionAssertComponent(boolean stopTestOnFail, boolean warningOnly) {
        super();
        this.setStopTestOnFail(stopTestOnFail);
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
         * @return {@link #compareToSourceExpression} (The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourceExpression" gives direct access to the value
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
         * @param value {@link #compareToSourceExpression} (The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.). This is the underlying object with id, value and extensions. The accessor "getCompareToSourceExpression" gives direct access to the value
         */
        public SetupActionAssertComponent setCompareToSourceExpressionElement(StringType value) { 
          this.compareToSourceExpression = value;
          return this;
        }

        /**
         * @return The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
         */
        public String getCompareToSourceExpression() { 
          return this.compareToSourceExpression == null ? null : this.compareToSourceExpression.getValue();
        }

        /**
         * @param value The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.
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
         * @return {@link #defaultManualCompletion} (The default manual completion outcome applied to this assertion.). This is the underlying object with id, value and extensions. The accessor "getDefaultManualCompletion" gives direct access to the value
         */
        public Enumeration<AssertionManualCompletionType> getDefaultManualCompletionElement() { 
          if (this.defaultManualCompletion == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.defaultManualCompletion");
            else if (Configuration.doAutoCreate())
              this.defaultManualCompletion = new Enumeration<AssertionManualCompletionType>(new AssertionManualCompletionTypeEnumFactory()); // bb
          return this.defaultManualCompletion;
        }

        public boolean hasDefaultManualCompletionElement() { 
          return this.defaultManualCompletion != null && !this.defaultManualCompletion.isEmpty();
        }

        public boolean hasDefaultManualCompletion() { 
          return this.defaultManualCompletion != null && !this.defaultManualCompletion.isEmpty();
        }

        /**
         * @param value {@link #defaultManualCompletion} (The default manual completion outcome applied to this assertion.). This is the underlying object with id, value and extensions. The accessor "getDefaultManualCompletion" gives direct access to the value
         */
        public SetupActionAssertComponent setDefaultManualCompletionElement(Enumeration<AssertionManualCompletionType> value) { 
          this.defaultManualCompletion = value;
          return this;
        }

        /**
         * @return The default manual completion outcome applied to this assertion.
         */
        public AssertionManualCompletionType getDefaultManualCompletion() { 
          return this.defaultManualCompletion == null ? null : this.defaultManualCompletion.getValue();
        }

        /**
         * @param value The default manual completion outcome applied to this assertion.
         */
        public SetupActionAssertComponent setDefaultManualCompletion(AssertionManualCompletionType value) { 
          if (value == null)
            this.defaultManualCompletion = null;
          else {
            if (this.defaultManualCompletion == null)
              this.defaultManualCompletion = new Enumeration<AssertionManualCompletionType>(new AssertionManualCompletionTypeEnumFactory());
            this.defaultManualCompletion.setValue(value);
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
         * @return {@link #minimumId} (The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.). This is the underlying object with id, value and extensions. The accessor "getMinimumId" gives direct access to the value
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
         * @param value {@link #minimumId} (The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.). This is the underlying object with id, value and extensions. The accessor "getMinimumId" gives direct access to the value
         */
        public SetupActionAssertComponent setMinimumIdElement(StringType value) { 
          this.minimumId = value;
          return this;
        }

        /**
         * @return The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.
         */
        public String getMinimumId() { 
          return this.minimumId == null ? null : this.minimumId.getValue();
        }

        /**
         * @param value The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.
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
         * @return {@link #operator} (The operator type defines the conditional behavior of the assert.). This is the underlying object with id, value and extensions. The accessor "getOperator" gives direct access to the value
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
         * @param value {@link #operator} (The operator type defines the conditional behavior of the assert.). This is the underlying object with id, value and extensions. The accessor "getOperator" gives direct access to the value
         */
        public SetupActionAssertComponent setOperatorElement(Enumeration<AssertionOperatorType> value) { 
          this.operator = value;
          return this;
        }

        /**
         * @return The operator type defines the conditional behavior of the assert.
         */
        public AssertionOperatorType getOperator() { 
          return this.operator == null ? null : this.operator.getValue();
        }

        /**
         * @param value The operator type defines the conditional behavior of the assert.
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
         * @return {@link #resource} (The type of the resource.  See the [resource list](resourcelist.html).). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public UriType getResourceElement() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new UriType(); // bb
          return this.resource;
        }

        public boolean hasResourceElement() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (The type of the resource.  See the [resource list](resourcelist.html).). This is the underlying object with id, value and extensions. The accessor "getResource" gives direct access to the value
         */
        public SetupActionAssertComponent setResourceElement(UriType value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return The type of the resource.  See the [resource list](resourcelist.html).
         */
        public String getResource() { 
          return this.resource == null ? null : this.resource.getValue();
        }

        /**
         * @param value The type of the resource.  See the [resource list](resourcelist.html).
         */
        public SetupActionAssertComponent setResource(String value) { 
          if (Utilities.noString(value))
            this.resource = null;
          else {
            if (this.resource == null)
              this.resource = new UriType();
            this.resource.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #response} (continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.). This is the underlying object with id, value and extensions. The accessor "getResponse" gives direct access to the value
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
         * @param value {@link #response} (continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.). This is the underlying object with id, value and extensions. The accessor "getResponse" gives direct access to the value
         */
        public SetupActionAssertComponent setResponseElement(Enumeration<AssertionResponseTypes> value) { 
          this.response = value;
          return this;
        }

        /**
         * @return continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.
         */
        public AssertionResponseTypes getResponse() { 
          return this.response == null ? null : this.response.getValue();
        }

        /**
         * @param value continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.
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
         * @return {@link #stopTestOnFail} (Whether or not the current test execution will stop on failure for this assert.). This is the underlying object with id, value and extensions. The accessor "getStopTestOnFail" gives direct access to the value
         */
        public BooleanType getStopTestOnFailElement() { 
          if (this.stopTestOnFail == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SetupActionAssertComponent.stopTestOnFail");
            else if (Configuration.doAutoCreate())
              this.stopTestOnFail = new BooleanType(); // bb
          return this.stopTestOnFail;
        }

        public boolean hasStopTestOnFailElement() { 
          return this.stopTestOnFail != null && !this.stopTestOnFail.isEmpty();
        }

        public boolean hasStopTestOnFail() { 
          return this.stopTestOnFail != null && !this.stopTestOnFail.isEmpty();
        }

        /**
         * @param value {@link #stopTestOnFail} (Whether or not the current test execution will stop on failure for this assert.). This is the underlying object with id, value and extensions. The accessor "getStopTestOnFail" gives direct access to the value
         */
        public SetupActionAssertComponent setStopTestOnFailElement(BooleanType value) { 
          this.stopTestOnFail = value;
          return this;
        }

        /**
         * @return Whether or not the current test execution will stop on failure for this assert.
         */
        public boolean getStopTestOnFail() { 
          return this.stopTestOnFail == null || this.stopTestOnFail.isEmpty() ? false : this.stopTestOnFail.getValue();
        }

        /**
         * @param value Whether or not the current test execution will stop on failure for this assert.
         */
        public SetupActionAssertComponent setStopTestOnFail(boolean value) { 
            if (this.stopTestOnFail == null)
              this.stopTestOnFail = new BooleanType();
            this.stopTestOnFail.setValue(value);
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

        /**
         * @return {@link #requirement} (Links or references providing traceability to the testing requirements for this assert.)
         */
        public List<SetupActionAssertRequirementComponent> getRequirement() { 
          if (this.requirement == null)
            this.requirement = new ArrayList<SetupActionAssertRequirementComponent>();
          return this.requirement;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SetupActionAssertComponent setRequirement(List<SetupActionAssertRequirementComponent> theRequirement) { 
          this.requirement = theRequirement;
          return this;
        }

        public boolean hasRequirement() { 
          if (this.requirement == null)
            return false;
          for (SetupActionAssertRequirementComponent item : this.requirement)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SetupActionAssertRequirementComponent addRequirement() { //3
          SetupActionAssertRequirementComponent t = new SetupActionAssertRequirementComponent();
          if (this.requirement == null)
            this.requirement = new ArrayList<SetupActionAssertRequirementComponent>();
          this.requirement.add(t);
          return t;
        }

        public SetupActionAssertComponent addRequirement(SetupActionAssertRequirementComponent t) { //3
          if (t == null)
            return this;
          if (this.requirement == null)
            this.requirement = new ArrayList<SetupActionAssertRequirementComponent>();
          this.requirement.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #requirement}, creating it if it does not already exist {3}
         */
        public SetupActionAssertRequirementComponent getRequirementFirstRep() { 
          if (getRequirement().isEmpty()) {
            addRequirement();
          }
          return getRequirement().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("label", "string", "The label would be used for tracking/logging purposes by test engines.", 0, 1, label));
          children.add(new Property("description", "string", "The description would be used by test engines for tracking and reporting purposes.", 0, 1, description));
          children.add(new Property("direction", "code", "The direction to use for the assertion.", 0, 1, direction));
          children.add(new Property("compareToSourceId", "string", "Id of the source fixture used as the contents to be evaluated by either the \"source/expression\" or \"sourceId/path\" definition.", 0, 1, compareToSourceId));
          children.add(new Property("compareToSourceExpression", "string", "The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourceExpression));
          children.add(new Property("compareToSourcePath", "string", "XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourcePath));
          children.add(new Property("contentType", "code", "The mime-type contents to compare against the request or response message 'Content-Type' header.", 0, 1, contentType));
          children.add(new Property("defaultManualCompletion", "code", "The default manual completion outcome applied to this assertion.", 0, 1, defaultManualCompletion));
          children.add(new Property("expression", "string", "The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.", 0, 1, expression));
          children.add(new Property("headerField", "string", "The HTTP header field name e.g. 'Location'.", 0, 1, headerField));
          children.add(new Property("minimumId", "string", "The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.", 0, 1, minimumId));
          children.add(new Property("navigationLinks", "boolean", "Whether or not the test execution performs validation on the bundle navigation links.", 0, 1, navigationLinks));
          children.add(new Property("operator", "code", "The operator type defines the conditional behavior of the assert.", 0, 1, operator));
          children.add(new Property("path", "string", "The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.", 0, 1, path));
          children.add(new Property("requestMethod", "code", "The request method or HTTP operation code to compare against that used by the client system under test.", 0, 1, requestMethod));
          children.add(new Property("requestURL", "string", "The value to use in a comparison against the request URL path string.", 0, 1, requestURL));
          children.add(new Property("resource", "uri", "The type of the resource.  See the [resource list](resourcelist.html).", 0, 1, resource));
          children.add(new Property("response", "code", "continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.", 0, 1, response));
          children.add(new Property("responseCode", "string", "The value of the HTTP response code to be tested.", 0, 1, responseCode));
          children.add(new Property("sourceId", "id", "Fixture to evaluate the XPath/JSONPath expression or the headerField  against.", 0, 1, sourceId));
          children.add(new Property("stopTestOnFail", "boolean", "Whether or not the current test execution will stop on failure for this assert.", 0, 1, stopTestOnFail));
          children.add(new Property("validateProfileId", "id", "The ID of the Profile to validate against.", 0, 1, validateProfileId));
          children.add(new Property("value", "string", "The value to compare to.", 0, 1, value));
          children.add(new Property("warningOnly", "boolean", "Whether or not the test execution will produce a warning only on error for this assert.", 0, 1, warningOnly));
          children.add(new Property("requirement", "", "Links or references providing traceability to the testing requirements for this assert.", 0, java.lang.Integer.MAX_VALUE, requirement));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 102727412: /*label*/  return new Property("label", "string", "The label would be used for tracking/logging purposes by test engines.", 0, 1, label);
          case -1724546052: /*description*/  return new Property("description", "string", "The description would be used by test engines for tracking and reporting purposes.", 0, 1, description);
          case -962590849: /*direction*/  return new Property("direction", "code", "The direction to use for the assertion.", 0, 1, direction);
          case 2081856758: /*compareToSourceId*/  return new Property("compareToSourceId", "string", "Id of the source fixture used as the contents to be evaluated by either the \"source/expression\" or \"sourceId/path\" definition.", 0, 1, compareToSourceId);
          case -1415702669: /*compareToSourceExpression*/  return new Property("compareToSourceExpression", "string", "The FHIRPath expression for a specific value to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourceExpression);
          case -790206144: /*compareToSourcePath*/  return new Property("compareToSourcePath", "string", "XPath or JSONPath expression to evaluate against the source fixture. When compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath must be defined, but not both.", 0, 1, compareToSourcePath);
          case -389131437: /*contentType*/  return new Property("contentType", "code", "The mime-type contents to compare against the request or response message 'Content-Type' header.", 0, 1, contentType);
          case 1448452259: /*defaultManualCompletion*/  return new Property("defaultManualCompletion", "code", "The default manual completion outcome applied to this assertion.", 0, 1, defaultManualCompletion);
          case -1795452264: /*expression*/  return new Property("expression", "string", "The FHIRPath expression to be evaluated against the request or response message contents - HTTP headers and payload.", 0, 1, expression);
          case 1160732269: /*headerField*/  return new Property("headerField", "string", "The HTTP header field name e.g. 'Location'.", 0, 1, headerField);
          case 818925001: /*minimumId*/  return new Property("minimumId", "string", "The ID of a fixture. Asserts that the response contains at a minimum the fixture specified by minimumId.", 0, 1, minimumId);
          case 1001488901: /*navigationLinks*/  return new Property("navigationLinks", "boolean", "Whether or not the test execution performs validation on the bundle navigation links.", 0, 1, navigationLinks);
          case -500553564: /*operator*/  return new Property("operator", "code", "The operator type defines the conditional behavior of the assert.", 0, 1, operator);
          case 3433509: /*path*/  return new Property("path", "string", "The XPath or JSONPath expression to be evaluated against the fixture representing the response received from server.", 0, 1, path);
          case 1217874000: /*requestMethod*/  return new Property("requestMethod", "code", "The request method or HTTP operation code to compare against that used by the client system under test.", 0, 1, requestMethod);
          case 37099616: /*requestURL*/  return new Property("requestURL", "string", "The value to use in a comparison against the request URL path string.", 0, 1, requestURL);
          case -341064690: /*resource*/  return new Property("resource", "uri", "The type of the resource.  See the [resource list](resourcelist.html).", 0, 1, resource);
          case -340323263: /*response*/  return new Property("response", "code", "continue | switchingProtocols | okay | created | accepted | nonAuthoritativeInformation | noContent | resetContent | partialContent | multipleChoices | movedPermanently | found | seeOther | notModified | useProxy | temporaryRedirect | permanentRedirect | badRequest | unauthorized | paymentRequired | forbidden | notFound | methodNotAllowed | notAcceptable | proxyAuthenticationRequired | requestTimeout | conflict | gone | lengthRequired | preconditionFailed | contentTooLarge | uriTooLong | unsupportedMediaType | rangeNotSatisfiable | expectationFailed | misdirectedRequest | unprocessableContent | upgradeRequired | internalServerError | notImplemented | badGateway | serviceUnavailable | gatewayTimeout | httpVersionNotSupported.", 0, 1, response);
          case 1438723534: /*responseCode*/  return new Property("responseCode", "string", "The value of the HTTP response code to be tested.", 0, 1, responseCode);
          case 1746327190: /*sourceId*/  return new Property("sourceId", "id", "Fixture to evaluate the XPath/JSONPath expression or the headerField  against.", 0, 1, sourceId);
          case -626616719: /*stopTestOnFail*/  return new Property("stopTestOnFail", "boolean", "Whether or not the current test execution will stop on failure for this assert.", 0, 1, stopTestOnFail);
          case 1555541038: /*validateProfileId*/  return new Property("validateProfileId", "id", "The ID of the Profile to validate against.", 0, 1, validateProfileId);
          case 111972721: /*value*/  return new Property("value", "string", "The value to compare to.", 0, 1, value);
          case -481159832: /*warningOnly*/  return new Property("warningOnly", "boolean", "Whether or not the test execution will produce a warning only on error for this assert.", 0, 1, warningOnly);
          case 363387971: /*requirement*/  return new Property("requirement", "", "Links or references providing traceability to the testing requirements for this assert.", 0, java.lang.Integer.MAX_VALUE, requirement);
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
        case 1448452259: /*defaultManualCompletion*/ return this.defaultManualCompletion == null ? new Base[0] : new Base[] {this.defaultManualCompletion}; // Enumeration<AssertionManualCompletionType>
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // StringType
        case 1160732269: /*headerField*/ return this.headerField == null ? new Base[0] : new Base[] {this.headerField}; // StringType
        case 818925001: /*minimumId*/ return this.minimumId == null ? new Base[0] : new Base[] {this.minimumId}; // StringType
        case 1001488901: /*navigationLinks*/ return this.navigationLinks == null ? new Base[0] : new Base[] {this.navigationLinks}; // BooleanType
        case -500553564: /*operator*/ return this.operator == null ? new Base[0] : new Base[] {this.operator}; // Enumeration<AssertionOperatorType>
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case 1217874000: /*requestMethod*/ return this.requestMethod == null ? new Base[0] : new Base[] {this.requestMethod}; // Enumeration<TestScriptRequestMethodCode>
        case 37099616: /*requestURL*/ return this.requestURL == null ? new Base[0] : new Base[] {this.requestURL}; // StringType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // UriType
        case -340323263: /*response*/ return this.response == null ? new Base[0] : new Base[] {this.response}; // Enumeration<AssertionResponseTypes>
        case 1438723534: /*responseCode*/ return this.responseCode == null ? new Base[0] : new Base[] {this.responseCode}; // StringType
        case 1746327190: /*sourceId*/ return this.sourceId == null ? new Base[0] : new Base[] {this.sourceId}; // IdType
        case -626616719: /*stopTestOnFail*/ return this.stopTestOnFail == null ? new Base[0] : new Base[] {this.stopTestOnFail}; // BooleanType
        case 1555541038: /*validateProfileId*/ return this.validateProfileId == null ? new Base[0] : new Base[] {this.validateProfileId}; // IdType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case -481159832: /*warningOnly*/ return this.warningOnly == null ? new Base[0] : new Base[] {this.warningOnly}; // BooleanType
        case 363387971: /*requirement*/ return this.requirement == null ? new Base[0] : this.requirement.toArray(new Base[this.requirement.size()]); // SetupActionAssertRequirementComponent
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
        case 1448452259: // defaultManualCompletion
          value = new AssertionManualCompletionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.defaultManualCompletion = (Enumeration) value; // Enumeration<AssertionManualCompletionType>
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
          this.resource = TypeConvertor.castToUri(value); // UriType
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
        case -626616719: // stopTestOnFail
          this.stopTestOnFail = TypeConvertor.castToBoolean(value); // BooleanType
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
        case 363387971: // requirement
          this.getRequirement().add((SetupActionAssertRequirementComponent) value); // SetupActionAssertRequirementComponent
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
        } else if (name.equals("defaultManualCompletion")) {
          value = new AssertionManualCompletionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.defaultManualCompletion = (Enumeration) value; // Enumeration<AssertionManualCompletionType>
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
          this.resource = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("response")) {
          value = new AssertionResponseTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.response = (Enumeration) value; // Enumeration<AssertionResponseTypes>
        } else if (name.equals("responseCode")) {
          this.responseCode = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("sourceId")) {
          this.sourceId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("stopTestOnFail")) {
          this.stopTestOnFail = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("validateProfileId")) {
          this.validateProfileId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("warningOnly")) {
          this.warningOnly = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("requirement")) {
          this.getRequirement().add((SetupActionAssertRequirementComponent) value);
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
        case 1448452259:  return getDefaultManualCompletionElement();
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
        case -626616719:  return getStopTestOnFailElement();
        case 1555541038:  return getValidateProfileIdElement();
        case 111972721:  return getValueElement();
        case -481159832:  return getWarningOnlyElement();
        case 363387971:  return addRequirement(); 
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
        case 1448452259: /*defaultManualCompletion*/ return new String[] {"code"};
        case -1795452264: /*expression*/ return new String[] {"string"};
        case 1160732269: /*headerField*/ return new String[] {"string"};
        case 818925001: /*minimumId*/ return new String[] {"string"};
        case 1001488901: /*navigationLinks*/ return new String[] {"boolean"};
        case -500553564: /*operator*/ return new String[] {"code"};
        case 3433509: /*path*/ return new String[] {"string"};
        case 1217874000: /*requestMethod*/ return new String[] {"code"};
        case 37099616: /*requestURL*/ return new String[] {"string"};
        case -341064690: /*resource*/ return new String[] {"uri"};
        case -340323263: /*response*/ return new String[] {"code"};
        case 1438723534: /*responseCode*/ return new String[] {"string"};
        case 1746327190: /*sourceId*/ return new String[] {"id"};
        case -626616719: /*stopTestOnFail*/ return new String[] {"boolean"};
        case 1555541038: /*validateProfileId*/ return new String[] {"id"};
        case 111972721: /*value*/ return new String[] {"string"};
        case -481159832: /*warningOnly*/ return new String[] {"boolean"};
        case 363387971: /*requirement*/ return new String[] {};
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
        else if (name.equals("defaultManualCompletion")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.defaultManualCompletion");
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
        else if (name.equals("stopTestOnFail")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.setup.action.assert.stopTestOnFail");
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
        else if (name.equals("requirement")) {
          return addRequirement();
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
        dst.defaultManualCompletion = defaultManualCompletion == null ? null : defaultManualCompletion.copy();
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
        dst.stopTestOnFail = stopTestOnFail == null ? null : stopTestOnFail.copy();
        dst.validateProfileId = validateProfileId == null ? null : validateProfileId.copy();
        dst.value = value == null ? null : value.copy();
        dst.warningOnly = warningOnly == null ? null : warningOnly.copy();
        if (requirement != null) {
          dst.requirement = new ArrayList<SetupActionAssertRequirementComponent>();
          for (SetupActionAssertRequirementComponent i : requirement)
            dst.requirement.add(i.copy());
        };
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
           && compareDeep(defaultManualCompletion, o.defaultManualCompletion, true) && compareDeep(expression, o.expression, true)
           && compareDeep(headerField, o.headerField, true) && compareDeep(minimumId, o.minimumId, true) && compareDeep(navigationLinks, o.navigationLinks, true)
           && compareDeep(operator, o.operator, true) && compareDeep(path, o.path, true) && compareDeep(requestMethod, o.requestMethod, true)
           && compareDeep(requestURL, o.requestURL, true) && compareDeep(resource, o.resource, true) && compareDeep(response, o.response, true)
           && compareDeep(responseCode, o.responseCode, true) && compareDeep(sourceId, o.sourceId, true) && compareDeep(stopTestOnFail, o.stopTestOnFail, true)
           && compareDeep(validateProfileId, o.validateProfileId, true) && compareDeep(value, o.value, true)
           && compareDeep(warningOnly, o.warningOnly, true) && compareDeep(requirement, o.requirement, true)
          ;
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
           && compareValues(defaultManualCompletion, o.defaultManualCompletion, true) && compareValues(expression, o.expression, true)
           && compareValues(headerField, o.headerField, true) && compareValues(minimumId, o.minimumId, true) && compareValues(navigationLinks, o.navigationLinks, true)
           && compareValues(operator, o.operator, true) && compareValues(path, o.path, true) && compareValues(requestMethod, o.requestMethod, true)
           && compareValues(requestURL, o.requestURL, true) && compareValues(resource, o.resource, true) && compareValues(response, o.response, true)
           && compareValues(responseCode, o.responseCode, true) && compareValues(sourceId, o.sourceId, true) && compareValues(stopTestOnFail, o.stopTestOnFail, true)
           && compareValues(validateProfileId, o.validateProfileId, true) && compareValues(value, o.value, true)
           && compareValues(warningOnly, o.warningOnly, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(label, description, direction
          , compareToSourceId, compareToSourceExpression, compareToSourcePath, contentType, defaultManualCompletion
          , expression, headerField, minimumId, navigationLinks, operator, path, requestMethod
          , requestURL, resource, response, responseCode, sourceId, stopTestOnFail, validateProfileId
          , value, warningOnly, requirement);
      }

  public String fhirType() {
    return "TestScript.setup.action.assert";

  }

  }

    @Block()
    public static class SetupActionAssertRequirementComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Link or reference providing traceability to the testing requirement for this test.
         */
        @Child(name = "link", type = {UriType.class, CanonicalType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Link or reference to the testing requirement", formalDefinition="Link or reference providing traceability to the testing requirement for this test." )
        protected DataType link;

        private static final long serialVersionUID = -91187948L;

    /**
     * Constructor
     */
      public SetupActionAssertRequirementComponent() {
        super();
      }

        /**
         * @return {@link #link} (Link or reference providing traceability to the testing requirement for this test.)
         */
        public DataType getLink() { 
          return this.link;
        }

        /**
         * @return {@link #link} (Link or reference providing traceability to the testing requirement for this test.)
         */
        public UriType getLinkUriType() throws FHIRException { 
          if (this.link == null)
            this.link = new UriType();
          if (!(this.link instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.link.getClass().getName()+" was encountered");
          return (UriType) this.link;
        }

        public boolean hasLinkUriType() { 
          return this != null && this.link instanceof UriType;
        }

        /**
         * @return {@link #link} (Link or reference providing traceability to the testing requirement for this test.)
         */
        public CanonicalType getLinkCanonicalType() throws FHIRException { 
          if (this.link == null)
            this.link = new CanonicalType();
          if (!(this.link instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.link.getClass().getName()+" was encountered");
          return (CanonicalType) this.link;
        }

        public boolean hasLinkCanonicalType() { 
          return this != null && this.link instanceof CanonicalType;
        }

        public boolean hasLink() { 
          return this.link != null && !this.link.isEmpty();
        }

        /**
         * @param value {@link #link} (Link or reference providing traceability to the testing requirement for this test.)
         */
        public SetupActionAssertRequirementComponent setLink(DataType value) { 
          if (value != null && !(value instanceof UriType || value instanceof CanonicalType))
            throw new Error("Not the right type for TestScript.setup.action.assert.requirement.link[x]: "+value.fhirType());
          this.link = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("link[x]", "uri|canonical(Requirements)", "Link or reference providing traceability to the testing requirement for this test.", 0, 1, link));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 177076806: /*link[x]*/  return new Property("link[x]", "uri|canonical(Requirements)", "Link or reference providing traceability to the testing requirement for this test.", 0, 1, link);
          case 3321850: /*link*/  return new Property("link[x]", "uri|canonical(Requirements)", "Link or reference providing traceability to the testing requirement for this test.", 0, 1, link);
          case 177070866: /*linkUri*/  return new Property("link[x]", "uri", "Link or reference providing traceability to the testing requirement for this test.", 0, 1, link);
          case -2064880102: /*linkCanonical*/  return new Property("link[x]", "canonical(Requirements)", "Link or reference providing traceability to the testing requirement for this test.", 0, 1, link);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3321850: /*link*/ return this.link == null ? new Base[0] : new Base[] {this.link}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3321850: // link
          this.link = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("link[x]")) {
          this.link = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 177076806:  return getLink();
        case 3321850:  return getLink();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3321850: /*link*/ return new String[] {"uri", "canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkUri")) {
          this.link = new UriType();
          return this.link;
        }
        else if (name.equals("linkCanonical")) {
          this.link = new CanonicalType();
          return this.link;
        }
        else
          return super.addChild(name);
      }

      public SetupActionAssertRequirementComponent copy() {
        SetupActionAssertRequirementComponent dst = new SetupActionAssertRequirementComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SetupActionAssertRequirementComponent dst) {
        super.copyValues(dst);
        dst.link = link == null ? null : link.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SetupActionAssertRequirementComponent))
          return false;
        SetupActionAssertRequirementComponent o = (SetupActionAssertRequirementComponent) other_;
        return compareDeep(link, o.link, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SetupActionAssertRequirementComponent))
          return false;
        SetupActionAssertRequirementComponent o = (SetupActionAssertRequirementComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(link);
      }

  public String fhirType() {
    return "TestScript.setup.action.assert.requirement";

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
     * An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this test script, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the test script", formalDefinition="A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the test script", formalDefinition="The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this test script (computer friendly)", formalDefinition="A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the test script.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this test script (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the test script." )
    protected StringType title;

    /**
     * The status of this test script. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this test script. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the test script.
     */
    @Child(name = "publisher", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the test script." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the test script from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the test script", formalDefinition="A free text natural language description of the test script from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the test script is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for test script (if applicable)", formalDefinition="A legal or geographic region in which the test script is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this test script is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this test script is defined", formalDefinition="Explanation of why this test script is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * An abstract server used in operations within this test script in the origin element.
     */
    @Child(name = "origin", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An abstract server representing a client or sender in a message exchange", formalDefinition="An abstract server used in operations within this test script in the origin element." )
    protected List<TestScriptOriginComponent> origin;

    /**
     * An abstract server used in operations within this test script in the destination element.
     */
    @Child(name = "destination", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An abstract server representing a destination or receiver in a message exchange", formalDefinition="An abstract server used in operations within this test script in the destination element." )
    protected List<TestScriptDestinationComponent> destination;

    /**
     * The required capability must exist and are assumed to function correctly on the FHIR server being tested.
     */
    @Child(name = "metadata", type = {}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Required capability that is assumed to function correctly on the FHIR server being tested", formalDefinition="The required capability must exist and are assumed to function correctly on the FHIR server being tested." )
    protected TestScriptMetadataComponent metadata;

    /**
     * The scope indicates a conformance artifact that is tested by the test(s) within this test case and the expectation of the test outcome(s) as well as the intended test phase inclusion.
     */
    @Child(name = "scope", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Indication of the artifact(s) that are tested by this test case", formalDefinition="The scope indicates a conformance artifact that is tested by the test(s) within this test case and the expectation of the test outcome(s) as well as the intended test phase inclusion." )
    protected List<TestScriptScopeComponent> scope;

    /**
     * Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.
     */
    @Child(name = "fixture", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Fixture in the test script - by reference (uri)", formalDefinition="Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute." )
    protected List<TestScriptFixtureComponent> fixture;

    /**
     * Reference to the profile to be used for validation.
     */
    @Child(name = "profile", type = {CanonicalType.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reference of the validation profile", formalDefinition="Reference to the profile to be used for validation." )
    protected List<CanonicalType> profile;

    /**
     * Variable is set based either on element value in response body or on header field value in the response headers.
     */
    @Child(name = "variable", type = {}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Placeholder for evaluated elements", formalDefinition="Variable is set based either on element value in response body or on header field value in the response headers." )
    protected List<TestScriptVariableComponent> variable;

    /**
     * A series of required setup operations before tests are executed.
     */
    @Child(name = "setup", type = {}, order=24, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A series of required setup operations before tests are executed", formalDefinition="A series of required setup operations before tests are executed." )
    protected TestScriptSetupComponent setup;

    /**
     * A test in this script.
     */
    @Child(name = "test", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A test in this script", formalDefinition="A test in this script." )
    protected List<TestScriptTestComponent> test;

    /**
     * A series of operations required to clean up after all the tests are executed (successfully or otherwise).
     */
    @Child(name = "teardown", type = {}, order=26, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A series of required clean up steps", formalDefinition="A series of operations required to clean up after all the tests are executed (successfully or otherwise)." )
    protected TestScriptTeardownComponent teardown;

    private static final long serialVersionUID = 1566648997L;

  /**
   * Constructor
   */
    public TestScript() {
      super();
    }

  /**
   * Constructor
   */
    public TestScript(String name, PublicationStatus status) {
      super();
      this.setName(name);
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
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
     * @param value {@link #url} (An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public TestScript setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.
     */
    public TestScript setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setIdentifier(List<Identifier> theIdentifier) { 
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

    public TestScript addIdentifier(Identifier t) { //3
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
    public TestScript setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new Error("Not the right type for TestScript.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
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
     * @return {@link #date} (The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
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
     * @param value {@link #date} (The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public TestScript setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the test script.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the test script.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public TestScript setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the test script.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the test script.
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
          throw new Error("Attempt to auto-create TestScript.copyrightLabel");
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
    public TestScript setCopyrightLabelElement(StringType value) { 
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
    public TestScript setCopyrightLabel(String value) { 
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
     * @return {@link #scope} (The scope indicates a conformance artifact that is tested by the test(s) within this test case and the expectation of the test outcome(s) as well as the intended test phase inclusion.)
     */
    public List<TestScriptScopeComponent> getScope() { 
      if (this.scope == null)
        this.scope = new ArrayList<TestScriptScopeComponent>();
      return this.scope;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setScope(List<TestScriptScopeComponent> theScope) { 
      this.scope = theScope;
      return this;
    }

    public boolean hasScope() { 
      if (this.scope == null)
        return false;
      for (TestScriptScopeComponent item : this.scope)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestScriptScopeComponent addScope() { //3
      TestScriptScopeComponent t = new TestScriptScopeComponent();
      if (this.scope == null)
        this.scope = new ArrayList<TestScriptScopeComponent>();
      this.scope.add(t);
      return t;
    }

    public TestScript addScope(TestScriptScopeComponent t) { //3
      if (t == null)
        return this;
      if (this.scope == null)
        this.scope = new ArrayList<TestScriptScopeComponent>();
      this.scope.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #scope}, creating it if it does not already exist {3}
     */
    public TestScriptScopeComponent getScopeFirstRep() { 
      if (getScope().isEmpty()) {
        addScope();
      }
      return getScope().get(0);
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
    public List<CanonicalType> getProfile() { 
      if (this.profile == null)
        this.profile = new ArrayList<CanonicalType>();
      return this.profile;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestScript setProfile(List<CanonicalType> theProfile) { 
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
     * @return {@link #profile} (Reference to the profile to be used for validation.)
     */
    public CanonicalType addProfileElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.profile == null)
        this.profile = new ArrayList<CanonicalType>();
      this.profile.add(t);
      return t;
    }

    /**
     * @param value {@link #profile} (Reference to the profile to be used for validation.)
     */
    public TestScript addProfile(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.profile == null)
        this.profile = new ArrayList<CanonicalType>();
      this.profile.add(t);
      return this;
    }

    /**
     * @param value {@link #profile} (Reference to the profile to be used for validation.)
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
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the test script.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this test script. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the test script.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the test script from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the test script is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this test script is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("origin", "", "An abstract server used in operations within this test script in the origin element.", 0, java.lang.Integer.MAX_VALUE, origin));
        children.add(new Property("destination", "", "An abstract server used in operations within this test script in the destination element.", 0, java.lang.Integer.MAX_VALUE, destination));
        children.add(new Property("metadata", "", "The required capability must exist and are assumed to function correctly on the FHIR server being tested.", 0, 1, metadata));
        children.add(new Property("scope", "", "The scope indicates a conformance artifact that is tested by the test(s) within this test case and the expectation of the test outcome(s) as well as the intended test phase inclusion.", 0, java.lang.Integer.MAX_VALUE, scope));
        children.add(new Property("fixture", "", "Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.", 0, java.lang.Integer.MAX_VALUE, fixture));
        children.add(new Property("profile", "canonical(StructureDefinition)", "Reference to the profile to be used for validation.", 0, java.lang.Integer.MAX_VALUE, profile));
        children.add(new Property("variable", "", "Variable is set based either on element value in response body or on header field value in the response headers.", 0, java.lang.Integer.MAX_VALUE, variable));
        children.add(new Property("setup", "", "A series of required setup operations before tests are executed.", 0, 1, setup));
        children.add(new Property("test", "", "A test in this script.", 0, java.lang.Integer.MAX_VALUE, test));
        children.add(new Property("teardown", "", "A series of operations required to clean up after all the tests are executed (successfully or otherwise).", 0, 1, teardown));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this test script when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test script is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test script is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this test script when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the test script when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the test script author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the test script. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the test script.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this test script. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this test script is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the test script was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test script changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the test script.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the test script from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test script instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the test script is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this test script is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the test script and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test script.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case -1008619738: /*origin*/  return new Property("origin", "", "An abstract server used in operations within this test script in the origin element.", 0, java.lang.Integer.MAX_VALUE, origin);
        case -1429847026: /*destination*/  return new Property("destination", "", "An abstract server used in operations within this test script in the destination element.", 0, java.lang.Integer.MAX_VALUE, destination);
        case -450004177: /*metadata*/  return new Property("metadata", "", "The required capability must exist and are assumed to function correctly on the FHIR server being tested.", 0, 1, metadata);
        case 109264468: /*scope*/  return new Property("scope", "", "The scope indicates a conformance artifact that is tested by the test(s) within this test case and the expectation of the test outcome(s) as well as the intended test phase inclusion.", 0, java.lang.Integer.MAX_VALUE, scope);
        case -843449847: /*fixture*/  return new Property("fixture", "", "Fixture in the test script - by reference (uri). All fixtures are required for the test script to execute.", 0, java.lang.Integer.MAX_VALUE, fixture);
        case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition)", "Reference to the profile to be used for validation.", 0, java.lang.Integer.MAX_VALUE, profile);
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
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : this.origin.toArray(new Base[this.origin.size()]); // TestScriptOriginComponent
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : this.destination.toArray(new Base[this.destination.size()]); // TestScriptDestinationComponent
        case -450004177: /*metadata*/ return this.metadata == null ? new Base[0] : new Base[] {this.metadata}; // TestScriptMetadataComponent
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : this.scope.toArray(new Base[this.scope.size()]); // TestScriptScopeComponent
        case -843449847: /*fixture*/ return this.fixture == null ? new Base[0] : this.fixture.toArray(new Base[this.fixture.size()]); // TestScriptFixtureComponent
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : this.profile.toArray(new Base[this.profile.size()]); // CanonicalType
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
        case -1008619738: // origin
          this.getOrigin().add((TestScriptOriginComponent) value); // TestScriptOriginComponent
          return value;
        case -1429847026: // destination
          this.getDestination().add((TestScriptDestinationComponent) value); // TestScriptDestinationComponent
          return value;
        case -450004177: // metadata
          this.metadata = (TestScriptMetadataComponent) value; // TestScriptMetadataComponent
          return value;
        case 109264468: // scope
          this.getScope().add((TestScriptScopeComponent) value); // TestScriptScopeComponent
          return value;
        case -843449847: // fixture
          this.getFixture().add((TestScriptFixtureComponent) value); // TestScriptFixtureComponent
          return value;
        case -309425751: // profile
          this.getProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
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
        } else if (name.equals("origin")) {
          this.getOrigin().add((TestScriptOriginComponent) value);
        } else if (name.equals("destination")) {
          this.getDestination().add((TestScriptDestinationComponent) value);
        } else if (name.equals("metadata")) {
          this.metadata = (TestScriptMetadataComponent) value; // TestScriptMetadataComponent
        } else if (name.equals("scope")) {
          this.getScope().add((TestScriptScopeComponent) value);
        } else if (name.equals("fixture")) {
          this.getFixture().add((TestScriptFixtureComponent) value);
        } else if (name.equals("profile")) {
          this.getProfile().add(TypeConvertor.castToCanonical(value));
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
        case -1008619738:  return addOrigin(); 
        case -1429847026:  return addDestination(); 
        case -450004177:  return getMetadata();
        case 109264468:  return addScope(); 
        case -843449847:  return addFixture(); 
        case -309425751:  return addProfileElement();
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
        case -1008619738: /*origin*/ return new String[] {};
        case -1429847026: /*destination*/ return new String[] {};
        case -450004177: /*metadata*/ return new String[] {};
        case 109264468: /*scope*/ return new String[] {};
        case -843449847: /*fixture*/ return new String[] {};
        case -309425751: /*profile*/ return new String[] {"canonical"};
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
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.version");
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
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.copyrightLabel");
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
        else if (name.equals("scope")) {
          return addScope();
        }
        else if (name.equals("fixture")) {
          return addFixture();
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestScript.profile");
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
        if (scope != null) {
          dst.scope = new ArrayList<TestScriptScopeComponent>();
          for (TestScriptScopeComponent i : scope)
            dst.scope.add(i.copy());
        };
        if (fixture != null) {
          dst.fixture = new ArrayList<TestScriptFixtureComponent>();
          for (TestScriptFixtureComponent i : fixture)
            dst.fixture.add(i.copy());
        };
        if (profile != null) {
          dst.profile = new ArrayList<CanonicalType>();
          for (CanonicalType i : profile)
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
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(origin, o.origin, true) && compareDeep(destination, o.destination, true) && compareDeep(metadata, o.metadata, true)
           && compareDeep(scope, o.scope, true) && compareDeep(fixture, o.fixture, true) && compareDeep(profile, o.profile, true)
           && compareDeep(variable, o.variable, true) && compareDeep(setup, o.setup, true) && compareDeep(test, o.test, true)
           && compareDeep(teardown, o.teardown, true);
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
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(profile, o.profile, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, experimental, date, publisher, contact
          , description, useContext, jurisdiction, purpose, copyright, copyrightLabel, origin
          , destination, metadata, scope, fixture, profile, variable, setup, test, teardown
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.TestScript;
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

 /**
   * Search parameter: <b>scope-artifact</b>
   * <p>
   * Description: <b>The artifact under test</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>TestScript.scope.artifact</b><br>
   * </p>
   */
  @SearchParamDefinition(name="scope-artifact", path="TestScript.scope.artifact", description="The artifact under test", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SCOPE_ARTIFACT = "scope-artifact";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>scope-artifact</b>
   * <p>
   * Description: <b>The artifact under test</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>TestScript.scope.artifact</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SCOPE_ARTIFACT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SCOPE_ARTIFACT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>TestScript:scope-artifact</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SCOPE_ARTIFACT = new ca.uhn.fhir.model.api.Include("TestScript:scope-artifact").toLocked();

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


}

