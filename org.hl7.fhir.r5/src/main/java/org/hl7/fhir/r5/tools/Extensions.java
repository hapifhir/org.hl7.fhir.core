package org.hl7.fhir.r5.tools;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.extensions.ExtensionsUtils;
import java.util.List;
import java.math.BigDecimal;

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




public class Extensions {
  
// -- BindingDefinition -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/binding-definition|0.6.0-cibuild
// Binding Definition

  public static Extension makeBindingDefinition(String value) {
    return new Extension(ExtensionConstants.EXT_BINDING_DEFINITION).setValue(new MarkdownType(value));
  }

// -- TerminologyBindingStyleEXT -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-binding-style|0.6.0-cibuild
// Terminology Binding Style Extension

  public static Extension makeTerminologyBindingStyleEXT(String value) {
    return new Extension(ExtensionConstants.EXT_TERMINOLOGY_BINDING_STYLE_E_X_T).setValue(new CodeType(value));
  }

  public static StructureDefinition addTerminologyBindingStyleEXT(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_TERMINOLOGY_BINDING_STYLE_E_X_T, new CodeType(value));
    return context;
  }

  public static List<String> getTerminologyBindingStyleEXTList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_TERMINOLOGY_BINDING_STYLE_E_X_T);
  }

// -- DateFormat -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-date-format|0.6.0-cibuild
// Date Format String

  public static Extension makeDateFormat(String value) {
    return new Extension(ExtensionConstants.EXT_DATE_FORMAT).setValue(new StringType(value));
  }

  public static ElementDefinition addDateFormat(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DATE_FORMAT, new StringType(value));
    return context;
  }

  public static List<String> getDateFormatList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_DATE_FORMAT);
  }

// -- DateRulesControl -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-date-rules|0.6.0-cibuild
// Date Validation Rules control

  public static Extension makeDateRulesControl(String value) {
    return new Extension(ExtensionConstants.EXT_DATE_RULES_CONTROL).setValue(new StringType(value));
  }

  public static ElementDefinition addDateRulesControl(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_DATE_RULES_CONTROL, new StringType(value));
    return context;
  }

  public static List<String> getDateRulesControlList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_DATE_RULES_CONTROL);
  }

// -- ExtensionStylesEXT -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/extension-style|0.6.0-cibuild
// Extension Style Extension

  public static Extension makeExtensionStylesEXT(String value) {
    return new Extension(ExtensionConstants.EXT_EXTENSION_STYLES_E_X_T).setValue(new CodeType(value));
  }

  public static StructureDefinition addExtensionStylesEXT(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EXTENSION_STYLES_E_X_T, new CodeType(value));
    return context;
  }

  public static List<String> getExtensionStylesEXTList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_EXTENSION_STYLES_E_X_T);
  }

// -- IdExpectationExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/id-expectation|0.6.0-cibuild
// Id Expectation Extension

  public static Extension makeIdExpectationExt(String value) {
    return new Extension(ExtensionConstants.EXT_ID_EXPECTATION_EXT).setValue(new CodeType(value));
  }

  public static ElementDefinition addIdExpectationExt(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ID_EXPECTATION_EXT, new CodeType(value));
    return context;
  }

  public static List<String> getIdExpectationExtList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ID_EXPECTATION_EXT);
  }

// -- ActorExampleURL -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-actor-example-url|0.6.0-cibuild
// Actor Example URL

  public static Extension makeActorExampleURL(String value) {
    return new Extension(ExtensionConstants.EXT_ACTOR_EXAMPLE_U_R_L).setValue(new UrlType(value));
  }

  public static ActorDefinition addActorExampleURL(ActorDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_ACTOR_EXAMPLE_U_R_L, new UrlType(value));
    return context;
  }

  public static List<String> getActorExampleURLList(ActorDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_ACTOR_EXAMPLE_U_R_L);
  }

// -- ActorForExample -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-example-actor|0.6.0-cibuild
// Actor For Example

  public static Extension makeActorForExample(String value) {
    return new Extension(ExtensionConstants.EXT_ACTOR_FOR_EXAMPLE).setValue(new CanonicalType(value));
  }

