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
 * A plan for executing testing on an artifact or specifications
 */
@ResourceDef(name="TestPlan", profile="http://hl7.org/fhir/StructureDefinition/TestPlan")
public class TestPlan extends CanonicalResource {

    @Block()
    public static class TestPlanDependencyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A textual description of the criterium - what is needed for the dependency to be considered met.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the dependency criterium", formalDefinition="A textual description of the criterium - what is needed for the dependency to be considered met." )
        protected MarkdownType description;

        /**
         * Predecessor test plans - those that are expected to be successfully performed as a dependency for the execution of this test plan.
         */
        @Child(name = "predecessor", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Link to predecessor test plans", formalDefinition="Predecessor test plans - those that are expected to be successfully performed as a dependency for the execution of this test plan." )
        protected Reference predecessor;

        private static final long serialVersionUID = 1630757943L;

    /**
     * Constructor
     */
      public TestPlanDependencyComponent() {
        super();
      }

        /**
         * @return {@link #description} (A textual description of the criterium - what is needed for the dependency to be considered met.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanDependencyComponent.description");
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
         * @param value {@link #description} (A textual description of the criterium - what is needed for the dependency to be considered met.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public TestPlanDependencyComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A textual description of the criterium - what is needed for the dependency to be considered met.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A textual description of the criterium - what is needed for the dependency to be considered met.
         */
        public TestPlanDependencyComponent setDescription(String value) { 
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
         * @return {@link #predecessor} (Predecessor test plans - those that are expected to be successfully performed as a dependency for the execution of this test plan.)
         */
        public Reference getPredecessor() { 
          if (this.predecessor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanDependencyComponent.predecessor");
            else if (Configuration.doAutoCreate())
              this.predecessor = new Reference(); // cc
          return this.predecessor;
        }

        public boolean hasPredecessor() { 
          return this.predecessor != null && !this.predecessor.isEmpty();
        }

        /**
         * @param value {@link #predecessor} (Predecessor test plans - those that are expected to be successfully performed as a dependency for the execution of this test plan.)
         */
        public TestPlanDependencyComponent setPredecessor(Reference value) { 
          this.predecessor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "A textual description of the criterium - what is needed for the dependency to be considered met.", 0, 1, description));
          children.add(new Property("predecessor", "Reference", "Predecessor test plans - those that are expected to be successfully performed as a dependency for the execution of this test plan.", 0, 1, predecessor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "A textual description of the criterium - what is needed for the dependency to be considered met.", 0, 1, description);
          case -1925032183: /*predecessor*/  return new Property("predecessor", "Reference", "Predecessor test plans - those that are expected to be successfully performed as a dependency for the execution of this test plan.", 0, 1, predecessor);
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
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.dependency.description");
        }
        else if (name.equals("predecessor")) {
          this.predecessor = new Reference();
          return this.predecessor;
        }
        else
          return super.addChild(name);
      }

      public TestPlanDependencyComponent copy() {
        TestPlanDependencyComponent dst = new TestPlanDependencyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanDependencyComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.predecessor = predecessor == null ? null : predecessor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanDependencyComponent))
          return false;
        TestPlanDependencyComponent o = (TestPlanDependencyComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(predecessor, o.predecessor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanDependencyComponent))
          return false;
        TestPlanDependencyComponent o = (TestPlanDependencyComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, predecessor);
      }

