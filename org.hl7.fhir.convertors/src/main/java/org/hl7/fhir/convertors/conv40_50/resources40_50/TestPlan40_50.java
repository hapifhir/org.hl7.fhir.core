package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.TestPlan.TestCaseDependencyComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanDependencyComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseAssertionComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseTestDataComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseTestRunComponent;
import org.hl7.fhir.r5.model.TestPlan.TestPlanTestCaseTestRunScriptComponent;
import org.hl7.fhir.r5.model.UsageContext;

/*
Copyright (c) 2011+, HL7, Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/
//Generated on Thu, Mar 11, 2023 14:26+0500 for FHIR v4.0.0
public class TestPlan40_50 {

  public static final String URL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.url";
  public static final String VERSION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.version";
  public static final String NAME_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.name";
  public static final String TITLE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.title";
  public static final String STATUS_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.status";
  public static final String EXPERIMENTAL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.experimental";
  public static final String DATE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.date";
  public static final String PUBLISHER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.publisher";
  public static final String CONTACT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.contact";
  public static final String DESCRIPTION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.description";
  public static final String USE_CONTEXT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.useContext";
  public static final String JURISDICTION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.jurisdiction";
  public static final String PURPOSE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.purpose";
  public static final String COPYRIGHT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.copyright";
  public static final String COPYRIGHT_LABEL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.copyrightLabel";
  public static final String CATEGORY_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.category";
  public static final String SCOPE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.scope";
  public static final String TESTTOOLS_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testTools";
  public static final String DEPENDENCY_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency";
  public static final String EXITCRITERIA_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.exitCriteria";
  public static final String TESTCASE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase";

  private static final String[] IGNORED_EXTENSION_URLS = new String[]{
    URL_EXTENSION_URL,
    VERSION_EXTENSION_URL,
    NAME_EXTENSION_URL,
    TITLE_EXTENSION_URL,
    STATUS_EXTENSION_URL,
    EXPERIMENTAL_EXTENSION_URL,
    DATE_EXTENSION_URL,
    PUBLISHER_EXTENSION_URL,
    CONTACT_EXTENSION_URL,
    DESCRIPTION_EXTENSION_URL,
    USE_CONTEXT_EXTENSION_URL,
    JURISDICTION_EXTENSION_URL,
    PURPOSE_EXTENSION_URL,
    COPYRIGHT_EXTENSION_URL,
    COPYRIGHT_LABEL_EXTENSION_URL,
    CATEGORY_EXTENSION_URL,
    SCOPE_EXTENSION_URL,
    TESTTOOLS_EXTENSION_URL,
    DEPENDENCY_EXTENSION_URL,
    EXITCRITERIA_EXTENSION_URL,
    TESTCASE_EXTENSION_URL
  };

  public static org.hl7.fhir.r5.model.TestPlan convertTestPlan(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
      throw new FHIRException("Error in logic: this basic resource is not an TestPlan");
    }
    org.hl7.fhir.r5.model.TestPlan tgt = new org.hl7.fhir.r5.model.TestPlan();

    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
	    
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    }
    if (src.hasExtension(URL_EXTENSION_URL)) {
      tgt.setUrlElement(Uri40_50.convertUri((org.hl7.fhir.r4.model.UriType) src.getExtensionByUrl(URL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(VERSION_EXTENSION_URL)) {
      tgt.setVersionElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(VERSION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(NAME_EXTENSION_URL)) {
      tgt.setNameElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(NAME_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(TITLE_EXTENSION_URL)) {
      tgt.setTitleElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TITLE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(STATUS_EXTENSION_URL)) {
      tgt.setStatus(PublicationStatus.fromCode(src.getExtensionByUrl(STATUS_EXTENSION_URL).getValue().primitiveValue()));
    }
    if (src.hasExtension(EXPERIMENTAL_EXTENSION_URL)) {
      tgt.setExperimentalElement(Boolean40_50.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(EXPERIMENTAL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(DATE_EXTENSION_URL)) {
      tgt.setDateElement(DateTime40_50.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src.getExtensionByUrl(DATE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(PUBLISHER_EXTENSION_URL)) {
      tgt.setPublisherElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(PUBLISHER_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(CONTACT_EXTENSION_URL)) {
      tgt.addContact(ContactDetail40_50.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) ext.getValue()));
    }
    if (src.hasExtension(DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(DESCRIPTION_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(USE_CONTEXT_EXTENSION_URL)) {
      tgt.addUseContext(UsageContext40_50.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(JURISDICTION_EXTENSION_URL)) {
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    }
    if (src.hasExtension(PURPOSE_EXTENSION_URL)) {
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(PURPOSE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_EXTENSION_URL)) {
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(COPYRIGHT_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_LABEL_EXTENSION_URL)) {
      tgt.setCopyrightLabelElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(COPYRIGHT_LABEL_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(CATEGORY_EXTENSION_URL)) {
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(SCOPE_EXTENSION_URL)) {
      tgt.getScope().add(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) ext.getValue()));
    }
    if (src.hasExtension(TESTTOOLS_EXTENSION_URL)) {
      tgt.setTestToolsElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TESTTOOLS_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(DEPENDENCY_EXTENSION_URL)) {
      convertTestPlanDependency(ext, tgt.addDependency());
    }
    if (src.hasExtension(EXITCRITERIA_EXTENSION_URL)) {
      tgt.setExitCriteriaElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(EXITCRITERIA_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TESTCASE_EXTENSION_URL)) {
      convertTestPlanTestCase(ext, tgt.addTestCase());
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Basic convertTestPlan(org.hl7.fhir.r5.model.TestPlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("TestPlan"); // note use of R5 type system
    
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    }
    if (src.hasUrl()) {
      tgt.addExtension(URL_EXTENSION_URL, Uri40_50.convertUri(src.getUrlElement()));
    }
    if (src.hasVersion()) {
      tgt.addExtension(VERSION_EXTENSION_URL, String40_50.convertString(src.getVersionElement()));
    }
    if (src.hasName()) {
      tgt.addExtension(NAME_EXTENSION_URL, String40_50.convertString(src.getNameElement()));
    }
    if (src.hasTitle()) {
      tgt.addExtension(TITLE_EXTENSION_URL, String40_50.convertString(src.getTitleElement()));
    }
    if (src.hasStatus()) {
      tgt.addExtension(STATUS_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getStatus().toCode()));
    }
    if (src.hasExperimental()) {
      tgt.addExtension(EXPERIMENTAL_EXTENSION_URL, Boolean40_50.convertBoolean(src.getExperimentalElement()));
    }
    if (src.hasDate()) {
      tgt.addExtension(DATE_EXTENSION_URL, DateTime40_50.convertDateTime(src.getDateElement()));
    }
    if (src.hasPublisher()) {
      tgt.addExtension(PUBLISHER_EXTENSION_URL, String40_50.convertString(src.getPublisherElement()));
    }
    for (ContactDetail cd : src.getContact()) {
      tgt.addExtension(CONTACT_EXTENSION_URL, ContactDetail40_50.convertContactDetail(cd));
    }
    if (src.hasDescription()) {
      tgt.addExtension(DESCRIPTION_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    for (UsageContext cd : src.getUseContext()) {
      tgt.addExtension(USE_CONTEXT_EXTENSION_URL, UsageContext40_50.convertUsageContext(cd));
    }
    for (CodeableConcept cd : src.getJurisdiction()) {
      tgt.addExtension(JURISDICTION_EXTENSION_URL, CodeableConcept40_50.convertCodeableConcept(cd));
    }
    if (src.hasPurpose()) {
      tgt.addExtension(PURPOSE_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    }
    if (src.hasCopyright()) {
      tgt.addExtension(COPYRIGHT_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    }
    if (src.hasCopyrightLabel()) {
      tgt.addExtension(COPYRIGHT_LABEL_EXTENSION_URL, String40_50.convertString(src.getCopyrightLabelElement()));
    }
    for (CodeableConcept cc : src.getCategory()) {
      tgt.addExtension(CATEGORY_EXTENSION_URL, CodeableConcept40_50.convertCodeableConcept(cc));
    }
    for (Reference ref : src.getScope()) {
      tgt.addExtension(SCOPE_EXTENSION_URL, Reference40_50.convertReference(ref));
    }
    if (src.hasTestTools()) {
      tgt.addExtension(TESTTOOLS_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getTestToolsElement()));
    }
    for (TestPlanDependencyComponent ref : src.getDependency()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(DEPENDENCY_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertTestPlanDependency(ref, tgte);
    }
    if (src.hasExitCriteria()) {
      tgt.addExtension(EXITCRITERIA_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getExitCriteriaElement()));
    }
    for (TestPlanTestCaseComponent ref : src.getTestCase()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TESTCASE_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertTestPlanTestCase(ref, tgte);
    }

    return tgt;
  }

  /*
   * R4 to R5 private methods
   */

  private static void convertTestPlanDependency(Extension src, TestPlanDependencyComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.description",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.predecessor"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.description")) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.description").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.predecessor")) {
      tgt.setPredecessor(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.predecessor").getValue()));
    }
  }

  private static void convertTestPlanTestCase(Extension src, TestPlanTestCaseComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.sequence",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.scope",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.sequence")) {
      tgt.setSequenceElement(Integer40_50.convertInteger((org.hl7.fhir.r4.model.IntegerType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.sequence").getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.scope")) {
      tgt.getScope().add(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency")) {
      convertTestPlanTestCaseDependency(ext, tgt.addDependency());
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun")) {
      convertTestPlanTestCaseTestRun(ext, tgt.addTestRun());
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData")) {
      convertTestPlanTestCaseTestData(ext, tgt.addTestData());
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion")) {
      convertTestPlanTestCaseAssertion(ext, tgt.addAssertion());
    }
  }

  private static void convertTestPlanTestCaseDependency(Extension src, TestCaseDependencyComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.description",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.predecessor"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.description")) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.description").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.predecessor")) {
      tgt.setPredecessor(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.predecessor").getValue()));
    }
  }

  private static void convertTestPlanTestCaseTestRun(Extension src, TestPlanTestCaseTestRunComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.narrative",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.narrative")) {
      tgt.setNarrativeElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.narrative").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script")) {
      convertTestPlanTestCaseTestRunScript(src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script"), tgt.getScript());
    }
  }

  private static void convertTestPlanTestCaseTestRunScript(Extension src, TestPlanTestCaseTestRunScriptComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.language",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceString",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceReference"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.language")) {
      tgt.setLanguage(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.language").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceString")) {
      tgt.setSource(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceString").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceReference")) {
      tgt.setSource(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceReference").getValue()));
    }
  }

  private static void convertTestPlanTestCaseTestData(Extension src, TestPlanTestCaseTestDataComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.type",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.content",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceString",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceReference"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.type")) {
      tgt.setType(Coding40_50.convertCoding((org.hl7.fhir.r4.model.Coding) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.type").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.content")) {
      tgt.setContent(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.content").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceString")) {
      tgt.setSource(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceString").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceReference")) {
      tgt.setSource(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceReference").getValue()));
    }
  }

  private static void convertTestPlanTestCaseAssertion(Extension src, TestPlanTestCaseAssertionComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.type",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result"
        );
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.type")) {
      tgt.getType().add(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object")) {
      convertTestPlanTestCaseAssertionObject(ext, tgt.addObject());
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result")) {
      convertTestPlanTestCaseAssertionResult(ext, tgt.addResult());
    }
  }

  private static void convertTestPlanTestCaseAssertionObject(Extension src, CodeableReference tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object.concept",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object.reference"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object.concept")) {
      tgt.setConcept(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object.concept").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object.reference")) {
      tgt.setReference(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object.reference").getValue()));
    }
  }

  private static void convertTestPlanTestCaseAssertionResult(Extension src, CodeableReference tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result.concept",
        "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result.reference"
        );
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result.concept")) {
      tgt.setConcept(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result.concept").getValue()));
    }
    if (src.hasExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result.reference")) {
      tgt.setReference(Reference40_50.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result.reference").getValue()));
    }
  }


  /*
   * R5 to R4 private methods
   */

  private static void convertTestPlanDependency(TestPlanDependencyComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.description", MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasPredecessor()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.dependency.predecessor", Reference40_50.convertReference(src.getPredecessor()));
    }
  }

  private static void convertTestPlanTestCase(TestPlanTestCaseComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasSequenceElement()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.sequence", Integer40_50.convertInteger(src.getSequenceElement()));
    }
    for (Reference ref : src.getScope()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.scope", Reference40_50.convertReference(ref));
    }
    for (TestCaseDependencyComponent ref : src.getDependency()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseDependency(ref, tgte);
    }
    for (TestPlanTestCaseTestRunComponent ref : src.getTestRun()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseTestRun(ref, tgte);
    }
    for (TestPlanTestCaseTestDataComponent ref : src.getTestData()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseTestData(ref, tgte);
    }
    for (TestPlanTestCaseAssertionComponent ref : src.getAssertion()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseAssertion(ref, tgte);
    }
  }

  private static void convertTestPlanTestCaseDependency(TestCaseDependencyComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.description", MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasPredecessor()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.dependency.predecessor", Reference40_50.convertReference(src.getPredecessor()));
    }
  }

  private static void convertTestPlanTestCaseTestRun(TestPlanTestCaseTestRunComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasNarrativeElement()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.narrative", MarkDown40_50.convertMarkdown(src.getNarrativeElement()));
    }
    if (src.hasScript()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseTestRunScript(src.getScript(), tgte);
    }
  }

  private static void convertTestPlanTestCaseTestRunScript(TestPlanTestCaseTestRunScriptComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasLanguage()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.language", CodeableConcept40_50.convertCodeableConcept(src.getLanguage()));
    }
    if (src.hasSourceStringType()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceString", String40_50.convertString(src.getSourceStringType()));
    }
    if (src.hasSourceReference()) {
     tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testRun.script.sourceReference", Reference40_50.convertReference(src.getSourceReference()));
    }
  }

  private static void convertTestPlanTestCaseTestData(TestPlanTestCaseTestDataComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.type", Coding40_50.convertCoding(src.getType()));
    }
    if (src.hasContent()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.content", Reference40_50.convertReference(src.getContent()));
    }
    if (src.hasSourceStringType()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceString", String40_50.convertString(src.getSourceStringType()));
    }
    if (src.hasSourceReference()) {
     tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testData.sourceReference", Reference40_50.convertReference(src.getSourceReference()));
    }
  }

  private static void convertTestPlanTestCaseAssertion(TestPlanTestCaseAssertionComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (CodeableConcept cc : src.getType()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.type", CodeableConcept40_50.convertCodeableConcept(cc));
    }
    for (CodeableReference ref : src.getObject()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.object");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseAssertionObject(ref, tgte);
    }
    for (CodeableReference ref : src.getObject()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.assertion.result");
      tgt.addExtension(tgte);
      convertTestPlanTestCaseAssertionResult(ref, tgte);
    }
  }

  private static void convertTestPlanTestCaseAssertionObject(CodeableReference src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasConcept()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testCase.assertion.object.concept", CodeableConcept40_50.convertCodeableConcept(src.getConcept()));
    }
    if (src.hasReference()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testCase.assertion.object.reference", Reference40_50.convertReference(src.getReference()));
    }
  }

  private static void convertTestPlanTestCaseAssertionResult(CodeableReference src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasConcept()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testCase.assertion.result.concept", CodeableConcept40_50.convertCodeableConcept(src.getConcept()));
    }
    if (src.hasReference()) {
      tgt.addExtension("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestPlan.testCase.testCase.assertion.result.reference", Reference40_50.convertReference(src.getReference()));
    }
  }

}