// -- IGInternalDependency -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-internal-dependency|0.6.0-cibuild
// IG Internal Dependency

  public static Extension makeIGInternalDependency(String value) {
    return new Extension(ExtensionConstants.EXT_IGINTERNAL_DEPENDENCY).setValue(new CodeType(value));
  }

// -- IGLinkDependency -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-link-dependency|0.6.0-cibuild
// IG Link Dependency

  public static Extension makeIGLinkDependency(String value) {
    return new Extension(ExtensionConstants.EXT_IGLINK_DEPENDENCY).setValue(new CodeType(value));
  }

// -- IGPublisherLoadAsResource -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-load-as-resource|0.6.0-cibuild
// IGPublisher Load As Resource

  public static Extension makeIGPublisherLoadAsResource(boolean value) {
    return new Extension(ExtensionConstants.EXT_IGPUBLISHER_LOAD_AS_RESOURCE).setValue(new BooleanType(value));
  }

  public static StructureDefinition addIGPublisherLoadAsResource(StructureDefinition context, boolean value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_IGPUBLISHER_LOAD_AS_RESOURCE, new BooleanType(value));
    return context;
  }

  public static List<Boolean> getIGPublisherLoadAsResourceList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBooleanList(context, ExtensionConstants.EXT_IGPUBLISHER_LOAD_AS_RESOURCE);
  }

// -- IGPageName -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-page-name|0.6.0-cibuild
// IG Page Name

  public static Extension makeIGPageName(String value) {
    return new Extension(ExtensionConstants.EXT_IGPAGE_NAME).setValue(new UrlType(value));
  }

// -- IGPublisherUseAsResourceId -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/ig-use-as-resource-id|0.6.0-cibuild
// IGPublisher Use As Resource Id

  public static Extension makeIGPublisherUseAsResourceId(boolean value) {
    return new Extension(ExtensionConstants.EXT_IGPUBLISHER_USE_AS_RESOURCE_ID).setValue(new BooleanType(value));
  }

  public static ElementDefinition addIGPublisherUseAsResourceId(ElementDefinition context, boolean value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_IGPUBLISHER_USE_AS_RESOURCE_ID, new BooleanType(value));
    return context;
  }

  public static List<Boolean> getIGPublisherUseAsResourceIdList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBooleanList(context, ExtensionConstants.EXT_IGPUBLISHER_USE_AS_RESOURCE_ID);
  }

// -- IGPublisherBundle -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/igpublisher-bundle|0.6.0-cibuild
// IG Publisher Bundle

  public static Extension makeIGPublisherBundle(String value) {
    return new Extension(ExtensionConstants.EXT_IGPUBLISHER_BUNDLE).setValue(new UrlType(value));
  }

// -- IGDependencyComment -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implementationguide-dependency-comment|0.6.0-cibuild
// IG Dependency Comment

  public static Extension makeIGDependencyComment(String value) {
    return new Extension(ExtensionConstants.EXT_IGDEPENDENCY_COMMENT).setValue(new MarkdownType(value));
  }

// -- BinaryResourceFormat -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-format|0.6.0-cibuild
// Binary Resource Format

  public static Extension makeBinaryResourceFormat(String value) {
    return new Extension(ExtensionConstants.EXT_BINARY_RESOURCE_FORMAT).setValue(new CodeType(value));
  }

// -- BinaryResourceLogical -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implementationguide-resource-logical|0.6.0-cibuild
// Binary Resource Logical

  public static Extension makeBinaryResourceLogical(String value) {
    return new Extension(ExtensionConstants.EXT_BINARY_RESOURCE_LOGICAL).setValue(new CanonicalType(value));
  }

