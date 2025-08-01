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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.ConceptDefinitionComponentSorter;
import org.hl7.fhir.r5.terminologies.providers.SpecialCodeSystem;
import org.hl7.fhir.r5.utils.CanonicalResourceUtilities;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

@Slf4j
public class CodeSystemUtilities extends TerminologyUtilities {

  public static class CodeSystemSorter implements Comparator<CodeSystem> {

    @Override
    public int compare(CodeSystem o1, CodeSystem o2) {
      String url1 = o1.getUrl();
      String url2 = o2.getUrl();
      int c = compareString(url1, url2);
      if (c == 0) {
        String ver1 = o1.getVersion();
        String ver2 = o2.getVersion();
        c = VersionUtilities.compareVersions(ver1, ver2);
        if (c == 0) {
          String d1 = o1.getDateElement().asStringValue();
          String d2 = o2.getDateElement().asStringValue();
          c = compareString(url1, url2);
        }
      }
      return c;
    }

    private int compareString(String s1, String s2) {
      if (s1 == null) {
        return s2 == null ? 0 : 1;
      } else {
        return s1.compareTo(s2);
      }
    }

  }


  
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
      return o1.hasCode() ? o1.getCode().compareToIgnoreCase(o2.getCode()) : 0;
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
    String pd = getPropertyByUrl(cs, "http://hl7.org/fhir/concept-properties#notSelectable");
    if (pd == null) {
      pd = "notSelectable";
    }
    for (ConceptPropertyComponent p : def.getProperty()) {
      if (pd.equals(p.getCode()) && p.hasValue() && p.getValue() instanceof BooleanType) 
        return ((BooleanType) p.getValue()).getValue();
    }
    return false;
  }

  public static boolean isNotSelectable(CodeSystem cs, String code) {
    ConceptDefinitionComponent cd = findCode(cs.getConcept(), code);
    return cd == null ? false : isNotSelectable(cs, cd);
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
  
  public static void setProperty(CodeSystem cs, ConceptDefinitionComponent concept, String url, String code, DataType value) throws FHIRFormatError {
    defineProperty(cs, code, propertyTypeForValue(value), url);
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

  private static String defineProperty(CodeSystem cs, String code, PropertyType pt) {
    String url = "http://hl7.org/fhir/concept-properties#"+code;
    return defineProperty(cs, code, pt, url);
  }
  private static String defineProperty(CodeSystem cs, String code, PropertyType pt, String url) {
    for (PropertyComponent p : cs.getProperty()) {
      if (p.hasCode() && p.getCode().equals(code)) {
        if (!p.getUri().equals(url)) {
          throw new Error("URI mismatch for code "+code+" url = "+p.getUri()+" vs "+url);
        }
        if (!p.getType().equals(pt)) {
          throw new Error("Type mismatch for code "+code+" type = "+p.getType()+" vs "+pt);
        }
        return code;
      }
    }
    cs.addProperty().setCode(code).setUri(url).setType(pt).setUri(url);
    return code;
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
      StandardsStatus ss = ExtensionUtilities.getStandardsStatus(def);
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
    StandardsStatus ss = ExtensionUtilities.getStandardsStatus(def);
    if (ss == StandardsStatus.DEPRECATED || ss == StandardsStatus.WITHDRAWN) {
      return true;
    }
    for (ConceptPropertyComponent p : def.getProperty()) {
      if ("status".equals(p.getCode()) && p.hasValueStringType()) {
        return "inactive".equals(p.getValueStringType().primitiveValue()) || "retired".equals(p.getValueStringType().primitiveValue()) || "deprecated".equals(p.getValueStringType().primitiveValue());
      }
      if ("inactive".equals(p.getCode()) && p.hasValueBooleanType()) {
        return p.getValueBooleanType().getValue();
      }
      if ("inactive".equals(p.getCode()) && p.hasValueCodeType()) {
        String code = p.getValueCodeType().primitiveValue();
        return "true".equals(code);
      }
    }
    return false;
  }
  
  public static boolean isInactive(CodeSystem cs, String code) throws FHIRException {
    if (cs.hasUserData(UserDataNames.tx_cs_special)) {
      SpecialCodeSystem scs = (SpecialCodeSystem) cs.getUserData(UserDataNames.tx_cs_special);
      return scs.inactive(code);
    }
    ConceptDefinitionComponent def = findCode(cs.getConcept(), code);
    if (def == null)
      return true;
    return isInactive(cs, def);
  }

  public static void defineCodeSystemProperty(CodeSystem cs, String code, String description, PropertyType type) {
    for (PropertyComponent p : cs.getProperty()) {
      if (p.hasCode() && p.getCode().equals(code))
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
    if (cs != null && cs.hasIdentifier() && "urn:ietf:rfc:3986".equals(cs.getIdentifierFirstRep().getSystem()) && cs.getIdentifierFirstRep().hasValue() && cs.getIdentifierFirstRep().getValue().startsWith("urn:oid:"))
        return cs.getIdentifierFirstRep().getValue().substring(8);
    return null;
  }

  public static ConceptDefinitionComponent findCode(List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
      if (c.hasCode() && c.getCode().equals(code))
        return c;
      ConceptDefinitionComponent s = findCode(c.getConcept(), code);
      if (s != null)
        return s;
    }
    return null;
  }


  public static List<ConceptDefinitionComponent> findCodeWithParents(List<ConceptDefinitionComponent> parents, List<ConceptDefinitionComponent> list, String code) {
    for (ConceptDefinitionComponent c : list) {
      if (c.hasCode() && c.getCode().equals(code)) {
        return addToList(parents, c);
      }
      List<ConceptDefinitionComponent> s = findCodeWithParents(addToList(parents, c), c.getConcept(), code);
      if (s != null)
        return s;
    }
    return null;
  }

  private static List<ConceptDefinitionComponent> addToList(List<ConceptDefinitionComponent> parents, ConceptDefinitionComponent c) {
    List<ConceptDefinitionComponent> res = new ArrayList<CodeSystem.ConceptDefinitionComponent>();
    if (parents != null) {
      res.addAll(parents);
    }
    res.add(c);
    return res;
  }

  public static ConceptDefinitionComponent findCodeOrAltCode(List<ConceptDefinitionComponent> list, String code, String use) {
    for (ConceptDefinitionComponent c : list) {
      if (c.hasCode() && c.getCode().equals(code))
        return c;
      for (ConceptPropertyComponent p : c.getProperty()) {
        if ("alternateCode".equals(p.getCode()) && (use == null || hasUse(p, use)) && p.hasValue() && p.getValue().isPrimitive() && code.equals(p.getValue().primitiveValue())) {
          return c;
        }
      }
      ConceptDefinitionComponent s = findCodeOrAltCode(c.getConcept(), code, use);
      if (s != null)
        return s;
    }
    return null;
  }

  private static boolean hasUse(ConceptPropertyComponent p, String use) {
    for (Extension ext : p.getExtensionsByUrl(ExtensionDefinitions.EXT_CS_ALTERNATE_USE)) {
      if (ext.hasValueCoding() && use.equals(ext.getValueCoding().getCode())) {
        return true;
      }
    }
    return false;
  }

  public static void markStatus(CodeSystem cs, String wg, StandardsStatus status, String pckage, String fmm, String normativeVersion) throws FHIRException {
    if (wg != null) {
      if (!ExtensionUtilities.hasExtension(cs, ExtensionDefinitions.EXT_WORKGROUP) || 
          (Utilities.existsInList(ExtensionUtilities.readStringExtension(cs, ExtensionDefinitions.EXT_WORKGROUP), "fhir", "vocab") && !Utilities.existsInList(wg, "fhir", "vocab"))) {
        CanonicalResourceUtilities.setHl7WG(cs, wg);
      }
    }
    if (status != null) {
      StandardsStatus ss = ExtensionUtilities.getStandardsStatus(cs);
      if (ss == null || ss.isLowerThan(status)) 
        ExtensionUtilities.setStandardsStatus(cs, status, normativeVersion);
      if (pckage != null) {
        if (!cs.hasUserData(UserDataNames.kindling_ballot_package))
          cs.setUserData(UserDataNames.kindling_ballot_package, pckage);
        else if (!pckage.equals(cs.getUserString(UserDataNames.kindling_ballot_package)))
          if (!"infrastructure".equals(cs.getUserString(UserDataNames.kindling_ballot_package)))
            log.warn("Code System "+cs.getUrl()+": ownership clash "+pckage+" vs "+cs.getUserString(UserDataNames.kindling_ballot_package));
      }
      if (status == StandardsStatus.NORMATIVE) {
        cs.setStatus(PublicationStatus.ACTIVE);
      }
    }
    if (fmm != null) {
      String sfmm = ExtensionUtilities.readStringExtension(cs, ExtensionDefinitions.EXT_FMM_LEVEL);
      if (Utilities.noString(sfmm) || Integer.parseInt(sfmm) < Integer.parseInt(fmm)) { 
        ExtensionUtilities.setIntegerExtension(cs, ExtensionDefinitions.EXT_FMM_LEVEL, Integer.parseInt(fmm));
      }
    }
  }

 
  public static DataType readProperty(ConceptDefinitionComponent concept, String code) {
    for (ConceptPropertyComponent p : concept.getProperty())
      if (p.hasCode() && p.getCode().equals(code))
        return p.getValue(); 
    return null;
  }

  public static ConceptPropertyComponent getProperty(ConceptDefinitionComponent concept, String code) {
    for (ConceptPropertyComponent p : concept.getProperty())
      if (p.hasCode() && p.getCode().equals(code))
        return p; 
    return null;
  }
  
  public static List<ConceptPropertyComponent> getPropertyValues(ConceptDefinitionComponent concept, String code) {
    List<ConceptPropertyComponent> res = new ArrayList<>();
    if (code != null) {
      for (ConceptPropertyComponent p : concept.getProperty()) {
        if (code.equals(p.getCode())) {
          res.add(p); 
        }
      }
    }
    return res;
  }

  // see http://hl7.org/fhir/R4/codesystem.html#hierachy
  // returns additional parents not in the hierarchy
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

  public static boolean checkDisplay(CodeSystem cs, ConceptDefinitionComponent cd, String display) {
    List<String> displays = getDisplays(cs, cd);
    for (String s : displays) {
      if (s.equalsIgnoreCase(display)) {
        return true;
      }
    }
    return false;
  }

  public static int countCodes(CodeSystem cs) {
    return countCodes(cs.getConcept());
  }

  private static int countCodes(List<ConceptDefinitionComponent> concept) {
    int t = concept.size();
    for (ConceptDefinitionComponent cd : concept) {
      t = t + (cd.hasConcept() ?  countCodes(cd.getConcept()) : 0);
    }
    return t;
  }

  public static CodeSystem mergeSupplements(CodeSystem cs, List<CodeSystem> supplements) {
    CodeSystem ret = cs.copy();
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (CodeSystem sup : supplements) {
      b.append(sup.getVersionedUrl());      
    }
    ret.setUserData(UserDataNames.tx_known_supplements, b.toString());

    for (ConceptDefinitionComponent t : ret.getConcept()) {
      mergeSupplements(ret, t, supplements);
    }
    return ret;
  }

  private static void mergeSupplements(CodeSystem ret, ConceptDefinitionComponent fdef, List<CodeSystem> supplements) {
    for (CodeSystem cs : supplements) {
      ConceptDefinitionComponent def = CodeSystemUtilities.findCode(cs.getConcept(), fdef.getCode());
      if (def != null) {
        for (Extension ext : def.getExtension()) {
          fdef.addExtension(ext.copy());
        }
        for (ConceptDefinitionDesignationComponent d : def.getDesignation()) {
          fdef.addDesignation(d.copy());
        }
        for (ConceptPropertyComponent p : def.getProperty()) {
          PropertyComponent pd = CodeSystemUtilities.getPropertyDefinition(cs, p);
          String code;
          if (pd != null) {
            code = defineProperty(ret, pd, propertyTypeForType(p.getValue()));
          } else {
            code = defineProperty(ret, p.getCode(), propertyTypeForType(p.getValue()));
          }
          fdef.addProperty().setCode(code).setValue(p.getValue()).copyExtensions(p, "http://hl7.org/fhir/StructureDefinition/alternate-code-use", "http://hl7.org/fhir/StructureDefinition/alternate-code-status");
        }
      }
      for (ConceptDefinitionComponent t : fdef.getConcept()) {
        mergeSupplements(ret, t, supplements);
      }      
    }
  }

  private static PropertyType propertyTypeForType(DataType value) {
    if (value == null) {
      return PropertyType.NULL;
    }
    if (value instanceof CodeType) {
      return PropertyType.CODE;
    }
    if (value instanceof CodeType) {
      return PropertyType.CODING;
    }
    if (value instanceof CodeType) {
      return PropertyType.STRING;
    }
    if (value instanceof CodeType) {
      return PropertyType.INTEGER;
    }
    if (value instanceof CodeType) {
      return PropertyType.BOOLEAN;
    }
    if (value instanceof CodeType) {
      return PropertyType.DATETIME;
    }
    if (value instanceof CodeType) {
      return PropertyType.DECIMAL;
    }
    throw new FHIRException("Unsupported property value for a CodeSystem Property: "+value.fhirType());
  }

  private static String defineProperty(CodeSystem cs, PropertyComponent pd, PropertyType pt) {
    for (PropertyComponent p : cs.getProperty()) {
      if (p.hasCode() && p.getCode().equals(pd.getCode())) {
        if (!p.getUri().equals(pd.getUri())) {
          throw new Error("URI mismatch for code "+pd.getCode()+" url = "+p.getUri()+" vs "+pd.getUri());
        }
        if (!p.getType().equals(pt)) {
          throw new Error("Type mismatch for code "+pd.getCode()+" type = "+p.getType().toCode()+" vs "+pt.toCode());
        }
        return pd.getCode();
      }
    }
    cs.addProperty().setCode(pd.getCode()).setUri(pd.getUri()).setType(pt);
    return pd.getCode();

  }


  private static PropertyComponent getPropertyDefinition(CodeSystem cs, ConceptPropertyComponent p) {
    for (PropertyComponent t : cs.getProperty()) {
      if (t.hasCode() && t.getCode().equals(p.getCode())) {
        return t;
      }
    }
    return null;
  }

  public static boolean hasProperties(CodeSystem cs) {
    return hasProperties(cs.getConcept());
  }

  private static boolean hasProperties(List<ConceptDefinitionComponent> list) {
    for (ConceptDefinitionComponent c : list) {
      if (c.hasProperty() || hasProperties(c.getConcept())) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasDesignations(CodeSystem cs) {
    return hasDesignations(cs.getConcept());
  }

  private static boolean hasDesignations(List<ConceptDefinitionComponent> list) {
    for (ConceptDefinitionComponent c : list) {
      if (c.hasDesignation() || hasDesignations(c.getConcept())) {
        return true;
      }
    }
    return false;
  }

  public static boolean hasPropertyDef(CodeSystem cs, String property) {
    
    for (PropertyComponent pd : cs.getProperty()) {
      if (pd.hasCode() && pd.getCode().equals(property)) {
        return true;
      }
    }
    return false;
  }

  public static DataType getProperty(CodeSystem cs, String code, String property) {
    ConceptDefinitionComponent def = getCode(cs, code);
    return getProperty(cs, def, property);
  }
  
  public static DataType getProperty(CodeSystem cs, ConceptDefinitionComponent def, String property) {
    PropertyComponent defn = getPropertyDefinition(cs, property);
    if (defn != null) {
      property = defn.getCode();
    }
    ConceptPropertyComponent cp = getProperty(def, property);
    return cp == null ? null : cp.getValue();
  }

  public static boolean hasMarkdownInDefinitions(CodeSystem cs, MarkDownProcessor md) {
    return hasMarkdownInDefinitions(cs.getConcept(), md);
  }

  private static boolean hasMarkdownInDefinitions(List<ConceptDefinitionComponent> concepts, MarkDownProcessor md) {
    for (ConceptDefinitionComponent c : concepts) {
      if (c.hasDefinition() && md.isProbablyMarkdown(c.getDefinition(), true)) {
        return true;
      }
      if (c.hasConcept() && hasMarkdownInDefinitions(c.getConcept(), md)) {
        return true;
      }
    }
    return false;
  }

  public static String getStatus(CodeSystem cs, ConceptDefinitionComponent cc) {
    StandardsStatus ss = ExtensionUtilities.getStandardsStatus(cc);
    if (ss == StandardsStatus.DEPRECATED || ss == StandardsStatus.WITHDRAWN) {
      return ss.toCode();
    }
    DataType v = getProperty(cs, cc, "status");
    if (v == null || !v.isPrimitive()) {
      return null;
    } else {
      return v.primitiveValue();
    }
  }

  public static Boolean subsumes(CodeSystem cs, String pc, String cc) {
    if (pc.equals(cc)) {
      return true;
    }
    List<ConceptDefinitionComponent> child = findCodeWithParents(null, cs.getConcept(), cc);
    for (ConceptDefinitionComponent item : child) {
      if (pc.equals(item.getCode())) {
        return true;
      }
    }
    return false;
  }

  public static Set<String> codes(CodeSystem cs) {
    Set<String> res = new HashSet<>();
    addCodes(res, cs.getConcept());
    return res;
  }

  private static void addCodes(Set<String> res, List<ConceptDefinitionComponent> list) {
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasCode()) {
        res.add(cd.getCode());
      }
      if (cd.hasConcept()) {
        addCodes(res, cd.getConcept());
      }
    }    
  }
  
  /**
   * property in this case is the name of a property that appears in a ValueSet filter 
   * 
   * @param cs
   * @param property
   * @return
   */
  public static PropertyComponent getPropertyDefinition(CodeSystem cs, String property) {
    String uri = getStandardPropertyUri(property);
    if (uri != null) {
      for (PropertyComponent cp : cs.getProperty()) {
        if (uri.equals(cp.getUri())) {
          return cp;
        }
      }
    }
    for (PropertyComponent cp : cs.getProperty()) {
      if (cp.getCode().equals(property)) {
        return cp;
      }
    }
    return null;
  }

  public static boolean isDefinedProperty(CodeSystem cs, String property) {
    String uri = getStandardPropertyUri(property);
    if (uri != null) {
      for (PropertyComponent cp : cs.getProperty()) {
        if (uri.equals(cp.getUri())) {
          return true;
        }
      }
    }
    for (PropertyComponent cp : cs.getProperty()) {
      if (cp.getCode().equals(property) && (uri == null || !cp.hasUri())) { // if uri is right, will return from above
        return true;
      }
    }
    return false;
  }
  

  private static String getStandardPropertyUri(String property) {
    switch (property) {
    case "status" : return "http://hl7.org/fhir/concept-properties#status";
    case "inactive" : return "http://hl7.org/fhir/concept-properties#inactive";
    case "effectiveDate" : return "http://hl7.org/fhir/concept-properties#effectiveDate";
    case "deprecationDate" : return "http://hl7.org/fhir/concept-properties#deprecationDate";
    case "retirementDate" : return "http://hl7.org/fhir/concept-properties#retirementDate";
    case "notSelectable" : return "http://hl7.org/fhir/concept-properties#notSelectable";
    case "parent" : return "http://hl7.org/fhir/concept-properties#parent";
    case "child" : return "http://hl7.org/fhir/concept-properties#child";
    case "partOf" : return "http://hl7.org/fhir/concept-properties#partOf";
    case "synonym" : return "http://hl7.org/fhir/concept-properties#synonym";
    case "comment" : return "http://hl7.org/fhir/concept-properties#comment";
    case "itemWeight" : return "http://hl7.org/fhir/concept-properties#itemWeight";        
    }
    return null;
  }

  public static boolean isExemptFromMultipleVersionChecking(String url) {
    return Utilities.existsInList(url, "http://snomed.info/sct", "http://loinc.org");
  }

  public static PropertyComponent getPropertyByUri(CodeSystem cs, String uri) {
    for (PropertyComponent t : cs.getProperty()) {
      if (uri.equals(t.getUri())) {
        return t;
      }
    }
    return null;
  }

  public static CodeSystem convertSD(StructureDefinition sd) {
    CodeSystem cs = new CodeSystem();
    cs.setId(sd.getId());
    cs.setUrl(sd.getUrl());
    cs.setVersion(sd.getVersion());
    cs.setStatus(sd.getStatus());
    cs.setContent(Enumerations.CodeSystemContentMode.COMPLETE);
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      ConceptDefinitionComponent cd = cs.addConcept();
      cd.setCode(ed.getId());
      cd.setDisplay(ed.getId());
      ed.setDefinition(ed.getDefinition());
    }
    return cs;
  }

}

