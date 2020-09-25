package org.hl7.fhir.r5.utils;

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



/*
Copyright (c) 2011+, HL7, Inc
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.fhir.ucum.Utilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Element;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.ExtensionHelper;
import org.hl7.fhir.r5.model.Factory;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Integer64Type;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;


public class ToolingExtensions {

  // validated
//  private static final String EXT_OID = "http://hl7.org/fhir/StructureDefinition/valueset-oid";
//  public static final String EXT_DEPRECATED = "http://hl7.org/fhir/StructureDefinition/codesystem-deprecated";
  public static final String EXT_DEFINITION = "http://hl7.org/fhir/StructureDefinition/valueset-concept-definition";
  public static final String EXT_CS_COMMENT = "http://hl7.org/fhir/StructureDefinition/codesystem-concept-comments";
  public static final String EXT_VS_COMMENT = "http://hl7.org/fhir/StructureDefinition/valueset-concept-comments";
  private static final String EXT_IDENTIFIER = "http://hl7.org/fhir/StructureDefinition/identifier";
  public static final String EXT_TRANSLATION = "http://hl7.org/fhir/StructureDefinition/translation";
  public static final String EXT_ISSUE_SOURCE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source";
  public static final String EXT_ISSUE_LINE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line";
  public static final String EXT_ISSUE_COL = "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col";
  public static final String EXT_DISPLAY_HINT = "http://hl7.org/fhir/StructureDefinition/structuredefinition-display-hint"; 
  public static final String EXT_REPLACED_BY = "http://hl7.org/fhir/StructureDefinition/valueset-replacedby";
  public static final String EXT_REGEX = "http://hl7.org/fhir/StructureDefinition/regex"; 
  public static final String EXT_CONTROL = "http://hl7.org/fhir/StructureDefinition/questionnaire-itemControl"; 
  public static final String EXT_MINOCCURS = "http://hl7.org/fhir/StructureDefinition/questionnaire-minOccurs"; 
  public static final String EXT_MAXOCCURS = "http://hl7.org/fhir/StructureDefinition/questionnaire-maxOccurs";
  public static final String EXT_ALLOWEDRESOURCE = "http://hl7.org/fhir/StructureDefinition/questionnaire-allowedResource";
  public static final String EXT_REFERENCEFILTER = "http://hl7.org/fhir/StructureDefinition/questionnaire-referenceFilter";
  public static final String EXT_CODE_GENERATION_PARENT = "http://hl7.org/fhir/StructureDefinition/structuredefinition-codegen-super";
  public static final String EXT_HIERARCHY = "http://hl7.org/fhir/StructureDefinition/structuredefinition-hierarchy";
  public static final String EXT_BEST_PRACTICE = "http://hl7.org/fhir/StructureDefinition/elementdefinition-bestpractice";
  public static final String EXT_BEST_PRACTICE_EXPLANATION = "http://hl7.org/fhir/StructureDefinition/elementdefinition-bestpractice-explanation";
  // unregistered?
  public static final String EXT_MAPPING_PREFIX = "http://hl7.org/fhir/tools/StructureDefinition/logical-mapping-prefix";
  public static final String EXT_MAPPING_SUFFIX = "http://hl7.org/fhir/tools/StructureDefinition/logical-mapping-suffix";

//  public static final String EXT_FLYOVER = "http://hl7.org/fhir/Profile/questionnaire-extensions#flyover";
  public static final String EXT_QTYPE = "http://hl7.org/fhir/StructureDefinition/questionnnaire-baseType";
//  private static final String EXT_QREF = "http://www.healthintersections.com.au/fhir/Profile/metadata#reference";
//  private static final String EXTENSION_FILTER_ONLY = "http://www.healthintersections.com.au/fhir/Profile/metadata#expandNeedsFilter";
//  private static final String EXT_TYPE = "http://www.healthintersections.com.au/fhir/Profile/metadata#type";
//  private static final String EXT_REFERENCE = "http://www.healthintersections.com.au/fhir/Profile/metadata#reference";
  private static final String EXT_FHIRTYPE = "http://hl7.org/fhir/StructureDefinition/questionnaire-fhirType";
  private static final String EXT_ALLOWABLE_UNITS = "http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits";
  public static final String EXT_CIMI_REFERENCE = "http://hl7.org/fhir/StructureDefinition/cimi-reference";
  public static final String EXT_UNCLOSED = "http://hl7.org/fhir/StructureDefinition/valueset-unclosed";
  public static final String EXT_FMM_LEVEL = "http://hl7.org/fhir/StructureDefinition/structuredefinition-fmm";
  public static final String EXT_SEC_CAT = "http://hl7.org/fhir/StructureDefinition/structuredefinition-security-category";
  public static final String EXT_RESOURCE_CATEGORY = "http://hl7.org/fhir/StructureDefinition/structuredefinition-category";
  public static final String EXT_RESOURCE_INTERFACE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-interface";
  public static final String EXT_TABLE_NAME = "http://hl7.org/fhir/StructureDefinition/structuredefinition-table-name";
  public static final String EXT_OO_FILE = "http://hl7.org/fhir/StructureDefinition/operationoutcome-file";
  public static final String EXT_WORKGROUP = "http://hl7.org/fhir/StructureDefinition/structuredefinition-wg";
  public static final String EXT_STANDARDS_STATUS = "http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status";
  public static final String EXT_NORMATIVE_VERSION = "http://hl7.org/fhir/StructureDefinition/structuredefinition-normative-version";
  public static final String EXT_IGP_BASE = "http://hl7.org/fhir/StructureDefinition/igpublisher-res-base";
  public static final String EXT_IGP_DEFNS = "http://hl7.org/fhir/StructureDefinition/igpublisher-res-defns";
  public static final String EXT_IGP_FORMAT = "http://hl7.org/fhir/StructureDefinition/igpublisher-res-format";
  public static final String EXT_IGP_SOURCE = "http://hl7.org/fhir/StructureDefinition/igpublisher-res-source";
  public static final String EXT_IGP_VERSION = "http://hl7.org/fhir/StructureDefinition/igpublisher-res-version";
  public static final String EXT_IGP_RESOURCES = "http://hl7.org/fhir/StructureDefinition/igpublisher-folder-resource";
  public static final String EXT_IGP_PAGES = "http://hl7.org/fhir/StructureDefinition/igpublisher-folder-pages";
  public static final String EXT_IGP_SPREADSHEET = "http://hl7.org/fhir/StructureDefinition/igpublisher-spreadsheet";
  public static final String EXT_IGP_MAPPING_CSV = "http://hl7.org/fhir/StructureDefinition/igpublisher-mapping-csv";
  public static final String EXT_IGP_BUNDLE = "http://hl7.org/fhir/StructureDefinition/igpublisher-bundle";
  public static final String EXT_IGP_RESOURCE_INFO = "http://hl7.org/fhir/tools/StructureDefinition/resource-information";
  public static final String EXT_IGP_LOADVERSION = "http://hl7.org/fhir/StructureDefinition/igpublisher-loadversion";
  public static final String EXT_MAX_VALUESET = "http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet";
  public static final String EXT_MIN_VALUESET = "http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet";
  public static final String EXT_PROFILE_ELEMENT = "http://hl7.org/fhir/StructureDefinition/elementdefinition-profile-element";
  public static final String EXT_LIST_PACKAGE = "http://hl7.org/fhir/StructureDefinition/list-packageId";
  public static final String EXT_MAPPING_NAME = "http://hl7.org/fhir/tools/StructureDefinition/conceptmap-source-name";
  public static final String EXT_MAPPING_TYPE = "http://hl7.org/fhir/tools/StructureDefinition/conceptmap-source-type";
  public static final String EXT_MAPPING_CARD = "http://hl7.org/fhir/tools/StructureDefinition/conceptmap-source-cardinality";
  public static final String EXT_MAPPING_TGTTYPE = "http://hl7.org/fhir/tools/StructureDefinition/conceptmap-target-type";
  public static final String EXT_MAPPING_TGTCARD = "http://hl7.org/fhir/tools/StructureDefinition/conceptmap-target-cardinality";
  public static final String EXT_PRIVATE_BASE = "http://hl7.org/fhir/tools/";
  public static final String EXT_ALLOWED_TYPE =  "http://hl7.org/fhir/StructureDefinition/operationdefinition-allowed-type";
  public static final String EXT_FHIR_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type";
  public static final String EXT_XML_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-xml-type";
  public static final String EXT_RENDERED_VALUE = "http://hl7.org/fhir/StructureDefinition/rendered-value";
  public static final String EXT_OLD_CONCEPTMAP_EQUIVALENCE = "http://hl7.org/fhir/1.0/StructureDefinition/extension-ConceptMap.element.target.equivalence";
  public static final String EXT_EXP_FRAGMENT = "http://hl7.org/fhir/tools/StructureDefinition/expansion-codesystem-fragment";
  public static final String EXT_EXP_TOOCOSTLY = "http://hl7.org/fhir/StructureDefinition/valueset-toocostly";
  public static final String EXT_MUST_SUPPORT = "http://hl7.org/fhir/StructureDefinition/elementdefinition-type-must-support";

  // specific extension helpers

  public static Extension makeIssueSource(Source source) {
    Extension ex = new Extension();
    // todo: write this up and get it published with the pack (and handle the redirect?)
    ex.setUrl(ToolingExtensions.EXT_ISSUE_SOURCE);
    CodeType c = new CodeType();
    c.setValue(source.toString());
    ex.setValue(c);
    return ex;
  }

  public static boolean hasExtension(DomainResource de, String url) {
    return getExtension(de, url) != null;
  }

  public static boolean hasExtension(Element e, String url) {
    return getExtension(e, url) != null;
  }

//  public static void addStringExtension(DomainResource dr, String url, String content) {
//    if (!StringUtils.isBlank(content)) {
//      Extension ex = getExtension(dr, url);
//      if (ex != null)
//        ex.setValue(new StringType(content));
//      else
//        dr.getExtension().add(Factory.newExtension(url, new StringType(content), true));   
//    }
//  }

  public static void addMarkdownExtension(DomainResource dr, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(dr, url);
      if (ex != null)
        ex.setValue(new StringType(content));
      else
        dr.getExtension().add(Factory.newExtension(url, new MarkdownType(content), true));   
    }
  }

  public static void addStringExtension(Element e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new StringType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new StringType(content), true));   
    }
  }

  public static void addCodeExtension(Element e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new CodeType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new CodeType(content), true));   
    }
  }

  public static void addStringExtension(DomainResource e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new StringType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new StringType(content), true));   
    }
  }


  public static void addBooleanExtension(Element e, String url, boolean content) {
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new BooleanType(content));
    else
      e.getExtension().add(Factory.newExtension(url, new BooleanType(content), true));   
  }

  public static void addBooleanExtension(DomainResource e, String url, boolean content) {
    Extension ex = getExtension(e, url);
    if (ex != null)
      ex.setValue(new BooleanType(content));
    else
      e.getExtension().add(Factory.newExtension(url, new BooleanType(content), true));   
  }

  public static void addIntegerExtension(DomainResource dr, String url, int value) {
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new IntegerType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new IntegerType(value), true));   
  }

  public static void addCodeExtension(DomainResource dr, String url, String value) {
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new CodeType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new CodeType(value), true));   
  }

  public static void addVSComment(ConceptSetComponent nc, String comment) {
    if (!StringUtils.isBlank(comment))
      nc.getExtension().add(Factory.newExtension(EXT_VS_COMMENT, Factory.newString_(comment), true));   
  }
  public static void addVSComment(ConceptReferenceComponent nc, String comment) {
    if (!StringUtils.isBlank(comment))
      nc.getExtension().add(Factory.newExtension(EXT_VS_COMMENT, Factory.newString_(comment), true));   
  }

  public static void addCSComment(ConceptDefinitionComponent nc, String comment) {
    if (!StringUtils.isBlank(comment))
      nc.getExtension().add(Factory.newExtension(EXT_CS_COMMENT, Factory.newString_(comment), true));   
  }

//  public static void markDeprecated(Element nc) {
//    setDeprecated(nc);   
//  }
//

  public static void addDefinition(Element nc, String definition) {
    if (!StringUtils.isBlank(definition))
      nc.getExtension().add(Factory.newExtension(EXT_DEFINITION, Factory.newString_(definition), true));   
  }

  public static void addDisplayHint(Element def, String hint) {
    if (!StringUtils.isBlank(hint))
      def.getExtension().add(Factory.newExtension(EXT_DISPLAY_HINT, Factory.newString_(hint), true));   
  }

  public static String getDisplayHint(Element def) {
    return readStringExtension(def, EXT_DISPLAY_HINT);    
  }

  public static String readStringExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (ex.getValue() instanceof UriType)
      return ((UriType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CanonicalType)
      return ((CanonicalType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CodeType)
      return ((CodeType) ex.getValue()).getValue();
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof Integer64Type)
      return ((Integer64Type) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof DecimalType)
      return ((DecimalType) ex.getValue()).asStringValue();
    if ((ex.getValue() instanceof MarkdownType))
      return ((MarkdownType) ex.getValue()).getValue();
    if ((ex.getValue() instanceof PrimitiveType))
      return ((PrimitiveType) ex.getValue()).primitiveValue();
    if (!(ex.getValue() instanceof StringType))
      return null;
    return ((StringType) ex.getValue()).getValue();
  }

  public static String readStringExtension(DomainResource c, String uri) {
    Extension ex = getExtension(c, uri);
    if (ex == null)
      return null;
    if ((ex.getValue() instanceof StringType))
      return ((StringType) ex.getValue()).getValue();
    if ((ex.getValue() instanceof UriType))
      return ((UriType) ex.getValue()).getValue();
    if (ex.getValue() instanceof CodeType)
      return ((CodeType) ex.getValue()).getValue();
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof Integer64Type)
      return ((Integer64Type) ex.getValue()).asStringValue();
    if (ex.getValue() instanceof DecimalType)
      return ((DecimalType) ex.getValue()).asStringValue();
    if ((ex.getValue() instanceof MarkdownType))
      return ((MarkdownType) ex.getValue()).getValue();
    return null;
  }

  @SuppressWarnings("unchecked")
  public static PrimitiveType<DataType> readPrimitiveExtension(DomainResource c, String uri) {
    Extension ex = getExtension(c, uri);
    if (ex == null)
      return null;
    return (PrimitiveType<DataType>) ex.getValue();
  }

  public static boolean findStringExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof StringType))
      return false;
    return !StringUtils.isBlank(((StringType) ex.getValue()).getValue());
  }

  public static Boolean readBooleanExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (!(ex.getValue() instanceof BooleanType))
      return null;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean findBooleanExtension(Element c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return true;
  }

  public static Boolean readBooleanExtension(DomainResource c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return null;
    if (!(ex.getValue() instanceof BooleanType))
      return null;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean readBoolExtension(DomainResource c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean readBoolExtension(Element e, String uri) {
    Extension ex = ExtensionHelper.getExtension(e, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return ((BooleanType) ex.getValue()).getValue();
  }

  public static boolean findBooleanExtension(DomainResource c, String uri) {
    Extension ex = ExtensionHelper.getExtension(c, uri);
    if (ex == null)
      return false;
    if (!(ex.getValue() instanceof BooleanType))
      return false;
    return true;
  }

  public static String getCSComment(ConceptDefinitionComponent c) {
    return readStringExtension(c, EXT_CS_COMMENT);    
  }
//
//  public static Boolean getDeprecated(Element c) {
//    return readBooleanExtension(c, EXT_DEPRECATED);    
//  }

  public static boolean hasCSComment(ConceptDefinitionComponent c) {
    return findStringExtension(c, EXT_CS_COMMENT);    
  }

//  public static boolean hasDeprecated(Element c) {
//    return findBooleanExtension(c, EXT_DEPRECATED);    
//  }

  public static void addFlyOver(QuestionnaireItemComponent item, String text){
    if (!StringUtils.isBlank(text)) {
    	QuestionnaireItemComponent display = item.addItem();
    	display.setType(QuestionnaireItemType.DISPLAY);
    	display.setText(text);
    	display.getExtension().add(Factory.newExtension(EXT_CONTROL, Factory.newCodeableConcept("flyover", "http://hl7.org/fhir/questionnaire-item-control", "Fly-over"), true));
    }
  }

  public static void addMin(QuestionnaireItemComponent item, int min) {
    item.getExtension().add(Factory.newExtension(EXT_MINOCCURS, Factory.newInteger(min), true));
  }
  
  public static void addMax(QuestionnaireItemComponent item, int max) {
    item.getExtension().add(Factory.newExtension(EXT_MAXOCCURS, Factory.newInteger(max), true));
  }
  
  public static void addFhirType(QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(EXT_FHIRTYPE, Factory.newString_(value), true));       
  }

  public static void addControl(QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(EXT_CONTROL, Factory.newCodeableConcept(value, "http://hl7.org/fhir/questionnaire-item-control", value), true));
  }

  public static void addAllowedResource(QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(EXT_ALLOWEDRESOURCE, Factory.newCode(value), true));       
  }

  public static void addReferenceFilter(QuestionnaireItemComponent group, String value) {
    group.getExtension().add(Factory.newExtension(EXT_REFERENCEFILTER, Factory.newString_(value), true));       
  }

  public static void addIdentifier(Element element, Identifier value) {
    element.getExtension().add(Factory.newExtension(EXT_IDENTIFIER, value, true));       
  }

  /**
   * @param name the identity of the extension of interest
   * @return The extension, if on this element, else null
   */
  public static Extension getExtension(DomainResource resource, String name) {
    if (name == null)
      return null;
    if (!resource.hasExtension())
      return null;
    for (Extension e : resource.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  public static Extension getExtension(Element el, String name) {
    if (name == null)
      return null;
    if (!el.hasExtension())
      return null;
    for (Extension e : el.getExtension()) {
      if (name.equals(e.getUrl()))
        return e;
    }
    return null;
  }

  public static void setStringExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
        Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new StringType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new StringType(value)));
  }

  public static void setStringExtension(Element resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
        Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new StringType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new StringType(value)));
  }

  public static void setCodeExtension(DomainResource resource, String uri, String value) {
    if (Utilities.noString(value))
      return;
    
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new CodeType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new CodeType(value)));
  }

  public static void setCodeExtension(Element element, String uri, String value) {
    if (Utilities.noString(value))
      return;
    
    Extension ext = getExtension(element, uri);
    if (ext != null)
      ext.setValue(new CodeType(value));
    else
      element.getExtension().add(new Extension(uri).setValue(new CodeType(value)));
  }

  public static void setIntegerExtension(DomainResource resource, String uri, int value) {
    Extension ext = getExtension(resource, uri);
    if (ext != null)
      ext.setValue(new IntegerType(value));
    else
      resource.getExtension().add(new Extension(uri).setValue(new IntegerType(value)));
  }

