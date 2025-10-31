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
 * A standard format for test cases used throughout the FHIR ecosystem
 */
@DatatypeDef(name="TestCases")
public class TestCases extends Resource implements ICompositeType {

    @Block()
    public static class TestCasesModeComponent extends LogicalBase {
        /**
         * The code by which the mode is identified when passed to runner
         */
        @Child(name = "code", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The code that identifies the mode", formalDefinition="The code by which the mode is identified when passed to runner" )
        protected StringType code;

        /**
         * Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of what this mode exists / why it was defined", formalDefinition="Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode" )
        protected StringType description;

        private static final long serialVersionUID = 1295492279L;

    /**
     * Constructor
     */
      public TestCasesModeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestCasesModeComponent(String code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (The code by which the mode is identified when passed to runner). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public StringType getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesModeComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new StringType(); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The code by which the mode is identified when passed to runner). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public TestCasesModeComponent setCodeElement(StringType value) { 
          this.code = value;
          return this;
        }

        /**
         * @return The code by which the mode is identified when passed to runner
         */
        public String getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value The code by which the mode is identified when passed to runner
         */
        public TestCasesModeComponent setCode(String value) { 
            if (this.code == null)
              this.code = new StringType();
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesModeComponent.description");
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
         * @param value {@link #description} (Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestCasesModeComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode
         */
        public TestCasesModeComponent setDescription(String value) { 
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
          children.add(new Property("code", "string", "The code by which the mode is identified when passed to runner", 0, 1, code));
          children.add(new Property("description", "string", "Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "string", "The code by which the mode is identified when passed to runner", 0, 1, code);
          case -1724546052: /*description*/  return new Property("description", "string", "Description of what this mode does / why it was defined. This should explain to a tester when they should use the mode", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.mode.code");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.mode.description");
        }
        else
          return super.addChild(name);
      }

      public TestCasesModeComponent copy() {
        TestCasesModeComponent dst = new TestCasesModeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCasesModeComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCasesModeComponent))
          return false;
        TestCasesModeComponent o = (TestCasesModeComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCasesModeComponent))
          return false;
        TestCasesModeComponent o = (TestCasesModeComponent) other_;
        return compareValues(code, o.code, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, description);
      }

  public String fhirType() {
    return "TestCases.mode";

  }

  }

    @Block()
    public static class TestCasesSuiteComponent extends LogicalBase {
        /**
         * The name by which this suite is known by in the test system. The name must be unique in the amongst the suites
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The name of this suite - unique in the TestCases resource", formalDefinition="The name by which this suite is known by in the test system. The name must be unique in the amongst the suites" )
        protected StringType name;

        /**
         * Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of what this suite does / why it was defined", formalDefinition="Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run" )
        protected StringType description;

        /**
         * If this mode is not passed to the runner, then this suite will not be run
         */
        @Child(name = "mode", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="mode required to run this suite", formalDefinition="If this mode is not passed to the runner, then this suite will not be run" )
        protected CodeType mode;