// -- ImpliedStringPrefix -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/implied-string-prefix|0.6.0-cibuild
// Implied String Prefix

  public static Extension makeImpliedStringPrefix(String value) {
    return new Extension(ExtensionConstants.EXT_IMPLIED_STRING_PREFIX).setValue(new StringType(value));
  }

  public static ElementDefinition addImpliedStringPrefix(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_IMPLIED_STRING_PREFIX, new StringType(value));
    return context;
  }

  public static List<String> getImpliedStringPrefixList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_IMPLIED_STRING_PREFIX);
  }

// -- InheritObligations -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/inherit-obligations|0.6.0-cibuild
// Inherit Obligations

  public static Extension makeInheritObligations(String value) {
    return new Extension(ExtensionConstants.EXT_INHERIT_OBLIGATIONS).setValue(new CanonicalType(value));
  }

  public static StructureDefinition addInheritObligations(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_INHERIT_OBLIGATIONS, new CanonicalType(value));
    return context;
  }

  public static List<String> getInheritObligationsList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_INHERIT_OBLIGATIONS);
  }

// -- JsonEmptyBehavior -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-empty-behavior|0.6.0-cibuild
// Json Empty Behavior Extension

  public static Extension makeJsonEmptyBehavior(String value) {
    return new Extension(ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR).setValue(new CodeType(value));
  }

  public static ElementDefinition addJsonEmptyBehavior(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR, new CodeType(value));
    return context;
  }

  public static List<String> getJsonEmptyBehaviorList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_EMPTY_BEHAVIOR);
  }

// -- JsonPropertyName -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-name|0.6.0-cibuild
// Json Property Name Extension

  public static Extension makeJsonPropertyName(String value) {
    return new Extension(ExtensionConstants.EXT_JSON_PROPERTY_NAME).setValue(new StringType(value));
  }

  public static ElementDefinition addJsonPropertyName(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_PROPERTY_NAME, new StringType(value));
    return context;
  }

  public static List<String> getJsonPropertyNameList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_PROPERTY_NAME);
  }

// -- JsonNullableExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-nullable|0.6.0-cibuild
// Json Nullable Extension

  public static Extension makeJsonNullableExt(boolean value) {
    return new Extension(ExtensionConstants.EXT_JSON_NULLABLE_EXT).setValue(new BooleanType(value));
  }

  public static ElementDefinition setJsonNullableExt(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_JSON_NULLABLE_EXT, new BooleanType(value));
    return context;
  }

  public static Boolean getJsonNullableExt(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_JSON_NULLABLE_EXT);
  }

// -- JsonPrimitiveChoiceExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-primitive-choice|0.6.0-cibuild
// Json Primitive Choice Extension

  public static Extension makeJsonPrimitiveChoiceExt(boolean value) {
    return new Extension(ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT).setValue(new BooleanType(value));
  }

  public static ElementDefinition setJsonPrimitiveChoiceExt(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT, new BooleanType(value));
    return context;
  }

  public static Boolean getJsonPrimitiveChoiceExt(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_JSON_PRIMITIVE_CHOICE_EXT);
  }

// -- JsonPropertyKey -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-property-key|0.6.0-cibuild
// Json Property Key Extension

  public static Extension makeJsonPropertyKey(String value) {
    return new Extension(ExtensionConstants.EXT_JSON_PROPERTY_KEY).setValue(new CodeType(value));
  }

  public static ElementDefinition addJsonPropertyKey(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_PROPERTY_KEY, new CodeType(value));
    return context;
  }

  public static List<String> getJsonPropertyKeyList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_JSON_PROPERTY_KEY);
  }

// -- JsonSuppressResourceType -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/json-suppress-resourcetype|0.6.0-cibuild
// Json Suppress resourceType Property

  public static Extension makeJsonSuppressResourceType(boolean value) {
    return new Extension(ExtensionConstants.EXT_JSON_SUPPRESS_RESOURCE_TYPE).setValue(new BooleanType(value));
  }

  public static StructureDefinition addJsonSuppressResourceType(StructureDefinition context, boolean value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_JSON_SUPPRESS_RESOURCE_TYPE, new BooleanType(value));
    return context;
  }

  public static List<Boolean> getJsonSuppressResourceTypeList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBooleanList(context, ExtensionConstants.EXT_JSON_SUPPRESS_RESOURCE_TYPE);
  }

