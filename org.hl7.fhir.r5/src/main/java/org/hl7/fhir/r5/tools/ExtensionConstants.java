package org.hl7.fhir.r5.tools;

import org.hl7.fhir.utilities.Utilities;

// generated

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



public class ExtensionConstants {
  
  public static final String EXT_ADDITIONAL_BINDING = "http://hl7.org/fhir/tools/StructureDefinition/additional-binding"; // Additional Binding Extension
  public static final String EXT_BINDING_DEFINITION = "http://hl7.org/fhir/tools/StructureDefinition/binding-definition"; // Binding Definition
  public static final String EXT_BINDING_PARAMETER_DECLARATION = "http://hl7.org/fhir/tools/StructureDefinition/binding-parameter"; // Binding Parameter Declaration
  public static final String EXT_TERMINOLOGY_BINDING_STYLE_E_X_T = "http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-binding-style"; // Terminology Binding Style Extension
  public static final String EXT_DATE_FORMAT = "http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-date-format"; // Date Format String
  public static final String EXT_DATE_RULES_CONTROL = "http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-date-rules"; // Date Validation Rules control
  public static final String EXT_EXTENSION_STYLES_E_X_T = "http://hl7.org/fhir/tools/StructureDefinition/extension-style"; // Extension Style Extension
  public static final String EXT_ID_EXPECTATION_EXT = "http://hl7.org/fhir/tools/StructureDefinition/id-expectation"; // Id Expectation Extension
  public static final String EXT_ACTOR_EXAMPLE_U_R_L = "http://hl7.org/fhir/tools/StructureDefinition/ig-actor-example-url"; // Actor Example URL
  public static final String EXT_ACTOR_FOR_EXAMPLE = "http://hl7.org/fhir/tools/StructureDefinition/ig-example-actor"; // Actor For Example
  public static final String EXT_IGINTERNAL_DEPENDENCY = "http://hl7.org/fhir/tools/StructureDefinition/ig-internal-dependency"; // IG Internal Dependency
  public static final String EXT_IGLINK_DEPENDENCY = "http://hl7.org/fhir/tools/StructureDefinition/ig-link-dependency"; // IG Link Dependency
  public static final String EXT_IGPUBLISHER_LOAD_AS_RESOURCE = "http://hl7.org/fhir/tools/StructureDefinition/ig-load-as-resource"; // IGPublisher Load As Resource
  public static final String EXT_IGPAGE_NAME = "http://hl7.org/fhir/tools/StructureDefinition/ig-page-name"; // IG Page Name
  public static final String EXT_IGPARAMETER = "http://hl7.org/fhir/tools/StructureDefinition/ig-parameter"; // IG Parameter
  public static final String EXT_IGPUBLISHER_USE_AS_RESOURCE_ID = "http://hl7.org/fhir/tools/StructureDefinition/ig-use-as-resource-id"; // IGPublisher Use As Resource Id
  public static final String EXT_IGPUBLISHER_BUNDLE = "http://hl7.org/fhir/tools/StructureDefinition/igpublisher-bundle"; // IG Publisher Bundle
  public static final String EXT_IGDEPENDENCY_COMMENT = "http://hl7.org/fhir/tools/StructureDefinition/implementationguide-dependency-comment"; // IG Dependency Comment
  public static final String EXT_BINARY_RESOURCE_FORMAT = "http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-format"; // Binary Resource Format
  public static final String EXT_RESOURCE_FRAGMENT = "http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-fragment"; // Resource Fragment
  public static final String EXT_BINARY_RESOURCE_LOGICAL = "http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-logical"; // Binary Resource Logical
  public static final String EXT_DEFINED_URI = "http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-uri"; // Defined Uri
  public static final String EXT_IMPLIED_STRING_PREFIX = "http://hl7.org/fhir/tools/StructureDefinition/implied-string-prefix"; // Implied String Prefix
  public static final String EXT_INHERIT_OBLIGATIONS = "http://hl7.org/fhir/tools/StructureDefinition/inherit-obligations"; // Inherit Obligations
  public static final String EXT_JSON_EMPTY_BEHAVIOR = "http://hl7.org/fhir/tools/StructureDefinition/json-empty-behavior"; // Json Empty Behavior Extension
  public static final String EXT_JSON_PROPERTY_NAME = "http://hl7.org/fhir/tools/StructureDefinition/json-name"; // Json Property Name Extension
  public static final String EXT_JSON_NULLABLE_EXT = "http://hl7.org/fhir/tools/StructureDefinition/json-nullable"; // Json Nullable Extension
  public static final String EXT_JSON_PRIMITIVE_CHOICE_EXT = "http://hl7.org/fhir/tools/StructureDefinition/json-primitive-choice"; // Json Primitive Choice Extension
  public static final String EXT_JSON_PROPERTY_KEY = "http://hl7.org/fhir/tools/StructureDefinition/json-property-key"; // Json Property Key Extension
  public static final String EXT_JSON_SUPPRESS_RESOURCE_TYPE = "http://hl7.org/fhir/tools/StructureDefinition/json-suppress-resourcetype"; // Json Suppress resourceType Property
  public static final String EXT_LOGICAL_CONTAINER = "http://hl7.org/fhir/tools/StructureDefinition/logical-container"; // Logical Container
  public static final String EXT_LOGICAL_TARGET = "http://hl7.org/fhir/tools/StructureDefinition/logical-target"; // Logical Target
  public static final String EXT_MATCHETYPE_FLAG = "http://hl7.org/fhir/tools/StructureDefinition/matchetype"; // Matchetype Flag
  public static final String EXT_MATCHETYPE_COUNT_FLAG = "http://hl7.org/fhir/tools/StructureDefinition/matchetype-count"; // Matchetype Count Flag
  public static final String EXT_MATCHETYPE_OPTIONAL_FLAG = "http://hl7.org/fhir/tools/StructureDefinition/matchetype-optional"; // Matchetype Optional Flag
  public static final String EXT_MATCHETYPE_SORT_RULES = "http://hl7.org/fhir/tools/StructureDefinition/matchetype-sort"; // Matchetype Sort Rules
  public static final String EXT_NO_BINDING = "http://hl7.org/fhir/tools/StructureDefinition/no-binding"; // No Binding Extension
  public static final String EXT_OBLIGATION_PROFILE = "http://hl7.org/fhir/tools/StructureDefinition/obligation-profile"; // Obligation Profile Flag
  public static final String EXT_PACKAGE_SCOPE = "http://hl7.org/fhir/tools/StructureDefinition/package-scope"; // Package Scope
  public static final String EXT_PROFILE_MAPPING = "http://hl7.org/fhir/tools/StructureDefinition/profile-mapping"; // Profile Mapping Extension
  public static final String EXT_RESOURCE_SORT_EXT = "http://hl7.org/fhir/tools/StructureDefinition/resource-sort"; // Resource Sort Extension
  public static final String EXT_SEARCH_PARAMETER_BASE_TYPE = "http://hl7.org/fhir/tools/StructureDefinition/searchparameter-base-type"; // Search Parameter Base Type
  public static final String EXT_SELECT_BY_MAP = "http://hl7.org/fhir/tools/StructureDefinition/select-by-map"; // Select By Map
  public static final String EXT_SNAPSHOT_BASE_VERSION = "http://hl7.org/fhir/tools/StructureDefinition/snapshot-base-version"; // Snapshot Base Version
  public static final String EXT_EXTENSION_SNAPSHOT_BEHAVIOR = "http://hl7.org/fhir/tools/StructureDefinition/snapshot-behavior"; // Extension Snapshot Behavior
  public static final String EXT_EXTENSION_SNAPSHOT_SOURCE = "http://hl7.org/fhir/tools/StructureDefinition/snapshot-base-version"; // Extension Snapshot Source
  public static final String EXT_TYPE_PARAMETER = "http://hl7.org/fhir/tools/StructureDefinition/type-parameter"; // Type Parameter Extension
  public static final String EXT_TYPE_SPECIFIER = "http://hl7.org/fhir/tools/StructureDefinition/type-specifier"; // Type Specifier Extension
  public static final String EXT_VALUE_SET_EXPANSION_PARAMETER_OLD = "http://hl7.org/fhir/tools/StructureDefinition/valueset-expansion-parameter"; // ValueSet Expansion Parameter
  public static final String EXT_VALUE_SET_EXPANSION_PARAMETER_NEW = "http://hl7.org/fhir/StructureDefinition/valueset-expansion-parameter"; // ValueSet Expansion Parameter
  public static final String EXT_VALUE_SET_PARAMETER_DECLARATION = "http://hl7.org/fhir/tools/StructureDefinition/valueset-parameter"; // ValueSet Parameter Declaration
  public static final String EXT_RENDERING_ENGINE_VIEW_HINTS_EXT = "http://hl7.org/fhir/tools/StructureDefinition/view-hint"; // Viewing Hints for Rendering Engines (Extension)
  public static final String EXT_WEB_SOURCE = "http://hl7.org/fhir/tools/StructureDefinition/web-source"; // Web Source
  public static final String EXT_XMLCHOICE_GROUP = "http://hl7.org/fhir/tools/StructureDefinition/xml-choice-group"; // XML Choice Group
  public static final String EXT_XML_ELEMENT_NAME = "http://hl7.org/fhir/tools/StructureDefinition/xml-name"; // Xml Element Name Extension
  public static final String EXT_NAMESPACE = "http://hl7.org/fhir/tools/StructureDefinition/xml-namespace"; // Namespace
  public static final String EXT_XML_NO_ORDER = "http://hl7.org/fhir/tools/StructureDefinition/xml-no-order"; // No Order in XML


  public static boolean isModifier(String url) {
    return false;
  }



}