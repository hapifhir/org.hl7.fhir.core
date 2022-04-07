package org.hl7.fhir.r4b.utils;

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



import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.VersionUtilities.VersionURLInfo;


public class TypesUtilities {

  public enum TypeClassification {
    PRIMITIVE, DATATYPE, METADATATYPE, SPECIAL;

    public String toDisplay() {
      switch (this) {
      case DATATYPE: return "Data Type";
      case METADATATYPE: return "MetaDataType";
      case PRIMITIVE: return "Primitive Type";
      case SPECIAL: return "Special Type";
      }
      return "?tu-class?";
    }
  }

  public static class WildcardInformation {
    private TypeClassification classification;
    private String typeName;
    private String comment;
    public WildcardInformation(String typeName, String comment, TypeClassification classification) {
      super();
      this.typeName = typeName;
      this.comment = comment;
      this.classification = classification;
    }
    public WildcardInformation(String typeName, TypeClassification classification) {
      super();
      this.typeName = typeName;
      this.classification = classification;
    }
    public String getTypeName() {
      return typeName;
    }
    public String getComment() {
      return comment;
    }
    public TypeClassification getClassification() {
      return classification;
    }
    
  }
  
  public static List<String> wildcardTypes(String version) {
    List<String> res = new ArrayList<String>();
    for (WildcardInformation wi : wildcards(version))
      res.add(wi.getTypeName());
    return res;
  }
  
  // this is the master list for what data types are allowed where the types = *
  // that this list is incomplete means that the following types cannot have fixed values in a profile:
  //   Narrative
  //   Meta
  //   Any of the IDMP data types
  // You have to walk into them to profile them.
  //
  public static List<WildcardInformation> wildcards(String version) {
    if (version.startsWith("_")) {
      throw new Error("underscore");
    }
    List<WildcardInformation> res = new ArrayList<WildcardInformation>();

    // primitive types
    res.add(new WildcardInformation("base64Binary", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("boolean", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("canonical", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("code", "(only if the extension definition provides a <a href=\"terminologies.html#code\">fixed</a> binding to a suitable set of codes)", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("date", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("dateTime", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("decimal", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("id", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("instant", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("integer", TypeClassification.PRIMITIVE));
    if (!VersionUtilities.isR4BVer(version)) {
      res.add(new WildcardInformation("integer64", TypeClassification.PRIMITIVE));
    }
    res.add(new WildcardInformation("markdown", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("oid", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("positiveInt", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("string", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("time", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("unsignedInt", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("uri", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("url", TypeClassification.PRIMITIVE));
    res.add(new WildcardInformation("uuid", TypeClassification.PRIMITIVE));

    // Complex general purpose data types
    res.add(new WildcardInformation("Address", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Age", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Annotation", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Attachment", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("CodeableConcept", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("CodeableReference", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Coding", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("ContactPoint", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Count", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Distance", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Duration", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("HumanName", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Identifier", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Money", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Period", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Quantity", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Range", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Ratio", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("RatioRange", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Reference", " - a reference to another resource", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("SampledData", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Signature", TypeClassification.DATATYPE));
    res.add(new WildcardInformation("Timing", TypeClassification.DATATYPE));
    
    // metadata types
    res.add(new WildcardInformation("ContactDetail", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("Contributor", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("DataRequirement", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("Expression", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("ParameterDefinition", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("RelatedArtifact", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("TriggerDefinition", TypeClassification.METADATATYPE));
    res.add(new WildcardInformation("UsageContext", TypeClassification.METADATATYPE));
    
    // special cases
    res.add(new WildcardInformation("Dosage", TypeClassification.SPECIAL));
    res.add(new WildcardInformation("Meta", TypeClassification.SPECIAL));
    return res;
  }

  public static boolean isPrimitive(String code) {
    return Utilities.existsInList(code, "boolean", "integer", "integer64", "string", "decimal", "uri", "url", "canonical", "base64Binary", "instant", "date", "dateTime", "time", "code", "oid", "id", "markdown", "unsignedInt", "positiveInt", "xhtml");
  }
}