// -- LogicalContainer -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/logical-container|0.6.0-cibuild
// Logical Container

  public static Extension makeLogicalContainer(String value) {
    return new Extension(ExtensionConstants.EXT_LOGICAL_CONTAINER).setValue(new UriType(value));
  }

  public static StructureDefinition setLogicalContainer(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LOGICAL_CONTAINER, new UriType(value));
    return context;
  }

  public static String getLogicalContainer(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_LOGICAL_CONTAINER);
  }

// -- LogicalTarget -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/logical-target|0.6.0-cibuild
// Logical Target

  public static Extension makeLogicalTarget(boolean value) {
    return new Extension(ExtensionConstants.EXT_LOGICAL_TARGET).setValue(new BooleanType(value));
  }

  public static StructureDefinition setLogicalTarget(StructureDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_LOGICAL_TARGET, new BooleanType(value));
    return context;
  }

  public static Boolean getLogicalTarget(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_LOGICAL_TARGET);
  }

// -- MatchetypeFlag -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/matchetype|0.6.0-cibuild
// Matchetype Flag

  public static Extension makeMatchetypeFlag(String value) {
    return new Extension(ExtensionConstants.EXT_MATCHETYPE_FLAG).setValue(new CodeType(value));
  }

  public static Resource addMatchetypeFlag(Resource context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MATCHETYPE_FLAG, new CodeType(value));
    return context;
  }

  public static List<String> getMatchetypeFlagList(Resource context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_MATCHETYPE_FLAG);
  }

// -- MatchetypeCountFlag -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/matchetype-count|0.6.0-cibuild
// Matchetype Count Flag

  public static Extension makeMatchetypeCountFlag(String value) {
    return new Extension(ExtensionConstants.EXT_MATCHETYPE_COUNT_FLAG).setValue(new StringType(value));
  }

  public static Element addMatchetypeCountFlag(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MATCHETYPE_COUNT_FLAG, new StringType(value));
    return context;
  }

  public static List<String> getMatchetypeCountFlagList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_MATCHETYPE_COUNT_FLAG);
  }

// -- MatchetypeOptionalFlag -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/matchetype-optional|0.6.0-cibuild
// Matchetype Optional Flag

  public static Extension makeMatchetypeOptionalFlag(String value) {
    return new Extension(ExtensionConstants.EXT_MATCHETYPE_OPTIONAL_FLAG).setValue(new StringType(value));
  }

  public static Extension makeMatchetypeOptionalFlag(boolean value) {
    return new Extension(ExtensionConstants.EXT_MATCHETYPE_OPTIONAL_FLAG).setValue(new BooleanType(value));
  }

  public static Element addMatchetypeOptionalFlag(Element context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MATCHETYPE_OPTIONAL_FLAG, new StringType(value));
    return context;
  }

  public static List<String> getMatchetypeOptionalFlagStringList(Element context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_MATCHETYPE_OPTIONAL_FLAG);
  }

  public static Element addMatchetypeOptionalFlag(Element context, boolean value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_MATCHETYPE_OPTIONAL_FLAG, new BooleanType(value));
    return context;
  }

  public static List<Boolean> getMatchetypeOptionalFlagBooleanList(Element context) {
    return ExtensionsUtils.getExtensionBooleanList(context, ExtensionConstants.EXT_MATCHETYPE_OPTIONAL_FLAG);
  }

// -- NoBinding -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/no-binding|0.6.0-cibuild
// No Binding Extension

  public static Extension makeNoBinding(boolean value) {
    return new Extension(ExtensionConstants.EXT_NO_BINDING).setValue(new BooleanType(value));
  }

  public static ElementDefinition setNoBinding(ElementDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NO_BINDING, new BooleanType(value));
    return context;
  }

  public static Boolean getNoBinding(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_NO_BINDING);
  }

