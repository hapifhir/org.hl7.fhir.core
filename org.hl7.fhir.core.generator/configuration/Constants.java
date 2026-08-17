{{startMark}}
package org.hl7.fhir.{{jid}}.core;

// generated

{{license}}


{{generated}}
public class Constants {

  public final static String LOCAL_REF_REGEX = "({{rt}})\\\\/[A-Za-z0-9\\\\-\\\\.]{1,64}";
  public final static String NS_SYSTEM_TYPE = "http://hl7.org/fhirpath/System.";
  public final static String NS_CDA_ROOT = "http://hl7.org/cda/stds/core";
  public final static String NS_FHIR_ROOT = "http://hl7.org/fhir";

  public final static String PACKAGE_NAME = "{{package-name}}";
  public final static String VERSION = "{{version}}";
  public final static String VERSION_BASE = "{{version-base}}";
  public final static String VERSION_MM = "{{version-mm}}";
  public final static String DATE = "{{date}}";
  public final static String URI_REGEX = "((http|https):\\/\\/([A-Za-z0-9\\\\\\.\\:\\%\\$\\-]*\\/)*?)?({{rt}})\\/[A-Za-z0-9\\-\\.]{1,64}(\\/_history\\/[A-Za-z0-9\\-\\.]{1,64})?";
}