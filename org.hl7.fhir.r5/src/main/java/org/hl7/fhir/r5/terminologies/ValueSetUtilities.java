package org.hl7.fhir.r5.terminologies;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.ConceptDefinitionComponentSorter;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.ConceptStatus;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache.SourcedValueSet;
import org.hl7.fhir.r5.utils.CanonicalResourceUtilities;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.NaturalOrderComparator;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

@Slf4j
public class ValueSetUtilities extends TerminologyUtilities {

  public static class ValueSetSorter implements Comparator<ValueSet> {

    @Override
    public int compare(ValueSet o1, ValueSet o2) {
      String url1 = o1.getUrl();
      String url2 = o2.getUrl();
      int c = compareString(url1, url2);
      if (c == 0) {
        String ver1 = o1.getVersion();
        String ver2 = o2.getVersion();
        c = compareVersions(ver1, ver2);
        if (c == 0) {
          String d1 = o1.getDateElement().asStringValue();
          String d2 = o2.getDateElement().asStringValue();
          c = compareString(url1, url2);
        }
      }
      return c;
    }

    private int compareVersions(String v1, String v2) {
      if (v1 == null && v2 == null) {
        return 0;
      } else if (v1 == null) {
        return -1; // this order is deliberate
      } else if (v2 == null) {
        return 1;
      } else if (VersionUtilities.isSemVer(v1) && VersionUtilities.isSemVer(v2)) {
        return VersionUtilities.compareVersions(v1, v2);
      } else if (Utilities.isInteger(v1) && Utilities.isInteger(v2)) {
        return Integer.compare(Integer.parseInt(v1), Integer.parseInt(v2));
      } else {
        return new NaturalOrderComparator<String>().compare(v1, v2);
      }
    }

    private int compareString(String s1, String s2) {
      if (s1 == null) {
        return s2 == null ? 0 : 1;
      } else {
        return s1.compareTo(s2);
      }
    }

  }

  public static boolean isServerSide(String url) {
    // this is required to work around placeholders or bad definitions in THO (cvx)
    return Utilities.existsInList(url,
      "http://hl7.org/fhir/sid/cvx",
      "http://loinc.org",
      "http://snomed.info/sct",
      "http://www.nlm.nih.gov/research/umls/rxnorm",
      "http://www.ama-assn.org/go/cpt",
      "http://hl7.org/fhir/ndfrt",
      "http://hl7.org/fhir/sid/ndc", 
      "http://hl7.org/fhir/sid/icd-10",
      "http://hl7.org/fhir/sid/icd-9-cm",
      "http://hl7.org/fhir/sid/icd-10-cm");
  }

  public static boolean isServerSide(Coding c) {
    return isServerSide(c.getSystem());
  }

  public static boolean hasServerSide(CodeableConcept cc) {
    for (Coding c : cc.getCoding()) {
      if (isServerSide(c)) {
        return true;
      }
    }
    return false;
  }

  public static ValueSet makeShareable(ValueSet vs, boolean extension) {
    if (!vs.hasExperimental()) {
      vs.setExperimental(false);
    }
    if (extension) {
      if (!vs.hasMeta())
        vs.setMeta(new Meta());
      for (UriType t : vs.getMeta().getProfile())
        if (t.getValue().equals("http://hl7.org/fhir/StructureDefinition/shareablevalueset"))
          return vs;
      vs.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareablevalueset"));
    }
    return vs;
  }


  public static void checkShareable(ValueSet vs) {
    if (!vs.hasMeta())
      throw new Error("ValueSet "+vs.getUrl()+" is not shareable");
    for (UriType t : vs.getMeta().getProfile()) {
      if (t.getValue().equals("http://hl7.org/fhir/StructureDefinition/shareablevalueset"))
        return;
    }
    throw new Error("ValueSet "+vs.getUrl()+" is not shareable");    
  }

  public static boolean hasOID(ValueSet vs) {
    return getOID(vs) != null;
  }

  public static String getOID(ValueSet vs) {
    for (Identifier id : vs.getIdentifier()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:"))
        return id.getValue().substring(8);
    }
    return null;
  }