// -- ObligationProfile -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/obligation-profile|0.6.0-cibuild
// Obligation Profile Flag

  public static Extension makeObligationProfile(boolean value) {
    return new Extension(ExtensionConstants.EXT_OBLIGATION_PROFILE).setValue(new BooleanType(value));
  }

  public static StructureDefinition addObligationProfile(StructureDefinition context, boolean value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_OBLIGATION_PROFILE, new BooleanType(value));
    return context;
  }

  public static List<Boolean> getObligationProfileList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBooleanList(context, ExtensionConstants.EXT_OBLIGATION_PROFILE);
  }

// -- PackageScope -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/package-scope|0.6.0-cibuild
// Package Scope

  public static Extension makePackageScope(String value) {
    return new Extension(ExtensionConstants.EXT_PACKAGE_SCOPE).setValue(new CodeType(value));
  }

  public static ImplementationGuide addPackageScope(ImplementationGuide context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_PACKAGE_SCOPE, new CodeType(value));
    return context;
  }

  public static List<String> getPackageScopeList(ImplementationGuide context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_PACKAGE_SCOPE);
  }

// -- ProfileMapping -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/profile-mapping|0.6.0-cibuild
// Profile Mapping Extension

  public static Extension makeProfileMapping(DataType value) {
    return new Extension(ExtensionConstants.EXT_PROFILE_MAPPING).setValue(value);
  }

// -- ResourceSortExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/resource-sort|0.6.0-cibuild
// Resource Sort Extension

  public static Extension makeResourceSortExt(int value) {
    return new Extension(ExtensionConstants.EXT_RESOURCE_SORT_EXT).setValue(new IntegerType(value));
  }

// -- SearchParameterBaseType -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/searchparameter-base-type|0.6.0-cibuild
// Search Parameter Base Type

  public static Extension makeSearchParameterBaseType(String value) {
    return new Extension(ExtensionConstants.EXT_SEARCH_PARAMETER_BASE_TYPE).setValue(new CodeType(value));
  }

// -- SnapshotBaseVersion -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/snapshot-base-version|0.6.0-cibuild
// Snapshot Base Version

  public static Extension makeSnapshotBaseVersion(String value) {
    return new Extension(ExtensionConstants.EXT_SNAPSHOT_BASE_VERSION).setValue(new StringType(value));
  }

// -- ExtensionSnapshotBehavior -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/snapshot-behavior|0.6.0-cibuild
// Extension Snapshot Behavior

  public static Extension makeExtensionSnapshotBehavior(String value) {
    return new Extension(ExtensionConstants.EXT_EXTENSION_SNAPSHOT_BEHAVIOR).setValue(new CodeType(value));
  }

  public static StructureDefinition addExtensionSnapshotBehavior(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EXTENSION_SNAPSHOT_BEHAVIOR, new CodeType(value));
    return context;
  }

  public static List<String> getExtensionSnapshotBehaviorList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_EXTENSION_SNAPSHOT_BEHAVIOR);
  }

// -- ExtensionSnapshotSource -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/snapshot-source|0.6.0-cibuild
// Extension Snapshot Source

  public static Extension makeExtensionSnapshotSource(String value) {
    return new Extension(ExtensionConstants.EXT_EXTENSION_SNAPSHOT_SOURCE).setValue(new CanonicalType(value));
  }

  public static StructureDefinition addExtensionSnapshotSource(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_EXTENSION_SNAPSHOT_SOURCE, new CanonicalType(value));
    return context;
  }

  public static List<String> getExtensionSnapshotSourceList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_EXTENSION_SNAPSHOT_SOURCE);
  }

// -- RenderingEngineViewHintsExt -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/view-hint|0.6.0-cibuild
// Viewing Hints for Rendering Engines (Extension)

  public static Extension makeRenderingEngineViewHintsExt(String value) {
    return new Extension(ExtensionConstants.EXT_RENDERING_ENGINE_VIEW_HINTS_EXT).setValue(new CodeType(value));
  }

  public static ElementDefinition setRenderingEngineViewHintsExt(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERING_ENGINE_VIEW_HINTS_EXT, new CodeType(value));
    return context;
  }

  public static String getRenderingEngineViewHintsExt(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERING_ENGINE_VIEW_HINTS_EXT);
  }

  public static StructureDefinition setRenderingEngineViewHintsExt(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_RENDERING_ENGINE_VIEW_HINTS_EXT, new CodeType(value));
    return context;
  }

  public static String getRenderingEngineViewHintsExt(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_RENDERING_ENGINE_VIEW_HINTS_EXT);
  }

