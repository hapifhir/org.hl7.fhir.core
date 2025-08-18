package org.hl7.fhir.dstu3.formats;

public enum FhirFormat {
  XML, JSON, JSONLD, TURTLE, TEXT, VBAR;

  public String getExtension() {
    switch (this) {
      case JSON:
        return "json";
      case JSONLD:
        return "ld.json";
      case TURTLE:
        return "ttl";
      case XML:
        return "xml";
      case TEXT:
        return "txt";
      case VBAR:
        return "hl7";
    }
    return null;
  }
}
