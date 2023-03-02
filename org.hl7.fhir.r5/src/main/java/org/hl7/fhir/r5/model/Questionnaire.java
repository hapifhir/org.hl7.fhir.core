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
 * A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.
 */
@ResourceDef(name="Questionnaire", profile="http://hl7.org/fhir/StructureDefinition/Questionnaire")
public class Questionnaire extends MetadataResource {

    public enum EnableWhenBehavior {
        /**
         * Enable the question when all the enableWhen criteria are satisfied.
         */
        ALL, 
        /**
         * Enable the question when any of the enableWhen criteria are satisfied.
         */
        ANY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EnableWhenBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("all".equals(codeString))
          return ALL;
        if ("any".equals(codeString))
          return ANY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EnableWhenBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ALL: return "all";
            case ANY: return "any";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ALL: return "http://hl7.org/fhir/questionnaire-enable-behavior";
            case ANY: return "http://hl7.org/fhir/questionnaire-enable-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ALL: return "Enable the question when all the enableWhen criteria are satisfied.";
            case ANY: return "Enable the question when any of the enableWhen criteria are satisfied.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ALL: return "All";
            case ANY: return "Any";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EnableWhenBehaviorEnumFactory implements EnumFactory<EnableWhenBehavior> {
    public EnableWhenBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("all".equals(codeString))
          return EnableWhenBehavior.ALL;
        if ("any".equals(codeString))
          return EnableWhenBehavior.ANY;
        throw new IllegalArgumentException("Unknown EnableWhenBehavior code '"+codeString+"'");
        }
        public Enumeration<EnableWhenBehavior> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EnableWhenBehavior>(this, EnableWhenBehavior.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<EnableWhenBehavior>(this, EnableWhenBehavior.NULL, code);
        if ("all".equals(codeString))
          return new Enumeration<EnableWhenBehavior>(this, EnableWhenBehavior.ALL, code);
        if ("any".equals(codeString))
          return new Enumeration<EnableWhenBehavior>(this, EnableWhenBehavior.ANY, code);
        throw new FHIRException("Unknown EnableWhenBehavior code '"+codeString+"'");
        }
    public String toCode(EnableWhenBehavior code) {
      if (code == EnableWhenBehavior.ALL)
        return "all";
      if (code == EnableWhenBehavior.ANY)
        return "any";
      return "?";
      }
    public String toSystem(EnableWhenBehavior code) {
      return code.getSystem();
      }
    }

    public enum QuestionnaireAnswerConstraint {
        /**
         * Only values listed as answerOption or in the expansion of the answerValueSet are permitted
         */
        OPTIONSONLY, 
        /**
         * In addition to the values listed as answerOption or in the expansion of the answerValueSet, any other values that correspond to the specified item.type are permitted
         */
        OPTIONSORTYPE, 
        /**
         * In addition to the values listed as answerOption or in the expansion of the answerValueSet, free-text strings are permitted.  Answers will have a type of 'string'.
         */
        OPTIONSORSTRING, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static QuestionnaireAnswerConstraint fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("optionsOnly".equals(codeString))
          return OPTIONSONLY;
        if ("optionsOrType".equals(codeString))
          return OPTIONSORTYPE;
        if ("optionsOrString".equals(codeString))
          return OPTIONSORSTRING;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown QuestionnaireAnswerConstraint code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case OPTIONSONLY: return "optionsOnly";
            case OPTIONSORTYPE: return "optionsOrType";
            case OPTIONSORSTRING: return "optionsOrString";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case OPTIONSONLY: return "http://hl7.org/fhir/questionnaire-answer-constraint";
            case OPTIONSORTYPE: return "http://hl7.org/fhir/questionnaire-answer-constraint";
            case OPTIONSORSTRING: return "http://hl7.org/fhir/questionnaire-answer-constraint";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case OPTIONSONLY: return "Only values listed as answerOption or in the expansion of the answerValueSet are permitted";
            case OPTIONSORTYPE: return "In addition to the values listed as answerOption or in the expansion of the answerValueSet, any other values that correspond to the specified item.type are permitted";
            case OPTIONSORSTRING: return "In addition to the values listed as answerOption or in the expansion of the answerValueSet, free-text strings are permitted.  Answers will have a type of 'string'.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case OPTIONSONLY: return "Options only";
            case OPTIONSORTYPE: return "Options or 'type'";
            case OPTIONSORSTRING: return "Options or string";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class QuestionnaireAnswerConstraintEnumFactory implements EnumFactory<QuestionnaireAnswerConstraint> {
    public QuestionnaireAnswerConstraint fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("optionsOnly".equals(codeString))
          return QuestionnaireAnswerConstraint.OPTIONSONLY;
        if ("optionsOrType".equals(codeString))
          return QuestionnaireAnswerConstraint.OPTIONSORTYPE;
        if ("optionsOrString".equals(codeString))
          return QuestionnaireAnswerConstraint.OPTIONSORSTRING;
        throw new IllegalArgumentException("Unknown QuestionnaireAnswerConstraint code '"+codeString+"'");
        }
        public Enumeration<QuestionnaireAnswerConstraint> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<QuestionnaireAnswerConstraint>(this, QuestionnaireAnswerConstraint.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<QuestionnaireAnswerConstraint>(this, QuestionnaireAnswerConstraint.NULL, code);
        if ("optionsOnly".equals(codeString))
          return new Enumeration<QuestionnaireAnswerConstraint>(this, QuestionnaireAnswerConstraint.OPTIONSONLY, code);
        if ("optionsOrType".equals(codeString))
          return new Enumeration<QuestionnaireAnswerConstraint>(this, QuestionnaireAnswerConstraint.OPTIONSORTYPE, code);
        if ("optionsOrString".equals(codeString))
          return new Enumeration<QuestionnaireAnswerConstraint>(this, QuestionnaireAnswerConstraint.OPTIONSORSTRING, code);
        throw new FHIRException("Unknown QuestionnaireAnswerConstraint code '"+codeString+"'");
        }
    public String toCode(QuestionnaireAnswerConstraint code) {
      if (code == QuestionnaireAnswerConstraint.OPTIONSONLY)
        return "optionsOnly";
      if (code == QuestionnaireAnswerConstraint.OPTIONSORTYPE)
        return "optionsOrType";
      if (code == QuestionnaireAnswerConstraint.OPTIONSORSTRING)
        return "optionsOrString";
      return "?";
      }
    public String toSystem(QuestionnaireAnswerConstraint code) {
      return code.getSystem();
      }
    }

    public enum QuestionnaireItemDisabledDisplay {
        /**
         * The item (and its children) should not be visible to the user at all.
         */
        HIDDEN, 
        /**
         * The item (and possibly its children) should not be selectable or editable but should still be visible - to allow the user to see what questions *could* have been completed had other answers caused the item to be enabled.
         */
        PROTECTED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static QuestionnaireItemDisabledDisplay fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("hidden".equals(codeString))
          return HIDDEN;
        if ("protected".equals(codeString))
          return PROTECTED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown QuestionnaireItemDisabledDisplay code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case HIDDEN: return "hidden";
            case PROTECTED: return "protected";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case HIDDEN: return "http://hl7.org/fhir/questionnaire-disabled-display";
            case PROTECTED: return "http://hl7.org/fhir/questionnaire-disabled-display";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case HIDDEN: return "The item (and its children) should not be visible to the user at all.";
            case PROTECTED: return "The item (and possibly its children) should not be selectable or editable but should still be visible - to allow the user to see what questions *could* have been completed had other answers caused the item to be enabled.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case HIDDEN: return "Hidden";
            case PROTECTED: return "Protected";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class QuestionnaireItemDisabledDisplayEnumFactory implements EnumFactory<QuestionnaireItemDisabledDisplay> {
    public QuestionnaireItemDisabledDisplay fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("hidden".equals(codeString))
          return QuestionnaireItemDisabledDisplay.HIDDEN;
        if ("protected".equals(codeString))
          return QuestionnaireItemDisabledDisplay.PROTECTED;
        throw new IllegalArgumentException("Unknown QuestionnaireItemDisabledDisplay code '"+codeString+"'");
        }
        public Enumeration<QuestionnaireItemDisabledDisplay> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<QuestionnaireItemDisabledDisplay>(this, QuestionnaireItemDisabledDisplay.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<QuestionnaireItemDisabledDisplay>(this, QuestionnaireItemDisabledDisplay.NULL, code);
        if ("hidden".equals(codeString))
          return new Enumeration<QuestionnaireItemDisabledDisplay>(this, QuestionnaireItemDisabledDisplay.HIDDEN, code);
        if ("protected".equals(codeString))
          return new Enumeration<QuestionnaireItemDisabledDisplay>(this, QuestionnaireItemDisabledDisplay.PROTECTED, code);
        throw new FHIRException("Unknown QuestionnaireItemDisabledDisplay code '"+codeString+"'");
        }
    public String toCode(QuestionnaireItemDisabledDisplay code) {
      if (code == QuestionnaireItemDisabledDisplay.HIDDEN)
        return "hidden";
      if (code == QuestionnaireItemDisabledDisplay.PROTECTED)
        return "protected";
      return "?";
      }
    public String toSystem(QuestionnaireItemDisabledDisplay code) {
      return code.getSystem();
      }
    }

