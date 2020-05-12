package org.hl7.fhir.r5.model;

{{license}}

{{startMark}}
  
import org.hl7.fhir.exceptions.FHIRException;

public class ResourceFactory extends Factory {

    public static Resource createResource(String name) throws FHIRException {
{{resource-factory}}
        else
            throw new FHIRException("Unknown Resource Name '"+name+"'");
    }

    public static Element createType(String name) throws FHIRException {
        if ("base64Binary".equals(name))            
          return new Base64BinaryType();
        if ("boolean".equals(name))            
          return new BooleanType();
        if ("canonical".equals(name))            
          return new CanonicalType();
        if ("code".equals(name))            
          return new CodeType();
        if ("date".equals(name))            
          return new DateType();
        if ("dateTime".equals(name))            
          return new DateTimeType();
        if ("decimal".equals(name))            
          return new DecimalType();
        if ("id".equals(name))            
          return new IdType();
        if ("instant".equals(name))            
          return new InstantType();
        if ("integer".equals(name))            
          return new IntegerType();
        if ("integer64".equals(name))            
          return new Integer64Type();
        if ("markdown".equals(name))            
          return new MarkdownType();
        if ("oid".equals(name))            
          return new OidType();
        if ("positiveInt".equals(name))            
          return new PositiveIntType();
        if ("string".equals(name))            
          return new StringType();
        if ("time".equals(name))            
          return new TimeType();
        if ("unsignedInt".equals(name))            
          return new UnsignedIntType();
        if ("uri".equals(name))            
          return new UriType();
        if ("url".equals(name))            
          return new UrlType();
        if ("uuid".equals(name))            
          return new UuidType();
{{type-factory}}
        else
            throw new FHIRException("Unknown Type Name '"+name+"'");    }

    public static Base createResourceOrType(String name) throws FHIRException {
      switch (name.hashCode()) {
        case -1216012752: return new Base64BinaryType();
        case 64711720: return new BooleanType();
        case 828351732: return new CanonicalType();
        case 3059181: return new CodeType();
        case 3076014: return new DateType();
        case 1792749467: return new DateTimeType();
        case 1542263633: return new DecimalType();
        case 3355: return new IdType();
        case 1957570017: return new InstantType();
        case 1958052158: return new IntegerType();
        case 246938863: return new MarkdownType();
        case 110026: return new OidType();
        case -131262666: return new PositiveIntType();
        case -891985903: return new StringType();
        case 3560141: return new TimeType();
        case 1145198778: return new UnsignedIntType();
        case 116076: return new UriType();
        case 116079: return new UrlType();
        case 3601339: return new UuidType();
{{case-factory}}
      default:
        throw new FHIRException("Unknown Resource or Type Name '"+name+"'");
    }
  }


}