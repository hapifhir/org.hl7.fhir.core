package org.hl7.fhir.r4.model.codesystems;

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

// Generated on Wed, Jan 30, 2019 16:19-0500 for FHIR v4.0.0

import org.hl7.fhir.exceptions.FHIRException;

public enum GuideParameterCode {

  /**
   * If the value of this string 0..* parameter is one of the metadata fields then
   * all conformance resources will have any specified [Resource].[field]
   * overwritten with the ImplementationGuide.[field], where field is one of:
   * version, date, status, publisher, contact, copyright, experimental,
   * jurisdiction, useContext.
   */
  APPLY,
  /**
   * The value of this string 0..* parameter is a subfolder of the build context's
   * location that is to be scanned to load resources. Scope is (if present) a
   * particular resource type.
   */
  PATHRESOURCE,
  /**
   * The value of this string 0..1 parameter is a subfolder of the build context's
   * location that contains files that are part of the html content processed by
   * the builder.
   */
  PATHPAGES,
  /**
   * The value of this string 0..1 parameter is a subfolder of the build context's
   * location that is used as the terminology cache. If this is not present, the
   * terminology cache is on the local system, not under version control.
   */
  PATHTXCACHE,
  /**
   * The value of this string 0..* parameter is a parameter (name=value) when
   * expanding value sets for this implementation guide. This is particularly used
   * to specify the versions of published terminologies such as SNOMED CT.
   */
  EXPANSIONPARAMETER,
  /**
   * The value of this string 0..1 parameter is either "warning" or "error"
   * (default = "error"). If the value is "warning" then IG build tools allow the
   * IG to be considered successfully build even when there is no internal broken
   * links.
   */
  RULEBROKENLINKS,
  /**
   * The value of this boolean 0..1 parameter specifies whether the IG publisher
   * creates examples in XML format. If not present, the Publication Tool decides
   * whether to generate XML.
   */
  GENERATEXML,
  /**
   * The value of this boolean 0..1 parameter specifies whether the IG publisher
   * creates examples in JSON format. If not present, the Publication Tool decides
   * whether to generate JSON.
   */
  GENERATEJSON,
  /**
   * The value of this boolean 0..1 parameter specifies whether the IG publisher
   * creates examples in Turtle format. If not present, the Publication Tool
   * decides whether to generate Turtle.
   */
  GENERATETURTLE,
  /**
   * The value of this string singleton parameter is the name of the file to use
   * as the builder template for each generated page (see templating).
   */
  HTMLTEMPLATE,
  /**
   * added to help the parsers
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
    throw new FHIRException("Unknown GuideParameterCode code '" + codeString + "'");
  }

  public String toCode() {
    switch (this) {
    case APPLY:
      return "apply";
    case PATHRESOURCE:
      return "path-resource";
    case PATHPAGES:
      return "path-pages";
    case PATHTXCACHE:
      return "path-tx-cache";
    case EXPANSIONPARAMETER:
      return "expansion-parameter";
    case RULEBROKENLINKS:
      return "rule-broken-links";
    case GENERATEXML:
      return "generate-xml";
    case GENERATEJSON:
      return "generate-json";
    case GENERATETURTLE:
      return "generate-turtle";
    case HTMLTEMPLATE:
      return "html-template";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getSystem() {
    return "http://hl7.org/fhir/guide-parameter-code";
  }

  public String getDefinition() {
    switch (this) {
    case APPLY:
      return "If the value of this string 0..* parameter is one of the metadata fields then all conformance resources will have any specified [Resource].[field] overwritten with the ImplementationGuide.[field], where field is one of: version, date, status, publisher, contact, copyright, experimental, jurisdiction, useContext.";
    case PATHRESOURCE:
      return "The value of this string 0..* parameter is a subfolder of the build context's location that is to be scanned to load resources. Scope is (if present) a particular resource type.";
    case PATHPAGES:
      return "The value of this string 0..1 parameter is a subfolder of the build context's location that contains files that are part of the html content processed by the builder.";
    case PATHTXCACHE:
      return "The value of this string 0..1 parameter is a subfolder of the build context's location that is used as the terminology cache. If this is not present, the terminology cache is on the local system, not under version control.";
    case EXPANSIONPARAMETER:
      return "The value of this string 0..* parameter is a parameter (name=value) when expanding value sets for this implementation guide. This is particularly used to specify the versions of published terminologies such as SNOMED CT.";
    case RULEBROKENLINKS:
      return "The value of this string 0..1 parameter is either \"warning\" or \"error\" (default = \"error\"). If the value is \"warning\" then IG build tools allow the IG to be considered successfully build even when there is no internal broken links.";
    case GENERATEXML:
      return "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in XML format. If not present, the Publication Tool decides whether to generate XML.";
    case GENERATEJSON:
      return "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in JSON format. If not present, the Publication Tool decides whether to generate JSON.";
    case GENERATETURTLE:
      return "The value of this boolean 0..1 parameter specifies whether the IG publisher creates examples in Turtle format. If not present, the Publication Tool decides whether to generate Turtle.";
    case HTMLTEMPLATE:
      return "The value of this string singleton parameter is the name of the file to use as the builder template for each generated page (see templating).";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

  public String getDisplay() {
    switch (this) {
    case APPLY:
      return "Apply Metadata Value";
    case PATHRESOURCE:
      return "Resource Path";
    case PATHPAGES:
      return "Pages Path";
    case PATHTXCACHE:
      return "Terminology Cache Path";
    case EXPANSIONPARAMETER:
      return "Expansion Profile";
    case RULEBROKENLINKS:
      return "Broken Links Rule";
    case GENERATEXML:
      return "Generate XML";
    case GENERATEJSON:
      return "Generate JSON";
    case GENERATETURTLE:
      return "Generate Turtle";
    case HTMLTEMPLATE:
      return "HTML Template";
    case NULL:
      return null;
    default:
      return "?";
    }
  }

}