  public static void setOID(ValueSet vs, String oid) {
    if (!oid.startsWith("urn:oid:"))
      oid = "urn:oid:" + oid;
    for (Identifier id : vs.getIdentifier()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:")) {
        id.setValue(oid);
        return;
      }
    }
    vs.addIdentifier().setSystem("urn:ietf:rfc:3986").setValue(oid);
  }

  public static void markStatus(ValueSet vs, String wg, StandardsStatus status, String fmm, IWorkerContext context, String normativeVersion) throws FHIRException {
    if (vs.hasUserData(UserDataNames.render_external_link))
      return;
    
    if (wg != null) {
      if (!ExtensionUtilities.hasExtension(vs, ExtensionDefinitions.EXT_WORKGROUP) ||
          (!Utilities.existsInList(ExtensionUtilities.readStringExtension(vs, ExtensionDefinitions.EXT_WORKGROUP), "fhir", "vocab") && Utilities.existsInList(wg, "fhir", "vocab"))) {
        CanonicalResourceUtilities.setHl7WG(vs, wg);
      }
    }
    if (status != null) {
      StandardsStatus ss = ExtensionUtilities.getStandardsStatus(vs);
      if (ss == null || ss.isLowerThan(status)) 
        ExtensionUtilities.setStandardsStatus(vs, status, normativeVersion);
      if (status == StandardsStatus.NORMATIVE) {
        vs.setStatus(PublicationStatus.ACTIVE);
      }
    }
    if (fmm != null) {
      String sfmm = ExtensionUtilities.readStringExtension(vs, ExtensionDefinitions.EXT_FMM_LEVEL);
      if (Utilities.noString(sfmm) || Integer.parseInt(sfmm) < Integer.parseInt(fmm))  {
        ExtensionUtilities.setIntegerExtension(vs, ExtensionDefinitions.EXT_FMM_LEVEL, Integer.parseInt(fmm));
      }
    }
    if (vs.hasUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM))
      CodeSystemUtilities.markStatus((CodeSystem) vs.getUserData(UserDataNames.TX_ASSOCIATED_CODESYSTEM), wg, status, fmm, normativeVersion);
    else if (status == StandardsStatus.NORMATIVE && context != null) {
      for (ConceptSetComponent csc : vs.getCompose().getInclude()) {
        if (csc.hasSystem()) {
          CodeSystem cs = context.fetchCodeSystem(csc.getSystem());
          if (cs != null) {
            CodeSystemUtilities.markStatus(cs, wg, status, fmm, normativeVersion);
          }
        }
      }
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


  public static class ConceptReferenceComponentSorter implements Comparator<ConceptReferenceComponent> {

    @Override
    public int compare(ConceptReferenceComponent o1, ConceptReferenceComponent o2) {
      return o1.getCode().compareToIgnoreCase(o2.getCode());
    }
  }


  public static void sortInclude(ConceptSetComponent inc) {
    Collections.sort(inc.getConcept(), new ConceptReferenceComponentSorter());
  }

  public static String getAllCodesSystem(ValueSet vs) {
    if (vs.hasCompose()) {
      ValueSetComposeComponent c = vs.getCompose();
      if (c.getExclude().isEmpty() && c.getInclude().size() == 1) {
        ConceptSetComponent i = c.getIncludeFirstRep();
        if (i.hasSystem() && !i.hasValueSet() && !i.hasConcept() && !i.hasFilter()) {
          return i.getSystem();
        }
      }
    }
    return null;
  }

  public static boolean isDeprecated(ValueSet vs, ValueSetExpansionContainsComponent c) {
    try {
      for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent p : c.getProperty()) {
        if ("status".equals(p.getCode()) && p.hasValue() && p.hasValueCodeType() && "deprecated".equals(p.getValueCodeType().getCode())) {
          return true;
        }      
        // this, though status should also be set
        if ("deprecationDate".equals(p.getCode()) && p.hasValue() && p.getValue() instanceof DateTimeType) 
          return ((DateTimeType) p.getValue()).before(new DateTimeType(Calendar.getInstance()));
        // legacy  
        if ("deprecated".equals(p.getCode()) && p.hasValue() && p.getValue() instanceof BooleanType) 
          return ((BooleanType) p.getValue()).getValue();
      }
      StandardsStatus ss = ExtensionUtilities.getStandardsStatus(c);
      if (ss == StandardsStatus.DEPRECATED) {
        return true;
      }
      return false;
    } catch (FHIRException e) {
      return false;
    }  
  }

  public static boolean hasCodeInExpansion(ValueSet vs, Coding code) {
    return hasCodeInExpansion(vs.getExpansion().getContains(), code);
  }

  private static boolean hasCodeInExpansion(List<ValueSetExpansionContainsComponent> list, Coding code) {
    for (ValueSetExpansionContainsComponent c : list) {
      if (c.getSystem().equals(code.getSystem()) && c.getCode().equals(code.getCode())) {
        return true;
      }
      if (hasCodeInExpansion(c.getContains(), code)) {
        return true;
      }
    }
    return false;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent addCodeProperty(ValueSet vs, ValueSetExpansionContainsComponent ctxt, String url, String code, String value) {
    if (value != null) {
      return addProperty(vs, ctxt, url, code, new CodeType(value));
    } else {
      return null;
    }
  }
  public static org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent addProperty(ValueSet vs, ValueSetExpansionContainsComponent ctxt, String url, String code, String value) {
    if (value != null) {
      return addProperty(vs, ctxt, url, code, new StringType(value));
    } else {
      return null;
    }
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent addProperty(ValueSet vs, ValueSetExpansionContainsComponent ctxt, String url, String code, Integer value) {
    if (value != null) {
      return addProperty(vs, ctxt, url, code, new IntegerType(value));
    } else {
      return null;
    }
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent addProperty(ValueSet vs, ValueSetExpansionContainsComponent ctxt, String url, String code, DataType value) {
    code = defineProperty(vs, url, code);
    org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent p = getProperty(ctxt.getProperty(),  code);
    if (p != null) {
      p.setValue(value);
    } else {
      p = ctxt.addProperty().setCode(code).setValue(value);
    }
    return p;
  }

  private static org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent getProperty(List<org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent> list, String code) {
    for (org.hl7.fhir.r5.model.ValueSet.ConceptPropertyComponent t : list) {
      if (code.equals(t.getCode())) {
        return t;
      }
    }
    return null;
  }

  private static String defineProperty(ValueSet vs, String url, String code) {
    for (ValueSetExpansionPropertyComponent p : vs.getExpansion().getProperty()) {
      if (p.hasUri() && p.getUri().equals(url)) {
        return p.getCode();
      }
    }
    for (ValueSetExpansionPropertyComponent p : vs.getExpansion().getProperty()) {
      if (p.hasCode() && p.getCode().equals(code)) {
        p.setUri(url);
        return code;
      }
    }
    ValueSetExpansionPropertyComponent p = vs.getExpansion().addProperty();
    p.setUri(url);
    p.setCode(code);
    return code;  
  }

  public static int countExpansion(ValueSet valueset) {
    int i = valueset.getExpansion().getContains().size();
    for (ValueSetExpansionContainsComponent t : valueset.getExpansion().getContains()) {
      i = i + countExpansion(t);
    }
    return i;
  }

  public static int countExpansion(List<ValueSetExpansionContainsComponent> list) {
    int i = list.size();
    for (ValueSetExpansionContainsComponent t : list) {
      i = i + countExpansion(t);
    }
    return i;
  }

  private static int countExpansion(ValueSetExpansionContainsComponent c) {
    int i = c.getContains().size();
    for (ValueSetExpansionContainsComponent t : c.getContains()) {
      i = i + countExpansion(t);
    }
    return i;
  }

  public static Set<String> listSystems(IWorkerContext ctxt, ValueSet vs) {
    Set<String> systems = new HashSet<>();
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      for (CanonicalType ct : inc.getValueSet()) {
        ValueSet vsr = ctxt.findTxResource(ValueSet.class, ct.asStringValue(), null, vs);
        if (vsr != null) {
          systems.addAll(listSystems(ctxt, vsr));
        }
      }
      if (inc.hasSystem()) {
        systems.add(inc.getSystem());
      }
    }
    return systems;
  }
  

  public static boolean isIncompleteExpansion(ValueSet valueSet) {
    if (valueSet.hasExpansion()) {
      ValueSetExpansionComponent exp = valueSet.getExpansion();
      if (exp.hasTotal()) {
        if (exp.getTotal() != countExpansion(exp.getContains())) {
          return true;
        }
      }
    }
    return false;
  }


  public static Set<String> codes(ValueSet vs, CodeSystem cs) {
    Set<String> res = new HashSet<>();
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      if (inc.getSystem().equals(cs.getUrl())) {
        addCodes(res, inc, cs.getConcept());
      }
    }
    return res;
  }

  private static void addCodes(Set<String> res, ConceptSetComponent inc, List<ConceptDefinitionComponent> list) {
    for (ConceptDefinitionComponent cd : list) {
      if (cd.hasCode() && (!inc.hasConcept() || inc.hasConcept(cd.getCode()))) {
        res.add(cd.getCode());
      }
      if (cd.hasConcept()) {
        addCodes(res, inc, cd.getConcept());
      }
    }    
  }
  
  public static String versionFromExpansionParams(Parameters expParameters, String system, String defaultVersion) {
    if (expParameters != null) {
      for (ParametersParameterComponent p : expParameters.getParameter()) {
        if ("system-version".equals(p.getName()) || "force-system-version".equals(p.getName())) {
          String v = p.getValue().primitiveValue();
          if (v.startsWith(system+"|")) {
            String ver = v.substring(v.indexOf("|")+1);
            if (defaultVersion == null || ver.startsWith(defaultVersion) || "force-system-version".equals(p.getName())) {
              return ver;
            }
          }
        }
      }
    }
    return defaultVersion;
  }

  public static Set<String> checkExpansionSubset(ValueSet vs1, ValueSet vs2) {
    Set<String> codes = new HashSet<>();
    checkCodes(codes, vs2.getExpansion().getContains(), vs1.getExpansion().getContains());
    return codes;
  }

  private static void checkCodes(Set<String> codes, List<ValueSetExpansionContainsComponent> listS, List<ValueSetExpansionContainsComponent> listT) {
    for (ValueSetExpansionContainsComponent c : listS) {
      ValueSetExpansionContainsComponent t = findContained(c, listT);
      if (t == null) {
        codes.add(c.getCode());
      }
      if (c.hasContains()) {
        checkCodes(codes, c.getContains(), listT);
      }
    }
  }

  private static ValueSetExpansionContainsComponent findContained(ValueSetExpansionContainsComponent c, List<ValueSetExpansionContainsComponent> listT) {
    for (ValueSetExpansionContainsComponent t : listT) {
      if (t.getSystem().equals(c.getSystem()) && t.getCode().equals(c.getCode())) {
        return t;
      }
      if (t.hasContains()) {
        ValueSetExpansionContainsComponent tt = findContained(c, t.getContains());
        if (tt != null) {
          return tt;
        }
      }
    }
    return null;
  }

  public static void setDeprecated(List<ValueSet.ValueSetExpansionPropertyComponent> vsProp, ValueSet.ValueSetExpansionContainsComponent n) {
    if (!"deprecated".equals(ValueSetUtilities.getStatus(vsProp, n))) {
      n.addProperty().setCode("status").setValue(new CodeType("deprecated"));
      for (ValueSet.ValueSetExpansionPropertyComponent o : vsProp) {
        if ("status".equals(o.getCode())) {
          return;
        }
      }
      vsProp.add(new ValueSet.ValueSetExpansionPropertyComponent().setCode("status").setUri("http://hl7.org/fhir/concept-properties#status"));
    }
  }

  private static String getStatus(List<ValueSetExpansionPropertyComponent> vsProp, ValueSetExpansionContainsComponent n) {
    return ValueSetUtilities.getProperty(vsProp, n, "status", "http://hl7.org/fhir/concept-properties#status");
  }


  public static String getProperty(List<ValueSetExpansionPropertyComponent> vsProp, ValueSetExpansionContainsComponent focus, String code, String url) {
    ValueSet.ValueSetExpansionPropertyComponent pc = null;
    for (ValueSet.ValueSetExpansionPropertyComponent t : vsProp) {
      if (t.hasUri() && t.getUri().equals(url)) {
        pc = t;
      }
    }
    if (pc == null) {
      for (ValueSet.ValueSetExpansionPropertyComponent t : vsProp) {
        if (t.hasCode() && t.getCode().equals(code)) {
          pc = t;
        }
      }
    }
    if (pc != null) {
      for (ValueSet.ConceptPropertyComponent t : focus.getProperty()) {
        if (t.hasCode() && t.getCode().equals(pc.getCode())) {
          return t.getValue().primitiveValue();
        }
      }
    }
    return null;
  }


}