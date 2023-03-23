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
 * A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.
 */
@ResourceDef(name="QuestionnaireResponse", profile="http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse")
public class QuestionnaireResponse extends DomainResource {

    public enum QuestionnaireResponseStatus {
        /**
         * This QuestionnaireResponse has been partially filled out with answers but changes or additions are still expected to be made to it.
         */
        INPROGRESS, 
        /**
         * This QuestionnaireResponse has been filled out with answers and the current content is regarded as definitive.
         */
        COMPLETED, 
        /**
         * This QuestionnaireResponse has been filled out with answers, then marked as complete, yet changes or additions have been made to it afterwards.
         */
        AMENDED, 
        /**
         * This QuestionnaireResponse was entered in error and voided.
         */
        ENTEREDINERROR, 
        /**
         * This QuestionnaireResponse has been partially filled out with answers but has been abandoned. No subsequent changes can be made.
         */
        STOPPED, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static QuestionnaireResponseStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("amended".equals(codeString))
          return AMENDED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("stopped".equals(codeString))
          return STOPPED;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown QuestionnaireResponseStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INPROGRESS: return "in-progress";
            case COMPLETED: return "completed";
            case AMENDED: return "amended";
            case ENTEREDINERROR: return "entered-in-error";
            case STOPPED: return "stopped";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INPROGRESS: return "http://hl7.org/fhir/questionnaire-answers-status";
            case COMPLETED: return "http://hl7.org/fhir/questionnaire-answers-status";
            case AMENDED: return "http://hl7.org/fhir/questionnaire-answers-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/questionnaire-answers-status";
            case STOPPED: return "http://hl7.org/fhir/questionnaire-answers-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INPROGRESS: return "This QuestionnaireResponse has been partially filled out with answers but changes or additions are still expected to be made to it.";
            case COMPLETED: return "This QuestionnaireResponse has been filled out with answers and the current content is regarded as definitive.";
            case AMENDED: return "This QuestionnaireResponse has been filled out with answers, then marked as complete, yet changes or additions have been made to it afterwards.";
            case ENTEREDINERROR: return "This QuestionnaireResponse was entered in error and voided.";
            case STOPPED: return "This QuestionnaireResponse has been partially filled out with answers but has been abandoned. No subsequent changes can be made.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INPROGRESS: return "In Progress";
            case COMPLETED: return "Completed";
            case AMENDED: return "Amended";
            case ENTEREDINERROR: return "Entered in Error";
            case STOPPED: return "Stopped";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class QuestionnaireResponseStatusEnumFactory implements EnumFactory<QuestionnaireResponseStatus> {
    public QuestionnaireResponseStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return QuestionnaireResponseStatus.INPROGRESS;
        if ("completed".equals(codeString))
          return QuestionnaireResponseStatus.COMPLETED;
        if ("amended".equals(codeString))
          return QuestionnaireResponseStatus.AMENDED;
        if ("entered-in-error".equals(codeString))
          return QuestionnaireResponseStatus.ENTEREDINERROR;
        if ("stopped".equals(codeString))
          return QuestionnaireResponseStatus.STOPPED;
        throw new IllegalArgumentException("Unknown QuestionnaireResponseStatus code '"+codeString+"'");
        }
        public Enumeration<QuestionnaireResponseStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.NULL, code);
        if ("in-progress".equals(codeString))
          return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.INPROGRESS, code);
        if ("completed".equals(codeString))
          return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.COMPLETED, code);
        if ("amended".equals(codeString))
          return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.AMENDED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.ENTEREDINERROR, code);
        if ("stopped".equals(codeString))
          return new Enumeration<QuestionnaireResponseStatus>(this, QuestionnaireResponseStatus.STOPPED, code);
        throw new FHIRException("Unknown QuestionnaireResponseStatus code '"+codeString+"'");
        }
    public String toCode(QuestionnaireResponseStatus code) {
      if (code == QuestionnaireResponseStatus.INPROGRESS)
        return "in-progress";
      if (code == QuestionnaireResponseStatus.COMPLETED)
        return "completed";
      if (code == QuestionnaireResponseStatus.AMENDED)
        return "amended";
      if (code == QuestionnaireResponseStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == QuestionnaireResponseStatus.STOPPED)
        return "stopped";
      return "?";
      }
    public String toSystem(QuestionnaireResponseStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class QuestionnaireResponseItemComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific item from Questionnaire", formalDefinition="The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource." )
        protected StringType linkId;

        /**
         * A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.
         */
        @Child(name = "definition", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ElementDefinition - details for the item", formalDefinition="A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item." )
        protected UriType definition;

        /**
         * Text that is displayed above the contents of the group or as the text of the question being answered.
         */
        @Child(name = "text", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name for group or question text", formalDefinition="Text that is displayed above the contents of the group or as the text of the question being answered." )
        protected StringType text;

        /**
         * The respondent's answer(s) to the question.
         */
        @Child(name = "answer", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The response(s) to the question", formalDefinition="The respondent's answer(s) to the question." )
        protected List<QuestionnaireResponseItemAnswerComponent> answer;

        /**
         * Sub-questions, sub-groups or display items nested beneath a group.
         */
        @Child(name = "item", type = {QuestionnaireResponseItemComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Child items of group item", formalDefinition="Sub-questions, sub-groups or display items nested beneath a group." )
        protected List<QuestionnaireResponseItemComponent> item;

        private static final long serialVersionUID = -1395483402L;

    /**
     * Constructor
     */
      public QuestionnaireResponseItemComponent() {
        super();
      }

    /**
     * Constructor
     */
      public QuestionnaireResponseItemComponent(String linkId) {
        super();
        this.setLinkId(linkId);
      }

        /**
         * @return {@link #linkId} (The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireResponseItemComponent.linkId");
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
         * @param value {@link #linkId} (The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public QuestionnaireResponseItemComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.
         */
        public QuestionnaireResponseItemComponent setLinkId(String value) { 
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public UriType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireResponseItemComponent.definition");
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
         * @param value {@link #definition} (A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public QuestionnaireResponseItemComponent setDefinitionElement(UriType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.
         */
        public QuestionnaireResponseItemComponent setDefinition(String value) { 
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
         * @return {@link #text} (Text that is displayed above the contents of the group or as the text of the question being answered.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public StringType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create QuestionnaireResponseItemComponent.text");
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
         * @param value {@link #text} (Text that is displayed above the contents of the group or as the text of the question being answered.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public QuestionnaireResponseItemComponent setTextElement(StringType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return Text that is displayed above the contents of the group or as the text of the question being answered.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value Text that is displayed above the contents of the group or as the text of the question being answered.
         */
        public QuestionnaireResponseItemComponent setText(String value) { 
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
         * @return {@link #answer} (The respondent's answer(s) to the question.)
         */
        public List<QuestionnaireResponseItemAnswerComponent> getAnswer() { 
          if (this.answer == null)
            this.answer = new ArrayList<QuestionnaireResponseItemAnswerComponent>();
          return this.answer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireResponseItemComponent setAnswer(List<QuestionnaireResponseItemAnswerComponent> theAnswer) { 
          this.answer = theAnswer;
          return this;
        }

        public boolean hasAnswer() { 
          if (this.answer == null)
            return false;
          for (QuestionnaireResponseItemAnswerComponent item : this.answer)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireResponseItemAnswerComponent addAnswer() { //3
          QuestionnaireResponseItemAnswerComponent t = new QuestionnaireResponseItemAnswerComponent();
          if (this.answer == null)
            this.answer = new ArrayList<QuestionnaireResponseItemAnswerComponent>();
          this.answer.add(t);
          return t;
        }

        public QuestionnaireResponseItemComponent addAnswer(QuestionnaireResponseItemAnswerComponent t) { //3
          if (t == null)
            return this;
          if (this.answer == null)
            this.answer = new ArrayList<QuestionnaireResponseItemAnswerComponent>();
          this.answer.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #answer}, creating it if it does not already exist {3}
         */
        public QuestionnaireResponseItemAnswerComponent getAnswerFirstRep() { 
          if (getAnswer().isEmpty()) {
            addAnswer();
          }
          return getAnswer().get(0);
        }

        /**
         * @return {@link #item} (Sub-questions, sub-groups or display items nested beneath a group.)
         */
        public List<QuestionnaireResponseItemComponent> getItem() { 
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireResponseItemComponent>();
          return this.item;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireResponseItemComponent setItem(List<QuestionnaireResponseItemComponent> theItem) { 
          this.item = theItem;
          return this;
        }

        public boolean hasItem() { 
          if (this.item == null)
            return false;
          for (QuestionnaireResponseItemComponent item : this.item)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireResponseItemComponent addItem() { //3
          QuestionnaireResponseItemComponent t = new QuestionnaireResponseItemComponent();
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireResponseItemComponent>();
          this.item.add(t);
          return t;
        }

        public QuestionnaireResponseItemComponent addItem(QuestionnaireResponseItemComponent t) { //3
          if (t == null)
            return this;
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireResponseItemComponent>();
          this.item.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist {3}
         */
        public QuestionnaireResponseItemComponent getItemFirstRep() { 
          if (getItem().isEmpty()) {
            addItem();
          }
          return getItem().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.", 0, 1, linkId));
          children.add(new Property("definition", "uri", "A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.", 0, 1, definition));
          children.add(new Property("text", "string", "Text that is displayed above the contents of the group or as the text of the question being answered.", 0, 1, text));
          children.add(new Property("answer", "", "The respondent's answer(s) to the question.", 0, java.lang.Integer.MAX_VALUE, answer));
          children.add(new Property("item", "@QuestionnaireResponse.item", "Sub-questions, sub-groups or display items nested beneath a group.", 0, java.lang.Integer.MAX_VALUE, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse resource.", 0, 1, linkId);
          case -1014418093: /*definition*/  return new Property("definition", "uri", "A reference to an [ElementDefinition](elementdefinition.html) that provides the details for the item.", 0, 1, definition);
          case 3556653: /*text*/  return new Property("text", "string", "Text that is displayed above the contents of the group or as the text of the question being answered.", 0, 1, text);
          case -1412808770: /*answer*/  return new Property("answer", "", "The respondent's answer(s) to the question.", 0, java.lang.Integer.MAX_VALUE, answer);
          case 3242771: /*item*/  return new Property("item", "@QuestionnaireResponse.item", "Sub-questions, sub-groups or display items nested beneath a group.", 0, java.lang.Integer.MAX_VALUE, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // UriType
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // StringType
        case -1412808770: /*answer*/ return this.answer == null ? new Base[0] : this.answer.toArray(new Base[this.answer.size()]); // QuestionnaireResponseItemAnswerComponent
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // QuestionnaireResponseItemComponent
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
        case 3556653: // text
          this.text = TypeConvertor.castToString(value); // StringType
          return value;
        case -1412808770: // answer
          this.getAnswer().add((QuestionnaireResponseItemAnswerComponent) value); // QuestionnaireResponseItemAnswerComponent
          return value;
        case 3242771: // item
          this.getItem().add((QuestionnaireResponseItemComponent) value); // QuestionnaireResponseItemComponent
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
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("answer")) {
          this.getAnswer().add((QuestionnaireResponseItemAnswerComponent) value);
        } else if (name.equals("item")) {
          this.getItem().add((QuestionnaireResponseItemComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case -1014418093:  return getDefinitionElement();
        case 3556653:  return getTextElement();
        case -1412808770:  return addAnswer(); 
        case 3242771:  return addItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"uri"};
        case 3556653: /*text*/ return new String[] {"string"};
        case -1412808770: /*answer*/ return new String[] {};
        case 3242771: /*item*/ return new String[] {"@QuestionnaireResponse.item"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a primitive type QuestionnaireResponse.item.linkId");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a primitive type QuestionnaireResponse.item.definition");
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a primitive type QuestionnaireResponse.item.text");
        }
        else if (name.equals("answer")) {
          return addAnswer();
        }
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

      public QuestionnaireResponseItemComponent copy() {
        QuestionnaireResponseItemComponent dst = new QuestionnaireResponseItemComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireResponseItemComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.text = text == null ? null : text.copy();
        if (answer != null) {
          dst.answer = new ArrayList<QuestionnaireResponseItemAnswerComponent>();
          for (QuestionnaireResponseItemAnswerComponent i : answer)
            dst.answer.add(i.copy());
        };
        if (item != null) {
          dst.item = new ArrayList<QuestionnaireResponseItemComponent>();
          for (QuestionnaireResponseItemComponent i : item)
            dst.item.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireResponseItemComponent))
          return false;
        QuestionnaireResponseItemComponent o = (QuestionnaireResponseItemComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(definition, o.definition, true) && compareDeep(text, o.text, true)
           && compareDeep(answer, o.answer, true) && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireResponseItemComponent))
          return false;
        QuestionnaireResponseItemComponent o = (QuestionnaireResponseItemComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(definition, o.definition, true) && compareValues(text, o.text, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, definition, text
          , answer, item);
      }

  public String fhirType() {
    return "QuestionnaireResponse.item";

  }

  }

    @Block()
    public static class QuestionnaireResponseItemAnswerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The answer (or one of the answers) provided by the respondent to the question.
         */
        @Child(name = "value", type = {BooleanType.class, DecimalType.class, IntegerType.class, DateType.class, DateTimeType.class, TimeType.class, StringType.class, UriType.class, Attachment.class, Coding.class, Quantity.class, Reference.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Single-valued answer to the question", formalDefinition="The answer (or one of the answers) provided by the respondent to the question." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-answers")
        protected DataType value;

        /**
         * Nested groups and/or questions found within this particular answer.
         */
        @Child(name = "item", type = {QuestionnaireResponseItemComponent.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Child items of question", formalDefinition="Nested groups and/or questions found within this particular answer." )
        protected List<QuestionnaireResponseItemComponent> item;

        private static final long serialVersionUID = 1790747618L;

    /**
     * Constructor
     */
      public QuestionnaireResponseItemAnswerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public QuestionnaireResponseItemAnswerComponent(DataType value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @return {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
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
         * @param value {@link #value} (The answer (or one of the answers) provided by the respondent to the question.)
         */
        public QuestionnaireResponseItemAnswerComponent setValue(DataType value) { 
          if (value != null && !(value instanceof BooleanType || value instanceof DecimalType || value instanceof IntegerType || value instanceof DateType || value instanceof DateTimeType || value instanceof TimeType || value instanceof StringType || value instanceof UriType || value instanceof Attachment || value instanceof Coding || value instanceof Quantity || value instanceof Reference))
            throw new FHIRException("Not the right type for QuestionnaireResponse.item.answer.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #item} (Nested groups and/or questions found within this particular answer.)
         */
        public List<QuestionnaireResponseItemComponent> getItem() { 
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireResponseItemComponent>();
          return this.item;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public QuestionnaireResponseItemAnswerComponent setItem(List<QuestionnaireResponseItemComponent> theItem) { 
          this.item = theItem;
          return this;
        }

        public boolean hasItem() { 
          if (this.item == null)
            return false;
          for (QuestionnaireResponseItemComponent item : this.item)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public QuestionnaireResponseItemComponent addItem() { //3
          QuestionnaireResponseItemComponent t = new QuestionnaireResponseItemComponent();
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireResponseItemComponent>();
          this.item.add(t);
          return t;
        }

        public QuestionnaireResponseItemAnswerComponent addItem(QuestionnaireResponseItemComponent t) { //3
          if (t == null)
            return this;
          if (this.item == null)
            this.item = new ArrayList<QuestionnaireResponseItemComponent>();
          this.item.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist {3}
         */
        public QuestionnaireResponseItemComponent getItemFirstRep() { 
          if (getItem().isEmpty()) {
            addItem();
          }
          return getItem().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("value[x]", "boolean|decimal|integer|date|dateTime|time|string|uri|Attachment|Coding|Quantity|Reference(Any)", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value));
          children.add(new Property("item", "@QuestionnaireResponse.item", "Nested groups and/or questions found within this particular answer.", 0, java.lang.Integer.MAX_VALUE, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1410166417: /*value[x]*/  return new Property("value[x]", "boolean|decimal|integer|date|dateTime|time|string|uri|Attachment|Coding|Quantity|Reference(Any)", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "boolean|decimal|integer|date|dateTime|time|string|uri|Attachment|Coding|Quantity|Reference(Any)", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -766192449: /*valueDate*/  return new Property("value[x]", "date", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference(Any)", "The answer (or one of the answers) provided by the respondent to the question.", 0, 1, value);
          case 3242771: /*item*/  return new Property("item", "@QuestionnaireResponse.item", "Nested groups and/or questions found within this particular answer.", 0, java.lang.Integer.MAX_VALUE, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // QuestionnaireResponseItemComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case 3242771: // item
          this.getItem().add((QuestionnaireResponseItemComponent) value); // QuestionnaireResponseItemComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("item")) {
          this.getItem().add((QuestionnaireResponseItemComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case 3242771:  return addItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"boolean", "decimal", "integer", "date", "dateTime", "time", "string", "uri", "Attachment", "Coding", "Quantity", "Reference"};
        case 3242771: /*item*/ return new String[] {"@QuestionnaireResponse.item"};
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
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

      public QuestionnaireResponseItemAnswerComponent copy() {
        QuestionnaireResponseItemAnswerComponent dst = new QuestionnaireResponseItemAnswerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireResponseItemAnswerComponent dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        if (item != null) {
          dst.item = new ArrayList<QuestionnaireResponseItemComponent>();
          for (QuestionnaireResponseItemComponent i : item)
            dst.item.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireResponseItemAnswerComponent))
          return false;
        QuestionnaireResponseItemAnswerComponent o = (QuestionnaireResponseItemAnswerComponent) other_;
        return compareDeep(value, o.value, true) && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireResponseItemAnswerComponent))
          return false;
        QuestionnaireResponseItemAnswerComponent o = (QuestionnaireResponseItemAnswerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, item);
      }

  public String fhirType() {
    return "QuestionnaireResponse.item.answer";

  }

  }

    /**
     * Business identifiers assigned to this questionnaire response by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this set of answers", formalDefinition="Business identifiers assigned to this questionnaire response by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this questionnaire response.  For example, a ServiceRequest seeking an intake assessment or a decision support recommendation to assess for post-partum depression.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ServiceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Request fulfilled by this QuestionnaireResponse", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this questionnaire response.  For example, a ServiceRequest seeking an intake assessment or a decision support recommendation to assess for post-partum depression." )
    protected List<Reference> basedOn;

    /**
     * A procedure or observation that this questionnaire was performed as part of the execution of.  For example, the surgery a checklist was executed as part of.
     */
    @Child(name = "partOf", type = {Observation.class, Procedure.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A procedure or observation that this questionnaire was performed as part of the execution of.  For example, the surgery a checklist was executed as part of." )
    protected List<Reference> partOf;

    /**
     * The Questionnaire that defines and organizes the questions for which answers are being provided.
     */
    @Child(name = "questionnaire", type = {CanonicalType.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical URL of Questionnaire being answered", formalDefinition="The Questionnaire that defines and organizes the questions for which answers are being provided." )
    protected CanonicalType questionnaire;

    /**
     * The current state of the questionnaire response.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="in-progress | completed | amended | entered-in-error | stopped", formalDefinition="The current state of the questionnaire response." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/questionnaire-answers-status")
    protected Enumeration<QuestionnaireResponseStatus> status;

    /**
     * The subject of the questionnaire response.  This could be a patient, organization, practitioner, device, etc.  This is who/what the answers apply to, but is not necessarily the source of information.
     */
    @Child(name = "subject", type = {Reference.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The subject of the questions", formalDefinition="The subject of the questionnaire response.  This could be a patient, organization, practitioner, device, etc.  This is who/what the answers apply to, but is not necessarily the source of information." )
    protected Reference subject;

    /**
     * The Encounter during which this questionnaire response was created or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter the questionnaire response is part of", formalDefinition="The Encounter during which this questionnaire response was created or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.
     */
    @Child(name = "authored", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date the answers were gathered", formalDefinition="The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status." )
    protected DateTimeType authored;

    /**
     * The individual or device that received the answers to the questions in the QuestionnaireResponse and recorded them in the system.
     */
    @Child(name = "author", type = {Device.class, Practitioner.class, PractitionerRole.class, Patient.class, RelatedPerson.class, Organization.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The individual or device that received and recorded the answers", formalDefinition="The individual or device that received the answers to the questions in the QuestionnaireResponse and recorded them in the system." )
    protected Reference author;

    /**
     * The individual or device that answered the questions about the subject.
     */
    @Child(name = "source", type = {Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The individual or device that answered the questions", formalDefinition="The individual or device that answered the questions about the subject." )
    protected Reference source;

    /**
     * A group or question item from the original questionnaire for which answers are provided.
     */
    @Child(name = "item", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Groups and questions", formalDefinition="A group or question item from the original questionnaire for which answers are provided." )
    protected List<QuestionnaireResponseItemComponent> item;

    private static final long serialVersionUID = 1660467089L;

  /**
   * Constructor
   */
    public QuestionnaireResponse() {
      super();
    }

  /**
   * Constructor
   */
    public QuestionnaireResponse(String questionnaire, QuestionnaireResponseStatus status) {
      super();
      this.setQuestionnaire(questionnaire);
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this questionnaire response by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public QuestionnaireResponse setIdentifier(List<Identifier> theIdentifier) { 
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

    public QuestionnaireResponse addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this questionnaire response.  For example, a ServiceRequest seeking an intake assessment or a decision support recommendation to assess for post-partum depression.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public QuestionnaireResponse setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public QuestionnaireResponse addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #partOf} (A procedure or observation that this questionnaire was performed as part of the execution of.  For example, the surgery a checklist was executed as part of.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public QuestionnaireResponse setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public QuestionnaireResponse addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
    }

    /**
     * @return {@link #questionnaire} (The Questionnaire that defines and organizes the questions for which answers are being provided.). This is the underlying object with id, value and extensions. The accessor "getQuestionnaire" gives direct access to the value
     */
    public CanonicalType getQuestionnaireElement() { 
      if (this.questionnaire == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.questionnaire");
        else if (Configuration.doAutoCreate())
          this.questionnaire = new CanonicalType(); // bb
      return this.questionnaire;
    }

    public boolean hasQuestionnaireElement() { 
      return this.questionnaire != null && !this.questionnaire.isEmpty();
    }

    public boolean hasQuestionnaire() { 
      return this.questionnaire != null && !this.questionnaire.isEmpty();
    }

    /**
     * @param value {@link #questionnaire} (The Questionnaire that defines and organizes the questions for which answers are being provided.). This is the underlying object with id, value and extensions. The accessor "getQuestionnaire" gives direct access to the value
     */
    public QuestionnaireResponse setQuestionnaireElement(CanonicalType value) { 
      this.questionnaire = value;
      return this;
    }

    /**
     * @return The Questionnaire that defines and organizes the questions for which answers are being provided.
     */
    public String getQuestionnaire() { 
      return this.questionnaire == null ? null : this.questionnaire.getValue();
    }

    /**
     * @param value The Questionnaire that defines and organizes the questions for which answers are being provided.
     */
    public QuestionnaireResponse setQuestionnaire(String value) { 
        if (this.questionnaire == null)
          this.questionnaire = new CanonicalType();
        this.questionnaire.setValue(value);
      return this;
    }

    /**
     * @return {@link #status} (The current state of the questionnaire response.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<QuestionnaireResponseStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<QuestionnaireResponseStatus>(new QuestionnaireResponseStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the questionnaire response.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public QuestionnaireResponse setStatusElement(Enumeration<QuestionnaireResponseStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the questionnaire response.
     */
    public QuestionnaireResponseStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the questionnaire response.
     */
    public QuestionnaireResponse setStatus(QuestionnaireResponseStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<QuestionnaireResponseStatus>(new QuestionnaireResponseStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #subject} (The subject of the questionnaire response.  This could be a patient, organization, practitioner, device, etc.  This is who/what the answers apply to, but is not necessarily the source of information.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The subject of the questionnaire response.  This could be a patient, organization, practitioner, device, etc.  This is who/what the answers apply to, but is not necessarily the source of information.)
     */
    public QuestionnaireResponse setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The Encounter during which this questionnaire response was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter during which this questionnaire response was created or to which the creation of this record is tightly associated.)
     */
    public QuestionnaireResponse setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #authored} (The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.). This is the underlying object with id, value and extensions. The accessor "getAuthored" gives direct access to the value
     */
    public DateTimeType getAuthoredElement() { 
      if (this.authored == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.authored");
        else if (Configuration.doAutoCreate())
          this.authored = new DateTimeType(); // bb
      return this.authored;
    }

    public boolean hasAuthoredElement() { 
      return this.authored != null && !this.authored.isEmpty();
    }

    public boolean hasAuthored() { 
      return this.authored != null && !this.authored.isEmpty();
    }

    /**
     * @param value {@link #authored} (The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.). This is the underlying object with id, value and extensions. The accessor "getAuthored" gives direct access to the value
     */
    public QuestionnaireResponse setAuthoredElement(DateTimeType value) { 
      this.authored = value;
      return this;
    }

    /**
     * @return The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.
     */
    public Date getAuthored() { 
      return this.authored == null ? null : this.authored.getValue();
    }

    /**
     * @param value The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.
     */
    public QuestionnaireResponse setAuthored(Date value) { 
      if (value == null)
        this.authored = null;
      else {
        if (this.authored == null)
          this.authored = new DateTimeType();
        this.authored.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #author} (The individual or device that received the answers to the questions in the QuestionnaireResponse and recorded them in the system.)
     */
    public Reference getAuthor() { 
      if (this.author == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.author");
        else if (Configuration.doAutoCreate())
          this.author = new Reference(); // cc
      return this.author;
    }

    public boolean hasAuthor() { 
      return this.author != null && !this.author.isEmpty();
    }

    /**
     * @param value {@link #author} (The individual or device that received the answers to the questions in the QuestionnaireResponse and recorded them in the system.)
     */
    public QuestionnaireResponse setAuthor(Reference value) { 
      this.author = value;
      return this;
    }

    /**
     * @return {@link #source} (The individual or device that answered the questions about the subject.)
     */
    public Reference getSource() { 
      if (this.source == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create QuestionnaireResponse.source");
        else if (Configuration.doAutoCreate())
          this.source = new Reference(); // cc
      return this.source;
    }

    public boolean hasSource() { 
      return this.source != null && !this.source.isEmpty();
    }

    /**
     * @param value {@link #source} (The individual or device that answered the questions about the subject.)
     */
    public QuestionnaireResponse setSource(Reference value) { 
      this.source = value;
      return this;
    }

    /**
     * @return {@link #item} (A group or question item from the original questionnaire for which answers are provided.)
     */
    public List<QuestionnaireResponseItemComponent> getItem() { 
      if (this.item == null)
        this.item = new ArrayList<QuestionnaireResponseItemComponent>();
      return this.item;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public QuestionnaireResponse setItem(List<QuestionnaireResponseItemComponent> theItem) { 
      this.item = theItem;
      return this;
    }

    public boolean hasItem() { 
      if (this.item == null)
        return false;
      for (QuestionnaireResponseItemComponent item : this.item)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public QuestionnaireResponseItemComponent addItem() { //3
      QuestionnaireResponseItemComponent t = new QuestionnaireResponseItemComponent();
      if (this.item == null)
        this.item = new ArrayList<QuestionnaireResponseItemComponent>();
      this.item.add(t);
      return t;
    }

    public QuestionnaireResponse addItem(QuestionnaireResponseItemComponent t) { //3
      if (t == null)
        return this;
      if (this.item == null)
        this.item = new ArrayList<QuestionnaireResponseItemComponent>();
      this.item.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist {3}
     */
    public QuestionnaireResponseItemComponent getItemFirstRep() { 
      if (getItem().isEmpty()) {
        addItem();
      }
      return getItem().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this questionnaire response by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this questionnaire response.  For example, a ServiceRequest seeking an intake assessment or a decision support recommendation to assess for post-partum depression.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(Observation|Procedure)", "A procedure or observation that this questionnaire was performed as part of the execution of.  For example, the surgery a checklist was executed as part of.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("questionnaire", "canonical(Questionnaire)", "The Questionnaire that defines and organizes the questions for which answers are being provided.", 0, 1, questionnaire));
        children.add(new Property("status", "code", "The current state of the questionnaire response.", 0, 1, status));
        children.add(new Property("subject", "Reference(Any)", "The subject of the questionnaire response.  This could be a patient, organization, practitioner, device, etc.  This is who/what the answers apply to, but is not necessarily the source of information.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter during which this questionnaire response was created or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("authored", "dateTime", "The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.", 0, 1, authored));
        children.add(new Property("author", "Reference(Device|Practitioner|PractitionerRole|Patient|RelatedPerson|Organization)", "The individual or device that received the answers to the questions in the QuestionnaireResponse and recorded them in the system.", 0, 1, author));
        children.add(new Property("source", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The individual or device that answered the questions about the subject.", 0, 1, source));
        children.add(new Property("item", "", "A group or question item from the original questionnaire for which answers are provided.", 0, java.lang.Integer.MAX_VALUE, item));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this questionnaire response by the performer and/or other systems.  These identifiers remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this questionnaire response.  For example, a ServiceRequest seeking an intake assessment or a decision support recommendation to assess for post-partum depression.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Observation|Procedure)", "A procedure or observation that this questionnaire was performed as part of the execution of.  For example, the surgery a checklist was executed as part of.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -1017049693: /*questionnaire*/  return new Property("questionnaire", "canonical(Questionnaire)", "The Questionnaire that defines and organizes the questions for which answers are being provided.", 0, 1, questionnaire);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the questionnaire response.", 0, 1, status);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Any)", "The subject of the questionnaire response.  This could be a patient, organization, practitioner, device, etc.  This is who/what the answers apply to, but is not necessarily the source of information.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter during which this questionnaire response was created or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case 1433073514: /*authored*/  return new Property("authored", "dateTime", "The date and/or time that this questionnaire response was last modified by the user - e.g. changing answers or revising status.", 0, 1, authored);
        case -1406328437: /*author*/  return new Property("author", "Reference(Device|Practitioner|PractitionerRole|Patient|RelatedPerson|Organization)", "The individual or device that received the answers to the questions in the QuestionnaireResponse and recorded them in the system.", 0, 1, author);
        case -896505829: /*source*/  return new Property("source", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The individual or device that answered the questions about the subject.", 0, 1, source);
        case 3242771: /*item*/  return new Property("item", "", "A group or question item from the original questionnaire for which answers are provided.", 0, java.lang.Integer.MAX_VALUE, item);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -1017049693: /*questionnaire*/ return this.questionnaire == null ? new Base[0] : new Base[] {this.questionnaire}; // CanonicalType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<QuestionnaireResponseStatus>
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1433073514: /*authored*/ return this.authored == null ? new Base[0] : new Base[] {this.authored}; // DateTimeType
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // Reference
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // QuestionnaireResponseItemComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1017049693: // questionnaire
          this.questionnaire = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -892481550: // status
          value = new QuestionnaireResponseStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<QuestionnaireResponseStatus>
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1433073514: // authored
          this.authored = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3242771: // item
          this.getItem().add((QuestionnaireResponseItemComponent) value); // QuestionnaireResponseItemComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("questionnaire")) {
          this.questionnaire = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("status")) {
          value = new QuestionnaireResponseStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<QuestionnaireResponseStatus>
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("authored")) {
          this.authored = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("item")) {
          this.getItem().add((QuestionnaireResponseItemComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -1017049693:  return getQuestionnaireElement();
        case -892481550:  return getStatusElement();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case 1433073514:  return getAuthoredElement();
        case -1406328437:  return getAuthor();
        case -896505829:  return getSource();
        case 3242771:  return addItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -1017049693: /*questionnaire*/ return new String[] {"canonical"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1433073514: /*authored*/ return new String[] {"dateTime"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        case 3242771: /*item*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("questionnaire")) {
          throw new FHIRException("Cannot call addChild on a primitive type QuestionnaireResponse.questionnaire");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type QuestionnaireResponse.status");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("authored")) {
          throw new FHIRException("Cannot call addChild on a primitive type QuestionnaireResponse.authored");
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else if (name.equals("source")) {
          this.source = new Reference();
          return this.source;
        }
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "QuestionnaireResponse";

  }

      public QuestionnaireResponse copy() {
        QuestionnaireResponse dst = new QuestionnaireResponse();
        copyValues(dst);
        return dst;
      }

      public void copyValues(QuestionnaireResponse dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.questionnaire = questionnaire == null ? null : questionnaire.copy();
        dst.status = status == null ? null : status.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.authored = authored == null ? null : authored.copy();
        dst.author = author == null ? null : author.copy();
        dst.source = source == null ? null : source.copy();
        if (item != null) {
          dst.item = new ArrayList<QuestionnaireResponseItemComponent>();
          for (QuestionnaireResponseItemComponent i : item)
            dst.item.add(i.copy());
        };
      }

      protected QuestionnaireResponse typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof QuestionnaireResponse))
          return false;
        QuestionnaireResponse o = (QuestionnaireResponse) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(questionnaire, o.questionnaire, true) && compareDeep(status, o.status, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(authored, o.authored, true) && compareDeep(author, o.author, true)
           && compareDeep(source, o.source, true) && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof QuestionnaireResponse))
          return false;
        QuestionnaireResponse o = (QuestionnaireResponse) other_;
        return compareValues(questionnaire, o.questionnaire, true) && compareValues(status, o.status, true)
           && compareValues(authored, o.authored, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , questionnaire, status, subject, encounter, authored, author, source, item
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.QuestionnaireResponse;
   }

 /**
   * Search parameter: <b>author</b>
   * <p>
   * Description: <b>The author of the questionnaire response</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.author</b><br>
   * </p>
   */
  @SearchParamDefinition(name="author", path="QuestionnaireResponse.author", description="The author of the questionnaire response", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_AUTHOR = "author";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>author</b>
   * <p>
   * Description: <b>The author of the questionnaire response</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.author</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AUTHOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AUTHOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:author</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AUTHOR = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:author").toLocked();

 /**
   * Search parameter: <b>authored</b>
   * <p>
   * Description: <b>When the questionnaire response was last changed</b><br>
   * Type: <b>date</b><br>
   * Path: <b>QuestionnaireResponse.authored</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authored", path="QuestionnaireResponse.authored", description="When the questionnaire response was last changed", type="date" )
  public static final String SP_AUTHORED = "authored";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authored</b>
   * <p>
   * Description: <b>When the questionnaire response was last changed</b><br>
   * Type: <b>date</b><br>
   * Path: <b>QuestionnaireResponse.authored</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_AUTHORED);

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Plan/proposal/order fulfilled by this questionnaire response</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="QuestionnaireResponse.basedOn", description="Plan/proposal/order fulfilled by this questionnaire response", type="reference", target={CarePlan.class, ServiceRequest.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Plan/proposal/order fulfilled by this questionnaire response</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:based-on").toLocked();

 /**
   * Search parameter: <b>item-subject</b>
   * <p>
   * Description: <b>Allows searching for QuestionnaireResponses by item value where the item has isSubject=true</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.item.where(extension('http://hl7.org/fhir/StructureDefinition/questionnaireresponse-isSubject').exists()).answer.value.ofType(Reference)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="item-subject", path="QuestionnaireResponse.item.where(extension('http://hl7.org/fhir/StructureDefinition/questionnaireresponse-isSubject').exists()).answer.value.ofType(Reference)", description="Allows searching for QuestionnaireResponses by item value where the item has isSubject=true", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_ITEM_SUBJECT = "item-subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>item-subject</b>
   * <p>
   * Description: <b>Allows searching for QuestionnaireResponses by item value where the item has isSubject=true</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.item.where(extension('http://hl7.org/fhir/StructureDefinition/questionnaireresponse-isSubject').exists()).answer.value.ofType(Reference)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ITEM_SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ITEM_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:item-subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ITEM_SUBJECT = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:item-subject").toLocked();

 /**
   * Search parameter: <b>part-of</b>
   * <p>
   * Description: <b>Procedure or observation this questionnaire response was performed as a part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.partOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-of", path="QuestionnaireResponse.partOf", description="Procedure or observation this questionnaire response was performed as a part of", type="reference", target={Observation.class, Procedure.class } )
  public static final String SP_PART_OF = "part-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-of</b>
   * <p>
   * Description: <b>Procedure or observation this questionnaire response was performed as a part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.partOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PART_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PART_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:part-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PART_OF = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:part-of").toLocked();

 /**
   * Search parameter: <b>questionnaire</b>
   * <p>
   * Description: <b>The questionnaire the answers are provided for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.questionnaire</b><br>
   * </p>
   */
  @SearchParamDefinition(name="questionnaire", path="QuestionnaireResponse.questionnaire", description="The questionnaire the answers are provided for", type="reference", target={Questionnaire.class } )
  public static final String SP_QUESTIONNAIRE = "questionnaire";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>questionnaire</b>
   * <p>
   * Description: <b>The questionnaire the answers are provided for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.questionnaire</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam QUESTIONNAIRE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_QUESTIONNAIRE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:questionnaire</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_QUESTIONNAIRE = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:questionnaire").toLocked();

 /**
   * Search parameter: <b>source</b>
   * <p>
   * Description: <b>The individual providing the information reflected in the questionnaire respose</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.source</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source", path="QuestionnaireResponse.source", description="The individual providing the information reflected in the questionnaire respose", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SOURCE = "source";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source</b>
   * <p>
   * Description: <b>The individual providing the information reflected in the questionnaire respose</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.source</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:source</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:source").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the questionnaire response</b><br>
   * Type: <b>token</b><br>
   * Path: <b>QuestionnaireResponse.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="QuestionnaireResponse.status", description="The status of the questionnaire response", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the questionnaire response</b><br>
   * Type: <b>token</b><br>
   * Path: <b>QuestionnaireResponse.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject of the questionnaire response</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="QuestionnaireResponse.subject", description="The subject of the questionnaire response", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject of the questionnaire response</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>QuestionnaireResponse.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:subject").toLocked();

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent\r\n* [CarePlan](careplan.html): The Encounter during which this CarePlan was created\r\n* [ChargeItem](chargeitem.html): Encounter associated with event\r\n* [Claim](claim.html): Encounters associated with a billed line item\r\n* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created\r\n* [Communication](communication.html): The Encounter during which this Communication was created\r\n* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created\r\n* [Composition](composition.html): Context of the Composition\r\n* [Condition](condition.html): The Encounter during which this Condition was created\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values\r\n* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [ImagingStudy](imagingstudy.html): The context of the study\r\n* [List](list.html): Context in which list created\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [Provenance](provenance.html): Encounter related to the Provenance\r\n* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response\r\n* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [Task](task.html): Search by encounter\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:encounter").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>QuestionnaireResponse:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("QuestionnaireResponse:patient").toLocked();


}

