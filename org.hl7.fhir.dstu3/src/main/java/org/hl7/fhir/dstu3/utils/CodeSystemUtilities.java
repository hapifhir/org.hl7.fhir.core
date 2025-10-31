package org.hl7.fhir.dstu3.utils;

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



import java.util.List;

import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.dstu3.model.CodeSystem.PropertyType;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Meta;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.utilities.Utilities;

public class CodeSystemUtilities {

  public static boolean isDeprecated(CodeSystem cs, ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent p : def.getProperty()) {
      if (p.getCode().equals("deprecated") && p.hasValue() && p.getValue() instanceof BooleanType) 
        return ((BooleanType) p.getValue()).getValue();
      if (p.getCode().equals("deprecationDate") && p.hasValue() && p.getValue() instanceof DateTimeType) 
        return ((DateTimeType) p.getValue()).before(new DateTimeType());
    }
    return false;
  }

  public static boolean isNotSelectable(CodeSystem cs, ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent p : def.getProperty()) {
      if (p.getCode().equals("notSelectable") && p.hasValue() && p.getValue() instanceof BooleanType) 
        return ((BooleanType) p.getValue()).getValue();
    }
    return false;
  }

  public static void setNotSelectable(CodeSystem cs, ConceptDefinitionComponent concept) throws FHIRFormatError {
    defineNotSelectableProperty(cs);
    concept.addProperty().setCode("notSelectable").setValue(new BooleanType(true));    
  }

  public static void setInactive(CodeSystem cs, ConceptDefinitionComponent concept) throws FHIRFormatError {
    defineInactiveProperty(cs);
    concept.addProperty().setCode("inactive").setValue(new BooleanType(true));    
  }

  public static void setDeprecated(CodeSystem cs, ConceptDefinitionComponent concept, DateTimeType date) throws FHIRFormatError {
    defineDeprecatedProperty(cs);
    concept.addProperty().setCode("deprecationDate").setValue(date);    
  }

  public static void defineNotSelectableProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "notSelectable", "Indicates that the code is abstract - only intended to be used as a selector for other concepts", PropertyType.BOOLEAN);
  }

  public static void defineInactiveProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "inactive", "True if the concept is not considered active - e.g. not a valid concept any more", PropertyType.BOOLEAN);
  }

  public static void defineDeprecatedProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "deprecationDate", "The date at which a concept was deprecated. Concepts that are deprecated but not inactive can still be used, but their use is discouraged", PropertyType.DATETIME);
  }

  public static void defineCodeSystemProperty(CodeSystem cs, String code, String description, PropertyType type) {
    for (PropertyComponent p : cs.getProperty()) {
      if (p.getCode().equals(code))
        return;
    }
    cs.addProperty().setCode(code).setDescription(description).setType(type).setUri("http://hl7.org/fhir/concept-properties#"+code);
  }

  public static String getCodeDefinition(CodeSystem cs, String code) {
    return getCodeDefinition(cs.getConcept(), code);
  }

  private static String getCodeDefinition(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
      if (c.getCode().equals(code))
        return c.getDefinition();
      String s = getCodeDefinition(c.getConcept(), code);
      if (s != null)
        return s;
    }
    return null;
  }

  public static CodeSystem makeShareable(CodeSystem cs) {
    if (!cs.hasMeta())
      cs.setMeta(new Meta());
    for (UriType t : cs.getMeta().getProfile()) 
      if (t.getValue().equals("http://hl7.org/fhir/StructureDefinition/shareablecodesystem"))
        return cs;
    cs.getMeta().getProfile().add(new UriType("http://hl7.org/fhir/StructureDefinition/shareablecodesystem"));
    return cs;
  }

  public static void setOID(CodeSystem cs, String oid) {
    if (!oid.startsWith("urn:oid:"))
       oid = "urn:oid:" + oid;
    if (!cs.hasIdentifier())
      cs.setIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986").setValue(oid));
    else if ("urn:ietf:rfc:3986".equals(cs.getIdentifier().getSystem()) && cs.getIdentifier().hasValue() && cs.getIdentifier().getValue().startsWith("urn:oid:"))
      cs.getIdentifier().setValue(oid);
    else
      throw new Error("unable to set OID on code system");
    
  }

  public static boolean hasOID(CodeSystem cs) {
    return getOID(cs) != null;
  }

  public static String getOID(CodeSystem cs) {
    if (cs.hasIdentifier() && "urn:ietf:rfc:3986".equals(cs.getIdentifier().getSystem()) && cs.getIdentifier().hasValue() && cs.getIdentifier().getValue().startsWith("urn:oid:"))
        return cs.getIdentifier().getValue().substring(8);
    return null;
  }

  public static boolean isInactive(CodeSystem cs, ConceptDefinitionComponent def) throws FHIRException {
    for (ConceptPropertyComponent p : def.getProperty()) {
      if (p.getCode().equals("status") && p.hasValueStringType()) 
        return "inactive".equals(p.getValueStringType());
    }
    return false;
  }
  
  public static boolean isInactive(CodeSystem cs, String code) throws FHIRException {
    ConceptDefinitionComponent def = findCode(cs.getConcept(), code);
    if (def == null)
      return true;
    return isInactive(cs, def);
  }

  private static ConceptDefinitionComponent findCode(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
      if (c.getCode().equals(code))
        return c;
      ConceptDefinitionComponent s = findCode(c.getConcept(), code);
      if (s != null)
        return s;
    }
    return null;
  }

  public static void markStatus(CodeSystem cs, String wg, String status, String fmm) {
    if (wg != null) {
      if (!ExtensionUtilities.hasExtension(cs, ExtensionUtilities.EXT_WORKGROUP) ||
          (Utilities.existsInList(ExtensionUtilities.readStringExtension(cs, ExtensionUtilities.EXT_WORKGROUP), "fhir", "vocab") && !Utilities.existsInList(wg, "fhir", "vocab"))) {
        ExtensionUtilities.setCodeExtension(cs, ExtensionUtilities.EXT_WORKGROUP, wg);
      }
    }
    if (status != null) {
      String ss = ExtensionUtilities.readStringExtension(cs, ExtensionUtilities.EXT_BALLOT_STATUS);
      if (Utilities.noString(ss) || ssval(ss) < ssval(status)) 
        ExtensionUtilities.setStringExtension(cs, ExtensionUtilities.EXT_BALLOT_STATUS, status);
    }
    if (fmm != null) {
      String sfmm = ExtensionUtilities.readStringExtension(cs, ExtensionUtilities.EXT_FMM_LEVEL);
      if (Utilities.noString(sfmm) || Integer.parseInt(sfmm) < Integer.parseInt(fmm)) 
        ExtensionUtilities.setIntegerExtension(cs, ExtensionUtilities.EXT_FMM_LEVEL, Integer.parseInt(fmm));
    }
  }

  private static int ssval(String status) {
    if ("Draft".equals("status")) 
      return 1;
    if ("Informative".equals("status")) 
      return 2;
    if ("External".equals("status")) 
      return 3;
    if ("Trial Use".equals("status")) 
      return 3;
    if ("Normative".equals("status")) 
      return 4;
    return -1;
  }

}