    public enum QuestionnaireItemOperator {
        /**
         * True if the determination of 'whether an answer exists for the question' is equal to the enableWhen answer (which must be a boolean).
         */
        EXISTS, 
        /**
         * True if at least one answer has a value that is equal to the enableWhen answer.
         */
        EQUAL, 
        /**
         * True if no answer has a value that is equal to the enableWhen answer.
         */
        NOT_EQUAL, 
        /**
         * True if at least one answer has a value that is greater than the enableWhen answer.
         */
        GREATER_THAN, 
        /**
         * True if at least one answer has a value that is less than the enableWhen answer.
         */
        LESS_THAN, 
        /**
         * True if at least one answer has a value that is greater or equal to the enableWhen answer.
         */
        GREATER_OR_EQUAL, 
        /**
         * True if at least one answer has a value that is less or equal to the enableWhen answer.
         */
        LESS_OR_EQUAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static QuestionnaireItemOperator fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("exists".equals(codeString))
          return EXISTS;
        if ("=".equals(codeString))
          return EQUAL;
        if ("!=".equals(codeString))
          return NOT_EQUAL;
        if (">".equals(codeString))
          return GREATER_THAN;
        if ("<".equals(codeString))
          return LESS_THAN;
        if (">=".equals(codeString))
          return GREATER_OR_EQUAL;
        if ("<=".equals(codeString))
          return LESS_OR_EQUAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown QuestionnaireItemOperator code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EXISTS: return "exists";
            case EQUAL: return "=";
            case NOT_EQUAL: return "!=";
            case GREATER_THAN: return ">";
            case LESS_THAN: return "<";
            case GREATER_OR_EQUAL: return ">=";
            case LESS_OR_EQUAL: return "<=";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EXISTS: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case EQUAL: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case NOT_EQUAL: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case GREATER_THAN: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case LESS_THAN: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case GREATER_OR_EQUAL: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case LESS_OR_EQUAL: return "http://hl7.org/fhir/questionnaire-enable-operator";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EXISTS: return "True if the determination of 'whether an answer exists for the question' is equal to the enableWhen answer (which must be a boolean).";
            case EQUAL: return "True if at least one answer has a value that is equal to the enableWhen answer.";
            case NOT_EQUAL: return "True if no answer has a value that is equal to the enableWhen answer.";
            case GREATER_THAN: return "True if at least one answer has a value that is greater than the enableWhen answer.";
            case LESS_THAN: return "True if at least one answer has a value that is less than the enableWhen answer.";
            case GREATER_OR_EQUAL: return "True if at least one answer has a value that is greater or equal to the enableWhen answer.";
            case LESS_OR_EQUAL: return "True if at least one answer has a value that is less or equal to the enableWhen answer.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EXISTS: return "Exists";
            case EQUAL: return "Equals";
            case NOT_EQUAL: return "Not Equals";
            case GREATER_THAN: return "Greater Than";
            case LESS_THAN: return "Less Than";
            case GREATER_OR_EQUAL: return "Greater or Equals";
            case LESS_OR_EQUAL: return "Less or Equals";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class QuestionnaireItemOperatorEnumFactory implements EnumFactory<QuestionnaireItemOperator> {
    public QuestionnaireItemOperator fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("exists".equals(codeString))
          return QuestionnaireItemOperator.EXISTS;
        if ("=".equals(codeString))
          return QuestionnaireItemOperator.EQUAL;
        if ("!=".equals(codeString))
          return QuestionnaireItemOperator.NOT_EQUAL;
        if (">".equals(codeString))
          return QuestionnaireItemOperator.GREATER_THAN;
        if ("<".equals(codeString))
          return QuestionnaireItemOperator.LESS_THAN;
        if (">=".equals(codeString))
          return QuestionnaireItemOperator.GREATER_OR_EQUAL;
        if ("<=".equals(codeString))
          return QuestionnaireItemOperator.LESS_OR_EQUAL;
        throw new IllegalArgumentException("Unknown QuestionnaireItemOperator code '"+codeString+"'");
        }
        public Enumeration<QuestionnaireItemOperator> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.NULL, code);
        if ("exists".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.EXISTS, code);
        if ("=".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.EQUAL, code);
        if ("!=".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.NOT_EQUAL, code);
        if (">".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.GREATER_THAN, code);
        if ("<".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.LESS_THAN, code);
        if (">=".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.GREATER_OR_EQUAL, code);
        if ("<=".equals(codeString))
          return new Enumeration<QuestionnaireItemOperator>(this, QuestionnaireItemOperator.LESS_OR_EQUAL, code);
        throw new FHIRException("Unknown QuestionnaireItemOperator code '"+codeString+"'");
        }
    public String toCode(QuestionnaireItemOperator code) {
      if (code == QuestionnaireItemOperator.EXISTS)
        return "exists";
      if (code == QuestionnaireItemOperator.EQUAL)
        return "=";
      if (code == QuestionnaireItemOperator.NOT_EQUAL)
        return "!=";
      if (code == QuestionnaireItemOperator.GREATER_THAN)
        return ">";
      if (code == QuestionnaireItemOperator.LESS_THAN)
        return "<";
      if (code == QuestionnaireItemOperator.GREATER_OR_EQUAL)
        return ">=";
      if (code == QuestionnaireItemOperator.LESS_OR_EQUAL)
        return "<=";
      return "?";
      }
    public String toSystem(QuestionnaireItemOperator code) {
      return code.getSystem();
      }
    }

    public enum QuestionnaireItemType {
        /**
         * An item with no direct answer but should have at least one child item.
         */
        GROUP, 
        /**
         * Text for display that will not capture an answer or have child items.
         */
        DISPLAY, 
        /**
         * An item that defines a specific answer to be captured, and which may have child items. (the answer provided in the QuestionnaireResponse should be of the defined datatype).
         */
        QUESTION, 
        /**
         * Question with a yes/no answer (valueBoolean).
         */
        BOOLEAN, 
        /**
         * Question with is a real number answer (valueDecimal).  There is an extension 'http://hl7.org/fhir/StructureDefinition/questionnaire-unit' that can be used to computably convey the unit of measure associated with the answer for use when performing data extraction to an element of type Quantity.
         */
        DECIMAL, 
        /**
         * Question with an integer answer (valueInteger).  There is an extension 'http://hl7.org/fhir/StructureDefinition/questionnaire-unit' that can be used to computably convey the unit of measure associated with the answer for use when performing data extraction to an element of type Quantity.
         */
        INTEGER, 
        /**
         * Question with a date answer (valueDate).
         */
        DATE, 
        /**
         * Question with a date and time answer (valueDateTime).
         */
        DATETIME, 
        /**
         * Question with a time (hour:minute:second) answer independent of date. (valueTime).
         */
        TIME, 
        /**
         * Question with a short (few words to short sentence) free-text entry answer (valueString).  Strings SHOULD NOT contain carriage return or newline characters.  If multi-line answers are needed, use the 'text' type.
         */
        STRING, 
        /**
         * Question with a long (potentially multi-paragraph) free-text entry answer (valueString).
         */
        TEXT, 
        /**
         * Question with a URL (website, FTP site, etc.) answer (valueUri).
         */
        URL, 
        /**
         * Question with a Coding - generally drawn from a list of possible answers (valueCoding)
         */
        CODING, 
        /**
         * Question with binary content such as an image, PDF, etc. as an answer (valueAttachment).
         */
        ATTACHMENT, 
        /**
         * Question with a reference to another resource (practitioner, organization, etc.) as an answer (valueReference).
         */
        REFERENCE, 
        /**
         * Question with a combination of a numeric value and unit as an answer. (valueSimpleQuantity)  There are two extensions ('http://hl7.org/fhir/StructureDefinition/questionnaire-unitOption' and 'http://hl7.org/fhir/StructureDefinition/questionnaire-unitValueSet')  that can be used to define what unit should be selected for the Quantity.code and Quantity.system.
         */
        QUANTITY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static QuestionnaireItemType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("group".equals(codeString))
          return GROUP;
        if ("display".equals(codeString))
          return DISPLAY;
        if ("question".equals(codeString))
          return QUESTION;
        if ("boolean".equals(codeString))
          return BOOLEAN;
        if ("decimal".equals(codeString))
          return DECIMAL;
        if ("integer".equals(codeString))
          return INTEGER;
        if ("date".equals(codeString))
          return DATE;
        if ("dateTime".equals(codeString))
          return DATETIME;
        if ("time".equals(codeString))
          return TIME;
        if ("string".equals(codeString))
          return STRING;
        if ("text".equals(codeString))
          return TEXT;
        if ("url".equals(codeString))
          return URL;
        if ("coding".equals(codeString))
          return CODING;
        if ("attachment".equals(codeString))
          return ATTACHMENT;
        if ("reference".equals(codeString))
          return REFERENCE;
        if ("quantity".equals(codeString))
          return QUANTITY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown QuestionnaireItemType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case GROUP: return "group";
            case DISPLAY: return "display";
            case QUESTION: return "question";
            case BOOLEAN: return "boolean";
            case DECIMAL: return "decimal";
            case INTEGER: return "integer";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case TIME: return "time";
            case STRING: return "string";
            case TEXT: return "text";
            case URL: return "url";
            case CODING: return "coding";
            case ATTACHMENT: return "attachment";
            case REFERENCE: return "reference";
            case QUANTITY: return "quantity";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case GROUP: return "http://hl7.org/fhir/item-type";
            case DISPLAY: return "http://hl7.org/fhir/item-type";
            case QUESTION: return "http://hl7.org/fhir/item-type";
            case BOOLEAN: return "http://hl7.org/fhir/item-type";
            case DECIMAL: return "http://hl7.org/fhir/item-type";
            case INTEGER: return "http://hl7.org/fhir/item-type";
            case DATE: return "http://hl7.org/fhir/item-type";
            case DATETIME: return "http://hl7.org/fhir/item-type";
            case TIME: return "http://hl7.org/fhir/item-type";
            case STRING: return "http://hl7.org/fhir/item-type";
            case TEXT: return "http://hl7.org/fhir/item-type";
            case URL: return "http://hl7.org/fhir/item-type";
            case CODING: return "http://hl7.org/fhir/item-type";
            case ATTACHMENT: return "http://hl7.org/fhir/item-type";
            case REFERENCE: return "http://hl7.org/fhir/item-type";
            case QUANTITY: return "http://hl7.org/fhir/item-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case GROUP: return "An item with no direct answer but should have at least one child item.";
            case DISPLAY: return "Text for display that will not capture an answer or have child items.";
            case QUESTION: return "An item that defines a specific answer to be captured, and which may have child items. (the answer provided in the QuestionnaireResponse should be of the defined datatype).";
            case BOOLEAN: return "Question with a yes/no answer (valueBoolean).";
            case DECIMAL: return "Question with is a real number answer (valueDecimal).  There is an extension 'http://hl7.org/fhir/StructureDefinition/questionnaire-unit' that can be used to computably convey the unit of measure associated with the answer for use when performing data extraction to an element of type Quantity.";
            case INTEGER: return "Question with an integer answer (valueInteger).  There is an extension 'http://hl7.org/fhir/StructureDefinition/questionnaire-unit' that can be used to computably convey the unit of measure associated with the answer for use when performing data extraction to an element of type Quantity.";
            case DATE: return "Question with a date answer (valueDate).";
            case DATETIME: return "Question with a date and time answer (valueDateTime).";
            case TIME: return "Question with a time (hour:minute:second) answer independent of date. (valueTime).";
            case STRING: return "Question with a short (few words to short sentence) free-text entry answer (valueString).  Strings SHOULD NOT contain carriage return or newline characters.  If multi-line answers are needed, use the 'text' type.";
            case TEXT: return "Question with a long (potentially multi-paragraph) free-text entry answer (valueString).";
            case URL: return "Question with a URL (website, FTP site, etc.) answer (valueUri).";
            case CODING: return "Question with a Coding - generally drawn from a list of possible answers (valueCoding)";
            case ATTACHMENT: return "Question with binary content such as an image, PDF, etc. as an answer (valueAttachment).";
            case REFERENCE: return "Question with a reference to another resource (practitioner, organization, etc.) as an answer (valueReference).";
            case QUANTITY: return "Question with a combination of a numeric value and unit as an answer. (valueSimpleQuantity)  There are two extensions ('http://hl7.org/fhir/StructureDefinition/questionnaire-unitOption' and 'http://hl7.org/fhir/StructureDefinition/questionnaire-unitValueSet')  that can be used to define what unit should be selected for the Quantity.code and Quantity.system.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case GROUP: return "Group";
            case DISPLAY: return "Display";
            case QUESTION: return "Question";
            case BOOLEAN: return "Boolean";
            case DECIMAL: return "Decimal";
            case INTEGER: return "Integer";
            case DATE: return "Date";
            case DATETIME: return "Date Time";
            case TIME: return "Time";
            case STRING: return "String";
            case TEXT: return "Text";
            case URL: return "Url";
            case CODING: return "Coding";
            case ATTACHMENT: return "Attachment";
            case REFERENCE: return "Reference";
            case QUANTITY: return "Quantity";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class QuestionnaireItemTypeEnumFactory implements EnumFactory<QuestionnaireItemType> {
    public QuestionnaireItemType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("group".equals(codeString))
          return QuestionnaireItemType.GROUP;
        if ("display".equals(codeString))
          return QuestionnaireItemType.DISPLAY;
        if ("question".equals(codeString))
          return QuestionnaireItemType.QUESTION;
        if ("boolean".equals(codeString))
          return QuestionnaireItemType.BOOLEAN;
        if ("decimal".equals(codeString))
          return QuestionnaireItemType.DECIMAL;
        if ("integer".equals(codeString))
          return QuestionnaireItemType.INTEGER;
        if ("date".equals(codeString))
          return QuestionnaireItemType.DATE;
        if ("dateTime".equals(codeString))
          return QuestionnaireItemType.DATETIME;
        if ("time".equals(codeString))
          return QuestionnaireItemType.TIME;
        if ("string".equals(codeString))
          return QuestionnaireItemType.STRING;
        if ("text".equals(codeString))
          return QuestionnaireItemType.TEXT;
        if ("url".equals(codeString))
          return QuestionnaireItemType.URL;
        if ("coding".equals(codeString))
          return QuestionnaireItemType.CODING;
        if ("attachment".equals(codeString))
          return QuestionnaireItemType.ATTACHMENT;
        if ("reference".equals(codeString))
          return QuestionnaireItemType.REFERENCE;
        if ("quantity".equals(codeString))
          return QuestionnaireItemType.QUANTITY;
        throw new IllegalArgumentException("Unknown QuestionnaireItemType code '"+codeString+"'");
        }
        public Enumeration<QuestionnaireItemType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.NULL, code);
        if ("group".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.GROUP, code);
        if ("display".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.DISPLAY, code);
        if ("question".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.QUESTION, code);
        if ("boolean".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.BOOLEAN, code);
        if ("decimal".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.DECIMAL, code);
        if ("integer".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.INTEGER, code);
        if ("date".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.DATE, code);
        if ("dateTime".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.DATETIME, code);
        if ("time".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.TIME, code);
        if ("string".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.STRING, code);
        if ("text".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.TEXT, code);
        if ("url".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.URL, code);
        if ("coding".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.CODING, code);
        if ("attachment".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.ATTACHMENT, code);
        if ("reference".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.REFERENCE, code);
        if ("quantity".equals(codeString))
          return new Enumeration<QuestionnaireItemType>(this, QuestionnaireItemType.QUANTITY, code);
        throw new FHIRException("Unknown QuestionnaireItemType code '"+codeString+"'");
        }
    public String toCode(QuestionnaireItemType code) {
      if (code == QuestionnaireItemType.GROUP)
        return "group";
      if (code == QuestionnaireItemType.DISPLAY)
        return "display";
      if (code == QuestionnaireItemType.QUESTION)
        return "question";
      if (code == QuestionnaireItemType.BOOLEAN)
        return "boolean";
      if (code == QuestionnaireItemType.DECIMAL)
        return "decimal";
      if (code == QuestionnaireItemType.INTEGER)
        return "integer";
      if (code == QuestionnaireItemType.DATE)
        return "date";
      if (code == QuestionnaireItemType.DATETIME)
        return "dateTime";
      if (code == QuestionnaireItemType.TIME)
        return "time";
      if (code == QuestionnaireItemType.STRING)
        return "string";
      if (code == QuestionnaireItemType.TEXT)
        return "text";
      if (code == QuestionnaireItemType.URL)
        return "url";
      if (code == QuestionnaireItemType.CODING)
        return "coding";
      if (code == QuestionnaireItemType.ATTACHMENT)
        return "attachment";
      if (code == QuestionnaireItemType.REFERENCE)
        return "reference";
      if (code == QuestionnaireItemType.QUANTITY)
        return "quantity";
      return "?";
      }
    public String toSystem(QuestionnaireItemType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class QuestionnaireItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Unique id for item in questionnaire", formalDefinition="An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource." )
        protected StringType linkId;

        /**
         * This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.
         */
        @Child(name = "definition", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ElementDefinition - details for the item", formalDefinition="This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below." )
        protected UriType definition;

        /**
         * A terminology code that corresponds to this group or question (e.g. a code from LOINC, which defines many questions and answers).
         */
        @Child(name = "code", type = {Coding.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Corresponding concept for this item in a terminology", formalDefinition="A terminology code that corresponds to this group or question (e.g. a code from LOINC, which defines many questions and answers)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-questions")
        protected List<Coding> code;

        /**
         * A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.
         */
        @Child(name = "prefix", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. \"1(a)\", \"2.5.3\"", formalDefinition="A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire." )
        protected StringType prefix;

        /**
         * The name of a section, the text of a question or text content for a display item.
         */
        @Child(name = "text", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Primary text for the item", formalDefinition="The name of a section, the text of a question or text content for a display item." )
        protected StringType text;

        /**
         * The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).
         */
        @Child(name = "type", type = {CodeType.class}, order=6, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="group | display | boolean | decimal | integer | date | dateTime +", formalDefinition="The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/item-type")
        protected Enumeration<QuestionnaireItemType> type;

        /**
         * A constraint indicating that this item should only be enabled (displayed/allow answers to be captured) when the specified condition is true.
         */
        @Child(name = "enableWhen", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=true, summary=false)
        @Description(shortDefinition="Only allow data when", formalDefinition="A constraint indicating that this item should only be enabled (displayed/allow answers to be captured) when the specified condition is true." )
        protected List<QuestionnaireItemEnableWhenComponent> enableWhen;

        /**
         * Controls how multiple enableWhen values are interpreted -  whether all or any must be true.
         */
        @Child(name = "enableBehavior", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="all | any", formalDefinition="Controls how multiple enableWhen values are interpreted -  whether all or any must be true." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-enable-behavior")
        protected Enumeration<EnableWhenBehavior> enableBehavior;

        /**
         * Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.
         */
        @Child(name = "disabledDisplay", type = {CodeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="hidden | protected", formalDefinition="Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-disabled-display")
        protected Enumeration<QuestionnaireItemDisabledDisplay> disabledDisplay;

        /**
         * An indication, if true, that the item must be present in a "completed" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.
         */
        @Child(name = "required", type = {BooleanType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the item must be included in data results", formalDefinition="An indication, if true, that the item must be present in a \"completed\" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire." )
        protected BooleanType required;

        /**
         * An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).
         */
        @Child(name = "repeats", type = {BooleanType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the item may repeat", formalDefinition="An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items)." )
        protected BooleanType repeats;

        /**
         * An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.
         */
        @Child(name = "readOnly", type = {BooleanType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Don't allow human editing", formalDefinition="An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire." )
        protected BooleanType readOnly;

        /**
         * The maximum number of characters that are permitted in the answer to be considered a "valid" QuestionnaireResponse.
         */
        @Child(name = "maxLength", type = {IntegerType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="No more than these many characters", formalDefinition="The maximum number of characters that are permitted in the answer to be considered a \"valid\" QuestionnaireResponse." )
        protected IntegerType maxLength;

        /**
         * For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.
         */
        @Child(name = "answerConstraint", type = {CodeType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="optionsOnly | optionsOrType | optionsOrString", formalDefinition="For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-answer-constraint")
        protected Enumeration<QuestionnaireAnswerConstraint> answerConstraint;

        /**
         * A reference to a value set containing a list of values representing permitted answers for a question.
         */
        @Child(name = "answerValueSet", type = {CanonicalType.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ValueSet containing permitted answers", formalDefinition="A reference to a value set containing a list of values representing permitted answers for a question." )
        protected CanonicalType answerValueSet;

        /**
         * One of the permitted answers for the question.
         */
        @Child(name = "answerOption", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Permitted answer", formalDefinition="One of the permitted answers for the question." )
        protected List<QuestionnaireItemAnswerOptionComponent> answerOption;

        /**
         * One or more values that should be pre-populated in the answer when initially rendering the questionnaire for user input.
         */
        @Child(name = "initial", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Initial value(s) when item is first rendered", formalDefinition="One or more values that should be pre-populated in the answer when initially rendering the questionnaire for user input." )
        protected List<QuestionnaireItemInitialComponent> initial;

        /**
         * Text, questions and other groups to be nested beneath a question or group.
         */
        @Child(name = "item", type = {QuestionnaireItemComponent.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Nested questionnaire items", formalDefinition="Text, questions and other groups to be nested beneath a question or group." )
        protected List<QuestionnaireItemComponent> item;

        private static final long serialVersionUID = -1760914161L;

    /**
     * Constructor
     */
      public QuestionnaireItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public QuestionnaireItemComponent(String linkId, QuestionnaireItemType type) {
        super();
        this.setLinkId(linkId);
        this.setType(type);
      }

        /**
         * @return {@link #linkId} (An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public QuestionnaireItemComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.
         */
        public QuestionnaireItemComponent setLinkId(String value) { 
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public UriType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.definition");
            else if (Configuration.doAutoCreate())
              this.definition = new UriType(); // bb
          return this.definition;
        }

        public boolean hasDefinitionElement() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public QuestionnaireItemComponent setDefinitionElement(UriType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.
         */
        public QuestionnaireItemComponent setDefinition(String value) { 
          if (Utilities.noString(value))
            this.definition = null;
          else {
            if (this.definition == null)
              this.definition = new UriType();
            this.definition.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (A terminology code that corresponds to this group or question (e.g. a code from LOINC, which defines many questions and answers).)
         */
        public List<Coding> getCode() { 
          if (this.code == null)
            this.code = new ArrayList<Coding>();
          return this.code;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireItemComponent setCode(List<Coding> theCode) { 
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

        public QuestionnaireItemComponent addCode(Coding t) { //3
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
         * @return {@link #prefix} (A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getPrefix" gives direct access to the value
         */
        public StringType getPrefixElement() { 
          if (this.prefix == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.prefix");
            else if (Configuration.doAutoCreate())
              this.prefix = new StringType(); // bb
          return this.prefix;
        }

        public boolean hasPrefixElement() { 
          return this.prefix != null && !this.prefix.isEmpty();
        }

        public boolean hasPrefix() { 
          return this.prefix != null && !this.prefix.isEmpty();
        }

        /**
         * @param value {@link #prefix} (A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getPrefix" gives direct access to the value
         */
        public QuestionnaireItemComponent setPrefixElement(StringType value) { 
          this.prefix = value;
          return this;
        }

        /**
         * @return A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.
         */
        public String getPrefix() { 
          return this.prefix == null ? null : this.prefix.getValue();
        }

        /**
         * @param value A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.
         */
        public QuestionnaireItemComponent setPrefix(String value) { 
          if (Utilities.noString(value))
            this.prefix = null;
          else {
            if (this.prefix == null)
              this.prefix = new StringType();
            this.prefix.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #text} (The name of a section, the text of a question or text content for a display item.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public StringType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.text");
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
         * @param value {@link #text} (The name of a section, the text of a question or text content for a display item.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public QuestionnaireItemComponent setTextElement(StringType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return The name of a section, the text of a question or text content for a display item.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value The name of a section, the text of a question or text content for a display item.
         */
        public QuestionnaireItemComponent setText(String value) { 
          if (Utilities.noString(value))
            this.text = null;
          else {
            if (this.text == null)
              this.text = new StringType();
            this.text.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #type} (The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<QuestionnaireItemType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<QuestionnaireItemType>(new QuestionnaireItemTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public QuestionnaireItemComponent setTypeElement(Enumeration<QuestionnaireItemType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).
         */
        public QuestionnaireItemType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).
         */
        public QuestionnaireItemComponent setType(QuestionnaireItemType value) { 
            if (this.type == null)
              this.type = new Enumeration<QuestionnaireItemType>(new QuestionnaireItemTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #enableWhen} (A constraint indicating that this item should only be enabled (displayed/allow answers to be captured) when the specified condition is true.)
         */
        public List<QuestionnaireItemEnableWhenComponent> getEnableWhen() { 
          if (this.enableWhen == null)
            this.enableWhen = new ArrayList<QuestionnaireItemEnableWhenComponent>();
          return this.enableWhen;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireItemComponent setEnableWhen(List<QuestionnaireItemEnableWhenComponent> theEnableWhen) { 
          this.enableWhen = theEnableWhen;
          return this;
        }

        public boolean hasEnableWhen() { 
          if (this.enableWhen == null)
            return false;
          for (QuestionnaireItemEnableWhenComponent item : this.enableWhen)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireItemEnableWhenComponent addEnableWhen() { //3
          QuestionnaireItemEnableWhenComponent t = new QuestionnaireItemEnableWhenComponent();
          if (this.enableWhen == null)
            this.enableWhen = new ArrayList<QuestionnaireItemEnableWhenComponent>();
          this.enableWhen.add(t);
          return t;
        }

        public QuestionnaireItemComponent addEnableWhen(QuestionnaireItemEnableWhenComponent t) { //3
          if (t == null)
            return this;
          if (this.enableWhen == null)
            this.enableWhen = new ArrayList<QuestionnaireItemEnableWhenComponent>();
          this.enableWhen.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #enableWhen}, creating it if it does not already exist {3}
         */
        public QuestionnaireItemEnableWhenComponent getEnableWhenFirstRep() { 
          if (getEnableWhen().isEmpty()) {
            addEnableWhen();
          }
          return getEnableWhen().get(0);
        }

        /**
         * @return {@link #enableBehavior} (Controls how multiple enableWhen values are interpreted -  whether all or any must be true.). This is the underlying object with id, value and extensions. The accessor "getEnableBehavior" gives direct access to the value
         */
        public Enumeration<EnableWhenBehavior> getEnableBehaviorElement() { 
          if (this.enableBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.enableBehavior");
            else if (Configuration.doAutoCreate())
              this.enableBehavior = new Enumeration<EnableWhenBehavior>(new EnableWhenBehaviorEnumFactory()); // bb
          return this.enableBehavior;
        }

        public boolean hasEnableBehaviorElement() { 
          return this.enableBehavior != null && !this.enableBehavior.isEmpty();
        }

        public boolean hasEnableBehavior() { 
          return this.enableBehavior != null && !this.enableBehavior.isEmpty();
        }

        /**
         * @param value {@link #enableBehavior} (Controls how multiple enableWhen values are interpreted -  whether all or any must be true.). This is the underlying object with id, value and extensions. The accessor "getEnableBehavior" gives direct access to the value
         */
        public QuestionnaireItemComponent setEnableBehaviorElement(Enumeration<EnableWhenBehavior> value) { 
          this.enableBehavior = value;
          return this;
        }

        /**
         * @return Controls how multiple enableWhen values are interpreted -  whether all or any must be true.
         */
        public EnableWhenBehavior getEnableBehavior() { 
          return this.enableBehavior == null ? null : this.enableBehavior.getValue();
        }

        /**
         * @param value Controls how multiple enableWhen values are interpreted -  whether all or any must be true.
         */
        public QuestionnaireItemComponent setEnableBehavior(EnableWhenBehavior value) { 
          if (value == null)
            this.enableBehavior = null;
          else {
            if (this.enableBehavior == null)
              this.enableBehavior = new Enumeration<EnableWhenBehavior>(new EnableWhenBehaviorEnumFactory());
            this.enableBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #disabledDisplay} (Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.). This is the underlying object with id, value and extensions. The accessor "getDisabledDisplay" gives direct access to the value
         */
        public Enumeration<QuestionnaireItemDisabledDisplay> getDisabledDisplayElement() { 
          if (this.disabledDisplay == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.disabledDisplay");
            else if (Configuration.doAutoCreate())
              this.disabledDisplay = new Enumeration<QuestionnaireItemDisabledDisplay>(new QuestionnaireItemDisabledDisplayEnumFactory()); // bb
          return this.disabledDisplay;
        }

        public boolean hasDisabledDisplayElement() { 
          return this.disabledDisplay != null && !this.disabledDisplay.isEmpty();
        }

        public boolean hasDisabledDisplay() { 
          return this.disabledDisplay != null && !this.disabledDisplay.isEmpty();
        }

        /**
         * @param value {@link #disabledDisplay} (Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.). This is the underlying object with id, value and extensions. The accessor "getDisabledDisplay" gives direct access to the value
         */
        public QuestionnaireItemComponent setDisabledDisplayElement(Enumeration<QuestionnaireItemDisabledDisplay> value) { 
          this.disabledDisplay = value;
          return this;
        }

        /**
         * @return Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.
         */
        public QuestionnaireItemDisabledDisplay getDisabledDisplay() { 
          return this.disabledDisplay == null ? null : this.disabledDisplay.getValue();
        }

        /**
         * @param value Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.
         */
        public QuestionnaireItemComponent setDisabledDisplay(QuestionnaireItemDisabledDisplay value) { 
          if (value == null)
            this.disabledDisplay = null;
          else {
            if (this.disabledDisplay == null)
              this.disabledDisplay = new Enumeration<QuestionnaireItemDisabledDisplay>(new QuestionnaireItemDisabledDisplayEnumFactory());
            this.disabledDisplay.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #required} (An indication, if true, that the item must be present in a "completed" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getRequired" gives direct access to the value
         */
        public BooleanType getRequiredElement() { 
          if (this.required == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.required");
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
         * @param value {@link #required} (An indication, if true, that the item must be present in a "completed" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getRequired" gives direct access to the value
         */
        public QuestionnaireItemComponent setRequiredElement(BooleanType value) { 
          this.required = value;
          return this;
        }

        /**
         * @return An indication, if true, that the item must be present in a "completed" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.
         */
        public boolean getRequired() { 
          return this.required == null || this.required.isEmpty() ? false : this.required.getValue();
        }

        /**
         * @param value An indication, if true, that the item must be present in a "completed" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.
         */
        public QuestionnaireItemComponent setRequired(boolean value) { 
            if (this.required == null)
              this.required = new BooleanType();
            this.required.setValue(value);
          return this;
        }

        /**
         * @return {@link #repeats} (An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).). This is the underlying object with id, value and extensions. The accessor "getRepeats" gives direct access to the value
         */
        public BooleanType getRepeatsElement() { 
          if (this.repeats == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.repeats");
            else if (Configuration.doAutoCreate())
              this.repeats = new BooleanType(); // bb
          return this.repeats;
        }

        public boolean hasRepeatsElement() { 
          return this.repeats != null && !this.repeats.isEmpty();
        }

        public boolean hasRepeats() { 
          return this.repeats != null && !this.repeats.isEmpty();
        }

        /**
         * @param value {@link #repeats} (An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).). This is the underlying object with id, value and extensions. The accessor "getRepeats" gives direct access to the value
         */
        public QuestionnaireItemComponent setRepeatsElement(BooleanType value) { 
          this.repeats = value;
          return this;
        }

        /**
         * @return An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).
         */
        public boolean getRepeats() { 
          return this.repeats == null || this.repeats.isEmpty() ? false : this.repeats.getValue();
        }

        /**
         * @param value An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).
         */
        public QuestionnaireItemComponent setRepeats(boolean value) { 
            if (this.repeats == null)
              this.repeats = new BooleanType();
            this.repeats.setValue(value);
          return this;
        }

        /**
         * @return {@link #readOnly} (An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.). This is the underlying object with id, value and extensions. The accessor "getReadOnly" gives direct access to the value
         */
        public BooleanType getReadOnlyElement() { 
          if (this.readOnly == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.readOnly");
            else if (Configuration.doAutoCreate())
              this.readOnly = new BooleanType(); // bb
          return this.readOnly;
        }

        public boolean hasReadOnlyElement() { 
          return this.readOnly != null && !this.readOnly.isEmpty();
        }

        public boolean hasReadOnly() { 
          return this.readOnly != null && !this.readOnly.isEmpty();
        }

        /**
         * @param value {@link #readOnly} (An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.). This is the underlying object with id, value and extensions. The accessor "getReadOnly" gives direct access to the value
         */
        public QuestionnaireItemComponent setReadOnlyElement(BooleanType value) { 
          this.readOnly = value;
          return this;
        }

        /**
         * @return An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.
         */
        public boolean getReadOnly() { 
          return this.readOnly == null || this.readOnly.isEmpty() ? false : this.readOnly.getValue();
        }

        /**
         * @param value An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.
         */
        public QuestionnaireItemComponent setReadOnly(boolean value) { 
            if (this.readOnly == null)
              this.readOnly = new BooleanType();
            this.readOnly.setValue(value);
          return this;
        }

        /**
         * @return {@link #maxLength} (The maximum number of characters that are permitted in the answer to be considered a "valid" QuestionnaireResponse.). This is the underlying object with id, value and extensions. The accessor "getMaxLength" gives direct access to the value
         */
        public IntegerType getMaxLengthElement() { 
          if (this.maxLength == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.maxLength");
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
         * @param value {@link #maxLength} (The maximum number of characters that are permitted in the answer to be considered a "valid" QuestionnaireResponse.). This is the underlying object with id, value and extensions. The accessor "getMaxLength" gives direct access to the value
         */
        public QuestionnaireItemComponent setMaxLengthElement(IntegerType value) { 
          this.maxLength = value;
          return this;
        }

        /**
         * @return The maximum number of characters that are permitted in the answer to be considered a "valid" QuestionnaireResponse.
         */
        public int getMaxLength() { 
          return this.maxLength == null || this.maxLength.isEmpty() ? 0 : this.maxLength.getValue();
        }

        /**
         * @param value The maximum number of characters that are permitted in the answer to be considered a "valid" QuestionnaireResponse.
         */
        public QuestionnaireItemComponent setMaxLength(int value) { 
            if (this.maxLength == null)
              this.maxLength = new IntegerType();
            this.maxLength.setValue(value);
          return this;
        }

        /**
         * @return {@link #answerConstraint} (For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.). This is the underlying object with id, value and extensions. The accessor "getAnswerConstraint" gives direct access to the value
         */
        public Enumeration<QuestionnaireAnswerConstraint> getAnswerConstraintElement() { 
          if (this.answerConstraint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.answerConstraint");
            else if (Configuration.doAutoCreate())
              this.answerConstraint = new Enumeration<QuestionnaireAnswerConstraint>(new QuestionnaireAnswerConstraintEnumFactory()); // bb
          return this.answerConstraint;
        }

        public boolean hasAnswerConstraintElement() { 
          return this.answerConstraint != null && !this.answerConstraint.isEmpty();
        }

        public boolean hasAnswerConstraint() { 
          return this.answerConstraint != null && !this.answerConstraint.isEmpty();
        }

        /**
         * @param value {@link #answerConstraint} (For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.). This is the underlying object with id, value and extensions. The accessor "getAnswerConstraint" gives direct access to the value
         */
        public QuestionnaireItemComponent setAnswerConstraintElement(Enumeration<QuestionnaireAnswerConstraint> value) { 
          this.answerConstraint = value;
          return this;
        }

        /**
         * @return For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.
         */
        public QuestionnaireAnswerConstraint getAnswerConstraint() { 
          return this.answerConstraint == null ? null : this.answerConstraint.getValue();
        }

        /**
         * @param value For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.
         */
        public QuestionnaireItemComponent setAnswerConstraint(QuestionnaireAnswerConstraint value) { 
          if (value == null)
            this.answerConstraint = null;
          else {
            if (this.answerConstraint == null)
              this.answerConstraint = new Enumeration<QuestionnaireAnswerConstraint>(new QuestionnaireAnswerConstraintEnumFactory());
            this.answerConstraint.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #answerValueSet} (A reference to a value set containing a list of values representing permitted answers for a question.). This is the underlying object with id, value and extensions. The accessor "getAnswerValueSet" gives direct access to the value
         */
        public CanonicalType getAnswerValueSetElement() { 
          if (this.answerValueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemComponent.answerValueSet");
            else if (Configuration.doAutoCreate())
              this.answerValueSet = new CanonicalType(); // bb
          return this.answerValueSet;
        }

        public boolean hasAnswerValueSetElement() { 
          return this.answerValueSet != null && !this.answerValueSet.isEmpty();
        }

        public boolean hasAnswerValueSet() { 
          return this.answerValueSet != null && !this.answerValueSet.isEmpty();
        }

        /**
         * @param value {@link #answerValueSet} (A reference to a value set containing a list of values representing permitted answers for a question.). This is the underlying object with id, value and extensions. The accessor "getAnswerValueSet" gives direct access to the value
         */
        public QuestionnaireItemComponent setAnswerValueSetElement(CanonicalType value) { 
          this.answerValueSet = value;
          return this;
        }

        /**
         * @return A reference to a value set containing a list of values representing permitted answers for a question.
         */
        public String getAnswerValueSet() { 
          return this.answerValueSet == null ? null : this.answerValueSet.getValue();
        }

        /**
         * @param value A reference to a value set containing a list of values representing permitted answers for a question.
         */
        public QuestionnaireItemComponent setAnswerValueSet(String value) { 
          if (Utilities.noString(value))
            this.answerValueSet = null;
          else {
            if (this.answerValueSet == null)
              this.answerValueSet = new CanonicalType();
            this.answerValueSet.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #answerOption} (One of the permitted answers for the question.)
         */
        public List<QuestionnaireItemAnswerOptionComponent> getAnswerOption() { 
          if (this.answerOption == null)
            this.answerOption = new ArrayList<QuestionnaireItemAnswerOptionComponent>();
          return this.answerOption;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireItemComponent setAnswerOption(List<QuestionnaireItemAnswerOptionComponent> theAnswerOption) { 
          this.answerOption = theAnswerOption;
          return this;
        }

        public boolean hasAnswerOption() { 
          if (this.answerOption == null)
            return false;
          for (QuestionnaireItemAnswerOptionComponent item : this.answerOption)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireItemAnswerOptionComponent addAnswerOption() { //3
          QuestionnaireItemAnswerOptionComponent t = new QuestionnaireItemAnswerOptionComponent();
          if (this.answerOption == null)
            this.answerOption = new ArrayList<QuestionnaireItemAnswerOptionComponent>();
          this.answerOption.add(t);
          return t;
        }

        public QuestionnaireItemComponent addAnswerOption(QuestionnaireItemAnswerOptionComponent t) { //3
          if (t == null)
            return this;
          if (this.answerOption == null)
            this.answerOption = new ArrayList<QuestionnaireItemAnswerOptionComponent>();
          this.answerOption.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #answerOption}, creating it if it does not already exist {3}
         */
        public QuestionnaireItemAnswerOptionComponent getAnswerOptionFirstRep() { 
          if (getAnswerOption().isEmpty()) {
            addAnswerOption();
          }
          return getAnswerOption().get(0);
        }

        /**
         * @return {@link #initial} (One or more values that should be pre-populated in the answer when initially rendering the questionnaire for user input.)
         */
        public List<QuestionnaireItemInitialComponent> getInitial() { 
          if (this.initial == null)
            this.initial = new ArrayList<QuestionnaireItemInitialComponent>();
          return this.initial;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireItemComponent setInitial(List<QuestionnaireItemInitialComponent> theInitial) { 
          this.initial = theInitial;
          return this;
        }

        public boolean hasInitial() { 
          if (this.initial == null)
            return false;
          for (QuestionnaireItemInitialComponent item : this.initial)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireItemInitialComponent addInitial() { //3
          QuestionnaireItemInitialComponent t = new QuestionnaireItemInitialComponent();
          if (this.initial == null)
            this.initial = new ArrayList<QuestionnaireItemInitialComponent>();
          this.initial.add(t);
          return t;
        }

        public QuestionnaireItemComponent addInitial(QuestionnaireItemInitialComponent t) { //3
          if (t == null)
            return this;
          if (this.initial == null)
            this.initial = new ArrayList<QuestionnaireItemInitialComponent>();
          this.initial.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #initial}, creating it if it does not already exist {3}
         */
        public QuestionnaireItemInitialComponent getInitialFirstRep() { 
          if (getInitial().isEmpty()) {
            addInitial();
          }
          return getInitial().get(0);
        }

        /**
         * @return {@link #item} (Text, questions and other groups to be nested beneath a question or group.)
         */
        public List<QuestionnaireItemComponent> getItem() { 
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireItemComponent>();
          return this.item;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireItemComponent setItem(List<QuestionnaireItemComponent> theItem) { 
          this.item = theItem;
          return this;
        }

        public boolean hasItem() { 
          if (this.item == null)
            return false;
          for (QuestionnaireItemComponent item : this.item)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireItemComponent addItem() { //3
          QuestionnaireItemComponent t = new QuestionnaireItemComponent();
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireItemComponent>();
          this.item.add(t);
          return t;
        }

        public QuestionnaireItemComponent addItem(QuestionnaireItemComponent t) { //3
          if (t == null)
            return this;
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireItemComponent>();
          this.item.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist {3}
         */
        public QuestionnaireItemComponent getItemFirstRep() { 
          if (getItem().isEmpty()) {
            addItem();
          }
          return getItem().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.", 0, 1, linkId));
          children.add(new Property("definition", "uri", "This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.", 0, 1, definition));
          children.add(new Property("code", "Coding", "A terminology code that corresponds to this group or question (e.g. a code from LOINC, which defines many questions and answers).", 0, java.lang.Integer.MAX_VALUE, code));
          children.add(new Property("prefix", "string", "A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.", 0, 1, prefix));
          children.add(new Property("text", "string", "The name of a section, the text of a question or text content for a display item.", 0, 1, text));
          children.add(new Property("type", "code", "The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).", 0, 1, type));
          children.add(new Property("enableWhen", "", "A constraint indicating that this item should only be enabled (displayed/allow answers to be captured) when the specified condition is true.", 0, java.lang.Integer.MAX_VALUE, enableWhen));
          children.add(new Property("enableBehavior", "code", "Controls how multiple enableWhen values are interpreted -  whether all or any must be true.", 0, 1, enableBehavior));
          children.add(new Property("disabledDisplay", "code", "Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.", 0, 1, disabledDisplay));
          children.add(new Property("required", "boolean", "An indication, if true, that the item must be present in a \"completed\" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.", 0, 1, required));
          children.add(new Property("repeats", "boolean", "An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).", 0, 1, repeats));
          children.add(new Property("readOnly", "boolean", "An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.", 0, 1, readOnly));
          children.add(new Property("maxLength", "integer", "The maximum number of characters that are permitted in the answer to be considered a \"valid\" QuestionnaireResponse.", 0, 1, maxLength));
          children.add(new Property("answerConstraint", "code", "For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.", 0, 1, answerConstraint));
          children.add(new Property("answerValueSet", "canonical(ValueSet)", "A reference to a value set containing a list of values representing permitted answers for a question.", 0, 1, answerValueSet));
          children.add(new Property("answerOption", "", "One of the permitted answers for the question.", 0, java.lang.Integer.MAX_VALUE, answerOption));
          children.add(new Property("initial", "", "One or more values that should be pre-populated in the answer when initially rendering the questionnaire for user input.", 0, java.lang.Integer.MAX_VALUE, initial));
          children.add(new Property("item", "@Questionnaire.item", "Text, questions and other groups to be nested beneath a question or group.", 0, java.lang.Integer.MAX_VALUE, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "An identifier that is unique within the Questionnaire allowing linkage to the equivalent item in a QuestionnaireResponse resource.", 0, 1, linkId);
          case -1014418093: /*definition*/  return new Property("definition", "uri", "This element is a URI that refers to an [ElementDefinition](elementdefinition.html) or to an [ObservationDefinition](observationdefinition.html) that provides information about this item, including information that might otherwise be included in the instance of the Questionnaire resource. A detailed description of the construction of the URI is shown in [Comments](questionnaire.html#definition), below.", 0, 1, definition);
          case 3059181: /*code*/  return new Property("code", "Coding", "A terminology code that corresponds to this group or question (e.g. a code from LOINC, which defines many questions and answers).", 0, java.lang.Integer.MAX_VALUE, code);
          case -980110702: /*prefix*/  return new Property("prefix", "string", "A short label for a particular group, question or set of display text within the questionnaire used for reference by the individual completing the questionnaire.", 0, 1, prefix);
          case 3556653: /*text*/  return new Property("text", "string", "The name of a section, the text of a question or text content for a display item.", 0, 1, text);
          case 3575610: /*type*/  return new Property("type", "code", "The type of questionnaire item this is - whether text for display, a grouping of other items or a particular type of data to be captured (string, integer, Coding, etc.).", 0, 1, type);
          case 1893321565: /*enableWhen*/  return new Property("enableWhen", "", "A constraint indicating that this item should only be enabled (displayed/allow answers to be captured) when the specified condition is true.", 0, java.lang.Integer.MAX_VALUE, enableWhen);
          case 1854802165: /*enableBehavior*/  return new Property("enableBehavior", "code", "Controls how multiple enableWhen values are interpreted -  whether all or any must be true.", 0, 1, enableBehavior);
          case -1254886746: /*disabledDisplay*/  return new Property("disabledDisplay", "code", "Indicates if and how items that are disabled (because enableWhen evaluates to 'false') should be displayed.", 0, 1, disabledDisplay);
          case -393139297: /*required*/  return new Property("required", "boolean", "An indication, if true, that the item must be present in a \"completed\" QuestionnaireResponse.  If false, the item may be skipped when answering the questionnaire.", 0, 1, required);
          case 1094288952: /*repeats*/  return new Property("repeats", "boolean", "An indication, if true, that a QuestionnaireResponse for this item may include multiple answers associated with a single instance of this item (for question-type items) or multiple repetitions of the item (for group-type items).", 0, 1, repeats);
          case -867683742: /*readOnly*/  return new Property("readOnly", "boolean", "An indication, when true, that the value cannot be changed by a human respondent to the Questionnaire.", 0, 1, readOnly);
          case -791400086: /*maxLength*/  return new Property("maxLength", "integer", "The maximum number of characters that are permitted in the answer to be considered a \"valid\" QuestionnaireResponse.", 0, 1, maxLength);
          case 746396731: /*answerConstraint*/  return new Property("answerConstraint", "code", "For items that have a defined set of allowed answers (via answerOption or answerValueSet), indicates whether values *other* than those specified can be selected.", 0, 1, answerConstraint);
          case -743278833: /*answerValueSet*/  return new Property("answerValueSet", "canonical(ValueSet)", "A reference to a value set containing a list of values representing permitted answers for a question.", 0, 1, answerValueSet);
          case -1527878189: /*answerOption*/  return new Property("answerOption", "", "One of the permitted answers for the question.", 0, java.lang.Integer.MAX_VALUE, answerOption);
          case 1948342084: /*initial*/  return new Property("initial", "", "One or more values that should be pre-populated in the answer when initially rendering the questionnaire for user input.", 0, java.lang.Integer.MAX_VALUE, initial);
          case 3242771: /*item*/  return new Property("item", "@Questionnaire.item", "Text, questions and other groups to be nested beneath a question or group.", 0, java.lang.Integer.MAX_VALUE, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // UriType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // Coding
        case -980110702: /*prefix*/ return this.prefix == null ? new Base[0] : new Base[] {this.prefix}; // StringType
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<QuestionnaireItemType>
        case 1893321565: /*enableWhen*/ return this.enableWhen == null ? new Base[0] : this.enableWhen.toArray(new Base[this.enableWhen.size()]); // QuestionnaireItemEnableWhenComponent
        case 1854802165: /*enableBehavior*/ return this.enableBehavior == null ? new Base[0] : new Base[] {this.enableBehavior}; // Enumeration<EnableWhenBehavior>
        case -1254886746: /*disabledDisplay*/ return this.disabledDisplay == null ? new Base[0] : new Base[] {this.disabledDisplay}; // Enumeration<QuestionnaireItemDisabledDisplay>
        case -393139297: /*required*/ return this.required == null ? new Base[0] : new Base[] {this.required}; // BooleanType
        case 1094288952: /*repeats*/ return this.repeats == null ? new Base[0] : new Base[] {this.repeats}; // BooleanType
        case -867683742: /*readOnly*/ return this.readOnly == null ? new Base[0] : new Base[] {this.readOnly}; // BooleanType
        case -791400086: /*maxLength*/ return this.maxLength == null ? new Base[0] : new Base[] {this.maxLength}; // IntegerType
        case 746396731: /*answerConstraint*/ return this.answerConstraint == null ? new Base[0] : new Base[] {this.answerConstraint}; // Enumeration<QuestionnaireAnswerConstraint>
        case -743278833: /*answerValueSet*/ return this.answerValueSet == null ? new Base[0] : new Base[] {this.answerValueSet}; // CanonicalType
        case -1527878189: /*answerOption*/ return this.answerOption == null ? new Base[0] : this.answerOption.toArray(new Base[this.answerOption.size()]); // QuestionnaireItemAnswerOptionComponent
        case 1948342084: /*initial*/ return this.initial == null ? new Base[0] : this.initial.toArray(new Base[this.initial.size()]); // QuestionnaireItemInitialComponent
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // QuestionnaireItemComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToUri(value); // UriType
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case -980110702: // prefix
          this.prefix = TypeConvertor.castToString(value); // StringType
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new QuestionnaireItemTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<QuestionnaireItemType>
          return value;
        case 1893321565: // enableWhen
          this.getEnableWhen().add((QuestionnaireItemEnableWhenComponent) value); // QuestionnaireItemEnableWhenComponent
          return value;
        case 1854802165: // enableBehavior
          value = new EnableWhenBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.enableBehavior = (Enumeration) value; // Enumeration<EnableWhenBehavior>
          return value;
        case -1254886746: // disabledDisplay
          value = new QuestionnaireItemDisabledDisplayEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.disabledDisplay = (Enumeration) value; // Enumeration<QuestionnaireItemDisabledDisplay>
          return value;
        case -393139297: // required
          this.required = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1094288952: // repeats
          this.repeats = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -867683742: // readOnly
          this.readOnly = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -791400086: // maxLength
          this.maxLength = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 746396731: // answerConstraint
          value = new QuestionnaireAnswerConstraintEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.answerConstraint = (Enumeration) value; // Enumeration<QuestionnaireAnswerConstraint>
          return value;
        case -743278833: // answerValueSet
          this.answerValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1527878189: // answerOption
          this.getAnswerOption().add((QuestionnaireItemAnswerOptionComponent) value); // QuestionnaireItemAnswerOptionComponent
          return value;
        case 1948342084: // initial
          this.getInitial().add((QuestionnaireItemInitialComponent) value); // QuestionnaireItemInitialComponent
          return value;
        case 3242771: // item
          this.getItem().add((QuestionnaireItemComponent) value); // QuestionnaireItemComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("prefix")) {
          this.prefix = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new QuestionnaireItemTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<QuestionnaireItemType>
        } else if (name.equals("enableWhen")) {
          this.getEnableWhen().add((QuestionnaireItemEnableWhenComponent) value);
        } else if (name.equals("enableBehavior")) {
          value = new EnableWhenBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.enableBehavior = (Enumeration) value; // Enumeration<EnableWhenBehavior>
        } else if (name.equals("disabledDisplay")) {
          value = new QuestionnaireItemDisabledDisplayEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.disabledDisplay = (Enumeration) value; // Enumeration<QuestionnaireItemDisabledDisplay>
        } else if (name.equals("required")) {
          this.required = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("repeats")) {
          this.repeats = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("readOnly")) {
          this.readOnly = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("maxLength")) {
          this.maxLength = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("answerConstraint")) {
          value = new QuestionnaireAnswerConstraintEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.answerConstraint = (Enumeration) value; // Enumeration<QuestionnaireAnswerConstraint>
        } else if (name.equals("answerValueSet")) {
          this.answerValueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("answerOption")) {
          this.getAnswerOption().add((QuestionnaireItemAnswerOptionComponent) value);
        } else if (name.equals("initial")) {
          this.getInitial().add((QuestionnaireItemInitialComponent) value);
        } else if (name.equals("item")) {
          this.getItem().add((QuestionnaireItemComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case -1014418093:  return getDefinitionElement();
        case 3059181:  return addCode(); 
        case -980110702:  return getPrefixElement();
        case 3556653:  return getTextElement();
        case 3575610:  return getTypeElement();
        case 1893321565:  return addEnableWhen(); 
        case 1854802165:  return getEnableBehaviorElement();
        case -1254886746:  return getDisabledDisplayElement();
        case -393139297:  return getRequiredElement();
        case 1094288952:  return getRepeatsElement();
        case -867683742:  return getReadOnlyElement();
        case -791400086:  return getMaxLengthElement();
        case 746396731:  return getAnswerConstraintElement();
        case -743278833:  return getAnswerValueSetElement();
        case -1527878189:  return addAnswerOption(); 
        case 1948342084:  return addInitial(); 
        case 3242771:  return addItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"uri"};
        case 3059181: /*code*/ return new String[] {"Coding"};
        case -980110702: /*prefix*/ return new String[] {"string"};
        case 3556653: /*text*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 1893321565: /*enableWhen*/ return new String[] {};
        case 1854802165: /*enableBehavior*/ return new String[] {"code"};
        case -1254886746: /*disabledDisplay*/ return new String[] {"code"};
        case -393139297: /*required*/ return new String[] {"boolean"};
        case 1094288952: /*repeats*/ return new String[] {"boolean"};
        case -867683742: /*readOnly*/ return new String[] {"boolean"};
        case -791400086: /*maxLength*/ return new String[] {"integer"};
        case 746396731: /*answerConstraint*/ return new String[] {"code"};
        case -743278833: /*answerValueSet*/ return new String[] {"canonical"};
        case -1527878189: /*answerOption*/ return new String[] {};
        case 1948342084: /*initial*/ return new String[] {};
        case 3242771: /*item*/ return new String[] {"@Questionnaire.item"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.linkId");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.definition");
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("prefix")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.prefix");
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.text");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.type");
        }
        else if (name.equals("enableWhen")) {
          return addEnableWhen();
        }
        else if (name.equals("enableBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.enableBehavior");
        }
        else if (name.equals("disabledDisplay")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.disabledDisplay");
        }
        else if (name.equals("required")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.required");
        }
        else if (name.equals("repeats")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.repeats");
        }
        else if (name.equals("readOnly")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.readOnly");
        }
        else if (name.equals("maxLength")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.maxLength");
        }
        else if (name.equals("answerConstraint")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.answerConstraint");
        }
        else if (name.equals("answerValueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.answerValueSet");
        }
        else if (name.equals("answerOption")) {
          return addAnswerOption();
        }
        else if (name.equals("initial")) {
          return addInitial();
        }
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

      public QuestionnaireItemComponent copy() {
        QuestionnaireItemComponent dst = new QuestionnaireItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireItemComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.definition = definition == null ? null : definition.copy();
        if (code != null) {
          dst.code = new ArrayList<Coding>();
          for (Coding i : code)
            dst.code.add(i.copy());
        };
        dst.prefix = prefix == null ? null : prefix.copy();
        dst.text = text == null ? null : text.copy();
        dst.type = type == null ? null : type.copy();
        if (enableWhen != null) {
          dst.enableWhen = new ArrayList<QuestionnaireItemEnableWhenComponent>();
          for (QuestionnaireItemEnableWhenComponent i : enableWhen)
            dst.enableWhen.add(i.copy());
        };
        dst.enableBehavior = enableBehavior == null ? null : enableBehavior.copy();
        dst.disabledDisplay = disabledDisplay == null ? null : disabledDisplay.copy();
        dst.required = required == null ? null : required.copy();
        dst.repeats = repeats == null ? null : repeats.copy();
        dst.readOnly = readOnly == null ? null : readOnly.copy();
        dst.maxLength = maxLength == null ? null : maxLength.copy();
        dst.answerConstraint = answerConstraint == null ? null : answerConstraint.copy();
        dst.answerValueSet = answerValueSet == null ? null : answerValueSet.copy();
        if (answerOption != null) {
          dst.answerOption = new ArrayList<QuestionnaireItemAnswerOptionComponent>();
          for (QuestionnaireItemAnswerOptionComponent i : answerOption)
            dst.answerOption.add(i.copy());
        };
        if (initial != null) {
          dst.initial = new ArrayList<QuestionnaireItemInitialComponent>();
          for (QuestionnaireItemInitialComponent i : initial)
            dst.initial.add(i.copy());
        };
        if (item != null) {
          dst.item = new ArrayList<QuestionnaireItemComponent>();
          for (QuestionnaireItemComponent i : item)
            dst.item.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemComponent))
          return false;
        QuestionnaireItemComponent o = (QuestionnaireItemComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(definition, o.definition, true) && compareDeep(code, o.code, true)
           && compareDeep(prefix, o.prefix, true) && compareDeep(text, o.text, true) && compareDeep(type, o.type, true)
           && compareDeep(enableWhen, o.enableWhen, true) && compareDeep(enableBehavior, o.enableBehavior, true)
           && compareDeep(disabledDisplay, o.disabledDisplay, true) && compareDeep(required, o.required, true)
           && compareDeep(repeats, o.repeats, true) && compareDeep(readOnly, o.readOnly, true) && compareDeep(maxLength, o.maxLength, true)
           && compareDeep(answerConstraint, o.answerConstraint, true) && compareDeep(answerValueSet, o.answerValueSet, true)
           && compareDeep(answerOption, o.answerOption, true) && compareDeep(initial, o.initial, true) && compareDeep(item, o.item, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemComponent))
          return false;
        QuestionnaireItemComponent o = (QuestionnaireItemComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(definition, o.definition, true) && compareValues(prefix, o.prefix, true)
           && compareValues(text, o.text, true) && compareValues(type, o.type, true) && compareValues(enableBehavior, o.enableBehavior, true)
           && compareValues(disabledDisplay, o.disabledDisplay, true) && compareValues(required, o.required, true)
           && compareValues(repeats, o.repeats, true) && compareValues(readOnly, o.readOnly, true) && compareValues(maxLength, o.maxLength, true)
           && compareValues(answerConstraint, o.answerConstraint, true) && compareValues(answerValueSet, o.answerValueSet, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, definition, code
          , prefix, text, type, enableWhen, enableBehavior, disabledDisplay, required, repeats
          , readOnly, maxLength, answerConstraint, answerValueSet, answerOption, initial, item
          );
      }

  public String fhirType() {
    return "Questionnaire.item";

  }

// added from java-adornments.txt:
public QuestionnaireItemComponent getQuestion(String linkId) {
        if (linkId == null)
          return null;
        for (QuestionnaireItemComponent i : getItem()) {
          if (i.getLinkId().equals(linkId))
            return i;
          QuestionnaireItemComponent t = i.getQuestion(linkId);
          if (t != null)
            return t;
        }
        return null;
      }

      public QuestionnaireItemComponent getCommonGroup(QuestionnaireItemComponent q1, QuestionnaireItemComponent q2) {
        if (q1 == null || q2 == null)
          return null;
        for (QuestionnaireItemComponent i : getItem()) {
          QuestionnaireItemComponent t = i.getCommonGroup(q1, q2);
          if (t != null)
            return t;
        }
        if (containsQuestion(q1) && containsQuestion(q2))
          return this;
        return null;
      }

      public boolean containsQuestion(QuestionnaireItemComponent q) {
        if (q == this)
          return true;
        for (QuestionnaireItemComponent i : getItem()) {
          if (i.containsQuestion(q))
            return true;
        }
        return false;
      }
// end addition
  }

    @Block()
    public static class QuestionnaireItemEnableWhenComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.
         */
        @Child(name = "question", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The linkId of question that determines whether item is enabled/disabled", formalDefinition="The linkId for the question whose answer (or lack of answer) governs whether this item is enabled." )
        protected StringType question;

        /**
         * Specifies the criteria by which the question is enabled.
         */
        @Child(name = "operator", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="exists | = | != | > | < | >= | <=", formalDefinition="Specifies the criteria by which the question is enabled." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-enable-operator")
        protected Enumeration<QuestionnaireItemOperator> operator;

        /**
         * A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.
         */
        @Child(name = "answer", type = {BooleanType.class, DecimalType.class, IntegerType.class, DateType.class, DateTimeType.class, TimeType.class, StringType.class, Coding.class, Quantity.class, Reference.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value for question comparison based on operator", formalDefinition="A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-answers")
        protected DataType answer;

        private static final long serialVersionUID = 1909865374L;

    /**
     * Constructor
     */
      public QuestionnaireItemEnableWhenComponent() {
        super();
      }

    /**
     * Constructor
     */
      public QuestionnaireItemEnableWhenComponent(String question, QuestionnaireItemOperator operator, DataType answer) {
        super();
        this.setQuestion(question);
        this.setOperator(operator);
        this.setAnswer(answer);
      }

        /**
         * @return {@link #question} (The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.). This is the underlying object with id, value and extensions. The accessor "getQuestion" gives direct access to the value
         */
        public StringType getQuestionElement() { 
          if (this.question == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemEnableWhenComponent.question");
            else if (Configuration.doAutoCreate())
              this.question = new StringType(); // bb
          return this.question;
        }

        public boolean hasQuestionElement() { 
          return this.question != null && !this.question.isEmpty();
        }

        public boolean hasQuestion() { 
          return this.question != null && !this.question.isEmpty();
        }

        /**
         * @param value {@link #question} (The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.). This is the underlying object with id, value and extensions. The accessor "getQuestion" gives direct access to the value
         */
        public QuestionnaireItemEnableWhenComponent setQuestionElement(StringType value) { 
          this.question = value;
          return this;
        }

        /**
         * @return The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.
         */
        public String getQuestion() { 
          return this.question == null ? null : this.question.getValue();
        }

        /**
         * @param value The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.
         */
        public QuestionnaireItemEnableWhenComponent setQuestion(String value) { 
            if (this.question == null)
              this.question = new StringType();
            this.question.setValue(value);
          return this;
        }

        /**
         * @return {@link #operator} (Specifies the criteria by which the question is enabled.). This is the underlying object with id, value and extensions. The accessor "getOperator" gives direct access to the value
         */
        public Enumeration<QuestionnaireItemOperator> getOperatorElement() { 
          if (this.operator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemEnableWhenComponent.operator");
            else if (Configuration.doAutoCreate())
              this.operator = new Enumeration<QuestionnaireItemOperator>(new QuestionnaireItemOperatorEnumFactory()); // bb
          return this.operator;
        }

        public boolean hasOperatorElement() { 
          return this.operator != null && !this.operator.isEmpty();
        }

        public boolean hasOperator() { 
          return this.operator != null && !this.operator.isEmpty();
        }

        /**
         * @param value {@link #operator} (Specifies the criteria by which the question is enabled.). This is the underlying object with id, value and extensions. The accessor "getOperator" gives direct access to the value
         */
        public QuestionnaireItemEnableWhenComponent setOperatorElement(Enumeration<QuestionnaireItemOperator> value) { 
          this.operator = value;
          return this;
        }

        /**
         * @return Specifies the criteria by which the question is enabled.
         */
        public QuestionnaireItemOperator getOperator() { 
          return this.operator == null ? null : this.operator.getValue();
        }

        /**
         * @param value Specifies the criteria by which the question is enabled.
         */
        public QuestionnaireItemEnableWhenComponent setOperator(QuestionnaireItemOperator value) { 
            if (this.operator == null)
              this.operator = new Enumeration<QuestionnaireItemOperator>(new QuestionnaireItemOperatorEnumFactory());
            this.operator.setValue(value);
          return this;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public DataType getAnswer() { 
          return this.answer;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public BooleanType getAnswerBooleanType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new BooleanType();
          if (!(this.answer instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (BooleanType) this.answer;
        }

        public boolean hasAnswerBooleanType() { 
          return this != null && this.answer instanceof BooleanType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public DecimalType getAnswerDecimalType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new DecimalType();
          if (!(this.answer instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (DecimalType) this.answer;
        }

        public boolean hasAnswerDecimalType() { 
          return this != null && this.answer instanceof DecimalType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public IntegerType getAnswerIntegerType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new IntegerType();
          if (!(this.answer instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (IntegerType) this.answer;
        }

        public boolean hasAnswerIntegerType() { 
          return this != null && this.answer instanceof IntegerType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public DateType getAnswerDateType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new DateType();
          if (!(this.answer instanceof DateType))
            throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (DateType) this.answer;
        }

        public boolean hasAnswerDateType() { 
          return this != null && this.answer instanceof DateType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public DateTimeType getAnswerDateTimeType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new DateTimeType();
          if (!(this.answer instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (DateTimeType) this.answer;
        }

        public boolean hasAnswerDateTimeType() { 
          return this != null && this.answer instanceof DateTimeType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public TimeType getAnswerTimeType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new TimeType();
          if (!(this.answer instanceof TimeType))
            throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (TimeType) this.answer;
        }

        public boolean hasAnswerTimeType() { 
          return this != null && this.answer instanceof TimeType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public StringType getAnswerStringType() throws FHIRException { 
          if (this.answer == null)
            this.answer = new StringType();
          if (!(this.answer instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (StringType) this.answer;
        }

        public boolean hasAnswerStringType() { 
          return this != null && this.answer instanceof StringType;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public Coding getAnswerCoding() throws FHIRException { 
          if (this.answer == null)
            this.answer = new Coding();
          if (!(this.answer instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (Coding) this.answer;
        }

        public boolean hasAnswerCoding() { 
          return this != null && this.answer instanceof Coding;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public Quantity getAnswerQuantity() throws FHIRException { 
          if (this.answer == null)
            this.answer = new Quantity();
          if (!(this.answer instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (Quantity) this.answer;
        }

        public boolean hasAnswerQuantity() { 
          return this != null && this.answer instanceof Quantity;
        }

        /**
         * @return {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public Reference getAnswerReference() throws FHIRException { 
          if (this.answer == null)
            this.answer = new Reference();
          if (!(this.answer instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.answer.getClass().getName()+" was encountered");
          return (Reference) this.answer;
        }

        public boolean hasAnswerReference() { 
          return this != null && this.answer instanceof Reference;
        }

        public boolean hasAnswer() { 
          return this.answer != null && !this.answer.isEmpty();
        }

        /**
         * @param value {@link #answer} (A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.)
         */
        public QuestionnaireItemEnableWhenComponent setAnswer(DataType value) { 
          if (value != null && !(value instanceof BooleanType || value instanceof DecimalType || value instanceof IntegerType || value instanceof DateType || value instanceof DateTimeType || value instanceof TimeType || value instanceof StringType || value instanceof Coding || value instanceof Quantity || value instanceof Reference))
            throw new Error("Not the right type for Questionnaire.item.enableWhen.answer[x]: "+value.fhirType());
          this.answer = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("question", "string", "The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.", 0, 1, question));
          children.add(new Property("operator", "code", "Specifies the criteria by which the question is enabled.", 0, 1, operator));
          children.add(new Property("answer[x]", "boolean|decimal|integer|date|dateTime|time|string|Coding|Quantity|Reference(Any)", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1165870106: /*question*/  return new Property("question", "string", "The linkId for the question whose answer (or lack of answer) governs whether this item is enabled.", 0, 1, question);
          case -500553564: /*operator*/  return new Property("operator", "code", "Specifies the criteria by which the question is enabled.", 0, 1, operator);
          case 1693524994: /*answer[x]*/  return new Property("answer[x]", "boolean|decimal|integer|date|dateTime|time|string|Coding|Quantity|Reference(Any)", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1412808770: /*answer*/  return new Property("answer[x]", "boolean|decimal|integer|date|dateTime|time|string|Coding|Quantity|Reference(Any)", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case 1194603146: /*answerBoolean*/  return new Property("answer[x]", "boolean", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1622812237: /*answerDecimal*/  return new Property("answer[x]", "decimal", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1207023712: /*answerInteger*/  return new Property("answer[x]", "integer", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case 958960780: /*answerDate*/  return new Property("answer[x]", "date", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1835321991: /*answerDateTime*/  return new Property("answer[x]", "dateTime", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case 959444907: /*answerTime*/  return new Property("answer[x]", "time", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1409727121: /*answerString*/  return new Property("answer[x]", "string", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1872828216: /*answerCoding*/  return new Property("answer[x]", "Coding", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -618108311: /*answerQuantity*/  return new Property("answer[x]", "Quantity", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          case -1726221011: /*answerReference*/  return new Property("answer[x]", "Reference(Any)", "A value that the referenced question is tested using the specified operator in order for the item to be enabled.  If there are multiple answers, a match on any of the answers suffices.  If different behavior is desired (all must match, at least 2 must match, etc.), consider using the enableWhenExpression extension.", 0, 1, answer);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1165870106: /*question*/ return this.question == null ? new Base[0] : new Base[] {this.question}; // StringType
        case -500553564: /*operator*/ return this.operator == null ? new Base[0] : new Base[] {this.operator}; // Enumeration<QuestionnaireItemOperator>
        case -1412808770: /*answer*/ return this.answer == null ? new Base[0] : new Base[] {this.answer}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1165870106: // question
          this.question = TypeConvertor.castToString(value); // StringType
          return value;
        case -500553564: // operator
          value = new QuestionnaireItemOperatorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.operator = (Enumeration) value; // Enumeration<QuestionnaireItemOperator>
          return value;
        case -1412808770: // answer
          this.answer = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("question")) {
          this.question = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("operator")) {
          value = new QuestionnaireItemOperatorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.operator = (Enumeration) value; // Enumeration<QuestionnaireItemOperator>
        } else if (name.equals("answer[x]")) {
          this.answer = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1165870106:  return getQuestionElement();
        case -500553564:  return getOperatorElement();
        case 1693524994:  return getAnswer();
        case -1412808770:  return getAnswer();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1165870106: /*question*/ return new String[] {"string"};
        case -500553564: /*operator*/ return new String[] {"code"};
        case -1412808770: /*answer*/ return new String[] {"boolean", "decimal", "integer", "date", "dateTime", "time", "string", "Coding", "Quantity", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("question")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.enableWhen.question");
        }
        else if (name.equals("operator")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.enableWhen.operator");
        }
        else if (name.equals("answerBoolean")) {
          this.answer = new BooleanType();
          return this.answer;
        }
        else if (name.equals("answerDecimal")) {
          this.answer = new DecimalType();
          return this.answer;
        }
        else if (name.equals("answerInteger")) {
          this.answer = new IntegerType();
          return this.answer;
        }
        else if (name.equals("answerDate")) {
          this.answer = new DateType();
          return this.answer;
        }
        else if (name.equals("answerDateTime")) {
          this.answer = new DateTimeType();
          return this.answer;
        }
        else if (name.equals("answerTime")) {
          this.answer = new TimeType();
          return this.answer;
        }
        else if (name.equals("answerString")) {
          this.answer = new StringType();
          return this.answer;
        }
        else if (name.equals("answerCoding")) {
          this.answer = new Coding();
          return this.answer;
        }
        else if (name.equals("answerQuantity")) {
          this.answer = new Quantity();
          return this.answer;
        }
        else if (name.equals("answerReference")) {
          this.answer = new Reference();
          return this.answer;
        }
        else
          return super.addChild(name);
      }

      public QuestionnaireItemEnableWhenComponent copy() {
        QuestionnaireItemEnableWhenComponent dst = new QuestionnaireItemEnableWhenComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireItemEnableWhenComponent dst) {
        super.copyValues(dst);
        dst.question = question == null ? null : question.copy();
        dst.operator = operator == null ? null : operator.copy();
        dst.answer = answer == null ? null : answer.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemEnableWhenComponent))
          return false;
        QuestionnaireItemEnableWhenComponent o = (QuestionnaireItemEnableWhenComponent) other_;
        return compareDeep(question, o.question, true) && compareDeep(operator, o.operator, true) && compareDeep(answer, o.answer, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemEnableWhenComponent))
          return false;
        QuestionnaireItemEnableWhenComponent o = (QuestionnaireItemEnableWhenComponent) other_;
        return compareValues(question, o.question, true) && compareValues(operator, o.operator, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(question, operator, answer
          );
      }

  public String fhirType() {
    return "Questionnaire.item.enableWhen";

  }

  }

    @Block()
    public static class QuestionnaireItemAnswerOptionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A potential answer that's allowed as the answer to this question.
         */
        @Child(name = "value", type = {IntegerType.class, DateType.class, TimeType.class, StringType.class, Coding.class, Reference.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Answer value", formalDefinition="A potential answer that's allowed as the answer to this question." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-answers")
        protected DataType value;

        /**
         * Indicates whether the answer value is selected when the list of possible answers is initially shown.
         */
        @Child(name = "initialSelected", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether option is selected by default", formalDefinition="Indicates whether the answer value is selected when the list of possible answers is initially shown." )
        protected BooleanType initialSelected;

        private static final long serialVersionUID = -504460934L;

    /**
     * Constructor
     */
      public QuestionnaireItemAnswerOptionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public QuestionnaireItemAnswerOptionComponent(DataType value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
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
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
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
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
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
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
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
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
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
         * @return {@link #value} (A potential answer that's allowed as the answer to this question.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (A potential answer that's allowed as the answer to this question.)
         */
        public QuestionnaireItemAnswerOptionComponent setValue(DataType value) { 
          if (value != null && !(value instanceof IntegerType || value instanceof DateType || value instanceof TimeType || value instanceof StringType || value instanceof Coding || value instanceof Reference))
            throw new Error("Not the right type for Questionnaire.item.answerOption.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #initialSelected} (Indicates whether the answer value is selected when the list of possible answers is initially shown.). This is the underlying object with id, value and extensions. The accessor "getInitialSelected" gives direct access to the value
         */
        public BooleanType getInitialSelectedElement() { 
          if (this.initialSelected == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireItemAnswerOptionComponent.initialSelected");
            else if (Configuration.doAutoCreate())
              this.initialSelected = new BooleanType(); // bb
          return this.initialSelected;
        }

        public boolean hasInitialSelectedElement() { 
          return this.initialSelected != null && !this.initialSelected.isEmpty();
        }

        public boolean hasInitialSelected() { 
          return this.initialSelected != null && !this.initialSelected.isEmpty();
        }

        /**
         * @param value {@link #initialSelected} (Indicates whether the answer value is selected when the list of possible answers is initially shown.). This is the underlying object with id, value and extensions. The accessor "getInitialSelected" gives direct access to the value
         */
        public QuestionnaireItemAnswerOptionComponent setInitialSelectedElement(BooleanType value) { 
          this.initialSelected = value;
          return this;
        }

        /**
         * @return Indicates whether the answer value is selected when the list of possible answers is initially shown.
         */
        public boolean getInitialSelected() { 
          return this.initialSelected == null || this.initialSelected.isEmpty() ? false : this.initialSelected.getValue();
        }

        /**
         * @param value Indicates whether the answer value is selected when the list of possible answers is initially shown.
         */
        public QuestionnaireItemAnswerOptionComponent setInitialSelected(boolean value) { 
            if (this.initialSelected == null)
              this.initialSelected = new BooleanType();
            this.initialSelected.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value[x]", "integer|date|time|string|Coding|Reference(Any)", "A potential answer that's allowed as the answer to this question.", 0, 1, value));
          children.add(new Property("initialSelected", "boolean", "Indicates whether the answer value is selected when the list of possible answers is initially shown.", 0, 1, initialSelected));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1410166417: /*value[x]*/  return new Property("value[x]", "integer|date|time|string|Coding|Reference(Any)", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "integer|date|time|string|Coding|Reference(Any)", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference(Any)", "A potential answer that's allowed as the answer to this question.", 0, 1, value);
          case -1310184961: /*initialSelected*/  return new Property("initialSelected", "boolean", "Indicates whether the answer value is selected when the list of possible answers is initially shown.", 0, 1, initialSelected);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -1310184961: /*initialSelected*/ return this.initialSelected == null ? new Base[0] : new Base[] {this.initialSelected}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -1310184961: // initialSelected
          this.initialSelected = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("initialSelected")) {
          this.initialSelected = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -1310184961:  return getInitialSelectedElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"integer", "date", "time", "string", "Coding", "Reference"};
        case -1310184961: /*initialSelected*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("valueInteger")) {
          this.value = new IntegerType();
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
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("initialSelected")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.item.answerOption.initialSelected");
        }
        else
          return super.addChild(name);
      }

      public QuestionnaireItemAnswerOptionComponent copy() {
        QuestionnaireItemAnswerOptionComponent dst = new QuestionnaireItemAnswerOptionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireItemAnswerOptionComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.initialSelected = initialSelected == null ? null : initialSelected.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemAnswerOptionComponent))
          return false;
        QuestionnaireItemAnswerOptionComponent o = (QuestionnaireItemAnswerOptionComponent) other_;
        return compareDeep(value, o.value, true) && compareDeep(initialSelected, o.initialSelected, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemAnswerOptionComponent))
          return false;
        QuestionnaireItemAnswerOptionComponent o = (QuestionnaireItemAnswerOptionComponent) other_;
        return compareValues(initialSelected, o.initialSelected, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, initialSelected);
      }

  public String fhirType() {
    return "Questionnaire.item.answerOption";

  }

  }

    @Block()
    public static class QuestionnaireItemInitialComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual value to for an initial answer.
         */
        @Child(name = "value", type = {BooleanType.class, DecimalType.class, IntegerType.class, DateType.class, DateTimeType.class, TimeType.class, StringType.class, UriType.class, Attachment.class, Coding.class, Quantity.class, Reference.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Actual value for initializing the question", formalDefinition="The actual value to for an initial answer." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-answers")
        protected DataType value;

        private static final long serialVersionUID = -1135414639L;

    /**
     * Constructor
     */
      public QuestionnaireItemInitialComponent() {
        super();
      }

    /**
     * Constructor
     */
      public QuestionnaireItemInitialComponent(DataType value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #value} (The actual value to for an initial answer.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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
         * @return {@link #value} (The actual value to for an initial answer.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The actual value to for an initial answer.)
         */
        public QuestionnaireItemInitialComponent setValue(DataType value) { 
          if (value != null && !(value instanceof BooleanType || value instanceof DecimalType || value instanceof IntegerType || value instanceof DateType || value instanceof DateTimeType || value instanceof TimeType || value instanceof StringType || value instanceof UriType || value instanceof Attachment || value instanceof Coding || value instanceof Quantity || value instanceof Reference))
            throw new Error("Not the right type for Questionnaire.item.initial.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value[x]", "boolean|decimal|integer|date|dateTime|time|string|uri|Attachment|Coding|Quantity|Reference(Any)", "The actual value to for an initial answer.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1410166417: /*value[x]*/  return new Property("value[x]", "boolean|decimal|integer|date|dateTime|time|string|uri|Attachment|Coding|Quantity|Reference(Any)", "The actual value to for an initial answer.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "boolean|decimal|integer|date|dateTime|time|string|uri|Attachment|Coding|Quantity|Reference(Any)", "The actual value to for an initial answer.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The actual value to for an initial answer.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The actual value to for an initial answer.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The actual value to for an initial answer.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "The actual value to for an initial answer.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The actual value to for an initial answer.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The actual value to for an initial answer.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The actual value to for an initial answer.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "The actual value to for an initial answer.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The actual value to for an initial answer.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "The actual value to for an initial answer.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The actual value to for an initial answer.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference(Any)", "The actual value to for an initial answer.", 0, 1, value);
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
        case 111972721: /*value*/ return new String[] {"boolean", "decimal", "integer", "date", "dateTime", "time", "string", "uri", "Attachment", "Coding", "Quantity", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueDecimal")) {
          this.value = new DecimalType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
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
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("valueCoding")) {
          this.value = new Coding();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public QuestionnaireItemInitialComponent copy() {
        QuestionnaireItemInitialComponent dst = new QuestionnaireItemInitialComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireItemInitialComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemInitialComponent))
          return false;
        QuestionnaireItemInitialComponent o = (QuestionnaireItemInitialComponent) other_;
        return compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireItemInitialComponent))
          return false;
        QuestionnaireItemInitialComponent o = (QuestionnaireItemInitialComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value);
      }

  public String fhirType() {
    return "Questionnaire.item.initial";

  }

  }

    /**
     * An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this questionnaire, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this questionnaire when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the questionnaire", formalDefinition="A formal identifier that is used to identify this questionnaire when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the questionnaire", formalDefinition="The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this questionnaire (computer friendly)", formalDefinition="A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the questionnaire.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this questionnaire (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the questionnaire." )
    protected StringType title;

    /**
     * The URL of a Questionnaire that this Questionnaire is based on.
     */
    @Child(name = "derivedFrom", type = {CanonicalType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Based on Questionnaire", formalDefinition="The URL of a Questionnaire that this Questionnaire is based on." )
    protected List<CanonicalType> derivedFrom;

    /**
     * The status of this questionnaire. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this questionnaire. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The types of subjects that can be the subject of responses created for the questionnaire.
     */
    @Child(name = "subjectType", type = {CodeType.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Resource that can be subject of QuestionnaireResponse", formalDefinition="The types of subjects that can be the subject of responses created for the questionnaire." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
    protected List<CodeType> subjectType;

    /**
     * The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last formally published", formalDefinition="The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.
     */
    @Child(name = "publisher", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the questionnaire from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the questionnaire", formalDefinition="A free text natural language description of the questionnaire from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate questionnaire instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate questionnaire instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the questionnaire is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for questionnaire (if applicable)", formalDefinition="A legal or geographic region in which the questionnaire is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this questionnaire is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this questionnaire is defined", formalDefinition="Explanation of why this questionnaire is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the questionnaire was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the questionnaire was last reviewed by the publisher", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the questionnaire content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the questionnaire is expected to be used", formalDefinition="The period during which the questionnaire content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * An identifier for this question or group of questions in a particular terminology such as LOINC.
     */
    @Child(name = "code", type = {Coding.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Concept that represents the overall questionnaire", formalDefinition="An identifier for this question or group of questions in a particular terminology such as LOINC." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-questions")
    protected List<Coding> code;

    /**
     * A particular question, question grouping or display text that is part of the questionnaire.
     */
    @Child(name = "item", type = {}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Questions and sections within the Questionnaire", formalDefinition="A particular question, question grouping or display text that is part of the questionnaire." )
    protected List<QuestionnaireItemComponent> item;

    private static final long serialVersionUID = -863684953L;

  /**
   * Constructor
   */
    public Questionnaire() {
      super();
    }

  /**
   * Constructor
   */
    public Questionnaire(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Questionnaire setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.
     */
    public Questionnaire setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this questionnaire when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setIdentifier(List<Identifier> theIdentifier) { 
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

    public Questionnaire addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Questionnaire setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public Questionnaire setVersion(String value) { 
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
    public Questionnaire setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new Error("Not the right type for Questionnaire.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.name");
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
     * @param value {@link #name} (A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Questionnaire setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public Questionnaire setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Questionnaire setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the questionnaire.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the questionnaire.
     */
    public Questionnaire setTitle(String value) { 
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
     * @return {@link #derivedFrom} (The URL of a Questionnaire that this Questionnaire is based on.)
     */
    public List<CanonicalType> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<CanonicalType>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setDerivedFrom(List<CanonicalType> theDerivedFrom) { 
      this.derivedFrom = theDerivedFrom;
      return this;
    }

    public boolean hasDerivedFrom() { 
      if (this.derivedFrom == null)
        return false;
      for (CanonicalType item : this.derivedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFrom} (The URL of a Questionnaire that this Questionnaire is based on.)
     */
    public CanonicalType addDerivedFromElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<CanonicalType>();
      this.derivedFrom.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFrom} (The URL of a Questionnaire that this Questionnaire is based on.)
     */
    public Questionnaire addDerivedFrom(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<CanonicalType>();
      this.derivedFrom.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFrom} (The URL of a Questionnaire that this Questionnaire is based on.)
     */
    public boolean hasDerivedFrom(String value) { 
      if (this.derivedFrom == null)
        return false;
      for (CanonicalType v : this.derivedFrom)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #status} (The status of this questionnaire. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.status");
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
     * @param value {@link #status} (The status of this questionnaire. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Questionnaire setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this questionnaire. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this questionnaire. Enables tracking the life-cycle of the content.
     */
    public Questionnaire setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Questionnaire setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public Questionnaire setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #subjectType} (The types of subjects that can be the subject of responses created for the questionnaire.)
     */
    public List<CodeType> getSubjectType() { 
      if (this.subjectType == null)
        this.subjectType = new ArrayList<CodeType>();
      return this.subjectType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setSubjectType(List<CodeType> theSubjectType) { 
      this.subjectType = theSubjectType;
      return this;
    }

    public boolean hasSubjectType() { 
      if (this.subjectType == null)
        return false;
      for (CodeType item : this.subjectType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #subjectType} (The types of subjects that can be the subject of responses created for the questionnaire.)
     */
    public CodeType addSubjectTypeElement() {//2 
      CodeType t = new CodeType();
      if (this.subjectType == null)
        this.subjectType = new ArrayList<CodeType>();
      this.subjectType.add(t);
      return t;
    }

    /**
     * @param value {@link #subjectType} (The types of subjects that can be the subject of responses created for the questionnaire.)
     */
    public Questionnaire addSubjectType(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.subjectType == null)
        this.subjectType = new ArrayList<CodeType>();
      this.subjectType.add(t);
      return this;
    }

    /**
     * @param value {@link #subjectType} (The types of subjects that can be the subject of responses created for the questionnaire.)
     */
    public boolean hasSubjectType(String value) { 
      if (this.subjectType == null)
        return false;
      for (CodeType v : this.subjectType)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Questionnaire setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.
     */
    public Questionnaire setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public Questionnaire setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.
     */
    public Questionnaire setPublisher(String value) { 
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
    public Questionnaire setContact(List<ContactDetail> theContact) { 
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

    public Questionnaire addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the questionnaire from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.description");
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
     * @param value {@link #description} (A free text natural language description of the questionnaire from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Questionnaire setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the questionnaire from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the questionnaire from a consumer's perspective.
     */
    public Questionnaire setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate questionnaire instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setUseContext(List<UsageContext> theUseContext) { 
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

    public Questionnaire addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the questionnaire is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public Questionnaire addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explanation of why this questionnaire is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.purpose");
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
     * @param value {@link #purpose} (Explanation of why this questionnaire is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Questionnaire setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this questionnaire is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this questionnaire is needed and why it has been designed as it has.
     */
    public Questionnaire setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Questionnaire setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.
     */
    public Questionnaire setCopyright(String value) { 
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
          throw new Error("Attempt to auto-create Questionnaire.copyrightLabel");
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
    public Questionnaire setCopyrightLabelElement(StringType value) { 
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
    public Questionnaire setCopyrightLabel(String value) { 
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
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.approvalDate");
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
    public Questionnaire setApprovalDateElement(DateType value) { 
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
    public Questionnaire setApprovalDate(Date value) { 
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
          throw new Error("Attempt to auto-create Questionnaire.lastReviewDate");
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
    public Questionnaire setLastReviewDateElement(DateType value) { 
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
    public Questionnaire setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the questionnaire content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Questionnaire.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the questionnaire content was or is planned to be in active use.)
     */
    public Questionnaire setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #code} (An identifier for this question or group of questions in a particular terminology such as LOINC.)
     */
    public List<Coding> getCode() { 
      if (this.code == null)
        this.code = new ArrayList<Coding>();
      return this.code;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setCode(List<Coding> theCode) { 
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

    public Questionnaire addCode(Coding t) { //3
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
     * @return {@link #item} (A particular question, question grouping or display text that is part of the questionnaire.)
     */
    public List<QuestionnaireItemComponent> getItem() { 
      if (this.item == null)
        this.item = new ArrayList<QuestionnaireItemComponent>();
      return this.item;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setItem(List<QuestionnaireItemComponent> theItem) { 
      this.item = theItem;
      return this;
    }

    public boolean hasItem() { 
      if (this.item == null)
        return false;
      for (QuestionnaireItemComponent item : this.item)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public QuestionnaireItemComponent addItem() { //3
      QuestionnaireItemComponent t = new QuestionnaireItemComponent();
      if (this.item == null)
        this.item = new ArrayList<QuestionnaireItemComponent>();
      this.item.add(t);
      return t;
    }

    public Questionnaire addItem(QuestionnaireItemComponent t) { //3
      if (t == null)
        return this;
      if (this.item == null)
        this.item = new ArrayList<QuestionnaireItemComponent>();
      this.item.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist {3}
     */
    public QuestionnaireItemComponent getItemFirstRep() { 
      if (getItem().isEmpty()) {
        addItem();
      }
      return getItem().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTopicMax() { 
      return 0;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the questionnaire. Topics provide a high-level categorization as well as keywords for the questionnaire that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setTopic(List<CodeableConcept> theTopic) { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"topic\""); 
    }
    public boolean hasTopic() { 
      return false;
    }

    public CodeableConcept addTopic() { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"topic\""); 
    }
    public Questionnaire addTopic(CodeableConcept t) { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"topic\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {2}
     */
    public CodeableConcept getTopicFirstRep() { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"topic\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getAuthorMax() { 
      return 0;
    }
    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the questionnaire.)
     */
    public List<ContactDetail> getAuthor() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setAuthor(List<ContactDetail> theAuthor) { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"author\""); 
    }
    public boolean hasAuthor() { 
      return false;
    }

    public ContactDetail addAuthor() { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"author\""); 
    }
    public Questionnaire addAuthor(ContactDetail t) { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"author\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {2}
     */
    public ContactDetail getAuthorFirstRep() { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"author\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEditorMax() { 
      return 0;
    }
    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the questionnaire.)
     */
    public List<ContactDetail> getEditor() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setEditor(List<ContactDetail> theEditor) { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"editor\""); 
    }
    public boolean hasEditor() { 
      return false;
    }

    public ContactDetail addEditor() { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"editor\""); 
    }
    public Questionnaire addEditor(ContactDetail t) { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"editor\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {2}
     */
    public ContactDetail getEditorFirstRep() { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"editor\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getReviewerMax() { 
      return 0;
    }
    /**
     * @return {@link #reviewer} (An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the questionnaire.)
     */
    public List<ContactDetail> getReviewer() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setReviewer(List<ContactDetail> theReviewer) { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"reviewer\""); 
    }
    public boolean hasReviewer() { 
      return false;
    }

    public ContactDetail addReviewer() { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"reviewer\""); 
    }
    public Questionnaire addReviewer(ContactDetail t) { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"reviewer\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {2}
     */
    public ContactDetail getReviewerFirstRep() { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"reviewer\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEndorserMax() { 
      return 0;
    }
    /**
     * @return {@link #endorser} (An individual or organization asserted by the publisher to be responsible for officially endorsing the questionnaire for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setEndorser(List<ContactDetail> theEndorser) { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"endorser\""); 
    }
    public boolean hasEndorser() { 
      return false;
    }

    public ContactDetail addEndorser() { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"endorser\""); 
    }
    public Questionnaire addEndorser(ContactDetail t) { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"endorser\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {2}
     */
    public ContactDetail getEndorserFirstRep() { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"endorser\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getRelatedArtifactMax() { 
      return 0;
    }
    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Questionnaire setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"relatedArtifact\""); 
    }
    public boolean hasRelatedArtifact() { 
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"relatedArtifact\""); 
    }
    public Questionnaire addRelatedArtifact(RelatedArtifact t) { //3
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"relatedArtifact\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {2}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      throw new Error("The resource type \"Questionnaire\" does not implement the property \"relatedArtifact\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this questionnaire when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the questionnaire.", 0, 1, title));
        children.add(new Property("derivedFrom", "canonical(Questionnaire)", "The URL of a Questionnaire that this Questionnaire is based on.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("status", "code", "The status of this questionnaire. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("subjectType", "code", "The types of subjects that can be the subject of responses created for the questionnaire.", 0, java.lang.Integer.MAX_VALUE, subjectType));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the questionnaire from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate questionnaire instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the questionnaire is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this questionnaire is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the questionnaire content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("code", "Coding", "An identifier for this question or group of questions in a particular terminology such as LOINC.", 0, java.lang.Integer.MAX_VALUE, code));
        children.add(new Property("item", "", "A particular question, question grouping or display text that is part of the questionnaire.", 0, java.lang.Integer.MAX_VALUE, item));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this questionnaire when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this questionnaire is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the questionnaire is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this questionnaire when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the questionnaire when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the questionnaire author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the questionnaire. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the questionnaire.", 0, 1, title);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "canonical(Questionnaire)", "The URL of a Questionnaire that this Questionnaire is based on.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this questionnaire. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this questionnaire is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case -603200890: /*subjectType*/  return new Property("subjectType", "code", "The types of subjects that can be the subject of responses created for the questionnaire.", 0, java.lang.Integer.MAX_VALUE, subjectType);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the questionnaire was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the questionnaire changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the questionnaire.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the questionnaire from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate questionnaire instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the questionnaire is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this questionnaire is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the questionnaire and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the questionnaire.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the questionnaire content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case 3059181: /*code*/  return new Property("code", "Coding", "An identifier for this question or group of questions in a particular terminology such as LOINC.", 0, java.lang.Integer.MAX_VALUE, code);
        case 3242771: /*item*/  return new Property("item", "", "A particular question, question grouping or display text that is part of the questionnaire.", 0, java.lang.Integer.MAX_VALUE, item);
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
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // CanonicalType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case -603200890: /*subjectType*/ return this.subjectType == null ? new Base[0] : this.subjectType.toArray(new Base[this.subjectType.size()]); // CodeType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // Coding
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // QuestionnaireItemComponent
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
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -603200890: // subjectType
          this.getSubjectType().add(TypeConvertor.castToCode(value)); // CodeType
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
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case 3242771: // item
          this.getItem().add((QuestionnaireItemComponent) value); // QuestionnaireItemComponent
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
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("subjectType")) {
          this.getSubjectType().add(TypeConvertor.castToCode(value));
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
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCoding(value));
        } else if (name.equals("item")) {
          this.getItem().add((QuestionnaireItemComponent) value);
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
        case 1077922663:  return addDerivedFromElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case -603200890:  return addSubjectTypeElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case 3059181:  return addCode(); 
        case 3242771:  return addItem(); 
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
        case 1077922663: /*derivedFrom*/ return new String[] {"canonical"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case -603200890: /*subjectType*/ return new String[] {"code"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case 3059181: /*code*/ return new String[] {"Coding"};
        case 3242771: /*item*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.version");
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
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.title");
        }
        else if (name.equals("derivedFrom")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.derivedFrom");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.experimental");
        }
        else if (name.equals("subjectType")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.subjectType");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.copyrightLabel");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Questionnaire.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Questionnaire";

  }

      public Questionnaire copy() {
        Questionnaire dst = new Questionnaire();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Questionnaire dst) {
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
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<CanonicalType>();
          for (CanonicalType i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        if (subjectType != null) {
          dst.subjectType = new ArrayList<CodeType>();
          for (CodeType i : subjectType)
            dst.subjectType.add(i.copy());
        };
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
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (code != null) {
          dst.code = new ArrayList<Coding>();
          for (Coding i : code)
            dst.code.add(i.copy());
        };
        if (item != null) {
          dst.item = new ArrayList<QuestionnaireItemComponent>();
          for (QuestionnaireItemComponent i : item)
            dst.item.add(i.copy());
        };
      }

      protected Questionnaire typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Questionnaire))
          return false;
        Questionnaire o = (Questionnaire) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(derivedFrom, o.derivedFrom, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(subjectType, o.subjectType, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(copyrightLabel, o.copyrightLabel, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
           && compareDeep(code, o.code, true) && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Questionnaire))
          return false;
        Questionnaire o = (Questionnaire) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(derivedFrom, o.derivedFrom, true) && compareValues(status, o.status, true)
           && compareValues(experimental, o.experimental, true) && compareValues(subjectType, o.subjectType, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, derivedFrom, status, experimental, subjectType
          , date, publisher, contact, description, useContext, jurisdiction, purpose, copyright
          , copyrightLabel, approvalDate, lastReviewDate, effectivePeriod, code, item);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Questionnaire;
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
   * Search parameter: <b>combo-code</b>
   * <p>
   * Description: <b>A code that corresponds to one of its items in the questionnaire</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.code | Questionnaire.item.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="combo-code", path="Questionnaire.code | Questionnaire.item.code", description="A code that corresponds to one of its items in the questionnaire", type="token" )
  public static final String SP_COMBO_CODE = "combo-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>combo-code</b>
   * <p>
   * Description: <b>A code that corresponds to one of its items in the questionnaire</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.code | Questionnaire.item.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam COMBO_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_COMBO_CODE);

 /**
   * Search parameter: <b>definition</b>
   * <p>
   * Description: <b>ElementDefinition - details for the item</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Questionnaire.item.definition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="definition", path="Questionnaire.item.definition", description="ElementDefinition - details for the item", type="uri" )
  public static final String SP_DEFINITION = "definition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>definition</b>
   * <p>
   * Description: <b>ElementDefinition - details for the item</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Questionnaire.item.definition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam DEFINITION = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_DEFINITION);

 /**
   * Search parameter: <b>item-code</b>
   * <p>
   * Description: <b>A code that corresponds to one of the items in the questionnaire</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.item.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="item-code", path="Questionnaire.item.code", description="A code that corresponds to one of the items in the questionnaire", type="token" )
  public static final String SP_ITEM_CODE = "item-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>item-code</b>
   * <p>
   * Description: <b>A code that corresponds to one of the items in the questionnaire</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.item.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ITEM_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ITEM_CODE);

 /**
   * Search parameter: <b>questionnaire-code</b>
   * <p>
   * Description: <b>A code that matches one of the Questionnaire.code codings</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="questionnaire-code", path="Questionnaire.code", description="A code that matches one of the Questionnaire.code codings", type="token" )
  public static final String SP_QUESTIONNAIRE_CODE = "questionnaire-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>questionnaire-code</b>
   * <p>
   * Description: <b>A code that matches one of the Questionnaire.code codings</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam QUESTIONNAIRE_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_QUESTIONNAIRE_CODE);

 /**
   * Search parameter: <b>subject-type</b>
   * <p>
   * Description: <b>Resource that can be subject of QuestionnaireResponse</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.subjectType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject-type", path="Questionnaire.subjectType", description="Resource that can be subject of QuestionnaireResponse", type="token" )
  public static final String SP_SUBJECT_TYPE = "subject-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject-type</b>
   * <p>
   * Description: <b>Resource that can be subject of QuestionnaireResponse</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Questionnaire.subjectType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SUBJECT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SUBJECT_TYPE);

// Manual code (from Configuration.txt):
public QuestionnaireItemComponent getQuestion(String linkId) {
    if (linkId == null)
      return null;
    for (QuestionnaireItemComponent i : getItem()) {
      if (i.getLinkId().equals(linkId))
        return i;
      QuestionnaireItemComponent t = i.getQuestion(linkId);
      if (t != null)
        return t;
    }
    return null;
  }

  public QuestionnaireItemComponent getCommonGroup(QuestionnaireItemComponent q1, QuestionnaireItemComponent q2) {
    for (QuestionnaireItemComponent i : getItem()) {
      QuestionnaireItemComponent t = i.getCommonGroup(q1, q2);
      if (t != null)
        return t;
    }
    return null;
  }
// end addition

}

