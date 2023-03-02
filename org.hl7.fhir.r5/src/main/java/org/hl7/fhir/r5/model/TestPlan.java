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
 * A report of inventory or stock items.
 */
@ResourceDef(name="TestPlan", profile="http://hl7.org/fhir/StructureDefinition/TestPlan")
public class TestPlan extends DomainResource {

    @Block()
    public static class TestPlanDependenciesComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of the criteria.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Description of the criteria", formalDefinition="Description of the criteria." )
        protected MarkdownType description;

        /**
         * Link to predecessor test plans.
         */
        @Child(name = "predecessor", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Link to predecessor test plans", formalDefinition="Link to predecessor test plans." )
        protected Reference predecessor;

        private static final long serialVersionUID = 1630757943L;

    /**
     * Constructor
     */
      public TestPlanDependenciesComponent() {
        super();
      }

        /**
         * @return {@link #description} (Description of the criteria.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanDependenciesComponent.description");
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
         * @param value {@link #description} (Description of the criteria.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestPlanDependenciesComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of the criteria.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of the criteria.
         */
        public TestPlanDependenciesComponent setDescription(String value) { 
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
         * @return {@link #predecessor} (Link to predecessor test plans.)
         */
        public Reference getPredecessor() { 
          if (this.predecessor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanDependenciesComponent.predecessor");
            else if (Configuration.doAutoCreate())
              this.predecessor = new Reference(); // cc
          return this.predecessor;
        }

        public boolean hasPredecessor() { 
          return this.predecessor != null && !this.predecessor.isEmpty();
        }

        /**
         * @param value {@link #predecessor} (Link to predecessor test plans.)
         */
        public TestPlanDependenciesComponent setPredecessor(Reference value) { 
          this.predecessor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "Description of the criteria.", 0, 1, description));
          children.add(new Property("predecessor", "Reference", "Link to predecessor test plans.", 0, 1, predecessor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Description of the criteria.", 0, 1, description);
          case -1925032183: /*predecessor*/  return new Property("predecessor", "Reference", "Link to predecessor test plans.", 0, 1, predecessor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1925032183: /*predecessor*/ return this.predecessor == null ? new Base[0] : new Base[] {this.predecessor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1925032183: // predecessor
          this.predecessor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("predecessor")) {
          this.predecessor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -1925032183:  return getPredecessor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1925032183: /*predecessor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.dependencies.description");
        }
        else if (name.equals("predecessor")) {
          this.predecessor = new Reference();
          return this.predecessor;
        }
        else
          return super.addChild(name);
      }

      public TestPlanDependenciesComponent copy() {
        TestPlanDependenciesComponent dst = new TestPlanDependenciesComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanDependenciesComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.predecessor = predecessor == null ? null : predecessor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanDependenciesComponent))
          return false;
        TestPlanDependenciesComponent o = (TestPlanDependenciesComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(predecessor, o.predecessor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanDependenciesComponent))
          return false;
        TestPlanDependenciesComponent o = (TestPlanDependenciesComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, predecessor);
      }

  public String fhirType() {
    return "TestPlan.dependencies";

  }

  }

    @Block()
    public static class TestPlanTestCaseComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Sequence of testing.
         */
        @Child(name = "sequence", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Sequence of testing", formalDefinition="Sequence of testing." )
        protected IntegerType sequence;

        /**
         * Specific test scope for one test case.
         */
        @Child(name = "scope", type = {Reference.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Specific test scope for one test case", formalDefinition="Specific test scope for one test case." )
        protected List<Reference> scope;

        /**
         * The required criteria to execute the test case - e.g. preconditions, previous tests.
         */
        @Child(name = "dependencies", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The required criteria to execute the test case - e.g. preconditions, previous tests", formalDefinition="The required criteria to execute the test case - e.g. preconditions, previous tests." )
        protected List<TestPlanTestCaseDependenciesComponent> dependencies;

        /**
         * The actual test to be executed.
         */
        @Child(name = "testRun", type = {Reference.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The actual test to be executed", formalDefinition="The actual test to be executed." )
        protected List<Reference> testRun;

        /**
         * The test data used in the test case.
         */
        @Child(name = "testData", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The test data used in the test case", formalDefinition="The test data used in the test case." )
        protected List<TestPlanTestCaseTestDataComponent> testData;

        /**
         * The test assertions.
         */
        @Child(name = "assertions", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The test assertions", formalDefinition="The test assertions." )
        protected List<TestPlanTestCaseAssertionsComponent> assertions;

        private static final long serialVersionUID = -1444786592L;

    /**
     * Constructor
     */
      public TestPlanTestCaseComponent() {
        super();
      }

        /**
         * @return {@link #sequence} (Sequence of testing.). This is the underlying object with id, value and extensions. The accessor "getSequence" gives direct access to the value
         */
        public IntegerType getSequenceElement() { 
          if (this.sequence == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseComponent.sequence");
            else if (Configuration.doAutoCreate())
              this.sequence = new IntegerType(); // bb
          return this.sequence;
        }

        public boolean hasSequenceElement() { 
          return this.sequence != null && !this.sequence.isEmpty();
        }

        public boolean hasSequence() { 
          return this.sequence != null && !this.sequence.isEmpty();
        }

        /**
         * @param value {@link #sequence} (Sequence of testing.). This is the underlying object with id, value and extensions. The accessor "getSequence" gives direct access to the value
         */
        public TestPlanTestCaseComponent setSequenceElement(IntegerType value) { 
          this.sequence = value;
          return this;
        }

        /**
         * @return Sequence of testing.
         */
        public int getSequence() { 
          return this.sequence == null || this.sequence.isEmpty() ? 0 : this.sequence.getValue();
        }

        /**
         * @param value Sequence of testing.
         */
        public TestPlanTestCaseComponent setSequence(int value) { 
            if (this.sequence == null)
              this.sequence = new IntegerType();
            this.sequence.setValue(value);
          return this;
        }

        /**
         * @return {@link #scope} (Specific test scope for one test case.)
         */
        public List<Reference> getScope() { 
          if (this.scope == null)
            this.scope = new ArrayList<Reference>();
          return this.scope;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setScope(List<Reference> theScope) { 
          this.scope = theScope;
          return this;
        }

        public boolean hasScope() { 
          if (this.scope == null)
            return false;
          for (Reference item : this.scope)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addScope() { //3
          Reference t = new Reference();
          if (this.scope == null)
            this.scope = new ArrayList<Reference>();
          this.scope.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addScope(Reference t) { //3
          if (t == null)
            return this;
          if (this.scope == null)
            this.scope = new ArrayList<Reference>();
          this.scope.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #scope}, creating it if it does not already exist {3}
         */
        public Reference getScopeFirstRep() { 
          if (getScope().isEmpty()) {
            addScope();
          }
          return getScope().get(0);
        }

        /**
         * @return {@link #dependencies} (The required criteria to execute the test case - e.g. preconditions, previous tests.)
         */
        public List<TestPlanTestCaseDependenciesComponent> getDependencies() { 
          if (this.dependencies == null)
            this.dependencies = new ArrayList<TestPlanTestCaseDependenciesComponent>();
          return this.dependencies;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setDependencies(List<TestPlanTestCaseDependenciesComponent> theDependencies) { 
          this.dependencies = theDependencies;
          return this;
        }

        public boolean hasDependencies() { 
          if (this.dependencies == null)
            return false;
          for (TestPlanTestCaseDependenciesComponent item : this.dependencies)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestPlanTestCaseDependenciesComponent addDependencies() { //3
          TestPlanTestCaseDependenciesComponent t = new TestPlanTestCaseDependenciesComponent();
          if (this.dependencies == null)
            this.dependencies = new ArrayList<TestPlanTestCaseDependenciesComponent>();
          this.dependencies.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addDependencies(TestPlanTestCaseDependenciesComponent t) { //3
          if (t == null)
            return this;
          if (this.dependencies == null)
            this.dependencies = new ArrayList<TestPlanTestCaseDependenciesComponent>();
          this.dependencies.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dependencies}, creating it if it does not already exist {3}
         */
        public TestPlanTestCaseDependenciesComponent getDependenciesFirstRep() { 
          if (getDependencies().isEmpty()) {
            addDependencies();
          }
          return getDependencies().get(0);
        }

        /**
         * @return {@link #testRun} (The actual test to be executed.)
         */
        public List<Reference> getTestRun() { 
          if (this.testRun == null)
            this.testRun = new ArrayList<Reference>();
          return this.testRun;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setTestRun(List<Reference> theTestRun) { 
          this.testRun = theTestRun;
          return this;
        }

        public boolean hasTestRun() { 
          if (this.testRun == null)
            return false;
          for (Reference item : this.testRun)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addTestRun() { //3
          Reference t = new Reference();
          if (this.testRun == null)
            this.testRun = new ArrayList<Reference>();
          this.testRun.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addTestRun(Reference t) { //3
          if (t == null)
            return this;
          if (this.testRun == null)
            this.testRun = new ArrayList<Reference>();
          this.testRun.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #testRun}, creating it if it does not already exist {3}
         */
        public Reference getTestRunFirstRep() { 
          if (getTestRun().isEmpty()) {
            addTestRun();
          }
          return getTestRun().get(0);
        }

        /**
         * @return {@link #testData} (The test data used in the test case.)
         */
        public List<TestPlanTestCaseTestDataComponent> getTestData() { 
          if (this.testData == null)
            this.testData = new ArrayList<TestPlanTestCaseTestDataComponent>();
          return this.testData;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setTestData(List<TestPlanTestCaseTestDataComponent> theTestData) { 
          this.testData = theTestData;
          return this;
        }

        public boolean hasTestData() { 
          if (this.testData == null)
            return false;
          for (TestPlanTestCaseTestDataComponent item : this.testData)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestPlanTestCaseTestDataComponent addTestData() { //3
          TestPlanTestCaseTestDataComponent t = new TestPlanTestCaseTestDataComponent();
          if (this.testData == null)
            this.testData = new ArrayList<TestPlanTestCaseTestDataComponent>();
          this.testData.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addTestData(TestPlanTestCaseTestDataComponent t) { //3
          if (t == null)
            return this;
          if (this.testData == null)
            this.testData = new ArrayList<TestPlanTestCaseTestDataComponent>();
          this.testData.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #testData}, creating it if it does not already exist {3}
         */
        public TestPlanTestCaseTestDataComponent getTestDataFirstRep() { 
          if (getTestData().isEmpty()) {
            addTestData();
          }
          return getTestData().get(0);
        }

        /**
         * @return {@link #assertions} (The test assertions.)
         */
        public List<TestPlanTestCaseAssertionsComponent> getAssertions() { 
          if (this.assertions == null)
            this.assertions = new ArrayList<TestPlanTestCaseAssertionsComponent>();
          return this.assertions;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setAssertions(List<TestPlanTestCaseAssertionsComponent> theAssertions) { 
          this.assertions = theAssertions;
          return this;
        }

        public boolean hasAssertions() { 
          if (this.assertions == null)
            return false;
          for (TestPlanTestCaseAssertionsComponent item : this.assertions)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestPlanTestCaseAssertionsComponent addAssertions() { //3
          TestPlanTestCaseAssertionsComponent t = new TestPlanTestCaseAssertionsComponent();
          if (this.assertions == null)
            this.assertions = new ArrayList<TestPlanTestCaseAssertionsComponent>();
          this.assertions.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addAssertions(TestPlanTestCaseAssertionsComponent t) { //3
          if (t == null)
            return this;
          if (this.assertions == null)
            this.assertions = new ArrayList<TestPlanTestCaseAssertionsComponent>();
          this.assertions.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #assertions}, creating it if it does not already exist {3}
         */
        public TestPlanTestCaseAssertionsComponent getAssertionsFirstRep() { 
          if (getAssertions().isEmpty()) {
            addAssertions();
          }
          return getAssertions().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("sequence", "integer", "Sequence of testing.", 0, 1, sequence));
          children.add(new Property("scope", "Reference", "Specific test scope for one test case.", 0, java.lang.Integer.MAX_VALUE, scope));
          children.add(new Property("dependencies", "", "The required criteria to execute the test case - e.g. preconditions, previous tests.", 0, java.lang.Integer.MAX_VALUE, dependencies));
          children.add(new Property("testRun", "Reference", "The actual test to be executed.", 0, java.lang.Integer.MAX_VALUE, testRun));
          children.add(new Property("testData", "", "The test data used in the test case.", 0, java.lang.Integer.MAX_VALUE, testData));
          children.add(new Property("assertions", "", "The test assertions.", 0, java.lang.Integer.MAX_VALUE, assertions));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1349547969: /*sequence*/  return new Property("sequence", "integer", "Sequence of testing.", 0, 1, sequence);
          case 109264468: /*scope*/  return new Property("scope", "Reference", "Specific test scope for one test case.", 0, java.lang.Integer.MAX_VALUE, scope);
          case 503774505: /*dependencies*/  return new Property("dependencies", "", "The required criteria to execute the test case - e.g. preconditions, previous tests.", 0, java.lang.Integer.MAX_VALUE, dependencies);
          case -1422467943: /*testRun*/  return new Property("testRun", "Reference", "The actual test to be executed.", 0, java.lang.Integer.MAX_VALUE, testRun);
          case -1147269284: /*testData*/  return new Property("testData", "", "The test data used in the test case.", 0, java.lang.Integer.MAX_VALUE, testData);
          case 2091567537: /*assertions*/  return new Property("assertions", "", "The test assertions.", 0, java.lang.Integer.MAX_VALUE, assertions);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1349547969: /*sequence*/ return this.sequence == null ? new Base[0] : new Base[] {this.sequence}; // IntegerType
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : this.scope.toArray(new Base[this.scope.size()]); // Reference
        case 503774505: /*dependencies*/ return this.dependencies == null ? new Base[0] : this.dependencies.toArray(new Base[this.dependencies.size()]); // TestPlanTestCaseDependenciesComponent
        case -1422467943: /*testRun*/ return this.testRun == null ? new Base[0] : this.testRun.toArray(new Base[this.testRun.size()]); // Reference
        case -1147269284: /*testData*/ return this.testData == null ? new Base[0] : this.testData.toArray(new Base[this.testData.size()]); // TestPlanTestCaseTestDataComponent
        case 2091567537: /*assertions*/ return this.assertions == null ? new Base[0] : this.assertions.toArray(new Base[this.assertions.size()]); // TestPlanTestCaseAssertionsComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1349547969: // sequence
          this.sequence = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 109264468: // scope
          this.getScope().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 503774505: // dependencies
          this.getDependencies().add((TestPlanTestCaseDependenciesComponent) value); // TestPlanTestCaseDependenciesComponent
          return value;
        case -1422467943: // testRun
          this.getTestRun().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1147269284: // testData
          this.getTestData().add((TestPlanTestCaseTestDataComponent) value); // TestPlanTestCaseTestDataComponent
          return value;
        case 2091567537: // assertions
          this.getAssertions().add((TestPlanTestCaseAssertionsComponent) value); // TestPlanTestCaseAssertionsComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("sequence")) {
          this.sequence = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("scope")) {
          this.getScope().add(TypeConvertor.castToReference(value));
        } else if (name.equals("dependencies")) {
          this.getDependencies().add((TestPlanTestCaseDependenciesComponent) value);
        } else if (name.equals("testRun")) {
          this.getTestRun().add(TypeConvertor.castToReference(value));
        } else if (name.equals("testData")) {
          this.getTestData().add((TestPlanTestCaseTestDataComponent) value);
        } else if (name.equals("assertions")) {
          this.getAssertions().add((TestPlanTestCaseAssertionsComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1349547969:  return getSequenceElement();
        case 109264468:  return addScope(); 
        case 503774505:  return addDependencies(); 
        case -1422467943:  return addTestRun(); 
        case -1147269284:  return addTestData(); 
        case 2091567537:  return addAssertions(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1349547969: /*sequence*/ return new String[] {"integer"};
        case 109264468: /*scope*/ return new String[] {"Reference"};
        case 503774505: /*dependencies*/ return new String[] {};
        case -1422467943: /*testRun*/ return new String[] {"Reference"};
        case -1147269284: /*testData*/ return new String[] {};
        case 2091567537: /*assertions*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("sequence")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.testCase.sequence");
        }
        else if (name.equals("scope")) {
          return addScope();
        }
        else if (name.equals("dependencies")) {
          return addDependencies();
        }
        else if (name.equals("testRun")) {
          return addTestRun();
        }
        else if (name.equals("testData")) {
          return addTestData();
        }
        else if (name.equals("assertions")) {
          return addAssertions();
        }
        else
          return super.addChild(name);
      }

      public TestPlanTestCaseComponent copy() {
        TestPlanTestCaseComponent dst = new TestPlanTestCaseComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseComponent dst) {
        super.copyValues(dst);
        dst.sequence = sequence == null ? null : sequence.copy();
        if (scope != null) {
          dst.scope = new ArrayList<Reference>();
          for (Reference i : scope)
            dst.scope.add(i.copy());
        };
        if (dependencies != null) {
          dst.dependencies = new ArrayList<TestPlanTestCaseDependenciesComponent>();
          for (TestPlanTestCaseDependenciesComponent i : dependencies)
            dst.dependencies.add(i.copy());
        };
        if (testRun != null) {
          dst.testRun = new ArrayList<Reference>();
          for (Reference i : testRun)
            dst.testRun.add(i.copy());
        };
        if (testData != null) {
          dst.testData = new ArrayList<TestPlanTestCaseTestDataComponent>();
          for (TestPlanTestCaseTestDataComponent i : testData)
            dst.testData.add(i.copy());
        };
        if (assertions != null) {
          dst.assertions = new ArrayList<TestPlanTestCaseAssertionsComponent>();
          for (TestPlanTestCaseAssertionsComponent i : assertions)
            dst.assertions.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseComponent))
          return false;
        TestPlanTestCaseComponent o = (TestPlanTestCaseComponent) other_;
        return compareDeep(sequence, o.sequence, true) && compareDeep(scope, o.scope, true) && compareDeep(dependencies, o.dependencies, true)
           && compareDeep(testRun, o.testRun, true) && compareDeep(testData, o.testData, true) && compareDeep(assertions, o.assertions, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseComponent))
          return false;
        TestPlanTestCaseComponent o = (TestPlanTestCaseComponent) other_;
        return compareValues(sequence, o.sequence, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(sequence, scope, dependencies
          , testRun, testData, assertions);
      }

  public String fhirType() {
    return "TestPlan.testCase";

  }

  }

    @Block()
    public static class TestPlanTestCaseDependenciesComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of the criteria.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Description of the criteria", formalDefinition="Description of the criteria." )
        protected MarkdownType description;

        /**
         * Link to predecessor test plans.
         */
        @Child(name = "predecessor", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Link to predecessor test plans", formalDefinition="Link to predecessor test plans." )
        protected Reference predecessor;

        private static final long serialVersionUID = 1630757943L;

    /**
     * Constructor
     */
      public TestPlanTestCaseDependenciesComponent() {
        super();
      }

        /**
         * @return {@link #description} (Description of the criteria.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseDependenciesComponent.description");
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
         * @param value {@link #description} (Description of the criteria.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestPlanTestCaseDependenciesComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of the criteria.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of the criteria.
         */
        public TestPlanTestCaseDependenciesComponent setDescription(String value) { 
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
         * @return {@link #predecessor} (Link to predecessor test plans.)
         */
        public Reference getPredecessor() { 
          if (this.predecessor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseDependenciesComponent.predecessor");
            else if (Configuration.doAutoCreate())
              this.predecessor = new Reference(); // cc
          return this.predecessor;
        }

        public boolean hasPredecessor() { 
          return this.predecessor != null && !this.predecessor.isEmpty();
        }

        /**
         * @param value {@link #predecessor} (Link to predecessor test plans.)
         */
        public TestPlanTestCaseDependenciesComponent setPredecessor(Reference value) { 
          this.predecessor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "Description of the criteria.", 0, 1, description));
          children.add(new Property("predecessor", "Reference", "Link to predecessor test plans.", 0, 1, predecessor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Description of the criteria.", 0, 1, description);
          case -1925032183: /*predecessor*/  return new Property("predecessor", "Reference", "Link to predecessor test plans.", 0, 1, predecessor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1925032183: /*predecessor*/ return this.predecessor == null ? new Base[0] : new Base[] {this.predecessor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1925032183: // predecessor
          this.predecessor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("predecessor")) {
          this.predecessor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case -1925032183:  return getPredecessor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1925032183: /*predecessor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.testCase.dependencies.description");
        }
        else if (name.equals("predecessor")) {
          this.predecessor = new Reference();
          return this.predecessor;
        }
        else
          return super.addChild(name);
      }

      public TestPlanTestCaseDependenciesComponent copy() {
        TestPlanTestCaseDependenciesComponent dst = new TestPlanTestCaseDependenciesComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseDependenciesComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.predecessor = predecessor == null ? null : predecessor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseDependenciesComponent))
          return false;
        TestPlanTestCaseDependenciesComponent o = (TestPlanTestCaseDependenciesComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(predecessor, o.predecessor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseDependenciesComponent))
          return false;
        TestPlanTestCaseDependenciesComponent o = (TestPlanTestCaseDependenciesComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, predecessor);
      }

  public String fhirType() {
    return "TestPlan.testCase.dependencies";

  }

  }

    @Block()
    public static class TestPlanTestCaseTestDataComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of test data description, e.g. 'synthea'.
         */
        @Child(name = "type", type = {Coding.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of test data description, e.g. 'synthea'", formalDefinition="The type of test data description, e.g. 'synthea'." )
        protected Coding type;

        /**
         * The actual test resources when they exist.
         */
        @Child(name = "content", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The actual test resources when they exist", formalDefinition="The actual test resources when they exist." )
        protected Reference content;

        /**
         * Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.
         */
        @Child(name = "source", type = {StringType.class, Reference.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc", formalDefinition="Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc." )
        protected DataType source;

        private static final long serialVersionUID = -300912813L;

    /**
     * Constructor
     */
      public TestPlanTestCaseTestDataComponent() {
        super();
      }

    /**
     * Constructor
     */
      public TestPlanTestCaseTestDataComponent(Coding type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The type of test data description, e.g. 'synthea'.)
         */
        public Coding getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseTestDataComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Coding(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of test data description, e.g. 'synthea'.)
         */
        public TestPlanTestCaseTestDataComponent setType(Coding value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #content} (The actual test resources when they exist.)
         */
        public Reference getContent() { 
          if (this.content == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseTestDataComponent.content");
            else if (Configuration.doAutoCreate())
              this.content = new Reference(); // cc
          return this.content;
        }

        public boolean hasContent() { 
          return this.content != null && !this.content.isEmpty();
        }

        /**
         * @param value {@link #content} (The actual test resources when they exist.)
         */
        public TestPlanTestCaseTestDataComponent setContent(Reference value) { 
          this.content = value;
          return this;
        }

        /**
         * @return {@link #source} (Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.)
         */
        public DataType getSource() { 
          return this.source;
        }

        /**
         * @return {@link #source} (Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.)
         */
        public StringType getSourceStringType() throws FHIRException { 
          if (this.source == null)
            this.source = new StringType();
          if (!(this.source instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.source.getClass().getName()+" was encountered");
          return (StringType) this.source;
        }

        public boolean hasSourceStringType() { 
          return this != null && this.source instanceof StringType;
        }

        /**
         * @return {@link #source} (Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.)
         */
        public Reference getSourceReference() throws FHIRException { 
          if (this.source == null)
            this.source = new Reference();
          if (!(this.source instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.source.getClass().getName()+" was encountered");
          return (Reference) this.source;
        }

        public boolean hasSourceReference() { 
          return this != null && this.source instanceof Reference;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.)
         */
        public TestPlanTestCaseTestDataComponent setSource(DataType value) { 
          if (value != null && !(value instanceof StringType || value instanceof Reference))
            throw new Error("Not the right type for TestPlan.testCase.testData.source[x]: "+value.fhirType());
          this.source = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "Coding", "The type of test data description, e.g. 'synthea'.", 0, 1, type));
          children.add(new Property("content", "Reference", "The actual test resources when they exist.", 0, 1, content));
          children.add(new Property("source[x]", "string|Reference", "Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.", 0, 1, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "Coding", "The type of test data description, e.g. 'synthea'.", 0, 1, type);
          case 951530617: /*content*/  return new Property("content", "Reference", "The actual test resources when they exist.", 0, 1, content);
          case -1698413947: /*source[x]*/  return new Property("source[x]", "string|Reference", "Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.", 0, 1, source);
          case -896505829: /*source*/  return new Property("source[x]", "string|Reference", "Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.", 0, 1, source);
          case 1327821836: /*sourceString*/  return new Property("source[x]", "string", "Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.", 0, 1, source);
          case -244259472: /*sourceReference*/  return new Property("source[x]", "Reference", "Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.", 0, 1, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Coding
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // Reference
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCoding(value); // Coding
          return value;
        case 951530617: // content
          this.content = TypeConvertor.castToReference(value); // Reference
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCoding(value); // Coding
        } else if (name.equals("content")) {
          this.content = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("source[x]")) {
          this.source = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 951530617:  return getContent();
        case -1698413947:  return getSource();
        case -896505829:  return getSource();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"Coding"};
        case 951530617: /*content*/ return new String[] {"Reference"};
        case -896505829: /*source*/ return new String[] {"string", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new Coding();
          return this.type;
        }
        else if (name.equals("content")) {
          this.content = new Reference();
          return this.content;
        }
        else if (name.equals("sourceString")) {
          this.source = new StringType();
          return this.source;
        }
        else if (name.equals("sourceReference")) {
          this.source = new Reference();
          return this.source;
        }
        else
          return super.addChild(name);
      }

      public TestPlanTestCaseTestDataComponent copy() {
        TestPlanTestCaseTestDataComponent dst = new TestPlanTestCaseTestDataComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseTestDataComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.content = content == null ? null : content.copy();
        dst.source = source == null ? null : source.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseTestDataComponent))
          return false;
        TestPlanTestCaseTestDataComponent o = (TestPlanTestCaseTestDataComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(content, o.content, true) && compareDeep(source, o.source, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseTestDataComponent))
          return false;
        TestPlanTestCaseTestDataComponent o = (TestPlanTestCaseTestDataComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, content, source);
      }

  public String fhirType() {
    return "TestPlan.testCase.testData";

  }

  }

    @Block()
    public static class TestPlanTestCaseAssertionsComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The test assertion type.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The test assertion type", formalDefinition="The test assertion type." )
        protected List<CodeableConcept> type;

        /**
         * The focus or object of the assertion.
         */
        @Child(name = "object", type = {CodeableReference.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The focus or object of the assertion", formalDefinition="The focus or object of the assertion." )
        protected List<CodeableReference> object;

        /**
         * The test assertions.
         */
        @Child(name = "result", type = {CodeableReference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The test assertions", formalDefinition="The test assertions." )
        protected List<CodeableReference> result;

        private static final long serialVersionUID = 481177705L;

    /**
     * Constructor
     */
      public TestPlanTestCaseAssertionsComponent() {
        super();
      }

        /**
         * @return {@link #type} (The test assertion type.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseAssertionsComponent setType(List<CodeableConcept> theType) { 
          this.type = theType;
          return this;
        }

        public boolean hasType() { 
          if (this.type == null)
            return false;
          for (CodeableConcept item : this.type)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return t;
        }

        public TestPlanTestCaseAssertionsComponent addType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTypeFirstRep() { 
          if (getType().isEmpty()) {
            addType();
          }
          return getType().get(0);
        }

        /**
         * @return {@link #object} (The focus or object of the assertion.)
         */
        public List<CodeableReference> getObject() { 
          if (this.object == null)
            this.object = new ArrayList<CodeableReference>();
          return this.object;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseAssertionsComponent setObject(List<CodeableReference> theObject) { 
          this.object = theObject;
          return this;
        }

        public boolean hasObject() { 
          if (this.object == null)
            return false;
          for (CodeableReference item : this.object)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addObject() { //3
          CodeableReference t = new CodeableReference();
          if (this.object == null)
            this.object = new ArrayList<CodeableReference>();
          this.object.add(t);
          return t;
        }

        public TestPlanTestCaseAssertionsComponent addObject(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.object == null)
            this.object = new ArrayList<CodeableReference>();
          this.object.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #object}, creating it if it does not already exist {3}
         */
        public CodeableReference getObjectFirstRep() { 
          if (getObject().isEmpty()) {
            addObject();
          }
          return getObject().get(0);
        }

        /**
         * @return {@link #result} (The test assertions.)
         */
        public List<CodeableReference> getResult() { 
          if (this.result == null)
            this.result = new ArrayList<CodeableReference>();
          return this.result;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseAssertionsComponent setResult(List<CodeableReference> theResult) { 
          this.result = theResult;
          return this;
        }

        public boolean hasResult() { 
          if (this.result == null)
            return false;
          for (CodeableReference item : this.result)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addResult() { //3
          CodeableReference t = new CodeableReference();
          if (this.result == null)
            this.result = new ArrayList<CodeableReference>();
          this.result.add(t);
          return t;
        }

        public TestPlanTestCaseAssertionsComponent addResult(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.result == null)
            this.result = new ArrayList<CodeableReference>();
          this.result.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #result}, creating it if it does not already exist {3}
         */
        public CodeableReference getResultFirstRep() { 
          if (getResult().isEmpty()) {
            addResult();
          }
          return getResult().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The test assertion type.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("object", "CodeableReference", "The focus or object of the assertion.", 0, java.lang.Integer.MAX_VALUE, object));
          children.add(new Property("result", "CodeableReference", "The test assertions.", 0, java.lang.Integer.MAX_VALUE, result));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The test assertion type.", 0, java.lang.Integer.MAX_VALUE, type);
          case -1023368385: /*object*/  return new Property("object", "CodeableReference", "The focus or object of the assertion.", 0, java.lang.Integer.MAX_VALUE, object);
          case -934426595: /*result*/  return new Property("result", "CodeableReference", "The test assertions.", 0, java.lang.Integer.MAX_VALUE, result);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1023368385: /*object*/ return this.object == null ? new Base[0] : this.object.toArray(new Base[this.object.size()]); // CodeableReference
        case -934426595: /*result*/ return this.result == null ? new Base[0] : this.result.toArray(new Base[this.result.size()]); // CodeableReference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1023368385: // object
          this.getObject().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -934426595: // result
          this.getResult().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("object")) {
          this.getObject().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("result")) {
          this.getResult().add(TypeConvertor.castToCodeableReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return addType(); 
        case -1023368385:  return addObject(); 
        case -934426595:  return addResult(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1023368385: /*object*/ return new String[] {"CodeableReference"};
        case -934426595: /*result*/ return new String[] {"CodeableReference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("object")) {
          return addObject();
        }
        else if (name.equals("result")) {
          return addResult();
        }
        else
          return super.addChild(name);
      }

      public TestPlanTestCaseAssertionsComponent copy() {
        TestPlanTestCaseAssertionsComponent dst = new TestPlanTestCaseAssertionsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseAssertionsComponent dst) {
        super.copyValues(dst);
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (object != null) {
          dst.object = new ArrayList<CodeableReference>();
          for (CodeableReference i : object)
            dst.object.add(i.copy());
        };
        if (result != null) {
          dst.result = new ArrayList<CodeableReference>();
          for (CodeableReference i : result)
            dst.result.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseAssertionsComponent))
          return false;
        TestPlanTestCaseAssertionsComponent o = (TestPlanTestCaseAssertionsComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(object, o.object, true) && compareDeep(result, o.result, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseAssertionsComponent))
          return false;
        TestPlanTestCaseAssertionsComponent o = (TestPlanTestCaseAssertionsComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, object, result);
      }

  public String fhirType() {
    return "TestPlan.testCase.assertions";

  }

  }

    /**
     * Canonical identifier URL.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier URL", formalDefinition="Canonical identifier URL." )
    protected UriType url;

    /**
     * Business identifier for the Test Plan.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier", formalDefinition="Business identifier for the Test Plan." )
    protected List<Identifier> identifier;

    /**
     * Version of the test plan.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Version", formalDefinition="Version of the test plan." )
    protected List<StringType> version;

    /**
     * Name.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Name", formalDefinition="Name." )
    protected List<StringType> name;

    /**
     * Human-readable title.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Human-readable title", formalDefinition="Human-readable title." )
    protected List<StringType> title;

    /**
     * Status.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="Status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected List<Enumeration<PublicationStatus>> status;

    /**
     * Date.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Date", formalDefinition="Date." )
    protected List<DateTimeType> date;

    /**
     * Publisher.
     */
    @Child(name = "publisher", type = {StringType.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Publisher", formalDefinition="Publisher." )
    protected List<StringType> publisher;

    /**
     * Contact.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact", formalDefinition="Contact." )
    protected List<ContactDetail> contact;

    /**
     * Description of the test plan.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Description", formalDefinition="Description of the test plan." )
    protected MarkdownType description;

    /**
     * Jurisdiction.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Jurisdiction", formalDefinition="Jurisdiction." )
    protected List<CodeableConcept> jurisdiction;

    /**
     * Purpose.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Purpose", formalDefinition="Purpose." )
    protected MarkdownType purpose;

    /**
     * Copyright.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Copyright", formalDefinition="Copyright." )
    protected MarkdownType copyright;

    /**
     * The category of the Test Plan - can be acceptance, unit, performance, etc.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The category of the Test Plan - can be acceptance, unit, performance", formalDefinition="The category of the Test Plan - can be acceptance, unit, performance, etc." )
    protected List<CodeableConcept> category;

    /**
     * What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...
     */
    @Child(name = "scope", type = {Reference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference", formalDefinition="What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference..." )
    protected List<Reference> scope;

    /**
     * A description of test tools to be used in the test plan.
     */
    @Child(name = "testTools", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A description of test tools to be used in the test plan - narrative for now", formalDefinition="A description of test tools to be used in the test plan." )
    protected MarkdownType testTools;

    /**
     * The required criteria to execute the test plan - e.g. preconditions, previous tests...
     */
    @Child(name = "dependencies", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The required criteria to execute the test plan - e.g. preconditions, previous tests", formalDefinition="The required criteria to execute the test plan - e.g. preconditions, previous tests..." )
    protected List<TestPlanDependenciesComponent> dependencies;

    /**
     * The threshold or criteria for the test plan to be considered successfully executed - narrative.
     */
    @Child(name = "exitCriteria", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The threshold or criteria for the test plan to be considered successfully executed - narrative", formalDefinition="The threshold or criteria for the test plan to be considered successfully executed - narrative." )
    protected MarkdownType exitCriteria;

    /**
     * The test cases that are part of this plan.
     */
    @Child(name = "testCase", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The test cases that are part of this plan", formalDefinition="The test cases that are part of this plan." )
    protected List<TestPlanTestCaseComponent> testCase;

    private static final long serialVersionUID = -1697495171L;

  /**
   * Constructor
   */
    public TestPlan() {
      super();
    }

    /**
     * @return {@link #url} (Canonical identifier URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.url");
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
     * @param value {@link #url} (Canonical identifier URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public TestPlan setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return Canonical identifier URL.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value Canonical identifier URL.
     */
    public TestPlan setUrl(String value) { 
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
     * @return {@link #identifier} (Business identifier for the Test Plan.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setIdentifier(List<Identifier> theIdentifier) { 
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

    public TestPlan addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (Version of the test plan.)
     */
    public List<StringType> getVersion() { 
      if (this.version == null)
        this.version = new ArrayList<StringType>();
      return this.version;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setVersion(List<StringType> theVersion) { 
      this.version = theVersion;
      return this;
    }

    public boolean hasVersion() { 
      if (this.version == null)
        return false;
      for (StringType item : this.version)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #version} (Version of the test plan.)
     */
    public StringType addVersionElement() {//2 
      StringType t = new StringType();
      if (this.version == null)
        this.version = new ArrayList<StringType>();
      this.version.add(t);
      return t;
    }

    /**
     * @param value {@link #version} (Version of the test plan.)
     */
    public TestPlan addVersion(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.version == null)
        this.version = new ArrayList<StringType>();
      this.version.add(t);
      return this;
    }

    /**
     * @param value {@link #version} (Version of the test plan.)
     */
    public boolean hasVersion(String value) { 
      if (this.version == null)
        return false;
      for (StringType v : this.version)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #name} (Name.)
     */
    public List<StringType> getName() { 
      if (this.name == null)
        this.name = new ArrayList<StringType>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setName(List<StringType> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (StringType item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #name} (Name.)
     */
    public StringType addNameElement() {//2 
      StringType t = new StringType();
      if (this.name == null)
        this.name = new ArrayList<StringType>();
      this.name.add(t);
      return t;
    }

    /**
     * @param value {@link #name} (Name.)
     */
    public TestPlan addName(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.name == null)
        this.name = new ArrayList<StringType>();
      this.name.add(t);
      return this;
    }

    /**
     * @param value {@link #name} (Name.)
     */
    public boolean hasName(String value) { 
      if (this.name == null)
        return false;
      for (StringType v : this.name)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #title} (Human-readable title.)
     */
    public List<StringType> getTitle() { 
      if (this.title == null)
        this.title = new ArrayList<StringType>();
      return this.title;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setTitle(List<StringType> theTitle) { 
      this.title = theTitle;
      return this;
    }

    public boolean hasTitle() { 
      if (this.title == null)
        return false;
      for (StringType item : this.title)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #title} (Human-readable title.)
     */
    public StringType addTitleElement() {//2 
      StringType t = new StringType();
      if (this.title == null)
        this.title = new ArrayList<StringType>();
      this.title.add(t);
      return t;
    }

    /**
     * @param value {@link #title} (Human-readable title.)
     */
    public TestPlan addTitle(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.title == null)
        this.title = new ArrayList<StringType>();
      this.title.add(t);
      return this;
    }

    /**
     * @param value {@link #title} (Human-readable title.)
     */
    public boolean hasTitle(String value) { 
      if (this.title == null)
        return false;
      for (StringType v : this.title)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #status} (Status.)
     */
    public List<Enumeration<PublicationStatus>> getStatus() { 
      if (this.status == null)
        this.status = new ArrayList<Enumeration<PublicationStatus>>();
      return this.status;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setStatus(List<Enumeration<PublicationStatus>> theStatus) { 
      this.status = theStatus;
      return this;
    }

    public boolean hasStatus() { 
      if (this.status == null)
        return false;
      for (Enumeration<PublicationStatus> item : this.status)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #status} (Status.)
     */
    public Enumeration<PublicationStatus> addStatusElement() {//2 
      Enumeration<PublicationStatus> t = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
      if (this.status == null)
        this.status = new ArrayList<Enumeration<PublicationStatus>>();
      this.status.add(t);
      return t;
    }

    /**
     * @param value {@link #status} (Status.)
     */
    public TestPlan addStatus(PublicationStatus value) { //1
      Enumeration<PublicationStatus> t = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
      t.setValue(value);
      if (this.status == null)
        this.status = new ArrayList<Enumeration<PublicationStatus>>();
      this.status.add(t);
      return this;
    }

    /**
     * @param value {@link #status} (Status.)
     */
    public boolean hasStatus(PublicationStatus value) { 
      if (this.status == null)
        return false;
      for (Enumeration<PublicationStatus> v : this.status)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #date} (Date.)
     */
    public List<DateTimeType> getDate() { 
      if (this.date == null)
        this.date = new ArrayList<DateTimeType>();
      return this.date;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setDate(List<DateTimeType> theDate) { 
      this.date = theDate;
      return this;
    }

    public boolean hasDate() { 
      if (this.date == null)
        return false;
      for (DateTimeType item : this.date)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #date} (Date.)
     */
    public DateTimeType addDateElement() {//2 
      DateTimeType t = new DateTimeType();
      if (this.date == null)
        this.date = new ArrayList<DateTimeType>();
      this.date.add(t);
      return t;
    }

    /**
     * @param value {@link #date} (Date.)
     */
    public TestPlan addDate(Date value) { //1
      DateTimeType t = new DateTimeType();
      t.setValue(value);
      if (this.date == null)
        this.date = new ArrayList<DateTimeType>();
      this.date.add(t);
      return this;
    }

    /**
     * @param value {@link #date} (Date.)
     */
    public boolean hasDate(Date value) { 
      if (this.date == null)
        return false;
      for (DateTimeType v : this.date)
        if (v.getValue().equals(value)) // dateTime
          return true;
      return false;
    }

    /**
     * @return {@link #publisher} (Publisher.)
     */
    public List<StringType> getPublisher() { 
      if (this.publisher == null)
        this.publisher = new ArrayList<StringType>();
      return this.publisher;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setPublisher(List<StringType> thePublisher) { 
      this.publisher = thePublisher;
      return this;
    }

    public boolean hasPublisher() { 
      if (this.publisher == null)
        return false;
      for (StringType item : this.publisher)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #publisher} (Publisher.)
     */
    public StringType addPublisherElement() {//2 
      StringType t = new StringType();
      if (this.publisher == null)
        this.publisher = new ArrayList<StringType>();
      this.publisher.add(t);
      return t;
    }

    /**
     * @param value {@link #publisher} (Publisher.)
     */
    public TestPlan addPublisher(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.publisher == null)
        this.publisher = new ArrayList<StringType>();
      this.publisher.add(t);
      return this;
    }

    /**
     * @param value {@link #publisher} (Publisher.)
     */
    public boolean hasPublisher(String value) { 
      if (this.publisher == null)
        return false;
      for (StringType v : this.publisher)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #contact} (Contact.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setContact(List<ContactDetail> theContact) { 
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

    public TestPlan addContact(ContactDetail t) { //3
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
     * @return {@link #description} (Description of the test plan.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.description");
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
     * @param value {@link #description} (Description of the test plan.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public TestPlan setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Description of the test plan.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Description of the test plan.
     */
    public TestPlan setDescription(String value) { 
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
     * @return {@link #jurisdiction} (Jurisdiction.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public TestPlan addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Purpose.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.purpose");
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
     * @param value {@link #purpose} (Purpose.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public TestPlan setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Purpose.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Purpose.
     */
    public TestPlan setPurpose(String value) { 
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
     * @return {@link #copyright} (Copyright.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.copyright");
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
     * @param value {@link #copyright} (Copyright.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public TestPlan setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return Copyright.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Copyright.
     */
    public TestPlan setCopyright(String value) { 
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
     * @return {@link #category} (The category of the Test Plan - can be acceptance, unit, performance, etc.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public TestPlan addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #scope} (What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...)
     */
    public List<Reference> getScope() { 
      if (this.scope == null)
        this.scope = new ArrayList<Reference>();
      return this.scope;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setScope(List<Reference> theScope) { 
      this.scope = theScope;
      return this;
    }

    public boolean hasScope() { 
      if (this.scope == null)
        return false;
      for (Reference item : this.scope)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addScope() { //3
      Reference t = new Reference();
      if (this.scope == null)
        this.scope = new ArrayList<Reference>();
      this.scope.add(t);
      return t;
    }

    public TestPlan addScope(Reference t) { //3
      if (t == null)
        return this;
      if (this.scope == null)
        this.scope = new ArrayList<Reference>();
      this.scope.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #scope}, creating it if it does not already exist {3}
     */
    public Reference getScopeFirstRep() { 
      if (getScope().isEmpty()) {
        addScope();
      }
      return getScope().get(0);
    }

    /**
     * @return {@link #testTools} (A description of test tools to be used in the test plan.). This is the underlying object with id, value and extensions. The accessor "getTestTools" gives direct access to the value
     */
    public MarkdownType getTestToolsElement() { 
      if (this.testTools == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.testTools");
        else if (Configuration.doAutoCreate())
          this.testTools = new MarkdownType(); // bb
      return this.testTools;
    }

    public boolean hasTestToolsElement() { 
      return this.testTools != null && !this.testTools.isEmpty();
    }

    public boolean hasTestTools() { 
      return this.testTools != null && !this.testTools.isEmpty();
    }

    /**
     * @param value {@link #testTools} (A description of test tools to be used in the test plan.). This is the underlying object with id, value and extensions. The accessor "getTestTools" gives direct access to the value
     */
    public TestPlan setTestToolsElement(MarkdownType value) { 
      this.testTools = value;
      return this;
    }

    /**
     * @return A description of test tools to be used in the test plan.
     */
    public String getTestTools() { 
      return this.testTools == null ? null : this.testTools.getValue();
    }

    /**
     * @param value A description of test tools to be used in the test plan.
     */
    public TestPlan setTestTools(String value) { 
      if (Utilities.noString(value))
        this.testTools = null;
      else {
        if (this.testTools == null)
          this.testTools = new MarkdownType();
        this.testTools.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #dependencies} (The required criteria to execute the test plan - e.g. preconditions, previous tests...)
     */
    public List<TestPlanDependenciesComponent> getDependencies() { 
      if (this.dependencies == null)
        this.dependencies = new ArrayList<TestPlanDependenciesComponent>();
      return this.dependencies;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setDependencies(List<TestPlanDependenciesComponent> theDependencies) { 
      this.dependencies = theDependencies;
      return this;
    }

    public boolean hasDependencies() { 
      if (this.dependencies == null)
        return false;
      for (TestPlanDependenciesComponent item : this.dependencies)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestPlanDependenciesComponent addDependencies() { //3
      TestPlanDependenciesComponent t = new TestPlanDependenciesComponent();
      if (this.dependencies == null)
        this.dependencies = new ArrayList<TestPlanDependenciesComponent>();
      this.dependencies.add(t);
      return t;
    }

    public TestPlan addDependencies(TestPlanDependenciesComponent t) { //3
      if (t == null)
        return this;
      if (this.dependencies == null)
        this.dependencies = new ArrayList<TestPlanDependenciesComponent>();
      this.dependencies.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dependencies}, creating it if it does not already exist {3}
     */
    public TestPlanDependenciesComponent getDependenciesFirstRep() { 
      if (getDependencies().isEmpty()) {
        addDependencies();
      }
      return getDependencies().get(0);
    }

    /**
     * @return {@link #exitCriteria} (The threshold or criteria for the test plan to be considered successfully executed - narrative.). This is the underlying object with id, value and extensions. The accessor "getExitCriteria" gives direct access to the value
     */
    public MarkdownType getExitCriteriaElement() { 
      if (this.exitCriteria == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.exitCriteria");
        else if (Configuration.doAutoCreate())
          this.exitCriteria = new MarkdownType(); // bb
      return this.exitCriteria;
    }

    public boolean hasExitCriteriaElement() { 
      return this.exitCriteria != null && !this.exitCriteria.isEmpty();
    }

    public boolean hasExitCriteria() { 
      return this.exitCriteria != null && !this.exitCriteria.isEmpty();
    }

    /**
     * @param value {@link #exitCriteria} (The threshold or criteria for the test plan to be considered successfully executed - narrative.). This is the underlying object with id, value and extensions. The accessor "getExitCriteria" gives direct access to the value
     */
    public TestPlan setExitCriteriaElement(MarkdownType value) { 
      this.exitCriteria = value;
      return this;
    }

    /**
     * @return The threshold or criteria for the test plan to be considered successfully executed - narrative.
     */
    public String getExitCriteria() { 
      return this.exitCriteria == null ? null : this.exitCriteria.getValue();
    }

    /**
     * @param value The threshold or criteria for the test plan to be considered successfully executed - narrative.
     */
    public TestPlan setExitCriteria(String value) { 
      if (Utilities.noString(value))
        this.exitCriteria = null;
      else {
        if (this.exitCriteria == null)
          this.exitCriteria = new MarkdownType();
        this.exitCriteria.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #testCase} (The test cases that are part of this plan.)
     */
    public List<TestPlanTestCaseComponent> getTestCase() { 
      if (this.testCase == null)
        this.testCase = new ArrayList<TestPlanTestCaseComponent>();
      return this.testCase;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setTestCase(List<TestPlanTestCaseComponent> theTestCase) { 
      this.testCase = theTestCase;
      return this;
    }

    public boolean hasTestCase() { 
      if (this.testCase == null)
        return false;
      for (TestPlanTestCaseComponent item : this.testCase)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestPlanTestCaseComponent addTestCase() { //3
      TestPlanTestCaseComponent t = new TestPlanTestCaseComponent();
      if (this.testCase == null)
        this.testCase = new ArrayList<TestPlanTestCaseComponent>();
      this.testCase.add(t);
      return t;
    }

    public TestPlan addTestCase(TestPlanTestCaseComponent t) { //3
      if (t == null)
        return this;
      if (this.testCase == null)
        this.testCase = new ArrayList<TestPlanTestCaseComponent>();
      this.testCase.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #testCase}, creating it if it does not already exist {3}
     */
    public TestPlanTestCaseComponent getTestCaseFirstRep() { 
      if (getTestCase().isEmpty()) {
        addTestCase();
      }
      return getTestCase().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "Canonical identifier URL.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "Business identifier for the Test Plan.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "Version of the test plan.", 0, java.lang.Integer.MAX_VALUE, version));
        children.add(new Property("name", "string", "Name.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("title", "string", "Human-readable title.", 0, java.lang.Integer.MAX_VALUE, title));
        children.add(new Property("status", "code", "Status.", 0, java.lang.Integer.MAX_VALUE, status));
        children.add(new Property("date", "dateTime", "Date.", 0, java.lang.Integer.MAX_VALUE, date));
        children.add(new Property("publisher", "string", "Publisher.", 0, java.lang.Integer.MAX_VALUE, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "Description of the test plan.", 0, 1, description));
        children.add(new Property("jurisdiction", "CodeableConcept", "Jurisdiction.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Purpose.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "Copyright.", 0, 1, copyright));
        children.add(new Property("category", "CodeableConcept", "The category of the Test Plan - can be acceptance, unit, performance, etc.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("scope", "Reference", "What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...", 0, java.lang.Integer.MAX_VALUE, scope));
        children.add(new Property("testTools", "markdown", "A description of test tools to be used in the test plan.", 0, 1, testTools));
        children.add(new Property("dependencies", "", "The required criteria to execute the test plan - e.g. preconditions, previous tests...", 0, java.lang.Integer.MAX_VALUE, dependencies));
        children.add(new Property("exitCriteria", "markdown", "The threshold or criteria for the test plan to be considered successfully executed - narrative.", 0, 1, exitCriteria));
        children.add(new Property("testCase", "", "The test cases that are part of this plan.", 0, java.lang.Integer.MAX_VALUE, testCase));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "Canonical identifier URL.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for the Test Plan.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "Version of the test plan.", 0, java.lang.Integer.MAX_VALUE, version);
        case 3373707: /*name*/  return new Property("name", "string", "Name.", 0, java.lang.Integer.MAX_VALUE, name);
        case 110371416: /*title*/  return new Property("title", "string", "Human-readable title.", 0, java.lang.Integer.MAX_VALUE, title);
        case -892481550: /*status*/  return new Property("status", "code", "Status.", 0, java.lang.Integer.MAX_VALUE, status);
        case 3076014: /*date*/  return new Property("date", "dateTime", "Date.", 0, java.lang.Integer.MAX_VALUE, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "Publisher.", 0, java.lang.Integer.MAX_VALUE, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "Description of the test plan.", 0, 1, description);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "Jurisdiction.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Purpose.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "Copyright.", 0, 1, copyright);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "The category of the Test Plan - can be acceptance, unit, performance, etc.", 0, java.lang.Integer.MAX_VALUE, category);
        case 109264468: /*scope*/  return new Property("scope", "Reference", "What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...", 0, java.lang.Integer.MAX_VALUE, scope);
        case -1190420375: /*testTools*/  return new Property("testTools", "markdown", "A description of test tools to be used in the test plan.", 0, 1, testTools);
        case 503774505: /*dependencies*/  return new Property("dependencies", "", "The required criteria to execute the test plan - e.g. preconditions, previous tests...", 0, java.lang.Integer.MAX_VALUE, dependencies);
        case -1382023523: /*exitCriteria*/  return new Property("exitCriteria", "markdown", "The threshold or criteria for the test plan to be considered successfully executed - narrative.", 0, 1, exitCriteria);
        case -1147299102: /*testCase*/  return new Property("testCase", "", "The test cases that are part of this plan.", 0, java.lang.Integer.MAX_VALUE, testCase);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : this.version.toArray(new Base[this.version.size()]); // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : this.title.toArray(new Base[this.title.size()]); // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : this.status.toArray(new Base[this.status.size()]); // Enumeration<PublicationStatus>
        case 3076014: /*date*/ return this.date == null ? new Base[0] : this.date.toArray(new Base[this.date.size()]); // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : this.publisher.toArray(new Base[this.publisher.size()]); // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : this.scope.toArray(new Base[this.scope.size()]); // Reference
        case -1190420375: /*testTools*/ return this.testTools == null ? new Base[0] : new Base[] {this.testTools}; // MarkdownType
        case 503774505: /*dependencies*/ return this.dependencies == null ? new Base[0] : this.dependencies.toArray(new Base[this.dependencies.size()]); // TestPlanDependenciesComponent
        case -1382023523: /*exitCriteria*/ return this.exitCriteria == null ? new Base[0] : new Base[] {this.exitCriteria}; // MarkdownType
        case -1147299102: /*testCase*/ return this.testCase == null ? new Base[0] : this.testCase.toArray(new Base[this.testCase.size()]); // TestPlanTestCaseComponent
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
          this.getVersion().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 3373707: // name
          this.getName().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 110371416: // title
          this.getTitle().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getStatus().add((Enumeration) value); // Enumeration<PublicationStatus>
          return value;
        case 3076014: // date
          this.getDate().add(TypeConvertor.castToDateTime(value)); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.getPublisher().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
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
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 109264468: // scope
          this.getScope().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1190420375: // testTools
          this.testTools = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 503774505: // dependencies
          this.getDependencies().add((TestPlanDependenciesComponent) value); // TestPlanDependenciesComponent
          return value;
        case -1382023523: // exitCriteria
          this.exitCriteria = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1147299102: // testCase
          this.getTestCase().add((TestPlanTestCaseComponent) value); // TestPlanTestCaseComponent
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
          this.getVersion().add(TypeConvertor.castToString(value));
        } else if (name.equals("name")) {
          this.getName().add(TypeConvertor.castToString(value));
        } else if (name.equals("title")) {
          this.getTitle().add(TypeConvertor.castToString(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.getStatus().add((Enumeration) value);
        } else if (name.equals("date")) {
          this.getDate().add(TypeConvertor.castToDateTime(value));
        } else if (name.equals("publisher")) {
          this.getPublisher().add(TypeConvertor.castToString(value));
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("scope")) {
          this.getScope().add(TypeConvertor.castToReference(value));
        } else if (name.equals("testTools")) {
          this.testTools = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("dependencies")) {
          this.getDependencies().add((TestPlanDependenciesComponent) value);
        } else if (name.equals("exitCriteria")) {
          this.exitCriteria = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("testCase")) {
          this.getTestCase().add((TestPlanTestCaseComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return addVersionElement();
        case 3373707:  return addNameElement();
        case 110371416:  return addTitleElement();
        case -892481550:  return addStatusElement();
        case 3076014:  return addDateElement();
        case 1447404028:  return addPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 50511102:  return addCategory(); 
        case 109264468:  return addScope(); 
        case -1190420375:  return getTestToolsElement();
        case 503774505:  return addDependencies(); 
        case -1382023523:  return getExitCriteriaElement();
        case -1147299102:  return addTestCase(); 
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
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 109264468: /*scope*/ return new String[] {"Reference"};
        case -1190420375: /*testTools*/ return new String[] {"markdown"};
        case 503774505: /*dependencies*/ return new String[] {};
        case -1382023523: /*exitCriteria*/ return new String[] {"markdown"};
        case -1147299102: /*testCase*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.status");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.description");
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.copyright");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("scope")) {
          return addScope();
        }
        else if (name.equals("testTools")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.testTools");
        }
        else if (name.equals("dependencies")) {
          return addDependencies();
        }
        else if (name.equals("exitCriteria")) {
          throw new FHIRException("Cannot call addChild on a primitive type TestPlan.exitCriteria");
        }
        else if (name.equals("testCase")) {
          return addTestCase();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "TestPlan";

  }

      public TestPlan copy() {
        TestPlan dst = new TestPlan();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlan dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (version != null) {
          dst.version = new ArrayList<StringType>();
          for (StringType i : version)
            dst.version.add(i.copy());
        };
        if (name != null) {
          dst.name = new ArrayList<StringType>();
          for (StringType i : name)
            dst.name.add(i.copy());
        };
        if (title != null) {
          dst.title = new ArrayList<StringType>();
          for (StringType i : title)
            dst.title.add(i.copy());
        };
        if (status != null) {
          dst.status = new ArrayList<Enumeration<PublicationStatus>>();
          for (Enumeration<PublicationStatus> i : status)
            dst.status.add(i.copy());
        };
        if (date != null) {
          dst.date = new ArrayList<DateTimeType>();
          for (DateTimeType i : date)
            dst.date.add(i.copy());
        };
        if (publisher != null) {
          dst.publisher = new ArrayList<StringType>();
          for (StringType i : publisher)
            dst.publisher.add(i.copy());
        };
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        if (scope != null) {
          dst.scope = new ArrayList<Reference>();
          for (Reference i : scope)
            dst.scope.add(i.copy());
        };
        dst.testTools = testTools == null ? null : testTools.copy();
        if (dependencies != null) {
          dst.dependencies = new ArrayList<TestPlanDependenciesComponent>();
          for (TestPlanDependenciesComponent i : dependencies)
            dst.dependencies.add(i.copy());
        };
        dst.exitCriteria = exitCriteria == null ? null : exitCriteria.copy();
        if (testCase != null) {
          dst.testCase = new ArrayList<TestPlanTestCaseComponent>();
          for (TestPlanTestCaseComponent i : testCase)
            dst.testCase.add(i.copy());
        };
      }

      protected TestPlan typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlan))
          return false;
        TestPlan o = (TestPlan) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(status, o.status, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(category, o.category, true)
           && compareDeep(scope, o.scope, true) && compareDeep(testTools, o.testTools, true) && compareDeep(dependencies, o.dependencies, true)
           && compareDeep(exitCriteria, o.exitCriteria, true) && compareDeep(testCase, o.testCase, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlan))
          return false;
        TestPlan o = (TestPlan) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(date, o.date, true)
           && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true)
           && compareValues(copyright, o.copyright, true) && compareValues(testTools, o.testTools, true) && compareValues(exitCriteria, o.exitCriteria, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, status, date, publisher, contact, description, jurisdiction, purpose
          , copyright, category, scope, testTools, dependencies, exitCriteria, testCase
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.TestPlan;
   }


}

