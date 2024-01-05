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


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.ConceptDefinitionComponentSorter;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities.ConceptStatus;
import org.hl7.fhir.r5.utils.CanonicalResourceUtilities;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;

public class ValueSetUtilities extends TerminologyUtilities {


  public static boolean isServerSide(String url) {
    return Utilities.existsInList(url, "http://hl7.org/fhir/sid/cvx");
  }
  
  public static ValueSet makeShareable(ValueSet vs) {
    if (!vs.hasExperimental()) {
      vs.setExperimental(false);
    }
    if (!vs.hasMeta())
      vs.setMeta(new Meta());
    for (UriType t : vs.getMeta().getProfile()) 
      if (t.getValue().equals("http://hl7.org/fhir/StructureDefinition/shareablevalueset"))
        return vs;
    vs.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareablevalueset"));
    return vs;
  }

  public static boolean makeVSShareable(ValueSet vs) {
    if (!vs.hasMeta())
      vs.setMeta(new Meta());
    for (UriType t : vs.getMeta().getProfile()) 
      if (t.getValue().equals("http://hl7.org/fhir/StructureDefinition/shareablevalueset"))
        return false;
    vs.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareablevalueset"));
    return true;
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

  public static void markStatus(ValueSet vs, String wg, StandardsStatus status, String pckage, String fmm, IWorkerContext context, String normativeVersion) throws FHIRException {
    if (vs.hasUserData("external.url"))
      return;
    
    if (wg != null) {
      if (!ToolingExtensions.hasExtension(vs, ToolingExtensions.EXT_WORKGROUP) || 
          (!Utilities.existsInList(ToolingExtensions.readStringExtension(vs, ToolingExtensions.EXT_WORKGROUP), "fhir", "vocab") && Utilities.existsInList(wg, "fhir", "vocab"))) {
        CanonicalResourceUtilities.setHl7WG(vs, wg);
      }
    }
    if (status != null) {
      StandardsStatus ss = ToolingExtensions.getStandardsStatus(vs);
      if (ss == null || ss.isLowerThan(status)) 
        ToolingExtensions.setStandardsStatus(vs, status, normativeVersion);
      if (pckage != null) {
        if (!vs.hasUserData("ballot.package"))        
          vs.setUserData("ballot.package", pckage);
        else if (!pckage.equals(vs.getUserString("ballot.package")))
          if (!"infrastructure".equals(vs.getUserString("ballot.package")))
          System.out.println("Value Set "+vs.getUrl()+": ownership clash "+pckage+" vs "+vs.getUserString("ballot.package"));
      }
      if (status == StandardsStatus.NORMATIVE) {
        vs.setExperimental(false);
        vs.setStatus(PublicationStatus.ACTIVE);
      }
    }
    if (fmm != null) {
      String sfmm = ToolingExtensions.readStringExtension(vs, ToolingExtensions.EXT_FMM_LEVEL);
      if (Utilities.noString(sfmm) || Integer.parseInt(sfmm) < Integer.parseInt(fmm))  {
        ToolingExtensions.setIntegerExtension(vs, ToolingExtensions.EXT_FMM_LEVEL, Integer.parseInt(fmm));
      }
      if (Integer.parseInt(fmm) <= 1) {
        vs.setExperimental(true);
      }
    }
    if (vs.hasUserData("cs"))
      CodeSystemUtilities.markStatus((CodeSystem) vs.getUserData("cs"), wg, status, pckage, fmm, normativeVersion);
    else if (status == StandardsStatus.NORMATIVE && context != null) {
      for (ConceptSetComponent csc : vs.getCompose().getInclude()) {
        if (csc.hasSystem()) {
          CodeSystem cs = context.fetchCodeSystem(csc.getSystem());
          if (cs != null) {
            CodeSystemUtilities.markStatus(cs, wg, status, pckage, fmm, normativeVersion);
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

  public static ValueSet generateImplicitValueSet(String uri) {
    if (uri.startsWith("http://snomed.info/sct"))
      return generateImplicitSnomedValueSet(uri);
    if (uri.startsWith("http://loinc.org/vs"))
      return generateImplicitLoincValueSet(uri);
    if (uri.equals("http://hl7.org/fhir/ValueSet/mimetypes")) {
      return generateImplicitMimetypesValueSet(uri);
    }
    return null;
  }

  private static ValueSet generateImplicitMimetypesValueSet(String theUri) {
    ValueSet valueSet = new ValueSet();
    valueSet.setStatus(PublicationStatus.ACTIVE);
    valueSet.setUrl(theUri);
    valueSet.setDescription("This value set includes all possible codes from BCP-13 (http://tools.ietf.org/html/bcp13)");
    valueSet.getCompose()
      .addInclude().setSystem("urn:ietf:bcp:13");
    return valueSet;
  }

  private static ValueSet generateImplicitLoincValueSet(String uri) {
    if ("http://loinc.org/vs".equals(uri))
      return makeLoincValueSet();
    if (uri.startsWith("http://loinc.org/vs/LL"))
      return makeAnswerList(makeLoincValueSet(), uri);
    return null;
  }

  private static ValueSet makeAnswerList(ValueSet vs, String uri) {
    vs.setUrl(uri);
    String c = uri.substring(20);
    vs.setName("LOINCAnswers"+c);
    vs.setTitle("LOINC Answer Codes for "+c);
    vs.getCompose().getIncludeFirstRep().addFilter().setProperty("LIST").setOp(FilterOperator.EQUAL).setValue(c);
    return vs;
  }

  private static ValueSet makeLoincValueSet() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://loinc.org/vs");
    vs.setName("LOINCCodes");
    vs.setTitle("All LOINC codes");
    vs.setCopyright("This content LOINC® is copyright © 1995 Regenstrief Institute, Inc. and the LOINC Committee, and available at no cost under the license at http://loinc.org/terms-of-use");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem("http://loinc.org");
    return vs;
  }

  private static ValueSet generateImplicitSnomedValueSet(String uri) {
    if ("http://snomed.info/sct?fhir_vs".equals(uri))
      return makeImplicitSnomedValueSet(uri);
    return null;
  }

  private static ValueSet makeImplicitSnomedValueSet(String uri) {
    ValueSet vs = new ValueSet();
    vs.setUrl(uri);
    vs.setName("SCTValueSet");
    vs.setTitle("SCT ValueSet");
    vs.setDescription("All SNOMED CT Concepts");
    vs.setCopyright("This value set includes content from SNOMED CT, which is copyright © 2002+ International Health Terminology Standards Development Organisation (SNOMED International), and distributed by agreement between SNOMED International and HL7. Implementer use of SNOMED CT is not covered by this agreement");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem("http://snomed.info/sct");
    return vs;
  }

  public static void setDeprecated(List<ValueSetExpansionPropertyComponent> vsProp,  ValueSetExpansionContainsComponent n) {
    n.addProperty().setCode("status").setValue(new CodeType("deprecated"));
    for (ValueSetExpansionPropertyComponent o : vsProp) {
      if ("status".equals(o.getCode())) {
        return;
      }
    }
    vsProp.add(new ValueSetExpansionPropertyComponent().setCode("status").setUri("http://hl7.org/fhir/concept-properties#status"));
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
      StandardsStatus ss = ToolingExtensions.getStandardsStatus(c);
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
        ValueSet vsr = ctxt.fetchResource(ValueSet.class, ct.asStringValue(), vs);
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

}