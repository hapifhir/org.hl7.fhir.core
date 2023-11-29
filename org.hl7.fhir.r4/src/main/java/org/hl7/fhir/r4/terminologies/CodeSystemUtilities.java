package org.hl7.fhir.r4.terminologies;

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
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r4.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r4.model.CodeSystem.PropertyType;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r4.utils.ToolingExtensions;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;

public class CodeSystemUtilities {

  public static boolean isNotSelectable(CodeSystem cs, ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent p : def.getProperty()) {
      if (p.getCode().equals("notSelectable") && p.hasValue() && p.getValue() instanceof BooleanType)
        return ((BooleanType) p.getValue()).getValue();
    }
    return false;
  }

  public static void setNotSelectable(CodeSystem cs, ConceptDefinitionComponent concept) throws FHIRFormatError {
    defineNotSelectableProperty(cs);
    ConceptPropertyComponent p = getProperty(concept, "abstract");
    if (p != null)
      p.setValue(new BooleanType(true));
    else
      concept.addProperty().setCode("notSelectable").setValue(new BooleanType(true));
  }

  public static void defineNotSelectableProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "notSelectable",
        "Indicates that the code is abstract - only intended to be used as a selector for other concepts",
        PropertyType.BOOLEAN);
  }


  public static Coding readCoding(String jurisdiction) {    
    return jurisdiction == null || !jurisdiction.contains("#") ?  null : new Coding().setCode(jurisdiction.substring(jurisdiction.indexOf("#")+1)).setSystem(jurisdiction.substring(0, jurisdiction.indexOf("#")));
  }

  public enum ConceptStatus {
    Active, Experimental, Deprecated, Retired;

    public String toCode() {
      switch (this) {
      case Active:
        return "active";
      case Experimental:
        return "experimental";
      case Deprecated:
        return "deprecated";
      case Retired:
        return "retired";
      default:
        return null;
      }
    }
  }

  public static void setStatus(CodeSystem cs, ConceptDefinitionComponent concept, ConceptStatus status)
      throws FHIRFormatError {
    defineStatusProperty(cs);
    ConceptPropertyComponent p = getProperty(concept, "status");
    if (p != null)
      p.setValue(new CodeType(status.toCode()));
    else
      concept.addProperty().setCode("status").setValue(new CodeType(status.toCode()));
  }

  public static void defineStatusProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "status",
        "A property that indicates the status of the concept. One of active, experimental, deprecated, retired",
        PropertyType.CODE);
  }

  private static void defineDeprecatedProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "deprecationDate",
        "The date at which a concept was deprecated. Concepts that are deprecated but not inactive can still be used, but their use is discouraged",
        PropertyType.DATETIME);
  }

  public static void defineParentProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "parent",
        "The concept identified in this property is a parent of the concept on which it is a property. The property type will be 'code'. The meaning of parent/child relationships is defined by the hierarchyMeaning attribute",
        PropertyType.CODE);
  }

  public static void defineChildProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "child",
        "The concept identified in this property is a child of the concept on which it is a property. The property type will be 'code'. The meaning of parent/child relationships is defined by the hierarchyMeaning attribute",
        PropertyType.CODE);
  }

  public static boolean isDeprecated(CodeSystem cs, ConceptDefinitionComponent def) {
    try {
      for (ConceptPropertyComponent p : def.getProperty()) {
        if (p.getCode().equals("status") && p.hasValue() && p.hasValueCodeType()
            && p.getValueCodeType().getCode().equals("deprecated"))
          return true;
        // this, though status should also be set
        if (p.getCode().equals("deprecationDate") && p.hasValue() && p.getValue() instanceof DateTimeType)
          return ((DateTimeType) p.getValue()).before(new DateTimeType(Calendar.getInstance()));
        // legacy
        if (p.getCode().equals("deprecated") && p.hasValue() && p.getValue() instanceof BooleanType)
          return ((BooleanType) p.getValue()).getValue();
      }
      return false;
    } catch (FHIRException e) {
      return false;
    }
  }

  public static void setDeprecated(CodeSystem cs, ConceptDefinitionComponent concept, DateTimeType date)
      throws FHIRFormatError {
    setStatus(cs, concept, ConceptStatus.Deprecated);
    defineDeprecatedProperty(cs);
    concept.addProperty().setCode("deprecationDate").setValue(date);
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

  public static PropertyComponent defineCodeSystemProperty(CodeSystem cs, String code, String description,
      PropertyType type) {
    for (PropertyComponent p : cs.getProperty()) {
      if (p.getCode().equals(code))
        return p;
    }
    PropertyComponent p = cs.addProperty();
    p.setCode(code).setDescription(description).setType(type).setUri("http://hl7.org/fhir/concept-properties#" + code);
    return p;
  }

  public static String getCodeDefinition(CodeSystem cs, String code) {
    return getCodeDefinition(cs.getConcept(), code);
  }

  private static String getCodeDefinition(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
      if (c.hasCode() && c.getCode().equals(code))
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
    cs.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareablecodesystem"));
    return cs;
  }

  public static void setOID(CodeSystem cs, String oid) {
    if (!oid.startsWith("urn:oid:"))
      oid = "urn:oid:" + oid;
    if (!cs.hasIdentifier())
      cs.addIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986").setValue(oid));
    else if ("urn:ietf:rfc:3986".equals(cs.getIdentifierFirstRep().getSystem()) && cs.getIdentifierFirstRep().hasValue()
        && cs.getIdentifierFirstRep().getValue().startsWith("urn:oid:"))
      cs.getIdentifierFirstRep().setValue(oid);
    else
      throw new Error("unable to set OID on code system");

  }

  public static boolean hasOID(CodeSystem cs) {
    return getOID(cs) != null;
  }

  public static String getOID(CodeSystem cs) {
    if (cs.hasIdentifier() && "urn:ietf:rfc:3986".equals(cs.getIdentifierFirstRep().getSystem())
        && cs.getIdentifierFirstRep().hasValue() && cs.getIdentifierFirstRep().getValue().startsWith("urn:oid:"))
      return cs.getIdentifierFirstRep().getValue().substring(8);
    return null;
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

  public static void markStatus(CodeSystem cs, String wg, StandardsStatus status, String pckage, String fmm,
      String normativeVersion) throws FHIRException {
    if (wg != null) {
      if (!ToolingExtensions.hasExtension(cs, ToolingExtensions.EXT_WORKGROUP)
          || (Utilities.existsInList(ToolingExtensions.readStringExtension(cs, ToolingExtensions.EXT_WORKGROUP), "fhir",
              "vocab") && !Utilities.existsInList(wg, "fhir", "vocab"))) {
        ToolingExtensions.setCodeExtension(cs, ToolingExtensions.EXT_WORKGROUP, wg);
      }
    }
    if (status != null) {
      StandardsStatus ss = ToolingExtensions.getStandardsStatus(cs);
      if (ss == null || ss.isLowerThan(status))
        ToolingExtensions.setStandardsStatus(cs, status, normativeVersion);
      if (pckage != null) {
        if (!cs.hasUserData("ballot.package"))
          cs.setUserData("ballot.package", pckage);
        else if (!pckage.equals(cs.getUserString("ballot.package")))
          if (!"infrastructure".equals(cs.getUserString("ballot.package")))
            System.out.println("Code System " + cs.getUrl() + ": ownership clash " + pckage + " vs "
                + cs.getUserString("ballot.package"));
      }
      if (status == StandardsStatus.NORMATIVE) {
        cs.setExperimental(false);
        cs.setStatus(PublicationStatus.ACTIVE);
      }
    }
    if (fmm != null) {
      String sfmm = ToolingExtensions.readStringExtension(cs, ToolingExtensions.EXT_FMM_LEVEL);
      if (Utilities.noString(sfmm) || Integer.parseInt(sfmm) < Integer.parseInt(fmm))
        ToolingExtensions.setIntegerExtension(cs, ToolingExtensions.EXT_FMM_LEVEL, Integer.parseInt(fmm));
    }
  }

  public static Type readProperty(ConceptDefinitionComponent concept, String code) {
    for (ConceptPropertyComponent p : concept.getProperty())
      if (p.getCode().equals(code))
        return p.getValue();
    return null;
  }

  public static ConceptPropertyComponent getProperty(ConceptDefinitionComponent concept, String code) {
    for (ConceptPropertyComponent p : concept.getProperty())
      if (p.getCode().equals(code))
        return p;
    return null;
  }

  // see http://hl7.org/fhir/R4/codesystem.html#hierachy
  // returns additional parents not in the heirarchy
  public static List<String> getOtherChildren(CodeSystem cs, ConceptDefinitionComponent c) {
    List<String> res = new ArrayList<String>();
    for (ConceptPropertyComponent p : c.getProperty()) {
      if ("parent".equals(p.getCode())) {
        res.add(p.getValue().primitiveValue());
      }
    }
    return res;
  }

  // see http://hl7.org/fhir/R4/codesystem.html#hierachy
  public static void addOtherChild(CodeSystem cs, ConceptDefinitionComponent owner, String code) {
    defineChildProperty(cs);
    owner.addProperty().setCode("child").setValue(new CodeType(code));
  }

  public static class ConceptDefinitionComponentSorter implements Comparator<ConceptDefinitionComponent> {

    @Override
    public int compare(ConceptDefinitionComponent o1, ConceptDefinitionComponent o2) {
      return o1.getCode().compareToIgnoreCase(o2.getCode());
    }

  }

  public static void sortAllCodes(CodeSystem cs) {
    sortAllCodes(cs.getConcept());
  }

  public static void sortAllCodes(List<ConceptDefinitionComponent> list) {
    Collections.sort(list, new ConceptDefinitionComponentSorter());
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasConcept()) {
        sortAllCodes(cd.getConcept());
      }
    }
  }

}