package org.hl7.fhir.model.utilities.formats;

public enum FhirFormat { XML, JSON, TURTLE, TEXT, VBAR, SHC, SHL, FML, NDJSON;
    // SHC = smart health cards, including as text versions of QR codes
    // SHL = smart health links, also a text version of the QR code
    
    public String getExtension() {
      switch (this) {
        case JSON:
          return "json";
        case TURTLE:
          return "ttl";
        case XML:
          return "xml";
        case TEXT:
          return "txt";
        case VBAR:
          return "hl7";
        case SHC:
          return "shc";
        case SHL:
          return "shl";
        case FML:
          return "fml";
        case NDJSON:
          return "ndjson";
      }
      return null;
    }

    public static FhirFormat getFhirFormat(String code) {
      switch (code) {
        case "json":
          return JSON;
        case "ttl":
          return TURTLE;
        case "xml":
          return XML;
        case "txt":
          return TEXT;
        case "hl7":
          return VBAR;
        case "shc":
          return SHC;
        case "shl":
          return SHL;
        case "fml":
          return FML;
        case "ndjson":
          return NDJSON;
      }
      return null;
    }
    public static FhirFormat readFromMimeType(String mt) {
      if (mt == null) {
        return null;
      }
      if (mt.contains("/xml") || mt.contains("+xml")) {
        return FhirFormat.XML;
      }
      if (mt.contains("/json") || mt.contains("+json")) {
        return FhirFormat.JSON;
      }
      return null;
    }

    public static FhirFormat fromCode(String code) {
      FhirFormat fmt = getFhirFormat(code);
      if (fmt == null) {
        fmt = readFromMimeType(code);
      } 
      return fmt;
    }

    public String toMimeType() {
      switch (this) {
      case FML: return "text/fhir+fml";
      case JSON: return "application/fhir+json";
      case NDJSON: return "application/fhir+ndjson";
      case SHC: return "application/shc";
      case SHL: return "application/shl";
      case TEXT: return "text/plain";
      case TURTLE: return "application/fhir+turtle";
      case VBAR: return "application/x-hl7-v2";
      case XML: return "application/fhir+xml";
      }
      return "??";
    }
  }