//  public static String getOID(CodeSystem define) {
//    return readStringExtension(define, EXT_OID);    
//  }
//
//  public static String getOID(ValueSet vs) {
//    return readStringExtension(vs, EXT_OID);    
//  }
//
//  public static void setOID(CodeSystem define, String oid) throws FHIRFormatError, URISyntaxException {
//    if (!oid.startsWith("urn:oid:"))
//      throw new FHIRFormatError("Error in OID format");
//    if (oid.startsWith("urn:oid:urn:oid:"))
//      throw new FHIRFormatError("Error in OID format");
//    if (!hasExtension(define, EXT_OID))
//    define.getExtension().add(Factory.newExtension(EXT_OID, Factory.newUri(oid), false));       
//    else if (!oid.equals(readStringExtension(define, EXT_OID)))
//      throw new Error("Attempt to assign multiple OIDs to a code system");
//  }
//  public static void setOID(ValueSet vs, String oid) throws FHIRFormatError, URISyntaxException {
//    if (!oid.startsWith("urn:oid:"))
//      throw new FHIRFormatError("Error in OID format");
//    if (oid.startsWith("urn:oid:urn:oid:"))
//      throw new FHIRFormatError("Error in OID format");
//    if (!hasExtension(vs, EXT_OID))
//    vs.getExtension().add(Factory.newExtension(EXT_OID, Factory.newUri(oid), false));       
//    else if (!oid.equals(readStringExtension(vs, EXT_OID)))
//      throw new Error("Attempt to assign multiple OIDs to value set "+vs.getName()+" ("+vs.getUrl()+"). Has "+readStringExtension(vs, EXT_OID)+", trying to add "+oid);
//  }

  public static boolean hasLanguageTranslation(Element element, String lang) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(EXT_TRANSLATION)) {
        Extension e1 = ExtensionHelper.getExtension(e, "lang");

        if (e1 != null && e1.getValue() instanceof CodeType && ((CodeType) e.getValue()).getValue().equals(lang))
          return true;
      }
    }
    return false;
  }

  public static String getLanguageTranslation(Element element, String lang) {
    for (Extension e : element.getExtension()) {
      if (e.getUrl().equals(EXT_TRANSLATION)) {
        Extension e1 = ExtensionHelper.getExtension(e, "lang");

        if (e1 != null && e1.getValue() instanceof CodeType && ((CodeType) e.getValue()).getValue().equals(lang)) {
          e1 = ExtensionHelper.getExtension(e, "content");
          return ((StringType) e.getValue()).getValue();
        }
      }
    }
    return null;
  }

  public static void addLanguageTranslation(Element element, String lang, String value) {
    if (Utilities.noString(lang) || Utilities.noString(value))
      return;
    
    Extension extension = new Extension().setUrl(EXT_TRANSLATION);
    extension.addExtension().setUrl("lang").setValue(new CodeType(lang));
    extension.addExtension().setUrl("content").setValue(new StringType(value));
    element.getExtension().add(extension);
  }

  public static DataType getAllowedUnits(ElementDefinition eld) {
    for (Extension e : eld.getExtension()) 
      if (e.getUrl().equals(EXT_ALLOWABLE_UNITS)) 
        return e.getValue();
    return null;
  }

  public static void setAllowableUnits(ElementDefinition eld, CodeableConcept cc) {
    for (Extension e : eld.getExtension()) 
      if (e.getUrl().equals(EXT_ALLOWABLE_UNITS)) {
        e.setValue(cc);
        return;
      }
    eld.getExtension().add(new Extension().setUrl(EXT_ALLOWABLE_UNITS).setValue(cc));
  }

  public static List<Extension> getExtensions(Element element, String url) {
    List<Extension> results = new ArrayList<Extension>();
    for (Extension ex : element.getExtension())
      if (ex.getUrl().equals(url))
        results.add(ex);
    return results;
  }

  public static List<Extension> getExtensions(DomainResource resource, String url) {
    List<Extension> results = new ArrayList<Extension>();
    for (Extension ex : resource.getExtension())
      if (ex.getUrl().equals(url))
        results.add(ex);
    return results;
  }

