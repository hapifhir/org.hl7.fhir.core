package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.Expression40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.*;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.*;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.exceptions.FHIRException;

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
public class TestPlan40_N {
  // ============================================================================================
  // TestPlan <-> Basic
  //
  // R4 has no TestPlan, and the testing-IG TestPlan is a ground-up redesign relative to the R5
  // TestPlan, so rather than converting to the R5 TestPlan we round-trip the whole resource through
  // Basic, carrying every element as an extension - the same technique Requirements40_N /
  // TestPlan40_N use for resources with no representation in the target version. The extension URLs
  // use the 6.0 namespace (the testing-IG TestPlan is R6-shaped), keeping them distinct from the 5.0
  // extension URLs the native R5 TestPlan uses. Reusable/nested backbones (scope, parameter, suite,
  // input, test, assertion) use short relative sub-extension URLs within their wrapper extension, so
  // the same component converter serves every place the component appears (including recursive suites).
  // input.resource (an inline resource) has no extension representation, so it is carried as a
  // contained resource on the Basic (id "tpc-N") and referenced from the input extension.
  // ============================================================================================

  private static final String TP_BASE = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestPlan.";
  private static final String TP_URL = TP_BASE + "url";
  private static final String TP_VERSION = TP_BASE + "version";
  private static final String TP_VERSION_ALGORITHM = TP_BASE + "versionAlgorithm";
  private static final String TP_NAME = TP_BASE + "name";
  private static final String TP_TITLE = TP_BASE + "title";
  private static final String TP_STATUS = TP_BASE + "status";
  private static final String TP_EXPERIMENTAL = TP_BASE + "experimental";
  private static final String TP_DATE = TP_BASE + "date";
  private static final String TP_PUBLISHER = TP_BASE + "publisher";
  private static final String TP_CONTACT = TP_BASE + "contact";
  private static final String TP_DESCRIPTION = TP_BASE + "description";
  private static final String TP_USE_CONTEXT = TP_BASE + "useContext";
  private static final String TP_JURISDICTION = TP_BASE + "jurisdiction";
  private static final String TP_PURPOSE = TP_BASE + "purpose";
  private static final String TP_COPYRIGHT = TP_BASE + "copyright";
  private static final String TP_COPYRIGHT_LABEL = TP_BASE + "copyrightLabel";
  private static final String TP_SCOPE = TP_BASE + "scope";
  private static final String TP_DEPENDENCY = TP_BASE + "dependency";
  private static final String TP_RUNNER = TP_BASE + "runner";
  private static final String TP_MODE = TP_BASE + "mode";
  private static final String TP_PARAMETER = TP_BASE + "parameter";
  private static final String TP_SUITE = TP_BASE + "suite";

  private static final String[] TP_IGNORED_EXTENSION_URLS = new String[] {
    TP_URL, TP_VERSION, TP_VERSION_ALGORITHM, TP_NAME, TP_TITLE, TP_STATUS, TP_EXPERIMENTAL,
    TP_DATE, TP_PUBLISHER, TP_CONTACT, TP_DESCRIPTION, TP_USE_CONTEXT, TP_JURISDICTION, TP_PURPOSE,
    TP_COPYRIGHT, TP_COPYRIGHT_LABEL, TP_SCOPE, TP_DEPENDENCY, TP_RUNNER, TP_MODE, TP_PARAMETER, TP_SUITE };