// -- WebSource -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/web-source|0.6.0-cibuild
// Web Source

  public static Extension makeWebSource(String value) {
    return new Extension(ExtensionConstants.EXT_WEB_SOURCE).setValue(new UrlType(value));
  }

  public static CanonicalResource setWebSource(CanonicalResource context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_WEB_SOURCE, new UrlType(value));
    return context;
  }

  public static String getWebSource(CanonicalResource context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_WEB_SOURCE);
  }

// -- XMLChoiceGroup -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/xml-choice-group|0.6.0-cibuild
// XML Choice Group

  public static Extension makeXMLChoiceGroup(boolean value) {
    return new Extension(ExtensionConstants.EXT_XMLCHOICE_GROUP).setValue(new BooleanType(value));
  }

  public static ElementDefinition addXMLChoiceGroup(ElementDefinition context, boolean value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_XMLCHOICE_GROUP, new BooleanType(value));
    return context;
  }

  public static List<Boolean> getXMLChoiceGroupList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionBooleanList(context, ExtensionConstants.EXT_XMLCHOICE_GROUP);
  }

// -- XmlElementName -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/xml-name|0.6.0-cibuild
// Xml Element Name Extension

  public static Extension makeXmlElementName(String value) {
    return new Extension(ExtensionConstants.EXT_XML_ELEMENT_NAME).setValue(new StringType(value));
  }

  public static ElementDefinition addXmlElementName(ElementDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_XML_ELEMENT_NAME, new StringType(value));
    return context;
  }

  public static List<String> getXmlElementNameList(ElementDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_XML_ELEMENT_NAME);
  }

  public static StructureDefinition addXmlElementName(StructureDefinition context, String value) {
    ExtensionsUtils.addExtension(context, ExtensionConstants.EXT_XML_ELEMENT_NAME, new StringType(value));
    return context;
  }

  public static List<String> getXmlElementNameList(StructureDefinition context) {
    return ExtensionsUtils.getExtensionStringList(context, ExtensionConstants.EXT_XML_ELEMENT_NAME);
  }

// -- Namespace -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/xml-namespace|0.6.0-cibuild
// Namespace

  public static Extension makeNamespace(String value) {
    return new Extension(ExtensionConstants.EXT_NAMESPACE).setValue(new UriType(value));
  }

  public static ElementDefinition setNamespace(ElementDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NAMESPACE, new UriType(value));
    return context;
  }

  public static String getNamespace(ElementDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NAMESPACE);
  }

  public static StructureDefinition setNamespace(StructureDefinition context, String value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_NAMESPACE, new UriType(value));
    return context;
  }

  public static String getNamespace(StructureDefinition context) {
    return ExtensionsUtils.getExtensionString(context, ExtensionConstants.EXT_NAMESPACE);
  }

// -- XmlNoOrder -------------------------------------
// http://hl7.org/fhir/tools/StructureDefinition/xml-no-order|0.6.0-cibuild
// No Order in XML

  public static Extension makeXmlNoOrder(boolean value) {
    return new Extension(ExtensionConstants.EXT_XML_NO_ORDER).setValue(new BooleanType(value));
  }

  public static StructureDefinition setXmlNoOrder(StructureDefinition context, boolean value) {
    ExtensionsUtils.setExtension(context, ExtensionConstants.EXT_XML_NO_ORDER, new BooleanType(value));
    return context;
  }

  public static Boolean getXmlNoOrder(StructureDefinition context) {
    return ExtensionsUtils.getExtensionBoolean(context, ExtensionConstants.EXT_XML_NO_ORDER);
  }



}