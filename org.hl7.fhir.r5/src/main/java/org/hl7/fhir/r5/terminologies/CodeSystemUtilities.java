package org.hl7.fhir.r5.terminologies;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.ConceptDefinitionComponentSorter;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;

public class CodeSystemUtilities {

  public static class SystemReference {
    private String link;
    private String text;
    private boolean local;
    
    public SystemReference(String text, String link) {
      super();
      this.link = link;
      this.text = text;
    }
    public SystemReference(String text, String link, boolean local) {
      super();
      this.link = link;
      this.text = text;
      this.local = local;
    }
    
    public String getLink() {
      return link;
    }
    public String getText() {
      return text;
    }
    public boolean isLocal() {
      return local;
    }
    
  }

  public static class ConceptDefinitionComponentSorter implements Comparator<ConceptDefinitionComponent> {

    @Override
    public int compare(ConceptDefinitionComponent o1, ConceptDefinitionComponent o2) {
      return o1.getCode().compareToIgnoreCase(o2.getCode());
    }

  }

  public static final String USER_DATA_CROSS_LINK = "cs.utils.cross.link";

  public static class CodeSystemNavigator {

    private CodeSystem cs;
    private boolean restructure;
    private Set<String> processed = new HashSet<>();

    public CodeSystemNavigator(CodeSystem cs) {
      this.cs = cs;
      restructure = hasExtraRelationships(cs.getConcept());
    }

    public boolean isRestructure() {
      return restructure;
    }

    private boolean hasExtraRelationships(List<ConceptDefinitionComponent> concept) {
      for (ConceptDefinitionComponent cd : concept) {
        if (!getSubsumedBy(cd).isEmpty()) {
          return true;
        }
        for (ConceptDefinitionComponent cdc : cd.getConcept()) {
          if (hasExtraRelationships(cdc.getConcept())) {
            return true;
          }
        }
      }
      return false;
    }

    public List<ConceptDefinitionComponent> getConcepts(ConceptDefinitionComponent context) {
      if (context == null) {
        if (restructure) {
          List<ConceptDefinitionComponent> res = new ArrayList<>();
          for (ConceptDefinitionComponent cd : cs.getConcept()) {
            if (getSubsumedBy(cd).isEmpty()) {
              res.add(cd);
              processed.add(cd.getCode());
            }
          }
          return res;
        } else {
          return cs.getConcept();
        }
      } else {
        if (restructure) {
          List<ConceptDefinitionComponent> res = new ArrayList<>();
          for (ConceptDefinitionComponent cd : context.getConcept()) {
            res.add(cd);
            processed.add(cd.getCode());
          }
          for (ConceptDefinitionComponent cd : cs.getConcept()) {
            if (getSubsumedBy(cd).contains(context.getCode()) && !processed.contains(cd.getCode())) {
              res.add(cd);
              processed.add(cd.getCode());
            }
          }
          return res;
        } else {
          return context.getConcept();
        }
      }
    }

    private List<String> getSubsumedBy(ConceptDefinitionComponent cd) {
      List<String> codes = new ArrayList<>();
      for (ConceptPropertyComponent cp : cd.getProperty()) {
        if ("subsumedBy".equals(cp.getCode())) {
          codes.add(cp.getValue().primitiveValue());
        }
      }
      return codes;
    }

    public List<ConceptDefinitionComponent> getOtherChildren(ConceptDefinitionComponent context) {
      List<ConceptDefinitionComponent> res = new ArrayList<>();
      for (ConceptDefinitionComponent cd : cs.getConcept()) {
        if (getSubsumedBy(cd).contains(context.getCode()) && processed.contains(cd.getCode())) {
          res.add(cd);
        }
      }
      return res;
    }
  }