  public static org.hl7.fhir.r4.model.Basic convertTestPlan(org.hl7.fhir.model.testing.TestPlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("TestPlan");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.getIdentifier().add(Identifier40_N.convertIdentifier(t));
    if (src.hasUrl())
      tgt.addExtension(TP_URL, Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.addExtension(TP_VERSION, String40_N.convertString(src.getVersionElement()));
    if (src.hasVersionAlgorithm())
      tgt.addExtension(TP_VERSION_ALGORITHM, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getVersionAlgorithm()));
    if (src.hasName())
      tgt.addExtension(TP_NAME, String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.addExtension(TP_TITLE, String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.addExtension(TP_STATUS, new org.hl7.fhir.r4.model.CodeType(src.getStatus().toCode()));
    if (src.hasExperimental())
      tgt.addExtension(TP_EXPERIMENTAL, Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.addExtension(TP_DATE, DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.addExtension(TP_PUBLISHER, String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addExtension(TP_CONTACT, ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.addExtension(TP_DESCRIPTION, MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addExtension(TP_USE_CONTEXT, UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addExtension(TP_JURISDICTION, CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.addExtension(TP_PURPOSE, MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.addExtension(TP_COPYRIGHT, MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCopyrightLabel())
      tgt.addExtension(TP_COPYRIGHT_LABEL, String40_N.convertString(src.getCopyrightLabelElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent t : src.getScopeList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_SCOPE);
      tgt.addExtension(tgte);
      convertTestPlanScope(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent t : src.getDependencyList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_DEPENDENCY);
      tgt.addExtension(tgte);
      convertTestPlanDependency(t, tgte);
    }
    if (src.hasRunner())
      tgt.addExtension(TP_RUNNER, Url40_N.convertUrl(src.getRunnerElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent t : src.getModeList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_MODE);
      tgt.addExtension(tgte);
      convertTestPlanMode(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_PARAMETER);
      tgt.addExtension(tgte);
      convertTestPlanParameter(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_SUITE);
      tgt.addExtension(tgte);
      convertTestPlanSuite(t, tgte, tgt);
    }
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestPlan convertTestPlan(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
      throw new FHIRException("Error in logic: this Basic resource is not a TestPlan");
    }
    org.hl7.fhir.model.testing.TestPlan tgt = new org.hl7.fhir.model.testing.TestPlan();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, TP_IGNORED_EXTENSION_URLS);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.getIdentifierList().add(Identifier40_N.convertIdentifier(t));
    if (src.hasExtension(TP_URL))
      tgt.setUrlElement(Uri40_N.convertUri((org.hl7.fhir.r4.model.UriType) src.getExtensionByUrl(TP_URL).getValue()));
    if (src.hasExtension(TP_VERSION))
      tgt.setVersionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_VERSION).getValue()));
    if (src.hasExtension(TP_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(TP_VERSION_ALGORITHM).getValue()));
    if (src.hasExtension(TP_NAME))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_NAME).getValue()));
    if (src.hasExtension(TP_TITLE))
      tgt.setTitleElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_TITLE).getValue()));
    if (src.hasExtension(TP_STATUS))
      tgt.setStatus(org.hl7.fhir.model.core.Enumerations.PublicationStatus.fromCode(src.getExtensionByUrl(TP_STATUS).getValue().primitiveValue()));
    if (src.hasExtension(TP_EXPERIMENTAL))
      tgt.setExperimentalElement(Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(TP_EXPERIMENTAL).getValue()));
    if (src.hasExtension(TP_DATE))
      tgt.setDateElement(DateTime40_N.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src.getExtensionByUrl(TP_DATE).getValue()));
    if (src.hasExtension(TP_PUBLISHER))
      tgt.setPublisherElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_PUBLISHER).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_CONTACT))
      tgt.getContactList().add(ContactDetail40_N.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) ext.getValue()));
    if (src.hasExtension(TP_DESCRIPTION))
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TP_DESCRIPTION).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_USE_CONTEXT))
      tgt.getUseContextList().add(UsageContext40_N.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) ext.getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_JURISDICTION))
      tgt.getJurisdictionList().add(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    if (src.hasExtension(TP_PURPOSE))
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TP_PURPOSE).getValue()));
    if (src.hasExtension(TP_COPYRIGHT))
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TP_COPYRIGHT).getValue()));
    if (src.hasExtension(TP_COPYRIGHT_LABEL))
      tgt.setCopyrightLabelElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_COPYRIGHT_LABEL).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_SCOPE))
      convertTestPlanScope(ext, tgt.addScope());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_DEPENDENCY))
      convertTestPlanDependency(ext, tgt.addDependency());
    if (src.hasExtension(TP_RUNNER))
      tgt.setRunnerElement(Url40_N.convertUrl((org.hl7.fhir.r4.model.UrlType) src.getExtensionByUrl(TP_RUNNER).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_MODE))
      convertTestPlanMode(ext, tgt.addMode());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_PARAMETER))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_SUITE))
      convertTestPlanSuite(ext, tgt.addSuite(), src);
    // the input resources were carried as contained resources (id "tpc-N") and have now been
    // re-inlined into their inputs; drop them from the resource-level contained list that
    // copyDomainResource brought across
    tgt.getContained().removeIf(r -> r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"));
    return tgt;
  }

  private static void convertTestPlanScope(org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", Canonical40_N.convertCanonical(src.getReferenceElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanScope(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src.getExtensionByUrl("reference").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanDependency(org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", Canonical40_N.convertCanonical(src.getReferenceElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanDependency(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src.getExtensionByUrl("reference").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanMode(org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode())
      tgt.addExtension("code", String40_N.convertString(src.getCodeElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanMode(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "code", "description");
    if (src.hasExtension("code"))
      tgt.setCodeElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("code").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanParameter(org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.addExtension("value", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanParameter(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "value", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("value"))
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl("value").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
  }

  private static void convertTestPlanSuite(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent src, org.hl7.fhir.r4.model.Extension tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent t : src.getTestList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("test");
      tgt.addExtension(e);
      convertTestPlanSuiteTest(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("suite");
      tgt.addExtension(e);
      convertTestPlanSuite(t, e, basic);
    }
    for (org.hl7.fhir.model.core.Reference t : src.getPlanList())
      tgt.addExtension("plan", Reference40_N.convertReference(t));
  }

  private static void convertTestPlanSuite(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "description", "mode", "input", "parameter", "test", "suite", "plan");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("test"))
      convertTestPlanSuiteTest(ext, tgt.addTest(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("suite"))
      convertTestPlanSuite(ext, tgt.addSuite(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("plan"))
      tgt.getPlanList().add(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) ext.getValue()));
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent src, org.hl7.fhir.r4.model.Extension tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasFile())
      tgt.addExtension("file", String40_N.convertString(src.getFileElement()));
    if (src.hasResource()) {
      org.hl7.fhir.r4.model.Resource r = VersionConvertorFactory_40_N.convertResource(src.getResource());
      String id = "tpc-" + (basic.getContained().size() + 1);
      r.setId(id);
      basic.getContained().add(r);
      tgt.addExtension("resource", new org.hl7.fhir.r4.model.Reference("#" + id));
    }
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "file", "resource", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("file"))
      tgt.setFileElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("file").getValue()));
    if (src.hasExtension("resource")) {
      String ref = ((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl("resource").getValue()).getReference();
      String id = ref != null && ref.startsWith("#") ? ref.substring(1) : ref;
      for (org.hl7.fhir.r4.model.Resource c : basic.getContained()) {
        if (id != null && id.equals(c.getIdPart())) {
          org.hl7.fhir.model.core.Resource r = VersionConvertorFactory_40_N.convertResource(c);
          if (r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"))
            r.setIdBase(null);
          tgt.setResource(r);
        }
      }
    }
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent src, org.hl7.fhir.r4.model.Extension tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOperation())
      tgt.addExtension("operation", Code40_N.convertCode(src.getOperationElement()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getExpectedList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("expected");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent t : src.getAssertionList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("assertion");
      tgt.addExtension(e);
      convertTestPlanAssertion(t, e);
    }
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "description", "operation", "mode", "parameter", "input", "expected", "assertion");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
    if (src.hasExtension("operation"))
      tgt.setOperationElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("operation").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("expected"))
      convertTestPlanSuiteInput(ext, tgt.addExpected(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("assertion"))
      convertTestPlanAssertion(ext, tgt.addAssertion());
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasFocus())
      tgt.addExtension("focus", String40_N.convertString(src.getFocusElement()));
    if (src.hasSeverity())
      tgt.addExtension("severity", Code40_N.convertCode(src.getSeverityElement()));
    if (src.hasExpression())
      tgt.addExtension("expression", Expression40_N.convertExpression(src.getExpression()));
    if (src.hasHuman())
      tgt.addExtension("human", String40_N.convertString(src.getHumanElement()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "focus", "severity", "expression", "human", "mode");
    if (src.hasExtension("focus"))
      tgt.setFocusElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("focus").getValue()));
    if (src.hasExtension("severity"))
      tgt.setSeverityElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("severity").getValue()));
    if (src.hasExtension("expression"))
      tgt.setExpression(Expression40_N.convertExpression((org.hl7.fhir.r4.model.Expression) src.getExtensionByUrl("expression").getValue()));
    if (src.hasExtension("human"))
      tgt.setHumanElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("human").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
  }

}
