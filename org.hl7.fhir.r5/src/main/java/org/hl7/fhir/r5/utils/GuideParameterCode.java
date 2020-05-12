package org.hl7.fhir.r5.utils;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Configuration;
import org.hl7.fhir.r5.model.EnumFactory;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.PrimitiveType;

public enum GuideParameterCode {
  /**
   * If the value of this string 0..* parameter is one of the metadata fields then all conformance resources will have any specified [Resource].[field] overwritten with the ImplementationGuide.[field], where field is one of: version, date, status, publisher, contact, copyright, experimental, jurisdiction, useContext.
   */
  APPLY, 
  /**
   * The value of this string 0..* parameter is a subfolder of the build context's location that is to be scanned to load resources. Scope is (if present) a particular resource type.
   */
  PATHRESOURCE, 
  /**
   * The value of this string 0..1 parameter is a subfolder of the build context's location that contains files that are part of the html content processed by the builder.
   */
  PATHPAGES, 
  /**
   * The value of this string 0..1 parameter is a subfolder of the build context's location that is used as the terminology cache. If this is not present, the terminology cache is on the local system, not under version control.
   */
  PATHTXCACHE, 
  /**
   * The value of this string 0..* parameter is a parameter (name=value) when expanding value sets for this implementation guide. This is particularly used to specify the versions of published terminologies such as SNOMED CT.
   */
  EXPANSIONPARAMETER, 
  /**
   * The value of this string 0..1 parameter is either "warning" or "error" (default = "error"). If the value is "warning" then IG build tools allow the IG to be considered successfully build even when there is no internal broken links.
   */
  RULEBROKENLINKS, 
  /**
   * The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in XML format. If not present, the Publication Tool decides whether to generate XML.
   */
  GENERATEXML, 
  /**
   * The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in JSON format. If not present, the Publication Tool decides whether to generate JSON.
   */
  GENERATEJSON, 
  /**
   * The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in Turtle format. If not present, the Publication Tool decides whether to generate Turtle.
   */
  GENERATETURTLE, 
  /**
   * The value of this string singleton parameter is the name of the file to use as the builder template for each generated page (see templating).
   */
  HTMLTEMPLATE, 
  /**
   * added to help the parsers with the generic types
   */
  NULL;
  public static GuideParameterCode fromCode(String codeString) throws FHIRException {
    if (codeString == null || "".equals(codeString))
      return null;
    if ("apply".equals(codeString))
      return APPLY;
    if ("path-resource".equals(codeString))
      return PATHRESOURCE;
    if ("path-pages".equals(codeString))
      return PATHPAGES;
    if ("path-tx-cache".equals(codeString))
      return PATHTXCACHE;
    if ("expansion-parameter".equals(codeString))
      return EXPANSIONPARAMETER;
    if ("rule-broken-links".equals(codeString))
      return RULEBROKENLINKS;
    if ("generate-xml".equals(codeString))
      return GENERATEXML;
    if ("generate-json".equals(codeString))
      return GENERATEJSON;
    if ("generate-turtle".equals(codeString))
      return GENERATETURTLE;
    if ("html-template".equals(codeString))
      return HTMLTEMPLATE;
    if (Configuration.isAcceptInvalidEnums())
      return null;
    else
      throw new FHIRException("Unknown GuideParameterCode code '"+codeString+"'");
  }
  public String toCode() {
    switch (this) {
    case APPLY: return "apply";
    case PATHRESOURCE: return "path-resource";
    case PATHPAGES: return "path-pages";
    case PATHTXCACHE: return "path-tx-cache";
    case EXPANSIONPARAMETER: return "expansion-parameter";
    case RULEBROKENLINKS: return "rule-broken-links";
    case GENERATEXML: return "generate-xml";
    case GENERATEJSON: return "generate-json";
    case GENERATETURTLE: return "generate-turtle";
    case HTMLTEMPLATE: return "html-template";
    default: return "?";
    }
  }
  public String getSystem() {
    switch (this) {
    case APPLY: return "http://hl7.org/fhir/guide-parameter-code";
    case PATHRESOURCE: return "http://hl7.org/fhir/guide-parameter-code";
    case PATHPAGES: return "http://hl7.org/fhir/guide-parameter-code";
    case PATHTXCACHE: return "http://hl7.org/fhir/guide-parameter-code";
    case EXPANSIONPARAMETER: return "http://hl7.org/fhir/guide-parameter-code";
    case RULEBROKENLINKS: return "http://hl7.org/fhir/guide-parameter-code";
    case GENERATEXML: return "http://hl7.org/fhir/guide-parameter-code";
    case GENERATEJSON: return "http://hl7.org/fhir/guide-parameter-code";
    case GENERATETURTLE: return "http://hl7.org/fhir/guide-parameter-code";
    case HTMLTEMPLATE: return "http://hl7.org/fhir/guide-parameter-code";
    default: return "?";
    }
  }
  public String getDefinition() {
    switch (this) {
    case APPLY: return "If the value of this string 0..* parameter is one of the metadata fields then all conformance resources will have any specified [Resource].[field] overwritten with the ImplementationGuide.[field], where field is one of: version, date, status, publisher, contact, copyright, experimental, jurisdiction, useContext.";
    case PATHRESOURCE: return "The value of this string 0..* parameter is a subfolder of the build context's location that is to be scanned to load resources. Scope is (if present) a particular resource type.";
    case PATHPAGES: return "The value of this string 0..1 parameter is a subfolder of the build context's location that contains files that are part of the html content processed by the builder.";
    case PATHTXCACHE: return "The value of this string 0..1 parameter is a subfolder of the build context's location that is used as the terminology cache. If this is not present, the terminology cache is on the local system, not under version control.";
    case EXPANSIONPARAMETER: return "The value of this string 0..* parameter is a parameter (name=value) when expanding value sets for this implementation guide. This is particularly used to specify the versions of published terminologies such as SNOMED CT.";
    case RULEBROKENLINKS: return "The value of this string 0..1 parameter is either \"warning\" or \"error\" (default = \"error\"). If the value is \"warning\" then IG build tools allow the IG to be considered successfully build even when there is no internal broken links.";
    case GENERATEXML: return "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in XML format. If not present, the Publication Tool decides whether to generate XML.";
    case GENERATEJSON: return "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in JSON format. If not present, the Publication Tool decides whether to generate JSON.";
    case GENERATETURTLE: return "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in Turtle format. If not present, the Publication Tool decides whether to generate Turtle.";
    case HTMLTEMPLATE: return "The value of this string singleton parameter is the name of the file to use as the builder template for each generated page (see templating).";
    default: return "?";
    }
  }
  public String getDisplay() {
    switch (this) {
    case APPLY: return "Apply Metadata Value";
    case PATHRESOURCE: return "Resource Path";
    case PATHPAGES: return "Pages Path";
    case PATHTXCACHE: return "Terminology Cache Path";
    case EXPANSIONPARAMETER: return "Expansion Profile";
    case RULEBROKENLINKS: return "Broken Links Rule";
    case GENERATEXML: return "Generate XML";
    case GENERATEJSON: return "Generate JSON";
    case GENERATETURTLE: return "Generate Turtle";
    case HTMLTEMPLATE: return "HTML Template";
    default: return "?";
    }
  }
  public class GuideParameterCodeEnumFactory implements EnumFactory<GuideParameterCode> {
    public GuideParameterCode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("apply".equals(codeString))
        return GuideParameterCode.APPLY;
      if ("path-resource".equals(codeString))
        return GuideParameterCode.PATHRESOURCE;
      if ("path-pages".equals(codeString))
        return GuideParameterCode.PATHPAGES;
      if ("path-tx-cache".equals(codeString))
        return GuideParameterCode.PATHTXCACHE;
      if ("expansion-parameter".equals(codeString))
        return GuideParameterCode.EXPANSIONPARAMETER;
      if ("rule-broken-links".equals(codeString))
        return GuideParameterCode.RULEBROKENLINKS;
      if ("generate-xml".equals(codeString))
        return GuideParameterCode.GENERATEXML;
      if ("generate-json".equals(codeString))
        return GuideParameterCode.GENERATEJSON;
      if ("generate-turtle".equals(codeString))
        return GuideParameterCode.GENERATETURTLE;
      if ("html-template".equals(codeString))
        return GuideParameterCode.HTMLTEMPLATE;
      throw new IllegalArgumentException("Unknown GuideParameterCode code '"+codeString+"'");
    }
    public Enumeration<GuideParameterCode> fromType(Base code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<GuideParameterCode>(this);
      String codeString = ((PrimitiveType) code).asStringValue();
      if (codeString == null || "".equals(codeString))
        return null;
      if ("apply".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.APPLY);
      if ("path-resource".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.PATHRESOURCE);
      if ("path-pages".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.PATHPAGES);
      if ("path-tx-cache".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.PATHTXCACHE);
      if ("expansion-parameter".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.EXPANSIONPARAMETER);
      if ("rule-broken-links".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.RULEBROKENLINKS);
      if ("generate-xml".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.GENERATEXML);
      if ("generate-json".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.GENERATEJSON);
      if ("generate-turtle".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.GENERATETURTLE);
      if ("html-template".equals(codeString))
        return new Enumeration<GuideParameterCode>(this, GuideParameterCode.HTMLTEMPLATE);
      throw new FHIRException("Unknown GuideParameterCode code '"+codeString+"'");
    }
    public String toCode(GuideParameterCode code) {
      if (code == GuideParameterCode.APPLY)
        return "apply";
      if (code == GuideParameterCode.PATHRESOURCE)
        return "path-resource";
      if (code == GuideParameterCode.PATHPAGES)
        return "path-pages";
      if (code == GuideParameterCode.PATHTXCACHE)
        return "path-tx-cache";
      if (code == GuideParameterCode.EXPANSIONPARAMETER)
        return "expansion-parameter";
      if (code == GuideParameterCode.RULEBROKENLINKS)
        return "rule-broken-links";
      if (code == GuideParameterCode.GENERATEXML)
        return "generate-xml";
      if (code == GuideParameterCode.GENERATEJSON)
        return "generate-json";
      if (code == GuideParameterCode.GENERATETURTLE)
        return "generate-turtle";
      if (code == GuideParameterCode.HTMLTEMPLATE)
        return "html-template";
      return "?";
    }
    public String toSystem(GuideParameterCode code) {
      return code.getSystem();
    }
  }
}