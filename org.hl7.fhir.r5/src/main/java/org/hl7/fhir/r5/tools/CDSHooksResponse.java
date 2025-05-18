package org.hl7.fhir.r5.tools;


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
import org.hl7.fhir.r5.tools.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * This structure is defined to allow the FHIR Validator to validate a CDSHooks Response body. TODO: This content will be moved to the CDS Hooks specification in the future
 */
@DatatypeDef(name="CDSHooksResponse")
public class CDSHooksResponse extends CDSHooksElement implements ICompositeType {

    public enum CDSActionTypeCodesVS {
        /**
         * Create this resource
         */
        CREATE, 
        /**
         * Update this resource
         */
        UPDATE, 
        /**
         * Delete this resource
         */
        DELETE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CDSActionTypeCodesVS fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return CREATE;
        if ("update".equals(codeString))
          return UPDATE;
        if ("delete".equals(codeString))
          return DELETE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CDSActionTypeCodesVS code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CREATE: return "http://hl7.org/fhir/tools/CodeSystem/CDSActionType";
            case UPDATE: return "http://hl7.org/fhir/tools/CodeSystem/CDSActionType";
            case DELETE: return "http://hl7.org/fhir/tools/CodeSystem/CDSActionType";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CREATE: return "Create this resource";
            case UPDATE: return "Update this resource";
            case DELETE: return "Delete this resource";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CREATE: return "create";
            case UPDATE: return "update";
            case DELETE: return "delete";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CDSActionTypeCodesVSEnumFactory implements EnumFactory<CDSActionTypeCodesVS> {
    public CDSActionTypeCodesVS fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("create".equals(codeString))
          return CDSActionTypeCodesVS.CREATE;
        if ("update".equals(codeString))
          return CDSActionTypeCodesVS.UPDATE;
        if ("delete".equals(codeString))
          return CDSActionTypeCodesVS.DELETE;
        throw new IllegalArgumentException("Unknown CDSActionTypeCodesVS code '"+codeString+"'");
        }
        public Enumeration<CDSActionTypeCodesVS> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CDSActionTypeCodesVS>(this, CDSActionTypeCodesVS.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<CDSActionTypeCodesVS>(this, CDSActionTypeCodesVS.NULL, code);
        if ("create".equals(codeString))
          return new Enumeration<CDSActionTypeCodesVS>(this, CDSActionTypeCodesVS.CREATE, code);
        if ("update".equals(codeString))
          return new Enumeration<CDSActionTypeCodesVS>(this, CDSActionTypeCodesVS.UPDATE, code);
        if ("delete".equals(codeString))
          return new Enumeration<CDSActionTypeCodesVS>(this, CDSActionTypeCodesVS.DELETE, code);
        throw new FHIRException("Unknown CDSActionTypeCodesVS code '"+codeString+"'");
        }
    public String toCode(CDSActionTypeCodesVS code) {
      if (code == CDSActionTypeCodesVS.CREATE)
        return "create";
      if (code == CDSActionTypeCodesVS.UPDATE)
        return "update";
      if (code == CDSActionTypeCodesVS.DELETE)
        return "delete";
      return "?";
      }
    public String toSystem(CDSActionTypeCodesVS code) {
      return code.getSystem();
      }
    }