//  public static void addDEReference(DataElement de, String value) {
//    for (Extension e : de.getExtension()) 
//      if (e.getUrl().equals(EXT_CIMI_REFERENCE)) {
//        e.setValue(new UriType(value));
//        return;
//      }
//    de.getExtension().add(new Extension().setUrl(EXT_CIMI_REFERENCE).setValue(new UriType(value)));
//  }

//  public static void setDeprecated(Element nc) {
//    for (Extension e : nc.getExtension()) 
//      if (e.getUrl().equals(EXT_DEPRECATED)) {
//        e.setValue(new BooleanType(true));
//        return;
//      }
//    nc.getExtension().add(new Extension().setUrl(EXT_DEPRECATED).setValue(new BooleanType(true)));    
//  }

  public static void setExtension(Element focus, String url, Coding c) {
    for (Extension e : focus.getExtension()) 
      if (e.getUrl().equals(url)) {
        e.setValue(c);
        return;
      }
    focus.getExtension().add(new Extension().setUrl(url).setValue(c));    
  }

  public static void removeExtension(DomainResource focus, String url) {
    Iterator<Extension> i = focus.getExtension().iterator();
    while (i.hasNext()) {
      Extension e = i.next(); // must be called before you can call i.remove()
      if (e.getUrl().equals(url)) {
        i.remove();
      }
    }
  }
  
  public static void removeExtension(Element focus, String url) {
    Iterator<Extension> i = focus.getExtension().iterator();
    while (i.hasNext()) {
      Extension e = i.next(); // must be called before you can call i.remove()
      if (e.getUrl().equals(url)) {
        i.remove();
      }
    }
  }

  public static int readIntegerExtension(DomainResource dr, String uri, int defaultValue) {
    Extension ex = ExtensionHelper.getExtension(dr, uri);
    if (ex == null)
      return defaultValue;
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).getValue();
    throw new Error("Unable to read extension "+uri+" as an integer");
  }

  public static int readIntegerExtension(Element e, String uri, int defaultValue) {
    Extension ex = ExtensionHelper.getExtension(e, uri);
    if (ex == null)
      return defaultValue;
    if (ex.getValue() instanceof IntegerType)
      return ((IntegerType) ex.getValue()).getValue();
    throw new Error("Unable to read extension "+uri+" as an integer");
  }

  public static Map<String, String> getLanguageTranslations(Element e) {
    Map<String, String> res = new HashMap<String, String>();
    for (Extension ext : e.getExtension()) {
      if (ext.getUrl().equals(EXT_TRANSLATION)) {
        String lang = readStringExtension(ext, "lang");
        String value = readStringExtension(ext, "content");
        res.put(lang,  value);
      }
    }
    return res;
  }

  public static StandardsStatus getStandardsStatus(DomainResource dr) throws FHIRException {
    return StandardsStatus.fromCode(ToolingExtensions.readStringExtension(dr, ToolingExtensions.EXT_STANDARDS_STATUS));
  }

  public static void setStandardsStatus(DomainResource dr, StandardsStatus status, String normativeVersion) {
    if (status == null)
      ToolingExtensions.removeExtension(dr, ToolingExtensions.EXT_STANDARDS_STATUS);
    else
      ToolingExtensions.setCodeExtension(dr, ToolingExtensions.EXT_STANDARDS_STATUS, status.toCode());
    if (normativeVersion == null)
      ToolingExtensions.removeExtension(dr, ToolingExtensions.EXT_NORMATIVE_VERSION);
    else
      ToolingExtensions.setCodeExtension(dr, ToolingExtensions.EXT_NORMATIVE_VERSION, normativeVersion);
  }

  public static void setStandardsStatus(Element dr, StandardsStatus status, String normativeVersion) {
    if (status == null)
      ToolingExtensions.removeExtension(dr, ToolingExtensions.EXT_STANDARDS_STATUS);
    else
      ToolingExtensions.setCodeExtension(dr, ToolingExtensions.EXT_STANDARDS_STATUS, status.toCode());
    if (normativeVersion == null)
      ToolingExtensions.removeExtension(dr, ToolingExtensions.EXT_NORMATIVE_VERSION);
    else
      ToolingExtensions.setCodeExtension(dr, ToolingExtensions.EXT_NORMATIVE_VERSION, normativeVersion);
  }

  public static ValidationMessage readValidationMessage(OperationOutcomeIssueComponent issue, Source source) {
    ValidationMessage vm = new ValidationMessage();
    vm.setSource(source);
    vm.setLevel(mapSeverity(issue.getSeverity()));
    vm.setType(mapType(issue.getCode()));
    if (issue.hasExtension(ToolingExtensions.EXT_ISSUE_LINE))
      vm.setLine(ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_LINE, 0));
    if (issue.hasExtension(ToolingExtensions.EXT_ISSUE_COL))
      vm.setCol(ToolingExtensions.readIntegerExtension(issue, ToolingExtensions.EXT_ISSUE_COL, 0));
    if (issue.hasExpression())
      vm.setLocation(issue.getExpression().get(0).asStringValue());
    vm.setMessage(issue.getDetails().getText());
    if (issue.hasExtension("http://hl7.org/fhir/StructureDefinition/rendering-xhtml"))
      vm.setHtml(ToolingExtensions.readStringExtension(issue, "http://hl7.org/fhir/StructureDefinition/rendering-xhtml"));
    return vm;
  }

  private static IssueType mapType(org.hl7.fhir.r5.model.OperationOutcome.IssueType code) {
    switch (code) {
    case BUSINESSRULE: return IssueType.BUSINESSRULE;
    case CODEINVALID: return IssueType.CODEINVALID;
    case CONFLICT: return IssueType.CONFLICT;
    case DELETED: return IssueType.DELETED;
    case DUPLICATE: return IssueType.DUPLICATE;
    case EXCEPTION: return IssueType.EXCEPTION;
    case EXPIRED: return IssueType.EXPIRED;
    case EXTENSION: return IssueType.EXTENSION;
    case FORBIDDEN: return IssueType.FORBIDDEN;
    case INCOMPLETE: return IssueType.INCOMPLETE;
    case INFORMATIONAL: return IssueType.INFORMATIONAL;
    case INVALID: return IssueType.INVALID;
    case INVARIANT: return IssueType.INVARIANT;
    case LOCKERROR: return IssueType.LOCKERROR;
    case LOGIN: return IssueType.LOGIN;
    case MULTIPLEMATCHES: return IssueType.MULTIPLEMATCHES;
    case NOSTORE: return IssueType.NOSTORE;
    case NOTFOUND: return IssueType.NOTFOUND;
    case NOTSUPPORTED: return IssueType.NOTSUPPORTED;
    case NULL: return IssueType.NULL;
    case PROCESSING: return IssueType.PROCESSING;
    case REQUIRED: return IssueType.REQUIRED;
    case SECURITY: return IssueType.SECURITY;
    case STRUCTURE: return IssueType.STRUCTURE;
    case SUPPRESSED: return IssueType.SUPPRESSED;
    case THROTTLED: return IssueType.THROTTLED;
    case TIMEOUT: return IssueType.TIMEOUT;
    case TOOCOSTLY: return IssueType.TOOCOSTLY;
    case TOOLONG: return IssueType.TOOLONG;
    case TRANSIENT: return IssueType.TRANSIENT;
    case UNKNOWN: return IssueType.UNKNOWN;
    case VALUE: return IssueType.VALUE;
    default: return null;
    }
  }

  private static IssueSeverity mapSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity severity) {
    switch (severity) {
    case ERROR: return IssueSeverity.ERROR;
    case FATAL: return IssueSeverity.FATAL;
    case INFORMATION: return IssueSeverity.INFORMATION;
    case WARNING: return IssueSeverity.WARNING;
    default: return null;
    }
  }

  public static String getPresentation(PrimitiveType<?> type) {
    if (type.hasExtension(EXT_RENDERED_VALUE))
      return readStringExtension(type, EXT_RENDERED_VALUE);
    return type.primitiveValue();
  }
  
  public static String getPresentation(Element holder, PrimitiveType<?> type) {
    if (holder.hasExtension(EXT_RENDERED_VALUE))
      return readStringExtension(holder, EXT_RENDERED_VALUE);
    if (type.hasExtension(EXT_RENDERED_VALUE))
      return readStringExtension(type, EXT_RENDERED_VALUE);
    return type.primitiveValue();
  }
  
//  public static boolean hasOID(ValueSet vs) {
//    return hasExtension(vs, EXT_OID);
//  }
//  
//  public static boolean hasOID(CodeSystem cs) {
//    return hasExtension(cs, EXT_OID);
//  }
//  
  public static void addUrlExtension(Element e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new UrlType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new UrlType(content), true));   
    }
  }

  public static void addUrlExtension(DomainResource dr, String url, String value) {
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new UrlType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new UrlType(value), true));   
  }

  public static void addUriExtension(Element e, String url, String content) {
    if (!StringUtils.isBlank(content)) {
      Extension ex = getExtension(e, url);
      if (ex != null)
        ex.setValue(new UriType(content));
      else
        e.getExtension().add(Factory.newExtension(url, new UriType(content), true));   
    }
  }

  public static void addUriExtension(DomainResource dr, String url, String value) {
    Extension ex = getExtension(dr, url);
    if (ex != null)
      ex.setValue(new UriType(value));
    else
      dr.getExtension().add(Factory.newExtension(url, new UriType(value), true));   
  }

  
}