  public String fhirType() {
    return "TestPlan.dependency";

  }

  }

    @Block()
    public static class TestPlanTestCaseComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.
         */
        @Child(name = "sequence", type = {IntegerType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Sequence of test case in the test plan", formalDefinition="Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan." )
        protected IntegerType sequence;

        /**
         * The scope or artifact covered by the case, when the individual test case is associated with a testable artifact.
         */
        @Child(name = "scope", type = {Reference.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The scope or artifact covered by the case", formalDefinition="The scope or artifact covered by the case, when the individual test case is associated with a testable artifact." )
        protected List<Reference> scope;

        /**
         * The required criteria to execute the test case - e.g. preconditions, previous tests.
         */
        @Child(name = "dependency", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Required criteria to execute the test case", formalDefinition="The required criteria to execute the test case - e.g. preconditions, previous tests." )
        protected List<TestCaseDependencyComponent> dependency;

        /**
         * The actual test to be executed.
         */
        @Child(name = "testRun", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The actual test to be executed", formalDefinition="The actual test to be executed." )
        protected List<TestPlanTestCaseTestRunComponent> testRun;

        /**
         * The test data used in the test case.
         */
        @Child(name = "testData", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The test data used in the test case", formalDefinition="The test data used in the test case." )
        protected List<TestPlanTestCaseTestDataComponent> testData;

        /**
         * The test assertions - the expectations of test results from the execution of the test case.
         */
        @Child(name = "assertion", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Test assertions or expectations", formalDefinition="The test assertions - the expectations of test results from the execution of the test case." )
        protected List<TestPlanTestCaseAssertionComponent> assertion;

        private static final long serialVersionUID = 1605296611L;

    /**
     * Constructor
     */
      public TestPlanTestCaseComponent() {
        super();
      }

        /**
         * @return {@link #sequence} (Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.). This is the underlying object with id, value and extensions. The accessor "getSequence" gives direct access to the value
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
         * @param value {@link #sequence} (Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.). This is the underlying object with id, value and extensions. The accessor "getSequence" gives direct access to the value
         */
        public TestPlanTestCaseComponent setSequenceElement(IntegerType value) { 
          this.sequence = value;
          return this;
        }

        /**
         * @return Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.
         */
        public int getSequence() { 
          return this.sequence == null || this.sequence.isEmpty() ? 0 : this.sequence.getValue();
        }

        /**
         * @param value Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.
         */
        public TestPlanTestCaseComponent setSequence(int value) { 
            if (this.sequence == null)
              this.sequence = new IntegerType();
            this.sequence.setValue(value);
          return this;
        }

        /**
         * @return {@link #scope} (The scope or artifact covered by the case, when the individual test case is associated with a testable artifact.)
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
         * @return {@link #dependency} (The required criteria to execute the test case - e.g. preconditions, previous tests.)
         */
        public List<TestCaseDependencyComponent> getDependency() { 
          if (this.dependency == null)
            this.dependency = new ArrayList<TestCaseDependencyComponent>();
          return this.dependency;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setDependency(List<TestCaseDependencyComponent> theDependency) { 
          this.dependency = theDependency;
          return this;
        }

        public boolean hasDependency() { 
          if (this.dependency == null)
            return false;
          for (TestCaseDependencyComponent item : this.dependency)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestCaseDependencyComponent addDependency() { //3
          TestCaseDependencyComponent t = new TestCaseDependencyComponent();
          if (this.dependency == null)
            this.dependency = new ArrayList<TestCaseDependencyComponent>();
          this.dependency.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addDependency(TestCaseDependencyComponent t) { //3
          if (t == null)
            return this;
          if (this.dependency == null)
            this.dependency = new ArrayList<TestCaseDependencyComponent>();
          this.dependency.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dependency}, creating it if it does not already exist {3}
         */
        public TestCaseDependencyComponent getDependencyFirstRep() { 
          if (getDependency().isEmpty()) {
            addDependency();
          }
          return getDependency().get(0);
        }

        /**
         * @return {@link #testRun} (The actual test to be executed.)
         */
        public List<TestPlanTestCaseTestRunComponent> getTestRun() { 
          if (this.testRun == null)
            this.testRun = new ArrayList<TestPlanTestCaseTestRunComponent>();
          return this.testRun;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setTestRun(List<TestPlanTestCaseTestRunComponent> theTestRun) { 
          this.testRun = theTestRun;
          return this;
        }

        public boolean hasTestRun() { 
          if (this.testRun == null)
            return false;
          for (TestPlanTestCaseTestRunComponent item : this.testRun)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestPlanTestCaseTestRunComponent addTestRun() { //3
          TestPlanTestCaseTestRunComponent t = new TestPlanTestCaseTestRunComponent();
          if (this.testRun == null)
            this.testRun = new ArrayList<TestPlanTestCaseTestRunComponent>();
          this.testRun.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addTestRun(TestPlanTestCaseTestRunComponent t) { //3
          if (t == null)
            return this;
          if (this.testRun == null)
            this.testRun = new ArrayList<TestPlanTestCaseTestRunComponent>();
          this.testRun.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #testRun}, creating it if it does not already exist {3}
         */
        public TestPlanTestCaseTestRunComponent getTestRunFirstRep() { 
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
         * @return {@link #assertion} (The test assertions - the expectations of test results from the execution of the test case.)
         */
        public List<TestPlanTestCaseAssertionComponent> getAssertion() { 
          if (this.assertion == null)
            this.assertion = new ArrayList<TestPlanTestCaseAssertionComponent>();
          return this.assertion;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseComponent setAssertion(List<TestPlanTestCaseAssertionComponent> theAssertion) { 
          this.assertion = theAssertion;
          return this;
        }

        public boolean hasAssertion() { 
          if (this.assertion == null)
            return false;
          for (TestPlanTestCaseAssertionComponent item : this.assertion)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TestPlanTestCaseAssertionComponent addAssertion() { //3
          TestPlanTestCaseAssertionComponent t = new TestPlanTestCaseAssertionComponent();
          if (this.assertion == null)
            this.assertion = new ArrayList<TestPlanTestCaseAssertionComponent>();
          this.assertion.add(t);
          return t;
        }

        public TestPlanTestCaseComponent addAssertion(TestPlanTestCaseAssertionComponent t) { //3
          if (t == null)
            return this;
          if (this.assertion == null)
            this.assertion = new ArrayList<TestPlanTestCaseAssertionComponent>();
          this.assertion.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #assertion}, creating it if it does not already exist {3}
         */
        public TestPlanTestCaseAssertionComponent getAssertionFirstRep() { 
          if (getAssertion().isEmpty()) {
            addAssertion();
          }
          return getAssertion().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("sequence", "integer", "Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.", 0, 1, sequence));
          children.add(new Property("scope", "Reference", "The scope or artifact covered by the case, when the individual test case is associated with a testable artifact.", 0, java.lang.Integer.MAX_VALUE, scope));
          children.add(new Property("dependency", "", "The required criteria to execute the test case - e.g. preconditions, previous tests.", 0, java.lang.Integer.MAX_VALUE, dependency));
          children.add(new Property("testRun", "", "The actual test to be executed.", 0, java.lang.Integer.MAX_VALUE, testRun));
          children.add(new Property("testData", "", "The test data used in the test case.", 0, java.lang.Integer.MAX_VALUE, testData));
          children.add(new Property("assertion", "", "The test assertions - the expectations of test results from the execution of the test case.", 0, java.lang.Integer.MAX_VALUE, assertion));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1349547969: /*sequence*/  return new Property("sequence", "integer", "Sequence of test case - an ordinal number that indicates the order for the present test case in the test plan.", 0, 1, sequence);
          case 109264468: /*scope*/  return new Property("scope", "Reference", "The scope or artifact covered by the case, when the individual test case is associated with a testable artifact.", 0, java.lang.Integer.MAX_VALUE, scope);
          case -26291381: /*dependency*/  return new Property("dependency", "", "The required criteria to execute the test case - e.g. preconditions, previous tests.", 0, java.lang.Integer.MAX_VALUE, dependency);
          case -1422467943: /*testRun*/  return new Property("testRun", "", "The actual test to be executed.", 0, java.lang.Integer.MAX_VALUE, testRun);
          case -1147269284: /*testData*/  return new Property("testData", "", "The test data used in the test case.", 0, java.lang.Integer.MAX_VALUE, testData);
          case 1314395906: /*assertion*/  return new Property("assertion", "", "The test assertions - the expectations of test results from the execution of the test case.", 0, java.lang.Integer.MAX_VALUE, assertion);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1349547969: /*sequence*/ return this.sequence == null ? new Base[0] : new Base[] {this.sequence}; // IntegerType
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : this.scope.toArray(new Base[this.scope.size()]); // Reference
        case -26291381: /*dependency*/ return this.dependency == null ? new Base[0] : this.dependency.toArray(new Base[this.dependency.size()]); // TestCaseDependencyComponent
        case -1422467943: /*testRun*/ return this.testRun == null ? new Base[0] : this.testRun.toArray(new Base[this.testRun.size()]); // TestPlanTestCaseTestRunComponent
        case -1147269284: /*testData*/ return this.testData == null ? new Base[0] : this.testData.toArray(new Base[this.testData.size()]); // TestPlanTestCaseTestDataComponent
        case 1314395906: /*assertion*/ return this.assertion == null ? new Base[0] : this.assertion.toArray(new Base[this.assertion.size()]); // TestPlanTestCaseAssertionComponent
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
        case -26291381: // dependency
          this.getDependency().add((TestCaseDependencyComponent) value); // TestCaseDependencyComponent
          return value;
        case -1422467943: // testRun
          this.getTestRun().add((TestPlanTestCaseTestRunComponent) value); // TestPlanTestCaseTestRunComponent
          return value;
        case -1147269284: // testData
          this.getTestData().add((TestPlanTestCaseTestDataComponent) value); // TestPlanTestCaseTestDataComponent
          return value;
        case 1314395906: // assertion
          this.getAssertion().add((TestPlanTestCaseAssertionComponent) value); // TestPlanTestCaseAssertionComponent
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
        } else if (name.equals("dependency")) {
          this.getDependency().add((TestCaseDependencyComponent) value);
        } else if (name.equals("testRun")) {
          this.getTestRun().add((TestPlanTestCaseTestRunComponent) value);
        } else if (name.equals("testData")) {
          this.getTestData().add((TestPlanTestCaseTestDataComponent) value);
        } else if (name.equals("assertion")) {
          this.getAssertion().add((TestPlanTestCaseAssertionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1349547969:  return getSequenceElement();
        case 109264468:  return addScope(); 
        case -26291381:  return addDependency(); 
        case -1422467943:  return addTestRun(); 
        case -1147269284:  return addTestData(); 
        case 1314395906:  return addAssertion(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1349547969: /*sequence*/ return new String[] {"integer"};
        case 109264468: /*scope*/ return new String[] {"Reference"};
        case -26291381: /*dependency*/ return new String[] {};
        case -1422467943: /*testRun*/ return new String[] {};
        case -1147269284: /*testData*/ return new String[] {};
        case 1314395906: /*assertion*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("sequence")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.testCase.sequence");
        }
        else if (name.equals("scope")) {
          return addScope();
        }
        else if (name.equals("dependency")) {
          return addDependency();
        }
        else if (name.equals("testRun")) {
          return addTestRun();
        }
        else if (name.equals("testData")) {
          return addTestData();
        }
        else if (name.equals("assertion")) {
          return addAssertion();
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
        if (dependency != null) {
          dst.dependency = new ArrayList<TestCaseDependencyComponent>();
          for (TestCaseDependencyComponent i : dependency)
            dst.dependency.add(i.copy());
        };
        if (testRun != null) {
          dst.testRun = new ArrayList<TestPlanTestCaseTestRunComponent>();
          for (TestPlanTestCaseTestRunComponent i : testRun)
            dst.testRun.add(i.copy());
        };
        if (testData != null) {
          dst.testData = new ArrayList<TestPlanTestCaseTestDataComponent>();
          for (TestPlanTestCaseTestDataComponent i : testData)
            dst.testData.add(i.copy());
        };
        if (assertion != null) {
          dst.assertion = new ArrayList<TestPlanTestCaseAssertionComponent>();
          for (TestPlanTestCaseAssertionComponent i : assertion)
            dst.assertion.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseComponent))
          return false;
        TestPlanTestCaseComponent o = (TestPlanTestCaseComponent) other_;
        return compareDeep(sequence, o.sequence, true) && compareDeep(scope, o.scope, true) && compareDeep(dependency, o.dependency, true)
           && compareDeep(testRun, o.testRun, true) && compareDeep(testData, o.testData, true) && compareDeep(assertion, o.assertion, true)
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(sequence, scope, dependency
          , testRun, testData, assertion);
      }

  public String fhirType() {
    return "TestPlan.testCase";

  }

  }

    @Block()
    public static class TestCaseDependencyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of the criteria.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the criteria", formalDefinition="Description of the criteria." )
        protected MarkdownType description;

        /**
         * Link to predecessor test plans.
         */
        @Child(name = "predecessor", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Link to predecessor test plans", formalDefinition="Link to predecessor test plans." )
        protected Reference predecessor;

        private static final long serialVersionUID = 1630757943L;

    /**
     * Constructor
     */
      public TestCaseDependencyComponent() {
        super();
      }

        /**
         * @return {@link #description} (Description of the criteria.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestCaseDependencyComponent.description");
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
        public TestCaseDependencyComponent setDescriptionElement(MarkdownType value) { 
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
        public TestCaseDependencyComponent setDescription(String value) { 
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
              throw new Error("Attempt to auto-create TestCaseDependencyComponent.predecessor");
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
        public TestCaseDependencyComponent setPredecessor(Reference value) { 
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
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.testCase.dependency.description");
        }
        else if (name.equals("predecessor")) {
          this.predecessor = new Reference();
          return this.predecessor;
        }
        else
          return super.addChild(name);
      }

      public TestCaseDependencyComponent copy() {
        TestCaseDependencyComponent dst = new TestCaseDependencyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestCaseDependencyComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.predecessor = predecessor == null ? null : predecessor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestCaseDependencyComponent))
          return false;
        TestCaseDependencyComponent o = (TestCaseDependencyComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(predecessor, o.predecessor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestCaseDependencyComponent))
          return false;
        TestCaseDependencyComponent o = (TestCaseDependencyComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, predecessor);
      }

  public String fhirType() {
    return "TestPlan.testCase.dependency";

  }

  }

    @Block()
    public static class TestPlanTestCaseTestRunComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The narrative description of the tests.
         */
        @Child(name = "narrative", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The narrative description of the tests", formalDefinition="The narrative description of the tests." )
        protected MarkdownType narrative;

        /**
         * The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.
         */
        @Child(name = "script", type = {}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript", formalDefinition="The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript." )
        protected TestPlanTestCaseTestRunScriptComponent script;

        private static final long serialVersionUID = -763780736L;

    /**
     * Constructor
     */
      public TestPlanTestCaseTestRunComponent() {
        super();
      }

        /**
         * @return {@link #narrative} (The narrative description of the tests.). This is the underlying object with id, value and extensions. The accessor "getNarrative" gives direct access to the value
         */
        public MarkdownType getNarrativeElement() { 
          if (this.narrative == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseTestRunComponent.narrative");
            else if (Configuration.doAutoCreate())
              this.narrative = new MarkdownType(); // bb
          return this.narrative;
        }

        public boolean hasNarrativeElement() { 
          return this.narrative != null && !this.narrative.isEmpty();
        }

        public boolean hasNarrative() { 
          return this.narrative != null && !this.narrative.isEmpty();
        }

        /**
         * @param value {@link #narrative} (The narrative description of the tests.). This is the underlying object with id, value and extensions. The accessor "getNarrative" gives direct access to the value
         */
        public TestPlanTestCaseTestRunComponent setNarrativeElement(MarkdownType value) { 
          this.narrative = value;
          return this;
        }

        /**
         * @return The narrative description of the tests.
         */
        public String getNarrative() { 
          return this.narrative == null ? null : this.narrative.getValue();
        }

        /**
         * @param value The narrative description of the tests.
         */
        public TestPlanTestCaseTestRunComponent setNarrative(String value) { 
          if (Utilities.noString(value))
            this.narrative = null;
          else {
            if (this.narrative == null)
              this.narrative = new MarkdownType();
            this.narrative.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #script} (The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.)
         */
        public TestPlanTestCaseTestRunScriptComponent getScript() { 
          if (this.script == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseTestRunComponent.script");
            else if (Configuration.doAutoCreate())
              this.script = new TestPlanTestCaseTestRunScriptComponent(); // cc
          return this.script;
        }

        public boolean hasScript() { 
          return this.script != null && !this.script.isEmpty();
        }

        /**
         * @param value {@link #script} (The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.)
         */
        public TestPlanTestCaseTestRunComponent setScript(TestPlanTestCaseTestRunScriptComponent value) { 
          this.script = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("narrative", "markdown", "The narrative description of the tests.", 0, 1, narrative));
          children.add(new Property("script", "", "The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.", 0, 1, script));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1750452338: /*narrative*/  return new Property("narrative", "markdown", "The narrative description of the tests.", 0, 1, narrative);
          case -907685685: /*script*/  return new Property("script", "", "The test cases in a structured language e.g. gherkin, Postman, or FHIR TestScript.", 0, 1, script);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1750452338: /*narrative*/ return this.narrative == null ? new Base[0] : new Base[] {this.narrative}; // MarkdownType
        case -907685685: /*script*/ return this.script == null ? new Base[0] : new Base[] {this.script}; // TestPlanTestCaseTestRunScriptComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1750452338: // narrative
          this.narrative = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -907685685: // script
          this.script = (TestPlanTestCaseTestRunScriptComponent) value; // TestPlanTestCaseTestRunScriptComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("narrative")) {
          this.narrative = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("script")) {
          this.script = (TestPlanTestCaseTestRunScriptComponent) value; // TestPlanTestCaseTestRunScriptComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1750452338:  return getNarrativeElement();
        case -907685685:  return getScript();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1750452338: /*narrative*/ return new String[] {"markdown"};
        case -907685685: /*script*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("narrative")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.testCase.testRun.narrative");
        }
        else if (name.equals("script")) {
          this.script = new TestPlanTestCaseTestRunScriptComponent();
          return this.script;
        }
        else
          return super.addChild(name);
      }

      public TestPlanTestCaseTestRunComponent copy() {
        TestPlanTestCaseTestRunComponent dst = new TestPlanTestCaseTestRunComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseTestRunComponent dst) {
        super.copyValues(dst);
        dst.narrative = narrative == null ? null : narrative.copy();
        dst.script = script == null ? null : script.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseTestRunComponent))
          return false;
        TestPlanTestCaseTestRunComponent o = (TestPlanTestCaseTestRunComponent) other_;
        return compareDeep(narrative, o.narrative, true) && compareDeep(script, o.script, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseTestRunComponent))
          return false;
        TestPlanTestCaseTestRunComponent o = (TestPlanTestCaseTestRunComponent) other_;
        return compareValues(narrative, o.narrative, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(narrative, script);
      }

  public String fhirType() {
    return "TestPlan.testCase.testRun";

  }

  }

    @Block()
    public static class TestPlanTestCaseTestRunScriptComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The language for the test cases e.g. 'gherkin', 'testscript'.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The language for the test cases e.g. 'gherkin', 'testscript'", formalDefinition="The language for the test cases e.g. 'gherkin', 'testscript'." )
        protected CodeableConcept language;

        /**
         * The actual content of the cases - references to TestScripts or externally defined content.
         */
        @Child(name = "source", type = {StringType.class, Reference.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The actual content of the cases - references to TestScripts or externally defined content", formalDefinition="The actual content of the cases - references to TestScripts or externally defined content." )
        protected DataType source;

        private static final long serialVersionUID = 1308596610L;

    /**
     * Constructor
     */
      public TestPlanTestCaseTestRunScriptComponent() {
        super();
      }

        /**
         * @return {@link #language} (The language for the test cases e.g. 'gherkin', 'testscript'.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create TestPlanTestCaseTestRunScriptComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (The language for the test cases e.g. 'gherkin', 'testscript'.)
         */
        public TestPlanTestCaseTestRunScriptComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #source} (The actual content of the cases - references to TestScripts or externally defined content.)
         */
        public DataType getSource() { 
          return this.source;
        }

        /**
         * @return {@link #source} (The actual content of the cases - references to TestScripts or externally defined content.)
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
         * @return {@link #source} (The actual content of the cases - references to TestScripts or externally defined content.)
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
         * @param value {@link #source} (The actual content of the cases - references to TestScripts or externally defined content.)
         */
        public TestPlanTestCaseTestRunScriptComponent setSource(DataType value) { 
          if (value != null && !(value instanceof StringType || value instanceof Reference))
            throw new FHIRException("Not the right type for TestPlan.testCase.testRun.script.source[x]: "+value.fhirType());
          this.source = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("language", "CodeableConcept", "The language for the test cases e.g. 'gherkin', 'testscript'.", 0, 1, language));
          children.add(new Property("source[x]", "string|Reference", "The actual content of the cases - references to TestScripts or externally defined content.", 0, 1, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "The language for the test cases e.g. 'gherkin', 'testscript'.", 0, 1, language);
          case -1698413947: /*source[x]*/  return new Property("source[x]", "string|Reference", "The actual content of the cases - references to TestScripts or externally defined content.", 0, 1, source);
          case -896505829: /*source*/  return new Property("source[x]", "string|Reference", "The actual content of the cases - references to TestScripts or externally defined content.", 0, 1, source);
          case 1327821836: /*sourceString*/  return new Property("source[x]", "string", "The actual content of the cases - references to TestScripts or externally defined content.", 0, 1, source);
          case -244259472: /*sourceReference*/  return new Property("source[x]", "Reference", "The actual content of the cases - references to TestScripts or externally defined content.", 0, 1, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source[x]")) {
          this.source = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672:  return getLanguage();
        case -1698413947:  return getSource();
        case -896505829:  return getSource();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"string", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
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

      public TestPlanTestCaseTestRunScriptComponent copy() {
        TestPlanTestCaseTestRunScriptComponent dst = new TestPlanTestCaseTestRunScriptComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseTestRunScriptComponent dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.source = source == null ? null : source.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseTestRunScriptComponent))
          return false;
        TestPlanTestCaseTestRunScriptComponent o = (TestPlanTestCaseTestRunScriptComponent) other_;
        return compareDeep(language, o.language, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseTestRunScriptComponent))
          return false;
        TestPlanTestCaseTestRunScriptComponent o = (TestPlanTestCaseTestRunScriptComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, source);
      }

  public String fhirType() {
    return "TestPlan.testCase.testRun.script";

  }

  }

    @Block()
    public static class TestPlanTestCaseTestDataComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of test data description, e.g. 'synthea'.
         */
        @Child(name = "type", type = {Coding.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of test data description, e.g. 'synthea'", formalDefinition="The type of test data description, e.g. 'synthea'." )
        protected Coding type;

        /**
         * The actual test resources when they exist.
         */
        @Child(name = "content", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The actual test resources when they exist", formalDefinition="The actual test resources when they exist." )
        protected Reference content;

        /**
         * Pointer to a definition of test resources - narrative or structured e.g. synthetic data generation, etc.
         */
        @Child(name = "source", type = {StringType.class, Reference.class}, order=3, min=0, max=1, modifier=false, summary=false)
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
            throw new FHIRException("Not the right type for TestPlan.testCase.testData.source[x]: "+value.fhirType());
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
    public static class TestPlanTestCaseAssertionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The test assertion type - this can be used to group assertions as 'required' or 'optional', or can be used for other classification of the assertion.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Assertion type - for example 'informative' or 'required' ", formalDefinition="The test assertion type - this can be used to group assertions as 'required' or 'optional', or can be used for other classification of the assertion." )
        protected List<CodeableConcept> type;

        /**
         * The focus or object of the assertion i.e. a resource.
         */
        @Child(name = "object", type = {CodeableReference.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The focus or object of the assertion", formalDefinition="The focus or object of the assertion i.e. a resource." )
        protected List<CodeableReference> object;

        /**
         * The test assertion - the expected outcome from the test case execution.
         */
        @Child(name = "result", type = {CodeableReference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The actual result assertion", formalDefinition="The test assertion - the expected outcome from the test case execution." )
        protected List<CodeableReference> result;

        private static final long serialVersionUID = 481177705L;

    /**
     * Constructor
     */
      public TestPlanTestCaseAssertionComponent() {
        super();
      }

        /**
         * @return {@link #type} (The test assertion type - this can be used to group assertions as 'required' or 'optional', or can be used for other classification of the assertion.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseAssertionComponent setType(List<CodeableConcept> theType) { 
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

        public TestPlanTestCaseAssertionComponent addType(CodeableConcept t) { //3
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
         * @return {@link #object} (The focus or object of the assertion i.e. a resource.)
         */
        public List<CodeableReference> getObject() { 
          if (this.object == null)
            this.object = new ArrayList<CodeableReference>();
          return this.object;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseAssertionComponent setObject(List<CodeableReference> theObject) { 
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

        public TestPlanTestCaseAssertionComponent addObject(CodeableReference t) { //3
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
         * @return {@link #result} (The test assertion - the expected outcome from the test case execution.)
         */
        public List<CodeableReference> getResult() { 
          if (this.result == null)
            this.result = new ArrayList<CodeableReference>();
          return this.result;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public TestPlanTestCaseAssertionComponent setResult(List<CodeableReference> theResult) { 
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

        public TestPlanTestCaseAssertionComponent addResult(CodeableReference t) { //3
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
          children.add(new Property("type", "CodeableConcept", "The test assertion type - this can be used to group assertions as 'required' or 'optional', or can be used for other classification of the assertion.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("object", "CodeableReference", "The focus or object of the assertion i.e. a resource.", 0, java.lang.Integer.MAX_VALUE, object));
          children.add(new Property("result", "CodeableReference", "The test assertion - the expected outcome from the test case execution.", 0, java.lang.Integer.MAX_VALUE, result));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The test assertion type - this can be used to group assertions as 'required' or 'optional', or can be used for other classification of the assertion.", 0, java.lang.Integer.MAX_VALUE, type);
          case -1023368385: /*object*/  return new Property("object", "CodeableReference", "The focus or object of the assertion i.e. a resource.", 0, java.lang.Integer.MAX_VALUE, object);
          case -934426595: /*result*/  return new Property("result", "CodeableReference", "The test assertion - the expected outcome from the test case execution.", 0, java.lang.Integer.MAX_VALUE, result);
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

      public TestPlanTestCaseAssertionComponent copy() {
        TestPlanTestCaseAssertionComponent dst = new TestPlanTestCaseAssertionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TestPlanTestCaseAssertionComponent dst) {
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
        if (!(other_ instanceof TestPlanTestCaseAssertionComponent))
          return false;
        TestPlanTestCaseAssertionComponent o = (TestPlanTestCaseAssertionComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(object, o.object, true) && compareDeep(result, o.result, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlanTestCaseAssertionComponent))
          return false;
        TestPlanTestCaseAssertionComponent o = (TestPlanTestCaseAssertionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, object, result);
      }

  public String fhirType() {
    return "TestPlan.testCase.assertion";

  }

  }

    /**
     * An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this test plan, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this test plan when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier identifier for the test plan", formalDefinition="A formal identifier that is used to identify this test plan when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the test plan", formalDefinition="The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this test plan (computer friendly)", formalDefinition="A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the test plan.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name for this test plan (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the test plan." )
    protected StringType title;

    /**
     * The status of this test plan. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this test plan. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.
     */
    @Child(name = "publisher", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the test plan." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the test plan from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the test plan", formalDefinition="A free text natural language description of the test plan from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test plan instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test plan instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the test plan is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction where the test plan applies (if applicable)", formalDefinition="A legal or geographic region in which the test plan is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this test plan is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this test plan is defined", formalDefinition="Explanation of why this test plan is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The category of the Test Plan - can be acceptance, unit, performance, etc.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The category of the Test Plan - can be acceptance, unit, performance", formalDefinition="The category of the Test Plan - can be acceptance, unit, performance, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/testscript-scope-phase-codes")
    protected List<CodeableConcept> category;

    /**
     * What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...
     */
    @Child(name = "scope", type = {Reference.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference", formalDefinition="What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference..." )
    protected List<Reference> scope;

    /**
     * A description of test tools to be used in the test plan.
     */
    @Child(name = "testTools", type = {MarkdownType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A description of test tools to be used in the test plan - narrative for now", formalDefinition="A description of test tools to be used in the test plan." )
    protected MarkdownType testTools;

    /**
     * The required criteria to execute the test plan - e.g. preconditions, previous tests...
     */
    @Child(name = "dependency", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The required criteria to execute the test plan - e.g. preconditions, previous tests", formalDefinition="The required criteria to execute the test plan - e.g. preconditions, previous tests..." )
    protected List<TestPlanDependencyComponent> dependency;

    /**
     * The threshold or criteria for the test plan to be considered successfully executed - narrative.
     */
    @Child(name = "exitCriteria", type = {MarkdownType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The threshold or criteria for the test plan to be considered successfully executed - narrative", formalDefinition="The threshold or criteria for the test plan to be considered successfully executed - narrative." )
    protected MarkdownType exitCriteria;

    /**
     * The individual test cases that are part of this plan, when they they are made explicit.
     */
    @Child(name = "testCase", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The test cases that constitute this plan", formalDefinition="The individual test cases that are part of this plan, when they they are made explicit." )
    protected List<TestPlanTestCaseComponent> testCase;

    private static final long serialVersionUID = 235546950L;

  /**
   * Constructor
   */
    public TestPlan() {
      super();
    }

    /**
   * Constructor
   */
    public TestPlan(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
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
     * @param value {@link #url} (An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public TestPlan setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.
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
     * @return {@link #identifier} (A formal identifier that is used to identify this test plan when it is represented in other formats, or referenced in a specification, model, design or an instance.)
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
     * @return {@link #version} (The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public TestPlan setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public TestPlan setVersion(String value) { 
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
    public TestPlan setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for TestPlan.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.name");
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
     * @param value {@link #name} (A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public TestPlan setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public TestPlan setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the test plan.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the test plan.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public TestPlan setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the test plan.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the test plan.
     */
    public TestPlan setTitle(String value) { 
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
     * @return {@link #status} (The status of this test plan. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.status");
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
     * @param value {@link #status} (The status of this test plan. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public TestPlan setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this test plan. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this test plan. Enables tracking the life-cycle of the content.
     */
    public TestPlan setStatus(PublicationStatus value) { 
      if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public TestPlan setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public TestPlan setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.date");
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
     * @param value {@link #date} (The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public TestPlan setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.
     */
    public TestPlan setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public TestPlan setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.
     */
    public TestPlan setPublisher(String value) { 
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
     * @return {@link #description} (A free text natural language description of the test plan from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
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
     * @param value {@link #description} (A free text natural language description of the test plan from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public TestPlan setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the test plan from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the test plan from a consumer's perspective.
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test plan instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setUseContext(List<UsageContext> theUseContext) { 
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

    public TestPlan addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the test plan is intended to be used.)
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
     * @return {@link #purpose} (Explanation of why this test plan is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
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
     * @param value {@link #purpose} (Explanation of why this test plan is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public TestPlan setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this test plan is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this test plan is needed and why it has been designed as it has.
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
     * @return {@link #copyright} (A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
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
     * @param value {@link #copyright} (A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public TestPlan setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.
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
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TestPlan.copyrightLabel");
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
    public TestPlan setCopyrightLabelElement(StringType value) { 
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
    public TestPlan setCopyrightLabel(String value) { 
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
     * @return {@link #dependency} (The required criteria to execute the test plan - e.g. preconditions, previous tests...)
     */
    public List<TestPlanDependencyComponent> getDependency() { 
      if (this.dependency == null)
        this.dependency = new ArrayList<TestPlanDependencyComponent>();
      return this.dependency;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TestPlan setDependency(List<TestPlanDependencyComponent> theDependency) { 
      this.dependency = theDependency;
      return this;
    }

    public boolean hasDependency() { 
      if (this.dependency == null)
        return false;
      for (TestPlanDependencyComponent item : this.dependency)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TestPlanDependencyComponent addDependency() { //3
      TestPlanDependencyComponent t = new TestPlanDependencyComponent();
      if (this.dependency == null)
        this.dependency = new ArrayList<TestPlanDependencyComponent>();
      this.dependency.add(t);
      return t;
    }

    public TestPlan addDependency(TestPlanDependencyComponent t) { //3
      if (t == null)
        return this;
      if (this.dependency == null)
        this.dependency = new ArrayList<TestPlanDependencyComponent>();
      this.dependency.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dependency}, creating it if it does not already exist {3}
     */
    public TestPlanDependencyComponent getDependencyFirstRep() { 
      if (getDependency().isEmpty()) {
        addDependency();
      }
      return getDependency().get(0);
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
     * @return {@link #testCase} (The individual test cases that are part of this plan, when they they are made explicit.)
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
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this test plan when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the test plan.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this test plan. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the test plan from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test plan instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the test plan is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this test plan is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("category", "CodeableConcept", "The category of the Test Plan - can be acceptance, unit, performance, etc.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("scope", "Reference", "What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...", 0, java.lang.Integer.MAX_VALUE, scope));
        children.add(new Property("testTools", "markdown", "A description of test tools to be used in the test plan.", 0, 1, testTools));
        children.add(new Property("dependency", "", "The required criteria to execute the test plan - e.g. preconditions, previous tests...", 0, java.lang.Integer.MAX_VALUE, dependency));
        children.add(new Property("exitCriteria", "markdown", "The threshold or criteria for the test plan to be considered successfully executed - narrative.", 0, 1, exitCriteria));
        children.add(new Property("testCase", "", "The individual test cases that are part of this plan, when they they are made explicit.", 0, java.lang.Integer.MAX_VALUE, testCase));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this test plan when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this test plan is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the test plan is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this test plan when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the test plan when it is referenced in a specification, model, design or instance.  This is an arbitrary value managed by the test plan author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the test plan. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the test plan.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this test plan. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this test plan is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date (and optionally time) when the test plan was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the test plan changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the test plan.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the test plan from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate test plan instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the test plan is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this test plan is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the test plan and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the test plan. The short copyright declaration (e.g. (c) '2015+ xyz organization' should be sent in the copyrightLabel element.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "The category of the Test Plan - can be acceptance, unit, performance, etc.", 0, java.lang.Integer.MAX_VALUE, category);
        case 109264468: /*scope*/  return new Property("scope", "Reference", "What is being tested with this Test Plan - a conformance resource, or narrative criteria, or an external reference...", 0, java.lang.Integer.MAX_VALUE, scope);
        case -1190420375: /*testTools*/  return new Property("testTools", "markdown", "A description of test tools to be used in the test plan.", 0, 1, testTools);
        case -26291381: /*dependency*/  return new Property("dependency", "", "The required criteria to execute the test plan - e.g. preconditions, previous tests...", 0, java.lang.Integer.MAX_VALUE, dependency);
        case -1382023523: /*exitCriteria*/  return new Property("exitCriteria", "markdown", "The threshold or criteria for the test plan to be considered successfully executed - narrative.", 0, 1, exitCriteria);
        case -1147299102: /*testCase*/  return new Property("testCase", "", "The individual test cases that are part of this plan, when they they are made explicit.", 0, java.lang.Integer.MAX_VALUE, testCase);
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
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 109264468: /*scope*/ return this.scope == null ? new Base[0] : this.scope.toArray(new Base[this.scope.size()]); // Reference
        case -1190420375: /*testTools*/ return this.testTools == null ? new Base[0] : new Base[] {this.testTools}; // MarkdownType
        case -26291381: /*dependency*/ return this.dependency == null ? new Base[0] : this.dependency.toArray(new Base[this.dependency.size()]); // TestPlanDependencyComponent
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
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 109264468: // scope
          this.getScope().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1190420375: // testTools
          this.testTools = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -26291381: // dependency
          this.getDependency().add((TestPlanDependencyComponent) value); // TestPlanDependencyComponent
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
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("scope")) {
          this.getScope().add(TypeConvertor.castToReference(value));
        } else if (name.equals("testTools")) {
          this.testTools = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("dependency")) {
          this.getDependency().add((TestPlanDependencyComponent) value);
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
        case 50511102:  return addCategory(); 
        case 109264468:  return addScope(); 
        case -1190420375:  return getTestToolsElement();
        case -26291381:  return addDependency(); 
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
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 109264468: /*scope*/ return new String[] {"Reference"};
        case -1190420375: /*testTools*/ return new String[] {"markdown"};
        case -26291381: /*dependency*/ return new String[] {};
        case -1382023523: /*exitCriteria*/ return new String[] {"markdown"};
        case -1147299102: /*testCase*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.version");
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
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.copyrightLabel");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("scope")) {
          return addScope();
        }
        else if (name.equals("testTools")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.testTools");
        }
        else if (name.equals("dependency")) {
          return addDependency();
        }
        else if (name.equals("exitCriteria")) {
          throw new FHIRException("Cannot call addChild on a singleton property TestPlan.exitCriteria");
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
        if (dependency != null) {
          dst.dependency = new ArrayList<TestPlanDependencyComponent>();
          for (TestPlanDependencyComponent i : dependency)
            dst.dependency.add(i.copy());
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
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(category, o.category, true) && compareDeep(scope, o.scope, true) && compareDeep(testTools, o.testTools, true)
           && compareDeep(dependency, o.dependency, true) && compareDeep(exitCriteria, o.exitCriteria, true)
           && compareDeep(testCase, o.testCase, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TestPlan))
          return false;
        TestPlan o = (TestPlan) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(testTools, o.testTools, true) && compareValues(exitCriteria, o.exitCriteria, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, experimental, date, publisher, contact
          , description, useContext, jurisdiction, purpose, copyright, copyrightLabel, category
          , scope, testTools, dependency, exitCriteria, testCase);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.TestPlan;
   }

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
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestPlan](testplan.html): An identifier for the test plan\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
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
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

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
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestPlan](testplan.html): The current status of the test plan\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
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
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

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
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestPlan](testplan.html): The uri that identifies the test plan\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
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
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>scope</b>
   * <p>
   * Description: <b>The scope that is to be tested with this test plan</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>TestPlan.scope</b><br>
   * </p>
   */
  @SearchParamDefinition(name="scope", path="TestPlan.scope", description="The scope that is to be tested with this test plan", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SCOPE = "scope";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>scope</b>
   * <p>
   * Description: <b>The scope that is to be tested with this test plan</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>TestPlan.scope</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SCOPE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SCOPE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>TestPlan:scope</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SCOPE = new ca.uhn.fhir.model.api.Include("TestPlan:scope").toLocked();


}