  public static boolean isNotSelectable(CodeSystem cs, ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent p : def.getProperty()) {
      if ("notSelectable".equals(p.getCode()) && p.hasValue() && p.getValue() instanceof BooleanType) 
        return ((BooleanType) p.getValue()).getValue();
    }
    return false;
  }

  public static void setNotSelectable(CodeSystem cs, ConceptDefinitionComponent concept) throws FHIRFormatError {
    defineNotSelectableProperty(cs);
    ConceptPropertyComponent p = getProperty(concept, "notSelectable");
    if (p != null)
      p.setValue(new BooleanType(true));
    else
      concept.addProperty().setCode("notSelectable").setValue(new BooleanType(true));    
  }

  public static void setProperty(CodeSystem cs, ConceptDefinitionComponent concept, String code, DataType value) throws FHIRFormatError {
    defineProperty(cs, code, propertyTypeForValue(value));
    ConceptPropertyComponent p = getProperty(concept,  code);
    if (p != null)
      p.setValue(value);
    else
      concept.addProperty().setCode(code).setValue(value);    
  }
  

  private static PropertyType propertyTypeForValue(DataType value) {
    if (value instanceof BooleanType) {
      return PropertyType.BOOLEAN;
    }
    if (value instanceof CodeType) {
      return PropertyType.CODE;
    }
    if (value instanceof Coding) {
      return PropertyType.CODING;
    }
    if (value instanceof DateTimeType) {
      return PropertyType.DATETIME;
    }
    if (value instanceof DecimalType) {
      return PropertyType.DECIMAL;
    }
    if (value instanceof IntegerType) {
      return PropertyType.INTEGER;
    }
    if (value instanceof StringType) {
      return PropertyType.STRING;
    }
    throw new Error("Unknown property type "+value.getClass().getName());
  }

  private static void defineProperty(CodeSystem cs, String code, PropertyType pt) {
    String url = "http://hl7.org/fhir/concept-properties#"+code;
    for (PropertyComponent p : cs.getProperty()) {
      if (p.getCode().equals(code)) {
        if (!p.getUri().equals(url)) {
          throw new Error("URI mismatch for code "+code+" url = "+p.getUri()+" vs "+url);
        }
        if (!p.getType().equals(pt)) {
          throw new Error("Type mismatch for code "+code+" type = "+p.getType()+" vs "+pt);
        }
        return;
      }
    }
    cs.addProperty().setCode(code).setUri(url).setType(pt).setUri(url);
  
  }

  public static void defineNotSelectableProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "notSelectable", "Indicates that the code is abstract - only intended to be used as a selector for other concepts", PropertyType.BOOLEAN);
  }


  public enum ConceptStatus {
    Active, Experimental, Deprecated, Retired;

    public String toCode() {
      switch (this) {
      case Active: return "active";
      case Experimental: return "experimental";
      case Deprecated: return "deprecated";
      case Retired: return "retired";
      default: return null;
      }
    }
  }

  public static void setStatus(CodeSystem cs, ConceptDefinitionComponent concept, ConceptStatus status) throws FHIRFormatError {
    defineStatusProperty(cs);
    ConceptPropertyComponent p = getProperty(concept, "status");
    if (p != null)
      p.setValue(new CodeType(status.toCode()));
    else
      concept.addProperty().setCode("status").setValue(new CodeType(status.toCode()));    
  }

  public static void defineStatusProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "status", "A property that indicates the status of the concept. One of active, experimental, deprecated, retired", PropertyType.CODE);
  }

  private static void defineDeprecatedProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "deprecationDate", "The date at which a concept was deprecated. Concepts that are deprecated but not inactive can still be used, but their use is discouraged", PropertyType.DATETIME);
  }

  public static void defineParentProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "parent", "The concept identified in this property is a parent of the concept on which it is a property. The property type will be 'code'. The meaning of parent/child relationships is defined by the hierarchyMeaning attribute", PropertyType.CODE);
  }

  public static void defineChildProperty(CodeSystem cs) {
    defineCodeSystemProperty(cs, "child", "The concept identified in this property is a child of the concept on which it is a property. The property type will be 'code'. The meaning of parent/child relationships is defined by the hierarchyMeaning attribute", PropertyType.CODE);
  }

  public static boolean isDeprecated(CodeSystem cs, ConceptDefinitionComponent def, boolean ignoreStatus)  {
    try {
      for (ConceptPropertyComponent p : def.getProperty()) {
        if (!ignoreStatus) {
          if ("status".equals(p.getCode()) && p.hasValue() && p.hasValueCodeType() && "deprecated".equals(p.getValueCodeType().getCode()))
            return true;
        }
        // this, though status should also be set
        if ("deprecationDate".equals(p.getCode()) && p.hasValue() && p.getValue() instanceof DateTimeType) 
          return ((DateTimeType) p.getValue()).before(new DateTimeType(Calendar.getInstance()));
        // legacy  
        if ("deprecated".equals(p.getCode()) && p.hasValue() && p.getValue() instanceof BooleanType) 
          return ((BooleanType) p.getValue()).getValue();
      }
      StandardsStatus ss = ToolingExtensions.getStandardsStatus(def);
      if (ss == StandardsStatus.DEPRECATED) {
        return true;
      }
      return false;
    } catch (FHIRException e) {
      return false;
    }
  }

  public static boolean isInactive(CodeSystem cs, ConceptDefinitionComponent def, boolean ignoreStatus)  {
    try {
      for (ConceptPropertyComponent p : def.getProperty()) {
        if (!ignoreStatus) {
          if ("status".equals(p.getCode()) && p.hasValue() && p.hasValueCodeType() && "inactive".equals(p.getValueCodeType().getCode()))
            return true;
        }
        // legacy  
        if ("inactive".equals(p.getCode()) && p.hasValue() && p.getValue() instanceof BooleanType) 
          return ((BooleanType) p.getValue()).getValue();
      }
      return false;
    } catch (FHIRException e) {
      return false;
    }
  }

  public static void setDeprecated(CodeSystem cs, ConceptDefinitionComponent concept, DateTimeType date) throws FHIRFormatError {
    setStatus(cs, concept, ConceptStatus.Deprecated);
    defineDeprecatedProperty(cs);
    concept.addProperty().setCode("deprecationDate").setValue(date);    
  }


  public static void setDeprecated(CodeSystem cs, ConceptDefinitionComponent concept) throws FHIRFormatError {
    setStatus(cs, concept, ConceptStatus.Deprecated);
  }
  
  public static boolean isInactive(CodeSystem cs, ConceptDefinitionComponent def) throws FHIRException {
    for (ConceptPropertyComponent p : def.getProperty()) {
      if ("status".equals(p.getCode()) && p.hasValueStringType()) {
        return "inactive".equals(p.getValueStringType().primitiveValue()) || "retired".equals(p.getValueStringType().primitiveValue());
      }
      if ("inactive".equals(p.getCode()) && p.hasValueBooleanType()) {
        return p.getValueBooleanType().getValue();
      }
    }
    return false;
  }
  
  public static boolean isInactive(CodeSystem cs, String code) throws FHIRException {
    ConceptDefinitionComponent def = findCode(cs.getConcept(), code);
    if (def == null)
      return true;
    return isInactive(cs, def);
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
      if (c.hasCode() &&  c.getCode().equals(code))
        return c.getDefinition();
      String s = getCodeDefinition(c.getConcept(), code);
      if (s != null)
        return s;
    }
    return null;
  }

  public static CodeSystem makeShareable(CodeSystem cs) {
    if (!cs.hasExperimental()) {
      cs.setExperimental(false);
    }

    if (!cs.hasMeta())
      cs.setMeta(new Meta());
    for (UriType t : cs.getMeta().getProfile()) 
      if ("http://hl7.org/fhir/StructureDefinition/shareablecodesystem".equals(t.getValue()))
        return cs;
    cs.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareablecodesystem"));
    return cs;
  }

  public static boolean checkMakeShareable(CodeSystem cs) {
    boolean changed = false;
    if (!cs.hasExperimental()) {
      cs.setExperimental(false);
      changed = true;
    }

    if (!cs.hasMeta())
      cs.setMeta(new Meta());
    for (UriType t : cs.getMeta().getProfile()) 
      if ("http://hl7.org/fhir/StructureDefinition/shareablecodesystem".equals(t.getValue()))
        return changed;
    cs.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareablecodesystem"));
    return true;
  }

  public static void setOID(CodeSystem cs, String oid) {
    if (!oid.startsWith("urn:oid:"))
       oid = "urn:oid:" + oid;
    if (!cs.hasIdentifier())
      cs.addIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986").setValue(oid));
    else if ("urn:ietf:rfc:3986".equals(cs.getIdentifierFirstRep().getSystem()) && cs.getIdentifierFirstRep().hasValue() && cs.getIdentifierFirstRep().getValue().startsWith("urn:oid:"))
      cs.getIdentifierFirstRep().setValue(oid);
    else
      throw new Error("unable to set OID on code system");
    
  }

  public static boolean hasOID(CanonicalResource cs) {
    return getOID(cs) != null;
  }

  public static String getOID(CanonicalResource cs) {
    if (cs.hasIdentifier() && "urn:ietf:rfc:3986".equals(cs.getIdentifierFirstRep().getSystem()) && cs.getIdentifierFirstRep().hasValue() && cs.getIdentifierFirstRep().getValue().startsWith("urn:oid:"))
        return cs.getIdentifierFirstRep().getValue().substring(8);
    return null;
  }

  public static ConceptDefinitionComponent findCode(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
      if (c.getCode().equals(code))
        return c;
      ConceptDefinitionComponent s = findCode(c.getConcept(), code);
      if (s != null)
        return s;
    }
    return null;
  }

  public static void markStatus(CodeSystem cs, String wg, StandardsStatus status, String pckage, String fmm, String normativeVersion) throws FHIRException {
    if (wg != null) {
      if (!ToolingExtensions.hasExtension(cs, ToolingExtensions.EXT_WORKGROUP) || 
          (Utilities.existsInList(ToolingExtensions.readStringExtension(cs, ToolingExtensions.EXT_WORKGROUP), "fhir", "vocab") && !Utilities.existsInList(wg, "fhir", "vocab"))) {
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
            System.out.println("Code System "+cs.getUrl()+": ownership clash "+pckage+" vs "+cs.getUserString("ballot.package"));
      }
      if (status == StandardsStatus.NORMATIVE) {
        cs.setExperimental(false);
        cs.setStatus(PublicationStatus.ACTIVE);
      }
    }
    if (fmm != null) {
      String sfmm = ToolingExtensions.readStringExtension(cs, ToolingExtensions.EXT_FMM_LEVEL);
      if (Utilities.noString(sfmm) || Integer.parseInt(sfmm) < Integer.parseInt(fmm)) { 
        ToolingExtensions.setIntegerExtension(cs, ToolingExtensions.EXT_FMM_LEVEL, Integer.parseInt(fmm));
      }
      if (Integer.parseInt(fmm) <= 1) {
        cs.setExperimental(true);
      }
    }
  }

 
  public static DataType readProperty(ConceptDefinitionComponent concept, String code) {
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
  
  public static List<ConceptPropertyComponent> getPropertyValues(ConceptDefinitionComponent concept, String code) {
    List<ConceptPropertyComponent> res = new ArrayList<>();
    for (ConceptPropertyComponent p : concept.getProperty()) {
      if (p.getCode().equals(code)) {
        res.add(p); 
      }
    }
    return res;
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

  public static boolean hasProperty(ConceptDefinitionComponent c, String code) {
    for (ConceptPropertyComponent cp : c.getProperty()) {
      if (code.equals(cp.getCode())) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasCode(CodeSystem cs, String code) {
    for (ConceptDefinitionComponent cc : cs.getConcept()) {
      if (hasCode(cc, code)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasCode(ConceptDefinitionComponent cc, String code) {
    if (code.equals(cc.getCode())) {
      return true;
    }
    for (ConceptDefinitionComponent c : cc.getConcept()) {
      if (hasCode(c, code)) {
        return true;
      }
    }
    return false;
  }

  public static ConceptDefinitionComponent getCode(CodeSystem cs, String code) {
    if (code == null) {
      return null;
    }
    for (ConceptDefinitionComponent cc : cs.getConcept()) {
      ConceptDefinitionComponent cd = getCode(cc, code);
      if (cd != null) {
        return cd;
      }
    }
    return null;
  }

  private static ConceptDefinitionComponent getCode(ConceptDefinitionComponent cc, String code) {
    if (code.equals(cc.getCode())) {
      return cc;
    }
    for (ConceptDefinitionComponent c : cc.getConcept()) {
      ConceptDefinitionComponent cd = getCode(c, code);
      if (cd != null) {
        return cd;
      }
    }
    return null;
  }

  public static void crossLinkCodeSystem(CodeSystem cs) {
    String parent = getPropertyByUrl(cs, "http://hl7.org/fhir/concept-properties#parent");
    if ((parent != null)) {
      crossLinkConcepts(cs.getConcept(), cs.getConcept(), parent);
    }
  }

  private static String getPropertyByUrl(CodeSystem cs, String url) {
    for (PropertyComponent pc : cs.getProperty()) {
      if (url.equals(pc.getUri())) {
        return pc.getCode();
      }
    }
    return null;
  }

  private static void crossLinkConcepts(List<ConceptDefinitionComponent> root, List<ConceptDefinitionComponent> focus, String parent) {
    for (ConceptDefinitionComponent def : focus) {
      List<ConceptPropertyComponent> pcl = getPropertyValues(def, parent);
      for (ConceptPropertyComponent pc : pcl) {
        String code = pc.getValue().primitiveValue();
        ConceptDefinitionComponent tgt = findCode(root, code);
        if (!tgt.hasUserData(USER_DATA_CROSS_LINK)) {
          tgt.setUserData(USER_DATA_CROSS_LINK, new ArrayList<>());
        }
        @SuppressWarnings("unchecked")
        List<ConceptDefinitionComponent> children = (List<ConceptDefinitionComponent>) tgt.getUserData(USER_DATA_CROSS_LINK);
        children.add(def);
      }      
      if (def.hasConcept()) {
        crossLinkConcepts(root, def.getConcept(), parent);
      }
    }
    
  }

  public static boolean hasHierarchy(CodeSystem cs) {
    for (ConceptDefinitionComponent c : cs.getConcept()) {
      if (c.hasConcept()) {
        return true;
      }
    }
    return false;
  }

  public static void sortAllCodes(CodeSystem cs) {
    sortAllCodes(cs.getConcept());
  }

  private static void sortAllCodes(List<ConceptDefinitionComponent> list) {
    Collections.sort(list, new ConceptDefinitionComponentSorter());
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasConcept()) {
        sortAllCodes(cd.getConcept());
      }
    }    
  }

  public static Coding readCoding(String jurisdiction) {    
    return jurisdiction == null || !jurisdiction.contains("#") ?  null : new Coding().setCode(jurisdiction.substring(jurisdiction.indexOf("#")+1)).setSystem(jurisdiction.substring(0, jurisdiction.indexOf("#")));
  }

  public static SystemReference getSystemReference(String system, IWorkerContext ctxt) {
    if (system == null) {
      return null;
    } if ("http://snomed.info/sct".equals(system)) {
      return new SystemReference("SNOMED CT", "https://browser.ihtsdotools.org/");      
    } else if ("http://loinc.org".equals(system)) {
      return new SystemReference("LOINC", "https://loinc.org/");            
    } else if ("http://unitsofmeasure.org".equals(system)) {
      return new SystemReference("UCUM", "http://ucum.org");            
    } else if (system.equals("http://www.nlm.nih.gov/research/umls/rxnorm")) {
      return new SystemReference("RxNorm", "http://www.nlm.nih.gov/research/umls/rxnorm");
    } else if (ctxt != null) {
      CodeSystem cs = ctxt.fetchCodeSystem(system);
      if (cs != null && cs.hasWebPath()) {
        return new SystemReference(cs.present(), cs.getWebPath(), Utilities.isAbsoluteUrl(cs.getWebPath()));
      } else if (cs != null) {
        return new SystemReference(cs.present(), null);
      }
    }
    return null;
  }

  public static boolean isNotCurrent(CodeSystem cs, ConceptDefinitionComponent c) {
    return isInactive(cs, c) || isDeprecated(cs, c, false);
  }

  public static List<String> getDisplays(CodeSystem srcCS, ConceptDefinitionComponent cd) {
    List<String> list = new ArrayList<>();
    if (cd.hasDisplay()) {
      list.add(cd.getDisplay());
    }
    for (ConceptDefinitionDesignationComponent d : cd.getDesignation()) {
      if (!list.contains(d.getValue())) {
        list.add(d.getValue());
      }
    }
    return list;
  }
}

