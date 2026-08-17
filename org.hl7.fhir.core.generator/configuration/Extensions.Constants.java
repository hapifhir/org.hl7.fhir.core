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


  // special cases: defined in earlier versions and still used, but no longer defined
  public static final String EXT_XML_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-xml-type";
  public static final String EXT_EXTENSION_STYLE_DEPRECATED = "http://hl7.org/fhir/tools/StructureDefinition/elementdefinition-extension-style";
  public static final String EXT_OBLIGATION_TOOLS = "http://hl7.org/fhir/tools/StructureDefinition/obligation";
  // the sub-extension name of EXT_OBLIGATION_SOURCE, not an extension url
  public static final String EXT_OBLIGATION_SOURCE_SHORT = "source";
  public static final String EXT_MAPPING_PREFIX = "http://hl7.org/fhir/tools/StructureDefinition/logical-mapping-prefix";
  public static final String EXT_MAPPING_SUFFIX = "http://hl7.org/fhir/tools/StructureDefinition/logical-mapping-suffix";
  public static final String EXT_ADDITIONAL_BASE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-additionalBase";
  {{mod}}

}