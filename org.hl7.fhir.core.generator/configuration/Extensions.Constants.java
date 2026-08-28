{{startMark}}
package org.hl7.fhir.{{jid}}.extensions;

import org.hl7.fhir.utilities.Utilities;

{{license}}


{{generated}}
public class ExtensionDefinitions {
  
{{consts}}

  // not properly defined yet
  public static final String EXT_SUPPL_TYPE = "http://hl7.org/fhir/StructureDefinition/codesystem-supplement-type";
  public static final String CANONICAL_RESOLUTION_METHOD = "http://hl7.org/fhir/StructureDefinition/version-resolution-method";
  public static final String EXT_JSON_NAME_DEPRECATED = "http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-json-name";
  public static final String EXT_XML_NAME_DEPRECATED = "http://hl7.org/fhir/StructureDefinition/elementdefinition-xml-name";
  public static final String EXT_CS_ALTERNATE_USE = "http://hl7.org/fhir/StructureDefinition/alternate-code-use";
  public static final String EXT_VALUESET_SYSTEM = "http://hl7.org/fhir/StructureDefinition/valueset-system";
  public static final String EXT_ISSUE_INNER_MESSAGE = "http://hl7.org/fhir/tools/StructureDefinition/operationoutcome-inner-message";
  public static final String EXT_FEATURE = "http://hl7.org/fhir/uv/application-feature/StructureDefinition/feature";
  public static final String FEATURE_TX_TEST_VERSION = "http://hl7.org/fhir/uv/tx-tests/FeatureDefinition/test-version";
  public static final String FEATURE_TX_CS_PARAMS = "http://hl7.org/fhir/uv/tx-ecosystem/FeatureDefinition/CodeSystemAsParameter";
  public static final String EXT_UNCLOSED_REASON = "http://hl7.org/fhir/StructureDefinition/valueset-unclosed-reason";


  // special cases: defined in earlier versions and still used, but no longer defined
  public static final String EXT_XML_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-xml-type";
  public static final String EXT_EXTENSION_STYLE_DEPRECATED = "http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-extension-style";
  public static final String EXT_OBLIGATION_TOOLS = "http://hl7.org/fhir/tools/StructureDefinition/obligation";
  // the sub-extension name of EXT_OBLIGATION_SOURCE, not an extension url
  public static final String EXT_OBLIGATION_SOURCE_SHORT = "source";
  public static final String EXT_MAPPING_PREFIX = "http://hl7.org/fhir/tools/StructureDefinition/logical-mapping-prefix";
  public static final String EXT_MAPPING_SUFFIX = "http://hl7.org/fhir/tools/StructureDefinition/logical-mapping-suffix";
  public static final String EXT_ADDITIONAL_BASE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-additionalBase";
  public static final String EXT_OBLIGATION_PROFILE_FLAG_NEW = "http://hl7.org/fhir/StructureDefinition/obligation-profile";

  // web pages referenced from rendered content (not extension urls)
  public static final String WEB_EXTENSION_STYLE = "http://build.fhir.org/ig/FHIR/fhir-tools-ig/format-extensions.html#extension-related-extensions";
  public static final String WEB_BINDING_STYLE = "http://build.fhir.org/ig/FHIR/fhir-tools-ig/StructureDefinition-binding-style.html";

  // SDC questionnaire extensions (defined in the sdc IG, not the tools IG)
  public static final String EXT_Q_IS_SUBJ = "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-isSubject";
  public static final String EXT_Q_OTP_DISP = "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-optionalDisplay";
  public static final String EXT_O_LINK_PERIOD = "http://hl7.org/fhir/uv/sdc/StructureDefinition/sdc-questionnaire-observationLinkPeriod";

  // cross-version extension for the R4 value of Questionnaire.item.type
  public static final String EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-questionnaire.item.type";
  // cross-version extensions for values from prior ConceptMap versions
  public static final String EXT_OLD_CONCEPTMAP_EQUIVALENCE = "http://hl7.org/fhir/1.0/StructureDefinition/extension-ConceptMap.element.target.equivalence";
  public static final String EXT_CM_NOMAP_COMMENT = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ConceptMap.group.element.target.comment";
  {{mod}}

}