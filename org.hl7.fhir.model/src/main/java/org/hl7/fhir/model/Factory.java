package org.hl7.fhir.model;

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



import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.UUID;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.ContactPoint.ContactPointSystem;
import org.hl7.fhir.model.core.Narrative.NarrativeStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

/*
Copyright (c) 2011+, HL7, Inc
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



public class Factory {

  public static IdType newId(String value) {
    if (value == null)
      return null;
    IdType res = new IdType();
    res.setValue(value);
    return res;
	}

  public static StringType newString_(String value) {
    if (value == null)
      return null;
    StringType res = new StringType();
    res.setValue(value);
    return res;
  }

  public static UriType newUri(String value) throws URISyntaxException {
    if (value == null)
      return null;
    UriType res = new UriType();
    res.setValue(value);
    return res;
  }

  public static UrlType newUrl(String value) throws URISyntaxException {
    if (value == null)
      return null;
    UrlType res = new UrlType();
    res.setValue(value);
    return res;
  }

  public static CanonicalType newCanonical(String value) throws URISyntaxException {
    if (value == null)
      return null;
    CanonicalType res = new CanonicalType();
    res.setValue(value);
    return res;
  }

  public static DateTimeType newDateTime(String value) throws ParseException {
    if (value == null)
      return null;
    return new DateTimeType(value);
  }

  public static DateType newDate(String value) throws ParseException {
    if (value == null)
      return null;
    return new DateType(value);
  }

  public static CodeType newCode(String value) {
    if (value == null)
      return null;
    CodeType res = new CodeType();
    res.setValue(value);
    return res;
  }

  public static IntegerType newInteger(int value) {
    IntegerType res = new IntegerType();
    res.setValue(value);
    return res;
  }
  
  public static IntegerType newInteger(java.lang.Integer value) {
    if (value == null)
      return null;
    IntegerType res = new IntegerType();
    res.setValue(value);
    return res;
  }
  
  public static BooleanType newBoolean(boolean value) {
    BooleanType res = new BooleanType();
    res.setValue(value);
    return res;
  }
  
  public static ContactPoint newContactPoint(ContactPointSystem system, String value) {
  	ContactPoint res = new ContactPoint();
	res.setSystem(system);
	res.setValue(value);
	return res;
  }

	public static Extension newExtension(String uri, DataType value, boolean evenIfNull) {
		if (!evenIfNull && (value == null || value.isEmpty()))
			return null;
		Extension e = new Extension();
		e.setUrl(uri);
		e.setValue(value);
	  return e;
  }

	public static CodeableConcept newCodeableConcept(String code, String system, String display) {
		CodeableConcept cc = new CodeableConcept();
		Coding c = new Coding();
		c.setCode(code);
		c.setSystem(system);
		c.setDisplay(display);
		cc.getCodingList().add(c);
	  return cc;
  }

	public static Reference makeReference(String url) {
	  Reference rr = new Reference();
	  rr.setReference(url);
	  return rr;
	}

	public static Narrative newNarrative(NarrativeStatus status, String html) throws IOException, FHIRException {
		Narrative n = new Narrative();
		n.setStatus(status);
		try {
			n.setDiv(new XhtmlParser().parseFragment("<div>"+Utilities.escapeXml(html)+"</div>"));
		} catch (org.hl7.fhir.exceptions.FHIRException e) {
			throw new FHIRException(e.getMessage(), e);
		}
		return n;
	}

	public static Coding makeCoding(String code) throws FHIRException {
		@SuppressWarnings("checkstyle:stringImplicitPatternUsage")
		//single literal character split
		String[] parts = code.split("\\|");
		Coding c = new Coding();
		if (parts.length == 2) {
			c.setSystem(parts[0]);
			c.setCode(parts[1]);
		} else if (parts.length == 3) {
			c.setSystem(parts[0]);
			c.setCode(parts[1]);
			c.setDisplay(parts[2]);
		} else 
			throw new FHIRException("Unable to understand the code '"+code+"'. Use the format system|code(|display)");
		return c;
	}

	public static Reference makeReference(String url, String text) {
		Reference rr = new Reference();
		rr.setReference(url);
		if (!Utilities.noString(text))
			rr.setDisplay(text);
		return rr;
	}

  public static String createUUID() {
    return "urn:uuid:"+UUID.randomUUID().toString().toLowerCase();
  }

  /**
   * Create an empty instance of the named data type - any concrete type that specializes DataType
   * (primitives, including xhtml, general purpose types, and BackboneTypes). Throws for anything else,
   * including resources and abstract types. See ResourceFactory for resources.
   */
  public DataType create(String name) throws FHIRException {
    switch (name) {
    // primitive types
    case "base64Binary":          return new Base64BinaryType();
    case "boolean":               return new BooleanType();
    case "canonical":             return new CanonicalType();
    case "code":                  return new CodeType();
    case "date":                  return new DateType();
    case "dateTime":              return new DateTimeType();
    case "decimal":               return new DecimalType();
    case "id":                    return new IdType();
    case "instant":               return new InstantType();
    case "integer":               return new IntegerType();
    case "integer64":             return new Integer64Type();
    case "markdown":              return new MarkdownType();
    case "oid":                   return new OidType();
    case "positiveInt":           return new PositiveIntType();
    case "string":                return new StringType();
    case "time":                  return new TimeType();
    case "unsignedInt":           return new UnsignedIntType();
    case "uri":                   return new UriType();
    case "url":                   return new UrlType();
    case "uuid":                  return new UuidType();
    case "xhtml":                 return new XhtmlType(new Narrative()); // XhtmlType is a view onto a narrative
    // complex types
    case "Address":               return new Address();
    case "Age":                   return new Age();
    case "Annotation":            return new Annotation();
    case "Attachment":            return new Attachment();
    case "Availability":          return new Availability();
    case "CodeableConcept":       return new CodeableConcept();
    case "CodeableReference":     return new CodeableReference();
    case "Coding":                return new Coding();
    case "ContactDetail":         return new ContactDetail();
    case "ContactPoint":          return new ContactPoint();
    case "Count":                 return new Count();
    case "DataRequirement":       return new DataRequirement();
    case "Distance":              return new Distance();
    case "Dosage":                return new Dosage();
    case "DosageCondition":       return new DosageCondition();
    case "DosageDetails":         return new DosageDetails();
    case "DosageSafety":          return new DosageSafety();
    case "Duration":              return new Duration();
    case "ElementDefinition":     return new ElementDefinition();
    case "Expression":            return new Expression();
    case "ExtendedContactDetail": return new ExtendedContactDetail();
    case "Extension":             return new Extension();
    case "HumanName":             return new HumanName();
    case "Identifier":            return new Identifier();
    case "MarketingStatus":       return new MarketingStatus();
    case "Meta":                  return new Meta();
    case "MonetaryComponent":     return new MonetaryComponent();
    case "Money":                 return new Money();
    case "Narrative":             return new Narrative();
    case "ParameterDefinition":   return new ParameterDefinition();
    case "Period":                return new Period();
    case "ProductShelfLife":      return new ProductShelfLife();
    case "Quantity":              return new Quantity();
    case "Range":                 return new Range();
    case "Ratio":                 return new Ratio();
    case "RatioRange":            return new RatioRange();
    case "Reference":             return new Reference();
    case "RelatedArtifact":       return new RelatedArtifact();
    case "RelativeTime":          return new RelativeTime();
    case "SampledData":           return new SampledData();
    case "Signature":             return new Signature();
    case "SimpleQuantity":        return new SimpleQuantity();
    case "Timing":                return new Timing();
    case "TriggerDefinition":     return new TriggerDefinition();
    case "UsageContext":          return new UsageContext();
    case "VirtualServiceDetail":  return new VirtualServiceDetail();
    default:
      throw new FHIRException("Unknown data type name "+name);
    }
  }
}