    public enum CDSIndicatorCodesVS {
        /**
         * An information message
         */
        INFO, 
        /**
         * A warning message
         */
        WARNING, 
        /**
         * An error message
         */
        ERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CDSIndicatorCodesVS fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("info".equals(codeString))
          return INFO;
        if ("warning".equals(codeString))
          return WARNING;
        if ("error".equals(codeString))
          return ERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CDSIndicatorCodesVS code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INFO: return "info";
            case WARNING: return "warning";
            case ERROR: return "error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INFO: return "http://hl7.org/fhir/tools/CodeSystem/CDSIndicator";
            case WARNING: return "http://hl7.org/fhir/tools/CodeSystem/CDSIndicator";
            case ERROR: return "http://hl7.org/fhir/tools/CodeSystem/CDSIndicator";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INFO: return "An information message";
            case WARNING: return "A warning message";
            case ERROR: return "An error message";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INFO: return "info";
            case WARNING: return "warning";
            case ERROR: return "error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CDSIndicatorCodesVSEnumFactory implements EnumFactory<CDSIndicatorCodesVS> {
    public CDSIndicatorCodesVS fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("info".equals(codeString))
          return CDSIndicatorCodesVS.INFO;
        if ("warning".equals(codeString))
          return CDSIndicatorCodesVS.WARNING;
        if ("error".equals(codeString))
          return CDSIndicatorCodesVS.ERROR;
        throw new IllegalArgumentException("Unknown CDSIndicatorCodesVS code '"+codeString+"'");
        }
        public Enumeration<CDSIndicatorCodesVS> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CDSIndicatorCodesVS>(this, CDSIndicatorCodesVS.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<CDSIndicatorCodesVS>(this, CDSIndicatorCodesVS.NULL, code);
        if ("info".equals(codeString))
          return new Enumeration<CDSIndicatorCodesVS>(this, CDSIndicatorCodesVS.INFO, code);
        if ("warning".equals(codeString))
          return new Enumeration<CDSIndicatorCodesVS>(this, CDSIndicatorCodesVS.WARNING, code);
        if ("error".equals(codeString))
          return new Enumeration<CDSIndicatorCodesVS>(this, CDSIndicatorCodesVS.ERROR, code);
        throw new FHIRException("Unknown CDSIndicatorCodesVS code '"+codeString+"'");
        }
    public String toCode(CDSIndicatorCodesVS code) {
      if (code == CDSIndicatorCodesVS.INFO)
        return "info";
      if (code == CDSIndicatorCodesVS.WARNING)
        return "warning";
      if (code == CDSIndicatorCodesVS.ERROR)
        return "error";
      return "?";
      }
    public String toSystem(CDSIndicatorCodesVS code) {
      return code.getSystem();
      }
    }

    public enum CDSLinkTypeCodesVS {
        /**
         * Indicates that the URL is absolute and should be treated as-is.
         */
        ABSOLUTE, 
        /**
         * indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters
         */
        SMART, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CDSLinkTypeCodesVS fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("absolute".equals(codeString))
          return ABSOLUTE;
        if ("smart".equals(codeString))
          return SMART;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CDSLinkTypeCodesVS code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ABSOLUTE: return "absolute";
            case SMART: return "smart";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ABSOLUTE: return "http://hl7.org/fhir/tools/CodeSystem/CDSLinkType";
            case SMART: return "http://hl7.org/fhir/tools/CodeSystem/CDSLinkType";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ABSOLUTE: return "Indicates that the URL is absolute and should be treated as-is.";
            case SMART: return "indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ABSOLUTE: return "absolute";
            case SMART: return "smart";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CDSLinkTypeCodesVSEnumFactory implements EnumFactory<CDSLinkTypeCodesVS> {
    public CDSLinkTypeCodesVS fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("absolute".equals(codeString))
          return CDSLinkTypeCodesVS.ABSOLUTE;
        if ("smart".equals(codeString))
          return CDSLinkTypeCodesVS.SMART;
        throw new IllegalArgumentException("Unknown CDSLinkTypeCodesVS code '"+codeString+"'");
        }
        public Enumeration<CDSLinkTypeCodesVS> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CDSLinkTypeCodesVS>(this, CDSLinkTypeCodesVS.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<CDSLinkTypeCodesVS>(this, CDSLinkTypeCodesVS.NULL, code);
        if ("absolute".equals(codeString))
          return new Enumeration<CDSLinkTypeCodesVS>(this, CDSLinkTypeCodesVS.ABSOLUTE, code);
        if ("smart".equals(codeString))
          return new Enumeration<CDSLinkTypeCodesVS>(this, CDSLinkTypeCodesVS.SMART, code);
        throw new FHIRException("Unknown CDSLinkTypeCodesVS code '"+codeString+"'");
        }
    public String toCode(CDSLinkTypeCodesVS code) {
      if (code == CDSLinkTypeCodesVS.ABSOLUTE)
        return "absolute";
      if (code == CDSLinkTypeCodesVS.SMART)
        return "smart";
      return "?";
      }
    public String toSystem(CDSLinkTypeCodesVS code) {
      return code.getSystem();
      }
    }

    public enum CDSSelectionBehaviorCodesVS {
        /**
         * indicates that the user may choose none or at most one of the suggestions
         */
        ATMOSTONE, 
        /**
         * indicates that the end user may choose any number of suggestions including none of them and all of them
         */
        ANY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CDSSelectionBehaviorCodesVS fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("at-most-one".equals(codeString))
          return ATMOSTONE;
        if ("any".equals(codeString))
          return ANY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CDSSelectionBehaviorCodesVS code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ATMOSTONE: return "at-most-one";
            case ANY: return "any";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ATMOSTONE: return "http://hl7.org/fhir/tools/CodeSystem/CDSSelectionBehavior";
            case ANY: return "http://hl7.org/fhir/tools/CodeSystem/CDSSelectionBehavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ATMOSTONE: return "indicates that the user may choose none or at most one of the suggestions";
            case ANY: return "indicates that the end user may choose any number of suggestions including none of them and all of them";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ATMOSTONE: return "at-most-one";
            case ANY: return "any";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CDSSelectionBehaviorCodesVSEnumFactory implements EnumFactory<CDSSelectionBehaviorCodesVS> {
    public CDSSelectionBehaviorCodesVS fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("at-most-one".equals(codeString))
          return CDSSelectionBehaviorCodesVS.ATMOSTONE;
        if ("any".equals(codeString))
          return CDSSelectionBehaviorCodesVS.ANY;
        throw new IllegalArgumentException("Unknown CDSSelectionBehaviorCodesVS code '"+codeString+"'");
        }
        public Enumeration<CDSSelectionBehaviorCodesVS> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CDSSelectionBehaviorCodesVS>(this, CDSSelectionBehaviorCodesVS.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<CDSSelectionBehaviorCodesVS>(this, CDSSelectionBehaviorCodesVS.NULL, code);
        if ("at-most-one".equals(codeString))
          return new Enumeration<CDSSelectionBehaviorCodesVS>(this, CDSSelectionBehaviorCodesVS.ATMOSTONE, code);
        if ("any".equals(codeString))
          return new Enumeration<CDSSelectionBehaviorCodesVS>(this, CDSSelectionBehaviorCodesVS.ANY, code);
        throw new FHIRException("Unknown CDSSelectionBehaviorCodesVS code '"+codeString+"'");
        }
    public String toCode(CDSSelectionBehaviorCodesVS code) {
      if (code == CDSSelectionBehaviorCodesVS.ATMOSTONE)
        return "at-most-one";
      if (code == CDSSelectionBehaviorCodesVS.ANY)
        return "any";
      return "?";
      }
    public String toSystem(CDSSelectionBehaviorCodesVS code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CDSHooksResponseCardsComponent extends CDSHooksElement {
        /**
         * Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.
         */
        @Child(name = "uuid", type = {UuidType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Unique identifier of the card (for logging/feedback)", formalDefinition="Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint." )
        protected UuidType uuid;

        /**
         * One-sentence, <140-character summary message for display to the user inside of this card.
         */
        @Child(name = "summary", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Summary message for display to the user (<140 char)", formalDefinition="One-sentence, <140-character summary message for display to the user inside of this card." )
        protected StringType summary;

        /**
         * Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').
         */
        @Child(name = "detail", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Optional detailed information to display (GitHub Flavored Markdown)", formalDefinition="Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...')." )
        protected MarkdownType detail;

        /**
         * Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.
         */
        @Child(name = "indicator", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="info, warning, critical - Urgency/importance of what this card conveys", formalDefinition="Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/tools/ValueSet/CDSIndicator")
        protected Enumeration<CDSIndicatorCodesVS> indicator;

        /**
         * The source should be the primary source of guidance for the decision support the card represents.
         */
        @Child(name = "source", type = {CDSHooksElement.class}, order=5, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The primary source of guidance for the content the card represents.", formalDefinition="The source should be the primary source of guidance for the decision support the card represents." )
        protected CDSHooksResponseCardsSourceComponent source;

        /**
         * Allows a service to suggest a set of changes in the context of the current activity (e.g. changing the dose of a medication currently being prescribed, for the order-sign activity).
         */
        @Child(name = "suggestions", type = {CDSHooksElement.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Suggest a set of changes in the context of the current activity", formalDefinition="Allows a service to suggest a set of changes in the context of the current activity (e.g. changing the dose of a medication currently being prescribed, for the order-sign activity)." )
        protected List<CDSHooksResponseCardsSuggestionsComponent> suggestionsList;

        /**
         * Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them
         */
        @Child(name = "selectionBehavior", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="at-most-one, any - intended selection behavior of the suggestions in the card", formalDefinition="Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them" )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/tools/ValueSet/CDSSelectionBehavior")
        protected Enumeration<CDSSelectionBehaviorCodesVS> selectionBehavior;

        /**
         * Override reasons can be selected by the end user when overriding a card without taking the suggested recommendations. The CDS service MAY return a list of override reasons to the CDS client.
         */
        @Child(name = "overrideReasons", type = {Coding.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Can be selected by the end user when overriding a card without taking the suggested recommendations.", formalDefinition="Override reasons can be selected by the end user when overriding a card without taking the suggested recommendations. The CDS service MAY return a list of override reasons to the CDS client." )
        protected List<Coding> overrideReasonsList;

        /**
         * Allows a service to suggest a link to an app that the user might want to run for additional information or to help guide a decision.
         */
        @Child(name = "links", type = {CDSHooksElement.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Link to an app that the user might want to run for additional information or to help guide a decision", formalDefinition="Allows a service to suggest a link to an app that the user might want to run for additional information or to help guide a decision." )
        protected List<CDSHooksResponseCardsLinksComponent> linksList;

        private static final long serialVersionUID = -1553644263L;

    /**
     * Constructor
     */
      public CDSHooksResponseCardsComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksResponseCardsComponent(String summary, CDSHooksResponseCardsSourceComponent source) {
        super();
        this.setSummary(summary);
        this.setSource(source);
      }

        /**
         * @return {@link #uuid} (Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.). This is the underlying object with id, value and extensions. The accessor "getUuid" gives direct access to the value
         */
        public UuidType getUuidElement() { 
          if (this.uuid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsComponent.uuid");
            else if (Configuration.doAutoCreate())
              this.uuid = new UuidType(); // bb
          return this.uuid;
        }

        public boolean hasUuidElement() { 
          return this.uuid != null && !this.uuid.isEmpty();
        }

        public boolean hasUuid() { 
          return this.uuid != null && !this.uuid.isEmpty();
        }

        /**
         * @param value {@link #uuid} (Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.). This is the underlying object with id, value and extensions. The accessor "getUuid" gives direct access to the value
         */
        public CDSHooksResponseCardsComponent setUuidElement(UuidType value) { 
          this.uuid = value;
          return this;
        }

        /**
         * @return Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.
         */
        public String getUuid() { 
          return this.uuid == null ? null : this.uuid.getValue();
        }

        /**
         * @param value Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.
         */
        public CDSHooksResponseCardsComponent setUuid(String value) { 
          if (Utilities.noString(value))
            this.uuid = null;
          else {
            if (this.uuid == null)
              this.uuid = new UuidType();
            this.uuid.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #summary} (One-sentence, <140-character summary message for display to the user inside of this card.). This is the underlying object with id, value and extensions. The accessor "getSummary" gives direct access to the value
         */
        public StringType getSummaryElement() { 
          if (this.summary == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsComponent.summary");
            else if (Configuration.doAutoCreate())
              this.summary = new StringType(); // bb
          return this.summary;
        }

        public boolean hasSummaryElement() { 
          return this.summary != null && !this.summary.isEmpty();
        }

        public boolean hasSummary() { 
          return this.summary != null && !this.summary.isEmpty();
        }

        /**
         * @param value {@link #summary} (One-sentence, <140-character summary message for display to the user inside of this card.). This is the underlying object with id, value and extensions. The accessor "getSummary" gives direct access to the value
         */
        public CDSHooksResponseCardsComponent setSummaryElement(StringType value) { 
          this.summary = value;
          return this;
        }

        /**
         * @return One-sentence, <140-character summary message for display to the user inside of this card.
         */
        public String getSummary() { 
          return this.summary == null ? null : this.summary.getValue();
        }

        /**
         * @param value One-sentence, <140-character summary message for display to the user inside of this card.
         */
        public CDSHooksResponseCardsComponent setSummary(String value) { 
            if (this.summary == null)
              this.summary = new StringType();
            this.summary.setValue(value);
          return this;
        }

        /**
         * @return {@link #detail} (Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').). This is the underlying object with id, value and extensions. The accessor "getDetail" gives direct access to the value
         */
        public MarkdownType getDetailElement() { 
          if (this.detail == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsComponent.detail");
            else if (Configuration.doAutoCreate())
              this.detail = new MarkdownType(); // bb
          return this.detail;
        }

        public boolean hasDetailElement() { 
          return this.detail != null && !this.detail.isEmpty();
        }

        public boolean hasDetail() { 
          return this.detail != null && !this.detail.isEmpty();
        }

        /**
         * @param value {@link #detail} (Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').). This is the underlying object with id, value and extensions. The accessor "getDetail" gives direct access to the value
         */
        public CDSHooksResponseCardsComponent setDetailElement(MarkdownType value) { 
          this.detail = value;
          return this;
        }

        /**
         * @return Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').
         */
        public String getDetail() { 
          return this.detail == null ? null : this.detail.getValue();
        }

        /**
         * @param value Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').
         */
        public CDSHooksResponseCardsComponent setDetail(String value) { 
          if (Utilities.noString(value))
            this.detail = null;
          else {
            if (this.detail == null)
              this.detail = new MarkdownType();
            this.detail.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #indicator} (Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.). This is the underlying object with id, value and extensions. The accessor "getIndicator" gives direct access to the value
         */
        public Enumeration<CDSIndicatorCodesVS> getIndicatorElement() { 
          if (this.indicator == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsComponent.indicator");
            else if (Configuration.doAutoCreate())
              this.indicator = new Enumeration<CDSIndicatorCodesVS>(new CDSIndicatorCodesVSEnumFactory()); // bb
          return this.indicator;
        }

        public boolean hasIndicatorElement() { 
          return this.indicator != null && !this.indicator.isEmpty();
        }

        public boolean hasIndicator() { 
          return this.indicator != null && !this.indicator.isEmpty();
        }

        /**
         * @param value {@link #indicator} (Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.). This is the underlying object with id, value and extensions. The accessor "getIndicator" gives direct access to the value
         */
        public CDSHooksResponseCardsComponent setIndicatorElement(Enumeration<CDSIndicatorCodesVS> value) { 
          this.indicator = value;
          return this;
        }

        /**
         * @return Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.
         */
        public CDSIndicatorCodesVS getIndicator() { 
          return this.indicator == null ? null : this.indicator.getValue();
        }

        /**
         * @param value Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.
         */
        public CDSHooksResponseCardsComponent setIndicator(CDSIndicatorCodesVS value) { 
          if (value == null)
            this.indicator = null;
          else {
            if (this.indicator == null)
              this.indicator = new Enumeration<CDSIndicatorCodesVS>(new CDSIndicatorCodesVSEnumFactory());
            this.indicator.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #source} (The source should be the primary source of guidance for the decision support the card represents.)
         */
        public CDSHooksResponseCardsSourceComponent getSource() { 
          return this.source;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (The source should be the primary source of guidance for the decision support the card represents.)
         */
        public CDSHooksResponseCardsComponent setSource(CDSHooksResponseCardsSourceComponent value) { 
          this.source = value;
          return this;
        }

        /**
         * @return {@link #suggestions} (Allows a service to suggest a set of changes in the context of the current activity (e.g. changing the dose of a medication currently being prescribed, for the order-sign activity).)
         */
        public List<CDSHooksResponseCardsSuggestionsComponent> getSuggestionsList() { 
          if (this.suggestionsList == null)
            this.suggestionsList = new ArrayList<CDSHooksResponseCardsSuggestionsComponent>();
          return this.suggestionsList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CDSHooksResponseCardsComponent setSuggestionsList(List<CDSHooksResponseCardsSuggestionsComponent> theSuggestions) { 
          this.suggestionsList = theSuggestions;
          return this;
        }

        public boolean hasSuggestions() { 
          if (this.suggestionsList == null)
            return false;
          for (CDSHooksResponseCardsSuggestionsComponent item : this.suggestionsList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CDSHooksResponseCardsSuggestionsComponent addSuggestions() { //3a
          CDSHooksResponseCardsSuggestionsComponent t = new CDSHooksResponseCardsSuggestionsComponent();
          if (this.suggestionsList == null)
            this.suggestionsList = new ArrayList<CDSHooksResponseCardsSuggestionsComponent>();
          this.suggestionsList.add(t);
          return t;
        }

        public CDSHooksResponseCardsComponent addSuggestions(CDSHooksResponseCardsSuggestionsComponent t) { //3b
          if (t == null)
            return this;
          if (this.suggestionsList == null)
            this.suggestionsList = new ArrayList<CDSHooksResponseCardsSuggestionsComponent>();
          this.suggestionsList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #suggestions}, creating it if it does not already exist {3}
         */
        public CDSHooksResponseCardsSuggestionsComponent getSuggestionsFirstRep() { 
          if (getSuggestionsList().isEmpty()) {
            addSuggestions();
          }
          return getSuggestionsList().get(0);
        }

        /**
         * @return {@link #selectionBehavior} (Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them). This is the underlying object with id, value and extensions. The accessor "getSelectionBehavior" gives direct access to the value
         */
        public Enumeration<CDSSelectionBehaviorCodesVS> getSelectionBehaviorElement() { 
          if (this.selectionBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsComponent.selectionBehavior");
            else if (Configuration.doAutoCreate())
              this.selectionBehavior = new Enumeration<CDSSelectionBehaviorCodesVS>(new CDSSelectionBehaviorCodesVSEnumFactory()); // bb
          return this.selectionBehavior;
        }

        public boolean hasSelectionBehaviorElement() { 
          return this.selectionBehavior != null && !this.selectionBehavior.isEmpty();
        }

        public boolean hasSelectionBehavior() { 
          return this.selectionBehavior != null && !this.selectionBehavior.isEmpty();
        }

        /**
         * @param value {@link #selectionBehavior} (Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them). This is the underlying object with id, value and extensions. The accessor "getSelectionBehavior" gives direct access to the value
         */
        public CDSHooksResponseCardsComponent setSelectionBehaviorElement(Enumeration<CDSSelectionBehaviorCodesVS> value) { 
          this.selectionBehavior = value;
          return this;
        }

        /**
         * @return Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them
         */
        public CDSSelectionBehaviorCodesVS getSelectionBehavior() { 
          return this.selectionBehavior == null ? null : this.selectionBehavior.getValue();
        }

        /**
         * @param value Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them
         */
        public CDSHooksResponseCardsComponent setSelectionBehavior(CDSSelectionBehaviorCodesVS value) { 
          if (value == null)
            this.selectionBehavior = null;
          else {
            if (this.selectionBehavior == null)
              this.selectionBehavior = new Enumeration<CDSSelectionBehaviorCodesVS>(new CDSSelectionBehaviorCodesVSEnumFactory());
            this.selectionBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #overrideReasons} (Override reasons can be selected by the end user when overriding a card without taking the suggested recommendations. The CDS service MAY return a list of override reasons to the CDS client.)
         */
        public List<Coding> getOverrideReasonsList() { 
          if (this.overrideReasonsList == null)
            this.overrideReasonsList = new ArrayList<Coding>();
          return this.overrideReasonsList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CDSHooksResponseCardsComponent setOverrideReasonsList(List<Coding> theOverrideReasons) { 
          this.overrideReasonsList = theOverrideReasons;
          return this;
        }

        public boolean hasOverrideReasons() { 
          if (this.overrideReasonsList == null)
            return false;
          for (Coding item : this.overrideReasonsList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Coding addOverrideReasons() { //3a
          Coding t = new Coding();
          if (this.overrideReasonsList == null)
            this.overrideReasonsList = new ArrayList<Coding>();
          this.overrideReasonsList.add(t);
          return t;
        }

        public CDSHooksResponseCardsComponent addOverrideReasons(Coding t) { //3b
          if (t == null)
            return this;
          if (this.overrideReasonsList == null)
            this.overrideReasonsList = new ArrayList<Coding>();
          this.overrideReasonsList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #overrideReasons}, creating it if it does not already exist {3}
         */
        public Coding getOverrideReasonsFirstRep() { 
          if (getOverrideReasonsList().isEmpty()) {
            addOverrideReasons();
          }
          return getOverrideReasonsList().get(0);
        }

        /**
         * @return {@link #links} (Allows a service to suggest a link to an app that the user might want to run for additional information or to help guide a decision.)
         */
        public List<CDSHooksResponseCardsLinksComponent> getLinksList() { 
          if (this.linksList == null)
            this.linksList = new ArrayList<CDSHooksResponseCardsLinksComponent>();
          return this.linksList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CDSHooksResponseCardsComponent setLinksList(List<CDSHooksResponseCardsLinksComponent> theLinks) { 
          this.linksList = theLinks;
          return this;
        }

        public boolean hasLinks() { 
          if (this.linksList == null)
            return false;
          for (CDSHooksResponseCardsLinksComponent item : this.linksList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CDSHooksResponseCardsLinksComponent addLinks() { //3a
          CDSHooksResponseCardsLinksComponent t = new CDSHooksResponseCardsLinksComponent();
          if (this.linksList == null)
            this.linksList = new ArrayList<CDSHooksResponseCardsLinksComponent>();
          this.linksList.add(t);
          return t;
        }

        public CDSHooksResponseCardsComponent addLinks(CDSHooksResponseCardsLinksComponent t) { //3b
          if (t == null)
            return this;
          if (this.linksList == null)
            this.linksList = new ArrayList<CDSHooksResponseCardsLinksComponent>();
          this.linksList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #links}, creating it if it does not already exist {3}
         */
        public CDSHooksResponseCardsLinksComponent getLinksFirstRep() { 
          if (getLinksList().isEmpty()) {
            addLinks();
          }
          return getLinksList().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("uuid", "uuid", "Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.", 0, 1, uuid));
          children.add(new Property("summary", "string", "One-sentence, <140-character summary message for display to the user inside of this card.", 0, 1, summary));
          children.add(new Property("detail", "markdown", "Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').", 0, 1, detail));
          children.add(new Property("indicator", "code", "Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.", 0, 1, indicator));
          children.add(new Property("source", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "The source should be the primary source of guidance for the decision support the card represents.", 0, 1, source));
          children.add(new Property("suggestions", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "Allows a service to suggest a set of changes in the context of the current activity (e.g. changing the dose of a medication currently being prescribed, for the order-sign activity).", 0, java.lang.Integer.MAX_VALUE, suggestionsList));
          children.add(new Property("selectionBehavior", "code", "Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them", 0, 1, selectionBehavior));
          children.add(new Property("overrideReasons", "Coding", "Override reasons can be selected by the end user when overriding a card without taking the suggested recommendations. The CDS service MAY return a list of override reasons to the CDS client.", 0, java.lang.Integer.MAX_VALUE, overrideReasonsList));
          children.add(new Property("links", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "Allows a service to suggest a link to an app that the user might want to run for additional information or to help guide a decision.", 0, java.lang.Integer.MAX_VALUE, linksList));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3601339: /*uuid*/  return new Property("uuid", "uuid", "Unique identifier of the card. MAY be used for auditing and logging cards and SHALL be included in any subsequent calls to the CDS service's feedback endpoint.", 0, 1, uuid);
          case -1857640538: /*summary*/  return new Property("summary", "string", "One-sentence, <140-character summary message for display to the user inside of this card.", 0, 1, summary);
          case -1335224239: /*detail*/  return new Property("detail", "markdown", "Optional detailed information to display; if provided MUST be represented in (GitHub Flavored) Markdown. (For non-urgent cards, the CDS Client MAY hide these details until the user clicks a link like 'view more details...').", 0, 1, detail);
          case -711999985: /*indicator*/  return new Property("indicator", "code", "Urgency/importance of what this card conveys. Allowed values, in order of increasing urgency, are: info, warning, critical.", 0, 1, indicator);
          case -896505829: /*source*/  return new Property("source", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "The source should be the primary source of guidance for the decision support the card represents.", 0, 1, source);
          case -1525319953: /*suggestions*/  return new Property("suggestions", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "Allows a service to suggest a set of changes in the context of the current activity (e.g. changing the dose of a medication currently being prescribed, for the order-sign activity).", 0, java.lang.Integer.MAX_VALUE, suggestionsList);
          case 168639486: /*selectionBehavior*/  return new Property("selectionBehavior", "code", "Describes the intended selection behavior of the suggestions in the card. Allowed values are: at-most-one, indicating that the user may choose none or at most one of the suggestions; any, indicating that the end user may choose any number of suggestions including none of them and all of them", 0, 1, selectionBehavior);
          case -1554410173: /*overrideReasons*/  return new Property("overrideReasons", "Coding", "Override reasons can be selected by the end user when overriding a card without taking the suggested recommendations. The CDS service MAY return a list of override reasons to the CDS client.", 0, java.lang.Integer.MAX_VALUE, overrideReasonsList);
          case 102977465: /*links*/  return new Property("links", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "Allows a service to suggest a link to an app that the user might want to run for additional information or to help guide a decision.", 0, java.lang.Integer.MAX_VALUE, linksList);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3601339: /*uuid*/ return this.uuid == null ? new Base[0] : new Base[] {this.uuid}; // UuidType
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : new Base[] {this.summary}; // StringType
        case -1335224239: /*detail*/ return this.detail == null ? new Base[0] : new Base[] {this.detail}; // MarkdownType
        case -711999985: /*indicator*/ return this.indicator == null ? new Base[0] : new Base[] {this.indicator}; // Enumeration<CDSIndicatorCodesVS>
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // CDSHooksResponseCardsSourceComponent
        case -1525319953: /*suggestions*/ return this.suggestionsList == null ? new Base[0] : this.suggestionsList.toArray(new Base[this.suggestionsList.size()]); // CDSHooksResponseCardsSuggestionsComponent
        case 168639486: /*selectionBehavior*/ return this.selectionBehavior == null ? new Base[0] : new Base[] {this.selectionBehavior}; // Enumeration<CDSSelectionBehaviorCodesVS>
        case -1554410173: /*overrideReasons*/ return this.overrideReasonsList == null ? new Base[0] : this.overrideReasonsList.toArray(new Base[this.overrideReasonsList.size()]); // Coding
        case 102977465: /*links*/ return this.linksList == null ? new Base[0] : this.linksList.toArray(new Base[this.linksList.size()]); // CDSHooksResponseCardsLinksComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3601339: // uuid
          this.uuid = TypeConvertor.castToUuid(value); // UuidType
          return value;
        case -1857640538: // summary
          this.summary = TypeConvertor.castToString(value); // StringType
          return value;
        case -1335224239: // detail
          this.detail = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -711999985: // indicator
          value = new CDSIndicatorCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.indicator = (Enumeration) value; // Enumeration<CDSIndicatorCodesVS>
          return value;
        case -896505829: // source
          this.source = (CDSHooksResponseCardsSourceComponent) value; // CDSHooksResponseCardsSourceComponent
          return value;
        case -1525319953: // suggestions
          this.getSuggestionsList().add((CDSHooksResponseCardsSuggestionsComponent) value); // CDSHooksResponseCardsSuggestionsComponent
          return value;
        case 168639486: // selectionBehavior
          value = new CDSSelectionBehaviorCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.selectionBehavior = (Enumeration) value; // Enumeration<CDSSelectionBehaviorCodesVS>
          return value;
        case -1554410173: // overrideReasons
          this.getOverrideReasonsList().add(TypeConvertor.castToCoding(value)); // Coding
          return value;
        case 102977465: // links
          this.getLinksList().add((CDSHooksResponseCardsLinksComponent) value); // CDSHooksResponseCardsLinksComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("uuid")) {
          this.uuid = TypeConvertor.castToUuid(value); // UuidType
        } else if (name.equals("summary")) {
          this.summary = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("detail")) {
          this.detail = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("indicator")) {
          value = new CDSIndicatorCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.indicator = (Enumeration) value; // Enumeration<CDSIndicatorCodesVS>
        } else if (name.equals("source")) {
          this.source = (CDSHooksResponseCardsSourceComponent) value; // CDSHooksResponseCardsSourceComponent
        } else if (name.equals("suggestions")) {
          this.getSuggestionsList().add((CDSHooksResponseCardsSuggestionsComponent) value); // CDSHooksResponseCardsSuggestionsComponent
        } else if (name.equals("selectionBehavior")) {
          value = new CDSSelectionBehaviorCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.selectionBehavior = (Enumeration) value; // Enumeration<CDSSelectionBehaviorCodesVS>
        } else if (name.equals("overrideReasons")) {
          this.getOverrideReasonsList().add(TypeConvertor.castToCoding(value)); // Coding
        } else if (name.equals("links")) {
          this.getLinksList().add((CDSHooksResponseCardsLinksComponent) value); // CDSHooksResponseCardsLinksComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3601339:  return getUuidElement();
        case -1857640538:  return getSummaryElement();
        case -1335224239:  return getDetailElement();
        case -711999985:  return getIndicatorElement();
        case -896505829:  return getSource();
        case -1525319953:  return addSuggestions(); 
        case 168639486:  return getSelectionBehaviorElement();
        case -1554410173:  return addOverrideReasons(); 
        case 102977465:  return addLinks(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3601339: /*uuid*/ return new String[] {"uuid"};
        case -1857640538: /*summary*/ return new String[] {"string"};
        case -1335224239: /*detail*/ return new String[] {"markdown"};
        case -711999985: /*indicator*/ return new String[] {"code"};
        case -896505829: /*source*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        case -1525319953: /*suggestions*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        case 168639486: /*selectionBehavior*/ return new String[] {"code"};
        case -1554410173: /*overrideReasons*/ return new String[] {"Coding"};
        case 102977465: /*links*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("uuid")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.uuid");
        }
        else if (name.equals("summary")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.summary");
        }
        else if (name.equals("detail")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.detail");
        }
        else if (name.equals("indicator")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.indicator");
        }
        else if (name.equals("source")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksResponse.cards.source");
        }
        else if (name.equals("suggestions")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksResponse.cards.suggestions");
        }
        else if (name.equals("selectionBehavior")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.selectionBehavior");
        }
        else if (name.equals("overrideReasons")) {
          return addOverrideReasons();
        }
        else if (name.equals("links")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksResponse.cards.links");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksResponseCardsComponent copy() {
        CDSHooksResponseCardsComponent dst = new CDSHooksResponseCardsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksResponseCardsComponent dst) {
        super.copyValues(dst);
        dst.uuid = uuid == null ? null : uuid.copy();
        dst.summary = summary == null ? null : summary.copy();
        dst.detail = detail == null ? null : detail.copy();
        dst.indicator = indicator == null ? null : indicator.copy();
        dst.source = source == null ? null : source.copy();
        if (suggestionsList != null) {
          dst.suggestionsList = new ArrayList<CDSHooksResponseCardsSuggestionsComponent>();
          for (CDSHooksResponseCardsSuggestionsComponent i : suggestionsList)
            dst.suggestionsList.add(i.copy());
        };
        dst.selectionBehavior = selectionBehavior == null ? null : selectionBehavior.copy();
        if (overrideReasonsList != null) {
          dst.overrideReasonsList = new ArrayList<Coding>();
          for (Coding i : overrideReasonsList)
            dst.overrideReasonsList.add(i.copy());
        };
        if (linksList != null) {
          dst.linksList = new ArrayList<CDSHooksResponseCardsLinksComponent>();
          for (CDSHooksResponseCardsLinksComponent i : linksList)
            dst.linksList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsComponent))
          return false;
        CDSHooksResponseCardsComponent o = (CDSHooksResponseCardsComponent) other_;
        return compareDeep(uuid, o.uuid, true) && compareDeep(summary, o.summary, true) && compareDeep(detail, o.detail, true)
           && compareDeep(indicator, o.indicator, true) && compareDeep(source, o.source, true) && compareDeep(suggestionsList, o.suggestionsList, true)
           && compareDeep(selectionBehavior, o.selectionBehavior, true) && compareDeep(overrideReasonsList, o.overrideReasonsList, true)
           && compareDeep(linksList, o.linksList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsComponent))
          return false;
        CDSHooksResponseCardsComponent o = (CDSHooksResponseCardsComponent) other_;
        return compareValues(uuid, o.uuid, true) && compareValues(summary, o.summary, true) && compareValues(detail, o.detail, true)
           && compareValues(indicator, o.indicator, true) && compareValues(selectionBehavior, o.selectionBehavior, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(uuid, summary, detail, indicator
          , source, suggestionsList, selectionBehavior, overrideReasonsList, linksList);
      }

  public String fhirType() {
    return "CDSHooksResponse.cards";

  }

  }

    @Block()
    public static class CDSHooksResponseCardsSourceComponent extends CDSHooksElement {
        /**
         * A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.
         */
        @Child(name = "label", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Short, human-readable label to display for the source.", formalDefinition="A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink." )
        protected StringType label;

        /**
         * An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.
         */
        @Child(name = "url", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Link for when user clicks for more information about the source", formalDefinition="An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card." )
        protected UrlType url;

        /**
         * An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.
         */
        @Child(name = "icon", type = {UrlType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="absolute URL to an icon for the source (<100x100 PNG))", formalDefinition="An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience." )
        protected UrlType icon;

        /**
         * A topic describes the content of the card by providing a high-level categorization that can be useful for filtering, searching or ordered display of related cards in the CDS client's UI. This specification does not prescribe a standard set of topics
         */
        @Child(name = "topic", type = {Coding.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Describes the content of the card - can be useful for filtering, searching or ordered display", formalDefinition="A topic describes the content of the card by providing a high-level categorization that can be useful for filtering, searching or ordered display of related cards in the CDS client's UI. This specification does not prescribe a standard set of topics" )
        protected Coding topic;

        private static final long serialVersionUID = -271286704L;

    /**
     * Constructor
     */
      public CDSHooksResponseCardsSourceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksResponseCardsSourceComponent(String label) {
        super();
        this.setLabel(label);
      }

        /**
         * @return {@link #label} (A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSourceComponent.label");
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
         * @param value {@link #label} (A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public CDSHooksResponseCardsSourceComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.
         */
        public CDSHooksResponseCardsSourceComponent setLabel(String value) { 
            if (this.label == null)
              this.label = new StringType();
            this.label.setValue(value);
          return this;
        }

        /**
         * @return {@link #url} (An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSourceComponent.url");
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
         * @param value {@link #url} (An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CDSHooksResponseCardsSourceComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.
         */
        public CDSHooksResponseCardsSourceComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #icon} (An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.). This is the underlying object with id, value and extensions. The accessor "getIcon" gives direct access to the value
         */
        public UrlType getIconElement() { 
          if (this.icon == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSourceComponent.icon");
            else if (Configuration.doAutoCreate())
              this.icon = new UrlType(); // bb
          return this.icon;
        }

        public boolean hasIconElement() { 
          return this.icon != null && !this.icon.isEmpty();
        }

        public boolean hasIcon() { 
          return this.icon != null && !this.icon.isEmpty();
        }

        /**
         * @param value {@link #icon} (An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.). This is the underlying object with id, value and extensions. The accessor "getIcon" gives direct access to the value
         */
        public CDSHooksResponseCardsSourceComponent setIconElement(UrlType value) { 
          this.icon = value;
          return this;
        }

        /**
         * @return An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.
         */
        public String getIcon() { 
          return this.icon == null ? null : this.icon.getValue();
        }

        /**
         * @param value An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.
         */
        public CDSHooksResponseCardsSourceComponent setIcon(String value) { 
          if (Utilities.noString(value))
            this.icon = null;
          else {
            if (this.icon == null)
              this.icon = new UrlType();
            this.icon.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #topic} (A topic describes the content of the card by providing a high-level categorization that can be useful for filtering, searching or ordered display of related cards in the CDS client's UI. This specification does not prescribe a standard set of topics)
         */
        public Coding getTopic() { 
          if (this.topic == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSourceComponent.topic");
            else if (Configuration.doAutoCreate())
              this.topic = new Coding(); // cc
          return this.topic;
        }

        public boolean hasTopic() { 
          return this.topic != null && !this.topic.isEmpty();
        }

        /**
         * @param value {@link #topic} (A topic describes the content of the card by providing a high-level categorization that can be useful for filtering, searching or ordered display of related cards in the CDS client's UI. This specification does not prescribe a standard set of topics)
         */
        public CDSHooksResponseCardsSourceComponent setTopic(Coding value) { 
          this.topic = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("label", "string", "A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.", 0, 1, label));
          children.add(new Property("url", "url", "An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.", 0, 1, url));
          children.add(new Property("icon", "url", "An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.", 0, 1, icon));
          children.add(new Property("topic", "Coding", "A topic describes the content of the card by providing a high-level categorization that can be useful for filtering, searching or ordered display of related cards in the CDS client's UI. This specification does not prescribe a standard set of topics", 0, 1, topic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 102727412: /*label*/  return new Property("label", "string", "A short, human-readable label to display for the source of the information displayed on this card. If a url is also specified, this MAY be the text for the hyperlink.", 0, 1, label);
          case 116079: /*url*/  return new Property("url", "url", "An optional absolute URL to load (via GET, in a browser context) when a user clicks on this link to learn more about the organization or data set that provided the information on this card.", 0, 1, url);
          case 3226745: /*icon*/  return new Property("icon", "url", "An absolute URL to an icon for the source of this card. The icon returned by this URL SHOULD be a 100x100 pixel PNG image without any transparent regions. The CDS Client may ignore or scale the image during display as appropriate for user experience.", 0, 1, icon);
          case 110546223: /*topic*/  return new Property("topic", "Coding", "A topic describes the content of the card by providing a high-level categorization that can be useful for filtering, searching or ordered display of related cards in the CDS client's UI. This specification does not prescribe a standard set of topics", 0, 1, topic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        case 3226745: /*icon*/ return this.icon == null ? new Base[0] : new Base[] {this.icon}; // UrlType
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : new Base[] {this.topic}; // Coding
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 3226745: // icon
          this.icon = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 110546223: // topic
          this.topic = TypeConvertor.castToCoding(value); // Coding
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("icon")) {
          this.icon = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("topic")) {
          this.topic = TypeConvertor.castToCoding(value); // Coding
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412:  return getLabelElement();
        case 116079:  return getUrlElement();
        case 3226745:  return getIconElement();
        case 110546223:  return getTopic();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return new String[] {"string"};
        case 116079: /*url*/ return new String[] {"url"};
        case 3226745: /*icon*/ return new String[] {"url"};
        case 110546223: /*topic*/ return new String[] {"Coding"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.source.label");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.source.url");
        }
        else if (name.equals("icon")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.source.icon");
        }
        else if (name.equals("topic")) {
          this.topic = new Coding();
          return this.topic;
        }
        else
          return super.addChild(name);
      }

      public CDSHooksResponseCardsSourceComponent copy() {
        CDSHooksResponseCardsSourceComponent dst = new CDSHooksResponseCardsSourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksResponseCardsSourceComponent dst) {
        super.copyValues(dst);
        dst.label = label == null ? null : label.copy();
        dst.url = url == null ? null : url.copy();
        dst.icon = icon == null ? null : icon.copy();
        dst.topic = topic == null ? null : topic.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsSourceComponent))
          return false;
        CDSHooksResponseCardsSourceComponent o = (CDSHooksResponseCardsSourceComponent) other_;
        return compareDeep(label, o.label, true) && compareDeep(url, o.url, true) && compareDeep(icon, o.icon, true)
           && compareDeep(topic, o.topic, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsSourceComponent))
          return false;
        CDSHooksResponseCardsSourceComponent o = (CDSHooksResponseCardsSourceComponent) other_;
        return compareValues(label, o.label, true) && compareValues(url, o.url, true) && compareValues(icon, o.icon, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(label, url, icon, topic
          );
      }

  public String fhirType() {
    return "CDSHooksResponse.cards.source";

  }

  }

    @Block()
    public static class CDSHooksResponseCardsSuggestionsComponent extends CDSHooksElement {
        /**
         * Human-readable label to display for this suggestion
         */
        @Child(name = "label", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-readable label to display for this suggestion", formalDefinition="Human-readable label to display for this suggestion" )
        protected StringType label;

        /**
         * Unique identifier, used for auditing and logging suggestions
         */
        @Child(name = "uuid", type = {UuidType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Unique identifier, used for auditing and logging suggestions", formalDefinition="Unique identifier, used for auditing and logging suggestions" )
        protected UuidType uuid;

        /**
         * When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card
         */
        @Child(name = "isRecommended", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="", formalDefinition="When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card" )
        protected BooleanType isRecommended;

        /**
         * Defines a suggested action. Within a suggestion, all actions are logically AND'd together, such that a user selecting a suggestion selects all of the actions within it
         */
        @Child(name = "actions", type = {CDSHooksElement.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Defines a suggested action (all apply)", formalDefinition="Defines a suggested action. Within a suggestion, all actions are logically AND'd together, such that a user selecting a suggestion selects all of the actions within it" )
        protected List<CDSHooksResponseCardsSuggestionsActionsComponent> actionsList;

        private static final long serialVersionUID = 89077716L;

    /**
     * Constructor
     */
      public CDSHooksResponseCardsSuggestionsComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksResponseCardsSuggestionsComponent(String label) {
        super();
        this.setLabel(label);
      }

        /**
         * @return {@link #label} (Human-readable label to display for this suggestion). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSuggestionsComponent.label");
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
         * @param value {@link #label} (Human-readable label to display for this suggestion). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public CDSHooksResponseCardsSuggestionsComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return Human-readable label to display for this suggestion
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value Human-readable label to display for this suggestion
         */
        public CDSHooksResponseCardsSuggestionsComponent setLabel(String value) { 
            if (this.label == null)
              this.label = new StringType();
            this.label.setValue(value);
          return this;
        }

        /**
         * @return {@link #uuid} (Unique identifier, used for auditing and logging suggestions). This is the underlying object with id, value and extensions. The accessor "getUuid" gives direct access to the value
         */
        public UuidType getUuidElement() { 
          if (this.uuid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSuggestionsComponent.uuid");
            else if (Configuration.doAutoCreate())
              this.uuid = new UuidType(); // bb
          return this.uuid;
        }

        public boolean hasUuidElement() { 
          return this.uuid != null && !this.uuid.isEmpty();
        }

        public boolean hasUuid() { 
          return this.uuid != null && !this.uuid.isEmpty();
        }

        /**
         * @param value {@link #uuid} (Unique identifier, used for auditing and logging suggestions). This is the underlying object with id, value and extensions. The accessor "getUuid" gives direct access to the value
         */
        public CDSHooksResponseCardsSuggestionsComponent setUuidElement(UuidType value) { 
          this.uuid = value;
          return this;
        }

        /**
         * @return Unique identifier, used for auditing and logging suggestions
         */
        public String getUuid() { 
          return this.uuid == null ? null : this.uuid.getValue();
        }

        /**
         * @param value Unique identifier, used for auditing and logging suggestions
         */
        public CDSHooksResponseCardsSuggestionsComponent setUuid(String value) { 
          if (Utilities.noString(value))
            this.uuid = null;
          else {
            if (this.uuid == null)
              this.uuid = new UuidType();
            this.uuid.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #isRecommended} (When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card). This is the underlying object with id, value and extensions. The accessor "getIsRecommended" gives direct access to the value
         */
        public BooleanType getIsRecommendedElement() { 
          if (this.isRecommended == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSuggestionsComponent.isRecommended");
            else if (Configuration.doAutoCreate())
              this.isRecommended = new BooleanType(); // bb
          return this.isRecommended;
        }

        public boolean hasIsRecommendedElement() { 
          return this.isRecommended != null && !this.isRecommended.isEmpty();
        }

        public boolean hasIsRecommended() { 
          return this.isRecommended != null && !this.isRecommended.isEmpty();
        }

        /**
         * @param value {@link #isRecommended} (When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card). This is the underlying object with id, value and extensions. The accessor "getIsRecommended" gives direct access to the value
         */
        public CDSHooksResponseCardsSuggestionsComponent setIsRecommendedElement(BooleanType value) { 
          this.isRecommended = value;
          return this;
        }

        /**
         * @return When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card
         */
        public boolean getIsRecommended() { 
          return this.isRecommended == null || this.isRecommended.isEmpty() ? false : this.isRecommended.getValue();
        }

        /**
         * @param value When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card
         */
        public CDSHooksResponseCardsSuggestionsComponent setIsRecommended(boolean value) { 
            if (this.isRecommended == null)
              this.isRecommended = new BooleanType();
            this.isRecommended.setValue(value);
          return this;
        }

        /**
         * @return {@link #actions} (Defines a suggested action. Within a suggestion, all actions are logically AND'd together, such that a user selecting a suggestion selects all of the actions within it)
         */
        public List<CDSHooksResponseCardsSuggestionsActionsComponent> getActionsList() { 
          if (this.actionsList == null)
            this.actionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
          return this.actionsList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CDSHooksResponseCardsSuggestionsComponent setActionsList(List<CDSHooksResponseCardsSuggestionsActionsComponent> theActions) { 
          this.actionsList = theActions;
          return this;
        }

        public boolean hasActions() { 
          if (this.actionsList == null)
            return false;
          for (CDSHooksResponseCardsSuggestionsActionsComponent item : this.actionsList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CDSHooksResponseCardsSuggestionsActionsComponent addActions() { //3a
          CDSHooksResponseCardsSuggestionsActionsComponent t = new CDSHooksResponseCardsSuggestionsActionsComponent();
          if (this.actionsList == null)
            this.actionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
          this.actionsList.add(t);
          return t;
        }

        public CDSHooksResponseCardsSuggestionsComponent addActions(CDSHooksResponseCardsSuggestionsActionsComponent t) { //3b
          if (t == null)
            return this;
          if (this.actionsList == null)
            this.actionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
          this.actionsList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #actions}, creating it if it does not already exist {3}
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent getActionsFirstRep() { 
          if (getActionsList().isEmpty()) {
            addActions();
          }
          return getActionsList().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("label", "string", "Human-readable label to display for this suggestion", 0, 1, label));
          children.add(new Property("uuid", "uuid", "Unique identifier, used for auditing and logging suggestions", 0, 1, uuid));
          children.add(new Property("isRecommended", "boolean", "When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card", 0, 1, isRecommended));
          children.add(new Property("actions", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "Defines a suggested action. Within a suggestion, all actions are logically AND'd together, such that a user selecting a suggestion selects all of the actions within it", 0, java.lang.Integer.MAX_VALUE, actionsList));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 102727412: /*label*/  return new Property("label", "string", "Human-readable label to display for this suggestion", 0, 1, label);
          case 3601339: /*uuid*/  return new Property("uuid", "uuid", "Unique identifier, used for auditing and logging suggestions", 0, 1, uuid);
          case 27884241: /*isRecommended*/  return new Property("isRecommended", "boolean", "When there are multiple suggestions, allows a service to indicate that a specific suggestion is recommended from all the available suggestions on the card", 0, 1, isRecommended);
          case -1161803523: /*actions*/  return new Property("actions", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "Defines a suggested action. Within a suggestion, all actions are logically AND'd together, such that a user selecting a suggestion selects all of the actions within it", 0, java.lang.Integer.MAX_VALUE, actionsList);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 3601339: /*uuid*/ return this.uuid == null ? new Base[0] : new Base[] {this.uuid}; // UuidType
        case 27884241: /*isRecommended*/ return this.isRecommended == null ? new Base[0] : new Base[] {this.isRecommended}; // BooleanType
        case -1161803523: /*actions*/ return this.actionsList == null ? new Base[0] : this.actionsList.toArray(new Base[this.actionsList.size()]); // CDSHooksResponseCardsSuggestionsActionsComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case 3601339: // uuid
          this.uuid = TypeConvertor.castToUuid(value); // UuidType
          return value;
        case 27884241: // isRecommended
          this.isRecommended = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1161803523: // actions
          this.getActionsList().add((CDSHooksResponseCardsSuggestionsActionsComponent) value); // CDSHooksResponseCardsSuggestionsActionsComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("uuid")) {
          this.uuid = TypeConvertor.castToUuid(value); // UuidType
        } else if (name.equals("isRecommended")) {
          this.isRecommended = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("actions")) {
          this.getActionsList().add((CDSHooksResponseCardsSuggestionsActionsComponent) value); // CDSHooksResponseCardsSuggestionsActionsComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412:  return getLabelElement();
        case 3601339:  return getUuidElement();
        case 27884241:  return getIsRecommendedElement();
        case -1161803523:  return addActions(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return new String[] {"string"};
        case 3601339: /*uuid*/ return new String[] {"uuid"};
        case 27884241: /*isRecommended*/ return new String[] {"boolean"};
        case -1161803523: /*actions*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.suggestions.label");
        }
        else if (name.equals("uuid")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.suggestions.uuid");
        }
        else if (name.equals("isRecommended")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.suggestions.isRecommended");
        }
        else if (name.equals("actions")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksResponse.cards.suggestions.actions");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksResponseCardsSuggestionsComponent copy() {
        CDSHooksResponseCardsSuggestionsComponent dst = new CDSHooksResponseCardsSuggestionsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksResponseCardsSuggestionsComponent dst) {
        super.copyValues(dst);
        dst.label = label == null ? null : label.copy();
        dst.uuid = uuid == null ? null : uuid.copy();
        dst.isRecommended = isRecommended == null ? null : isRecommended.copy();
        if (actionsList != null) {
          dst.actionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
          for (CDSHooksResponseCardsSuggestionsActionsComponent i : actionsList)
            dst.actionsList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsSuggestionsComponent))
          return false;
        CDSHooksResponseCardsSuggestionsComponent o = (CDSHooksResponseCardsSuggestionsComponent) other_;
        return compareDeep(label, o.label, true) && compareDeep(uuid, o.uuid, true) && compareDeep(isRecommended, o.isRecommended, true)
           && compareDeep(actionsList, o.actionsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsSuggestionsComponent))
          return false;
        CDSHooksResponseCardsSuggestionsComponent o = (CDSHooksResponseCardsSuggestionsComponent) other_;
        return compareValues(label, o.label, true) && compareValues(uuid, o.uuid, true) && compareValues(isRecommended, o.isRecommended, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(label, uuid, isRecommended
          , actionsList);
      }

  public String fhirType() {
    return "CDSHooksResponse.cards.suggestions";

  }

  }

    @Block()
    public static class CDSHooksResponseCardsSuggestionsActionsComponent extends CDSHooksElement {
        /**
         * The type of action being performed. Allowed values are: create, update, delete.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="create, update, delete - type of action performed", formalDefinition="The type of action being performed. Allowed values are: create, update, delete." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/tools/ValueSet/CDSActionType")
        protected Enumeration<CDSActionTypeCodesVS> type;

        /**
         * Human-readable description of the suggested action that MAY be presented to the end-user.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-readable description of the suggested action (MAY be presented to the end-user)", formalDefinition="Human-readable description of the suggested action that MAY be presented to the end-user." )
        protected StringType description;

        /**
         * When the type attribute is create, the resource attribute SHALL contain a new FHIR resource to be created. For update, this holds the updated resource in its entirety and not just the changed fields.
         */
        @Child(name = "resource", type = {Resource.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="FHIR resource to create/update", formalDefinition="When the type attribute is create, the resource attribute SHALL contain a new FHIR resource to be created. For update, this holds the updated resource in its entirety and not just the changed fields." )
        protected Resource resource;

        /**
         * A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.
         */
        @Child(name = "resourceId", type = {UrlType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A relative reference to the relevant resource.", formalDefinition="A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete." )
        protected UrlType resourceId;

        private static final long serialVersionUID = -1667751535L;

    /**
     * Constructor
     */
      public CDSHooksResponseCardsSuggestionsActionsComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksResponseCardsSuggestionsActionsComponent(CDSActionTypeCodesVS type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The type of action being performed. Allowed values are: create, update, delete.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<CDSActionTypeCodesVS> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSuggestionsActionsComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<CDSActionTypeCodesVS>(new CDSActionTypeCodesVSEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of action being performed. Allowed values are: create, update, delete.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setTypeElement(Enumeration<CDSActionTypeCodesVS> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of action being performed. Allowed values are: create, update, delete.
         */
        public CDSActionTypeCodesVS getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of action being performed. Allowed values are: create, update, delete.
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setType(CDSActionTypeCodesVS value) { 
            if (this.type == null)
              this.type = new Enumeration<CDSActionTypeCodesVS>(new CDSActionTypeCodesVSEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Human-readable description of the suggested action that MAY be presented to the end-user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSuggestionsActionsComponent.description");
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
         * @param value {@link #description} (Human-readable description of the suggested action that MAY be presented to the end-user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Human-readable description of the suggested action that MAY be presented to the end-user.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Human-readable description of the suggested action that MAY be presented to the end-user.
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setDescription(String value) { 
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
         * @return {@link #resource} (When the type attribute is create, the resource attribute SHALL contain a new FHIR resource to be created. For update, this holds the updated resource in its entirety and not just the changed fields.)
         */
        public Resource getResource() { 
          return this.resource;
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (When the type attribute is create, the resource attribute SHALL contain a new FHIR resource to be created. For update, this holds the updated resource in its entirety and not just the changed fields.)
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setResource(Resource value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return {@link #resourceId} (A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.). This is the underlying object with id, value and extensions. The accessor "getResourceId" gives direct access to the value
         */
        public UrlType getResourceIdElement() { 
          if (this.resourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsSuggestionsActionsComponent.resourceId");
            else if (Configuration.doAutoCreate())
              this.resourceId = new UrlType(); // bb
          return this.resourceId;
        }

        public boolean hasResourceIdElement() { 
          return this.resourceId != null && !this.resourceId.isEmpty();
        }

        public boolean hasResourceId() { 
          return this.resourceId != null && !this.resourceId.isEmpty();
        }

        /**
         * @param value {@link #resourceId} (A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.). This is the underlying object with id, value and extensions. The accessor "getResourceId" gives direct access to the value
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setResourceIdElement(UrlType value) { 
          this.resourceId = value;
          return this;
        }

        /**
         * @return A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.
         */
        public String getResourceId() { 
          return this.resourceId == null ? null : this.resourceId.getValue();
        }

        /**
         * @param value A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.
         */
        public CDSHooksResponseCardsSuggestionsActionsComponent setResourceId(String value) { 
          if (Utilities.noString(value))
            this.resourceId = null;
          else {
            if (this.resourceId == null)
              this.resourceId = new UrlType();
            this.resourceId.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The type of action being performed. Allowed values are: create, update, delete.", 0, 1, type));
          children.add(new Property("description", "string", "Human-readable description of the suggested action that MAY be presented to the end-user.", 0, 1, description));
          children.add(new Property("resource", "Resource", "When the type attribute is create, the resource attribute SHALL contain a new FHIR resource to be created. For update, this holds the updated resource in its entirety and not just the changed fields.", 0, 1, resource));
          children.add(new Property("resourceId", "url", "A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.", 0, 1, resourceId));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The type of action being performed. Allowed values are: create, update, delete.", 0, 1, type);
          case -1724546052: /*description*/  return new Property("description", "string", "Human-readable description of the suggested action that MAY be presented to the end-user.", 0, 1, description);
          case -341064690: /*resource*/  return new Property("resource", "Resource", "When the type attribute is create, the resource attribute SHALL contain a new FHIR resource to be created. For update, this holds the updated resource in its entirety and not just the changed fields.", 0, 1, resource);
          case -1345650231: /*resourceId*/  return new Property("resourceId", "url", "A relative reference to the relevant resource. SHOULD be provided when the type attribute is delete.", 0, 1, resourceId);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<CDSActionTypeCodesVS>
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Resource
        case -1345650231: /*resourceId*/ return this.resourceId == null ? new Base[0] : new Base[] {this.resourceId}; // UrlType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new CDSActionTypeCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<CDSActionTypeCodesVS>
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -341064690: // resource
          this.resource = (Resource) value; // Resource
          return value;
        case -1345650231: // resourceId
          this.resourceId = TypeConvertor.castToUrl(value); // UrlType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new CDSActionTypeCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<CDSActionTypeCodesVS>
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resource")) {
          this.resource = (Resource) value; // Resource
        } else if (name.equals("resourceId")) {
          this.resourceId = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -1724546052:  return getDescriptionElement();
        case -341064690: throw new FHIRException("Cannot make property resource as it is not a complex type"); // Resource
        case -1345650231:  return getResourceIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -341064690: /*resource*/ return new String[] {"Resource"};
        case -1345650231: /*resourceId*/ return new String[] {"url"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.suggestions.actions.type");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.suggestions.actions.description");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksResponse.cards.suggestions.actions.resource");
        }
        else if (name.equals("resourceId")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.suggestions.actions.resourceId");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksResponseCardsSuggestionsActionsComponent copy() {
        CDSHooksResponseCardsSuggestionsActionsComponent dst = new CDSHooksResponseCardsSuggestionsActionsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksResponseCardsSuggestionsActionsComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.description = description == null ? null : description.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.resourceId = resourceId == null ? null : resourceId.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsSuggestionsActionsComponent))
          return false;
        CDSHooksResponseCardsSuggestionsActionsComponent o = (CDSHooksResponseCardsSuggestionsActionsComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(description, o.description, true) && compareDeep(resource, o.resource, true)
           && compareDeep(resourceId, o.resourceId, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsSuggestionsActionsComponent))
          return false;
        CDSHooksResponseCardsSuggestionsActionsComponent o = (CDSHooksResponseCardsSuggestionsActionsComponent) other_;
        return compareValues(type, o.type, true) && compareValues(description, o.description, true) && compareValues(resourceId, o.resourceId, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, description, resource
          , resourceId);
      }

  public String fhirType() {
    return "CDSHooksResponse.cards.suggestions.actions";

  }

  }

    @Block()
    public static class CDSHooksResponseCardsLinksComponent extends CDSHooksElement {
        /**
         * Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).
         */
        @Child(name = "label", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).", formalDefinition="Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link)." )
        protected StringType label;

        /**
         * URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.
         */
        @Child(name = "url", type = {UrlType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.", formalDefinition="URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash." )
        protected UrlType url;

        /**
         * The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters
         */
        @Child(name = "type", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="absolute, smart - how to use the link", formalDefinition="The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters" )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/tools/ValueSet/CDSLinkType")
        protected Enumeration<CDSLinkTypeCodesVS> type;

        /**
         * An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.
         */
        @Child(name = "appContext", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Allows the CDS Service to share information from the CDS card with a subsequently launched SMART app", formalDefinition="An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it." )
        protected StringType appContext;

        private static final long serialVersionUID = 1992417446L;

    /**
     * Constructor
     */
      public CDSHooksResponseCardsLinksComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CDSHooksResponseCardsLinksComponent(String label, String url) {
        super();
        this.setLabel(label);
        this.setUrl(url);
      }

        /**
         * @return {@link #label} (Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public StringType getLabelElement() { 
          if (this.label == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsLinksComponent.label");
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
         * @param value {@link #label} (Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
         */
        public CDSHooksResponseCardsLinksComponent setLabelElement(StringType value) { 
          this.label = value;
          return this;
        }

        /**
         * @return Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).
         */
        public String getLabel() { 
          return this.label == null ? null : this.label.getValue();
        }

        /**
         * @param value Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).
         */
        public CDSHooksResponseCardsLinksComponent setLabel(String value) { 
            if (this.label == null)
              this.label = new StringType();
            this.label.setValue(value);
          return this;
        }

        /**
         * @return {@link #url} (URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsLinksComponent.url");
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
         * @param value {@link #url} (URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CDSHooksResponseCardsLinksComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.
         */
        public CDSHooksResponseCardsLinksComponent setUrl(String value) { 
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<CDSLinkTypeCodesVS> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsLinksComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<CDSLinkTypeCodesVS>(new CDSLinkTypeCodesVSEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CDSHooksResponseCardsLinksComponent setTypeElement(Enumeration<CDSLinkTypeCodesVS> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters
         */
        public CDSLinkTypeCodesVS getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters
         */
        public CDSHooksResponseCardsLinksComponent setType(CDSLinkTypeCodesVS value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<CDSLinkTypeCodesVS>(new CDSLinkTypeCodesVSEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #appContext} (An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.). This is the underlying object with id, value and extensions. The accessor "getAppContext" gives direct access to the value
         */
        public StringType getAppContextElement() { 
          if (this.appContext == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CDSHooksResponseCardsLinksComponent.appContext");
            else if (Configuration.doAutoCreate())
              this.appContext = new StringType(); // bb
          return this.appContext;
        }

        public boolean hasAppContextElement() { 
          return this.appContext != null && !this.appContext.isEmpty();
        }

        public boolean hasAppContext() { 
          return this.appContext != null && !this.appContext.isEmpty();
        }

        /**
         * @param value {@link #appContext} (An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.). This is the underlying object with id, value and extensions. The accessor "getAppContext" gives direct access to the value
         */
        public CDSHooksResponseCardsLinksComponent setAppContextElement(StringType value) { 
          this.appContext = value;
          return this;
        }

        /**
         * @return An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.
         */
        public String getAppContext() { 
          return this.appContext == null ? null : this.appContext.getValue();
        }

        /**
         * @param value An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.
         */
        public CDSHooksResponseCardsLinksComponent setAppContext(String value) { 
          if (Utilities.noString(value))
            this.appContext = null;
          else {
            if (this.appContext == null)
              this.appContext = new StringType();
            this.appContext.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("label", "string", "Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).", 0, 1, label));
          children.add(new Property("url", "url", "URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.", 0, 1, url));
          children.add(new Property("type", "code", "The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters", 0, 1, type));
          children.add(new Property("appContext", "string", "An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.", 0, 1, appContext));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 102727412: /*label*/  return new Property("label", "string", "Human-readable label to display for this link (e.g. the CDS Client might render this as the underlined text of a clickable link).", 0, 1, label);
          case 116079: /*url*/  return new Property("url", "url", "URL to load (via GET, in a browser context) when a user clicks on this link. Note that this MAY be a 'deep link' with context embedded in path segments, query parameters, or a hash.", 0, 1, url);
          case 3575610: /*type*/  return new Property("type", "code", "The type of the given URL. There are two possible values for this field. A type of absolute indicates that the URL is absolute and should be treated as-is. A type of smart indicates that the URL is a SMART app launch URL and the CDS Client should ensure the SMART app launch URL is populated with the appropriate SMART launch parameters", 0, 1, type);
          case 2084035662: /*appContext*/  return new Property("appContext", "string", "An optional field that allows the CDS Service to share information from the CDS card with a subsequently launched SMART app. The appContext field should only be valued if the link type is smart and is not valid for absolute links. The appContext field and value will be sent to the SMART app as part of the OAuth 2.0 access token response, alongside the other SMART launch parameters when the SMART app is launched. Note that appContext could be escaped JSON, base64 encoded XML, or even a simple string, so long as the SMART app can recognize it.", 0, 1, appContext);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<CDSLinkTypeCodesVS>
        case 2084035662: /*appContext*/ return this.appContext == null ? new Base[0] : new Base[] {this.appContext}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 3575610: // type
          value = new CDSLinkTypeCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<CDSLinkTypeCodesVS>
          return value;
        case 2084035662: // appContext
          this.appContext = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("type")) {
          value = new CDSLinkTypeCodesVSEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<CDSLinkTypeCodesVS>
        } else if (name.equals("appContext")) {
          this.appContext = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412:  return getLabelElement();
        case 116079:  return getUrlElement();
        case 3575610:  return getTypeElement();
        case 2084035662:  return getAppContextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 102727412: /*label*/ return new String[] {"string"};
        case 116079: /*url*/ return new String[] {"url"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 2084035662: /*appContext*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.links.label");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.links.url");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.links.type");
        }
        else if (name.equals("appContext")) {
          throw new FHIRException("Cannot call addChild on a singleton property CDSHooksResponse.cards.links.appContext");
        }
        else
          return super.addChild(name);
      }

      public CDSHooksResponseCardsLinksComponent copy() {
        CDSHooksResponseCardsLinksComponent dst = new CDSHooksResponseCardsLinksComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksResponseCardsLinksComponent dst) {
        super.copyValues(dst);
        dst.label = label == null ? null : label.copy();
        dst.url = url == null ? null : url.copy();
        dst.type = type == null ? null : type.copy();
        dst.appContext = appContext == null ? null : appContext.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsLinksComponent))
          return false;
        CDSHooksResponseCardsLinksComponent o = (CDSHooksResponseCardsLinksComponent) other_;
        return compareDeep(label, o.label, true) && compareDeep(url, o.url, true) && compareDeep(type, o.type, true)
           && compareDeep(appContext, o.appContext, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponseCardsLinksComponent))
          return false;
        CDSHooksResponseCardsLinksComponent o = (CDSHooksResponseCardsLinksComponent) other_;
        return compareValues(label, o.label, true) && compareValues(url, o.url, true) && compareValues(type, o.type, true)
           && compareValues(appContext, o.appContext, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(label, url, type, appContext
          );
      }

  public String fhirType() {
    return "CDSHooksResponse.cards.links";

  }

  }

    /**
     * An array of Cards. Cards can provide a combination of information (for reading), suggested actions (to be applied if a user selects them), and links (to launch an app if the user selects them).
     */
    @Child(name = "cards", type = {CDSHooksElement.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An array of Cards that provide information, suggested actions, and links", formalDefinition="An array of Cards. Cards can provide a combination of information (for reading), suggested actions (to be applied if a user selects them), and links (to launch an app if the user selects them)." )
    protected List<CDSHooksResponseCardsComponent> cardsList;

    /**
     * An array of Actions that the CDS Service proposes to auto-apply
     */
    @Child(name = "systemActions", type = {CDSHooksResponseCardsSuggestionsActionsComponent.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An array of Actions that the CDS Service proposes to auto-apply", formalDefinition="An array of Actions that the CDS Service proposes to auto-apply" )
    protected List<CDSHooksResponseCardsSuggestionsActionsComponent> systemActionsList;

    private static final long serialVersionUID = -131860217L;

  /**
   * Constructor
   */
    public CDSHooksResponse() {
      super();
    }

    /**
     * @return {@link #cards} (An array of Cards. Cards can provide a combination of information (for reading), suggested actions (to be applied if a user selects them), and links (to launch an app if the user selects them).)
     */
    public List<CDSHooksResponseCardsComponent> getCardsList() { 
      if (this.cardsList == null)
        this.cardsList = new ArrayList<CDSHooksResponseCardsComponent>();
      return this.cardsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CDSHooksResponse setCardsList(List<CDSHooksResponseCardsComponent> theCards) { 
      this.cardsList = theCards;
      return this;
    }

    public boolean hasCards() { 
      if (this.cardsList == null)
        return false;
      for (CDSHooksResponseCardsComponent item : this.cardsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CDSHooksResponseCardsComponent addCards() { //3a
      CDSHooksResponseCardsComponent t = new CDSHooksResponseCardsComponent();
      if (this.cardsList == null)
        this.cardsList = new ArrayList<CDSHooksResponseCardsComponent>();
      this.cardsList.add(t);
      return t;
    }

    public CDSHooksResponse addCards(CDSHooksResponseCardsComponent t) { //3b
      if (t == null)
        return this;
      if (this.cardsList == null)
        this.cardsList = new ArrayList<CDSHooksResponseCardsComponent>();
      this.cardsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #cards}, creating it if it does not already exist {3}
     */
    public CDSHooksResponseCardsComponent getCardsFirstRep() { 
      if (getCardsList().isEmpty()) {
        addCards();
      }
      return getCardsList().get(0);
    }

    /**
     * @return {@link #systemActions} (An array of Actions that the CDS Service proposes to auto-apply)
     */
    public List<CDSHooksResponseCardsSuggestionsActionsComponent> getSystemActionsList() { 
      if (this.systemActionsList == null)
        this.systemActionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
      return this.systemActionsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CDSHooksResponse setSystemActionsList(List<CDSHooksResponseCardsSuggestionsActionsComponent> theSystemActions) { 
      this.systemActionsList = theSystemActions;
      return this;
    }

    public boolean hasSystemActions() { 
      if (this.systemActionsList == null)
        return false;
      for (CDSHooksResponseCardsSuggestionsActionsComponent item : this.systemActionsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CDSHooksResponseCardsSuggestionsActionsComponent addSystemActions() { //3a
      CDSHooksResponseCardsSuggestionsActionsComponent t = new CDSHooksResponseCardsSuggestionsActionsComponent();
      if (this.systemActionsList == null)
        this.systemActionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
      this.systemActionsList.add(t);
      return t;
    }

    public CDSHooksResponse addSystemActions(CDSHooksResponseCardsSuggestionsActionsComponent t) { //3b
      if (t == null)
        return this;
      if (this.systemActionsList == null)
        this.systemActionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
      this.systemActionsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #systemActions}, creating it if it does not already exist {3}
     */
    public CDSHooksResponseCardsSuggestionsActionsComponent getSystemActionsFirstRep() { 
      if (getSystemActionsList().isEmpty()) {
        addSystemActions();
      }
      return getSystemActionsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("cards", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "An array of Cards. Cards can provide a combination of information (for reading), suggested actions (to be applied if a user selects them), and links (to launch an app if the user selects them).", 0, java.lang.Integer.MAX_VALUE, cardsList));
        children.add(new Property("systemActions", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksResponse@CDSHooksResponse.cards.suggestions.actions", "An array of Actions that the CDS Service proposes to auto-apply", 0, java.lang.Integer.MAX_VALUE, systemActionsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 94431075: /*cards*/  return new Property("cards", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement", "An array of Cards. Cards can provide a combination of information (for reading), suggested actions (to be applied if a user selects them), and links (to launch an app if the user selects them).", 0, java.lang.Integer.MAX_VALUE, cardsList);
        case 867134414: /*systemActions*/  return new Property("systemActions", "http://hl7.org/fhir/tools/StructureDefinition/CDSHooksResponse@CDSHooksResponse.cards.suggestions.actions", "An array of Actions that the CDS Service proposes to auto-apply", 0, java.lang.Integer.MAX_VALUE, systemActionsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 94431075: /*cards*/ return this.cardsList == null ? new Base[0] : this.cardsList.toArray(new Base[this.cardsList.size()]); // CDSHooksResponseCardsComponent
        case 867134414: /*systemActions*/ return this.systemActionsList == null ? new Base[0] : this.systemActionsList.toArray(new Base[this.systemActionsList.size()]); // CDSHooksResponseCardsSuggestionsActionsComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 94431075: // cards
          this.getCardsList().add((CDSHooksResponseCardsComponent) value); // CDSHooksResponseCardsComponent
          return value;
        case 867134414: // systemActions
          this.getSystemActionsList().add((CDSHooksResponseCardsSuggestionsActionsComponent) value); // CDSHooksResponseCardsSuggestionsActionsComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("cards")) {
          this.getCardsList().add((CDSHooksResponseCardsComponent) value); // CDSHooksResponseCardsComponent
        } else if (name.equals("systemActions")) {
          this.getSystemActionsList().add((CDSHooksResponseCardsSuggestionsActionsComponent) value); // CDSHooksResponseCardsSuggestionsActionsComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 94431075:  return addCards(); 
        case 867134414:  return addSystemActions(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 94431075: /*cards*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksElement"};
        case 867134414: /*systemActions*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/CDSHooksResponse@CDSHooksResponse.cards.suggestions.actions"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("cards")) {
          throw new FHIRException("Cannot call addChild on an abstract type CDSHooksResponse.cards");
        }
        else if (name.equals("systemActions")) {
          return addSystemActions();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CDSHooksResponse";

  }

      public CDSHooksResponse copy() {
        CDSHooksResponse dst = new CDSHooksResponse();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CDSHooksResponse dst) {
        super.copyValues(dst);
        if (cardsList != null) {
          dst.cardsList = new ArrayList<CDSHooksResponseCardsComponent>();
          for (CDSHooksResponseCardsComponent i : cardsList)
            dst.cardsList.add(i.copy());
        };
        if (systemActionsList != null) {
          dst.systemActionsList = new ArrayList<CDSHooksResponseCardsSuggestionsActionsComponent>();
          for (CDSHooksResponseCardsSuggestionsActionsComponent i : systemActionsList)
            dst.systemActionsList.add(i.copy());
        };
      }

      protected CDSHooksResponse typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponse))
          return false;
        CDSHooksResponse o = (CDSHooksResponse) other_;
        return compareDeep(cardsList, o.cardsList, true) && compareDeep(systemActionsList, o.systemActionsList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CDSHooksResponse))
          return false;
        CDSHooksResponse o = (CDSHooksResponse) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(cardsList, systemActionsList
          );
      }


}