        /**
         * The resources used in the tests in this suite. How exactly they are used depends on the definition of the runner
         */
        @Child(name = "resource", type = {Base.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Resources used in the tests in this suite", formalDefinition="The resources used in the tests in this suite. How exactly they are used depends on the definition of the runner" )
        protected List<TestCasesSuiteResourceComponent> resourceList;

        /**
         * A parameter passed to the runner when executing tests. Which parameters are valid, and how exactly the parameter is used are used depends on the definition of the runner
         */
        @Child(name = "parameter", type = {Base.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Parameter passed to the runner", formalDefinition="A parameter passed to the runner when executing tests. Which parameters are valid, and how exactly the parameter is used are used depends on the definition of the runner" )
        protected List<TestCasesSuiteParameterComponent> parameterList;

        /**
         * An actual test in the test suite
         */
        @Child(name = "test", type = {Base.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A test in the test suite", formalDefinition="An actual test in the test suite" )
        protected List<TestCasesSuiteTestComponent> testList;

        private static final long serialVersionUID = 622063903L;

    /**
     * Constructor
     */
      public TestCasesSuiteComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestCasesSuiteComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (The name by which this suite is known by in the test system. The name must be unique in the amongst the suites). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteComponent.name");
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
         * @param value {@link #name} (The name by which this suite is known by in the test system. The name must be unique in the amongst the suites). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TestCasesSuiteComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name by which this suite is known by in the test system. The name must be unique in the amongst the suites
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name by which this suite is known by in the test system. The name must be unique in the amongst the suites
         */
        public TestCasesSuiteComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteComponent.description");
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
         * @param value {@link #description} (Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestCasesSuiteComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run
         */
        public TestCasesSuiteComponent setDescription(String value) { 
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
         * @return {@link #mode} (If this mode is not passed to the runner, then this suite will not be run). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CodeType getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new CodeType(); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (If this mode is not passed to the runner, then this suite will not be run). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public TestCasesSuiteComponent setModeElement(CodeType value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return If this mode is not passed to the runner, then this suite will not be run
         */
        public String getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value If this mode is not passed to the runner, then this suite will not be run
         */
        public TestCasesSuiteComponent setMode(String value) { 
          if (Utilities.noString(value))
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new CodeType();
            this.mode.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resource} (The resources used in the tests in this suite. How exactly they are used depends on the definition of the runner)
         */
        public List<TestCasesSuiteResourceComponent> getResourceList() { 
          if (this.resourceList == null)
            this.resourceList = new ArrayList<TestCasesSuiteResourceComponent>();
          return this.resourceList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestCasesSuiteComponent setResourceList(List<TestCasesSuiteResourceComponent> theResource) { 
          this.resourceList = theResource;
          return this;
        }

        public boolean hasResource() { 
          if (this.resourceList == null)
            return false;
          for (TestCasesSuiteResourceComponent item : this.resourceList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCasesSuiteComponent addResource(TestCasesSuiteResourceComponent t) { //3b
          if (t == null)
            return this;
          if (this.resourceList == null)
            this.resourceList = new ArrayList<TestCasesSuiteResourceComponent>();
          this.resourceList.add(t);
          return this;
        }

        /**
         * @return {@link #parameter} (A parameter passed to the runner when executing tests. Which parameters are valid, and how exactly the parameter is used are used depends on the definition of the runner)
         */
        public List<TestCasesSuiteParameterComponent> getParameterList() { 
          if (this.parameterList == null)
            this.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          return this.parameterList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestCasesSuiteComponent setParameterList(List<TestCasesSuiteParameterComponent> theParameter) { 
          this.parameterList = theParameter;
          return this;
        }

        public boolean hasParameter() { 
          if (this.parameterList == null)
            return false;
          for (TestCasesSuiteParameterComponent item : this.parameterList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCasesSuiteComponent addParameter(TestCasesSuiteParameterComponent t) { //3b
          if (t == null)
            return this;
          if (this.parameterList == null)
            this.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          this.parameterList.add(t);
          return this;
        }

        /**
         * @return {@link #test} (An actual test in the test suite)
         */
        public List<TestCasesSuiteTestComponent> getTestList() { 
          if (this.testList == null)
            this.testList = new ArrayList<TestCasesSuiteTestComponent>();
          return this.testList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestCasesSuiteComponent setTestList(List<TestCasesSuiteTestComponent> theTest) { 
          this.testList = theTest;
          return this;
        }

        public boolean hasTest() { 
          if (this.testList == null)
            return false;
          for (TestCasesSuiteTestComponent item : this.testList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCasesSuiteComponent addTest(TestCasesSuiteTestComponent t) { //3b
          if (t == null)
            return this;
          if (this.testList == null)
            this.testList = new ArrayList<TestCasesSuiteTestComponent>();
          this.testList.add(t);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name by which this suite is known by in the test system. The name must be unique in the amongst the suites", 0, 1, name));
          children.add(new Property("description", "string", "Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run", 0, 1, description));
          children.add(new Property("mode", "code", "If this mode is not passed to the runner, then this suite will not be run", 0, 1, mode));
          children.add(new Property("resource", "Base", "The resources used in the tests in this suite. How exactly they are used depends on the definition of the runner", 0, java.lang.Integer.MAX_VALUE, resourceList));
          children.add(new Property("parameter", "Base", "A parameter passed to the runner when executing tests. Which parameters are valid, and how exactly the parameter is used are used depends on the definition of the runner", 0, java.lang.Integer.MAX_VALUE, parameterList));
          children.add(new Property("test", "Base", "An actual test in the test suite", 0, java.lang.Integer.MAX_VALUE, testList));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name by which this suite is known by in the test system. The name must be unique in the amongst the suites", 0, 1, name);
          case -1724546052: /*description*/  return new Property("description", "string", "Description of what this suite does / why it was defined. This should explain to a tester what they should know when deciding which tests to run", 0, 1, description);
          case 3357091: /*mode*/  return new Property("mode", "code", "If this mode is not passed to the runner, then this suite will not be run", 0, 1, mode);
          case -341064690: /*resource*/  return new Property("resource", "Base", "The resources used in the tests in this suite. How exactly they are used depends on the definition of the runner", 0, java.lang.Integer.MAX_VALUE, resourceList);
          case 1954460585: /*parameter*/  return new Property("parameter", "Base", "A parameter passed to the runner when executing tests. Which parameters are valid, and how exactly the parameter is used are used depends on the definition of the runner", 0, java.lang.Integer.MAX_VALUE, parameterList);
          case 3556498: /*test*/  return new Property("test", "Base", "An actual test in the test suite", 0, java.lang.Integer.MAX_VALUE, testList);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // CodeType
        case -341064690: /*resource*/ return this.resourceList == null ? new Base[0] : this.resourceList.toArray(new Base[this.resourceList.size()]); // TestCasesSuiteResourceComponent
        case 1954460585: /*parameter*/ return this.parameterList == null ? new Base[0] : this.parameterList.toArray(new Base[this.parameterList.size()]); // TestCasesSuiteParameterComponent
        case 3556498: /*test*/ return this.testList == null ? new Base[0] : this.testList.toArray(new Base[this.testList.size()]); // TestCasesSuiteTestComponent
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
        case 3357091: // mode
          this.mode = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -341064690: // resource
          this.getResourceList().add((TestCasesSuiteResourceComponent) value); // TestCasesSuiteResourceComponent
          return value;
        case 1954460585: // parameter
          this.getParameterList().add((TestCasesSuiteParameterComponent) value); // TestCasesSuiteParameterComponent
          return value;
        case 3556498: // test
          this.getTestList().add((TestCasesSuiteTestComponent) value); // TestCasesSuiteTestComponent
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
        } else if (name.equals("mode")) {
          this.mode = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("resource")) {
          this.getResourceList().add((TestCasesSuiteResourceComponent) value); // TestCasesSuiteResourceComponent
        } else if (name.equals("parameter")) {
          this.getParameterList().add((TestCasesSuiteParameterComponent) value); // TestCasesSuiteParameterComponent
        } else if (name.equals("test")) {
          this.getTestList().add((TestCasesSuiteTestComponent) value); // TestCasesSuiteTestComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case 3357091:  return getModeElement();
        case -341064690: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'resource'");
        case 1954460585: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'parameter'");
        case 3556498: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'test'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3357091: /*mode*/ return new String[] {"code"};
        case -341064690: /*resource*/ return new String[] {"Base"};
        case 1954460585: /*parameter*/ return new String[] {"Base"};
        case 3556498: /*test*/ return new String[] {"Base"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.description");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.mode");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on an abstract type TestCases.suite.resource");
        }
        else if (name.equals("parameter")) {
          throw new FHIRException("Cannot call addChild on an abstract type TestCases.suite.parameter");
        }
        else if (name.equals("test")) {
          throw new FHIRException("Cannot call addChild on an abstract type TestCases.suite.test");
        }
        else
          return super.addChild(name);
      }

      public TestCasesSuiteComponent copy() {
        TestCasesSuiteComponent dst = new TestCasesSuiteComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCasesSuiteComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        dst.mode = mode == null ? null : mode.copy();
        if (resourceList != null) {
          dst.resourceList = new ArrayList<TestCasesSuiteResourceComponent>();
          for (TestCasesSuiteResourceComponent i : resourceList)
            dst.resourceList.add(i.copy());
        };
        if (parameterList != null) {
          dst.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          for (TestCasesSuiteParameterComponent i : parameterList)
            dst.parameterList.add(i.copy());
        };
        if (testList != null) {
          dst.testList = new ArrayList<TestCasesSuiteTestComponent>();
          for (TestCasesSuiteTestComponent i : testList)
            dst.testList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteComponent))
          return false;
        TestCasesSuiteComponent o = (TestCasesSuiteComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(description, o.description, true) && compareDeep(mode, o.mode, true)
           && compareDeep(resourceList, o.resourceList, true) && compareDeep(parameterList, o.parameterList, true)
           && compareDeep(testList, o.testList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteComponent))
          return false;
        TestCasesSuiteComponent o = (TestCasesSuiteComponent) other_;
        return compareValues(name, o.name, true) && compareValues(description, o.description, true) && compareValues(mode, o.mode, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, description, mode
          , resourceList, parameterList, testList);
      }

  public String fhirType() {
    return "TestCases.suite";

  }

  }

    @Block()
    public static class TestCasesSuiteResourceComponent extends LogicalBase {
        /**
         * A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A name for this resource (per runner definition)", formalDefinition="A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are" )
        protected StringType name;

        /**
         * A file containing a resource used in the tests
         */
        @Child(name = "file", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A file containing a resource used in the tests", formalDefinition="A file containing a resource used in the tests" )
        protected StringType file;

        /**
         * An inline resource used in the tests. How exactly it is used depends on the definition of the runner.
         */
        @Child(name = "resource", type = {Resource.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="An inline resource used in the tests", formalDefinition="An inline resource used in the tests. How exactly it is used depends on the definition of the runner." )
        protected Resource resource;

        /**
         * If this mode is not passed to the runner, then this resource will not be used
         */
        @Child(name = "mode", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A mode that must be true for this resource to be used", formalDefinition="If this mode is not passed to the runner, then this resource will not be used" )
        protected CodeType mode;

        private static final long serialVersionUID = 1036724891L;

    /**
     * Constructor
     */
      public TestCasesSuiteResourceComponent() {
        super();
      }

        /**
         * @return {@link #name} (A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteResourceComponent.name");
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
         * @param value {@link #name} (A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TestCasesSuiteResourceComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are
         */
        public TestCasesSuiteResourceComponent setName(String value) { 
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
         * @return {@link #file} (A file containing a resource used in the tests). This is the underlying object with id, value and extensions. The accessor "getFile" gives direct access to the value
         */
        public StringType getFileElement() { 
          if (this.file == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteResourceComponent.file");
            else if (Configuration.doAutoCreate())
              this.file = new StringType(); // bb
          return this.file;
        }

        public boolean hasFileElement() { 
          return this.file != null && !this.file.isEmpty();
        }

        public boolean hasFile() { 
          return this.file != null && !this.file.isEmpty();
        }

        /**
         * @param value {@link #file} (A file containing a resource used in the tests). This is the underlying object with id, value and extensions. The accessor "getFile" gives direct access to the value
         */
        public TestCasesSuiteResourceComponent setFileElement(StringType value) { 
          this.file = value;
          return this;
        }

        /**
         * @return A file containing a resource used in the tests
         */
        public String getFile() { 
          return this.file == null ? null : this.file.getValue();
        }

        /**
         * @param value A file containing a resource used in the tests
         */
        public TestCasesSuiteResourceComponent setFile(String value) { 
          if (Utilities.noString(value))
            this.file = null;
          else {
            if (this.file == null)
              this.file = new StringType();
            this.file.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resource} (An inline resource used in the tests. How exactly it is used depends on the definition of the runner.)
         */
        public Resource getResource() { 
          return this.resource;
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (An inline resource used in the tests. How exactly it is used depends on the definition of the runner.)
         */
        public TestCasesSuiteResourceComponent setResource(Resource value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return {@link #mode} (If this mode is not passed to the runner, then this resource will not be used). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CodeType getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteResourceComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new CodeType(); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (If this mode is not passed to the runner, then this resource will not be used). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public TestCasesSuiteResourceComponent setModeElement(CodeType value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return If this mode is not passed to the runner, then this resource will not be used
         */
        public String getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value If this mode is not passed to the runner, then this resource will not be used
         */
        public TestCasesSuiteResourceComponent setMode(String value) { 
          if (Utilities.noString(value))
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new CodeType();
            this.mode.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are", 0, 1, name));
          children.add(new Property("file", "string", "A file containing a resource used in the tests", 0, 1, file));
          children.add(new Property("resource", "Resource", "An inline resource used in the tests. How exactly it is used depends on the definition of the runner.", 0, 1, resource));
          children.add(new Property("mode", "code", "If this mode is not passed to the runner, then this resource will not be used", 0, 1, mode));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "A name that identifies this resource. The runner definition defines whether there must be a name, and what names there are", 0, 1, name);
          case 3143036: /*file*/  return new Property("file", "string", "A file containing a resource used in the tests", 0, 1, file);
          case -341064690: /*resource*/  return new Property("resource", "Resource", "An inline resource used in the tests. How exactly it is used depends on the definition of the runner.", 0, 1, resource);
          case 3357091: /*mode*/  return new Property("mode", "code", "If this mode is not passed to the runner, then this resource will not be used", 0, 1, mode);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3143036: /*file*/ return this.file == null ? new Base[0] : new Base[] {this.file}; // StringType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Resource
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // CodeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3143036: // file
          this.file = TypeConvertor.castToString(value); // StringType
          return value;
        case -341064690: // resource
          this.resource = (Resource) value; // Resource
          return value;
        case 3357091: // mode
          this.mode = TypeConvertor.castToCode(value); // CodeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("file")) {
          this.file = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("resource")) {
          this.resource = (Resource) value; // Resource
        } else if (name.equals("mode")) {
          this.mode = TypeConvertor.castToCode(value); // CodeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3143036:  return getFileElement();
        case -341064690: throw new FHIRException("Cannot make property resource as it is not a complex type"); // Resource
        case 3357091:  return getModeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 3143036: /*file*/ return new String[] {"string"};
        case -341064690: /*resource*/ return new String[] {"Resource"};
        case 3357091: /*mode*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.resource.name");
        }
        else if (name.equals("file")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.resource.file");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on an abstract type TestCases.suite.resource.resource");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.resource.mode");
        }
        else
          return super.addChild(name);
      }

      public TestCasesSuiteResourceComponent copy() {
        TestCasesSuiteResourceComponent dst = new TestCasesSuiteResourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCasesSuiteResourceComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.file = file == null ? null : file.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.mode = mode == null ? null : mode.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteResourceComponent))
          return false;
        TestCasesSuiteResourceComponent o = (TestCasesSuiteResourceComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(file, o.file, true) && compareDeep(resource, o.resource, true)
           && compareDeep(mode, o.mode, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteResourceComponent))
          return false;
        TestCasesSuiteResourceComponent o = (TestCasesSuiteResourceComponent) other_;
        return compareValues(name, o.name, true) && compareValues(file, o.file, true) && compareValues(mode, o.mode, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, file, resource, mode
          );
      }

  public String fhirType() {
    return "TestCases.suite.resource";

  }

  }

    @Block()
    public static class TestCasesSuiteParameterComponent extends LogicalBase {
        /**
         * Name of parameter
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of parameter", formalDefinition="Name of parameter" )
        protected StringType name;

        /**
         * The value of the parameter
         */
        @Child(name = "value", type = {StringType.class, BooleanType.class, IntegerType.class, DecimalType.class, DateTimeType.class, UriType.class, Coding.class, Quantity.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of this parameter", formalDefinition="The value of the parameter" )
        protected DataType value;

        /**
         * If this mode is not passed to the runner, then this parameter will not be used
         */
        @Child(name = "mode", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A mode that must be true for this parameter to be used", formalDefinition="If this mode is not passed to the runner, then this parameter will not be used" )
        protected CodeType mode;

        private static final long serialVersionUID = -410765611L;

    /**
     * Constructor
     */
      public TestCasesSuiteParameterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestCasesSuiteParameterComponent(String name, DataType value) {
        super();
        this.setName(name);
        this.setValue(value);
      }

        /**
         * @return {@link #name} (Name of parameter). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteParameterComponent.name");
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
         * @param value {@link #name} (Name of parameter). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TestCasesSuiteParameterComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of parameter
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of parameter
         */
        public TestCasesSuiteParameterComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() {
            return this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() {
            return this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() {
            return this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public DecimalType getValueDecimalType() throws FHIRException { 
          if (this.value == null)
            this.value = new DecimalType();
          if (!(this.value instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DecimalType) this.value;
        }

        public boolean hasValueDecimalType() {
            return this.value instanceof DecimalType;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public DateTimeType getValueDateTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateTimeType();
          if (!(this.value instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateTimeType) this.value;
        }

        public boolean hasValueDateTimeType() {
            return this.value instanceof DateTimeType;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public UriType getValueUriType() throws FHIRException { 
          if (this.value == null)
            this.value = new UriType();
          if (!(this.value instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (UriType) this.value;
        }

        public boolean hasValueUriType() {
            return this.value instanceof UriType;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public Coding getValueCoding() throws FHIRException { 
          if (this.value == null)
            this.value = new Coding();
          if (!(this.value instanceof Coding))
            throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Coding) this.value;
        }

        public boolean hasValueCoding() {
            return this.value instanceof Coding;
        }

        /**
         * @return {@link #value} (The value of the parameter)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() {
            return this.value instanceof Quantity;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The value of the parameter)
         */
        public TestCasesSuiteParameterComponent setValue(DataType value) { 
          if (value != null && !(value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof DecimalType || value instanceof DateTimeType || value instanceof UriType || value instanceof Coding || value instanceof Quantity))
            throw new FHIRException("Not the right type for TestCases.suite.parameter.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #mode} (If this mode is not passed to the runner, then this parameter will not be used). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CodeType getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteParameterComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new CodeType(); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (If this mode is not passed to the runner, then this parameter will not be used). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public TestCasesSuiteParameterComponent setModeElement(CodeType value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return If this mode is not passed to the runner, then this parameter will not be used
         */
        public String getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value If this mode is not passed to the runner, then this parameter will not be used
         */
        public TestCasesSuiteParameterComponent setMode(String value) { 
          if (Utilities.noString(value))
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new CodeType();
            this.mode.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Name of parameter", 0, 1, name));
          children.add(new Property("value[x]", "string|boolean|integer|decimal|dateTime|uri|Coding|Quantity", "The value of the parameter", 0, 1, value));
          children.add(new Property("mode", "code", "If this mode is not passed to the runner, then this parameter will not be used", 0, 1, mode));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Name of parameter", 0, 1, name);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "string|boolean|integer|decimal|dateTime|uri|Coding|Quantity", "The value of the parameter", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "string|boolean|integer|decimal|dateTime|uri|Coding|Quantity", "The value of the parameter", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The value of the parameter", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The value of the parameter", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The value of the parameter", 0, 1, value);
          case -2083993440: /*valueDecimal*/  return new Property("value[x]", "decimal", "The value of the parameter", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The value of the parameter", 0, 1, value);
          case -1410172357: /*valueUri*/  return new Property("value[x]", "uri", "The value of the parameter", 0, 1, value);
          case -1887705029: /*valueCoding*/  return new Property("value[x]", "Coding", "The value of the parameter", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The value of the parameter", 0, 1, value);
          case 3357091: /*mode*/  return new Property("mode", "code", "If this mode is not passed to the runner, then this parameter will not be used", 0, 1, mode);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // CodeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case 3357091: // mode
          this.mode = TypeConvertor.castToCode(value); // CodeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("mode")) {
          this.mode = TypeConvertor.castToCode(value); // CodeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case 3357091:  return getModeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"string", "boolean", "integer", "decimal", "dateTime", "uri", "Coding", "Quantity"};
        case 3357091: /*mode*/ return new String[] {"code"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.parameter.name");
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
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valueUri")) {
          this.value = new UriType();
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
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.parameter.mode");
        }
        else
          return super.addChild(name);
      }

      public TestCasesSuiteParameterComponent copy() {
        TestCasesSuiteParameterComponent dst = new TestCasesSuiteParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCasesSuiteParameterComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.value = value == null ? null : value.copy();
        dst.mode = mode == null ? null : mode.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteParameterComponent))
          return false;
        TestCasesSuiteParameterComponent o = (TestCasesSuiteParameterComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(value, o.value, true) && compareDeep(mode, o.mode, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteParameterComponent))
          return false;
        TestCasesSuiteParameterComponent o = (TestCasesSuiteParameterComponent) other_;
        return compareValues(name, o.name, true) && compareValues(mode, o.mode, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, value, mode);
      }

  public String fhirType() {
    return "TestCases.suite.parameter";

  }

  }

    @Block()
    public static class TestCasesSuiteTestComponent extends LogicalBase {
        /**
         * The name by which this test is known by in the test system. The name must be unique in the suite
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The name of this test - unique in the suite", formalDefinition="The name by which this test is known by in the test system. The name must be unique in the suite" )
        protected StringType name;

        /**
         * Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of what this test does / why it was defined", formalDefinition="Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results" )
        protected StringType description;

        /**
         * A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner
         */
        @Child(name = "operation", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Operation that is executed during this test (per definition of runner)", formalDefinition="A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner" )
        protected CodeType operation;

        /**
         * If this mode is not passed to the runner, then this test will not be run
         */
        @Child(name = "mode", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="mode required to run this test", formalDefinition="If this mode is not passed to the runner, then this test will not be run" )
        protected StringType mode;

        /**
         * 
         */
        @Child(name = "parameter", type = {TestCasesSuiteParameterComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="", formalDefinition="" )
        protected List<TestCasesSuiteParameterComponent> parameterList;

        /**
         * The resources used when executing this test. How exactly they are used depends on the definition of the runner.
         */
        @Child(name = "input", type = {TestCasesSuiteResourceComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Resources used when executing this test (per runner definition)", formalDefinition="The resources used when executing this test. How exactly they are used depends on the definition of the runner." )
        protected List<TestCasesSuiteResourceComponent> inputList;

        /**
         * Resources expected as output from this test. Often, but not always, these resources are Matchetype resources. How exactly it is used depends on the definition of the runner
         */
        @Child(name = "output", type = {TestCasesSuiteResourceComponent.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Resources expected as output from this test (per runner definition, often Matchetypes)", formalDefinition="Resources expected as output from this test. Often, but not always, these resources are Matchetype resources. How exactly it is used depends on the definition of the runner" )
        protected List<TestCasesSuiteResourceComponent> outputList;

        private static final long serialVersionUID = 330781544L;

    /**
     * Constructor
     */
      public TestCasesSuiteTestComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestCasesSuiteTestComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (The name by which this test is known by in the test system. The name must be unique in the suite). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteTestComponent.name");
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
         * @param value {@link #name} (The name by which this test is known by in the test system. The name must be unique in the suite). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public TestCasesSuiteTestComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name by which this test is known by in the test system. The name must be unique in the suite
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name by which this test is known by in the test system. The name must be unique in the suite
         */
        public TestCasesSuiteTestComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #description} (Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteTestComponent.description");
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
         * @param value {@link #description} (Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestCasesSuiteTestComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results
         */
        public TestCasesSuiteTestComponent setDescription(String value) { 
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
         * @return {@link #operation} (A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner). This is the underlying object with id, value and extensions. The accessor "getOperation" gives direct access to the value
         */
        public CodeType getOperationElement() { 
          if (this.operation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteTestComponent.operation");
            else if (Configuration.doAutoCreate())
              this.operation = new CodeType(); // bb
          return this.operation;
        }

        public boolean hasOperationElement() { 
          return this.operation != null && !this.operation.isEmpty();
        }

        public boolean hasOperation() { 
          return this.operation != null && !this.operation.isEmpty();
        }

        /**
         * @param value {@link #operation} (A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner). This is the underlying object with id, value and extensions. The accessor "getOperation" gives direct access to the value
         */
        public TestCasesSuiteTestComponent setOperationElement(CodeType value) { 
          this.operation = value;
          return this;
        }

        /**
         * @return A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner
         */
        public String getOperation() { 
          return this.operation == null ? null : this.operation.getValue();
        }

        /**
         * @param value A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner
         */
        public TestCasesSuiteTestComponent setOperation(String value) { 
          if (Utilities.noString(value))
            this.operation = null;
          else {
            if (this.operation == null)
              this.operation = new CodeType();
            this.operation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #mode} (If this mode is not passed to the runner, then this test will not be run). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public StringType getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCasesSuiteTestComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new StringType(); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (If this mode is not passed to the runner, then this test will not be run). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public TestCasesSuiteTestComponent setModeElement(StringType value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return If this mode is not passed to the runner, then this test will not be run
         */
        public String getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value If this mode is not passed to the runner, then this test will not be run
         */
        public TestCasesSuiteTestComponent setMode(String value) { 
          if (Utilities.noString(value))
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new StringType();
            this.mode.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #parameter} ()
         */
        public List<TestCasesSuiteParameterComponent> getParameterList() { 
          if (this.parameterList == null)
            this.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          return this.parameterList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestCasesSuiteTestComponent setParameterList(List<TestCasesSuiteParameterComponent> theParameter) { 
          this.parameterList = theParameter;
          return this;
        }

        public boolean hasParameter() { 
          if (this.parameterList == null)
            return false;
          for (TestCasesSuiteParameterComponent item : this.parameterList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCasesSuiteParameterComponent addParameter() { //3a
          TestCasesSuiteParameterComponent t = new TestCasesSuiteParameterComponent();
          if (this.parameterList == null)
            this.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          this.parameterList.add(t);
          return t;
        }

        public TestCasesSuiteTestComponent addParameter(TestCasesSuiteParameterComponent t) { //3b
          if (t == null)
            return this;
          if (this.parameterList == null)
            this.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          this.parameterList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
         */
        public TestCasesSuiteParameterComponent getParameterFirstRep() { 
          if (getParameterList().isEmpty()) {
            addParameter();
          }
          return getParameterList().get(0);
        }

        /**
         * @return {@link #input} (The resources used when executing this test. How exactly they are used depends on the definition of the runner.)
         */
        public List<TestCasesSuiteResourceComponent> getInputList() { 
          if (this.inputList == null)
            this.inputList = new ArrayList<TestCasesSuiteResourceComponent>();
          return this.inputList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestCasesSuiteTestComponent setInputList(List<TestCasesSuiteResourceComponent> theInput) { 
          this.inputList = theInput;
          return this;
        }

        public boolean hasInput() { 
          if (this.inputList == null)
            return false;
          for (TestCasesSuiteResourceComponent item : this.inputList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCasesSuiteResourceComponent addInput() { //3a
          TestCasesSuiteResourceComponent t = new TestCasesSuiteResourceComponent();
          if (this.inputList == null)
            this.inputList = new ArrayList<TestCasesSuiteResourceComponent>();
          this.inputList.add(t);
          return t;
        }

        public TestCasesSuiteTestComponent addInput(TestCasesSuiteResourceComponent t) { //3b
          if (t == null)
            return this;
          if (this.inputList == null)
            this.inputList = new ArrayList<TestCasesSuiteResourceComponent>();
          this.inputList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #input}, creating it if it does not already exist {3}
         */
        public TestCasesSuiteResourceComponent getInputFirstRep() { 
          if (getInputList().isEmpty()) {
            addInput();
          }
          return getInputList().get(0);
        }

        /**
         * @return {@link #output} (Resources expected as output from this test. Often, but not always, these resources are Matchetype resources. How exactly it is used depends on the definition of the runner)
         */
        public List<TestCasesSuiteResourceComponent> getOutputList() { 
          if (this.outputList == null)
            this.outputList = new ArrayList<TestCasesSuiteResourceComponent>();
          return this.outputList;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestCasesSuiteTestComponent setOutputList(List<TestCasesSuiteResourceComponent> theOutput) { 
          this.outputList = theOutput;
          return this;
        }

        public boolean hasOutput() { 
          if (this.outputList == null)
            return false;
          for (TestCasesSuiteResourceComponent item : this.outputList)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCasesSuiteResourceComponent addOutput() { //3a
          TestCasesSuiteResourceComponent t = new TestCasesSuiteResourceComponent();
          if (this.outputList == null)
            this.outputList = new ArrayList<TestCasesSuiteResourceComponent>();
          this.outputList.add(t);
          return t;
        }

        public TestCasesSuiteTestComponent addOutput(TestCasesSuiteResourceComponent t) { //3b
          if (t == null)
            return this;
          if (this.outputList == null)
            this.outputList = new ArrayList<TestCasesSuiteResourceComponent>();
          this.outputList.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #output}, creating it if it does not already exist {3}
         */
        public TestCasesSuiteResourceComponent getOutputFirstRep() { 
          if (getOutputList().isEmpty()) {
            addOutput();
          }
          return getOutputList().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name by which this test is known by in the test system. The name must be unique in the suite", 0, 1, name));
          children.add(new Property("description", "string", "Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results", 0, 1, description));
          children.add(new Property("operation", "code", "A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner", 0, 1, operation));
          children.add(new Property("mode", "string", "If this mode is not passed to the runner, then this test will not be run", 0, 1, mode));
          children.add(new Property("parameter", "http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.parameter", "", 0, java.lang.Integer.MAX_VALUE, parameterList));
          children.add(new Property("input", "http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.resource", "The resources used when executing this test. How exactly they are used depends on the definition of the runner.", 0, java.lang.Integer.MAX_VALUE, inputList));
          children.add(new Property("output", "http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.resource", "Resources expected as output from this test. Often, but not always, these resources are Matchetype resources. How exactly it is used depends on the definition of the runner", 0, java.lang.Integer.MAX_VALUE, outputList));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name by which this test is known by in the test system. The name must be unique in the suite", 0, 1, name);
          case -1724546052: /*description*/  return new Property("description", "string", "Description of what this test does / why it was defined. This should explain to a tester what they should know when looking at failing test results", 0, 1, description);
          case 1662702951: /*operation*/  return new Property("operation", "code", "A code that identifies the operation executed for this test. One of the codes defined in the definition of the runner", 0, 1, operation);
          case 3357091: /*mode*/  return new Property("mode", "string", "If this mode is not passed to the runner, then this test will not be run", 0, 1, mode);
          case 1954460585: /*parameter*/  return new Property("parameter", "http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.parameter", "", 0, java.lang.Integer.MAX_VALUE, parameterList);
          case 100358090: /*input*/  return new Property("input", "http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.resource", "The resources used when executing this test. How exactly they are used depends on the definition of the runner.", 0, java.lang.Integer.MAX_VALUE, inputList);
          case -1005512447: /*output*/  return new Property("output", "http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.resource", "Resources expected as output from this test. Often, but not always, these resources are Matchetype resources. How exactly it is used depends on the definition of the runner", 0, java.lang.Integer.MAX_VALUE, outputList);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : new Base[] {this.operation}; // CodeType
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // StringType
        case 1954460585: /*parameter*/ return this.parameterList == null ? new Base[0] : this.parameterList.toArray(new Base[this.parameterList.size()]); // TestCasesSuiteParameterComponent
        case 100358090: /*input*/ return this.inputList == null ? new Base[0] : this.inputList.toArray(new Base[this.inputList.size()]); // TestCasesSuiteResourceComponent
        case -1005512447: /*output*/ return this.outputList == null ? new Base[0] : this.outputList.toArray(new Base[this.outputList.size()]); // TestCasesSuiteResourceComponent
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
        case 1662702951: // operation
          this.operation = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 3357091: // mode
          this.mode = TypeConvertor.castToString(value); // StringType
          return value;
        case 1954460585: // parameter
          this.getParameterList().add((TestCasesSuiteParameterComponent) value); // TestCasesSuiteParameterComponent
          return value;
        case 100358090: // input
          this.getInputList().add((TestCasesSuiteResourceComponent) value); // TestCasesSuiteResourceComponent
          return value;
        case -1005512447: // output
          this.getOutputList().add((TestCasesSuiteResourceComponent) value); // TestCasesSuiteResourceComponent
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
        } else if (name.equals("operation")) {
          this.operation = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("mode")) {
          this.mode = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("parameter")) {
          this.getParameterList().add((TestCasesSuiteParameterComponent) value); // TestCasesSuiteParameterComponent
        } else if (name.equals("input")) {
          this.getInputList().add((TestCasesSuiteResourceComponent) value); // TestCasesSuiteResourceComponent
        } else if (name.equals("output")) {
          this.getOutputList().add((TestCasesSuiteResourceComponent) value); // TestCasesSuiteResourceComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case 1662702951:  return getOperationElement();
        case 3357091:  return getModeElement();
        case 1954460585:  return addParameter(); 
        case 100358090:  return addInput(); 
        case -1005512447:  return addOutput(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 1662702951: /*operation*/ return new String[] {"code"};
        case 3357091: /*mode*/ return new String[] {"string"};
        case 1954460585: /*parameter*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.parameter"};
        case 100358090: /*input*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.resource"};
        case -1005512447: /*output*/ return new String[] {"http://hl7.org/fhir/tools/StructureDefinition/TestCases@TestCases.suite.resource"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.test.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.test.description");
        }
        else if (name.equals("operation")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.test.operation");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.suite.test.mode");
        }
        else if (name.equals("parameter")) {
          return addParameter();
        }
        else if (name.equals("input")) {
          return addInput();
        }
        else if (name.equals("output")) {
          return addOutput();
        }
        else
          return super.addChild(name);
      }

      public TestCasesSuiteTestComponent copy() {
        TestCasesSuiteTestComponent dst = new TestCasesSuiteTestComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCasesSuiteTestComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        dst.operation = operation == null ? null : operation.copy();
        dst.mode = mode == null ? null : mode.copy();
        if (parameterList != null) {
          dst.parameterList = new ArrayList<TestCasesSuiteParameterComponent>();
          for (TestCasesSuiteParameterComponent i : parameterList)
            dst.parameterList.add(i.copy());
        };
        if (inputList != null) {
          dst.inputList = new ArrayList<TestCasesSuiteResourceComponent>();
          for (TestCasesSuiteResourceComponent i : inputList)
            dst.inputList.add(i.copy());
        };
        if (outputList != null) {
          dst.outputList = new ArrayList<TestCasesSuiteResourceComponent>();
          for (TestCasesSuiteResourceComponent i : outputList)
            dst.outputList.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteTestComponent))
          return false;
        TestCasesSuiteTestComponent o = (TestCasesSuiteTestComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(description, o.description, true) && compareDeep(operation, o.operation, true)
           && compareDeep(mode, o.mode, true) && compareDeep(parameterList, o.parameterList, true) && compareDeep(inputList, o.inputList, true)
           && compareDeep(outputList, o.outputList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCasesSuiteTestComponent))
          return false;
        TestCasesSuiteTestComponent o = (TestCasesSuiteTestComponent) other_;
        return compareValues(name, o.name, true) && compareValues(description, o.description, true) && compareValues(operation, o.operation, true)
           && compareValues(mode, o.mode, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, description, operation
          , mode, parameterList, inputList, outputList);
      }

  public String fhirType() {
    return "TestCases.suite.test";

  }

// Additional Code from TestCasesSuiteTestComponent.java:

  public String getParameterStr(String name) { 
    for (TestCasesSuiteParameterComponent p : getParameterList()) { 
      if (name.equals(p.getName())) { 
        return p.getValue().primitiveValue(); 
      } 
    } 

    return null; 
  } 

  public DataType getParameter(String name) { 
    for (TestCasesSuiteParameterComponent p : getParameterList()) { 
      if (name.equals(p.getName())) { 
        return p.getValue(); 
      } 
    } 

    return null; 
  } 

  public TestCasesSuiteResourceComponent getInput(String name) { 
    for (TestCasesSuiteResourceComponent input : getInputList()) { 
      if (name.equals(input.getName())) { 
        return input; 
      } 
    } 
    return null; 
  } 
// end addition
  }

    /**
     * An absolute URI that is used to identify test tests.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for these tests, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify test tests." )
    protected UriType url;

    /**
     * The identifier that is used to identify this version of these tests. Version must use SemVer
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the test set (semver)", formalDefinition="The identifier that is used to identify this version of these tests. Version must use SemVer" )
    protected StringType version;

    /**
     * A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for these tests", formalDefinition="A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * General description of these teats.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General Description of these tests", formalDefinition="General description of these teats." )
    protected MarkdownType description;

    /**
     * URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.
     */
    @Child(name = "runner", type = {UrlType.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="URL Documentation for a runner that executes these tests", formalDefinition="URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool." )
    protected UrlType runner;

    /**
     * A mode that can be passed to a runner running these these tests, that affects test content and influences how the tests are executed or evaulated (or even if they run)
     */
    @Child(name = "mode", type = {Base.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A mode that can be passed to runner - affects test content", formalDefinition="A mode that can be passed to a runner running these these tests, that affects test content and influences how the tests are executed or evaulated (or even if they run)" )
    protected List<TestCasesModeComponent> modeList;

    /**
     * A suite of tests that all share a common set up, and can be executed as a group
     */
    @Child(name = "suite", type = {Base.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A suite of tests that share a common set up", formalDefinition="A suite of tests that all share a common set up, and can be executed as a group" )
    protected List<TestCasesSuiteComponent> suiteList;

    private static final long serialVersionUID = -1998407452L;

  /**
   * Constructor
   */
    public TestCases() {
      super();
    }

  /**
   * Constructor
   */
    public TestCases(String runner) {
      super();
      this.setRunner(runner);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify test tests.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestCases.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify test tests.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public TestCases setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify test tests.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify test tests.
     */
    public TestCases setUrl(String value) { 
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
     * @return {@link #version} (The identifier that is used to identify this version of these tests. Version must use SemVer). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestCases.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of these tests. Version must use SemVer). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public TestCases setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of these tests. Version must use SemVer
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of these tests. Version must use SemVer
     */
    public TestCases setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestCases.name");
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
     * @param value {@link #name} (A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public TestCases setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public TestCases setName(String value) { 
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
     * @return {@link #description} (General description of these teats.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestCases.description");
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
     * @param value {@link #description} (General description of these teats.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public TestCases setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return General description of these teats.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value General description of these teats.
     */
    public TestCases setDescription(String value) { 
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
     * @return {@link #runner} (URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.). This is the underlying object with id, value and extensions. The accessor "getRunner" gives direct access to the value
     */
    public UrlType getRunnerElement() { 
      if (this.runner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestCases.runner");
        else if (Configuration.doAutoCreate())
          this.runner = new UrlType(); // bb
      return this.runner;
    }

    public boolean hasRunnerElement() { 
      return this.runner != null && !this.runner.isEmpty();
    }

    public boolean hasRunner() { 
      return this.runner != null && !this.runner.isEmpty();
    }

    /**
     * @param value {@link #runner} (URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.). This is the underlying object with id, value and extensions. The accessor "getRunner" gives direct access to the value
     */
    public TestCases setRunnerElement(UrlType value) { 
      this.runner = value;
      return this;
    }

    /**
     * @return URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.
     */
    public String getRunner() { 
      return this.runner == null ? null : this.runner.getValue();
    }

    /**
     * @param value URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.
     */
    public TestCases setRunner(String value) { 
        if (this.runner == null)
          this.runner = new UrlType();
        this.runner.setValue(value);
      return this;
    }

    /**
     * @return {@link #mode} (A mode that can be passed to a runner running these these tests, that affects test content and influences how the tests are executed or evaulated (or even if they run))
     */
    public List<TestCasesModeComponent> getModeList() { 
      if (this.modeList == null)
        this.modeList = new ArrayList<TestCasesModeComponent>();
      return this.modeList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestCases setModeList(List<TestCasesModeComponent> theMode) { 
      this.modeList = theMode;
      return this;
    }

    public boolean hasMode() { 
      if (this.modeList == null)
        return false;
      for (TestCasesModeComponent item : this.modeList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestCases addMode(TestCasesModeComponent t) { //3b
      if (t == null)
        return this;
      if (this.modeList == null)
        this.modeList = new ArrayList<TestCasesModeComponent>();
      this.modeList.add(t);
      return this;
    }

    /**
     * @return {@link #suite} (A suite of tests that all share a common set up, and can be executed as a group)
     */
    public List<TestCasesSuiteComponent> getSuiteList() { 
      if (this.suiteList == null)
        this.suiteList = new ArrayList<TestCasesSuiteComponent>();
      return this.suiteList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestCases setSuiteList(List<TestCasesSuiteComponent> theSuite) { 
      this.suiteList = theSuite;
      return this;
    }

    public boolean hasSuite() { 
      if (this.suiteList == null)
        return false;
      for (TestCasesSuiteComponent item : this.suiteList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestCases addSuite(TestCasesSuiteComponent t) { //3b
      if (t == null)
        return this;
      if (this.suiteList == null)
        this.suiteList = new ArrayList<TestCasesSuiteComponent>();
      this.suiteList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify test tests.", 0, 1, url));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of these tests. Version must use SemVer", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("description", "markdown", "General description of these teats.", 0, 1, description));
        children.add(new Property("runner", "url", "URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.", 0, 1, runner));
        children.add(new Property("mode", "Base", "A mode that can be passed to a runner running these these tests, that affects test content and influences how the tests are executed or evaulated (or even if they run)", 0, java.lang.Integer.MAX_VALUE, modeList));
        children.add(new Property("suite", "Base", "A suite of tests that all share a common set up, and can be executed as a group", 0, java.lang.Integer.MAX_VALUE, suiteList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify test tests.", 0, 1, url);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of these tests. Version must use SemVer", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the tests. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case -1724546052: /*description*/  return new Property("description", "markdown", "General description of these teats.", 0, 1, description);
        case -919806160: /*runner*/  return new Property("runner", "url", "URL of documentation that explains how a runner would read these tests, and use them to actually test out a tool.", 0, 1, runner);
        case 3357091: /*mode*/  return new Property("mode", "Base", "A mode that can be passed to a runner running these these tests, that affects test content and influences how the tests are executed or evaulated (or even if they run)", 0, java.lang.Integer.MAX_VALUE, modeList);
        case 109795064: /*suite*/  return new Property("suite", "Base", "A suite of tests that all share a common set up, and can be executed as a group", 0, java.lang.Integer.MAX_VALUE, suiteList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -919806160: /*runner*/ return this.runner == null ? new Base[0] : new Base[] {this.runner}; // UrlType
        case 3357091: /*mode*/ return this.modeList == null ? new Base[0] : this.modeList.toArray(new Base[this.modeList.size()]); // TestCasesModeComponent
        case 109795064: /*suite*/ return this.suiteList == null ? new Base[0] : this.suiteList.toArray(new Base[this.suiteList.size()]); // TestCasesSuiteComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -919806160: // runner
          this.runner = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 3357091: // mode
          this.getModeList().add((TestCasesModeComponent) value); // TestCasesModeComponent
          return value;
        case 109795064: // suite
          this.getSuiteList().add((TestCasesSuiteComponent) value); // TestCasesSuiteComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("runner")) {
          this.runner = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("mode")) {
          this.getModeList().add((TestCasesModeComponent) value); // TestCasesModeComponent
        } else if (name.equals("suite")) {
          this.getSuiteList().add((TestCasesSuiteComponent) value); // TestCasesSuiteComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case -919806160:  return getRunnerElement();
        case 3357091: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'mode'");
        case 109795064: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'suite'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -919806160: /*runner*/ return new String[] {"url"};
        case 3357091: /*mode*/ return new String[] {"Base"};
        case 109795064: /*suite*/ return new String[] {"Base"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.url");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.description");
        }
        else if (name.equals("runner")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestCases.runner");
        }
        else if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on an abstract type TestCases.mode");
        }
        else if (name.equals("suite")) {
          throw new FHIRException("Cannot call addChild on an abstract type TestCases.suite");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "TestCases";

  }

      public TestCases copy() {
        TestCases dst = new TestCases();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCases dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        dst.runner = runner == null ? null : runner.copy();
        if (modeList != null) {
          dst.modeList = new ArrayList<TestCasesModeComponent>();
          for (TestCasesModeComponent i : modeList)
            dst.modeList.add(i.copy());
        };
        if (suiteList != null) {
          dst.suiteList = new ArrayList<TestCasesSuiteComponent>();
          for (TestCasesSuiteComponent i : suiteList)
            dst.suiteList.add(i.copy());
        };
      }

      protected TestCases typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCases))
          return false;
        TestCases o = (TestCases) other_;
        return compareDeep(url, o.url, true) && compareDeep(version, o.version, true) && compareDeep(name, o.name, true)
           && compareDeep(description, o.description, true) && compareDeep(runner, o.runner, true) && compareDeep(modeList, o.modeList, true)
           && compareDeep(suiteList, o.suiteList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCases))
          return false;
        TestCases o = (TestCases) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(description, o.description, true) && compareValues(runner, o.runner, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, version, name, description
          , runner, modeList, suiteList);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Custom;
   }

  public String getCustomResourceName() {
    return "TestCases";
   }


}

