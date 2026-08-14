{{startMark}}
package org.hl7.fhir.{{jid}}.extensions;

import org.hl7.fhir.utilities.Utilities;

// generated

{{license}}


{{generated}}
public class ExtensionDefinitions {
  
{{consts}}

  // not properly defined yet
  public static final String EXT_SUPPL_TYPE = "http://hl7.org/fhir/StructureDefinition/codesystem-supplement-type";
  public static final String CANONICAL_RESOLUTION_METHOD = "http://hl7.org/fhir/StructureDefinition/version-resolution-method";


  // special cases: defined in earlier versions and still used, but no longer defined
  public static final String EXT_XML_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-xml-type";
  {{mod}}

}